package com.coloros.anim.d;

import android.content.Context;
import android.util.Pair;
import com.coloros.anim.a;
import com.coloros.anim.e;
import com.coloros.anim.g;
import com.coloros.anim.k;
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
    private final Context f2430a;

    /* renamed from: b  reason: collision with root package name */
    private final String f2431b;
    private final b c;

    private c(Context context, String str) {
        this.f2430a = context.getApplicationContext();
        this.f2431b = str;
        this.c = new b(this.f2430a, str);
    }

    public static e<a> a(Context context, String str) {
        return new c(context, str).a();
    }

    public e<a> a() {
        a b2 = b();
        if (b2 != null) {
            return new e<>(b2);
        }
        k.a("Animation for " + this.f2431b + " not found in cache. Fetching from network.");
        return c();
    }

    private a b() {
        e<a> eVar;
        Pair<a, InputStream> a2 = this.c.a();
        if (a2 == null) {
            return null;
        }
        a aVar = (a) a2.first;
        InputStream inputStream = (InputStream) a2.second;
        if (aVar == a.ZIP) {
            eVar = g.a(new ZipInputStream(inputStream), this.f2431b);
        } else {
            eVar = g.a(inputStream, this.f2431b);
        }
        if (eVar.a() != null) {
            return eVar.a();
        }
        return null;
    }

    private e<a> c() {
        try {
            return d();
        } catch (IOException e) {
            return new e<>((Throwable) e);
        }
    }

    private e d() throws IOException {
        a aVar;
        e<a> eVar;
        k.a("Fetching " + this.f2431b);
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.f2431b).openConnection();
        httpURLConnection.setRequestMethod("GET");
        httpURLConnection.connect();
        if (httpURLConnection.getErrorStream() == null && httpURLConnection.getResponseCode() == 200) {
            String contentType = httpURLConnection.getContentType();
            char c2 = 65535;
            int hashCode = contentType.hashCode();
            boolean z = true;
            if (hashCode != -1248325150) {
                if (hashCode == -43840953 && contentType.equals("application/json")) {
                    c2 = 1;
                }
            } else if (contentType.equals("application/zip")) {
                c2 = 0;
            }
            if (c2 != 0) {
                k.a("Received json response.");
                aVar = a.JSON;
                eVar = g.a((InputStream) new FileInputStream(new File(this.c.a(httpURLConnection.getInputStream(), aVar).getAbsolutePath())), this.f2431b);
            } else {
                k.a("Handling zip response.");
                aVar = a.ZIP;
                eVar = g.a(new ZipInputStream(new FileInputStream(this.c.a(httpURLConnection.getInputStream(), aVar))), this.f2431b);
            }
            if (eVar.a() != null) {
                this.c.a(aVar);
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Completed fetch from network. Success: ");
            if (eVar.a() == null) {
                z = false;
            }
            sb.append(z);
            k.a(sb.toString());
            return eVar;
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getErrorStream()));
        StringBuilder sb2 = new StringBuilder();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                sb2.append(readLine);
                sb2.append(10);
            } else {
                return new e((Throwable) new IllegalArgumentException("Unable to fetch " + this.f2431b + ". Failed with " + httpURLConnection.getResponseCode() + "\n" + sb2));
            }
        }
    }
}
