package com.oppo.camera.ui;

import android.content.DialogInterface;
import android.graphics.Rect;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.RelativeLayout;
import com.oppo.camera.gl.GLRootView;
import com.oppo.camera.gl.t;
import com.oppo.camera.t.a;
import com.oppo.camera.ui.control.c;
import com.oppo.camera.ui.control.e;
import com.oppo.camera.ui.menu.setting.CameraMenuOption;
import com.oppo.camera.ui.preview.a.k;
import java.util.List;

/* compiled from: CameraUIInterface */
public interface e {
    public static final String[] d = {"key_beauty_custom_video_exfoliating", "key_beauty_custom_video_thin_face", "key_beauty_custom_video_big_eye", "key_beauty_custom_video_thin_nasal", "key_beauty_custom_video_chin", "key_beauty_custom_video_little_face", "key_beauty_custom_video_makeup", "key_beauty_custom_video_3d"};
    public static final String[] d_ = {"key_beauty_custom_sticker_exfoliating", "key_beauty_custom_sticker_thin_face", "key_beauty_custom_sticker_big_eye", "key_beauty_custom_sticker_thin_nasal", "key_beauty_custom_sticker_chin", "key_beauty_custom_sticker_little_face", "key_beauty_custom_sticker_makeup", "key_beauty_custom_sticker_3d"};
    public static final String[] e = {"key_beauty_custom_night_exfoliating", "key_beauty_custom_night_thin_face", "key_beauty_custom_night_big_eye", "key_beauty_custom_night_thin_nasal", "key_beauty_custom_night_chin", "key_beauty_custom_night_little_face", "key_beauty_custom_night_makeup", "key_beauty_custom_night_3d"};
    public static final String[] e_ = {"key_beauty_custom_common_exfoliating", "key_beauty_custom_common_thin_face", "key_beauty_custom_common_big_eye", "key_beauty_custom_common_thin_nasal", "key_beauty_custom_common_chin", "key_beauty_custom_common_little_face", "key_beauty_custom_common_makeup", "key_beauty_custom_common_3d"};
    public static final String[] f = {"key_beauty_custom_multi_video_exfoliating", "key_beauty_custom_multi_video_thin_face", "key_beauty_custom_multi_video_big_eye", "key_beauty_custom_multi_video_thin_nasal", "key_beauty_custom_multi_video_chin", "key_beauty_custom_multi_video_little_face", "key_beauty_custom_multi_video_makeup", "key_beauty_custom_multi_video_3d"};
    public static final String[] f_ = {"key_beauty_custom_portrait_exfoliating", "key_beauty_custom_portrait_thin_face", "key_beauty_custom_portrait_big_eye", "key_beauty_custom_portrait_thin_nasal", "key_beauty_custom_portrait_chin", "key_beauty_custom_portrait_little_face", "key_beauty_custom_portrait_makeup", "key_beauty_custom_portrait_3d"};
    public static final String[] g = {"key_beauty_custom_idphoto_exfoliating", "key_beauty_custom_idphoto_thin_face", "key_beauty_custom_idphoto_big_eye", "key_beauty_custom_idphoto_thin_nasal", "key_beauty_custom_idphoto_chin", "key_beauty_custom_idphoto_little_face", "key_beauty_custom_idphoto_makeup", "key_beauty_custom_idphoto_3d"};

    void A();

    void A(boolean z);

    void B();

    void B(boolean z);

    void C(boolean z);

    boolean C();

    void D(boolean z);

    boolean D();

    void E();

    void E(boolean z);

    void F();

    void F(boolean z);

    void G(boolean z);

    boolean G();

    void H(boolean z);

    boolean H();

    void I(boolean z);

    boolean I();

    void J(boolean z);

    boolean J();

    void K();

    boolean L();

    void M();

    void N();

    boolean O();

    int P();

    void Q();

    boolean R();

    boolean S();

    boolean T();

    boolean U();

    boolean V();

    void W();

    void X();

    void Y();

    int Z();

    GLRootView a();

    void a(int i);

    void a(int i, int i2);

    void a(int i, int i2, boolean z, boolean z2, boolean z3);

    void a(int i, int i2, boolean z, boolean z2, boolean z3, boolean z4, boolean z5);

