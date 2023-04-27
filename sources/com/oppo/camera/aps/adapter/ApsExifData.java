package com.oppo.camera.aps.adapter;

import com.oppo.exif.OppoRational;

public class ApsExifData {
    public String mDocExifGpsDateStamp;
    public OppoRational[] mDocExifGpsTimeStamp = new OppoRational[3];
    public OppoRational mExifAltitude;
    public int mExifAltitudeRef;
    public OppoRational mExifAperture;
    public OppoRational mExifBrightness;
    public int mExifColorSpace;
    public String mExifComments;
    public String mExifComponentsConfig;
    public String mExifDateTime;
    public OppoRational mExifExpTime;
    public OppoRational mExifExposureBias;
    public int mExifExposureMode;
    public int mExifExposureProgram;
    public OppoRational mExifFNumber;
    public String mExifFlashPixVersion;
    public OppoRational mExifFocalLength;
    public int mExifFocalLength35Mm;
    public long mExifIso;
    public OppoRational[] mExifLatitude = new OppoRational[3];
    public String mExifLatitudeRef;
    public OppoRational[] mExifLongitude = new OppoRational[3];
    public String mExifLongitudeRef;
    public String mExifMakerNote;
    public String mExifManufacture;
    public OppoRational mExifMaxAperture;
    public int mExifMeteringMode;
    public String mExifModel;
    public int mExifRotate;
    public int mExifSceneCaptureType;
    public String mExifSceneType;
    public int mExifSensingMethod;
    public OppoRational mExifShutterSpeed;
    public String mExifSubDateTime;
    public String mExifVersion;
    public int mExifWhiteBalanceMode;
    public int mFlashValue;
    public int mHeicQuality;
    public int mImageHeight;
    public int mImageWidth;
    public String mInteropIndexStr;
    public String mInteropVersion;
    public String mSensorName;
    public ApsSizeDataType mStatsDebugData;
    public int mTiffResolutionUnit;
    public OppoRational mTiffXResolution;
    public OppoRational mTiffYResolution;
    public int mTiffYcrcbPositioning;
    public boolean mbMirror;
    public boolean mbSupportDCIP3;
    public boolean mbSupportLocation;
    public boolean mbSupportLocationTimeStamp;

    public class ApsSizeDataType {
        byte[] mBuffer;
        long mSize;

        public ApsSizeDataType() {
        }
    }
}
