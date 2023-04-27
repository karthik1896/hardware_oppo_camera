package com.oppo.camera.aps.adapter;

import android.hardware.HardwareBuffer;
import android.hardware.camera2.CaptureResult;
import android.media.Image;
import android.media.ImageReader;
import com.oppo.camera.aps.ApsAdapterLog;
import com.oppo.camera.aps.algorithm.ApsInterface;
import java.util.concurrent.atomic.AtomicInteger;

public class ApsResult {
    private static final String TAG = "ApsResult";
    public long mAppAlgoFlag = 0;
    public String mApsInitFinish = null;
    public int mBufferType = 0;
    public byte[] mCopyBuffer = null;
    public int mCropBottom = 0;
    public int mCropLeft = 0;
    public int mCropRight = 0;
    public int mCropTop = 0;
    public ApsExifData mExifData = null;
    public int mHeight = 0;
    private HardwareBuffer mHwbuffer = null;
    public long mIdentity = 0;
    private Image mImage = null;
    private ImageBuffer mImageBuffer = null;
    public int mIsLastVideoFrame = 0;
    public int mIsMotionDetected = 0;
    public int mIsStartInterpolationFrame = 0;
    public int mMessageType = 0;
    public CaptureResult mMetadata = null;
    public int mNoiseReductionStrength = 0;
    public String mPipelineName = null;
    public long mRefTimestamp = -1;
    public String[] mResultString = null;
    public int mRotation = 0;
    public int mSTHeight = 0;
    public int mSTWidth = 0;
    public int mScanline = 0;
    public int mStride = 0;
    public int mWidth = 0;
    public boolean mbHasSTResult = false;
    public boolean mbHeifProcessInAps = false;
    public boolean mbNeedDetach = false;

    public ApsResult() {
    }

    public ApsResult(Image image) {
        this.mImage = image;
    }

    public ImageBuffer getImageBuffer() {
        ImageBuffer imageBuffer = this.mImageBuffer;
        if (imageBuffer != null) {
            return imageBuffer;
        }
        Image image = this.mImage;
        if (image != null) {
            try {
                this.mImageBuffer = new ImageBuffer((ImageReader) null, image, image.getHardwareBuffer(), this.mIdentity, this.mMetadata);
            } catch (IllegalStateException e) {
                ApsAdapterLog.e(TAG, "getImageBuffer, get buffer from Image error.", e);
            }
        } else {
            HardwareBuffer hardwareBuffer = this.mHwbuffer;
            if (hardwareBuffer != null && !hardwareBuffer.isClosed()) {
                this.mImageBuffer = new ImageBuffer((ImageReader) null, (Image) null, this.mHwbuffer, this.mIdentity, this.mMetadata, 1, this.mPipelineName);
            }
        }
        return this.mImageBuffer;
    }

