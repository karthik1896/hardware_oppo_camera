package androidx.core.g;

import android.os.Build;
import android.view.WindowInsets;
import androidx.core.f.c;
import java.util.Objects;

/* compiled from: WindowInsetsCompat */
public class ad {

    /* renamed from: a  reason: collision with root package name */
    private final Object f695a;

    ad(Object obj) {
        this.f695a = obj;
    }

    public int a() {
        if (Build.VERSION.SDK_INT >= 20) {
            return ((WindowInsets) this.f695a).getSystemWindowInsetLeft();
        }
        return 0;
    }

    public int b() {
        if (Build.VERSION.SDK_INT >= 20) {
            return ((WindowInsets) this.f695a).getSystemWindowInsetTop();
        }
        return 0;
    }

    public int c() {
        if (Build.VERSION.SDK_INT >= 20) {
            return ((WindowInsets) this.f695a).getSystemWindowInsetRight();
        }
        return 0;
    }

    public int d() {
        if (Build.VERSION.SDK_INT >= 20) {
            return ((WindowInsets) this.f695a).getSystemWindowInsetBottom();
        }
        return 0;
    }

    public boolean e() {
        if (Build.VERSION.SDK_INT >= 20) {
            return ((WindowInsets) this.f695a).hasSystemWindowInsets();
        }
        return false;
    }

    public boolean f() {
        if (Build.VERSION.SDK_INT >= 21) {
            return ((WindowInsets) this.f695a).isConsumed();
        }
        return false;
    }

    public ad g() {
        if (Build.VERSION.SDK_INT >= 20) {
            return new ad(((WindowInsets) this.f695a).consumeSystemWindowInsets());
        }
        return null;
    }

    public ad a(int i, int i2, int i3, int i4) {
        if (Build.VERSION.SDK_INT >= 20) {
            return new ad(((WindowInsets) this.f695a).replaceSystemWindowInsets(i, i2, i3, i4));
        }
        return null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ad)) {
            return false;
        }
        return c.a(this.f695a, ((ad) obj).f695a);
    }

    public int hashCode() {
        Object obj = this.f695a;
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public WindowInsets h() {
        return (WindowInsets) this.f695a;
    }

    public static ad a(WindowInsets windowInsets) {
        return new ad(Objects.requireNonNull(windowInsets));
    }
}
