package com.oppo.camera.ui.menu.levelcontrol;

import android.animation.AnimatorSet;
import android.app.Activity;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.oppo.camera.R;
import com.oppo.camera.ui.inverse.InverseTextView;
import com.oppo.camera.ui.inverse.c;
import com.oppo.camera.ui.menu.levelcontrol.ThreeDScrollBar;
import com.oppo.camera.ui.menu.setting.t;
import com.oppo.camera.ui.preview.a.g;
import com.oppo.camera.ui.preview.a.h;
import com.oppo.camera.util.Util;
import java.util.List;

/* compiled from: FilterEffectMenu */
public class e extends t {
    private int e = 0;
    private Activity f = null;
    private RelativeLayout g = null;
    private RelativeLayout h = null;
    private InverseTextView i = null;
    /* access modifiers changed from: private */
    public ThreeDScrollBar j = null;
    /* access modifiers changed from: private */
    public a k = null;
    private Handler l = new Handler();
    /* access modifiers changed from: private */
    public AnimatorSet m = null;
    private List<String> n = null;
    /* access modifiers changed from: private */
    public int o = g.f4385a;
    /* access modifiers changed from: private */
    public boolean p = false;
    /* access modifiers changed from: private */
    public int q = 0;
    /* access modifiers changed from: private */
    public int r = 0;
    private int s = 0;
    private int t = 1;
    private int u = 1;
    private h.a v = h.a.Polarr;

    /* compiled from: FilterEffectMenu */
    public interface a {
        void a();

        void a(int i, boolean z);

        void a(g gVar);

        void a(String str);

        void a(boolean z);

        boolean a(int i);

        void b(String str);

        boolean b();

        boolean c();

        boolean d();

        int e();

        int f();
    }

    public void a(String str, boolean z) {
        if (this.c) {
            com.oppo.camera.e.a("FilterEffectMenu", "showMenuPanel, ExitAnimatorSet.isRunning, return");
            return;
        }
        a aVar = this.k;
        if (aVar == null || (!aVar.d() && !z)) {
            com.oppo.camera.e.a("FilterEffectMenu", "showMenuPanel, mMenuListener null, return!");
            return;
        }
        if (this.k.b() || z) {
            this.u = 1;
            this.k.b("filter");
            a(true);
        }
        super.a(str, z);
    }

    public void a(boolean z, boolean z2) {
        if (!b()) {
            return;
        }
        if (g() || m()) {
            com.oppo.camera.e.a("FilterEffectMenu", "hideMenuPanel, anim isRunning, return.");
        } else {
            b(true, z2);
        }
    }

    /* compiled from: FilterEffectMenu */
    private class b implements ThreeDScrollBar.a {
        private b() {
        }

        public void a() {
            if (e.this.k != null) {
                e.this.k.a();
            }
            if (e.this.j != null) {
                e.this.j.a(e.this.q, e.this.r);
            }
        }

        public void a(g gVar) {
            if (e.this.k != null) {
                e.this.k.a(gVar);
            }
        }

        public void a(int i, boolean z) {
            if (e.this.k != null) {
                int unused = e.this.o = i;
                e.this.k.a(i, z);
            }
        }

        public boolean a(int i) {
            if (e.this.k != null) {
                return e.this.k.a(i);
            }
            return false;
        }

        public boolean b() {
            return e.this.k != null && e.this.k.b() && !e.this.g() && (e.this.m == null || !e.this.m.isRunning()) && e.this.p;
        }

        public int c() {
            return e.this.o;
        }

        public int d() {
            if (e.this.k != null) {
                return e.this.k.e();
            }
            return 0;
        }
    }

    public void setFilterEffectMenuListener(a aVar) {
        this.k = aVar;
    }

    public e(Activity activity) {
        super(activity);
        this.f = activity;
    }

    public void setCameraEntryType(int i2) {
        this.t = i2;
    }

    public void setFilterIndex(int i2) {
        this.o = i2;
    }

    public void a(int i2) {
        this.e = i2;
        this.g = (RelativeLayout) this.f.findViewById(R.id.camera);
        if (this.g == null) {
        }
    }

    public void a() {
        ThreeDScrollBar threeDScrollBar = this.j;
        if (threeDScrollBar != null) {
            threeDScrollBar.b();
        }
    }

