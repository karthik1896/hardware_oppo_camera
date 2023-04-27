package com.airbnb.lottie.c.c;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build;
import com.airbnb.lottie.a.a.e;
import com.airbnb.lottie.a.b.a;
import com.airbnb.lottie.a.b.c;
import com.airbnb.lottie.a.b.g;
import com.airbnb.lottie.a.b.o;
import com.airbnb.lottie.c.b.g;
import com.airbnb.lottie.c.b.l;
import com.airbnb.lottie.c.c.d;
import com.airbnb.lottie.c.f;
import com.airbnb.lottie.d;
import com.airbnb.lottie.f.h;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: BaseLayer */
public abstract class a implements e, a.C0053a, f {

    /* renamed from: a  reason: collision with root package name */
    final Matrix f1703a = new Matrix();

    /* renamed from: b  reason: collision with root package name */
    final com.airbnb.lottie.f f1704b;
    final d c;
    final o d;
    private final Path e = new Path();
    private final Matrix f = new Matrix();
    private final Paint g = new com.airbnb.lottie.a.a(1);
    private final Paint h = new com.airbnb.lottie.a.a(1, PorterDuff.Mode.DST_IN);
    private final Paint i = new com.airbnb.lottie.a.a(1, PorterDuff.Mode.DST_OUT);
    private final Paint j = new com.airbnb.lottie.a.a(1);
    private final Paint k = new com.airbnb.lottie.a.a(PorterDuff.Mode.CLEAR);
    private final RectF l = new RectF();
    private final RectF m = new RectF();
    private final RectF n = new RectF();
    private final RectF o = new RectF();
    private final String p;
    private g q;
    /* access modifiers changed from: private */
    public c r;
    private a s;
    private a t;
    private List<a> u;
    private final List<com.airbnb.lottie.a.b.a<?, ?>> v = new ArrayList();
    private boolean w = true;

    public void a(List<com.airbnb.lottie.a.a.c> list, List<com.airbnb.lottie.a.a.c> list2) {
    }

    /* access modifiers changed from: package-private */
    public abstract void b(Canvas canvas, Matrix matrix, int i2);

    /* access modifiers changed from: package-private */
    public void b(com.airbnb.lottie.c.e eVar, int i2, List<com.airbnb.lottie.c.e> list, com.airbnb.lottie.c.e eVar2) {
    }

    static a a(d dVar, com.airbnb.lottie.f fVar, d dVar2) {
        switch (dVar.k()) {
            case SHAPE:
                return new f(fVar, dVar);
            case PRE_COMP:
                return new b(fVar, dVar, dVar2.b(dVar.g()), dVar2);
            case SOLID:
                return new g(fVar, dVar);
            case IMAGE:
                return new c(fVar, dVar);
            case NULL:
                return new e(fVar, dVar);
            case TEXT:
                return new h(fVar, dVar);
            default:
                com.airbnb.lottie.f.d.b("Unknown layer type " + dVar.k());
                return null;
        }
    }

