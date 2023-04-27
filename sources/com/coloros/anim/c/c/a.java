package com.coloros.anim.c.c;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build;
import com.coloros.anim.a.a.c;
import com.coloros.anim.a.a.e;
import com.coloros.anim.a.b.a;
import com.coloros.anim.a.b.o;
import com.coloros.anim.b;
import com.coloros.anim.c.b.g;
import com.coloros.anim.c.b.l;
import com.coloros.anim.c.c.d;
import com.coloros.anim.c.f;
import com.coloros.anim.c.g;
import com.coloros.anim.k;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: BaseLayer */
public abstract class a implements e, a.C0061a, g {

    /* renamed from: a  reason: collision with root package name */
    final Matrix f2404a = new Matrix();

    /* renamed from: b  reason: collision with root package name */
    final b f2405b;
    final d c;
    final o d;
    private final Path e = new Path();
    private final Matrix f = new Matrix();
    private final Paint g;
    private final Paint h;
    private final Paint i;
    private final Paint j;
    private final Paint k;
    private final RectF l;
    private final RectF m;
    private final RectF n;
    private final RectF o;
    private final String p;
    private final List<com.coloros.anim.a.b.a<?, ?>> q;
    private com.coloros.anim.a.b.g r;
    private a s;
    private a t;
    private List<a> u;
    private boolean v;

    public void a(List<c> list, List<c> list2) {
    }

    /* access modifiers changed from: package-private */
    public abstract void b(Canvas canvas, Matrix matrix, int i2);

    /* access modifiers changed from: package-private */
    public void b(f fVar, int i2, List<f> list, f fVar2) {
    }

    a(b bVar, d dVar) {
        boolean z = true;
        this.g = new com.coloros.anim.a.a(1);
        this.h = new com.coloros.anim.a.a(1, PorterDuff.Mode.DST_IN);
        this.i = new com.coloros.anim.a.a(1, PorterDuff.Mode.DST_OUT);
        this.j = new com.coloros.anim.a.a(1);
        this.k = new com.coloros.anim.a.a(PorterDuff.Mode.CLEAR);
        this.l = new RectF();
        this.m = new RectF();
        this.n = new RectF();
        this.o = new RectF();
        this.q = new ArrayList();
        this.v = true;
        this.f2405b = bVar;
        this.c = dVar;
        this.p = dVar.f() + "#draw";
        if (com.coloros.anim.f.b.d) {
            com.coloros.anim.f.b.b("BaseLayer::name = " + dVar.f() + ";layerModel.getMatteType() = " + dVar.l() + "; this = " + this);
        }
        if (dVar.l() == d.b.INVERT) {
            this.j.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        } else {
            this.j.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        }
        this.d = dVar.o().j();
        this.d.a((a.C0061a) this);
        if (com.coloros.anim.f.b.d) {
            StringBuilder sb = new StringBuilder();
            sb.append("BaseLayer::layerModel.getMasks() ? ");
            sb.append(dVar.j() != null ? false : z);
            com.coloros.anim.f.b.b(sb.toString());
        }
        if (dVar.j() != null && !dVar.j().isEmpty()) {
            this.r = new com.coloros.anim.a.b.g(dVar.j());
            for (com.coloros.anim.a.b.a<l, Path> a2 : this.r.b()) {
                a2.a((a.C0061a) this);
            }
            for (com.coloros.anim.a.b.a next : this.r.c()) {
                a((com.coloros.anim.a.b.a<?, ?>) next);
                next.a((a.C0061a) this);
            }
        }
        f();
    }

    static a a(d dVar, b bVar, com.coloros.anim.a aVar) {
        switch (dVar.k()) {
            case SHAPE:
                return new f(bVar, dVar);
            case PRE_COMP:
                return new b(bVar, dVar, aVar.b(dVar.g()), aVar);
            case SOLID:
                return new g(bVar, dVar);
            case IMAGE:
                return new c(bVar, dVar);
            case NULL:
                return new e(bVar, dVar);
            case TEXT:
                return new h(bVar, dVar);
            default:
                k.b("Unknown layer type " + dVar.k());
                return null;
        }
    }

    public void a() {
        g();
    }

    /* access modifiers changed from: package-private */
    public d c() {
        return this.c;
    }

    /* access modifiers changed from: package-private */
    public void a(a aVar) {
        this.s = aVar;
    }

    /* access modifiers changed from: package-private */
    public boolean d() {
        return this.s != null;
    }

