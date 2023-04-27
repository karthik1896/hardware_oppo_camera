package com.oppo.camera.jni;

import android.content.Context;

public class SecurityLicenseChecker {
    public static native byte[] decodeBuffer(Context context, byte[] bArr);

    public static native byte[] encodeBuffer(byte[] bArr);

    static {
        System.loadLibrary("license-checker-jni");
    }
}
