package com.anc.humanvideo;

import android.annotation.SuppressLint;
import android.util.Log;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class HumanVideoApi {
    static final String TAG = "HumanVideoApi";
    private static AtomicBoolean isSoLoaded = new AtomicBoolean(false);
    private static HumanVideoApi sInstance = new HumanVideoApi();
    private AtomicLong handle = new AtomicLong(0);
    private AtomicInteger mPendingLogLevel = new AtomicInteger(-1);
    private int runtime_featureset;
    private int sdk_featureset;

    public enum CameraType {
        MODE_REAR_CAMERA,
        MODE_FRONT_CAMERA
    }

    public static class HumanFrame {
        public byte[] data;
        public int height;
        public int rotation;
        public ImageType type;
        public int width;
    }

    public static class HumanProcessFrameRequest extends HumanProcessRequest {
        public HumanFrame humanFrame = new HumanFrame();
    }

    public static class HumanProcessFrameResult extends HumanProcessResult {
        public HumanFrame humanFrame = new HumanFrame();
    }

    public static class HumanProcessRequest {
        public CameraType cameraType;
    }

    public static class HumanProcessResult {
    }

    public static class HumanProcessTextureRequest extends HumanProcessRequest {
        public HumanTexture humanTexture = new HumanTexture();
    }

    public static class HumanProcessTexureResult extends HumanProcessResult {
        public HumanTexture humanTexture = new HumanTexture();
    }

    public static class HumanTexture {
        public int height;
        public boolean isOES;
        public int rotation;
        public int texID;
        public int width;
    }

    public static class HumanVideoBokehParams extends HumanVideoParams {
        public float blurIntensity;
    }

    public static class HumanVideoParams {
    }

    public static class HumanVideoRetainParams extends HumanVideoParams {
        public String bgPath;
        public String fgPath;
    }

    public enum ImageType {
        ANC_HUM_IMG_NV21,
        ANC_HUM_IMG_BGR,
        ANC_HUM_IMG_RGB,
        ANC_HUM_IMG_RGBA,
        ANC_HUM_IMG_DEPTH,
        ANC_HUM_IMG_GREYSCALE,
        ANC_HUM_IMG_NV12
    }

    private native int nativeEnableRunTimeFeature(long j, int i);

    private native long nativeInitHandle(HumanVideoConfig humanVideoConfig);

    private native int nativeProcessFrame(long j, byte[] bArr, byte[] bArr2, int i, int i2, int i3, int i4, int i5, int i6);

    private native int nativeProcessTexture(long j, int i, int i2, int i3, int i4, int i5, boolean z);

    private native int nativeRelease(long j);

    private native String nativeSdkVersion();

    private native int nativeSetLogLevel(int i);

    private native int nativeSetParamsBokeh(long j, HumanVideoBokehParams humanVideoBokehParams);

    private native int nativeSetParamsRetain(long j, HumanVideoRetainParams humanVideoRetainParams);

    public static HumanVideoApi getInstance() {
        return sInstance;
    }

    public enum FeatureType {
        ANCHUM_FEATURE_NONE(0),
        ANCHUM_FEATURE_BOKEH(1),
        ANCHUM_FEATURE_RETAIN(2),
        ANCHUM_FEATURE_SEGMENT(4);
        
        private final int value;

        private FeatureType(int i) {
            this.value = i;
        }

        public int getValue() {
            return this.value;
        }
    }

    public static class HumanVideoConfig {
        public String cachePath;
        public boolean isRealTime;
        public byte[] modelData;
        public String modelPath;
        public String nativeLibPath;
        public int sdkCapability;

        @SuppressLint({"DefaultLocale"})
        public String toString() {
            Object[] objArr = new Object[5];
            int i = 0;
            objArr[0] = Integer.valueOf(this.sdkCapability);
            byte[] bArr = this.modelData;
            if (bArr != null) {
                i = bArr.length;
            }
            objArr[1] = Integer.valueOf(i);
            String str = this.cachePath;
            String str2 = "null";
            objArr[2] = str != null ? new File(str).getName() : str2;
            String str3 = this.nativeLibPath;
            if (str3 != null) {
                str2 = new File(str3).getName();
            }
            objArr[3] = str2;
            objArr[4] = Boolean.valueOf(this.isRealTime);
            return String.format("sdkCapability %d, model size %d, cache path %s, lib path %s, realtime %b", objArr);
        }
    }

    public int setLogLevel(int i) {
        if (i < 0 || i > 4) {
            Log.e(TAG, "setLogLevel: log level must be 1~4");
            return 1;
        } else if (!isSoLoaded.get()) {
            this.mPendingLogLevel.set(i);
            return -1;
        } else {
            nativeSetLogLevel(i);
            return 0;
        }
    }

    public String getVersion() {
        if (!isSoLoaded.get()) {
            return "";
        }
        return nativeSdkVersion();
    }

    public int initHandle(HumanVideoConfig humanVideoConfig) {
        String str = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("init by config BuildNumber: 100 isRealTime: ");
        sb.append(humanVideoConfig != null ? humanVideoConfig.toString() : " null config");
        Log.i(str, sb.toString());
        if (humanVideoConfig == null) {
            Log.e(TAG, "initHandle: config invalid!");
            return 1;
        }
        if (humanVideoConfig.modelData == null) {
            if (humanVideoConfig.modelPath != null) {
                humanVideoConfig.modelData = getFileContent(humanVideoConfig.modelPath);
            } else {
                Log.e(TAG, "initHandle: config invalid, model is null!");
                return 1;
            }
        }
        File file = new File(humanVideoConfig.cachePath);
        if (file.isFile()) {
            file.delete();
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        if (this.handle.get() != 0) {
            Log.e(TAG, "initHandle:handle start init failure!");
            return 5;
        }
        if (!isSoLoaded.get()) {
            System.loadLibrary("AncHumanVideo-jni");
            isSoLoaded.set(true);
        }
        if (humanVideoConfig.cachePath == null) {
            humanVideoConfig.cachePath = "";
        }
        if (humanVideoConfig.nativeLibPath == null) {
            humanVideoConfig.nativeLibPath = "";
        }
        this.sdk_featureset = humanVideoConfig.sdkCapability;
        this.runtime_featureset = FeatureType.ANCHUM_FEATURE_NONE.getValue();
        this.handle.set(nativeInitHandle(humanVideoConfig));
        return 0;
    }

    public int enableRuntimeFeature(FeatureType featureType, boolean z) {
        if (this.handle.get() == 0) {
            return 2;
        }
        if ((this.sdk_featureset & featureType.getValue()) == 0) {
            Log.e(TAG, "enableRuntimeFeature: FeatureType not available!");
            return 1;
        }
        if (z) {
            this.runtime_featureset = featureType.getValue() | this.runtime_featureset;
        } else {
            this.runtime_featureset = (~featureType.getValue()) & this.runtime_featureset;
        }
        return nativeEnableRunTimeFeature(this.handle.get(), this.runtime_featureset);
    }

    public int setParams(HumanVideoParams humanVideoParams) {
        if (this.handle.get() == 0) {
            Log.e(TAG, "setParams: handle is invalid!");
            return 2;
        } else if (humanVideoParams instanceof HumanVideoBokehParams) {
            return nativeSetParamsBokeh(this.handle.get(), (HumanVideoBokehParams) humanVideoParams);
        } else {
            if (humanVideoParams instanceof HumanVideoRetainParams) {
                return nativeSetParamsRetain(this.handle.get(), (HumanVideoRetainParams) humanVideoParams);
            }
            Log.e(TAG, "setParams: params type is invalid!");
            return 1;
        }
    }

    public int process(HumanProcessRequest humanProcessRequest, HumanProcessResult humanProcessResult) {
        if (this.handle.get() == 0) {
            Log.e(TAG, "process: handle is invalid!");
            return 2;
        } else if ((humanProcessRequest instanceof HumanProcessTextureRequest) && (humanProcessResult instanceof HumanProcessTexureResult)) {
            HumanProcessTextureRequest humanProcessTextureRequest = (HumanProcessTextureRequest) humanProcessRequest;
            return nativeProcessTexture(this.handle.get(), humanProcessTextureRequest.humanTexture.texID, ((HumanProcessTexureResult) humanProcessResult).humanTexture.texID, humanProcessTextureRequest.humanTexture.width, humanProcessTextureRequest.humanTexture.height, humanProcessTextureRequest.humanTexture.rotation, humanProcessTextureRequest.humanTexture.isOES);
        } else if (!(humanProcessRequest instanceof HumanProcessFrameRequest) || !(humanProcessResult instanceof HumanProcessFrameResult)) {
            Log.e(TAG, "process: request type is invalid!");
            return 2;
        } else {
            HumanProcessFrameRequest humanProcessFrameRequest = (HumanProcessFrameRequest) humanProcessRequest;
            HumanProcessFrameResult humanProcessFrameResult = (HumanProcessFrameResult) humanProcessResult;
            return nativeProcessFrame(this.handle.get(), humanProcessFrameRequest.humanFrame.data, humanProcessFrameResult.humanFrame.data, humanProcessFrameRequest.humanFrame.width, humanProcessFrameRequest.humanFrame.height, (humanProcessFrameResult.humanFrame.width == 0 ? humanProcessFrameRequest.humanFrame : humanProcessFrameResult.humanFrame).width, (humanProcessFrameResult.humanFrame.height == 0 ? humanProcessFrameRequest.humanFrame : humanProcessFrameResult.humanFrame).height, humanProcessFrameRequest.humanFrame.type.ordinal(), humanProcessFrameRequest.humanFrame.rotation);
        }
    }

    public int release() {
        if (this.handle.get() == 0) {
            Log.e(TAG, "release: handle is invalid!");
            return 2;
        }
        int nativeRelease = nativeRelease(this.handle.get());
        this.handle.set(0);
        return nativeRelease;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
        android.util.Log.e(TAG, "getFileContent: get model from path failure!");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002e, code lost:
        return null;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x0027 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static byte[] getFileContent(java.lang.String r4) {
        /*
            java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream
            r0.<init>()
            r1 = 8192(0x2000, float:1.14794E-41)
            byte[] r1 = new byte[r1]
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ IOException -> 0x0027 }
            r2.<init>(r4)     // Catch:{ IOException -> 0x0027 }
        L_0x000e:
            int r4 = r2.read(r1)     // Catch:{ IOException -> 0x0027 }
            r3 = -1
            if (r4 == r3) goto L_0x001a
            r3 = 0
            r0.write(r1, r3, r4)     // Catch:{ IOException -> 0x0027 }
            goto L_0x000e
        L_0x001a:
            r2.close()     // Catch:{ IOException -> 0x0027 }
            r0.close()     // Catch:{ IOException -> 0x0027 }
            byte[] r4 = r0.toByteArray()
            return r4
        L_0x0025:
            r4 = move-exception
            goto L_0x0030
        L_0x0027:
            java.lang.String r4 = TAG     // Catch:{ all -> 0x0025 }
            java.lang.String r0 = "getFileContent: get model from path failure!"
            android.util.Log.e(r4, r0)     // Catch:{ all -> 0x0025 }
            r4 = 0
            return r4
        L_0x0030:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anc.humanvideo.HumanVideoApi.getFileContent(java.lang.String):byte[]");
    }
}
