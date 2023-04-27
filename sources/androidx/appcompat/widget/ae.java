package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.q;
import androidx.core.g.v;
import androidx.core.widget.h;
import com.crunchfish.touchless_a3d.TouchlessA3D;
import java.lang.reflect.Method;

/* compiled from: ListPopupWindow */
public class ae implements q {

    /* renamed from: a  reason: collision with root package name */
    private static Method f383a;

    /* renamed from: b  reason: collision with root package name */
    private static Method f384b;
    private static Method h;
    private Drawable A;
    private AdapterView.OnItemClickListener B;
    private AdapterView.OnItemSelectedListener C;
    private final d D;
    private final c E;
    private final a F;
    private Runnable G;
    private final Rect H;
    private Rect I;
    private boolean J;
    ab c;
    int d;
    final e e;
    final Handler f;
    PopupWindow g;
    private Context i;
    private ListAdapter j;
    private int k;
    private int l;
    private int m;
    private int n;
    private int o;
    private boolean p;
    private boolean q;
    private boolean r;
    private boolean s;
    private int t;
    private boolean u;
    private boolean v;
    private View w;
    private int x;
    private DataSetObserver y;
    private View z;

    static {
        if (Build.VERSION.SDK_INT <= 28) {
            Class<PopupWindow> cls = PopupWindow.class;
            try {
                f383a = cls.getDeclaredMethod("setClipToScreenEnabled", new Class[]{Boolean.TYPE});
            } catch (NoSuchMethodException unused) {
                Log.i("ListPopupWindow", "Could not find method setClipToScreenEnabled() on PopupWindow. Oh well.");
            }
            try {
                h = PopupWindow.class.getDeclaredMethod("setEpicenterBounds", new Class[]{Rect.class});
            } catch (NoSuchMethodException unused2) {
                Log.i("ListPopupWindow", "Could not find method setEpicenterBounds(Rect) on PopupWindow. Oh well.");
            }
        }
        if (Build.VERSION.SDK_INT <= 23) {
            Class<PopupWindow> cls2 = PopupWindow.class;
            try {
                f384b = cls2.getDeclaredMethod("getMaxAvailableHeight", new Class[]{View.class, Integer.TYPE, Boolean.TYPE});
            } catch (NoSuchMethodException unused3) {
                Log.i("ListPopupWindow", "Could not find method getMaxAvailableHeight(View, int, boolean) on PopupWindow. Oh well.");
            }
        }
    }

    public ae(Context context) {
        this(context, (AttributeSet) null, R.attr.listPopupWindowStyle);
    }

