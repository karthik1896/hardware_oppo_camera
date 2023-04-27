package androidx.appcompat.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.Toolbar;
import androidx.collection.ArraySet;
import java.lang.ref.WeakReference;
import java.util.Iterator;

/* compiled from: AppCompatDelegate */
public abstract class e {

    /* renamed from: a  reason: collision with root package name */
    private static int f174a = -100;

    /* renamed from: b  reason: collision with root package name */
    private static final ArraySet<WeakReference<e>> f175b = new ArraySet<>();
    private static final Object c = new Object();

    public abstract a a();

    public void a(int i) {
    }

    public void a(Context context) {
    }

    public abstract void a(Configuration configuration);

    public abstract void a(Bundle bundle);

    public abstract void a(View view);

    public abstract void a(View view, ViewGroup.LayoutParams layoutParams);

    public abstract void a(Toolbar toolbar);

    public abstract void a(CharSequence charSequence);

    public abstract MenuInflater b();

    public abstract <T extends View> T b(int i);

    public abstract void b(Bundle bundle);

    public abstract void b(View view, ViewGroup.LayoutParams layoutParams);

    public abstract void c();

    public abstract void c(int i);

    public abstract void c(Bundle bundle);

    public abstract void d();

    public abstract boolean d(int i);

    public abstract void e();

    public abstract void f();

    public abstract void g();

    public abstract void h();

    public int i() {
        return -100;
    }

    public static e a(Activity activity, d dVar) {
        return new AppCompatDelegateImpl(activity, dVar);
    }

    public static e a(Dialog dialog, d dVar) {
        return new AppCompatDelegateImpl(dialog, dVar);
    }

    e() {
    }

    public static int j() {
        return f174a;
    }

    static void a(e eVar) {
        synchronized (c) {
            c(eVar);
            f175b.add(new WeakReference(eVar));
        }
    }

    static void b(e eVar) {
        synchronized (c) {
            c(eVar);
        }
    }

    private static void c(e eVar) {
        synchronized (c) {
            Iterator<WeakReference<e>> it = f175b.iterator();
            while (it.hasNext()) {
                e eVar2 = (e) it.next().get();
                if (eVar2 == eVar || eVar2 == null) {
                    it.remove();
                }
            }
        }
    }
}
