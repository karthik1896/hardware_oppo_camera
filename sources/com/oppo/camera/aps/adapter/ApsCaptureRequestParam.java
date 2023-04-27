package com.oppo.camera.aps.adapter;

import androidx.collection.ArrayMap;

public class ApsCaptureRequestParam {
    public int mActiveMap = -1;
    public long mLogicMetadata = 0;
    public int mLogicalId = -1;
    public int mMasterCameraId = -1;
    public ArrayMap<String, Long> mPhysicalMetadatas = null;
}
