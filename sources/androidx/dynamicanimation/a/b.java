package androidx.dynamicanimation.a;

import android.os.Looper;
import android.util.AndroidRuntimeException;
import android.view.View;
import androidx.core.g.v;
import androidx.dynamicanimation.a.a;
import androidx.dynamicanimation.a.b;
import java.util.ArrayList;

/* compiled from: DynamicAnimation */
public abstract class b<T extends b<T>> implements a.b {

    /* renamed from: a  reason: collision with root package name */
    public static final d f793a = new d("translationX") {
        public void a(View view, float f) {
            view.setTranslationX(f);
        }

        public float a(View view) {
            return view.getTranslationX();
        }
    };

    /* renamed from: b  reason: collision with root package name */
    public static final d f794b = new d("translationY") {
        public void a(View view, float f) {
            view.setTranslationY(f);
        }

        public float a(View view) {
            return view.getTranslationY();
        }
    };
    public static final d c = new d("translationZ") {
        public void a(View view, float f) {
            v.b(view, f);
        }

        public float a(View view) {
            return v.p(view);
        }
    };
    public static final d d = new d("scaleX") {
        public void a(View view, float f) {
            view.setScaleX(f);
        }

        public float a(View view) {
            return view.getScaleX();
        }
    };
    public static final d e = new d("scaleY") {
        public void a(View view, float f) {
            view.setScaleY(f);
        }

        public float a(View view) {
            return view.getScaleY();
        }
    };
    public static final d f = new d("rotation") {
        public void a(View view, float f) {
            view.setRotation(f);
        }

        public float a(View view) {
            return view.getRotation();
        }
    };
    public static final d g = new d("rotationX") {
        public void a(View view, float f) {
            view.setRotationX(f);
        }

        public float a(View view) {
            return view.getRotationX();
        }
    };
    public static final d h = new d("rotationY") {
        public void a(View view, float f) {
            view.setRotationY(f);
        }

        public float a(View view) {
            return view.getRotationY();
        }
    };
    public static final d i = new d("x") {
        public void a(View view, float f) {
            view.setX(f);
        }

        public float a(View view) {
            return view.getX();
        }
    };
    public static final d j = new d("y") {
        public void a(View view, float f) {
            view.setY(f);
        }

        public float a(View view) {
            return view.getY();
        }
    };
    public static final d k = new d("z") {
        public void a(View view, float f) {
            v.c(view, f);
        }

        public float a(View view) {
            return v.B(view);
        }
    };
    public static final d l = new d("alpha") {
        public void a(View view, float f) {
            view.setAlpha(f);
        }

        public float a(View view) {
            return view.getAlpha();
        }
    };
    public static final d m = new d("scrollX") {
        public void a(View view, float f) {
            view.setScrollX((int) f);
        }

        public float a(View view) {
            return (float) view.getScrollX();
        }
    };
    public static final d n = new d("scrollY") {
        public void a(View view, float f) {
            view.setScrollY((int) f);
        }

        public float a(View view) {
            return (float) view.getScrollY();
        }
    };
    float o;
    float p;
    boolean q;
    final Object r;
    final c s;
    boolean t;
    float u;
    float v;
    private long w;
    private float x;
    private final ArrayList<C0027b> y;
    private final ArrayList<c> z;

    /* renamed from: androidx.dynamicanimation.a.b$b  reason: collision with other inner class name */
    /* compiled from: DynamicAnimation */
    public interface C0027b {
        void a(b bVar, boolean z, float f, float f2);
    }

    /* compiled from: DynamicAnimation */
    public interface c {
        void a(b bVar, float f, float f2);
    }

    /* access modifiers changed from: package-private */
    public abstract boolean a(float f2, float f3);

    /* access modifiers changed from: package-private */
    public abstract boolean b(long j2);

    /* compiled from: DynamicAnimation */
    public static abstract class d extends c<View> {
        private d(String str) {
            super(str);
        }
    }

    /* compiled from: DynamicAnimation */
    static class a {

        /* renamed from: a  reason: collision with root package name */
        float f797a;

        /* renamed from: b  reason: collision with root package name */
        float f798b;

        a() {
        }
    }

