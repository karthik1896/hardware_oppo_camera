package com.google.android.apps.gsa.publicsearch;

import android.os.Parcel;
import android.os.Parcelable;

public final class SystemParcelableWrapper implements Parcelable {
    public static final Parcelable.Creator<SystemParcelableWrapper> CREATOR = new Parcelable.Creator<SystemParcelableWrapper>() {
        public SystemParcelableWrapper createFromParcel(Parcel parcel) {
            return new SystemParcelableWrapper(parcel.readParcelable((ClassLoader) null));
        }

        public SystemParcelableWrapper[] newArray(int i) {
            return new SystemParcelableWrapper[i];
        }
    };
    private final Parcelable parcelable;

    public int describeContents() {
        return 0;
    }

    public SystemParcelableWrapper(Parcelable parcelable2) {
        if (isSystemParcelable(parcelable2)) {
            this.parcelable = parcelable2;
            return;
        }
        throw new IllegalArgumentException("Only Android system classes can be passed in SystemParcelableWrapper.");
    }

    public Parcelable getParcelable() {
        return this.parcelable;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.parcelable, i);
    }

    static boolean isSystemParcelable(Parcelable parcelable2) {
        return parcelable2.getClass().getName().startsWith("android.os.");
    }
}
