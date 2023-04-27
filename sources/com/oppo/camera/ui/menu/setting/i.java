package com.oppo.camera.ui.menu.setting;

import android.content.SharedPreferences;

/* compiled from: CameraMenuOptionListener */
public interface i {
    String a(String str, int i, int i2);

    boolean a(String str);

    boolean a(String str, boolean z);

    boolean a(String str, boolean z, boolean z2);

    void b(String str);

    void b(String str, int i, int i2);

    void c(String str);

    boolean getMenuPanelAshed();

    boolean getMenuPanelEnable();

    int getOrientation();

    SharedPreferences getSharedPreferences();
}
