package com.oppo.camera.e;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.PointF;
import android.graphics.Rect;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.media.CamcorderProfile;
import android.media.Image;
import android.media.ImageReader;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import android.util.Range;
import android.util.Size;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.ViewGroup;
import co.polarr.renderer.FilterPackageUtil;
import com.oppo.camera.Camera;
import com.oppo.camera.R;
import com.oppo.camera.a;
import com.oppo.camera.ab;
import com.oppo.camera.aps.ApsCameraRequestTag;
import com.oppo.camera.aps.adapter.ApsAdapterDecision;
import com.oppo.camera.aps.adapter.ApsCaptureResult;
import com.oppo.camera.aps.adapter.ApsParameters;
import com.oppo.camera.aps.adapter.ApsResult;
import com.oppo.camera.aps.adapter.ApsTotalResult;
import com.oppo.camera.aps.adapter.ApsWatermarkParam;
import com.oppo.camera.aps.adapter.ImageCategory;
import com.oppo.camera.aps.config.AlgoSwitchConfig;
import com.oppo.camera.aps.config.CameraConfig;
import com.oppo.camera.aps.config.CameraFunction;
import com.oppo.camera.aps.config.ConfigDataBase;
import com.oppo.camera.aps.constant.ParameterKeys;
import com.oppo.camera.aps.service.ApsAdapterListener;
import com.oppo.camera.aps.service.ApsService;
import com.oppo.camera.aps.service.ThumbnailItem;
import com.oppo.camera.aps.service.ThumbnailProcessor;
import com.oppo.camera.d;
import com.oppo.camera.doubleexposure.g;
import com.oppo.camera.entry.b;
import com.oppo.camera.f.d;
import com.oppo.camera.f.f;
import com.oppo.camera.f.h;
import com.oppo.camera.f.j;
import com.oppo.camera.gl.t;
import com.oppo.camera.statistics.CameraStatisticsUtil;
import com.oppo.camera.statistics.model.CaptureMsgData;
import com.oppo.camera.statistics.model.DcsMsgData;
import com.oppo.camera.statistics.model.FocusAimMsgData;
import com.oppo.camera.statistics.model.MenuClickMsgData;
import com.oppo.camera.statistics.model.PerformanceMsgData;
import com.oppo.camera.tiltshift.TiltShiftParam;
import com.oppo.camera.ui.control.c;
import com.oppo.camera.ui.control.e;
import com.oppo.camera.ui.e;
import com.oppo.camera.ui.inverse.c;
import com.oppo.camera.ui.preview.a.h;
import com.oppo.camera.ui.preview.a.k;
import com.oppo.camera.ui.preview.a.n;
import com.oppo.camera.ui.preview.a.v;
import com.oppo.camera.ui.preview.a.w;
import com.oppo.camera.ui.preview.a.x;
import com.oppo.camera.util.Util;
import com.oppo.camera.z;
import com.oppo.exif.OppoExifTag;
import java.math.BigDecimal;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: BaseMode */
public abstract class a implements ApsAdapterListener.CaptureCallback, d, f.a {
    private static boolean at = true;
    private static boolean au = true;
    public static final String[] d = {"pref_camera_photo_ratio_key", "pref_camera_flashmode_key"};
    protected static boolean h = false;
    protected boolean A = false;
    protected boolean B = false;
    protected boolean C = false;
    protected boolean D = false;
    protected boolean E = false;
    protected boolean F = false;
    protected boolean G = true;
    protected boolean H;
    protected boolean I = false;
    protected boolean J = false;
    protected boolean K = true;
    protected boolean L = false;
    protected boolean M = false;
    protected boolean N = false;
    protected boolean O = false;
    protected boolean P = false;
    protected boolean Q = false;
    protected boolean R = false;
    protected boolean S = false;
    protected boolean T = false;
    protected String U = "off";
    protected String V = "off";
    protected f W = null;
    protected b X = null;
    /* access modifiers changed from: protected */
    public e Y = null;
    protected Activity Z = null;
    /* access modifiers changed from: private */
    public ThumbnailProcessor.DataRequest aA = null;
    /* access modifiers changed from: private */
    public String aB = null;
    private int aC = 0;
    /* access modifiers changed from: private */
    public long aD = 0;
    private long aE = 0;
    private int aF = 0;
    /* access modifiers changed from: private */
    public Handler aG = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message message) {
            if (message == null) {
                com.oppo.camera.e.e("BaseMode", "handleMessage, msg is null");
                return;
            }
            com.oppo.camera.e.c("BaseMode", "handleMessage, msg is: " + a.this.G(message.what));
            switch (message.what) {
                case 1:
                    Bundle data = message.getData();
                    if (data != null) {
                        int intValue = ((Integer) data.get("picture_width")).intValue();
                        int intValue2 = ((Integer) data.get("picture_height")).intValue();
                        int intValue3 = ((Integer) data.get("picture_format")).intValue();
                        boolean booleanValue = ((Boolean) data.get("is_burst_shot")).booleanValue();
                        a.this.b((byte[]) data.get("picture_data"), intValue, intValue2, intValue3, booleanValue);
                        return;
                    }
                    return;
                case 2:
                    a.this.cP();
                    return;
                case 3:
                    a.this.fG();
                    return;
                case 4:
                    a.this.bQ();
                    return;
                case 5:
                    a.this.b((k) message.obj);
                    return;
                case 6:
                    a.this.Y.a((com.oppo.camera.ui.control.e) message.obj, 1);
                    return;
                case 7:
                    if (!a.this.y && a.this.Y != null && !a.this.Y.as()) {
                        a.this.B();
                        return;
                    }
                    return;
                case 8:
                    if (!a.this.y) {
                        a.this.z();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    };
    /* access modifiers changed from: protected */
    public SharedPreferences aa = null;
    protected n ab = null;
    protected ViewGroup ac = null;
    protected List<String> ad = null;
    protected String ae = "beauty";
    protected ApsAdapterDecision.DecisionResult af = null;
    protected com.oppo.camera.t.a ag = null;
    protected int ah = 0;
    protected AlgoSwitchConfig.PreviewConfig ai = null;
    protected ApsService aj = null;
    protected b ak = null;
    protected Integer al = 1;
    protected boolean am = false;
    protected boolean an = false;
    protected int ao = 0;
    protected int ap = 0;
    protected long aq = 0;
    protected int ar = 0;
    protected int as = 1;
    private final Object av = new Object();
    private boolean aw = false;
    private boolean ax = false;
    private boolean ay = false;
    private int az = 0;
    public boolean e = false;
    public int[] f = null;
    public float g = 1.0f;
    protected final Object i = new Object();
    protected final Object j = new Object();
    protected int k = 0;
    protected int l;
    protected int m = 0;
    protected int n = 0;
    protected int o = 0;
    protected int p = 0;
    protected int q = 1;
    protected int r = 0;
    protected int s = 0;
    protected boolean t = false;
    protected boolean u = false;
    protected boolean v;
    protected boolean w = false;
    protected boolean x = false;
    protected volatile boolean y = false;
    protected volatile boolean z = false;

    /* renamed from: com.oppo.camera.e.a$a  reason: collision with other inner class name */
    /* compiled from: BaseMode */
    protected enum C0080a {
        INPUT,
        OUTPUT
    }

    /* access modifiers changed from: private */
    public String G(int i2) {
        switch (i2) {
            case 1:
                return "MSG_AFTER_TAKEPICTURE";
            case 2:
                return "MSG_DIS_SCREEN_HINT_ICON";
            case 3:
                return "MSG_AFTER_START_PREVIEW";
            case 4:
                return "MSG_UPDATE_EFFECT_MENUNAME";
            case 5:
                return "MSG_CREATE_EFFECT_TEXTURE";
            case 6:
                return "MSG_PRE_UPDATE_THUMBNAIL";
            default:
                return null;
        }
    }

    private boolean a(int i2, int i3, int i4, int i5, int i6, int i7) {
        return (i2 == 0 || i6 == 0 || i2 == i6 || i3 == 0 || i7 == 0 || i3 == i7 || i4 == 0 || i5 == 0) ? false : true;
    }

    /* access modifiers changed from: protected */
    public int B(int i2) {
        return 0;
    }

    public void B(boolean z2) {
    }

    public void C(boolean z2) {
    }

    /* access modifiers changed from: protected */
    public boolean C(int i2) {
        return false;
    }

    public int D() {
        return 20;
    }

    public void D(int i2) {
    }

    public void D(boolean z2) {
    }

    public int E() {
        return 0;
    }

    public void E(int i2) {
    }

    public void F(boolean z2) {
    }

    public boolean F() {
        return true;
    }

    public int G() {
        return 1;
    }

    public boolean I() {
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean J() {
        return false;
    }

    /* access modifiers changed from: protected */
    public f.a O() {
        return this;
    }

    /* access modifiers changed from: protected */
    public boolean P() {
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean Q() {
        return false;
    }

    public void S() {
    }

    public int[] U() {
        return null;
    }

    public void V() {
    }

    public boolean W() {
        return false;
    }

    public boolean X() {
        return false;
    }

    public boolean Y() {
        return false;
    }

    public boolean Z() {
        return false;
    }

    public Size a(Size size) {
        return size;
    }

    public abstract String a();

    public void a(int i2, int i3) {
    }

    public void a(int i2, int i3, boolean z2, int i4) {
    }

    public void a(ImageReader imageReader) {
    }

    public void a(ApsCaptureResult apsCaptureResult, ImageCategory.MetaItemInfo metaItemInfo) {
    }

    public void a(ThumbnailItem thumbnailItem) {
    }

    public void a(com.oppo.camera.doubleexposure.b bVar, g.a aVar) {
    }

    public void a(Object obj, boolean z2, boolean z3) {
    }

    public void a(String str) {
    }

    public void a(HashMap<String, f.C0084f> hashMap) {
    }

    /* access modifiers changed from: protected */
    public void a(boolean z2) {
    }

    public void a(byte[] bArr) {
    }

    /* access modifiers changed from: protected */
    public abstract void a(byte[] bArr, boolean z2);

    public boolean a(int i2, MotionEvent motionEvent) {
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean a(Image image) {
        return true;
    }

    public boolean a(MotionEvent motionEvent) {
        return false;
    }

    public boolean a(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        return false;
    }

    public boolean a(ApsResult apsResult, ApsCameraRequestTag apsCameraRequestTag) {
        return false;
    }

    public boolean a(ImageCategory.ImageItemInfo imageItemInfo, ImageCategory.MetaItemInfo metaItemInfo) {
        return false;
    }

    /* access modifiers changed from: protected */
    public abstract boolean a(com.oppo.camera.f.d dVar);

    public boolean a(boolean z2, boolean z3) {
        return true;
    }

    /* access modifiers changed from: protected */
    public int aB() {
        return 0;
    }

    public boolean aE() {
        return false;
    }

    public boolean aF() {
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean aG() {
        return false;
    }

    public int aH() {
        return 0;
    }

    /* access modifiers changed from: protected */
    public boolean aJ() {
        return false;
    }

    /* access modifiers changed from: protected */
    public long aK() {
        return 0;
    }

    public boolean aM() {
        return true;
    }

    /* access modifiers changed from: protected */
    public e.b aN() {
        return null;
    }

    /* access modifiers changed from: protected */
    public boolean aO() {
        return false;
    }

    public boolean aP() {
        return true;
    }

    public int aQ() {
        return 256;
    }

    public boolean aR() {
        return true;
    }

    public int aS() {
        return 0;
    }

    /* access modifiers changed from: protected */
    public boolean aT() {
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean aU() {
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean aV() {
        return false;
    }

    /* access modifiers changed from: protected */
    public void aX() {
    }

    /* access modifiers changed from: protected */
    public void aY() {
    }

    /* access modifiers changed from: protected */
    public boolean aZ() {
        return true;
    }

    public boolean aa() {
        return true;
    }

    public String ad() {
        return "full";
    }

    public boolean af() {
        return false;
    }

    public void ak() {
    }

    public void an() {
    }

    public int ao() {
        return 0;
    }

    public final void as() {
    }

    public boolean au() {
        return false;
    }

    public boolean av() {
        return false;
    }

    public boolean ax() {
        return true;
    }

    public DcsMsgData b(DcsMsgData dcsMsgData) {
        return dcsMsgData;
    }

    public DcsMsgData b(DcsMsgData dcsMsgData, z.a aVar) {
        return dcsMsgData;
    }

    public String b() {
        return null;
    }

    public void b(int i2, boolean z2) {
    }

    /* access modifiers changed from: protected */
    public void b(byte[] bArr, boolean z2) {
    }

    public boolean b(MotionEvent motionEvent) {
        return false;
    }

    public int[] b(j jVar) {
        return null;
    }

    /* access modifiers changed from: protected */
    public void bE() {
    }

    public boolean bL() {
        return false;
    }

    public void bM() {
    }

    public void bN() {
    }

    public boolean bV() {
        return true;
    }

    public int bW() {
        return 102;
    }

    /* access modifiers changed from: protected */
    public String bY() {
        return null;
    }

    /* access modifiers changed from: protected */
    public void ba() {
    }

    /* access modifiers changed from: protected */
    public void bb() {
    }

    public void bc() {
    }

    /* access modifiers changed from: protected */
    public boolean bf() {
        return true;
    }

    /* access modifiers changed from: protected */
    public void bg() {
    }

    public void bh() {
    }

    public void bi() {
    }

    public void bj() {
    }

    /* access modifiers changed from: protected */
    public boolean bk() {
        return false;
    }

    public int bm() {
        return 0;
    }

    public boolean bw() {
        return false;
    }

    public boolean bx() {
        return false;
    }

    public float c(j jVar) {
        return 1.0f;
    }

    public abstract int c();

    public boolean c(int i2) {
        return false;
    }

    public boolean c(MotionEvent motionEvent) {
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean c(ApsAdapterDecision.DecisionResult decisionResult) {
        return false;
    }

    public boolean c(String str) {
        return false;
    }

    public boolean cM() {
        return false;
    }

    /* access modifiers changed from: protected */
    public com.oppo.camera.e.a.a cN() {
        return null;
    }

    /* access modifiers changed from: protected */
    public boolean cQ() {
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean cR() {
        return false;
    }

    public boolean cS() {
        return false;
    }

    public boolean cT() {
        return true;
    }

    public void cU() {
    }

    public boolean cV() {
        return false;
    }

    public boolean cW() {
        return true;
    }

    public boolean cX() {
        return false;
    }

    public int cY() {
        return 0;
    }

    public void cZ() {
    }

    public boolean cd() {
        return false;
    }

    public String cg() {
        return "key_filter_index";
    }

    public boolean ci() {
        return true;
    }

    public boolean cj() {
        return false;
    }

    public boolean ck() {
        return false;
    }

    public boolean cl() {
        return false;
    }

    public boolean cm() {
        return false;
    }

    public boolean cn() {
        return false;
    }

    public boolean cq() {
        return false;
    }

    public boolean cr() {
        return false;
    }

    public boolean cs() {
        return false;
    }

    public boolean cw() {
        return true;
    }

    public void cx() {
    }

    /* access modifiers changed from: protected */
    public void d(ApsAdapterDecision.DecisionResult decisionResult) {
    }

    public boolean d() {
        return true;
    }

    public boolean d(MotionEvent motionEvent) {
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean dA() {
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean dB() {
        return false;
    }

    public void dC() {
    }

    public void dF() {
    }

    public void dG() {
    }

    public void dH() {
    }

    public void dI() {
    }

    public void dJ() {
    }

    public boolean dK() {
        return false;
    }

    public boolean dL() {
        return false;
    }

    public boolean dM() {
        return false;
    }

    public boolean dN() {
        return false;
    }

    public boolean dO() {
        return false;
    }

    public boolean dP() {
        return true;
    }

    public boolean dQ() {
        return false;
    }

    public boolean dR() {
        return false;
    }

    public boolean dS() {
        return false;
    }

    public void dT() {
    }

    public boolean dU() {
        return true;
    }

    public boolean dV() {
        return false;
    }

    public void dW() {
    }

    public void dX() {
    }

    public long dZ() {
        return 0;
    }

    public boolean db() {
        return false;
    }

    public void dc() {
    }

    /* access modifiers changed from: protected */
    public String[] de() {
        return null;
    }

    /* access modifiers changed from: protected */
    public int di() {
        return 40;
    }

    public int dj() {
        return 0;
    }

    public String dk() {
        return null;
    }

    public void dm() {
    }

    public boolean dn() {
        return false;
    }

    /* renamed from: do  reason: not valid java name */
    public long m2do() {
        return 0;
    }

    /* access modifiers changed from: protected */
    public String dq() {
        return "pref_camera_line_photo";
    }

    public void dr() {
    }

    public boolean dt() {
        return false;
    }

    public void dv() {
    }

    public boolean dw() {
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean dz() {
        return false;
    }

    public Range<Integer> e() {
        return null;
    }

    public void e(boolean z2, boolean z3) {
    }

    public void eA() {
    }

    /* access modifiers changed from: protected */
    public int eD() {
        return -1;
    }

    /* access modifiers changed from: protected */
    public void eE() {
    }

    public void eG() {
    }

    public void eH() {
    }

    public boolean eI() {
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean eJ() {
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean eK() {
        return false;
    }

    public void eL() {
    }

    public void eM() {
    }

    /* access modifiers changed from: protected */
    public void eN() {
    }

    /* access modifiers changed from: protected */
    public void eP() {
    }

    /* access modifiers changed from: protected */
    public void eQ() {
    }

    /* access modifiers changed from: protected */
    public Surface eS() {
        return null;
    }

    public void eV() {
    }

    public int eW() {
        return 0;
    }

    public boolean eX() {
        return false;
    }

    public boolean eY() {
        return true;
    }

    public int eb() {
        return 1;
    }

    public boolean ec() {
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean ee() {
        return false;
    }

    /* access modifiers changed from: protected */
    public int ef() {
        return 0;
    }

    /* access modifiers changed from: protected */
    public void eg() {
    }

    /* access modifiers changed from: protected */
    public void eh() {
    }

    /* access modifiers changed from: protected */
    public String ei() {
        return null;
    }

    /* access modifiers changed from: protected */
    public boolean ej() {
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean ek() {
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean el() {
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean en() {
        return false;
    }

    public boolean eo() {
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean ep() {
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean eu() {
        return false;
    }

    /* access modifiers changed from: protected */
    public void ev() {
    }

    /* access modifiers changed from: protected */
    public boolean ew() {
        return false;
    }

    public void ey() {
    }

    public void ez() {
    }

    public boolean f() {
        return true;
    }

    public boolean fA() {
        return false;
    }

    public boolean fB() {
        return true;
    }

    public boolean fa() {
        return false;
    }

    public boolean fb() {
        return false;
    }

    public boolean fc() {
        return false;
    }

    public boolean fd() {
        return false;
    }

    public boolean fe() {
        return false;
    }

    public boolean ff() {
        return false;
    }

    public boolean fg() {
        return false;
    }

    public boolean fh() {
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean fl() {
        return false;
    }

    public boolean fm() {
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean fn() {
        return false;
    }

    public int fp() {
        return -1;
    }

    public long fq() {
        return -1;
    }

    public boolean fr() {
        return false;
    }

    public boolean fs() {
        return false;
    }

    public void fu() {
    }

    public void fv() {
    }

    public void fw() {
    }

    public boolean fx() {
        return false;
    }

    public boolean fz() {
        return true;
    }

    public boolean g() {
        return true;
    }

    /* access modifiers changed from: protected */
    public void h(int i2) {
    }

    public void h(boolean z2) {
    }

    public boolean h() {
        return false;
    }

    public void j() {
    }

    public boolean k() {
        return false;
    }

    public boolean k(String str) {
        return false;
    }

    public com.oppo.camera.ui.k l() {
        return null;
    }

    public void m(boolean z2) {
    }

    /* access modifiers changed from: protected */
    public boolean n() {
        return false;
    }

    public CamcorderProfile n_() {
        return null;
    }

    public void o(boolean z2) {
    }

    /* access modifiers changed from: protected */
    public abstract void p();

    public void p(boolean z2) {
    }

    public int q(int i2) {
        return 0;
    }

    /* access modifiers changed from: protected */
    public abstract void q();

    public void q(boolean z2) {
    }

    /* access modifiers changed from: protected */
    public abstract void r();

    public void r(boolean z2) {
    }

    public boolean r(int i2) {
        return false;
    }

    /* access modifiers changed from: protected */
    public abstract void s();

    public void s(int i2) {
    }

    public void s(String str) {
    }

    public void s(boolean z2) {
    }

    /* access modifiers changed from: protected */
    public abstract void t();

    public void t(int i2) {
    }

    public void t(String str) {
    }

    public Bitmap u(int i2) {
        return null;
    }

    /* access modifiers changed from: protected */
    public abstract void u();

    public void u(String str) {
    }

    /* access modifiers changed from: protected */
    public void u(boolean z2) {
    }

    /* access modifiers changed from: protected */
    public void v(boolean z2) {
    }

    /* access modifiers changed from: protected */
    public abstract boolean v();

    /* access modifiers changed from: protected */
    public boolean v(String str) {
        return true;
    }

    public void w(boolean z2) {
    }

    public boolean w(int i2) {
        return true;
    }

    public boolean w(String str) {
        return false;
    }

    public int x(String str) {
        return 35;
    }

    /* access modifiers changed from: protected */
    public void x(int i2) {
    }

    public int y(String str) {
        return 35;
    }

    public void y() {
    }

    public boolean z(String str) {
        return false;
    }

    public a(Activity activity, b bVar, com.oppo.camera.ui.e eVar, n nVar) {
        com.oppo.camera.e.a("BaseMode", "BaseMode, constructor init");
        this.Z = activity;
        this.X = bVar;
        this.Y = eVar;
        this.aa = this.X.r();
        this.ab = nVar;
        this.ak = this.X.b();
        this.as = this.ak.y();
    }

    public final int a(int i2) {
        b bVar = this.ak;
        if (bVar == null) {
            return -1;
        }
        return bVar.a(a(), i2);
    }

    public int m() {
        return this.W.e().J();
    }

    public c o() {
        SharedPreferences sharedPreferences = this.aa;
        String str = "button_shape_ring_none";
        if (sharedPreferences != null) {
            String string = sharedPreferences.getString("pref_camera_timer_shutter_key", this.Z.getString(R.string.camera_shutter_mode_default_value));
            if (FocusAimMsgData.KEY_INTELLIGENCE_VIEW_FOCUS_TYPE.equals(string)) {
                str = "button_shape_countdown_ten_seconds";
            } else if ("3".equals(string)) {
                str = "button_shape_countdown_three_seconds";
            }
        }
        return new c(1, "button_color_inside_none", str, 0);
    }

    public void w() {
        f fVar;
        if (this.M && (fVar = this.W) != null) {
            this.M = false;
            fVar.a(this.X.w(), false);
            if (this.X.j()) {
                this.W.a((f.c) null);
            }
        }
    }

    public void x() {
        f fVar;
        if (this.N && (fVar = this.W) != null) {
            this.N = false;
            fVar.e(false);
            if (this.X.j()) {
                this.W.a((f.c) null);
            }
        }
    }

    private void fC() {
        this.aG.removeMessages(8);
        this.aG.obtainMessage(8).sendToTarget();
    }

    public void z() {
        b bVar;
        SharedPreferences sharedPreferences = this.aa;
        boolean z2 = false;
        if (sharedPreferences != null && (!sharedPreferences.getBoolean("key_permission_dialog_displayed", false) || !this.aa.getBoolean("pref_camera_statement_key", false))) {
            return;
        }
        if (this.Y == null || (bVar = this.X) == null || !bVar.j() || this.Y.ap() || !p("key_drawer_show_guide_animation") || !aa()) {
            com.oppo.camera.ui.e eVar = this.Y;
            if (eVar != null && !eVar.ap()) {
                B();
                return;
            }
            return;
        }
        if (this.Y.ao() || this.Y.ap()) {
            z2 = true;
        }
        if (!com.oppo.camera.ui.g.h && !z2) {
            B();
        }
    }

    public void A() {
        this.aG.sendMessageDelayed(this.aG.obtainMessage(7), 1000);
    }

    public void B() {
        this.aG.removeMessages(7);
    }

    public int C() {
        synchronized (this.i) {
            if (this.af == null) {
                return 1;
            }
            int i2 = this.af.mMultiFrameCount;
            return i2;
        }
    }

    public void a(CaptureRequest.Builder builder, int i2, int i3, String[] strArr) {
        int i4;
        if (!Util.p() && builder != null) {
            com.oppo.camera.e.b("BaseMode", "onCaptureRequestBuilderUpdate, index: " + i3 + ", pictureNum: " + i2);
            builder.set(com.oppo.camera.f.c.ar, Integer.valueOf(i3));
            builder.set(com.oppo.camera.f.c.aq, Integer.valueOf(i2));
            if (strArr != null && strArr.length > 0) {
                if (ParameterKeys.ALGO_NAME_MFNR.equals(strArr[0]) || ParameterKeys.ALGO_NAME_AINR.equals(strArr[0])) {
                    int i5 = 5007;
                    if (!((i3 == i2 - 1 && ParameterKeys.ALGO_NAME_MFNR.equals(strArr[0]) && (26 == (i4 = this.ar) || 27 == i4)) || (i3 == i2 - 2 && ParameterKeys.ALGO_NAME_MFNR.equals(strArr[0]) && 27 == this.ar))) {
                        i5 = ParameterKeys.ALGO_NAME_MFNR.equals(strArr[0]) ? 1 : 2;
                    }
                    builder.set(com.oppo.camera.f.c.ap, new int[]{i5});
                    com.oppo.camera.e.b("BaseMode", "onCaptureRequestBuilderUpdate, hintForIspTuning: " + i5);
                }
            }
        }
    }

    public int H() {
        return G();
    }

    public void b(boolean z2) {
        f fVar = this.W;
        if (fVar != null) {
            fVar.B(this.ar);
            if (z2) {
                this.W.a((f.c) null);
            }
        }
    }

    public void a(boolean z2, int i2) {
        f fVar = this.W;
        if (fVar != null) {
            fVar.C(i2);
            if (z2) {
                this.W.a((f.c) null);
            }
        }
    }

    public void b(boolean z2, int i2) {
        f fVar = this.W;
        if (fVar != null) {
            fVar.D(i2);
            if (z2) {
                this.W.a((f.c) null);
            }
        }
    }

    private void fD() {
        f fVar;
        if (!Util.p() && CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_PORTRAIT_NEON_SUPPORT) && (fVar = this.W) != null) {
            fVar.u("neon-2020.cube.rgb.bin".equals(ce()));
        }
    }

    public void b(boolean z2, boolean z3) {
        f fVar = this.W;
        if (fVar != null) {
            fVar.l(z3);
            if (z2) {
                this.W.a((f.c) null);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0076, code lost:
        r9 = r8.j;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0078, code lost:
        monitor-enter(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x007b, code lost:
        if (r8.Q == false) goto L_0x0098;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x007d, code lost:
        com.oppo.camera.e.a("BaseMode", "onPreviewDecisionResult, needCapture");
        r8.Q = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0088, code lost:
        if (r8.W == null) goto L_0x0098;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x008a, code lost:
        r8.W.m().post(new com.oppo.camera.e.a.AnonymousClass2(r8));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0098, code lost:
        monitor-exit(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0099, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(com.oppo.camera.aps.adapter.ApsAdapterDecision.DecisionResult r9) {
        /*
            r8 = this;
            java.lang.Object r0 = r8.i
            monitor-enter(r0)
            boolean r1 = r8.v     // Catch:{ all -> 0x00cb }
            if (r1 != 0) goto L_0x009d
            boolean r1 = r8.y     // Catch:{ all -> 0x00cb }
            if (r1 != 0) goto L_0x009d
            boolean r1 = r8.A     // Catch:{ all -> 0x00cb }
            if (r1 != 0) goto L_0x0011
            goto L_0x009d
        L_0x0011:
            r8.af = r9     // Catch:{ all -> 0x00cb }
            boolean r1 = r8.ex()     // Catch:{ all -> 0x00cb }
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L_0x003f
            if (r9 == 0) goto L_0x0037
            int[] r1 = r9.mSensorMask     // Catch:{ all -> 0x00cb }
            if (r1 == 0) goto L_0x0037
            int[] r1 = r9.mSensorMask     // Catch:{ all -> 0x00cb }
            int r1 = r1.length     // Catch:{ all -> 0x00cb }
            r4 = 3
            if (r1 < r4) goto L_0x0037
            int[] r1 = r9.mSensorMask     // Catch:{ all -> 0x00cb }
            int r4 = r1.length     // Catch:{ all -> 0x00cb }
            r5 = r2
            r6 = r5
        L_0x002c:
            if (r5 >= r4) goto L_0x0038
            r7 = r1[r5]     // Catch:{ all -> 0x00cb }
            if (r3 != r7) goto L_0x0034
            int r6 = r6 + 1
        L_0x0034:
            int r5 = r5 + 1
            goto L_0x002c
        L_0x0037:
            r6 = r2
        L_0x0038:
            if (r6 <= 0) goto L_0x003b
            goto L_0x003c
        L_0x003b:
            r6 = r3
        L_0x003c:
            r8.q = r6     // Catch:{ all -> 0x00cb }
            goto L_0x004e
        L_0x003f:
            r8.q = r3     // Catch:{ all -> 0x00cb }
            com.oppo.camera.aps.adapter.ApsAdapterDecision$DecisionResult r1 = r8.af     // Catch:{ all -> 0x00cb }
            if (r1 == 0) goto L_0x004e
            com.oppo.camera.aps.adapter.ApsAdapterDecision$DecisionResult r1 = r8.af     // Catch:{ all -> 0x00cb }
            r4 = 0
            r1.mSensorMask = r4     // Catch:{ all -> 0x00cb }
            com.oppo.camera.aps.adapter.ApsAdapterDecision$DecisionResult r1 = r8.af     // Catch:{ all -> 0x00cb }
            r1.mMasterPipeline = r2     // Catch:{ all -> 0x00cb }
        L_0x004e:
            if (r9 == 0) goto L_0x0061
            int r1 = r8.ar     // Catch:{ all -> 0x00cb }
            int r4 = r9.mApsDecisionFeatureType     // Catch:{ all -> 0x00cb }
            if (r1 == r4) goto L_0x0061
            int r1 = r9.mApsDecisionFeatureType     // Catch:{ all -> 0x00cb }
            r8.ar = r1     // Catch:{ all -> 0x00cb }
            boolean r1 = r8.u     // Catch:{ all -> 0x00cb }
            if (r1 != 0) goto L_0x0061
            r8.b((boolean) r3)     // Catch:{ all -> 0x00cb }
        L_0x0061:
            if (r9 == 0) goto L_0x0072
            int r1 = r8.ao     // Catch:{ all -> 0x00cb }
            int r4 = r9.mApsBracketMode     // Catch:{ all -> 0x00cb }
            if (r1 == r4) goto L_0x0072
            int r1 = r9.mApsBracketMode     // Catch:{ all -> 0x00cb }
            r8.ao = r1     // Catch:{ all -> 0x00cb }
            int r1 = r8.ao     // Catch:{ all -> 0x00cb }
            r8.a((boolean) r3, (int) r1)     // Catch:{ all -> 0x00cb }
        L_0x0072:
            r8.e((com.oppo.camera.aps.adapter.ApsAdapterDecision.DecisionResult) r9)     // Catch:{ all -> 0x00cb }
            monitor-exit(r0)     // Catch:{ all -> 0x00cb }
            java.lang.Object r9 = r8.j
            monitor-enter(r9)
            boolean r0 = r8.Q     // Catch:{ all -> 0x009a }
            if (r0 == 0) goto L_0x0098
            java.lang.String r0 = "BaseMode"
            java.lang.String r1 = "onPreviewDecisionResult, needCapture"
            com.oppo.camera.e.a(r0, r1)     // Catch:{ all -> 0x009a }
            r8.Q = r2     // Catch:{ all -> 0x009a }
            com.oppo.camera.f.f r0 = r8.W     // Catch:{ all -> 0x009a }
            if (r0 == 0) goto L_0x0098
            com.oppo.camera.f.f r0 = r8.W     // Catch:{ all -> 0x009a }
            android.os.Handler r0 = r0.m()     // Catch:{ all -> 0x009a }
            com.oppo.camera.e.a$2 r1 = new com.oppo.camera.e.a$2     // Catch:{ all -> 0x009a }
            r1.<init>()     // Catch:{ all -> 0x009a }
            r0.post(r1)     // Catch:{ all -> 0x009a }
        L_0x0098:
            monitor-exit(r9)     // Catch:{ all -> 0x009a }
            return
        L_0x009a:
            r0 = move-exception
            monitor-exit(r9)     // Catch:{ all -> 0x009a }
            throw r0
        L_0x009d:
            java.lang.String r9 = "BaseMode"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00cb }
            r1.<init>()     // Catch:{ all -> 0x00cb }
            java.lang.String r2 = "onPreviewDecisionResult, mbInCapturing: "
            r1.append(r2)     // Catch:{ all -> 0x00cb }
            boolean r2 = r8.v     // Catch:{ all -> 0x00cb }
            r1.append(r2)     // Catch:{ all -> 0x00cb }
            java.lang.String r2 = ", mbPaused: "
            r1.append(r2)     // Catch:{ all -> 0x00cb }
            boolean r2 = r8.y     // Catch:{ all -> 0x00cb }
            r1.append(r2)     // Catch:{ all -> 0x00cb }
            java.lang.String r2 = ", mbCapModeInit: "
            r1.append(r2)     // Catch:{ all -> 0x00cb }
            boolean r2 = r8.A     // Catch:{ all -> 0x00cb }
            r1.append(r2)     // Catch:{ all -> 0x00cb }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x00cb }
            com.oppo.camera.e.e(r9, r1)     // Catch:{ all -> 0x00cb }
            monitor-exit(r0)     // Catch:{ all -> 0x00cb }
            return
        L_0x00cb:
            r9 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00cb }
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.e.a.a(com.oppo.camera.aps.adapter.ApsAdapterDecision$DecisionResult):void");
    }

    private void e(ApsAdapterDecision.DecisionResult decisionResult) {
        boolean z2;
        boolean z3;
        this.R = false;
        if (!cG() || decisionResult == null || this.u) {
            this.C = false;
            return;
        }
        int i2 = decisionResult.mApsDecisionSceneMode;
        boolean z4 = this.C;
        if (1 == i2 || 11 == i2 || 14 == i2 || 23 == i2) {
            this.C = true;
            if (this.X.p() > 0 && !cH()) {
                this.R = true;
                this.C = false;
            }
            if (com.oppo.camera.ui.inverse.c.INS.isInverseColor(this.Z.hashCode())) {
                this.C = false;
            }
            if (!cH() && !this.H && z4 != (z2 = this.C)) {
                d(z2, this.E);
                return;
            }
            return;
        }
        this.C = false;
        if (!cH() && !this.H && z4 != (z3 = this.C)) {
            d(z3, this.E);
        }
    }

    public void a(Image image, TotalCaptureResult totalCaptureResult, Rect rect, com.oppo.camera.f.d dVar) {
        b bVar = this.X;
        if (!(bVar != null ? bVar.d() : false) || image == null || totalCaptureResult == null || dVar == null) {
            a((byte[]) null, 0, 0, 256, false);
            return;
        }
        dVar.a(d.a.CAPTURE_REPROCESS);
        dVar.q = 1;
        dVar.r = 35;
        dVar.H = null;
        this.aC = 0;
        this.W.a(image, totalCaptureResult, rect, dVar);
    }

    public com.oppo.camera.f.d b(ApsAdapterDecision.DecisionResult decisionResult) {
        com.oppo.camera.f.d dVar = new com.oppo.camera.f.d();
        dVar.f3190a = ck();
        dVar.g = bw();
        String ce = ce();
        boolean g2 = g(ce);
        dVar.f3191b = g2;
        dVar.n = ce;
        boolean z2 = false;
        if (g2) {
            dVar.m = f(CameraFunction.FILTER_VIGNETTE) && "oppo_video_filter_olympus".equals(ce);
        } else if ("portrait_retention".equals(ce)) {
            dVar.J = true;
        }
        dVar.j = f(CameraFunction.VIDEO_BLUR_PROCESS) && eu();
        dVar.k = f(CameraFunction.VIDEO_RETENTION) && ew();
        dVar.l = dz();
        dVar.h = f(CameraFunction.FACE_BLUR);
        dVar.i = fa();
        dVar.T = es();
        dVar.f = f(CameraFunction.DERED_EYE) && cz();
        dVar.c = em();
        dVar.d = cr();
        dVar.o = this.u;
        dVar.p = en();
        if (this.u) {
            dVar.r = 35;
            if (!Util.p()) {
                try {
                    dVar.q = 1 == this.W.e().f() ? 10 : Util.d;
                } catch (IllegalArgumentException e2) {
                    com.oppo.camera.e.e("BaseMode", "getCaptureRequestTag, exception: " + e2.getMessage());
                    dVar.q = Util.d;
                }
            } else {
                dVar.q = Util.d;
            }
        } else {
            dVar.r = decisionResult.mRequestFormat;
            dVar.q = C();
        }
        dVar.s = !this.X.j();
        dVar.u = a();
        dVar.v = this.n;
        dVar.w = this.X.aq();
        dVar.ar = decisionResult.mbAIShutter;
        if (dVar.r == 32 || dVar.r == 37 || dVar.r == 36 || dVar.r == 34) {
            dVar.a(d.a.CAPTURE_RAW);
        } else {
            dVar.a(d.a.CAPTURE);
        }
        if (f("pref_camera_hdr_mode_key")) {
            dVar.x = this.aa.getString("pref_camera_hdr_mode_key", CameraConfig.getOptionKeyDefaultValue("pref_camera_hdr_mode_key", this.n));
            dVar.y = cB();
        }
        dVar.z = Util.a(d(this.W.e()), this.n);
        dVar.A = bB();
        dVar.B = this.X.X();
        dVar.C = this.r;
        dVar.D = this.X.Y();
        dVar.aq = this.aF;
        if (f("pref_none_sat_ultra_wide_angle_key")) {
            dVar.E = this.aa.getString("pref_none_sat_ultra_wide_angle_key", this.Z.getString(R.string.ultra_wide_angle_default_value));
        }
        dVar.F = this.k;
        String str = "off";
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_PI_AI)) {
            dVar.K = this.X.l();
        } else {
            dVar.K = "on".equals(this.aa.getString("pref_camera_pi_mode_key", str));
        }
        if (this.t) {
            str = bA();
        }
        dVar.L = "on".equals(str);
        dVar.N = this.X.k();
        dVar.O = P();
        dVar.W = this.u ? 1 : H();
        dVar.aj = eq();
        ApsAdapterDecision.DecisionResult decisionResult2 = null;
        if (ex()) {
            if (this.u) {
                int[] iArr = {0, 0, 0};
                if (decisionResult.mSensorMask != null && decisionResult.mMasterPipeline >= 0 && iArr.length > decisionResult.mMasterPipeline && decisionResult.mSensorMask.length > decisionResult.mMasterPipeline && 1 == decisionResult.mSensorMask[decisionResult.mMasterPipeline]) {
                    iArr[decisionResult.mMasterPipeline] = 1;
                }
                dVar.X = iArr;
                dVar.Y = decisionResult.mMasterPipeline;
                com.oppo.camera.e.a("BaseMode", "getCaptureRequestTag, decisionResult.sensorMask: " + Arrays.toString(decisionResult.mSensorMask) + ", sensorMask: " + Arrays.toString(iArr) + ", decisionResult.mMasterPipeline: " + decisionResult.mMasterPipeline);
            } else {
                dVar.X = cQ() ? null : decisionResult.mSensorMask;
                dVar.Y = decisionResult.mMasterPipeline;
                com.oppo.camera.e.a("BaseMode", "getCaptureRequestTag, decisionResult.mSensorMask: " + Arrays.toString(decisionResult.mSensorMask) + ", isInNightProcess(): " + cQ());
            }
        }
        boolean z3 = 4 == decisionResult.mApsDecisionFeatureType || 8 == decisionResult.mApsDecisionFeatureType || 16 == decisionResult.mApsDecisionFeatureType || 24 == decisionResult.mApsDecisionFeatureType || 26 == decisionResult.mApsDecisionFeatureType || 30 == decisionResult.mApsDecisionFeatureType || 27 == decisionResult.mApsDecisionFeatureType || 28 == decisionResult.mApsDecisionFeatureType;
        boolean z4 = 12 == decisionResult.mApsDecisionSceneMode || 13 == decisionResult.mApsDecisionSceneMode;
        if ((z3 && !c(decisionResult) && !this.u) || ((cQ() && !this.u) || ((f("key_support_bokeh_hdr") && z4) || 13 == decisionResult.mApsDecisionSceneMode || 26 == decisionResult.mApsDecisionSceneMode))) {
            dVar.H = decisionResult.mCaptureEVList;
            dVar.I = decisionResult.mCaptureETList;
        }
        dVar.G = this.u ? null : decisionResult.mApsAlgoFlag;
        if (!this.u) {
            decisionResult2 = decisionResult;
        }
        dVar.M = decisionResult2;
        if (b(ParameterKeys.ALGO_NAME_PF_V3)) {
            dVar.e = false;
        } else {
            dVar.e = cb();
        }
        if (!this.u) {
            dVar.Z = decisionResult.mSupportCaptureZoomFeature;
            dVar.ac = decisionResult.mApsDecisionFeatureType;
            dVar.aa = decisionResult.mApsBracketMode;
            dVar.ab = decisionResult.mAsdSceneValue;
            dVar.ae = decisionResult.mMFSRFrameCount;
        }
        if (dVar.s) {
            dVar.t = fL();
        }
        dVar.ah = !this.u && (cQ() || ah() > 0);
        dVar.am = this.X.v();
        dVar.ap = bd();
        dVar.ai = J();
        dVar.as = fh();
        if (aJ()) {
            if (decisionResult.mApsDecisionFeatureType != 5) {
                z2 = true;
            }
            dVar.S = z2;
        }
        return dVar;
    }

    public boolean K() {
        return com.oppo.camera.f.a.c(this.n) && !fe();
    }

    public void L() {
        b(0);
    }

    /* access modifiers changed from: protected */
    public void b(int i2) {
        synchronized (this.av) {
            com.oppo.camera.e.a("BaseMode", "setCapturePreviewDataState: " + this.az + " -> " + i2);
            this.az = i2;
        }
    }

    private int fE() {
        int i2;
        synchronized (this.av) {
            i2 = this.az;
        }
        return i2;
    }

    /* access modifiers changed from: protected */
    public void M() {
        if (this.W == null) {
            return;
        }
        if (!b(ParameterKeys.ALGO_NAME_SUPERPHOTO) || this.u) {
            this.W.i(0);
        } else {
            this.W.i(1);
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0025, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean b(java.lang.String r7) {
        /*
            r6 = this;
            java.lang.Object r0 = r6.i
            monitor-enter(r0)
            com.oppo.camera.aps.adapter.ApsAdapterDecision$DecisionResult r1 = r6.af     // Catch:{ all -> 0x0026 }
            r2 = 0
            if (r1 == 0) goto L_0x0024
            com.oppo.camera.aps.adapter.ApsAdapterDecision$DecisionResult r1 = r6.af     // Catch:{ all -> 0x0026 }
            java.lang.String[] r1 = r1.mApsAlgoFlag     // Catch:{ all -> 0x0026 }
            if (r1 == 0) goto L_0x0024
            com.oppo.camera.aps.adapter.ApsAdapterDecision$DecisionResult r1 = r6.af     // Catch:{ all -> 0x0026 }
            java.lang.String[] r1 = r1.mApsAlgoFlag     // Catch:{ all -> 0x0026 }
            int r3 = r1.length     // Catch:{ all -> 0x0026 }
            r4 = r2
        L_0x0014:
            if (r4 >= r3) goto L_0x0024
            r5 = r1[r4]     // Catch:{ all -> 0x0026 }
            boolean r5 = android.text.TextUtils.equals(r7, r5)     // Catch:{ all -> 0x0026 }
            if (r5 == 0) goto L_0x0021
            monitor-exit(r0)     // Catch:{ all -> 0x0026 }
            r7 = 1
            return r7
        L_0x0021:
            int r4 = r4 + 1
            goto L_0x0014
        L_0x0024:
            monitor-exit(r0)     // Catch:{ all -> 0x0026 }
            return r2
        L_0x0026:
            r7 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0026 }
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.e.a.b(java.lang.String):boolean");
    }

    /* access modifiers changed from: protected */
    public boolean N() {
        return Util.b(a(), this.t);
    }

    /* JADX WARNING: Removed duplicated region for block: B:56:0x00c8  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00c9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(android.hardware.camera2.CameraCaptureSession r17, android.hardware.camera2.CaptureRequest r18, long r19, long r21) {
        /*
            r16 = this;
            r1 = r16
            r10 = r19
            java.lang.String r0 = "captureX onCaptureStarted"
            com.oppo.camera.e.a((java.lang.String) r0)
            int r0 = r1.ah
            r2 = 0
            r3 = 1
            if (r0 != 0) goto L_0x0011
            r0 = r3
            goto L_0x0012
        L_0x0011:
            r0 = r2
        L_0x0012:
            int r4 = r1.ah
            int r4 = r4 + r3
            r1.ah = r4
            java.lang.Object r4 = r18.getTag()
            r12 = r4
            com.oppo.camera.f.d r12 = (com.oppo.camera.f.d) r12
            if (r12 == 0) goto L_0x0028
            int r4 = r12.q
            int r5 = r1.ah
            if (r4 != r5) goto L_0x0028
            r4 = r3
            goto L_0x0029
        L_0x0028:
            r4 = r2
        L_0x0029:
            if (r12 == 0) goto L_0x002e
            boolean r5 = r12.o
            goto L_0x002f
        L_0x002e:
            r5 = r2
        L_0x002f:
            int r6 = r16.fE()
            if (r6 != r3) goto L_0x0037
            r6 = r3
            goto L_0x0038
        L_0x0037:
            r6 = r2
        L_0x0038:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "onCaptureStarted, burstShot: "
            r7.append(r8)
            r7.append(r5)
            java.lang.String r8 = ", timestamp: "
            r7.append(r8)
            r7.append(r10)
            java.lang.String r8 = ", firstFrame: "
            r7.append(r8)
            r7.append(r0)
            java.lang.String r7 = r7.toString()
            java.lang.String r8 = "BaseMode"
            com.oppo.camera.e.b(r8, r7)
            r13 = 0
            if (r0 == 0) goto L_0x007e
            int r7 = r18.hashCode()
            r1.o = r7
            r1.aD = r10
            r1.aA = r13
            com.oppo.camera.e.b r7 = r1.X
            if (r7 == 0) goto L_0x007e
            if (r6 != 0) goto L_0x007e
            long r8 = r1.aD
            java.lang.String r14 = r1.aB
            java.lang.String r15 = "key_support_update_thumbnail_user_picture"
            boolean r15 = r1.f((java.lang.String) r15)
            r7.a((long) r8, (java.lang.String) r14, (boolean) r15)
        L_0x007e:
            android.app.Activity r7 = r1.Z
            if (r7 == 0) goto L_0x0092
            boolean r7 = r16.aP()
            if (r7 == 0) goto L_0x0092
            android.app.Activity r7 = r1.Z
            com.oppo.camera.e.a$3 r8 = new com.oppo.camera.e.a$3
            r8.<init>(r5, r0, r4)
            r7.runOnUiThread(r8)
        L_0x0092:
            com.oppo.camera.aps.adapter.ApsAdapterDecision$DecisionResult r0 = r12.M
            if (r0 == 0) goto L_0x009b
            com.oppo.camera.aps.adapter.ApsAdapterDecision$DecisionResult r0 = r12.M
            int r0 = r0.mThumbnailIndex
            goto L_0x009c
        L_0x009b:
            r0 = r3
        L_0x009c:
            java.lang.Object r4 = r1.i
            monitor-enter(r4)
            com.oppo.camera.aps.adapter.ApsAdapterDecision$DecisionResult r5 = r1.af     // Catch:{ all -> 0x012f }
            if (r5 == 0) goto L_0x00a8
            com.oppo.camera.aps.adapter.ApsAdapterDecision$DecisionResult r5 = r1.af     // Catch:{ all -> 0x012f }
            int r5 = r5.mApsDecisionFeatureType     // Catch:{ all -> 0x012f }
            goto L_0x00a9
        L_0x00a8:
            r5 = r2
        L_0x00a9:
            r7 = 5
            if (r7 != r5) goto L_0x00ae
            r7 = r3
            goto L_0x00af
        L_0x00ae:
            r7 = r2
        L_0x00af:
            r8 = 4
            if (r8 == r5) goto L_0x00bd
            r8 = 8
            if (r8 == r5) goto L_0x00bd
            r8 = 16
            if (r8 != r5) goto L_0x00bb
            goto L_0x00bd
        L_0x00bb:
            r8 = r2
            goto L_0x00be
        L_0x00bd:
            r8 = r3
        L_0x00be:
            if (r7 != 0) goto L_0x00cb
            boolean r5 = r1.C((int) r5)     // Catch:{ all -> 0x012f }
            if (r5 != 0) goto L_0x00cb
            if (r8 == 0) goto L_0x00c9
            goto L_0x00cb
        L_0x00c9:
            r9 = r2
            goto L_0x00cc
        L_0x00cb:
            r9 = r3
        L_0x00cc:
            monitor-exit(r4)     // Catch:{ all -> 0x012f }
            com.oppo.camera.ui.e r2 = r1.Y
            if (r2 == 0) goto L_0x00e6
            int r3 = r1.ah
            if (r0 != r3) goto L_0x00e6
            if (r6 == 0) goto L_0x00e6
            com.oppo.camera.ui.preview.e r2 = r2.c()
            r3 = r17
            r4 = r18
            r5 = r19
            r7 = r21
            r2.a((android.hardware.camera2.CameraCaptureSession) r3, (android.hardware.camera2.CaptureRequest) r4, (long) r5, (long) r7, (boolean) r9)
        L_0x00e6:
            boolean r0 = com.oppo.camera.util.Util.p()
            if (r0 == 0) goto L_0x0112
            if (r12 == 0) goto L_0x0112
            com.oppo.camera.aps.adapter.ApsAdapterDecision$DecisionResult r0 = r12.M
            if (r0 == 0) goto L_0x0112
            com.oppo.camera.aps.adapter.ApsAdapterDecision$DecisionResult r0 = r12.M
            int r0 = r0.mMetaIndex
            int r2 = r1.ah
            if (r0 != r2) goto L_0x0112
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "onCaptureStarted, we save the use reprocess's metadata's timestamp: "
            r0.append(r2)
            r0.append(r10)
            java.lang.String r0 = r0.toString()
            java.lang.String r2 = "BaseMode"
            com.oppo.camera.e.b(r2, r0)
            r1.aE = r10
        L_0x0112:
            if (r12 == 0) goto L_0x0129
            com.oppo.camera.f.d$a r0 = r12.a()
            com.oppo.camera.f.d$a r2 = com.oppo.camera.f.d.a.CAPTURE_REPROCESS
            if (r0 != r2) goto L_0x0129
            com.oppo.camera.e.b r0 = r1.X
            if (r0 == 0) goto L_0x0129
            com.oppo.camera.aps.service.ThumbnailProcessor$DataRequest r2 = r1.aA
            if (r2 == 0) goto L_0x0129
            r0.a((com.oppo.camera.aps.service.ThumbnailProcessor.DataRequest) r2)
            r1.aA = r13
        L_0x0129:
            java.lang.String r0 = "captureX onCaptureStarted"
            com.oppo.camera.e.b(r0)
            return
        L_0x012f:
            r0 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x012f }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.e.a.a(android.hardware.camera2.CameraCaptureSession, android.hardware.camera2.CaptureRequest, long, long):void");
    }

    /* access modifiers changed from: protected */
    public boolean R() {
        com.oppo.camera.t.a aVar = this.ag;
        return aVar != null && aVar.c();
    }

    public void a(ApsCaptureResult apsCaptureResult, CaptureRequest captureRequest) {
        Object a2;
        com.oppo.camera.e.a("captureX onCaptureCompleted");
        this.S = false;
        b bVar = this.X;
        if (bVar != null && !bVar.aH() && F()) {
            if (ex() && AlgoSwitchConfig.getApsVersion() <= 2 && (a2 = com.oppo.camera.f.c.a(apsCaptureResult.getTotalResult(), com.oppo.camera.f.c.ai)) != null && (a2 instanceof Integer)) {
                int intValue = ((Integer) a2).intValue();
                synchronized (this.i) {
                    if (intValue > 0) {
                        this.q = intValue;
                    } else {
                        this.q = 1;
                    }
                }
            }
            a(apsCaptureResult, (com.oppo.camera.f.d) captureRequest.getTag());
        }
        com.oppo.camera.e.b("captureX onCaptureCompleted");
    }

    private ImageCategory.MetaItemInfo a(ApsCaptureResult apsCaptureResult, com.oppo.camera.f.d dVar) {
        boolean z2;
        String str;
        int i2;
        float[] a2;
        TiltShiftParam aG2;
        int i3;
        ApsCaptureResult apsCaptureResult2 = apsCaptureResult;
        com.oppo.camera.f.d dVar2 = dVar;
        PerformanceMsgData.startPointTime(CaptureMsgData.PROCESS_DURATION);
        boolean z3 = dVar2.o;
        String str2 = "type_still_capture_yuv_main";
        if (!(apsCaptureResult2.mMasterPipeline == null || apsCaptureResult2.mMasterPipeline.length == 0)) {
            if (apsCaptureResult2.mMasterPipeline[0] == 0) {
                str2 = "type_still_capture_yuv_sub";
            } else if (2 == apsCaptureResult2.mMasterPipeline[0]) {
                str2 = "type_still_capture_yuv_third";
            }
        }
        com.oppo.camera.e.a("BaseMode", "addCaptureMetaToAPS, timeStamp: " + apsCaptureResult2.mSensorTimestamp + ", burstShot: " + z3 + ", result: " + apsCaptureResult2);
        if (ex()) {
            z2 = apsCaptureResult2.mSensorMask != null && apsCaptureResult2.mSensorMask.length >= 3 && apsCaptureResult2.mSensorMask[0] == 1;
            com.oppo.camera.e.a("BaseMode", "addCaptureMetaToAPS, sensorMask: " + Arrays.toString(apsCaptureResult2.mSensorMask));
        } else {
            z2 = eB();
        }
        com.oppo.camera.e.a("BaseMode", "addCaptureMetaToAPS, isNeedRectify: " + z2);
        ImageCategory.MetaItemInfo metaItemInfo = new ImageCategory.MetaItemInfo();
        ArrayList arrayList = new ArrayList();
        if (dVar2.o && z2) {
            arrayList.add(ParameterKeys.ALGO_NAME_RECTIFY);
            if (ex()) {
                metaItemInfo.setParameter(ParameterKeys.KEY_IMAGE_ROLE, 2);
            } else {
                metaItemInfo.setParameter(ParameterKeys.KEY_IMAGE_ROLE, 0);
            }
        }
        if (dVar2.d && !dVar2.o) {
            arrayList.add(ParameterKeys.ALGO_NAME_FACE_RECTIFY);
        }
        if (dVar2.e || dVar2.f) {
            if (AlgoSwitchConfig.getSupportCaptureAlgo(a(), this.n, ParameterKeys.ALGO_NAME_FACE_INFO)) {
                arrayList.add(ParameterKeys.ALGO_NAME_FACE_INFO);
            }
            if (dVar2.e) {
                arrayList.add(ParameterKeys.ALGO_NAME_FACE_BEAUTY);
            }
            if (dVar2.f) {
                arrayList.add(ParameterKeys.ALGO_NAME_DERED_EYE);
            }
        }
        if (dVar2.j) {
            arrayList.add(ParameterKeys.ALGO_NAME_VIDEO_BLUR);
        }
        if (dVar2.h) {
            if (dVar2.as) {
                arrayList.add(ParameterKeys.ALGO_NAME_SINGLE_AICOLOR);
            } else {
                arrayList.add(T());
            }
        }
        if (dVar2.k) {
            arrayList.add(ParameterKeys.ALGO_NAME_VIDEO_RETENTION);
        }
        if (dVar2.f3191b) {
            arrayList.add(dt() ? ParameterKeys.ALGO_NAME_FILTER_MICROSCOPE : ParameterKeys.ALGO_NAME_FILTER);
        }
        if (!dVar2.f3190a || !R()) {
            metaItemInfo.setParameter(ParameterKeys.KEY_SUPER_TEXT_ENABLE, ParameterKeys.getFlagState(false));
        } else {
            arrayList.add(ParameterKeys.ALGO_NAME_SUPER_TEXT);
            metaItemInfo.setParameter(ParameterKeys.KEY_SUPER_TEXT_ENABLE, ParameterKeys.getFlagState(true));
        }
        if (dVar2.l && dE() > 0) {
            arrayList.add(ParameterKeys.ALGO_NAME_TILT_SHIFT);
        }
        metaItemInfo.setParameter(ParameterKeys.KEY_SUPER_RAW_ENABLE, ParameterKeys.getFlagState(dVar2.ao));
        metaItemInfo.setParameter(ParameterKeys.KEY_OPERATION_MODE, String.valueOf(c()));
        if (AlgoSwitchConfig.getSupportCaptureAlgo(a(), this.n, ParameterKeys.ALGO_NAME_ROTATE_MIRROR)) {
            arrayList.add(ParameterKeys.ALGO_NAME_ROTATE_MIRROR);
        }
        a(apsCaptureResult2, metaItemInfo, str2, dVar2.ap);
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SURPERNIGHT_REPROCESS_EXTRA_YUV) && d.a.CAPTURE_REPROCESS == dVar.a()) {
            a(apsCaptureResult2, metaItemInfo);
        }
        if (AlgoSwitchConfig.getSupportCaptureAlgo(a(), this.n, ParameterKeys.ALGO_NAME_UPSCALE)) {
            arrayList.add(ParameterKeys.ALGO_NAME_UPSCALE);
        }
        if (dVar2.c) {
            arrayList.add(ParameterKeys.ALGO_NAME_WATERMARK);
        }
        if (dVar2.f3191b) {
            String valueOf = String.valueOf(dVar2.n);
            if (!TextUtils.isEmpty(valueOf)) {
                metaItemInfo.setParameter(ParameterKeys.KEY_FILTER_TYPE, valueOf);
                metaItemInfo.setParameter(ParameterKeys.KEY_FILTER_WITHVIGNETTE, ParameterKeys.getFlagState(dVar2.m));
            }
        }
        if ((dVar2.h || dVar2.j || Util.a(dVar2.G, ParameterKeys.ALGO_NAME_BOKEH) || Util.a(dVar2.G, ParameterKeys.ALGO_NAME_FRONT_BOKEH)) && (i3 = dVar2.T) > 0) {
            metaItemInfo.setParameter(ParameterKeys.KEY_BLUR_VALUE, String.valueOf(i3));
            metaItemInfo.setParameter(ParameterKeys.KEY_VIDEO_BLUR_ORIENTATION, String.valueOf(B(dVar2.F)));
            metaItemInfo.setParameter(ParameterKeys.KEY_VIDEO_BLUR_EFFECT, String.valueOf(((w) this.ab.i(32)).o()));
        }
        if (dVar2.k) {
            boolean o2 = ((x) this.ab.i(256)).o();
            metaItemInfo.setParameter(ParameterKeys.KEY_VIDEO_RETENTION, ParameterKeys.getFlagState(o2));
            if (o2) {
                metaItemInfo.setParameter(ParameterKeys.KEY_VIDEO_RETENTION_ORIENTATION, String.valueOf(B(dVar2.F)));
            }
        } else {
            metaItemInfo.setParameter(ParameterKeys.KEY_VIDEO_RETENTION, "0");
        }
        if (!dVar2.l || dE() <= 0) {
            metaItemInfo.setParameter(ParameterKeys.KEY_TILT_SHIFT, "0");
        } else {
            boolean o3 = ((v) this.ab.i(512)).o();
            metaItemInfo.setParameter(ParameterKeys.KEY_TILT_SHIFT, ParameterKeys.getFlagState(o3));
            if (o3 && (aG2 = this.X.aG()) != null) {
                String arrays = Arrays.toString(new float[]{aG2.getCenterX(), aG2.getCenterY()});
                Size previewSize = aG2.getPreviewSize();
                metaItemInfo.setParameter(ParameterKeys.KEY_TILT_SHIFT_PREVIEW_SIZE, Arrays.toString(new int[]{previewSize.getWidth(), previewSize.getHeight()}));
                metaItemInfo.setParameter(ParameterKeys.KEY_BLUR_VALUE, String.valueOf(dE()));
                metaItemInfo.setParameter(ParameterKeys.KEY_TILT_SHIFT_TYPE, String.valueOf(aG2.isCircle() ^ true ? 1 : 0));
                metaItemInfo.setParameter(ParameterKeys.KEY_TILT_SHIFT_CENTER_POSITION, arrays);
                metaItemInfo.setParameter(ParameterKeys.KEY_TILT_SHIFT_CLEAR_DISTANCE, String.valueOf(aG2.getInnerDistance()));
                metaItemInfo.setParameter(ParameterKeys.KEY_TILT_SHIFT_ROTATE_ANGLE, String.valueOf(aG2.getAngle()));
            }
        }
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_PI_AI) && dVar2.K && dVar2.N > 0) {
            metaItemInfo.setParameter(ParameterKeys.KEY_AI_SCENE, String.valueOf(dVar2.N));
        }
        ApsParameters.Key<String> key = ParameterKeys.KEY_NEON_ENABLE;
        if (dVar2.i) {
            str = "1";
        } else {
            str = "0";
        }
        metaItemInfo.setParameter(key, str);
        metaItemInfo.setParameter(ParameterKeys.KEY_TIME_STAMP, apsCaptureResult2.mSensorTimestamp);
        metaItemInfo.setParameter(ParameterKeys.KEY_FLASH_STATUS, ParameterKeys.getFlagState(cz()));
        metaItemInfo.setParameter(ParameterKeys.KEY_CAPTURE_RESULT, apsCaptureResult.getTotalResult());
        metaItemInfo.setParameter(ParameterKeys.KEY_CAMERA_ID, String.valueOf(this.n));
        metaItemInfo.setParameter(ParameterKeys.KEY_LOGIC_CAMERA_ID, Integer.valueOf(dVar2.w));
        metaItemInfo.setParameter(ParameterKeys.KEY_META_MAP, apsCaptureResult.getMetaMap());
        metaItemInfo.setParameter(ParameterKeys.KEY_CAPTURE_REQUEST, Integer.valueOf(dVar2.ad));
        String a3 = a(metaItemInfo);
        if (a3 != null) {
            metaItemInfo.setParameter(ParameterKeys.KEY_PICTURE_EXIF_FLAG, a3);
        }
        metaItemInfo.setParameter(ParameterKeys.KEY_FAST_CAPTURE, Boolean.valueOf(!f("key_support_update_thumbnail_user_picture")));
        if (d.a.CAPTURE_RAW == dVar.a() || d.a.CAPTURE_REPROCESS == dVar.a()) {
            i2 = 1;
        } else {
            i2 = H();
        }
        if (!AlgoSwitchConfig.getSupportApsCapture() || z3) {
            metaItemInfo.setParameter(ParameterKeys.KEY_MERGE_NUMBER, 1);
            metaItemInfo.setParameter(ParameterKeys.KEY_MERGE_INDEX, 0);
            metaItemInfo.setParameter(ParameterKeys.KEY_MERGE_IDENTITY, apsCaptureResult2.mSensorTimestamp);
            metaItemInfo.setParameter(ParameterKeys.KEY_PREVIEW_STREAM_NUMBER, 1);
            metaItemInfo.setParameter(ParameterKeys.KEY_CAPTURE_STREAM_NUMBER, 1);
            metaItemInfo.setParameter(ParameterKeys.KEY_DATE, 0L);
        } else {
            metaItemInfo.setParameter(ParameterKeys.KEY_MERGE_NUMBER, Integer.valueOf(dVar2.q * i2));
            metaItemInfo.setParameter(ParameterKeys.KEY_MERGE_INDEX, Integer.valueOf(this.aC));
            this.aC++;
            metaItemInfo.setParameter(ParameterKeys.KEY_MERGE_IDENTITY, Long.valueOf(this.aD));
            metaItemInfo.setParameter(ParameterKeys.KEY_PREVIEW_STREAM_NUMBER, Integer.valueOf(G()));
            metaItemInfo.setParameter(ParameterKeys.KEY_CAPTURE_STREAM_NUMBER, Integer.valueOf(i2));
            metaItemInfo.setParameter(ParameterKeys.KEY_DATE, Long.valueOf(this.aq));
        }
        if (!(dVar2.am == null || 0 == dVar2.am.getTime())) {
            metaItemInfo.setParameter(ParameterKeys.KEY_GPS_TIME, String.valueOf(dVar2.am.getTime()));
            metaItemInfo.setParameter(ParameterKeys.KEY_GPS_COORDS, Arrays.toString(new double[]{dVar2.am.getLatitude(), dVar2.am.getLongitude(), dVar2.am.getAltitude()}));
        }
        metaItemInfo.setParameter(ParameterKeys.KEY_FRAME_NUMBER, Long.valueOf(apsCaptureResult2.mFrameNumber));
        metaItemInfo.setParameter(ParameterKeys.KEY_DISPLAY_METRICS_WIDTH, String.valueOf(Util.E()));
        metaItemInfo.setParameter(ParameterKeys.KEY_DISPLAY_METRICS_HEIGHT, String.valueOf(Util.C()));
        metaItemInfo.setParameter(ParameterKeys.KEY_FACE_BEAUTY_VERSION, String.valueOf(CameraConfig.getConfigIntValue(ConfigDataBase.KEY_FACE_BEAUTY_VERSION_CODE)));
        metaItemInfo.setParameter(ParameterKeys.KEY_CUSTOM_BEAUTY_PARAM, Util.a(dh()));
        metaItemInfo.setParameter(ParameterKeys.KEY_RETENTION_ENABLE, ParameterKeys.getFlagState(dVar2.J));
        metaItemInfo.setParameter(ParameterKeys.KEY_PI_ENABLE, ParameterKeys.getFlagState(dVar2.K));
        metaItemInfo.setParameter(ParameterKeys.KEY_FRAME_FLAG, Integer.valueOf(dVar2.af));
        metaItemInfo.setParameter(ParameterKeys.KEY_OUTPUT_FORMAT, Integer.valueOf(dVar2.ag));
        metaItemInfo.setParameter(ParameterKeys.KEY_OFFSET_DATE_TIME, DateTimeFormatter.ofPattern("XXX").format(ZonedDateTime.ofInstant(Instant.ofEpochMilli(System.currentTimeMillis()), ZoneId.systemDefault())));
        if (this.t) {
            metaItemInfo.setParameter(ParameterKeys.KEY_PICTURE_MIRROR, ParameterKeys.getFlagState(!dVar2.L));
            metaItemInfo.setParameter(ParameterKeys.KEY_LENS_FACING, String.valueOf(0));
        } else {
            metaItemInfo.setParameter(ParameterKeys.KEY_PICTURE_MIRROR, "0");
            metaItemInfo.setParameter(ParameterKeys.KEY_LENS_FACING, String.valueOf(1));
        }
        metaItemInfo.setParameter(ParameterKeys.KEY_DCIP3_ENABLE, ParameterKeys.getFlagState(!dVar2.s && CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_FEATURE_DCIP3_SUPPORT)));
        metaItemInfo.setParameter(ParameterKeys.KEY_ZOOM_RATIO, String.valueOf(dVar2.ap));
        if (this.W != null && !Util.p()) {
            metaItemInfo.setParameter(ParameterKeys.KEY_CSHOT_REQUEST_NUMER, Integer.valueOf(this.W.v()));
        }
        metaItemInfo.setParameter(ParameterKeys.KEY_MAX_BURST_SHOT_NUM, Integer.valueOf(Util.d));
        b bVar = this.X;
        if (bVar != null) {
            int al2 = bVar.al();
            Size ak2 = this.X.ak();
            byte[] aj2 = this.X.aj();
            if (!(aj2 == null || al2 == 0 || ak2 == null)) {
                metaItemInfo.setParameter(ParameterKeys.KEY_APS_WATERMARK_PARAM, new ApsWatermarkParam(al2, ak2.getHeight(), ak2.getWidth(), aj2));
            }
        }
        metaItemInfo.setParameter(ParameterKeys.KEY_ORIENTATION, Integer.valueOf(this.k));
        metaItemInfo.setParameter(ParameterKeys.KEY_ULTRA_RESOLUTION, ParameterKeys.getFlagState(af()));
        metaItemInfo.setParameter(ParameterKeys.KEY_HEIF_ENABLE, ParameterKeys.getFlagState(dVar2.aj != null));
        metaItemInfo.setParameter(ParameterKeys.KEY_USE_TUNING_DATA, Boolean.valueOf(!Util.p() && (r("type_tuning_data_yuv") || r("type_tuning_data_raw"))));
        if (ck()) {
            com.oppo.camera.e.a("BaseMode", "addCaptureMetaToAPS, mDetectResult: " + this.ag);
            com.oppo.camera.t.a aVar = this.ag;
            if (aVar != null && aVar.c() && (a2 = a(this.ag.a())) != null && a2.length > 0) {
                metaItemInfo.setParameter(ParameterKeys.KEY_SUPER_TEXT_VERTICES, Arrays.toString(a2));
            }
        }
        if (this.aE == apsCaptureResult2.mSensorTimestamp.longValue() && (dVar2.ah || dVar2.ao || dVar2.ai)) {
            com.oppo.camera.e.b("BaseMode", "addCaptureMetaToAPS, will save capture result for reprocess");
            metaItemInfo.setParameter(ParameterKeys.KEY_REPROCESS_META_DATA, true);
        }
        ApsCameraRequestTag a4 = Util.a(dVar2, metaItemInfo);
        if (a4.mCaptureDecisionResult != null) {
            metaItemInfo.setParameter(ParameterKeys.KEY_INPUT_EVLIST, Arrays.toString(a4.mCaptureDecisionResult.mCaptureEVList));
            metaItemInfo.setParameter(ParameterKeys.KEY_META_INDEX, String.valueOf(a4.mCaptureDecisionResult.mMetaIndex));
            metaItemInfo.setParameter(ParameterKeys.KEY_SUPER_NIGHT_SCENE, String.valueOf(a4.mCaptureDecisionResult.mSuperNightScene));
            metaItemInfo.setParameter(ParameterKeys.KEY_CAPTURE_FEATURE_TYPE, Integer.valueOf(a4.mCaptureDecisionResult.mApsDecisionFeatureType));
            metaItemInfo.setParameter(ParameterKeys.KEY_CAPTURE_MFNR_NUM, Integer.valueOf(a4.mCaptureDecisionResult.mMFSRFrameCount));
            com.oppo.camera.e.a("BaseMode", "addCaptureMetaToAPS, mCaptureDecisionResult.mSuperNightScene: " + a4.mCaptureDecisionResult.mSuperNightScene);
        }
        metaItemInfo.setParameter(ParameterKeys.KEY_CAMERA_REQUEST_TAG, a4);
        CaptureMsgData captureMsgData = null;
        metaItemInfo.setParameter(ParameterKeys.KEY_APS_PROCESS_ALGO_TYPE, a((String[]) arrayList.toArray(new String[0]), z3 ? null : dVar2.G));
        metaItemInfo.setParameter(ParameterKeys.KEY_AI_SHUTTER, Boolean.valueOf(dVar2.ar));
        ApsService apsService = this.aj;
        if (apsService != null) {
            b bVar2 = this.X;
            if (bVar2 != null) {
                captureMsgData = bVar2.ab();
            }
            apsService.addCaptureMetaInfo(metaItemInfo, captureMsgData);
        }
        return metaItemInfo;
    }

    /* access modifiers changed from: protected */
    public String T() {
        return CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_ARCSOFT_SINGLE_BOKEH_SUPPORT) ? ParameterKeys.ALGO_NAME_SINGLE_BOKEH : ParameterKeys.ALGO_NAME_SINGLE_BLUR;
    }

    public void a(ApsCaptureResult apsCaptureResult, ImageCategory.MetaItemInfo metaItemInfo, String str, float f2) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        ApsCaptureResult apsCaptureResult2 = apsCaptureResult;
        ImageCategory.MetaItemInfo metaItemInfo2 = metaItemInfo;
        if (apsCaptureResult2.mUpscaleInputSize == null || apsCaptureResult2.mUpscaleInputSize.length != 4) {
            com.oppo.camera.e.d("BaseMode", "onCaptureCompleted, upscaleInputArray is null");
            i5 = 0;
            i4 = 0;
            i3 = 0;
            i2 = 0;
        } else {
            i5 = apsCaptureResult2.mUpscaleInputSize[0];
            i4 = apsCaptureResult2.mUpscaleInputSize[1];
            i3 = apsCaptureResult2.mUpscaleInputSize[2];
            i2 = apsCaptureResult2.mUpscaleInputSize[3];
        }
        if (apsCaptureResult2.mUpscaleOutputSize == null || apsCaptureResult2.mUpscaleOutputSize.length != 4) {
            com.oppo.camera.e.d("BaseMode", "onCaptureCompleted, upscaleOutputArray is null");
            i9 = 0;
            i8 = 0;
            i7 = 0;
            i6 = 0;
        } else {
            int i10 = apsCaptureResult2.mUpscaleOutputSize[0];
            int i11 = apsCaptureResult2.mUpscaleOutputSize[1];
            int i12 = apsCaptureResult2.mUpscaleOutputSize[2];
            i6 = apsCaptureResult2.mUpscaleOutputSize[3];
            i9 = i10;
            i8 = i11;
            i7 = i12;
        }
        Size a2 = Util.p() ? null : a(str, this.W.e());
        if (a2 != null) {
            metaItemInfo2.setParameter(ParameterKeys.KEY_OUTPUT_SIZE, new int[]{a2.getWidth(), a2.getHeight(), 0, 0});
            metaItemInfo2.setParameter(ParameterKeys.KEY_OUTPUT_WIDTH, String.valueOf(a2.getWidth()));
            metaItemInfo2.setParameter(ParameterKeys.KEY_OUTPUT_HEIGHT, String.valueOf(a2.getHeight()));
            if (!bw()) {
                boolean eT = eT();
                metaItemInfo2.setParameter(ParameterKeys.KEY_CROP_WIDTH, String.valueOf(eT ? a2.getWidth() / 2 : a2.getWidth()));
                metaItemInfo2.setParameter(ParameterKeys.KEY_CROP_HEIGHT, String.valueOf(eT ? a2.getHeight() / 2 : a2.getHeight()));
            }
        }
        metaItemInfo2.setParameter(ParameterKeys.KEY_CROP_WIDTH, metaItemInfo2.get(ParameterKeys.KEY_CROP_WIDTH));
        metaItemInfo2.setParameter(ParameterKeys.KEY_CROP_HEIGHT, metaItemInfo2.get(ParameterKeys.KEY_CROP_HEIGHT));
        if (a(i5, i4, i3, i2, i9, i8)) {
            metaItemInfo2.setParameter(ParameterKeys.KEY_INPUT_SIZE, new int[]{i5, i4, i3, i2});
            metaItemInfo2.setParameter(ParameterKeys.KEY_OUTPUT_SIZE, new int[]{i9, i8, i7, i6});
            metaItemInfo2.setParameter(ParameterKeys.KEY_OUTPUT_WIDTH, String.valueOf(i9));
            metaItemInfo2.setParameter(ParameterKeys.KEY_OUTPUT_HEIGHT, String.valueOf(i8));
        }
        int[] U2 = U();
        if (U2 != null && U2.length > 1) {
            metaItemInfo2.setParameter(ParameterKeys.KEY_OUTPUT_SIZE, new int[]{U2[0], U2[1], 0, 0});
            metaItemInfo2.setParameter(ParameterKeys.KEY_OUTPUT_WIDTH, String.valueOf(U2[0]));
            metaItemInfo2.setParameter(ParameterKeys.KEY_OUTPUT_HEIGHT, String.valueOf(U2[1]));
            metaItemInfo2.setParameter(ParameterKeys.KEY_CROP_WIDTH, String.valueOf(U2[0]));
            metaItemInfo2.setParameter(ParameterKeys.KEY_CROP_HEIGHT, String.valueOf(U2[1]));
        }
    }

    private float[] a(PointF[] pointFArr) {
        if (pointFArr == null || pointFArr.length <= 0) {
            return null;
        }
        float[] fArr = new float[(pointFArr.length * 2)];
        int i2 = 0;
        for (int i3 = 0; i3 < pointFArr.length; i3++) {
            int i4 = i2 + 1;
            fArr[i2] = pointFArr[i3].x;
            i2 = i4 + 1;
            fArr[i4] = pointFArr[i3].y;
        }
        com.oppo.camera.e.a("BaseMode", "convertVertices, result: " + Arrays.toString(fArr));
        return fArr;
    }

    private String[] a(String[] strArr, String[] strArr2) {
        if (strArr == null || strArr.length <= 0) {
            if (strArr2 == null || strArr2.length == 0) {
                return new String[]{ApsParameters.ALGO_NAME_NONE};
            }
            return strArr2;
        } else if (strArr2 == null || strArr2.length == 0) {
            return strArr;
        } else {
            String[] strArr3 = new String[(strArr2.length + strArr.length)];
            System.arraycopy(strArr2, 0, strArr3, 0, strArr2.length);
            System.arraycopy(strArr, 0, strArr3, strArr2.length, strArr.length);
            return strArr3;
        }
    }

    public void b(com.oppo.camera.f.d dVar) {
        com.oppo.camera.e.e("BaseMode", "onCaptureCanceled, requestTag: " + dVar);
        this.S = false;
        b bVar = this.X;
        if (bVar != null) {
            bVar.a(this.aD, 0, 0);
        }
        b(2);
        a((byte[]) null, 0, 0, aQ(), false);
    }

    public void a(CaptureRequest captureRequest) {
        int i2;
        com.oppo.camera.e.e("BaseMode", "onCaptureFailed, mCaptureMergeIdentity: " + this.aD);
        boolean z2 = false;
        boolean z3 = this.ah == 0;
        this.S = false;
        if (z3) {
            this.ah++;
        }
        com.oppo.camera.f.d dVar = (com.oppo.camera.f.d) captureRequest.getTag();
        if (!(this.X == null || dVar == null)) {
            if (dVar.o) {
                this.X.a(this.aD, dVar.W, dVar.W);
            } else {
                if (d.a.CAPTURE_RAW == dVar.a() || d.a.CAPTURE_REPROCESS == dVar.a()) {
                    z2 = true;
                }
                if (z2) {
                    i2 = 1;
                } else {
                    i2 = dVar.W;
                }
                this.X.a(this.aD, i2, dVar.q * i2);
            }
        }
        b bVar = this.X;
        if (bVar != null) {
            bVar.e(true);
        }
        b(2);
        a((byte[]) null, 0, 0, aQ(), false);
    }

    public void a(CaptureRequest captureRequest, CaptureResult captureResult) {
        com.oppo.camera.e.a("BaseMode", "onProgress");
    }

    public void onApsCaptureStarted(long j2) {
        com.oppo.camera.e.c("BaseMode", "onApsCaptureStarted, timestamp: " + j2);
        this.aD = j2;
    }

    public void onApsCaptureCompleted(ApsResult apsResult, ApsTotalResult apsTotalResult, ApsCameraRequestTag apsCameraRequestTag) {
        com.oppo.camera.e.c("BaseMode", "onApsCaptureCompleted, result: " + apsResult);
        if (apsCameraRequestTag.mTag == null || this.z) {
            com.oppo.camera.e.c("BaseMode", "onApsCaptureCompleted, tag:" + apsCameraRequestTag.mTag + ", requestTag.mTag:" + apsCameraRequestTag.mTag);
            return;
        }
        com.oppo.camera.f.d dVar = (com.oppo.camera.f.d) apsCameraRequestTag.mTag;
        ApsCaptureResult apsCaptureResult = new ApsCaptureResult((TotalCaptureResult) apsTotalResult.getTotalResult(), Integer.toString(dVar.w));
        ApsResult.ImageBuffer imageBuffer = apsResult.getImageBuffer();
        if (!(imageBuffer == null || apsCaptureResult.mSensorTimestamp.longValue() == imageBuffer.getTimestamp())) {
            com.oppo.camera.e.d("BaseMode", "onApsCaptureCompleted, meta timestamp is not match with buffer");
            apsCaptureResult.mSensorTimestamp = Long.valueOf(imageBuffer.getTimestamp());
        }
        ImageCategory.MetaItemInfo a2 = a(apsCaptureResult, dVar);
        if (imageBuffer != null) {
            this.X.a(imageBuffer, 0);
        } else {
            com.oppo.camera.e.e("BaseMode", "onApsCaptureCompleted, imageBuffer is null");
        }
        this.X.a(((Long) a2.get(ParameterKeys.KEY_TIME_STAMP)).longValue(), Util.a(((Long) a2.get(ParameterKeys.KEY_DATE)).longValue()), false);
    }

    public boolean d(String str) {
        String c = b.c(str);
        if ("pref_setting_key".equals(c)) {
            if (this.X.m() || !aa()) {
                return true;
            }
            return false;
        } else if ("pref_filter_menu".equals(c) || "pref_camera_torch_mode_key".equals(c) || "pref_video_blur_menu".equals(c) || "pref_portrait_blur_menu".equals(c) || "pref_none_sat_ultra_wide_angle_key".equals(c) || "pref_night_tripod_mode_key".equals(c)) {
            return f(c);
        } else {
            if ("pref_camera_timer_shutter_key".equals(c)) {
            }
            return false;
        }
    }

    public boolean e(String str) {
        if ("pref_zoom_key".equals(str)) {
            return f(str) || this.u;
        }
        return f(str);
    }

    public void ab() {
        c cVar = new c(10, "button_color_inside_none");
        cVar.b(0);
        this.Y.a(cVar);
    }

    public void c(boolean z2) {
        c cVar = new c(11, "button_color_inside_none");
        cVar.b(0);
        this.Y.a(cVar);
    }

    public boolean ac() {
        String string = this.aa.getString("pref_camera_torch_mode_key", Util.y(this.Z));
        return (string.equals("on") || string.equals(MenuClickMsgData.VALUE_PROFESSION_AUTO)) && this.t && !f(CameraFunction.TORCH_SOFT_LIGHT) && f("pref_camera_torch_mode_key");
    }

    public boolean f(String str) {
        String str2;
        b bVar;
        b bVar2;
        boolean z2 = true;
        if ("pref_camera_tap_shutter_key".equals(str) || "pref_update_setting_background_bar_key".equals(str) || "pref_face_detection_key".equals(str) || "pref_time_lapse_key".equals(str) || "pref_continuous_focus_key".equals(str) || "pref_manual_exposure_key".equals(str) || "pref_support_switch_camera".equals(str) || "pref_support_thumbnail".equals(str) || "pref_camera_assistant_line_key".equals(str) || "pref_assist_gradienter".equals(str) || "pref_subsetting_key".equals(str) || "key_support_zsl".equals(str) || "pref_support_rotate_hint_view".equals(str) || CameraFunction.REQUEST_FAST_LAUNCH.equals(str) || "key_setting_menu".equals(str) || "key_setting_support".equals(str) || "pref_camera_pi_ai_mode_key".equals(str) || "key_support_share_edit_thumb".equals(str) || "pref_video_size_fps_settings".equals(str) || "key_capturing_click_close".equals(str)) {
            return true;
        }
        if ("key_support_gimbal_change".equals(str) || "key_dark_environment_tips".equals(str) || "key_support_show_low_ambient_light_hint".equals(str)) {
            return false;
        }
        if ("pref_camera_gesture_shutter_key".equals(str)) {
            if (!this.t || Z()) {
                return false;
            }
            return true;
        } else if ("pref_zoom_key".equals(str)) {
            if ((!this.t || (N() && ((bVar2 = this.X) == null || bVar2.j()))) && !this.u) {
                return true;
            }
            return false;
        } else if ("pref_filter_menu".equals(str)) {
            return f("pref_filter_process_key");
        } else {
            if (CameraFunction.NEED_PREVIEW_STREAM.equals(str)) {
                return aj();
            }
            if (CameraFunction.RESET_AUTO_FOCUS.equals(str)) {
                if (!bC() || !"on".equals(bu())) {
                    return true;
                }
                return false;
            } else if ("key_support_slow_video_h265".equals(str)) {
                return Util.V();
            } else {
                if (CameraFunction.DERED_EYE.equals(str)) {
                    if (this.t || !AlgoSwitchConfig.getSupportCaptureAlgo(a(), this.n, ParameterKeys.ALGO_NAME_DERED_EYE) || (bVar = this.X) == null || !bVar.j()) {
                        return false;
                    }
                    return true;
                } else if (CameraFunction.APS_BRACKETMODE.equals(str)) {
                    if (!g() || this.u || cy()) {
                        return false;
                    }
                    return true;
                } else if ("pref_camera_countdown_effect_key".equals(str)) {
                    return Util.h("oplus.software.motor.breathled");
                } else {
                    if ("pref_lens_dirty_detection_key".equals(str)) {
                        SharedPreferences sharedPreferences = this.Z.getApplication().getSharedPreferences("rom_update_info", 0);
                        if (sharedPreferences != null) {
                            str2 = sharedPreferences.getString("dirty_detection_switch", CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_DIRTY_DETECT) ? "on" : "off");
                        } else {
                            str2 = "on";
                        }
                        return TextUtils.equals(str2, "on");
                    } else if (CameraFunction.AIS_SNAPSHOT.equals(str) || "key_support_show_soloop".equals(str) || "pref_10bits_heic_encode_key".equals(str)) {
                        return false;
                    } else {
                        if ("key_support_front_face_point_animation".equals(str)) {
                            SharedPreferences sharedPreferences2 = this.aa;
                            int i2 = sharedPreferences2 != null ? sharedPreferences2.getInt("key_support_front_face_point_animation", 0) : 0;
                            int f2 = Util.f(System.currentTimeMillis());
                            SharedPreferences sharedPreferences3 = this.aa;
                            int i3 = sharedPreferences3 != null ? sharedPreferences3.getInt("key_camera_pid_history", 0) : 0;
                            int myPid = Process.myPid();
                            if (this.aa == null || !this.t || ((i3 == myPid && f2 <= i2) || !CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_FRONT_FACE_POINT_ANIMATION) || !f(CameraFunction.FACE_BEAUTY_CUSTOM))) {
                                return false;
                            }
                            return true;
                        } else if (CameraFunction.CACHE_CLICK_CAPTURE.equals(str)) {
                            synchronized (this.i) {
                                if (!CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_CACHE_CLICK_CAPTURE_SUPPORT) || this.af == null || 3 != this.af.mApsDecisionFeatureType) {
                                    z2 = false;
                                }
                            }
                            return z2;
                        } else if ("pref_none_sat_tele_angle_key".equals(str)) {
                            return CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_NONE_SAT_TELE_SUPPORT);
                        } else {
                            return false;
                        }
                    }
                }
            }
        }
    }

    public boolean ae() {
        if (!f("pref_filter_process_key") || com.oppo.camera.ui.preview.a.g.f4385a == cf()) {
            return false;
        }
        return true;
    }

    public boolean g(String str) {
        return !FilterPackageUtil.F_DEFAULT.equals(str);
    }

    public boolean ag() {
        return this.H;
    }

    public int ah() {
        int i2;
        synchronized (this.i) {
            i2 = 0;
            int i3 = this.af != null ? this.af.mApsDecisionFeatureType : 0;
            if (i3 == 9 || i3 == 10 || i3 == 11 || i3 == 13 || i3 == 29 || i3 == 14 || i3 == 21 || i3 == 31) {
                i2 = this.af.mSuperNightScene;
            }
        }
        return i2;
    }

    public boolean ai() {
        boolean z2;
        synchronized (this.i) {
            z2 = true;
            if (this.af == null || this.af.mApsAlgoFlag == null || !ParameterKeys.ALGO_NAME_SUPERNIGHT.equals(this.af.mApsAlgoFlag[0]) || this.af.mSuperNightScene != 1) {
                z2 = false;
            }
        }
        return z2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:90:0x0135, code lost:
        return true;
     */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00c5 A[LOOP:0: B:48:0x008d->B:61:0x00c5, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00c8  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00dd  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x00de  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00f3  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00f5  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x00c4 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean aj() {
        /*
            r10 = this;
            boolean r0 = r10.u
            r1 = 1
            if (r0 == 0) goto L_0x0006
            return r1
        L_0x0006:
            java.lang.Integer r0 = r10.al
            int r0 = r0.intValue()
            r2 = 0
            if (r1 == r0) goto L_0x0010
            return r2
        L_0x0010:
            java.lang.Object r0 = r10.i
            monitor-enter(r0)
            com.oppo.camera.aps.adapter.ApsAdapterDecision$DecisionResult r3 = r10.af     // Catch:{ all -> 0x0136 }
            if (r3 == 0) goto L_0x0134
            java.lang.String r3 = "com.oplus.feature.mtk.insensor.zoom"
            boolean r3 = com.oppo.camera.aps.config.CameraConfig.getConfigBooleanValue(r3)     // Catch:{ all -> 0x0136 }
            if (r3 == 0) goto L_0x002e
            boolean r3 = com.oppo.camera.util.Util.p()     // Catch:{ all -> 0x0136 }
            if (r3 != 0) goto L_0x002e
            r3 = 4
            com.oppo.camera.aps.adapter.ApsAdapterDecision$DecisionResult r4 = r10.af     // Catch:{ all -> 0x0136 }
            int r4 = r4.mSupportCaptureZoomFeature     // Catch:{ all -> 0x0136 }
            if (r3 != r4) goto L_0x002e
            monitor-exit(r0)     // Catch:{ all -> 0x0136 }
            return r2
        L_0x002e:
            r3 = 5
            com.oppo.camera.aps.adapter.ApsAdapterDecision$DecisionResult r4 = r10.af     // Catch:{ all -> 0x0136 }
            int r4 = r4.mApsDecisionFeatureType     // Catch:{ all -> 0x0136 }
            if (r3 != r4) goto L_0x004b
            boolean r3 = com.oppo.camera.util.Util.p()     // Catch:{ all -> 0x0136 }
            if (r3 == 0) goto L_0x0042
            r3 = 2
            int r4 = com.oppo.camera.aps.config.AlgoSwitchConfig.getApsVersion()     // Catch:{ all -> 0x0136 }
            if (r3 == r4) goto L_0x004b
        L_0x0042:
            java.lang.String r1 = "BaseMode"
            java.lang.String r3 = "getNeedPreviewStream, remosaic capture no need preview surface"
            com.oppo.camera.e.a(r1, r3)     // Catch:{ all -> 0x0136 }
            monitor-exit(r0)     // Catch:{ all -> 0x0136 }
            return r2
        L_0x004b:
            r3 = 12
            com.oppo.camera.aps.adapter.ApsAdapterDecision$DecisionResult r4 = r10.af     // Catch:{ all -> 0x0136 }
            int r4 = r4.mApsDecisionSceneMode     // Catch:{ all -> 0x0136 }
            r5 = 14
            r6 = 11
            r7 = 13
            if (r3 == r4) goto L_0x0084
            com.oppo.camera.aps.adapter.ApsAdapterDecision$DecisionResult r3 = r10.af     // Catch:{ all -> 0x0136 }
            int r3 = r3.mApsDecisionSceneMode     // Catch:{ all -> 0x0136 }
            if (r7 == r3) goto L_0x0084
            com.oppo.camera.aps.adapter.ApsAdapterDecision$DecisionResult r3 = r10.af     // Catch:{ all -> 0x0136 }
            int r3 = r3.mApsDecisionSceneMode     // Catch:{ all -> 0x0136 }
            if (r6 == r3) goto L_0x0084
            com.oppo.camera.aps.adapter.ApsAdapterDecision$DecisionResult r3 = r10.af     // Catch:{ all -> 0x0136 }
            int r3 = r3.mApsDecisionSceneMode     // Catch:{ all -> 0x0136 }
            if (r1 == r3) goto L_0x0084
            com.oppo.camera.aps.adapter.ApsAdapterDecision$DecisionResult r3 = r10.af     // Catch:{ all -> 0x0136 }
            int r3 = r3.mApsDecisionSceneMode     // Catch:{ all -> 0x0136 }
            if (r5 == r3) goto L_0x0084
            r3 = 22
            com.oppo.camera.aps.adapter.ApsAdapterDecision$DecisionResult r4 = r10.af     // Catch:{ all -> 0x0136 }
            int r4 = r4.mApsDecisionSceneMode     // Catch:{ all -> 0x0136 }
            if (r3 == r4) goto L_0x0084
            r3 = 23
            com.oppo.camera.aps.adapter.ApsAdapterDecision$DecisionResult r4 = r10.af     // Catch:{ all -> 0x0136 }
            int r4 = r4.mApsDecisionSceneMode     // Catch:{ all -> 0x0136 }
            if (r3 != r4) goto L_0x0082
            goto L_0x0084
        L_0x0082:
            r3 = r2
            goto L_0x0085
        L_0x0084:
            r3 = r1
        L_0x0085:
            com.oppo.camera.aps.adapter.ApsAdapterDecision$DecisionResult r4 = r10.af     // Catch:{ all -> 0x0136 }
            java.lang.String[] r4 = r4.mApsAlgoFlag     // Catch:{ all -> 0x0136 }
            if (r4 == 0) goto L_0x00c8
            r4 = r2
            r8 = r4
        L_0x008d:
            com.oppo.camera.aps.adapter.ApsAdapterDecision$DecisionResult r9 = r10.af     // Catch:{ all -> 0x0136 }
            java.lang.String[] r9 = r9.mApsAlgoFlag     // Catch:{ all -> 0x0136 }
            int r9 = r9.length     // Catch:{ all -> 0x0136 }
            if (r4 >= r9) goto L_0x00c9
            java.lang.String r8 = "aps_algo_hdr"
            com.oppo.camera.aps.adapter.ApsAdapterDecision$DecisionResult r9 = r10.af     // Catch:{ all -> 0x0136 }
            java.lang.String[] r9 = r9.mApsAlgoFlag     // Catch:{ all -> 0x0136 }
            r9 = r9[r4]     // Catch:{ all -> 0x0136 }
            boolean r8 = r8.equals(r9)     // Catch:{ all -> 0x0136 }
            if (r8 != 0) goto L_0x00c1
            java.lang.String r8 = "aps_algo_lowlight_hdr"
            com.oppo.camera.aps.adapter.ApsAdapterDecision$DecisionResult r9 = r10.af     // Catch:{ all -> 0x0136 }
            java.lang.String[] r9 = r9.mApsAlgoFlag     // Catch:{ all -> 0x0136 }
            r9 = r9[r4]     // Catch:{ all -> 0x0136 }
            boolean r8 = r8.equals(r9)     // Catch:{ all -> 0x0136 }
            if (r8 != 0) goto L_0x00c1
            java.lang.String r8 = "aps_algo_raw_hdr"
            com.oppo.camera.aps.adapter.ApsAdapterDecision$DecisionResult r9 = r10.af     // Catch:{ all -> 0x0136 }
            java.lang.String[] r9 = r9.mApsAlgoFlag     // Catch:{ all -> 0x0136 }
            r9 = r9[r4]     // Catch:{ all -> 0x0136 }
            boolean r8 = r8.equals(r9)     // Catch:{ all -> 0x0136 }
            if (r8 == 0) goto L_0x00bf
            goto L_0x00c1
        L_0x00bf:
            r8 = r2
            goto L_0x00c2
        L_0x00c1:
            r8 = r1
        L_0x00c2:
            if (r8 == 0) goto L_0x00c5
            goto L_0x00c9
        L_0x00c5:
            int r4 = r4 + 1
            goto L_0x008d
        L_0x00c8:
            r8 = r2
        L_0x00c9:
            com.oppo.camera.aps.adapter.ApsAdapterDecision$DecisionResult r4 = r10.af     // Catch:{ all -> 0x0136 }
            int r4 = r4.mApsDecisionFeatureType     // Catch:{ all -> 0x0136 }
            if (r7 == r4) goto L_0x00e0
            com.oppo.camera.aps.adapter.ApsAdapterDecision$DecisionResult r4 = r10.af     // Catch:{ all -> 0x0136 }
            int r4 = r4.mApsDecisionFeatureType     // Catch:{ all -> 0x0136 }
            if (r5 == r4) goto L_0x00e0
            r4 = 29
            com.oppo.camera.aps.adapter.ApsAdapterDecision$DecisionResult r5 = r10.af     // Catch:{ all -> 0x0136 }
            int r5 = r5.mApsDecisionFeatureType     // Catch:{ all -> 0x0136 }
            if (r4 != r5) goto L_0x00de
            goto L_0x00e0
        L_0x00de:
            r4 = r2
            goto L_0x00e1
        L_0x00e0:
            r4 = r1
        L_0x00e1:
            boolean r5 = r10.t     // Catch:{ all -> 0x0136 }
            if (r5 == 0) goto L_0x00f5
            com.oppo.camera.aps.adapter.ApsAdapterDecision$DecisionResult r5 = r10.af     // Catch:{ all -> 0x0136 }
            int r5 = r5.mApsDecisionFeatureType     // Catch:{ all -> 0x0136 }
            if (r6 == r5) goto L_0x00f3
            r5 = 10
            com.oppo.camera.aps.adapter.ApsAdapterDecision$DecisionResult r6 = r10.af     // Catch:{ all -> 0x0136 }
            int r6 = r6.mApsDecisionFeatureType     // Catch:{ all -> 0x0136 }
            if (r5 != r6) goto L_0x00f5
        L_0x00f3:
            r5 = r1
            goto L_0x00f6
        L_0x00f5:
            r5 = r2
        L_0x00f6:
            boolean r6 = com.oppo.camera.util.Util.p()     // Catch:{ all -> 0x0136 }
            if (r6 != 0) goto L_0x0134
            if (r3 != 0) goto L_0x0104
            if (r8 != 0) goto L_0x0104
            if (r4 != 0) goto L_0x0104
            if (r5 == 0) goto L_0x0134
        L_0x0104:
            java.lang.String r1 = "BaseMode"
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0136 }
            r6.<init>()     // Catch:{ all -> 0x0136 }
            java.lang.String r7 = "getNeedPreviewStream, isSceneModeHDR: "
            r6.append(r7)     // Catch:{ all -> 0x0136 }
            r6.append(r3)     // Catch:{ all -> 0x0136 }
            java.lang.String r3 = ", isAlgoHDR: "
            r6.append(r3)     // Catch:{ all -> 0x0136 }
            r6.append(r8)     // Catch:{ all -> 0x0136 }
            java.lang.String r3 = ", isDarkSight: "
            r6.append(r3)     // Catch:{ all -> 0x0136 }
            r6.append(r4)     // Catch:{ all -> 0x0136 }
            java.lang.String r3 = ", isFrontNight: "
            r6.append(r3)     // Catch:{ all -> 0x0136 }
            r6.append(r5)     // Catch:{ all -> 0x0136 }
            java.lang.String r3 = r6.toString()     // Catch:{ all -> 0x0136 }
            com.oppo.camera.e.a(r1, r3)     // Catch:{ all -> 0x0136 }
            monitor-exit(r0)     // Catch:{ all -> 0x0136 }
            return r2
        L_0x0134:
            monitor-exit(r0)     // Catch:{ all -> 0x0136 }
            return r1
        L_0x0136:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0136 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.e.a.aj():boolean");
    }

    public void al() {
        this.Y.a((int) R.string.camera_toast_camera_Low_memory_hint, -1, true, false, false);
    }

    public void am() {
        if (this.Y.J()) {
            this.Y.K();
        }
        n nVar = this.ab;
        if (nVar != null) {
            nVar.d(2);
        }
        this.Y.b((int) R.string.camera_pi_ai_scenes_on_hint);
        this.Y.b((int) R.string.camera_pi_ai_scenes_off_hint);
        this.Y.b((int) R.string.camera_bokeh_need_more_light);
        this.ax = false;
    }

    public void d(int i2) {
        this.ar = 0;
        this.ao = 0;
        this.ap = 0;
        this.H = false;
        this.p = 0;
        this.n = i2;
        this.t = com.oppo.camera.f.a.c(this.n);
    }

    public final void d(boolean z2) {
        this.H = false;
        this.y = false;
        au = false;
        at = false;
        this.z = false;
        aw();
        a(z2);
        if (f("pref_camera_hdr_mode_key")) {
            G(true);
        } else {
            G(false);
        }
    }

    public final void ap() {
        this.y = true;
        this.e = false;
        this.v = false;
        this.w = false;
        this.x = false;
        this.G = true;
        au = false;
        at = false;
        this.ax = false;
        this.S = false;
        h = false;
        ApsService apsService = this.aj;
        if (apsService != null) {
            apsService.setCapturing(false);
        }
        com.oppo.camera.e.a("BaseMode", "pause, mbInCapturing: " + this.v);
        p();
        b(0);
        Handler handler = this.aG;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
        }
        if (cH()) {
            I(false);
        }
        this.Y.a(true, true, true);
        if (p("key_bubble_type_custom_face_beauty_close")) {
            this.Y.c(8, true);
        }
        l(false);
        z(false);
        this.C = false;
        this.D = false;
        this.I = false;
        this.p = 0;
        cx();
    }

    public final void aq() {
        q();
    }

    public final void ar() {
        com.oppo.camera.e.a("BaseMode", "destroy");
        this.z = true;
        r();
        this.A = false;
        this.B = false;
        this.aa = null;
        this.ab = null;
        this.Z = null;
        this.X = null;
        this.ac = null;
    }

    public void a(ApsTotalResult apsTotalResult) {
        Integer num;
        SharedPreferences sharedPreferences;
        if (apsTotalResult == null || apsTotalResult.getTotalResult() == null) {
            com.oppo.camera.e.e("BaseMode", "onPreviewCaptureResult, invalid totalResult: " + apsTotalResult);
            return;
        }
        CaptureResult totalResult = apsTotalResult.getTotalResult();
        boolean z2 = false;
        if (!f(CameraFunction.TORCH_SOFT_LIGHT)) {
            Integer num2 = (Integer) totalResult.get(CaptureResult.CONTROL_AE_STATE);
            Integer num3 = (Integer) totalResult.get(CaptureResult.CONTROL_AE_MODE);
            if (num2 != null && !this.u) {
                boolean z3 = this.E;
                if (this.X.w()) {
                    l(false);
                } else if (!this.v) {
                    if (cE() && com.oppo.camera.ui.inverse.c.INS.isInverseAble(this.Z)) {
                        l(com.oppo.camera.ui.inverse.c.INS.isInverseColor(this.Z.hashCode()));
                    } else if (2 == num3.intValue()) {
                        if (4 == num2.intValue()) {
                            l(true);
                        } else if (2 == num2.intValue()) {
                            l(false);
                        }
                    }
                }
                if (this.E != z3) {
                    if (!cC() && !cF() && !this.H) {
                        d(this.C, this.E);
                    } else {
                        return;
                    }
                }
            }
        }
        Object a2 = com.oppo.camera.f.c.a(totalResult, com.oppo.camera.f.c.L);
        if (a2 != null && (a2 instanceof Integer)) {
            Integer num4 = (Integer) a2;
            if (103 == num4.intValue()) {
                this.D = true;
            } else if (104 == num4.intValue()) {
                this.D = false;
            }
        }
        Object a3 = com.oppo.camera.f.c.a(totalResult, com.oppo.camera.f.c.M);
        if (a3 != null && (a3 instanceof Integer)) {
            Integer num5 = (Integer) a3;
            if (1002 == num5.intValue() || 1003 == num5.intValue()) {
                this.F = true;
                int i2 = this.p;
                if (i2 > 0) {
                    this.p = i2 - 1;
                }
                if (this.Y.l() == 4 && (f("pref_camera_hdr_mode_key") || f("pref_auto_night_scence_key"))) {
                    this.Y.a(o(), f("pref_burst_shot_key"));
                }
                bg();
            }
        }
        Object a4 = com.oppo.camera.f.c.a(totalResult, com.oppo.camera.f.c.S);
        if (!com.oppo.camera.ui.inverse.c.INS.isInverseAble(this.Z) || !f("pref_camera_torch_mode_key") || (sharedPreferences = this.aa) == null || !"off".equals(sharedPreferences.getString("pref_camera_torch_mode_key", Util.y(this.Z)))) {
            if (a4 != null && (a4 instanceof int[])) {
                this.s = ((int[]) a4)[0];
                com.oppo.camera.ui.e eVar = this.Y;
                if (this.s == 1) {
                    z2 = true;
                }
                eVar.B(z2);
            }
        } else if (Util.a(totalResult) > ((float) com.oppo.camera.ui.inverse.c.INS.getThreshold())) {
            this.Y.B(true);
        } else if (Util.a(totalResult) < ((float) com.oppo.camera.ui.inverse.c.INS.getThresholdRecover())) {
            this.Y.B(false);
        }
        Object a5 = com.oppo.camera.f.c.a(totalResult, com.oppo.camera.f.c.ak);
        if (a5 instanceof Integer) {
            this.al = (Integer) a5;
        }
        if (b(apsTotalResult)) {
            fF();
        }
        Integer num6 = (Integer) totalResult.get(CaptureResult.CONTROL_AE_EXPOSURE_COMPENSATION);
        if (num6 != null) {
            this.aF = num6.intValue();
        }
        if (!((!CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_MAINCAMERA_ASD_AISCENE_SUPPORT) && !CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_WIDECAMERA_ASD_AISCENE_SUPPORT)) || (num = (Integer) apsTotalResult.get(ApsTotalResult.APS_AI_SCENE)) == null || this.ap == num.intValue())) {
            this.ap = num.intValue();
            b(true, this.ap);
        }
        Object a6 = com.oppo.camera.f.c.a(totalResult, com.oppo.camera.f.c.aY);
        if (this.Y != null && f("support_focus_out_of_range") && a6 != null && (a6 instanceof Integer)) {
            if (1 != ((Integer) a6).intValue() || this.Y.J() || this.v) {
                this.Y.b((int) R.string.camera_bokeh_move_farther_away);
            } else {
                this.Y.a((int) R.string.camera_bokeh_move_farther_away, -1, true, false, false);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0009, code lost:
        r5 = com.oppo.camera.f.c.a(r5.getTotalResult(), com.oppo.camera.f.c.ah);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean b(com.oppo.camera.aps.adapter.ApsTotalResult r5) {
        /*
            r4 = this;
            int r0 = com.oppo.camera.aps.config.AlgoSwitchConfig.getApsVersion()
            r1 = 0
            r2 = 1
            r3 = 2
            if (r3 != r0) goto L_0x0025
            android.hardware.camera2.CaptureResult r5 = r5.getTotalResult()
            android.hardware.camera2.CaptureResult$Key<java.lang.Integer> r0 = com.oppo.camera.f.c.ah
            java.lang.Object r5 = com.oppo.camera.f.c.a(r5, r0)
            if (r5 == 0) goto L_0x0023
            boolean r0 = r5 instanceof java.lang.Integer
            if (r0 == 0) goto L_0x0023
            java.lang.Integer r5 = (java.lang.Integer) r5
            int r5 = r5.intValue()
            if (r5 != r2) goto L_0x0023
        L_0x0021:
            r5 = r2
            goto L_0x003c
        L_0x0023:
            r5 = r1
            goto L_0x003c
        L_0x0025:
            com.oppo.camera.aps.adapter.ApsTotalResult$Key<java.lang.Integer> r0 = com.oppo.camera.aps.adapter.ApsTotalResult.APS_LENS_DIRTY
            java.lang.Object r0 = r5.get(r0)
            if (r0 == 0) goto L_0x0023
            com.oppo.camera.aps.adapter.ApsTotalResult$Key<java.lang.Integer> r0 = com.oppo.camera.aps.adapter.ApsTotalResult.APS_LENS_DIRTY
            java.lang.Object r5 = r5.get(r0)
            java.lang.Integer r5 = (java.lang.Integer) r5
            int r5 = r5.intValue()
            if (r2 != r5) goto L_0x0023
            goto L_0x0021
        L_0x003c:
            java.lang.String r0 = "pref_lens_dirty_detection_key"
            boolean r0 = r4.f((java.lang.String) r0)
            if (r0 == 0) goto L_0x0067
            boolean r0 = r4.at()
            if (r0 == 0) goto L_0x0067
            float r0 = r4.bd()
            boolean r0 = r4.c((float) r0)
            if (r0 == 0) goto L_0x0067
            if (r5 == 0) goto L_0x0067
            boolean r5 = r4.t
            if (r5 == 0) goto L_0x005e
            boolean r5 = au
            if (r5 == 0) goto L_0x0066
        L_0x005e:
            boolean r5 = r4.t
            if (r5 != 0) goto L_0x0067
            boolean r5 = at
            if (r5 != 0) goto L_0x0067
        L_0x0066:
            r1 = r2
        L_0x0067:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.e.a.b(com.oppo.camera.aps.adapter.ApsTotalResult):boolean");
    }

    private boolean c(float f2) {
        if (f(CameraFunction.SAT_CAMERA)) {
            float[] configFloatArrayValue = CameraConfig.getConfigFloatArrayValue(ConfigDataBase.KEY_SAT_MAIN_ZOOM_RANGE);
            if (configFloatArrayValue == null || 2 != configFloatArrayValue.length) {
                return false;
            }
            if (Float.compare(f2, 0.6f) == 0) {
                return true;
            }
            if (Float.compare(f2, configFloatArrayValue[0]) < 0 || Float.compare(f2, configFloatArrayValue[1]) > 0 || aT()) {
                return false;
            }
            return true;
        } else if (Float.compare(f2, 0.6f) == 0) {
            return true;
        } else {
            if (Float.compare(f2, 1.0f) < 0 || Float.compare(f2, 2.0f) > 0) {
                return false;
            }
            return true;
        }
    }

    public boolean at() {
        SharedPreferences sharedPreferences = this.aa;
        if (sharedPreferences != null) {
            return "on".equals(sharedPreferences.getString("pref_lens_dirty_detection_key", this.Z.getString(R.string.lens_dirty_detection_default_value)));
        }
        return false;
    }

    private void fF() {
        if (!this.Y.O()) {
            return;
        }
        if (this.t) {
            au = true;
        } else {
            at = true;
        }
    }

    public void aw() {
        String string = this.aa.getString("pref_camera_mode_key", Util.a(this.X.m()));
        com.oppo.camera.e.a("BaseMode", "setForceMode, capMode: " + string + ", modeName: " + a());
        if (!string.equals(a())) {
            SharedPreferences.Editor edit = this.aa.edit();
            edit.putString("pref_camera_mode_key", a());
            edit.apply();
        }
    }

    public void e(int i2) {
        this.k = i2;
    }

    public void a(f fVar) {
        this.W = fVar;
        if (this.W != null && f("key_support_zsl")) {
            this.W.g(br());
        }
    }

    public final void ay() {
        com.oppo.camera.e.a("BaseMode", "initCameraMode");
        this.A = false;
        this.B = false;
        if (this.ab.k() != 0) {
            o(cf());
            if (!f(CameraFunction.FILTER_VIGNETTE) || !"oppo_video_filter_olympus".equals(ce())) {
                this.ab.c(false);
            } else {
                this.ab.c(true);
            }
        }
        this.H = false;
        this.k = this.X.s();
        this.B = true;
        this.ac = this.Y.b();
        this.ab.b();
        s();
        j();
        this.Y.j();
        b(d);
        bQ();
        if (cH()) {
            I(true);
        } else if (cG()) {
            H(this.t);
        }
        this.Y.a(l());
        this.Y.b(a(), true);
        this.A = true;
    }

    public final void az() {
        com.oppo.camera.e.a("BaseMode", "deInitCameraMode");
        Handler handler = this.aG;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
        }
        this.B = false;
        this.p = 0;
        a(d);
        G(false);
        if (cH()) {
            I(false);
            c("off", true);
        }
        f fVar = this.W;
        if (fVar != null) {
            if (fVar.e().H()) {
                this.W.k(false);
            } else if (cG()) {
                this.W.r(0);
            }
            this.W.a(com.oppo.camera.a.a());
        }
        l(false);
        this.C = false;
        this.D = false;
        t();
        SharedPreferences sharedPreferences = this.aa;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putString("pref_subsetting_key", "off").apply();
        }
        this.ab.d(1);
        this.A = false;
        this.ar = 0;
        this.ao = 0;
        this.ap = 0;
        cx();
    }

    public final void e(boolean z2) {
        if (this.A) {
            aC();
            f(z2);
        }
        com.oppo.camera.v.a.a().a((Context) this.Z, CameraStatisticsUtil.PORTRAIT_CAPTURE_MODE, (Object) Integer.valueOf(c()));
    }

    public final void aA() {
        this.ai = AlgoSwitchConfig.getPreviewConfig(TextUtils.isEmpty(b()) ? a() : b(), this.n);
        f fVar = this.W;
        boolean z2 = true;
        if (fVar != null) {
            fVar.o(true);
            this.W.v(0);
            this.W.f(com.oppo.camera.a.b());
            this.W.r(fl());
            this.W.n(false);
            this.W.t(aF() && (!this.t || aG()));
            if (!TextUtils.isEmpty(this.X.az())) {
                this.W.a(this.X.az().getBytes());
            }
        }
        o(cf());
        cv();
        b(false, this.ap);
        fQ();
        aD();
        b(false);
        fD();
        b(false, false);
        if (Util.p()) {
            a(false, this.ao);
        } else {
            this.L = true;
        }
        if (eB() && cC() && !CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_FLASH_FULL_ZOOM)) {
            if (f("pref_camera_flashmode_key")) {
                this.aa.edit().putString("pref_camera_flashmode_key", "off").apply();
            }
            if (f("pref_camera_videoflashmode_key")) {
                this.aa.edit().putString("pref_camera_videoflashmode_key", "off").apply();
            }
        }
        f fVar2 = this.W;
        if (fVar2 != null) {
            fVar2.a(bu());
        }
        n nVar = this.ab;
        if (nVar != null) {
            nVar.j(false);
            this.ab.d(1.0f);
        }
        u();
        n nVar2 = this.ab;
        if (nVar2 != null) {
            nVar2.g(aB());
            n nVar3 = this.ab;
            nVar3.c(nVar3.k());
        }
        if (f("pref_camera_hdr_mode_key")) {
            c(this.aa.getString("pref_camera_hdr_mode_key", CameraConfig.getOptionKeyDefaultValue("pref_camera_hdr_mode_key", this.n)), false);
        }
        l(false);
        this.C = false;
        this.D = false;
        fR();
        f fVar3 = this.W;
        if (fVar3 != null) {
            if (fVar3.e() != null && this.W.e().G()) {
                f fVar4 = this.W;
                if (!f(CameraFunction.REQUEST_FAST_LAUNCH) || !this.X.aw()) {
                    z2 = false;
                }
                fVar4.j(z2);
            }
            if (cL()) {
                this.W.l(a.C0079a.FrameAverage.ordinal());
            } else {
                this.W.l(a.C0079a.CenterWeighted.ordinal());
            }
            if (!Util.p()) {
                this.W.x();
                byte[] bArr = f.d;
                if (this.L) {
                    bArr = CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_TUNING_DATA_BUFFER_SUPPORT) ? f.f : f.e;
                }
                this.W.b(bArr);
            }
            this.W.g(DateTimeFormatter.ofPattern("XXX").format(ZonedDateTime.ofInstant(Instant.ofEpochMilli(System.currentTimeMillis()), ZoneId.systemDefault())));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0015, code lost:
        r1 = r5.aa;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void aC() {
        /*
            r5 = this;
            java.lang.String r0 = "com.oplus.track.focus.support"
            boolean r0 = com.oppo.camera.aps.config.CameraConfig.getConfigBooleanValue(r0)
            if (r0 == 0) goto L_0x004d
            com.oppo.camera.f.f r0 = r5.W
            if (r0 == 0) goto L_0x004d
            java.lang.String r0 = "pref_track_focus_key"
            boolean r1 = r5.f((java.lang.String) r0)
            r2 = 0
            if (r1 == 0) goto L_0x0030
            android.content.SharedPreferences r1 = r5.aa
            if (r1 == 0) goto L_0x0030
            android.app.Activity r3 = r5.Z
            r4 = 2131755245(0x7f1000ed, float:1.9141364E38)
            java.lang.String r3 = r3.getString(r4)
            java.lang.String r0 = r1.getString(r0, r3)
            java.lang.String r1 = "on"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L_0x0030
            r0 = 1
            goto L_0x0031
        L_0x0030:
            r0 = r2
        L_0x0031:
            r5.ay = r0
            com.oppo.camera.f.f r0 = r5.W
            boolean r1 = r5.ay
            r0.s((boolean) r1)
            com.oppo.camera.e.b r0 = r5.X
            if (r0 == 0) goto L_0x004d
            boolean r1 = r5.ay
            if (r1 == 0) goto L_0x004a
            android.util.Size r1 = r5.cp()
            r0.a((android.util.Size) r1)
            goto L_0x004d
        L_0x004a:
            r0.h(r2)
        L_0x004d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.e.a.aC():void");
    }

    /* access modifiers changed from: protected */
    public void aD() {
        n nVar;
        if (f(CameraFunction.BOKEH)) {
            f fVar = this.W;
            if (fVar != null) {
                fVar.c(et());
            }
        } else if (f(CameraFunction.FACE_BLUR) && (nVar = this.ab) != null) {
            nVar.a(et());
        }
    }

    public void f(boolean z2) {
        this.G = true;
        this.aG.removeMessages(3);
        this.aG.sendEmptyMessage(3);
        if (this.Z != null && com.oppo.camera.ui.inverse.c.INS.isInverseAble(this.Z) && f("pref_camera_torch_mode_key")) {
            this.Y.a("pref_camera_torch_mode_key", "on", this.Z.getString(R.string.camera_torch_mode_torch));
        }
        this.Y.a(ch(), dt());
        this.Y.ar();
        if (z2) {
            fC();
        }
    }

    public void g(boolean z2) {
        com.oppo.camera.ui.inverse.c.INS.setPositionRatio(this.Z, 0.5f, z2);
    }

    /* access modifiers changed from: private */
    public void fG() {
        com.oppo.camera.e.a("BaseMode", "doAfterStartPreview");
        if (!this.y && this.Y != null) {
            if (!cz() && !cB() && !cR() && !com.oppo.camera.ui.inverse.c.INS.isInverseColor(this.Z.hashCode())) {
                if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_VIDEO_3HDR) || CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_VIDEO_LIVE_HDR)) {
                    this.Y.c((int) R.string.camera_video_hdr);
                }
                if (!aE() && CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_ULTRA_NIGHT_VIDEO) && !cR()) {
                    this.Y.c((int) R.string.camera_ultra_night_video);
                }
                this.Y.a(false, true, true);
            }
            if (this.aa != null) {
                if (f("key_high_picture_size") && "standard_high".equals(this.aa.getString("pref_camera_photo_ratio_key", this.Z.getString(R.string.camera_photo_ratio_default_value)))) {
                    this.aa.edit().putBoolean("key_high_picture_size", true).commit();
                }
                if (cH()) {
                    I(true);
                } else if (cG()) {
                    H(this.t);
                }
                Handler handler = this.aG;
                if (handler != null) {
                    handler.removeMessages(2);
                    this.aG.sendEmptyMessageDelayed(2, 400);
                }
            }
        }
    }

    private final boolean c(com.oppo.camera.f.d dVar) {
        com.oppo.camera.e.a("captureX beforeSnapping");
        if (fE() == 1) {
            com.oppo.camera.e.e("BaseMode", "beforeSnapping, capturePreview not done!");
            return false;
        }
        this.l = this.X.s();
        this.K = d(dVar);
        if (!fH()) {
            com.oppo.camera.e.e("BaseMode", "beforeSnapping, check inputMemSize fail!");
            if (this.u && CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_BURST_SHOT_CACHE_SUPPORT)) {
                al();
            }
            return false;
        } else if (!aL()) {
            com.oppo.camera.e.e("BaseMode", "beforeSnapping, memory is not enough!");
            if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_MEMORY_NOT_ENOUGH_HINT)) {
                al();
            }
            ak();
            return false;
        } else {
            boolean c = this.X.c();
            com.oppo.camera.e.a("BaseMode", "beforeSnapping, ret: " + c + ", mbAutoHDR: " + this.C);
            if (!c) {
                com.oppo.camera.e.e("BaseMode", "beforeSnapping, beforeCaptureProcess return false");
                return false;
            }
            a((ImageCategory.MetaItemInfo) null);
            boolean a2 = a(dVar);
            this.Z.runOnUiThread(new Runnable() {
                public void run() {
                    if (!a.this.z) {
                        a.this.X.d(false);
                        a.this.Y.h();
                    }
                }
            });
            this.m = com.oppo.camera.f.a.b(a(this.n), this.l);
            if (!f(CameraFunction.APS_BRACKETMODE) || c(dVar.M)) {
                a(false, 0);
            } else {
                this.ao = dVar.aa;
                a(false, this.ao);
            }
            if (this.ar != dVar.ac) {
                this.ar = dVar.ac;
                b(true);
            }
            this.W.c(this.m);
            this.W.p(false);
            if (this.u) {
                this.W.d(75);
            } else {
                this.W.d(95);
            }
            this.W.a(this.X.v());
            if (!Util.p() && dVar.H != null && (!this.t || !cQ())) {
                this.W.a(true, false);
                this.M = true;
            }
            ImageCategory.MetaItemInfo metaItemInfo = new ImageCategory.MetaItemInfo();
            metaItemInfo.setParameter(ParameterKeys.KEY_CAPTURE_ALGO_LIST, dVar.G);
            metaItemInfo.setParameter(ParameterKeys.KEY_CAPTURE_FEATURE_TYPE, Integer.valueOf(dVar.ac));
            if (dVar.M != null) {
                metaItemInfo.setParameter(ParameterKeys.KEY_CAPTURE_SCENE, Integer.valueOf(dVar.M.mApsDecisionSceneMode));
                metaItemInfo.setParameter(ParameterKeys.KEY_CAPTURE_FRAME_COUNT, Integer.valueOf(dVar.M.mMultiFrameCount));
            }
            ApsService apsService = this.aj;
            dVar.ad = apsService != null ? apsService.beforeCapture(metaItemInfo) : -1;
            com.oppo.camera.e.b("captureX beforeSnapping");
            return a2;
        }
    }

    public long aI() {
        return (!bw() || !"heic_8bits".equalsIgnoreCase(eq())) ? 52428800 : 150994944;
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x00df A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean d(com.oppo.camera.f.d r13) {
        /*
            r12 = this;
            int r0 = r13.r
            r1 = 32
            if (r0 == r1) goto L_0x0024
            int r0 = r13.r
            r2 = 37
            if (r0 == r2) goto L_0x0024
            int r0 = r13.r
            r2 = 36
            if (r0 == r2) goto L_0x0024
            int r0 = r13.r
            r2 = 34
            if (r0 != r2) goto L_0x0019
            goto L_0x0024
        L_0x0019:
            com.oppo.camera.f.f r0 = r12.W
            com.oppo.camera.f.j r0 = r0.e()
            android.util.Size r0 = r12.d((com.oppo.camera.f.j) r0)
            goto L_0x002e
        L_0x0024:
            com.oppo.camera.f.f r0 = r12.W
            com.oppo.camera.f.j r0 = r0.e()
            android.util.Size r0 = r12.f((com.oppo.camera.f.j) r0)
        L_0x002e:
            boolean r2 = r13.S
            if (r2 == 0) goto L_0x0038
            java.lang.String r0 = "com.oplus.high.mfnr.picturesize"
            android.util.Size r0 = com.oppo.camera.aps.config.CameraConfig.getSizeConfigValue(r0)
        L_0x0038:
            r2 = 0
            if (r0 == 0) goto L_0x0045
            int r3 = r0.getWidth()
            int r0 = r0.getHeight()
            int r0 = r0 * r3
            goto L_0x0046
        L_0x0045:
            r0 = r2
        L_0x0046:
            int r3 = r13.r
            if (r3 == r1) goto L_0x005e
            r1 = 256(0x100, float:3.59E-43)
            if (r3 == r1) goto L_0x005b
            switch(r3) {
                case 34: goto L_0x005e;
                case 35: goto L_0x0053;
                case 36: goto L_0x005e;
                case 37: goto L_0x005e;
                default: goto L_0x0051;
            }
        L_0x0051:
            r0 = r2
            goto L_0x0066
        L_0x0053:
            float r0 = (float) r0
            r1 = 1069547520(0x3fc00000, float:1.5)
            float r0 = r0 * r1
            int r0 = (int) r0
            int r1 = r13.q
            goto L_0x0065
        L_0x005b:
            int r1 = r13.q
            goto L_0x0065
        L_0x005e:
            float r0 = (float) r0
            r1 = 1073741824(0x40000000, float:2.0)
            float r0 = r0 * r1
            int r0 = (int) r0
            int r1 = r13.q
        L_0x0065:
            int r0 = r0 * r1
        L_0x0066:
            android.app.Activity r1 = r12.Z
            android.app.ActivityManager$MemoryInfo r1 = com.oppo.camera.util.Util.e((android.content.Context) r1)
            long r3 = r1.availMem
            long r10 = r1.totalMem
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r5 = "requestNum: "
            r1.append(r5)
            int r5 = r13.q
            r1.append(r5)
            java.lang.String r5 = ", format: "
            r1.append(r5)
            int r13 = r13.r
            r1.append(r13)
            java.lang.String r13 = ", needMemory: "
            r1.append(r13)
            r13 = 1048576(0x100000, float:1.469368E-39)
            int r13 = r0 / r13
            r1.append(r13)
            java.lang.String r13 = "MB"
            r1.append(r13)
            java.lang.String r5 = ", availableMemory: "
            r1.append(r5)
            r5 = 1048576(0x100000, double:5.180654E-318)
            long r3 = r3 / r5
            r1.append(r3)
            r1.append(r13)
            java.lang.String r3 = ", totalMemory: "
            r1.append(r3)
            long r3 = r10 / r5
            r1.append(r3)
            r1.append(r13)
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            java.lang.String r3 = "checkMemoryState: "
            r13.append(r3)
            java.lang.String r1 = r1.toString()
            r13.append(r1)
            java.lang.String r13 = r13.toString()
            java.lang.String r1 = "BaseMode"
            com.oppo.camera.e.b(r1, r13)
            com.oppo.camera.aps.service.ApsService r5 = r12.aj
            if (r5 == 0) goto L_0x00e0
            long r6 = (long) r0
            long r8 = r12.aK()
            boolean r13 = r5.checkRuntimeState(r6, r8, r10)
            if (r13 == 0) goto L_0x00e0
            r2 = 1
        L_0x00e0:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.e.a.d(com.oppo.camera.f.d):boolean");
    }

    public boolean aL() {
        return this.K;
    }

    private boolean fH() {
        return !this.u || !CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_BURST_SHOT_CACHE_SUPPORT) || !this.aj.checkApsIsProcessing();
    }

    /* access modifiers changed from: protected */
    public List<Integer> f(int i2) {
        return this.t ? com.oppo.camera.ui.preview.a.g.e : com.oppo.camera.ui.preview.a.g.f;
    }

    /* access modifiers changed from: protected */
    public List<String> g(int i2) {
        return this.t ? com.oppo.camera.ui.preview.a.g.f4386b : com.oppo.camera.ui.preview.a.g.c;
    }

    /* access modifiers changed from: protected */
    public void a(boolean z2, boolean z3, boolean z4) {
        com.oppo.camera.e.e("BaseMode", "CameraTest Shutter clickable Restart");
    }

    private void e(final com.oppo.camera.f.d dVar) {
        com.oppo.camera.e.a("BaseMode", "capturePreviewData");
        if (this.Y != null && fE() == 1) {
            this.Y.a((t.a) new t.a() {
                public boolean a() {
                    return dVar.L;
                }

                public int b() {
                    a aVar = a.this;
                    int b2 = com.oppo.camera.f.a.b(aVar.a(aVar.n), dVar.F);
                    if (!a.this.t) {
                        return b2;
                    }
                    if (!a() || b2 % 180 != 0) {
                        return b2 % 180 != 0 ? 360 - b2 : b2;
                    }
                    return 180 - b2;
                }

                public void a(Bitmap bitmap) {
                    if (!dVar.o) {
                        a.this.aG.removeMessages(6);
                        a.this.aG.sendMessage(a.this.aG.obtainMessage(6, new com.oppo.camera.ui.control.e(bitmap, (long) dVar.hashCode(), dVar.an)));
                        return;
                    }
                    a.this.X.a(new com.oppo.camera.ui.control.e(bitmap));
                }

                public void a(Bitmap bitmap, long j) {
                    com.oppo.camera.e.a("BaseMode", "capturePreviewData, onPreviewCaptured, bitmap: " + bitmap + ", timeStamp: " + j);
                    boolean cQ = a.this.cQ();
                    String string = (a.this.aa == null || a.this.Z == null) ? "off" : a.this.aa.getString("pref_mirror_key", a.this.Z.getString(R.string.camera_mirror_default_value));
                    if (0 == j) {
                        a.this.Z.runOnUiThread(new Runnable() {
                            public void run() {
                                a.this.c(false, true);
                            }
                        });
                    }
                    ThumbnailProcessor.DataRequest dataRequest = new ThumbnailProcessor.DataRequest();
                    dataRequest.mThumbBitmap = bitmap;
                    dataRequest.mCapMode = a.this.a();
                    dataRequest.mResolver = a.this.Z.getApplicationContext().getContentResolver();
                    dataRequest.mPreviewSize = new Size(bitmap.getHeight(), bitmap.getWidth());
                    dataRequest.mDate = a.this.aq;
                    dataRequest.mTitle = a.this.aB;
                    dataRequest.mExif = a.this.a((ImageCategory.MetaItemInfo) null);
                    dataRequest.mMirrorState = string;
                    dataRequest.mThumbOrientation = a.this.l;
                    dataRequest.mCameraId = a.this.n;
                    a aVar = a.this;
                    dataRequest.mJpegOrientation = com.oppo.camera.f.a.b(aVar.a(aVar.n), a.this.l);
                    dataRequest.mTimeStamp = j;
                    dataRequest.mIdentity = a.this.aD;
                    dataRequest.mbBurstShot = a.this.u;
                    boolean z = true;
                    dataRequest.mRecBurstNum = a.this.u ? 1 : -1;
                    dataRequest.mbLockScreen = a.this.J;
                    dataRequest.mRequestHash = (long) dVar.hashCode();
                    dataRequest.mbUltraHighResolution = a.this.af();
                    if (!a.this.P() || !a.this.b(ParameterKeys.ALGO_NAME_SCPORTRAIT)) {
                        z = false;
                    }
                    dataRequest.mbSuperClearPortrait = z;
                    dataRequest.mHeicCodecFormat = dVar.aj;
                    if (a.this.u) {
                        dataRequest.mCshotPath = a.this.X.t();
                        dataRequest.mBurstShotFlagId = a.this.X.u();
                    }
                    ThumbnailProcessor.DataRequest unused = a.this.aA = dataRequest;
                    if (!Util.p() || !cQ || a.this.u) {
                        a.this.X.a(dataRequest);
                    }
                    a.this.b(2);
                    com.oppo.camera.e.a("BaseMode", "capturePreviewData, onPreviewCaptured, X, isInightProcess: " + cQ);
                }
            }, true, aP(), t.a.d);
        }
    }

    public final void c(boolean z2, boolean z3) {
        b(z2, z3, false);
    }

    public final void b(boolean z2, boolean z3, boolean z4) {
        if (!z2 && !this.y) {
            this.p++;
            com.oppo.camera.e.a("BaseMode", "shutterCallback, mPostCounter: " + this.p);
            this.x = false;
        }
        if (this.y) {
            com.oppo.camera.e.a("BaseMode", "shutterCallback, camera pause, so return");
            return;
        }
        if (!z2 && !cQ()) {
            this.X.e();
        }
        a(z2, z3, z4);
    }

    public boolean a(float f2) {
        float[] configFloatArrayValue;
        if (f(CameraFunction.SAT_CAMERA) && (configFloatArrayValue = CameraConfig.getConfigFloatArrayValue(ConfigDataBase.KEY_SAT_MAIN_ZOOM_RANGE)) != null && configFloatArrayValue.length == 2 && Float.compare(f2, configFloatArrayValue[0]) >= 0 && Float.compare(f2, configFloatArrayValue[1]) < 0 && !aT()) {
            return true;
        }
        return false;
    }

    public boolean b(float f2) {
        float[] configFloatArrayValue;
        if (f(CameraFunction.SAT_CAMERA) && (configFloatArrayValue = CameraConfig.getConfigFloatArrayValue(ConfigDataBase.KEY_SAT_MAIN_ZOOM_RANGE)) != null && configFloatArrayValue.length == 2 && Float.compare(f2, configFloatArrayValue[1]) < 0) {
            return true;
        }
        return false;
    }

    public final void a(byte[] bArr, int i2, int i3, String str, boolean z2, boolean z3, long j2) {
        com.oppo.camera.ui.e eVar;
        int i4;
        int i5;
        f fVar;
        b bVar = this.X;
        if (bVar != null) {
            bVar.a(bArr);
            b(bArr, z3);
        }
        if (z2) {
            if (!this.y) {
                if (i2 != 0 || i3 != 0 || (fVar = this.W) == null || this.X == null) {
                    int i6 = i3;
                    i4 = i2;
                    i5 = i6;
                } else {
                    Size d2 = d(fVar.e());
                    if (com.oppo.camera.f.a.b(a(this.n), this.X.s()) % 180 == 0) {
                        i4 = d2.getWidth();
                        i5 = d2.getHeight();
                    } else {
                        i4 = d2.getHeight();
                        i5 = d2.getWidth();
                    }
                }
                z.a aVar = new z.a();
                aVar.q = i4;
                aVar.r = i5;
                aVar.e = bArr;
                aVar.j = str;
                aVar.k = a();
                aVar.v = Util.b(bArr);
                aVar.v = this.m;
                aVar.i = null;
                aVar.F = this.J;
                aVar.n = j2;
                aVar.y = aU();
                if (this.aB != null && "raw".equalsIgnoreCase(aVar.j)) {
                    aVar.h = this.aB;
                }
                b bVar2 = this.X;
                if (bVar2 != null) {
                    bVar2.a(aVar);
                }
            } else {
                return;
            }
        }
        b bVar3 = this.X;
        if (bVar3 != null) {
            bVar3.b(bArr);
            a(bArr, z3);
        }
        if (!aV()) {
            this.G = true;
        }
        this.v = false;
        this.e = true;
        b bVar4 = this.X;
        if (bVar4 != null && bVar4.j()) {
            this.X.d(true);
        }
        if ((Camera.l || Camera.m) && this.aw && (eVar = this.Y) != null && !z3) {
            this.aw = false;
            eVar.f("pref_camera_flashmode_key");
            this.Y.f("pref_camera_videoflashmode_key");
        }
        b bVar5 = this.X;
        if (bVar5 != null) {
            bVar5.f();
        }
        com.oppo.camera.e.a("BaseMode", "pictureTakenCallback, mbInCapturing: " + this.v + ", mbNeedReloadFlashMenu: " + this.aw);
    }

    public final boolean aW() {
        com.oppo.camera.e.a("BaseMode", "burstShotCapture");
        this.u = true;
        bF();
        aX();
        if (ct()) {
            bH();
            this.I = true;
        } else {
            this.I = false;
        }
        return aZ();
    }

    /* access modifiers changed from: protected */
    public float bd() {
        b bVar = this.X;
        if (bVar != null) {
            return bVar.ad();
        }
        return 1.0f;
    }

    public final boolean be() {
        ApsAdapterDecision.DecisionResult decisionResult;
        boolean z2;
        int i2;
        this.T = false;
        synchronized (this.i) {
            this.v = true;
            decisionResult = this.af;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("capture, decisionResult: ");
        sb.append(decisionResult != null ? decisionResult.toString() : "null");
        com.oppo.camera.e.a("BaseMode", sb.toString());
        if (decisionResult == null || decisionResult.mCameraId != this.n || !decisionResult.mCaptureMode.equals(a()) || decisionResult.mMultiFrameCount <= 0) {
            this.v = false;
            com.oppo.camera.e.e("BaseMode", "capture, return");
            return false;
        }
        d(decisionResult);
        this.x = true;
        this.G = false;
        com.oppo.camera.f.d b2 = b(decisionResult);
        if (!c(b2)) {
            this.v = false;
            this.x = false;
            this.G = true;
            com.oppo.camera.e.b("captureX beforeSnapping");
            return false;
        }
        this.F = false;
        this.ah = 0;
        this.aC = 0;
        synchronized (this.i) {
            z2 = this.af != null && 30 == this.af.mApsDecisionFeatureType;
        }
        if (z2) {
            if (b2.H == null || b2.H.length <= 0) {
                i2 = 0;
            } else {
                i2 = 0;
                for (int i3 = 0; i3 < C(); i3++) {
                    if (b2.H[i3] == 0) {
                        i2++;
                    }
                }
            }
            this.W.s(i2);
        }
        if (bf()) {
            this.W.g(br());
        }
        this.S = 1 == decisionResult.mCaptureNoNeedMatchMeta;
        if (cw()) {
            this.aq = System.currentTimeMillis();
            long j2 = this.aq;
            b2.an = j2;
            this.aB = Util.a(j2, this.u);
            if (em()) {
                this.X.a(false, h() ? 1 : 0, false);
            }
            if (f("pref_support_capture_preview")) {
                b(1);
            } else {
                b(0);
            }
            this.X.e(false);
            if (this.u) {
                this.W.B(0);
                this.w = true;
                a(Util.d, b2, O(), (ApsAdapterListener.CaptureCallback) this);
            } else {
                a(C(), b2, O(), (ApsAdapterListener.CaptureCallback) this);
            }
            if (f("pref_support_capture_preview")) {
                e(b2);
                eV();
            }
        } else {
            this.X.A();
        }
        this.o = 0;
        aM();
        return true;
    }

    /* access modifiers changed from: protected */
    public void a(int i2, com.oppo.camera.f.d dVar, f.a aVar, ApsAdapterListener.CaptureCallback captureCallback) {
        this.X.a(i2, dVar, aVar, captureCallback);
    }

    public final boolean i(boolean z2) {
        if (!bk() || !z2) {
            return v();
        }
        bg();
        return true;
    }

    public void i(int i2) {
        this.n = i2;
        this.t = com.oppo.camera.f.a.c(this.n);
    }

    public void bl() {
        com.oppo.camera.ui.preview.a.g.f4385a = bm();
    }

    public void j(boolean z2) {
        this.Y.a(true, true, false);
        this.ax = false;
    }

    public boolean bn() {
        return this.G && fE() != 1;
    }

    public final boolean h(String str) {
        if (this.B) {
            return i(str);
        }
        return true;
    }

    public boolean i(String str) {
        return !"pref_camera_flashmode_key".equals(str) || a("pref_camera_flashmode_key", this.n) != null;
    }

    public List<String> a(String str, int i2) {
        return b(str, i2);
    }

    public final List<String> b(String str, int i2) {
        String c = b.c(str);
        String[] strArr = null;
        if ("pref_camera_flashmode_key".equals(c) && this.t) {
            return null;
        }
        List<String> supportedList = CameraConfig.getSupportedList(c, i2);
        if (supportedList == null) {
            supportedList = new ArrayList<>();
            if ("pref_camera_flashmode_key".equals(c)) {
                strArr = this.Z.getResources().getStringArray(R.array.flash_mode_values);
            }
            if ("pref_camera_photo_ratio_key".equals(c)) {
                strArr = this.Z.getResources().getStringArray(R.array.photo_ratio_values);
            }
            if ("pref_camera_timer_shutter_key".equals(c)) {
                strArr = this.Z.getResources().getStringArray(R.array.timer_shutter_values);
            }
            if (strArr != null) {
                for (String add : strArr) {
                    supportedList.add(add);
                }
            }
        }
        return supportedList;
    }

    public final void a(String[] strArr) {
        List<String> b2;
        if (strArr != null) {
            for (int i2 = 0; i2 < strArr.length; i2++) {
                List<String> a2 = a(strArr[i2], this.n);
                if (!(a2 == null || a2.size() < 2 || (b2 = b(strArr[i2], this.n)) == null)) {
                    for (int i3 = 0; i3 < b2.size(); i3++) {
                        String str = b2.get(i3);
                        if (!a2.contains(str)) {
                            this.Y.a(strArr[i2], str);
                        }
                    }
                }
            }
        }
    }

    public final void b(String[] strArr) {
        List<String> b2;
        if (strArr != null) {
            for (int i2 = 0; i2 < strArr.length; i2++) {
                List<String> a2 = a(strArr[i2], this.n);
                if (!(a2 == null || a2.size() < 2 || (b2 = b(strArr[i2], this.n)) == null)) {
                    for (int i3 = 0; i3 < b2.size(); i3++) {
                        String str = b2.get(i3);
                        if (!a2.contains(str)) {
                            if ("pref_camera_photo_ratio_key".equals(strArr[i2]) && str.equals(this.aa.getString("pref_camera_photo_ratio_key", this.Z.getString(R.string.camera_photo_ratio_default_value)))) {
                                SharedPreferences.Editor edit = this.aa.edit();
                                edit.putString("pref_camera_photo_ratio_key", b2.get(0));
                                edit.apply();
                            }
                            this.Y.b(strArr[i2], str);
                        }
                    }
                }
            }
        }
    }

    public void bo() {
        Activity activity;
        if ((bp() || bq()) && (activity = this.Z) != null && this.aa != null) {
            String string = activity.getResources().getString(R.string.camera_iso_default_value);
            String string2 = this.Z.getResources().getString(R.string.camera_exposure_time_default_value);
            String string3 = this.Z.getResources().getString(R.string.camera_whitebalance_default_value);
            String string4 = this.Z.getResources().getString(R.string.camera_focus_mode_default_value);
            this.aa.edit().putString("pref_professional_iso_key", string).putString("pref_professional_exposure_time_key", string2).putString("pref_professional_whitebalance_key", string3).putString("pref_professional_focus_mode_key", string4).putString("pref_professional_exposure_compensation_key", this.Z.getResources().getString(R.string.camera_exposure_compensation_default_value)).apply();
        }
    }

    /* access modifiers changed from: protected */
    public boolean bp() {
        return CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_NIGHT_PRO_MODE_SUPPORT);
    }

    /* access modifiers changed from: protected */
    public boolean bq() {
        return CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_HIGHPICTURE_PRO_MODE_SUPPORT);
    }

    public boolean br() {
        if (this.t && Util.p() && bs() != 0) {
            return false;
        }
        b bVar = this.X;
        if (bVar != null && !bVar.j() && !Util.p()) {
            return false;
        }
        if (!Util.p() || this.ao <= 0) {
            return true;
        }
        return false;
    }

    public int bs() {
        f fVar = this.W;
        if (fVar == null || fVar.e() == null || CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_ZSL_SUPPORT_PREVERSION)) {
            return -1;
        }
        return this.W.e().J();
    }

    public int bt() {
        List asList;
        f fVar = this.W;
        if (!(fVar == null || fVar.e() == null || (asList = Arrays.asList(new int[][]{this.W.e().A()})) == null || asList.size() <= 0)) {
            if (asList.contains(4)) {
                return 4;
            }
            if (asList.contains(1)) {
                return 1;
            }
        }
        com.oppo.camera.e.a("BaseMode", "getDefaultAFMode, focusMode: " + 4);
        return 4;
    }

    public String bu() {
        if (this.P) {
            return (!CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_FLASH_FULL_ZOOM) || b(bd()) || !g() || !f("pref_camera_flashmode_key") || !"torch".equals(fI())) ? "off" : "torch";
        }
        if (f("pref_camera_videoflashmode_key")) {
            return fJ();
        }
        if (f("pref_camera_film_mode_key")) {
            return fK();
        }
        if (f("pref_camera_torch_mode_key") || f(CameraFunction.TORCH_SOFT_LIGHT)) {
            String bv = bv();
            if (f(CameraFunction.TORCH_SOFT_LIGHT) && "on".equals(bv)) {
                bv = "torch";
            }
            if (!f("pref_camera_torch_mode_key") || !"on".equals(bv) || !com.oppo.camera.ui.inverse.c.INS.isInverseAble(this.Z)) {
                return bv;
            }
            return "torch";
        } else if (f("pref_camera_flashmode_key")) {
            return fI();
        } else {
            return "off";
        }
    }

    private String fI() {
        SharedPreferences sharedPreferences = this.aa;
        if (sharedPreferences != null) {
            return sharedPreferences.getString("pref_camera_flashmode_key", this.Z.getString(R.string.camera_flash_mode_default_value));
        }
        return this.Z.getString(R.string.camera_flash_mode_default_value);
    }

    /* access modifiers changed from: protected */
    public String bv() {
        SharedPreferences sharedPreferences = this.aa;
        if (sharedPreferences != null) {
            return sharedPreferences.getString("pref_camera_torch_mode_key", Util.y(this.Z));
        }
        Activity activity = this.Z;
        return activity != null ? Util.y(activity) : "off";
    }

    private String fJ() {
        Activity activity = this.Z;
        String string = activity != null ? activity.getString(R.string.camera_flash_mode_video_default_value) : "off";
        SharedPreferences sharedPreferences = this.aa;
        return sharedPreferences != null ? sharedPreferences.getString("pref_camera_videoflashmode_key", string) : string;
    }

    private String fK() {
        Activity activity = this.Z;
        String string = activity != null ? activity.getString(R.string.camera_flash_mode_video_default_value) : "off";
        SharedPreferences sharedPreferences = this.aa;
        return sharedPreferences != null ? sharedPreferences.getString("pref_camera_film_mode_key", string) : string;
    }

    private boolean fL() {
        String callingPackage = this.Z.getCallingPackage();
        return "com.android.mms".equals(callingPackage) || "com.android.contacts".equals(callingPackage) || "com.nearme.note".equals(callingPackage) || "com.coloros.note".equals(callingPackage) || "com.google.android.keep".equals(callingPackage);
    }

    public Size a(j jVar) {
        if (!fL()) {
            return null;
        }
        return Util.a(jVar.a(256), "5000000", Util.a(this.aa.getString("pref_camera_photo_ratio_key", this.Z.getString(R.string.camera_photo_ratio_default_value))));
    }

    public double by() {
        int configIntValue = CameraConfig.getConfigIntValue(ConfigDataBase.KEY_HIGH_PICTURE_SIZE_NAME, this.n) / 100;
        if (configIntValue > 0) {
            return (double) configIntValue;
        }
        return Util.a((Context) this.Z, CameraConfig.getSizeConfigValue(ConfigDataBase.KEY_HIGH_PICTURE_SIZE, this.n));
    }

    public Size a(String str, j jVar) {
        List<Size> list;
        List<Size> list2;
        int[] b2;
        if ("type_tuning_data_yuv".equals(str)) {
            int[] b3 = jVar.b((CameraCharacteristics.Key<?>) com.oppo.camera.f.c.aG);
            if (b3 != null && b3.length >= 2) {
                return new Size(b3[0], b3[1]);
            }
        } else if ("type_tuning_data_raw".equals(str) && (b2 = jVar.b((CameraCharacteristics.Key<?>) com.oppo.camera.f.c.aH)) != null && b2.length >= 2) {
            return new Size(b2[0], b2[1]);
        }
        this.f = jVar.b((CameraCharacteristics.Key<?>) com.oppo.camera.f.c.aD);
        if (ex()) {
            if (!Util.p() && w(str)) {
                return a(jVar, this.W.e(str), str);
            }
            if ("type_still_capture_yuv_main".equals(str)) {
                Size j2 = j(ConfigDataBase.KEY_SAT_WIDE_PICTURE_SIZE);
                return j2 == null ? d(jVar) : j2;
            } else if ("type_still_capture_yuv_sub".equals(str)) {
                return j(ConfigDataBase.KEY_SAT_ULTRA_PICTURE_SIZE);
            } else {
                if ("type_still_capture_yuv_third".equals(str)) {
                    return j(ConfigDataBase.KEY_SAT_TELE_PICTURE_SIZE);
                }
                if ("type_reprocess_data_yuv".equals(str)) {
                    return Util.a(new Size[]{j(ConfigDataBase.KEY_SAT_WIDE_PICTURE_SIZE), j(ConfigDataBase.KEY_SAT_ULTRA_PICTURE_SIZE), j(ConfigDataBase.KEY_SAT_TELE_PICTURE_SIZE)});
                }
            }
        } else if (f("pref_dual_camera")) {
            int[] b4 = jVar.b((CameraCharacteristics.Key<?>) com.oppo.camera.f.c.aj);
            if ("type_still_capture_yuv_main".equals(str)) {
                if (Math.abs(c(jVar) - 2.0f) > 1.0E-6f) {
                    list2 = CameraConfig.getConfigSizeListValue(ConfigDataBase.KEY_PORTRAIT_MODE_PICTURE_SIZE_1X);
                } else {
                    list2 = CameraConfig.getConfigSizeListValue(ConfigDataBase.KEY_PORTRAIT_MODE_PICTURE_SIZE_2X);
                }
                Size size = (list2 == null || list2.size() == 0) ? null : list2.get(0);
                if (size != null) {
                    return new Size(size.getWidth(), size.getHeight());
                }
                if (b4.length >= 2) {
                    return new Size(b4[0], b4[1]);
                }
            } else if ("type_still_capture_yuv_sub".equals(str)) {
                if (Math.abs(c(jVar) - 2.0f) > 1.0E-6f) {
                    list = CameraConfig.getConfigSizeListValue(ConfigDataBase.KEY_PORTRAIT_MODE_PICTURE_SIZE_1X);
                } else {
                    list = CameraConfig.getConfigSizeListValue(ConfigDataBase.KEY_PORTRAIT_MODE_PICTURE_SIZE_2X);
                }
                Size size2 = (list == null || list.size() < 2) ? null : list.get(1);
                if (size2 != null) {
                    return new Size(size2.getWidth(), size2.getHeight());
                }
                if (b4.length >= 4) {
                    return new Size(b4[2], b4[3]);
                }
            }
        } else if (!"type_video_frame".equals(str)) {
            return d(jVar);
        }
        return null;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.util.Size j(java.lang.String r7) {
        /*
            r6 = this;
            java.util.List r7 = com.oppo.camera.aps.config.CameraConfig.getConfigSizeListValue(r7)
            android.content.SharedPreferences r0 = r6.aa
            android.app.Activity r1 = r6.Z
            r2 = 2131755453(0x7f1001bd, float:1.9141786E38)
            java.lang.String r1 = r1.getString(r2)
            java.lang.String r2 = "pref_camera_photo_ratio_key"
            java.lang.String r0 = r0.getString(r2, r1)
            int r1 = r0.hashCode()
            r2 = 4
            r3 = 3
            r4 = 2
            r5 = 1
            switch(r1) {
                case -1993005596: goto L_0x0049;
                case -894674659: goto L_0x003f;
                case 1514655: goto L_0x0035;
                case 3154575: goto L_0x002b;
                case 1312628413: goto L_0x0021;
                default: goto L_0x0020;
            }
        L_0x0020:
            goto L_0x0053
        L_0x0021:
            java.lang.String r1 = "standard"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0053
            r0 = 0
            goto L_0x0054
        L_0x002b:
            java.lang.String r1 = "full"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0053
            r0 = r4
            goto L_0x0054
        L_0x0035:
            java.lang.String r1 = "16_9"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0053
            r0 = r3
            goto L_0x0054
        L_0x003f:
            java.lang.String r1 = "square"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0053
            r0 = r2
            goto L_0x0054
        L_0x0049:
            java.lang.String r1 = "standard_high"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0053
            r0 = r5
            goto L_0x0054
        L_0x0053:
            r0 = -1
        L_0x0054:
            if (r0 == 0) goto L_0x007a
            if (r0 == r5) goto L_0x007a
            if (r0 == r4) goto L_0x0071
            if (r0 == r3) goto L_0x0067
            if (r0 == r2) goto L_0x0060
            r7 = 0
            return r7
        L_0x0060:
            r0 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            android.util.Size r7 = com.oppo.camera.util.Util.c((java.util.List<android.util.Size>) r7, (double) r0)
            return r7
        L_0x0067:
            r0 = 4610685218510194460(0x3ffc71c71c71c71c, double:1.7777777777777777)
            android.util.Size r7 = com.oppo.camera.util.Util.c((java.util.List<android.util.Size>) r7, (double) r0)
            return r7
        L_0x0071:
            double r0 = com.oppo.camera.util.Util.G()
            android.util.Size r7 = com.oppo.camera.util.Util.c((java.util.List<android.util.Size>) r7, (double) r0)
            return r7
        L_0x007a:
            r0 = 4608683618675807573(0x3ff5555555555555, double:1.3333333333333333)
            android.util.Size r7 = com.oppo.camera.util.Util.c((java.util.List<android.util.Size>) r7, (double) r0)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.e.a.j(java.lang.String):android.util.Size");
    }

    public Size d(j jVar) {
        if (f("key_high_picture_size") && this.aa.getBoolean("key_high_picture_size", false)) {
            return CameraConfig.getSizeConfigValue(ConfigDataBase.KEY_HIGH_PICTURE_SIZE, this.n);
        }
        String string = this.z ? "" : this.aa.getString("pref_camera_photo_ratio_key", this.Z.getString(R.string.camera_photo_ratio_default_value));
        if (k(string)) {
            string = "standard";
        }
        List<Size> a2 = jVar.a(256);
        com.oppo.camera.e.a("BaseMode", "getPictureSize, sizeList: " + a2.toString());
        if ("standard".equals(string)) {
            return Util.c(a2, 1.3333333333333333d);
        }
        if ("full".equals(string)) {
            return Util.c(a2, Util.G());
        }
        if ("square".equals(string)) {
            return Util.c(a2, 1.0d);
        }
        if ("16_9".equals(string)) {
            return Util.c(a2, 1.7777777777777777d);
        }
        if (!"standard_high".equals(string)) {
            return null;
        }
        if (f("key_high_picture_size")) {
            return CameraConfig.getSizeConfigValue(ConfigDataBase.KEY_HIGH_PICTURE_SIZE, this.n);
        }
        return Util.c(a2, 1.3333333333333333d);
    }

    public Size a(j jVar, CameraCharacteristics cameraCharacteristics, String str) {
        Size j2;
        if (f("key_high_picture_size") && this.aa.getBoolean("key_high_picture_size", false)) {
            return CameraConfig.getSizeConfigValue(ConfigDataBase.KEY_HIGH_PICTURE_SIZE, this.n);
        }
        SharedPreferences sharedPreferences = this.aa;
        String string = sharedPreferences != null ? sharedPreferences.getString("pref_camera_photo_ratio_key", this.Z.getString(R.string.camera_photo_ratio_default_value)) : null;
        List<Size> a2 = jVar.a(35, cameraCharacteristics, str);
        if ("type_still_capture_yuv_third".equals(str) && (j2 = j((String) ConfigDataBase.KEY_SAT_TELE_PICTURE_SIZE)) != null) {
            return j2;
        }
        com.oppo.camera.e.a("BaseMode", "getPhysicalPictureSize, surfaceType: " + str + ", sizeList: " + a2.toString());
        if ("standard".equals(string)) {
            return Util.c(a2, 1.3333333333333333d);
        }
        if ("full".equals(string)) {
            return Util.c(a2, Util.G());
        }
        if ("square".equals(string)) {
            return Util.c(a2, 1.0d);
        }
        if ("16_9".equals(string)) {
            return Util.c(a2, 1.7777777777777777d);
        }
        if (!"standard_high".equals(string)) {
            return null;
        }
        if (f("key_high_picture_size")) {
            return CameraConfig.getSizeConfigValue(ConfigDataBase.KEY_HIGH_PICTURE_SIZE, this.n);
        }
        return Util.c(a2, 1.3333333333333333d);
    }

    public Size e(j jVar) {
        List<Size> configSizeListValue;
        Size d2 = d(jVar);
        double d3 = 1.3333333333333333d;
        if (!"standard".equals(Util.a(d2, this.n)) && !"standard_high".equals(Util.a(d2, this.n))) {
            if ("full".equals(Util.a(d2, this.n))) {
                d3 = Util.G();
            } else if ("square".equals(Util.a(d2, this.n))) {
                d3 = 1.0d;
            } else if ("16_9".equals(Util.a(d2, this.n))) {
                d3 = 1.7777777777777777d;
            }
        }
        List<Size> a2 = jVar.a();
        if (eB() && (configSizeListValue = CameraConfig.getConfigSizeListValue(ConfigDataBase.KEY_WIDE_NORMAL_PREVIEW_SIZE)) != null && configSizeListValue.size() > 0) {
            a2 = configSizeListValue;
        }
        List<Size> configSizeListValue2 = CameraConfig.getConfigSizeListValue(ConfigDataBase.KEY_CONTROL_PREVIEW_SIZE);
        if (configSizeListValue2 != null && configSizeListValue2.size() > 0) {
            a2 = configSizeListValue2;
        }
        com.oppo.camera.e.a("BaseMode", "getPreviewSize, sizeList: " + a2.toString());
        Size a3 = Util.a(a2, d3);
        if (Util.p() || a3 == null) {
            return a3;
        }
        return (!(a3.getWidth() % 16 == 0 && a3.getHeight() % 16 == 0) && "square".equals(Util.a(d2, this.n))) ? new Size(1088, 1088) : a3;
    }

    public Size a(j jVar, double d2) {
        List<Size> a2 = jVar.a();
        com.oppo.camera.e.a("BaseMode", "getPreviewSize, sizeList: " + a2.toString());
        return Util.a(a2, d2);
    }

    public Size a(j jVar, String str) {
        return e(jVar);
    }

    public Size f(j jVar) {
        Size c = Util.c(jVar.a(32), 1.3333333333333333d);
        com.oppo.camera.e.b("BaseMode", "getRawSize, optimalSize: " + c);
        return c;
    }

    public Size g(j jVar) {
        return e(jVar);
    }

    public String bz() {
        if (this.aa != null && f("pref_time_lapse_key")) {
            String string = this.aa.getString("pref_camera_timer_shutter_key", this.Z.getString(R.string.camera_shutter_mode_default_value));
            try {
                Integer.valueOf(string);
                return string;
            } catch (NumberFormatException unused) {
            }
        }
        return "off";
    }

    public String bA() {
        SharedPreferences sharedPreferences = this.aa;
        if (sharedPreferences != null) {
            return sharedPreferences.getString("pref_mirror_key", this.Z.getString(R.string.camera_mirror_default_value));
        }
        return null;
    }

    public String bB() {
        return this.X.Z();
    }

    public boolean bC() {
        return this.v;
    }

    public boolean bD() {
        return this.w;
    }

    public void k(boolean z2) {
        this.w = z2;
    }

    public void bF() {
        if (f("pref_camera_flashmode_key")) {
            l(false);
            this.V = bu();
            if ("on".equals(this.V) || MenuClickMsgData.VALUE_PROFESSION_AUTO.equals(this.V)) {
                this.Y.a(false, true, true);
                this.Y.b("pref_camera_flashmode_key", "off");
                f fVar = this.W;
                if (fVar != null) {
                    fVar.a("off");
                    this.W.a((f.c) null);
                }
            }
        }
        if (f("pref_camera_hdr_mode_key")) {
            this.C = false;
            this.U = this.aa.getString("pref_camera_hdr_mode_key", CameraConfig.getOptionKeyDefaultValue("pref_camera_hdr_mode_key", this.n));
            if (!"off".equals(this.U)) {
                this.Y.a(false, true, true);
                this.Y.b("pref_camera_hdr_mode_key", "off");
                c("off", false);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void bG() {
        SharedPreferences.Editor edit = this.aa.edit();
        edit.putString("pref_camera_vivid_effect_key", "on");
        edit.apply();
        this.Y.b("pref_camera_vivid_effect_key", "on");
    }

    /* access modifiers changed from: protected */
    public void bH() {
        SharedPreferences.Editor edit = this.aa.edit();
        edit.putString("pref_camera_vivid_effect_key", "off");
        edit.apply();
        this.Y.a(true, false, true);
        this.Y.b("pref_camera_vivid_effect_key", "off");
    }

    public void bI() {
        if (f("pref_camera_flashmode_key")) {
            this.V = bu();
            if ("on".equals(this.V) || MenuClickMsgData.VALUE_PROFESSION_AUTO.equals(this.V)) {
                this.Y.b("pref_camera_flashmode_key", (String) null);
                f fVar = this.W;
                if (fVar != null) {
                    fVar.a(this.V);
                    this.W.a((f.c) null);
                }
            }
        }
        if (f("pref_camera_hdr_mode_key")) {
            this.U = this.aa.getString("pref_camera_hdr_mode_key", CameraConfig.getOptionKeyDefaultValue("pref_camera_hdr_mode_key", this.n));
            if (!"off".equals(this.U)) {
                this.Y.b("pref_camera_hdr_mode_key", (String) null);
                c(this.U, false);
            }
        }
    }

    public final void bJ() {
        bE();
        this.p = 0;
        bI();
        aY();
        if (this.I) {
            this.I = false;
            bG();
        }
        if ((Camera.l || Camera.m) && this.aw) {
            this.aw = false;
            this.Y.f("pref_camera_flashmode_key");
            this.Y.f("pref_camera_videoflashmode_key");
        }
        b bVar = this.X;
        if (bVar != null) {
            bVar.d(true);
        }
    }

    public void bK() {
        com.oppo.camera.e.a("BaseMode", "onUpdateCameraSettingMenu");
        if (f("pref_filter_menu")) {
            this.Y.h("pref_filter_menu");
        } else if (f("pref_portrait_new_style_menu")) {
            this.Y.h("pref_portrait_new_style_menu");
        } else if (f("pref_video_filter_menu")) {
            this.Y.h("pref_video_filter_menu");
        } else if (f("pref_night_filter_menu")) {
            this.Y.h("pref_night_filter_menu");
        }
        if (f("pref_video_blur_menu")) {
            this.Y.h("pref_video_blur_menu");
        }
        if (f("pref_portrait_blur_menu")) {
            this.Y.h("pref_portrait_blur_menu");
        }
        b(d);
        G(f("pref_camera_hdr_mode_key"));
    }

    public void bO() {
        com.oppo.camera.e.a("BaseMode", "onEffectSurfaceCreated");
        this.aG.removeMessages(4);
        this.aG.sendEmptyMessage(4);
    }

    public void l(String str) {
        com.oppo.camera.e.a("BaseMode", "onEffectMenuChange, menuName: " + str);
        this.ae = str;
    }

    /* access modifiers changed from: protected */
    public String bP() {
        return this.ae;
    }

    /* access modifiers changed from: protected */
    public void bQ() {
        com.oppo.camera.e.a("BaseMode", "updateEffectMenuNames");
        if (f("pref_filter_process_key")) {
            if (this.ad == null) {
                this.ad = new CopyOnWriteArrayList();
            }
            this.ad.clear();
            if (f(CameraFunction.FACE_BEAUTY_PROCESS)) {
                this.ad.add("beauty");
            }
            if (f("pref_filter_process_key")) {
                this.ad.add("filter");
            }
            String bP = bP();
            int i2 = 0;
            if ("beauty".equals(bP)) {
                i2 = fN();
            } else if ("filter".equals(bP)) {
                i2 = cf();
            }
            this.X.a(true, this.ad, bP, i2);
        }
    }

    private List<String> fM() {
        if (this.ad == null) {
            bQ();
        }
        return this.ad;
    }

    public boolean bR() {
        List<String> fM = fM();
        int i2 = com.oppo.camera.ui.preview.a.g.f4385a;
        if (fM != null) {
            for (String equals : fM) {
                if ("filter".equals(equals)) {
                    i2 = cf();
                }
            }
        } else {
            com.oppo.camera.e.a("BaseMode", "hasEffectSelected, not Support filter effect.");
        }
        return i2 != com.oppo.camera.ui.preview.a.g.f4385a;
    }

    public String bS() {
        return this.Z.getString(f(this.n).get(cf()).intValue());
    }

    public void a(k kVar) {
        if (f("pref_filter_process_key")) {
            this.aG.removeMessages(5);
            Message message = new Message();
            message.obj = kVar;
            message.what = 5;
            this.aG.sendMessage(message);
        }
    }

    /* access modifiers changed from: private */
    public void b(k kVar) {
        String bP = bP();
        boolean z2 = this.t;
        b bVar = this.X;
        boolean z3 = (z2 ? 90 : 270) == com.oppo.camera.f.a.b(bVar != null ? bVar.aq() : 0) && !dt();
        if ("filter".equals(bP)) {
            com.oppo.camera.ui.preview.a.g.a(this.Z.getResources(), bP, cf(), z2, z3, g(this.n), f(this.n), kVar, e(com.oppo.camera.f.a.a(this.n)));
        }
    }

    public int bT() {
        if (f(CameraFunction.FACE_BEAUTY_CUSTOM)) {
            return 1;
        }
        return f(CameraFunction.FACE_BEAUTY_COMMON) ? 2 : 0;
    }

    public void bU() {
        String[] de = de();
        SharedPreferences sharedPreferences = this.aa;
        if (!(sharedPreferences == null || de == null)) {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            for (int i2 = 0; i2 < de.length; i2++) {
                edit.putInt(de[i2], dg()[i2]);
            }
            edit.commit();
        }
        a(dh());
        f fVar = this.W;
        if (fVar != null) {
            fVar.a((f.c) null);
        }
        n nVar = this.ab;
        if (nVar != null) {
            nVar.a(dh());
        }
    }

    public int j(int i2) {
        com.oppo.camera.e.a("BaseMode", "getFaceBeautyItemValue, index: " + i2);
        if (de() != null) {
            return this.aa.getInt(de()[i2], k(i2));
        }
        return k(i2);
    }

    public void a(int i2, int i3, boolean z2) {
        int[] dh = dh();
        if (dh == null) {
            com.oppo.camera.e.d("BaseMode", "onFaceBeautyItemValueChange, return");
            return;
        }
        dh[i2] = i3;
        n nVar = this.ab;
        if (nVar != null) {
            nVar.a(dh);
        }
        a(dh);
        f fVar = this.W;
        if (fVar != null) {
            fVar.a((f.c) null);
        }
        if (z2 && this.aa != null && de() != null) {
            SharedPreferences.Editor edit = this.aa.edit();
            edit.putInt(de()[i2], i3);
            edit.commit();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0010, code lost:
        r0 = r4.aa;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int bX() {
        /*
            r4 = this;
            java.lang.String r0 = "func_face_beauty_process"
            boolean r0 = r4.f((java.lang.String) r0)
            r1 = 0
            if (r0 != 0) goto L_0x000a
            return r1
        L_0x000a:
            java.lang.String r0 = r4.bY()
            if (r0 == 0) goto L_0x0021
            android.content.SharedPreferences r0 = r4.aa
            if (r0 == 0) goto L_0x0021
            java.lang.String r2 = r4.bY()
            int r3 = r4.ca()
            int r0 = r0.getInt(r2, r3)
            goto L_0x0022
        L_0x0021:
            r0 = r1
        L_0x0022:
            if (r0 > 0) goto L_0x0025
            return r1
        L_0x0025:
            r0 = 102(0x66, float:1.43E-43)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.e.a.bX():int");
    }

    /* access modifiers changed from: protected */
    public boolean bZ() {
        return com.oppo.camera.w.b.b();
    }

    /* access modifiers changed from: protected */
    public int ca() {
        if (bZ()) {
            return 0;
        }
        if ((!f(CameraFunction.FACE_BEAUTY_COMMON) || df() == 0) && !f(CameraFunction.FACE_BEAUTY_CUSTOM)) {
            return 0;
        }
        return 102;
    }

    /* access modifiers changed from: protected */
    public int k(int i2) {
        if (f(CameraFunction.FACE_BEAUTY_COMMON)) {
            if (i2 == 0) {
                return df();
            }
            return 0;
        } else if (f(CameraFunction.FACE_BEAUTY_CUSTOM)) {
            return dg()[i2];
        } else {
            return -100000;
        }
    }

    /* access modifiers changed from: protected */
    public boolean cb() {
        if (!f(CameraFunction.FACE_BEAUTY_PROCESS) || bX() == 0) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean cc() {
        if (!f(CameraFunction.FACE_BEAUTY_COMMON) || this.aa.getInt(bY(), 0) == 0) {
            return false;
        }
        return true;
    }

    public void l(int i2) {
        com.oppo.camera.e.a("BaseMode", "onFaceBeautyItemChange, index: " + i2);
        if (m(i2)) {
            a(i2, true);
            n nVar = this.ab;
            if (nVar != null) {
                nVar.h(i2);
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean m(int i2) {
        if (this.aa == null || bY() == null) {
            com.oppo.camera.e.d("BaseMode", "updateFaceBeautyValue, mPreferences: " + this.aa + ", key: " + bY());
            return false;
        }
        this.aa.edit().putInt(bY(), i2).apply();
        return true;
    }

    /* access modifiers changed from: protected */
    public void a(int i2, boolean z2) {
        if (this.W != null) {
            if (!f(CameraFunction.FACE_BEAUTY_PROCESS)) {
                this.W.j(0);
            } else if (fe()) {
                ((h) this.W).a(i2, 2);
            } else {
                this.W.j(i2);
            }
            if (!z2) {
                return;
            }
            if (fe()) {
                ((h) this.W).a((f.c) null, 2);
            } else {
                this.W.a((f.c) null);
            }
        }
    }

    private int fN() {
        int bX = bX();
        return f("key_beauty3d") ? bX + 1 : bX;
    }

    public String ce() {
        return f("pref_filter_process_key") ? p(cf()) : FilterPackageUtil.F_DEFAULT;
    }

    public int cf() {
        SharedPreferences sharedPreferences = this.aa;
        if (sharedPreferences == null) {
            return com.oppo.camera.ui.preview.a.g.f4385a;
        }
        return Util.a(sharedPreferences.getInt(cg(), bm()), 0, g(this.n).size() - 1);
    }

    /* access modifiers changed from: protected */
    public void n(int i2) {
        if (ct() && i2 != com.oppo.camera.ui.preview.a.g.f4385a) {
            cu();
        }
        o(i2);
        String cg = cg();
        int i3 = this.aa.getInt(cg, com.oppo.camera.ui.preview.a.g.f4385a);
        this.aa.edit().putInt(cg, i2).apply();
        com.oppo.camera.e.b("BaseMode", "onFilterItemChange, key: " + cg + ", previousIndex: " + i3 + ", previousIndex: " + i2);
        if (this.Y != null) {
            String ch = ch();
            this.Y.c(ch, i2 != com.oppo.camera.ui.preview.a.g.f4385a ? 1 : 0);
            if (i3 != com.oppo.camera.ui.preview.a.g.f4385a || i2 == com.oppo.camera.ui.preview.a.g.f4385a || dt()) {
                int i4 = com.oppo.camera.ui.preview.a.g.f4385a;
                int i5 = R.drawable.menu_effect_off_selector;
                if (i3 != i4 && i2 == com.oppo.camera.ui.preview.a.g.f4385a && !dt()) {
                    if (this.Y.s()) {
                        i5 = R.drawable.menu_effect_off_light_selector;
                    }
                    this.Y.a(ch, i5);
                } else if (i3 == com.oppo.camera.ui.preview.a.g.f4385a && i2 == com.oppo.camera.ui.preview.a.g.f4385a) {
                    this.Y.a(ch, (int) R.drawable.menu_effect_off_selector);
                }
            } else {
                this.Y.a(ch, (int) R.drawable.menu_effect_on_light);
            }
        }
    }

    public String ch() {
        return b.b("pref_filter_menu", this.as);
    }

    /* access modifiers changed from: protected */
    public void m(String str) {
        a(str, true);
    }

    public void a(String str, boolean z2) {
        if ("on".equals(str)) {
            this.Y.a(-1, fU(), false, true, false);
        } else if (MenuClickMsgData.VALUE_PROFESSION_AUTO.equals(str)) {
            if (this.E) {
                this.Y.a(-1, (int) R.drawable.flash_hint_icon, false, true, false);
            } else {
                this.Y.a(false, true, true);
            }
        } else if (!"torch".equals(str)) {
            if ("off".equals(str)) {
                l(false);
            }
            if (!cH()) {
                this.Y.a(false, true, true);
            }
        } else if (!dt()) {
            this.Y.a(-1, (int) R.drawable.torch_hint_icon, false, true, false);
        }
        f fVar = this.W;
        if (fVar != null) {
            fVar.a(str);
            if (z2) {
                this.W.a((f.c) null);
            }
        }
    }

    private boolean fO() {
        String str;
        if (this.t) {
            str = this.aa.getString("pref_camera_torch_mode_key", Util.y(this.Z));
        } else {
            str = this.aa.getString("pref_camera_flashmode_key", this.Z.getString(R.string.camera_flash_mode_default_value));
        }
        String string = this.aa.getString("pref_camera_hdr_mode_key", CameraConfig.getOptionKeyDefaultValue("pref_camera_hdr_mode_key", this.n));
        SharedPreferences.Editor edit = this.aa.edit();
        if (!"off".equals(str) && "on".equals(string)) {
            edit.putString("pref_camera_hdr_mode_key", "off");
            edit.apply();
            this.Y.f("pref_camera_hdr_mode_key");
            return true;
        } else if ((!"torch".equals(str) && !"on".equals(str)) || !MenuClickMsgData.VALUE_PROFESSION_AUTO.equals(string)) {
            return false;
        } else {
            edit.putString("pref_camera_hdr_mode_key", "off");
            edit.apply();
            this.Y.f("pref_camera_hdr_mode_key");
            return true;
        }
    }

    private boolean fP() {
        if (!f(CameraFunction.TORCH_SOFT_LIGHT)) {
            return true;
        }
        String string = this.aa.getString("pref_camera_torch_mode_key", this.Z.getString(R.string.camera_flash_mode_default_value));
        String string2 = this.aa.getString("pref_camera_hdr_mode_key", CameraConfig.getOptionKeyDefaultValue("pref_camera_hdr_mode_key", this.n));
        SharedPreferences.Editor edit = this.aa.edit();
        if (!"off".equals(string) && "on".equals(string2)) {
            edit.putString("pref_camera_hdr_mode_key", "off");
            edit.apply();
            this.Y.f("pref_camera_hdr_mode_key");
            return true;
        } else if (!"on".equals(string) || !MenuClickMsgData.VALUE_PROFESSION_AUTO.equals(string2)) {
            return false;
        } else {
            edit.putString("pref_camera_hdr_mode_key", "off");
            edit.apply();
            this.Y.f("pref_camera_hdr_mode_key");
            return true;
        }
    }

    private void G(boolean z2) {
        com.oppo.camera.e.b("BaseMode", "setHDRMenuVisibility(), flag: " + z2 + ", mCameraUIInterface: " + this.Y);
        com.oppo.camera.ui.e eVar = this.Y;
        if (eVar != null) {
            if (z2) {
                eVar.b("pref_camera_hdr_mode_key", (String) null);
                this.Y.d("pref_camera_hdr_mode_key");
                return;
            }
            eVar.e("pref_camera_hdr_mode_key");
        }
    }

    private void H(boolean z2) {
        String str;
        String str2;
        if (this.aa == null) {
            com.oppo.camera.e.a("BaseMode", "updateFlashMenuIfHDRIsAuto null  == mPreferences");
            return;
        }
        if (z2) {
            str = "pref_camera_torch_mode_key";
            str2 = "off";
        } else {
            str = "pref_camera_flashmode_key";
            str2 = MenuClickMsgData.VALUE_PROFESSION_AUTO;
        }
        String c = b.c(str);
        String string = this.aa.getString(c, str2);
        com.oppo.camera.e.a("BaseMode", "updateFlashMenuIfHDRIsAuto, flashMode: " + string);
        if ("on".equals(string) || "torch".equals(string)) {
            SharedPreferences.Editor edit = this.aa.edit();
            edit.putString(c, "off");
            edit.apply();
            com.oppo.camera.ui.e eVar = this.Y;
            if (eVar != null) {
                eVar.f(c);
            }
        }
    }

    private void I(boolean z2) {
        com.oppo.camera.e.a("BaseMode", "updateMenuWithHDRChange(), enable: " + z2);
        if (this.Y != null && z2) {
            SharedPreferences.Editor edit = this.aa.edit();
            if (this.t) {
                String c = b.c("pref_camera_torch_mode_key");
                edit.putString(c, "off");
                edit.apply();
                this.Y.f(c);
                return;
            }
            edit.putString("pref_camera_flashmode_key", "off");
            edit.apply();
            this.Y.f("pref_camera_flashmode_key");
        }
    }

    public void l(boolean z2) {
        if (this.E != z2) {
            this.E = z2;
            f fVar = this.W;
            if (fVar != null) {
                fVar.c(z2);
            }
        }
    }

    private void c(String str, boolean z2) {
        com.oppo.camera.e.a("BaseMode", "updateHDRMode, value: " + str + ", update: " + z2);
        if (this.W != null) {
            if ("off".equals(str)) {
                this.W.r(0);
                this.W.q(0);
            } else if (MenuClickMsgData.VALUE_PROFESSION_AUTO.equals(str)) {
                this.W.r(2);
                this.W.q(0);
            } else if ("on".equals(str)) {
                this.W.r(1);
                this.W.q(18);
                this.W.a("off");
            } else if ("close".equals(str)) {
                this.W.r(0);
                this.W.q(0);
            }
            if (z2) {
                this.W.a((f.c) null);
            }
        }
    }

    public boolean co() {
        return this.ay;
    }

    public Size cp() {
        return e(this.W.e());
    }

    public boolean ct() {
        if (!f("pref_camera_vivid_effect_key")) {
            return false;
        }
        SharedPreferences sharedPreferences = this.aa;
        return "on".equals(sharedPreferences != null ? sharedPreferences.getString("pref_camera_vivid_effect_key", this.Z.getString(R.string.camera_vivid_effect_off)) : "off");
    }

    public void cu() {
        SharedPreferences sharedPreferences = this.aa;
        if (sharedPreferences != null) {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putString("pref_camera_vivid_effect_key", this.Z.getString(R.string.camera_vivid_effect_off));
            edit.commit();
            this.Y.f("pref_camera_vivid_effect_key");
        }
    }

    /* access modifiers changed from: protected */
    public void o(int i2) {
        if (this.ab != null) {
            if (ct() && i2 != com.oppo.camera.ui.preview.a.g.f4385a) {
                cu();
            }
            this.ab.a(p(i2));
            return;
        }
        com.oppo.camera.e.e("BaseMode", "updateFilterParam, mPreviewEffectProcess: " + this.ab + ", mPreferences: " + this.aa);
    }

    public void cv() {
        if (this.W == null) {
            com.oppo.camera.e.d("BaseMode", "updateAISceneMode failed");
            return;
        }
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_PI_AI)) {
            this.W.h(cl() ? 1 : 0);
            this.W.x(this.Y.P());
        }
        if (fW()) {
            this.W.g(1);
        } else {
            this.W.g(0);
        }
    }

    private void fQ() {
        if (!"off".equals(this.aa.getString("pref_camera_slogan_key", this.Z.getString(R.string.camera_slogan_default_value)))) {
            if (this.W == null) {
                com.oppo.camera.e.d("BaseMode", "setSloganEnable failed");
            } else if (f("pref_camera_slogan_key")) {
                this.W.n(1);
            } else {
                this.W.n(0);
            }
        }
    }

    public final DcsMsgData a(DcsMsgData dcsMsgData) {
        com.oppo.camera.e.b("BaseMode", "getBeforeCaptureMsgCommonData");
        dcsMsgData.mScreenBrightness = this.r;
        if (dcsMsgData instanceof CaptureMsgData) {
            ((CaptureMsgData) dcsMsgData).mPicSizeType = Util.a(d(this.W.e()), this.n);
        }
        com.oppo.camera.e.b("BaseMode", "getBeforeCaptureMsgCommonData X");
        return b(dcsMsgData);
    }

    public final DcsMsgData a(DcsMsgData dcsMsgData, z.a aVar) {
        return b(dcsMsgData, aVar);
    }

    /* access modifiers changed from: protected */
    public String p(int i2) {
        return g(this.n).get(i2);
    }

    public boolean cy() {
        if (f("pref_camera_flashmode_key") && "on".equals(fI())) {
            return true;
        }
        if (cD() && this.E) {
            return true;
        }
        if (!cF() || f(CameraFunction.TORCH_SOFT_LIGHT)) {
            return cE() && this.E && !f(CameraFunction.TORCH_SOFT_LIGHT);
        }
        return true;
    }

    public boolean cz() {
        if (cC()) {
            return true;
        }
        if ((cD() && this.E) || cF()) {
            return true;
        }
        if (!cE() || !this.E) {
            return false;
        }
        return true;
    }

    public boolean cA() {
        if (!f("pref_camera_torch_mode_key")) {
            return false;
        }
        if (cF()) {
            return true;
        }
        if (!cE() || !this.E) {
            return false;
        }
        return true;
    }

    public boolean cB() {
        if (cH()) {
            return true;
        }
        if (!cG() || !this.C) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean cC() {
        if (this.P) {
            return false;
        }
        if (this.aa == null) {
            com.oppo.camera.e.a("BaseMode", "isOpenFlash mPreferences is equal null ");
            return false;
        } else if (fe() && "torch".equals(bu())) {
            return true;
        } else {
            if (("on".equals(bu()) || "torch".equals(bu())) && !this.t) {
                return true;
            }
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public boolean cD() {
        if (this.aa == null) {
            com.oppo.camera.e.a("BaseMode", "isAutoFlash mPreferences is equal null ");
            return false;
        } else if (!MenuClickMsgData.VALUE_PROFESSION_AUTO.equals(bu()) || this.t) {
            return false;
        } else {
            return true;
        }
    }

    /* access modifiers changed from: protected */
    public boolean cE() {
        SharedPreferences sharedPreferences = this.aa;
        return sharedPreferences != null && MenuClickMsgData.VALUE_PROFESSION_AUTO.equals(sharedPreferences.getString("pref_camera_torch_mode_key", Util.y(this.Z))) && f("pref_camera_torch_mode_key");
    }

    /* access modifiers changed from: protected */
    public boolean cF() {
        SharedPreferences sharedPreferences = this.aa;
        return sharedPreferences != null && "on".equals(sharedPreferences.getString("pref_camera_torch_mode_key", Util.y(this.Z))) && f("pref_camera_torch_mode_key");
    }

    public boolean cG() {
        return this.aa != null && f("pref_camera_hdr_mode_key") && MenuClickMsgData.VALUE_PROFESSION_AUTO.equals(this.aa.getString("pref_camera_hdr_mode_key", CameraConfig.getOptionKeyDefaultValue("pref_camera_hdr_mode_key", this.n)));
    }

    public boolean cH() {
        SharedPreferences sharedPreferences = this.aa;
        return sharedPreferences != null && "on".equals(sharedPreferences.getString("pref_camera_hdr_mode_key", CameraConfig.getOptionKeyDefaultValue("pref_camera_hdr_mode_key", this.n))) && f("pref_camera_hdr_mode_key");
    }

    public boolean cI() {
        return this.C;
    }

    /* access modifiers changed from: protected */
    public String cJ() {
        return b.b("pref_camera_hdr_mode_key", this.as);
    }

    /* access modifiers changed from: protected */
    public String n(String str) {
        return this.aa.getString(str, cK());
    }

    /* access modifiers changed from: protected */
    public String cK() {
        return CameraConfig.getOptionKeyDefaultValue(b.c(cJ()), this.n);
    }

    /* access modifiers changed from: protected */
    public boolean cL() {
        if (!d(CameraFunction.VIDEO_HDR)) {
            return false;
        }
        if ("on".equals(n(cJ())) || MenuClickMsgData.VALUE_PROFESSION_AUTO.equals(n(cJ()))) {
            return true;
        }
        return false;
    }

    public boolean cO() {
        return f("pref_camera_gesture_shutter_key") && "on".equals(this.aa.getString("pref_camera_gesture_shutter_key", this.Z.getString(R.string.camera_gesture_shutter_default_value)));
    }

    public void cP() {
        com.oppo.camera.e.a("BaseMode", "displayScreenHintIconInSwitchOn, isOpenFrontTorch: " + cF() + ", isOpenFlash: " + cC());
        if (ef() != 0) {
            com.oppo.camera.e.a("BaseMode", "displayScreenHintIconInSwitchOn, beauty3DMode");
        } else if (!this.Y.H()) {
            if ((!cF() && !cz() && !cB()) || this.H || dz() || this.u) {
                this.Y.a(false, true, true);
            } else if (cB()) {
                if (f(CameraFunction.VIDEO_HDR)) {
                    this.Y.a(-1, (int) R.drawable.hdr_hint_icon_3hdr, false, true, false);
                } else {
                    this.Y.a(-1, (int) R.drawable.hdr_hint_icon, false, true, false);
                }
            } else if (!"torch".equals(bu())) {
                this.Y.a(-1, fU(), false, true, false);
            } else if (!dt()) {
                this.Y.a(-1, (int) R.drawable.torch_hint_icon, false, true, false);
            }
        }
    }

    public void d(boolean z2, boolean z3) {
        if (ef() != 0) {
            com.oppo.camera.e.a("BaseMode", "displayAllIcon, beauty3DMode");
        } else if (!this.Y.H()) {
            if (z2) {
                if (f(CameraFunction.VIDEO_HDR)) {
                    this.Y.a(-1, (int) R.drawable.hdr_hint_icon_3hdr, false, false, false);
                } else {
                    this.Y.a(-1, (int) R.drawable.hdr_hint_icon, false, false, false);
                }
            } else if (z3) {
                if (this.u) {
                    return;
                }
                if (cD() || cE()) {
                    this.Y.a(-1, (int) R.drawable.flash_hint_icon, false, true, false);
                } else if (!cH()) {
                    this.Y.a(false, true, true);
                }
            } else if (!cC() && !cH() && !cF()) {
                this.Y.a(false, true, true);
            }
        }
    }

    /* access modifiers changed from: protected */
    public String a(ImageCategory.MetaItemInfo metaItemInfo) {
        f fVar;
        int a2 = com.oppo.camera.h.b.a(da(), this.n);
        int b2 = com.oppo.camera.f.a.b(a(this.n), this.l);
        if (b2 > 0) {
            a2 |= 32;
        }
        if (bX() > 0) {
            a2 |= 2;
        }
        if (af()) {
            a2 |= OppoExifTag.EXIF_TAG_SUPER_HIGH_RESOLUTION;
        }
        if (eu()) {
            a2 |= 16;
        }
        if (cf() != com.oppo.camera.ui.preview.a.g.f4385a) {
            a2 |= 1024;
        }
        if (metaItemInfo != null && "1".equals(metaItemInfo.get(ParameterKeys.KEY_SUPER_TEXT_ENABLE))) {
            a2 |= 4096;
        }
        com.oppo.camera.e.b("BaseMode", "getExif, exif: " + a2 + ", jpegOrientation: " + b2);
        if (!Util.p() && (fVar = this.W) != null) {
            fVar.E(a2);
        }
        return OppoExifTag.EXIF_TAG_PREFIX + a2;
    }

    /* access modifiers changed from: protected */
    public String da() {
        return a();
    }

    /* access modifiers changed from: protected */
    public void dd() {
        if (f(CameraFunction.FACE_BEAUTY_PROCESS)) {
            int bX = bX();
            com.oppo.camera.e.a("BaseMode", "applyBeautyParam, index: " + bX);
            a(bX, false);
            a(dh());
            n nVar = this.ab;
            if (nVar != null) {
                nVar.h(bX);
                this.ab.a(dh());
                return;
            }
            return;
        }
        a(0, false);
        n nVar2 = this.ab;
        if (nVar2 != null) {
            nVar2.h(0);
        }
    }

    /* access modifiers changed from: protected */
    public int df() {
        if (!bZ() && this.t) {
            return di();
        }
        return 0;
    }

    /* access modifiers changed from: protected */
    public int[] dg() {
        return f2784a;
    }

    /* access modifiers changed from: protected */
    public int[] dh() {
        String[] de = de();
        if (de == null) {
            com.oppo.camera.e.d("BaseMode", "getCustomBeautyValues, customBeautyKeys null");
            return null;
        }
        int[] iArr = new int[de.length];
        if (f(CameraFunction.FACE_BEAUTY_CUSTOM)) {
            for (int i2 = 0; i2 < de.length; i2++) {
                SharedPreferences sharedPreferences = this.aa;
                if (sharedPreferences != null) {
                    iArr[i2] = sharedPreferences.getInt(de[i2], dg()[i2]);
                } else {
                    iArr[i2] = dg()[i2];
                }
            }
        } else if (f(CameraFunction.FACE_BEAUTY_COMMON)) {
            SharedPreferences sharedPreferences2 = this.aa;
            if (sharedPreferences2 != null) {
                iArr[0] = sharedPreferences2.getInt(de[0], df());
            } else {
                iArr[0] = 0;
            }
            for (int i3 = 1; i3 < de.length; i3++) {
                iArr[i3] = 0;
            }
        } else {
            for (int i4 = 0; i4 < de.length; i4++) {
                iArr[i4] = 0;
            }
        }
        return iArr;
    }

    /* access modifiers changed from: protected */
    public void a(int[] iArr) {
        f fVar;
        if ((CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_NEED_HAL_HANDING_FACE_BEAUTY) || !Util.p()) && (fVar = this.W) != null && iArr != null) {
            fVar.a(Util.a(iArr));
        }
    }

    public ab dl() {
        ab abVar = new ab();
        abVar.f2754a = dR();
        abVar.f2755b = dS();
        abVar.a(g());
        abVar.b(ex());
        abVar.c(eB());
        abVar.d(f("pref_none_sat_ultra_wide_angle_key"));
        abVar.e(f("pref_none_sat_tele_angle_key"));
        abVar.j(this.t);
        abVar.m(f("key_night_tripod_zoom_hide_ultra_wide"));
        abVar.w(dz());
        return abVar;
    }

    public String dp() {
        String dq = dq();
        SharedPreferences sharedPreferences = this.aa;
        if (sharedPreferences == null || dq == null) {
            return null;
        }
        return sharedPreferences.getString(dq, (String) null);
    }

    public long ds() {
        return this.aq;
    }

    public h.a du() {
        return h.a.Polarr;
    }

    public void dx() {
        com.oppo.camera.e.a("BaseMode", "onUiModeChanged");
    }

    public void a(SharedPreferences sharedPreferences, String str) {
        String c = b.c(str);
        if ("pref_camera_flashmode_key".equals(c)) {
            String string = sharedPreferences.getString("pref_camera_flashmode_key", this.Z.getString(R.string.camera_flash_mode_default_value));
            com.oppo.camera.e.a("BaseMode", "onSharedPreferenceChanged, flashMode: " + string + ", mbAutoFlash: " + this.E);
            if (Camera.l || Camera.m) {
                this.aw = true;
                if (!"off".equals(string)) {
                    SharedPreferences.Editor edit = this.aa.edit();
                    edit.putString("pref_camera_flashmode_key", "off");
                    edit.apply();
                    this.Y.f("pref_camera_flashmode_key");
                } else {
                    l(false);
                    d(this.C, this.E);
                    if (Camera.m) {
                        this.Y.a((int) R.string.camera_high_temperature_flash_disable, -1, true, false, false);
                    } else if (Camera.l) {
                        this.Y.a((int) R.string.camera_low_battery_flash_disable, -1, true, false, false);
                    }
                }
            } else {
                m(string);
                fO();
            }
        }
        if ("pref_camera_photo_ratio_key".equals(c)) {
            g(true);
        }
        if ("pref_camera_torch_mode_key".equals(c)) {
            if (!f(CameraFunction.TORCH_SOFT_LIGHT) || (!Camera.l && !Camera.m)) {
                String string2 = sharedPreferences.getString(c, "off");
                if ("on".equals(string2)) {
                    this.Y.a(-1, (int) R.drawable.torch_hint_icon, false, true, false);
                } else if (MenuClickMsgData.VALUE_PROFESSION_AUTO.equals(string2)) {
                    if (this.E) {
                        this.Y.a(-1, (int) R.drawable.flash_hint_icon, false, true, false);
                    } else if (!cH()) {
                        this.Y.a(false, true, true);
                    }
                } else if (!cH()) {
                    this.Y.a(false, true, true);
                }
                if (f(CameraFunction.TORCH_SOFT_LIGHT)) {
                    fP();
                } else {
                    fO();
                }
                if (this.W != null) {
                    String str2 = "torch";
                    if (f(CameraFunction.TORCH_SOFT_LIGHT) && "on".equals(string2)) {
                        string2 = str2;
                    }
                    if (!f("pref_camera_torch_mode_key") || !"on".equals(string2) || !com.oppo.camera.ui.inverse.c.INS.isInverseAble(this.Z)) {
                        str2 = string2;
                    }
                    this.W.a(str2);
                    this.W.a((f.c) null);
                }
            } else {
                this.aw = true;
                l(false);
                d(this.C, this.E);
                if (!"off".equals(sharedPreferences.getString(c, "off"))) {
                    if (Camera.m) {
                        this.Y.a((int) R.string.camera_high_temperature_flash_disable, -1, true, false, false);
                    } else if (Camera.l) {
                        this.Y.a((int) R.string.camera_low_battery_flash_disable, -1, true, false, false);
                    }
                    SharedPreferences.Editor edit2 = this.aa.edit();
                    edit2.putString("pref_camera_torch_mode_key", "off");
                    edit2.apply();
                    this.Y.f("pref_camera_torch_mode_key");
                }
            }
        }
        if ("pref_camera_vivid_effect_key".equals(c) && ct() && ae()) {
            n(com.oppo.camera.ui.preview.a.g.f4385a);
            if ("filter".equals(bP())) {
                this.Y.b(this.Z.getString(R.string.camera_filter_none), com.oppo.camera.ui.preview.a.g.f4385a);
            }
        }
        if ("slow_video_high_frame_reddot_show".equals(c) && !sharedPreferences.getBoolean("slow_video_high_frame_reddot_show", true)) {
            this.Y.o(2);
        }
        if ("id_photo_reddot_show".equals(c) && !sharedPreferences.getBoolean("id_photo_reddot_show", true)) {
            this.Y.o(13);
        }
        if ("multi_video_reddot_show".equals(c) && !sharedPreferences.getBoolean("multi_video_reddot_show", true)) {
            this.Y.o(14);
        }
        if ("profession_reddot_show".equals(c) && !sharedPreferences.getBoolean("profession_reddot_show", true)) {
            this.Y.o(4);
        }
        if ("double_exposure_reddot_show".equals(c) && !sharedPreferences.getBoolean("double_exposure_reddot_show", true)) {
            this.Y.o(18);
        }
        if ("timelapse_tiltshift_reddot_show".equals(c) && !sharedPreferences.getBoolean("timelapse_tiltshift_reddot_show", true)) {
            this.Y.o(1);
        }
        if ("pref_camera_statement_agree".equals(c)) {
            fC();
        }
    }

    private void A(String str) {
        if (f("pref_camera_hdr_mode_key")) {
            c(str, true);
            I("on".equals(str));
        }
        if ("on".equals(str)) {
            if (this.Z == null) {
                return;
            }
            if (!f(CameraFunction.VIDEO_HDR)) {
                this.Y.a(-1, (int) R.drawable.hdr_hint_icon, false, true, false);
            } else if (c("key_video_hdr")) {
                this.Y.a(this.Z.getString(R.string.camera_video_hdr), 0, (int) R.color.screen_hint_text_color);
            } else {
                this.Y.a(-1, (int) R.drawable.hdr_hint_icon_3hdr, false, true, false);
            }
        } else if (f("pref_camera_hdr_mode_key")) {
            if (!cC() && !cF() && !cG()) {
                if (!((cD() || cE()) && this.E)) {
                    this.Y.a(false, true, true);
                }
            }
            if (MenuClickMsgData.VALUE_PROFESSION_AUTO.equals(str)) {
                this.C = true;
                H(this.t);
            }
        } else if (f("key_video_hdr")) {
            this.Y.a(false, true, true);
        }
    }

    public void o(String str) {
        String n2 = n(str);
        if (this.X.h() != 0) {
            c(n2, true);
            A(n2);
        }
    }

    /* access modifiers changed from: protected */
    public void dy() {
        boolean dz = dz();
        n nVar = this.ab;
        if (nVar != null) {
            nVar.d(dz);
            if (dz) {
                this.ab.c(dD());
            }
        }
    }

    public void a(TiltShiftParam tiltShiftParam) {
        n nVar = this.ab;
        if (nVar != null) {
            nVar.a(tiltShiftParam);
        }
    }

    /* access modifiers changed from: protected */
    public float dD() {
        return z(dE());
    }

    /* access modifiers changed from: protected */
    public int dE() {
        if (f(CameraFunction.TILT_SHIFT)) {
            return this.aa.getInt("pref_tilt_shift_blur_menu_index", 60);
        }
        return 60;
    }

    public void c(int i2, boolean z2) {
        com.oppo.camera.e.a("BaseMode", "changeModeAllViewWhenAnimation, animType: " + i2 + ", isShow: " + z2);
        if (5 == i2) {
            if (z2) {
                this.e = false;
                this.H = false;
                this.C = false;
                if (this.Y != null && !this.t && "on".equals(bu())) {
                    this.Y.a(-1, (int) R.drawable.flash_hint_icon, false, false, false);
                    return;
                }
                return;
            }
            this.H = true;
            com.oppo.camera.ui.e eVar = this.Y;
            if (eVar != null) {
                eVar.a(true, true, false);
            }
        } else if (6 == i2) {
            A(n(cJ()));
            this.Y.f("pref_camera_hdr_mode_key");
        } else if (2 == i2) {
            if (z2) {
                this.Y.i(z2);
                this.Y.j(z2);
            }
        } else if (10 == i2) {
            if (this.Y != null) {
                if (z2 && "on".equals(bu())) {
                    this.Y.a(-1, (int) R.drawable.flash_hint_icon, false, false, false);
                } else if (!cH() || !z2) {
                    this.Y.a(true, true, false);
                } else if (f(CameraFunction.VIDEO_HDR)) {
                    this.Y.a(-1, (int) R.drawable.hdr_hint_icon_3hdr, false, true, false);
                } else {
                    this.Y.a(-1, (int) R.drawable.hdr_hint_icon, false, true, false);
                }
            }
        } else if (1 == i2 && !z2) {
            if (h()) {
                if (aF()) {
                    this.Y.b((int) R.string.camera_ai_enhancement_video_on_hint);
                } else {
                    this.Y.b((int) R.string.camera_ai_enhancement_video_off_hint);
                }
                if (p("key_bubble_type_ai_enhancement_video")) {
                    this.Y.c(7, true);
                }
                this.Y.b((int) R.string.camera_ai_allmighty_video_hdr_hint);
                this.Y.b((int) R.string.camera_ai_allmighty_video_night_hint);
                this.Y.b((int) R.string.camera_video_blur_open);
                this.Y.b((int) R.string.camera_video_retention_open);
            } else if (cm()) {
                this.Y.b((int) R.string.camera_pi_ai_scenes_on_hint);
            } else {
                this.Y.b((int) R.string.camera_pi_ai_scenes_off_hint);
            }
            this.Y.b((int) R.string.camera_toast_clean_lens_suggestion);
        }
    }

    public void n(boolean z2) {
        this.J = z2;
    }

    public boolean p(String str) {
        if (this.aa == null) {
            com.oppo.camera.e.e("BaseMode", "isBubbleOpen, mPreference null");
            return false;
        } else if ("key_bubble_short_video".equals(str)) {
            return this.aa.getBoolean(str, false);
        } else {
            return this.aa.getBoolean(str, true);
        }
    }

    public boolean q(String str) {
        SharedPreferences sharedPreferences = this.aa;
        if (sharedPreferences != null) {
            return sharedPreferences.contains(str);
        }
        com.oppo.camera.e.e("BaseMode", "containsBubbleKey, mPreference null");
        return true;
    }

    public void b(String str, boolean z2) {
        SharedPreferences sharedPreferences = this.aa;
        if (sharedPreferences == null) {
            com.oppo.camera.e.e("BaseMode", "updateBubbleValue, mPreference null");
            return;
        }
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putBoolean(str, z2);
        edit.commit();
    }

    public CameraStatisticsUtil.MakerNote dY() {
        CameraStatisticsUtil.MakerNote makerNote = new CameraStatisticsUtil.MakerNote();
        if (this.ab != null && e("pref_filter_process_key")) {
            makerNote.O = String.valueOf(cf());
        }
        return makerNote;
    }

    public void v(int i2) {
        this.r = i2;
    }

    public void t(boolean z2) {
        this.T = z2;
    }

    public void a(byte[] bArr, int i2, int i3, int i4, boolean z2) {
        StringBuilder sb = new StringBuilder();
        sb.append("onPictureCallback, data size: ");
        sb.append(bArr != null ? Integer.valueOf(bArr.length) : null);
        sb.append(", width: ");
        sb.append(i2);
        sb.append(", height: ");
        sb.append(i3);
        sb.append(", imageFormat: ");
        sb.append(i4);
        sb.append(", isBurstShot: ");
        sb.append(z2);
        com.oppo.camera.e.a("BaseMode", sb.toString());
        if (!z2) {
            this.aG.removeMessages(1);
        }
        Message message = new Message();
        Bundle bundle = new Bundle();
        bundle.putByteArray("picture_data", bArr);
        bundle.putInt("picture_width", i2);
        bundle.putInt("picture_height", i3);
        bundle.putInt("picture_format", i4);
        bundle.putBoolean("is_burst_shot", z2);
        message.setData(bundle);
        message.what = 1;
        this.aG.sendMessage(message);
    }

    /* access modifiers changed from: private */
    public void b(byte[] bArr, int i2, int i3, int i4, boolean z2) {
        int i5;
        int i6;
        com.oppo.camera.e.a("BaseMode", "doOnPictureCallback, mbPaused: " + this.y);
        if (!this.y) {
            b bVar = this.X;
            int s2 = bVar != null ? bVar.s() : this.l;
            if (s2 == 0 || s2 == 180) {
                i5 = i2;
                i6 = i3;
            } else {
                i6 = i2;
                i5 = i3;
            }
            a(bArr, i6, i5, Util.a(i4), bArr != null, z2, 0);
        }
    }

    public boolean r(String str) {
        if ("type_main_preview_frame".equals(str)) {
            if (3 == AlgoSwitchConfig.getApsVersion()) {
                return true;
            }
            return false;
        } else if ("type_still_capture_yuv_main".equals(str)) {
            return true;
        } else {
            if ("type_still_capture_raw".equals(str)) {
                if (!f("pref_support_raw_post_process") || CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_DISABLE_RAW)) {
                    return false;
                }
                return true;
            } else if ("type_tuning_data_yuv".equals(str)) {
                if (Util.p() || !CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_TUNING_DATA_BUFFER_SUPPORT)) {
                    return false;
                }
                return true;
            } else if (!"type_tuning_data_raw".equals(str) || Util.p() || !CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_TUNING_DATA_BUFFER_SUPPORT) || !f("pref_support_raw_post_process")) {
                return false;
            } else {
                return true;
            }
        }
    }

    public boolean ea() {
        if (this.z) {
            return false;
        }
        if (this.X.C()) {
            return true;
        }
        if (2 == this.X.h() && this.S) {
            return false;
        }
        if (1 != this.X.h() && 2 != this.X.h()) {
            return true;
        }
        if (this.ai == null) {
            this.ai = AlgoSwitchConfig.getPreviewConfig(TextUtils.isEmpty(b()) ? a() : b(), this.n);
            if (this.ai == null) {
                com.oppo.camera.e.e("BaseMode", "matchPreviewTimestamp, config is null");
                return false;
            }
        }
        for (String next : this.ai.mComponentMap.keySet()) {
            AlgoSwitchConfig.PreviewConfig.Component component = this.ai.mComponentMap.get(next);
            if ((!g() || !AlgoSwitchConfig.APS_PIPELINE_VIDEO.equals(next)) && component.mbEnable && component.mAlgoList.length >= 1) {
                ArrayList arrayList = new ArrayList();
                Collections.addAll(arrayList, component.mAlgoList);
                if (AlgoSwitchConfig.APS_PIPELINE_PREVIEW.equals(next)) {
                    if (bX() == 0) {
                        arrayList.remove(ParameterKeys.PREVIEW_ALGO_NAME_FB);
                    }
                    if (!eB()) {
                        arrayList.remove("preview_rectify");
                    }
                }
                if (arrayList.size() >= 1 && !ParameterKeys.PREVIEW_ALGO_NAME_DEFAULT.equals(arrayList.get(0))) {
                    return true;
                }
            }
        }
        return false;
    }

    public void ed() {
        if (!f("pref_camera_torch_mode_key")) {
            fV();
        }
        if (!this.X.P()) {
            return;
        }
        if (ae() || bX() != 0) {
            this.Y.B();
        }
    }

    /* access modifiers changed from: protected */
    public void a(com.oppo.camera.f.d dVar, CaptureRequest.Builder builder, HashMap<String, f.C0084f> hashMap, int i2) {
        if (d.a.PREVIEW != dVar.a() && !f(CameraFunction.NEED_PREVIEW_STREAM)) {
            builder.removeTarget(hashMap.get("type_main_preview_frame").a());
            if (hashMap.containsKey("type_sub_preview_frame")) {
                builder.removeTarget(hashMap.get("type_sub_preview_frame").a());
            }
            if (hashMap.containsKey("type_third_preview_frame")) {
                builder.removeTarget(hashMap.get("type_third_preview_frame").a());
            }
        }
    }

    /* access modifiers changed from: protected */
    public int y(int i2) {
        if (com.oppo.camera.f.a.c(i2)) {
            return CameraConfig.getConfigIntValue(ConfigDataBase.KEY_DEFAULT_TO_REAL_SWITCH_ANIM_TIME);
        }
        return CameraConfig.getConfigIntValue(ConfigDataBase.KEY_DEFAULT_TO_FRONT_SWITCH_ANIM_TIME);
    }

    /* access modifiers changed from: protected */
    public boolean em() {
        if (f("pref_camera_slogan_key")) {
            return "on".equals(this.aa.getString("pref_camera_slogan_key", this.Z.getString(R.string.camera_slogan_default_value)));
        }
        if (f("pref_camera_video_slogan_key")) {
            return "on".equals(this.aa.getString("pref_camera_video_slogan_key", this.Z.getString(R.string.camera_slogan_default_value)));
        }
        return false;
    }

    public String eq() {
        if (this.aa == null || ck() || this.u || !this.X.j() || !g() || dO()) {
            return null;
        }
        if (er()) {
            return "heic_10bits";
        }
        if ("HEIF".equals(this.aa.getString("pref_photo_codec_key", "JPEG"))) {
            return "heic_8bits";
        }
        return null;
    }

    public boolean er() {
        SharedPreferences sharedPreferences = this.aa;
        if (sharedPreferences == null) {
            return false;
        }
        String string = sharedPreferences.getString("pref_10bits_heic_encode_key", "off");
        if (!f("pref_10bits_heic_encode_key") || !"on".equals(string) || this.z || !this.X.j()) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public int es() {
        if (dz()) {
            return this.aa.getInt("pref_tilt_shift_blur_menu_index", 60);
        }
        if (f(CameraFunction.BOKEH) || f(CameraFunction.FACE_BLUR)) {
            return this.aa.getInt("pref_portrait_blur_menu_index", 60);
        }
        if (f(CameraFunction.VIDEO_BLUR_PROCESS)) {
            return this.aa.getInt("pref_video_blur_menu_index", 60);
        }
        return 60;
    }

    /* access modifiers changed from: protected */
    public float et() {
        return z(es());
    }

    /* access modifiers changed from: protected */
    public float z(int i2) {
        return new BigDecimal(i2).multiply(com.oppo.camera.d.c).floatValue();
    }

    /* access modifiers changed from: protected */
    public void A(int i2) {
        com.oppo.camera.e.a("BaseMode", "setBlurIndex, index: " + i2);
        float z2 = z(i2);
        if (f(CameraFunction.BOKEH)) {
            f fVar = this.W;
            if (fVar != null) {
                fVar.c(z2);
                this.W.a((f.c) null);
            }
            this.aa.edit().putInt("pref_portrait_blur_menu_index", i2).apply();
        } else if (f(CameraFunction.FACE_BLUR)) {
            n nVar = this.ab;
            if (nVar != null) {
                nVar.a(z2);
            }
            this.aa.edit().putInt("pref_portrait_blur_menu_index", i2).apply();
        } else if (dz()) {
            SharedPreferences.Editor edit = this.aa.edit();
            edit.putInt("pref_tilt_shift_blur_menu_index", i2);
            edit.apply();
            dy();
        } else if (f(CameraFunction.VIDEO_BLUR_PROCESS)) {
            n nVar2 = this.ab;
            if (nVar2 != null) {
                nVar2.b(z2);
            }
            SharedPreferences.Editor edit2 = this.aa.edit();
            edit2.putInt("pref_video_blur_menu_index", i2);
            if (i2 == 0) {
                edit2.putString("pref_video_blur_menu", "off");
            } else {
                edit2.putString("pref_video_blur_menu", "on");
            }
            if (!f(CameraFunction.SAT_CAMERA)) {
                edit2.putBoolean("pref_video_blur_menu_state", i2 != 0);
            }
            edit2.apply();
            this.Y.f("pref_video_blur_menu");
        }
    }

    public boolean ex() {
        return f(CameraFunction.SAT_CAMERA);
    }

    public boolean eB() {
        SharedPreferences sharedPreferences;
        if (!f("pref_none_sat_ultra_wide_angle_key") || (sharedPreferences = this.aa) == null) {
            return false;
        }
        return "on".equals(sharedPreferences.getString("pref_none_sat_ultra_wide_angle_key", this.Z.getString(R.string.ultra_wide_angle_default_value)));
    }

    public boolean eC() {
        SharedPreferences sharedPreferences;
        if (!f("pref_none_sat_tele_angle_key") || (sharedPreferences = this.aa) == null) {
            return false;
        }
        return "on".equals(sharedPreferences.getString("pref_none_sat_tele_angle_key", this.Z.getString(R.string.tele_angle_default_value)));
    }

    public void eF() {
        this.ax = false;
    }

    private void fR() {
        f fVar;
        if (this.t && (fVar = this.W) != null) {
            fVar.d(TextUtils.equals(bA(), "off"));
        }
    }

    /* access modifiers changed from: protected */
    public void x(boolean z2) {
        this.am = z2;
    }

    public void a(com.oppo.camera.t.a aVar) {
        this.ag = aVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000e, code lost:
        r1 = r3.aa;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean eO() {
        /*
            r3 = this;
            boolean r0 = com.oppo.camera.util.Util.T()
            if (r0 == 0) goto L_0x0020
            java.lang.String r0 = "pref_qr_code_key"
            boolean r1 = r3.f((java.lang.String) r0)
            if (r1 == 0) goto L_0x0020
            android.content.SharedPreferences r1 = r3.aa
            if (r1 == 0) goto L_0x0020
            java.lang.String r2 = "on"
            java.lang.String r0 = r1.getString(r0, r2)
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x0020
            r0 = 1
            goto L_0x0021
        L_0x0020:
            r0 = 0
        L_0x0021:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.e.a.eO():boolean");
    }

    /* access modifiers changed from: protected */
    public ImageCategory.ItemInfoType eR() {
        return ImageCategory.ItemInfoType.PREVIEW;
    }

    /* access modifiers changed from: protected */
    public boolean eT() {
        return CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_FRONT_SENSOR_BINNING) && this.t;
    }

    public long eU() {
        return CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_PREVIEW_YUV_FORMAT_NV12) ? 256 : 259;
    }

    public void a(TotalCaptureResult totalCaptureResult) {
        if (com.oppo.camera.ui.inverse.c.INS.isInverseAble(this.Z)) {
            b(totalCaptureResult);
        } else {
            c(totalCaptureResult);
        }
        d(totalCaptureResult);
    }

    public void y(boolean z2) {
        this.P = z2;
    }

    public void eZ() {
        com.oppo.camera.e.a("BaseMode", "clearApsDecisionResult");
        synchronized (this.i) {
            this.af = null;
        }
    }

    public void z(boolean z2) {
        com.oppo.camera.e.a("BaseMode", "setNeedCapture, needCapture: " + z2);
        if (z2) {
            this.v = false;
            b(0);
        }
        synchronized (this.j) {
            this.Q = z2;
        }
    }

    public int fi() {
        return 1 == this.Z.getResources().getConfiguration().getLayoutDirection() ? R.anim.gallery_in_rtl : R.anim.gallery_in;
    }

    public float fj() {
        return this.g;
    }

    public boolean b(int i2, int i3) {
        return i3 >= this.Y.Z() && i3 <= this.Y.aa();
    }

    public int fk() {
        return Util.E();
    }

    public void a(ApsService apsService) {
        this.aj = apsService;
    }

    private void b(TotalCaptureResult totalCaptureResult) {
        if (f("pref_camera_torch_mode_key")) {
            if (this.v) {
                com.oppo.camera.ui.inverse.c.INS.removeMessages();
                return;
            }
            String string = this.aa.getString("pref_camera_torch_mode_key", Util.y(this.Z));
            int threshold = com.oppo.camera.ui.inverse.c.INS.getThreshold();
            int thresholdRecover = com.oppo.camera.ui.inverse.c.INS.getThresholdRecover();
            if (threshold > 0) {
                if (MenuClickMsgData.VALUE_PROFESSION_AUTO.equals(string)) {
                    if (fn()) {
                        if (com.oppo.camera.ui.inverse.c.INS.isInverseColor(this.Z.hashCode())) {
                            com.oppo.camera.ui.inverse.c.INS.postInverseColor(this.Z.hashCode(), false, false);
                        }
                        com.oppo.camera.ui.inverse.c.INS.removeMessages();
                        fS();
                    } else {
                        float a2 = Util.a((CaptureResult) totalCaptureResult);
                        com.oppo.camera.e.a("BaseMode", "updateScreenState, currentLux: " + a2 + ", threshold: " + threshold);
                        if (((float) threshold) <= a2) {
                            if (!com.oppo.camera.ui.inverse.c.INS.setInverseDelay(this.Z, true, true, new c.a() {
                                public final void call() {
                                    a.this.fY();
                                }
                            })) {
                                fS();
                            }
                            if (com.oppo.camera.ui.inverse.c.INS.isInverseColor(this.Z.hashCode()) && !this.Y.ah()) {
                                this.Y.a(-1, (int) R.drawable.flash_hint_icon, false, true, false);
                            }
                        } else if (((float) thresholdRecover) <= a2) {
                            fS();
                            if (com.oppo.camera.ui.inverse.c.INS.isInverseColor(this.Z.hashCode()) && !this.Y.ah()) {
                                this.Y.a(-1, (int) R.drawable.flash_hint_icon, false, true, false);
                            }
                        } else if (!com.oppo.camera.ui.inverse.c.INS.setInverseDelay(this.Z, false, true, new c.a() {
                            public final void call() {
                                a.this.fX();
                            }
                        })) {
                            fS();
                        }
                    }
                }
                fT();
            }
        } else if (h) {
            fV();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void fY() {
        this.Y.a(-1, (int) R.drawable.flash_hint_icon, false, true, false);
        fS();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void fX() {
        d(this.C, false);
        fS();
    }

    private void fS() {
        if (com.oppo.camera.ui.inverse.c.INS.isInverseColor(this.Z.hashCode()) && !"torch".equals(this.W.q())) {
            this.W.a("torch");
            this.W.a((f.c) null);
        } else if (!com.oppo.camera.ui.inverse.c.INS.isInverseColor(this.Z.hashCode()) && !"off".equals(this.W.q())) {
            this.W.a("off");
            this.W.a((f.c) null);
        }
    }

    private void fT() {
        if (com.oppo.camera.ui.inverse.c.INS.isInverseColor(this.Z.hashCode())) {
            if (!h || com.oppo.camera.ui.inverse.c.INS.getCurrentHighBrightnessValue() != fo()) {
                com.oppo.camera.ui.inverse.c.INS.setCurrentHighBrightnessValue(fo());
                this.X.b(com.oppo.camera.ui.inverse.c.INS.getCurrentHighBrightnessValue());
                h = true;
            }
        } else if (h) {
            fV();
        }
    }

    /* access modifiers changed from: protected */
    public float fo() {
        return com.oppo.camera.ui.inverse.c.INS.getBrightness();
    }

    private void c(TotalCaptureResult totalCaptureResult) {
        if (f("pref_camera_torch_mode_key")) {
            String string = this.aa.getString("pref_camera_torch_mode_key", Util.y(this.Z));
            float a2 = Util.a((CaptureResult) totalCaptureResult);
            int configIntValue = CameraConfig.getConfigIntValue(ConfigDataBase.KEY_SCREEN_BRIGHTNESS_THRESHOLD);
            int configIntValue2 = CameraConfig.getConfigIntValue(ConfigDataBase.KEY_SCREEN_BRIGHTNESS_RECOVER_THRESHOLD);
            if (!h && configIntValue != 0 && ((float) configIntValue) <= a2 && ("on".equals(string) || MenuClickMsgData.VALUE_PROFESSION_AUTO.equals(string))) {
                this.X.b(0.8f);
                h = true;
            } else if (!h) {
            } else {
                if ((configIntValue != 0 && ((float) configIntValue2) > a2) || "off".equals(string)) {
                    fV();
                }
            }
        } else if (h) {
            fV();
        }
    }

    private int fU() {
        return (!f("pref_camera_torch_mode_key") || !"on".equals(bv()) || !this.t) ? R.drawable.flash_hint_icon : R.drawable.torch_hint_icon;
    }

    private void fV() {
        this.X.b(-1.0f);
        h = false;
    }

    public void A(boolean z2) {
        this.S = z2;
    }

    public String ft() {
        return z.d((z.a) null);
    }

    private void d(TotalCaptureResult totalCaptureResult) {
        if (f("key_dark_environment_tips") && totalCaptureResult != null) {
            float a2 = Util.a((CaptureResult) totalCaptureResult);
            int eW = eW();
            if (eW != 0 && ((float) eW) < a2 && !this.ax) {
                this.ax = true;
                this.Y.a((int) R.string.camera_bokeh_need_more_light, -1, true, false, false);
            } else if (eW != 0 && ((float) eW) > a2 && this.ax) {
                this.ax = false;
                this.Y.b((int) R.string.camera_bokeh_need_more_light);
            }
        } else if (this.ax) {
            this.ax = false;
            this.Y.b((int) R.string.camera_bokeh_need_more_light);
        }
    }

    public long fy() {
        return this.aD;
    }

    private boolean fW() {
        return cm() || (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_MAINCAMERA_ASD_AISCENE_SUPPORT) && com.oppo.camera.f.a.h() == a(this.n)) || (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_WIDECAMERA_ASD_AISCENE_SUPPORT) && com.oppo.camera.f.a.j() == a(this.n));
    }

    public void E(boolean z2) {
        n nVar = this.ab;
        if (nVar != null) {
            nVar.g(z2);
        }
    }
}
