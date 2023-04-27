package com.coloros.anim.c.b;

import android.graphics.Paint;
import com.coloros.anim.a.a.c;
import com.coloros.anim.a.a.r;
import com.coloros.anim.c.a.d;
import java.util.List;

/* compiled from: ShapeStroke */
public class p implements b {

    /* renamed from: a  reason: collision with root package name */
    private final String f2396a;

    /* renamed from: b  reason: collision with root package name */
    private final com.coloros.anim.c.a.b f2397b;
    private final List<com.coloros.anim.c.a.b> c;
    private final com.coloros.anim.c.a.a d;
    private final d e;
    private final com.coloros.anim.c.a.b f;
    private final a g;
    private final b h;
    private final float i;
    private final boolean j;

    public p(String str, com.coloros.anim.c.a.b bVar, List<com.coloros.anim.c.a.b> list, com.coloros.anim.c.a.a aVar, d dVar, com.coloros.anim.c.a.b bVar2, a aVar2, b bVar3, float f2, boolean z) {
        this.f2396a = str;
        this.f2397b = bVar;
        this.c = list;
        this.d = aVar;
        this.e = dVar;
        this.f = bVar2;
        this.g = aVar2;
        this.h = bVar3;
        this.i = f2;
        this.j = z;
    }

    public c a(com.coloros.anim.b bVar, com.coloros.anim.c.c.a aVar) {
        if (com.coloros.anim.f.b.d) {
            com.coloros.anim.f.b.b("ShapeStroke to StrokeContent, layer = " + aVar);
        }
        return new r(bVar, aVar, this);
    }

    public String a() {
        return this.f2396a;
    }

    public com.coloros.anim.c.a.a b() {
        return this.d;
    }

    public d c() {
        return this.e;
    }

    public com.coloros.anim.c.a.b d() {
        return this.f;
    }

    public List<com.coloros.anim.c.a.b> e() {
        return this.c;
    }

    public com.coloros.anim.c.a.b f() {
        return this.f2397b;
    }

    public a g() {
        return this.g;
    }

    public b h() {
        return this.h;
    }

    public float i() {
        return this.i;
    }

    public boolean j() {
        return this.j;
    }

    /* compiled from: ShapeStroke */
    public enum a {
        BUTT,
        ROUND,
        UNKNOWN;

        public Paint.Cap toPaintCap() {
            int i = AnonymousClass1.f2398a[ordinal()];
            if (i == 1) {
                return Paint.Cap.BUTT;
            }
            if (i != 2) {
                return Paint.Cap.SQUARE;
            }
            return Paint.Cap.ROUND;
        }
    }

    /* renamed from: com.coloros.anim.c.b.p$1  reason: invalid class name */
    /* compiled from: ShapeStroke */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f2398a = new int[a.values().length];

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f2399b = new int[b.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|13|14|15|16|17|18|20) */
        /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x003d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0047 */
        static {
            /*
                com.coloros.anim.c.b.p$b[] r0 = com.coloros.anim.c.b.p.b.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f2399b = r0
                r0 = 1
                int[] r1 = f2399b     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.coloros.anim.c.b.p$b r2 = com.coloros.anim.c.b.p.b.BEVEL     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                r1 = 2
                int[] r2 = f2399b     // Catch:{ NoSuchFieldError -> 0x001f }
                com.coloros.anim.c.b.p$b r3 = com.coloros.anim.c.b.p.b.MITER     // Catch:{ NoSuchFieldError -> 0x001f }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                r2 = 3
                int[] r3 = f2399b     // Catch:{ NoSuchFieldError -> 0x002a }
                com.coloros.anim.c.b.p$b r4 = com.coloros.anim.c.b.p.b.ROUND     // Catch:{ NoSuchFieldError -> 0x002a }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                com.coloros.anim.c.b.p$a[] r3 = com.coloros.anim.c.b.p.a.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                f2398a = r3
                int[] r3 = f2398a     // Catch:{ NoSuchFieldError -> 0x003d }
                com.coloros.anim.c.b.p$a r4 = com.coloros.anim.c.b.p.a.BUTT     // Catch:{ NoSuchFieldError -> 0x003d }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x003d }
                r3[r4] = r0     // Catch:{ NoSuchFieldError -> 0x003d }
            L_0x003d:
                int[] r0 = f2398a     // Catch:{ NoSuchFieldError -> 0x0047 }
                com.coloros.anim.c.b.p$a r3 = com.coloros.anim.c.b.p.a.ROUND     // Catch:{ NoSuchFieldError -> 0x0047 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0047 }
                r0[r3] = r1     // Catch:{ NoSuchFieldError -> 0x0047 }
            L_0x0047:
                int[] r0 = f2398a     // Catch:{ NoSuchFieldError -> 0x0051 }
                com.coloros.anim.c.b.p$a r1 = com.coloros.anim.c.b.p.a.UNKNOWN     // Catch:{ NoSuchFieldError -> 0x0051 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0051 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0051 }
            L_0x0051:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.coloros.anim.c.b.p.AnonymousClass1.<clinit>():void");
        }
    }

    /* compiled from: ShapeStroke */
    public enum b {
        MITER,
        ROUND,
        BEVEL;

        public Paint.Join toPaintJoin() {
            int i = AnonymousClass1.f2399b[ordinal()];
            if (i == 1) {
                return Paint.Join.BEVEL;
            }
            if (i == 2) {
                return Paint.Join.MITER;
            }
            if (i != 3) {
                return null;
            }
            return Paint.Join.ROUND;
        }
    }
}
