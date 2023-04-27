package com.oppo.camera.ui.preview.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.renderscript.Matrix4f;
import android.util.Size;
import com.oppo.camera.aps.adapter.ApsResult;
import com.oppo.camera.aps.config.CameraFunction;
import com.oppo.camera.e;
import com.oppo.camera.gl.GLRootView;
import com.oppo.camera.gl.b.f;
import com.oppo.camera.gl.c;
import com.oppo.camera.gl.g;
import com.oppo.camera.gl.h;
import com.oppo.camera.gl.t;
import com.oppo.camera.sticker.data.StickerItem;
import com.oppo.camera.t.a;
import com.oppo.camera.tiltshift.TiltShiftParam;
import com.oppo.camera.ui.preview.a.h;
import com.oppo.camera.ui.preview.a.n;
import com.oppo.camera.ui.preview.a.s;
import com.oppo.camera.ui.preview.a.u;
import com.oppo.camera.util.Util;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: PreviewEffectProcessImpl */
public class o implements n {

    /* renamed from: a  reason: collision with root package name */
    private volatile boolean f4413a;

    /* renamed from: b  reason: collision with root package name */
    private int f4414b;
    private int c;
    private float[] d;
    private float[] e;
    private GLRootView f;
    /* access modifiers changed from: private */
    public n.a g;
    private t h;
    private u i;
    /* access modifiers changed from: private */
    public HashMap<Integer, s> j;
    private ConcurrentHashMap<Integer, Boolean> k;
    private s.b l;

    public boolean a(h hVar, int i2, int i3, int i4, int i5) {
        return false;
    }

    public o(Context context) {
        s a2;
        int i2 = 0;
        this.f4413a = false;
        this.f4414b = 0;
        this.c = 0;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = new ConcurrentHashMap<>();
        this.l = new s.b() {
            public void a(String str) {
                if (o.this.g != null) {
                    o.this.g.b(str);
                }
            }

            public void a() {
                if (o.this.g != null) {
                    o.this.g.b();
                }
            }

            public Rect[] b() {
                if (o.this.g != null) {
                    return o.this.g.a();
                }
                return null;
            }

            public a a(int i, int i2, int i3, int i4, int i5, boolean z, long j) {
                if (o.this.g == null) {
                    return null;
                }
                o.this.g.a(i, i2, i3, i4, i5, z, j);
                return null;
            }

            public void a(a aVar) {
                if (o.this.g != null) {
                    o.this.g.a(aVar);
                }
            }

            public void a(int i, int i2, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, int i3) {
                if (o.this.g != null) {
                    o.this.g.a(i, i2, z, z2, z3, z4, z5, z6, i3);
                }
            }

            public void a(int i) {
                if (o.this.g != null) {
                    o.this.g.a(i);
                }
            }
        };
        this.j = new HashMap<>();
        while (true) {
            int i3 = (1 << i2) & 2047;
            if (!(i3 == 0 || (a2 = t.a(context.getApplicationContext(), i3)) == null)) {
                a2.a(this.l);
                this.j.put(Integer.valueOf(i3), a2);
            }
            int i4 = i2 + 1;
            if ((2047 >> i2) == 0) {
                this.i = new u();
                Matrix4f matrix4f = new Matrix4f();
                matrix4f.scale(1.0f, -1.0f, 1.0f);
                matrix4f.translate(0.0f, -1.0f, 0.0f);
                this.e = matrix4f.getArray();
                return;
            }
            i2 = i4;
        }
    }

    public void a(n.a aVar) {
        this.g = aVar;
    }

    public void a(GLRootView gLRootView) {
        this.f = gLRootView;
        for (s a2 : this.j.values()) {
            a2.a(gLRootView);
        }
    }

    public void a(t tVar) {
        this.h = tVar;
    }

    public void a(boolean z) {
        synchronized (this) {
            this.f4413a = z;
        }
    }

    public void a(h.a aVar) {
        ((h) this.j.get(2)).a(aVar);
    }

    public void a(int i2) {
        for (s d2 : this.j.values()) {
            d2.d(i2);
        }
    }

    public void a() {
        k(k());
    }

    public void a(int i2, int i3) {
        k(k());
    }

    public void f() {
        this.j.get(8).c();
    }

    public void c(final int i2) {
        c(this.f4414b, this.c);
        GLRootView gLRootView = this.f;
        if (gLRootView != null) {
            gLRootView.a((Runnable) new Runnable() {
                public void run() {
                    o.this.k(i2);
                }
            });
        }
    }

    public void d(int i2) {
        int k2 = k();
        e.a("PreviewEffectProcessImpl", "destroyEngine, type: " + i2);
        int i3 = 16;
        int i4 = 0;
        if (i2 == 0) {
            i3 = 1463;
        } else if (i2 == 1) {
            i4 = 16;
            i3 = 1462;
        } else if (i2 != 2) {
            i3 = 0;
        }
        for (Map.Entry next : this.j.entrySet()) {
            if ((((Integer) next.getKey()).intValue() & i3) != 0 && ((((Integer) next.getKey()).intValue() & i4) == 0 || (i4 & k2) != 0)) {
                ((s) next.getValue()).e();
            }
        }
    }

    public boolean a(com.oppo.camera.gl.h hVar, g gVar, int i2, int i3, int i4, int i5) {
        boolean booleanValue = this.k.containsKey(2) ? this.k.get(2).booleanValue() : false;
        boolean booleanValue2 = this.k.containsKey(4) ? this.k.get(4).booleanValue() : false;
        boolean booleanValue3 = this.k.containsKey(8) ? this.k.get(8).booleanValue() : false;
        boolean booleanValue4 = this.k.containsKey(16) ? this.k.get(16).booleanValue() : false;
        boolean booleanValue5 = this.k.containsKey(32) ? this.k.get(32).booleanValue() : false;
        boolean booleanValue6 = this.k.containsKey(1024) ? this.k.get(1024).booleanValue() : false;
        boolean a2 = this.j.get(128).a(k());
        boolean a3 = this.j.get(256).a(k());
        boolean a4 = this.j.get(512).a(k());
        s sVar = this.j.get(16);
        boolean z = sVar != null && sVar.a();
        if (booleanValue4 && z) {
            f(hVar, i2, i3, i4, i5, this.e);
            return true;
        } else if (booleanValue3) {
            c(hVar, i2, i3, i4, i5, this.e);
            return true;
        } else if (a2) {
            return a(hVar, gVar, this.e, this.d, i2, i3, i4, i5, booleanValue5, booleanValue, booleanValue2, a3, a4, booleanValue6);
        } else if (booleanValue) {
            d(hVar, i2, i3, i4, i5, this.d);
            return true;
        } else if (booleanValue5) {
            return g(hVar, i2, i3, i4, i5, this.d);
        } else if (a4) {
            return h(hVar, i2, i3, i4, i5, this.d);
        } else if (booleanValue2 && !a3) {
            a(hVar, i2, i3, i4, i5, this.d);
            return true;
        } else if (a3) {
            return i(hVar, i2, i3, i4, i5, this.d);
        } else if (!booleanValue6) {
            return false;
        } else {
            return k(hVar, i2, i3, i4, i5, this.d);
        }
    }

