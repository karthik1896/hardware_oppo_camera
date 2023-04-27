package androidx.core.app;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import androidx.collection.SimpleArrayMap;
import androidx.core.g.d;
import androidx.lifecycle.e;
import androidx.lifecycle.h;
import androidx.lifecycle.i;
import androidx.lifecycle.p;

/* compiled from: ComponentActivity */
public class e extends Activity implements d.a, h {

    /* renamed from: a  reason: collision with root package name */
    private SimpleArrayMap<Class<? extends a>, a> f587a = new SimpleArrayMap<>();

    /* renamed from: b  reason: collision with root package name */
    private i f588b = new i(this);

    @Deprecated
    /* compiled from: ComponentActivity */
    public static class a {
    }

    @Deprecated
    public void a(a aVar) {
        this.f587a.put(aVar.getClass(), aVar);
    }

    /* access modifiers changed from: protected */
    @SuppressLint({"RestrictedApi"})
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        p.a((Activity) this);
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        this.f588b.a(e.b.CREATED);
        super.onSaveInstanceState(bundle);
    }

    @Deprecated
    public <T extends a> T a(Class<T> cls) {
        return (a) this.f587a.get(cls);
    }

    public androidx.lifecycle.e getLifecycle() {
        return this.f588b;
    }

    public boolean a(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        View decorView = getWindow().getDecorView();
        if (decorView == null || !d.a(decorView, keyEvent)) {
            return super.dispatchKeyShortcutEvent(keyEvent);
        }
        return true;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        View decorView = getWindow().getDecorView();
        if (decorView == null || !d.a(decorView, keyEvent)) {
            return d.a(this, decorView, this, keyEvent);
        }
        return true;
    }
}
