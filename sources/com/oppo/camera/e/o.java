package com.oppo.camera.e;

import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.TotalCaptureResult;
import android.media.Image;
import android.media.ImageReader;
import android.util.Range;
import android.util.Size;
import android.view.MotionEvent;
import android.view.Surface;
import com.oppo.camera.ab;
import com.oppo.camera.aps.ApsCameraRequestTag;
import com.oppo.camera.aps.adapter.ApsAdapterDecision;
import com.oppo.camera.aps.adapter.ApsResult;
import com.oppo.camera.aps.adapter.ApsTotalResult;
import com.oppo.camera.aps.adapter.ImageCategory;
import com.oppo.camera.aps.config.AlgoSwitchConfig;
import com.oppo.camera.aps.config.CameraConfig;
import com.oppo.camera.aps.config.ConfigDataBase;
import com.oppo.camera.aps.constant.ApsConstant;
import com.oppo.camera.aps.service.ApsService;
import com.oppo.camera.aps.service.ThumbnailItem;
import com.oppo.camera.doubleexposure.g;
import com.oppo.camera.f.f;
import com.oppo.camera.f.j;
import com.oppo.camera.j.t;
import com.oppo.camera.o.a;
import com.oppo.camera.r.g;
import com.oppo.camera.s.b;
import com.oppo.camera.s.d;
import com.oppo.camera.statistics.CameraStatisticsUtil;
import com.oppo.camera.statistics.model.DcsMsgData;
import com.oppo.camera.tiltshift.TiltShiftParam;
import com.oppo.camera.ui.control.c;
import com.oppo.camera.ui.control.e;
import com.oppo.camera.ui.e;
import com.oppo.camera.ui.preview.a.h;
import com.oppo.camera.ui.preview.a.k;
import com.oppo.camera.ui.preview.a.n;
import com.oppo.camera.util.Util;
import com.oppo.camera.z;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: ModeManager */
public class o {

    /* renamed from: a  reason: collision with root package name */
    private int f2894a = -1;

    /* renamed from: b  reason: collision with root package name */
    private int f2895b;
    private a c = null;
    private Map<String, a> d = new ConcurrentHashMap();
    private f e = null;
    private boolean f = false;
    private boolean g = false;
    private boolean h = false;
    private String i = ApsConstant.CAPTURE_MODE_COMMON;
    private Activity j = null;
    private b k = null;
    private e l = null;
    private n m = null;

    public String q() {
        return ApsConstant.CAPTURE_MODE_COMMON;
    }

    public o(Activity activity) {
        this.j = activity;
    }

    public void a(b bVar, e eVar, n nVar) {
        this.k = bVar;
        this.l = eVar;
        this.m = nVar;
    }

    public a a(String str) {
        Map<String, a> map = this.d;
        if (map != null) {
            return map.get(str);
        }
        return null;
    }

