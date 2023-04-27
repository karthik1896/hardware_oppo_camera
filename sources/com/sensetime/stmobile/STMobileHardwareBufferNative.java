package com.sensetime.stmobile;

public class STMobileHardwareBufferNative {
    public static final int HAEDWARE_BUFFER_FORMAT = 0;
    public static final int HAEDWARE_BUFFER_USAGE_DOWNLOAD = 1;

    public native void downloadRgbaImage(int i, int i2, byte[] bArr);

    public native int getTextureId();

    public native int init(int i, int i2, int i3, int i4);

    public native void release();
}
