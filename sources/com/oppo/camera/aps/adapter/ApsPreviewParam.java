package com.oppo.camera.aps.adapter;

import android.hardware.camera2.CameraMetadata;
import android.hardware.camera2.CaptureResult;
import androidx.collection.ArrayMap;
import com.oppo.camera.aps.adapter.ApsResult;

public class ApsPreviewParam {
    private long mConsumerPtr = 0;
    private long mFrameIdx = 0;
    private ApsResult.ImageBuffer[] mImageBufferArray = null;
    private CaptureResult mMetaObj = null;
    private ArrayMap<String, CameraMetadata> mMetadataMap = null;
    private String[] mProcessParamters = null;
    private int[] mRole = null;
    private long mTimeStamp = 0;
    private boolean mbIsDetached = false;
    private boolean mbNeedMetadata = true;

    public ApsPreviewParam() {
    }

    public ApsPreviewParam(long j, String[] strArr, long j2, ApsResult.ImageBuffer[] imageBufferArr, CaptureResult captureResult, ArrayMap<String, CameraMetadata> arrayMap, int[] iArr, boolean z, boolean z2, long j3) {
        this.mFrameIdx = j;
        this.mProcessParamters = strArr;
        this.mTimeStamp = j2;
        this.mImageBufferArray = imageBufferArr;
        this.mMetaObj = captureResult;
        this.mMetadataMap = arrayMap;
        this.mRole = iArr;
        this.mbNeedMetadata = z;
        this.mbIsDetached = z2;
        this.mConsumerPtr = j3;
    }

    public long getFrameIdx() {
        return this.mFrameIdx;
    }

    public void setFrameIdx(long j) {
        this.mFrameIdx = j;
    }

    public String[] getProcessParamters() {
        return this.mProcessParamters;
    }

    public void setProcessParamters(String[] strArr) {
        this.mProcessParamters = strArr;
    }

    public long getTimeStamp() {
        return this.mTimeStamp;
    }

    public void setTimeStamp(long j) {
        this.mTimeStamp = j;
    }

    public ApsResult.ImageBuffer[] getImageBufferArray() {
        return this.mImageBufferArray;
    }

    public void setImageBufferArray(ApsResult.ImageBuffer[] imageBufferArr) {
        this.mImageBufferArray = imageBufferArr;
    }

    public CaptureResult getMetaObj() {
        return this.mMetaObj;
    }

    public void setMetaObj(CaptureResult captureResult) {
        this.mMetaObj = captureResult;
    }

    public ArrayMap<String, CameraMetadata> getMetadataPtr() {
        return this.mMetadataMap;
    }

    public void setMetadataPtr(ArrayMap<String, CameraMetadata> arrayMap) {
        this.mMetadataMap = arrayMap;
    }

    public int[] getRole() {
        return this.mRole;
    }

    public void setRole(int[] iArr) {
        this.mRole = iArr;
    }

    public boolean getIsDetached() {
        return this.mbIsDetached;
    }
}
