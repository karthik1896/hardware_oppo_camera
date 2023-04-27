package androidx.transition;

import android.annotation.SuppressLint;
import android.view.View;

/* compiled from: ViewUtilsApi19 */
class ae extends aj {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f1244a = true;

    public void b(View view) {
    }

    public void c(View view) {
    }

    ae() {
    }

    @SuppressLint({"NewApi"})
    public void a(View view, float f) {
        if (f1244a) {
            try {
                view.setTransitionAlpha(f);
                return;
            } catch (NoSuchMethodError unused) {
                f1244a = false;
            }
        }
        view.setAlpha(f);
    }

    @SuppressLint({"NewApi"})
    public float a(View view) {
        if (f1244a) {
            try {
                return view.getTransitionAlpha();
            } catch (NoSuchMethodError unused) {
                f1244a = false;
            }
        }
        return view.getAlpha();
    }
}
