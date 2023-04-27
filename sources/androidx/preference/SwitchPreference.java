package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.Checkable;
import android.widget.CompoundButton;
import android.widget.Switch;
import androidx.core.content.a.g;

public class SwitchPreference extends TwoStatePreference {

    /* renamed from: b  reason: collision with root package name */
    private final a f990b;
    private CharSequence c;
    private CharSequence d;

    public SwitchPreference(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.f990b = new a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SwitchPreference, i, i2);
        e((CharSequence) g.b(obtainStyledAttributes, R.styleable.SwitchPreference_summaryOn, R.styleable.SwitchPreference_android_summaryOn));
        f((CharSequence) g.b(obtainStyledAttributes, R.styleable.SwitchPreference_summaryOff, R.styleable.SwitchPreference_android_summaryOff));
        c((CharSequence) g.b(obtainStyledAttributes, R.styleable.SwitchPreference_switchTextOn, R.styleable.SwitchPreference_android_switchTextOn));
        d((CharSequence) g.b(obtainStyledAttributes, R.styleable.SwitchPreference_switchTextOff, R.styleable.SwitchPreference_android_switchTextOff));
        f(g.a(obtainStyledAttributes, R.styleable.SwitchPreference_disableDependentsState, R.styleable.SwitchPreference_android_disableDependentsState, false));
        obtainStyledAttributes.recycle();
    }

    public SwitchPreference(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public SwitchPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, g.a(context, R.attr.switchPreferenceStyle, 16843629));
    }

    public SwitchPreference(Context context) {
        this(context, (AttributeSet) null);
    }

    public void a(l lVar) {
        super.a(lVar);
        d(lVar.a(16908352));
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
            d(view.findViewById(16908352));
            b(view.findViewById(16908304));
        }
    }

    private void d(View view) {
        boolean z = view instanceof Switch;
        if (z) {
            ((Switch) view).setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) null);
        }
        if (view instanceof Checkable) {
            ((Checkable) view).setChecked(this.f994a);
        }
        if (z) {
            Switch switchR = (Switch) view;
            switchR.setTextOn(this.c);
            switchR.setTextOff(this.d);
            switchR.setOnCheckedChangeListener(this.f990b);
        }
    }

    private class a implements CompoundButton.OnCheckedChangeListener {
        a() {
        }

        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (!SwitchPreference.this.b((Object) Boolean.valueOf(z))) {
                compoundButton.setChecked(!z);
            } else {
                SwitchPreference.this.e(z);
            }
        }
    }
}
