package com.oppo.camera.update;

import android.content.Context;
import android.text.TextUtils;
import com.oppo.camera.aps.update.ApsUpdateParam;
import com.oppo.camera.e;
import com.oppo.camera.q.a;
import java.io.File;

public class ApsUpdateHelper {
    private static final int NUM_TWO = 2;
    private static final String TAG = "ApsUpdateHelper";

    private ApsUpdateHelper() {
    }

    public static void updateApsParamToFile(Context context, ApsUpdateParam apsUpdateParam) {
        if (apsUpdateParam == null || !apsUpdateParam.isValid()) {
            e.e(TAG, "updateApsParamToFile, apsUpdateParam is null");
            return;
        }
        File filesDir = context.getFilesDir();
        if (ensurePathExist(filesDir, apsUpdateParam.getUpdateFilePath())) {
            String str = filesDir.toString() + apsUpdateParam.getUpdateFilePath();
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            a.b(str, a.f3583b, apsUpdateParam.getUpdateContent().getBytes());
        }
    }

    private static boolean ensurePathExist(File file, String str) {
        if (TextUtils.isEmpty(str)) {
            e.e(TAG, "ensurePathExist, updateFilePath is null");
            return false;
        }
        String[] split = str.split("/");
        if (split.length < 2) {
            return true;
        }
        if (!file.exists()) {
            return false;
        }
        StringBuilder sb = new StringBuilder(file.getAbsolutePath());
        for (int i = 0; i < split.length - 1; i++) {
            if (!TextUtils.isEmpty(split[i])) {
                sb.append(File.separator);
                sb.append(split[i]);
            }
        }
        File file2 = new File(sb.toString());
        if (file2.exists()) {
            return true;
        }
        return file2.mkdirs();
    }
}
