package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import android.widget.TabHost;
import java.util.ArrayList;

@Deprecated
public class FragmentTabHost extends TabHost implements TabHost.OnTabChangeListener {

    /* renamed from: a  reason: collision with root package name */
    private final ArrayList<a> f835a;

    /* renamed from: b  reason: collision with root package name */
    private Context f836b;
    private h c;
    private int d;
    private TabHost.OnTabChangeListener e;
    private a f;
    private boolean g;

    static final class a {

        /* renamed from: a  reason: collision with root package name */
        final String f837a;

        /* renamed from: b  reason: collision with root package name */
        final Class<?> f838b;
        final Bundle c;
        Fragment d;
    }

    static class SavedState extends View.BaseSavedState {
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
        String curTab;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        SavedState(Parcel parcel) {
            super(parcel);
            this.curTab = parcel.readString();
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.curTab);
        }

        public String toString() {
            return "FragmentTabHost.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " curTab=" + this.curTab + "}";
        }
    }

    @Deprecated
    public void setup() {
        throw new IllegalStateException("Must call setup() that takes a Context and FragmentManager");
    }

    @Deprecated
    public void setOnTabChangedListener(TabHost.OnTabChangeListener onTabChangeListener) {
        this.e = onTabChangeListener;
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        String currentTabTag = getCurrentTabTag();
        int size = this.f835a.size();
        k kVar = null;
        for (int i = 0; i < size; i++) {
            a aVar = this.f835a.get(i);
            aVar.d = this.c.a(aVar.f837a);
            if (aVar.d != null && !aVar.d.isDetached()) {
                if (aVar.f837a.equals(currentTabTag)) {
                    this.f = aVar;
                } else {
                    if (kVar == null) {
                        kVar = this.c.a();
                    }
                    kVar.b(aVar.d);
                }
            }
        }
        this.g = true;
        k a2 = a(currentTabTag, kVar);
        if (a2 != null) {
            a2.b();
            this.c.b();
        }
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.g = false;
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.curTab = getCurrentTabTag();
        return savedState;
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public void onRestoreInstanceState(@SuppressLint({"UnknownNullness"}) Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setCurrentTabByTag(savedState.curTab);
    }

    @Deprecated
    public void onTabChanged(String str) {
        k a2;
        if (this.g && (a2 = a(str, (k) null)) != null) {
            a2.b();
        }
        TabHost.OnTabChangeListener onTabChangeListener = this.e;
        if (onTabChangeListener != null) {
            onTabChangeListener.onTabChanged(str);
        }
    }

    private k a(String str, k kVar) {
        a a2 = a(str);
        if (this.f != a2) {
            if (kVar == null) {
                kVar = this.c.a();
            }
            a aVar = this.f;
            if (!(aVar == null || aVar.d == null)) {
                kVar.b(this.f.d);
            }
            if (a2 != null) {
                if (a2.d == null) {
                    a2.d = this.c.f().c(this.f836b.getClassLoader(), a2.f838b.getName());
                    a2.d.setArguments(a2.c);
                    kVar.a(this.d, a2.d, a2.f837a);
                } else {
                    kVar.c(a2.d);
                }
            }
            this.f = a2;
        }
        return kVar;
    }

    private a a(String str) {
        int size = this.f835a.size();
        for (int i = 0; i < size; i++) {
            a aVar = this.f835a.get(i);
            if (aVar.f837a.equals(str)) {
                return aVar;
            }
        }
        return null;
    }
}
