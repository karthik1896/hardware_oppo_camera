package com.oppo.camera.aps.adapter;

import android.hardware.camera2.CaptureResult;
import java.util.Arrays;

public class ApsAdapterDecision {
    private static final float FLOAT_ONE = 1.0f;

    public interface DecisionCallback {
        void onDecisionResult(DecisionResult decisionResult);
    }

    public static class DecisionControlData {
        public int mCameraId = 0;
        public String mCaptureMode = null;
        public CaptureResult mCaptureResult = null;
        public DecisionCallback mDecisionCallback = null;
        public int mFaceBeautyEnable = 0;
        public int mFilterEnable = 0;
        public String mLogicCameraId = null;
        public int mLogicCameraType = 0;
        public int mNeonEnable = 0;
        public int mPiEnable = 0;
        public int mRecordingCapture = 0;
        public int mSCPEnable = 0;
        public int mStreamerEnable = 0;
        public int mSuperRawEnable = 0;
        public int mTripodEnable = 0;
        public int mUltraHighResolutionEnable = 0;
        public float mZoomValue = 1.0f;
    }

    public static class DecisionResult {
        public String[] mApsAlgoFlag = null;
        public int mApsBracketMode = 0;
        public int mApsDecisionFeatureType = 0;
        public int mApsDecisionSceneMode = 0;
        public int mAsdSceneValue = 0;
        public int mCameraId = -1;
        public long[] mCaptureETList = null;
        public int[] mCaptureEVList = null;
        public String mCaptureMode = null;
        public int mCaptureNoNeedMatchMeta = 0;
        public int mMFSRFrameCount = 0;
        public int mMasterPipeline = 0;
        public int mMetaIndex = 1;
        public int mMultiFrameCount = 1;
        public int mNightTotalExpTime = 0;
        public int mRequestFormat = 0;
        public int[] mSensorMask = null;
        public int mSuperNightScene = 0;
        public int mSupportCaptureZoomFeature = 0;
        public int mThumbnailIndex = 1;
        public boolean mbAIShutter = false;

        public String toString() {
            return "mCameraId: " + this.mCameraId + ", mCaptureMode: " + this.mCaptureMode + ", mRequestFormat: " + this.mRequestFormat + ", mMultiFrameCount: " + this.mMultiFrameCount + ", mThumbnailIndex: " + this.mThumbnailIndex + ", mMetaIndex: " + this.mMetaIndex + ", mSuperNightScene: " + this.mSuperNightScene + ", mNightTotalExpTime: " + this.mNightTotalExpTime + ", mApsDecisionSceneMode: " + this.mApsDecisionSceneMode + ", mApsDecisionFeatureType: " + this.mApsDecisionFeatureType + ", mApsAlgoFlag: " + Arrays.toString(this.mApsAlgoFlag) + ", mCaptureEVList: " + Arrays.toString(this.mCaptureEVList) + ", mCaptureETList: " + Arrays.toString(this.mCaptureETList) + ", mSensorMask: " + Arrays.toString(this.mSensorMask) + ", mMasterPipeline: " + this.mMasterPipeline + ", mMFSRFrameCount: " + this.mMFSRFrameCount + ", mApsBracketMode: " + this.mApsBracketMode + ", mSupportCaptureZoomFeature: " + this.mSupportCaptureZoomFeature + ", mCaptureNoNeedMatchMeta: " + this.mCaptureNoNeedMatchMeta + ", mAsdSceneValue: " + this.mAsdSceneValue + ", mbAIShutter: " + this.mbAIShutter;
        }
    }
}
