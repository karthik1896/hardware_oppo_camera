package com.oppo.camera.upscale;

public class OppoUpscale {
    public static final int IMAGE_FORMAT_NV12 = 9;
    public static final int IMAGE_FORMAT_NV21 = 8;

    public static class ScaleRuntimeParameter {
        public int mActiveCPUMask = 0;
        public int mColorNoiseReductionStrength = 0;
        public int mNoiseReductionStrength = 0;
        public int mNumberOfProcessingThreads = 0;
        public float mSharpen = 0.0f;
    }

    public static class YUVImageParameter {
        public int mCBPixelStride = 0;
        public int mCBRowStride = 0;
        public int mCRPixelStride = 0;
        public int mCRRowStride = 0;
        public int mFormat = 9;
        public int mHeight = 0;
        public int mWidth = 0;
        public int mYColumnStride = 0;
        public int mYPixelStride = 0;
        public int mYRowStride = 0;
    }

    public native String getVersion();

    public native int scaleImage(YUVImageParameter yUVImageParameter, byte[] bArr, YUVImageParameter yUVImageParameter2, byte[] bArr2, ScaleRuntimeParameter scaleRuntimeParameter);

    public native int scaleImageSplitYUV(YUVImageParameter yUVImageParameter, byte[] bArr, byte[] bArr2, YUVImageParameter yUVImageParameter2, byte[] bArr3, byte[] bArr4, ScaleRuntimeParameter scaleRuntimeParameter);

    static {
        System.loadLibrary("OppoUpscaleJni");
    }
}
