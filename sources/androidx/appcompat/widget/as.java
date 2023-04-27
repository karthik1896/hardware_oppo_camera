package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.a;
import androidx.appcompat.view.menu.h;
import androidx.appcompat.view.menu.n;
import androidx.appcompat.widget.Toolbar;
import androidx.core.g.aa;
import androidx.core.g.ab;
import androidx.core.g.v;
import androidx.core.g.z;
import com.google.android.material.badge.BadgeDrawable;

/* compiled from: ToolbarWidgetWrapper */
public class as implements z {

    /* renamed from: a  reason: collision with root package name */
    Toolbar f419a;

    /* renamed from: b  reason: collision with root package name */
    CharSequence f420b;
    Window.Callback c;
    boolean d;
    private int e;
    private View f;
    private View g;
    private Drawable h;
    private Drawable i;
    private Drawable j;
    private boolean k;
    private CharSequence l;
    private CharSequence m;
    private ActionMenuPresenter n;
    private int o;
    private int p;
    private Drawable q;

    public void b(boolean z) {
    }

    public as(Toolbar toolbar, boolean z) {
        this(toolbar, z, R.string.abc_action_bar_up_description, R.drawable.abc_ic_ab_back_material);
    }

    public as(Toolbar toolbar, boolean z, int i2, int i3) {
        Drawable drawable;
        this.o = 0;
        this.p = 0;
        this.f419a = toolbar;
        this.f420b = toolbar.getTitle();
        this.l = toolbar.getSubtitle();
        this.k = this.f420b != null;
        this.j = toolbar.getNavigationIcon();
        ar a2 = ar.a(toolbar.getContext(), (AttributeSet) null, R.styleable.ActionBar, R.attr.actionBarStyle, 0);
        this.q = a2.a(R.styleable.ActionBar_homeAsUpIndicator);
        if (z) {
            CharSequence c2 = a2.c(R.styleable.ActionBar_title);
            if (!TextUtils.isEmpty(c2)) {
                b(c2);
            }
            CharSequence c3 = a2.c(R.styleable.ActionBar_subtitle);
            if (!TextUtils.isEmpty(c3)) {
                c(c3);
            }
            Drawable a3 = a2.a(R.styleable.ActionBar_logo);
            if (a3 != null) {
                b(a3);
            }
            Drawable a4 = a2.a(R.styleable.ActionBar_icon);
            if (a4 != null) {
                a(a4);
            }
            if (this.j == null && (drawable = this.q) != null) {
                c(drawable);
            }
            c(a2.a(R.styleable.ActionBar_displayOptions, 0));
            int g2 = a2.g(R.styleable.ActionBar_customNavigationLayout, 0);
            if (g2 != 0) {
                a(LayoutInflater.from(this.f419a.getContext()).inflate(g2, this.f419a, false));
                c(this.e | 16);
            }
            int f2 = a2.f(R.styleable.ActionBar_height, 0);
            if (f2 > 0) {
                ViewGroup.LayoutParams layoutParams = this.f419a.getLayoutParams();
                layoutParams.height = f2;
                this.f419a.setLayoutParams(layoutParams);
            }
            int d2 = a2.d(R.styleable.ActionBar_contentInsetStart, -1);
            int d3 = a2.d(R.styleable.ActionBar_contentInsetEnd, -1);
            if (d2 >= 0 || d3 >= 0) {
                this.f419a.setContentInsetsRelative(Math.max(d2, 0), Math.max(d3, 0));
            }
            int g3 = a2.g(R.styleable.ActionBar_titleTextStyle, 0);
            if (g3 != 0) {
                Toolbar toolbar2 = this.f419a;
                toolbar2.setTitleTextAppearance(toolbar2.getContext(), g3);
            }
            int g4 = a2.g(R.styleable.ActionBar_subtitleTextStyle, 0);
            if (g4 != 0) {
                Toolbar toolbar3 = this.f419a;
                toolbar3.setSubtitleTextAppearance(toolbar3.getContext(), g4);
            }
            int g5 = a2.g(R.styleable.ActionBar_popupTheme, 0);
            if (g5 != 0) {
                this.f419a.setPopupTheme(g5);
            }
        } else {
            this.e = r();
        }
        a2.b();
        e(i2);
        this.m = this.f419a.getNavigationContentDescription();
        this.f419a.setNavigationOnClickListener(new View.OnClickListener() {

            /* renamed from: a  reason: collision with root package name */
            final a f421a = new a(as.this.f419a.getContext(), 0, 16908332, 0, 0, as.this.f420b);

            public void onClick(View view) {
                if (as.this.c != null && as.this.d) {
                    as.this.c.onMenuItemSelected(0, this.f421a);
                }
            }
        });
    }

    public void e(int i2) {
        if (i2 != this.p) {
            this.p = i2;
            if (TextUtils.isEmpty(this.f419a.getNavigationContentDescription())) {
                f(this.p);
            }
        }
    }

    private int r() {
        if (this.f419a.getNavigationIcon() == null) {
            return 11;
        }
        this.q = this.f419a.getNavigationIcon();
        return 15;
    }

    public ViewGroup a() {
        return this.f419a;
    }

    public Context b() {
        return this.f419a.getContext();
    }

    public boolean c() {
        return this.f419a.hasExpandedActionView();
    }

    public void d() {
        this.f419a.collapseActionView();
    }

    public void a(Window.Callback callback) {
        this.c = callback;
    }

    public void a(CharSequence charSequence) {
        if (!this.k) {
            e(charSequence);
        }
    }

    public CharSequence e() {
        return this.f419a.getTitle();
    }

