package com.heytap.shield;

import android.content.Context;
import android.os.Binder;
import android.text.TextUtils;
import com.heytap.shield.authcode.a;
import com.heytap.shield.authcode.c;
import com.heytap.shield.b.d;
import com.heytap.shield.b.e;

/* compiled from: PermissionCheck */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static b f2644a;

    /* renamed from: b  reason: collision with root package name */
    private volatile boolean f2645b = false;
    private Context c;
    private a d;

    private b() {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0041, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void a(android.content.Context r2) {
        /*
            r1 = this;
            monitor-enter(r1)
            boolean r0 = r1.f2645b     // Catch:{ all -> 0x0042 }
            if (r0 == 0) goto L_0x0007
            monitor-exit(r1)
            return
        L_0x0007:
            r0 = 1
            r1.f2645b = r0     // Catch:{ all -> 0x0042 }
            boolean r0 = r2 instanceof android.app.Application     // Catch:{ all -> 0x0042 }
            if (r0 == 0) goto L_0x0010
            r0 = r2
            goto L_0x0014
        L_0x0010:
            android.content.Context r0 = r2.getApplicationContext()     // Catch:{ all -> 0x0042 }
        L_0x0014:
            r1.c = r0     // Catch:{ all -> 0x0042 }
            com.heytap.shield.authcode.a r0 = new com.heytap.shield.authcode.a     // Catch:{ all -> 0x0042 }
            r0.<init>(r2)     // Catch:{ all -> 0x0042 }
            r1.d = r0     // Catch:{ all -> 0x0042 }
            com.heytap.shield.a.a.a()     // Catch:{ all -> 0x0042 }
            android.content.Context r2 = r1.c     // Catch:{ all -> 0x0042 }
            if (r2 == 0) goto L_0x0040
            android.content.Context r2 = r1.c     // Catch:{ all -> 0x0042 }
            java.lang.String r2 = r2.getPackageName()     // Catch:{ all -> 0x0042 }
            java.lang.String r0 = "com.heytap.appplatform"
            boolean r2 = android.text.TextUtils.equals(r2, r0)     // Catch:{ all -> 0x0042 }
            if (r2 == 0) goto L_0x0040
            android.content.Context r2 = r1.c     // Catch:{ all -> 0x0042 }
            com.heytap.shield.b.d.a((android.content.Context) r2)     // Catch:{ all -> 0x0042 }
            com.heytap.shield.b.c r2 = com.heytap.shield.b.c.b()     // Catch:{ all -> 0x0042 }
            android.content.Context r0 = r1.c     // Catch:{ all -> 0x0042 }
            r2.a((android.content.Context) r0)     // Catch:{ all -> 0x0042 }
        L_0x0040:
            monitor-exit(r1)
            return
        L_0x0042:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.heytap.shield.b.a(android.content.Context):void");
    }

    public boolean a(String str, String str2, String str3) {
        String str4 = str;
        String str5 = str2;
        String str6 = str3;
        if (Binder.getCallingUid() == 1000) {
            return true;
        }
        String a2 = e.a(this.c, Binder.getCallingUid(), Binder.getCallingPid());
        if (TextUtils.isEmpty(str)) {
            d.b("Epona Authentication Failed Cause Component Empty : " + a2);
            return false;
        } else if (TextUtils.isEmpty(str)) {
            d.b("Epona Authentication Failed Cause ActionName Empty : " + a2);
            return false;
        } else if (TextUtils.isEmpty(str3)) {
            d.b("Epona Authentication Failed Cause Register Package Empty : " + a2);
            return false;
        } else {
            d.a("Start epona verify Component : [" + str4 + "] action : [" + str5 + "] register pacage : [" + str6 + "] caller pacakge : [" + a2 + "]");
            String b2 = com.heytap.shield.b.b.b(this.c, a2);
            if (this.d.a(b2)) {
                d.a("Tingle verity SUCCESS Caller Package [" + a2 + "] is platform signature");
                return true;
            }
            String str7 = "SUCCESS";
            if (!TextUtils.equals("com.heytap.appplatform", str6)) {
                boolean equals = TextUtils.equals(com.heytap.shield.b.b.a(this.c, str6), com.heytap.shield.b.b.a(this.c, a2));
                StringBuilder sb = new StringBuilder();
                sb.append("Epona verity ");
                if (!equals) {
                    str7 = "FAILED";
                }
                sb.append(str7);
                sb.append(" Caller : [");
                sb.append(a2);
                sb.append("] Component : [");
                sb.append(str4);
                sb.append("] ActionName : [");
                sb.append(str5);
                sb.append("]");
                d.a(sb.toString());
                return equals;
            } else if (TextUtils.equals("com.heytap.appplatform", a2)) {
                return true;
            } else {
                if (this.d.a(a2, b2)) {
                    boolean a3 = this.d.a(a2, str4, str5);
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Epona verity ");
                    if (!a3) {
                        str7 = "FAILED";
                    }
                    sb2.append(str7);
                    sb2.append(" Caller : [");
                    sb2.append(a2);
                    sb2.append("] Component : [");
                    sb2.append(str4);
                    sb2.append("] ActionName : [");
                    sb2.append(str5);
                    sb2.append("]");
                    d.a(sb2.toString());
                    return a3;
                }
                com.heytap.shield.authcode.a.a a4 = com.heytap.shield.authcode.b.a(this.c, a2);
                int b3 = a4.b();
                if (b3 != 1001) {
                    d.b("Epona Authentication Failed " + c.a(b3) + " Package : " + a2);
                    return false;
                }
                this.d.a(a2, a4, b2);
                boolean a5 = this.d.a(a2, str4, str5);
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Epona verity ");
                if (!a5) {
                    str7 = "FAILED";
                }
                sb3.append(str7);
                sb3.append(" Caller : [");
                sb3.append(a2);
                sb3.append("] Component : [");
                sb3.append(str4);
                sb3.append("] ActionName : [");
                sb3.append(str5);
                sb3.append("]");
                d.a(sb3.toString());
                return a5;
            }
        }
    }

    public boolean a() {
        return !com.heytap.shield.b.c.b().a();
    }

    public static b b() {
        if (f2644a == null) {
            synchronized (b.class) {
                if (f2644a == null) {
                    f2644a = new b();
                }
            }
        }
        return f2644a;
    }
}
