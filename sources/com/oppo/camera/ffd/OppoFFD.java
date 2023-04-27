package com.oppo.camera.ffd;

import com.oppo.camera.e;
import java.nio.ByteBuffer;

public class OppoFFD {
    public static final int FACE_INFO_ATTR = 2;
    public static final int FACE_INFO_FD = 1;
    public static final int FACE_INFO_MASTER = 8;
    public static final int FACE_INFO_SKINSEG = 4;
    public static final int IMAGE_FMT_NV12 = 0;
    public static final int IMAGE_FMT_NV21 = 1;
    public static final int IMAGE_FMT_RGB888 = 3;
    public static final int IMAGE_FMT_RGBA8888 = 2;
    private static final String TAG = "OppoFFD";
    private long mHandle = 0;

    public static class ImageInfo {
        public int mFormat = 0;
        public int mHeight = 0;
        public int mScanline = 0;
        public int mStride = 0;
        public int mWidth = 0;
    }

    public static class ProcessParameter {
        public ByteBuffer mAttrResult = null;
        public int mAttrResultSize = 0;
        public int mDeviceOrientation = 0;
        public ByteBuffer mExifResult = null;
        public int mExifSize = 0;
        public ByteBuffer mFFDResult = null;
        public int mFFDResultSize = 0;
        public int mFaceNum = 0;
        public boolean mFrontCamera = false;
    }

    private native int init(int i, String str);

    private native int process(long j, byte[] bArr, ImageInfo imageInfo, ProcessParameter processParameter);

    private native int processSplitYUV(long j, byte[] bArr, byte[] bArr2, ImageInfo imageInfo, ProcessParameter processParameter);

    private native int release(long j);

    private native int setDebug(long j, boolean z, boolean z2, boolean z3, boolean z4);

    static {
        System.loadLibrary("OppoFFDJni");
    }

    public int initialize(int i, String str) {
        long init = (long) init(i, str);
        e.a(TAG, "initialize, faceInfoMode: " + i + ", modelPath: " + str + ", result: " + init);
        if (init != 0) {
            this.mHandle = init;
        }
        return (int) init;
    }

    public int processSplitYUV(byte[] bArr, byte[] bArr2, ImageInfo imageInfo, ProcessParameter processParameter) {
        long j = this.mHandle;
        int processSplitYUV = j != 0 ? processSplitYUV(j, bArr, bArr2, imageInfo, processParameter) : -1;
        e.a(TAG, "process, mHandle: " + this.mHandle + ", yBuffer: " + bArr + ", uvBuffer: " + bArr2 + ", imageInfo: " + imageInfo + ", parameter: " + processParameter + ", result: " + processSplitYUV);
        return processSplitYUV;
    }

    public int process(byte[] bArr, ImageInfo imageInfo, ProcessParameter processParameter) {
        long j = this.mHandle;
        int process = j != 0 ? process(j, bArr, imageInfo, processParameter) : -1;
        e.a(TAG, "process, yuvBuffer: " + bArr + ", imageInfo: " + imageInfo + ", parameter: " + processParameter);
        return process;
    }

    public int release() {
        long j = this.mHandle;
        int release = j != 0 ? release(j) : -1;
        e.a(TAG, "release, mHandle: " + this.mHandle + ", result: " + release);
        return release;
    }

    public int setDebug(boolean z, boolean z2, boolean z3, boolean z4) {
        long j = this.mHandle;
        int debug = j != 0 ? setDebug(j, z, z2, z3, z4) : -1;
        e.a(TAG, "setDebug, mHandle: " + this.mHandle + ", fbDump: " + z + ", drawMarks: " + z2 + ", printAttr: " + z3 + ", printFFD: " + z4 + ", result: " + debug);
        return debug;
    }
}
