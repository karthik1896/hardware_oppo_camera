package com.oppo.camera.ui.menu.setting;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import com.oppo.camera.R;
import com.oppo.camera.k;
import com.oppo.camera.ui.f;
import com.oppo.camera.ui.h;
import com.oppo.camera.ui.menu.BasicOptionItemList;
import com.oppo.camera.ui.menu.a;
import com.oppo.camera.ui.menu.c;
import com.oppo.camera.ui.menu.d;
import com.oppo.camera.ui.menu.e;
import com.oppo.camera.util.Util;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CameraMenuOption implements BasicOptionItemList.OptionItemListListener, e {

    /* renamed from: a  reason: collision with root package name */
    public k f4163a = null;

    /* renamed from: b  reason: collision with root package name */
    public BasicOptionItemList f4164b = null;
    public boolean c = false;
    protected boolean d = false;
    protected boolean e = false;
    protected boolean f = true;
    protected boolean g = false;
    protected boolean h = false;
    protected int i = 0;
    protected Context j = null;
    protected i k = null;
    protected OnItemClickListener l = null;
    protected f m = null;
    protected int n = 0;
    /* access modifiers changed from: private */
    public boolean o = false;
    private LayoutTranslationAnimation p = null;
    private ViewGroup q = null;
    private int r = 0;
    private int s = 0;
    private int t = 0;
    private int u = 0;
    private String v = null;
    private ArrayList<d> w = null;
    private boolean x = true;
    private a y = null;

    public interface OnItemClickListener {
        void a(CameraMenuOption cameraMenuOption);
    }

    public View F() {
        return null;
    }

    public boolean G() {
        return false;
    }

    public void a(Drawable drawable, boolean z) {
    }

    public void a(View view) {
    }

    public void a(String str, String str2, int i2, int i3) {
    }

    public void a(String str, String str2, String str3, int i2, int i3) {
    }

    public void a(boolean z, int i2, int i3) {
    }

    public void b(Drawable drawable, boolean z) {
    }

    public void b(String str) {
    }

    public void b(boolean z) {
    }

    public void c(boolean z) {
    }

    public void d(boolean z) {
    }

    public boolean e() {
        return false;
    }

    public void h(String str) {
    }

    /* access modifiers changed from: protected */
    public void r() {
    }

    /* access modifiers changed from: protected */
    public void s() {
    }

    public void t() {
    }

    public int x() {
        return 0;
    }

    public int y() {
        return 0;
    }

    public CameraMenuOption(k kVar, Context context, a aVar, i iVar, f fVar, int i2, String str) {
        this.j = context;
        this.f4163a = kVar;
        this.k = iVar;
        if (aVar != null) {
            this.y = aVar;
            if (!h.a(this.y)) {
                com.oppo.camera.e.a("CameraMenuOption", "CameraMenuOption, getOptionKey: " + aVar.getOptionKey());
                return;
            }
            this.w = new ArrayList<>(this.y.getOptionItems());
            m(n(str));
        }
        this.t = this.j.getResources().getDimensionPixelSize(R.dimen.menu_panel_padding_left_right);
        this.u = this.j.getResources().getDimensionPixelSize(R.dimen.menu_rec_mode_padding_left);
        this.m = fVar;
        this.i = i2;
    }

    public void b() {
        o();
        p();
        c();
        boolean z = this.x;
        this.d = !z;
        a(z, this.d);
    }

    public void c() {
        if (!this.c) {
            com.oppo.camera.ui.menu.f.a((e) this);
        }
    }

    public void d() {
        BasicOptionItemList basicOptionItemList = this.f4164b;
        if (basicOptionItemList != null) {
            basicOptionItemList.f();
        }
        if (z()) {
            A();
        }
        b(true, true);
        com.oppo.camera.ui.menu.f.b((e) this);
    }

    public void a(int i2) {
        if (this.e || O() <= 0) {
            i2 = 8;
        }
        if (F() != null && C() != i2) {
            F().setVisibility(i2);
        }
    }

    public void a(boolean z, boolean z2) {
        float f2 = 0.5f;
        if (this.d || !p()) {
            if (F() != null) {
                F().setEnabled(false);
                F().setAlpha(0.5f);
                if (F() instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) F();
                    for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                        viewGroup.getChildAt(i2).setEnabled(false);
                    }
                }
            }
            this.x = false;
            BasicOptionItemList basicOptionItemList = this.f4164b;
            if (basicOptionItemList != null) {
                basicOptionItemList.a(false, true);
                return;
            }
            return;
        }
        if (F() != null) {
            F().setEnabled(z);
            View F = F();
            if (!z2 || z) {
                f2 = 1.0f;
            }
            F.setAlpha(f2);
            if (F() instanceof ViewGroup) {
                ViewGroup viewGroup2 = (ViewGroup) F();
                for (int i3 = 0; i3 < viewGroup2.getChildCount(); i3++) {
                    viewGroup2.getChildAt(i3).setEnabled(z);
                }
            }
        }
        this.x = z;
        BasicOptionItemList basicOptionItemList2 = this.f4164b;
        if (basicOptionItemList2 != null) {
            basicOptionItemList2.a(z, z2);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0058, code lost:
        if (r4.k.a(a(), true) != false) goto L_0x005c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(com.oppo.camera.ui.menu.setting.CameraMenuOption r5, int r6) {
        /*
            r4 = this;
            com.oppo.camera.ui.menu.setting.i r5 = r4.k
            if (r5 == 0) goto L_0x0094
            java.lang.String r0 = r4.a()
            r1 = 0
            r2 = 1
            boolean r5 = r5.a((java.lang.String) r0, (boolean) r2, (boolean) r1)
            if (r5 != 0) goto L_0x0030
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "onItemSelected, key: "
            r5.append(r6)
            java.lang.String r6 = r4.a()
            r5.append(r6)
            java.lang.String r6 = ", return"
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            java.lang.String r6 = "CameraMenuOption"
            com.oppo.camera.e.a(r6, r5)
            return
        L_0x0030:
            com.oppo.camera.ui.menu.setting.i r5 = r4.k
            java.lang.String r0 = r4.a()
            int r3 = r4.n
            java.lang.String r5 = r5.a((java.lang.String) r0, (int) r3, (int) r6)
            if (r5 == 0) goto L_0x0044
            java.util.ArrayList<com.oppo.camera.ui.menu.d> r6 = r4.w
            int r6 = com.oppo.camera.ui.h.a((java.lang.String) r5, (java.util.ArrayList<com.oppo.camera.ui.menu.d>) r6)
        L_0x0044:
            int r5 = r4.n
            if (r5 == r6) goto L_0x005b
            r4.g((int) r6)
            r4.o()
            com.oppo.camera.ui.menu.setting.i r5 = r4.k
            java.lang.String r0 = r4.a()
            boolean r5 = r5.a(r0, r2)
            if (r5 == 0) goto L_0x005b
            goto L_0x005c
        L_0x005b:
            r1 = r2
        L_0x005c:
            com.oppo.camera.ui.menu.BasicOptionItemList r5 = r4.f4164b
            if (r5 == 0) goto L_0x0070
            com.oppo.camera.ui.menu.a r0 = r4.y
            android.graphics.Bitmap r0 = r0.getOptionSingleIcon()
            r5.setOptionItemIcon(r0)
            com.oppo.camera.ui.menu.BasicOptionItemList r5 = r4.f4164b
            int r0 = r4.n
            r5.setSelectItemIndex(r0)
        L_0x0070:
            android.view.View r5 = r4.F()
            if (r5 == 0) goto L_0x0084
            r5 = 3
            int r0 = r4.S()
            if (r5 == r0) goto L_0x0084
            android.view.View r5 = r4.F()
            r5.invalidate()
        L_0x0084:
            if (r1 == 0) goto L_0x0089
            r4.n()
        L_0x0089:
            com.oppo.camera.ui.menu.setting.i r5 = r4.k
            java.lang.String r0 = r4.a()
            int r1 = r4.n
            r5.b(r0, r1, r6)
        L_0x0094:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.ui.menu.setting.CameraMenuOption.a(com.oppo.camera.ui.menu.setting.CameraMenuOption, int):void");
    }

    public boolean f() {
        BasicOptionItemList basicOptionItemList = this.f4164b;
        return basicOptionItemList != null && basicOptionItemList.isShown();
    }

    public boolean g() {
        return this.e;
    }

    public boolean h() {
        return this.f;
    }

    public void a(boolean z) {
        this.f = z;
    }

    public void a(int i2, boolean z) {
        BasicOptionItemList basicOptionItemList = this.f4164b;
        if (basicOptionItemList != null) {
            basicOptionItemList.a(i2, z);
        }
    }

    public void i() {
        j();
        BasicOptionItemList basicOptionItemList = this.f4164b;
        if (basicOptionItemList != null) {
            basicOptionItemList.setVisibility(8);
            this.f4164b.a(this.k.getOrientation(), false);
            this.f4164b.setOptionItemIcon(this.y.getOptionSingleIcon());
            this.f4164b.setSelectItemIndex(this.n);
        }
    }

    public void j() {
        int O;
        com.oppo.camera.e.a("CameraMenuOption", "initializeOptionItems");
        if (!P() && (O = O()) > 0) {
            this.f4164b = new c(this.j, this.m);
            for (int i2 = 0; i2 < O; i2++) {
                j jVar = new j(this.f4163a, this.j, this.m, this.i);
                jVar.b();
                d f2 = f(i2);
                if (f2 != null) {
                    if (S() == 3) {
                        jVar.a(f2.a(), false);
                    } else {
                        jVar.h(f2.d());
                    }
                }
                this.f4164b.a((CameraMenuOption) jVar);
            }
            this.f4164b.setOptionItemIcon(this.y.getOptionSingleIcon());
            this.f4164b.setSelectItemIndex(this.n);
            this.f4164b.setOptionItemListListener(this);
            this.f4164b.a(F(), 0, 2);
            this.f4164b.setVisibility(8);
        }
    }

    public void k() {
        BasicOptionItemList basicOptionItemList = this.f4164b;
        if (basicOptionItemList != null) {
            basicOptionItemList.g();
            this.f4164b = null;
        }
    }

    public void l() {
        b(true, true);
        a(true);
        a aVar = this.y;
        if (aVar != null) {
            aVar.release();
            this.y = null;
        }
        ArrayList<d> arrayList = this.w;
        if (arrayList != null) {
            Iterator<d> it = arrayList.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next != null) {
                    next.e();
                }
            }
            this.w.clear();
            this.w = null;
        }
        this.k = null;
        com.oppo.camera.ui.menu.f.b((e) this);
        k();
        if (F() != null) {
            F().clearAnimation();
        }
        LayoutTranslationAnimation layoutTranslationAnimation = this.p;
        if (layoutTranslationAnimation != null) {
            layoutTranslationAnimation.cancel();
            this.p = null;
        }
        w();
        this.j = null;
    }

    public void m() {
        BasicOptionItemList basicOptionItemList = this.f4164b;
        if (basicOptionItemList != null) {
            com.oppo.camera.ui.menu.f.a(basicOptionItemList);
        }
    }

    public void n() {
        BasicOptionItemList basicOptionItemList = this.f4164b;
        if (basicOptionItemList != null && basicOptionItemList.isShown()) {
            this.f4164b.d();
        }
    }

    public void o() {
        if (O() > 0) {
            b(J(), K());
        } else {
            b((Drawable) null, false);
        }
        h(N());
        if (F() != null) {
            F().invalidate();
        }
    }

    public boolean a(String str, int i2) {
        if (str == null || !str.equals(a())) {
            return false;
        }
        if (this.w == null) {
            return true;
        }
        for (int i3 = 0; i3 < this.w.size(); i3++) {
            d dVar = this.w.get(i3);
            dVar.a(this.j.getDrawable(i2));
            b(dVar.a(), false);
        }
        return true;
    }

    public boolean a(String str, String str2, List<String> list) {
        if (str == null || !str.equals(a())) {
            return false;
        }
        if (a(list, n(str2))) {
            if (this.f4164b != null) {
                k();
            }
            o();
            if (O() < 2) {
                a(false, true);
            } else if (!this.d && this.k.getMenuPanelEnable()) {
                a(true, false);
            }
            if (O() <= 0) {
                a(8);
            } else {
                e(str2);
            }
        } else {
            e(str2);
            o();
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean p() {
        return O() >= 2;
    }

    public boolean q() {
        return this.x;
    }

    public boolean a(String str, String str2, String str3) {
        if (str != null && !str.equals(a())) {
            return false;
        }
        com.oppo.camera.e.a("CameraMenuOption", "disableMenuOption, key: " + str + ", keyValue: " + str3);
        if (p()) {
            this.d = true;
            a(false, true);
            this.x = !this.d;
            if (str3 == null) {
                this.g = false;
                e(str2);
            } else if (j(str3)) {
                b(J(), K());
            }
            if (F() != null) {
                F().invalidate();
            }
        }
        return true;
    }

    public boolean b(String str, String str2, String str3) {
        if (str != null && !str.equals(a())) {
            return false;
        }
        com.oppo.camera.e.a("CameraMenuOption", "enableMenuOption, key: " + str + ", keyValue: " + str3);
        if (p()) {
            this.d = false;
            a(true, false);
            this.x = !this.d;
            if (str3 == null) {
                this.g = false;
                e(str2);
            } else if (j(str3)) {
                b(J(), K());
            }
            if (F() != null) {
                F().invalidate();
            }
        }
        return true;
    }

    public boolean a(String str, String... strArr) {
        if (str == null || !str.equals(a())) {
            return false;
        }
        com.oppo.camera.e.a("CameraMenuOption", "addMenuOptionItems, key: " + str);
        if (strArr == null || strArr.length <= 0) {
            return true;
        }
        for (String l2 : strArr) {
            int l3 = l(l2);
            if (l3 >= 0 && this.f4164b != null) {
                j jVar = new j(this.f4163a, this.j, this.m, this.i);
                jVar.b();
                d f2 = f(l3);
                if (f2 != null) {
                    jVar.h(f2.d());
                    jVar.b(f2.a(), false);
                    this.f4164b.a((CameraMenuOption) jVar, l3);
                }
            }
        }
        BasicOptionItemList basicOptionItemList = this.f4164b;
        if (basicOptionItemList == null) {
            return true;
        }
        basicOptionItemList.setSelectItemIndex(this.n);
        return true;
    }

    public boolean b(String str, String... strArr) {
        if (str == null || !str.equals(a())) {
            return false;
        }
        com.oppo.camera.e.a("CameraMenuOption", "removeMenuOptionItems, key: " + str + ", mOptionItemList: " + this.f4164b);
        if (strArr == null || strArr.length <= 0) {
            return true;
        }
        for (String k2 : strArr) {
            int k3 = k(k2);
            if (k3 >= 0) {
                BasicOptionItemList basicOptionItemList = this.f4164b;
                if (basicOptionItemList != null) {
                    basicOptionItemList.a(k3);
                    this.f4164b.setSelectItemIndex(this.n);
                }
                o();
            }
        }
        return true;
    }

    public boolean a(String str, String str2, int i2, boolean z) {
        if (str != null && str.equals(a()) && g()) {
            i iVar = this.k;
            if (iVar != null && iVar.a(str)) {
                this.e = false;
                a(false);
                e(str2);
                a(this.k.getMenuPanelEnable(), this.k.getMenuPanelAshed());
                if (i2 != 0 || !z) {
                    a(i2);
                } else {
                    d(i2);
                }
            }
            r();
            return true;
        } else if (str == null || !str.equals(a()) || B() != 0) {
            return false;
        } else {
            if (i2 == 0) {
                d(i2);
            }
            r();
            return true;
        }
    }

    public boolean a(String str, boolean z) {
        if (str == null || !str.equals(a())) {
            return false;
        }
        this.e = true;
        if (!(F() == null || C() == 8)) {
            if (!z || 4 == F().getVisibility()) {
                a(8);
            } else {
                Util.a(F(), 8, (Animation.AnimationListener) null, 300);
            }
        }
        s();
        return true;
    }

    public void e(String str) {
        if (!this.d) {
            m(n(str));
            if (!g()) {
                o();
            }
            BasicOptionItemList basicOptionItemList = this.f4164b;
            if (basicOptionItemList != null) {
                basicOptionItemList.setSelectItemIndex(this.n);
            }
        }
    }

    public void a(String str) {
        com.oppo.camera.e.a("CameraMenuOption", "showPopUpWindowBegin, key: " + str + ", option key: " + a());
        if (D() && !g() && F() != null) {
            F().setClickable(false);
            if (str.equals(a())) {
                c(1);
                int left = F().getLeft();
                int i2 = this.t;
                this.r = left;
                if (z()) {
                    A();
                }
                if (left != i2) {
                    a(left, i2);
                } else {
                    F().setClickable(true);
                    F().setAlpha(1.0f);
                }
                o();
                return;
            }
            f(str);
        }
    }

    public void c(String str) {
        com.oppo.camera.e.a("CameraMenuOption", "hidePopUpWindowBegin, key: " + str + ", option key: " + a());
        if (F() != null) {
            if (1 == B()) {
                F().setClickable(false);
            }
            if (3 == B()) {
                F().clearAnimation();
                g(str);
            } else if (1 == B()) {
                c(2);
                o();
                F().clearAnimation();
                if (C() != 0) {
                    A();
                    b(this.r);
                } else if (this.p != null) {
                    if (z()) {
                        A();
                    }
                    a(F().getLeft(), this.r);
                }
            }
        }
    }

    public void d(String str) {
        if (F() != null) {
            F().setClickable(true);
            if (B() != 0) {
                a(1.0f);
            }
            if (3 == B() && !g()) {
                F().setVisibility(0);
            } else if (1 == B()) {
                c(0);
                b(this.r);
            }
        }
        o();
        c(0);
    }

    public void f(String str) {
        com.oppo.camera.e.a("CameraMenuOption", "hideMenu, option key: " + a() + ", remove: " + this.e + ", state: " + B() + ", itemView: " + F() + ", show: " + D());
        if (D() && !g() && B() == 0 && F() != null) {
            c(3);
            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation.setDuration(150);
            alphaAnimation.setAnimationListener(new Animation.AnimationListener() {
                public void onAnimationRepeat(Animation animation) {
                }

                public void onAnimationStart(Animation animation) {
                }

                public void onAnimationEnd(Animation animation) {
                    if (CameraMenuOption.this.F() != null && 3 == CameraMenuOption.this.B()) {
                        CameraMenuOption.this.F().setVisibility(4);
                    }
                }
            });
            F().clearAnimation();
            F().startAnimation(alphaAnimation);
        }
    }

    public void g(String str) {
        com.oppo.camera.e.a("CameraMenuOption", "showMenu, option key: " + a() + ", remove: " + this.e + ", state: " + B() + ", itemView: " + F());
        if (F() != null && 3 == B() && !g()) {
            c(4);
            Util.a(F(), 0, (Animation.AnimationListener) null, 200);
            if (F().getAnimation() != null) {
                F().getAnimation().setStartOffset(50);
            }
        }
    }

    public int u() {
        return this.r;
    }

    public void b(int i2) {
        com.oppo.camera.e.a("CameraMenuOption", "key: " + a() + " resetLayout left: " + i2);
        if (F() != null) {
            F().layout(i2, F().getTop(), F().getWidth() + i2, F().getBottom());
        }
    }

    public void b(boolean z, boolean z2) {
        if (B() != 0) {
            if (F() != null) {
                F().setClickable(true);
                F().setAlpha(1.0f);
                if (3 == B() && z) {
                    F().setVisibility(0);
                } else if (1 == B() && z2) {
                    c(0);
                    o();
                    b(this.r);
                }
            }
            c(0);
        }
    }

    public Drawable v() {
        ArrayList<d> arrayList = this.w;
        if (arrayList != null) {
            return arrayList.get(0).a();
        }
        return null;
    }

    public void a(float f2) {
        if (F() != null) {
            View F = F();
            if (f2 == 1.0f && !F().isEnabled()) {
                f2 = F().getAlpha();
            }
            F.setAlpha(f2);
        }
    }

    public void a(OnItemClickListener onItemClickListener) {
        this.l = onItemClickListener;
    }

    public void a(ViewGroup viewGroup) {
        if (viewGroup != null && F() != null) {
            try {
                this.q = viewGroup;
                viewGroup.addView(F());
            } catch (Exception e2) {
                com.oppo.camera.e.a("CameraMenuOption", "addItemViewToParent, Exception: " + e2.toString());
            }
        }
    }

    /* access modifiers changed from: protected */
    public void w() {
        if (!(this.q == null || F() == null)) {
            this.q.removeView(F());
        }
        this.q = null;
    }

    public void a(int i2, int i3, int i4, int i5) {
        if (F() != null) {
            F().layout(i2, i3, i4, i5);
        }
    }

    public boolean z() {
        return this.o;
    }

    public void A() {
        LayoutTranslationAnimation layoutTranslationAnimation = this.p;
        if (layoutTranslationAnimation != null && this.o) {
            layoutTranslationAnimation.onAnimationEnd(layoutTranslationAnimation);
        }
    }

    public void c(int i2) {
        com.oppo.camera.e.a("CameraMenuOption", "key: " + a() + " setItemState, state( " + this.s + " ==> " + i2 + " )");
        this.s = i2;
    }

    public int B() {
        return this.s;
    }

    public void a(int i2, int i3) {
        com.oppo.camera.e.a("CameraMenuOption", "animationLayoutTranslationToX, startPos: " + i2 + "endPos: " + i3 + " key: " + a());
        if (i2 != i3 && F() != null) {
            if (this.p == null) {
                this.p = new LayoutTranslationAnimation();
                this.p.setInterpolator(new AccelerateDecelerateInterpolator());
                LayoutTranslationAnimation layoutTranslationAnimation = this.p;
                layoutTranslationAnimation.setAnimationListener(layoutTranslationAnimation);
            }
            if (this.o) {
                this.p.a(i3);
                return;
            }
            this.o = true;
            this.p.a(i2, i3);
            this.p.setDuration(250);
            F().clearAnimation();
            F().startAnimation(this.p);
        }
    }

    public void d(int i2) {
        if (F() != null && C() != i2) {
            Util.a(F(), i2, (Animation.AnimationListener) null, 300);
        }
    }

    public int C() {
        if (F() != null) {
            return F().getVisibility();
        }
        return 8;
    }

    public boolean D() {
        if (F() != null) {
            return F().isShown();
        }
        return false;
    }

    public int E() {
        LayoutTranslationAnimation layoutTranslationAnimation;
        if (this.o && (layoutTranslationAnimation = this.p) != null) {
            return layoutTranslationAnimation.a();
        }
        if (F() != null) {
            return F().getLeft();
        }
        return 0;
    }

    public void e(int i2) {
        this.i = i2;
    }

    private class LayoutTranslationAnimation extends Animation implements Animation.AnimationListener {

        /* renamed from: b  reason: collision with root package name */
        private int f4167b = 0;
        private int c = 0;
        private boolean d = false;

        public LayoutTranslationAnimation() {
            boolean unused = CameraMenuOption.this.o = false;
            this.d = false;
        }

        public void a(int i, int i2) {
            this.f4167b = i;
            this.c = i2;
        }

        public int a() {
            return this.c;
        }

        public void a(int i) {
            this.c = i;
        }

        /* access modifiers changed from: protected */
        public void applyTransformation(float f, Transformation transformation) {
            if (CameraMenuOption.this.F() != null && !this.d) {
                int i = this.c;
                int i2 = this.f4167b;
                int i3 = ((int) (((float) (i - i2)) * f)) + i2;
                CameraMenuOption cameraMenuOption = CameraMenuOption.this;
                cameraMenuOption.a(i3, cameraMenuOption.F().getTop(), CameraMenuOption.this.F().getWidth() + i3, CameraMenuOption.this.F().getBottom());
            }
        }

        public void cancel() {
            this.d = true;
            CameraMenuOption cameraMenuOption = CameraMenuOption.this;
            cameraMenuOption.a(this.c, cameraMenuOption.F().getTop(), this.c + CameraMenuOption.this.F().getWidth(), CameraMenuOption.this.F().getBottom());
            super.cancel();
        }

        public void onAnimationEnd(Animation animation) {
            boolean unused = CameraMenuOption.this.o = false;
            this.d = false;
            if (CameraMenuOption.this.F() != null) {
                CameraMenuOption cameraMenuOption = CameraMenuOption.this;
                cameraMenuOption.a(this.c, cameraMenuOption.F().getTop(), this.c + CameraMenuOption.this.F().getWidth(), CameraMenuOption.this.F().getBottom());
                if (1 == CameraMenuOption.this.B()) {
                    CameraMenuOption.this.F().setClickable(true);
                    CameraMenuOption.this.F().setAlpha(1.0f);
                }
            }
        }

        public void onAnimationRepeat(Animation animation) {
            boolean unused = CameraMenuOption.this.o = true;
        }

        public void onAnimationStart(Animation animation) {
            if (hasStarted() && !hasEnded()) {
                boolean unused = CameraMenuOption.this.o = true;
            }
            this.d = false;
        }
    }

    public String a() {
        a aVar = this.y;
        if (aVar != null) {
            return aVar.getOptionKey();
        }
        return null;
    }

    public int H() {
        return this.y.getOptionType();
    }

    public void i(String str) {
        int a2 = h.a(str, this.w);
        if (a2 >= 0) {
            this.n = a2;
            this.v = str;
            this.g = false;
            SharedPreferences.Editor edit = this.k.getSharedPreferences().edit();
            edit.putString(this.y.getOptionKey(), str);
            edit.apply();
            return;
        }
        com.oppo.camera.e.e("CameraMenuOption", "setOptionValue fail! index: " + a2);
    }

    public Drawable I() {
        ArrayList<d> arrayList = this.w;
        if (arrayList == null || this.n >= arrayList.size()) {
            return null;
        }
        Drawable a2 = this.w.get(this.n).a();
        return a2 == null ? this.w.get(0).a() : a2;
    }

    public Drawable J() {
        ArrayList<d> arrayList = this.w;
        if (arrayList == null || this.n >= arrayList.size()) {
            return null;
        }
        Drawable a2 = this.w.get(this.n).a();
        return a2 == null ? this.w.get(0).a() : a2;
    }

    public boolean K() {
        return TextUtils.equals(this.v, "on");
    }

    public Drawable L() {
        a aVar = this.y;
        if (aVar != null) {
            return aVar.getOptionExpandIcon();
        }
        return null;
    }

    public Drawable e(boolean z) {
        ArrayList<d> arrayList = this.w;
        if (arrayList == null || this.n >= arrayList.size()) {
            return null;
        }
        if (z) {
            return this.w.get(1).a();
        }
        return this.w.get(0).a();
    }

    public String M() {
        ArrayList<d> arrayList = this.w;
        return (arrayList == null || this.n >= arrayList.size() || TextUtils.isEmpty(this.w.get(this.n).c())) ? "" : this.w.get(this.n).c();
    }

    public String N() {
        ArrayList<d> arrayList = this.w;
        if (arrayList == null || this.n >= arrayList.size()) {
            return null;
        }
        return this.w.get(this.n).d();
    }

    public d f(int i2) {
        ArrayList<d> arrayList = this.w;
        if (arrayList == null || arrayList.size() <= i2) {
            return null;
        }
        return this.w.get(i2);
    }

    public int O() {
        ArrayList<d> arrayList = this.w;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    public boolean P() {
        return this.y.getOptionOnOff();
    }

    public boolean Q() {
        return this.y.getImageTitleMode();
    }

    public boolean R() {
        return this.y.getImageTitleColorChangeable();
    }

    public int S() {
        return this.y.getGroupType();
    }

    public boolean j(String str) {
        int a2 = h.a(str, this.w);
        if (a2 < 0 || a2 == this.n) {
            return false;
        }
        this.n = a2;
        this.v = this.w.get(this.n).b();
        this.g = true;
        com.oppo.camera.e.a(str, "setOptionValueNoToPreferences, key: " + a() + ", mOptionValue: " + this.v);
        return true;
    }

    public void g(int i2) {
        if (i2 >= 0 && i2 < this.w.size()) {
            i(this.w.get(i2).b());
        }
    }

    public int T() {
        return this.n;
    }

    public int k(String str) {
        if (!h.b(str, this.w)) {
            return -1;
        }
        int a2 = h.a(str, this.w);
        if (a2 >= 0) {
            this.w.remove(a2);
        }
        if (this.w.size() <= 0) {
            com.oppo.camera.e.a("CameraMenuOption", "removeOptionItem, the remain item is 0, Error");
            return a2;
        } else if (this.v.equals(str)) {
            this.v = this.w.get(0).b();
            this.n = 0;
            i(this.v);
            return a2;
        } else {
            this.n = h.a(this.v, this.w);
            return a2;
        }
    }

    public void f(boolean z) {
        this.h = z;
    }

    public int l(String str) {
        int i2;
        if (h.b(str, this.w) || !h.b(str, this.y.getOptionItems())) {
            return -1;
        }
        int a2 = h.a(str, this.y.getOptionItems());
        if (a2 == 0) {
            i2 = a2;
        } else {
            i2 = 0;
            int i3 = a2 - 1;
            while (true) {
                if (i3 < 0) {
                    break;
                }
                int a3 = h.a(this.y.getOptionItems().get(i3).b(), this.w);
                if (a3 >= 0) {
                    i2 = a3 + 1;
                    break;
                }
                i3--;
            }
        }
        this.w.add(i2, this.y.getOptionItems().get(a2));
        if (this.w.size() <= 0) {
            com.oppo.camera.e.a("CameraMenuOption", "addOptionItem, the remain item is 0, Error");
            return i2;
        }
        this.n = h.a(this.v, this.w);
        return i2;
    }

    public boolean a(List<String> list, String str) {
        int i2;
        if (list == null || list.size() <= 0) {
            i2 = this.w.size();
            this.w.clear();
        } else {
            ArrayList<d> arrayList = new ArrayList<>();
            ArrayList<d> optionItems = this.y.getOptionItems();
            for (int i3 = 0; i3 < optionItems.size(); i3++) {
                if (list.indexOf(optionItems.get(i3).b()) >= 0) {
                    arrayList.add(optionItems.get(i3));
                }
            }
            i2 = Math.abs(this.w.size() - arrayList.size());
            if (i2 == 0) {
                int i4 = i2;
                for (int i5 = 0; i5 < this.w.size(); i5++) {
                    if (!this.w.get(i5).b().equals(arrayList.get(i5).b())) {
                        i4++;
                    }
                }
                i2 = i4;
            }
            this.w.clear();
            this.w = arrayList;
            m(str);
        }
        if (i2 > 0) {
            return true;
        }
        return false;
    }

    public void m(String str) {
        this.v = this.k.getSharedPreferences().getString(a(), str);
        if (this.w.size() <= 0 || (!this.x && h.a(this.v, this.w) >= 0)) {
            int a2 = h.a(this.v, this.w);
            if (a2 < 0 || a2 >= this.w.size()) {
                this.n = 0;
                if (this.w.size() > 0) {
                    this.v = this.w.get(this.n).b();
                }
            } else if (this.n != a2) {
                this.n = a2;
            }
        } else {
            if (!this.g) {
                this.n = h.a(this.v, this.w);
            }
            if (this.n < 0) {
                this.n = 0;
                if (this.w.size() > 0) {
                    this.v = this.w.get(this.n).b();
                }
            }
        }
    }

    public String n(String str) {
        String optionDefaultValue = this.y.getOptionDefaultValue();
        if (optionDefaultValue != null && h.b(optionDefaultValue, this.w)) {
            return optionDefaultValue;
        }
        if (str == null || !h.b(str, this.w)) {
            return this.w.get(0).b();
        }
        return str;
    }

    /* access modifiers changed from: protected */
    public Bitmap U() {
        return this.y.getOffAnimationIcon();
    }

    /* access modifiers changed from: protected */
    public Bitmap V() {
        return this.y.getOnAnimationIcon();
    }
}
