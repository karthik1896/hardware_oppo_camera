package androidx.appcompat.app;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.app.UiModeManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.KeyboardShortcutGroup;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.appcompat.view.b;
import androidx.appcompat.view.f;
import androidx.appcompat.view.menu.h;
import androidx.appcompat.view.menu.n;
import androidx.appcompat.view.menu.o;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ContentFrameLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.ac;
import androidx.appcompat.widget.ar;
import androidx.appcompat.widget.aw;
import androidx.appcompat.widget.ax;
import androidx.appcompat.widget.i;
import androidx.appcompat.widget.y;
import androidx.collection.ArrayMap;
import androidx.core.g.aa;
import androidx.core.g.ab;
import androidx.core.g.ad;
import androidx.core.g.d;
import androidx.core.g.q;
import androidx.core.g.v;
import androidx.core.g.z;
import androidx.lifecycle.e;
import com.crunchfish.touchless_a3d.TouchlessA3D;
import java.lang.Thread;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;

class AppCompatDelegateImpl extends e implements LayoutInflater.Factory2, h.a {
    private static final Map<Class<?>, Integer> t = new ArrayMap();
    private static final boolean u = (Build.VERSION.SDK_INT < 21);
    private static final int[] v = {16842836};
    private static boolean w = true;
    private static final boolean x;
    private y A;
    private a B;
    private h C;
    private boolean D;
    private boolean E;
    private ViewGroup F;
    private TextView G;
    private View H;
    private boolean I;
    private boolean J;
    private boolean K;
    private PanelFeatureState[] L;
    private PanelFeatureState M;
    private boolean N;
    private boolean O;
    private boolean P;
    private boolean Q;
    private int R;
    private int S;
    private boolean T;
    private boolean U;
    private e V;
    private e W;
    private final Runnable X;
    private boolean Y;
    private Rect Z;

    /* renamed from: a  reason: collision with root package name */
    final Object f146a;
    private Rect aa;
    private AppCompatViewInflater ab;

    /* renamed from: b  reason: collision with root package name */
    final Context f147b;
    Window c;
    final d d;
    a e;
    MenuInflater f;
    androidx.appcompat.view.b g;
    ActionBarContextView h;
    PopupWindow i;
    Runnable j;
    z k;
    boolean l;
    boolean m;
    boolean n;
    boolean o;
    boolean p;
    boolean q;
    boolean r;
    int s;
    private c y;
    private CharSequence z;

    /* access modifiers changed from: package-private */
    public void a(ViewGroup viewGroup) {
    }

