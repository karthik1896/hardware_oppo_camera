package com.oppo.camera.ui.menu.setting;

import android.app.KeyguardManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import androidx.appcompat.app.c;
import com.color.support.d.o;
import com.oppo.camera.e;
import com.oppo.camera.h;
import com.oppo.camera.ui.menu.setting.a.a;
import com.oppo.camera.util.Util;

/* compiled from: CameraSettingBaseActivity */
public abstract class m extends c implements a {
    private a k = null;
    private boolean l = false;
    private boolean m = false;
    private boolean n = false;
    private boolean o = false;
    private boolean p = false;

    public boolean a() {
        return true;
    }

    public int c() {
        return 3;
    }

    public boolean p_() {
        return true;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        this.k = new a(this);
        this.k.a(h());
        o.a().a((Context) this);
        super.onCreate(bundle);
        Bundle bundleExtra = getIntent().getBundleExtra("camera_intent_data");
        if (bundleExtra != null) {
            this.p = bundleExtra.getBoolean("camera_enter_form_lock_screen", false);
        }
    }

    /* access modifiers changed from: protected */
    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        this.k.b(h());
    }

    public void onContentChanged() {
        super.onContentChanged();
        this.k.a();
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        this.k.a(menuItem);
        return super.onOptionsItemSelected(menuItem);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (com.oppo.camera.q.a.f3582a != i) {
            return;
        }
        if (-1 == i2) {
            com.oppo.camera.q.a.a(intent);
        } else {
            com.oppo.camera.q.a.b();
        }
    }

    public void setShowWhenLocked(boolean z) {
        KeyguardManager keyguardManager = (KeyguardManager) getApplicationContext().getSystemService("keyguard");
        if (keyguardManager != null) {
            boolean z2 = keyguardManager.isKeyguardLocked() && z;
            super.setShowWhenLocked(z2);
            e.b("SettingBaseActivity", "setShowWhenLocked: " + z2);
        }
    }

    public boolean k() {
        return this.l;
    }

    public void onBackPressed() {
        e.a("SettingBaseActivity", "onBackPressed");
        if (this.m) {
            this.o = true;
        }
        super.onBackPressed();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        e.b("SettingBaseActivity", "onResume: " + this);
        super.onResume();
        setShowWhenLocked(this.m && this.p);
        this.o = false;
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        e.b("SettingBaseActivity", "onPause: " + this);
        super.onPause();
        if (this.m && !this.o) {
            h.a(getApplicationContext()).f();
        }
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        e.b("SettingBaseActivity", "onStop: " + this);
        super.onStop();
        if (!this.o) {
            setShowWhenLocked(false);
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        e.b("SettingBaseActivity", "onDestroy: " + this);
        super.onDestroy();
        this.n = false;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        if (!(keyCode == 57 || keyCode == 58 || keyCode == 82)) {
            switch (keyCode) {
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                    break;
            }
        }
        if (Util.M()) {
            return true;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    public boolean l() {
        return this.n;
    }

    public void a(boolean z) {
        this.n = z;
    }

    public void b(boolean z) {
        this.o = z;
    }

    public boolean m() {
        return this.m;
    }

    public void c(boolean z) {
        this.m = z;
    }

    public boolean n() {
        return this.p;
    }

    /* access modifiers changed from: protected */
    public void attachBaseContext(Context context) {
        if (Util.f4604b > 0) {
            Configuration configuration = new Configuration();
            configuration.densityDpi = Util.f4604b;
            context.getResources().updateConfiguration(configuration, context.getResources().getDisplayMetrics());
        }
        super.attachBaseContext(context);
    }
}
