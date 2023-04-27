package androidx.transition;

import android.annotation.SuppressLint;
import android.os.Build;
import android.view.View;

/* compiled from: ViewUtilsApi23 */
class ah extends ag {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f1248a = true;

    ah() {
    }

    @SuppressLint({"NewApi"})
    public void a(View view, int i) {
        if (Build.VERSION.SDK_INT == 28) {
            super.a(view, i);
        } else if (f1248a) {
            try {
                view.setTransitionVisibility(i);
            } catch (NoSuchMethodError unused) {
                f1248a = false;
            }
        }
    }
}
