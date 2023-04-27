package com.oppo.camera.sticker.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Process;
import com.oppo.camera.R;
import com.oppo.camera.e;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: ImageDownloader */
public class c {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static ConcurrentHashMap<String, SoftReference<Drawable>> f3691a = new ConcurrentHashMap<>(10);
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static Map<String, C0098c> f3692b = new ConcurrentHashMap();
    private Context c;
    /* access modifiers changed from: private */
    public BitmapDrawable d = null;
    private int e = 0;
    private int f = 0;
    private int g = 0;
    private int h = 0;
    private HashMap<String, Drawable> i;

    public c(Context context, int i2) {
        this.c = context.getApplicationContext();
        try {
            this.d = (BitmapDrawable) context.getResources().getDrawable(i2);
        } catch (OutOfMemoryError unused) {
            System.gc();
        }
        a(10);
        this.h = this.c.getResources().getDimensionPixelSize(R.dimen.sticker_gridview_image_width);
        this.f = this.c.getResources().getDimensionPixelSize(R.dimen.sticker_gridview_redpoint_margin_top);
        this.g = this.c.getResources().getDimensionPixelSize(R.dimen.sticker_gridview_redpoint_radius);
        this.e = this.c.getResources().getDimensionPixelSize(R.dimen.sticker_gridview_thumbnail_display_size);
    }

    private void a(int i2) {
        final int i3 = i2;
        this.i = new LinkedHashMap<String, Drawable>(i2, 0.75f, false) {
            /* access modifiers changed from: protected */
            public boolean removeEldestEntry(Map.Entry<String, Drawable> entry) {
                if (size() <= i3) {
                    return false;
                }
                c.f3691a.put(entry.getKey(), new SoftReference(entry.getValue()));
                return true;
            }
        };
    }

    public void a(String str, String str2, d dVar) {
        BitmapDrawable bitmapDrawable;
        if (str != null || (bitmapDrawable = this.d) == null) {
            Drawable b2 = b(str);
            if (b2 == null) {
                b(str, str2, dVar);
                return;
            }
            a(str);
            a(dVar, b2);
            return;
        }
        a(dVar, (Drawable) bitmapDrawable);
    }

    private void b(String str, String str2, d dVar) {
        boolean z;
        C0098c cVar;
        if (str != null) {
            String a2 = a(dVar);
            if (!(a2 == null || a2.equals(str) || (cVar = f3692b.get(a2)) == null)) {
                cVar.b(dVar);
            }
            C0098c cVar2 = f3692b.get(str);
            if (cVar2 == null || cVar2.isCancelled()) {
                C0098c b2 = b(dVar);
                if (b2 != null) {
                    b2.cancel(true);
                }
                cVar2 = new C0098c();
                f3692b.put(str, cVar2);
                z = true;
            } else {
                z = false;
            }
            cVar2.a(dVar);
            if (z) {
                if (this.d != null) {
                    a(dVar, (Drawable) new b(this.c.getResources(), this.d, str, cVar2));
                } else {
                    a(dVar, (Drawable) new a(str, cVar2));
                }
                cVar2.execute(new String[]{str, str2});
            }
        }
    }

    private static boolean a(String str) {
        C0098c cVar;
        if (!(str == null || (cVar = f3692b.get(str)) == null)) {
            cVar.cancel(true);
        }
        return true;
    }

    private String a(d dVar) {
        if (dVar == null) {
            return null;
        }
        Drawable b2 = dVar.b();
        if (b2 instanceof a) {
            return ((a) b2).a();
        }
        if (b2 instanceof b) {
            return ((b) b2).a();
        }
        return null;
    }

    private C0098c b(d dVar) {
        if (dVar == null) {
            return null;
        }
        Drawable b2 = dVar.b();
        if (b2 instanceof a) {
            return ((a) b2).b();
        }
        if (b2 instanceof b) {
            return ((b) b2).b();
        }
        return null;
    }

