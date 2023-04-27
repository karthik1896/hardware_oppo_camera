package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.R;
import androidx.core.g.v;

/* compiled from: AppCompatBackgroundHelper */
class e {

    /* renamed from: a  reason: collision with root package name */
    private final View f442a;

    /* renamed from: b  reason: collision with root package name */
    private final i f443b;
    private int c = -1;
    private ap d;
    private ap e;
    private ap f;

    e(View view) {
        this.f442a = view;
        this.f443b = i.b();
    }

    /* access modifiers changed from: package-private */
    public void a(AttributeSet attributeSet, int i) {
        ar a2 = ar.a(this.f442a.getContext(), attributeSet, R.styleable.ViewBackgroundHelper, i, 0);
        try {
            if (a2.g(R.styleable.ViewBackgroundHelper_android_background)) {
                this.c = a2.g(R.styleable.ViewBackgroundHelper_android_background, -1);
                ColorStateList b2 = this.f443b.b(this.f442a.getContext(), this.c);
                if (b2 != null) {
                    b(b2);
                }
            }
            if (a2.g(R.styleable.ViewBackgroundHelper_backgroundTint)) {
                v.a(this.f442a, a2.e(R.styleable.ViewBackgroundHelper_backgroundTint));
            }
            if (a2.g(R.styleable.ViewBackgroundHelper_backgroundTintMode)) {
                v.a(this.f442a, aa.a(a2.a(R.styleable.ViewBackgroundHelper_backgroundTintMode, -1), (PorterDuff.Mode) null));
            }
        } finally {
            a2.b();
        }
    }

    /* access modifiers changed from: package-private */
    public void a(int i) {
        this.c = i;
        i iVar = this.f443b;
        b(iVar != null ? iVar.b(this.f442a.getContext(), i) : null);
        c();
    }

    /* access modifiers changed from: package-private */
    public void a(Drawable drawable) {
        this.c = -1;
        b((ColorStateList) null);
        c();
    }

    /* access modifiers changed from: package-private */
    public void a(ColorStateList colorStateList) {
        if (this.e == null) {
            this.e = new ap();
        }
        ap apVar = this.e;
        apVar.f414a = colorStateList;
        apVar.d = true;
        c();
    }

    /* access modifiers changed from: package-private */
    public ColorStateList a() {
        ap apVar = this.e;
        if (apVar != null) {
            return apVar.f414a;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public void a(PorterDuff.Mode mode) {
        if (this.e == null) {
            this.e = new ap();
        }
        ap apVar = this.e;
        apVar.f415b = mode;
        apVar.c = true;
        c();
    }

    /* access modifiers changed from: package-private */
    public PorterDuff.Mode b() {
        ap apVar = this.e;
        if (apVar != null) {
            return apVar.f415b;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public void c() {
        Drawable background = this.f442a.getBackground();
        if (background == null) {
            return;
        }
        if (!d() || !b(background)) {
            ap apVar = this.e;
            if (apVar != null) {
                i.a(background, apVar, this.f442a.getDrawableState());
                return;
            }
            ap apVar2 = this.d;
            if (apVar2 != null) {
                i.a(background, apVar2, this.f442a.getDrawableState());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void b(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (this.d == null) {
                this.d = new ap();
            }
            ap apVar = this.d;
            apVar.f414a = colorStateList;
            apVar.d = true;
        } else {
            this.d = null;
        }
        c();
    }

    private boolean d() {
        int i = Build.VERSION.SDK_INT;
        if (i <= 21) {
            return i == 21;
        }
        if (this.d != null) {
            return true;
        }
        return false;
    }

    private boolean b(Drawable drawable) {
        if (this.f == null) {
            this.f = new ap();
        }
        ap apVar = this.f;
        apVar.a();
        ColorStateList w = v.w(this.f442a);
        if (w != null) {
            apVar.d = true;
            apVar.f414a = w;
        }
        PorterDuff.Mode x = v.x(this.f442a);
        if (x != null) {
            apVar.c = true;
            apVar.f415b = x;
        }
        if (!apVar.d && !apVar.c) {
            return false;
        }
        i.a(drawable, apVar, this.f442a.getDrawableState());
        return true;
    }
}
