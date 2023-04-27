package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.n;
import androidx.appcompat.widget.af;
import androidx.appcompat.widget.ag;
import androidx.core.g.c;
import androidx.core.g.v;
import java.util.ArrayList;
import java.util.List;

/* compiled from: CascadingMenuPopup */
final class e extends l implements View.OnKeyListener, PopupWindow.OnDismissListener, n {
    private static final int g = R.layout.abc_cascading_menu_item_layout;
    private PopupWindow.OnDismissListener A;

    /* renamed from: a  reason: collision with root package name */
    final Handler f252a;

    /* renamed from: b  reason: collision with root package name */
    final List<a> f253b = new ArrayList();
    final ViewTreeObserver.OnGlobalLayoutListener c = new ViewTreeObserver.OnGlobalLayoutListener() {
        public void onGlobalLayout() {
            if (e.this.c() && e.this.f253b.size() > 0 && !e.this.f253b.get(0).f259a.i()) {
                View view = e.this.d;
                if (view == null || !view.isShown()) {
                    e.this.b();
                    return;
                }
                for (a aVar : e.this.f253b) {
                    aVar.f259a.a_();
                }
            }
        }
    };
    View d;
    ViewTreeObserver e;
    boolean f;
    private final Context h;
    private final int i;
    private final int j;
    private final int k;
    private final boolean l;
    private final List<h> m = new ArrayList();
    private final View.OnAttachStateChangeListener n = new View.OnAttachStateChangeListener() {
        public void onViewAttachedToWindow(View view) {
        }

        public void onViewDetachedFromWindow(View view) {
            if (e.this.e != null) {
                if (!e.this.e.isAlive()) {
                    e.this.e = view.getViewTreeObserver();
                }
                e.this.e.removeGlobalOnLayoutListener(e.this.c);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    };
    private final af o = new af() {
        public void a(h hVar, MenuItem menuItem) {
            e.this.f252a.removeCallbacksAndMessages(hVar);
        }

        public void b(final h hVar, final MenuItem menuItem) {
            final a aVar = null;
            e.this.f252a.removeCallbacksAndMessages((Object) null);
            int size = e.this.f253b.size();
            int i = 0;
            while (true) {
                if (i >= size) {
                    i = -1;
                    break;
                } else if (hVar == e.this.f253b.get(i).f260b) {
                    break;
                } else {
                    i++;
                }
            }
            if (i != -1) {
                int i2 = i + 1;
                if (i2 < e.this.f253b.size()) {
                    aVar = e.this.f253b.get(i2);
                }
                e.this.f252a.postAtTime(new Runnable() {
                    public void run() {
                        if (aVar != null) {
                            e.this.f = true;
                            aVar.f260b.close(false);
                            e.this.f = false;
                        }
                        if (menuItem.isEnabled() && menuItem.hasSubMenu()) {
                            hVar.performItemAction(menuItem, 4);
                        }
                    }
                }, hVar, SystemClock.uptimeMillis() + 200);
            }
        }
    };
    private int p = 0;
    private int q = 0;
    private View r;
    private int s;
    private boolean t;
    private boolean u;
    private int v;
    private int w;
    private boolean x;
    private boolean y;
    private n.a z;

    /* access modifiers changed from: protected */
    public boolean e() {
        return false;
    }

    public boolean flagActionItems() {
        return false;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
    }

    public Parcelable onSaveInstanceState() {
        return null;
    }

    public e(Context context, View view, int i2, int i3, boolean z2) {
        this.h = context;
        this.r = view;
        this.j = i2;
        this.k = i3;
        this.l = z2;
        this.x = false;
        this.s = h();
        Resources resources = context.getResources();
        this.i = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R.dimen.abc_config_prefDialogWidth));
        this.f252a = new Handler();
    }

    public void a(boolean z2) {
        this.x = z2;
    }

    private ag g() {
        ag agVar = new ag(this.h, (AttributeSet) null, this.j, this.k);
        agVar.a(this.o);
        agVar.a((AdapterView.OnItemClickListener) this);
        agVar.a((PopupWindow.OnDismissListener) this);
        agVar.b(this.r);
        agVar.f(this.q);
        agVar.a(true);
        agVar.i(2);
        return agVar;
    }

    public void a_() {
        if (!c()) {
            for (h c2 : this.m) {
                c(c2);
            }
            this.m.clear();
            this.d = this.r;
            if (this.d != null) {
                boolean z2 = this.e == null;
                this.e = this.d.getViewTreeObserver();
                if (z2) {
                    this.e.addOnGlobalLayoutListener(this.c);
                }
                this.d.addOnAttachStateChangeListener(this.n);
            }
        }
    }

