package com.aps;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.hardware.HardwareBuffer;
import android.hardware.camera2.CameraMetadata;
import android.media.Image;
import android.media.ImageReader;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.Surface;
import com.oppo.camera.aps.ApsAdapterLog;
import com.oppo.camera.aps.adapter.ApsAdapterDecision;
import com.oppo.camera.aps.adapter.ApsCaptureParam;
import com.oppo.camera.aps.adapter.ApsCaptureRequestParam;
import com.oppo.camera.aps.adapter.ApsExifData;
import com.oppo.camera.aps.adapter.ApsInitParameter;
import com.oppo.camera.aps.adapter.ApsParameters;
import com.oppo.camera.aps.adapter.ApsPreviewDecisionParam;
import com.oppo.camera.aps.adapter.ApsPreviewParam;
import com.oppo.camera.aps.adapter.ApsResult;
import com.oppo.camera.aps.adapter.ApsWatermarkParam;
import com.oppo.camera.aps.config.AlgoSwitchConfig;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.HashMap;

public class APSClient {
    private static final String BASE_VERSION = "V001.000.000";
    private static final int CAMERA_MSG_HEIF_CODEC = 3;
    private static final int CAMERA_MSG_HEIF_THUMB = 4;
    private static final int CAMERA_MSG_JPEG_DATA = 1;
    private static final int CAMERA_MSG_PREVIEW_DATA = 2;
    private static final int CAMERA_MSG_SERVER_DIED = 255;
    private static final String COMPATIABLE_VERSION = "V000.000.001";
    private static final String KEY_ALGONODE_ENABLE = "algonode_enable";
    private static final String KEY_ALGONODE_NAME = "algonode_name";
    private static final String KEY_APS_INIT_MODE = "aps_init_mode";
    private static final String KEY_APS_MODULE = "aps_module";
    private static final String KEY_BITMAP_OBJ = "bitmapobj";
    private static final String KEY_CAMERA_ID = "camera_id";
    private static final String KEY_CAPTURE_ALGO_LIST = "capture_algo_list";
    private static final String KEY_CONSUMER_PTR = "consumer_ptr";
    private static final String KEY_DECISION_AISHUTTER_ENABLE = "previewdecision_aishutter_enable";
    private static final String KEY_DECISION_ALGO_LIST = "previewdecision_algolist";
    private static final String KEY_DECISION_ASD_MSG_SCENE_VALUE = "previewdecision_asd_msg_scene_value";
    private static final String KEY_DECISION_BRACKET_MODE = "previewdecision_bracket_mode";
    private static final String KEY_DECISION_CAMERAID = "previewdecision_cameraid";
    private static final String KEY_DECISION_CAPTURE_MODE = "previewdecision_capture_mode";
    private static final String KEY_DECISION_CAPTURE_NO_NEED_MATCH_META = "previewdecision_capture_noneed_match_meta";
    private static final String KEY_DECISION_ET_LIST = "previewdecision_evlist";
    private static final String KEY_DECISION_EV_LIST = "previewdecision_evlist";
    private static final String KEY_DECISION_FEATURE_TYPE = "previewdecision_feature_type";
    private static final String KEY_DECISION_MASTER_PIPELINE = "previewdecision_master_pipeline";
    private static final String KEY_DECISION_META_INDEX = "previewdecision_meta_index";
    private static final String KEY_DECISION_MFSR_FRAME_CNT = "previewdecision_mfsr_frame_count";
    private static final String KEY_DECISION_MULTI_FRAME_CNT = "previewdecision_multiframecnt";
    private static final String KEY_DECISION_NIGHT_TOTAL_EXP = "previewdecision_night_total_exptime";
    private static final String KEY_DECISION_REQUEST_FORMAT = "previewdecision_request_format";
    private static final String KEY_DECISION_SCENE_MODE = "previewdecision_scene_mode";
    private static final String KEY_DECISION_SENSORMASK = "previewdecision_sensormask";
    private static final String KEY_DECISION_SUPERNIGHT_SCENE = "previewdecision_supernight_scene";
    private static final String KEY_DECISION_THUMBNAIL_INDEX = "previewdecision_thumbnail_index";
    private static final String KEY_DECISION_ZOOM_FEATURE = "previewdecision_zoom_feature";
    private static final String KEY_FACE_BEAUTY_ENABLE = "face_beauty_enable";
    private static final String KEY_FILTER_ENABLE = "filter_enable";
    private static final String KEY_FLOWINGWATER_ENABLE = "flowing_water_enable";
    private static final String KEY_HARDWAREBUFFER_OBJ = "hardwarebufferobj";
    private static final String KEY_HAS_IMAGEREADER = "has_imagereader";
    private static final String KEY_IMAGE_BUFFER_OBJ = "imagebufferobj";
    private static final String KEY_IMAGE_OBJ = "imageobj";
    private static final String KEY_INPUT_HEIGHT = "buffer_input_height";
    private static final String KEY_INPUT_SCANLINE = "buffer_input_scanline";
    private static final String KEY_INPUT_STRIDE = "buffer_input_stride";
    private static final String KEY_INPUT_WIDTH = "buffer_input_width";
    private static final String KEY_IS_REPROCESS_FRAME = "is_reprocess_frame";
    private static final String KEY_LOGICAMETA_OBJ = "logicmetaobj";
    private static final String KEY_META_OBJ = "metarefobj";
    private static final String KEY_MULTI_CAMERA_MODE = "multicamera_camera_mode";
    private static final String KEY_NEON_ENABLE = "neon_enable";
    private static final String KEY_PHYSICALMETA_OBJ = "phymetaobj";
    private static final String KEY_PIPELINE_ENABLE = "pipeline_enable";
    private static final String KEY_PIPELINE_NAME = "pipeline_name";
    private static final String KEY_PI_ENABLE = "pi_enable";
    private static final String KEY_PREVIEWCFG_CAMERA_ID = "previewcfg_camera_id";
    private static final String KEY_PREVIEWCFG_CAMERA_MODE = "previewcfg_camera_mode";
    private static final String KEY_PREVIEWCFG_CAMERA_NUM = "previewcfg_camera_num";
    private static final String KEY_PREVIEWCFG_COMP_ALGOLIST = "previewcfg_component_algolist";
    private static final String KEY_PREVIEWCFG_COMP_ALGONODE_COPYFROM = "previewcfg_component_algonode_copyfrom";
    private static final String KEY_PREVIEWCFG_COMP_ENABLE = "previewcfg_component_enable";
    private static final String KEY_PREVIEWCFG_COMP_MASTETHEIGHT = "previewcfg_component_masterheight";
    private static final String KEY_PREVIEWCFG_COMP_MASTETWIDTH = "previewcfg_component_masterwidth";
    private static final String KEY_PREVIEWCFG_COMP_NAME = "previewcfg_component_componentname";
    private static final String KEY_PREVIEWCFG_COMP_OUTPUTHEIGHT = "previewcfg_component_outputheight";
    private static final String KEY_PREVIEWCFG_COMP_OUTPUTWIDTH = "previewcfg_component_outputwidth";
    private static final String KEY_PREVIEWCFG_COMP_PIPELINE_COPYFROM = "previewcfg_component_pipeline_copyfrom";
    private static final String KEY_PREVIEWCFG_COMP_SKIP_CNT = "previewcfg_component_skip_cnt";
    private static final String KEY_PREVIEWCFG_COMP_SLAVEHEIGHT = "previewcfg_component_slaveheight";
    private static final String KEY_PREVIEWCFG_COMP_SLAVEWIDTH = "previewcfg_component_slavewidth";
    private static final String KEY_PREVIEWCFG_COMP_THIRDHEIGHT = "previewcfg_component_thirdheight";
    private static final String KEY_PREVIEWCFG_COMP_THIRDWIDTH = "previewcfg_component_thirdwidth";
    private static final String KEY_PREVIEWCFG_IS_SEPARATE_VIDEO = "previewcfg_mIsSeparateStreamForPrevAndVideo";
    private static final String KEY_PREVIEWCFG_NUM_COMPONENT = "previewcfg_num_component";
    private static final String KEY_PROCESS_TYPE = "process_type";
    private static final String KEY_RECORDING_CAPTURE = "recording_capture";
    private static final String KEY_RESULT_APP_ALGOFLAG = "resultinfo_app_algoflag";
    private static final String KEY_RESULT_APS_INIT_FINISH = "resultinfo_algoInterface_init_done";
    private static final String KEY_RESULT_BUFFER_TYPE = "resultinfo_buffer_type";
    private static final String KEY_RESULT_CROP_BOTTOM = "resultinfo_crop_bottom";
    private static final String KEY_RESULT_CROP_LEFT = "resultinfo_crop_left";
    private static final String KEY_RESULT_CROP_RIGHT = "resultinfo_crop_right";
    private static final String KEY_RESULT_CROP_TOP = "resultinfo_crop_top";
    private static final String KEY_RESULT_HAS_STRESULT = "resultinfo_has_st_result";
    private static final String KEY_RESULT_HEIF_PROCESS_APS = "resultinfo_heif_encode_in_aps";
    private static final String KEY_RESULT_HEIGHT = "resultinfo_height";
    private static final String KEY_RESULT_IDENTITY = "resultinfo_identity";
    private static final String KEY_RESULT_IS_LASTVIDEOFRAME = "resultinfo_is_last_videoframe";
    private static final String KEY_RESULT_IS_MOTION_DETECTED = "resultinfo_is_motion_detected";
    private static final String KEY_RESULT_IS_NEED_DETACH = "resultinfo_is_need_detach";
    private static final String KEY_RESULT_IS_START_INTERPOLATION_FRAME = "resultinfo_is_start_interoplation";
    private static final String KEY_RESULT_MESSAGE_TYPE = "resultinfo_message_type";
    private static final String KEY_RESULT_NOISE_REDUCTION_STRENGTH = "resultinfo_noise_reduction_strength";
    private static final String KEY_RESULT_PIPELINE_NAME = "resultinfo_pipeline_name";
    private static final String KEY_RESULT_REF_TIMESTAMP = "resultinfo_ref_timestamp";
    private static final String KEY_RESULT_ROTATION = "resultinfo_rotation";
    private static final String KEY_RESULT_SCANLINE = "resultinfo_scanline";
    private static final String KEY_RESULT_STRIDE = "resultinfo_stride";
    private static final String KEY_RESULT_ST_HEIGHT = "resultinfo_st_height";
    private static final String KEY_RESULT_ST_WIDTH = "resultinfo_st_width";
    private static final String KEY_RESULT_WIDTH = "resultinfo_width";
    private static final String KEY_RUNTIME_CNT_PENDING = "runtimeinfo_mProcessCntPending";
    private static final String KEY_RUNTIME_MEMSIZE = "runtimeinfo_mInputMemSize";
    private static final String KEY_RUNTIME_SINGLEALGO_MAXMEM = "runtimeinfo_mSingleAlgoMaxRunMem";
    private static final String KEY_RUNTIME_TOTAL_TIME = "runtimeinfo_mTotalTimeEstimate";
    private static final String KEY_SCP_ENABLE = "scp_enable";
    private static final String KEY_STATICMETA_OBJ = "staticmetaobj";
    private static final String KEY_STREAMER_ENABLE = "streamer_enable";
    private static final String KEY_SUPER_RAW_ENABLE = "superraw_enable";
    private static final String KEY_SURFACE_OBJ = "surfaceobj";
    private static final String KEY_TRIPOD_ENABLE = "tripod_enable";
    private static final String KEY_ULTRA_HIGHRES_ENABLE = "ultra_highres_enable";
    private static final String KEY_WATERMARK_HEIGHT = "watermark_height";
    private static final String KEY_WATERMARK_OBJ = "waterwarkobj";
    private static final String KEY_WATERMARK_REF_WIDTH = "watermark_refwidth";
    private static final String KEY_WATERMARK_WIDTH = "watermark_width";
    private static final String KEY_ZOOM_RATIO = "zoom_ratio";
    private static final int PROCESS_TYPE_ADD_FRAME_BUFF = 4;
    private static final int PROCESS_TYPE_BEFORE_CAPTURE = 11;
    private static final int PROCESS_TYPE_CLEAR = 6;
    private static final int PROCESS_TYPE_GET_RUNTIME_INFO = 1;
    private static final int PROCESS_TYPE_INIT = 2;
    private static final int PROCESS_TYPE_NONE = 0;
    private static final int PROCESS_TYPE_PROCESS_BITMAP = 12;
    private static final int PROCESS_TYPE_PROCESS_IMAGES = 5;
    private static final int PROCESS_TYPE_RELEASE_BUFFER = 7;
    private static final int PROCESS_TYPE_SET_ALGONODE_ENABLE = 10;
    private static final int PROCESS_TYPE_SET_PIPELINE_ENABLE = 9;
    private static final int PROCESS_TYPE_STOP = 8;
    private static final int PROCESS_TYPE_UNINIT = 3;
    private static final String TAG = "APSClient";
    private static final String VALUE_RESERVE = "reserve";
    /* access modifiers changed from: private */
    public static BufferCallback sBufferCallback = null;
    private static HeifCodecCallback sHeifCodecCallback = null;
    private static long sLogInterval = 0;
    private static boolean sbNewJniVersion = false;
    private EventHandler mEventHandler = null;