    b(final d dVar) {
        this.o = 0.0f;
        this.p = Float.MAX_VALUE;
        this.q = false;
        this.t = false;
        this.u = Float.MAX_VALUE;
        this.v = -this.u;
        this.w = 0;
        this.y = new ArrayList<>();
        this.z = new ArrayList<>();
        this.r = null;
        this.s = new c("FloatValueHolder") {
            public float a(Object obj) {
                return dVar.a();
            }

            public void a(Object obj, float f) {
                dVar.a(f);
            }
        };
        this.x = 1.0f;
    }

    <K> b(K k2, c<K> cVar) {
        this.o = 0.0f;
        this.p = Float.MAX_VALUE;
        this.q = false;
        this.t = false;
        this.u = Float.MAX_VALUE;
        this.v = -this.u;
        this.w = 0;
        this.y = new ArrayList<>();
        this.z = new ArrayList<>();
        this.r = k2;
        this.s = cVar;
        c cVar2 = this.s;
        if (cVar2 == f || cVar2 == g || cVar2 == h) {
            this.x = 0.1f;
        } else if (cVar2 == l) {
            this.x = 0.00390625f;
        } else if (cVar2 == d || cVar2 == e) {
            this.x = 0.00390625f;
        } else {
            this.x = 1.0f;
        }
    }

    public T a(float f2) {
        this.o = f2;
        return this;
    }

    public T b(float f2) {
        this.u = f2;
        return this;
    }

    public T c(float f2) {
        this.v = f2;
        return this;
    }

    public T a(C0027b bVar) {
        if (!this.y.contains(bVar)) {
            this.y.add(bVar);
        }
        return this;
    }

    public T a(c cVar) {
        if (!c()) {
            if (!this.z.contains(cVar)) {
                this.z.add(cVar);
            }
            return this;
        }
        throw new UnsupportedOperationException("Error: Update listeners must be added beforethe animation.");
    }

    public void b(c cVar) {
        a(this.z, cVar);
    }

    private static <T> void a(ArrayList<T> arrayList) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (arrayList.get(size) == null) {
                arrayList.remove(size);
            }
        }
    }

    private static <T> void a(ArrayList<T> arrayList, T t2) {
        int indexOf = arrayList.indexOf(t2);
        if (indexOf >= 0) {
            arrayList.set(indexOf, (Object) null);
        }
    }

    public void a() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new AndroidRuntimeException("Animations may only be started on the main thread");
        } else if (!this.t) {
            e();
        }
    }

    public void b() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new AndroidRuntimeException("Animations may only be canceled on the main thread");
        } else if (this.t) {
            a(true);
        }
    }

    public boolean c() {
        return this.t;
    }

    private void e() {
        if (!this.t) {
            this.t = true;
            if (!this.q) {
                this.p = f();
            }
            float f2 = this.p;
            if (f2 > this.u || f2 < this.v) {
                throw new IllegalArgumentException("Starting value need to be in between min value and max value");
            }
            a.a().a(this, 0);
        }
    }

    public boolean a(long j2) {
        long j3 = this.w;
        if (j3 == 0) {
            this.w = j2;
            d(this.p);
            return false;
        }
        this.w = j2;
        boolean b2 = b(j2 - j3);
        this.p = Math.min(this.p, this.u);
        this.p = Math.max(this.p, this.v);
        d(this.p);
        if (b2) {
            a(false);
        }
        return b2;
    }

    private void a(boolean z2) {
        this.t = false;
        a.a().a((a.b) this);
        this.w = 0;
        this.q = false;
        for (int i2 = 0; i2 < this.y.size(); i2++) {
            if (this.y.get(i2) != null) {
                this.y.get(i2).a(this, z2, this.p, this.o);
            }
        }
        a(this.y);
    }

    /* access modifiers changed from: package-private */
    public void d(float f2) {
        this.s.a(this.r, f2);
        for (int i2 = 0; i2 < this.z.size(); i2++) {
            if (this.z.get(i2) != null) {
                this.z.get(i2).a(this, this.p, this.o);
            }
        }
        a(this.z);
    }

    /* access modifiers changed from: package-private */
    public float d() {
        return this.x * 0.75f;
    }

    private float f() {
        return this.s.a(this.r);
    }
}
