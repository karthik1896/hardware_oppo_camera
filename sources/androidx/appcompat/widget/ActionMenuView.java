package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.appcompat.view.menu.h;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.view.menu.n;
import androidx.appcompat.view.menu.o;
import androidx.appcompat.widget.LinearLayoutCompat;

public class ActionMenuView extends LinearLayoutCompat implements h.b, o {

    /* renamed from: a  reason: collision with root package name */
    h.a f309a;

    /* renamed from: b  reason: collision with root package name */
    e f310b;
    private h c;
    private Context d;
    private int e;
    private boolean f;
    private ActionMenuPresenter g;
    private n.a h;
    private boolean i;
    private int j;
    private int k;
    private int l;

    public interface a {
        boolean b();

        boolean c();
    }

    public interface e {
        boolean a(MenuItem menuItem);
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return false;
    }

    public int getWindowAnimations() {
        return 0;
    }

    public ActionMenuView(Context context) {
        this(context, (AttributeSet) null);
    }

    public ActionMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setBaselineAligned(false);
        float f2 = context.getResources().getDisplayMetrics().density;
        this.k = (int) (56.0f * f2);
        this.l = (int) (f2 * 4.0f);
        this.d = context;
        this.e = 0;
    }

    public void setPopupTheme(int i2) {
        if (this.e != i2) {
            this.e = i2;
            if (i2 == 0) {
                this.d = getContext();
            } else {
                this.d = new ContextThemeWrapper(getContext(), i2);
            }
        }
    }

    public int getPopupTheme() {
        return this.e;
    }

    public void setPresenter(ActionMenuPresenter actionMenuPresenter) {
        this.g = actionMenuPresenter;
        this.g.a(this);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        ActionMenuPresenter actionMenuPresenter = this.g;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.updateMenuView(false);
            if (this.g.g()) {
                this.g.d();
                this.g.c();
            }
        }
    }

    public void setOnMenuItemClickListener(e eVar) {
        this.f310b = eVar;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        h hVar;
        boolean z = this.i;
        this.i = View.MeasureSpec.getMode(i2) == 1073741824;
        if (z != this.i) {
            this.j = 0;
        }
        int size = View.MeasureSpec.getSize(i2);
        if (!(!this.i || (hVar = this.c) == null || size == this.j)) {
            this.j = size;
            hVar.onItemsChanged(true);
        }
        int childCount = getChildCount();
        if (!this.i || childCount <= 0) {
            for (int i4 = 0; i4 < childCount; i4++) {
                c cVar = (c) getChildAt(i4).getLayoutParams();
                cVar.rightMargin = 0;
                cVar.leftMargin = 0;
            }
            super.onMeasure(i2, i3);
            return;
        }
        a(i2, i3);
    }

    /* JADX WARNING: Removed duplicated region for block: B:134:0x023d A[LOOP:5: B:134:0x023d->B:138:0x025b, LOOP_START, PHI: r13 
      PHI: (r13v3 int) = (r13v2 int), (r13v4 int) binds: [B:133:0x023b, B:138:0x025b] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x0260  */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x0263  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(int r30, int r31) {
        /*
            r29 = this;
            r0 = r29
            int r1 = android.view.View.MeasureSpec.getMode(r31)
            int r2 = android.view.View.MeasureSpec.getSize(r30)
            int r3 = android.view.View.MeasureSpec.getSize(r31)
            int r4 = r29.getPaddingLeft()
            int r5 = r29.getPaddingRight()
            int r4 = r4 + r5
            int r5 = r29.getPaddingTop()
            int r6 = r29.getPaddingBottom()
            int r5 = r5 + r6
            r6 = -2
            r7 = r31
            int r6 = getChildMeasureSpec(r7, r5, r6)
            int r2 = r2 - r4
            int r4 = r0.k
            int r7 = r2 / r4
            int r8 = r2 % r4
            r9 = 0
            if (r7 != 0) goto L_0x0035
            r0.setMeasuredDimension(r2, r9)
            return
        L_0x0035:
            int r8 = r8 / r7
            int r4 = r4 + r8
            int r8 = r29.getChildCount()
            r14 = r7
            r7 = r9
            r10 = r7
            r12 = r10
            r13 = r12
            r15 = r13
            r16 = r15
            r17 = 0
        L_0x0045:
            if (r7 >= r8) goto L_0x00c5
            android.view.View r11 = r0.getChildAt(r7)
            int r9 = r11.getVisibility()
            r19 = r3
            r3 = 8
            if (r9 != r3) goto L_0x0057
            goto L_0x00bf
        L_0x0057:
            boolean r3 = r11 instanceof androidx.appcompat.view.menu.b
            int r13 = r13 + 1
            if (r3 == 0) goto L_0x0066
            int r9 = r0.l
            r20 = r13
            r13 = 0
            r11.setPadding(r9, r13, r9, r13)
            goto L_0x0069
        L_0x0066:
            r20 = r13
            r13 = 0
        L_0x0069:
            android.view.ViewGroup$LayoutParams r9 = r11.getLayoutParams()
            androidx.appcompat.widget.ActionMenuView$c r9 = (androidx.appcompat.widget.ActionMenuView.c) r9
            r9.f = r13
            r9.c = r13
            r9.f312b = r13
            r9.d = r13
            r9.leftMargin = r13
            r9.rightMargin = r13
            if (r3 == 0) goto L_0x0088
            r3 = r11
            androidx.appcompat.view.menu.b r3 = (androidx.appcompat.view.menu.b) r3
            boolean r3 = r3.a()
            if (r3 == 0) goto L_0x0088
            r3 = 1
            goto L_0x0089
        L_0x0088:
            r3 = 0
        L_0x0089:
            r9.e = r3
            boolean r3 = r9.f311a
            if (r3 == 0) goto L_0x0091
            r3 = 1
            goto L_0x0092
        L_0x0091:
            r3 = r14
        L_0x0092:
            int r3 = a(r11, r4, r3, r6, r5)
            int r13 = java.lang.Math.max(r15, r3)
            boolean r15 = r9.d
            if (r15 == 0) goto L_0x00a0
            int r16 = r16 + 1
        L_0x00a0:
            boolean r9 = r9.f311a
            if (r9 == 0) goto L_0x00a5
            r12 = 1
        L_0x00a5:
            int r14 = r14 - r3
            int r9 = r11.getMeasuredHeight()
            int r10 = java.lang.Math.max(r10, r9)
            r9 = 1
            if (r3 != r9) goto L_0x00bb
            int r3 = r9 << r7
            r11 = r10
            long r9 = (long) r3
            long r9 = r17 | r9
            r17 = r9
            r10 = r11
            goto L_0x00bc
        L_0x00bb:
            r11 = r10
        L_0x00bc:
            r15 = r13
            r13 = r20
        L_0x00bf:
            int r7 = r7 + 1
            r3 = r19
            r9 = 0
            goto L_0x0045
        L_0x00c5:
            r19 = r3
            r3 = 2
            if (r12 == 0) goto L_0x00ce
            if (r13 != r3) goto L_0x00ce
            r5 = 1
            goto L_0x00cf
        L_0x00ce:
            r5 = 0
        L_0x00cf:
            r7 = 0
        L_0x00d0:
            r20 = 1
            if (r16 <= 0) goto L_0x0173
            if (r14 <= 0) goto L_0x0173
            r9 = 2147483647(0x7fffffff, float:NaN)
            r3 = r9
            r9 = 0
            r11 = 0
            r22 = 0
        L_0x00de:
            if (r9 >= r8) goto L_0x0112
            android.view.View r24 = r0.getChildAt(r9)
            android.view.ViewGroup$LayoutParams r24 = r24.getLayoutParams()
            r25 = r7
            r7 = r24
            androidx.appcompat.widget.ActionMenuView$c r7 = (androidx.appcompat.widget.ActionMenuView.c) r7
            r24 = r10
            boolean r10 = r7.d
            if (r10 != 0) goto L_0x00f5
            goto L_0x010b
        L_0x00f5:
            int r10 = r7.f312b
            if (r10 >= r3) goto L_0x0101
            int r3 = r7.f312b
            long r10 = r20 << r9
            r22 = r10
            r11 = 1
            goto L_0x010b
        L_0x0101:
            int r7 = r7.f312b
            if (r7 != r3) goto L_0x010b
            long r26 = r20 << r9
            long r22 = r22 | r26
            int r11 = r11 + 1
        L_0x010b:
            int r9 = r9 + 1
            r10 = r24
            r7 = r25
            goto L_0x00de
        L_0x0112:
            r25 = r7
            r24 = r10
            long r17 = r17 | r22
            if (r11 <= r14) goto L_0x011e
            r11 = r1
            r26 = r2
            goto L_0x017a
        L_0x011e:
            int r3 = r3 + 1
            r7 = 0
        L_0x0121:
            if (r7 >= r8) goto L_0x016d
            android.view.View r9 = r0.getChildAt(r7)
            android.view.ViewGroup$LayoutParams r10 = r9.getLayoutParams()
            androidx.appcompat.widget.ActionMenuView$c r10 = (androidx.appcompat.widget.ActionMenuView.c) r10
            r26 = r2
            r11 = 1
            int r2 = r11 << r7
            r11 = r1
            long r1 = (long) r2
            long r20 = r22 & r1
            r27 = 0
            int r20 = (r20 > r27 ? 1 : (r20 == r27 ? 0 : -1))
            if (r20 != 0) goto L_0x0145
            int r9 = r10.f312b
            if (r9 != r3) goto L_0x0142
            long r17 = r17 | r1
        L_0x0142:
            r20 = r3
            goto L_0x0165
        L_0x0145:
            if (r5 == 0) goto L_0x0159
            boolean r1 = r10.e
            if (r1 == 0) goto L_0x0159
            r1 = 1
            if (r14 != r1) goto L_0x0159
            int r2 = r0.l
            int r1 = r2 + r4
            r20 = r3
            r3 = 0
            r9.setPadding(r1, r3, r2, r3)
            goto L_0x015b
        L_0x0159:
            r20 = r3
        L_0x015b:
            int r1 = r10.f312b
            r2 = 1
            int r1 = r1 + r2
            r10.f312b = r1
            r10.f = r2
            int r14 = r14 + -1
        L_0x0165:
            int r7 = r7 + 1
            r1 = r11
            r3 = r20
            r2 = r26
            goto L_0x0121
        L_0x016d:
            r10 = r24
            r3 = 2
            r7 = 1
            goto L_0x00d0
        L_0x0173:
            r11 = r1
            r26 = r2
            r25 = r7
            r24 = r10
        L_0x017a:
            if (r12 != 0) goto L_0x0181
            r1 = 1
            if (r13 != r1) goto L_0x0182
            r2 = r1
            goto L_0x0183
        L_0x0181:
            r1 = 1
        L_0x0182:
            r2 = 0
        L_0x0183:
            if (r14 <= 0) goto L_0x0238
            r9 = 0
            int r3 = (r17 > r9 ? 1 : (r17 == r9 ? 0 : -1))
            if (r3 == 0) goto L_0x0238
            int r13 = r13 - r1
            if (r14 < r13) goto L_0x0192
            if (r2 != 0) goto L_0x0192
            if (r15 <= r1) goto L_0x0238
        L_0x0192:
            int r1 = java.lang.Long.bitCount(r17)
            float r1 = (float) r1
            if (r2 != 0) goto L_0x01d3
            long r2 = r17 & r20
            r9 = 0
            int r2 = (r2 > r9 ? 1 : (r2 == r9 ? 0 : -1))
            r3 = 1056964608(0x3f000000, float:0.5)
            if (r2 == 0) goto L_0x01b4
            r13 = 0
            android.view.View r2 = r0.getChildAt(r13)
            android.view.ViewGroup$LayoutParams r2 = r2.getLayoutParams()
            androidx.appcompat.widget.ActionMenuView$c r2 = (androidx.appcompat.widget.ActionMenuView.c) r2
            boolean r2 = r2.e
            if (r2 != 0) goto L_0x01b5
            float r1 = r1 - r3
            goto L_0x01b5
        L_0x01b4:
            r13 = 0
        L_0x01b5:
            int r2 = r8 + -1
            r5 = 1
            int r7 = r5 << r2
            long r9 = (long) r7
            long r9 = r17 & r9
            r15 = 0
            int r5 = (r9 > r15 ? 1 : (r9 == r15 ? 0 : -1))
            if (r5 == 0) goto L_0x01d4
            android.view.View r2 = r0.getChildAt(r2)
            android.view.ViewGroup$LayoutParams r2 = r2.getLayoutParams()
            androidx.appcompat.widget.ActionMenuView$c r2 = (androidx.appcompat.widget.ActionMenuView.c) r2
            boolean r2 = r2.e
            if (r2 != 0) goto L_0x01d4
            float r1 = r1 - r3
            goto L_0x01d4
        L_0x01d3:
            r13 = 0
        L_0x01d4:
            r2 = 0
            int r2 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r2 <= 0) goto L_0x01de
            int r14 = r14 * r4
            float r2 = (float) r14
            float r2 = r2 / r1
            int r9 = (int) r2
            goto L_0x01df
        L_0x01de:
            r9 = r13
        L_0x01df:
            r1 = r13
        L_0x01e0:
            if (r1 >= r8) goto L_0x0239
            r2 = 1
            int r3 = r2 << r1
            long r2 = (long) r3
            long r2 = r17 & r2
            r14 = 0
            int r2 = (r2 > r14 ? 1 : (r2 == r14 ? 0 : -1))
            if (r2 != 0) goto L_0x01f1
            r2 = 1
            r5 = 2
            goto L_0x0235
        L_0x01f1:
            android.view.View r2 = r0.getChildAt(r1)
            android.view.ViewGroup$LayoutParams r3 = r2.getLayoutParams()
            androidx.appcompat.widget.ActionMenuView$c r3 = (androidx.appcompat.widget.ActionMenuView.c) r3
            boolean r2 = r2 instanceof androidx.appcompat.view.menu.b
            if (r2 == 0) goto L_0x0215
            r3.c = r9
            r2 = 1
            r3.f = r2
            if (r1 != 0) goto L_0x0210
            boolean r2 = r3.e
            if (r2 != 0) goto L_0x0210
            int r2 = -r9
            r5 = 2
            int r2 = r2 / r5
            r3.leftMargin = r2
            goto L_0x0211
        L_0x0210:
            r5 = 2
        L_0x0211:
            r2 = 1
            r25 = 1
            goto L_0x0235
        L_0x0215:
            r5 = 2
            boolean r2 = r3.f311a
            if (r2 == 0) goto L_0x0226
            r3.c = r9
            r2 = 1
            r3.f = r2
            int r7 = -r9
            int r7 = r7 / r5
            r3.rightMargin = r7
            r25 = r2
            goto L_0x0235
        L_0x0226:
            r2 = 1
            if (r1 == 0) goto L_0x022d
            int r7 = r9 / 2
            r3.leftMargin = r7
        L_0x022d:
            int r7 = r8 + -1
            if (r1 == r7) goto L_0x0235
            int r7 = r9 / 2
            r3.rightMargin = r7
        L_0x0235:
            int r1 = r1 + 1
            goto L_0x01e0
        L_0x0238:
            r13 = 0
        L_0x0239:
            r1 = 1073741824(0x40000000, float:2.0)
            if (r25 == 0) goto L_0x025e
        L_0x023d:
            if (r13 >= r8) goto L_0x025e
            android.view.View r2 = r0.getChildAt(r13)
            android.view.ViewGroup$LayoutParams r3 = r2.getLayoutParams()
            androidx.appcompat.widget.ActionMenuView$c r3 = (androidx.appcompat.widget.ActionMenuView.c) r3
            boolean r5 = r3.f
            if (r5 != 0) goto L_0x024e
            goto L_0x025b
        L_0x024e:
            int r5 = r3.f312b
            int r5 = r5 * r4
            int r3 = r3.c
            int r5 = r5 + r3
            int r3 = android.view.View.MeasureSpec.makeMeasureSpec(r5, r1)
            r2.measure(r3, r6)
        L_0x025b:
            int r13 = r13 + 1
            goto L_0x023d
        L_0x025e:
            if (r11 == r1) goto L_0x0263
            r1 = r24
            goto L_0x0265
        L_0x0263:
            r1 = r19
        L_0x0265:
            r2 = r26
            r0.setMeasuredDimension(r2, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ActionMenuView.a(int, int):void");
    }

    static int a(View view, int i2, int i3, int i4, int i5) {
        c cVar = (c) view.getLayoutParams();
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i4) - i5, View.MeasureSpec.getMode(i4));
        androidx.appcompat.view.menu.b bVar = view instanceof androidx.appcompat.view.menu.b ? (androidx.appcompat.view.menu.b) view : null;
        boolean z = true;
        boolean z2 = bVar != null && bVar.a();
        int i6 = 2;
        if (i3 <= 0 || (z2 && i3 < 2)) {
            i6 = 0;
        } else {
            view.measure(View.MeasureSpec.makeMeasureSpec(i3 * i2, Integer.MIN_VALUE), makeMeasureSpec);
            int measuredWidth = view.getMeasuredWidth();
            int i7 = measuredWidth / i2;
            if (measuredWidth % i2 != 0) {
                i7++;
            }
            if (!z2 || i7 >= 2) {
                i6 = i7;
            }
        }
        if (cVar.f311a || !z2) {
            z = false;
        }
        cVar.d = z;
        cVar.f312b = i6;
        view.measure(View.MeasureSpec.makeMeasureSpec(i2 * i6, 1073741824), makeMeasureSpec);
        return i6;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int i6;
        int i7;
        int i8;
        int i9;
        if (!this.i) {
            super.onLayout(z, i2, i3, i4, i5);
            return;
        }
        int childCount = getChildCount();
        int i10 = (i5 - i3) / 2;
        int dividerWidth = getDividerWidth();
        int i11 = i4 - i2;
        int paddingRight = (i11 - getPaddingRight()) - getPaddingLeft();
        boolean a2 = ax.a(this);
        int i12 = paddingRight;
        int i13 = 0;
        int i14 = 0;
        for (int i15 = 0; i15 < childCount; i15++) {
            View childAt = getChildAt(i15);
            if (childAt.getVisibility() != 8) {
                c cVar = (c) childAt.getLayoutParams();
                if (cVar.f311a) {
                    int measuredWidth = childAt.getMeasuredWidth();
                    if (a(i15)) {
                        measuredWidth += dividerWidth;
                    }
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (a2) {
                        i8 = getPaddingLeft() + cVar.leftMargin;
                        i9 = i8 + measuredWidth;
                    } else {
                        i9 = (getWidth() - getPaddingRight()) - cVar.rightMargin;
                        i8 = i9 - measuredWidth;
                    }
                    int i16 = i10 - (measuredHeight / 2);
                    childAt.layout(i8, i16, i9, measuredHeight + i16);
                    i12 -= measuredWidth;
                    i13 = 1;
                } else {
                    i12 -= (childAt.getMeasuredWidth() + cVar.leftMargin) + cVar.rightMargin;
                    boolean a3 = a(i15);
                    i14++;
                }
            }
        }
        if (childCount == 1 && i13 == 0) {
            View childAt2 = getChildAt(0);
            int measuredWidth2 = childAt2.getMeasuredWidth();
            int measuredHeight2 = childAt2.getMeasuredHeight();
            int i17 = (i11 / 2) - (measuredWidth2 / 2);
            int i18 = i10 - (measuredHeight2 / 2);
            childAt2.layout(i17, i18, measuredWidth2 + i17, measuredHeight2 + i18);
            return;
        }
        int i19 = i14 - (i13 ^ 1);
        if (i19 > 0) {
            i6 = i12 / i19;
            i7 = 0;
        } else {
            i7 = 0;
            i6 = 0;
        }
        int max = Math.max(i7, i6);
        if (a2) {
            int width = getWidth() - getPaddingRight();
            while (i7 < childCount) {
                View childAt3 = getChildAt(i7);
                c cVar2 = (c) childAt3.getLayoutParams();
                if (childAt3.getVisibility() != 8 && !cVar2.f311a) {
                    int i20 = width - cVar2.rightMargin;
                    int measuredWidth3 = childAt3.getMeasuredWidth();
                    int measuredHeight3 = childAt3.getMeasuredHeight();
                    int i21 = i10 - (measuredHeight3 / 2);
                    childAt3.layout(i20 - measuredWidth3, i21, i20, measuredHeight3 + i21);
                    width = i20 - ((measuredWidth3 + cVar2.leftMargin) + max);
                }
                i7++;
            }
            return;
        }
        int paddingLeft = getPaddingLeft();
        while (i7 < childCount) {
            View childAt4 = getChildAt(i7);
            c cVar3 = (c) childAt4.getLayoutParams();
            if (childAt4.getVisibility() != 8 && !cVar3.f311a) {
                int i22 = paddingLeft + cVar3.leftMargin;
                int measuredWidth4 = childAt4.getMeasuredWidth();
                int measuredHeight4 = childAt4.getMeasuredHeight();
                int i23 = i10 - (measuredHeight4 / 2);
                childAt4.layout(i22, i23, i22 + measuredWidth4, measuredHeight4 + i23);
                paddingLeft = i22 + measuredWidth4 + cVar3.rightMargin + max;
            }
            i7++;
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        i();
    }

    public void setOverflowIcon(Drawable drawable) {
        getMenu();
        this.g.a(drawable);
    }

    public Drawable getOverflowIcon() {
        getMenu();
        return this.g.b();
    }

    public boolean a() {
        return this.f;
    }

    public void setOverflowReserved(boolean z) {
        this.f = z;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public c generateDefaultLayoutParams() {
        c cVar = new c(-2, -2);
        cVar.h = 16;
        return cVar;
    }

    /* renamed from: a */
    public c generateLayoutParams(AttributeSet attributeSet) {
        return new c(getContext(), attributeSet);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public c generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams == null) {
            return generateDefaultLayoutParams();
        }
        c cVar = layoutParams instanceof c ? new c((c) layoutParams) : new c(layoutParams);
        if (cVar.h <= 0) {
            cVar.h = 16;
        }
        return cVar;
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof c;
    }

    public c c() {
        c b2 = generateDefaultLayoutParams();
        b2.f311a = true;
        return b2;
    }

    public boolean a(j jVar) {
        return this.c.performItemAction(jVar, 0);
    }

    public void initialize(h hVar) {
        this.c = hVar;
    }

    public Menu getMenu() {
        if (this.c == null) {
            Context context = getContext();
            this.c = new h(context);
            this.c.setCallback(new d());
            this.g = new ActionMenuPresenter(context);
            this.g.a(true);
            ActionMenuPresenter actionMenuPresenter = this.g;
            n.a aVar = this.h;
            if (aVar == null) {
                aVar = new b();
            }
            actionMenuPresenter.setCallback(aVar);
            this.c.addMenuPresenter(this.g, this.d);
            this.g.a(this);
        }
        return this.c;
    }

    public void a(n.a aVar, h.a aVar2) {
        this.h = aVar;
        this.f309a = aVar2;
    }

    public h d() {
        return this.c;
    }

    public boolean e() {
        ActionMenuPresenter actionMenuPresenter = this.g;
        return actionMenuPresenter != null && actionMenuPresenter.c();
    }

    public boolean f() {
        ActionMenuPresenter actionMenuPresenter = this.g;
        return actionMenuPresenter != null && actionMenuPresenter.d();
    }

    public boolean g() {
        ActionMenuPresenter actionMenuPresenter = this.g;
        return actionMenuPresenter != null && actionMenuPresenter.g();
    }

    public boolean h() {
        ActionMenuPresenter actionMenuPresenter = this.g;
        return actionMenuPresenter != null && actionMenuPresenter.h();
    }

    public void i() {
        ActionMenuPresenter actionMenuPresenter = this.g;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.e();
        }
    }

    /* access modifiers changed from: protected */
    public boolean a(int i2) {
        boolean z = false;
        if (i2 == 0) {
            return false;
        }
        View childAt = getChildAt(i2 - 1);
        View childAt2 = getChildAt(i2);
        if (i2 < getChildCount() && (childAt instanceof a)) {
            z = false | ((a) childAt).c();
        }
        return (i2 <= 0 || !(childAt2 instanceof a)) ? z : z | ((a) childAt2).b();
    }

    public void setExpandedActionViewsExclusive(boolean z) {
        this.g.b(z);
    }

    private class d implements h.a {
        d() {
        }

        public boolean onMenuItemSelected(h hVar, MenuItem menuItem) {
            return ActionMenuView.this.f310b != null && ActionMenuView.this.f310b.a(menuItem);
        }

        public void onMenuModeChange(h hVar) {
            if (ActionMenuView.this.f309a != null) {
                ActionMenuView.this.f309a.onMenuModeChange(hVar);
            }
        }
    }

    private static class b implements n.a {
        public void a(h hVar, boolean z) {
        }

        public boolean a(h hVar) {
            return false;
        }

        b() {
        }
    }

    public static class c extends LinearLayoutCompat.a {
        @ViewDebug.ExportedProperty

        /* renamed from: a  reason: collision with root package name */
        public boolean f311a;
        @ViewDebug.ExportedProperty

        /* renamed from: b  reason: collision with root package name */
        public int f312b;
        @ViewDebug.ExportedProperty
        public int c;
        @ViewDebug.ExportedProperty
        public boolean d;
        @ViewDebug.ExportedProperty
        public boolean e;
        boolean f;

        public c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public c(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public c(c cVar) {
            super(cVar);
            this.f311a = cVar.f311a;
        }

        public c(int i, int i2) {
            super(i, i2);
            this.f311a = false;
        }
    }
}