    public static class APSRuntimeInfo {
        public int mInputMemSize = 0;
        public int mProcessCntPending = 0;
        public int mSingleAlgoMaxRunMem = 0;
        public int mTotalTimeEstimate = 0;
    }

    public interface BufferCallback {
        void onCaptureCallback(ApsResult apsResult);

        void onPreviewCallback(ApsResult apsResult);

        void onServiceDied();
    }

    public interface HeifCodecCallback {
        void initHeifCodec(long j);

        void processHeifCodec(long j, HardwareBuffer hardwareBuffer, ApsExifData apsExifData, int i, int i2);

        void setHeicProcessInApp(boolean z);

        void uninitHeifCodec(long j);
    }

    private native int addFrameBuff(String[] strArr, Object[] objArr, String[] strArr2);

    public static native void attachPreviewSurface(int i, Surface surface, int i2);

    private native int create(Object obj);

    public static native void detachPreviewSurface(int i);

    public static native int exchangeBuffer(Surface surface, Surface surface2, int i, int i2, long j);

    public static native String getAPSVersion();

    public static native int setBufferQAllocEnable(Surface surface, boolean z);

    public native int addFrameBuff(ApsCaptureParam apsCaptureParam, Object obj);

    public native int addPreviewFrameBuff(ApsPreviewParam apsPreviewParam, ApsWatermarkParam apsWatermarkParam);

