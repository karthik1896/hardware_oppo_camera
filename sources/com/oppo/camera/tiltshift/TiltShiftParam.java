package com.oppo.camera.tiltshift;

import android.util.Size;

public class TiltShiftParam {
    private float mAngle = 0.0f;
    private float mCenterX = 0.0f;
    private float mCenterY = 0.0f;
    private float mInnerDistance = 0.0f;
    private Size mPreviewSize = null;
    private boolean mbAdjusting = false;
    private boolean mbCircle = true;

    public TiltShiftParam() {
    }

    public TiltShiftParam(TiltShiftParam tiltShiftParam) {
        this.mPreviewSize = tiltShiftParam.getPreviewSize();
        this.mCenterX = tiltShiftParam.getCenterX();
        this.mCenterY = tiltShiftParam.getCenterY();
        this.mInnerDistance = tiltShiftParam.getInnerDistance();
        this.mAngle = tiltShiftParam.getAngle();
        this.mbCircle = tiltShiftParam.isCircle();
        this.mbAdjusting = tiltShiftParam.isAdjusting();
    }

    public Size getPreviewSize() {
        return this.mPreviewSize;
    }

    public void setPreviewSize(Size size) {
        this.mPreviewSize = size;
    }

    public float getCenterX() {
        return this.mCenterX;
    }

    public void setCenterX(float f) {
        this.mCenterX = f;
    }

    public float getCenterY() {
        return this.mCenterY;
    }

    public void setCenterY(float f) {
        this.mCenterY = f;
    }

    public float getInnerDistance() {
        return this.mInnerDistance;
    }

    public void setInnerDistance(float f) {
        this.mInnerDistance = f;
    }

    public float getAngle() {
        return this.mAngle;
    }

    public void setAngle(float f) {
        this.mAngle = f;
    }

    public boolean isCircle() {
        return this.mbCircle;
    }

    public void setCircle(boolean z) {
        this.mbCircle = z;
    }

    public boolean isAdjusting() {
        return this.mbAdjusting;
    }

    public void setAdjusting(boolean z) {
        this.mbAdjusting = z;
    }

    public String toString() {
        return "TiltShiftParam{mPreviewSize=" + this.mPreviewSize + ", mCenterX=" + this.mCenterX + ", mCenterY=" + this.mCenterY + ", mInnerDistance=" + this.mInnerDistance + ", mAngle=" + this.mAngle + ", mbCircle=" + this.mbCircle + ", mbAdjusting=" + this.mbAdjusting + '}';
    }
}
