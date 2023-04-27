package com.airbnb.lottie.d;

import android.content.Context;
import com.airbnb.lottie.d;
import com.airbnb.lottie.e;
import com.airbnb.lottie.l;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.zip.ZipInputStream;

/* compiled from: NetworkFetcher */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private final Context f1727a;

    /* renamed from: b  reason: collision with root package name */
    private final String f1728b;
    private final b c;

    public static l<d> a(Context context, String str, String str2) {
        return new c(context, str, str2).a();
    }

    private c(Context context, String str, String str2) {
        this.f1727a = context.getApplicationContext();
        this.f1728b = str;
        if (str2 == null) {
            this.c = null;
        } else {
            this.c = new b(this.f1727a);
        }
    }

    public l<d> a() {
        d b2 = b();
        if (b2 != null) {
            return new l<>(b2);
        }
        com.airbnb.lottie.f.d.a("Animation for " + this.f1728b + " not found in cache. Fetching from network.");
        return c();
    }

    private d b() {
        androidx.core.f.d<a, InputStream> a2;
        l<d> lVar;
        b bVar = this.c;
        if (bVar == null || (a2 = bVar.a(this.f1728b)) == null) {
            return null;
        }
        a aVar = (a) a2.f676a;
        InputStream inputStream = (InputStream) a2.f677b;
        if (aVar == a.ZIP) {
            lVar = e.a(new ZipInputStream(inputStream), this.f1728b);
        } else {
            lVar = e.b(inputStream, this.f1728b);
        }
        if (lVar.a() != null) {
            return lVar.a();
        }
        return null;
    }

    private l<d> c() {
        try {
            return d();
        } catch (IOException e) {
            return new l<>((Throwable) e);
        }
    }

    private l<d> d() throws IOException {
        com.airbnb.lottie.f.d.a("Fetching " + this.f1728b);
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.f1728b).openConnection();
        httpURLConnection.setRequestMethod("GET");
        try {
            httpURLConnection.connect();
            if (httpURLConnection.getErrorStream() == null) {
                if (httpURLConnection.getResponseCode() == 200) {
                    l<d> b2 = b(httpURLConnection);
                    StringBuilder sb = new StringBuilder();
                    sb.append("Completed fetch from network. Success: ");
                    sb.append(b2.a() != null);
                    com.airbnb.lottie.f.d.a(sb.toString());
                    httpURLConnection.disconnect();
                    return b2;
                }
            }
            String a2 = a(httpURLConnection);
            return new l<>((Throwable) new IllegalArgumentException("Unable to fetch " + this.f1728b + ". Failed with " + httpURLConnection.getResponseCode() + "\n" + a2));
        } catch (Exception e) {
            return new l<>((Throwable) e);
        } finally {
            httpURLConnection.disconnect();
        }
    }

    private String a(HttpURLConnection httpURLConnection) throws IOException {
        httpURLConnection.getResponseCode();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getErrorStream()));
        StringBuilder sb = new StringBuilder();
        while (true) {
            try {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    sb.append(readLine);
                    sb.append(10);
                } else {
                    try {
                        break;
                    } catch (Exception unused) {
                    }
                }
            } catch (Exception e) {
                throw e;
            } catch (Throwable th) {
                try {
                    bufferedReader.close();
                } catch (Exception unused2) {
                }
                throw th;
            }
        }
        bufferedReader.close();
        return sb.toString();
    }

    private l<d> b(HttpURLConnection httpURLConnection) throws IOException {
        l<d> lVar;
        a aVar;
        String contentType = httpURLConnection.getContentType();
        if (contentType == null) {
            contentType = "application/json";
        }
        if (contentType.contains("application/zip")) {
            com.airbnb.lottie.f.d.a("Handling zip response.");
            aVar = a.ZIP;
            b bVar = this.c;
            if (bVar == null) {
                lVar = e.a(new ZipInputStream(httpURLConnection.getInputStream()), (String) null);
            } else {
                lVar = e.a(new ZipInputStream(new FileInputStream(bVar.a(this.f1728b, httpURLConnection.getInputStream(), aVar))), this.f1728b);
            }
        } else {
            com.airbnb.lottie.f.d.a("Received json response.");
            aVar = a.JSON;
            b bVar2 = this.c;
            if (bVar2 == null) {
                lVar = e.b(httpURLConnection.getInputStream(), (String) null);
            } else {
                lVar = e.b((InputStream) new FileInputStream(new File(bVar2.a(this.f1728b, httpURLConnection.getInputStream(), aVar).getAbsolutePath())), this.f1728b);
            }
        }
        if (!(this.c == null || lVar.a() == null)) {
            this.c.a(this.f1728b, aVar);
        }
        return lVar;
    }
}
