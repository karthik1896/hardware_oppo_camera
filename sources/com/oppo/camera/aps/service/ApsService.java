package com.oppo.camera.aps.service;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.OplusWhiteListManager;
import android.app.Service;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.ContentObserver;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.hardware.HardwareBuffer;
import android.hardware.camera2.TotalCaptureResult;
import android.os.Binder;
import android.os.Build;
import android.os.IBinder;
import android.util.Size;
import androidx.collection.ArrayMap;
import androidx.core.app.h;
import com.aps.APSClient;
import com.oppo.camera.R;
import com.oppo.camera.a.d;
import com.oppo.camera.aps.ApsCameraRequestTag;
import com.oppo.camera.aps.adapter.ApsAdapterDecision;
import com.oppo.camera.aps.adapter.ApsAdapterImpl;
import com.oppo.camera.aps.adapter.ApsAdapterInterface;
import com.oppo.camera.aps.adapter.ApsExifData;
import com.oppo.camera.aps.adapter.ApsInitParameter;
import com.oppo.camera.aps.adapter.ApsParameters;
import com.oppo.camera.aps.adapter.ApsResult;
import com.oppo.camera.aps.adapter.ImageCategory;
import com.oppo.camera.aps.config.AlgoSwitchConfig;
import com.oppo.camera.aps.constant.ParameterKeys;
import com.oppo.camera.aps.service.ApsAdapterListener;
import com.oppo.camera.e;
import com.oppo.camera.m.b;
import com.oppo.camera.statistics.model.CaptureMsgData;
import com.oppo.camera.util.Util;
import com.oppo.camera.z;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class ApsService extends Service implements ApsAdapterInterface.ImageProcessListener {
    private static final String BURST_SHOT_TEMP_DIRECTORY_FLAG = ".cshot";
    private static final float MAX_AVAILABLE_MEMORY_RATIO = 0.33333334f;
    private static final long SELF_PROTECT_ADD_TIME = 600000;
    private static final String TAG = "ApsService";
    private ApsAdapterInterface mApsAdapter = null;
    private final IBinder mBinder = new LocalBinder();
    private final Object mBurstShotTempDirectoryLock = new Object();
    private ConcurrentHashMap<Long, b> mHeicProcessorMap = new ConcurrentHashMap<>();
    private long mLatestThumbnailIdentity = 0;
    private final Object mOppoWhiteListLock = new Object();
    private OplusWhiteListManager mOppoWhiteListManager = null;
    private ConcurrentHashMap<Long, ThumbnailCategory> mThumbnailMap = new ConcurrentHashMap<>();
    private final Object mThumbnailMapLock = new Object();
    private boolean mbCapturing = false;

    private void handlePreviewFailed(long j) {
    }

    public void initHeifCodec(long j) {
    }

    public void onPreviewFrameProcessStarted(long j, Long l) {
    }

    public void onPreviewReceived(ApsResult apsResult, ImageCategory.ImageItemInfo imageItemInfo) {
    }

    public void processHeifCodec(long j, HardwareBuffer hardwareBuffer, ApsExifData apsExifData, int i, int i2) {
    }

    public void uninitHeifCodec(long j) {
    }

    public void afterAddFrame(ImageCategory.ImageItemInfo imageItemInfo, ImageCategory.MetaItemInfo metaItemInfo) {
        if (imageItemInfo != null && imageItemInfo.mApsServiceListener != null) {
            imageItemInfo.mApsServiceListener.onFinishAddFrame(imageItemInfo, metaItemInfo);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x00a8, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void afterProcessImage(int r3, com.oppo.camera.aps.adapter.ImageCategory.ImageItemInfo r4, com.oppo.camera.aps.adapter.ImageCategory.MetaItemInfo r5) {
        /*
            r2 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "afterProcessImage, processResult: "
            r0.append(r1)
            r0.append(r3)
            java.lang.String r1 = ", imageItemInfo: "
            r0.append(r1)
            r0.append(r4)
            java.lang.String r1 = ", metaItemInfo: "
            r0.append(r1)
            r0.append(r5)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "ApsService"
            com.oppo.camera.e.a(r1, r0)
            java.lang.Object r0 = r2.mThumbnailMapLock
            monitor-enter(r0)
            r1 = -1
            if (r3 != r1) goto L_0x003d
            java.util.concurrent.ConcurrentHashMap<java.lang.Long, com.oppo.camera.aps.service.ThumbnailCategory> r3 = r2.mThumbnailMap     // Catch:{ all -> 0x00a9 }
            com.oppo.camera.aps.adapter.ApsParameters$Key r4 = com.oppo.camera.aps.constant.ParameterKeys.KEY_MERGE_IDENTITY     // Catch:{ all -> 0x00a9 }
            java.lang.Object r4 = r5.get(r4)     // Catch:{ all -> 0x00a9 }
            r3.remove(r4)     // Catch:{ all -> 0x00a9 }
            r3 = 0
            r2.mLatestThumbnailIdentity = r3     // Catch:{ all -> 0x00a9 }
            monitor-exit(r0)     // Catch:{ all -> 0x00a9 }
            return
        L_0x003d:
            boolean r3 = com.oppo.camera.util.Util.p()     // Catch:{ all -> 0x00a9 }
            if (r3 == 0) goto L_0x0053
            com.oppo.camera.aps.adapter.ApsParameters$Key r3 = com.oppo.camera.aps.constant.ParameterKeys.KEY_IMAGE_FORMAT     // Catch:{ all -> 0x00a9 }
            java.lang.Object r3 = r4.get(r3)     // Catch:{ all -> 0x00a9 }
            java.lang.Integer r3 = (java.lang.Integer) r3     // Catch:{ all -> 0x00a9 }
            int r3 = r3.intValue()     // Catch:{ all -> 0x00a9 }
            r1 = 32
            if (r3 == r1) goto L_0x00a7
        L_0x0053:
            java.util.concurrent.ConcurrentHashMap<java.lang.Long, com.oppo.camera.aps.service.ThumbnailCategory> r3 = r2.mThumbnailMap     // Catch:{ all -> 0x00a9 }
            if (r3 == 0) goto L_0x00a7
            java.util.concurrent.ConcurrentHashMap<java.lang.Long, com.oppo.camera.aps.service.ThumbnailCategory> r3 = r2.mThumbnailMap     // Catch:{ all -> 0x00a9 }
            com.oppo.camera.aps.adapter.ApsParameters$Key r1 = com.oppo.camera.aps.constant.ParameterKeys.KEY_MERGE_IDENTITY     // Catch:{ all -> 0x00a9 }
            java.lang.Object r1 = r5.get(r1)     // Catch:{ all -> 0x00a9 }
            boolean r3 = r3.containsKey(r1)     // Catch:{ all -> 0x00a9 }
            if (r3 == 0) goto L_0x0082
            java.util.concurrent.ConcurrentHashMap<java.lang.Long, com.oppo.camera.aps.service.ThumbnailCategory> r3 = r2.mThumbnailMap     // Catch:{ all -> 0x00a9 }
            com.oppo.camera.aps.adapter.ApsParameters$Key r1 = com.oppo.camera.aps.constant.ParameterKeys.KEY_MERGE_IDENTITY     // Catch:{ all -> 0x00a9 }
            java.lang.Object r1 = r5.get(r1)     // Catch:{ all -> 0x00a9 }
            java.lang.Object r3 = r3.get(r1)     // Catch:{ all -> 0x00a9 }
            com.oppo.camera.aps.service.ThumbnailCategory r3 = (com.oppo.camera.aps.service.ThumbnailCategory) r3     // Catch:{ all -> 0x00a9 }
            r3.mImageItemInfo = r4     // Catch:{ all -> 0x00a9 }
            r3.mMetaItemInfo = r5     // Catch:{ all -> 0x00a9 }
            com.oppo.camera.aps.adapter.ApsParameters$Key<com.oppo.camera.statistics.model.CaptureMsgData> r4 = com.oppo.camera.aps.constant.ParameterKeys.KEY_CAPTURE_MSG_DATA     // Catch:{ all -> 0x00a9 }
            java.lang.Object r4 = r5.get(r4)     // Catch:{ all -> 0x00a9 }
            com.oppo.camera.statistics.model.CaptureMsgData r4 = (com.oppo.camera.statistics.model.CaptureMsgData) r4     // Catch:{ all -> 0x00a9 }
            r3.mCaptureMsgData = r4     // Catch:{ all -> 0x00a9 }
            goto L_0x00a0
        L_0x0082:
            com.oppo.camera.aps.service.ThumbnailCategory r3 = new com.oppo.camera.aps.service.ThumbnailCategory     // Catch:{ all -> 0x00a9 }
            r3.<init>()     // Catch:{ all -> 0x00a9 }
            r3.mImageItemInfo = r4     // Catch:{ all -> 0x00a9 }
            r3.mMetaItemInfo = r5     // Catch:{ all -> 0x00a9 }
            com.oppo.camera.aps.adapter.ApsParameters$Key<com.oppo.camera.statistics.model.CaptureMsgData> r4 = com.oppo.camera.aps.constant.ParameterKeys.KEY_CAPTURE_MSG_DATA     // Catch:{ all -> 0x00a9 }
            java.lang.Object r4 = r5.get(r4)     // Catch:{ all -> 0x00a9 }
            com.oppo.camera.statistics.model.CaptureMsgData r4 = (com.oppo.camera.statistics.model.CaptureMsgData) r4     // Catch:{ all -> 0x00a9 }
            r3.mCaptureMsgData = r4     // Catch:{ all -> 0x00a9 }
            java.util.concurrent.ConcurrentHashMap<java.lang.Long, com.oppo.camera.aps.service.ThumbnailCategory> r4 = r2.mThumbnailMap     // Catch:{ all -> 0x00a9 }
            com.oppo.camera.aps.adapter.ApsParameters$Key r1 = com.oppo.camera.aps.constant.ParameterKeys.KEY_MERGE_IDENTITY     // Catch:{ all -> 0x00a9 }
            java.lang.Object r5 = r5.get(r1)     // Catch:{ all -> 0x00a9 }
            r4.put(r5, r3)     // Catch:{ all -> 0x00a9 }
        L_0x00a0:
            com.oppo.camera.n.b r3 = com.oppo.camera.n.b.a()     // Catch:{ all -> 0x00a9 }
            r3.h()     // Catch:{ all -> 0x00a9 }
        L_0x00a7:
            monitor-exit(r0)     // Catch:{ all -> 0x00a9 }
            return
        L_0x00a9:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00a9 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.aps.service.ApsService.afterProcessImage(int, com.oppo.camera.aps.adapter.ImageCategory$ImageItemInfo, com.oppo.camera.aps.adapter.ImageCategory$MetaItemInfo):void");
    }

    public void onProcessQueueEmpty() {
        e.a(TAG, "onProcessQueueEmpty");
    }

    public void onJpegReceived(ApsResult apsResult) {
        ThumbnailCategory thumbnailCategory;
        Boolean bool;
        e.a("CameraCapturePerformance.onJpegReceived");
        synchronized (this.mThumbnailMapLock) {
            thumbnailCategory = this.mThumbnailMap.get(Long.valueOf(apsResult.mIdentity));
            StringBuilder sb = new StringBuilder();
            sb.append("onJpegReceived, thumbnailCategory: ");
            sb.append(thumbnailCategory);
            sb.append(", isValid: ");
            if (thumbnailCategory == null) {
                bool = null;
            } else {
                bool = Boolean.valueOf(thumbnailCategory.isValid());
            }
            sb.append(bool);
            e.a(TAG, sb.toString());
            if (thumbnailCategory != null && thumbnailCategory.isValid()) {
                savePicture(thumbnailCategory, apsResult);
                this.mThumbnailMap.remove(Long.valueOf(apsResult.mIdentity));
            } else if (thumbnailCategory != null) {
                thumbnailCategory.mApsResult = copyApsResult(apsResult);
            }
            if (this.mThumbnailMap.size() == 0) {
                this.mLatestThumbnailIdentity = 0;
                removeStageProtectInfo(getPackageName());
            }
        }
        com.oppo.camera.n.b.a().i();
        this.mbCapturing = false;
        e.a(TAG, "onJpegReceived, thumbnailCategory: " + thumbnailCategory + ", identity: " + apsResult.mIdentity);
        e.b("CameraCapturePerformance.onJpegReceived");
    }

    public void onReprocess(ImageCategory imageCategory, ApsResult apsResult) {
        ImageCategory.ImageItemInfo imageItemInfo = imageCategory.mImageItemList.get(0);
        ImageCategory.MetaItemInfo metaItemInfo = imageCategory.mMetaItem;
        if (!(imageItemInfo == null || imageItemInfo.mApsServiceListener == null)) {
            imageItemInfo.mImageBuffer.getImage().getPlanes()[0].getBuffer().put(apsResult.mCopyBuffer, 0, imageItemInfo.mImageBuffer.getImage().getPlanes()[0].getBuffer().remaining());
            imageItemInfo.mApsServiceListener.onReprocess(imageItemInfo.mImageBuffer.getImage(), (TotalCaptureResult) metaItemInfo.get(ApsParameters.KEY_CAPTURE_RESULT), new Rect(apsResult.mCropLeft, apsResult.mCropTop, apsResult.mCropRight, apsResult.mCropBottom), (ApsCameraRequestTag) metaItemInfo.get(ApsParameters.KEY_CAMERA_REQUEST_TAG));
        }
        this.mbCapturing = false;
    }

    public void onBurstShotStart(long j) {
        createBurstShotFlagFile(j);
    }

    public void onBurstShotEnd(ImageCategory.ImageItemInfo imageItemInfo, ImageCategory.MetaItemInfo metaItemInfo) {
        deleteBurstShotFlagFile(((Long) imageItemInfo.get(ParameterKeys.KEY_BURST_SHOT_FLAG_ID)).longValue());
        if (imageItemInfo.mApsServiceListener != null) {
            ThumbnailCategory thumbnailCategory = new ThumbnailCategory();
            thumbnailCategory.mImageItemInfo = imageItemInfo;
            thumbnailCategory.mMetaItemInfo = metaItemInfo;
            thumbnailCategory.mCaptureMsgData = (CaptureMsgData) metaItemInfo.get(ParameterKeys.KEY_CAPTURE_MSG_DATA);
            imageItemInfo.mApsServiceListener.reportCaptureDataToDcs(thumbnailCategory, (Object) null);
        }
    }

    private boolean interruptHeicData(ApsAdapterListener.ApsServiceListener apsServiceListener, ApsResult apsResult, ApsCameraRequestTag apsCameraRequestTag) {
        if (!(apsServiceListener instanceof OnCaptureHeciDataListener)) {
            return false;
        }
        boolean onHeicReceived = ((OnCaptureHeciDataListener) apsServiceListener).onHeicReceived(apsResult, apsCameraRequestTag);
        e.c(TAG, "interruptHeicData, ret: " + onHeicReceived);
        return onHeicReceived;
    }

    public void onHeicReceived(ApsResult apsResult) {
        ThumbnailCategory thumbnailCategory;
        Boolean bool;
        synchronized (this.mThumbnailMapLock) {
            thumbnailCategory = this.mThumbnailMap.get(Long.valueOf(apsResult.mIdentity));
            if (thumbnailCategory != null && thumbnailCategory.isValid()) {
                if (!interruptHeicData(thumbnailCategory.mImageItemInfo.mApsServiceListener, apsResult, (ApsCameraRequestTag) thumbnailCategory.mMetaItemInfo.get(ApsParameters.KEY_CAMERA_REQUEST_TAG))) {
                    savePicture(thumbnailCategory, apsResult);
                }
                this.mThumbnailMap.remove(Long.valueOf(apsResult.mIdentity));
            } else if (thumbnailCategory != null) {
                thumbnailCategory.mApsResult = copyApsResult(apsResult);
            }
            if (this.mThumbnailMap.size() == 0) {
                this.mLatestThumbnailIdentity = 0;
                removeStageProtectInfo(getPackageName());
            }
        }
        com.oppo.camera.n.b.a().i();
        this.mbCapturing = false;
        StringBuilder sb = new StringBuilder();
        sb.append("onHeicReceived, thumbnailCategory: ");
        sb.append(thumbnailCategory);
        sb.append(", isValid: ");
        if (thumbnailCategory == null) {
            bool = null;
        } else {
            bool = Boolean.valueOf(thumbnailCategory.isValid());
        }
        sb.append(bool);
        sb.append(", identity: ");
        sb.append(apsResult.mIdentity);
        e.a(TAG, sb.toString());
    }

    private ApsResult copyApsResult(ApsResult apsResult) {
        if (apsResult == null) {
            return null;
        }
        ApsResult apsResult2 = new ApsResult();
        apsResult2.mCopyBuffer = apsResult.mCopyBuffer;
        apsResult2.mExifData = apsResult.mExifData;
        apsResult2.mWidth = apsResult.mWidth;
        apsResult2.mHeight = apsResult.mHeight;
        apsResult2.mScanline = apsResult.mScanline;
        apsResult2.mStride = apsResult.mStride;
        apsResult2.mSTHeight = apsResult.mSTHeight;
        apsResult2.mSTWidth = apsResult.mSTWidth;
        apsResult2.mbHasSTResult = apsResult.mbHasSTResult;
        return apsResult2;
    }

    public HashMap<String, String> fillApsParameters(ImageCategory imageCategory, int i) {
        HashMap<String, String> hashMap = new HashMap<>();
        if (imageCategory == null) {
            return hashMap;
        }
        ImageCategory.MetaItemInfo metaItemInfo = imageCategory.mMetaItem;
        ImageCategory.ImageItemInfo imageItemInfo = imageCategory.mImageItemList != null ? imageCategory.mImageItemList.get(0) : null;
        if (metaItemInfo != null) {
            for (Map.Entry entry : metaItemInfo.mParameterMap.entrySet()) {
                ApsParameters.Key key = (ApsParameters.Key) entry.getKey();
                if (1 == key.getCategory()) {
                    hashMap.put(key.getName(), String.valueOf(((ApsParameters.ValueWrapper) entry.getValue()).getValue().get()));
                }
            }
        }
        if (imageItemInfo != null) {
            for (Map.Entry entry2 : imageItemInfo.mParameterMap.entrySet()) {
                ApsParameters.Key key2 = (ApsParameters.Key) entry2.getKey();
                if (1 == key2.getCategory()) {
                    hashMap.put(key2.getName(), String.valueOf(((ApsParameters.ValueWrapper) entry2.getValue()).getValue().get()));
                }
            }
        }
        if (1 == i && metaItemInfo != null && imageItemInfo != null) {
            hashMap.put(ApsParameters.KEY_PROCESS_IMAGE_IDENTITY, String.valueOf(metaItemInfo.get(ParameterKeys.KEY_MERGE_IDENTITY)));
            hashMap.put(ParameterKeys.KEY_CUSTOM_BEAUTY_PARAM.getName(), Arrays.toString((int[]) metaItemInfo.get(ParameterKeys.KEY_CUSTOM_BEAUTY_PARAM)));
            if (((Long) metaItemInfo.get(ParameterKeys.KEY_DATE)).longValue() != 0) {
                hashMap.put(ParameterKeys.KEY_PICTURE_DATE_TIME, String.valueOf(metaItemInfo.get(ParameterKeys.KEY_DATE)));
            } else {
                hashMap.put(ParameterKeys.KEY_PICTURE_DATE_TIME, String.valueOf(imageItemInfo.get(ParameterKeys.KEY_DATE)));
            }
            if (metaItemInfo.get(ParameterKeys.KEY_PICTURE_EXIF_FLAG) != null) {
                hashMap.put(ParameterKeys.KEY_PICTURE_EXIF_FLAG.getName(), ((String) metaItemInfo.get(ParameterKeys.KEY_PICTURE_EXIF_FLAG)).substring(5));
            }
            if (imageItemInfo.get(ParameterKeys.KEY_BURST_SHOT) != null) {
                hashMap.put(ParameterKeys.KEY_BURST_SHOT.getName(), String.valueOf(imageItemInfo.get(ParameterKeys.KEY_BURST_SHOT)));
            }
            if (imageItemInfo.get(ParameterKeys.KEY_BURST_SHOT_FLAG_ID) != null) {
                hashMap.put(ParameterKeys.KEY_BURST_SHOT_FLAG_ID.getName(), String.valueOf(imageItemInfo.get(ParameterKeys.KEY_BURST_SHOT_FLAG_ID)));
            }
        } else if ((2 == i || 3 == i) && imageItemInfo != null) {
            hashMap.put(ApsParameters.KEY_PROCESS_IMAGE_IDENTITY, String.valueOf(imageItemInfo.get(ParameterKeys.KEY_TIME_STAMP)));
            hashMap.put(ApsParameters.KEY_PIPELINE, ApsParameters.APS_PIPELINE_NAME_PREVIEW);
        }
        return hashMap;
    }

    public HashMap<String, String> fillApsParameters(ApsInitParameter apsInitParameter) {
        HashMap<String, String> hashMap = new HashMap<>();
        if (apsInitParameter == null) {
            return hashMap;
        }
        for (Map.Entry entry : apsInitParameter.mParameterMap.entrySet()) {
            ApsParameters.Key key = (ApsParameters.Key) entry.getKey();
            if (key.getCategory() == 1) {
                hashMap.put(key.getName(), String.valueOf(((ApsParameters.ValueWrapper) entry.getValue()).getValue().get()));
            }
        }
        return hashMap;
    }

    public ApsInitParameter getApsInitParameter(ApsInitParameter apsInitParameter, ApsInitParameter apsInitParameter2) {
        Set<String> initAlgos = getInitAlgos((String) apsInitParameter.get(ParameterKeys.KEY_CAPTURE_MODE), (String) apsInitParameter.get(ParameterKeys.KEY_CAMERA_ID), (Set) apsInitParameter.get(ParameterKeys.KEY_UNINIT_ALGOS));
        if (!needInit(apsInitParameter, apsInitParameter2, initAlgos)) {
            return null;
        }
        ApsInitParameter apsInitParameter3 = new ApsInitParameter();
        apsInitParameter3.mVendorTags = apsInitParameter.mVendorTags;
        apsInitParameter3.mVendorTagKeyMap = apsInitParameter.mVendorTagKeyMap;
        apsInitParameter3.setParameter(ParameterKeys.KEY_CAPTURE_MODE, apsInitParameter.get(ParameterKeys.KEY_CAPTURE_MODE));
        apsInitParameter3.setParameter(ParameterKeys.KEY_CAMERA_FEATURE, apsInitParameter.get(ParameterKeys.KEY_CAMERA_FEATURE));
        apsInitParameter3.setParameter(ParameterKeys.KEY_CAMERA_ID, apsInitParameter.get(ParameterKeys.KEY_CAMERA_ID));
        apsInitParameter3.setParameter(ParameterKeys.KEY_LOGIC_CAMERA_ID, apsInitParameter.get(ParameterKeys.KEY_LOGIC_CAMERA_ID));
        apsInitParameter3.setParameter(ParameterKeys.KEY_HIGHT_PICTURE_SIZE_ENABLE, apsInitParameter.get(ParameterKeys.KEY_HIGHT_PICTURE_SIZE_ENABLE));
        apsInitParameter3.setParameter(ParameterKeys.KEY_OPERATION_MODE, apsInitParameter.get(ParameterKeys.KEY_OPERATION_MODE));
        apsInitParameter3.setParameter(ParameterKeys.KEY_PREVIEW_SIZE, apsInitParameter.get(ParameterKeys.KEY_PREVIEW_SIZE));
        apsInitParameter3.setParameter(ParameterKeys.KEY_VIDEO_SIZE, apsInitParameter.get(ParameterKeys.KEY_VIDEO_SIZE));
        apsInitParameter3.setParameter(ParameterKeys.KEY_UNINIT_ALGOS, new HashSet((Collection) apsInitParameter.get(ParameterKeys.KEY_UNINIT_ALGOS)));
        apsInitParameter3.mApsModule = apsInitParameter.mApsModule;
        apsInitParameter3.mInitAlgo = new String[initAlgos.size()];
        int i = 0;
        for (String str : initAlgos) {
            apsInitParameter3.mInitAlgo[i] = str;
            i++;
        }
        return apsInitParameter3;
    }

    private boolean needInit(ApsInitParameter apsInitParameter, ApsInitParameter apsInitParameter2, Set<String> set) {
        if (AlgoSwitchConfig.getApsMode() == 0 || apsInitParameter.get(ParameterKeys.KEY_CAPTURE_MODE) == null || apsInitParameter.get(ParameterKeys.KEY_CAMERA_ID) == null || set == null || apsInitParameter.get(ParameterKeys.KEY_HIGHT_PICTURE_SIZE_ENABLE) == null || apsInitParameter.get(ParameterKeys.KEY_OPERATION_MODE) == null || apsInitParameter.get(ParameterKeys.KEY_PREVIEW_SIZE) == null) {
            return false;
        }
        if (apsInitParameter2 != null) {
            Set<String> initAlgos = getInitAlgos((String) apsInitParameter2.get(ParameterKeys.KEY_CAPTURE_MODE), (String) apsInitParameter2.get(ParameterKeys.KEY_CAMERA_ID), (Set) apsInitParameter2.get(ParameterKeys.KEY_UNINIT_ALGOS));
            if (!((String) apsInitParameter2.get(ParameterKeys.KEY_CAPTURE_MODE)).equals(apsInitParameter.get(ParameterKeys.KEY_CAPTURE_MODE)) || !((String) apsInitParameter2.get(ParameterKeys.KEY_CAMERA_ID)).equals(apsInitParameter.get(ParameterKeys.KEY_CAMERA_ID)) || !initAlgos.equals(set) || !((String) apsInitParameter2.get(ParameterKeys.KEY_HIGHT_PICTURE_SIZE_ENABLE)).equals(apsInitParameter.get(ParameterKeys.KEY_HIGHT_PICTURE_SIZE_ENABLE)) || apsInitParameter2.mApsModule != apsInitParameter.mApsModule || !((String) apsInitParameter2.get(ParameterKeys.KEY_OPERATION_MODE)).equals(apsInitParameter.get(ParameterKeys.KEY_OPERATION_MODE)) || !((Size) apsInitParameter.get(ParameterKeys.KEY_PREVIEW_SIZE)).equals(apsInitParameter2.get(ParameterKeys.KEY_PREVIEW_SIZE)) || (((apsInitParameter2.get(ParameterKeys.KEY_VIDEO_SIZE) != null || apsInitParameter.get(ParameterKeys.KEY_VIDEO_SIZE) != null) && (apsInitParameter2.get(ParameterKeys.KEY_VIDEO_SIZE) == null || !((Size) apsInitParameter2.get(ParameterKeys.KEY_VIDEO_SIZE)).equals(apsInitParameter.get(ParameterKeys.KEY_VIDEO_SIZE)))) || ((apsInitParameter2.get(ParameterKeys.KEY_CAMERA_FEATURE) != null || apsInitParameter.get(ParameterKeys.KEY_CAMERA_FEATURE) != null) && (apsInitParameter2.get(ParameterKeys.KEY_CAMERA_FEATURE) == null || !((String) apsInitParameter2.get(ParameterKeys.KEY_CAMERA_FEATURE)).equals(apsInitParameter.get(ParameterKeys.KEY_CAMERA_FEATURE)))))) {
                return true;
            }
            return false;
        } else if (AlgoSwitchConfig.getApsVersion() == 2 && apsInitParameter.mApsModule == 3) {
            return false;
        } else {
            return true;
        }
    }

    private Set<String> getInitAlgos(String str, String str2, Set<String> set) {
        HashSet hashSet = new HashSet();
        AlgoSwitchConfig.CaptureConfig captureConfig = AlgoSwitchConfig.getCaptureConfig(str, Integer.parseInt(str2));
        if (captureConfig != null && captureConfig.mbEnable) {
            hashSet.addAll(captureConfig.mAlgos);
            hashSet.removeAll(set);
        }
        if (hashSet.size() == 0) {
            hashSet.add(ApsParameters.ALGO_NAME_NONE);
        }
        return hashSet;
    }

    private boolean createBurstShotFlagFile(long j) {
        boolean z;
        File file;
        File file2;
        synchronized (this.mBurstShotTempDirectoryLock) {
            e.a(TAG, "createBurstShotFlagFile, burstShotFlagId: " + j);
            z = true;
            try {
                if (z.c()) {
                    file2 = new File(z.a());
                    file = new File(file2.getAbsolutePath() + File.separator + j + BURST_SHOT_TEMP_DIRECTORY_FLAG);
                } else {
                    String a2 = z.a(String.valueOf(j), "");
                    file2 = new File(a2);
                    file = new File(a2 + File.separator + BURST_SHOT_TEMP_DIRECTORY_FLAG);
                }
                if (!file2.exists() || !file2.isDirectory()) {
                    e.a(TAG, "createBurstShotFlagFile, make directory");
                    z = file2.mkdirs();
                }
                if (!file.exists() || !file.isFile()) {
                    e.a(TAG, "createBurstShotFlagFile, path: " + file.getAbsolutePath());
                    z = file.createNewFile();
                }
            } catch (Exception e) {
                e.printStackTrace();
                z = false;
                e.e(TAG, "createBurstShotFlagFile, Exception");
            }
        }
        return z;
    }

    private boolean deleteBurstShotFlagFile(long j) {
        boolean z;
        File file;
        File file2;
        synchronized (this.mBurstShotTempDirectoryLock) {
            e.a(TAG, "deleteBurstShotFlagFile, burstShotFlagId: " + j);
            z = false;
            try {
                if (z.c()) {
                    file2 = new File(z.a());
                    file = new File(file2.getAbsolutePath() + File.separator + j + BURST_SHOT_TEMP_DIRECTORY_FLAG);
                } else {
                    String a2 = z.a(String.valueOf(j), "");
                    file2 = new File(a2);
                    file = new File(a2 + File.separator + BURST_SHOT_TEMP_DIRECTORY_FLAG);
                }
                boolean z2 = true;
                if (!file2.exists() || !file.exists()) {
                    z = true;
                } else {
                    e.a(TAG, "deleteBurstShotFlagFile, path: " + file.getAbsolutePath());
                    boolean delete = file.delete();
                    e.a(TAG, "deleteBurstShotFlagFile, notify gallery start");
                    ContentResolver contentResolver = getContentResolver();
                    if (!"on".equals(z.r) || !z.d()) {
                        z2 = false;
                    }
                    contentResolver.notifyChange(z.c(z2), (ContentObserver) null);
                    e.a(TAG, "deleteBurstShotFlagFile, notify gallery end");
                    z = delete;
                }
            } catch (Exception e) {
                e.printStackTrace();
                e.e(TAG, "deleteBurstShotFlagFile, Exception");
            }
        }
        return z;
    }

    private void savePicture(ThumbnailCategory thumbnailCategory, ApsResult apsResult) {
        ApsAdapterInterface apsAdapterInterface;
        ImageCategory.ImageItemInfo imageItemInfo = thumbnailCategory.mImageItemInfo;
        ThumbnailItem thumbnailItem = thumbnailCategory.mThumbnailItem;
        ImageCategory.MetaItemInfo metaItemInfo = thumbnailCategory.mMetaItemInfo;
        if (((Boolean) imageItemInfo.get(ParameterKeys.KEY_BURST_SHOT)).booleanValue() && (apsAdapterInterface = this.mApsAdapter) != null) {
            apsAdapterInterface.countBurstShot(imageItemInfo, metaItemInfo);
        }
        z.a aVar = new z.a();
        aVar.f3177a = thumbnailItem.mResolver;
        aVar.h = thumbnailItem.mJpegName;
        aVar.e = apsResult.mCopyBuffer;
        aVar.c = thumbnailItem.mUri;
        aVar.q = apsResult.mWidth;
        aVar.r = apsResult.mHeight;
        aVar.t = apsResult.mScanline;
        aVar.s = apsResult.mStride;
        aVar.f3178b = apsResult.mExifData;
        aVar.p = ((Integer) imageItemInfo.get(ParameterKeys.KEY_REC_BURST_NUMBER)).intValue();
        aVar.j = thumbnailItem.mPictureFormat;
        aVar.x = true;
        aVar.J = thumbnailItem.mTimeStamp;
        aVar.F = thumbnailItem.mbLockScreen;
        aVar.o = ((Long) imageItemInfo.get(ParameterKeys.KEY_BURST_SHOT_FLAG_ID)).longValue();
        aVar.m = (String) imageItemInfo.get(ParameterKeys.KEY_CSHOT_PATH);
        aVar.G = (String) metaItemInfo.get(ParameterKeys.KEY_PICTURE_EXIF_FLAG);
        aVar.R = thumbnailItem.mbUltraHighResolution;
        if (thumbnailItem.mCameraUiUpdateThumbnail != null) {
            aVar.A = thumbnailItem.mCameraUiUpdateThumbnail;
            aVar.w = thumbnailItem.mThumbnailWidth;
        }
        e.a(TAG, "savePicture, metaItemInfo.mDate: " + metaItemInfo.get(ParameterKeys.KEY_DATE) + " imageItemInfo.mDate: " + imageItemInfo.get(ParameterKeys.KEY_DATE));
        e.a("CameraCapturePerformance.savePicture");
        if (((Long) metaItemInfo.get(ParameterKeys.KEY_DATE)).longValue() != 0) {
            aVar.n = ((Long) metaItemInfo.get(ParameterKeys.KEY_DATE)).longValue();
        } else {
            aVar.n = ((Long) imageItemInfo.get(ParameterKeys.KEY_DATE)).longValue();
        }
        aVar.v = Util.b(aVar.e);
        if (thumbnailItem.mIdentity == this.mLatestThumbnailIdentity) {
            aVar.K = true;
        }
        aVar.T = ((Boolean) imageItemInfo.get(ParameterKeys.KEY_IS_SUPER_TEXT_OPEN)).booleanValue();
        if (imageItemInfo.get(ParameterKeys.KEY_SUPER_TEXT_RESULT_PROCESSOR) != null && apsResult.mbHasSTResult) {
            aVar.M = Util.b(BitmapFactory.decodeByteArray(aVar.e, 0, aVar.e.length), ((float) Util.E()) / ((float) (apsResult.mSTHeight < apsResult.mSTWidth ? apsResult.mSTHeight : apsResult.mSTWidth)));
            aVar.M = Util.a(aVar.M, (360 - ((Integer) metaItemInfo.get(ParameterKeys.KEY_ORIENTATION)).intValue()) % 360);
            aVar.L = (com.oppo.camera.a.e) imageItemInfo.get(ParameterKeys.KEY_SUPER_TEXT_RESULT_PROCESSOR);
            aVar.P = apsResult.mbHasSTResult;
            aVar.Q = ((Integer) metaItemInfo.get(ParameterKeys.KEY_ORIENTATION)).intValue();
        }
        if ("heic_8bits".equalsIgnoreCase(aVar.j) || "heic_10bits".equalsIgnoreCase(aVar.j)) {
            aVar.E = true;
        }
        aVar.O = (d) imageItemInfo.get(ParameterKeys.KEY_PICTURE_TAKEN_CALL_BACK);
        if (thumbnailItem.mProductProcessor != null) {
            thumbnailItem.mProductProcessor.a(aVar);
        } else {
            com.oppo.camera.n.b.a().c(aVar);
        }
        imageItemInfo.setParameter(ParameterKeys.KEY_IMAGE_WIDTH, Integer.valueOf(apsResult.mWidth));
        imageItemInfo.setParameter(ParameterKeys.KEY_IMAGE_HEIGHT, Integer.valueOf(apsResult.mHeight));
        if (imageItemInfo.mApsServiceListener != null && !((Boolean) imageItemInfo.get(ParameterKeys.KEY_BURST_SHOT)).booleanValue()) {
            if (thumbnailCategory.mCaptureMsgData != null) {
                thumbnailCategory.mCaptureMsgData.mMultiFrameNum = String.valueOf((apsResult.mNoiseReductionStrength >> 4) & 15);
                thumbnailCategory.mCaptureMsgData.mLostFrameNum = String.valueOf(((apsResult.mNoiseReductionStrength >> 4) & 15) - (apsResult.mNoiseReductionStrength & 15));
            }
            imageItemInfo.mApsServiceListener.reportCaptureDataToDcs(thumbnailCategory, aVar);
        }
        e.b("CameraCapturePerformance.savePicture");
        e.e(TAG, "savePicture, End");
    }

    public IBinder onBind(Intent intent) {
        e.a(TAG, "onBind, this: " + this);
        synchronized (this.mOppoWhiteListLock) {
            if (this.mOppoWhiteListManager == null) {
                this.mOppoWhiteListManager = new OplusWhiteListManager(this);
            }
        }
        ApsAdapterInterface apsAdapterInterface = this.mApsAdapter;
        if (apsAdapterInterface != null) {
            apsAdapterInterface.connectAps(Util.p());
        }
        return this.mBinder;
    }

    public void onCreate() {
        e.a(TAG, "onCreate, mApsAdapter: " + this.mApsAdapter);
        super.onCreate();
        startForeground();
        if (this.mApsAdapter == null) {
            this.mApsAdapter = new ApsAdapterImpl(this);
        }
    }

    public void onDestroy() {
        e.b(TAG, "onDestroy");
        stopForeground(true);
        ApsAdapterInterface apsAdapterInterface = this.mApsAdapter;
        if (apsAdapterInterface != null) {
            apsAdapterInterface.onDestroy();
        }
        super.onDestroy();
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        e.b(TAG, "onStartCommand");
        super.onStartCommand(intent, i, i2);
        startForeground();
        return 1;
    }

    private void startForeground() {
        if (Build.VERSION.SDK_INT > 26) {
            startForeground(1, new h.d(this, createNotificationChannel("com.oppo.camera", getString(R.string.camera_app_name))).a(true).c(-2).a("service").b());
        } else {
            startForeground(1, new Notification());
        }
    }

    private String createNotificationChannel(String str, String str2) {
        NotificationChannel notificationChannel = new NotificationChannel(str, str2, 0);
        notificationChannel.setLightColor(-16711936);
        notificationChannel.setLockscreenVisibility(0);
        ((NotificationManager) getSystemService("notification")).createNotificationChannel(notificationChannel);
        return str;
    }

    private void addStageProtectInfo(String str) {
        synchronized (this.mOppoWhiteListLock) {
            if (this.mOppoWhiteListManager != null) {
                ArrayList stageProtectListFromPkg = this.mOppoWhiteListManager.getStageProtectListFromPkg(str, 0);
                StringBuilder sb = new StringBuilder("StageProtectList: ");
                Iterator it = stageProtectListFromPkg.iterator();
                while (it.hasNext()) {
                    sb.append("[");
                    sb.append((String) it.next());
                    sb.append("] ");
                }
                e.b(TAG, "addStageProtectInfo, nameBuilder: " + sb.toString());
                if (!stageProtectListFromPkg.contains(getPackageName())) {
                    this.mOppoWhiteListManager.addStageProtectInfo(str, SELF_PROTECT_ADD_TIME);
                }
            }
        }
    }

    private void removeStageProtectInfo(String str) {
        synchronized (this.mOppoWhiteListLock) {
            if (this.mOppoWhiteListManager != null) {
                e.b(TAG, "removeStageProtectInfo, pkgName: " + str);
                this.mOppoWhiteListManager.removeStageProtectInfo(str);
            }
        }
    }

    public void onBeforeOpenCamera() {
        ApsAdapterInterface apsAdapterInterface = this.mApsAdapter;
        if (apsAdapterInterface != null) {
            apsAdapterInterface.onBeforeOpenCamera();
        }
    }

    public void init(ApsInitParameter apsInitParameter) {
        ApsAdapterInterface apsAdapterInterface = this.mApsAdapter;
        if (apsAdapterInterface != null) {
            apsAdapterInterface.init(apsInitParameter);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x003c, code lost:
        return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.HashSet<java.lang.String> getSloganPathsInUse() {
        /*
            r5 = this;
            java.util.HashSet r0 = new java.util.HashSet
            r0.<init>()
            java.lang.Object r1 = r5.mThumbnailMapLock
            monitor-enter(r1)
            java.util.concurrent.ConcurrentHashMap<java.lang.Long, com.oppo.camera.aps.service.ThumbnailCategory> r2 = r5.mThumbnailMap     // Catch:{ all -> 0x003d }
            if (r2 == 0) goto L_0x003b
            java.util.concurrent.ConcurrentHashMap<java.lang.Long, com.oppo.camera.aps.service.ThumbnailCategory> r2 = r5.mThumbnailMap     // Catch:{ all -> 0x003d }
            int r2 = r2.size()     // Catch:{ all -> 0x003d }
            if (r2 != 0) goto L_0x0015
            goto L_0x003b
        L_0x0015:
            java.util.concurrent.ConcurrentHashMap<java.lang.Long, com.oppo.camera.aps.service.ThumbnailCategory> r2 = r5.mThumbnailMap     // Catch:{ all -> 0x003d }
            java.util.Collection r2 = r2.values()     // Catch:{ all -> 0x003d }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x003d }
        L_0x001f:
            boolean r3 = r2.hasNext()     // Catch:{ all -> 0x003d }
            if (r3 == 0) goto L_0x0039
            java.lang.Object r3 = r2.next()     // Catch:{ all -> 0x003d }
            com.oppo.camera.aps.service.ThumbnailCategory r3 = (com.oppo.camera.aps.service.ThumbnailCategory) r3     // Catch:{ all -> 0x003d }
            com.oppo.camera.aps.adapter.ImageCategory$MetaItemInfo r3 = r3.mMetaItemInfo     // Catch:{ all -> 0x003d }
            if (r3 == 0) goto L_0x001f
            com.oppo.camera.aps.adapter.ApsParameters$Key<java.lang.String> r4 = com.oppo.camera.aps.constant.ParameterKeys.KEY_WATERMARK_PATH     // Catch:{ all -> 0x003d }
            java.lang.Object r3 = r3.get(r4)     // Catch:{ all -> 0x003d }
            r0.add(r3)     // Catch:{ all -> 0x003d }
            goto L_0x001f
        L_0x0039:
            monitor-exit(r1)     // Catch:{ all -> 0x003d }
            return r0
        L_0x003b:
            monitor-exit(r1)     // Catch:{ all -> 0x003d }
            return r0
        L_0x003d:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x003d }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.aps.service.ApsService.getSloganPathsInUse():java.util.HashSet");
    }

    public int beforeCapture(ImageCategory.MetaItemInfo metaItemInfo) {
        this.mbCapturing = true;
        ApsAdapterInterface apsAdapterInterface = this.mApsAdapter;
        if (apsAdapterInterface != null) {
            return apsAdapterInterface.beforeCapture(metaItemInfo);
        }
        return -1;
    }

    public void setCapturing(boolean z) {
        e.a(TAG, "setCapturing, capturing: " + this.mbCapturing + " -> " + z);
        this.mbCapturing = z;
    }

    public void addCaptureMetaInfo(ImageCategory.MetaItemInfo metaItemInfo, CaptureMsgData captureMsgData) {
        if (this.mApsAdapter != null) {
            metaItemInfo.setParameter(ParameterKeys.KEY_CAPTURE_MSG_DATA, captureMsgData);
            this.mApsAdapter.addMetadata(metaItemInfo);
        }
    }

    public void addCaptureImageInfo(ImageCategory.ImageItemInfo imageItemInfo) {
        ApsAdapterInterface apsAdapterInterface = this.mApsAdapter;
        if (apsAdapterInterface != null) {
            apsAdapterInterface.addImage(imageItemInfo);
        }
    }

    public boolean isApsProcessing() {
        return this.mbCapturing;
    }

    public void addTuningInfo(ImageCategory.TuningItemInfo tuningItemInfo) {
        ApsAdapterInterface apsAdapterInterface = this.mApsAdapter;
        if (apsAdapterInterface != null) {
            apsAdapterInterface.addTuningItem(tuningItemInfo);
        }
    }

    public void addVideoImageInfo(ImageCategory.ImageItemInfo imageItemInfo) {
        ApsAdapterInterface apsAdapterInterface = this.mApsAdapter;
        if (apsAdapterInterface != null) {
            apsAdapterInterface.addVideoImage(imageItemInfo);
        }
    }

    public void addThumbnailInfo(ThumbnailItem thumbnailItem) {
        synchronized (this.mThumbnailMapLock) {
            long j = thumbnailItem.mIdentity;
            e.b(TAG, "addThumbnailInfo, timeStamp: " + j + ", mThumbnailMap: " + this.mThumbnailMap);
            if (this.mThumbnailMap != null) {
                if (j > this.mLatestThumbnailIdentity) {
                    this.mLatestThumbnailIdentity = j;
                }
                if (this.mThumbnailMap.containsKey(Long.valueOf(j))) {
                    ThumbnailCategory thumbnailCategory = this.mThumbnailMap.get(Long.valueOf(j));
                    thumbnailCategory.mThumbnailItem = thumbnailItem;
                    if (thumbnailCategory.isValid() && thumbnailCategory.mApsResult != null) {
                        savePicture(thumbnailCategory, thumbnailCategory.mApsResult);
                        this.mThumbnailMap.remove(Long.valueOf(j));
                    }
                } else {
                    ThumbnailCategory thumbnailCategory2 = new ThumbnailCategory();
                    thumbnailCategory2.mThumbnailItem = thumbnailItem;
                    this.mThumbnailMap.put(Long.valueOf(j), thumbnailCategory2);
                }
            }
            addStageProtectInfo(getPackageName());
        }
    }

    public void waitAddFrame(boolean z) {
        ApsAdapterInterface apsAdapterInterface = this.mApsAdapter;
        if (apsAdapterInterface != null) {
            apsAdapterInterface.waitAddFrameFinish(z);
        }
        synchronized (this.mThumbnailMapLock) {
            if (this.mThumbnailMap != null && !this.mThumbnailMap.isEmpty()) {
                for (Long next : this.mThumbnailMap.keySet()) {
                    ThumbnailCategory thumbnailCategory = this.mThumbnailMap.get(next);
                    if (!(thumbnailCategory == null || thumbnailCategory.isValid() || thumbnailCategory.mThumbnailItem == null)) {
                        e.e(TAG, "waitAddFrame, mThumbnailItem: " + thumbnailCategory.mThumbnailItem.toString());
                        this.mThumbnailMap.remove(next);
                        deleteThumbnailAndCache(thumbnailCategory.mThumbnailItem);
                    }
                }
            }
            this.mLatestThumbnailIdentity = 0;
        }
    }

    private void deleteThumbnailAndCache(ThumbnailItem thumbnailItem) {
        if (thumbnailItem != null) {
            e.b(TAG, "deleteThumbnailAndCache, thumbnailItem: " + thumbnailItem.toString());
            z.a aVar = new z.a();
            aVar.f3177a = thumbnailItem.mResolver;
            aVar.c = thumbnailItem.mUri;
            aVar.x = false;
            aVar.F = thumbnailItem.mbLockScreen;
            aVar.B = thumbnailItem.mUpdateLastThumbTask;
            com.oppo.camera.n.b.a().c(aVar);
        }
    }

    public void onDecisionControlData(ApsAdapterDecision.DecisionControlData decisionControlData) {
        ApsAdapterInterface apsAdapterInterface = this.mApsAdapter;
        if (apsAdapterInterface != null) {
            apsAdapterInterface.onDecisionControlData(decisionControlData);
        }
    }

    public boolean checkRuntimeState(long j, long j2, long j3) {
        long j4 = j;
        long j5 = j3;
        ApsAdapterInterface apsAdapterInterface = this.mApsAdapter;
        if (apsAdapterInterface == null) {
            e.b(TAG, "checkRuntimeState, mApsAdapter is null");
            return false;
        }
        long j6 = j2 * 1048576;
        long j7 = (long) (((float) j5) * MAX_AVAILABLE_MEMORY_RATIO);
        APSClient.APSRuntimeInfo runtimeInfo = apsAdapterInterface.getRuntimeInfo();
        if (runtimeInfo == null) {
            e.b(TAG, "checkRuntimeState, runtimeInfo is null");
            return false;
        }
        long j8 = ((long) runtimeInfo.mInputMemSize) * 1048576;
        int i = runtimeInfo.mSingleAlgoMaxRunMem;
        String str = TAG;
        long j9 = ((long) i) * 1048576;
        int i2 = runtimeInfo.mTotalTimeEstimate;
        e.b(str, "checkRuntimeState, needMemory: " + j4 + ", totalMemory: " + j5 + ", maxAvailableMemory: " + j7 + ", mInputMemSize: " + j8 + ", singleAlgoMaxRunMem: " + j9 + ", cameraMem: " + j6 + ", timeLimit: " + 25000 + ", totalTimeEstimate: " + i2);
        return ((j8 + j4) + j6) + j9 < j7 && ((long) i2) < 25000;
    }

    public boolean checkApsIsProcessing() {
        APSClient.APSRuntimeInfo runtimeInfo = this.mApsAdapter.getRuntimeInfo();
        if (runtimeInfo == null) {
            return false;
        }
        long j = ((long) runtimeInfo.mInputMemSize) * 1048576;
        e.b(TAG, "checkApsIsProcessing, inputMemSize: " + j);
        if (j > 0) {
            return true;
        }
        return false;
    }

    public void closeCamera() {
        e.a(TAG, "closeCamera");
        ApsAdapterInterface apsAdapterInterface = this.mApsAdapter;
        if (apsAdapterInterface != null) {
            apsAdapterInterface.closeCamera();
        }
    }

    public void notifyErrorType(ApsFailure apsFailure) {
        e.e(TAG, "notifyErrorType, failure: " + apsFailure);
        int i = apsFailure.mType;
        if (i == 1) {
            handleCaptureFailed(apsFailure.mTimestamp, apsFailure.mImageNums, apsFailure.mMergeNums, apsFailure.mImageItemInfo);
        } else if (i == 2) {
            handlePreviewFailed(apsFailure.mFrameNumber);
        }
    }

    private void handleCaptureFailed(long j, int i, int i2, ImageCategory.ImageItemInfo imageItemInfo) {
        synchronized (this.mThumbnailMapLock) {
            if (this.mThumbnailMap.get(Long.valueOf(j)) != null) {
                deleteThumbnailAndCache(this.mThumbnailMap.get(Long.valueOf(j)).mThumbnailItem);
            }
            this.mThumbnailMap.remove(Long.valueOf(j));
            this.mLatestThumbnailIdentity = 0;
        }
        ApsAdapterInterface apsAdapterInterface = this.mApsAdapter;
        if (apsAdapterInterface != null) {
            apsAdapterInterface.onCaptureFailed(j, i, i2, true, imageItemInfo);
        }
    }

    public void addPreviewMetaInfo(ImageCategory.MetaItemInfo metaItemInfo) {
        ApsAdapterInterface apsAdapterInterface = this.mApsAdapter;
        if (apsAdapterInterface != null) {
            apsAdapterInterface.addPreviewMetadata(metaItemInfo);
        }
    }

    public void addPreviewImageInfo(ImageCategory.ImageItemInfo imageItemInfo) {
        ApsAdapterInterface apsAdapterInterface = this.mApsAdapter;
        if (apsAdapterInterface != null) {
            apsAdapterInterface.addPreviewImage(imageItemInfo);
        }
    }

    public void videoSnapshot(ApsAdapterListener.CaptureCallback captureCallback, com.oppo.camera.f.d dVar) {
        ApsAdapterInterface apsAdapterInterface = this.mApsAdapter;
        if (apsAdapterInterface != null) {
            apsAdapterInterface.videoSnapshot(captureCallback, Util.a(dVar, (ImageCategory.MetaItemInfo) null));
        }
    }

    public class LocalBinder extends Binder {
        public LocalBinder() {
        }

        public ApsService getService() {
            return ApsService.this;
        }
    }

    public int setEnableAPSPipeline(String str, boolean z) {
        return this.mApsAdapter.setEnableAPSPipeline(str, z);
    }

    public int setEnableAPSAlgoNode(String str, boolean z) {
        return this.mApsAdapter.setEnableAPSAlgoNode(str, z);
    }

    public int forceStop() {
        return this.mApsAdapter.forceStop();
    }

    public void setPermitProcess(ImageCategory.ItemInfoType itemInfoType, boolean z) {
        this.mApsAdapter.setPermitProcess(itemInfoType, z);
    }

    public Rect[] roiTranslate(Rect[] rectArr) {
        return this.mApsAdapter.roiTranslate(rectArr);
    }

    public void setRequestMetadata(String str, ArrayMap<String, Long> arrayMap, int i, int i2) {
        this.mApsAdapter.setRequestMetadata(str, arrayMap, i, i2);
    }

    public void sessionClosed(boolean z) {
        ApsAdapterInterface apsAdapterInterface = this.mApsAdapter;
        if (apsAdapterInterface != null) {
            apsAdapterInterface.sessionClosed(z);
        }
    }

    public void unInitApsAlgo(int i) {
        ApsAdapterInterface apsAdapterInterface = this.mApsAdapter;
        if (apsAdapterInterface != null) {
            apsAdapterInterface.unInitApsAlgo(i);
        }
    }

    public static class ApsFailure {
        public static final int TYPE_CAPTURE_FAIL = 1;
        public static final int TYPE_NONE = 0;
        public static final int TYPE_PREVIEW_FAIL = 2;
        public long mFrameNumber;
        public ImageCategory.ImageItemInfo mImageItemInfo;
        public int mImageNums;
        public int mMergeNums;
        public long mTimestamp;
        public int mType;

        public ApsFailure(int i, long j) {
            this(i, j, 0, 0, 0, (ImageCategory.ImageItemInfo) null);
        }

        public ApsFailure(int i, long j, long j2, int i2, int i3, ImageCategory.ImageItemInfo imageItemInfo) {
            this.mType = 0;
            this.mFrameNumber = -1;
            this.mTimestamp = 0;
            this.mImageNums = 0;
            this.mMergeNums = 0;
            this.mImageItemInfo = null;
            this.mType = i;
            this.mFrameNumber = j;
            this.mTimestamp = j2;
            this.mImageNums = i2;
            this.mMergeNums = i3;
            this.mImageItemInfo = imageItemInfo;
        }

        public String toString() {
            return "{" + "mType: " + this.mType + ", mFrameNumber: " + this.mFrameNumber + ", mTimestamp: " + this.mTimestamp + ", mImageNums: " + this.mImageNums + ", mMergeNums: " + this.mMergeNums + ", mImageItemInfo: " + this.mImageItemInfo + "}";
        }
    }
}