    public native int algoInit(ApsInitParameter apsInitParameter, Object obj);

    public native int algoInit(String[] strArr, Object[] objArr, String[] strArr2, String[] strArr3);

    public native int clear(Object obj);

    public native int destroy();

    public native String[] getParameters(String[] strArr, Object[] objArr, String[] strArr2);

    public native APSRuntimeInfo getRuntimeInfo(Object obj);

    public native ApsAdapterDecision.DecisionResult previewDecision(ApsPreviewDecisionParam apsPreviewDecisionParam, Object obj);

    public native String[] previewDecision(ApsPreviewDecisionParam apsPreviewDecisionParam, String[] strArr, CameraMetadata cameraMetadata);

    public native int processImages(String[] strArr, Object[] objArr, String[] strArr2, byte[] bArr);

    public native int processImages(String[] strArr, String[] strArr2, ApsWatermarkParam apsWatermarkParam, Object obj);

    public native int releaseBuffer(String str, HardwareBuffer hardwareBuffer, Object obj);

    public native Rect[] roiTranslate(Rect[] rectArr);

    public native int setEnableAPSAlgoNode(String str, boolean z, Object obj);

    public native int setEnableAPSPipeline(String str, boolean z, Object obj);

    public native int setParameters(String[] strArr, Object[] objArr, String[] strArr2);

    public native void setRequestMetadata(ApsCaptureRequestParam apsCaptureRequestParam);

    public native int stop(int i, Object obj);

    public native int unint(int i, String[] strArr, String[] strArr2, Object obj);

    public native int unint(String[] strArr, Object[] objArr, String[] strArr2);

    public APSClient(boolean z) {
        sBufferCallback = null;
        sHeifCodecCallback = null;
        if (z) {
            System.loadLibrary("APSClient-jni.qti");
        } else {
            System.loadLibrary("APSClient-jni.trustonic");
        }
        if (Looper.myLooper() != null) {
            this.mEventHandler = new EventHandler(Looper.myLooper());
        } else if (Looper.getMainLooper() != null) {
            this.mEventHandler = new EventHandler(Looper.getMainLooper());
        } else {
            this.mEventHandler = null;
        }
    }

    public void setDataCallback(BufferCallback bufferCallback) {
        sBufferCallback = bufferCallback;
    }

    public void setHeifCodecCallback(HeifCodecCallback heifCodecCallback) {
        sHeifCodecCallback = heifCodecCallback;
    }

    public int connect() {
        String str;
        int create = create(new WeakReference(this));
        try {
            str = getAPSVersion();
        } catch (Throwable th) {
            th.printStackTrace();
            ApsAdapterLog.e(TAG, "connect, error: getAPSVersion is not implemented");
            str = COMPATIABLE_VERSION;
        }
        sbNewJniVersion = str.compareToIgnoreCase(BASE_VERSION) >= 0;
        ApsAdapterLog.i(TAG, "connect, APS JNI version: " + str + ", sbNewJniVersion: " + sbNewJniVersion);
        return create;
    }

