package com.oppo.camera.q;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.UriPermission;
import android.net.Uri;
import android.os.Environment;
import android.os.storage.StorageVolume;
import android.provider.DocumentsContract;
import com.heytap.compat.os.UserHandleNative;
import com.heytap.compat.os.a.b;
import com.oppo.camera.z;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;

/* compiled from: DocumentUtil */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static int f3582a = 101;

    /* renamed from: b  reason: collision with root package name */
    public static String f3583b = "text/plain";
    public static String c = "image/jpeg";
    public static String d = "image/png";
    public static String e = "image/heic";
    public static String f = "image/x-adobe-dng";
    public static String g = "application/zip";
    public static String h = "application/octet-stream";
    public static String i = "audio/mpeg";
    public static String j = "video/mp4";
    public static String k = "video/3gp";
    private static Uri l;
    private static Context m;
    private static C0092a n;

    /* renamed from: com.oppo.camera.q.a$a  reason: collision with other inner class name */
    /* compiled from: DocumentUtil */
    public interface C0092a {
        void a();

        void b();
    }

    private static boolean d() {
        return true;
    }

    private static boolean g(String str) {
        return false;
    }

    private static StorageVolume c() {
        String str;
        if (m == null) {
            return null;
        }
        StorageVolume[] storageVolumeArr = new StorageVolume[0];
        try {
            storageVolumeArr = com.heytap.compat.os.a.a.a(UserHandleNative.myUserId(), 0);
        } catch (com.heytap.compat.d.a.a e2) {
            e2.printStackTrace();
        }
        if (storageVolumeArr == null) {
            return null;
        }
        for (StorageVolume storageVolume : storageVolumeArr) {
            try {
                str = b.a(storageVolume);
            } catch (com.heytap.compat.d.a.a e3) {
                e3.printStackTrace();
                str = null;
            }
            if ("mounted".equalsIgnoreCase(storageVolume.getState()) && str != null && Environment.isExternalStorageRemovable(new File(str))) {
                return storageVolume;
            }
        }
        return null;
    }

    public static boolean a() {
        if (z.g == null) {
            return false;
        }
        return f(z.g);
    }

    public static void a(Context context, C0092a aVar) {
        StorageVolume c2;
        Uri uri;
        m = context.getApplicationContext();
        if (!d() && (c2 = c()) != null) {
            String uuid = c2.getUuid();
            Iterator<UriPermission> it = context.getContentResolver().getPersistedUriPermissions().iterator();
            while (true) {
                if (!it.hasNext()) {
                    uri = null;
                    break;
                }
                UriPermission next = it.next();
                if (next.getUri().toString().contains(uuid)) {
                    uri = next.getUri();
                    break;
                }
            }
            if (uri != null) {
                l = uri;
            } else if (aVar != null && (context instanceof Activity)) {
                n = aVar;
                ((Activity) context).startActivityForResult(c2.createAccessIntent((String) null), f3582a);
            }
        }
    }

    public static void b() {
        n.b();
    }

    public static void a(Intent intent) {
        Context context = m;
        if (context != null) {
            context.getContentResolver().takePersistableUriPermission(intent.getData(), 3);
            l = intent.getData();
            n.a();
        }
    }

    private static Uri h(String str) {
        String str2;
        if (!a() || !g(str)) {
            return null;
        }
        String substring = str.substring(str.indexOf(File.separator, 1) + 1);
        if (substring.contains(File.separator)) {
            str2 = substring.replaceFirst(File.separator, ":");
        } else {
            str2 = substring + ":";
        }
        return DocumentsContract.buildDocumentUriUsingTree(l, str2);
    }

    public static boolean a(String str) {
        return new File(str).exists();
    }

    public static boolean b(String str) {
        return new File(str).isDirectory();
    }

    public static boolean c(String str) {
        if (!a(str)) {
            return true;
        }
        if (!g(str)) {
            return new File(str).delete();
        }
        try {
            DocumentsContract.deleteDocument(m.getContentResolver(), h(str));
            return true;
        } catch (FileNotFoundException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static byte[] d(String str) {
        if (m == null) {
            return null;
        }
        return a(str, (byte[]) null);
    }

    public static InputStream e(String str) throws FileNotFoundException {
        if (g(str)) {
            return m.getContentResolver().openInputStream(h(str));
        }
        return new FileInputStream(str);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0022, code lost:
        r5 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0023, code lost:
        r1 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0027, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0028, code lost:
        r3 = r1;
        r1 = r5;
        r5 = r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] a(java.lang.String r4, byte[] r5) {
        /*
            r0 = 0
            java.io.InputStream r4 = e(r4)     // Catch:{ IOException -> 0x003c }
            int r1 = r4.available()     // Catch:{ Throwable -> 0x0025, all -> 0x0022 }
            if (r5 == 0) goto L_0x000e
            int r2 = r5.length     // Catch:{ Throwable -> 0x0025, all -> 0x0022 }
            if (r2 >= r1) goto L_0x0010
        L_0x000e:
            byte[] r5 = new byte[r1]     // Catch:{ Throwable -> 0x0025, all -> 0x0022 }
        L_0x0010:
            int r2 = r4.read(r5)     // Catch:{ Throwable -> 0x0025, all -> 0x0022 }
            if (r1 != r2) goto L_0x001c
            if (r4 == 0) goto L_0x001b
            r4.close()     // Catch:{ IOException -> 0x003c }
        L_0x001b:
            return r5
        L_0x001c:
            if (r4 == 0) goto L_0x0021
            r4.close()     // Catch:{ IOException -> 0x003c }
        L_0x0021:
            return r0
        L_0x0022:
            r5 = move-exception
            r1 = r0
            goto L_0x002b
        L_0x0025:
            r5 = move-exception
            throw r5     // Catch:{ all -> 0x0027 }
        L_0x0027:
            r1 = move-exception
            r3 = r1
            r1 = r5
            r5 = r3
        L_0x002b:
            if (r4 == 0) goto L_0x003b
            if (r1 == 0) goto L_0x0038
            r4.close()     // Catch:{ Throwable -> 0x0033 }
            goto L_0x003b
        L_0x0033:
            r4 = move-exception
            r1.addSuppressed(r4)     // Catch:{ IOException -> 0x003c }
            goto L_0x003b
        L_0x0038:
            r4.close()     // Catch:{ IOException -> 0x003c }
        L_0x003b:
            throw r5     // Catch:{ IOException -> 0x003c }
        L_0x003c:
            r4 = move-exception
            r4.printStackTrace()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.q.a.a(java.lang.String, byte[]):byte[]");
    }

    public static OutputStream a(String str, String str2) throws FileNotFoundException {
        if (!c(str, str2)) {
            return null;
        }
        if (g(str)) {
            return m.getContentResolver().openOutputStream(h(str));
        }
        return new FileOutputStream(str);
    }

    public static boolean f(String str) {
        if (a(str)) {
            return b(str);
        }
        if (g(str)) {
            return i(str);
        }
        return new File(str).mkdirs();
    }

    public static boolean b(String str, String str2) {
        if ((g(str) && !g(str2)) || (!g(str) && g(str2))) {
            return false;
        }
        if (a(str2) && !c(str2)) {
            return false;
        }
        if (!g(str2)) {
            return new File(str).renameTo(new File(str2));
        }
        try {
            DocumentsContract.renameDocument(m.getContentResolver(), h(str), new File(str2).getName());
            return true;
        } catch (FileNotFoundException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static boolean a(String str, String str2, byte[] bArr) {
        File file = new File(str);
        String str3 = file.getParent() + File.separator + ("temp_" + file.getName());
        if (b(str3, str2, bArr)) {
            return b(str3, str);
        }
        return false;
    }

    public static boolean b(String str, String str2, byte[] bArr) {
        OutputStream a2;
        if (bArr == null) {
            return false;
        }
        try {
            a2 = a(str, str2);
            if (a2 != null) {
                a2.write(bArr);
                if (a2 != null) {
                    a2.close();
                }
                return true;
            }
            if (a2 != null) {
                a2.close();
            }
            return false;
        } catch (IOException e2) {
            e2.printStackTrace();
            return false;
        } catch (Throwable th) {
            r2.addSuppressed(th);
        }
        throw th;
    }

    public static boolean c(String str, String str2) {
        if (a(str)) {
            return true;
        }
        int lastIndexOf = str.lastIndexOf(File.separator);
        String substring = str.substring(0, lastIndexOf);
        if (g(str)) {
            if (i(substring)) {
                try {
                    DocumentsContract.createDocument(m.getContentResolver(), h(substring), str2, str.substring(lastIndexOf + 1));
                    return true;
                } catch (FileNotFoundException e2) {
                    e2.printStackTrace();
                }
            }
            return false;
        }
        File file = new File(substring);
        if (!file.exists() && !file.mkdirs()) {
            return false;
        }
        try {
            return new File(str).createNewFile();
        } catch (IOException e3) {
            e3.printStackTrace();
            return false;
        }
    }

    private static boolean i(String str) {
        if (a(str)) {
            return b(str);
        }
        int lastIndexOf = str.lastIndexOf("/");
        String substring = str.substring(0, lastIndexOf);
        if (i(substring)) {
            try {
                DocumentsContract.createDocument(m.getContentResolver(), h(substring), "vnd.android.document/directory", str.substring(lastIndexOf + 1));
                return true;
            } catch (FileNotFoundException e2) {
                e2.printStackTrace();
            }
        }
        return false;
    }
}
