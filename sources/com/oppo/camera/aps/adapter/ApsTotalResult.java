package com.oppo.camera.aps.adapter;

import android.hardware.camera2.CaptureResult;
import android.text.TextUtils;
import com.oppo.camera.aps.ApsAdapterLog;
import com.oppo.camera.aps.ApsCameraMetadataKey;
import com.oppo.camera.aps.config.AlgoSwitchConfig;
import java.util.HashMap;
import java.util.List;

public class ApsTotalResult {
    public static final Key<Integer> APS_AI_SCENE = new Key<>("ASD_scene_icon", Integer.TYPE);
    public static final Key<Integer> APS_AI_TUNING_SCENE = new Key<>("ASD_tuning_scene", Integer.TYPE);
    public static final Key<Integer> APS_BOKEN_STATE = new Key<>("RTB_msg", Integer.TYPE);
    public static final Key<Integer> APS_HDR_SCOPE = new Key<>("ASD_hdr_scope", Integer.TYPE);
    public static final Key<Integer> APS_LENS_DIRTY = new Key<>("LSD_is_dirty", Integer.TYPE);
    private static final int APS_RESULT_DATA_LENGTH = 3;
    public static final Key<Integer> APS_VIDEO_EIS = new Key<>("video_eis_on", Integer.TYPE);
    public static final Key<Integer> SAT_ACTIVE_MAP = new Key<>("sat_active_map", Integer.TYPE);
    public static final Key<Integer> SAT_MASTER_CAMERA_ID = new Key<>("sat_master_camera_id", Integer.TYPE);
    private static final String TAG = "ApsTotalResult";
    private HashMap<Key, Object> mResults = new HashMap<>();
    private CaptureResult mTotalResult = null;

    private static final class Key<T> {
        /* access modifiers changed from: private */
        public String mName;

        private Key(String str, Class<T> cls) {
            this.mName = "";
            this.mName = str;
        }
    }

    public ApsTotalResult(CaptureResult captureResult) {
        this.mTotalResult = captureResult;
        parse();
    }

    public boolean containsKey(Key key) {
        return this.mResults.containsKey(key);
    }

    public <T> T get(Key<T> key) {
        T t;
        if (this.mResults.containsKey(key) && (t = this.mResults.get(key)) != null) {
            return t;
        }
        return null;
    }

    public CaptureResult getTotalResult() {
        return this.mTotalResult;
    }

    private void parse() {
        CaptureResult captureResult;
        byte[] bArr;
        if (2 != AlgoSwitchConfig.getApsVersion() && (captureResult = this.mTotalResult) != null) {
            try {
                bArr = (byte[]) captureResult.get(ApsCameraMetadataKey.KEY_APS_RESULT_DATA);
            } catch (Exception unused) {
                ApsAdapterLog.e(TAG, "parse, com.oppo.aps.result.data is undefined.");
                bArr = null;
            }
            if (bArr == null) {
                ApsAdapterLog.e(TAG, "apsResultData is null.");
                return;
            }
            List<String> matchBrackets = ApsUtils.matchBrackets(new String(bArr));
            if (matchBrackets == null) {
                ApsAdapterLog.e(TAG, "parse, parse result is null.");
                return;
            }
            for (String next : matchBrackets) {
                if (!TextUtils.isEmpty(next)) {
                    String[] split = next.split(";");
                    if (split == null || 3 != split.length) {
                        ApsAdapterLog.e(TAG, "parse, invalid str: " + next);
                    } else if (APS_BOKEN_STATE.mName.equals(split[0])) {
                        this.mResults.put(APS_BOKEN_STATE, Integer.valueOf(Integer.parseInt(split[2])));
                    } else if (APS_AI_SCENE.mName.equals(split[0])) {
                        this.mResults.put(APS_AI_SCENE, Integer.valueOf(Integer.parseInt(split[2])));
                    } else if (APS_AI_TUNING_SCENE.mName.equals(split[0])) {
                        this.mResults.put(APS_AI_TUNING_SCENE, Integer.valueOf(Integer.parseInt(split[2])));
                    } else if (SAT_MASTER_CAMERA_ID.mName.equals(split[0])) {
                        this.mResults.put(SAT_MASTER_CAMERA_ID, Integer.valueOf(Integer.parseInt(split[2])));
                    } else if (SAT_ACTIVE_MAP.mName.equals(split[0])) {
                        this.mResults.put(SAT_ACTIVE_MAP, Integer.valueOf(Integer.parseInt(split[2])));
                    } else if (APS_LENS_DIRTY.mName.equals(split[0])) {
                        this.mResults.put(APS_LENS_DIRTY, Integer.valueOf(Integer.parseInt(split[2])));
                    } else if (APS_VIDEO_EIS.mName.equals(split[0])) {
                        this.mResults.put(APS_VIDEO_EIS, Integer.valueOf(Integer.parseInt(split[2])));
                    } else if (APS_HDR_SCOPE.mName.equals(split[0])) {
                        this.mResults.put(APS_HDR_SCOPE, Integer.valueOf(Integer.parseInt(split[2])));
                    }
                }
            }
        }
    }
}
