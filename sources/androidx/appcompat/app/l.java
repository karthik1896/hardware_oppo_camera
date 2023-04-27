package androidx.appcompat.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.appcompat.R;
import androidx.appcompat.app.a;
import androidx.appcompat.view.b;
import androidx.appcompat.view.g;
import androidx.appcompat.view.h;
import androidx.appcompat.view.menu.h;
import androidx.appcompat.widget.ActionBarContainer;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.ak;
import androidx.appcompat.widget.z;
import androidx.core.g.aa;
import androidx.core.g.ab;
import androidx.core.g.ac;
import androidx.core.g.v;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* compiled from: WindowDecorActionBar */
public class l extends a implements ActionBarOverlayLayout.a {
    static final /* synthetic */ boolean s = (!l.class.desiredAssertionStatus());
    private static final Interpolator t = new AccelerateInterpolator();
    private static final Interpolator u = new DecelerateInterpolator();
    private boolean A;
    private boolean B;
    private ArrayList<a.b> C = new ArrayList<>();
    private boolean D;
    private int E = 0;
    private boolean F;
    private boolean G = true;
    private boolean H;

    /* renamed from: a  reason: collision with root package name */
    Context f193a;

    /* renamed from: b  reason: collision with root package name */
    ActionBarOverlayLayout f194b;
    ActionBarContainer c;
    z d;
    ActionBarContextView e;
    View f;
    ak g;
    a h;
    b i;
    b.a j;
    boolean k = true;
    boolean l;
    boolean m;
    h n;
    boolean o;
    final aa p = new ab() {
        public void b(View view) {
            if (l.this.k && l.this.f != null) {
                l.this.f.setTranslationY(0.0f);
                l.this.c.setTranslationY(0.0f);
            }
            l.this.c.setVisibility(8);
            l.this.c.setTransitioning(false);
            l lVar = l.this;
            lVar.n = null;
            lVar.h();
            if (l.this.f194b != null) {
                v.s(l.this.f194b);
            }
        }
    };
    final aa q = new ab() {
        public void b(View view) {
            l lVar = l.this;
            lVar.n = null;
            lVar.c.requestLayout();
        }
    };
    final ac r = new ac() {
        public void a(View view) {
            ((View) l.this.c.getParent()).invalidate();
        }
    };
    private Context v;
    private Activity w;
    private Dialog x;
    private ArrayList<Object> y = new ArrayList<>();
    private int z = -1;

    static boolean a(boolean z2, boolean z3, boolean z4) {
        if (z4) {
            return true;
        }
        return !z2 && !z3;
    }

    public void m() {
    }

    public l(Activity activity, boolean z2) {
        this.w = activity;
        View decorView = activity.getWindow().getDecorView();
        a(decorView);
        if (!z2) {
            this.f = decorView.findViewById(16908290);
        }
    }

    public l(Dialog dialog) {
        this.x = dialog;
        a(dialog.getWindow().getDecorView());
    }