    public Image getImage() {
        return this.mImage;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ApsResult: {");
        sb.append("mMessageType: ");
        sb.append(this.mMessageType);
        sb.append(", mRotation: ");
        sb.append(this.mRotation);
        sb.append(", mBufferType: ");
        sb.append(this.mBufferType);
        sb.append(", mWidth: ");
        sb.append(this.mWidth);
        sb.append(", mHeight: ");
        sb.append(this.mHeight);
        sb.append(", mStride: ");
        sb.append(this.mStride);
        sb.append(", mScanline: ");
        sb.append(this.mScanline);
        sb.append(", mIdentity: ");
        sb.append(this.mIdentity);
        sb.append(", mAppAlgoFlag: ");
        sb.append(this.mAppAlgoFlag);
        sb.append(", mCopyBuffer.length: ");
        byte[] bArr = this.mCopyBuffer;
        sb.append(bArr != null ? bArr.length : 0);
        sb.append(", mCropLeft: ");
        sb.append(this.mCropLeft);
        sb.append(", mCropTop: ");
        sb.append(this.mCropTop);
        sb.append(", mCropRight: ");
        sb.append(this.mCropRight);
        sb.append(", mCropBottom: ");
        sb.append(this.mCropBottom);
        sb.append(", mSTWidth: ");
        sb.append(this.mSTWidth);
        sb.append(", mSTHeight: ");
        sb.append(this.mSTHeight);
        sb.append(", mbHasSTResult: ");
        sb.append(this.mbHasSTResult);
        sb.append(", mPipelineName: ");
        sb.append(this.mPipelineName);
        sb.append(", mNoiseReductionStrength: ");
        sb.append(this.mNoiseReductionStrength);
        sb.append(", mIsLastVideoFrame: ");
        sb.append(this.mIsLastVideoFrame);
        sb.append(", mIsStartInterpolationFrame: ");
        sb.append(this.mIsStartInterpolationFrame);
        sb.append(", mIsMotionDetected: ");
        sb.append(this.mIsMotionDetected);
        sb.append(", mMetadata: ");
        sb.append(this.mMetadata);
        sb.append(", mExifData: ");
        sb.append(this.mExifData);
        sb.append(", mImage: ");
        sb.append(this.mImage);
        sb.append(", mHwbuffer: ");
        sb.append(this.mHwbuffer);
        sb.append(", mImageBuffer: ");
        sb.append(this.mImageBuffer);
        sb.append("}");
        return sb.toString();
    }

    public static class ImageBuffer {
        private static final int REFERENCE_COUNT_ZERO = 0;
        private static final int TYPE_FROM_APP = 0;
        private static final int TYPE_FROM_APS = 1;
        private ApsInterface mApsInterface;
        private CaptureResult mCaptureResult;
        private HardwareBuffer mHardwareBuffer;
        private Image mImage;
        private ImageReader mImageReader;
        private String mPipelineName;
        private AtomicInteger mRef;
        private long mTimestamp;
        private int mType;

        public ImageBuffer(ImageReader imageReader, Image image, HardwareBuffer hardwareBuffer, long j) {
            this(imageReader, image, hardwareBuffer, j, (CaptureResult) null, 0, (String) null);
        }

        public ImageBuffer(ImageReader imageReader, Image image, HardwareBuffer hardwareBuffer, long j, CaptureResult captureResult) {
            this(imageReader, image, hardwareBuffer, j, captureResult, 0, (String) null);
        }

        public ImageBuffer(ImageReader imageReader, Image image, HardwareBuffer hardwareBuffer, long j, CaptureResult captureResult, int i, String str) {
            this.mImageReader = null;
            this.mImage = null;
            this.mHardwareBuffer = null;
            this.mTimestamp = 0;
            this.mRef = new AtomicInteger(1);
            this.mApsInterface = null;
            this.mCaptureResult = null;
            this.mType = 0;
            this.mPipelineName = null;
            this.mImageReader = imageReader;
            this.mImage = image;
            this.mHardwareBuffer = hardwareBuffer;
            this.mTimestamp = j;
            this.mCaptureResult = captureResult;
            this.mType = i;
            this.mPipelineName = str;
        }

        public final void setApsInterface(ApsInterface apsInterface) {
            this.mApsInterface = apsInterface;
        }

        public final ImageReader getImageReader() {
            return this.mImageReader;
        }

        public final Image getImage() {
            return this.mImage;
        }

        public final HardwareBuffer getHardwareBuffer() {
            return this.mHardwareBuffer;
        }

        public final long getTimestamp() {
            return this.mTimestamp;
        }

        public final CaptureResult getCaptureResult() {
            return this.mCaptureResult;
        }

        public final int addRef() {
            return this.mRef.addAndGet(1);
        }

        public final void close() {
            if (this.mRef.decrementAndGet() == 0) {
                ApsInterface apsInterface = this.mApsInterface;
                if (apsInterface != null && 1 == this.mType) {
                    apsInterface.releaseBuffer(this.mPipelineName, this.mHardwareBuffer);
                }
                this.mHardwareBuffer.close();
                Image image = this.mImage;
                if (image != null) {
                    image.close();
                }
            }
        }

        public String toString() {
            return "{ImageReader: " + this.mImageReader + ", Image: " + this.mImage + ",HardwareBuffer: " + this.mHardwareBuffer + ", TimeStamp: " + this.mTimestamp + ", Reference: " + this.mRef.get() + "}";
        }
    }
}
