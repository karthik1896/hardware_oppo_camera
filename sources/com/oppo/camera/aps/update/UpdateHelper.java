package com.oppo.camera.aps.update;

import android.content.Context;
import com.oppo.camera.aps.ApsAdapterLog;
import java.io.File;

public class UpdateHelper {
    private static final String TAG = "UpdateHelper";

    private UpdateHelper() {
    }

    public static String tryRusUpdatePath(Context context, String str) {
        File filesDir = context.getFilesDir();
        String str2 = filesDir.getAbsolutePath() + str;
        if (!new File(str2).exists()) {
            return str;
        }
        ApsAdapterLog.v(TAG, "tryRusUpdatePath, updatePath: " + str2);
        return str2;
    }
}
