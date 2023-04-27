package androidx.transition;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Build;
import android.util.Property;
import android.view.View;
import androidx.core.g.v;

/* compiled from: ViewUtils */
class ad {

    /* renamed from: a  reason: collision with root package name */
    static final Property<View, Float> f1242a = new Property<View, Float>(Float.class, "translationAlpha") {
        /* renamed from: a */
        public Float get(View view) {
            return Float.valueOf(ad.c(view));
        }

        /* renamed from: a */
        public void set(View view, Float f) {
            ad.a(view, f.floatValue());
        }
    };

    /* renamed from: b  reason: collision with root package name */
    static final Property<View, Rect> f1243b = new Property<View, Rect>(Rect.class, "clipBounds") {
        /* renamed from: a */
        public Rect get(View view) {
            return v.C(view);
        }

        /* renamed from: a */
        public void set(View view, Rect rect) {
            v.a(view, rect);
        }
    };
    private static final aj c;

    static {
        if (Build.VERSION.SDK_INT >= 29) {
            c = new ai();
        } else if (Build.VERSION.SDK_INT >= 23) {
            c = new ah();
        } else if (Build.VERSION.SDK_INT >= 22) {
            c = new ag();
        } else if (Build.VERSION.SDK_INT >= 21) {
            c = new af();
        } else if (Build.VERSION.SDK_INT >= 19) {
            c = new ae();
        } else {
            c = new aj();
        }
    }

    static ac a(View view) {
        if (Build.VERSION.SDK_INT >= 18) {
            return new ab(view);
        }
        return aa.d(view);
    }

    static an b(View view) {
        if (Build.VERSION.SDK_INT >= 18) {
            return new am(view);
        }
        return new al(view.getWindowToken());
    }

    static void a(View view, float f) {
        c.a(view, f);
    }

    static float c(View view) {
        return c.a(view);
    }

    static void d(View view) {
        c.b(view);
    }

    static void e(View view) {
        c.c(view);
    }

    static void a(View view, int i) {
        c.a(view, i);
    }

    static void a(View view, Matrix matrix) {
        c.a(view, matrix);
    }

    static void b(View view, Matrix matrix) {
        c.b(view, matrix);
    }

    static void a(View view, int i, int i2, int i3, int i4) {
        c.a(view, i, i2, i3, i4);
    }
}
