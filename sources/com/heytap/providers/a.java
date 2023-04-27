package com.heytap.providers;

import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.SQLException;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.RemoteException;
import android.provider.BaseColumns;
import android.provider.Settings;
import android.util.Log;
import com.android.providers.downloads.Downloads;
import com.color.compat.provider.ColorSettings;

/* compiled from: HeytapSettings */
public class a implements BaseColumns {

    /* renamed from: a  reason: collision with root package name */
    public static final Uri f2615a = Settings.System.getUriFor(ColorSettings.System.VIDEO_CALL);

    /* renamed from: b  reason: collision with root package name */
    public static final Uri f2616b = Settings.System.getUriFor(ColorSettings.System.SIP_CALL);
    public static final String[] c = {"user_preferred_sub1", "user_preferred_sub2"};
    public static final Uri d = Settings.System.getUriFor(ColorSettings.System.MMS_NOTIFICATION_SOUND);
    public static final Uri e = Settings.System.getUriFor(ColorSettings.System.RINGTONE_SIM2);
    public static final Uri f = Settings.System.getUriFor(ColorSettings.System.NOTIFICATION_SOUND_SIM2);
    public static final Uri g = Settings.System.getUriFor(ColorSettings.System.CALENDAR_REMINDER_SOUND);
    public static final String[] h = {"user_preferred_sub1", "user_preferred_sub2", "user_preferred_sub3"};

    /* renamed from: com.heytap.providers.a$a  reason: collision with other inner class name */
    /* compiled from: HeytapSettings */
    private static final class C0072a {

        /* renamed from: a  reason: collision with root package name */
        private final Object f2617a = new Object();

        /* renamed from: b  reason: collision with root package name */
        private final Uri f2618b;
        private ContentProviderClient c;

        public C0072a(Uri uri) {
            this.f2618b = uri;
        }

        public ContentProviderClient a(ContentResolver contentResolver) {
            ContentProviderClient contentProviderClient;
            synchronized (this.f2617a) {
                if (this.c == null) {
                    this.c = contentResolver.acquireContentProviderClient(this.f2618b.getAuthority());
                }
                contentProviderClient = this.c;
            }
            return contentProviderClient;
        }
    }

    /* compiled from: HeytapSettings */
    public static class c implements BaseColumns {
        protected static boolean a(ContentResolver contentResolver, Uri uri, String str, String str2) {
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put("name", str);
                contentValues.put(Downloads.Impl.RequestHeaders.COLUMN_VALUE, str2);
                contentResolver.insert(uri, contentValues);
                return true;
            } catch (SQLException e) {
                Log.w("EponaSettings", "Can't set key " + str + " in " + uri, e);
                return false;
            }
        }

