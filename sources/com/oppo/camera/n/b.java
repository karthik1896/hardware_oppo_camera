package com.oppo.camera.n;

import android.app.Activity;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* compiled from: ImageSaverThread */
public class b extends d {
    private static b d;

    /* renamed from: b  reason: collision with root package name */
    private ExecutorService f3445b = Executors.newSingleThreadExecutor();
    private c c = new c();

    /* access modifiers changed from: protected */
    public void b() {
    }

    public void c() {
    }

    public static b a() {
        b bVar;
        synchronized (b.class) {
            if (d == null) {
                d = new b();
            }
            bVar = d;
        }
        return bVar;
    }

    private b() {
    }

    public boolean a(Activity activity, long j) {
        c cVar = this.c;
        if (cVar != null) {
            return cVar.a(activity, j);
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:60:0x01f2  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x01fb  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x020e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b(com.oppo.camera.z.a r20) throws java.lang.Exception {
        /*
            r19 = this;
            r0 = r19
            r1 = r20
            java.util.Locale r2 = java.util.Locale.ENGLISH
            r3 = 7
            java.lang.Object[] r3 = new java.lang.Object[r3]
            byte[] r4 = r1.e
            r5 = -1
            if (r4 != 0) goto L_0x0010
            r4 = r5
            goto L_0x0013
        L_0x0010:
            byte[] r4 = r1.e
            int r4 = r4.length
        L_0x0013:
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r6 = 0
            r3[r6] = r4
            long r6 = r1.J
            java.lang.Long r4 = java.lang.Long.valueOf(r6)
            r6 = 1
            r3[r6] = r4
            r4 = 2
            int r7 = r1.p
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            r3[r4] = r7
            r4 = 3
            android.net.Uri r7 = r1.c
            r3[r4] = r7
            r4 = 4
            com.oppo.camera.ui.control.e$a r7 = r1.A
            r3[r4] = r7
            r4 = 5
            boolean r7 = r1.K
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r7)
            r3[r4] = r7
            r4 = 6
            boolean r7 = r1.E
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r7)
            r3[r4] = r7
            java.lang.String r4 = "handlePicture, picture.jpeg: %d, timeStamp: %d, mRecBurstNum: %d, mUri: %s, mUpdateThumbTask: %s, mbLatestPicture: %s, mbWriteExifByApp: %s."
            java.lang.String r2 = java.lang.String.format(r2, r4, r3)
            java.lang.String r3 = "ImageSaverThread"
            com.oppo.camera.e.a(r3, r2)
            android.content.Context r2 = com.oppo.camera.util.Util.f()
            android.content.ContentResolver r2 = r2.getContentResolver()
            r1.f3177a = r2
            android.net.Uri r2 = r1.c
            if (r2 == 0) goto L_0x0065
            com.oppo.camera.z.c((com.oppo.camera.z.a) r20)
            goto L_0x0075
        L_0x0065:
            byte[] r2 = r1.e
            if (r2 == 0) goto L_0x0075
            com.oppo.camera.n.c r2 = r0.c
            byte[] r4 = r1.e
            int r4 = r4.length
            long r7 = (long) r4
            r2.a(r7)
            com.oppo.camera.z.a((com.oppo.camera.z.a) r20)
        L_0x0075:
            com.oppo.camera.ui.control.e$b r2 = r1.U
            if (r2 == 0) goto L_0x0080
            com.oppo.camera.ui.control.e$b r2 = r1.U
            long r7 = r1.n
            r2.a(r7)
        L_0x0080:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r4 = "CameraTest Picture Save End, picture.mFormat: "
            r2.append(r4)
            java.lang.String r4 = r1.j
            r2.append(r4)
            java.lang.String r4 = ", picture.mUri: "
            r2.append(r4)
            android.net.Uri r4 = r1.c
            r2.append(r4)
            java.lang.String r2 = r2.toString()
            com.oppo.camera.e.b(r3, r2)
            com.oppo.camera.util.a.a((com.oppo.camera.z.a) r20)
            boolean r2 = r1.x
            r4 = 0
            if (r2 != 0) goto L_0x00b1
            com.oppo.camera.ui.control.e$a r2 = r1.B
            if (r2 == 0) goto L_0x00b1
            com.oppo.camera.ui.control.e$a r2 = r1.B
            r2.a(r4)
        L_0x00b1:
            android.net.Uri r2 = r1.c
            if (r2 == 0) goto L_0x021f
            boolean r2 = r1.K
            if (r2 == 0) goto L_0x00bd
            int r2 = r1.p
            if (r5 == r2) goto L_0x00c1
        L_0x00bd:
            int r2 = r1.p
            if (r6 != r2) goto L_0x00c8
        L_0x00c1:
            com.oppo.camera.n.a r2 = com.oppo.camera.n.a.a()
            r2.a((com.oppo.camera.z.a) r1)
        L_0x00c8:
            java.lang.String r2 = r1.j
            if (r2 == 0) goto L_0x00e0
            java.lang.String r2 = r1.j
            java.lang.String r6 = "raw"
            boolean r2 = r2.equalsIgnoreCase(r6)
            if (r2 == 0) goto L_0x00e0
            boolean r2 = r1.y
            if (r2 != 0) goto L_0x00e0
            java.lang.String r1 = "handlePicture, picture.mFormat is raw, do not updateThumbNail"
            com.oppo.camera.e.a(r3, r1)
            return
        L_0x00e0:
            com.oppo.camera.ui.control.e$a r2 = r1.A
            if (r2 == 0) goto L_0x0215
            java.lang.String r2 = "handlePicture, create thumbnail for JpegData start"
            com.oppo.camera.e.a(r3, r2)
            java.lang.String r2 = r1.i
            byte[] r6 = com.oppo.camera.util.Util.c((java.lang.String) r2)
            int r2 = r1.q
            int r7 = r1.r
            int r8 = r1.w
            int r9 = r1.w
            int r2 = com.oppo.camera.util.Util.a((int) r2, (int) r7, (int) r8, (int) r9)
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "handlePicture, create thumbnail for Exif start, inSampleSize: "
            r7.append(r8)
            r7.append(r2)
            java.lang.String r8 = ", thumbnailData: "
            r7.append(r8)
            r7.append(r6)
            java.lang.String r7 = r7.toString()
            com.oppo.camera.e.a(r3, r7)
            if (r6 == 0) goto L_0x0151
            int r7 = r6.length
            if (r7 <= 0) goto L_0x0151
            int r7 = r1.v
            r8 = 1
            android.net.Uri r9 = r1.c
            java.lang.String r4 = java.lang.String.valueOf(r5)
            java.lang.String r10 = r1.j
            java.lang.String r10 = com.oppo.camera.z.a((java.lang.String) r4, (java.lang.String) r10)
            long r14 = (long) r5
            r11 = r14
            com.oppo.camera.ui.control.e r4 = com.oppo.camera.ui.control.e.a((byte[]) r6, (int) r7, (int) r8, (android.net.Uri) r9, (java.lang.String) r10, (long) r11)
            if (r4 != 0) goto L_0x01e8
            byte[] r6 = r1.e
            if (r6 == 0) goto L_0x01e8
            byte[] r10 = r1.e
            int r11 = r1.v
            android.net.Uri r13 = r1.c
            java.lang.String r4 = java.lang.String.valueOf(r5)
            java.lang.String r5 = r1.j
            java.lang.String r4 = com.oppo.camera.z.a((java.lang.String) r4, (java.lang.String) r5)
            r12 = r2
            r5 = r14
            r14 = r4
            r15 = r5
            com.oppo.camera.ui.control.e r4 = com.oppo.camera.ui.control.e.a((byte[]) r10, (int) r11, (int) r12, (android.net.Uri) r13, (java.lang.String) r14, (long) r15)
            goto L_0x01e8
        L_0x0151:
            byte[] r6 = r1.e
            if (r6 == 0) goto L_0x01e8
            java.lang.String r6 = r1.j
            java.lang.String r7 = "heic_8bits"
            boolean r6 = r7.equalsIgnoreCase(r6)
            if (r6 == 0) goto L_0x0187
            android.graphics.Bitmap r2 = r1.N
            if (r2 == 0) goto L_0x01e8
            android.net.Uri r6 = r1.c
            android.graphics.Bitmap r2 = r1.N
            int r7 = com.oppo.camera.ui.control.ThumbImageView.f3902a
            android.graphics.Bitmap r7 = com.oppo.camera.ui.control.e.b((android.graphics.Bitmap) r2, (int) r7)
            int r8 = r1.v
            java.lang.String r2 = java.lang.String.valueOf(r5)
            java.lang.String r9 = r1.j
            java.lang.String r9 = com.oppo.camera.z.a((java.lang.String) r2, (java.lang.String) r9)
            long r10 = (long) r5
            com.oppo.camera.ui.control.e r2 = com.oppo.camera.ui.control.e.a((android.net.Uri) r6, (android.graphics.Bitmap) r7, (int) r8, (java.lang.String) r9, (long) r10)
            android.graphics.Bitmap r5 = r1.N
            r5.recycle()
            r1.N = r4
            r8 = r2
            goto L_0x01e9
        L_0x0187:
            java.lang.String r4 = r1.j
            java.lang.String r6 = "heic_10bits"
            boolean r4 = r6.equalsIgnoreCase(r4)
            if (r4 == 0) goto L_0x01d0
            android.content.ContentResolver r2 = r1.f3177a
            com.oppo.camera.ui.control.e$c r4 = new com.oppo.camera.ui.control.e$c
            r7 = 0
            int r9 = r1.v
            long r10 = r1.n
            android.net.Uri r12 = r1.c
            java.lang.String r13 = r1.i
            java.lang.String r14 = r1.h
            java.lang.String r15 = r1.i
            java.lang.String r16 = com.oppo.camera.q.a.e
            int r6 = r1.q
            int r5 = r1.r
            r17 = r6
            r6 = r4
            r18 = r5
            r6.<init>(r7, r9, r10, r12, r13, r14, r15, r16, r17, r18)
            android.graphics.Bitmap r2 = com.oppo.camera.ui.control.e.a((android.content.ContentResolver) r2, (com.oppo.camera.ui.control.e.c) r4)
            android.net.Uri r4 = r1.c
            int r5 = r1.v
            android.graphics.Bitmap r5 = com.oppo.camera.ui.control.e.a((android.graphics.Bitmap) r2, (int) r5)
            r6 = 0
            r7 = -1
            java.lang.String r2 = java.lang.String.valueOf(r7)
            java.lang.String r8 = r1.j
            java.lang.String r2 = com.oppo.camera.z.a((java.lang.String) r2, (java.lang.String) r8)
            long r8 = (long) r7
            r7 = r2
            com.oppo.camera.ui.control.e r4 = com.oppo.camera.ui.control.e.a((android.net.Uri) r4, (android.graphics.Bitmap) r5, (int) r6, (java.lang.String) r7, (long) r8)
            goto L_0x01e8
        L_0x01d0:
            r7 = r5
            byte[] r10 = r1.e
            int r11 = r1.v
            android.net.Uri r13 = r1.c
            java.lang.String r4 = java.lang.String.valueOf(r7)
            java.lang.String r5 = r1.j
            java.lang.String r14 = com.oppo.camera.z.a((java.lang.String) r4, (java.lang.String) r5)
            long r4 = (long) r7
            r12 = r2
            r15 = r4
            com.oppo.camera.ui.control.e r4 = com.oppo.camera.ui.control.e.a((byte[]) r10, (int) r11, (int) r12, (android.net.Uri) r13, (java.lang.String) r14, (long) r15)
        L_0x01e8:
            r8 = r4
        L_0x01e9:
            java.lang.String r2 = "handlePicture, create thumbnail for Exif end"
            com.oppo.camera.e.a(r3, r2)
            boolean r2 = r1.P
            if (r2 != 0) goto L_0x01f7
            com.oppo.camera.ui.control.e$a r2 = r1.A
            r2.a(r8)
        L_0x01f7:
            com.oppo.camera.a.e r2 = r1.L
            if (r2 == 0) goto L_0x020a
            com.oppo.camera.a.e r5 = r1.L
            android.graphics.Bitmap r6 = r1.M
            com.oppo.camera.ui.control.e$a r7 = r1.A
            boolean r9 = r1.P
            int r10 = r1.Q
            boolean r11 = r1.T
            r5.a(r6, r7, r8, r9, r10, r11)
        L_0x020a:
            com.oppo.camera.a.d r2 = r1.O
            if (r2 == 0) goto L_0x0215
            com.oppo.camera.a.d r2 = r1.O
            boolean r3 = r1.P
            r2.a(r3)
        L_0x0215:
            java.util.concurrent.ExecutorService r2 = r0.f3445b
            com.oppo.camera.n.b$1 r3 = new com.oppo.camera.n.b$1
            r3.<init>(r1)
            r2.submit(r3)
        L_0x021f:
            boolean r2 = com.oppo.camera.z.c()
            if (r2 != 0) goto L_0x0232
            java.lang.String r2 = r1.h
            if (r2 == 0) goto L_0x0232
            com.oppo.camera.util.g r2 = com.oppo.camera.util.g.a()
            java.lang.String r1 = r1.h
            r2.b((java.lang.String) r1)
        L_0x0232:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.n.b.b(com.oppo.camera.z$a):void");
    }
}