    /* access modifiers changed from: private */
    public Drawable a(String str, String str2) {
        Drawable drawable;
        if ("parse_url".equals(str2)) {
            drawable = a(this.c, Uri.parse(str));
        } else {
            drawable = "parse_file".equals(str2) ? a(this.c, str) : null;
        }
        e.a("ImageDownloader", "downloadDrawable, drawable: " + drawable);
        return drawable;
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x003e A[SYNTHETIC, Splitter:B:25:0x003e] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0056 A[SYNTHETIC, Splitter:B:32:0x0056] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.graphics.drawable.Drawable a(android.content.Context r4, android.net.Uri r5) {
        /*
            r3 = this;
            android.content.ContentResolver r0 = r4.getContentResolver()
            r1 = 0
            java.io.InputStream r5 = r0.openInputStream(r5)     // Catch:{ FileNotFoundException -> 0x0037, all -> 0x0034 }
            android.graphics.Bitmap r0 = android.graphics.BitmapFactory.decodeStream(r5)     // Catch:{ FileNotFoundException -> 0x0032 }
            if (r0 == 0) goto L_0x002a
            android.graphics.drawable.BitmapDrawable r2 = new android.graphics.drawable.BitmapDrawable     // Catch:{ FileNotFoundException -> 0x0032 }
            android.content.res.Resources r4 = r4.getResources()     // Catch:{ FileNotFoundException -> 0x0032 }
            r2.<init>(r4, r0)     // Catch:{ FileNotFoundException -> 0x0032 }
            int r4 = r0.getDensity()     // Catch:{ FileNotFoundException -> 0x0032 }
            r2.setTargetDensity(r4)     // Catch:{ FileNotFoundException -> 0x0032 }
            if (r5 == 0) goto L_0x0029
            r5.close()     // Catch:{ IOException -> 0x0025 }
            goto L_0x0029
        L_0x0025:
            r4 = move-exception
            r4.printStackTrace()
        L_0x0029:
            return r2
        L_0x002a:
            if (r5 == 0) goto L_0x0046
            r5.close()     // Catch:{ IOException -> 0x0042 }
            goto L_0x0046
        L_0x0030:
            r4 = move-exception
            goto L_0x0054
        L_0x0032:
            r4 = move-exception
            goto L_0x0039
        L_0x0034:
            r4 = move-exception
            r5 = r1
            goto L_0x0054
        L_0x0037:
            r4 = move-exception
            r5 = r1
        L_0x0039:
            r4.printStackTrace()     // Catch:{ all -> 0x0030 }
            if (r5 == 0) goto L_0x0046
            r5.close()     // Catch:{ IOException -> 0x0042 }
            goto L_0x0046
        L_0x0042:
            r4 = move-exception
            r4.printStackTrace()
        L_0x0046:
            android.content.Context r4 = r3.c
            android.content.res.Resources r4 = r4.getResources()
            r5 = 2131231969(0x7f0804e1, float:1.8080034E38)
            android.graphics.drawable.Drawable r4 = r4.getDrawable(r5, r1)
            return r4
        L_0x0054:
            if (r5 == 0) goto L_0x005e
            r5.close()     // Catch:{ IOException -> 0x005a }
            goto L_0x005e
        L_0x005a:
            r5 = move-exception
            r5.printStackTrace()
        L_0x005e:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.sticker.ui.c.a(android.content.Context, android.net.Uri):android.graphics.drawable.Drawable");
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x0046 A[SYNTHETIC, Splitter:B:27:0x0046] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x005f A[SYNTHETIC, Splitter:B:35:0x005f] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.graphics.drawable.Drawable a(android.content.Context r4, java.lang.String r5) {
        /*
            r3 = this;
            java.io.File r0 = new java.io.File
            r0.<init>(r5)
            r5 = 0
            boolean r1 = r0.exists()     // Catch:{ FileNotFoundException -> 0x003f, all -> 0x003c }
            if (r1 == 0) goto L_0x0012
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x003f, all -> 0x003c }
            r1.<init>(r0)     // Catch:{ FileNotFoundException -> 0x003f, all -> 0x003c }
            goto L_0x0013
        L_0x0012:
            r1 = r5
        L_0x0013:
            android.graphics.Bitmap r0 = android.graphics.BitmapFactory.decodeStream(r1)     // Catch:{ FileNotFoundException -> 0x003a }
            if (r0 == 0) goto L_0x0034
            android.graphics.drawable.BitmapDrawable r2 = new android.graphics.drawable.BitmapDrawable     // Catch:{ FileNotFoundException -> 0x003a }
            android.content.res.Resources r4 = r4.getResources()     // Catch:{ FileNotFoundException -> 0x003a }
            r2.<init>(r4, r0)     // Catch:{ FileNotFoundException -> 0x003a }
            int r4 = r0.getDensity()     // Catch:{ FileNotFoundException -> 0x003a }
            r2.setTargetDensity(r4)     // Catch:{ FileNotFoundException -> 0x003a }
            if (r1 == 0) goto L_0x0033
            r1.close()     // Catch:{ IOException -> 0x002f }
            goto L_0x0033
        L_0x002f:
            r4 = move-exception
            r4.printStackTrace()
        L_0x0033:
            return r2
        L_0x0034:
            if (r1 == 0) goto L_0x004e
            r1.close()     // Catch:{ IOException -> 0x004a }
            goto L_0x004e
        L_0x003a:
            r4 = move-exception
            goto L_0x0041
        L_0x003c:
            r4 = move-exception
            r1 = r5
            goto L_0x005d
        L_0x003f:
            r4 = move-exception
            r1 = r5
        L_0x0041:
            r4.printStackTrace()     // Catch:{ all -> 0x005c }
            if (r1 == 0) goto L_0x004e
            r1.close()     // Catch:{ IOException -> 0x004a }
            goto L_0x004e
        L_0x004a:
            r4 = move-exception
            r4.printStackTrace()
        L_0x004e:
            android.content.Context r4 = r3.c
            android.content.res.Resources r4 = r4.getResources()
            r0 = 2131231969(0x7f0804e1, float:1.8080034E38)
            android.graphics.drawable.Drawable r4 = r4.getDrawable(r0, r5)
            return r4
        L_0x005c:
            r4 = move-exception
        L_0x005d:
            if (r1 == 0) goto L_0x0067
            r1.close()     // Catch:{ IOException -> 0x0063 }
            goto L_0x0067
        L_0x0063:
            r5 = move-exception
            r5.printStackTrace()
        L_0x0067:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.sticker.ui.c.a(android.content.Context, java.lang.String):android.graphics.drawable.Drawable");
    }

    /* renamed from: com.oppo.camera.sticker.ui.c$c  reason: collision with other inner class name */
    /* compiled from: ImageDownloader */
    class C0098c extends AsyncTask<String, Void, Drawable> {

        /* renamed from: a  reason: collision with root package name */
        public String f3697a;
        private final List<d> c = new ArrayList();
        private String d;

        C0098c() {
        }

        public void a(d dVar) {
            if (dVar != null && !a(dVar, false)) {
                this.c.add(dVar);
            }
        }

        private boolean a(d dVar, boolean z) {
            int size = this.c.size();
            int i = 0;
            while (i < size) {
                if (this.c.get(i) != dVar) {
                    i++;
                } else if (!z) {
                    return true;
                } else {
                    this.c.remove(i);
                    return true;
                }
            }
            return false;
        }

        public void b(d dVar) {
            a(dVar, true);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public Drawable doInBackground(String... strArr) {
            Process.setThreadPriority(10);
            this.f3697a = strArr[0];
            this.d = strArr[1];
            if (isCancelled()) {
                return null;
            }
            return c.this.a(this.f3697a, this.d);
        }

        /* access modifiers changed from: protected */
        public void onCancelled() {
            super.onCancelled();
            if (c.f3692b != null && this.f3697a != null) {
                c.f3692b.remove(this.f3697a);
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void onCancelled(Drawable drawable) {
            super.onCancelled(drawable);
            if (c.f3692b != null && this.f3697a != null) {
                c.f3692b.remove(this.f3697a);
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void onPostExecute(Drawable drawable) {
            e.a("ImageDownloader", "onPostExecute, isCancelled: " + isCancelled() + ", bitmap: " + drawable);
            c.f3692b.remove(this.f3697a);
            if (isCancelled()) {
                drawable = null;
            }
            if (drawable != null) {
                c.this.a(this.f3697a, drawable);
                c(drawable);
                return;
            }
            a();
        }

        private void c(Drawable drawable) {
            int size = this.c.size();
            for (int i = 0; i < size; i++) {
                d dVar = this.c.get(i);
                if (dVar != null) {
                    c.this.a(dVar, drawable);
                }
            }
            this.c.clear();
        }

        private void a() {
            int size = this.c.size();
            for (int i = 0; i < size; i++) {
                d dVar = this.c.get(i);
                if (!(dVar == null || c.this.d == null)) {
                    c cVar = c.this;
                    cVar.a(dVar, (Drawable) cVar.d);
                }
            }
            this.c.clear();
        }
    }

    /* compiled from: ImageDownloader */
    private static class a extends ColorDrawable {

        /* renamed from: a  reason: collision with root package name */
        private final WeakReference<String> f3693a;

        /* renamed from: b  reason: collision with root package name */
        private final WeakReference<C0098c> f3694b;

        public a(String str, C0098c cVar) {
            super(-1);
            this.f3693a = new WeakReference<>(str);
            this.f3694b = new WeakReference<>(cVar);
        }

        public String a() {
            return (String) this.f3693a.get();
        }

        public C0098c b() {
            return (C0098c) this.f3694b.get();
        }
    }

    /* compiled from: ImageDownloader */
    private static class b extends BitmapDrawable {

        /* renamed from: a  reason: collision with root package name */
        private final WeakReference<String> f3695a;

        /* renamed from: b  reason: collision with root package name */
        private final WeakReference<C0098c> f3696b;

        public b(Resources resources, BitmapDrawable bitmapDrawable, String str, C0098c cVar) {
            super(resources, bitmapDrawable.getBitmap());
            this.f3695a = new WeakReference<>(str);
            this.f3696b = new WeakReference<>(cVar);
        }

        public String a() {
            return (String) this.f3695a.get();
        }

        public C0098c b() {
            return (C0098c) this.f3696b.get();
        }
    }

    /* access modifiers changed from: private */
    public void a(String str, Drawable drawable) {
        if (drawable != null) {
            HashMap<String, Drawable> hashMap = this.i;
            if (hashMap != null) {
                synchronized (hashMap) {
                    this.i.put(str, drawable);
                }
            }
            ConcurrentHashMap<String, SoftReference<Drawable>> concurrentHashMap = f3691a;
            if (concurrentHashMap != null) {
                concurrentHashMap.put(str, new SoftReference(drawable));
            }
        }
    }

    private Drawable b(String str) {
        SoftReference softReference;
        if (str == null) {
            return null;
        }
        HashMap<String, Drawable> hashMap = this.i;
        if (hashMap != null) {
            synchronized (hashMap) {
                Drawable drawable = this.i.get(str);
                if (drawable != null) {
                    this.i.remove(str);
                    this.i.put(str, drawable);
                    return drawable;
                }
            }
        }
        ConcurrentHashMap<String, SoftReference<Drawable>> concurrentHashMap = f3691a;
        if (!(concurrentHashMap == null || (softReference = concurrentHashMap.get(str)) == null)) {
            Drawable drawable2 = (Drawable) softReference.get();
            if (drawable2 != null) {
                return drawable2;
            }
            f3691a.remove(str);
        }
        return null;
    }

    public void a() {
        HashMap<String, Drawable> hashMap = this.i;
        if (hashMap != null) {
            hashMap.clear();
        }
        this.d = null;
    }

    public static void b() {
        Map<String, C0098c> map = f3692b;
        if (map != null) {
            map.clear();
        }
        ConcurrentHashMap<String, SoftReference<Drawable>> concurrentHashMap = f3691a;
        if (concurrentHashMap != null) {
            concurrentHashMap.clear();
        }
    }

    /* access modifiers changed from: private */
    public void a(d dVar, Drawable drawable) {
        if (dVar == null || drawable == null) {
            e.a("ImageDownloader", "setImageDrawable, imageTagInfo: " + dVar + ", drawable: " + drawable);
            return;
        }
        a(dVar.a(), a(dVar.a(), drawable, dVar.f(), dVar.d(), dVar.e()), dVar.c());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0017, code lost:
        if (r5 != 16) goto L_0x002d;
     */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.graphics.drawable.Drawable a(com.oppo.camera.sticker.ui.b r3, android.graphics.drawable.Drawable r4, int r5, boolean r6, boolean r7) {
        /*
            r2 = this;
            if (r7 == 0) goto L_0x0006
            android.graphics.drawable.Drawable r4 = r2.a((android.graphics.drawable.Drawable) r4)
        L_0x0006:
            r7 = 8
            r0 = 1
            if (r5 == 0) goto L_0x0029
            if (r5 == r0) goto L_0x0024
            r1 = 2
            if (r5 == r1) goto L_0x0024
            r1 = 4
            if (r5 == r1) goto L_0x001f
            if (r5 == r7) goto L_0x001a
            r1 = 16
            if (r5 == r1) goto L_0x001f
            goto L_0x002d
        L_0x001a:
            android.graphics.drawable.Drawable r4 = r2.b(r3, r4)
            goto L_0x002d
        L_0x001f:
            android.graphics.drawable.Drawable r4 = r2.d(r3, r4)
            goto L_0x002d
        L_0x0024:
            android.graphics.drawable.Drawable r4 = r2.c(r3, r4)
            goto L_0x002d
        L_0x0029:
            android.graphics.drawable.Drawable r4 = r2.a((com.oppo.camera.sticker.ui.b) r3, (android.graphics.drawable.Drawable) r4)
        L_0x002d:
            int r3 = r4.getIntrinsicWidth()
            int r1 = r2.e
            if (r3 <= r1) goto L_0x0044
            android.graphics.drawable.Drawable[] r3 = new android.graphics.drawable.Drawable[r0]
            r0 = 0
            r3[r0] = r4
            android.graphics.drawable.LayerDrawable r4 = new android.graphics.drawable.LayerDrawable
            r4.<init>(r3)
            int r3 = r2.e
            r4.setLayerSize(r0, r3, r3)
        L_0x0044:
            if (r6 == 0) goto L_0x004c
            if (r7 == r5) goto L_0x004c
            android.graphics.drawable.LayerDrawable r4 = r2.b((android.graphics.drawable.Drawable) r4)
        L_0x004c:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.sticker.ui.c.a(com.oppo.camera.sticker.ui.b, android.graphics.drawable.Drawable, int, boolean, boolean):android.graphics.drawable.Drawable");
    }

    private Drawable a(Drawable drawable) {
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{drawable});
        Drawable drawable2 = this.c.getResources().getDrawable(R.drawable.sticker_music, (Resources.Theme) null);
        if (drawable2 != null) {
            layerDrawable.addLayer(drawable2);
        }
        return layerDrawable;
    }

    private Drawable a(b bVar, Drawable drawable) {
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{drawable});
        drawable.setAlpha(255);
        Drawable drawable2 = this.c.getResources().getDrawable(R.drawable.sticker_need_download, (Resources.Theme) null);
        if (drawable2 != null) {
            layerDrawable.addLayer(drawable2);
        }
        if (bVar.f3689a != null) {
            bVar.f3689a.setVisibility(8);
            bVar.f3689a.clearAnimation();
        }
        return layerDrawable;
    }

    private Drawable b(b bVar, Drawable drawable) {
        drawable.setAlpha(255);
        if (bVar.f3689a != null) {
            bVar.f3689a.setVisibility(8);
            bVar.f3689a.clearAnimation();
        }
        return drawable;
    }

    private Drawable c(b bVar, Drawable drawable) {
        drawable.setAlpha(127);
        if (bVar.f3689a != null) {
            bVar.f3689a.setVisibility(0);
            bVar.f3689a.a();
        }
        return drawable;
    }

    private Drawable d(b bVar, Drawable drawable) {
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{drawable});
        drawable.setAlpha(255);
        Drawable drawable2 = this.c.getResources().getDrawable(R.drawable.sticker_need_refresh, (Resources.Theme) null);
        if (drawable2 != null) {
            layerDrawable.addLayer(drawable2);
        }
        if (bVar.f3689a != null) {
            bVar.f3689a.setVisibility(8);
            bVar.f3689a.clearAnimation();
        }
        return layerDrawable;
    }

    private void a(b bVar, Drawable drawable, String str) {
        if (bVar.f3690b != null) {
            bVar.f3690b.setImageDrawable(drawable);
        }
    }

    private LayerDrawable b(Drawable drawable) {
        Drawable[] drawableArr = {drawable, this.c.getResources().getDrawable(R.drawable.sticker_red_point)};
        LayerDrawable layerDrawable = new LayerDrawable(drawableArr);
        int intrinsicWidth = drawableArr[0].getIntrinsicWidth();
        int intrinsicWidth2 = drawableArr[1].getIntrinsicWidth();
        int i2 = this.h;
        int i3 = (i2 - intrinsicWidth) / 2;
        int i4 = i3 + 0;
        int i5 = i2 - (intrinsicWidth + i3);
        int i6 = this.g;
        int i7 = i2 - ((intrinsicWidth2 / 2) + i6);
        int i8 = i6 - this.f;
        int i9 = i7 + intrinsicWidth2;
        int i10 = i7 - 0;
        int i11 = i8 + 0;
        int i12 = i2 - i9;
        int i13 = i2 - (intrinsicWidth2 + i8);
        if (i4 < 0 || i4 < 0 || i5 > 0 || i5 > 0) {
            e.e("ImageDownloader", "showRedPoint, drawable0 out of thumbnail display!");
        }
        LayerDrawable layerDrawable2 = layerDrawable;
        layerDrawable2.setLayerInset(0, i4, i4, i5, i5);
        layerDrawable2.setLayerInset(1, i10, i11, i12, i13);
        return layerDrawable;
    }
}