    public boolean a(com.oppo.camera.gl.h hVar, f fVar, com.oppo.camera.gl.s sVar, int i2, int i3, int i4, int i5) {
        if (!this.j.get(128).a(k())) {
            return false;
        }
        return a(hVar, sVar, this.d, i2, i3, i4, i5);
    }

    public s i(int i2) {
        return this.j.get(Integer.valueOf(i2));
    }

    public boolean a(com.oppo.camera.gl.h hVar, g gVar, int i2, int i3, int i4, int i5, int i6, ApsResult.ImageBuffer imageBuffer) {
        boolean z;
        int k2 = k();
        boolean a2 = this.j.get(1).c_(k2) ? this.j.get(1).a(k2) : false;
        boolean a3 = this.j.get(2).c_(k2) ? this.j.get(2).a(k2) : false;
        boolean a4 = this.j.get(4).c_(k2) ? this.j.get(4).a(k2) : false;
        boolean a5 = (this.j.get(8) == null || !this.j.get(8).c_(k2)) ? false : this.j.get(8).a(k2);
        boolean a6 = (this.j.get(16) == null || !this.j.get(16).c_(k2)) ? false : this.j.get(16).a(k2);
        boolean a7 = this.j.get(32).c_(k2) ? this.j.get(32).a(k2) : false;
        boolean a8 = this.j.get(512).c_(k2) ? this.j.get(512).a(k2) : false;
        boolean a9 = (this.j.get(64) == null || !this.j.get(64).c_(k2)) ? false : this.j.get(64).a(k2);
        boolean a10 = this.j.get(256).c_(k2) ? this.j.get(256).a(k2) : false;
        boolean a11 = this.j.get(1024).c_(k2) ? this.j.get(1024).a(k2) : false;
        this.k.put(2, Boolean.valueOf(a3));
        this.k.put(4, Boolean.valueOf(a4));
        this.k.put(8, Boolean.valueOf(a5));
        this.k.put(16, Boolean.valueOf(a6));
        this.k.put(32, Boolean.valueOf(a7));
        this.k.put(512, Boolean.valueOf(a8));
        if (!a11 && !a2 && !a3 && !a5 && !a6 && !a4 && !a7 && !a9 && !a10 && !a8) {
            return false;
        }
        if (a11) {
            z = a(hVar, gVar, i2, i3, i4, i5, this.e, imageBuffer);
        } else if (a6) {
            z = b(hVar, i2, i3, i4, i5, this.e);
        } else if (a2 && !a3 && !a5 && !a4) {
            z = a(hVar, gVar, i2, i3, i4, i5, this.e);
        } else if (a2 && !a3 && a5) {
            z = d(hVar, gVar, i2, i3, i4, i5, this.e);
        } else if (a2 && a3 && !a5 && !a4) {
            z = h(hVar, gVar, i2, i3, i4, i5, this.e);
        } else if (a2 && a3 && a5) {
            z = e(hVar, gVar, i2, i3, i4, i5, this.e);
        } else if (a2 && !a3 && !a5 && a4) {
            z = b(hVar, gVar, i2, i3, i4, i5, this.e, i6);
        } else if (a2 && a3 && !a5 && a4) {
            z = c(hVar, gVar, i2, i3, i4, i5, this.e, i6);
        } else if (!a2 && a3 && !a5 && !a4 && !a7 && !a8) {
            z = c(hVar, gVar, i2, i3, i4, i5, this.e);
        } else if (!a2 && a3 && a5 && !a4) {
            z = f(hVar, gVar, i2, i3, i4, i5, this.e);
        } else if (!a2 && !a3 && a5 && !a4) {
            z = g(hVar, gVar, i2, i3, i4, i5, this.e);
        } else if (!a2 && !a8 && !a3 && !a5 && a4 && !a7 && !a10) {
            z = a(hVar, gVar, i2, i3, i4, i5, this.e, i6);
        } else if (!a2 && a3 && !a5 && a4 && !a7 && !a8) {
            z = d(hVar, gVar, i2, i3, i4, i5, this.e, i6);
        } else if (!a2 && !a3 && a5 && a4) {
            z = e(hVar, gVar, i2, i3, i4, i5, this.e, i6);
        } else if (!a2 && a3 && a5 && a4) {
            z = f(hVar, gVar, i2, i3, i4, i5, this.e, i6);
        } else if (a8 && !a3 && !a4) {
            z = k(hVar, gVar, i2, i3, i4, i5, this.e);
        } else if (a8 && a3 && !a4) {
            z = l(hVar, gVar, i2, i3, i4, i5, this.e);
        } else if (a8 && !a3 && a4) {
            z = h(hVar, gVar, i2, i3, i4, i5, this.e, i6);
        } else if (a8 && a3 && a4) {
            z = j(hVar, gVar, i2, i3, i4, i5, this.e, i6);
        } else if (a7 && !a3 && !a4) {
            z = j(hVar, gVar, i2, i3, i4, i5, this.e);
        } else if (a7 && a3 && !a4) {
            z = m(hVar, gVar, i2, i3, i4, i5, this.e);
        } else if (a7 && !a3 && a4) {
            z = g(hVar, gVar, i2, i3, i4, i5, this.e, i6);
        } else if (a7 && a3 && a4) {
            z = i(hVar, gVar, i2, i3, i4, i5, this.e, i6);
        } else if (a9) {
            z = b(hVar, gVar, i2, i3, i4, i5, this.e);
        } else if (!a10 || a7 || a4) {
            z = (!a10 || a7 || !a4) ? false : k(hVar, gVar, i2, i3, i4, i5, this.e, i6);
        } else {
            z = n(hVar, gVar, i2, i3, i4, i5, this.e);
        }
        if (z) {
            return true;
        }
        hVar.a((c) gVar, this.d, i2, i3, i4, i5);
        return true;
    }

    public boolean a(com.oppo.camera.gl.h hVar, g gVar, int i2, int i3, int i4, int i5, int i6) {
        int k2 = k();
        if (!(this.j.get(4).c_(k2) ? this.j.get(4).a(k2) : false)) {
            return false;
        }
        return a(hVar, gVar, i2, i3, i4, i5, this.e, i6);
    }

    public boolean a(com.oppo.camera.gl.h hVar, g gVar, com.oppo.camera.gl.s sVar) {
        boolean a2 = this.j.get(2).a(k());
        boolean a3 = this.j.get(4).a(k());
        boolean a4 = this.j.get(1).a(k());
        boolean a5 = this.j.get(8).a(k());
        if (this.j.get(16).a(k()) && this.j.get(16) != null) {
            a(hVar, (c) this.j.get(16).g(), sVar, this.e);
        } else if (a5 && this.j.get(8) != null) {
            a(hVar, (c) this.j.get(8).g(), sVar, this.e, !Util.p());
        } else if (a2 && this.j.get(2) != null) {
            a(hVar, (c) this.j.get(2).g(), sVar, (float[]) null);
        } else if (a4 && this.j.get(1) != null) {
            a(hVar, (c) this.j.get(1).g(), sVar, (float[]) null);
        } else if (!a3 || this.j.get(4) == null) {
            a(hVar, (c) gVar, sVar, (float[]) null);
        } else {
            a(hVar, (c) this.j.get(4).g(), sVar, (float[]) null);
        }
        return true;
    }

