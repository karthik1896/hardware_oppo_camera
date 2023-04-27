package com.coloros.anim.c.c;

import com.coloros.anim.c.a.j;
import com.coloros.anim.c.a.k;
import com.coloros.anim.c.a.l;
import com.coloros.anim.c.b.g;
import com.coloros.anim.g.c;
import java.util.List;
import java.util.Locale;

/* compiled from: Layer */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private final List<com.coloros.anim.c.b.b> f2411a;

    /* renamed from: b  reason: collision with root package name */
    private final com.coloros.anim.a f2412b;
    private final String c;
    private final long d;
    private final a e;
    private final long f;
    private final String g;
    private final List<g> h;
    private final l i;
    private final int j;
    private final int k;
    private final int l;
    private final float m;
    private final float n;
    private final int o;
    private final int p;
    private final j q;
    private final k r;
    private final com.coloros.anim.c.a.b s;
    private final List<c<Float>> t;
    private final b u;
    private final boolean v;

    /* compiled from: Layer */
    public enum a {
        PRE_COMP,
        SOLID,
        IMAGE,
        NULL,
        SHAPE,
        TEXT,
        UNKNOWN
    }

    /* compiled from: Layer */
    public enum b {
        NONE,
        ADD,
        INVERT,
        UNKNOWN
    }

    public d(List<com.coloros.anim.c.b.b> list, com.coloros.anim.a aVar, String str, long j2, a aVar2, long j3, String str2, List<g> list2, l lVar, int i2, int i3, int i4, float f2, float f3, int i5, int i6, j jVar, k kVar, List<c<Float>> list3, b bVar, com.coloros.anim.c.a.b bVar2, boolean z) {
        this.f2411a = list;
        this.f2412b = aVar;
        this.c = str;
        this.d = j2;
        this.e = aVar2;
        this.f = j3;
        this.g = str2;
        this.h = list2;
        this.i = lVar;
        this.j = i2;
        this.k = i3;
        this.l = i4;
        this.m = f2;
        this.n = f3;
        this.o = i5;
        this.p = i6;
        this.q = jVar;
        this.r = kVar;
        this.t = list3;
        this.u = bVar;
        this.s = bVar2;
        this.v = z;
    }

    /* access modifiers changed from: package-private */
    public com.coloros.anim.a a() {
        return this.f2412b;
    }

    /* access modifiers changed from: package-private */
    public float b() {
        return this.m;
    }

    /* access modifiers changed from: package-private */
    public float c() {
        return this.n / this.f2412b.m();
    }

    /* access modifiers changed from: package-private */
    public List<c<Float>> d() {
        return this.t;
    }

    public long e() {
        return this.d;
    }

    /* access modifiers changed from: package-private */
    public String f() {
        return this.c;
    }

    /* access modifiers changed from: package-private */
    public String g() {
        return this.g;
    }

    /* access modifiers changed from: package-private */
    public int h() {
        return this.o;
    }

    /* access modifiers changed from: package-private */
    public int i() {
        return this.p;
    }

    /* access modifiers changed from: package-private */
    public List<g> j() {
        return this.h;
    }

    public a k() {
        return this.e;
    }

    /* access modifiers changed from: package-private */
    public b l() {
        return this.u;
    }

    /* access modifiers changed from: package-private */
    public long m() {
        return this.f;
    }

    /* access modifiers changed from: package-private */
    public List<com.coloros.anim.c.b.b> n() {
        return this.f2411a;
    }

    /* access modifiers changed from: package-private */
    public l o() {
        return this.i;
    }

    /* access modifiers changed from: package-private */
    public int p() {
        return this.l;
    }

    /* access modifiers changed from: package-private */
    public int q() {
        return this.k;
    }

    /* access modifiers changed from: package-private */
    public int r() {
        return this.j;
    }

    /* access modifiers changed from: package-private */
    public j s() {
        return this.q;
    }

    /* access modifiers changed from: package-private */
    public k t() {
        return this.r;
    }

    /* access modifiers changed from: package-private */
    public com.coloros.anim.c.a.b u() {
        return this.s;
    }

    public String toString() {
        return a("");
    }

    public boolean v() {
        return this.v;
    }

    public String a(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(f());
        sb.append("\n");
        d a2 = this.f2412b.a(m());
        if (a2 != null) {
            sb.append("\t\tParents: ");
            sb.append(a2.f());
            d a3 = this.f2412b.a(a2.m());
            while (a3 != null) {
                sb.append("->");
                sb.append(a3.f());
                a3 = this.f2412b.a(a3.m());
            }
            sb.append(str);
            sb.append("\n");
        }
        if (!j().isEmpty()) {
            sb.append(str);
            sb.append("\tMasks: ");
            sb.append(j().size());
            sb.append("\n");
        }
        if (!(r() == 0 || q() == 0)) {
            sb.append(str);
            sb.append("\tBackground: ");
            sb.append(String.format(Locale.US, "%dx%d %X\n", new Object[]{Integer.valueOf(r()), Integer.valueOf(q()), Integer.valueOf(p())}));
        }
        if (!this.f2411a.isEmpty()) {
            sb.append(str);
            sb.append("\tShapes:\n");
            for (com.coloros.anim.c.b.b next : this.f2411a) {
                sb.append(str);
                sb.append("\t\t");
                sb.append(next);
                sb.append("\n");
            }
        }
        return sb.toString();
    }
}