    public ae(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, 0);
    }

    public ae(Context context, AttributeSet attributeSet, int i2, int i3) {
        this.k = -2;
        this.l = -2;
        this.o = TouchlessA3D.Parameters.EXTENDED_RANGE;
        this.q = true;
        this.t = 0;
        this.u = false;
        this.v = false;
        this.d = Integer.MAX_VALUE;
        this.x = 0;
        this.e = new e();
        this.D = new d();
        this.E = new c();
        this.F = new a();
        this.H = new Rect();
        this.i = context;
        this.f = new Handler(context.getMainLooper());
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ListPopupWindow, i2, i3);
        this.m = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.ListPopupWindow_android_dropDownHorizontalOffset, 0);
        this.n = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.ListPopupWindow_android_dropDownVerticalOffset, 0);
        if (this.n != 0) {
            this.p = true;
        }
        obtainStyledAttributes.recycle();
        this.g = new o(context, attributeSet, i2, i3);
        this.g.setInputMethodMode(1);
    }

    public void a(ListAdapter listAdapter) {
        DataSetObserver dataSetObserver = this.y;
        if (dataSetObserver == null) {
            this.y = new b();
        } else {
            ListAdapter listAdapter2 = this.j;
            if (listAdapter2 != null) {
                listAdapter2.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.j = listAdapter;
        if (listAdapter != null) {
            listAdapter.registerDataSetObserver(this.y);
        }
        ab abVar = this.c;
        if (abVar != null) {
            abVar.setAdapter(this.j);
        }
    }

    public void d(int i2) {
        this.x = i2;
    }

    public void a(boolean z2) {
        this.J = z2;
        this.g.setFocusable(z2);
    }

    public boolean i() {
        return this.J;
    }

    public Drawable d() {
        return this.g.getBackground();
    }

    public void a(Drawable drawable) {
        this.g.setBackgroundDrawable(drawable);
    }

    public void e(int i2) {
        this.g.setAnimationStyle(i2);
    }

    public View j() {
        return this.z;
    }

    public void b(View view) {
        this.z = view;
    }

    public int f() {
        return this.m;
    }

    public void b(int i2) {
        this.m = i2;
    }

    public int e() {
        if (!this.p) {
            return 0;
        }
        return this.n;
    }

    public void a(int i2) {
        this.n = i2;
        this.p = true;
    }

    public void a(Rect rect) {
        this.I = rect != null ? new Rect(rect) : null;
    }

    public void f(int i2) {
        this.t = i2;
    }

    public int k() {
        return this.l;
    }

    public void g(int i2) {
        this.l = i2;
    }

    public void h(int i2) {
        Drawable background = this.g.getBackground();
        if (background != null) {
            background.getPadding(this.H);
            this.l = this.H.left + this.H.right + i2;
            return;
        }
        g(i2);
    }

    public void a(AdapterView.OnItemClickListener onItemClickListener) {
        this.B = onItemClickListener;
    }

    public void a_() {
        int h2 = h();
        boolean m2 = m();
        h.a(this.g, this.o);
        boolean z2 = true;
        if (!this.g.isShowing()) {
            int i2 = this.l;
            if (i2 == -1) {
                i2 = -1;
            } else if (i2 == -2) {
                i2 = j().getWidth();
            }
            int i3 = this.k;
            if (i3 == -1) {
                h2 = -1;
            } else if (i3 != -2) {
                h2 = i3;
            }
            this.g.setWidth(i2);
            this.g.setHeight(h2);
            c(true);
            this.g.setOutsideTouchable(!this.v && !this.u);
            this.g.setTouchInterceptor(this.D);
            if (this.s) {
                h.a(this.g, this.r);
            }
            if (Build.VERSION.SDK_INT <= 28) {
                Method method = h;
                if (method != null) {
                    try {
                        method.invoke(this.g, new Object[]{this.I});
                    } catch (Exception e2) {
                        Log.e("ListPopupWindow", "Could not invoke setEpicenterBounds on PopupWindow", e2);
                    }
                }
            } else {
                this.g.setEpicenterBounds(this.I);
            }
            h.a(this.g, j(), this.m, this.n, this.t);
            this.c.setSelection(-1);
            if (!this.J || this.c.isInTouchMode()) {
                l();
            }
            if (!this.J) {
                this.f.post(this.F);
            }
        } else if (v.D(j())) {
            int i4 = this.l;
            if (i4 == -1) {
                i4 = -1;
            } else if (i4 == -2) {
                i4 = j().getWidth();
            }
            int i5 = this.k;
            if (i5 == -1) {
                if (!m2) {
                    h2 = -1;
                }
                if (m2) {
                    this.g.setWidth(this.l == -1 ? -1 : 0);
                    this.g.setHeight(0);
                } else {
                    this.g.setWidth(this.l == -1 ? -1 : 0);
                    this.g.setHeight(-1);
                }
            } else if (i5 != -2) {
                h2 = i5;
            }
            PopupWindow popupWindow = this.g;
            if (this.v || this.u) {
                z2 = false;
            }
            popupWindow.setOutsideTouchable(z2);
            this.g.update(j(), this.m, this.n, i4 < 0 ? -1 : i4, h2 < 0 ? -1 : h2);
        }
    }

    public void b() {
        this.g.dismiss();
        g();
        this.g.setContentView((View) null);
        this.c = null;
        this.f.removeCallbacks(this.e);
    }

    public void a(PopupWindow.OnDismissListener onDismissListener) {
        this.g.setOnDismissListener(onDismissListener);
    }

    private void g() {
        View view = this.w;
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.w);
            }
        }
    }

    public void i(int i2) {
        this.g.setInputMethodMode(i2);
    }

    public void j(int i2) {
        ab abVar = this.c;
        if (c() && abVar != null) {
            abVar.setListSelectionHidden(false);
            abVar.setSelection(i2);
            if (abVar.getChoiceMode() != 0) {
                abVar.setItemChecked(i2, true);
            }
        }
    }

    public void l() {
        ab abVar = this.c;
        if (abVar != null) {
            abVar.setListSelectionHidden(true);
            abVar.requestLayout();
        }
    }

    public boolean c() {
        return this.g.isShowing();
    }

    public boolean m() {
        return this.g.getInputMethodMode() == 2;
    }

    public Object n() {
        if (!c()) {
            return null;
        }
        return this.c.getSelectedItem();
    }

    public int o() {
        if (!c()) {
            return -1;
        }
        return this.c.getSelectedItemPosition();
    }

    public long p() {
        if (!c()) {
            return Long.MIN_VALUE;
        }
        return this.c.getSelectedItemId();
    }

    public View q() {
        if (!c()) {
            return null;
        }
        return this.c.getSelectedView();
    }

    public ListView b_() {
        return this.c;
    }

    /* access modifiers changed from: package-private */
    public ab a(Context context, boolean z2) {
        return new ab(context, z2);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v24, resolved type: androidx.appcompat.widget.ab} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v25, resolved type: androidx.appcompat.widget.ab} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v2, resolved type: android.widget.LinearLayout} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v30, resolved type: androidx.appcompat.widget.ab} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int h() {
        /*
            r12 = this;
            androidx.appcompat.widget.ab r0 = r12.c
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = -1
            r3 = 1
            r4 = 0
            if (r0 != 0) goto L_0x00c0
            android.content.Context r0 = r12.i
            androidx.appcompat.widget.ae$1 r5 = new androidx.appcompat.widget.ae$1
            r5.<init>()
            r12.G = r5
            boolean r5 = r12.J
            r5 = r5 ^ r3
            androidx.appcompat.widget.ab r5 = r12.a(r0, r5)
            r12.c = r5
            android.graphics.drawable.Drawable r5 = r12.A
            if (r5 == 0) goto L_0x0024
            androidx.appcompat.widget.ab r6 = r12.c
            r6.setSelector(r5)
        L_0x0024:
            androidx.appcompat.widget.ab r5 = r12.c
            android.widget.ListAdapter r6 = r12.j
            r5.setAdapter(r6)
            androidx.appcompat.widget.ab r5 = r12.c
            android.widget.AdapterView$OnItemClickListener r6 = r12.B
            r5.setOnItemClickListener(r6)
            androidx.appcompat.widget.ab r5 = r12.c
            r5.setFocusable(r3)
            androidx.appcompat.widget.ab r5 = r12.c
            r5.setFocusableInTouchMode(r3)
            androidx.appcompat.widget.ab r5 = r12.c
            androidx.appcompat.widget.ae$2 r6 = new androidx.appcompat.widget.ae$2
            r6.<init>()
            r5.setOnItemSelectedListener(r6)
            androidx.appcompat.widget.ab r5 = r12.c
            androidx.appcompat.widget.ae$c r6 = r12.E
            r5.setOnScrollListener(r6)
            android.widget.AdapterView$OnItemSelectedListener r5 = r12.C
            if (r5 == 0) goto L_0x0056
            androidx.appcompat.widget.ab r6 = r12.c
            r6.setOnItemSelectedListener(r5)
        L_0x0056:
            androidx.appcompat.widget.ab r5 = r12.c
            android.view.View r6 = r12.w
            if (r6 == 0) goto L_0x00b9
            android.widget.LinearLayout r7 = new android.widget.LinearLayout
            r7.<init>(r0)
            r7.setOrientation(r3)
            android.widget.LinearLayout$LayoutParams r0 = new android.widget.LinearLayout$LayoutParams
            r8 = 1065353216(0x3f800000, float:1.0)
            r0.<init>(r2, r4, r8)
            int r8 = r12.x
            if (r8 == 0) goto L_0x0091
            if (r8 == r3) goto L_0x008a
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r5 = "Invalid hint position "
            r0.append(r5)
            int r5 = r12.x
            r0.append(r5)
            java.lang.String r0 = r0.toString()
            java.lang.String r5 = "ListPopupWindow"
            android.util.Log.e(r5, r0)
            goto L_0x0097
        L_0x008a:
            r7.addView(r5, r0)
            r7.addView(r6)
            goto L_0x0097
        L_0x0091:
            r7.addView(r6)
            r7.addView(r5, r0)
        L_0x0097:
            int r0 = r12.l
            if (r0 < 0) goto L_0x009d
            r5 = r1
            goto L_0x009f
        L_0x009d:
            r0 = r4
            r5 = r0
        L_0x009f:
            int r0 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r5)
            r6.measure(r0, r4)
            android.view.ViewGroup$LayoutParams r0 = r6.getLayoutParams()
            android.widget.LinearLayout$LayoutParams r0 = (android.widget.LinearLayout.LayoutParams) r0
            int r5 = r6.getMeasuredHeight()
            int r6 = r0.topMargin
            int r5 = r5 + r6
            int r0 = r0.bottomMargin
            int r5 = r5 + r0
            r0 = r5
            r5 = r7
            goto L_0x00ba
        L_0x00b9:
            r0 = r4
        L_0x00ba:
            android.widget.PopupWindow r6 = r12.g
            r6.setContentView(r5)
            goto L_0x00de
        L_0x00c0:
            android.widget.PopupWindow r0 = r12.g
            android.view.View r0 = r0.getContentView()
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
            android.view.View r0 = r12.w
            if (r0 == 0) goto L_0x00dd
            android.view.ViewGroup$LayoutParams r5 = r0.getLayoutParams()
            android.widget.LinearLayout$LayoutParams r5 = (android.widget.LinearLayout.LayoutParams) r5
            int r0 = r0.getMeasuredHeight()
            int r6 = r5.topMargin
            int r0 = r0 + r6
            int r5 = r5.bottomMargin
            int r0 = r0 + r5
            goto L_0x00de
        L_0x00dd:
            r0 = r4
        L_0x00de:
            android.widget.PopupWindow r5 = r12.g
            android.graphics.drawable.Drawable r5 = r5.getBackground()
            if (r5 == 0) goto L_0x0100
            android.graphics.Rect r6 = r12.H
            r5.getPadding(r6)
            android.graphics.Rect r5 = r12.H
            int r5 = r5.top
            android.graphics.Rect r6 = r12.H
            int r6 = r6.bottom
            int r5 = r5 + r6
            boolean r6 = r12.p
            if (r6 != 0) goto L_0x0106
            android.graphics.Rect r6 = r12.H
            int r6 = r6.top
            int r6 = -r6
            r12.n = r6
            goto L_0x0106
        L_0x0100:
            android.graphics.Rect r5 = r12.H
            r5.setEmpty()
            r5 = r4
        L_0x0106:
            android.widget.PopupWindow r6 = r12.g
            int r6 = r6.getInputMethodMode()
            r7 = 2
            if (r6 != r7) goto L_0x0110
            goto L_0x0111
        L_0x0110:
            r3 = r4
        L_0x0111:
            android.view.View r4 = r12.j()
            int r6 = r12.n
            int r3 = r12.a(r4, r6, r3)
            boolean r4 = r12.u
            if (r4 != 0) goto L_0x0187
            int r4 = r12.k
            if (r4 != r2) goto L_0x0124
            goto L_0x0187
        L_0x0124:
            int r4 = r12.l
            r6 = -2
            if (r4 == r6) goto L_0x014e
            r1 = 1073741824(0x40000000, float:2.0)
            if (r4 == r2) goto L_0x0133
            int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r4, r1)
        L_0x0131:
            r7 = r1
            goto L_0x0169
        L_0x0133:
            android.content.Context r2 = r12.i
            android.content.res.Resources r2 = r2.getResources()
            android.util.DisplayMetrics r2 = r2.getDisplayMetrics()
            int r2 = r2.widthPixels
            android.graphics.Rect r4 = r12.H
            int r4 = r4.left
            android.graphics.Rect r6 = r12.H
            int r6 = r6.right
            int r4 = r4 + r6
            int r2 = r2 - r4
            int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r2, r1)
            goto L_0x0131
        L_0x014e:
            android.content.Context r2 = r12.i
            android.content.res.Resources r2 = r2.getResources()
            android.util.DisplayMetrics r2 = r2.getDisplayMetrics()
            int r2 = r2.widthPixels
            android.graphics.Rect r4 = r12.H
            int r4 = r4.left
            android.graphics.Rect r6 = r12.H
            int r6 = r6.right
            int r4 = r4 + r6
            int r2 = r2 - r4
            int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r2, r1)
            goto L_0x0131
        L_0x0169:
            androidx.appcompat.widget.ab r6 = r12.c
            r8 = 0
            r9 = -1
            int r10 = r3 - r0
            r11 = -1
            int r1 = r6.a(r7, r8, r9, r10, r11)
            if (r1 <= 0) goto L_0x0185
            androidx.appcompat.widget.ab r2 = r12.c
            int r2 = r2.getPaddingTop()
            androidx.appcompat.widget.ab r3 = r12.c
            int r3 = r3.getPaddingBottom()
            int r2 = r2 + r3
            int r5 = r5 + r2
            int r0 = r0 + r5
        L_0x0185:
            int r1 = r1 + r0
            return r1
        L_0x0187:
            int r3 = r3 + r5
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ae.h():int");
    }

    public void b(boolean z2) {
        this.s = true;
        this.r = z2;
    }

    /* compiled from: ListPopupWindow */
    private class b extends DataSetObserver {
        b() {
        }

        public void onChanged() {
            if (ae.this.c()) {
                ae.this.a_();
            }
        }

        public void onInvalidated() {
            ae.this.b();
        }
    }

    /* compiled from: ListPopupWindow */
    private class a implements Runnable {
        a() {
        }

        public void run() {
            ae.this.l();
        }
    }

    /* compiled from: ListPopupWindow */
    private class e implements Runnable {
        e() {
        }

        public void run() {
            if (ae.this.c != null && v.D(ae.this.c) && ae.this.c.getCount() > ae.this.c.getChildCount() && ae.this.c.getChildCount() <= ae.this.d) {
                ae.this.g.setInputMethodMode(2);
                ae.this.a_();
            }
        }
    }

    /* compiled from: ListPopupWindow */
    private class d implements View.OnTouchListener {
        d() {
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (action == 0 && ae.this.g != null && ae.this.g.isShowing() && x >= 0 && x < ae.this.g.getWidth() && y >= 0 && y < ae.this.g.getHeight()) {
                ae.this.f.postDelayed(ae.this.e, 250);
                return false;
            } else if (action != 1) {
                return false;
            } else {
                ae.this.f.removeCallbacks(ae.this.e);
                return false;
            }
        }
    }

    /* compiled from: ListPopupWindow */
    private class c implements AbsListView.OnScrollListener {
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }

        c() {
        }

        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 1 && !ae.this.m() && ae.this.g.getContentView() != null) {
                ae.this.f.removeCallbacks(ae.this.e);
                ae.this.e.run();
            }
        }
    }

    private void c(boolean z2) {
        if (Build.VERSION.SDK_INT <= 28) {
            Method method = f383a;
            if (method != null) {
                try {
                    method.invoke(this.g, new Object[]{Boolean.valueOf(z2)});
                } catch (Exception unused) {
                    Log.i("ListPopupWindow", "Could not call setClipToScreenEnabled() on PopupWindow. Oh well.");
                }
            }
        } else {
            this.g.setIsClippedToScreen(z2);
        }
    }

    private int a(View view, int i2, boolean z2) {
        if (Build.VERSION.SDK_INT > 23) {
            return this.g.getMaxAvailableHeight(view, i2, z2);
        }
        Method method = f384b;
        if (method != null) {
            try {
                return ((Integer) method.invoke(this.g, new Object[]{view, Integer.valueOf(i2), Boolean.valueOf(z2)})).intValue();
            } catch (Exception unused) {
                Log.i("ListPopupWindow", "Could not call getMaxAvailableHeightMethod(View, int, boolean) on PopupWindow. Using the public version.");
            }
        }
        return this.g.getMaxAvailableHeight(view, i2);
    }
}