    public void b() {
        if (this.j.get(8) != null) {
            this.j.get(8).l();
        }
    }

    public void c() {
        if (this.j.get(8) != null) {
            this.j.get(8).m();
        }
    }

    public boolean e() {
        return this.j.get(8).a(k()) || this.j.get(16).a(k());
    }

    public boolean d() {
        if (this.j.get(8) != null) {
            if (this.j.get(8).a(k())) {
                this.j.get(8).h();
            } else {
                this.j.get(8).n();
            }
        }
        if (this.j.get(16) == null) {
            return false;
        }
        if (u()) {
            this.j.get(16).a(this.i);
            this.j.get(16).h();
            return false;
        }
        this.j.get(16).e();
        return false;
    }

    public void a(Size size, boolean z) {
        for (s next : this.j.values()) {
            int k2 = k();
            if (next.c_(k2) && next.a(k2)) {
                next.a(size, z);
            }
        }
    }

    public void a(long j2) {
        for (s next : this.j.values()) {
            int k2 = k();
            if (next.c_(k2) && next.a(k2)) {
                next.a(j2);
            }
        }
    }

    public boolean a(byte[] bArr, int i2, int i3, int i4) {
        s sVar = this.j.get(Integer.valueOf(i4));
        if (sVar == null || !sVar.a(i4)) {
            return false;
        }
        sVar.a(bArr, i2, i3);
        return true;
    }

    public void g() {
        this.k.clear();
        GLRootView gLRootView = this.f;
        if (gLRootView != null) {
            gLRootView.a((Runnable) new Runnable() {
                public void run() {
                    for (s j : o.this.j.values()) {
                        j.j();
                    }
                }
            });
        }
    }

    public void h() {
        GLRootView gLRootView = this.f;
        if (gLRootView != null) {
            gLRootView.a((Runnable) new Runnable() {
                public void run() {
                    e.a("PreviewEffectProcessImpl", "onDestroy");
                    for (s b2 : o.this.j.values()) {
                        b2.b();
                    }
                }
            });
            this.f = null;
        }
    }

    public void i() {
        if (this.f != null) {
            this.f = null;
        }
        HashMap<Integer, s> hashMap = this.j;
        if (hashMap != null) {
            for (s next : hashMap.values()) {
                next.a((GLRootView) null);
                next.q();
            }
        }
    }

    public void b(int i2, int i3) {
        this.f4414b = i2;
        this.c = i3;
        c(i2, i3);
    }

    public void e(int i2) {
        for (s b2 : this.j.values()) {
            b2.b(i2);
        }
    }

    public void f(int i2) {
        for (s e2 : this.j.values()) {
            e2.e(i2);
        }
    }

    public void a(byte[] bArr) {
        u uVar = this.i;
        if (uVar != null) {
            uVar.a(bArr);
        }
    }

    public void b(long j2) {
        u uVar = this.i;
        if (uVar != null) {
            uVar.a(j2);
        }
    }

    public void a(float[] fArr) {
        this.d = fArr;
    }

    public void g(int i2) {
        u uVar = this.i;
        if (uVar != null) {
            uVar.b(i2);
        }
    }

    public void a(u.b bVar) {
        u uVar = this.i;
        if (uVar != null) {
            uVar.a(bVar);
        }
    }

    public void a(String str) {
        u uVar = this.i;
        if (uVar != null) {
            uVar.a(str);
        }
    }

    public void b(boolean z) {
        u uVar = this.i;
        if (uVar != null) {
            uVar.d(z);
        }
    }

    public void c(boolean z) {
        u uVar = this.i;
        if (uVar != null) {
            uVar.e(z);
        }
    }

    public void h(int i2) {
        u uVar = this.i;
        if (uVar != null) {
            uVar.a(i2);
        }
    }

    public void a(float f2) {
        u uVar = this.i;
        if (uVar != null) {
            uVar.a(f2);
        }
    }

    public void b(float f2) {
        u uVar = this.i;
        if (uVar != null) {
            uVar.b(f2);
        }
    }

    public void d(boolean z) {
        u uVar = this.i;
        if (uVar != null) {
            uVar.b(z);
        }
    }

    public void c(float f2) {
        u uVar = this.i;
        if (uVar != null) {
            uVar.c(f2);
        }
    }

    public void a(TiltShiftParam tiltShiftParam) {
        u uVar = this.i;
        if (uVar != null) {
            uVar.a(tiltShiftParam);
        }
    }

    public void a(StickerItem stickerItem) {
        u uVar = this.i;
        if (uVar != null) {
            uVar.a(stickerItem);
        }
    }

    public void a(int[] iArr) {
        u uVar = this.i;
        if (uVar != null) {
            uVar.a(iArr);
        }
    }

    public void a(Bitmap bitmap) {
        u uVar = this.i;
        if (uVar != null) {
            uVar.a(bitmap);
        }
    }

    public void e(boolean z) {
        u uVar = this.i;
        if (uVar != null) {
            uVar.g(z);
        }
    }

    public void f(boolean z) {
        u uVar = this.i;
        if (uVar != null) {
            uVar.h(z);
        }
    }

    public StickerItem j() {
        u uVar = this.i;
        if (uVar != null) {
            return uVar.j();
        }
        return null;
    }

    public boolean s() {
        u uVar = this.i;
        if (uVar != null) {
            return uVar.m();
        }
        return true;
    }

    public boolean b(StickerItem stickerItem) {
        if (j() == null || stickerItem == null || stickerItem.getStickerUUID() == null) {
            return false;
        }
        return stickerItem.getStickerUUID().equals(j().getStickerUUID());
    }

    public boolean t() {
        return j() != null;
    }

    public void g(boolean z) {
        u uVar = this.i;
        if (uVar != null) {
            uVar.a(z);
        }
    }

    public void i(boolean z) {
        u uVar = this.i;
        if (uVar != null) {
            uVar.c(z);
        }
    }

    public void b(int i2) {
        u uVar = this.i;
        if (uVar != null) {
            uVar.c(i2);
        }
    }

    public void a(Point point) {
        u uVar = this.i;
        if (uVar != null) {
            uVar.a(point);
        }
    }

    public void h(boolean z) {
        u uVar = this.i;
        if (uVar != null) {
            uVar.f(z);
        }
    }

    public int k() {
        n.a aVar = this.g;
        int i2 = 0;
        if (aVar == null) {
            return 0;
        }
        if (aVar.a(CameraFunction.FACE_BLUR)) {
            i2 = 1;
        }
        if (this.g.a("pref_filter_process_key")) {
            i2 |= 2;
        }
        if (this.g.a("pref_sticker_process_key")) {
            i2 |= 8;
        }
        if (this.g.a("pref_omoji_process_key")) {
            i2 |= 16;
        }
        if (this.g.a(CameraFunction.FACE_SLENDER_PROCESS)) {
            i2 |= 4;
        }
        if (this.g.a(CameraFunction.VIDEO_BLUR_PROCESS)) {
            i2 |= 32;
        }
        if (this.g.a(CameraFunction.SUPER_TEXT_GPU_PROCESS)) {
            i2 |= 64;
        }
        if (this.g.a("pref_camera_video_slogan_key")) {
            i2 |= 128;
        }
        if (this.g.a(CameraFunction.VIDEO_RETENTION)) {
            i2 |= 256;
        }
        if (this.g.a(CameraFunction.TILT_SHIFT)) {
            i2 |= 512;
        }
        return this.g.a(CameraFunction.DOUBLE_EXPOSURE) ? i2 | 1024 : i2;
    }

