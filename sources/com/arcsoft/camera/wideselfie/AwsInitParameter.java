package com.arcsoft.camera.wideselfie;

public class AwsInitParameter {
    private static final float DEFAULT_CAMERA_HORIZ_VIEW_ANGLE = 55.3014f;
    private static final float DEFAULT_CAMERA_VERT_VIEW_ANGLE = 42.9829f;
    private static final float DEFAULT_THUMB_SIZE_RATE = 3.0f;
    private int bufferSize;
    public float cameraViewAngleForHeight;
    public float cameraViewAngleForWidth;
    public int changeDirectionThumbThreshold;
    public boolean convertNV21;
    private int deviceOrientation;
    public boolean flipResultImage;
    private int fullImageHeight;
    private int fullImageWidth;
    public int guideStableBarThumbHeight;
    public int guideStopBarThumbHeight;
    public int maxResultWidth;
    public int mode;
    public int progressBarThumbHeight;
    public float progressBarThumbHeightCropRatio;
    public float resultAngleForHeight;
    public float resultAngleForWidth;
    public boolean rotateResultImage;
    private int srcFormat;
    private int thumbnailFormat;
    private int thumbnailHeight;
    private int thumbnailWidth;

    public int getBufferSize() {
        return this.bufferSize;
    }

    public int getSrcFormat() {
        return this.srcFormat;
    }

    public int getFullImageWidth() {
        return this.fullImageWidth;
    }

    public int getFullImageHeight() {
        return this.fullImageHeight;
    }

    public int getThumbForamt() {
        return this.thumbnailFormat;
    }

    public int getThumbnailWidth() {
        return this.thumbnailWidth;
    }

    public int getThumbnailHeight() {
        return this.thumbnailHeight;
    }

    public int getDeviceOrientation() {
        return this.deviceOrientation;
    }

    private AwsInitParameter() {
    }

    public static AwsInitParameter getDefaultInitParams(int i, int i2, int i3, int i4) {
        AwsInitParameter awsInitParameter = new AwsInitParameter();
        awsInitParameter.bufferSize = 0;
        awsInitParameter.mode = 64;
        awsInitParameter.cameraViewAngleForHeight = DEFAULT_CAMERA_VERT_VIEW_ANGLE;
        awsInitParameter.cameraViewAngleForWidth = DEFAULT_CAMERA_HORIZ_VIEW_ANGLE;
        awsInitParameter.resultAngleForWidth = 120.0f;
        awsInitParameter.resultAngleForHeight = 90.0f;
        awsInitParameter.changeDirectionThumbThreshold = 120;
        awsInitParameter.srcFormat = i3;
        awsInitParameter.fullImageWidth = i;
        awsInitParameter.fullImageHeight = i2;
        awsInitParameter.thumbnailFormat = awsInitParameter.srcFormat;
        awsInitParameter.thumbnailWidth = awsInitParameter.fullImageWidth;
        awsInitParameter.thumbnailHeight = awsInitParameter.fullImageHeight;
        awsInitParameter.deviceOrientation = i4;
        if (i4 == 90 || i4 == 270) {
            awsInitParameter.maxResultWidth = (int) (((float) i) * 3.0f * 0.4f);
            awsInitParameter.progressBarThumbHeight = i / 10;
            awsInitParameter.guideStopBarThumbHeight = (int) (((double) i) * 0.303d);
        } else {
            awsInitParameter.maxResultWidth = (int) (((float) i2) * 3.0f * 0.8f);
            awsInitParameter.progressBarThumbHeight = i2 / 8;
            awsInitParameter.guideStopBarThumbHeight = awsInitParameter.progressBarThumbHeight / 2;
        }
        awsInitParameter.guideStableBarThumbHeight = 5;
        awsInitParameter.progressBarThumbHeightCropRatio = 0.0f;
        awsInitParameter.convertNV21 = false;
        awsInitParameter.flipResultImage = false;
        awsInitParameter.rotateResultImage = false;
        return awsInitParameter;
    }
}
