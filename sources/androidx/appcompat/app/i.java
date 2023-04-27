package androidx.appcompat.app;

import android.content.Context;
import android.content.res.Configuration;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import androidx.appcompat.app.a;
import androidx.appcompat.view.menu.h;
import androidx.appcompat.view.menu.n;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.as;
import androidx.appcompat.widget.z;
import androidx.core.g.v;
import java.util.ArrayList;

/* compiled from: ToolbarActionBar */
class i extends a {

    /* renamed from: a  reason: collision with root package name */
    z f179a;

    /* renamed from: b  reason: collision with root package name */
    boolean f180b;
    Window.Callback c;
    private boolean d;
    private boolean e;
    private ArrayList<a.b> f = new ArrayList<>();
    private final Runnable g = new Runnable() {
        public void run() {
            i.this.i();
        }
    };
    private final Toolbar.c h = new Toolbar.c() {
        public boolean a(MenuItem menuItem) {
            return i.this.c.onMenuItemSelected(0, menuItem);
        }
    };

    public void b(boolean z) {
    }

    public void d(boolean z) {
    }

    public void e(boolean z) {
    }

    i(Toolbar toolbar, CharSequence charSequence, Window.Callback callback) {
        this.f179a = new as(toolbar, false);
        this.c = new c(callback);
        this.f179a.a(this.c);
        toolbar.setOnMenuItemClickListener(this.h);
        this.f179a.a(charSequence);
    }

    public Window.Callback h() {
        return this.c;
    }

    public void a(float f2) {
        v.a((View) this.f179a.a(), f2);
    }

    public Context b() {
        return this.f179a.b();
    }

    public void a(Configuration configuration) {
        super.a(configuration);
    }

    public void a(CharSequence charSequence) {
        this.f179a.a(charSequence);
    }

    public void a(int i, int i2) {
        this.f179a.c((i & i2) | ((~i2) & this.f179a.o()));
    }

    public void a(boolean z) {
        a(z ? 4 : 0, 4);
    }

    public int a() {
        return this.f179a.o();
    }

    public boolean c() {
        return this.f179a.k();
    }

    public boolean d() {
        return this.f179a.l();
    }

    public boolean e() {
        this.f179a.a().removeCallbacks(this.g);
        v.a((View) this.f179a.a(), this.g);
        return true;
    }

    public boolean f() {
        if (!this.f179a.c()) {
            return false;
        }
        this.f179a.d();
        return true;
    }

    /* access modifiers changed from: package-private */
    public void i() {
        Menu j = j();
        h hVar = j instanceof h ? (h) j : null;
        if (hVar != null) {
            hVar.stopDispatchingItemsChanged();
        }
        try {
            j.clear();
            if (!this.c.onCreatePanelMenu(0, j) || !this.c.onPreparePanel(0, (View) null, j)) {
                j.clear();
            }
        } finally {
            if (hVar != null) {
                hVar.startDispatchingItemsChanged();
            }
        }
    }

    public boolean a(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 1) {
            c();
        }
        return true;
    }

    public boolean a(int i, KeyEvent keyEvent) {
        Menu j = j();
        if (j == null) {
            return false;
        }
        boolean z = true;
        if (KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() == 1) {
            z = false;
        }
        j.setQwertyMode(z);
        return j.performShortcut(i, keyEvent, 0);
    }

    /* access modifiers changed from: package-private */
    public void g() {
        this.f179a.a().removeCallbacks(this.g);
    }

    public void f(boolean z) {
        if (z != this.e) {
            this.e = z;
            int size = this.f.size();
            for (int i = 0; i < size; i++) {
                this.f.get(i).a(z);
            }
        }
    }

    /* compiled from: ToolbarActionBar */
    private class c extends androidx.appcompat.view.i {
        public c(Window.Callback callback) {
            super(callback);
        }

        public boolean onPreparePanel(int i, View view, Menu menu) {
            boolean onPreparePanel = super.onPreparePanel(i, view, menu);
            if (onPreparePanel && !i.this.f180b) {
                i.this.f179a.m();
                i.this.f180b = true;
            }
            return onPreparePanel;
        }

        public View onCreatePanelView(int i) {
            if (i == 0) {
                return new View(i.this.f179a.b());
            }
            return super.onCreatePanelView(i);
        }
    }

    private Menu j() {
        if (!this.d) {
            this.f179a.a((n.a) new a(), (h.a) new b());
            this.d = true;
        }
        return this.f179a.q();
    }

    /* compiled from: ToolbarActionBar */
    private final class a implements n.a {

        /* renamed from: b  reason: collision with root package name */
        private boolean f184b;

        a() {
        }

        public boolean a(h hVar) {
            if (i.this.c == null) {
                return false;
            }
            i.this.c.onMenuOpened(108, hVar);
            return true;
        }

        public void a(h hVar, boolean z) {
            if (!this.f184b) {
                this.f184b = true;
                i.this.f179a.n();
                if (i.this.c != null) {
                    i.this.c.onPanelClosed(108, hVar);
                }
                this.f184b = false;
            }
        }
    }

    /* compiled from: ToolbarActionBar */
    private final class b implements h.a {
        public boolean onMenuItemSelected(h hVar, MenuItem menuItem) {
            return false;
        }

        b() {
        }

        public void onMenuModeChange(h hVar) {
            if (i.this.c == null) {
                return;
            }
            if (i.this.f179a.i()) {
                i.this.c.onPanelClosed(108, hVar);
            } else if (i.this.c.onPreparePanel(0, (View) null, hVar)) {
                i.this.c.onMenuOpened(108, hVar);
            }
        }
    }
}
