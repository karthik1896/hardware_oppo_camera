package androidx.transition;

import android.annotation.SuppressLint;
import android.os.Build;
import android.view.ViewGroup;

/* compiled from: ViewGroupUtils */
class y {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f1316a = true;

    static x a(ViewGroup viewGroup) {
        if (Build.VERSION.SDK_INT >= 18) {
            return new w(viewGroup);
        }
        return v.a(viewGroup);
    }

    static void a(ViewGroup viewGroup, boolean z) {
        if (Build.VERSION.SDK_INT >= 29) {
            viewGroup.suppressLayout(z);
        } else if (Build.VERSION.SDK_INT >= 18) {
            b(viewGroup, z);
        } else {
            z.a(viewGroup, z);
        }
    }

    @SuppressLint({"NewApi"})
    private static void b(ViewGroup viewGroup, boolean z) {
        if (f1316a) {
            try {
                viewGroup.suppressLayout(z);
            } catch (NoSuchMethodError unused) {
                f1316a = false;
            }
        }
    }
}
