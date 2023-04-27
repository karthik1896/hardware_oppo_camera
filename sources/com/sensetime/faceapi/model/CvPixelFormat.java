package com.sensetime.faceapi.model;

public enum CvPixelFormat {
    GRAY8(0),
    YUV420P(1),
    NV12(2),
    NV21(3),
    BGRA8888(4),
    BGR888(5),
    RGBA8888(6);
    
    private static CvPixelFormat[] sImageFormats;
    final int nativeInt;

    static {
        CvPixelFormat cvPixelFormat;
        CvPixelFormat cvPixelFormat2;
        CvPixelFormat cvPixelFormat3;
        CvPixelFormat cvPixelFormat4;
        CvPixelFormat cvPixelFormat5;
        CvPixelFormat cvPixelFormat6;
        CvPixelFormat cvPixelFormat7;
        sImageFormats = new CvPixelFormat[]{cvPixelFormat, cvPixelFormat2, cvPixelFormat3, cvPixelFormat4, cvPixelFormat5, cvPixelFormat6, cvPixelFormat7};
    }

    private CvPixelFormat(int i) {
        this.nativeInt = i;
    }

    public int getValue() {
        return this.nativeInt;
    }

    public static CvPixelFormat nativeToConfig(int i) {
        return sImageFormats[i];
    }
}
