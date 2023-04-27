package com.oppo.camera.aps.config;

import android.content.Context;
import android.util.Size;
import androidx.collection.ArrayMap;
import com.android.providers.downloads.Downloads;
import com.oppo.camera.aps.ApsAdapterLog;
import com.oppo.camera.aps.BuildConfig;
import com.oppo.camera.aps.adapter.ApsUtils;
import com.oppo.camera.aps.update.UpdateHelper;
import java.io.FileInputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public class AlgoSwitchConfig {
    private static final String ALGO_SWITCH_CONFIG_NAME = "oplus_camera_algo_switch_config";
    public static final int APS_MODE_CAPTURE = 2;
    public static final int APS_MODE_FULL = 1;
    public static final int APS_MODE_NONE = 0;
    public static final int APS_MODE_PREVIEW = 3;
    public static final String APS_PIPELINE_ASD = "asd";
    public static final String APS_PIPELINE_PREVIEW = "preview";
    public static final String APS_PIPELINE_VIDEO = "video";
    public static final int APS_VERSION_2 = 2;
    public static final int APS_VERSION_3 = 3;
    private static final String TAG = "AlgoSwitchConfig";
    private static int sApsMode = 0;
    private static int sApsVersion = 2;
    private static final HashMap<String, CaptureConfig> sCaptureConfigMap = new HashMap<>();
    private static String sPackageName = "com.oppo.camera";
    private static final HashMap<String, PreviewConfig> sPreviewConfigMap = new HashMap<>();
    private static long sTotalMemory = -1;

    public static void initialize(Context context) {
        sPackageName = context.getPackageName();
        sTotalMemory = ApsUtils.getTotalMemory(context);
        parseConfigData(UpdateHelper.tryRusUpdatePath(context, ApsUtils.CONFIG_JSON_PATH + ALGO_SWITCH_CONFIG_NAME));
    }

    public static String getPackageName() {
        return sPackageName;
    }

    public static long getTotalMemory() {
        return sTotalMemory;
    }

    public static int getApsVersion() {
        return sApsVersion;
    }

    public static int getApsMode() {
        return sApsMode;
    }

    public static boolean getSupportApsCapture() {
        int i = sApsMode;
        return i == 1 || i == 2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r0 = sApsMode;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean getSupportApsPreview() {
        /*
            int r0 = sApsVersion
            r1 = 1
            r2 = 3
            if (r0 != r2) goto L_0x000d
            int r0 = sApsMode
            if (r0 == r1) goto L_0x000e
            if (r0 != r2) goto L_0x000d
            goto L_0x000e
        L_0x000d:
            r1 = 0
        L_0x000e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.aps.config.AlgoSwitchConfig.getSupportApsPreview():boolean");
    }

    public static boolean getSupportCaptureAlgo(String str, int i, String str2) {
        HashMap<String, CaptureConfig> hashMap = sCaptureConfigMap;
        CaptureConfig captureConfig = hashMap.get(str + "@" + i);
        return captureConfig != null && captureConfig.mbEnable && captureConfig.mAlgos.contains(str2);
    }

    public static boolean getSupportCameraFeature(String str, int i) {
        HashMap<String, PreviewConfig> hashMap = sPreviewConfigMap;
        return hashMap.containsKey(str + "@" + i);
    }

    public static boolean getSupportPreviewAlgo(String str, int i, String str2, String str3) {
        PreviewConfig previewConfig = sPreviewConfigMap.get(str + "@" + i);
        if (previewConfig.mComponentMap.containsKey(str2)) {
            PreviewConfig.Component component = previewConfig.mComponentMap.get(str2);
            if (component.mAlgoList != null) {
                for (String equals : component.mAlgoList) {
                    if (equals.equals(str3)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static CaptureConfig getCaptureConfig(String str, int i) {
        HashMap<String, CaptureConfig> hashMap = sCaptureConfigMap;
        CaptureConfig captureConfig = hashMap.get(str + "@" + i);
        if (captureConfig != null) {
            return new CaptureConfig(captureConfig);
        }
        return null;
    }

    public static PreviewConfig getPreviewConfig(String str, int i) {
        HashMap<String, PreviewConfig> hashMap = sPreviewConfigMap;
        PreviewConfig previewConfig = hashMap.get(str + "@" + i);
        if (previewConfig != null) {
            return new PreviewConfig(previewConfig);
        }
        ApsAdapterLog.d(TAG, "getPreviewConfig, config is null");
        PreviewConfig previewConfig2 = new PreviewConfig();
        previewConfig2.mCameraId = i;
        previewConfig2.mCameraMode = str;
        PreviewConfig.Component component = new PreviewConfig.Component();
        component.mbEnable = false;
        previewConfig2.mComponentMap.put(APS_PIPELINE_PREVIEW, component);
        PreviewConfig.Component component2 = new PreviewConfig.Component();
        component2.mbEnable = false;
        previewConfig2.mComponentMap.put(APS_PIPELINE_VIDEO, component2);
        PreviewConfig.Component component3 = new PreviewConfig.Component();
        component3.mbEnable = false;
        previewConfig2.mComponentMap.put(APS_PIPELINE_ASD, component3);
        return previewConfig2;
    }

    public static PreviewConfig getPreviewConfig(String str, int i, Size size, Size size2, boolean z, boolean z2, boolean z3) {
        HashMap<String, PreviewConfig> hashMap = sPreviewConfigMap;
        PreviewConfig previewConfig = hashMap.get(str + "@" + i);
        if (previewConfig == null) {
            return null;
        }
        ApsAdapterLog.d(TAG, "getPreviewConfig, isNeedEnablePipLine: " + z2 + ", isVideoWatermarkOn: " + z);
        PreviewConfig previewConfig2 = new PreviewConfig(previewConfig);
        if (size != null && previewConfig2.mComponentMap.containsKey(APS_PIPELINE_PREVIEW)) {
            PreviewConfig.Component component = previewConfig2.mComponentMap.get(APS_PIPELINE_PREVIEW);
            checkNeedAlgorithmVideoFrc(false, component);
            if (z2 && z) {
                component.mbEnable = true;
            }
            if (!(component.mMasterInputWidth == size.getWidth() && component.mMasterInputHeight == size.getHeight()) && component.mbEnable) {
                component.mMasterInputWidth = size.getWidth();
                component.mMasterInputHeight = size.getHeight();
                component.mSlaveInputWidth = size.getWidth();
                component.mSlaveInputHeight = size.getHeight();
                component.mThirdInputWidth = size.getWidth();
                component.mThirdInputHeight = size.getHeight();
                component.mOutputWidth = size.getWidth();
                component.mOutputHeight = size.getHeight();
            }
        }
        if (size2 != null && previewConfig2.mComponentMap.keySet().contains(APS_PIPELINE_VIDEO)) {
            PreviewConfig.Component component2 = previewConfig2.mComponentMap.get(APS_PIPELINE_VIDEO);
            checkNeedAlgorithmVideoFrc(z3, component2);
            if (z2 && z) {
                component2.mbEnable = true;
            }
            if (!(component2.mMasterInputWidth == size2.getWidth() && component2.mMasterInputHeight == size2.getHeight()) && component2.mbEnable) {
                component2.mMasterInputWidth = size2.getWidth();
                component2.mMasterInputHeight = size2.getHeight();
                component2.mSlaveInputWidth = size2.getWidth();
                component2.mSlaveInputHeight = size2.getHeight();
                component2.mThirdInputWidth = size2.getWidth();
                component2.mThirdInputHeight = size2.getHeight();
                component2.mOutputWidth = size2.getWidth();
                component2.mOutputHeight = size2.getHeight();
            }
        }
        if (size != null && previewConfig2.mComponentMap.keySet().contains(APS_PIPELINE_ASD)) {
            PreviewConfig.Component component3 = previewConfig2.mComponentMap.get(APS_PIPELINE_ASD);
            checkNeedAlgorithmVideoFrc(false, component3);
            if (!(component3.mMasterInputWidth == size.getWidth() && component3.mMasterInputHeight == size.getHeight()) && component3.mbEnable) {
                component3.mMasterInputWidth = size.getWidth();
                component3.mMasterInputHeight = size.getHeight();
                component3.mSlaveInputWidth = size.getWidth();
                component3.mSlaveInputHeight = size.getHeight();
                component3.mThirdInputWidth = size.getWidth();
                component3.mThirdInputHeight = size.getHeight();
                component3.mOutputWidth = size.getWidth();
                component3.mOutputHeight = size.getHeight();
            }
        }
        return previewConfig2;
    }

    private static void checkNeedAlgorithmVideoFrc(boolean z, PreviewConfig.Component component) {
        if (!z && component.mAlgoList != null) {
            for (int i = 0; i < component.mAlgoList.length; i++) {
                if ("preview_video_frc".equals(component.mAlgoList[i])) {
                    component.mAlgoList[i] = "";
                }
            }
        }
    }

    private static void parseConfigData(String str) {
        FileInputStream fileInputStream;
        StringBuilder sb;
        try {
            fileInputStream = new FileInputStream(str);
        } catch (Exception e) {
            ApsAdapterLog.e(TAG, "parseConfigData, e1: " + e.getMessage());
            fileInputStream = null;
        }
        if (fileInputStream != null) {
            try {
                byte[] bArr = new byte[fileInputStream.available()];
                fileInputStream.read(bArr);
                JSONObject jSONObject = new JSONObject(new String(bArr, StandardCharsets.UTF_8));
                sApsVersion = jSONObject.getInt("aps_version");
                sApsMode = jSONObject.getInt("aps_mode");
                ApsAdapterLog.d(TAG, "parseConfigData, sApsVersion: " + sApsVersion + ", sApsMode: " + sApsMode + ", adapterVersion: " + BuildConfig.VERSION_NAME);
                if (getSupportApsCapture()) {
                    parseCaptureConfig(jSONObject);
                }
                if (getSupportApsPreview()) {
                    parsePreviewConfig(jSONObject);
                }
                try {
                    fileInputStream.close();
                    return;
                } catch (Exception e2) {
                    e = e2;
                    sb = new StringBuilder();
                }
            } catch (Exception e3) {
                ApsAdapterLog.e(TAG, "parseConfigData, e2: " + e3.getMessage());
                try {
                    fileInputStream.close();
                    return;
                } catch (Exception e4) {
                    e = e4;
                    sb = new StringBuilder();
                }
            } catch (Throwable th) {
                try {
                    fileInputStream.close();
                } catch (Exception e5) {
                    ApsAdapterLog.e(TAG, "parseConfigData, e3: " + e5.getMessage());
                }
                throw th;
            }
        } else {
            return;
        }
        sb.append("parseConfigData, e3: ");
        sb.append(e.getMessage());
        ApsAdapterLog.e(TAG, sb.toString());
    }

    private static void parseCaptureConfig(JSONObject jSONObject) {
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("aps_capture_configs");
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                    String string = jSONObject2.getString("mode");
                    JSONArray jSONArray2 = jSONObject2.getJSONArray(Downloads.Impl.COLUMN_APP_DATA);
                    for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                        JSONObject jSONObject3 = jSONArray2.getJSONObject(i2);
                        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
                        Iterator<String> keys = jSONObject3.keys();
                        while (keys.hasNext()) {
                            linkedHashSet.add(keys.next());
                        }
                        if (linkedHashSet.contains("id")) {
                            CaptureConfig captureConfig = new CaptureConfig();
                            captureConfig.mCameraMode = string;
                            captureConfig.mCameraId = jSONObject3.getInt("id");
                            boolean z = true;
                            if (linkedHashSet.contains("enable")) {
                                if (jSONObject3.getInt("enable") != 1) {
                                    z = false;
                                }
                            }
                            captureConfig.mbEnable = z;
                            linkedHashSet.remove("id");
                            linkedHashSet.remove("enable");
                            for (String str : linkedHashSet) {
                                if (jSONObject3.getInt(str) != 0) {
                                    captureConfig.mAlgos.add(str);
                                }
                            }
                            sCaptureConfigMap.put(captureConfig.mCameraMode + "@" + captureConfig.mCameraId, captureConfig);
                        }
                    }
                } catch (Exception e) {
                    ApsAdapterLog.e(TAG, "parseCaptureConfig, e1: " + e.getMessage());
                }
            }
        } catch (Exception e2) {
            ApsAdapterLog.e(TAG, "parseCaptureConfig, e2: " + e2.getMessage());
        }
        ApsAdapterLog.d(TAG, "parseCaptureConfig, sCaptureConfigMap: " + sCaptureConfigMap.toString());
    }

    private static void parsePreviewConfig(JSONObject jSONObject) {
        String str;
        String str2;
        String str3 = "id";
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("aps_preview_configs");
            int i = 0;
            while (i < jSONArray.length()) {
                try {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                    String string = jSONObject2.getString("mode");
                    JSONArray jSONArray2 = jSONObject2.getJSONArray(Downloads.Impl.COLUMN_APP_DATA);
                    int i2 = 0;
                    while (i2 < jSONArray2.length()) {
                        JSONObject jSONObject3 = jSONArray2.getJSONObject(i2);
                        if (jSONObject3.has(str3)) {
                            PreviewConfig previewConfig = new PreviewConfig();
                            previewConfig.mCameraMode = string;
                            previewConfig.mCameraId = jSONObject3.getInt(str3);
                            previewConfig.mCameraNum = jSONObject3.getInt("camera_num");
                            previewConfig.mIsSeparateStreamForPrevAndVideo = jSONObject3.getInt("separate_preview_video");
                            JSONObject jSONObject4 = jSONObject3.getJSONObject("pipelines");
                            Iterator<String> keys = jSONObject4.keys();
                            while (keys.hasNext()) {
                                String next = keys.next();
                                JSONObject jSONObject5 = jSONObject4.getJSONObject(next);
                                PreviewConfig.Component component = new PreviewConfig.Component();
                                try {
                                    boolean z = true;
                                    if (jSONObject5.getInt("enable") != 1) {
                                        z = false;
                                    }
                                    component.mbEnable = z;
                                    component.mMasterInputWidth = jSONObject5.getInt("master_input_width");
                                    component.mMasterInputHeight = jSONObject5.getInt("master_input_height");
                                    component.mSlaveInputWidth = jSONObject5.getInt("slave_input_width");
                                    component.mSlaveInputHeight = jSONObject5.getInt("slave_input_height");
                                    component.mThirdInputWidth = jSONObject5.getInt("third_input_width");
                                    component.mThirdInputHeight = jSONObject5.getInt("third_input_height");
                                    component.mOutputWidth = jSONObject5.getInt("output_width");
                                    component.mOutputHeight = jSONObject5.getInt("output_height");
                                    component.mFrameSkipCnt = jSONObject5.getInt("skip_frame_cnt");
                                    String string2 = jSONObject5.getString("pipeline_copy_from");
                                    if (string2.isEmpty()) {
                                        string2 = null;
                                    }
                                    component.mPipelineCopyFrom = string2;
                                    String string3 = jSONObject5.getString("algonode_copy_from");
                                    if (string3.isEmpty()) {
                                        string3 = null;
                                    }
                                    component.mAlgoNodeCopyFrom = string3;
                                    JSONArray jSONArray3 = jSONObject5.getJSONArray("algo_list");
                                    int length = jSONArray3.length();
                                    if (length > 0) {
                                        component.mAlgoList = new String[length];
                                        int i3 = 0;
                                        while (i3 < length) {
                                            str = str3;
                                            try {
                                                component.mAlgoList[i3] = jSONArray3.getString(i3);
                                                i3++;
                                                str3 = str;
                                            } catch (Exception e) {
                                                e = e;
                                                try {
                                                    ApsAdapterLog.d(TAG, "parsePreviewConfig, config: " + previewConfig.mCameraMode + "@" + previewConfig.mCameraId + ", pipeline: " + next + ", e1: " + e.getMessage());
                                                    previewConfig.mComponentMap.put(next, component);
                                                    str3 = str;
                                                } catch (Exception e2) {
                                                    e = e2;
                                                    ApsAdapterLog.e(TAG, "parsePreviewConfig, e2: " + e.getMessage());
                                                    i++;
                                                    str3 = str;
                                                }
                                            }
                                        }
                                    }
                                    str = str3;
                                } catch (Exception e3) {
                                    e = e3;
                                    str = str3;
                                    ApsAdapterLog.d(TAG, "parsePreviewConfig, config: " + previewConfig.mCameraMode + "@" + previewConfig.mCameraId + ", pipeline: " + next + ", e1: " + e.getMessage());
                                    previewConfig.mComponentMap.put(next, component);
                                    str3 = str;
                                }
                                previewConfig.mComponentMap.put(next, component);
                                str3 = str;
                            }
                            str2 = str3;
                            sPreviewConfigMap.put(previewConfig.mCameraMode + "@" + previewConfig.mCameraId, previewConfig);
                        } else {
                            str2 = str3;
                        }
                        i2++;
                        str3 = str2;
                    }
                    str = str3;
                } catch (Exception e4) {
                    e = e4;
                    str = str3;
                    ApsAdapterLog.e(TAG, "parsePreviewConfig, e2: " + e.getMessage());
                    i++;
                    str3 = str;
                }
                i++;
                str3 = str;
            }
        } catch (Exception e5) {
            ApsAdapterLog.e(TAG, "parsePreviewConfig, e3: " + e5.getMessage());
        }
        ApsAdapterLog.d(TAG, "parsePreviewConfig, sPreviewConfigMap: " + sPreviewConfigMap.toString());
    }

    public static class CaptureConfig {
        public Set<String> mAlgos = new HashSet();
        public int mCameraId = -1;
        public String mCameraMode = null;
        public boolean mbEnable = true;

        CaptureConfig() {
        }

        CaptureConfig(CaptureConfig captureConfig) {
            this.mCameraMode = captureConfig.mCameraMode;
            this.mCameraId = captureConfig.mCameraId;
            this.mbEnable = captureConfig.mbEnable;
            this.mAlgos.addAll(captureConfig.mAlgos);
        }

        public String toString() {
            return "mCameraMode: " + this.mCameraMode + ", mCameraId: " + this.mCameraId + ", mbEnable: " + this.mbEnable + ", mAlgos: " + this.mAlgos;
        }
    }

    public static class PreviewConfig {
        public int mCameraId;
        public String mCameraMode;
        public int mCameraNum;
        public ArrayMap<String, Component> mComponentMap;
        public int mIsSeparateStreamForPrevAndVideo;

        PreviewConfig() {
            this.mCameraMode = null;
            this.mCameraId = -1;
            this.mCameraNum = -1;
            this.mIsSeparateStreamForPrevAndVideo = 0;
            this.mComponentMap = new ArrayMap<>();
        }

        PreviewConfig(PreviewConfig previewConfig) {
            this.mCameraMode = null;
            this.mCameraId = -1;
            this.mCameraNum = -1;
            this.mIsSeparateStreamForPrevAndVideo = 0;
            this.mComponentMap = new ArrayMap<>();
            this.mCameraMode = previewConfig.mCameraMode;
            this.mCameraId = previewConfig.mCameraId;
            this.mCameraNum = previewConfig.mCameraNum;
            this.mIsSeparateStreamForPrevAndVideo = previewConfig.mIsSeparateStreamForPrevAndVideo;
            for (int i = 0; i < previewConfig.mComponentMap.size(); i++) {
                this.mComponentMap.put(previewConfig.mComponentMap.keyAt(i), previewConfig.mComponentMap.valueAt(i));
            }
        }

        public String toString() {
            return "mCameraMode: " + this.mCameraMode + ", mCameraId: " + this.mCameraId + ", mCameraNum: " + this.mCameraNum + ", mIsSeparateStreamForPrevAndVideo: " + this.mIsSeparateStreamForPrevAndVideo + ", mComponentMap: " + this.mComponentMap;
        }

        public static class Component {
            public String[] mAlgoList = null;
            public String mAlgoNodeCopyFrom = null;
            public int mFrameSkipCnt = 0;
            public int mMasterInputHeight = 0;
            public int mMasterInputWidth = 0;
            public int mOutputHeight = 0;
            public int mOutputWidth = 0;
            public String mPipelineCopyFrom = null;
            public int mSlaveInputHeight = 0;
            public int mSlaveInputWidth = 0;
            public int mThirdInputHeight = 0;
            public int mThirdInputWidth = 0;
            public boolean mbEnable = true;

            public String toString() {
                return "{" + "mbEnable: " + this.mbEnable + ", mMasterInputWidth: " + this.mMasterInputWidth + ", mMasterInputHeight: " + this.mMasterInputHeight + ", mSlaveInputWidth: " + this.mSlaveInputWidth + ", mSlaveInputHeight: " + this.mSlaveInputHeight + ", mThirdInputWidth: " + this.mThirdInputWidth + ", mThirdInputHeight: " + this.mThirdInputHeight + ", mOutputWidth: " + this.mOutputWidth + ", mOutputHeight: " + this.mOutputHeight + ", mFrameSkipCnt: " + this.mFrameSkipCnt + ", mPipelineCopyFrom: " + this.mPipelineCopyFrom + ", mAlgoNodeCopyFrom: " + this.mAlgoNodeCopyFrom + ", mAlgoList: " + Arrays.toString(this.mAlgoList) + "}";
            }
        }
    }
}
