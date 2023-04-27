package color.support.a.a;

import android.annotation.SuppressLint;
import android.os.Build;
import android.view.View;

/* compiled from: ColorViewCompat */
public class a {

    /* renamed from: a  reason: collision with root package name */
    static final d f1435a;

    /* compiled from: ColorViewCompat */
    interface d {
        int a(View view);

        void a(View view, int i);

        int b(View view);

        boolean c(View view);
    }

    /* renamed from: color.support.a.a.a$a  reason: collision with other inner class name */
    /* compiled from: ColorViewCompat */
    static class C0043a implements d {
        public int a(View view) {
            return 0;
        }

        public void a(View view, int i) {
        }

        public boolean c(View view) {
            return true;
        }

        C0043a() {
        }

        @SuppressLint({"NewApi"})
        public int b(View view) {
            return view.getLayoutDirection();
        }
    }

    /* compiled from: ColorViewCompat */
    static class b extends C0043a {
        public boolean c(View view) {
            return true;
        }

        b() {
        }

        @SuppressLint({"NewApi"})
        public int a(View view) {
            return view.getTextAlignment();
        }

        @SuppressLint({"NewApi"})
        public void a(View view, int i) {
            view.setTextAlignment(i);
        }
    }

    /* compiled from: ColorViewCompat */
    static class c extends b {
        public int b(View view) {
            return 2;
        }

        c() {
        }
    }

    static {
        int i = Build.VERSION.SDK_INT;
        if (i >= 17) {
            f1435a = new c();
        } else if (i >= 16) {
            f1435a = new b();
        } else {
            f1435a = new C0043a();
        }
    }

    public static int a(View view) {
        return f1435a.a(view);
    }

    public static void a(View view, int i) {
        f1435a.a(view, i);
    }

    public static int b(View view) {
        return f1435a.b(view);
    }

    public static boolean c(View view) {
        return f1435a.c(view);
    }
}
