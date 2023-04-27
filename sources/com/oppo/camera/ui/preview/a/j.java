package com.oppo.camera.ui.preview.a;

import android.content.Context;
import java.io.File;
import java.io.IOException;

/* compiled from: ImageBeautyTools */
public class j {

    /* renamed from: a  reason: collision with root package name */
    private static File f4394a;

    public static int a(Context context) {
        if (f4394a == null) {
            f4394a = new File(context.getFilesDir() + File.separator + "register.info");
        }
        return f4394a.exists() ? 1 : 0;
    }

    public static boolean b(Context context) {
        if (f4394a == null) {
            f4394a = new File(context.getFilesDir() + File.separator + "register.info");
        }
        if (f4394a.exists()) {
            return f4394a.delete();
        }
        return true;
    }

    public static boolean c(Context context) {
        if (f4394a == null) {
            f4394a = new File(context.getFilesDir() + File.separator + "register.info");
        }
        if (f4394a.exists()) {
            return true;
        }
        try {
            return f4394a.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
