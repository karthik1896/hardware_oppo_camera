package com.oppo.camera.ui.menu.setting;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.LinearLayout;
import com.oppo.camera.R;
import com.oppo.camera.aps.config.CameraConfig;
import com.oppo.camera.e;
import com.oppo.camera.entry.b;
import com.oppo.camera.k;
import com.oppo.camera.ui.f;
import com.oppo.camera.ui.menu.BasicOptionItemList;
import com.oppo.camera.ui.menu.d;
import com.oppo.camera.ui.menu.g;
import com.oppo.camera.ui.menu.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CameraSettingMenuPanel extends LinearLayout implements com.oppo.camera.ui.inverse.a, i {

    /* renamed from: a  reason: collision with root package name */
    public boolean f4168a = false;

    /* renamed from: b  reason: collision with root package name */
    public boolean f4169b = true;
    public CopyOnWriteArrayList<CameraMenuOption> c = null;
    public f d = null;
    public k e = null;
    public Context f = null;
    public int g = 0;
    private final Object h = new Object();
    private int i = 0;
    private int j = 0;
    private boolean k = true;
    private boolean l = false;
    private boolean m = false;
    private boolean n = false;
    private int o = 0;
    private List<a> p = null;

    public void setPendingDrawerGuideAni(Runnable runnable) {
    }

    public CameraSettingMenuPanel(Context context) {
        super(context);
        this.f = context;
        this.i = this.f.getResources().getDimensionPixelSize(R.dimen.menu_panel_padding_left_right);
    }

    public CameraSettingMenuPanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f = context;
        this.i = this.f.getResources().getDimensionPixelSize(R.dimen.menu_panel_padding_left_right);
    }

    public void setCameraMenuLayout(boolean z) {
        e.a("CameraSettingMenuPanel", "setCameraMenuLayout(), " + this.f4169b + " => " + z);
        this.f4169b = z;
        if (this.f4169b) {
            j();
            requestLayout();
        }
    }

    public void setInitState(boolean z) {
        this.f4168a = z;
    }

    public void a(String str, String str2, String str3, int i2, int i3) {
        CameraMenuOption l2 = l(str);
        if (l2 != null) {
            l2.a(str2, str3, i2, i3);
        }
    }

    public void d(String str) {
        CameraMenuOption l2 = l(str);
        if (l2 != null) {
            l2.t();
        }
    }

    public void a(String str, String str2, String str3, String str4, int i2, int i3) {
        CameraMenuOption b2;
        BasicOptionItemList basicOptionItemList = null;
        int i4 = -1;
        try {
            h hVar = (h) l(str);
            if (hVar != null) {
                i4 = hVar.o(str3);
                basicOptionItemList = hVar.f4164b;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (basicOptionItemList != null && !basicOptionItemList.isShown() && (b2 = basicOptionItemList.b(i4)) != null) {
            b2.a(str2, str4, str3, i2, i3);
        }
    }

    public void a(String str, boolean z, int i2, int i3) {
        CameraMenuOption l2 = l(str);
        if (l2 != null) {
            l2.a(z, i2, i3);
        }
    }

    private CameraMenuOption l(String str) {
        if (str != null && !str.isEmpty()) {
            Iterator<CameraMenuOption> it = this.c.iterator();
            while (it.hasNext()) {
                CameraMenuOption next = it.next();
                if (str.equals(next.a())) {
                    return next;
                }
            }
        }
        return null;
    }

    private void j() {
        List<a> list = this.p;
        if (list != null && !list.isEmpty()) {
            synchronized (this.h) {
                e.a("CameraSettingMenuPanel", "executeOptions(), length: " + this.p.size());
                for (a next : this.p) {
                    if (next != null && 1 == next.f4172a) {
                        m(next.f4173b);
                    }
                }
                for (a next2 : this.p) {
                    if (next2 != null && next2.f4172a == 0) {
                        h(next2.f4173b);
                    }
                }
                for (a next3 : this.p) {
                    if (next3 != null) {
                        int i2 = next3.f4172a;
                        if (i2 == 2) {
                            a(next3.f4173b, next3.d);
                        } else if (i2 == 5) {
                            b(next3.f4173b, next3.e);
                        } else if (i2 == 6) {
                            a(next3.f4173b, next3.e);
                        }
                    }
                }
                for (a next4 : this.p) {
                    if (next4 != null) {
                        int i3 = next4.f4172a;
                        if (i3 == 3) {
                            b(next4.f4173b, next4.c);
                        } else if (i3 == 4) {
                            a(next4.f4173b, next4.c);
                        }
                    }
                }
                this.p.clear();
            }
        }
    }

    public void a(k kVar, f fVar, g gVar, int i2, boolean z) {
        e.a("CameraSettingMenuPanel", "initialize, sizeRatioType: " + i2);
        this.m = z;
        this.e = kVar;
        h();
        this.c = new CopyOnWriteArrayList<>();
        this.d = fVar;
        this.g = i2;
        List<String> menuPanelOptionList = CameraConfig.getMenuPanelOptionList();
        if (this.m) {
            this.i = this.f.getResources().getDimensionPixelSize(R.dimen.submenu_panel_padding_left_right);
        }
        if (menuPanelOptionList != null && menuPanelOptionList.size() > 0) {
            for (String next : menuPanelOptionList) {
                com.oppo.camera.ui.menu.a a2 = gVar.a(b.b(next, this.d.aw().y()));
                if (a2 != null) {
                    com.oppo.camera.ui.menu.a aVar = a2;
                    h hVar = new h(this.e, this.f, aVar, this, this.d, this.g, CameraConfig.getOptionKeyDefaultValue(next, getCameraId()), z);
                    hVar.b();
                    this.c.add(hVar);
                    hVar.a((ViewGroup) this);
                    hVar.F().setContentDescription(a2.getOptionTitle());
                }
            }
        }
    }

    public void a() {
        e.a("CameraSettingMenuPanel", "updateAfterCameraResume(), mMenuList: " + this.c);
        setCameraMenuLayout(true);
        CopyOnWriteArrayList<CameraMenuOption> copyOnWriteArrayList = this.c;
        if (copyOnWriteArrayList != null) {
            Iterator<CameraMenuOption> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                CameraMenuOption next = it.next();
                if (next != null) {
                    next.c();
                }
            }
        }
    }

    public void b() {
        e.a("CameraSettingMenuPanel", "updateImageIconShadow");
        CopyOnWriteArrayList<CameraMenuOption> copyOnWriteArrayList = this.c;
        if (copyOnWriteArrayList != null) {
            Iterator<CameraMenuOption> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                CameraMenuOption next = it.next();
                if (next != null) {
                    next.b(next.G());
                }
            }
        }
    }

    public void c() {
        e.a("CameraSettingMenuPanel", "updateAfterCameraPause");
        CopyOnWriteArrayList<CameraMenuOption> copyOnWriteArrayList = this.c;
        if (copyOnWriteArrayList != null) {
            Iterator<CameraMenuOption> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                CameraMenuOption next = it.next();
                if (next != null) {
                    next.d();
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        CopyOnWriteArrayList<CameraMenuOption> copyOnWriteArrayList;
        CameraMenuOption cameraMenuOption;
        int i6;
        int i7;
        if (this.f4168a && (copyOnWriteArrayList = this.c) != null && copyOnWriteArrayList.size() > 0 && this.f4169b) {
            int i8 = i4 - i2;
            int i9 = this.i;
            int i10 = i8 - (i9 * 2);
            int i11 = i5 - i3;
            float f2 = 0.0f;
            int i12 = 0;
            int i13 = 0;
            int i14 = 0;
            for (int i15 = 0; i15 < this.c.size(); i15++) {
                CameraMenuOption cameraMenuOption2 = this.c.get(i15);
                if (!cameraMenuOption2.g()) {
                    i13 += cameraMenuOption2.x();
                    i14++;
                }
            }
            if (i10 > i13 && i14 > 1) {
                f2 = ((float) (i10 - i13)) / ((float) (i14 - 1));
            }
            boolean z2 = 1 == getLayoutDirection();
            int i16 = i9;
            int i17 = 0;
            int i18 = 0;
            while (i17 < this.c.size()) {
                if (z2) {
                    int size = (this.c.size() - i17) - 1;
                    cameraMenuOption = (CameraMenuOption) (size >= 0 ? this.c.get(size) : this.c.get(i12));
                } else {
                    cameraMenuOption = this.c.get(i17);
                }
                if (cameraMenuOption == null || cameraMenuOption.C() == 8) {
                    i6 = i11;
                    i16 = i16;
                } else {
                    int x = cameraMenuOption.x();
                    int measuredHeight = getMeasuredHeight();
                    int i19 = (i11 - measuredHeight) / 2;
                    i6 = i11;
                    int E = cameraMenuOption.E();
                    int i20 = i16;
                    if (1 != cameraMenuOption.B()) {
                        if (i14 != 1) {
                            i7 = i20;
                        } else if (d(cameraMenuOption.a(), z2)) {
                            i7 = this.i;
                        } else {
                            i7 = e(cameraMenuOption.a(), z2) ? (this.i + i10) - x : (i8 - i13) / 2;
                        }
                        if (cameraMenuOption.F() != null) {
                            i18 = cameraMenuOption.F().getLeft();
                        }
                        if (!cameraMenuOption.z()) {
                            if (E == 0 || i7 == E) {
                                cameraMenuOption.a(i7, i19, i7 + x, measuredHeight + i19);
                            } else if (cameraMenuOption.C() != 0 || i18 == i7 || !cameraMenuOption.h()) {
                                cameraMenuOption.a(i7, cameraMenuOption.F().getTop(), cameraMenuOption.F().getWidth() + i7, cameraMenuOption.F().getBottom());
                            } else {
                                cameraMenuOption.a(i18, i7);
                            }
                        } else if (E != i7) {
                            if (cameraMenuOption.C() != 0 || i18 == i7 || !cameraMenuOption.h()) {
                                cameraMenuOption.a(i7, cameraMenuOption.F().getTop(), cameraMenuOption.F().getWidth() + i7, cameraMenuOption.F().getBottom());
                            } else {
                                cameraMenuOption.a(i18, i7);
                            }
                        }
                        if (!cameraMenuOption.h()) {
                            cameraMenuOption.a(true);
                        }
                        i16 = (int) (((float) i7) + ((float) x) + f2);
                    } else {
                        return;
                    }
                }
                i17++;
                i11 = i6;
                i12 = 0;
            }
        }
    }

    public boolean d() {
        CopyOnWriteArrayList<CameraMenuOption> copyOnWriteArrayList = this.c;
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.size() <= 0) {
            return false;
        }
        Iterator<CameraMenuOption> it = this.c.iterator();
        while (it.hasNext()) {
            CameraMenuOption next = it.next();
            if (next != null && next.e()) {
                return true;
            }
        }
        return false;
    }

    public void e() {
        CopyOnWriteArrayList<CameraMenuOption> copyOnWriteArrayList = this.c;
        if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() > 0) {
            Iterator<CameraMenuOption> it = this.c.iterator();
            while (it.hasNext()) {
                CameraMenuOption next = it.next();
                if (next != null && !next.g()) {
                    if (this.d.g("pref_camera_videoflashmode_key") && "pref_camera_videoflashmode_key".equals(next.a())) {
                        next.d(0);
                    } else if (!this.d.g("pref_camera_torch_mode_key") || !"pref_camera_torch_mode_key".equals(next.a())) {
                        if (1 == next.B()) {
                            next.a(4);
                        } else {
                            if (next.z()) {
                                next.A();
                            }
                            next.d(4);
                        }
                        next.a(false, false);
                        if (3 == next.B()) {
                            next.c(0);
                        }
                    } else {
                        next.d(0);
                    }
                }
            }
        }
    }

    public void f() {
        Iterator<CameraMenuOption> it = this.c.iterator();
        while (it.hasNext()) {
            CameraMenuOption next = it.next();
            if (next != null) {
                if (next.g()) {
                    next.a(8);
                } else {
                    next.d(0);
                }
            }
        }
    }

    public void setAlpha(float f2) {
        super.setAlpha(f2);
        e.a("CameraSettingMenuPanel", "setAlpha, alpha : " + f2);
    }

    public void setVisibility(int i2) {
        CopyOnWriteArrayList<CameraMenuOption> copyOnWriteArrayList;
        super.setVisibility(i2);
        e.a("CameraSettingMenuPanel", "setVisibility, visibility : " + i2);
        if (i2 == 0 && (copyOnWriteArrayList = this.c) != null) {
            Iterator<CameraMenuOption> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                CameraMenuOption next = it.next();
                if (next != null) {
                    if (next.g()) {
                        next.a(8);
                    } else {
                        next.d(0);
                    }
                }
            }
        }
        if (i2 != 0 && this.c != null && com.oppo.camera.ui.menu.f.a()) {
            Iterator<CameraMenuOption> it2 = this.c.iterator();
            while (it2.hasNext()) {
                CameraMenuOption next2 = it2.next();
                if (next2 != null) {
                    next2.n();
                }
            }
        }
    }

    public void a(boolean z, boolean z2) {
        this.k = z;
        this.l = z2;
        CopyOnWriteArrayList<CameraMenuOption> copyOnWriteArrayList = this.c;
        if (copyOnWriteArrayList != null) {
            Iterator<CameraMenuOption> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                CameraMenuOption next = it.next();
                if (next != null && (!z || !next.g())) {
                    next.a(z, z2);
                }
            }
        }
    }

    public boolean e(String str) {
        CopyOnWriteArrayList<CameraMenuOption> copyOnWriteArrayList;
        f fVar = this.d;
        if (fVar == null) {
            return false;
        }
        String b2 = b.b(str, fVar.aw().y());
        if (TextUtils.isEmpty(b2) || (copyOnWriteArrayList = this.c) == null) {
            return false;
        }
        Iterator<CameraMenuOption> it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            CameraMenuOption next = it.next();
            if (next != null && next.a().equals(b2)) {
                return next.q();
            }
        }
        return false;
    }

    public void a(String str, String str2) {
        CopyOnWriteArrayList<CameraMenuOption> copyOnWriteArrayList;
        if (TextUtils.isEmpty(str) || (copyOnWriteArrayList = this.c) == null) {
            return;
        }
        if (this.f4169b) {
            Iterator<CameraMenuOption> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                CameraMenuOption next = it.next();
                if (next != null && next.a(str, CameraConfig.getOptionKeyDefaultValue(b.c(next.a()), getCameraId()), str2)) {
                    return;
                }
            }
            return;
        }
        if (this.p == null) {
            this.p = new ArrayList();
        }
        synchronized (this.h) {
            a d2 = d(str, 4);
            if (d2 == null) {
                d2 = d(str, 3);
            }
            if (d2 == null) {
                d2 = new a(this, (AnonymousClass1) null);
            } else {
                this.p.remove(d2);
            }
            d2.f4173b = str;
            d2.f4172a = 4;
            d2.c = str2;
            this.p.add(d2);
        }
    }

    public void b(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            f fVar = this.d;
            if (fVar == null || fVar.a(str)) {
                CopyOnWriteArrayList<CameraMenuOption> copyOnWriteArrayList = this.c;
                if (copyOnWriteArrayList == null) {
                    return;
                }
                if (this.f4169b) {
                    Iterator<CameraMenuOption> it = copyOnWriteArrayList.iterator();
                    while (it.hasNext()) {
                        CameraMenuOption next = it.next();
                        if (next != null && !next.g() && next.b(str, CameraConfig.getOptionKeyDefaultValue(b.c(next.a()), getCameraId()), str2)) {
                            return;
                        }
                    }
                    return;
                }
                if (this.p == null) {
                    this.p = new ArrayList();
                }
                synchronized (this.h) {
                    a d2 = d(str, 3);
                    if (d2 == null) {
                        d2 = d(str, 4);
                    }
                    if (d2 == null) {
                        d2 = new a(this, (AnonymousClass1) null);
                    } else {
                        this.p.remove(d2);
                    }
                    d2.f4173b = str;
                    d2.f4172a = 3;
                    d2.c = str2;
                    this.p.add(d2);
                }
                return;
            }
            e.a("CameraSettingMenuPanel", "enableCameraSettingMenuOption(), this cap mod can not enable key : " + str);
        }
    }

    public void a(String str, String... strArr) {
        if (str != null && !str.equals("") && strArr != null && strArr.length > 0 && this.c != null) {
            if (this.f4169b || this.p == null) {
                Iterator<CameraMenuOption> it = this.c.iterator();
                while (it.hasNext()) {
                    CameraMenuOption next = it.next();
                    if (next != null && next.a(str, strArr)) {
                        return;
                    }
                }
                return;
            }
            synchronized (this.h) {
                a aVar = new a(this, (AnonymousClass1) null);
                aVar.f4173b = str;
                aVar.e = strArr;
                aVar.f4172a = 6;
                this.p.add(aVar);
            }
        }
    }

    public void a(String str, String str2, String str3) {
        CopyOnWriteArrayList<CameraMenuOption> copyOnWriteArrayList;
        if (str != null && !str.equals("") && str2 != null && !str2.equals("") && (copyOnWriteArrayList = this.c) != null) {
            Iterator<CameraMenuOption> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                CameraMenuOption next = it.next();
                if ((next instanceof h) && str.equals(next.a())) {
                    List<d> W = ((h) next).W();
                    if (W != null) {
                        for (int i2 = 0; i2 < W.size(); i2++) {
                            if (str2.equals(W.get(i2).b())) {
                                W.get(i2).c(str3);
                                return;
                            }
                        }
                        return;
                    }
                    return;
                }
            }
        }
    }

    public void b(String str, String... strArr) {
        if (str != null && !str.equals("") && strArr != null && strArr.length > 0 && this.c != null) {
            if (this.f4169b || this.p == null) {
                Iterator<CameraMenuOption> it = this.c.iterator();
                while (it.hasNext()) {
                    CameraMenuOption next = it.next();
                    if (next != null && next.b(str, strArr)) {
                        return;
                    }
                }
                return;
            }
            synchronized (this.h) {
                a aVar = new a(this, (AnonymousClass1) null);
                aVar.f4173b = str;
                aVar.e = strArr;
                aVar.f4172a = 5;
                this.p.add(aVar);
            }
        }
    }

    public boolean a(CameraMenuOption cameraMenuOption, int i2) {
        Iterator<CameraMenuOption> it = this.c.iterator();
        while (it.hasNext()) {
            CameraMenuOption next = it.next();
            if (next != null && next.S() == i2 && next.C() == 0 && !cameraMenuOption.a().equals(next.a())) {
                return true;
            }
        }
        return false;
    }

    public void f(String str) {
        if (!TextUtils.isEmpty(str)) {
            f fVar = this.d;
            if (fVar == null || fVar.b(str)) {
                CopyOnWriteArrayList<CameraMenuOption> copyOnWriteArrayList = this.c;
                if (copyOnWriteArrayList == null) {
                    return;
                }
                if (this.f4169b) {
                    Iterator<CameraMenuOption> it = copyOnWriteArrayList.iterator();
                    while (it.hasNext()) {
                        if (a(str, it.next())) {
                            requestLayout();
                        }
                    }
                    return;
                }
                if (this.p == null) {
                    this.p = new ArrayList();
                }
                synchronized (this.h) {
                    a d2 = d(str, 1);
                    if (d2 == null) {
                        d2 = d(str, 0);
                    }
                    if (d2 == null) {
                        a aVar = new a(this, (AnonymousClass1) null);
                        aVar.f4173b = str;
                        aVar.f4172a = 1;
                        this.p.add(aVar);
                    } else if (d2.f4172a != 1) {
                        this.p.remove(d2);
                        d2.f4173b = str;
                        d2.f4172a = 1;
                        this.p.add(d2);
                    }
                }
                return;
            }
            e.a("CameraSettingMenuPanel", "addContainMenuOption, the current mode can not add option: " + str);
        }
    }

    private void m(String str) {
        if (!TextUtils.isEmpty(str)) {
            f fVar = this.d;
            if (fVar == null || fVar.b(str)) {
                CopyOnWriteArrayList<CameraMenuOption> copyOnWriteArrayList = this.c;
                if (copyOnWriteArrayList != null && this.f4169b) {
                    Iterator<CameraMenuOption> it = copyOnWriteArrayList.iterator();
                    while (it.hasNext()) {
                        a(str, it.next());
                    }
                    return;
                }
                return;
            }
            e.a("CameraSettingMenuPanel", "executeAddContainMenuOption, the current mode can not add option: " + str);
        }
    }

    private boolean a(String str, CameraMenuOption cameraMenuOption) {
        if (cameraMenuOption == null) {
            return false;
        }
        if (cameraMenuOption.a(str, CameraConfig.getOptionKeyDefaultValue(b.c(cameraMenuOption.a()), getCameraId()), getVisibility(), !str.equals(cameraMenuOption.a()) || 1 != cameraMenuOption.S() || !a(cameraMenuOption, 1))) {
            return true;
        }
        return false;
    }

    public void g(String str) {
        CopyOnWriteArrayList<CameraMenuOption> copyOnWriteArrayList;
        if (TextUtils.isEmpty(str) || (copyOnWriteArrayList = this.c) == null) {
            return;
        }
        if (this.f4169b) {
            Iterator<CameraMenuOption> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                CameraMenuOption next = it.next();
                if (next != null) {
                    if (next.a(str, this.f4168a && !this.m)) {
                        requestLayout();
                        return;
                    }
                }
            }
            return;
        }
        if (this.p == null) {
            this.p = new ArrayList();
        }
        synchronized (this.h) {
            a d2 = d(str, 0);
            if (d2 == null) {
                d2 = d(str, 1);
            }
            if (d2 == null) {
                a aVar = new a(this, (AnonymousClass1) null);
                aVar.f4173b = str;
                aVar.f4172a = 0;
                this.p.add(aVar);
            } else if (d2.f4172a != 0) {
                this.p.remove(d2);
                d2.f4173b = str;
                d2.f4172a = 0;
                this.p.add(d2);
            }
        }
    }

    public void h(String str) {
        CopyOnWriteArrayList<CameraMenuOption> copyOnWriteArrayList;
        if (!TextUtils.isEmpty(str) && (copyOnWriteArrayList = this.c) != null && this.f4169b) {
            Iterator<CameraMenuOption> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                CameraMenuOption next = it.next();
                if (next != null) {
                    if (next.a(str, this.f4168a && !this.m)) {
                        return;
                    }
                }
            }
        }
    }

    private a d(String str, int i2) {
        List<a> list;
        if (str == null || str.equals("") || (list = this.p) == null || list.isEmpty()) {
            return null;
        }
        for (a next : this.p) {
            if (str.equals(next.f4173b) && next.f4172a == i2) {
                return next;
            }
        }
        return null;
    }

    public void a(String str, int i2) {
        CopyOnWriteArrayList<CameraMenuOption> copyOnWriteArrayList;
        if (!TextUtils.isEmpty(str) && (copyOnWriteArrayList = this.c) != null) {
            Iterator<CameraMenuOption> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                CameraMenuOption next = it.next();
                if (next != null && next.a(str, i2)) {
                    return;
                }
            }
        }
    }

    public void a(String str, List<String> list) {
        if (!TextUtils.isEmpty(str) && list != null) {
            f fVar = this.d;
            if (fVar == null || fVar.e(str)) {
                f fVar2 = this.d;
                if (fVar2 != null) {
                    str = b.b(str, fVar2.aw().y());
                }
                CopyOnWriteArrayList<CameraMenuOption> copyOnWriteArrayList = this.c;
                if (copyOnWriteArrayList == null) {
                    return;
                }
                if (this.f4169b) {
                    Iterator<CameraMenuOption> it = copyOnWriteArrayList.iterator();
                    while (it.hasNext()) {
                        CameraMenuOption next = it.next();
                        if (next != null && next.a(str, CameraConfig.getOptionKeyDefaultValue(b.c(next.a()), getCameraId()), list)) {
                            return;
                        }
                    }
                    return;
                }
                if (this.p == null) {
                    this.p = new ArrayList();
                }
                synchronized (this.h) {
                    a d2 = d(str, 2);
                    if (d2 == null) {
                        d2 = new a(this, (AnonymousClass1) null);
                    } else {
                        this.p.remove(d2);
                    }
                    d2.f4173b = str;
                    d2.f4172a = 2;
                    d2.d = list;
                    this.p.add(d2);
                }
            }
        }
    }

    public void i(String str) {
        CopyOnWriteArrayList<CameraMenuOption> copyOnWriteArrayList;
        if (!TextUtils.isEmpty(str) && (copyOnWriteArrayList = this.c) != null) {
            Iterator<CameraMenuOption> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                CameraMenuOption next = it.next();
                if (next != null && str.equals(next.a())) {
                    next.e(CameraConfig.getOptionKeyDefaultValue(b.c(next.a()), getCameraId()));
                    return;
                }
            }
        }
    }

    public void b(String str, int i2) {
        CopyOnWriteArrayList<CameraMenuOption> copyOnWriteArrayList;
        if (!TextUtils.isEmpty(str) && (copyOnWriteArrayList = this.c) != null) {
            Iterator<CameraMenuOption> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                CameraMenuOption next = it.next();
                if (next != null && str.equals(next.a()) && b(next, i2)) {
                    a(next);
                    return;
                }
            }
        }
    }

    private boolean b(CameraMenuOption cameraMenuOption, int i2) {
        if (cameraMenuOption.T() == 0 && i2 == 0) {
            return true;
        }
        return cameraMenuOption.T() != 0 && 8 == i2;
    }

    private void a(CameraMenuOption cameraMenuOption) {
        Drawable I = cameraMenuOption.I();
        View F = cameraMenuOption.F();
        if (I == null || F == null) {
            e.b("CameraSettingMenuPanel", "showCameraSubSettingMenuWithAnimation view: " + F + "drawable: " + I);
        } else if (I instanceof StateListDrawable) {
            StateListDrawable stateListDrawable = (StateListDrawable) I;
            Drawable stateDrawable = stateListDrawable.getStateDrawable(stateListDrawable.findStateDrawableIndex(F.getDrawableState()));
            if (stateDrawable instanceof Animatable) {
                ((Animatable) stateDrawable).start();
            }
        } else if (I instanceof Animatable) {
            ((Animatable) I).start();
        }
    }

    public void b(String str, boolean z) {
        CopyOnWriteArrayList<CameraMenuOption> copyOnWriteArrayList;
        if (!TextUtils.isEmpty(str) && (copyOnWriteArrayList = this.c) != null) {
            Iterator<CameraMenuOption> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                CameraMenuOption next = it.next();
                if (next != null && str.equals(next.a())) {
                    next.c(z);
                    return;
                }
            }
        }
    }

    public void g() {
        CopyOnWriteArrayList<CameraMenuOption> copyOnWriteArrayList;
        if (this.f4169b && (copyOnWriteArrayList = this.c) != null) {
            Iterator<CameraMenuOption> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                CameraMenuOption next = it.next();
                if (next != null) {
                    next.e(CameraConfig.getOptionKeyDefaultValue(b.c(next.a()), getCameraId()));
                }
            }
        }
    }

    public void b(boolean z, boolean z2) {
        CopyOnWriteArrayList<CameraMenuOption> copyOnWriteArrayList = this.c;
        if (copyOnWriteArrayList != null) {
            Iterator<CameraMenuOption> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                CameraMenuOption next = it.next();
                if (next != null) {
                    next.b(z, z2);
                }
            }
        }
    }

    /* renamed from: com.oppo.camera.ui.menu.setting.CameraSettingMenuPanel$1  reason: invalid class name */
    class AnonymousClass1 implements Animation.AnimationListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ boolean f4170a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ CameraMenuOption f4171b;

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationStart(Animation animation) {
        }

        public void onAnimationEnd(Animation animation) {
            CameraMenuOption cameraMenuOption;
            if (this.f4170a && (cameraMenuOption = this.f4171b) != null) {
                cameraMenuOption.b(cameraMenuOption.u());
            }
        }
    }

    public void a(float f2) {
        CopyOnWriteArrayList<CameraMenuOption> copyOnWriteArrayList = this.c;
        if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() > 0) {
            Iterator<CameraMenuOption> it = this.c.iterator();
            while (it.hasNext()) {
                CameraMenuOption next = it.next();
                if (next != null && !next.g()) {
                    next.a(f2);
                }
            }
        }
    }

    public void h() {
        CopyOnWriteArrayList<CameraMenuOption> copyOnWriteArrayList = this.c;
        if (copyOnWriteArrayList != null) {
            Iterator<CameraMenuOption> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                it.next().l();
            }
            this.c.clear();
            this.c = null;
        }
    }

    public void i() {
        clearAnimation();
        h();
        removeAllViews();
        if (this.p != null) {
            synchronized (this.h) {
                this.p.clear();
            }
            this.p = null;
        }
        this.f = null;
        this.d = null;
    }

    public SharedPreferences getSharedPreferences() {
        return this.e;
    }

    public int getCameraId() {
        f fVar = this.d;
        if (fVar != null) {
            return fVar.t();
        }
        return 0;
    }

    public boolean getMenuPanelEnable() {
        return this.k;
    }

    public boolean getMenuPanelAshed() {
        return this.l;
    }

    public int getOrientation() {
        return this.j;
    }

    public void setOrientation(int i2) {
        this.j = i2;
        CopyOnWriteArrayList<CameraMenuOption> copyOnWriteArrayList = this.c;
        if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() > 0) {
            Iterator<CameraMenuOption> it = this.c.iterator();
            while (it.hasNext()) {
                it.next().a(i2, true);
            }
        }
    }

    public int getUnremovedMenuNum() {
        CopyOnWriteArrayList<CameraMenuOption> copyOnWriteArrayList = this.c;
        int i2 = 0;
        if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() > 0) {
            Iterator<CameraMenuOption> it = this.c.iterator();
            while (it.hasNext()) {
                CameraMenuOption next = it.next();
                if (next != null && !next.g()) {
                    i2++;
                }
            }
        }
        return i2;
    }

    public CopyOnWriteArrayList<CameraMenuOption> getMenuList() {
        return this.c;
    }

    public boolean a(String str, boolean z, boolean z2) {
        f fVar = this.d;
        if (fVar != null) {
            return fVar.a(str, z, z2, true);
        }
        return true;
    }

    public boolean a(String str, boolean z) {
        f fVar = this.d;
        if (fVar != null) {
            return fVar.a(str, z);
        }
        return false;
    }

    public String a(String str, int i2, int i3) {
        f fVar = this.d;
        if (fVar != null) {
            return fVar.a(str, i2, i3);
        }
        return null;
    }

    public void b(String str, int i2, int i3) {
        f fVar = this.d;
        if (fVar != null) {
            fVar.b(str, i2, i3);
        }
    }

    public boolean a(String str) {
        f fVar = this.d;
        if (fVar != null) {
            return fVar.b(str);
        }
        return false;
    }

    public void b(String str) {
        f fVar = this.d;
        if (fVar != null) {
            fVar.j(str);
        }
    }

    public void c(String str) {
        f fVar = this.d;
        if (fVar != null) {
            fVar.k(str);
        }
    }

    private boolean d(String str, boolean z) {
        if (z) {
            return k(str);
        }
        return j(str);
    }

    private boolean e(String str, boolean z) {
        if (z) {
            return j(str);
        }
        return k(str);
    }

    public boolean j(String str) {
        return "pref_camera_flashmode_key".equals(str) || "pref_camera_videoflashmode_key".equals(str) || "pref_camera_torch_mode_key".equals(str);
    }

    public boolean k(String str) {
        String c2 = b.c(str);
        return "pref_setting_key".equals(c2) || "pref_subsetting_key".equals(c2);
    }

    public void setSizeRatioType(int i2) {
        this.g = i2;
        CopyOnWriteArrayList<CameraMenuOption> copyOnWriteArrayList = this.c;
        if (copyOnWriteArrayList != null) {
            Iterator<CameraMenuOption> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                CameraMenuOption next = it.next();
                if (next != null) {
                    next.e(this.g);
                }
            }
        }
    }

    public void b(String str, boolean z, boolean z2) {
        String b2 = b.b(str, this.d.aw().y());
        CopyOnWriteArrayList<CameraMenuOption> copyOnWriteArrayList = this.c;
        if (copyOnWriteArrayList != null) {
            Iterator<CameraMenuOption> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                CameraMenuOption next = it.next();
                if (next != null && b2.equals(next.a())) {
                    if (z2 || z != next.T()) {
                        next.g(z ? 1 : 0);
                        next.b(next.e(z), next.K());
                    }
                }
            }
        }
    }

    public void c(String str, int i2) {
        String b2 = b.b(str, this.d.aw().y());
        CopyOnWriteArrayList<CameraMenuOption> copyOnWriteArrayList = this.c;
        if (copyOnWriteArrayList != null) {
            Iterator<CameraMenuOption> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                CameraMenuOption next = it.next();
                if (!(next == null || !b2.equals(next.a()) || i2 == next.T())) {
                    next.g(i2);
                }
            }
        }
    }

    public void setShadowOn(boolean z) {
        CopyOnWriteArrayList<CameraMenuOption> copyOnWriteArrayList = this.c;
        if (copyOnWriteArrayList != null) {
            Iterator<CameraMenuOption> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                it.next().d(z);
            }
        }
    }

    public void setInverseColor(boolean z) {
        this.n = z;
        setBackgroundColor(this.o);
        invalidate();
    }

    public void setBackgroundColor(int i2) {
        this.o = i2;
        if (this.n) {
            i2 = 0;
        }
        super.setBackgroundColor(i2);
    }

    public void c(String str, boolean z) {
        CopyOnWriteArrayList<CameraMenuOption> copyOnWriteArrayList = this.c;
        if (copyOnWriteArrayList != null && str != null) {
            Iterator<CameraMenuOption> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                CameraMenuOption next = it.next();
                if (str.equals(next.a())) {
                    ((h) next.F()).setStateSecond(z);
                }
            }
        }
    }

    private class a {

        /* renamed from: a  reason: collision with root package name */
        public int f4172a;

        /* renamed from: b  reason: collision with root package name */
        public String f4173b;
        public String c;
        public List<String> d;
        public String[] e;

        private a() {
            this.f4172a = -1;
            this.c = null;
            this.d = null;
            this.e = null;
        }

        /* synthetic */ a(CameraSettingMenuPanel cameraSettingMenuPanel, AnonymousClass1 r2) {
            this();
        }
    }
}