    void a(int i, int i2, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, int i3);

    void a(int i, String str);

    void a(int i, boolean z);

    void a(long j);

    void a(long j, long j2, boolean z, boolean z2, long j3);

    void a(long j, boolean z);

    void a(DialogInterface.OnCancelListener onCancelListener);

    void a(View view, int i, int i2, int i3);

    void a(View view, String str, int i, boolean z);

    void a(Animation animation);

    void a(t.a aVar, boolean z, boolean z2, String str);

    void a(a aVar);

    void a(c cVar);

    void a(c cVar, boolean z);

    void a(e.c cVar, boolean z);

    void a(com.oppo.camera.ui.control.e eVar, int i);

    void a(k kVar);

    void a(Float f2, int i, boolean z);

    void a(String str);

    void a(String str, int i);

    void a(String str, int i, int i2);

    void a(String str, String str2);

    void a(String str, String str2, String str3);

    void a(String str, boolean z);

    void a(String str, boolean z, int i, int i2);

    void a(String str, boolean z, boolean z2);

    void a(String str, String... strArr);

    void a(List<String> list, long j);

    void a(boolean z);

    void a(boolean z, String str);

    void a(boolean z, boolean z2);

    void a(boolean z, boolean z2, boolean z3);

    void a(boolean z, boolean z2, boolean z3, boolean z4);

    void a(int... iArr);

    void aA();

    void aB();

    void aC();

    int aa();

    Uri ab();

    boolean ac();

    String ad();

    void ae();

    void af();

    void ag();

    boolean ah();

    boolean ai();

    Rect aj();

    boolean ak();

    void al();

    void am();

    void an();

    boolean ao();

    boolean ap();

    void aq();

    void ar();

    boolean as();

    void at();

    void au();

    void av();

    void aw();

    void ax();

    void ay();

    void az();

    ViewGroup b();

    void b(int i);

    void b(int i, int i2);

    void b(int i, boolean z);

    void b(String str);

    void b(String str, int i);

    void b(String str, String str2);

    void b(String str, boolean z);

    void b(String str, String... strArr);

    void b(boolean z);

    void b(boolean z, boolean z2);

    void b(boolean z, boolean z2, boolean z3);

    com.oppo.camera.ui.preview.e c();

    void c(int i);

    void c(int i, int i2);

    void c(int i, boolean z);

    void c(String str);

    void c(String str, int i);

    void c(boolean z);

    void c(boolean z, boolean z2);

    void c(boolean z, boolean z2, boolean z3);

    void d(int i);

    void d(String str);

    void d(boolean z);

    void d(boolean z, boolean z2);

    void d(boolean z, boolean z2, boolean z3);

    boolean d();

    String e();

    void e(int i);

    void e(String str);

    void e(boolean z);

    void e(boolean z, boolean z2);

    int f();

    void f(int i);

    void f(String str);

    void f(boolean z);

    void f(boolean z, boolean z2);

    void g();

    void g(int i);

    void g(String str);

    void g(boolean z);

    void g(boolean z, boolean z2);

    void h();

    void h(int i);

    void h(String str);

    void h(boolean z);

    void h(boolean z, boolean z2);

    RelativeLayout i();

    CameraMenuOption i(String str);

    void i(int i);

    void i(boolean z);

    void i(boolean z, boolean z2);

    void j();

    void j(int i);

    void j(boolean z);

    int k();

    void k(int i);

    void k(boolean z);

    int l();

    void l(int i);

    void l(boolean z);

    void m();

    void m(int i);

    void m(boolean z);

    CameraScreenHintView n();

    void n(int i);

    void n(boolean z);

    void o();

    void o(int i);

    void o(boolean z);

    void p();

    void p(int i);

    void p(boolean z);

    void q();

    void q(int i);

    void q(boolean z);

    String r();

    void r(int i);

    void r(boolean z);

    void s(int i);

    void s(boolean z);

    boolean s();

    void t(int i);

    void t(boolean z);

    boolean t();

    void u();

    void u(boolean z);

    void v();

    void v(boolean z);

    void w();

    void w(boolean z);

    void x();

    void x(boolean z);

    void y();

    void y(boolean z);

    k z();

    void z(boolean z);
}
