package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;

/* compiled from: WrappedDrawableState */
final class f extends Drawable.ConstantState {

    /* renamed from: a  reason: collision with root package name */
    int f736a;

    /* renamed from: b  reason: collision with root package name */
    Drawable.ConstantState f737b;
    ColorStateList c = null;
    PorterDuff.Mode d = d.f734a;

    f(f fVar) {
        if (fVar != null) {
            this.f736a = fVar.f736a;
            this.f737b = fVar.f737b;
            this.c = fVar.c;
            this.d = fVar.d;
        }
    }

    public Drawable newDrawable() {
        return newDrawable((Resources) null);
    }

    public Drawable newDrawable(Resources resources) {
        if (Build.VERSION.SDK_INT >= 21) {
            return new e(this, resources);
        }
        return new d(this, resources);
    }

    public int getChangingConfigurations() {
        int i = this.f736a;
        Drawable.ConstantState constantState = this.f737b;
        return i | (constantState != null ? constantState.getChangingConfigurations() : 0);
    }

    /* access modifiers changed from: package-private */
    public boolean a() {
        return this.f737b != null;
    }
}
