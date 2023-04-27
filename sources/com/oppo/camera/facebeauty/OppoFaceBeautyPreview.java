package com.oppo.camera.facebeauty;

public class OppoFaceBeautyPreview {
    public native int destroy();

    public native long getTimeStamp();

    public native float getZoomScale();

    public native int init(int i, int i2, int i3, int i4, String str, String str2, String str3, boolean z, boolean z2, byte[] bArr, int i5);

    public native int process(int i, int[] iArr, int[] iArr2, int[] iArr3);

    public native int reset();

    public native int updataMetaParams(byte[] bArr);

    public native int updataPreviewParams(long j);

    static {
        System.loadLibrary("ApsFaceBeautyPreviewJni");
    }
}
