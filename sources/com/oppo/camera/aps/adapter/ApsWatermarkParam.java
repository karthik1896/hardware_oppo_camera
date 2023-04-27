package com.oppo.camera.aps.adapter;

public class ApsWatermarkParam {
    private int mRefWidth = 0;
    private byte[] mWatermarkBuffer = null;
    private int mWatermarkHeight = 0;
    private int mWatermarkWidth = 0;

    public ApsWatermarkParam(int i, int i2, int i3, byte[] bArr) {
        this.mRefWidth = i;
        this.mWatermarkHeight = i2;
        this.mWatermarkWidth = i3;
        this.mWatermarkBuffer = bArr;
    }

    public String toString() {
        return "ApsWatermarkParam: {mRefWidth: " + this.mRefWidth + ", mWatermarkHeight: " + this.mWatermarkHeight + ", mWatermarkWidth: " + this.mWatermarkWidth + ", mWatermarkBuffer: " + this.mWatermarkBuffer + "}";
    }

    public byte[] getWatermarkBuffer() {
        return this.mWatermarkBuffer;
    }

    public int getRefWidth() {
        return this.mRefWidth;
    }

    public int getWatermarkHeight() {
        return this.mWatermarkHeight;
    }

    public int getWatermarkWidth() {
        return this.mWatermarkWidth;
    }
}