    static {
        boolean z2 = false;
        if (Build.VERSION.SDK_INT >= 21 && Build.VERSION.SDK_INT <= 25) {
            z2 = true;
        }
        x = z2;
        if (u && !w) {
            final Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
            Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
                public void uncaughtException(Thread thread, Throwable th) {
                    if (a(th)) {
                        Resources.NotFoundException notFoundException = new Resources.NotFoundException(th.getMessage() + ". If the resource you are trying to use is a vector resource, you may be referencing it in an unsupported way. See AppCompatDelegate.setCompatVectorFromResourcesEnabled() for more info.");
                        notFoundException.initCause(th.getCause());
                        notFoundException.setStackTrace(th.getStackTrace());
                        defaultUncaughtExceptionHandler.uncaughtException(thread, notFoundException);
                        return;
                    }
                    defaultUncaughtExceptionHandler.uncaughtException(thread, th);
                }

                private boolean a(Throwable th) {
                    String message;
                    if (!(th instanceof Resources.NotFoundException) || (message = th.getMessage()) == null) {
                        return false;
                    }
                    if (message.contains("drawable") || message.contains("Drawable")) {
                        return true;
                    }
                    return false;
                }
            });
        }
    }

    AppCompatDelegateImpl(Activity activity, d dVar) {
        this(activity, (Window) null, dVar, activity);
    }

    AppCompatDelegateImpl(Dialog dialog, d dVar) {
        this(dialog.getContext(), dialog.getWindow(), dVar, dialog);
    }

    private AppCompatDelegateImpl(Context context, Window window, d dVar, Object obj) {
        Integer num;
        c B2;
        this.k = null;
        this.D = true;
        this.R = -100;
        this.X = new Runnable() {
            public void run() {
                if ((AppCompatDelegateImpl.this.s & 1) != 0) {
                    AppCompatDelegateImpl.this.h(0);
                }
                if ((AppCompatDelegateImpl.this.s & 4096) != 0) {
                    AppCompatDelegateImpl.this.h(108);
                }
                AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
                appCompatDelegateImpl.r = false;
                appCompatDelegateImpl.s = 0;
            }
        };
        this.f147b = context;
        this.d = dVar;
        this.f146a = obj;
        if (this.R == -100 && (this.f146a instanceof Dialog) && (B2 = B()) != null) {
            this.R = B2.h().i();
        }
        if (this.R == -100 && (num = t.get(this.f146a.getClass())) != null) {
            this.R = num.intValue();
            t.remove(this.f146a.getClass());
        }
        if (window != null) {
            a(window);
        }
        i.a();
    }

    public void a(Context context) {
        a(false);
        this.O = true;
    }

    public void a(Bundle bundle) {
        this.O = true;
        a(false);
        x();
        Object obj = this.f146a;
        if (obj instanceof Activity) {
            String str = null;
            try {
                str = androidx.core.app.f.b((Activity) obj);
            } catch (IllegalArgumentException unused) {
            }
            if (str != null) {
                a k2 = k();
                if (k2 == null) {
                    this.Y = true;
                } else {
                    k2.d(true);
                }
            }
        }
        this.P = true;
    }

    public void b(Bundle bundle) {
        y();
    }

    public a a() {
        v();
        return this.e;
    }

    /* access modifiers changed from: package-private */
    public final a k() {
        return this.e;
    }

    /* access modifiers changed from: package-private */
    public final Window.Callback l() {
        return this.c.getCallback();
    }

    private void v() {
        y();
        if (this.l && this.e == null) {
            Object obj = this.f146a;
            if (obj instanceof Activity) {
                this.e = new l((Activity) obj, this.m);
            } else if (obj instanceof Dialog) {
                this.e = new l((Dialog) obj);
            }
            a aVar = this.e;
            if (aVar != null) {
                aVar.d(this.Y);
            }
        }
    }

    public void a(Toolbar toolbar) {
        if (this.f146a instanceof Activity) {
            a a2 = a();
            if (!(a2 instanceof l)) {
                this.f = null;
                if (a2 != null) {
                    a2.g();
                }
                if (toolbar != null) {
                    i iVar = new i(toolbar, n(), this.y);
                    this.e = iVar;
                    this.c.setCallback(iVar.h());
                } else {
                    this.e = null;
                    this.c.setCallback(this.y);
                }
                f();
                return;
            }
            throw new IllegalStateException("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_SUPPORT_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.");
        }
    }

    /* access modifiers changed from: package-private */
    public final Context m() {
        a a2 = a();
        Context b2 = a2 != null ? a2.b() : null;
        return b2 == null ? this.f147b : b2;
    }

    public MenuInflater b() {
        if (this.f == null) {
            v();
            a aVar = this.e;
            this.f = new androidx.appcompat.view.g(aVar != null ? aVar.b() : this.f147b);
        }
        return this.f;
    }

    public <T extends View> T b(int i2) {
        y();
        return this.c.findViewById(i2);
    }

    public void a(Configuration configuration) {
        a a2;
        if (this.l && this.E && (a2 = a()) != null) {
            a2.a(configuration);
        }
        i.b().a(this.f147b);
        a(false);
    }

    public void c() {
        this.Q = true;
        t();
        a((e) this);
    }

    public void d() {
        this.Q = false;
        b((e) this);
        a a2 = a();
        if (a2 != null) {
            a2.e(false);
        }
        if (this.f146a instanceof Dialog) {
            w();
        }
    }

    public void e() {
        a a2 = a();
        if (a2 != null) {
            a2.e(true);
        }
    }

    public void a(View view) {
        y();
        ViewGroup viewGroup = (ViewGroup) this.F.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        this.y.a().onContentChanged();
    }

    public void c(int i2) {
        y();
        ViewGroup viewGroup = (ViewGroup) this.F.findViewById(16908290);
        viewGroup.removeAllViews();
        LayoutInflater.from(this.f147b).inflate(i2, viewGroup);
        this.y.a().onContentChanged();
    }

    public void a(View view, ViewGroup.LayoutParams layoutParams) {
        y();
        ViewGroup viewGroup = (ViewGroup) this.F.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        this.y.a().onContentChanged();
    }

    public void b(View view, ViewGroup.LayoutParams layoutParams) {
        y();
        ((ViewGroup) this.F.findViewById(16908290)).addView(view, layoutParams);
        this.y.a().onContentChanged();
    }

    public void c(Bundle bundle) {
        if (this.R != -100) {
            t.put(this.f146a.getClass(), Integer.valueOf(this.R));
        }
    }

    public void g() {
        b((e) this);
        if (this.r) {
            this.c.getDecorView().removeCallbacks(this.X);
        }
        this.Q = false;
        this.q = true;
        a aVar = this.e;
        if (aVar != null) {
            aVar.g();
        }
        w();
    }

    private void w() {
        e eVar = this.V;
        if (eVar != null) {
            eVar.e();
        }
        e eVar2 = this.W;
        if (eVar2 != null) {
            eVar2.e();
        }
    }

    public void a(int i2) {
        this.S = i2;
    }

    private void x() {
        if (this.c == null) {
            Object obj = this.f146a;
            if (obj instanceof Activity) {
                a(((Activity) obj).getWindow());
            }
        }
        if (this.c == null) {
            throw new IllegalStateException("We have not been given a Window");
        }
    }

    private void a(Window window) {
        if (this.c == null) {
            Window.Callback callback = window.getCallback();
            if (!(callback instanceof c)) {
                this.y = new c(callback);
                window.setCallback(this.y);
                ar a2 = ar.a(this.f147b, (AttributeSet) null, v);
                Drawable b2 = a2.b(0);
                if (b2 != null) {
                    window.setBackgroundDrawable(b2);
                }
                a2.b();
                this.c = window;
                return;
            }
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        throw new IllegalStateException("AppCompat has already installed itself into the Window");
    }

    private void y() {
        if (!this.E) {
            this.F = z();
            CharSequence n2 = n();
            if (!TextUtils.isEmpty(n2)) {
                y yVar = this.A;
                if (yVar != null) {
                    yVar.setWindowTitle(n2);
                } else if (k() != null) {
                    k().a(n2);
                } else {
                    TextView textView = this.G;
                    if (textView != null) {
                        textView.setText(n2);
                    }
                }
            }
            A();
            a(this.F);
            this.E = true;
            PanelFeatureState a2 = a(0, false);
            if (this.q) {
                return;
            }
            if (a2 == null || a2.j == null) {
                k(108);
            }
        }
    }

    private ViewGroup z() {
        ViewGroup viewGroup;
        Context context;
        TypedArray obtainStyledAttributes = this.f147b.obtainStyledAttributes(R.styleable.AppCompatTheme);
        if (obtainStyledAttributes.hasValue(R.styleable.AppCompatTheme_windowActionBar)) {
            if (obtainStyledAttributes.getBoolean(R.styleable.AppCompatTheme_windowNoTitle, false)) {
                d(1);
            } else if (obtainStyledAttributes.getBoolean(R.styleable.AppCompatTheme_windowActionBar, false)) {
                d(108);
            }
            if (obtainStyledAttributes.getBoolean(R.styleable.AppCompatTheme_windowActionBarOverlay, false)) {
                d(109);
            }
            if (obtainStyledAttributes.getBoolean(R.styleable.AppCompatTheme_windowActionModeOverlay, false)) {
                d(10);
            }
            this.o = obtainStyledAttributes.getBoolean(R.styleable.AppCompatTheme_android_windowIsFloating, false);
            obtainStyledAttributes.recycle();
            x();
            this.c.getDecorView();
            LayoutInflater from = LayoutInflater.from(this.f147b);
            if (this.p) {
                if (this.n) {
                    viewGroup = (ViewGroup) from.inflate(R.layout.abc_screen_simple_overlay_action_mode, (ViewGroup) null);
                } else {
                    viewGroup = (ViewGroup) from.inflate(R.layout.abc_screen_simple, (ViewGroup) null);
                }
                if (Build.VERSION.SDK_INT >= 21) {
                    v.a((View) viewGroup, (q) new q() {
                        public ad onApplyWindowInsets(View view, ad adVar) {
                            int b2 = adVar.b();
                            int i = AppCompatDelegateImpl.this.i(b2);
                            if (b2 != i) {
                                adVar = adVar.a(adVar.a(), i, adVar.c(), adVar.d());
                            }
                            return v.a(view, adVar);
                        }
                    });
                } else {
                    ((ac) viewGroup).setOnFitSystemWindowsListener(new ac.a() {
                        public void a(Rect rect) {
                            rect.top = AppCompatDelegateImpl.this.i(rect.top);
                        }
                    });
                }
            } else if (this.o) {
                viewGroup = (ViewGroup) from.inflate(R.layout.abc_dialog_title_material, (ViewGroup) null);
                this.m = false;
                this.l = false;
            } else if (this.l) {
                TypedValue typedValue = new TypedValue();
                this.f147b.getTheme().resolveAttribute(R.attr.actionBarTheme, typedValue, true);
                if (typedValue.resourceId != 0) {
                    context = new androidx.appcompat.view.d(this.f147b, typedValue.resourceId);
                } else {
                    context = this.f147b;
                }
                viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.abc_screen_toolbar, (ViewGroup) null);
                this.A = (y) viewGroup.findViewById(R.id.decor_content_parent);
                this.A.setWindowCallback(l());
                if (this.m) {
                    this.A.a(109);
                }
                if (this.I) {
                    this.A.a(2);
                }
                if (this.J) {
                    this.A.a(5);
                }
            } else {
                viewGroup = null;
            }
            if (viewGroup != null) {
                if (this.A == null) {
                    this.G = (TextView) viewGroup.findViewById(R.id.title);
                }
                ax.b(viewGroup);
                ContentFrameLayout contentFrameLayout = (ContentFrameLayout) viewGroup.findViewById(R.id.action_bar_activity_content);
                ViewGroup viewGroup2 = (ViewGroup) this.c.findViewById(16908290);
                if (viewGroup2 != null) {
                    while (viewGroup2.getChildCount() > 0) {
                        View childAt = viewGroup2.getChildAt(0);
                        viewGroup2.removeViewAt(0);
                        contentFrameLayout.addView(childAt);
                    }
                    viewGroup2.setId(-1);
                    contentFrameLayout.setId(16908290);
                    if (viewGroup2 instanceof FrameLayout) {
                        ((FrameLayout) viewGroup2).setForeground((Drawable) null);
                    }
                }
                this.c.setContentView(viewGroup);
                contentFrameLayout.setAttachListener(new ContentFrameLayout.a() {
                    public void a() {
                    }

                    public void b() {
                        AppCompatDelegateImpl.this.s();
                    }
                });
                return viewGroup;
            }
            throw new IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + this.l + ", windowActionBarOverlay: " + this.m + ", android:windowIsFloating: " + this.o + ", windowActionModeOverlay: " + this.n + ", windowNoTitle: " + this.p + " }");
        }
        obtainStyledAttributes.recycle();
        throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
    }

    private void A() {
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) this.F.findViewById(16908290);
        View decorView = this.c.getDecorView();
        contentFrameLayout.a(decorView.getPaddingLeft(), decorView.getPaddingTop(), decorView.getPaddingRight(), decorView.getPaddingBottom());
        TypedArray obtainStyledAttributes = this.f147b.obtainStyledAttributes(R.styleable.AppCompatTheme);
        obtainStyledAttributes.getValue(R.styleable.AppCompatTheme_windowMinWidthMajor, contentFrameLayout.getMinWidthMajor());
        obtainStyledAttributes.getValue(R.styleable.AppCompatTheme_windowMinWidthMinor, contentFrameLayout.getMinWidthMinor());
        if (obtainStyledAttributes.hasValue(R.styleable.AppCompatTheme_windowFixedWidthMajor)) {
            obtainStyledAttributes.getValue(R.styleable.AppCompatTheme_windowFixedWidthMajor, contentFrameLayout.getFixedWidthMajor());
        }
        if (obtainStyledAttributes.hasValue(R.styleable.AppCompatTheme_windowFixedWidthMinor)) {
            obtainStyledAttributes.getValue(R.styleable.AppCompatTheme_windowFixedWidthMinor, contentFrameLayout.getFixedWidthMinor());
        }
        if (obtainStyledAttributes.hasValue(R.styleable.AppCompatTheme_windowFixedHeightMajor)) {
            obtainStyledAttributes.getValue(R.styleable.AppCompatTheme_windowFixedHeightMajor, contentFrameLayout.getFixedHeightMajor());
        }
        if (obtainStyledAttributes.hasValue(R.styleable.AppCompatTheme_windowFixedHeightMinor)) {
            obtainStyledAttributes.getValue(R.styleable.AppCompatTheme_windowFixedHeightMinor, contentFrameLayout.getFixedHeightMinor());
        }
        obtainStyledAttributes.recycle();
        contentFrameLayout.requestLayout();
    }

    public boolean d(int i2) {
        int l2 = l(i2);
        if (this.p && l2 == 108) {
            return false;
        }
        if (this.l && l2 == 1) {
            this.l = false;
        }
        if (l2 == 1) {
            C();
            this.p = true;
            return true;
        } else if (l2 == 2) {
            C();
            this.I = true;
            return true;
        } else if (l2 == 5) {
            C();
            this.J = true;
            return true;
        } else if (l2 == 10) {
            C();
            this.n = true;
            return true;
        } else if (l2 == 108) {
            C();
            this.l = true;
            return true;
        } else if (l2 != 109) {
            return this.c.requestFeature(l2);
        } else {
            C();
            this.m = true;
            return true;
        }
    }

    public final void a(CharSequence charSequence) {
        this.z = charSequence;
        y yVar = this.A;
        if (yVar != null) {
            yVar.setWindowTitle(charSequence);
        } else if (k() != null) {
            k().a(charSequence);
        } else {
            TextView textView = this.G;
            if (textView != null) {
                textView.setText(charSequence);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final CharSequence n() {
        Object obj = this.f146a;
        if (obj instanceof Activity) {
            return ((Activity) obj).getTitle();
        }
        return this.z;
    }

    /* access modifiers changed from: package-private */
    public void e(int i2) {
        if (i2 == 108) {
            a a2 = a();
            if (a2 != null) {
                a2.f(false);
            }
        } else if (i2 == 0) {
            PanelFeatureState a3 = a(i2, true);
            if (a3.o) {
                a(a3, false);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void f(int i2) {
        a a2;
        if (i2 == 108 && (a2 = a()) != null) {
            a2.f(true);
        }
    }

    public boolean onMenuItemSelected(androidx.appcompat.view.menu.h hVar, MenuItem menuItem) {
        PanelFeatureState a2;
        Window.Callback l2 = l();
        if (l2 == null || this.q || (a2 = a((Menu) hVar.getRootMenu())) == null) {
            return false;
        }
        return l2.onMenuItemSelected(a2.f156a, menuItem);
    }

    public void onMenuModeChange(androidx.appcompat.view.menu.h hVar) {
        a(hVar, true);
    }

    public androidx.appcompat.view.b a(b.a aVar) {
        d dVar;
        if (aVar != null) {
            androidx.appcompat.view.b bVar = this.g;
            if (bVar != null) {
                bVar.c();
            }
            b bVar2 = new b(aVar);
            a a2 = a();
            if (a2 != null) {
                this.g = a2.a((b.a) bVar2);
                androidx.appcompat.view.b bVar3 = this.g;
                if (!(bVar3 == null || (dVar = this.d) == null)) {
                    dVar.onSupportActionModeStarted(bVar3);
                }
            }
            if (this.g == null) {
                this.g = b((b.a) bVar2);
            }
            return this.g;
        }
        throw new IllegalArgumentException("ActionMode callback can not be null.");
    }

    public void f() {
        a a2 = a();
        if (a2 == null || !a2.e()) {
            k(0);
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0025  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0029  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public androidx.appcompat.view.b b(androidx.appcompat.view.b.a r8) {
        /*
            r7 = this;
            r7.q()
            androidx.appcompat.view.b r0 = r7.g
            if (r0 == 0) goto L_0x000a
            r0.c()
        L_0x000a:
            boolean r0 = r8 instanceof androidx.appcompat.app.AppCompatDelegateImpl.b
            if (r0 != 0) goto L_0x0014
            androidx.appcompat.app.AppCompatDelegateImpl$b r0 = new androidx.appcompat.app.AppCompatDelegateImpl$b
            r0.<init>(r8)
            r8 = r0
        L_0x0014:
            androidx.appcompat.app.d r0 = r7.d
            r1 = 0
            if (r0 == 0) goto L_0x0022
            boolean r2 = r7.q
            if (r2 != 0) goto L_0x0022
            androidx.appcompat.view.b r0 = r0.onWindowStartingSupportActionMode(r8)     // Catch:{ AbstractMethodError -> 0x0022 }
            goto L_0x0023
        L_0x0022:
            r0 = r1
        L_0x0023:
            if (r0 == 0) goto L_0x0029
            r7.g = r0
            goto L_0x0166
        L_0x0029:
            androidx.appcompat.widget.ActionBarContextView r0 = r7.h
            r2 = 0
            r3 = 1
            if (r0 != 0) goto L_0x00d6
            boolean r0 = r7.o
            if (r0 == 0) goto L_0x00b7
            android.util.TypedValue r0 = new android.util.TypedValue
            r0.<init>()
            android.content.Context r4 = r7.f147b
            android.content.res.Resources$Theme r4 = r4.getTheme()
            int r5 = androidx.appcompat.R.attr.actionBarTheme
            r4.resolveAttribute(r5, r0, r3)
            int r5 = r0.resourceId
            if (r5 == 0) goto L_0x0068
            android.content.Context r5 = r7.f147b
            android.content.res.Resources r5 = r5.getResources()
            android.content.res.Resources$Theme r5 = r5.newTheme()
            r5.setTo(r4)
            int r4 = r0.resourceId
            r5.applyStyle(r4, r3)
            androidx.appcompat.view.d r4 = new androidx.appcompat.view.d
            android.content.Context r6 = r7.f147b
            r4.<init>((android.content.Context) r6, (int) r2)
            android.content.res.Resources$Theme r6 = r4.getTheme()
            r6.setTo(r5)
            goto L_0x006a
        L_0x0068:
            android.content.Context r4 = r7.f147b
        L_0x006a:
            androidx.appcompat.widget.ActionBarContextView r5 = new androidx.appcompat.widget.ActionBarContextView
            r5.<init>(r4)
            r7.h = r5
            android.widget.PopupWindow r5 = new android.widget.PopupWindow
            int r6 = androidx.appcompat.R.attr.actionModePopupWindowStyle
            r5.<init>(r4, r1, r6)
            r7.i = r5
            android.widget.PopupWindow r5 = r7.i
            r6 = 2
            androidx.core.widget.h.a((android.widget.PopupWindow) r5, (int) r6)
            android.widget.PopupWindow r5 = r7.i
            androidx.appcompat.widget.ActionBarContextView r6 = r7.h
            r5.setContentView(r6)
            android.widget.PopupWindow r5 = r7.i
            r6 = -1
            r5.setWidth(r6)
            android.content.res.Resources$Theme r5 = r4.getTheme()
            int r6 = androidx.appcompat.R.attr.actionBarSize
            r5.resolveAttribute(r6, r0, r3)
            int r0 = r0.data
            android.content.res.Resources r4 = r4.getResources()
            android.util.DisplayMetrics r4 = r4.getDisplayMetrics()
            int r0 = android.util.TypedValue.complexToDimensionPixelSize(r0, r4)
            androidx.appcompat.widget.ActionBarContextView r4 = r7.h
            r4.setContentHeight(r0)
            android.widget.PopupWindow r0 = r7.i
            r4 = -2
            r0.setHeight(r4)
            androidx.appcompat.app.AppCompatDelegateImpl$6 r0 = new androidx.appcompat.app.AppCompatDelegateImpl$6
            r0.<init>()
            r7.j = r0
            goto L_0x00d6
        L_0x00b7:
            android.view.ViewGroup r0 = r7.F
            int r4 = androidx.appcompat.R.id.action_mode_bar_stub
            android.view.View r0 = r0.findViewById(r4)
            androidx.appcompat.widget.ViewStubCompat r0 = (androidx.appcompat.widget.ViewStubCompat) r0
            if (r0 == 0) goto L_0x00d6
            android.content.Context r4 = r7.m()
            android.view.LayoutInflater r4 = android.view.LayoutInflater.from(r4)
            r0.setLayoutInflater(r4)
            android.view.View r0 = r0.a()
            androidx.appcompat.widget.ActionBarContextView r0 = (androidx.appcompat.widget.ActionBarContextView) r0
            r7.h = r0
        L_0x00d6:
            androidx.appcompat.widget.ActionBarContextView r0 = r7.h
            if (r0 == 0) goto L_0x0166
            r7.q()
            androidx.appcompat.widget.ActionBarContextView r0 = r7.h
            r0.c()
            androidx.appcompat.view.e r0 = new androidx.appcompat.view.e
            androidx.appcompat.widget.ActionBarContextView r4 = r7.h
            android.content.Context r4 = r4.getContext()
            androidx.appcompat.widget.ActionBarContextView r5 = r7.h
            android.widget.PopupWindow r6 = r7.i
            if (r6 != 0) goto L_0x00f1
            goto L_0x00f2
        L_0x00f1:
            r3 = r2
        L_0x00f2:
            r0.<init>(r4, r5, r8, r3)
            android.view.Menu r3 = r0.b()
            boolean r8 = r8.a((androidx.appcompat.view.b) r0, (android.view.Menu) r3)
            if (r8 == 0) goto L_0x0164
            r0.d()
            androidx.appcompat.widget.ActionBarContextView r8 = r7.h
            r8.a(r0)
            r7.g = r0
            boolean r8 = r7.o()
            r0 = 1065353216(0x3f800000, float:1.0)
            if (r8 == 0) goto L_0x012e
            androidx.appcompat.widget.ActionBarContextView r8 = r7.h
            r1 = 0
            r8.setAlpha(r1)
            androidx.appcompat.widget.ActionBarContextView r8 = r7.h
            androidx.core.g.z r8 = androidx.core.g.v.n(r8)
            androidx.core.g.z r8 = r8.a((float) r0)
            r7.k = r8
            androidx.core.g.z r8 = r7.k
            androidx.appcompat.app.AppCompatDelegateImpl$7 r0 = new androidx.appcompat.app.AppCompatDelegateImpl$7
            r0.<init>()
            r8.a((androidx.core.g.aa) r0)
            goto L_0x0154
        L_0x012e:
            androidx.appcompat.widget.ActionBarContextView r8 = r7.h
            r8.setAlpha(r0)
            androidx.appcompat.widget.ActionBarContextView r8 = r7.h
            r8.setVisibility(r2)
            androidx.appcompat.widget.ActionBarContextView r8 = r7.h
            r0 = 32
            r8.sendAccessibilityEvent(r0)
            androidx.appcompat.widget.ActionBarContextView r8 = r7.h
            android.view.ViewParent r8 = r8.getParent()
            boolean r8 = r8 instanceof android.view.View
            if (r8 == 0) goto L_0x0154
            androidx.appcompat.widget.ActionBarContextView r8 = r7.h
            android.view.ViewParent r8 = r8.getParent()
            android.view.View r8 = (android.view.View) r8
            androidx.core.g.v.s(r8)
        L_0x0154:
            android.widget.PopupWindow r8 = r7.i
            if (r8 == 0) goto L_0x0166
            android.view.Window r8 = r7.c
            android.view.View r8 = r8.getDecorView()
            java.lang.Runnable r0 = r7.j
            r8.post(r0)
            goto L_0x0166
        L_0x0164:
            r7.g = r1
        L_0x0166:
            androidx.appcompat.view.b r8 = r7.g
            if (r8 == 0) goto L_0x0171
            androidx.appcompat.app.d r0 = r7.d
            if (r0 == 0) goto L_0x0171
            r0.onSupportActionModeStarted(r8)
        L_0x0171:
            androidx.appcompat.view.b r8 = r7.g
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.b(androidx.appcompat.view.b$a):androidx.appcompat.view.b");
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r1.F;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean o() {
        /*
            r1 = this;
            boolean r0 = r1.E
            if (r0 == 0) goto L_0x0010
            android.view.ViewGroup r0 = r1.F
            if (r0 == 0) goto L_0x0010
            boolean r0 = androidx.core.g.v.A(r0)
            if (r0 == 0) goto L_0x0010
            r0 = 1
            goto L_0x0011
        L_0x0010:
            r0 = 0
        L_0x0011:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.o():boolean");
    }

    public boolean p() {
        return this.D;
    }

    /* access modifiers changed from: package-private */
    public void q() {
        z zVar = this.k;
        if (zVar != null) {
            zVar.b();
        }
    }

    /* access modifiers changed from: package-private */
    public boolean r() {
        androidx.appcompat.view.b bVar = this.g;
        if (bVar != null) {
            bVar.c();
            return true;
        }
        a a2 = a();
        if (a2 == null || !a2.f()) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean a(int i2, KeyEvent keyEvent) {
        a a2 = a();
        if (a2 != null && a2.a(i2, keyEvent)) {
            return true;
        }
        PanelFeatureState panelFeatureState = this.M;
        if (panelFeatureState == null || !a(panelFeatureState, keyEvent.getKeyCode(), keyEvent, 1)) {
            if (this.M == null) {
                PanelFeatureState a3 = a(0, true);
                b(a3, keyEvent);
                boolean a4 = a(a3, keyEvent.getKeyCode(), keyEvent, 1);
                a3.m = false;
                if (a4) {
                    return true;
                }
            }
            return false;
        }
        PanelFeatureState panelFeatureState2 = this.M;
        if (panelFeatureState2 != null) {
            panelFeatureState2.n = true;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean a(KeyEvent keyEvent) {
        View decorView;
        Object obj = this.f146a;
        boolean z2 = true;
        if (((obj instanceof d.a) || (obj instanceof f)) && (decorView = this.c.getDecorView()) != null && androidx.core.g.d.a(decorView, keyEvent)) {
            return true;
        }
        if (keyEvent.getKeyCode() == 82 && this.y.a().dispatchKeyEvent(keyEvent)) {
            return true;
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyEvent.getAction() != 0) {
            z2 = false;
        }
        return z2 ? c(keyCode, keyEvent) : b(keyCode, keyEvent);
    }

    /* access modifiers changed from: package-private */
    public boolean b(int i2, KeyEvent keyEvent) {
        if (i2 == 4) {
            boolean z2 = this.N;
            this.N = false;
            PanelFeatureState a2 = a(0, false);
            if (a2 != null && a2.o) {
                if (!z2) {
                    a(a2, true);
                }
                return true;
            } else if (r()) {
                return true;
            }
        } else if (i2 == 82) {
            e(0, keyEvent);
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean c(int i2, KeyEvent keyEvent) {
        boolean z2 = true;
        if (i2 == 4) {
            if ((keyEvent.getFlags() & 128) == 0) {
                z2 = false;
            }
            this.N = z2;
        } else if (i2 == 82) {
            d(0, keyEvent);
            return true;
        }
        return false;
    }

    public View a(View view, String str, Context context, AttributeSet attributeSet) {
        boolean z2 = false;
        if (this.ab == null) {
            String string = this.f147b.obtainStyledAttributes(R.styleable.AppCompatTheme).getString(R.styleable.AppCompatTheme_viewInflaterClass);
            if (string == null || AppCompatViewInflater.class.getName().equals(string)) {
                this.ab = new AppCompatViewInflater();
            } else {
                try {
                    this.ab = (AppCompatViewInflater) Class.forName(string).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                } catch (Throwable th) {
                    Log.i("AppCompatDelegate", "Failed to instantiate custom view inflater " + string + ". Falling back to default.", th);
                    this.ab = new AppCompatViewInflater();
                }
            }
        }
        if (u) {
            if (!(attributeSet instanceof XmlPullParser)) {
                z2 = a((ViewParent) view);
            } else if (((XmlPullParser) attributeSet).getDepth() > 1) {
                z2 = true;
            }
        }
        return this.ab.createView(view, str, context, attributeSet, z2, u, true, aw.a());
    }

    private boolean a(ViewParent viewParent) {
        if (viewParent == null) {
            return false;
        }
        View decorView = this.c.getDecorView();
        while (viewParent != null) {
            if (viewParent == decorView || !(viewParent instanceof View) || v.D((View) viewParent)) {
                return false;
            }
            viewParent = viewParent.getParent();
        }
        return true;
    }

    public void h() {
        LayoutInflater from = LayoutInflater.from(this.f147b);
        if (from.getFactory() == null) {
            androidx.core.g.e.a(from, this);
        } else if (!(from.getFactory2() instanceof AppCompatDelegateImpl)) {
            Log.i("AppCompatDelegate", "The Activity's LayoutInflater already has a Factory installed so we can not install AppCompat's");
        }
    }

    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return a(view, str, context, attributeSet);
    }

    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView((View) null, str, context, attributeSet);
    }

    private c B() {
        Context context = this.f147b;
        while (context != null) {
            if (!(context instanceof c)) {
                if (!(context instanceof ContextWrapper)) {
                    break;
                }
                context = ((ContextWrapper) context).getBaseContext();
            } else {
                return (c) context;
            }
        }
        return null;
    }

    private void a(PanelFeatureState panelFeatureState, KeyEvent keyEvent) {
        int i2;
        ViewGroup.LayoutParams layoutParams;
        if (!panelFeatureState.o && !this.q) {
            if (panelFeatureState.f156a == 0) {
                if ((this.f147b.getResources().getConfiguration().screenLayout & 15) == 4) {
                    return;
                }
            }
            Window.Callback l2 = l();
            if (l2 == null || l2.onMenuOpened(panelFeatureState.f156a, panelFeatureState.j)) {
                WindowManager windowManager = (WindowManager) this.f147b.getSystemService("window");
                if (windowManager != null && b(panelFeatureState, keyEvent)) {
                    if (panelFeatureState.g == null || panelFeatureState.q) {
                        if (panelFeatureState.g == null) {
                            if (!a(panelFeatureState) || panelFeatureState.g == null) {
                                return;
                            }
                        } else if (panelFeatureState.q && panelFeatureState.g.getChildCount() > 0) {
                            panelFeatureState.g.removeAllViews();
                        }
                        if (c(panelFeatureState) && panelFeatureState.a()) {
                            ViewGroup.LayoutParams layoutParams2 = panelFeatureState.h.getLayoutParams();
                            if (layoutParams2 == null) {
                                layoutParams2 = new ViewGroup.LayoutParams(-2, -2);
                            }
                            panelFeatureState.g.setBackgroundResource(panelFeatureState.f157b);
                            ViewParent parent = panelFeatureState.h.getParent();
                            if (parent instanceof ViewGroup) {
                                ((ViewGroup) parent).removeView(panelFeatureState.h);
                            }
                            panelFeatureState.g.addView(panelFeatureState.h, layoutParams2);
                            if (!panelFeatureState.h.hasFocus()) {
                                panelFeatureState.h.requestFocus();
                            }
                        } else {
                            return;
                        }
                    } else if (!(panelFeatureState.i == null || (layoutParams = panelFeatureState.i.getLayoutParams()) == null || layoutParams.width != -1)) {
                        i2 = -1;
                        panelFeatureState.n = false;
                        WindowManager.LayoutParams layoutParams3 = new WindowManager.LayoutParams(i2, -2, panelFeatureState.d, panelFeatureState.e, TouchlessA3D.Parameters.EXTENDED_RANGE, 8519680, -3);
                        layoutParams3.gravity = panelFeatureState.c;
                        layoutParams3.windowAnimations = panelFeatureState.f;
                        windowManager.addView(panelFeatureState.g, layoutParams3);
                        panelFeatureState.o = true;
                        return;
                    }
                    i2 = -2;
                    panelFeatureState.n = false;
                    WindowManager.LayoutParams layoutParams32 = new WindowManager.LayoutParams(i2, -2, panelFeatureState.d, panelFeatureState.e, TouchlessA3D.Parameters.EXTENDED_RANGE, 8519680, -3);
                    layoutParams32.gravity = panelFeatureState.c;
                    layoutParams32.windowAnimations = panelFeatureState.f;
                    windowManager.addView(panelFeatureState.g, layoutParams32);
                    panelFeatureState.o = true;
                    return;
                }
                return;
            }
            a(panelFeatureState, true);
        }
    }

    private boolean a(PanelFeatureState panelFeatureState) {
        panelFeatureState.a(m());
        panelFeatureState.g = new g(panelFeatureState.l);
        panelFeatureState.c = 81;
        return true;
    }

    private void a(androidx.appcompat.view.menu.h hVar, boolean z2) {
        y yVar = this.A;
        if (yVar == null || !yVar.e() || (ViewConfiguration.get(this.f147b).hasPermanentMenuKey() && !this.A.g())) {
            PanelFeatureState a2 = a(0, true);
            a2.q = true;
            a(a2, false);
            a(a2, (KeyEvent) null);
            return;
        }
        Window.Callback l2 = l();
        if (this.A.f() && z2) {
            this.A.i();
            if (!this.q) {
                l2.onPanelClosed(108, a(0, true).j);
            }
        } else if (l2 != null && !this.q) {
            if (this.r && (this.s & 1) != 0) {
                this.c.getDecorView().removeCallbacks(this.X);
                this.X.run();
            }
            PanelFeatureState a3 = a(0, true);
            if (a3.j != null && !a3.r && l2.onPreparePanel(0, a3.i, a3.j)) {
                l2.onMenuOpened(108, a3.j);
                this.A.h();
            }
        }
    }

    private boolean b(PanelFeatureState panelFeatureState) {
        Context context = this.f147b;
        if ((panelFeatureState.f156a == 0 || panelFeatureState.f156a == 108) && this.A != null) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme theme = context.getTheme();
            theme.resolveAttribute(R.attr.actionBarTheme, typedValue, true);
            Resources.Theme theme2 = null;
            if (typedValue.resourceId != 0) {
                theme2 = context.getResources().newTheme();
                theme2.setTo(theme);
                theme2.applyStyle(typedValue.resourceId, true);
                theme2.resolveAttribute(R.attr.actionBarWidgetTheme, typedValue, true);
            } else {
                theme.resolveAttribute(R.attr.actionBarWidgetTheme, typedValue, true);
            }
            if (typedValue.resourceId != 0) {
                if (theme2 == null) {
                    theme2 = context.getResources().newTheme();
                    theme2.setTo(theme);
                }
                theme2.applyStyle(typedValue.resourceId, true);
            }
            if (theme2 != null) {
                androidx.appcompat.view.d dVar = new androidx.appcompat.view.d(context, 0);
                dVar.getTheme().setTo(theme2);
                context = dVar;
            }
        }
        androidx.appcompat.view.menu.h hVar = new androidx.appcompat.view.menu.h(context);
        hVar.setCallback(this);
        panelFeatureState.a(hVar);
        return true;
    }

    private boolean c(PanelFeatureState panelFeatureState) {
        if (panelFeatureState.i != null) {
            panelFeatureState.h = panelFeatureState.i;
            return true;
        } else if (panelFeatureState.j == null) {
            return false;
        } else {
            if (this.C == null) {
                this.C = new h();
            }
            panelFeatureState.h = (View) panelFeatureState.a((n.a) this.C);
            if (panelFeatureState.h != null) {
                return true;
            }
            return false;
        }
    }

    private boolean b(PanelFeatureState panelFeatureState, KeyEvent keyEvent) {
        y yVar;
        y yVar2;
        y yVar3;
        if (this.q) {
            return false;
        }
        if (panelFeatureState.m) {
            return true;
        }
        PanelFeatureState panelFeatureState2 = this.M;
        if (!(panelFeatureState2 == null || panelFeatureState2 == panelFeatureState)) {
            a(panelFeatureState2, false);
        }
        Window.Callback l2 = l();
        if (l2 != null) {
            panelFeatureState.i = l2.onCreatePanelView(panelFeatureState.f156a);
        }
        boolean z2 = panelFeatureState.f156a == 0 || panelFeatureState.f156a == 108;
        if (z2 && (yVar3 = this.A) != null) {
            yVar3.j();
        }
        if (panelFeatureState.i == null && (!z2 || !(k() instanceof i))) {
            if (panelFeatureState.j == null || panelFeatureState.r) {
                if (panelFeatureState.j == null && (!b(panelFeatureState) || panelFeatureState.j == null)) {
                    return false;
                }
                if (z2 && this.A != null) {
                    if (this.B == null) {
                        this.B = new a();
                    }
                    this.A.a(panelFeatureState.j, this.B);
                }
                panelFeatureState.j.stopDispatchingItemsChanged();
                if (!l2.onCreatePanelMenu(panelFeatureState.f156a, panelFeatureState.j)) {
                    panelFeatureState.a((androidx.appcompat.view.menu.h) null);
                    if (z2 && (yVar2 = this.A) != null) {
                        yVar2.a((Menu) null, this.B);
                    }
                    return false;
                }
                panelFeatureState.r = false;
            }
            panelFeatureState.j.stopDispatchingItemsChanged();
            if (panelFeatureState.s != null) {
                panelFeatureState.j.restoreActionViewStates(panelFeatureState.s);
                panelFeatureState.s = null;
            }
            if (!l2.onPreparePanel(0, panelFeatureState.i, panelFeatureState.j)) {
                if (z2 && (yVar = this.A) != null) {
                    yVar.a((Menu) null, this.B);
                }
                panelFeatureState.j.startDispatchingItemsChanged();
                return false;
            }
            panelFeatureState.p = KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1;
            panelFeatureState.j.setQwertyMode(panelFeatureState.p);
            panelFeatureState.j.startDispatchingItemsChanged();
        }
        panelFeatureState.m = true;
        panelFeatureState.n = false;
        this.M = panelFeatureState;
        return true;
    }

    /* access modifiers changed from: package-private */
    public void a(androidx.appcompat.view.menu.h hVar) {
        if (!this.K) {
            this.K = true;
            this.A.k();
            Window.Callback l2 = l();
            if (l2 != null && !this.q) {
                l2.onPanelClosed(108, hVar);
            }
            this.K = false;
        }
    }

    /* access modifiers changed from: package-private */
    public void g(int i2) {
        a(a(i2, true), true);
    }

    /* access modifiers changed from: package-private */
    public void a(PanelFeatureState panelFeatureState, boolean z2) {
        y yVar;
        if (!z2 || panelFeatureState.f156a != 0 || (yVar = this.A) == null || !yVar.f()) {
            WindowManager windowManager = (WindowManager) this.f147b.getSystemService("window");
            if (!(windowManager == null || !panelFeatureState.o || panelFeatureState.g == null)) {
                windowManager.removeView(panelFeatureState.g);
                if (z2) {
                    a(panelFeatureState.f156a, panelFeatureState, (Menu) null);
                }
            }
            panelFeatureState.m = false;
            panelFeatureState.n = false;
            panelFeatureState.o = false;
            panelFeatureState.h = null;
            panelFeatureState.q = true;
            if (this.M == panelFeatureState) {
                this.M = null;
                return;
            }
            return;
        }
        a(panelFeatureState.j);
    }

    private boolean d(int i2, KeyEvent keyEvent) {
        if (keyEvent.getRepeatCount() != 0) {
            return false;
        }
        PanelFeatureState a2 = a(i2, true);
        if (!a2.o) {
            return b(a2, keyEvent);
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x006c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean e(int r4, android.view.KeyEvent r5) {
        /*
            r3 = this;
            androidx.appcompat.view.b r0 = r3.g
            r1 = 0
            if (r0 == 0) goto L_0x0006
            return r1
        L_0x0006:
            r0 = 1
            androidx.appcompat.app.AppCompatDelegateImpl$PanelFeatureState r2 = r3.a((int) r4, (boolean) r0)
            if (r4 != 0) goto L_0x0043
            androidx.appcompat.widget.y r4 = r3.A
            if (r4 == 0) goto L_0x0043
            boolean r4 = r4.e()
            if (r4 == 0) goto L_0x0043
            android.content.Context r4 = r3.f147b
            android.view.ViewConfiguration r4 = android.view.ViewConfiguration.get(r4)
            boolean r4 = r4.hasPermanentMenuKey()
            if (r4 != 0) goto L_0x0043
            androidx.appcompat.widget.y r4 = r3.A
            boolean r4 = r4.f()
            if (r4 != 0) goto L_0x003c
            boolean r4 = r3.q
            if (r4 != 0) goto L_0x0063
            boolean r4 = r3.b((androidx.appcompat.app.AppCompatDelegateImpl.PanelFeatureState) r2, (android.view.KeyEvent) r5)
            if (r4 == 0) goto L_0x0063
            androidx.appcompat.widget.y r4 = r3.A
            boolean r4 = r4.h()
            goto L_0x006a
        L_0x003c:
            androidx.appcompat.widget.y r4 = r3.A
            boolean r4 = r4.i()
            goto L_0x006a
        L_0x0043:
            boolean r4 = r2.o
            if (r4 != 0) goto L_0x0065
            boolean r4 = r2.n
            if (r4 == 0) goto L_0x004c
            goto L_0x0065
        L_0x004c:
            boolean r4 = r2.m
            if (r4 == 0) goto L_0x0063
            boolean r4 = r2.r
            if (r4 == 0) goto L_0x005b
            r2.m = r1
            boolean r4 = r3.b((androidx.appcompat.app.AppCompatDelegateImpl.PanelFeatureState) r2, (android.view.KeyEvent) r5)
            goto L_0x005c
        L_0x005b:
            r4 = r0
        L_0x005c:
            if (r4 == 0) goto L_0x0063
            r3.a((androidx.appcompat.app.AppCompatDelegateImpl.PanelFeatureState) r2, (android.view.KeyEvent) r5)
            r4 = r0
            goto L_0x006a
        L_0x0063:
            r4 = r1
            goto L_0x006a
        L_0x0065:
            boolean r4 = r2.o
            r3.a((androidx.appcompat.app.AppCompatDelegateImpl.PanelFeatureState) r2, (boolean) r0)
        L_0x006a:
            if (r4 == 0) goto L_0x0083
            android.content.Context r5 = r3.f147b
            java.lang.String r0 = "audio"
            java.lang.Object r5 = r5.getSystemService(r0)
            android.media.AudioManager r5 = (android.media.AudioManager) r5
            if (r5 == 0) goto L_0x007c
            r5.playSoundEffect(r1)
            goto L_0x0083
        L_0x007c:
            java.lang.String r5 = "AppCompatDelegate"
            java.lang.String r0 = "Couldn't get audio manager"
            android.util.Log.w(r5, r0)
        L_0x0083:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.e(int, android.view.KeyEvent):boolean");
    }

    /* access modifiers changed from: package-private */
    public void a(int i2, PanelFeatureState panelFeatureState, Menu menu) {
        if (menu == null) {
            if (panelFeatureState == null && i2 >= 0) {
                PanelFeatureState[] panelFeatureStateArr = this.L;
                if (i2 < panelFeatureStateArr.length) {
                    panelFeatureState = panelFeatureStateArr[i2];
                }
            }
            if (panelFeatureState != null) {
                menu = panelFeatureState.j;
            }
        }
        if ((panelFeatureState == null || panelFeatureState.o) && !this.q) {
            this.y.a().onPanelClosed(i2, menu);
        }
    }

    /* access modifiers changed from: package-private */
    public PanelFeatureState a(Menu menu) {
        PanelFeatureState[] panelFeatureStateArr = this.L;
        int length = panelFeatureStateArr != null ? panelFeatureStateArr.length : 0;
        for (int i2 = 0; i2 < length; i2++) {
            PanelFeatureState panelFeatureState = panelFeatureStateArr[i2];
            if (panelFeatureState != null && panelFeatureState.j == menu) {
                return panelFeatureState;
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public PanelFeatureState a(int i2, boolean z2) {
        PanelFeatureState[] panelFeatureStateArr = this.L;
        if (panelFeatureStateArr == null || panelFeatureStateArr.length <= i2) {
            PanelFeatureState[] panelFeatureStateArr2 = new PanelFeatureState[(i2 + 1)];
            if (panelFeatureStateArr != null) {
                System.arraycopy(panelFeatureStateArr, 0, panelFeatureStateArr2, 0, panelFeatureStateArr.length);
            }
            this.L = panelFeatureStateArr2;
            panelFeatureStateArr = panelFeatureStateArr2;
        }
        PanelFeatureState panelFeatureState = panelFeatureStateArr[i2];
        if (panelFeatureState != null) {
            return panelFeatureState;
        }
        PanelFeatureState panelFeatureState2 = new PanelFeatureState(i2);
        panelFeatureStateArr[i2] = panelFeatureState2;
        return panelFeatureState2;
    }

    private boolean a(PanelFeatureState panelFeatureState, int i2, KeyEvent keyEvent, int i3) {
        boolean z2 = false;
        if (keyEvent.isSystem()) {
            return false;
        }
        if ((panelFeatureState.m || b(panelFeatureState, keyEvent)) && panelFeatureState.j != null) {
            z2 = panelFeatureState.j.performShortcut(i2, keyEvent, i3);
        }
        if (z2 && (i3 & 1) == 0 && this.A == null) {
            a(panelFeatureState, true);
        }
        return z2;
    }

    private void k(int i2) {
        this.s = (1 << i2) | this.s;
        if (!this.r) {
            v.a(this.c.getDecorView(), this.X);
            this.r = true;
        }
    }

    /* access modifiers changed from: package-private */
    public void h(int i2) {
        PanelFeatureState a2;
        PanelFeatureState a3 = a(i2, true);
        if (a3.j != null) {
            Bundle bundle = new Bundle();
            a3.j.saveActionViewStates(bundle);
            if (bundle.size() > 0) {
                a3.s = bundle;
            }
            a3.j.stopDispatchingItemsChanged();
            a3.j.clear();
        }
        a3.r = true;
        a3.q = true;
        if ((i2 == 108 || i2 == 0) && this.A != null && (a2 = a(0, false)) != null) {
            a2.m = false;
            b(a2, (KeyEvent) null);
        }
    }

    /* access modifiers changed from: package-private */
    public int i(int i2) {
        boolean z2;
        boolean z3;
        ActionBarContextView actionBarContextView = this.h;
        int i3 = 0;
        if (actionBarContextView == null || !(actionBarContextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            z2 = false;
        } else {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.h.getLayoutParams();
            z2 = true;
            if (this.h.isShown()) {
                if (this.Z == null) {
                    this.Z = new Rect();
                    this.aa = new Rect();
                }
                Rect rect = this.Z;
                Rect rect2 = this.aa;
                rect.set(0, i2, 0, 0);
                ax.a(this.F, rect, rect2);
                if (marginLayoutParams.topMargin != (rect2.top == 0 ? i2 : 0)) {
                    marginLayoutParams.topMargin = i2;
                    View view = this.H;
                    if (view == null) {
                        this.H = new View(this.f147b);
                        this.H.setBackgroundColor(this.f147b.getResources().getColor(R.color.abc_input_method_navigation_guard));
                        this.F.addView(this.H, -1, new ViewGroup.LayoutParams(-1, i2));
                    } else {
                        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                        if (layoutParams.height != i2) {
                            layoutParams.height = i2;
                            this.H.setLayoutParams(layoutParams);
                        }
                    }
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (this.H == null) {
                    z2 = false;
                }
                if (!this.n && z2) {
                    i2 = 0;
                }
            } else if (marginLayoutParams.topMargin != 0) {
                marginLayoutParams.topMargin = 0;
                z3 = true;
                z2 = false;
            } else {
                z3 = false;
                z2 = false;
            }
            if (z3) {
                this.h.setLayoutParams(marginLayoutParams);
            }
        }
        View view2 = this.H;
        if (view2 != null) {
            if (!z2) {
                i3 = 8;
            }
            view2.setVisibility(i3);
        }
        return i2;
    }

    private void C() {
        if (this.E) {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }

    private int l(int i2) {
        if (i2 == 8) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR id when requesting this feature.");
            return 108;
        } else if (i2 != 9) {
            return i2;
        } else {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY id when requesting this feature.");
            return 109;
        }
    }

    /* access modifiers changed from: package-private */
    public void s() {
        y yVar = this.A;
        if (yVar != null) {
            yVar.k();
        }
        if (this.i != null) {
            this.c.getDecorView().removeCallbacks(this.j);
            if (this.i.isShowing()) {
                try {
                    this.i.dismiss();
                } catch (IllegalArgumentException unused) {
                }
            }
            this.i = null;
        }
        q();
        PanelFeatureState a2 = a(0, false);
        if (a2 != null && a2.j != null) {
            a2.j.close();
        }
    }

    public boolean t() {
        return a(true);
    }

    private boolean a(boolean z2) {
        if (this.q) {
            return false;
        }
        int D2 = D();
        boolean b2 = b(j(D2), z2);
        if (D2 == 0) {
            u().d();
        } else {
            e eVar = this.V;
            if (eVar != null) {
                eVar.e();
            }
        }
        if (D2 == 3) {
            E().d();
        } else {
            e eVar2 = this.W;
            if (eVar2 != null) {
                eVar2.e();
            }
        }
        return b2;
    }

    public int i() {
        return this.R;
    }

    /* access modifiers changed from: package-private */
    public int j(int i2) {
        if (i2 == -100) {
            return -1;
        }
        if (i2 == -1) {
            return i2;
        }
        if (i2 != 0) {
            if (i2 == 1 || i2 == 2) {
                return i2;
            }
            if (i2 == 3) {
                return E().a();
            }
            throw new IllegalStateException("Unknown value set for night mode. Please use one of the MODE_NIGHT values from AppCompatDelegate.");
        } else if (Build.VERSION.SDK_INT < 23 || ((UiModeManager) this.f147b.getSystemService(UiModeManager.class)).getNightMode() != 0) {
            return u().a();
        } else {
            return -1;
        }
    }

    private int D() {
        int i2 = this.R;
        return i2 != -100 ? i2 : j();
    }

    private boolean b(int i2, boolean z2) {
        int i3 = this.f147b.getApplicationContext().getResources().getConfiguration().uiMode & 48;
        boolean z3 = true;
        int i4 = i2 != 1 ? i2 != 2 ? i3 : 32 : 16;
        boolean F2 = F();
        boolean z4 = false;
        if ((x || i4 != i3) && !F2 && Build.VERSION.SDK_INT >= 17 && !this.O && (this.f146a instanceof ContextThemeWrapper)) {
            Configuration configuration = new Configuration();
            configuration.uiMode = (configuration.uiMode & -49) | i4;
            try {
                ((ContextThemeWrapper) this.f146a).applyOverrideConfiguration(configuration);
                z4 = true;
            } catch (IllegalStateException e2) {
                Log.e("AppCompatDelegate", "updateForNightMode. Calling applyOverrideConfiguration() failed with an exception. Will fall back to using Resources.updateConfiguration()", e2);
            }
        }
        int i5 = this.f147b.getResources().getConfiguration().uiMode & 48;
        if (!z4 && i5 != i4 && z2 && !F2 && this.O && (Build.VERSION.SDK_INT >= 17 || this.P)) {
            Object obj = this.f146a;
            if (obj instanceof Activity) {
                androidx.core.app.a.b((Activity) obj);
                z4 = true;
            }
        }
        if (z4 || i5 == i4) {
            z3 = z4;
        } else {
            c(i4, F2);
        }
        if (z3) {
            Object obj2 = this.f146a;
            if (obj2 instanceof c) {
                ((c) obj2).a(i2);
            }
        }
        return z3;
    }

    private void c(int i2, boolean z2) {
        Resources resources = this.f147b.getResources();
        Configuration configuration = new Configuration(resources.getConfiguration());
        configuration.uiMode = i2 | (resources.getConfiguration().uiMode & -49);
        resources.updateConfiguration(configuration, (DisplayMetrics) null);
        if (Build.VERSION.SDK_INT < 26) {
            h.a(resources);
        }
        int i3 = this.S;
        if (i3 != 0) {
            this.f147b.setTheme(i3);
            if (Build.VERSION.SDK_INT >= 23) {
                this.f147b.getTheme().applyStyle(this.S, true);
            }
        }
        if (z2) {
            Object obj = this.f146a;
            if (obj instanceof Activity) {
                Activity activity = (Activity) obj;
                if (activity instanceof androidx.lifecycle.h) {
                    if (((androidx.lifecycle.h) activity).getLifecycle().a().isAtLeast(e.b.STARTED)) {
                        activity.onConfigurationChanged(configuration);
                    }
                } else if (this.Q) {
                    activity.onConfigurationChanged(configuration);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final e u() {
        if (this.V == null) {
            this.V = new f(k.a(this.f147b));
        }
        return this.V;
    }

    private e E() {
        if (this.W == null) {
            this.W = new d(this.f147b);
        }
        return this.W;
    }

    private boolean F() {
        if (!this.U && (this.f146a instanceof Activity)) {
            PackageManager packageManager = this.f147b.getPackageManager();
            if (packageManager == null) {
                return false;
            }
            try {
                ActivityInfo activityInfo = packageManager.getActivityInfo(new ComponentName(this.f147b, this.f146a.getClass()), 0);
                this.T = (activityInfo == null || (activityInfo.configChanges & 512) == 0) ? false : true;
            } catch (PackageManager.NameNotFoundException e2) {
                Log.d("AppCompatDelegate", "Exception while getting ActivityInfo", e2);
                this.T = false;
            }
        }
        this.U = true;
        return this.T;
    }

    class b implements b.a {

        /* renamed from: b  reason: collision with root package name */
        private b.a f160b;

        public b(b.a aVar) {
            this.f160b = aVar;
        }

        public boolean a(androidx.appcompat.view.b bVar, Menu menu) {
            return this.f160b.a(bVar, menu);
        }

        public boolean b(androidx.appcompat.view.b bVar, Menu menu) {
            return this.f160b.b(bVar, menu);
        }

        public boolean a(androidx.appcompat.view.b bVar, MenuItem menuItem) {
            return this.f160b.a(bVar, menuItem);
        }

        public void a(androidx.appcompat.view.b bVar) {
            this.f160b.a(bVar);
            if (AppCompatDelegateImpl.this.i != null) {
                AppCompatDelegateImpl.this.c.getDecorView().removeCallbacks(AppCompatDelegateImpl.this.j);
            }
            if (AppCompatDelegateImpl.this.h != null) {
                AppCompatDelegateImpl.this.q();
                AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
                appCompatDelegateImpl.k = v.n(appCompatDelegateImpl.h).a(0.0f);
                AppCompatDelegateImpl.this.k.a((aa) new ab() {
                    public void b(View view) {
                        AppCompatDelegateImpl.this.h.setVisibility(8);
                        if (AppCompatDelegateImpl.this.i != null) {
                            AppCompatDelegateImpl.this.i.dismiss();
                        } else if (AppCompatDelegateImpl.this.h.getParent() instanceof View) {
                            v.s((View) AppCompatDelegateImpl.this.h.getParent());
                        }
                        AppCompatDelegateImpl.this.h.removeAllViews();
                        AppCompatDelegateImpl.this.k.a((aa) null);
                        AppCompatDelegateImpl.this.k = null;
                    }
                });
            }
            if (AppCompatDelegateImpl.this.d != null) {
                AppCompatDelegateImpl.this.d.onSupportActionModeFinished(AppCompatDelegateImpl.this.g);
            }
            AppCompatDelegateImpl.this.g = null;
        }
    }

    private final class h implements n.a {
        h() {
        }

        public void a(androidx.appcompat.view.menu.h hVar, boolean z) {
            androidx.appcompat.view.menu.h rootMenu = hVar.getRootMenu();
            boolean z2 = rootMenu != hVar;
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            if (z2) {
                hVar = rootMenu;
            }
            PanelFeatureState a2 = appCompatDelegateImpl.a((Menu) hVar);
            if (a2 == null) {
                return;
            }
            if (z2) {
                AppCompatDelegateImpl.this.a(a2.f156a, a2, rootMenu);
                AppCompatDelegateImpl.this.a(a2, true);
                return;
            }
            AppCompatDelegateImpl.this.a(a2, z);
        }

        public boolean a(androidx.appcompat.view.menu.h hVar) {
            Window.Callback l;
            if (hVar != null || !AppCompatDelegateImpl.this.l || (l = AppCompatDelegateImpl.this.l()) == null || AppCompatDelegateImpl.this.q) {
                return true;
            }
            l.onMenuOpened(108, hVar);
            return true;
        }
    }

    private final class a implements n.a {
        a() {
        }

        public boolean a(androidx.appcompat.view.menu.h hVar) {
            Window.Callback l = AppCompatDelegateImpl.this.l();
            if (l == null) {
                return true;
            }
            l.onMenuOpened(108, hVar);
            return true;
        }

        public void a(androidx.appcompat.view.menu.h hVar, boolean z) {
            AppCompatDelegateImpl.this.a(hVar);
        }
    }

    protected static final class PanelFeatureState {

        /* renamed from: a  reason: collision with root package name */
        int f156a;

        /* renamed from: b  reason: collision with root package name */
        int f157b;
        int c;
        int d;
        int e;
        int f;
        ViewGroup g;
        View h;
        View i;
        androidx.appcompat.view.menu.h j;
        androidx.appcompat.view.menu.f k;
        Context l;
        boolean m;
        boolean n;
        boolean o;
        public boolean p;
        boolean q = false;
        boolean r;
        Bundle s;

        PanelFeatureState(int i2) {
            this.f156a = i2;
        }

        public boolean a() {
            if (this.h == null) {
                return false;
            }
            if (this.i != null) {
                return true;
            }
            if (this.k.a().getCount() > 0) {
                return true;
            }
            return false;
        }

        /* access modifiers changed from: package-private */
        public void a(Context context) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme newTheme = context.getResources().newTheme();
            newTheme.setTo(context.getTheme());
            newTheme.resolveAttribute(R.attr.actionBarPopupTheme, typedValue, true);
            if (typedValue.resourceId != 0) {
                newTheme.applyStyle(typedValue.resourceId, true);
            }
            newTheme.resolveAttribute(R.attr.panelMenuListTheme, typedValue, true);
            if (typedValue.resourceId != 0) {
                newTheme.applyStyle(typedValue.resourceId, true);
            } else {
                newTheme.applyStyle(R.style.Theme_AppCompat_CompactMenu, true);
            }
            androidx.appcompat.view.d dVar = new androidx.appcompat.view.d(context, 0);
            dVar.getTheme().setTo(newTheme);
            this.l = dVar;
            TypedArray obtainStyledAttributes = dVar.obtainStyledAttributes(R.styleable.AppCompatTheme);
            this.f157b = obtainStyledAttributes.getResourceId(R.styleable.AppCompatTheme_panelBackground, 0);
            this.f = obtainStyledAttributes.getResourceId(R.styleable.AppCompatTheme_android_windowAnimationStyle, 0);
            obtainStyledAttributes.recycle();
        }

        /* access modifiers changed from: package-private */
        public void a(androidx.appcompat.view.menu.h hVar) {
            androidx.appcompat.view.menu.f fVar;
            androidx.appcompat.view.menu.h hVar2 = this.j;
            if (hVar != hVar2) {
                if (hVar2 != null) {
                    hVar2.removeMenuPresenter(this.k);
                }
                this.j = hVar;
                if (hVar != null && (fVar = this.k) != null) {
                    hVar.addMenuPresenter(fVar);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public o a(n.a aVar) {
            if (this.j == null) {
                return null;
            }
            if (this.k == null) {
                this.k = new androidx.appcompat.view.menu.f(this.l, R.layout.abc_list_menu_item_layout);
                this.k.setCallback(aVar);
                this.j.addMenuPresenter(this.k);
            }
            return this.k.a(this.g);
        }

        @SuppressLint({"BanParcelableUsage"})
        private static class SavedState implements Parcelable {
            public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() {
                /* renamed from: a */
                public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                    return SavedState.readFromParcel(parcel, classLoader);
                }

                /* renamed from: a */
                public SavedState createFromParcel(Parcel parcel) {
                    return SavedState.readFromParcel(parcel, (ClassLoader) null);
                }

                /* renamed from: a */
                public SavedState[] newArray(int i) {
                    return new SavedState[i];
                }
            };
            int featureId;
            boolean isOpen;
            Bundle menuState;

            public int describeContents() {
                return 0;
            }

            SavedState() {
            }

            public void writeToParcel(Parcel parcel, int i) {
                parcel.writeInt(this.featureId);
                parcel.writeInt(this.isOpen ? 1 : 0);
                if (this.isOpen) {
                    parcel.writeBundle(this.menuState);
                }
            }

            static SavedState readFromParcel(Parcel parcel, ClassLoader classLoader) {
                SavedState savedState = new SavedState();
                savedState.featureId = parcel.readInt();
                boolean z = true;
                if (parcel.readInt() != 1) {
                    z = false;
                }
                savedState.isOpen = z;
                if (savedState.isOpen) {
                    savedState.menuState = parcel.readBundle(classLoader);
                }
                return savedState;
            }
        }
    }

    private class g extends ContentFrameLayout {
        public g(Context context) {
            super(context);
        }

        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return AppCompatDelegateImpl.this.a(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (motionEvent.getAction() != 0 || !a((int) motionEvent.getX(), (int) motionEvent.getY())) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            AppCompatDelegateImpl.this.g(0);
            return true;
        }

        public void setBackgroundResource(int i) {
            setBackgroundDrawable(androidx.appcompat.a.a.a.b(getContext(), i));
        }

        private boolean a(int i, int i2) {
            return i < -5 || i2 < -5 || i > getWidth() + 5 || i2 > getHeight() + 5;
        }
    }

    class c extends androidx.appcompat.view.i {
        public void onContentChanged() {
        }

        c(Window.Callback callback) {
            super(callback);
        }

        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return AppCompatDelegateImpl.this.a(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
            return super.dispatchKeyShortcutEvent(keyEvent) || AppCompatDelegateImpl.this.a(keyEvent.getKeyCode(), keyEvent);
        }

        public boolean onCreatePanelMenu(int i, Menu menu) {
            if (i != 0 || (menu instanceof androidx.appcompat.view.menu.h)) {
                return super.onCreatePanelMenu(i, menu);
            }
            return false;
        }

        public boolean onPreparePanel(int i, View view, Menu menu) {
            androidx.appcompat.view.menu.h hVar = menu instanceof androidx.appcompat.view.menu.h ? (androidx.appcompat.view.menu.h) menu : null;
            if (i == 0 && hVar == null) {
                return false;
            }
            if (hVar != null) {
                hVar.setOverrideVisibleItems(true);
            }
            boolean onPreparePanel = super.onPreparePanel(i, view, menu);
            if (hVar != null) {
                hVar.setOverrideVisibleItems(false);
            }
            return onPreparePanel;
        }

        public boolean onMenuOpened(int i, Menu menu) {
            super.onMenuOpened(i, menu);
            AppCompatDelegateImpl.this.f(i);
            return true;
        }

        public void onPanelClosed(int i, Menu menu) {
            super.onPanelClosed(i, menu);
            AppCompatDelegateImpl.this.e(i);
        }

        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
            if (Build.VERSION.SDK_INT >= 23) {
                return null;
            }
            if (AppCompatDelegateImpl.this.p()) {
                return a(callback);
            }
            return super.onWindowStartingActionMode(callback);
        }

        /* access modifiers changed from: package-private */
        public final ActionMode a(ActionMode.Callback callback) {
            f.a aVar = new f.a(AppCompatDelegateImpl.this.f147b, callback);
            androidx.appcompat.view.b a2 = AppCompatDelegateImpl.this.a((b.a) aVar);
            if (a2 != null) {
                return aVar.b(a2);
            }
            return null;
        }

        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i) {
            if (!AppCompatDelegateImpl.this.p() || i != 0) {
                return super.onWindowStartingActionMode(callback, i);
            }
            return a(callback);
        }

        public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> list, Menu menu, int i) {
            PanelFeatureState a2 = AppCompatDelegateImpl.this.a(0, true);
            if (a2 == null || a2.j == null) {
                super.onProvideKeyboardShortcuts(list, menu, i);
            } else {
                super.onProvideKeyboardShortcuts(list, a2.j, i);
            }
        }
    }

    abstract class e {

        /* renamed from: a  reason: collision with root package name */
        private BroadcastReceiver f164a;

        /* access modifiers changed from: package-private */
        public abstract int a();

        /* access modifiers changed from: package-private */
        public abstract void b();

        /* access modifiers changed from: package-private */
        public abstract IntentFilter c();

        e() {
        }

        /* access modifiers changed from: package-private */
        public void d() {
            e();
            IntentFilter c = c();
            if (c != null && c.countActions() != 0) {
                if (this.f164a == null) {
                    this.f164a = new BroadcastReceiver() {
                        public void onReceive(Context context, Intent intent) {
                            e.this.b();
                        }
                    };
                }
                AppCompatDelegateImpl.this.f147b.registerReceiver(this.f164a, c);
            }
        }

        /* access modifiers changed from: package-private */
        public void e() {
            if (this.f164a != null) {
                try {
                    AppCompatDelegateImpl.this.f147b.unregisterReceiver(this.f164a);
                } catch (IllegalArgumentException unused) {
                }
                this.f164a = null;
            }
        }
    }

    private class f extends e {
        private final k c;

        f(k kVar) {
            super();
            this.c = kVar;
        }

        public int a() {
            return this.c.a() ? 2 : 1;
        }

        public void b() {
            AppCompatDelegateImpl.this.t();
        }

        /* access modifiers changed from: package-private */
        public IntentFilter c() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.TIME_SET");
            intentFilter.addAction("android.intent.action.TIMEZONE_CHANGED");
            intentFilter.addAction("android.intent.action.TIME_TICK");
            return intentFilter;
        }
    }

    private class d extends e {
        private final PowerManager c;

        d(Context context) {
            super();
            this.c = (PowerManager) context.getSystemService("power");
        }

        public int a() {
            if (Build.VERSION.SDK_INT < 21 || !this.c.isPowerSaveMode()) {
                return 1;
            }
            return 2;
        }

        public void b() {
            AppCompatDelegateImpl.this.t();
        }

        /* access modifiers changed from: package-private */
        public IntentFilter c() {
            if (Build.VERSION.SDK_INT < 21) {
                return null;
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.os.action.POWER_SAVE_MODE_CHANGED");
            return intentFilter;
        }
    }
}
