package com.meicam.sdk;

import android.os.Handler;
import android.os.Looper;
import java.util.Hashtable;
import java.util.concurrent.atomic.AtomicReference;

public class NvsMediaFileConvertor {
    public static final String CONVERTOR_CUSTOM_AUDIO_CHANNEL = "custom-audio-channel";
    public static final String CONVERTOR_CUSTOM_AUDIO_PCM_FILE = "custom-audio-pcm-file";
    public static final String CONVERTOR_CUSTOM_AUDIO_SAMPLE_RATE = "custom-audio-sample-rate";
    public static final String CONVERTOR_CUSTOM_VIDEO_HEIGHT = "custom-video-height";
    public static final String CONVERTOR_DETECTED_AUDIO_MUTE_FACTOR = "detected_audio_mute";
    public static final String CONVERTOR_DISABLE_HARDWARE_VIDEO_DECODER = "disable_hardware_video_decoder";
    public static final int CONVERTOR_ERROR_CODE_CANCEL = 1;
    public static final int CONVERTOR_ERROR_CODE_NO_ERROR = 0;
    public static final int CONVERTOR_ERROR_UNKNOWN = 65535;
    public static final int CONVERTOR_ERROR_VIDEO_DECODER_ERROR = 4;
    public static final int CONVERTOR_ERROR_VIDEO_DECODING_ERROR = 5;
    public static final int CONVERTOR_ERROR_VIDEO_ENCODER_SETUP_ERROR = 2;
    public static final int CONVERTOR_ERROR_VIDEO_ENCODING_ERROR = 3;
    public static final String CONVERTOR_NO_AUDIO = "convertor-no-audio";
    public static final String CONVERTOR_NO_VIDEO = "convertor-no-video";
    private final String TAG = "NvsMediaFileConvertor";
    private AtomicReference<Handler> mCallbackHanlder = new AtomicReference<>((Object) null);
    private AtomicReference<MeidaFileConvertorCallback> m_callback = new AtomicReference<>((Object) null);
    private long m_contextInterface = nativeInit();

    public interface MeidaFileConvertorCallback {
        void notifyAudioMuteRage(long j, long j2, long j3);

        void onFinish(long j, String str, String str2, int i);

        void onProgress(long j, float f);
    }

    private native void nativeCancelTask(long j, long j2);

    private native void nativeClose(long j);

    private native long nativeConvertMeidaFile(long j, String str, String str2, boolean z, long j2, long j3, Hashtable<String, Object> hashtable);

    private native long nativeInit();

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        release();
        super.finalize();
    }

    public void release() {
        if (!isReleased()) {
            synchronized (this) {
                nativeClose(this.m_contextInterface);
                this.m_callback.set((Object) null);
                this.m_contextInterface = 0;
            }
        }
    }

    public boolean isReleased() {
        return this.m_contextInterface == 0;
    }

    public void setMeidaFileConvertorCallback(MeidaFileConvertorCallback meidaFileConvertorCallback, Handler handler) {
        this.m_callback.set(meidaFileConvertorCallback);
        this.mCallbackHanlder.set(handler);
        if (meidaFileConvertorCallback != null && handler == null) {
            this.mCallbackHanlder.set(new Handler(Looper.getMainLooper()));
        }
    }

    public void setMeidaFileConvertorCallback(MeidaFileConvertorCallback meidaFileConvertorCallback, boolean z) {
        this.m_callback.set(meidaFileConvertorCallback);
        if (meidaFileConvertorCallback != null && z) {
            this.mCallbackHanlder.set(new Handler(Looper.getMainLooper()));
        }
    }

    public long convertMeidaFile(String str, String str2, boolean z, long j, long j2, Hashtable<String, Object> hashtable) {
        long nativeConvertMeidaFile;
        synchronized (this) {
            nativeConvertMeidaFile = nativeConvertMeidaFile(this.m_contextInterface, str, str2, z, j, j2, hashtable);
        }
        return nativeConvertMeidaFile;
    }

    public void cancelTask(long j) {
        if (!isReleased()) {
            synchronized (this) {
                nativeCancelTask(this.m_contextInterface, j);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void notifyProgress(long j, float f) {
        final MeidaFileConvertorCallback meidaFileConvertorCallback = this.m_callback.get();
        Handler handler = this.mCallbackHanlder.get();
        if (meidaFileConvertorCallback == null) {
            return;
        }
        if (handler != null) {
            final long j2 = j;
            final float f2 = f;
            handler.post(new Runnable() {
                public void run() {
                    meidaFileConvertorCallback.onProgress(j2, f2);
                }
            });
            return;
        }
        meidaFileConvertorCallback.onProgress(j, f);
    }

    /* access modifiers changed from: protected */
    public void notifyFinish(long j, String str, String str2, int i) {
        final MeidaFileConvertorCallback meidaFileConvertorCallback = this.m_callback.get();
        Handler handler = this.mCallbackHanlder.get();
        if (meidaFileConvertorCallback == null) {
            return;
        }
        if (handler != null) {
            final long j2 = j;
            final String str3 = str;
            final String str4 = str2;
            final int i2 = i;
            handler.post(new Runnable() {
                public void run() {
                    meidaFileConvertorCallback.onFinish(j2, str3, str4, i2);
                }
            });
            return;
        }
        meidaFileConvertorCallback.onFinish(j, str, str2, i);
    }

    /* access modifiers changed from: protected */
    public void notifyAudioMuteRage(long j, long j2, long j3) {
        final MeidaFileConvertorCallback meidaFileConvertorCallback = this.m_callback.get();
        Handler handler = this.mCallbackHanlder.get();
        if (meidaFileConvertorCallback == null) {
            return;
        }
        if (handler != null) {
            final long j4 = j;
            final long j5 = j2;
            final long j6 = j3;
            handler.post(new Runnable() {
                public void run() {
                    meidaFileConvertorCallback.notifyAudioMuteRage(j4, j5, j6);
                }
            });
            return;
        }
        meidaFileConvertorCallback.notifyAudioMuteRage(j, j2, j3);
    }
}
