package com.oppo.camera.aps.adapter;

import android.hardware.camera2.CameraMetadata;
import com.oppo.camera.aps.adapter.ApsResult;
import java.util.Arrays;

public class ApsCaptureParam {
    private long mFrameNumber = 0;
    private ApsResult.ImageBuffer mImageBuffer = null;
    private int[] mInputSize = null;
    private CameraMetadata mLogicMeta = null;
    private int mMaxHoldImages = 0;
    private CameraMetadata mPhysicMeta = null;
    private int mPreferType = 0;
    private int mRole = 0;
    private boolean mbReprocessFrame = false;
    private boolean mbVideoSnapshot = false;

    public ApsCaptureParam(long j, ApsResult.ImageBuffer imageBuffer, int i, CameraMetadata cameraMetadata, CameraMetadata cameraMetadata2, int[] iArr, boolean z, int i2, int i3, boolean z2) {
        this.mFrameNumber = j;
        this.mImageBuffer = imageBuffer;
        this.mRole = i;
        this.mLogicMeta = cameraMetadata;
        this.mPhysicMeta = cameraMetadata2;
        this.mInputSize = iArr;
        this.mbReprocessFrame = z;
        this.mMaxHoldImages = i2;
        this.mPreferType = i3;
        this.mbVideoSnapshot = z2;
    }

    public long getFrameNumber() {
        return this.mFrameNumber;
    }

    public ApsResult.ImageBuffer getImageBuffer() {
        return this.mImageBuffer;
    }

    public boolean getIsReprocessFrame() {
        return this.mbReprocessFrame;
    }

    public int[] getInputSize() {
        return this.mInputSize;
    }

    public int getRole() {
        return this.mRole;
    }

    public CameraMetadata getLogicMeta() {
        return this.mLogicMeta;
    }

    public CameraMetadata getPhysicMeta() {
        return this.mPhysicMeta;
    }

    public int getMaxHoldImages() {
        return this.mMaxHoldImages;
    }

    public int getPreferType() {
        return this.mPreferType;
    }

    public boolean getIsVideoSnapshot() {
        return this.mbVideoSnapshot;
    }

    public String toString() {
        return "{" + "mFrameNumber: " + this.mFrameNumber + ", mImageBuffer: " + this.mImageBuffer + ", mRole: " + this.mRole + ", mLogicMeta: " + this.mLogicMeta + ", mPhysicMeta: " + this.mPhysicMeta + ", mInputSize: " + Arrays.toString(this.mInputSize) + ", mbReprocessFrame: " + this.mbReprocessFrame + ", mMaxHoldImages: " + this.mMaxHoldImages + ", mPreferType: " + this.mPreferType + "}";
    }
}
