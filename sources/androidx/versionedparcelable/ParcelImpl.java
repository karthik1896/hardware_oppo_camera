package androidx.versionedparcelable;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;

@SuppressLint({"BanParcelableUsage"})
public class ParcelImpl implements Parcelable {
    public static final Parcelable.Creator<ParcelImpl> CREATOR = new Parcelable.Creator<ParcelImpl>() {
        /* renamed from: a */
        public ParcelImpl createFromParcel(Parcel parcel) {
            return new ParcelImpl(parcel);
        }

        /* renamed from: a */
        public ParcelImpl[] newArray(int i) {
            return new ParcelImpl[i];
        }
    };
    private final c mParcel;

    public int describeContents() {
        return 0;
    }

    public ParcelImpl(c cVar) {
        this.mParcel = cVar;
    }

    protected ParcelImpl(Parcel parcel) {
        this.mParcel = new b(parcel).j();
    }

    public <T extends c> T getVersionedParcel() {
        return this.mParcel;
    }

    public void writeToParcel(Parcel parcel, int i) {
        new b(parcel).a(this.mParcel);
    }
}
