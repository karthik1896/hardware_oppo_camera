package com.sensetime.faceapi;

import android.graphics.Bitmap;
import android.util.Log;
import com.sensetime.faceapi.model.CvPixelFormat;
import com.sensetime.faceapi.model.FaceConfig;
import com.sensetime.faceapi.model.FaceInfo;
import com.sensetime.faceapi.model.FaceOrientation;
import com.sensetime.faceapi.utils.ColorConvertUtil;

public class FaceTrack extends FaceHandleBase {
    private static final boolean DEBUG = true;
    private static final String TAG = "FaceTrack";

    public FaceTrack() {
        this((String) null, (String) null, (FaceConfig.FaceImageResize) null, (FaceConfig.FaceKeyPointCount) null, (FaceConfig.TrackThreadCount) null);
    }

    public FaceTrack(FaceConfig.FaceImageResize faceImageResize, FaceConfig.FaceKeyPointCount faceKeyPointCount, FaceConfig.TrackThreadCount trackThreadCount) {
        this((String) null, (String) null, faceImageResize, faceKeyPointCount, trackThreadCount);
    }

    public FaceTrack(String str, String str2, FaceConfig.FaceImageResize faceImageResize, FaceConfig.FaceKeyPointCount faceKeyPointCount, FaceConfig.TrackThreadCount trackThreadCount) {
        init(str, str2, (faceImageResize == null ? FaceConfig.FaceImageResize.RESIZE_320W : faceImageResize).getValue() | (faceKeyPointCount == null ? FaceConfig.FaceKeyPointCount.POINT_COUNT_21 : faceKeyPointCount).getValue() | (trackThreadCount == null ? FaceConfig.TrackThreadCount.DEFAULT_CONFIG : trackThreadCount).getValue());
    }

    private void init(String str, String str2, int i) {
        this.mCvFaceHandle = FaceLibrary.cvFaceCreateTracker(str, str2, i);
    }

    public FaceInfo[] track(int[] iArr, CvPixelFormat cvPixelFormat, int i, int i2, int i3, FaceOrientation faceOrientation) {
        FaceInfo[] cvFaceTrackInts = FaceLibrary.cvFaceTrackInts(this.mCvFaceHandle, iArr, cvPixelFormat.getValue(), i, i2, i3, faceOrientation.getValue(), this.mResultCode);
        checkResultCode();
        return cvFaceTrackInts;
    }

    public FaceInfo[] track(byte[] bArr, CvPixelFormat cvPixelFormat, int i, int i2, int i3, FaceOrientation faceOrientation) {
        FaceInfo[] cvFaceTrackBytes = FaceLibrary.cvFaceTrackBytes(this.mCvFaceHandle, bArr, cvPixelFormat.getValue(), i, i2, i3, faceOrientation.getValue(), this.mResultCode);
        checkResultCode();
        return cvFaceTrackBytes;
    }

    public FaceInfo[] track(Bitmap bitmap) {
        return track(bitmap, FaceOrientation.UP);
    }

    public FaceInfo[] track(Bitmap bitmap, FaceOrientation faceOrientation) {
        return track(bitmap, faceOrientation, (byte[]) null);
    }

    public FaceInfo[] track(Bitmap bitmap, FaceOrientation faceOrientation, byte[] bArr) {
        if (bitmap == null || bitmap.isRecycled()) {
            Log.w(TAG, "track image is null or Recycled");
            return null;
        }
        if (bitmap.getConfig() != Bitmap.Config.ARGB_8888) {
            bitmap.copy(Bitmap.Config.ARGB_8888, false);
        }
        if (bArr == null) {
            bArr = createBufferIfNeed(bitmap.getWidth(), bitmap.getHeight());
        } else if (bArr.length != bitmap.getWidth() * bitmap.getHeight() * 4) {
            throw new RuntimeException("detect buffer is illegal !");
        }
        byte[] bArr2 = bArr;
        ColorConvertUtil.getBGRADataFromBitmap(bitmap, bArr2);
        return track(bArr2, CvPixelFormat.BGRA8888, bitmap.getWidth(), bitmap.getHeight(), bitmap.getWidth() * 4, faceOrientation);
    }

    public FaceInfo[] track(byte[] bArr, CvPixelFormat cvPixelFormat, int i, int i2) {
        return track(bArr, cvPixelFormat, i, i2, FaceOrientation.UP);
    }

    public FaceInfo[] track(byte[] bArr, CvPixelFormat cvPixelFormat, int i, int i2, FaceOrientation faceOrientation) {
        return track(bArr, cvPixelFormat, i, i2, i, faceOrientation);
    }

    public FaceInfo[] track(int[] iArr, int i, int i2, FaceOrientation faceOrientation) {
        return track(iArr, CvPixelFormat.BGR888, i, i2, faceOrientation);
    }

    public FaceInfo[] track(int[] iArr, CvPixelFormat cvPixelFormat, int i, int i2, FaceOrientation faceOrientation) {
        return track(iArr, cvPixelFormat, i, i2, i * 4, faceOrientation);
    }

    public void reset() {
        if (!isHandleInitialized()) {
            Log.e(TAG, "reset Handle not Initialized");
        } else {
            FaceLibrary.cvFaceResetTracker(this.mCvFaceHandle);
        }
    }

    public void showInsideModelVersion() {
        FaceLibrary.cvFaceShowInsideModel();
    }

    public void setFaceTrackInterval(int i) {
        FaceLibrary.cvFaceTrackSetDetectInterval(this.mCvFaceHandle, i);
    }

    public void setFaceLimit(int i) {
        if (!isHandleInitialized()) {
            Log.e(TAG, "setFaceLimit Handle not Initialized");
            return;
        }
        long j = this.mCvFaceHandle;
        if (i <= 0) {
            i = -1;
        }
        checkResultCode(FaceLibrary.cvFaceTrackSetDetectFaceCntLimit(j, i));
    }

    /* access modifiers changed from: protected */
    public void releaseHandle() {
        FaceLibrary.cvFaceDestroyTracker(this.mCvFaceHandle);
    }
}
