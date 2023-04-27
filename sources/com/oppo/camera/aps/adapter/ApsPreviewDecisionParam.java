package com.oppo.camera.aps.adapter;

import android.hardware.camera2.CameraMetadata;

public class ApsPreviewDecisionParam {
    private int mCameraId = 0;
    private String mCaptureMode = null;
    private int mFaceBeautyEnable = 0;
    private int mFilterEnable = 0;
    private int mLogicalCameraId = 0;
    private CameraMetadata mMetadata = null;
    private int mMultiCameraMode = 0;
    private int mNeonEnable = 0;
    private int mPiEnable = 0;
    private int mRecordingCapture = 0;
    private int mSCPEnable = 0;
    private int mStreamerEnable = 0;
    private int mSuperRawEnable = 0;
    private int mTripodEnable = 0;
    private int mUltraHighResolutionEnable = 0;
    private float mZoomRatio = 0.0f;

    public ApsPreviewDecisionParam(float f, CameraMetadata cameraMetadata, int i, int i2, int i3, int i4, int i5, int i6, int i7, String str, int i8, int i9, int i10, int i11, int i12, int i13) {
        this.mZoomRatio = f;
        this.mMetadata = cameraMetadata;
        this.mMultiCameraMode = i;
        this.mCameraId = i2;
        this.mLogicalCameraId = i3;
        this.mPiEnable = i4;
        this.mTripodEnable = i5;
        this.mUltraHighResolutionEnable = i6;
        this.mFilterEnable = i7;
        this.mFaceBeautyEnable = i10;
        this.mCaptureMode = str;
        this.mSCPEnable = i9;
        this.mNeonEnable = i8;
        this.mStreamerEnable = i12;
        this.mSuperRawEnable = i11;
        this.mRecordingCapture = i13;
    }

    public void setZoomRatio(float f) {
        this.mZoomRatio = f;
    }

    public float getZoomRatio() {
        return this.mZoomRatio;
    }

    public void setMetadata(CameraMetadata cameraMetadata) {
        this.mMetadata = cameraMetadata;
    }

    public CameraMetadata getMetadata() {
        return this.mMetadata;
    }

    public void setMultiCameraMode(int i) {
        this.mMultiCameraMode = i;
    }

    public int getMultiCameraMode() {
        return this.mMultiCameraMode;
    }

    public void setCameraId(int i) {
        this.mCameraId = i;
    }

    public int getCameraId() {
        return this.mCameraId;
    }

    public void setLogicalCameraId(int i) {
        this.mLogicalCameraId = i;
    }

    public int getLogicalCameraId() {
        return this.mLogicalCameraId;
    }

    public void setPiEnable(int i) {
        this.mPiEnable = i;
    }

    public int getPiEnable() {
        return this.mPiEnable;
    }

    public void setTripodEnable(int i) {
        this.mTripodEnable = i;
    }

    public int getTripodEnable() {
        return this.mTripodEnable;
    }

    public void setUltraHighResolutionEnable(int i) {
        this.mUltraHighResolutionEnable = i;
    }

    public int getUltraHighResolutionEnable() {
        return this.mUltraHighResolutionEnable;
    }

    public void setCaptureMode(String str) {
        this.mCaptureMode = str;
    }

    public String getCaptureMode() {
        return this.mCaptureMode;
    }

    public int getRecordingCaptureState() {
        return this.mRecordingCapture;
    }

    public int getSCPEnable() {
        return this.mSCPEnable;
    }

    public void setSCPEnable(int i) {
        this.mSCPEnable = i;
    }

    public int getNeonEnable() {
        return this.mNeonEnable;
    }

    public int getStreamerEnable() {
        return this.mStreamerEnable;
    }

    public int getSuperRawEnable() {
        return this.mSuperRawEnable;
    }

    public void setSuperRawEnable(int i) {
        this.mSuperRawEnable = i;
    }

    public void setNeonEnable(int i) {
        this.mNeonEnable = i;
    }

    public void setStreamerEnable(int i) {
        this.mStreamerEnable = i;
    }

    public int getFilterEnable() {
        return this.mFilterEnable;
    }

    public int getFaceBeautyEnable() {
        return this.mFaceBeautyEnable;
    }

    public String toString() {
        return "PreviewDecisionParameters: [mZoomRatio: " + this.mZoomRatio + ", mMetadata: " + this.mMetadata + ", mMultiCameraMode: " + this.mMultiCameraMode + ", mCameraId: " + this.mCameraId + ", mLogicalCameraId: " + this.mLogicalCameraId + ", mPiEnable: " + this.mPiEnable + ", mTripodEnable: " + this.mTripodEnable + ", mUltraHighResolutionEnable: " + this.mUltraHighResolutionEnable + ", mFilterEnable: " + this.mFilterEnable + ", mFaceBeautyEnable: " + this.mFaceBeautyEnable + ", mCaptureMode: " + this.mCaptureMode + ", mSCPEnable: " + this.mSCPEnable + ", mNeonEnable: " + this.mNeonEnable + ", mStreamerEnable: " + this.mStreamerEnable + ", mSuperRawEnable: " + this.mSuperRawEnable + "]";
    }
}
