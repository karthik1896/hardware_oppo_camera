package android.hardware.fingerprint;

import android.util.Log;

public class FingerprintManager {
    public static final int KEYCODE_SYSTEM_FINGERPRINT_KEYMODE = -1;
    private static String TAG = "FingerprintManager";

    private FingerprintManager() {
    }

    public void setFingerKeymode(int i) {
        String str = TAG;
        Log.d(str, "setFingerKeymode for test, enable: " + i);
    }
}