    public boolean a() {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.ej();
        }
        return false;
    }

    public boolean b() {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.ek();
        }
        return false;
    }

    public boolean c() {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.el();
        }
        return false;
    }

    public int d() {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.c();
        }
        return 0;
    }

    public String e() {
        return this.i;
    }

    public c f() {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.o();
        }
        com.oppo.camera.e.e("ModeManager", "getShutterButtonInfo, mCurrentMode is null..");
        return null;
    }

    public boolean g() {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.g();
        }
        return true;
    }

    public boolean h() {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.I();
        }
        return false;
    }

    public boolean i() {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.h();
        }
        return false;
    }

    public void b(String str) {
        a aVar = this.c;
        if (aVar != null) {
            aVar.a(str);
        }
    }

    public void a(boolean z) {
        a aVar = this.c;
        if (aVar != null) {
            aVar.m(z);
        }
    }

    public String a(int i2, String str) {
        if (b(i2, str)) {
            return str;
        }
        String a2 = Util.a(this.k.m());
        com.oppo.camera.e.a("ModeManager", "getEnabledModeForCameraId, modeName: " + str + ", Switch to mode: " + a2);
        return a2;
    }

    public boolean c(String str) {
        if (!b(this.f2894a, str)) {
            com.oppo.camera.e.e("ModeManager", "setCurrentMode fail, the mode: " + str + " is not enabled at cameraId: " + this.f2894a);
            str = Util.a(this.k.m());
            if (ApsConstant.CAPTURE_MODE_COMMON.equals(str) && this.d.get(ApsConstant.CAPTURE_MODE_COMMON) == null) {
                e eVar = new e(this.j, this.k, this.l, this.m);
                this.d.put(eVar.a(), eVar);
            } else if (ApsConstant.REC_MODE_COMMON.equals(str) && this.d.get(ApsConstant.REC_MODE_COMMON) == null) {
                f fVar = new f(this.j, this.k, this.l, this.m);
                this.d.put(fVar.a(), fVar);
            }
        }
        a aVar = this.d.get(str);
        if (aVar == null) {
            com.oppo.camera.e.e("ModeManager", "setCurrentMode, cannot find cap mode: " + str);
            return false;
        }
        aVar.i(this.f2894a);
        aVar.bl();
        a aVar2 = this.c;
        if (aVar2 != null) {
            if (aVar2.a().equals(str)) {
                com.oppo.camera.e.a("ModeManager", "setCurrentMode fail, the mode not change: " + str);
                return false;
            }
            if (!a()) {
                this.i = this.c.a();
            }
            this.c.az();
        }
        this.c = aVar;
        this.c.a(this.e);
        this.c.ay();
        this.c.p(this.g);
        this.c.n(this.h);
        this.l.z(this.c.ej());
        com.oppo.camera.e.a("ModeManager", "setCurrentMode, mCurrentMode mode: " + aVar.a());
        return true;
    }

    public boolean j() {
        return this.c.au();
    }

    public void k() {
        this.c.eh();
    }

    public String l() {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.a();
        }
        return null;
    }

    public boolean m() {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.cs();
        }
        return false;
    }

    public String n() {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.b();
        }
        return null;
    }

    public Range<Integer> o() {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.e();
        }
        return null;
    }

    public boolean a(MotionEvent motionEvent) {
        a aVar = this.c;
        if (aVar == null) {
            return false;
        }
        return aVar.a(motionEvent);
    }

    public boolean b(MotionEvent motionEvent) {
        a aVar = this.c;
        if (aVar == null) {
            return false;
        }
        return aVar.b(motionEvent);
    }

    public boolean a(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.a(motionEvent, motionEvent2, f2, f3);
        }
        return false;
    }

    public boolean c(MotionEvent motionEvent) {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.c(motionEvent);
        }
        return false;
    }

    public int p() {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.D();
        }
        return 20;
    }

    public boolean a(boolean z, boolean z2) {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.a(z, z2);
        }
        return false;
    }

    public void a(ApsTotalResult apsTotalResult) {
        a aVar = this.c;
        if (aVar != null) {
            aVar.a(apsTotalResult);
        }
    }

    public void a(ThumbnailItem thumbnailItem) {
        a aVar = this.c;
        if (aVar != null) {
            aVar.a(thumbnailItem);
        }
    }

    public void r() {
        com.oppo.camera.e.a("onBeforePreview");
        if (this.c != null) {
            com.oppo.camera.e.a("ModeManager", "onBeforePreview, capMode: " + this.c.a() + ", mCurrentMode: " + this.c);
            this.c.aA();
        }
        com.oppo.camera.e.b("onBeforePreview");
    }

    public void b(boolean z) {
        a aVar = this.c;
        if (aVar != null) {
            aVar.e(z);
        }
    }

    public void a(f fVar) {
        this.e = fVar;
        a aVar = this.c;
        if (aVar != null) {
            aVar.a(fVar);
        }
    }

    public void s() {
        a aVar = this.c;
        if (aVar != null) {
            aVar.bK();
        }
    }

    public boolean d(String str) {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.d(str);
        }
        return false;
    }

    public boolean e(String str) {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.c(str);
        }
        return false;
    }

    public void a(int i2) {
        a aVar = this.c;
        if (aVar != null) {
            aVar.e(i2);
        }
    }

    public boolean t() {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.aW();
        }
        return false;
    }

    public boolean u() {
        return this.c.be();
    }

    public void v() {
        a aVar = this.c;
        if (aVar != null) {
            aVar.ba();
        }
    }

    public void w() {
        a aVar = this.c;
        if (aVar != null) {
            aVar.bb();
        }
    }

    public void x() {
        a aVar = this.c;
        if (aVar != null) {
            aVar.bc();
        }
    }

    public void a(int i2, int i3) {
        a aVar = this.c;
        if (aVar != null) {
            aVar.a(i2, i3);
        }
    }

    public boolean c(boolean z) {
        return this.c.i(z);
    }

    public void y() {
        this.c.bJ();
    }

    public void z() {
        this.c.bh();
        z(false);
    }

    public void A() {
        this.c.bi();
    }

    public void B() {
        this.c.bj();
        z(true);
    }

    public void b(int i2) {
        com.oppo.camera.e.a("ModeManager", "setCameraId, cameraId: " + this.f2894a + " -> " + i2);
        this.f2894a = i2;
        a aVar = this.c;
        if (aVar != null) {
            aVar.i(i2);
        }
    }

    public void C() {
        a aVar = this.c;
        if (aVar != null) {
            aVar.am();
        }
    }

    public void c(int i2) {
        com.oppo.camera.e.a("ModeManager", "cameraIdChanged, cameraId: " + this.f2894a + " -> " + i2);
        a aVar = this.c;
        if (aVar != null && this.f2894a != -1) {
            this.f2894a = i2;
            aVar.d(i2);
        }
    }

    public void D() {
        a aVar = this.c;
        if (aVar != null) {
            aVar.bN();
        }
    }

    public void E() {
        a aVar = this.c;
        if (aVar != null) {
            aVar.bM();
        }
    }

    public void d(int i2) {
        a aVar = this.c;
        if (aVar != null) {
            aVar.n(i2);
        }
    }

    public boolean e(int i2) {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.r(i2);
        }
        return false;
    }

    public boolean F() {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.W();
        }
        return false;
    }

    public boolean G() {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.X();
        }
        return false;
    }

    public boolean H() {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.c(aVar.cf());
        }
        return false;
    }

    public void a(k kVar) {
        a aVar = this.c;
        if (aVar != null) {
            aVar.a(kVar);
        }
    }

    public void I() {
        a aVar = this.c;
        if (aVar != null) {
            aVar.bO();
        }
    }

    public String J() {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.bS();
        }
        return null;
    }

    public void f(String str) {
        a aVar = this.c;
        if (aVar != null) {
            aVar.l(str);
        }
    }

    public boolean K() {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.bR();
        }
        return false;
    }

    public void b(boolean z, boolean z2) {
        a aVar = this.c;
        if (aVar != null) {
            aVar.d(z, z2);
        }
    }

    public void L() {
        com.oppo.camera.e.a("ModeManager", "displayScreenHint");
        a aVar = this.c;
        if (aVar != null) {
            aVar.eG();
            this.c.eF();
            this.c.cP();
        }
    }

    public void M() {
        a aVar = this.c;
        if (aVar != null) {
            aVar.al();
        }
    }

    public long N() {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.aI();
        }
        return 52428800;
    }

    public boolean O() {
        return this.f && this.c.bn();
    }

    public boolean g(String str) {
        return this.c.h(str);
    }

    public int P() {
        return this.c.bt();
    }

    public String Q() {
        return this.c.bu();
    }

    public boolean R() {
        return this.c.cA();
    }

    public Size a(j jVar) {
        return a(jVar, (String) null);
    }

    public Size a(j jVar, String str) {
        com.oppo.camera.e.a("getPreviewSize");
        a aVar = this.c;
        Size a2 = aVar == null ? null : aVar.a(jVar, str);
        com.oppo.camera.e.b("getPreviewSize");
        return a2;
    }

    public int S() {
        return this.c.fk();
    }

    public Size b(j jVar) {
        return this.c.g(jVar);
    }

    public Size c(j jVar) {
        return this.c.d(jVar);
    }

    public Size d(j jVar) {
        return this.c.f(jVar);
    }

    public boolean T() {
        return this.c.bC();
    }

    public boolean U() {
        return this.c.bD();
    }

    public void d(boolean z) {
        this.c.k(z);
    }

    public boolean V() {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.aR();
        }
        return false;
    }

    public int W() {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.aS();
        }
        return 0;
    }

    public void X() {
        a aVar = this.c;
        if (aVar != null) {
            aVar.y();
        }
    }

    public boolean h(String str) {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.e(str);
        }
        return false;
    }

    public void Y() {
        a aVar = this.c;
        if (aVar != null) {
            aVar.ab();
        }
    }

    public void e(boolean z) {
        a aVar = this.c;
        if (aVar != null) {
            aVar.c(z);
        }
    }

    public boolean i(String str) {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.f(str);
        }
        return false;
    }

    public boolean Z() {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.ac();
        }
        return false;
    }

    public String aa() {
        a aVar = this.c;
        return aVar != null ? aVar.ad() : "full";
    }

    public DcsMsgData a(DcsMsgData dcsMsgData) {
        a aVar = this.c;
        return aVar != null ? aVar.a(dcsMsgData) : dcsMsgData;
    }

    public DcsMsgData a(DcsMsgData dcsMsgData, z.a aVar) {
        a aVar2 = this.c;
        return aVar2 != null ? aVar2.a(dcsMsgData, aVar) : dcsMsgData;
    }

    public void ab() {
        a aVar = this.c;
        if (aVar != null) {
            aVar.an();
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void j(java.lang.String r5) {
        /*
            r4 = this;
            int r0 = r5.hashCode()
            switch(r0) {
                case -1933413040: goto L_0x00f5;
                case -1890252483: goto L_0x00eb;
                case -1482065415: goto L_0x00e0;
                case -1354814997: goto L_0x00d6;
                case -1060049483: goto L_0x00cb;
                case -892483559: goto L_0x00c0;
                case -735775298: goto L_0x00b5;
                case -333683288: goto L_0x00aa;
                case -332860600: goto L_0x009f;
                case -35510913: goto L_0x0094;
                case 103652300: goto L_0x0089;
                case 104087344: goto L_0x007d;
                case 104817688: goto L_0x0072;
                case 325866571: goto L_0x0066;
                case 729267099: goto L_0x005b;
                case 764302074: goto L_0x004f;
                case 875077159: goto L_0x0044;
                case 1069983349: goto L_0x0039;
                case 1373542928: goto L_0x002d;
                case 1638611415: goto L_0x0021;
                case 1704250517: goto L_0x0015;
                case 2138587465: goto L_0x0009;
                default: goto L_0x0007;
            }
        L_0x0007:
            goto L_0x00ff
        L_0x0009:
            java.lang.String r0 = "starVideo"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x00ff
            r5 = 21
            goto L_0x0100
        L_0x0015:
            java.lang.String r0 = "highDefinition"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x00ff
            r5 = 14
            goto L_0x0100
        L_0x0021:
            java.lang.String r0 = "idPhoto"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x00ff
            r5 = 12
            goto L_0x0100
        L_0x002d:
            java.lang.String r0 = "microscope"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x00ff
            r5 = 17
            goto L_0x0100
        L_0x0039:
            java.lang.String r0 = "panorama"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x00ff
            r5 = 2
            goto L_0x0100
        L_0x0044:
            java.lang.String r0 = "professional"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x00ff
            r5 = 3
            goto L_0x0100
        L_0x004f:
            java.lang.String r0 = "slowVideo"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x00ff
            r5 = 9
            goto L_0x0100
        L_0x005b:
            java.lang.String r0 = "portrait"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x00ff
            r5 = 5
            goto L_0x0100
        L_0x0066:
            java.lang.String r0 = "microscopeVideo"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x00ff
            r5 = 18
            goto L_0x0100
        L_0x0072:
            java.lang.String r0 = "night"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x00ff
            r5 = 7
            goto L_0x0100
        L_0x007d:
            java.lang.String r0 = "movie"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x00ff
            r5 = 10
            goto L_0x0100
        L_0x0089:
            java.lang.String r0 = "macro"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x00ff
            r5 = 4
            goto L_0x0100
        L_0x0094:
            java.lang.String r0 = "fastVideo"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x00ff
            r5 = 8
            goto L_0x0100
        L_0x009f:
            java.lang.String r0 = "superText"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x00ff
            r5 = 11
            goto L_0x0100
        L_0x00aa:
            java.lang.String r0 = "ultraHD"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x00ff
            r5 = 13
            goto L_0x0100
        L_0x00b5:
            java.lang.String r0 = "multiCamera"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x00ff
            r5 = 15
            goto L_0x0100
        L_0x00c0:
            java.lang.String r0 = "starry"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x00ff
            r5 = 20
            goto L_0x0100
        L_0x00cb:
            java.lang.String r0 = "double_exposure"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x00ff
            r5 = 19
            goto L_0x0100
        L_0x00d6:
            java.lang.String r0 = "common"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x00ff
            r5 = 0
            goto L_0x0100
        L_0x00e0:
            java.lang.String r0 = "groupshot"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x00ff
            r5 = 16
            goto L_0x0100
        L_0x00eb:
            java.lang.String r0 = "sticker"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x00ff
            r5 = 6
            goto L_0x0100
        L_0x00f5:
            java.lang.String r0 = "commonVideo"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x00ff
            r5 = 1
            goto L_0x0100
        L_0x00ff:
            r5 = -1
        L_0x0100:
            switch(r5) {
                case 0: goto L_0x02f8;
                case 1: goto L_0x02e1;
                case 2: goto L_0x02ca;
                case 3: goto L_0x02b3;
                case 4: goto L_0x029c;
                case 5: goto L_0x0285;
                case 6: goto L_0x026d;
                case 7: goto L_0x0255;
                case 8: goto L_0x023d;
                case 9: goto L_0x0225;
                case 10: goto L_0x020d;
                case 11: goto L_0x01f5;
                case 12: goto L_0x01dd;
                case 13: goto L_0x01c5;
                case 14: goto L_0x01ad;
                case 15: goto L_0x0195;
                case 16: goto L_0x017d;
                case 17: goto L_0x0165;
                case 18: goto L_0x014d;
                case 19: goto L_0x0135;
                case 20: goto L_0x011d;
                case 21: goto L_0x0105;
                default: goto L_0x0103;
            }
        L_0x0103:
            goto L_0x030e
        L_0x0105:
            com.oppo.camera.s.b r5 = new com.oppo.camera.s.b
            android.app.Activity r0 = r4.j
            com.oppo.camera.e.b r1 = r4.k
            com.oppo.camera.ui.e r2 = r4.l
            com.oppo.camera.ui.preview.a.n r3 = r4.m
            r5.<init>(r0, r1, r2, r3)
            java.util.Map<java.lang.String, com.oppo.camera.e.a> r0 = r4.d
            java.lang.String r1 = r5.a()
            r0.put(r1, r5)
            goto L_0x030e
        L_0x011d:
            com.oppo.camera.s.d r5 = new com.oppo.camera.s.d
            android.app.Activity r0 = r4.j
            com.oppo.camera.e.b r1 = r4.k
            com.oppo.camera.ui.e r2 = r4.l
            com.oppo.camera.ui.preview.a.n r3 = r4.m
            r5.<init>(r0, r1, r2, r3)
            java.util.Map<java.lang.String, com.oppo.camera.e.a> r0 = r4.d
            java.lang.String r1 = r5.a()
            r0.put(r1, r5)
            goto L_0x030e
        L_0x0135:
            com.oppo.camera.e.h r5 = new com.oppo.camera.e.h
            android.app.Activity r0 = r4.j
            com.oppo.camera.e.b r1 = r4.k
            com.oppo.camera.ui.e r2 = r4.l
            com.oppo.camera.ui.preview.a.n r3 = r4.m
            r5.<init>(r0, r1, r2, r3)
            java.util.Map<java.lang.String, com.oppo.camera.e.a> r0 = r4.d
            java.lang.String r1 = r5.a()
            r0.put(r1, r5)
            goto L_0x030e
        L_0x014d:
            com.oppo.camera.e.n r5 = new com.oppo.camera.e.n
            android.app.Activity r0 = r4.j
            com.oppo.camera.e.b r1 = r4.k
            com.oppo.camera.ui.e r2 = r4.l
            com.oppo.camera.ui.preview.a.n r3 = r4.m
            r5.<init>(r0, r1, r2, r3)
            java.util.Map<java.lang.String, com.oppo.camera.e.a> r0 = r4.d
            java.lang.String r1 = r5.a()
            r0.put(r1, r5)
            goto L_0x030e
        L_0x0165:
            com.oppo.camera.e.m r5 = new com.oppo.camera.e.m
            android.app.Activity r0 = r4.j
            com.oppo.camera.e.b r1 = r4.k
            com.oppo.camera.ui.e r2 = r4.l
            com.oppo.camera.ui.preview.a.n r3 = r4.m
            r5.<init>(r0, r1, r2, r3)
            java.util.Map<java.lang.String, com.oppo.camera.e.a> r0 = r4.d
            java.lang.String r1 = r5.a()
            r0.put(r1, r5)
            goto L_0x030e
        L_0x017d:
            com.oppo.camera.e.i r5 = new com.oppo.camera.e.i
            android.app.Activity r0 = r4.j
            com.oppo.camera.e.b r1 = r4.k
            com.oppo.camera.ui.e r2 = r4.l
            com.oppo.camera.ui.preview.a.n r3 = r4.m
            r5.<init>(r0, r1, r2, r3)
            java.util.Map<java.lang.String, com.oppo.camera.e.a> r0 = r4.d
            java.lang.String r1 = r5.a()
            r0.put(r1, r5)
            goto L_0x030e
        L_0x0195:
            com.oppo.camera.e.p r5 = new com.oppo.camera.e.p
            android.app.Activity r0 = r4.j
            com.oppo.camera.e.b r1 = r4.k
            com.oppo.camera.ui.e r2 = r4.l
            com.oppo.camera.ui.preview.a.n r3 = r4.m
            r5.<init>(r0, r1, r2, r3)
            java.util.Map<java.lang.String, com.oppo.camera.e.a> r0 = r4.d
            java.lang.String r1 = r5.a()
            r0.put(r1, r5)
            goto L_0x030e
        L_0x01ad:
            com.oppo.camera.e.j r5 = new com.oppo.camera.e.j
            android.app.Activity r0 = r4.j
            com.oppo.camera.e.b r1 = r4.k
            com.oppo.camera.ui.e r2 = r4.l
            com.oppo.camera.ui.preview.a.n r3 = r4.m
            r5.<init>(r0, r1, r2, r3)
            java.util.Map<java.lang.String, com.oppo.camera.e.a> r0 = r4.d
            java.lang.String r1 = r5.a()
            r0.put(r1, r5)
            goto L_0x030e
        L_0x01c5:
            com.oppo.camera.e.t r5 = new com.oppo.camera.e.t
            android.app.Activity r0 = r4.j
            com.oppo.camera.e.b r1 = r4.k
            com.oppo.camera.ui.e r2 = r4.l
            com.oppo.camera.ui.preview.a.n r3 = r4.m
            r5.<init>(r0, r1, r2, r3)
            java.util.Map<java.lang.String, com.oppo.camera.e.a> r0 = r4.d
            java.lang.String r1 = r5.a()
            r0.put(r1, r5)
            goto L_0x030e
        L_0x01dd:
            com.oppo.camera.e.k r5 = new com.oppo.camera.e.k
            android.app.Activity r0 = r4.j
            com.oppo.camera.e.b r1 = r4.k
            com.oppo.camera.ui.e r2 = r4.l
            com.oppo.camera.ui.preview.a.n r3 = r4.m
            r5.<init>(r0, r1, r2, r3)
            java.util.Map<java.lang.String, com.oppo.camera.e.a> r0 = r4.d
            java.lang.String r1 = r5.a()
            r0.put(r1, r5)
            goto L_0x030e
        L_0x01f5:
            com.oppo.camera.e.s r5 = new com.oppo.camera.e.s
            android.app.Activity r0 = r4.j
            com.oppo.camera.e.b r1 = r4.k
            com.oppo.camera.ui.e r2 = r4.l
            com.oppo.camera.ui.preview.a.n r3 = r4.m
            r5.<init>(r0, r1, r2, r3)
            java.util.Map<java.lang.String, com.oppo.camera.e.a> r0 = r4.d
            java.lang.String r1 = r5.a()
            r0.put(r1, r5)
            goto L_0x030e
        L_0x020d:
            com.oppo.camera.j.t r5 = new com.oppo.camera.j.t
            android.app.Activity r0 = r4.j
            com.oppo.camera.e.b r1 = r4.k
            com.oppo.camera.ui.e r2 = r4.l
            com.oppo.camera.ui.preview.a.n r3 = r4.m
            r5.<init>(r0, r1, r2, r3)
            java.util.Map<java.lang.String, com.oppo.camera.e.a> r0 = r4.d
            java.lang.String r1 = r5.a()
            r0.put(r1, r5)
            goto L_0x030e
        L_0x0225:
            com.oppo.camera.r.g r5 = new com.oppo.camera.r.g
            android.app.Activity r0 = r4.j
            com.oppo.camera.e.b r1 = r4.k
            com.oppo.camera.ui.e r2 = r4.l
            com.oppo.camera.ui.preview.a.n r3 = r4.m
            r5.<init>(r0, r1, r2, r3)
            java.util.Map<java.lang.String, com.oppo.camera.e.a> r0 = r4.d
            java.lang.String r1 = r5.a()
            r0.put(r1, r5)
            goto L_0x030e
        L_0x023d:
            com.oppo.camera.i.a r5 = new com.oppo.camera.i.a
            android.app.Activity r0 = r4.j
            com.oppo.camera.e.b r1 = r4.k
            com.oppo.camera.ui.e r2 = r4.l
            com.oppo.camera.ui.preview.a.n r3 = r4.m
            r5.<init>(r0, r1, r2, r3)
            java.util.Map<java.lang.String, com.oppo.camera.e.a> r0 = r4.d
            java.lang.String r1 = r5.a()
            r0.put(r1, r5)
            goto L_0x030e
        L_0x0255:
            com.oppo.camera.e.q r5 = new com.oppo.camera.e.q
            android.app.Activity r0 = r4.j
            com.oppo.camera.e.b r1 = r4.k
            com.oppo.camera.ui.e r2 = r4.l
            com.oppo.camera.ui.preview.a.n r3 = r4.m
            r5.<init>(r0, r1, r2, r3)
            java.util.Map<java.lang.String, com.oppo.camera.e.a> r0 = r4.d
            java.lang.String r1 = r5.a()
            r0.put(r1, r5)
            goto L_0x030e
        L_0x026d:
            com.oppo.camera.e.r r5 = new com.oppo.camera.e.r
            android.app.Activity r0 = r4.j
            com.oppo.camera.e.b r1 = r4.k
            com.oppo.camera.ui.e r2 = r4.l
            com.oppo.camera.ui.preview.a.n r3 = r4.m
            r5.<init>(r0, r1, r2, r3)
            java.util.Map<java.lang.String, com.oppo.camera.e.a> r0 = r4.d
            java.lang.String r1 = r5.a()
            r0.put(r1, r5)
            goto L_0x030e
        L_0x0285:
            com.oppo.camera.o.a r5 = new com.oppo.camera.o.a
            android.app.Activity r0 = r4.j
            com.oppo.camera.e.b r1 = r4.k
            com.oppo.camera.ui.e r2 = r4.l
            com.oppo.camera.ui.preview.a.n r3 = r4.m
            r5.<init>(r0, r1, r2, r3)
            java.util.Map<java.lang.String, com.oppo.camera.e.a> r0 = r4.d
            java.lang.String r1 = r5.a()
            r0.put(r1, r5)
            goto L_0x030e
        L_0x029c:
            com.oppo.camera.e.l r5 = new com.oppo.camera.e.l
            android.app.Activity r0 = r4.j
            com.oppo.camera.e.b r1 = r4.k
            com.oppo.camera.ui.e r2 = r4.l
            com.oppo.camera.ui.preview.a.n r3 = r4.m
            r5.<init>(r0, r1, r2, r3)
            java.util.Map<java.lang.String, com.oppo.camera.e.a> r0 = r4.d
            java.lang.String r1 = r5.a()
            r0.put(r1, r5)
            goto L_0x030e
        L_0x02b3:
            com.oppo.camera.professional.k r5 = new com.oppo.camera.professional.k
            android.app.Activity r0 = r4.j
            com.oppo.camera.e.b r1 = r4.k
            com.oppo.camera.ui.e r2 = r4.l
            com.oppo.camera.ui.preview.a.n r3 = r4.m
            r5.<init>(r0, r1, r2, r3)
            java.util.Map<java.lang.String, com.oppo.camera.e.a> r0 = r4.d
            java.lang.String r1 = r5.a()
            r0.put(r1, r5)
            goto L_0x030e
        L_0x02ca:
            com.oppo.camera.panorama.f r5 = new com.oppo.camera.panorama.f
            android.app.Activity r0 = r4.j
            com.oppo.camera.e.b r1 = r4.k
            com.oppo.camera.ui.e r2 = r4.l
            com.oppo.camera.ui.preview.a.n r3 = r4.m
            r5.<init>(r0, r1, r2, r3)
            java.util.Map<java.lang.String, com.oppo.camera.e.a> r0 = r4.d
            java.lang.String r1 = r5.a()
            r0.put(r1, r5)
            goto L_0x030e
        L_0x02e1:
            com.oppo.camera.e.f r5 = new com.oppo.camera.e.f
            android.app.Activity r0 = r4.j
            com.oppo.camera.e.b r1 = r4.k
            com.oppo.camera.ui.e r2 = r4.l
            com.oppo.camera.ui.preview.a.n r3 = r4.m
            r5.<init>(r0, r1, r2, r3)
            java.util.Map<java.lang.String, com.oppo.camera.e.a> r0 = r4.d
            java.lang.String r1 = r5.a()
            r0.put(r1, r5)
            goto L_0x030e
        L_0x02f8:
            com.oppo.camera.e.e r5 = new com.oppo.camera.e.e
            android.app.Activity r0 = r4.j
            com.oppo.camera.e.b r1 = r4.k
            com.oppo.camera.ui.e r2 = r4.l
            com.oppo.camera.ui.preview.a.n r3 = r4.m
            r5.<init>(r0, r1, r2, r3)
            java.util.Map<java.lang.String, com.oppo.camera.e.a> r0 = r4.d
            java.lang.String r1 = r5.a()
            r0.put(r1, r5)
        L_0x030e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.e.o.j(java.lang.String):void");
    }

    public boolean ac() {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.dt();
        }
        return false;
    }

    public void f(boolean z) {
        a aVar = this.c;
        if (aVar != null) {
            aVar.d(z);
        }
    }

    public void ad() {
        a aVar = this.c;
        if (aVar != null) {
            aVar.ap();
        }
    }

    public void ae() {
        a aVar = this.c;
        if (aVar != null) {
            aVar.aq();
        }
    }

    public void af() {
        a aVar = this.c;
        if (aVar != null) {
            aVar.as();
        }
    }

    public String ag() {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.bz();
        }
        return null;
    }

    public void ah() {
        synchronized (this) {
            if (this.d != null) {
                for (String str : this.d.keySet()) {
                    a aVar = this.d.get(str);
                    if (aVar != null) {
                        aVar.ar();
                    }
                }
                this.d.clear();
                this.f = false;
                this.d = null;
                this.c = null;
            }
        }
        this.j = null;
    }

    private void dq() {
        if (this.f2895b != this.c.X.s()) {
            this.f2895b = this.c.X.s();
            a(this.f2895b);
        }
    }

    private void z(boolean z) {
        if (z) {
            dq();
        }
    }

    public boolean ai() {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.ci();
        }
        return true;
    }

    public boolean aj() {
        return this.c.ag();
    }

    public boolean ak() {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.cV();
        }
        return false;
    }

    public boolean al() {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.cW();
        }
        return true;
    }

    public boolean am() {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.cX();
        }
        return false;
    }

    public int an() {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.cY();
        }
        return 0;
    }

    public void ao() {
        this.c.cZ();
    }

    public void a(int i2, boolean z) {
        a aVar = this.c;
        if (aVar != null) {
            aVar.b(i2, z);
        }
    }

    public void ap() {
        a aVar = this.c;
        if (aVar != null) {
            aVar.cv();
        }
    }

    public void f(int i2) {
        a aVar = this.c;
        if (aVar != null) {
            aVar.s(i2);
        }
    }

    public int aq() {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.eb();
        }
        return 1;
    }

    public void ar() {
        com.oppo.camera.e.a("initBaseModeMap");
        if (this.d == null) {
            com.oppo.camera.e.e("ModeManager", "initBaseModeMap, mBaseModeMap is null!");
            return;
        }
        com.oppo.camera.e.a("ModeManager", "initBaseModeMap, mBaseModeList Size: " + this.d.size());
        if (!this.k.m()) {
            if (this.d.get(ApsConstant.CAPTURE_MODE_COMMON) == null) {
                e eVar = new e(this.j, this.k, this.l, this.m);
                this.d.put(eVar.a(), eVar);
            }
            if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_PORTRAIT) && this.d.get("portrait") == null) {
                a aVar = new a(this.j, this.k, this.l, this.m);
                this.d.put(aVar.a(), aVar);
            }
            if (this.k.j()) {
                if (this.d.get(ApsConstant.REC_MODE_COMMON) == null) {
                    f fVar = new f(this.j, this.k, this.l, this.m);
                    this.d.put(fVar.a(), fVar);
                }
                if (this.d.get(ApsConstant.CAPTURE_MODE_PANORAMA) == null) {
                    com.oppo.camera.panorama.f fVar2 = new com.oppo.camera.panorama.f(this.j, this.k, this.l, this.m);
                    this.d.put(fVar2.a(), fVar2);
                }
                if (this.d.get(ApsConstant.REC_MODE_FAST_VIDEO) == null) {
                    com.oppo.camera.i.a aVar2 = new com.oppo.camera.i.a(this.j, this.k, this.l, this.m);
                    this.d.put(aVar2.a(), aVar2);
                }
                if (this.d.get(ApsConstant.REC_MODE_SLOW_VIDEO) == null && CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_SLOW_VIDEO)) {
                    g gVar = new g(this.j, this.k, this.l, this.m);
                    this.d.put(gVar.a(), gVar);
                }
                if (this.d.get(ApsConstant.CAPTURE_MODE_MULTI_VIDEO) == null && CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_MULTI_VIDEO_MODE_SUPPORT)) {
                    p pVar = new p(this.j, this.k, this.l, this.m);
                    this.d.put(pVar.a(), pVar);
                }
                if (this.d.get("movie") == null && CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_SLOW_VIDEO)) {
                    t tVar = new t(this.j, this.k, this.l, this.m);
                    this.d.put(tVar.a(), tVar);
                }
                if (this.d.get(ApsConstant.CAPTURE_MODE_PROFESSIONAL) == null) {
                    com.oppo.camera.professional.k kVar = new com.oppo.camera.professional.k(this.j, this.k, this.l, this.m);
                    this.d.put(kVar.a(), kVar);
                }
                if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_STICKER) && this.d.get(ApsConstant.CAPTURE_MODE_STICKER) == null) {
                    r rVar = new r(this.j, this.k, this.l, this.m);
                    this.d.put(rVar.a(), rVar);
                }
                if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_NIGHT)) {
                    q qVar = new q(this.j, this.k, this.l, this.m);
                    this.d.put(qVar.a(), qVar);
                }
                if (this.d.get(ApsConstant.CAPTURE_MODE_MACRO) == null && CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_MACRO_MODE)) {
                    l lVar = new l(this.j, this.k, this.l, this.m);
                    this.d.put(lVar.a(), lVar);
                }
                if (this.d.get("superText") == null) {
                    s sVar = new s(this.j, this.k, this.l, this.m);
                    this.d.put(sVar.a(), sVar);
                }
                if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_ID_PHOTO) && this.d.get(ApsConstant.CAPTURE_MODE_ID_PHOTO) == null) {
                    Util.o(this.j);
                }
                if (this.d.get(ApsConstant.CAPTURE_MODE_ULTRA_HIGH_RESOLUTION) == null) {
                    t tVar2 = new t(this.j, this.k, this.l, this.m);
                    this.d.put(tVar2.a(), tVar2);
                }
                if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_HIGH_DEFINITION) && this.d.get(ApsConstant.CAPTURE_MODE_HIGH_DEFINITION) == null) {
                    j jVar = new j(this.j, this.k, this.l, this.m);
                    this.d.put(jVar.a(), jVar);
                }
                if (this.d.get(ApsConstant.CAPTURE_MODE_GROUP_SHOT) == null) {
                    i iVar = new i(this.j, this.k, this.l, this.m);
                    this.d.put(iVar.a(), iVar);
                }
                if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_MICROSCOPE_SUPPORT) && this.d.get(ApsConstant.CAPTURE_MODE_MICROSCOPE) == null) {
                    m mVar = new m(this.j, this.k, this.l, this.m);
                    this.d.put(mVar.a(), mVar);
                }
                if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_MICROSCOPE_SUPPORT) && this.d.get(ApsConstant.REC_MODE_MICROSCOPE) == null) {
                    n nVar = new n(this.j, this.k, this.l, this.m);
                    this.d.put(nVar.a(), nVar);
                }
                if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_DOUBLE_EXPOSURE_SUPPORT) && this.d.get(ApsConstant.REC_MODE_DOUBLE_EXPOSURE) == null) {
                    h hVar = new h(this.j, this.k, this.l, this.m);
                    this.d.put(hVar.a(), hVar);
                }
                if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_STARRY_MODE) && this.d.get(ApsConstant.CAPTURE_MODE_STARRY) == null) {
                    d dVar = new d(this.j, this.k, this.l, this.m);
                    this.d.put(dVar.a(), dVar);
                }
                if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_STARRY_MODE) && CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_STAR_VIDEO) && this.d.get(ApsConstant.REC_MODE_STAR_VIDEO) == null) {
                    b bVar = new b(this.j, this.k, this.l, this.m);
                    this.d.put(bVar.a(), bVar);
                }
            }
        } else if (this.d.get(ApsConstant.REC_MODE_COMMON) == null) {
            f fVar3 = new f(this.j, this.k, this.l, this.m);
            this.d.put(fVar3.a(), fVar3);
        }
        this.f = true;
        com.oppo.camera.e.b("initBaseModeMap");
        com.oppo.camera.e.a("ModeManager", "initBaseModeMap X, mBaseModeList Size: " + this.d.size());
    }

    public synchronized boolean b(int i2, String str) {
        if (str == null) {
            com.oppo.camera.e.e("ModeManager", "getPluginEnabled ,mode-string or mPlugins is null,so return");
            return false;
        } else if (!this.d.containsKey(str)) {
            return false;
        } else {
            a aVar = this.d.get(str);
            if (com.oppo.camera.f.a.c(i2)) {
                return aVar.d();
            }
            return aVar.f();
        }
    }

    public void as() {
        a aVar = this.c;
        if (aVar != null) {
            aVar.dx();
        }
    }

    public void a(SharedPreferences sharedPreferences, String str) {
        this.c.a(sharedPreferences, str);
    }

    public boolean at() {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.cj();
        }
        return false;
    }

    public boolean au() {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.dw();
        }
        return false;
    }

    public void g(boolean z) {
        a aVar = this.c;
        if (aVar != null) {
            aVar.g(z);
        }
    }

    public boolean av() {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.cm();
        }
        return false;
    }

    public boolean aw() {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.cl();
        }
        return false;
    }

    public boolean ax() {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.ct();
        }
        return false;
    }

    public boolean ay() {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.cz();
        }
        return false;
    }

    public boolean az() {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.F();
        }
        return false;
    }

    public void a(CaptureRequest.Builder builder, int i2, int i3, String[] strArr) {
        a aVar = this.c;
        if (aVar != null) {
            aVar.a(builder, i2, i3, strArr);
        }
    }

    public void b(int i2, boolean z) {
        a aVar = this.c;
        if (aVar != null) {
            aVar.c(i2, z);
        }
    }

    public void k(String str) {
        a aVar = this.c;
        if (aVar != null) {
            aVar.o(str);
        }
    }

    public void aA() {
        a aVar = this.c;
        if (aVar != null) {
            aVar.dC();
        }
    }

    public void a(TiltShiftParam tiltShiftParam) {
        a aVar = this.c;
        if (aVar != null) {
            aVar.a(tiltShiftParam);
        }
    }

    public boolean aB() {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.dz();
        }
        return false;
    }

    public boolean aC() {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.dA();
        }
        return false;
    }

    public void h(boolean z) {
        this.h = z;
        a aVar = this.c;
        if (aVar != null) {
            aVar.n(z);
        }
    }

    public void i(boolean z) {
        a aVar = this.c;
        if (aVar != null) {
            aVar.o(z);
        }
    }

    public void j(boolean z) {
        this.g = z;
        a aVar = this.c;
        if (aVar != null) {
            aVar.p(z);
        }
    }

    public void k(boolean z) {
        a aVar = this.c;
        if (aVar != null) {
            aVar.q(z);
        }
    }

    public void aD() {
        a aVar = this.c;
        if (aVar != null) {
            aVar.dF();
        }
    }

    public void aE() {
        a aVar = this.c;
        if (aVar != null) {
            aVar.dG();
        }
    }

    public void aF() {
        a aVar = this.c;
        if (aVar != null) {
            aVar.dH();
        }
    }

    public void aG() {
        a aVar = this.c;
        if (aVar != null) {
            aVar.dI();
        }
    }

    public void aH() {
        a aVar = this.c;
        if (aVar != null) {
            aVar.dJ();
        }
    }

    public boolean aI() {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.dK();
        }
        return false;
    }

    public boolean aJ() {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.dL();
        }
        return false;
    }

    public boolean aK() {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.dM();
        }
        return false;
    }

    public boolean aL() {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.dN();
        }
        return false;
    }

    public boolean aM() {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.dO();
        }
        return false;
    }

    public boolean aN() {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.dP();
        }
        return true;
    }

    public boolean aO() {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.dQ();
        }
        return false;
    }

    public void l(boolean z) {
        a aVar = this.c;
        if (aVar != null) {
            aVar.r(z);
        }
    }

    public boolean aP() {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.dR();
        }
        return false;
    }

    public boolean aQ() {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.dS();
        }
        return false;
    }

    public Bitmap g(int i2) {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.u(i2);
        }
        return null;
    }

    public CameraStatisticsUtil.MakerNote aR() {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.dY();
        }
        return null;
    }

    public long aS() {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.dZ();
        }
        return 0;
    }

    public void h(int i2) {
        a aVar = this.c;
        if (aVar != null) {
            aVar.v(i2);
        }
    }

    public void aT() {
        a aVar = this.c;
        if (aVar != null) {
            aVar.dT();
        }
    }

    public void m(boolean z) {
        a aVar = this.c;
        if (aVar != null) {
            aVar.s(z);
        }
    }

    public boolean aU() {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.dU();
        }
        return true;
    }

    public boolean aV() {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.dV();
        }
        return false;
    }

    public boolean a(int i2, MotionEvent motionEvent) {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.a(i2, motionEvent);
        }
        return false;
    }

    public boolean aW() {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.bL();
        }
        return false;
    }

    public void aX() {
        a aVar = this.c;
        if (aVar != null) {
            aVar.dW();
        }
    }

    public void aY() {
        a aVar = this.c;
        if (aVar != null) {
            aVar.dX();
        }
    }

    public boolean a(Image image) {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.a(image);
        }
        return true;
    }

    public void a(byte[] bArr, int i2, int i3, int i4, boolean z) {
        a aVar = this.c;
        if (aVar != null) {
            aVar.a(bArr, i2, i3, i4, z);
        }
    }

    public void n(boolean z) {
        a aVar = this.c;
        if (aVar != null) {
            aVar.t(z);
        }
    }

    public void a(ImageReader imageReader) {
        a aVar = this.c;
        if (aVar != null) {
            aVar.a(imageReader);
        }
    }

    public boolean l(String str) {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.r(str);
        }
        return false;
    }

    public boolean aZ() {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.ec();
        }
        return false;
    }

    public boolean ba() {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.ea();
        }
        return true;
    }

    public boolean i(int i2) {
        if (2 == AlgoSwitchConfig.getApsVersion()) {
            return false;
        }
        a aVar = this.c;
        if (aVar != null) {
            return aVar.w(i2);
        }
        return true;
    }

    public boolean bb() {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.br();
        }
        return false;
    }

    public boolean d(MotionEvent motionEvent) {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.d(motionEvent);
        }
        return false;
    }

    public void a(HashMap<String, f.C0084f> hashMap) {
        a aVar = this.c;
        if (aVar != null) {
            aVar.a(hashMap);
        }
    }

    public void bc() {
        a aVar = this.c;
        if (aVar != null) {
            aVar.ed();
        }
    }

    public void a(com.oppo.camera.f.d dVar, CaptureRequest.Builder builder, HashMap<String, f.C0084f> hashMap, int i2) {
        a aVar = this.c;
        if (aVar != null) {
            aVar.a(dVar, builder, hashMap, i2);
        }
    }

    public boolean bd() {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.ee();
        }
        return false;
    }

    public void j(int i2) {
        a aVar = this.c;
        if (aVar != null) {
            aVar.x(i2);
        }
    }

    public int k(int i2) {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.q(i2);
        }
        return 0;
    }

    public boolean be() {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.Z();
        }
        return false;
    }

    public boolean bf() {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.Y();
        }
        return false;
    }

    public boolean bg() {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.cS();
        }
        return false;
    }

    public boolean bh() {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.cT();
        }
        return false;
    }

    public void bi() {
        a aVar = this.c;
        if (aVar != null) {
            aVar.cU();
        }
    }

    public int bj() {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.ef();
        }
        return 0;
    }

    public boolean bk() {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.db();
        }
        return false;
    }

    public int bl() {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.bW();
        }
        return 0;
    }

    public void bm() {
        a aVar = this.c;
        if (aVar != null) {
            aVar.eg();
        }
    }

    public String bn() {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.ei();
        }
        return null;
    }

    public int bo() {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.dj();
        }
        return 0;
    }

    public int l(int i2) {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.y(i2);
        }
        return 0;
    }

    public int bp() {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.bX();
        }
        return 0;
    }

    public boolean bq() {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.cb();
        }
        return false;
    }

    public int br() {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.ao();
        }
        return 0;
    }

    public int bs() {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.bT();
        }
        return 0;
    }

    public void m(int i2) {
        a aVar = this.c;
        if (aVar != null) {
            aVar.l(i2);
        }
    }

    public void bt() {
        a aVar = this.c;
        if (aVar != null) {
            aVar.bU();
        }
    }

    public int n(int i2) {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.j(i2);
        }
        return -100000;
    }

    public int bu() {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.df();
        }
        return 40;
    }

    public int[] bv() {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.dg();
        }
        return com.oppo.camera.d.f2784a;
    }

    public void a(int i2, int i3, boolean z) {
        a aVar = this.c;
        if (aVar != null) {
            aVar.a(i2, i3, z);
        }
    }

    public boolean bw() {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.bV();
        }
        return true;
    }

    public boolean bx() {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.bw();
        }
        return false;
    }

    public boolean by() {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.bx();
        }
        return false;
    }

    public double bz() {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.by();
        }
        return -1.0d;
    }

    public Size a(String str, j jVar) {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.a(str, jVar);
        }
        return null;
    }

    public void o(int i2) {
        a aVar = this.c;
        if (aVar != null) {
            aVar.h(i2);
        }
    }

    public void a(ApsAdapterDecision.DecisionResult decisionResult) {
        a aVar = this.c;
        if (aVar != null) {
            aVar.a(decisionResult);
        }
    }

    public void a(Image image, TotalCaptureResult totalCaptureResult, Rect rect, com.oppo.camera.f.d dVar) {
        a aVar = this.c;
        if (aVar != null) {
            aVar.a(image, totalCaptureResult, rect, dVar);
        }
    }

    public int bA() {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.es();
        }
        return 60;
    }

    public void p(int i2) {
        a aVar = this.c;
        if (aVar != null) {
            aVar.A(i2);
        }
    }

    public void o(boolean z) {
        a aVar = this.c;
        if (aVar != null) {
            aVar.u(z);
        }
    }

    public boolean bB() {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.eu();
        }
        return false;
    }

    public boolean bC() {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.at();
        }
        return false;
    }

    public void bD() {
        a aVar = this.c;
        if (aVar != null) {
            aVar.ev();
        }
    }

    public boolean bE() {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.ew();
        }
        return false;
    }

    public void p(boolean z) {
        a aVar = this.c;
        if (aVar != null) {
            aVar.v(z);
        }
    }

    public void bF() {
        a aVar = this.c;
        if (aVar != null) {
            aVar.L();
        }
    }

    public boolean bG() {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.ck();
        }
        return false;
    }

    public boolean bH() {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.av();
        }
        return false;
    }

    public boolean bI() {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.ax();
        }
        return false;
    }

    public String bJ() {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.eq();
        }
        return null;
    }

    public boolean bK() {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.P();
        }
        return false;
    }

    public boolean bL() {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.cQ();
        }
        return false;
    }

    public boolean bM() {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.cH();
        }
        return false;
    }

    public boolean bN() {
        a aVar = this.c;
        if (aVar == null || !aVar.cG() || !this.c.cI()) {
            return false;
        }
        return true;
    }

    public boolean bO() {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.Q();
        }
        return false;
    }

    public boolean bP() {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.af();
        }
        return false;
    }

    public boolean bQ() {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.ae();
        }
        return false;
    }

    public h.a bR() {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.du();
        }
        return h.a.Polarr;
    }

    public int bS() {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.aQ();
        }
        return 256;
    }

    public Size a(j jVar, double d2) {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.a(jVar, d2);
        }
        return null;
    }

    public boolean bT() {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.ex();
        }
        return false;
    }

    public void bU() {
        a aVar = this.c;
        if (aVar != null) {
            aVar.ey();
        }
    }

    public void bV() {
        a aVar = this.c;
        if (aVar != null) {
            aVar.ez();
        }
    }

    public void bW() {
        a aVar = this.c;
        if (aVar != null) {
            aVar.eA();
        }
    }

    public void m(String str) {
        a aVar = this.c;
        if (aVar != null) {
            aVar.u(str);
        }
    }

    public boolean n(String str) {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.v(str);
        }
        return true;
    }

    public boolean bX() {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.eB();
        }
        return false;
    }

    public boolean bY() {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.eC();
        }
        return false;
    }

    public int bZ() {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.eD();
        }
        return -1;
    }

    public void ca() {
        a aVar = this.c;
        if (aVar != null) {
            aVar.b(true);
        }
    }

    public void cb() {
        a aVar = this.c;
        if (aVar != null) {
            aVar.eE();
        }
    }

    public void cc() {
        a aVar = this.c;
        if (aVar != null) {
            aVar.eH();
        }
    }

    public boolean o(String str) {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.w(str);
        }
        return false;
    }

    public void q(boolean z) {
        a aVar = this.c;
        if (aVar != null) {
            aVar.w(z);
        }
    }

    public ab cd() {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.dl();
        }
        return new ab();
    }

    public boolean a(float f2) {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.a(f2);
        }
        return false;
    }

    public boolean b(float f2) {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.b(f2);
        }
        return false;
    }

    public boolean ce() {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.eI();
        }
        return false;
    }

    public boolean cf() {
        return this.c.eK();
    }

    public void cg() {
        a aVar = this.c;
        if (aVar != null) {
            aVar.eL();
        }
    }

    public void a(com.oppo.camera.t.a aVar) {
        a aVar2 = this.c;
        if (aVar2 != null) {
            aVar2.a(aVar);
        }
    }

    public boolean ch() {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.cn();
        }
        return false;
    }

    public boolean ci() {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.co();
        }
        return false;
    }

    public void cj() {
        a aVar = this.c;
        if (aVar != null) {
            aVar.aC();
        }
    }

    public boolean ck() {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.cr();
        }
        return false;
    }

    public boolean cl() {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.cq();
        }
        return false;
    }

    public void cm() {
        a aVar = this.c;
        if (aVar != null) {
            aVar.dm();
        }
    }

    public void cn() {
        a aVar = this.c;
        if (aVar != null) {
            aVar.eM();
        }
    }

    public void p(String str) {
        a aVar = this.c;
        if (aVar != null) {
            aVar.s(str);
        }
    }

    public void q(String str) {
        a aVar = this.c;
        if (aVar != null) {
            aVar.t(str);
        }
    }

    public boolean co() {
        a aVar = this.c;
        return aVar != null && aVar.eO();
    }

    public int cp() {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.G();
        }
        return 1;
    }

    public int cq() {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.H();
        }
        return 1;
    }

    public ImageCategory.ItemInfoType cr() {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.eR();
        }
        return null;
    }

    public int cs() {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.E();
        }
        return 0;
    }

    public void ct() {
        a aVar = this.c;
        if (aVar != null) {
            aVar.eN();
        }
    }

    public void cu() {
        a aVar = this.c;
        if (aVar != null) {
            aVar.eP();
        }
    }

    public void cv() {
        a aVar = this.c;
        if (aVar != null) {
            aVar.eQ();
        }
    }

    public Surface cw() {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.eS();
        }
        return null;
    }

    public long cx() {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.eU();
        }
        return 3;
    }

    public int cy() {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.m();
        }
        return this.e.e().J();
    }

    public int r(String str) {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.y(str);
        }
        return 35;
    }

    public int s(String str) {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.x(str);
        }
        return 0;
    }

    public e.b cz() {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.aN();
        }
        return null;
    }

    public void a(TotalCaptureResult totalCaptureResult) {
        a aVar = this.c;
        if (aVar != null) {
            aVar.a(totalCaptureResult);
        }
    }

    public boolean cA() {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.eX();
        }
        return false;
    }

    public boolean cB() {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.eo();
        }
        return false;
    }

    public boolean cC() {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.eY();
        }
        return true;
    }

    public boolean cD() {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.aE();
        }
        return false;
    }

    public boolean cE() {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.aF();
        }
        return false;
    }

    public boolean cF() {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.aG();
        }
        return false;
    }

    public void a(String str, boolean z) {
        a aVar = this.c;
        if (aVar != null) {
            aVar.a(str, z);
        }
    }

    public void r(boolean z) {
        a aVar = this.c;
        if (aVar != null) {
            aVar.y(z);
        }
    }

    public Size a(Size size) {
        a aVar = this.c;
        return aVar != null ? aVar.a(size) : size;
    }

    public void cG() {
        a aVar = this.c;
        if (aVar != null) {
            aVar.eZ();
        }
    }

    public boolean cH() {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.dn();
        }
        return false;
    }

    public long cI() {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.m2do();
        }
        return 0;
    }

    public boolean cJ() {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.fa();
        }
        return false;
    }

    public boolean cK() {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.fb();
        }
        return false;
    }

    public boolean cL() {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.fc();
        }
        return false;
    }

    public boolean cM() {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.fd();
        }
        return false;
    }

    public boolean cN() {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.fe();
        }
        return false;
    }

    public boolean cO() {
        a aVar = this.c;
        return aVar != null && aVar.ff();
    }

    public boolean cP() {
        a aVar = this.c;
        return aVar != null && aVar.fg();
    }

    public boolean a(ApsResult apsResult, ApsCameraRequestTag apsCameraRequestTag) {
        a aVar = this.c;
        return aVar != null && aVar.a(apsResult, apsCameraRequestTag);
    }

    public boolean a(ImageCategory.ImageItemInfo imageItemInfo, ImageCategory.MetaItemInfo metaItemInfo) {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.a(imageItemInfo, metaItemInfo);
        }
        return false;
    }

    public boolean cQ() {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.fh();
        }
        return false;
    }

    public void s(boolean z) {
        synchronized (this) {
            if (this.d != null) {
                for (String str : this.d.keySet()) {
                    a aVar = this.d.get(str);
                    if (aVar != null) {
                        aVar.B(z);
                    }
                }
            }
        }
    }

    public String cR() {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.dp();
        }
        return null;
    }

    public void t(boolean z) {
        a aVar = this.c;
        if (aVar != null) {
            aVar.z(z);
        }
    }

    public float cS() {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.fj();
        }
        return 1.0f;
    }

    public boolean b(int i2, int i3) {
        a aVar = this.c;
        return aVar != null && aVar.b(i2, i3);
    }

    public int cT() {
        return this.c.fi();
    }

    public boolean cU() {
        a aVar = this.c;
        return aVar != null && aVar.cM();
    }

    public boolean cV() {
        a aVar = this.c;
        return aVar != null && aVar.er();
    }

    public void cW() {
        a aVar = this.c;
        if (aVar != null) {
            aVar.dr();
        }
    }

    public void q(int i2) {
        a aVar = this.c;
        if (aVar != null) {
            aVar.t(i2);
        }
    }

    public long cX() {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.ds();
        }
        return 0;
    }

    public boolean cY() {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.fm();
        }
        return false;
    }

    public int cZ() {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.fp();
        }
        return -1;
    }

    public long da() {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.fq();
        }
        return -1;
    }

    public void u(boolean z) {
        a aVar = this.c;
        if (aVar != null) {
            aVar.A(z);
        }
    }

    public int[] e(j jVar) {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.b(jVar);
        }
        return null;
    }

    public void r(int i2) {
        a aVar = this.c;
        if (aVar != null) {
            aVar.D(i2);
        }
    }

    public void a(int i2, int i3, boolean z, int i4) {
        a aVar = this.c;
        if (aVar != null) {
            aVar.a(i2, i3, z, i4);
        }
    }

    public com.oppo.camera.e.a.a db() {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.cN();
        }
        return null;
    }

    public void dc() {
        a aVar = this.c;
        if (aVar != null) {
            aVar.dv();
        }
    }

    public synchronized void a(ApsService apsService) {
        if (this.c != null) {
            this.c.a(apsService);
        }
    }

    public boolean dd() {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.fr();
        }
        return false;
    }

    public void de() {
        a aVar = this.c;
        if (aVar != null) {
            aVar.fw();
        }
    }

    public void v(boolean z) {
        a aVar = this.c;
        if (aVar != null) {
            aVar.C(z);
        }
    }

    public boolean df() {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.fx();
        }
        return false;
    }

    public void a(byte[] bArr) {
        a aVar = this.c;
        if (aVar != null) {
            aVar.a(bArr);
        }
    }

    public boolean dg() {
        a aVar = this.c;
        return aVar != null && aVar.K();
    }

    public void a(String str, Object obj, boolean z, boolean z2) {
        Map<String, a> map;
        a aVar = this.c;
        if (aVar != null && (map = this.d) != null && obj != null) {
            if (z) {
                aVar.a(obj, true, z2);
                return;
            }
            a aVar2 = map.get(str);
            if (aVar2 != null) {
                aVar2.a(obj, false, z2);
            }
        }
    }

    public String dh() {
        a aVar = this.c;
        return aVar != null ? aVar.cg() : "key_filter_index";
    }

    public String di() {
        a aVar = this.c;
        return aVar != null ? aVar.ch() : "pref_filter_menu";
    }

    public boolean dj() {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.fs();
        }
        return false;
    }

    public void dk() {
        a aVar = this.c;
        if (aVar != null) {
            aVar.A();
        }
    }

    public void a(com.oppo.camera.doubleexposure.b bVar, g.a aVar) {
        a aVar2 = this.c;
        if (aVar2 != null) {
            aVar2.a(bVar, aVar);
        }
    }

    public void w(boolean z) {
        a aVar = this.c;
        if (aVar != null) {
            aVar.D(z);
        }
    }

    public void s(int i2) {
        a aVar = this.c;
        if (aVar != null) {
            aVar.E(i2);
        }
    }

    public void dl() {
        a aVar = this.c;
        if (aVar != null) {
            aVar.bQ();
        }
    }

    public long dm() {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.fy();
        }
        return 0;
    }

    public boolean dn() {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.fz();
        }
        return true;
    }

    /* renamed from: do  reason: not valid java name */
    public boolean m6do() {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.fA();
        }
        return false;
    }

    public void x(boolean z) {
        a aVar = this.c;
        if (aVar != null) {
            aVar.E(z);
        }
    }

    public boolean dp() {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.fB();
        }
        return true;
    }

    public void y(boolean z) {
        a aVar = this.c;
        if (aVar != null) {
            aVar.F(z);
        }
    }
}
