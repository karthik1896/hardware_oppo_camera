package com.oppo.camera.ui.preview.a;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import color.support.v7.app.b;
import com.oplus.util.OplusNetworkUtil;
import com.oppo.camera.R;
import com.oppo.camera.e;
import com.oppo.camera.statistics.CameraStatisticsUtil;
import com.oppo.camera.sticker.data.StickerCategoryItem;
import com.oppo.camera.sticker.data.StickerItem;
import com.oppo.camera.sticker.g;
import com.oppo.camera.sticker.h;
import com.oppo.camera.sticker.ui.h;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: ImageStickerTools */
public class l {

    /* renamed from: a  reason: collision with root package name */
    private static l f4395a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static Object f4396b = new Object();
    private Context c = null;
    /* access modifiers changed from: private */
    public c d = new c();
    private SharedPreferences e;
    private HandlerThread f = null;
    private Handler g = null;
    /* access modifiers changed from: private */
    public p h = null;
    private long i = 1;
    private h j = null;
    /* access modifiers changed from: private */
    public HashMap<String, b> k = null;
    private boolean l = false;
    private int m = 0;
    /* access modifiers changed from: private */
    public boolean n = false;
    private color.support.v7.app.b o;
    /* access modifiers changed from: private */
    public StickerItem p;
    private com.oppo.camera.sticker.a q = new com.oppo.camera.sticker.a() {
        public void a(int i) {
            synchronized (l.f4396b) {
                if (i == 1) {
                    l.this.c();
                    if (l.this.h != null) {
                        l.this.h.a();
                    }
                }
            }
        }

        public void b(StickerItem stickerItem) {
            if (stickerItem == null) {
                e.e("ImageStickerTools", "onStickerDownloadSuccess return");
                return;
            }
            e.b("ImageStickerTools", "onStickerDownloadSuccess, item: " + stickerItem);
            stickerItem.setDownloadState(8);
            synchronized (l.f4396b) {
                l.this.c();
                if (l.this.h != null) {
                    l.this.h.b(stickerItem);
                }
            }
            if (l.this.k != null) {
                l.this.a((b) l.this.k.get(stickerItem.getStickerUUID()), true);
            }
        }

        public void a(StickerItem stickerItem) {
            e.b("ImageStickerTools", "onStickerDelete, item: " + stickerItem);
            if (stickerItem != null && stickerItem.matchAppAttribute(1)) {
                synchronized (l.f4396b) {
                    l.this.c();
                    if (l.this.h != null) {
                        l.this.h.c(stickerItem);
                    }
                }
            }
        }

        public void a() {
            e.b("ImageStickerTools", "onStickerImportFinish");
            synchronized (l.f4396b) {
                l.this.c();
                if (l.this.h != null) {
                    l.this.h.a();
                }
            }
        }

        public void a(StickerItem stickerItem, int i) {
            e.b("ImageStickerTools", "onStickerDownloadFail, errorCode: " + i + ", item: " + stickerItem);
            if (stickerItem == null) {
                e.e("ImageStickerTools", "onStickerDownloadFail return! Since item: " + stickerItem);
                return;
            }
            if (l.this.h != null) {
                l.this.h.a(stickerItem, i);
            }
            if (l.this.k != null) {
                l.this.a((b) l.this.k.get(stickerItem.getStickerUUID()), false);
            }
        }

        public void b(StickerItem stickerItem, int i) {
            e.b("ImageStickerTools", "onStickerDownloadPause, errorCode: " + i + ", item: " + stickerItem);
            if (stickerItem == null) {
                e.e("ImageStickerTools", "onStickerDownloadPause return! Since item: " + stickerItem);
                return;
            }
            if (l.this.h != null) {
                l.this.h.a(stickerItem, i);
            }
            if (l.this.k != null) {
                l.this.a((b) l.this.k.get(stickerItem.getStickerUUID()), false);
            }
        }

        public void c(StickerItem stickerItem) {
            e.b("ImageStickerTools", "onUpdateStickerDownloadTime, item: " + stickerItem);
            synchronized (l.f4396b) {
                l.this.c();
                if (l.this.h != null) {
                    l.this.h.d(stickerItem);
                }
            }
        }
    };

    public static boolean a(int i2) {
        return 2 == i2;
    }

