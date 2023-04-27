package com.oppo.camera.f;

import android.graphics.Rect;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.hardware.camera2.params.MeteringRectangle;
import android.location.Location;
import android.media.Image;
import android.media.ImageReader;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Range;
import com.oppo.camera.aps.constant.ApsConstant;
import com.oppo.camera.e;
import com.oppo.camera.e.a.a;
import com.oppo.camera.f.f;
import com.oppo.camera.u.d;
import java.util.Set;

/* compiled from: OneCameraProxy */
public class h implements f {
    private g k;
    private g l;
    private a m;

    public h() {
        this.k = null;
        this.l = null;
        this.m = null;
        this.k = new g(1);
        this.m = new a();
        this.l = new g(2);
    }

    public a A() {
        return this.m;
    }

    public boolean H(int i) {
        return B() && 2 == i;
    }

    public boolean B() {
        return (this.m == null || this.l == null) ? false : true;
    }

    public void a(int i) {
        this.k.a(i);
        if (B()) {
            this.l.a(i);
        }
    }

    public ImageReader.OnImageAvailableListener a(ImageReader.OnImageAvailableListener onImageAvailableListener) {
        return this.k.a(onImageAvailableListener);
    }

    public void b(int i) {
        if (1 == i) {
            this.k.b(i);
        } else if (2 == i) {
            this.l.b(i);
        }
    }

    public void a() {
        this.k.a();
        if (B()) {
            this.l.a();
        }
    }

    public void a(String str, ImageReader.OnImageAvailableListener onImageAvailableListener, Handler handler) {
        this.k.a(str, onImageAvailableListener, handler);
    }

    public void b(long j) {
        this.k.b(j);
    }

    public void a(String str, ImageReader.OnImageAvailableListener onImageAvailableListener, Handler handler, int i) {
        if (1 == i) {
            this.k.a(str, onImageAvailableListener, handler);
        } else if (H(i)) {
            this.l.a(str, onImageAvailableListener, handler);
        }
    }

    public ImageReader a(String str, int i, int i2, int i3, int i4, long j) {
        return this.k.a(str, i, i2, i3, i4, j);
    }

    public ImageReader a(String str, int i, int i2, int i3, int i4, long j, int i5) {
        int i6 = i5;
        if (H(i6)) {
            return this.l.a(str, i, i2, i3, i4, j);
        }
        e.e("OneCameraProxy", "getImageReader, something maybe wrong, checkSubOneCameraByRole: " + H(i6));
        return this.k.a(str, i, i2, i3, i4, j);
    }

    public void a(boolean z) {
        this.k.a(z);
        if (B()) {
            this.l.a(z);
        }
    }

    public void a(int i, f.b bVar, int i2) {
        this.k.a(i, bVar, i2);
        e.b("OneCameraProxy", "openCamera mMultiCameraDecision: " + this.m + ", mSubOneCameraImpl: " + this.l + ", checkSubOneCamera: " + B() + ", needSubOpenCamera: " + G());
        if (B() && G()) {
            this.l.E();
            this.l.a(1, bVar, i2);
        }
    }

    public void b(boolean z) {
        this.k.b(z);
    }

    public boolean b() {
        return this.k.b();
    }

    public int c() {
        return this.k.c();
    }

    public void a(boolean z, CameraDevice cameraDevice, boolean z2) {
        this.k.a(z, cameraDevice, z2);
        if (B()) {
            this.l.a(z, cameraDevice, false);
        }
    }

    public void a(boolean z, CameraDevice cameraDevice, boolean z2, int i) {
        if (H(i)) {
            this.l.a(z, cameraDevice, z2);
        } else {
            this.k.a(z, cameraDevice, z2);
        }
    }

    public void d() {
        this.k.d();
    }

    public j e() {
        return this.k.e();
    }

    public CaptureRequest.Builder a(Set<String> set) throws CameraAccessException {
        return this.k.a(set);
    }

    public void a(int i, f.d dVar, int i2, int i3) {
        if (H(i3)) {
            this.l.b(i, dVar, i2);
            return;
        }
        this.l.E();
        this.k.b(i, dVar, i2);
    }

    public void f() {
        this.k.f();
        this.l.f();
    }

