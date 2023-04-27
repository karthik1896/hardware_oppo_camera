package androidx.constraintlayout.a.a;

import androidx.constraintlayout.a.c;
import java.util.ArrayList;

/* compiled from: WidgetContainer */
public class q extends f {
    protected ArrayList<f> az = new ArrayList<>();

    public void f() {
        this.az.clear();
        super.f();
    }

    public void b(f fVar) {
        this.az.add(fVar);
        if (fVar.k() != null) {
            ((q) fVar.k()).c(fVar);
        }
        fVar.a((f) this);
    }

    public void c(f fVar) {
        this.az.remove(fVar);
        fVar.a((f) null);
    }

    public g T() {
        f k = k();
        g gVar = this instanceof g ? (g) this : null;
        while (k != null) {
            f k2 = k.k();
            if (k instanceof g) {
                gVar = (g) k;
            }
            k = k2;
        }
        return gVar;
    }

    public void b(int i, int i2) {
        super.b(i, i2);
        int size = this.az.size();
        for (int i3 = 0; i3 < size; i3++) {
            this.az.get(i3).b(v(), w());
        }
    }

    public void D() {
        super.D();
        ArrayList<f> arrayList = this.az;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                f fVar = this.az.get(i);
                fVar.b(t(), u());
                if (!(fVar instanceof g)) {
                    fVar.D();
                }
            }
        }
    }

    public void N() {
        D();
        ArrayList<f> arrayList = this.az;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                f fVar = this.az.get(i);
                if (fVar instanceof q) {
                    ((q) fVar).N();
                }
            }
        }
    }

    public void a(c cVar) {
        super.a(cVar);
        int size = this.az.size();
        for (int i = 0; i < size; i++) {
            this.az.get(i).a(cVar);
        }
    }

    public void U() {
        this.az.clear();
    }
}
