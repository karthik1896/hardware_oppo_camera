package androidx.lifecycle;

import androidx.lifecycle.e;

class CompositeGeneratedAdaptersObserver implements f {

    /* renamed from: a  reason: collision with root package name */
    private final c[] f901a;

    CompositeGeneratedAdaptersObserver(c[] cVarArr) {
        this.f901a = cVarArr;
    }

    public void a(h hVar, e.a aVar) {
        l lVar = new l();
        for (c a2 : this.f901a) {
            a2.a(hVar, aVar, false, lVar);
        }
        for (c a3 : this.f901a) {
            a3.a(hVar, aVar, true, lVar);
        }
    }
}
