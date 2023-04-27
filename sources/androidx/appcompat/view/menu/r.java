package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.n;
import androidx.appcompat.widget.ag;
import androidx.core.g.v;

/* compiled from: StandardMenuPopup */
final class r extends l implements View.OnKeyListener, AdapterView.OnItemClickListener, PopupWindow.OnDismissListener, n {
    private static final int e = R.layout.abc_popup_menu_item_layout;

    /* renamed from: a  reason: collision with root package name */
    final ag f285a;

    /* renamed from: b  reason: collision with root package name */
    final ViewTreeObserver.OnGlobalLayoutListener f286b = new ViewTreeObserver.OnGlobalLayoutListener() {
        public void onGlobalLayout() {
            if (r.this.c() && !r.this.f285a.i()) {
                View view = r.this.c;
                if (view == null || !view.isShown()) {
                    r.this.b();
                } else {
                    r.this.f285a.a_();
                }
            }
        }
    };
    View c;
    ViewTreeObserver d;
    private final Context f;
    private final h g;
    private final g h;
    private final boolean i;
    private final int j;
    private final int k;
    private final int l;
    private final View.OnAttachStateChangeListener m = new View.OnAttachStateChangeListener() {
        public void onViewAttachedToWindow(View view) {
        }

        public void onViewDetachedFromWindow(View view) {
            if (r.this.d != null) {
                if (!r.this.d.isAlive()) {
                    r.this.d = view.getViewTreeObserver();
                }
                r.this.d.removeGlobalOnLayoutListener(r.this.f286b);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    };
    private PopupWindow.OnDismissListener n;
    private View o;
    private n.a p;
    private boolean q;
    private boolean r;
    private int s;
    private int t = 0;
    private boolean u;

    public void a(h hVar) {
    }

    public boolean flagActionItems() {
        return false;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
    }

    public Parcelable onSaveInstanceState() {
        return null;
    }

    public r(Context context, h hVar, View view, int i2, int i3, boolean z) {
        this.f = context;
        this.g = hVar;
        this.i = z;
        this.h = new g(hVar, LayoutInflater.from(context), this.i, e);
        this.k = i2;
        this.l = i3;
        Resources resources = context.getResources();
        this.j = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R.dimen.abc_config_prefDialogWidth));
        this.o = view;
        this.f285a = new ag(this.f, (AttributeSet) null, this.k, this.l);
        hVar.addMenuPresenter(this, context);
    }

    public void a(boolean z) {
        this.h.a(z);
    }

    public void a(int i2) {
        this.t = i2;
    }

    private boolean g() {
        View view;
        if (c()) {
            return true;
        }
        if (this.q || (view = this.o) == null) {
            return false;
        }
        this.c = view;
        this.f285a.a((PopupWindow.OnDismissListener) this);
        this.f285a.a((AdapterView.OnItemClickListener) this);
        this.f285a.a(true);
        View view2 = this.c;
        boolean z = this.d == null;
        this.d = view2.getViewTreeObserver();
        if (z) {
            this.d.addOnGlobalLayoutListener(this.f286b);
        }
        view2.addOnAttachStateChangeListener(this.m);
        this.f285a.b(view2);
        this.f285a.f(this.t);
        if (!this.r) {
            this.s = a(this.h, (ViewGroup) null, this.f, this.j);
            this.r = true;
        }
        this.f285a.h(this.s);
        this.f285a.i(2);
        this.f285a.a(f());
        this.f285a.a_();
        ListView b_ = this.f285a.b_();
        b_.setOnKeyListener(this);
        if (this.u && this.g.getHeaderTitle() != null) {
            FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(this.f).inflate(R.layout.abc_popup_menu_header_item_layout, b_, false);
            TextView textView = (TextView) frameLayout.findViewById(16908310);
            if (textView != null) {
                textView.setText(this.g.getHeaderTitle());
            }
            frameLayout.setEnabled(false);
            b_.addHeaderView(frameLayout, (Object) null, false);
        }
        this.f285a.a((ListAdapter) this.h);
        this.f285a.a_();
        return true;
    }

    public void a_() {
        if (!g()) {
            throw new IllegalStateException("StandardMenuPopup cannot be used without an anchor");
        }
    }

    public void b() {
        if (c()) {
            this.f285a.b();
        }
    }

    public boolean c() {
        return !this.q && this.f285a.c();
    }

    public void onDismiss() {
        this.q = true;
        this.g.close();
        ViewTreeObserver viewTreeObserver = this.d;
        if (viewTreeObserver != null) {
            if (!viewTreeObserver.isAlive()) {
                this.d = this.c.getViewTreeObserver();
            }
            this.d.removeGlobalOnLayoutListener(this.f286b);
            this.d = null;
        }
        this.c.removeOnAttachStateChangeListener(this.m);
        PopupWindow.OnDismissListener onDismissListener = this.n;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    public void updateMenuView(boolean z) {
        this.r = false;
        g gVar = this.h;
        if (gVar != null) {
            gVar.notifyDataSetChanged();
        }
    }

    public void setCallback(n.a aVar) {
        this.p = aVar;
    }

    public boolean onSubMenuSelected(s sVar) {
        if (sVar.hasVisibleItems()) {
            m mVar = new m(this.f, sVar, this.c, this.i, this.k, this.l);
            mVar.a(this.p);
            mVar.a(l.b((h) sVar));
            mVar.a(this.n);
            this.n = null;
            this.g.close(false);
            int f2 = this.f285a.f();
            int e2 = this.f285a.e();
            if ((Gravity.getAbsoluteGravity(this.t, v.g(this.o)) & 7) == 5) {
                f2 += this.o.getWidth();
            }
            if (mVar.a(f2, e2)) {
                n.a aVar = this.p;
                if (aVar == null) {
                    return true;
                }
                aVar.a(sVar);
                return true;
            }
        }
        return false;
    }

    public void onCloseMenu(h hVar, boolean z) {
        if (hVar == this.g) {
            b();
            n.a aVar = this.p;
            if (aVar != null) {
                aVar.a(hVar, z);
            }
        }
    }

    public void a(View view) {
        this.o = view;
    }

    public boolean onKey(View view, int i2, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i2 != 82) {
            return false;
        }
        b();
        return true;
    }

    public void a(PopupWindow.OnDismissListener onDismissListener) {
        this.n = onDismissListener;
    }

    public ListView b_() {
        return this.f285a.b_();
    }

    public void b(int i2) {
        this.f285a.b(i2);
    }

    public void c(int i2) {
        this.f285a.a(i2);
    }

    public void b(boolean z) {
        this.u = z;
    }
}
