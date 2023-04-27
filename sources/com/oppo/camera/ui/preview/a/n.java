package com.oppo.camera.ui.preview.a;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.Size;
import com.oppo.camera.aps.adapter.ApsResult;
import com.oppo.camera.doubleexposure.c;
import com.oppo.camera.gl.GLRootView;
import com.oppo.camera.gl.b.f;
import com.oppo.camera.gl.g;
import com.oppo.camera.gl.s;
import com.oppo.camera.gl.t;
import com.oppo.camera.sticker.data.StickerItem;
import com.oppo.camera.tiltshift.TiltShiftParam;
import com.oppo.camera.ui.preview.a.h;
import com.oppo.camera.ui.preview.a.u;

/* compiled from: PreviewEffectProcess */
public interface n {

    /* compiled from: PreviewEffectProcess */
    public interface a {
        com.oppo.camera.t.a a(int i, int i2, int i3, int i4, int i5, boolean z, long j);

        void a(int i);

        void a(int i, int i2, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, int i3);

        void a(com.oppo.camera.t.a aVar);

        boolean a(String str);

        Rect[] a();

        void b();

        void b(String str);
    }

    void a();

    void a(float f);

    void a(int i);

    void a(int i, int i2);

    void a(long j);

    void a(Bitmap bitmap);

    void a(Point point);

    void a(Size size, boolean z);

    void a(c cVar);

    void a(GLRootView gLRootView);

    void a(t tVar);

    void a(StickerItem stickerItem);

    void a(TiltShiftParam tiltShiftParam);

    void a(h.a aVar);

    void a(a aVar);

    void a(u.b bVar);

    void a(String str);

    void a(boolean z);

    void a(byte[] bArr);

    void a(float[] fArr);

    void a(int[] iArr);

    boolean a(com.oppo.camera.gl.h hVar, int i, int i2, int i3, int i4);

    boolean a(com.oppo.camera.gl.h hVar, f fVar, s sVar, int i, int i2, int i3, int i4);

    boolean a(com.oppo.camera.gl.h hVar, g gVar, int i, int i2, int i3, int i4);

    boolean a(com.oppo.camera.gl.h hVar, g gVar, int i, int i2, int i3, int i4, int i5);

    boolean a(com.oppo.camera.gl.h hVar, g gVar, int i, int i2, int i3, int i4, int i5, ApsResult.ImageBuffer imageBuffer);

    boolean a(com.oppo.camera.gl.h hVar, g gVar, s sVar);

    boolean a(byte[] bArr, int i, int i2, int i3);

    void b();

    void b(float f);

    void b(int i);

    void b(int i, int i2);

    void b(long j);

    void b(boolean z);

    boolean b(StickerItem stickerItem);

    void c();

    void c(float f);

    void c(int i);

    void c(boolean z);

    void d(float f);

    void d(int i);

    void d(boolean z);

    boolean d();

    void e(int i);

    void e(boolean z);

    boolean e();

    void f();

    void f(int i);

    void f(boolean z);

    void g();

    void g(int i);

    void g(boolean z);

    void h();

    void h(int i);

    void h(boolean z);

    s i(int i);

    void i();

    void i(boolean z);

    StickerItem j();

    void j(int i);

    void j(boolean z);

    int k();

    boolean l();

    float m();

    float n();

    void o();

    void p();

    void q();

    void r();
}
