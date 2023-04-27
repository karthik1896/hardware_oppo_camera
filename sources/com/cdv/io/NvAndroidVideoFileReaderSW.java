package com.cdv.io;

import android.content.Context;
import android.media.Image;
import android.media.ImageReader;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.os.Build;
import android.os.Handler;
import android.util.Log;
import android.view.Surface;
import com.cdv.utils.NvAndroidInterruptionChecker;
import com.cdv.utils.NvAndroidUtils;
import com.oppo.camera.statistics.CameraStatisticsUtil;
import java.nio.ByteBuffer;

public class NvAndroidVideoFileReaderSW {
    private static final int ERROR_EOF = 1;
    private static final int ERROR_FAIL = 2;
    private static final int ERROR_INTERRUPTED_DECODING = 3;
    private static final int ERROR_MEDIA_EXTRACTOR_PRELOAD_FAILED = 4;
    private static final int ERROR_OK = 0;
    private static final int SKIP_MODE_ALL_NONREFERENCE = 1;
    private static final int SKIP_MODE_BELOW_TIMESTAMP = 2;
    private static final int SKIP_MODE_NONE = 0;
    private static final String TAG = "NvAndroidVideoFileReaderSW";
    private static final boolean m_verbose = false;
    private MediaCodec.BufferInfo m_bufferInfo = null;
    private Handler m_cleanupHandler = null;
    private long m_contiuousDecodingThreshold = 1000000;
    private MediaCodec m_decoder = null;
    ByteBuffer[] m_decoderInputBuffers = null;
    ByteBuffer[] m_decoderOutputBuffers = null;
    private boolean m_decoderSetupFailed = false;
    private boolean m_decoderStarted = false;
    private boolean m_decoderUseSurface = false;
    private long m_duration = 0;
    private MediaExtractor m_extractor = null;
    private boolean m_extractorInOriginalState = true;
    private MediaFormat m_format = null;
    /* access modifiers changed from: private */
    public Object m_frameSyncObject = new Object();
    private Handler m_handler = null;
    private ImageReader m_imageReader = null;
    /* access modifiers changed from: private */
    public boolean m_imageReady = false;
    private boolean m_inputBufferQueued = false;
    private NvAndroidInterruptionChecker m_interruptionChecker;
    private long m_lastSeekActualTimestamp = Long.MIN_VALUE;
    private long m_lastSeekTimestamp = Long.MIN_VALUE;
    private boolean m_onlyDecodeKeyFrame = false;
    private long m_owner = 0;
    private int m_pendingInputFrameCount = 0;
    private long m_preloadedTimestamp = Long.MIN_VALUE;
    private boolean m_sawInputEOS = false;
    private boolean m_sawOutputEOS = false;
    private boolean m_skipNonReferenceFrameWhenPlayback = false;
    private long m_timestampOfLastCopiedFrame = Long.MIN_VALUE;
    private long m_timestampOfLastDecodedFrame = Long.MIN_VALUE;
    private int m_videoColorTransferCharacteristic = 0;
    private int m_videoTrackIndex = -1;

    private native void nativeCopyVideoFrame(long j, ByteBuffer byteBuffer, int i, int i2, long j2);

    private native void nativeCopyVideoFrameFromYUV420ImagePlanes(long j, int i, int i2, int i3, int i4, ByteBuffer byteBuffer, int i5, int i6, ByteBuffer byteBuffer2, int i7, int i8, ByteBuffer byteBuffer3, int i9, int i10, long j2);

    private native void nativeSetFormatInfo(long j, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9);

    NvAndroidVideoFileReaderSW(long j, Handler handler, Handler handler2) {
        this.m_owner = j;
        this.m_handler = handler;
        this.m_cleanupHandler = handler2;
        this.m_bufferInfo = new MediaCodec.BufferInfo();
    }

    public boolean OpenFile(String str, Context context, int i, long j) {
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
        int trackCount = mediaExtractor.getTrackCount();
        int i2 = 0;
        while (true) {
            if (i2 >= trackCount) {
                break;
            } else if (this.m_extractor.getTrackFormat(i2).getString("mime").startsWith("video/")) {
                this.m_videoTrackIndex = i2;
                break;
            } else {
                i2++;
            }
        }
        int i3 = this.m_videoTrackIndex;
        if (i3 < 0) {
            Log.e(TAG, "Failed to find a video track from " + str);
            CloseFile();
            return false;
        }
        this.m_extractor.selectTrack(i3);
        this.m_format = this.m_extractor.getTrackFormat(this.m_videoTrackIndex);
        if (Build.VERSION.SDK_INT == 16) {
            this.m_format.setInteger("max-input-size", 0);
        }
        boolean equals = Build.HARDWARE.equals("qcom");
        if (Build.VERSION.SDK_INT >= 23 && i >= 0 && !equals) {
            MediaFormat mediaFormat = this.m_format;
            if (i <= 0) {
                i = 120;
            }
            mediaFormat.setInteger("operating-rate", i);
        }
        try {
            this.m_duration = this.m_format.getLong("durationUs");
            String string = this.m_format.getString("mime");
            if (equals && this.m_format.containsKey("frame-rate")) {
                this.m_format.setInteger("frame-rate", 0);
            }
            this.m_videoColorTransferCharacteristic = 3;
            if (this.m_format.containsKey("color-transfer")) {
                this.m_videoColorTransferCharacteristic = this.m_format.getInteger("color-transfer");
            }
            this.m_decoderSetupFailed = false;
            if (!SetupDecoder(string)) {
                this.m_decoderSetupFailed = true;
                CloseFile();
                return false;
            }
            this.m_contiuousDecodingThreshold = j;
            return true;
        } catch (Exception e) {
            Log.e(TAG, "" + e.getMessage());
            e.printStackTrace();
            CloseFile();
            return false;
        }
    }

