package com.oppo.camera.aps.service;

import com.oppo.camera.aps.adapter.ApsParameters;
import com.oppo.camera.aps.adapter.ApsResult;
import com.oppo.camera.aps.adapter.ImageCategory;
import com.oppo.camera.statistics.model.CaptureMsgData;

public class ThumbnailCategory {
    public ApsResult mApsResult = null;
    public CaptureMsgData mCaptureMsgData = null;
    public ImageCategory.ImageItemInfo mImageItemInfo = null;
    public ImageCategory.MetaItemInfo mMetaItemInfo = null;
    public ThumbnailItem mThumbnailItem = null;

    public boolean isValid() {
        ThumbnailItem thumbnailItem = this.mThumbnailItem;
        return (thumbnailItem == null || this.mImageItemInfo == null || this.mMetaItemInfo == null || thumbnailItem.mIdentity != ((Long) this.mMetaItemInfo.get(ApsParameters.KEY_MERGE_IDENTITY)).longValue() || !((Long) this.mImageItemInfo.get(ApsParameters.KEY_TIME_STAMP)).equals(this.mMetaItemInfo.get(ApsParameters.KEY_TIME_STAMP))) ? false : true;
    }

    public String toString() {
        if (isValid()) {
            return this.mThumbnailItem.toString() + ", " + this.mApsResult;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("ThumbnailCategory is invalid! thumbnail.identity: ");
        ThumbnailItem thumbnailItem = this.mThumbnailItem;
        long j = -1;
        sb.append(thumbnailItem != null ? thumbnailItem.mIdentity : -1);
        sb.append(", meta.mergeIdentity: ");
        ImageCategory.MetaItemInfo metaItemInfo = this.mMetaItemInfo;
        sb.append(metaItemInfo != null ? ((Long) metaItemInfo.get(ApsParameters.KEY_MERGE_IDENTITY)).longValue() : -1);
        sb.append(", meta.timeStamp: ");
        ImageCategory.MetaItemInfo metaItemInfo2 = this.mMetaItemInfo;
        sb.append(metaItemInfo2 != null ? ((Long) metaItemInfo2.get(ApsParameters.KEY_TIME_STAMP)).longValue() : -1);
        sb.append(", image.timeStamp: ");
        ImageCategory.ImageItemInfo imageItemInfo = this.mImageItemInfo;
        if (imageItemInfo != null) {
            j = ((Long) imageItemInfo.get(ApsParameters.KEY_TIME_STAMP)).longValue();
        }
        sb.append(j);
        return sb.toString();
    }
}
