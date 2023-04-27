package com.oppo.camera.sticker.b;

import com.oppo.camera.sticker.c.d;
import com.oppo.camera.util.Util;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import okhttp3.OkHttpClient;

/* compiled from: OkHttpClientHelper */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static volatile b f3635a;

    /* renamed from: b  reason: collision with root package name */
    private OkHttpClient f3636b = null;

    public static b a() {
        if (f3635a == null) {
            synchronized (b.class) {
                if (f3635a == null) {
                    f3635a = new b();
                }
            }
        }
        return f3635a;
    }

    public b() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(15, TimeUnit.SECONDS);
        builder.readTimeout(15, TimeUnit.SECONDS);
        builder.writeTimeout(15, TimeUnit.SECONDS);
        if (d.d(Util.f())) {
            builder.sslSocketFactory(c.a(), new c());
            builder.hostnameVerifier(new HostnameVerifier() {
                public boolean verify(String str, SSLSession sSLSession) {
                    return HttpsURLConnection.getDefaultHostnameVerifier().verify(str, sSLSession);
                }
            });
        }
        this.f3636b = builder.build();
    }

    public OkHttpClient b() {
        return this.f3636b;
    }
}
