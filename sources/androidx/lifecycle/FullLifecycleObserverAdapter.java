package androidx.lifecycle;

import androidx.lifecycle.e;

class FullLifecycleObserverAdapter implements f {

    /* renamed from: a  reason: collision with root package name */
    private final b f902a;

    /* renamed from: b  reason: collision with root package name */
    private final f f903b;

    FullLifecycleObserverAdapter(b bVar, f fVar) {
        this.f902a = bVar;
        this.f903b = fVar;
    }

    public void a(h hVar, e.a aVar) {
        switch (aVar) {
            case ON_CREATE:
                this.f902a.a(hVar);
                break;
            case ON_START:
                this.f902a.b(hVar);
                break;
            case ON_RESUME:
                this.f902a.c(hVar);
                break;
            case ON_PAUSE:
                this.f902a.d(hVar);
                break;
            case ON_STOP:
                this.f902a.e(hVar);
                break;
            case ON_DESTROY:
                this.f902a.f(hVar);
                break;
            case ON_ANY:
                throw new IllegalArgumentException("ON_ANY must not been send by anybody");
        }
        f fVar = this.f903b;
        if (fVar != null) {
            fVar.a(hVar, aVar);
        }
    }
}
