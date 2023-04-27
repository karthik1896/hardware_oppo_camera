package com.arcsoft.libsinglecamerabokeh.jni;

import android.content.res.AssetManager;

public class SingleCameraBokehJNI {
    public static final int CAMERA_TYPE_BACK = 0;
    public static final int CAMERA_TYPE_FRONT = 1;
    public static final int PLATFORM_QC_7150 = 1;
    public static final int PLATFORM_QC_8150 = 2;
    public static final int PLATFORM_QC_DEFAULT = 0;
    public static final int PREVIEW_MODE = 2;
    public static final int SINGLECAMBOKEH_FOC_0 = 1;
    public static final int SINGLECAMBOKEH_FOC_180 = 4;
    public static final int SINGLECAMBOKEH_FOC_270 = 3;
    public static final int SINGLECAMBOKEH_FOC_90 = 2;
    public static final int SINGLECAMBOKEH_FOC_UNKNOWN = 0;
    private static final String TAG = ("ArcSoft_" + SingleCameraBokehJNI.class.getSimpleName());
    private long mGlobalPtr = 0;

    private native int native_forceUpdateFrame(long j, int i);

    private native String native_getVersion();

    private native int native_init(SinCamVBInitData sinCamVBInitData);

    private native int native_process(long j, SinCamVBProcessData sinCamVBProcessData);

    private native int native_release(long j);

    static {
        System.loadLibrary("mpbase");
        System.loadLibrary("arcsoft_scbokeh_video");
        System.loadLibrary("single_camera_bokeh_native");
    }

    public static class SinCamVBInitData {
        private int m_CameraType = 0;
        private int m_Format = 0;
        private int m_ModelInit = 0;
        private int m_OutHeight = 0;
        private int m_OutWidth = 0;
        private int m_SrcHeight = 0;
        private int m_SrcWidth = 0;

        public SinCamVBInitData(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
            this.m_SrcWidth = i;
            this.m_SrcHeight = i2;
            this.m_OutWidth = i3;
            this.m_OutHeight = i4;
            this.m_Format = i5;
            this.m_CameraType = i6;
            this.m_ModelInit = i7;
        }
    }

    public static class SinCamVBProcessData {
        private int m_BlurLevel = 0;
        private int m_FaceCount = 0;
        private int[] m_FaceRect = null;
        private int m_Orientation = 0;
        private int[] m_OutTexture = null;
        private int[] m_RefocusRect = null;
        private int m_SrcTexture = 0;

        public SinCamVBProcessData(int i, int[] iArr, int i2, int[] iArr2, int[] iArr3, int i3, int i4) {
            this.m_SrcTexture = i;
            this.m_OutTexture = iArr;
            this.m_FaceCount = i2;
            this.m_FaceRect = iArr2;
            this.m_RefocusRect = iArr3;
            this.m_BlurLevel = i3;
            this.m_Orientation = i4;
        }
    }

    public String getVersion() {
        return native_getVersion();
    }

    public int init(int i, int i2, int i3, int i4, int i5, int i6, AssetManager assetManager) {
        return native_init(new SinCamVBInitData(i, i2, i3, i4, i5, i6, 2));
    }

    public int process(int i, int[] iArr, int i2, int[] iArr2, int[] iArr3, int i3, int i4) {
        long j = this.mGlobalPtr;
        if (0 != j) {
            return native_process(j, new SinCamVBProcessData(i, iArr, i2, iArr2, iArr3, i3, i4));
        }
        return 2;
    }

    public int release() {
        long j = this.mGlobalPtr;
        if (0 == j) {
            return 2;
        }
        int native_release = native_release(j);
        this.mGlobalPtr = 0;
        return native_release;
    }

    public int forceUpdateFrame(int i) {
        long j = this.mGlobalPtr;
        if (0 != j) {
            return native_forceUpdateFrame(j, i);
        }
        return 2;
    }
}
