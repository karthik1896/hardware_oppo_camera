package com.heytap.epona;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

public class Request implements Parcelable {
    public static final Parcelable.Creator<Request> CREATOR = new Parcelable.Creator<Request>() {
        /* renamed from: a */
        public Request createFromParcel(Parcel parcel) {
            return new Request(parcel);
        }

        /* renamed from: a */
        public Request[] newArray(int i) {
            return new Request[i];
        }
    };
    private final String mActionName;
    private Bundle mBundle;
    private final String mComponentName;

    public int describeContents() {
        return 0;
    }

    private Request(String str, String str2, Bundle bundle) {
        this.mBundle = new Bundle();
        this.mComponentName = str;
        this.mActionName = str2;
        this.mBundle.putAll(bundle);
    }

    private Request(Parcel parcel) {
        this.mBundle = new Bundle();
        this.mComponentName = parcel.readString();
        this.mActionName = parcel.readString();
        this.mBundle = parcel.readBundle(getClass().getClassLoader());
    }

    public void putBundle(Bundle bundle) {
        this.mBundle.putAll(bundle);
    }

    public String getComponentName() {
        return this.mComponentName;
    }

    public String getActionName() {
        return this.mActionName;
    }

    public Bundle getBundle() {
        return this.mBundle;
    }

    public String toString() {
        return "Request{Component=" + this.mComponentName + ",Action=" + this.mActionName + ",Bundle=" + this.mBundle + "}";
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mComponentName);
        parcel.writeString(this.mActionName);
        parcel.writeBundle(this.mBundle);
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private String f2576a;

        /* renamed from: b  reason: collision with root package name */
        private String f2577b;
        private Bundle c = new Bundle();

        public a a(String str) {
            this.f2576a = str;
            return this;
        }

        public a b(String str) {
            this.f2577b = str;
            return this;
        }

        public a a(String str, int i) {
            this.c.putInt(str, i);
            return this;
        }

        public a a(String str, float f) {
            this.c.putFloat(str, f);
            return this;
        }

        public a a(String str, String str2) {
            this.c.putString(str, str2);
            return this;
        }

        public Request a() {
            return new Request(this.f2576a, this.f2577b, this.c);
        }
    }
}
