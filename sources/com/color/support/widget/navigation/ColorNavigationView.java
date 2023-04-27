package com.color.support.widget.navigation;

import android.animation.Animator;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.FrameLayout;
import androidx.appcompat.view.g;
import androidx.appcompat.view.menu.h;
import androidx.customview.view.AbsSavedState;
import color.support.v7.appcompat.R;

public class ColorNavigationView extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f2233a = {16842912};

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f2234b = {-16842910};
    private final h c;
    private final b d;
    private final ColorNavigationPresenter e;
    private MenuInflater f;
    private Animator g;
    private Animator h;
    private int i;
    private int j;
    private c k;
    private b l;
    private a m;

    public interface a {
    }

    public interface b {
    }

    public interface c {
    }

    public int getMaxItemCount() {
        return 5;
    }

    private void a(boolean z) {
        int i2;
        if (this.i == 0) {
            i2 = getResources().getDimensionPixelSize(z ? R.dimen.color_tool_navigation_item_height : R.dimen.color_tool_navigation_item_height_land);
        } else {
            i2 = getResources().getDimensionPixelSize(z ? R.dimen.color_navigation_item_height : R.dimen.color_navigation_item_height_land);
        }
        this.d.setItemHeight(i2);
    }

    public void setOnNavigationItemSelectedListener(c cVar) {
        this.k = cVar;
    }

    public void setOnNavigationItemReselectedListener(b bVar) {
        this.l = bVar;
    }

    public Menu getMenu() {
        return this.c;
    }

    public ColorStateList getItemIconTintList() {
        return this.d.getIconTintList();
    }

    @Deprecated
    public void setItemIconTintList(ColorStateList colorStateList) {
        this.d.setIconTintList(colorStateList);
    }

    public ColorStateList getItemTextColor() {
        return this.d.getItemTextColor();
    }

    public void setItemTextColor(ColorStateList colorStateList) {
        this.d.setItemTextColor(colorStateList);
    }

    public int getItemBackgroundResource() {
        return this.d.getItemBackgroundRes();
    }

    public void setItemBackgroundResource(int i2) {
        this.d.setItemBackgroundRes(i2);
    }

    public int getSelectedItemId() {
        return this.d.getSelectedItemId();
    }

    public void setSelectedItemId(int i2) {
        MenuItem findItem = this.c.findItem(i2);
        if (findItem != null && !this.c.performItemAction(findItem, this.e, 0)) {
            findItem.setChecked(true);
        }
    }

    public void setAnimationType(int i2) {
        if (i2 == 1) {
            this.g.start();
        } else if (i2 == 2) {
            this.h.start();
        }
    }

    public void setNeedTextAnim(boolean z) {
        this.d.setNeedTextAnim(z);
    }

    public void setOnAnimatorListener(a aVar) {
        this.m = aVar;
    }

    private MenuInflater getMenuInflater() {
        if (this.f == null) {
            this.f = new g(getContext());
        }
        return this.f;
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.menuPresenterState = new Bundle();
        this.c.savePresenterStates(savedState.menuPresenterState);
        return savedState;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.c.restorePresenterStates(savedState.menuPresenterState);
    }

    static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() {
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, (ClassLoader) null);
            }

            /* renamed from: a */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        Bundle menuPresenterState;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            readFromParcel(parcel, classLoader);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeBundle(this.menuPresenterState);
        }

        private void readFromParcel(Parcel parcel, ClassLoader classLoader) {
            this.menuPresenterState = parcel.readBundle(classLoader);
        }
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        int b2 = com.color.support.d.h.b(getContext());
        if (this.j != b2) {
            a(com.color.support.d.h.a(b2));
            this.j = b2;
        }
    }
}