    public void e() {
        ThreeDScrollBar threeDScrollBar = this.j;
        if (threeDScrollBar != null) {
            threeDScrollBar.c();
        }
        Handler handler = this.l;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
        }
        this.f4265b = false;
        this.c = false;
        c(true, false);
    }

    public void f() {
        ThreeDScrollBar threeDScrollBar = this.j;
        if (threeDScrollBar != null) {
            threeDScrollBar.d();
        }
    }

    public boolean o_() {
        if (!b()) {
            return false;
        }
        if (g() || m()) {
            com.oppo.camera.e.a("FilterEffectMenu", "onBackPressed, onClick, anim isRunning.");
            return true;
        }
        b(true, false);
        return true;
    }

    public boolean a(int i2, int i3) {
        if (b() && i3 < o()) {
            if (g() || m()) {
                com.oppo.camera.e.a("FilterEffectMenu", "onSingleTapUp, onClick, anim isRunning.");
            } else {
                b(true, false);
                return true;
            }
        }
        return false;
    }

    public boolean g() {
        return this.f4265b || this.c;
    }

    public void i() {
        ThreeDScrollBar threeDScrollBar = this.j;
        if (threeDScrollBar != null) {
            threeDScrollBar.h();
        }
    }

    public void j() {
        ThreeDScrollBar threeDScrollBar = this.j;
        if (threeDScrollBar != null) {
            threeDScrollBar.f();
        }
    }

    public void k() {
        ThreeDScrollBar threeDScrollBar = this.j;
        if (threeDScrollBar != null) {
            threeDScrollBar.g();
        }
    }

    public void b(int i2) {
        ThreeDScrollBar threeDScrollBar = this.j;
        if (threeDScrollBar != null) {
            threeDScrollBar.b(i2);
        }
    }

    public boolean b() {
        return this.p || this.f4265b;
    }

    public boolean c() {
        a aVar = this.k;
        if (aVar != null) {
            return aVar.c();
        }
        return g.f4385a != this.o;
    }

    private void p() {
        a aVar;
        if (this.h == null) {
            LayoutInflater layoutInflater = this.f.getLayoutInflater();
            this.h = (RelativeLayout) layoutInflater.inflate(R.layout.effects_menu, (ViewGroup) null);
            this.i = (InverseTextView) layoutInflater.inflate(R.layout.effects_title, (ViewGroup) null);
            c.INS.registerInverse(this.f, this.i);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, this.f.getResources().getDimensionPixelSize(R.dimen.effects_menu_height));
            layoutParams.addRule(10);
            layoutParams.topMargin = Util.v() + this.f.getResources().getDimensionPixelSize(R.dimen.effects_menu_margin_top);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams2.addRule(10);
            layoutParams2.addRule(14);
            layoutParams2.topMargin = Util.v() + this.f.getResources().getDimensionPixelSize(R.dimen.effects_menu_title_margin_top);
            a aVar2 = this.k;
            if (aVar2 != null) {
                this.g.addView(this.h, aVar2.f(), layoutParams);
                this.g.addView(this.i, this.k.f(), layoutParams2);
            } else {
                this.g.addView(this.h, layoutParams);
                this.g.addView(this.i, layoutParams2);
            }
            this.j = (ThreeDScrollBar) this.h.findViewById(R.id.effect_scrollbar);
            this.j.setCameraEntryType(this.t);
            this.j.setThreeDScrollBarTextureViewCallback(new b());
        } else if (this.u == 1 && (aVar = this.k) != null) {
            aVar.a("filter");
        }
    }

    public void a(List<String> list, String str, int i2) {
        this.n = list;
        this.o = i2;
    }

    public void c(int i2) {
        ThreeDScrollBar threeDScrollBar = this.j;
        if (threeDScrollBar != null) {
            threeDScrollBar.a(i2);
        }
    }

    public int getTextureWidth() {
        return this.q;
    }

    public int getTextureHeight() {
        return this.r;
    }

    public void b(int i2, int i3) {
        ThreeDScrollBar threeDScrollBar;
        com.oppo.camera.e.a("FilterEffectMenu", "notifyPreviewSizeChanged, Size: " + i2 + "x" + i3);
        this.q = i2;
        this.r = i3;
        if (b() && (threeDScrollBar = this.j) != null) {
            threeDScrollBar.a(i2, i3);
        }
    }

    public void a(int i2, boolean z) {
        com.oppo.camera.e.a("FilterEffectMenu", "setVisibility, visible: " + i2 + ", isAnim: " + z + ", isEffectMenuOpen: " + b());
        if (z) {
            if (b()) {
                a(this.h, i2, true);
                b(this.i, i2, true);
            }
        } else if (b()) {
            a(this.h, i2, false);
            b(this.i, i2, false);
        }
    }

    public void l() {
        ThreeDScrollBar threeDScrollBar = this.j;
        if (threeDScrollBar != null) {
            threeDScrollBar.a();
        }
    }

    public void a(boolean z) {
        com.oppo.camera.e.a("FilterEffectMenu", "show, isAnim: " + z);
        if (this.n == null) {
            com.oppo.camera.e.e("FilterEffectMenu", "show failed, mCurrMenuNames: " + this.n);
            return;
        }
        this.p = true;
        p();
        this.j.setFilterCategory(this.v);
        if (z) {
            a(this.h, 0, true);
            a(this.j, 0, true);
            b(this.i, 0, true);
            return;
        }
        a(this.h, 0, false);
        a(this.j, 0, false);
        b(this.i, 0, false);
    }

    public void setFilterCategory(h.a aVar) {
        this.v = aVar;
    }

    public void b(boolean z, boolean z2) {
        com.oppo.camera.e.a("FilterEffectMenu", "hideAnimator");
        Handler handler = this.l;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
        }
        a(this.j, 4, true);
        b(this.i, 8, true);
        this.p = false;
        a aVar = this.k;
        if (aVar != null) {
            aVar.a(z2);
        }
        super.a(z, z2);
    }

    public void c(boolean z, boolean z2) {
        com.oppo.camera.e.a("FilterEffectMenu", "hideWithoutAnim");
        Handler handler = this.l;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
        }
        if (b()) {
            a(this.j, 4, false);
            b(this.i, 8, false);
            this.p = false;
            super.a(z, false);
        }
    }

    public boolean m() {
        ThreeDScrollBar threeDScrollBar = this.j;
        if (threeDScrollBar != null) {
            return threeDScrollBar.e();
        }
        return false;
    }

    public void a(f fVar) {
        if (this.j != null && fVar != null) {
            fVar.b(this.q);
            fVar.c(this.r);
            this.o = fVar.j();
            this.j.a(fVar);
        }
    }

    public void a(int i2, String str) {
        ThreeDScrollBar threeDScrollBar = this.j;
        if (threeDScrollBar != null) {
            threeDScrollBar.a(i2, str);
        }
    }

    public void n() {
        ThreeDScrollBar threeDScrollBar = this.j;
        if (threeDScrollBar != null) {
            threeDScrollBar.i();
        }
    }
}
