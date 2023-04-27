package com.sensetime.faceapi;

import android.util.Log;
import com.sensetime.faceapi.model.CvPixelFormat;
import com.sensetime.faceapi.model.FaceConfig;
import com.sensetime.faceapi.model.FaceOrientation;

public class FigureSegment extends FaceHandleBase {
    public static final int CV_COMMON_SEGMENT_DEFLICKER = 16;
    public static final int CV_COMMON_SEGMENT_NV21MODEL = 8;
    public static final int CV_FACE_SEGMENT_ANTI_SHAKE = 2;
    public static final int CV_FACE_SEGMENT_REDUCE_HOLE = 4;
    public static final int CV_FACE_SEGMENT_RESET = 1;
    private static final boolean DEBUG = true;
    private static final String TAG = "FaceSegment";
    private static FigureSegment mInstance;
    private final Object mSyncObject = new Object();

    private FigureSegment() {
    }

    public static FigureSegment getInstance(String str, FaceConfig.FaceImageResize faceImageResize) {
        if (mInstance == null) {
            synchronized (FigureSegment.class) {
                if (mInstance == null) {
                    mInstance = new FigureSegment();
                }
            }
        }
        mInstance.initHandle(str, faceImageResize);
        return mInstance;
    }

    public void initHandle(String str, FaceConfig.FaceImageResize faceImageResize) {
        synchronized (this.mSyncObject) {
            if (this.mCvFaceHandle == 0) {
                this.mCvFaceHandle = FaceLibrary.cvFaceCreateFigureSeg(str, faceImageResize.getValue());
                Log.e(TAG, "cvFaceCreateFigureSeg handle: " + this.mCvFaceHandle);
            }
        }
    }

    public int createOutputBuffer(int i, int i2, int i3, int[] iArr) {
        return FaceLibrary.cvFaceFigureSegSetOuputLength(this.mCvFaceHandle, i, i2, i3, iArr);
    }

    public int segment(byte[] bArr, CvPixelFormat cvPixelFormat, int i, int i2, int i3, FaceOrientation faceOrientation, byte[] bArr2) {
        return segment(bArr, cvPixelFormat, i, i2, i3, faceOrientation, bArr2, 0);
    }

    public int segment(byte[] bArr, CvPixelFormat cvPixelFormat, int i, int i2, int i3, FaceOrientation faceOrientation, byte[] bArr2, int i4) {
        int cvFaceFigureSeg;
        Log.e(TAG, "segment width: " + i + " height: " + i2 + " stride: " + i3 + " orientation: " + faceOrientation.getValue());
        synchronized (this.mSyncObject) {
            cvFaceFigureSeg = FaceLibrary.cvFaceFigureSeg(this.mCvFaceHandle, bArr, cvPixelFormat.getValue(), i, i2, i3, faceOrientation.getValue(), bArr2, i4);
        }
        return cvFaceFigureSeg;
    }

    /* access modifiers changed from: protected */
    public void releaseHandle() {
        Log.e(TAG, "releaseHandle handle : " + this.mCvFaceHandle);
        synchronized (this.mSyncObject) {
            FaceLibrary.cvFaceDestroyFigureSeg(this.mCvFaceHandle);
            this.mCvFaceHandle = 0;
        }
    }
}
