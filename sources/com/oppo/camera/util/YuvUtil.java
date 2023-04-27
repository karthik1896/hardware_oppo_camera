package com.oppo.camera.util;

import com.oppo.camera.e;

public class YuvUtil {

    public static class YuvParameter {
        public int mFormat = 17;
        public int mHeight = 0;
        public int mWidth = 0;
    }

    public native int scale(byte[] bArr, YuvParameter yuvParameter, byte[] bArr2, YuvParameter yuvParameter2);

    static {
        System.loadLibrary("YuvUtil");
    }

    public byte[] a(byte[] bArr, int i, int i2, int i3, int i4) {
        byte[] bArr2 = new byte[((int) (((float) (i3 * i4)) * 1.5f))];
        YuvParameter yuvParameter = new YuvParameter();
        yuvParameter.mWidth = i;
        yuvParameter.mHeight = i2;
        YuvParameter yuvParameter2 = new YuvParameter();
        yuvParameter2.mWidth = i3;
        yuvParameter2.mHeight = i4;
        int scale = scale(bArr, yuvParameter, bArr2, yuvParameter2);
        if (scale == 0) {
            return bArr2;
        }
        e.e("YuvUtil", "scaleImage, result: " + scale);
        return null;
    }
}
