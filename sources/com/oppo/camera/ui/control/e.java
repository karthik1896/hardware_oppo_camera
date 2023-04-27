package com.oppo.camera.ui.control;

import android.content.ContentResolver;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.hardware.HardwareBuffer;
import android.net.Uri;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.ConditionVariable;
import android.text.TextUtils;
import android.util.Size;
import com.oppo.camera.jni.FormatConverter;
import com.oppo.camera.util.Util;
import com.oppo.camera.z;
import java.io.FileDescriptor;
import java.io.IOException;

/* compiled from: Thumbnail */
public class e {

    /* renamed from: b  reason: collision with root package name */
    private static c f3917b;
    private static c c;
    private static c d;
    private static Object e = new Object();
    private static int f;
    private static FormatConverter o = new FormatConverter();
    private static ConditionVariable p = new ConditionVariable(true);

    /* renamed from: a  reason: collision with root package name */
    public boolean f3918a;
    private Uri g;
    private String h;
    private String i;
    private long j;
    private Bitmap k;
    private boolean l;
    private long m;
    private c n;

    /* compiled from: Thumbnail */
    public interface a {
        void a(e eVar);
    }

    /* compiled from: Thumbnail */
    public interface b {
        void a(long j);
    }

    public e() {
        this.f3918a = false;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = 0;
        this.k = null;
        this.l = false;
        this.m = 0;
        this.n = null;
    }

    public e(Bitmap bitmap) {
        this.f3918a = false;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = 0;
        this.k = null;
        this.l = false;
        this.m = 0;
        this.n = null;
        this.k = bitmap;
    }

    public e(Bitmap bitmap, long j2, long j3) {
        this.f3918a = false;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = 0;
        this.k = null;
        this.l = false;
        this.m = 0;
        this.n = null;
        this.i = null;
        this.j = j3;
        this.g = null;
        this.m = j2;
        this.k = bitmap;
    }

    private e(Uri uri, Bitmap bitmap, int i2, String str, long j2) {
        this.f3918a = false;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = 0;
        this.k = null;
        this.l = false;
        this.m = 0;
        this.n = null;
        this.g = uri;
        this.i = str;
        this.j = j2;
        if (bitmap != null) {
            this.k = a(bitmap, i2);
            return;
        }
        com.oppo.camera.e.a("Thumbnail", "Thumbnail, mUri: " + this.g + ", thumbnail bitmap is null...");
        this.k = bitmap;
    }

    public long a() {
        return this.m;
    }

    public void a(long j2) {
        this.m = j2;
    }

