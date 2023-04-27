package com.coloros.anim;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Typeface;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.view.View;
import com.coloros.anim.b.a;
import com.coloros.anim.c.h;
import com.coloros.anim.e.t;
import com.coloros.anim.f.c;
import com.coloros.anim.f.f;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* compiled from: EffectiveAnimationDrawable */
public class b extends Drawable implements Animatable, Drawable.Callback {
    private static final String c = "b";

    /* renamed from: a  reason: collision with root package name */
    i f2327a;

    /* renamed from: b  reason: collision with root package name */
    p f2328b;
    private final Matrix d = new Matrix();
    /* access modifiers changed from: private */
    public final c e = new c();
    private final Set<Object> f = new HashSet();
    private final ArrayList<a> g = new ArrayList<>();
    private a h;
    private float i = 1.0f;
    private com.coloros.anim.b.b j;
    private String k;
    private j l;
    private a m;
    private boolean n;
    /* access modifiers changed from: private */
    public com.coloros.anim.c.c.b o;
    private int p = 255;
    private boolean q;
    private boolean r = false;

    /* compiled from: EffectiveAnimationDrawable */
    private interface a {
        void a(a aVar);
    }

    public int getOpacity() {
        return -3;
    }

    public b() {
        this.e.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (b.this.o != null) {
                    b.this.o.a(b.this.e.d());
                }
            }
        });
    }

    public boolean a() {
        return this.n;
    }

    public void a(boolean z) {
        if (this.n != z) {
            if (Build.VERSION.SDK_INT < 19) {
                Log.w(c, "Merge paths are not supported pre-Kit Kat.");
                return;
            }
            this.n = z;
            if (this.h != null) {
                v();
            }
        }
    }

    public void a(String str) {
        this.k = str;
    }

    public String b() {
        return this.k;
    }

    public boolean a(a aVar) {
        if (this.h == aVar) {
            return false;
        }
        if (com.coloros.anim.f.b.f2453b) {
            com.coloros.anim.f.b.b("EffectiveAnimationDrawable::setComposition:composition = " + aVar.toString());
        }
        com.coloros.anim.f.b.b("EffectiveAnimationDrawable::setComposition");
        this.r = false;
        d();
        this.h = aVar;
        v();
        this.e.a(aVar);
        e(this.e.getAnimatedFraction());
        d(this.i);
        w();
        Iterator it = new ArrayList(this.g).iterator();
        while (it.hasNext()) {
            ((a) it.next()).a(aVar);
            it.remove();
        }
        this.g.clear();
        aVar.b(this.q);
        return true;
    }

    public void b(boolean z) {
        this.q = z;
        a aVar = this.h;
        if (aVar != null) {
            aVar.b(z);
        }
    }

    public m c() {
        a aVar = this.h;
        if (aVar != null) {
            return aVar.c();
        }
        return null;
    }

    private void v() {
        this.o = new com.coloros.anim.c.c.b(this, t.a(this.h), this.h.i(), this.h);
    }

    public void d() {
        if (this.e.isRunning()) {
            this.e.cancel();
        }
        this.h = null;
        this.o = null;
        this.j = null;
        this.e.f();
        invalidateSelf();
    }

    public void invalidateSelf() {
        if (!this.r) {
            this.r = true;
            Drawable.Callback callback = getCallback();
            if (callback != null) {
                callback.invalidateDrawable(this);
            }
        }
    }

    public int getAlpha() {
        return this.p;
    }

    public void setAlpha(int i2) {
        this.p = i2;
    }

    public void setColorFilter(ColorFilter colorFilter) {
        Log.w("EffectiveAnimation", "Use addColorFilter instead.");
    }

    public void draw(Canvas canvas) {
        float f2;
        this.r = false;
        k.a("Drawable#draw#start");
        k.c("Drawable#draw");
        if (this.o != null) {
            float f3 = this.i;
            float a2 = a(canvas);
            if (f3 > a2) {
                f2 = this.i / a2;
            } else {
                a2 = f3;
                f2 = 1.0f;
            }
            int i2 = -1;
            if (f2 > 1.0f) {
                i2 = canvas.save();
                float width = ((float) this.h.d().width()) / 2.0f;
                float height = ((float) this.h.d().height()) / 2.0f;
                float f4 = width * a2;
                float f5 = height * a2;
                canvas.translate((q() * width) - f4, (q() * height) - f5);
                canvas.scale(f2, f2, f4, f5);
            }
            this.d.reset();
            this.d.preScale(a2, a2);
            this.o.a(canvas, this.d, this.p);
            k.a("Drawable#draw#end time = " + k.d("Drawable#draw"));
            if (i2 > 0) {
                canvas.restoreToCount(i2);
            }
        }
    }

    public void start() {
        e();
    }

    public void stop() {
        f();
    }

    public boolean isRunning() {
        return n();
    }

    public void e() {
        if (this.o == null) {
            this.g.add(new a() {
                public void a(a aVar) {
                    b.this.e();
                }
            });
        } else {
            this.e.i();
        }
    }

    public void f() {
        this.g.clear();
        this.e.j();
    }

    public void g() {
        if (this.o == null) {
            this.g.add(new a() {
                public void a(a aVar) {
                    b.this.g();
                }
            });
        } else {
            this.e.l();
        }
    }

    public void a(final int i2) {
        if (this.h == null) {
            this.g.add(new a() {
                public void a(a aVar) {
                    b.this.a(i2);
                }
            });
        } else {
            this.e.b(i2);
        }
    }

    public float h() {
        return this.e.m();
    }

    public void b(final String str) {
        a aVar = this.h;
        if (aVar == null) {
            this.g.add(new a() {
                public void a(a aVar) {
                    b.this.b(str);
                }
            });
            return;
        }
        h c2 = aVar.c(str);
        if (c2 != null) {
            a((int) c2.f2423b);
            return;
        }
        throw new IllegalArgumentException("Cannot find marker with name " + str + ".");
    }

    public void a(final float f2) {
        a aVar = this.h;
        if (aVar == null) {
            this.g.add(new a() {
                public void a(a aVar) {
                    b.this.a(f2);
                }
            });
        } else {
            a((int) f.a(aVar.f(), this.h.g(), f2));
        }
    }

    public void b(final int i2) {
        if (this.h == null) {
            this.g.add(new a() {
                public void a(a aVar) {
                    b.this.b(i2);
                }
            });
        } else {
            this.e.b(((float) i2) + 0.99f);
        }
    }

    public float i() {
        return this.e.n();
    }

    public void c(final String str) {
        a aVar = this.h;
        if (aVar == null) {
            this.g.add(new a() {
                public void a(a aVar) {
                    b.this.c(str);
                }
            });
            return;
        }
        h c2 = aVar.c(str);
        if (c2 != null) {
            b((int) (c2.f2423b + c2.c));
            return;
        }
        throw new IllegalArgumentException("Cannot find marker with name " + str + ".");
    }

    public void b(final float f2) {
        a aVar = this.h;
        if (aVar == null) {
            this.g.add(new a() {
                public void a(a aVar) {
                    b.this.b(f2);
                }
            });
        } else {
            b((int) f.a(aVar.f(), this.h.g(), f2));
        }
    }

    public void d(final String str) {
        a aVar = this.h;
        if (aVar == null) {
            this.g.add(new a() {
                public void a(a aVar) {
                    b.this.d(str);
                }
            });
            return;
        }
        h c2 = aVar.c(str);
        if (c2 != null) {
            int i2 = (int) c2.f2423b;
            a(i2, ((int) c2.c) + i2);
            return;
        }
        throw new IllegalArgumentException("Cannot find marker with name " + str + ".");
    }

    public void a(final int i2, final int i3) {
        if (this.h == null) {
            this.g.add(new a() {
                public void a(a aVar) {
                    b.this.a(i2, i3);
                }
            });
        } else {
            this.e.a((float) i2, ((float) i3) + 0.99f);
        }
    }

    public float j() {
        return this.e.h();
    }

    public void c(float f2) {
        this.e.a(f2);
    }

    public int k() {
        return (int) this.e.e();
    }

    public void c(final int i2) {
        if (this.h == null) {
            this.g.add(new a() {
                public void a(a aVar) {
                    b.this.c(i2);
                }
            });
        } else {
            this.e.a(i2);
        }
    }

    public int l() {
        return this.e.getRepeatMode();
    }

    public void d(int i2) {
        this.e.setRepeatMode(i2);
    }

    public int m() {
        return this.e.getRepeatCount();
    }

    public void e(int i2) {
        this.e.setRepeatCount(i2);
    }

    public boolean n() {
        return this.e.isRunning();
    }

    public void a(j jVar) {
        this.l = jVar;
        com.coloros.anim.b.b bVar = this.j;
        if (bVar != null) {
            bVar.a(jVar);
        }
    }

    public void a(i iVar) {
        this.f2327a = iVar;
        a aVar = this.m;
        if (aVar != null) {
            aVar.a(iVar);
        }
    }

    public p o() {
        return this.f2328b;
    }

    public void a(p pVar) {
        this.f2328b = pVar;
    }

    public boolean p() {
        return this.f2328b == null && this.h.j().size() > 0;
    }

    public float q() {
        return this.i;
    }

    public void d(float f2) {
        this.i = f2;
        w();
    }

    public a r() {
        return this.h;
    }

    private void w() {
        if (this.h != null) {
            float q2 = q();
            setBounds(0, 0, (int) (((float) this.h.d().width()) * q2), (int) (((float) this.h.d().height()) * q2));
        }
    }

    public void s() {
        this.g.clear();
        this.e.cancel();
    }

    public void t() {
        this.g.clear();
        this.e.k();
    }

    public float u() {
        return this.e.d();
    }

    public void e(final float f2) {
        a aVar = this.h;
        if (aVar == null) {
            this.g.add(new a() {
                public void a(a aVar) {
                    b.this.e(f2);
                }
            });
        } else {
            c((int) f.a(aVar.f(), this.h.g(), f2));
        }
    }

    public int getIntrinsicWidth() {
        a aVar = this.h;
        if (aVar == null) {
            return -1;
        }
        return (int) (((float) aVar.d().width()) * q());
    }

    public int getIntrinsicHeight() {
        a aVar = this.h;
        if (aVar == null) {
            return -1;
        }
        return (int) (((float) aVar.d().height()) * q());
    }

    public List<com.coloros.anim.c.f> a(com.coloros.anim.c.f fVar) {
        if (this.o == null) {
            Log.w("EffectiveAnimation", "Cannot resolve KeyPath. Composition is not set yet.");
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        this.o.a(fVar, 0, (List<com.coloros.anim.c.f>) arrayList, new com.coloros.anim.c.f(new String[0]));
        return arrayList;
    }

    public <T> void a(final com.coloros.anim.c.f fVar, final T t, final com.coloros.anim.g.b<T> bVar) {
        if (this.o == null) {
            this.g.add(new a() {
                public void a(a aVar) {
                    b.this.a(fVar, t, bVar);
                }
            });
            return;
        }
        boolean z = true;
        if (fVar.a() != null) {
            fVar.a().a(t, bVar);
        } else {
            List<com.coloros.anim.c.f> a2 = a(fVar);
            for (int i2 = 0; i2 < a2.size(); i2++) {
                if (com.coloros.anim.f.b.c) {
                    com.coloros.anim.f.b.a("EffectiveAnimationDrawable::KeyPath = " + a2.get(i2));
                }
                a2.get(i2).a().a(t, bVar);
            }
            z = true ^ a2.isEmpty();
        }
        if (z) {
            invalidateSelf();
            if (t == d.y) {
                e(u());
            }
        }
    }

    public Bitmap e(String str) {
        com.coloros.anim.b.b x = x();
        if (x != null) {
            return x.a(str);
        }
        return null;
    }

    private com.coloros.anim.b.b x() {
        if (getCallback() == null) {
            return null;
        }
        com.coloros.anim.b.b bVar = this.j;
        if (bVar != null && !bVar.a(z())) {
            this.j = null;
        }
        if (this.j == null) {
            this.j = new com.coloros.anim.b.b(getCallback(), this.k, this.l, this.h.l());
        }
        return this.j;
    }

    public Typeface a(String str, String str2) {
        a y = y();
        if (y != null) {
            return y.a(str, str2);
        }
        return null;
    }

    private a y() {
        if (getCallback() == null) {
            return null;
        }
        if (this.m == null) {
            this.m = new a(getCallback(), this.f2327a);
        }
        return this.m;
    }

    private Context z() {
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

    private float a(Canvas canvas) {
        return Math.min(((float) canvas.getWidth()) / ((float) this.h.d().width()), ((float) canvas.getHeight()) / ((float) this.h.d().height()));
    }
}
