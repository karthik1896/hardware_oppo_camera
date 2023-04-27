package com.oppo.camera.aps.service;

import android.content.ContentResolver;
import android.graphics.Bitmap;
import android.net.Uri;
import android.util.Size;
import com.oppo.camera.e.g;
import com.oppo.camera.f.a;
import com.oppo.camera.f.d;
import com.oppo.camera.ui.control.e;
import com.oppo.camera.util.Util;
import com.oppo.camera.z;
import java.util.ArrayList;

public class ThumbnailProcessor extends Thread {
    private static final String TAG = "ThumbnailProcessor";
    private static final float THUMBNAIL_SCALE_SIZE = 0.6f;
    private final Object mLock = new Object();
    private ThumbnailProcessListener mThumbNailProcessListener = null;
    private ArrayList<DataRequest> mThumbNailQueue = new ArrayList<>();
    private volatile boolean mbDestroyed = false;
    private boolean mbProcessingThumbnail = false;

    public static class DataRequest {
        public long mBurstShotFlagId = -1;
        public int mCameraId = 0;
        public String mCapMode = null;
        public g mContentOperatedCallback = null;
        public String mCshotPath = "";
        public long mDate = 0;
        public String mExif = null;
        public String mHeicCodecFormat = null;
        public long mIdentity = 0;
        public int mJpegOrientation = 0;
        public String mMirrorState = null;
        public Size mPictureSize = null;
        public Size mPreviewSize = null;
        public int mRecBurstNum = 0;
        public long mRequestHash = 0;
        public d.a mRequestMode = null;
        public ContentResolver mResolver = null;
        public Bitmap mThumbBitmap = null;
        public byte[] mThumbData = null;
        public int mThumbOrientation = 0;
        public long mTimeStamp = 0;
        public String mTitle = null;
        public boolean mbBurstShot = false;
        public boolean mbLockScreen = false;
        public boolean mbSuperClearPortrait = false;
        public boolean mbUltraHighResolution = false;
        public boolean mbUseHeifCodec = false;
    }

    public interface ThumbnailProcessListener {
        void updateLastThumbnailView(Uri uri, ContentResolver contentResolver);

        void updateLastThumbnailView(boolean z);

        void updateThumbnail(e eVar, ThumbnailItem thumbnailItem, ContentResolver contentResolver);
    }

    public ThumbnailProcessor() {
        setName(TAG);
        this.mThumbNailQueue = new ArrayList<>();
        start();
    }

    public void setThumbNailProcessListener(ThumbnailProcessListener thumbnailProcessListener) {
        synchronized (this.mLock) {
            this.mThumbNailProcessListener = thumbnailProcessListener;
        }
    }

    public void addQueue(DataRequest dataRequest) {
        synchronized (this) {
            this.mThumbNailQueue.add(dataRequest);
            notifyAll();
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:6|(2:8|(1:10)(1:11))|14|15|16) */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001e, code lost:
        generateThumbnailAndUri(r0);
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x0025 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r2 = this;
        L_0x0000:
            monitor-enter(r2)
            boolean r0 = r2.mbDestroyed     // Catch:{ all -> 0x0027 }
            if (r0 == 0) goto L_0x0007
            monitor-exit(r2)     // Catch:{ all -> 0x0027 }
            return
        L_0x0007:
            java.util.ArrayList<com.oppo.camera.aps.service.ThumbnailProcessor$DataRequest> r0 = r2.mThumbNailQueue     // Catch:{ all -> 0x0027 }
            if (r0 == 0) goto L_0x0022
            java.util.ArrayList<com.oppo.camera.aps.service.ThumbnailProcessor$DataRequest> r0 = r2.mThumbNailQueue     // Catch:{ all -> 0x0027 }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x0027 }
            if (r0 == 0) goto L_0x0014
            goto L_0x0022
        L_0x0014:
            java.util.ArrayList<com.oppo.camera.aps.service.ThumbnailProcessor$DataRequest> r0 = r2.mThumbNailQueue     // Catch:{ all -> 0x0027 }
            r1 = 0
            java.lang.Object r0 = r0.remove(r1)     // Catch:{ all -> 0x0027 }
            com.oppo.camera.aps.service.ThumbnailProcessor$DataRequest r0 = (com.oppo.camera.aps.service.ThumbnailProcessor.DataRequest) r0     // Catch:{ all -> 0x0027 }
            monitor-exit(r2)     // Catch:{ all -> 0x0027 }
            r2.generateThumbnailAndUri(r0)
            goto L_0x0000
        L_0x0022:
            r2.wait()     // Catch:{ InterruptedException -> 0x0025 }
        L_0x0025:
            monitor-exit(r2)     // Catch:{ all -> 0x0027 }
            goto L_0x0000
        L_0x0027:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0027 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.aps.service.ThumbnailProcessor.run():void");
    }

