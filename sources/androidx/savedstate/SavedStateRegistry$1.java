package androidx.savedstate;

import androidx.lifecycle.d;
import androidx.lifecycle.e;
import androidx.lifecycle.h;

class SavedStateRegistry$1 implements d {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f1227a;

    SavedStateRegistry$1(a aVar) {
        this.f1227a = aVar;
    }

    public void a(h hVar, e.a aVar) {
        if (aVar == e.a.ON_START) {
            this.f1227a.f1228a = true;
        } else if (aVar == e.a.ON_STOP) {
            this.f1227a.f1228a = false;
        }
    }
}