    /* access modifiers changed from: package-private */
    public void b(a aVar) {
        this.t = aVar;
    }

    private void f() {
        boolean z = true;
        if (!this.c.d().isEmpty()) {
            final com.coloros.anim.a.b.c cVar = new com.coloros.anim.a.b.c(this.c.d());
            if (com.coloros.anim.f.b.d) {
                for (int i2 = 0; i2 < this.c.d().size(); i2++) {
                    com.coloros.anim.f.b.b("BaseLayer::create InOutAnimations, " + this.c.d().get(i2).toString());
                }
            }
            cVar.a();
            cVar.a((a.C0061a) new a.C0061a() {
                public void a() {
                    a.this.a(cVar.i() == 1.0f);
                }
            });
            if (((Float) cVar.g()).floatValue() != 1.0f) {
                z = false;
            }
            a(z);
            a((com.coloros.anim.a.b.a<?, ?>) cVar);
            return;
        }
        a(true);
    }

    private void g() {
        this.f2405b.invalidateSelf();
    }

    @SuppressLint({"WrongConstant"})
    private void a(Canvas canvas, RectF rectF, Paint paint, boolean z) {
        if (Build.VERSION.SDK_INT < 23) {
            canvas.saveLayer(rectF, paint, z ? 31 : 19);
        } else {
            canvas.saveLayer(rectF, paint);
        }
    }

    public void a(com.coloros.anim.a.b.a<?, ?> aVar) {
        if (aVar != null) {
            this.q.add(aVar);
        }
    }

