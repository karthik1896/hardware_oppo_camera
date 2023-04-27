package color.support.a.a;

import android.os.Build;
import android.view.ViewTreeObserver;

/* compiled from: ColorViewTreeObserverCompat */
public class b {

    /* renamed from: a  reason: collision with root package name */
    static final c f1436a;

    /* compiled from: ColorViewTreeObserverCompat */
    interface c {
        void a(ViewTreeObserver viewTreeObserver, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener);
    }

    /* compiled from: ColorViewTreeObserverCompat */
    static class a implements c {
        a() {
        }

        public void a(ViewTreeObserver viewTreeObserver, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
            viewTreeObserver.removeGlobalOnLayoutListener(onGlobalLayoutListener);
        }
    }

    /* renamed from: color.support.a.a.b$b  reason: collision with other inner class name */
    /* compiled from: ColorViewTreeObserverCompat */
    static class C0044b extends a {
        C0044b() {
        }

        public void a(ViewTreeObserver viewTreeObserver, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
            viewTreeObserver.removeOnGlobalLayoutListener(onGlobalLayoutListener);
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 16) {
            f1436a = new C0044b();
        } else {
            f1436a = new a();
        }
    }

    public static void a(ViewTreeObserver viewTreeObserver, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        f1436a.a(viewTreeObserver, onGlobalLayoutListener);
    }
}
