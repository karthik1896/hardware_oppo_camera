package com.cdv.io;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;
import android.view.Surface;
import com.cdv.utils.NvAndroidInterruptionChecker;
import com.cdv.utils.NvAndroidUtils;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class NvAndroidVideoFileReader implements SurfaceTexture.OnFrameAvailableListener {
    private static final int DECODER_FEED_STATUS_Error = 3;
    private static final int DECODER_FEED_STATUS_Finish = 2;
    private static final int DECODER_FEED_STATUS_None = 0;
    private static final int DECODER_FEED_STATUS_Start = 1;
    private static final int ERROR_EOF = 1;
    private static final int ERROR_FAIL = 2;
    private static final int ERROR_INTERRUPTED_DECODING = 3;
    private static final int ERROR_MEDIA_EXTRACTOR_PRELOAD_FAILED = 4;
    private static final int ERROR_OK = 0;
    private static final int SKIP_MODE_ALL_NONREFERENCE = 1;
    private static final int SKIP_MODE_BELOW_TIMESTAMP = 2;
    private static final int SKIP_MODE_NONE = 0;
    private static final String TAG = "NvAndroidVideoFileReader";
    private static Method m_setOnFrameAvailableListener2 = null;
    private static final boolean m_verbose = false;
    private MediaCodec.BufferInfo m_bufferInfo;
    private Handler m_cleanupHandler = null;
    private Context m_context;
    private long m_contiuousDecodingThreshold;
    private boolean m_curTexImageUpdated;
    private MediaCodec m_decoder;
    ByteBuffer[] m_decoderInputBuffers;
    private boolean m_decoderSetupFailed;
    private boolean m_decoderStarted;
    private long m_duration = 0;
    private MediaExtractor m_extractor = null;
    private boolean m_extractorInOriginalState;
    /* access modifiers changed from: private */
    public int m_feedDecoderStatus;
    private boolean m_feedDecoderStopping;
    private Object m_feedDecoderSyncObject;
    private Handler m_feedVideoDecoderHandler;
    private HandlerThread m_feedVideoDecoderThread;
    private boolean m_firstPlaybackTexFrameUnconsumed;
    private MediaFormat m_format = null;
    private boolean m_frameAvailable;
    private Object m_frameSyncObject;
    private Handler m_handler = null;
    private boolean m_inputBufferQueued;
    private NvAndroidInterruptionChecker m_interruptionChecker;
    private long m_lastSeekActualTimestamp;
    private long m_lastSeekTimestamp;
    private boolean m_onlyDecodeKeyFrame;
    private AtomicInteger m_pendingInputFrameCount;
    private long m_preloadedTimestamp;
    private boolean m_sawInputEOS;
    private boolean m_sawOutputEOS;
    private boolean m_skipNonReferenceFrameWhenPlayback;
    private Surface m_surface;
    /* access modifiers changed from: private */
    public SurfaceTexture m_surfaceTexture;
    /* access modifiers changed from: private */
    public Semaphore m_surfaceTextureCreationSemaphore;
    private long m_temporalLayerEndTime;
    /* access modifiers changed from: private */
    public int m_texId;
    private long m_timestampOfCurTexFrame;
    private long m_timestampOfLastDecodedFrame;
    private AtomicLong m_timestampOfLastInputFrame;
    private boolean m_usedAsyncDecodeMode;
    private int m_usedTemporalLayer;
    private int m_videoColorTransferCharacteristic;
    private String m_videoFilePath;
    private int m_videoTrackIndex = -1;

    public void preload(long j) {
    }

    static {
        if (Build.VERSION.SDK_INT >= 21) {
            try {
                m_setOnFrameAvailableListener2 = SurfaceTexture.class.getDeclaredMethod("setOnFrameAvailableListener", new Class[]{SurfaceTexture.OnFrameAvailableListener.class, Handler.class});
                Log.d(TAG, "New SurfaceTexture.setOnFrameAvailableListener() method is available!");
            } catch (Exception unused) {
                m_setOnFrameAvailableListener2 = null;
            }
        }
    }

    NvAndroidVideoFileReader(Handler handler, Handler handler2) {
        boolean z = true;
        this.m_extractorInOriginalState = true;
        this.m_surfaceTexture = null;
        this.m_surface = null;
        this.m_bufferInfo = null;
        this.m_decoder = null;
        this.m_decoderSetupFailed = false;
        this.m_decoderStarted = false;
        this.m_decoderInputBuffers = null;
        this.m_frameSyncObject = new Object();
        this.m_frameAvailable = false;
        this.m_timestampOfLastDecodedFrame = Long.MIN_VALUE;
        this.m_timestampOfCurTexFrame = Long.MIN_VALUE;
        this.m_curTexImageUpdated = false;
        this.m_firstPlaybackTexFrameUnconsumed = false;
        this.m_sawOutputEOS = false;
        this.m_preloadedTimestamp = Long.MIN_VALUE;
        this.m_lastSeekTimestamp = Long.MIN_VALUE;
        this.m_lastSeekActualTimestamp = Long.MIN_VALUE;
        this.m_usedTemporalLayer = -1;
        this.m_temporalLayerEndTime = -1;
        this.m_onlyDecodeKeyFrame = false;
        this.m_contiuousDecodingThreshold = 1500000;
        this.m_inputBufferQueued = false;
        this.m_sawInputEOS = false;
        this.m_skipNonReferenceFrameWhenPlayback = false;
        this.m_timestampOfLastInputFrame = new AtomicLong(Long.MIN_VALUE);
        this.m_pendingInputFrameCount = new AtomicInteger(0);
        this.m_feedVideoDecoderThread = null;
        this.m_feedVideoDecoderHandler = null;
        this.m_feedDecoderStatus = 0;
        this.m_feedDecoderStopping = false;
        this.m_feedDecoderSyncObject = new Object();
        this.m_usedAsyncDecodeMode = Build.VERSION.SDK_INT < 28 ? false : z;
        this.m_videoColorTransferCharacteristic = 0;
        this.m_handler = handler;
        this.m_cleanupHandler = handler2;
        this.m_bufferInfo = new MediaCodec.BufferInfo();
    }

    public boolean OpenFile(String str, int i, Context context, int i2, long j) {
        if (IsValid()) {
            Log.e(TAG, "You can't call OpenFile() twice!");
            return false;
        }
        this.m_extractor = NvAndroidUtils.createMediaExtractorFromMediaFilePath(context, str);
        MediaExtractor mediaExtractor = this.m_extractor;
        if (mediaExtractor == null) {
            return false;
        }
        this.m_extractorInOriginalState = true;
        this.m_videoFilePath = str;
        this.m_context = context;
        try {
            int trackCount = mediaExtractor.getTrackCount();
            int i3 = 0;
            while (true) {
                if (i3 >= trackCount) {
                    break;
                } else if (this.m_extractor.getTrackFormat(i3).getString("mime").startsWith("video/")) {
                    this.m_videoTrackIndex = i3;
                    break;
                } else {
                    i3++;
                }
            }
            int i4 = this.m_videoTrackIndex;
            if (i4 < 0) {
                Log.e(TAG, "Failed to find a video track from " + str);
                CloseFile();
                return false;
            }
            this.m_extractor.selectTrack(i4);
            this.m_format = this.m_extractor.getTrackFormat(this.m_videoTrackIndex);
            if (Build.VERSION.SDK_INT == 16) {
                this.m_format.setInteger("max-input-size", 0);
            }
            this.m_videoColorTransferCharacteristic = 3;
            if (this.m_format.containsKey("color-transfer")) {
                this.m_videoColorTransferCharacteristic = this.m_format.getInteger("color-transfer");
            }
            boolean equals = Build.HARDWARE.equals("qcom");
            if (Build.VERSION.SDK_INT >= 23 && i2 >= 0 && !equals) {
                MediaFormat mediaFormat = this.m_format;
                if (i2 <= 0) {
                    i2 = 120;
                }
                mediaFormat.setInteger("operating-rate", i2);
            }
            try {
                this.m_duration = this.m_format.getLong("durationUs");
                String string = this.m_format.getString("mime");
                if (equals && this.m_format.containsKey("frame-rate")) {
                    this.m_format.setInteger("frame-rate", 0);
                }
                try {
                    if (m_setOnFrameAvailableListener2 != null) {
                        this.m_surfaceTexture = new SurfaceTexture(i);
                        m_setOnFrameAvailableListener2.invoke(this.m_surfaceTexture, new Object[]{this, this.m_handler});
                    } else {
                        this.m_surfaceTextureCreationSemaphore = new Semaphore(0);
                        this.m_texId = i;
                        this.m_handler.post(new Runnable() {
                            public void run() {
                                try {
                                    SurfaceTexture unused = NvAndroidVideoFileReader.this.m_surfaceTexture = new SurfaceTexture(NvAndroidVideoFileReader.this.m_texId);
                                    NvAndroidVideoFileReader.this.m_surfaceTextureCreationSemaphore.release();
                                } catch (Exception e) {
                                    Log.e(NvAndroidVideoFileReader.TAG, "" + e.getMessage());
                                    e.printStackTrace();
                                }
                            }
                        });
                        this.m_surfaceTextureCreationSemaphore.acquire();
                        this.m_surfaceTextureCreationSemaphore = null;
                        this.m_texId = 0;
                        if (this.m_surfaceTexture == null) {
                            CloseFile();
                            return false;
                        }
                        this.m_surfaceTexture.setOnFrameAvailableListener(this);
                    }
                    this.m_surface = new Surface(this.m_surfaceTexture);
                    this.m_decoderSetupFailed = false;
                    if (!SetupDecoder(string)) {
                        this.m_decoderSetupFailed = true;
                        CloseFile();
                        return false;
                    }
                    if (this.m_usedAsyncDecodeMode) {
                        CreateFeedVideoDecoderThread();
                    }
                    this.m_contiuousDecodingThreshold = j;
                    this.m_usedTemporalLayer = -1;
                    this.m_temporalLayerEndTime = -1;
                    this.m_onlyDecodeKeyFrame = false;
                    return true;
                } catch (Exception e) {
                    Log.e(TAG, "" + e.getMessage());
                    e.printStackTrace();
                    CloseFile();
                    return false;
                }
            } catch (Exception e2) {
                Log.e(TAG, "" + e2.getMessage());
                e2.printStackTrace();
                CloseFile();
                return false;
            }
        } catch (Exception e3) {
            Log.e(TAG, "" + e3.getMessage());
            e3.printStackTrace();
            CloseFile();
            return false;
        }
    }

    public boolean hasDecoderSetupFailed() {
        return this.m_decoderSetupFailed;
    }

    public void enableOnlyDecodeKeyFrame(boolean z) {
        this.m_onlyDecodeKeyFrame = z;
    }

    public void setActualDuration(long j) {
        if (j > this.m_duration) {
            this.m_duration = j;
        }
    }

    public void setInterruptionChecker(NvAndroidInterruptionChecker nvAndroidInterruptionChecker) {
        this.m_interruptionChecker = nvAndroidInterruptionChecker;
    }

    public void skipNonReferenceFrame(boolean z) {
        this.m_skipNonReferenceFrameWhenPlayback = z;
    }

    public void CloseFile() {
        InvalidLastSeekTimestamp();
        if (this.m_usedAsyncDecodeMode) {
            BreakFeedVideoDecoder();
            CloseFeedVideoDecoderThread();
        }
        try {
            CleanupDecoder(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        MediaExtractor mediaExtractor = this.m_extractor;
        if (mediaExtractor != null) {
            mediaExtractor.release();
            this.m_extractor = null;
            this.m_videoTrackIndex = -1;
            this.m_format = null;
            this.m_duration = 0;
            this.m_extractorInOriginalState = true;
        }
        this.m_usedTemporalLayer = -1;
        this.m_temporalLayerEndTime = -1;
        this.m_onlyDecodeKeyFrame = false;
        this.m_videoFilePath = null;
        this.m_context = null;
    }

    public void SetDecodeTemporalLayer(int i, long j) {
        if (i != this.m_usedTemporalLayer) {
            this.m_temporalLayerEndTime = j;
            this.m_usedTemporalLayer = i;
        }
    }

    public int SeekVideoFrame(long j, long j2) {
        if (!IsValid()) {
            return 1;
        }
        long max = Math.max(j, 0);
        long j3 = this.m_duration;
        if (max >= j3) {
            if (max >= 40000 + j3) {
                return 1;
            }
            max = j3 - 1;
        }
        long j4 = this.m_timestampOfCurTexFrame;
        if (j4 != Long.MIN_VALUE && Math.abs(max - j4) <= j2) {
            return 0;
        }
        int SeekInternal = SeekInternal(max, j2, false, this.m_onlyDecodeKeyFrame ? 0 : 2, false);
        if (SeekInternal == 0) {
            this.m_lastSeekTimestamp = max;
            this.m_lastSeekActualTimestamp = this.m_timestampOfCurTexFrame;
        } else {
            InvalidLastSeekTimestamp();
        }
        return SeekInternal;
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x004e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int StartPlayback(long r11, long r13) {
        /*
            r10 = this;
            boolean r0 = r10.IsValid()
            r8 = 1
            if (r0 != 0) goto L_0x0008
            return r8
        L_0x0008:
            r0 = 0
            long r0 = java.lang.Math.max(r11, r0)
            long r2 = r10.m_duration
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 < 0) goto L_0x0015
            return r8
        L_0x0015:
            long r2 = r10.m_preloadedTimestamp
            r4 = -9223372036854775808
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 == 0) goto L_0x002b
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 < 0) goto L_0x0028
            long r2 = r10.m_timestampOfCurTexFrame
            int r6 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r6 > 0) goto L_0x0028
            r0 = r2
        L_0x0028:
            r10.m_preloadedTimestamp = r4
            goto L_0x003d
        L_0x002b:
            long r2 = r10.m_lastSeekTimestamp
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 == 0) goto L_0x003d
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 != 0) goto L_0x003d
            long r2 = r10.m_lastSeekActualTimestamp
            int r4 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r4 == 0) goto L_0x003d
            r1 = r2
            goto L_0x003e
        L_0x003d:
            r1 = r0
        L_0x003e:
            long r3 = r10.m_timestampOfCurTexFrame
            int r0 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            r9 = 0
            if (r0 != 0) goto L_0x004e
            long r5 = r10.m_timestampOfLastDecodedFrame
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 != 0) goto L_0x004e
            r10.m_firstPlaybackTexFrameUnconsumed = r8
            return r9
        L_0x004e:
            r5 = 0
            r6 = 2
            boolean r7 = r10.m_usedAsyncDecodeMode
            r0 = r10
            r3 = r13
            int r0 = r0.SeekInternal(r1, r3, r5, r6, r7)
            r10.InvalidLastSeekTimestamp()
            if (r0 == 0) goto L_0x005e
            return r0
        L_0x005e:
            r10.m_firstPlaybackTexFrameUnconsumed = r8
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cdv.io.NvAndroidVideoFileReader.StartPlayback(long, long):int");
    }

    public int GetNextVideoFrameForPlayback() {
        if (!IsValid()) {
            return 1;
        }
        if (!this.m_firstPlaybackTexFrameUnconsumed) {
            boolean z = this.m_skipNonReferenceFrameWhenPlayback;
            int DecodeToFrame = DecodeToFrame(Long.MIN_VALUE, 0, false, z ? 1 : 0, this.m_usedAsyncDecodeMode);
            InvalidLastSeekTimestamp();
            if (DecodeToFrame != 0) {
                return DecodeToFrame;
            }
        } else {
            this.m_firstPlaybackTexFrameUnconsumed = false;
        }
        return 0;
    }

    public long GetTimestampOfCurrentTextureFrame() {
        return this.m_timestampOfCurTexFrame;
    }

    public void GetTransformMatrixOfSurfaceTexture(float[] fArr) {
        SurfaceTexture surfaceTexture = this.m_surfaceTexture;
        if (surfaceTexture != null) {
            surfaceTexture.getTransformMatrix(fArr);
        }
    }

    public void updateCurTexImage() {
        try {
            if (this.m_timestampOfCurTexFrame != Long.MIN_VALUE && !this.m_curTexImageUpdated) {
                if (this.m_surfaceTexture != null) {
                    this.m_surfaceTexture.updateTexImage();
                }
                this.m_curTexImageUpdated = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int GetVideoColorTransfer() {
        return this.m_videoColorTransferCharacteristic;
    }

    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        synchronized (this.m_frameSyncObject) {
            if (this.m_frameAvailable) {
                Log.e(TAG, "m_frameAvailable already set, frame could be dropped!");
            }
            this.m_frameAvailable = true;
            this.m_frameSyncObject.notifyAll();
        }
    }

    private boolean IsValid() {
        return this.m_decoder != null;
    }

    private boolean recreateMediaExtractor() {
        try {
            this.m_extractor.release();
            this.m_extractor = NvAndroidUtils.createMediaExtractorFromMediaFilePath(this.m_context, this.m_videoFilePath);
            if (this.m_extractor != null) {
                this.m_extractor.selectTrack(this.m_videoTrackIndex);
                this.m_extractorInOriginalState = true;
                return true;
            }
            throw new Exception("Failed to re-create media extractor!");
        } catch (Exception e) {
            Log.e(TAG, "" + e.getMessage());
            e.printStackTrace();
            this.m_extractor = null;
            this.m_videoTrackIndex = -1;
            this.m_format = null;
            this.m_duration = 0;
            this.m_extractorInOriginalState = true;
            CloseFile();
            return false;
        }
    }

    private boolean SetupDecoder(String str) {
        try {
            this.m_decoder = MediaCodec.createDecoderByType(str);
            this.m_decoder.configure(this.m_format, this.m_surface, (MediaCrypto) null, 0);
            this.m_decoder.start();
            this.m_decoderStarted = true;
            this.m_decoderInputBuffers = this.m_decoder.getInputBuffers();
            return true;
        } catch (Exception e) {
            Log.e(TAG, "" + e.getMessage());
            e.printStackTrace();
            CleanupDecoder(false);
            return false;
        }
    }

    private void CleanupDecoder(boolean z) {
        updateCurTexImage();
        if (this.m_decoder != null && this.m_decoderStarted) {
            try {
                if (this.m_sawInputEOS && !this.m_sawOutputEOS) {
                    DrainOutputBuffers(true);
                }
            } catch (Exception e) {
                Log.e(TAG, "" + e.getMessage());
                e.printStackTrace();
            }
        }
        if (!z) {
            CleanupDecoderCore(false);
        } else {
            this.m_cleanupHandler.post(new Runnable() {
                public void run() {
                    NvAndroidVideoFileReader.this.CleanupDecoderCore(true);
                }
            });
        }
        this.m_timestampOfLastDecodedFrame = Long.MIN_VALUE;
        this.m_timestampOfCurTexFrame = Long.MIN_VALUE;
        this.m_firstPlaybackTexFrameUnconsumed = false;
        this.m_pendingInputFrameCount.set(0);
        this.m_timestampOfLastInputFrame.set(Long.MIN_VALUE);
        this.m_sawInputEOS = false;
        this.m_sawOutputEOS = false;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Can't wrap try/catch for region: R(4:8|9|10|11) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x0011 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void CleanupDecoderCore(boolean r6) {
        /*
            r5 = this;
            android.media.MediaCodec r0 = r5.m_decoder
            r1 = 0
            if (r0 == 0) goto L_0x0042
            boolean r2 = r5.m_decoderStarted
            if (r2 == 0) goto L_0x003b
            r2 = 0
            boolean r3 = r5.m_inputBufferQueued     // Catch:{ Exception -> 0x0019 }
            if (r3 == 0) goto L_0x0013
            r0.flush()     // Catch:{ Exception -> 0x0011 }
        L_0x0011:
            r5.m_inputBufferQueued = r2     // Catch:{ Exception -> 0x0019 }
        L_0x0013:
            android.media.MediaCodec r0 = r5.m_decoder     // Catch:{ Exception -> 0x0019 }
            r0.stop()     // Catch:{ Exception -> 0x0019 }
            goto L_0x0037
        L_0x0019:
            r0 = move-exception
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = ""
            r3.append(r4)
            java.lang.String r4 = r0.getMessage()
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            java.lang.String r4 = "NvAndroidVideoFileReader"
            android.util.Log.e(r4, r3)
            r0.printStackTrace()
        L_0x0037:
            r5.m_decoderStarted = r2
            r5.m_decoderInputBuffers = r1
        L_0x003b:
            android.media.MediaCodec r0 = r5.m_decoder
            r0.release()
            r5.m_decoder = r1
        L_0x0042:
            if (r6 == 0) goto L_0x0056
            android.view.Surface r6 = r5.m_surface
            if (r6 == 0) goto L_0x004d
            r6.release()
            r5.m_surface = r1
        L_0x004d:
            android.graphics.SurfaceTexture r6 = r5.m_surfaceTexture
            if (r6 == 0) goto L_0x0056
            r6.release()
            r5.m_surfaceTexture = r1
        L_0x0056:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cdv.io.NvAndroidVideoFileReader.CleanupDecoderCore(boolean):void");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:37|38|39|40) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x007c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int SeekInternal(long r9, long r11, boolean r13, int r14, boolean r15) {
        /*
            r8 = this;
            java.lang.String r0 = "NvAndroidVideoFileReader"
            long r1 = r8.m_timestampOfLastDecodedFrame
            r3 = -9223372036854775808
            int r3 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            r4 = 1
            r5 = 0
            if (r3 == 0) goto L_0x0018
            int r3 = (r9 > r1 ? 1 : (r9 == r1 ? 0 : -1))
            if (r3 <= 0) goto L_0x0018
            long r6 = r8.m_contiuousDecodingThreshold
            long r1 = r1 + r6
            int r1 = (r9 > r1 ? 1 : (r9 == r1 ? 0 : -1))
            if (r1 >= 0) goto L_0x0018
            goto L_0x0024
        L_0x0018:
            boolean r1 = r8.m_extractorInOriginalState
            if (r1 == 0) goto L_0x0023
            long r1 = r8.m_contiuousDecodingThreshold
            int r1 = (r9 > r1 ? 1 : (r9 == r1 ? 0 : -1))
            if (r1 >= 0) goto L_0x0023
            goto L_0x0024
        L_0x0023:
            r4 = r5
        L_0x0024:
            if (r15 != 0) goto L_0x002b
            int r1 = r8.m_feedDecoderStatus
            if (r1 == 0) goto L_0x002b
            r4 = r5
        L_0x002b:
            boolean r1 = r8.m_onlyDecodeKeyFrame
            if (r1 == 0) goto L_0x0030
            r4 = r5
        L_0x0030:
            if (r4 != 0) goto L_0x00b3
            r1 = 2
            r8.BreakFeedVideoDecoder()     // Catch:{ Exception -> 0x0096 }
            android.media.MediaExtractor r2 = r8.m_extractor     // Catch:{ Exception -> 0x0096 }
            r2.seekTo(r9, r5)     // Catch:{ Exception -> 0x0096 }
            android.media.MediaExtractor r2 = r8.m_extractor     // Catch:{ Exception -> 0x0096 }
            long r2 = r2.getSampleTime()     // Catch:{ Exception -> 0x0096 }
            r6 = 0
            int r2 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r2 >= 0) goto L_0x006a
            long r2 = r8.m_duration     // Catch:{ Exception -> 0x0096 }
            r6 = 100000(0x186a0, double:4.94066E-319)
            long r2 = r2 - r6
            int r2 = (r9 > r2 ? 1 : (r9 == r2 ? 0 : -1))
            if (r2 >= 0) goto L_0x006a
            java.lang.String r2 = "Try to recreate MediaExtractor!"
            android.util.Log.w(r0, r2)     // Catch:{ Exception -> 0x0096 }
            boolean r2 = r8.recreateMediaExtractor()     // Catch:{ Exception -> 0x0096 }
            if (r2 != 0) goto L_0x0065
            java.lang.String r9 = "Failed to recreate MediaExtractor!"
            android.util.Log.e(r0, r9)     // Catch:{ Exception -> 0x0096 }
            r8.CloseFile()     // Catch:{ Exception -> 0x0096 }
            return r1
        L_0x0065:
            android.media.MediaExtractor r2 = r8.m_extractor     // Catch:{ Exception -> 0x0096 }
            r2.seekTo(r9, r5)     // Catch:{ Exception -> 0x0096 }
        L_0x006a:
            boolean r2 = r8.m_sawInputEOS     // Catch:{ Exception -> 0x0096 }
            if (r2 != 0) goto L_0x0084
            boolean r2 = r8.m_sawOutputEOS     // Catch:{ Exception -> 0x0096 }
            if (r2 == 0) goto L_0x0073
            goto L_0x0084
        L_0x0073:
            boolean r2 = r8.m_inputBufferQueued     // Catch:{ Exception -> 0x0096 }
            if (r2 == 0) goto L_0x00b3
            android.media.MediaCodec r2 = r8.m_decoder     // Catch:{ Exception -> 0x007c }
            r2.flush()     // Catch:{ Exception -> 0x007c }
        L_0x007c:
            r8.m_inputBufferQueued = r5     // Catch:{ Exception -> 0x0096 }
            java.util.concurrent.atomic.AtomicInteger r2 = r8.m_pendingInputFrameCount     // Catch:{ Exception -> 0x0096 }
            r2.set(r5)     // Catch:{ Exception -> 0x0096 }
            goto L_0x00b3
        L_0x0084:
            r8.CleanupDecoder(r5)     // Catch:{ Exception -> 0x0096 }
            android.media.MediaFormat r2 = r8.m_format     // Catch:{ Exception -> 0x0096 }
            java.lang.String r3 = "mime"
            java.lang.String r2 = r2.getString(r3)     // Catch:{ Exception -> 0x0096 }
            boolean r0 = r8.SetupDecoder(r2)     // Catch:{ Exception -> 0x0096 }
            if (r0 != 0) goto L_0x00b3
            return r1
        L_0x0096:
            r9 = move-exception
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r11 = ""
            r10.append(r11)
            java.lang.String r11 = r9.getMessage()
            r10.append(r11)
            java.lang.String r10 = r10.toString()
            android.util.Log.e(r0, r10)
            r9.printStackTrace()
            return r1
        L_0x00b3:
            int r9 = r8.DecodeToFrame(r9, r11, r13, r14, r15)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cdv.io.NvAndroidVideoFileReader.SeekInternal(long, long, boolean, int, boolean):int");
    }

    private int DecodeToFrame(long j, long j2, boolean z, int i, boolean z2) {
        try {
            return DoDecodeToFrame(j, j2, z, i, z2);
        } catch (Exception e) {
            Log.e(TAG, "" + e.getMessage());
            e.printStackTrace();
            CleanupDecoder(false);
            return 2;
        }
    }

    private int DoDecodeToFrame(long j, long j2, boolean z, int i, boolean z2) {
        int i2;
        boolean z3;
        boolean z4;
        int max = Math.max(this.m_decoderInputBuffers.length / 3, 2);
        if (z2) {
            FeedVideoDecoderTask();
        }
        boolean z5 = false;
        int i3 = 0;
        do {
            boolean z6 = true;
            if (this.m_sawOutputEOS) {
                if (!(j == Long.MIN_VALUE || this.m_timestampOfCurTexFrame == Long.MIN_VALUE)) {
                    if (z5) {
                        return 0;
                    }
                    if (this.m_sawInputEOS) {
                        long j3 = this.m_timestampOfLastInputFrame.get();
                        if (j3 == Long.MIN_VALUE || this.m_timestampOfCurTexFrame < j3) {
                            return 1;
                        }
                        return 0;
                    }
                }
                return 1;
            } else if (isInterruptedDecoding()) {
                Log.d(TAG, "Interrupted video Decoding ");
                return 3;
            } else {
                if (!z2 && !this.m_sawInputEOS) {
                    FeedVideoDecoder(this.m_decoder.dequeueInputBuffer(4000));
                }
                int dequeueOutputBuffer = this.m_decoder.dequeueOutputBuffer(this.m_bufferInfo, (long) ((this.m_pendingInputFrameCount.get() > max || this.m_sawInputEOS || z2) ? 4000 : 0));
                i3++;
                if (!(dequeueOutputBuffer == -1 || dequeueOutputBuffer == -3)) {
                    if (dequeueOutputBuffer == -2) {
                        MediaFormat outputFormat = this.m_decoder.getOutputFormat();
                        if (outputFormat.containsKey("color-transfer")) {
                            this.m_videoColorTransferCharacteristic = outputFormat.getInteger("color-transfer");
                        }
                    } else if (dequeueOutputBuffer < 0) {
                        Log.e(TAG, "Unexpected result from decoder.dequeueOutputBuffer: " + dequeueOutputBuffer);
                        return 2;
                    } else {
                        if ((this.m_bufferInfo.flags & 4) != 0) {
                            this.m_sawOutputEOS = true;
                        }
                        if (!this.m_sawOutputEOS) {
                            this.m_timestampOfLastDecodedFrame = this.m_bufferInfo.presentationTimeUs;
                            this.m_pendingInputFrameCount.decrementAndGet();
                            if (j != Long.MIN_VALUE) {
                                z4 = this.m_timestampOfLastDecodedFrame >= j - j2;
                                if (z4 || !this.m_sawInputEOS || z) {
                                    z3 = false;
                                    i2 = 0;
                                } else {
                                    long j4 = this.m_timestampOfLastInputFrame.get();
                                    if (j4 == Long.MIN_VALUE || this.m_timestampOfLastDecodedFrame < j4) {
                                        z3 = false;
                                    } else {
                                        z5 = true;
                                        z4 = true;
                                        z3 = true;
                                    }
                                    i2 = 0;
                                }
                            } else {
                                z3 = false;
                                i2 = 0;
                                z4 = true;
                            }
                        } else {
                            z3 = false;
                            i2 = i3;
                            z4 = false;
                        }
                        if (!this.m_onlyDecodeKeyFrame) {
                            z6 = z4;
                        }
                        if (z6) {
                            if (!z) {
                                updateCurTexImage();
                            }
                            synchronized (this.m_frameSyncObject) {
                                this.m_frameAvailable = false;
                            }
                        }
                        this.m_decoder.releaseOutputBuffer(dequeueOutputBuffer, z6);
                        if (z6) {
                            boolean z7 = !z;
                            if (AwaitNewImage(z7)) {
                                this.m_timestampOfCurTexFrame = this.m_bufferInfo.presentationTimeUs;
                                this.m_curTexImageUpdated = z7;
                                if (!z3) {
                                    return 0;
                                }
                            } else {
                                Log.e(TAG, "Render decoded frame to surface texture failed!");
                                return 2;
                            }
                        }
                        i3 = i2;
                    }
                }
                if (this.m_feedDecoderStatus == 3) {
                    return 2;
                }
            }
        } while (i3 <= 100);
        Log.e(TAG, "We have tried too many times and can't decode a frame!");
        return 2;
    }

    private boolean isNonReferenceFrame(ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            return false;
        }
        byte[] bArr = new byte[5];
        int position = byteBuffer.position();
        byteBuffer.get(bArr);
        byteBuffer.position(position);
        byte b2 = bArr[4] & 31;
        if (bArr[0] == 0 && bArr[1] == 0 && bArr[2] == 0 && bArr[3] == 1 && b2 == 1 && ((bArr[4] >> 5) & 3) == 0) {
            return true;
        }
        return false;
    }

    private boolean canSkipFrame(ByteBuffer byteBuffer, long j) {
        if (byteBuffer == null || this.m_usedTemporalLayer <= 0 || j >= this.m_temporalLayerEndTime) {
            return false;
        }
        byte[] bArr = new byte[16];
        int position = byteBuffer.position();
        byteBuffer.get(bArr);
        byteBuffer.position(position);
        byte b2 = bArr[4] & 31;
        if (bArr[0] == 0 && bArr[1] == 0 && bArr[2] == 0 && bArr[3] == 1 && (b2 == 14 || b2 == 20)) {
            if (!(((bArr[5] & 255) >> 7) > 0) || (((bArr[7] & 255) >> 5) & 7) <= this.m_usedTemporalLayer) {
                return false;
            }
        } else if (this.m_usedTemporalLayer <= 0) {
            return false;
        }
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x003f, code lost:
        if (r6 == false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        r5.m_surfaceTexture.updateTexImage();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0047, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0048, code lost:
        android.util.Log.e(TAG, "" + r6.getMessage());
        r6.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0065, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:?, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean AwaitNewImage(boolean r6) {
        /*
            r5 = this;
            java.lang.Object r0 = r5.m_frameSyncObject
            monitor-enter(r0)
        L_0x0003:
            boolean r1 = r5.m_frameAvailable     // Catch:{ all -> 0x0068 }
            r2 = 0
            if (r1 != 0) goto L_0x003c
            java.lang.Object r1 = r5.m_frameSyncObject     // Catch:{ InterruptedException -> 0x001c }
            r3 = 3000(0xbb8, double:1.482E-320)
            r1.wait(r3)     // Catch:{ InterruptedException -> 0x001c }
            boolean r1 = r5.m_frameAvailable     // Catch:{ InterruptedException -> 0x001c }
            if (r1 != 0) goto L_0x0003
            java.lang.String r6 = "NvAndroidVideoFileReader"
            java.lang.String r1 = "Frame wait timed out!"
            android.util.Log.e(r6, r1)     // Catch:{ InterruptedException -> 0x001c }
            monitor-exit(r0)     // Catch:{ all -> 0x0068 }
            return r2
        L_0x001c:
            r6 = move-exception
            java.lang.String r1 = "NvAndroidVideoFileReader"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0068 }
            r3.<init>()     // Catch:{ all -> 0x0068 }
            java.lang.String r4 = ""
            r3.append(r4)     // Catch:{ all -> 0x0068 }
            java.lang.String r4 = r6.getMessage()     // Catch:{ all -> 0x0068 }
            r3.append(r4)     // Catch:{ all -> 0x0068 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0068 }
            android.util.Log.e(r1, r3)     // Catch:{ all -> 0x0068 }
            r6.printStackTrace()     // Catch:{ all -> 0x0068 }
            monitor-exit(r0)     // Catch:{ all -> 0x0068 }
            return r2
        L_0x003c:
            r5.m_frameAvailable = r2     // Catch:{ all -> 0x0068 }
            monitor-exit(r0)     // Catch:{ all -> 0x0068 }
            if (r6 == 0) goto L_0x0066
            android.graphics.SurfaceTexture r6 = r5.m_surfaceTexture     // Catch:{ Exception -> 0x0047 }
            r6.updateTexImage()     // Catch:{ Exception -> 0x0047 }
            goto L_0x0066
        L_0x0047:
            r6 = move-exception
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = ""
            r0.append(r1)
            java.lang.String r1 = r6.getMessage()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "NvAndroidVideoFileReader"
            android.util.Log.e(r1, r0)
            r6.printStackTrace()
            return r2
        L_0x0066:
            r6 = 1
            return r6
        L_0x0068:
            r6 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0068 }
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cdv.io.NvAndroidVideoFileReader.AwaitNewImage(boolean):boolean");
    }

    private void DrainOutputBuffers(boolean z) {
        if (z || (this.m_sawInputEOS && !this.m_sawOutputEOS)) {
            int i = 0;
            while (!this.m_sawOutputEOS) {
                int dequeueOutputBuffer = this.m_decoder.dequeueOutputBuffer(this.m_bufferInfo, 5000);
                i++;
                if (!(dequeueOutputBuffer == -1 || dequeueOutputBuffer == -3 || dequeueOutputBuffer == -2)) {
                    if (dequeueOutputBuffer < 0) {
                        Log.e(TAG, "DrainDecoderBuffers(): Unexpected result from decoder.dequeueOutputBuffer: " + dequeueOutputBuffer);
                        return;
                    }
                    if ((this.m_bufferInfo.flags & 4) != 0) {
                        this.m_sawOutputEOS = true;
                    }
                    this.m_decoder.releaseOutputBuffer(dequeueOutputBuffer, false);
                    i = 0;
                }
                if (i > 100) {
                    Log.e(TAG, "DrainDecoderBuffers(): We have tried too many times and can't decode a frame!");
                    return;
                }
            }
        }
    }

    private void InvalidLastSeekTimestamp() {
        this.m_lastSeekTimestamp = Long.MIN_VALUE;
        this.m_lastSeekActualTimestamp = Long.MIN_VALUE;
    }

    private boolean isInterruptedDecoding() {
        NvAndroidInterruptionChecker nvAndroidInterruptionChecker = this.m_interruptionChecker;
        if (nvAndroidInterruptionChecker == null) {
            return false;
        }
        return nvAndroidInterruptionChecker.isInterrupted();
    }

    private void CreateFeedVideoDecoderThread() {
        if (this.m_feedVideoDecoderThread == null) {
            this.m_feedVideoDecoderThread = new HandlerThread("feed video decoder handler");
            this.m_feedVideoDecoderThread.start();
            this.m_feedVideoDecoderHandler = new Handler(this.m_feedVideoDecoderThread.getLooper());
        }
    }

    private void CloseFeedVideoDecoderThread() {
        HandlerThread handlerThread = this.m_feedVideoDecoderThread;
        if (handlerThread != null) {
            if (handlerThread.isAlive()) {
                this.m_feedVideoDecoderThread.quitSafely();
            }
            try {
                this.m_feedVideoDecoderThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.m_feedVideoDecoderHandler = null;
            this.m_feedVideoDecoderThread = null;
        }
    }

    private boolean FeedVideoDecoderTask() {
        HandlerThread handlerThread = this.m_feedVideoDecoderThread;
        if (handlerThread == null || !handlerThread.isAlive()) {
            Log.e(TAG, "FeedVideoDecoderTask thread in invalid!");
            return false;
        } else if (this.m_feedDecoderStatus != 0) {
            return true;
        } else {
            this.m_feedDecoderStatus = 1;
            this.m_feedDecoderStopping = false;
            this.m_feedVideoDecoderHandler.post(new Runnable() {
                public void run() {
                    try {
                        NvAndroidVideoFileReader.this.FeedVideoDecoderInThread();
                    } catch (Exception e) {
                        Log.e(NvAndroidVideoFileReader.TAG, "" + e.getMessage());
                        e.printStackTrace();
                        int unused = NvAndroidVideoFileReader.this.m_feedDecoderStatus = 3;
                    }
                }
            });
            return true;
        }
    }

    private void BreakFeedVideoDecoder() {
        int i = this.m_feedDecoderStatus;
        if (i != 0) {
            if (i == 3) {
                this.m_feedDecoderStatus = 0;
                this.m_feedDecoderStopping = false;
                return;
            }
            this.m_feedDecoderStopping = true;
            if (this.m_inputBufferQueued && i != 2) {
                DrainOutputBuffersForFeedFinish();
            }
            System.currentTimeMillis();
            synchronized (this.m_feedDecoderSyncObject) {
                if (this.m_feedDecoderStatus != 2) {
                    try {
                        this.m_feedDecoderSyncObject.wait(30000);
                    } catch (InterruptedException e) {
                        Log.e(TAG, "" + e.getMessage());
                        e.printStackTrace();
                    }
                }
            }
            this.m_feedDecoderStatus = 0;
            this.m_feedDecoderStopping = false;
        }
    }

    /* access modifiers changed from: private */
    public void FeedVideoDecoderInThread() {
        this.m_decoderInputBuffers = this.m_decoder.getInputBuffers();
        while (!this.m_sawInputEOS) {
            int dequeueInputBuffer = this.m_decoder.dequeueInputBuffer(-1);
            if (this.m_feedDecoderStopping) {
                break;
            }
            FeedVideoDecoder(dequeueInputBuffer);
        }
        synchronized (this.m_feedDecoderSyncObject) {
            this.m_feedDecoderStatus = 2;
            this.m_feedDecoderSyncObject.notifyAll();
        }
    }

    private void FeedVideoDecoder(int i) {
        int readSampleData;
        long sampleTime;
        if (i >= 0) {
            ByteBuffer byteBuffer = this.m_decoderInputBuffers[i];
            while (true) {
                readSampleData = this.m_extractor.readSampleData(byteBuffer, 0);
                if (readSampleData < 0) {
                    this.m_decoder.queueInputBuffer(i, 0, 0, 0, 4);
                    this.m_sawInputEOS = true;
                    return;
                }
                if (this.m_extractor.getSampleTrackIndex() != this.m_videoTrackIndex) {
                    Log.w(TAG, "WEIRD: got sample from track " + this.m_extractor.getSampleTrackIndex() + ", expected " + this.m_videoTrackIndex);
                }
                sampleTime = this.m_extractor.getSampleTime();
                if (((this.m_extractor.getSampleFlags() & 1) != 0) || !canSkipFrame(byteBuffer, sampleTime)) {
                    this.m_timestampOfLastInputFrame.set(sampleTime);
                    this.m_decoder.queueInputBuffer(i, 0, readSampleData, sampleTime, 0);
                    this.m_inputBufferQueued = true;
                    this.m_pendingInputFrameCount.incrementAndGet();
                    this.m_extractor.advance();
                    this.m_extractorInOriginalState = false;
                } else {
                    this.m_extractor.advance();
                    this.m_extractorInOriginalState = false;
                }
            }
            this.m_timestampOfLastInputFrame.set(sampleTime);
            this.m_decoder.queueInputBuffer(i, 0, readSampleData, sampleTime, 0);
            this.m_inputBufferQueued = true;
            this.m_pendingInputFrameCount.incrementAndGet();
            this.m_extractor.advance();
            this.m_extractorInOriginalState = false;
        }
    }

    private void DrainOutputBuffersForFeedFinish() {
        if (!this.m_sawOutputEOS) {
            int i = 0;
            while (!this.m_sawOutputEOS) {
                int dequeueOutputBuffer = this.m_decoder.dequeueOutputBuffer(this.m_bufferInfo, 1000);
                if (this.m_feedDecoderStatus != 2) {
                    i++;
                    if (!(dequeueOutputBuffer == -1 || dequeueOutputBuffer == -3 || dequeueOutputBuffer == -2)) {
                        if (dequeueOutputBuffer < 0) {
                            Log.e(TAG, "DrainDecoderBuffers(): Unexpected result from decoder.dequeueOutputBuffer: " + dequeueOutputBuffer);
                            return;
                        }
                        if ((this.m_bufferInfo.flags & 4) != 0) {
                            this.m_sawOutputEOS = true;
                        }
                        this.m_decoder.releaseOutputBuffer(dequeueOutputBuffer, false);
                        i = 0;
                    }
                    if (i > 100) {
                        Log.e(TAG, "DrainDecoderBuffers(): We have tried too many times and can't decode a frame!");
                        return;
                    }
                } else {
                    return;
                }
            }
        }
    }
}
