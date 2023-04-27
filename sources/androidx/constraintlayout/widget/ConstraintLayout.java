package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.a.a.e;
import androidx.constraintlayout.a.a.f;
import androidx.constraintlayout.a.a.g;
import androidx.constraintlayout.a.a.i;
import com.oppo.exif.OppoExifInterface;
import java.util.ArrayList;
import java.util.HashMap;

public class ConstraintLayout extends ViewGroup {

    /* renamed from: a  reason: collision with root package name */
    SparseArray<View> f547a = new SparseArray<>();

    /* renamed from: b  reason: collision with root package name */
    g f548b = new g();
    int c = -1;
    int d = -1;
    int e = 0;
    int f = 0;
    private ArrayList<b> g = new ArrayList<>(4);
    private final ArrayList<f> h = new ArrayList<>(100);
    private int i = 0;
    private int j = 0;
    private int k = Integer.MAX_VALUE;
    private int l = Integer.MAX_VALUE;
    private boolean m = true;
    private int n = 7;
    private c o = null;
    private int p = -1;
    private HashMap<String, Integer> q = new HashMap<>();
    private int r = -1;
    private int s = -1;
    private androidx.constraintlayout.a.f t;

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public void a(int i2, Object obj, Object obj2) {
        if (i2 == 0 && (obj instanceof String) && (obj2 instanceof Integer)) {
            if (this.q == null) {
                this.q = new HashMap<>();
            }
            String str = (String) obj;
            int indexOf = str.indexOf("/");
            if (indexOf != -1) {
                str = str.substring(indexOf + 1);
            }
            this.q.put(str, Integer.valueOf(((Integer) obj2).intValue()));
        }
    }

    public Object a(int i2, Object obj) {
        if (i2 != 0 || !(obj instanceof String)) {
            return null;
        }
        String str = (String) obj;
        HashMap<String, Integer> hashMap = this.q;
        if (hashMap == null || !hashMap.containsKey(str)) {
            return null;
        }
        return this.q.get(str);
    }

    public ConstraintLayout(Context context) {
        super(context);
        b((AttributeSet) null);
    }

