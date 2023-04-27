package androidx.cardview.a;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;

/* compiled from: CardViewApi21Impl */
class c implements f {
    public void a() {
    }

    c() {
    }

    public void a(e eVar, Context context, ColorStateList colorStateList, float f, float f2, float f3) {
        eVar.a(new g(colorStateList, f));
        View d = eVar.d();
        d.setClipToOutline(true);
        d.setElevation(f2);
        b(eVar, f3);
    }

    public void a(e eVar, float f) {
        j(eVar).a(f);
    }

    public void b(e eVar, float f) {
        j(eVar).a(f, eVar.a(), eVar.b());
        f(eVar);
    }

    public float a(e eVar) {
        return j(eVar).a();
    }

    public float b(e eVar) {
        return d(eVar) * 2.0f;
    }

    public float c(e eVar) {
        return d(eVar) * 2.0f;
    }

    public float d(e eVar) {
        return j(eVar).b();
    }

    public void c(e eVar, float f) {
        eVar.d().setElevation(f);
    }

    public float e(e eVar) {
        return eVar.d().getElevation();
    }

    public void f(e eVar) {
        if (!eVar.a()) {
            eVar.a(0, 0, 0, 0);
            return;
        }
        float a2 = a(eVar);
        float d = d(eVar);
        int ceil = (int) Math.ceil((double) h.b(a2, d, eVar.b()));
        int ceil2 = (int) Math.ceil((double) h.a(a2, d, eVar.b()));
        eVar.a(ceil, ceil2, ceil, ceil2);
    }

    public void g(e eVar) {
        b(eVar, a(eVar));
    }

    public void h(e eVar) {
        b(eVar, a(eVar));
    }

    public void a(e eVar, ColorStateList colorStateList) {
        j(eVar).a(colorStateList);
    }

    public ColorStateList i(e eVar) {
        return j(eVar).c();
    }

    private g j(e eVar) {
        return (g) eVar.c();
    }
}
