package androidx.versionedparcelable;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.SparseIntArray;
import androidx.collection.ArrayMap;
import java.lang.reflect.Method;

/* compiled from: VersionedParcelParcel */
class b extends a {
    private final SparseIntArray d;
    private final Parcel e;
    private final int f;
    private final int g;
    private final String h;
    private int i;
    private int j;
    private int k;

    b(Parcel parcel) {
        this(parcel, parcel.dataPosition(), parcel.dataSize(), "", new ArrayMap(), new ArrayMap(), new ArrayMap());
    }

    private b(Parcel parcel, int i2, int i3, String str, ArrayMap<String, Method> arrayMap, ArrayMap<String, Method> arrayMap2, ArrayMap<String, Class> arrayMap3) {
        super(arrayMap, arrayMap2, arrayMap3);
        this.d = new SparseIntArray();
        this.i = -1;
        this.j = 0;
        this.k = -1;
        this.e = parcel;
        this.f = i2;
        this.g = i3;
        this.j = this.f;
        this.h = str;
    }

    public boolean b(int i2) {
        while (this.j < this.g) {
            int i3 = this.k;
            if (i3 == i2) {
                return true;
            }
            if (String.valueOf(i3).compareTo(String.valueOf(i2)) > 0) {
                return false;
            }
            this.e.setDataPosition(this.j);
            int readInt = this.e.readInt();
            this.k = this.e.readInt();
            this.j += readInt;
        }
        if (this.k == i2) {
            return true;
        }
        return false;
    }

    public void c(int i2) {
        b();
        this.i = i2;
        this.d.put(i2, this.e.dataPosition());
        a(0);
        a(i2);
    }

    public void b() {
        int i2 = this.i;
        if (i2 >= 0) {
            int i3 = this.d.get(i2);
            int dataPosition = this.e.dataPosition();
            this.e.setDataPosition(i3);
            this.e.writeInt(dataPosition - i3);
            this.e.setDataPosition(dataPosition);
        }
    }

    /* access modifiers changed from: protected */
    public a c() {
        Parcel parcel = this.e;
        int dataPosition = parcel.dataPosition();
        int i2 = this.j;
        if (i2 == this.f) {
            i2 = this.g;
        }
        int i3 = i2;
        return new b(parcel, dataPosition, i3, this.h + "  ", this.f1342a, this.f1343b, this.c);
    }

    public void a(byte[] bArr) {
        if (bArr != null) {
            this.e.writeInt(bArr.length);
            this.e.writeByteArray(bArr);
            return;
        }
        this.e.writeInt(-1);
    }

    public void a(int i2) {
        this.e.writeInt(i2);
    }

    public void a(String str) {
        this.e.writeString(str);
    }

    public void a(Parcelable parcelable) {
        this.e.writeParcelable(parcelable, 0);
    }

    public void a(boolean z) {
        this.e.writeInt(z ? 1 : 0);
    }

    /* access modifiers changed from: protected */
    public void a(CharSequence charSequence) {
        TextUtils.writeToParcel(charSequence, this.e, 0);
    }

    /* access modifiers changed from: protected */
    public CharSequence g() {
        return (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(this.e);
    }

    public int d() {
        return this.e.readInt();
    }

    public String e() {
        return this.e.readString();
    }

    public byte[] f() {
        int readInt = this.e.readInt();
        if (readInt < 0) {
            return null;
        }
        byte[] bArr = new byte[readInt];
        this.e.readByteArray(bArr);
        return bArr;
    }

    public <T extends Parcelable> T h() {
        return this.e.readParcelable(getClass().getClassLoader());
    }

    public boolean i() {
        return this.e.readInt() != 0;
    }
}
