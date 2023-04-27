package com.heytap.epona;

import android.os.Parcel;
import android.os.Parcelable;

class ExceptionInfo implements Parcelable {
    public static final Parcelable.Creator<ExceptionInfo> CREATOR = new Parcelable.Creator<ExceptionInfo>() {
        /* renamed from: a */
        public ExceptionInfo createFromParcel(Parcel parcel) {
            return new ExceptionInfo(parcel);
        }

        /* renamed from: a */
        public ExceptionInfo[] newArray(int i) {
            return new ExceptionInfo[i];
        }
    };
    private String mMessage;
    private String mName;

    public int describeContents() {
        return 0;
    }

    ExceptionInfo(Throwable th) {
        this.mName = th.getClass().getName();
        this.mMessage = th.getMessage();
    }

    private ExceptionInfo(Parcel parcel) {
        this.mName = parcel.readString();
        this.mMessage = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mName);
        parcel.writeString(this.mMessage);
    }

    public String getName() {
        return this.mName;
    }

    public String getMessage() {
        return this.mMessage;
    }
}
