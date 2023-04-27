package com.oppo.camera.aps.service;

import android.content.ContentResolver;
import android.graphics.Bitmap;
import android.net.Uri;
import com.oppo.camera.a.b;
import com.oppo.camera.ui.control.e;

public class ThumbnailItem {
    public e.a mCameraUiUpdateThumbnail = null;
    public long mDate = 0;
    public long mIdentity = 0;
    public String mJpegName = null;
    public int mOrientation = 0;
    public Bitmap mOriginBitmap;
    public String mPictureFormat = null;
    public b mProductProcessor = null;
    public long mRequestHash = 0;
    public ContentResolver mResolver = null;
    public Bitmap mThumbBitmap = null;
    public int mThumbnailWidth = 0;
    public long mTimeStamp = 0;
    public e.a mUpdateLastThumbTask = null;
    public Uri mUri = null;
    public boolean mbBurstShot = false;
    public boolean mbLockScreen = false;
    public boolean mbMirror = false;
    public boolean mbUltraHighResolution = false;

    public String toString() {
        return "mUri: " + this.mUri + ", mResolver: " + this.mResolver + ", mPictureFormat: " + this.mPictureFormat + ", mJpegName: " + this.mJpegName + ", mThumbBitmap: " + this.mThumbBitmap + ", mOrientation: " + this.mOrientation + ", mTimeStamp: " + this.mTimeStamp + ", mIdentity: " + this.mIdentity + ", mbBurstShot: " + this.mbBurstShot + ", mProductProcessor: " + this.mProductProcessor + ", mDate: " + this.mDate + ", mThumbnailWidth: " + this.mThumbnailWidth + ", mbLockScreen: " + this.mbLockScreen + ", mCameraUiUpdateThumbnail: " + this.mCameraUiUpdateThumbnail;
    }
}
