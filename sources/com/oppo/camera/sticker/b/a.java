package com.oppo.camera.sticker.b;

import android.content.Context;
import android.text.TextUtils;
import com.oppo.camera.e;
import java.io.IOException;
import java.util.Map;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* compiled from: HttpRequestHelper */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private Context f3630a = null;

    /* renamed from: com.oppo.camera.sticker.b.a$a  reason: collision with other inner class name */
    /* compiled from: HttpRequestHelper */
    public interface C0096a {
        void a();

        void a(String str);
    }

    /* compiled from: HttpRequestHelper */
    public enum b {
        GET,
        POST
    }

    /* compiled from: HttpRequestHelper */
    public interface c {
        void a(String str);

        void a(ResponseBody responseBody);
    }

    public a(Context context) {
        this.f3630a = context;
    }

    public String a(Context context, int i) {
        String a2 = a(context);
        if (TextUtils.isEmpty(a2)) {
            a2 = "https://stickereu.apps.oppomobile.com";
        }
        return a2 + a(i);
    }

    private String a(Context context) {
        return com.oppo.camera.w.b.a(context);
    }

    private String a(int i) {
        return "/multi_app/all_sticker.pb?audit_status=" + i;
    }

    private static OkHttpClient a() {
        return b.a().b();
    }

    public Request a(b bVar, String str, Map<String, String> map, RequestBody requestBody) {
        Request.Builder url = new Request.Builder().url(str);
        if (bVar == b.POST) {
            if (map != null && !map.isEmpty()) {
                for (Map.Entry next : map.entrySet()) {
                    url.addHeader((String) next.getKey(), (String) next.getValue());
                }
            }
            if (requestBody != null) {
                url.post(requestBody);
            }
        } else {
            url.get();
        }
        return url.build();
    }

    public RequestBody a(byte[] bArr) {
        return RequestBody.create(MediaType.parse("application/x-protobuf"), bArr);
    }

    public void a(Request request, c cVar) {
        a(a(request), cVar);
    }

    public void a(Call call, final c cVar) {
        call.enqueue(new Callback() {
            public void onFailure(Call call, IOException iOException) {
                String message = iOException.getMessage();
                c cVar = cVar;
                if (cVar != null) {
                    cVar.a(message);
                }
                e.b("HttpRequestHelper", "asyncRequest, onFailure, errMsg: " + message);
            }

            public void onResponse(Call call, Response response) throws IOException {
                if (response == null) {
                    try {
                        e.d("HttpRequestHelper", "asyncRequest, onResponse, null response");
                        if (cVar != null) {
                            cVar.a("null response");
                        }
                        if (response != null) {
                            response.close();
                        }
                    } catch (Exception e) {
                        String message = e.getMessage();
                        if (cVar != null) {
                            cVar.a(message);
                        }
                        e.b("HttpRequestHelper", "asyncRequest, onResponse exception! errorMsg: " + message);
                        if (response == null) {
                        }
                    } catch (Throwable th) {
                        if (response != null) {
                            response.close();
                        }
                        throw th;
                    }
                } else {
                    if (!response.isSuccessful()) {
                        String message2 = response.message();
                        if (cVar != null) {
                            cVar.a(message2);
                        }
                        e.b("HttpRequestHelper", "asyncRequest, onResponse not successful! resMsg: " + message2);
                    } else if (cVar != null) {
                        cVar.a(response.body());
                    }
                    if (response == null) {
                        return;
                    }
                    response.close();
                }
            }
        });
    }

    public void a(Request request, final String str, final C0096a aVar) {
        a().newCall(request).enqueue(new Callback() {
            public void onFailure(Call call, IOException iOException) {
                String message = iOException.getMessage();
                C0096a aVar = aVar;
                if (aVar != null) {
                    aVar.a(message);
                }
                e.b("HttpRequestHelper", "downloadFile, onFailure, errMsg: " + message);
            }

            /* JADX WARNING: Removed duplicated region for block: B:36:0x00c8 A[SYNTHETIC, Splitter:B:36:0x00c8] */
            /* JADX WARNING: Removed duplicated region for block: B:41:0x00e1 A[SYNTHETIC, Splitter:B:41:0x00e1] */
            /* JADX WARNING: Removed duplicated region for block: B:47:0x00fb A[SYNTHETIC, Splitter:B:47:0x00fb] */
            /* JADX WARNING: Removed duplicated region for block: B:52:0x0114 A[SYNTHETIC, Splitter:B:52:0x0114] */
            /* JADX WARNING: Removed duplicated region for block: B:64:? A[RETURN, SYNTHETIC] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void onResponse(okhttp3.Call r9, okhttp3.Response r10) {
                /*
                    r8 = this;
                    java.lang.String r9 = "downloadFile, onResponse, exception, fose: "
                    java.lang.String r0 = "downloadFile, onResponse, exception, ie: "
                    boolean r1 = r10.isSuccessful()
                    java.lang.String r2 = "HttpRequestHelper"
                    if (r1 == 0) goto L_0x012c
                    okhttp3.ResponseBody r1 = r10.body()
                    java.io.InputStream r1 = r1.byteStream()
                    r3 = 0
                    r4 = 2048(0x800, float:2.87E-42)
                    byte[] r4 = new byte[r4]     // Catch:{ IOException -> 0x00b1 }
                    okhttp3.ResponseBody r10 = r10.body()     // Catch:{ IOException -> 0x00b1 }
                    long r5 = r10.contentLength()     // Catch:{ IOException -> 0x00b1 }
                    java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00b1 }
                    r10.<init>()     // Catch:{ IOException -> 0x00b1 }
                    java.lang.String r7 = "downloadFile, totalLen: "
                    r10.append(r7)     // Catch:{ IOException -> 0x00b1 }
                    r10.append(r5)     // Catch:{ IOException -> 0x00b1 }
                    java.lang.String r5 = ", destFilePath: "
                    r10.append(r5)     // Catch:{ IOException -> 0x00b1 }
                    java.lang.String r5 = r3     // Catch:{ IOException -> 0x00b1 }
                    r10.append(r5)     // Catch:{ IOException -> 0x00b1 }
                    java.lang.String r10 = r10.toString()     // Catch:{ IOException -> 0x00b1 }
                    com.oppo.camera.e.b(r2, r10)     // Catch:{ IOException -> 0x00b1 }
                    java.io.File r10 = new java.io.File     // Catch:{ IOException -> 0x00b1 }
                    java.lang.String r5 = r3     // Catch:{ IOException -> 0x00b1 }
                    r10.<init>(r5)     // Catch:{ IOException -> 0x00b1 }
                    boolean r5 = com.oppo.camera.sticker.c.b.a((java.io.File) r10)     // Catch:{ IOException -> 0x00b1 }
                    if (r5 == 0) goto L_0x0072
                    java.io.FileOutputStream r5 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x00b1 }
                    r5.<init>(r10)     // Catch:{ IOException -> 0x00b1 }
                L_0x0051:
                    int r10 = r1.read(r4)     // Catch:{ IOException -> 0x006f, all -> 0x006b }
                    r3 = -1
                    if (r10 == r3) goto L_0x005d
                    r3 = 0
                    r5.write(r4, r3, r10)     // Catch:{ IOException -> 0x006f, all -> 0x006b }
                    goto L_0x0051
                L_0x005d:
                    r5.flush()     // Catch:{ IOException -> 0x006f, all -> 0x006b }
                    com.oppo.camera.sticker.b.a$a r10 = r4     // Catch:{ IOException -> 0x006f, all -> 0x006b }
                    if (r10 == 0) goto L_0x0069
                    com.oppo.camera.sticker.b.a$a r10 = r4     // Catch:{ IOException -> 0x006f, all -> 0x006b }
                    r10.a()     // Catch:{ IOException -> 0x006f, all -> 0x006b }
                L_0x0069:
                    r3 = r5
                    goto L_0x0088
                L_0x006b:
                    r10 = move-exception
                    r3 = r5
                    goto L_0x00f9
                L_0x006f:
                    r10 = move-exception
                    r3 = r5
                    goto L_0x00b2
                L_0x0072:
                    java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00b1 }
                    r10.<init>()     // Catch:{ IOException -> 0x00b1 }
                    java.lang.String r4 = "downloadFile, delete exit file fail! destFilePath: "
                    r10.append(r4)     // Catch:{ IOException -> 0x00b1 }
                    java.lang.String r4 = r3     // Catch:{ IOException -> 0x00b1 }
                    r10.append(r4)     // Catch:{ IOException -> 0x00b1 }
                    java.lang.String r10 = r10.toString()     // Catch:{ IOException -> 0x00b1 }
                    com.oppo.camera.e.e(r2, r10)     // Catch:{ IOException -> 0x00b1 }
                L_0x0088:
                    if (r1 == 0) goto L_0x00a1
                    r1.close()     // Catch:{ IOException -> 0x008e }
                    goto L_0x00a1
                L_0x008e:
                    r10 = move-exception
                    java.lang.StringBuilder r1 = new java.lang.StringBuilder
                    r1.<init>()
                    r1.append(r0)
                    r1.append(r10)
                    java.lang.String r10 = r1.toString()
                    com.oppo.camera.e.d(r2, r10)
                L_0x00a1:
                    if (r3 == 0) goto L_0x014b
                    r3.close()     // Catch:{ IOException -> 0x00a8 }
                    goto L_0x014b
                L_0x00a8:
                    r10 = move-exception
                    java.lang.StringBuilder r0 = new java.lang.StringBuilder
                    r0.<init>()
                    goto L_0x00eb
                L_0x00af:
                    r10 = move-exception
                    goto L_0x00f9
                L_0x00b1:
                    r10 = move-exception
                L_0x00b2:
                    java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x00af }
                    r4.<init>()     // Catch:{ all -> 0x00af }
                    java.lang.String r5 = "downloadFile, onResponse, exception, e: "
                    r4.append(r5)     // Catch:{ all -> 0x00af }
                    r4.append(r10)     // Catch:{ all -> 0x00af }
                    java.lang.String r10 = r4.toString()     // Catch:{ all -> 0x00af }
                    com.oppo.camera.e.d(r2, r10)     // Catch:{ all -> 0x00af }
                    if (r1 == 0) goto L_0x00df
                    r1.close()     // Catch:{ IOException -> 0x00cc }
                    goto L_0x00df
                L_0x00cc:
                    r10 = move-exception
                    java.lang.StringBuilder r1 = new java.lang.StringBuilder
                    r1.<init>()
                    r1.append(r0)
                    r1.append(r10)
                    java.lang.String r10 = r1.toString()
                    com.oppo.camera.e.d(r2, r10)
                L_0x00df:
                    if (r3 == 0) goto L_0x014b
                    r3.close()     // Catch:{ IOException -> 0x00e5 }
                    goto L_0x014b
                L_0x00e5:
                    r10 = move-exception
                    java.lang.StringBuilder r0 = new java.lang.StringBuilder
                    r0.<init>()
                L_0x00eb:
                    r0.append(r9)
                    r0.append(r10)
                    java.lang.String r9 = r0.toString()
                    com.oppo.camera.e.d(r2, r9)
                    goto L_0x014b
                L_0x00f9:
                    if (r1 == 0) goto L_0x0112
                    r1.close()     // Catch:{ IOException -> 0x00ff }
                    goto L_0x0112
                L_0x00ff:
                    r1 = move-exception
                    java.lang.StringBuilder r4 = new java.lang.StringBuilder
                    r4.<init>()
                    r4.append(r0)
                    r4.append(r1)
                    java.lang.String r0 = r4.toString()
                    com.oppo.camera.e.d(r2, r0)
                L_0x0112:
                    if (r3 == 0) goto L_0x012b
                    r3.close()     // Catch:{ IOException -> 0x0118 }
                    goto L_0x012b
                L_0x0118:
                    r0 = move-exception
                    java.lang.StringBuilder r1 = new java.lang.StringBuilder
                    r1.<init>()
                    r1.append(r9)
                    r1.append(r0)
                    java.lang.String r9 = r1.toString()
                    com.oppo.camera.e.d(r2, r9)
                L_0x012b:
                    throw r10
                L_0x012c:
                    java.lang.String r9 = r10.message()
                    com.oppo.camera.sticker.b.a$a r10 = r4
                    if (r10 == 0) goto L_0x0137
                    r10.a(r9)
                L_0x0137:
                    java.lang.StringBuilder r10 = new java.lang.StringBuilder
                    r10.<init>()
                    java.lang.String r0 = "downloadFile, onResponse not successful! resMsg: "
                    r10.append(r0)
                    r10.append(r9)
                    java.lang.String r9 = r10.toString()
                    com.oppo.camera.e.b(r2, r9)
                L_0x014b:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.sticker.b.a.AnonymousClass2.onResponse(okhttp3.Call, okhttp3.Response):void");
            }
        });
    }

    public Call a(Request request) {
        return a().newCall(request);
    }
}
