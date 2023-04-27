package androidx.core.widget;

import android.content.res.Resources;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import androidx.core.g.v;
import com.sensetime.stmobile.sticker_module_types.STStickerFilterParamType;

/* compiled from: AutoScrollHelper */
public abstract class a implements View.OnTouchListener {
    private static final int r = ViewConfiguration.getTapTimeout();

    /* renamed from: a  reason: collision with root package name */
    final C0023a f755a = new C0023a();

    /* renamed from: b  reason: collision with root package name */
    final View f756b;
    boolean c;
    boolean d;
    boolean e;
    private final Interpolator f = new AccelerateInterpolator();
    private Runnable g;
    private float[] h = {0.0f, 0.0f};
    private float[] i = {Float.MAX_VALUE, Float.MAX_VALUE};
    private int j;
    private int k;
    private float[] l = {0.0f, 0.0f};
    private float[] m = {0.0f, 0.0f};
    private float[] n = {Float.MAX_VALUE, Float.MAX_VALUE};
    private boolean o;
    private boolean p;
    private boolean q;

    static float a(float f2, float f3, float f4) {
        return f2 > f4 ? f4 : f2 < f3 ? f3 : f2;
    }

    static int a(int i2, int i3, int i4) {
        return i2 > i4 ? i4 : i2 < i3 ? i3 : i2;
    }

    public abstract void a(int i2, int i3);

    public abstract boolean e(int i2);

    public abstract boolean f(int i2);

    public a(View view) {
        this.f756b = view;
        DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();
        float f2 = (float) ((int) ((displayMetrics.density * 1575.0f) + 0.5f));
        a(f2, f2);
        float f3 = (float) ((int) ((displayMetrics.density * 315.0f) + 0.5f));
        b(f3, f3);
        a(1);
        e(Float.MAX_VALUE, Float.MAX_VALUE);
        d(0.2f, 0.2f);
        c(1.0f, 1.0f);
        b(r);
        c(STStickerFilterParamType.ST_STICKER_PARAM_FILTER_FLOAT_STRENGTH);
        d(STStickerFilterParamType.ST_STICKER_PARAM_FILTER_FLOAT_STRENGTH);
    }

    public a a(boolean z) {
        if (this.p && !z) {
            d();
        }
        this.p = z;
        return this;
    }

    public a a(float f2, float f3) {
        float[] fArr = this.n;
        fArr[0] = f2 / 1000.0f;
        fArr[1] = f3 / 1000.0f;
        return this;
    }

    public a b(float f2, float f3) {
        float[] fArr = this.m;
        fArr[0] = f2 / 1000.0f;
        fArr[1] = f3 / 1000.0f;
        return this;
    }

    public a c(float f2, float f3) {
        float[] fArr = this.l;
        fArr[0] = f2 / 1000.0f;
        fArr[1] = f3 / 1000.0f;
        return this;
    }

    public a a(int i2) {
        this.j = i2;
        return this;
    }

    public a d(float f2, float f3) {
        float[] fArr = this.h;
        fArr[0] = f2;
        fArr[1] = f3;
        return this;
    }

    public a e(float f2, float f3) {
        float[] fArr = this.i;
        fArr[0] = f2;
        fArr[1] = f3;
        return this;
    }

    public a b(int i2) {
        this.k = i2;
        return this;
    }

    public a c(int i2) {
        this.f755a.a(i2);
        return this;
    }