    a(com.airbnb.lottie.f fVar, d dVar) {
        this.f1704b = fVar;
        this.c = dVar;
        this.p = dVar.f() + "#draw";
        if (dVar.l() == d.b.INVERT) {
            this.j.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        } else {
            this.j.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        }
        this.d = dVar.o().j();
        this.d.a((a.C0053a) this);
        if (dVar.j() != null && !dVar.j().isEmpty()) {
            this.q = new g(dVar.j());
            for (com.airbnb.lottie.a.b.a<l, Path> a2 : this.q.b()) {
                a2.a((a.C0053a) this);
            }
            for (com.airbnb.lottie.a.b.a next : this.q.c()) {
                a((com.airbnb.lottie.a.b.a<?, ?>) next);
                next.a((a.C0053a) this);
            }
        }
        f();
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
            this.r = new c(this.c.d());
            this.r.a();
            this.r.a((a.C0053a) new a.C0053a() {
                public void a() {
                    a aVar = a.this;
                    aVar.a(aVar.r.i() == 1.0f);
                }
            });
            if (((Float) this.r.g()).floatValue() != 1.0f) {
                z = false;
            }
            a(z);
            a((com.airbnb.lottie.a.b.a<?, ?>) this.r);
            return;
        }
        a(true);
    }

    private void g() {
        this.f1704b.invalidateSelf();
    }

    public void a(com.airbnb.lottie.a.b.a<?, ?> aVar) {
        if (aVar != null) {
            this.v.add(aVar);
        }
    }

    public void b(com.airbnb.lottie.a.b.a<?, ?> aVar) {
        this.v.remove(aVar);
    }

    public void a(RectF rectF, Matrix matrix, boolean z) {
        this.l.set(0.0f, 0.0f, 0.0f, 0.0f);
        i();
        this.f1703a.set(matrix);
        if (z) {
            List<a> list = this.u;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.f1703a.preConcat(this.u.get(size).d.d());
                }
            } else {
                a aVar = this.t;
                if (aVar != null) {
                    this.f1703a.preConcat(aVar.d.d());
                }
            }
        }
        this.f1703a.preConcat(this.d.d());
    }

    public void a(Canvas canvas, Matrix matrix, int i2) {
        com.airbnb.lottie.c.a(this.p);
        if (!this.w || this.c.v()) {
            com.airbnb.lottie.c.b(this.p);
            return;
        }
        i();
        com.airbnb.lottie.c.a("Layer#parentMatrix");
        this.f.reset();
        this.f.set(matrix);
        for (int size = this.u.size() - 1; size >= 0; size--) {
            this.f.preConcat(this.u.get(size).d.d());
        }
        com.airbnb.lottie.c.b("Layer#parentMatrix");
        int intValue = (int) ((((((float) i2) / 255.0f) * ((float) (this.d.a() == null ? 100 : this.d.a().g().intValue()))) / 100.0f) * 255.0f);
        if (d() || e()) {
            com.airbnb.lottie.c.a("Layer#computeBounds");
            a(this.l, this.f, false);
            b(this.l, matrix);
            this.f.preConcat(this.d.d());
            a(this.l, this.f);
            if (!this.l.intersect(0.0f, 0.0f, (float) canvas.getWidth(), (float) canvas.getHeight())) {
                this.l.set(0.0f, 0.0f, 0.0f, 0.0f);
            }
            com.airbnb.lottie.c.b("Layer#computeBounds");
            if (!this.l.isEmpty()) {
                com.airbnb.lottie.c.a("Layer#saveLayer");
                this.g.setAlpha(255);
                h.a(canvas, this.l, this.g);
                com.airbnb.lottie.c.b("Layer#saveLayer");
                a(canvas);
                com.airbnb.lottie.c.a("Layer#drawLayer");
                b(canvas, this.f, intValue);
                com.airbnb.lottie.c.b("Layer#drawLayer");
                if (e()) {
                    a(canvas, this.f);
                }
                if (d()) {
                    com.airbnb.lottie.c.a("Layer#drawMatte");
                    com.airbnb.lottie.c.a("Layer#saveLayer");
                    h.a(canvas, this.l, this.j, 19);
                    com.airbnb.lottie.c.b("Layer#saveLayer");
                    a(canvas);
                    this.s.a(canvas, matrix, intValue);
                    com.airbnb.lottie.c.a("Layer#restoreLayer");
                    canvas.restore();
                    com.airbnb.lottie.c.b("Layer#restoreLayer");
                    com.airbnb.lottie.c.b("Layer#drawMatte");
                }
                com.airbnb.lottie.c.a("Layer#restoreLayer");
                canvas.restore();
                com.airbnb.lottie.c.b("Layer#restoreLayer");
            }
            b(com.airbnb.lottie.c.b(this.p));
            return;
        }
        this.f.preConcat(this.d.d());
        com.airbnb.lottie.c.a("Layer#drawLayer");
        b(canvas, this.f, intValue);
        com.airbnb.lottie.c.b("Layer#drawLayer");
        b(com.airbnb.lottie.c.b(this.p));
    }

    private void b(float f2) {
        this.f1704b.s().c().a(this.c.f(), f2);
    }

    private void a(Canvas canvas) {
        com.airbnb.lottie.c.a("Layer#clearLayer");
        canvas.drawRect(this.l.left - 1.0f, this.l.top - 1.0f, this.l.right + 1.0f, this.l.bottom + 1.0f, this.k);
        com.airbnb.lottie.c.b("Layer#clearLayer");
    }

    private void a(RectF rectF, Matrix matrix) {
        this.m.set(0.0f, 0.0f, 0.0f, 0.0f);
        if (e()) {
            int size = this.q.a().size();
            int i2 = 0;
            while (i2 < size) {
                com.airbnb.lottie.c.b.g gVar = this.q.a().get(i2);
                this.e.set((Path) this.q.b().get(i2).g());
                this.e.transform(matrix);
                int i3 = AnonymousClass2.f1707b[gVar.a().ordinal()];
                if (i3 != 1 && i3 != 2) {
                    if ((i3 != 3 && i3 != 4) || !gVar.d()) {
                        this.e.computeBounds(this.o, false);
                        if (i2 == 0) {
                            this.m.set(this.o);
                        } else {
                            RectF rectF2 = this.m;
                            rectF2.set(Math.min(rectF2.left, this.o.left), Math.min(this.m.top, this.o.top), Math.max(this.m.right, this.o.right), Math.max(this.m.bottom, this.o.bottom));
                        }
                        i2++;
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
            if (!rectF.intersect(this.m)) {
                rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
            }
        }
    }

    /* renamed from: com.airbnb.lottie.c.c.a$2  reason: invalid class name */
    /* compiled from: BaseLayer */
    static /* synthetic */ class AnonymousClass2 {

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f1707b = new int[g.a.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(24:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|17|18|19|20|21|22|23|24|25|26|27|28|29|30|32) */
        /* JADX WARNING: Can't wrap try/catch for region: R(26:0|1|2|3|(2:5|6)|7|(2:9|10)|11|13|14|15|17|18|19|20|21|22|23|24|25|26|27|28|29|30|32) */
        /* JADX WARNING: Can't wrap try/catch for region: R(27:0|1|2|3|5|6|7|(2:9|10)|11|13|14|15|17|18|19|20|21|22|23|24|25|26|27|28|29|30|32) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0048 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0052 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x005c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0066 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0071 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x007c */
        static {
            /*
                com.airbnb.lottie.c.b.g$a[] r0 = com.airbnb.lottie.c.b.g.a.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f1707b = r0
                r0 = 1
                int[] r1 = f1707b     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.airbnb.lottie.c.b.g$a r2 = com.airbnb.lottie.c.b.g.a.MASK_MODE_NONE     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                r1 = 2
                int[] r2 = f1707b     // Catch:{ NoSuchFieldError -> 0x001f }
                com.airbnb.lottie.c.b.g$a r3 = com.airbnb.lottie.c.b.g.a.MASK_MODE_SUBTRACT     // Catch:{ NoSuchFieldError -> 0x001f }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                r2 = 3
                int[] r3 = f1707b     // Catch:{ NoSuchFieldError -> 0x002a }
                com.airbnb.lottie.c.b.g$a r4 = com.airbnb.lottie.c.b.g.a.MASK_MODE_INTERSECT     // Catch:{ NoSuchFieldError -> 0x002a }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                r3 = 4
                int[] r4 = f1707b     // Catch:{ NoSuchFieldError -> 0x0035 }
                com.airbnb.lottie.c.b.g$a r5 = com.airbnb.lottie.c.b.g.a.MASK_MODE_ADD     // Catch:{ NoSuchFieldError -> 0x0035 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                com.airbnb.lottie.c.c.d$a[] r4 = com.airbnb.lottie.c.c.d.a.values()
                int r4 = r4.length
                int[] r4 = new int[r4]
                f1706a = r4
                int[] r4 = f1706a     // Catch:{ NoSuchFieldError -> 0x0048 }
                com.airbnb.lottie.c.c.d$a r5 = com.airbnb.lottie.c.c.d.a.SHAPE     // Catch:{ NoSuchFieldError -> 0x0048 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0048 }
                r4[r5] = r0     // Catch:{ NoSuchFieldError -> 0x0048 }
            L_0x0048:
                int[] r0 = f1706a     // Catch:{ NoSuchFieldError -> 0x0052 }
                com.airbnb.lottie.c.c.d$a r4 = com.airbnb.lottie.c.c.d.a.PRE_COMP     // Catch:{ NoSuchFieldError -> 0x0052 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0052 }
                r0[r4] = r1     // Catch:{ NoSuchFieldError -> 0x0052 }
            L_0x0052:
                int[] r0 = f1706a     // Catch:{ NoSuchFieldError -> 0x005c }
                com.airbnb.lottie.c.c.d$a r1 = com.airbnb.lottie.c.c.d.a.SOLID     // Catch:{ NoSuchFieldError -> 0x005c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x005c }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x005c }
            L_0x005c:
                int[] r0 = f1706a     // Catch:{ NoSuchFieldError -> 0x0066 }
                com.airbnb.lottie.c.c.d$a r1 = com.airbnb.lottie.c.c.d.a.IMAGE     // Catch:{ NoSuchFieldError -> 0x0066 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0066 }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x0066 }
            L_0x0066:
                int[] r0 = f1706a     // Catch:{ NoSuchFieldError -> 0x0071 }
                com.airbnb.lottie.c.c.d$a r1 = com.airbnb.lottie.c.c.d.a.NULL     // Catch:{ NoSuchFieldError -> 0x0071 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0071 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0071 }
            L_0x0071:
                int[] r0 = f1706a     // Catch:{ NoSuchFieldError -> 0x007c }
                com.airbnb.lottie.c.c.d$a r1 = com.airbnb.lottie.c.c.d.a.TEXT     // Catch:{ NoSuchFieldError -> 0x007c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x007c }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x007c }
            L_0x007c:
                int[] r0 = f1706a     // Catch:{ NoSuchFieldError -> 0x0087 }
                com.airbnb.lottie.c.c.d$a r1 = com.airbnb.lottie.c.c.d.a.UNKNOWN     // Catch:{ NoSuchFieldError -> 0x0087 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0087 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0087 }
            L_0x0087:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.c.c.a.AnonymousClass2.<clinit>():void");
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
        com.airbnb.lottie.c.a("Layer#saveLayer");
        h.a(canvas, this.l, this.h, 19);
        if (Build.VERSION.SDK_INT < 28) {
            a(canvas);
        }
        com.airbnb.lottie.c.b("Layer#saveLayer");
        for (int i2 = 0; i2 < this.q.a().size(); i2++) {
            com.airbnb.lottie.c.b.g gVar = this.q.a().get(i2);
            com.airbnb.lottie.a.b.a aVar = this.q.b().get(i2);
            com.airbnb.lottie.a.b.a aVar2 = this.q.c().get(i2);
            int i3 = AnonymousClass2.f1707b[gVar.a().ordinal()];
            if (i3 != 1) {
                if (i3 == 2) {
                    if (i2 == 0) {
                        this.g.setColor(-16777216);
                        this.g.setAlpha(255);
                        canvas.drawRect(this.l, this.g);
                    }
                    if (gVar.d()) {
                        d(canvas, matrix, gVar, aVar, aVar2);
                    } else {
                        c(canvas, matrix, gVar, aVar, aVar2);
                    }
                } else if (i3 != 3) {
                    if (i3 == 4) {
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
            } else if (h()) {
                this.g.setAlpha(255);
                canvas.drawRect(this.l, this.g);
            }
        }
        com.airbnb.lottie.c.a("Layer#restoreLayer");
        canvas.restore();
        com.airbnb.lottie.c.b("Layer#restoreLayer");
    }

    private boolean h() {
        if (this.q.b().isEmpty()) {
            return false;
        }
        for (int i2 = 0; i2 < this.q.a().size(); i2++) {
            if (this.q.a().get(i2).a() != g.a.MASK_MODE_NONE) {
                return false;
            }
        }
        return true;
    }

    private void a(Canvas canvas, Matrix matrix, com.airbnb.lottie.c.b.g gVar, com.airbnb.lottie.a.b.a<l, Path> aVar, com.airbnb.lottie.a.b.a<Integer, Integer> aVar2) {
        this.e.set(aVar.g());
        this.e.transform(matrix);
        this.g.setAlpha((int) (((float) aVar2.g().intValue()) * 2.55f));
        canvas.drawPath(this.e, this.g);
    }

    private void b(Canvas canvas, Matrix matrix, com.airbnb.lottie.c.b.g gVar, com.airbnb.lottie.a.b.a<l, Path> aVar, com.airbnb.lottie.a.b.a<Integer, Integer> aVar2) {
        h.a(canvas, this.l, this.g);
        canvas.drawRect(this.l, this.g);
        this.e.set(aVar.g());
        this.e.transform(matrix);
        this.g.setAlpha((int) (((float) aVar2.g().intValue()) * 2.55f));
        canvas.drawPath(this.e, this.i);
        canvas.restore();
    }

    private void c(Canvas canvas, Matrix matrix, com.airbnb.lottie.c.b.g gVar, com.airbnb.lottie.a.b.a<l, Path> aVar, com.airbnb.lottie.a.b.a<Integer, Integer> aVar2) {
        this.e.set(aVar.g());
        this.e.transform(matrix);
        canvas.drawPath(this.e, this.i);
    }

    private void d(Canvas canvas, Matrix matrix, com.airbnb.lottie.c.b.g gVar, com.airbnb.lottie.a.b.a<l, Path> aVar, com.airbnb.lottie.a.b.a<Integer, Integer> aVar2) {
        h.a(canvas, this.l, this.i);
        canvas.drawRect(this.l, this.g);
        this.i.setAlpha((int) (((float) aVar2.g().intValue()) * 2.55f));
        this.e.set(aVar.g());
        this.e.transform(matrix);
        canvas.drawPath(this.e, this.i);
        canvas.restore();
    }

    private void e(Canvas canvas, Matrix matrix, com.airbnb.lottie.c.b.g gVar, com.airbnb.lottie.a.b.a<l, Path> aVar, com.airbnb.lottie.a.b.a<Integer, Integer> aVar2) {
        h.a(canvas, this.l, this.h);
        this.e.set(aVar.g());
        this.e.transform(matrix);
        this.g.setAlpha((int) (((float) aVar2.g().intValue()) * 2.55f));
        canvas.drawPath(this.e, this.g);
        canvas.restore();
    }

    private void f(Canvas canvas, Matrix matrix, com.airbnb.lottie.c.b.g gVar, com.airbnb.lottie.a.b.a<l, Path> aVar, com.airbnb.lottie.a.b.a<Integer, Integer> aVar2) {
        h.a(canvas, this.l, this.h);
        canvas.drawRect(this.l, this.g);
        this.i.setAlpha((int) (((float) aVar2.g().intValue()) * 2.55f));
        this.e.set(aVar.g());
        this.e.transform(matrix);
        canvas.drawPath(this.e, this.i);
        canvas.restore();
    }

    /* access modifiers changed from: package-private */
    public boolean e() {
        com.airbnb.lottie.a.b.g gVar = this.q;
        return gVar != null && !gVar.b().isEmpty();
    }

    /* access modifiers changed from: private */
    public void a(boolean z) {
        if (z != this.w) {
            this.w = z;
            g();
        }
    }

    /* access modifiers changed from: package-private */
    public void a(float f2) {
        this.d.a(f2);
        if (this.q != null) {
            for (int i2 = 0; i2 < this.q.b().size(); i2++) {
                this.q.b().get(i2).a(f2);
            }
        }
        if (this.c.b() != 0.0f) {
            f2 /= this.c.b();
        }
        c cVar = this.r;
        if (cVar != null) {
            cVar.a(f2 / this.c.b());
        }
        a aVar = this.s;
        if (aVar != null) {
            this.s.a(aVar.c.b() * f2);
        }
        for (int i3 = 0; i3 < this.v.size(); i3++) {
            this.v.get(i3).a(f2);
        }
    }

    private void i() {
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

    public void a(com.airbnb.lottie.c.e eVar, int i2, List<com.airbnb.lottie.c.e> list, com.airbnb.lottie.c.e eVar2) {
        if (eVar.a(b(), i2)) {
            if (!"__container".equals(b())) {
                eVar2 = eVar2.a(b());
                if (eVar.c(b(), i2)) {
                    list.add(eVar2.a((f) this));
                }
            }
            if (eVar.d(b(), i2)) {
                b(eVar, i2 + eVar.b(b(), i2), list, eVar2);
            }
        }
    }

    public <T> void a(T t2, com.airbnb.lottie.g.c<T> cVar) {
        this.d.a(t2, cVar);
    }
}
