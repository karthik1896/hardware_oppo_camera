package com.airbnb.lottie;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.airbnb.lottie.c.g;
import com.airbnb.lottie.d.c;
import com.airbnb.lottie.e.t;
import com.airbnb.lottie.f.h;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import okio.Okio;

/* compiled from: LottieCompositionFactory */
public class e {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final Map<String, m<d>> f1729a = new HashMap();

    public static m<d> a(Context context, String str) {
        return a(context, str, "url_" + str);
    }

    public static m<d> a(final Context context, final String str, final String str2) {
        return a(str2, (Callable<l<d>>) new Callable<l<d>>() {
            /* renamed from: a */
            public l<d> call() {
                return c.a(context, str, str2);
            }
        });
    }

    public static m<d> b(Context context, String str) {
        return b(context, str, "asset_" + str);
    }

    public static m<d> b(Context context, final String str, final String str2) {
        final Context applicationContext = context.getApplicationContext();
        return a(str2, (Callable<l<d>>) new Callable<l<d>>() {
            /* renamed from: a */
            public l<d> call() {
                return e.c(applicationContext, str, str2);
            }
        });
    }

    public static l<d> c(Context context, String str, String str2) {
        try {
            if (str.endsWith(".zip")) {
                return a(new ZipInputStream(context.getAssets().open(str)), str2);
            }
            return b(context.getAssets().open(str), str2);
        } catch (IOException e) {
            return new l<>((Throwable) e);
        }
    }

    public static m<d> a(Context context, int i) {
        return a(context, i, c(context, i));
    }

    public static m<d> a(Context context, final int i, String str) {
        final WeakReference weakReference = new WeakReference(context);
        final Context applicationContext = context.getApplicationContext();
        return a(str, (Callable<l<d>>) new Callable<l<d>>() {
            /* renamed from: a */
            public l<d> call() {
                Context context = (Context) weakReference.get();
                if (context == null) {
                    context = applicationContext;
                }
                return e.b(context, i);
            }
        });
    }

    public static l<d> b(Context context, int i) {
        return b(context, i, c(context, i));
    }

    public static l<d> b(Context context, int i, String str) {
        try {
            return b(context.getResources().openRawResource(i), str);
        } catch (Resources.NotFoundException e) {
            return new l<>((Throwable) e);
        }
    }

    private static String c(Context context, int i) {
        StringBuilder sb = new StringBuilder();
        sb.append("rawRes");
        sb.append(a(context) ? "_night_" : "_day_");
        sb.append(i);
        return sb.toString();
    }

    private static boolean a(Context context) {
        return (context.getResources().getConfiguration().uiMode & 48) == 32;
    }

    public static m<d> a(final InputStream inputStream, final String str) {
        return a(str, (Callable<l<d>>) new Callable<l<d>>() {
            /* renamed from: a */
            public l<d> call() {
                return e.b(inputStream, str);
            }
        });
    }

    public static l<d> b(InputStream inputStream, String str) {
        return a(inputStream, str, true);
    }

    private static l<d> a(InputStream inputStream, String str, boolean z) {
        try {
            return a(com.airbnb.lottie.e.a.c.a(Okio.buffer(Okio.source(inputStream))), str);
        } finally {
            if (z) {
                h.a((Closeable) inputStream);
            }
        }
    }

    public static l<d> a(com.airbnb.lottie.e.a.c cVar, String str) {
        return a(cVar, str, true);
    }

    private static l<d> a(com.airbnb.lottie.e.a.c cVar, String str, boolean z) {
        try {
            d a2 = t.a(cVar);
            if (str != null) {
                g.a().a(str, a2);
            }
            l<d> lVar = new l<>(a2);
            if (z) {
                h.a((Closeable) cVar);
            }
            return lVar;
        } catch (Exception e) {
            l<d> lVar2 = new l<>((Throwable) e);
            if (z) {
                h.a((Closeable) cVar);
            }
            return lVar2;
        } catch (Throwable th) {
            if (z) {
                h.a((Closeable) cVar);
            }
            throw th;
        }
    }

    public static l<d> a(ZipInputStream zipInputStream, String str) {
        try {
            return b(zipInputStream, str);
        } finally {
            h.a((Closeable) zipInputStream);
        }
    }

    private static l<d> b(ZipInputStream zipInputStream, String str) {
        HashMap hashMap = new HashMap();
        try {
            ZipEntry nextEntry = zipInputStream.getNextEntry();
            d dVar = null;
            while (nextEntry != null) {
                String name = nextEntry.getName();
                if (name.contains("__MACOSX")) {
                    zipInputStream.closeEntry();
                } else if (nextEntry.getName().contains(".json")) {
                    dVar = a(com.airbnb.lottie.e.a.c.a(Okio.buffer(Okio.source((InputStream) zipInputStream))), (String) null, false).a();
                } else {
                    if (!name.contains(".png")) {
                        if (!name.contains(".webp")) {
                            zipInputStream.closeEntry();
                        }
                    }
                    String[] split = name.split("/");
                    hashMap.put(split[split.length - 1], BitmapFactory.decodeStream(zipInputStream));
                }
                nextEntry = zipInputStream.getNextEntry();
            }
            if (dVar == null) {
                return new l<>((Throwable) new IllegalArgumentException("Unable to parse composition"));
            }
            for (Map.Entry entry : hashMap.entrySet()) {
                g a2 = a(dVar, (String) entry.getKey());
                if (a2 != null) {
                    a2.a(h.a((Bitmap) entry.getValue(), a2.a(), a2.b()));
                }
            }
            for (Map.Entry next : dVar.l().entrySet()) {
                if (((g) next.getValue()).e() == null) {
                    return new l<>((Throwable) new IllegalStateException("There is no image for " + ((g) next.getValue()).d()));
                }
            }
            if (str != null) {
                g.a().a(str, dVar);
            }
            return new l<>(dVar);
        } catch (IOException e) {
            return new l<>((Throwable) e);
        }
    }

    private static g a(d dVar, String str) {
        for (g next : dVar.l().values()) {
            if (next.d().equals(str)) {
                return next;
            }
        }
        return null;
    }

    private static m<d> a(final String str, Callable<l<d>> callable) {
        final d a2 = str == null ? null : g.a().a(str);
        if (a2 != null) {
            return new m<>(new Callable<l<d>>() {
                /* renamed from: a */
                public l<d> call() {
                    return new l<>(d.this);
                }
            });
        }
        if (str != null && f1729a.containsKey(str)) {
            return f1729a.get(str);
        }
        m<d> mVar = new m<>(callable);
        if (str != null) {
            mVar.a((h<d>) new h<d>() {
                public void a(d dVar) {
                    e.f1729a.remove(str);
                }
            });
            mVar.c(new h<Throwable>() {
                public void a(Throwable th) {
                    e.f1729a.remove(str);
                }
            });
            f1729a.put(str, mVar);
        }
        return mVar;
    }
}
