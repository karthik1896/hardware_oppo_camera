package com.oppo.camera;

import android.util.Size;
import com.oppo.camera.ui.preview.d;
import java.util.ArrayList;

/* compiled from: PreviewImageProcess */
public class u {

    /* renamed from: a  reason: collision with root package name */
    private boolean f3158a = false;

    /* renamed from: b  reason: collision with root package name */
    private boolean f3159b = false;
    private ArrayList<a> c = new ArrayList<>();
    private d.a d = null;
    private b e = null;
    private a f = null;

    /* compiled from: PreviewImageProcess */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public Size f3160a = null;

        /* renamed from: b  reason: collision with root package name */
        public Size f3161b = null;
        public int c = 0;
        public int d = 0;
        public boolean e = false;
        public int f = 0;
    }

    /* compiled from: PreviewImageProcess */
    public interface b {
        boolean W();

        void Y();

        void a(Size size, Size size2, d.a aVar, int i, int i2, int i3, boolean z);
    }

    public u(b bVar) {
        this.e = bVar;
    }

    public void a() {
        a(true);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x006f, code lost:
        if (r3.e.W() != false) goto L_0x00a7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0071, code lost:
        monitor-enter(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0078, code lost:
        if (r3.c.isEmpty() == false) goto L_0x009b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x007a, code lost:
        r1 = new com.oppo.camera.u.a();
        r1.f3160a = r4;
        r1.f3161b = r5;
        r1.c = r4.getWidth();
        r1.d = r4.getHeight();
        r1.e = false;
        r1.f = r7;
        r3.c.add(r1);
        r3.f3159b = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x009b, code lost:
        com.oppo.camera.e.e("PreviewImageProcess", "getPreviewFrame, onPreviewCaptured, setData fail!");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x00a2, code lost:
        monitor-exit(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00a7, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(android.util.Size r4, android.util.Size r5, boolean r6, int r7) {
        /*
            r3 = this;
            monitor-enter(r3)
            java.lang.String r0 = "PreviewImageProcess"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00aa }
            r1.<init>()     // Catch:{ all -> 0x00aa }
            java.lang.String r2 = "setCaptureOnePreviewData, mbShowBlurImage: "
            r1.append(r2)     // Catch:{ all -> 0x00aa }
            boolean r2 = r3.f3158a     // Catch:{ all -> 0x00aa }
            r1.append(r2)     // Catch:{ all -> 0x00aa }
            java.lang.String r2 = ", mbDataGetting: "
            r1.append(r2)     // Catch:{ all -> 0x00aa }
            boolean r2 = r3.f3159b     // Catch:{ all -> 0x00aa }
            r1.append(r2)     // Catch:{ all -> 0x00aa }
            java.lang.String r2 = ", currSize: "
            r1.append(r2)     // Catch:{ all -> 0x00aa }
            int r2 = r4.getWidth()     // Catch:{ all -> 0x00aa }
            r1.append(r2)     // Catch:{ all -> 0x00aa }
            java.lang.String r2 = " x "
            r1.append(r2)     // Catch:{ all -> 0x00aa }
            int r2 = r4.getHeight()     // Catch:{ all -> 0x00aa }
            r1.append(r2)     // Catch:{ all -> 0x00aa }
            java.lang.String r2 = ", newSize: "
            r1.append(r2)     // Catch:{ all -> 0x00aa }
            int r2 = r5.getWidth()     // Catch:{ all -> 0x00aa }
            r1.append(r2)     // Catch:{ all -> 0x00aa }
            java.lang.String r2 = " x "
            r1.append(r2)     // Catch:{ all -> 0x00aa }
            int r2 = r5.getHeight()     // Catch:{ all -> 0x00aa }
            r1.append(r2)     // Catch:{ all -> 0x00aa }
            java.lang.String r2 = ", modeTypeChange: "
            r1.append(r2)     // Catch:{ all -> 0x00aa }
            r1.append(r6)     // Catch:{ all -> 0x00aa }
            java.lang.String r6 = r1.toString()     // Catch:{ all -> 0x00aa }
            com.oppo.camera.e.a(r0, r6)     // Catch:{ all -> 0x00aa }
            boolean r6 = r3.f3159b     // Catch:{ all -> 0x00aa }
            r0 = 0
            if (r6 != 0) goto L_0x00a8
            boolean r6 = r3.f3158a     // Catch:{ all -> 0x00aa }
            if (r6 == 0) goto L_0x0065
            goto L_0x00a8
        L_0x0065:
            r6 = 1
            r3.f3159b = r6     // Catch:{ all -> 0x00aa }
            monitor-exit(r3)     // Catch:{ all -> 0x00aa }
            com.oppo.camera.u$b r1 = r3.e
            boolean r1 = r1.W()
            if (r1 != 0) goto L_0x00a7
            monitor-enter(r3)
            java.util.ArrayList<com.oppo.camera.u$a> r1 = r3.c     // Catch:{ all -> 0x00a4 }
            boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x00a4 }
            if (r1 == 0) goto L_0x009b
            com.oppo.camera.u$a r1 = new com.oppo.camera.u$a     // Catch:{ all -> 0x00a4 }
            r1.<init>()     // Catch:{ all -> 0x00a4 }
            r1.f3160a = r4     // Catch:{ all -> 0x00a4 }
            r1.f3161b = r5     // Catch:{ all -> 0x00a4 }
            int r5 = r4.getWidth()     // Catch:{ all -> 0x00a4 }
            r1.c = r5     // Catch:{ all -> 0x00a4 }
            int r4 = r4.getHeight()     // Catch:{ all -> 0x00a4 }
            r1.d = r4     // Catch:{ all -> 0x00a4 }
            r1.e = r0     // Catch:{ all -> 0x00a4 }
            r1.f = r7     // Catch:{ all -> 0x00a4 }
            java.util.ArrayList<com.oppo.camera.u$a> r4 = r3.c     // Catch:{ all -> 0x00a4 }
            r4.add(r1)     // Catch:{ all -> 0x00a4 }
            r3.f3159b = r0     // Catch:{ all -> 0x00a4 }
            goto L_0x00a2
        L_0x009b:
            java.lang.String r4 = "PreviewImageProcess"
            java.lang.String r5 = "getPreviewFrame, onPreviewCaptured, setData fail!"
            com.oppo.camera.e.e(r4, r5)     // Catch:{ all -> 0x00a4 }
        L_0x00a2:
            monitor-exit(r3)     // Catch:{ all -> 0x00a4 }
            goto L_0x00a7
        L_0x00a4:
            r4 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x00a4 }
            throw r4
        L_0x00a7:
            return r6
        L_0x00a8:
            monitor-exit(r3)     // Catch:{ all -> 0x00aa }
            return r0
        L_0x00aa:
            r4 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x00aa }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.u.a(android.util.Size, android.util.Size, boolean, int):boolean");
    }

    public synchronized void a(boolean z) {
        e.a("PreviewImageProcess", "resetData allClean: " + z);
        if (!z) {
            this.f3159b = false;
            return;
        }
        this.f3158a = false;
        this.f3159b = false;
        this.c.clear();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x005c, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(com.oppo.camera.ui.preview.d.a r4, int r5, int r6, boolean r7) {
        /*
            r3 = this;
            monitor-enter(r3)
            java.lang.String r0 = "PreviewImageProcess"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x005d }
            r1.<init>()     // Catch:{ all -> 0x005d }
            java.lang.String r2 = "showBlurBitmap, mBitmap: mCurrentPreviewData: "
            r1.append(r2)     // Catch:{ all -> 0x005d }
            com.oppo.camera.u$a r2 = r3.f     // Catch:{ all -> 0x005d }
            r1.append(r2)     // Catch:{ all -> 0x005d }
            java.lang.String r2 = ", mbDataGetting: "
            r1.append(r2)     // Catch:{ all -> 0x005d }
            boolean r2 = r3.f3159b     // Catch:{ all -> 0x005d }
            r1.append(r2)     // Catch:{ all -> 0x005d }
            java.lang.String r2 = ", mbShowBlurImage: "
            r1.append(r2)     // Catch:{ all -> 0x005d }
            boolean r2 = r3.f3158a     // Catch:{ all -> 0x005d }
            r1.append(r2)     // Catch:{ all -> 0x005d }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x005d }
            com.oppo.camera.e.a(r0, r1)     // Catch:{ all -> 0x005d }
            boolean r0 = r3.f3158a     // Catch:{ all -> 0x005d }
            r1 = 1
            if (r0 == 0) goto L_0x004c
            java.lang.String r4 = "PreviewImageProcess"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x005d }
            r5.<init>()     // Catch:{ all -> 0x005d }
            java.lang.String r6 = "showBlurBitmap, the blur image has been shown, mbShowBlurImage: "
            r5.append(r6)     // Catch:{ all -> 0x005d }
            boolean r6 = r3.f3158a     // Catch:{ all -> 0x005d }
            r5.append(r6)     // Catch:{ all -> 0x005d }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x005d }
            com.oppo.camera.e.a(r4, r5)     // Catch:{ all -> 0x005d }
            monitor-exit(r3)     // Catch:{ all -> 0x005d }
            return r1
        L_0x004c:
            r3.d = r4     // Catch:{ all -> 0x005d }
            r3.f3158a = r1     // Catch:{ all -> 0x005d }
            java.util.ArrayList<com.oppo.camera.u$a> r4 = r3.c     // Catch:{ all -> 0x005d }
            boolean r4 = r4.isEmpty()     // Catch:{ all -> 0x005d }
            if (r4 != 0) goto L_0x005b
            r3.a(r5, r6, r7)     // Catch:{ all -> 0x005d }
        L_0x005b:
            monitor-exit(r3)     // Catch:{ all -> 0x005d }
            return r1
        L_0x005d:
            r4 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x005d }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.u.a(com.oppo.camera.ui.preview.d$a, int, int, boolean):boolean");
    }

    public synchronized boolean b() {
        e.a("PreviewImageProcess", "isShowBlurBitmap: " + this.f3158a);
        return this.f3158a;
    }

    public boolean c() {
        boolean z;
        synchronized (this) {
            z = !this.f3158a;
        }
        return z;
    }

    public synchronized void b(boolean z) {
        this.f3158a = false;
        e.a("PreviewImageProcess", "resetBlurAnimation, mbShowBlurImage: " + this.f3158a);
        if (z) {
            this.c.clear();
            this.f = null;
        }
    }

    public synchronized void a(Size size, Size size2) {
        if (this.f != null) {
            this.f.f3160a = size;
            this.f.f3161b = size2;
        }
    }

    private void a(int i, int i2, boolean z) {
        e.a("PreviewImageProcess", "handleImage");
        boolean z2 = false;
        if (this.e.W() || !this.f3158a || (this.c.isEmpty() && this.f == null)) {
            z2 = true;
        } else {
            if (!this.c.isEmpty()) {
                this.f = this.c.get(0);
            }
            e.a("PreviewImageProcess", "handleImage, size: " + this.f.f3160a.getWidth() + " x " + this.f.f3160a.getHeight() + " => " + this.f.f3161b.getWidth() + " x " + this.f.f3161b.getHeight());
            this.e.a(this.f.f3160a, this.f.f3161b, this.d, this.f.f, i, i2, z);
        }
        a(true);
        if (z2) {
            this.e.Y();
            d.a aVar = this.d;
            if (aVar != null) {
                aVar.a();
            }
        }
    }
}
