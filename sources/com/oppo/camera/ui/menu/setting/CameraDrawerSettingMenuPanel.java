package com.oppo.camera.ui.menu.setting;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.oppo.camera.R;
import com.oppo.camera.aps.config.CameraConfig;
import com.oppo.camera.entry.b;
import com.oppo.camera.k;
import com.oppo.camera.ui.f;
import com.oppo.camera.ui.inverse.c;
import com.oppo.camera.ui.menu.a;
import com.oppo.camera.ui.menu.g;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CameraDrawerSettingMenuPanel extends CameraSettingMenuPanel {
    /* access modifiers changed from: private */
    public boolean h = false;

    public CameraDrawerSettingMenuPanel(Context context) {
        super(context);
    }

    public CameraDrawerSettingMenuPanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void a(k kVar, f fVar, g gVar, int i, boolean z) {
        this.e = kVar;
        h();
        this.c = new CopyOnWriteArrayList();
        this.d = fVar;
        this.g = i;
        setMotionEventSplittingEnabled(false);
        List<String> menuPanelOptionList = CameraConfig.getMenuPanelOptionList();
        if (menuPanelOptionList != null && menuPanelOptionList.size() > 0) {
            for (String next : menuPanelOptionList) {
                a a2 = gVar.a(b.b(next, this.d.aw().y()));
                if (a2 != null) {
                    a aVar = a2;
                    g gVar2 = new g(this.e, this.f, aVar, this, this.d, this.g, CameraConfig.getOptionKeyDefaultValue(next, getCameraId()));
                    c.INS.registerInverse(this.f, gVar2);
                    gVar2.b();
                    gVar2.a(8);
                    this.c.add(gVar2);
                    gVar2.a((ViewGroup) this);
                    gVar2.F().setContentDescription(a2.getOptionTitle());
                }
            }
        }
        this.h = true;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.c != null && this.h && this.c.size() > 0 && this.f4169b) {
            int i5 = i3 - i;
            int dimension = (int) getResources().getDimension(R.dimen.drawer_layout_space_top);
            for (int i6 = 0; i6 < this.c.size(); i6++) {
                CameraMenuOption cameraMenuOption = (CameraMenuOption) this.c.get(i6);
                if (!(cameraMenuOption == null || 8 == cameraMenuOption.C())) {
                    int y = cameraMenuOption.y() + dimension;
                    cameraMenuOption.a(0, dimension, i5, y);
                    dimension = (int) (((float) y) + getResources().getDimension(R.dimen.drawer_layout_space));
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i2);
        if (this.c != null && this.c.size() > 0) {
            int i3 = 0;
            for (int i4 = 0; i4 < this.c.size(); i4++) {
                CameraMenuOption cameraMenuOption = (CameraMenuOption) this.c.get(i4);
                if (!(cameraMenuOption == null || 8 == cameraMenuOption.C())) {
                    i3 = (int) (((float) (i3 + cameraMenuOption.y())) + getResources().getDimension(R.dimen.drawer_layout_space));
                }
            }
            size = i3 != 0 ? (int) (((float) i3) + getResources().getDimension(R.dimen.drawer_layout_space_bottom)) : i3;
        }
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(size, 1073741824));
    }

    public void setPendingDrawerGuideAni(final Runnable runnable) {
        addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
            public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                if (CameraDrawerSettingMenuPanel.this.h && i3 - i > 0 && i4 - i2 > 0) {
                    runnable.run();
                    CameraDrawerSettingMenuPanel.this.removeOnLayoutChangeListener(this);
                }
            }
        });
    }
}
