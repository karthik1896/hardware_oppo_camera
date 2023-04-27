package com.oppo.camera.aps.adapter;

import com.oppo.camera.aps.ApsAdapterLog;
import com.oppo.camera.aps.adapter.ApsParameters;
import com.oppo.camera.aps.adapter.ApsResult;
import com.oppo.camera.aps.service.ApsAdapterListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ImageCategory {
    private static final String TAG = "ImageCategory";
    public static final int TYPE_CAPTURE = 1;
    public static final int TYPE_PREVIEW = 2;
    public static final int TYPE_VIDEO = 3;
    public List<ImageItemInfo> mImageItemList = new ArrayList();
    public MetaItemInfo mMetaItem = null;
    public List<TuningItemInfo> mTuningItemList = new ArrayList();
    public boolean mbAlreadySendAps = false;

    public static class ImageItemInfo extends ApsParameters.ParameterModel {
        public ApsAdapterListener.ApsServiceListener mApsServiceListener = null;
        public ApsResult.ImageBuffer mImageBuffer = null;
    }

    public enum ItemInfoType {
        CAPTURE,
        PREVIEW,
        VIDEO
    }

    public static class TuningItemInfo extends ApsParameters.ParameterModel {
        public ApsResult.ImageBuffer mTuningBuffer = null;
    }

    public boolean isValid() {
        List<ImageItemInfo> list = this.mImageItemList;
        boolean z = list != null && list.size() > 0 && !((Boolean) this.mImageItemList.get(0).get(ApsParameters.KEY_NEED_META_DATA)).booleanValue();
        MetaItemInfo metaItemInfo = this.mMetaItem;
        boolean z2 = metaItemInfo != null && ((Integer) metaItemInfo.get(ApsParameters.KEY_MERGE_NUMBER)).intValue() >= 1 && ((Integer) this.mMetaItem.get(ApsParameters.KEY_PREVIEW_STREAM_NUMBER)).intValue() >= 1 && this.mImageItemList != null && ((Integer) this.mMetaItem.get(ApsParameters.KEY_PREVIEW_STREAM_NUMBER)).intValue() == this.mImageItemList.size() && ((Long) this.mMetaItem.get(ApsParameters.KEY_TIME_STAMP)).equals(this.mImageItemList.get(0).get(ApsParameters.KEY_TIME_STAMP)) && isTuningDataValid();
        if (z || z2) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean isTuningDataValid() {
        if (!((Boolean) this.mMetaItem.get(ApsParameters.KEY_USE_TUNING_DATA)).booleanValue()) {
            return true;
        }
        if (this.mTuningItemList.size() <= 0 || !((Long) this.mMetaItem.get(ApsParameters.KEY_TIME_STAMP)).equals(this.mTuningItemList.get(0).get(ApsParameters.KEY_TIME_STAMP))) {
            return false;
        }
        return true;
    }

    public void releaseImageItemList() {
        ApsAdapterLog.d(TAG, "releaseImageItemList, mImageItemList: " + this.mImageItemList);
        List<ImageItemInfo> list = this.mImageItemList;
        if (list != null) {
            for (ImageItemInfo next : list) {
                if (next.mImageBuffer != null) {
                    next.mImageBuffer.close();
                    next.mImageBuffer = null;
                }
            }
            this.mImageItemList.clear();
            this.mImageItemList = null;
        }
        List<TuningItemInfo> list2 = this.mTuningItemList;
        if (list2 != null) {
            for (TuningItemInfo next2 : list2) {
                if (next2.mTuningBuffer != null) {
                    next2.mTuningBuffer.close();
                    next2.mTuningBuffer = null;
                }
            }
            this.mTuningItemList.clear();
            this.mTuningItemList = null;
        }
    }

    public static class MetaItemInfo extends ApsParameters.ParameterModel {
        public MetaItemInfo copy() {
            MetaItemInfo metaItemInfo = new MetaItemInfo();
            metaItemInfo.mParameterMap = new HashMap();
            copy(metaItemInfo.mParameterMap);
            return metaItemInfo;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.mImageItemList != null) {
            sb.append("mImageItemList size: " + this.mImageItemList.size() + ", ");
            for (int i = 0; i < this.mImageItemList.size(); i++) {
                sb.append("image");
                sb.append(i);
                sb.append(" [");
                sb.append(this.mImageItemList.get(i).toString());
                sb.append("], ");
            }
        } else {
            sb.append("mImageItemList is null");
        }
        if (this.mMetaItem != null) {
            sb.append("metadata [");
            sb.append(this.mMetaItem.toString());
            sb.append("]");
        } else {
            sb.append("metadata is null");
        }
        if (this.mTuningItemList != null) {
            sb.append("mTuningItemList size: " + this.mTuningItemList.size() + " ");
            for (int i2 = 0; i2 < this.mTuningItemList.size(); i2++) {
                sb.append("tuningItem");
                sb.append(i2);
                sb.append(" [");
                sb.append(this.mTuningItemList.get(i2).toString());
                sb.append("], ");
            }
        } else {
            sb.append("mTuningItemList is null");
        }
        return sb.toString();
    }
}