    private void generateThumbnailAndUri(DataRequest dataRequest) {
        Bitmap bitmap;
        int i;
        int i2;
        com.oppo.camera.e.a(TAG, "generateThumbnailAndUri");
        this.mbProcessingThumbnail = true;
        if (dataRequest.mThumbData != null) {
            if (a.c(dataRequest.mCameraId)) {
                bitmap = Util.a(dataRequest.mThumbData, dataRequest.mPreviewSize.getWidth(), dataRequest.mPreviewSize.getHeight(), 270, 2, false);
                if (bitmap == null) {
                    com.oppo.camera.e.e(TAG, "generateThumbnailAndUri, bitmap is null");
                    return;
                }
                int i3 = dataRequest.mThumbOrientation;
                if (i3 != 0) {
                    if (i3 == 90) {
                        bitmap = "off".equals(dataRequest.mMirrorState) ? Util.a(Util.b(bitmap), 90) : Util.a(bitmap, -90);
                    } else if (i3 == 180) {
                        bitmap = "off".equals(dataRequest.mMirrorState) ? Util.b(Util.a(bitmap, 180)) : Util.a(bitmap, 180);
                    } else if (i3 != 270) {
                        com.oppo.camera.e.e(TAG, "generateThumbnailAndUri, mOrientation: " + dataRequest.mThumbOrientation + " is wrong!!");
                    } else {
                        bitmap = "off".equals(dataRequest.mMirrorState) ? Util.a(Util.b(bitmap), -90) : Util.a(bitmap, 90);
                    }
                } else if ("off".equals(dataRequest.mMirrorState)) {
                    bitmap = Util.b(bitmap);
                }
            } else {
                bitmap = Util.a(Util.a(dataRequest.mThumbData, dataRequest.mPreviewSize.getWidth(), dataRequest.mPreviewSize.getHeight(), 90, 2, false), dataRequest.mThumbOrientation);
            }
        } else if (dataRequest.mThumbBitmap == null || dataRequest.mThumbBitmap.isRecycled()) {
            bitmap = null;
        } else {
            bitmap = Util.b(dataRequest.mThumbBitmap, (float) THUMBNAIL_SCALE_SIZE);
            if (a.c(dataRequest.mCameraId)) {
                int i4 = dataRequest.mThumbOrientation;
                if (i4 != 0) {
                    if (i4 == 90) {
                        bitmap = "on".equals(dataRequest.mMirrorState) ? Util.b(Util.a(bitmap, 90)) : Util.a(bitmap, 90);
                    } else if (i4 == 180) {
                        bitmap = "on".equals(dataRequest.mMirrorState) ? Util.b(Util.a(bitmap, 180)) : Util.a(bitmap, 180);
                    } else if (i4 != 270) {
                        com.oppo.camera.e.e(TAG, "generateThumbnailAndUri, mOrientation: " + dataRequest.mThumbOrientation + " is wrong!!");
                    } else {
                        bitmap = "on".equals(dataRequest.mMirrorState) ? Util.b(Util.a(bitmap, -90)) : Util.a(bitmap, -90);
                    }
                } else if ("on".equals(dataRequest.mMirrorState)) {
                    bitmap = Util.b(bitmap);
                }
            } else {
                bitmap = Util.a(bitmap, dataRequest.mThumbOrientation);
            }
        }
        if (bitmap != null) {
            int i5 = -1;
            if (dataRequest.mPictureSize != null) {
                if (dataRequest.mJpegOrientation % 180 == 0) {
                    i5 = -dataRequest.mPictureSize.getWidth();
                    i2 = dataRequest.mPictureSize.getHeight();
                } else {
                    i5 = -dataRequest.mPictureSize.getHeight();
                    i2 = dataRequest.mPictureSize.getWidth();
                }
                i = -i2;
            } else {
                i = -1;
            }
            z.a aVar = new z.a();
            aVar.h = dataRequest.mTitle;
            aVar.n = dataRequest.mDate;
            aVar.k = dataRequest.mCapMode;
            aVar.u = dataRequest.mCameraId;
            aVar.j = dataRequest.mHeicCodecFormat != null ? dataRequest.mHeicCodecFormat : "jpeg";
            if (d.a.CAPTURE_RAW == aVar.l) {
                aVar.j = "raw";
            }
            aVar.q = i5;
            aVar.r = i;
            aVar.G = dataRequest.mExif;
            aVar.f3177a = dataRequest.mResolver;
            aVar.p = dataRequest.mRecBurstNum;
            aVar.l = dataRequest.mRequestMode;
            aVar.o = dataRequest.mBurstShotFlagId;
            aVar.m = dataRequest.mCshotPath;
            aVar.g = bitmap;
            aVar.F = dataRequest.mbLockScreen;
            aVar.R = dataRequest.mbUltraHighResolution;
            aVar.S = dataRequest.mbSuperClearPortrait;
            aVar.V = dataRequest.mContentOperatedCallback;
            Uri b2 = z.b(aVar);
            com.oppo.camera.e.a(TAG, "generateThumbnailAndUri, uri: " + b2 + ", mbBurstShot: " + dataRequest.mbBurstShot);
            ThumbnailItem thumbnailItem = new ThumbnailItem();
            thumbnailItem.mUri = b2;
            thumbnailItem.mResolver = aVar.f3177a;
            thumbnailItem.mPictureFormat = dataRequest.mHeicCodecFormat != null ? dataRequest.mHeicCodecFormat : "jpeg";
            thumbnailItem.mJpegName = aVar.h;
            thumbnailItem.mThumbBitmap = aVar.g;
            thumbnailItem.mOriginBitmap = dataRequest.mThumbBitmap;
            thumbnailItem.mOrientation = dataRequest.mJpegOrientation;
            thumbnailItem.mTimeStamp = dataRequest.mTimeStamp;
            thumbnailItem.mIdentity = dataRequest.mIdentity;
            thumbnailItem.mbBurstShot = dataRequest.mbBurstShot;
            thumbnailItem.mDate = aVar.n;
            thumbnailItem.mRequestHash = dataRequest.mRequestHash;
            thumbnailItem.mbLockScreen = dataRequest.mbLockScreen;
            thumbnailItem.mbMirror = "off".equals(dataRequest.mMirrorState);
            thumbnailItem.mbUltraHighResolution = aVar.R;
            e a2 = e.a(aVar.g, 0, 1, b2, z.a(String.valueOf(aVar.n), aVar.j), aVar.n);
            a2.a(dataRequest.mRequestHash);
            synchronized (this.mLock) {
                if (this.mThumbNailProcessListener != null) {
                    this.mThumbNailProcessListener.updateThumbnail(a2, thumbnailItem, aVar.f3177a);
                }
            }
            if (z.c()) {
                com.oppo.camera.util.g.a().b(aVar.h, bitmap);
            } else {
                com.oppo.camera.util.g.a().a(aVar.h, bitmap);
            }
        }
        this.mbProcessingThumbnail = false;
    }

    public boolean isEmpty() {
        StringBuilder sb = new StringBuilder();
        sb.append("isEmpty, isEmpty:");
        ArrayList<DataRequest> arrayList = this.mThumbNailQueue;
        sb.append(arrayList != null ? Boolean.valueOf(arrayList.isEmpty()) : "null");
        sb.append(", !mbProcessingThumbnail: ");
        sb.append(!this.mbProcessingThumbnail);
        com.oppo.camera.e.a(TAG, sb.toString());
        ArrayList<DataRequest> arrayList2 = this.mThumbNailQueue;
        if ((arrayList2 == null || arrayList2.isEmpty()) && !this.mbProcessingThumbnail) {
            return true;
        }
        return false;
    }

    public void onDestroy() {
        com.oppo.camera.e.a(TAG, "onDestroy");
        this.mbDestroyed = true;
        synchronized (this) {
            notifyAll();
        }
    }
}
