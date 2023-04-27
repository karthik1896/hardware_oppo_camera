package com.oppo.camera.ui.preview.a;

import android.content.Context;
import com.oppo.camera.aps.config.CameraConfig;
import com.oppo.camera.aps.config.ConfigDataBase;
import com.oppo.camera.ui.preview.a.a.a;
import com.oppo.camera.ui.preview.a.b.b;

/* compiled from: TexturePreviewFactory */
public class t {
    public static s a(Context context, int i) {
        if (i != 1) {
            if (i == 2) {
                return new h(context);
            }
            if (i == 4) {
                return new f(context);
            }
            if (i == 8) {
                return new q(context);
            }
            if (i == 16) {
                return new c(context);
            }
            if (i == 32) {
                return new w(context);
            }
            if (i == 64) {
                return new r(context);
            }
            if (i == 128) {
                return new b(context);
            }
            if (i == 256) {
                return new x(context);
            }
            if (i == 512) {
                return new v(context);
            }
            if (i != 1024) {
                return null;
            }
            return new a(context);
        } else if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_ARCSOFT_SINGLE_BOKEH_SUPPORT)) {
            return new d(context);
        } else {
            return new e(context);
        }
    }
}
