package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.appcompat.R;
import androidx.appcompat.a.a.a;
import androidx.core.widget.e;

/* compiled from: AppCompatImageHelper */
public class m {

    /* renamed from: a  reason: collision with root package name */
    private final ImageView f452a;

    /* renamed from: b  reason: collision with root package name */
    private ap f453b;
    private ap c;
    private ap d;

    public m(ImageView imageView) {
        this.f452a = imageView;
    }

    public void a(AttributeSet attributeSet, int i) {
        int g;
        ar a2 = ar.a(this.f452a.getContext(), attributeSet, R.styleable.AppCompatImageView, i, 0);
        try {
            Drawable drawable = this.f452a.getDrawable();
            if (!(drawable != null || (g = a2.g(R.styleable.AppCompatImageView_srcCompat, -1)) == -1 || (drawable = a.b(this.f452a.getContext(), g)) == null)) {
                this.f452a.setImageDrawable(drawable);
            }
            if (drawable != null) {
                aa.b(drawable);
            }
            if (a2.g(R.styleable.AppCompatImageView_tint)) {
                e.a(this.f452a, a2.e(R.styleable.AppCompatImageView_tint));
            }
            if (a2.g(R.styleable.AppCompatImageView_tintMode)) {
                e.a(this.f452a, aa.a(a2.a(R.styleable.AppCompatImageView_tintMode, -1), (PorterDuff.Mode) null));
            }
        } finally {
            a2.b();
        }
    }

    public void a(int i) {
        if (i != 0) {
            Drawable b2 = a.b(this.f452a.getContext(), i);
            if (b2 != null) {
                aa.b(b2);
            }
            this.f452a.setImageDrawable(b2);
        } else {
            this.f452a.setImageDrawable((Drawable) null);
        }
        d();
    }

    /* access modifiers changed from: package-private */
    public boolean a() {
        return Build.VERSION.SDK_INT < 21 || !(this.f452a.getBackground() instanceof RippleDrawable);
    }

    /* access modifiers changed from: package-private */
    public void a(ColorStateList colorStateList) {
        if (this.c == null) {
            this.c = new ap();
        }
        ap apVar = this.c;
        apVar.f414a = colorStateList;
        apVar.d = true;
        d();
    }

    /* access modifiers changed from: package-private */
    public ColorStateList b() {
        ap apVar = this.c;
        if (apVar != null) {
            return apVar.f414a;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public void a(PorterDuff.Mode mode) {
        if (this.c == null) {
            this.c = new ap();
        }
        ap apVar = this.c;
        apVar.f415b = mode;
        apVar.c = true;
        d();
    }

    /* access modifiers changed from: package-private */
    public PorterDuff.Mode c() {
        ap apVar = this.c;
        if (apVar != null) {
            return apVar.f415b;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public void d() {
        Drawable drawable = this.f452a.getDrawable();
        if (drawable != null) {
            aa.b(drawable);
        }
        if (drawable == null) {
            return;
        }
        if (!e() || !a(drawable)) {
            ap apVar = this.c;
            if (apVar != null) {
                i.a(drawable, apVar, this.f452a.getDrawableState());
                return;
            }
            ap apVar2 = this.f453b;
            if (apVar2 != null) {
                i.a(drawable, apVar2, this.f452a.getDrawableState());
            }
        }
    }

    private boolean e() {
        int i = Build.VERSION.SDK_INT;
        if (i <= 21) {
            return i == 21;
        }
        if (this.f453b != null) {
            return true;
        }
        return false;
    }

    private boolean a(Drawable drawable) {
        if (this.d == null) {
            this.d = new ap();
        }
        ap apVar = this.d;
        apVar.a();
        ColorStateList a2 = e.a(this.f452a);
        if (a2 != null) {
            apVar.d = true;
            apVar.f414a = a2;
        }
        PorterDuff.Mode b2 = e.b(this.f452a);
        if (b2 != null) {
            apVar.c = true;
            apVar.f415b = b2;
        }
        if (!apVar.d && !apVar.c) {
            return false;
        }
        i.a(drawable, apVar, this.f452a.getDrawableState());
        return true;
    }
}