    public void b() {
        int size = this.f253b.size();
        if (size > 0) {
            a[] aVarArr = (a[]) this.f253b.toArray(new a[size]);
            for (int i2 = size - 1; i2 >= 0; i2--) {
                a aVar = aVarArr[i2];
                if (aVar.f259a.c()) {
                    aVar.f259a.b();
                }
            }
        }
    }

    public boolean onKey(View view, int i2, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i2 != 82) {
            return false;
        }
        b();
        return true;
    }

    private int h() {
        return v.g(this.r) == 1 ? 0 : 1;
    }

    private int d(int i2) {
        List<a> list = this.f253b;
        ListView a2 = list.get(list.size() - 1).a();
        int[] iArr = new int[2];
        a2.getLocationOnScreen(iArr);
        Rect rect = new Rect();
        this.d.getWindowVisibleDisplayFrame(rect);
        if (this.s == 1) {
            if (iArr[0] + a2.getWidth() + i2 > rect.right) {
                return 0;
            }
            return 1;
        } else if (iArr[0] - i2 < 0) {
            return 1;
        } else {
            return 0;
        }
    }

    public void a(h hVar) {
        hVar.addMenuPresenter(this, this.h);
        if (c()) {
            c(hVar);
        } else {
            this.m.add(hVar);
        }
    }

    private void c(h hVar) {
        View view;
        a aVar;
        int i2;
        int i3;
        int i4;
        LayoutInflater from = LayoutInflater.from(this.h);
        g gVar = new g(hVar, from, this.l, g);
        if (!c() && this.x) {
            gVar.a(true);
        } else if (c()) {
            gVar.a(l.b(hVar));
        }
        int a2 = a(gVar, (ViewGroup) null, this.h, this.i);
        ag g2 = g();
        g2.a((ListAdapter) gVar);
        g2.h(a2);
        g2.f(this.q);
        if (this.f253b.size() > 0) {
            List<a> list = this.f253b;
            aVar = list.get(list.size() - 1);
            view = a(aVar, hVar);
        } else {
            aVar = null;
            view = null;
        }
        if (view != null) {
            g2.c(false);
            g2.a((Object) null);
            int d2 = d(a2);
            boolean z2 = d2 == 1;
            this.s = d2;
            if (Build.VERSION.SDK_INT >= 26) {
                g2.b(view);
                i3 = 0;
                i2 = 0;
            } else {
                int[] iArr = new int[2];
                this.r.getLocationOnScreen(iArr);
                int[] iArr2 = new int[2];
                view.getLocationOnScreen(iArr2);
                if ((this.q & 7) == 5) {
                    iArr[0] = iArr[0] + this.r.getWidth();
                    iArr2[0] = iArr2[0] + view.getWidth();
                }
                i2 = iArr2[0] - iArr[0];
                i3 = iArr2[1] - iArr[1];
            }
            if ((this.q & 5) != 5) {
                if (z2) {
                    a2 = view.getWidth();
                }
                i4 = i2 - a2;
                g2.b(i4);
                g2.b(true);
                g2.a(i3);
            } else if (!z2) {
                a2 = view.getWidth();
                i4 = i2 - a2;
                g2.b(i4);
                g2.b(true);
                g2.a(i3);
            }
            i4 = i2 + a2;
            g2.b(i4);
            g2.b(true);
            g2.a(i3);
        } else {
            if (this.t) {
                g2.b(this.v);
            }
            if (this.u) {
                g2.a(this.w);
            }
            g2.a(f());
        }
        this.f253b.add(new a(g2, hVar, this.s));
        g2.a_();
        ListView b_ = g2.b_();
        b_.setOnKeyListener(this);
        if (aVar == null && this.y && hVar.getHeaderTitle() != null) {
            FrameLayout frameLayout = (FrameLayout) from.inflate(R.layout.abc_popup_menu_header_item_layout, b_, false);
            frameLayout.setEnabled(false);
            ((TextView) frameLayout.findViewById(16908310)).setText(hVar.getHeaderTitle());
            b_.addHeaderView(frameLayout, (Object) null, false);
            g2.a_();
        }
    }

    private MenuItem a(h hVar, h hVar2) {
        int size = hVar.size();
        for (int i2 = 0; i2 < size; i2++) {
            MenuItem item = hVar.getItem(i2);
            if (item.hasSubMenu() && hVar2 == item.getSubMenu()) {
                return item;
            }
        }
        return null;
    }

    private View a(a aVar, h hVar) {
        int i2;
        g gVar;
        int firstVisiblePosition;
        MenuItem a2 = a(aVar.f260b, hVar);
        if (a2 == null) {
            return null;
        }
        ListView a3 = aVar.a();
        ListAdapter adapter = a3.getAdapter();
        int i3 = 0;
        if (adapter instanceof HeaderViewListAdapter) {
            HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
            i2 = headerViewListAdapter.getHeadersCount();
            gVar = (g) headerViewListAdapter.getWrappedAdapter();
        } else {
            gVar = (g) adapter;
            i2 = 0;
        }
        int count = gVar.getCount();
        while (true) {
            if (i3 >= count) {
                i3 = -1;
                break;
            } else if (a2 == gVar.getItem(i3)) {
                break;
            } else {
                i3++;
            }
        }
        if (i3 != -1 && (firstVisiblePosition = (i3 + i2) - a3.getFirstVisiblePosition()) >= 0 && firstVisiblePosition < a3.getChildCount()) {
            return a3.getChildAt(firstVisiblePosition);
        }
        return null;
    }

    public boolean c() {
        return this.f253b.size() > 0 && this.f253b.get(0).f259a.c();
    }

    public void onDismiss() {
        a aVar;
        int size = this.f253b.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                aVar = null;
                break;
            }
            aVar = this.f253b.get(i2);
            if (!aVar.f259a.c()) {
                break;
            }
            i2++;
        }
        if (aVar != null) {
            aVar.f260b.close(false);
        }
    }

    public void updateMenuView(boolean z2) {
        for (a a2 : this.f253b) {
            a(a2.a().getAdapter()).notifyDataSetChanged();
        }
    }

    public void setCallback(n.a aVar) {
        this.z = aVar;
    }

    public boolean onSubMenuSelected(s sVar) {
        for (a next : this.f253b) {
            if (sVar == next.f260b) {
                next.a().requestFocus();
                return true;
            }
        }
        if (!sVar.hasVisibleItems()) {
            return false;
        }
        a((h) sVar);
        n.a aVar = this.z;
        if (aVar != null) {
            aVar.a(sVar);
        }
        return true;
    }

    private int d(h hVar) {
        int size = this.f253b.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (hVar == this.f253b.get(i2).f260b) {
                return i2;
            }
        }
        return -1;
    }

    public void onCloseMenu(h hVar, boolean z2) {
        int d2 = d(hVar);
        if (d2 >= 0) {
            int i2 = d2 + 1;
            if (i2 < this.f253b.size()) {
                this.f253b.get(i2).f260b.close(false);
            }
            a remove = this.f253b.remove(d2);
            remove.f260b.removeMenuPresenter(this);
            if (this.f) {
                remove.f259a.b((Object) null);
                remove.f259a.e(0);
            }
            remove.f259a.b();
            int size = this.f253b.size();
            if (size > 0) {
                this.s = this.f253b.get(size - 1).c;
            } else {
                this.s = h();
            }
            if (size == 0) {
                b();
                n.a aVar = this.z;
                if (aVar != null) {
                    aVar.a(hVar, true);
                }
                ViewTreeObserver viewTreeObserver = this.e;
                if (viewTreeObserver != null) {
                    if (viewTreeObserver.isAlive()) {
                        this.e.removeGlobalOnLayoutListener(this.c);
                    }
                    this.e = null;
                }
                this.d.removeOnAttachStateChangeListener(this.n);
                this.A.onDismiss();
            } else if (z2) {
                this.f253b.get(0).f260b.close(false);
            }
        }
    }

    public void a(int i2) {
        if (this.p != i2) {
            this.p = i2;
            this.q = c.a(i2, v.g(this.r));
        }
    }

    public void a(View view) {
        if (this.r != view) {
            this.r = view;
            this.q = c.a(this.p, v.g(this.r));
        }
    }

    public void a(PopupWindow.OnDismissListener onDismissListener) {
        this.A = onDismissListener;
    }

    public ListView b_() {
        if (this.f253b.isEmpty()) {
            return null;
        }
        List<a> list = this.f253b;
        return list.get(list.size() - 1).a();
    }

    public void b(int i2) {
        this.t = true;
        this.v = i2;
    }

    public void c(int i2) {
        this.u = true;
        this.w = i2;
    }

    public void b(boolean z2) {
        this.y = z2;
    }

    /* compiled from: CascadingMenuPopup */
    private static class a {

        /* renamed from: a  reason: collision with root package name */
        public final ag f259a;

        /* renamed from: b  reason: collision with root package name */
        public final h f260b;
        public final int c;

        public a(ag agVar, h hVar, int i) {
            this.f259a = agVar;
            this.f260b = hVar;
            this.c = i;
        }

        public ListView a() {
            return this.f259a.b_();
        }
    }
}
