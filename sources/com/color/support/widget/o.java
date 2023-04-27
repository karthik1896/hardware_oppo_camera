package com.color.support.widget;

import android.content.Context;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.OverScroller;

/* compiled from: SpringOverScroller */
public class o extends OverScroller implements m {
    /* access modifiers changed from: private */
    public static float e;

    /* renamed from: a  reason: collision with root package name */
    private b f2242a;

    /* renamed from: b  reason: collision with root package name */
    private b f2243b;
    private Interpolator c;
    private int d;

    public void a(int i) {
    }

    public o(Context context, Interpolator interpolator) {
        super(context, interpolator);
        this.d = 2;
        this.f2242a = new b();
        this.f2243b = new b();
        if (interpolator == null) {
            this.c = new a();
        } else {
            this.c = interpolator;
        }
        e = 0.016f;
    }

    public o(Context context) {
        this(context, (Interpolator) null);
    }

    public void a(float f) {
        e = ((float) Math.round(10000.0f / f)) / 10000.0f;
    }

    public void a(Interpolator interpolator) {
        if (interpolator == null) {
            this.c = new a();
        } else {
            this.c = interpolator;
        }
    }

    public boolean computeScrollOffset() {
        if (a()) {
            return false;
        }
        int i = this.d;
        if (i == 0) {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - this.f2242a.p;
            int b2 = this.f2242a.n;
            if (currentAnimationTimeMillis < ((long) b2)) {
                float interpolation = this.c.getInterpolation(((float) currentAnimationTimeMillis) / ((float) b2));
                this.f2242a.a(interpolation);
                this.f2243b.a(interpolation);
            } else {
                this.f2242a.a(1.0f);
                this.f2243b.a(1.0f);
                abortAnimation();
            }
        } else if (i == 1 && !this.f2242a.f() && !this.f2243b.f()) {
            abortAnimation();
        }
        return true;
    }

    public final boolean a() {
        return this.f2242a.e() && this.f2243b.e() && this.d != 0;
    }

    public final int b() {
        return (int) Math.round(this.f2242a.a());
    }

    public final int c() {
        return (int) Math.round(this.f2243b.a());
    }

    public final int d() {
        return (int) this.f2242a.c();
    }

