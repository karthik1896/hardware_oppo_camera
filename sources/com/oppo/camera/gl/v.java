package com.oppo.camera.gl;

import android.graphics.Bitmap;
import android.opengl.GLUtils;
import com.oppo.camera.util.Util;
import java.util.HashMap;

/* compiled from: UploadedTexture */
public abstract class v extends c {
    private static HashMap<a, Bitmap> h = new HashMap<>();
    private static a j = new a();
    private static int k;
    protected Bitmap i;
    private boolean l = true;
    private boolean m = false;
    private boolean n = true;
    private boolean o = false;
    private int p;

    /* access modifiers changed from: protected */
    public abstract void a(Bitmap bitmap);

    /* access modifiers changed from: protected */
    public abstract Bitmap g_();

    public int j() {
        return 3553;
    }

    protected v(boolean z) {
        super((h) null, 0, 0);
        if (z) {
            a(true);
            this.p = 1;
        }
    }

    private static Bitmap a(boolean z, Bitmap.Config config, int i2) {
        Bitmap bitmap;
        a aVar = j;
        aVar.f3323a = z;
        aVar.f3324b = config;
        aVar.c = i2;
        Bitmap bitmap2 = h.get(aVar);
        if (bitmap2 != null) {
            return bitmap2;
        }
        if (z) {
            bitmap = Util.a(1, i2, config);
        } else {
            bitmap = Util.a(i2, 1, config);
        }
        Bitmap bitmap3 = bitmap;
        h.put(aVar.clone(), bitmap3);
        return bitmap3;
    }

    public static void o() {
        k = 0;
    }

    public static boolean p() {
        return k > 100;
    }

    private Bitmap r() {
        if (this.i == null) {
            this.i = g_();
            int width = this.i.getWidth() + (this.p * 2);
            int height = this.i.getHeight() + (this.p * 2);
            if (this.f3282a == -1) {
                a(width, height);
            }
        }
        return this.i;
    }

    private void s() {
        a(this.i);
        this.i = null;
    }

    public int e() {
        if (this.f3282a == -1) {
            r();
        }
        return this.f3282a;
    }

    public int f() {
        if (this.f3282a == -1) {
            r();
        }
        return this.f3283b;
    }

    public boolean q() {
        return k() && this.l;
    }

    public void c(h hVar) {
        if (!k()) {
            if (this.o) {
                int i2 = k + 1;
                k = i2;
                if (i2 > 100) {
                    return;
                }
            }
            d(hVar);
        } else if (!this.l) {
            Bitmap r = r();
            int internalFormat = GLUtils.getInternalFormat(r);
            int type = GLUtils.getType(r);
            int i3 = this.p;
            hVar.a((c) this, i3, i3, r, internalFormat, type);
            s();
            this.l = true;
        }
    }

    private void d(h hVar) {
        boolean z;
        h hVar2 = hVar;
        Bitmap r = r();
        if (r != null) {
            try {
                int width = r.getWidth();
                int height = r.getHeight();
                int i2 = this.p;
                int i3 = this.p;
                int g = g();
                int h2 = h();
                this.c = hVar.a().b();
                hVar2.b(this);
                if (width == g && height == h2) {
                    hVar2.a((c) this, r);
                    s();
                    a(hVar);
                    this.d = 1;
                    this.l = true;
                }
                int internalFormat = GLUtils.getInternalFormat(r);
                int type = GLUtils.getType(r);
                Bitmap.Config config = r.getConfig();
                hVar2.a((c) this, internalFormat, type);
                Bitmap.Config config2 = config;
                hVar.a((c) this, this.p, this.p, r, internalFormat, type);
                if (this.p > 0) {
                    z = false;
                    hVar.a((c) this, 0, 0, a(true, config2, h2), internalFormat, type);
                    hVar.a((c) this, 0, 0, a(false, config2, g), internalFormat, type);
                } else {
                    z = false;
                }
                if (this.p + width < g) {
                    hVar.a((c) this, this.p + width, 0, a(true, config2, h2), internalFormat, type);
                }
                if (this.p + height < h2) {
                    hVar.a((c) this, 0, this.p + height, a(z, config2, g), internalFormat, type);
                }
                s();
                a(hVar);
                this.d = 1;
                this.l = true;
            } catch (Exception e) {
                e.printStackTrace();
            } catch (Throwable th) {
                s();
                throw th;
            }
        } else {
            this.d = -1;
            throw new RuntimeException("Texture load fail, no bitmap");
        }
    }

    /* access modifiers changed from: protected */
    public boolean b(h hVar) {
        c(hVar);
        return q();
    }

    public boolean n() {
        return this.n;
    }

    public void l() {
        super.l();
        if (this.i != null) {
            s();
        }
    }

    /* compiled from: UploadedTexture */
    private static class a implements Cloneable {

        /* renamed from: a  reason: collision with root package name */
        public boolean f3323a;

        /* renamed from: b  reason: collision with root package name */
        public Bitmap.Config f3324b;
        public int c;

        private a() {
        }

        public int hashCode() {
            int hashCode = this.f3324b.hashCode() ^ this.c;
            return this.f3323a ? hashCode : -hashCode;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (this.f3323a == aVar.f3323a && this.f3324b == aVar.f3324b && this.c == aVar.c) {
                return true;
            }
            return false;
        }

        /* renamed from: a */
        public a clone() {
            try {
                return (a) super.clone();
            } catch (CloneNotSupportedException e) {
                throw new AssertionError(e);
            }
        }
    }
}
