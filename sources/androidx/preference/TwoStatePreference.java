package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import androidx.preference.Preference;

public abstract class TwoStatePreference extends Preference {

    /* renamed from: a  reason: collision with root package name */
    protected boolean f994a;

    /* renamed from: b  reason: collision with root package name */
    private CharSequence f995b;
    private CharSequence c;
    private boolean d;
    private boolean e;

    public TwoStatePreference(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    public TwoStatePreference(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public TwoStatePreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TwoStatePreference(Context context) {
        this(context, (AttributeSet) null);
    }

    /* access modifiers changed from: protected */
    public void g() {
        super.g();
        boolean z = !b();
        if (b((Object) Boolean.valueOf(z))) {
            e(z);
        }
    }

    public boolean b() {
        return this.f994a;
    }

    public void e(boolean z) {
        boolean z2 = this.f994a != z;
        if (z2 || !this.d) {
            this.f994a = z;
            this.d = true;
            c(z);
            if (z2) {
                b(j());
                i();
            }
        }
    }

    public boolean j() {
        if ((this.e ? this.f994a : !this.f994a) || super.j()) {
            return true;
        }
        return false;
    }

    public void e(CharSequence charSequence) {
        this.f995b = charSequence;
        if (b()) {
            i();
        }
    }

    public void f(CharSequence charSequence) {
        this.c = charSequence;
        if (!b()) {
            i();
        }
    }

    public void f(boolean z) {
        this.e = z;
    }

    /* access modifiers changed from: protected */
    public Object a(TypedArray typedArray, int i) {
        return Boolean.valueOf(typedArray.getBoolean(i, false));
    }

    /* access modifiers changed from: protected */
    public void a(Object obj) {
        if (obj == null) {
            obj = false;
        }
        e(d(((Boolean) obj).booleanValue()));
    }

    /* access modifiers changed from: protected */
    public void b(l lVar) {
        b(lVar.a(16908304));
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0030  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0042  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b(android.view.View r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof android.widget.TextView
            if (r0 != 0) goto L_0x0005
            return
        L_0x0005:
            android.widget.TextView r5 = (android.widget.TextView) r5
            r0 = 1
            boolean r1 = r4.f994a
            r2 = 0
            if (r1 == 0) goto L_0x001c
            java.lang.CharSequence r1 = r4.f995b
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x001c
            java.lang.CharSequence r0 = r4.f995b
            r5.setText(r0)
        L_0x001a:
            r0 = r2
            goto L_0x002e
        L_0x001c:
            boolean r1 = r4.f994a
            if (r1 != 0) goto L_0x002e
            java.lang.CharSequence r1 = r4.c
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x002e
            java.lang.CharSequence r0 = r4.c
            r5.setText(r0)
            goto L_0x001a
        L_0x002e:
            if (r0 == 0) goto L_0x003e
            java.lang.CharSequence r1 = r4.n()
            boolean r3 = android.text.TextUtils.isEmpty(r1)
            if (r3 != 0) goto L_0x003e
            r5.setText(r1)
            r0 = r2
        L_0x003e:
            r1 = 8
            if (r0 != 0) goto L_0x0043
            r1 = r2
        L_0x0043:
            int r0 = r5.getVisibility()
            if (r1 == r0) goto L_0x004c
            r5.setVisibility(r1)
        L_0x004c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.preference.TwoStatePreference.b(android.view.View):void");
    }

    /* access modifiers changed from: protected */
    public Parcelable k() {
        Parcelable k = super.k();
        if (D()) {
            return k;
        }
        SavedState savedState = new SavedState(k);
        savedState.mChecked = b();
        return savedState;
    }

    /* access modifiers changed from: protected */
    public void a(Parcelable parcelable) {
        if (parcelable == null || !parcelable.getClass().equals(SavedState.class)) {
            super.a(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.a(savedState.getSuperState());
        e(savedState.mChecked);
    }

    static class SavedState extends Preference.BaseSavedState {
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
        boolean mChecked;

        SavedState(Parcel parcel) {
            super(parcel);
            this.mChecked = parcel.readInt() != 1 ? false : true;
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.mChecked ? 1 : 0);
        }
    }
}