    public void j(boolean z) {
        u uVar = this.i;
        if (uVar != null) {
            uVar.i(z);
        }
    }

    public void d(float f2) {
        u uVar = this.i;
        if (uVar != null) {
            uVar.d(f2);
        }
    }

    public boolean l() {
        u uVar = this.i;
        if (uVar != null) {
            return uVar.w();
        }
        return false;
    }

    public void a(com.oppo.camera.doubleexposure.c cVar) {
        if (this.j.get(1024) != null) {
            this.j.get(1024).a(cVar);
        }
    }

    public void o() {
        if (this.j.get(1024) != null) {
            this.j.get(1024).s();
        }
    }

    public void p() {
        if (this.j.get(1024) != null) {
            this.j.get(1024).t();
        }
    }

    public void q() {
        if (this.j.get(1024) != null) {
            this.j.get(1024).u();
        }
    }

    public void r() {
        if (this.j.get(1024) != null) {
            this.j.get(1024).v();
        }
    }

    public void j(int i2) {
        u uVar = this.i;
        if (uVar != null) {
            uVar.d(i2);
        }
    }

    public float m() {
        u uVar = this.i;
        if (uVar != null) {
            return uVar.x();
        }
        return 1.0f;
    }

    public float n() {
        u uVar = this.i;
        if (uVar != null) {
            return uVar.y();
        }
        return 1.0f;
    }

