package com.airbnb.lottie;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.widget.ImageView;
import com.airbnb.lottie.b.b;
import com.airbnb.lottie.c.h;
import com.airbnb.lottie.e.s;
import com.airbnb.lottie.f.d;
import com.airbnb.lottie.f.e;
import com.airbnb.lottie.f.g;
import com.airbnb.lottie.g.c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* compiled from: LottieDrawable */
public class f extends Drawable implements Animatable, Drawable.Callback {
    private static final String c = "f";

    /* renamed from: a  reason: collision with root package name */
    a f1789a;

    /* renamed from: b  reason: collision with root package name */
    q f1790b;
    private final Matrix d = new Matrix();
    private d e;
    /* access modifiers changed from: private */
    public final e f = new e();
    private float g = 1.0f;
    private boolean h = true;
    private boolean i = false;
    private final Set<Object> j = new HashSet();
    private final ArrayList<a> k = new ArrayList<>();
    private final ValueAnimator.AnimatorUpdateListener l = new ValueAnimator.AnimatorUpdateListener() {
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (f.this.s != null) {
                f.this.s.a(f.this.f.d());
            }
        }
    };
    private ImageView.ScaleType m;
    private b n;
    private String o;
    private b p;
    private com.airbnb.lottie.b.a q;
    private boolean r;
    /* access modifiers changed from: private */
    public com.airbnb.lottie.c.c.b s;
    private int t = 255;
    private boolean u;
    private boolean v;
    private boolean w = true;
    private boolean x = false;

    /* compiled from: LottieDrawable */
    private interface a {
        void a(d dVar);
    }

    public int getOpacity() {
        return -3;
    }

    public f() {
        this.f.addUpdateListener(this.l);
    }

    public boolean a() {
        return this.r;
    }

    public void a(boolean z) {
        if (this.r != z) {
            if (Build.VERSION.SDK_INT < 19) {
                d.b("Merge paths are not supported pre-Kit Kat.");
                return;
            }
            this.r = z;
            if (this.e != null) {
                w();
            }
        }
    }

    public void a(String str) {
        this.o = str;
    }

    public String b() {
        return this.o;
    }

    public boolean a(d dVar) {
        if (this.e == dVar) {
            return false;
        }
        this.x = false;
        e();
        this.e = dVar;
        w();
        this.f.a(dVar);
        d(this.f.getAnimatedFraction());
        e(this.g);
        x();
        Iterator it = new ArrayList(this.k).iterator();
        while (it.hasNext()) {
            ((a) it.next()).a(dVar);
            it.remove();
        }
        this.k.clear();
        dVar.b(this.u);
        Drawable.Callback callback = getCallback();
        if (!(callback instanceof ImageView)) {
            return true;
        }
        ImageView imageView = (ImageView) callback;
        imageView.setImageDrawable((Drawable) null);
        imageView.setImageDrawable(this);
        return true;
    }

    public void b(boolean z) {
        this.u = z;
        d dVar = this.e;
        if (dVar != null) {
            dVar.b(z);
        }
    }

    public n c() {
        d dVar = this.e;
        if (dVar != null) {
            return dVar.c();
        }
        return null;
    }

    public void c(boolean z) {
        this.v = z;
    }

    public boolean d() {
        return this.v;
    }

    private void w() {
        this.s = new com.airbnb.lottie.c.c.b(this, s.a(this.e), this.e.i(), this.e);
    }

    public void e() {
        if (this.f.isRunning()) {
            this.f.cancel();
        }
        this.e = null;
        this.s = null;
        this.n = null;
        this.f.f();
        invalidateSelf();
    }

    public void d(boolean z) {
        this.i = z;
    }

    public void invalidateSelf() {
        if (!this.x) {
            this.x = true;
            Drawable.Callback callback = getCallback();
            if (callback != null) {
                callback.invalidateDrawable(this);
            }
        }
    }

    public void setAlpha(int i2) {
        this.t = i2;
        invalidateSelf();
    }

    public int getAlpha() {
        return this.t;
    }

    public void setColorFilter(ColorFilter colorFilter) {
        d.b("Use addColorFilter instead.");
    }

    public void draw(Canvas canvas) {
        this.x = false;
        c.a("Drawable#draw");
        if (this.i) {
            try {
                a(canvas);
            } catch (Throwable th) {
                d.b("Lottie crashed in draw!", th);
            }
        } else {
            a(canvas);
        }
        c.b("Drawable#draw");
    }

    private void a(Canvas canvas) {
        if (ImageView.ScaleType.FIT_XY == this.m) {
            c(canvas);
        } else {
            d(canvas);
        }
    }

    public void start() {
        f();
    }

    public void stop() {
        g();
    }

    public boolean isRunning() {
        return o();
    }

    public void f() {
        if (this.s == null) {
            this.k.add(new a() {
                public void a(d dVar) {
                    f.this.f();
                }
            });
            return;
        }
        if (this.h || n() == 0) {
            this.f.i();
        }
        if (!this.h) {
            c((int) (k() < 0.0f ? i() : j()));
            this.f.j();
        }
    }

    public void g() {
        this.k.clear();
        this.f.j();
    }

    public void h() {
        if (this.s == null) {
            this.k.add(new a() {
                public void a(d dVar) {
                    f.this.h();
                }
            });
            return;
        }
        if (this.h || n() == 0) {
            this.f.l();
        }
        if (!this.h) {
            c((int) (k() < 0.0f ? i() : j()));
            this.f.j();
        }
    }

    public void a(final int i2) {
        if (this.e == null) {
            this.k.add(new a() {
                public void a(d dVar) {
                    f.this.a(i2);
                }
            });
        } else {
            this.f.a(i2);
        }
    }

    public float i() {
        return this.f.m();
    }

    public void a(final float f2) {
        d dVar = this.e;
        if (dVar == null) {
            this.k.add(new a() {
                public void a(d dVar) {
                    f.this.a(f2);
                }
            });
        } else {
            a((int) g.a(dVar.f(), this.e.g(), f2));
        }
    }

    public void b(final int i2) {
        if (this.e == null) {
            this.k.add(new a() {
                public void a(d dVar) {
                    f.this.b(i2);
                }
            });
        } else {
            this.f.b(((float) i2) + 0.99f);
        }
    }

    public float j() {
        return this.f.n();
    }

    public void b(final float f2) {
        d dVar = this.e;
        if (dVar == null) {
            this.k.add(new a() {
                public void a(d dVar) {
                    f.this.b(f2);
                }
            });
        } else {
            b((int) g.a(dVar.f(), this.e.g(), f2));
        }
    }

    public void b(final String str) {
        d dVar = this.e;
        if (dVar == null) {
            this.k.add(new a() {
                public void a(d dVar) {
                    f.this.b(str);
                }
            });
            return;
        }
        h c2 = dVar.c(str);
        if (c2 != null) {
            a((int) c2.f1720a);
            return;
        }
        throw new IllegalArgumentException("Cannot find marker with name " + str + ".");
    }

    public void c(final String str) {
        d dVar = this.e;
        if (dVar == null) {
            this.k.add(new a() {
                public void a(d dVar) {
                    f.this.c(str);
                }
            });
            return;
        }
        h c2 = dVar.c(str);
        if (c2 != null) {
            b((int) (c2.f1720a + c2.f1721b));
            return;
        }
        throw new IllegalArgumentException("Cannot find marker with name " + str + ".");
    }

    public void d(final String str) {
        d dVar = this.e;
        if (dVar == null) {
            this.k.add(new a() {
                public void a(d dVar) {
                    f.this.d(str);
                }
            });
            return;
        }
        h c2 = dVar.c(str);
        if (c2 != null) {
            int i2 = (int) c2.f1720a;
            a(i2, ((int) c2.f1721b) + i2);
            return;
        }
        throw new IllegalArgumentException("Cannot find marker with name " + str + ".");
    }

    public void a(final int i2, final int i3) {
        if (this.e == null) {
            this.k.add(new a() {
                public void a(d dVar) {
                    f.this.a(i2, i3);
                }
            });
        } else {
            this.f.a((float) i2, ((float) i3) + 0.99f);
        }
    }

    public void c(float f2) {
        this.f.c(f2);
    }

    public float k() {
        return this.f.h();
    }

    public void c(final int i2) {
        if (this.e == null) {
            this.k.add(new a() {
                public void a(d dVar) {
                    f.this.c(i2);
                }
            });
        } else {
            this.f.a((float) i2);
        }
    }

    public int l() {
        return (int) this.f.e();
    }

    public void d(final float f2) {
        if (this.e == null) {
            this.k.add(new a() {
                public void a(d dVar) {
                    f.this.d(f2);
                }
            });
            return;
        }
        c.a("Drawable#setProgress");
        this.f.a(g.a(this.e.f(), this.e.g(), f2));
        c.b("Drawable#setProgress");
    }

    public void d(int i2) {
        this.f.setRepeatMode(i2);
    }

    public int m() {
        return this.f.getRepeatMode();
    }

    public void e(int i2) {
        this.f.setRepeatCount(i2);
    }

    public int n() {
        return this.f.getRepeatCount();
    }

    public boolean o() {
        e eVar = this.f;
        if (eVar == null) {
            return false;
        }
        return eVar.isRunning();
    }

    /* access modifiers changed from: package-private */
    public void a(Boolean bool) {
        this.h = bool.booleanValue();
    }

    public void e(float f2) {
        this.g = f2;
        x();
    }

    public void a(b bVar) {
        this.p = bVar;
        b bVar2 = this.n;
        if (bVar2 != null) {
            bVar2.a(bVar);
        }
    }

    public void a(a aVar) {
        this.f1789a = aVar;
        com.airbnb.lottie.b.a aVar2 = this.q;
        if (aVar2 != null) {
            aVar2.a(aVar);
        }
    }

    public void a(q qVar) {
        this.f1790b = qVar;
    }

    public q p() {
        return this.f1790b;
    }

    public boolean q() {
        return this.f1790b == null && this.e.j().size() > 0;
    }

    public float r() {
        return this.g;
    }

    public d s() {
        return this.e;
    }

    private void x() {
        if (this.e != null) {
            float r2 = r();
            setBounds(0, 0, (int) (((float) this.e.d().width()) * r2), (int) (((float) this.e.d().height()) * r2));
        }
    }

    public void t() {
        this.k.clear();
        this.f.cancel();
    }

    public void u() {
        this.k.clear();
        this.f.k();
    }

    public float v() {
        return this.f.d();
    }

    public int getIntrinsicWidth() {
        d dVar = this.e;
        if (dVar == null) {
            return -1;
        }
        return (int) (((float) dVar.d().width()) * r());
    }

    public int getIntrinsicHeight() {
        d dVar = this.e;
        if (dVar == null) {
            return -1;
        }
        return (int) (((float) dVar.d().height()) * r());
    }

    public List<com.airbnb.lottie.c.e> a(com.airbnb.lottie.c.e eVar) {
        if (this.s == null) {
            d.b("Cannot resolve KeyPath. Composition is not set yet.");
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        this.s.a(eVar, 0, arrayList, new com.airbnb.lottie.c.e(new String[0]));
        return arrayList;
    }

    public <T> void a(final com.airbnb.lottie.c.e eVar, final T t2, final c<T> cVar) {
        if (this.s == null) {
            this.k.add(new a() {
                public void a(d dVar) {
                    f.this.a(eVar, t2, cVar);
                }
            });
            return;
        }
        boolean z = true;
        if (eVar == com.airbnb.lottie.c.e.f1716a) {
            this.s.a(t2, cVar);
        } else if (eVar.a() != null) {
            eVar.a().a(t2, cVar);
        } else {
            List<com.airbnb.lottie.c.e> a2 = a(eVar);
            for (int i2 = 0; i2 < a2.size(); i2++) {
                a2.get(i2).a().a(t2, cVar);
            }
            z = true ^ a2.isEmpty();
        }
        if (z) {
            invalidateSelf();
            if (t2 == k.A) {
                d(v());
            }
        }
    }

    public Bitmap e(String str) {
        b y = y();
        if (y != null) {
            return y.a(str);
        }
        return null;
    }

    private b y() {
        if (getCallback() == null) {
            return null;
        }
        b bVar = this.n;
        if (bVar != null && !bVar.a(A())) {
            this.n = null;
        }
        if (this.n == null) {
            this.n = new b(getCallback(), this.o, this.p, this.e.l());
        }
        return this.n;
    }

    public Typeface a(String str, String str2) {
        com.airbnb.lottie.b.a z = z();
        if (z != null) {
            return z.a(str, str2);
        }
        return null;
    }

    private com.airbnb.lottie.b.a z() {
        if (getCallback() == null) {
            return null;
        }
        if (this.q == null) {
            this.q = new com.airbnb.lottie.b.a(getCallback(), this.f1789a);
        }
        return this.q;
    }

    private Context A() {
        Drawable.Callback callback = getCallback();
        if (callback != null && (callback instanceof View)) {
            return ((View) callback).getContext();
        }
        return null;
    }

    public void invalidateDrawable(Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j2) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.scheduleDrawable(this, runnable, j2);
        }
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.unscheduleDrawable(this, runnable);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(ImageView.ScaleType scaleType) {
        this.m = scaleType;
    }

    private float b(Canvas canvas) {
        return Math.min(((float) canvas.getWidth()) / ((float) this.e.d().width()), ((float) canvas.getHeight()) / ((float) this.e.d().height()));
    }

    private void c(Canvas canvas) {
        float f2;
        if (this.s != null) {
            int i2 = -1;
            Rect bounds = getBounds();
            float width = ((float) bounds.width()) / ((float) this.e.d().width());
            float height = ((float) bounds.height()) / ((float) this.e.d().height());
            if (this.w) {
                float min = Math.min(width, height);
                if (min < 1.0f) {
                    f2 = 1.0f / min;
                    width /= f2;
                    height /= f2;
                } else {
                    f2 = 1.0f;
                }
                if (f2 > 1.0f) {
                    i2 = canvas.save();
                    float width2 = ((float) bounds.width()) / 2.0f;
                    float height2 = ((float) bounds.height()) / 2.0f;
                    float f3 = width2 * min;
                    float f4 = min * height2;
                    canvas.translate(width2 - f3, height2 - f4);
                    canvas.scale(f2, f2, f3, f4);
                }
            }
            this.d.reset();
            this.d.preScale(width, height);
            this.s.a(canvas, this.d, this.t);
            if (i2 > 0) {
                canvas.restoreToCount(i2);
            }
        }
    }

    private void d(Canvas canvas) {
        float f2;
        if (this.s != null) {
            float f3 = this.g;
            float b2 = b(canvas);
            if (f3 > b2) {
                f2 = this.g / b2;
            } else {
                b2 = f3;
                f2 = 1.0f;
            }
            int i2 = -1;
            if (f2 > 1.0f) {
                i2 = canvas.save();
                float width = ((float) this.e.d().width()) / 2.0f;
                float height = ((float) this.e.d().height()) / 2.0f;
                float f4 = width * b2;
                float f5 = height * b2;
                canvas.translate((r() * width) - f4, (r() * height) - f5);
                canvas.scale(f2, f2, f4, f5);
            }
            this.d.reset();
            this.d.preScale(b2, b2);
            this.s.a(canvas, this.d, this.t);
            if (i2 > 0) {
                canvas.restoreToCount(i2);
            }
        }
    }
}