    public void g() {
        this.k.g();
    }

    public void h() {
        this.k.h();
    }

    public void a(f.c cVar) {
        this.k.a(cVar);
    }

    public void a(f.c cVar, int i) {
        if (H(i)) {
            this.l.a(cVar);
        } else {
            this.k.a(cVar);
        }
    }

    public void a(int i, d dVar, f.a aVar) {
        this.k.a(i, dVar, aVar);
    }

    public void a(f.a aVar, d dVar) {
        this.k.a(aVar, dVar);
    }

    public void i() {
        this.k.i();
    }

    public void a(boolean z, d dVar, f.a aVar) {
        this.k.a(z, dVar, aVar);
    }

    public void c(int i) {
        this.k.c(i);
    }

    public void d(int i) {
        this.k.d(i);
    }

    public void a(Location location) {
        this.k.a(location);
    }

    public void a(Rect rect) {
        this.k.a(rect);
    }

    public void a(float f) {
        this.k.a(f);
    }

    public void b(Rect rect) {
        this.k.b(rect);
    }

    public void j() {
        this.k.j();
    }

    public void I(int i) {
        if (H(i)) {
            this.l.j();
        } else {
            this.k.j();
        }
    }

    public void k() {
        this.k.k();
    }

    public Handler l() {
        return this.k.l();
    }

    public Handler m() {
        return this.k.m();
    }

    public void b(float f) {
        this.k.b(f);
    }

    public void a(int i, boolean z) {
        this.k.a(i, z);
    }

    public void a(int i, MeteringRectangle[] meteringRectangleArr, MeteringRectangle[] meteringRectangleArr2, boolean z) {
        this.k.a(i, meteringRectangleArr, meteringRectangleArr2, z);
    }

    public void a(MeteringRectangle[] meteringRectangleArr) {
        this.k.a(meteringRectangleArr);
    }

    public void b(MeteringRectangle[] meteringRectangleArr) {
        this.k.b(meteringRectangleArr);
    }

    public void a(k kVar) {
        this.k.a(kVar);
    }

    public void b(k kVar) {
        this.k.b(kVar);
    }

    public void n() {
        this.k.n();
    }

    public void o() {
        this.k.o();
    }

    public void e(int i) {
        this.k.e(i);
    }

    public int p() {
        return this.k.p();
    }

    public String q() {
        return this.k.q();
    }

    public void f(int i) {
        this.k.f(i);
    }

    public void m(boolean z) {
        this.k.m(z);
    }

    public void a(String str) {
        this.k.a(str);
    }

    public void c(boolean z) {
        this.k.c(z);
    }

    public int[] a(CaptureResult.Key<?> key, CaptureResult captureResult) {
        return this.k.a(key, captureResult);
    }

    public void g(int i) {
        this.k.g(i);
    }

    public void h(int i) {
        this.k.h(i);
    }

    public void i(int i) {
        this.k.i(i);
    }

    public void j(int i) {
        this.k.j(i);
        if (B()) {
            this.l.j(i);
        }
    }

    public void a(int i, int i2) {
        if (H(i2)) {
            this.l.j(i);
        } else {
            this.k.j(i);
        }
    }

    public void a(int[] iArr) {
        this.k.a(iArr);
    }

    public void a(f.e eVar) {
        this.k.a(eVar);
        if (B()) {
            this.l.a(eVar);
        }
    }

    public void r() {
        this.k.r();
    }

    public void k(int i) {
        this.k.k(i);
    }

    public void l(int i) {
        this.k.l(i);
    }

    public void m(int i) {
        this.k.m(i);
    }

    public void a(long j) {
        this.k.a(j);
    }

    public void s() {
        this.k.s();
        if (B()) {
            this.l.s();
        }
    }

    public void t() {
        this.k.t();
        if (B()) {
            this.l.t();
        }
    }

    public void n(int i) {
        this.k.n(i);
    }

    public void o(int i) {
        this.k.o(i);
    }

    public void p(int i) {
        this.k.p(i);
    }

    public void b(String str) {
        this.k.b(str);
    }

    public void d(boolean z) {
        this.k.d(z);
    }

    public void q(int i) {
        this.k.q(i);
    }

