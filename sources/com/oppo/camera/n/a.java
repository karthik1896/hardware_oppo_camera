package com.oppo.camera.n;

import com.oppo.camera.e;
import com.oppo.camera.l;
import com.oppo.camera.util.Util;
import com.oppo.camera.z;

/* compiled from: CallGalleryPreDecodeThread */
public class a extends d {
    private static a c;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public l f3443b = null;

    public static a a() {
        a aVar;
        synchronized (a.class) {
            if (c == null) {
                c = new a();
            }
            aVar = c;
        }
        return aVar;
    }

    public void a(z.a aVar) {
        d();
        if (aVar != null && aVar.D) {
            c(aVar);
        }
    }

    /* access modifiers changed from: protected */
    public void b() {
        synchronized (this) {
            if (this.f3443b == null) {
                this.f3443b = new l();
                this.f3443b.a(Util.f());
            }
        }
    }

    /* access modifiers changed from: protected */
    public void b(z.a aVar) throws Exception {
        e.a("CallGalleryPreDecodeThread", "handlePicture, callGallery");
        l lVar = this.f3443b;
        if (lVar != null) {
            lVar.a(Util.f(), aVar.c, aVar.i, aVar.n, aVar.C);
        }
    }

    public void c() {
        if (this.f3450a != null) {
            this.f3450a.submit(new Runnable() {
                public void run() {
                    synchronized (a.this) {
                        if (a.this.f3443b != null) {
                            a.this.f3443b.b(Util.f());
                            l unused = a.this.f3443b = null;
                        }
                    }
                }
            });
        }
    }
}
