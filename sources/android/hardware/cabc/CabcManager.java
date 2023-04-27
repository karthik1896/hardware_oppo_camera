package android.hardware.cabc;

public class CabcManager {
    public static final int OFF_MODE = 0;
    public static final int PIC_MODE = 2;
    private static final String TAG = "CabcManager";
    public static final int UI_MODE = 1;
    public static final int VIDEO_MODE = 3;
    private static CabcManager mCabcManagerInstance;
    private int mMode = 3;

    private void init() {
    }

    public void closeCabc() {
    }

    public int getMode() {
        return 3;
    }

    public void openCabc() {
    }

    public void setMode(int i) {
    }

    private CabcManager() {
        init();
    }

    public static CabcManager getCabcManagerInstance() {
        if (mCabcManagerInstance == null) {
            mCabcManagerInstance = new CabcManager();
        }
        return mCabcManagerInstance;
    }
}
