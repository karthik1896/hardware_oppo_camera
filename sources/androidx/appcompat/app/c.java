package androidx.appcompat.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.view.b;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.aw;
import androidx.core.app.a;
import androidx.core.app.f;
import androidx.core.app.m;

/* compiled from: AppCompatActivity */
public class c extends androidx.fragment.app.c implements d, m.a {
    private e k;
    private Resources l;

    /* access modifiers changed from: protected */
    public void a(int i) {
    }

    public void b(m mVar) {
    }

    @Deprecated
    public void g() {
    }

    public void onSupportActionModeFinished(b bVar) {
    }

    public void onSupportActionModeStarted(b bVar) {
    }

    public b onWindowStartingSupportActionMode(b.a aVar) {
        return null;
    }

    /* access modifiers changed from: protected */
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        h().a(context);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        e h = h();
        h.h();
        h.a(bundle);
        super.onCreate(bundle);
    }

    public void setTheme(int i) {
        super.setTheme(i);
        h().a(i);
    }

    /* access modifiers changed from: protected */
    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        h().b(bundle);
    }

    public a q_() {
        return h().a();
    }

    public void a(Toolbar toolbar) {
        h().a(toolbar);
    }

    public MenuInflater getMenuInflater() {
        return h().b();
    }

    public void setContentView(int i) {
        h().c(i);
    }

    public void setContentView(View view) {
        h().a(view);
    }

    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        h().a(view, layoutParams);
    }

    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        h().b(view, layoutParams);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.l != null) {
            this.l.updateConfiguration(configuration, super.getResources().getDisplayMetrics());
        }
        h().a(configuration);
    }

    /* access modifiers changed from: protected */
    public void onPostResume() {
        super.onPostResume();
        h().e();
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        h().c();
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        h().d();
    }

    public <T extends View> T findViewById(int i) {
        return h().b(i);
    }

    public final boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        a q_ = q_();
        if (menuItem.getItemId() != 16908332 || q_ == null || (q_.a() & 4) == 0) {
            return false;
        }
        return e();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        h().g();
    }

    /* access modifiers changed from: protected */
    public void onTitleChanged(CharSequence charSequence, int i) {
        super.onTitleChanged(charSequence, i);
        h().a(charSequence);
    }

    public void d() {
        h().f();
    }

    public void invalidateOptionsMenu() {
        h().f();
    }

    public void a(m mVar) {
        mVar.a((Activity) this);
    }

    public boolean e() {
        Intent f = f();
        if (f == null) {
            return false;
        }
        if (a(f)) {
            m a2 = m.a((Context) this);
            a(a2);
            b(a2);
            a2.a();
            try {
                a.a(this);
                return true;
            } catch (IllegalStateException unused) {
                finish();
                return true;
            }
        } else {
            b(f);
            return true;
        }
    }

    public Intent f() {
        return f.a(this);
    }

    public boolean a(Intent intent) {
        return f.a((Activity) this, intent);
    }

    public void b(Intent intent) {
        f.b((Activity) this, intent);
    }

    public void onContentChanged() {
        g();
    }

    public boolean onMenuOpened(int i, Menu menu) {
        return super.onMenuOpened(i, menu);
    }

    public void onPanelClosed(int i, Menu menu) {
        super.onPanelClosed(i, menu);
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        h().c(bundle);
    }

    public e h() {
        if (this.k == null) {
            this.k = e.a((Activity) this, (d) this);
        }
        return this.k;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        a q_ = q_();
        if (keyCode != 82 || q_ == null || !q_.a(keyEvent)) {
            return super.dispatchKeyEvent(keyEvent);
        }
        return true;
    }

    public Resources getResources() {
        if (this.l == null && aw.a()) {
            this.l = new aw(this, super.getResources());
        }
        Resources resources = this.l;
        return resources == null ? super.getResources() : resources;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0026, code lost:
        r2 = getWindow();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean a(int r2, android.view.KeyEvent r3) {
        /*
            r1 = this;
            int r2 = android.os.Build.VERSION.SDK_INT
            r0 = 26
            if (r2 >= r0) goto L_0x003e
            boolean r2 = r3.isCtrlPressed()
            if (r2 != 0) goto L_0x003e
            int r2 = r3.getMetaState()
            boolean r2 = android.view.KeyEvent.metaStateHasNoModifiers(r2)
            if (r2 != 0) goto L_0x003e
            int r2 = r3.getRepeatCount()
            if (r2 != 0) goto L_0x003e
            int r2 = r3.getKeyCode()
            boolean r2 = android.view.KeyEvent.isModifierKey(r2)
            if (r2 != 0) goto L_0x003e
            android.view.Window r2 = r1.getWindow()
            if (r2 == 0) goto L_0x003e
            android.view.View r0 = r2.getDecorView()
            if (r0 == 0) goto L_0x003e
            android.view.View r2 = r2.getDecorView()
            boolean r2 = r2.dispatchKeyShortcutEvent(r3)
            if (r2 == 0) goto L_0x003e
            r2 = 1
            return r2
        L_0x003e:
            r2 = 0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.c.a(int, android.view.KeyEvent):boolean");
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (a(i, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    public void openOptionsMenu() {
        a q_ = q_();
        if (!getWindow().hasFeature(0)) {
            return;
        }
        if (q_ == null || !q_.c()) {
            super.openOptionsMenu();
        }
    }

    public void closeOptionsMenu() {
        a q_ = q_();
        if (!getWindow().hasFeature(0)) {
            return;
        }
        if (q_ == null || !q_.d()) {
            super.closeOptionsMenu();
        }
    }
}
