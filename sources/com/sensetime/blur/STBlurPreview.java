package com.sensetime.blur;

import android.content.Context;
import android.graphics.Rect;
import android.util.Log;
import com.oppo.camera.aps.config.CameraConfig;
import com.oppo.camera.aps.config.ConfigDataBase;
import com.sensetime.faceapi.FaceTrack;
import com.sensetime.faceapi.FigureSegment;
import com.sensetime.faceapi.model.CvPixelFormat;
import com.sensetime.faceapi.model.FaceConfig;
import com.sensetime.faceapi.model.FaceInfo;
import com.sensetime.faceapi.model.FaceOrientation;
import com.sensetime.faceapi.utils.AccelerometerManager;
import com.sensetime.faceapi.utils.FaceRotationUtil;
import com.sensetime.utils.OpenGLUtils;
import com.sensetime.utils.ShakeDetectorUtils;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class STBlurPreview implements ShakeDetectorUtils.OnShakeListener {
    /* access modifiers changed from: private */
    public static boolean DEBUG = false;
    private static final int RESIZE_RATIO = 4;
    private static final int SEGMENT_LENGTH = 240;
    public static final int ST_BLUR_PARAM_TYPE_LEVEL = 4097;
    public static final int ST_BLUR_PARAM_TYPE_MASK_EROSION_VALUE = 4101;
    public static final int ST_BLUR_PARAM_TYPE_MASK_MIN_AREA_SIZE = 4100;
    public static final int ST_BLUR_PARAM_TYPE_RECT_HEIGHT_SCALE = 4099;
    public static final int ST_BLUR_PARAM_TYPE_RECT_WIDTH_SCALE = 4098;
    public static final int ST_BUFFER_ERROR = -4;
    public static final int ST_INTERNAL_ERROR = -6;
    public static final int ST_OK = 0;
    public static final int ST_PARAM_ERROR = -1;
    public static final int ST_PROGRAM_ERROR = -3;
    public static final int ST_SHADER_ERROR = -2;
    public static final int ST_TEXTURE_ERROR = -5;
    private static final String TAG = "STBlurPreview";
    private long PROCESS_LIFE_CYCLE_TIME;
    private long RESET_MASK_CYCLE_TIME;
    long debugSegCount;
    long debugSegSumTime;
    private int[] m2dTextureIds;
    private Context mContext;
    private int mCur2dTextureIdx;
    private int mFaceCount;
    private int mFrameNum;
    /* access modifiers changed from: private */
    public boolean mFrontCamera;
    private boolean mInitialized;
    private int mLast2dTextureId;
    private int mLastMaskTextureId;
    private long mLastProcessTime;
    /* access modifiers changed from: private */
    public int mPreviewHeight;
    /* access modifiers changed from: private */
    public int mPreviewWidth;
    private ProcessThread mProcessThread;
    private boolean mResetMask;
    private long mResetMaskTime;
    private int mResizedTextureId;
    /* access modifiers changed from: private */
    public FigureSegment mSegment;
    private byte[] mSegmentBuffer;
    private int mSegmentBufferHeight;
    private int mSegmentBufferWidth;
    /* access modifiers changed from: private */
    public String mSegmentModel;
    private final Object mSegmentObject;
    private int mSegmentOption;
    private ByteBuffer mSegmentOutBuffer;
    /* access modifiers changed from: private */
    public int[] mSegmentOutBufferInfo;
    /* access modifiers changed from: private */
    public SegmentThread mSegmentThread;
    private final Object mSyncObject;
    private Rect[] mTmpFaceRects;
    private float[] mTmpYaws;
    /* access modifiers changed from: private */
    public FaceTrack mTrack;
    /* access modifiers changed from: private */
    public boolean mUseSegment;
    private boolean mbRetentionOpen;
    private boolean mbSetDefaultParam;
    /* access modifiers changed from: private */
    public boolean needDestroySegTextures;

    public interface Callback {
        void onResult(boolean z, byte[] bArr, FaceInfo[] faceInfoArr);
    }

    public STBlurPreview(Context context) {
        this(context, true);
    }

    public STBlurPreview(Context context, boolean z) {
        this(context, z, (String) null, FaceConfig.FaceImageResize.RESIZE_320W, FaceConfig.TrackThreadCount.TWO_THREAD);
    }

    public STBlurPreview(Context context, boolean z, String str) {
        this(context, z, str, FaceConfig.FaceImageResize.RESIZE_320W, FaceConfig.TrackThreadCount.TWO_THREAD);
    }

    public STBlurPreview(Context context, boolean z, String str, FaceConfig.FaceImageResize faceImageResize, FaceConfig.TrackThreadCount trackThreadCount) {
        this.mSegmentOutBufferInfo = new int[2];
        this.mSegmentOption = 28;
        this.mFrontCamera = true;
        this.mSyncObject = new Object();
        this.mSegmentObject = new Object();
        this.PROCESS_LIFE_CYCLE_TIME = 3000;
        this.mResetMask = false;
        this.RESET_MASK_CYCLE_TIME = 300;
        this.mFaceCount = 0;
        this.mSegmentThread = null;
        this.needDestroySegTextures = false;
        this.mbSetDefaultParam = false;
        this.mCur2dTextureIdx = 0;
        this.m2dTextureIds = new int[]{-1, -1, -1, -1, -1};
        this.mLast2dTextureId = -1;
        this.mLastMaskTextureId = -1;
        this.mResizedTextureId = -1;
        this.mbRetentionOpen = false;
        this.debugSegSumTime = 0;
        this.debugSegCount = 0;
        if (this.mInitialized) {
            destroy();
        }
        this.mUseSegment = z;
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_PORTRAIT_RETENTION_SUPPORT)) {
            this.mSegmentThread = new SegmentThread();
        }
        final boolean z2 = z;
        final String str2 = str;
        final FaceConfig.FaceImageResize faceImageResize2 = faceImageResize;
        final FaceConfig.TrackThreadCount trackThreadCount2 = trackThreadCount;
        new Thread(new Runnable() {
            public void run() {
                if (z2) {
                    FigureSegment unused = STBlurPreview.this.mSegment = FigureSegment.getInstance(str2, faceImageResize2);
                    String unused2 = STBlurPreview.this.mSegmentModel = str2;
                } else {
                    FaceTrack unused3 = STBlurPreview.this.mTrack = new FaceTrack(faceImageResize2, FaceConfig.FaceKeyPointCount.POINT_COUNT_21, trackThreadCount2);
                }
                if (STBlurPreview.this.mSegmentThread != null) {
                    STBlurPreview.this.mSegmentThread.start();
                }
            }
        }).start();
        ShakeDetectorUtils.getInstance(context).registerOnShakeListener(this).start();
        AccelerometerManager.start(context);
        this.mInitialized = true;
        this.mContext = context;
    }

    public int destroy() {
        ShakeDetectorUtils.getInstance(this.mContext).unregisterOnShakeListener(this).stop();
        AccelerometerManager.stop();
        if (DEBUG) {
            Log.d(TAG, "destroy");
        }
        ProcessThread processThread = this.mProcessThread;
        if (processThread != null) {
            processThread.release();
            try {
                this.mProcessThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (DEBUG) {
                Log.d(TAG, "destroy process thread join");
            }
            this.mProcessThread = null;
        }
        SegmentThread segmentThread = this.mSegmentThread;
        if (segmentThread != null) {
            segmentThread.release();
            try {
                this.mSegmentThread.join();
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
            if (DEBUG) {
                Log.d(TAG, "destroy segment thread join");
            }
            this.mSegmentThread = null;
        }
        FaceTrack faceTrack = this.mTrack;
        if (faceTrack != null) {
            faceTrack.release();
            this.mTrack = null;
        }
        FigureSegment figureSegment = this.mSegment;
        if (figureSegment != null) {
            figureSegment.release();
            this.mSegment = null;
        }
        this.mInitialized = false;
        return 0;
    }

    public int initRender(int i, int i2, boolean z) {
        this.mFrameNum = 0;
        int init = BlurFilterLibrary.init(i, i2);
        if (this.mSegmentModel == null) {
            setParam(4101, 0.3f);
            if (z) {
                setParam(4100, 0.15f);
            } else {
                setParam(4100, 0.01f);
            }
        } else {
            setParam(4101, 0.39f);
            if (z) {
                setParam(4100, 0.15f);
            } else {
                setParam(4100, 0.01f);
            }
        }
        if (z) {
            this.mSegmentOption = 28;
        } else {
            this.mSegmentOption = 24;
        }
        return init;
    }

    public int destroyRender() {
        this.needDestroySegTextures = false;
        destroyTextures();
        return BlurFilterLibrary.destroy();
    }

    public int processTexture(int i, int i2, int i3, int[] iArr, boolean z) {
        int i4;
        destroySegmentTextures();
        if (System.currentTimeMillis() - this.mLastProcessTime >= this.PROCESS_LIFE_CYCLE_TIME) {
            if (DEBUG) {
                Log.d(TAG, "processTexture mask beyond the life cycle!");
            }
            i4 = -1;
        } else if (this.mUseSegment) {
            i4 = getMaskTextureBySegment(z);
        } else {
            i4 = getMaskTextureByFace(z);
        }
        return BlurFilterLibrary.processTextureByMask(i, i4, i2, i3, this.mFrontCamera, iArr);
    }

    /* access modifiers changed from: private */
    public void setDefaultParamIfNeed(boolean z) {
        if (!this.mbSetDefaultParam || this.mFrontCamera != z) {
            if (DEBUG) {
                Log.i(TAG, "setDefaultParamIfNeed mFrontCamera = " + this.mFrontCamera + ", frontCamera = " + z);
            }
            if (z) {
                setParam(4101, 0.3f);
                setParam(4100, 0.15f);
                this.mSegmentOption = 28;
            } else {
                setParam(4101, 0.39f);
                setParam(4100, 0.11f);
                this.mSegmentOption = 24;
            }
            this.mbSetDefaultParam = true;
        }
    }

    public int processOESTexture(int i, int i2, int i3, int[] iArr, boolean z) {
        int i4;
        if (System.currentTimeMillis() - this.mLastProcessTime >= this.PROCESS_LIFE_CYCLE_TIME) {
            if (DEBUG) {
                Log.d(TAG, "processOESTexture mask beyond the life cycle!");
            }
            i4 = -1;
        } else if (this.mUseSegment) {
            i4 = getMaskTextureBySegment(z);
        } else {
            i4 = getMaskTextureByFace(z);
        }
        return BlurFilterLibrary.processOESTextureByMask(i, i4, i2, i3, this.mFrontCamera, iArr);
    }

    public int doOnPreviewProcess(int i, int i2, int i3, int i4, int i5, int i6, int[] iArr, boolean z, boolean z2) {
        int i7 = i4;
        int i8 = i5;
        if (this.needDestroySegTextures) {
            int processTextureByMask = BlurFilterLibrary.processTextureByMask(i, -2, -1, -1, z, iArr);
            destroySegmentTextures();
            return processTextureByMask;
        } else if (!this.mSegmentThread.active) {
            return BlurFilterLibrary.processTextureByMask(i, -2, -1, -1, z, iArr);
        } else {
            int[] iArr2 = {this.m2dTextureIds[this.mCur2dTextureIdx]};
            if (iArr2[0] <= 0) {
                iArr2[0] = OpenGLUtils.loadTexture((Buffer) null, i7, i8, -1);
            }
            BlurFilterLibrary.copy2DTexture(i, iArr2);
            int[] iArr3 = this.m2dTextureIds;
            int i9 = this.mCur2dTextureIdx;
            iArr3[i9] = iArr2[0];
            int i10 = i9 + 1;
            this.mCur2dTextureIdx = i10;
            this.mCur2dTextureIdx = i10 % iArr3.length;
            int i11 = i7 / 4;
            int i12 = i8 / 4;
            int[] iArr4 = this.mSegmentOutBufferInfo;
            if (iArr4[0] <= 0 || iArr4[1] <= 0 || iArr4[0] * i12 != iArr4[1] * i11) {
                FigureSegment figureSegment = this.mSegment;
                if (figureSegment == null) {
                    return -1;
                }
                figureSegment.createOutputBuffer(i11, i12, 240, this.mSegmentOutBufferInfo);
            }
            byte[] bArr = new byte[(i11 * i12 * 4)];
            if (this.mResizedTextureId <= 0) {
                this.mResizedTextureId = OpenGLUtils.loadTexture((Buffer) null, i11, i12, -1);
            }
            BlurFilterLibrary.ResizeTexture(iArr2[0], this.mResizedTextureId, i11, i12);
            OpenGLUtils.readPix(this.mResizedTextureId, i11, i12, bArr);
            if (!this.mSegmentThread.active) {
                return 0;
            }
            TextureInfo latestTextureInfo = this.mSegmentThread.getLatestTextureInfo();
            try {
                BlockingQueue access$600 = this.mSegmentThread.inQueue;
                SegmentData segmentData = r1;
                SegmentData segmentData2 = new SegmentData(iArr2[0], i4, i5, bArr, i11, i12, i6, z, z2);
                access$600.put(segmentData);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (!this.mSegmentThread.active) {
                return 0;
            }
            if (latestTextureInfo == null) {
                int i13 = this.mLast2dTextureId;
                if (i13 <= 0) {
                    return BlurFilterLibrary.processTextureByMask(i, -2, -1, -1, z, iArr);
                }
                return BlurFilterLibrary.processTextureByMask(i13, this.mLastMaskTextureId, i2, i3, z, iArr);
            }
            int maskTextureBySegment = getMaskTextureBySegment(latestTextureInfo.maskData, latestTextureInfo.maskWidth, latestTextureInfo.maskHeight, z2);
            this.mLast2dTextureId = latestTextureInfo.src2dTextureId;
            this.mLastMaskTextureId = maskTextureBySegment;
            return BlurFilterLibrary.processTextureByMask(latestTextureInfo.src2dTextureId, maskTextureBySegment, i2, i3, z, iArr);
        }
    }

    public int processTextureGradual(int i, int i2, int i3, float[] fArr, int[] iArr, boolean z) {
        int i4;
        if (System.currentTimeMillis() - this.mLastProcessTime >= this.PROCESS_LIFE_CYCLE_TIME) {
            if (DEBUG) {
                Log.d(TAG, "processOESTexture mask beyond the life cycle!");
            }
            i4 = -1;
        } else if (this.mUseSegment) {
            i4 = getMaskTextureBySegment(z);
        } else {
            i4 = getMaskTextureByFace(z);
        }
        return BlurFilterLibrary.processTexureByMaskGradual(i, i4, i2, i3, this.mFrontCamera, AccelerometerManager.getDegree(), fArr, iArr);
    }

    public int processOESTextureGradual(int i, int i2, int i3, float[] fArr, int[] iArr, boolean z) {
        int i4;
        if (System.currentTimeMillis() - this.mLastProcessTime >= this.PROCESS_LIFE_CYCLE_TIME) {
            if (DEBUG) {
                Log.d(TAG, "processOESTexture mask beyond the life cycle!");
            }
            i4 = -1;
        } else if (this.mUseSegment) {
            i4 = getMaskTextureBySegment(z);
        } else {
            i4 = getMaskTextureByFace(z);
        }
        return BlurFilterLibrary.processOESTexureByMaskGradual(i, i4, i2, i3, this.mFrontCamera, AccelerometerManager.getDegree(), fArr, iArr);
    }

    private int getMaskTextureBySegment(boolean z) {
        byte[] bArr;
        int i;
        int i2;
        if (this.mFaceCount <= 0) {
            if (DEBUG) {
                Log.i(TAG, "getMaskTextureBySegment: mFaceCount=" + this.mFaceCount);
            }
            return -1;
        }
        synchronized (this.mSyncObject) {
            bArr = this.mSegmentBuffer;
            i = this.mSegmentBufferWidth;
            i2 = this.mSegmentBufferHeight;
        }
        if (this.mResetMask && bArr != null) {
            for (int i3 = 0; i3 < bArr.length; i3++) {
                bArr[i3] = -1;
            }
            if (this.RESET_MASK_CYCLE_TIME < System.currentTimeMillis() - this.mResetMaskTime) {
                this.mResetMask = false;
            }
        }
        if (z || bArr == null) {
            return -1;
        }
        int[] iArr = new int[1];
        BlurFilterLibrary.processMaskBuffer(bArr, i, i2, true, iArr);
        if (DEBUG) {
            Log.d(TAG, "getMaskTextureBySegment out after process outTexture : " + iArr[0]);
        }
        return iArr[0];
    }

    public int getMaskTextureBySegment(byte[] bArr, int i, int i2, boolean z) {
        if (z) {
            return -2;
        }
        if (this.mResetMask && bArr != null) {
            for (int i3 = 0; i3 < bArr.length; i3++) {
                bArr[i3] = -1;
            }
            if (this.RESET_MASK_CYCLE_TIME < System.currentTimeMillis() - this.mResetMaskTime) {
                this.mResetMask = false;
            }
        }
        if (z || bArr == null) {
            return -1;
        }
        int[] iArr = new int[1];
        BlurFilterLibrary.processMaskBuffer(bArr, i, i2, true, iArr);
        if (DEBUG) {
            Log.d(TAG, "getMaskTextureBySegment out after process outTexture : " + iArr[0]);
        }
        return iArr[0];
    }

    private int getMaskTextureByFace(boolean z) {
        float[] fArr;
        Rect[] rectArr;
        if (this.mFaceCount <= 0) {
            return -1;
        }
        synchronized (this.mSyncObject) {
            if (this.mTmpFaceRects == null || this.mTmpFaceRects.length <= 0) {
                rectArr = null;
                fArr = null;
            } else {
                int length = this.mTmpFaceRects.length;
                rectArr = new Rect[length];
                float[] fArr2 = new float[length];
                for (int i = 0; i < length; i++) {
                    fArr2[i] = this.mTmpYaws[i];
                    rectArr[i] = new Rect(this.mTmpFaceRects[i]);
                }
                fArr = fArr2;
            }
        }
        return BlurFilterLibrary.getMaskTextureByFace(z ? null : rectArr, false, fArr, this.mPreviewWidth, this.mPreviewHeight, (AccelerometerManager.getDegree() + 270) % 360, this.mFrontCamera);
    }

    public void onPreviewCallback(byte[] bArr, int i, int i2, int i3, boolean z) {
        onPreviewCallback(bArr, i, i2, i3, z, (Callback) null);
    }

    public void onPreviewCallback(byte[] bArr, int i, int i2, int i3, boolean z, Callback callback) {
        onPreviewCallback(bArr, i, i2, i3, z, true, 1, callback);
    }

    public void onPreviewCallback(byte[] bArr, int i, int i2, int i3, boolean z, boolean z2, int i4, Callback callback) {
        this.mFaceCount = i3;
        if (i4 > 1) {
            int i5 = this.mFrameNum;
            this.mFrameNum = i5 + 1;
            if (i5 % i4 != 0) {
                if (DEBUG) {
                    Log.i(TAG, "onPreviewCallback drop this frame");
                    return;
                }
                return;
            }
        }
        if (DEBUG) {
            Log.i(TAG, "onPreviewCallback do");
        }
        if (z2) {
            if (this.mProcessThread == null) {
                this.mProcessThread = new ProcessThread();
                this.mProcessThread.start();
            }
            this.mProcessThread.updateBuffer(bArr, i, i2, z, callback);
        } else {
            doOnPreviewCallback(bArr, i, i2, z, callback);
        }
        this.mLastProcessTime = System.currentTimeMillis();
    }

    class ProcessThread extends Thread {
        Callback callback;
        byte[] copyBuffer;
        boolean frontCamera;
        int height;
        private boolean isRunning;
        int width;

        ProcessThread() {
        }

        public synchronized void start() {
            this.isRunning = true;
            super.start();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0021, code lost:
            monitor-enter(r8);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
            r8.isRunning = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0024, code lost:
            monitor-exit(r8);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0025, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r8 = this;
            L_0x0000:
                r0 = 0
                monitor-enter(r8)     // Catch:{ InterruptedException -> 0x002e }
                boolean r1 = r8.isRunning     // Catch:{ all -> 0x0029 }
                if (r1 == 0) goto L_0x0020
                boolean r1 = r8.isInterrupted()     // Catch:{ all -> 0x0029 }
                if (r1 != 0) goto L_0x0020
                r8.wait()     // Catch:{ all -> 0x0029 }
                monitor-exit(r8)     // Catch:{ all -> 0x0029 }
                com.sensetime.blur.STBlurPreview r2 = com.sensetime.blur.STBlurPreview.this     // Catch:{ InterruptedException -> 0x002e }
                byte[] r3 = r8.copyBuffer     // Catch:{ InterruptedException -> 0x002e }
                int r4 = r8.width     // Catch:{ InterruptedException -> 0x002e }
                int r5 = r8.height     // Catch:{ InterruptedException -> 0x002e }
                boolean r6 = r8.frontCamera     // Catch:{ InterruptedException -> 0x002e }
                com.sensetime.blur.STBlurPreview$Callback r7 = r8.callback     // Catch:{ InterruptedException -> 0x002e }
                r2.doOnPreviewCallback(r3, r4, r5, r6, r7)     // Catch:{ InterruptedException -> 0x002e }
                goto L_0x0000
            L_0x0020:
                monitor-exit(r8)     // Catch:{ all -> 0x0029 }
                monitor-enter(r8)
                r8.isRunning = r0     // Catch:{ all -> 0x0026 }
                monitor-exit(r8)     // Catch:{ all -> 0x0026 }
                return
            L_0x0026:
                r0 = move-exception
                monitor-exit(r8)     // Catch:{ all -> 0x0026 }
                throw r0
            L_0x0029:
                r1 = move-exception
                monitor-exit(r8)     // Catch:{ all -> 0x0029 }
                throw r1     // Catch:{ InterruptedException -> 0x002e }
            L_0x002c:
                r1 = move-exception
                goto L_0x003a
            L_0x002e:
                r1 = move-exception
                r1.printStackTrace()     // Catch:{ all -> 0x002c }
                monitor-enter(r8)
                r8.isRunning = r0     // Catch:{ all -> 0x0037 }
                monitor-exit(r8)     // Catch:{ all -> 0x0037 }
                return
            L_0x0037:
                r0 = move-exception
                monitor-exit(r8)     // Catch:{ all -> 0x0037 }
                throw r0
            L_0x003a:
                monitor-enter(r8)
                r8.isRunning = r0     // Catch:{ all -> 0x003f }
                monitor-exit(r8)     // Catch:{ all -> 0x003f }
                throw r1
            L_0x003f:
                r0 = move-exception
                monitor-exit(r8)     // Catch:{ all -> 0x003f }
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sensetime.blur.STBlurPreview.ProcessThread.run():void");
        }

        public void updateBuffer(byte[] bArr, int i, int i2, boolean z, Callback callback2) {
            this.width = i;
            this.height = i2;
            this.frontCamera = z;
            this.callback = callback2;
            this.copyBuffer = bArr;
            synchronized (this) {
                notify();
            }
        }

        public synchronized void release() {
            this.isRunning = false;
            interrupt();
        }
    }

    public void onFaceUpdate(FaceInfo[] faceInfoArr, int i, int i2, boolean z) {
        this.mUseSegment = false;
        this.mFrontCamera = z;
        this.mPreviewWidth = i;
        this.mPreviewHeight = i2;
        synchronized (this.mSyncObject) {
            if (faceInfoArr != null) {
                if (faceInfoArr.length > 0) {
                    int length = faceInfoArr.length;
                    this.mTmpFaceRects = new Rect[length];
                    this.mTmpYaws = new float[length];
                    for (int i3 = 0; i3 < length; i3++) {
                        this.mTmpYaws[i3] = faceInfoArr[i3].yaw;
                        this.mTmpFaceRects[i3] = new Rect(faceInfoArr[i3].faceRect);
                    }
                }
            }
            this.mTmpFaceRects = null;
            this.mTmpYaws = null;
        }
        this.mLastProcessTime = System.currentTimeMillis();
    }

    public void onSegmentUpdate(byte[] bArr, int i, int i2, int i3, int i4) {
        this.mUseSegment = true;
        synchronized (this.mSyncObject) {
            this.mSegmentBuffer = bArr;
            this.mSegmentBufferWidth = i;
            this.mSegmentBufferHeight = i2;
            this.mPreviewWidth = i3;
            this.mPreviewHeight = i4;
        }
        this.mLastProcessTime = System.currentTimeMillis();
    }

    /* access modifiers changed from: private */
    public void doOnPreviewCallback(byte[] bArr, int i, int i2, boolean z, Callback callback) {
        if (DEBUG) {
            Log.i(TAG, "doOnPreviewCallback data.length=" + bArr.length + ", width=" + i + ", height=" + i2);
        }
        this.mFrontCamera = z;
        this.mPreviewWidth = i;
        this.mPreviewHeight = i2;
        if (this.mUseSegment) {
            if (this.mSegment != null) {
                onSegment(bArr, i, i2, z, callback);
            }
        } else if (this.mTrack != null) {
            onTrack(bArr, i, i2, z, callback);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0016, code lost:
        if ((r2[0] * r6) != (r2[1] * r0)) goto L_0x0018;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void onSegment(byte[] r19, int r20, int r21, boolean r22, com.sensetime.blur.STBlurPreview.Callback r23) {
        /*
            r18 = this;
            r1 = r18
            r0 = r20
            r6 = r21
            r11 = r23
            java.nio.ByteBuffer r2 = r1.mSegmentOutBuffer
            r12 = 1
            r13 = 0
            if (r2 == 0) goto L_0x0018
            int[] r2 = r1.mSegmentOutBufferInfo
            r3 = r2[r13]
            int r3 = r3 * r6
            r2 = r2[r12]
            int r2 = r2 * r0
            if (r3 == r2) goto L_0x0031
        L_0x0018:
            com.sensetime.faceapi.FigureSegment r2 = r1.mSegment
            if (r2 != 0) goto L_0x001d
            return
        L_0x001d:
            r3 = 240(0xf0, float:3.36E-43)
            int[] r4 = r1.mSegmentOutBufferInfo
            r2.createOutputBuffer(r0, r6, r3, r4)
            int[] r2 = r1.mSegmentOutBufferInfo
            r3 = r2[r13]
            r2 = r2[r12]
            int r3 = r3 * r2
            java.nio.ByteBuffer r2 = java.nio.ByteBuffer.allocate(r3)
            r1.mSegmentOutBuffer = r2
        L_0x0031:
            int r2 = r1.mFaceCount
            if (r2 > 0) goto L_0x0057
            boolean r0 = DEBUG
            if (r0 == 0) goto L_0x0056
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "mFaceCount = "
            r0.append(r2)
            int r2 = r1.mFaceCount
            r0.append(r2)
            java.lang.String r2 = " skip segment"
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            java.lang.String r2 = "STBlurPreview"
            android.util.Log.i(r2, r0)
        L_0x0056:
            return
        L_0x0057:
            java.nio.ByteBuffer r2 = r1.mSegmentOutBuffer
            r2.rewind()
            com.sensetime.faceapi.model.FaceOrientation r8 = com.sensetime.faceapi.utils.AccelerometerManager.getFaceOrientation((boolean) r22)
            long r14 = java.lang.System.currentTimeMillis()
            java.lang.Object r10 = r1.mSegmentObject
            monitor-enter(r10)
            com.sensetime.faceapi.FigureSegment r2 = r1.mSegment     // Catch:{ all -> 0x00e0 }
            if (r2 == 0) goto L_0x0089
            com.sensetime.faceapi.FigureSegment r2 = r1.mSegment     // Catch:{ all -> 0x00e0 }
            com.sensetime.faceapi.model.CvPixelFormat r4 = com.sensetime.faceapi.model.CvPixelFormat.NV21     // Catch:{ all -> 0x00e0 }
            java.nio.ByteBuffer r3 = r1.mSegmentOutBuffer     // Catch:{ all -> 0x00e0 }
            byte[] r9 = r3.array()     // Catch:{ all -> 0x00e0 }
            int r7 = r1.mSegmentOption     // Catch:{ all -> 0x00e0 }
            r3 = r19
            r5 = r20
            r6 = r21
            r16 = r7
            r7 = r20
            r17 = r10
            r10 = r16
            r2.segment(r3, r4, r5, r6, r7, r8, r9, r10)     // Catch:{ all -> 0x00e5 }
            goto L_0x008b
        L_0x0089:
            r17 = r10
        L_0x008b:
            monitor-exit(r17)     // Catch:{ all -> 0x00e5 }
            long r2 = r1.debugSegSumTime
            long r4 = java.lang.System.currentTimeMillis()
            long r4 = r4 - r14
            long r2 = r2 + r4
            r1.debugSegSumTime = r2
            long r2 = r1.debugSegCount
            r4 = 1
            long r2 = r2 + r4
            r1.debugSegCount = r2
            boolean r0 = DEBUG
            if (r0 == 0) goto L_0x00bc
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "segment time = "
            r0.append(r2)
            long r2 = r1.debugSegSumTime
            long r4 = r1.debugSegCount
            long r2 = r2 / r4
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            java.lang.String r2 = "STBlurPreview"
            android.util.Log.i(r2, r0)
        L_0x00bc:
            java.lang.Object r2 = r1.mSyncObject
            monitor-enter(r2)
            java.nio.ByteBuffer r0 = r1.mSegmentOutBuffer     // Catch:{ all -> 0x00dd }
            byte[] r0 = r0.array()     // Catch:{ all -> 0x00dd }
            r1.mSegmentBuffer = r0     // Catch:{ all -> 0x00dd }
            int[] r0 = r1.mSegmentOutBufferInfo     // Catch:{ all -> 0x00dd }
            r0 = r0[r13]     // Catch:{ all -> 0x00dd }
            r1.mSegmentBufferWidth = r0     // Catch:{ all -> 0x00dd }
            int[] r0 = r1.mSegmentOutBufferInfo     // Catch:{ all -> 0x00dd }
            r0 = r0[r12]     // Catch:{ all -> 0x00dd }
            r1.mSegmentBufferHeight = r0     // Catch:{ all -> 0x00dd }
            monitor-exit(r2)     // Catch:{ all -> 0x00dd }
            if (r11 == 0) goto L_0x00dc
            boolean r0 = r1.mUseSegment
            r2 = 0
            r11.onResult(r0, r2, r2)
        L_0x00dc:
            return
        L_0x00dd:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x00dd }
            throw r0
        L_0x00e0:
            r0 = move-exception
            r17 = r10
        L_0x00e3:
            monitor-exit(r17)     // Catch:{ all -> 0x00e5 }
            throw r0
        L_0x00e5:
            r0 = move-exception
            goto L_0x00e3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sensetime.blur.STBlurPreview.onSegment(byte[], int, int, boolean, com.sensetime.blur.STBlurPreview$Callback):void");
    }

    public void onShake(boolean z) {
        if (z) {
            resetMask();
        }
    }

    private void onTrack(byte[] bArr, int i, int i2, boolean z, Callback callback) {
        Object obj;
        FaceOrientation faceOrientation = AccelerometerManager.getFaceOrientation(z);
        FaceInfo[] track = this.mTrack.track(bArr, CvPixelFormat.NV21, i, i2, faceOrientation);
        if (DEBUG) {
            StringBuilder sb = new StringBuilder();
            sb.append("onTrack dir: ");
            sb.append(faceOrientation.getValue());
            sb.append(", face: ");
            if (track == null) {
                obj = "null";
            } else {
                obj = Integer.valueOf(track.length);
            }
            sb.append(obj);
            Log.d(TAG, sb.toString());
        }
        onFaceUpdate(track, i, i2, z);
        if (callback != null) {
            FaceRotationUtil.rotateFaceInfos(track, i, i2, z, 90);
            callback.onResult(this.mUseSegment, (byte[]) null, (FaceInfo[]) null);
        }
    }

    public void resetMask() {
        if (!this.mbRetentionOpen) {
            this.mResetMask = true;
            this.mResetMaskTime = System.currentTimeMillis();
        }
    }

    private void destroySegmentTextures() {
        if (this.needDestroySegTextures) {
            destroyTextures();
            this.needDestroySegTextures = false;
        }
    }

    public int rotateMaskTexture(int i, boolean z, boolean z2) {
        return BlurFilterLibrary.rotateMaskTexture(i, z, z2);
    }

    public int rotateGrdualTexture(int i, boolean z, boolean z2) {
        return BlurFilterLibrary.rotateGradualTexture(i, z, z2);
    }

    public int setParam(int i, float f) {
        return BlurFilterLibrary.setParam(i, f);
    }

    public void resetSegmentThread() {
        SegmentThread segmentThread = this.mSegmentThread;
        if (segmentThread != null) {
            segmentThread.clear();
        }
    }

    public void setSegmentOption(int i) {
        this.mSegmentOption = i;
    }

    public static int setDebug(boolean z) {
        DEBUG = z;
        return BlurFilterLibrary.setDebug(z);
    }

    public int setDebugMask(boolean z) {
        return BlurFilterLibrary.setDebugMask(z);
    }

    public static String getVersion() {
        return BlurFilterLibrary.getVersion();
    }

    public String getTimeLog() {
        if (this.debugSegCount == 0) {
            return "";
        }
        return "segment time = " + (this.debugSegSumTime / this.debugSegCount) + " ms";
    }

    /* access modifiers changed from: private */
    public void onSegmentRGBA(byte[] bArr, int i, int i2, byte[] bArr2, boolean z, boolean z2) {
        if (DEBUG) {
            Log.i(TAG, "in onSegmentRGBA");
        }
        FaceOrientation faceOrientation = AccelerometerManager.getFaceOrientation(z);
        synchronized (this.mSegmentObject) {
            if (this.mSegment != null) {
                this.mSegment.segment(bArr, CvPixelFormat.RGBA8888, i, i2, i * 4, faceOrientation, bArr2, this.mSegmentOption);
            }
        }
        if (DEBUG) {
            Log.i(TAG, "onSegmentRGBA segment ret = segment");
        }
    }

    private void destroyTextures() {
        int i = 0;
        while (true) {
            int[] iArr = this.m2dTextureIds;
            if (i < iArr.length) {
                OpenGLUtils.destroyTexture(iArr[i]);
                this.m2dTextureIds[i] = -1;
                i++;
            } else {
                OpenGLUtils.destroyTexture(this.mResizedTextureId);
                this.mResizedTextureId = -1;
                this.mLast2dTextureId = -1;
                this.mLastMaskTextureId = -1;
                return;
            }
        }
    }

    public void setRetentionOpen(boolean z) {
        this.mbRetentionOpen = z;
    }

    private class SegmentThread extends Thread {
        private final int QUEUE_SIZE;
        private final int WAIT_TIME;
        /* access modifiers changed from: private */
        public volatile boolean active;
        /* access modifiers changed from: private */
        public BlockingQueue<SegmentData> inQueue;
        private BlockingQueue<TextureInfo> outQueue;
        private Object outQueueSyncObj;

        private SegmentThread() {
            this.QUEUE_SIZE = 2;
            this.WAIT_TIME = 60;
            this.active = true;
            this.inQueue = new LinkedBlockingQueue(2);
            this.outQueue = new LinkedBlockingQueue(4);
            this.outQueueSyncObj = new Object();
        }

        public void run() {
            SegmentData segmentData;
            super.run();
            while (this.active && !isInterrupted()) {
                byte[] bArr = null;
                try {
                    segmentData = this.inQueue.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    segmentData = null;
                }
                if (segmentData != null) {
                    if (this.active && !isInterrupted()) {
                        if (STBlurPreview.DEBUG) {
                            Log.i(STBlurPreview.TAG, "doOnPreviewSegment data.length=" + segmentData.resizedData.length + ", width=" + segmentData.resizeWidth + ", height=" + segmentData.resizeHeight);
                        }
                        STBlurPreview.this.setDefaultParamIfNeed(segmentData.isFrontCamera);
                        boolean unused = STBlurPreview.this.mFrontCamera = segmentData.isFrontCamera;
                        int unused2 = STBlurPreview.this.mPreviewWidth = segmentData.srcWidth;
                        int unused3 = STBlurPreview.this.mPreviewHeight = segmentData.srcHeight;
                        if (STBlurPreview.this.mUseSegment) {
                            int i = STBlurPreview.this.mSegmentOutBufferInfo[0];
                            int i2 = STBlurPreview.this.mSegmentOutBufferInfo[1];
                            if (segmentData.faceCount != 0) {
                                bArr = new byte[(i * i2)];
                                STBlurPreview.this.onSegmentRGBA(segmentData.resizedData, segmentData.resizeWidth, segmentData.resizeHeight, bArr, segmentData.isFrontCamera, segmentData.showOriginal);
                            }
                            byte[] bArr2 = bArr;
                            synchronized (this.outQueueSyncObj) {
                                this.outQueue.offer(new TextureInfo(segmentData.src2dTextureId, segmentData.srcWidth, segmentData.srcHeight, bArr2, i, i2, segmentData.showOriginal));
                            }
                        } else {
                            continue;
                        }
                    } else {
                        return;
                    }
                }
            }
        }

        public TextureInfo getLatestTextureInfo() {
            synchronized (this.outQueueSyncObj) {
                if (this.outQueue.isEmpty()) {
                    return null;
                }
                while (this.outQueue.size() > 1) {
                    this.outQueue.poll();
                }
                TextureInfo textureInfo = (TextureInfo) this.outQueue.poll();
                return textureInfo;
            }
        }

        public void release() {
            this.active = false;
            interrupt();
            clear();
        }

        public void clear() {
            this.inQueue.clear();
            this.outQueue.clear();
            boolean unused = STBlurPreview.this.needDestroySegTextures = true;
        }
    }

    private class TextureInfo {
        byte[] maskData = null;
        int maskHeight = 0;
        int maskWidth = 0;
        boolean showOriginal = false;
        int src2dTextureId = 0;
        int srcHeight = 0;
        int srcWidth = 0;

        public TextureInfo(int i, int i2, int i3, byte[] bArr, int i4, int i5, boolean z) {
            this.src2dTextureId = i;
            this.srcWidth = i2;
            this.srcHeight = i3;
            this.maskData = bArr;
            this.maskWidth = i4;
            this.maskHeight = i5;
            this.showOriginal = z;
        }
    }

    private class SegmentData {
        int faceCount = 0;
        boolean isFrontCamera = false;
        int resizeHeight = 0;
        int resizeWidth = 0;
        byte[] resizedData = null;
        boolean showOriginal = false;
        int src2dTextureId = 0;
        int srcHeight = 0;
        int srcWidth = 0;

        public SegmentData(int i, int i2, int i3, byte[] bArr, int i4, int i5, int i6, boolean z, boolean z2) {
            this.src2dTextureId = i;
            this.srcWidth = i2;
            this.srcHeight = i3;
            this.resizedData = bArr;
            this.resizeWidth = i4;
            this.resizeHeight = i5;
            this.faceCount = i6;
            this.isFrontCamera = z;
            this.showOriginal = z2;
        }
    }
}
