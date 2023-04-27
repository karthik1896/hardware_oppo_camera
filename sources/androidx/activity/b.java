package androidx.activity;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import androidx.core.app.e;
import androidx.lifecycle.e;
import androidx.lifecycle.h;
import androidx.lifecycle.i;
import androidx.lifecycle.p;
import androidx.lifecycle.s;
import androidx.lifecycle.t;
import androidx.savedstate.c;

/* compiled from: ComponentActivity */
public class b extends e implements d, h, t, c {

    /* renamed from: a  reason: collision with root package name */
    private final i f110a = new i(this);

    /* renamed from: b  reason: collision with root package name */
    private final androidx.savedstate.b f111b = androidx.savedstate.b.a((c) this);
    private s c;
    private final OnBackPressedDispatcher d = new OnBackPressedDispatcher(new Runnable() {
        public void run() {
            b.super.onBackPressed();
        }
    });
    private int e;

    @Deprecated
    public Object r_() {
        return null;
    }

    /* compiled from: ComponentActivity */
    static final class a {

        /* renamed from: a  reason: collision with root package name */
        Object f113a;

        /* renamed from: b  reason: collision with root package name */
        s f114b;

        a() {
        }
    }

    public b() {
        if (getLifecycle() != null) {
            if (Build.VERSION.SDK_INT >= 19) {
                getLifecycle().a(new ComponentActivity$2(this));
            }
            getLifecycle().a(new ComponentActivity$3(this));
            if (19 <= Build.VERSION.SDK_INT && Build.VERSION.SDK_INT <= 23) {
                getLifecycle().a(new ImmLeaksCleaner(this));
                return;
            }
            return;
        }
        throw new IllegalStateException("getLifecycle() returned null in ComponentActivity's constructor. Please make sure you are lazily constructing your Lifecycle in the first call to getLifecycle() rather than relying on field initialization.");
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f111b.a(bundle);
        p.a((Activity) this);
        int i = this.e;
        if (i != 0) {
            setContentView(i);
        }
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        androidx.lifecycle.e lifecycle = getLifecycle();
        if (lifecycle instanceof i) {
            ((i) lifecycle).b(e.b.CREATED);
        }
        super.onSaveInstanceState(bundle);
        this.f111b.b(bundle);
    }

    public final Object onRetainNonConfigurationInstance() {
        a aVar;
        Object r_ = r_();
        s sVar = this.c;
        if (sVar == null && (aVar = (a) getLastNonConfigurationInstance()) != null) {
            sVar = aVar.f114b;
        }
        if (sVar == null && r_ == null) {
            return null;
        }
        a aVar2 = new a();
        aVar2.f113a = r_;
        aVar2.f114b = sVar;
        return aVar2;
    }

    public androidx.lifecycle.e getLifecycle() {
        return this.f110a;
    }

    public s getViewModelStore() {
        if (getApplication() != null) {
            if (this.c == null) {
                a aVar = (a) getLastNonConfigurationInstance();
                if (aVar != null) {
                    this.c = aVar.f114b;
                }
                if (this.c == null) {
                    this.c = new s();
                }
            }
            return this.c;
        }
        throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
    }

    public void onBackPressed() {
        this.d.a();
    }

    public final OnBackPressedDispatcher b() {
        return this.d;
    }

    public final androidx.savedstate.a getSavedStateRegistry() {
        return this.f111b.a();
    }
}
