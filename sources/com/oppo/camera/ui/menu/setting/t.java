package com.oppo.camera.ui.menu.setting;

import android.app.Activity;
import android.view.View;
import android.view.animation.Animation;
import com.oppo.camera.R;
import com.oppo.camera.e;
import com.oppo.camera.util.Util;

/* compiled from: ExpandableMenuPanel */
public class t extends View {

    /* renamed from: a  reason: collision with root package name */
    public static String f4264a = "DefaultExpandPanel";

    /* renamed from: b  reason: collision with root package name */
    public boolean f4265b = false;
    public boolean c = false;
    public b d = null;
    private boolean e = false;
    /* access modifiers changed from: private */
    public int f = 0;

    /* compiled from: ExpandableMenuPanel */
    public interface b {
        void a(String str);

        void a(String str, boolean z, boolean z2);
    }

    public void b(int i) {
    }

    public void c(boolean z, boolean z2) {
    }

    public boolean d() {
        return false;
    }

    public void j() {
    }

    public void k() {
    }

    public t(Activity activity) {
        super(activity.getApplicationContext());
    }

    public void a(String str, boolean z) {
        e.a("ExpandableMenuPanel", "showMenuPanel");
        this.e = true;
        setCurrentMenuKey(str);
        b bVar = this.d;
        if (bVar != null) {
            bVar.a(f4264a);
        }
    }

    public void a(boolean z, boolean z2) {
        e.a("ExpandableMenuPanel", "hideMenuPanel");
        this.e = false;
        b bVar = this.d;
        if (bVar != null) {
            bVar.a(f4264a, z, z2);
        }
        setCurrentMenuKey("DefaultExpandPanel");
    }

    public void setExpandMenuListener(b bVar) {
        this.d = bVar;
    }

    public int o() {
        return Util.C() - Util.w();
    }

    public boolean a(int i, int i2) {
        if (!this.e || i2 >= o() || g()) {
            return false;
        }
        a(true, false);
        return true;
    }

    public boolean o_() {
        if (!this.e || g()) {
            return false;
        }
        a(true, false);
        return true;
    }

    public boolean g() {
        return this.f4265b || this.c;
    }

    public void setCurrentMenuKey(String str) {
        f4264a = str;
    }

    public void setSkipIndex(int i) {
        this.f = i;
    }

    public String getCurrentMenuKey() {
        return f4264a;
    }

    public boolean b() {
        return this.e || this.f4265b;
    }

    public boolean c() {
        return this.e || this.f4265b;
    }

    public void a(View view, int i, boolean z) {
        if (z) {
            if (i == 0) {
                Util.a(view, i, (int) R.anim.expand_menu_enter, true, true, (Animation.AnimationListener) new a(view, i));
                return;
            }
            Util.a(view, i, (int) R.anim.expand_menu_exit, true, true, (Animation.AnimationListener) new a(view, i));
        } else if (view != null) {
            view.clearAnimation();
            view.setVisibility(i);
            this.f4265b = false;
            this.c = false;
        }
    }

    public void b(View view, int i, boolean z) {
        if (z) {
            if (i == 0) {
                Util.a(view, i, (int) R.anim.expand_text_show, true, true, (Animation.AnimationListener) new a(view, i));
                return;
            }
            Util.a(view, i, (int) R.anim.expand_text_hide, true, true, (Animation.AnimationListener) new a(view, i));
        } else if (view != null) {
            view.clearAnimation();
            view.setVisibility(i);
        }
    }

    /* compiled from: ExpandableMenuPanel */
    public class a implements Animation.AnimationListener {

        /* renamed from: b  reason: collision with root package name */
        private View f4267b = null;
        private int c = 4;

        public void onAnimationRepeat(Animation animation) {
        }

        public a(View view, int i) {
            this.f4267b = view;
            this.c = i;
        }

        public void onAnimationStart(Animation animation) {
            int i = this.c;
            if (i == 0) {
                this.f4267b.setVisibility(i);
                t.this.f4265b = true;
                return;
            }
            t.this.c = true;
        }

        public void onAnimationEnd(Animation animation) {
            int i = this.c;
            if (i != 0) {
                this.f4267b.setVisibility(i);
            }
            if (this.c == 0) {
                t.this.f4265b = false;
            } else {
                t.this.c = false;
            }
            if (t.this.f != 0) {
                t tVar = t.this;
                tVar.b(tVar.f);
                int unused = t.this.f = 0;
            }
        }
    }
}
