package androidx.constraintlayout.a.a;

import androidx.constraintlayout.a.a.e;
import java.util.ArrayList;

/* compiled from: Snapshot */
public class p {

    /* renamed from: a  reason: collision with root package name */
    private int f531a;

    /* renamed from: b  reason: collision with root package name */
    private int f532b;
    private int c;
    private int d;
    private ArrayList<a> e = new ArrayList<>();

    /* compiled from: Snapshot */
    static class a {

        /* renamed from: a  reason: collision with root package name */
        private e f533a;

        /* renamed from: b  reason: collision with root package name */
        private e f534b;
        private int c;
        private e.b d;
        private int e;

        public a(e eVar) {
            this.f533a = eVar;
            this.f534b = eVar.g();
            this.c = eVar.e();
            this.d = eVar.f();
            this.e = eVar.h();
        }

        public void a(f fVar) {
            this.f533a = fVar.a(this.f533a.d());
            e eVar = this.f533a;
            if (eVar != null) {
                this.f534b = eVar.g();
                this.c = this.f533a.e();
                this.d = this.f533a.f();
                this.e = this.f533a.h();
                return;
            }
            this.f534b = null;
            this.c = 0;
            this.d = e.b.STRONG;
            this.e = 0;
        }

        public void b(f fVar) {
            fVar.a(this.f533a.d()).a(this.f534b, this.c, this.d, this.e);
        }
    }

    public p(f fVar) {
        this.f531a = fVar.n();
        this.f532b = fVar.o();
        this.c = fVar.p();
        this.d = fVar.r();
        ArrayList<e> C = fVar.C();
        int size = C.size();
        for (int i = 0; i < size; i++) {
            this.e.add(new a(C.get(i)));
        }
    }

    public void a(f fVar) {
        this.f531a = fVar.n();
        this.f532b = fVar.o();
        this.c = fVar.p();
        this.d = fVar.r();
        int size = this.e.size();
        for (int i = 0; i < size; i++) {
            this.e.get(i).a(fVar);
        }
    }

    public void b(f fVar) {
        fVar.h(this.f531a);
        fVar.i(this.f532b);
        fVar.j(this.c);
        fVar.k(this.d);
        int size = this.e.size();
        for (int i = 0; i < size; i++) {
            this.e.get(i).b(fVar);
        }
    }
}
