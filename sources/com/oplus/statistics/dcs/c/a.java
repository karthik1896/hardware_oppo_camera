package com.oplus.statistics.dcs.c;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

/* compiled from: AppLifecycleCallbacks */
public class a implements Application.ActivityLifecycleCallbacks {

    /* renamed from: a  reason: collision with root package name */
    private int f2707a;

    /* renamed from: com.oplus.statistics.dcs.c.a$a  reason: collision with other inner class name */
    /* compiled from: AppLifecycleCallbacks */
    private static class C0076a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final a f2708a = new a();
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public void onActivityDestroyed(Activity activity) {
    }

    public void onActivityPaused(Activity activity) {
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    private a() {
        this.f2707a = 0;
    }

    public static a a() {
        return C0076a.f2708a;
    }

    public void onActivityStarted(Activity activity) {
        this.f2707a++;
    }

    public void onActivityResumed(Activity activity) {
        if (b()) {
            c.a().c(activity.getApplicationContext());
        }
    }

    public void onActivityStopped(Activity activity) {
        this.f2707a--;
        if (c()) {
            c.a().b(activity.getApplicationContext());
        }
    }

    private boolean b() {
        return this.f2707a == 1;
    }

    private boolean c() {
        return this.f2707a == 0;
    }
}