    public void b(CharSequence charSequence) {
        this.k = true;
        e(charSequence);
    }

    private void e(CharSequence charSequence) {
        this.f420b = charSequence;
        if ((this.e & 8) != 0) {
            this.f419a.setTitle(charSequence);
        }
    }

    public void c(CharSequence charSequence) {
        this.l = charSequence;
        if ((this.e & 8) != 0) {
            this.f419a.setSubtitle(charSequence);
        }
    }

    public void f() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    public void g() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    public void a(int i2) {
        a(i2 != 0 ? androidx.appcompat.a.a.a.b(b(), i2) : null);
    }

    public void a(Drawable drawable) {
        this.h = drawable;
        s();
    }

    public void b(int i2) {
        b(i2 != 0 ? androidx.appcompat.a.a.a.b(b(), i2) : null);
    }

    public void b(Drawable drawable) {
        this.i = drawable;
        s();
    }

    private void s() {
        Drawable drawable;
        int i2 = this.e;
        if ((i2 & 2) == 0) {
            drawable = null;
        } else if ((i2 & 1) != 0) {
            drawable = this.i;
            if (drawable == null) {
                drawable = this.h;
            }
        } else {
            drawable = this.h;
        }
        this.f419a.setLogo(drawable);
    }

    public boolean h() {
        return this.f419a.canShowOverflowMenu();
    }

    public boolean i() {
        return this.f419a.isOverflowMenuShowing();
    }

    public boolean j() {
        return this.f419a.isOverflowMenuShowPending();
    }

    public boolean k() {
        return this.f419a.showOverflowMenu();
    }

    public boolean l() {
        return this.f419a.hideOverflowMenu();
    }

    public void m() {
        this.d = true;
    }

    public void a(Menu menu, n.a aVar) {
        if (this.n == null) {
            this.n = new ActionMenuPresenter(this.f419a.getContext());
            this.n.a(R.id.action_menu_presenter);
        }
        this.n.setCallback(aVar);
        this.f419a.setMenu((h) menu, this.n);
    }

    public void n() {
        this.f419a.dismissPopupMenus();
    }

    public int o() {
        return this.e;
    }

    public void c(int i2) {
        View view;
        int i3 = this.e ^ i2;
        this.e = i2;
        if (i3 != 0) {
            if ((i3 & 4) != 0) {
                if ((i2 & 4) != 0) {
                    u();
                }
                t();
            }
            if ((i3 & 3) != 0) {
                s();
            }
            if ((i3 & 8) != 0) {
                if ((i2 & 8) != 0) {
                    this.f419a.setTitle(this.f420b);
                    this.f419a.setSubtitle(this.l);
                } else {
                    this.f419a.setTitle((CharSequence) null);
                    this.f419a.setSubtitle((CharSequence) null);
                }
            }
            if ((i3 & 16) != 0 && (view = this.g) != null) {
                if ((i2 & 16) != 0) {
                    this.f419a.addView(view);
                } else {
                    this.f419a.removeView(view);
                }
            }
        }
    }

    public void a(ak akVar) {
        Toolbar toolbar;
        View view = this.f;
        if (view != null && view.getParent() == (toolbar = this.f419a)) {
            toolbar.removeView(this.f);
        }
        this.f = akVar;
        if (akVar != null && this.o == 2) {
            this.f419a.addView(this.f, 0);
            Toolbar.b bVar = (Toolbar.b) this.f.getLayoutParams();
            bVar.width = -2;
            bVar.height = -2;
            bVar.f172a = BadgeDrawable.BOTTOM_START;
            akVar.setAllowCollapse(true);
        }
    }

    public void a(boolean z) {
        this.f419a.setCollapsible(z);
    }

    public int p() {
        return this.o;
    }

    public void a(View view) {
        View view2 = this.g;
        if (!(view2 == null || (this.e & 16) == 0)) {
            this.f419a.removeView(view2);
        }
        this.g = view;
        if (view != null && (this.e & 16) != 0) {
            this.f419a.addView(this.g);
        }
    }

    public z a(final int i2, long j2) {
        return v.n(this.f419a).a(i2 == 0 ? 1.0f : 0.0f).a(j2).a((aa) new ab() {
            private boolean c = false;

            public void a(View view) {
                as.this.f419a.setVisibility(0);
            }

            public void b(View view) {
                if (!this.c) {
                    as.this.f419a.setVisibility(i2);
                }
            }

            public void c(View view) {
                this.c = true;
            }
        });
    }

    public void c(Drawable drawable) {
        this.j = drawable;
        t();
    }

    private void t() {
        if ((this.e & 4) != 0) {
            Toolbar toolbar = this.f419a;
            Drawable drawable = this.j;
            if (drawable == null) {
                drawable = this.q;
            }
            toolbar.setNavigationIcon(drawable);
            return;
        }
        this.f419a.setNavigationIcon((Drawable) null);
    }

    public void d(CharSequence charSequence) {
        this.m = charSequence;
        u();
    }

    public void f(int i2) {
        d((CharSequence) i2 == 0 ? null : b().getString(i2));
    }

    private void u() {
        if ((this.e & 4) == 0) {
            return;
        }
        if (TextUtils.isEmpty(this.m)) {
            this.f419a.setNavigationContentDescription(this.p);
        } else {
            this.f419a.setNavigationContentDescription(this.m);
        }
    }

    public void d(int i2) {
        this.f419a.setVisibility(i2);
    }

    public void a(n.a aVar, h.a aVar2) {
        this.f419a.setMenuCallbacks(aVar, aVar2);
    }

    public Menu q() {
        return this.f419a.getMenu();
    }
}