    public void preload(long j) {
        int preloadInternal = preloadInternal(j);
        int i = 0;
        while (preloadInternal == 4) {
            this.m_timestampOfLastDecodedFrame = Long.MIN_VALUE;
            preloadInternal = preloadInternal(j);
            i++;
            Log.w(TAG, "Try to preload! times=" + i);
            if (i >= 2) {
                break;
            }
        }
        if (preloadInternal == 4) {
            Log.w(TAG, "Try to recreate MediaExtractor after preload!");
            this.m_timestampOfLastDecodedFrame = Long.MIN_VALUE;
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
        CleanupDecoder(true);
        MediaExtractor mediaExtractor = this.m_extractor;
        if (mediaExtractor != null) {
            mediaExtractor.release();
            this.m_extractor = null;
            this.m_videoTrackIndex = -1;
            this.m_format = null;
            this.m_duration = 0;
            this.m_extractorInOriginalState = true;
            this.m_onlyDecodeKeyFrame = false;
        }
    }

    public int SeekVideoFrame(long j, long j2) {
        if (!IsValid()) {
            return 1;
        }
        long max = Math.max(j, 0);
        long j3 = this.m_duration;
        if (max >= j3) {
            if (max >= 25000 + j3) {
                return 1;
            }
            max = j3 - 1;
        }
        long j4 = this.m_timestampOfLastCopiedFrame;
        if (j4 != Long.MIN_VALUE && Math.abs(max - j4) <= j2) {
            return 0;
        }
        int SeekInternal = SeekInternal(max, j2, this.m_onlyDecodeKeyFrame ? 0 : 2);
        if (SeekInternal == 0) {
            this.m_lastSeekTimestamp = max;
            this.m_lastSeekActualTimestamp = this.m_timestampOfLastCopiedFrame;
        } else {
            InvalidLastSeekTimestamp();
        }
        return SeekInternal;
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x004a A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x004c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int StartPlayback(long r10, long r12) {
        /*
            r9 = this;
            boolean r0 = r9.IsValid()
            r1 = 1
            if (r0 != 0) goto L_0x0008
            return r1
        L_0x0008:
            r2 = 0
            long r10 = java.lang.Math.max(r10, r2)
            long r2 = r9.m_duration
            int r0 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r0 < 0) goto L_0x0015
            return r1
        L_0x0015:
            long r0 = r9.m_preloadedTimestamp
            r2 = -9223372036854775808
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 == 0) goto L_0x002b
            int r0 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r0 < 0) goto L_0x0028
            long r0 = r9.m_timestampOfLastCopiedFrame
            int r4 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r4 > 0) goto L_0x0028
            r10 = r0
        L_0x0028:
            r9.m_preloadedTimestamp = r2
            goto L_0x003d
        L_0x002b:
            long r0 = r9.m_lastSeekTimestamp
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 == 0) goto L_0x003d
            int r0 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r0 != 0) goto L_0x003d
            long r0 = r9.m_lastSeekActualTimestamp
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 == 0) goto L_0x003d
            r4 = r0
            goto L_0x003e
        L_0x003d:
            r4 = r10
        L_0x003e:
            long r10 = r9.m_timestampOfLastCopiedFrame
            int r0 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1))
            if (r0 != 0) goto L_0x004c
            long r0 = r9.m_timestampOfLastDecodedFrame
            int r10 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r10 != 0) goto L_0x004c
            r10 = 0
            return r10
        L_0x004c:
            r8 = 2
            r3 = r9
            r6 = r12
            int r10 = r3.SeekInternal(r4, r6, r8)
            r9.InvalidLastSeekTimestamp()
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cdv.io.NvAndroidVideoFileReaderSW.StartPlayback(long, long):int");
    }

    public int GetNextVideoFrameForPlayback() {
        if (!IsValid()) {
            return 1;
        }
        int DecodeToFrame = DecodeToFrame(Long.MIN_VALUE, 0, this.m_skipNonReferenceFrameWhenPlayback ? 1 : 0);
        InvalidLastSeekTimestamp();
        return DecodeToFrame;
    }

    public int GetVideoColorTransfer() {
        return this.m_videoColorTransferCharacteristic;
    }

    private boolean IsValid() {
        return this.m_decoder != null;
    }

    private boolean preferDecodeToImageReader(String str) {
        if (!Build.MANUFACTURER.equals("OPPO") || !Build.MODEL.equals("R15")) {
            return false;
        }
        return str.equals("video/mpeg2");
    }

    private int preloadInternal(long j) {
        if (!IsValid()) {
            return 2;
        }
        long max = Math.max(Math.min(j, this.m_duration - 1), 0);
        int SeekInternal = SeekInternal(max, 0, 2);
        if (SeekInternal == 0) {
            if (this.m_timestampOfLastCopiedFrame == Long.MIN_VALUE) {
                return SeekInternal;
            }
            this.m_preloadedTimestamp = max;
            return SeekInternal;
        } else if (SeekInternal != 1 || this.m_timestampOfLastCopiedFrame != Long.MIN_VALUE) {
            return SeekInternal;
        } else {
            long j2 = this.m_timestampOfLastDecodedFrame;
            if (j2 == Long.MIN_VALUE || j2 >= this.m_duration - 100000) {
                return SeekInternal;
            }
            return 4;
        }
    }

    private boolean SetupDecoder(String str) {
        if (!preferDecodeToImageReader(str) || !setupDecoderWithImageReader(str)) {
            return setupDecoderWithBuffers(str);
        }
        return true;
    }

    private boolean setupDecoderWithBuffers(String str) {
        try {
            this.m_decoder = MediaCodec.createDecoderByType(str);
            this.m_decoder.configure(this.m_format, (Surface) null, (MediaCrypto) null, 0);
            this.m_decoder.start();
            this.m_decoderStarted = true;
            this.m_decoderInputBuffers = this.m_decoder.getInputBuffers();
            this.m_decoderOutputBuffers = this.m_decoder.getOutputBuffers();
            return true;
        } catch (Exception e) {
            Log.e(TAG, "" + e.getMessage());
            e.printStackTrace();
            CleanupDecoder(false);
            return false;
        }
    }

    private boolean setupDecoderWithImageReader(String str) {
        boolean z;
        if (Build.VERSION.SDK_INT < 19) {
            return false;
        }
        try {
            this.m_decoder = MediaCodec.createDecoderByType(str);
            int[] iArr = this.m_decoder.getCodecInfo().getCapabilitiesForType(str).colorFormats;
            int length = iArr.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    z = false;
                    break;
                } else if (iArr[i] == 2135033992) {
                    z = true;
                    break;
                } else {
                    i++;
                }
            }
            if (!z) {
                Log.w(TAG, "We can't decode to ImageReader if COLOR_FormatYUV420Flexible is not supported!");
                this.m_decoder.release();
                this.m_decoder = null;
                return false;
            }
            this.m_format.setInteger("color-format", 2135033992);
            this.m_imageReader = ImageReader.newInstance(this.m_format.getInteger(CameraStatisticsUtil.IMAGE_WIDTH), this.m_format.getInteger(CameraStatisticsUtil.IMAGE_HEIGHT), 35, 1);
            this.m_imageReader.setOnImageAvailableListener(new ImageReader.OnImageAvailableListener() {
                public void onImageAvailable(ImageReader imageReader) {
                    synchronized (NvAndroidVideoFileReaderSW.this.m_frameSyncObject) {
                        boolean unused = NvAndroidVideoFileReaderSW.this.m_imageReady = true;
                        NvAndroidVideoFileReaderSW.this.m_frameSyncObject.notifyAll();
                    }
                }
            }, this.m_handler);
            this.m_decoder.configure(this.m_format, this.m_imageReader.getSurface(), (MediaCrypto) null, 0);
            this.m_decoder.start();
            this.m_decoderStarted = true;
            this.m_decoderUseSurface = true;
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
        if (this.m_decoder != null && this.m_decoderStarted) {
            try {
                if (this.m_sawInputEOS && !this.m_sawOutputEOS) {
                    DrainOutputBuffers();
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
                    NvAndroidVideoFileReaderSW.this.CleanupDecoderCore(true);
                }
            });
        }
        this.m_timestampOfLastDecodedFrame = Long.MIN_VALUE;
        this.m_timestampOfLastCopiedFrame = Long.MIN_VALUE;
        this.m_pendingInputFrameCount = 0;
        this.m_sawInputEOS = false;
        this.m_sawOutputEOS = false;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Can't wrap try/catch for region: R(4:7|8|9|10) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0011 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void CleanupDecoderCore(boolean r5) {
        /*
            r4 = this;
            android.media.MediaCodec r5 = r4.m_decoder
            r0 = 0
            r1 = 0
            if (r5 == 0) goto L_0x0042
            boolean r2 = r4.m_decoderStarted
            if (r2 == 0) goto L_0x003b
            boolean r2 = r4.m_inputBufferQueued     // Catch:{ Exception -> 0x0019 }
            if (r2 == 0) goto L_0x0013
            r5.flush()     // Catch:{ Exception -> 0x0011 }
        L_0x0011:
            r4.m_inputBufferQueued = r1     // Catch:{ Exception -> 0x0019 }
        L_0x0013:
            android.media.MediaCodec r5 = r4.m_decoder     // Catch:{ Exception -> 0x0019 }
            r5.stop()     // Catch:{ Exception -> 0x0019 }
            goto L_0x0037
        L_0x0019:
            r5 = move-exception
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = ""
            r2.append(r3)
            java.lang.String r3 = r5.getMessage()
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            java.lang.String r3 = "NvAndroidVideoFileReaderSW"
            android.util.Log.e(r3, r2)
            r5.printStackTrace()
        L_0x0037:
            r4.m_decoderStarted = r1
            r4.m_decoderInputBuffers = r0
        L_0x003b:
            android.media.MediaCodec r5 = r4.m_decoder
            r5.release()
            r4.m_decoder = r0
        L_0x0042:
            android.media.ImageReader r5 = r4.m_imageReader
            if (r5 == 0) goto L_0x004b
            r5.close()
            r4.m_imageReader = r0
        L_0x004b:
            r4.m_decoderUseSurface = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cdv.io.NvAndroidVideoFileReaderSW.CleanupDecoderCore(boolean):void");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:24|25|26|27) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:26:0x0041 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int SeekInternal(long r8, long r10, int r12) {
        /*
            r7 = this;
            long r0 = r7.m_timestampOfLastDecodedFrame
            r2 = -9223372036854775808
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L_0x0016
            int r2 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            if (r2 <= 0) goto L_0x0016
            long r5 = r7.m_contiuousDecodingThreshold
            long r0 = r0 + r5
            int r0 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            if (r0 >= 0) goto L_0x0016
            goto L_0x0022
        L_0x0016:
            boolean r0 = r7.m_extractorInOriginalState
            if (r0 == 0) goto L_0x0021
            long r0 = r7.m_contiuousDecodingThreshold
            int r0 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            if (r0 >= 0) goto L_0x0021
            goto L_0x0022
        L_0x0021:
            r3 = r4
        L_0x0022:
            boolean r0 = r7.m_onlyDecodeKeyFrame
            if (r0 == 0) goto L_0x0027
            r3 = r4
        L_0x0027:
            if (r3 != 0) goto L_0x0077
            r0 = 2
            android.media.MediaExtractor r1 = r7.m_extractor     // Catch:{ Exception -> 0x0058 }
            r1.seekTo(r8, r4)     // Catch:{ Exception -> 0x0058 }
            boolean r1 = r7.m_sawInputEOS     // Catch:{ Exception -> 0x0058 }
            if (r1 != 0) goto L_0x0046
            boolean r1 = r7.m_sawOutputEOS     // Catch:{ Exception -> 0x0058 }
            if (r1 == 0) goto L_0x0038
            goto L_0x0046
        L_0x0038:
            boolean r1 = r7.m_inputBufferQueued     // Catch:{ Exception -> 0x0058 }
            if (r1 == 0) goto L_0x0077
            android.media.MediaCodec r1 = r7.m_decoder     // Catch:{ Exception -> 0x0041 }
            r1.flush()     // Catch:{ Exception -> 0x0041 }
        L_0x0041:
            r7.m_inputBufferQueued = r4     // Catch:{ Exception -> 0x0058 }
            r7.m_pendingInputFrameCount = r4     // Catch:{ Exception -> 0x0058 }
            goto L_0x0077
        L_0x0046:
            r7.CleanupDecoder(r4)     // Catch:{ Exception -> 0x0058 }
            android.media.MediaFormat r1 = r7.m_format     // Catch:{ Exception -> 0x0058 }
            java.lang.String r2 = "mime"
            java.lang.String r1 = r1.getString(r2)     // Catch:{ Exception -> 0x0058 }
            boolean r1 = r7.SetupDecoder(r1)     // Catch:{ Exception -> 0x0058 }
            if (r1 != 0) goto L_0x0077
            return r0
        L_0x0058:
            r8 = move-exception
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = ""
            r9.append(r10)
            java.lang.String r10 = r8.getMessage()
            r9.append(r10)
            java.lang.String r9 = r9.toString()
            java.lang.String r10 = "NvAndroidVideoFileReaderSW"
            android.util.Log.e(r10, r9)
            r8.printStackTrace()
            return r0
        L_0x0077:
            int r8 = r7.DecodeToFrame(r8, r10, r12)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cdv.io.NvAndroidVideoFileReaderSW.SeekInternal(long, long, int):int");
    }

    private int DecodeToFrame(long j, long j2, int i) {
        try {
            return DoDecodeToFrame(j, j2, i);
        } catch (Exception e) {
            Log.e(TAG, "" + e.getMessage());
            e.printStackTrace();
            CleanupDecoder(false);
            return 2;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:114:0x02a1 A[LOOP:0: B:1:0x0010->B:114:0x02a1, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x0299 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int DoDecodeToFrame(long r30, long r32, int r34) {
        /*
            r29 = this;
            r15 = r29
            r0 = r34
            java.nio.ByteBuffer[] r1 = r15.m_decoderInputBuffers
            int r1 = r1.length
            r14 = 3
            int r1 = r1 / r14
            r13 = 2
            int r12 = java.lang.Math.max(r1, r13)
            r11 = 0
            r1 = r11
        L_0x0010:
            boolean r2 = r15.m_sawOutputEOS
            r3 = 100000(0x186a0, double:4.94066E-319)
            r5 = -9223372036854775808
            r10 = 1
            if (r2 != 0) goto L_0x02af
            boolean r2 = r29.isInterruptedDecoding()
            if (r2 == 0) goto L_0x0021
            return r14
        L_0x0021:
            boolean r2 = r15.m_sawInputEOS
            if (r2 != 0) goto L_0x00d5
            android.media.MediaCodec r2 = r15.m_decoder
            r7 = 4000(0xfa0, double:1.9763E-320)
            int r17 = r2.dequeueInputBuffer(r7)
            if (r17 < 0) goto L_0x00d5
            java.nio.ByteBuffer[] r2 = r15.m_decoderInputBuffers
            r2 = r2[r17]
        L_0x0033:
            android.media.MediaExtractor r7 = r15.m_extractor
            int r19 = r7.readSampleData(r2, r11)
            if (r19 >= 0) goto L_0x004e
            android.media.MediaCodec r2 = r15.m_decoder
            r18 = 0
            r19 = 0
            r20 = 0
            r22 = 4
            r16 = r2
            r16.queueInputBuffer(r17, r18, r19, r20, r22)
            r15.m_sawInputEOS = r10
            goto L_0x00d5
        L_0x004e:
            android.media.MediaExtractor r7 = r15.m_extractor
            int r7 = r7.getSampleTrackIndex()
            int r8 = r15.m_videoTrackIndex
            if (r7 == r8) goto L_0x007e
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "WEIRD: got sample from track "
            r7.append(r8)
            android.media.MediaExtractor r8 = r15.m_extractor
            int r8 = r8.getSampleTrackIndex()
            r7.append(r8)
            java.lang.String r8 = ", expected "
            r7.append(r8)
            int r8 = r15.m_videoTrackIndex
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            java.lang.String r8 = "NvAndroidVideoFileReaderSW"
            android.util.Log.w(r8, r7)
        L_0x007e:
            android.media.MediaExtractor r7 = r15.m_extractor
            long r7 = r7.getSampleTime()
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r14 = "read sample from readeer:"
            r9.append(r14)
            r9.append(r7)
            java.lang.String r9 = r9.toString()
            java.lang.String r14 = "NvAndroidVideoFileReaderSW"
            android.util.Log.d(r14, r9)
            if (r0 != r10) goto L_0x009e
        L_0x009c:
            r9 = r10
            goto L_0x00a8
        L_0x009e:
            if (r0 != r13) goto L_0x00a7
            long r20 = r30 - r32
            int r9 = (r7 > r20 ? 1 : (r7 == r20 ? 0 : -1))
            if (r9 >= 0) goto L_0x00a7
            goto L_0x009c
        L_0x00a7:
            r9 = r11
        L_0x00a8:
            if (r9 == 0) goto L_0x00ba
            boolean r9 = r15.isNonReferenceFrame(r2)
            if (r9 == 0) goto L_0x00ba
            android.media.MediaExtractor r7 = r15.m_extractor
            r7.advance()
            r15.m_extractorInOriginalState = r11
            r14 = 3
            goto L_0x0033
        L_0x00ba:
            android.media.MediaCodec r2 = r15.m_decoder
            r18 = 0
            r22 = 0
            r16 = r2
            r20 = r7
            r16.queueInputBuffer(r17, r18, r19, r20, r22)
            r15.m_inputBufferQueued = r10
            int r2 = r15.m_pendingInputFrameCount
            int r2 = r2 + r10
            r15.m_pendingInputFrameCount = r2
            android.media.MediaExtractor r2 = r15.m_extractor
            r2.advance()
            r15.m_extractorInOriginalState = r11
        L_0x00d5:
            int r2 = r15.m_pendingInputFrameCount
            if (r2 > r12) goto L_0x00e0
            boolean r2 = r15.m_sawInputEOS
            if (r2 == 0) goto L_0x00de
            goto L_0x00e0
        L_0x00de:
            r2 = r11
            goto L_0x00e2
        L_0x00e0:
            r2 = 4000(0xfa0, float:5.605E-42)
        L_0x00e2:
            android.media.MediaCodec r7 = r15.m_decoder
            android.media.MediaCodec$BufferInfo r8 = r15.m_bufferInfo
            r14 = r12
            long r11 = (long) r2
            int r9 = r7.dequeueOutputBuffer(r8, r11)
            int r11 = r1 + 1
            r1 = -1
            if (r9 != r1) goto L_0x00f2
            goto L_0x011a
        L_0x00f2:
            r1 = -3
            if (r9 != r1) goto L_0x00fe
            android.media.MediaCodec r1 = r15.m_decoder
            java.nio.ByteBuffer[] r1 = r1.getOutputBuffers()
            r15.m_decoderOutputBuffers = r1
            goto L_0x011a
        L_0x00fe:
            r1 = -2
            if (r9 != r1) goto L_0x0125
            android.media.MediaCodec r1 = r15.m_decoder
            android.media.MediaFormat r1 = r1.getOutputFormat()
            java.lang.String r2 = "color-transfer"
            boolean r2 = r1.containsKey(r2)
            if (r2 == 0) goto L_0x0117
            java.lang.String r2 = "color-transfer"
            int r2 = r1.getInteger(r2)
            r15.m_videoColorTransferCharacteristic = r2
        L_0x0117:
            r15.ParseMediaFormat(r1)
        L_0x011a:
            r25 = r13
            r23 = r14
            r1 = r15
            r22 = 0
            r26 = 3
            goto L_0x0295
        L_0x0125:
            if (r9 >= 0) goto L_0x013e
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Unexpected result from decoder.dequeueOutputBuffer: "
            r0.append(r1)
            r0.append(r9)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "NvAndroidVideoFileReaderSW"
            android.util.Log.e(r1, r0)
            return r13
        L_0x013e:
            android.media.MediaCodec$BufferInfo r1 = r15.m_bufferInfo
            int r1 = r1.flags
            r1 = r1 & 4
            if (r1 == 0) goto L_0x0148
            r15.m_sawOutputEOS = r10
        L_0x0148:
            android.media.MediaCodec$BufferInfo r1 = r15.m_bufferInfo
            int r1 = r1.size
            if (r1 == 0) goto L_0x018a
            android.media.MediaCodec$BufferInfo r1 = r15.m_bufferInfo
            long r1 = r1.presentationTimeUs
            r15.m_timestampOfLastDecodedFrame = r1
            int r1 = r15.m_pendingInputFrameCount
            int r1 = r1 - r10
            r15.m_pendingInputFrameCount = r1
            int r1 = (r30 > r5 ? 1 : (r30 == r5 ? 0 : -1))
            if (r1 == 0) goto L_0x0184
            long r1 = r15.m_timestampOfLastDecodedFrame
            long r5 = r30 - r32
            int r1 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r1 < 0) goto L_0x0167
            r1 = r10
            goto L_0x0168
        L_0x0167:
            r1 = 0
        L_0x0168:
            if (r1 != 0) goto L_0x0176
            long r5 = r15.m_timestampOfLastDecodedFrame
            long r7 = r15.m_duration
            long r7 = r7 - r3
            int r2 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r2 < 0) goto L_0x0176
            r1 = r10
            r11 = r1
            goto L_0x0178
        L_0x0176:
            r11 = r1
            r1 = 0
        L_0x0178:
            boolean r2 = r15.m_onlyDecodeKeyFrame
            if (r2 == 0) goto L_0x0180
            r19 = r1
            r12 = r10
            goto L_0x0187
        L_0x0180:
            r19 = r1
            r12 = r11
            goto L_0x0187
        L_0x0184:
            r12 = r10
            r19 = 0
        L_0x0187:
            r20 = 0
            goto L_0x018f
        L_0x018a:
            r20 = r11
            r12 = 0
            r19 = 0
        L_0x018f:
            boolean r1 = r15.m_decoderUseSurface
            if (r1 != 0) goto L_0x01bf
            if (r12 == 0) goto L_0x01ae
            long r2 = r15.m_owner
            java.nio.ByteBuffer[] r1 = r15.m_decoderOutputBuffers
            r4 = r1[r9]
            android.media.MediaCodec$BufferInfo r1 = r15.m_bufferInfo
            int r5 = r1.offset
            android.media.MediaCodec$BufferInfo r1 = r15.m_bufferInfo
            int r6 = r1.size
            long r7 = r15.m_timestampOfLastDecodedFrame
            r1 = r29
            r1.nativeCopyVideoFrame(r2, r4, r5, r6, r7)
            long r1 = r15.m_timestampOfLastDecodedFrame
            r15.m_timestampOfLastCopiedFrame = r1
        L_0x01ae:
            android.media.MediaCodec r1 = r15.m_decoder
            r2 = 0
            r1.releaseOutputBuffer(r9, r2)
            r22 = r2
            r24 = r12
            r25 = r13
            r23 = r14
            r1 = r15
            goto L_0x028c
        L_0x01bf:
            r2 = 0
            if (r12 == 0) goto L_0x01cc
            java.lang.Object r1 = r15.m_frameSyncObject
            monitor-enter(r1)
            r15.m_imageReady = r2     // Catch:{ all -> 0x01c9 }
            monitor-exit(r1)     // Catch:{ all -> 0x01c9 }
            goto L_0x01cc
        L_0x01c9:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x01c9 }
            throw r0
        L_0x01cc:
            android.media.MediaCodec r1 = r15.m_decoder
            r1.releaseOutputBuffer(r9, r12)
            if (r12 == 0) goto L_0x0283
            android.media.Image r21 = r29.AwaitNewImage()
            if (r21 == 0) goto L_0x0278
            int r1 = r21.getWidth()
            int r2 = r21.getHeight()
            int r3 = android.os.Build.VERSION.SDK_INT
            r4 = 21
            if (r3 < r4) goto L_0x01ec
            android.graphics.Rect r1 = r21.getCropRect()
            goto L_0x01f3
        L_0x01ec:
            android.graphics.Rect r3 = new android.graphics.Rect
            r4 = 0
            r3.<init>(r4, r4, r1, r2)
            r1 = r3
        L_0x01f3:
            android.media.Image$Plane[] r11 = r21.getPlanes()
            int r2 = r11.length
            r9 = 3
            if (r2 != r9) goto L_0x0269
            long r2 = r15.m_owner
            int r4 = r1.left
            int r5 = r1.top
            int r6 = r1.right
            int r7 = r1.bottom
            r1 = 0
            r8 = r11[r1]
            java.nio.ByteBuffer r8 = r8.getBuffer()
            r16 = r11[r1]
            int r16 = r16.getRowStride()
            r17 = r9
            r9 = r16
            r16 = r11[r1]
            int r16 = r16.getPixelStride()
            r18 = r10
            r10 = r16
            r16 = r11[r18]
            java.nio.ByteBuffer r16 = r16.getBuffer()
            r22 = r1
            r1 = r11
            r11 = r16
            r16 = r1[r18]
            int r16 = r16.getRowStride()
            r24 = r12
            r23 = r14
            r12 = r16
            r14 = r1[r18]
            int r14 = r14.getPixelStride()
            r25 = r13
            r13 = r14
            r14 = r1[r25]
            java.nio.ByteBuffer r14 = r14.getBuffer()
            r26 = r17
            r16 = r1[r25]
            int r16 = r16.getRowStride()
            r27 = r2
            r2 = r15
            r15 = r16
            r1 = r1[r25]
            int r16 = r1.getPixelStride()
            long r0 = r2.m_timestampOfLastDecodedFrame
            r17 = r0
            r1 = r29
            r2 = r27
            r1.nativeCopyVideoFrameFromYUV420ImagePlanes(r2, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17)
            long r2 = r1.m_timestampOfLastDecodedFrame
            r1.m_timestampOfLastCopiedFrame = r2
            goto L_0x0274
        L_0x0269:
            r26 = r9
            r24 = r12
            r25 = r13
            r23 = r14
            r1 = r15
            r22 = 0
        L_0x0274:
            r21.close()
            goto L_0x028e
        L_0x0278:
            r25 = r13
            r1 = r15
            java.lang.String r0 = "NvAndroidVideoFileReaderSW"
            java.lang.String r2 = "Render decoded frame to ImageReader failed!"
            android.util.Log.e(r0, r2)
            return r25
        L_0x0283:
            r24 = r12
            r25 = r13
            r23 = r14
            r1 = r15
            r22 = 0
        L_0x028c:
            r26 = 3
        L_0x028e:
            if (r24 == 0) goto L_0x0293
            if (r19 != 0) goto L_0x0293
            return r22
        L_0x0293:
            r11 = r20
        L_0x0295:
            r0 = 100
            if (r11 <= r0) goto L_0x02a1
            java.lang.String r0 = "NvAndroidVideoFileReaderSW"
            java.lang.String r2 = "We have tried too many times and can't decode a frame!"
            android.util.Log.e(r0, r2)
            return r25
        L_0x02a1:
            r0 = r34
            r15 = r1
            r1 = r11
            r11 = r22
            r12 = r23
            r13 = r25
            r14 = r26
            goto L_0x0010
        L_0x02af:
            r18 = r10
            r22 = r11
            r1 = r15
            int r0 = (r30 > r5 ? 1 : (r30 == r5 ? 0 : -1))
            if (r0 == 0) goto L_0x02c6
            long r7 = r1.m_timestampOfLastCopiedFrame
            int r0 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r0 == 0) goto L_0x02c6
            long r5 = r1.m_duration
            long r5 = r5 - r3
            int r0 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r0 < 0) goto L_0x02c6
            return r22
        L_0x02c6:
            return r18
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cdv.io.NvAndroidVideoFileReaderSW.DoDecodeToFrame(long, long, int):int");
    }

    private Image AwaitNewImage() {
        synchronized (this.m_frameSyncObject) {
            do {
                if (!this.m_imageReady) {
                    try {
                        this.m_frameSyncObject.wait(3000);
                    } catch (InterruptedException e) {
                        Log.e(TAG, "" + e.getMessage());
                        e.printStackTrace();
                        return null;
                    }
                } else {
                    this.m_imageReady = false;
                    try {
                        return this.m_imageReader.acquireLatestImage();
                    } catch (Exception e2) {
                        Log.e(TAG, "" + e2.getMessage());
                        e2.printStackTrace();
                        return null;
                    }
                }
            } while (this.m_imageReady);
            Log.e(TAG, "ImageReader wait timed out!");
            return null;
        }
    }

    private void DrainOutputBuffers() {
        if (this.m_sawInputEOS && !this.m_sawOutputEOS) {
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

    /* JADX WARNING: Removed duplicated region for block: B:35:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x009a  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00a3  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00a8  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00b3  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00b9  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00c2  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00c8  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void ParseMediaFormat(android.media.MediaFormat r14) {
        /*
            r13 = this;
            java.lang.String r1 = "width"
            boolean r2 = r14.containsKey(r1)
            if (r2 == 0) goto L_0x00e0
            java.lang.String r2 = "height"
            boolean r3 = r14.containsKey(r2)
            if (r3 == 0) goto L_0x00e0
            java.lang.String r3 = "color-format"
            boolean r4 = r14.containsKey(r3)
            if (r4 != 0) goto L_0x001a
            goto L_0x00e0
        L_0x001a:
            int r1 = r14.getInteger(r1)
            int r2 = r14.getInteger(r2)
            int r3 = r14.getInteger(r3)
            int r4 = android.os.Build.VERSION.SDK_INT
            r5 = 18
            if (r4 < r5) goto L_0x0041
            android.media.MediaCodec r4 = r13.m_decoder
            java.lang.String r4 = r4.getName()
            r6 = 25
            if (r3 != r6) goto L_0x0041
            java.lang.String r6 = "OMX.k3.video.decoder.avc"
            boolean r4 = r4.equals(r6)
            if (r4 == 0) goto L_0x0041
            r3 = 2130706688(0x7f000100, float:1.7014638E38)
        L_0x0041:
            r6 = r3
            int r3 = android.os.Build.VERSION.SDK_INT
            r4 = 23
            if (r3 < r4) goto L_0x0065
            java.lang.String r3 = "slice-height"
            boolean r4 = r14.containsKey(r3)
            if (r4 == 0) goto L_0x0055
            int r3 = r14.getInteger(r3)
            goto L_0x0056
        L_0x0055:
            r3 = r2
        L_0x0056:
            java.lang.String r4 = "stride"
            boolean r7 = r14.containsKey(r4)
            if (r7 == 0) goto L_0x0063
            int r4 = r14.getInteger(r4)
            goto L_0x0067
        L_0x0063:
            r4 = r1
            goto L_0x0067
        L_0x0065:
            r4 = r1
            r3 = r2
        L_0x0067:
            int r7 = android.os.Build.VERSION.SDK_INT
            if (r7 < r5) goto L_0x0089
            android.media.MediaCodec r5 = r13.m_decoder
            java.lang.String r5 = r5.getName()
            java.lang.String r7 = "OMX.Nvidia."
            boolean r7 = r5.startsWith(r7)
            if (r7 == 0) goto L_0x007e
            int r3 = r3 + 15
            r3 = r3 & -16
            goto L_0x0089
        L_0x007e:
            java.lang.String r7 = "OMX.SEC.avc.dec"
            boolean r5 = r5.startsWith(r7)
            if (r5 == 0) goto L_0x0089
            r8 = r1
            r7 = r2
            goto L_0x008b
        L_0x0089:
            r7 = r3
            r8 = r4
        L_0x008b:
            java.lang.String r3 = "crop-left"
            boolean r4 = r14.containsKey(r3)
            r5 = 0
            if (r4 == 0) goto L_0x009a
            int r3 = r14.getInteger(r3)
            r9 = r3
            goto L_0x009b
        L_0x009a:
            r9 = r5
        L_0x009b:
            java.lang.String r3 = "crop-right"
            boolean r4 = r14.containsKey(r3)
            if (r4 == 0) goto L_0x00a8
            int r1 = r14.getInteger(r3)
            goto L_0x00aa
        L_0x00a8:
            int r1 = r1 + -1
        L_0x00aa:
            r10 = r1
            java.lang.String r1 = "crop-top"
            boolean r3 = r14.containsKey(r1)
            if (r3 == 0) goto L_0x00b9
            int r1 = r14.getInteger(r1)
            r11 = r1
            goto L_0x00ba
        L_0x00b9:
            r11 = r5
        L_0x00ba:
            java.lang.String r1 = "crop-bottom"
            boolean r3 = r14.containsKey(r1)
            if (r3 == 0) goto L_0x00c8
            int r0 = r14.getInteger(r1)
            r12 = r0
            goto L_0x00cb
        L_0x00c8:
            int r2 = r2 + -1
            r12 = r2
        L_0x00cb:
            int r0 = r10 + 1
            int r3 = r0 - r9
            int r0 = r12 + 1
            int r4 = r0 - r11
            long r1 = r13.m_owner
            r0 = r13
            r5 = r6
            r6 = r7
            r7 = r8
            r8 = r9
            r9 = r10
            r10 = r11
            r11 = r12
            r0.nativeSetFormatInfo(r1, r3, r4, r5, r6, r7, r8, r9, r10, r11)
        L_0x00e0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cdv.io.NvAndroidVideoFileReaderSW.ParseMediaFormat(android.media.MediaFormat):void");
    }

    private boolean isInterruptedDecoding() {
        NvAndroidInterruptionChecker nvAndroidInterruptionChecker = this.m_interruptionChecker;
        if (nvAndroidInterruptionChecker == null) {
            return false;
        }
        return nvAndroidInterruptionChecker.isInterrupted();
    }
}
