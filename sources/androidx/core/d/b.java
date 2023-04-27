package androidx.core.d;

import android.content.ContentUris;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Build;
import android.os.CancellationSignal;
import androidx.collection.LruCache;
import androidx.collection.SimpleArrayMap;
import androidx.core.d.c;
import androidx.core.graphics.f;
import androidx.core.graphics.m;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: FontsContractCompat */
public class b {

    /* renamed from: a  reason: collision with root package name */
    static final LruCache<String, Typeface> f629a = new LruCache<>(16);

    /* renamed from: b  reason: collision with root package name */
    static final Object f630b = new Object();
    static final SimpleArrayMap<String, ArrayList<c.a<c>>> c = new SimpleArrayMap<>();
    private static final c d = new c("fonts", 10, 10000);
    private static final Comparator<byte[]> e = new Comparator<byte[]>() {
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v2, resolved type: byte} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v2, resolved type: byte} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v5, resolved type: byte} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v4, resolved type: byte} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v6, resolved type: byte} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v5, resolved type: byte} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int compare(byte[] r5, byte[] r6) {
            /*
                r4 = this;
                int r0 = r5.length
                int r1 = r6.length
                if (r0 == r1) goto L_0x0008
                int r5 = r5.length
                int r6 = r6.length
            L_0x0006:
                int r5 = r5 - r6
                return r5
            L_0x0008:
                r0 = 0
                r1 = r0
            L_0x000a:
                int r2 = r5.length
                if (r1 >= r2) goto L_0x001b
                byte r2 = r5[r1]
                byte r3 = r6[r1]
                if (r2 == r3) goto L_0x0018
                byte r5 = r5[r1]
                byte r6 = r6[r1]
                goto L_0x0006
            L_0x0018:
                int r1 = r1 + 1
                goto L_0x000a
            L_0x001b:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.core.d.b.AnonymousClass4.compare(byte[], byte[]):int");
        }
    };

    static c a(Context context, a aVar, int i) {
        try {
            a a2 = a(context, (CancellationSignal) null, aVar);
            int i2 = -3;
            if (a2.a() == 0) {
                Typeface a3 = f.a(context, (CancellationSignal) null, a2.b(), i);
                if (a3 != null) {
                    i2 = 0;
                }
                return new c(a3, i2);
            }
            if (a2.a() == 1) {
                i2 = -2;
            }
            return new c((Typeface) null, i2);
        } catch (PackageManager.NameNotFoundException unused) {
            return new c((Typeface) null, -1);
        }
    }

    /* compiled from: FontsContractCompat */
    private static final class c {

        /* renamed from: a  reason: collision with root package name */
        final Typeface f640a;

        /* renamed from: b  reason: collision with root package name */
        final int f641b;

        c(Typeface typeface, int i) {
            this.f640a = typeface;
            this.f641b = i;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0074, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0085, code lost:
        d.a(r1, new androidx.core.d.b.AnonymousClass3());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x008f, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.graphics.Typeface a(final android.content.Context r2, final androidx.core.d.a r3, final androidx.core.content.a.f.a r4, final android.os.Handler r5, boolean r6, int r7, final int r8) {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = r3.f()
            r0.append(r1)
            java.lang.String r1 = "-"
            r0.append(r1)
            r0.append(r8)
            java.lang.String r0 = r0.toString()
            androidx.collection.LruCache<java.lang.String, android.graphics.Typeface> r1 = f629a
            java.lang.Object r1 = r1.get(r0)
            android.graphics.Typeface r1 = (android.graphics.Typeface) r1
            if (r1 == 0) goto L_0x0028
            if (r4 == 0) goto L_0x0027
            r4.onFontRetrieved(r1)
        L_0x0027:
            return r1
        L_0x0028:
            if (r6 == 0) goto L_0x0045
            r1 = -1
            if (r7 != r1) goto L_0x0045
            androidx.core.d.b$c r2 = a((android.content.Context) r2, (androidx.core.d.a) r3, (int) r8)
            if (r4 == 0) goto L_0x0042
            int r3 = r2.f641b
            if (r3 != 0) goto L_0x003d
            android.graphics.Typeface r3 = r2.f640a
            r4.callbackSuccessAsync(r3, r5)
            goto L_0x0042
        L_0x003d:
            int r3 = r2.f641b
            r4.callbackFailAsync(r3, r5)
        L_0x0042:
            android.graphics.Typeface r2 = r2.f640a
            return r2
        L_0x0045:
            androidx.core.d.b$1 r1 = new androidx.core.d.b$1
            r1.<init>(r2, r3, r8, r0)
            r2 = 0
            if (r6 == 0) goto L_0x0058
            androidx.core.d.c r3 = d     // Catch:{ InterruptedException -> 0x0057 }
            java.lang.Object r3 = r3.a(r1, (int) r7)     // Catch:{ InterruptedException -> 0x0057 }
            androidx.core.d.b$c r3 = (androidx.core.d.b.c) r3     // Catch:{ InterruptedException -> 0x0057 }
            android.graphics.Typeface r2 = r3.f640a     // Catch:{ InterruptedException -> 0x0057 }
        L_0x0057:
            return r2
        L_0x0058:
            if (r4 != 0) goto L_0x005c
            r3 = r2
            goto L_0x0061
        L_0x005c:
            androidx.core.d.b$2 r3 = new androidx.core.d.b$2
            r3.<init>(r4, r5)
        L_0x0061:
            java.lang.Object r4 = f630b
            monitor-enter(r4)
            androidx.collection.SimpleArrayMap<java.lang.String, java.util.ArrayList<androidx.core.d.c$a<androidx.core.d.b$c>>> r5 = c     // Catch:{ all -> 0x0090 }
            java.lang.Object r5 = r5.get(r0)     // Catch:{ all -> 0x0090 }
            java.util.ArrayList r5 = (java.util.ArrayList) r5     // Catch:{ all -> 0x0090 }
            if (r5 == 0) goto L_0x0075
            if (r3 == 0) goto L_0x0073
            r5.add(r3)     // Catch:{ all -> 0x0090 }
        L_0x0073:
            monitor-exit(r4)     // Catch:{ all -> 0x0090 }
            return r2
        L_0x0075:
            if (r3 == 0) goto L_0x0084
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch:{ all -> 0x0090 }
            r5.<init>()     // Catch:{ all -> 0x0090 }
            r5.add(r3)     // Catch:{ all -> 0x0090 }
            androidx.collection.SimpleArrayMap<java.lang.String, java.util.ArrayList<androidx.core.d.c$a<androidx.core.d.b$c>>> r3 = c     // Catch:{ all -> 0x0090 }
            r3.put(r0, r5)     // Catch:{ all -> 0x0090 }
        L_0x0084:
            monitor-exit(r4)     // Catch:{ all -> 0x0090 }
            androidx.core.d.c r3 = d
            androidx.core.d.b$3 r4 = new androidx.core.d.b$3
            r4.<init>(r0)
            r3.a(r1, r4)
            return r2
        L_0x0090:
            r2 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x0090 }
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.d.b.a(android.content.Context, androidx.core.d.a, androidx.core.content.a.f$a, android.os.Handler, boolean, int, int):android.graphics.Typeface");
    }

    /* renamed from: androidx.core.d.b$b  reason: collision with other inner class name */
    /* compiled from: FontsContractCompat */
    public static class C0015b {

        /* renamed from: a  reason: collision with root package name */
        private final Uri f638a;

        /* renamed from: b  reason: collision with root package name */
        private final int f639b;
        private final int c;
        private final boolean d;
        private final int e;

        public C0015b(Uri uri, int i, int i2, boolean z, int i3) {
            this.f638a = (Uri) androidx.core.f.f.a(uri);
            this.f639b = i;
            this.c = i2;
            this.d = z;
            this.e = i3;
        }

        public Uri a() {
            return this.f638a;
        }

        public int b() {
            return this.f639b;
        }

        public int c() {
            return this.c;
        }

        public boolean d() {
            return this.d;
        }

        public int e() {
            return this.e;
        }
    }

    /* compiled from: FontsContractCompat */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private final int f636a;

        /* renamed from: b  reason: collision with root package name */
        private final C0015b[] f637b;

        public a(int i, C0015b[] bVarArr) {
            this.f636a = i;
            this.f637b = bVarArr;
        }

        public int a() {
            return this.f636a;
        }

        public C0015b[] b() {
            return this.f637b;
        }
    }

    public static Map<Uri, ByteBuffer> a(Context context, C0015b[] bVarArr, CancellationSignal cancellationSignal) {
        HashMap hashMap = new HashMap();
        for (C0015b bVar : bVarArr) {
            if (bVar.e() == 0) {
                Uri a2 = bVar.a();
                if (!hashMap.containsKey(a2)) {
                    hashMap.put(a2, m.a(context, cancellationSignal, a2));
                }
            }
        }
        return Collections.unmodifiableMap(hashMap);
    }

    public static a a(Context context, CancellationSignal cancellationSignal, a aVar) throws PackageManager.NameNotFoundException {
        ProviderInfo a2 = a(context.getPackageManager(), aVar, context.getResources());
        if (a2 == null) {
            return new a(1, (C0015b[]) null);
        }
        return new a(0, a(context, aVar, a2.authority, cancellationSignal));
    }

    public static ProviderInfo a(PackageManager packageManager, a aVar, Resources resources) throws PackageManager.NameNotFoundException {
        String a2 = aVar.a();
        ProviderInfo resolveContentProvider = packageManager.resolveContentProvider(a2, 0);
        if (resolveContentProvider == null) {
            throw new PackageManager.NameNotFoundException("No package found for authority: " + a2);
        } else if (resolveContentProvider.packageName.equals(aVar.b())) {
            List<byte[]> a3 = a(packageManager.getPackageInfo(resolveContentProvider.packageName, 64).signatures);
            Collections.sort(a3, e);
            List<List<byte[]>> a4 = a(aVar, resources);
            for (int i = 0; i < a4.size(); i++) {
                ArrayList arrayList = new ArrayList(a4.get(i));
                Collections.sort(arrayList, e);
                if (a(a3, (List<byte[]>) arrayList)) {
                    return resolveContentProvider;
                }
            }
            return null;
        } else {
            throw new PackageManager.NameNotFoundException("Found content provider " + a2 + ", but package was not " + aVar.b());
        }
    }

    private static List<List<byte[]>> a(a aVar, Resources resources) {
        if (aVar.d() != null) {
            return aVar.d();
        }
        return androidx.core.content.a.c.a(resources, aVar.e());
    }

    private static boolean a(List<byte[]> list, List<byte[]> list2) {
        if (list.size() != list2.size()) {
            return false;
        }
        for (int i = 0; i < list.size(); i++) {
            if (!Arrays.equals(list.get(i), list2.get(i))) {
                return false;
            }
        }
        return true;
    }

    private static List<byte[]> a(Signature[] signatureArr) {
        ArrayList arrayList = new ArrayList();
        for (Signature byteArray : signatureArr) {
            arrayList.add(byteArray.toByteArray());
        }
        return arrayList;
    }

    static C0015b[] a(Context context, a aVar, String str, CancellationSignal cancellationSignal) {
        Uri uri;
        Cursor query;
        String str2 = str;
        ArrayList arrayList = new ArrayList();
        Uri build = new Uri.Builder().scheme("content").authority(str2).build();
        Uri build2 = new Uri.Builder().scheme("content").authority(str2).appendPath("file").build();
        Cursor cursor = null;
        try {
            if (Build.VERSION.SDK_INT > 16) {
                query = context.getContentResolver().query(build, new String[]{"_id", "file_id", "font_ttc_index", "font_variation_settings", "font_weight", "font_italic", "result_code"}, "query = ?", new String[]{aVar.c()}, (String) null, cancellationSignal);
            } else {
                query = context.getContentResolver().query(build, new String[]{"_id", "file_id", "font_ttc_index", "font_variation_settings", "font_weight", "font_italic", "result_code"}, "query = ?", new String[]{aVar.c()}, (String) null);
            }
            if (cursor != null && cursor.getCount() > 0) {
                int columnIndex = cursor.getColumnIndex("result_code");
                ArrayList arrayList2 = new ArrayList();
                int columnIndex2 = cursor.getColumnIndex("_id");
                int columnIndex3 = cursor.getColumnIndex("file_id");
                int columnIndex4 = cursor.getColumnIndex("font_ttc_index");
                int columnIndex5 = cursor.getColumnIndex("font_weight");
                int columnIndex6 = cursor.getColumnIndex("font_italic");
                while (cursor.moveToNext()) {
                    int i = columnIndex != -1 ? cursor.getInt(columnIndex) : 0;
                    int i2 = columnIndex4 != -1 ? cursor.getInt(columnIndex4) : 0;
                    if (columnIndex3 == -1) {
                        uri = ContentUris.withAppendedId(build, cursor.getLong(columnIndex2));
                    } else {
                        uri = ContentUris.withAppendedId(build2, cursor.getLong(columnIndex3));
                    }
                    arrayList2.add(new C0015b(uri, i2, columnIndex5 != -1 ? cursor.getInt(columnIndex5) : 400, columnIndex6 != -1 && cursor.getInt(columnIndex6) == 1, i));
                }
                arrayList = arrayList2;
            }
            return (C0015b[]) arrayList.toArray(new C0015b[0]);
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }
}