    private l(Context context) {
        this.c = context;
        this.e = this.c.getSharedPreferences("sticker_info", 0);
        h();
    }

    public void a(Context context) {
        e.b("ImageStickerTools", "initStickerMediator");
        if (this.j == null) {
            this.j = h.a(context);
            this.j.a();
            this.j.a(this.q);
        }
    }

    private void h() {
        if (this.f == null) {
            this.f = new HandlerThread("StickerHandlerThread");
            this.f.start();
        }
        if (this.g == null) {
            this.g = new Handler(this.f.getLooper());
        }
    }

    private void i() {
        Handler handler = this.g;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
            this.g = null;
        }
        HandlerThread handlerThread = this.f;
        if (handlerThread != null) {
            handlerThread.quitSafely();
            this.f = null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0023, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(final int r3, boolean r4) {
        /*
            r2 = this;
            java.lang.Object r0 = f4396b
            monitor-enter(r0)
            boolean r1 = r2.l     // Catch:{ all -> 0x0024 }
            if (r1 == 0) goto L_0x000b
            if (r3 != 0) goto L_0x000b
            monitor-exit(r0)     // Catch:{ all -> 0x0024 }
            return
        L_0x000b:
            r1 = 1
            r2.l = r1     // Catch:{ all -> 0x0024 }
            if (r4 == 0) goto L_0x001f
            android.os.Handler r4 = r2.g     // Catch:{ all -> 0x0024 }
            if (r4 == 0) goto L_0x0022
            android.os.Handler r4 = r2.g     // Catch:{ all -> 0x0024 }
            com.oppo.camera.ui.preview.a.l$1 r1 = new com.oppo.camera.ui.preview.a.l$1     // Catch:{ all -> 0x0024 }
            r1.<init>(r3)     // Catch:{ all -> 0x0024 }
            r4.post(r1)     // Catch:{ all -> 0x0024 }
            goto L_0x0022
        L_0x001f:
            r2.b((int) r3)     // Catch:{ all -> 0x0024 }
        L_0x0022:
            monitor-exit(r0)     // Catch:{ all -> 0x0024 }
            return
        L_0x0024:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0024 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.ui.preview.a.l.a(int, boolean):void");
    }

    /* access modifiers changed from: private */
    public void b(int i2) {
        c();
        p pVar = this.h;
        if (pVar != null) {
            pVar.a(i2);
        }
    }

    public Integer a() {
        return Integer.valueOf(this.m - 1);
    }

    public c b() {
        return this.d;
    }

    public boolean a(String str) {
        SharedPreferences sharedPreferences = this.e;
        if (sharedPreferences != null) {
            return sharedPreferences.getBoolean(str, false);
        }
        return true;
    }

    public void a(String str, boolean z) {
        SharedPreferences sharedPreferences = this.e;
        if (sharedPreferences != null) {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putBoolean(str, z);
            edit.apply();
        }
    }

    private boolean j() {
        SharedPreferences sharedPreferences = this.e;
        if (sharedPreferences != null) {
            return sharedPreferences.getBoolean("sticker_dialog_status", false);
        }
        return false;
    }

    /* access modifiers changed from: private */
    public void k() {
        SharedPreferences sharedPreferences = this.e;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putBoolean("sticker_dialog_status", true).apply();
        }
    }

    public static l b(Context context) {
        l lVar;
        synchronized (f4396b) {
            if (f4395a == null) {
                f4395a = new l(context.getApplicationContext());
            }
            lVar = f4395a;
        }
        return lVar;
    }

    public void c() {
        e.a("ImageStickerTools", "refreshStickerInfoByCameraId");
        if (this.c == null) {
            e.e("ImageStickerTools", "refreshStickerInfoByCameraId, mContext is null");
            return;
        }
        e.a("refreshStickerInfoByCameraId");
        this.d.a(b(d()));
        List<StickerItem> a2 = a(this.d.c());
        if (a2 != null) {
            for (StickerItem a3 : a2) {
                a(a3);
            }
        } else {
            e.e("ImageStickerTools", "initStickerInfoToMap, databaseList is null");
        }
        e.b("refreshStickerInfoByCameraId");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0024, code lost:
        if (r1 == null) goto L_0x002c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0027, code lost:
        if (r1 != null) goto L_0x0029;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0029, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002c, code lost:
        return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.ArrayList<com.oppo.camera.sticker.data.StickerCategoryItem> d() {
        /*
            r4 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            android.content.Context r1 = r4.c
            long r2 = r4.i
            android.database.Cursor r1 = com.oppo.camera.sticker.e.a(r1, r2)
            if (r1 == 0) goto L_0x0027
        L_0x000f:
            boolean r2 = r1.moveToNext()     // Catch:{ Exception -> 0x0024, all -> 0x001d }
            if (r2 == 0) goto L_0x0027
            com.oppo.camera.sticker.data.StickerCategoryItem r2 = com.oppo.camera.sticker.e.a(r1)     // Catch:{ Exception -> 0x0024, all -> 0x001d }
            r0.add(r2)     // Catch:{ Exception -> 0x0024, all -> 0x001d }
            goto L_0x000f
        L_0x001d:
            r0 = move-exception
            if (r1 == 0) goto L_0x0023
            r1.close()
        L_0x0023:
            throw r0
        L_0x0024:
            if (r1 == 0) goto L_0x002c
            goto L_0x0029
        L_0x0027:
            if (r1 == 0) goto L_0x002c
        L_0x0029:
            r1.close()
        L_0x002c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.ui.preview.a.l.d():java.util.ArrayList");
    }

    public List<StickerItem> a(ArrayList<h.b> arrayList) {
        ArrayList arrayList2 = new ArrayList();
        try {
            Iterator<h.b> it = arrayList.iterator();
            while (it.hasNext()) {
                h.b next = it.next();
                Cursor a2 = g.a(this.c, this.i, next.c);
                if (a2 != null) {
                    if (StickerCategoryItem.isMyCategory(next.c)) {
                        this.m = a2.getCount();
                    }
                    while (a2.moveToNext()) {
                        StickerItem a3 = g.a(a2);
                        a3.getCategoryId();
                        if (StickerCategoryItem.isMyCategory(next.c)) {
                            a3.setCategoryId(next.c);
                        }
                        arrayList2.add(a3);
                    }
                    a2.close();
                }
            }
        } catch (Exception e2) {
            e.e("ImageStickerTools", "querySingleStickerInfo, e: " + e2);
        }
        return arrayList2;
    }

    public StickerItem a(SharedPreferences sharedPreferences) {
        StickerItem a2;
        if (sharedPreferences == null) {
            e.e("ImageStickerTools", "getSelectedStickerItem, preferences: " + sharedPreferences);
            return null;
        }
        e.a("getSelectedStickerItem");
        String string = sharedPreferences.getString("pref_current_sticker_uuid", "unselected_uuid");
        if ("unselected_uuid".equals(string) || (a2 = g.a(this.c, "uuid", string)) == null || !a2.isDownloaded()) {
            return null;
        }
        e.b("getSelectedStickerItem");
        return a2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0032 A[SYNTHETIC, Splitter:B:25:0x0032] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x004a A[SYNTHETIC, Splitter:B:32:0x004a] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.graphics.drawable.Drawable a(android.content.Context r3, android.net.Uri r4) {
        /*
            r2 = this;
            android.content.ContentResolver r0 = r3.getContentResolver()
            r1 = 0
            java.io.InputStream r4 = r0.openInputStream(r4)     // Catch:{ FileNotFoundException -> 0x002b, all -> 0x0028 }
            android.graphics.Bitmap r0 = android.graphics.BitmapFactory.decodeStream(r4)     // Catch:{ FileNotFoundException -> 0x0026 }
            if (r0 == 0) goto L_0x001e
            android.graphics.drawable.BitmapDrawable r3 = com.oppo.camera.util.Util.a((android.content.Context) r3, (android.graphics.Bitmap) r0)     // Catch:{ FileNotFoundException -> 0x0026 }
            if (r4 == 0) goto L_0x001d
            r4.close()     // Catch:{ IOException -> 0x0019 }
            goto L_0x001d
        L_0x0019:
            r4 = move-exception
            r4.printStackTrace()
        L_0x001d:
            return r3
        L_0x001e:
            if (r4 == 0) goto L_0x003a
            r4.close()     // Catch:{ IOException -> 0x0036 }
            goto L_0x003a
        L_0x0024:
            r3 = move-exception
            goto L_0x0048
        L_0x0026:
            r3 = move-exception
            goto L_0x002d
        L_0x0028:
            r3 = move-exception
            r4 = r1
            goto L_0x0048
        L_0x002b:
            r3 = move-exception
            r4 = r1
        L_0x002d:
            r3.printStackTrace()     // Catch:{ all -> 0x0024 }
            if (r4 == 0) goto L_0x003a
            r4.close()     // Catch:{ IOException -> 0x0036 }
            goto L_0x003a
        L_0x0036:
            r3 = move-exception
            r3.printStackTrace()
        L_0x003a:
            android.content.Context r3 = r2.c
            android.content.res.Resources r3 = r3.getResources()
            r4 = 2131231969(0x7f0804e1, float:1.8080034E38)
            android.graphics.drawable.Drawable r3 = r3.getDrawable(r4, r1)
            return r3
        L_0x0048:
            if (r4 == 0) goto L_0x0052
            r4.close()     // Catch:{ IOException -> 0x004e }
            goto L_0x0052
        L_0x004e:
            r4 = move-exception
            r4.printStackTrace()
        L_0x0052:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.ui.preview.a.l.a(android.content.Context, android.net.Uri):android.graphics.drawable.Drawable");
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [byte[], java.io.InputStream] */
    public static byte[] a(Context context, String str) {
        ? r0 = 0;
        if (context == null || TextUtils.isEmpty(str)) {
            e.b("ImageStickerTools", "readStickerStream, context or stickerUri is null");
            return r0;
        }
        byte[] bArr = new byte[1024];
        ContentResolver contentResolver = context.getContentResolver();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            InputStream openInputStream = contentResolver.openInputStream(Uri.parse(str));
            while (openInputStream != null) {
                int read = openInputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            if (openInputStream != null) {
                try {
                    openInputStream.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
            try {
                byteArrayOutputStream.close();
            } catch (IOException e3) {
                e3.printStackTrace();
            }
            return byteArray;
        } catch (Exception e4) {
            e.e("ImageStickerTools", "readStickerStream, ex: " + e4);
            if (r0 != 0) {
                try {
                    r0.close();
                } catch (IOException e5) {
                    e5.printStackTrace();
                }
            }
            try {
                byteArrayOutputStream.close();
            } catch (IOException e6) {
                e6.printStackTrace();
            }
            return bArr;
        } catch (Throwable th) {
            if (r0 != 0) {
                try {
                    r0.close();
                } catch (IOException e7) {
                    e7.printStackTrace();
                }
            }
            try {
                byteArrayOutputStream.close();
            } catch (IOException e8) {
                e8.printStackTrace();
            }
            throw th;
        }
    }

    private ArrayList<h.b> b(ArrayList<StickerCategoryItem> arrayList) {
        Drawable drawable;
        ArrayList<h.b> arrayList2 = new ArrayList<>();
        this.d.a();
        if (arrayList != null) {
            int i2 = 0;
            Iterator<StickerCategoryItem> it = arrayList.iterator();
            while (it.hasNext()) {
                StickerCategoryItem next = it.next();
                if (next != null) {
                    String iconHighlightFileUri = next.getIconHighlightFileUri();
                    String iconFileUri = next.getIconFileUri();
                    boolean isCategoryNew = next.isCategoryNew();
                    Drawable drawable2 = null;
                    if (!TextUtils.isEmpty(iconFileUri)) {
                        drawable = a(this.c, Uri.parse(iconFileUri));
                    } else {
                        drawable = null;
                    }
                    if (drawable == null) {
                        drawable = this.c.getDrawable(R.drawable.unselect_preset);
                    }
                    if (!TextUtils.isEmpty(iconHighlightFileUri)) {
                        drawable2 = a(this.c, Uri.parse(iconHighlightFileUri));
                    }
                    if (drawable2 == null) {
                        drawable2 = this.c.getDrawable(R.drawable.select_preset);
                    }
                    arrayList2.add(new h.b(drawable2, drawable, next.getReadableId(), isCategoryNew));
                    this.d.b(next.getReadableId(), i2);
                    i2++;
                }
            }
        }
        return arrayList2;
    }

    public boolean a(Activity activity, StickerItem stickerItem) {
        StringBuilder sb = new StringBuilder();
        sb.append("onEffectClick, isDownloaded: ");
        Boolean bool = null;
        sb.append(stickerItem != null ? Boolean.valueOf(stickerItem.isDownloaded()) : null);
        sb.append(", item.needUpdate: ");
        if (stickerItem != null) {
            bool = Boolean.valueOf(stickerItem.needUpdate());
        }
        sb.append(bool);
        e.a("ImageStickerTools", sb.toString());
        if (stickerItem == null) {
            e.d("ImageStickerTools", "onEffectClick, item is null!");
            return true;
        } else if (!stickerItem.needUpdate() && stickerItem.isDownloaded()) {
            return false;
        } else {
            Context context = this.c;
            if (context != null) {
                if (OplusNetworkUtil.isWifiConnected(context)) {
                    stickerItem.setDownloadState(2);
                    p pVar = this.h;
                    if (pVar != null) {
                        pVar.a(stickerItem);
                    }
                    com.oppo.camera.sticker.h hVar = this.j;
                    if (hVar != null) {
                        hVar.a(stickerItem, false);
                        e(stickerItem);
                    }
                } else if (OplusNetworkUtil.isMobileDataConnected(this.c)) {
                    b(activity, stickerItem);
                } else {
                    com.oppo.camera.util.h.a(this.c, R.string.sticker_toast_disconnect);
                    stickerItem.setDownloadState(16);
                    p pVar2 = this.h;
                    if (pVar2 != null) {
                        pVar2.a(stickerItem);
                    }
                }
            }
            return true;
        }
    }

    public void a(StickerItem stickerItem) {
        if (stickerItem != null) {
            CopyOnWriteArrayList<StickerItem> a2 = this.d.a(stickerItem.getCategoryId());
            if (a2 == null) {
                a2 = new CopyOnWriteArrayList<>();
                this.d.a(stickerItem.getCategoryId(), a2);
            }
            a2.add(stickerItem);
            this.d.a(stickerItem.getStickerUUID(), a2.indexOf(stickerItem));
            return;
        }
        e.e("ImageStickerTools", "refreshSticker, item is null");
    }

    public void b(String str) {
        synchronized (f4396b) {
            this.d.b(str);
        }
    }

    public void a(final k kVar, final StickerItem stickerItem, final boolean z) {
        synchronized (f4396b) {
            if (stickerItem != null) {
                this.d.b(stickerItem.getCategoryId());
            }
            CopyOnWriteArrayList<a> b2 = this.d.b();
            ArrayList arrayList = new ArrayList(this.d.c());
            int d2 = this.d.d();
            if (b2 != null && b2.size() > 0 && arrayList.size() > 0) {
                e.a("ImageStickerTools", "setImageResource, stickerList.size: " + b2.size());
                kVar.a(arrayList, d2, stickerItem, z);
            } else if (this.g != null) {
                this.g.post(new Runnable() {
                    public void run() {
                        synchronized (l.f4396b) {
                            l.this.a(0, false);
                            if (stickerItem != null) {
                                l.this.d.b(stickerItem.getCategoryId());
                            }
                            kVar.a(l.this.d.c(), l.this.d.d(), stickerItem, z);
                        }
                    }
                });
            }
        }
    }

    public void c(Context context) {
        e.a("ImageStickerTools", "releaseResource");
        if (context.getApplicationContext() != this.c) {
            e.a("ImageStickerTools", "releaseResource, return");
            return;
        }
        com.oppo.camera.sticker.h hVar = this.j;
        if (hVar != null) {
            hVar.b(this.q);
            this.j.b();
            this.j = null;
        }
        synchronized (f4396b) {
            this.d.a();
            i();
            this.l = false;
            f4395a = null;
        }
    }

    public void a(p pVar) {
        this.h = pVar;
    }

    public void a(Activity activity) {
        color.support.v7.app.b bVar = this.o;
        if (bVar != null && bVar.isShowing()) {
            a(activity, this.n, true);
        }
    }

    public void e() {
        color.support.v7.app.b bVar = this.o;
        if (bVar != null && bVar.isShowing()) {
            this.o.dismiss();
        }
        this.o = null;
    }

    private void b(Activity activity, StickerItem stickerItem) {
        if (activity == null) {
            e.b("ImageStickerTools", "showNetworkWarningDialog, context is null .");
        } else if (j()) {
            d(stickerItem);
        } else {
            this.p = stickerItem;
            a(activity, this.n, false);
        }
    }

    private void a(Activity activity, boolean z, boolean z2) {
        color.support.v7.app.b bVar = this.o;
        if (bVar != null && (bVar.isShowing() || z2)) {
            this.o.cancel();
            this.o = null;
        }
        View inflate = LayoutInflater.from(activity).inflate(R.layout.sticker_warning_checkbox, (ViewGroup) null);
        CheckBox checkBox = (CheckBox) ((LinearLayout) inflate).findViewById(R.id.sticker_check_box_never);
        if (z2) {
            checkBox.setChecked(z);
        }
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                boolean unused = l.this.n = z;
            }
        });
        this.o = new b.a(activity).setCancelable(false).setOnKeyListener((DialogInterface.OnKeyListener) new DialogInterface.OnKeyListener() {
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                if (4 != i) {
                    return false;
                }
                dialogInterface.dismiss();
                return false;
            }
        }).setPositiveButton((int) R.string.sticker_continue_download, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                l lVar = l.this;
                lVar.d(lVar.p);
                if (l.this.n) {
                    l.this.k();
                }
            }
        }).setNegativeButton((int) R.string.sticker_cancel_download, (DialogInterface.OnClickListener) null).setOnDismissListener((DialogInterface.OnDismissListener) new DialogInterface.OnDismissListener() {
            public void onDismiss(DialogInterface dialogInterface) {
                boolean unused = l.this.n = false;
            }
        }).setTitle((int) R.string.sticker_consumption_networks_dialog).setView(inflate).create();
        e.a("ImageStickerTools", "startDownloadFromDialog mWarningDialog created");
        if (activity.isFinishing()) {
            e.a("ImageStickerTools", "startDownloadFromDialog activity isFinishing");
        } else {
            this.o.show();
        }
    }

    /* access modifiers changed from: private */
    public void d(StickerItem stickerItem) {
        e.a("ImageStickerTools", "startDownloadFromDialog");
        stickerItem.setDownloadState(2);
        p pVar = this.h;
        if (pVar != null) {
            pVar.a(stickerItem);
        }
        com.oppo.camera.sticker.h.a(this.c).a(stickerItem, true);
        e(stickerItem);
    }

    public static boolean b(StickerItem stickerItem) {
        if (stickerItem != null) {
            return a(stickerItem.getMaterialType());
        }
        return false;
    }

    public static boolean c(StickerItem stickerItem) {
        return stickerItem != null && stickerItem.getMaterialType() == 1;
    }

    /* compiled from: ImageStickerTools */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public CopyOnWriteArrayList<a> f4410a = new CopyOnWriteArrayList<>();

        /* renamed from: b  reason: collision with root package name */
        public Map<String, Integer> f4411b = new HashMap();
        public Map<String, Integer> c = new HashMap();
        public ArrayList<h.b> d = new ArrayList<>();
        private String e = null;

        public void a() {
            e.a("ImageStickerTools", "recycle");
            this.f4410a.clear();
            this.f4411b.clear();
            this.c.clear();
            this.d.clear();
        }

        public CopyOnWriteArrayList<StickerItem> a(String str) {
            int a2 = a(this.f4410a, str);
            if (a2 >= 0) {
                return this.f4410a.get(a2).a();
            }
            return null;
        }

        public CopyOnWriteArrayList<a> b() {
            return this.f4410a;
        }

        public void a(String str, CopyOnWriteArrayList<StickerItem> copyOnWriteArrayList) {
            a aVar = new a();
            aVar.a(str);
            aVar.a(copyOnWriteArrayList);
            this.f4410a.add(aVar);
        }

        public void a(ArrayList<h.b> arrayList) {
            this.d = arrayList;
        }

        public ArrayList<h.b> c() {
            return this.d;
        }

        public void b(String str) {
            this.e = str;
        }

        public int d() {
            ArrayList<h.b> arrayList = this.d;
            if (arrayList == null) {
                return 1;
            }
            Iterator<h.b> it = arrayList.iterator();
            int i = 0;
            while (it.hasNext()) {
                if (it.next().c.equals(this.e)) {
                    return i;
                }
                i++;
            }
            return 1;
        }

        public void a(String str, int i) {
            this.f4411b.put(str, Integer.valueOf(i));
        }

        public Integer c(String str) {
            return this.f4411b.get(str);
        }

        public boolean d(String str) {
            return this.f4411b.get(str) != null;
        }

        public void b(String str, int i) {
            this.c.put(str, Integer.valueOf(i));
        }

        public Integer e(String str) {
            Integer num;
            synchronized (l.f4396b) {
                num = this.c.get(str);
            }
            return num;
        }

        public int a(CopyOnWriteArrayList<a> copyOnWriteArrayList, String str) {
            if (!(copyOnWriteArrayList == null || copyOnWriteArrayList.isEmpty() || str == null)) {
                Iterator<a> it = copyOnWriteArrayList.iterator();
                while (it.hasNext()) {
                    a next = it.next();
                    if (str.equals(next.b())) {
                        return copyOnWriteArrayList.indexOf(next);
                    }
                }
            }
            return -1;
        }
    }

    public void f() {
        if (this.j != null) {
            e.b("ImageStickerTools", "requestSticker");
            this.j.c();
        }
    }

    private void e(StickerItem stickerItem) {
        e.b("ImageStickerTools", "startDownloadStickerNearme uuid: " + stickerItem.getStickerUUID());
        if (this.k == null) {
            this.k = new HashMap<>();
        }
        b bVar = new b();
        long unused = bVar.c = System.currentTimeMillis();
        int unused2 = bVar.d = l();
        String unused3 = bVar.f4409b = stickerItem.getStickerUUID();
        String unused4 = bVar.e = stickerItem.getStickerName();
        String unused5 = bVar.f = stickerItem.getCategoryId();
        this.k.put(stickerItem.getStickerUUID(), bVar);
    }

    private int l() {
        if (OplusNetworkUtil.isWifiConnected(this.c)) {
            return 1;
        }
        return OplusNetworkUtil.isMobileDataConnected(this.c) ? 0 : -1;
    }

    /* access modifiers changed from: private */
    public void a(b bVar, boolean z) {
        if (bVar != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(CameraStatisticsUtil.format(CameraStatisticsUtil.STICKER_UUID, bVar.f4409b));
            sb.append(CameraStatisticsUtil.format(CameraStatisticsUtil.STICKER_TYPE, bVar.f));
            sb.append(CameraStatisticsUtil.format(CameraStatisticsUtil.STICKER_NAME, bVar.e));
            sb.append(CameraStatisticsUtil.format(CameraStatisticsUtil.STICKER_DOWNLOAD_RESULT, String.valueOf(z)));
            sb.append(CameraStatisticsUtil.format(CameraStatisticsUtil.STICKER_NETWORK, String.valueOf(bVar.d)));
            long currentTimeMillis = System.currentTimeMillis() - bVar.c;
            if (currentTimeMillis > 0) {
                sb.append(CameraStatisticsUtil.format(CameraStatisticsUtil.STICKER_DOWNLOAD_COST_TIME, String.valueOf(currentTimeMillis)));
            }
            CameraStatisticsUtil.onCommon(this.c, "sticker_download", sb.toString(), false);
            HashMap<String, b> hashMap = this.k;
            if (hashMap != null) {
                hashMap.remove(bVar.f4409b);
            }
        }
    }

    /* compiled from: ImageStickerTools */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private CopyOnWriteArrayList<StickerItem> f4406a = null;

        /* renamed from: b  reason: collision with root package name */
        private String f4407b = null;

        public void a(CopyOnWriteArrayList<StickerItem> copyOnWriteArrayList) {
            this.f4406a = copyOnWriteArrayList;
        }

        public void a(String str) {
            this.f4407b = str;
        }

        public CopyOnWriteArrayList<StickerItem> a() {
            return this.f4406a;
        }

        public String b() {
            return this.f4407b;
        }
    }

    /* compiled from: ImageStickerTools */
    private class b {
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public String f4409b;
        /* access modifiers changed from: private */
        public long c;
        /* access modifiers changed from: private */
        public int d;
        /* access modifiers changed from: private */
        public String e;
        /* access modifiers changed from: private */
        public String f;

        private b() {
            this.f4409b = "";
            this.c = 0;
            this.d = -1;
            this.e = "";
            this.f = "";
        }
    }
}
