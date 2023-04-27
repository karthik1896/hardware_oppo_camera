package androidx.viewpager2.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import java.util.Locale;

/* compiled from: ScrollEventAdapter */
final class e extends RecyclerView.n {

    /* renamed from: a  reason: collision with root package name */
    private ViewPager2.e f1393a;

    /* renamed from: b  reason: collision with root package name */
    private final ViewPager2 f1394b;
    private final RecyclerView c = this.f1394b.d;
    private final LinearLayoutManager d = ((LinearLayoutManager) this.c.getLayoutManager());
    private int e;
    private int f;
    private a g = new a();
    private int h;
    private int i;
    private boolean j;
    private boolean k;
    private boolean l;
    private boolean m;

    e(ViewPager2 viewPager2) {
        this.f1394b = viewPager2;
        f();
    }

    private void f() {
        this.e = 0;
        this.f = 0;
        this.g.a();
        this.h = -1;
        this.i = -1;
        this.j = false;
        this.k = false;
        this.m = false;
        this.l = false;
    }

    public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
        boolean z = true;
        if (!(this.e == 1 && this.f == 1) && i2 == 1) {
            a(false);
        } else if (!h() || i2 != 2) {
            if (h() && i2 == 0) {
                g();
                if (!this.k) {
                    if (this.g.f1395a != -1) {
                        a(this.g.f1395a, 0.0f, 0);
                    }
                } else if (this.g.c != 0) {
                    z = false;
                } else if (this.h != this.g.f1395a) {
                    b(this.g.f1395a);
                }
                if (z) {
                    a(0);
                    f();
                }
            }
            if (this.e == 2 && i2 == 0 && this.l) {
                g();
                if (this.g.c == 0) {
                    if (this.i != this.g.f1395a) {
                        b(this.g.f1395a == -1 ? 0 : this.g.f1395a);
                    }
                    a(0);
                    f();
                }
            }
        } else if (this.k) {
            a(2);
            this.j = true;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001d, code lost:
        if ((r5 < 0) == r3.f1394b.b()) goto L_0x0022;
     */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x002b  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x003d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onScrolled(androidx.recyclerview.widget.RecyclerView r4, int r5, int r6) {
        /*
            r3 = this;
            r4 = 1
            r3.k = r4
            r3.g()
            boolean r0 = r3.j
            r1 = -1
            r2 = 0
            if (r0 == 0) goto L_0x0041
            r3.j = r2
            if (r6 > 0) goto L_0x0022
            if (r6 != 0) goto L_0x0020
            if (r5 >= 0) goto L_0x0016
            r5 = r4
            goto L_0x0017
        L_0x0016:
            r5 = r2
        L_0x0017:
            androidx.viewpager2.widget.ViewPager2 r6 = r3.f1394b
            boolean r6 = r6.b()
            if (r5 != r6) goto L_0x0020
            goto L_0x0022
        L_0x0020:
            r5 = r2
            goto L_0x0023
        L_0x0022:
            r5 = r4
        L_0x0023:
            if (r5 == 0) goto L_0x0031
            androidx.viewpager2.widget.e$a r5 = r3.g
            int r5 = r5.c
            if (r5 == 0) goto L_0x0031
            androidx.viewpager2.widget.e$a r5 = r3.g
            int r5 = r5.f1395a
            int r5 = r5 + r4
            goto L_0x0035
        L_0x0031:
            androidx.viewpager2.widget.e$a r5 = r3.g
            int r5 = r5.f1395a
        L_0x0035:
            r3.i = r5
            int r5 = r3.h
            int r6 = r3.i
            if (r5 == r6) goto L_0x004f
            r3.b(r6)
            goto L_0x004f
        L_0x0041:
            int r5 = r3.e
            if (r5 != 0) goto L_0x004f
            androidx.viewpager2.widget.e$a r5 = r3.g
            int r5 = r5.f1395a
            if (r5 != r1) goto L_0x004c
            r5 = r2
        L_0x004c:
            r3.b(r5)
        L_0x004f:
            androidx.viewpager2.widget.e$a r5 = r3.g
            int r5 = r5.f1395a
            if (r5 != r1) goto L_0x0057
            r5 = r2
            goto L_0x005b
        L_0x0057:
            androidx.viewpager2.widget.e$a r5 = r3.g
            int r5 = r5.f1395a
        L_0x005b:
            androidx.viewpager2.widget.e$a r6 = r3.g
            float r6 = r6.f1396b
            androidx.viewpager2.widget.e$a r0 = r3.g
            int r0 = r0.c
            r3.a(r5, r6, r0)
            androidx.viewpager2.widget.e$a r5 = r3.g
            int r5 = r5.f1395a
            int r6 = r3.i
            if (r5 == r6) goto L_0x0070
            if (r6 != r1) goto L_0x0080
        L_0x0070:
            androidx.viewpager2.widget.e$a r5 = r3.g
            int r5 = r5.c
            if (r5 != 0) goto L_0x0080
            int r5 = r3.f
            if (r5 == r4) goto L_0x0080
            r3.a((int) r2)
            r3.f()
        L_0x0080:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager2.widget.e.onScrolled(androidx.recyclerview.widget.RecyclerView, int, int):void");
    }

    private void g() {
        int i2;
        float f2;
        a aVar = this.g;
        aVar.f1395a = this.d.findFirstVisibleItemPosition();
        if (aVar.f1395a == -1) {
            aVar.a();
            return;
        }
        View findViewByPosition = this.d.findViewByPosition(aVar.f1395a);
        if (findViewByPosition == null) {
            aVar.a();
            return;
        }
        int leftDecorationWidth = this.d.getLeftDecorationWidth(findViewByPosition);
        int rightDecorationWidth = this.d.getRightDecorationWidth(findViewByPosition);
        int topDecorationHeight = this.d.getTopDecorationHeight(findViewByPosition);
        int bottomDecorationHeight = this.d.getBottomDecorationHeight(findViewByPosition);
        ViewGroup.LayoutParams layoutParams = findViewByPosition.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            leftDecorationWidth += marginLayoutParams.leftMargin;
            rightDecorationWidth += marginLayoutParams.rightMargin;
            topDecorationHeight += marginLayoutParams.topMargin;
            bottomDecorationHeight += marginLayoutParams.bottomMargin;
        }
        int height = findViewByPosition.getHeight() + topDecorationHeight + bottomDecorationHeight;
        int width = rightDecorationWidth + findViewByPosition.getWidth() + leftDecorationWidth;
        if (this.d.getOrientation() == 0) {
            i2 = (findViewByPosition.getLeft() - leftDecorationWidth) - this.c.getPaddingLeft();
            if (this.f1394b.b()) {
                i2 = -i2;
            }
        } else {
            i2 = (findViewByPosition.getTop() - topDecorationHeight) - this.c.getPaddingTop();
            width = height;
        }
        aVar.c = -i2;
        if (aVar.c >= 0) {
            if (width == 0) {
                f2 = 0.0f;
            } else {
                f2 = ((float) aVar.c) / ((float) width);
            }
            aVar.f1396b = f2;
        } else if (new a(this.d).a()) {
            throw new IllegalStateException("Page(s) contain a ViewGroup with a LayoutTransition (or animateLayoutChanges=\"true\"), which interferes with the scrolling animation. Make sure to call getLayoutTransition().setAnimateParentHierarchy(false) on all ViewGroups with a LayoutTransition before an animation is started.");
        } else {
            throw new IllegalStateException(String.format(Locale.US, "Page can only be offset by a positive amount, not by %d", new Object[]{Integer.valueOf(aVar.c)}));
        }
    }

    private void a(boolean z) {
        this.m = z;
        this.e = z ? 4 : 1;
        int i2 = this.i;
        if (i2 != -1) {
            this.h = i2;
            this.i = -1;
        } else if (this.h == -1) {
            this.h = i();
        }
        a(1);
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.l = true;
    }

    /* access modifiers changed from: package-private */
    public void a(int i2, boolean z) {
        this.e = z ? 2 : 3;
        boolean z2 = false;
        this.m = false;
        if (this.i != i2) {
            z2 = true;
        }
        this.i = i2;
        a(2);
        if (z2) {
            b(i2);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(ViewPager2.e eVar) {
        this.f1393a = eVar;
    }

    /* access modifiers changed from: package-private */
    public int b() {
        return this.f;
    }

    /* access modifiers changed from: package-private */
    public boolean c() {
        return this.f == 0;
    }

    /* access modifiers changed from: package-private */
    public boolean d() {
        return this.m;
    }

    private boolean h() {
        int i2 = this.e;
        return i2 == 1 || i2 == 4;
    }

    /* access modifiers changed from: package-private */
    public double e() {
        g();
        return ((double) this.g.f1395a) + ((double) this.g.f1396b);
    }

    private void a(int i2) {
        if ((this.e != 3 || this.f != 0) && this.f != i2) {
            this.f = i2;
            ViewPager2.e eVar = this.f1393a;
            if (eVar != null) {
                eVar.onPageScrollStateChanged(i2);
            }
        }
    }

    private void b(int i2) {
        ViewPager2.e eVar = this.f1393a;
        if (eVar != null) {
            eVar.onPageSelected(i2);
        }
    }

    private void a(int i2, float f2, int i3) {
        ViewPager2.e eVar = this.f1393a;
        if (eVar != null) {
            eVar.onPageScrolled(i2, f2, i3);
        }
    }

    private int i() {
        return this.d.findFirstVisibleItemPosition();
    }

    /* compiled from: ScrollEventAdapter */
    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        int f1395a;

        /* renamed from: b  reason: collision with root package name */
        float f1396b;
        int c;

        a() {
        }

        /* access modifiers changed from: package-private */
        public void a() {
            this.f1395a = -1;
            this.f1396b = 0.0f;
            this.c = 0;
        }
    }
}
