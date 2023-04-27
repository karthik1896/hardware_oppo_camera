package com.heytap.epona.e;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

/* compiled from: ProviderUtils */
public class b {
    public static Bundle a(Context context, String str) {
        Bundle a2 = a(context, Uri.parse("content://com.heytap.appplatform.dispatcher/find_transfer/" + str));
        return a2 == null ? b(context, str) : a2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0025, code lost:
        r6 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0026, code lost:
        r3 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x002a, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x002b, code lost:
        r4 = r3;
        r3 = r6;
        r6 = r4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.os.Bundle a(android.content.Context r5, android.net.Uri r6) {
        /*
            java.lang.String r0 = "ProviderUtils"
            r1 = 0
            r2 = 0
            android.content.ContentResolver r5 = r5.getContentResolver()     // Catch:{ Exception -> 0x003f }
            android.database.Cursor r5 = r5.query(r6, r2, r2, r2)     // Catch:{ Exception -> 0x003f }
            if (r5 != 0) goto L_0x001b
            java.lang.String r6 = "Get cursor null."
            java.lang.Object[] r3 = new java.lang.Object[r1]     // Catch:{ Throwable -> 0x0028, all -> 0x0025 }
            com.heytap.epona.e.a.b(r0, r6, r3)     // Catch:{ Throwable -> 0x0028, all -> 0x0025 }
            if (r5 == 0) goto L_0x001a
            r5.close()     // Catch:{ Exception -> 0x003f }
        L_0x001a:
            return r2
        L_0x001b:
            android.os.Bundle r6 = com.heytap.epona.b.a.a.a(r5)     // Catch:{ Throwable -> 0x0028, all -> 0x0025 }
            if (r5 == 0) goto L_0x0024
            r5.close()     // Catch:{ Exception -> 0x003f }
        L_0x0024:
            return r6
        L_0x0025:
            r6 = move-exception
            r3 = r2
            goto L_0x002e
        L_0x0028:
            r6 = move-exception
            throw r6     // Catch:{ all -> 0x002a }
        L_0x002a:
            r3 = move-exception
            r4 = r3
            r3 = r6
            r6 = r4
        L_0x002e:
            if (r5 == 0) goto L_0x003e
            if (r3 == 0) goto L_0x003b
            r5.close()     // Catch:{ Throwable -> 0x0036 }
            goto L_0x003e
        L_0x0036:
            r5 = move-exception
            r3.addSuppressed(r5)     // Catch:{ Exception -> 0x003f }
            goto L_0x003e
        L_0x003b:
            r5.close()     // Catch:{ Exception -> 0x003f }
        L_0x003e:
            throw r6     // Catch:{ Exception -> 0x003f }
        L_0x003f:
            r5 = move-exception
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r3 = "Get cursor Exception : "
            r6.append(r3)
            r6.append(r5)
            java.lang.String r6 = r6.toString()
            java.lang.Object[] r1 = new java.lang.Object[r1]
            com.heytap.epona.e.a.b(r0, r6, r1)
            r5.printStackTrace()
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.heytap.epona.e.b.a(android.content.Context, android.net.Uri):android.os.Bundle");
    }

    private static Bundle b(Context context, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("com.heytap.epona.Dispatcher.TRANSFER_KEY", str);
        return context.getContentResolver().call("com.heytap.appplatform.dispatcher", "com.heytap.epona.Dispatcher.FIND_TRANSFER", (String) null, bundle);
    }
}
