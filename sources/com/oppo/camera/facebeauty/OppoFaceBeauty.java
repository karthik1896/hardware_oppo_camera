package com.oppo.camera.facebeauty;

import com.oppo.camera.e;

public class OppoFaceBeauty {
    public static final int ATTR_RESULT_NULL = -7;
    public static final int DEBUG_PARAM_INVALID = -5;
    public static final int FACEBEAUTY_LANGUAGE_NULL = -10;
    public static final int FACEBEAUTY_OK = 0;
    public static final int FACEBEAUTY_PARAM_NULL = -9;
    public static final int FACEBEAUTY_REGION_NULL = -12;
    public static final int FACEBEAUTY_VERSION_NULL = -11;
    public static final int FFD_RESULT_NULL = -6;
    public static final int HANDLE_INVAILD = -1;
    public static final int IMAGE_FMT_NV12 = 0;
    public static final int IMAGE_FMT_NV21 = 1;
    public static final int IMAGE_FMT_RGB888 = 3;
    public static final int IMAGE_FMT_RGBA8888 = 2;
    public static final int INIT_PARAM_INVAILD = -2;
    public static final int MEMORY_ALLOC_FAILED = -3;
    public static final int MODEL_PATH_PATH_NULL = -8;
    public static final int PROCESS_PARAM_INVALID = -4;
    private static final String TAG = "OppoFaceBeauty";
    private long mHandle = 0;

    public static class DebugParameter {
        public int mBlush = 0;
        public int mCheekBone = 0;
        public int mDeblemish = 0;
        public int mDepouch = 0;
        public int mDragChin = 0;
        public long mDumpTime = 0;
        public int mEnlargeEyes = 0;
        public int mEyeEnlargement = 0;
        public int mEyeEnlargementAlt = 0;
        public int mEyeSharpen1 = 0;
        public int mEyeSharpen2 = 0;
        public int mEyeWhiten = 0;
        public int mEyelidDarkening = 0;
        public int mFaceContour = 0;
        public boolean mFbEnable = true;
        public int mHigherNose = 0;
        public int mLipBeauty = 0;
        public int mModelling = 0;
        public int mNarrowNose = 0;
        public int mNoseHighlight = 0;
        public int mProtectTilak = 0;
        public int mPupilBrightening = 0;
        public int mPupilContrast = 0;
        public int mPupilEnlargement = 0;
        public int mSimulationHeight = 0;
        public int mSimulationWidth = 0;
        public int mSkinBright = 0;
        public int mSkinClarity = 0;
        public int mSkinRuddy = 0;
        public int mSkinStyle = 0;
        public int mSlimFace = 0;
        public int mSmallFace = 0;
        public int mSoften = 0;
        public int mSoftenSharp = 0;
        public int mSoftenType = 0;
        public int mTouchUp = 0;
        public boolean mb3DFBDump = false;
        public boolean mb3DFb = true;
        public boolean mbAIFb = false;
        public boolean mbDepthEnable = false;
        public boolean mbDrawmarks = false;
        public boolean mbFbDump = false;
        public boolean mbPrintFFD = false;
        public boolean mbSetPara = false;
        public boolean mbSkinDump = false;
    }

    public static class ImageInfo {
        public int mFormat = 0;
        public int mHeight = 0;
        public int mScanline = 0;
        public int mStride = 0;
        public int mWidth = 0;
    }

    public static class ProcessParameter {
        public int[] mAppBeautyParam = null;
        public int mAppBeautyParamSize = 0;
        public byte[] mAttrResult = null;
        public int mDeviceOrientation = 0;
        public byte[] mFFDResult = null;
        public int mFaceBeautyLevel = 0;
        public int mFaceNum = 0;
        public int mISO = 0;
        public String mLanguage = null;
        public int mMasterFaceIndex = 0;
        public String mModelPath = null;
        public String mProjectName = null;
        public String mRegion = null;
        public String mSensorName = null;
        public String mVersion = null;
        public int mVersionCode = -1;
        public boolean mbAiAdjustParam = true;
        public boolean mbFlashSnapshot = false;
        public boolean mbLowPerformance = false;
        public boolean mbVideoMode = false;
    }

    private native int init(InitParameter initParameter);

    private native int process(long j, byte[] bArr, ImageInfo imageInfo, ProcessParameter processParameter);

    private native int processSplitYUV(long j, byte[] bArr, byte[] bArr2, ImageInfo imageInfo, ProcessParameter processParameter);

    private native int release(long j);

    private native int setDebug(long j, DebugParameter debugParameter);

    static {
        System.loadLibrary("OppoFaceBeautyJni");
    }

    public static class InitParameter {
        public boolean mbFrontCamera = false;
        public boolean mbPortraitMode = false;
        public boolean mbSuperNight = false;

        public boolean equal(boolean z, boolean z2, boolean z3) {
            return this.mbFrontCamera == z && this.mbPortraitMode == z2 && this.mbSuperNight == z3;
        }
    }

    public int initialize(InitParameter initParameter) {
        long init = (long) init(initParameter);
        e.a(TAG, "initialize, result: " + init);
        if (init != 0) {
            this.mHandle = init;
        }
        return (int) init;
    }

    public int processSplitYUV(byte[] bArr, byte[] bArr2, ImageInfo imageInfo, ProcessParameter processParameter) {
        e.a(TAG, "process, mHandle: " + this.mHandle);
        long j = this.mHandle;
        if (j != 0) {
            return processSplitYUV(j, bArr, bArr2, imageInfo, processParameter);
        }
        return -1;
    }

    public int process(byte[] bArr, ImageInfo imageInfo, ProcessParameter processParameter) {
        e.a(TAG, "process, yuvBuffer: " + bArr + ", imageInfo: " + imageInfo + ", parameter: " + processParameter);
        long j = this.mHandle;
        if (j != 0) {
            return process(j, bArr, imageInfo, processParameter);
        }
        return -1;
    }

    public int release() {
        e.a(TAG, "release, mHandle: " + this.mHandle);
        long j = this.mHandle;
        if (j != 0) {
            return release(j);
        }
        return -1;
    }

    public void setDebug(DebugParameter debugParameter) {
        e.a(TAG, "setDebug, mHandle: " + this.mHandle + ", parameter: " + debugParameter);
        long j = this.mHandle;
        if (j != 0) {
            setDebug(j, debugParameter);
        }
    }
}
