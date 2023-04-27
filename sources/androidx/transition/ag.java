package androidx.transition;

import android.annotation.SuppressLint;
import android.view.View;

/* compiled from: ViewUtilsApi22 */
class ag extends af {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f1247a = true;

    ag() {
    }

    @SuppressLint({"NewApi"})
    public void a(View view, int i, int i2, int i3, int i4) {
        if (f1247a) {
            try {
                view.setLeftTopRightBottom(i, i2, i3, i4);
            } catch (NoSuchMethodError unused) {
                f1247a = false;
            }
        }
    }
}
