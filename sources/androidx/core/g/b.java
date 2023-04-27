package androidx.core.g;

import android.content.Context;
import android.util.Log;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* compiled from: ActionProvider */
public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    private final Context f696a;

    /* renamed from: b  reason: collision with root package name */
    private a f697b;
    private C0022b c;

    /* compiled from: ActionProvider */
    public interface a {
        void c(boolean z);
    }

    /* renamed from: androidx.core.g.b$b  reason: collision with other inner class name */
    /* compiled from: ActionProvider */
    public interface C0022b {
        void a(boolean z);
    }

    public abstract View a();

    public void a(SubMenu subMenu) {
    }

    public boolean b() {
        return false;
    }

    public boolean c() {
        return false;
    }

    public boolean d() {
        return false;
    }

    public boolean e() {
        return true;
    }

    public b(Context context) {
        this.f696a = context;
    }

    public View a(MenuItem menuItem) {
        return a();
    }

    public void a(boolean z) {
        a aVar = this.f697b;
        if (aVar != null) {
            aVar.c(z);
        }
    }

    public void a(a aVar) {
        this.f697b = aVar;
    }

    public void a(C0022b bVar) {
        if (!(this.c == null || bVar == null)) {
            Log.w("ActionProvider(support)", "setVisibilityListener: Setting a new ActionProvider.VisibilityListener when one is already set. Are you reusing this " + getClass().getSimpleName() + " instance while it is still in use somewhere else?");
        }
        this.c = bVar;
    }

    public void f() {
        this.c = null;
        this.f697b = null;
    }
}
