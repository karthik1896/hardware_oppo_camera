package com.color.support.widget.navigation;

import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.os.Build;
import android.util.SparseArray;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.view.menu.h;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.view.menu.o;

/* compiled from: ColorNavigationMenuView */
public class b extends ViewGroup implements o {

    /* renamed from: a  reason: collision with root package name */
    private View.OnClickListener f2238a;

    /* renamed from: b  reason: collision with root package name */
    private a[] f2239b;
    private ColorStateList c;
    private ColorStateList d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int[] k;
    private boolean l;
    private int m;
    private SparseArray<a> n;
    private ColorNavigationPresenter o;
    private h p;

    public int getWindowAnimations() {
        return 0;
    }

    public void initialize(h hVar) {
        this.p = hVar;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        int size = View.MeasureSpec.getSize(i2) - (this.j * 2);
        int childCount = getChildCount();
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.e, 1073741824);
        int i4 = size / (childCount == 0 ? 1 : childCount);
        int i5 = size - (i4 * childCount);
        for (int i6 = 0; i6 < childCount; i6++) {
            int[] iArr = this.k;
            iArr[i6] = i4;
            if (i5 > 0) {
                iArr[i6] = iArr[i6] + 1;
                i5--;
            }
        }
        int i7 = 0;
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = getChildAt(i8);
            if (childAt.getVisibility() != 8) {
                if (childCount == 1) {
                    int i9 = this.j;
                    childAt.setPadding(i9, 0, i9, 0);
                    childAt.measure(View.MeasureSpec.makeMeasureSpec(this.k[i8] + (this.j * 2), 1073741824), makeMeasureSpec);
                } else if (i8 == 0) {
                    childAt.setPadding(c() ? 0 : this.j, 0, c() ? this.j : 0, 0);
                    childAt.measure(View.MeasureSpec.makeMeasureSpec(this.k[i8] + this.j, 1073741824), makeMeasureSpec);
                } else if (i8 == childCount - 1) {
                    childAt.setPadding(c() ? this.j : 0, 0, c() ? 0 : this.j, 0);
                    childAt.measure(View.MeasureSpec.makeMeasureSpec(this.k[i8] + this.j, 1073741824), makeMeasureSpec);
                } else {
                    childAt.setPadding(0, 0, 0, 0);
                    childAt.measure(View.MeasureSpec.makeMeasureSpec(this.k[i8], 1073741824), makeMeasureSpec);
                }
                childAt.getLayoutParams().width = childAt.getMeasuredWidth();
                i7 += childAt.getMeasuredWidth();
            }
        }
        setMeasuredDimension(View.resolveSizeAndState(i7, View.MeasureSpec.makeMeasureSpec(i7, 1073741824), 0), View.resolveSizeAndState(this.e, makeMeasureSpec, 0));
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int childCount = getChildCount();
        int i6 = i4 - i2;
        int i7 = i5 - i3;
        int i8 = 0;
        for (int i9 = 0; i9 < childCount; i9++) {
            View childAt = getChildAt(i9);
            if (childAt.getVisibility() != 8) {
                if (c()) {
                    int i10 = i6 - i8;
                    childAt.layout(i10 - childAt.getMeasuredWidth(), 0, i10, i7);
                } else {
                    childAt.layout(i8, 0, childAt.getMeasuredWidth() + i8, i7);
                }
                i8 += childAt.getMeasuredWidth();
            }
        }
    }

    @Deprecated
    public void setIconTintList(ColorStateList colorStateList) {
        this.d = colorStateList;
        a[] aVarArr = this.f2239b;
        if (aVarArr != null) {
            for (a iconTintList : aVarArr) {
                iconTintList.setIconTintList(colorStateList);
            }
        }
    }

    public ColorStateList getIconTintList() {
        return this.d;
    }

    public void setItemTextColor(ColorStateList colorStateList) {
        this.c = colorStateList;
        a[] aVarArr = this.f2239b;
        if (aVarArr != null) {
            for (a textColor : aVarArr) {
                textColor.setTextColor(colorStateList);
            }
        }
    }

    public void setItemTextSize(int i2) {
        this.i = i2;
        a[] aVarArr = this.f2239b;
        if (aVarArr != null) {
            for (a textSize : aVarArr) {
                textSize.setTextSize(i2);
            }
        }
    }

    public ColorStateList getItemTextColor() {
        return this.c;
    }

    public void setItemBackgroundRes(int i2) {
        this.h = i2;
        a[] aVarArr = this.f2239b;
        if (aVarArr != null) {
            for (a itemBackground : aVarArr) {
                itemBackground.setItemBackground(i2);
            }
        }
    }

    public int getItemBackgroundRes() {
        return this.h;
    }

    public void setPresenter(ColorNavigationPresenter colorNavigationPresenter) {
        this.o = colorNavigationPresenter;
    }

    public void a() {
        int size = this.p.size();
        if (size != 0) {
            removeAllViews();
        }
        if (size == 0) {
            this.f = 0;
            this.g = 0;
            this.f2239b = null;
            return;
        }
        this.f2239b = new a[size];
        for (int i2 = 0; i2 < size; i2++) {
            j jVar = (j) this.p.getItem(i2);
            if (jVar.isVisible()) {
                if (i2 >= 5) {
                    break;
                }
                a newItem = getNewItem();
                this.f2239b[i2] = newItem;
                newItem.setIconTintList(this.d);
                newItem.setTextColor(this.c);
                newItem.setTextSize(this.i);
                newItem.setItemBackground(this.h);
                newItem.initialize(jVar, 0);
                newItem.setItemPosition(i2);
                newItem.setOnClickListener(this.f2238a);
                a aVar = this.n.get(jVar.getItemId());
                if (aVar != null) {
                    newItem.a(aVar.a(), aVar.b());
                }
                addView(newItem);
            }
        }
        this.g = Math.min(this.p.size() - 1, this.g);
        this.p.getItem(this.g).setChecked(true);
    }

    public void b() {
        int size = this.p.size();
        if (size != this.f2239b.length) {
            a();
            return;
        }
        int i2 = this.f;
        for (int i3 = 0; i3 < size; i3++) {
            MenuItem item = this.p.getItem(i3);
            if (item.isChecked()) {
                this.f = item.getItemId();
                this.g = i3;
            }
        }
        if (i2 != this.f) {
            int i4 = Build.VERSION.SDK_INT;
        }
        for (int i5 = 0; i5 < size; i5++) {
            if (this.f2239b[i5] != null) {
                this.o.a(true);
                this.f2239b[i5].initialize((j) this.p.getItem(i5), 0);
                this.o.a(false);
            }
        }
    }

    public int getSelectedItemId() {
        return this.f;
    }

    /* access modifiers changed from: package-private */
    public void a(int i2) {
        int size = this.p.size();
        for (int i3 = 0; i3 < size; i3++) {
            MenuItem item = this.p.getItem(i3);
            if (i2 == item.getItemId()) {
                this.f = i2;
                this.g = i3;
                item.setChecked(true);
                return;
            }
        }
    }

    public void setItemHeight(int i2) {
        this.e = i2;
    }

    /* access modifiers changed from: protected */
    public void setNeedTextAnim(boolean z) {
        this.l = z;
    }

    private a getNewItem() {
        return new a(getContext());
    }

    private boolean c() {
        if (Build.VERSION.SDK_INT <= 16 || getLayoutDirection() != 1) {
            return false;
        }
        return true;
    }

    /* compiled from: ColorNavigationMenuView */
    private static class a {

        /* renamed from: a  reason: collision with root package name */
        private int f2240a;

        /* renamed from: b  reason: collision with root package name */
        private int f2241b;

        public int a() {
            return this.f2240a;
        }

        public int b() {
            return this.f2241b;
        }
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        int b2 = com.color.support.d.h.b(getContext());
        if (b2 != this.m) {
            a();
            this.m = b2;
        }
    }
}
