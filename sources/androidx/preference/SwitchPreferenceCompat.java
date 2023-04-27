package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.Checkable;
import android.widget.CompoundButton;
import androidx.appcompat.widget.SwitchCompat;
import androidx.core.content.a.g;

public class SwitchPreferenceCompat extends TwoStatePreference {

    /* renamed from: b  reason: collision with root package name */
    private final a f992b;
    private CharSequence c;
    private CharSequence d;

    public SwitchPreferenceCompat(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.f992b = new a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SwitchPreferenceCompat, i, i2);
        e((CharSequence) g.b(obtainStyledAttributes, R.styleable.SwitchPreferenceCompat_summaryOn, R.styleable.SwitchPreferenceCompat_android_summaryOn));
        f((CharSequence) g.b(obtainStyledAttributes, R.styleable.SwitchPreferenceCompat_summaryOff, R.styleable.SwitchPreferenceCompat_android_summaryOff));
        c((CharSequence) g.b(obtainStyledAttributes, R.styleable.SwitchPreferenceCompat_switchTextOn, R.styleable.SwitchPreferenceCompat_android_switchTextOn));
        d((CharSequence) g.b(obtainStyledAttributes, R.styleable.SwitchPreferenceCompat_switchTextOff, R.styleable.SwitchPreferenceCompat_android_switchTextOff));
        f(g.a(obtainStyledAttributes, R.styleable.SwitchPreferenceCompat_disableDependentsState, R.styleable.SwitchPreferenceCompat_android_disableDependentsState, false));
        obtainStyledAttributes.recycle();
    }

    public SwitchPreferenceCompat(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public SwitchPreferenceCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.switchPreferenceCompatStyle);
    }

    public void a(l lVar) {
        super.a(lVar);
        d(lVar.a(R.id.switchWidget));
        b(lVar);
    }

    public void c(CharSequence charSequence) {
        this.c = charSequence;
        i();
    }

    public void d(CharSequence charSequence) {
        this.d = charSequence;
        i();
    }

    /* access modifiers changed from: protected */
    public void a(View view) {
        super.a(view);
        c(view);
    }

    private void c(View view) {
        if (((AccessibilityManager) J().getSystemService("accessibility")).isEnabled()) {
            d(view.findViewById(R.id.switchWidget));
            b(view.findViewById(16908304));
        }
    }

    private void d(View view) {
        boolean z = view instanceof SwitchCompat;
        if (z) {
            ((SwitchCompat) view).setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) null);
        }
        if (view instanceof Checkable) {
            ((Checkable) view).setChecked(this.f994a);
        }
        if (z) {
            SwitchCompat switchCompat = (SwitchCompat) view;
            switchCompat.setTextOn(this.c);
            switchCompat.setTextOff(this.d);
            switchCompat.setOnCheckedChangeListener(this.f992b);
        }
    }

    private class a implements CompoundButton.OnCheckedChangeListener {
        a() {
        }

        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (!SwitchPreferenceCompat.this.b((Object) Boolean.valueOf(z))) {
                compoundButton.setChecked(!z);
            } else {
                SwitchPreferenceCompat.this.e(z);
            }
        }
    }
}