    public final int e() {
        return (int) this.f2243b.c();
    }

    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        int i11 = i2;
        if (i11 > i8) {
            int i12 = i7;
        } else if (i11 >= i7) {
            fling(i, i2, i3, i4, i5, i6, i7, i8);
            return;
        }
        springBack(i, i2, i5, i6, i7, i8);
    }

    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        a(i, i2, i3, i4);
    }

    public void a(int i, int i2, int i3, int i4) {
        this.d = 1;
        this.f2242a.a(i, i3);
        this.f2243b.a(i2, i4);
    }

    public boolean springBack(int i, int i2, int i3, int i4, int i5, int i6) {
        boolean a2 = this.f2242a.a(i, i3, i4);
        boolean a3 = this.f2243b.a(i2, i5, i6);
        if (a2 || a3) {
            this.d = 1;
        }
        if (a2 || a3) {
            return true;
        }
        return false;
    }

    public void startScroll(int i, int i2, int i3, int i4) {
        startScroll(i, i2, i3, i4, 250);
    }

    public void startScroll(int i, int i2, int i3, int i4, int i5) {
        this.d = 0;
        this.f2242a.b(i, i3, i5);
        this.f2243b.b(i2, i4, i5);
    }

    public void abortAnimation() {
        this.d = 2;
        this.f2242a.d();
        this.f2243b.d();
    }

    public void notifyVerticalEdgeReached(int i, int i2, int i3) {
        this.f2243b.c(i, i2, i3);
        springBack(0, i, 0, 0, 0, 0);
    }

    public void notifyHorizontalEdgeReached(int i, int i2, int i3) {
        this.f2242a.c(i, i2, i3);
        springBack(i, 0, 0, 0, 0, 0);
    }

    public float getCurrVelocity() {
        double b2 = this.f2242a.b();
        double b3 = this.f2243b.b();
        return (float) ((int) Math.sqrt((b2 * b2) + (b3 * b3)));
    }

    public float f() {
        return (float) this.f2242a.b();
    }

    public float g() {
        return (float) this.f2243b.b();
    }

    public void b(float f) {
        this.f2242a.e.f2249b = (double) f;
    }

    public void c(float f) {
        this.f2243b.e.f2249b = (double) f;
    }

    public void d(float f) {
        float unused = this.f2242a.u = f;
        float unused2 = this.f2243b.u = f;
    }

    /* compiled from: SpringOverScroller */
    static class b {

        /* renamed from: a  reason: collision with root package name */
        private static float f2246a = 1.0f;

        /* renamed from: b  reason: collision with root package name */
        private C0059b f2247b;
        private C0059b c = new C0059b((double) this.h, 0.0d);
        private C0059b d = new C0059b(12.1899995803833d, 16.0d);
        /* access modifiers changed from: private */
        public a e = new a();
        private a f = new a();
        private a g = new a();
        private float h = 1.06f;
        private double i = 100.0d;
        private double j = 0.05d;
        private double k;
        private double l;
        private int m;
        /* access modifiers changed from: private */
        public int n;
        private int o;
        /* access modifiers changed from: private */
        public long p;
        private int q = 1;
        private boolean r = false;
        private boolean s;
        private boolean t;
        /* access modifiers changed from: private */
        public float u = 2.15f;

        b() {
            a(this.c);
        }

        /* access modifiers changed from: package-private */
        public void a(int i2, int i3) {
            this.q = 1;
            f2246a = 1.0f;
            this.c.a((double) this.h);
            this.c.b(0.0d);
            a(this.c);
            a((double) i2, true);
            a((double) i3);
        }

        /* access modifiers changed from: package-private */
        public boolean a(int i2, int i3, int i4) {
            a((double) i2, false);
            if (i2 > i4 || i2 < i3) {
                if (i2 > i4) {
                    b((double) i4);
                } else if (i2 < i3) {
                    b((double) i3);
                }
                this.s = true;
                this.d.a(12.1899995803833d);
                this.d.b((double) (this.u * 16.0f));
                a(this.d);
                return true;
            }
            a(new C0059b((double) this.h, 0.0d));
            return false;
        }

        /* access modifiers changed from: package-private */
        public void b(int i2, int i3, int i4) {
            this.m = i2;
            this.o = i2 + i3;
            this.n = i4;
            this.p = AnimationUtils.currentAnimationTimeMillis();
            a(this.c);
        }

        /* access modifiers changed from: package-private */
        public void a(C0059b bVar) {
            if (bVar != null) {
                this.f2247b = bVar;
                return;
            }
            throw new IllegalArgumentException("springConfig is required");
        }

        /* access modifiers changed from: package-private */
        public void a(double d2, boolean z) {
            this.k = d2;
            if (!this.r) {
                this.f.f2248a = 0.0d;
                this.g.f2248a = 0.0d;
            }
            this.e.f2248a = d2;
            if (z) {
                d();
            }
        }

        /* access modifiers changed from: package-private */
        public double a() {
            return this.e.f2248a;
        }

        /* access modifiers changed from: package-private */
        public double b() {
            return this.e.f2249b;
        }

        /* access modifiers changed from: package-private */
        public void a(double d2) {
            if (d2 != this.e.f2249b) {
                this.e.f2249b = d2;
            }
        }

        /* access modifiers changed from: package-private */
        public double c() {
            return this.l;
        }

        /* access modifiers changed from: package-private */
        public void b(double d2) {
            if (this.l != d2) {
                this.k = a();
                this.l = d2;
            }
        }

        /* access modifiers changed from: package-private */
        public void d() {
            this.l = this.e.f2248a;
            this.g.f2248a = this.e.f2248a;
            this.e.f2249b = 0.0d;
            this.s = false;
        }

        /* access modifiers changed from: package-private */
        public boolean e() {
            return Math.abs(this.e.f2249b) <= this.i && (a(this.e) <= this.j || this.f2247b.f2251b == 0.0d);
        }

        /* access modifiers changed from: package-private */
        public void a(float f2) {
            a aVar = this.e;
            int i2 = this.m;
            aVar.f2248a = (double) (i2 + Math.round(f2 * ((float) (this.o - i2))));
        }

        /* access modifiers changed from: package-private */
        public void c(int i2, int i3, int i4) {
            this.e.f2248a = (double) i2;
            a aVar = this.f;
            aVar.f2248a = 0.0d;
            aVar.f2249b = 0.0d;
            a aVar2 = this.g;
            aVar2.f2248a = 0.0d;
            aVar2.f2249b = 0.0d;
        }

        /* access modifiers changed from: package-private */
        public double a(a aVar) {
            return Math.abs(this.l - aVar.f2248a);
        }

        /* access modifiers changed from: package-private */
        public boolean f() {
            if (e()) {
                return false;
            }
            double d2 = this.e.f2248a;
            double d3 = this.e.f2249b;
            double d4 = this.g.f2248a;
            double d5 = this.g.f2249b;
            if (this.s) {
                double a2 = a(this.e);
                if (!this.t && a2 < 180.0d) {
                    this.f2247b.f2251b += 100.0d;
                    this.t = true;
                } else if (a2 < 2.0d) {
                    this.e.f2248a = this.l;
                    this.t = false;
                    this.s = false;
                    return false;
                }
            } else if (this.q < 60) {
                f2246a += 0.020000001f;
                this.f2247b.f2250a += 0.020000001415610313d;
            } else {
                float f2 = f2246a;
                f2246a = f2 - ((f2 - 0.6f) / 60.0f);
                this.f2247b.f2250a -= (double) ((f2246a - 0.6f) / 60.0f);
            }
            double d6 = (this.f2247b.f2251b * (this.l - d4)) - (this.f2247b.f2250a * this.f.f2249b);
            double h2 = ((((double) o.e) * d6) / 2.0d) + d3;
            double h3 = (this.f2247b.f2251b * (this.l - (((((double) o.e) * d3) / 2.0d) + d2))) - (this.f2247b.f2250a * h2);
            double d7 = d6;
            double h4 = ((((double) o.e) * h3) / 2.0d) + d3;
            double d8 = h3;
            double h5 = (this.f2247b.f2251b * (this.l - (((((double) o.e) * h2) / 2.0d) + d2))) - (this.f2247b.f2250a * h4);
            double h6 = (((double) o.e) * h4) + d2;
            double h7 = (((double) o.e) * h5) + d3;
            double h8 = d3 + ((d7 + ((d8 + h5) * 2.0d) + ((this.f2247b.f2251b * (this.l - h6)) - (this.f2247b.f2250a * h7))) * 0.16699999570846558d * ((double) o.e));
            a aVar = this.g;
            aVar.f2249b = h7;
            aVar.f2248a = h6;
            a aVar2 = this.e;
            aVar2.f2249b = h8;
            aVar2.f2248a = d2 + ((((h2 + h4) * 2.0d) + d3 + h7) * 0.16699999570846558d * ((double) o.e));
            this.q++;
            return true;
        }

        /* renamed from: com.color.support.widget.o$b$b  reason: collision with other inner class name */
        /* compiled from: SpringOverScroller */
        static class C0059b {

            /* renamed from: a  reason: collision with root package name */
            double f2250a;

            /* renamed from: b  reason: collision with root package name */
            double f2251b;

            private float a(float f) {
                if (f == 0.0f) {
                    return 0.0f;
                }
                return 25.0f + ((f - 8.0f) * 3.0f);
            }

            private double b(float f) {
                if (f == 0.0f) {
                    return 0.0d;
                }
                return (double) (((f - 30.0f) * 3.62f) + 194.0f);
            }

            C0059b(double d, double d2) {
                this.f2250a = (double) a((float) d);
                this.f2251b = b((float) d2);
            }

            /* access modifiers changed from: package-private */
            public void a(double d) {
                this.f2250a = (double) a((float) d);
            }

            /* access modifiers changed from: package-private */
            public void b(double d) {
                this.f2251b = b((float) d);
            }
        }

        /* compiled from: SpringOverScroller */
        static class a {

            /* renamed from: a  reason: collision with root package name */
            double f2248a;

            /* renamed from: b  reason: collision with root package name */
            double f2249b;

            a() {
            }
        }
    }

    /* compiled from: SpringOverScroller */
    static class a implements Interpolator {

        /* renamed from: a  reason: collision with root package name */
        private static final float f2244a = (1.0f / a(1.0f));

        /* renamed from: b  reason: collision with root package name */
        private static final float f2245b = (1.0f - (f2244a * a(1.0f)));

        a() {
        }

        private static float a(float f) {
            float f2 = f * 8.0f;
            if (f2 < 1.0f) {
                return f2 - (1.0f - ((float) Math.exp((double) (-f2))));
            }
            return ((1.0f - ((float) Math.exp((double) (1.0f - f2)))) * 0.63212055f) + 0.36787945f;
        }

        public float getInterpolation(float f) {
            float a2 = f2244a * a(f);
            return a2 > 0.0f ? a2 + f2245b : a2;
        }
    }
}
