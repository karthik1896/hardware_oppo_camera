package com.google.android.material.internal;

import android.content.Context;
import androidx.appcompat.view.menu.h;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.view.menu.s;

public class NavigationSubMenu extends s {
    public NavigationSubMenu(Context context, NavigationMenu navigationMenu, j jVar) {
        super(context, navigationMenu, jVar);
    }

    public void onItemsChanged(boolean z) {
        super.onItemsChanged(z);
        ((h) getParentMenu()).onItemsChanged(z);
    }
}
