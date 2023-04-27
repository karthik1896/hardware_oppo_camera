package com.color.support.widget;

import android.content.Context;
import android.util.Log;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.OverScroller;

/* compiled from: ColorOverScroller */
public class h extends OverScroller implements m {
    private static final Interpolator d = new Interpolator() {
        public float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * f2 * f2 * f2 * f2) + 1.0f;
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private a f2204a;

    /* renamed from: b  reason: collision with root package name */
    private a f2205b;
    private Interpolator c;
    private int e;

    public h(Context context) {
        this(context, (Interpolator) null);
    }

    public h(Context context, Interpolator interpolator) {
        super(context, interpolator);
        this.f2204a = new a(context);
        this.f2205b = new a(context);
        if (interpolator == null) {
            this.c = d;
        } else {
            this.c = interpolator;
        }
    }

    public void a(float f) {
        this.f2204a.a(f);
        this.f2205b.a(f);
    }

    public void a(Interpolator interpolator) {
        if (interpolator == null) {
            this.c = d;
        } else {
            this.c = interpolator;
        }
    }

    public boolean computeScrollOffset() {
        if (a()) {
            return false;
        }
        int i = this.e;
        if (i == 0) {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - this.f2204a.g;
            int b2 = this.f2204a.h;
            if (currentAnimationTimeMillis < ((long) b2)) {
                float interpolation = this.c.getInterpolation(((float) currentAnimationTimeMillis) / ((float) b2));
                this.f2204a.b(interpolation);
                this.f2205b.b(interpolation);
            } else {
                abortAnimation();
            }
        } else if (i == 1) {
            if (!this.f2204a.k && !this.f2204a.c() && !this.f2204a.b()) {
                this.f2204a.a();
            }
            if (!this.f2205b.k && !this.f2205b.c() && !this.f2205b.b()) {
                this.f2205b.a();
            }
        }
        return true;
    }

    public boolean a() {
        return this.f2204a.k && this.f2205b.k;
    }

    public int b() {
        return this.f2204a.f2207b;
    }

    public int c() {
        return this.f2205b.f2207b;
    }

    public int d() {
        return this.f2204a.c;
    }

    public int e() {
        return this.f2205b.c;
    }

