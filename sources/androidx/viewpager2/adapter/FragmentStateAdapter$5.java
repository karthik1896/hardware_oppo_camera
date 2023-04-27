package androidx.viewpager2.adapter;

import android.os.Handler;
import androidx.lifecycle.e;
import androidx.lifecycle.f;
import androidx.lifecycle.h;

class FragmentStateAdapter$5 implements f {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Handler f1359a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Runnable f1360b;

    public void a(h hVar, e.a aVar) {
        if (aVar == e.a.ON_DESTROY) {
            this.f1359a.removeCallbacks(this.f1360b);
            hVar.getLifecycle().b(this);
        }
    }
}
