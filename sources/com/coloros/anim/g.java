package com.coloros.anim;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.util.JsonReader;
import com.coloros.anim.d.c;
import com.coloros.anim.e.i;
import com.coloros.anim.f.b;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* compiled from: EffectiveCompositionFactory */
public class g {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final Map<String, f<a>> f2461a = new HashMap();

    public static f<a> a(final Context context, final String str) {
        if (b.f2453b) {
            b.b("EffectiveCompositionFactory::fromUrl url = " + str.toString());
        }
        return a("url_" + str, (Callable<e<a>>) new Callable<e<a>>() {
            /* renamed from: a */
            public e<a> call() {
                return c.a(context, str);
            }
        });
    }

    public static f<a> a(final AssetManager assetManager, final String str) {
        if (b.f2453b) {
            b.b("EffectiveCompositionFactory::fromAsset fileName = " + str.toString());
        }
        return a(str, (Callable<e<a>>) new Callable<e<a>>() {
            /* renamed from: a */
            public e<a> call() {
                return g.b(assetManager, str);
            }
        });
    }

    public static e<a> b(AssetManager assetManager, String str) {
        if (b.f2453b) {
            b.b("EffectiveCompositionFactory::fromAssetSync fileName = " + str.toString());
        }
        try {
            String str2 = "asset_" + str;
            if (str.endsWith(".zip")) {
                return a(new ZipInputStream(assetManager.open(str)), str2);
            }
            return a(assetManager.open(str), str2);
        } catch (IOException e) {
            return new e<>((Throwable) e);
        }
    }

    public static f<a> a(Context context, final int i) {
        if (b.f2453b) {
            b.b("EffectiveCompositionFactory::fromRawRes.");
        }
        final Context applicationContext = context.getApplicationContext();
        return a(a(i), (Callable<e<a>>) new Callable<e<a>>() {
            /* renamed from: a */
            public e<a> call() {
                return g.c(applicationContext, i);
            }
        });
    }

    public static f<a> b(Context context, final int i) {
        if (b.f2453b) {
            b.b("EffectiveCompositionFactory::fromRawResUsingActivityContext.");
        }
        final WeakReference weakReference = new WeakReference(context);
        return a(a(i), (Callable<e<a>>) new Callable<e<a>>() {
            /* renamed from: a */
            public e<a> call() {
                WeakReference weakReference = weakReference;
                if (weakReference == null || weakReference.get() == null) {
                    return null;
                }
                return g.c((Context) weakReference.get(), i);
            }
        });
    }

    public static e<a> c(Context context, int i) {
        if (b.f2453b) {
            b.b("EffectiveCompositionFactory::fromRawResSync.");
        }
        try {
            return a(context.getResources().openRawResource(i), a(i));
        } catch (Resources.NotFoundException e) {
            return new e<>((Throwable) e);
        }
    }

    private static String a(int i) {
        return "rawRes_" + i;
    }

    public static e<a> a(InputStream inputStream, String str) {
        if (b.f2453b) {
            b.b("EffectiveCompositionFactory::fromJsonInputStreamSync cacheKey = " + str);
        }
        return a(inputStream, str, true);
    }

    private static e<a> a(InputStream inputStream, String str, boolean z) {
        try {
            return b(new JsonReader(new InputStreamReader(inputStream)), str);
        } finally {
            if (z) {
                com.coloros.anim.f.g.a((Closeable) inputStream);
            }
        }
    }

    public static f<a> a(final JsonReader jsonReader, final String str) {
        if (b.f2453b) {
            b.b("EffectiveCompositionFactory::fromJsonReader cacheKey = " + str);
        }
        return a(str, (Callable<e<a>>) new Callable<e<a>>() {
            /* renamed from: a */
            public e<a> call() {
                return g.b(jsonReader, str);
            }
        });
    }

    public static e<a> b(JsonReader jsonReader, String str) {
        if (b.f2453b) {
            b.b("EffectiveCompositionFactory::fromJsonReaderSync cacheKey = " + str);
        }
        return a(jsonReader, str, true);
    }

    private static e<a> a(JsonReader jsonReader, String str, boolean z) {
        try {
            a a2 = i.a(jsonReader);
            com.coloros.anim.c.c.a().a(str, a2);
            e<a> eVar = new e<>(a2);
            if (z) {
                com.coloros.anim.f.g.a((Closeable) jsonReader);
            }
            return eVar;
        } catch (Exception e) {
            e<a> eVar2 = new e<>((Throwable) e);
            if (z) {
                com.coloros.anim.f.g.a((Closeable) jsonReader);
            }
            return eVar2;
        } catch (Throwable th) {
            if (z) {
                com.coloros.anim.f.g.a((Closeable) jsonReader);
            }
            throw th;
        }
    }