    public ConstraintLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b(attributeSet);
    }

    public ConstraintLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        b(attributeSet);
    }

    public void setId(int i2) {
        this.f547a.remove(getId());
        super.setId(i2);
        this.f547a.put(getId(), this);
    }

    private void b(AttributeSet attributeSet) {
        this.f548b.a((Object) this);
        this.f547a.put(getId(), this);
        this.o = null;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                if (index == R.styleable.ConstraintLayout_Layout_android_minWidth) {
                    this.i = obtainStyledAttributes.getDimensionPixelOffset(index, this.i);
                } else if (index == R.styleable.ConstraintLayout_Layout_android_minHeight) {
                    this.j = obtainStyledAttributes.getDimensionPixelOffset(index, this.j);
                } else if (index == R.styleable.ConstraintLayout_Layout_android_maxWidth) {
                    this.k = obtainStyledAttributes.getDimensionPixelOffset(index, this.k);
                } else if (index == R.styleable.ConstraintLayout_Layout_android_maxHeight) {
                    this.l = obtainStyledAttributes.getDimensionPixelOffset(index, this.l);
                } else if (index == R.styleable.ConstraintLayout_Layout_layout_optimizationLevel) {
                    this.n = obtainStyledAttributes.getInt(index, this.n);
                } else if (index == R.styleable.ConstraintLayout_Layout_constraintSet) {
                    int resourceId = obtainStyledAttributes.getResourceId(index, 0);
                    try {
                        this.o = new c();
                        this.o.a(getContext(), resourceId);
                    } catch (Resources.NotFoundException unused) {
                        this.o = null;
                    }
                    this.p = resourceId;
                }
            }
            obtainStyledAttributes.recycle();
        }
        this.f548b.a(this.n);
    }

    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i2, layoutParams);
        if (Build.VERSION.SDK_INT < 14) {
            onViewAdded(view);
        }
    }

    public void removeView(View view) {
        super.removeView(view);
        if (Build.VERSION.SDK_INT < 14) {
            onViewRemoved(view);
        }
    }

    public void onViewAdded(View view) {
        if (Build.VERSION.SDK_INT >= 14) {
            super.onViewAdded(view);
        }
        f a2 = a(view);
        if ((view instanceof e) && !(a2 instanceof i)) {
            a aVar = (a) view.getLayoutParams();
            aVar.al = new i();
            aVar.Y = true;
            ((i) aVar.al).a(aVar.S);
        }
        if (view instanceof b) {
            b bVar = (b) view;
            bVar.a();
            ((a) view.getLayoutParams()).Z = true;
            if (!this.g.contains(bVar)) {
                this.g.add(bVar);
            }
        }
        this.f547a.put(view.getId(), view);
        this.m = true;
    }

    public void onViewRemoved(View view) {
        if (Build.VERSION.SDK_INT >= 14) {
            super.onViewRemoved(view);
        }
        this.f547a.remove(view.getId());
        f a2 = a(view);
        this.f548b.c(a2);
        this.g.remove(view);
        this.h.remove(a2);
        this.m = true;
    }

    public void setMinWidth(int i2) {
        if (i2 != this.i) {
            this.i = i2;
            requestLayout();
        }
    }

    public void setMinHeight(int i2) {
        if (i2 != this.j) {
            this.j = i2;
            requestLayout();
        }
    }

    public int getMinWidth() {
        return this.i;
    }

    public int getMinHeight() {
        return this.j;
    }

    public void setMaxWidth(int i2) {
        if (i2 != this.k) {
            this.k = i2;
            requestLayout();
        }
    }

    public void setMaxHeight(int i2) {
        if (i2 != this.l) {
            this.l = i2;
            requestLayout();
        }
    }

    public int getMaxWidth() {
        return this.k;
    }

    public int getMaxHeight() {
        return this.l;
    }

    private void b() {
        int childCount = getChildCount();
        boolean z = false;
        int i2 = 0;
        while (true) {
            if (i2 >= childCount) {
                break;
            } else if (getChildAt(i2).isLayoutRequested()) {
                z = true;
                break;
            } else {
                i2++;
            }
        }
        if (z) {
            this.h.clear();
            c();
        }
    }

    private void c() {
        int i2;
        int i3;
        int i4;
        float f2;
        int i5;
        f b2;
        f b3;
        f b4;
        f b5;
        int i6;
        boolean isInEditMode = isInEditMode();
        int childCount = getChildCount();
        boolean z = false;
        if (isInEditMode) {
            for (int i7 = 0; i7 < childCount; i7++) {
                View childAt = getChildAt(i7);
                try {
                    String resourceName = getResources().getResourceName(childAt.getId());
                    a(0, resourceName, Integer.valueOf(childAt.getId()));
                    int indexOf = resourceName.indexOf(47);
                    if (indexOf != -1) {
                        resourceName = resourceName.substring(indexOf + 1);
                    }
                    b(childAt.getId()).a(resourceName);
                } catch (Resources.NotFoundException unused) {
                }
            }
        }
        for (int i8 = 0; i8 < childCount; i8++) {
            f a2 = a(getChildAt(i8));
            if (a2 != null) {
                a2.f();
            }
        }
        if (this.p != -1) {
            for (int i9 = 0; i9 < childCount; i9++) {
                View childAt2 = getChildAt(i9);
                if (childAt2.getId() == this.p && (childAt2 instanceof d)) {
                    this.o = ((d) childAt2).getConstraintSet();
                }
            }
        }
        c cVar = this.o;
        if (cVar != null) {
            cVar.a(this);
        }
        this.f548b.U();
        int size = this.g.size();
        if (size > 0) {
            for (int i10 = 0; i10 < size; i10++) {
                this.g.get(i10).a(this);
            }
        }
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt3 = getChildAt(i11);
            if (childAt3 instanceof f) {
                ((f) childAt3).a(this);
            }
        }
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt4 = getChildAt(i12);
            f a3 = a(childAt4);
            if (a3 != null) {
                a aVar = (a) childAt4.getLayoutParams();
                aVar.a();
                if (aVar.am) {
                    aVar.am = z;
                } else if (isInEditMode) {
                    try {
                        String resourceName2 = getResources().getResourceName(childAt4.getId());
                        a(z ? 1 : 0, resourceName2, Integer.valueOf(childAt4.getId()));
                        b(childAt4.getId()).a(resourceName2.substring(resourceName2.indexOf("id/") + 3));
                    } catch (Resources.NotFoundException unused2) {
                    }
                }
                a3.e(childAt4.getVisibility());
                if (aVar.aa) {
                    a3.e(8);
                }
                a3.a((Object) childAt4);
                this.f548b.b(a3);
                if (!aVar.W || !aVar.V) {
                    this.h.add(a3);
                }
                if (aVar.Y) {
                    i iVar = (i) a3;
                    int i13 = aVar.ai;
                    int i14 = aVar.aj;
                    float f3 = aVar.ak;
                    if (Build.VERSION.SDK_INT < 17) {
                        i13 = aVar.f549a;
                        i14 = aVar.f550b;
                        f3 = aVar.c;
                    }
                    if (f3 != -1.0f) {
                        iVar.e(f3);
                    } else if (i13 != -1) {
                        iVar.u(i13);
                    } else if (i14 != -1) {
                        iVar.v(i14);
                    }
                } else if (aVar.d != -1 || aVar.e != -1 || aVar.f != -1 || aVar.g != -1 || aVar.q != -1 || aVar.p != -1 || aVar.r != -1 || aVar.s != -1 || aVar.h != -1 || aVar.i != -1 || aVar.j != -1 || aVar.k != -1 || aVar.l != -1 || aVar.Q != -1 || aVar.R != -1 || aVar.m != -1 || aVar.width == -1 || aVar.height == -1) {
                    int i15 = aVar.ab;
                    int i16 = aVar.ac;
                    int i17 = aVar.ad;
                    int i18 = aVar.ae;
                    int i19 = aVar.af;
                    int i20 = aVar.ag;
                    float f4 = aVar.ah;
                    if (Build.VERSION.SDK_INT < 17) {
                        int i21 = aVar.d;
                        int i22 = aVar.e;
                        i17 = aVar.f;
                        i18 = aVar.g;
                        int i23 = aVar.t;
                        int i24 = aVar.v;
                        f4 = aVar.z;
                        if (i21 == -1 && i22 == -1) {
                            if (aVar.q != -1) {
                                i21 = aVar.q;
                            } else if (aVar.p != -1) {
                                i22 = aVar.p;
                            }
                        }
                        int i25 = i22;
                        i15 = i21;
                        i4 = i25;
                        if (i17 == -1 && i18 == -1) {
                            if (aVar.r != -1) {
                                i17 = aVar.r;
                            } else if (aVar.s != -1) {
                                i18 = aVar.s;
                            }
                        }
                        i3 = i23;
                        i2 = i24;
                    } else {
                        i4 = i16;
                        i2 = i20;
                        i3 = i19;
                    }
                    int i26 = i18;
                    float f5 = f4;
                    int i27 = i17;
                    if (aVar.m != -1) {
                        f b6 = b(aVar.m);
                        if (b6 != null) {
                            a3.a(b6, aVar.o, aVar.n);
                        }
                    } else {
                        if (i15 != -1) {
                            f b7 = b(i15);
                            if (b7 != null) {
                                f2 = f5;
                                i6 = i26;
                                a3.a(e.c.LEFT, b7, e.c.LEFT, aVar.leftMargin, i3);
                            } else {
                                f2 = f5;
                                i6 = i26;
                            }
                            i5 = i6;
                        } else {
                            f2 = f5;
                            i5 = i26;
                            if (!(i4 == -1 || (b5 = b(i4)) == null)) {
                                a3.a(e.c.LEFT, b5, e.c.RIGHT, aVar.leftMargin, i3);
                            }
                        }
                        if (i27 != -1) {
                            f b8 = b(i27);
                            if (b8 != null) {
                                a3.a(e.c.RIGHT, b8, e.c.LEFT, aVar.rightMargin, i2);
                            }
                        } else if (!(i5 == -1 || (b4 = b(i5)) == null)) {
                            a3.a(e.c.RIGHT, b4, e.c.RIGHT, aVar.rightMargin, i2);
                        }
                        if (aVar.h != -1) {
                            f b9 = b(aVar.h);
                            if (b9 != null) {
                                a3.a(e.c.TOP, b9, e.c.TOP, aVar.topMargin, aVar.u);
                            }
                        } else if (!(aVar.i == -1 || (b3 = b(aVar.i)) == null)) {
                            a3.a(e.c.TOP, b3, e.c.BOTTOM, aVar.topMargin, aVar.u);
                        }
                        if (aVar.j != -1) {
                            f b10 = b(aVar.j);
                            if (b10 != null) {
                                a3.a(e.c.BOTTOM, b10, e.c.TOP, aVar.bottomMargin, aVar.w);
                            }
                        } else if (!(aVar.k == -1 || (b2 = b(aVar.k)) == null)) {
                            a3.a(e.c.BOTTOM, b2, e.c.BOTTOM, aVar.bottomMargin, aVar.w);
                        }
                        if (aVar.l != -1) {
                            View view = this.f547a.get(aVar.l);
                            f b11 = b(aVar.l);
                            if (!(b11 == null || view == null || !(view.getLayoutParams() instanceof a))) {
                                aVar.X = true;
                                ((a) view.getLayoutParams()).X = true;
                                a3.a(e.c.BASELINE).a(b11.a(e.c.BASELINE), 0, -1, e.b.STRONG, 0, true);
                                a3.a(e.c.TOP).i();
                                a3.a(e.c.BOTTOM).i();
                            }
                        }
                        float f6 = f2;
                        if (f6 >= 0.0f && f6 != 0.5f) {
                            a3.a(f6);
                        }
                        if (aVar.A >= 0.0f && aVar.A != 0.5f) {
                            a3.b(aVar.A);
                        }
                    }
                    if (isInEditMode && !(aVar.Q == -1 && aVar.R == -1)) {
                        a3.a(aVar.Q, aVar.R);
                    }
                    if (aVar.V) {
                        a3.a(f.a.FIXED);
                        a3.j(aVar.width);
                    } else if (aVar.width == -1) {
                        a3.a(f.a.MATCH_PARENT);
                        a3.a(e.c.LEFT).d = aVar.leftMargin;
                        a3.a(e.c.RIGHT).d = aVar.rightMargin;
                    } else {
                        a3.a(f.a.MATCH_CONSTRAINT);
                        a3.j(0);
                    }
                    if (aVar.W) {
                        z = false;
                        a3.b(f.a.FIXED);
                        a3.k(aVar.height);
                    } else if (aVar.height == -1) {
                        a3.b(f.a.MATCH_PARENT);
                        a3.a(e.c.TOP).d = aVar.topMargin;
                        a3.a(e.c.BOTTOM).d = aVar.bottomMargin;
                        z = false;
                    } else {
                        a3.b(f.a.MATCH_CONSTRAINT);
                        z = false;
                        a3.k(0);
                    }
                    if (aVar.B != null) {
                        a3.b(aVar.B);
                    }
                    a3.c(aVar.E);
                    a3.d(aVar.F);
                    a3.r(aVar.G);
                    a3.s(aVar.H);
                    a3.a(aVar.I, aVar.K, aVar.M, aVar.O);
                    a3.b(aVar.J, aVar.L, aVar.N, aVar.P);
                }
            }
        }
    }

    private final f b(int i2) {
        if (i2 == 0) {
            return this.f548b;
        }
        View view = this.f547a.get(i2);
        if (view == null && (view = findViewById(i2)) != null && view != this && view.getParent() == this) {
            onViewAdded(view);
        }
        if (view == this) {
            return this.f548b;
        }
        if (view == null) {
            return null;
        }
        return ((a) view.getLayoutParams()).al;
    }

    public final f a(View view) {
        if (view == this) {
            return this.f548b;
        }
        if (view == null) {
            return null;
        }
        return ((a) view.getLayoutParams()).al;
    }

    private void a(int i2, int i3) {
        boolean z;
        boolean z2;
        int baseline;
        int i4;
        int i5;
        int i6 = i2;
        int i7 = i3;
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int childCount = getChildCount();
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = getChildAt(i8);
            if (childAt.getVisibility() != 8) {
                a aVar = (a) childAt.getLayoutParams();
                f fVar = aVar.al;
                if (!aVar.Y && !aVar.Z) {
                    fVar.e(childAt.getVisibility());
                    int i9 = aVar.width;
                    int i10 = aVar.height;
                    if (aVar.V || aVar.W || (!aVar.V && aVar.I == 1) || aVar.width == -1 || (!aVar.W && (aVar.J == 1 || aVar.height == -1))) {
                        if (i9 == 0) {
                            i4 = getChildMeasureSpec(i6, paddingLeft, -2);
                            z2 = true;
                        } else if (i9 == -1) {
                            i4 = getChildMeasureSpec(i6, paddingLeft, -1);
                            z2 = false;
                        } else {
                            z2 = i9 == -2;
                            i4 = getChildMeasureSpec(i6, paddingLeft, i9);
                        }
                        if (i10 == 0) {
                            z = true;
                            i5 = getChildMeasureSpec(i7, paddingTop, -2);
                        } else if (i10 == -1) {
                            i5 = getChildMeasureSpec(i7, paddingTop, -1);
                            z = false;
                        } else {
                            z = i10 == -2;
                            i5 = getChildMeasureSpec(i7, paddingTop, i10);
                        }
                        childAt.measure(i4, i5);
                        androidx.constraintlayout.a.f fVar2 = this.t;
                        if (fVar2 != null) {
                            fVar2.f541a++;
                        }
                        fVar.b(i9 == -2);
                        fVar.c(i10 == -2);
                        i9 = childAt.getMeasuredWidth();
                        i10 = childAt.getMeasuredHeight();
                    } else {
                        z2 = false;
                        z = false;
                    }
                    fVar.j(i9);
                    fVar.k(i10);
                    if (z2) {
                        fVar.n(i9);
                    }
                    if (z) {
                        fVar.o(i10);
                    }
                    if (aVar.X && (baseline = childAt.getBaseline()) != -1) {
                        fVar.q(baseline);
                    }
                }
            }
        }
    }

    private void d() {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt instanceof f) {
                ((f) childAt).b(this);
            }
        }
        int size = this.g.size();
        if (size > 0) {
            for (int i3 = 0; i3 < size; i3++) {
                this.g.get(i3).c(this);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:109:0x0206  */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x0240  */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x0265  */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x026e  */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x0273  */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x0275  */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x027b  */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x027d  */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x0291  */
    /* JADX WARNING: Removed duplicated region for block: B:143:0x0296  */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x029b  */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x02a3  */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x02ac  */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x02b4  */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x02c1  */
    /* JADX WARNING: Removed duplicated region for block: B:155:0x02cc  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void b(int r24, int r25) {
        /*
            r23 = this;
            r0 = r23
            r1 = r24
            r2 = r25
            int r3 = r23.getPaddingTop()
            int r4 = r23.getPaddingBottom()
            int r3 = r3 + r4
            int r4 = r23.getPaddingLeft()
            int r5 = r23.getPaddingRight()
            int r4 = r4 + r5
            int r5 = r23.getChildCount()
            r7 = 0
        L_0x001d:
            r8 = 1
            r10 = 8
            r12 = -2
            if (r7 >= r5) goto L_0x00de
            android.view.View r14 = r0.getChildAt(r7)
            int r15 = r14.getVisibility()
            if (r15 != r10) goto L_0x0030
            goto L_0x00d6
        L_0x0030:
            android.view.ViewGroup$LayoutParams r10 = r14.getLayoutParams()
            androidx.constraintlayout.widget.ConstraintLayout$a r10 = (androidx.constraintlayout.widget.ConstraintLayout.a) r10
            androidx.constraintlayout.a.a.f r15 = r10.al
            boolean r6 = r10.Y
            if (r6 != 0) goto L_0x00d6
            boolean r6 = r10.Z
            if (r6 == 0) goto L_0x0042
            goto L_0x00d6
        L_0x0042:
            int r6 = r14.getVisibility()
            r15.e(r6)
            int r6 = r10.width
            int r13 = r10.height
            if (r6 == 0) goto L_0x00c6
            if (r13 != 0) goto L_0x0053
            goto L_0x00c6
        L_0x0053:
            if (r6 != r12) goto L_0x0058
            r16 = 1
            goto L_0x005a
        L_0x0058:
            r16 = 0
        L_0x005a:
            int r11 = getChildMeasureSpec(r1, r4, r6)
            if (r13 != r12) goto L_0x0063
            r17 = 1
            goto L_0x0065
        L_0x0063:
            r17 = 0
        L_0x0065:
            int r12 = getChildMeasureSpec(r2, r3, r13)
            r14.measure(r11, r12)
            androidx.constraintlayout.a.f r11 = r0.t
            if (r11 == 0) goto L_0x0077
            r12 = r3
            long r2 = r11.f541a
            long r2 = r2 + r8
            r11.f541a = r2
            goto L_0x0078
        L_0x0077:
            r12 = r3
        L_0x0078:
            r2 = -2
            if (r6 != r2) goto L_0x007d
            r3 = 1
            goto L_0x007e
        L_0x007d:
            r3 = 0
        L_0x007e:
            r15.b((boolean) r3)
            if (r13 != r2) goto L_0x0085
            r2 = 1
            goto L_0x0086
        L_0x0085:
            r2 = 0
        L_0x0086:
            r15.c((boolean) r2)
            int r2 = r14.getMeasuredWidth()
            int r3 = r14.getMeasuredHeight()
            r15.j(r2)
            r15.k(r3)
            if (r16 == 0) goto L_0x009c
            r15.n(r2)
        L_0x009c:
            if (r17 == 0) goto L_0x00a1
            r15.o(r3)
        L_0x00a1:
            boolean r6 = r10.X
            if (r6 == 0) goto L_0x00af
            int r6 = r14.getBaseline()
            r8 = -1
            if (r6 == r8) goto L_0x00af
            r15.q(r6)
        L_0x00af:
            boolean r6 = r10.V
            if (r6 == 0) goto L_0x00d7
            boolean r6 = r10.W
            if (r6 == 0) goto L_0x00d7
            androidx.constraintlayout.a.a.n r6 = r15.i()
            r6.a(r2)
            androidx.constraintlayout.a.a.n r2 = r15.j()
            r2.a(r3)
            goto L_0x00d7
        L_0x00c6:
            r12 = r3
            androidx.constraintlayout.a.a.n r2 = r15.i()
            r2.e()
            androidx.constraintlayout.a.a.n r2 = r15.j()
            r2.e()
            goto L_0x00d7
        L_0x00d6:
            r12 = r3
        L_0x00d7:
            int r7 = r7 + 1
            r2 = r25
            r3 = r12
            goto L_0x001d
        L_0x00de:
            r12 = r3
            androidx.constraintlayout.a.a.g r2 = r0.f548b
            r2.P()
            r2 = 0
        L_0x00e5:
            if (r2 >= r5) goto L_0x02e2
            android.view.View r3 = r0.getChildAt(r2)
            int r6 = r3.getVisibility()
            if (r6 != r10) goto L_0x00f3
            goto L_0x02ce
        L_0x00f3:
            android.view.ViewGroup$LayoutParams r6 = r3.getLayoutParams()
            androidx.constraintlayout.widget.ConstraintLayout$a r6 = (androidx.constraintlayout.widget.ConstraintLayout.a) r6
            androidx.constraintlayout.a.a.f r7 = r6.al
            boolean r11 = r6.Y
            if (r11 != 0) goto L_0x02ce
            boolean r11 = r6.Z
            if (r11 == 0) goto L_0x0105
            goto L_0x02ce
        L_0x0105:
            int r11 = r3.getVisibility()
            r7.e(r11)
            int r11 = r6.width
            int r13 = r6.height
            if (r11 == 0) goto L_0x0116
            if (r13 == 0) goto L_0x0116
            goto L_0x02ce
        L_0x0116:
            androidx.constraintlayout.a.a.e$c r14 = androidx.constraintlayout.a.a.e.c.LEFT
            androidx.constraintlayout.a.a.e r14 = r7.a((androidx.constraintlayout.a.a.e.c) r14)
            androidx.constraintlayout.a.a.m r14 = r14.a()
            androidx.constraintlayout.a.a.e$c r15 = androidx.constraintlayout.a.a.e.c.RIGHT
            androidx.constraintlayout.a.a.e r15 = r7.a((androidx.constraintlayout.a.a.e.c) r15)
            androidx.constraintlayout.a.a.m r15 = r15.a()
            androidx.constraintlayout.a.a.e$c r10 = androidx.constraintlayout.a.a.e.c.LEFT
            androidx.constraintlayout.a.a.e r10 = r7.a((androidx.constraintlayout.a.a.e.c) r10)
            androidx.constraintlayout.a.a.e r10 = r10.g()
            if (r10 == 0) goto L_0x0144
            androidx.constraintlayout.a.a.e$c r10 = androidx.constraintlayout.a.a.e.c.RIGHT
            androidx.constraintlayout.a.a.e r10 = r7.a((androidx.constraintlayout.a.a.e.c) r10)
            androidx.constraintlayout.a.a.e r10 = r10.g()
            if (r10 == 0) goto L_0x0144
            r10 = 1
            goto L_0x0145
        L_0x0144:
            r10 = 0
        L_0x0145:
            androidx.constraintlayout.a.a.e$c r8 = androidx.constraintlayout.a.a.e.c.TOP
            androidx.constraintlayout.a.a.e r8 = r7.a((androidx.constraintlayout.a.a.e.c) r8)
            androidx.constraintlayout.a.a.m r8 = r8.a()
            androidx.constraintlayout.a.a.e$c r9 = androidx.constraintlayout.a.a.e.c.BOTTOM
            androidx.constraintlayout.a.a.e r9 = r7.a((androidx.constraintlayout.a.a.e.c) r9)
            androidx.constraintlayout.a.a.m r9 = r9.a()
            r17 = r5
            androidx.constraintlayout.a.a.e$c r5 = androidx.constraintlayout.a.a.e.c.TOP
            androidx.constraintlayout.a.a.e r5 = r7.a((androidx.constraintlayout.a.a.e.c) r5)
            androidx.constraintlayout.a.a.e r5 = r5.g()
            if (r5 == 0) goto L_0x0175
            androidx.constraintlayout.a.a.e$c r5 = androidx.constraintlayout.a.a.e.c.BOTTOM
            androidx.constraintlayout.a.a.e r5 = r7.a((androidx.constraintlayout.a.a.e.c) r5)
            androidx.constraintlayout.a.a.e r5 = r5.g()
            if (r5 == 0) goto L_0x0175
            r5 = 1
            goto L_0x0176
        L_0x0175:
            r5 = 0
        L_0x0176:
            if (r11 != 0) goto L_0x0188
            if (r13 != 0) goto L_0x0188
            if (r10 == 0) goto L_0x0188
            if (r5 == 0) goto L_0x0188
            r5 = r25
            r20 = r2
            r3 = -1
            r10 = -2
            r18 = 1
            goto L_0x02d8
        L_0x0188:
            r20 = r2
            androidx.constraintlayout.a.a.g r2 = r0.f548b
            androidx.constraintlayout.a.a.f$a r2 = r2.F()
            r21 = r6
            androidx.constraintlayout.a.a.f$a r6 = androidx.constraintlayout.a.a.f.a.WRAP_CONTENT
            if (r2 == r6) goto L_0x0198
            r6 = 1
            goto L_0x0199
        L_0x0198:
            r6 = 0
        L_0x0199:
            androidx.constraintlayout.a.a.g r2 = r0.f548b
            androidx.constraintlayout.a.a.f$a r2 = r2.G()
            androidx.constraintlayout.a.a.f$a r0 = androidx.constraintlayout.a.a.f.a.WRAP_CONTENT
            if (r2 == r0) goto L_0x01a5
            r0 = 1
            goto L_0x01a6
        L_0x01a5:
            r0 = 0
        L_0x01a6:
            if (r6 != 0) goto L_0x01af
            androidx.constraintlayout.a.a.n r2 = r7.i()
            r2.e()
        L_0x01af:
            if (r0 != 0) goto L_0x01b8
            androidx.constraintlayout.a.a.n r2 = r7.j()
            r2.e()
        L_0x01b8:
            if (r11 != 0) goto L_0x01f0
            if (r6 == 0) goto L_0x01e7
            boolean r2 = r7.d()
            if (r2 == 0) goto L_0x01e7
            if (r10 == 0) goto L_0x01e7
            boolean r2 = r14.g()
            if (r2 == 0) goto L_0x01e7
            boolean r2 = r15.g()
            if (r2 == 0) goto L_0x01e7
            float r2 = r15.d()
            float r10 = r14.d()
            float r2 = r2 - r10
            int r11 = (int) r2
            androidx.constraintlayout.a.a.n r2 = r7.i()
            r2.a(r11)
            int r2 = getChildMeasureSpec(r1, r4, r11)
            r14 = r2
            goto L_0x01f8
        L_0x01e7:
            r2 = -2
            int r6 = getChildMeasureSpec(r1, r4, r2)
            r14 = r6
            r2 = 1
            r6 = 0
            goto L_0x0204
        L_0x01f0:
            r2 = -2
            r10 = -1
            if (r11 != r10) goto L_0x01fa
            int r14 = getChildMeasureSpec(r1, r4, r10)
        L_0x01f8:
            r2 = 0
            goto L_0x0204
        L_0x01fa:
            if (r11 != r2) goto L_0x01fe
            r2 = 1
            goto L_0x01ff
        L_0x01fe:
            r2 = 0
        L_0x01ff:
            int r10 = getChildMeasureSpec(r1, r4, r11)
            r14 = r10
        L_0x0204:
            if (r13 != 0) goto L_0x0240
            if (r0 == 0) goto L_0x0236
            boolean r10 = r7.e()
            if (r10 == 0) goto L_0x0236
            if (r5 == 0) goto L_0x0236
            boolean r5 = r8.g()
            if (r5 == 0) goto L_0x0236
            boolean r5 = r9.g()
            if (r5 == 0) goto L_0x0236
            float r5 = r9.d()
            float r8 = r8.d()
            float r5 = r5 - r8
            int r13 = (int) r5
            androidx.constraintlayout.a.a.n r5 = r7.j()
            r5.a(r13)
            r5 = r25
            int r8 = getChildMeasureSpec(r5, r12, r13)
            r9 = r0
            r0 = r8
            goto L_0x024c
        L_0x0236:
            r5 = r25
            r8 = -2
            int r0 = getChildMeasureSpec(r5, r12, r8)
            r8 = 1
            r9 = 0
            goto L_0x025c
        L_0x0240:
            r5 = r25
            r8 = -2
            r9 = -1
            if (r13 != r9) goto L_0x024e
            int r10 = getChildMeasureSpec(r5, r12, r9)
            r9 = r0
            r0 = r10
        L_0x024c:
            r8 = 0
            goto L_0x025c
        L_0x024e:
            if (r13 != r8) goto L_0x0252
            r8 = 1
            goto L_0x0253
        L_0x0252:
            r8 = 0
        L_0x0253:
            int r9 = getChildMeasureSpec(r5, r12, r13)
            r22 = r9
            r9 = r0
            r0 = r22
        L_0x025c:
            r3.measure(r14, r0)
            r0 = r23
            androidx.constraintlayout.a.f r10 = r0.t
            if (r10 == 0) goto L_0x026e
            long r14 = r10.f541a
            r18 = 1
            long r14 = r14 + r18
            r10.f541a = r14
            goto L_0x0270
        L_0x026e:
            r18 = 1
        L_0x0270:
            r10 = -2
            if (r11 != r10) goto L_0x0275
            r11 = 1
            goto L_0x0276
        L_0x0275:
            r11 = 0
        L_0x0276:
            r7.b((boolean) r11)
            if (r13 != r10) goto L_0x027d
            r11 = 1
            goto L_0x027e
        L_0x027d:
            r11 = 0
        L_0x027e:
            r7.c((boolean) r11)
            int r11 = r3.getMeasuredWidth()
            int r13 = r3.getMeasuredHeight()
            r7.j(r11)
            r7.k(r13)
            if (r2 == 0) goto L_0x0294
            r7.n(r11)
        L_0x0294:
            if (r8 == 0) goto L_0x0299
            r7.o(r13)
        L_0x0299:
            if (r6 == 0) goto L_0x02a3
            androidx.constraintlayout.a.a.n r2 = r7.i()
            r2.a(r11)
            goto L_0x02aa
        L_0x02a3:
            androidx.constraintlayout.a.a.n r2 = r7.i()
            r2.c()
        L_0x02aa:
            if (r9 == 0) goto L_0x02b4
            androidx.constraintlayout.a.a.n r2 = r7.j()
            r2.a(r13)
            goto L_0x02bb
        L_0x02b4:
            androidx.constraintlayout.a.a.n r2 = r7.j()
            r2.c()
        L_0x02bb:
            r6 = r21
            boolean r2 = r6.X
            if (r2 == 0) goto L_0x02cc
            int r2 = r3.getBaseline()
            r3 = -1
            if (r2 == r3) goto L_0x02d8
            r7.q(r2)
            goto L_0x02d8
        L_0x02cc:
            r3 = -1
            goto L_0x02d8
        L_0x02ce:
            r20 = r2
            r17 = r5
            r18 = r8
            r3 = -1
            r10 = -2
            r5 = r25
        L_0x02d8:
            int r2 = r20 + 1
            r5 = r17
            r8 = r18
            r10 = 8
            goto L_0x00e5
        L_0x02e2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.b(int, int):void");
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:170:0x0371  */
    /* JADX WARNING: Removed duplicated region for block: B:173:0x0386  */
    /* JADX WARNING: Removed duplicated region for block: B:180:0x03bf  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x013a  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0151  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMeasure(int r25, int r26) {
        /*
            r24 = this;
            r0 = r24
            r1 = r25
            r2 = r26
            java.lang.System.currentTimeMillis()
            int r3 = android.view.View.MeasureSpec.getMode(r25)
            int r4 = android.view.View.MeasureSpec.getSize(r25)
            int r5 = android.view.View.MeasureSpec.getMode(r26)
            int r6 = android.view.View.MeasureSpec.getSize(r26)
            int r7 = r24.getPaddingLeft()
            int r8 = r24.getPaddingTop()
            androidx.constraintlayout.a.a.g r9 = r0.f548b
            r9.h(r7)
            androidx.constraintlayout.a.a.g r9 = r0.f548b
            r9.i(r8)
            androidx.constraintlayout.a.a.g r9 = r0.f548b
            int r10 = r0.k
            r9.c((int) r10)
            androidx.constraintlayout.a.a.g r9 = r0.f548b
            int r10 = r0.l
            r9.d((int) r10)
            int r9 = android.os.Build.VERSION.SDK_INT
            r10 = 0
            r11 = 1
            r12 = 17
            if (r9 < r12) goto L_0x004f
            androidx.constraintlayout.a.a.g r9 = r0.f548b
            int r12 = r24.getLayoutDirection()
            if (r12 != r11) goto L_0x004b
            r12 = r11
            goto L_0x004c
        L_0x004b:
            r12 = r10
        L_0x004c:
            r9.a((boolean) r12)
        L_0x004f:
            r24.c(r25, r26)
            androidx.constraintlayout.a.a.g r9 = r0.f548b
            int r9 = r9.p()
            androidx.constraintlayout.a.a.g r12 = r0.f548b
            int r12 = r12.r()
            boolean r13 = r0.m
            if (r13 == 0) goto L_0x0069
            r0.m = r10
            r24.b()
            r13 = r11
            goto L_0x006a
        L_0x0069:
            r13 = r10
        L_0x006a:
            int r14 = r0.n
            r15 = 8
            r14 = r14 & r15
            if (r14 != r15) goto L_0x0073
            r14 = r11
            goto L_0x0074
        L_0x0073:
            r14 = r10
        L_0x0074:
            if (r14 == 0) goto L_0x0084
            androidx.constraintlayout.a.a.g r15 = r0.f548b
            r15.O()
            androidx.constraintlayout.a.a.g r15 = r0.f548b
            r15.f(r9, r12)
            r24.b(r25, r26)
            goto L_0x0087
        L_0x0084:
            r24.a((int) r25, (int) r26)
        L_0x0087:
            r24.d()
            int r15 = r24.getChildCount()
            if (r15 <= 0) goto L_0x0097
            if (r13 == 0) goto L_0x0097
            androidx.constraintlayout.a.a.g r13 = r0.f548b
            androidx.constraintlayout.a.a.a.a((androidx.constraintlayout.a.a.g) r13)
        L_0x0097:
            androidx.constraintlayout.a.a.g r13 = r0.f548b
            boolean r13 = r13.as
            if (r13 == 0) goto L_0x00d7
            androidx.constraintlayout.a.a.g r13 = r0.f548b
            boolean r13 = r13.at
            r15 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r13 == 0) goto L_0x00bb
            if (r3 != r15) goto L_0x00bb
            androidx.constraintlayout.a.a.g r13 = r0.f548b
            int r13 = r13.av
            if (r13 >= r4) goto L_0x00b4
            androidx.constraintlayout.a.a.g r13 = r0.f548b
            int r11 = r13.av
            r13.j(r11)
        L_0x00b4:
            androidx.constraintlayout.a.a.g r11 = r0.f548b
            androidx.constraintlayout.a.a.f$a r13 = androidx.constraintlayout.a.a.f.a.FIXED
            r11.a((androidx.constraintlayout.a.a.f.a) r13)
        L_0x00bb:
            androidx.constraintlayout.a.a.g r11 = r0.f548b
            boolean r11 = r11.au
            if (r11 == 0) goto L_0x00d7
            if (r5 != r15) goto L_0x00d7
            androidx.constraintlayout.a.a.g r11 = r0.f548b
            int r11 = r11.aw
            if (r11 >= r6) goto L_0x00d0
            androidx.constraintlayout.a.a.g r11 = r0.f548b
            int r13 = r11.aw
            r11.k(r13)
        L_0x00d0:
            androidx.constraintlayout.a.a.g r11 = r0.f548b
            androidx.constraintlayout.a.a.f$a r13 = androidx.constraintlayout.a.a.f.a.FIXED
            r11.b((androidx.constraintlayout.a.a.f.a) r13)
        L_0x00d7:
            int r11 = r0.n
            r13 = 32
            r11 = r11 & r13
            r15 = 1073741824(0x40000000, float:2.0)
            if (r11 != r13) goto L_0x0133
            androidx.constraintlayout.a.a.g r11 = r0.f548b
            int r11 = r11.p()
            androidx.constraintlayout.a.a.g r13 = r0.f548b
            int r13 = r13.r()
            int r10 = r0.r
            if (r10 == r11) goto L_0x00fa
            if (r3 != r15) goto L_0x00fa
            androidx.constraintlayout.a.a.g r3 = r0.f548b
            java.util.List<androidx.constraintlayout.a.a.h> r3 = r3.ar
            r10 = 0
            androidx.constraintlayout.a.a.a.a((java.util.List<androidx.constraintlayout.a.a.h>) r3, (int) r10, (int) r11)
        L_0x00fa:
            int r3 = r0.s
            if (r3 == r13) goto L_0x0108
            if (r5 != r15) goto L_0x0108
            androidx.constraintlayout.a.a.g r3 = r0.f548b
            java.util.List<androidx.constraintlayout.a.a.h> r3 = r3.ar
            r5 = 1
            androidx.constraintlayout.a.a.a.a((java.util.List<androidx.constraintlayout.a.a.h>) r3, (int) r5, (int) r13)
        L_0x0108:
            androidx.constraintlayout.a.a.g r3 = r0.f548b
            boolean r3 = r3.at
            if (r3 == 0) goto L_0x011d
            androidx.constraintlayout.a.a.g r3 = r0.f548b
            int r3 = r3.av
            if (r3 <= r4) goto L_0x011d
            androidx.constraintlayout.a.a.g r3 = r0.f548b
            java.util.List<androidx.constraintlayout.a.a.h> r3 = r3.ar
            r10 = 0
            androidx.constraintlayout.a.a.a.a((java.util.List<androidx.constraintlayout.a.a.h>) r3, (int) r10, (int) r4)
            goto L_0x011e
        L_0x011d:
            r10 = 0
        L_0x011e:
            androidx.constraintlayout.a.a.g r3 = r0.f548b
            boolean r3 = r3.au
            if (r3 == 0) goto L_0x0133
            androidx.constraintlayout.a.a.g r3 = r0.f548b
            int r3 = r3.aw
            if (r3 <= r6) goto L_0x0133
            androidx.constraintlayout.a.a.g r3 = r0.f548b
            java.util.List<androidx.constraintlayout.a.a.h> r3 = r3.ar
            r4 = 1
            androidx.constraintlayout.a.a.a.a((java.util.List<androidx.constraintlayout.a.a.h>) r3, (int) r4, (int) r6)
            goto L_0x0134
        L_0x0133:
            r4 = 1
        L_0x0134:
            int r3 = r24.getChildCount()
            if (r3 <= 0) goto L_0x013f
            java.lang.String r3 = "First pass"
            r0.a((java.lang.String) r3)
        L_0x013f:
            java.util.ArrayList<androidx.constraintlayout.a.a.f> r3 = r0.h
            int r3 = r3.size()
            int r5 = r24.getPaddingBottom()
            int r8 = r8 + r5
            int r5 = r24.getPaddingRight()
            int r7 = r7 + r5
            if (r3 <= 0) goto L_0x0371
            androidx.constraintlayout.a.a.g r6 = r0.f548b
            androidx.constraintlayout.a.a.f$a r6 = r6.F()
            androidx.constraintlayout.a.a.f$a r11 = androidx.constraintlayout.a.a.f.a.WRAP_CONTENT
            if (r6 != r11) goto L_0x015d
            r6 = r4
            goto L_0x015e
        L_0x015d:
            r6 = r10
        L_0x015e:
            androidx.constraintlayout.a.a.g r11 = r0.f548b
            androidx.constraintlayout.a.a.f$a r11 = r11.G()
            androidx.constraintlayout.a.a.f$a r13 = androidx.constraintlayout.a.a.f.a.WRAP_CONTENT
            if (r11 != r13) goto L_0x016a
            r11 = r4
            goto L_0x016b
        L_0x016a:
            r11 = r10
        L_0x016b:
            androidx.constraintlayout.a.a.g r13 = r0.f548b
            int r13 = r13.p()
            int r4 = r0.i
            int r4 = java.lang.Math.max(r13, r4)
            androidx.constraintlayout.a.a.g r13 = r0.f548b
            int r13 = r13.r()
            int r10 = r0.j
            int r10 = java.lang.Math.max(r13, r10)
            r13 = r4
            r5 = r10
            r4 = 0
            r10 = 0
            r17 = 0
        L_0x0189:
            r18 = 1
            if (r4 >= r3) goto L_0x02ca
            java.util.ArrayList<androidx.constraintlayout.a.a.f> r15 = r0.h
            java.lang.Object r15 = r15.get(r4)
            androidx.constraintlayout.a.a.f r15 = (androidx.constraintlayout.a.a.f) r15
            java.lang.Object r20 = r15.B()
            r21 = r3
            r3 = r20
            android.view.View r3 = (android.view.View) r3
            if (r3 != 0) goto L_0x01a9
            r20 = r9
            r23 = r10
            r22 = r12
            goto L_0x02b6
        L_0x01a9:
            android.view.ViewGroup$LayoutParams r20 = r3.getLayoutParams()
            r22 = r12
            r12 = r20
            androidx.constraintlayout.widget.ConstraintLayout$a r12 = (androidx.constraintlayout.widget.ConstraintLayout.a) r12
            r20 = r9
            boolean r9 = r12.Z
            if (r9 != 0) goto L_0x02b4
            boolean r9 = r12.Y
            if (r9 == 0) goto L_0x01bf
            goto L_0x02b4
        L_0x01bf:
            int r9 = r3.getVisibility()
            r23 = r10
            r10 = 8
            if (r9 != r10) goto L_0x01cb
        L_0x01c9:
            goto L_0x02b6
        L_0x01cb:
            if (r14 == 0) goto L_0x01e2
            androidx.constraintlayout.a.a.n r9 = r15.i()
            boolean r9 = r9.g()
            if (r9 == 0) goto L_0x01e2
            androidx.constraintlayout.a.a.n r9 = r15.j()
            boolean r9 = r9.g()
            if (r9 == 0) goto L_0x01e2
            goto L_0x01c9
        L_0x01e2:
            int r9 = r12.width
            r10 = -2
            if (r9 != r10) goto L_0x01f2
            boolean r9 = r12.V
            if (r9 == 0) goto L_0x01f2
            int r9 = r12.width
            int r9 = getChildMeasureSpec(r1, r7, r9)
            goto L_0x01fc
        L_0x01f2:
            int r9 = r15.p()
            r10 = 1073741824(0x40000000, float:2.0)
            int r9 = android.view.View.MeasureSpec.makeMeasureSpec(r9, r10)
        L_0x01fc:
            int r10 = r12.height
            r1 = -2
            if (r10 != r1) goto L_0x020c
            boolean r1 = r12.W
            if (r1 == 0) goto L_0x020c
            int r1 = r12.height
            int r1 = getChildMeasureSpec(r2, r8, r1)
            goto L_0x0216
        L_0x020c:
            int r1 = r15.r()
            r10 = 1073741824(0x40000000, float:2.0)
            int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r1, r10)
        L_0x0216:
            r3.measure(r9, r1)
            androidx.constraintlayout.a.f r1 = r0.t
            if (r1 == 0) goto L_0x0223
            long r9 = r1.f542b
            long r9 = r9 + r18
            r1.f542b = r9
        L_0x0223:
            int r1 = r3.getMeasuredWidth()
            int r9 = r3.getMeasuredHeight()
            int r10 = r15.p()
            if (r1 == r10) goto L_0x025a
            r15.j(r1)
            if (r14 == 0) goto L_0x023d
            androidx.constraintlayout.a.a.n r10 = r15.i()
            r10.a(r1)
        L_0x023d:
            if (r6 == 0) goto L_0x0258
            int r1 = r15.x()
            if (r1 <= r13) goto L_0x0258
            int r1 = r15.x()
            androidx.constraintlayout.a.a.e$c r10 = androidx.constraintlayout.a.a.e.c.RIGHT
            androidx.constraintlayout.a.a.e r10 = r15.a((androidx.constraintlayout.a.a.e.c) r10)
            int r10 = r10.e()
            int r1 = r1 + r10
            int r13 = java.lang.Math.max(r13, r1)
        L_0x0258:
            r23 = 1
        L_0x025a:
            int r1 = r15.r()
            if (r9 == r1) goto L_0x028a
            r15.k(r9)
            if (r14 == 0) goto L_0x026c
            androidx.constraintlayout.a.a.n r1 = r15.j()
            r1.a(r9)
        L_0x026c:
            if (r11 == 0) goto L_0x0288
            int r1 = r15.y()
            if (r1 <= r5) goto L_0x0288
            int r1 = r15.y()
            androidx.constraintlayout.a.a.e$c r9 = androidx.constraintlayout.a.a.e.c.BOTTOM
            androidx.constraintlayout.a.a.e r9 = r15.a((androidx.constraintlayout.a.a.e.c) r9)
            int r9 = r9.e()
            int r1 = r1 + r9
            int r1 = java.lang.Math.max(r5, r1)
            r5 = r1
        L_0x0288:
            r23 = 1
        L_0x028a:
            boolean r1 = r12.X
            if (r1 == 0) goto L_0x02a0
            int r1 = r3.getBaseline()
            r9 = -1
            if (r1 == r9) goto L_0x02a0
            int r9 = r15.A()
            if (r1 == r9) goto L_0x02a0
            r15.q(r1)
            r23 = 1
        L_0x02a0:
            int r1 = android.os.Build.VERSION.SDK_INT
            r9 = 11
            if (r1 < r9) goto L_0x02b1
            int r1 = r3.getMeasuredState()
            r3 = r17
            int r17 = combineMeasuredStates(r3, r1)
            goto L_0x02ba
        L_0x02b1:
            r3 = r17
            goto L_0x02ba
        L_0x02b4:
            r23 = r10
        L_0x02b6:
            r3 = r17
            r17 = r3
        L_0x02ba:
            r10 = r23
            int r4 = r4 + 1
            r1 = r25
            r9 = r20
            r3 = r21
            r12 = r22
            r15 = 1073741824(0x40000000, float:2.0)
            goto L_0x0189
        L_0x02ca:
            r21 = r3
            r20 = r9
            r23 = r10
            r22 = r12
            r3 = r17
            if (r23 == 0) goto L_0x0319
            androidx.constraintlayout.a.a.g r1 = r0.f548b
            r4 = r20
            r1.j(r4)
            androidx.constraintlayout.a.a.g r1 = r0.f548b
            r4 = r22
            r1.k(r4)
            if (r14 == 0) goto L_0x02eb
            androidx.constraintlayout.a.a.g r1 = r0.f548b
            r1.P()
        L_0x02eb:
            java.lang.String r1 = "2nd pass"
            r0.a((java.lang.String) r1)
            androidx.constraintlayout.a.a.g r1 = r0.f548b
            int r1 = r1.p()
            if (r1 >= r13) goto L_0x02ff
            androidx.constraintlayout.a.a.g r1 = r0.f548b
            r1.j(r13)
            r11 = 1
            goto L_0x0300
        L_0x02ff:
            r11 = 0
        L_0x0300:
            androidx.constraintlayout.a.a.g r1 = r0.f548b
            int r1 = r1.r()
            if (r1 >= r5) goto L_0x0310
            androidx.constraintlayout.a.a.g r1 = r0.f548b
            r1.k(r5)
            r16 = 1
            goto L_0x0312
        L_0x0310:
            r16 = r11
        L_0x0312:
            if (r16 == 0) goto L_0x0319
            java.lang.String r1 = "3rd pass"
            r0.a((java.lang.String) r1)
        L_0x0319:
            r1 = r21
            r4 = 0
        L_0x031c:
            if (r4 >= r1) goto L_0x0372
            java.util.ArrayList<androidx.constraintlayout.a.a.f> r5 = r0.h
            java.lang.Object r5 = r5.get(r4)
            androidx.constraintlayout.a.a.f r5 = (androidx.constraintlayout.a.a.f) r5
            java.lang.Object r6 = r5.B()
            android.view.View r6 = (android.view.View) r6
            if (r6 != 0) goto L_0x0333
        L_0x032e:
            r10 = 8
        L_0x0330:
            r11 = 1073741824(0x40000000, float:2.0)
            goto L_0x036e
        L_0x0333:
            int r9 = r6.getMeasuredWidth()
            int r10 = r5.p()
            if (r9 != r10) goto L_0x0347
            int r9 = r6.getMeasuredHeight()
            int r10 = r5.r()
            if (r9 == r10) goto L_0x032e
        L_0x0347:
            int r9 = r5.l()
            r10 = 8
            if (r9 == r10) goto L_0x0330
            int r9 = r5.p()
            r11 = 1073741824(0x40000000, float:2.0)
            int r9 = android.view.View.MeasureSpec.makeMeasureSpec(r9, r11)
            int r5 = r5.r()
            int r5 = android.view.View.MeasureSpec.makeMeasureSpec(r5, r11)
            r6.measure(r9, r5)
            androidx.constraintlayout.a.f r5 = r0.t
            if (r5 == 0) goto L_0x036e
            long r12 = r5.f542b
            long r12 = r12 + r18
            r5.f542b = r12
        L_0x036e:
            int r4 = r4 + 1
            goto L_0x031c
        L_0x0371:
            r3 = 0
        L_0x0372:
            androidx.constraintlayout.a.a.g r1 = r0.f548b
            int r1 = r1.p()
            int r1 = r1 + r7
            androidx.constraintlayout.a.a.g r4 = r0.f548b
            int r4 = r4.r()
            int r4 = r4 + r8
            int r5 = android.os.Build.VERSION.SDK_INT
            r6 = 11
            if (r5 < r6) goto L_0x03bf
            r5 = r25
            int r1 = resolveSizeAndState(r1, r5, r3)
            int r3 = r3 << 16
            int r2 = resolveSizeAndState(r4, r2, r3)
            r3 = 16777215(0xffffff, float:2.3509886E-38)
            r1 = r1 & r3
            r2 = r2 & r3
            int r3 = r0.k
            int r1 = java.lang.Math.min(r3, r1)
            int r3 = r0.l
            int r2 = java.lang.Math.min(r3, r2)
            androidx.constraintlayout.a.a.g r3 = r0.f548b
            boolean r3 = r3.K()
            r4 = 16777216(0x1000000, float:2.3509887E-38)
            if (r3 == 0) goto L_0x03ae
            r1 = r1 | r4
        L_0x03ae:
            androidx.constraintlayout.a.a.g r3 = r0.f548b
            boolean r3 = r3.L()
            if (r3 == 0) goto L_0x03b7
            r2 = r2 | r4
        L_0x03b7:
            r0.setMeasuredDimension(r1, r2)
            r0.r = r1
            r0.s = r2
            goto L_0x03c6
        L_0x03bf:
            r0.setMeasuredDimension(r1, r4)
            r0.r = r1
            r0.s = r4
        L_0x03c6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.onMeasure(int, int):void");
    }

    private void c(int i2, int i3) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        int size2 = View.MeasureSpec.getSize(i3);
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        f.a aVar = f.a.FIXED;
        f.a aVar2 = f.a.FIXED;
        getLayoutParams();
        if (mode != Integer.MIN_VALUE) {
            if (mode == 0) {
                aVar = f.a.WRAP_CONTENT;
            } else if (mode == 1073741824) {
                size = Math.min(this.k, size) - paddingLeft;
            }
            size = 0;
        } else {
            aVar = f.a.WRAP_CONTENT;
        }
        if (mode2 != Integer.MIN_VALUE) {
            if (mode2 == 0) {
                aVar2 = f.a.WRAP_CONTENT;
            } else if (mode2 == 1073741824) {
                size2 = Math.min(this.l, size2) - paddingTop;
            }
            size2 = 0;
        } else {
            aVar2 = f.a.WRAP_CONTENT;
        }
        this.f548b.l(0);
        this.f548b.m(0);
        this.f548b.a(aVar);
        this.f548b.j(size);
        this.f548b.b(aVar2);
        this.f548b.k(size2);
        this.f548b.l((this.i - getPaddingLeft()) - getPaddingRight());
        this.f548b.m((this.j - getPaddingTop()) - getPaddingBottom());
    }

    /* access modifiers changed from: protected */
    public void a(String str) {
        this.f548b.N();
        androidx.constraintlayout.a.f fVar = this.t;
        if (fVar != null) {
            fVar.c++;
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        View content;
        int childCount = getChildCount();
        boolean isInEditMode = isInEditMode();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            a aVar = (a) childAt.getLayoutParams();
            f fVar = aVar.al;
            if ((childAt.getVisibility() != 8 || aVar.Y || aVar.Z || isInEditMode) && !aVar.aa) {
                int t2 = fVar.t();
                int u = fVar.u();
                int p2 = fVar.p() + t2;
                int r2 = fVar.r() + u;
                childAt.layout(t2, u, p2, r2);
                if ((childAt instanceof f) && (content = ((f) childAt).getContent()) != null) {
                    content.setVisibility(0);
                    content.layout(t2, u, p2, r2);
                }
            }
        }
        int size = this.g.size();
        if (size > 0) {
            for (int i7 = 0; i7 < size; i7++) {
                this.g.get(i7).b(this);
            }
        }
    }

    public void setOptimizationLevel(int i2) {
        this.f548b.a(i2);
    }

    public int getOptimizationLevel() {
        return this.f548b.J();
    }

    /* renamed from: a */
    public a generateLayoutParams(AttributeSet attributeSet) {
        return new a(getContext(), attributeSet);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public a generateDefaultLayoutParams() {
        return new a(-2, -2);
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new a(layoutParams);
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof a;
    }

    public void setConstraintSet(c cVar) {
        this.o = cVar;
    }

    public View a(int i2) {
        return this.f547a.get(i2);
    }

    public void dispatchDraw(Canvas canvas) {
        Object tag;
        super.dispatchDraw(canvas);
        if (isInEditMode()) {
            int childCount = getChildCount();
            float width = (float) getWidth();
            float height = (float) getHeight();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if (!(childAt.getVisibility() == 8 || (tag = childAt.getTag()) == null || !(tag instanceof String))) {
                    String[] split = ((String) tag).split(",");
                    if (split.length == 4) {
                        int parseInt = Integer.parseInt(split[0]);
                        int parseInt2 = Integer.parseInt(split[1]);
                        int parseInt3 = Integer.parseInt(split[2]);
                        int i3 = (int) ((((float) parseInt) / 1080.0f) * width);
                        int i4 = (int) ((((float) parseInt2) / 1920.0f) * height);
                        Paint paint = new Paint();
                        paint.setColor(-65536);
                        float f2 = (float) i3;
                        float f3 = (float) (i3 + ((int) ((((float) parseInt3) / 1080.0f) * width)));
                        Canvas canvas2 = canvas;
                        float f4 = (float) i4;
                        float f5 = f2;
                        float f6 = f2;
                        float f7 = f4;
                        Paint paint2 = paint;
                        float f8 = f3;
                        Paint paint3 = paint2;
                        canvas2.drawLine(f5, f7, f8, f4, paint3);
                        float parseInt4 = (float) (i4 + ((int) ((((float) Integer.parseInt(split[3])) / 1920.0f) * height)));
                        float f9 = f3;
                        float f10 = parseInt4;
                        canvas2.drawLine(f9, f7, f8, f10, paint3);
                        float f11 = parseInt4;
                        float f12 = f6;
                        canvas2.drawLine(f9, f11, f12, f10, paint3);
                        float f13 = f6;
                        canvas2.drawLine(f13, f11, f12, f4, paint3);
                        Paint paint4 = paint2;
                        paint4.setColor(-16711936);
                        Paint paint5 = paint4;
                        float f14 = f3;
                        Paint paint6 = paint5;
                        canvas2.drawLine(f13, f4, f14, parseInt4, paint6);
                        canvas2.drawLine(f13, parseInt4, f14, f4, paint6);
                    }
                }
            }
        }
    }

    public static class a extends ViewGroup.MarginLayoutParams {
        public float A = 0.5f;
        public String B = null;
        float C = 0.0f;
        int D = 1;
        public float E = -1.0f;
        public float F = -1.0f;
        public int G = 0;
        public int H = 0;
        public int I = 0;
        public int J = 0;
        public int K = 0;
        public int L = 0;
        public int M = 0;
        public int N = 0;
        public float O = 1.0f;
        public float P = 1.0f;
        public int Q = -1;
        public int R = -1;
        public int S = -1;
        public boolean T = false;
        public boolean U = false;
        boolean V = true;
        boolean W = true;
        boolean X = false;
        boolean Y = false;
        boolean Z = false;

        /* renamed from: a  reason: collision with root package name */
        public int f549a = -1;
        boolean aa = false;
        int ab = -1;
        int ac = -1;
        int ad = -1;
        int ae = -1;
        int af = -1;
        int ag = -1;
        float ah = 0.5f;
        int ai;
        int aj;
        float ak;
        f al = new f();
        public boolean am = false;

        /* renamed from: b  reason: collision with root package name */
        public int f550b = -1;
        public float c = -1.0f;
        public int d = -1;
        public int e = -1;
        public int f = -1;
        public int g = -1;
        public int h = -1;
        public int i = -1;
        public int j = -1;
        public int k = -1;
        public int l = -1;
        public int m = -1;
        public int n = 0;
        public float o = 0.0f;
        public int p = -1;
        public int q = -1;
        public int r = -1;
        public int s = -1;
        public int t = -1;
        public int u = -1;
        public int v = -1;
        public int w = -1;
        public int x = -1;
        public int y = -1;
        public float z = 0.5f;

        /* renamed from: androidx.constraintlayout.widget.ConstraintLayout$a$a  reason: collision with other inner class name */
        private static class C0012a {

            /* renamed from: a  reason: collision with root package name */
            public static final SparseIntArray f551a = new SparseIntArray();

            static {
                f551a.append(R.styleable.ConstraintLayout_Layout_layout_constraintLeft_toLeftOf, 8);
                f551a.append(R.styleable.ConstraintLayout_Layout_layout_constraintLeft_toRightOf, 9);
                f551a.append(R.styleable.ConstraintLayout_Layout_layout_constraintRight_toLeftOf, 10);
                f551a.append(R.styleable.ConstraintLayout_Layout_layout_constraintRight_toRightOf, 11);
                f551a.append(R.styleable.ConstraintLayout_Layout_layout_constraintTop_toTopOf, 12);
                f551a.append(R.styleable.ConstraintLayout_Layout_layout_constraintTop_toBottomOf, 13);
                f551a.append(R.styleable.ConstraintLayout_Layout_layout_constraintBottom_toTopOf, 14);
                f551a.append(R.styleable.ConstraintLayout_Layout_layout_constraintBottom_toBottomOf, 15);
                f551a.append(R.styleable.ConstraintLayout_Layout_layout_constraintBaseline_toBaselineOf, 16);
                f551a.append(R.styleable.ConstraintLayout_Layout_layout_constraintCircle, 2);
                f551a.append(R.styleable.ConstraintLayout_Layout_layout_constraintCircleRadius, 3);
                f551a.append(R.styleable.ConstraintLayout_Layout_layout_constraintCircleAngle, 4);
                f551a.append(R.styleable.ConstraintLayout_Layout_layout_editor_absoluteX, 49);
                f551a.append(R.styleable.ConstraintLayout_Layout_layout_editor_absoluteY, 50);
                f551a.append(R.styleable.ConstraintLayout_Layout_layout_constraintGuide_begin, 5);
                f551a.append(R.styleable.ConstraintLayout_Layout_layout_constraintGuide_end, 6);
                f551a.append(R.styleable.ConstraintLayout_Layout_layout_constraintGuide_percent, 7);
                f551a.append(R.styleable.ConstraintLayout_Layout_android_orientation, 1);
                f551a.append(R.styleable.ConstraintLayout_Layout_layout_constraintStart_toEndOf, 17);
                f551a.append(R.styleable.ConstraintLayout_Layout_layout_constraintStart_toStartOf, 18);
                f551a.append(R.styleable.ConstraintLayout_Layout_layout_constraintEnd_toStartOf, 19);
                f551a.append(R.styleable.ConstraintLayout_Layout_layout_constraintEnd_toEndOf, 20);
                f551a.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginLeft, 21);
                f551a.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginTop, 22);
                f551a.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginRight, 23);
                f551a.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginBottom, 24);
                f551a.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginStart, 25);
                f551a.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginEnd, 26);
                f551a.append(R.styleable.ConstraintLayout_Layout_layout_constraintHorizontal_bias, 29);
                f551a.append(R.styleable.ConstraintLayout_Layout_layout_constraintVertical_bias, 30);
                f551a.append(R.styleable.ConstraintLayout_Layout_layout_constraintDimensionRatio, 44);
                f551a.append(R.styleable.ConstraintLayout_Layout_layout_constraintHorizontal_weight, 45);
                f551a.append(R.styleable.ConstraintLayout_Layout_layout_constraintVertical_weight, 46);
                f551a.append(R.styleable.ConstraintLayout_Layout_layout_constraintHorizontal_chainStyle, 47);
                f551a.append(R.styleable.ConstraintLayout_Layout_layout_constraintVertical_chainStyle, 48);
                f551a.append(R.styleable.ConstraintLayout_Layout_layout_constrainedWidth, 27);
                f551a.append(R.styleable.ConstraintLayout_Layout_layout_constrainedHeight, 28);
                f551a.append(R.styleable.ConstraintLayout_Layout_layout_constraintWidth_default, 31);
                f551a.append(R.styleable.ConstraintLayout_Layout_layout_constraintHeight_default, 32);
                f551a.append(R.styleable.ConstraintLayout_Layout_layout_constraintWidth_min, 33);
                f551a.append(R.styleable.ConstraintLayout_Layout_layout_constraintWidth_max, 34);
                f551a.append(R.styleable.ConstraintLayout_Layout_layout_constraintWidth_percent, 35);
                f551a.append(R.styleable.ConstraintLayout_Layout_layout_constraintHeight_min, 36);
                f551a.append(R.styleable.ConstraintLayout_Layout_layout_constraintHeight_max, 37);
                f551a.append(R.styleable.ConstraintLayout_Layout_layout_constraintHeight_percent, 38);
                f551a.append(R.styleable.ConstraintLayout_Layout_layout_constraintLeft_creator, 39);
                f551a.append(R.styleable.ConstraintLayout_Layout_layout_constraintTop_creator, 40);
                f551a.append(R.styleable.ConstraintLayout_Layout_layout_constraintRight_creator, 41);
                f551a.append(R.styleable.ConstraintLayout_Layout_layout_constraintBottom_creator, 42);
                f551a.append(R.styleable.ConstraintLayout_Layout_layout_constraintBaseline_creator, 43);
            }
        }

        public a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            int i2;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i3 = 0; i3 < indexCount; i3++) {
                int index = obtainStyledAttributes.getIndex(i3);
                switch (C0012a.f551a.get(index)) {
                    case 1:
                        this.S = obtainStyledAttributes.getInt(index, this.S);
                        break;
                    case 2:
                        this.m = obtainStyledAttributes.getResourceId(index, this.m);
                        if (this.m != -1) {
                            break;
                        } else {
                            this.m = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 3:
                        this.n = obtainStyledAttributes.getDimensionPixelSize(index, this.n);
                        break;
                    case 4:
                        this.o = obtainStyledAttributes.getFloat(index, this.o) % 360.0f;
                        float f2 = this.o;
                        if (f2 >= 0.0f) {
                            break;
                        } else {
                            this.o = (360.0f - f2) % 360.0f;
                            break;
                        }
                    case 5:
                        this.f549a = obtainStyledAttributes.getDimensionPixelOffset(index, this.f549a);
                        break;
                    case 6:
                        this.f550b = obtainStyledAttributes.getDimensionPixelOffset(index, this.f550b);
                        break;
                    case 7:
                        this.c = obtainStyledAttributes.getFloat(index, this.c);
                        break;
                    case 8:
                        this.d = obtainStyledAttributes.getResourceId(index, this.d);
                        if (this.d != -1) {
                            break;
                        } else {
                            this.d = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 9:
                        this.e = obtainStyledAttributes.getResourceId(index, this.e);
                        if (this.e != -1) {
                            break;
                        } else {
                            this.e = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 10:
                        this.f = obtainStyledAttributes.getResourceId(index, this.f);
                        if (this.f != -1) {
                            break;
                        } else {
                            this.f = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 11:
                        this.g = obtainStyledAttributes.getResourceId(index, this.g);
                        if (this.g != -1) {
                            break;
                        } else {
                            this.g = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 12:
                        this.h = obtainStyledAttributes.getResourceId(index, this.h);
                        if (this.h != -1) {
                            break;
                        } else {
                            this.h = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 13:
                        this.i = obtainStyledAttributes.getResourceId(index, this.i);
                        if (this.i != -1) {
                            break;
                        } else {
                            this.i = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 14:
                        this.j = obtainStyledAttributes.getResourceId(index, this.j);
                        if (this.j != -1) {
                            break;
                        } else {
                            this.j = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 15:
                        this.k = obtainStyledAttributes.getResourceId(index, this.k);
                        if (this.k != -1) {
                            break;
                        } else {
                            this.k = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 16:
                        this.l = obtainStyledAttributes.getResourceId(index, this.l);
                        if (this.l != -1) {
                            break;
                        } else {
                            this.l = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 17:
                        this.p = obtainStyledAttributes.getResourceId(index, this.p);
                        if (this.p != -1) {
                            break;
                        } else {
                            this.p = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 18:
                        this.q = obtainStyledAttributes.getResourceId(index, this.q);
                        if (this.q != -1) {
                            break;
                        } else {
                            this.q = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 19:
                        this.r = obtainStyledAttributes.getResourceId(index, this.r);
                        if (this.r != -1) {
                            break;
                        } else {
                            this.r = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 20:
                        this.s = obtainStyledAttributes.getResourceId(index, this.s);
                        if (this.s != -1) {
                            break;
                        } else {
                            this.s = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 21:
                        this.t = obtainStyledAttributes.getDimensionPixelSize(index, this.t);
                        break;
                    case 22:
                        this.u = obtainStyledAttributes.getDimensionPixelSize(index, this.u);
                        break;
                    case 23:
                        this.v = obtainStyledAttributes.getDimensionPixelSize(index, this.v);
                        break;
                    case 24:
                        this.w = obtainStyledAttributes.getDimensionPixelSize(index, this.w);
                        break;
                    case 25:
                        this.x = obtainStyledAttributes.getDimensionPixelSize(index, this.x);
                        break;
                    case 26:
                        this.y = obtainStyledAttributes.getDimensionPixelSize(index, this.y);
                        break;
                    case 27:
                        this.T = obtainStyledAttributes.getBoolean(index, this.T);
                        break;
                    case 28:
                        this.U = obtainStyledAttributes.getBoolean(index, this.U);
                        break;
                    case 29:
                        this.z = obtainStyledAttributes.getFloat(index, this.z);
                        break;
                    case 30:
                        this.A = obtainStyledAttributes.getFloat(index, this.A);
                        break;
                    case 31:
                        this.I = obtainStyledAttributes.getInt(index, 0);
                        if (this.I != 1) {
                            break;
                        } else {
                            Log.e("ConstraintLayout", "layout_constraintWidth_default=\"wrap\" is deprecated.\nUse layout_width=\"WRAP_CONTENT\" and layout_constrainedWidth=\"true\" instead.");
                            break;
                        }
                    case 32:
                        this.J = obtainStyledAttributes.getInt(index, 0);
                        if (this.J != 1) {
                            break;
                        } else {
                            Log.e("ConstraintLayout", "layout_constraintHeight_default=\"wrap\" is deprecated.\nUse layout_height=\"WRAP_CONTENT\" and layout_constrainedHeight=\"true\" instead.");
                            break;
                        }
                    case 33:
                        try {
                            this.K = obtainStyledAttributes.getDimensionPixelSize(index, this.K);
                            break;
                        } catch (Exception unused) {
                            if (obtainStyledAttributes.getInt(index, this.K) != -2) {
                                break;
                            } else {
                                this.K = -2;
                                break;
                            }
                        }
                    case 34:
                        try {
                            this.M = obtainStyledAttributes.getDimensionPixelSize(index, this.M);
                            break;
                        } catch (Exception unused2) {
                            if (obtainStyledAttributes.getInt(index, this.M) != -2) {
                                break;
                            } else {
                                this.M = -2;
                                break;
                            }
                        }
                    case 35:
                        this.O = Math.max(0.0f, obtainStyledAttributes.getFloat(index, this.O));
                        break;
                    case 36:
                        try {
                            this.L = obtainStyledAttributes.getDimensionPixelSize(index, this.L);
                            break;
                        } catch (Exception unused3) {
                            if (obtainStyledAttributes.getInt(index, this.L) != -2) {
                                break;
                            } else {
                                this.L = -2;
                                break;
                            }
                        }
                    case 37:
                        try {
                            this.N = obtainStyledAttributes.getDimensionPixelSize(index, this.N);
                            break;
                        } catch (Exception unused4) {
                            if (obtainStyledAttributes.getInt(index, this.N) != -2) {
                                break;
                            } else {
                                this.N = -2;
                                break;
                            }
                        }
                    case 38:
                        this.P = Math.max(0.0f, obtainStyledAttributes.getFloat(index, this.P));
                        break;
                    case 44:
                        this.B = obtainStyledAttributes.getString(index);
                        this.C = Float.NaN;
                        this.D = -1;
                        String str = this.B;
                        if (str == null) {
                            break;
                        } else {
                            int length = str.length();
                            int indexOf = this.B.indexOf(44);
                            if (indexOf <= 0 || indexOf >= length - 1) {
                                i2 = 0;
                            } else {
                                String substring = this.B.substring(0, indexOf);
                                if (substring.equalsIgnoreCase(OppoExifInterface.GpsLongitudeRef.WEST)) {
                                    this.D = 0;
                                } else if (substring.equalsIgnoreCase("H")) {
                                    this.D = 1;
                                }
                                i2 = indexOf + 1;
                            }
                            int indexOf2 = this.B.indexOf(58);
                            if (indexOf2 >= 0 && indexOf2 < length - 1) {
                                String substring2 = this.B.substring(i2, indexOf2);
                                String substring3 = this.B.substring(indexOf2 + 1);
                                if (substring2.length() > 0 && substring3.length() > 0) {
                                    try {
                                        float parseFloat = Float.parseFloat(substring2);
                                        float parseFloat2 = Float.parseFloat(substring3);
                                        if (parseFloat > 0.0f && parseFloat2 > 0.0f) {
                                            if (this.D != 1) {
                                                this.C = Math.abs(parseFloat / parseFloat2);
                                                break;
                                            } else {
                                                this.C = Math.abs(parseFloat2 / parseFloat);
                                                break;
                                            }
                                        }
                                    } catch (NumberFormatException unused5) {
                                        break;
                                    }
                                }
                            } else {
                                String substring4 = this.B.substring(i2);
                                if (substring4.length() <= 0) {
                                    break;
                                } else {
                                    this.C = Float.parseFloat(substring4);
                                    break;
                                }
                            }
                        }
                        break;
                    case 45:
                        this.E = obtainStyledAttributes.getFloat(index, this.E);
                        break;
                    case 46:
                        this.F = obtainStyledAttributes.getFloat(index, this.F);
                        break;
                    case 47:
                        this.G = obtainStyledAttributes.getInt(index, 0);
                        break;
                    case 48:
                        this.H = obtainStyledAttributes.getInt(index, 0);
                        break;
                    case 49:
                        this.Q = obtainStyledAttributes.getDimensionPixelOffset(index, this.Q);
                        break;
                    case 50:
                        this.R = obtainStyledAttributes.getDimensionPixelOffset(index, this.R);
                        break;
                }
            }
            obtainStyledAttributes.recycle();
            a();
        }

        public void a() {
            this.Y = false;
            this.V = true;
            this.W = true;
            if (this.width == -2 && this.T) {
                this.V = false;
                this.I = 1;
            }
            if (this.height == -2 && this.U) {
                this.W = false;
                this.J = 1;
            }
            if (this.width == 0 || this.width == -1) {
                this.V = false;
                if (this.width == 0 && this.I == 1) {
                    this.width = -2;
                    this.T = true;
                }
            }
            if (this.height == 0 || this.height == -1) {
                this.W = false;
                if (this.height == 0 && this.J == 1) {
                    this.height = -2;
                    this.U = true;
                }
            }
            if (this.c != -1.0f || this.f549a != -1 || this.f550b != -1) {
                this.Y = true;
                this.V = true;
                this.W = true;
                if (!(this.al instanceof i)) {
                    this.al = new i();
                }
                ((i) this.al).a(this.S);
            }
        }

        public a(int i2, int i3) {
            super(i2, i3);
        }

        public a(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        /* JADX WARNING: Removed duplicated region for block: B:14:0x004c  */
        /* JADX WARNING: Removed duplicated region for block: B:17:0x0053  */
        /* JADX WARNING: Removed duplicated region for block: B:20:0x005a  */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x0060  */
        /* JADX WARNING: Removed duplicated region for block: B:26:0x0066  */
        /* JADX WARNING: Removed duplicated region for block: B:33:0x007c  */
        /* JADX WARNING: Removed duplicated region for block: B:34:0x0084  */
        @android.annotation.TargetApi(17)
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void resolveLayoutDirection(int r7) {
            /*
                r6 = this;
                int r0 = r6.leftMargin
                int r1 = r6.rightMargin
                super.resolveLayoutDirection(r7)
                r7 = -1
                r6.ad = r7
                r6.ae = r7
                r6.ab = r7
                r6.ac = r7
                r6.af = r7
                r6.ag = r7
                int r2 = r6.t
                r6.af = r2
                int r2 = r6.v
                r6.ag = r2
                float r2 = r6.z
                r6.ah = r2
                int r2 = r6.f549a
                r6.ai = r2
                int r2 = r6.f550b
                r6.aj = r2
                float r2 = r6.c
                r6.ak = r2
                int r2 = r6.getLayoutDirection()
                r3 = 0
                r4 = 1
                if (r4 != r2) goto L_0x0036
                r2 = r4
                goto L_0x0037
            L_0x0036:
                r2 = r3
            L_0x0037:
                if (r2 == 0) goto L_0x009a
                int r2 = r6.p
                if (r2 == r7) goto L_0x0041
                r6.ad = r2
            L_0x003f:
                r3 = r4
                goto L_0x0048
            L_0x0041:
                int r2 = r6.q
                if (r2 == r7) goto L_0x0048
                r6.ae = r2
                goto L_0x003f
            L_0x0048:
                int r2 = r6.r
                if (r2 == r7) goto L_0x004f
                r6.ac = r2
                r3 = r4
            L_0x004f:
                int r2 = r6.s
                if (r2 == r7) goto L_0x0056
                r6.ab = r2
                r3 = r4
            L_0x0056:
                int r2 = r6.x
                if (r2 == r7) goto L_0x005c
                r6.ag = r2
            L_0x005c:
                int r2 = r6.y
                if (r2 == r7) goto L_0x0062
                r6.af = r2
            L_0x0062:
                r2 = 1065353216(0x3f800000, float:1.0)
                if (r3 == 0) goto L_0x006c
                float r3 = r6.z
                float r3 = r2 - r3
                r6.ah = r3
            L_0x006c:
                boolean r3 = r6.Y
                if (r3 == 0) goto L_0x00be
                int r3 = r6.S
                if (r3 != r4) goto L_0x00be
                float r3 = r6.c
                r4 = -1082130432(0xffffffffbf800000, float:-1.0)
                int r5 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
                if (r5 == 0) goto L_0x0084
                float r2 = r2 - r3
                r6.ak = r2
                r6.ai = r7
                r6.aj = r7
                goto L_0x00be
            L_0x0084:
                int r2 = r6.f549a
                if (r2 == r7) goto L_0x008f
                r6.aj = r2
                r6.ai = r7
                r6.ak = r4
                goto L_0x00be
            L_0x008f:
                int r2 = r6.f550b
                if (r2 == r7) goto L_0x00be
                r6.ai = r2
                r6.aj = r7
                r6.ak = r4
                goto L_0x00be
            L_0x009a:
                int r2 = r6.p
                if (r2 == r7) goto L_0x00a0
                r6.ac = r2
            L_0x00a0:
                int r2 = r6.q
                if (r2 == r7) goto L_0x00a6
                r6.ab = r2
            L_0x00a6:
                int r2 = r6.r
                if (r2 == r7) goto L_0x00ac
                r6.ad = r2
            L_0x00ac:
                int r2 = r6.s
                if (r2 == r7) goto L_0x00b2
                r6.ae = r2
            L_0x00b2:
                int r2 = r6.x
                if (r2 == r7) goto L_0x00b8
                r6.af = r2
            L_0x00b8:
                int r2 = r6.y
                if (r2 == r7) goto L_0x00be
                r6.ag = r2
            L_0x00be:
                int r2 = r6.r
                if (r2 != r7) goto L_0x0108
                int r2 = r6.s
                if (r2 != r7) goto L_0x0108
                int r2 = r6.q
                if (r2 != r7) goto L_0x0108
                int r2 = r6.p
                if (r2 != r7) goto L_0x0108
                int r2 = r6.f
                if (r2 == r7) goto L_0x00dd
                r6.ad = r2
                int r2 = r6.rightMargin
                if (r2 > 0) goto L_0x00eb
                if (r1 <= 0) goto L_0x00eb
                r6.rightMargin = r1
                goto L_0x00eb
            L_0x00dd:
                int r2 = r6.g
                if (r2 == r7) goto L_0x00eb
                r6.ae = r2
                int r2 = r6.rightMargin
                if (r2 > 0) goto L_0x00eb
                if (r1 <= 0) goto L_0x00eb
                r6.rightMargin = r1
            L_0x00eb:
                int r1 = r6.d
                if (r1 == r7) goto L_0x00fa
                r6.ab = r1
                int r7 = r6.leftMargin
                if (r7 > 0) goto L_0x0108
                if (r0 <= 0) goto L_0x0108
                r6.leftMargin = r0
                goto L_0x0108
            L_0x00fa:
                int r1 = r6.e
                if (r1 == r7) goto L_0x0108
                r6.ac = r1
                int r7 = r6.leftMargin
                if (r7 > 0) goto L_0x0108
                if (r0 <= 0) goto L_0x0108
                r6.leftMargin = r0
            L_0x0108:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.a.resolveLayoutDirection(int):void");
        }
    }

    public void requestLayout() {
        super.requestLayout();
        this.m = true;
        this.r = -1;
        this.s = -1;
        this.c = -1;
        this.d = -1;
        this.e = 0;
        this.f = 0;
    }
}
