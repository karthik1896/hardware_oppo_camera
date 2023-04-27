package com.arcsoft.camera.burstpmk;

public class BurstPMKInitParameter {
    private int bufferSize;
    public int deviceDirection;
    public int deviceOrientation;
    public int maxfullResultLength;
    public boolean resultImageRotated;
    public int sensorOrientation;
    private int srcFullImageHeight;
    private int srcFullImageWidth;
    private int srcImageFormat;
    private int srcSmallImageHeight;
    private int srcSmallImageWidth;
    public int thumbnailResultHeightH;
    public int thumbnailResultHeightV;
    public int thumbnailResultWidthH;
    public int thumbnailResultWidthV;

    public int getBufferSize() {
        return this.bufferSize;
    }

    public int getImageFormat() {
        return this.srcImageFormat;
    }

    public int getSmallImageWidth() {
        return this.srcSmallImageWidth;
    }

    public int getSmallImageHeight() {
        return this.srcSmallImageHeight;
    }

    public int getFullImageWidth() {
        return this.srcFullImageWidth;
    }

    public int getFullImageHeight() {
        return this.srcFullImageHeight;
    }

    private BurstPMKInitParameter() {
    }

    public static BurstPMKInitParameter getDefaultInitParams(int i, int i2, int i3, int i4) {
        BurstPMKInitParameter burstPMKInitParameter = new BurstPMKInitParameter();
        burstPMKInitParameter.srcFullImageWidth = i;
        burstPMKInitParameter.srcFullImageHeight = i2;
        burstPMKInitParameter.srcImageFormat = i3;
        burstPMKInitParameter.deviceOrientation = i4;
        int i5 = burstPMKInitParameter.srcFullImageWidth;
        burstPMKInitParameter.srcSmallImageWidth = i5;
        int i6 = burstPMKInitParameter.srcFullImageHeight;
        burstPMKInitParameter.srcSmallImageHeight = i6;
        if (i3 == 1281 || i3 == 1285) {
            burstPMKInitParameter.bufferSize = burstPMKInitParameter.srcFullImageWidth * 28 * burstPMKInitParameter.srcFullImageHeight;
        } else if (i3 == 2049 || i3 == 2050) {
            burstPMKInitParameter.bufferSize = (int) (((double) burstPMKInitParameter.srcFullImageWidth) * 21.0d * ((double) burstPMKInitParameter.srcFullImageHeight));
        } else {
            burstPMKInitParameter.bufferSize = (int) (((double) i5) * 21.0d * ((double) i6));
        }
        int i7 = burstPMKInitParameter.srcFullImageWidth;
        burstPMKInitParameter.maxfullResultLength = i7 * 4;
        int i8 = burstPMKInitParameter.maxfullResultLength;
        burstPMKInitParameter.thumbnailResultWidthH = i8 / 6;
        burstPMKInitParameter.thumbnailResultHeightH = burstPMKInitParameter.srcFullImageHeight / 6;
        burstPMKInitParameter.thumbnailResultWidthV = i7 / 8;
        burstPMKInitParameter.thumbnailResultHeightV = i8 / 8;
        burstPMKInitParameter.deviceDirection = -1;
        burstPMKInitParameter.sensorOrientation = 0;
        burstPMKInitParameter.resultImageRotated = false;
        return burstPMKInitParameter;
    }
}
