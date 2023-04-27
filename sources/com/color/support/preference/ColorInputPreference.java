package com.color.support.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.preference.Preference;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.EditText;
import androidx.preference.l;
import color.support.v7.appcompat.R;
import com.color.support.view.a;
import com.color.support.widget.ColorEditText;

public class ColorInputPreference extends ColorPreference {

    /* renamed from: a  reason: collision with root package name */
    private ColorEditText f1935a;

    /* renamed from: b  reason: collision with root package name */
    private CharSequence f1936b;
    private CharSequence c;
    private Context d;
    private View e;
    private boolean f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;

    public ColorInputPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.colorInputPreferenceStyle);
    }

    public ColorInputPreference(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, 0);
    }

    public ColorInputPreference(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2);
        this.d = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ColorInputPreference, i2, 0);
        this.f1936b = obtainStyledAttributes.getText(R.styleable.ColorInputPreference_colorContent);
        this.c = obtainStyledAttributes.getText(R.styleable.ColorInputPreference_colorHint);
        obtainStyledAttributes.recycle();
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, R.styleable.Preference, i2, 0);
        this.f = obtainStyledAttributes2.getText(R.styleable.Preference_android_title) != null;
        obtainStyledAttributes2.recycle();
        this.g = context.getResources().getDimensionPixelSize(R.dimen.color_input_edit_text_has_title_padding_top);
        this.h = context.getResources().getDimensionPixelSize(R.dimen.color_input_edit_text_has_title_padding_bottom);
        this.i = context.getResources().getDimensionPixelSize(R.dimen.color_input_edit_text_no_title_padding_top);
        this.j = context.getResources().getDimensionPixelOffset(R.dimen.color_input_edit_text_no_title_padding_bottom);
        this.k = context.getResources().getDimensionPixelOffset(R.dimen.color_input_preference_padding_end);
        this.f1935a = new a(context, attributeSet);
        this.f1935a.setId(16908297);
        this.f1935a.setBackgroundResource(0);
        this.f1935a.setMaxLines(5);
        this.f1935a.setFastDeletable(true);
        this.f1935a.setVerticalScrollBarEnabled(false);
        this.f1935a.setLineSpacing(0.0f, 1.1f);
        this.f1935a.setGravity(8388627);
        this.f1935a.setTextSize(0, (float) this.d.getResources().getDimensionPixelSize(R.dimen.color_input_preference_text_size));
        if (this.f) {
            this.f1935a.setTextColor(this.d.getResources().getColorStateList(R.color.color_input_preference_text_color));
            this.f1935a.setPaddingRelative(0, this.g, this.k, this.h);
            return;
        }
        this.f1935a.setPaddingRelative(0, this.i, this.k, this.j);
    }

    public void c(CharSequence charSequence) {
        ColorEditText colorEditText = this.f1935a;
        if (colorEditText != null) {
            colorEditText.setText(charSequence);
            this.f1936b = charSequence;
            return;
        }
        if (!TextUtils.equals(this.f1936b, charSequence)) {
            i();
        }
        boolean j2 = j();
        this.f1936b = charSequence;
        if (charSequence != null) {
            d(charSequence.toString());
        }
        boolean j3 = j();
        if (j3 != j2) {
            b(j3);
        }
    }

    public CharSequence b() {
        return this.c;
    }

    /* access modifiers changed from: protected */
    public Object a(TypedArray typedArray, int i2) {
        return typedArray.getString(i2);
    }

    /* access modifiers changed from: protected */
    public void a(boolean z, Object obj) {
        if (!TextUtils.isEmpty(this.f1936b)) {
            c(z ? e(this.f1936b.toString()) : (String) obj);
        }
    }

    public boolean j() {
        return TextUtils.isEmpty(this.f1936b) || super.j();
    }

    public void a(l lVar) {
        super.a(lVar);
        this.e = lVar.a(R.id.color_preference);
        ViewGroup viewGroup = (ViewGroup) this.e.findViewById(R.id.edittext_container);
        if (viewGroup != null) {
            if (!this.f1935a.equals((EditText) viewGroup.findViewById(16908297))) {
                ViewParent parent = this.f1935a.getParent();
                if (parent != null) {
                    ((ViewGroup) parent).removeView(this.f1935a);
                }
                viewGroup.removeAllViews();
                viewGroup.addView(this.f1935a, -1, -2);
            }
        }
        CharSequence b2 = b();
        if (!TextUtils.isEmpty(b2)) {
            this.f1935a.setHint(b2);
        }
        this.f1935a.setEnabled(y());
    }

    /* access modifiers changed from: protected */
    public Parcelable k() {
        Parcelable k2 = super.k();
        if (D()) {
            return k2;
        }
        SavedState savedState = new SavedState(k2);
        CharSequence charSequence = this.f1936b;
        if (charSequence != null) {
            savedState.mText = charSequence.toString();
        }
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
        c(savedState.mText);
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

        public SavedState(Parcel parcel) {
            super(parcel);
            this.mText = parcel.readString();
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.mText);
        }
    }
}