    private void a(View view) {
        this.f194b = (ActionBarOverlayLayout) view.findViewById(R.id.decor_content_parent);
        ActionBarOverlayLayout actionBarOverlayLayout = this.f194b;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.setActionBarVisibilityCallback(this);
        }
        this.d = b(view.findViewById(R.id.action_bar));
        this.e = (ActionBarContextView) view.findViewById(R.id.action_context_bar);
        this.c = (ActionBarContainer) view.findViewById(R.id.action_bar_container);
        z zVar = this.d;
        if (zVar == null || this.e == null || this.c == null) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with a compatible window decor layout");
        }
        this.f193a = zVar.b();
        boolean z2 = (this.d.o() & 4) != 0;
        if (z2) {
            this.A = true;
        }
        androidx.appcompat.view.a a2 = androidx.appcompat.view.a.a(this.f193a);
        b(a2.f() || z2);
        k(a2.d());
        TypedArray obtainStyledAttributes = this.f193a.obtainStyledAttributes((AttributeSet) null, R.styleable.ActionBar, R.attr.actionBarStyle, 0);
        if (obtainStyledAttributes.getBoolean(R.styleable.ActionBar_hideOnContentScroll, false)) {
            c(true);
        }
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ActionBar_elevation, 0);
        if (dimensionPixelSize != 0) {
            a((float) dimensionPixelSize);
        }
        obtainStyledAttributes.recycle();
    }

    private z b(View view) {
        if (view instanceof z) {
            return (z) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Can't make a decor toolbar out of ");
        sb.append(view != null ? view.getClass().getSimpleName() : "null");
        throw new IllegalStateException(sb.toString());
    }

    public void a(float f2) {
        v.a((View) this.c, f2);
    }

    public void a(Configuration configuration) {
        k(androidx.appcompat.view.a.a(this.f193a).d());
    }

    private void k(boolean z2) {
        this.D = z2;
        if (!this.D) {
            this.d.a((ak) null);
            this.c.setTabContainer(this.g);
        } else {
            this.c.setTabContainer((ak) null);
            this.d.a(this.g);
        }
        boolean z3 = true;
        boolean z4 = i() == 2;
        ak akVar = this.g;
        if (akVar != null) {
            if (z4) {
                akVar.setVisibility(0);
                ActionBarOverlayLayout actionBarOverlayLayout = this.f194b;
                if (actionBarOverlayLayout != null) {
                    v.s(actionBarOverlayLayout);
                }
            } else {
                akVar.setVisibility(8);
            }
        }
        this.d.a(!this.D && z4);
        ActionBarOverlayLayout actionBarOverlayLayout2 = this.f194b;
        if (this.D || !z4) {
            z3 = false;
        }
        actionBarOverlayLayout2.setHasNonEmbeddedTabs(z3);
    }

    /* access modifiers changed from: package-private */
    public void h() {
        b.a aVar = this.j;
        if (aVar != null) {
            aVar.a(this.i);
            this.i = null;
            this.j = null;
        }
    }

    public void a(int i2) {
        this.E = i2;
    }

    public void e(boolean z2) {
        h hVar;
        this.H = z2;
        if (!z2 && (hVar = this.n) != null) {
            hVar.c();
        }
    }

    public void f(boolean z2) {
        if (z2 != this.B) {
            this.B = z2;
            int size = this.C.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.C.get(i2).a(z2);
            }
        }
    }

    public void a(boolean z2) {
        a(z2 ? 4 : 0, 4);
    }

    public void b(boolean z2) {
        this.d.b(z2);
    }

    public void a(CharSequence charSequence) {
        this.d.a(charSequence);
    }

    public void a(int i2, int i3) {
        int o2 = this.d.o();
        if ((i3 & 4) != 0) {
            this.A = true;
        }
        this.d.c((i2 & i3) | ((~i3) & o2));
    }

    public int i() {
        return this.d.p();
    }

    public int a() {
        return this.d.o();
    }

    public b a(b.a aVar) {
        a aVar2 = this.h;
        if (aVar2 != null) {
            aVar2.c();
        }
        this.f194b.setHideOnContentScrollEnabled(false);
        this.e.c();
        a aVar3 = new a(this.e.getContext(), aVar);
        if (!aVar3.e()) {
            return null;
        }
        this.h = aVar3;
        aVar3.d();
        this.e.a(aVar3);
        j(true);
        this.e.sendAccessibilityEvent(32);
        return aVar3;
    }

    public void g(boolean z2) {
        this.k = z2;
    }

    private void n() {
        if (!this.F) {
            this.F = true;
            ActionBarOverlayLayout actionBarOverlayLayout = this.f194b;
            if (actionBarOverlayLayout != null) {
                actionBarOverlayLayout.setShowingForActionMode(true);
            }
            l(false);
        }
    }

    public void j() {
        if (this.m) {
            this.m = false;
            l(true);
        }
    }

    private void o() {
        if (this.F) {
            this.F = false;
            ActionBarOverlayLayout actionBarOverlayLayout = this.f194b;
            if (actionBarOverlayLayout != null) {
                actionBarOverlayLayout.setShowingForActionMode(false);
            }
            l(false);
        }
    }

    public void k() {
        if (!this.m) {
            this.m = true;
            l(true);
        }
    }

    public void c(boolean z2) {
        if (!z2 || this.f194b.a()) {
            this.o = z2;
            this.f194b.setHideOnContentScrollEnabled(z2);
            return;
        }
        throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
    }

    private void l(boolean z2) {
        if (a(this.l, this.m, this.F)) {
            if (!this.G) {
                this.G = true;
                h(z2);
            }
        } else if (this.G) {
            this.G = false;
            i(z2);
        }
    }

    public void h(boolean z2) {
        View view;
        View view2;
        h hVar = this.n;
        if (hVar != null) {
            hVar.c();
        }
        this.c.setVisibility(0);
        if (this.E != 0 || (!this.H && !z2)) {
            this.c.setAlpha(1.0f);
            this.c.setTranslationY(0.0f);
            if (this.k && (view = this.f) != null) {
                view.setTranslationY(0.0f);
            }
            this.q.b((View) null);
        } else {
            this.c.setTranslationY(0.0f);
            float f2 = (float) (-this.c.getHeight());
            if (z2) {
                int[] iArr = {0, 0};
                this.c.getLocationInWindow(iArr);
                f2 -= (float) iArr[1];
            }
            this.c.setTranslationY(f2);
            h hVar2 = new h();
            androidx.core.g.z b2 = v.n(this.c).b(0.0f);
            b2.a(this.r);
            hVar2.a(b2);
            if (this.k && (view2 = this.f) != null) {
                view2.setTranslationY(f2);
                hVar2.a(v.n(this.f).b(0.0f));
            }
            hVar2.a(u);
            hVar2.a(250);
            hVar2.a(this.q);
            this.n = hVar2;
            hVar2.a();
        }
        ActionBarOverlayLayout actionBarOverlayLayout = this.f194b;
        if (actionBarOverlayLayout != null) {
            v.s(actionBarOverlayLayout);
        }
    }

    public void i(boolean z2) {
        View view;
        h hVar = this.n;
        if (hVar != null) {
            hVar.c();
        }
        if (this.E != 0 || (!this.H && !z2)) {
            this.p.b((View) null);
            return;
        }
        this.c.setAlpha(1.0f);
        this.c.setTransitioning(true);
        h hVar2 = new h();
        float f2 = (float) (-this.c.getHeight());
        if (z2) {
            int[] iArr = {0, 0};
            this.c.getLocationInWindow(iArr);
            f2 -= (float) iArr[1];
        }
        androidx.core.g.z b2 = v.n(this.c).b(f2);
        b2.a(this.r);
        hVar2.a(b2);
        if (this.k && (view = this.f) != null) {
            hVar2.a(v.n(view).b(f2));
        }
        hVar2.a(t);
        hVar2.a(250);
        hVar2.a(this.p);
        this.n = hVar2;
        hVar2.a();
    }

    public void j(boolean z2) {
        androidx.core.g.z zVar;
        androidx.core.g.z zVar2;
        if (z2) {
            n();
        } else {
            o();
        }
        if (p()) {
            if (z2) {
                zVar = this.d.a(4, 100);
                zVar2 = this.e.a(0, 200);
            } else {
                zVar2 = this.d.a(0, 200);
                zVar = this.e.a(8, 100);
            }
            h hVar = new h();
            hVar.a(zVar, zVar2);
            hVar.a();
        } else if (z2) {
            this.d.d(4);
            this.e.setVisibility(0);
        } else {
            this.d.d(0);
            this.e.setVisibility(8);
        }
    }

    private boolean p() {
        return v.A(this.c);
    }

    public Context b() {
        if (this.v == null) {
            TypedValue typedValue = new TypedValue();
            this.f193a.getTheme().resolveAttribute(R.attr.actionBarWidgetTheme, typedValue, true);
            int i2 = typedValue.resourceId;
            if (i2 != 0) {
                this.v = new ContextThemeWrapper(this.f193a, i2);
            } else {
                this.v = this.f193a;
            }
        }
        return this.v;
    }

    public void l() {
        h hVar = this.n;
        if (hVar != null) {
            hVar.c();
            this.n = null;
        }
    }

    public boolean f() {
        z zVar = this.d;
        if (zVar == null || !zVar.c()) {
            return false;
        }
        this.d.d();
        return true;
    }

    /* compiled from: WindowDecorActionBar */
    public class a extends b implements h.a {

        /* renamed from: b  reason: collision with root package name */
        private final Context f199b;
        private final androidx.appcompat.view.menu.h c;
        private b.a d;
        private WeakReference<View> e;

        public a(Context context, b.a aVar) {
            this.f199b = context;
            this.d = aVar;
            this.c = new androidx.appcompat.view.menu.h(context).setDefaultShowAsAction(1);
            this.c.setCallback(this);
        }

        public MenuInflater a() {
            return new g(this.f199b);
        }

        public Menu b() {
            return this.c;
        }

        public void c() {
            if (l.this.h == this) {
                if (!l.a(l.this.l, l.this.m, false)) {
                    l lVar = l.this;
                    lVar.i = this;
                    lVar.j = this.d;
                } else {
                    this.d.a(this);
                }
                this.d = null;
                l.this.j(false);
                l.this.e.b();
                l.this.d.a().sendAccessibilityEvent(32);
                l.this.f194b.setHideOnContentScrollEnabled(l.this.o);
                l.this.h = null;
            }
        }

        public void d() {
            if (l.this.h == this) {
                this.c.stopDispatchingItemsChanged();
                try {
                    this.d.b(this, this.c);
                } finally {
                    this.c.startDispatchingItemsChanged();
                }
            }
        }

        public boolean e() {
            this.c.stopDispatchingItemsChanged();
            try {
                return this.d.a((b) this, (Menu) this.c);
            } finally {
                this.c.startDispatchingItemsChanged();
            }
        }

        public void a(View view) {
            l.this.e.setCustomView(view);
            this.e = new WeakReference<>(view);
        }

        public void a(CharSequence charSequence) {
            l.this.e.setSubtitle(charSequence);
        }

        public void b(CharSequence charSequence) {
            l.this.e.setTitle(charSequence);
        }

        public void a(int i) {
            b((CharSequence) l.this.f193a.getResources().getString(i));
        }

        public void b(int i) {
            a((CharSequence) l.this.f193a.getResources().getString(i));
        }

        public CharSequence f() {
            return l.this.e.getTitle();
        }

        public CharSequence g() {
            return l.this.e.getSubtitle();
        }

        public void a(boolean z) {
            super.a(z);
            l.this.e.setTitleOptional(z);
        }

        public boolean h() {
            return l.this.e.d();
        }

        public View i() {
            WeakReference<View> weakReference = this.e;
            if (weakReference != null) {
                return (View) weakReference.get();
            }
            return null;
        }

        public boolean onMenuItemSelected(androidx.appcompat.view.menu.h hVar, MenuItem menuItem) {
            b.a aVar = this.d;
            if (aVar != null) {
                return aVar.a((b) this, menuItem);
            }
            return false;
        }

        public void onMenuModeChange(androidx.appcompat.view.menu.h hVar) {
            if (this.d != null) {
                d();
                l.this.e.a();
            }
        }
    }

    public void d(boolean z2) {
        if (!this.A) {
            a(z2);
        }
    }

    public boolean a(int i2, KeyEvent keyEvent) {
        Menu b2;
        a aVar = this.h;
        if (aVar == null || (b2 = aVar.b()) == null) {
            return false;
        }
        boolean z2 = true;
        if (KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() == 1) {
            z2 = false;
        }
        b2.setQwertyMode(z2);
        return b2.performShortcut(i2, keyEvent, 0);
    }
}
