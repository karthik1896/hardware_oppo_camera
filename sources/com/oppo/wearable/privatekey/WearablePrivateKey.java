package com.oppo.wearable.privatekey;

public class WearablePrivateKey {
    public static final int KEYCODE_OCLICK_DOUBLE_DOWN = 332;
    public static final int KEYCODE_OCLICK_DOUBLE_LEFT = 333;
    public static final int KEYCODE_OCLICK_DOUBLE_OK = 329;
    public static final int KEYCODE_OCLICK_DOUBLE_RIGHT = 331;
    public static final int KEYCODE_OCLICK_DOUBLE_UP = 330;
    public static final int KEYCODE_OCLICK_LONG_DOWN = 342;
    public static final int KEYCODE_OCLICK_LONG_LEFT = 343;
    public static final int KEYCODE_OCLICK_LONG_OK = 339;
    public static final int KEYCODE_OCLICK_LONG_RIGHT = 341;
    public static final int KEYCODE_OCLICK_LONG_UP = 340;
    public static final int KEYCODE_OCLICK_SINGLE_DOWN = 322;
    public static final int KEYCODE_OCLICK_SINGLE_LEFT = 323;
    public static final int KEYCODE_OCLICK_SINGLE_OK = 319;
    public static final int KEYCODE_OCLICK_SINGLE_RIGHT = 321;
    public static final int KEYCODE_OCLICK_SINGLE_UP = 320;
    private static final int KEY_INTERVAL = 10;
    private static final int SYSTEM_LAST_KEYCODE = 219;
    String WearablePrivateKey_VERSION = "1.0";

    public static boolean isOClickKey(int i) {
        if (i >= 319 && i <= 323) {
            return true;
        }
        if (i < 329 || i > 333) {
            return i >= 339 && i <= 343;
        }
        return true;
    }
}
