package com.oppo.camera.aps.adapter;

import com.oppo.camera.aps.adapter.ImageCategory;

public class CaptureImageCategory extends ImageCategory {
    private static final String TAG = "CaptureImageCategory";

    public boolean isValid() {
        boolean z = this.mImageItemList != null && this.mImageItemList.size() > 0 && !((Boolean) ((ImageCategory.ImageItemInfo) this.mImageItemList.get(0)).get(ApsParameters.KEY_NEED_META_DATA)).booleanValue();
        boolean z2 = this.mMetaItem != null && ((Integer) this.mMetaItem.get(ApsParameters.KEY_MERGE_NUMBER)).intValue() >= 1 && ((Integer) this.mMetaItem.get(ApsParameters.KEY_CAPTURE_STREAM_NUMBER)).intValue() >= 1 && this.mImageItemList != null && ((Integer) this.mMetaItem.get(ApsParameters.KEY_CAPTURE_STREAM_NUMBER)).intValue() == this.mImageItemList.size() && ((Long) this.mMetaItem.get(ApsParameters.KEY_TIME_STAMP)).equals(((ImageCategory.ImageItemInfo) this.mImageItemList.get(0)).get(ApsParameters.KEY_TIME_STAMP)) && isTuningDataValid();
        if (z || z2) {
            return true;
        }
        return false;
    }
}