    private boolean u() {
        return s() && t() && 2 == j().getMaterialType();
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001b, code lost:
        com.oppo.camera.e.a("PreviewEffectProcessImpl", "onlyCreateEngines, effectFlag: " + r7);
        r0 = java.lang.System.currentTimeMillis();
        r2 = r6.j.entrySet().iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0045, code lost:
        if (r2.hasNext() == false) goto L_0x0076;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0047, code lost:
        r3 = r2.next();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0058, code lost:
        if ((16 & ((java.lang.Integer) r3.getKey()).intValue()) != 0) goto L_0x003f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0064, code lost:
        if (((com.oppo.camera.ui.preview.a.s) r3.getValue()).c_(r7) == false) goto L_0x003f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0068, code lost:
        if (r6.i == null) goto L_0x003f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x006a, code lost:
        ((com.oppo.camera.ui.preview.a.s) r3.getValue()).a(r6.i);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0080, code lost:
        if (r6.j.get(16) == null) goto L_0x00b0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0084, code lost:
        if (r6.i == null) goto L_0x00b0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0087, code lost:
        if ((r7 & 16) == 0) goto L_0x00a1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x008d, code lost:
        if (u() == false) goto L_0x00a1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x008f, code lost:
        r6.j.get(16).a(r6.i);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00a1, code lost:
        r6.j.get(16).e();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00b0, code lost:
        com.oppo.camera.e.a("PreviewEffectProcessImpl", "onlyCreateEngines, cost time: " + (java.lang.System.currentTimeMillis() - r0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00cb, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void k(int r7) {
        /*
            r6 = this;
            com.oppo.camera.gl.GLRootView r0 = r6.f
            if (r0 == 0) goto L_0x00cf
            boolean r0 = r0.getSurfaceState()
            if (r0 != 0) goto L_0x000c
            goto L_0x00cf
        L_0x000c:
            monitor-enter(r6)
            boolean r0 = r6.f4413a     // Catch:{ all -> 0x00cc }
            if (r0 != 0) goto L_0x001a
            java.lang.String r7 = "PreviewEffectProcessImpl"
            java.lang.String r0 = "onlyCreateEngines, texture has been released"
            com.oppo.camera.e.a(r7, r0)     // Catch:{ all -> 0x00cc }
            monitor-exit(r6)     // Catch:{ all -> 0x00cc }
            return
        L_0x001a:
            monitor-exit(r6)     // Catch:{ all -> 0x00cc }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "onlyCreateEngines, effectFlag: "
            r0.append(r1)
            r0.append(r7)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "PreviewEffectProcessImpl"
            com.oppo.camera.e.a(r1, r0)
            long r0 = java.lang.System.currentTimeMillis()
            java.util.HashMap<java.lang.Integer, com.oppo.camera.ui.preview.a.s> r2 = r6.j
            java.util.Set r2 = r2.entrySet()
            java.util.Iterator r2 = r2.iterator()
        L_0x003f:
            boolean r3 = r2.hasNext()
            r4 = 16
            if (r3 == 0) goto L_0x0076
            java.lang.Object r3 = r2.next()
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3
            java.lang.Object r5 = r3.getKey()
            java.lang.Integer r5 = (java.lang.Integer) r5
            int r5 = r5.intValue()
            r4 = r4 & r5
            if (r4 != 0) goto L_0x003f
            java.lang.Object r4 = r3.getValue()
            com.oppo.camera.ui.preview.a.s r4 = (com.oppo.camera.ui.preview.a.s) r4
            boolean r4 = r4.c_(r7)
            if (r4 == 0) goto L_0x003f
            com.oppo.camera.ui.preview.a.u r4 = r6.i
            if (r4 == 0) goto L_0x003f
            java.lang.Object r3 = r3.getValue()
            com.oppo.camera.ui.preview.a.s r3 = (com.oppo.camera.ui.preview.a.s) r3
            com.oppo.camera.ui.preview.a.u r4 = r6.i
            r3.a((com.oppo.camera.ui.preview.a.u) r4)
            goto L_0x003f
        L_0x0076:
            java.util.HashMap<java.lang.Integer, com.oppo.camera.ui.preview.a.s> r2 = r6.j
            java.lang.Integer r3 = java.lang.Integer.valueOf(r4)
            java.lang.Object r2 = r2.get(r3)
            if (r2 == 0) goto L_0x00b0
            com.oppo.camera.ui.preview.a.u r2 = r6.i
            if (r2 == 0) goto L_0x00b0
            r7 = r7 & r4
            if (r7 == 0) goto L_0x00a1
            boolean r7 = r6.u()
            if (r7 == 0) goto L_0x00a1
            java.util.HashMap<java.lang.Integer, com.oppo.camera.ui.preview.a.s> r7 = r6.j
            java.lang.Integer r2 = java.lang.Integer.valueOf(r4)
            java.lang.Object r7 = r7.get(r2)
            com.oppo.camera.ui.preview.a.s r7 = (com.oppo.camera.ui.preview.a.s) r7
            com.oppo.camera.ui.preview.a.u r2 = r6.i
            r7.a((com.oppo.camera.ui.preview.a.u) r2)
            goto L_0x00b0
        L_0x00a1:
            java.util.HashMap<java.lang.Integer, com.oppo.camera.ui.preview.a.s> r7 = r6.j
            java.lang.Integer r2 = java.lang.Integer.valueOf(r4)
            java.lang.Object r7 = r7.get(r2)
            com.oppo.camera.ui.preview.a.s r7 = (com.oppo.camera.ui.preview.a.s) r7
            r7.e()
        L_0x00b0:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r2 = "onlyCreateEngines, cost time: "
            r7.append(r2)
            long r2 = java.lang.System.currentTimeMillis()
            long r2 = r2 - r0
            r7.append(r2)
            java.lang.String r7 = r7.toString()
            java.lang.String r0 = "PreviewEffectProcessImpl"
            com.oppo.camera.e.a(r0, r7)
            return
        L_0x00cc:
            r7 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x00cc }
            throw r7
        L_0x00cf:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r0 = "onlyCreateEngines, mGLRootView: "
            r7.append(r0)
            com.oppo.camera.gl.GLRootView r0 = r6.f
            r7.append(r0)
            java.lang.String r7 = r7.toString()
            java.lang.String r0 = "PreviewEffectProcessImpl"
            com.oppo.camera.e.e(r0, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.ui.preview.a.o.k(int):void");
    }

    private void c(int i2, int i3) {
        long currentTimeMillis = System.currentTimeMillis();
        d(i2, i3);
        w();
        v();
        e.a("PreviewEffectProcessImpl", "updateTextureRes, cost time: " + (System.currentTimeMillis() - currentTimeMillis));
    }

    private void d(int i2, int i3) {
        for (s next : this.j.values()) {
            if (next.c_(k())) {
                next.a(i2, i3);
            }
        }
    }

    private void v() {
        GLRootView gLRootView = this.f;
        if (gLRootView != null) {
            gLRootView.a((Runnable) new Runnable() {
                public void run() {
                    for (s sVar : o.this.j.values()) {
                        if (sVar.c_(o.this.k())) {
                            sVar.a(true);
                        }
                    }
                }
            });
        }
    }

    private void w() {
        GLRootView gLRootView = this.f;
        if (gLRootView != null) {
            gLRootView.a((Runnable) new Runnable() {
                public void run() {
                    for (s sVar : o.this.j.values()) {
                        if (sVar.c_(o.this.k())) {
                            sVar.j();
                            sVar.i();
                        }
                    }
                }
            });
        }
    }

    private void a(com.oppo.camera.gl.h hVar, c cVar, com.oppo.camera.gl.s sVar, float[] fArr) {
        a(hVar, cVar, sVar, fArr, false);
    }

    private void a(com.oppo.camera.gl.h hVar, c cVar, com.oppo.camera.gl.s sVar, float[] fArr, boolean z) {
        if (sVar != null) {
            int e2 = sVar.e();
            int f2 = sVar.f();
            hVar.a(sVar);
            if (z) {
                GLES20.glFinish();
            }
            hVar.a(0.0f, (float) f2);
            hVar.a(1.0f, -1.0f, 1.0f);
            this.h.a(this.d);
            if (fArr == null) {
                fArr = this.d;
            }
            hVar.a(cVar, fArr, 0, 0, e2, f2);
            hVar.h();
        }
    }

    private boolean a(com.oppo.camera.gl.h hVar, g gVar, int i2, int i3, int i4, int i5, float[] fArr) {
        this.j.get(1).a(hVar);
        boolean a2 = a(hVar, gVar, fArr, false);
        if (a2) {
            e(hVar, i2, i3, i4, i5, this.d);
        }
        return a2;
    }

    private boolean b(com.oppo.camera.gl.h hVar, g gVar, int i2, int i3, int i4, int i5, float[] fArr) {
        this.j.get(64).a(hVar);
        this.h.j();
        this.h.a(this.d);
        return i(hVar, gVar, i2, i3, i4, i5, fArr);
    }

    private boolean c(com.oppo.camera.gl.h hVar, g gVar, int i2, int i3, int i4, int i5, float[] fArr) {
        this.j.get(2).a(hVar);
        boolean a2 = a(hVar, gVar, false, false, fArr, (com.oppo.camera.gl.s) null);
        if (a2) {
            d(hVar, i2, i3, i4, i5, this.d);
        }
        return a2;
    }

    private boolean a(com.oppo.camera.gl.h hVar, g gVar, int i2, int i3, int i4, int i5, float[] fArr, int i6) {
        this.j.get(4).a(hVar);
        boolean a2 = a(hVar, gVar, fArr, i6);
        if (a2) {
            a(hVar, i2, i3, i4, i5, this.d);
        }
        return a2;
    }

    private void a(com.oppo.camera.gl.h hVar, int i2, int i3, int i4, int i5, float[] fArr) {
        hVar.a((c) this.j.get(4).g(), fArr, i2, i3, i4, i5);
    }

    private boolean a(com.oppo.camera.gl.h hVar, g gVar, float[] fArr, float[] fArr2, int i2, int i3, int i4, int i5, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
        this.j.get(128).a(hVar);
        s.a r = this.j.get(128).r();
        r.f4427a = hVar;
        r.c = this.j.get(128).f();
        r.f4428b = gVar;
        r.h = fArr2;
        r.i = i4;
        r.j = i5;
        r.k = i2;
        r.l = i3;
        if (z2) {
            r.c = this.j.get(2).g();
        } else if (z && Float.compare(this.i.f(), 0.0f) != 0) {
            r.c = this.j.get(32).g();
        } else if (z4) {
            r.c = this.j.get(256).g();
        } else if (z5) {
            r.c = this.j.get(512).g();
        } else if (z3) {
            r.c = this.j.get(4).g();
        } else if (z6) {
            r.c = this.j.get(1024).g();
        } else {
            float[] fArr3 = fArr;
            a(hVar, (c) gVar, this.j.get(128).f(), fArr);
        }
        return this.j.get(128).a(r);
    }

    private boolean a(com.oppo.camera.gl.h hVar, com.oppo.camera.gl.s sVar, float[] fArr, int i2, int i3, int i4, int i5) {
        this.j.get(128).a(hVar);
        s.a r = this.j.get(128).r();
        r.f4427a = hVar;
        r.c = sVar;
        Matrix.setIdentityM(fArr, 0);
        r.h = fArr;
        r.i = i4;
        r.j = i5;
        r.k = i2;
        r.l = i3;
        return this.j.get(128).a(r);
    }

    private boolean a(com.oppo.camera.gl.h hVar, g gVar, float[] fArr, int i2) {
        a(hVar, (c) gVar, this.j.get(4).f(), fArr);
        s.a r = this.j.get(4).r();
        r.c = this.j.get(4).f();
        r.m = i2;
        return this.j.get(4).a(r);
    }

    private boolean b(com.oppo.camera.gl.h hVar, int i2, int i3, int i4, int i5, float[] fArr) {
        boolean a2 = a(hVar, i4, i5, fArr);
        if (a2) {
            f(hVar, i2, i3, i4, i5, this.e);
        }
        return a2;
    }

    private void c(com.oppo.camera.gl.h hVar, int i2, int i3, int i4, int i5, float[] fArr) {
        hVar.a((c) this.j.get(8).g(), fArr, i2, i3, i4, i5);
    }

    private boolean a(com.oppo.camera.gl.h hVar, g gVar, boolean z, boolean z2, boolean z3) {
        s.a r = this.j.get(8).r();
        r.f4427a = hVar;
        r.c = this.j.get(8).f();
        if (z2) {
            a(hVar, (c) this.j.get(2).g(), this.j.get(8).f(), (float[]) null);
            return this.j.get(8).a(r);
        } else if (z) {
            a(hVar, (c) this.j.get(1).g(), this.j.get(8).f(), (float[]) null);
            return this.j.get(8).a(r);
        } else if (z3) {
            a(hVar, (c) this.j.get(4).g(), this.j.get(8).f(), (float[]) null);
            return this.j.get(8).a(r);
        } else {
            a(hVar, (c) gVar, this.j.get(8).f(), (float[]) null);
            return this.j.get(8).a(r);
        }
    }

    private boolean d(com.oppo.camera.gl.h hVar, g gVar, int i2, int i3, int i4, int i5, float[] fArr) {
        com.oppo.camera.gl.h hVar2 = hVar;
        this.j.get(1).a(hVar);
        this.j.get(8).a(hVar);
        boolean a2 = a(hVar, gVar, fArr, false);
        boolean a3 = a(hVar, gVar, a2, false, false);
        if (a3) {
            c(hVar, i2, i3, i4, i5, fArr);
        } else if (a2) {
            e(hVar, i2, i3, i4, i5, fArr);
        }
        if (a3 || a2) {
            return true;
        }
        return false;
    }

    private boolean e(com.oppo.camera.gl.h hVar, g gVar, int i2, int i3, int i4, int i5, float[] fArr) {
        com.oppo.camera.gl.h hVar2 = hVar;
        this.j.get(1).a(hVar2);
        this.j.get(2).a(hVar2);
        this.j.get(8).a(hVar2);
        boolean a2 = a(hVar2, gVar, fArr, false);
        com.oppo.camera.gl.h hVar3 = hVar;
        g gVar2 = gVar;
        boolean z = a2;
        boolean a3 = a(hVar3, gVar2, z, false, fArr, this.j.get(1).g());
        boolean a4 = a(hVar3, gVar2, z, a3, false);
        if (a4) {
            c(hVar, i2, i3, i4, i5, fArr);
        } else if (a3) {
            d(hVar, i2, i3, i4, i5, this.d);
        } else if (a2) {
            e(hVar, i2, i3, i4, i5, fArr);
        }
        if (a4 || a3 || a2) {
            return true;
        }
        return false;
    }

    private boolean f(com.oppo.camera.gl.h hVar, g gVar, int i2, int i3, int i4, int i5, float[] fArr) {
        com.oppo.camera.gl.h hVar2 = hVar;
        this.j.get(2).a(hVar);
        this.j.get(8).a(hVar);
        com.oppo.camera.gl.h hVar3 = hVar;
        g gVar2 = gVar;
        boolean a2 = a(hVar3, gVar2, false, false, fArr, (com.oppo.camera.gl.s) null);
        boolean a3 = a(hVar3, gVar2, false, a2, false);
        if (a3) {
            c(hVar, i2, i3, i4, i5, fArr);
        } else if (a2) {
            d(hVar, i2, i3, i4, i5, this.d);
        }
        return a3 || a2;
    }

    private boolean g(com.oppo.camera.gl.h hVar, g gVar, int i2, int i3, int i4, int i5, float[] fArr) {
        this.j.get(8).a(hVar);
        boolean a2 = a(hVar, gVar, false, false, false);
        if (a2) {
            c(hVar, i2, i3, i4, i5, fArr);
        }
        return a2;
    }

    private boolean b(com.oppo.camera.gl.h hVar, g gVar, int i2, int i3, int i4, int i5, float[] fArr, int i6) {
        com.oppo.camera.gl.h hVar2 = hVar;
        g gVar2 = gVar;
        float[] fArr2 = fArr;
        this.j.get(4).a(hVar);
        this.j.get(1).a(hVar);
        boolean a2 = a(hVar, gVar, fArr2, i6);
        boolean a3 = a(hVar, gVar, fArr2, a2);
        if (a3) {
            e(hVar, i2, i3, i4, i5, this.d);
        } else if (a2) {
            a(hVar, i2, i3, i4, i5, this.d);
        }
        if (a3 || a2) {
            return true;
        }
        return false;
    }

    private boolean c(com.oppo.camera.gl.h hVar, g gVar, int i2, int i3, int i4, int i5, float[] fArr, int i6) {
        com.oppo.camera.gl.h hVar2 = hVar;
        float[] fArr2 = fArr;
        this.j.get(4).a(hVar);
        this.j.get(1).a(hVar);
        this.j.get(2).a(hVar);
        boolean a2 = a(hVar, gVar, fArr2, i6);
        boolean a3 = a(hVar, gVar, fArr2, a2);
        com.oppo.camera.gl.h hVar3 = hVar;
        boolean a4 = a(hVar3, gVar, a3, false, fArr2, this.j.get(1).g());
        if (a4) {
            d(hVar, i2, i3, i4, i5, this.d);
        } else if (a3) {
            e(hVar, i2, i3, i4, i5, this.d);
        } else if (a2) {
            a(hVar, i2, i3, i4, i5, this.d);
        }
        if (a4 || a3 || a2) {
            return true;
        }
        return false;
    }

    private boolean d(com.oppo.camera.gl.h hVar, g gVar, int i2, int i3, int i4, int i5, float[] fArr, int i6) {
        com.oppo.camera.gl.h hVar2 = hVar;
        this.j.get(4).a(hVar);
        this.j.get(2).a(hVar);
        float[] fArr2 = fArr;
        boolean a2 = a(hVar, gVar, fArr2, i6);
        boolean a3 = a(hVar, gVar, false, a2, fArr2, (com.oppo.camera.gl.s) null);
        if (a3) {
            d(hVar, i2, i3, i4, i5, this.d);
        } else if (a2) {
            a(hVar, i2, i3, i4, i5, this.d);
        }
        return a3 || a2;
    }

    private boolean e(com.oppo.camera.gl.h hVar, g gVar, int i2, int i3, int i4, int i5, float[] fArr, int i6) {
        com.oppo.camera.gl.h hVar2 = hVar;
        this.j.get(4).a(hVar);
        this.j.get(8).a(hVar);
        this.h.j();
        this.h.a(this.d);
        boolean a2 = a(hVar, gVar, fArr, i6);
        boolean a3 = a(hVar, gVar, false, false, a2);
        if (a3) {
            c(hVar, i2, i3, i4, i5, fArr);
        } else if (a2) {
            a(hVar, i2, i3, i4, i5, this.d);
        }
        return a3 || a2;
    }

    private boolean f(com.oppo.camera.gl.h hVar, g gVar, int i2, int i3, int i4, int i5, float[] fArr, int i6) {
        com.oppo.camera.gl.h hVar2 = hVar;
        this.j.get(4).a(hVar);
        this.j.get(2).a(hVar);
        this.j.get(8).a(hVar);
        this.h.j();
        this.h.a(this.d);
        g gVar2 = gVar;
        boolean a2 = a(hVar, gVar, fArr, i6);
        com.oppo.camera.gl.h hVar3 = hVar;
        g gVar3 = gVar;
        boolean a3 = a(hVar3, gVar3, false, a2, fArr, (com.oppo.camera.gl.s) null);
        boolean a4 = a(hVar3, gVar3, false, a3, a2);
        if (a4) {
            c(hVar, i2, i3, i4, i5, fArr);
        } else if (a3) {
            d(hVar, i2, i3, i4, i5, this.d);
        } else if (a2) {
            a(hVar, i2, i3, i4, i5, this.d);
        }
        return a4 || a3 || a2;
    }

    private boolean h(com.oppo.camera.gl.h hVar, g gVar, int i2, int i3, int i4, int i5, float[] fArr) {
        com.oppo.camera.gl.h hVar2 = hVar;
        this.j.get(1).a(hVar);
        this.j.get(2).a(hVar);
        float[] fArr2 = fArr;
        boolean a2 = a(hVar, gVar, fArr2, false);
        com.oppo.camera.gl.h hVar3 = hVar;
        boolean a3 = a(hVar3, gVar, a2, false, fArr2, this.j.get(1).g());
        if (a3) {
            d(hVar, i2, i3, i4, i5, this.d);
        } else if (a2) {
            e(hVar, i2, i3, i4, i5, this.d);
        }
        if (a3 || a2) {
            return true;
        }
        return false;
    }

    private boolean i(com.oppo.camera.gl.h hVar, g gVar, int i2, int i3, int i4, int i5, float[] fArr) {
        s.a r = this.j.get(64).r();
        r.f4427a = hVar;
        r.i = i4;
        r.j = i5;
        r.f4428b = gVar;
        return this.j.get(64).a(r);
    }

    private boolean a(com.oppo.camera.gl.h hVar, g gVar, float[] fArr, boolean z) {
        s.a r = this.j.get(1).r();
        r.f4427a = hVar;
        if (z) {
            r.c = this.j.get(4).g();
            return this.j.get(1).a(r);
        }
        a(hVar, (c) gVar, this.j.get(1).f(), fArr);
        r.c = this.j.get(1).f();
        return this.j.get(1).a(r);
    }

    private boolean b(com.oppo.camera.gl.h hVar, g gVar, float[] fArr, boolean z) {
        s.a r = this.j.get(512).r();
        r.f4427a = hVar;
        if (z) {
            r.c = this.j.get(4).g();
            return this.j.get(512).a(r);
        }
        a(hVar, (c) gVar, this.j.get(512).f(), fArr);
        r.c = this.j.get(512).f();
        return this.j.get(512).a(r);
    }

    private boolean a(com.oppo.camera.gl.h hVar, g gVar, boolean z, boolean z2, float[] fArr, com.oppo.camera.gl.s sVar) {
        s.a r = this.j.get(2).r();
        if (z) {
            r.c = sVar;
            return this.j.get(2).a(r);
        } else if (z2) {
            r.c = this.j.get(4).g();
            return this.j.get(2).a(r);
        } else {
            a(hVar, (c) gVar, this.j.get(2).f(), fArr);
            r.c = this.j.get(2).f();
            return this.j.get(2).a(r);
        }
    }

    private boolean a(com.oppo.camera.gl.h hVar, int i2, int i3, float[] fArr) {
        s.a r = this.j.get(16).r();
        r.f4427a = hVar;
        r.i = i2;
        r.j = i3;
        return this.j.get(16).a(r);
    }

    private boolean j(com.oppo.camera.gl.h hVar, g gVar, int i2, int i3, int i4, int i5, float[] fArr) {
        boolean z;
        this.j.get(32).a(hVar);
        boolean c2 = c(hVar, gVar, fArr, false);
        if (c2) {
            z = g(hVar, i2, i3, i4, i5, this.d);
        } else {
            z = false;
        }
        if (!c2 || !z) {
            return false;
        }
        return true;
    }

    private boolean k(com.oppo.camera.gl.h hVar, g gVar, int i2, int i3, int i4, int i5, float[] fArr) {
        this.j.get(512).a(hVar);
        boolean b2 = b(hVar, gVar, fArr, false);
        if (b2) {
            h(hVar, i2, i3, i4, i5, this.d);
        }
        return b2;
    }

    private boolean l(com.oppo.camera.gl.h hVar, g gVar, int i2, int i3, int i4, int i5, float[] fArr) {
        boolean z;
        com.oppo.camera.gl.h hVar2 = hVar;
        this.j.get(512).a(hVar);
        this.j.get(2).a(hVar);
        float[] fArr2 = fArr;
        boolean b2 = b(hVar, gVar, fArr2, false);
        boolean a2 = a(hVar, gVar, b2, false, fArr2, this.j.get(512).g());
        if (a2) {
            d(hVar, i2, i3, i4, i5, this.d);
        } else if (b2) {
            z = h(hVar, i2, i3, i4, i5, this.d);
            if (!a2 || (b2 && z)) {
                return true;
            }
            return false;
        }
        z = false;
        if (!a2) {
        }
        return true;
    }

    private boolean c(com.oppo.camera.gl.h hVar, g gVar, float[] fArr, boolean z) {
        s.a r = this.j.get(32).r();
        r.f4427a = hVar;
        if (z) {
            r.c = this.j.get(4).g();
        } else {
            a(hVar, (c) gVar, this.j.get(32).f(), fArr);
            r.c = this.j.get(32).f();
        }
        return this.j.get(32).a(r);
    }

    private boolean m(com.oppo.camera.gl.h hVar, g gVar, int i2, int i3, int i4, int i5, float[] fArr) {
        boolean z;
        com.oppo.camera.gl.h hVar2 = hVar;
        this.j.get(32).a(hVar);
        this.j.get(2).a(hVar);
        float[] fArr2 = fArr;
        boolean c2 = c(hVar, gVar, fArr2, false);
        boolean a2 = a(hVar, gVar, c2, false, fArr2, this.j.get(32).g());
        if (a2) {
            d(hVar, i2, i3, i4, i5, this.d);
        } else if (c2) {
            z = g(hVar, i2, i3, i4, i5, this.d);
            if (!a2 || (c2 && z)) {
                return true;
            }
            return false;
        }
        z = false;
        if (!a2) {
        }
        return true;
    }

    private boolean g(com.oppo.camera.gl.h hVar, g gVar, int i2, int i3, int i4, int i5, float[] fArr, int i6) {
        boolean z;
        com.oppo.camera.gl.h hVar2 = hVar;
        g gVar2 = gVar;
        float[] fArr2 = fArr;
        this.j.get(4).a(hVar);
        this.j.get(32).a(hVar);
        boolean a2 = a(hVar, gVar, fArr2, i6);
        boolean c2 = c(hVar, gVar, fArr2, a2);
        if (c2) {
            z = g(hVar, i2, i3, i4, i5, this.d);
        } else {
            z = false;
        }
        if ((!c2 || !z) && a2) {
            a(hVar, i2, i3, i4, i5, this.d);
        }
        if ((!c2 || !z) && !a2) {
            return false;
        }
        return true;
    }

    private boolean h(com.oppo.camera.gl.h hVar, g gVar, int i2, int i3, int i4, int i5, float[] fArr, int i6) {
        boolean z;
        com.oppo.camera.gl.h hVar2 = hVar;
        g gVar2 = gVar;
        float[] fArr2 = fArr;
        this.j.get(4).a(hVar);
        this.j.get(512).a(hVar);
        boolean a2 = a(hVar, gVar, fArr2, i6);
        boolean b2 = b(hVar, gVar, fArr2, a2);
        if (b2) {
            z = h(hVar, i2, i3, i4, i5, this.d);
        } else {
            z = false;
        }
        if ((!b2 || !z) && a2) {
            a(hVar, i2, i3, i4, i5, this.d);
        }
        if ((!b2 || !z) && !a2) {
            return false;
        }
        return true;
    }

    private boolean i(com.oppo.camera.gl.h hVar, g gVar, int i2, int i3, int i4, int i5, float[] fArr, int i6) {
        boolean z;
        com.oppo.camera.gl.h hVar2 = hVar;
        g gVar2 = gVar;
        float[] fArr2 = fArr;
        this.j.get(4).a(hVar);
        this.j.get(32).a(hVar);
        this.j.get(2).a(hVar);
        this.h.j();
        this.h.a(this.d);
        boolean a2 = a(hVar, gVar2, fArr2, i6);
        boolean c2 = c(hVar, gVar2, fArr2, a2);
        boolean a3 = a(hVar, gVar2, c2, a2, fArr2, this.j.get(32).g());
        if (a3) {
            d(hVar, i2, i3, i4, i5, this.d);
            z = false;
        } else {
            if (c2) {
                z = g(hVar, i2, i3, i4, i5, this.d);
            } else {
                z = false;
            }
            if ((!c2 || !z) && a2) {
                a(hVar, i2, i3, i4, i5, this.d);
            }
        }
        if (a3 || ((c2 && z) || a2)) {
            return true;
        }
        return false;
    }

    private boolean j(com.oppo.camera.gl.h hVar, g gVar, int i2, int i3, int i4, int i5, float[] fArr, int i6) {
        boolean z;
        com.oppo.camera.gl.h hVar2 = hVar;
        g gVar2 = gVar;
        float[] fArr2 = fArr;
        this.j.get(4).a(hVar);
        this.j.get(512).a(hVar);
        this.j.get(2).a(hVar);
        this.h.j();
        this.h.a(this.d);
        boolean a2 = a(hVar, gVar2, fArr2, i6);
        boolean b2 = b(hVar, gVar2, fArr2, a2);
        boolean a3 = a(hVar, gVar2, b2, a2, fArr2, this.j.get(512).g());
        if (a3) {
            d(hVar, i2, i3, i4, i5, this.d);
            z = false;
        } else {
            if (b2) {
                z = h(hVar, i2, i3, i4, i5, this.d);
            } else {
                z = false;
            }
            if ((!b2 || !z) && a2) {
                a(hVar, i2, i3, i4, i5, this.d);
            }
        }
        if (a3 || ((b2 && z) || a2)) {
            return true;
        }
        return false;
    }

    private void d(com.oppo.camera.gl.h hVar, int i2, int i3, int i4, int i5, float[] fArr) {
        hVar.a((c) this.j.get(2).g(), fArr, i2, i3, i4, i5);
    }

    private void e(com.oppo.camera.gl.h hVar, int i2, int i3, int i4, int i5, float[] fArr) {
        hVar.a((c) this.j.get(1).g(), fArr, i2, i3, i4, i5);
    }

    private void f(com.oppo.camera.gl.h hVar, int i2, int i3, int i4, int i5, float[] fArr) {
        hVar.a((c) this.j.get(16).g(), fArr, i2, i3, i4, i5);
    }

    private boolean g(com.oppo.camera.gl.h hVar, int i2, int i3, int i4, int i5, float[] fArr) {
        if (Float.compare(this.i.f(), 0.0f) == 0) {
            return false;
        }
        hVar.a((c) this.j.get(32).g(), fArr, i2, i3, i4, i5);
        return true;
    }

    private boolean n(com.oppo.camera.gl.h hVar, g gVar, int i2, int i3, int i4, int i5, float[] fArr) {
        this.j.get(256).a(hVar);
        if (!d(hVar, gVar, fArr, false)) {
            return false;
        }
        if (i(hVar, i2, i3, i4, i5, this.d)) {
            return true;
        }
        return false;
    }

    private boolean h(com.oppo.camera.gl.h hVar, int i2, int i3, int i4, int i5, float[] fArr) {
        hVar.a((c) this.j.get(512).g(), fArr, i2, i3, i4, i5);
        return true;
    }

    private boolean k(com.oppo.camera.gl.h hVar, g gVar, int i2, int i3, int i4, int i5, float[] fArr, int i6) {
        boolean z;
        com.oppo.camera.gl.h hVar2 = hVar;
        g gVar2 = gVar;
        float[] fArr2 = fArr;
        this.j.get(4).a(hVar);
        this.j.get(256).a(hVar);
        boolean a2 = a(hVar, gVar, fArr2, i6);
        boolean d2 = d(hVar, gVar, fArr2, a2);
        if (d2) {
            z = i(hVar, i2, i3, i4, i5, this.d);
        } else {
            z = false;
        }
        if ((!d2 || !z) && a2) {
            a(hVar, i2, i3, i4, i5, this.d);
        }
        if ((!d2 || !z) && !a2) {
            return false;
        }
        return true;
    }

    private boolean d(com.oppo.camera.gl.h hVar, g gVar, float[] fArr, boolean z) {
        s.a r = this.j.get(256).r();
        r.f4427a = hVar;
        if (z) {
            r.c = this.j.get(4).g();
        } else {
            a(hVar, (c) gVar, this.j.get(256).f(), fArr);
            r.c = this.j.get(256).f();
        }
        return this.j.get(256).a(r);
    }

    private boolean a(com.oppo.camera.gl.h hVar, g gVar, int i2, int i3, int i4, int i5, float[] fArr, ApsResult.ImageBuffer imageBuffer) {
        this.j.get(1024).a(hVar);
        s.a r = this.j.get(1024).r();
        r.f4427a = hVar;
        r.i = i4;
        r.j = i5;
        r.e = imageBuffer;
        boolean a2 = this.j.get(1024).a(r);
        this.k.put(1024, Boolean.valueOf(a2));
        if (r.f) {
            hVar.a((c) r.d, this.e, i2, i3, i4, i5);
            return true;
        } else if (!a2) {
            return false;
        } else {
            return j(hVar, i2, i3, i4, i5, this.d);
        }
    }

    private boolean i(com.oppo.camera.gl.h hVar, int i2, int i3, int i4, int i5, float[] fArr) {
        if (!this.i.g()) {
            return false;
        }
        hVar.a((c) this.j.get(256).g(), fArr, i2, i3, i4, i5);
        return true;
    }

    private boolean j(com.oppo.camera.gl.h hVar, int i2, int i3, int i4, int i5, float[] fArr) {
        hVar.a((c) this.j.get(1024).g(), fArr, i2, i3, i4, i5);
        return true;
    }

    private boolean k(com.oppo.camera.gl.h hVar, int i2, int i3, int i4, int i5, float[] fArr) {
        hVar.a((c) this.j.get(1024).g(), fArr, i2, i3, i4, i5);
        return true;
    }
}
