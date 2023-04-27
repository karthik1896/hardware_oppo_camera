package com.oppo.camera.f;

import android.graphics.Rect;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CaptureFailure;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.hardware.camera2.params.InputConfiguration;
import android.hardware.camera2.params.MeteringRectangle;
import android.location.Location;
import android.media.Image;
import android.media.ImageReader;
import android.os.Handler;
import android.util.Range;
import android.view.Surface;
import com.oppo.camera.aps.adapter.ApsCaptureResult;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Set;

/* compiled from: OneCamera */
public interface f extends com.oppo.camera.d {
    public static final byte[] d = {0};
    public static final byte[] e = {1};
    public static final byte[] f = {2};
    public static final byte[] g = {0};
    public static final byte[] h = {1};
    public static final byte[] i = {2};
    public static final byte[] j = {3};

    /* compiled from: OneCamera */
    public interface a {
        void S();

        void V();

        void a(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, long j, long j2);

        void a(CaptureRequest captureRequest);

        void a(CaptureRequest captureRequest, CaptureResult captureResult);

        void a(ApsCaptureResult apsCaptureResult, CaptureRequest captureRequest);

        void b(d dVar);
    }

    /* compiled from: OneCamera */
    public interface b {
        void a(int i);

        void a(int i, int i2);

        void a(boolean z, int i);

        boolean a();

        void b(int i);
    }

    /* compiled from: OneCamera */
    public interface c {
        void a(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, long j, long j2);

        void a(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, CaptureFailure captureFailure);

        void a(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, CaptureResult captureResult);

        void a(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, TotalCaptureResult totalCaptureResult, int i, long j);

        void a(TotalCaptureResult totalCaptureResult, int i);
    }

    /* compiled from: OneCamera */
    public interface d {
        InputConfiguration a();

        void a(int i);

        void a(d dVar, int i);

        void a(LinkedHashMap<String, C0084f> linkedHashMap, int i);

        boolean a(CaptureRequest captureRequest, int i);

        void b();

        Range<Integer> c();
    }

    /* compiled from: OneCamera */
    public interface e {
        int a(String str);

        void a();

        void a(int i);

        void a(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, long j);

        void a(CaptureRequest.Builder builder, int i, int i2, String[] strArr);

        void a(TotalCaptureResult totalCaptureResult, CaptureRequest captureRequest);

        void a(d dVar, CaptureRequest.Builder builder, HashMap<String, C0084f> hashMap, int i);

        void a(boolean z);

        void b();

        void c();

        void d();
    }

    void A(int i2);

    void B(int i2);

    void C(int i2);

    void D(int i2);

    void E(int i2);

    void F(int i2);

    void G(int i2);

    CaptureRequest.Builder a(Set<String> set) throws CameraAccessException;

    ImageReader.OnImageAvailableListener a(ImageReader.OnImageAvailableListener onImageAvailableListener);

    ImageReader a(String str, int i2, int i3, int i4, int i5, long j2);

    void a();

    void a(float f2);

    void a(int i2);

    void a(int i2, d dVar, a aVar);

    void a(int i2, b bVar, int i3);

    void a(int i2, boolean z);

    void a(int i2, MeteringRectangle[] meteringRectangleArr, MeteringRectangle[] meteringRectangleArr2, boolean z);

    void a(long j2);

    void a(Rect rect);

    void a(Location location);

    void a(Image image, TotalCaptureResult totalCaptureResult, Rect rect, d dVar);

    void a(Range range);

    void a(a aVar, d dVar);

    void a(c cVar);

    void a(e eVar);

    void a(k kVar);

    void a(com.oppo.camera.u.d dVar);

    void a(String str);

    void a(String str, ImageReader.OnImageAvailableListener onImageAvailableListener, Handler handler);

    void a(String str, boolean z);

    void a(String str, int[] iArr);

    void a(boolean z);

    void a(boolean z, CameraDevice cameraDevice, boolean z2);

    void a(boolean z, d dVar, a aVar);

    void a(boolean z, String str);

    void a(boolean z, boolean z2);

    void a(byte[] bArr);

    void a(int[] iArr);

    void a(MeteringRectangle[] meteringRectangleArr);

    int[] a(CaptureResult.Key<?> key, CaptureResult captureResult);

    void b(float f2);

    void b(int i2);

    void b(long j2);

    void b(Rect rect);

    void b(k kVar);

    void b(String str);

    void b(boolean z);

    void b(byte[] bArr);

    void b(int[] iArr);

    void b(MeteringRectangle[] meteringRectangleArr);

    boolean b();

    int c();

    void c(float f2);

    void c(int i2);

    void c(long j2);

    void c(boolean z);

    boolean c(String str);

    void d();

    void d(int i2);

    void d(long j2);

    void d(String str);

    void d(boolean z);

    CameraCharacteristics e(String str);

    j e();

    void e(int i2);

    void e(boolean z);

    void f();

    void f(int i2);

    void f(String str);

    void f(boolean z);

    void g();

    void g(int i2);

    void g(String str);

    void g(boolean z);

    void h();

    void h(int i2);

    void h(boolean z);

    void i();

    void i(int i2);

    void i(boolean z);

    void j();

    void j(int i2);

    void j(boolean z);

    void k();

    void k(int i2);

    void k(boolean z);

    Handler l();

    void l(int i2);

    void l(boolean z);

    Handler m();

    void m(int i2);

    void m(boolean z);

    void n();

    void n(int i2);

    void n(boolean z);

    void o();

    void o(int i2);

    void o(boolean z);

    int p();

    void p(int i2);

    void p(boolean z);

    String q();

    void q(int i2);

    void q(boolean z);

    void r();

    void r(int i2);

    void r(boolean z);

    void s();

    void s(int i2);

    void s(boolean z);

    void t();

    void t(int i2);

    void t(boolean z);

    void u();

    void u(int i2);

    void u(boolean z);

    int v();

    void v(int i2);

    void v(boolean z);

    void w();

    void w(int i2);

    void x();

    void x(int i2);

    void y();

    void y(int i2);

    void z();

    void z(int i2);

    /* renamed from: com.oppo.camera.f.f$f  reason: collision with other inner class name */
    /* compiled from: OneCamera */
    public static class C0084f {

        /* renamed from: a  reason: collision with root package name */
        private Surface f3193a = null;

        /* renamed from: b  reason: collision with root package name */
        private String f3194b = null;

        public C0084f(Surface surface) {
            this.f3193a = surface;
        }

        public C0084f(Surface surface, String str) {
            this.f3193a = surface;
            this.f3194b = str;
        }

        public Surface a() {
            return this.f3193a;
        }

        public String b() {
            return this.f3194b;
        }

        public String toString() {
            return "mSurface: " + this.f3193a + ", mPhysicalId: " + this.f3194b;
        }
    }
}
