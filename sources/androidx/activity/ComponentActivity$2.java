package androidx.activity;

import android.view.View;
import android.view.Window;
import androidx.lifecycle.e;
import androidx.lifecycle.f;
import androidx.lifecycle.h;

class ComponentActivity$2 implements f {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ b f100a;

    ComponentActivity$2(b bVar) {
        this.f100a = bVar;
    }

    public void a(h hVar, e.a aVar) {
        if (aVar == e.a.ON_STOP) {
            Window window = this.f100a.getWindow();
            View peekDecorView = window != null ? window.peekDecorView() : null;
            if (peekDecorView != null) {
                peekDecorView.cancelPendingInputEvents();
            }
        }
    }
}