    public static e<a> a(ZipInputStream zipInputStream, String str) {
        if (b.f2453b) {
            b.b("EffectiveCompositionFactory::fromZipStreamSync cacheKey = " + str);
        }
        try {
            return a(zipInputStream, str, (BitmapFactory.Options) null);
        } finally {
            com.coloros.anim.f.g.a((Closeable) zipInputStream);
        }
    }

    private static e<a> a(ZipInputStream zipInputStream, String str, BitmapFactory.Options options) {
        HashMap hashMap = new HashMap();
        if (b.f2453b) {
            b.b("EffectiveCompositionFactory::fromZipStreamSyncInternal cacheKey = " + str);
        }
        try {
            ZipEntry nextEntry = zipInputStream.getNextEntry();
            if (b.f2453b) {
                StringBuilder sb = new StringBuilder();
                sb.append("EffectiveCompositionFactory::fromZipStreamSyncInternal entry == null ? ");
                sb.append(nextEntry == null);
                b.b(sb.toString());
            }
            a aVar = null;
            while (nextEntry != null) {
                if (b.f2453b) {
                    b.b("EffectiveCompositionFactory::fromZipStreamSyncInternal entry.getName() = " + nextEntry.getName());
                }
                if (!nextEntry.getName().contains("__MACOSX")) {
                    if (!nextEntry.getName().contains("../")) {
                        if (nextEntry.getName().endsWith(".json")) {
                            aVar = a(new JsonReader(new InputStreamReader(zipInputStream)), (String) null, false).a();
                        } else if (nextEntry.getName().endsWith(".png")) {
                            String[] split = nextEntry.getName().split("/");
                            hashMap.put(split[split.length - 1], BitmapFactory.decodeStream(zipInputStream, (Rect) null, options));
                        } else {
                            zipInputStream.closeEntry();
                        }
                        nextEntry = zipInputStream.getNextEntry();
                    }
                }
                zipInputStream.closeEntry();
                nextEntry = zipInputStream.getNextEntry();
            }
            if (aVar == null) {
                return new e<>((Throwable) new IllegalArgumentException("Unable to parse composition"));
            }
            for (Map.Entry entry : hashMap.entrySet()) {
                h a2 = a(aVar, (String) entry.getKey());
                if (a2 != null) {
                    a2.a((Bitmap) entry.getValue());
                }
            }
            for (Map.Entry next : aVar.l().entrySet()) {
                if (((h) next.getValue()).c() == null) {
                    return new e<>((Throwable) new IllegalStateException("There is no image for " + ((h) next.getValue()).b()));
                }
            }
            com.coloros.anim.c.c.a().a(str, aVar);
            return new e<>(aVar);
        } catch (IOException e) {
            return new e<>((Throwable) e);
        }
    }

    private static h a(a aVar, String str) {
        for (h next : aVar.l().values()) {
            if (next.b().equals(str)) {
                return next;
            }
        }
        return null;
    }

    private static f<a> a(final String str, Callable<e<a>> callable) {
        final a a2 = str == null ? null : com.coloros.anim.c.c.a().a(str);
        float f = Resources.getSystem().getDisplayMetrics().density;
        if (a2 == null || a2.n() != f) {
            if (!(a2 == null || a2.n() == f)) {
                com.coloros.anim.f.g.b();
                b.b("EffectiveCompositionFactory::cachedComposition density = " + a2.n() + "; curDensity = " + f);
            }
            if (str != null && f2461a.containsKey(str)) {
                return f2461a.get(str);
            }
            f<a> fVar = new f<>(callable);
            fVar.a((c<a>) new c<a>() {
                public void a(a aVar) {
                    if (str != null) {
                        com.coloros.anim.c.c.a().a(str, aVar);
                    }
                    g.f2461a.remove(str);
                }
            });
            fVar.c(new c<Throwable>() {
                public void a(Throwable th) {
                    g.f2461a.remove(str);
                }
            });
            f2461a.put(str, fVar);
            return fVar;
        }
        b.b("EffectiveCompositionFactory::cached Composition isn't null, cacheKey is " + str);
        return new f<>(new Callable<e<a>>() {
            /* renamed from: a */
            public e<a> call() {
                return new e<>(a2);
            }
        }, true);
    }
}
