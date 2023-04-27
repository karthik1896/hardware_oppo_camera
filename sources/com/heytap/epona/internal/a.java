package com.heytap.epona.internal;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.lang.ref.WeakReference;
import java.util.Stack;

/* compiled from: ActivityStackManager */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private final Stack<WeakReference<Activity>> f2602a = new Stack<>();

    /* renamed from: b  reason: collision with root package name */
    private final Application.ActivityLifecycleCallbacks f2603b = new Application.ActivityLifecycleCallbacks() {
        public void onActivityPaused(Activity activity) {
        }

        public void onActivityResumed(Activity activity) {
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public void onActivityStarted(Activity activity) {
        }

        public void onActivityStopped(Activity activity) {
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
            a.this.a(activity);
        }

        public void onActivityDestroyed(Activity activity) {
            a.this.b(activity);
        }
    };

    public void a(Application application) {
        if (application != null) {
            application.registerActivityLifecycleCallbacks(this.f2603b);
        }
    }

    /* access modifiers changed from: private */
    public synchronized void a(Activity activity) {
        if (activity != null) {
            this.f2602a.push(new WeakReference(activity));
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0042, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void b(android.app.Activity r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            if (r4 != 0) goto L_0x0005
            monitor-exit(r3)
            return
        L_0x0005:
            java.util.Stack<java.lang.ref.WeakReference<android.app.Activity>> r0 = r3.f2602a     // Catch:{ all -> 0x0043 }
            int r0 = r0.size()     // Catch:{ all -> 0x0043 }
            int r0 = r0 + -1
        L_0x000d:
            if (r0 < 0) goto L_0x0041
            java.util.Stack<java.lang.ref.WeakReference<android.app.Activity>> r1 = r3.f2602a     // Catch:{ Exception -> 0x003e }
            java.lang.Object r1 = r1.get(r0)     // Catch:{ Exception -> 0x003e }
            java.lang.ref.WeakReference r1 = (java.lang.ref.WeakReference) r1     // Catch:{ Exception -> 0x003e }
            if (r1 == 0) goto L_0x003e
            java.lang.Object r1 = r1.get()     // Catch:{ Exception -> 0x003e }
            android.app.Activity r1 = (android.app.Activity) r1     // Catch:{ Exception -> 0x003e }
            if (r1 != 0) goto L_0x0022
            goto L_0x003e
        L_0x0022:
            java.lang.Class r1 = r1.getClass()     // Catch:{ Exception -> 0x003e }
            java.lang.String r1 = r1.getSimpleName()     // Catch:{ Exception -> 0x003e }
            java.lang.Class r2 = r4.getClass()     // Catch:{ Exception -> 0x003e }
            java.lang.String r2 = r2.getSimpleName()     // Catch:{ Exception -> 0x003e }
            boolean r1 = r1.equals(r2)     // Catch:{ Exception -> 0x003e }
            if (r1 == 0) goto L_0x003e
            java.util.Stack<java.lang.ref.WeakReference<android.app.Activity>> r1 = r3.f2602a     // Catch:{ Exception -> 0x003e }
            r1.remove(r0)     // Catch:{ Exception -> 0x003e }
            goto L_0x0041
        L_0x003e:
            int r0 = r0 + -1
            goto L_0x000d
        L_0x0041:
            monitor-exit(r3)
            return
        L_0x0043:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.heytap.epona.internal.a.b(android.app.Activity):void");
    }
}
