package com.oppo.camera.aps.config;

import android.graphics.Color;
import android.text.TextUtils;
import android.util.Size;
import com.oppo.camera.aps.adapter.ApsUtils;
import com.oppo.camera.e;
import com.oppo.camera.f.a;
import com.oppo.camera.ui.h;
import com.oppo.camera.ui.menu.b;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CameraConfig {
    private static final String TAG = "CameraConfig";
    private static ConfigDataBase sConfigDataBase;
    private static final Object sInitLockObject = new Object();
    private static boolean sbInit = false;

    public static void initialize() {
        synchronized (sInitLockObject) {
            if (!sbInit) {
                sConfigDataBase = new ConfigDataBase();
                sConfigDataBase.parseDefaultProjectConfig();
                sConfigDataBase.parseProjectConfigFromConfigFile();
                sConfigDataBase.parseMenuPanel();
                sConfigDataBase.parseMenuSetting();
                sConfigDataBase.parseDefaultMenuSettingConfigMap();
                sConfigDataBase.parseOptionItemConfig();
                sbInit = true;
            }
        }
    }

    public static List<String> getSupportedList(String str, int i) {
        if (sConfigDataBase.getOptionItemConfigs() == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(a.c(i) ? "_front_camera_supported" : "_back_camera_supported");
        String sb2 = sb.toString();
        for (b next : sConfigDataBase.getOptionItemConfigs()) {
            if (next != null && (next.a().equals(str) || next.a().equals(sb2))) {
                return next.b();
            }
        }
        return null;
    }

    public static boolean getSupportSettingMenuKey(String str) {
        return !TextUtils.isEmpty(str) && sConfigDataBase.getMenuSettingList() != null && sConfigDataBase.getMenuSettingList().contains(str);
    }

    public static String getOptionKeyDefaultValue(String str, int i) {
        try {
            if (sConfigDataBase.getDefaultMenuSettingConfig() == null) {
                return null;
            }
            String str2 = str + "_default";
            StringBuilder sb = new StringBuilder();
            sb.append(str2);
            sb.append(a.c(i) ? "_front_camera" : "_back_camera");
            String sb2 = sb.toString();
            if (sConfigDataBase.getDefaultMenuSettingConfig().containsKey(str2)) {
                return sConfigDataBase.getDefaultMenuSettingConfig().get(str2);
            }
            if (sConfigDataBase.getDefaultMenuSettingConfig().containsKey(sb2)) {
                return sConfigDataBase.getDefaultMenuSettingConfig().get(sb2);
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean getConfigBooleanValue(String str, int i) {
        if (sConfigDataBase.getDefaultMenuSettingConfig() == null) {
            return false;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(a.c(i) ? "_front_camera_supported" : "_back_camera_supported");
        String sb2 = sb.toString();
        if (sConfigDataBase.getDefaultMenuSettingConfig().containsKey(str)) {
            return Boolean.parseBoolean(sConfigDataBase.getDefaultMenuSettingConfig().get(str));
        }
        if (sConfigDataBase.getDefaultMenuSettingConfig().containsKey(sb2)) {
            return Boolean.parseBoolean(sConfigDataBase.getDefaultMenuSettingConfig().get(sb2));
        }
        return false;
    }

    public static void setConfigBooleanValue(String str, boolean z) {
        ConfigDataBase configDataBase = sConfigDataBase;
        if (configDataBase == null) {
            return;
        }
        if (z) {
            configDataBase.getProjectMap().put(str, "1");
        } else {
            configDataBase.getProjectMap().put(str, "0");
        }
    }

    public static List<String> getMenuPanelOptionList() {
        ConfigDataBase configDataBase = sConfigDataBase;
        if (configDataBase != null) {
            return configDataBase.getMenuPanelList();
        }
        return new ArrayList();
    }

    public static boolean checkKeyInMenuList(String str) {
        if (str != null && !str.equals("")) {
            if (sConfigDataBase.getMenuPanelList() != null) {
                for (int i = 0; i < sConfigDataBase.getMenuPanelList().size(); i++) {
                    if (h.a((Object) str, (Object) sConfigDataBase.getMenuPanelList().get(i))) {
                        return true;
                    }
                }
            }
            if (sConfigDataBase.getMenuSettingList() != null) {
                for (int i2 = 0; i2 < sConfigDataBase.getMenuSettingList().size(); i2++) {
                    if (h.a((Object) str, (Object) sConfigDataBase.getMenuSettingList().get(i2))) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static Size getSizeConfigValue(String str) {
        if (sConfigDataBase.getProjectMap() != null && sConfigDataBase.getProjectMap().containsKey(str)) {
            try {
                String str2 = sConfigDataBase.getProjectMap().get(str);
                return new Size(Integer.parseInt(str2.split("x")[0]), Integer.parseInt(str2.split("x")[1]));
            } catch (Exception e) {
                e.e(TAG, e.getMessage());
            }
        }
        return null;
    }

    public static Size getSizeConfigValue(String str, int i) {
        if (a.c(i)) {
            return getSizeConfigValue(ConfigDataBase.KEY_HIGH_PICTURE_SIZE_FRONT);
        }
        return getSizeConfigValue(str);
    }

    public static int getConfigIntValue(String str, int i) {
        if (a.c(i)) {
            return getConfigIntValue(ConfigDataBase.KEY_HIGH_PICTURE_SIZE_NAME_FRONT);
        }
        return getConfigIntValue(str);
    }

    public static List<Size> getConfigSizeListValue(String str) {
        if (sConfigDataBase.getProjectMap() == null || !sConfigDataBase.getProjectMap().containsKey(str) || sConfigDataBase.getProjectMap().get(str) == null) {
            return null;
        }
        String[] split = sConfigDataBase.getProjectMap().get(str).split("x");
        int length = split.length / 2;
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            arrayList.add(new Size(Integer.parseInt(split[i2]), Integer.parseInt(split[i2 + 1])));
        }
        return arrayList;
    }

    public static List<String> getConfigStringListValue(String str) {
        if (sConfigDataBase.getProjectMap() == null || !sConfigDataBase.getProjectMap().containsKey(str) || sConfigDataBase.getProjectMap().get(str) == null) {
            return null;
        }
        return Arrays.asList(sConfigDataBase.getProjectMap().get(str).split(","));
    }

    public static boolean getConfigBooleanValue(String str) {
        if (sConfigDataBase.getProjectMap() == null || !sConfigDataBase.getProjectMap().containsKey(str)) {
            return false;
        }
        try {
            if (Byte.parseByte(sConfigDataBase.getProjectMap().get(str)) > 0) {
                return true;
            }
            return false;
        } catch (Exception e) {
            e.e(TAG, "getConfigBooleanValue, key: " + str + ", value: " + sConfigDataBase.getProjectMap().get(str));
            e.printStackTrace();
            return true;
        }
    }

    public static Byte getConfigByteValue(String str) {
        if (sConfigDataBase.getProjectMap() == null || !sConfigDataBase.getProjectMap().containsKey(str)) {
            return (byte) 0;
        }
        return Byte.valueOf(Byte.parseByte(sConfigDataBase.getProjectMap().get(str)));
    }

    public static int getConfigIntValue(String str) {
        if (sConfigDataBase.getProjectMap() == null || !sConfigDataBase.getProjectMap().containsKey(str)) {
            return -1;
        }
        return Integer.parseInt(sConfigDataBase.getProjectMap().get(str));
    }

    public static float getConfigFloatValue(String str) {
        if (sConfigDataBase.getProjectMap() == null || !sConfigDataBase.getProjectMap().containsKey(str)) {
            return 0.0f;
        }
        return Float.parseFloat(sConfigDataBase.getProjectMap().get(str));
    }

    public static float[] getConfigFloatArrayValue(String str) {
        if (sConfigDataBase.getProjectMap() == null || !sConfigDataBase.getProjectMap().containsKey(str) || sConfigDataBase.getProjectMap().get(str) == null) {
            return null;
        }
        String[] split = sConfigDataBase.getProjectMap().get(str).split(",");
        float[] fArr = new float[split.length];
        for (int i = 0; i < fArr.length; i++) {
            fArr[i] = Float.parseFloat(split[i]);
        }
        return fArr;
    }

    public static int[] getConfigIntArrayValue(String str) {
        if (sConfigDataBase.getProjectMap() == null || !sConfigDataBase.getProjectMap().containsKey(str) || sConfigDataBase.getProjectMap().get(str) == null) {
            return null;
        }
        String[] split = sConfigDataBase.getProjectMap().get(str).split(",");
        int[] iArr = new int[split.length];
        for (int i = 0; i < iArr.length; i++) {
            iArr[i] = Integer.parseInt(split[i]);
        }
        return iArr;
    }

    public static int getConfigColorValue(String str) {
        if (sConfigDataBase.getProjectMap() != null && sConfigDataBase.getProjectMap().containsKey(str)) {
            try {
                return Color.parseColor(sConfigDataBase.getProjectMap().get(str));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return -1;
    }

    public static String getConfigStringValue(String str) {
        if (sConfigDataBase.getProjectMap() == null || !sConfigDataBase.getProjectMap().containsKey(str)) {
            return null;
        }
        return sConfigDataBase.getProjectMap().get(str);
    }

    public static String[] getConfigStringArrayValue(String str) {
        if (sConfigDataBase.getProjectMap() == null || !sConfigDataBase.getProjectMap().containsKey(str)) {
            return null;
        }
        String configStringValue = getConfigStringValue(str);
        if (!TextUtils.isEmpty(configStringValue)) {
            return configStringValue.split(",");
        }
        return null;
    }

    public static String getConfigFpsValue(String str) {
        String[] configStringArrayValue = getConfigStringArrayValue(str);
        return (configStringArrayValue == null || configStringArrayValue.length != 2) ? "" : configStringArrayValue[0];
    }

    public static String getConfigFpsVideoType(String str) {
        String[] configStringArrayValue = getConfigStringArrayValue(str);
        return (configStringArrayValue == null || configStringArrayValue.length != 2) ? "" : configStringArrayValue[1];
    }

    public static void release() {
        e.a(TAG, "release");
        synchronized (sInitLockObject) {
            sbInit = false;
        }
    }

    public static boolean isApsSupportVendorTag(String str) {
        String vendorTagConfig = ApsUtils.getVendorTagConfig(str);
        e.c(TAG, "isApsSupportVendorTag, key: " + str + ", value: " + vendorTagConfig);
        return vendorTagConfig != null;
    }
}
