package androidx.viewpager2.adapter;

import androidx.core.g.v;
import androidx.lifecycle.e;
import androidx.lifecycle.f;
import androidx.lifecycle.h;

class FragmentStateAdapter$2 implements f {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ b f1357a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ a f1358b;

    FragmentStateAdapter$2(a aVar, b bVar) {
        this.f1358b = aVar;
        this.f1357a = bVar;
    }

    public void a(h hVar, e.a aVar) {
        if (!this.f1358b.a()) {
            hVar.getLifecycle().b(this);
            if (v.D(this.f1357a.a())) {
                this.f1358b.a(this.f1357a);
            }
        }
    }
}
