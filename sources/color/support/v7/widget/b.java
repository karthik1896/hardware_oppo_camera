package color.support.v7.widget;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.SystemClock;
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
import androidx.core.g.z;
import color.support.v7.appcompat.R;
import color.support.v7.widget.c;
import java.lang.reflect.Method;

/* compiled from: ColorBaseListPopupWindow */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static Method f1561a;
    /* access modifiers changed from: private */
    public Handler A;
    private Rect B;
    private boolean C;

    /* renamed from: b  reason: collision with root package name */
    private Context f1562b;
    protected c c;
    int d;
    /* access modifiers changed from: private */
    public ListAdapter e;
    /* access modifiers changed from: private */
    public C0049b f;
    private int g;
    private int h;
    private int i;
    private int j;
    private boolean k;
    private int l;
    private boolean m;
    private boolean n;
    private View o;
    private int p;
    private DataSetObserver q;
    private View r;
    private Drawable s;
    private AdapterView.OnItemClickListener t;
    private AdapterView.OnItemSelectedListener u;
    /* access modifiers changed from: private */
    public final h v;
    private final g w;
    private final f x;
    private final d y;
    private Runnable z;

    static {
        Class<c> cls = c.class;
        try {
            f1561a = cls.getDeclaredMethod("a", new Class[]{Boolean.TYPE});
        } catch (NoSuchMethodException unused) {
            Log.i("BaseListPopupWindow", "Could not find method setClipToScreenEnabled() on PopupWindow. Oh well.");
        }
    }

    public void a(ListAdapter listAdapter) {
        DataSetObserver dataSetObserver = this.q;
        if (dataSetObserver == null) {
            this.q = new e(this, (AnonymousClass1) null);
        } else {
            ListAdapter listAdapter2 = this.e;
            if (listAdapter2 != null) {
                listAdapter2.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.e = listAdapter;
        if (this.e != null) {
            listAdapter.registerDataSetObserver(this.q);
        }
        C0049b bVar = this.f;
        if (bVar != null) {
            bVar.setAdapter(new a(this.e));
        }
    }

    public Drawable e() {
        return this.c.getBackground();
    }

    public void a(Drawable drawable) {
        this.c.setBackgroundDrawable(drawable);
    }

    public View l() {
        return this.r;
    }

    public int g() {
        return this.i;
    }

    public void b(int i2) {
        this.i = i2;
    }

    public int f() {
        if (!this.k) {
            return 0;
        }
        return this.j;
    }

    public void a(int i2) {
        this.j = i2;
        this.k = true;
    }

    public int m() {
        return this.h;
    }

    public void c(int i2) {
        this.h = i2;
    }

    public void d(int i2) {
        Drawable background = this.c.getBackground();
        if (background != null) {
            background.getPadding(this.B);
            this.h = this.B.left + this.B.right + i2;
            return;
        }
        c(i2);
    }

    public void e(int i2) {
        this.g = i2;
    }

    public void h() {
        int i2;
        int i3;
        int i4;
        int i5;
        int j2 = j();
        boolean o2 = o();
        boolean z2 = true;
        int i6 = -1;
        if (this.c.isShowing()) {
            int i7 = this.h;
            if (i7 == -1) {
                i4 = -1;
            } else {
                if (i7 == -2) {
                    i7 = l().getWidth();
                }
                i4 = i7;
            }
            int i8 = this.g;
            if (i8 == -1) {
                if (!o2) {
                    j2 = -1;
                }
                if (o2) {
                    c cVar = this.c;
                    if (this.h != -1) {
                        i6 = 0;
                    }
                    cVar.setWindowLayoutMode(i6, 0);
                } else {
                    this.c.setWindowLayoutMode(this.h == -1 ? -1 : 0, -1);
                }
            } else if (i8 != -2) {
                i5 = i8;
                c cVar2 = this.c;
                if (this.n || this.m) {
                    z2 = false;
                }
                cVar2.setOutsideTouchable(z2);
                this.c.update(l(), this.i, this.j, i4, i5);
                return;
            }
            i5 = j2;
            c cVar22 = this.c;
            z2 = false;
            cVar22.setOutsideTouchable(z2);
            this.c.update(l(), this.i, this.j, i4, i5);
            return;
        }
        int i9 = this.h;
        if (i9 == -1) {
            i2 = -1;
        } else {
            if (i9 == -2) {
                this.c.setWidth(l().getWidth());
            } else {
                this.c.setWidth(i9);
            }
            i2 = 0;
        }
        int i10 = this.g;
        if (i10 == -1) {
            i3 = -1;
        } else {
            if (i10 == -2) {
                this.c.setHeight(j2);
            } else {
                this.c.setHeight(i10);
            }
            i3 = 0;
        }
        this.c.setWindowLayoutMode(i2, i3);
        if (l() instanceof color.support.v7.internal.widget.b) {
            a(false);
        } else {
            a(true);
        }
        c cVar3 = this.c;
        if (this.n || this.m) {
            z2 = false;
        }
        cVar3.setOutsideTouchable(z2);
        this.c.setTouchInterceptor(this.w);
        androidx.core.widget.h.a(this.c, l(), this.i, this.j, this.l);
        this.f.setSelection(-1);
        if (!this.C || this.f.isInTouchMode()) {
            n();
        }
        if (!this.C) {
            this.A.post(this.y);
        }
    }

    public void c() {
        this.c.dismiss();
        a();
        this.c.setContentView((View) null);
        this.f = null;
        this.A.removeCallbacks(this.v);
    }

    public void a(c.a aVar) {
        this.c.a(aVar);
    }

    private void a() {
        View view = this.o;
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.o);
            }
        }
    }

    public void f(int i2) {
        this.c.setInputMethodMode(i2);
    }

    public void g(int i2) {
        C0049b bVar = this.f;
        if (d() && bVar != null) {
            boolean unused = bVar.f = false;
            bVar.setSelection(i2);
            if (Build.VERSION.SDK_INT >= 11 && bVar.getChoiceMode() != 0) {
                bVar.setItemChecked(i2, true);
            }
        }
    }

    public void n() {
        C0049b bVar = this.f;
        if (bVar != null) {
            boolean unused = bVar.f = true;
            bVar.requestLayout();
        }
    }

    public boolean d() {
        return this.c.isShowing();
    }

    public boolean o() {
        return this.c.getInputMethodMode() == 2;
    }

    public ListView p() {
        return this.f;
    }

    /* renamed from: color.support.v7.widget.b$1  reason: invalid class name */
    /* compiled from: ColorBaseListPopupWindow */
    class AnonymousClass1 extends c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f1563a;

        public b a() {
            return this.f1563a;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v27, resolved type: color.support.v7.widget.b$b} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v28, resolved type: color.support.v7.widget.b$b} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v2, resolved type: android.widget.LinearLayout} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v31, resolved type: color.support.v7.widget.b$b} */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int j() {
        /*
            r11 = this;
            color.support.v7.widget.b$b r0 = r11.f
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = -1
            r3 = 0
            if (r0 != 0) goto L_0x00bf
            android.content.Context r0 = r11.f1562b
            color.support.v7.widget.b$2 r4 = new color.support.v7.widget.b$2
            r4.<init>()
            r11.z = r4
            color.support.v7.widget.b$b r4 = new color.support.v7.widget.b$b
            boolean r5 = r11.C
            r6 = 1
            r5 = r5 ^ r6
            r4.<init>(r0, r5)
            r11.f = r4
            android.graphics.drawable.Drawable r4 = r11.s
            if (r4 == 0) goto L_0x0025
            color.support.v7.widget.b$b r5 = r11.f
            r5.setSelector(r4)
        L_0x0025:
            color.support.v7.widget.b$b r4 = r11.f
            color.support.v7.widget.b$a r5 = new color.support.v7.widget.b$a
            android.widget.ListAdapter r7 = r11.e
            r5.<init>(r7)
            r4.setAdapter(r5)
            color.support.v7.widget.b$b r4 = r11.f
            android.widget.AdapterView$OnItemClickListener r5 = r11.t
            r4.setOnItemClickListener(r5)
            color.support.v7.widget.b$b r4 = r11.f
            r4.setFocusable(r6)
            color.support.v7.widget.b$b r4 = r11.f
            r4.setFocusableInTouchMode(r6)
            color.support.v7.widget.b$b r4 = r11.f
            color.support.v7.widget.b$3 r5 = new color.support.v7.widget.b$3
            r5.<init>()
            r4.setOnItemSelectedListener(r5)
            color.support.v7.widget.b$b r4 = r11.f
            color.support.v7.widget.b$f r5 = r11.x
            r4.setOnScrollListener(r5)
            android.widget.AdapterView$OnItemSelectedListener r4 = r11.u
            if (r4 == 0) goto L_0x005c
            color.support.v7.widget.b$b r5 = r11.f
            r5.setOnItemSelectedListener(r4)
        L_0x005c:
            color.support.v7.widget.b$b r4 = r11.f
            android.view.View r5 = r11.o
            if (r5 == 0) goto L_0x00b8
            android.widget.LinearLayout r7 = new android.widget.LinearLayout
            r7.<init>(r0)
            r7.setOrientation(r6)
            android.widget.LinearLayout$LayoutParams r0 = new android.widget.LinearLayout$LayoutParams
            r8 = 1065353216(0x3f800000, float:1.0)
            r0.<init>(r2, r3, r8)
            int r8 = r11.p
            if (r8 == 0) goto L_0x0097
            if (r8 == r6) goto L_0x0090
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r4 = "Invalid hint position "
            r0.append(r4)
            int r4 = r11.p
            r0.append(r4)
            java.lang.String r0 = r0.toString()
            java.lang.String r4 = "BaseListPopupWindow"
            android.util.Log.e(r4, r0)
            goto L_0x009d
        L_0x0090:
            r7.addView(r4, r0)
            r7.addView(r5)
            goto L_0x009d
        L_0x0097:
            r7.addView(r5)
            r7.addView(r4, r0)
        L_0x009d:
            int r0 = r11.h
            int r0 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r1)
            r5.measure(r0, r3)
            android.view.ViewGroup$LayoutParams r0 = r5.getLayoutParams()
            android.widget.LinearLayout$LayoutParams r0 = (android.widget.LinearLayout.LayoutParams) r0
            int r4 = r5.getMeasuredHeight()
            int r5 = r0.topMargin
            int r4 = r4 + r5
            int r0 = r0.bottomMargin
            int r0 = r0 + r4
            r4 = r7
            goto L_0x00b9
        L_0x00b8:
            r0 = r3
        L_0x00b9:
            color.support.v7.widget.c r5 = r11.c
            r5.setContentView(r4)
            goto L_0x00dd
        L_0x00bf:
            color.support.v7.widget.c r0 = r11.c
            android.view.View r0 = r0.getContentView()
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
            android.view.View r0 = r11.o
            if (r0 == 0) goto L_0x00dc
            android.view.ViewGroup$LayoutParams r4 = r0.getLayoutParams()
            android.widget.LinearLayout$LayoutParams r4 = (android.widget.LinearLayout.LayoutParams) r4
            int r0 = r0.getMeasuredHeight()
            int r5 = r4.topMargin
            int r0 = r0 + r5
            int r4 = r4.bottomMargin
            int r0 = r0 + r4
            goto L_0x00dd
        L_0x00dc:
            r0 = r3
        L_0x00dd:
            color.support.v7.widget.c r4 = r11.c
            android.graphics.drawable.Drawable r4 = r4.getBackground()
            if (r4 == 0) goto L_0x00ff
            android.graphics.Rect r3 = r11.B
            r4.getPadding(r3)
            android.graphics.Rect r3 = r11.B
            int r3 = r3.top
            android.graphics.Rect r4 = r11.B
            int r4 = r4.bottom
            int r3 = r3 + r4
            boolean r4 = r11.k
            if (r4 != 0) goto L_0x0104
            android.graphics.Rect r4 = r11.B
            int r4 = r4.top
            int r4 = -r4
            r11.j = r4
            goto L_0x0104
        L_0x00ff:
            android.graphics.Rect r4 = r11.B
            r4.setEmpty()
        L_0x0104:
            color.support.v7.widget.c r4 = r11.c
            int r4 = r4.getInputMethodMode()
            r5 = 2
            color.support.v7.widget.c r4 = r11.c
            android.view.View r5 = r11.l()
            int r6 = r11.j
            int r4 = r4.getMaxAvailableHeight(r5, r6)
            boolean r5 = r11.m
            if (r5 != 0) goto L_0x0175
            int r5 = r11.g
            if (r5 != r2) goto L_0x0120
            goto L_0x0175
        L_0x0120:
            int r5 = r11.h
            r6 = -2
            if (r5 == r6) goto L_0x014a
            r1 = 1073741824(0x40000000, float:2.0)
            if (r5 == r2) goto L_0x012f
            int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r5, r1)
        L_0x012d:
            r6 = r1
            goto L_0x0165
        L_0x012f:
            android.content.Context r2 = r11.f1562b
            android.content.res.Resources r2 = r2.getResources()
            android.util.DisplayMetrics r2 = r2.getDisplayMetrics()
            int r2 = r2.widthPixels
            android.graphics.Rect r5 = r11.B
            int r5 = r5.left
            android.graphics.Rect r6 = r11.B
            int r6 = r6.right
            int r5 = r5 + r6
            int r2 = r2 - r5
            int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r2, r1)
            goto L_0x012d
        L_0x014a:
            android.content.Context r2 = r11.f1562b
            android.content.res.Resources r2 = r2.getResources()
            android.util.DisplayMetrics r2 = r2.getDisplayMetrics()
            int r2 = r2.widthPixels
            android.graphics.Rect r5 = r11.B
            int r5 = r5.left
            android.graphics.Rect r6 = r11.B
            int r6 = r6.right
            int r5 = r5 + r6
            int r2 = r2 - r5
            int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r2, r1)
            goto L_0x012d
        L_0x0165:
            color.support.v7.widget.b$b r5 = r11.f
            r7 = 0
            r8 = -1
            int r9 = r4 - r0
            r10 = -1
            int r1 = r5.a(r6, r7, r8, r9, r10)
            if (r1 <= 0) goto L_0x0173
            int r0 = r0 + r3
        L_0x0173:
            int r1 = r1 + r0
            return r1
        L_0x0175:
            int r4 = r4 + r3
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: color.support.v7.widget.b.j():int");
    }

    /* compiled from: ColorBaseListPopupWindow */
    public static abstract class c implements View.OnTouchListener {

        /* renamed from: a  reason: collision with root package name */
        private final float f1568a;

        /* renamed from: b  reason: collision with root package name */
        private final int f1569b;
        private final int c;
        /* access modifiers changed from: private */
        public final View d;
        private Runnable e;
        private Runnable f;
        private boolean g;
        private boolean h;
        private int i;
        private final int[] j;

        public abstract b a();

        public boolean onTouch(View view, MotionEvent motionEvent) {
            boolean z;
            boolean z2 = this.g;
            if (z2) {
                z = this.h ? b(motionEvent) : b(motionEvent) || !c();
            } else {
                z = a(motionEvent) && b();
                if (z) {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                    this.d.onTouchEvent(obtain);
                    obtain.recycle();
                }
            }
            this.g = z;
            if (z || z2) {
                return true;
            }
            return false;
        }

        /* access modifiers changed from: protected */
        public boolean b() {
            b a2 = a();
            if (a2 == null || a2.d()) {
                return true;
            }
            a2.h();
            return true;
        }

        /* access modifiers changed from: protected */
        public boolean c() {
            b a2 = a();
            if (a2 == null || !a2.d()) {
                return true;
            }
            a2.c();
            return true;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0017, code lost:
            if (r1 != 3) goto L_0x0070;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private boolean a(android.view.MotionEvent r6) {
            /*
                r5 = this;
                android.view.View r0 = r5.d
                boolean r1 = r0.isEnabled()
                r2 = 0
                if (r1 != 0) goto L_0x000a
                return r2
            L_0x000a:
                int r1 = androidx.core.g.h.a(r6)
                if (r1 == 0) goto L_0x0041
                r3 = 1
                if (r1 == r3) goto L_0x003d
                r4 = 2
                if (r1 == r4) goto L_0x001a
                r6 = 3
                if (r1 == r6) goto L_0x003d
                goto L_0x0070
            L_0x001a:
                int r1 = r5.i
                int r1 = r6.findPointerIndex(r1)
                if (r1 < 0) goto L_0x0070
                float r4 = r6.getX(r1)
                float r6 = r6.getY(r1)
                float r1 = r5.f1568a
                boolean r6 = a(r0, r4, r6, r1)
                if (r6 != 0) goto L_0x0070
                r5.d()
                android.view.ViewParent r6 = r0.getParent()
                r6.requestDisallowInterceptTouchEvent(r3)
                return r3
            L_0x003d:
                r5.d()
                goto L_0x0070
            L_0x0041:
                int r6 = r6.getPointerId(r2)
                r5.i = r6
                r5.h = r2
                java.lang.Runnable r6 = r5.e
                r1 = 0
                if (r6 != 0) goto L_0x0055
                color.support.v7.widget.b$c$a r6 = new color.support.v7.widget.b$c$a
                r6.<init>(r5, r1)
                r5.e = r6
            L_0x0055:
                java.lang.Runnable r6 = r5.e
                int r3 = r5.f1569b
                long r3 = (long) r3
                r0.postDelayed(r6, r3)
                java.lang.Runnable r6 = r5.f
                if (r6 != 0) goto L_0x0068
                color.support.v7.widget.b$c$b r6 = new color.support.v7.widget.b$c$b
                r6.<init>(r5, r1)
                r5.f = r6
            L_0x0068:
                java.lang.Runnable r6 = r5.f
                int r1 = r5.c
                long r3 = (long) r1
                r0.postDelayed(r6, r3)
            L_0x0070:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: color.support.v7.widget.b.c.a(android.view.MotionEvent):boolean");
        }

        private void d() {
            Runnable runnable = this.f;
            if (runnable != null) {
                this.d.removeCallbacks(runnable);
            }
            Runnable runnable2 = this.e;
            if (runnable2 != null) {
                this.d.removeCallbacks(runnable2);
            }
        }

        /* access modifiers changed from: private */
        public void e() {
            d();
            View view = this.d;
            if (view.isEnabled() && !view.isLongClickable() && b()) {
                view.getParent().requestDisallowInterceptTouchEvent(true);
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                view.onTouchEvent(obtain);
                obtain.recycle();
                this.g = true;
                this.h = true;
            }
        }

        private boolean b(MotionEvent motionEvent) {
            C0049b a2;
            View view = this.d;
            b a3 = a();
            if (a3 == null || !a3.d() || (a2 = a3.f) == null || !a2.isShown()) {
                return false;
            }
            MotionEvent obtainNoHistory = MotionEvent.obtainNoHistory(motionEvent);
            b(view, obtainNoHistory);
            a(a2, obtainNoHistory);
            boolean a4 = a2.a(obtainNoHistory, this.i);
            obtainNoHistory.recycle();
            int a5 = androidx.core.g.h.a(motionEvent);
            return a4 && (a5 != 1 && a5 != 3);
        }

        private static boolean a(View view, float f2, float f3, float f4) {
            float f5 = -f4;
            return f2 >= f5 && f3 >= f5 && f2 < ((float) (view.getRight() - view.getLeft())) + f4 && f3 < ((float) (view.getBottom() - view.getTop())) + f4;
        }

        private boolean a(View view, MotionEvent motionEvent) {
            int[] iArr = this.j;
            view.getLocationOnScreen(iArr);
            motionEvent.offsetLocation((float) (-iArr[0]), (float) (-iArr[1]));
            return true;
        }

        private boolean b(View view, MotionEvent motionEvent) {
            int[] iArr = this.j;
            view.getLocationOnScreen(iArr);
            motionEvent.offsetLocation((float) iArr[0], (float) iArr[1]);
            return true;
        }

        /* compiled from: ColorBaseListPopupWindow */
        private class a implements Runnable {
            private a() {
            }

            /* synthetic */ a(c cVar, AnonymousClass1 r2) {
                this();
            }

            public void run() {
                c.this.d.getParent().requestDisallowInterceptTouchEvent(true);
            }
        }

        /* renamed from: color.support.v7.widget.b$c$b  reason: collision with other inner class name */
        /* compiled from: ColorBaseListPopupWindow */
        private class C0050b implements Runnable {
            private C0050b() {
            }

            /* synthetic */ C0050b(c cVar, AnonymousClass1 r2) {
                this();
            }

            public void run() {
                c.this.e();
            }
        }
    }

    /* compiled from: ColorBaseListPopupWindow */
    private class a implements ListAdapter {

        /* renamed from: b  reason: collision with root package name */
        private ListAdapter f1567b;

        public a(ListAdapter listAdapter) {
            this.f1567b = listAdapter;
        }

        public void registerDataSetObserver(DataSetObserver dataSetObserver) {
            ListAdapter listAdapter = this.f1567b;
            if (listAdapter != null) {
                listAdapter.registerDataSetObserver(dataSetObserver);
            }
        }

        public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            ListAdapter listAdapter = this.f1567b;
            if (listAdapter != null) {
                listAdapter.unregisterDataSetObserver(dataSetObserver);
            }
        }

        public int getCount() {
            ListAdapter listAdapter = this.f1567b;
            if (listAdapter == null) {
                return 0;
            }
            return listAdapter.getCount();
        }

        public Object getItem(int i) {
            ListAdapter listAdapter = this.f1567b;
            if (listAdapter == null) {
                return null;
            }
            return listAdapter.getItem(i);
        }

        public long getItemId(int i) {
            ListAdapter listAdapter = this.f1567b;
            if (listAdapter == null) {
                return 0;
            }
            return listAdapter.getItemId(i);
        }

        public boolean hasStableIds() {
            ListAdapter listAdapter = this.f1567b;
            return listAdapter != null && listAdapter.hasStableIds();
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            ListAdapter listAdapter = this.f1567b;
            if (listAdapter == null) {
                return null;
            }
            View view2 = listAdapter.getView(i, view, viewGroup);
            if (view2 == null) {
                return view2;
            }
            view2.setAlpha(0.0f);
            view2.animate().alpha(1.0f).setInterpolator(androidx.core.g.b.b.a(0.33f, 0.0f, 0.66f, 1.0f)).setDuration(350).setStartDelay(150).start();
            return view2;
        }

        public int getItemViewType(int i) {
            ListAdapter listAdapter = this.f1567b;
            if (listAdapter == null) {
                return 0;
            }
            return listAdapter.getItemViewType(i);
        }

        public int getViewTypeCount() {
            if (this.f1567b != null) {
                Log.d("ColorBaseListPopupWindow", "listAdapter.typeCount = " + this.f1567b.getViewTypeCount());
            } else if (b.this.e != null) {
                Log.d("ColorBaseListPopupWindow", "getViewTypeCount:listAdapter = null,mAdapter = " + b.this.e + ",typeCount = " + b.this.e.getViewTypeCount());
            } else {
                Log.d("ColorBaseListPopupWindow", "getViewTypeCount:listAdapter = null,mAdapter = " + b.this.e);
            }
            ListAdapter listAdapter = this.f1567b;
            if (listAdapter == null) {
                return 0;
            }
            return listAdapter.getViewTypeCount();
        }

        public boolean isEmpty() {
            ListAdapter listAdapter = this.f1567b;
            return listAdapter != null && listAdapter.isEmpty();
        }

        public boolean areAllItemsEnabled() {
            ListAdapter listAdapter = this.f1567b;
            return listAdapter != null && listAdapter.areAllItemsEnabled();
        }

        public boolean isEnabled(int i) {
            ListAdapter listAdapter = this.f1567b;
            return listAdapter != null && listAdapter.isEnabled(i);
        }
    }

    /* renamed from: color.support.v7.widget.b$b  reason: collision with other inner class name */
    /* compiled from: ColorBaseListPopupWindow */
    private static class C0049b extends color.support.v7.internal.widget.c {
        /* access modifiers changed from: private */
        public boolean f;
        private boolean g;
        private boolean h;
        private z i;
        private androidx.core.widget.f j;

        public C0049b(Context context, boolean z) {
            super(context, (AttributeSet) null, R.attr.dropDownListViewStyle);
            this.g = z;
            setCacheColorHint(0);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:5:0x000c, code lost:
            if (r0 != 3) goto L_0x000e;
         */
        /* JADX WARNING: Removed duplicated region for block: B:12:0x001e  */
        /* JADX WARNING: Removed duplicated region for block: B:22:0x004f  */
        /* JADX WARNING: Removed duplicated region for block: B:26:0x0065  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean a(android.view.MotionEvent r8, int r9) {
            /*
                r7 = this;
                int r0 = androidx.core.g.h.a(r8)
                r1 = 0
                r2 = 1
                if (r0 == r2) goto L_0x0016
                r3 = 2
                if (r0 == r3) goto L_0x0014
                r9 = 3
                if (r0 == r9) goto L_0x0011
            L_0x000e:
                r9 = r1
                r3 = r2
                goto L_0x0046
            L_0x0011:
                r9 = r1
                r3 = r9
                goto L_0x0046
            L_0x0014:
                r3 = r2
                goto L_0x0017
            L_0x0016:
                r3 = r1
            L_0x0017:
                int r9 = r8.findPointerIndex(r9)
                if (r9 >= 0) goto L_0x001e
                goto L_0x0011
            L_0x001e:
                float r4 = r8.getX(r9)
                int r4 = (int) r4
                float r9 = r8.getY(r9)
                int r9 = (int) r9
                int r5 = r7.pointToPosition(r4, r9)
                r6 = -1
                if (r5 != r6) goto L_0x0031
                r9 = r2
                goto L_0x0046
            L_0x0031:
                int r3 = r7.getFirstVisiblePosition()
                int r3 = r5 - r3
                android.view.View r3 = r7.getChildAt(r3)
                float r4 = (float) r4
                float r9 = (float) r9
                r7.a(r3, r5, r4, r9)
                if (r0 != r2) goto L_0x000e
                r7.a((android.view.View) r3, (int) r5)
                goto L_0x000e
            L_0x0046:
                if (r3 == 0) goto L_0x004a
                if (r9 == 0) goto L_0x004d
            L_0x004a:
                r7.d()
            L_0x004d:
                if (r3 == 0) goto L_0x0065
                androidx.core.widget.f r9 = r7.j
                if (r9 != 0) goto L_0x005a
                androidx.core.widget.f r9 = new androidx.core.widget.f
                r9.<init>(r7)
                r7.j = r9
            L_0x005a:
                androidx.core.widget.f r9 = r7.j
                r9.a((boolean) r2)
                androidx.core.widget.f r9 = r7.j
                r9.onTouch(r7, r8)
                goto L_0x006c
            L_0x0065:
                androidx.core.widget.f r8 = r7.j
                if (r8 == 0) goto L_0x006c
                r8.a((boolean) r1)
            L_0x006c:
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: color.support.v7.widget.b.C0049b.a(android.view.MotionEvent, int):boolean");
        }

        private void a(View view, int i2) {
            performItemClick(view, i2, getItemIdAtPosition(i2));
        }

        private void d() {
            this.h = false;
            setPressed(false);
            drawableStateChanged();
            z zVar = this.i;
            if (zVar != null) {
                zVar.b();
                this.i = null;
            }
        }

        private void a(View view, int i2, float f2, float f3) {
            this.h = true;
            setPressed(true);
            layoutChildren();
            setSelection(i2);
            a(i2, view, f2, f3);
            setSelectorEnabled(false);
            refreshDrawableState();
        }

        /* access modifiers changed from: protected */
        public boolean c() {
            return this.h || super.c();
        }

        public boolean isInTouchMode() {
            return (this.g && this.f) || super.isInTouchMode();
        }

        public boolean hasWindowFocus() {
            return this.g || super.hasWindowFocus();
        }

        public boolean isFocused() {
            return this.g || super.isFocused();
        }

        public boolean hasFocus() {
            return this.g || super.hasFocus();
        }
    }

    /* compiled from: ColorBaseListPopupWindow */
    private class e extends DataSetObserver {
        private e() {
        }

        /* synthetic */ e(b bVar, AnonymousClass1 r2) {
            this();
        }

        public void onChanged() {
            if (b.this.d()) {
                b.this.h();
            }
        }

        public void onInvalidated() {
            b.this.c();
        }
    }

    /* compiled from: ColorBaseListPopupWindow */
    private class d implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f1572a;

        public void run() {
            this.f1572a.n();
        }
    }

    /* compiled from: ColorBaseListPopupWindow */
    private class h implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f1576a;

        public void run() {
            if (this.f1576a.f != null && this.f1576a.f.getCount() > this.f1576a.f.getChildCount() && this.f1576a.f.getChildCount() <= this.f1576a.d) {
                this.f1576a.c.setInputMethodMode(2);
                this.f1576a.h();
            }
        }
    }

    /* compiled from: ColorBaseListPopupWindow */
    protected class g implements View.OnTouchListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f1575a;

        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (action == 0 && this.f1575a.c != null && this.f1575a.c.isShowing() && x >= 0 && x < this.f1575a.c.getWidth() && y >= 0 && y < this.f1575a.c.getHeight()) {
                this.f1575a.A.postDelayed(this.f1575a.v, 250);
                return false;
            } else if (action != 1) {
                return false;
            } else {
                this.f1575a.A.removeCallbacks(this.f1575a.v);
                return false;
            }
        }
    }

    /* compiled from: ColorBaseListPopupWindow */
    private class f implements AbsListView.OnScrollListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f1574a;

        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }

        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 1 && !this.f1574a.o() && this.f1574a.c.getContentView() != null) {
                this.f1574a.A.removeCallbacks(this.f1574a.v);
                this.f1574a.v.run();
            }
        }
    }

    private void a(boolean z2) {
        Method method = f1561a;
        if (method != null) {
            try {
                method.invoke(this.c, new Object[]{Boolean.valueOf(z2)});
            } catch (Exception unused) {
                Log.i("BaseListPopupWindow", "Could not call setClipToScreenEnabled() on PopupWindow. Oh well.");
            }
        }
    }
}
