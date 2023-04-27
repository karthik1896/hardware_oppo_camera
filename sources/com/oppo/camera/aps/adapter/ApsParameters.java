package com.oppo.camera.aps.adapter;

import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraMetadata;
import android.hardware.camera2.CaptureResult;
import android.util.Size;
import android.view.Surface;
import androidx.collection.ArrayMap;
import androidx.collection.SimpleArrayMap;
import com.oppo.camera.aps.ApsAdapterLog;
import com.oppo.camera.aps.ApsCameraRequestTag;
import com.oppo.camera.aps.adapter.ImageCategory;
import com.oppo.camera.statistics.CameraStatisticsUtil;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ApsParameters {
    public static final String ALGO_NAME_FRC = "preview_video_frc";
    public static final String ALGO_NAME_NONE = "aps_algo_none";
    public static final String APS_PIPELINE_NAME_AUTO_SCENE_DETECT = "pipeline_asd";
    public static final String APS_PIPELINE_NAME_DEFAULT = "pipeline_default";
    public static final String APS_PIPELINE_NAME_PREVIEW = "pipeline_preview";
    public static final String APS_PIPELINE_NAME_VIDEO = "pipeline_video";
    public static final int CATEGORY_AUTO = 1;
    public static final int CATEGORY_MANUAL = 2;
    public static final int DEFAULT_MAP_SIZE = 128;
    public static final int DOUBLE_MAP_SIZE = 2;
    public static final String FLAG_OFF = "0";
    public static final String FLAG_ON = "1";
    public static final int FORCE_STOP_SLOW_VIDEO_RECORD = 1;
    public static final Key<String[]> KEY_APS_PROCESS_ALGO_TYPE = new Key<>("apsProcessAlgoType", 2);
    public static final Key<ApsWatermarkParam> KEY_APS_WATERMARK_PARAM = new Key<>("watermarkParam", 2);
    public static final Key<Integer> KEY_BURST_COUNT = new Key<>(CameraStatisticsUtil.PORTRAIT_BURST_COUNT, 2, 0);
    public static final Key<Boolean> KEY_BURST_SHOT = new Key<>("burst_shot", 2, false);
    public static final Key<Long> KEY_BURST_SHOT_FLAG_ID = new Key<>("burst_shot_flag_id", 2, -1L);
    public static final Key<CameraCharacteristics> KEY_CAMERA_CHARACTERISTICS = new Key<>("cameraCharacteristics", 2);
    public static final Key<ApsCameraRequestTag> KEY_CAMERA_REQUEST_TAG = new Key<>("cameraRequestTag", 2);
    public static final Key<String> KEY_CAPTURE_MODE = new Key<>(CameraStatisticsUtil.PORTRAIT_CAPTURE_MODE, 1);
    public static final Key<CaptureResult> KEY_CAPTURE_RESULT = new Key<>("captureResult", 2);
    public static final Key<Integer> KEY_CAPTURE_STREAM_NUMBER = new Key<>("captureStreamNumber", 2, 1);
    public static final Key<String> KEY_CSHOT_PATH = new Key<>("cshot_path", 2, "");
    public static final Key<Integer> KEY_CSHOT_REQUEST_NUMER = new Key<>("cShotRequestNum", 2, 20);
    public static final Key<Long> KEY_DATE = new Key<>("date", 2, 0L);
    public static final Key<Long> KEY_FRAME_NUMBER = new Key<>("frameNumber", 2, 0L);
    public static final String KEY_HEIF_FILE_FD = "heif_fd";
    public static final Key<Integer> KEY_IMAGE_FORMAT = new Key<>("image_format", 2, 0);
    public static final Key<Integer> KEY_IMAGE_ROLE = new Key<>("image_role", 2, 0);
    public static final Key<int[]> KEY_INPUT_SIZE = new Key<>("input_size", 2);
    public static final Key<Boolean> KEY_IS_DETACHED = new Key<>("isDetached", 2, false);
    public static final Key<ImageCategory.ItemInfoType> KEY_ITEM_INFO_TYPE = new Key<>("item_info_type", 2, ImageCategory.ItemInfoType.CAPTURE);
    public static final Key<Integer> KEY_LOGIC_CAMERA_ID = new Key<>("logic_camera_id", 1, 0);
    public static final Key<Integer> KEY_MAX_BURST_SHOT_NUM = new Key<>("max_burst_shot_num", 2, 20);
    public static final Key<Integer> KEY_MAX_HOLD_IMAGES = new Key<>("max_hold_images", 2, 0);
    public static final Key<Long> KEY_MERGE_IDENTITY = new Key<>("mergeIdentity", 2, -1L);
    public static final Key<Integer> KEY_MERGE_INDEX = new Key<>("mergeIndex", 2, 0);
    public static final Key<Integer> KEY_MERGE_NUMBER = new Key<>("mergeNumber", 2, 1);
    public static final Key<ArrayMap<String, CameraMetadata>> KEY_META_MAP = new Key<>("metaMap", 2);
    public static final Key<Boolean> KEY_NEED_MATCH_TIME_STAMP = new Key<>("needMatchTimeStamp", 2, true);
    public static final Key<Boolean> KEY_NEED_META_DATA = new Key<>("needMetadata", 2, true);
    public static final String KEY_PACKAGE_NAME = "package_name";
    public static final String KEY_PIPELINE = "pipeline";
    public static final Key<Integer> KEY_PREFER_ADD_FRAME_TYPE = new Key<>("prefer_add_frame_type", 2, 0);
    public static final Key<Size> KEY_PREVIEW_SIZE = new Key<>("previewSize", 2);
    public static final Key<Integer> KEY_PREVIEW_STREAM_NUMBER = new Key<>("previewStreamNumber", 2, 1);
    public static final String KEY_PROCESS_IMAGE_IDENTITY = "identity";
    public static final Key<Integer> KEY_REC_BURST_NUMBER = new Key<>("rec_burst_number", 2, -1);
    public static final Key<Boolean> KEY_REPROCESS_META_DATA = new Key<>("reprocessMetadata", 2, false);
    public static final Key<String> KEY_SUPER_RAW_ENABLE = new Key<>("super_raw_enable", 1);
    public static final Key<Surface> KEY_SURFACE = new Key<>("surface", 2);
    public static final Key<Long> KEY_TIME_STAMP = new Key<>("time_stamp", 2, 0L);
    public static final String KEY_TOTAL_MEMORY = "total_memory";
    public static final Key<Boolean> KEY_USE_TUNING_DATA = new Key<>("use_tuning_data", 2, false);
    public static final Key<Boolean> KEY_VALID_BURST_SHOT_IMAGE = new Key<>("valid_burst_shot_image", 2, false);
    public static final Key<Boolean> KEY_VIDEO_SNAPSHOT = new Key<>("video_snapshot", 2, false);
    public static final int PREFER_ADD_FRAME_WITH_COPY = 1;
    public static final int PREFER_ADD_FRAME_WITH_DETACH = 0;
    private static final String TAG = "ApsParameters";
    private HashMap<String, String> mMap;

    public interface Supplier<T> {
        T get();
    }

    public ApsParameters() {
        this.mMap = null;
        this.mMap = new HashMap<>(128);
    }

    public void set(String str, String str2) {
        if (str2 == null) {
            ApsAdapterLog.e(TAG, "set, key: " + str);
            return;
        }
        this.mMap.remove(str);
        this.mMap.put(str, str2);
    }

    public void setAll(HashMap<String, String> hashMap) {
        if (hashMap != null) {
            for (Map.Entry next : hashMap.entrySet()) {
                set((String) next.getKey(), (String) next.getValue());
            }
        }
    }

    public String get(String str) {
        HashMap<String, String> hashMap = this.mMap;
        if (hashMap == null) {
            return null;
        }
        return hashMap.get(str);
    }

    public String[] getParameters() {
        int size = this.mMap.size();
        if (size == 0) {
            return null;
        }
        String[] strArr = new String[(size * 2)];
        int i = 0;
        for (String next : this.mMap.keySet()) {
            int i2 = i + 1;
            strArr[i] = next;
            i = i2 + 1;
            strArr[i2] = this.mMap.get(next);
        }
        return strArr;
    }

    public static class ParameterModel {
        public Map<Key<?>, ValueWrapper<?>> mParameterMap = new HashMap();

        public <T> void setParameter(Key<T> key, final T t) {
            this.mParameterMap.put(key, new ValueWrapper(new Supplier<T>() {
                public T get() {
                    return t;
                }
            }));
        }

        public <T> T get(Key<T> key) {
            ValueWrapper<?> valueWrapper = this.mParameterMap.get(key);
            return valueWrapper != null ? valueWrapper.getValue().get() : key.getDefault();
        }

        public Map<Key<?>, ValueWrapper<?>> copy(Map<Key<?>, ValueWrapper<?>> map) {
            Object obj;
            for (Map.Entry next : this.mParameterMap.entrySet()) {
                Key key = (Key) next.getKey();
                Key key2 = new Key(key.getName(), key.getCategory(), key.getDefault());
                final Object obj2 = ((ValueWrapper) next.getValue()).getValue().get();
                if (obj2 instanceof String[]) {
                    obj2 = ((String[]) obj2).clone();
                } else if (obj2 instanceof int[]) {
                    obj2 = ((int[]) obj2).clone();
                } else {
                    if (obj2 instanceof ArrayMap) {
                        obj = new ArrayMap((SimpleArrayMap) (ArrayMap) obj2);
                    } else if (obj2 instanceof float[]) {
                        float[] fArr = (float[]) obj2;
                        obj = new float[fArr.length];
                        System.arraycopy(fArr, 0, obj, 0, fArr.length);
                    }
                    obj2 = obj;
                }
                map.put(key2, new ValueWrapper(new Supplier() {
                    public Object get() {
                        return obj2;
                    }
                }));
            }
            return map;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            for (Map.Entry next : this.mParameterMap.entrySet()) {
                Object obj = ((ValueWrapper) next.getValue()).getValue().get();
                if (obj instanceof String[]) {
                    sb.append(((Key) next.getKey()).getName());
                    sb.append(": ");
                    sb.append(Arrays.toString((String[]) ((ValueWrapper) next.getValue()).getValue().get()));
                    sb.append(", ");
                } else if (obj instanceof int[]) {
                    sb.append(((Key) next.getKey()).getName());
                    sb.append(": ");
                    sb.append(Arrays.toString((int[]) ((ValueWrapper) next.getValue()).getValue().get()));
                    sb.append(", ");
                } else if (obj instanceof float[]) {
                    sb.append(((Key) next.getKey()).getName());
                    sb.append(": ");
                    sb.append(Arrays.toString((float[]) ((ValueWrapper) next.getValue()).getValue().get()));
                    sb.append(", ");
                } else {
                    sb.append(((Key) next.getKey()).getName());
                    sb.append(": ");
                    sb.append(((ValueWrapper) next.getValue()).getValue().get());
                    sb.append(", ");
                }
            }
            sb.replace(sb.length() - 1, sb.length(), "");
            return sb.toString();
        }
    }

    public static final class Key<T> {
        private int mCategory = 0;
        private T mDefault;
        private String mKeyName = null;

        public Key(String str, int i) {
            this.mKeyName = str;
            this.mCategory = i;
        }

        public Key(String str, int i, T t) {
            this.mKeyName = str;
            this.mCategory = i;
            this.mDefault = t;
        }

        public String getName() {
            return this.mKeyName;
        }

        public int getCategory() {
            return this.mCategory;
        }

        public T getDefault() {
            return this.mDefault;
        }

        public int hashCode() {
            return this.mKeyName.hashCode();
        }

        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            return this.mKeyName.equals(((Key) obj).mKeyName);
        }

        public String toString() {
            return "mKeyName: " + this.mKeyName + ", mCategory: " + this.mCategory + ", mDefault: " + this.mDefault;
        }
    }

    public static final class ValueWrapper<T> {
        private Supplier<T> mValue = null;

        public ValueWrapper(Supplier<T> supplier) {
            this.mValue = supplier;
        }

        public Supplier<T> getValue() {
            return this.mValue;
        }
    }
}
