package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.core.content.a.g;

public abstract class DialogPreference extends Preference {

    /* renamed from: a  reason: collision with root package name */
    private CharSequence f964a;

    /* renamed from: b  reason: collision with root package name */
    private CharSequence f965b;
    private Drawable c;
    private CharSequence d;
    private CharSequence e;
    private int f;

    public interface a {
        <T extends Preference> T a(CharSequence charSequence);
    }

    public DialogPreference(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.DialogPreference, i, i2);
        this.f964a = g.b(obtainStyledAttributes, R.styleable.DialogPreference_dialogTitle, R.styleable.DialogPreference_android_dialogTitle);
        if (this.f964a == null) {
            this.f964a = x();
        }
        this.f965b = g.b(obtainStyledAttributes, R.styleable.DialogPreference_dialogMessage, R.styleable.DialogPreference_android_dialogMessage);
        this.c = g.a(obtainStyledAttributes, R.styleable.DialogPreference_dialogIcon, R.styleable.DialogPreference_android_dialogIcon);
        this.d = g.b(obtainStyledAttributes, R.styleable.DialogPreference_positiveButtonText, R.styleable.DialogPreference_android_positiveButtonText);
        this.e = g.b(obtainStyledAttributes, R.styleable.DialogPreference_negativeButtonText, R.styleable.DialogPreference_android_negativeButtonText);
        this.f = g.b(obtainStyledAttributes, R.styleable.DialogPreference_dialogLayout, R.styleable.DialogPreference_android_dialogLayout, 0);
        obtainStyledAttributes.recycle();
    }

    public DialogPreference(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public DialogPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, g.a(context, R.attr.dialogPreferenceStyle, 16842897));
    }

    public DialogPreference(Context context) {
        this(context, (AttributeSet) null);
    }

    public CharSequence a() {
        return this.f964a;
    }

    public CharSequence b() {
        return this.f965b;
    }

    public Drawable c() {
        return this.c;
    }

    public CharSequence d() {
        return this.d;
    }

    public CharSequence e() {
        return this.e;
    }

    public int f() {
        return this.f;
    }

    /* access modifiers changed from: protected */
    public void g() {
        M().a((Preference) this);
    }
}