    public void r(int i) {
        this.k.r(i);
    }

    public void a(boolean z, boolean z2) {
        this.k.a(z, z2);
    }

    public void e(boolean z) {
        this.k.e(z);
    }

    public void f(boolean z) {
        this.k.f(z);
    }

    public void g(boolean z) {
        this.k.g(z);
    }

    public void s(int i) {
        this.k.s(i);
    }

    public void a(String str, int[] iArr) {
        this.k.a(str, iArr);
    }

    public boolean c(String str) {
        return this.k.c(str);
    }

    public void a(String str, boolean z) {
        this.k.a(str, z);
    }

    public void h(boolean z) {
        this.k.h(z);
    }

    public void d(String str) {
        this.k.d(str);
    }

    public void t(int i) {
        this.k.t(i);
    }

    public void u(int i) {
        this.k.u(i);
    }

    public void i(boolean z) {
        this.k.i(z);
    }

    public void v(int i) {
        this.k.v(i);
    }

    public void a(byte[] bArr) {
        this.k.a(bArr);
    }

    public void c(float f) {
        this.k.c(f);
    }

    public void w(int i) {
        this.k.w(i);
    }

    public void x(int i) {
        this.k.x(i);
    }

    public void y(int i) {
        this.k.y(i);
    }

    public void z(int i) {
        this.k.z(i);
    }

    public void a(Image image, TotalCaptureResult totalCaptureResult, Rect rect, d dVar) {
        this.k.a(image, totalCaptureResult, rect, dVar);
    }

    public void A(int i) {
        this.k.A(i);
    }

    public void j(boolean z) {
        this.k.j(z);
    }

    public void k(boolean z) {
        this.k.k(z);
    }

    public void B(int i) {
        this.k.B(i);
    }

    public void C(int i) {
        this.k.C(i);
    }

    public void D(int i) {
        this.k.D(i);
    }

    public void l(boolean z) {
        this.k.l(z);
    }

    public void u() {
        this.k.u();
    }

    public void b(byte[] bArr) {
        this.k.b(bArr);
    }

    public void n(boolean z) {
        this.k.n(z);
    }

    public int v() {
        return this.k.v();
    }

    public void w() {
        this.k.w();
    }

    public void x() {
        this.k.x();
    }

    public CameraCharacteristics e(String str) {
        return this.k.e(str);
    }

    public void a(boolean z, String str) {
        this.k.a(z, str);
    }

    public void a(Range range) {
        this.k.a(range);
    }

    public void E(int i) {
        this.k.E(i);
    }

    public void o(boolean z) {
        this.k.o(z);
    }

    public void f(String str) {
        this.k.f(str);
    }

    public void p(boolean z) {
        this.k.p(z);
    }

    public void y() {
        this.k.y();
    }

    public void q(boolean z) {
        this.k.q(z);
    }

    public void r(boolean z) {
        this.k.r(z);
    }

    public void a(d dVar) {
        this.k.a(dVar);
    }

    public void g(String str) {
        this.k.g(str);
    }

    public void s(boolean z) {
        this.k.s(z);
    }

    public void b(int[] iArr) {
        this.k.b(iArr);
    }

    public void t(boolean z) {
        this.k.t(z);
    }

    public void F(int i) {
        this.k.F(i);
    }

    public void c(long j) {
        this.k.c(j);
    }

    public void G(int i) {
        this.k.G(i);
    }

    public void d(long j) {
        this.k.d(j);
    }

    private boolean G() {
        return ApsConstant.CAPTURE_MODE_MULTI_VIDEO.equals(this.m.c()) || (TextUtils.isEmpty(this.m.b()) && TextUtils.isEmpty(this.m.c()) && ApsConstant.CAPTURE_MODE_MULTI_VIDEO.equals(this.m.h()));
    }

    public void C() {
        this.l.D();
    }

    public boolean D() {
        return this.k.H() && this.l.H();
    }

    public void u(boolean z) {
        this.k.u(z);
    }

    public void v(boolean z) {
        this.k.v(z);
    }

    public void z() {
        this.k.z();
    }

    public boolean E() {
        return this.l.I();
    }

    public void F() {
        this.k.F();
    }
}