    public a d(int i2) {
        this.f755a.b(i2);
        return this;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0013, code lost:
        if (r0 != 3) goto L_0x0058;
     */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouch(android.view.View r6, android.view.MotionEvent r7) {
        /*
            r5 = this;
            boolean r0 = r5.p
            r1 = 0
            if (r0 != 0) goto L_0x0006
            return r1
        L_0x0006:
            int r0 = r7.getActionMasked()
            r2 = 1
            if (r0 == 0) goto L_0x001a
            if (r0 == r2) goto L_0x0016
            r3 = 2
            if (r0 == r3) goto L_0x001e
            r6 = 3
            if (r0 == r6) goto L_0x0016
            goto L_0x0058
        L_0x0016:
            r5.d()
            goto L_0x0058
        L_0x001a:
            r5.d = r2
            r5.o = r1
        L_0x001e:
            float r0 = r7.getX()
            int r3 = r6.getWidth()
            float r3 = (float) r3
            android.view.View r4 = r5.f756b
            int r4 = r4.getWidth()
            float r4 = (float) r4
            float r0 = r5.a((int) r1, (float) r0, (float) r3, (float) r4)
            float r7 = r7.getY()
            int r6 = r6.getHeight()
            float r6 = (float) r6
            android.view.View r3 = r5.f756b
            int r3 = r3.getHeight()
            float r3 = (float) r3
            float r6 = r5.a((int) r2, (float) r7, (float) r6, (float) r3)
            androidx.core.widget.a$a r7 = r5.f755a
            r7.a(r0, r6)
            boolean r6 = r5.e
            if (r6 != 0) goto L_0x0058
            boolean r6 = r5.a()
            if (r6 == 0) goto L_0x0058
            r5.c()
        L_0x0058:
            boolean r6 = r5.q
            if (r6 == 0) goto L_0x0061
            boolean r6 = r5.e
            if (r6 == 0) goto L_0x0061
            r1 = r2
        L_0x0061:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.a.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    /* access modifiers changed from: package-private */
    public boolean a() {
        C0023a aVar = this.f755a;
        int f2 = aVar.f();
        int e2 = aVar.e();
        return (f2 != 0 && f(f2)) || (e2 != 0 && e(e2));
    }

    private void c() {
        int i2;
        if (this.g == null) {
            this.g = new b();
        }
        this.e = true;
        this.c = true;
        if (this.o || (i2 = this.k) <= 0) {
            this.g.run();
        } else {
            v.a(this.f756b, this.g, (long) i2);
        }
        this.o = true;
    }

    private void d() {
        if (this.c) {
            this.e = false;
        } else {
            this.f755a.b();
        }
    }

    private float a(int i2, float f2, float f3, float f4) {
        float a2 = a(this.h[i2], f3, this.i[i2], f2);
        int i3 = (a2 > 0.0f ? 1 : (a2 == 0.0f ? 0 : -1));
        if (i3 == 0) {
            return 0.0f;
        }
        float f5 = this.l[i2];
        float f6 = this.m[i2];
        float f7 = this.n[i2];
        float f8 = f5 * f4;
        if (i3 > 0) {
            return a(a2 * f8, f6, f7);
        }
        return -a((-a2) * f8, f6, f7);
    }

    private float a(float f2, float f3, float f4, float f5) {
        float f6;
        float a2 = a(f2 * f3, 0.0f, f4);
        float f7 = f(f3 - f5, a2) - f(f5, a2);
        if (f7 < 0.0f) {
            f6 = -this.f.getInterpolation(-f7);
        } else if (f7 <= 0.0f) {
            return 0.0f;
        } else {
            f6 = this.f.getInterpolation(f7);
        }
        return a(f6, -1.0f, 1.0f);
    }

    private float f(float f2, float f3) {
        if (f3 == 0.0f) {
            return 0.0f;
        }
        int i2 = this.j;
        if (i2 == 0 || i2 == 1) {
            if (f2 < f3) {
                if (f2 >= 0.0f) {
                    return 1.0f - (f2 / f3);
                }
                return (!this.e || this.j != 1) ? 0.0f : 1.0f;
            }
        } else if (i2 == 2 && f2 < 0.0f) {
            return f2 / (-f3);
        }
    }

    /* access modifiers changed from: package-private */
    public void b() {
        long uptimeMillis = SystemClock.uptimeMillis();
        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
        this.f756b.onTouchEvent(obtain);
        obtain.recycle();
    }

    /* compiled from: AutoScrollHelper */
    private class b implements Runnable {
        b() {
        }

        public void run() {
            if (a.this.e) {
                if (a.this.c) {
                    a aVar = a.this;
                    aVar.c = false;
                    aVar.f755a.a();
                }
                C0023a aVar2 = a.this.f755a;
                if (aVar2.c() || !a.this.a()) {
                    a.this.e = false;
                    return;
                }
                if (a.this.d) {
                    a aVar3 = a.this;
                    aVar3.d = false;
                    aVar3.b();
                }
                aVar2.d();
                a.this.a(aVar2.g(), aVar2.h());
                v.a(a.this.f756b, (Runnable) this);
            }
        }
    }

    /* renamed from: androidx.core.widget.a$a  reason: collision with other inner class name */
    /* compiled from: AutoScrollHelper */
    private static class C0023a {

        /* renamed from: a  reason: collision with root package name */
        private int f757a;

        /* renamed from: b  reason: collision with root package name */
        private int f758b;
        private float c;
        private float d;
        private long e = Long.MIN_VALUE;
        private long f = 0;
        private int g = 0;
        private int h = 0;
        private long i = -1;
        private float j;
        private int k;

        private float a(float f2) {
            return (-4.0f * f2 * f2) + (f2 * 4.0f);
        }

        C0023a() {
        }

        public void a(int i2) {
            this.f757a = i2;
        }

        public void b(int i2) {
            this.f758b = i2;
        }

        public void a() {
            this.e = AnimationUtils.currentAnimationTimeMillis();
            this.i = -1;
            this.f = this.e;
            this.j = 0.5f;
            this.g = 0;
            this.h = 0;
        }

        public void b() {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.k = a.a((int) (currentAnimationTimeMillis - this.e), 0, this.f758b);
            this.j = a(currentAnimationTimeMillis);
            this.i = currentAnimationTimeMillis;
        }

        public boolean c() {
            return this.i > 0 && AnimationUtils.currentAnimationTimeMillis() > this.i + ((long) this.k);
        }

        private float a(long j2) {
            if (j2 < this.e) {
                return 0.0f;
            }
            long j3 = this.i;
            if (j3 < 0 || j2 < j3) {
                return a.a(((float) (j2 - this.e)) / ((float) this.f757a), 0.0f, 1.0f) * 0.5f;
            }
            long j4 = j2 - j3;
            float f2 = this.j;
            return (1.0f - f2) + (f2 * a.a(((float) j4) / ((float) this.k), 0.0f, 1.0f));
        }

        public void d() {
            if (this.f != 0) {
                long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
                float a2 = a(a(currentAnimationTimeMillis));
                this.f = currentAnimationTimeMillis;
                float f2 = ((float) (currentAnimationTimeMillis - this.f)) * a2;
                this.g = (int) (this.c * f2);
                this.h = (int) (f2 * this.d);
                return;
            }
            throw new RuntimeException("Cannot compute scroll delta before calling start()");
        }

        public void a(float f2, float f3) {
            this.c = f2;
            this.d = f3;
        }

        public int e() {
            float f2 = this.c;
            return (int) (f2 / Math.abs(f2));
        }

        public int f() {
            float f2 = this.d;
            return (int) (f2 / Math.abs(f2));
        }

        public int g() {
            return this.g;
        }

        public int h() {
            return this.h;
        }
    }
}
