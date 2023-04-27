package androidx.transition;

import android.annotation.SuppressLint;
import android.graphics.Matrix;
import android.view.View;

/* compiled from: ViewUtilsApi21 */
class af extends ae {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f1245a = true;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f1246b = true;
    private static boolean c = true;

    af() {
    }

    @SuppressLint({"NewApi"})
    public void a(View view, Matrix matrix) {
        if (f1246b) {
            try {
                view.transformMatrixToGlobal(matrix);
            } catch (NoSuchMethodError unused) {
                f1246b = false;
            }
        }
    }

    @SuppressLint({"NewApi"})
    public void b(View view, Matrix matrix) {
        if (c) {
            try {
                view.transformMatrixToLocal(matrix);
            } catch (NoSuchMethodError unused) {
                c = false;
            }
        }
    }
}