    public static Bitmap a(Bitmap bitmap, int i2) {
        com.oppo.camera.e.a("Thumbnail", "rotateImage");
        if (i2 != 0) {
            Matrix matrix = new Matrix();
            matrix.setRotate((float) i2, ((float) bitmap.getWidth()) * 0.5f, ((float) bitmap.getHeight()) * 0.5f);
            try {
                Bitmap a2 = Util.a(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
                if (a2 != bitmap) {
                    bitmap.recycle();
                }
                return a2;
            } catch (Throwable th) {
                com.oppo.camera.e.c("Thumbnail", "Failed to rotate thumbnail", th);
            }
        }
        return bitmap;
    }

    private static int j() {
        c cVar = f3917b;
        long j2 = cVar != null ? cVar.c : 0;
        c cVar2 = c;
        long j3 = cVar2 != null ? cVar2.c : 0;
        c cVar3 = d;
        long j4 = cVar3 != null ? cVar3.c : 0;
        if (j2 >= j3 && j2 > j4 && j2 > 0) {
            f = 0;
        } else if (j3 > j2 && j3 > j4 && j3 > 0) {
            f = 1;
        } else if (j4 <= j3 || j4 <= j2 || j4 <= 0) {
            f = -1;
        } else {
            f = 2;
        }
        return f;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: android.os.ParcelFileDescriptor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v12, resolved type: android.os.ParcelFileDescriptor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v1, resolved type: android.os.ParcelFileDescriptor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v13, resolved type: android.os.ParcelFileDescriptor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v14, resolved type: android.net.Uri} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v2, resolved type: android.os.ParcelFileDescriptor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v15, resolved type: android.net.Uri} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v26, resolved type: android.net.Uri} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v27, resolved type: android.net.Uri} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v28, resolved type: android.os.ParcelFileDescriptor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v30, resolved type: android.os.ParcelFileDescriptor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v31, resolved type: android.os.ParcelFileDescriptor} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0220 A[SYNTHETIC, Splitter:B:89:0x0220] */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x022b A[SYNTHETIC, Splitter:B:95:0x022b] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int a(android.content.ContentResolver r12, com.oppo.camera.ui.control.e r13, boolean r14) {
        /*
            android.net.Uri r0 = com.oppo.camera.z.c((boolean) r14)
            android.net.Uri r1 = com.oppo.camera.z.d((boolean) r14)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "getLastThumbnailFromContentResolver, sdCard: "
            r2.append(r3)
            r2.append(r14)
            java.lang.String r14 = r2.toString()
            java.lang.String r2 = "Thumbnail"
            com.oppo.camera.e.a(r2, r14)
            com.oppo.camera.ui.control.e$c r14 = r13.n
            r3 = 2
            r4 = 1
            r5 = -1
            r6 = 0
            if (r14 == 0) goto L_0x005d
            int r14 = r14.k
            if (r5 == r14) goto L_0x005d
            com.oppo.camera.ui.control.e$c r14 = r13.n
            int r14 = r14.k
            com.oppo.camera.ui.control.e$c r7 = r13.n
            android.graphics.Bitmap r7 = r7.l
            com.oppo.camera.ui.control.e$c r8 = r13.n
            int r8 = r8.k
            if (r8 != 0) goto L_0x003f
            com.oppo.camera.ui.control.e$c r1 = b((android.content.ContentResolver) r12, (android.net.Uri) r0)
            f3917b = r1
            goto L_0x0071
        L_0x003f:
            com.oppo.camera.ui.control.e$c r8 = r13.n
            int r8 = r8.k
            if (r4 != r8) goto L_0x0050
            com.oppo.camera.ui.control.e$c r8 = r13.n
            android.net.Uri r8 = r8.d
            com.oppo.camera.ui.control.e$c r1 = a((android.content.ContentResolver) r12, (android.net.Uri) r1, (android.net.Uri) r8)
            c = r1
            goto L_0x0071
        L_0x0050:
            com.oppo.camera.ui.control.e$c r1 = r13.n
            int r1 = r1.k
            if (r3 != r1) goto L_0x0071
            com.oppo.camera.ui.control.e$c r1 = a((android.content.ContentResolver) r12)
            d = r1
            goto L_0x0071
        L_0x005d:
            com.oppo.camera.ui.control.e$c r14 = b((android.content.ContentResolver) r12, (android.net.Uri) r0)
            f3917b = r14
            com.oppo.camera.ui.control.e$c r14 = a((android.content.ContentResolver) r12, (android.net.Uri) r1, (android.net.Uri) r6)
            c = r14
            com.oppo.camera.ui.control.e$c r14 = a((android.content.ContentResolver) r12)
            d = r14
            r14 = r5
            r7 = r6
        L_0x0071:
            com.oppo.camera.ui.control.e$c r1 = f3917b
            r8 = 0
            if (r1 != 0) goto L_0x009f
            com.oppo.camera.ui.control.e$c r1 = c
            if (r1 != 0) goto L_0x009f
            com.oppo.camera.ui.control.e$c r1 = d
            if (r1 != 0) goto L_0x009f
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r13 = "getLastThumbnailFromContentResolver, image: "
            r12.append(r13)
            com.oppo.camera.ui.control.e$c r13 = f3917b
            r12.append(r13)
            java.lang.String r13 = ", video: "
            r12.append(r13)
            com.oppo.camera.ui.control.e$c r13 = c
            r12.append(r13)
            java.lang.String r12 = r12.toString()
            com.oppo.camera.e.a(r2, r12)
            return r8
        L_0x009f:
            if (r5 != r14) goto L_0x00a5
            int r14 = j()
        L_0x00a5:
            if (r5 != r14) goto L_0x00a8
            return r8
        L_0x00a8:
            java.lang.String r1 = ", height: "
            if (r14 != 0) goto L_0x01ab
            com.oppo.camera.ui.control.e$c r14 = f3917b
            android.net.Uri r14 = r14.d
            com.oppo.camera.ui.control.e$c r5 = f3917b
            java.lang.String r5 = r5.g
            com.oppo.camera.ui.control.e$c r9 = f3917b
            int r9 = r9.i
            com.oppo.camera.ui.control.e$c r10 = f3917b
            int r10 = r10.j
            boolean r14 = com.oppo.camera.util.Util.a((android.net.Uri) r14, (java.lang.String) r5, (int) r9, (int) r10)
            if (r14 == 0) goto L_0x0135
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            java.lang.String r5 = "getLastThumbnailFromContentResolver, uri: "
            r14.append(r5)
            com.oppo.camera.ui.control.e$c r5 = f3917b
            android.net.Uri r5 = r5.d
            r14.append(r5)
            java.lang.String r5 = ", path: "
            r14.append(r5)
            com.oppo.camera.ui.control.e$c r5 = f3917b
            java.lang.String r5 = r5.g
            r14.append(r5)
            java.lang.String r5 = ", width: "
            r14.append(r5)
            com.oppo.camera.ui.control.e$c r5 = f3917b
            int r5 = r5.i
            r14.append(r5)
            r14.append(r1)
            com.oppo.camera.ui.control.e$c r1 = f3917b
            int r1 = r1.j
            r14.append(r1)
            java.lang.String r14 = r14.toString()
            com.oppo.camera.e.a(r2, r14)
            boolean r14 = com.oppo.camera.z.c()
            if (r14 == 0) goto L_0x010f
            com.oppo.camera.util.g r14 = com.oppo.camera.util.g.a()
            com.oppo.camera.ui.control.e$c r1 = f3917b
            java.lang.String r1 = r1.f
            android.graphics.Bitmap r14 = r14.c(r1)
            goto L_0x011b
        L_0x010f:
            com.oppo.camera.util.g r14 = com.oppo.camera.util.g.a()
            com.oppo.camera.ui.control.e$c r1 = f3917b
            java.lang.String r1 = r1.f
            android.graphics.Bitmap r14 = r14.a((java.lang.String) r1)
        L_0x011b:
            int r1 = com.oppo.camera.ui.control.ThumbImageView.f3902a
            android.graphics.Bitmap r7 = b((android.graphics.Bitmap) r14, (int) r1)
            com.oppo.camera.ui.control.e$c r14 = f3917b
            if (r7 != 0) goto L_0x0136
            com.oppo.camera.ui.control.e$c r0 = b((android.content.ContentResolver) r12, (android.net.Uri) r0)
            f3917b = r0
            com.oppo.camera.ui.control.e$c r0 = f3917b
            if (r0 != 0) goto L_0x0136
            java.lang.String r12 = "getLastThumbnailFromContentResolver, sImage null"
            com.oppo.camera.e.a(r2, r12)
            return r8
        L_0x0135:
            r14 = r6
        L_0x0136:
            if (r7 != 0) goto L_0x0150
            com.oppo.camera.ui.control.e$c r0 = f3917b     // Catch:{ Exception -> 0x014c }
            android.net.Uri r0 = r0.d     // Catch:{ Exception -> 0x014c }
            android.graphics.Bitmap r7 = a((android.content.ContentResolver) r12, (android.net.Uri) r0)     // Catch:{ Exception -> 0x014c }
            if (r7 != 0) goto L_0x0149
            com.oppo.camera.ui.control.e$c r0 = f3917b     // Catch:{ Exception -> 0x014c }
            android.graphics.Bitmap r0 = a((android.content.ContentResolver) r12, (com.oppo.camera.ui.control.e.c) r0)     // Catch:{ Exception -> 0x014c }
            r7 = r0
        L_0x0149:
            com.oppo.camera.ui.control.e$c r14 = f3917b     // Catch:{ Exception -> 0x014c }
            goto L_0x0150
        L_0x014c:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0150:
            if (r7 != 0) goto L_0x023a
            java.lang.String r13 = "getLastThumbnailFromContentResolver, bitmap null"
            com.oppo.camera.e.e(r2, r13)
            com.oppo.camera.ui.control.e$c r13 = f3917b
            java.lang.String r13 = r13.g
            java.lang.String r14 = "\\."
            java.lang.String[] r13 = r13.split(r14)
            if (r13 == 0) goto L_0x01aa
            int r14 = r13.length
            if (r14 <= 0) goto L_0x01aa
            int r14 = r13.length
            int r14 = r14 - r4
            r13 = r13[r14]
            java.lang.String r14 = "jpg"
            boolean r13 = r14.equals(r13)
            if (r13 == 0) goto L_0x01aa
            com.oppo.camera.ui.control.e$c r13 = f3917b     // Catch:{ Exception -> 0x0192 }
            android.net.Uri r13 = r13.d     // Catch:{ Exception -> 0x0192 }
            r12.delete(r13, r6, r6)     // Catch:{ Exception -> 0x0192 }
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0192 }
            r12.<init>()     // Catch:{ Exception -> 0x0192 }
            java.lang.String r13 = "getLastThumbnailFromContentResolver, delete image: "
            r12.append(r13)     // Catch:{ Exception -> 0x0192 }
            com.oppo.camera.ui.control.e$c r13 = f3917b     // Catch:{ Exception -> 0x0192 }
            android.net.Uri r13 = r13.d     // Catch:{ Exception -> 0x0192 }
            r12.append(r13)     // Catch:{ Exception -> 0x0192 }
            java.lang.String r12 = r12.toString()     // Catch:{ Exception -> 0x0192 }
            com.oppo.camera.e.a(r2, r12)     // Catch:{ Exception -> 0x0192 }
            goto L_0x01aa
        L_0x0192:
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r13 = "getLastThumbnailFromContentResolver, Failed to delete image: "
            r12.append(r13)
            com.oppo.camera.ui.control.e$c r13 = f3917b
            android.net.Uri r13 = r13.d
            r12.append(r13)
            java.lang.String r12 = r12.toString()
            com.oppo.camera.e.e(r2, r12)
        L_0x01aa:
            return r8
        L_0x01ab:
            if (r4 != r14) goto L_0x0234
            java.lang.String r14 = "getLastThumbnailFromContentResolver, Fail to close fd"
            if (r7 != 0) goto L_0x01ce
            com.oppo.camera.ui.control.e$c r0 = c     // Catch:{ Exception -> 0x01cc }
            android.net.Uri r0 = r0.d     // Catch:{ Exception -> 0x01cc }
            java.lang.String r5 = "r"
            android.os.ParcelFileDescriptor r0 = r12.openFileDescriptor(r0, r5)     // Catch:{ Exception -> 0x01cc }
            if (r0 == 0) goto L_0x01cf
            java.io.FileDescriptor r5 = r0.getFileDescriptor()     // Catch:{ Exception -> 0x0219, all -> 0x0217 }
            int r7 = com.oppo.camera.ui.control.ThumbImageView.f3902a     // Catch:{ Exception -> 0x0219, all -> 0x0217 }
            android.graphics.Bitmap r5 = a((java.lang.String) r6, (java.io.FileDescriptor) r5, (int) r7)     // Catch:{ Exception -> 0x0219, all -> 0x0217 }
            r7 = r5
            goto L_0x01cf
        L_0x01c9:
            r12 = move-exception
            r0 = r6
            goto L_0x0229
        L_0x01cc:
            r12 = move-exception
            goto L_0x021b
        L_0x01ce:
            r0 = r6
        L_0x01cf:
            com.oppo.camera.ui.control.e$c r5 = c     // Catch:{ Exception -> 0x0219, all -> 0x0217 }
            if (r7 == 0) goto L_0x020b
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0219, all -> 0x0217 }
            r9.<init>()     // Catch:{ Exception -> 0x0219, all -> 0x0217 }
            java.lang.String r10 = "getLastThumbnailFromContentResolver, sVideo.mId: "
            r9.append(r10)     // Catch:{ Exception -> 0x0219, all -> 0x0217 }
            com.oppo.camera.ui.control.e$c r10 = c     // Catch:{ Exception -> 0x0219, all -> 0x0217 }
            long r10 = r10.f3919a     // Catch:{ Exception -> 0x0219, all -> 0x0217 }
            r9.append(r10)     // Catch:{ Exception -> 0x0219, all -> 0x0217 }
            java.lang.String r10 = ", bitmap width: "
            r9.append(r10)     // Catch:{ Exception -> 0x0219, all -> 0x0217 }
            int r10 = r7.getWidth()     // Catch:{ Exception -> 0x0219, all -> 0x0217 }
            r9.append(r10)     // Catch:{ Exception -> 0x0219, all -> 0x0217 }
            r9.append(r1)     // Catch:{ Exception -> 0x0219, all -> 0x0217 }
            int r1 = r7.getHeight()     // Catch:{ Exception -> 0x0219, all -> 0x0217 }
            r9.append(r1)     // Catch:{ Exception -> 0x0219, all -> 0x0217 }
            java.lang.String r1 = ", lastMediaInfo.orientation: "
            r9.append(r1)     // Catch:{ Exception -> 0x0219, all -> 0x0217 }
            int r1 = r5.f3920b     // Catch:{ Exception -> 0x0219, all -> 0x0217 }
            r9.append(r1)     // Catch:{ Exception -> 0x0219, all -> 0x0217 }
            java.lang.String r1 = r9.toString()     // Catch:{ Exception -> 0x0219, all -> 0x0217 }
            com.oppo.camera.e.a(r2, r1)     // Catch:{ Exception -> 0x0219, all -> 0x0217 }
        L_0x020b:
            if (r0 == 0) goto L_0x0215
            r0.close()     // Catch:{ Exception -> 0x0211 }
            goto L_0x0215
        L_0x0211:
            r0 = move-exception
            com.oppo.camera.e.d(r2, r14, r0)
        L_0x0215:
            r14 = r5
            goto L_0x023a
        L_0x0217:
            r12 = move-exception
            goto L_0x0229
        L_0x0219:
            r12 = move-exception
            r6 = r0
        L_0x021b:
            r12.printStackTrace()     // Catch:{ all -> 0x01c9 }
            if (r6 == 0) goto L_0x0228
            r6.close()     // Catch:{ Exception -> 0x0224 }
            goto L_0x0228
        L_0x0224:
            r12 = move-exception
            com.oppo.camera.e.d(r2, r14, r12)
        L_0x0228:
            return r8
        L_0x0229:
            if (r0 == 0) goto L_0x0233
            r0.close()     // Catch:{ Exception -> 0x022f }
            goto L_0x0233
        L_0x022f:
            r13 = move-exception
            com.oppo.camera.e.d(r2, r14, r13)
        L_0x0233:
            throw r12
        L_0x0234:
            if (r3 != r14) goto L_0x0239
            com.oppo.camera.ui.control.e$c r14 = d
            goto L_0x023a
        L_0x0239:
            r14 = r6
        L_0x023a:
            if (r14 == 0) goto L_0x0252
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "getLastThumbnailFromContentResolver, thumbnail uri: "
            r0.append(r1)
            android.net.Uri r1 = r14.d
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            com.oppo.camera.e.a(r2, r0)
        L_0x0252:
            if (r14 == 0) goto L_0x02b1
            android.net.Uri r0 = r14.d
            java.lang.String r1 = r14.g
            int r5 = r14.i
            int r8 = r14.j
            boolean r0 = com.oppo.camera.util.Util.a((android.net.Uri) r0, (java.lang.String) r1, (int) r5, (int) r8)
            if (r0 != 0) goto L_0x026a
            android.net.Uri r0 = r14.d
            boolean r12 = com.oppo.camera.util.Util.a((android.net.Uri) r0, (android.content.ContentResolver) r12)
            if (r12 == 0) goto L_0x02b1
        L_0x026a:
            android.net.Uri r12 = r14.d
            r13.g = r12
            java.lang.String r12 = r14.e
            r13.i = r12
            long r0 = r14.c
            r13.j = r0
            java.lang.String r12 = r14.h
            r13.h = r12
            if (r7 == 0) goto L_0x0298
            r12 = 29
            int r0 = android.os.Build.VERSION.SDK_INT
            if (r12 > r0) goto L_0x028f
            java.lang.String r12 = com.oppo.camera.q.a.f
            java.lang.String r0 = r13.h
            boolean r12 = r12.equals(r0)
            if (r12 != 0) goto L_0x028f
            r13.k = r7
            goto L_0x02b0
        L_0x028f:
            int r12 = r14.f3920b
            android.graphics.Bitmap r12 = a((android.graphics.Bitmap) r7, (int) r12)
            r13.k = r12
            goto L_0x02b0
        L_0x0298:
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r14 = "getLastThumbnailFromContentResolver, bitmap is null, mUri: "
            r12.append(r14)
            android.net.Uri r14 = r13.g
            r12.append(r14)
            java.lang.String r12 = r12.toString()
            com.oppo.camera.e.a(r2, r12)
            r13.k = r6
        L_0x02b0:
            return r4
        L_0x02b1:
            java.lang.String r12 = "getLastThumbnailFromContentResolver, THUMBNAIL_DELETED"
            com.oppo.camera.e.a(r2, r12)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.ui.control.e.a(android.content.ContentResolver, com.oppo.camera.ui.control.e, boolean):int");
    }

    public static Bitmap a(ContentResolver contentResolver, c cVar) {
        if (29 <= Build.VERSION.SDK_INT) {
            return a(contentResolver, cVar.d, cVar);
        }
        return a(cVar.e);
    }

    private static Bitmap a(ContentResolver contentResolver, Uri uri, c cVar) {
        Bitmap bitmap;
        if (uri == null) {
            com.oppo.camera.e.e("Thumbnail", "getThumbnailBitmapFromUri, uri: null");
            return null;
        }
        CancellationSignal cancellationSignal = new CancellationSignal();
        try {
            if (29 <= Build.VERSION.SDK_INT) {
                com.oppo.camera.e.e("Thumbnail", "getThumbnailBitmapFromUri, media.mWidth: " + cVar.i + "media.mHeight: " + cVar.j);
                if (cVar.i > cVar.j) {
                    bitmap = contentResolver.loadThumbnail(uri, new Size((cVar.i / cVar.j) * ThumbImageView.f3902a, ThumbImageView.f3902a), cancellationSignal);
                } else if (cVar.i < cVar.j) {
                    bitmap = contentResolver.loadThumbnail(uri, new Size(ThumbImageView.f3902a, (cVar.j / cVar.i) * ThumbImageView.f3902a), cancellationSignal);
                } else {
                    bitmap = contentResolver.loadThumbnail(uri, new Size(ThumbImageView.f3902a, ThumbImageView.f3902a), cancellationSignal);
                }
                return b(bitmap, ThumbImageView.f3902a);
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        return null;
    }

    private static Bitmap a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        options.inJustDecodeBounds = false;
        if (options.outWidth / 4 >= ThumbImageView.f3902a && options.outHeight / 4 >= ThumbImageView.f3902a) {
            options.outHeight /= 4;
            options.outWidth /= 4;
            options.inSampleSize = 4;
        }
        return b(BitmapFactory.decodeFile(str, options), ThumbImageView.f3902a);
    }

    public static Bitmap b(Bitmap bitmap, int i2) {
        int i3;
        if (bitmap == null) {
            return null;
        }
        int i4 = 2;
        if (Bitmap.Config.RGB_565 == bitmap.getConfig()) {
            i3 = 2;
        } else {
            i3 = Bitmap.Config.RGBA_F16 == bitmap.getConfig() ? 5 : 0;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int min = Math.min(width, height);
        com.oppo.camera.e.e("Thumbnail", "getThumbnailBitmapFromUri, width: " + width + "height: " + height + "channelType: " + i3);
        if (min <= i2) {
            return bitmap;
        }
        Bitmap.Config config = Bitmap.Config.ARGB_8888;
        if (2 == i3) {
            config = Bitmap.Config.RGB_565;
        } else if (5 == i3) {
            i4 = 8;
            config = Bitmap.Config.RGBA_F16;
        } else {
            i4 = 4;
        }
        float f2 = ((float) i2) / ((float) min);
        int round = Math.round(((float) width) * f2);
        int round2 = Math.round(f2 * ((float) height));
        Bitmap a2 = Util.a(round, round2, config);
        o.scaleArea(bitmap, width * i4, width, height, a2, round * i4, round, round2, i3);
        return a2;
    }

    private static c b(ContentResolver contentResolver, Uri uri) {
        c c2 = c(contentResolver, uri);
        c d2 = d(contentResolver, uri);
        if (c2 == null && d2 == null) {
            return null;
        }
        return (c2 == null || d2 == null) ? d2 == null ? c2 : d2 : d2.c > c2.c ? d2 : c2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x010e, code lost:
        if (r2 != null) goto L_0x011d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x011b, code lost:
        if (r2 != null) goto L_0x011d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x011d, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0120, code lost:
        return null;
     */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0124  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.oppo.camera.ui.control.e.c c(android.content.ContentResolver r21, android.net.Uri r22) {
        /*
            java.lang.String r0 = "_data"
            java.lang.String r1 = "Thumbnail"
            android.net.Uri$Builder r2 = r22.buildUpon()
            java.lang.String r3 = "limit"
            java.lang.String r4 = "1"
            android.net.Uri$Builder r2 = r2.appendQueryParameter(r3, r4)
            android.net.Uri r2 = r2.build()
            java.lang.String r3 = "_id"
            java.lang.String r4 = "orientation"
            java.lang.String r5 = "datetaken"
            java.lang.String r6 = "_data"
            java.lang.String r7 = "title"
            java.lang.String r8 = "width"
            java.lang.String r9 = "height"
            java.lang.String r10 = "mime_type"
            java.lang.String[] r3 = new java.lang.String[]{r3, r4, r5, r6, r7, r8, r9, r10}
            r4 = 1
            boolean r5 = com.oppo.camera.z.b((boolean) r4)
            if (r5 == 0) goto L_0x0058
            boolean r5 = com.oppo.camera.util.Util.K()
            if (r5 == 0) goto L_0x0058
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "(bucket_id IN ("
            r5.append(r6)
            java.lang.String r6 = com.oppo.camera.z.k
            r5.append(r6)
            java.lang.String r6 = ","
            r5.append(r6)
            java.lang.String r6 = com.oppo.camera.z.f
            r5.append(r6)
            java.lang.String r6 = "))"
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            goto L_0x0070
        L_0x0058:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "(bucket_id="
            r5.append(r6)
            java.lang.String r6 = com.oppo.camera.z.k
            r5.append(r6)
            java.lang.String r6 = ")"
            r5.append(r6)
            java.lang.String r5 = r5.toString()
        L_0x0070:
            java.lang.String r6 = "datetaken DESC,_id DESC"
            r7 = 0
            android.os.Bundle r8 = new android.os.Bundle     // Catch:{ Exception -> 0x0114, all -> 0x0111 }
            r8.<init>()     // Catch:{ Exception -> 0x0114, all -> 0x0111 }
            java.lang.String r9 = "android:query-arg-match-pending"
            r8.putInt(r9, r4)     // Catch:{ Exception -> 0x0114, all -> 0x0111 }
            java.lang.String r4 = "android:query-arg-sql-selection"
            r8.putString(r4, r5)     // Catch:{ Exception -> 0x0114, all -> 0x0111 }
            java.lang.String r4 = "android:query-arg-sql-sort-order"
            r8.putString(r4, r6)     // Catch:{ Exception -> 0x0114, all -> 0x0111 }
            r4 = r21
            android.database.Cursor r2 = r4.query(r2, r3, r8, r7)     // Catch:{ Exception -> 0x0114, all -> 0x0111 }
            if (r2 == 0) goto L_0x010e
            boolean r3 = r2.moveToFirst()     // Catch:{ Exception -> 0x010c }
            if (r3 == 0) goto L_0x010e
            r3 = 0
            long r9 = r2.getLong(r3)     // Catch:{ Exception -> 0x010c }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x010c }
            r3.<init>()     // Catch:{ Exception -> 0x010c }
            java.lang.String r4 = "getLatestImage, id: "
            r3.append(r4)     // Catch:{ Exception -> 0x010c }
            r3.append(r9)     // Catch:{ Exception -> 0x010c }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x010c }
            com.oppo.camera.e.a(r1, r3)     // Catch:{ Exception -> 0x010c }
            com.oppo.camera.ui.control.e$c r3 = new com.oppo.camera.ui.control.e$c     // Catch:{ Exception -> 0x010c }
            java.lang.String r4 = "orientation"
            int r4 = r2.getColumnIndex(r4)     // Catch:{ Exception -> 0x010c }
            int r11 = r2.getInt(r4)     // Catch:{ Exception -> 0x010c }
            java.lang.String r4 = "datetaken"
            int r4 = r2.getColumnIndex(r4)     // Catch:{ Exception -> 0x010c }
            long r12 = r2.getLong(r4)     // Catch:{ Exception -> 0x010c }
            r4 = r22
            android.net.Uri r14 = android.content.ContentUris.withAppendedId(r4, r9)     // Catch:{ Exception -> 0x010c }
            int r4 = r2.getColumnIndex(r0)     // Catch:{ Exception -> 0x010c }
            java.lang.String r15 = r2.getString(r4)     // Catch:{ Exception -> 0x010c }
            java.lang.String r4 = "title"
            int r4 = r2.getColumnIndex(r4)     // Catch:{ Exception -> 0x010c }
            java.lang.String r16 = r2.getString(r4)     // Catch:{ Exception -> 0x010c }
            int r0 = r2.getColumnIndex(r0)     // Catch:{ Exception -> 0x010c }
            java.lang.String r17 = r2.getString(r0)     // Catch:{ Exception -> 0x010c }
            java.lang.String r0 = "mime_type"
            int r0 = r2.getColumnIndex(r0)     // Catch:{ Exception -> 0x010c }
            java.lang.String r18 = r2.getString(r0)     // Catch:{ Exception -> 0x010c }
            java.lang.String r0 = "width"
            int r0 = r2.getColumnIndex(r0)     // Catch:{ Exception -> 0x010c }
            int r19 = r2.getInt(r0)     // Catch:{ Exception -> 0x010c }
            java.lang.String r0 = "height"
            int r0 = r2.getColumnIndex(r0)     // Catch:{ Exception -> 0x010c }
            int r20 = r2.getInt(r0)     // Catch:{ Exception -> 0x010c }
            r8 = r3
            r8.<init>(r9, r11, r12, r14, r15, r16, r17, r18, r19, r20)     // Catch:{ Exception -> 0x010c }
            if (r2 == 0) goto L_0x010b
            r2.close()
        L_0x010b:
            return r3
        L_0x010c:
            r0 = move-exception
            goto L_0x0116
        L_0x010e:
            if (r2 == 0) goto L_0x0120
            goto L_0x011d
        L_0x0111:
            r0 = move-exception
            r2 = r7
            goto L_0x0122
        L_0x0114:
            r0 = move-exception
            r2 = r7
        L_0x0116:
            java.lang.String r3 = "getLatestImage, fail: "
            com.oppo.camera.e.d(r1, r3, r0)     // Catch:{ all -> 0x0121 }
            if (r2 == 0) goto L_0x0120
        L_0x011d:
            r2.close()
        L_0x0120:
            return r7
        L_0x0121:
            r0 = move-exception
        L_0x0122:
            if (r2 == 0) goto L_0x0127
            r2.close()
        L_0x0127:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.ui.control.e.c(android.content.ContentResolver, android.net.Uri):com.oppo.camera.ui.control.e$c");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x00d7, code lost:
        if (r3 != null) goto L_0x00d9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x00d9, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x00e7, code lost:
        if (r3 != null) goto L_0x00d9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00ea, code lost:
        return null;
     */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00ed  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.oppo.camera.ui.control.e.c d(android.content.ContentResolver r18, android.net.Uri r19) {
        /*
            java.lang.String r0 = "_data"
            java.lang.String r1 = "Thumbnail"
            android.net.Uri$Builder r2 = r19.buildUpon()
            java.lang.String r3 = "limit"
            java.lang.String r4 = "1"
            android.net.Uri$Builder r2 = r2.appendQueryParameter(r3, r4)
            android.net.Uri r4 = r2.build()
            java.lang.String r5 = "_id"
            java.lang.String r6 = "orientation"
            java.lang.String r7 = "datetaken"
            java.lang.String r8 = "_data"
            java.lang.String r9 = "title"
            java.lang.String r10 = "mime_type"
            java.lang.String r11 = "width"
            java.lang.String r12 = "height"
            java.lang.String[] r5 = new java.lang.String[]{r5, r6, r7, r8, r9, r10, r11, r12}
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "(_data like '"
            r2.append(r3)
            java.lang.String r3 = com.oppo.camera.z.l
            r2.append(r3)
            java.lang.String r3 = "/Cshot%' OR _data like '"
            r2.append(r3)
            java.lang.String r3 = com.oppo.camera.z.g
            r2.append(r3)
            java.lang.String r3 = "/Cshot%') AND _display_name like '%COVER%'"
            r2.append(r3)
            java.lang.String r6 = r2.toString()
            java.lang.String r8 = "datetaken DESC"
            r7 = 0
            r2 = 0
            r3 = r18
            android.database.Cursor r3 = r3.query(r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x00e0, all -> 0x00dd }
            if (r3 == 0) goto L_0x00d7
            boolean r4 = r3.moveToFirst()     // Catch:{ Exception -> 0x00d5 }
            if (r4 == 0) goto L_0x00d7
            r4 = 0
            long r6 = r3.getLong(r4)     // Catch:{ Exception -> 0x00d5 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00d5 }
            r4.<init>()     // Catch:{ Exception -> 0x00d5 }
            java.lang.String r5 = "getLatestBurstImage, id: "
            r4.append(r5)     // Catch:{ Exception -> 0x00d5 }
            r4.append(r6)     // Catch:{ Exception -> 0x00d5 }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x00d5 }
            com.oppo.camera.e.a(r1, r4)     // Catch:{ Exception -> 0x00d5 }
            com.oppo.camera.ui.control.e$c r4 = new com.oppo.camera.ui.control.e$c     // Catch:{ Exception -> 0x00d5 }
            java.lang.String r5 = "orientation"
            int r5 = r3.getColumnIndex(r5)     // Catch:{ Exception -> 0x00d5 }
            int r8 = r3.getInt(r5)     // Catch:{ Exception -> 0x00d5 }
            java.lang.String r5 = "datetaken"
            int r5 = r3.getColumnIndex(r5)     // Catch:{ Exception -> 0x00d5 }
            long r9 = r3.getLong(r5)     // Catch:{ Exception -> 0x00d5 }
            r5 = r19
            android.net.Uri r11 = android.content.ContentUris.withAppendedId(r5, r6)     // Catch:{ Exception -> 0x00d5 }
            int r5 = r3.getColumnIndex(r0)     // Catch:{ Exception -> 0x00d5 }
            java.lang.String r12 = r3.getString(r5)     // Catch:{ Exception -> 0x00d5 }
            java.lang.String r5 = "title"
            int r5 = r3.getColumnIndex(r5)     // Catch:{ Exception -> 0x00d5 }
            java.lang.String r13 = r3.getString(r5)     // Catch:{ Exception -> 0x00d5 }
            int r0 = r3.getColumnIndex(r0)     // Catch:{ Exception -> 0x00d5 }
            java.lang.String r14 = r3.getString(r0)     // Catch:{ Exception -> 0x00d5 }
            java.lang.String r0 = "mime_type"
            int r0 = r3.getColumnIndex(r0)     // Catch:{ Exception -> 0x00d5 }
            java.lang.String r15 = r3.getString(r0)     // Catch:{ Exception -> 0x00d5 }
            java.lang.String r0 = "width"
            int r0 = r3.getColumnIndex(r0)     // Catch:{ Exception -> 0x00d5 }
            int r16 = r3.getInt(r0)     // Catch:{ Exception -> 0x00d5 }
            java.lang.String r0 = "height"
            int r0 = r3.getColumnIndex(r0)     // Catch:{ Exception -> 0x00d5 }
            int r17 = r3.getInt(r0)     // Catch:{ Exception -> 0x00d5 }
            r5 = r4
            r5.<init>(r6, r8, r9, r11, r12, r13, r14, r15, r16, r17)     // Catch:{ Exception -> 0x00d5 }
            if (r3 == 0) goto L_0x00d2
            r3.close()
        L_0x00d2:
            return r4
        L_0x00d3:
            r0 = move-exception
            goto L_0x00eb
        L_0x00d5:
            r0 = move-exception
            goto L_0x00e2
        L_0x00d7:
            if (r3 == 0) goto L_0x00ea
        L_0x00d9:
            r3.close()
            goto L_0x00ea
        L_0x00dd:
            r0 = move-exception
            r3 = r2
            goto L_0x00eb
        L_0x00e0:
            r0 = move-exception
            r3 = r2
        L_0x00e2:
            java.lang.String r4 = "getLatestBurstImage, fail: "
            com.oppo.camera.e.d(r1, r4, r0)     // Catch:{ all -> 0x00d3 }
            if (r3 == 0) goto L_0x00ea
            goto L_0x00d9
        L_0x00ea:
            return r2
        L_0x00eb:
            if (r3 == 0) goto L_0x00f0
            r3.close()
        L_0x00f0:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.ui.control.e.d(android.content.ContentResolver, android.net.Uri):com.oppo.camera.ui.control.e$c");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00fd, code lost:
        if (r2 != null) goto L_0x00ff;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00ff, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x010d, code lost:
        if (r2 != null) goto L_0x00ff;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0110, code lost:
        return null;
     */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0113  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.oppo.camera.ui.control.e.c a(android.content.ContentResolver r26, android.net.Uri r27, android.net.Uri r28) {
        /*
            java.lang.String r1 = "Thumbnail"
            if (r28 == 0) goto L_0x0007
            r3 = r28
            goto L_0x0018
        L_0x0007:
            android.net.Uri$Builder r0 = r27.buildUpon()
            java.lang.String r2 = "limit"
            java.lang.String r3 = "1"
            android.net.Uri$Builder r0 = r0.appendQueryParameter(r2, r3)
            android.net.Uri r0 = r0.build()
            r3 = r0
        L_0x0018:
            java.lang.String r0 = "mime_type"
            java.lang.String r8 = "date_modified"
            java.lang.String r9 = "datetaken"
            java.lang.String r10 = "_data"
            java.lang.String r2 = "_id"
            java.lang.String[] r4 = new java.lang.String[]{r2, r10, r9, r8, r0}
            r11 = 1
            boolean r2 = com.oppo.camera.z.b((boolean) r11)
            java.lang.String r5 = " > 0"
            java.lang.String r6 = "duration"
            java.lang.String r7 = ") and "
            java.lang.String r12 = "bucket_id IN ("
            if (r2 == 0) goto L_0x0060
            boolean r2 = com.oppo.camera.util.Util.K()
            if (r2 == 0) goto L_0x0060
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r12)
            java.lang.String r12 = com.oppo.camera.z.m
            r2.append(r12)
            java.lang.String r12 = ","
            r2.append(r12)
            java.lang.String r12 = com.oppo.camera.z.h
            r2.append(r12)
            r2.append(r7)
            r2.append(r6)
            r2.append(r5)
            java.lang.String r2 = r2.toString()
            goto L_0x007a
        L_0x0060:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r12)
            java.lang.String r12 = com.oppo.camera.z.m
            r2.append(r12)
            r2.append(r7)
            r2.append(r6)
            r2.append(r5)
            java.lang.String r2 = r2.toString()
        L_0x007a:
            r5 = r2
            java.lang.String r7 = "date_modified DESC,datetaken DESC,_id DESC"
            r6 = 0
            r12 = 0
            r2 = r26
            android.database.Cursor r2 = r2.query(r3, r4, r5, r6, r7)     // Catch:{ Exception -> 0x0106, all -> 0x0103 }
            if (r2 == 0) goto L_0x00fd
            boolean r3 = r2.moveToFirst()     // Catch:{ Exception -> 0x00fb }
            if (r3 == 0) goto L_0x00fd
            r3 = 0
            long r14 = r2.getLong(r3)     // Catch:{ Exception -> 0x00fb }
            int r3 = r2.getColumnIndex(r9)     // Catch:{ Exception -> 0x00fb }
            long r3 = r2.getLong(r3)     // Catch:{ Exception -> 0x00fb }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00fb }
            r5.<init>()     // Catch:{ Exception -> 0x00fb }
            java.lang.String r6 = "getLastVideoThumbnail, path: "
            r5.append(r6)     // Catch:{ Exception -> 0x00fb }
            java.lang.String r6 = r2.getString(r11)     // Catch:{ Exception -> 0x00fb }
            r5.append(r6)     // Catch:{ Exception -> 0x00fb }
            java.lang.String r6 = ", id: "
            r5.append(r6)     // Catch:{ Exception -> 0x00fb }
            r5.append(r14)     // Catch:{ Exception -> 0x00fb }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x00fb }
            com.oppo.camera.e.b(r1, r5)     // Catch:{ Exception -> 0x00fb }
            com.oppo.camera.ui.control.e$c r5 = new com.oppo.camera.ui.control.e$c     // Catch:{ Exception -> 0x00fb }
            r16 = 0
            r6 = 0
            int r6 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1))
            if (r6 != 0) goto L_0x00cf
            int r3 = r2.getColumnIndex(r8)     // Catch:{ Exception -> 0x00fb }
            long r3 = r2.getLong(r3)     // Catch:{ Exception -> 0x00fb }
            r6 = 1000(0x3e8, double:4.94E-321)
            long r3 = r3 * r6
        L_0x00cf:
            r17 = r3
            r3 = r27
            android.net.Uri r19 = android.content.ContentUris.withAppendedId(r3, r14)     // Catch:{ Exception -> 0x00fb }
            int r3 = r2.getColumnIndex(r10)     // Catch:{ Exception -> 0x00fb }
            java.lang.String r20 = r2.getString(r3)     // Catch:{ Exception -> 0x00fb }
            r21 = 0
            r22 = 0
            int r0 = r2.getColumnIndex(r0)     // Catch:{ Exception -> 0x00fb }
            java.lang.String r23 = r2.getString(r0)     // Catch:{ Exception -> 0x00fb }
            r24 = -1
            r25 = -1
            r13 = r5
            r13.<init>(r14, r16, r17, r19, r20, r21, r22, r23, r24, r25)     // Catch:{ Exception -> 0x00fb }
            if (r2 == 0) goto L_0x00f8
            r2.close()
        L_0x00f8:
            return r5
        L_0x00f9:
            r0 = move-exception
            goto L_0x0111
        L_0x00fb:
            r0 = move-exception
            goto L_0x0108
        L_0x00fd:
            if (r2 == 0) goto L_0x0110
        L_0x00ff:
            r2.close()
            goto L_0x0110
        L_0x0103:
            r0 = move-exception
            r2 = r12
            goto L_0x0111
        L_0x0106:
            r0 = move-exception
            r2 = r12
        L_0x0108:
            java.lang.String r3 = "getLastVideoThumbnail, fail"
            com.oppo.camera.e.d(r1, r3, r0)     // Catch:{ all -> 0x00f9 }
            if (r2 == 0) goto L_0x0110
            goto L_0x00ff
        L_0x0110:
            return r12
        L_0x0111:
            if (r2 == 0) goto L_0x0116
            r2.close()
        L_0x0116:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.ui.control.e.a(android.content.ContentResolver, android.net.Uri, android.net.Uri):com.oppo.camera.ui.control.e$c");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x00d6, code lost:
        if (r3 != null) goto L_0x00d8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x00d8, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00e6, code lost:
        if (r3 != null) goto L_0x00d8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00e9, code lost:
        return null;
     */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00ec  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.oppo.camera.ui.control.e.c a(android.content.ContentResolver r26) {
        /*
            java.lang.String r1 = "Thumbnail"
            java.lang.String r0 = "external"
            android.net.Uri r0 = android.provider.MediaStore.Files.getContentUri(r0)
            android.net.Uri$Builder r2 = r0.buildUpon()
            java.lang.String r3 = "limit"
            java.lang.String r4 = "1"
            android.net.Uri$Builder r2 = r2.appendQueryParameter(r3, r4)
            android.net.Uri r4 = r2.build()
            java.lang.String r2 = "mime_type"
            java.lang.String r9 = "datetaken"
            java.lang.String r10 = "_data"
            java.lang.String r3 = "_id"
            java.lang.String[] r5 = new java.lang.String[]{r3, r10, r9, r2}
            r11 = 1
            boolean r3 = com.oppo.camera.z.b((boolean) r11)
            java.lang.String r6 = ") AND mime_type like 'model/gltf-binary'"
            java.lang.String r7 = "bucket_id IN ("
            if (r3 == 0) goto L_0x0054
            boolean r3 = com.oppo.camera.util.Util.K()
            if (r3 == 0) goto L_0x0054
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r7)
            java.lang.String r7 = com.oppo.camera.z.m
            r3.append(r7)
            java.lang.String r7 = ","
            r3.append(r7)
            java.lang.String r7 = com.oppo.camera.z.h
            r3.append(r7)
            r3.append(r6)
            java.lang.String r3 = r3.toString()
            goto L_0x0068
        L_0x0054:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r7)
            java.lang.String r7 = com.oppo.camera.z.m
            r3.append(r7)
            r3.append(r6)
            java.lang.String r3 = r3.toString()
        L_0x0068:
            r6 = r3
            java.lang.String r8 = "datetaken DESC,_id DESC"
            r7 = 0
            r12 = 0
            r3 = r26
            android.database.Cursor r3 = r3.query(r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x00df, all -> 0x00dc }
            if (r3 == 0) goto L_0x00d6
            boolean r4 = r3.moveToFirst()     // Catch:{ Exception -> 0x00d4 }
            if (r4 == 0) goto L_0x00d6
            r4 = 0
            long r14 = r3.getLong(r4)     // Catch:{ Exception -> 0x00d4 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00d4 }
            r4.<init>()     // Catch:{ Exception -> 0x00d4 }
            java.lang.String r5 = "getLastModeThumbnail, path: "
            r4.append(r5)     // Catch:{ Exception -> 0x00d4 }
            java.lang.String r5 = r3.getString(r11)     // Catch:{ Exception -> 0x00d4 }
            r4.append(r5)     // Catch:{ Exception -> 0x00d4 }
            java.lang.String r5 = ", id: "
            r4.append(r5)     // Catch:{ Exception -> 0x00d4 }
            r4.append(r14)     // Catch:{ Exception -> 0x00d4 }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x00d4 }
            com.oppo.camera.e.b(r1, r4)     // Catch:{ Exception -> 0x00d4 }
            com.oppo.camera.ui.control.e$c r4 = new com.oppo.camera.ui.control.e$c     // Catch:{ Exception -> 0x00d4 }
            r16 = 0
            int r5 = r3.getColumnIndex(r9)     // Catch:{ Exception -> 0x00d4 }
            long r17 = r3.getLong(r5)     // Catch:{ Exception -> 0x00d4 }
            android.net.Uri r19 = android.content.ContentUris.withAppendedId(r0, r14)     // Catch:{ Exception -> 0x00d4 }
            int r0 = r3.getColumnIndex(r10)     // Catch:{ Exception -> 0x00d4 }
            java.lang.String r20 = r3.getString(r0)     // Catch:{ Exception -> 0x00d4 }
            r21 = 0
            r22 = 0
            int r0 = r3.getColumnIndex(r2)     // Catch:{ Exception -> 0x00d4 }
            java.lang.String r23 = r3.getString(r0)     // Catch:{ Exception -> 0x00d4 }
            r24 = -1
            r25 = -1
            r13 = r4
            r13.<init>(r14, r16, r17, r19, r20, r21, r22, r23, r24, r25)     // Catch:{ Exception -> 0x00d4 }
            if (r3 == 0) goto L_0x00d1
            r3.close()
        L_0x00d1:
            return r4
        L_0x00d2:
            r0 = move-exception
            goto L_0x00ea
        L_0x00d4:
            r0 = move-exception
            goto L_0x00e1
        L_0x00d6:
            if (r3 == 0) goto L_0x00e9
        L_0x00d8:
            r3.close()
            goto L_0x00e9
        L_0x00dc:
            r0 = move-exception
            r3 = r12
            goto L_0x00ea
        L_0x00df:
            r0 = move-exception
            r3 = r12
        L_0x00e1:
            java.lang.String r2 = "getLastModeThumbnail, fail"
            com.oppo.camera.e.d(r1, r2, r0)     // Catch:{ all -> 0x00d2 }
            if (r3 == 0) goto L_0x00e9
            goto L_0x00d8
        L_0x00e9:
            return r12
        L_0x00ea:
            if (r3 == 0) goto L_0x00ef
            r3.close()
        L_0x00ef:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.ui.control.e.a(android.content.ContentResolver):com.oppo.camera.ui.control.e$c");
    }

    public static Bitmap a(ContentResolver contentResolver, Uri uri) {
        if (uri == null) {
            com.oppo.camera.e.e("Thumbnail", "createBitmapForExifThumbnail, uri: null");
            return null;
        }
        byte[] a2 = z.a(contentResolver, uri);
        if (a2 != null) {
            return BitmapFactory.decodeByteArray(a2, 0, a2.length);
        }
        com.oppo.camera.e.e("Thumbnail", "createBitmapForExifThumbnail, thumbnailData: null");
        return null;
    }

    public static e a(Bitmap bitmap, int i2, int i3, Uri uri, String str, long j2) {
        if (bitmap != null) {
            return a(uri, bitmap, i2, str, j2);
        }
        com.oppo.camera.e.a("Thumbnail", "createThumbnail(), use data cereate bitmap is null... ");
        return null;
    }

    public static e a(byte[] bArr, int i2, int i3, Uri uri, String str, long j2) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        if (i3 > 4) {
            i3 = 4;
        }
        options.inSampleSize = i3;
        return a(uri, b(BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options), ThumbImageView.f3902a), i2, str, j2);
    }

    public static Bitmap a(FileDescriptor fileDescriptor, int i2) {
        return a((String) null, fileDescriptor, i2);
    }

    public static Bitmap a(String str, int i2) {
        return a(str, (FileDescriptor) null, i2);
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0022 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.graphics.Bitmap a(java.lang.String r1, java.io.FileDescriptor r2, int r3) {
        /*
            android.os.ConditionVariable r0 = p
            r0.block()
            android.media.MediaMetadataRetriever r0 = new android.media.MediaMetadataRetriever
            r0.<init>()
            if (r1 == 0) goto L_0x0010
            r0.setDataSource(r1)     // Catch:{ IllegalArgumentException | RuntimeException -> 0x0022, all -> 0x001d }
            goto L_0x0013
        L_0x0010:
            r0.setDataSource(r2)     // Catch:{ IllegalArgumentException | RuntimeException -> 0x0022, all -> 0x001d }
        L_0x0013:
            r1 = -1
            android.graphics.Bitmap r1 = r0.getFrameAtTime(r1)     // Catch:{ IllegalArgumentException | RuntimeException -> 0x0022, all -> 0x001d }
            r0.release()     // Catch:{ RuntimeException -> 0x0026 }
            goto L_0x0026
        L_0x001d:
            r1 = move-exception
            r0.release()     // Catch:{ RuntimeException -> 0x0021 }
        L_0x0021:
            throw r1
        L_0x0022:
            r0.release()     // Catch:{ RuntimeException -> 0x0025 }
        L_0x0025:
            r1 = 0
        L_0x0026:
            android.graphics.Bitmap r1 = b((android.graphics.Bitmap) r1, (int) r3)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.ui.control.e.a(java.lang.String, java.io.FileDescriptor, int):android.graphics.Bitmap");
    }

    public static void b() {
        com.oppo.camera.e.c("Thumbnail", "closeMediaLimitCondition");
        p.close();
    }

    public static void c() {
        com.oppo.camera.e.c("Thumbnail", "openMediaLimitCondition");
        p.open();
    }

    public static e a(Uri uri, Bitmap bitmap, int i2, String str, long j2) {
        com.oppo.camera.e.e("Thumbnail", "createThumbnail, uri: " + uri);
        return new e(uri, bitmap, i2, str, j2);
    }

    public static e a(HardwareBuffer hardwareBuffer, int i2, int i3, int i4, int i5) {
        float f2;
        float f3;
        int i6;
        int i7;
        int i8 = i2;
        int i9 = i3;
        int i10 = i4;
        int i11 = i5;
        com.oppo.camera.e.a("Thumbnail", "createThumbnail start, width: " + i8 + ", height: " + i9 + ", rotate: " + i11);
        if (i10 != 0) {
            f2 = ((float) (i8 < i9 ? i8 : i9)) / ((float) i10);
        } else {
            f2 = 0.0f;
        }
        if (i11 == 90 || i11 == 270) {
            i6 = (int) (((float) i9) / f2);
            f3 = (float) i8;
        } else {
            i6 = (int) (((float) i8) / f2);
            f3 = (float) i9;
        }
        int i12 = i6;
        int i13 = (int) (f3 / f2);
        if (i11 != 0) {
            if (i11 == 90) {
                i7 = 1;
            } else if (i11 == 180) {
                i7 = 2;
            } else if (i11 == 270) {
                i7 = 3;
            }
            Bitmap a2 = Util.a(i12, i13, Bitmap.Config.ARGB_8888);
            FormatConverter formatConverter = new FormatConverter();
            long nv21ToBitmapInitWithHardwareBuffer = formatConverter.nv21ToBitmapInitWithHardwareBuffer(hardwareBuffer, i2, i3, i12, i13, f2, 1, i7, 0, 0, 2);
            Bitmap bitmap = a2;
            formatConverter.hardwareBufferToBitmapProcess(nv21ToBitmapInitWithHardwareBuffer, hardwareBuffer, 0, bitmap, i12);
            formatConverter.nv21ToBitmapUnInit(nv21ToBitmapInitWithHardwareBuffer);
            com.oppo.camera.e.a("Thumbnail", "createThumbnail end");
            return new e(bitmap);
        }
        i7 = 0;
        Bitmap a22 = Util.a(i12, i13, Bitmap.Config.ARGB_8888);
        FormatConverter formatConverter2 = new FormatConverter();
        long nv21ToBitmapInitWithHardwareBuffer2 = formatConverter2.nv21ToBitmapInitWithHardwareBuffer(hardwareBuffer, i2, i3, i12, i13, f2, 1, i7, 0, 0, 2);
        Bitmap bitmap2 = a22;
        formatConverter2.hardwareBufferToBitmapProcess(nv21ToBitmapInitWithHardwareBuffer2, hardwareBuffer, 0, bitmap2, i12);
        formatConverter2.nv21ToBitmapUnInit(nv21ToBitmapInitWithHardwareBuffer2);
        com.oppo.camera.e.a("Thumbnail", "createThumbnail end");
        return new e(bitmap2);
    }

    public static Bitmap a(Bitmap bitmap, int i2, int i3, boolean z) {
        if (bitmap == null) {
            return null;
        }
        Bitmap a2 = Util.a(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(a2);
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Paint paint = new Paint();
        Rect rect = new Rect(0, 0, width, height);
        RectF rectF = new RectF(rect);
        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(-12434878);
        float f2 = (float) i2;
        canvas.drawRoundRect(rectF, f2, f2, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        if (z) {
            Paint paint2 = new Paint();
            paint2.setColor(452984831);
            paint2.setStrokeWidth((float) i3);
            paint2.setStyle(Paint.Style.STROKE);
            paint2.setAntiAlias(true);
            canvas.drawCircle((float) (width / 2), (float) (height / 2), (float) (i2 - (i3 / 2)), paint2);
        }
        return a2;
    }

    public Uri d() {
        return this.g;
    }

    public String e() {
        return this.i;
    }

    public long f() {
        return this.j;
    }

    public Bitmap g() {
        return this.k;
    }

    public void h() {
        Bitmap bitmap = this.k;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.k.recycle();
        }
        this.k = null;
        this.g = null;
    }

    public String i() {
        return this.h;
    }

    public void a(c cVar) {
        this.n = cVar;
    }

    /* compiled from: Thumbnail */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public long f3919a;

        /* renamed from: b  reason: collision with root package name */
        public int f3920b;
        public long c;
        public Uri d;
        public String e;
        public String f;
        public String g;
        public String h;
        public int i = 0;
        public int j = 0;
        public int k = -1;
        public Bitmap l = null;

        public c() {
        }

        public c(long j2, int i2, long j3, Uri uri, String str, String str2, String str3, String str4, int i3, int i4) {
            this.f3919a = j2;
            this.f3920b = i2;
            this.c = j3;
            this.d = uri;
            this.e = str;
            this.f = str2;
            this.g = str3;
            this.i = i3;
            this.j = i4;
            this.h = str4;
        }
    }
}
