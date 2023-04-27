package com.airbnb.lottie.d;

import android.content.Context;
import com.airbnb.lottie.f.d;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: NetworkCache */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private final Context f1726a;

    public b(Context context) {
        this.f1726a = context.getApplicationContext();
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public androidx.core.f.d<com.airbnb.lottie.d.a, java.io.InputStream> a(java.lang.String r6) {
        /*
            r5 = this;
            r0 = 0
            java.io.File r1 = r5.b(r6)     // Catch:{ FileNotFoundException -> 0x0044 }
            if (r1 != 0) goto L_0x0008
            return r0
        L_0x0008:
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{  }
            r2.<init>(r1)     // Catch:{  }
            java.lang.String r0 = r1.getAbsolutePath()
            java.lang.String r3 = ".zip"
            boolean r0 = r0.endsWith(r3)
            if (r0 == 0) goto L_0x001c
            com.airbnb.lottie.d.a r0 = com.airbnb.lottie.d.a.ZIP
            goto L_0x001e
        L_0x001c:
            com.airbnb.lottie.d.a r0 = com.airbnb.lottie.d.a.JSON
        L_0x001e:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Cache hit for "
            r3.append(r4)
            r3.append(r6)
            java.lang.String r6 = " at "
            r3.append(r6)
            java.lang.String r6 = r1.getAbsolutePath()
            r3.append(r6)
            java.lang.String r6 = r3.toString()
            com.airbnb.lottie.f.d.a(r6)
            androidx.core.f.d r6 = new androidx.core.f.d
            r6.<init>(r0, r2)
            return r6
        L_0x0044:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.d.b.a(java.lang.String):androidx.core.f.d");
    }

    /* access modifiers changed from: package-private */
    public File a(String str, InputStream inputStream, a aVar) throws IOException {
        FileOutputStream fileOutputStream;
        File file = new File(a(), a(str, aVar, true));
        try {
            fileOutputStream = new FileOutputStream(file);
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    fileOutputStream.write(bArr, 0, read);
                } else {
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    inputStream.close();
                    return file;
                }
            }
        } catch (Throwable th) {
            inputStream.close();
            throw th;
        }
    }

    /* access modifiers changed from: package-private */
    public void a(String str, a aVar) {
        File file = new File(a(), a(str, aVar, true));
        File file2 = new File(file.getAbsolutePath().replace(".temp", ""));
        boolean renameTo = file.renameTo(file2);
        d.a("Copying temp file to real file (" + file2 + ")");
        if (!renameTo) {
            d.b("Unable to rename cache file " + file.getAbsolutePath() + " to " + file2.getAbsolutePath() + ".");
        }
    }

    private File b(String str) throws FileNotFoundException {
        File file = new File(a(), a(str, a.JSON, false));
        if (file.exists()) {
            return file;
        }
        File file2 = new File(a(), a(str, a.ZIP, false));
        if (file2.exists()) {
            return file2;
        }
        return null;
    }

    private File a() {
        File file = new File(this.f1726a.getCacheDir(), "lottie_network_cache");
        if (file.isFile()) {
            file.delete();
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    private static String a(String str, a aVar, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("lottie_cache_");
        sb.append(str.replaceAll("\\W+", ""));
        sb.append(z ? aVar.tempExtension() : aVar.extension);
        return sb.toString();
    }
}
