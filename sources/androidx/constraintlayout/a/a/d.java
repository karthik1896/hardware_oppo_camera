package androidx.constraintlayout.a.a;

import androidx.constraintlayout.a.a.f;
import java.util.ArrayList;

/* compiled from: ChainHead */
public class d {

    /* renamed from: a  reason: collision with root package name */
    protected f f515a;

    /* renamed from: b  reason: collision with root package name */
    protected f f516b;
    protected f c;
    protected f d;
    protected f e;
    protected f f;
    protected f g;
    protected ArrayList<f> h;
    protected int i;
    protected int j;
    protected float k = 0.0f;
    protected boolean l;
    protected boolean m;
    protected boolean n;
    private int o;
    private boolean p = false;
    private boolean q;

    public d(f fVar, int i2, boolean z) {
        this.f515a = fVar;
        this.o = i2;
        this.p = z;
    }

    private static boolean a(f fVar, int i2) {
        return fVar.l() != 8 && fVar.C[i2] == f.a.MATCH_CONSTRAINT && (fVar.g[i2] == 0 || fVar.g[i2] == 3);
    }

    private void b() {
        int i2 = this.o * 2;
        boolean z = false;
        f fVar = this.f515a;
        f fVar2 = fVar;
        boolean z2 = false;
        while (!z2) {
            this.i++;
            f fVar3 = null;
            fVar.af[this.o] = null;
            fVar.ae[this.o] = null;
            if (fVar.l() != 8) {
                if (this.f516b == null) {
                    this.f516b = fVar;
                }
                this.d = fVar;
                if (fVar.C[this.o] == f.a.MATCH_CONSTRAINT && (fVar.g[this.o] == 0 || fVar.g[this.o] == 3 || fVar.g[this.o] == 2)) {
                    this.j++;
                    float f2 = fVar.ad[this.o];
                    if (f2 > 0.0f) {
                        this.k += fVar.ad[this.o];
                    }
                    if (a(fVar, this.o)) {
                        if (f2 < 0.0f) {
                            this.l = true;
                        } else {
                            this.m = true;
                        }
                        if (this.h == null) {
                            this.h = new ArrayList<>();
                        }
                        this.h.add(fVar);
                    }
                    if (this.f == null) {
                        this.f = fVar;
                    }
                    f fVar4 = this.g;
                    if (fVar4 != null) {
                        fVar4.ae[this.o] = fVar;
                    }
                    this.g = fVar;
                }
            }
            if (fVar2 != fVar) {
                fVar2.af[this.o] = fVar;
            }
            e eVar = fVar.A[i2 + 1].c;
            if (eVar != null) {
                f fVar5 = eVar.f517a;
                if (fVar5.A[i2].c != null && fVar5.A[i2].c.f517a == fVar) {
                    fVar3 = fVar5;
                }
            }
            if (fVar3 == null) {
                fVar3 = fVar;
                z2 = true;
            }
            fVar2 = fVar;
            fVar = fVar3;
        }
        this.c = fVar;
        if (this.o != 0 || !this.p) {
            this.e = this.f515a;
        } else {
            this.e = this.c;
        }
        if (this.m && this.l) {
            z = true;
        }
        this.n = z;
    }

    public void a() {
        if (!this.q) {
            b();
        }
        this.q = true;
    }
}