    public void a(RectF rectF, Matrix matrix, boolean z) {
        this.l.set(0.0f, 0.0f, 0.0f, 0.0f);
        h();
        this.f2404a.set(matrix);
        if (z) {
            List<a> list = this.u;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.f2404a.preConcat(this.u.get(size).d.d());
                }
            } else {
                a aVar = this.t;
                if (aVar != null) {
                    this.f2404a.preConcat(aVar.d.d());
                }
            }
        }
        this.f2404a.preConcat(this.d.d());
    }

    public void a(Canvas canvas, Matrix matrix, int i2) {
        k.c(this.p);
        if (!this.v || this.c.v()) {
            k.d(this.p);
            return;
        }
        h();
        k.c("Layer#parentMatrix");
        this.f.reset();
        this.f.set(matrix);
        for (int size = this.u.size() - 1; size >= 0; size--) {
            this.f.preConcat(this.u.get(size).d.d());
        }
        k.d("Layer#parentMatrix");
        int intValue = (int) ((((((float) i2) / 255.0f) * ((float) (this.d.a() == null ? 100 : this.d.a().g().intValue()))) / 100.0f) * 255.0f);
        if (d() || e()) {
            k.c("Layer#computeBounds");
            a(this.l, this.f, false);
            b(this.l, matrix);
            this.f.preConcat(this.d.d());
            a(this.l, this.f);
            k.d("Layer#computeBounds");
            if (!this.l.isEmpty()) {
                k.c("Layer#saveLayer");
                a(canvas, this.l, this.g, true);
                k.d("Layer#saveLayer");
                a(canvas);
                k.c("Layer#drawLayer");
                b(canvas, this.f, intValue);
                k.d("Layer#drawLayer");
                if (e()) {
                    a(canvas, this.f);
                }
                if (d()) {
                    k.c("Layer#drawMatte");
                    k.c("Layer#saveLayer");
                    a(canvas, this.l, this.j, false);
                    k.d("Layer#saveLayer");
                    a(canvas);
                    this.s.a(canvas, matrix, intValue);
                    k.c("Layer#restoreLayer");
                    canvas.restore();
                    k.d("Layer#restoreLayer");
                    k.d("Layer#drawMatte");
                }
                k.c("Layer#restoreLayer");
                canvas.restore();
                k.d("Layer#restoreLayer");
            }
            float d2 = k.d(this.p);
            k.a(this.p + " draw end,time = " + d2);
            b(d2);
            return;
        }
        this.f.preConcat(this.d.d());
        k.c("Layer#drawLayer");
        b(canvas, this.f, intValue);
        k.d("Layer#drawLayer");
        float d3 = k.d(this.p);
        k.a(this.p + " draw end time = " + d3);
        b(d3);
    }

    private void b(float f2) {
        this.f2405b.r().c().a(this.c.f(), f2);
    }

    private void a(Canvas canvas) {
        k.c("Layer#clearLayer");
        canvas.drawRect(this.l.left - 1.0f, this.l.top - 1.0f, this.l.right + 1.0f, this.l.bottom + 1.0f, this.k);
        k.d("Layer#clearLayer");
    }

    private void a(RectF rectF, Matrix matrix) {
        this.m.set(0.0f, 0.0f, 0.0f, 0.0f);
        if (e()) {
            int size = this.r.a().size();
            int i2 = 0;
            while (i2 < size) {
                com.coloros.anim.c.b.g gVar = this.r.a().get(i2);
                this.e.set((Path) this.r.b().get(i2).g());
                this.e.transform(matrix);
                int i3 = AnonymousClass2.f2409b[gVar.a().ordinal()];
                if (i3 != 1) {
                    if (i3 != 2 && i3 != 3) {
                        this.e.computeBounds(this.o, false);
                        if (i2 == 0) {
                            this.m.set(this.o);
                        } else {
                            RectF rectF2 = this.m;
                            rectF2.set(Math.min(rectF2.left, this.o.left), Math.min(this.m.top, this.o.top), Math.max(this.m.right, this.o.right), Math.max(this.m.bottom, this.o.bottom));
                        }
                    } else if (!gVar.d()) {
                        this.e.computeBounds(this.o, false);
                        if (i2 == 0) {
                            this.m.set(this.o);
                        } else {
                            RectF rectF3 = this.m;
                            rectF3.set(Math.min(rectF3.left, this.o.left), Math.min(this.m.top, this.o.top), Math.max(this.m.right, this.o.right), Math.max(this.m.bottom, this.o.bottom));
                        }
                    } else {
                        return;
                    }
                    i2++;
                } else {
                    return;
                }
            }
            if (!rectF.intersect(this.m)) {
                rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
            }
        }
    }

    /* renamed from: com.coloros.anim.c.c.a$2  reason: invalid class name */
    /* compiled from: BaseLayer */
    static /* synthetic */ class AnonymousClass2 {

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f2409b = new int[g.a.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(22:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|13|14|15|16|17|18|19|20|21|22|23|24|25|26|28) */
        /* JADX WARNING: Can't wrap try/catch for region: R(23:0|1|2|3|(2:5|6)|7|(2:9|10)|11|13|14|15|16|17|18|19|20|21|22|23|24|25|26|28) */
        /* JADX WARNING: Can't wrap try/catch for region: R(24:0|1|2|3|5|6|7|(2:9|10)|11|13|14|15|16|17|18|19|20|21|22|23|24|25|26|28) */
        /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x003d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0047 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0051 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x005c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0067 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0072 */
        static {
            /*
                com.coloros.anim.c.b.g$a[] r0 = com.coloros.anim.c.b.g.a.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f2409b = r0
                r0 = 1
                int[] r1 = f2409b     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.coloros.anim.c.b.g$a r2 = com.coloros.anim.c.b.g.a.MASK_MODE_SUBTRACT     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                r1 = 2
                int[] r2 = f2409b     // Catch:{ NoSuchFieldError -> 0x001f }
                com.coloros.anim.c.b.g$a r3 = com.coloros.anim.c.b.g.a.MASK_MODE_INTERSECT     // Catch:{ NoSuchFieldError -> 0x001f }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                r2 = 3
                int[] r3 = f2409b     // Catch:{ NoSuchFieldError -> 0x002a }
                com.coloros.anim.c.b.g$a r4 = com.coloros.anim.c.b.g.a.MASK_MODE_ADD     // Catch:{ NoSuchFieldError -> 0x002a }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                com.coloros.anim.c.c.d$a[] r3 = com.coloros.anim.c.c.d.a.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                f2408a = r3
                int[] r3 = f2408a     // Catch:{ NoSuchFieldError -> 0x003d }
                com.coloros.anim.c.c.d$a r4 = com.coloros.anim.c.c.d.a.SHAPE     // Catch:{ NoSuchFieldError -> 0x003d }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x003d }
                r3[r4] = r0     // Catch:{ NoSuchFieldError -> 0x003d }
            L_0x003d:
                int[] r0 = f2408a     // Catch:{ NoSuchFieldError -> 0x0047 }
                com.coloros.anim.c.c.d$a r3 = com.coloros.anim.c.c.d.a.PRE_COMP     // Catch:{ NoSuchFieldError -> 0x0047 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0047 }
                r0[r3] = r1     // Catch:{ NoSuchFieldError -> 0x0047 }
            L_0x0047:
                int[] r0 = f2408a     // Catch:{ NoSuchFieldError -> 0x0051 }
                com.coloros.anim.c.c.d$a r1 = com.coloros.anim.c.c.d.a.SOLID     // Catch:{ NoSuchFieldError -> 0x0051 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0051 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0051 }
            L_0x0051:
                int[] r0 = f2408a     // Catch:{ NoSuchFieldError -> 0x005c }
                com.coloros.anim.c.c.d$a r1 = com.coloros.anim.c.c.d.a.IMAGE     // Catch:{ NoSuchFieldError -> 0x005c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x005c }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x005c }
            L_0x005c:
                int[] r0 = f2408a     // Catch:{ NoSuchFieldError -> 0x0067 }
                com.coloros.anim.c.c.d$a r1 = com.coloros.anim.c.c.d.a.NULL     // Catch:{ NoSuchFieldError -> 0x0067 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0067 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0067 }
            L_0x0067:
                int[] r0 = f2408a     // Catch:{ NoSuchFieldError -> 0x0072 }
                com.coloros.anim.c.c.d$a r1 = com.coloros.anim.c.c.d.a.TEXT     // Catch:{ NoSuchFieldError -> 0x0072 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0072 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0072 }
            L_0x0072:
                int[] r0 = f2408a     // Catch:{ NoSuchFieldError -> 0x007d }
                com.coloros.anim.c.c.d$a r1 = com.coloros.anim.c.c.d.a.UNKNOWN     // Catch:{ NoSuchFieldError -> 0x007d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x007d }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x007d }
            L_0x007d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.coloros.anim.c.c.a.AnonymousClass2.<clinit>():void");
        }
    }

    private void b(RectF rectF, Matrix matrix) {
        if (d() && this.c.l() != d.b.INVERT) {
            this.n.set(0.0f, 0.0f, 0.0f, 0.0f);
            this.s.a(this.n, matrix, true);
            if (!rectF.intersect(this.n)) {
                rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
            }
        }
    }

    private void a(Canvas canvas, Matrix matrix) {
        k.c("Layer#saveLayer");
        a(canvas, this.l, this.h, false);
        k.d("Layer#saveLayer");
        for (int i2 = 0; i2 < this.r.a().size(); i2++) {
            com.coloros.anim.c.b.g gVar = this.r.a().get(i2);
            com.coloros.anim.a.b.a aVar = this.r.b().get(i2);
            com.coloros.anim.a.b.a aVar2 = this.r.c().get(i2);
            int i3 = AnonymousClass2.f2409b[gVar.a().ordinal()];
            if (i3 == 1) {
                if (i2 == 0) {
                    Paint paint = new Paint();
                    paint.setColor(-16777216);
                    canvas.drawRect(this.l, paint);
                }
                if (gVar.d()) {
                    d(canvas, matrix, gVar, aVar, aVar2);
                } else {
                    c(canvas, matrix, gVar, aVar, aVar2);
                }
            } else if (i3 != 2) {
                if (i3 == 3) {
                    if (gVar.d()) {
                        b(canvas, matrix, gVar, aVar, aVar2);
                    } else {
                        a(canvas, matrix, gVar, aVar, aVar2);
                    }
                }
            } else if (gVar.d()) {
                f(canvas, matrix, gVar, aVar, aVar2);
            } else {
                e(canvas, matrix, gVar, aVar, aVar2);
            }
        }
        k.c("Layer#restoreLayer");
        canvas.restore();
        k.d("Layer#restoreLayer");
    }

    private void a(Canvas canvas, Matrix matrix, com.coloros.anim.c.b.g gVar, com.coloros.anim.a.b.a<l, Path> aVar, com.coloros.anim.a.b.a<Integer, Integer> aVar2) {
        this.e.set(aVar.g());
        this.e.transform(matrix);
        this.g.setAlpha((int) (((float) aVar2.g().intValue()) * 2.55f));
        canvas.drawPath(this.e, this.g);
    }

    private void b(Canvas canvas, Matrix matrix, com.coloros.anim.c.b.g gVar, com.coloros.anim.a.b.a<l, Path> aVar, com.coloros.anim.a.b.a<Integer, Integer> aVar2) {
        a(canvas, this.l, this.g, true);
        canvas.drawRect(this.l, this.g);
        this.e.set(aVar.g());
        this.e.transform(matrix);
        this.g.setAlpha((int) (((float) aVar2.g().intValue()) * 2.55f));
        canvas.drawPath(this.e, this.i);
        canvas.restore();
    }

    private void c(Canvas canvas, Matrix matrix, com.coloros.anim.c.b.g gVar, com.coloros.anim.a.b.a<l, Path> aVar, com.coloros.anim.a.b.a<Integer, Integer> aVar2) {
        this.e.set(aVar.g());
        this.e.transform(matrix);
        canvas.drawPath(this.e, this.i);
    }

    private void d(Canvas canvas, Matrix matrix, com.coloros.anim.c.b.g gVar, com.coloros.anim.a.b.a<l, Path> aVar, com.coloros.anim.a.b.a<Integer, Integer> aVar2) {
        a(canvas, this.l, this.i, true);
        canvas.drawRect(this.l, this.g);
        this.i.setAlpha((int) (((float) aVar2.g().intValue()) * 2.55f));
        this.e.set(aVar.g());
        this.e.transform(matrix);
        canvas.drawPath(this.e, this.i);
        canvas.restore();
    }

    private void e(Canvas canvas, Matrix matrix, com.coloros.anim.c.b.g gVar, com.coloros.anim.a.b.a<l, Path> aVar, com.coloros.anim.a.b.a<Integer, Integer> aVar2) {
        a(canvas, this.l, this.h, true);
        this.e.set(aVar.g());
        this.e.transform(matrix);
        this.g.setAlpha((int) (((float) aVar2.g().intValue()) * 2.55f));
        canvas.drawPath(this.e, this.g);
        canvas.restore();
    }

    private void f(Canvas canvas, Matrix matrix, com.coloros.anim.c.b.g gVar, com.coloros.anim.a.b.a<l, Path> aVar, com.coloros.anim.a.b.a<Integer, Integer> aVar2) {
        a(canvas, this.l, this.h, true);
        canvas.drawRect(this.l, this.g);
        this.i.setAlpha((int) (((float) aVar2.g().intValue()) * 2.55f));
        this.e.set(aVar.g());
        this.e.transform(matrix);
        canvas.drawPath(this.e, this.i);
        canvas.restore();
    }

    /* access modifiers changed from: package-private */
    public boolean e() {
        com.coloros.anim.a.b.g gVar = this.r;
        return gVar != null && !gVar.b().isEmpty();
    }

    public void a(boolean z) {
        if (z != this.v) {
            this.v = z;
            g();
        }
    }

    /* access modifiers changed from: package-private */
    public void a(float f2) {
        this.d.a(f2);
        if (this.r != null) {
            for (int i2 = 0; i2 < this.r.b().size(); i2++) {
                this.r.b().get(i2).a(f2);
            }
        }
        if (this.c.b() != 0.0f) {
            f2 /= this.c.b();
        }
        a aVar = this.s;
        if (aVar != null) {
            this.s.a(aVar.c.b() * f2);
        }
        for (int i3 = 0; i3 < this.q.size(); i3++) {
            this.q.get(i3).a(f2);
        }
    }

    private void h() {
        if (this.u == null) {
            if (this.t == null) {
                this.u = Collections.emptyList();
                return;
            }
            this.u = new ArrayList();
            for (a aVar = this.t; aVar != null; aVar = aVar.t) {
                this.u.add(aVar);
            }
        }
    }

    public String b() {
        return this.c.f();
    }

    public void a(f fVar, int i2, List<f> list, f fVar2) {
        if (com.coloros.anim.f.b.c) {
            com.coloros.anim.f.b.b("BaseLayer::resolveKeyPath()::this = " + b() + "; keyPath = " + fVar.toString());
        }
        if (fVar.a(b(), i2)) {
            if (!"__container".equals(b())) {
                fVar2 = fVar2.a(b());
                if (fVar.c(b(), i2)) {
                    if (com.coloros.anim.f.b.c) {
                        com.coloros.anim.f.b.b("BaseLayer::resolveKeyPath()::name = " + b());
                    }
                    list.add(fVar2.a((com.coloros.anim.c.g) this));
                }
            }
            if (fVar.d(b(), i2)) {
                int b2 = i2 + fVar.b(b(), i2);
                if (com.coloros.anim.f.b.c) {
                    com.coloros.anim.f.b.b("BaseLayer::resolveKeyPath()::newDepth = " + b2);
                }
                b(fVar, b2, list, fVar2);
            }
        }
    }

    public <T> void a(T t2, com.coloros.anim.g.b<T> bVar) {
        this.d.a(t2, bVar);
    }
}
