package androidx.fragment.app;

import androidx.lifecycle.e;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

/* compiled from: FragmentTransaction */
public abstract class k {
    ArrayList<a> d = new ArrayList<>();
    int e;
    int f;
    int g;
    int h;
    int i;
    int j;
    boolean k;
    boolean l = true;
    String m;
    int n;
    CharSequence o;
    int p;
    CharSequence q;
    ArrayList<String> r;
    ArrayList<String> s;
    boolean t = false;
    ArrayList<Runnable> u;

    public abstract int b();

    public abstract int c();

    public abstract void d();

    /* compiled from: FragmentTransaction */
    static final class a {

        /* renamed from: a  reason: collision with root package name */
        int f873a;

        /* renamed from: b  reason: collision with root package name */
        Fragment f874b;
        int c;
        int d;
        int e;
        int f;
        e.b g;
        e.b h;

        a() {
        }

        a(int i, Fragment fragment) {
            this.f873a = i;
            this.f874b = fragment;
            this.g = e.b.RESUMED;
            this.h = e.b.RESUMED;
        }

        a(int i, Fragment fragment, e.b bVar) {
            this.f873a = i;
            this.f874b = fragment;
            this.g = fragment.mMaxState;
            this.h = bVar;
        }
    }

    /* access modifiers changed from: package-private */
    public void a(a aVar) {
        this.d.add(aVar);
        aVar.c = this.e;
        aVar.d = this.f;
        aVar.e = this.g;
        aVar.f = this.h;
    }

    public k a(Fragment fragment, String str) {
        a(0, fragment, str, 1);
        return this;
    }

    public k a(int i2, Fragment fragment, String str) {
        a(i2, fragment, str, 1);
        return this;
    }

    /* access modifiers changed from: package-private */
    public void a(int i2, Fragment fragment, String str, int i3) {
        Class<?> cls = fragment.getClass();
        int modifiers = cls.getModifiers();
        if (cls.isAnonymousClass() || !Modifier.isPublic(modifiers) || (cls.isMemberClass() && !Modifier.isStatic(modifiers))) {
            throw new IllegalStateException("Fragment " + cls.getCanonicalName() + " must be a public static class to be  properly recreated from instance state.");
        }
        if (str != null) {
            if (fragment.mTag == null || str.equals(fragment.mTag)) {
                fragment.mTag = str;
            } else {
                throw new IllegalStateException("Can't change tag of fragment " + fragment + ": was " + fragment.mTag + " now " + str);
            }
        }
        if (i2 != 0) {
            if (i2 == -1) {
                throw new IllegalArgumentException("Can't add fragment " + fragment + " with tag " + str + " to container view with no id");
            } else if (fragment.mFragmentId == 0 || fragment.mFragmentId == i2) {
                fragment.mFragmentId = i2;
                fragment.mContainerId = i2;
            } else {
                throw new IllegalStateException("Can't change container ID of fragment " + fragment + ": was " + fragment.mFragmentId + " now " + i2);
            }
        }
        a(new a(i3, fragment));
    }

    public k a(int i2, Fragment fragment) {
        return b(i2, fragment, (String) null);
    }

    public k b(int i2, Fragment fragment, String str) {
        if (i2 != 0) {
            a(i2, fragment, str, 2);
            return this;
        }
        throw new IllegalArgumentException("Must use non-zero containerViewId");
    }

    public k a(Fragment fragment) {
        a(new a(3, fragment));
        return this;
    }

    public k b(Fragment fragment) {
        a(new a(6, fragment));
        return this;
    }

    public k c(Fragment fragment) {
        a(new a(7, fragment));
        return this;
    }

    public k a(Fragment fragment, e.b bVar) {
        a(new a(10, fragment, bVar));
        return this;
    }

    public boolean h() {
        return this.d.isEmpty();
    }

    public k a(String str) {
        if (this.l) {
            this.k = true;
            this.m = str;
            return this;
        }
        throw new IllegalStateException("This FragmentTransaction is not allowed to be added to the back stack.");
    }

    public k i() {
        if (!this.k) {
            this.l = false;
            return this;
        }
        throw new IllegalStateException("This transaction is already being added to the back stack");
    }
}