        public static Uri a(Uri uri, String str) {
            return Uri.withAppendedPath(uri, str);
        }
    }

    /* compiled from: HeytapSettings */
    private static class b {

        /* renamed from: a  reason: collision with root package name */
        private static final String[] f2619a = {Downloads.Impl.RequestHeaders.COLUMN_VALUE};

        /* renamed from: b  reason: collision with root package name */
        private final Uri f2620b;
        private final C0072a c;
        private final String d;
        private final String e;

        public b(Uri uri, String str, String str2, C0072a aVar) {
            this.f2620b = uri;
            this.d = str;
            this.e = str2;
            this.c = aVar;
        }

        public boolean a(ContentResolver contentResolver, String str, String str2, String str3, boolean z) {
            try {
                Bundle bundle = new Bundle();
                bundle.putString(Downloads.Impl.RequestHeaders.COLUMN_VALUE, str2);
                if (str3 != null) {
                    bundle.putString("_tag", str3);
                }
                if (z) {
                    bundle.putBoolean("_make_default", true);
                }
                this.c.a(contentResolver).call(this.e, str, bundle);
                return true;
            } catch (RemoteException e2) {
                Log.w("EponaSettings", "Can't set key " + str + " in " + this.f2620b, e2);
                return false;
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:36:0x00b1  */
        /* JADX WARNING: Removed duplicated region for block: B:40:0x00b8  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.String a(android.content.ContentResolver r12, java.lang.String r13) {
            /*
                r11 = this;
                java.lang.String r0 = " from "
                java.lang.String r1 = "Can't get key "
                com.heytap.providers.a$a r2 = r11.c
                android.content.ContentProviderClient r3 = r2.a(r12)
                java.lang.String r12 = "EponaSettings"
                r2 = 0
                if (r3 != 0) goto L_0x0026
                java.lang.StringBuilder r13 = new java.lang.StringBuilder
                r13.<init>()
                java.lang.String r0 = "Can't get provider for "
                r13.append(r0)
                android.net.Uri r0 = r11.f2620b
                r13.append(r0)
                java.lang.String r13 = r13.toString()
                android.util.Log.w(r12, r13)
                return r2
            L_0x0026:
                java.lang.String r4 = r11.d
                if (r4 == 0) goto L_0x003e
                android.os.Bundle r4 = new android.os.Bundle     // Catch:{ RemoteException -> 0x003e }
                r4.<init>()     // Catch:{ RemoteException -> 0x003e }
                java.lang.String r5 = r11.d     // Catch:{ RemoteException -> 0x003e }
                android.os.Bundle r4 = r3.call(r5, r13, r4)     // Catch:{ RemoteException -> 0x003e }
                if (r4 == 0) goto L_0x003e
                java.lang.String r5 = "value"
                java.lang.String r12 = r4.getString(r5)     // Catch:{ RemoteException -> 0x003e }
                return r12
            L_0x003e:
                java.lang.String r4 = "name=?"
                r5 = 1
                java.lang.String[] r6 = new java.lang.String[r5]     // Catch:{ RemoteException -> 0x0093, all -> 0x0090 }
                r9 = 0
                r6[r9] = r13     // Catch:{ RemoteException -> 0x0093, all -> 0x0090 }
                com.heytap.providers.a.a(r4, r6, r2)     // Catch:{ RemoteException -> 0x0093, all -> 0x0090 }
                android.net.Uri r4 = r11.f2620b     // Catch:{ RemoteException -> 0x0093, all -> 0x0090 }
                java.lang.String[] r6 = f2619a     // Catch:{ RemoteException -> 0x0093, all -> 0x0090 }
                java.lang.String r7 = "name=?"
                java.lang.String[] r8 = new java.lang.String[r5]     // Catch:{ RemoteException -> 0x0093, all -> 0x0090 }
                r8[r9] = r13     // Catch:{ RemoteException -> 0x0093, all -> 0x0090 }
                r10 = 0
                r5 = r6
                r6 = r7
                r7 = r8
                r8 = r10
                android.database.Cursor r3 = r3.query(r4, r5, r6, r7, r8)     // Catch:{ RemoteException -> 0x0093, all -> 0x0090 }
                if (r3 != 0) goto L_0x007e
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ RemoteException -> 0x008e }
                r4.<init>()     // Catch:{ RemoteException -> 0x008e }
                r4.append(r1)     // Catch:{ RemoteException -> 0x008e }
                r4.append(r13)     // Catch:{ RemoteException -> 0x008e }
                r4.append(r0)     // Catch:{ RemoteException -> 0x008e }
                android.net.Uri r5 = r11.f2620b     // Catch:{ RemoteException -> 0x008e }
                r4.append(r5)     // Catch:{ RemoteException -> 0x008e }
                java.lang.String r4 = r4.toString()     // Catch:{ RemoteException -> 0x008e }
                android.util.Log.w(r12, r4)     // Catch:{ RemoteException -> 0x008e }
                if (r3 == 0) goto L_0x007d
                r3.close()
            L_0x007d:
                return r2
            L_0x007e:
                boolean r4 = r3.moveToNext()     // Catch:{ RemoteException -> 0x008e }
                if (r4 == 0) goto L_0x0088
                java.lang.String r2 = r3.getString(r9)     // Catch:{ RemoteException -> 0x008e }
            L_0x0088:
                if (r3 == 0) goto L_0x008d
                r3.close()
            L_0x008d:
                return r2
            L_0x008e:
                r4 = move-exception
                goto L_0x0095
            L_0x0090:
                r12 = move-exception
                r3 = r2
                goto L_0x00b6
            L_0x0093:
                r4 = move-exception
                r3 = r2
            L_0x0095:
                java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x00b5 }
                r5.<init>()     // Catch:{ all -> 0x00b5 }
                r5.append(r1)     // Catch:{ all -> 0x00b5 }
                r5.append(r13)     // Catch:{ all -> 0x00b5 }
                r5.append(r0)     // Catch:{ all -> 0x00b5 }
                android.net.Uri r13 = r11.f2620b     // Catch:{ all -> 0x00b5 }
                r5.append(r13)     // Catch:{ all -> 0x00b5 }
                java.lang.String r13 = r5.toString()     // Catch:{ all -> 0x00b5 }
                android.util.Log.w(r12, r13, r4)     // Catch:{ all -> 0x00b5 }
                if (r3 == 0) goto L_0x00b4
                r3.close()
            L_0x00b4:
                return r2
            L_0x00b5:
                r12 = move-exception
            L_0x00b6:
                if (r3 == 0) goto L_0x00bb
                r3.close()
            L_0x00bb:
                throw r12
            */
            throw new UnsupportedOperationException("Method not decompiled: com.heytap.providers.a.b.a(android.content.ContentResolver, java.lang.String):java.lang.String");
        }
    }

    /* compiled from: HeytapSettings */
    public static final class d extends c {

        /* renamed from: a  reason: collision with root package name */
        public static final Uri f2621a = Uri.parse("content://com.heytap.appplatform.settings/system");

        /* renamed from: b  reason: collision with root package name */
        private static final C0072a f2622b = new C0072a(f2621a);
        private static final b c = new b(f2621a, "GET_system", "PUT_system", f2622b);

        public static String a(ContentResolver contentResolver, String str) {
            return c.a(contentResolver, str);
        }

        public static boolean a(ContentResolver contentResolver, String str, String str2) {
            if (Build.VERSION.SDK_INT > 28) {
                return c.a(contentResolver, str, str2, (String) null, false);
            }
            return a(contentResolver, a(str), str, str2);
        }

        public static Uri a(String str) {
            return a(f2621a, str);
        }

        public static int a(ContentResolver contentResolver, String str, int i) {
            String a2 = a(contentResolver, str);
            if (a2 == null) {
                return i;
            }
            try {
                return Integer.parseInt(a2);
            } catch (NumberFormatException unused) {
                return i;
            }
        }

        public static boolean b(ContentResolver contentResolver, String str, int i) {
            return a(contentResolver, str, Integer.toString(i));
        }
    }

    public static Bundle a(String str, String[] strArr, String str2) {
        if (str == null && strArr == null && str2 == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        if (str != null) {
            bundle.putString("android:query-arg-sql-selection", str);
        }
        if (strArr != null) {
            bundle.putStringArray("android:query-arg-sql-selection-args", strArr);
        }
        if (str2 != null) {
            bundle.putString("android:query-arg-sql-sort-order", str2);
        }
        return bundle;
    }
}
