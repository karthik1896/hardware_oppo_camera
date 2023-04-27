package com.oppo.camera.watermark;

public class OppoWatermark {
    public static final int IMAGE_FMT_NV12 = 0;
    public static final int IMAGE_FMT_NV21 = 1;

    public static class WatermarkParameter {
        public int mImageFormat = 1;
        public int mImageHeight = 0;
        public int mImageScanline = 0;
        public int mImageStride = 0;
        public int mImageWidth = 0;
        public int mOrientation = 0;
        public int mPreviewHeight = 0;
        public int mPreviewWidth = 0;
        public int mWatermarkFormat = 0;
        public String mWatermarkPath = null;
    }

    public native int process(byte[] bArr, WatermarkParameter watermarkParameter);

    public native int processSplitYUV(byte[] bArr, byte[] bArr2, WatermarkParameter watermarkParameter);

    static {
        System.loadLibrary("OppoWatermarkJni");
    }
}
