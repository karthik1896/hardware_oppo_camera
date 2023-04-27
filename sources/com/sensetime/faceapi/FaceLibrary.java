package com.sensetime.faceapi;

import android.graphics.Bitmap;
import com.oppo.camera.util.Util;
import com.sensetime.faceapi.model.FaceAttrInfo;
import com.sensetime.faceapi.model.FaceInfo;

public class FaceLibrary {
    public static native void convertColorSpace(byte[] bArr, int i, int i2, byte[] bArr2, int i3);

    public static native void cropNv21Data(byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, byte[] bArr2);

    public static native FaceAttrInfo cvFaceAttributeBytes(long j, byte[] bArr, int i, int i2, int i3, int i4, FaceInfo faceInfo, int[] iArr);

    public static native FaceAttrInfo cvFaceAttributeInts(long j, int[] iArr, int i, int i2, int i3, int i4, FaceInfo faceInfo, int[] iArr2);

    public static native void cvFaceCluster(long j, byte[][] bArr, int[] iArr, int[] iArr2);

    public static native float cvFaceCompareFeature(long j, byte[] bArr, byte[] bArr2, int[] iArr);

    public static native long cvFaceCreateAttribute(String str);

    public static native long cvFaceCreateCluster(String str);

    public static native long cvFaceCreateDetector(String str, int i);

    public static native long cvFaceCreateFigureSeg(String str, int i);

    public static native long cvFaceCreateHackness(String str);

    public static native long cvFaceCreateTracker(String str, String str2, int i);

    public static native long cvFaceCreateVerify(String str);

    public static native long cvFaceDeserialize(byte[] bArr);

    public static native void cvFaceDestroyAttribute(long j);

    public static native void cvFaceDestroyCluster(long j);

    public static native void cvFaceDestroyDetector(long j);

    public static native void cvFaceDestroyFigureSeg(long j);

    public static native void cvFaceDestroyHackness(long j);

    public static native void cvFaceDestroyTracker(long j);

    public static native void cvFaceDestroyVerify(long j);

    public static native FaceInfo[] cvFaceDetectBytes(long j, byte[] bArr, int i, int i2, int i3, int i4, int i5, int[] iArr);

    public static native FaceInfo[] cvFaceDetectInts(long j, int[] iArr, int i, int i2, int i3, int i4, int i5, int[] iArr2);

    public static native int cvFaceFigureSeg(long j, byte[] bArr, int i, int i2, int i3, int i4, int i5, byte[] bArr2, int i6);

    public static native int cvFaceFigureSeg(long j, byte[] bArr, int i, int i2, int i3, int i4, int i5, byte[] bArr2, int i6, int i7, int i8);

    public static native int cvFaceFigureSegSetOuputLength(long j, int i, int i2, int i3, int[] iArr);

    public static native byte[] cvFaceGetFeatureBytes(long j, byte[] bArr, int i, int i2, int i3, int i4, FaceInfo faceInfo, int[] iArr);

    public static native byte[] cvFaceGetFeatureInts(long j, int[] iArr, int i, int i2, int i3, int i4, FaceInfo faceInfo, int[] iArr2);

    public static native int cvFaceGetVerifyLength(long j);

    public static native int cvFaceGetVerifyVersion(long j);

    public static native float cvFaceHackness(long j, byte[] bArr, int i, int i2, int i3, int i4, int i5, FaceInfo faceInfo, int[] iArr);

    public static native void cvFaceResetTracker(long j);

    public static native void cvFaceShowInsideModel();

    public static native FaceInfo[] cvFaceTrackBytes(long j, byte[] bArr, int i, int i2, int i3, int i4, int i5, int[] iArr);

    public static native FaceInfo[] cvFaceTrackInts(long j, int[] iArr, int i, int i2, int i3, int i4, int i5, int[] iArr2);

    public static native int cvFaceTrackSetDetectFaceCntLimit(long j, int i);

    public static native int cvFaceTrackSetDetectInterval(long j, int i);

    public static native int faceBrightEvaluate(byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9);

    public static native void getBGRADataFromBitmap(Bitmap bitmap, byte[] bArr);

    public static native void getBGRDataFromBitmap(Bitmap bitmap, byte[] bArr);

    public static native float getDetectThreshold(long j, int[] iArr);

    public static native void getRepresentative(long j, int i, int i2, int[] iArr, int[] iArr2);

    public static native int initLiscence(byte[] bArr);

    public static native int initLiscenceStr(String str);

    public static native void setDebug(boolean z);

    public static native void setDetectThreshold(long j, float f, int[] iArr);

    static {
        System.loadLibrary(Util.p() ? "jnistblur_api.qti" : "jnistblur_api.trustonic");
    }
}
