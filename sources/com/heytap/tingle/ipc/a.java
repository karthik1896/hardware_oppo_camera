package com.heytap.tingle.ipc;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import com.sensetime.stmobile.STMobileHumanActionNative;

/* compiled from: Engine */
public class a {
    public static void a(Context context) {
        if (!context.getApplicationInfo().packageName.equals("com.heytap.appplatform")) {
            c(context);
        }
    }

    private static void c(Context context) {
        if (d(context)) {
            IBinder b2 = b(context);
            if (b2 != null) {
                c.a(b2);
            } else {
                com.heytap.tingle.ipc.d.a.a("Engine", "Call AppPlatform provider failed.", new Object[0]);
            }
        } else {
            com.heytap.tingle.ipc.d.a.a("Engine", "MasterProvider is not exist.", new Object[0]);
        }
    }

    private static boolean d(Context context) {
        return context.getPackageManager().resolveContentProvider("com.heytap.appplatform.master.provider", STMobileHumanActionNative.ST_MOBILE_DETECT_MODE_VIDEO) != null;
    }

    public static IBinder b(Context context) {
        IBinder e = e(context);
        return e == null ? f(context) : e;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x002b, code lost:
        r3 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x002c, code lost:
        r4 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0030, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0031, code lost:
        r5 = r4;
        r4 = r3;
        r3 = r5;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.os.IBinder e(android.content.Context r6) {
        /*
            java.lang.String r0 = "Engine"
            r1 = 0
            r2 = 0
            android.content.ContentResolver r6 = r6.getContentResolver()     // Catch:{ Exception -> 0x0045 }
            java.lang.String r3 = "content://com.heytap.appplatform.master.provider"
            android.net.Uri r3 = android.net.Uri.parse(r3)     // Catch:{ Exception -> 0x0045 }
            android.database.Cursor r6 = r6.query(r3, r2, r2, r2)     // Catch:{ Exception -> 0x0045 }
            if (r6 != 0) goto L_0x0021
            java.lang.String r3 = "Get cursor null."
            java.lang.Object[] r4 = new java.lang.Object[r1]     // Catch:{ Throwable -> 0x002e, all -> 0x002b }
            com.heytap.tingle.ipc.d.a.a(r0, r3, r4)     // Catch:{ Throwable -> 0x002e, all -> 0x002b }
            if (r6 == 0) goto L_0x0020
            r6.close()     // Catch:{ Exception -> 0x0045 }
        L_0x0020:
            return r2
        L_0x0021:
            android.os.IBinder r3 = com.heytap.tingle.ipc.a.a.a(r6)     // Catch:{ Throwable -> 0x002e, all -> 0x002b }
            if (r6 == 0) goto L_0x002a
            r6.close()     // Catch:{ Exception -> 0x0045 }
        L_0x002a:
            return r3
        L_0x002b:
            r3 = move-exception
            r4 = r2
            goto L_0x0034
        L_0x002e:
            r3 = move-exception
            throw r3     // Catch:{ all -> 0x0030 }
        L_0x0030:
            r4 = move-exception
            r5 = r4
            r4 = r3
            r3 = r5
        L_0x0034:
            if (r6 == 0) goto L_0x0044
            if (r4 == 0) goto L_0x0041
            r6.close()     // Catch:{ Throwable -> 0x003c }
            goto L_0x0044
        L_0x003c:
            r6 = move-exception
            r4.addSuppressed(r6)     // Catch:{ Exception -> 0x0045 }
            goto L_0x0044
        L_0x0041:
            r6.close()     // Catch:{ Exception -> 0x0045 }
        L_0x0044:
            throw r3     // Catch:{ Exception -> 0x0045 }
        L_0x0045:
            r6 = move-exception
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Close cursor failed : "
            r3.append(r4)
            java.lang.String r6 = r6.toString()
            r3.append(r6)
            java.lang.String r6 = r3.toString()
            java.lang.Object[] r1 = new java.lang.Object[r1]
            com.heytap.tingle.ipc.d.a.a(r0, r6, r1)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.heytap.tingle.ipc.a.e(android.content.Context):android.os.IBinder");
    }

    private static IBinder f(Context context) {
        Bundle call = context.getContentResolver().call("com.heytap.appplatform.master.provider", "sendBinder", (String) null, (Bundle) null);
        if (call != null) {
            return call.getBinder("com.heytap.epona.ext_binder");
        }
        com.heytap.tingle.ipc.d.a.a("Engine", "Get Master IBinder from provider call is null", new Object[0]);
        return null;
    }
}
