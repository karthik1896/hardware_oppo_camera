package com.oppo.camera.jni;

public class YuvProcessUtil {
    public static final int FORMAT_NV12 = 274;
    public static final int FORMAT_NV21 = 17;

    public static class ExifInfo {
        public static final int APERTURE_MULTIPLE = 100;
        public static final int AWB_AUTO = 0;
        public static final int AWB_MANUAL = 1;
        public static final int DATE_TIME_MULTIPLE = 1000;
        public static final int EXPOSURE_BIAS_MULTIPLE = 10000000;
        public static final int EXPOSURE_MULTIPLE = 1000000;
        public static final int FLASH_AUTO_CLOSE = 24;
        public static final int FLASH_AUTO_OPEN = 25;
        public static final int FLASH_CLOSE = 16;
        public static final int FLASH_OPEN = 9;
        public static final int FOCAL_LENGTH_MULTIPLE = 100;
        public static final int F_NUMBER_MULTIPLE = 10;
        public static final int LOCATION_MULTIPLE = 1000;
        public static final int LOCATION_TIME_MULTIPLE = 1;
        public long[] mAltitude = null;
        public byte mAltitudeRef = 0;
        public long[] mApertureValue = null;
        public String mDateTime = null;
        public long[] mExposureBiasValue = null;
        public long[] mExposureTime = null;
        public int[] mFNumber = null;
        public int mFlashValue = 0;
        public int[] mFocalLength = null;
        public long mFrameNum = 0;
        public String mGPSDateStamp = null;
        public long[] mGPSTimeStamp = null;
        public int mISO = 0;
        public int mImageHeight = 0;
        public int mImageWidth = 0;
        public int mJpegOrientation = 0;
        public long[] mLatitude = null;
        public String mLatitudeRef = null;
        public long[] mLongitude = null;
        public String mLongitudeRef = null;
        public String mManufacture = null;
        public String mModel = null;
        public String mSubDateTime = null;
        public int mSupportDCIP3 = 0;
        public byte[] mTunningStats = null;
        public String mUserComment = null;
        public int mWhiteBalanceMode = 0;
    }

    public static native void bindCpuCores(long j);

    public static native byte[] mirrorYUV(byte[] bArr, int i, int[] iArr, int[] iArr2, int i2, int i3, int i4);

    public static native void restoreCpuCores();

    public static native byte[] rotateYUV(byte[] bArr, int i, int[] iArr, int[] iArr2, int i2, int i3, int i4);

    public static native void setExifParam(String str, int i, int i2, int[] iArr, int i3, int i4, long[] jArr, long[] jArr2, String str2, String str3, long j, long[] jArr3, int[] iArr2, String str4, byte[] bArr, int i5, String str5, String str6, String str7, byte b2, long[] jArr4, int i6, int i7, String str8, long[] jArr5, long[] jArr6, long[] jArr7);

    public native byte[] compressYUVtoJpeg(byte[] bArr, int i, int[] iArr, int[] iArr2, int i2, int i3, int i4, int i5, boolean z, boolean z2, boolean z3, int i6);

    public native int init(boolean z);

    public native void unInit(boolean z);

    public static void setExifInfo(ExifInfo exifInfo) {
        ExifInfo exifInfo2 = exifInfo;
        setExifParam(exifInfo2.mModel, exifInfo2.mJpegOrientation, exifInfo2.mISO, exifInfo2.mFNumber, exifInfo2.mWhiteBalanceMode, exifInfo2.mFlashValue, exifInfo2.mLatitude, exifInfo2.mLongitude, exifInfo2.mDateTime, exifInfo2.mSubDateTime, exifInfo2.mFrameNum, exifInfo2.mExposureTime, exifInfo2.mFocalLength, exifInfo2.mManufacture, exifInfo2.mTunningStats, exifInfo2.mSupportDCIP3, exifInfo2.mUserComment, exifInfo2.mLatitudeRef, exifInfo2.mLongitudeRef, exifInfo2.mAltitudeRef, exifInfo2.mAltitude, exifInfo2.mImageWidth, exifInfo2.mImageHeight, exifInfo2.mGPSDateStamp, exifInfo2.mGPSTimeStamp, exifInfo2.mApertureValue, exifInfo2.mExposureBiasValue);
    }
}