    private static void postEventFromNative(Object obj, Object obj2) {
        APSClient aPSClient = (APSClient) ((WeakReference) obj).get();
        ApsResult apsResult = obj2 != null ? (ApsResult) obj2 : null;
        if (aPSClient == null || apsResult == null) {
            ApsAdapterLog.i(TAG, "postEventFromNative, apsclient or apsResults is null, return");
            return;
        }
        if (sbNewJniVersion) {
            ApsAdapterLog.v(TAG, "postEventFromNative, resultString: " + Arrays.toString(apsResult.mResultString));
            String[] strArr = apsResult.mResultString;
            if (apsResult.mResultString != null) {
                HashMap hashMap = new HashMap(strArr.length / 2);
                for (int i = 0; i < strArr.length - 1; i += 2) {
                    hashMap.put(strArr[i], strArr[i + 1]);
                }
                apsResult.mRotation = Integer.parseInt((String) hashMap.get(KEY_RESULT_ROTATION));
                apsResult.mIdentity = Long.parseLong((String) hashMap.get(KEY_RESULT_IDENTITY));
                apsResult.mAppAlgoFlag = Long.parseLong((String) hashMap.get(KEY_RESULT_APP_ALGOFLAG));
                apsResult.mWidth = Integer.parseInt((String) hashMap.get(KEY_RESULT_WIDTH));
                apsResult.mHeight = Integer.parseInt((String) hashMap.get(KEY_RESULT_HEIGHT));
                apsResult.mStride = Integer.parseInt((String) hashMap.get(KEY_RESULT_STRIDE));
                apsResult.mScanline = Integer.parseInt((String) hashMap.get(KEY_RESULT_SCANLINE));
                apsResult.mSTWidth = Integer.parseInt((String) hashMap.get(KEY_RESULT_ST_WIDTH));
                apsResult.mSTHeight = Integer.parseInt((String) hashMap.get(KEY_RESULT_ST_HEIGHT));
                apsResult.mbHasSTResult = Boolean.parseBoolean((String) hashMap.get(KEY_RESULT_HAS_STRESULT));
                apsResult.mBufferType = Integer.parseInt((String) hashMap.get(KEY_RESULT_BUFFER_TYPE));
                apsResult.mCropLeft = Integer.parseInt((String) hashMap.get(KEY_RESULT_CROP_LEFT));
                apsResult.mCropTop = Integer.parseInt((String) hashMap.get(KEY_RESULT_CROP_TOP));
                apsResult.mCropRight = Integer.parseInt((String) hashMap.get(KEY_RESULT_CROP_RIGHT));
                apsResult.mCropBottom = Integer.parseInt((String) hashMap.get(KEY_RESULT_CROP_BOTTOM));
                apsResult.mMessageType = Integer.parseInt((String) hashMap.get(KEY_RESULT_MESSAGE_TYPE));
                apsResult.mPipelineName = (String) hashMap.get(KEY_RESULT_PIPELINE_NAME);
                apsResult.mIsLastVideoFrame = Integer.parseInt((String) hashMap.get(KEY_RESULT_IS_LASTVIDEOFRAME));
                apsResult.mIsStartInterpolationFrame = Integer.parseInt((String) hashMap.get(KEY_RESULT_IS_START_INTERPOLATION_FRAME));
                apsResult.mIsMotionDetected = Integer.parseInt((String) hashMap.get(KEY_RESULT_IS_MOTION_DETECTED));
                apsResult.mbNeedDetach = Boolean.parseBoolean((String) hashMap.get(KEY_RESULT_IS_NEED_DETACH));
                apsResult.mbHeifProcessInAps = Boolean.parseBoolean((String) hashMap.get(KEY_RESULT_HEIF_PROCESS_APS));
                apsResult.mApsInitFinish = (String) hashMap.get(KEY_RESULT_APS_INIT_FINISH);
                if (hashMap.containsKey(KEY_RESULT_NOISE_REDUCTION_STRENGTH)) {
                    apsResult.mNoiseReductionStrength = Integer.parseInt((String) hashMap.get(KEY_RESULT_NOISE_REDUCTION_STRENGTH));
                }
                if (hashMap.containsKey(KEY_RESULT_REF_TIMESTAMP)) {
                    apsResult.mRefTimestamp = Long.parseLong((String) hashMap.get(KEY_RESULT_REF_TIMESTAMP));
                }
                ApsAdapterLog.v(TAG, "postEventFromNative, callback result: " + apsResult);
            }
        }
        if (2 == apsResult.mMessageType) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - sLogInterval > 3000) {
                sLogInterval = currentTimeMillis;
                dumpApsCallbackInfos(apsResult);
            }
        } else {
            dumpApsCallbackInfos(apsResult);
        }
        if (2 == apsResult.mMessageType) {
            sBufferCallback.onPreviewCallback(apsResult);
        } else if (aPSClient.mEventHandler != null) {
            aPSClient.mEventHandler.sendMessage(aPSClient.mEventHandler.obtainMessage(apsResult.mMessageType, apsResult));
        }
    }

    private static void dumpApsCallbackInfos(ApsResult apsResult) {
        ApsAdapterLog.d(TAG, "dumpApsCallbackInfos, result: " + apsResult.toString());
    }

    private class EventHandler extends Handler {
        public EventHandler(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            ApsAdapterLog.d(APSClient.TAG, "handleMessage, type: " + message.what + ", sBufferCallback: " + APSClient.sBufferCallback);
            if (APSClient.sBufferCallback == null) {
                ApsAdapterLog.e(APSClient.TAG, "handleMessage, mBufferCallback is null");
            } else if (message.obj == null) {
                ApsAdapterLog.e(APSClient.TAG, "handleMessage, msg object is null, return");
            } else {
                ApsResult apsResult = (ApsResult) message.obj;
                int i = message.what;
                if (i != 1) {
                    if (i == 255) {
                        APSClient.sBufferCallback.onServiceDied();
                        return;
                    } else if (!(i == 3 || i == 4)) {
                        ApsAdapterLog.e(APSClient.TAG, "handleMessage, the message type is error, please check, return");
                        return;
                    }
                }
                APSClient.sBufferCallback.onCaptureCallback(apsResult);
            }
        }
    }

    public void hypnusSetAction(int i, int i2) {
        ApsAdapterLog.i(TAG, "hypnusSetAction, action: " + i + ", timeout: " + i2);
    }

    public void initHeifCodec(long j) {
        ApsAdapterLog.e(TAG, "initHeifCodec, identity: " + j);
        sHeifCodecCallback.initHeifCodec(j);
    }

    public void processHeifCodec(long j, HardwareBuffer hardwareBuffer, ApsExifData apsExifData, int i, int i2) {
        ApsAdapterLog.e(TAG, "processHeifCodec");
        sHeifCodecCallback.processHeifCodec(j, hardwareBuffer, apsExifData, i, i2);
    }

    public void uninitHeifCodec(long j) {
        ApsAdapterLog.e(TAG, "uninitHeifCodec");
        sHeifCodecCallback.uninitHeifCodec(j);
    }

    public void setHeicProcessInApp(boolean z) {
        sHeifCodecCallback.setHeicProcessInApp(z);
    }

    public static class ApsObjectsInfo {
        private String[] mObjInfo = null;
        private Object[] mObjects = null;

        public void addObjInfo(String str, Object obj) {
            Object[] objArr = this.mObjects;
            if (objArr != null) {
                this.mObjects = Arrays.copyOf(objArr, objArr.length + 1);
            } else {
                this.mObjects = new Object[1];
            }
            Object[] objArr2 = this.mObjects;
            objArr2[objArr2.length - 1] = obj;
            String[] strArr = this.mObjInfo;
            if (strArr != null) {
                this.mObjInfo = (String[]) Arrays.copyOf(strArr, strArr.length + 1);
            } else {
                this.mObjInfo = new String[1];
            }
            String[] strArr2 = this.mObjInfo;
            strArr2[strArr2.length - 1] = str;
        }

        public Object[] getObjects() {
            return this.mObjects;
        }

        public String[] getObjInfo() {
            return this.mObjInfo;
        }
    }

    private int[] StringToInt(String[] strArr) {
        int[] iArr = new int[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            iArr[i] = Integer.parseInt(strArr[i]);
        }
        return iArr;
    }

    private long[] StringToLong(String[] strArr) {
        long[] jArr = new long[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            jArr[i] = Long.parseLong(strArr[i]);
        }
        return jArr;
    }

    public static String[] mergeArrays(String[] strArr, String[] strArr2) {
        String[] strArr3 = new String[(strArr.length + strArr2.length)];
        System.arraycopy(strArr, 0, strArr3, 0, strArr.length);
        System.arraycopy(strArr2, 0, strArr3, strArr.length, strArr2.length);
        return strArr3;
    }

    public int algoInit(ApsInitParameter apsInitParameter) {
        if (!sbNewJniVersion) {
            return algoInit(apsInitParameter, (Object) null);
        }
        ApsParameters apsParameters = new ApsParameters();
        String[] strArr = apsInitParameter.mParameters;
        apsParameters.set(KEY_APS_MODULE, String.valueOf(apsInitParameter.mApsModule));
        setHeicProcessInApp(apsInitParameter.mbHeicProcessInApp);
        if (apsInitParameter.mInitAlgo != null) {
            apsParameters.set(KEY_CAPTURE_ALGO_LIST, Arrays.toString(apsInitParameter.mInitAlgo).replace('[', ' ').replace(']', ' '));
        }
        ApsObjectsInfo apsObjectsInfo = new ApsObjectsInfo();
        apsObjectsInfo.addObjInfo(KEY_STATICMETA_OBJ, apsInitParameter.mMetadata);
        if (apsInitParameter.mVideoSurface != null) {
            apsObjectsInfo.addObjInfo(KEY_SURFACE_OBJ, apsInitParameter.mVideoSurface);
        }
        AlgoSwitchConfig.PreviewConfig previewConfig = apsInitParameter.mPreviewConfig;
        if (previewConfig != null) {
            apsParameters.set(KEY_PREVIEWCFG_CAMERA_MODE, previewConfig.mCameraMode);
            apsParameters.set(KEY_PREVIEWCFG_CAMERA_ID, Integer.toString(previewConfig.mCameraId));
            apsParameters.set(KEY_PREVIEWCFG_CAMERA_NUM, Integer.toString(previewConfig.mCameraNum));
            apsParameters.set(KEY_PREVIEWCFG_IS_SEPARATE_VIDEO, Integer.toString(previewConfig.mIsSeparateStreamForPrevAndVideo));
            apsParameters.set(KEY_PREVIEWCFG_NUM_COMPONENT, Integer.toString(previewConfig.mComponentMap.size()));
            for (int i = 0; i < previewConfig.mComponentMap.size(); i++) {
                AlgoSwitchConfig.PreviewConfig.Component valueAt = previewConfig.mComponentMap.valueAt(i);
                apsParameters.set(KEY_PREVIEWCFG_COMP_NAME + i, previewConfig.mComponentMap.keyAt(i));
                apsParameters.set(KEY_PREVIEWCFG_COMP_ENABLE + i, Boolean.toString(valueAt.mbEnable));
                apsParameters.set(KEY_PREVIEWCFG_COMP_MASTETWIDTH + i, Integer.toString(valueAt.mMasterInputWidth));
                apsParameters.set(KEY_PREVIEWCFG_COMP_MASTETHEIGHT + i, Integer.toString(valueAt.mMasterInputHeight));
                apsParameters.set(KEY_PREVIEWCFG_COMP_SLAVEWIDTH + i, Integer.toString(valueAt.mSlaveInputWidth));
                apsParameters.set(KEY_PREVIEWCFG_COMP_SLAVEHEIGHT + i, Integer.toString(valueAt.mSlaveInputHeight));
                apsParameters.set(KEY_PREVIEWCFG_COMP_THIRDWIDTH + i, Integer.toString(valueAt.mThirdInputWidth));
                apsParameters.set(KEY_PREVIEWCFG_COMP_THIRDHEIGHT + i, Integer.toString(valueAt.mThirdInputHeight));
                apsParameters.set(KEY_PREVIEWCFG_COMP_OUTPUTWIDTH + i, Integer.toString(valueAt.mOutputWidth));
                apsParameters.set(KEY_PREVIEWCFG_COMP_OUTPUTHEIGHT + i, Integer.toString(valueAt.mOutputHeight));
                apsParameters.set(KEY_PREVIEWCFG_COMP_SKIP_CNT + i, Integer.toString(valueAt.mFrameSkipCnt));
                apsParameters.set(KEY_PREVIEWCFG_COMP_PIPELINE_COPYFROM + i, valueAt.mPipelineCopyFrom);
                apsParameters.set(KEY_PREVIEWCFG_COMP_ALGONODE_COPYFROM + i, valueAt.mAlgoNodeCopyFrom);
                apsParameters.set(KEY_PREVIEWCFG_COMP_ALGOLIST + i, Arrays.toString(valueAt.mAlgoList).replace('[', ' ').replace(']', ' '));
            }
        }
        return algoInit(apsObjectsInfo.getObjInfo(), apsObjectsInfo.getObjects(), mergeArrays(strArr, apsParameters.getParameters()), apsInitParameter.mVendorTags);
    }

    public int beforeCapture(ApsParameters apsParameters) {
        apsParameters.set(KEY_PROCESS_TYPE, Integer.toString(11));
        return setParameters((String[]) null, (Object[]) null, apsParameters.getParameters());
    }

    public int addFrameBuff(ApsCaptureParam apsCaptureParam) {
        if (!sbNewJniVersion) {
            return addFrameBuff(apsCaptureParam, (Object) null);
        }
        ApsParameters apsParameters = new ApsParameters();
        ApsObjectsInfo apsObjectsInfo = new ApsObjectsInfo();
        apsObjectsInfo.addObjInfo(KEY_IMAGE_BUFFER_OBJ, apsCaptureParam.getImageBuffer());
        apsParameters.set(ApsParameters.KEY_FRAME_NUMBER.getName(), String.valueOf(apsCaptureParam.getFrameNumber()));
        apsParameters.set(ApsParameters.KEY_PROCESS_IMAGE_IDENTITY, String.valueOf(apsCaptureParam.getImageBuffer().getTimestamp()));
        apsParameters.set(KEY_IS_REPROCESS_FRAME, String.valueOf(apsCaptureParam.getIsReprocessFrame()));
        apsParameters.set(ApsParameters.KEY_IMAGE_ROLE.getName(), String.valueOf(apsCaptureParam.getRole()));
        apsParameters.set(ApsParameters.KEY_MAX_HOLD_IMAGES.getName(), String.valueOf(apsCaptureParam.getMaxHoldImages()));
        apsParameters.set(ApsParameters.KEY_PREFER_ADD_FRAME_TYPE.getName(), String.valueOf(apsCaptureParam.getPreferType()));
        apsParameters.set(ApsParameters.KEY_VIDEO_SNAPSHOT.getName(), String.valueOf(apsCaptureParam.getIsVideoSnapshot()));
        int[] inputSize = apsCaptureParam.getInputSize();
        if (inputSize == null || inputSize.length <= 0) {
            ApsAdapterLog.v(TAG, "addFrameBuff, input array is null");
        } else {
            apsParameters.set(KEY_INPUT_WIDTH, String.valueOf(inputSize[0]));
            apsParameters.set(KEY_INPUT_HEIGHT, String.valueOf(inputSize[1]));
            apsParameters.set(KEY_INPUT_STRIDE, String.valueOf(inputSize[2]));
            apsParameters.set(KEY_INPUT_SCANLINE, String.valueOf(inputSize[3]));
        }
        CameraMetadata logicMeta = apsCaptureParam.getLogicMeta();
        CameraMetadata physicMeta = apsCaptureParam.getPhysicMeta();
        HardwareBuffer hardwareBuffer = apsCaptureParam.getImageBuffer().getHardwareBuffer();
        ImageReader imageReader = apsCaptureParam.getImageBuffer().getImageReader();
        Image image = apsCaptureParam.getImageBuffer().getImage();
        if (imageReader != null) {
            apsParameters.set(KEY_HAS_IMAGEREADER, String.valueOf(true));
        }
        if (image != null) {
            apsObjectsInfo.addObjInfo(KEY_IMAGE_OBJ, image);
        }
        if (hardwareBuffer != null) {
            apsObjectsInfo.addObjInfo(KEY_HARDWAREBUFFER_OBJ, hardwareBuffer);
        }
        if (!(logicMeta == null || 4 == apsCaptureParam.getRole())) {
            apsObjectsInfo.addObjInfo(KEY_LOGICAMETA_OBJ, logicMeta);
        }
        if (!(physicMeta == null || 4 == apsCaptureParam.getRole())) {
            apsObjectsInfo.addObjInfo(KEY_PHYSICALMETA_OBJ, physicMeta);
        }
        String[] objInfo = apsObjectsInfo.getObjInfo();
        Object[] objects = apsObjectsInfo.getObjects();
        String[] parameters = apsParameters.getParameters();
        ApsAdapterLog.v(TAG, "addFrameBuff, objInfo: " + Arrays.toString(objInfo) + ", rocessParameters: " + Arrays.toString(parameters));
        return addFrameBuff(objInfo, objects, parameters);
    }

    public int processImages(String[] strArr, String[] strArr2, ApsWatermarkParam apsWatermarkParam) {
        byte[] bArr = null;
        if (!sbNewJniVersion) {
            return processImages(strArr, strArr2, apsWatermarkParam, (Object) null);
        }
        ApsParameters apsParameters = new ApsParameters();
        if (apsWatermarkParam != null) {
            apsParameters.set(KEY_WATERMARK_REF_WIDTH, String.valueOf(apsWatermarkParam.getRefWidth()));
            apsParameters.set(KEY_WATERMARK_WIDTH, String.valueOf(apsWatermarkParam.getWatermarkWidth()));
            apsParameters.set(KEY_WATERMARK_HEIGHT, String.valueOf(apsWatermarkParam.getWatermarkHeight()));
            bArr = apsWatermarkParam.getWatermarkBuffer();
            ApsAdapterLog.v(TAG, "processImages, watermark: " + apsWatermarkParam.toString());
        }
        if (strArr2 != null) {
            apsParameters.set(KEY_CAPTURE_ALGO_LIST, Arrays.toString(strArr2).replace('[', ' ').replace(']', ' '));
        }
        ApsObjectsInfo apsObjectsInfo = new ApsObjectsInfo();
        if (bArr != null) {
            apsObjectsInfo.addObjInfo(KEY_WATERMARK_OBJ, bArr);
        }
        String[] objInfo = apsObjectsInfo.getObjInfo();
        Object[] objects = apsObjectsInfo.getObjects();
        String[] mergeArrays = mergeArrays(apsParameters.getParameters(), strArr);
        ApsAdapterLog.v(TAG, "processImages, objInfo: " + Arrays.toString(objInfo) + ", processParameters: " + Arrays.toString(mergeArrays));
        return processImages(objInfo, objects, mergeArrays, bArr);
    }

    public Bitmap processBitmap(Bitmap bitmap, CameraMetadata cameraMetadata, ApsParameters apsParameters) {
        apsParameters.set(KEY_PROCESS_TYPE, Integer.toString(12));
        setParameters(new String[]{KEY_BITMAP_OBJ, KEY_LOGICAMETA_OBJ}, new Object[]{bitmap, cameraMetadata}, apsParameters.getParameters());
        return bitmap;
    }

    public ApsAdapterDecision.DecisionResult previewDecision(ApsPreviewDecisionParam apsPreviewDecisionParam) {
        if (!sbNewJniVersion) {
            return previewDecision(apsPreviewDecisionParam, (Object) null);
        }
        ApsParameters apsParameters = new ApsParameters();
        apsParameters.set(KEY_MULTI_CAMERA_MODE, String.valueOf(apsPreviewDecisionParam.getMultiCameraMode()));
        apsParameters.set("camera_id", String.valueOf(apsPreviewDecisionParam.getCameraId()));
        apsParameters.set(ApsParameters.KEY_LOGIC_CAMERA_ID.getName(), String.valueOf(apsPreviewDecisionParam.getLogicalCameraId()));
        apsParameters.set(KEY_PI_ENABLE, String.valueOf(apsPreviewDecisionParam.getPiEnable()));
        apsParameters.set(KEY_TRIPOD_ENABLE, String.valueOf(apsPreviewDecisionParam.getTripodEnable()));
        apsParameters.set(KEY_ZOOM_RATIO, String.valueOf(apsPreviewDecisionParam.getZoomRatio()));
        apsParameters.set(KEY_ULTRA_HIGHRES_ENABLE, String.valueOf(apsPreviewDecisionParam.getUltraHighResolutionEnable()));
        apsParameters.set(KEY_SCP_ENABLE, String.valueOf(apsPreviewDecisionParam.getSCPEnable()));
        apsParameters.set(KEY_FILTER_ENABLE, String.valueOf(apsPreviewDecisionParam.getFilterEnable()));
        apsParameters.set(KEY_FACE_BEAUTY_ENABLE, String.valueOf(apsPreviewDecisionParam.getFaceBeautyEnable()));
        apsParameters.set(KEY_SUPER_RAW_ENABLE, String.valueOf(apsPreviewDecisionParam.getSuperRawEnable()));
        apsParameters.set(KEY_NEON_ENABLE, String.valueOf(apsPreviewDecisionParam.getNeonEnable()));
        apsParameters.set(KEY_STREAMER_ENABLE, String.valueOf(apsPreviewDecisionParam.getStreamerEnable()));
        apsParameters.set(ApsParameters.KEY_CAPTURE_MODE.getName(), apsPreviewDecisionParam.getCaptureMode());
        apsParameters.set(KEY_RECORDING_CAPTURE, String.valueOf(apsPreviewDecisionParam.getRecordingCaptureState()));
        String[] parameters = apsParameters.getParameters();
        ApsAdapterLog.v(TAG, "previewdecision, processParameters: " + Arrays.toString(parameters));
        String[] previewDecision = previewDecision(apsPreviewDecisionParam, parameters, apsPreviewDecisionParam.getMetadata());
        ApsAdapterLog.v(TAG, "previewdecision, result: " + Arrays.toString(previewDecision));
        if (previewDecision == null) {
            return null;
        }
        HashMap hashMap = new HashMap(previewDecision.length / 2);
        for (int i = 0; i < previewDecision.length - 1; i += 2) {
            hashMap.put(previewDecision[i], previewDecision[i + 1]);
        }
        ApsAdapterDecision.DecisionResult decisionResult = new ApsAdapterDecision.DecisionResult();
        decisionResult.mCameraId = Integer.parseInt((String) hashMap.get(KEY_DECISION_CAMERAID));
        decisionResult.mCaptureMode = (String) hashMap.get(KEY_DECISION_CAPTURE_MODE);
        decisionResult.mRequestFormat = Integer.parseInt((String) hashMap.get(KEY_DECISION_REQUEST_FORMAT));
        decisionResult.mMultiFrameCount = Integer.parseInt((String) hashMap.get(KEY_DECISION_MULTI_FRAME_CNT));
        decisionResult.mThumbnailIndex = Integer.parseInt((String) hashMap.get(KEY_DECISION_THUMBNAIL_INDEX));
        decisionResult.mMetaIndex = Integer.parseInt((String) hashMap.get(KEY_DECISION_META_INDEX));
        decisionResult.mSuperNightScene = Integer.parseInt((String) hashMap.get(KEY_DECISION_SUPERNIGHT_SCENE));
        decisionResult.mNightTotalExpTime = Integer.parseInt((String) hashMap.get(KEY_DECISION_NIGHT_TOTAL_EXP));
        decisionResult.mApsDecisionSceneMode = Integer.parseInt((String) hashMap.get(KEY_DECISION_SCENE_MODE));
        decisionResult.mApsDecisionFeatureType = Integer.parseInt((String) hashMap.get(KEY_DECISION_FEATURE_TYPE));
        decisionResult.mApsAlgoFlag = ((String) hashMap.get(KEY_DECISION_ALGO_LIST)).split(",");
        decisionResult.mCaptureEVList = StringToInt(((String) hashMap.get("previewdecision_evlist")).split(","));
        decisionResult.mCaptureETList = StringToLong(((String) hashMap.get("previewdecision_evlist")).split(","));
        decisionResult.mSensorMask = StringToInt(((String) hashMap.get(KEY_DECISION_SENSORMASK)).split(","));
        decisionResult.mMasterPipeline = Integer.parseInt((String) hashMap.get(KEY_DECISION_MASTER_PIPELINE));
        decisionResult.mApsBracketMode = Integer.parseInt((String) hashMap.get(KEY_DECISION_BRACKET_MODE));
        decisionResult.mMFSRFrameCount = Integer.parseInt((String) hashMap.get(KEY_DECISION_MFSR_FRAME_CNT));
        decisionResult.mSupportCaptureZoomFeature = Integer.parseInt((String) hashMap.get(KEY_DECISION_ZOOM_FEATURE));
        if (hashMap.get(KEY_DECISION_ASD_MSG_SCENE_VALUE) != null) {
            decisionResult.mAsdSceneValue = Integer.parseInt((String) hashMap.get(KEY_DECISION_ASD_MSG_SCENE_VALUE));
        }
        if (hashMap.get(KEY_DECISION_AISHUTTER_ENABLE) != null) {
            decisionResult.mbAIShutter = Boolean.parseBoolean((String) hashMap.get(KEY_DECISION_AISHUTTER_ENABLE));
        }
        if (hashMap.get(KEY_DECISION_CAPTURE_NO_NEED_MATCH_META) != null) {
            decisionResult.mCaptureNoNeedMatchMeta = Integer.parseInt((String) hashMap.get(KEY_DECISION_CAPTURE_NO_NEED_MATCH_META));
        }
        ApsAdapterLog.v(TAG, "previewdecision, cameraID: " + decisionResult.mCameraId + ", mMultiFrameCount: " + decisionResult.mMultiFrameCount + ", algoList: " + Arrays.toString(decisionResult.mApsAlgoFlag) + ", et list: " + Arrays.toString(decisionResult.mCaptureETList));
        return decisionResult;
    }

    public int unint(int i, String[] strArr, String[] strArr2) {
        if (!sbNewJniVersion) {
            return unint(i, strArr, strArr2, (Object) null);
        }
        ApsParameters apsParameters = new ApsParameters();
        apsParameters.set(KEY_PROCESS_TYPE, Integer.toString(3));
        if (strArr2 != null) {
            apsParameters.set(KEY_CAPTURE_ALGO_LIST, Arrays.toString(strArr2).replace('[', ' ').replace(']', ' '));
        }
        apsParameters.set(KEY_APS_MODULE, String.valueOf(i));
        String[] parameters = apsParameters.getParameters();
        if (strArr != null) {
            parameters = mergeArrays(parameters, strArr);
        }
        return unint((String[]) null, (Object[]) null, parameters);
    }

    public int stop(int i) {
        if (!sbNewJniVersion) {
            return stop(i, (Object) null);
        }
        ApsParameters apsParameters = new ApsParameters();
        apsParameters.set(KEY_PROCESS_TYPE, Integer.toString(8));
        return setParameters((String[]) null, (Object[]) null, apsParameters.getParameters());
    }

    public int clear() {
        if (!sbNewJniVersion) {
            return clear((Object) null);
        }
        ApsParameters apsParameters = new ApsParameters();
        apsParameters.set(KEY_PROCESS_TYPE, String.valueOf(6));
        return setParameters((String[]) null, (Object[]) null, apsParameters.getParameters());
    }

    public int releaseBuffer(String str, HardwareBuffer hardwareBuffer) {
        if (!sbNewJniVersion) {
            return releaseBuffer(str, hardwareBuffer, (Object) null);
        }
        ApsParameters apsParameters = new ApsParameters();
        apsParameters.set(KEY_PROCESS_TYPE, String.valueOf(7));
        apsParameters.set(KEY_PIPELINE_NAME, str);
        String[] parameters = apsParameters.getParameters();
        ApsObjectsInfo apsObjectsInfo = new ApsObjectsInfo();
        apsObjectsInfo.addObjInfo(KEY_HARDWAREBUFFER_OBJ, hardwareBuffer);
        return setParameters(apsObjectsInfo.getObjInfo(), apsObjectsInfo.getObjects(), parameters);
    }

    public APSRuntimeInfo getRuntimeInfo() {
        if (!sbNewJniVersion) {
            return getRuntimeInfo((Object) null);
        }
        ApsParameters apsParameters = new ApsParameters();
        apsParameters.set(KEY_PROCESS_TYPE, String.valueOf(1));
        String[] parameters = apsParameters.getParameters();
        ApsAdapterLog.v(TAG, "getRuntimeInfo, params: " + Arrays.toString(parameters));
        String[] parameters2 = getParameters((String[]) null, (Object[]) null, parameters);
        ApsAdapterLog.v(TAG, "getRuntimeInfo, result: " + Arrays.toString(parameters2));
        if (parameters2 == null) {
            return null;
        }
        HashMap hashMap = new HashMap(parameters2.length / 2);
        for (int i = 0; i < parameters2.length - 1; i += 2) {
            hashMap.put(parameters2[i], parameters2[i + 1]);
        }
        APSRuntimeInfo aPSRuntimeInfo = new APSRuntimeInfo();
        aPSRuntimeInfo.mInputMemSize = Integer.valueOf((String) hashMap.get(KEY_RUNTIME_MEMSIZE)).intValue();
        aPSRuntimeInfo.mSingleAlgoMaxRunMem = Integer.valueOf((String) hashMap.get(KEY_RUNTIME_SINGLEALGO_MAXMEM)).intValue();
        aPSRuntimeInfo.mTotalTimeEstimate = Integer.valueOf((String) hashMap.get(KEY_RUNTIME_TOTAL_TIME)).intValue();
        aPSRuntimeInfo.mProcessCntPending = Integer.valueOf((String) hashMap.get(KEY_RUNTIME_CNT_PENDING)).intValue();
        ApsAdapterLog.v(TAG, "getRuntimeInfo, result mInputMemSize: " + aPSRuntimeInfo.mInputMemSize + ", mSingleAlgoMaxRunMem: " + aPSRuntimeInfo.mSingleAlgoMaxRunMem + ", mTotalTimeEstimate: " + aPSRuntimeInfo.mTotalTimeEstimate + ", mProcessCntPending: " + aPSRuntimeInfo.mProcessCntPending);
        return aPSRuntimeInfo;
    }

    public int setEnableAPSPipeline(String str, boolean z) {
        if (!sbNewJniVersion) {
            return setEnableAPSPipeline(str, z, (Object) null);
        }
        ApsParameters apsParameters = new ApsParameters();
        apsParameters.set(KEY_PROCESS_TYPE, Integer.toString(9));
        apsParameters.set(KEY_PIPELINE_NAME, str);
        apsParameters.set(KEY_PIPELINE_ENABLE, Boolean.toString(z));
        String[] parameters = apsParameters.getParameters();
        ApsAdapterLog.v(TAG, "setEnableAPSPipeline, param: " + Arrays.toString(parameters));
        return setParameters((String[]) null, (Object[]) null, parameters);
    }

    public int setEnableAPSAlgoNode(String str, boolean z) {
        if (!sbNewJniVersion) {
            return setEnableAPSAlgoNode(str, z, (Object) null);
        }
        ApsParameters apsParameters = new ApsParameters();
        apsParameters.set(KEY_PROCESS_TYPE, Integer.toString(10));
        apsParameters.set(KEY_ALGONODE_NAME, str);
        apsParameters.set(KEY_ALGONODE_ENABLE, Boolean.toString(z));
        String[] parameters = apsParameters.getParameters();
        ApsAdapterLog.v(TAG, "setEnableAPSAlgoNode, param: " + Arrays.toString(parameters));
        return setParameters((String[]) null, (Object[]) null, parameters);
    }

    public void updateThumbnailMap(ApsResult apsResult) {
        this.mEventHandler.sendMessage(this.mEventHandler.obtainMessage(4, apsResult));
    }
}
