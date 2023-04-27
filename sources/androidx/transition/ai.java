package androidx.transition;

import android.graphics.Matrix;
import android.view.View;

/* compiled from: ViewUtilsApi29 */
class ai extends ah {
    ai() {
    }

    public void a(View view, float f) {
        view.setTransitionAlpha(f);
    }

    public float a(View view) {
        return view.getTransitionAlpha();
    }

    public void a(View view, int i) {
        view.setTransitionVisibility(i);
    }

    public void a(View view, int i, int i2, int i3, int i4) {
        view.setLeftTopRightBottom(i, i2, i3, i4);
    }

    public void a(View view, Matrix matrix) {
        view.transformMatrixToGlobal(matrix);
    }

    public void b(View view, Matrix matrix) {
        view.transformMatrixToLocal(matrix);
    }
}
