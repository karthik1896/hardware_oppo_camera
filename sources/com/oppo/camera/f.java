package com.oppo.camera;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.app.Activity;
import android.app.Application;
import android.app.KeyguardManager;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.hardware.cabc.CabcManager;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CaptureFailure;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.hardware.camera2.params.Face;
import android.hardware.camera2.params.InputConfiguration;
import android.hardware.camera2.params.MeteringRectangle;
import android.hardware.fingerprint.FingerprintManager;
import android.hardware.foss.FossManager;
import android.location.Address;
import android.location.Location;
import android.media.Image;
import android.media.ImageReader;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.ConditionVariable;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.PowerManager;
import android.os.SystemClock;
import android.provider.Settings;
import android.renderscript.Allocation;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicYuvToRGB;
import android.renderscript.Type;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Range;
import android.util.Size;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.widget.Toast;
import com.heytap.providers.a;
import com.oppo.camera.ac;
import com.oppo.camera.aps.ApsCameraRequestTag;
import com.oppo.camera.aps.adapter.ApsAdapterDecision;
import com.oppo.camera.aps.adapter.ApsInitParameter;
import com.oppo.camera.aps.adapter.ApsParameters;
import com.oppo.camera.aps.adapter.ApsResult;
import com.oppo.camera.aps.adapter.ApsTotalResult;
import com.oppo.camera.aps.adapter.ApsUtils;
import com.oppo.camera.aps.adapter.ApsWatermarkParam;
import com.oppo.camera.aps.adapter.ImageCategory;
import com.oppo.camera.aps.config.AlgoSwitchConfig;
import com.oppo.camera.aps.config.CameraConfig;
import com.oppo.camera.aps.config.CameraFunction;
import com.oppo.camera.aps.config.ConfigDataBase;
import com.oppo.camera.aps.constant.ApsConstant;
import com.oppo.camera.aps.constant.ParameterKeys;
import com.oppo.camera.aps.service.ApsAdapterListener;
import com.oppo.camera.aps.service.ApsService;
import com.oppo.camera.aps.service.OnCaptureHeciDataListener;
import com.oppo.camera.aps.service.ThumbnailCategory;
import com.oppo.camera.aps.service.ThumbnailItem;
import com.oppo.camera.aps.service.ThumbnailProcessor;
import com.oppo.camera.doubleexposure.g;
import com.oppo.camera.f.a;
import com.oppo.camera.f.c;
import com.oppo.camera.f.d;
import com.oppo.camera.f.f;
import com.oppo.camera.f.h;
import com.oppo.camera.f.j;
import com.oppo.camera.f.k;
import com.oppo.camera.gl.t;
import com.oppo.camera.i;
import com.oppo.camera.m;
import com.oppo.camera.n.d;
import com.oppo.camera.o;
import com.oppo.camera.statistics.CameraStatisticsUtil;
import com.oppo.camera.statistics.QualityReport;
import com.oppo.camera.statistics.model.CaptureMsgData;
import com.oppo.camera.statistics.model.DcsMsgData;
import com.oppo.camera.statistics.model.FocusAimMsgData;
import com.oppo.camera.statistics.model.MenuClickMsgData;
import com.oppo.camera.statistics.model.PerformanceMsgData;
import com.oppo.camera.statistics.model.PreviewStaticInfoMsgData;
import com.oppo.camera.statistics.model.ReminderMsgData;
import com.oppo.camera.statistics.model.SwitchCameraMsgData;
import com.oppo.camera.statistics.model.VideoRecordMsgData;
import com.oppo.camera.sticker.data.StickerItem;
import com.oppo.camera.tiltshift.TiltShiftManager;
import com.oppo.camera.tiltshift.TiltShiftParam;
import com.oppo.camera.u;
import com.oppo.camera.ui.RotateImageView;
import com.oppo.camera.ui.control.b;
import com.oppo.camera.ui.control.e;
import com.oppo.camera.ui.control.h;
import com.oppo.camera.ui.preview.a.n;
import com.oppo.camera.ui.preview.a.u;
import com.oppo.camera.ui.preview.d;
import com.oppo.camera.ui.preview.e;
import com.oppo.camera.util.Util;
import com.oppo.camera.util.YuvUtil;
import com.oppo.camera.util.storage.SandBoxContentProvider;
import com.oppo.camera.x;
import com.oppo.camera.z;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* compiled from: CameraManager */
public class f implements d, u.b {
    /* access modifiers changed from: private */
    public static final long e = ((long) ViewConfiguration.getDoubleTapTimeout());
    /* access modifiers changed from: private */
    public final ImageReader.OnImageAvailableListener A = new n("multi_main_preview_image");
    /* access modifiers changed from: private */
    public final ImageReader.OnImageAvailableListener B = new n("multi_sub_preview_image");
    /* access modifiers changed from: private */
    public final ImageReader.OnImageAvailableListener C = new n("yuv_capture_mfnr");
    /* access modifiers changed from: private */
    public int D = 255;
    /* access modifiers changed from: private */
    public int E = 0;
    /* access modifiers changed from: private */
    public int F = 0;
    /* access modifiers changed from: private */
    public int G = 0;
    /* access modifiers changed from: private */
    public int H = 0;
    /* access modifiers changed from: private */
    public int I = 0;
    /* access modifiers changed from: private */
    public int J = 0;
    /* access modifiers changed from: private */
    public int K = -1;
    /* access modifiers changed from: private */
    public int L = -1;
    /* access modifiers changed from: private */
    public int M = 0;
    private int N = 650;
    private int O = 650;
    /* access modifiers changed from: private */
    public int P = 300;
    /* access modifiers changed from: private */
    public int Q = 70;
    /* access modifiers changed from: private */
    public int R = 300;
    /* access modifiers changed from: private */
    public int[] S;
    /* access modifiers changed from: private */
    public int T;
    /* access modifiers changed from: private */
    public int U = 0;
    /* access modifiers changed from: private */
    public int V = 0;
    private int W = -1;
    /* access modifiers changed from: private */
    public int X = 0;
    private int Y = -1;
    /* access modifiers changed from: private */
    public int Z = 0;
    /* access modifiers changed from: private */
    public boolean aA = false;
    /* access modifiers changed from: private */
    public boolean aB = false;
    /* access modifiers changed from: private */
    public boolean aC = false;
    /* access modifiers changed from: private */
    public boolean aD = false;
    private boolean aE = false;
    /* access modifiers changed from: private */
    public boolean aF = false;
    /* access modifiers changed from: private */
    public boolean aG = false;
    private boolean aH = false;
    private boolean aI = true;
    /* access modifiers changed from: private */
    public boolean aJ = false;
    private boolean aK = true;
    private boolean aL = false;
    private boolean aM = false;
    /* access modifiers changed from: private */
    public boolean aN = false;
    private boolean aO = false;
    /* access modifiers changed from: private */
    public float aP = 0.0f;
    /* access modifiers changed from: private */
    public float aQ = 0.0f;
    private long aR = 0;
    private long aS = 0;
    /* access modifiers changed from: private */
    public int aT = 0;
    /* access modifiers changed from: private */
    public int aU = 0;
    /* access modifiers changed from: private */
    public long aV = -1;
    /* access modifiers changed from: private */
    public String aW = "";
    /* access modifiers changed from: private */
    public volatile boolean aX;
    /* access modifiers changed from: private */
    public boolean aY;
    /* access modifiers changed from: private */
    public boolean aZ;
    /* access modifiers changed from: private */
    public int aa = 0;
    /* access modifiers changed from: private */
    public int ab = 0;
    /* access modifiers changed from: private */
    public int ac = 0;
    private long ad = 0;
    private long ae = 0;
    /* access modifiers changed from: private */
    public long af;
    /* access modifiers changed from: private */
    public long ag;
    /* access modifiers changed from: private */
    public long ah;
    /* access modifiers changed from: private */
    public long ai;
    private long aj = 0;
    private long ak = 0;
    private long al = 0;
    /* access modifiers changed from: private */
    public long am = -1;
    private long an = 0;
    /* access modifiers changed from: private */
    public boolean ao = false;
    /* access modifiers changed from: private */
    public boolean ap = false;
    /* access modifiers changed from: private */
    public boolean aq = false;
    /* access modifiers changed from: private */
    public boolean ar = false;
    /* access modifiers changed from: private */
    public volatile boolean as = false;
    /* access modifiers changed from: private */
    public volatile boolean at = false;
    /* access modifiers changed from: private */
    public boolean au = false;
    private int av = 0;
    /* access modifiers changed from: private */
    public long aw = 0;
    /* access modifiers changed from: private */
    public boolean ax = false;
    /* access modifiers changed from: private */
    public boolean ay = false;
    /* access modifiers changed from: private */
    public boolean az = false;
    /* access modifiers changed from: private */
    public boolean bA = true;
    private String bB = null;
    private String bC = "off";
    /* access modifiers changed from: private */
    public String bD = "on";
    private String bE = "off";
    private String bF = VideoRecordMsgData.END_TYPE_NORMAL;
    /* access modifiers changed from: private */
    public CaptureMsgData bG = null;
    /* access modifiers changed from: private */
    public Object bH = new Object();
    /* access modifiers changed from: private */
    public Object bI = new Object();
    private Object bJ = new Object();
    /* access modifiers changed from: private */
    public Object bK = new Object();
    private Object bL = new Object();
    private ConditionVariable bM = new ConditionVariable();
    /* access modifiers changed from: private */
    public ConditionVariable bN = new ConditionVariable();
    /* access modifiers changed from: private */
    public volatile Activity bO;
    /* access modifiers changed from: private */
    public volatile k bP = null;
    private SharedPreferences bQ = null;
    /* access modifiers changed from: private */
    public com.oppo.camera.f.f bR = null;
    /* access modifiers changed from: private */
    public j bS = null;
    private f.d bT = null;
    /* access modifiers changed from: private */
    public f.e bU = null;
    /* access modifiers changed from: private */
    public volatile g bV;
    /* access modifiers changed from: private */
    public Face[] bW = null;
    /* access modifiers changed from: private */
    public int[] bX = null;
    /* access modifiers changed from: private */
    public int[] bY = null;
    private int bZ = 0;
    private boolean ba = false;
    private boolean bb = false;
    private boolean bc = false;
    private boolean bd = false;
    /* access modifiers changed from: private */
    public boolean be = false;
    /* access modifiers changed from: private */
    public boolean bf = false;
    /* access modifiers changed from: private */
    public boolean bg = false;
    /* access modifiers changed from: private */
    public boolean bh = false;
    /* access modifiers changed from: private */
    public boolean bi = false;
    private boolean bj = false;
    /* access modifiers changed from: private */
    public boolean bk = false;
    /* access modifiers changed from: private */
    public boolean bl = false;
    private boolean bm = false;
    /* access modifiers changed from: private */
    public boolean bn;
    /* access modifiers changed from: private */
    public boolean bo;
    private boolean bp = false;
    /* access modifiers changed from: private */
    public boolean bq = false;
    /* access modifiers changed from: private */
    public boolean br = false;
    private boolean bs = false;
    /* access modifiers changed from: private */
    public boolean bt = false;
    /* access modifiers changed from: private */
    public boolean bu = false;
    private boolean bv = true;
    private boolean bw = true;
    /* access modifiers changed from: private */
    public boolean bx = false;
    private boolean by = false;
    private boolean bz = false;
    private CabcManager cA;
    /* access modifiers changed from: private */
    public volatile aa cB = null;
    private Handler cC = null;
    private HandlerThread cD = null;
    private Uri cE = null;
    private StickerItem cF = null;
    private boolean cG = false;
    /* access modifiers changed from: private */
    public com.oppo.camera.entry.b cH = null;
    /* access modifiers changed from: private */
    public com.oppo.camera.ui.control.e cI = null;
    /* access modifiers changed from: private */
    public CopyOnWriteArrayList<com.oppo.camera.ui.control.e> cJ = null;
    /* access modifiers changed from: private */
    public byte[] cK = null;
    private r cL;
    /* access modifiers changed from: private */
    public volatile m cM = null;
    /* access modifiers changed from: private */
    public v cN = null;
    /* access modifiers changed from: private */
    public Size cO = null;
    private f.b cP = null;
    /* access modifiers changed from: private */
    public int cQ = 0;
    /* access modifiers changed from: private */
    public boolean cR = false;
    /* access modifiers changed from: private */
    public o cS = null;
    /* access modifiers changed from: private */
    public p cT = null;
    /* access modifiers changed from: private */
    public com.oppo.camera.soloop.b cU = null;
    /* access modifiers changed from: private */
    public byte cV = 0;
    /* access modifiers changed from: private */
    public boolean cW = false;
    /* access modifiers changed from: private */
    public boolean cX = false;
    /* access modifiers changed from: private */
    public boolean cY = true;
    /* access modifiers changed from: private */
    public boolean cZ = false;
    /* access modifiers changed from: private */
    public Rect ca = null;
    /* access modifiers changed from: private */
    public volatile s cb = null;
    /* access modifiers changed from: private */
    public volatile com.oppo.camera.ui.g cc = null;
    /* access modifiers changed from: private */
    public com.oppo.camera.ui.preview.a.n cd = null;
    /* access modifiers changed from: private */
    public volatile com.oppo.camera.ui.preview.k ce = null;
    /* access modifiers changed from: private */
    public volatile ac cf = null;
    /* access modifiers changed from: private */
    public volatile TiltShiftManager cg = null;
    /* access modifiers changed from: private */
    public b ch = null;
    /* access modifiers changed from: private */
    public float ci = 1.0f;
    /* access modifiers changed from: private */
    public volatile com.oppo.camera.e.o cj = null;
    /* access modifiers changed from: private */
    public volatile com.oppo.camera.t.d ck = null;
    private AsyncTask cl = null;
    /* access modifiers changed from: private */
    public volatile x cm = null;
    private FossManager cn;
    /* access modifiers changed from: private */

    /* renamed from: co  reason: collision with root package name */
    public volatile com.oppo.camera.ui.control.h f2941co = null;
    /* access modifiers changed from: private */
    public volatile ThumbnailProcessor cp = null;
    /* access modifiers changed from: private */
    public VelocityTracker cq;
    private GestureDetector cr = null;
    /* access modifiers changed from: private */
    public volatile y cs = null;
    /* access modifiers changed from: private */
    public QualityReport ct = null;
    /* access modifiers changed from: private */
    public volatile o cu;
    /* access modifiers changed from: private */
    public volatile com.oppo.camera.u.c cv;
    private FingerprintManager cw = null;
    private Thread cx = null;
    /* access modifiers changed from: private */
    public volatile o.a cy = null;
    /* access modifiers changed from: private */
    public o.a cz = null;
    protected int d = 100;
    /* access modifiers changed from: private */
    public Rect dA = new Rect();
    private boolean dB = false;
    /* access modifiers changed from: private */
    public boolean dC = false;
    /* access modifiers changed from: private */
    public final com.oppo.camera.a.b dD = new com.oppo.camera.a.b() {

        /* renamed from: b  reason: collision with root package name */
        private boolean f2943b = false;
        private RenderScript c = null;
        private ScriptIntrinsicYuvToRGB d = null;
        private Type.Builder e = null;
        private Type.Builder f = null;
        private Allocation g = null;
        private Allocation h = null;

        public void a() {
            this.f2943b = false;
            byte[] unused = f.this.cK = null;
            long unused2 = f.this.dk = System.currentTimeMillis();
        }

        /* access modifiers changed from: package-private */
        public void a(final Bitmap bitmap) {
            if (bitmap != null) {
                f.this.dN.a(new Runnable() {
                    public void run() {
                        if (!f.this.as && f.this.dl <= f.this.dk) {
                            f.this.a((Animation.AnimationListener) null);
                            if (f.this.cc != null) {
                                f.this.cc.a(bitmap);
                                f.this.N();
                                if (f.this.b("pref_camera_gradienter_key") && "on".equals(f.this.bP.getString("pref_camera_gradienter_key", "off"))) {
                                    f.this.cc.aI();
                                }
                            }
                            f.this.cj.b(12, false);
                            int unused = f.this.U = 0;
                            f.this.cj.b(5, false);
                        }
                    }
                });
            }
        }

        public void a(z.a aVar) {
            if (f.this.cH.y() == 1) {
                e.b("CameraManager", "onCameraPictureBuilt, uri: " + aVar.c);
                if (f.this.bR != null) {
                    f.this.bR.u();
                }
                if (f.this.cj != null) {
                    aVar.U = f.this.cj.cz();
                }
                aVar.V = f.this.dS;
                com.oppo.camera.n.b.a().c(aVar);
                return;
            }
            b(aVar);
        }

        private void b(final z.a aVar) {
            if (!f.this.as && f.this.bR != null) {
                if (f.this.dl > f.this.dk) {
                    e.e("CameraManager", "processInThirdApp, mThirdPartyPauseTime: " + f.this.dl + ", mThirdPartyCaptureTime: " + f.this.dk);
                    return;
                }
                byte[] unused = f.this.cK = aVar.e;
                e.a("CameraManager", "processInThirdApp, size: " + (f.this.cK.length / 1024) + "KB, width x height: " + aVar.q + " x " + aVar.r);
                if (this.f2943b) {
                    f.this.bR.a("off");
                    f.this.bR.a((f.c) null);
                    f.this.bR.g();
                    f.this.dN.post(new Runnable() {
                        public void run() {
                            f.this.j(0);
                        }
                    });
                    return;
                }
                final int i = -f.this.J;
                new Thread(new Runnable() {
                    public void run() {
                        BitmapFactory.Options options = new BitmapFactory.Options();
                        if (aVar.q * aVar.r >= Integer.valueOf("8000000").intValue()) {
                            options.inSampleSize = Math.round(Math.min((float) aVar.q, (float) aVar.r) / ((float) Util.E()));
                        }
                        if (options.inSampleSize < 1) {
                            options.inSampleSize = 1;
                        }
                        Bitmap decodeByteArray = BitmapFactory.decodeByteArray(aVar.e, 0, aVar.e.length, options);
                        int i = i;
                        if (i != 0) {
                            decodeByteArray = Util.a(decodeByteArray, i, false);
                        }
                        AnonymousClass1.this.a(decodeByteArray);
                        f.this.bR.a("off");
                        f.this.bR.a((f.c) null);
                        f.this.bR.g();
                        f.this.dN.post(new Runnable() {
                            public void run() {
                                f.this.j(0);
                            }
                        });
                    }
                }).start();
            }
        }
    };
    private final com.oppo.camera.a.e dE = new com.oppo.camera.a.e() {
        public void a(Bitmap bitmap, e.a aVar, com.oppo.camera.ui.control.e eVar, boolean z, int i, boolean z2) {
            final boolean z3 = z;
            final Bitmap bitmap2 = bitmap;
            final boolean z4 = z2;
            final e.a aVar2 = aVar;
            final com.oppo.camera.ui.control.e eVar2 = eVar;
            final int i2 = i;
            f.this.bO.runOnUiThread(new Runnable() {
                public void run() {
                    if (!z3) {
                        f.this.dW.T();
                    } else if (f.this.cc != null && bitmap2 != null && f.this.cj != null && z4) {
                        f.this.cc.a(bitmap2, aVar2, eVar2, i2);
                    }
                }
            });
        }
    };
    private final com.oppo.camera.a.d dF = new com.oppo.camera.a.d() {
        public void a(boolean z) {
            if (f.this.cj != null) {
                f.this.cj.a((byte[]) null, 0, 0, f.this.cj.bS(), false);
                f.this.cj.n(z);
            }
            if (!z && f.this.ck != null) {
                f.this.ck.a(false);
            }
        }
    };
    private m.c dG = new m.c() {
        public void a(Rect rect) {
            e.b("CameraManager", "onOpenHand");
            f.this.dN.a(new Runnable() {
                public void run() {
                    boolean cC = f.this.cj.cC();
                    if (f.this.as || !cC || f.this.at() || !f.this.cc.be() || "gesture".equals(f.this.dm) || f.this.cc.cF() || f.this.U()) {
                        e.a("CameraManager", "onOpenHand, isSupportGestureCapture: " + cC + ", isTimerSnapShotRunning: " + f.this.at() + ", isCameraShutterButtonEnabled: " + f.this.cc.be() + ", mShutterType: " + f.this.dm + ", isHeadlineScrolling: " + f.this.cc.cF() + ", isSnapShotProgress: " + f.this.U());
                        return;
                    }
                    String unused = f.this.dm = "gesture";
                    f.this.cM.a(true);
                    String u = f.this.cl();
                    if (!"off".equals(u)) {
                        f.this.m(u);
                    }
                    f.this.cM.a(false);
                    f.this.bV.p();
                }
            });
            e.b("CameraManager", "onOpenHand X");
        }
    };
    /* access modifiers changed from: private */
    public h dH = null;
    private int dI = 0;
    /* access modifiers changed from: private */
    public d dJ = new d();
    /* access modifiers changed from: private */
    public k dK = new k();
    private v dL = new v();
    /* access modifiers changed from: private */
    public u dM = null;
    /* access modifiers changed from: private */
    public com.oppo.camera.v.b dN = new com.oppo.camera.v.b(Looper.getMainLooper()) {
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    if (!f.this.as) {
                        e.d("CameraManager", "handleMessage, MSG_CODE_SWITCH_CAMERA_OVER_TIME");
                        f.this.e(false);
                        if (!f.this.cc.H()) {
                            f.this.cc.d(true, true);
                        }
                        if (!f.this.cc.J() && f.this.cj.bx() && !CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_HIGH_DEFINITION)) {
                            f.this.cc.a(f.this.bO.getString(R.string.camera_picture_size_standard_high_hint, new Object[]{Double.valueOf(f.this.cj.bz())}), 0, (int) R.color.screen_hint_text_color);
                        }
                        f.this.j(1);
                        return;
                    }
                    return;
                case 2:
                    f.this.a(96, false);
                    return;
                case 3:
                    f.this.a(95, false);
                    return;
                case 5:
                    e.a("CameraManager", "handleMessage, onPreviewStartedAsync OK");
                    f.this.j(1);
                    boolean unused = f.this.aX = false;
                    f.this.c(true, message.arg1);
                    boolean unused2 = f.this.aY = true;
                    if (f.this.bg) {
                        f.this.bV.o();
                        f.this.dN.postDelayed(new Runnable() {
                            public void run() {
                                if (!f.this.as) {
                                    f.this.v(1);
                                }
                            }
                        }, 200);
                        return;
                    }
                    return;
                case 6:
                    f.this.dN.removeMessages(6);
                    f fVar = f.this;
                    fVar.i(fVar.Q());
                    return;
                case 10:
                    f.this.l(2);
                    return;
                case 11:
                    if (f.this.cS != null) {
                        f.this.cS.g();
                        return;
                    }
                    return;
                case 12:
                    f.this.cc.n(true);
                    return;
                case 13:
                    if (f.this.cc != null) {
                        boolean booleanValue = ((Boolean) message.obj).booleanValue();
                        if (!booleanValue) {
                            f.this.cc.h();
                        }
                        if (!booleanValue || f.this.ce.y() || f.this.aA || (f.this.cN != null && f.this.cN.h())) {
                            f.this.cc.h();
                            return;
                        } else {
                            f.this.cc.a(booleanValue ? f.this.bW : null, f.this.bX);
                            return;
                        }
                    } else {
                        return;
                    }
                case 14:
                    Bundle data = message.getData();
                    if (data != null) {
                        boolean booleanValue2 = ((Boolean) data.get("view_enable")).booleanValue();
                        boolean booleanValue3 = ((Boolean) data.get("view_ashed")).booleanValue();
                        if (f.this.cc != null) {
                            f.this.cc.d(booleanValue2, booleanValue3);
                            return;
                        }
                        return;
                    }
                    return;
                case 15:
                    if (f.this.cb != null && !f.this.as) {
                        f.this.cb.c();
                        return;
                    }
                    return;
                case 16:
                    if (f.this.cH.w()) {
                        if (f.this.bO != null) {
                            f.this.bO.finishAndRemoveTask();
                        }
                        MyApplication.c();
                        return;
                    }
                    return;
                case 17:
                    float f = 0.0f;
                    if (message.obj != null) {
                        f = ((Float) message.obj).floatValue();
                    }
                    f fVar2 = f.this;
                    fVar2.a(f, fVar2.aP);
                    return;
                case 19:
                    if (!f.this.aG && f.this.b("pref_camera_pi_ai_mode_key") && f.this.cc != null) {
                        f.this.cc.C(message.arg1);
                        return;
                    }
                    return;
                case 20:
                    if (f.this.cJ != null && !f.this.cJ.isEmpty()) {
                        com.oppo.camera.ui.control.e eVar = (com.oppo.camera.ui.control.e) f.this.cJ.get(0);
                        if (1 < f.this.cJ.size()) {
                            f.this.cJ.remove(0);
                        }
                        f.this.cc.a(eVar, 2);
                    }
                    if (f.this.aG) {
                        sendEmptyMessageDelayed(20, (long) CameraConfig.getConfigIntValue(ConfigDataBase.KEY_BURSTSHOT_THUMB_ANIM_STEP_TIME));
                        return;
                    }
                    return;
                case 21:
                    f.this.c(((Float) message.obj).floatValue(), false);
                    return;
                case 22:
                    if (!f.this.a(3)) {
                        f.this.dN.removeMessages(22);
                        f.this.dN.sendEmptyMessageDelayed(22, 50);
                        return;
                    } else if (f.this.cH.n()) {
                        f.this.e(true, false);
                        return;
                    } else {
                        return;
                    }
                case 23:
                    if (f.this.cc == null) {
                        return;
                    }
                    if (!((Boolean) message.obj).booleanValue() || f.this.ce.y() || f.this.bY == null) {
                        f.this.cc.bu();
                        return;
                    } else {
                        f.this.cc.b(f.this.bY);
                        return;
                    }
                case 25:
                    if (!f.this.aN) {
                        boolean unused3 = f.this.aN = true;
                        f.this.cc.b(f.this.K, f.this.cj.bf(), !f.this.cj.bk());
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    };
    /* access modifiers changed from: private */
    public x.c dO = new x.c() {
        public void a() {
            if (f.this.ce != null) {
                f.this.ce.w();
            }
        }

        public void b() {
            if (f.this.ce != null) {
                f.this.ce.x();
            }
        }
    };
    private u.b dP = new u.b() {
        public void a(float f) {
            if (f.this.cc != null) {
                f.this.cc.c(f);
            }
            if (f.this.ce != null) {
                f.this.ce.a(f);
            }
        }

        public boolean a() {
            if (f.this.cj != null) {
                return f.this.cj.cN();
            }
            return false;
        }
    };
    private n.a dQ = new n.a() {
        public boolean a(String str) {
            if (f.this.cj != null) {
                return f.this.cj.i(str);
            }
            return false;
        }

        public Rect[] a() {
            if (f.this.cc != null) {
                return f.this.cc.cz();
            }
            return null;
        }

        public void b(final String str) {
            if (f.this.bO != null) {
                f.this.bO.runOnUiThread(new Runnable() {
                    public void run() {
                        if (f.this.cc != null) {
                            f.this.cc.n(str);
                        }
                    }
                });
            }
        }

        public void b() {
            if (f.this.bO != null) {
                f.this.bO.runOnUiThread(new Runnable() {
                    public void run() {
                        if (f.this.cc != null) {
                            f.this.cc.v();
                        }
                    }
                });
            }
        }

        public com.oppo.camera.t.a a(int i, int i2, int i3, int i4, int i5, boolean z, long j) {
            if (f.this.ck == null || f.this.D()) {
                f.this.cc.a((com.oppo.camera.t.a) null);
            } else {
                f.this.ck.a(i, i2, i3, i5, j);
            }
            return null;
        }

        public void a(com.oppo.camera.t.a aVar) {
            if (f.this.cc != null) {
                f.this.cc.a(aVar);
            }
        }

        public void a(int i, int i2, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, int i3) {
            int i4 = i;
            if (f.this.cc != null) {
                f.this.cc.a(i, i2, z, z2, z3, z4, z5, z6, i3);
            }
            if (f.this.cc == null) {
                return;
            }
            if (R.string.camera_double_exposure_nobody_hint == i4 || R.string.mode_double_exposure_move_closer == i4) {
                f.this.cc.t(i);
            }
        }

        public void a(int i) {
            if (f.this.cc != null) {
                f.this.cc.b(i);
            }
        }
    };
    /* access modifiers changed from: private */
    public f.c dR = new f.c() {

        /* renamed from: b  reason: collision with root package name */
        private long f2994b = 0;

        public void a(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, long j, long j2) {
        }

        public void a(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, CaptureResult captureResult) {
            e.c("CameraManager", "onCaptureProgressed, mCameraState: " + f.this.E + ", mFrameNumber: " + f.this.am + ", partialResult: " + captureResult.getFrameNumber());
            if (!Util.p() && captureResult.get(CaptureResult.SENSOR_TIMESTAMP) != null && (1 == f.this.E || 2 == f.this.E)) {
                if (captureResult.getFrameNumber() > f.this.am) {
                    long unused = f.this.am = captureResult.getFrameNumber();
                }
                if (f.this.cj != null && f.this.cj.i(-1)) {
                    f.this.a(captureRequest, captureResult);
                }
            }
            if (f.this.b(CameraFunction.AIS_SNAPSHOT)) {
                int[] a2 = f.this.bR.a((CaptureResult.Key<?>) c.c, captureResult);
                int[] a3 = f.this.bR.a((CaptureResult.Key<?>) c.d, captureResult);
                int[] a4 = f.this.bR.a((CaptureResult.Key<?>) c.e, captureResult);
                if (!(f.this.ch == null || a2 == null || a3 == null || a4 == null)) {
                    f.this.ch.a(a2[0], a3[0], a4[0]);
                }
                try {
                    int[] iArr = (int[]) captureResult.get(c.R);
                    Byte b2 = (Byte) captureResult.get(c.f);
                    Integer num = (Integer) captureResult.get(CaptureResult.CONTROL_AF_STATE);
                    Integer num2 = (Integer) captureResult.get(CaptureResult.CONTROL_AF_MODE);
                    boolean unused2 = f.this.bx = false;
                    if (f.this.ce != null && num != null && num2 != null && b2 != null) {
                        f.this.ce.a(num.intValue(), num2.intValue(), iArr, f.this.E, (int) b2.byteValue());
                    }
                } catch (Exception unused3) {
                    boolean unused4 = f.this.bx = true;
                }
            }
        }

        public void a(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, TotalCaptureResult totalCaptureResult, int i, long j) {
            if (f.this.at || f.this.bR == null || (f.this.as && f.this.cj != null && !f.this.cj.h())) {
                e.e("CameraManager" + i, "onPreviewCaptureResult, mOneCamera: " + f.this.bR);
                return;
            }
            a((CaptureResult) totalCaptureResult, j);
            if (f.this.aF()) {
                int[] a2 = f.this.bR.a((CaptureResult.Key<?>) c.K, (CaptureResult) totalCaptureResult);
                Long l = (Long) totalCaptureResult.get(CaptureResult.SENSOR_TIMESTAMP);
                if (2 == i && a2 != null) {
                    f.this.a(a2, l.longValue());
                }
            }
            boolean z = f.this.cj != null && f.this.cj.i(-1);
            if (z && (f.this.aC || f.this.aA)) {
                e.e("CameraManager", "onPreviewCaptureResult, mbCaptureModeChanging: " + f.this.aC + ", mbSwitchingCamera: " + f.this.aA);
                f.this.a(captureRequest, (CaptureResult) totalCaptureResult);
            } else if (totalCaptureResult.getFrameNumber() > f.this.am) {
                long unused = f.this.am = totalCaptureResult.getFrameNumber();
                com.oppo.camera.util.a.a(captureRequest, totalCaptureResult);
                if (f.this.cT == null || !f.this.cT.m()) {
                    if (z) {
                        f.this.a(captureRequest, (CaptureResult) totalCaptureResult);
                    } else {
                        f.this.d(new ApsTotalResult(totalCaptureResult));
                    }
                    if (f.this.cj != null) {
                        f.this.cj.a(totalCaptureResult);
                    }
                    if (2 == AlgoSwitchConfig.getApsVersion()) {
                        f.this.a((CaptureResult) totalCaptureResult);
                        return;
                    }
                    return;
                }
                f.this.cT.a(new ApsTotalResult(totalCaptureResult));
            }
        }

        public void a(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, CaptureFailure captureFailure) {
            if (captureFailure.wasImageCaptured()) {
                f.this.a(captureFailure.getFrameNumber());
            }
            if (f.this.bU != null && !f.this.aF()) {
                f.this.bU.c();
            }
        }

        public void a(TotalCaptureResult totalCaptureResult, int i) {
            e.e("CameraManager", "onFirstCaptureResultArrived");
            if (f.this.as) {
                e.e("CameraManager", "onPause，the first frame come, so return");
                return;
            }
            if (!f.this.dC && (2 == AlgoSwitchConfig.getApsVersion() || f.this.aF())) {
                boolean unused = f.this.dC = true;
            }
            int i2 = 0;
            if (f.this.cN != null) {
                f.this.cN.l();
                f.this.bL();
                f.this.cN.e(false);
            }
            if (((h) f.this.bR).A() != null) {
                ((h) f.this.bR).A().g();
            }
            if (f.this.cj != null) {
                f.this.cj.cG();
            }
            if (1 == i) {
                synchronized (f.this.i) {
                    int unused2 = f.this.dn = 0;
                }
                f.this.a((CaptureResult) totalCaptureResult);
            }
            if (!f.this.aN) {
                f.this.dN.sendEmptyMessage(25);
            }
            if (f.this.aY) {
                i2 = 100;
            }
            Message obtain = Message.obtain(f.this.dN, 5);
            obtain.arg1 = i;
            f.this.dN.sendMessageDelayed(obtain, (long) i2);
            f.this.ct.onFirstFrame(totalCaptureResult);
            if (f.this.cc != null) {
                f.this.cb();
                if (f.this.aF()) {
                    if (1 == i) {
                        f.this.cc.c().i(true);
                    } else {
                        f.this.cc.c().j(true);
                    }
                }
                if (2 == AlgoSwitchConfig.getApsVersion() && f.this.cc.c() != null) {
                    f.this.cc.c().l();
                }
                if (f.this.b("pref_camera_gradienter_key") && "on".equals(f.this.bP.getString("pref_camera_gradienter_key", "off"))) {
                    f.this.cc.a(true, f.this.I);
                }
                if (!f.this.aA) {
                    f.this.cc.cR();
                }
            }
        }

        private void a(CaptureResult captureResult, long j) {
            if (captureResult != null && j != -1) {
                if (f.this.cj == null || !f.this.cj.cN()) {
                    Object a2 = c.a(captureResult, c.S);
                    if ((a2 instanceof int[]) && 1 != ((int[]) a2)[0]) {
                        com.oppo.camera.g.a.a(System.currentTimeMillis() - this.f2994b, j);
                    }
                    this.f2994b = System.currentTimeMillis();
                }
            }
        }
    };
    /* access modifiers changed from: private */
    public com.oppo.camera.e.g dS = new com.oppo.camera.e.g() {
        public void a() {
            if (f.this.aj()) {
                boolean unused = f.this.cX = true;
            }
        }
    };
    /* access modifiers changed from: private */
    public com.oppo.camera.e.b dT = new com.oppo.camera.e.b() {
        public void y() {
        }

        public void a() {
            if (f.this.ce != null) {
                f.this.ce.h(8);
                f.this.ce.g(8);
            }
        }

        public com.oppo.camera.entry.b b() {
            return f.this.cH;
        }

        public boolean c() {
            if (!f.this.S() || f.this.aC) {
                return false;
            }
            f fVar = f.this;
            boolean unused = fVar.aB = fVar.b(CameraFunction.CACHE_CLICK_CAPTURE);
            e.a("CameraManager", "beforeCaptureProcess, enableCacheClickCapture: " + f.this.aB);
            if (f.this.bO != null) {
                f.this.bO.runOnUiThread(new Runnable() {
                    public void run() {
                        if (!f.this.as) {
                            f.this.cc.X(f.this.aB);
                        }
                    }
                });
            }
            f.this.j(2);
            f.this.bN.close();
            int unused2 = f.this.F = a.b(f.this.L, f.this.G);
            f fVar2 = f.this;
            int unused3 = fVar2.J = fVar2.G;
            int unused4 = f.this.Z = 0;
            if (f.this.cj == null || f.this.ce == null || !f.this.cj.i("pref_time_lapse_key") || "off".equals(f.this.cj.ag())) {
                return true;
            }
            f.this.ce.i();
            return true;
        }

        public boolean d() {
            int unused = f.this.Z = 0;
            return true;
        }

        public void a(int i, d dVar, f.a aVar, ApsAdapterListener.CaptureCallback captureCallback) {
            e.a("captureX burstCapture");
            if (f.this.bR != null) {
                A();
                boolean z = false;
                if (f.this.cj != null && f.this.cj.az()) {
                    boolean unused = f.this.cY = false;
                }
                if (f.this.aG) {
                    Handler l = f.this.bR.l();
                    f.this.bR.a("type_still_capture_yuv_main", f.this.v, l);
                    f.this.bR.a("type_still_capture_yuv_sub", f.this.v, l);
                    f.this.bR.a("type_still_capture_yuv_third", f.this.v, l);
                    f.this.bR.a("type_still_capture_jpeg", f.this.v, l);
                    f.this.bR.a("type_tuning_data_yuv", f.this.w, l);
                    long currentTimeMillis = System.currentTimeMillis();
                    String unused2 = f.this.aW = z.a(String.valueOf(currentTimeMillis), "");
                    long unused3 = f.this.aV = currentTimeMillis;
                } else {
                    Handler l2 = f.this.bR.l();
                    f.this.bR.a("type_still_capture_yuv_main", f.this.m, l2);
                    f.this.bR.a("type_still_capture_yuv_sub", f.this.o, l2);
                    f.this.bR.a("type_still_capture_yuv_third", f.this.q, l2);
                    f.this.bR.a("type_still_capture_jpeg", f.this.u, l2);
                    f.this.bR.a("type_tuning_data_yuv", f.this.x, l2);
                    f.this.bR.a("type_still_capture_yuv_mfnr", f.this.C, l2);
                    if (f.this.cc != null && f.this.cj.i("pref_sticker_process_key")) {
                        com.oppo.camera.ui.preview.a.n Y = f.this.cd;
                        Size c = f.this.cj.c(f.this.bS);
                        if (f.this.cc.bA() != 0) {
                            z = true;
                        }
                        Y.a(c, z);
                    }
                }
                if (f.this.aG && f.this.bR.e().E()) {
                    f.this.bR.a(true, dVar, aVar);
                } else if (f.this.cj.aM()) {
                    String string = f.this.bP.getString("pref_video_size_key", CameraConfig.getOptionKeyDefaultValue("pref_video_size_key", f.this.K));
                    if (2 == AlgoSwitchConfig.getApsVersion() || ("video_size_4kuhd".equals(string) && !f.this.cj.ac())) {
                        f.this.bR.a(aVar, dVar);
                    } else {
                        f.this.bU.a();
                        f.this.de.videoSnapshot(captureCallback, dVar);
                    }
                } else {
                    f.this.bR.a(i, dVar, aVar);
                    f.this.dD.a();
                    if (!j() && (!f.this.cj.ay() || "torch".equals(f.this.cj.Q()))) {
                        f.this.bR.g();
                    }
                }
            }
            e.b("captureX burstCapture");
        }

        public void e() {
            if (f.this.cH.y() == 2 && f.this.cj.ai()) {
                f.this.cc.a(new com.oppo.camera.ui.control.c(4, "button_color_inside_grey"));
            }
        }

        public void a(byte[] bArr) {
            e.a("CameraManager", "beforePictureTaken");
            if (!f.this.as) {
                if (!f.this.V() && j() && 5 != h() && f.this.aY) {
                    f.this.j(1);
                }
                if (f.this.cH.y() == 2 && f.this.cc != null && f.this.cj != null && f.this.cj.ai()) {
                    f.this.cc.a(f.this.cj.f(), f.this.cD());
                }
            }
        }

        public void b(byte[] bArr) {
            e.a("CameraManager", "afterPictureTaken");
            if (!f.this.as) {
                if (f.this.be) {
                    if (f.this.ea != null) {
                        f.this.ea.j();
                    }
                    f.this.f(false);
                }
                if (f.this.br) {
                    try {
                        if (!(f.this.cc == null || f.this.as || f.this.bR == null || f.this.bV == null)) {
                            boolean unused = f.this.br = false;
                            f.this.bR.a("off");
                            f.this.bR.a((f.c) null);
                            f.this.bt();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                f.this.bR.a();
                if (z.t == 0) {
                    f.this.bx();
                }
            }
        }

        public void f() {
            if (f.this.dN != null && f.this.dN.hasMessages(24)) {
                e.a("CameraManager", "checkCacheCapture");
                f.this.dN.removeMessages(24);
                f.this.ea.h();
            }
        }

        public void g() {
            e.a("CameraManager", "resetVideoTakePicture, mbPaused: " + f.this.as);
            if (!f.this.as) {
                f.this.k(0);
                f.this.cc.e(true, true);
                f.this.cc.c(!f.this.cj.aM(), false);
                f.this.j(1);
            }
        }

        public void a(int i) {
            f.this.o(i);
        }

        public void b(int i) {
            f.this.p(i);
        }

        public int h() {
            return f.this.E;
        }

        public void c(int i) {
            f.this.b(i);
        }

        public void i() {
            if (!f.this.cc.bT()) {
                f.this.cc.bt();
            }
        }

        public void a(boolean z) {
            f.this.n(z);
        }

        public void a(com.oppo.camera.ui.control.e eVar) {
            com.oppo.camera.ui.control.e unused = f.this.cI = eVar;
        }

        public boolean j() {
            return f.this.bd();
        }

        public int k() {
            return f.this.U;
        }

        public boolean l() {
            return f.this.cc.G(f.this.U);
        }

        public boolean m() {
            return f.this.be();
        }

        public void n() {
            if (f.this.cc != null) {
                f.this.cc.U(f.this.ao);
            }
        }

        public boolean o() {
            return f.this.cj != null && f.this.ch != null && f.this.ch.a() && Float.compare(f.this.ci, 1.0f) == 0 && !f.this.aG && f.this.T == 0 && f.this.cj.i(CameraFunction.AIS_SNAPSHOT) && !f.this.cj.ay() && !X() && !f.this.cj.bL() && !f.this.cj.bM();
        }

        public void b(boolean z) {
            if (f.this.cc != null) {
                if (f.this.cc.J()) {
                    f.this.cc.K();
                }
                f.this.cc.aq(false);
            }
            e.a("captureX onAISSnapshotCapture");
            e.a("CameraManager", "doAISCapture, needCheckAFStatus: " + z);
            f.this.e(z, true);
            e.b("captureX onAISSnapshotCapture");
            if (f.this.aj()) {
                f.this.t(false);
            }
        }

        public int p() {
            if (f.this.ch != null) {
                return f.this.ch.f();
            }
            return -1;
        }

        public boolean q() {
            if (f.this.cj != null) {
                return f.this.cj.bN();
            }
            return false;
        }

        public SharedPreferences r() {
            return f.this.bP;
        }

        public int s() {
            return f.this.G;
        }

        public void a(z.a aVar) {
            f.this.a(aVar);
        }

        public void b(z.a aVar) {
            f.this.c(aVar);
        }

        public Uri a(ThumbnailProcessor.DataRequest dataRequest) {
            if (f.this.cp == null) {
                return null;
            }
            dataRequest.mContentOperatedCallback = f.this.dS;
            f.this.cp.addQueue(dataRequest);
            return null;
        }

        public String t() {
            return f.this.aW;
        }

        public long u() {
            return f.this.aV;
        }

        public Location v() {
            if (f.this.cu == null || !f.this.da || !"on".equals(f.this.cu.f())) {
                return null;
            }
            if (!f.this.cu.g() || (!f.this.cj.i("pref_camera_slogan_key") && !f.this.cj.i("pref_camera_video_slogan_key"))) {
                return f.this.cu.a();
            }
            f fVar = f.this;
            o.a unused = fVar.cz = fVar.cy;
            if (f.this.cz == null) {
                return null;
            }
            return f.this.cz.i;
        }

        public boolean w() {
            return X();
        }

        public boolean x() {
            return f.this.at();
        }

        public boolean z() {
            return f.this.bf;
        }

        public void A() {
            f.this.s();
        }

        public boolean B() {
            return f.this.aA;
        }

        public boolean C() {
            return f.this.aC;
        }

        public void c(boolean z) {
            f.this.h(z);
        }

        public void a(Animation.AnimationListener animationListener) {
            f.this.a(animationListener);
        }

        public void D() {
            f.this.au();
        }

        public boolean E() {
            return f.this.av();
        }

        public void a(boolean z, boolean z2) {
            if (f.this.cf != null) {
                f.this.cf.a(z, true, z2);
            }
        }

        public void d(boolean z) {
            f.this.v(z);
        }

        public boolean F() {
            return f.this.aM();
        }

        public boolean G() {
            f.this.cc.d(false, false);
            f.this.cc.bk();
            f.this.cj.z();
            f.this.cc.bX();
            f.this.cc.W(true);
            f.this.cc.b((int) R.string.camera_10bit_hint);
            if (f.this.cc.ba()) {
                f.this.cc.bC();
            }
            if (f.this.cH.y() != 3) {
                f.this.bk();
            }
            return true;
        }

        public void H() {
            if (!f.this.cj.i(CameraFunction.SAT_CAMERA) || !f.this.cj.bT() || CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_FLASH_FULL_ZOOM) || f.this.cj.a(ad()) || f.this.cj.aP()) {
                if (f.this.cj.d("pref_camera_torch_mode_key")) {
                    f.this.cc.b("pref_camera_torch_mode_key", (String) null);
                } else if (f.this.cj.d("pref_camera_videoflashmode_key") && f.this.cr()) {
                    f.this.cc.b("pref_camera_videoflashmode_key", (String) null);
                }
            }
            f.this.cc.V(!f.this.b("key_short_video") && !f.this.b("key_intelligent_high_frame_usage_key") && !f.this.aF() && !f.this.cj.dj());
            if (f.this.cj.a()) {
                f.this.cc.ai(true);
            } else {
                f.this.cc.a(4);
            }
            if (f.this.cc.ak()) {
                f.this.cc.al();
            }
            if (f.this.cc.s()) {
                f.this.cc.ad(false);
                f.this.cc.b(false);
            } else {
                f.this.cc.o(false);
            }
            if (f.this.cc.C()) {
                f.this.cc.t(false);
            }
            if (f.this.cc.G()) {
                f.this.cc.d(false, true, true);
            } else {
                f.this.cc.d(false, false, true);
            }
            if (f.this.cj.i(CameraFunction.TILT_SHIFT)) {
                if (f.this.cc.cb()) {
                    f.this.cc.c(false, true, true);
                } else {
                    f.this.cc.c(false, false, true);
                }
                f.this.cc.y(false);
            }
            f.this.cc.a(false, true, false, true);
            f.this.cc.w(false);
            f.this.cc.u(false);
            f.this.cc.bV();
            f.this.cc.m(true, false);
            if (f.this.cj.i("pref_none_sat_ultra_wide_angle_key")) {
                if (f.this.co()) {
                    f.this.cf.b(8);
                } else {
                    float ae = ae();
                    float aR = f.this.aR();
                    if (f.this.cj.i("pref_none_sat_tele_angle_key") && !f.this.cj.aP() && !f.this.cj.aQ()) {
                        if (f.this.ck()) {
                            aR = 2.0f;
                        } else {
                            ae = 1.9f;
                        }
                    }
                    f.this.cf.a(aR, ae, f.this.cf.a(), f.this.bS.d(), f.this.cj.cd(), false);
                }
            }
            f fVar = f.this;
            int unused = fVar.H = fVar.G;
        }

        public void I() {
            f.this.bV.q();
            f.this.cj.A();
            f.this.cb.b();
            if (f.this.dN != null) {
                f.this.dN.removeMessages(15);
                f.this.dN.sendEmptyMessageDelayed(15, 250);
            }
            f.this.a((Face[]) null, (int[]) null);
        }

        public void J() {
            if (f.this.cb != null) {
                f.this.cb.d();
            }
        }

        public void K() {
            if (f.this.dN != null) {
                f.this.dN.removeMessages(15);
            }
            if (f.this.b("key_intelligent_high_frame_usage_key")) {
                f.this.cc.bn();
                f.this.cc.ah(true);
                f.this.cc.d(false, false);
                f.this.cc.b("pref_camera_videoflashmode_key", (String) null);
                return;
            }
            aI();
            f.this.cc.al(true);
            if (f.this.cj.cV()) {
                f.this.cc.a(f.this.bO.getString(R.string.camera_10bit_hint), 0, (int) R.color.screen_hint_text_color);
            }
        }

        private void aI() {
            f.this.cc.d(false, false);
            boolean aV = f.this.cj.aV();
            boolean df = f.this.cj.df();
            if (f.this.cH.y() == 1 && !f.this.cc.bp()) {
                if (f.this.cj.a()) {
                    if (!aV && !F() && !df) {
                        f.this.cc.ah(true);
                    }
                } else if (f.this.dW != null && !f.this.dW.M()) {
                    f.this.cc.a(0);
                }
            }
            if (f.this.cj.dj()) {
                f.this.cc.aj(false);
            }
            f.this.cc.j(aV, df);
        }

        public void L() {
            f.this.cc.i(true);
            if (f.this.b("key_intelligent_high_frame_usage_key")) {
                f.this.ce.o();
                f.this.cc.bo();
            }
            if (!f.this.cj.aV()) {
                if ((f.this.cc.C() || f.this.cc.s() || f.this.cc.G()) && f.this.cj.i("pref_zoom_key")) {
                    if (((!f.this.cj() && !f.this.ao) || f.this.cj.cF()) && ((!CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_ALLMIGHTY_VIDEO) || !f.this.cj.cE()) && (!CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_ULTRA_NIGHT_VIDEO_WIDE_ANGLE) || !f.this.cj.cD()))) {
                        f.this.cf.a(f.this.aR(), ae(), f.this.cf.a(), f.this.bS.d(), f.this.cj.cd(), true);
                    }
                    a((Animation.AnimationListener) null);
                } else {
                    E();
                    d(true);
                    if (f.this.cj.i(CameraFunction.KEY_VIDEO_SUPER_EIS_WIDE)) {
                        f.this.cc.v(true);
                    }
                    if (f.this.cj.i(CameraFunction.TILT_SHIFT)) {
                        f.this.cc.x(true);
                    }
                    if (f.this.cj.i("key_slow_video_frame_seek_bar_menu_key")) {
                        f.this.cc.F(true);
                    }
                    if (f.this.cj.i("pref_video_super_eis_key") && !f.this.ao) {
                        f.this.cc.E();
                    }
                    if (f.this.cj.cl() && f.this.cf != null) {
                        f.this.cf.a(false, true, false);
                    }
                    if (f.this.cf != null) {
                        f.this.cc.p(true);
                    }
                    if (f.this.cj.i("pref_none_sat_ultra_wide_angle_key")) {
                        if (((f.this.cj() || f.this.ao) && !f.this.cj.cF()) || ((CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_ALLMIGHTY_VIDEO) && f.this.cj.cE()) || (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_ULTRA_NIGHT_VIDEO_WIDE_ANGLE) && f.this.cj.cD()))) {
                            f.this.cf.b(0);
                        } else {
                            f.this.cf.a(f.this.aR(), ae(), f.this.cf.a(), f.this.bS.d(), f.this.cj.cd(), true);
                        }
                    }
                }
            }
            f.this.cj.B();
        }

        public void a(e.c cVar, boolean z, boolean z2) {
            e.a("CameraManager", "stopVideoRecordingProcess, failed: " + z);
            if (!f.this.as) {
                if (f.this.cH.y() == 3) {
                    if (!z) {
                        a((Animation.AnimationListener) null);
                        f.this.cc.b(f.this.cj.g(Util.E()));
                    } else {
                        D();
                        f.this.cc.c(f.this.cj.f(), f.this.cD());
                    }
                    f.this.bx();
                } else {
                    f.this.bj();
                    if (!f.this.cj.dj()) {
                        f.this.cc.d(true, true);
                    }
                    if (!z && z2) {
                        com.oppo.camera.ui.control.g.a();
                        f.this.cc.a(cVar, true);
                        e.e("CameraManager", "CameraTest Video Thumbnail Saved");
                    }
                    f.this.k(0);
                    if (f.this.B() && !f.this.ce.y()) {
                        f.this.cc.U(f.this.ao);
                    }
                    f.this.bx();
                }
                f.this.bV.p();
            } else if (f.this.cH.y() == 3 && !z) {
                a((Animation.AnimationListener) null);
                f.this.cc.b(f.this.cj.g(Util.E()));
            }
        }

        public void a(e.c cVar) {
            e.a("CameraManager", "updateThumbnail, mediaInfo: " + cVar);
            com.oppo.camera.ui.control.g.a();
            f.this.cc.a(cVar, true);
        }

        public void e(boolean z) {
            f.this.a(z);
        }

        public boolean M() {
            return com.oppo.camera.n.b.a().a(f.this.bO, f.this.cj.N());
        }

        public void N() {
            if (f.this.bV != null) {
                f.this.bV.m();
            }
        }

        public boolean O() {
            return f.this.d();
        }

        public boolean P() {
            return f.this.ax;
        }

        public void Q() {
            f.this.G();
        }

        public int R() {
            return f.this.D;
        }

        public void a(boolean z, List<String> list, String str, int i) {
            e.a("CameraManager", "updateEffectMenuData, currMenuName: " + str + ", currItemIndex: " + i);
            f.this.cc.a(list, str, i);
            if (z && f.this.cj.i("pref_filter_process_key")) {
                f.this.cj.a(f.this.cc.z());
            }
        }

        public void S() {
            f.this.dN.removeMessages(10);
            f.this.dN.sendEmptyMessage(10);
        }

        public void T() {
            f.this.bD();
        }

        public void b(boolean z, boolean z2) {
            f.this.b(z, z2);
        }

        public void f(boolean z) {
            if (P()) {
                e.a("CameraManager", "onBeauty3DChange, BlurAnimRunning, return");
                return;
            }
            boolean unused = f.this.cR = z;
            Size aX = f.this.cc.aX();
            Size size = null;
            if (f.this.cj != null) {
                size = f.this.cj.a(f.this.bS);
            }
            Size size2 = size;
            if (size2 != null && aX != null) {
                int S = f.this.cj.S();
                f fVar = f.this;
                if (fVar.a(aX, size2, S, S, false, 0, (d.a) fVar.dJ)) {
                    f.this.g(true);
                }
            }
        }

        public void g(boolean z) {
            if (f.this.ce != null) {
                f.this.ce.g(z);
            }
        }

        public void U() {
            if (f.this.ce != null) {
                f.this.ce.z();
            }
        }

        public void V() {
            if (f.this.ce != null) {
                f.this.ce.o();
            }
        }

        public void a(long j, int i, int i2) {
            if (f.this.cY) {
                e.b("CameraManager", "notifyCaptureFailed, don't notifyErrorType when finish add frame to aps.");
                return;
            }
            ImageCategory.ImageItemInfo imageItemInfo = new ImageCategory.ImageItemInfo();
            imageItemInfo.setParameter(ParameterKeys.KEY_TIME_STAMP, Long.valueOf(j));
            imageItemInfo.mApsServiceListener = f.this.df;
            if (f.this.de != null && i >= 1) {
                f.this.de.notifyErrorType(new ApsService.ApsFailure(1, -1, j, i, i2, imageItemInfo));
            }
        }

        public aa W() {
            if (f.this.cB != null) {
                return f.this.cB;
            }
            return null;
        }

        public boolean X() {
            return f.this.u();
        }

        public String Y() {
            return f.this.bv();
        }

        public String Z() {
            return f.this.dm;
        }

        public void a(String str) {
            String unused = f.this.dm = str;
        }

        public int aa() {
            return f.this.T;
        }

        public CaptureMsgData ab() {
            return f.this.bG;
        }

        public void a(ApsResult.ImageBuffer imageBuffer, int i) {
            f.this.a(imageBuffer, i);
        }

        public void a(long j, String str, boolean z) {
            f.this.a(j, str, z);
        }

        public int ac() {
            return f.this.t();
        }

        public float ad() {
            return f.this.aN();
        }

        public float ae() {
            return f.this.bS.d(f.this.cj.cd());
        }

        public boolean a(float f) {
            return f.this.d(f);
        }

        public void af() {
            f.this.ad();
        }

        public boolean ag() {
            return f.this.aG();
        }

        public boolean ah() {
            return f.this.aH();
        }

        public y ai() {
            if (f.this.cs == null) {
                f fVar = f.this;
                y unused = fVar.cs = new y(fVar.bO, f.this.bP, f.this.cH.y());
            }
            return f.this.cs;
        }

        public byte[] aj() {
            return f.this.az();
        }

        public Size ak() {
            return f.this.aA();
        }

        public int al() {
            return f.this.aB();
        }

        public int am() {
            return f.this.cH.a(f.this.cj.l(), f.this.K);
        }

        public boolean an() {
            return f.this.aT();
        }

        public void ao() {
            f.this.bD();
        }

        public void ap() {
            f.this.bF();
        }

        public void a(boolean z, int i, boolean z2) {
            int i2;
            if (f.this.cs == null) {
                f fVar = f.this;
                y unused = fVar.cs = new y(fVar.bO, f.this.bP, f.this.cH.y());
            }
            Size c = f.this.cj.c(f.this.bS);
            HashSet hashSet = new HashSet();
            if (f.this.de != null) {
                hashSet.addAll(f.this.de.getSloganPathsInUse());
            }
            if (c != null && f.this.cs != null) {
                if (f.this.ax() || f.this.ay()) {
                    e.a("CameraManager", "updateSlogan, mSloganBuffer starts to generate");
                    y cB = f.this.cs;
                    o.a cD = f.this.bf();
                    if (z2) {
                        i2 = 270;
                    } else {
                        i2 = f.this.G;
                    }
                    cB.a(c, cD, (HashSet<String>) hashSet, z, i2, i, f.this.K);
                    e.a("CameraManager", "updateSlogan, mSloganBuffer generated x");
                }
            }
        }

        public int aq() {
            return f.this.ak();
        }

        public int ar() {
            return f.this.aU();
        }

        public void b(final float f) {
            f.this.bO.runOnUiThread(new Runnable() {
                public void run() {
                    f.this.a(f);
                }
            });
        }

        public void as() {
            if (f.this.cj != null) {
                f fVar = f.this;
                fVar.a(fVar.cj.a(f.this.bS), true);
            }
        }

        public boolean at() {
            return f.this.aF;
        }

        public boolean a(float f, float f2) {
            if (f.this.cj == null || !f.this.b(CameraFunction.SAT_CAMERA)) {
                return false;
            }
            if (f.this.cj.a(f) && f.this.cj.a(f2)) {
                return false;
            }
            if (!a(f) || !a(f2)) {
                return !f.this.e(f) || !f.this.e(f2);
            }
            return false;
        }

        public boolean au() {
            if (f.this.cj == null) {
                return false;
            }
            f.this.cj.cY();
            return false;
        }

        public void av() {
            if (f.this.dW != null) {
                f.this.dW.G();
            }
        }

        public boolean aw() {
            return f.this.bA;
        }

        public void ax() {
            if (f.this.cj != null && f.this.cj.i("pref_filter_process_key") && f.this.cc != null && f.this.cc.s()) {
                f.this.cm();
            }
        }

        public void b(String str) {
            if (f.this.bR != null && f.this.m() && f.this.cN != null && f.this.cN.k() && !f.this.o()) {
                f.this.bR.d(str);
            }
        }

        public boolean ay() {
            return f.this.X();
        }

        public void d(int i) {
            if (f.this.aU <= Util.d && f.this.aU > i) {
                i = f.this.aU;
            }
            f.this.C(i);
        }

        public String az() {
            return f.this.cH.l();
        }

        public void aA() {
            f fVar = f.this;
            fVar.a(fVar.aQ(), true);
        }

        public void aB() {
            f.this.bV.q();
        }

        public void aC() {
            f.this.bV.p();
        }

        public boolean aD() {
            return f.this.M();
        }

        public float[] aE() {
            if (f.this.cf != null) {
                return f.this.cf.p();
            }
            return null;
        }

        public void h(boolean z) {
            f.this.G(z);
        }

        public void a(Size size) {
            if (f.this.cc != null) {
                f.this.cc.a(f.this.ca, f.this.bS.d(), size);
            }
        }

        public void aF() {
            f.this.dS.a();
        }

        public void b(Size size) {
            Size aX = f.this.cc.aX();
            e.a("CameraManager", "changePreviewSizeIfNeeded, newSize: " + size + ", currSize: " + aX + ", mCameraState: " + f.this.E + ", mbSizeChanging: " + f.this.aD + ", mbSendCapturePictureRequest: " + f.this.cZ + "\n");
            if (aX != null && !aX.toString().equals(size.toString()) && f.this.S() && !f.this.aD && !f.this.cZ) {
                f.this.bA();
            }
        }

        public TiltShiftParam aG() {
            if (f.this.cg != null) {
                return f.this.cg.getTiltShiftCaptureParam();
            }
            return null;
        }

        public boolean aH() {
            return f.this.at;
        }
    };
    private com.oppo.camera.u.a dU = new com.oppo.camera.u.a() {
        public void a() {
            if (!f.this.as && f.this.bR != null && !f.this.ao) {
                if (f.this.cj != null) {
                    String Q = f.this.cj.Q();
                    e.b("CameraManager", "stopFlash torchMode: " + Q);
                    if ("off".equals(Q)) {
                        return;
                    }
                }
                f.this.bR.a("off");
                f.this.bR.a((f.c) null);
                f.this.bR.p(true);
                if (f.this.cT != null) {
                    f.this.cT.p().dc();
                }
                f.this.bs();
            }
        }

        public void b() {
            if (f.this.cj != null) {
                f.this.cj.x();
            }
        }

        public void a(float f) {
            e.b("CameraManager", "adjustBrightness brightness: " + f);
            if (f.this.bO != null) {
                Window window = f.this.bO.getWindow();
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.screenBrightness = f / ((float) f.this.D);
                window.setAttributes(attributes);
            }
        }

        public void a(boolean z, int i) {
            if (f.this.bO != null && 1 == i) {
                e.b("CameraManager", "finishByHighTemperature isStartCamera: " + z + ", highTempProtectStatus: " + i);
                if (!z) {
                    Toast.makeText(f.this.bO, f.this.bO.getString(R.string.camera_high_temperature_exit_toast), 0).show();
                }
                f.this.a(ReminderMsgData.TYPE_DISABLE_CODE, ReminderMsgData.CODE_TEMPS_CAM);
                f.this.bO.finish();
            } else if (f.this.cv != null) {
                f.this.cv.b();
            }
        }

        public void a(int i, int i2) {
            if (f.this.cj != null) {
                f.this.cj.a(i, i2);
            }
        }
    };
    private com.oppo.camera.ui.preview.c dV = new com.oppo.camera.ui.preview.c() {
        public void a(int[] iArr, boolean z) {
            if (f.this.bR != null) {
                f.this.bR.b(iArr);
                if (z) {
                    f.this.bR.a(f.this.dR);
                }
            }
        }

        public boolean a() {
            if (f.this.cf != null) {
                return f.this.cf.h();
            }
            return false;
        }

        public void b() {
            if (f.this.cc != null) {
                f.this.cc.U(f.this.ao);
            }
        }

        public void c() {
            f.this.cc.bk();
        }

        public void d() {
            if (f.this.cc != null) {
                f.this.cc.bl();
            }
        }

        public void e() {
            if (f.this.cc != null) {
                f.this.cc.bm();
            }
        }

        public boolean f() {
            return f.this.cj.g();
        }

        public boolean a(String str) {
            if (f.this.cj != null) {
                return f.this.cj.i(str);
            }
            return false;
        }

        public void a(boolean z) {
            if (f.this.ce != null && f.this.ce.g()) {
                String unused = f.this.dm = "tap";
            }
            f.this.e(false, z);
        }

        public void a(boolean z, boolean z2) {
            if (f.this.cc != null) {
                f.this.cc.d(z, z2);
            }
        }

        public void b(boolean z) {
            f.this.y(z);
        }

        public boolean g() {
            if (f.this.cc != null) {
                return f.this.cc.be();
            }
            return false;
        }

        public void h() {
            f.this.p("2");
        }

        public boolean i() {
            if (f.this.bR == null || f.this.bR.e() == null || Float.compare(f.this.bR.e().n(), 0.0f) != 0) {
                return false;
            }
            return true;
        }

        public boolean j() {
            if (f.this.cj != null) {
                return f.this.cj.cH();
            }
            return false;
        }

        public boolean k() {
            return f.this.cj.aM();
        }

        public boolean l() {
            return f.this.cc.aP();
        }

        public void a(int i, Rect rect, Rect rect2) {
            f.this.a(i, rect, rect2);
        }

        public void a(Rect rect, Rect rect2) {
            MeteringRectangle[] meteringRectangleArr = rect2 != null ? new MeteringRectangle[]{new MeteringRectangle(rect2, a.c())} : null;
            f.this.bR.a(rect != null ? new MeteringRectangle[]{new MeteringRectangle(rect, a.d())} : null);
            f.this.bR.b(meteringRectangleArr);
            f.this.bR.a((f.c) null);
        }

        public void a(int i) {
            if (f.this.bR != null) {
                int unused = f.this.T = i;
                f.this.bR.f(f.this.T);
                f.this.bR.a((f.c) null);
            }
        }

        public boolean m() {
            if (f.this.cj != null) {
                return f.this.cj.i("pref_manual_exposure_key");
            }
            return false;
        }

        public boolean n() {
            if (f.this.bR == null || f.this.bR.e() == null) {
                return false;
            }
            return f.this.bR.e().t();
        }

        public boolean o() {
            if (f.this.bR == null || f.this.bR.e() == null) {
                return false;
            }
            return f.this.bR.e().s();
        }

        public void p() {
            f.this.e();
        }

        public void q() {
            if (f.this.bR != null) {
                f.this.bR.o();
            }
        }

        public boolean r() {
            return f.this.c();
        }

        public boolean s() {
            return f.this.at();
        }

        public void a(int i, int i2) {
            f.this.a(i, i2);
            if (f.this.cd != null) {
                f.this.cd.a(new Point(i, i2));
            }
        }

        public int t() {
            return f.this.f();
        }

        public int u() {
            if (f.this.bS != null) {
                return f.this.bS.q();
            }
            return a.b();
        }

        public int v() {
            if (f.this.bS != null) {
                return f.this.bS.p();
            }
            return a.b();
        }

        public Rect w() {
            f fVar = f.this;
            return fVar.c(fVar.aN());
        }

        public void b(boolean z, boolean z2) {
            f.this.b(z, z2);
        }
    };
    /* access modifiers changed from: private */
    public com.oppo.camera.ui.f dW = new com.oppo.camera.ui.f() {
        public boolean a() {
            return f.this.cj.am();
        }

        public boolean b() {
            return f.this.cj.aM();
        }

        public boolean c() {
            return f.this.cj.aO();
        }

        public boolean d() {
            return f.this.cj.aL();
        }

        public boolean e() {
            return (!f.this.ap && !f.this.dK.e()) || (f.this.ap && f.this.cj.g() && "off".equals(f.this.cl()));
        }

        public void f() {
            f.this.bV.m();
        }

        public int g() {
            return f.this.E;
        }

        public void h() {
            f.this.cj.I();
        }

        public boolean a(String str) {
            if ("pref_camera_flashmode_key".equals(str) && f.this.ao) {
                return false;
            }
            if ((!"pref_camera_videoflashmode_key".equals(str) || !f.this.ao || f.this.aF()) && !f.this.cc.q(f.this.cc.p(str))) {
                return !"pref_intelligent_high_frame_selected_key".equals(str) || f.this.cj.i("key_intelligent_high_frame_usage_key");
            }
            return false;
        }

        public boolean b(String str) {
            return f.this.cj.g(str);
        }

        public boolean i() {
            return f.this.bf;
        }

        public void j() {
            if (f.this.cj != null && f.this.cj.i("pref_zoom_key")) {
                f.this.a((Animation.AnimationListener) null);
                f.this.v(false);
            }
            if (f.this.cj != null) {
                f.this.cj.aT();
            }
            if (f.this.cN != null) {
                f.this.cN.c(false);
            }
            if (f.this.cc.ak()) {
                f.this.cc.al();
            }
        }

        public void a(boolean z) {
            boolean z2 = true;
            if (f.this.cj != null && f.this.cj.i("pref_zoom_key") && f.this.cc != null && !f.this.cc.aP() && !f.this.aG && !z && !f.this.T() && !f.this.cc.ak() && (!b() || !f.this.cj.i("pref_none_sat_ultra_wide_angle_key") || !f.this.co())) {
                f.this.au();
                f.this.v(true);
            }
            if (f.this.cj != null) {
                f.this.cj.m(z);
            }
            if (f.this.cN != null) {
                v A = f.this.cN;
                if (!f.this.m() || !f.this.br()) {
                    z2 = false;
                }
                A.c(z2);
            }
        }

        public void a(int i, boolean z, boolean z2) {
            f.this.b(i, z, z2);
        }

        public boolean k() {
            return f.this.K();
        }

        public boolean a(int i) {
            if (f.this.cj != null) {
                return f.this.cj.e(i);
            }
            return false;
        }

        public boolean l() {
            if (f.this.cj != null) {
                return f.this.cj.F();
            }
            return false;
        }

        public int m() {
            return (f.this.cj == null || 1 != f.this.cj.k(0)) ? 0 : 1;
        }

        public void c(String str) {
            if (f.this.cc != null) {
                f.this.cj.a(f.this.cc.z());
            }
        }

        public void d(String str) {
            if (f.this.cj != null) {
                f.this.cj.f(str);
            }
        }

        public boolean n() {
            if (f.this.cj != null) {
                return f.this.cj.K();
            }
            return false;
        }

        public boolean a(String str, boolean z, boolean z2, boolean z3) {
            String c = com.oppo.camera.entry.b.c(str);
            if (z3) {
                f.this.a(c, z, com.oppo.camera.ui.menu.f.a(), f.this.cc.s() || f.this.cc.G(), z2);
            }
            if (f.this.as || f.this.bf || !f.this.bn || !f.this.bi || !aD() || f.this.aD || f.this.aC || f.this.d() || f.this.aA || f.this.cc.ca() || !f.this.cj.O() || ((f.this.cj.i("pref_burst_shot_key") && f.this.aG) || y() || f.this.cj.aK() || f.this.cc.t() || (f.this.cj.aO() && !f.this.cj.i("key_intelligent_high_frame_usage_key")))) {
                StringBuilder sb = new StringBuilder();
                sb.append("onMenuButtonClick, key: ");
                sb.append(c);
                sb.append(", mbPaused: ");
                sb.append(f.this.as);
                sb.append(", !mbDoubleFinger: ");
                sb.append(!f.this.bf);
                sb.append(", !mbInitialized: ");
                sb.append(!f.this.bn);
                sb.append(", !mbFrameAvailable: ");
                sb.append(!f.this.bi);
                sb.append(", !isPreviewStarted: ");
                sb.append(!aD());
                sb.append(", mbSizeChanging: ");
                sb.append(f.this.aD);
                sb.append(", CaptureModeChangeState: ");
                sb.append(f.this.aC);
                sb.append(", isAnimationRunning: ");
                sb.append(f.this.d());
                sb.append(", mbSwitchingCamera: ");
                sb.append(f.this.aA);
                sb.append(", isEffectMenuScrolling: ");
                sb.append(f.this.cc.ca());
                sb.append(", !mModeManager.isAllowSwitch: ");
                sb.append(!f.this.cj.O());
                sb.append(", mbBurstShot: ");
                sb.append(f.this.aG);
                sb.append(", isTimerSnapShotRunning: ");
                sb.append(y());
                sb.append(", mModeManager.isVideoRecordStarting: ");
                sb.append(f.this.cj.aK());
                sb.append(", mModeManager.isVideoRecordStopping: ");
                sb.append(f.this.cj.aO());
                sb.append(", mCameraUIManager.isAnimationRunning: ");
                sb.append(f.this.cc.t());
                e.e("CameraManager", sb.toString());
                return false;
            }
            if ("pref_super_raw_control_key".equals(c)) {
                f.this.cj.m(c);
            }
            if (!f.this.cc.t() && "pref_video_blur_menu".equals(c)) {
                if (f.this.cc.G()) {
                    if (ae() == 0) {
                        f.this.cc.E(60);
                        return true;
                    }
                    f.this.bS();
                    f fVar = f.this;
                    fVar.a((SharedPreferences) fVar.bP);
                    a(0, false);
                } else if (ag()) {
                    f.this.bS();
                    f fVar2 = f.this;
                    fVar2.a((SharedPreferences) fVar2.bP);
                    a(0, false);
                    f.this.cj.x(false);
                    return true;
                }
                f.this.ct();
            }
            if ("pref_video_blur_menu".equals(c) || "pref_video_tilt_shift_key".equals(c) || "pref_video_timelapse_tilt_shift_key".equals(c) || "pref_photo_tilt_shift_key".equals(c) || "pref_tilt_shift_blur_menu".equals(c) || "pref_filter_menu".equals(c) || "pref_portrait_new_style_menu".equals(c) || "pref_portrait_blur_menu".equals(c) || "pref_video_filter_menu".equals(c) || "pref_video_super_eis_key".equals(c)) {
                f.this.cc.D(false);
            }
            f.this.cc.r(c);
            if ("pref_video_filter_menu".equals(c) || "pref_portrait_new_style_menu".equals(c) || "pref_night_filter_menu".equals(c)) {
                f.this.cs();
            }
            if (f.this.cf != null && f.this.cf.e()) {
                e.b("CameraManager", "onMenuButtonClick(), consumed by ZoomMenu");
                f.this.cf.b(false);
            }
            if ("key_multicamera_type_menu_key".equals(c) && f.this.cc.T()) {
                f.this.cc.a("key_multicamera_type_menu_key", false, 0, 0);
                androidx.preference.j.a((Context) f.this.bO).edit().putBoolean("multi_video_setting_menu_reddot_show", false).apply();
            }
            if ("pref_super_raw_control_key".equals(c) && f.this.cc.U()) {
                f.this.cc.a("pref_super_raw_control_key", false, 0, 0);
                androidx.preference.j.a((Context) f.this.bO).edit().putBoolean("super_raw_setting_menu_reddot_show", false).apply();
            }
            if ("pref_video_timelapse_tilt_shift_key".equals(c) && f.this.cc.V()) {
                f.this.cc.a("pref_video_timelapse_tilt_shift_key", false, 0, 0);
                androidx.preference.j.a((Context) f.this.bO).edit().putBoolean("timelapse_tiltshift_menu_reddot_show", false).apply();
            }
            return true;
        }

        public boolean a(String str, boolean z) {
            String c = com.oppo.camera.entry.b.c(str);
            boolean f = f.this.n(c);
            if ("pref_camera_torch_mode_key".equals(c) && f.this.cn()) {
                SharedPreferences.Editor edit = f.this.bP.edit();
                edit.putString("pref_camera_hdr_mode_key", "off");
                edit.apply();
                f.this.cc.f("pref_camera_hdr_mode_key");
            }
            return f;
        }

        public String a(String str, int i, int i2) {
            if (!f.this.cc.s() || !f.this.n(str) || i == i2) {
                return null;
            }
            f.this.cc.ad(true);
            f.this.cc.n(true);
            return null;
        }

        public void b(String str, int i, int i2) {
            f.this.q(str);
        }

        public void o() {
            if (f.this.cj != null) {
                f.this.cj.s();
            }
        }

        public boolean e(String str) {
            if (f.this.cj != null) {
                return f.this.cj.d(str);
            }
            return false;
        }

        public boolean f(String str) {
            if (f.this.cj != null) {
                return f.this.cj.e(str);
            }
            return false;
        }

        public boolean g(String str) {
            if (f.this.cj != null) {
                return f.this.cj.i(str);
            }
            return false;
        }

        public boolean p() {
            return f.this.cj.g();
        }

        public void q() {
            e.a("CameraManager", "onPreviewTextureCopied");
            f.this.dN.removeMessages(6);
            f.this.dN.sendEmptyMessage(6);
        }

        public void r() {
            f.this.b(true, 1);
        }

        public int s() {
            String string = f.this.bP != null ? f.this.bP.getString("pref_mirror_key", f.this.bO.getString(R.string.camera_mirror_default_value)) : "off";
            boolean z = f.this.G == 0 || f.this.G == 180;
            if (f.this.cj == null || !f.this.cj.dg() || !TextUtils.equals(string, "on")) {
                return 0;
            }
            return z ? 1 : 2;
        }

        public int t() {
            return f.this.K;
        }

        public int u() {
            return f.this.ak();
        }

        public int v() {
            return f.this.aU();
        }

        public boolean w() {
            if (f.this.ce != null) {
                return f.this.ce.r();
            }
            return false;
        }

        public boolean x() {
            if (f.this.ce != null) {
                return f.this.ce.s();
            }
            return false;
        }

        public boolean y() {
            return f.this.at();
        }

        public boolean z() {
            return (f.this.cj != null && (f.this.cj.T() || f.this.cj.aM())) || f.this.cZ;
        }

        public boolean A() {
            return f.this.ay;
        }

        public boolean B() {
            return f.this.cj.aN();
        }

        public boolean C() {
            if (!f.this.aM() || f.this.aQ < ((float) f.this.cc.aa())) {
                return true;
            }
            e.a("CameraManager", "canScrollHeadLine, isZoomSeekBarExpand: " + f.this.aM());
            return false;
        }

        public void a(RotateImageView rotateImageView) {
            if (f.this.ce != null) {
                f.this.ce.a(rotateImageView);
            }
        }

        public void a(int i, int i2) {
            if (f.this.ce != null) {
                f.this.ce.a(i, i2);
            }
            if (f.this.cf != null) {
                f.this.cf.a(i, i2);
            }
            if (f.this.cc != null && f.this.cg != null && ah()) {
                if (f.this.cc.aY() != null) {
                    f.this.cg.initialize(f.this.cj.a(f.this.bS), f.this.cc.aY());
                }
                f.this.cg.setPreviewSize(i, i2);
            }
        }

        public void D() {
            f.this.cJ();
        }

        public void b(int i, int i2) {
            f.this.k(0);
            f.this.b(false, false);
            f.this.a(i, i2, false);
        }

        public void c(int i, int i2) {
            f.this.c(i, i2);
        }

        public void b(int i, boolean z, boolean z2) {
            if (f.this.cj != null) {
                f.this.cj.a(i, z);
            }
            if (f.this.dN != null) {
                f.this.dN.removeMessages(19);
                Message obtainMessage = f.this.dN.obtainMessage(19);
                obtainMessage.arg1 = z ? i : 0;
                f.this.dN.sendMessage(obtainMessage);
            }
            if (z2) {
                f.this.b(i, z);
            }
        }

        public void b(int i) {
            if (f.this.cj != null) {
                f.this.cj.f(i);
            }
        }

        public boolean E() {
            return f.this.bd();
        }

        public boolean F() {
            return f.this.M();
        }

        public boolean h(String str) {
            if (!F()) {
                return false;
            }
            if ("more".equals(str)) {
                return true;
            }
            if (f.this.cj != null) {
                String l = f.this.cj.l();
                e.a("CameraManager", "isHeadlineCanTouch, modeName: " + str + ", currentModeName: " + l);
                if (TextUtils.equals(str, l)) {
                    return true;
                }
            }
            if (f.this.cT == null) {
                return false;
            }
            String b2 = f.this.cT.b();
            e.a("CameraManager", "isHeadlineCanTouch, modeName: " + str + ", lastModeName: " + b2);
            if (TextUtils.equals(str, b2)) {
                return true;
            }
            return false;
        }

        public void G() {
            if (!aD() || !f.this.bi) {
                e.a("CameraManager", "onModeTitleTouch, return false, state: " + f.this.E + ", mbFrameAvailable: " + f.this.bi);
            } else if (!f.this.aO()) {
                if (y()) {
                    e.a("CameraManager", "onModeTitleTouch, can not touch, timesnap is running");
                } else if (b()) {
                    e.a("CameraManager", "onModeTitleTouch, can not touch, video record started");
                } else if (!f.this.cZ || g("key_capturing_click_close")) {
                    String e = f.this.cj.e();
                    if (e.equals(ApsConstant.CAPTURE_MODE_NIGHT) && f.this.ao && !f.this.cj.a(e).f("pref_support_night_process")) {
                        e = f.this.cj.q();
                    }
                    String a2 = f.this.cj.a(f.this.K, e);
                    f.this.cc.bW();
                    f.this.cc.ai(true);
                    f.this.cc.b(f.this.K, a2);
                    if (!f.this.cc.cU()) {
                        f.this.cc.a(0);
                    }
                    if (!f.this.d(a2)) {
                        f.this.cc.ah(true);
                        f.this.cc.a(4);
                    }
                    f.this.cc.dd();
                } else {
                    e.a("CameraManager", "onModeTitleTouch, can not touch, panorama capture is running");
                }
            }
        }

        public void c(final int i) {
            e.a("CameraManager", "onModeItemClick, itemId: " + i);
            if (9 == i) {
                f.this.bQ();
                f.this.cc.an(true);
                f.this.a(true, true, -1);
                f.this.D(true);
            } else if (!F()) {
                e.a("CameraManager", "onModeItemClick, is not allowed to switch mode");
                f.this.bP();
                f.this.cc.an(true);
                f.this.a(true, true, -1);
            } else {
                f.this.ce.i(false);
                boolean z = 3 == i;
                if (g("pref_zoom_key")) {
                    f.this.a((Animation.AnimationListener) null);
                    f.this.v(false);
                }
                f.this.E(false);
                if (!z) {
                    f.this.cc.a(4, 0, 0, (TimeInterpolator) null, (Animator.AnimatorListener) new Animator.AnimatorListener() {
                        public void onAnimationRepeat(Animator animator) {
                        }

                        public void onAnimationStart(Animator animator) {
                        }

                        public void onAnimationEnd(Animator animator) {
                            f.this.cc.o(com.oppo.camera.ui.modepanel.a.a(f.this.bO, i));
                            f.this.cc.ah(true);
                            f.this.cc.an(false);
                        }

                        public void onAnimationCancel(Animator animator) {
                            f.this.cc.o(com.oppo.camera.ui.modepanel.a.a(f.this.bO, i));
                            f.this.cc.ah(true);
                            f.this.cc.an(false);
                        }
                    });
                } else {
                    f.this.cc.an(false);
                }
                f.this.cc.o(true);
                f.this.d(com.oppo.camera.ui.modepanel.a.b(i));
            }
        }

        public void H() {
            if (f.this.cj != null) {
                f.this.cj.bt();
            }
        }

        public int I() {
            if (f.this.cj != null) {
                return f.this.cj.bs();
            }
            return 0;
        }

        public int J() {
            if (f.this.cj != null) {
                return f.this.cj.bp();
            }
            return 0;
        }

        public int d(int i) {
            if (f.this.cj != null) {
                return f.this.cj.n(i);
            }
            return -100000;
        }

        public void e(int i) {
            if (f.this.cj != null) {
                f.this.cj.m(i);
            }
        }

        public void a(int i, int i2, boolean z) {
            if (f.this.cj != null) {
                f.this.cj.a(i, i2, z);
            }
        }

        public int K() {
            if (f.this.cj != null) {
                return f.this.cj.bu();
            }
            return 40;
        }

        public int[] L() {
            if (f.this.cj != null) {
                return f.this.cj.bv();
            }
            return d.f2784a;
        }

        public void f(int i) {
            e.a("CameraManager", "onBackFromMoreMode");
            f.this.a(true, true, i);
        }

        public boolean M() {
            if (f.this.cf != null) {
                return f.this.cf.e();
            }
            return false;
        }

        public boolean N() {
            return f.this.cf != null && f.this.cf.f();
        }

        public void O() {
            f.this.av();
        }

        public String P() {
            return f.this.cj != null ? f.this.cj.l() : "";
        }

        public boolean Q() {
            if (f.this.cj != null) {
                return f.this.cj.a();
            }
            return false;
        }

        public boolean R() {
            if (f.this.cj != null) {
                return f.this.cj.b();
            }
            return false;
        }

        public boolean S() {
            if (f.this.cj != null) {
                return f.this.cj.c();
            }
            return false;
        }

        public boolean i(String str) {
            if (f.this.cc != null) {
                if ("pref_camera_flashmode_key".equals(str) && f.this.cc.cr()) {
                    return false;
                }
                if ("pref_camera_hdr_mode_key".equals(str) && f.this.cc.cs()) {
                    return false;
                }
                if ("pref_filter_menu".equals(str) && f.this.cc.ct()) {
                    return false;
                }
            }
            if ("pref_camera_flashmode_key".equals(str) || "pref_camera_videoflashmode_key".equals(str)) {
                return f.this.cr();
            }
            if (f.this.cj != null) {
                return f.this.cj.n(str);
            }
            return true;
        }

        public Size a(double d) {
            if (f.this.cj != null) {
                return f.this.cj.a(f.this.bS, d);
            }
            return null;
        }

        public void a(final com.oppo.camera.t.a aVar) {
            com.oppo.camera.t.a unused = f.this.dp = aVar;
            f.this.bO.runOnUiThread(new Runnable() {
                public void run() {
                    if (f.this.cj != null && f.this.cc != null) {
                        if (AnonymousClass46.this.as() || !f.this.cj.bG()) {
                            f.this.cc.a((com.oppo.camera.t.a) null);
                        } else {
                            f.this.cc.a(aVar);
                        }
                    }
                }
            });
        }

        public void b(com.oppo.camera.t.a aVar) {
            f.this.cc.b(aVar);
        }

        public void b(boolean z) {
            if (f.this.ck != null) {
                f.this.ck.a(z);
            }
        }

        public void T() {
            if (f.this.cj != null) {
                f.this.cj.cg();
            }
        }

        public boolean U() {
            if (f.this.cj != null) {
                return f.this.cj.aV();
            }
            return false;
        }

        public String V() {
            if (f.this.cj != null) {
                return f.this.cj.cR();
            }
            return null;
        }

        public Size W() {
            if (f.this.cT != null) {
                return f.this.cT.b(f.this.bS);
            }
            return null;
        }

        public void X() {
            f.this.cA();
        }

        public void Y() {
            f.this.cA();
        }

        public boolean Z() {
            if (f.this.cj != null) {
                return f.this.cj.ac();
            }
            return false;
        }

        public void aa() {
            if (f.this.cf != null) {
                f.this.cf.j();
            }
        }

        public boolean ab() {
            if (f.this.cj == null) {
                return false;
            }
            if (Z()) {
                return true;
            }
            if (!f.this.cj.cO() || !CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_STAR_VIDEO)) {
                return false;
            }
            return true;
        }

        public boolean ac() {
            if (f.this.cj != null) {
                return f.this.cj.bw();
            }
            return true;
        }

        public void ad() {
            if (f.this.cj != null) {
                f.this.cj.dc();
            }
        }

        public int ae() {
            if (f.this.cj != null) {
                return f.this.cj.bA();
            }
            return 60;
        }

        public void a(int i, boolean z) {
            if (f.this.cj != null) {
                f.this.cj.p(i);
                if (!z) {
                    return;
                }
                if (f.this.cj.i(CameraFunction.VIDEO_BLUR_PROCESS)) {
                    f.this.q("pref_video_blur_menu_state");
                } else if (f.this.cj.i(CameraFunction.FACE_BLUR) || f.this.cj.i(CameraFunction.BOKEH)) {
                    f.this.q("pref_portrait_blur_menu_index");
                }
            }
        }

        public void c(boolean z) {
            if (f.this.cg != null) {
                f.this.cg.switchTiltShiftType(z);
            }
        }

        public void af() {
            if (f.this.cj != null) {
                f.this.cj.L();
            }
        }

        public void a(boolean z, boolean z2) {
            if (f.this.cj != null) {
                f.this.cj.o(z);
                if (z2) {
                    f.this.q("pref_video_blur_menu_state");
                }
            }
        }

        public boolean ag() {
            if (f.this.cj != null) {
                return f.this.cj.bB();
            }
            return false;
        }

        public boolean ah() {
            if (f.this.cj != null) {
                return f.this.cj.aB();
            }
            return false;
        }

        public boolean ai() {
            if (f.this.cj != null) {
                return f.this.cj.aC();
            }
            return false;
        }

        public boolean aj() {
            if (f.this.cj != null) {
                return f.this.cj.bE();
            }
            return false;
        }

        public boolean ak() {
            return f.this.aC;
        }

        public int al() {
            return f.this.U;
        }

        public boolean am() {
            return f.this.cr();
        }

        public boolean an() {
            return f.this.cD();
        }

        public void ao() {
            if (f.this.cj != null) {
                f.this.cj.cc();
            }
        }

        public void d(boolean z) {
            if (f.this.cf != null) {
                f.this.z(z);
            }
        }

        public void e(boolean z) {
            if (f.this.cf != null) {
                f.this.cf.a(0, f.this.cf.i(), z);
            }
        }

        public void ap() {
            f.this.a((Animation.AnimationListener) null);
            f.this.v(false);
        }

        public void aq() {
            f.this.au();
            f.this.v(true);
        }

        public void f(boolean z) {
            if (f.this.cj != null) {
                f.this.cj.q(z);
            }
        }

        public boolean ar() {
            return !f.this.cc.H() && !Camera.l && !Camera.m && f.this.cj != null && f.this.cj.i("key_support_show_dim_hint") && "off".equals(f.this.cj.Q()) && f.this.cp() && !b();
        }

        public void a(String str, String str2) {
            f.this.a(str, str2);
        }

        public void j(String str) {
            if (f.this.cj != null) {
                f.this.cj.p(str);
            }
        }

        public void k(String str) {
            if (f.this.cj != null) {
                f.this.cj.q(str);
            }
        }

        public boolean as() {
            return f.this.D();
        }

        public boolean at() {
            if (f.this.cj != null) {
                return f.this.cj.cA();
            }
            return false;
        }

        public boolean au() {
            return g("key_support_share_edit_thumb") && "on".equals(f.this.bP != null ? f.this.bP.getString("pref_share_and_edit_key", f.this.bO.getString(R.string.camera_share_default_value)) : "off");
        }

        public void av() {
            if (f.this.cc.G()) {
                f.this.cc.d(true, true, true);
            }
            if (f.this.cc.s()) {
                f.this.cc.ad(true);
                f.this.cc.b(false);
            }
            if (f.this.cc.C() && !f.this.cc.t()) {
                f.this.cc.b(true, true, false);
            }
            if (f.this.cj != null) {
                f.this.cj.X();
            }
            if (f.this.cf != null && f.this.cc != null && !f.this.cc.ak() && !f.this.cc.C()) {
                f.this.cf.c();
            }
        }

        public void g(int i) {
            MenuClickMsgData menuClickMsgData = new MenuClickMsgData(f.this.bO);
            menuClickMsgData.buildEvent(false);
            menuClickMsgData.mFuncKeyId = i;
            menuClickMsgData.mFuncKeyResult = 1;
            menuClickMsgData.mCaptureMode = P();
            menuClickMsgData.mCameraId = f.this.aU();
            menuClickMsgData.mOrientation = f.this.G;
            menuClickMsgData.mCaptureType = true ^ p() ? 1 : 0;
            menuClickMsgData.report();
        }

        public com.oppo.camera.entry.b aw() {
            return f.this.cH;
        }

        public void l(String str) {
            if (f.this.cj != null) {
                MenuClickMsgData menuClickMsgData = new MenuClickMsgData(f.this.bO);
                menuClickMsgData.buildEvent(false);
                menuClickMsgData.mCameraId = v();
                menuClickMsgData.mCaptureMode = f.this.cj.l();
                menuClickMsgData.mToolbarType = str;
                menuClickMsgData.mFuncKeyId = 26;
                menuClickMsgData.mFuncKeyResult = "off".equals(f.this.bP.getString("pref_subsetting_key", "off")) ? 2 : 1;
                menuClickMsgData.report();
            }
        }

        public boolean ax() {
            return f.this.cj != null && f.this.cj.cM();
        }

        public boolean ay() {
            return f.this.bP != null && "movie".equals(f.this.bP.getString("pref_camera_mode_key", Util.a(f.this.be())));
        }

        public float az() {
            if (f.this.cj != null) {
                return f.this.cj.cS();
            }
            return 1.0f;
        }

        public boolean aA() {
            if (f.this.cj != null) {
                return f.this.cj.bh();
            }
            return false;
        }

        public void h(int i) {
            if (f.this.cj != null) {
                f.this.cj.r(i);
            }
        }

        public void d(int i, int i2) {
            if (f.this.cj != null) {
                f.this.cj.a(i, i2, w(), f.this.T);
            }
        }

        public boolean e(int i, int i2) {
            return f.this.cj != null && f.this.cj.b(i, i2);
        }

        public void i(int i) {
            if (f.this.cc != null) {
                f.this.bP.edit().putInt("pref_multicamera_type_selected_key", i).apply();
                f.this.bF();
                f.this.cc.s(i);
            }
        }

        public void aB() {
            if (f.this.ce != null) {
                f.this.ce.z();
            }
        }

        public boolean aC() {
            return f.this.ce != null && f.this.ce.y();
        }

        public boolean aD() {
            return f.this.S();
        }

        public void m(String str) {
            f.this.p(str);
        }

        public void aE() {
            if (f.this.cU != null) {
                f.this.cU.a(f.this.cH.m());
            }
        }

        public void a(String str, Object obj, boolean z, boolean z2) {
            if (f.this.cj != null) {
                f.this.cj.a(str, obj, z, z2);
            }
        }

        public String aF() {
            return f.this.cj != null ? f.this.cj.dh() : "key_filter_index";
        }

        public String aG() {
            return f.this.cj != null ? f.this.cj.di() : "pref_filter_menu";
        }

        public void g(boolean z) {
            if (f.this.cc != null) {
                f.this.cc.at(z);
            }
        }

        public void aH() {
            if (f.this.cj != null) {
                f.this.cj.dk();
            }
        }

        public boolean aI() {
            if (f.this.cj != null) {
                return f.this.cj.df();
            }
            return false;
        }

        public void b(boolean z, boolean z2) {
            if (f.this.cf == null) {
                return;
            }
            if (z) {
                f.this.cf.d(z2);
            } else {
                f.this.cf.c(z2);
            }
        }

        public void a(com.oppo.camera.doubleexposure.f fVar) {
            if (f.this.cd != null && fVar != null) {
                f.this.cd.j(fVar.a());
            }
        }

        public void a(com.oppo.camera.doubleexposure.b bVar, g.a aVar) {
            if (f.this.cj != null) {
                f.this.cj.a(bVar, aVar);
            }
        }

        public void j(int i) {
            if (f.this.cj != null) {
                f.this.cj.s(i);
            }
        }

        public View aJ() {
            if (f.this.cf != null) {
                return f.this.cf.d();
            }
            return null;
        }

        public void aK() {
            if (f.this.dd && f.this.cj != null) {
                f.this.cj.dl();
                boolean unused = f.this.dd = false;
            }
        }

        public boolean aL() {
            if (f.this.cj != null) {
                return f.this.cj.dn();
            }
            return true;
        }

        public boolean aM() {
            if (f.this.cj != null) {
                return f.this.cj.m6do();
            }
            return false;
        }

        public void h(boolean z) {
            if (f.this.cj != null) {
                f.this.cj.y(z);
            }
        }

        public boolean aN() {
            if (f.this.cH != null) {
                return f.this.cH.f();
            }
            return false;
        }

        public void i(boolean z) {
            f.this.a(z);
        }
    };
    private com.oppo.camera.ui.menu.e dX = new com.oppo.camera.ui.menu.e() {
        public void a(String str) {
            if (f.this.cj != null) {
                f.this.cj.b(8, false);
            }
        }

        public void b(String str) {
            if (f.this.cj != null) {
                f.this.cj.b(8, true);
            }
        }

        public void c(String str) {
            if (f.this.cj != null) {
                f.this.cj.b(9, false);
            }
        }

        public void d(String str) {
            if (f.this.cj != null) {
                f.this.cj.b(9, true);
            }
        }
    };
    private ThumbnailProcessor.ThumbnailProcessListener dY = new ThumbnailProcessor.ThumbnailProcessListener() {
        public void updateLastThumbnailView(Uri uri, ContentResolver contentResolver) {
        }

        public void updateLastThumbnailView(boolean z) {
        }

        public void updateThumbnail(final com.oppo.camera.ui.control.e eVar, ThumbnailItem thumbnailItem, ContentResolver contentResolver) {
            if (!(f.this.de == null || f.this.cj == null || !f.this.cj.az())) {
                thumbnailItem.mProductProcessor = f.this.dD;
                thumbnailItem.mUpdateLastThumbTask = f.this.cv();
                f.this.de.addThumbnailInfo(thumbnailItem);
            }
            if (f.this.cj != null) {
                f.this.cj.a(thumbnailItem);
            }
            if (f.this.dN == null || f.this.as) {
                f.this.a(true);
            } else {
                f.this.dN.post(new Runnable() {
                    public void run() {
                        if (f.this.cc != null) {
                            f.this.cc.a(eVar, !f.this.aG);
                        }
                        f.this.a(true);
                    }
                });
            }
            if (eVar != null) {
                com.oppo.camera.ui.control.g.a();
                com.oppo.camera.ui.control.g.a(eVar);
            }
        }
    };
    private com.oppo.camera.ui.control.f dZ = new com.oppo.camera.ui.control.f() {

        /* renamed from: b  reason: collision with root package name */
        private b.C0100b f3019b = new b.C0100b() {
            public void a(com.oppo.camera.ui.control.e eVar) {
                e.b("CameraManager", "onThumbnailLoadSucceed: uri = " + eVar.d());
                f.this.a(eVar);
            }
        };

        public void a(z.a aVar) {
            e.a("CameraManager", "notifyGalleryPreDecode");
            if (aVar != null && aVar.c != null) {
                com.oppo.camera.n.a.a().a(aVar);
            }
        }

        public void a(com.oppo.camera.ui.control.e eVar) {
            if (!f.this.bK() || eVar == null) {
                e.d("CameraManager", "onThumbNailClick, cameraState: " + f.this.E + ", thumbnail: " + eVar);
                return;
            }
            Uri d = eVar.d();
            boolean a2 = Util.a(d, f.this.bO.getContentResolver());
            boolean z = f.this.aj() && f.this.cX;
            if ((!f.this.cH.m() || z) && a2) {
                e.e("CameraManager", "CameraTest Camera View Picture Start, onThumbNailClick, mCurrentUri: " + d);
                if (!f.this.cH.m() && f.this.cH.s()) {
                    f.this.cH.r();
                }
                f.this.a(eVar);
                return;
            }
            e.d("CameraManager", "onThumbNailClick, imageSaveListIsEmpty: " + com.oppo.camera.n.b.a().g() + ", getDisplayOnLock: " + f.this.aj() + ", isLockAlbumHasPicture: " + z + ", isUriValid: " + a2);
            f.this.cc.a(this.f3019b);
        }

        public boolean a() {
            if (!f.this.cH.m()) {
                return true;
            }
            if (!f.this.cW && f.this.cX) {
                return true;
            }
            e.a("CameraManager", "needGetLastThumbNail, LockAblum list is null");
            return false;
        }

        public void a(boolean z) {
            if (z) {
                com.oppo.camera.v.c.a().a(new Runnable() {
                    public void run() {
                        AnonymousClass50.this.b();
                    }
                }, "query lock album");
            } else {
                b();
            }
        }

        /* access modifiers changed from: private */
        public void b() {
            Cursor query;
            Throwable th;
            Uri parse = Uri.parse("content://com.oppo.gallery3d.open.provider/locked_pictures");
            if (f.this.bO != null) {
                try {
                    query = f.this.bO.getApplicationContext().getContentResolver().query(parse, new String[]{"count(*)"}, (Bundle) null, (CancellationSignal) null);
                    if (query != null) {
                        if (query.moveToFirst()) {
                            boolean unused = f.this.cX = query.getLong(0) > 0;
                        }
                    }
                    if (query != null) {
                        query.close();
                    }
                } catch (Exception e) {
                    e.d("CameraManager", "realUpdateLockAlbumHasPicture, Failed to query LOCK_SCREEN_URI uri: " + parse, e);
                    boolean unused2 = f.this.cX = false;
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            e.a("CameraManager", "realUpdateLockAlbumHasPicture, mbLockAlbumHasPicture: " + f.this.cX);
            return;
            throw th;
        }
    };
    /* access modifiers changed from: private */
    public boolean da = true;
    /* access modifiers changed from: private */
    public boolean db = false;
    private boolean dc = false;
    /* access modifiers changed from: private */
    public boolean dd = false;
    /* access modifiers changed from: private */
    public ApsService de = null;
    /* access modifiers changed from: private */
    public b df = new b();
    /* access modifiers changed from: private */
    public ConditionVariable dg = new ConditionVariable();
    private a dh = new a();
    /* access modifiers changed from: private */
    public ApsInitParameter di = new ApsInitParameter();
    /* access modifiers changed from: private */
    public List<ImageCategory.ImageItemInfo> dj = new CopyOnWriteArrayList();
    /* access modifiers changed from: private */
    public long dk = -1;
    /* access modifiers changed from: private */
    public long dl = -1;
    /* access modifiers changed from: private */
    public String dm = VideoRecordMsgData.END_TYPE_NORMAL;
    /* access modifiers changed from: private */
    public int dn = 3;

    /* renamed from: do  reason: not valid java name */
    private e.a f0do = null;
    /* access modifiers changed from: private */
    public com.oppo.camera.t.a dp = null;
    /* access modifiers changed from: private */
    public Handler dq = null;
    private Handler dr = null;
    /* access modifiers changed from: private */
    public Handler ds = null;
    /* access modifiers changed from: private */
    public Handler dt = null;
    /* access modifiers changed from: private */
    public volatile w du = null;
    private long dv = 0;
    private YuvUtil dw = null;
    private com.oppo.camera.u.d dx = null;
    private long dy = 0;
    /* access modifiers changed from: private */
    public boolean dz = false;
    /* access modifiers changed from: private */
    public com.oppo.camera.ui.control.a ea = new com.oppo.camera.ui.control.a() {
        public void a() {
            f.this.P();
        }

        public void b() {
            if (!f.this.as && f.this.cK != null) {
                f.this.cc.br();
                f.this.cc.d(true, false);
                if (f.this.b("pref_camera_hdr_mode_key")) {
                    f.this.cj.b(6, true);
                }
                f.this.cj.b(5, true);
                f.this.ci();
                f.this.cj.a(f.this.cj.Q(), true);
                f.this.j(1);
                if (f.this.cH.y() == 2 && !f.this.ao && f.this.bR != null) {
                    f.this.bR.o();
                }
            }
        }

        public void c() {
            f.this.cj.k(true);
        }

        public void d() {
            f.this.cj.aD();
            f.this.cc.bs();
            f.this.cc.U(f.this.ao);
            f.this.ci();
            f.this.cc.b("pref_camera_videoflashmode_key", (String) null);
            f.this.cj.aF();
        }

        public void e() {
            boolean unused = f.this.bl = true;
            f.this.cj.aE();
        }

        public void f() {
            f.this.cj.de();
        }

        public void a(boolean z) {
            f.this.cj.w(z);
        }

        public void g() {
            f.this.cj.v(true);
        }

        public void b(boolean z) {
            if (f.this.as || f.this.U() || f.this.T() || !z || !f.this.S() || z.t != 0) {
            }
        }

        public void h() {
            e.a("CameraManager", "onCameraShutterButtonClick");
            boolean unused = f.this.ap = true;
            if (f.this.cc != null) {
                if (f.this.cc.J()) {
                    f.this.cc.K();
                }
                f.this.cc.aq(false);
            }
            if (f.this.ch != null && f.this.ch.e()) {
                boolean unused2 = f.this.ap = false;
            } else if (f.this.ce == null || !f.this.ce.B()) {
                e.a("CameraManager", "onCameraShutterButtonClick, normal snapshot");
                e.a("captureX onCameraShutterButtonClick");
                f.this.cw();
                boolean unused3 = f.this.ap = false;
                if (f.this.aj()) {
                    f.this.t(false);
                }
                e.b("captureX onCameraShutterButtonClick");
            } else {
                boolean unused4 = f.this.ap = false;
                e.a("CameraManager", "onCameraShutterButtonClick, wait AF so return");
            }
        }

        public void i() {
            boolean a2 = f.this.a(1);
            if (f.this.at() || f.this.cj.aM() || f.this.cj.T() || !a2 || f.this.as || f.this.aA || !f.this.cY || f.this.T()) {
                e.d("CameraManager", "onCameraShutterButtonLongClick, isTimerSnapShotRunning: " + f.this.at() + ", isVideoRecording: " + f.this.cj.aM() + ", isCapturingState: " + f.this.cj.T() + ", isSoundLoaded: " + a2 + ", mbPaused: " + f.this.as + ", mbSwitchingCamera: " + f.this.aA + ", mbApsFinishAddFrame: " + f.this.cY + ", isPreviewStopped: " + f.this.T());
                return;
            }
            if (f.this.cc != null && f.this.cc.J()) {
                f.this.cc.K();
            }
            if (z.t != 0) {
                e.d("CameraManager", "onCameraShutterButtonLongClick, sStorageStatus is failed, so return");
                f.this.cc.o();
            } else if (f.this.cj.i("key_short_video")) {
                f.this.dN.removeMessages(9);
                f.this.u(true);
                f.this.cj.v();
                if (f.this.aj()) {
                    f.this.t(false);
                }
            } else {
                boolean i = f.this.cj.i("pref_burst_shot_key");
                boolean c = f.this.cj.c(false);
                if (!com.oppo.camera.n.b.a().a(f.this.bO, f.this.cj.N())) {
                    e.d("CameraManager", "checkReadyToCapture, memory or storage is not enough");
                    f.this.cj.M();
                    f.this.a(ReminderMsgData.TYPE_DISABLE_CODE, ReminderMsgData.CODE_MEMORY_CAPTURE);
                } else if (com.oppo.camera.n.b.a().f() || !i || f.this.aG || f.this.U() || f.this.aC || f.this.aD || c) {
                    e.d("CameraManager", "onCameraShutterButtonLongClick, checkQueueLimit: " + com.oppo.camera.n.b.a().f() + ", isBurstShotSupported: " + i + ", mbBurstShot: " + f.this.aG + ", isSnapShotProgress: " + f.this.U() + ", mbCaptureModeChanging: " + f.this.aC + ", mbSizeChanging: " + f.this.aD + ", stopTakePicture: " + c);
                } else if ("heic_10bits".equals(f.this.cj.bJ())) {
                    f.this.cc.a((int) R.string.camera_10bits_not_support_continuous_shot_tips, -1, true, false, false);
                    e.d("CameraManager", "onCameraShutterButtonLongClick, 10 bit heif does not support continuous shot");
                } else {
                    e.e("CameraManager", "onCameraShutterButtonLongClick");
                    if (f.this.cj != null) {
                        f.this.cj.l(true);
                    }
                    f.this.u(true);
                    f.this.f(false);
                    f.this.o(true);
                    int unused = f.this.aT = 0;
                    int unused2 = f.this.aU = 0;
                    if (f.this.cj.i("pref_filter_process_key")) {
                        f.this.cc.q(true);
                        f.this.cc.b(false);
                    }
                    if (f.this.cc.C()) {
                        f.this.cc.t(false);
                        f.this.cc.b(false, true, false);
                    }
                    f.this.cc.D(false);
                    f.this.bH();
                    if (!f.this.cj.t()) {
                        e.b("CameraManager", "onCameraShutterButtonLongClick, burstShotCapture return false!");
                        if (f.this.bO != null) {
                            f.this.bO.runOnUiThread(new Runnable() {
                                public void run() {
                                    f.this.au();
                                    f.this.v(true);
                                    if (f.this.cc != null) {
                                        f.this.cc.d(true, true);
                                    }
                                }
                            });
                        }
                        f.this.o(false);
                        f.this.j(1);
                        return;
                    }
                    f.this.a((Animation.AnimationListener) null);
                    if (f.this.aj()) {
                        f.this.t(false);
                    }
                }
            }
        }

        public void j() {
            if (f.this.cj.i("key_short_video")) {
                f.this.cj.w();
                return;
            }
            if (f.this.cc != null && f.this.cc.aH()) {
                f.this.cc.N(false);
            }
            boolean i = f.this.cj.i("pref_burst_shot_key");
            if (f.this.at() || f.this.cj.aM() || !f.this.aG || f.this.as || !i) {
                e.d("CameraManager", "onCameraShutterButtonLongClickReleased, isTimerSnapShotRunning: " + f.this.at() + ", isVideoRecording: " + f.this.cj.aM() + ", mbBurstShot: " + f.this.aG + ", mbPaused: " + f.this.as + ", supportBurstShot: " + i);
            } else if (f.this.cj.an() != 0 || !f.this.U()) {
                e.a("CameraManager", "onCameraShutterButtonLongClickReleased");
                f.this.o(false);
                f.this.cj.y();
                int v = f.this.bR.v();
                int size = CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_BURST_SHOT_CACHE_SUPPORT) ? f.this.dj.size() : f.this.aT;
                if (v != 0 && (size >= Util.d || (!Util.p() && f.this.aT >= v))) {
                    f.this.ba();
                }
                f.this.cc.a(f.this.cj.f(), f.this.cD());
            } else {
                e.a("CameraManager", "onCameraShutterButtonLongClickReleased, waiting receive first burst picture, so return");
                f.this.f(true);
            }
        }

        public void k() {
            if (f.this.as || !f.this.S() || !f.this.bn || f.this.cj.g() || f.this.cc.ca() || !f.this.a(4) || !f.this.a(5) || f.this.D()) {
                e.a("CameraManager", "onCameraVideoShutterButtonClick, mbPaused: " + f.this.as + ", isPreviewStarted: " + f.this.S() + ", mbInitialized: " + f.this.bn + ", isCaptureModeType: " + f.this.cj.g() + ", isEffectMenuScrolling: " + f.this.cc.ca() + ", isStartSoundLoaded: " + f.this.a(4) + ", isStopSoundLoaded: " + f.this.a(5) + ", isBlurAnimRunning: " + f.this.D());
                return;
            }
            f.this.dN.removeMessages(9);
            int unused = f.this.V = 0;
            f.this.u(true);
            f.this.cj.aG();
        }

        public void l() {
            f.this.f(true, false);
        }

        public void m() {
            int i;
            if (!f.this.S() || f.this.aC || f.this.at() || f.this.d() || f.this.aA || !f.this.cj.O() || f.this.cc.ca() || f.this.cc.aD() || !f.this.bi || !f.this.bn || !f.this.cY || !f.this.cj.i("pref_support_switch_camera") || f.this.cj.aV() || f.this.aG() || f.this.D()) {
                e.a("CameraManager", "onSwitchCameraButtonClick, isPreviewStarted: " + f.this.S() + ", mbCaptureModeChanging: " + f.this.aC + ", isTimerSnapShotRunning: " + f.this.at() + ", isAnimationRunning: " + f.this.d() + ", mbSwitchingCamera: " + f.this.aA + ", isAllowSwitch: " + f.this.cj.O() + ", isHeadLineAnimationRunning: " + f.this.cc.aD() + ", isEffectMenuScrolling: " + f.this.cc.ca() + ", mbFrameAvailable: " + f.this.bi + ", mbInitialized: " + f.this.bn + ", mbApsFinishAddFrame: " + f.this.cY + ", support switch: " + f.this.cj.i("pref_support_switch_camera") + ", isStickerMenuOpen: " + f.this.cj.aV() + ", isVideoRecording(): " + f.this.aG() + ", isBlurAnimRunning: " + f.this.D());
            } else if (f.this.cx()) {
                e.a("CameraManager", "onSwitchCameraButtonClick, interruptSwitchCameraClickEvent");
            } else {
                e.a("CameraManager", "onSwitchCameraButtonClick");
                if (f.this.aF() && f.this.cc.c().t()) {
                    e.a("CameraManager", "multi video intercept onSwitchCameraButtonClick");
                    f.this.cc.c().h(false);
                    f.this.cy();
                }
                e.a("onSwitchCameraButtonClick");
                if (!f.this.aF()) {
                    if (f.this.Q() == 0) {
                        i = 1;
                        f.this.cc.j(f.this.bO.getResources().getString(R.string.camera_description_front_camera));
                    } else {
                        f.this.cc.j(f.this.bO.getResources().getString(R.string.camera_description_rear_camera));
                        i = 0;
                    }
                    SharedPreferences.Editor edit = f.this.bP.edit();
                    edit.putString("pref_camera_id_key", Integer.toString(i));
                    edit.apply();
                }
                f.this.C(false);
                if (f.this.cj != null) {
                    f.this.cj.bm();
                }
                f.this.cz();
                if (f.this.cc.bT() && f.this.bU != null && !f.this.aF()) {
                    f.this.bU.c();
                }
                e.b("onSwitchCameraButtonClick");
            }
        }

        public void n() {
            e.a("CameraManager", "onSwitchCameraButtonDown");
            e.a("CameraStartupPerformance.onSwitchCameraButtonDown");
            if (f.this.dH == null) {
                f fVar = f.this;
                h unused = fVar.dH = new h();
            }
            f.this.cc.ch();
            if (!f.this.aA && f.this.S() && !f.this.aC && !f.this.aF()) {
                f.this.bI();
                f.this.R();
            }
            e.b("CameraStartupPerformance.onSwitchCameraButtonDown");
        }

        public void o() {
            e.a("CameraManager", "onSwitchCameraButtonUp");
            f.this.cc.ci();
        }

        public boolean p() {
            if (!f.this.S()) {
                e.a("CameraManager", "onVideoRecordingPause, preview not started.");
                return false;
            } else if (f.this.cj != null) {
                return f.this.cj.aI();
            } else {
                return false;
            }
        }

        public boolean q() {
            if (!f.this.S()) {
                e.a("CameraManager", "onVideoRecordingResume, preview not started.");
                return false;
            } else if (f.this.cj != null) {
                return f.this.cj.aJ();
            } else {
                return false;
            }
        }
    };
    /* access modifiers changed from: private */
    public final Object f = new Object();
    /* access modifiers changed from: private */
    public final Object g = new Object();
    /* access modifiers changed from: private */
    public final Object h = new Object();
    /* access modifiers changed from: private */
    public final Object i = new Object();
    /* access modifiers changed from: private */
    public final Object j = new Object();
    private final ExecutorService k = Executors.newSingleThreadExecutor();
    /* access modifiers changed from: private */
    public final ImageReader.OnImageAvailableListener l = new n("main_yuv_preview_image");
    /* access modifiers changed from: private */
    public final ImageReader.OnImageAvailableListener m = new n("main_yuv_capture_image");
    /* access modifiers changed from: private */
    public final ImageReader.OnImageAvailableListener n = new n("sub_yuv_preview_image");
    /* access modifiers changed from: private */
    public final ImageReader.OnImageAvailableListener o = new n("sub_yuv_capture_image");
    /* access modifiers changed from: private */
    public final ImageReader.OnImageAvailableListener p = new n("third_yuv_preview_image");
    /* access modifiers changed from: private */
    public final ImageReader.OnImageAvailableListener q = new n("third_yuv_capture_image");
    /* access modifiers changed from: private */
    public final ImageReader.OnImageAvailableListener r = new n("video_frame_image");
    /* access modifiers changed from: private */
    public final ImageReader.OnImageAvailableListener s = new n("preview_frame_image");
    /* access modifiers changed from: private */
    public final ImageReader.OnImageAvailableListener t = new n("raw_capture_image");
    /* access modifiers changed from: private */
    public final ImageReader.OnImageAvailableListener u = new n("still_capture_image");
    /* access modifiers changed from: private */
    public final ImageReader.OnImageAvailableListener v = new n("burst_capture_image");
    /* access modifiers changed from: private */
    public final ImageReader.OnImageAvailableListener w = new n("burst_capture_tuning_data");
    /* access modifiers changed from: private */
    public final ImageReader.OnImageAvailableListener x = new n("yuv_tuning_data");
    private final ImageReader.OnImageAvailableListener y = new n("raw_tuning_data");
    /* access modifiers changed from: private */
    public final ImageReader.OnImageAvailableListener z = new n("reprocess_yuv_image");

    static /* synthetic */ int M(f fVar) {
        int i2 = fVar.aT;
        fVar.aT = i2 + 1;
        return i2;
    }

    static /* synthetic */ int aN(f fVar) {
        int i2 = fVar.Z;
        fVar.Z = i2 + 1;
        return i2;
    }

    /* access modifiers changed from: private */
    public void aZ() {
        if (!this.as) {
            this.dN.removeMessages(20);
            if (this.bO != null) {
                this.bO.runOnUiThread(new Runnable() {
                    public void run() {
                        if (!(f.this.cI == null || f.this.cc == null)) {
                            f.this.cc.a(f.this.cI, 2);
                        }
                        if (f.this.cJ != null) {
                            f.this.cJ.clear();
                            CopyOnWriteArrayList unused = f.this.cJ = null;
                        }
                        com.oppo.camera.ui.control.e unused2 = f.this.cI = null;
                    }
                });
            }
        }
    }

    public void a() {
        e.a("CameraManager", "onStop");
        if (this.cj != null) {
            this.cj.l(false);
            this.cj.ae();
        }
        bM();
        p(1);
        if (this.cc != null) {
            this.cc.aK();
        }
        if (this.cH.y() == 2) {
            ci();
        }
        if (this.bj && !this.bl) {
            try {
                Thread.sleep(50);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void a(String str) {
        if (this.cc != null) {
            this.cc.w(str);
        }
    }

    /* compiled from: CameraManager */
    class n implements ImageReader.OnImageAvailableListener {

        /* renamed from: b  reason: collision with root package name */
        private String f3079b = "";
        private long c = 0;

        n(String str) {
            this.f3079b = str;
        }

        /* JADX WARNING: Can't fix incorrect switch cases order */
        /* JADX WARNING: Code restructure failed: missing block: B:151:0x03ff, code lost:
            if ("main_yuv_capture_image".equals(r0.f3079b) != false) goto L_0x0447;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:153:0x0407, code lost:
            if ("sub_yuv_capture_image".equals(r0.f3079b) != false) goto L_0x0447;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:155:0x040f, code lost:
            if ("third_yuv_capture_image".equals(r0.f3079b) != false) goto L_0x0447;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:157:0x0417, code lost:
            if ("raw_capture_image".equals(r0.f3079b) != false) goto L_0x0447;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:159:0x041f, code lost:
            if ("burst_capture_image".equals(r0.f3079b) != false) goto L_0x0447;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:161:0x0427, code lost:
            if ("burst_capture_tuning_data".equals(r0.f3079b) != false) goto L_0x0447;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:163:0x0431, code lost:
            if (r20.equals(r0.f3079b) != false) goto L_0x0447;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:165:0x043b, code lost:
            if (r19.equals(r0.f3079b) != false) goto L_0x0447;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:167:0x0445, code lost:
            if (r18.equals(r0.f3079b) == false) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:168:0x0447, code lost:
            com.oppo.camera.e.b("captureX onImageAvailable X" + r0.f3079b);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:169:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:170:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:78:0x013e, code lost:
            r20 = "yuv_tuning_data";
            r19 = "raw_tuning_data";
            r18 = "reprocess_yuv_image";
         */
        /* JADX WARNING: Code restructure failed: missing block: B:87:0x01dd, code lost:
            r20 = "yuv_tuning_data";
            r19 = "raw_tuning_data";
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onImageAvailable(android.media.ImageReader r28) {
            /*
                r27 = this;
                r0 = r27
                r2 = r28
                java.lang.String r1 = r0.f3079b
                java.lang.String r7 = "main_yuv_capture_image"
                boolean r1 = r7.equals(r1)
                java.lang.String r8 = "yuv_tuning_data"
                java.lang.String r9 = "raw_tuning_data"
                java.lang.String r10 = "burst_capture_image"
                java.lang.String r11 = "reprocess_yuv_image"
                java.lang.String r12 = "raw_capture_image"
                java.lang.String r13 = "third_yuv_capture_image"
                java.lang.String r14 = "sub_yuv_capture_image"
                java.lang.String r15 = "burst_capture_tuning_data"
                if (r1 != 0) goto L_0x005e
                java.lang.String r1 = r0.f3079b
                boolean r1 = r14.equals(r1)
                if (r1 != 0) goto L_0x005e
                java.lang.String r1 = r0.f3079b
                boolean r1 = r13.equals(r1)
                if (r1 != 0) goto L_0x005e
                java.lang.String r1 = r0.f3079b
                boolean r1 = r12.equals(r1)
                if (r1 != 0) goto L_0x005e
                java.lang.String r1 = r0.f3079b
                boolean r1 = r10.equals(r1)
                if (r1 != 0) goto L_0x005e
                java.lang.String r1 = r0.f3079b
                boolean r1 = r15.equals(r1)
                if (r1 != 0) goto L_0x005e
                java.lang.String r1 = r0.f3079b
                boolean r1 = r8.equals(r1)
                if (r1 != 0) goto L_0x005e
                java.lang.String r1 = r0.f3079b
                boolean r1 = r9.equals(r1)
                if (r1 != 0) goto L_0x005e
                java.lang.String r1 = r0.f3079b
                boolean r1 = r11.equals(r1)
                if (r1 == 0) goto L_0x0074
            L_0x005e:
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r3 = "captureX onImageAvailable E"
                r1.append(r3)
                java.lang.String r3 = r0.f3079b
                r1.append(r3)
                java.lang.String r1 = r1.toString()
                com.oppo.camera.e.a((java.lang.String) r1)
            L_0x0074:
                java.lang.String r1 = r0.f3079b
                int r4 = r1.hashCode()
                r5 = 0
                r6 = 3
                r3 = 2
                switch(r4) {
                    case -2097157301: goto L_0x012d;
                    case -789138624: goto L_0x0123;
                    case -612668507: goto L_0x011b;
                    case -527421933: goto L_0x0112;
                    case -476771773: goto L_0x0109;
                    case -418961956: goto L_0x0100;
                    case -142445365: goto L_0x00f5;
                    case -41128327: goto L_0x00eb;
                    case 212076050: goto L_0x00e1;
                    case 809009214: goto L_0x00d9;
                    case 815934813: goto L_0x00cf;
                    case 983614021: goto L_0x00c4;
                    case 1508629727: goto L_0x00b8;
                    case 1551027983: goto L_0x00ae;
                    case 1557019511: goto L_0x00a5;
                    case 1561716452: goto L_0x0099;
                    case 2076798395: goto L_0x008d;
                    case 2084150951: goto L_0x0082;
                    default: goto L_0x0080;
                }
            L_0x0080:
                goto L_0x0136
            L_0x0082:
                java.lang.String r4 = "third_yuv_preview_image"
                boolean r1 = r1.equals(r4)
                if (r1 == 0) goto L_0x0136
                r1 = 4
                goto L_0x0137
            L_0x008d:
                java.lang.String r4 = "yuv_capture_mfnr"
                boolean r1 = r1.equals(r4)
                if (r1 == 0) goto L_0x0136
                r1 = 17
                goto L_0x0137
            L_0x0099:
                java.lang.String r4 = "multi_main_preview_image"
                boolean r1 = r1.equals(r4)
                if (r1 == 0) goto L_0x0136
                r1 = 14
                goto L_0x0137
            L_0x00a5:
                boolean r1 = r1.equals(r7)
                if (r1 == 0) goto L_0x0136
                r1 = 1
                goto L_0x0137
            L_0x00ae:
                boolean r1 = r1.equals(r8)
                if (r1 == 0) goto L_0x0136
                r1 = 12
                goto L_0x0137
            L_0x00b8:
                java.lang.String r4 = "multi_sub_preview_image"
                boolean r1 = r1.equals(r4)
                if (r1 == 0) goto L_0x0136
                r1 = 15
                goto L_0x0137
            L_0x00c4:
                java.lang.String r4 = "video_frame_image"
                boolean r1 = r1.equals(r4)
                if (r1 == 0) goto L_0x0136
                r1 = 6
                goto L_0x0137
            L_0x00cf:
                boolean r1 = r1.equals(r9)
                if (r1 == 0) goto L_0x0136
                r1 = 13
                goto L_0x0137
            L_0x00d9:
                boolean r1 = r1.equals(r14)
                if (r1 == 0) goto L_0x0136
                r1 = r6
                goto L_0x0137
            L_0x00e1:
                java.lang.String r4 = "preview_frame_image"
                boolean r1 = r1.equals(r4)
                if (r1 == 0) goto L_0x0136
                r1 = 7
                goto L_0x0137
            L_0x00eb:
                java.lang.String r4 = "main_yuv_preview_image"
                boolean r1 = r1.equals(r4)
                if (r1 == 0) goto L_0x0136
                r1 = r5
                goto L_0x0137
            L_0x00f5:
                java.lang.String r4 = "still_capture_image"
                boolean r1 = r1.equals(r4)
                if (r1 == 0) goto L_0x0136
                r1 = 10
                goto L_0x0137
            L_0x0100:
                boolean r1 = r1.equals(r15)
                if (r1 == 0) goto L_0x0136
                r1 = 11
                goto L_0x0137
            L_0x0109:
                boolean r1 = r1.equals(r10)
                if (r1 == 0) goto L_0x0136
                r1 = 9
                goto L_0x0137
            L_0x0112:
                boolean r1 = r1.equals(r11)
                if (r1 == 0) goto L_0x0136
                r1 = 16
                goto L_0x0137
            L_0x011b:
                boolean r1 = r1.equals(r13)
                if (r1 == 0) goto L_0x0136
                r1 = 5
                goto L_0x0137
            L_0x0123:
                java.lang.String r4 = "sub_yuv_preview_image"
                boolean r1 = r1.equals(r4)
                if (r1 == 0) goto L_0x0136
                r1 = r3
                goto L_0x0137
            L_0x012d:
                boolean r1 = r1.equals(r12)
                if (r1 == 0) goto L_0x0136
                r1 = 8
                goto L_0x0137
            L_0x0136:
                r1 = -1
            L_0x0137:
                java.lang.String r16 = "com.oplus.capture.with.detach"
                java.lang.String r4 = "CameraManager"
                switch(r1) {
                    case 0: goto L_0x03ea;
                    case 1: goto L_0x03b7;
                    case 2: goto L_0x03a4;
                    case 3: goto L_0x036e;
                    case 4: goto L_0x0361;
                    case 5: goto L_0x0331;
                    case 6: goto L_0x0315;
                    case 7: goto L_0x02d6;
                    case 8: goto L_0x0285;
                    case 9: goto L_0x027a;
                    case 10: goto L_0x0250;
                    case 11: goto L_0x01e3;
                    case 12: goto L_0x01e3;
                    case 13: goto L_0x01e3;
                    case 14: goto L_0x01cd;
                    case 15: goto L_0x01bd;
                    case 16: goto L_0x0184;
                    case 17: goto L_0x0146;
                    default: goto L_0x013e;
                }
            L_0x013e:
                r20 = r8
                r19 = r9
                r18 = r11
                goto L_0x03f9
            L_0x0146:
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r3 = "LocalImageAvailableListener, onImageAvailable, mType: "
                r1.append(r3)
                java.lang.String r3 = r0.f3079b
                r1.append(r3)
                java.lang.String r1 = r1.toString()
                com.oppo.camera.e.b(r4, r1)
                boolean r1 = com.oppo.camera.aps.config.CameraConfig.getConfigBooleanValue(r16)
                android.media.Image r20 = r28.acquireNextImage()
                com.oppo.camera.aps.adapter.ApsResult$ImageBuffer r3 = new com.oppo.camera.aps.adapter.ApsResult$ImageBuffer
                if (r1 == 0) goto L_0x016b
                r19 = r2
                goto L_0x016d
            L_0x016b:
                r19 = 0
            L_0x016d:
                android.hardware.HardwareBuffer r21 = r20.getHardwareBuffer()
                long r22 = r20.getTimestamp()
                r18 = r3
                r18.<init>(r19, r20, r21, r22)
                com.oppo.camera.f r1 = com.oppo.camera.f.this
                boolean r2 = r1.ao
                r1.a((com.oppo.camera.aps.adapter.ApsResult.ImageBuffer) r3, (int) r2)
                goto L_0x013e
            L_0x0184:
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r3 = "LocalImageAvailableListener, onImageAvailable, mType: "
                r1.append(r3)
                java.lang.String r3 = r0.f3079b
                r1.append(r3)
                java.lang.String r1 = r1.toString()
                com.oppo.camera.e.b(r4, r1)
                android.media.Image r3 = r28.acquireNextImage()
                com.oppo.camera.aps.adapter.ApsResult$ImageBuffer r5 = new com.oppo.camera.aps.adapter.ApsResult$ImageBuffer
                android.hardware.HardwareBuffer r4 = r3.getHardwareBuffer()
                long r16 = r3.getTimestamp()
                r1 = r5
                r2 = r28
                r18 = r11
                r11 = r5
                r5 = r16
                r1.<init>(r2, r3, r4, r5)
                com.oppo.camera.f r1 = com.oppo.camera.f.this
                boolean r2 = r1.ao
                r1.a((com.oppo.camera.aps.adapter.ApsResult.ImageBuffer) r11, (int) r2)
                goto L_0x01dd
            L_0x01bd:
                r18 = r11
                com.oppo.camera.f r1 = com.oppo.camera.f.this
                com.oppo.camera.ui.g r1 = r1.cc
                com.oppo.camera.ui.preview.e r1 = r1.c()
                r1.a((android.media.ImageReader) r2, (int) r3)
                goto L_0x01dd
            L_0x01cd:
                r18 = r11
                com.oppo.camera.f r1 = com.oppo.camera.f.this
                com.oppo.camera.ui.g r1 = r1.cc
                com.oppo.camera.ui.preview.e r1 = r1.c()
                r3 = 1
                r1.a((android.media.ImageReader) r2, (int) r3)
            L_0x01dd:
                r20 = r8
                r19 = r9
                goto L_0x03f9
            L_0x01e3:
                r18 = r11
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r3 = "LocalImageAvailableListener, onImageAvailable, mType: "
                r1.append(r3)
                java.lang.String r3 = r0.f3079b
                r1.append(r3)
                java.lang.String r1 = r1.toString()
                com.oppo.camera.e.b(r4, r1)
                boolean r1 = com.oppo.camera.aps.config.CameraConfig.getConfigBooleanValue(r16)
                if (r1 == 0) goto L_0x0206
                java.lang.String r1 = r0.f3079b
                if (r15 == r1) goto L_0x0206
                r5 = 1
            L_0x0206:
                android.media.Image r21 = r28.acquireNextImage()
                com.oppo.camera.aps.adapter.ApsResult$ImageBuffer r1 = new com.oppo.camera.aps.adapter.ApsResult$ImageBuffer
                if (r5 == 0) goto L_0x0211
                r20 = r2
                goto L_0x0213
            L_0x0211:
                r20 = 0
            L_0x0213:
                android.hardware.HardwareBuffer r22 = r21.getHardwareBuffer()
                long r23 = r21.getTimestamp()
                r19 = r1
                r19.<init>(r20, r21, r22, r23)
                com.oppo.camera.aps.adapter.ImageCategory$TuningItemInfo r2 = new com.oppo.camera.aps.adapter.ImageCategory$TuningItemInfo
                r2.<init>()
                r2.mTuningBuffer = r1
                com.oppo.camera.aps.adapter.ApsParameters$Key r3 = com.oppo.camera.aps.constant.ParameterKeys.KEY_IMAGE_ROLE
                r4 = 4
                java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
                r2.setParameter(r3, r4)
                com.oppo.camera.aps.adapter.ApsParameters$Key r3 = com.oppo.camera.aps.constant.ParameterKeys.KEY_TIME_STAMP
                long r4 = r1.getTimestamp()
                java.lang.Long r1 = java.lang.Long.valueOf(r4)
                r2.setParameter(r3, r1)
                com.oppo.camera.f r1 = com.oppo.camera.f.this
                com.oppo.camera.aps.service.ApsService r1 = r1.de
                if (r1 == 0) goto L_0x01dd
                com.oppo.camera.f r1 = com.oppo.camera.f.this
                com.oppo.camera.aps.service.ApsService r1 = r1.de
                r1.addTuningInfo(r2)
                goto L_0x01dd
            L_0x0250:
                r18 = r11
                java.lang.String r1 = "LocalImageAvailableListener, onImageAvailable, mType: still_capture_image"
                com.oppo.camera.e.b(r4, r1)
                android.media.Image r3 = r28.acquireNextImage()
                com.oppo.camera.f r11 = com.oppo.camera.f.this
                com.oppo.camera.aps.adapter.ApsResult$ImageBuffer r6 = new com.oppo.camera.aps.adapter.ApsResult$ImageBuffer
                android.hardware.HardwareBuffer r4 = r3.getHardwareBuffer()
                long r16 = r3.getTimestamp()
                r1 = r6
                r2 = r28
                r20 = r8
                r19 = r9
                r8 = r5
                r9 = r6
                r5 = r16
                r1.<init>(r2, r3, r4, r5)
                r11.a((com.oppo.camera.aps.adapter.ApsResult.ImageBuffer) r9, (int) r8)
                goto L_0x03f9
            L_0x027a:
                r20 = r8
                r19 = r9
                r18 = r11
                r27.a(r28)
                goto L_0x03f9
            L_0x0285:
                r20 = r8
                r19 = r9
                r18 = r11
                java.lang.String r1 = "LocalImageAvailableListener, onImageAvailable, mType: raw_capture_image"
                com.oppo.camera.e.b(r4, r1)
                com.oppo.camera.f r1 = com.oppo.camera.f.this
                com.oppo.camera.e.o r1 = r1.cj
                if (r1 == 0) goto L_0x03f9
                com.oppo.camera.f r1 = com.oppo.camera.f.this
                com.oppo.camera.e.o r1 = r1.cj
                r1.a((android.media.ImageReader) r2)
                com.oppo.camera.f r1 = com.oppo.camera.f.this
                com.oppo.camera.e.o r1 = r1.cj
                boolean r1 = r1.cf()
                if (r1 != 0) goto L_0x03f9
                boolean r1 = com.oppo.camera.aps.config.CameraConfig.getConfigBooleanValue(r16)
                android.media.Image r23 = r28.acquireNextImage()
                com.oppo.camera.aps.adapter.ApsResult$ImageBuffer r3 = new com.oppo.camera.aps.adapter.ApsResult$ImageBuffer
                if (r1 == 0) goto L_0x02bc
                r22 = r2
                goto L_0x02be
            L_0x02bc:
                r22 = 0
            L_0x02be:
                android.hardware.HardwareBuffer r24 = r23.getHardwareBuffer()
                long r25 = r23.getTimestamp()
                r21 = r3
                r21.<init>(r22, r23, r24, r25)
                com.oppo.camera.f r1 = com.oppo.camera.f.this
                boolean r2 = r1.ao
                r1.a((com.oppo.camera.aps.adapter.ApsResult.ImageBuffer) r3, (int) r2)
                goto L_0x03f9
            L_0x02d6:
                r20 = r8
                r19 = r9
                r18 = r11
                android.media.Image r1 = r28.acquireNextImage()
                if (r1 != 0) goto L_0x02e8
                java.lang.String r1 = "mPreviewFrameImageAvailableListener, image is null"
                com.oppo.camera.e.e(r4, r1)
                return
            L_0x02e8:
                com.oppo.camera.f r2 = com.oppo.camera.f.this
                boolean r2 = r2.as
                if (r2 == 0) goto L_0x02f9
                java.lang.String r2 = "mPreviewFrameImageAvailableListener, mbPaused so return"
                com.oppo.camera.e.e(r4, r2)
                r1.close()
                return
            L_0x02f9:
                int r2 = com.oppo.camera.aps.config.AlgoSwitchConfig.getApsVersion()
                if (r3 != r2) goto L_0x0304
                com.oppo.camera.f r2 = com.oppo.camera.f.this
                r2.a((android.media.Image) r1)
            L_0x0304:
                com.oppo.camera.f r2 = com.oppo.camera.f.this
                com.oppo.camera.e.o r2 = r2.cj
                boolean r2 = r2.a((android.media.Image) r1)
                if (r2 == 0) goto L_0x03f9
                r1.close()
                goto L_0x03f9
            L_0x0315:
                r20 = r8
                r19 = r9
                r18 = r11
                long r3 = r0.c
                r5 = 1
                long r3 = r3 + r5
                r0.c = r3
                com.oppo.camera.f r1 = com.oppo.camera.f.this
                r3 = 100
                com.oppo.camera.aps.adapter.ImageCategory$ItemInfoType r4 = com.oppo.camera.aps.adapter.ImageCategory.ItemInfoType.VIDEO
                long r5 = r0.c
                r2 = r28
                r1.a((android.media.ImageReader) r2, (int) r3, (com.oppo.camera.aps.adapter.ImageCategory.ItemInfoType) r4, (long) r5)
                goto L_0x03f9
            L_0x0331:
                r20 = r8
                r19 = r9
                r18 = r11
                java.lang.String r1 = "LocalImageAvailableListener, onImageAvailable, mType: third_yuv_capture_image"
                com.oppo.camera.e.b(r4, r1)
                boolean r1 = com.oppo.camera.aps.config.CameraConfig.getConfigBooleanValue(r16)
                android.media.Image r23 = r28.acquireNextImage()
                com.oppo.camera.aps.adapter.ApsResult$ImageBuffer r3 = new com.oppo.camera.aps.adapter.ApsResult$ImageBuffer
                if (r1 == 0) goto L_0x034b
                r22 = r2
                goto L_0x034d
            L_0x034b:
                r22 = 0
            L_0x034d:
                android.hardware.HardwareBuffer r24 = r23.getHardwareBuffer()
                long r25 = r23.getTimestamp()
                r21 = r3
                r21.<init>(r22, r23, r24, r25)
                com.oppo.camera.f r1 = com.oppo.camera.f.this
                r1.a((com.oppo.camera.aps.adapter.ApsResult.ImageBuffer) r3, (int) r6)
                goto L_0x03f9
            L_0x0361:
                r20 = r8
                r19 = r9
                r18 = r11
                com.oppo.camera.f r1 = com.oppo.camera.f.this
                r1.a((android.media.ImageReader) r2, (int) r6)
                goto L_0x03f9
            L_0x036e:
                r20 = r8
                r19 = r9
                r18 = r11
                java.lang.String r1 = "LocalImageAvailableListener, onImageAvailable, mType: sub_yuv_capture_image"
                com.oppo.camera.e.b(r4, r1)
                boolean r1 = com.oppo.camera.aps.config.CameraConfig.getConfigBooleanValue(r16)
                android.media.Image r23 = r28.acquireNextImage()
                com.oppo.camera.aps.adapter.ApsResult$ImageBuffer r4 = new com.oppo.camera.aps.adapter.ApsResult$ImageBuffer
                if (r1 == 0) goto L_0x0388
                r22 = r2
                goto L_0x038a
            L_0x0388:
                r22 = 0
            L_0x038a:
                android.hardware.HardwareBuffer r24 = r23.getHardwareBuffer()
                long r25 = r23.getTimestamp()
                r21 = r4
                r21.<init>(r22, r23, r24, r25)
                com.oppo.camera.f r1 = com.oppo.camera.f.this
                boolean r2 = r1.ao
                if (r2 == 0) goto L_0x03a0
                r3 = 5
            L_0x03a0:
                r1.a((com.oppo.camera.aps.adapter.ApsResult.ImageBuffer) r4, (int) r3)
                goto L_0x03f9
            L_0x03a4:
                r20 = r8
                r19 = r9
                r18 = r11
                com.oppo.camera.f r1 = com.oppo.camera.f.this
                boolean r4 = r1.ao
                if (r4 == 0) goto L_0x03b3
                r3 = 5
            L_0x03b3:
                r1.a((android.media.ImageReader) r2, (int) r3)
                goto L_0x03f9
            L_0x03b7:
                r20 = r8
                r19 = r9
                r18 = r11
                java.lang.String r1 = "LocalImageAvailableListener, onImageAvailable, mType: main_yuv_capture_image"
                com.oppo.camera.e.b(r4, r1)
                boolean r1 = com.oppo.camera.aps.config.CameraConfig.getConfigBooleanValue(r16)
                android.media.Image r23 = r28.acquireNextImage()
                com.oppo.camera.aps.adapter.ApsResult$ImageBuffer r3 = new com.oppo.camera.aps.adapter.ApsResult$ImageBuffer
                if (r1 == 0) goto L_0x03d1
                r22 = r2
                goto L_0x03d3
            L_0x03d1:
                r22 = 0
            L_0x03d3:
                android.hardware.HardwareBuffer r24 = r23.getHardwareBuffer()
                long r25 = r23.getTimestamp()
                r21 = r3
                r21.<init>(r22, r23, r24, r25)
                com.oppo.camera.f r1 = com.oppo.camera.f.this
                boolean r2 = r1.ao
                r1.a((com.oppo.camera.aps.adapter.ApsResult.ImageBuffer) r3, (int) r2)
                goto L_0x03f9
            L_0x03ea:
                r20 = r8
                r19 = r9
                r18 = r11
                com.oppo.camera.f r1 = com.oppo.camera.f.this
                boolean r3 = r1.ao
                r1.a((android.media.ImageReader) r2, (int) r3)
            L_0x03f9:
                java.lang.String r1 = r0.f3079b
                boolean r1 = r7.equals(r1)
                if (r1 != 0) goto L_0x0447
                java.lang.String r1 = r0.f3079b
                boolean r1 = r14.equals(r1)
                if (r1 != 0) goto L_0x0447
                java.lang.String r1 = r0.f3079b
                boolean r1 = r13.equals(r1)
                if (r1 != 0) goto L_0x0447
                java.lang.String r1 = r0.f3079b
                boolean r1 = r12.equals(r1)
                if (r1 != 0) goto L_0x0447
                java.lang.String r1 = r0.f3079b
                boolean r1 = r10.equals(r1)
                if (r1 != 0) goto L_0x0447
                java.lang.String r1 = r0.f3079b
                boolean r1 = r15.equals(r1)
                if (r1 != 0) goto L_0x0447
                java.lang.String r1 = r0.f3079b
                r2 = r20
                boolean r1 = r2.equals(r1)
                if (r1 != 0) goto L_0x0447
                java.lang.String r1 = r0.f3079b
                r2 = r19
                boolean r1 = r2.equals(r1)
                if (r1 != 0) goto L_0x0447
                java.lang.String r1 = r0.f3079b
                r2 = r18
                boolean r1 = r2.equals(r1)
                if (r1 == 0) goto L_0x045d
            L_0x0447:
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "captureX onImageAvailable X"
                r1.append(r2)
                java.lang.String r2 = r0.f3079b
                r1.append(r2)
                java.lang.String r1 = r1.toString()
                com.oppo.camera.e.b(r1)
            L_0x045d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.f.n.onImageAvailable(android.media.ImageReader):void");
        }

        private void a(ImageReader imageReader) {
            e.a("CameraManager", "onBurstCaptureImageReceived, mReceiveBurstPictureCount: " + f.this.aT + ", mbBurstShot: " + f.this.aG);
            f.M(f.this);
            long currentTimeMillis = System.currentTimeMillis();
            Image acquireNextImage = imageReader.acquireNextImage();
            int width = acquireNextImage.getWidth();
            int height = acquireNextImage.getHeight();
            int format = acquireNextImage.getFormat();
            ImageCategory.ImageItemInfo imageItemInfo = new ImageCategory.ImageItemInfo();
            imageItemInfo.mApsServiceListener = f.this.df;
            imageItemInfo.mImageBuffer = new ApsResult.ImageBuffer((ImageReader) null, acquireNextImage, acquireNextImage.getHardwareBuffer(), acquireNextImage.getTimestamp());
            imageItemInfo.setParameter(ParameterKeys.KEY_IMAGE_FORMAT, Integer.valueOf(acquireNextImage.getFormat()));
            imageItemInfo.setParameter(ParameterKeys.KEY_TIME_STAMP, Long.valueOf(acquireNextImage.getTimestamp()));
            if (2 == f.this.aT && !f.this.aG) {
                e.b("CameraManager", "onImageAvailable, don't update first picture if just burstshot one picture");
                com.oppo.camera.ui.control.e unused = f.this.cI = null;
            }
            if (f.this.aG) {
                f fVar = f.this;
                int unused2 = fVar.aU = fVar.aT;
                imageItemInfo.setParameter(ParameterKeys.KEY_VALID_BURST_SHOT_IMAGE, true);
                com.oppo.camera.ui.control.e a2 = com.oppo.camera.ui.control.e.a(acquireNextImage.getHardwareBuffer(), width, height, f.this.bO.getResources().getDimensionPixelSize(R.dimen.thumbnail_width_nomal), f.this.F);
                if (1 == f.this.aT) {
                    com.oppo.camera.ui.control.e unused3 = f.this.cI = a2;
                    if (f.this.cJ == null) {
                        CopyOnWriteArrayList unused4 = f.this.cJ = new CopyOnWriteArrayList();
                    } else {
                        f.this.cJ.clear();
                    }
                }
                if (f.this.cJ != null) {
                    f.this.cJ.add(a2);
                }
                if (1 == f.this.aT) {
                    f.this.dN.removeMessages(20);
                    f.this.dN.sendEmptyMessage(20);
                }
                if (f.this.cj != null) {
                    f.this.cj.a((byte[]) null, width, height, format, true);
                }
                if (f.this.aT > 1) {
                    f.this.a(((Long) imageItemInfo.get(ParameterKeys.KEY_TIME_STAMP)).longValue(), Util.a(f.this.cj.cX(), true), false);
                }
            } else {
                f.this.aZ();
            }
            imageItemInfo.setParameter(ParameterKeys.KEY_IMAGE_WIDTH, Integer.valueOf(width));
            imageItemInfo.setParameter(ParameterKeys.KEY_IMAGE_HEIGHT, Integer.valueOf(height));
            imageItemInfo.setParameter(ParameterKeys.KEY_ORIENTATION, Integer.valueOf(f.this.F));
            imageItemInfo.setParameter(ParameterKeys.KEY_BURST_SHOT, true);
            imageItemInfo.setParameter(ParameterKeys.KEY_BURST_SHOT_FLAG_ID, Long.valueOf(f.this.aV));
            imageItemInfo.setParameter(ParameterKeys.KEY_CSHOT_PATH, f.this.aW);
            imageItemInfo.setParameter(ParameterKeys.KEY_REC_BURST_NUMBER, Integer.valueOf(f.this.aT));
            imageItemInfo.setParameter(ParameterKeys.KEY_DATE, Long.valueOf(currentTimeMillis));
            imageItemInfo.setParameter(ParameterKeys.KEY_ITEM_INFO_TYPE, ImageCategory.ItemInfoType.CAPTURE);
            if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_BURST_SHOT_CACHE_SUPPORT)) {
                f.this.dj.add(imageItemInfo);
            } else if (f.this.de != null) {
                f.this.de.addCaptureImageInfo(imageItemInfo);
            }
            int v = f.this.bR.v();
            if (f.this.aT >= Util.d || (!Util.p() && !f.this.aG && f.this.aT >= v)) {
                f.this.ba();
            }
        }
    }

    /* access modifiers changed from: private */
    public void ba() {
        e.a("CameraManager", "resetBurstShot");
        this.bR.w();
        if (this.cj != null) {
            this.cj.d(false);
        }
        this.aW = "";
        this.aV = -1;
        if (this.cj != null) {
            this.cj.ca();
        }
        aZ();
        if (this.cj != null) {
            this.cj.l(false);
        }
        if (this.de != null && CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_BURST_SHOT_CACHE_SUPPORT)) {
            for (ImageCategory.ImageItemInfo addCaptureImageInfo : this.dj) {
                this.de.addCaptureImageInfo(addCaptureImageInfo);
            }
            this.dj.clear();
        }
    }

    /* access modifiers changed from: private */
    public void a(ImageReader imageReader, int i2) {
        Image a2 = Util.a(imageReader);
        boolean a3 = Util.a(imageReader, imageReader.getMaxImages());
        if (a2 == null) {
            e.e("CameraManager", "onPreviewFrameReceived, image is null");
        } else if (this.as || a3) {
            e.e("CameraManager", "onPreviewFrameReceived, mbPaused: " + this.as + ", flow: " + a3);
            a2.close();
        } else {
            this.ct.onPreview();
            if (i2 == 0 || 1 == i2) {
                a(a2);
            }
            if (3 == AlgoSwitchConfig.getApsVersion()) {
                a(imageReader, a2, i2, ImageCategory.ItemInfoType.PREVIEW);
            } else {
                a2.close();
            }
        }
    }

    /* access modifiers changed from: private */
    public void a(Image image) {
        boolean z2;
        boolean z3;
        if (this.aC || this.aA || this.aD || this.cj == null || T()) {
            e.b("CameraManager", "onPreviewFrameReceived, state changing, mbSwitchingCamera: " + this.aA + ", mbCaptureModeChanging: " + this.aC + ", mbSizeChanging: " + this.aD + ", isPreviewStopped: " + T());
            return;
        }
        e.a("onPreviewFrameReceived");
        boolean o2 = o();
        boolean i2 = this.cj.i(CameraFunction.FACE_BLUR);
        boolean at2 = this.cj.at();
        boolean z4 = false;
        boolean z5 = this.cj.bG() && this.cj.i(CameraFunction.SUPER_TEXT_CPU_PROCESS);
        boolean au2 = this.cj.au();
        v vVar = this.cN;
        boolean z6 = vVar != null && !vVar.k() && m();
        if (z5) {
            long j2 = this.dv;
            z2 = au2;
            this.dv = j2 + 1;
            if (0 == j2 % 3 && !t.b()) {
                z4 = true;
            } else if (t.b()) {
                this.cc.a((com.oppo.camera.t.a) null);
            }
        } else {
            z2 = au2;
        }
        if (o2 || i2 || at2 || z4 || z2 || z6) {
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(((image.getWidth() * image.getHeight()) * 3) / 2);
            if (!Util.nativeGetYuvDataWithoutPadding(image.getHardwareBuffer(), allocateDirect, 17)) {
                e.e("CameraManager", "onPreviewFrameReceived, nativeGetYuvDataWithoutPadding failed");
                return;
            }
            byte[] array = allocateDirect.array();
            if (Util.c()) {
                Util.a(array, "preview_yuv", "yuv_" + image.getTimestamp() + ".yuv");
                StringBuilder sb = new StringBuilder();
                sb.append("onPreviewFrameReceived, image.size: ");
                sb.append(image.getWidth());
                sb.append("x");
                sb.append(image.getHeight());
                sb.append(", format: ");
                sb.append(image.getFormat());
                sb.append(", bytes.size: ");
                sb.append(array.length);
                sb.append(", file: yuv_");
                z3 = z4;
                sb.append(image.getTimestamp());
                sb.append(".yuv");
                e.a("CameraManager", sb.toString());
            } else {
                z3 = z4;
            }
            long uptimeMillis = SystemClock.uptimeMillis();
            int i3 = 1000 / (this.ao ? 3 : 4);
            boolean z7 = z6;
            long j3 = uptimeMillis - this.ae;
            long j4 = j3 > 1000 ? 0 : j3;
            this.ak += j4;
            this.aj += j4;
            this.al += j4;
            this.an += j4;
            this.ae = uptimeMillis;
            if (o2) {
                long j5 = this.ak;
                long j6 = (long) 76;
                if (j5 >= j6) {
                    this.ak = j5 - j6;
                    this.dr.obtainMessage(1, array).sendToTarget();
                }
            }
            if (i2) {
                long j7 = this.aj;
                long j8 = (long) i3;
                if (j7 >= j8) {
                    this.aj = j7 - j8;
                    this.dr.obtainMessage(2, image.getWidth(), image.getHeight(), array).sendToTarget();
                }
            }
            if (at2) {
                long j9 = this.al;
                long j10 = (long) 33;
                if (j9 >= j10) {
                    this.al = j9 - j10;
                    this.dr.obtainMessage(3, image.getWidth(), image.getHeight(), array).sendToTarget();
                }
            }
            if (z7) {
                long j11 = this.an;
                if (j11 >= 250) {
                    this.an = j11 - 250;
                    this.dr.obtainMessage(4, image.getWidth(), image.getHeight(), array).sendToTarget();
                }
            }
            if (z3) {
                Size b2 = b(image.getWidth(), image.getHeight());
                if (this.dw == null) {
                    this.dw = new YuvUtil();
                }
                byte[] a2 = this.dw.a(array, image.getWidth(), image.getHeight(), b2.getWidth(), b2.getHeight());
                if (a2 != null) {
                    a(a2, b2.getWidth(), b2.getHeight(), image.getTimestamp());
                }
            }
            if (z2) {
                if (this.dw == null) {
                    this.dw = new YuvUtil();
                }
                byte[] a3 = this.dw.a(array, image.getWidth(), image.getHeight(), image.getWidth() / 3, image.getHeight() / 3);
                if (this.cj != null) {
                    this.cj.a(a3);
                }
            }
        }
        e.b("onPreviewFrameReceived");
    }

    private Size b(int i2, int i3) {
        if (i2 >= i3) {
            int i4 = (i2 * 384) / i3;
            if (i4 % 2 != 0) {
                i4++;
            }
            return new Size(i4, 384);
        }
        int i5 = (i3 * 384) / i2;
        if (i5 % 2 != 0) {
            i5++;
        }
        return new Size(384, i5);
    }

    private void a(byte[] bArr, int i2, int i3, long j2) {
        if (this.ck != null) {
            this.ck.a(bArr, i2, i3, j2);
        }
    }

    public f(Activity activity, g gVar) {
        this.bO = activity;
        this.bV = gVar;
        this.cj = new com.oppo.camera.e.o(activity);
        this.ct = new QualityReport();
    }

    private void bb() {
        if (!bd()) {
            return;
        }
        if (("portrait".equals(am()) || ApsConstant.CAPTURE_MODE_COMMON.equals(am())) && this.bP.contains("pref_none_sat_ultra_wide_angle_key")) {
            this.bP.edit().putString("pref_none_sat_ultra_wide_angle_key", "off").apply();
        }
    }

    public void a(k kVar, com.oppo.camera.entry.b bVar, boolean z2) {
        e.a("CameraManager create instance");
        this.bP = kVar;
        this.cH = bVar;
        this.dx = new com.oppo.camera.u.d(this.bO.getApplicationContext(), this.bP, this.dU);
        r(this.cH.h());
        Application application = this.bO.getApplication();
        bb();
        if (application instanceof MyApplication) {
            ((MyApplication) application).e();
        }
        this.cS = new o();
        if (this.cH.d()) {
            cG();
            this.cj.s(false);
        }
        e(am());
        if (z2) {
            l(0);
        }
        bg();
        this.bQ = application.getSharedPreferences("rom_update_info", 0);
        try {
            this.D = com.heytap.compat.os.a.a((PowerManager) application.getSystemService("power"));
        } catch (com.heytap.compat.d.a.a e2) {
            e2.printStackTrace();
        }
        this.cT = new p(this.cj, this.cS);
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_SHOW_SOLOOP) || CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_SHOW_SOLOOP_SAME)) {
            this.cU = new com.oppo.camera.soloop.b(this.bO);
        }
        e.b("CameraManager create instance");
    }

    private void e(String str) {
        if ("portrait".equals(str)) {
            com.oppo.camera.ui.preview.a.g.f4385a = this.ao ? com.oppo.camera.ui.preview.a.g.i() : com.oppo.camera.ui.preview.a.g.h();
        } else if (ApsConstant.REC_MODE_COMMON.equals(str)) {
            com.oppo.camera.ui.preview.a.g.f4385a = this.ao ? com.oppo.camera.ui.preview.a.g.k() : com.oppo.camera.ui.preview.a.g.j();
        } else {
            com.oppo.camera.ui.preview.a.g.f4385a = 0;
        }
    }

    public void b() {
        e.b("CameraManager", "onScreenOffWhenLocked");
        com.oppo.camera.f.f fVar = this.bR;
        if (fVar != null) {
            fVar.a(false);
        }
        a(false, true);
        if (this.cj != null) {
            this.cj.aH();
        }
        if (this.cj != null && this.cj.aN()) {
            this.dN.removeMessages(16);
            this.dN.sendEmptyMessage(16);
        }
    }

    /* access modifiers changed from: private */
    public void o(int i2) {
        if (this.cC != null) {
            Message obtain = Message.obtain();
            obtain.what = 3;
            obtain.arg1 = i2;
            this.cC.sendMessage(obtain);
        }
    }

    /* access modifiers changed from: private */
    public void p(int i2) {
        if (this.cC != null) {
            Message obtain = Message.obtain();
            obtain.what = 4;
            obtain.arg1 = i2;
            this.cC.sendMessage(obtain);
        }
    }

    private void bc() {
        Handler handler = this.cC;
        if (handler != null) {
            handler.removeMessages(5);
            this.cC.sendEmptyMessage(5);
        }
    }

    public boolean c() {
        if (this.cm != null) {
            return this.cm.a();
        }
        return false;
    }

    /* access modifiers changed from: private */
    public boolean bd() {
        return 1 == this.cH.y();
    }

    /* access modifiers changed from: private */
    public void a(final long j2, String str, boolean z2) {
        e.b("CameraManager", "addEmptyThumbnail, identity: " + j2 + ", jpegName: " + str + ", isUpdateThumbnail: " + z2);
        if (this.cj == null) {
            e.e("CameraManager", "addEmptyThumbnail, mModeManager is null");
            return;
        }
        ThumbnailItem thumbnailItem = new ThumbnailItem();
        thumbnailItem.mUri = null;
        thumbnailItem.mResolver = this.bO.getContentResolver();
        thumbnailItem.mPictureFormat = (this.cj.bJ() == null || this.aT != 0) ? "jpeg" : this.cj.bJ();
        thumbnailItem.mThumbBitmap = null;
        thumbnailItem.mIdentity = j2;
        thumbnailItem.mProductProcessor = this.dD;
        thumbnailItem.mbLockScreen = aj();
        thumbnailItem.mJpegName = str;
        final boolean z3 = thumbnailItem.mbLockScreen;
        if (z2 || this.cj.bG() || this.cj.bH()) {
            thumbnailItem.mThumbnailWidth = this.cc.aV();
            thumbnailItem.mCameraUiUpdateThumbnail = new e.a() {
                public void a(final com.oppo.camera.ui.control.e eVar) {
                    f.this.bO.runOnUiThread(new Runnable() {
                        public void run() {
                            long dm = f.this.cj != null ? f.this.cj.dm() : 0;
                            boolean z = !z3 && f.this.aj();
                            if (f.this.cc != null && j2 >= dm && !z) {
                                f.this.cc.a(eVar);
                            }
                            if (f.this.cj != null && j2 == dm) {
                                f.this.cj.a((byte[]) null, 0, 0, 256, false);
                            }
                        }
                    });
                }
            };
        }
        ApsService apsService = this.de;
        if (apsService != null) {
            apsService.addThumbnailInfo(thumbnailItem);
        }
    }

    public void a(boolean z2) {
        e.a("CameraManager", "setCaptureThumbnailUpdated: " + this.aO + "->" + z2);
        this.aO = z2;
    }

    /* access modifiers changed from: private */
    public boolean be() {
        return 3 == this.cH.y();
    }

    /* access modifiers changed from: private */
    public void a(long j2) {
        ApsService apsService = this.de;
        if (apsService != null) {
            apsService.notifyErrorType(new ApsService.ApsFailure(2, j2));
        }
        com.oppo.camera.f.f fVar = this.bR;
        if (fVar != null) {
            fVar.b(true);
        }
    }

    /* access modifiers changed from: private */
    public o.a bf() {
        if (!this.da) {
            return null;
        }
        if (this.cu == null || !"on".equals(this.cu.f()) || !this.cu.g()) {
            return this.cy;
        }
        return this.cz;
    }

    private void bg() {
        synchronized (this.bJ) {
            if (this.cC == null) {
                this.cD = new HandlerThread("CameraHandlerThread");
                this.cD.start();
                this.cC = new Handler(this.cD.getLooper()) {
                    public void handleMessage(Message message) {
                        e.a("CameraManager", "initHandlerThread, handleMessage, what: " + message.what);
                        int i = message.what;
                        if (i == 1) {
                            f.this.bi().openCabc();
                        } else if (i == 2) {
                            f.this.bi().closeCabc();
                        } else if (i == 3) {
                            int i2 = message.arg1;
                            if (f.this.cm == null) {
                                x unused = f.this.cm = new x(MyApplication.d());
                                f.this.cm.a(f.this.dO);
                            }
                            f.this.cm.a(i2);
                        } else if (i == 4) {
                            int i3 = message.arg1;
                            if (f.this.cm != null) {
                                f.this.cm.b(i3);
                            }
                        } else if (i == 5 && f.this.cm != null) {
                            f.this.cm.b();
                            x unused2 = f.this.cm = null;
                        }
                        e.a("CameraManager", "initHandlerThread, handleMessage mWorkThreadHandler X");
                    }
                };
            }
        }
    }

    private void bh() {
        if (this.dq == null) {
            HandlerThread handlerThread = new HandlerThread("PreviewYuvThread");
            handlerThread.start();
            this.dq = new Handler(handlerThread.getLooper());
        }
        if (this.dr == null) {
            HandlerThread handlerThread2 = new HandlerThread("PreviewProcessThread");
            handlerThread2.start();
            this.dr = new Handler(handlerThread2.getLooper()) {
                public void handleMessage(Message message) {
                    e.a("CameraManager", "PreviewProcessThread, handleMessage, what: " + message.what);
                    int i = message.what;
                    if (i != 1) {
                        if (i != 2) {
                            if (i != 3) {
                                if (i == 4 && f.this.cN != null) {
                                    f.this.cN.c(f.this.br());
                                    if (f.this.br()) {
                                        f.this.cN.a((byte[]) message.obj, (Rect) null, (Size) null, message.arg1, message.arg2);
                                    }
                                }
                            } else if (f.this.cd != null) {
                                f.this.cd.a((byte[]) message.obj, message.arg1, message.arg2, 16);
                            }
                        } else if (f.this.cd != null) {
                            f.this.cd.a((byte[]) message.obj, message.arg1, message.arg2, 1);
                        }
                    } else if (f.this.cM != null) {
                        f.this.cM.a((byte[]) message.obj, f.this.K, f.this.G);
                    }
                }
            };
        }
        if (this.ds == null) {
            HandlerThread handlerThread3 = new HandlerThread("ApsPreviewCaptureResultHandler");
            handlerThread3.start();
            this.ds = new Handler(handlerThread3.getLooper()) {
                public void handleMessage(Message message) {
                    if (message.what == 1) {
                        f.this.c((ApsTotalResult) message.obj);
                    }
                }
            };
        }
        if (this.dt == null) {
            HandlerThread handlerThread4 = new HandlerThread("PreviewFrameThread");
            handlerThread4.start();
            this.dt = new Handler(handlerThread4.getLooper());
        }
    }

    /* access modifiers changed from: private */
    public CabcManager bi() {
        if (this.cA == null) {
            this.cA = CabcManager.getCabcManagerInstance();
        }
        return this.cA;
    }

    /* access modifiers changed from: private */
    public void bj() {
        Handler handler = this.cC;
        if (handler != null) {
            handler.removeMessages(2);
            this.cC.sendEmptyMessage(2);
        }
    }

    /* access modifiers changed from: private */
    public void bk() {
        Handler handler = this.cC;
        if (handler != null) {
            handler.removeMessages(1);
            this.cC.sendEmptyMessage(1);
        }
    }

    private void bl() {
        HandlerThread handlerThread = this.cD;
        if (handlerThread != null) {
            handlerThread.quitSafely();
        }
        Handler handler = this.dq;
        if (handler != null) {
            handler.getLooper().quitSafely();
            this.dq = null;
        }
        Handler handler2 = this.dr;
        if (handler2 != null) {
            handler2.getLooper().quitSafely();
            this.dr = null;
        }
        Handler handler3 = this.ds;
        if (handler3 != null) {
            handler3.getLooper().quitSafely();
            this.ds = null;
        }
        Handler handler4 = this.dt;
        if (handler4 != null) {
            handler4.getLooper().quitSafely();
            this.dt = null;
        }
    }

    public boolean d() {
        k kVar = this.dK;
        if (kVar != null) {
            return kVar.d();
        }
        return false;
    }

    private void bm() {
        Bundle extras;
        this.cb = new s(this.bO.getApplicationContext());
        this.cb.a();
        a(96, false);
        if (this.cH.y() == 2 && (extras = this.bO.getIntent().getExtras()) != null) {
            try {
                this.cE = (Uri) extras.getParcelable("output");
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            try {
                this.bB = extras.getString("crop");
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
        this.cj.h(this.bd);
    }

    public boolean a(int i2) {
        if (this.cb != null) {
            return this.cb.a(i2);
        }
        return false;
    }

    public void e() {
        if (this.bR != null && !this.aA && !this.cj.aK()) {
            this.bR.e(this.cj.P());
        }
    }

    public void a(int i2, Rect rect, Rect rect2) {
        if (this.bR != null) {
            if (aN() < 1.0f) {
                this.bR.a(new k(rect2, a.d()));
                this.bR.b(new k(rect2, a.c()));
                this.bR.a(i2, true);
            } else {
                this.bR.a(i2, rect != null ? new MeteringRectangle[]{new MeteringRectangle(rect, a.c())} : null, rect2 != null ? new MeteringRectangle[]{new MeteringRectangle(rect2, a.d())} : null, true);
            }
            this.bR.a((f.c) null);
        }
    }

    public int f() {
        com.oppo.camera.f.f fVar = this.bR;
        if (fVar != null) {
            return fVar.p();
        }
        return this.cj.P();
    }

    public void a(int i2, int i3) {
        synchronized (this.h) {
            if (this.S == null) {
                this.S = new int[2];
            }
            this.S[0] = i2;
            this.S[1] = i3;
        }
        p(bn());
    }

    private String bn() {
        int i2 = this.av;
        if (i2 == 0) {
            return "1";
        }
        if (i2 != 1) {
            return i2 != 2 ? "1" : "3";
        }
        return "7";
    }

    public void g() {
        this.dN.a(new Runnable() {
            public void run() {
                synchronized (f.this.h) {
                    int[] unused = f.this.S = null;
                }
            }
        });
    }

    public void b(int i2) {
        e.a("CameraManager", "playSound, cameraSound: " + i2);
        if (this.cb != null && "on".equals(this.bC)) {
            this.cb.b(i2);
        }
    }

    public void h() {
        if (this.bo || this.bR == null) {
            e.a("CameraManager", "initializeFirstTime, mOneCamera: " + this.bR + ", mbFirstTimeInitialized: " + this.bo);
            return;
        }
        com.oppo.camera.v.c.a().a(new Runnable() {
            public void run() {
                try {
                    f.this.cj.ar();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "initBaseModeMap");
        this.ac = this.bO.getResources().getDimensionPixelSize(R.dimen.video_tracking_focus_distance_between_two_points);
        this.P = this.bO.getResources().getDimensionPixelSize(R.dimen.switch_mode_distance_limit);
        this.Q = this.bO.getResources().getDimensionPixelSize(R.dimen.switch_mode_distance_limit_min);
        this.R = this.bO.getResources().getDimensionPixelSize(R.dimen.switch_mode_velocity_limit);
        Size a2 = this.cj.a(this.bS);
        q(Util.b(a2.getWidth(), a2.getHeight()));
        this.aq = false;
        bx();
        cu();
        com.oppo.camera.n.b.a().d();
        com.oppo.camera.n.b.a().a((d.a) new s(this));
        this.bn = true;
        this.bo = true;
    }

    public void i() {
        if (this.cc != null) {
            this.cc.cL();
        }
    }

    /* compiled from: CameraManager */
    private static class s implements d.a {

        /* renamed from: a  reason: collision with root package name */
        private WeakReference<f> f3088a = null;

        s(f fVar) {
            this.f3088a = new WeakReference<>(fVar);
        }

        public void a() {
            f fVar;
            WeakReference<f> weakReference = this.f3088a;
            if (weakReference != null && (fVar = (f) weakReference.get()) != null) {
                fVar.i();
            }
        }
    }

    public void j() {
        if (this.bR == null) {
            e.a("CameraManager", "initializeSecondTime, mOneCamera: " + this.bR);
            return;
        }
        Size a2 = this.cj.a(this.bS);
        q(Util.b(a2.getWidth(), a2.getHeight()));
        z.a(this.bO.getApplicationContext());
        this.cc.b(this.cj.f());
        this.cc.e(true, false);
        this.cc.b(this.K, this.cj.bf(), !this.cj.bk());
        this.aq = false;
        bx();
        cu();
        com.oppo.camera.n.b.a().d();
        if (this.cj.i("pref_filter_process_key")) {
            this.cj.a(this.cc.z());
        }
        this.bn = true;
    }

    public void a(boolean z2, int i2) {
        if (!this.as) {
            if (this.bg || z2) {
                this.bV.o();
                e.a("CameraManager", "notifyFirstFrame, sendBroadcast com.oppo.camera.start notifyFirstFrame");
            }
            b(false, i2);
        }
    }

    public void b(boolean z2, int i2) {
        if (this.as) {
            e.a("CameraManager", "onPreviewOk, mbPaused: " + this.as);
        } else if (z2 && !this.bi) {
            this.bi = true;
            e.e("CameraManager", "CameraTest Displayed com.oppo.camera");
            if (this.cj.ac()) {
                this.bO.runOnUiThread(new Runnable() {
                    public void run() {
                        f.this.dW.a("pref_filter_menu", false, false, false);
                    }
                });
            }
            if (!this.bg) {
                c(i2);
            }
        } else if (!this.bg) {
            s(true);
            e.a("CameraManager", "onPreviewOk, mbDisplayOnLock: " + this.bd);
            this.bV.p();
            c(i2);
        }
    }

    public void c(int i2) {
        e.a("CameraManager", "onPreviewOKMessage");
        if (this.bg) {
            e.a("CameraManager", "onPreviewOKMessage, mbPreviewOKMessageEnd is true, so return");
            return;
        }
        this.bg = true;
        bm();
        o(1);
        af();
        this.bV.n();
        if (!this.bo) {
            h();
        } else {
            j();
        }
        this.cc.bh();
        c(false, i2);
        if (aj()) {
            this.cX = false;
        }
        if (this.cj.aB()) {
            ag();
        }
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_STICKER)) {
            bo();
        }
        e.a("CameraManager", "onPreviewOKMessage X");
    }

    private void bo() {
        com.oppo.camera.ui.preview.a.l.b((Context) this.bO).a((Context) this.bO);
        boolean z2 = false;
        if (com.oppo.camera.w.b.g() || this.bP.getBoolean("pref_allow_network_access", false)) {
            z2 = true;
        }
        if (z2) {
            com.oppo.camera.ui.preview.a.l.b((Context) this.bO).f();
        }
    }

    public void c(boolean z2, int i2) {
        e.a("CameraManager", "afterStartPreview, mbFrameAvailable: " + this.bi + ", mbPaused: " + this.as + ", cameraRole: " + i2);
        if (1 == i2) {
            F(z2);
        }
        bN();
        if (!this.as) {
            int i3 = this.V;
            if ((i3 == 0 || 2 == i3) && 1 == this.cH.y() && this.cj.i("key_setting_menu")) {
                this.cc.d(1.0f);
            }
            if (!aF() || 1 == i2) {
                this.cT.a(z2);
            }
            if (this.cj.i("pref_sticker_process_key")) {
                this.cF = com.oppo.camera.ui.preview.a.l.b((Context) this.bO).a((SharedPreferences) this.bP);
            }
            this.cc.ac(cD() && !this.cc.cH());
            if (!this.aC) {
                this.cc.b(true);
                this.cc.t(true);
                v(true);
            }
            b("pref_camera_high_resolution_key", this.bP.getBoolean("key_high_picture_size", false));
            this.cc.b("pref_camera_high_resolution_key", this.bP.getBoolean("key_high_picture_size", false), true);
            if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_PI_AI)) {
                this.U = 0;
                this.cc.cv();
                this.cc.cq();
            }
            this.cc.b((int) R.string.micro_lens_mode_toast);
            bp();
            if (z2) {
                bq();
            }
        }
    }

    private void bp() {
        if (this.dW != null) {
            this.cc.a(this.cc.s(), this.dW.aG());
        }
    }

    private void bq() {
        if (this.cH.n() && this.cj.g()) {
            if (Util.a(this.bO, Camera.k) || !this.bP.getBoolean("pref_runtime_alert_first_show", true)) {
                this.dN.removeMessages(22);
                this.dN.sendEmptyMessageDelayed(22, 500);
            }
        }
    }

    public boolean k() {
        return "on".equals(this.bP.getString("pref_camera_gesture_shutter_key", this.bO.getString(R.string.camera_gesture_shutter_default_value))) && this.cj.i("pref_camera_gesture_shutter_key");
    }

    public void b(boolean z2) {
        if (z2) {
            this.cc.bM();
            this.cc.bN();
        }
        if (this.cM == null) {
            this.cM = new m();
        }
        Size a2 = this.cj.a(this.bS);
        this.cM.a(this.bO.getApplicationContext(), a2.getWidth(), a2.getHeight());
        this.cM.a(this.dG);
    }

    public void l() {
        if (this.cN == null) {
            this.cN = new v(this.bO, this.bP, this.dT, this.D);
        }
        if (this.cc != null) {
            this.cN.a(this.cc.b(), this.G);
        }
    }

    /* access modifiers changed from: private */
    public boolean br() {
        v vVar = this.cN;
        return vVar != null && !vVar.k() && this.cc != null && !this.cc.cH() && !this.cc.C() && !this.aC && S() && !this.as && !d() && !D() && !aM() && this.bi && (this.f2941co == null || !this.f2941co.d());
    }

    public boolean m() {
        return this.cj != null && this.cj.co();
    }

    public void n() {
        if (this.cM != null) {
            this.cM.close();
        }
        if (this.cc != null) {
            this.cc.b((int) R.string.camera_toast_gesture_take_picture);
            this.cc.a(true);
        }
    }

    public boolean o() {
        if (this.cM == null || !b("pref_camera_gesture_shutter_key") || !this.cM.b()) {
            return false;
        }
        return true;
    }

    public boolean p() {
        if (this.cM != null) {
            return this.cM.a();
        }
        return false;
    }

    public void q() {
        if (this.cc == null || ((!this.cc.bf() && !bd()) || this.ao)) {
            Camera.o = true;
            return;
        }
        this.cc.a((int) R.string.camera_high_temperature_flash_disable, -1, true, false, false);
        Camera.o = false;
        a(ReminderMsgData.TYPE_DISABLE_CODE, ReminderMsgData.CODE_TEMPS_FLASH);
    }

    /* access modifiers changed from: private */
    public void bs() {
        c((SharedPreferences) this.bP);
        if (b(CameraFunction.TORCH_SOFT_LIGHT)) {
            d(this.bP.b(this.bO, 1));
        }
        bu();
        q();
    }

    public boolean r() {
        if (this.cc == null || !this.cc.bf() || this.ao) {
            Camera.n = true;
            return false;
        }
        this.cc.a((int) R.string.camera_low_battery_flash_disable, -1, true, false, false);
        Camera.n = false;
        a(ReminderMsgData.TYPE_DISABLE_CODE, ReminderMsgData.CODE_BATTERY_FLASH);
        return true;
    }

    /* access modifiers changed from: private */
    public void bt() {
        c((SharedPreferences) this.bP);
        if (b(CameraFunction.TORCH_SOFT_LIGHT)) {
            d(this.bP.b(this.bO, 1));
        }
        bu();
        r();
    }

    private void bu() {
        this.cc.f("pref_camera_flashmode_key");
        this.cc.f("pref_camera_videoflashmode_key");
        if (b(CameraFunction.TORCH_SOFT_LIGHT)) {
            this.cc.f("pref_camera_torch_mode_key");
        }
    }

    public void s() {
        String str;
        e.b("CameraManager", "prepareRealTimeDcsMsgData");
        this.bG = new CaptureMsgData(this.bO.getApplicationContext());
        this.bG.mCameraEnterType = String.valueOf(this.cH.y());
        CaptureMsgData captureMsgData = this.bG;
        captureMsgData.mTouchEVValue = this.T;
        captureMsgData.mMemoryValue = String.valueOf(Util.i((Context) this.bO));
        this.bG.mPictureFps = PerformanceMsgData.getAverageFrameRate();
        this.bG.parseFaceInfo(this.bW);
        if (this.cj.i("pref_camera_torch_mode_key")) {
            CaptureMsgData captureMsgData2 = this.bG;
            if (this.cj.i(ConfigDataBase.KEY_TORCH_SOFT_LIGHT)) {
                str = "flash_light";
            } else {
                str = com.oppo.camera.ui.inverse.c.INS.isInverseAble(this.bO) ? "inverse_light" : "screen_light";
            }
            captureMsgData2.mFlashType = str;
        } else if (this.cj.i("pref_camera_flashmode_key")) {
            this.bG.mFlashType = "flash_light";
        } else {
            this.bG.mFlashType = "none";
        }
        this.bG.mIsRecordLocation = String.valueOf("on".equals(this.bP.getString("pref_camera_recordlocation_key", this.bO.getString(R.string.camera_location_default_value))));
        this.bG.mIsSDCard = String.valueOf("on".equals(this.bP.getString("pref_camera_storage_key", this.bO.getString(R.string.camera_storage_default_value))));
        this.bG.mVolumeFunction = this.bP.getString("pref_volume_key_function_key", this.bO.getString(R.string.camera_volume_key_function_default_value));
        this.bG.mIsShutterVoice = this.bP.getString("pref_camera_sound_key", this.bO.getString(R.string.camera_sound_default_value));
        this.bG.mIsGestureCaptureType = this.bP.getString("pref_camera_gesture_shutter_key", this.bO.getString(R.string.camera_gesture_shutter_default_value));
        this.bG.mIsTapCaptureType = this.bP.getString("pref_camera_tap_shutter_key", this.bO.getString(R.string.camera_tap_shutter_default_value));
        this.bG.mSpiritLevel = this.bP.getString("pref_assist_gradienter", "off");
        if (this.cj.dg()) {
            this.bG.mIsMirror = this.bP.getString("pref_mirror_key", this.bO.getString(R.string.camera_mirror_default_value));
        }
        CaptureMsgData captureMsgData3 = this.bG;
        captureMsgData3.mPreviewCaptureCostTime = this.ag;
        captureMsgData3.mBetweenClickBtnCostTime = this.ai;
        captureMsgData3.mDelayTime = this.cj.ag();
        if (Util.h("oplus.software.motor.breathled")) {
            this.bG.mSelfieLight = this.bP.getString("pref_camera_countdown_effect_key", "off");
            if (this.ao) {
                this.bG.mSelfieLightTrigger = String.valueOf(!"off".equals(this.cj.ag()) && "on".equals(this.bG.mSelfieLight) && b("pref_time_lapse_key"));
            }
        }
        this.bG.mPhotoFormat = (!"HEIF".equals(this.bP.getString("pref_photo_codec_key", "JPEG")) || this.cj.bG()) ? "JPEG" : "HEIF";
        if (this.cj.h("pref_camera_slogan_key")) {
            this.bG.mIsModelSlogan = this.bP.getString("pref_slogan_device_key", this.bO.getString(R.string.camera_slogan_default_value));
            this.bG.mIsTimeSlogan = this.bP.getString("pref_slogan_time_key", this.bO.getString(R.string.camera_slogan_default_value));
            this.bG.mIsLocationSlogan = this.bP.getString("pref_slogan_location_key", this.bO.getString(R.string.camera_slogan_default_value));
            if (this.cs != null) {
                this.bG.mSloganType = this.cs.f();
            }
        }
        if (!CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_PI_AI)) {
            if (this.cj.h("pref_camera_pi_mode_key")) {
                this.bG.mIsPi = this.bP.getString("pref_camera_pi_mode_key", "off");
            }
            if (this.cj.h("pref_ai_scene_key")) {
                this.bG.mIsAiScene = String.valueOf(this.cj.av());
            }
        } else if (this.cj.h("pref_camera_pi_ai_mode_key")) {
            this.bG.mIsPi = this.cc.G(this.U) ? "on" : "off";
            this.bG.mIsAiScene = String.valueOf(this.cj.aw());
        }
        if (this.cj.h("pref_face_rectify_key")) {
            this.bG.mIsFaceRectify = this.cj.ck() ? "on" : "off";
        }
        if (this.cj.h("pref_zoom_key")) {
            this.bG.mZoomValue = String.valueOf(aN());
        }
        if (this.cj.h("pref_camera_assistant_line_key")) {
            this.bG.mIsAssistantLine = this.bP.getString("pref_camera_line_photo", "off");
        }
        if (this.cj.h("pref_camera_flashmode_key") || this.cj.h("pref_camera_videoflashmode_key")) {
            this.bG.mFlashMode = this.cj.Q();
        } else if (this.cj.h("pref_camera_torch_mode_key")) {
            this.bG.mFlashMode = this.bP.getString("pref_camera_torch_mode_key", Util.y(this.bO));
        }
        if (this.f2941co != null && !"off".equals(this.bG.mDelayTime)) {
            this.bG.mTimerSize = this.f2941co.b();
            this.bG.mTimerCoordinate = this.f2941co.c();
        }
        if (b(CameraFunction.ID_PHOTO)) {
            synchronized (this.bI) {
                if (this.bZ == 0) {
                    this.bG.mFaceCode = "no_face";
                } else if (this.bZ > 1) {
                    this.bG.mFaceCode = "more_face";
                }
            }
        }
        com.oppo.camera.w.b.a(this.bG, this.bP.getBoolean("pref_camera_statement_agree", false), this.cu);
        this.bG = (CaptureMsgData) this.cj.a((DcsMsgData) this.bG);
        this.bG.mRearOrFront = this.ao ? DcsMsgData.FRONT : DcsMsgData.REAR;
        e.b("CameraManager", "prepareRealTimeDcsMsgData X");
    }

    public int t() {
        int i2;
        if (!B()) {
            return 0;
        }
        synchronized (this.bI) {
            i2 = this.bZ;
        }
        return i2;
    }

    public void a(Face[] faceArr, int[] iArr) {
        synchronized (this.bI) {
            this.bW = faceArr;
            if (!b("key_support_front_face_point_animation")) {
                iArr = null;
            }
            this.bX = iArr;
            this.bZ = this.bW != null ? this.bW.length : 0;
            if (this.cd != null && B()) {
                this.cd.b(this.bW != null ? this.bZ : -1);
            }
        }
    }

    public void a(int[] iArr) {
        synchronized (this.bK) {
            if (this.au) {
                this.bY = iArr;
            }
        }
    }

    /* access modifiers changed from: private */
    public String bv() {
        synchronized (this.h) {
            if (this.S == null || this.S.length < 2) {
                return "";
            }
            String str = this.S[0] + "x" + this.S[1];
            return str;
        }
    }

    public void a(final Size size, Size size2) {
        if (size == null) {
            e.e("CameraManager", "onPreviewSurfaceSizeChanged, previewSize is null ");
            return;
        }
        e.a("onPreviewSurfaceSizeChanged");
        q(Util.b(size.getWidth(), size.getHeight()));
        e.a("CameraManager", "onPreviewSurfaceSizeChanged");
        this.cc.a(size, size2, true);
        this.dN.a(new Runnable() {
            public void run() {
                e.a("CameraManager", "onPreviewSurfaceSizeChanged, mbCaptureModeChanging: " + f.this.aC);
                if (!f.this.aC) {
                    if (f.this.cj != null && !f.this.cj.bk() && !f.this.cj.df()) {
                        f fVar = f.this;
                        fVar.a(size, fVar.bh);
                    }
                    if (!f.this.aD && f.this.cc != null) {
                        f.this.cc.i(true);
                    }
                }
            }
        });
        e.b("onPreviewSizeChanged");
    }

    public boolean u() {
        if (this.ce == null) {
            return false;
        }
        return this.ce.r();
    }

    public boolean b(String str) {
        if (this.cj != null) {
            return this.cj.i(str);
        }
        return true;
    }

    public void v() {
        this.dN.a(new Runnable() {
            public void run() {
                synchronized (f.this.bH) {
                    if (f.this.cc != null) {
                        f.this.cc.cj();
                    }
                }
            }
        });
    }

    public void w() {
        this.dN.a(new Runnable() {
            public void run() {
                synchronized (f.this.bH) {
                    if (f.this.cc != null) {
                        f.this.cc.ck();
                    }
                }
            }
        });
    }

    public void x() {
        final Size a2 = this.cT.a(this.bS);
        this.dN.a(new Runnable() {
            /* JADX WARNING: Code restructure failed: missing block: B:20:0x0098, code lost:
                return;
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void run() {
                /*
                    r4 = this;
                    com.oppo.camera.f r0 = com.oppo.camera.f.this
                    java.lang.Object r0 = r0.bI
                    monitor-enter(r0)
                    com.oppo.camera.f r1 = com.oppo.camera.f.this     // Catch:{ all -> 0x0099 }
                    boolean r1 = r1.as     // Catch:{ all -> 0x0099 }
                    if (r1 == 0) goto L_0x0011
                    monitor-exit(r0)     // Catch:{ all -> 0x0099 }
                    return
                L_0x0011:
                    java.lang.String r1 = "CameraManager"
                    java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0099 }
                    r2.<init>()     // Catch:{ all -> 0x0099 }
                    java.lang.String r3 = "startFaceDetection, mbFaceDetectionStarted: "
                    r2.append(r3)     // Catch:{ all -> 0x0099 }
                    com.oppo.camera.f r3 = com.oppo.camera.f.this     // Catch:{ all -> 0x0099 }
                    boolean r3 = r3.ar     // Catch:{ all -> 0x0099 }
                    r2.append(r3)     // Catch:{ all -> 0x0099 }
                    java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0099 }
                    com.oppo.camera.e.a(r1, r2)     // Catch:{ all -> 0x0099 }
                    com.oppo.camera.f r1 = com.oppo.camera.f.this     // Catch:{ all -> 0x0099 }
                    r2 = 0
                    r1.a((android.hardware.camera2.params.Face[]) r2, (int[]) r2)     // Catch:{ all -> 0x0099 }
                    com.oppo.camera.f r1 = com.oppo.camera.f.this     // Catch:{ all -> 0x0099 }
                    r2 = 1
                    boolean unused = r1.ar = r2     // Catch:{ all -> 0x0099 }
                    com.oppo.camera.f r1 = com.oppo.camera.f.this     // Catch:{ all -> 0x0099 }
                    com.oppo.camera.f r2 = com.oppo.camera.f.this     // Catch:{ all -> 0x0099 }
                    com.oppo.camera.e.o r2 = r2.cj     // Catch:{ all -> 0x0099 }
                    java.lang.String r3 = "pref_video_eis"
                    boolean r2 = r2.i((java.lang.String) r3)     // Catch:{ all -> 0x0099 }
                    boolean unused = r1.aZ = r2     // Catch:{ all -> 0x0099 }
                    com.oppo.camera.f r1 = com.oppo.camera.f.this     // Catch:{ all -> 0x0099 }
                    com.oppo.camera.ui.g r1 = r1.cc     // Catch:{ all -> 0x0099 }
                    com.oppo.camera.f r2 = com.oppo.camera.f.this     // Catch:{ all -> 0x0099 }
                    android.graphics.Rect r2 = r2.ca     // Catch:{ all -> 0x0099 }
                    android.util.Size r3 = r0     // Catch:{ all -> 0x0099 }
                    r1.a((android.graphics.Rect) r2, (android.util.Size) r3)     // Catch:{ all -> 0x0099 }
                    java.lang.String r1 = "com.oplus.tunning.video.eis.preview.scale"
                    float r1 = com.oppo.camera.aps.config.CameraConfig.getConfigFloatValue(r1)     // Catch:{ all -> 0x0099 }
                    com.oppo.camera.f r2 = com.oppo.camera.f.this     // Catch:{ all -> 0x0099 }
                    boolean r2 = r2.aZ     // Catch:{ all -> 0x0099 }
                    r3 = 1065353216(0x3f800000, float:1.0)
                    if (r2 == 0) goto L_0x0070
                    int r2 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
                    if (r2 <= 0) goto L_0x0070
                    goto L_0x0071
                L_0x0070:
                    r1 = r3
                L_0x0071:
                    boolean r2 = com.oppo.camera.util.Util.p()     // Catch:{ all -> 0x0099 }
                    if (r2 == 0) goto L_0x0080
                    com.oppo.camera.f r2 = com.oppo.camera.f.this     // Catch:{ all -> 0x0099 }
                    com.oppo.camera.ui.g r2 = r2.cc     // Catch:{ all -> 0x0099 }
                    r2.a((float) r1)     // Catch:{ all -> 0x0099 }
                L_0x0080:
                    com.oppo.camera.f r1 = com.oppo.camera.f.this     // Catch:{ all -> 0x0099 }
                    com.oppo.camera.ui.g r1 = r1.cc     // Catch:{ all -> 0x0099 }
                    if (r1 == 0) goto L_0x0097
                    com.oppo.camera.f r1 = com.oppo.camera.f.this     // Catch:{ all -> 0x0099 }
                    com.oppo.camera.ui.g r1 = r1.cc     // Catch:{ all -> 0x0099 }
                    com.oppo.camera.f r2 = com.oppo.camera.f.this     // Catch:{ all -> 0x0099 }
                    boolean r2 = r2.ao     // Catch:{ all -> 0x0099 }
                    r1.U((boolean) r2)     // Catch:{ all -> 0x0099 }
                L_0x0097:
                    monitor-exit(r0)     // Catch:{ all -> 0x0099 }
                    return
                L_0x0099:
                    r1 = move-exception
                    monitor-exit(r0)     // Catch:{ all -> 0x0099 }
                    throw r1
                */
                throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.f.AnonymousClass10.run():void");
            }
        });
    }

    public void y() {
        this.dN.a(new Runnable() {
            /* JADX WARNING: Code restructure failed: missing block: B:11:0x0045, code lost:
                return;
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void run() {
                /*
                    r4 = this;
                    com.oppo.camera.f r0 = com.oppo.camera.f.this
                    java.lang.Object r0 = r0.bI
                    monitor-enter(r0)
                    com.oppo.camera.f r1 = com.oppo.camera.f.this     // Catch:{ all -> 0x0046 }
                    boolean r1 = r1.as     // Catch:{ all -> 0x0046 }
                    if (r1 == 0) goto L_0x0011
                    monitor-exit(r0)     // Catch:{ all -> 0x0046 }
                    return
                L_0x0011:
                    java.lang.String r1 = "CameraManager"
                    java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0046 }
                    r2.<init>()     // Catch:{ all -> 0x0046 }
                    java.lang.String r3 = "stopFaceDetection, mbFaceDetectionStarted: "
                    r2.append(r3)     // Catch:{ all -> 0x0046 }
                    com.oppo.camera.f r3 = com.oppo.camera.f.this     // Catch:{ all -> 0x0046 }
                    boolean r3 = r3.ar     // Catch:{ all -> 0x0046 }
                    r2.append(r3)     // Catch:{ all -> 0x0046 }
                    java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0046 }
                    com.oppo.camera.e.a(r1, r2)     // Catch:{ all -> 0x0046 }
                    com.oppo.camera.f r1 = com.oppo.camera.f.this     // Catch:{ all -> 0x0046 }
                    r2 = 0
                    boolean unused = r1.ar = r2     // Catch:{ all -> 0x0046 }
                    com.oppo.camera.f r1 = com.oppo.camera.f.this     // Catch:{ all -> 0x0046 }
                    com.oppo.camera.ui.g r1 = r1.cc     // Catch:{ all -> 0x0046 }
                    if (r1 == 0) goto L_0x0044
                    com.oppo.camera.f r1 = com.oppo.camera.f.this     // Catch:{ all -> 0x0046 }
                    com.oppo.camera.ui.g r1 = r1.cc     // Catch:{ all -> 0x0046 }
                    r1.bk()     // Catch:{ all -> 0x0046 }
                L_0x0044:
                    monitor-exit(r0)     // Catch:{ all -> 0x0046 }
                    return
                L_0x0046:
                    r1 = move-exception
                    monitor-exit(r0)     // Catch:{ all -> 0x0046 }
                    throw r1
                */
                throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.f.AnonymousClass11.run():void");
            }
        });
    }

    public void z() {
        this.dN.a(new Runnable() {
            /* JADX WARNING: Code restructure failed: missing block: B:11:0x0036, code lost:
                return;
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void run() {
                /*
                    r3 = this;
                    com.oppo.camera.f r0 = com.oppo.camera.f.this
                    java.lang.Object r0 = r0.bK
                    monitor-enter(r0)
                    com.oppo.camera.f r1 = com.oppo.camera.f.this     // Catch:{ all -> 0x0037 }
                    boolean r1 = r1.as     // Catch:{ all -> 0x0037 }
                    if (r1 == 0) goto L_0x0011
                    monitor-exit(r0)     // Catch:{ all -> 0x0037 }
                    return
                L_0x0011:
                    java.lang.String r1 = "CameraManager"
                    java.lang.String r2 = "startMultiFocus"
                    com.oppo.camera.e.b(r1, r2)     // Catch:{ all -> 0x0037 }
                    com.oppo.camera.f r1 = com.oppo.camera.f.this     // Catch:{ all -> 0x0037 }
                    r2 = 0
                    r1.a((int[]) r2)     // Catch:{ all -> 0x0037 }
                    com.oppo.camera.f r1 = com.oppo.camera.f.this     // Catch:{ all -> 0x0037 }
                    r2 = 1
                    boolean unused = r1.au = r2     // Catch:{ all -> 0x0037 }
                    com.oppo.camera.f r1 = com.oppo.camera.f.this     // Catch:{ all -> 0x0037 }
                    com.oppo.camera.ui.g r1 = r1.cc     // Catch:{ all -> 0x0037 }
                    if (r1 == 0) goto L_0x0035
                    com.oppo.camera.f r1 = com.oppo.camera.f.this     // Catch:{ all -> 0x0037 }
                    com.oppo.camera.ui.g r1 = r1.cc     // Catch:{ all -> 0x0037 }
                    r1.bl()     // Catch:{ all -> 0x0037 }
                L_0x0035:
                    monitor-exit(r0)     // Catch:{ all -> 0x0037 }
                    return
                L_0x0037:
                    r1 = move-exception
                    monitor-exit(r0)     // Catch:{ all -> 0x0037 }
                    throw r1
                */
                throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.f.AnonymousClass13.run():void");
            }
        });
    }

    public void A() {
        this.dN.a(new Runnable() {
            /* JADX WARNING: Code restructure failed: missing block: B:11:0x0036, code lost:
                return;
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void run() {
                /*
                    r3 = this;
                    com.oppo.camera.f r0 = com.oppo.camera.f.this
                    java.lang.Object r0 = r0.bK
                    monitor-enter(r0)
                    com.oppo.camera.f r1 = com.oppo.camera.f.this     // Catch:{ all -> 0x0037 }
                    r2 = 0
                    int[] unused = r1.bY = r2     // Catch:{ all -> 0x0037 }
                    com.oppo.camera.f r1 = com.oppo.camera.f.this     // Catch:{ all -> 0x0037 }
                    boolean r1 = r1.as     // Catch:{ all -> 0x0037 }
                    if (r1 == 0) goto L_0x0017
                    monitor-exit(r0)     // Catch:{ all -> 0x0037 }
                    return
                L_0x0017:
                    java.lang.String r1 = "CameraManager"
                    java.lang.String r2 = "stopMultiFocus"
                    com.oppo.camera.e.b(r1, r2)     // Catch:{ all -> 0x0037 }
                    com.oppo.camera.f r1 = com.oppo.camera.f.this     // Catch:{ all -> 0x0037 }
                    r2 = 0
                    boolean unused = r1.au = r2     // Catch:{ all -> 0x0037 }
                    com.oppo.camera.f r1 = com.oppo.camera.f.this     // Catch:{ all -> 0x0037 }
                    com.oppo.camera.ui.g r1 = r1.cc     // Catch:{ all -> 0x0037 }
                    if (r1 == 0) goto L_0x0035
                    com.oppo.camera.f r1 = com.oppo.camera.f.this     // Catch:{ all -> 0x0037 }
                    com.oppo.camera.ui.g r1 = r1.cc     // Catch:{ all -> 0x0037 }
                    r1.bm()     // Catch:{ all -> 0x0037 }
                L_0x0035:
                    monitor-exit(r0)     // Catch:{ all -> 0x0037 }
                    return
                L_0x0037:
                    r1 = move-exception
                    monitor-exit(r0)     // Catch:{ all -> 0x0037 }
                    throw r1
                */
                throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.f.AnonymousClass14.run():void");
            }
        });
    }

    public boolean B() {
        boolean z2;
        synchronized (this.bI) {
            z2 = this.ar;
        }
        return z2;
    }

    /* access modifiers changed from: private */
    public void y(boolean z2) {
        e.a("CameraManager", "setTabCaptureStart, " + this.bq + " -> " + z2);
        this.bq = z2;
    }

    public void c(boolean z2) {
        e.a("CameraManager", "setDoubleFinger, mbDoubleFinger: " + this.bf + " -> " + z2);
        this.bf = z2;
    }

    public void d(boolean z2) {
        e.a("CameraManager", "setCaptureModeChangeState, " + this.aC + " -> " + z2);
        this.aC = z2;
    }

    public boolean C() {
        return this.aA;
    }

    public void e(boolean z2) {
        e.a("CameraManager", "setSwitchingCameraState, " + this.aA + " -> " + z2);
        this.aA = z2;
    }

    public void f(boolean z2) {
        e.a("CameraManager", "setDelayToDisableBustShot, " + this.be + " > " + z2);
        this.be = z2;
    }

    public void g(boolean z2) {
        e.a("CameraManager", "setSizeChangeState: " + this.aD + " > " + z2);
        this.aD = z2;
    }

    public void h(boolean z2) {
        e.a("CameraManager", "setForceChangeRecSize: " + this.aF + " > " + z2);
        this.aF = z2;
    }

    public void i(boolean z2) {
        e.a("CameraManager", "setNoneSatUltraWideAngleChanging, running: " + this.ay + " > " + z2);
        this.ay = z2;
    }

    public void j(boolean z2) {
        e.a("CameraManager", "setNoneSatTeleAngleChanging, running: " + this.az + " > " + z2);
        this.az = z2;
    }

    public void k(boolean z2) {
        e.a("CameraManager", "setBlurAnimRunning, running: " + this.ax + " > " + z2);
        this.ax = z2;
    }

    public boolean D() {
        return this.ax;
    }

    public void d(int i2) {
        e.a("CameraManager", "setBlurAnimType, animType: " + this.W + " > " + i2);
        this.W = i2;
    }

    private void q(int i2) {
        e.a("CameraManager", "setSizeRatioType, type: " + i2);
        if (i2 != this.dI) {
            this.dI = i2;
            this.cc.y(this.dI);
        }
    }

    public boolean E() {
        e.a("CameraManager", "needPreviewImage");
        u uVar = this.dM;
        if (uVar == null || !this.aC || uVar.c()) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    public String bw() {
        e.a("CameraManager", "checkSmallInternalStorage");
        String string = this.bO.getString(R.string.camera_storage_default_value);
        if (z.d() && z.g() <= 8.0d) {
            string = "on";
        }
        SharedPreferences.Editor edit = this.bP.edit();
        edit.putString("pref_camera_storage_key", string);
        edit.apply();
        return string;
    }

    /* access modifiers changed from: private */
    public void bx() {
        e.a("CameraManager", "checkStorage, mbCheckStorage: " + this.aq);
        if (!this.aq) {
            this.aq = true;
            this.cl = new AsyncTask<Void, Void, Void>() {
                /* access modifiers changed from: protected */
                public void onPreExecute() {
                    e.a("CameraManager", "onPreExecute");
                    if (!f.this.as) {
                        f fVar = f.this;
                        String unused = fVar.bD = fVar.bP.getString("pref_camera_storage_key", (String) null);
                        if (f.this.bD == null) {
                            f fVar2 = f.this;
                            String unused2 = fVar2.bD = fVar2.bw();
                        }
                    }
                    if (!f.this.bk) {
                        if ("on".equals(f.this.bD) && !z.d()) {
                            SharedPreferences.Editor edit = f.this.bP.edit();
                            edit.putString("pref_camera_storage_key", "off");
                            edit.apply();
                            String unused3 = f.this.bD = "off";
                        }
                        boolean unused4 = f.this.bk = true;
                    }
                }

                /* access modifiers changed from: protected */
                /* renamed from: a */
                public Void doInBackground(Void... voidArr) {
                    e.a("CameraManager", "checkStorage, doInBackground");
                    if (f.this.as) {
                        return null;
                    }
                    z.a(f.this.bP, f.this.bD);
                    return null;
                }

                /* access modifiers changed from: protected */
                /* renamed from: a */
                public void onPostExecute(Void voidR) {
                    e.a("CameraManager", "checkStorage, onPostExecute, mbPaused: " + f.this.as);
                    if (!f.this.as) {
                        int i = z.s;
                        if (i == 1 || i == 2 || i == 3 || i == 4) {
                            if (f.this.cj.aM()) {
                                f.this.cj.i(false);
                            }
                        } else if (i == 5 && f.this.cj.aM() && f.this.bV != null) {
                            f.this.bV.m();
                        }
                        f fVar = f.this;
                        String unused = fVar.bD = fVar.bP.getString("pref_camera_storage_key", f.this.bO.getString(R.string.camera_storage_default_value));
                        f.this.cc.o();
                    }
                    boolean unused2 = f.this.aq = false;
                }
            }.execute(new Void[0]);
        }
    }

    public void a(float f2, float f3) {
        float f4 = f2 - f3;
        float parseFloat = Float.parseFloat(Util.af());
        if (Float.compare(f4, parseFloat) < 0) {
            f4 = parseFloat;
        }
        a(f4);
        e.b("CameraManager", "decreaseScreenBrightness, targetBrightness: " + f4 + ", targetBrightness:" + f4);
        if (Float.compare(f4, parseFloat) > 0) {
            this.dN.removeMessages(17);
            this.dN.sendMessageDelayed(this.dN.obtainMessage(17, Float.valueOf(f4)), 1000);
        }
    }

    public int F() {
        return Settings.System.getInt(this.bO.getApplicationContext().getContentResolver(), CameraStatisticsUtil.SCREEN_BRIGHTNESS, (int) (((float) this.D) * 0.4f));
    }

    /* access modifiers changed from: private */
    public void by() {
        long parseLong = Long.parseLong(Util.ae());
        float floatValue = Float.valueOf((float) F()).floatValue() / ((float) this.D);
        float parseFloat = Float.parseFloat(Util.af());
        if (Float.compare(floatValue, parseFloat) > 0) {
            e.b("CameraManager", "delayDecreaseBrightness, decreaseScreenBrightnessDelay: " + parseLong);
            this.aP = (floatValue - parseFloat) / 30.0f;
            this.dN.removeMessages(17);
            this.dN.sendMessageDelayed(this.dN.obtainMessage(17, Float.valueOf(floatValue)), parseLong);
        }
    }

    public void a(float f2) {
        if (this.bO != null) {
            if (f2 == -1.0f) {
                G();
                return;
            }
            float f3 = (float) Settings.System.getInt(this.bO.getApplicationContext().getContentResolver(), CameraStatisticsUtil.SCREEN_BRIGHTNESS, (int) (((float) this.D) * 0.4f));
            if (f3 > ((float) this.D)) {
                e.a("CameraManager", "changeScreenBrightness, fSysBrightness >= " + this.D + ", so no need set window screenBrightness");
                if (this.cj != null) {
                    this.cj.h((int) f3);
                    return;
                }
                return;
            }
            Window window = this.bO.getWindow();
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.screenBrightness = f2;
            window.setAttributes(attributes);
            float f4 = ((float) this.D) * f2;
            if (this.cj != null) {
                this.cj.h((int) f4);
            }
        }
    }

    public void G() {
        e.a("CameraManager", "restoreScreenBrightnessForChangeOnRuningtime");
        if (this.bO != null) {
            Window window = this.bO.getWindow();
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.screenBrightness = -1.0f;
            window.setAttributes(attributes);
        }
        int i2 = Settings.System.getInt(Util.f().getContentResolver(), CameraStatisticsUtil.SCREEN_BRIGHTNESS, (int) (((float) this.D) * 0.4f));
        if (this.cj != null) {
            this.cj.h(i2);
        }
        e.a("CameraManager", "restoreScreenBrightnessForChangeOnRuningtime X");
    }

    private int bz() {
        int i2 = this.D;
        if (!Util.h("oplus.software.display.multibits_dimming_support")) {
            return i2;
        }
        try {
            i2 = Integer.parseInt(com.heytap.compat.os.b.a("sys.oppo.multibrightness", "0"));
        } catch (com.heytap.compat.d.a.a e2) {
            e2.printStackTrace();
        }
        return i2 == 0 ? this.D : i2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x005f, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(boolean r7, boolean r8) {
        /*
            r6 = this;
            java.lang.Object r0 = r6.bL
            monitor-enter(r0)
            boolean r1 = r6.bb     // Catch:{ all -> 0x0060 }
            if (r1 == 0) goto L_0x0010
            java.lang.String r7 = "CameraManager"
            java.lang.String r8 = "setAutoBrightnessAdjust, Process would be kill, don't set adjustValue!"
            com.oppo.camera.e.a(r7, r8)     // Catch:{ all -> 0x0060 }
            monitor-exit(r0)     // Catch:{ all -> 0x0060 }
            return
        L_0x0010:
            r6.bb = r8     // Catch:{ all -> 0x0060 }
            int r8 = r6.bz()     // Catch:{ all -> 0x0060 }
            r1 = 1132396544(0x437f0000, float:255.0)
            if (r7 == 0) goto L_0x001d
            r7 = 1133903872(0x43960000, float:300.0)
            goto L_0x001f
        L_0x001d:
            r7 = 1140457472(0x43fa0000, float:500.0)
        L_0x001f:
            float r8 = (float) r8     // Catch:{ all -> 0x0060 }
            float r8 = r8 * r7
            float r8 = r8 / r1
            r7 = 0
            int r7 = (r8 > r7 ? 1 : (r8 == r7 ? 0 : -1))
            if (r7 != 0) goto L_0x0030
            java.lang.String r7 = "CameraManager"
            java.lang.String r8 = "setAutoBrightnessAdjust, No need set adjustValue!"
            com.oppo.camera.e.a(r7, r8)     // Catch:{ all -> 0x0060 }
            monitor-exit(r0)     // Catch:{ all -> 0x0060 }
            return
        L_0x0030:
            java.lang.String r7 = "CameraManager"
            java.util.Locale r1 = java.util.Locale.ENGLISH     // Catch:{ all -> 0x0060 }
            java.lang.String r2 = "setAutoBrightnessAdjust %f on sdk %d"
            r3 = 2
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ all -> 0x0060 }
            r4 = 0
            java.lang.Float r5 = java.lang.Float.valueOf(r8)     // Catch:{ all -> 0x0060 }
            r3[r4] = r5     // Catch:{ all -> 0x0060 }
            r4 = 1
            int r5 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x0060 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x0060 }
            r3[r4] = r5     // Catch:{ all -> 0x0060 }
            java.lang.String r1 = java.lang.String.format(r1, r2, r3)     // Catch:{ all -> 0x0060 }
            com.oppo.camera.e.a(r7, r1)     // Catch:{ all -> 0x0060 }
            r7 = 27
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x0060 }
            if (r7 >= r1) goto L_0x005e
            com.oppo.camera.f$16 r7 = new com.oppo.camera.f$16     // Catch:{ all -> 0x0060 }
            r7.<init>(r8)     // Catch:{ all -> 0x0060 }
            com.oppo.camera.util.Util.a((java.lang.Runnable) r7)     // Catch:{ all -> 0x0060 }
        L_0x005e:
            monitor-exit(r0)     // Catch:{ all -> 0x0060 }
            return
        L_0x0060:
            r7 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0060 }
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.f.a(boolean, boolean):void");
    }

    public void l(boolean z2) {
        e.a("CameraManager", "initScreenBrightness, bEnterCamera: " + z2);
        a(z2, false);
        e.a("CameraManager", "initScreenBrightness X");
    }

    public void H() {
        e.a("CameraManager", "updateOtherSettingFlags");
        this.bC = this.bP.getString("pref_camera_sound_key", this.bO.getString(R.string.camera_sound_default_value));
        this.bE = this.bP.getString("pref_camera_fingerprint_shutter_key", this.bO.getString(R.string.camera_fingerprint_capture_default_value));
        e.a("CameraManager", "updateOtherSettingFlags, mFingerprintShutter: " + this.bE);
        this.bD = this.bP.getString("pref_camera_storage_key", (String) null);
        if (this.bD == null) {
            this.bD = bw();
        }
        if (this.bD.equals("off")) {
            z.r = "off";
        } else {
            z.r = "on";
        }
    }

    public void I() {
        a(0.8f);
        this.cc.bR();
        this.cj.aX();
    }

    public boolean J() {
        if (this.cj != null) {
            return this.cj.Z();
        }
        return false;
    }

    /* access modifiers changed from: private */
    public void bA() {
        e.a("CameraManager", "onPictureSizeChanged");
        if (this.cc != null) {
            Size aX2 = this.cc.aX();
            Size a2 = this.cj.a(this.bS);
            int S2 = this.cj.S();
            boolean a3 = a(aX2, a2, S2, S2, false, 100, (d.a) new t());
            this.cc.a((com.oppo.camera.t.a) null);
            this.dp = null;
            if (a3) {
                g(true);
            }
            this.cc.cw();
        }
        com.oppo.camera.f.f fVar = this.bR;
        if (fVar != null) {
            fVar.a(false, false);
        }
        this.U = 0;
    }

    private void bB() {
        e.a("CameraManager", "onVideoSizeChanged");
        Size aX2 = this.cc.aX();
        Size a2 = this.cT.a(this.bS);
        Size a3 = this.cT.a(a2);
        Size size = a3 != null ? a3 : a2;
        int S2 = this.cj.S();
        if (a(aX2, size, S2, S2, false, 0, (d.a) new y())) {
            g(true);
            this.cc.Q(false);
            String string = this.bP.getString("pref_video_size_key", CameraConfig.getOptionKeyDefaultValue("pref_video_size_key", this.K));
            if (bd() && "video_size_720p".equals(string)) {
                this.cc.bZ();
            }
        }
    }

    private void bC() {
        Size aX2 = this.cc.aX();
        Size a2 = this.cT.a(this.bS);
        Size a3 = this.cT.a(a2);
        Size size = a3 != null ? a3 : a2;
        if (this.bP.getString("pref_10bits_heic_encode_key", "off").equals("on") && this.bP.getBoolean("pref_video_blur_menu_state", false)) {
            this.bP.edit().putBoolean("pref_video_blur_menu_state", false).apply();
        }
        int S2 = this.cj.S();
        if (a(aX2, size, S2, S2, false, 0, (d.a) new e())) {
            g(true);
        }
    }

    /* access modifiers changed from: private */
    public void bD() {
        Size aX2 = this.cc.aX();
        Size a2 = this.cj.a(a.a(this.cH.a(this.cj.l(), this.K)));
        int S2 = this.cj.S();
        Size a3 = this.cj.a(a2);
        if (a(aX2, a3 != null ? a3 : a2, S2, S2, false, 0, (d.a) new c())) {
            g(true);
        }
        this.cH.g();
    }

    private void bE() {
        Size aX2 = this.cc.aX();
        Size a2 = this.cj.a(a.a(this.cH.a(this.cj.l(), this.K)));
        int S2 = this.cj.S();
        Size a3 = this.cj.a(a2);
        Size size = a3 != null ? a3 : a2;
        if (this.ax) {
            this.dM.b(false);
            this.cc.bO();
            k(false);
            d(-1);
            this.cc.c().r();
            e.a("CameraManager", "noneSatTeleAngleChanged, resetBlurAnimation");
        }
        if (a(aX2, size, S2, S2, false, 0, (d.a) new e())) {
            g(true);
        }
        this.cH.g();
    }

    /* access modifiers changed from: private */
    public void bF() {
        Size aX2 = this.cc.aX();
        int S2 = this.cj.S();
        if (a(aX2, aX2, S2, S2, false, 0, (d.a) new e())) {
            g(true);
        }
    }

    private void f(String str) {
        if (n(str)) {
            Size aX2 = this.cc.aX();
            int S2 = this.cj.S();
            if (a(aX2, aX2, S2, S2, false, 0, (d.a) new m())) {
                g(true);
            }
        }
        this.cj.k(str);
    }

    private void g(String str) {
        if (n(str)) {
            Size aX2 = this.cc.aX();
            int S2 = this.cj.S();
            if (a(aX2, aX2, S2, S2, false, 0, (d.a) new m())) {
                g(true);
            }
        }
    }

    private void h(String str) {
        if (n(str)) {
            Size aX2 = this.cc.aX();
            int S2 = this.cj.S();
            if (a(aX2, aX2, S2, S2, false, 0, (d.a) new m())) {
                g(true);
            }
        }
        this.cj.aA();
    }

    public boolean c(String str) {
        com.oppo.camera.e.a a2 = this.cj.a(str);
        Size b2 = b(this.cj.a(this.cj.l()));
        Size b3 = b(a2);
        int b4 = b2 != null ? Util.b(b2.getWidth(), b2.getHeight()) : 0;
        int b5 = b3 != null ? Util.b(b3.getWidth(), b3.getHeight()) : 0;
        u uVar = this.dM;
        if (uVar != null) {
            uVar.a(b2, b3);
        }
        if (!(b2 == null || b3 == null)) {
            e.a("CameraManager", "isModeSwitchNeedBlurAnimate, previewSize:(" + b2.getWidth() + "x" + b2.getHeight() + ") => (" + b3.getWidth() + "x" + b3.getHeight() + ")");
        }
        if (!TextUtils.equals(str, this.cj.l()) || b4 != b5) {
            return true;
        }
        return false;
    }

    public boolean a(String str, int i2) {
        e.a("CameraManager", "setCurrentMode, mode: " + str + ", cameraId: " + i2);
        this.cj.b(i2);
        boolean c2 = this.cj.c(str);
        if (this.de != null) {
            this.cj.a(this.de);
        }
        if (this.bR != null) {
            e.a("CameraManager", "setCurrentMode, mOneCamera:" + this.bR);
            ((h) this.bR).A().c(str);
        }
        if (c2 && this.cc != null) {
            this.cc.b(this.cj.f());
            if (!this.cj.a()) {
                this.cc.ai(false);
            }
            this.cc.an();
            this.cc.cO();
        }
        if (ApsConstant.REC_MODE_COMMON.equals(str)) {
            this.cj.p(this.bv);
        }
        return c2;
    }

    public boolean K() {
        if (this.cj == null || this.cc == null) {
            e.a("CameraManager", "canRespondTouch, mModeManager: " + this.cj + ", mCameraUIManager: " + this.cc);
            return false;
        } else if (this.bn && !this.cc.bT() && this.cj.aN() && !this.cj.T() && !U() && !this.aX && !this.aD && this.aY && bG() && this.bi && !this.bq && this.cc.l() != 4 && this.cH.y() != 3 && !this.aG && ((this.aC || S()) && this.cj.O() && !at() && !this.aA)) {
            return true;
        } else {
            e.a("CameraManager", "canRespondTouch, mbInitialized: " + this.bn + ", getScreenTorchState: " + this.cc.bT() + ", isVideoRecordStopped: " + this.cj.aN() + ", getIsCapturingState: " + this.cj.T() + ", isSnapShotProgress: " + U() + ", mbSwitchingVideoProfile: " + this.aX + ", mbSizeChanging: " + this.aD + ", mbFirstPreviewOK: " + this.aY + ", canScrollChangeMode: " + bG() + ", mbFrameAvailable: " + this.bi + ", mbTabCaptureStart: " + this.bq + ", getMainShutterButtonType: " + this.cc.l() + ", mCameraEntry.getCameraEntryType(): " + this.cH.y() + ", mbBurstShot: " + this.aG + ", mbCaptureModeChanging: " + this.aC + ", isPreviewStarted: " + S() + ", mModeManager.isAllowSwitch: " + this.cj.O() + ", isTimerSnapShotRunning: " + at() + ", mbSwitchingCamera: " + this.aA);
            return false;
        }
    }

    public boolean L() {
        if (this.cH == null || this.cj == null || this.bR == null || this.cH.a(this.cj.l(), this.K) != this.bR.c()) {
            return false;
        }
        return true;
    }

    public boolean M() {
        if (this.cj == null || this.cc == null) {
            e.a("CameraManager", "isAllowSwitchMode, mModeManager: " + this.cj + ", mCameraUIManager: " + this.cc);
            return false;
        } else if (this.bn && !this.cc.bT() && this.cj.aN() && !this.cj.T() && !this.cj.aj() && !U() && !this.aX && !this.aD && this.aY && bG() && !this.bq && this.cc.l() != 4 && this.cH.y() != 3 && !this.aG && this.cY && ((this.aC || S()) && this.cj.O() && !at() && !this.aA && !this.cc.G() && !this.cj.a() && !this.cc.t() && ((!this.cc.C() || this.cj.bs() != 1) && !this.cj.aV() && !aO() && !this.cc.cN() && !this.cc.cP() && !this.cc.db() && this.dC))) {
            return true;
        } else {
            e.a("CameraManager", "isAllowSwitchMode, mbInitialized: " + this.bn + ", getScreenTorchState: " + this.cc.bT() + ", isVideoRecordStopped: " + this.cj.aN() + ", getIsCapturingState: " + this.cj.T() + ", getIsShowPostCaptureAlert: " + this.cj.aj() + ", isSnapShotProgress: " + U() + ", mbSwitchingVideoProfile: " + this.aX + ", mbSizeChanging: " + this.aD + ", mbFirstPreviewOK: " + this.aY + ", canScrollChangeMode: " + bG() + ", mbTabCaptureStart: " + this.bq + ", getMainShutterButtonType: " + this.cc.l() + ", mCameraEntry.getCameraEntryType(): " + this.cH.y() + ", mbBurstShot: " + this.aG + ", mbApsFinishAddFrame: " + this.cY + ", mbCaptureModeChanging: " + this.aC + ", isPreviewStarted: " + S() + ", mModeManager.isAllowSwitch: " + this.cj.O() + ", isTimerSnapShotRunning: " + at() + ", mbSwitchingCamera: " + this.aA + ", isBlurMenuOpen: " + this.cc.G() + ", isPanelMode: " + this.cj.a() + ", isAnyModeAnimationRunning: " + this.cc.t() + ", isFaceBeautyMenuOpen: " + this.cc.C() + ", faceBeautyMenuType: " + this.cj.bs() + ", isStickerMenuOpen: " + this.cj.aV() + ", isZoomAnimRunning: " + aO() + ", isFilterEffectMenuAnimRunning: " + this.cc.cN() + ", isNightAnimationRunning: " + this.cc.cP() + ", isDrawerAnimationRun: " + this.cc.db() + ", mbEntryFirstPreviewReceived: " + this.dC);
            return false;
        }
    }

    private void e(MotionEvent motionEvent) {
        e.a("CameraManager", "onUp");
        e.a("onUp");
        if (this.cj != null && this.cj.aj()) {
            return;
        }
        if (this.dc) {
            this.M = 0;
        } else if (this.cj == null || !this.cj.a(this.M, motionEvent)) {
            int i2 = this.M;
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        if (i2 == 4 && !this.ax && 500 > this.aS && !this.cc.da() && ("off".equals(cl()) || this.f2941co == null || !this.f2941co.d())) {
                            if ("on".equals(this.bP.getString("pref_subsetting_key", "off"))) {
                                this.bP.edit().putString("pref_subsetting_key", "off").apply();
                            }
                            com.oppo.camera.ui.f fVar = this.dW;
                            if (fVar != null) {
                                fVar.l("2");
                            }
                        }
                    } else if (!this.ax && 500 > this.aS && !this.cc.da() && !this.cc.ap() && this.aN && ("off".equals(cl()) || this.f2941co == null || !this.f2941co.d())) {
                        if ("off".equals(this.bP.getString("pref_subsetting_key", "off"))) {
                            this.bP.edit().putString("pref_subsetting_key", "on").apply();
                        }
                        com.oppo.camera.ui.f fVar2 = this.dW;
                        if (fVar2 != null) {
                            fVar2.l("2");
                        }
                    }
                } else if (500 > this.aS) {
                    if (this.cj != null && this.cj.aV() && !this.cj.at()) {
                        this.cc.aG();
                    } else if (this.cc.s()) {
                        if (motionEvent.getY() < ((float) this.cc.bd()) && K()) {
                            this.cc.bc();
                        }
                    } else if (M() && !this.dB) {
                        this.cc.aO();
                    }
                }
            } else if (500 > this.aS) {
                if (this.cj != null && this.cj.aV() && !this.cj.at()) {
                    this.cc.aF();
                } else if (this.cc.s()) {
                    if (motionEvent.getY() < ((float) this.cc.bd()) && K()) {
                        this.cc.bb();
                    }
                } else if (M() && !this.dB) {
                    this.cc.aN();
                }
            }
            this.M = 0;
            e.b("onUp");
        } else {
            e.a("CameraManager", "onUp, getCurrentModeName: " + this.cj.l());
            this.M = 0;
            e.b("onUp");
        }
    }

    private boolean bG() {
        return !at() && !this.bf;
    }

    public void a(MotionEvent motionEvent) {
        r rVar;
        m(motionEvent.getPointerCount() >= 2);
        if (motionEvent.getAction() == 0) {
            this.aQ = motionEvent.getY();
            this.aR = motionEvent.getDownTime();
        } else if (2 == motionEvent.getActionMasked() && this.bf && (rVar = this.cL) != null) {
            this.M = 0;
            rVar.a(false);
        }
        this.cc.c(motionEvent);
    }

    public void m(boolean z2) {
        c(z2);
        if (this.cj != null) {
            this.cj.a(!z2);
        }
    }

    public void b(MotionEvent motionEvent) {
        if (this.cq == null) {
            this.cq = VelocityTracker.obtain();
        }
        this.cq.addMovement(motionEvent);
    }

    /* JADX WARNING: Removed duplicated region for block: B:106:0x014a A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(int r9, android.view.KeyEvent r10) {
        /*
            r8 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "onKeyDown, keycode: "
            r0.append(r1)
            r0.append(r9)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "CameraManager"
            com.oppo.camera.e.a(r1, r0)
            com.oppo.camera.q r0 = com.oppo.camera.q.a()
            r0.a(r9, r10)
            int r0 = r8.Y
            r1 = 1
            if (r0 != r9) goto L_0x0035
            boolean r9 = r8.bo
            if (r9 == 0) goto L_0x0034
            int r9 = r10.getRepeatCount()
            if (r9 != 0) goto L_0x0034
            java.lang.String r9 = "fingerprint"
            r8.i((java.lang.String) r9)
            r8.aC()
        L_0x0034:
            return r1
        L_0x0035:
            r0 = 27
            if (r9 == r0) goto L_0x01cb
            r0 = 66
            if (r9 == r0) goto L_0x01cb
            r0 = 82
            if (r9 == r0) goto L_0x01ca
            r0 = 84
            if (r9 == r0) goto L_0x01c5
            r0 = 319(0x13f, float:4.47E-43)
            if (r9 == r0) goto L_0x01cb
            r0 = 706(0x2c2, float:9.9E-43)
            if (r9 == r0) goto L_0x01b7
            r0 = 717(0x2cd, float:1.005E-42)
            r2 = 0
            if (r9 == r0) goto L_0x014b
            r0 = 57
            if (r9 == r0) goto L_0x0133
            r0 = 58
            if (r9 == r0) goto L_0x011b
            r0 = 79
            if (r9 == r0) goto L_0x00d7
            r0 = 80
            if (r9 == r0) goto L_0x00c9
            r0 = 168(0xa8, float:2.35E-43)
            if (r9 == r0) goto L_0x00a9
            r0 = 169(0xa9, float:2.37E-43)
            if (r9 == r0) goto L_0x00a9
            switch(r9) {
                case 19: goto L_0x00a2;
                case 20: goto L_0x00a2;
                case 21: goto L_0x00a2;
                case 22: goto L_0x00a2;
                case 23: goto L_0x0098;
                case 24: goto L_0x006f;
                case 25: goto L_0x006f;
                default: goto L_0x006d;
            }
        L_0x006d:
            goto L_0x014a
        L_0x006f:
            com.oppo.camera.ui.g r0 = r8.cc
            boolean r0 = r0.cQ()
            if (r0 == 0) goto L_0x0080
            com.oppo.camera.ui.g r0 = r8.cc
            boolean r0 = r0.cH()
            if (r0 == 0) goto L_0x0080
            return r1
        L_0x0080:
            com.oppo.camera.ui.g r0 = r8.cc
            boolean r0 = r0.cF()
            if (r0 != 0) goto L_0x0097
            com.oppo.camera.ui.g r0 = r8.cc
            boolean r0 = r0.dk()
            if (r0 == 0) goto L_0x0091
            goto L_0x0097
        L_0x0091:
            boolean r9 = r8.d((int) r9, (android.view.KeyEvent) r10)
            if (r9 == 0) goto L_0x014a
        L_0x0097:
            return r1
        L_0x0098:
            boolean r9 = com.oppo.camera.util.Util.M()
            if (r9 != 0) goto L_0x00a1
            r8.a((android.view.KeyEvent) r10)
        L_0x00a1:
            return r1
        L_0x00a2:
            boolean r9 = com.oppo.camera.util.Util.M()
            if (r9 == 0) goto L_0x014a
            return r1
        L_0x00a9:
            com.oppo.camera.ui.g r0 = r8.cc
            boolean r0 = r0.cQ()
            if (r0 == 0) goto L_0x00b9
            com.oppo.camera.ui.g r0 = r8.cc
            boolean r0 = r0.cH()
            if (r0 != 0) goto L_0x00c1
        L_0x00b9:
            com.oppo.camera.ui.g r0 = r8.cc
            boolean r0 = r0.cF()
            if (r0 == 0) goto L_0x00c2
        L_0x00c1:
            return r1
        L_0x00c2:
            boolean r9 = r8.c((int) r9, (android.view.KeyEvent) r10)
            if (r9 == 0) goto L_0x014a
            return r1
        L_0x00c9:
            boolean r9 = r8.bo
            if (r9 == 0) goto L_0x00d6
            int r9 = r10.getRepeatCount()
            if (r9 != 0) goto L_0x00d6
            r8.aC()
        L_0x00d6:
            return r1
        L_0x00d7:
            long r2 = r10.getDownTime()
            boolean r9 = r8.bo
            r4 = 600(0x258, double:2.964E-321)
            if (r9 == 0) goto L_0x00f0
            int r9 = r10.getRepeatCount()
            if (r9 != 0) goto L_0x00f0
            long r6 = r8.ad
            long r6 = r2 - r6
            int r9 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r9 > 0) goto L_0x00f0
            return r1
        L_0x00f0:
            boolean r9 = r8.bo
            if (r9 == 0) goto L_0x010e
            int r9 = r10.getRepeatCount()
            if (r9 != 0) goto L_0x010e
            long r6 = r8.ad
            long r6 = r2 - r6
            int r9 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r9 <= 0) goto L_0x010e
            boolean r9 = r8.aw()
            if (r9 == 0) goto L_0x010e
            r8.ad = r2
            r8.aC()
            goto L_0x011a
        L_0x010e:
            boolean r9 = r8.bo
            if (r9 == 0) goto L_0x011a
            int r9 = r10.getRepeatCount()
            if (r9 <= 0) goto L_0x011a
            r8.ad = r2
        L_0x011a:
            return r1
        L_0x011b:
            boolean r9 = com.oppo.camera.util.Util.M()
            if (r9 == 0) goto L_0x014a
            boolean r9 = com.oppo.camera.util.Util.P()
            if (r9 == 0) goto L_0x014a
            boolean r9 = r8.M()
            if (r9 == 0) goto L_0x014a
            com.oppo.camera.ui.g r9 = r8.cc
            r9.aN()
            goto L_0x014a
        L_0x0133:
            boolean r9 = com.oppo.camera.util.Util.M()
            if (r9 == 0) goto L_0x014a
            boolean r9 = com.oppo.camera.util.Util.P()
            if (r9 == 0) goto L_0x014a
            boolean r9 = r8.M()
            if (r9 == 0) goto L_0x014a
            com.oppo.camera.ui.g r9 = r8.cc
            r9.aO()
        L_0x014a:
            return r2
        L_0x014b:
            com.oppo.camera.entry.b r9 = r8.cH
            int r9 = r9.y()
            if (r1 == r9) goto L_0x0154
            return r1
        L_0x0154:
            boolean r9 = r8.bo
            if (r9 == 0) goto L_0x01b6
            int r9 = r10.getRepeatCount()
            if (r9 != 0) goto L_0x01b6
            com.oppo.camera.e.o r9 = r8.cj
            com.oppo.camera.e.o r10 = r8.cj
            java.lang.String r10 = r10.l()
            com.oppo.camera.e.a r9 = r9.a((java.lang.String) r10)
            boolean r9 = r9.g()
            if (r9 == 0) goto L_0x0173
            java.lang.String r9 = "commonVideo"
            goto L_0x0175
        L_0x0173:
            java.lang.String r9 = "common"
        L_0x0175:
            com.oppo.camera.ui.g r10 = r8.cc
            if (r10 == 0) goto L_0x018f
            com.oppo.camera.ui.g r10 = r8.cc
            boolean r10 = r10.cH()
            if (r10 == 0) goto L_0x018f
            com.oppo.camera.ui.g r10 = r8.cc
            r10.cJ()
            com.oppo.camera.ui.g r10 = r8.cc
            r10.ao(r2)
            r10 = -1
            r8.a((boolean) r2, (boolean) r2, (int) r10)
        L_0x018f:
            com.oppo.camera.ui.g r10 = r8.cc
            if (r10 == 0) goto L_0x01a9
            com.oppo.camera.ui.g r10 = r8.cc
            boolean r10 = r10.d()
            if (r10 == 0) goto L_0x01a1
            boolean r10 = r8.M()
            if (r10 != 0) goto L_0x01b3
        L_0x01a1:
            com.oppo.camera.ui.g r10 = r8.cc
            boolean r10 = r10.cm()
            if (r10 != 0) goto L_0x01b3
        L_0x01a9:
            com.oppo.camera.e.o r10 = r8.cj
            java.lang.String r0 = "key_support_gimbal_change"
            boolean r10 = r10.i((java.lang.String) r0)
            if (r10 == 0) goto L_0x01b6
        L_0x01b3:
            r8.o((java.lang.String) r9)
        L_0x01b6:
            return r1
        L_0x01b7:
            boolean r9 = r8.bo
            if (r9 == 0) goto L_0x01c4
            int r9 = r10.getRepeatCount()
            if (r9 != 0) goto L_0x01c4
            r8.aD()
        L_0x01c4:
            return r1
        L_0x01c5:
            boolean r9 = r10.isLongPress()
            return r9
        L_0x01ca:
            return r1
        L_0x01cb:
            r8.a((android.view.KeyEvent) r10)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.f.a(int, android.view.KeyEvent):boolean");
    }

    public boolean b(int i2, KeyEvent keyEvent) {
        e.a("CameraManager", "onKeyUp, keyCode: " + i2);
        boolean z2 = M() && Util.c("sys.oplus.otest.cameratest.enable", false);
        if (!(i2 == 24 || i2 == 25)) {
            if (i2 != 79) {
                if (i2 != 80) {
                    if (i2 != 82) {
                        if (i2 != 131) {
                            if (i2 != 319) {
                                switch (i2) {
                                    case 19:
                                    case 20:
                                    case 21:
                                    case 22:
                                        if (Util.M()) {
                                            return true;
                                        }
                                        break;
                                    default:
                                        switch (i2) {
                                            case 133:
                                                if (z2) {
                                                    d(ApsConstant.REC_MODE_COMMON);
                                                    return true;
                                                }
                                                break;
                                            case 134:
                                                if (z2) {
                                                    return true;
                                                }
                                                break;
                                            case 135:
                                                if (z2) {
                                                    this.dW.c(0);
                                                    return true;
                                                }
                                                break;
                                            case 136:
                                                if (z2) {
                                                    this.dW.c(1);
                                                    return true;
                                                }
                                                break;
                                            case 137:
                                                if (z2 && CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_STICKER)) {
                                                    this.dW.c(7);
                                                    return true;
                                                }
                                            case 138:
                                            case 139:
                                                if (this.cj != null) {
                                                    this.cj.c(false);
                                                }
                                                return true;
                                            case 140:
                                                if (z2) {
                                                    d("portrait");
                                                    return true;
                                                }
                                                break;
                                            case 141:
                                                if (z2) {
                                                    this.dW.c(4);
                                                    return true;
                                                }
                                                break;
                                            case 142:
                                                if (z2) {
                                                    this.dW.c(2);
                                                    return true;
                                                }
                                                break;
                                            case 143:
                                                if (z2) {
                                                    d(ApsConstant.CAPTURE_MODE_NIGHT);
                                                    return true;
                                                }
                                                break;
                                            case 144:
                                                if (z2 && CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_MOVIE_MODE)) {
                                                    this.dW.c(3);
                                                    return true;
                                                }
                                        }
                                        break;
                                }
                            }
                        } else if (z2) {
                            d(ApsConstant.CAPTURE_MODE_COMMON);
                        }
                        return false;
                    }
                    return true;
                } else if (this.bo) {
                    aC();
                }
            }
            return true;
        }
        if ((!this.cc.cQ() || !this.cc.cH()) && !this.cc.cF() && !this.cc.dk()) {
            String string = this.bP.getString("pref_volume_key_function_key", this.bO.getString(R.string.camera_volume_key_function_default_value));
            if ("shutter".equals(string) || CameraStatisticsUtil.PORTRAIT_ZOOM.equals(string)) {
                if ("shutter".equals(string)) {
                    if (this.aE) {
                        com.oppo.camera.ui.control.a aVar = this.ea;
                        if (aVar != null) {
                            aVar.j();
                            this.ad = keyEvent.getEventTime();
                        }
                        this.aE = false;
                        return true;
                    }
                    long eventTime = keyEvent.getEventTime();
                    long j2 = this.ad;
                    if (600 < eventTime - j2 && 600 < eventTime - j2) {
                        this.ad = eventTime;
                        this.dm = "volume";
                        aC();
                    }
                }
            }
            return false;
        }
        return true;
    }

    public boolean c(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.aQ = motionEvent.getY();
            this.aR = motionEvent.getDownTime();
            if (this.cg != null && this.cj.aB() && this.cg.isPointInTiltShift(motionEvent.getX(), motionEvent.getY())) {
                this.dc = true;
            }
            if (this.cf != null) {
                this.dB = this.cf.c(motionEvent);
            } else {
                this.dB = false;
            }
        } else if (motionEvent.getAction() == 1) {
            this.aS = motionEvent.getEventTime() - this.aR;
            e(motionEvent);
            if (this.cg != null && this.cj.aB()) {
                this.cg.resetAjustingState();
            }
            this.dc = false;
        } else if (motionEvent.getAction() == 3) {
            this.dc = false;
            f(motionEvent);
        }
        if (!T()) {
            if (!U()) {
                if (this.ce != null && this.ce.a(motionEvent)) {
                    e.a("CameraManager", "dispatchTouchEvent, do mFocus manager touchevent");
                    return true;
                } else if (this.cg != null && this.cj.aB() && this.cg.dispatchTouchEvent(motionEvent)) {
                    return true;
                } else {
                    if (!(this.cN == null || this.ce == null || !this.ce.u())) {
                        d(motionEvent);
                    }
                    if (this.cc != null && this.cc.a(motionEvent)) {
                        return true;
                    }
                    if (this.cf != null && this.cf.a(motionEvent)) {
                        return true;
                    }
                    if (this.cj != null && this.cj.d(motionEvent)) {
                        return true;
                    }
                    g(motionEvent);
                }
            } else if (1 == motionEvent.getAction() || 6 == motionEvent.getAction()) {
                if (this.cf != null) {
                    this.cf.a(motionEvent);
                }
                if ((this.ce == null || !this.ce.a(motionEvent)) && this.cc != null) {
                    this.cc.a(motionEvent);
                }
                g(motionEvent);
            } else if (motionEvent.getAction() == 0) {
                g(motionEvent);
            }
        } else if (6 == motionEvent.getAction() || 262 == motionEvent.getAction()) {
            if (this.cf != null) {
                this.cf.a(motionEvent);
            }
        } else if (!this.cj.aj()) {
            g(motionEvent);
        }
        return false;
    }

    private void f(MotionEvent motionEvent) {
        if (this.cf != null) {
            this.cf.a(motionEvent);
        }
    }

    public void d(MotionEvent motionEvent) {
        v vVar = this.cN;
        if (vVar != null) {
            vVar.a(motionEvent);
        }
    }

    /* compiled from: CameraManager */
    private class r implements GestureDetector.OnGestureListener {

        /* renamed from: b  reason: collision with root package name */
        private boolean f3087b;
        private boolean c;

        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            return false;
        }

        public void onShowPress(MotionEvent motionEvent) {
        }

        private r() {
            this.f3087b = false;
        }

        public boolean onDown(MotionEvent motionEvent) {
            if (f.this.cj.a(motionEvent)) {
                return false;
            }
            this.c = true;
            this.f3087b = true;
            return false;
        }

        public void a(boolean z) {
            this.c = z;
        }

        public void onLongPress(MotionEvent motionEvent) {
            if (f.this.as || !f.this.bo || f.this.bR == null || f.this.cc.i() == null || f.this.bq || f.this.aA || f.this.U() || f.this.T() || (f.this.cf != null && (f.this.cf.h() || f.this.cf.b(motionEvent)))) {
                e.e("CameraManager", "onLongPress, is not preview state,so return");
            } else if (com.oppo.camera.gl.b.e.a().b()) {
                e.e("CameraManager", "onLongPress, small surface is moving, so return");
            } else if (com.oppo.camera.gl.b.e.a().b()) {
                e.e("CameraManager", "onLongPress, small surface is moving, so return");
            } else if (f.this.cc.ba()) {
                f.this.cc.bC();
                e.e("CameraManager", "onLongPress, hidepopupwindow, so return");
            } else if (!f.this.ce.u()) {
                if (f.this.cj != null && f.this.cj.c(motionEvent)) {
                    return;
                }
                if (f.this.cc.b(motionEvent)) {
                    e.e("CameraManager", "onLongPress, needSubSettingTouchEvent, so return");
                    return;
                }
                f.this.c((int) (((double) motionEvent.getX()) + 0.5d), (int) (((double) motionEvent.getY()) + 0.5d));
            }
        }

        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (f.this.cj == null || !f.this.cj.aM()) {
                e.e("CameraManager", "onScroll, mCameraProcessManager.isPreviewStarted() :" + f.this.S());
                if (!this.c || f.this.bf || f.this.U()) {
                    e.a("CameraManager", "onScroll, mbCanScroll: " + this.c + ", mbDoubleFinger: " + f.this.bf + ", isSnapShotProgress: " + f.this.U());
                    return false;
                } else if (f.this.cj != null && f.this.cj.a(motionEvent, motionEvent2, f, f2)) {
                    return false;
                } else {
                    if (f.this.ce != null && f.this.ce.u() && f.this.G % 180 != 0) {
                        return false;
                    }
                    if (!f.this.bo) {
                        e.a("CameraManager", "onScroll, mFirstTimeInitialized is false, so return.");
                        return false;
                    } else if (!f.this.aM() || f.this.aQ < ((float) f.this.cc.aa())) {
                        if (!((f.this.cf != null && (f.this.cf.h() || f.this.cf.e())) || motionEvent == null || motionEvent2 == null)) {
                            float x = motionEvent.getX();
                            float y = motionEvent.getY();
                            float x2 = motionEvent2.getX();
                            float y2 = motionEvent2.getY();
                            StringBuilder sb = new StringBuilder();
                            sb.append("onScroll, eX1 - eX2: ");
                            float f3 = x - x2;
                            sb.append(Math.abs(f3));
                            sb.append(", eY1 - eY2: ");
                            float f4 = y - y2;
                            sb.append(Math.abs(f4));
                            e.a("CameraManager", sb.toString());
                            if (!f.this.cj.aM() && !f.this.cj.T() && !f.this.aA && !f.this.cj.U()) {
                                f.this.cq.computeCurrentVelocity(400);
                                e.a("CameraManager", "onScroll, xVelocity: " + f.this.cq.getXVelocity() + ", yVelocity: " + f.this.cq.getYVelocity());
                                if (Math.abs(f4) < Math.abs(f3)) {
                                    float xVelocity = f.this.cq.getXVelocity();
                                    float abs = Math.abs(f4) / Math.abs(f3);
                                    if (3 != f.this.cH.y() && 1 > Float.compare(abs, 0.58f) && (f3 > ((float) f.this.P) || (xVelocity < ((float) (-f.this.R)) && f3 > ((float) f.this.Q)))) {
                                        int unused = f.this.M = 1;
                                        this.c = false;
                                        return false;
                                    } else if (3 != f.this.cH.y() && 1 > Float.compare(abs, 0.58f)) {
                                        float f5 = x2 - x;
                                        if (f5 > ((float) f.this.P) || (xVelocity > ((float) f.this.R) && f5 > ((float) f.this.Q))) {
                                            int unused2 = f.this.M = 2;
                                            this.c = false;
                                            return false;
                                        }
                                    }
                                } else if (!f.this.T() && !f.this.ce.y() && !f.this.ce.u()) {
                                    float yVelocity = f.this.cq.getYVelocity();
                                    float abs2 = Math.abs(f3) / Math.abs(f4);
                                    if (3 != f.this.cH.y() && 1 > Float.compare(abs2, 0.58f)) {
                                        float f6 = y2 - y;
                                        if (f6 > ((float) f.this.P) || (yVelocity < ((float) (-f.this.R)) && f6 > ((float) f.this.Q))) {
                                            int unused3 = f.this.M = 3;
                                            this.c = false;
                                            return false;
                                        }
                                    }
                                    if (3 != f.this.cH.y() && 1 > Float.compare(abs2, 0.58f) && (f4 > ((float) f.this.P) || (yVelocity < ((float) (-f.this.R)) && f4 > ((float) f.this.Q)))) {
                                        int unused4 = f.this.M = 4;
                                        this.c = false;
                                    }
                                }
                            }
                        }
                        return false;
                    } else {
                        e.a("CameraManager", "isCanScrollHeadLine, isZoomSeekBarExpand: " + f.this.aM());
                        return false;
                    }
                }
            } else {
                e.e("CameraManager", "onScroll, isVideoRecording, so return");
                return false;
            }
        }

        public boolean onSingleTapUp(MotionEvent motionEvent) {
            boolean z;
            int actionIndex = motionEvent.getActionIndex();
            int x = (int) (((double) motionEvent.getX(actionIndex)) + 0.5d);
            int y = (int) (((double) motionEvent.getY(actionIndex)) + 0.5d);
            boolean z2 = true;
            if (f.this.as || f.this.bR == null || f.this.d() || f.this.U() || f.this.cj.b(motionEvent) || f.this.aA || !f.this.S() || !this.f3087b || (f.this.cf != null && f.this.cf.h())) {
                StringBuilder sb = new StringBuilder();
                sb.append("onSingleTapUp, mbPaused: ");
                sb.append(f.this.as);
                sb.append(", mbSwitchingCamera: ");
                sb.append(f.this.aA);
                sb.append(", isSnapShotProgress: ");
                sb.append(f.this.U());
                sb.append(", !isPreviewStarted: ");
                sb.append(!f.this.S());
                sb.append(", mbHasReceiveDownEvent: ");
                sb.append(this.f3087b);
                sb.append(", isInInertialZoom: ");
                if (f.this.cf == null || !f.this.cf.h()) {
                    z2 = false;
                }
                sb.append(z2);
                e.a("CameraManager", sb.toString());
                return false;
            } else if (f.this.cc.C()) {
                f.this.cc.b(true, true, false);
                return true;
            } else if (f.this.cc.b(motionEvent)) {
                e.b("CameraManager", "onSingleTapUp, consumed by submenuSetting");
                return true;
            } else {
                boolean z3 = f.this.cc != null && f.this.cc.ba();
                boolean z4 = f.this.cf != null && f.this.cf.e();
                if (z3 || z4) {
                    if (z3) {
                        e.b("CameraManager", "onSingleTapUp, consumed by popupWindow");
                        f.this.cc.bC();
                    }
                    if (z4) {
                        e.b("CameraManager", "onSingleTapUp, consumed by ZoomMenu");
                        f.this.cf.b(false);
                    }
                    return true;
                } else if (f.this.cc == null || !f.this.cc.dg()) {
                    if (f.this.cf != null && f.this.b("pref_inertial_zoom_key")) {
                        f.this.cf.e(true);
                    }
                    f.this.dA.set(f.this.cc.i().getLeft(), f.this.cc.i().getTop(), f.this.cc.i().getRight(), f.this.cc.i().getBottom());
                    boolean b2 = f.this.cj.b(x, y);
                    if (f.this.dA.contains(x, y)) {
                        long currentTimeMillis = System.currentTimeMillis();
                        if (f.e <= currentTimeMillis - f.this.aw || ((int) Math.sqrt(Math.pow((double) (f.this.aa - x), 2.0d) + Math.pow((double) (f.this.ab - y), 2.0d))) > f.this.ac) {
                            int unused = f.this.aa = x;
                            int unused2 = f.this.ab = y;
                            long unused3 = f.this.aw = currentTimeMillis;
                            f.this.k(0);
                            z = false;
                        } else {
                            long unused4 = f.this.aw = 0;
                            z = a(x, y);
                            if (f.this.cj.ci()) {
                                f.this.k(1);
                            } else if (!z) {
                                f.this.k(0);
                            }
                        }
                        if (!z) {
                            if (b2) {
                                f.this.b(false, false);
                                f.this.a(x, y, false);
                            } else {
                                e.a("CameraManager", "onSingleTapUp, canTouch is false");
                                f.this.cc.f(x, y);
                            }
                        }
                    } else {
                        e.a("CameraManager", "onSingleTapUp, y is not in right area");
                        f.this.cc.f(x, y);
                    }
                    this.f3087b = false;
                    return true;
                } else {
                    e.b("CameraManager", "onSingleTapUp, consumed by SlowVideoModeSeekBar");
                    f.this.cc.df();
                    return true;
                }
            }
        }

        private boolean a(int i, int i2) {
            if (!a() || !f.this.aF() || i2 < f.this.cc.Z() || i2 > f.this.cc.aa() || f.this.aG() || !f.this.S() || !((h) f.this.bR).D() || f.this.aD || !b()) {
                return false;
            }
            e.a("CameraManager", "onDoubleClick, x:" + i + ", y: " + i2);
            f.this.cy();
            f.this.p(FocusAimMsgData.KEY_MULTI_VIDEO_SWITCH_SCREEN_FOCUS_TYPE);
            return true;
        }

        private boolean a() {
            boolean z = true;
            if (!f.this.as && f.this.bR != null && !f.this.d() && !f.this.aA && !f.this.U() && f.this.S() && (f.this.cf == null || !f.this.cf.h())) {
                return true;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("checkCanTap, mbPaused: ");
            sb.append(f.this.as);
            sb.append(", mbSwitchingCamera: ");
            sb.append(f.this.aA);
            sb.append(", isSnapShotProgress: ");
            sb.append(f.this.U());
            sb.append(", !isPreviewStarted: ");
            sb.append(!f.this.S());
            sb.append(", isInInertialZoom: ");
            if (f.this.cf == null || !f.this.cf.h()) {
                z = false;
            }
            sb.append(z);
            e.a("CameraManager", sb.toString());
            return false;
        }

        private boolean b() {
            return f.this.cc.c() != null && f.this.cc.c().s() && f.this.cc.c().t();
        }
    }

    private void g(MotionEvent motionEvent) {
        if (this.cr == null) {
            this.cL = new r();
            this.cr = new GestureDetector(this.bO, this.cL);
        }
        this.cr.onTouchEvent(motionEvent);
    }

    /* access modifiers changed from: private */
    public void a(int i2, int i3, boolean z2) {
        if (new Rect(this.cc.i().getLeft(), this.cc.i().getTop(), this.cc.i().getRight(), this.cc.i().getBottom()).contains(i2, i3) && !this.cc.g(i2, i3) && this.cj.i("pref_continuous_focus_key") && this.ce != null) {
            e.e("CameraManager", "CameraTest Camera Touch Focus Start");
            this.ce.a(i2, i3 - this.cc.i().getTop(), true);
        }
    }

    /* access modifiers changed from: private */
    public void c(int i2, int i3) {
        Rect rect = new Rect();
        rect.set(this.cc.i().getLeft(), this.cc.i().getTop(), this.cc.i().getRight(), this.cc.i().getBottom());
        if (this.cj.b(i2, i3) && rect.contains(i2, i3)) {
            if (this.cj.ac()) {
                k(0);
            } else {
                k(2);
                b(false, false);
            }
            a(i2, i3, true);
        }
    }

    /* access modifiers changed from: private */
    public void bH() {
        if (this.ce != null) {
            this.ce.h();
        }
    }

    public void N() {
        if (this.ce != null) {
            this.ce.o();
        }
    }

    /* access modifiers changed from: private */
    public void a(boolean z2, boolean z3, boolean z4) {
        boolean z5;
        o oVar;
        u uVar;
        boolean z6 = z2;
        boolean z7 = z3;
        boolean z8 = z4;
        e.e("CameraManager", "CameraTest Camera Mode Change Start, isAsync: " + z6 + ", checkToAsync: " + z7 + ", fromAnimation: " + z8 + ", mbPaused: " + this.as);
        com.oppo.camera.perf.a.a("switch_mode");
        if (!this.as && this.cc != null) {
            if (!z8) {
                d(true);
            }
            if (!z6) {
                this.cc.d(false, false);
            }
            bH();
            String string = this.bP.getString("pref_camera_mode_key", Util.a(this.cH.y() == 3));
            if (!z6 && !z8) {
                this.cj.b(string);
            }
            this.cc.Q(false);
            if (this.cj.bP()) {
                this.cc.e("pref_camera_flashmode_key");
            }
            this.cc.cv();
            this.cc.aJ();
            this.U = 0;
            this.cc.cq();
            if (z7 && c(string)) {
                N();
                if (!z8 && ((uVar = this.dM) == null || uVar.b() || this.dK.d())) {
                    u uVar2 = this.dM;
                    if (uVar2 != null && uVar2.b()) {
                        this.dM.b(false);
                    }
                    this.cc.bO();
                    this.dK.c();
                    k(string);
                    return;
                } else if (!k(string)) {
                    e.a("CameraManager", "onCaptureModeChanged, mPreviewImageProcess: " + this.dM);
                    this.ba = true;
                } else {
                    e.a("CameraManager", "onCaptureModeChanged, modeType or surfaceType changed, delay to call");
                    return;
                }
            }
            boolean bd2 = this.cj.bd();
            int d2 = this.cj.d();
            String l2 = this.cj.l();
            int a2 = this.cH.a(this.cj.l(), this.K);
            com.oppo.camera.e.a a3 = this.cj.a(this.cj.l());
            com.oppo.camera.e.a a4 = this.cj.a(string);
            boolean a5 = a(string, this.K);
            int a6 = this.cH.a(string, this.K);
            com.oppo.camera.f.f fVar = this.bR;
            if (!(fVar == null || ((h) fVar).A() == null)) {
                if (ApsConstant.CAPTURE_MODE_MULTI_VIDEO.equals(l2)) {
                    ((h) this.bR).A().a(l2).b(string).b(a6).d(-1).a(true).d();
                    this.cc.c().f(true);
                } else if (ApsConstant.CAPTURE_MODE_MULTI_VIDEO.equals(string)) {
                    ((h) this.bR).A().a(l2).b(string).a(a2).c(-1).a(false).e();
                    this.cc.c().f(false);
                }
                e.e("CameraManager", "multiCameraDecision: " + ((h) this.bR).A());
            }
            e.b("CameraManager", "onCaptureModeChanged, beforeModeName: " + l2 + ", beforeModeProperCameraId: " + a2 + ", afterModeName: " + string + ", afterModeProperCameraId: " + a6);
            if (ApsConstant.REC_MODE_SLOW_VIDEO.equals(l2)) {
                this.bA = false;
            }
            boolean bd3 = this.cj.bd();
            if (a2 == a6 || this.aA || this.bR == null || (oVar = this.cS) == null) {
                z5 = false;
            } else {
                oVar.a(new p().a(l2).b(string).a(a2).b(a6).c(d2).a(bd2).b(bd3).a(a4).b(a3));
                z5 = true;
            }
            if (this.ba) {
                a3.c(1, false);
                this.cj.b(1, true);
                this.cc.b(string, true);
            }
            e.b("CameraManager", "onCaptureModeChanged, modeChange: " + a5 + ", hasOpenCamera: " + z5);
            if (a5 || T()) {
                e.a("CameraManager", "onCaptureModeChanged, isPreviewStopped: " + T() + ", isAsync: " + z6);
                b(false, false);
                k(0);
                o oVar2 = this.cS;
                if (oVar2 != null && !z5) {
                    oVar2.a(new p().a(l2).b(string).a(a2).b(a6).c(d2).a(bd2).b(bd3).a(a4).b(a3));
                }
                if (!z6) {
                    ai();
                }
            } else {
                ai();
            }
            if (!z6 && !this.dK.d()) {
                this.cj.b(1, true);
                d(false);
                ci();
                this.cc.d(true, false);
            }
            e.e("CameraManager", "CameraTest Camera Mode Change End, isAsync: " + z6);
        }
    }

    public int O() {
        Size a2 = this.cj.a(this.bS);
        return (a2 == null || !Util.a(a2)) ? 10 : 9;
    }

    public void e(int i2) {
        this.G = i2;
        if (this.cj != null) {
            this.cj.a(this.G);
        }
        if (this.cc != null) {
            this.cc.x(this.G);
        }
        com.oppo.camera.ui.preview.a.n nVar = this.cd;
        if (nVar != null) {
            nVar.e(this.G);
        }
        if (this.ce != null) {
            this.ce.b(i2);
        }
        if (this.cf != null) {
            this.cf.a(this.G, true);
        }
        v vVar = this.cN;
        if (vVar != null) {
            vVar.a(i2);
        }
        if (this.ck != null) {
            this.ck.a(i2);
        }
        if (this.bR != null && this.cH.y() == 2 && !U()) {
            this.bR.c(a.b(this.L, this.G));
            this.bR.a((f.c) null);
        }
    }

    public void f(int i2) {
        this.I = i2;
        com.oppo.camera.ui.preview.a.n nVar = this.cd;
        if (nVar != null) {
            nVar.f(i2);
        }
        if (b("pref_camera_gradienter_key") && "on".equals(this.bP.getString("pref_camera_gradienter_key", "off")) && S() && this.cc != null && this.cf != null && this.cj != null) {
            this.cc.a(i2, this.cf.e(), this.cj.l());
        }
    }

    public void g(int i2) {
        e.a("CameraManager", "onBatteryChanged, level: " + i2 + ", sbLowBatteryState: " + Camera.l);
        if (this.cj != null) {
            if (i2 > 2) {
                this.cj.j(false);
                this.cc.b((int) R.string.camera_low_battery_rec_disabled);
            } else {
                this.cj.j(true);
                if (this.cj.aM()) {
                    this.cj.i(false);
                    this.cc.a((int) R.string.camera_low_battery_rec_disabled, -1, true, false, false);
                    a(ReminderMsgData.TYPE_DISABLE_CODE, ReminderMsgData.CODE_BATTERY_VIDEO);
                }
            }
        }
        if (i2 > 15) {
            if (Camera.l) {
                Camera.l = false;
                Camera.n = false;
                if (!this.as && this.cc != null) {
                    this.cc.b((int) R.string.camera_low_battery_flash_disable);
                    if (cr()) {
                        this.cc.b("pref_camera_flashmode_key", (String) null);
                    }
                    this.cc.b("pref_camera_videoflashmode_key", (String) null);
                }
            }
        } else if (!Camera.l) {
            Camera.l = true;
            Camera.n = true;
            try {
                if (this.cc != null && !this.as && this.bR != null && this.bV != null && this.cj != null && !this.cj.ac()) {
                    if (!this.ao) {
                        if (this.cj == null || this.cj.T()) {
                            this.br = true;
                        } else {
                            this.bR.a("off");
                            this.bR.a((f.c) null);
                        }
                    } else if (b(CameraFunction.TORCH_SOFT_LIGHT) && this.cj != null && !this.cj.T()) {
                        this.bR.a("off");
                        this.bR.a((f.c) null);
                    }
                    bt();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void n(boolean z2) {
        e.a("CameraManager", "setBurstCaptureEnable, enable: " + z2 + ", mbBurstShot: " + this.aG);
        o(z2);
        if (h.a(this.bO.getApplicationContext()).a()) {
            if (z2) {
                h.a(this.bO.getApplicationContext()).g();
            } else {
                h.a(this.bO.getApplicationContext()).e();
            }
        }
        com.oppo.camera.f.f fVar = this.bR;
        if (fVar != null && !z2) {
            fVar.i();
        }
    }

    public void o(boolean z2) {
        this.aG = z2;
    }

    public void a(z.a aVar) {
        e.a("CameraManager", "storeImagePictureTakenDone, mJpegRotation: " + this.F + ", orientation: " + aVar.v + ", mbBurstShot: " + this.aG + ", jpegName: " + aVar.i + ", mbPaused: " + this.as + ", picture.mFormat: " + aVar.j);
        if (!this.as) {
            b(aVar);
            g();
            boolean z2 = false;
            this.T = 0;
            aVar.u = this.K;
            if (this.cH.y() == 1) {
                if (this.cu != null && "on".equals(this.cu.f())) {
                    aVar.d = this.cu.a();
                }
                if ((!this.aG && !this.cj.aM()) || !aVar.j.equalsIgnoreCase("raw")) {
                    z2 = true;
                }
                aVar.w = this.cc.aV();
                aVar.k = this.cj.l();
                if (0 == aVar.n) {
                    aVar.n = System.currentTimeMillis();
                }
                if (z2) {
                    aVar.A = new e.a() {
                        public void a(final com.oppo.camera.ui.control.e eVar) {
                            f.this.bO.runOnUiThread(new Runnable() {
                                public void run() {
                                    if (f.this.cc != null) {
                                        f.this.cc.a(eVar);
                                    }
                                }
                            });
                        }
                    };
                }
            }
            c(aVar);
            this.dD.a(aVar);
            if (z.t == 0) {
                bx();
                e.a("CameraManager", "storeImagePictureTakenDone X");
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v1, resolved type: android.net.Uri} */
    /* JADX WARNING: type inference failed for: r6v0 */
    /* JADX WARNING: type inference failed for: r6v3, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r6v5 */
    /* JADX WARNING: type inference failed for: r6v6 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void P() {
        /*
            r9 = this;
            java.lang.String r0 = "outputY"
            java.lang.String r1 = "outputX"
            java.lang.String r2 = "aspectY"
            java.lang.String r3 = "aspectX"
            boolean r4 = r9.as
            if (r4 != 0) goto L_0x01c4
            byte[] r4 = r9.cK
            if (r4 == 0) goto L_0x01c4
            android.app.Activity r4 = r9.bO
            if (r4 != 0) goto L_0x0016
            goto L_0x01c4
        L_0x0016:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "doAttach, mCropValue:"
            r4.append(r5)
            java.lang.String r5 = r9.bB
            r4.append(r5)
            java.lang.String r5 = ", mSaveUri:"
            r4.append(r5)
            android.net.Uri r5 = r9.cE
            r4.append(r5)
            java.lang.String r5 = ", mJpegImageData:"
            r4.append(r5)
            byte[] r5 = r9.cK
            int r5 = r5.length
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            java.lang.String r5 = "CameraManager"
            com.oppo.camera.e.a(r5, r4)
            java.lang.String r4 = r9.bB
            r6 = 0
            if (r4 != 0) goto L_0x00f1
            android.net.Uri r0 = r9.cE
            r1 = -1
            if (r0 == 0) goto L_0x00c5
            com.oppo.camera.z.a((android.net.Uri) r0)
            android.app.Activity r0 = r9.bO     // Catch:{ IOException -> 0x009f, SecurityException -> 0x007b }
            android.content.Context r0 = r0.getApplicationContext()     // Catch:{ IOException -> 0x009f, SecurityException -> 0x007b }
            android.content.ContentResolver r0 = r0.getContentResolver()     // Catch:{ IOException -> 0x009f, SecurityException -> 0x007b }
            android.net.Uri r2 = r9.cE     // Catch:{ IOException -> 0x009f, SecurityException -> 0x007b }
            java.io.OutputStream r6 = r0.openOutputStream(r2)     // Catch:{ IOException -> 0x009f, SecurityException -> 0x007b }
            if (r6 == 0) goto L_0x006a
            byte[] r0 = r9.cK     // Catch:{ IOException -> 0x009f, SecurityException -> 0x007b }
            r6.write(r0)     // Catch:{ IOException -> 0x009f, SecurityException -> 0x007b }
            r6.close()     // Catch:{ IOException -> 0x009f, SecurityException -> 0x007b }
        L_0x006a:
            android.app.Activity r0 = r9.bO     // Catch:{ IOException -> 0x009f, SecurityException -> 0x007b }
            r0.setResult(r1)     // Catch:{ IOException -> 0x009f, SecurityException -> 0x007b }
            android.app.Activity r0 = r9.bO     // Catch:{ IOException -> 0x009f, SecurityException -> 0x007b }
            r0.finish()     // Catch:{ IOException -> 0x009f, SecurityException -> 0x007b }
        L_0x0074:
            com.oppo.camera.util.Util.a((java.io.Closeable) r6)
            goto L_0x01c4
        L_0x0079:
            r0 = move-exception
            goto L_0x00c1
        L_0x007b:
            r0 = move-exception
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0079 }
            r2.<init>()     // Catch:{ all -> 0x0079 }
            java.lang.String r3 = "doAttach, SecurityException error, exception: "
            r2.append(r3)     // Catch:{ all -> 0x0079 }
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x0079 }
            r2.append(r0)     // Catch:{ all -> 0x0079 }
            java.lang.String r0 = r2.toString()     // Catch:{ all -> 0x0079 }
            com.oppo.camera.e.e(r5, r0)     // Catch:{ all -> 0x0079 }
            android.app.Activity r0 = r9.bO     // Catch:{ all -> 0x0079 }
            r0.setResult(r1)     // Catch:{ all -> 0x0079 }
            android.app.Activity r0 = r9.bO     // Catch:{ all -> 0x0079 }
            r0.finish()     // Catch:{ all -> 0x0079 }
            goto L_0x0074
        L_0x009f:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0079 }
            r1.<init>()     // Catch:{ all -> 0x0079 }
            java.lang.String r2 = "doAttach, IOException error, exception: "
            r1.append(r2)     // Catch:{ all -> 0x0079 }
            java.lang.String r2 = r0.getMessage()     // Catch:{ all -> 0x0079 }
            r1.append(r2)     // Catch:{ all -> 0x0079 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0079 }
            com.oppo.camera.e.d(r5, r1, r0)     // Catch:{ all -> 0x0079 }
            r0.printStackTrace()     // Catch:{ all -> 0x0079 }
            android.app.Activity r0 = r9.bO     // Catch:{ all -> 0x0079 }
            com.oppo.camera.w.b.a((android.app.Activity) r0)     // Catch:{ all -> 0x0079 }
            goto L_0x0074
        L_0x00c1:
            com.oppo.camera.util.Util.a((java.io.Closeable) r6)
            throw r0
        L_0x00c5:
            byte[] r0 = r9.cK
            int r0 = com.oppo.camera.util.Util.b((byte[]) r0)
            byte[] r2 = r9.cK
            r3 = 51200(0xc800, float:7.1746E-41)
            android.graphics.Bitmap r2 = com.oppo.camera.util.Util.a((byte[]) r2, (int) r3)
            android.graphics.Bitmap r0 = com.oppo.camera.util.Util.a((android.graphics.Bitmap) r2, (int) r0)
            android.app.Activity r2 = r9.bO
            android.content.Intent r3 = new android.content.Intent
            java.lang.String r4 = "inline-data"
            r3.<init>(r4)
            java.lang.String r4 = "data"
            android.content.Intent r0 = r3.putExtra(r4, r0)
            r2.setResult(r1, r0)
            android.app.Activity r0 = r9.bO
            r0.finish()
            goto L_0x01c4
        L_0x00f1:
            android.app.Activity r4 = r9.bO
            java.lang.String r5 = "crop-temp"
            java.io.File r4 = r4.getFileStreamPath(r5)
            java.lang.String r5 = r4.getAbsolutePath()
            java.lang.String r7 = com.oppo.camera.q.a.c
            byte[] r8 = r9.cK
            boolean r5 = com.oppo.camera.q.a.b(r5, r7, r8)
            r7 = 0
            if (r5 == 0) goto L_0x010d
            android.net.Uri r6 = android.net.Uri.fromFile(r4)
            goto L_0x0117
        L_0x010d:
            android.app.Activity r4 = r9.bO
            r4.setResult(r7)
            android.app.Activity r4 = r9.bO
            r4.finish()
        L_0x0117:
            android.os.Bundle r4 = new android.os.Bundle
            r4.<init>()
            java.lang.String r5 = r9.bB
            java.lang.String r8 = "circle"
            boolean r5 = r5.equals(r8)
            if (r5 == 0) goto L_0x012d
            java.lang.String r5 = "circleCrop"
            java.lang.String r8 = "true"
            r4.putString(r5, r8)
        L_0x012d:
            android.net.Uri r5 = r9.cE
            if (r5 == 0) goto L_0x0137
            java.lang.String r8 = "output"
            r4.putParcelable(r8, r5)
            goto L_0x013d
        L_0x0137:
            r5 = 1
            java.lang.String r8 = "return-data"
            r4.putBoolean(r8, r5)
        L_0x013d:
            android.content.Intent r5 = new android.content.Intent
            java.lang.String r8 = "com.android.camera.action.CROP"
            r5.<init>(r8)
            r5.setData(r6)
            android.app.Activity r8 = r9.bO     // Catch:{ Exception -> 0x01b6 }
            android.content.Intent r8 = r8.getIntent()     // Catch:{ Exception -> 0x01b6 }
            if (r8 == 0) goto L_0x019f
            android.app.Activity r8 = r9.bO     // Catch:{ Exception -> 0x01b6 }
            android.content.Intent r8 = r8.getIntent()     // Catch:{ Exception -> 0x01b6 }
            android.os.Bundle r8 = r8.getExtras()     // Catch:{ Exception -> 0x01b6 }
            if (r8 == 0) goto L_0x019f
            android.app.Activity r8 = r9.bO     // Catch:{ Exception -> 0x01b6 }
            android.content.Intent r8 = r8.getIntent()     // Catch:{ Exception -> 0x01b6 }
            android.os.Bundle r8 = r8.getExtras()     // Catch:{ Exception -> 0x01b6 }
            int r8 = r8.getInt(r3)     // Catch:{ Exception -> 0x01b6 }
            r4.putInt(r3, r8)     // Catch:{ Exception -> 0x01b6 }
            android.app.Activity r3 = r9.bO     // Catch:{ Exception -> 0x01b6 }
            android.content.Intent r3 = r3.getIntent()     // Catch:{ Exception -> 0x01b6 }
            android.os.Bundle r3 = r3.getExtras()     // Catch:{ Exception -> 0x01b6 }
            int r3 = r3.getInt(r2)     // Catch:{ Exception -> 0x01b6 }
            r4.putInt(r2, r3)     // Catch:{ Exception -> 0x01b6 }
            android.app.Activity r2 = r9.bO     // Catch:{ Exception -> 0x01b6 }
            android.content.Intent r2 = r2.getIntent()     // Catch:{ Exception -> 0x01b6 }
            android.os.Bundle r2 = r2.getExtras()     // Catch:{ Exception -> 0x01b6 }
            int r2 = r2.getInt(r1)     // Catch:{ Exception -> 0x01b6 }
            r4.putInt(r1, r2)     // Catch:{ Exception -> 0x01b6 }
            android.app.Activity r1 = r9.bO     // Catch:{ Exception -> 0x01b6 }
            android.content.Intent r1 = r1.getIntent()     // Catch:{ Exception -> 0x01b6 }
            android.os.Bundle r1 = r1.getExtras()     // Catch:{ Exception -> 0x01b6 }
            int r1 = r1.getInt(r0)     // Catch:{ Exception -> 0x01b6 }
            r4.putInt(r0, r1)     // Catch:{ Exception -> 0x01b6 }
        L_0x019f:
            java.lang.String r0 = "image/*"
            r5.setDataAndType(r6, r0)     // Catch:{ Exception -> 0x01b6 }
            java.lang.String r0 = "key_set_as_contract"
            java.lang.String r1 = "set_as_contract"
            r5.putExtra(r0, r1)     // Catch:{ Exception -> 0x01b6 }
            r5.putExtras(r4)     // Catch:{ Exception -> 0x01b6 }
            android.app.Activity r0 = r9.bO     // Catch:{ Exception -> 0x01b6 }
            r1 = 1000(0x3e8, float:1.401E-42)
            r0.startActivityForResult(r5, r1)     // Catch:{ Exception -> 0x01b6 }
            goto L_0x01c4
        L_0x01b6:
            r0 = move-exception
            r0.printStackTrace()
            android.app.Activity r0 = r9.bO
            r0.setResult(r7)
            android.app.Activity r0 = r9.bO
            r0.finish()
        L_0x01c4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.f.P():void");
    }

    public int Q() {
        if (this.bP != null) {
            return Integer.parseInt(this.bP.getString("pref_camera_id_key", String.valueOf(0)));
        }
        return 0;
    }

    /* access modifiers changed from: private */
    public void bI() {
        h hVar = this.dH;
        hVar.f3069a = false;
        hVar.f3070b = false;
        hVar.c = false;
        if (hVar.d != null) {
            this.dH.d.recycle();
            this.dH.d = null;
        }
    }

    public void R() {
        e.a("CameraManager", "setSwitchPreviewCb, mCameraSwitch: " + this.dH);
        e.a("CaptureOnePreview");
        this.cc.a((t.a) new t.a() {
            public void a(Bitmap bitmap, long j) {
                e.b("CaptureOnePreview");
                if (f.this.as || f.this.dH == null) {
                    e.e("CameraManager", "setSwitchPreviewCb, onPreviewCaptured, mCameraSwitch is null");
                    return;
                }
                int O = f.this.O();
                final Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, bitmap.getWidth() / O, bitmap.getHeight() / O, false);
                f.this.dN.removeMessages(1);
                if (f.this.dN != null) {
                    f.this.dN.a(new Runnable() {
                        public void run() {
                            if (f.this.dH != null) {
                                f.this.dH.d = createScaledBitmap;
                                f.this.dH.f3069a = true;
                                if (f.this.dH.f3070b) {
                                    f.this.bJ();
                                }
                            }
                        }
                    });
                }
            }
        }, false, false, t.a.c);
        this.dH.c = true;
    }

    /* access modifiers changed from: private */
    public void bJ() {
        h hVar = this.dH;
        if (hVar == null || !hVar.f3069a || this.as) {
            e.d("CameraManager", "onSwitchPreviewData, invalid data");
            return;
        }
        e.a("CameraManager", "onSwitchPreviewData, getCurrentModeName: " + this.cj.l());
        Bitmap bitmap = this.dH.d;
        Bitmap a2 = Util.a(bitmap, 25.0f);
        if (!(this.cc == null || this.cc.c() == null)) {
            this.cc.c().a(a2, this.K);
        }
        if (bitmap != null) {
            bitmap.recycle();
        }
        bI();
        if (this.cc != null) {
            this.cj.b(2, false);
            this.cc.i(false);
            this.cc.j(false);
        }
    }

    private void a(int i2, boolean z2, boolean z3) {
        if (this.as || !this.bi) {
            e.e("CameraManager", "onCameraIdChange, mbPaused: " + this.as + ", mbFrameAvailable: " + this.bi);
            return;
        }
        if (this.cj.bX() && this.bP != null) {
            h(true);
            this.bP.edit().putString("pref_none_sat_ultra_wide_angle_key", "off").apply();
            h(false);
        }
        if (this.cj.bY() && this.bP != null) {
            h(true);
            this.bP.edit().putString("pref_none_sat_tele_angle_key", "off").apply();
            h(false);
        }
        e.e("CameraManager", "CameraTest Camera Switch Start, cameraId: " + i2);
        com.oppo.camera.perf.a.a("switch_camera");
        e(true);
        this.cc.Q(false);
        this.cc.d(false, false);
        this.cc.ak(true);
        if (this.cj.bx()) {
            this.cc.u(true);
        }
        this.U = 0;
        this.ce.p();
        j(3);
        if (z2 || z3) {
            if (this.dH == null) {
                this.dH = new h();
            }
            if (this.dH.f3069a) {
                bJ();
                return;
            }
            if (!this.dH.c) {
                R();
            }
            this.dH.f3070b = true;
            this.dN.removeMessages(1);
            this.dN.sendEmptyMessageDelayed(1, 2000);
            return;
        }
        i(i2);
        this.cc.Q(true);
        this.cc.d(true, true);
    }

    public void h(int i2) {
        String l2 = this.cj.l();
        a(l2, i2);
        SharedPreferences.Editor edit = this.bP.edit();
        edit.putString("pref_camera_mode_key", l2);
        edit.apply();
    }

    public void i(int i2) {
        e.a("CameraManager", "switchCamera, cameraId: " + i2 + ", mbPaused: " + this.as);
        this.cO = null;
        if (!this.as) {
            e.a("CameraManager", "startOperation, cameraId: " + i2);
            this.bt = this.K != i2;
            this.aK = this.K != i2;
            this.cc.b(i2, this.cj.l());
            this.cc.cg();
            this.cc.cq();
            this.cc.c(9, true);
            bp();
            this.bP.a((Context) this.bO, i2);
            this.cj.b(i2);
            h(i2);
            this.cj.C();
            n(false);
            this.cc.bk();
            this.cc.bm();
            this.cc.cv();
            this.cc.aJ();
            this.dN.a(new Runnable() {
                public void run() {
                    f.this.cc.h();
                    if (f.this.ce != null) {
                        f.this.ce.j(false);
                    }
                }
            });
            r(i2);
            this.cd.a(i2);
            A(this.cj.i("pref_camera_torch_mode_key"));
            this.cj.g(true);
            com.oppo.camera.ui.inverse.c.INS.setMaskAlpha(this.bO, false, false);
            this.ct.onSwitchCamera(a.c(i2));
            l(1);
        }
    }

    private void r(int i2) {
        e.a("CameraManager", "setCameraId, mCameraId: " + this.K + ", cameraId: " + i2);
        if (this.K != i2) {
            this.K = i2;
            this.ao = a.c(this.K);
            com.oppo.camera.ui.preview.a.n nVar = this.cd;
            if (nVar != null) {
                nVar.a(i2);
            }
            if (this.bP != null) {
                this.bP.a((Context) this.bO, this.K);
            }
        }
    }

    public void j(int i2) {
        e.a("CameraManager", "setCameraState, state: " + this.E + "->" + i2);
        this.E = i2;
    }

    /* access modifiers changed from: private */
    public boolean bK() {
        return this.aO && this.cp.isEmpty();
    }

    public boolean S() {
        return this.E == 1;
    }

    public boolean T() {
        return this.E == 0;
    }

    public boolean U() {
        return this.E == 2;
    }

    public boolean V() {
        return this.E == 3;
    }

    public void k(int i2) {
        this.av = i2;
        if (this.ce != null) {
            this.ce.e(i2);
        }
    }

    public boolean W() {
        return this.as;
    }

    public boolean X() {
        return this.bl;
    }

    public void a(Size size, Size size2, d.a aVar, int i2, int i3, int i4, boolean z2) {
        if (this.ce != null) {
            this.ce.j(false);
        }
        if (!this.cc.cU()) {
            this.cc.i(false);
        }
        this.cc.a((byte) 1, false);
        this.cc.k(true, false);
        this.cc.h();
        this.cc.bu();
        this.cc.a(size, size2, aVar, i2, i3, i4, z2);
        this.cc.j(false);
    }

    public void Y() {
        this.ba = true;
        a(true, false, false);
        ai();
        this.cc.j();
    }

    /* access modifiers changed from: private */
    public void bL() {
        this.cN.b();
        this.cN.a();
        this.cN.c(m() && br());
    }

    public void a(ApsTotalResult apsTotalResult) {
        if (this.as || this.aC || this.aA || this.bR == null) {
            e.e("CameraManager", "onPreviewCaptureResult, mOneCamera: " + this.bR + ", mbCaptureModeChanging: " + this.aC + ", mbSwitchingCamera: " + this.aA + ", mbPaused: " + this.as);
        } else if (apsTotalResult == null || apsTotalResult.getTotalResult() == null) {
            e.e("CameraManager", "onPreviewCaptureResult, totalResult: " + apsTotalResult);
        } else {
            CaptureResult totalResult = apsTotalResult.getTotalResult();
            int b2 = b(apsTotalResult);
            CaptureMsgData captureMsgData = this.bG;
            if (captureMsgData != null) {
                captureMsgData.mHdrScope = String.valueOf(apsTotalResult.get(ApsTotalResult.APS_HDR_SCOPE));
            }
            boolean z2 = false;
            if (b2 >= 0 && this.cj != null && this.cj.av() && !this.cj.T()) {
                if (!CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_PI_AI) || this.cj.aw()) {
                    s(b2);
                } else {
                    if (12 != b2) {
                        b2 = 0;
                    }
                    s(b2);
                }
            }
            Object a2 = c.a(totalResult, c.A);
            if (!(this.cc == null || a2 == null || !(a2 instanceof int[]))) {
                int[] iArr = (int[]) a2;
                if (iArr.length > 0) {
                    int i2 = iArr[0];
                    this.bs = i2 == 1;
                    if (this.bs) {
                        e.b("CameraManager", "onPreviewCaptureResult, apertureSwitchValue: " + i2);
                        this.cc.c().k(false);
                    } else {
                        this.cc.c().k(true);
                    }
                }
            }
            Object a3 = c.a(totalResult, c.F);
            if (a3 == null || !(a3 instanceof int[])) {
                this.bu = false;
            } else {
                int[] iArr2 = (int[]) a3;
                if ((iArr2.length > 0 ? iArr2[0] : 0) == 1) {
                    z2 = true;
                }
                this.bu = z2;
            }
            Object a4 = c.a(totalResult, c.G);
            if (a4 != null && (a4 instanceof Integer)) {
                a(((Integer) a4).intValue(), true);
            }
            Object a5 = c.a(totalResult, c.H);
            if (a5 != null && (a5 instanceof Integer)) {
                Integer num = (Integer) a5;
                if (2 == num.intValue() || 100 == num.intValue()) {
                    if (this.bO != null && !this.bO.isFinishing()) {
                        this.dN.a(new Runnable() {
                            public void run() {
                                if (f.this.bO != null && !f.this.bO.isFinishing()) {
                                    f.this.bO.finish();
                                }
                            }
                        });
                    } else {
                        return;
                    }
                }
            }
            if (this.cj != null) {
                this.cj.a(apsTotalResult);
            }
        }
    }

    private int b(ApsTotalResult apsTotalResult) {
        int[] iArr;
        CaptureResult totalResult = apsTotalResult.getTotalResult();
        if (AlgoSwitchConfig.getApsVersion() <= 2) {
            Object a2 = c.a(totalResult, c.ac);
            if (a2 == null || !(a2 instanceof int[]) || (iArr = (int[]) a2) == null || iArr.length <= 0) {
                return -1;
            }
            return iArr[0];
        } else if (apsTotalResult.get(ApsTotalResult.APS_AI_SCENE) != null) {
            return ((Integer) apsTotalResult.get(ApsTotalResult.APS_AI_SCENE)).intValue();
        } else {
            return -1;
        }
    }

    private void s(int i2) {
        if ((CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_PI_AI) && !this.cc.H(i2)) || ((!CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_AUTO_MICRO) && 18 == i2) || this.cc.cH())) {
            i2 = 0;
        }
        if (this.cc != null && this.dW != null && this.U != i2) {
            e.a("CameraManager", "updateAIScene, value: " + i2);
            t(i2);
            this.U = i2;
            this.cc.D(this.U);
            if (this.U > 0) {
                this.dW.b(i2, this.cc.G(i2), false);
                a("ai_scene", String.valueOf(this.U));
                return;
            }
            this.dW.b(0, false, false);
        }
    }

    private void t(int i2) {
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_PI_AI) && this.cc != null) {
            if (u(i2)) {
                this.cc.f(i2, !this.cj.bx());
            } else if (18 == i2) {
                this.cc.f(18, this.aI);
            }
        }
    }

    private boolean u(int i2) {
        return CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_HIGH_DEFINITION) ? 12 == i2 || 4 == i2 || 16 == i2 || 17 == i2 || 10 == i2 : 12 == i2 || 4 == i2;
    }

    public void b(boolean z2, boolean z3) {
        e.a("CameraManager", "setAEAFLocked, locked: " + z2 + ", update: " + z3);
        if (this.cj.T()) {
            e.a("CameraManager", "setAEAFLocked, isCapturing, so return!");
            return;
        }
        e.a("setAEAFLocked");
        if (this.cc != null) {
            if (z2) {
                this.av = 0;
                this.bO.runOnUiThread(new Runnable() {
                    public void run() {
                        if (f.this.cc != null) {
                            f.this.cc.bD();
                        }
                    }
                });
                if (b("pref_camera_flashmode_key") && "on".equals(this.bP.getString("pref_camera_flashmode_key", this.bO.getString(R.string.camera_flash_mode_default_value)))) {
                    SharedPreferences.Editor edit = this.bP.edit();
                    edit.putString("pref_camera_flashmode_key", "off");
                    edit.apply();
                    this.bO.runOnUiThread(new Runnable() {
                        public void run() {
                            if (f.this.cc != null) {
                                f.this.cc.f("pref_camera_flashmode_key");
                            }
                        }
                    });
                }
            } else {
                this.cc.bE();
            }
            if (this.ce != null) {
                this.ce.f(z2);
            }
        }
        com.oppo.camera.f.f fVar = this.bR;
        if (fVar != null) {
            fVar.a(z2, true);
            if (z3) {
                this.bR.a((f.c) null);
            }
        }
        e.b("setAEAFLocked");
    }

    public void Z() {
        if (this.aY && !this.aA) {
            this.cc.a((t.a) new t.a() {
                public void a(Bitmap bitmap, long j) {
                    com.oppo.camera.ui.preview.d.c(bitmap);
                }
            }, false, false, t.a.e);
        }
    }

    private void i(String str) {
        if (str != null && !str.equals(this.bF)) {
            e.a("CameraManager", "setCameraTriggerShutterType, shutterTriggerType: " + this.bF + " -> " + str);
            this.bF = str;
        }
    }

    /* access modifiers changed from: private */
    public void v(int i2) {
        if (Util.h("oplus.software.fingerprint.shutter")) {
            if (this.cw == null) {
                this.cw = (FingerprintManager) this.bO.getSystemService("fingerprint");
                this.Y = Util.j("KEYCODE_SYSTEM_FINGERPRINT_KEYMODE");
            }
            if (this.cw != null && "on".equals(this.bE)) {
                try {
                    this.cw.setFingerKeymode(i2);
                } catch (NoSuchMethodError unused) {
                    e.e("CameraManager", "setFingerKeymode, FingerprintManager NoSuchMethodError");
                }
                e.a("CameraManager", "setFingerKeymode, enable: " + i2);
            }
        }
    }

    public void p(boolean z2) {
        e.a("CameraManager", "onPause, mbSwitchingCamera: " + this.aA + ", mCameraId: " + this.K);
        v(0);
        com.oppo.camera.v.a.a().a((Context) this.bO, CameraStatisticsUtil.PORTRAIT_CAPTURE_MODE, (Object) 0);
        this.cV = 0;
        if (cE()) {
            SharedPreferences.Editor edit = this.bP.edit();
            edit.putString("last_camera_gesture_shutter_key", this.bP.getString("pref_camera_gesture_shutter_key", this.bO.getString(R.string.camera_gesture_shutter_default_value)));
            edit.apply();
        }
        this.as = true;
        this.bn = false;
        this.bh = false;
        this.bi = false;
        this.by = false;
        this.bz = false;
        this.db = false;
        this.dd = false;
        this.dC = false;
        b bVar = this.ch;
        if (bVar != null) {
            bVar.c();
        }
        if (!this.bm && !this.bl) {
            this.bt = true;
            if (this.cf != null) {
                this.cf.b(aQ());
            }
            cH();
            this.cc.cS();
        }
        ca();
        this.dl = System.currentTimeMillis();
        p(1);
        m(false);
        ApsService apsService = this.de;
        a(apsService != null && !apsService.isApsProcessing());
        this.cj.ad();
        bk();
        FossManager fossManager = this.cn;
        if (fossManager != null) {
            fossManager.enableFoss();
        }
        if (this.f2941co != null && at()) {
            this.f2941co.f();
        }
        f(false);
        this.aX = false;
        this.dH = null;
        this.av = 0;
        b(false, false);
        this.aG = false;
        this.cK = null;
        this.bs = false;
        this.dp = null;
        synchronized (this.i) {
            this.dn = 3;
        }
        this.dW.a((com.oppo.camera.t.a) null);
        if (this.cM != null && this.cM.b()) {
            n();
        }
        v(false);
        this.cO = null;
        this.dI = -1;
        u uVar = this.dM;
        if (uVar != null) {
            uVar.a();
            this.dM = null;
        }
        this.dN.removeMessages(9);
        this.dN.removeMessages(11);
        this.dN.removeMessages(22);
        this.dN.removeMessages(24);
        this.aB = false;
        this.cH.o();
        o oVar = this.cS;
        if (oVar != null) {
            oVar.k();
        }
        this.cj.af();
        an();
        this.aY = false;
        if (!z2) {
            l(false);
        }
        com.oppo.camera.n.b.a().c();
        com.oppo.camera.n.a.a().c();
        this.dN.removeCallbacksAndMessages((Object) null);
        Util.k();
        AsyncTask asyncTask = this.cl;
        if (asyncTask != null) {
            asyncTask.cancel(true);
            this.cl = null;
        }
        if (this.cM != null) {
            this.cM.c();
        }
        bO();
        if (this.cf != null) {
            this.cf.g();
        }
        if (this.ck != null) {
            this.cc.a().a((Runnable) new Runnable() {
                public void run() {
                    f.this.ck.e();
                }
            });
        }
        com.oppo.camera.ui.preview.a.n nVar = this.cd;
        if (nVar != null) {
            nVar.d(0);
        }
        this.cc.b(this.cj.f(), cD());
        long aZ2 = this.cc.aZ();
        this.cc.a(0);
        if (0 != aZ2) {
            a(aZ2, Util.a(this.cj.cX()), true);
        }
        if (D()) {
            this.cc.cA();
            if (this.cc.c() != null) {
                this.cc.c().u();
            }
        }
        this.dK.c();
        if (this.ce != null) {
            this.ce.c();
        }
        if (this.cg != null) {
            this.cg.onPause();
        }
        if (this.cu != null) {
            this.cu.d();
        }
        com.oppo.camera.u.d dVar = this.dx;
        if (dVar != null) {
            dVar.a(false);
        }
        v vVar = this.cN;
        if (vVar != null) {
            vVar.f();
        }
        if (this.aA) {
            com.oppo.camera.ui.inverse.c.INS.setMaskAlpha(this.bO, true, false);
        }
        com.oppo.camera.ui.menu.f.b(this.dX);
        this.U = 0;
        if (!this.bm) {
            h.a(this.bO.getApplicationContext()).f();
        } else if (this.ao || !"off".equals(this.cj.Q())) {
            h.a(this.bO.getApplicationContext()).g();
        }
        com.oppo.camera.g.a.a();
        e.a("CameraManager", "onPause X");
    }

    private void bM() {
        e.a("CameraManager", "exitOneCamera");
        j(4);
        this.cY = true;
        if (this.cj != null) {
            this.cj.bF();
        }
    }

    /* access modifiers changed from: private */
    public void w(int i2) {
        e.a("CameraManager", "closeImageReader, role: " + i2);
        this.bR.b(i2);
        p pVar = this.cT;
        if (pVar != null && 1 == i2) {
            pVar.x();
        }
        e.a("CameraManager", "closeImageReader X, role: " + i2);
    }

    private void bN() {
        this.af = System.currentTimeMillis();
        this.ah = 0;
        this.ai = 0;
        this.ag = 0;
        g();
        this.T = 0;
    }

    private void bO() {
        g();
        this.T = 0;
        this.af = 0;
        this.ag = 0;
        this.ah = 0;
        this.ai = 0;
    }

    public boolean aa() {
        if (!S() && (!T() || this.cH.y() != 2)) {
            if (!(this.cj != null ? this.cj.cP() : false)) {
                com.oppo.camera.f.f fVar = this.bR;
                if (fVar != null) {
                    fVar.m().post(new Runnable() {
                        public void run() {
                            if (f.this.cj != null) {
                                f.this.cj.c(false);
                            }
                        }
                    });
                }
                e.a("CameraManager", "onBackPressed, cameraState return");
                this.bV.p();
                return false;
            }
        }
        if (this.cc.bL() && !this.cj.be()) {
            e.a("CameraManager", "onBackPressed, mCameraUIManager return");
            this.bV.p();
            return false;
        } else if (this.f2941co != null && at()) {
            this.dm = VideoRecordMsgData.END_TYPE_NORMAL;
            B(0);
            this.f2941co.f();
            this.cc.a(true, false);
            this.cc.b(true, false);
            this.cc.c(true, false);
            this.cc.e(true, false);
            this.bV.p();
            return false;
        } else if (this.cj != null && this.cj.j()) {
            e.a("CameraManager", "onBackPressed, Capmode processing other,so return");
            this.bV.p();
            return false;
        } else if (!this.cZ) {
            return true;
        } else {
            e.a("CameraManager", "onBackPressed, Taking pictures, so return");
            this.bV.p();
            return false;
        }
    }

    /* access modifiers changed from: private */
    public void bP() {
        e.a("CameraManager", "backToLastMode");
        if (this.cc != null) {
            this.cc.cG();
        }
    }

    /* access modifiers changed from: private */
    public void bQ() {
        if (this.bO != null) {
            try {
                Intent intent = new Intent("coloros.intent.action.CODE_SCANNER");
                intent.setPackage("com.coloros.ocrscanner");
                intent.addFlags(268435456);
                intent.addFlags(32768);
                intent.putExtra("extra_from_package", this.bO.getPackageName());
                intent.putExtra("need_show_backicon", true);
                this.bO.startActivity(intent);
                if (this.bP != null) {
                    this.bP.edit().putBoolean("pref_entry_breeno_scan_key", true).apply();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* compiled from: CameraManager */
    private class q implements com.oppo.camera.ui.control.d {
        private q() {
        }

        public void a(String str) {
            e.a("CameraManager", "onModeTypeChanged, switch mode to: " + str);
            if ("more".equals(str)) {
                if (f.this.cN != null) {
                    f.this.cN.c(false);
                }
                f.this.bR();
                f.this.bH();
                if (f.this.cN != null) {
                    f.this.cN.c(false);
                }
                if (f.this.cc != null) {
                    f.this.cc.F(f.this.K);
                    f.this.cc.cK();
                }
                f.this.E(true);
                f.this.cc.a(R.string.camera_mode_more);
                androidx.preference.j.a((Context) f.this.bO).edit().putBoolean("more_menu_reddot_show", false).apply();
            } else if (!f.this.cj.l().equals(str)) {
                if (f.this.cc != null && f.this.cc.cH()) {
                    f.this.cc.cJ();
                    f.this.cc.ao(false);
                    f.this.a(false, false, 2);
                }
                f.this.d(str);
            } else if (f.this.cc != null && f.this.cc.cH()) {
                f.this.cc.cJ();
                f.this.cc.ao(true);
                f.this.a(true, true, -1);
            }
        }
    }

    /* access modifiers changed from: private */
    public void bR() {
        if (this.cj != null) {
            this.cj.cW();
        }
        if (this.ce != null) {
            this.ce.i(true);
            this.ce.f(8);
            this.ce.h(8);
            this.ce.i(8);
            if (!u() && cN()) {
                this.ce.k();
            }
        }
        if (this.cf != null) {
            this.cf.e(false);
        }
        a((Animation.AnimationListener) null);
    }

    /* access modifiers changed from: private */
    public void a(boolean z2, boolean z3, int i2) {
        if (this.cj != null) {
            this.cj.q(i2);
        }
        this.cc.D(this.U);
        if (this.cj != null && z2) {
            this.cj.L();
        }
        if (this.ce != null) {
            this.ce.i(false);
            if (u()) {
                this.ce.A();
                this.ce.f(0);
                this.ce.i(0);
            }
        }
        if (z3) {
            ci();
        }
        if (this.cN != null) {
            bL();
        }
    }

    public void ab() {
        SharedPreferences sharedPreferences = this.bQ;
        String str = null;
        if (sharedPreferences != null) {
            str = sharedPreferences.getString("sticker_switch", (String) null);
            e.a("CameraManager", "updateStickerModeFromRUS, stikerModeSwitch: " + str);
        }
        if (str == null) {
            return;
        }
        if (TextUtils.equals(str, "on")) {
            CameraConfig.setConfigBooleanValue(ConfigDataBase.KEY_STICKER, true);
        } else {
            CameraConfig.setConfigBooleanValue(ConfigDataBase.KEY_STICKER, false);
        }
    }

    public void ac() {
        ab();
        this.cd = new com.oppo.camera.ui.preview.a.o(this.bO);
        this.cd.a(this.dQ);
        this.cd.a(this.dP);
        this.cc = new com.oppo.camera.ui.g(this.bO, this.bP, this.dW);
        this.cc.v(this.cH.y());
        this.cc.a(this.ea);
        this.cc.a((com.oppo.camera.ui.control.d) new q());
        this.cc.a(this.dZ);
        this.cc.a((e.c) this.dL);
        this.cc.a(this.cd);
        if (-1 != this.L) {
            this.cc.u(a.a(0, this.L));
        }
        this.ce = new com.oppo.camera.ui.preview.k(this.bO, this.bP, this.dV);
        this.ce.a(this.cH.y());
        if (-1 != this.L) {
            this.ce.c(a.b(this.L));
        }
        this.cj.a(this.dT, (com.oppo.camera.ui.e) this.cc, this.cd);
        this.cj.j(this.cH.e());
        this.cj.a(this.bR);
        a(this.cH.e(), this.K);
        this.cd.a(this.cj.bR());
        this.cc.a(this.cj.bR());
        this.bM.open();
        e.a("CameraManager", "onCreate, open the block");
        this.cc.aE();
        this.ce.a();
        bh();
        this.dx.a();
        cu();
        com.oppo.camera.n.b.a().d();
        this.cd.a(this.K);
        if (this.cj.a()) {
            this.cc.o(this.bO.getString(com.oppo.camera.ui.menu.b.d.a(this.cj.l())));
            this.cc.ah(false);
        }
        this.aM = Util.h("oplus.software.vibrator_lmvibrator");
        this.cu = new o(this.bO, this.bP);
        this.cu.a(this.cH.y());
        this.cu.a((o.f) new x());
        this.cv = new com.oppo.camera.u.c(this.bO.getApplicationContext(), this.dU);
        this.aL = TextUtils.isEmpty(this.bP.getString("pref_none_sat_tele_angle_key", ""));
        if (this.cU != null) {
            this.cc.a(this.cU);
        }
    }

    public void a(Intent intent) {
        this.bt = true;
        if (this.cH.m() && !this.cW) {
            com.oppo.camera.v.c.a().a(new Runnable() {
                public void run() {
                    f.this.bW();
                }
            }, "clearLockDB");
            this.cW = true;
        }
        if (this.cj != null) {
            String e2 = this.cH.e();
            if (this.cj.a(e2) == null) {
                this.cj.j(e2);
            }
        }
    }

    /* access modifiers changed from: private */
    public void bS() {
        if (this.cj != null && !this.cj.g() && this.cj.i(CameraFunction.SAT_CAMERA)) {
            if (this.cj.bX() || CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_ZOOM_WIDE_ANGLE_OPEN_DEFAULT)) {
                this.by = true;
                this.bz = true;
                this.bP.edit().remove("pref_none_sat_ultra_wide_angle_key").apply();
            }
        }
    }

    /* access modifiers changed from: private */
    public void a(SharedPreferences sharedPreferences) {
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.remove("pref_video_blur_menu_state");
        edit.remove("pref_video_blur_menu_index");
        edit.remove("pref_video_blur_menu");
        edit.apply();
    }

    public void ad() {
        this.by = true;
    }

    public void ae() {
        if (this.bg) {
            this.dN.postAtFrontOfQueue(new Runnable() {
                public void run() {
                    f.this.bV.o();
                }
            });
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x00e5  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x011a A[SYNTHETIC, Splitter:B:31:0x011a] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x01ab  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x01b2  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x01bd  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x01c9  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0215 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0216  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void c(boolean r9, boolean r10) {
        /*
            r8 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "onResume, mbShouldRestoreDefaultMode: "
            r0.append(r1)
            com.oppo.camera.entry.b r1 = r8.cH
            boolean r1 = r1.d()
            r0.append(r1)
            java.lang.String r1 = ", mbShouldKeepCurrentMode: "
            r0.append(r1)
            com.oppo.camera.entry.b r1 = r8.cH
            boolean r1 = r1.b()
            r0.append(r1)
            java.lang.String r1 = ", sbMonkeyRunning: "
            r0.append(r1)
            boolean r1 = com.oppo.camera.util.Util.N()
            r0.append(r1)
            java.lang.String r1 = ", sbAutoTestMonkeyRunning: "
            r0.append(r1)
            boolean r1 = com.oppo.camera.util.Util.O()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "CameraManager"
            com.oppo.camera.e.a(r1, r0)
            com.oppo.camera.ui.g r0 = r8.cc
            if (r0 != 0) goto L_0x0047
            return
        L_0x0047:
            com.oppo.camera.u.c r0 = r8.cv
            if (r0 == 0) goto L_0x0050
            com.oppo.camera.u.c r0 = r8.cv
            r0.a()
        L_0x0050:
            com.oppo.camera.v r0 = r8.cN
            if (r0 == 0) goto L_0x0057
            r0.e()
        L_0x0057:
            com.oppo.camera.entry.b r0 = r8.cH
            r0.j()
            r8.bU()
            r8.bT()
            com.oppo.camera.util.b.a()
            android.os.ConditionVariable r0 = r8.bN
            r0.open()
            java.lang.String r0 = "normal"
            r8.dm = r0
            r0 = 0
            r8.cZ = r0
            r2 = 1
            r8.da = r2
            com.oppo.camera.k r3 = r8.bP
            java.lang.String r4 = "key_high_picture_size"
            boolean r3 = r3.getBoolean(r4, r0)
            r8.aH = r3
            com.oppo.camera.entry.b r3 = r8.cH
            int r3 = r3.y()
            if (r2 == r3) goto L_0x00a2
            boolean r3 = r8.cM()
            r8.da = r3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "onResume, mbAllowObtainExifLocation: "
            r3.append(r4)
            boolean r4 = r8.da
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            com.oppo.camera.e.a(r1, r3)
        L_0x00a2:
            com.oppo.camera.entry.b r1 = r8.cH
            boolean r1 = r1.k()
            com.oppo.camera.entry.b r3 = r8.cH
            boolean r3 = r3.d()
            com.oppo.camera.entry.b r4 = r8.cH
            java.lang.String r4 = r4.e()
            if (r3 == 0) goto L_0x00cb
            if (r1 != 0) goto L_0x00cb
            com.oppo.camera.entry.b r5 = r8.cH
            boolean r5 = r5.b()
            if (r5 != 0) goto L_0x00e2
            int r5 = r8.K
            if (r5 == 0) goto L_0x00c6
            r5 = r2
            goto L_0x00c7
        L_0x00c6:
            r5 = r0
        L_0x00c7:
            r8.r((int) r0)
            goto L_0x00e3
        L_0x00cb:
            if (r1 == 0) goto L_0x00e2
            int r5 = r8.K
            com.oppo.camera.entry.b r6 = r8.cH
            int r6 = r6.h()
            if (r5 == r6) goto L_0x00e2
            com.oppo.camera.entry.b r5 = r8.cH
            int r5 = r5.h()
            r8.r((int) r5)
            r5 = r2
            goto L_0x00e3
        L_0x00e2:
            r5 = r0
        L_0x00e3:
            if (r3 == 0) goto L_0x00f5
            r8.cG()
            com.oppo.camera.e.o r3 = r8.cj
            com.oppo.camera.entry.b r6 = r8.cH
            boolean r6 = r6.b()
            r3.s((boolean) r6)
            r8.bz = r0
        L_0x00f5:
            com.oppo.camera.ui.g r3 = r8.cc
            r3.bq()
            r8.cQ = r0
            com.oppo.camera.k r3 = r8.bP
            android.content.SharedPreferences$Editor r3 = r3.edit()
            int r6 = r8.K
            java.lang.String r6 = java.lang.Integer.toString(r6)
            java.lang.String r7 = "pref_camera_id_key"
            r3.putString(r7, r6)
            r3.apply()
            r6 = 0
            r8.ad = r6
            r8.bk = r0
            boolean r3 = r8.bp
            if (r3 != 0) goto L_0x0124
            com.oppo.camera.e.o r3 = r8.cj     // Catch:{ Exception -> 0x0120 }
            r3.ar()     // Catch:{ Exception -> 0x0120 }
            goto L_0x0124
        L_0x0120:
            r3 = move-exception
            r3.printStackTrace()
        L_0x0124:
            com.oppo.camera.e.o r3 = r8.cj
            java.lang.String r3 = r3.l()
            boolean r3 = r4.equals(r3)
            if (r3 == 0) goto L_0x0132
            if (r5 == 0) goto L_0x014a
        L_0x0132:
            r8.cF()
            com.oppo.camera.e.o r3 = r8.cj
            boolean r3 = r3.cN()
            if (r3 == 0) goto L_0x014a
            com.oppo.camera.f.f r3 = r8.bR
            if (r3 == 0) goto L_0x014a
            com.oppo.camera.f.h r3 = (com.oppo.camera.f.h) r3
            com.oppo.camera.e.a.a r3 = r3.A()
            r3.i()
        L_0x014a:
            com.oppo.camera.e.o r3 = r8.cj
            java.lang.String r3 = r3.l()
            com.oppo.camera.entry.b r4 = r8.cH
            java.lang.String r4 = r4.e()
            if (r3 == 0) goto L_0x0163
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x0163
            com.oppo.camera.e.o r3 = r8.cj
            r3.b((java.lang.String) r4)
        L_0x0163:
            int r3 = r8.K
            r8.a((java.lang.String) r4, (int) r3)
            com.oppo.camera.ui.preview.a.n r3 = r8.cd
            com.oppo.camera.e.o r4 = r8.cj
            com.oppo.camera.ui.preview.a.h$a r4 = r4.bR()
            r3.a((com.oppo.camera.ui.preview.a.h.a) r4)
            com.oppo.camera.ui.g r3 = r8.cc
            com.oppo.camera.e.o r4 = r8.cj
            com.oppo.camera.ui.preview.a.h$a r4 = r4.bR()
            r3.a((com.oppo.camera.ui.preview.a.h.a) r4)
            r8.o((int) r2)
            r8.r((boolean) r10)
            boolean r10 = r8.as
            r10 = r10 ^ r2
            r8.s((boolean) r10)
            android.app.Activity r10 = r8.bO
            android.content.Context r10 = r10.getApplicationContext()
            java.lang.String r3 = "phone"
            java.lang.Object r10 = r10.getSystemService(r3)
            android.telephony.TelephonyManager r10 = (android.telephony.TelephonyManager) r10
            int r10 = r10.getCallState()
            r8.X = r10
            r8.bj()
            android.hardware.foss.FossManager r10 = android.hardware.foss.FossManager.getInstance()
            r8.cn = r10
            android.hardware.foss.FossManager r10 = r8.cn
            if (r10 == 0) goto L_0x01ae
            r10.disableFoss()
        L_0x01ae:
            com.oppo.camera.u.d r10 = r8.dx
            if (r10 == 0) goto L_0x01b5
            r10.a((boolean) r2)
        L_0x01b5:
            com.oppo.camera.e.o r10 = r8.cj
            boolean r10 = r10.a()
            if (r10 == 0) goto L_0x01c9
            com.oppo.camera.ui.g r10 = r8.cc
            r10.K((boolean) r0)
            com.oppo.camera.e.o r10 = r8.cj
            java.lang.String r10 = r10.e()
            goto L_0x01d4
        L_0x01c9:
            com.oppo.camera.ui.g r10 = r8.cc
            r10.ai(r0)
            com.oppo.camera.e.o r10 = r8.cj
            java.lang.String r10 = r10.l()
        L_0x01d4:
            com.oppo.camera.ui.g r3 = r8.cc
            int r4 = r8.K
            com.oppo.camera.e.o r6 = r8.cj
            java.lang.String r7 = "pref_support_switch_camera"
            boolean r6 = r6.i((java.lang.String) r7)
            r3.a((int) r4, (java.lang.String) r10, (boolean) r6)
            com.oppo.camera.e.o r10 = r8.cj
            r10.f((boolean) r1)
            com.oppo.camera.ui.g r10 = r8.cc
            com.oppo.camera.e.o r3 = r8.cj
            java.lang.String r3 = r3.l()
            boolean r3 = r8.j((java.lang.String) r3)
            r10.ag(r3)
            com.oppo.camera.e.o r10 = r8.cj
            java.lang.String r3 = "pref_camera_torch_mode_key"
            boolean r10 = r10.i((java.lang.String) r3)
            r8.A((boolean) r10)
            com.oppo.camera.e.o r10 = r8.cj
            r10.g((boolean) r0)
            r8.bl = r0
            r8.as = r0
            boolean r10 = r8.bp
            if (r10 == 0) goto L_0x0213
            if (r1 == 0) goto L_0x0232
            if (r5 == 0) goto L_0x0232
        L_0x0213:
            if (r9 != 0) goto L_0x0216
            return
        L_0x0216:
            com.oppo.camera.entry.b r9 = r8.cH
            boolean r9 = r9.m()
            if (r9 == 0) goto L_0x0228
            com.oppo.camera.e.o r9 = r8.cj
            boolean r9 = r9.aO()
            if (r9 == 0) goto L_0x0228
            r9 = r2
            goto L_0x0229
        L_0x0228:
            r9 = r0
        L_0x0229:
            r8.t((boolean) r9)
            r8.l((int) r0)
            r8.af()
        L_0x0232:
            com.oppo.camera.v.b r9 = r8.dN
            r10 = 16
            r9.removeMessages(r10)
            com.oppo.camera.ui.g r9 = r8.cc
            r9.cq()
            android.app.Activity r9 = r8.bO
            android.content.Context r9 = r9.getApplicationContext()
            com.oppo.camera.h r9 = com.oppo.camera.h.a((android.content.Context) r9)
            r9.e()
            if (r5 == 0) goto L_0x025c
            java.lang.String r9 = "key_bubble_type_zoom_ultra_wide"
            boolean r9 = r8.b((java.lang.String) r9)
            if (r9 != 0) goto L_0x025c
            com.oppo.camera.ui.g r9 = r8.cc
            r10 = 9
            r9.c((int) r10, (boolean) r2)
        L_0x025c:
            com.oppo.camera.k r9 = r8.bP
            java.lang.String r10 = "pref_entry_breeno_scan_key"
            boolean r9 = r9.getBoolean(r10, r0)
            if (r9 == 0) goto L_0x0276
            com.oppo.camera.k r9 = r8.bP
            android.content.SharedPreferences$Editor r9 = r9.edit()
            android.content.SharedPreferences$Editor r9 = r9.remove(r10)
            r9.apply()
            r8.D((boolean) r0)
        L_0x0276:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.f.c(boolean, boolean):void");
    }

    public void q(boolean z2) {
        this.cH.a(z2);
    }

    private boolean a(com.oppo.camera.e.a aVar) {
        if (aVar.dt()) {
            return true;
        }
        if (!aVar.ff() || !CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_STAR_VIDEO)) {
            return false;
        }
        return true;
    }

    private boolean j(String str) {
        if (ApsConstant.REC_MODE_MICROSCOPE.equals(str)) {
            return true;
        }
        if (!CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_STAR_VIDEO) || !ApsConstant.REC_MODE_STAR_VIDEO.equals(str)) {
            return false;
        }
        return true;
    }

    private void bT() {
        if (this.bP != null) {
            String string = this.bP.getString("pref_camera_slogan_version_key", (String) null);
            if (!"1.1.0".equals(string)) {
                String string2 = this.bP.getString("pref_slogan_owner_key", (String) null);
                this.bP.edit().putString("pref_camera_slogan_version_key", "1.1.0").putString("pref_slogan_customize_key", string2).putString("pref_slogan_owner_key", (String) null).putString("pref_slogan_device_key", this.bP.getString("pref_camera_slogan_key", "off")).apply();
                e.b("CameraManager", "updateSloganFromOTA, preSloganVersion: " + string + ", currentVersion: " + "1.1.0");
            }
        }
    }

    private void bU() {
        String str;
        SharedPreferences sharedPreferences = this.bQ;
        if (sharedPreferences != null) {
            str = sharedPreferences.getString("video_blur_switch", "on");
            e.d("CameraManager", "updateVideoBlurFromRUS, videoBlurSwitch: " + str);
        } else {
            str = "on";
        }
        this.bv = TextUtils.equals(str, "on");
        this.cj.p(this.bv);
    }

    public void af() {
        e.a("CameraManager", "onResumeMessage");
        if (this.bh) {
            e.a("CameraManager", "onResumeMessage, return");
            return;
        }
        this.bh = true;
        y(false);
        h(false);
        g(false);
        d(false);
        k(false);
        i(false);
        j(false);
        d(-1);
        H();
        if (this.cc != null) {
            this.cc.b(!this.aC, false);
            e(false);
        }
        if (this.cf != null && ((this.cc != null && this.cc.aP()) || this.cj.bf())) {
            this.cf.b(8);
        }
        if (this.cc != null) {
            u(false);
            this.cc.e(this.cj.bf(), this.cj.be(), this.cj.bk());
            if (this.bm) {
                this.cj.cb();
            }
            if (this.ce != null) {
                this.ce.b();
            }
            if (b(CameraFunction.FACE_BEAUTY_PROCESS) && this.cH.f() && !aX()) {
                this.cj.f("beauty");
                int bl2 = this.cj.bl();
                this.cj.m(bl2);
                this.cc.m(bl2);
                if (!this.cj.bk()) {
                    this.cc.s(false);
                }
            } else if ((!this.cH.k() || !this.cj.aW()) && this.cH.y() != 3 && !this.cc.cm() && !this.cj.a() && !this.cj.bf() && !this.cj.bg() && !this.cc.C()) {
                this.cc.L(false);
            } else if (this.cj.a() && !this.cc.cm() && !this.cj.bf() && !this.cj.i("pref_headline_control_by_mode") && !this.cj.aV() && !this.cj.df()) {
                this.cc.o(this.bO.getString(com.oppo.camera.ui.menu.b.d.a(this.cj.l())));
                this.cc.ah(false);
            }
            if (1 == this.cH.y()) {
                if (!Util.v(this.bO) || this.cH.m()) {
                    this.cc.B(17);
                } else {
                    this.cc.A(17);
                }
            }
            if (1 == this.cH.y() && CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_BREENO_SCAN)) {
                if (this.cH.m()) {
                    this.cc.B(9);
                } else {
                    this.cc.A(9);
                }
            }
            if (this.cj.be()) {
                this.cc.m(false);
            }
            if (this.cj.i("pref_portrait_new_style_menu")) {
                this.cc.h("pref_portrait_new_style_menu");
            } else if (b("pref_filter_menu")) {
                this.cc.h("pref_filter_menu");
            } else if (b("pref_video_filter_menu")) {
                this.cc.h("pref_video_filter_menu");
            } else if (b("pref_night_filter_menu")) {
                this.cc.h("pref_night_filter_menu");
            }
            c(aN(), false);
        }
        if (this.cc != null) {
            if (b("pref_video_blur_menu")) {
                this.cc.h("pref_video_blur_menu");
            }
            if (b("pref_portrait_blur_menu")) {
                this.cc.h("pref_portrait_blur_menu");
            }
        }
        if (this.cu != null) {
            this.cu.b();
        }
        com.oppo.camera.ui.menu.f.a(this.dX);
        this.bV.p();
        if (this.cH.k() && this.cc != null) {
            this.cc.b(this.K, this.cj.l());
            String string = this.bO.getString(com.oppo.camera.ui.menu.b.d.a(this.cj.l()));
            String cl2 = this.cc.cl();
            if (this.cj.a() && !TextUtils.equals(string, cl2) && !this.cj.bf() && !this.cj.i("pref_headline_control_by_mode") && !this.cj.aV()) {
                this.cc.o(string);
            }
        }
        if (this.ch == null) {
            this.ch = new b(this.dT);
        }
        if (this.ck == null && CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPER_TEXT)) {
            this.ck = new com.oppo.camera.t.d(this.bO, this.dW);
            this.ck.a(this.G);
        }
        if (this.ck != null && b(CameraFunction.SUPER_TEXT)) {
            this.ck.b();
        }
        if (this.aM && this.cB == null) {
            this.cB = new aa(this.bO, true);
        }
        if (this.cB != null) {
            this.cB.a();
        }
        if ((this.bV.l() && !aX()) || !this.cH.f()) {
            this.cH.g();
        }
        w(false);
        e.a("CameraManager", "onResumeMessage, end");
    }

    /* access modifiers changed from: private */
    public void bV() {
        this.cf = new ac(this.bO, this.bP, this.dT, this.cc.b());
        this.cf.c(this.cc.b().getLayoutDirection());
        this.cf.a((ac.a) new j());
        this.cf.d(this.cc.b());
        this.cf.a(this.G, false);
    }

    public void b(float f2) {
        a(f2, false);
    }

    public void a(final float f2, boolean z2) {
        b(f2, z2);
        c(f2, true);
        this.dN.a(new Runnable() {
            public void run() {
                if (!f.this.as) {
                    if (f.this.cf == null) {
                        f.this.bV();
                    }
                    f.this.cf.a(f.this.aR(), f.this.aS(), f2, f.this.bS.d(), f.this.cj.cd(), true);
                    f.this.cf.e(true);
                    f.this.z(true);
                    f.this.ci();
                }
            }
        });
    }

    public void ag() {
        this.dN.a(new Runnable() {
            public void run() {
                if (!f.this.as) {
                    if (f.this.cg == null) {
                        f fVar = f.this;
                        TiltShiftManager unused = fVar.cg = new TiltShiftManager(fVar.bO, f.this.bP, f.this.dT, f.this.cc);
                    }
                    if (f.this.cc == null || !f.this.cj.aB()) {
                        f.this.cg.setCameraTiltShiftListener((TiltShiftManager.CameraTiltShiftListener) null);
                        return;
                    }
                    f.this.cg.setCameraTiltShiftListener(new i());
                    if (f.this.cc.aY() != null) {
                        f.this.cg.initialize(f.this.cc.aX(), f.this.cc.aY());
                    }
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void z(boolean z2) {
        int i2;
        Size aX2 = this.cc.aX();
        if (aX2 == null || 4 != Util.b(aX2.getWidth(), aX2.getHeight())) {
            i2 = this.cj.br();
        } else {
            i2 = this.cj.br() + ((int) (((double) Util.E()) * 0.11111111111111094d));
        }
        this.cf.a(i2, this.cf.i(), z2);
    }

    public void ah() {
        e.a("CameraManager", "onDestroy");
        this.dg.open();
        this.at = true;
        com.oppo.camera.v.a.b();
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_STICKER)) {
            com.oppo.camera.ui.preview.a.l.b((Context) this.bO).c((Context) this.bO);
        }
        SandBoxContentProvider.a(this.bO);
        if (this.bP != null) {
            cH();
        }
        if (this.ck != null) {
            this.ck.f();
            this.ck = null;
        }
        if (this.cu != null) {
            this.cu.e();
            this.cu = null;
        }
        b bVar = this.ch;
        if (bVar != null) {
            bVar.d();
            this.ch = null;
        }
        if (this.f2941co != null) {
            this.f2941co.f();
            this.f2941co.a();
            this.f2941co = null;
        }
        if (this.cp != null) {
            this.cp.setThumbNailProcessListener((ThumbnailProcessor.ThumbnailProcessListener) null);
            this.cp.onDestroy();
            this.cp = null;
        }
        if (this.cj != null) {
            this.cj.ah();
            this.cj = null;
        }
        if (this.cM != null) {
            this.cM.d();
            this.cM = null;
        }
        if (this.cc != null) {
            this.cc.aL();
            this.cc = null;
        }
        if (this.ce != null) {
            this.ce.d();
            this.ce = null;
        }
        if (this.cg != null) {
            this.cg.onDestroy();
            this.cg = null;
        }
        if (this.cf != null) {
            this.cf.k();
            this.cf = null;
        }
        if (this.cB != null) {
            this.cB.b();
            this.cB = null;
        }
        com.oppo.camera.u.d dVar = this.dx;
        if (dVar != null) {
            dVar.b();
            this.dx = null;
        }
        if (this.cv != null) {
            this.cv.c();
            this.cv = null;
        }
        bc();
        bl();
        ExecutorService executorService = this.k;
        if (executorService != null) {
            executorService.shutdown();
        }
        if (this.cb != null) {
            this.cb.e();
            this.cb = null;
        }
        com.oppo.camera.soloop.b bVar2 = this.cU;
        if (bVar2 != null) {
            bVar2.b();
            this.cU = null;
        }
        if (this.du != null) {
            this.du = null;
        }
        com.oppo.camera.ui.preview.a.n nVar = this.cd;
        if (nVar != null) {
            nVar.i();
            this.cd = null;
        }
        v vVar = this.cN;
        if (vVar != null) {
            vVar.g();
            this.cN = null;
        }
        this.aX = false;
        this.bO = null;
        this.bV = null;
        this.cy = null;
        if (z.c()) {
            com.oppo.camera.util.g.a().c();
        } else {
            com.oppo.camera.util.g.a().b();
        }
        com.oppo.camera.f.f fVar = this.bR;
        if (fVar != null) {
            ((h) fVar).A().i();
        }
    }

    /* access modifiers changed from: private */
    public void a(int i2, boolean z2) {
        e.a("CameraManager", "useIsoSetDisplay, messageType: " + i2 + ", delay: " + z2);
        e.a("useIsoSetDisplay");
        if (this.bj) {
            this.dN.removeMessages(3);
            this.dN.removeMessages(2);
            if (i2 != 95) {
                if (i2 == 96) {
                    if (z2) {
                        this.dN.sendEmptyMessageDelayed(2, 800);
                    } else if (a.d.a(this.bO.getApplicationContext().getContentResolver(), "oppo_in_camera_mode", 0) == 2) {
                        a.d.b(this.bO.getApplicationContext().getContentResolver(), "oppo_in_camera_mode", 0);
                    }
                }
            } else if (z2) {
                this.dN.sendEmptyMessageDelayed(3, 800);
            }
        }
        e.b("useIsoSetDisplay");
    }

    public void ai() {
        e.a("CameraManager", "switchUIByCurrentModeType, getCurrentModeName: " + this.cj.l());
        this.cc.b(this.cj.f());
        this.cc.a(this.cj.l(), this.cj.f(), cD());
    }

    private Size b(com.oppo.camera.e.a aVar) {
        if (aVar == null) {
            e.a("CameraManager", "getModePreviewSize, mode: " + aVar);
            return null;
        }
        aVar.i(this.K);
        aVar.a(this.bR);
        Size e2 = aVar.e(com.oppo.camera.f.a.a(this.cH.a(aVar.a(), this.K)));
        Size a2 = aVar.a(e2);
        if (a2 == null) {
            a2 = e2;
        }
        e.d("CameraManager", "getModePreviewSize, previewSize: " + a2.getWidth() + "x" + a2.getHeight());
        return a2;
    }

    public void a(Size size, boolean z2) {
        if (size != null) {
            int b2 = Util.b(size.getWidth(), size.getHeight());
            this.cc.d(b2, z2);
            e.b("CameraManager", "updateSettingControlBg, type: " + b2 + ", needControllerAnimation: " + z2);
        }
    }

    private boolean k(String str) {
        com.oppo.camera.e.a a2 = this.cj.a(str);
        Size b2 = b(a2);
        boolean z2 = !TextUtils.equals(a2.a(), this.cj.l());
        if (b2 == null) {
            e.e("CameraManager", "showCaptureModeChangeBlurAnim, null == newSize!");
            return false;
        }
        return a(this.cc.aX(), b2, this.cj.S(), a2.fk(), z2, 0, (d.a) this.dK);
    }

    /* access modifiers changed from: private */
    public boolean a(Size size, Size size2, int i2, int i3, boolean z2, int i4, d.a aVar) {
        int b2 = aVar != null ? aVar.b() : -1;
        e.a("CameraManager", "showBlurAnim, animType: " + b2 + ", mbBlurAnimRunning: " + this.ax);
        if (this.as) {
            return false;
        }
        v vVar = this.cN;
        if (vVar != null) {
            vVar.c(false);
        }
        if (!this.ax || this.cj.G()) {
            if (this.dM == null) {
                this.dM = new u(this);
            }
            if (E()) {
                this.dM.a(size, size2, z2, i4);
            }
            if (!this.dM.a(aVar, i2, i3, z2)) {
                return false;
            }
            k(true);
            d(b2);
            this.dN.removeMessages(13);
            this.dN.removeMessages(23);
            return true;
        }
        e.a("CameraManager", "showBlurAnim, return!");
        return false;
    }

    /* access modifiers changed from: private */
    public void bW() {
        e.a("CameraManager", "clearLockDB, mbLockDbCleared: " + this.cW + ", mActivity: " + this.bO);
        Uri parse = Uri.parse("content://com.oppo.gallery3d.open.provider/locked_pictures");
        if (this.bO != null) {
            try {
                this.bO.getApplicationContext().getContentResolver().delete(parse, "0==0", (String[]) null);
            } catch (Exception e2) {
                e.a("CameraManager", "clearLockDB ", (Throwable) e2);
            }
        }
    }

    public void r(boolean z2) {
        this.bc = z2;
        if (this.cc != null) {
            this.cc.O(this.bc);
        }
    }

    public void s(boolean z2) {
        if (((KeyguardManager) this.bO.getApplicationContext().getSystemService("keyguard")).isKeyguardLocked()) {
            this.bd = true;
            if (z2 && !this.cW) {
                com.oppo.camera.v.c.a().a(new Runnable() {
                    public void run() {
                        f.this.bW();
                    }
                }, "clearLockDB");
                t(true);
            }
        } else {
            this.bd = false;
        }
        if (this.cj != null) {
            this.cj.h(this.bd);
        }
    }

    public void t(boolean z2) {
        e.a("CameraManager", "updateLockDbClearFlag, clear: " + z2);
        this.cW = z2;
    }

    public boolean aj() {
        return this.bd;
    }

    /* compiled from: CameraManager */
    public class h {

        /* renamed from: a  reason: collision with root package name */
        public boolean f3069a = false;

        /* renamed from: b  reason: collision with root package name */
        public boolean f3070b = false;
        public boolean c = false;
        public Bitmap d = null;

        public h() {
        }
    }

    public void l(int i2) {
        if (this.cP == null) {
            this.cP = new C0082f();
        }
        aq();
        if (this.bR == null) {
            this.bR = MyApplication.a();
            com.oppo.camera.f.f fVar = this.bR;
            if (fVar != null) {
                fVar.a(this.cH.y());
                ((h) this.bR).A().i();
                ((h) this.bR).A().c(this.cH.e());
            } else {
                return;
            }
        }
        boolean z2 = false;
        int i3 = 1;
        if (b("pref_none_sat_tele_angle_key") && ck() && ((this.cj.aP() || this.cj.aQ()) && this.cf.a() > aS())) {
            h(true);
            this.bP.edit().putString("pref_none_sat_tele_angle_key", "off").apply();
            h(false);
        }
        int ak2 = ak();
        if (this.cj != null && aF() && this.cj.db() != null) {
            ak2 = this.cj.db().a();
        } else if (this.cj != null && this.cj.l() == null && ApsConstant.CAPTURE_MODE_MULTI_VIDEO.equals(this.cH.e())) {
            ak2 = ((h) this.bR).A().a();
        }
        e.b("CameraManager", "openCamera, properCameraId: " + ak2 + ", mCameraId: " + this.K);
        com.oppo.camera.u.d dVar = this.dx;
        if (dVar != null) {
            this.bR.a(dVar);
        }
        if (this.bO.getApplication() != null && (this.bO.getApplication() instanceof MyApplication)) {
            ((MyApplication) this.bO.getApplication()).f();
        }
        if (this.du == null && 3 == AlgoSwitchConfig.getApsVersion() && !CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SAT_USE_HAL)) {
            this.du = new w();
            this.du.a(this.bR);
        }
        ApsService apsService = this.de;
        if (apsService != null) {
            apsService.onBeforeOpenCamera();
        }
        this.V = i2;
        this.bS = com.oppo.camera.f.a.a(ak2);
        this.bR.a(ak2, this.cP, i2);
        this.L = ak2;
        this.cQ++;
        if (this.ce != null) {
            this.ce.c(com.oppo.camera.f.a.b(this.L));
        }
        if (this.cc != null) {
            this.cc.u(com.oppo.camera.f.a.a(0, this.L));
        }
        this.bp = true;
        com.oppo.camera.v.c.a().a(new Runnable() {
            public void run() {
                f.this.bS.a();
                f.this.bS.a(256);
                f.this.bS.a(32);
                e.e("CameraManager", "openCamera, preload finish");
            }
        }, "pre init keys");
        if (4 != i2 && 3 != i2) {
            if (1 != i2 || this.aK) {
                if (aF() || (this.cj != null && this.cj.l() == null && ApsConstant.CAPTURE_MODE_MULTI_VIDEO.equals(this.cH.e()))) {
                    z2 = true;
                }
                if (!z2) {
                    i3 = this.K;
                }
                Util.h(i3);
            }
        }
    }

    public int ak() {
        return this.cH.a(am(), this.K);
    }

    public void al() {
        com.oppo.camera.f.f fVar = this.bR;
        if (fVar != null) {
            fVar.f(am());
        }
    }

    public String am() {
        o oVar = this.cS;
        String str = (oVar == null || oVar.i() == null) ? null : this.cS.i().c;
        return str == null ? this.cH.e() : str;
    }

    public void an() {
        Util.i(this.K);
        if (U()) {
            this.bN.block(500);
        }
        com.oppo.camera.f.f fVar = this.bR;
        if (fVar != null) {
            fVar.k();
            this.bR.a(false, (CameraDevice) null, bY());
            this.dN.removeMessages(5);
        }
        synchronized (this.bI) {
            this.ar = false;
        }
        synchronized (this.bK) {
            this.au = false;
        }
        j(0);
        this.bp = false;
    }

    public void m(int i2) {
        e.a("CameraManager", "afterStartUpCamera, mbPaused: " + this.as + ", mFirstTimeInitialized: " + this.bo);
        if (!this.as) {
            this.bM.block();
            this.cj.b(this.K);
            this.cj.a(this.bR);
            this.ce.a(this.ao);
            k(0);
            b(false, false);
            if (this.as) {
                e.e("CameraManager", "afterStartUpCamera, activity paused, so return");
                return;
            }
            if (this.cH.k() && this.cj.i("key_beauty3d")) {
                this.bO.runOnUiThread(new Runnable() {
                    public void run() {
                        f.this.cj.b(13, true);
                    }
                });
            }
            n(i2);
            if (this.bg) {
                this.dN.a(new Runnable() {
                    public void run() {
                        if (!f.this.as) {
                            if (!f.this.bo) {
                                f.this.h();
                            } else {
                                f.this.j();
                            }
                        }
                    }
                });
            }
            this.cC.post(new Runnable() {
                public void run() {
                    if (!f.this.as) {
                        f.this.l(true);
                    }
                }
            });
        }
    }

    private void bX() {
        if (this.bT == null) {
            this.bT = new u();
        }
    }

    private boolean bY() {
        boolean z2 = !this.cY && this.cj.V();
        e.b("CameraManager", "needDelayClose, needDelay: " + z2);
        return z2;
    }

    /* access modifiers changed from: private */
    public f.e bZ() {
        if (this.bU == null) {
            this.bU = new g();
        }
        return this.bU;
    }

    /* compiled from: CameraManager */
    private final class g implements f.e {
        public void a(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, long j) {
        }

        private g() {
        }

        public void a(com.oppo.camera.f.d dVar, CaptureRequest.Builder builder, HashMap<String, f.C0084f> hashMap, int i) {
            if (f.this.cj != null) {
                f.this.cj.a(dVar, builder, hashMap, i);
            }
        }

        public void a() {
            if (f.this.bO != null && com.oppo.camera.ui.inverse.c.INS.isInverseColor(f.this.bO.hashCode())) {
                f.this.dN.a(new Runnable() {
                    public void run() {
                        if (!f.this.as) {
                            e.a("CameraManager", "startInverseMaskAnimation");
                            com.oppo.camera.ui.inverse.c.INS.startMaskScaleAnimation(f.this.bO);
                        }
                    }
                });
            }
        }

        public void b() {
            if (f.this.dN != null && f.this.cj != null && f.this.cj.R() && !com.oppo.camera.ui.inverse.c.INS.isInverseAble(f.this.bO)) {
                f.this.dN.a(new Runnable() {
                    public void run() {
                        if (!f.this.as) {
                            e.a("CameraManager", "openFrontFlash");
                            f.this.I();
                        }
                    }
                });
            }
        }

        public void c() {
            if (f.this.dN != null) {
                f.this.dN.a(new Runnable() {
                    public void run() {
                        if (!f.this.as && f.this.J() && !com.oppo.camera.ui.inverse.c.INS.isInverseAble(f.this.bO)) {
                            e.a("CameraManager", "closeFrontFlash");
                            f.this.cc.bS();
                            if (!f.this.cc.s() && !f.this.cc.C() && !f.this.cj.a() && !f.this.cj.cA()) {
                                f.this.cc.L(false);
                            }
                            f.this.cj.aY();
                        }
                    }
                });
            }
        }

        public void a(boolean z) {
            if (f.this.cr() && f.this.cj != null) {
                f.this.bR.a(f.this.cj.Q());
            }
            if (f.this.cf != null && f.this.cf.o()) {
                f.this.cf.i(false);
                if (f.this.cj != null) {
                    f.this.cj.cG();
                }
                f.this.aV();
            }
            if (f.this.cj != null && z) {
                f.this.j(1);
                f.this.cj.t(z);
            }
        }

        public void a(int i) {
            f.this.y(i);
        }

        public void a(TotalCaptureResult totalCaptureResult, CaptureRequest captureRequest) {
            e.a("onCaptureCompleted captureX CameraManager");
            com.oppo.camera.util.a.b(captureRequest, totalCaptureResult);
            if (f.this.cj == null) {
                e.e("CameraManager", "onCaptureCompleted, mModeManager is null");
                return;
            }
            f.aN(f.this);
            com.oppo.camera.f.d dVar = (com.oppo.camera.f.d) captureRequest.getTag();
            if (!(f.this.cj == null || f.this.bR == null || f.this.cj.i(-1) || dVar == null || !dVar.e)) {
                f.this.a(f.this.bR.a((CaptureResult.Key<?>) c.K, (CaptureResult) totalCaptureResult), ((Long) totalCaptureResult.get(CaptureResult.SENSOR_TIMESTAMP)).longValue());
            }
            Size size = null;
            if (f.this.dp != null) {
                size = f.this.cj.c(f.this.bS);
            }
            Size size2 = size;
            int i = 0;
            long j = 0;
            if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_MMCAMERA_PROFESSIONAL)) {
                i = f.this.cj.cZ();
                j = f.this.cj.da();
            }
            f fVar = f.this;
            TotalCaptureResult totalCaptureResult2 = totalCaptureResult;
            CaptureRequest captureRequest2 = captureRequest;
            CaptureMsgData unused = fVar.bG = com.oppo.camera.a.a.a(fVar.bG, totalCaptureResult2, captureRequest2, f.this.dp, size2, i, j);
            if (f.this.cj != null && f.this.cj.i(-1) && (!f.this.cj.bb() || totalCaptureResult.getFrameNumber() > f.this.am)) {
                f.this.a(captureRequest, (CaptureResult) totalCaptureResult);
            }
            if (f.this.cj != null && !f.this.cj.az()) {
                f.this.bN.open();
            }
            e.b("onCaptureCompleted captureX CameraManager");
        }

        public void a(CaptureRequest.Builder builder, int i, int i2, String[] strArr) {
            f.this.cj.a(builder, i, i2, strArr);
            if (f.this.de != null && f.this.du != null && f.this.cj.bT()) {
                String valueOf = String.valueOf(f.this.bR.c());
                f fVar = f.this;
                f.this.du.a(builder, valueOf, fVar.c(fVar.cf.a()));
            }
        }

        public int a(String str) {
            if (f.this.de == null || f.this.du == null || !f.this.cj.bT()) {
                return 0;
            }
            f fVar = f.this;
            return f.this.du.a(str, fVar.c(fVar.cf.a()));
        }

        public void d() {
            if (f.this.bR != null) {
                ((h) f.this.bR).C();
            }
        }
    }

    /* compiled from: CameraManager */
    private final class u implements f.d {
        private u() {
        }

        public void a(LinkedHashMap<String, f.C0084f> linkedHashMap, int i) {
            int i2;
            Size a2;
            Size a3;
            Size a4;
            Size a5;
            Size c;
            Size a6;
            Size a7;
            String str;
            Size a8;
            String str2;
            Size a9;
            String str3;
            Size d;
            Size b2;
            Size a10;
            Size a11;
            Size a12;
            Size a13;
            String str4;
            String str5;
            LinkedHashMap<String, f.C0084f> linkedHashMap2 = linkedHashMap;
            int i3 = i;
            if (f.this.bR == null || f.this.as) {
                e.e("CameraManager", "configOutputSessionSurface, mOneCamera: " + f.this.bR);
                return;
            }
            com.oppo.camera.e.a p = f.this.cT.p();
            String[] d2 = com.oppo.camera.f.a.d(p.a(f.this.K));
            Size a14 = f.this.cT.a(f.this.bS);
            if (f.this.cT.a("type_main_preview_frame") && a14 != null) {
                ImageReader a15 = f.this.bR.a("type_main_preview_frame", a14.getWidth(), a14.getHeight(), f.this.cT.c("type_main_preview_frame"), 20, f.this.cT.s());
                a15.setOnImageAvailableListener(f.this.bR.a(f.this.l), f.this.dq);
                if (p.w("type_main_preview_frame") && d2 != null) {
                    int[] e = f.this.cT.e(f.this.bS);
                    if (e != null) {
                        str5 = String.valueOf(e.length > 0 ? Integer.valueOf(e[0]) : null);
                    } else if (d2.length > 0) {
                        str5 = d2[0];
                    }
                    linkedHashMap2.put("type_main_preview_frame", new f.C0084f(a15.getSurface(), str5));
                }
                str5 = null;
                linkedHashMap2.put("type_main_preview_frame", new f.C0084f(a15.getSurface(), str5));
            } else if (!f.this.aF()) {
                linkedHashMap2.put("type_main_preview_frame", new f.C0084f(f.this.cc.aW()));
            }
            if (f.this.cT.a("type_sub_preview_frame") && (a13 = f.this.cT.a(f.this.bS, "type_sub_preview_frame")) != null) {
                ImageReader a16 = f.this.bR.a("type_sub_preview_frame", a13.getWidth(), a13.getHeight(), f.this.cT.d("type_sub_preview_frame"), 20, f.this.cT.s());
                a16.setOnImageAvailableListener(f.this.n, f.this.dq);
                if (p.w("type_sub_preview_frame") && d2 != null) {
                    int[] e2 = f.this.cT.e(f.this.bS);
                    if (e2 != null) {
                        str4 = String.valueOf(e2.length > 1 ? Integer.valueOf(e2[1]) : null);
                    } else if (d2.length > 1) {
                        str4 = d2[1];
                    }
                    linkedHashMap2.put("type_sub_preview_frame", new f.C0084f(a16.getSurface(), str4));
                }
                str4 = null;
                linkedHashMap2.put("type_sub_preview_frame", new f.C0084f(a16.getSurface(), str4));
            }
            if (f.this.cT.a("type_third_preview_frame") && (a12 = f.this.cT.a(f.this.bS, "type_third_preview_frame")) != null) {
                ImageReader a17 = f.this.bR.a("type_third_preview_frame", a12.getWidth(), a12.getHeight(), f.this.cT.d("type_third_preview_frame"), 20, f.this.cT.s());
                a17.setOnImageAvailableListener(f.this.p, f.this.dq);
                linkedHashMap2.put("type_third_preview_frame", new f.C0084f(a17.getSurface(), (!p.w("type_third_preview_frame") || d2 == null || d2.length <= 2) ? null : d2[2]));
            }
            if (f.this.cT.a("type_multi_main_preview_frame") && 1 == i3 && (a11 = f.this.cT.a(f.this.bS, "type_multi_main_preview_frame")) != null) {
                ImageReader a18 = f.this.bR.a("type_multi_main_preview_frame", a11.getWidth(), a11.getHeight(), f.this.cT.d("type_multi_main_preview_frame"), 20, 3);
                a18.setOnImageAvailableListener(f.this.A, f.this.dq);
                if (f.this.cj.o("type_multi_main_preview_frame")) {
                    linkedHashMap2.put("type_multi_main_preview_frame", new f.C0084f(a18.getSurface(), (d2 == null || d2.length <= 2) ? null : d2[2]));
                } else {
                    linkedHashMap2.put("type_multi_main_preview_frame", new f.C0084f(a18.getSurface()));
                }
            }
            if (!f.this.cT.a("type_multi_sub_preview_frame") || 2 != i3 || (a10 = f.this.cT.a(f.this.bS, "type_multi_sub_preview_frame")) == null) {
                i2 = 2;
            } else {
                i2 = 2;
                String str6 = "type_multi_sub_preview_frame";
                ImageReader a19 = ((h) f.this.bR).a("type_multi_sub_preview_frame", a10.getWidth(), a10.getHeight(), f.this.cT.d("type_multi_sub_preview_frame"), 20, f.this.cT.s(), i);
                a19.setOnImageAvailableListener(f.this.B, f.this.dq);
                if (f.this.cj.o(str6)) {
                    linkedHashMap2.put(str6, new f.C0084f(a19.getSurface(), (d2 == null || d2.length <= 2) ? null : d2[2]));
                } else {
                    linkedHashMap2.put(str6, new f.C0084f(a19.getSurface()));
                }
            }
            if (f.this.cT.a("type_preview_frame") && (b2 = f.this.cT.b(f.this.bS)) != null) {
                ImageReader a20 = f.this.bR.a("type_preview_frame", b2.getWidth(), b2.getHeight(), 35, 20, 3);
                a20.setOnImageAvailableListener(f.this.s, f.this.dt);
                linkedHashMap2.put("type_preview_frame", new f.C0084f(a20.getSurface()));
            }
            if (AlgoSwitchConfig.getSupportApsCapture() && f.this.cT.a("type_still_capture_raw") && (d = f.this.cT.d(f.this.bS)) != null) {
                int i4 = 3;
                if (f.this.cT.b("pref_support_raw_post_process") || f.this.cT.b("pref_super_raw_control_key")) {
                    i4 = 20;
                }
                ImageReader a21 = f.this.bR.a("type_still_capture_raw", d.getWidth(), d.getHeight(), 32, i4, 3);
                a21.setOnImageAvailableListener(f.this.t, f.this.bR.l());
                linkedHashMap2.put("type_still_capture_raw", new f.C0084f(a21.getSurface()));
            }
            if (AlgoSwitchConfig.getSupportApsCapture() && f.this.cT.a("type_still_capture_yuv_main") && (a9 = f.this.cT.a("type_still_capture_yuv_main", f.this.bS)) != null) {
                ImageReader a22 = f.this.bR.a("type_still_capture_yuv_main", a9.getWidth(), a9.getHeight(), "heic_10bits".equalsIgnoreCase(f.this.cT.i()) ? 34 : 35, 20, 3);
                a22.setOnImageAvailableListener(f.this.m, f.this.bR.l());
                if (p.w("type_still_capture_yuv_main") && d2 != null) {
                    int[] e3 = f.this.cT.e(f.this.bS);
                    if (e3 != null) {
                        str3 = String.valueOf(e3.length > 0 ? Integer.valueOf(e3[0]) : null);
                    } else if (d2.length > 0) {
                        str3 = d2[0];
                    }
                    linkedHashMap2.put("type_still_capture_yuv_main", new f.C0084f(a22.getSurface(), str3));
                }
                str3 = null;
                linkedHashMap2.put("type_still_capture_yuv_main", new f.C0084f(a22.getSurface(), str3));
            }
            if (AlgoSwitchConfig.getSupportApsCapture() && f.this.cT.a("type_still_capture_yuv_mfnr") && (a8 = f.this.cT.a("type_still_capture_yuv_mfnr", f.this.bS)) != null) {
                ImageReader a23 = f.this.bR.a("type_still_capture_yuv_mfnr", a8.getWidth(), a8.getHeight(), 35, 20, 3);
                a23.setOnImageAvailableListener(f.this.C, f.this.bR.l());
                if (p.w("type_still_capture_yuv_main") && d2 != null) {
                    int[] e4 = f.this.cT.e(f.this.bS);
                    if (e4 != null) {
                        str2 = String.valueOf(e4.length > 0 ? Integer.valueOf(e4[0]) : null);
                    } else if (d2.length > 0) {
                        str2 = d2[0];
                    }
                    linkedHashMap2.put("type_still_capture_yuv_mfnr", new f.C0084f(a23.getSurface(), str2));
                }
                str2 = null;
                linkedHashMap2.put("type_still_capture_yuv_mfnr", new f.C0084f(a23.getSurface(), str2));
            }
            if (AlgoSwitchConfig.getSupportApsCapture() && f.this.cT.a("type_still_capture_yuv_sub") && (a7 = f.this.cT.a("type_still_capture_yuv_sub", f.this.bS)) != null) {
                ImageReader a24 = f.this.bR.a("type_still_capture_yuv_sub", a7.getWidth(), a7.getHeight(), "heic_10bits".equalsIgnoreCase(f.this.cT.i()) ? 34 : 35, 20, 3);
                a24.setOnImageAvailableListener(f.this.o, f.this.bR.l());
                if (p.w("type_still_capture_yuv_sub") && d2 != null) {
                    int[] e5 = f.this.cT.e(f.this.bS);
                    if (e5 != null) {
                        str = String.valueOf(e5.length > 1 ? Integer.valueOf(e5[1]) : null);
                    } else if (d2.length > 1) {
                        str = d2[1];
                    }
                    linkedHashMap2.put("type_still_capture_yuv_sub", new f.C0084f(a24.getSurface(), str));
                }
                str = null;
                linkedHashMap2.put("type_still_capture_yuv_sub", new f.C0084f(a24.getSurface(), str));
            }
            if (AlgoSwitchConfig.getSupportApsCapture() && f.this.cT.a("type_still_capture_yuv_third") && (a6 = f.this.cT.a("type_still_capture_yuv_third", f.this.bS)) != null) {
                ImageReader a25 = f.this.bR.a("type_still_capture_yuv_third", a6.getWidth(), a6.getHeight(), "heic_10bits".equalsIgnoreCase(f.this.cT.i()) ? 34 : 35, 20, 3);
                a25.setOnImageAvailableListener(f.this.q, f.this.bR.l());
                linkedHashMap2.put("type_still_capture_yuv_third", new f.C0084f(a25.getSurface(), (!p.w("type_still_capture_yuv_third") || d2 == null || d2.length <= i2) ? null : d2[i2]));
            }
            if (f.this.cT.a("type_still_capture_jpeg") && (c = f.this.cT.c(f.this.bS)) != null) {
                ImageReader a26 = f.this.bR.a("type_still_capture_jpeg", c.getWidth(), c.getHeight(), 256, Util.d, 3);
                a26.setOnImageAvailableListener(f.this.u, f.this.bR.l());
                linkedHashMap2.put("type_still_capture_jpeg", new f.C0084f(a26.getSurface()));
            }
            if (AlgoSwitchConfig.getSupportApsPreview() && f.this.cT.a("type_video_frame") && (a5 = f.this.cT.a("type_video_frame", f.this.bS)) != null) {
                ImageReader a27 = f.this.bR.a("type_video_frame", a5.getWidth(), a5.getHeight(), f.this.cT.c("type_video_frame"), f.this.cT.t(), f.this.cT.u());
                a27.setOnImageAvailableListener(f.this.r, f.this.dq);
                linkedHashMap2.put("type_video_frame", new f.C0084f(a27.getSurface()));
            }
            if (AlgoSwitchConfig.getSupportApsCapture() && f.this.cT.a("type_tuning_data_yuv") && (a4 = f.this.cT.a("type_tuning_data_yuv", f.this.bS)) != null) {
                ImageReader a28 = f.this.bR.a("type_tuning_data_yuv", a4.getWidth(), a4.getHeight(), 842094169, 20, 3);
                a28.setOnImageAvailableListener(f.this.x, f.this.bR.l());
                linkedHashMap2.put("type_tuning_data_yuv", new f.C0084f(a28.getSurface(), (!f.this.cj.o("type_tuning_data_yuv") || d2 == null || d2.length <= 0) ? null : d2[0]));
            }
            if (AlgoSwitchConfig.getSupportApsCapture() && f.this.cT.a("type_tuning_data_raw") && (a3 = f.this.cT.a("type_tuning_data_raw", f.this.bS)) != null) {
                ImageReader a29 = f.this.bR.a("type_tuning_data_raw", a3.getWidth(), a3.getHeight(), 842094169, 20, 3);
                a29.setOnImageAvailableListener(f.this.x, f.this.bR.l());
                linkedHashMap2.put("type_tuning_data_raw", new f.C0084f(a29.getSurface()));
            }
            if (AlgoSwitchConfig.getSupportApsCapture() && f.this.cT.a("type_reprocess_data_yuv") && (a2 = f.this.cT.a("type_reprocess_data_yuv", f.this.bS)) != null) {
                ImageReader a30 = f.this.bR.a("type_reprocess_data_yuv", a2.getWidth(), a2.getHeight(), f.this.cT.c("type_reprocess_data_yuv"), 20, 3);
                a30.setOnImageAvailableListener(f.this.z, f.this.bR.l());
                linkedHashMap2.put("type_reprocess_data_yuv", new f.C0084f(a30.getSurface()));
            }
            f.this.cT.a((HashMap<String, f.C0084f>) linkedHashMap2);
            e.a("CameraManager", "configOutputSessionSurface, surfaces: " + linkedHashMap.toString());
        }

        public InputConfiguration a() {
            InputConfiguration inputConfiguration = null;
            if (f.this.bR == null || f.this.cT == null) {
                e.e("CameraManager", "getInputConfiguration, mOneCamera: " + f.this.bR);
                return null;
            }
            Size c = f.this.cT.c(f.this.bS);
            if (32 == f.this.cT.k()) {
                c = f.this.cT.d(f.this.bS);
            }
            if (f.this.cT.h() && c != null) {
                inputConfiguration = new InputConfiguration(c.getWidth(), c.getHeight(), f.this.cT.k());
            }
            e.e("CameraManager", "getInputConfiguration, configuration: " + inputConfiguration);
            return inputConfiguration;
        }

        public boolean a(CaptureRequest captureRequest, final int i) {
            if (f.this.bR == null || f.this.as || f.this.at) {
                e.e("CameraManager", "onSessionConfigured, Camera closed, aborting");
                return false;
            }
            e.a("CameraManager", "onSessionConfigured, cameraRole: " + i);
            f.this.dN.a(new Runnable() {
                public void run() {
                    if (f.this.bO != null && !f.this.bO.isFinishing()) {
                        boolean z = false;
                        f.this.a(false, i);
                        if (f.this.b("key_support_decrease_brightness")) {
                            f.this.by();
                        }
                        if (Camera.m && Camera.o) {
                            f.this.bs();
                        } else if (Camera.l && Camera.n) {
                            f.this.bt();
                        }
                        if (f.this.k()) {
                            String string = f.this.bP.getString("pref_camera_gesture_shutter_key", f.this.bO.getString(R.string.camera_gesture_shutter_default_value));
                            if (f.this.dW.g("pref_camera_gesture_shutter_key") && string.equals("on") && f.this.cE() && f.this.cV != 2) {
                                byte unused = f.this.cV = (byte) 1;
                            }
                            f fVar = f.this;
                            if (f.this.cV == 1) {
                                z = true;
                            }
                            fVar.b(z);
                            byte unused2 = f.this.cV = (byte) 2;
                        } else if (f.this.cM != null && f.this.cM.b()) {
                            f.this.n();
                        }
                        if (f.this.m()) {
                            f.this.l();
                        }
                    }
                }
            });
            e.a("setRepeatingRequest");
            boolean unused = f.this.aJ = false;
            boolean unused2 = f.this.db = false;
            ((h) f.this.bR).a(f.this.dR, i);
            e.b("setRepeatingRequest");
            f.this.x(i);
            f.this.cT.l();
            synchronized (f.this.j) {
                f.this.a(f.this.di);
            }
            f.this.dg.block();
            e.a("CameraManager", "onSessionConfigured, unlock");
            if (1 == i) {
                f fVar = f.this;
                fVar.a(3, fVar.di);
            }
            if (f.this.cS != null) {
                f.this.cS.e();
            }
            if (f.this.db) {
                f.this.cb();
            }
            return true;
        }

        public void b() {
            e.b("CameraManager", "onSessionConfigureFailed");
            f.this.dN.a(new Runnable() {
                public void run() {
                    f.this.j(0);
                }
            });
            if (f.this.D()) {
                f.this.cc.cA();
            }
        }

        public void a(com.oppo.camera.f.d dVar, int i) {
            e.b("CameraManager", "onSessionClosed, role: " + i);
            if (!(f.this.cc == null || f.this.cc.c() == null)) {
                f.this.cc.c().e(i);
            }
            if (2 != i) {
                f.this.dN.a(new Runnable() {
                    public void run() {
                        f.this.j(0);
                        boolean unused = f.this.bi = false;
                    }
                });
                if (f.this.cS != null) {
                    f.this.cS.d();
                }
                if (!f.this.as && 1 == f.this.V && f.this.ao && Util.h("oplus.software.motor_support")) {
                    h.a((Context) f.this.bO).b(f.this.cH.a(f.this.cj.l(), f.this.K));
                }
                if (f.this.de != null) {
                    f.this.de.sessionClosed(true);
                }
                if (f.this.du != null) {
                    f.this.du.a((ApsTotalResult) null);
                }
                f.this.ca();
                boolean unused = f.this.bu = false;
            }
        }

        public void a(int i) {
            if (f.this.aF()) {
                f.this.x(i);
            }
        }

        public Range<Integer> c() {
            return f.this.cT.e();
        }
    }

    /* access modifiers changed from: private */
    public void x(int i2) {
        if (!aF()) {
            com.oppo.camera.f.f fVar = this.bR;
            fVar.a("type_main_preview_frame", fVar.a(this.l), this.dq);
            this.bR.a("type_sub_preview_frame", this.n, this.dq);
            this.bR.a("type_third_preview_frame", this.p, this.dq);
            this.bR.a("type_video_frame", this.r, this.dq);
        } else if (1 == i2) {
            this.bR.a("type_multi_main_preview_frame", this.A, this.dq);
        } else {
            ((h) this.bR).a("type_multi_sub_preview_frame", this.B, this.dq, i2);
        }
    }

    /* access modifiers changed from: private */
    public void y(int i2) {
        if (1 == i2) {
            this.bR.a("type_main_preview_frame", (ImageReader.OnImageAvailableListener) null, (Handler) null);
            this.bR.a("type_sub_preview_frame", (ImageReader.OnImageAvailableListener) null, (Handler) null);
            this.bR.a("type_third_preview_frame", (ImageReader.OnImageAvailableListener) null, (Handler) null);
            this.bR.a("type_multi_main_preview_frame", (ImageReader.OnImageAvailableListener) null, (Handler) null);
            this.bR.a("type_video_frame", (ImageReader.OnImageAvailableListener) null, (Handler) null);
            return;
        }
        ((h) this.bR).a("type_multi_sub_preview_frame", (ImageReader.OnImageAvailableListener) null, (Handler) null, 2);
    }

    /* access modifiers changed from: private */
    public void ca() {
        com.oppo.camera.f.f fVar = this.bR;
        if (fVar != null) {
            fVar.y();
        }
        if (this.cf != null) {
            this.cf.i(false);
        }
    }

    /* access modifiers changed from: private */
    public void a(ApsInitParameter apsInitParameter) {
        apsInitParameter.mVendorTags = this.bS.K();
        String q2 = this.cT.q();
        apsInitParameter.setParameter(ParameterKeys.KEY_CAPTURE_MODE, q2);
        apsInitParameter.setParameter(ParameterKeys.KEY_CAMERA_FEATURE, this.cT.c());
        apsInitParameter.setParameter(ParameterKeys.KEY_CAMERA_ID, String.valueOf(this.K));
        ApsParameters.Key key = ParameterKeys.KEY_LOGIC_CAMERA_ID;
        int i2 = this.L;
        if (-1 == i2) {
            i2 = this.cH.a(q2, this.K);
        }
        apsInitParameter.setParameter(key, Integer.valueOf(i2));
        apsInitParameter.setParameter(ParameterKeys.KEY_HIGHT_PICTURE_SIZE_ENABLE, ParameterKeys.getFlagState(this.cT.f()));
        apsInitParameter.setParameter(ParameterKeys.KEY_OPERATION_MODE, String.valueOf(this.cT.g()));
        apsInitParameter.setParameter(ParameterKeys.KEY_PREVIEW_SIZE, this.cT.a(this.bS));
        apsInitParameter.setParameter(ParameterKeys.KEY_VIDEO_SIZE, this.cT.a("type_video_frame", this.bS));
        String str = "1";
        apsInitParameter.setParameter(ParameterKeys.KEY_IS_VIDEO_3HDR_10BIT, this.cT.v() ? str : "0");
        ApsParameters.Key<String> key2 = ParameterKeys.KEY_10_BITS_ENABLE;
        if (!this.cT.w()) {
            str = "0";
        }
        apsInitParameter.setParameter(key2, str);
        apsInitParameter.setParameter(ParameterKeys.KEY_IS_FROM_MAIN_MENU_APP, Boolean.valueOf(bd()));
    }

    /* access modifiers changed from: private */
    public void c(ApsTotalResult apsTotalResult) {
        d(apsTotalResult);
        if (this.du != null) {
            this.du.a(apsTotalResult);
        }
        if (!(this.cj == null || this.du == null || !this.cj.bT())) {
            this.du.a();
        }
        a(apsTotalResult.getTotalResult());
    }

    /* access modifiers changed from: private */
    public void d(ApsTotalResult apsTotalResult) {
        Face[] faceArr;
        if (apsTotalResult == null || apsTotalResult.getTotalResult() == null) {
            e.e("CameraManager", "onReceivePreviewCaptureResult, invalid totalResult: " + apsTotalResult);
            return;
        }
        CaptureResult totalResult = apsTotalResult.getTotalResult();
        Face[] faceArr2 = (Face[]) totalResult.get(CaptureResult.STATISTICS_FACES);
        com.oppo.camera.f.f fVar = this.bR;
        byte[] bArr = null;
        a(faceArr2, fVar != null ? fVar.a((CaptureResult.Key<?>) c.K, totalResult) : null);
        if (!(this.cj == null || !this.cj.ci() || this.ce == null || this.bR == null)) {
            this.ce.a(this.bR.a((CaptureResult.Key<?>) c.m, totalResult));
        }
        try {
            a((int[]) totalResult.get(c.af));
            if (this.ch != null) {
                this.ch.a((int[]) totalResult.get(c.g));
            }
        } catch (IllegalArgumentException unused) {
        }
        if (at()) {
            this.f2941co.a(c(aN()), faceArr2, this.G);
        }
        boolean z2 = false;
        if (this.cc != null) {
            this.cc.S(false);
        }
        Object a2 = c.a(totalResult, c.K);
        p pVar = this.cT;
        if (pVar != null && pVar.b("key_beauty3d_main_face_detect") && a2 != null && (a2 instanceof int[])) {
            int[] iArr = (int[]) a2;
            if (iArr.length >= 3) {
                e.a("CameraManager", "onReceivePreviewCaptureResult, mainFaceIndex: " + iArr[2]);
                if (this.cc != null) {
                    this.cc.S(true);
                    this.cc.w(iArr[2]);
                }
            }
        }
        Long l2 = (Long) totalResult.get(CaptureResult.SENSOR_TIMESTAMP);
        if (!(this.bR == null || this.cj == null || this.cj.bp() == 0)) {
            a(this.bR.a((CaptureResult.Key<?>) c.K, totalResult), l2.longValue());
        }
        Object a3 = c.a(totalResult, c.I);
        if (a3 != null && (a3 instanceof byte[])) {
            bArr = (byte[]) a3;
        }
        com.oppo.camera.ui.preview.a.n nVar = this.cd;
        if (nVar != null) {
            nVar.a(bArr);
            this.cd.a(l2 != null ? l2.longValue() : 0);
        }
        if (this.cT == null || !b("key_support_show_no_face")) {
            if (this.cc != null) {
                this.cc.bG();
            }
        } else if (this.cc != null) {
            if (!this.aY || !((faceArr = this.bW) == null || faceArr.length == 0)) {
                this.cc.bG();
            } else {
                this.cc.bF();
            }
        }
        if (this.cc != null) {
            if (b("pref_face_detection_key") && this.cj != null) {
                boolean z3 = !this.aG && !this.cc.ba() && S() && !D() && this.cj.bI();
                if ((this.ce != null && (!z3 || !this.ce.y())) || this.cj.ci()) {
                    this.dN.removeMessages(13);
                    this.dN.obtainMessage(13, Boolean.valueOf(z3)).sendToTarget();
                }
            }
            if (!Util.p() || !b(CameraFunction.AIS_SNAPSHOT) || this.bx) {
                int[] iArr2 = (int[]) totalResult.get(c.R);
                Integer num = (Integer) totalResult.get(CaptureResult.CONTROL_AF_STATE);
                Integer num2 = (Integer) totalResult.get(CaptureResult.CONTROL_AF_MODE);
                if (!(this.ce == null || num == null || num2 == null)) {
                    this.ce.a(num.intValue(), num2.intValue(), iArr2, this.E, -1);
                }
            }
            if (!com.oppo.camera.ui.menu.f.a() && S() && !D()) {
                z2 = true;
            }
            if (!z2 || this.ce == null || !this.ce.y()) {
                this.dN.removeMessages(23);
                this.dN.obtainMessage(23, Boolean.valueOf(z2)).sendToTarget();
            }
            a(apsTotalResult);
        }
    }

    /* access modifiers changed from: private */
    public void cb() {
        if (this.cc != null && D()) {
            this.cc.cB();
            if (!this.cS.a()) {
                this.cc.cA();
                if (this.cc.c() != null) {
                    this.cc.c().u();
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0132, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0134, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(int r10, com.oppo.camera.aps.adapter.ApsInitParameter r11) {
        /*
            r9 = this;
            java.lang.Object r0 = r9.j
            monitor-enter(r0)
            com.oppo.camera.aps.service.ApsService r1 = r9.de     // Catch:{ all -> 0x0135 }
            if (r1 == 0) goto L_0x0133
            r1 = 3
            if (r1 != r10) goto L_0x001a
            r1 = 2
            int r2 = com.oppo.camera.aps.config.AlgoSwitchConfig.getApsVersion()     // Catch:{ all -> 0x0135 }
            if (r1 != r2) goto L_0x001a
            java.lang.String r10 = "CameraManager"
            java.lang.String r11 = "initAPS AlgoSwitchConfig.APS_VERSION_2 don't initialize the APS preview process"
            com.oppo.camera.e.e(r10, r11)     // Catch:{ all -> 0x0135 }
            monitor-exit(r0)     // Catch:{ all -> 0x0135 }
            return
        L_0x001a:
            com.oppo.camera.aps.adapter.ApsParameters$Key<java.lang.String> r1 = com.oppo.camera.aps.constant.ParameterKeys.KEY_CAMERA_ID     // Catch:{ all -> 0x0135 }
            java.lang.Object r1 = r11.get(r1)     // Catch:{ all -> 0x0135 }
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1     // Catch:{ all -> 0x0135 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x0135 }
            if (r1 == 0) goto L_0x002b
            r9.a((com.oppo.camera.aps.adapter.ApsInitParameter) r11)     // Catch:{ all -> 0x0135 }
        L_0x002b:
            com.oppo.camera.aps.adapter.ApsInitParameter r1 = new com.oppo.camera.aps.adapter.ApsInitParameter     // Catch:{ all -> 0x0135 }
            r1.<init>()     // Catch:{ all -> 0x0135 }
            java.util.HashMap r2 = new java.util.HashMap     // Catch:{ all -> 0x0135 }
            java.util.Map r3 = r11.mParameterMap     // Catch:{ all -> 0x0135 }
            r2.<init>(r3)     // Catch:{ all -> 0x0135 }
            r1.mParameterMap = r2     // Catch:{ all -> 0x0135 }
            java.lang.String[] r2 = r11.mVendorTags     // Catch:{ all -> 0x0135 }
            java.lang.String[] r11 = r11.mVendorTags     // Catch:{ all -> 0x0135 }
            int r11 = r11.length     // Catch:{ all -> 0x0135 }
            java.lang.Object[] r11 = java.util.Arrays.copyOf(r2, r11)     // Catch:{ all -> 0x0135 }
            java.lang.String[] r11 = (java.lang.String[]) r11     // Catch:{ all -> 0x0135 }
            r1.mVendorTags = r11     // Catch:{ all -> 0x0135 }
            boolean r11 = r9.at     // Catch:{ all -> 0x0135 }
            if (r11 != 0) goto L_0x0131
            com.oppo.camera.e.o r11 = r9.cj     // Catch:{ all -> 0x0135 }
            if (r11 == 0) goto L_0x0131
            com.oppo.camera.aps.adapter.ApsParameters$Key<java.util.Set<java.lang.String>> r11 = com.oppo.camera.aps.constant.ParameterKeys.KEY_UNINIT_ALGOS     // Catch:{ all -> 0x0135 }
            java.util.Set r2 = r9.ao()     // Catch:{ all -> 0x0135 }
            r1.setParameter(r11, r2)     // Catch:{ all -> 0x0135 }
            com.oppo.camera.e.o r11 = r9.cj     // Catch:{ all -> 0x0135 }
            android.view.Surface r11 = r11.cw()     // Catch:{ all -> 0x0135 }
            r1.mVideoSurface = r11     // Catch:{ all -> 0x0135 }
            r1.mApsModule = r10     // Catch:{ all -> 0x0135 }
            com.oppo.camera.aps.adapter.ApsParameters$Key<java.lang.String> r10 = com.oppo.camera.aps.constant.ParameterKeys.KEY_CAMERA_FEATURE     // Catch:{ all -> 0x0135 }
            java.lang.Object r10 = r1.get(r10)     // Catch:{ all -> 0x0135 }
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10     // Catch:{ all -> 0x0135 }
            boolean r10 = android.text.TextUtils.isEmpty(r10)     // Catch:{ all -> 0x0135 }
            if (r10 == 0) goto L_0x0078
            com.oppo.camera.aps.adapter.ApsParameters$Key r10 = com.oppo.camera.aps.constant.ParameterKeys.KEY_CAPTURE_MODE     // Catch:{ all -> 0x0135 }
            java.lang.Object r10 = r1.get(r10)     // Catch:{ all -> 0x0135 }
            java.lang.String r10 = (java.lang.String) r10     // Catch:{ all -> 0x0135 }
            goto L_0x0080
        L_0x0078:
            com.oppo.camera.aps.adapter.ApsParameters$Key<java.lang.String> r10 = com.oppo.camera.aps.constant.ParameterKeys.KEY_CAMERA_FEATURE     // Catch:{ all -> 0x0135 }
            java.lang.Object r10 = r1.get(r10)     // Catch:{ all -> 0x0135 }
            java.lang.String r10 = (java.lang.String) r10     // Catch:{ all -> 0x0135 }
        L_0x0080:
            r2 = r10
            com.oppo.camera.aps.adapter.ApsParameters$Key<java.lang.String> r10 = com.oppo.camera.aps.constant.ParameterKeys.KEY_CAMERA_ID     // Catch:{ all -> 0x0135 }
            java.lang.Object r10 = r1.get(r10)     // Catch:{ all -> 0x0135 }
            java.lang.String r10 = (java.lang.String) r10     // Catch:{ all -> 0x0135 }
            int r3 = java.lang.Integer.parseInt(r10)     // Catch:{ all -> 0x0135 }
            java.lang.String r10 = "commonVideoSatHal"
            boolean r10 = r10.equals(r2)     // Catch:{ all -> 0x0135 }
            r11 = 0
            r4 = 1
            if (r10 != 0) goto L_0x00ce
            java.lang.String r10 = "4kVideo"
            boolean r10 = r10.equals(r2)     // Catch:{ all -> 0x0135 }
            if (r10 != 0) goto L_0x00ce
            java.lang.String r10 = "liveHDR"
            boolean r10 = r10.equals(r2)     // Catch:{ all -> 0x0135 }
            if (r10 != 0) goto L_0x00ce
            java.lang.String r10 = "ultraNight"
            boolean r10 = r10.equals(r2)     // Catch:{ all -> 0x0135 }
            if (r10 != 0) goto L_0x00ce
            java.lang.String r10 = "aiEnhancement"
            boolean r10 = r10.equals(r2)     // Catch:{ all -> 0x0135 }
            if (r10 != 0) goto L_0x00ce
            java.lang.String r10 = "commonVideo"
            boolean r10 = r10.equals(r2)     // Catch:{ all -> 0x0135 }
            if (r10 == 0) goto L_0x00c1
            if (r4 == r3) goto L_0x00ce
        L_0x00c1:
            java.lang.String r10 = "fastVideo"
            boolean r10 = r10.equals(r2)     // Catch:{ all -> 0x0135 }
            if (r10 == 0) goto L_0x00cc
            if (r4 != r3) goto L_0x00cc
            goto L_0x00ce
        L_0x00cc:
            r7 = r11
            goto L_0x00cf
        L_0x00ce:
            r7 = r4
        L_0x00cf:
            java.lang.String r10 = "slowVideo"
            boolean r10 = r10.equals(r2)     // Catch:{ all -> 0x0135 }
            if (r10 == 0) goto L_0x00db
            if (r3 != 0) goto L_0x00db
            r8 = r4
            goto L_0x00dc
        L_0x00db:
            r8 = r11
        L_0x00dc:
            com.oppo.camera.aps.adapter.ApsParameters$Key r10 = com.oppo.camera.aps.constant.ParameterKeys.KEY_PREVIEW_SIZE     // Catch:{ all -> 0x0135 }
            java.lang.Object r10 = r1.get(r10)     // Catch:{ all -> 0x0135 }
            r4 = r10
            android.util.Size r4 = (android.util.Size) r4     // Catch:{ all -> 0x0135 }
            com.oppo.camera.aps.adapter.ApsParameters$Key<android.util.Size> r10 = com.oppo.camera.aps.constant.ParameterKeys.KEY_VIDEO_SIZE     // Catch:{ all -> 0x0135 }
            java.lang.Object r10 = r1.get(r10)     // Catch:{ all -> 0x0135 }
            r5 = r10
            android.util.Size r5 = (android.util.Size) r5     // Catch:{ all -> 0x0135 }
            com.oppo.camera.p r10 = r9.cT     // Catch:{ all -> 0x0135 }
            boolean r6 = r10.j()     // Catch:{ all -> 0x0135 }
            com.oppo.camera.aps.config.AlgoSwitchConfig$PreviewConfig r10 = com.oppo.camera.aps.config.AlgoSwitchConfig.getPreviewConfig(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ all -> 0x0135 }
            r1.mPreviewConfig = r10     // Catch:{ all -> 0x0135 }
            com.oppo.camera.aps.adapter.ApsParameters$Key r10 = com.oppo.camera.aps.constant.ParameterKeys.KEY_LOGIC_CAMERA_ID     // Catch:{ all -> 0x0135 }
            java.lang.Object r10 = r1.get(r10)     // Catch:{ all -> 0x0135 }
            if (r10 == 0) goto L_0x012b
            com.oppo.camera.aps.adapter.ApsParameters$Key r10 = com.oppo.camera.aps.constant.ParameterKeys.KEY_LOGIC_CAMERA_ID     // Catch:{ all -> 0x0135 }
            java.lang.Object r10 = r1.get(r10)     // Catch:{ all -> 0x0135 }
            java.lang.String r10 = java.lang.String.valueOf(r10)     // Catch:{ all -> 0x0135 }
            boolean r10 = r10.isEmpty()     // Catch:{ all -> 0x0135 }
            if (r10 != 0) goto L_0x012b
            com.oppo.camera.aps.adapter.ApsParameters$Key r10 = com.oppo.camera.aps.constant.ParameterKeys.KEY_CAMERA_CHARACTERISTICS     // Catch:{ all -> 0x0135 }
            com.oppo.camera.aps.adapter.ApsParameters$Key r11 = com.oppo.camera.aps.constant.ParameterKeys.KEY_LOGIC_CAMERA_ID     // Catch:{ all -> 0x0135 }
            java.lang.Object r11 = r1.get(r11)     // Catch:{ all -> 0x0135 }
            java.lang.Integer r11 = (java.lang.Integer) r11     // Catch:{ all -> 0x0135 }
            int r11 = r11.intValue()     // Catch:{ all -> 0x0135 }
            com.oppo.camera.f.j r11 = com.oppo.camera.f.a.a((int) r11)     // Catch:{ all -> 0x0135 }
            android.hardware.camera2.CameraCharacteristics r11 = r11.F()     // Catch:{ all -> 0x0135 }
            r1.setParameter(r10, r11)     // Catch:{ all -> 0x0135 }
        L_0x012b:
            com.oppo.camera.aps.service.ApsService r10 = r9.de     // Catch:{ all -> 0x0135 }
            r10.init(r1)     // Catch:{ all -> 0x0135 }
            goto L_0x0133
        L_0x0131:
            monitor-exit(r0)     // Catch:{ all -> 0x0135 }
            return
        L_0x0133:
            monitor-exit(r0)     // Catch:{ all -> 0x0135 }
            return
        L_0x0135:
            r10 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0135 }
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.f.a(int, com.oppo.camera.aps.adapter.ApsInitParameter):void");
    }

    public Set<String> ao() {
        HashSet hashSet = new HashSet();
        if (!this.cj.aw() && this.cj.bp() == 0 && !this.aG) {
            hashSet.add(ParameterKeys.ALGO_NAME_FACE_BEAUTY);
        }
        if (!this.dW.ag()) {
            hashSet.add(ParameterKeys.ALGO_NAME_VIDEO_BLUR);
            hashSet.add(ParameterKeys.ALGO_NAME_BOKEH);
        }
        if (!this.dW.aj()) {
            hashSet.add(ParameterKeys.ALGO_NAME_VIDEO_RETENTION);
        }
        if (!ce()) {
            hashSet.add(ParameterKeys.ALGO_NAME_FACE_RECTIFY);
        }
        if (1 != this.cH.y()) {
            hashSet.add(ParameterKeys.ALGO_NAME_AINR);
        }
        if (this.cH.y() != 1) {
            hashSet.add(ParameterKeys.ALGO_NAME_AINR);
        }
        if (this.cj != null && !this.cj.bK()) {
            hashSet.add(ParameterKeys.ALGO_NAME_SCPORTRAIT);
        }
        if (this.cj != null && !this.cj.cL()) {
            hashSet.add(ParameterKeys.ALGO_NAME_MOTION_BLUR);
        }
        return hashSet;
    }

    public void ap() {
        e.a("CameraManager", "closeCaptureSession, mCameraState: " + this.E + ", mOneCamera: " + this.bR);
        if (this.bR != null && !this.as) {
            e.a("CameraSwitchModePerformance.closeCaptureSession");
            j(5);
            this.bR.f();
            this.dN.removeMessages(5);
            b bVar = this.ch;
            if (bVar != null) {
                bVar.b();
            }
            aq();
            this.cc.b((int) R.string.camera_toast_lock_ae_af);
            e.b("CameraSwitchModePerformance.closeCaptureSession");
        }
    }

    public void aq() {
        if (this.ce != null) {
            this.ce.l();
            this.ce.p();
            this.av = 0;
            if (this.ce.r()) {
                this.dN.a(new Runnable() {
                    public void run() {
                        if (!f.this.as) {
                            f.this.ce.f(false);
                            f.this.cc.bE();
                        }
                    }
                });
            }
        }
    }

    public int ar() {
        return Float.compare(this.bR.e().n(), 0.0f) != 0 && !CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_IS_UW_FIXED_FOCUS) ? Util.d((int) R.string.ultra_wide_micro_lens_toast) : R.string.ultra_wide_angel_toast;
    }

    public void n(int i2) {
        float f2;
        o oVar = this.cS;
        String pVar = (oVar == null || oVar.i() == null) ? "" : this.cS.i().toString();
        e.a("CameraManager", "createCaptureSession, mCameraState: " + this.E + ", mOneCamera: " + this.bR + ", mbPaused: " + this.as + ", modeChangeTask: " + pVar + ", role: " + i2);
        if (this.bR != null && !this.as && this.bO != null && !this.bO.isFinishing()) {
            al();
            if ((Camera.m && Camera.o) || (Camera.l && Camera.n)) {
                c((SharedPreferences) this.bP);
            }
            Size a2 = this.cT.a(this.bS);
            Size a3 = this.cT.a(a2);
            if (a3 == null) {
                a3 = a2;
            }
            a(a3, a2);
            if (this.cc != null) {
                this.cc.a(a3);
            }
            boolean i3 = this.cj.i("pref_zoom_key");
            if (this.by && this.cj.i(CameraFunction.SAT_CAMERA)) {
                f2 = aR();
                this.by = false;
            } else if ((!this.bt || this.cj.bY()) && this.cf != null && i3) {
                f2 = this.cf.a();
                if (!f(f2)) {
                    f2 = aQ();
                    this.cj.r(false);
                }
            } else {
                f2 = aQ();
                this.cj.r(false);
            }
            if (!Util.p() && this.cj.bT()) {
                this.bR.b(c(f2));
            }
            this.U = 0;
            this.am = -1;
            this.dv = 0;
            this.cT.a();
            this.bA = true;
            this.ca = this.bS.a(a3);
            b(f2);
            if (b(CameraFunction.TILT_SHIFT)) {
                ag();
            }
            o oVar2 = this.cS;
            if (oVar2 != null && oVar2.b() <= 1) {
                this.bt = false;
            }
            bX();
            if (b("pref_face_detection_key")) {
                x();
                this.bR.j();
            } else {
                y();
                this.bR.k();
            }
            if (aF() && !Util.p()) {
                ((h) this.bR).I(2);
            }
            if (!com.oppo.camera.f.a.c(this.dW.u()) && com.oppo.camera.f.a.f() && Float.compare(this.bS.n(), 0.0f) != 0) {
                this.aI = false;
            }
            if (b("key_suppport_multi_focus")) {
                z();
            } else {
                A();
            }
            if (this.cj == null || !this.cj.bG()) {
                w();
            } else {
                v();
            }
            if (!this.ao) {
                this.bR.a(this.cT.d(), a.a(), a.a(), true);
                this.bR.a(false, false);
            }
            ApsService apsService = this.de;
            if (apsService != null) {
                apsService.setPermitProcess(ImageCategory.ItemInfoType.VIDEO, false);
            }
            if (!(this.cc == null || this.cj == null)) {
                this.cc.c().g(this.cj.cN());
            }
            ((h) this.bR).a(this.cT.g(), this.bT, cc(), i2);
        }
    }

    private int cc() {
        if (this.cj != null) {
            return this.cj.aq();
        }
        return 1;
    }

    /* renamed from: com.oppo.camera.f$f  reason: collision with other inner class name */
    /* compiled from: CameraManager */
    private class C0082f implements f.b {
        private C0082f() {
        }

        public void a(int i) {
            e.a("CameraManager", "CameraOpenCallback onCameraOpened, mOneCamera: " + f.this.bR + ", mOpenCameraType: " + f.this.V + ", cameraRole: " + i);
            if (!f.this.as && f.this.bR != null) {
                synchronized (f.this.f) {
                    f.this.bR.a(f.this.bZ());
                }
                int bx = f.this.V;
                if (bx != 0) {
                    if (bx != 1) {
                        if (bx != 2) {
                            if (!(bx == 3 || bx == 4)) {
                                return;
                            }
                        }
                    }
                    boolean unused = f.this.cY = true;
                    f fVar = f.this;
                    Size unused2 = fVar.cO = fVar.cT.a(f.this.bS);
                    Size a2 = f.this.cT.a(f.this.cO);
                    if (a2 != null) {
                        Size unused3 = f.this.cO = a2;
                    }
                    f.this.ce.b(f.this.ao);
                    f.this.cc.R(f.this.ao);
                    f.this.cj.a(f.this.bR);
                    f.this.cj.c(f.this.K);
                    if (f.this.cS != null) {
                        f.this.cS.f();
                    }
                    f.this.k(0);
                    f.this.b(false, false);
                    f.this.dN.a(new Runnable() {
                        public void run() {
                            if (!f.this.as) {
                                boolean z = !f.this.cT.m() && !f.this.cT.n() && !f.this.cc.cQ() && !f.this.cc.cH() && f.this.aA;
                                if (!f.this.aG()) {
                                    f.this.cc.a(f.this.K, z, f.this.cc.H());
                                }
                                f.this.cc.c(f.this.cT.a(f.this.bS));
                            }
                        }
                    });
                    if (f.this.cc.b(f.this.cT.a(f.this.bS)) && !f.this.as) {
                        f.this.n(i);
                        return;
                    }
                    return;
                }
                boolean unused4 = f.this.cY = true;
                int unused5 = f.this.cQ = 0;
                f.this.a(96, false);
                Util.k();
                f.this.m(i);
            }
        }

        public void a(boolean z, int i) {
            e.a("CameraManager", "CameraOpenCallback onFailure, cameraRole: " + i + " mOneCamera: " + f.this.bR + ", mOpenCameraTime: " + f.this.cQ + ", mOpenCameraType: " + f.this.V + ", disconnected: " + z);
            if (2 == i) {
                ((h) f.this.bR).F();
            }
            if (f.this.cS != null) {
                f.this.cS.k();
            }
            synchronized (f.this.f) {
                if (f.this.bR != null) {
                    f.this.bR.a((f.e) null);
                }
            }
            if (f.this.bO != null && !f.this.bO.isFinishing()) {
                if (z) {
                    f.this.dN.removeMessages(10);
                    f.this.dN.a(new Runnable() {
                        public void run() {
                            if (f.this.bO != null && !f.this.bO.isFinishing()) {
                                e.e("CameraManager", "onError, camera will finish");
                                f.this.bO.finish();
                            }
                        }
                    });
                    return;
                }
                f.this.dN.a(new Runnable() {
                    public void run() {
                        if (!f.this.as) {
                            if (f.this.cQ <= 3) {
                                f.this.dN.removeMessages(10);
                                f.this.dN.sendEmptyMessageDelayed(10, 100);
                                return;
                            }
                            Util.a(f.this.bO, (int) R.string.camera_camera_error_title);
                        }
                    }
                });
            }
        }

        public void a(int i, int i2) {
            e.a("CameraManager", "CameraOpenCallback onError, cameraRole: " + i2 + ", mOneCamera: " + f.this.bR + ", errorCode: " + i + ", mOpenCameraType: " + f.this.V);
            if (2 == i2) {
                ((h) f.this.bR).F();
            }
            if (f.this.cS != null) {
                f.this.cS.k();
            }
            synchronized (f.this.f) {
                if (f.this.bR != null) {
                    f.this.bR.a((f.e) null);
                }
            }
            if (f.this.dN != null) {
                f.this.dN.removeMessages(10);
                f.this.dN.a(new Runnable() {
                    public void run() {
                        if (f.this.bO != null && !f.this.bO.isFinishing()) {
                            e.e("CameraManager", "onError, camera will finish");
                            f.this.bO.finish();
                        }
                    }
                });
            }
        }

        public void b(int i) {
            e.a("CameraManager", "CameraOpenCallback onCameraClosed, mOneCamera: " + f.this.bR + ", mOpenCameraType: " + f.this.V + ", cameraRole: " + i);
            if (1 == i) {
                if (f.this.de != null) {
                    f.this.de.closeCamera();
                    f.this.de.waitAddFrame(true);
                }
                if (f.this.du != null) {
                    f.this.du.a((ApsTotalResult) null);
                }
                f.this.bR.u();
                f.this.w(1);
                f.this.dN.a(new Runnable() {
                    public void run() {
                        f.this.j(0);
                    }
                });
            } else if (2 == i) {
                f.this.w(2);
                ((h) f.this.bR).F();
            }
        }

        public boolean a() {
            return f.this.bR == null || ((h) f.this.bR).E();
        }
    }

    public void as() {
        if (this.cc != null) {
            this.cc.bH();
        }
        if (this.cj != null) {
            this.cj.as();
        }
    }

    public void a(SharedPreferences sharedPreferences, String str) {
        boolean z2;
        SharedPreferences sharedPreferences2 = sharedPreferences;
        e.a("CameraManager", "onSharedPreferenceChanged, key: " + str);
        String c2 = com.oppo.camera.entry.b.c(str);
        if (!"pref_video_blur_menu_state".equals(c2) && !"pref_portrait_blur_menu_index".equals(c2) && !"pref_multicamera_type_selected_key".equals(c2) && !CameraConfig.getMenuPanelOptionList().contains(c2)) {
            q(c2);
        }
        if (this.cc != null) {
            this.cc.a(sharedPreferences2, c2);
        }
        if (this.ce != null) {
            this.ce.a(sharedPreferences2, c2);
        }
        if (this.cj != null) {
            this.cj.a(sharedPreferences2, c2);
        }
        boolean z3 = true;
        if ("pref_camera_id_key".equals(c2)) {
            int Q2 = Q();
            if (this.K != Q2) {
                this.cH.g();
                a(Q2, true, false);
            }
        } else if (this.cj != null) {
            if ("pref_camera_mode_key".equals(c2)) {
                if (!sharedPreferences2.getString(c2, Util.a(this.cH.y() == 3)).equals(this.cj.l())) {
                    this.ba = false;
                    if ((this.cj.bX() || this.cj.ce() || this.cj.bY()) && this.bP != null) {
                        h(true);
                        this.bP.edit().putString("pref_none_sat_ultra_wide_angle_key", "off").apply();
                        this.bP.edit().putString("pref_none_sat_tele_angle_key", "off").apply();
                        h(false);
                    }
                    this.cH.g();
                    a(false, true, false);
                    C(true);
                }
            } else if (!"pref_subsetting_key".equals(c2) || this.bP == null) {
                if ("pref_setting_key".equals(c2)) {
                    if (this.du != null) {
                        this.du.a(true);
                    }
                    Intent intent = new Intent("com.oppo.camera.action.SETTING_MENU");
                    Bundle a2 = com.oppo.camera.ui.menu.setting.o.a(this.cj);
                    a2.putInt("pref_camera_id_key", this.K);
                    a2.putInt("camera_enter_type", this.cH.y());
                    a2.putBoolean("camera_enter_form_lock_screen", this.cH.m());
                    a2.putInt("camera_property_camera_id", ak());
                    a2.putBoolean("pref_photo_codec_key", CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_PHOTO_CODEC));
                    a2.putBoolean("pref_10bits_heic_encode_key", CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_10_BITS_HEIC_ENCODE_SUPPORT));
                    a2.putBoolean("pref_qr_code_key", b("pref_qr_code_key"));
                    intent.putExtra("camera_intent_data", a2);
                    w(true);
                    cL();
                    this.bO.startActivity(intent);
                }
                if ("pref_video_size_key".equals(c2) || "pref_video_fps_key".equals(c2) || ("pref_platform_slow_video_fps_key".equals(c2) && this.bP != null)) {
                    if (!this.cj.aM() && !this.aF) {
                        if (this.cH.a(this.bP.getString("pref_camera_mode_key", ApsConstant.CAPTURE_MODE_COMMON), this.K) != this.bR.c()) {
                            bF();
                        } else {
                            bB();
                        }
                    }
                    if (ApsConstant.REC_MODE_COMMON.equals(this.cj.l())) {
                        com.oppo.camera.v.a.a().a((Context) this.bO, CameraStatisticsUtil.PORTRAIT_CAPTURE_MODE, (Object) Integer.valueOf(this.cj.d()));
                        return;
                    }
                    return;
                }
                if ("pref_10bits_heic_encode_key".equals(c2) && this.bP != null && !this.cj.aM() && this.cH.a(this.bP.getString("pref_camera_mode_key", ApsConstant.REC_MODE_COMMON), this.K) == this.bR.c() && !this.aF) {
                    bC();
                }
                if (!"pref_none_sat_ultra_wide_angle_key".equals(c2) || this.aF) {
                    String str2 = null;
                    if ("pref_none_sat_tele_angle_key".equals(c2)) {
                        if (this.bP != null) {
                            str2 = this.bP.getString("pref_none_sat_tele_angle_key", "");
                        }
                        if (!this.aF && (!this.aL || "on".equals(str2))) {
                            cg();
                        }
                        if (this.bP != null && !TextUtils.isEmpty(str2)) {
                            z3 = false;
                        }
                        this.aL = z3;
                        return;
                    }
                    if ("pref_video_super_eis_key".equals(c2)) {
                        if (!this.aF) {
                            boolean bX2 = this.cj.bX();
                            boolean z4 = this.ao;
                            boolean configBooleanValue = CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_VIDEO_FRONT_EIS_FORCE_ULTRA_WIDE);
                            if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_VIDEO_SUPER_EIS_WIDE_OPEN_DEFAULT)) {
                                z2 = this.cj.ce();
                            } else {
                                z2 = cd();
                            }
                            if (cd()) {
                                a((Animation.AnimationListener) null);
                            }
                            this.cj.bW();
                            if (bX2 && z2) {
                                if (!configBooleanValue) {
                                    e.a("CameraManager", "onSharedPreferenceChanged, return");
                                    return;
                                } else if (!z4) {
                                    return;
                                }
                            }
                            if (configBooleanValue && !bX2 && z4) {
                                bD();
                            }
                            if (this.cj.i(CameraFunction.SAT_CAMERA)) {
                                bF();
                                return;
                            } else {
                                bB();
                                return;
                            }
                        } else if (!cd() && this.cc != null) {
                            this.cc.w(false);
                            this.cc.F();
                        }
                    }
                    if (!"pref_video_blur_menu_state".equals(c2) || this.aF || this.aA) {
                        if ("pref_switch_camera_key".equals(c2) || "pref_switch_camera_bar_key".equals(c2)) {
                            bD();
                        } else if ("pref_camera_photo_ratio_key".equals(c2) && this.bP != null) {
                            if ("standard_high".equals(this.bP.getString("pref_camera_high_resolution_key", "standard_high"))) {
                                String string = this.bP.getString("pref_camera_photo_ratio_key", "standard");
                                if (!"standard_high".equals(string)) {
                                    this.bP.edit().putString("pref_camera_high_resolution_key", string).apply();
                                    this.bP.edit().putBoolean("key_high_picture_size", false).apply();
                                    if (this.cc != null) {
                                        this.cc.f("pref_camera_high_resolution_key");
                                    }
                                }
                            }
                            bA();
                        } else if ("pref_camera_timer_shutter_key".equals(c2) && this.bP != null) {
                            String string2 = this.bP.getString("pref_camera_timer_shutter_key", this.bO.getString(R.string.camera_shutter_mode_default_value));
                            com.oppo.camera.ui.control.c f2 = this.cj.f();
                            if (VideoRecordMsgData.END_TYPE_NORMAL.equals(string2)) {
                                b(c2, false);
                                f2.b("button_shape_ring_none");
                            } else if ("3".equals(string2)) {
                                b(c2, true);
                                f2.b("button_shape_countdown_three_seconds");
                            } else if (FocusAimMsgData.KEY_INTELLIGENCE_VIEW_FOCUS_TYPE.equals(string2)) {
                                b(c2, true);
                                f2.b("button_shape_countdown_ten_seconds");
                            }
                            this.cc.a(f2);
                        } else if (this.bP != null && "pref_camera_high_resolution_key".equals(c2)) {
                            String string3 = this.bP.getString("pref_camera_high_resolution_key", "standard_high");
                            String string4 = this.bP.getString("pref_camera_photo_ratio_key", "standard");
                            if ("standard_high".equals(string3)) {
                                this.bP.edit().putString("pref_camera_photo_ratio_key", "standard_high").apply();
                                this.bP.edit().putBoolean("key_high_picture_size", true).apply();
                                if (this.cc != null) {
                                    this.cc.f("pref_camera_photo_ratio_key");
                                    this.cc.c(c2, true);
                                }
                                if (string3.equals("standard_high") && !b("pref_ultra_wide_high_picture_size_key")) {
                                    a((Animation.AnimationListener) null);
                                }
                                if (this.cj.bX()) {
                                    e.a("CameraManager", "onSharedPreferenceChanged, turn off wideAngleMode");
                                    h(true);
                                    this.bP.edit().putString("pref_none_sat_ultra_wide_angle_key", "off").apply();
                                    h(false);
                                }
                            } else if ("standard_high".equals(string4)) {
                                this.bP.edit().putString("pref_camera_photo_ratio_key", "standard").apply();
                                this.bP.edit().putBoolean("key_high_picture_size", false).apply();
                                b(c2, false);
                            }
                            if (this.cc == null) {
                                return;
                            }
                            if (this.bP.getBoolean("key_high_picture_size", false)) {
                                if (!this.cc.k(CameraFunction.FACE_BEAUTY_PROCESS)) {
                                    if (this.cc.C()) {
                                        this.cc.b(false, false, false);
                                    }
                                    this.cc.a(false, false, false, false);
                                }
                                if (!this.cc.k("pref_filter_process_key")) {
                                    this.cc.g(true, false);
                                    return;
                                }
                                return;
                            }
                            this.cc.r(true);
                            if (this.cc.C()) {
                                this.cc.s(false);
                            }
                        } else if (!"pref_camera_hdr_mode_key".equals(c2) && !"key_video_hdr".equals(c2)) {
                            if ("pref_film_video_log".equals(c2) && !this.aF) {
                                l(c2);
                            }
                            if ("key_ultra_night_video".equals(c2)) {
                                if (!this.aF) {
                                    g(c2);
                                }
                                if (b(CameraFunction.ULTRA_NIGHT_VIDEO)) {
                                    com.oppo.camera.v.a.a().a((Context) this.bO, CameraStatisticsUtil.PORTRAIT_CAPTURE_MODE, (Object) Integer.valueOf(this.cj.d()));
                                }
                            } else if ("pref_video_tilt_shift_key".equals(c2) || "pref_video_timelapse_tilt_shift_key".equals(c2) || "pref_photo_tilt_shift_key".equals(c2)) {
                                if (!this.aF) {
                                    h(c2);
                                } else if (!this.cj.aB()) {
                                    this.cc.c(true, false, true);
                                    this.cc.y(false);
                                }
                            } else if ("key_ai_enhancement_video".equals(c2)) {
                                if (!this.aF) {
                                    g(c2);
                                }
                                if (b(CameraFunction.AI_ENHANCEMENT_VIDEO)) {
                                    com.oppo.camera.v.a.a().a((Context) this.bO, CameraStatisticsUtil.PORTRAIT_CAPTURE_MODE, (Object) Integer.valueOf(this.cj.d()));
                                }
                            } else if ("pref_night_pro_mode_key".equals(c2) && !this.aF && com.oppo.camera.f.a.f()) {
                                bF();
                            } else if ("pref_camera_flashmode_key".equals(c2)) {
                                if ("on".equals(sharedPreferences2.getString("pref_camera_flashmode_key", this.bO.getString(R.string.camera_flash_mode_default_value))) && u()) {
                                    k(0);
                                    b(false, true);
                                }
                            } else if ("pref_camera_videoflashmode_key".equals(c2)) {
                                if (this.cc != null) {
                                    String Q3 = this.cj.Q();
                                    if (Camera.m || Camera.l) {
                                        if (!"off".equals(Q3)) {
                                            if (Camera.m) {
                                                this.cc.a((int) R.string.camera_high_temperature_flash_disable, -1, true, false, false);
                                                a(ReminderMsgData.TYPE_DISABLE_CODE, ReminderMsgData.CODE_TEMPS_FLASH);
                                            } else if (Camera.l) {
                                                this.cc.a((int) R.string.camera_low_battery_flash_disable, -1, true, false, false);
                                                a(ReminderMsgData.TYPE_DISABLE_CODE, ReminderMsgData.CODE_BATTERY_FLASH);
                                            }
                                            if (this.bP != null) {
                                                SharedPreferences.Editor edit = this.bP.edit();
                                                edit.putString("pref_camera_videoflashmode_key", "off");
                                                edit.apply();
                                            }
                                            this.cc.f("pref_camera_videoflashmode_key");
                                        }
                                        this.cj.b(false, false);
                                        return;
                                    }
                                    this.cj.L();
                                    com.oppo.camera.f.f fVar = this.bR;
                                    if (fVar != null) {
                                        fVar.a(Q3);
                                        this.bR.a((f.c) null);
                                    }
                                }
                            } else if ("pref_camera_torch_mode_key".equals(c2)) {
                                String string5 = sharedPreferences2.getString("pref_camera_torch_mode_key", Util.y(this.bO));
                                if (this.cj.i(CameraFunction.TORCH_SOFT_LIGHT)) {
                                    if ("on".equals(string5)) {
                                        this.bR.a("torch");
                                    } else {
                                        this.bR.a("off");
                                    }
                                    this.bR.a((f.c) null);
                                }
                            } else if (!"pref_camera_vivid_effect_key".equals(c2)) {
                                if ("pref_current_sticker_uuid".equals(c2)) {
                                    StickerItem a3 = com.oppo.camera.ui.preview.a.l.b((Context) this.bO).a((SharedPreferences) this.bP);
                                    if (com.oppo.camera.ui.preview.a.l.b(this.cF) || !com.oppo.camera.ui.preview.a.l.b(a3)) {
                                        if (com.oppo.camera.ui.preview.a.l.b(this.cF) && !com.oppo.camera.ui.preview.a.l.b(a3)) {
                                            if (2 != AlgoSwitchConfig.getApsVersion() || o()) {
                                                this.bR.a((f.c) null);
                                            } else {
                                                this.bR.d("type_preview_frame");
                                            }
                                        }
                                    } else if (2 == AlgoSwitchConfig.getApsVersion() && !o()) {
                                        this.bR.a("type_preview_frame", false);
                                    }
                                    this.cF = a3;
                                }
                                if ("pref_switch_dual_camera_key".equals(c2)) {
                                    a(Q(), true, true);
                                    return;
                                }
                                if ("pref_super_eis_wide_key".equals(c2) && !this.aF) {
                                    bF();
                                }
                                if ("pref_camera_pi_ai_mode_key".equals(c2)) {
                                    if (this.cc != null) {
                                        this.U = 0;
                                        this.cc.cv();
                                        this.cc.cq();
                                    }
                                    this.cj.ap();
                                    this.bR.a((f.c) null);
                                } else if ("key_high_picture_size".equals(c2) && this.bP != null) {
                                    this.aH = this.bP.getBoolean("key_high_picture_size", false);
                                    if (!this.aH) {
                                        this.U = 0;
                                    }
                                    e.c("CameraManager", "onSharedPreferenceChanged, mbHighPictureResolutionOn: " + this.aH);
                                } else if ("pref_night_tripod_mode_key".equals(c2) && b("pref_night_tripod_mode_key") && CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_NIGHT_TRIPOD_ZOOM_HIDE_ULTRA_WIDE)) {
                                    this.cf.a(aR(), aS(), this.cf.a(), this.bS.d(), this.cj.cd(), true);
                                } else if ("pref_film_video_eis_menu".equals(c2)) {
                                    if (this.cj.i(CameraFunction.SAT_CAMERA)) {
                                        bF();
                                    } else if (!this.aF && "movie".equals(this.cj.l())) {
                                        bB();
                                    }
                                } else if (!"pref_film_video_size_4k".equals(c2)) {
                                } else {
                                    if (this.cj.i(CameraFunction.SAT_CAMERA)) {
                                        bF();
                                    } else {
                                        bB();
                                    }
                                }
                            } else if (!this.aG) {
                                int i2 = R.string.camera_vivid_close_toast;
                                if (this.cj.ax()) {
                                    i2 = R.string.camera_vivid_open_toast;
                                }
                                int i3 = i2;
                                if (this.cc != null) {
                                    this.cc.a(i3, -1, true, false, false);
                                }
                            }
                        } else if (!"key_video_hdr".equals(c2) || b(CameraFunction.VIDEO_HDR)) {
                            if (!this.aF) {
                                f(c2);
                            }
                            if (b(CameraFunction.VIDEO_HDR) && this.bP != null) {
                                com.oppo.camera.v.a.a().a((Context) this.bO, CameraStatisticsUtil.PORTRAIT_CAPTURE_MODE, (Object) Integer.valueOf(this.cj.d()));
                                b(c2, "on".equals(this.bP.getString("key_video_hdr", this.bO.getResources().getString(R.string.camera_video_hdr_default_value))));
                            }
                        } else {
                            e.d("CameraManager", "onSharedPreferenceChanged, not support KEY_VIDEO_HDR");
                        }
                    } else if (this.cj.i(CameraFunction.SAT_CAMERA)) {
                        bF();
                    }
                } else {
                    cf();
                }
            } else if (this.cc != null) {
                boolean equals = "on".equals(this.bP.getString("pref_subsetting_key", "off"));
                this.cc.N(equals);
                if (equals && this.cf.e()) {
                    this.cf.b(true);
                }
                if (!equals && !this.aC && this.cj.bx() && !CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_HIGH_DEFINITION)) {
                    this.cc.a(this.bO.getString(R.string.camera_picture_size_standard_high_hint, new Object[]{Double.valueOf(this.cj.bz())}), 0, (int) R.color.screen_hint_text_color);
                }
            }
        }
    }

    private void l(String str) {
        if (n(str)) {
            Size aX2 = this.cc.aX();
            int S2 = this.cj.S();
            if (a(aX2, aX2, S2, S2, false, 0, (d.a) new m())) {
                g(true);
            }
        }
    }

    private boolean cd() {
        return this.bP != null && "on".equals(this.bP.getString("pref_video_super_eis_key", "off"));
    }

    private boolean ce() {
        if (this.cj != null) {
            return this.cj.ch();
        }
        return false;
    }

    private void cf() {
        i(true);
        if (this.cj != null) {
            if (this.cj.bX()) {
                this.cj.bU();
                if (!CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_FLASH_FULL_ZOOM) && (b("pref_camera_flashmode_key") || b("pref_camera_videoflashmode_key"))) {
                    this.cj.r(true);
                    this.cj.a(this.cj.Q(), !this.ay);
                }
                if (this.cc != null && this.cc.G()) {
                    this.cc.d(true, false, true);
                }
            } else if (b("pref_camera_flashmode_key") || b("pref_camera_videoflashmode_key")) {
                this.cj.r(this.cj.bY());
                this.cj.a(this.cj.Q(), true ^ this.ay);
            }
        }
        bD();
    }

    private void cg() {
        if (this.cH.a(this.bP.getString("pref_camera_mode_key", ApsConstant.CAPTURE_MODE_COMMON), this.K) != this.bR.c()) {
            j(true);
            if (this.cj != null) {
                if (this.cj.bY()) {
                    this.cj.bV();
                    if (!CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_FLASH_FULL_ZOOM) && (b("pref_camera_flashmode_key") || b("pref_camera_videoflashmode_key"))) {
                        this.cj.r(true);
                        this.cj.a(this.cj.Q(), !this.az);
                    }
                    if (this.cc != null && this.cc.G()) {
                        this.cc.d(true, false, true);
                    }
                } else if (b("pref_camera_flashmode_key") || b("pref_camera_videoflashmode_key")) {
                    this.cj.r(this.cj.bX());
                    this.cj.a(this.cj.Q(), true ^ this.az);
                }
            }
            bE();
        }
    }

    private void b(String str, boolean z2) {
        if (this.cc != null) {
            this.cc.c(str, z2);
        }
    }

    /* compiled from: CameraManager */
    private class y implements d.a {
        public int b() {
            return -1;
        }

        private y() {
        }

        public void a(Size size) {
            f.this.cc.d(false, false);
            Size aX = f.this.cc.aX();
            e.a("CameraManager", "VideoSizeChangeAnimationListenerImpl, onAnimationStart, currSize: " + aX.getWidth() + "x" + aX.getHeight() + ", toSize: " + size.getWidth() + "x" + size.getHeight());
            if (f.this.cj.aM()) {
                return;
            }
            if (TextUtils.equals(ApsConstant.REC_MODE_COMMON, f.this.cj.l()) || TextUtils.equals(ApsConstant.REC_MODE_SLOW_VIDEO, f.this.cj.l()) || TextUtils.equals("movie", f.this.cj.l())) {
                boolean unused = f.this.aX = true;
                if (f.this.cH.a(f.this.cj.l(), f.this.K) != f.this.bR.c()) {
                    f.this.l(4);
                    return;
                }
                f.this.ap();
                f.this.n(1);
            }
        }

        public void a(Size size, Size size2) {
            e.a("CameraManager", "VideoSizeChangeAnimationListenerImpl, onAnimationMiddle");
            f.this.a(size2, true);
            f.this.cj.b(b(), true);
        }

        public void a() {
            e.a("CameraManager", "VideoSizeChangeAnimationListenerImpl, onAnimationEnd");
            if (f.this.dM != null) {
                f.this.dM.b(true);
            }
            f.this.cc.d(true, false);
            f.this.d(false);
            f.this.g(false);
            f.this.k(false);
            f.this.d(-1);
            f.this.cc.Q(true);
            f.this.cc.i(true);
            if (com.oppo.camera.ui.menu.f.a()) {
                com.oppo.camera.ui.menu.f.d();
            }
        }
    }

    /* compiled from: CameraManager */
    private class m implements d.a {
        public int b() {
            return 6;
        }

        private m() {
        }

        public void a(Size size) {
            e.a("CameraManager", "HdrAnimationListenerImpl, onAnimationStart");
            f.this.cc.d(false, false);
            if (f.this.cH.a(f.this.cj.l(), f.this.K) != f.this.bR.c()) {
                f.this.l(1);
                return;
            }
            f.this.ap();
            f.this.n(1);
        }

        public void a(Size size, Size size2) {
            e.e("CameraManager", "HdrAnimationListenerImpl, onAnimationMiddle");
            if (com.oppo.camera.ui.menu.f.a()) {
                com.oppo.camera.ui.menu.f.d();
            }
        }

        public void a() {
            e.e("CameraManager", "HdrAnimationListenerImpl, onAnimationEnd");
            f.this.cj.b(b(), true);
            if (f.this.dM != null) {
                f.this.dM.b(true);
            }
            f.this.cc.d(true, false);
            f.this.g(false);
            f.this.cc.i(true);
            f.this.k(false);
            f.this.i(false);
            f.this.d(-1);
            f.this.cj.b(13, true);
        }
    }

    /* compiled from: CameraManager */
    private class e implements d.a {
        public int b() {
            return 16;
        }

        private e() {
        }

        public void a(Size size) {
            e.a("CameraManager", "BlurModeAnimationListenerImpl, onAnimationStart");
            f.this.cc.d(false, false);
            f.this.cc.b((int) R.string.ultra_wide_angel_toast);
            if (f.this.aF() || f.this.cH.a(f.this.bP.getString("pref_camera_mode_key", ApsConstant.CAPTURE_MODE_COMMON), f.this.K) == f.this.bR.c()) {
                f.this.ap();
                f.this.n(1);
                if (f.this.aF()) {
                    f.this.n(2);
                    return;
                }
                return;
            }
            f.this.l(1);
        }

        public void a(Size size, Size size2) {
            e.e("CameraManager", "BlurModeAnimationListenerImpl, onAnimationMiddle");
            if (com.oppo.camera.ui.menu.f.a()) {
                com.oppo.camera.ui.menu.f.d();
            }
        }

        public void a() {
            e.e("CameraManager", "BlurModeAnimationListenerImpl, onAnimationEnd");
            f.this.cj.b(b(), true);
            if (f.this.dM != null) {
                f.this.dM.b(true);
            }
            f.this.cc.d(true, false);
            f.this.g(false);
            f.this.cc.i(true);
            f.this.k(false);
            f.this.i(false);
            f.this.j(false);
            f.this.d(-1);
            f.this.cc.a(f.this.K, true, f.this.cc.H());
            f.this.cj.b(13, true);
        }
    }

    /* compiled from: CameraManager */
    private class c implements d.a {

        /* renamed from: b  reason: collision with root package name */
        private Size f3055b;
        private Size c;

        public int b() {
            return 17;
        }

        private c() {
            this.f3055b = null;
            this.c = null;
        }

        public void a(Size size) {
            e.a("CameraManager", "BaseSwitchDualCameraAnimationListenerImpl, onAnimationStart");
            f.this.cj.b(b(), false);
            f.this.cc.b(f.this.ar());
            f.this.cc.d(false, false);
            f fVar = f.this;
            fVar.i(fVar.Q());
        }

        public void a(Size size, Size size2) {
            StringBuilder sb = new StringBuilder();
            sb.append("BaseSwitchDualCameraAnimationListenerImpl, onAnimationMiddle , fromSize: ");
            String str = null;
            sb.append(size != null ? size.toString() : null);
            sb.append(", toSize: ");
            if (size2 != null) {
                str = size2.toString();
            }
            sb.append(str);
            e.a("CameraManager", sb.toString());
            this.f3055b = size2;
            this.c = size;
            if (com.oppo.camera.ui.menu.f.a()) {
                com.oppo.camera.ui.menu.f.d();
            }
        }

        public void a() {
            e.e("CameraManager", "BaseSwitchDualCameraAnimationListenerImpl, onAnimationEnd");
            f.this.cj.b(b(), true);
            if (f.this.dM != null) {
                f.this.dM.b(true);
            }
            if (!f.this.cj.bk()) {
                f.this.a(this.f3055b, true);
            }
            f.this.cc.d(true, false);
            f.this.g(false);
            f.this.k(false);
            com.oppo.camera.ui.inverse.c.INS.setMaskAlpha(f.this.bO, true, false);
            f.this.i(false);
            f.this.d(-1);
            f fVar = f.this;
            fVar.A(fVar.cj.bZ());
            f.this.cc.i(true);
        }
    }

    /* access modifiers changed from: private */
    public void z(int i2) {
        if (-1 != i2 && this.cc != null) {
            this.cc.b(i2);
        }
    }

    /* access modifiers changed from: private */
    public void A(int i2) {
        if (-1 != i2 && this.cc != null) {
            this.cc.a(i2, -1, true, false, false);
        }
    }

    /* compiled from: CameraManager */
    public class t implements d.a {

        /* renamed from: b  reason: collision with root package name */
        private Size f3090b = null;
        private Size c = null;

        public int b() {
            return -1;
        }

        public t() {
        }

        public void a(Size size) {
            e.a("CameraManager", "PictureSizeAnimationListenerImpl, onAnimationStart");
            if (f.this.ax || 2 != f.this.cH.y()) {
                f.this.cc.d(false, false);
                if (2 == Util.b(size.getWidth(), size.getHeight())) {
                    f.this.cj.b(13, true);
                }
                f.this.ap();
                if (f.this.L()) {
                    f.this.n(1);
                } else {
                    f.this.l(4);
                }
            }
        }

        public void a(Size size, Size size2) {
            StringBuilder sb = new StringBuilder();
            sb.append("PictureSizeAnimationListenerImpl, onAnimationMiddle , fromSize: ");
            String str = null;
            sb.append(size != null ? size.toString() : null);
            sb.append(", toSize: ");
            if (size2 != null) {
                str = size2.toString();
            }
            sb.append(str);
            e.a("CameraManager", sb.toString());
            this.f3090b = size2;
            this.c = size;
            if (com.oppo.camera.ui.menu.f.a()) {
                com.oppo.camera.ui.menu.f.d();
            }
            f.this.cj.b(b(), true);
        }

        public void a() {
            e.a("CameraManager", "PictureSizeAnimationListenerImpl, onAnimationEnd");
            if (f.this.dM != null) {
                f.this.dM.b(true);
            }
            if (!f.this.cj.bk()) {
                f.this.a(this.f3090b, true);
            }
            f.this.v(true);
            f.this.cc.d(true, false);
            f.this.d(false);
            f.this.g(false);
            f.this.cc.i(true);
            f.this.k(false);
            f.this.d(-1);
            f.this.cj.b(13, true);
        }
    }

    /* compiled from: CameraManager */
    public class k implements d.a {

        /* renamed from: b  reason: collision with root package name */
        private boolean f3074b = false;
        private boolean c = false;
        private boolean d = false;
        private Size e = null;
        private int f = 0;
        private int g = 0;

        public int b() {
            return 1;
        }

        public k() {
        }

        private boolean f() {
            if (Util.b(this.f)) {
                return true;
            }
            if (Util.e(this.f) || (Util.Q() && Util.c(this.f, this.g) && !Util.b(this.g))) {
                return false;
            }
            return true;
        }

        public void a(Size size) {
            e.a("CameraManager", "switch camera mode, onAnimationStart");
            this.f3074b = true;
            this.c = true;
            this.d = false;
            String string = f.this.bP.getString("pref_camera_mode_key", Util.a(f.this.cH.y() == 3));
            com.oppo.camera.e.a a2 = f.this.cj.a(string);
            if (!a2.f("pref_filter_process_key")) {
                f.this.cc.o(true);
            }
            if (f.this.cc.C()) {
                f.this.cc.b(false, true, false);
            }
            f.this.cc.D(false);
            if (!a2.f("pref_video_super_eis_key")) {
                f.this.cc.w(false);
            }
            if (f.this.cj.aB()) {
                f.this.cc.c(true, true, true);
                f.this.cc.y(false);
                if (f.this.cg != null) {
                    f.this.cg.resetTiltShiftParams();
                }
            }
            if (!a2.f("pref_inertial_zoom_key")) {
                f.this.cq();
            }
            if (!a2.f("pref_video_super_eis_key")) {
                f.this.cc.F();
            }
            f.this.cc.b(f.this.ar());
            f.this.cc.b((int) R.string.camera_slow_video_tips);
            f.this.cc.bV();
            if (!a2.f("pref_zoom_key") || a2.f("pref_expand_popbar_key")) {
                f.this.a((Animation.AnimationListener) null);
            } else if (f.this.cf != null && f.this.cf.e()) {
                f.this.av();
            }
            f fVar = f.this;
            fVar.z(fVar.cj.bZ());
            f.this.cj.b(1, false);
            f.this.cc.b(a2.a(), true);
            f.this.a(true, false, true);
            if (!a2.f(CameraFunction.FACE_BEAUTY_PROCESS) || f.this.cc.cy()) {
                f.this.cc.a(true, true, false, false);
            } else {
                f.this.cc.r(true);
            }
            if (f.this.cj.i("pref_zoom_key") && !f.this.cj.i("pref_expand_popbar_key") && ApsConstant.CAPTURE_MODE_PROFESSIONAL.equals(string)) {
                f fVar2 = f.this;
                fVar2.b(fVar2.aQ());
                f.this.v(true);
                f.this.cc.A(true);
            }
            f.this.cc.di();
        }

        public void a(Size size, Size size2) {
            StringBuilder sb = new StringBuilder();
            sb.append("switch camera mode, onAnimationMiddle, mbCancle: ");
            sb.append(this.d);
            sb.append(", fromSize: ");
            String str = null;
            sb.append(size != null ? size.toString() : null);
            sb.append(", toSize: ");
            if (size2 != null) {
                str = size2.toString();
            }
            sb.append(str);
            e.a("CameraManager", sb.toString());
            this.c = false;
            f.this.cc.a(f.this.cj.l(), f.this.cj.f(), f.this.cD());
            this.e = size2;
            if (size2 != null) {
                this.g = Util.b(size2.getWidth(), size2.getHeight());
            }
            if (size != null) {
                this.f = Util.b(size.getWidth(), size.getHeight());
            }
            if (f.this.cj.i("pref_zoom_key") && !f.this.cj.i("pref_expand_popbar_key") && !ApsConstant.CAPTURE_MODE_PROFESSIONAL.equals(f.this.cj.l())) {
                f.this.au();
                f.this.v(true);
            }
        }

        public void a() {
            e.a("CameraManager", "switch camera mode, onAnimationEnd, mbCancle: " + this.d);
            if (!this.d) {
                if (f.this.dM != null) {
                    f.this.dM.b(true);
                }
                if (!f() && !f.this.cc.cH()) {
                    f.this.a(this.e, true);
                }
                if (f.this.cc != null && !f.this.cc.cU() && !f.this.cc.cH() && 0.0f == f.this.cc.cI()) {
                    f.this.cc.d(1.0f);
                }
                f.this.d(false);
                f.this.k(false);
                f.this.d(-1);
                if (f.this.as) {
                    this.f3074b = false;
                    return;
                }
                if (!f.this.cc.cQ() || !f.this.cc.cH()) {
                    f.this.cc.d(true, false);
                    f.this.cc.i(true);
                } else {
                    f.this.cc.d(false, true);
                    f.this.cc.i(false);
                }
                f.this.cc.a(f.this.K, true, f.this.cc.H());
                this.f3074b = false;
                f.this.cj.b(13, true);
                f.this.cj.b(b(), true);
            }
        }

        public void c() {
            e.a("CameraManager", "switch camera mode, cancleAnimation");
            f.this.k(false);
            f.this.d(-1);
            f.this.cc.c().r();
            this.d = true;
            this.f3074b = false;
            this.c = false;
        }

        public boolean d() {
            e.a("CameraManager", "switch camera mode, isAnimationRunning, mbRunning: " + this.f3074b);
            return this.f3074b;
        }

        public boolean e() {
            return this.c;
        }
    }

    /* access modifiers changed from: private */
    public boolean ch() {
        e.a("CameraManager", "canRunSwitchAnim, mbPaused: " + this.as + ", mAfterSwitchPrvSize: " + this.cO);
        return !this.as && this.cO != null;
    }

    /* compiled from: CameraManager */
    public class v implements e.c {
        public v() {
        }

        public void a() {
            e.a("CameraManager", "onSwitchAnimStart");
            if (!f.this.as) {
                if (f.this.cc.s()) {
                    f.this.cc.o(false);
                    f.this.cc.cO();
                }
                if (f.this.cc.C()) {
                    f.this.cc.b(false, true, false);
                }
                f.this.cc.D(false);
                if (f.this.cc.G()) {
                    f.this.cc.d(true, true, true);
                }
                if (f.this.cc.cb()) {
                    f.this.cc.c(true, true, true);
                }
                f.this.cc.b(f.this.ar());
                f.this.cc.n(false);
                f.this.cc.b((int) R.string.camera_slow_video_tips);
                f.this.cc.bV();
                f.this.cc.cf();
                if (!f.this.cj.i("pref_zoom_key") || f.this.cj.i("pref_expand_popbar_key")) {
                    f.this.a((Animation.AnimationListener) null);
                }
                f.this.cj.b(13, false);
                f.this.cj.b(12, false);
                boolean unused = f.this.dd = true;
            }
        }

        public void b() {
            e.a("CameraManager", "onSwitchAnimMiddle, mAfterSwitchPrvSize: " + f.this.cO);
            if (f.this.ch() && !f.this.cj.df()) {
                f.this.cc.a(f.this.cO, f.this.cO, false);
                f fVar = f.this;
                fVar.a(fVar.cO, false);
                if (!f.this.cj.g()) {
                    f.this.cc.a(f.this.cO, f.this.cO, true);
                }
            }
        }

        public void c() {
            e.e("CameraManager", "onSwitchAnimEnd");
            if (!f.this.as) {
                if (f.this.ch()) {
                    f.this.cj.b(2, true);
                    f.this.cc.a(f.this.cO, f.this.cj.a(f.this.bS), true);
                    f.this.cc.Q(true);
                    f.this.cc.e(true, false);
                    f.this.H();
                    f.this.ai();
                    f.this.cc.d(true, false);
                    if (f.this.bO != null) {
                        f.this.bO.onUserInteraction();
                    }
                    f.this.cj.ao();
                    if (f.this.cc.s()) {
                        if (f.this.cj.i("pref_filter_process_key")) {
                            f.this.cc.p(true);
                        } else {
                            f.this.cc.q(true);
                        }
                    }
                    String str = null;
                    if (f.this.cj.i("pref_portrait_new_style_menu")) {
                        str = "pref_portrait_new_style_menu";
                    } else if (f.this.cj.i("pref_filter_menu")) {
                        str = "pref_filter_menu";
                    } else if (f.this.cj.i("pref_video_filter_menu")) {
                        str = "pref_video_filter_menu";
                    } else if (f.this.cj.i("pref_night_filter_menu")) {
                        str = "pref_night_filter_menu";
                    }
                    if (str != null) {
                        f.this.cc.h(str);
                    }
                    if (!f.this.cj.i(CameraFunction.FACE_BEAUTY_PROCESS) || f.this.dW == null || !f.this.dW.aA()) {
                        f.this.cc.a(true, true, true, false);
                    } else {
                        f.this.cc.r(true);
                    }
                    f.this.ci();
                    f.this.e(false);
                    f.this.cj.b(13, true);
                    if (f.this.cO != null && !f.this.cj.df()) {
                        f fVar = f.this;
                        fVar.a(fVar.cO, false);
                    }
                }
                com.oppo.camera.ui.inverse.c.INS.setMaskAlpha(f.this.bO, true, true);
            }
        }

        public int a(int i) {
            int l = f.this.cj.l(i);
            if (Camera.l) {
                l += 150;
            }
            e.a("CameraManager", "getSwitchAnimTime, switchTime: " + l + ", cameraId: " + i);
            return l;
        }

        public void d() {
            e.a("CameraManager", "onSwitchAnimCancel");
            f.this.j(1);
            f.this.e(false);
            boolean unused = f.this.dd = false;
        }
    }

    /* compiled from: CameraManager */
    public class d implements d.a {

        /* renamed from: b  reason: collision with root package name */
        private Size f3057b = null;
        private Size c = null;

        public int b() {
            return 2;
        }

        public d() {
        }

        public void a(Size size) {
            e.a("CameraManager", "onSwitchAnimStart, Beauty3DState: " + f.this.cj.bj());
            this.f3057b = size;
            f.this.cc.d(false, false);
            f.this.cc.n(false);
            f.this.cc.i(false);
            if (!f.this.cj.i("pref_zoom_key") || f.this.cj.i("pref_expand_popbar_key")) {
                f.this.a((Animation.AnimationListener) null);
            }
            int bj = f.this.cj.bj();
            if (bj != 0) {
                if (bj == 1) {
                    f.this.cc.cf();
                    f.this.cj.b(10, false);
                    f fVar = f.this;
                    fVar.i(fVar.Q());
                    return;
                } else if (bj == 4) {
                    f.this.cc.y();
                    f.this.cc.d(false, true);
                    f fVar2 = f.this;
                    fVar2.i(fVar2.Q());
                    return;
                } else if (bj == 6) {
                    f.this.cj.b(14, true);
                    f fVar3 = f.this;
                    fVar3.i(fVar3.Q());
                    return;
                } else if (bj == 8) {
                    f.this.cj.b(10, false);
                    f.this.cj.b(14, true);
                } else {
                    return;
                }
            }
            f.this.ap();
            f.this.n(1);
        }

        public void a(Size size, Size size2) {
            e.a("CameraManager", "onSwitchAnimMiddle, mAfterSwitchPrvSize: " + f.this.cO);
            this.c = size;
            this.f3057b = size2;
            if (this.f3057b != null) {
                com.oppo.camera.ui.g g = f.this.cc;
                Size size3 = this.f3057b;
                g.a(size3, size3, false);
                if (f.this.cj.bj() == 0 || f.this.cj.bj() == 4) {
                    f.this.a(this.f3057b, false);
                }
            }
        }

        public void a() {
            f.this.cc.Q(true);
            e.e("CameraManager", "onSwitchAnimEnd, Beauty3DState: " + f.this.cj.bj());
            if (f.this.dM != null) {
                f.this.dM.b(true);
            }
            int bj = f.this.cj.bj();
            if (f.this.cj.bj() == 0 || f.this.cj.bj() == 4) {
                f.this.H();
                f.this.ai();
                if (f.this.bO != null) {
                    f.this.bO.onUserInteraction();
                }
                f.this.a(this.f3057b, true);
                f.this.cc.y();
                f.this.cj.b(10, true);
                f.this.ci();
                if (f.this.bP.getBoolean("key_bubble_type_custom_beuty3d", true) && f.this.cR && !f.this.cc.s() && com.oppo.camera.ui.preview.a.j.a(f.this.bO) == 1) {
                    f.this.cc.a((View) null, 5, f.this.bO.getResources().getDimensionPixelSize(R.dimen.bubble_type_beauty3d_custom_offset_x), f.this.bO.getResources().getDimensionPixelSize(R.dimen.bubble_type_beauty3d_custom_offset_y));
                }
                boolean unused = f.this.cR = false;
                if (!(f.this.cc == null || !f.this.cc.s() || f.this.cj == null)) {
                    f.this.cj.a(f.this.cc.z());
                }
                if (f.this.cj.bj() == 4) {
                    e.e("CameraManager", "onSwitchAnimEnd, retsetBeauty3DState");
                    f.this.cj.j(0);
                }
                f.this.cc.i(true);
            } else if (bj == 1 || bj == 6 || bj == 7 || bj == 8 || bj == 10) {
                f.this.cj.b(15, true);
            }
            f.this.k(false);
            f.this.d(-1);
            f.this.g(false);
            f.this.e(false);
        }
    }

    /* access modifiers changed from: private */
    public void ci() {
        if (this.cj == null || !this.cj.i("pref_zoom_key") || this.cj.i("pref_expand_popbar_key") || this.cj.aV() || this.cc == null || this.cc.aP() || this.cc.s() || this.cc.C() || this.cc.G() || this.cc.ak()) {
            a((Animation.AnimationListener) null);
            v(false);
            return;
        }
        au();
        v(true);
    }

    /* compiled from: CameraManager */
    private class j implements ac.a {
        private j() {
        }

        public boolean a() {
            return f.this.cj.i("pref_zoom_key") && !f.this.cc.bT() && !f.this.at();
        }

        public void a(float f, boolean z, float f2) {
            e.a("CameraManager", "onZoomChange, zoomValue: " + f);
            if (f.this.cf != null) {
                boolean a2 = f.this.g(f);
                f fVar = f.this;
                if (Boolean.compare(a2, fVar.g(fVar.cf.b())) != 0) {
                    f.this.dN.removeMessages(21);
                    Message obtain = Message.obtain();
                    obtain.what = 21;
                    obtain.obj = Float.valueOf(f);
                    float[] configFloatArrayValue = CameraConfig.getConfigFloatArrayValue(ConfigDataBase.KEY_SAT_MAIN_ZOOM_RANGE);
                    f.this.dN.sendMessageDelayed(obtain, (configFloatArrayValue == null || 2 != configFloatArrayValue.length || Float.compare(f.this.cf.b(), configFloatArrayValue[0]) >= 0 || !f.this.g(f)) ? 0 : 480);
                }
            }
            if (f.this.cj != null && !f.this.cj.bx()) {
                b(f2);
            }
            if ("on".equals(f.this.bP.getString("pref_subsetting_key", "off"))) {
                f.this.bP.edit().putString("pref_subsetting_key", "off").apply();
            }
            if (f.this.cc != null && f.this.cc.ba()) {
                f.this.cc.bC();
            }
            f.this.b(f, true);
            if (f.this.cj != null) {
                f.this.cj.bi();
            }
        }

        private void b(float f) {
            int ar = f.this.ar();
            if (a(f)) {
                f.this.A(ar);
            } else {
                f.this.cc.b(ar);
            }
        }

        public void b() {
            f.this.bV.q();
        }

        public void c() {
            f.this.bV.p();
        }

        public boolean a(float f) {
            return f.this.d(f);
        }

        public boolean d() {
            if (f.this.bR == null || f.this.cj == null || !f.this.cj.i("pref_zoom_key") || f.this.cj.aK() || f.this.cj.aO() || f.this.cj.T() || !f.this.S() || f.this.aD || f.this.aA || f.this.aC || f.this.cZ) {
                e.e("CameraManager", "getZoomMenuEnabled, isPreviewStarted: " + f.this.S() + ", mbSizeChanging: " + f.this.aD + ", mbSwitchingCamera: " + f.this.aA + ", mbCaptureModeChanging: " + f.this.aC + ", mbSendCapturePictureRequest: " + f.this.cZ);
                return false;
            } else if (f.this.cc != null && !f.this.cc.cF() && (!f.this.cc.dc() || f.this.cc.da())) {
                return true;
            } else {
                e.a("CameraManager", "getZoomMenuEnabled, headline is scrolling, disable ZoomMenu: " + f.this.cc.cF() + ", isDrawerDrag: " + f.this.cc.dc() + ", isDrawerLayoutHeightNone: " + f.this.cc.da());
                return false;
            }
        }

        public Size e() {
            if (f.this.cc != null) {
                return f.this.cc.aX();
            }
            return null;
        }

        public void f() {
            if (f.this.bR != null) {
                f.this.bR.q(true);
            }
            if (f.this.cj != null) {
                f.this.cj.E();
            }
            if (f.this.cc != null) {
                f.this.cc.cd();
            }
            if (f.this.cN != null) {
                f.this.cN.c(false);
            }
            l();
        }

        public void g() {
            if (f.this.cc != null && !f.this.at()) {
                f.this.cc.ce();
            }
        }

        public void h() {
            if (f.this.cj != null && f.this.cc != null) {
                boolean z = false;
                if (f.this.bR != null) {
                    f.this.bR.q(false);
                }
                f.this.cj.D();
                if (!f.this.at()) {
                    f.this.cc.l(f.this.cj.aU(), (!f.this.cj.ak() || !f.this.cj.T()) && f.this.dW.aA());
                }
                if (f.this.aG()) {
                    f.this.cc.z(Color.argb(0, 0, 0, 0));
                }
                if (!f.this.cj.aM() && (f.this.cc.s() || f.this.cc.C())) {
                    f.this.a((Animation.AnimationListener) null);
                }
                if (f.this.cN != null) {
                    v A = f.this.cN;
                    if (f.this.m() && f.this.br()) {
                        z = true;
                    }
                    A.c(z);
                    f.this.cN.n();
                }
                if (f.this.b("pref_camera_gradienter_key") && "on".equals(f.this.bP.getString("pref_camera_gradienter_key", "off")) && f.this.cj.l().equals(ApsConstant.CAPTURE_MODE_PROFESSIONAL)) {
                    f.this.cc.a(f.this.S(), f.this.I);
                }
            }
        }

        public void i() {
            double bz = f.this.cj.bz();
            if (f.this.cj != null && f.this.cj.bx() && !f.this.ao && bz > 0.0d && f.this.cc != null) {
                f.this.cc.m(f.this.bO.getString(R.string.camera_zoom_not_support, new Object[]{Double.valueOf(bz)}));
            }
        }

        public boolean j() {
            return f.this.cj.g();
        }

        public boolean k() {
            return !f.this.cj.aM() && (f.this.cB == null || f.this.cB.c());
        }

        public void l() {
            f.this.cA();
        }

        public void m() {
            f.this.cB();
        }

        public boolean n() {
            return f.this.cj();
        }

        public boolean o() {
            return f.this.ck();
        }

        public boolean p() {
            return f.this.ay;
        }

        public boolean q() {
            return f.this.az;
        }

        public void a(int i) {
            f.this.cc.z(i);
        }

        public boolean r() {
            return f.this.cj.cl();
        }

        public boolean s() {
            if (f.this.ce != null) {
                return f.this.ce.y();
            }
            return false;
        }

        public void t() {
            if (f.this.cc != null && f.this.cc.J()) {
                f.this.cc.K();
            }
            if (f.this.bR != null) {
                f.this.bR.q(true);
            }
        }

        public void u() {
            if (f.this.bR != null) {
                f.this.bR.q(false);
            }
        }

        public boolean v() {
            return !f.this.D() && !f.this.cj.aB();
        }

        public boolean w() {
            if (f.this.cc != null) {
                return f.this.cc.cN();
            }
            return false;
        }

        public boolean x() {
            return f.this.D();
        }
    }

    /* compiled from: CameraManager */
    private class i implements TiltShiftManager.CameraTiltShiftListener {
        private i() {
        }

        public boolean getSupportTiltShif() {
            return f.this.cj.i(CameraFunction.TILT_SHIFT) && !f.this.cc.bT() && !f.this.at();
        }

        public boolean getTiltShifGestureEnabled() {
            if (f.this.bR == null || f.this.cj == null || !f.this.cj.i(CameraFunction.TILT_SHIFT) || f.this.cj.aK() || f.this.cj.aO() || f.this.cj.T() || !f.this.S() || f.this.aD || f.this.aA || f.this.aC || f.this.cZ) {
                e.e("CameraManager", "getTiltShifGestureEnabled, isPreviewStarted: " + f.this.S() + ", mbSizeChanging: " + f.this.aD + ", mbSwitchingCamera: " + f.this.aA + ", mbCaptureModeChanging: " + f.this.aC + ", mbSendCapturePictureRequest: " + f.this.cZ);
                return false;
            } else if (f.this.cc == null || !f.this.cc.cF()) {
                return true;
            } else {
                e.a("CameraManager", "getTiltShifGestureEnabled, headline is scrolling, disable ZoomMenu");
                return false;
            }
        }

        public boolean isEffectMenuAnimRunning() {
            if (f.this.cc != null) {
                return f.this.cc.cN();
            }
            return false;
        }

        public void setTiltShiftParams(TiltShiftParam tiltShiftParam) {
            e.a("CameraManager", "setTiltShiftParams, params: " + tiltShiftParam);
            f.this.cj.a(tiltShiftParam);
        }
    }

    /* access modifiers changed from: private */
    public boolean cj() {
        return this.cj != null && this.cj.bX();
    }

    /* access modifiers changed from: private */
    public boolean ck() {
        return this.cj != null && this.cj.bY();
    }

    public void u(boolean z2) {
        if (this.cc != null) {
            this.cc.T(z2);
        }
    }

    public boolean at() {
        if (this.f2941co != null) {
            return this.f2941co.d();
        }
        return false;
    }

    /* access modifiers changed from: private */
    public void m(String str) {
        if (this.f2941co == null) {
            this.f2941co = new com.oppo.camera.ui.control.h();
            this.f2941co.a((h.b) new w());
        }
        String bn2 = this.cj.bn();
        if (bn2 == null) {
            bn2 = this.bP.getString("pref_camera_photo_ratio_key", "standard");
        }
        boolean equals = "full".equals(bn2);
        B(Integer.valueOf(str).intValue());
        this.f2941co.a(Integer.valueOf(str).intValue(), this.bO, this.G, equals);
        if (this.cc != null && this.cc.J()) {
            this.cc.K();
        }
    }

    /* access modifiers changed from: private */
    public String cl() {
        String str;
        if (!S() || this.cj == null || !this.cj.i("pref_time_lapse_key") || this.cH.y() == 3) {
            return "off";
        }
        if (this.cj != null) {
            str = this.cj.ag();
        } else {
            str = "off";
        }
        if (p() && "on".equals(this.bP.getString("pref_camera_gesture_shutter_key", this.bO.getString(R.string.camera_gesture_shutter_default_value))) && "off".equals(str)) {
            str = "2";
        }
        if (!this.cH.n()) {
            return str;
        }
        String valueOf = String.valueOf(this.cH.p());
        this.cH.o();
        return valueOf;
    }

    private void B(int i2) {
        String string = this.bP.getString("pref_camera_countdown_effect_key", "on");
        if (Util.h("oplus.software.motor.breathled") && "on".equals(string) && this.ao) {
            h.a((Context) this.bO).a(i2);
        }
    }

    /* compiled from: CameraManager */
    private class w implements h.b {
        private w() {
        }

        public void a() {
            e.a("CameraManager", "onTimeOut, getCurrentModeName: " + f.this.cj.l());
            f.this.f(false, false);
        }

        public void b() {
            f.this.cc.ae(Util.b(f.this.cj.a(f.this.bS)));
            f.this.cj.Y();
            f.this.cj.b(3, false);
            f.this.a((Animation.AnimationListener) null);
            f.this.v(false);
            f.this.cc.c(false, false, false);
            f.this.cc.y(false);
        }

        public void c() {
            e.a("CameraManager", "onTimeUpdated, mbPaused: " + f.this.as + ", mPhoneState: " + f.this.X);
            if (!f.this.as && f.this.X == 0) {
                f.this.b(3);
            }
        }

        public void a(boolean z) {
            if (f.this.cc != null) {
                f.this.cc.d(true, false);
                if (!z || (f.this.cj != null && !f.this.cj.ak() && f.this.cj.al())) {
                    f.this.cc.h(0);
                    f.this.cc.j(0);
                    f fVar = f.this;
                    fVar.a(fVar.cj.a(f.this.bS), true);
                    f.this.cj.e(z);
                    f.this.cc.j();
                    f.this.cc.b(true);
                    f.this.cc.t(true);
                    f.this.cc.p(true);
                    f.this.cc.r(true);
                    f.this.cc.x(false);
                    f.this.cj.b(3, true);
                    if (!f.this.cj.i("pref_expand_popbar_key")) {
                        f.this.au();
                        f.this.v(true);
                    }
                }
                if (f.this.cH.y() == 3) {
                    return;
                }
                if (!z || (f.this.cj != null && !f.this.cj.ak() && f.this.cj.al())) {
                    if (f.this.cj.a()) {
                        if (!f.this.cj.i("pref_headline_control_by_mode")) {
                            f.this.cc.ah(true);
                        }
                    } else if (!f.this.cj.i("pref_headline_control_by_mode")) {
                        f.this.cc.a(0);
                    }
                    if (f.this.cj.i("pref_support_switch_camera")) {
                        f.this.cc.f(0);
                    } else {
                        f.this.cc.f(4);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void cm() {
        v vVar;
        if (this.cj.J() != null && this.cc != null && this.cc.s() && ((vVar = this.cN) == null || !vVar.j())) {
            this.cc.g(this.cj.J());
        } else if (this.cc != null) {
            this.cc.n(true);
        }
    }

    public void a(Animation.AnimationListener animationListener) {
        e.a("CameraManager", "hideZoomMenu, listener: " + animationListener);
        if (this.cf != null) {
            this.cf.a(animationListener);
        }
    }

    public void au() {
        e.a("CameraManager", "showOpticalZoomMenu");
        if ((this.cc == null || !this.cc.cQ() || !this.cc.cH()) && this.cf != null) {
            if (this.cc != null && this.cf.l()) {
                this.cc.n(true);
            }
            this.cf.c();
        }
    }

    public boolean av() {
        e.a("CameraManager", "collapseOpticalZoomMenu");
        if (this.cf != null) {
            return this.cf.b(false);
        }
        return false;
    }

    public void v(boolean z2) {
        e.a("CameraManager", "enableOpticalZoomMenu, enable: " + z2);
        if (this.cf != null) {
            this.cf.a(z2);
        }
    }

    /* access modifiers changed from: private */
    public boolean cn() {
        if (this.cj != null && this.cj.i(CameraFunction.TORCH_SOFT_LIGHT)) {
            return false;
        }
        String string = this.bP.getString("pref_camera_torch_mode_key", Util.y(this.bO));
        String string2 = this.bP.getString("pref_camera_hdr_mode_key", CameraConfig.getOptionKeyDefaultValue("pref_camera_hdr_mode_key", this.K));
        if (!"off".equals(string) && "on".equals(string2)) {
            return true;
        }
        if (!"on".equals(string) || !MenuClickMsgData.VALUE_PROFESSION_AUTO.equals(string2)) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public boolean co() {
        if (this.cj == null) {
            return false;
        }
        if (cj() || this.ao || ((CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_ALLMIGHTY_VIDEO) && this.cj.cE()) || (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_ULTRA_NIGHT_VIDEO_WIDE_ANGLE) && this.cj.cD()))) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    public boolean n(String str) {
        if (this.aA || this.aC) {
            return false;
        }
        String c2 = com.oppo.camera.entry.b.c(str);
        if ("pref_video_size_key".equals(c2) || "pref_camera_photo_ratio_key".equals(c2) || "pref_platform_slow_video_fps_key".equals(c2)) {
            return true;
        }
        if ("pref_camera_hdr_mode_key".equals(c2) || "key_video_hdr".equals(c2)) {
            return b(CameraFunction.VIDEO_HDR);
        }
        if ("pref_camera_torch_mode_key".equals(c2)) {
            if (!b("pref_camera_hdr_mode_key") || !cn()) {
                return false;
            }
            return true;
        } else if ("pref_video_tilt_shift_key".equals(c2) || "pref_video_timelapse_tilt_shift_key".equals(c2) || "pref_photo_tilt_shift_key".equals(c2)) {
            return b(CameraFunction.TILT_SHIFT);
        } else {
            if ("key_ultra_night_video".equals(c2)) {
                return b(CameraFunction.ULTRA_NIGHT_VIDEO);
            }
            if ("key_ai_enhancement_video".equals(c2)) {
                return b(CameraFunction.AI_ENHANCEMENT_VIDEO);
            }
            if ("pref_film_video_log".equals(c2)) {
                return b("pref_film_video_log");
            }
            return false;
        }
    }

    /* access modifiers changed from: private */
    public boolean cp() {
        if (this.cj.i("pref_camera_videoflashmode_key")) {
            return this.cc.l("pref_camera_videoflashmode_key");
        }
        if (this.cj.i("pref_camera_flashmode_key")) {
            return this.cc.l("pref_camera_flashmode_key");
        }
        return cr();
    }

    /* access modifiers changed from: private */
    public void cq() {
        if (this.cf != null) {
            this.cf.f(false);
        }
    }

    /* access modifiers changed from: private */
    public boolean g(float f2) {
        if (this.cj == null) {
            return false;
        }
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_FLASH_FULL_ZOOM)) {
            return this.cj.b(f2);
        }
        return this.cj.a(f2);
    }

    /* access modifiers changed from: private */
    public boolean cr() {
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_FLASH_FULL_ZOOM)) {
            return true;
        }
        if (this.cj == null || !this.cj.bT()) {
            if (this.cj != null && this.cj.i("pref_switch_dual_camera_key") && this.bP != null && !CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_FLASH_FULL_ZOOM)) {
                return "camera_main".equals(this.bP.getString("pref_switch_camera_key", "camera_main"));
            }
            if (this.cj != null && ((this.cj.bX() || this.cj.bY()) && !CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_FLASH_FULL_ZOOM))) {
                return false;
            }
            if (this.cj != null && this.cj.by()) {
                return false;
            }
            if (this.cj == null || !cd() || !this.cj.ce()) {
                return true;
            }
            return false;
        } else if (!this.bz) {
            return g(aN());
        } else {
            this.bz = false;
            return false;
        }
    }

    /* access modifiers changed from: private */
    public void cs() {
        if (this.cj != null) {
            this.cj.bD();
        }
    }

    /* access modifiers changed from: private */
    public void ct() {
        if (!this.cj.bB() && !this.cc.G()) {
            this.cc.a((int) R.string.camera_video_blur_open, -1, true, false, false);
            this.cc.w(true);
            this.cc.F();
        } else if (!this.cj.bB() && this.cc.G()) {
            this.cc.b((int) R.string.camera_video_blur_open);
            if (this.cj.i(CameraFunction.KEY_VIDEO_SUPER_EIS_WIDE)) {
                this.cc.v(true);
            }
            if (this.cj.i("pref_video_super_eis_key") && !this.ao) {
                this.cc.E();
            }
        }
        this.cc.D(false);
    }

    /* access modifiers changed from: private */
    public void b(int i2, boolean z2, boolean z3) {
        if (this.cj != null) {
            this.cj.d(i2);
            if (!this.as && z2) {
                cA();
            }
        }
    }

    private void cu() {
        if (this.cp == null) {
            this.cp = new ThumbnailProcessor();
            this.cp.setThumbNailProcessListener(this.dY);
        }
    }

    /* access modifiers changed from: private */
    public e.a cv() {
        if (this.f0do == null) {
            this.f0do = new e.a() {
                public void a(com.oppo.camera.ui.control.e eVar) {
                    f.this.bO.runOnUiThread(new Runnable() {
                        public void run() {
                            if (f.this.cc != null) {
                                f.this.cc.c(true);
                            }
                        }
                    });
                }
            };
        }
        return this.f0do;
    }

    public boolean aw() {
        if (this.cj == null || this.cc == null || this.cc.aT() == null || this.cc.aT().getVisibility() != 0 || !this.cc.aT().isClickable() || !this.cc.aT().isEnabled() || (aG() && this.cj.i("pref_sticker_process_key"))) {
            return false;
        }
        e.a("CameraManager", "checkVolumeCanCapture, getCurrentModeName: " + this.cj.l());
        if (!ApsConstant.CAPTURE_MODE_COMMON.equals(this.cj.l()) || !this.aG) {
            return true;
        }
        return false;
    }

    public boolean ax() {
        return "on".equals(this.bP.getString("pref_camera_slogan_key", this.bO.getString(R.string.camera_slogan_default_value)));
    }

    public boolean ay() {
        return "on".equals(this.bP.getString("pref_camera_video_slogan_key", this.bO.getString(R.string.camera_slogan_default_value)));
    }

    public byte[] az() {
        if (this.cs == null || this.cj == null) {
            return null;
        }
        if ((!ax() || !this.cj.i("pref_camera_slogan_key")) && (!ay() || !this.cj.i("pref_camera_video_slogan_key"))) {
            return null;
        }
        return this.cs.d();
    }

    public Size aA() {
        if (this.cs == null || this.cj == null) {
            return null;
        }
        if ((!ax() || !this.cj.i("pref_camera_slogan_key")) && (!ay() || !this.cj.i("pref_camera_video_slogan_key"))) {
            return null;
        }
        return this.cs.b();
    }

    public int aB() {
        if (this.cs == null || this.cj == null) {
            return 0;
        }
        if ((!ax() || !this.cj.i("pref_camera_slogan_key")) && (!ay() || !this.cj.i("pref_camera_video_slogan_key"))) {
            return 0;
        }
        return this.cs.c();
    }

    public void a(KeyEvent keyEvent) {
        long downTime = keyEvent.getDownTime();
        if (this.bo && keyEvent.getRepeatCount() == 0 && downTime - this.ad > 600) {
            this.ad = downTime;
            aC();
        } else if (this.bo && keyEvent.getRepeatCount() > 0) {
            this.ad = downTime;
        }
    }

    public boolean a(String str, boolean z2) {
        String b2 = this.cT.b();
        e.a("CameraManager", "checkToSwitchMode, lastModeName: " + b2 + ", modeName: " + str);
        if (str == null || TextUtils.equals(str, b2)) {
            return false;
        }
        v vVar = this.cN;
        if (vVar != null) {
            vVar.c(false);
        }
        e.a("CameraSwitchModePerformance.checkToSwitchMode");
        com.oppo.camera.e.a a2 = this.cj.a(str);
        a2.i(this.K);
        o oVar = this.cS;
        a2.j(oVar != null ? oVar.a() : false);
        o oVar2 = this.cS;
        if (oVar2 != null && !oVar2.c()) {
            this.cS.l();
            ap();
        }
        this.bt = true;
        j(0);
        SharedPreferences.Editor edit = this.bP.edit();
        edit.putString("pref_camera_mode_key", str);
        edit.apply();
        com.oppo.camera.ui.control.c o2 = a2.o();
        o2.a(a2.k());
        this.cc.b(o2);
        this.cj.b(13, false);
        A(a2.f("pref_camera_torch_mode_key"));
        a2.g(true);
        this.cd.a(a2.du());
        this.cc.a(a2.du());
        this.cc.af(a(a2));
        this.cc.ag(j(str));
        if (z2 && a2.f("key_support_mode_change_vibrate")) {
            cz();
        }
        this.ct.onSwitchMode(str);
        e.b("CameraSwitchModePerformance.checkToSwitchMode");
        return true;
    }

    private void A(boolean z2) {
        boolean z3;
        if (z2) {
            String string = this.bP.getString("pref_camera_torch_mode_key", Util.y(this.bO));
            z3 = string.equals("on");
            if (string.equals(MenuClickMsgData.VALUE_PROFESSION_AUTO)) {
                return;
            }
        } else {
            z3 = false;
        }
        com.oppo.camera.ui.inverse.c.INS.setInverseColor((Context) this.bO, z3, true);
        bp();
    }

    public boolean d(String str) {
        return a(str, true);
    }

    private void o(String str) {
        if (!S() || !this.bi) {
            e.a("CameraManager", "gimbalChangeModeFunction, return , mCameraState: " + this.E + ", mbFrameAvailable: " + this.bi);
        } else if (aO()) {
            e.a("CameraManager", "gimbalChangeModeFunction invalid, zoom animation is running");
        } else if (at()) {
            e.a("CameraManager", "gimbalChangeModeFunction invalid, timesnap is running");
        } else if (aG()) {
            e.a("CameraManager", "gimbalChangeModeFunction invalid, video record started");
        } else {
            this.cc.ai(true);
            this.cc.b(this.K, str);
            this.cc.a(0);
            if (!d(str)) {
                this.cc.ah(true);
                this.cc.a(4);
            }
        }
    }

    public boolean c(int i2, KeyEvent keyEvent) {
        if (!this.aA && this.bn && !this.cc.bT() && !this.cc.aP() && S() && !D() && !this.aC && !at() && this.cj.i("pref_zoom_key") && !this.cj.T()) {
            if (168 == i2) {
                if (this.cf != null) {
                    this.cf.h(true);
                }
            } else if (169 == i2 && this.cf != null) {
                this.cf.h(false);
            }
        }
        return true;
    }

    public boolean d(int i2, KeyEvent keyEvent) {
        long downTime = keyEvent.getDownTime();
        String string = this.bP.getString("pref_volume_key_function_key", this.bO.getString(R.string.camera_volume_key_function_default_value));
        if (this.bo && keyEvent.getRepeatCount() == 0 && 600 >= downTime - this.ad) {
            return true;
        }
        if ("shutter".equals(string)) {
            if (this.bo && keyEvent.getRepeatCount() == 0 && aw()) {
                this.aE = false;
            } else if (!this.aE && keyEvent.getRepeatCount() > 0 && 600 < downTime - this.ad) {
                this.aE = true;
                this.ad = downTime;
                aE();
            }
            return true;
        } else if (!CameraStatisticsUtil.PORTRAIT_ZOOM.equals(string)) {
            return false;
        } else {
            if (!this.aA && this.bn && !this.cc.bT() && !this.cc.aP() && ((this.cf == null || !this.cf.h()) && S() && !this.aC && !D() && !at() && this.cj.i("pref_zoom_key") && !this.cj.T() && !this.cc.dc())) {
                if (i2 == 24) {
                    if (this.cf != null) {
                        this.cf.h(true);
                    }
                } else if (this.cf != null) {
                    this.cf.h(false);
                }
            }
            return true;
        }
    }

    /* access modifiers changed from: private */
    public boolean d(boolean z2, boolean z3) {
        boolean z4;
        if (this.cj == null) {
            return false;
        }
        if (this.cc.aP()) {
            e.d("CameraManager", "checkReadyToCapture, video alert showing, so return");
            return false;
        }
        if (ApsConstant.CAPTURE_MODE_PANORAMA.equals(this.cj.l())) {
            z4 = a(4) && a(5);
        } else {
            z4 = a(0);
        }
        if (this.as || !this.bn || !z4) {
            e.d("CameraManager", "checkReadyToCapture, mbPaused: " + this.as + ", mbInitialized: " + this.bn + ", isSoundLoaded: " + z4);
            return false;
        } else if (this.cc.ca()) {
            e.d("CameraManager", "checkReadyToCapture, isEffectMenuScrolling, so return");
            return false;
        } else if (this.bu || (this.cf != null && this.cf.o())) {
            e.d("CameraManager", "checkReadyToCapture, mZoomExecutor is excuting, so return, mbZoomStateChanging: " + this.bu);
            return false;
        } else if (!aP()) {
            e.d("CameraManager", "checkReadyToCapture, zoomValue is not fit sensor mask, so return");
            return false;
        } else if (!com.oppo.camera.n.b.a().a(this.bO, this.cj.N())) {
            e.d("CameraManager", "checkReadyToCapture, memory or storage is not enough");
            this.cj.M();
            a(ReminderMsgData.TYPE_DISABLE_CODE, ReminderMsgData.CODE_MEMORY_CAPTURE);
            return false;
        } else if (z.t != 0) {
            e.d("CameraManager", "checkReadyToCapture, sStorageStatus is failed, so return");
            if (this.bO != null) {
                this.bO.runOnUiThread(new Runnable() {
                    public void run() {
                        if (f.this.cc != null) {
                            f.this.cc.o();
                        }
                    }
                });
            }
            return false;
        } else {
            if (com.oppo.camera.ui.menu.f.a() && this.bO != null) {
                this.bO.runOnUiThread(new Runnable() {
                    public void run() {
                        com.oppo.camera.ui.menu.f.d();
                    }
                });
            }
            int e2 = com.oppo.camera.n.b.a().e();
            if (this.cj != null && ((this.cj.i("pref_raw_control_key") || this.cj.i("pref_super_raw_control_key")) && e2 > 3)) {
                e.d("CameraManager", "checkReadyToCapture, rawCount: " + e2);
                this.cc.a((int) R.string.camera_toast_camera_Low_memory_hint, -1, true, false, false);
                a(ReminderMsgData.TYPE_DISABLE_CODE, ReminderMsgData.CODE_MEMORY_CAPTURE);
                return false;
            } else if (this.aA || this.aG || d() || this.aC || this.aD) {
                e.d("CameraManager", "checkReadyToCapture, mbSwitchingCamera: " + this.aA + ", mbBurstShot: " + this.aG + ", isAnimationRunning: " + d() + ", mbCaptureModeChanging: " + this.aC + ", mbSizeChanging: " + this.aD);
                return false;
            } else if (this.cj.c(false)) {
                e.d("CameraManager", "checkReadyToCapture, stopTakePicture sucess, so return");
                return false;
            } else if (!this.cY) {
                e.d("CameraManager", "checkReadyToCapture, mbApsFinishAddFrame: " + this.cY);
                if (this.aB) {
                    this.dN.removeMessages(24);
                    this.dN.sendEmptyMessageDelayed(24, 1000);
                }
                return false;
            } else if (!S() && !U()) {
                e.d("CameraManager", "checkReadyToCapture, mCameraState: " + this.E + ", so return");
                return false;
            } else if (z2 && this.ce != null && this.ce.c(z3)) {
                e.d("CameraManager", "checkReadyToCapture, checkStateBeforeCapture true, so return");
                return false;
            } else if (!this.cj.T() && S()) {
                return true;
            } else {
                e.d("CameraManager", "checkReadyToCapture, mCameraState: " + this.E + ", getIsCapturingState: " + this.cj.T() + ", so return");
                return false;
            }
        }
    }

    public void aC() {
        if (this.cc != null) {
            this.cc.bI();
        }
    }

    public void aD() {
        if (this.cc != null) {
            this.cc.bK();
        }
    }

    public void aE() {
        if (this.cc != null) {
            this.cc.bJ();
        }
    }

    /* access modifiers changed from: private */
    public void cw() {
        if (this.cj.g()) {
            e(true, false);
        } else {
            this.ea.k();
        }
    }

    /* access modifiers changed from: private */
    public void e(boolean z2, boolean z3) {
        int i2;
        if (T() || (i2 = this.E) == 5 || i2 == 4) {
            e.d("CameraManager", "capturePhoto, mCameraState: " + this.E + ", so return");
            return;
        }
        String cl2 = cl();
        if (at() && !this.f2941co.e()) {
            B(0);
            this.f2941co.f();
            this.dm = VideoRecordMsgData.END_TYPE_NORMAL;
        } else if (!"off".equals(cl2)) {
            m(cl2);
        } else {
            f(z2, z3);
        }
    }

    /* access modifiers changed from: private */
    public void f(final boolean z2, final boolean z3) {
        this.cZ = true;
        if (this.bR == null) {
            e.e("CameraManager", "capture, mOneCamera is null, so return");
            this.cZ = false;
            return;
        }
        e.a("CameraManager", "capture, mbSendCapturePictureRequest: " + this.cZ + ", needCheckAFStatus: " + z2);
        this.bR.m().post(new Runnable() {
            public void run() {
                if (!f.this.d(z2, z3)) {
                    if (f.this.dN != null) {
                        Bundle bundle = new Bundle();
                        bundle.putBoolean("view_enable", true);
                        bundle.putBoolean("view_ashed", false);
                        f.this.dN.removeMessages(14);
                        Message obtainMessage = f.this.dN.obtainMessage(14);
                        obtainMessage.setData(bundle);
                        obtainMessage.sendToTarget();
                    }
                    String unused = f.this.dm = VideoRecordMsgData.END_TYPE_NORMAL;
                    if (f.this.bO != null) {
                        f.this.bO.runOnUiThread(new Runnable() {
                            public void run() {
                                if (f.this.at()) {
                                    f.this.f2941co.f();
                                }
                            }
                        });
                    }
                    boolean unused2 = f.this.cZ = false;
                    f.this.a(true);
                    return;
                }
                int unused3 = f.this.aT = 0;
                f.this.u(true);
                if (f.this.bO != null) {
                    f.this.bO.runOnUiThread(new Runnable() {
                        public void run() {
                            if (f.this.at()) {
                                f.this.f2941co.f();
                            }
                        }
                    });
                }
                if (f.this.ck != null && f.this.cj.bG()) {
                    f.this.ck.a(true);
                }
                if (f.this.cc != null) {
                    f.this.cc.aq(false);
                }
                if (f.this.J()) {
                    e.e("CameraManager", "CameraTest Shutter Respond Start");
                    if (!f.this.cj.u()) {
                        if (f.this.bO != null) {
                            f.this.bO.runOnUiThread(new Runnable() {
                                public void run() {
                                    if (f.this.cc != null) {
                                        f.this.cc.d(true, false);
                                    }
                                }
                            });
                        }
                        f.this.j(1);
                        f.this.a(true);
                    }
                    String unused4 = f.this.dm = VideoRecordMsgData.END_TYPE_NORMAL;
                    boolean unused5 = f.this.cZ = false;
                    return;
                }
                if (f.this.af <= 0 || f.this.ag != 0) {
                    long unused6 = f.this.ag = -1;
                } else {
                    long unused7 = f.this.ag = System.currentTimeMillis() - f.this.af;
                }
                if (f.this.ah > 0) {
                    long unused8 = f.this.ai = System.currentTimeMillis() - f.this.ah;
                }
                long unused9 = f.this.ah = System.currentTimeMillis();
                e.e("CameraManager", "CameraTest Shutter Respond Start");
                com.oppo.camera.perf.a.a("capture");
                com.oppo.camera.perf.a.a("picture_save");
                if (!(!f.this.cj.bG() || f.this.dW == null || f.this.ck == null)) {
                    com.oppo.camera.t.a a2 = f.this.ck.a(System.currentTimeMillis());
                    f.this.cj.a(a2);
                    if (a2 == null || !a2.c() || f.this.D()) {
                        f.this.cc.a((com.oppo.camera.t.a) null);
                    } else {
                        f.this.cc.a(a2);
                        f.this.dW.b(a2);
                    }
                }
                e.a("CameraCapturePerformance.capture");
                if (!f.this.cj.u()) {
                    e.d("CameraManager", "doCapture, capture failed for some reason!");
                    if (f.this.bO != null) {
                        f.this.bO.runOnUiThread(new Runnable() {
                            public void run() {
                                f.this.v(true);
                                if (f.this.cj != null && f.this.cc != null) {
                                    f.this.cj.b(12, true);
                                    f.this.cc.d(true, true);
                                    if (!f.this.aG()) {
                                        f.this.cc.a(f.this.cj.f(), f.this.cD());
                                    }
                                }
                            }
                        });
                    }
                    f.this.j(1);
                    f.this.a(true);
                }
                e.b("CameraCapturePerformance.capture");
                String unused10 = f.this.dm = VideoRecordMsgData.END_TYPE_NORMAL;
                boolean unused11 = f.this.cZ = false;
            }
        });
        if (aj()) {
            t(false);
        }
    }

    /* access modifiers changed from: private */
    public boolean cx() {
        if (this.cj == null) {
            return false;
        }
        if (this.cj.ac()) {
            if (this.cj.l().equals(ApsConstant.CAPTURE_MODE_MICROSCOPE)) {
                d(ApsConstant.REC_MODE_MICROSCOPE);
            } else {
                d(ApsConstant.CAPTURE_MODE_MICROSCOPE);
            }
            this.cc.q(true);
            return true;
        } else if (!this.cj.cO() || !CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_STAR_VIDEO)) {
            return false;
        } else {
            if (this.cj.l().equals(ApsConstant.CAPTURE_MODE_STARRY)) {
                d(ApsConstant.REC_MODE_STAR_VIDEO);
            } else {
                d(ApsConstant.CAPTURE_MODE_STARRY);
            }
            return true;
        }
    }

    /* access modifiers changed from: private */
    public void cy() {
        boolean z2 = true;
        int i2 = this.bP.getInt("pref_multicamera_show_position_state_key", 1) == 1 ? 2 : 1;
        this.bP.edit().putInt("pref_multicamera_show_position_state_key", i2).apply();
        int i3 = this.bP.getInt("pref_multicamera_type_selected_key", 0);
        e.b("CameraManager", "switchMultiVideoSurface: type: " + i3 + ", currentState: " + i2);
        if (i3 == 0) {
            com.oppo.camera.ui.g gVar = this.cc;
            if (1 != i2) {
                z2 = false;
            }
            gVar.H(z2);
        } else {
            bF();
        }
        this.dW.aB();
        if (this.cc.ak()) {
            e.b("CameraManager", "switchMultiVideoSurface, consumed by MultiVideoSmallSurface");
            this.cc.al();
        }
    }

    public boolean aF() {
        return this.cj != null && this.cj.cN();
    }

    /* access modifiers changed from: private */
    public void cz() {
        if (this.cB != null) {
            this.cB.e();
        }
    }

    /* access modifiers changed from: private */
    public void cA() {
        if (this.cB != null) {
            this.cB.d();
        }
    }

    /* access modifiers changed from: private */
    public void cB() {
        if (this.cB != null) {
            this.cB.f();
        }
    }

    public boolean aG() {
        return this.cj.aM();
    }

    public boolean aH() {
        return this.cj.aN();
    }

    public boolean aI() {
        return this.cj.T();
    }

    public void aJ() {
        if (this.cu != null) {
            this.cu.h();
        }
    }

    public void aK() {
        if (this.cj != null) {
            this.cj.cn();
            this.cj.b(this.K);
        }
        this.ao = com.oppo.camera.f.a.c(this.K);
        com.oppo.camera.ui.preview.a.n nVar = this.cd;
        if (nVar != null) {
            nVar.a(this.K);
        }
    }

    /* compiled from: CameraManager */
    private class x implements o.f {
        private x() {
        }

        public void a(Location location, boolean z) {
            f fVar = f.this;
            fVar.a(fVar.bO.getApplicationContext(), location, z);
        }

        public boolean a() {
            return f.this.bV.r();
        }
    }

    public void a(ApsResult.ImageBuffer imageBuffer, int i2) {
        if (this.cj != null && this.cj.az() && imageBuffer != null) {
            ImageCategory.ImageItemInfo imageItemInfo = new ImageCategory.ImageItemInfo();
            imageItemInfo.mImageBuffer = imageBuffer;
            imageItemInfo.mApsServiceListener = this.df;
            imageItemInfo.setParameter(ParameterKeys.KEY_IMAGE_FORMAT, Integer.valueOf(imageBuffer.getHardwareBuffer().getFormat()));
            imageItemInfo.setParameter(ParameterKeys.KEY_IMAGE_WIDTH, Integer.valueOf(imageBuffer.getHardwareBuffer().getWidth()));
            imageItemInfo.setParameter(ParameterKeys.KEY_IMAGE_HEIGHT, Integer.valueOf(imageBuffer.getHardwareBuffer().getHeight()));
            imageItemInfo.setParameter(ParameterKeys.KEY_IMAGE_ROLE, Integer.valueOf(i2));
            imageItemInfo.setParameter(ParameterKeys.KEY_TIME_STAMP, Long.valueOf(imageBuffer.getTimestamp()));
            imageItemInfo.setParameter(ParameterKeys.KEY_ORIENTATION, Integer.valueOf(this.F));
            imageItemInfo.setParameter(ParameterKeys.KEY_REC_BURST_NUMBER, -1);
            imageItemInfo.setParameter(ParameterKeys.KEY_BURST_SHOT, false);
            imageItemInfo.setParameter(ParameterKeys.KEY_DATE, Long.valueOf(System.currentTimeMillis()));
            if (this.cj.bG()) {
                imageItemInfo.setParameter(ParameterKeys.KEY_SUPER_TEXT_RESULT_PROCESSOR, this.dE);
                imageItemInfo.setParameter(ParameterKeys.KEY_PICTURE_TAKEN_CALL_BACK, this.dF);
                imageItemInfo.setParameter(ParameterKeys.KEY_IS_SUPER_TEXT_OPEN, true);
            }
            this.cj.u(false);
            e.a("CameraManager", "addCaptureImageToAPS, mTimeStamp: " + imageItemInfo.get(ParameterKeys.KEY_TIME_STAMP) + ", role: " + i2 + ", imageItem.mDate: " + imageItemInfo.get(ParameterKeys.KEY_DATE));
            e.a("CameraCapturePerformance.addCaptureImageToAPS");
            ApsService apsService = this.de;
            if (apsService != null) {
                apsService.addCaptureImageInfo(imageItemInfo);
            }
            e.b("CameraCapturePerformance.addCaptureImageToAPS");
        }
    }

    public void a(ComponentName componentName, IBinder iBinder) {
        this.de = ((ApsService.LocalBinder) iBinder).getService();
        bg();
        if (this.cj != null) {
            this.cj.a(this.de);
        }
        this.dg.open();
        if (this.du != null) {
            this.du.a(this.de);
        }
        e.a("CameraManager", "onServiceConnected, mApsService: " + this.de);
        this.cC.postAtFrontOfQueue(new Runnable() {
            public void run() {
                if (f.this.di.mVendorTagKeyMap != null) {
                    f fVar = f.this;
                    fVar.a(3, fVar.di);
                }
            }
        });
    }

    /* compiled from: CameraManager */
    private class a implements ApsAdapterDecision.DecisionCallback {
        private a() {
        }

        public void onDecisionResult(ApsAdapterDecision.DecisionResult decisionResult) {
            if (f.this.cj != null) {
                f.this.cj.a(decisionResult);
            }
        }
    }

    /* compiled from: CameraManager */
    private class b implements ApsAdapterListener.ApsServiceListener, OnCaptureHeciDataListener {
        private b() {
        }

        public void onFinishAddFrame(ImageCategory.ImageItemInfo imageItemInfo, ImageCategory.MetaItemInfo metaItemInfo) {
            e.a("CameraManager", "onFinishAddFrame");
            f.this.bN.open();
            if (f.this.bR != null) {
                f.this.bR.b(true);
            }
            boolean unused = f.this.cY = true;
            if (f.this.cj != null) {
                if (imageItemInfo != null && metaItemInfo != null && !((Boolean) imageItemInfo.get(ParameterKeys.KEY_BURST_SHOT)).booleanValue() && ((Boolean) metaItemInfo.get(ParameterKeys.KEY_FAST_CAPTURE)).booleanValue()) {
                    e.a("CameraManager", "onFinishAddFrame, isBurstShot: " + imageItemInfo.get(ParameterKeys.KEY_BURST_SHOT));
                    f.this.cj.a((byte[]) null, ((Integer) imageItemInfo.get(ParameterKeys.KEY_IMAGE_WIDTH)).intValue(), ((Integer) imageItemInfo.get(ParameterKeys.KEY_IMAGE_HEIGHT)).intValue(), 256, false);
                }
                if (f.this.cj != null) {
                    f.this.cj.a(imageItemInfo, metaItemInfo);
                }
            }
        }

        public void onReprocess(Image image, TotalCaptureResult totalCaptureResult, Rect rect, ApsCameraRequestTag apsCameraRequestTag) {
            if (f.this.cj != null) {
                f.this.cj.a(image, totalCaptureResult, rect, (com.oppo.camera.f.d) apsCameraRequestTag.mTag);
            }
        }

        public void reportCaptureDataToDcs(Object obj, Object obj2) {
            if (obj != null && obj2 != null) {
                ThumbnailCategory thumbnailCategory = (ThumbnailCategory) obj;
                CaptureMsgData a2 = com.oppo.camera.a.a.a(com.oppo.camera.a.a.a(thumbnailCategory.mCaptureMsgData, thumbnailCategory), (z.a) obj2);
                if (a2 != null) {
                    a2.mProcessDuration = String.valueOf(PerformanceMsgData.getPointTime(CaptureMsgData.PROCESS_DURATION));
                    a2.report();
                }
            }
        }

        public void onPreviewReceived(ApsResult apsResult, ApsTotalResult apsTotalResult) {
            ApsResult.ImageBuffer imageBuffer = apsResult.getImageBuffer();
            CaptureResult totalResult = apsTotalResult.getTotalResult();
            if (imageBuffer == null) {
                e.e("CameraManager", "onPreviewReceived, get null buffer.");
            } else if (f.this.aC && f.this.cc != null && f.this.cc.c() != null && !f.this.aJ && f.this.cc.c().v()) {
                e.e("CameraManager", "onPreviewReceived, hasModeChangeTask");
                imageBuffer.close();
            } else if (f.this.cc == null || f.this.cc.c() == null) {
                e.e("CameraManager", "onPreviewReceived, mCameraUIManager is null");
                imageBuffer.close();
            } else {
                f.this.cc.c().a(imageBuffer, !f.this.aJ);
                if (!f.this.aJ) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("onPreviewReceived, first frame received, frameNumber: ");
                    sb.append(totalResult != null ? Long.valueOf(totalResult.getFrameNumber()) : "null");
                    e.c("CameraManager", sb.toString());
                    e.a("CameraStartupPerformance.receivedFirstFrameFromAPS");
                    boolean unused = f.this.aJ = true;
                    e.b("CameraStartupPerformance.receivedFirstFrameFromAPS");
                    if (f.this.cc != null) {
                        f.this.cc.ar(f.this.K == 0);
                        if (f.this.cc.c() != null) {
                            f.this.cc.c().l();
                        }
                    }
                    if (f.this.du != null) {
                        f.this.du.a(false);
                    }
                }
                if (!f.this.dC) {
                    boolean unused2 = f.this.dC = true;
                }
                if (f.this.as || f.this.aC || f.this.aA || f.this.aD || f.this.E == 0) {
                    e.e("CameraManager", "onPreviewReceived, mbPaused: " + f.this.as + ", mbCaptureModeChanging: " + f.this.aC + ", mbSwitchingCamera: " + f.this.aA + ", mbSizeChanging: " + f.this.aD + ", cameraState: " + f.this.E);
                    return;
                }
                f.this.ds.removeMessages(1);
                f.this.ds.sendMessage(f.this.dN.obtainMessage(1, apsTotalResult));
            }
        }

        public void onVideoReceived(ApsResult apsResult) {
            ApsResult.ImageBuffer imageBuffer = apsResult.getImageBuffer();
            if (imageBuffer != null) {
                imageBuffer.close();
            }
            if (1 == apsResult.mIsMotionDetected) {
                e.e("CameraManager", "onVideoReceived,  motionDetectedFrame Come.");
                if (f.this.cj != null) {
                    f.this.cj.cv();
                }
            }
            if (1 == apsResult.mIsStartInterpolationFrame) {
                e.e("CameraManager", "onVideoReceived, interpolationFrame Come.");
                if (f.this.cj != null) {
                    f.this.cj.cu();
                }
            }
            if (f.this.cj != null && ApsConstant.REC_MODE_SLOW_VIDEO.equals(f.this.cj.l())) {
                boolean unused = f.this.dz = apsResult.mbNeedDetach;
            }
            if (1 == apsResult.mIsLastVideoFrame) {
                e.e("CameraManager", "onVideoReceived, lastVideoFrameCome");
                if (f.this.cj != null) {
                    f.this.cj.ct();
                }
            }
        }

        public boolean onHeicReceived(ApsResult apsResult, ApsCameraRequestTag apsCameraRequestTag) {
            return f.this.cj != null && f.this.cj.a(apsResult, apsCameraRequestTag);
        }
    }

    public void b(Intent intent) {
        String action = intent.getAction();
        Bundle extras = intent.getExtras();
        e.e("CameraManager", "onReceiver, intent action: " + action + ", packageName: " + (extras != null ? extras.getString("android.media.EXTRA_RECORD_START_PACKAGE_TYPE") : null));
        if (action != null) {
            if (action.equals("android.intent.action.MEDIA_MOUNTED") || action.equals("android.intent.action.MEDIA_CHECKING")) {
                bx();
                return;
            }
            boolean z2 = false;
            if (action.equals("android.intent.action.MEDIA_SCANNER_FINISHED")) {
                z.a(this.bO.getApplicationContext());
                bx();
                if (!this.bd && !this.bc) {
                    if (!com.oppo.camera.n.b.a().g()) {
                        e.b("CameraManager", "onReceiver, imageSaveList is not Empty, so return.");
                    } else if (this.cH.y() == 1 && this.cj != null && !this.cj.aM() && !U()) {
                        this.cc.c(false);
                    }
                }
            } else if (action.equals("android.intent.action.MEDIA_UNMOUNTED")) {
                if (this.cj.aM() && "on".equals(this.bP.getString("pref_camera_storage_key", this.bO.getString(R.string.camera_storage_default_value)))) {
                    this.bV.m();
                }
                bx();
                this.cc.c(false);
            } else if (action.equals("android.intent.action.MEDIA_PRE_SHARED") || action.equals("android.intent.action.MEDIA_SHARED") || action.equals("android.intent.action.MEDIA_EJECT")) {
                if (this.cj.aM() && "on".equals(this.bP.getString("pref_camera_storage_key", this.bO.getString(R.string.camera_storage_default_value)))) {
                    this.bO.finish();
                }
            } else if ("com.oppo.gallery3d.action.DELETE_PICTURE".equals(action)) {
                if (this.cc != null && !this.as) {
                    this.cc.c(false);
                }
            } else if (intent.getAction().equals("android.intent.action.BATTERY_CHANGED")) {
                this.d = intent.getIntExtra("level", -1);
                g(this.d);
                if (intent.getIntExtra("plugged", 0) != 0) {
                    z2 = true;
                }
                this.cG = z2;
                e.a("CameraManager", "onReceiver, temperature: " + intent.getIntExtra("temperature", -1));
            } else if (!intent.getAction().equals("android.intent.action.SCREEN_OFF") || this.bw) {
                if (intent.getAction().equals("android.intent.action.USER_PRESENT")) {
                    if (!this.as) {
                        if (this.bd) {
                            s(true);
                        }
                        if (this.cc != null && this.cc.aU() == null) {
                            this.cc.bi();
                        }
                    }
                } else if ("android.intent.action.PHONE_STATE".equals(action)) {
                    String stringExtra = intent.getStringExtra("state");
                    this.X = ((TelephonyManager) this.bO.getSystemService("phone")).getCallState();
                    if (stringExtra != null) {
                        e.a("CameraManager", "onReceiver, phone state: " + stringExtra + ", mPhoneState: " + this.X);
                        if (TelephonyManager.EXTRA_STATE_OFFHOOK.equals(stringExtra) && !this.as && this.cj != null && this.cj.aM()) {
                            e.a("CameraManager", "onReceiver, phone offhook, forceStopVideoRecording");
                            this.cj.i(true);
                        }
                    }
                } else if ("android.intent.action.CLOSE_SYSTEM_DIALOGS".equals(action)) {
                    String stringExtra2 = intent.getStringExtra("reason");
                    e.a("CameraManager", "onReceiver, ACTION_CLOSE_SYSTEM_DIALOGS, reason: " + stringExtra2);
                    if ("homekey".equals(stringExtra2) || "recentapps".equals(stringExtra2)) {
                        this.bt = true;
                        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_ULTRA_WIDE_ANGLE_SUPPORT) && this.bP.contains("pref_none_sat_ultra_wide_angle_key")) {
                            h(true);
                            this.bP.edit().putString("pref_none_sat_ultra_wide_angle_key", "off").apply();
                            h(false);
                        }
                        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_NONE_SAT_TELE_SUPPORT) && this.bP.contains("pref_none_sat_tele_angle_key")) {
                            h(true);
                            this.bP.edit().putString("pref_none_sat_tele_angle_key", "off").apply();
                            h(false);
                        }
                        if (this.cj != null) {
                            this.cj.cm();
                        }
                        this.cH.a();
                        cH();
                        if (this.cc != null) {
                            this.cc.cS();
                        }
                        if (this.cH.m()) {
                            if (this.cj != null) {
                                this.cj.h(false);
                            }
                            if (!this.cW) {
                                com.oppo.camera.v.c.a().a(new Runnable() {
                                    public void run() {
                                        f.this.bW();
                                    }
                                }, "clearLockDB");
                                this.cW = true;
                            }
                            if (!this.as) {
                                if (this.bO != null) {
                                    this.bO.finishAndRemoveTask();
                                }
                                MyApplication.c();
                            }
                        }
                    }
                } else if (!"com.heytap.speechassist.intent.action.WINDOW_MANAGER_OCCUPIED".equals(action) || this.as) {
                    if ("com.heytap.speechassist.intent.action.FLOAT_ACTIVITY_START".equals(action)) {
                        this.bO.finish();
                    } else if ("android.location.MODE_CHANGED".equals(action)) {
                        if (this.cs != null) {
                            this.cs.g();
                        }
                        if (this.cu != null) {
                            this.cu.c();
                        }
                    }
                } else if (this.cj != null && this.cj.T()) {
                    this.cj.c(true);
                } else if (this.f2941co != null && this.f2941co.d()) {
                    this.f2941co.f();
                } else if (this.cj != null && this.cj.aM()) {
                    this.cj.i(false);
                }
            } else if (1 == ((WindowManager) this.bO.getSystemService("window")).getDefaultDisplay().getState()) {
                if (this.bP != null && cC()) {
                    this.cH.a();
                    this.cH.a(true);
                }
                cH();
                if (this.cc != null) {
                    this.cc.cS();
                }
                if (this.cj != null && this.as) {
                    this.cj.h(false);
                }
                if (!this.cW) {
                    if (this.cc != null && this.cc.bj()) {
                        this.cc.bi();
                    }
                    com.oppo.camera.v.c.a().a(new Runnable() {
                        public void run() {
                            f.this.bW();
                        }
                    }, "clearLockDB");
                    t(true);
                }
                if (this.cH.m()) {
                    b();
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x001c, code lost:
        r0 = r0.get(0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean cC() {
        /*
            r4 = this;
            android.app.Activity r0 = r4.bO
            android.content.Context r0 = r0.getApplicationContext()
            java.lang.String r1 = "activity"
            java.lang.Object r0 = r0.getSystemService(r1)
            android.app.ActivityManager r0 = (android.app.ActivityManager) r0
            r1 = 1
            java.util.List r0 = r0.getRunningTasks(r1)
            r2 = 0
            if (r0 == 0) goto L_0x002f
            int r3 = r0.size()
            if (r3 <= 0) goto L_0x002f
            java.lang.Object r0 = r0.get(r2)
            android.app.ActivityManager$RunningTaskInfo r0 = (android.app.ActivityManager.RunningTaskInfo) r0
            if (r0 == 0) goto L_0x002f
            android.content.ComponentName r3 = r0.topActivity
            if (r3 == 0) goto L_0x002f
            android.content.ComponentName r0 = r0.topActivity
            java.lang.String r0 = r0.getClassName()
            goto L_0x0030
        L_0x002f:
            r0 = 0
        L_0x0030:
            java.lang.Class<com.oppo.camera.Camera> r3 = com.oppo.camera.Camera.class
            java.lang.String r3 = r3.getName()
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x003d
            return r1
        L_0x003d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.f.cC():boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:44:0x0132  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0172  */
    /* JADX WARNING: Removed duplicated region for block: B:55:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void b(com.oppo.camera.z.a r11) {
        /*
            r10 = this;
            if (r11 != 0) goto L_0x0003
            return
        L_0x0003:
            java.lang.String r0 = r11.i
            r1 = 0
            java.lang.String r2 = "CameraManager"
            if (r0 == 0) goto L_0x0014
            java.lang.String r0 = r11.i
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x0014
            r0 = 1
            goto L_0x0032
        L_0x0014:
            byte[] r0 = r11.e
            if (r0 == 0) goto L_0x0175
            byte[] r0 = r11.e
            int r0 = r0.length
            if (r0 <= 0) goto L_0x0175
            java.lang.String r0 = r11.j
            java.lang.String r3 = "heic_8bits"
            boolean r0 = r3.equalsIgnoreCase(r0)
            if (r0 != 0) goto L_0x0175
            java.lang.String r0 = r11.j
            java.lang.String r3 = "heic_10bits"
            boolean r0 = r3.equalsIgnoreCase(r0)
            if (r0 != 0) goto L_0x0175
            r0 = r1
        L_0x0032:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "writeNearMeDateToExif, isJpegPath: "
            r3.append(r4)
            r3.append(r0)
            java.lang.String r3 = r3.toString()
            com.oppo.camera.e.b(r2, r3)
            if (r0 == 0) goto L_0x004f
            java.lang.String r0 = r11.i
            android.media.ExifInterface r0 = com.oppo.camera.util.Util.b((java.lang.String) r0)
            goto L_0x0055
        L_0x004f:
            byte[] r0 = r11.e
            android.media.ExifInterface r0 = com.oppo.camera.util.Util.a((byte[]) r0)
        L_0x0055:
            if (r0 != 0) goto L_0x0058
            return
        L_0x0058:
            com.oppo.camera.e.o r2 = r10.cj
            com.oppo.camera.statistics.CameraStatisticsUtil$MakerNote r2 = r2.aR()
            if (r2 != 0) goto L_0x0061
            return
        L_0x0061:
            int r3 = r10.K
            java.lang.String r3 = java.lang.String.valueOf(r3)
            r2.J = r3
            com.oppo.camera.e.o r3 = r10.cj
            java.lang.String r3 = r3.l()
            java.lang.String r3 = java.lang.String.valueOf(r3)
            r2.K = r3
            int r3 = r10.t()
            java.lang.String r3 = java.lang.String.valueOf(r3)
            r2.M = r3
            android.hardware.camera2.params.Face[] r3 = r10.bW
            if (r3 == 0) goto L_0x0102
            int r3 = r3.length
            if (r3 <= 0) goto L_0x0102
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            android.hardware.camera2.params.Face[] r5 = r10.bW
            int r6 = r5.length
        L_0x0093:
            if (r1 >= r6) goto L_0x00f6
            r7 = r5[r1]
            com.oppo.camera.statistics.CameraStatisticsUtil$FaceSize r8 = new com.oppo.camera.statistics.CameraStatisticsUtil$FaceSize
            r8.<init>()
            android.graphics.Rect r9 = r7.getBounds()
            int r9 = r9.width()
            java.lang.String r9 = java.lang.String.valueOf(r9)
            r8.N1 = r9
            android.graphics.Rect r9 = r7.getBounds()
            int r9 = r9.height()
            java.lang.String r9 = java.lang.String.valueOf(r9)
            r8.N2 = r9
            r3.add(r8)
            com.oppo.camera.statistics.CameraStatisticsUtil$FaceCoordinate r8 = new com.oppo.camera.statistics.CameraStatisticsUtil$FaceCoordinate
            r8.<init>()
            android.graphics.Rect r9 = r7.getBounds()
            int r9 = r9.left
            java.lang.String r9 = java.lang.String.valueOf(r9)
            r8.L1 = r9
            android.graphics.Rect r9 = r7.getBounds()
            int r9 = r9.top
            java.lang.String r9 = java.lang.String.valueOf(r9)
            r8.L2 = r9
            android.graphics.Rect r9 = r7.getBounds()
            int r9 = r9.right
            java.lang.String r9 = java.lang.String.valueOf(r9)
            r8.L3 = r9
            android.graphics.Rect r7 = r7.getBounds()
            int r7 = r7.bottom
            java.lang.String r7 = java.lang.String.valueOf(r7)
            r8.L4 = r7
            r4.add(r8)
            int r1 = r1 + 1
            goto L_0x0093
        L_0x00f6:
            r2.N = r3
            r2.L = r4
            int r1 = r10.T
            java.lang.String r1 = java.lang.String.valueOf(r1)
            r2.S = r1
        L_0x0102:
            com.oppo.camera.e.o r1 = r10.cj
            int r1 = r1.bp()
            java.lang.String r1 = java.lang.String.valueOf(r1)
            r2.R = r1
            com.google.gson.Gson r1 = new com.google.gson.Gson
            r1.<init>()
            java.lang.String r3 = "MakerNote"
            java.lang.String r0 = r0.getAttribute(r3)
            r3 = 0
            if (r0 == 0) goto L_0x012f
            boolean r4 = r0.isEmpty()
            if (r4 != 0) goto L_0x012f
            java.lang.Class<com.oppo.camera.statistics.CameraStatisticsUtil$MakerNote> r4 = com.oppo.camera.statistics.CameraStatisticsUtil.MakerNote.class
            java.lang.Object r0 = r1.fromJson((java.lang.String) r0, r4)     // Catch:{ JsonSyntaxException -> 0x012b }
            com.oppo.camera.statistics.CameraStatisticsUtil$MakerNote r0 = (com.oppo.camera.statistics.CameraStatisticsUtil.MakerNote) r0     // Catch:{ JsonSyntaxException -> 0x012b }
            goto L_0x0130
        L_0x012b:
            r0 = move-exception
            r0.printStackTrace()
        L_0x012f:
            r0 = r3
        L_0x0130:
            if (r0 == 0) goto L_0x0166
            java.lang.String r3 = r0.A
            r2.A = r3
            java.lang.String r3 = r0.B
            r2.B = r3
            java.util.ArrayList<com.oppo.camera.statistics.CameraStatisticsUtil$Face> r3 = r0.C
            r2.C = r3
            java.lang.String r3 = r0.I
            r2.I = r3
            java.lang.String r3 = r0.P
            r2.P = r3
            java.lang.String r3 = r0.Q
            r2.Q = r3
            java.lang.String r3 = r0.U
            r2.U = r3
            java.lang.String r3 = r0.V
            r2.V = r3
            java.lang.String r3 = r0.PiFlag
            r2.PiFlag = r3
            java.lang.String r3 = r0.nightFlag
            r2.nightFlag = r3
            java.util.ArrayList<java.lang.String> r3 = r0.asdOut
            r2.asdOut = r3
            java.lang.String r3 = r0.iso
            r2.iso = r3
            java.lang.String r0 = r0.expTime
            r2.expTime = r0
        L_0x0166:
            java.lang.String r0 = r1.toJson((java.lang.Object) r2)
            if (r0 == 0) goto L_0x0174
            boolean r1 = r0.isEmpty()
            if (r1 != 0) goto L_0x0174
            r11.H = r0
        L_0x0174:
            return
        L_0x0175:
            java.lang.String r11 = "writeNearMeDateToExif, picture is invalid"
            com.oppo.camera.e.b(r2, r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.f.b(com.oppo.camera.z$a):void");
    }

    public long aL() {
        if (this.cj != null) {
            return this.cj.aS();
        }
        return 0;
    }

    public void a(Context context, Location location, boolean z2) {
        if (location != null && context != null) {
            if (z2 && "zh-CN".equals(Util.aa())) {
                o.a a2 = com.oppo.camera.util.b.a(context, location);
                e.a("CameraManager", "onLocationUpdated, isLastKnownLocation: " + z2);
                if (a2 != null) {
                    a2.i = location;
                    this.cy = a2;
                    return;
                }
            }
            Thread thread = this.cx;
            if (thread == null || !thread.isAlive()) {
                e.a("CameraManager", "onLocationUpdated, isLastKnownLocation: " + z2);
                String string = this.bP.getString("pref_slogan_location_key", this.bO.getString(R.string.camera_slogan_default_value));
                String string2 = this.bP.getString("pref_video_slogan_location_key", this.bO.getString(R.string.camera_slogan_default_value));
                if (this.k == null) {
                    return;
                }
                if ("on".equals(string) || "on".equals(string2)) {
                    this.cx = new l("get_address_thread", context, location);
                    this.k.submit(this.cx);
                    return;
                }
                return;
            }
            e.a("CameraManager", "onLocationUpdated, GetAddressThread is running");
        }
    }

    /* access modifiers changed from: private */
    public boolean cD() {
        return (b("pref_burst_shot_key") || b("key_short_video")) && !this.cc.H();
    }

    /* access modifiers changed from: private */
    public boolean cE() {
        return !this.bP.getString("pref_camera_gesture_shutter_key", this.bO.getString(R.string.camera_gesture_shutter_default_value)).equals(this.bP.getString("last_camera_gesture_shutter_key", this.bO.getString(R.string.camera_gesture_shutter_default_value)));
    }

    /* compiled from: CameraManager */
    private class l extends Thread {

        /* renamed from: b  reason: collision with root package name */
        private WeakReference<Context> f3076b = null;
        private Location c = null;

        public l(String str, Context context, Location location) {
            super(str);
            this.f3076b = new WeakReference<>(context);
            this.c = location;
        }

        public void run() {
            Location location;
            Address a2 = Util.a((Context) this.f3076b.get(), this.c);
            if (a2 == null) {
                e.d("CameraManager", "GetAddressThread run, address is null, return");
                return;
            }
            o.a a3 = com.oppo.camera.util.b.a(a2);
            e.b("CameraManager", "GetAddressThread");
            if (a3 != null && (location = this.c) != null) {
                a3.i = location;
                o.a unused = f.this.cy = a3;
            }
        }
    }

    public Rect c(float f2) {
        Rect d2 = this.bS.d();
        Rect rect = new Rect();
        int width = d2.width() / 2;
        int height = d2.height() / 2;
        float f3 = f2 * 2.0f;
        int width2 = (int) (((float) d2.width()) / f3);
        int height2 = (int) (((float) d2.height()) / f3);
        rect.set(width - width2, height - height2, width + width2, height + height2);
        return rect;
    }

    public void b(float f2, boolean z2) {
        if (!this.as) {
            if (b("pref_portrait_half_body_key") || (this.cj != null && this.cj.by())) {
                f2 = 1.0f;
            } else if (this.cj != null && this.cj.i("pref_none_sat_tele_angle_key") && ck() && !this.cj.aP() && !this.cj.aQ()) {
                f2 = (f2 - 2.0f) + aQ();
            }
            e.b("CameraManager", "updateZoomValue, value: " + f2 + ", submit: " + z2);
            if (this.bR != null) {
                if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SAT_NEED_SET_ZOOMRATIO)) {
                    this.bR.a(f2);
                } else {
                    this.bR.a(c(f2));
                }
                if (z2) {
                    this.bR.a((f.c) null);
                }
                if (Util.h("oplus.software.video.surround_record_support") && (this.cj.i("pref_sound_types_key_rear") || this.cj.i("pref_sound_types_key_front"))) {
                    int i2 = (int) ((f2 - 1.0f) * 10.0f);
                    if (i2 <= 0) {
                        i2 = 1;
                    }
                    e.a("CameraManager", "updateZoomValue soundValue: " + i2);
                    this.cj.o(i2);
                }
                if (this.cc != null) {
                    this.cc.b(f2);
                }
            }
            this.ci = f2;
            this.cj.cj();
        }
    }

    private float B(boolean z2) {
        boolean z3 = true;
        boolean z4 = false;
        if (TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) != 1) {
            z3 = false;
        }
        if (this.cc != null) {
            z4 = this.cc.cU();
        }
        if (!z2) {
            return z4 ? 0.112f : 0.915f;
        }
        if (z4 || !z3) {
            return z4 ? 0.105f : 0.14f;
        }
        return 0.86f;
    }

    /* access modifiers changed from: private */
    public void c(final float f2, boolean z2) {
        if (!this.at && this.bO != null && this.cj != null && this.cj.bT()) {
            this.bO.runOnUiThread(new Runnable() {
                public void run() {
                    if (!f.this.as) {
                        String str = !f.this.cj.g() ? "pref_camera_videoflashmode_key" : "pref_camera_flashmode_key";
                        String Q = f.this.cj.Q();
                        if (f.this.g(f2)) {
                            f.this.cj.r(false);
                            if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_FLASH_FULL_ZOOM)) {
                                f.this.cc.a(str, "on", MenuClickMsgData.VALUE_PROFESSION_AUTO);
                            }
                            f.this.cc.b(str, (String) null);
                            String Q2 = f.this.cj.Q();
                            if (!"off".equals(Q) || !"off".equals(Q2)) {
                                f.this.cj.a(Q2, true);
                            }
                        } else {
                            if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_FLASH_FULL_ZOOM)) {
                                if ("on".equals(Q) || MenuClickMsgData.VALUE_PROFESSION_AUTO.equals(Q)) {
                                    f.this.cj.r(true);
                                    f.this.cj.a("off", true);
                                    f.this.cc.b(str, "off");
                                } else if ("torch".equals(Q) && f.this.cj.g()) {
                                    f.this.cj.r(false);
                                    f.this.cj.a(f.this.cj.Q(), true);
                                    f.this.cc.b(str, (String) null);
                                }
                                f.this.cc.b(str, "on", MenuClickMsgData.VALUE_PROFESSION_AUTO);
                            } else {
                                if (!"off".equals(Q)) {
                                    f.this.cj.r(true);
                                    f.this.cj.a("off", true);
                                }
                                f.this.cc.a(str, "off");
                            }
                            f.this.cc.B(false);
                        }
                        f.this.cc.f(str);
                    }
                }
            });
        } else if (!this.at && this.bO != null && this.cj != null && z2) {
            if ((b(CameraFunction.SAT_CAMERA) || b("pref_none_sat_ultra_wide_angle_key")) && !this.cj.ce() && !this.cj.bX() && !this.cj.bY() && !this.cj.by()) {
                this.bO.runOnUiThread(new Runnable() {
                    public void run() {
                        if (!f.this.as) {
                            String str = !f.this.cj.g() ? "pref_camera_videoflashmode_key" : "pref_camera_flashmode_key";
                            f.this.cj.r(false);
                            if (f.this.cj.g() && CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_FLASH_FULL_ZOOM)) {
                                f.this.cc.a(str, "on", MenuClickMsgData.VALUE_PROFESSION_AUTO);
                            }
                            f.this.cc.b(str, (String) null);
                            f.this.cj.a(f.this.cj.Q(), true);
                            f.this.cc.f(str);
                        }
                    }
                });
            }
        }
    }

    public boolean aM() {
        if (this.cf != null) {
            return this.cf.e();
        }
        return false;
    }

    public float aN() {
        if (this.cf != null) {
            return this.cf.a();
        }
        return aQ();
    }

    public boolean aO() {
        if (this.cf != null) {
            return this.cf.m();
        }
        return false;
    }

    public boolean aP() {
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SAT_USE_HAL)) {
            return true;
        }
        float aN2 = aN();
        return this.cj.a(d(aN2), e(aN2));
    }

    public boolean d(float f2) {
        if (!b(CameraFunction.SAT_CAMERA)) {
            return false;
        }
        return h(f2);
    }

    private boolean h(float f2) {
        float[] configFloatArrayValue = CameraConfig.getConfigFloatArrayValue(ConfigDataBase.KEY_SAT_ULTRAWIDE_ZOOM_RANGE);
        if (configFloatArrayValue == null || configFloatArrayValue.length != 2 || Float.compare(f2, configFloatArrayValue[0]) < 0 || Float.compare(f2, configFloatArrayValue[1]) >= 0) {
            return false;
        }
        return true;
    }

    public boolean e(float f2) {
        float[] configFloatArrayValue;
        if (b(CameraFunction.SAT_CAMERA) && (configFloatArrayValue = CameraConfig.getConfigFloatArrayValue(ConfigDataBase.KEY_SAT_TELE_ZOOM_RANGE)) != null && configFloatArrayValue.length == 2 && Float.compare(f2, configFloatArrayValue[0]) >= 0 && Float.compare(f2, configFloatArrayValue[1]) <= 0) {
            return true;
        }
        return false;
    }

    public float aQ() {
        p pVar = this.cT;
        if (pVar != null && 32784 == pVar.g()) {
            return 2.0f;
        }
        if (this.bS == null || this.cj == null) {
            return 1.0f;
        }
        return this.bS.b(this.cj.cd());
    }

    public float aR() {
        if (!this.cj.cd().i() || b("pref_ultra_wide_high_picture_size_key")) {
            return this.bS.c(this.cj.cd());
        }
        return 1.0f;
    }

    public float aS() {
        return this.bS.d(this.cj.cd());
    }

    public boolean f(float f2) {
        return this.bS.a(this.cj.cd(), f2);
    }

    /* compiled from: CameraManager */
    protected class o {

        /* renamed from: b  reason: collision with root package name */
        private Vector<p> f3081b = null;
        private int c = 0;
        private boolean d = false;

        protected o() {
        }

        public boolean a() {
            boolean z;
            synchronized (f.this.g) {
                z = this.f3081b != null && this.f3081b.size() > 0;
            }
            return z;
        }

        public int b() {
            int size;
            synchronized (f.this.g) {
                size = this.f3081b != null ? this.f3081b.size() : 0;
            }
            return size;
        }

        public boolean c() {
            boolean z;
            synchronized (f.this.g) {
                z = this.f3081b != null && this.f3081b.size() > 0 && this.c == 0;
            }
            return z;
        }

        public boolean a(int i) {
            e.b("ModeChangeExecutor", "isSwitchCamera, mProperCameraId: " + f.this.L + ", properCameraId: " + i);
            return f.this.L != i;
        }

        /* access modifiers changed from: private */
        public void l() {
            synchronized (f.this.g) {
                p i = i();
                if (i == null) {
                    e.e("ModeChangeExecutor", "handleOnSessionClosing, firstTask is null ");
                    this.c = 1;
                    return;
                }
                i.d();
            }
        }

        public void d() {
            synchronized (f.this.g) {
                p i = i();
                if (i == null) {
                    e.e("ModeChangeExecutor", "handleOnSessionClosed, firstTask is null ");
                    this.c = 2;
                    return;
                }
                if (!(i == null || i.k == null)) {
                    i.k.an();
                }
                i.c();
                f.this.bO.runOnUiThread(new Runnable() {
                    public void run() {
                        o.this.g();
                    }
                });
            }
        }

        public void e() {
            e.b("ModeChangeExecutor", "handleOnSessionConfigured");
            p i = i();
            if (i != null) {
                this.d = i.f3083a;
                e.b("ModeChangeExecutor", "handleOnSessionConfigured, mbCurrentHFR: " + this.d);
            }
            h();
        }

        public void f() {
            e.b("ModeChangeExecutor", "handleOnCameraOpened");
            p i = i();
            if (i != null) {
                i.b();
            }
        }

        public void g() {
            int i;
            int size;
            f.this.dN.removeMessages(11);
            p i2 = i();
            synchronized (f.this.g) {
                i = 0;
                size = this.f3081b != null ? this.f3081b.size() : 0;
            }
            if (i2 != null) {
                e.b("ModeChangeExecutor", "looperExecuteModeChangeTask, firstTask: " + i2.toString() + ", size: " + size);
                int b2 = i2.e;
                if (b2 == 0) {
                    i2.a();
                } else if (b2 == 2) {
                    if (size > 1) {
                        h();
                        p i3 = i();
                        if (i3 != null) {
                            int unused = i3.e = 2;
                            i3.a();
                        }
                    } else {
                        i2.a();
                    }
                }
            }
            synchronized (f.this.g) {
                if (this.f3081b != null) {
                    i = this.f3081b.size();
                }
            }
            e.b("ModeChangeExecutor", "looperExecuteModeChangeTask, after size : " + i);
            if (i > 0) {
                f.this.dN.sendEmptyMessageDelayed(11, 100);
            }
        }

        public void a(p pVar) {
            if (pVar != null) {
                synchronized (f.this.g) {
                    if (this.f3081b == null) {
                        this.f3081b = new Vector<>();
                    }
                    e.b("ModeChangeExecutor", "addModeChangeTask, task: " + pVar + ", size: " + this.f3081b.size());
                    if (this.c == 1) {
                        pVar.d();
                    } else if (this.c == 2) {
                        pVar.c();
                    }
                    if (this.f3081b.size() >= 1) {
                        boolean unused = f.this.bt = true;
                    }
                    this.c = 0;
                    if (this.f3081b.size() <= 1) {
                        this.f3081b.add(pVar);
                    } else {
                        this.f3081b.removeElementAt(1);
                        this.f3081b.add(pVar);
                    }
                }
                g();
            }
        }

        public void h() {
            synchronized (f.this.g) {
                if (this.f3081b != null && this.f3081b.size() > 0) {
                    this.f3081b.remove(0);
                    e.b("ModeChangeExecutor", "popFirstModeChangeTask X ");
                }
            }
        }

        public p i() {
            p pVar;
            synchronized (f.this.g) {
                pVar = (this.f3081b == null || this.f3081b.size() <= 0) ? null : this.f3081b.get(0);
            }
            return pVar;
        }

        public p j() {
            synchronized (f.this.g) {
                if (this.f3081b == null || this.f3081b.size() <= 0) {
                    return null;
                }
                p lastElement = this.f3081b.lastElement();
                return lastElement;
            }
        }

        public void k() {
            e.b("ModeChangeExecutor", "release");
            synchronized (f.this.g) {
                if (this.f3081b != null) {
                    this.f3081b.clear();
                }
            }
        }
    }

    /* compiled from: CameraManager */
    protected class p {

        /* renamed from: a  reason: collision with root package name */
        protected boolean f3083a = false;

        /* renamed from: b  reason: collision with root package name */
        protected com.oppo.camera.e.a f3084b = null;
        protected String c = null;
        /* access modifiers changed from: private */
        public int e = 0;
        private String f = null;
        private int g = 0;
        private int h = 0;
        private int i = 0;
        private boolean j = false;
        /* access modifiers changed from: private */
        public com.oppo.camera.e.a k = null;

        protected p() {
        }

        public void a() {
            e.b("ModeChangeTask", "execute task: " + toString());
            int i2 = this.e;
            if (i2 == 0) {
                this.e = 1;
                e.b("ModeChangeTask", "execute, send closeCaptureSession");
                f.this.ap();
                e.a("ModeChangeTaskDelay");
            } else if (i2 == 2) {
                e.b("closeSession");
                e.b("ModeChangeTask", "execute, STATUS_SESSION_CLOSED after mOneCamera.endOfStream X, mAfterModeProperCameraId: " + this.h);
                if ((f.this.cS == null || !f.this.cS.a(this.h)) && (((com.oppo.camera.f.h) f.this.bR).A() == null || !((com.oppo.camera.f.h) f.this.bR).A().f())) {
                    this.e = 3;
                    e.b("ModeChangeTask", "execute, STATUS_SESSION_CLOSED createCaptureSession");
                    f.this.n(1);
                    return;
                }
                int unused = f.this.V = 3;
                e.b("ModeChangeTask", "execute, openCamera");
                this.e = 4;
                f.this.l(3);
                if (ApsConstant.CAPTURE_MODE_MULTI_VIDEO.equals(((com.oppo.camera.f.h) f.this.bR).A().b())) {
                    ((com.oppo.camera.f.h) f.this.bR).a(false, (CameraDevice) null, false, 2);
                }
            }
        }

        public void b() {
            e.b("ModeChangeTask", "handleOnCameraOpened mStatus: " + this.e);
            if (this.e == 4) {
                this.e = 5;
            }
        }

        public void c() {
            e.b("ModeChangeTask", "handleOnSessionClosed mStatus: " + this.e);
            this.e = 2;
        }

        public void d() {
            e.b("ModeChangeTask", "handleOnSessionClosing mStatus: " + this.e);
            this.e = 1;
        }

        public p a(String str) {
            this.f = str;
            return this;
        }

        public p b(String str) {
            this.c = str;
            return this;
        }

        public p a(int i2) {
            this.g = i2;
            return this;
        }

        public p b(int i2) {
            this.h = i2;
            return this;
        }

        public p c(int i2) {
            this.i = i2;
            return this;
        }

        public p a(boolean z) {
            this.j = z;
            return this;
        }

        public p b(boolean z) {
            this.f3083a = z;
            return this;
        }

        public p a(com.oppo.camera.e.a aVar) {
            synchronized (f.this.cT) {
                this.f3084b = aVar;
            }
            return this;
        }

        public p b(com.oppo.camera.e.a aVar) {
            this.k = aVar;
            return this;
        }

        public String toString() {
            return "mStatus: " + this.e + ", mBeforeModeName: " + this.f + ", mAfterModeName: " + this.c + ", mBeforeModeProperCameraId: " + this.g + ", mAfterModeProperCameraId: " + this.h + ", mbBeforeHFR: " + this.j + " ,mbAfterHFR : " + this.f3083a + ", mBeforeOperatingMode: " + this.i;
        }
    }

    public void w(boolean z2) {
        this.bm = z2;
        e.b("CameraManager", "setExitCameraToSetting, mbSettingClickCausedPause: " + this.bm + " > " + z2);
    }

    public boolean aT() {
        return X() || this.bm;
    }

    private void cF() {
        if (this.cj != null) {
            this.cj.a(this.bR);
            this.cj.f(false);
            this.cj.k();
        }
    }

    private void cG() {
        e.b("CameraManager", "restoreAppConfig");
        cI();
        SharedPreferences b2 = this.bP.b(this.bO, 1);
        SharedPreferences b3 = this.bP.b(this.bO, 0);
        SharedPreferences.Editor edit = this.bP.edit();
        SharedPreferences.Editor edit2 = b2.edit();
        SharedPreferences.Editor edit3 = b3.edit();
        if (this.bP.getBoolean("key_high_picture_size", false)) {
            edit.remove("key_high_picture_size");
            edit.remove("pref_camera_photo_ratio_key");
            edit.remove("pref_camera_high_resolution_key");
        }
        edit.putBoolean("pref_restore_professional_params", true);
        edit.remove("pref_camera_timer_shutter_key");
        edit.remove("pref_switch_camera_key");
        edit.remove("pref_camera_id_key");
        h(true);
        this.bP.edit().putString("pref_none_sat_ultra_wide_angle_key", "off").apply();
        b3.edit().putString("pref_video_super_eis_key", "off").apply();
        b2.edit().putString("pref_video_super_eis_key", "off").apply();
        h(false);
        edit.putBoolean("pref_super_eis_wide_key", false);
        edit.putString("pref_raw_control_key", this.bO.getString(R.string.camera_raw_control_off));
        edit.putString("pref_super_raw_control_key", this.bO.getString(R.string.camera_raw_control_off));
        edit.remove("pref_video_hyper_lapse_key");
        edit.remove("pref_film_video_eis_and_flash_enable");
        a(b2);
        a(b3);
        edit2.putString("pref_camera_hdr_mode_key", MenuClickMsgData.VALUE_PROFESSION_AUTO);
        edit2.remove("key_ai_enhancement_video");
        edit3.putString("pref_film_video_eis_menu", "on");
        edit3.remove("pref_film_mode_iso");
        edit3.remove("pref_film_mode_shutter");
        edit3.remove("pref_film_mode_white_balance");
        edit3.remove("pref_film_mode_focus");
        edit3.remove("pref_film_mode_exposure");
        edit3.remove("pref_film_show_ui_default");
        edit3.remove("pref_switch_camera_bar_key");
        edit3.remove("key_ai_enhancement_video");
        edit3.putString("pref_camera_hdr_mode_key", MenuClickMsgData.VALUE_PROFESSION_AUTO);
        edit3.putString("key_video_hdr", this.bO.getResources().getString(R.string.camera_video_hdr_default_value));
        edit3.putString("key_ultra_night_video", this.bO.getResources().getString(R.string.camera_ultra_night_video_default_value));
        edit3.remove("pref_photo_tilt_shift_key");
        edit3.remove("pref_video_tilt_shift_key");
        edit3.remove("pref_video_timelapse_tilt_shift_key");
        edit3.remove("pref_tilt_shift_type");
        edit3.remove("pref_tilt_shift_blur_menu_index");
        edit.remove("pref_night_pro_mode_key");
        edit.putBoolean("pref_restore_night_pro_params", true);
        edit.remove("pref_high_picture_pro_mode_key");
        edit.putBoolean("pref_restore_high_picture_pro_params", true);
        edit2.apply();
        h(true);
        edit3.apply();
        h(false);
        edit.apply();
        com.oppo.camera.f.f fVar = this.bR;
        if (fVar != null) {
            ((com.oppo.camera.f.h) fVar).A().i();
        }
        if (this.cc != null) {
            this.cc.dh();
        }
    }

    private void cH() {
        boolean z2 = false;
        if (h.a((Context) this.bO).c()) {
            if (this.ao) {
                z2 = CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_MOTOR_FLASHLIGHT);
            } else if (h.a((Context) this.bO).b() || h.a((Context) this.bO).a()) {
                z2 = true;
            }
        }
        e.a("CameraManager", "setFlashAndTorchOffIfMotorFlash, motorFlash: " + z2);
        if (z2) {
            cI();
        }
    }

    private void cI() {
        if (this.bO != null && this.bP != null) {
            if (this.ao) {
                if (b((SharedPreferences) this.bP) && this.cc != null) {
                    if (!this.cc.bf()) {
                        this.cc.e(true, false);
                    }
                    this.cc.f("pref_camera_torch_mode_key");
                }
                c(this.bP.b(this.bO, 0));
                return;
            }
            if (c((SharedPreferences) this.bP) && this.cc != null) {
                if (!this.cc.bf()) {
                    this.cc.e(true, false);
                }
                this.cc.f("pref_camera_flashmode_key");
                this.cc.f("pref_camera_videoflashmode_key");
            }
            b(this.bP.b(this.bO, 1));
        }
    }

    private boolean b(SharedPreferences sharedPreferences) {
        e.a("CameraManager", "applyTorchModeDefault");
        String y2 = Util.y(this.bO);
        if (y2.equals(sharedPreferences.getString("pref_camera_torch_mode_key", y2))) {
            return false;
        }
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString("pref_camera_torch_mode_key", y2);
        edit.apply();
        return true;
    }

    private boolean c(SharedPreferences sharedPreferences) {
        SharedPreferences.Editor editor;
        e.a("CameraManager", "applyFlashModeOff");
        if (!"off".equals(sharedPreferences.getString("pref_camera_flashmode_key", "off"))) {
            editor = sharedPreferences.edit();
            editor.putString("pref_camera_flashmode_key", "off");
        } else {
            editor = null;
        }
        if (!"off".equals(sharedPreferences.getString("pref_camera_videoflashmode_key", "off"))) {
            if (editor == null) {
                editor = sharedPreferences.edit();
            }
            editor.putString("pref_camera_videoflashmode_key", "off");
        }
        if (!"off".equals(sharedPreferences.getString("pref_camera_film_mode_key", "off"))) {
            editor = sharedPreferences.edit();
            editor.putString("pref_camera_film_mode_key", "off");
        }
        if (editor == null) {
            return false;
        }
        editor.apply();
        return true;
    }

    private boolean d(SharedPreferences sharedPreferences) {
        e.a("CameraManager", "applyTorchModeOff");
        if ("off".equals(sharedPreferences.getString("pref_camera_torch_mode_key", "off"))) {
            return false;
        }
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString("pref_camera_torch_mode_key", "off");
        edit.apply();
        return true;
    }

    /* access modifiers changed from: private */
    public void C(boolean z2) {
        if (this.cj != null) {
            SwitchCameraMsgData switchCameraMsgData = new SwitchCameraMsgData(this.bO);
            switchCameraMsgData.mCameraId = aU();
            switchCameraMsgData.mCaptureMode = this.cj.l();
            switchCameraMsgData.mOrientation = this.G;
            switchCameraMsgData.mScreenBrightness = (int) ((float) Settings.System.getInt(this.bO.getContentResolver(), CameraStatisticsUtil.SCREEN_BRIGHTNESS, (int) (((float) this.D) * 0.4f)));
            switchCameraMsgData.mToCaptureMode = this.bP.getString("pref_camera_mode_key", "");
            switchCameraMsgData.mCaptureType = this.cj.g() ^ true ? 1 : 0;
            switchCameraMsgData.mCameraEnterType = String.valueOf(this.cH.y());
            switchCameraMsgData.mOperType = z2 ? "1" : "0";
            switchCameraMsgData.mRearOrFront = com.oppo.camera.f.a.c(ak()) ? DcsMsgData.FRONT : DcsMsgData.REAR;
            switchCameraMsgData.report();
        }
    }

    /* access modifiers changed from: private */
    public void D(boolean z2) {
        if (this.cj != null) {
            SwitchCameraMsgData switchCameraMsgData = new SwitchCameraMsgData(this.bO);
            String str = "smartRecogni";
            switchCameraMsgData.mCaptureMode = z2 ? this.cj.l() : str;
            if (!z2) {
                str = this.cj.l();
            }
            switchCameraMsgData.mToCaptureMode = str;
            switchCameraMsgData.mCameraId = aU();
            switchCameraMsgData.mOrientation = this.G;
            switchCameraMsgData.mOperType = "1";
            switchCameraMsgData.mScreenBrightness = (int) ((float) Settings.System.getInt(this.bO.getContentResolver(), CameraStatisticsUtil.SCREEN_BRIGHTNESS, (int) (((float) this.D) * 0.4f)));
            switchCameraMsgData.mRearOrFront = com.oppo.camera.f.a.c(this.L) ? DcsMsgData.FRONT : DcsMsgData.REAR;
            switchCameraMsgData.report();
        }
    }

    /* access modifiers changed from: private */
    public void cJ() {
        String bv2 = bv();
        if ((!TextUtils.isEmpty(bv2) || this.cj.cd().m()) && this.cj != null) {
            FocusAimMsgData focusAimMsgData = new FocusAimMsgData(this.bO);
            focusAimMsgData.mCameraId = aU();
            focusAimMsgData.mCaptureMode = this.cj.l();
            focusAimMsgData.mOrientation = this.G;
            boolean z2 = true;
            focusAimMsgData.mCaptureType = this.cj.g() ^ true ? 1 : 0;
            focusAimMsgData.mCameraEnterType = String.valueOf(this.cH.y());
            focusAimMsgData.mbVideoRecording = aG();
            focusAimMsgData.mTouchXY = bv2;
            if (!this.ao) {
                if (2 != this.av && !u()) {
                    z2 = false;
                }
                focusAimMsgData.mAeAfLock = String.valueOf(z2);
            }
            focusAimMsgData.mTouchEV = String.valueOf(this.T);
            if (this.cj.cd().m()) {
                if (this.cc != null) {
                    focusAimMsgData.mHyperLapseFocusViewXY = this.cc.r();
                }
                if (!TextUtils.isEmpty(focusAimMsgData.mHyperLapseFocusViewXY)) {
                    focusAimMsgData.mActType = FocusAimMsgData.KEY_HYPER_LAPSE_FOCUS_TYPE;
                }
            }
            focusAimMsgData.mRearOrFront = com.oppo.camera.f.a.c(ak()) ? DcsMsgData.FRONT : DcsMsgData.REAR;
            focusAimMsgData.report();
        }
    }

    /* access modifiers changed from: private */
    public void p(String str) {
        String bv2 = bv();
        if ((!TextUtils.isEmpty(bv2) || this.cj.cd().m() || aF()) && this.cj != null) {
            FocusAimMsgData focusAimMsgData = new FocusAimMsgData(this.bO);
            focusAimMsgData.mCameraId = aU();
            focusAimMsgData.mCaptureMode = this.cj.l();
            focusAimMsgData.mOrientation = this.G;
            boolean z2 = true;
            focusAimMsgData.mCaptureType = this.cj.g() ^ true ? 1 : 0;
            focusAimMsgData.mCameraEnterType = String.valueOf(this.cH.y());
            focusAimMsgData.mbVideoRecording = aG();
            focusAimMsgData.mTouchXY = bv2;
            if (!this.ao) {
                if (2 != this.av && !u()) {
                    z2 = false;
                }
                focusAimMsgData.mAeAfLock = String.valueOf(z2);
            }
            focusAimMsgData.mTouchEV = String.valueOf(this.T);
            if (this.cj.cd().m()) {
                if (this.cc != null) {
                    focusAimMsgData.mHyperLapseFocusViewXY = this.cc.r();
                }
                if (!TextUtils.isEmpty(focusAimMsgData.mHyperLapseFocusViewXY)) {
                    focusAimMsgData.mActType = FocusAimMsgData.KEY_HYPER_LAPSE_FOCUS_TYPE;
                }
            }
            focusAimMsgData.mRearOrFront = com.oppo.camera.f.a.c(ak()) ? DcsMsgData.FRONT : DcsMsgData.REAR;
            if (!str.isEmpty()) {
                if (!"on".equals(this.bP.getString("pref_camera_tap_shutter_key", this.bO.getString(R.string.camera_tap_shutter_default_value))) || str.equals("2")) {
                    focusAimMsgData.mActType = str;
                } else {
                    focusAimMsgData.mActType = FocusAimMsgData.KEY_TOUCH_TAKE_PICTURE;
                }
            }
            if (aF()) {
                int i2 = this.bP.getInt("pref_multicamera_type_selected_key", 0);
                if (!(this.cc == null || i2 == 0)) {
                    focusAimMsgData.mSubScreenValue = String.valueOf(this.cc.aj());
                }
            }
            focusAimMsgData.report();
        }
    }

    /* access modifiers changed from: private */
    public void a(String str, boolean z2, boolean z3, boolean z4, boolean z5) {
        if (this.cj != null) {
            MenuClickMsgData menuClickMsgData = new MenuClickMsgData(this.bO);
            menuClickMsgData.mCaptureMode = this.cj.l();
            menuClickMsgData.mCaptureType = this.cj.g() ^ true ? 1 : 0;
            menuClickMsgData.mCameraEnterType = String.valueOf(this.cH.y());
            menuClickMsgData.mCameraId = aU();
            menuClickMsgData.mOrientation = this.G;
            menuClickMsgData.buildMenuClick(this.bP, str, z2, z3, z4, z5, this.cj.ac());
            menuClickMsgData.mbVideoRecording = aG();
            if ("pref_camera_photo_ratio_key".equals(str) && b("pref_sticker_process_key") && "full".equals(menuClickMsgData.mItemValue)) {
                menuClickMsgData.mItemValue = this.cj.aa();
            }
            menuClickMsgData.mRearOrFront = com.oppo.camera.f.a.c(ak()) ? DcsMsgData.FRONT : DcsMsgData.REAR;
            menuClickMsgData.report();
        }
    }

    /* access modifiers changed from: private */
    public void q(String str) {
        if (this.cj != null) {
            MenuClickMsgData menuClickMsgData = new MenuClickMsgData(this.bO);
            menuClickMsgData.mCaptureMode = this.cj.l();
            menuClickMsgData.mCaptureType = this.cj.g() ^ true ? 1 : 0;
            menuClickMsgData.mCameraEnterType = String.valueOf(this.cH.y());
            menuClickMsgData.mCameraId = aU();
            menuClickMsgData.mOrientation = this.G;
            menuClickMsgData.mbVideoRecording = aG();
            menuClickMsgData.mRearOrFront = com.oppo.camera.f.a.c(this.cH.h()) ? DcsMsgData.FRONT : DcsMsgData.REAR;
            menuClickMsgData.buildMenuItem(str, this.bP, this.K);
            menuClickMsgData.report();
        }
    }

    public int aU() {
        if (!aF() || this.bP == null) {
            return ak();
        }
        return 1 == this.bP.getInt("pref_multicamera_show_position_state_key", 1) ? 0 : 1;
    }

    /* access modifiers changed from: private */
    public void b(int i2, boolean z2) {
        if (this.cj != null) {
            ReminderMsgData reminderMsgData = new ReminderMsgData(this.bO, this.cj.g());
            reminderMsgData.mCaptureMode = this.cj.l();
            reminderMsgData.mCameraEnterType = String.valueOf(this.cH.y());
            reminderMsgData.mCameraId = aU();
            reminderMsgData.mOrientation = this.G;
            reminderMsgData.mReminderAIScene = String.valueOf(i2);
            reminderMsgData.mReminderAILabelSwitch = z2 ? "on" : "off";
            reminderMsgData.mRearOrFront = com.oppo.camera.f.a.c(this.cH.h()) ? DcsMsgData.FRONT : DcsMsgData.REAR;
            reminderMsgData.buildAISceneItem();
            reminderMsgData.report();
        }
    }

    /* access modifiers changed from: private */
    public void E(boolean z2) {
        if (this.cj != null) {
            MenuClickMsgData menuClickMsgData = new MenuClickMsgData(this.bO);
            menuClickMsgData.buildEvent(false);
            int i2 = 1;
            menuClickMsgData.mFuncKeyId = 1;
            menuClickMsgData.mCaptureMode = this.cj.l();
            menuClickMsgData.mCaptureType = this.cj.g() ^ true ? 1 : 0;
            menuClickMsgData.mCameraEnterType = String.valueOf(this.cH.y());
            menuClickMsgData.mCameraId = aU();
            menuClickMsgData.mOrientation = this.G;
            menuClickMsgData.mbVideoRecording = aG();
            if (!z2) {
                i2 = 2;
            }
            menuClickMsgData.mFuncKeyResult = i2;
            menuClickMsgData.mRearOrFront = com.oppo.camera.f.a.c(ak()) ? DcsMsgData.FRONT : DcsMsgData.REAR;
            menuClickMsgData.report();
        }
    }

    private void cK() {
        if (this.cj != null) {
            MenuClickMsgData menuClickMsgData = new MenuClickMsgData(this.bO);
            menuClickMsgData.buildEvent(false);
            menuClickMsgData.mFuncKeyId = 6;
            menuClickMsgData.mCaptureMode = this.cj.l();
            menuClickMsgData.mCaptureType = this.cj.g() ^ true ? 1 : 0;
            menuClickMsgData.mCameraEnterType = String.valueOf(this.cH.y());
            menuClickMsgData.mCameraId = aU();
            menuClickMsgData.mOrientation = this.G;
            menuClickMsgData.mbVideoRecording = aG();
            menuClickMsgData.mRearOrFront = com.oppo.camera.f.a.c(ak()) ? DcsMsgData.FRONT : DcsMsgData.REAR;
            menuClickMsgData.report();
        }
    }

    private void cL() {
        if (this.cj != null) {
            MenuClickMsgData menuClickMsgData = new MenuClickMsgData(this.bO);
            menuClickMsgData.buildEvent(false);
            menuClickMsgData.mFuncKeyId = 5;
            menuClickMsgData.mCaptureMode = this.cj.l();
            menuClickMsgData.mCaptureType = this.cj.g() ^ true ? 1 : 0;
            menuClickMsgData.mCameraEnterType = String.valueOf(this.cH.y());
            menuClickMsgData.mCameraId = aU();
            menuClickMsgData.mOrientation = this.G;
            menuClickMsgData.mRearOrFront = com.oppo.camera.f.a.c(ak()) ? DcsMsgData.FRONT : DcsMsgData.REAR;
            menuClickMsgData.report();
        }
    }

    private void F(boolean z2) {
        if (z2 && this.cj != null) {
            PreviewStaticInfoMsgData previewStaticInfoMsgData = new PreviewStaticInfoMsgData(this.bO);
            previewStaticInfoMsgData.mCaptureMode = this.cj.l();
            previewStaticInfoMsgData.mCaptureType = this.cj.g() ^ true ? 1 : 0;
            if (this.cj.i("pref_sticker_process_key")) {
                previewStaticInfoMsgData.mStickerCount = com.oppo.camera.ui.preview.a.l.b((Context) this.bO).a().intValue();
            }
            previewStaticInfoMsgData.mCameraEnterType = String.valueOf(this.cH.y());
            previewStaticInfoMsgData.mCameraId = aU();
            previewStaticInfoMsgData.mOrientation = this.G;
            previewStaticInfoMsgData.mScreenBrightness = (int) ((float) Settings.System.getInt(this.bO.getContentResolver(), CameraStatisticsUtil.SCREEN_BRIGHTNESS, (int) (((float) this.D) * 0.4f)));
            previewStaticInfoMsgData.mRearOrFront = com.oppo.camera.f.a.c(ak()) ? DcsMsgData.FRONT : DcsMsgData.REAR;
            previewStaticInfoMsgData.report();
        }
    }

    /* access modifiers changed from: private */
    public void c(z.a aVar) {
        CaptureMsgData captureMsgData;
        if (aVar != null && (captureMsgData = this.bG) != null) {
            captureMsgData.mCaptureMode = this.cj.l();
            this.bG.mCameraId = aU();
            this.bG.mOrientation = this.G;
            this.bG = (CaptureMsgData) this.cj.a((DcsMsgData) this.bG, aVar);
            this.bG.mFilePath = com.oppo.camera.a.a.a(aVar);
            this.bG.mRearOrFront = com.oppo.camera.f.a.c(ak()) ? DcsMsgData.FRONT : DcsMsgData.REAR;
            this.bG.report();
        }
    }

    /* access modifiers changed from: private */
    public void G(boolean z2) {
        if (this.ce != null) {
            this.ce.j(z2);
        }
    }

    /* access modifiers changed from: private */
    public void C(int i2) {
        if (i2 > 0 && this.bG != null && this.cj != null) {
            this.bG.mCaptureMode = this.cj.l();
            this.bG.mCameraId = aU();
            CaptureMsgData captureMsgData = this.bG;
            captureMsgData.mOrientation = this.G;
            captureMsgData.mBurstCount = i2;
            captureMsgData.report();
        }
    }

    /* access modifiers changed from: private */
    public void a(String str, String str2) {
        if (this.cj != null) {
            ReminderMsgData reminderMsgData = new ReminderMsgData(this.bO, this.cj.g());
            reminderMsgData.mCameraEnterType = String.valueOf(this.cH.y());
            reminderMsgData.mCaptureMode = this.cj.l();
            reminderMsgData.mCaptureType = this.cj.g() ^ true ? 1 : 0;
            reminderMsgData.mCameraId = aU();
            reminderMsgData.mOrientation = this.G;
            reminderMsgData.mReminderTypeValue = str;
            reminderMsgData.mReminderCodeValue = str2;
            if (ReminderMsgData.CODE_TEMPS_FLASH.equals(str2)) {
                reminderMsgData.mReminderTriggerValue = this.cG ? ReminderMsgData.CODE_CHARGE_TRUE : ReminderMsgData.CODE_CHARGE_FALSE;
            } else {
                reminderMsgData.mReminderTriggerValue = "";
            }
            reminderMsgData.mRearOrFront = com.oppo.camera.f.a.c(ak()) ? DcsMsgData.FRONT : DcsMsgData.REAR;
            reminderMsgData.report();
        }
    }

    public void a(int[] iArr, long j2) {
        if (this.cd != null && iArr != null) {
            byte[] bArr = new byte[((iArr.length * Util.f) + Util.g)];
            byte[] e2 = Util.e(j2);
            for (int i2 = 0; i2 < Util.g; i2++) {
                bArr[i2] = e2[i2];
            }
            for (int i3 = 0; i3 < iArr.length; i3++) {
                byte[] g2 = Util.g(iArr[i3]);
                for (int i4 = 0; i4 < Util.f; i4++) {
                    bArr[Util.g + (Util.f * i3) + i4] = g2[i4];
                }
            }
            this.cd.a(bArr, 0, 0, 4);
        }
    }

    private boolean cM() {
        try {
            String callingPackage = this.bO.getCallingPackage();
            new Intent("android.intent.action.MAIN", (Uri) null).addCategory("android.intent.category.LAUNCHER");
            PackageManager packageManager = this.bO.getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(callingPackage, 4096);
            if (packageInfo == null) {
                return false;
            }
            int checkPermission = packageManager.checkPermission("android.permission.ACCESS_FINE_LOCATION", packageInfo.packageName);
            int checkPermission2 = packageManager.checkPermission("android.permission.ACCESS_COARSE_LOCATION", packageInfo.packageName);
            if (checkPermission == 0 && checkPermission2 == 0) {
                return true;
            }
            return false;
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    /* access modifiers changed from: private */
    public void a(CaptureRequest captureRequest, CaptureResult captureResult) {
        String str;
        String str2;
        int i2;
        int i3;
        if (this.de == null || this.at) {
            e.e("CameraManager", "addPreviewMetaToAPS, aps service is null or now is destroyed.");
            return;
        }
        Long l2 = (Long) captureResult.get(CaptureResult.SENSOR_TIMESTAMP);
        com.oppo.camera.f.d dVar = (com.oppo.camera.f.d) captureRequest.getTag();
        ImageCategory.MetaItemInfo metaItemInfo = new ImageCategory.MetaItemInfo();
        boolean z2 = true;
        if (this.cj.bT()) {
            ApsParameters.Key key = ParameterKeys.KEY_PREVIEW_STREAM_NUMBER;
            if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SAT_USE_HAL)) {
                i2 = 1;
            } else {
                i2 = ((TotalCaptureResult) captureResult).getPhysicalCameraResults().size();
            }
            metaItemInfo.setParameter(key, Integer.valueOf(i2));
            ApsParameters.Key key2 = ParameterKeys.KEY_CAPTURE_STREAM_NUMBER;
            if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SAT_USE_HAL)) {
                i3 = 1;
            } else {
                i3 = ((TotalCaptureResult) captureResult).getPhysicalCameraResults().size();
            }
            metaItemInfo.setParameter(key2, Integer.valueOf(i3));
        } else {
            metaItemInfo.setParameter(ParameterKeys.KEY_PREVIEW_STREAM_NUMBER, Integer.valueOf(this.cj.cp()));
            metaItemInfo.setParameter(ParameterKeys.KEY_CAPTURE_STREAM_NUMBER, Integer.valueOf(this.cj.cq()));
        }
        String str3 = "1";
        if (!this.cj.cB() || !aG()) {
            metaItemInfo.setParameter(ParameterKeys.KEY_VIDEO_WATERMARK_ENABLE, "0");
        } else {
            metaItemInfo.setParameter(ParameterKeys.KEY_VIDEO_MIRROR, ParameterKeys.getFlagState(this.cj.dg() ? TextUtils.equals(this.bP.getString("pref_mirror_key", this.bO.getString(R.string.camera_mirror_default_value)), "off") : false));
            metaItemInfo.setParameter(ParameterKeys.KEY_VIDEO_WATERMARK_ENABLE, str3);
            metaItemInfo.setParameter(ParameterKeys.KEY_VIDEO_ORIENTATION, String.valueOf(this.cj.dd() ? 270 : this.H));
            int aB2 = aB();
            Size aA2 = aA();
            byte[] az2 = az();
            if (!(az2 == null || aB2 == 0 || aA2 == null)) {
                metaItemInfo.setParameter(ParameterKeys.KEY_APS_WATERMARK_PARAM, new ApsWatermarkParam(aB2, aA2.getHeight(), aA2.getWidth(), az2));
            }
        }
        metaItemInfo.setParameter(ParameterKeys.KEY_PI_ENABLE, ParameterKeys.getFlagState(this.cc.G(this.U)));
        metaItemInfo.setParameter(ParameterKeys.KEY_FRAME_NUMBER, Long.valueOf(captureResult.getFrameNumber()));
        metaItemInfo.setParameter(ParameterKeys.KEY_TIME_STAMP, l2);
        metaItemInfo.setParameter(ParameterKeys.KEY_MERGE_IDENTITY, l2);
        metaItemInfo.setParameter(ParameterKeys.KEY_CAPTURE_RESULT, captureResult);
        metaItemInfo.setParameter(ParameterKeys.KEY_CAMERA_ID, String.valueOf(this.K));
        metaItemInfo.setParameter(ParameterKeys.KEY_LOGIC_CAMERA_ID, Integer.valueOf(ak()));
        metaItemInfo.setParameter(ParameterKeys.KEY_META_MAP, ApsUtils.assembleMetaMap(metaItemInfo.get(ParameterKeys.KEY_CAPTURE_RESULT), String.valueOf(ak())));
        metaItemInfo.setParameter(ParameterKeys.KEY_ITEM_INFO_TYPE, this.cj.cr());
        metaItemInfo.setParameter(ParameterKeys.KEY_HYPER_LAPSE_RATE, String.valueOf(this.cj.cs()));
        metaItemInfo.setParameter(ParameterKeys.KEY_HYPER_LAPSE_RECORDING_STATUS, Integer.valueOf(this.cc.de() ^ true ? 1 : 0));
        boolean cQ2 = this.cj.cQ();
        ApsParameters.Key<String> key3 = ParameterKeys.KEY_AICOLOR_ENABLE;
        if (cQ2) {
            str = str3;
        } else {
            str = "0";
        }
        metaItemInfo.setParameter(key3, str);
        ApsParameters.Key<String> key4 = ParameterKeys.KEY_RTB_ENABLE;
        if (cQ2) {
            str2 = "0";
        } else {
            str2 = str3;
        }
        metaItemInfo.setParameter(key4, str2);
        if (this.cj.H()) {
            metaItemInfo.setParameter(ParameterKeys.KEY_MONO_PORTRAIT, str3);
        }
        metaItemInfo.setParameter(ParameterKeys.KEY_LSD_ENABLE, Boolean.valueOf(this.cj.i("pref_lens_dirty_detection_key") && this.cj.bC()));
        metaItemInfo.setParameter(ParameterKeys.KEY_ZOOM_RATIO, String.valueOf(this.ci));
        metaItemInfo.setParameter(ParameterKeys.KEY_CAMERA_REQUEST_TAG, Util.a(dVar, metaItemInfo));
        metaItemInfo.setParameter(ParameterKeys.KEY_PREVIEW_CALLBACK_TYPE, "0");
        if (!this.cj.i(CameraFunction.VIDEO_BLUR_PROCESS) || !this.cj.bB()) {
            z2 = false;
        }
        ApsParameters.Key<String> key5 = ParameterKeys.KEY_VIDEO_BLUR_OPEN;
        if (!z2) {
            str3 = "0";
        }
        metaItemInfo.setParameter(key5, str3);
        this.de.addPreviewMetaInfo(metaItemInfo);
    }

    private void a(ImageReader imageReader, Image image, int i2, ImageCategory.ItemInfoType itemInfoType) {
        if (this.de == null) {
            e.e("CameraManager", "addPreviewImageToAPS, aps service is null.");
            image.close();
            return;
        }
        if (!this.db) {
            e.a("CameraStartupPerformance.addFirstPreviewImageToAPS");
            this.db = true;
            e.b("CameraManager", "add first frame image to APS");
            e.b("CameraStartupPerformance.addFirstPreviewImageToAPS");
        }
        this.de.addPreviewImageInfo(a(imageReader, image, i2, itemInfoType, false));
    }

    /* access modifiers changed from: private */
    public void a(ImageReader imageReader, int i2, ImageCategory.ItemInfoType itemInfoType, long j2) {
        if (this.cj == null || this.at) {
            e.e("CameraManager", "addVideoImageToAPS, mModeManager is null or now is destroyed.");
            return;
        }
        if (this.dy > 0) {
            com.oppo.camera.g.a.b(System.currentTimeMillis() - this.dy, j2);
        }
        this.dy = System.currentTimeMillis();
        Image a2 = Util.a(imageReader);
        if (a2 == null) {
            e.e("CameraManager", "addVideoImageToAPS, image is null.");
        } else if (this.de == null) {
            e.e("CameraManager", "addVideoImageToAPS, mApsService is null.");
            a2.close();
        } else {
            this.de.addVideoImageInfo(a(imageReader, a2, i2, itemInfoType, this.cj.l().equals(ApsConstant.REC_MODE_SLOW_VIDEO) && (this.cj.aM() || this.dz)));
        }
    }

    private ImageCategory.ImageItemInfo a(ImageReader imageReader, Image image, int i2, ImageCategory.ItemInfoType itemInfoType, boolean z2) {
        if (image == null || itemInfoType == null) {
            e.e("CameraManager", "generateImageInfo, params error, image: " + image + ", role: " + i2 + ", type: " + itemInfoType);
            return null;
        }
        ImageCategory.ImageItemInfo imageItemInfo = new ImageCategory.ImageItemInfo();
        imageItemInfo.mImageBuffer = new ApsResult.ImageBuffer(imageReader, image, image.getHardwareBuffer(), image.getTimestamp());
        imageItemInfo.mApsServiceListener = this.df;
        imageItemInfo.setParameter(ParameterKeys.KEY_IMAGE_WIDTH, Integer.valueOf(image.getWidth()));
        imageItemInfo.setParameter(ParameterKeys.KEY_IMAGE_HEIGHT, Integer.valueOf(image.getHeight()));
        imageItemInfo.setParameter(ParameterKeys.KEY_IMAGE_ROLE, Integer.valueOf(i2));
        imageItemInfo.setParameter(ParameterKeys.KEY_TIME_STAMP, Long.valueOf(image.getTimestamp()));
        imageItemInfo.setParameter(ParameterKeys.KEY_ORIENTATION, Integer.valueOf(this.F));
        imageItemInfo.setParameter(ParameterKeys.KEY_REC_BURST_NUMBER, -1);
        imageItemInfo.setParameter(ParameterKeys.KEY_BURST_SHOT, false);
        imageItemInfo.setParameter(ParameterKeys.KEY_DATE, Long.valueOf(System.currentTimeMillis()));
        imageItemInfo.setParameter(ParameterKeys.KEY_ITEM_INFO_TYPE, itemInfoType);
        imageItemInfo.setParameter(ParameterKeys.KEY_NEED_META_DATA, Boolean.valueOf(this.cj.i(i2)));
        imageItemInfo.setParameter(ParameterKeys.KEY_NEED_MATCH_TIME_STAMP, Boolean.valueOf(this.cj.ba()));
        imageItemInfo.setParameter(ParameterKeys.KEY_IS_DETACHED, Boolean.valueOf(z2));
        if (this.cj.bT()) {
            imageItemInfo.setParameter(ParameterKeys.KEY_PREVIEW_STREAM_NUMBER, 1);
            imageItemInfo.setParameter(ParameterKeys.KEY_CAPTURE_STREAM_NUMBER, 1);
        } else {
            imageItemInfo.setParameter(ParameterKeys.KEY_PREVIEW_STREAM_NUMBER, Integer.valueOf(this.cj.cp()));
            imageItemInfo.setParameter(ParameterKeys.KEY_CAPTURE_STREAM_NUMBER, Integer.valueOf(this.cj.cq()));
        }
        if (this.cc != null && b("key_intelligent_high_frame_usage_key")) {
            imageItemInfo.setParameter(ParameterKeys.KEY_SLOW_VIDEO_HIGH_FRAME, true);
            if ("on".equals(this.bP.getString("pref_intelligent_high_frame_selected_key", this.bO.getString(R.string.camera_intelligent_high_frame_default_selected)))) {
                imageItemInfo.setParameter(ParameterKeys.KEY_INTELLIGENT_OPENED, "1");
                RectF J2 = this.cc.J(com.oppo.camera.f.a.b(this.K));
                if (J2 != null) {
                    imageItemInfo.setParameter(ParameterKeys.KEY_INTELLIGENT_CROP_REGION, Arrays.toString(new int[]{(int) J2.left, (int) J2.top, (int) J2.right, (int) J2.bottom}));
                }
            }
            if (b("key_accelerometer_usage")) {
                imageItemInfo.setParameter(ParameterKeys.KEY_ACCELEROMETER_USE, "1");
                if (this.cm != null) {
                    imageItemInfo.setParameter(ParameterKeys.KEY_ACCELEROMETER_DATA, Arrays.toString(this.cm.c()));
                }
            }
            Range<Integer> o2 = this.cj.o();
            if (o2 != null) {
                imageItemInfo.setParameter(ParameterKeys.KEY_INTELLIGENT_FPS_RANGE, String.valueOf(o2.getLower()));
            }
        }
        imageItemInfo.setParameter(ApsParameters.KEY_SURFACE, this.cj.cw());
        return imageItemInfo;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0032, code lost:
        if (r6.cY == false) goto L_0x003a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0034, code lost:
        a(2, r6.di);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x003a, code lost:
        r0 = r6.cH.a(r6.cj.l(), r6.K);
        r2 = new com.oppo.camera.aps.adapter.ApsAdapterDecision.DecisionControlData();
        r2.mCameraId = r6.K;
        r2.mCaptureMode = r6.cj.l();
        r2.mLogicCameraId = java.lang.String.valueOf(r0);
        r2.mLogicCameraType = r6.cT.r();
        r2.mZoomValue = r6.ci;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0071, code lost:
        if (com.oppo.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oppo.camera.aps.config.ConfigDataBase.KEY_PI_AI) == false) goto L_0x0085;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0075, code lost:
        if (r6.cc == null) goto L_0x0082;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0077, code lost:
        r2.mPiEnable = r6.cc.G(r6.U) ? 1 : 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0082, code lost:
        r2.mPiEnable = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0085, code lost:
        r2.mPiEnable = r6.bP.getString("pref_camera_pi_mode_key", "off").equals("on") ? 1 : 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x009e, code lost:
        if (b("pref_super_raw_control_key") == false) goto L_0x00b4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00b0, code lost:
        if (r6.bP.getString("pref_super_raw_control_key", "off").equals("super_raw") == false) goto L_0x00b4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00b2, code lost:
        r0 = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00b4, code lost:
        r0 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00b5, code lost:
        r2.mSuperRawEnable = r0;
        r2.mSCPEnable = r6.cj.bK() ? 1 : 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00c5, code lost:
        if (b("pref_night_tripod_mode_key") == false) goto L_0x00da;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00d7, code lost:
        if (r6.bP.getString("pref_night_tripod_mode_key", "off").equals("on") == false) goto L_0x00da;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00d9, code lost:
        r1 = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00da, code lost:
        r2.mTripodEnable = r1;
        r2.mCaptureResult = r7;
        r2.mDecisionCallback = r6.dh;
        r2.mUltraHighResolutionEnable = r6.cj.bP() ? 1 : 0;
        r2.mFilterEnable = r6.cj.bQ() ? 1 : 0;
        r2.mFaceBeautyEnable = r6.cj.bq() ? 1 : 0;
        r2.mNeonEnable = r6.cj.cJ() ? 1 : 0;
        r2.mStreamerEnable = r6.cj.cK() ? 1 : 0;
        r6.de.onDecisionControlData(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x010f, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(android.hardware.camera2.CaptureResult r7) {
        /*
            r6 = this;
            boolean r0 = r6.as
            if (r0 != 0) goto L_0x0113
            com.oppo.camera.f.f r0 = r6.bR
            if (r0 == 0) goto L_0x0113
            com.oppo.camera.aps.service.ApsService r0 = r6.de
            if (r0 == 0) goto L_0x0113
            if (r7 == 0) goto L_0x0113
            boolean r0 = r6.bd()
            if (r0 != 0) goto L_0x001e
            com.oppo.camera.aps.service.ApsService r0 = r6.de
            boolean r0 = r0.isApsProcessing()
            if (r0 == 0) goto L_0x001e
            goto L_0x0113
        L_0x001e:
            java.lang.Object r0 = r6.i
            monitor-enter(r0)
            int r1 = r6.dn     // Catch:{ all -> 0x0110 }
            int r2 = r1 + 1
            r6.dn = r2     // Catch:{ all -> 0x0110 }
            r2 = 3
            if (r1 >= r2) goto L_0x002c
            monitor-exit(r0)     // Catch:{ all -> 0x0110 }
            return
        L_0x002c:
            r1 = 0
            r6.dn = r1     // Catch:{ all -> 0x0110 }
            monitor-exit(r0)     // Catch:{ all -> 0x0110 }
            boolean r0 = r6.cY
            if (r0 == 0) goto L_0x003a
            r0 = 2
            com.oppo.camera.aps.adapter.ApsInitParameter r2 = r6.di
            r6.a((int) r0, (com.oppo.camera.aps.adapter.ApsInitParameter) r2)
        L_0x003a:
            com.oppo.camera.entry.b r0 = r6.cH
            com.oppo.camera.e.o r2 = r6.cj
            java.lang.String r2 = r2.l()
            int r3 = r6.K
            int r0 = r0.a((java.lang.String) r2, (int) r3)
            com.oppo.camera.aps.adapter.ApsAdapterDecision$DecisionControlData r2 = new com.oppo.camera.aps.adapter.ApsAdapterDecision$DecisionControlData
            r2.<init>()
            int r3 = r6.K
            r2.mCameraId = r3
            com.oppo.camera.e.o r3 = r6.cj
            java.lang.String r3 = r3.l()
            r2.mCaptureMode = r3
            java.lang.String r0 = java.lang.String.valueOf(r0)
            r2.mLogicCameraId = r0
            com.oppo.camera.p r0 = r6.cT
            int r0 = r0.r()
            r2.mLogicCameraType = r0
            float r0 = r6.ci
            r2.mZoomValue = r0
            java.lang.String r0 = "com.oplus.feature.pi.ai.support"
            boolean r0 = com.oppo.camera.aps.config.CameraConfig.getConfigBooleanValue(r0)
            if (r0 == 0) goto L_0x0085
            com.oppo.camera.ui.g r0 = r6.cc
            if (r0 == 0) goto L_0x0082
            com.oppo.camera.ui.g r0 = r6.cc
            int r3 = r6.U
            boolean r0 = r0.G((int) r3)
            r2.mPiEnable = r0
            goto L_0x0097
        L_0x0082:
            r2.mPiEnable = r1
            goto L_0x0097
        L_0x0085:
            com.oppo.camera.k r0 = r6.bP
            java.lang.String r3 = "pref_camera_pi_mode_key"
            java.lang.String r4 = "off"
            java.lang.String r0 = r0.getString(r3, r4)
            java.lang.String r3 = "on"
            boolean r0 = r0.equals(r3)
            r2.mPiEnable = r0
        L_0x0097:
            java.lang.String r0 = "pref_super_raw_control_key"
            boolean r0 = r6.b((java.lang.String) r0)
            r3 = 1
            if (r0 == 0) goto L_0x00b4
            com.oppo.camera.k r0 = r6.bP
            java.lang.String r4 = "pref_super_raw_control_key"
            java.lang.String r5 = "off"
            java.lang.String r0 = r0.getString(r4, r5)
            java.lang.String r4 = "super_raw"
            boolean r0 = r0.equals(r4)
            if (r0 == 0) goto L_0x00b4
            r0 = r3
            goto L_0x00b5
        L_0x00b4:
            r0 = r1
        L_0x00b5:
            r2.mSuperRawEnable = r0
            com.oppo.camera.e.o r0 = r6.cj
            boolean r0 = r0.bK()
            r2.mSCPEnable = r0
            java.lang.String r0 = "pref_night_tripod_mode_key"
            boolean r0 = r6.b((java.lang.String) r0)
            if (r0 == 0) goto L_0x00da
            com.oppo.camera.k r0 = r6.bP
            java.lang.String r4 = "pref_night_tripod_mode_key"
            java.lang.String r5 = "off"
            java.lang.String r0 = r0.getString(r4, r5)
            java.lang.String r4 = "on"
            boolean r0 = r0.equals(r4)
            if (r0 == 0) goto L_0x00da
            r1 = r3
        L_0x00da:
            r2.mTripodEnable = r1
            r2.mCaptureResult = r7
            com.oppo.camera.f$a r7 = r6.dh
            r2.mDecisionCallback = r7
            com.oppo.camera.e.o r7 = r6.cj
            boolean r7 = r7.bP()
            r2.mUltraHighResolutionEnable = r7
            com.oppo.camera.e.o r7 = r6.cj
            boolean r7 = r7.bQ()
            r2.mFilterEnable = r7
            com.oppo.camera.e.o r7 = r6.cj
            boolean r7 = r7.bq()
            r2.mFaceBeautyEnable = r7
            com.oppo.camera.e.o r7 = r6.cj
            boolean r7 = r7.cJ()
            r2.mNeonEnable = r7
            com.oppo.camera.e.o r7 = r6.cj
            boolean r7 = r7.cK()
            r2.mStreamerEnable = r7
            com.oppo.camera.aps.service.ApsService r7 = r6.de
            r7.onDecisionControlData(r2)
            return
        L_0x0110:
            r7 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0110 }
            throw r7
        L_0x0113:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "previewDecision, params error, mbPaused: "
            r0.append(r1)
            boolean r1 = r6.as
            r0.append(r1)
            java.lang.String r1 = ", mOneCamera: "
            r0.append(r1)
            com.oppo.camera.f.f r1 = r6.bR
            r0.append(r1)
            java.lang.String r1 = ", mApsService: "
            r0.append(r1)
            com.oppo.camera.aps.service.ApsService r1 = r6.de
            r0.append(r1)
            java.lang.String r1 = ", result: "
            r0.append(r1)
            r0.append(r7)
            java.lang.String r7 = r0.toString()
            java.lang.String r0 = "CameraManager"
            com.oppo.camera.e.e(r0, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.f.a(android.hardware.camera2.CaptureResult):void");
    }

    public void x(boolean z2) {
        this.bw = z2;
    }

    public void aV() {
        e.a("CameraManager", "resetAPSDecisionPreviewFrameCount");
        synchronized (this.i) {
            this.dn = 3;
        }
    }

    public i.a aW() {
        return new i.a() {
            public void a() {
                if (f.this.cc != null && !f.this.aX()) {
                    e.b("CameraManager", "onStartFacePointAnimation");
                    f.this.cc.cc();
                }
            }
        };
    }

    public boolean aX() {
        return this.bO != null && Util.p(this.bO) && this.bP != null && "on".equals(this.bP.getString("pref_camera_recordlocation_key", "on")) && this.bV != null && !this.bV.r();
    }

    public void a(Runnable runnable, long j2) {
        Handler handler = this.cC;
        if (handler != null) {
            handler.postDelayed(runnable, j2);
        }
    }

    public void a(Runnable runnable) {
        Handler handler = this.cC;
        if (handler != null) {
            handler.removeCallbacks(runnable);
        }
    }

    private boolean cN() {
        if (this.cj != null) {
            return this.cj.dp();
        }
        return true;
    }

    /* access modifiers changed from: private */
    public void a(com.oppo.camera.ui.control.e eVar) {
        cK();
        if (Util.b((Context) this.bO, "com.coloros.gallery3d")) {
            try {
                this.bl = true;
                Intent intent = new Intent("com.android.camera.action.REVIEW");
                intent.setDataAndType(eVar.d(), eVar.i());
                intent.putExtra("media-from", "from_camera");
                intent.putExtra("animation_pivotX", B(true));
                intent.putExtra("animation_pivotY", B(false));
                intent.setPackage("com.coloros.gallery3d");
                this.bO.startActivity(intent);
                this.bO.overridePendingTransition(this.cj.cT(), 0);
                if (this.du != null) {
                    this.du.a(true);
                }
            } catch (ActivityNotFoundException e2) {
                e.a("CameraManager", "startGallery, Exception: ActivityNotFoundException.", (Throwable) e2);
                this.bl = false;
            }
        }
    }
}