    public void a(int i) {
        if (i != -1) {
            this.f2204a.a(i);
        }
    }

    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        int i11 = i2;
        if (i11 > i8) {
            int i12 = i7;
        } else if (i11 >= i7) {
            a(i, i2, i3, i4);
            return;
        }
        springBack(i, i2, i5, i6, i7, i8);
    }

    public void a(int i, int i2, int i3, int i4) {
        this.e = 1;
        this.f2204a.a(i, i3, Integer.MIN_VALUE, Integer.MAX_VALUE, 0);
        this.f2205b.a(i2, i4, Integer.MIN_VALUE, Integer.MAX_VALUE, 0);
    }

    public boolean springBack(int i, int i2, int i3, int i4, int i5, int i6) {
        boolean b2 = this.f2204a.b(i, i3, i4);
        boolean b3 = this.f2205b.b(i2, i5, i6);
        if (b2 || b3) {
            this.e = 1;
        }
        if (b2 || b3) {
            return true;
        }
        return false;
    }

    public void startScroll(int i, int i2, int i3, int i4) {
        startScroll(i, i2, i3, i4, 250);
    }

    public void startScroll(int i, int i2, int i3, int i4, int i5) {
        this.e = 0;
        this.f2204a.a(i, i3, i5);
        this.f2205b.a(i2, i4, i5);
    }

    public void abortAnimation() {
        this.f2204a.a();
        this.f2205b.a();
    }

    public void notifyVerticalEdgeReached(int i, int i2, int i3) {
        this.f2205b.c(i, i2, i3);
        springBack(0, i, 0, 0, 0, 0);
    }

    public void notifyHorizontalEdgeReached(int i, int i2, int i3) {
        this.f2204a.c(i, i2, i3);
        springBack(i, 0, 0, 0, 0, 0);
    }

    public float getCurrVelocity() {
        return (float) Math.hypot((double) this.f2204a.e, (double) this.f2205b.e);
    }

    public float f() {
        return this.f2204a.e;
    }

    public float g() {
        return this.f2205b.e;
    }

    /* compiled from: ColorOverScroller */
    private static class a {
        private static float p = ((float) (Math.log(0.78d) / Math.log(0.9d)));
        private static final float[] q = new float[101];
        private static final float[] r = new float[101];

        /* renamed from: a  reason: collision with root package name */
        private int f2206a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public int f2207b;
        /* access modifiers changed from: private */
        public int c;
        private int d;
        /* access modifiers changed from: private */
        public float e;
        private float f;
        /* access modifiers changed from: private */
        public long g;
        /* access modifiers changed from: private */
        public int h;
        private int i;
        private int j;
        /* access modifiers changed from: private */
        public boolean k = true;
        private int l;
        private float m = (ViewConfiguration.getScrollFriction() * 2.5f);
        private int n = 0;
        private float o;

        private static float b(int i2) {
            return i2 > 0 ? -2000.0f : 2000.0f;
        }

        static {
            float f2;
            float f3;
            float f4;
            float f5;
            float f6;
            float f7;
            float f8;
            float f9;
            float f10;
            float f11;
            float f12 = 0.0f;
            float f13 = 0.0f;
            for (int i2 = 0; i2 < 100; i2++) {
                float f14 = ((float) i2) / 100.0f;
                float f15 = 1.0f;
                while (true) {
                    f2 = 2.0f;
                    f3 = ((f15 - f12) / 2.0f) + f12;
                    f4 = 3.0f;
                    f5 = 1.0f - f3;
                    f6 = f3 * 3.0f * f5;
                    f7 = f3 * f3 * f3;
                    float f16 = (((f5 * 0.175f) + (f3 * 0.35000002f)) * f6) + f7;
                    float f17 = f16;
                    if (((double) Math.abs(f16 - f14)) < 1.0E-5d) {
                        break;
                    } else if (f17 > f14) {
                        f15 = f3;
                    } else {
                        f12 = f3;
                    }
                }
                q[i2] = (f6 * ((f5 * 0.5f) + f3)) + f7;
                float f18 = 1.0f;
                while (true) {
                    f8 = ((f18 - f13) / f2) + f13;
                    f9 = 1.0f - f8;
                    f10 = f8 * f4 * f9;
                    f11 = f8 * f8 * f8;
                    float f19 = (((f9 * 0.5f) + f8) * f10) + f11;
                    if (((double) Math.abs(f19 - f14)) < 1.0E-5d) {
                        break;
                    }
                    if (f19 > f14) {
                        f18 = f8;
                    } else {
                        f13 = f8;
                    }
                    f2 = 2.0f;
                    f4 = 3.0f;
                }
                r[i2] = (f10 * ((f9 * 0.175f) + (f8 * 0.35000002f))) + f11;
            }
            float[] fArr = q;
            r[100] = 1.0f;
            fArr[100] = 1.0f;
        }

        /* access modifiers changed from: package-private */
        public void a(float f2) {
            this.m = f2;
        }

        a(Context context) {
            this.o = context.getResources().getDisplayMetrics().density * 160.0f * 386.0878f * 0.84f;
        }

        /* access modifiers changed from: package-private */
        public void b(float f2) {
            int i2 = this.f2206a;
            this.f2207b = i2 + Math.round(f2 * ((float) (this.c - i2)));
        }

        private void d(int i2, int i3, int i4) {
            float abs = Math.abs(((float) (i4 - i2)) / ((float) (i3 - i2)));
            int i5 = (int) (abs * 100.0f);
            if (i5 < 100) {
                float f2 = ((float) i5) / 100.0f;
                int i6 = i5 + 1;
                float[] fArr = r;
                float f3 = fArr[i5];
                this.h = (int) (((float) this.h) * (f3 + (((abs - f2) / ((((float) i6) / 100.0f) - f2)) * (fArr[i6] - f3))));
            }
        }

        /* access modifiers changed from: package-private */
        public void a(int i2, int i3, int i4) {
            this.k = false;
            this.f2206a = i2;
            this.f2207b = i2;
            this.c = i2 + i3;
            this.g = AnimationUtils.currentAnimationTimeMillis();
            this.h = i4;
            this.f = 0.0f;
            this.d = 0;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            this.f2207b = this.c;
            this.k = true;
        }

        /* access modifiers changed from: package-private */
        public void a(int i2) {
            this.c = i2;
            this.j = this.c - this.f2206a;
            this.k = false;
        }

        /* access modifiers changed from: package-private */
        public boolean b(int i2, int i3, int i4) {
            this.k = true;
            this.c = i2;
            this.f2206a = i2;
            this.f2207b = i2;
            this.d = 0;
            this.g = AnimationUtils.currentAnimationTimeMillis();
            this.h = 0;
            if (i2 < i3) {
                e(i2, i3, 0);
            } else if (i2 > i4) {
                e(i2, i4, 0);
            }
            return !this.k;
        }

        private void e(int i2, int i3, int i4) {
            this.k = false;
            this.n = 1;
            this.f2206a = i2;
            this.f2207b = i2;
            this.c = i3;
            int i5 = i2 - i3;
            this.f = b(i5);
            this.d = -i5;
            this.l = Math.abs(i5);
            this.h = (int) (Math.sqrt((((double) i5) * -2.0d) / ((double) this.f)) * 1000.0d);
        }

        /* access modifiers changed from: package-private */
        public void a(int i2, int i3, int i4, int i5, int i6) {
            this.l = i6;
            this.k = false;
            this.d = i3;
            float f2 = (float) i3;
            this.e = f2;
            this.i = 0;
            this.h = 0;
            this.g = AnimationUtils.currentAnimationTimeMillis();
            this.f2206a = i2;
            this.f2207b = i2;
            if (i2 > i5 || i2 < i4) {
                a(i2, i4, i5, i3);
                return;
            }
            this.n = 0;
            double d2 = 0.0d;
            if (i3 != 0) {
                int e2 = e(i3);
                this.i = e2;
                this.h = e2;
                d2 = d(i3);
            }
            this.j = (int) (d2 * ((double) Math.signum(f2)));
            this.c = i2 + this.j;
            int i7 = this.c;
            if (i7 < i4) {
                d(this.f2206a, i7, i4);
                this.c = i4;
            }
            int i8 = this.c;
            if (i8 > i5) {
                d(this.f2206a, i8, i5);
                this.c = i5;
            }
        }

        private double c(int i2) {
            return Math.log((double) ((((float) Math.abs(i2)) * 0.35f) / (this.m * this.o)));
        }

        private double d(int i2) {
            double c2 = c(i2);
            float f2 = p;
            return ((double) (this.m * this.o)) * Math.exp((((double) f2) / (((double) f2) - 1.0d)) * c2);
        }

        private int e(int i2) {
            return (int) (Math.exp(c(i2) / (((double) p) - 1.0d)) * 1000.0d);
        }

        private void f(int i2, int i3, int i4) {
            float f2 = this.f;
            float f3 = ((float) (-i4)) / f2;
            float f4 = (float) i4;
            float sqrt = (float) Math.sqrt((((double) ((((f4 * f4) / 2.0f) / Math.abs(f2)) + ((float) Math.abs(i3 - i2)))) * 2.0d) / ((double) Math.abs(this.f)));
            this.g -= (long) ((int) ((sqrt - f3) * 1000.0f));
            this.f2206a = i3;
            this.f2207b = i3;
            this.d = (int) ((-this.f) * sqrt);
        }

        private void g(int i2, int i3, int i4) {
            this.f = b(i4 == 0 ? i2 - i3 : i4);
            f(i2, i3, i4);
            d();
        }

        private void a(int i2, int i3, int i4, int i5) {
            boolean z = true;
            if (i2 <= i3 || i2 >= i4) {
                boolean z2 = i2 > i4;
                int i6 = z2 ? i4 : i3;
                int i7 = i2 - i6;
                if (i7 * i5 < 0) {
                    z = false;
                }
                if (z) {
                    g(i2, i6, i5);
                } else if (d(i5) > ((double) Math.abs(i7))) {
                    a(i2, i5, z2 ? i3 : i2, z2 ? i2 : i4, this.l);
                } else {
                    e(i2, i6, i5);
                }
            } else {
                Log.e("ColorOverScroller", "startAfterEdge called from a valid position");
                this.k = true;
            }
        }

        /* access modifiers changed from: package-private */
        public void c(int i2, int i3, int i4) {
            if (this.n == 0) {
                this.l = i4;
                this.g = AnimationUtils.currentAnimationTimeMillis();
                a(i2, i3, i3, (int) this.e);
            }
        }

        private void d() {
            int i2 = this.d;
            float f2 = ((float) i2) * ((float) i2);
            float abs = f2 / (Math.abs(this.f) * 2.0f);
            float signum = Math.signum((float) this.d);
            int i3 = this.l;
            if (abs > ((float) i3)) {
                this.f = ((-signum) * f2) / (((float) i3) * 2.0f);
                abs = (float) i3;
            }
            this.l = (int) abs;
            this.n = 2;
            int i4 = this.f2206a;
            if (this.d <= 0) {
                abs = -abs;
            }
            this.c = i4 + ((int) abs);
            this.h = -((int) ((((float) this.d) * 1000.0f) / this.f));
        }

        /* access modifiers changed from: package-private */
        public boolean b() {
            int i2 = this.n;
            if (i2 != 0) {
                if (i2 == 1) {
                    return false;
                }
                if (i2 == 2) {
                    this.g += (long) this.h;
                    e(this.c, this.f2206a, 0);
                }
            } else if (this.h >= this.i) {
                return false;
            } else {
                int i3 = this.c;
                this.f2206a = i3;
                this.f2207b = i3;
                this.d = (int) this.e;
                this.f = b(this.d);
                this.g += (long) this.h;
                d();
            }
            c();
            return true;
        }

        /* access modifiers changed from: package-private */
        public boolean c() {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - this.g;
            if (currentAnimationTimeMillis != 0) {
                int i2 = this.h;
                if (currentAnimationTimeMillis > ((long) i2)) {
                    return false;
                }
                double d2 = 0.0d;
                int i3 = this.n;
                if (i3 == 0) {
                    float f2 = ((float) currentAnimationTimeMillis) / ((float) this.i);
                    int i4 = (int) (f2 * 100.0f);
                    float f3 = 1.0f;
                    float f4 = 0.0f;
                    if (i4 < 100) {
                        float f5 = ((float) i4) / 100.0f;
                        int i5 = i4 + 1;
                        float[] fArr = q;
                        float f6 = fArr[i4];
                        f4 = (fArr[i5] - f6) / ((((float) i5) / 100.0f) - f5);
                        f3 = f6 + ((f2 - f5) * f4);
                    }
                    int i6 = this.j;
                    this.e = ((f4 * ((float) i6)) / ((float) this.i)) * 1000.0f;
                    d2 = (double) (f3 * ((float) i6));
                } else if (i3 == 1) {
                    float f7 = ((float) currentAnimationTimeMillis) / ((float) i2);
                    float f8 = f7 * f7;
                    float signum = Math.signum((float) this.d);
                    int i7 = this.l;
                    d2 = (double) (((float) i7) * signum * ((3.0f * f8) - ((2.0f * f7) * f8)));
                    this.e = signum * ((float) i7) * 6.0f * ((-f7) + f8);
                } else if (i3 == 2) {
                    float f9 = ((float) currentAnimationTimeMillis) / 1000.0f;
                    int i8 = this.d;
                    float f10 = this.f;
                    this.e = ((float) i8) + (f10 * f9);
                    d2 = (double) ((((float) i8) * f9) + (((f10 * f9) * f9) / 2.0f));
                }
                this.f2207b = this.f2206a + ((int) Math.round(d2));
                return true;
            } else if (this.h > 0) {
                return true;
            } else {
                return false;
            }
        }
    }
}
