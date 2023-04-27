package com.sensetime.faceapi.utils;

import android.graphics.Bitmap;
import android.util.Log;
import com.oppo.camera.util.Util;
import com.sensetime.faceapi.FaceLibrary;
import com.sensetime.faceapi.model.ColorConvertType;
import java.nio.ByteBuffer;

public class ColorConvertUtil {
    public static final String TAG = "ColorConvertUtil";

    public static void convertColorSpace(byte[] bArr, int i, int i2, byte[] bArr2, ColorConvertType colorConvertType) {
        FaceLibrary.convertColorSpace(bArr, i, i2, bArr2, colorConvertType.getValue());
    }

    public static void getBGRADataFromBitmap(Bitmap bitmap, byte[] bArr) {
        if (bitmap == null || bitmap.isRecycled() || bArr == null) {
            Log.e(TAG, "getBGRADataFromBitmap bitmap is null or bgra is null !!!");
        } else if (bitmap.getConfig() != Bitmap.Config.ARGB_8888) {
            Log.e(TAG, "getBGRADataFromBitmap is not ARGB_8888 !!!");
        } else if (bitmap.getWidth() * bitmap.getHeight() * 4 != bArr.length) {
            Log.e(TAG, "getBGRADataFromBitmap illegal bgra data!!!");
        } else {
            FaceLibrary.getBGRADataFromBitmap(bitmap, bArr);
        }
    }

    public static void getBGRDataFromBitmap(Bitmap bitmap, byte[] bArr) {
        if (bitmap == null || bitmap.isRecycled() || bArr == null) {
            throw new RuntimeException("getBGRDataFromBitmap bitmap is null or bgra is null !!!");
        } else if (bitmap.getConfig() != Bitmap.Config.ARGB_8888) {
            throw new RuntimeException("getBGRDataFromBitmap is not ARGB_8888 !!!");
        } else if (bitmap.getWidth() * bitmap.getHeight() * 3 == bArr.length) {
            FaceLibrary.getBGRDataFromBitmap(bitmap, bArr);
        } else {
            throw new RuntimeException("getBGRDataFromBitmap illegal bgra data!!!");
        }
    }

    public static Bitmap cropNv21ToBitmap(byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6) {
        byte[] bArr2 = new byte[(i5 * i6 * 4)];
        cropNv21DataToARGB(bArr, i, i2, i3, i4, i5, i6, bArr2);
        return byteArrayToBitmap(bArr2, i5, i6);
    }

    public static void cropNv21DataToARGB(byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, byte[] bArr2) {
        if (bArr == null || bArr2 == null) {
            Log.e(TAG, "cropNv21DataToARGB _in or out is null ");
        }
        if (i < i5 || i2 < i6 || i < i3 + i5 || i2 < i4 + i6) {
            Log.e(TAG, "cropNv21DataToARGB  illegal para !!!");
            throw new RuntimeException("cropNv21DataToARGB ");
        } else {
            FaceLibrary.cropNv21Data(bArr, i, i2, i3, i4, i5, i6, bArr2);
        }
    }

    public static Bitmap byteArrayToBitmap(byte[] bArr, int i, int i2) {
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        Bitmap a2 = Util.a(i, i2, Bitmap.Config.ARGB_8888);
        a2.copyPixelsFromBuffer(wrap);
        return a2;
    }
}
