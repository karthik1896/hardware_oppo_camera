package com.oppo.camera.e;

import android.content.SharedPreferences;
import android.location.Location;
import android.net.Uri;
import android.util.Size;
import android.view.animation.Animation;
import com.oppo.camera.aa;
import com.oppo.camera.aps.adapter.ApsResult;
import com.oppo.camera.aps.service.ApsAdapterListener;
import com.oppo.camera.aps.service.ThumbnailProcessor;
import com.oppo.camera.f.d;
import com.oppo.camera.f.f;
import com.oppo.camera.statistics.model.CaptureMsgData;
import com.oppo.camera.tiltshift.TiltShiftParam;
import com.oppo.camera.ui.control.e;
import com.oppo.camera.y;
import com.oppo.camera.z;
import java.util.List;

/* compiled from: CameraInterface */
public interface b {
    void A();

    boolean B();

    boolean C();

    void D();

    boolean E();

    boolean F();

    boolean G();

    void H();

    void I();

    void J();

    void K();

    void L();

    boolean M();

    void N();

    boolean O();

    boolean P();

    void Q();

    int R();

    void S();

    void T();

    void U();

    void V();

    aa W();

    boolean X();

    String Y();

    String Z();

    Uri a(ThumbnailProcessor.DataRequest dataRequest);

    void a();

    void a(int i);

    void a(int i, d dVar, f.a aVar, ApsAdapterListener.CaptureCallback captureCallback);

    void a(long j, int i, int i2);

    void a(long j, String str, boolean z);

    void a(Size size);

    void a(Animation.AnimationListener animationListener);

    void a(ApsResult.ImageBuffer imageBuffer, int i);

    void a(e.c cVar);

    void a(e.c cVar, boolean z, boolean z2);

    void a(e eVar);

    void a(z.a aVar);

    void a(String str);

    void a(boolean z);

    void a(boolean z, int i, boolean z2);

    void a(boolean z, List<String> list, String str, int i);

    void a(boolean z, boolean z2);

    void a(byte[] bArr);

    boolean a(float f);

    boolean a(float f, float f2);

    void aA();

    void aB();

    void aC();

    boolean aD();

    float[] aE();

    void aF();

    TiltShiftParam aG();

    boolean aH();

    int aa();

    CaptureMsgData ab();

    int ac();

    float ad();

    float ae();

    void af();

    boolean ag();

    boolean ah();

    y ai();

    byte[] aj();

    Size ak();

    int al();

    int am();

    boolean an();

    void ao();

    void ap();

    int aq();

    int ar();

    void as();

    boolean at();

    boolean au();

    void av();

    boolean aw();

    void ax();

    boolean ay();

    String az();

    com.oppo.camera.entry.b b();

    void b(float f);

    void b(int i);

    void b(Size size);

    void b(z.a aVar);

    void b(String str);

    void b(boolean z);

    void b(boolean z, boolean z2);

    void b(byte[] bArr);

    void c(int i);

    void c(boolean z);

    boolean c();

    void d(int i);

    void d(boolean z);

    boolean d();

    void e();

    void e(boolean z);

    void f();

    void f(boolean z);

    void g();

    void g(boolean z);

    int h();

    void h(boolean z);

    void i();

    boolean j();

    int k();

    boolean l();

    boolean m();

    void n();

    boolean o();

    int p();

    boolean q();

    SharedPreferences r();

    int s();

    String t();

    long u();

    Location v();

    boolean w();

    boolean x();

    void y();

    boolean z();
}
