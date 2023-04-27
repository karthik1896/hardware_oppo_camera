package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.EditText;
import androidx.core.content.a.g;
import androidx.preference.Preference;

public class EditTextPreference extends DialogPreference {

    /* renamed from: a  reason: collision with root package name */
    private String f969a;

    /* renamed from: b  reason: collision with root package name */
    private a f970b;

    public interface a {
        void a(EditText editText);
    }

    public EditTextPreference(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.EditTextPreference, i, i2);
        if (g.a(obtainStyledAttributes, R.styleable.EditTextPreference_useSimpleSummaryProvider, R.styleable.EditTextPreference_useSimpleSummaryProvider, false)) {
            a((Preference.e) b.a());
        }
        obtainStyledAttributes.recycle();
    }

    public EditTextPreference(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public EditTextPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, g.a(context, R.attr.editTextPreferenceStyle, 16842898));
    }

    public void a(String str) {
        boolean j = j();
        this.f969a = str;
        d(str);
        boolean j2 = j();
        if (j2 != j) {
            b(j2);
        }
        i();
    }

    public String h() {
        return this.f969a;
    }

    /* access modifiers changed from: protected */
    public Object a(TypedArray typedArray, int i) {
        return typedArray.getString(i);
    }

    /* access modifiers changed from: protected */
    public void a(Object obj) {
        a(e((String) obj));
    }

    public boolean j() {
        return TextUtils.isEmpty(this.f969a) || super.j();
    }

    /* access modifiers changed from: protected */
    public Parcelable k() {
        Parcelable k = super.k();
        if (D()) {
            return k;
        }
        SavedState savedState = new SavedState(k);
        savedState.mText = h();
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
        a(savedState.mText);
    }

    /* access modifiers changed from: package-private */
    public a l() {
        return this.f970b;
    }

    private static class SavedState extends Preference.BaseSavedState {
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
        String mText;

        SavedState(Parcel parcel) {
            super(parcel);
            this.mText = parcel.readString();
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.mText);
        }
    }

    public static final class b implements Preference.e<EditTextPreference> {

        /* renamed from: a  reason: collision with root package name */
        private static b f971a;

        private b() {
        }

        public static b a() {
            if (f971a == null) {
                f971a = new b();
            }
            return f971a;
        }

        public CharSequence a(EditTextPreference editTextPreference) {
            if (TextUtils.isEmpty(editTextPreference.h())) {
                return editTextPreference.J().getString(R.string.not_set);
            }
            return editTextPreference.h();
        }
    }
}
