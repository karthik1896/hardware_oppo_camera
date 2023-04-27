package com.color.support.widget.navigation;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.appcompat.view.menu.h;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.view.menu.n;
import androidx.appcompat.view.menu.s;

public class ColorNavigationPresenter implements n {

    /* renamed from: a  reason: collision with root package name */
    private h f2231a;

    /* renamed from: b  reason: collision with root package name */
    private b f2232b;
    private boolean c;
    private int d;

    public boolean collapseItemActionView(h hVar, j jVar) {
        return false;
    }

    public boolean expandItemActionView(h hVar, j jVar) {
        return false;
    }

    public boolean flagActionItems() {
        return false;
    }

    public void onCloseMenu(h hVar, boolean z) {
    }

    public boolean onSubMenuSelected(s sVar) {
        return false;
    }

    public void setCallback(n.a aVar) {
    }

    public void initForMenu(Context context, h hVar) {
        this.f2232b.initialize(this.f2231a);
        this.f2231a = hVar;
    }

    public void updateMenuView(boolean z) {
        if (!this.c) {
            if (z) {
                this.f2232b.a();
            } else {
                this.f2232b.b();
            }
        }
    }

    public int getId() {
        return this.d;
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState();
        savedState.mSelectedItemId = this.f2232b.getSelectedItemId();
        return savedState;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            this.f2232b.a(((SavedState) parcelable).mSelectedItemId);
        }
    }

    public void a(boolean z) {
        this.c = z;
    }

    static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* renamed from: a */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int mSelectedItemId;

        public int describeContents() {
            return 0;
        }

        SavedState() {
        }

        SavedState(Parcel parcel) {
            this.mSelectedItemId = parcel.readInt();
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.mSelectedItemId);
        }
    }
}
