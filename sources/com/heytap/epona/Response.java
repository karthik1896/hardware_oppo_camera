package com.heytap.epona;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

public class Response implements Parcelable {
    private static final int CODE_FAILED = -1;
    private static final int CODE_SUCCESS = 1;
    public static final Parcelable.Creator<Response> CREATOR = new Parcelable.Creator<Response>() {
        /* renamed from: a */
        public Response createFromParcel(Parcel parcel) {
            return new Response(parcel);
        }

        /* renamed from: a */
        public Response[] newArray(int i) {
            return new Response[i];
        }
    };
    private static final String EXCEPTION_INFO = "epona_exception_info";
    private Bundle mBundle;
    private final int mCode;
    private final String mMessage;
    private g mParcelableException;

    public int describeContents() {
        return 0;
    }

    private Response(int i, String str) {
        this.mCode = i;
        this.mMessage = str;
        this.mBundle = new Bundle();
    }

    private Response(Parcel parcel) {
        this.mCode = parcel.readInt();
        this.mMessage = parcel.readString();
        this.mBundle = parcel.readBundle(getClass().getClassLoader());
    }

    public Bundle getBundle() {
        return this.mBundle;
    }

    private void setBundle(Bundle bundle) {
        this.mBundle = bundle;
    }

    public int getCode() {
        return this.mCode;
    }

    public String getMessage() {
        return this.mMessage;
    }

    public String toString() {
        return "Successful=" + isSuccessful() + ", Message=" + this.mMessage;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mCode);
        parcel.writeString(this.mMessage);
        parcel.writeBundle(this.mBundle);
    }

    public static Response newResponse(Bundle bundle) {
        Response response = new Response(1, "");
        response.setBundle(bundle);
        return response;
    }

    public static Response defaultErrorResponse() {
        return new Response(-1, "somethings not yet...");
    }

    public static Response errorResponse(String str) {
        return new Response(-1, str);
    }

    public static Response errorResponse(Exception exc) {
        Response response = new Response(-1, "response has exception");
        Bundle bundle = new Bundle();
        bundle.putParcelable(EXCEPTION_INFO, new ExceptionInfo((Throwable) exc));
        response.setBundle(bundle);
        return response;
    }

    public <T extends Throwable> void checkThrowable(Class<T> cls) throws Throwable {
        Bundle bundle = this.mBundle;
        if (bundle != null) {
            if (this.mParcelableException == null) {
                ExceptionInfo exceptionInfo = (ExceptionInfo) bundle.getParcelable(EXCEPTION_INFO);
                if (exceptionInfo != null) {
                    this.mParcelableException = g.create(exceptionInfo);
                } else {
                    return;
                }
            }
            this.mParcelableException.maybeRethrow(cls);
        }
    }

    public boolean isSuccessful() {
        return this.mCode == 1;
    }
}
