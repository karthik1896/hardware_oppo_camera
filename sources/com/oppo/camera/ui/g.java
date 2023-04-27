package com.oppo.camera.ui;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.hardware.camera2.params.Face;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Size;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.Space;
import color.support.v7.widget.c;
import com.color.support.widget.j;
import com.meicam.sdk.NvsStreamingContext;
import com.meicam.sdk.NvsTimeline;
import com.oppo.camera.Camera;
import com.oppo.camera.R;
import com.oppo.camera.aps.ApsAdapterConstant;
import com.oppo.camera.aps.config.AlgoSwitchConfig;
import com.oppo.camera.aps.config.CameraConfig;
import com.oppo.camera.aps.config.CameraFunction;
import com.oppo.camera.aps.config.ConfigDataBase;
import com.oppo.camera.aps.constant.ApsConstant;
import com.oppo.camera.aps.constant.ParameterKeys;
import com.oppo.camera.d;
import com.oppo.camera.doubleexposure.g;
import com.oppo.camera.gl.GLRootView;
import com.oppo.camera.gl.t;
import com.oppo.camera.statistics.model.DcsMsgData;
import com.oppo.camera.statistics.model.FocusAimMsgData;
import com.oppo.camera.statistics.model.MenuClickMsgData;
import com.oppo.camera.statistics.model.ReminderMsgData;
import com.oppo.camera.sticker.data.StickerItem;
import com.oppo.camera.sticker.ui.h;
import com.oppo.camera.ui.CheckableImageButton;
import com.oppo.camera.ui.SwitchButton;
import com.oppo.camera.ui.control.MainShutterButton;
import com.oppo.camera.ui.control.ShutterButton;
import com.oppo.camera.ui.control.b;
import com.oppo.camera.ui.control.e;
import com.oppo.camera.ui.menu.OppoTextView;
import com.oppo.camera.ui.menu.a.g;
import com.oppo.camera.ui.menu.levelcontrol.a;
import com.oppo.camera.ui.menu.levelcontrol.e;
import com.oppo.camera.ui.menu.levelcontrol.f;
import com.oppo.camera.ui.menu.levelcontrol.k;
import com.oppo.camera.ui.menu.setting.CameraMenuOption;
import com.oppo.camera.ui.menu.setting.p;
import com.oppo.camera.ui.menu.setting.t;
import com.oppo.camera.ui.modepanel.c;
import com.oppo.camera.ui.modepanel.d;
import com.oppo.camera.ui.modepanel.f;
import com.oppo.camera.ui.preview.ScreenHoleView;
import com.oppo.camera.ui.preview.a;
import com.oppo.camera.ui.preview.a.h;
import com.oppo.camera.ui.preview.a.n;
import com.oppo.camera.ui.preview.d;
import com.oppo.camera.ui.preview.e;
import com.oppo.camera.ui.preview.m;
import com.oppo.camera.ui.preview.o;
import com.oppo.camera.ui.preview.v;
import com.oppo.camera.ui.widget.c;
import com.oppo.camera.ui.widget.e;
import com.oppo.camera.util.Util;
import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: CameraUIManager */
public class g implements d, e, d.b, e.b {
    public static boolean h = true;
    /* access modifiers changed from: private */
    public int A = 0;
    private int B = 0;
    /* access modifiers changed from: private */
    public int C = 0;
    /* access modifiers changed from: private */
    public int D = 0;
    private int E = 0;
    private long F = 0;
    private long G = 0;
    private long H = 0;
    /* access modifiers changed from: private */
    public ViewGroup I = null;
    /* access modifiers changed from: private */
    public CameraScreenHintView J = null;
    private CameraScreenHintView K = null;
    private CameraScreenHintView L = null;
    /* access modifiers changed from: private */
    public CameraScreenHintView M = null;
    /* access modifiers changed from: private */
    public com.oppo.camera.ui.menu.levelcontrol.e N = null;
    /* access modifiers changed from: private */
    public com.oppo.camera.ui.menu.levelcontrol.a O = null;
    private CameraScreenHintView P = null;
    private k Q = null;
    private View R = null;
    /* access modifiers changed from: private */
    public CameraScreenHintView S = null;
    private j T = null;
    private com.oppo.camera.ui.widget.d U = null;
    private PopupWindow V = null;
    private j W = null;
    private PopupWindow X = null;
    private j Y = null;
    private j Z = null;
    private boolean aA = false;
    private boolean aB = false;
    private boolean aC = true;
    private boolean aD = true;
    private com.oppo.camera.doubleexposure.g aE = null;
    /* access modifiers changed from: private */
    public ObjectAnimator aF = null;
    private com.oppo.camera.ui.preview.a.k aG = new com.oppo.camera.ui.preview.a.k() {
        public void a(ArrayList<h.b> arrayList, int i, StickerItem stickerItem, boolean z) {
        }

        public void a(f fVar) {
            com.oppo.camera.e.a("CameraUIManager", "imageReady");
            if (g.this.N != null && !g.this.l) {
                g.this.N.a(fVar);
            }
        }
    };
    /* access modifiers changed from: private */
    public a.C0106a aH = new a.C0106a() {
        public void a(int i, boolean z, boolean z2) {
            com.oppo.camera.e.a("CameraUIManager", "setPIEnable, code: " + i + ", enbalbe: " + z + ", changeByClick: " + z2);
            if (12 == i) {
                boolean unused = g.this.m = true;
                int unused2 = g.this.D = 0;
                if (g.this.aM != null) {
                    g.this.aM.removeMessages(1);
                }
            }
            if (g.this.x != null) {
                g.this.x.b(i, z, z2);
            }
        }

        public boolean a() {
            if (g.this.x != null) {
                return g.this.x.k();
            }
            return false;
        }

        public void a(int i) {
            if (g.this.x == null || g.this.x.k()) {
                if (i == 12) {
                    boolean unused = g.this.m = true;
                    int unused2 = g.this.D = 0;
                    if (g.this.aM != null) {
                        g.this.aM.removeMessages(1);
                    }
                    g.this.dP();
                }
                if (g.this.x != null) {
                    g.this.x.b(i);
                    return;
                }
                return;
            }
            com.oppo.camera.e.e("CameraUIManager", "onAISceneClosed, canRespondTouch is false!");
        }

        public void b(int i) {
            if (g.this.J != null) {
                g.this.J.b(g.this.U(i));
            }
            g.this.cC();
        }
    };
    /* access modifiers changed from: private */
    public b aI = new b() {
        public void a(int i) {
            if (g.this.af != null) {
                g.this.af.b(g.this.U(i));
            }
        }

        public void b(int i) {
            if (g.this.af != null) {
                g.this.af.a(i == 0, g.this.k("pref_ai_scene_key"));
            }
            if (8 == i && g.this.J != null) {
                g gVar = g.this;
                gVar.ax(!gVar.J.g());
            }
        }
    };
    private a aJ = new a() {
        public boolean a() {
            if (g.this.x != null) {
                return g.this.x.aM();
            }
            return false;
        }
    };
    private View.OnLayoutChangeListener aK = new View.OnLayoutChangeListener() {
        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            if (g.this.aH != null) {
                if (g.this.af.c()) {
                    g.this.aH.b(i3 - i);
                } else {
                    g.this.aH.b(0);
                }
            }
            g.this.cC();
        }
    };
    private View.OnLayoutChangeListener aL = new View.OnLayoutChangeListener() {
        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            if (g.this.aI != null) {
                g.this.aI.a((g.this.J.getHintIconView() == null || g.this.J.getHintIconView().getVisibility() != 0) ? 0 : (g.this.J.getCurrentOrientation() == 90 || g.this.J.getCurrentOrientation() == 270) ? view.getMeasuredHeight() : view.getMeasuredWidth());
            }
            g.this.cC();
        }
    };
    /* access modifiers changed from: private */
    public Handler aM = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message message) {
            com.oppo.camera.e.a("CameraUIManager", "handleMessage, msg: " + message.what);
            int i = message.what;
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        g.this.bY();
                    } else if (i == 4) {
                        g.this.df();
                    }
                } else if (message.obj != null && g.this.af != null && !g.this.k) {
                    int intValue = ((Integer) message.obj).intValue();
                    if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_PI_AI)) {
                        g.this.af.a(intValue, g.this.z, g.this.D);
                    } else {
                        g.this.T(intValue);
                    }
                    int unused = g.this.C = intValue;
                }
            } else if (!g.this.l && g.this.af != null && g.this.x != null && g.this.x.g("pref_support_night_process")) {
                int unused2 = g.this.D = 2;
                g gVar = g.this;
                gVar.D(gVar.C);
            }
        }
    };
    private View.OnClickListener aN = new View.OnClickListener() {
        public void onClick(View view) {
            com.oppo.camera.e.a("CameraUIManager", "mFaceBeautyEnterButtonListener, onClick");
            if (g.this.x != null && 1 == g.this.x.I() && g.this.p.aa()) {
                g.this.p.ab();
            }
            if (!g.this.cX()) {
                com.oppo.camera.e.a("CameraUIManager", "mFaceBeautyEnterButtonListener, onClick, preview not started");
            } else if (g.this.cF()) {
                com.oppo.camera.e.a("CameraUIManager", "mFaceBeautyEnterButtonListener, onClick, isHeadlineScrolling: true");
            } else if (g.this.cM()) {
                com.oppo.camera.e.a("CameraUIManager", "mFaceBeautyEnterButtonListener, onClick, isMoreModePanelAnimRunning: true");
            } else if (g.this.H()) {
                com.oppo.camera.e.a("CameraUIManager", "mFaceBeautyEnterButtonListener, onClick, isMoreModeShown: true");
            } else if (g.this.x != null && g.this.x.y()) {
                com.oppo.camera.e.a("CameraUIManager", "mFaceBeautyEnterButtonListener, onClick, isTimerSnapShotRunning: true");
            } else if (g.this.x != null && g.this.x.M()) {
                com.oppo.camera.e.a("CameraUIManager", "mFaceBeautyEnterButtonListener, onClick, isZoomMenuExpand: true");
            } else if (g.this.ao == null || g.this.ao.f() || g.this.N.g() || g.this.O.g()) {
                com.oppo.camera.e.d("CameraUIManager", "mFaceBeautyEnterButtonListener, onClick, return");
            } else if (g.this.ao.h()) {
                g.this.b(true, true, false);
                g.this.x.ad();
                g.this.aA(false);
            } else {
                if (g.this.x.ac()) {
                    g.this.n(true);
                    g.this.s(true);
                }
                if (g.this.w != null && g.this.w.b()) {
                    g.this.w.a(8);
                }
                g.this.aA(true);
            }
        }
    };
    private CheckableImageButton.b aO = new CheckableImageButton.b() {
        public void a(View view) {
            com.oppo.camera.e.a("CameraUIManager", "mTiltShiftBlurButtonListener, onClick");
            if (g.this.x != null && g.this.p.aa()) {
                g.this.p.ab();
            }
            if (g.this.cF()) {
                com.oppo.camera.e.a("CameraUIManager", "mTiltShiftBlurButtonListener, onClick, isHeadlineScrolling: true");
            } else if (g.this.cM()) {
                com.oppo.camera.e.a("CameraUIManager", "mTiltShiftBlurButtonListener, onClick, isMoreModePanelAnimRunning: true");
            } else if (g.this.H()) {
                com.oppo.camera.e.a("CameraUIManager", "mTiltShiftBlurButtonListener, onClick, isMoreModeShown: true");
            } else if (g.this.x != null && g.this.x.y()) {
                com.oppo.camera.e.a("CameraUIManager", "mTiltShiftBlurButtonListener, onClick, isTimerSnapShotRunning: true");
            } else if (g.this.x != null && g.this.x.M()) {
                com.oppo.camera.e.a("CameraUIManager", "mTiltShiftBlurButtonListener, onClick, isZoomMenuExpand: true");
            } else if (g.this.an == null || g.this.ao.f() || g.this.N.g() || g.this.O.g() || g.this.ak.g()) {
                com.oppo.camera.e.d("CameraUIManager", "mTiltShiftBlurButtonListener, onClick, return");
            } else {
                g.this.r("pref_tilt_shift_blur_menu");
            }
        }
    };
    private g.a aP = new g.a() {
        public void a() {
            g.this.x.H();
        }

        public int b() {
            return g.this.x.J();
        }

        public int a(int i) {
            return g.this.x.d(i);
        }

        public void b(int i) {
            g.this.x.e(i);
            g.this.dw();
        }

        public void a(View view) {
            if (g.this.r.getBoolean("key_bubble_type_custom_face_beauty_close", true)) {
                g.this.a(view, 8, 0, 0);
            } else {
                g.this.c(8, false);
            }
        }

        public void a(int i, int i2, boolean z) {
            g.this.x.a(i, i2, z);
            if (g.this.n && 40 != i2) {
                g.this.dI();
            }
        }

        public boolean c() {
            return g.this.x.k();
        }

        public int d() {
            return g.this.x.K();
        }

        public int[] e() {
            return g.this.x.L();
        }
    };
    private e.a aQ = new e.a() {
        public void a() {
            if (g.this.x != null) {
                g.this.x.h();
            }
        }

        public void a(com.oppo.camera.ui.menu.levelcontrol.g gVar) {
            if (g.this.q != null) {
                g.this.q.a(gVar);
            }
        }

        public void a(boolean z) {
            if (g.this.x != null) {
                g.this.x.a(z);
            }
        }

        public void a(int i, boolean z) {
            if (g.this.x != null) {
                g.this.x.a(i, z, true);
            }
        }

        public boolean a(int i) {
            if (g.this.x != null) {
                return g.this.x.a(i);
            }
            return false;
        }

        public boolean b() {
            if (g.this.x != null) {
                return g.this.x.k();
            }
            return false;
        }

        public void a(String str) {
            if (g.this.x != null) {
                g.this.x.c(str);
            }
        }

        public void b(String str) {
            if (g.this.x != null) {
                g.this.x.d(str);
            }
        }

        public boolean c() {
            if (g.this.x != null) {
                return g.this.x.n();
            }
            return false;
        }

        public boolean d() {
            return !g.this.t();
        }

        public int e() {
            if (g.this.x != null) {
                return g.this.x.m();
            }
            return 0;
        }

        public int f() {
            if (g.this.I != null) {
                return g.this.I.indexOfChild(g.this.p.R()) + 1;
            }
            return -1;
        }
    };
    private a.C0103a aR = new a.C0103a() {
        public boolean a() {
            return !g.this.t();
        }

        public boolean b() {
            return g.this.x.ag();
        }

        public boolean c() {
            return g.this.x.k();
        }

        public void a(boolean z, boolean z2) {
            if (z2) {
                g.this.x.a(z);
            }
            if (g.this.al != null && g()) {
                g.this.al.setChecked(false);
            }
            if (!h()) {
                g.this.a((byte) 1, true);
            }
        }

        public void d() {
            g.this.a((byte) 2, true);
        }

        public void a(int i, boolean z) {
            g.this.x.a(i, z);
        }

        public void b(boolean z, boolean z2) {
            com.oppo.camera.e.a("CameraUIManager", "mBlurMenuListener, onBlurStateChange, isBlurOpen: " + z);
            if (!g.this.x.p()) {
                g.this.x.a(z, z2);
                g.this.v.b("pref_video_blur_menu", z);
            }
        }

        public int e() {
            return g.this.x.ae();
        }

        public boolean f() {
            return !g.this.x.p() && !g();
        }

        public boolean g() {
            return g.this.x.ah();
        }

        public boolean h() {
            return g.this.x.b();
        }

        public boolean i() {
            return g.this.k(CameraFunction.SAT_CAMERA);
        }
    };
    private t.b aS = new t.b() {
        public void a(String str) {
            com.oppo.camera.e.a("CameraUIManager", "onExpandMenuShow, key: " + str);
            g.this.s(str);
            if (g.this.cm() && g.this.ar) {
                g.this.ai(true);
            } else if (g.this.p != null) {
                g.this.p.g();
            }
            if (g.this.x != null) {
                g.this.x.j();
            }
            g.this.a(true, true, false, false);
            g.this.i(8, true);
            if (g.this.x != null) {
                String aG = g.this.x.aG();
                if (TextUtils.equals(aG, str)) {
                    g.this.a(true, str);
                }
                if (TextUtils.equals(aG, str.concat("_from_other_app"))) {
                    g.this.a(true, aG);
                }
            }
        }

        public void a(String str, boolean z, boolean z2) {
            if (g.this.x != null) {
                String aG = g.this.x.aG();
                if (TextUtils.equals(aG, str)) {
                    g.this.a(false, str);
                } else if (TextUtils.equals(aG, str.concat("_from_other_app"))) {
                    g.this.a(false, aG);
                } else {
                    g.this.d(str, true);
                }
            }
            if (g.this.ar) {
                if (g.this.x != null && !g.this.x.y() && z && !z2) {
                    g.this.ah(true);
                }
            } else if (g.this.p != null && z && !z2) {
                g.this.p.d(true, true);
            }
            g.this.n(true);
            if (!z2) {
                if (g.this.x != null && g.this.x.aA()) {
                    g.this.r(true);
                }
                g.this.i(0, true);
            }
        }
    };
    /* access modifiers changed from: private */
    public com.oppo.camera.ui.widget.d aa = null;
    private com.oppo.camera.ui.widget.d ab = null;
    private byte ac = 0;
    private Map<String, ConcurrentHashMap<Integer, View>> ad = new HashMap();
    private Map<String, t> ae = new HashMap();
    /* access modifiers changed from: private */
    public com.oppo.camera.ui.preview.a af = null;
    /* access modifiers changed from: private */
    public m ag = null;
    private c ah = null;
    private t ai = null;
    /* access modifiers changed from: private */
    public RotateImageView aj = null;
    /* access modifiers changed from: private */
    public com.oppo.camera.ui.menu.levelcontrol.a ak = null;
    /* access modifiers changed from: private */
    public CheckableImageButton al = null;
    private CheckableImageButton am = null;
    /* access modifiers changed from: private */
    public LinearLayout an = null;
    /* access modifiers changed from: private */
    public com.oppo.camera.ui.menu.a.g ao = null;
    /* access modifiers changed from: private */
    public SwitchButton ap = null;
    private ObjectAnimator aq = null;
    /* access modifiers changed from: private */
    public boolean ar = false;
    /* access modifiers changed from: private */
    public com.oppo.camera.ui.modepanel.f as = null;
    private boolean at = false;
    private int au = 0;
    private int av = 0;
    private com.oppo.camera.l.a aw = null;
    private com.oppo.camera.ui.widget.c ax = null;
    private Size ay = null;
    private boolean az = false;
    /* access modifiers changed from: private */
    public Activity i = null;
    private boolean j = false;
    /* access modifiers changed from: private */
    public boolean k = false;
    /* access modifiers changed from: private */
    public boolean l = false;
    /* access modifiers changed from: private */
    public boolean m = false;
    /* access modifiers changed from: private */
    public boolean n = false;
    private com.oppo.camera.ui.a.a o = null;
    /* access modifiers changed from: private */
    public com.oppo.camera.ui.control.b p = null;
    /* access modifiers changed from: private */
    public com.oppo.camera.ui.preview.d q = null;
    /* access modifiers changed from: private */
    public com.oppo.camera.k r = null;
    private com.oppo.camera.soloop.b s = null;
    private v t = null;
    private com.oppo.camera.ui.preview.f u = null;
    /* access modifiers changed from: private */
    public p v = null;
    /* access modifiers changed from: private */
    public com.oppo.camera.ui.menu.setting.f w = null;
    /* access modifiers changed from: private */
    public f x = null;
    private int y = 1;
    /* access modifiers changed from: private */
    public int z = 0;

    private boolean O(int i2) {
        return 10 == i2 || 16 == i2 || 17 == i2;
    }

    private boolean P(int i2) {
        return 10 == i2 || 16 == i2 || 17 == i2 || i2 == 0;
    }

    private boolean Q(int i2) {
        return (12 == i2 || 19 == i2) ? false : true;
    }

    private boolean R(int i2) {
        return (12 == i2 || 19 == i2 || 4 == i2) ? false : true;
    }

    private boolean S(int i2) {
        return (12 == i2 || 4 == i2) ? false : true;
    }

    public void a(com.oppo.camera.soloop.b bVar) {
        this.s = bVar;
        if (this.r.getBoolean("pref_allow_network_access", false)) {
            bVar.a();
        }
    }

    public void z(boolean z2) {
        this.ar = z2;
    }

    public void g(boolean z2, boolean z3) {
        com.oppo.camera.ui.menu.levelcontrol.e eVar = this.N;
        if (eVar != null) {
            eVar.b(z2, z3);
        }
    }

    public void x() {
        int i2 = 0;
        this.p.f(true, false);
        p(false);
        if (s()) {
            this.N.b(true, false);
        }
        Size aX = aX();
        if (aX != null) {
            i2 = Util.b(aX.getWidth(), aX.getHeight());
        }
        d(i2, true);
    }

    public void w() {
        this.p.f(false, true);
        if (s()) {
            this.N.b(true, false);
        }
        o(false);
        b(false);
        t(false);
        Size aX = aX();
        if (aX != null) {
            L(Util.b(aX.getWidth(), aX.getHeight()));
        }
    }

    private void L(int i2) {
        if (Util.b(i2)) {
            Y(true);
            com.oppo.camera.ui.control.b bVar = this.p;
            if (bVar != null) {
                bVar.o(true);
            }
        }
    }

    public com.oppo.camera.ui.preview.a.k z() {
        return this.aG;
    }

    public g(Activity activity, com.oppo.camera.k kVar, f fVar) {
        this.i = activity;
        this.r = kVar;
        this.x = fVar;
        this.p = new com.oppo.camera.ui.control.b(this.i, this.r, this.x);
        this.q = new com.oppo.camera.ui.preview.d(this.i, this.r, this);
        com.oppo.camera.ui.inverse.c.INS.setCameraPreviewUI(this.i, this.q);
        this.v = new p(this.i, this.r, fVar, false);
        this.w = new com.oppo.camera.ui.menu.setting.f(this.i, this.r, fVar, true);
        this.o = new com.oppo.camera.ui.a.a(this.i, fVar, this.p);
    }

    public void a(com.oppo.camera.ui.control.d dVar) {
        this.p.a(dVar);
    }

    public boolean aD() {
        return this.p.a();
    }

    public boolean d() {
        com.oppo.camera.ui.control.b bVar = this.p;
        if (bVar != null) {
            return bVar.b();
        }
        return false;
    }

    public void K(boolean z2) {
        com.oppo.camera.ui.control.b bVar = this.p;
        if (bVar != null) {
            bVar.a(z2);
        }
    }

    public void L(boolean z2) {
        com.oppo.camera.ui.control.b bVar = this.p;
        if (bVar != null) {
            bVar.b(z2);
        }
    }

    public void a(n nVar) {
        com.oppo.camera.e.a("CameraUIManager", "onCreate");
        com.oppo.camera.e.a("UIManager.onCreate");
        this.j = false;
        this.I = (ViewGroup) this.i.findViewById(R.id.camera);
        com.oppo.camera.ui.a.a aVar = this.o;
        if (aVar != null) {
            aVar.a(this.I);
        }
        com.oppo.camera.ui.preview.d dVar = this.q;
        if (dVar != null) {
            dVar.a(nVar);
        }
        com.oppo.camera.ui.control.b bVar = this.p;
        if (bVar != null) {
            bVar.c();
        }
        p pVar = this.v;
        if (pVar != null) {
            pVar.s();
        }
        com.oppo.camera.ui.menu.setting.f fVar = this.w;
        if (fVar != null) {
            fVar.s();
        }
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_PI_AI)) {
            this.af = new com.oppo.camera.ui.preview.p(this.i, this.I, this.r);
        } else {
            this.af = new o(this.i, this.I, this.r);
        }
        this.af.a(this.aH);
        this.af.a(this.aK);
        this.af.a(this.i.getResources().getDimensionPixelSize(R.dimen.camera_up_hint_margin_top) - this.af.a());
        this.E = this.af.a();
        this.N = new com.oppo.camera.ui.menu.levelcontrol.e(this.i);
        this.N.setCameraEntryType(this.y);
        this.N.a(this.z);
        this.N.setFilterEffectMenuListener(this.aQ);
        this.O = new com.oppo.camera.ui.menu.levelcontrol.a(this.i, this.aR);
        this.aj = (RotateImageView) this.i.findViewById(R.id.face_beauty_enter_button);
        Drawable drawable = this.i.getDrawable(R.drawable.face_beauty_menu_control_button_highlight);
        if (drawable != null) {
            drawable.setAlpha(0);
            this.aj.setForeground(drawable);
            this.aF = ObjectAnimator.ofInt(drawable, "alpha", new int[]{0, 255});
            this.aF.setInterpolator(AnimationUtils.loadInterpolator(this.i, R.anim.alpha_path_interpolator));
            this.aF.setDuration(180);
        }
        this.aj.setOnClickListener(this.aN);
        this.ao = new com.oppo.camera.ui.menu.a.g(this.i, this.aP, this.y, this.x);
        if (this.y == 1) {
            dA();
            dV();
        }
        com.oppo.camera.e.b("UIManager.onCreate");
    }

    public void aE() {
        com.oppo.camera.ui.preview.d dVar = this.q;
        if (dVar != null) {
            dVar.d();
        }
        com.oppo.camera.ui.control.b bVar = this.p;
        if (bVar != null) {
            bVar.d();
        }
    }

    public void aF() {
        k kVar = this.Q;
        if (kVar != null) {
            kVar.c();
        }
    }

    public void aG() {
        k kVar = this.Q;
        if (kVar != null) {
            kVar.b();
        }
    }

    public void M(boolean z2) {
        au(z2);
    }

    private void au(boolean z2) {
        if (z2) {
            cC();
            f fVar = this.x;
            if (fVar != null && !fVar.ak()) {
                this.x.af();
                if (this.af != null && !cH()) {
                    T(this.x.al());
                }
            }
            f fVar2 = this.x;
            if (fVar2 != null && fVar2.ah() && !this.l) {
                a(true, true, false);
                if (this.x.e()) {
                    x(true);
                    return;
                }
                return;
            }
            return;
        }
        f fVar3 = this.x;
        if (fVar3 != null && fVar3.ah()) {
            y(false);
        }
        a(true, true, false);
        cw();
        u(false);
        a(true);
    }

    public void N(boolean z2) {
        au(!z2);
        com.oppo.camera.ui.menu.setting.f fVar = this.w;
        int i2 = 8;
        if (fVar != null) {
            fVar.a(z2 ? 0 : 8);
        }
        if (z2 && C()) {
            b(false, true, false);
        }
        p pVar = this.v;
        if (pVar != null) {
            if (z2) {
                i2 = 0;
            }
            pVar.a("pref_subsetting_key", i2);
            this.v.A();
        }
    }

    public boolean aH() {
        com.oppo.camera.ui.menu.setting.f fVar = this.w;
        if (fVar != null) {
            return fVar.b();
        }
        return false;
    }

    public void c(String str, boolean z2) {
        com.oppo.camera.ui.menu.setting.f fVar = this.w;
        if (fVar != null) {
            fVar.a(str, z2);
        }
    }

    public void aI() {
        m mVar = this.ag;
        if (mVar != null) {
            mVar.b();
        }
    }

    public boolean J() {
        return !this.l && this.w.x();
    }

    public void K() {
        com.oppo.camera.ui.menu.setting.f fVar = this.w;
        if (fVar != null) {
            fVar.c(false);
        }
        com.oppo.camera.k kVar = this.r;
        if (kVar != null) {
            kVar.edit().putString("pref_subsetting_key", "off").apply();
            f("pref_subsetting_key");
        }
    }

    public void h(boolean z2, boolean z3) {
        p pVar = this.v;
        if (pVar != null) {
            pVar.b(z2, z3);
        }
        com.oppo.camera.ui.menu.setting.f fVar = this.w;
        if (fVar != null) {
            fVar.b(z2, z3);
        }
    }

    public void a(boolean z2, String str) {
        f fVar = this.x;
        if (fVar != null && this.r != null && this.i != null) {
            if (com.oppo.camera.ui.preview.a.g.f4385a == this.r.getInt(fVar.aF(), com.oppo.camera.ui.preview.a.g.f4385a)) {
                a(str, z2 ? R.drawable.menu_effect_off_light_selector : R.drawable.menu_effect_off_selector);
            } else {
                a(str, (int) R.drawable.menu_effect_on_selector);
            }
        }
    }

    public void c(String str, int i2) {
        p pVar = this.v;
        if (pVar != null) {
            pVar.c(str, i2);
        }
    }

    public void a(final boolean z2, final int i2) {
        Activity activity = this.i;
        if (activity != null) {
            activity.runOnUiThread(new Runnable() {
                public void run() {
                    int i;
                    if (g.this.ag == null) {
                        int E = Util.E() / 2;
                        if (g.this.A == 0 || g.this.A == 2) {
                            i = g.this.q.E().getTop() + (g.this.q.E().getHeight() / 2);
                        } else {
                            i = g.this.i.getResources().getDimensionPixelSize(R.dimen.gradienter_full_margin_top);
                        }
                        com.oppo.camera.e.b("CameraUIManager", "showGradienterView, top: " + g.this.q.E().getTop() + ", height: " + g.this.q.E().getHeight() + ", centerY: " + i + ", mSizeRatioType: " + g.this.A);
                        g gVar = g.this;
                        m unused = gVar.ag = new m(gVar.i, E, i, i2);
                        g.this.ag.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
                        g.this.I.addView(g.this.ag);
                        g.this.ag.setVisibility(4);
                    }
                    if (g.this.ag != null && z2) {
                        g.this.ag.a();
                    }
                }
            });
        }
    }

    public void a(int i2, boolean z2, String str) {
        com.oppo.camera.e.b("CameraUIManager", "updateGradienterView, orientation: " + i2);
        if (this.ag == null) {
            return;
        }
        if (!z2 || !str.equals(ApsConstant.CAPTURE_MODE_PROFESSIONAL)) {
            this.ag.a(i2);
            return;
        }
        this.ag.setOrientation(i2);
        this.ag.b();
    }

    public void aJ() {
        m mVar = this.ag;
        if (mVar != null && this.I != null) {
            mVar.c();
            this.I.removeView(this.ag);
            this.ag = null;
        }
    }

    public void a(int i2, String str, boolean z2) {
        f fVar;
        ar();
        com.oppo.camera.ui.a.a aVar = this.o;
        if (aVar != null) {
            aVar.a();
        }
        com.oppo.camera.ui.preview.d dVar = this.q;
        if (dVar != null) {
            dVar.e();
            if (!this.x.aI()) {
                this.q.an();
            }
        }
        v vVar = this.t;
        if (vVar != null) {
            vVar.a(false, cU());
        }
        com.oppo.camera.ui.control.b bVar = this.p;
        if (bVar != null) {
            bVar.a(i2, str, z2);
        }
        com.oppo.camera.ui.modepanel.f fVar2 = this.as;
        if (fVar2 != null) {
            fVar2.b(false);
            ao(true);
            f fVar3 = this.x;
            if (fVar3 != null) {
                fVar3.f(1);
            }
        }
        com.oppo.camera.ui.menu.levelcontrol.e eVar = this.N;
        if (eVar != null) {
            eVar.a();
            a("pref_filter_menu", (t) this.N);
            a("pref_portrait_new_style_menu", (t) this.N);
            a("pref_video_filter_menu", (t) this.N);
            a("pref_night_filter_menu", (t) this.N);
        }
        com.oppo.camera.ui.menu.levelcontrol.a aVar2 = this.O;
        if (aVar2 != null) {
            a("pref_portrait_blur_menu", (t) aVar2);
            a("pref_video_blur_menu", (t) this.O);
        }
        com.oppo.camera.ui.menu.levelcontrol.a aVar3 = this.ak;
        if (aVar3 != null) {
            a("pref_tilt_shift_blur_menu", (t) aVar3);
        }
        f fVar4 = this.x;
        if (fVar4 != null) {
            fVar4.a((com.oppo.camera.t.a) null);
            this.x.b(false);
        }
        dX();
        com.oppo.camera.l.a aVar4 = this.aw;
        if (aVar4 != null) {
            aVar4.e();
        }
        com.oppo.camera.doubleexposure.g gVar = this.aE;
        if (gVar != null) {
            gVar.e();
            if (!this.aE.o() && (fVar = this.x) != null && fVar.g(CameraFunction.DOUBLE_EXPOSURE) && this.x.g("key_support_share_edit_thumb")) {
                ae();
            }
        }
    }

    public void ar() {
        com.oppo.camera.ui.menu.setting.f fVar;
        if (this.aM != null && !this.az && this.r.getBoolean("show_arrow_animation", false)) {
            if ((!this.r.getBoolean("key_drawer_show_guide_animation", true) || !h) && (fVar = this.w) != null && fVar.p()) {
                this.aM.sendEmptyMessage(3);
            }
        }
    }

    public void e(boolean z2, boolean z3, boolean z4) {
        com.oppo.camera.e.a("CameraUIManager", "onResumeMessage");
        this.l = false;
        com.oppo.camera.ui.control.b bVar = this.p;
        if (bVar != null) {
            bVar.i();
        }
        p pVar = this.v;
        if (pVar != null) {
            pVar.g();
        }
        com.oppo.camera.ui.menu.setting.f fVar = this.w;
        if (fVar != null) {
            fVar.g();
        }
        if (!this.j && !z2 && !z3) {
            P(z4);
        }
        if (this.y == 3) {
            o(false);
            a(false, false, false, false);
        }
        com.oppo.camera.ui.preview.d dVar = this.q;
        if (dVar != null) {
            if (dVar.z() && this.y == 2) {
                br();
            }
            this.q.f();
        }
        CameraScreenHintView cameraScreenHintView = this.J;
        if (cameraScreenHintView != null) {
            cameraScreenHintView.b();
        }
        CameraScreenHintView cameraScreenHintView2 = this.K;
        if (cameraScreenHintView2 != null) {
            cameraScreenHintView2.b();
        }
        CameraScreenHintView cameraScreenHintView3 = this.L;
        if (cameraScreenHintView3 != null) {
            cameraScreenHintView3.b();
        }
        CameraScreenHintView cameraScreenHintView4 = this.M;
        if (cameraScreenHintView4 != null) {
            cameraScreenHintView4.b();
        }
        CameraScreenHintView cameraScreenHintView5 = this.P;
        if (cameraScreenHintView5 != null) {
            cameraScreenHintView5.b();
        }
        if (!Camera.l) {
            b((int) R.string.camera_low_battery_flash_disable);
        }
        if (!Camera.m) {
            b((int) R.string.camera_high_temperature_flash_disable);
        }
        bS();
        String string = this.r.getString("pref_camera_tap_shutter_key", this.i.getString(R.string.camera_tap_shutter_default_value));
        if (this.x.g("pref_camera_tap_shutter_key") && string.equals("on") && dR() && this.ac != 2) {
            this.ac = 1;
        }
        if (this.ac == 1) {
            a((int) R.string.camera_tab_shutter_toast, -1, true, false, false);
            this.ac = 2;
        }
    }

    public void O(boolean z2) {
        com.oppo.camera.ui.control.b bVar = this.p;
        if (bVar != null) {
            bVar.h(z2);
        }
    }

    public void b(com.oppo.camera.ui.control.c cVar, boolean z2) {
        ViewGroup viewGroup;
        com.oppo.camera.e.a("CameraUIManager", "onPause");
        this.l = true;
        this.av = 0;
        this.ac = 0;
        this.D = 0;
        this.C = 0;
        this.m = false;
        this.A = -1;
        this.at = false;
        this.az = false;
        if (dR()) {
            SharedPreferences.Editor edit = this.r.edit();
            edit.putString("last_camera_tap_shutter_key", this.r.getString("pref_camera_tap_shutter_key", this.i.getString(R.string.camera_tap_shutter_default_value)));
            edit.apply();
        }
        Handler handler = this.aM;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
        }
        com.oppo.camera.ui.a.a aVar = this.o;
        if (aVar != null) {
            aVar.b();
        }
        p pVar = this.v;
        if (pVar != null) {
            pVar.e();
        }
        ak(true);
        am(false);
        com.oppo.camera.ui.menu.setting.f fVar = this.w;
        if (fVar != null) {
            fVar.e();
        }
        com.oppo.camera.ui.menu.f.f();
        com.oppo.camera.ui.control.b bVar = this.p;
        if (bVar != null) {
            bVar.a(cVar, z2);
        }
        com.oppo.camera.ui.preview.d dVar = this.q;
        if (dVar != null) {
            dVar.i();
        }
        v vVar = this.t;
        if (vVar != null) {
            vVar.c();
        }
        View view = this.R;
        if (view != null) {
            view.setVisibility(8);
        }
        CameraScreenHintView cameraScreenHintView = this.K;
        if (cameraScreenHintView != null) {
            cameraScreenHintView.a();
            u(true);
        }
        CameraScreenHintView cameraScreenHintView2 = this.J;
        if (cameraScreenHintView2 != null) {
            cameraScreenHintView2.a();
        }
        CameraScreenHintView cameraScreenHintView3 = this.L;
        if (cameraScreenHintView3 != null) {
            cameraScreenHintView3.a();
        }
        CameraScreenHintView cameraScreenHintView4 = this.M;
        if (cameraScreenHintView4 != null) {
            cameraScreenHintView4.c(false);
            this.M.a();
        }
        com.oppo.camera.ui.menu.levelcontrol.e eVar = this.N;
        if (eVar != null) {
            eVar.e();
        }
        com.oppo.camera.ui.menu.levelcontrol.a aVar2 = this.O;
        if (aVar2 != null) {
            if (aVar2.h()) {
                this.O.a(false, false, false, true);
            }
            this.O.setVideoRecordingHideMenu(false);
        }
        com.oppo.camera.ui.menu.levelcontrol.a aVar3 = this.ak;
        if (aVar3 != null) {
            if (aVar3.h()) {
                this.ak.a(false, false, false, true);
            }
            this.ak.setVideoRecordingHideMenu(false);
        }
        CameraScreenHintView cameraScreenHintView5 = this.P;
        if (cameraScreenHintView5 != null) {
            this.I.removeView(cameraScreenHintView5);
            this.P = null;
        }
        CameraScreenHintView cameraScreenHintView6 = this.S;
        if (!(cameraScreenHintView6 == null || (viewGroup = this.I) == null)) {
            viewGroup.removeView(cameraScreenHintView6);
            this.S = null;
        }
        com.oppo.camera.ui.menu.a.g gVar = this.ao;
        if (gVar != null) {
            if (gVar.h()) {
                b(false, true, false);
            }
            this.ao.d(false);
        }
        Map<String, t> map = this.ae;
        if (map != null) {
            map.clear();
        }
        this.ai = null;
        b(true);
        t(true);
        cq();
        dr();
        aJ();
        k kVar = this.Q;
        if (kVar != null) {
            kVar.a();
        }
        com.oppo.camera.ui.menu.a.g gVar2 = this.ao;
        if (gVar2 != null) {
            gVar2.i();
        }
        com.oppo.camera.l.a aVar4 = this.aw;
        if (aVar4 != null) {
            aVar4.f();
        }
        com.oppo.camera.doubleexposure.g gVar3 = this.aE;
        if (gVar3 != null) {
            gVar3.c();
        }
        if (ak()) {
            i(false, false);
            al();
        }
        at(false);
    }

    public void aK() {
        com.oppo.camera.e.a("CameraUIManager", "onStop");
        if (this.y == 2) {
            br();
        }
        com.oppo.camera.ui.preview.d dVar = this.q;
        if (dVar != null) {
            dVar.j();
        }
        com.oppo.camera.ui.control.b bVar = this.p;
        if (bVar != null) {
            bVar.j();
        }
        com.oppo.camera.k kVar = this.r;
        if (kVar != null && kVar.getBoolean("pref_camera_statement_key", false)) {
            du();
        }
    }

    public void aL() {
        com.oppo.camera.e.a("CameraUIManager", "onDestroy");
        this.aj = null;
        this.N = null;
        this.ah = null;
        this.O = null;
        this.x = null;
        this.i = null;
        this.s = null;
        com.oppo.camera.ui.a.a aVar = this.o;
        if (aVar != null) {
            aVar.c();
            this.o = null;
        }
        com.oppo.camera.ui.control.b bVar = this.p;
        if (bVar != null) {
            bVar.k();
            this.p = null;
        }
        com.oppo.camera.ui.modepanel.f fVar = this.as;
        if (fVar != null) {
            fVar.e();
            this.as = null;
        }
        p pVar = this.v;
        if (pVar != null) {
            pVar.f();
            this.v = null;
        }
        com.oppo.camera.ui.menu.setting.f fVar2 = this.w;
        if (fVar2 != null) {
            fVar2.f();
            this.w = null;
        }
        com.oppo.camera.ui.preview.d dVar = this.q;
        if (dVar != null) {
            dVar.k();
            this.q = null;
        }
        ViewGroup viewGroup = this.I;
        if (viewGroup != null) {
            viewGroup.removeAllViewsInLayout();
            this.I.removeAllViews();
            this.I = null;
        }
        com.oppo.camera.ui.menu.a.g gVar = this.ao;
        if (gVar != null) {
            gVar.j();
            this.ao = null;
        }
        com.oppo.camera.ui.preview.a aVar2 = this.af;
        if (aVar2 != null) {
            aVar2.d();
            this.af.j();
            this.af = null;
        }
        v vVar = this.t;
        if (vVar != null) {
            vVar.h();
            this.t = null;
        }
        com.oppo.camera.l.a aVar3 = this.aw;
        if (aVar3 != null) {
            aVar3.g();
            this.aw = null;
        }
        if (this.ap != null) {
            this.ap = null;
        }
        if (this.T != null) {
            this.T = null;
        }
        com.oppo.camera.doubleexposure.g gVar2 = this.aE;
        if (gVar2 != null) {
            gVar2.d();
            this.aE = null;
        }
    }

    public void P(boolean z2) {
        aM();
        e(0);
        i(true);
        com.oppo.camera.ui.control.b bVar = this.p;
        if (bVar != null) {
            bVar.d(0);
        }
        if (z2) {
            L(this.A);
            a(false, true);
            return;
        }
        if (this.x.g("pref_filter_process_key")) {
            p(false);
        } else {
            o(false);
        }
        if (!this.x.g(CameraFunction.FACE_BEAUTY_PROCESS) || !this.x.aA()) {
            a(false, false, false, false);
        } else {
            r(false);
        }
        as(false);
        if (this.x.g(CameraFunction.KEY_VIDEO_SUPER_EIS_WIDE)) {
            v(false);
        } else {
            w(false);
        }
        if (this.x.ah()) {
            x(false);
        } else {
            y(false);
        }
        if (dQ()) {
            E();
        } else {
            F();
        }
        if (!this.x.aI()) {
            d(this.A, false);
        }
    }

    public void aM() {
        com.oppo.camera.ui.control.b bVar = this.p;
        if (bVar != null) {
            bVar.c(true);
        }
    }

    public void Q(boolean z2) {
        p pVar = this.v;
        if (pVar != null) {
            pVar.d(z2);
        }
        com.oppo.camera.ui.menu.setting.f fVar = this.w;
        if (fVar != null) {
            fVar.d(z2);
        }
    }

    public void b(com.oppo.camera.ui.control.c cVar) {
        com.oppo.camera.e.a("CameraUIManager", "switchToModeType, buttonType: " + cVar.a() + ", insideColor: " + cVar.b() + ", shape: " + cVar.c());
        com.oppo.camera.ui.menu.f.d();
        this.m = false;
        this.C = 0;
        Handler handler = this.aM;
        if (handler != null) {
            handler.removeMessages(1);
        }
        if (aQ()) {
            bE();
        }
        if (this.y != 3) {
            this.p.a(cVar);
        }
        com.oppo.camera.ui.menu.a.g gVar = this.ao;
        if (gVar != null) {
            gVar.e();
        }
    }

    public void a(String str, com.oppo.camera.ui.control.c cVar, boolean z2) {
        com.oppo.camera.ui.control.b bVar = this.p;
        if (bVar != null) {
            bVar.b(cVar, z2);
            if (this.y != 3 && !this.l && !this.x.ay()) {
                this.p.c(false);
            }
        }
        if (this.y != 3) {
            this.x.o();
            Q(true);
        }
        if (this.x.g("pref_filter_process_key")) {
            p(true);
        } else {
            o(false);
            n(false);
        }
        if (this.x.g(CameraFunction.KEY_VIDEO_SUPER_EIS_WIDE)) {
            v(true);
        } else {
            w(false);
        }
        if (this.x.ah()) {
            a(true, true, false);
            x(false);
        } else {
            y(false);
        }
        if (dQ()) {
            E();
        } else {
            F();
        }
        d(false);
        if (!this.x.ar()) {
            b((int) R.string.camera_dark_environment_open_flash_toast);
        }
        if (D()) {
            a(true, false, false);
        }
    }

    public void aN() {
        com.oppo.camera.ui.control.b bVar = this.p;
        if (bVar != null) {
            bVar.l();
        }
    }

    public void aO() {
        com.oppo.camera.ui.control.b bVar = this.p;
        if (bVar != null) {
            bVar.m();
        }
    }

    public void a(List<String> list, String str, int i2) {
        com.oppo.camera.ui.menu.levelcontrol.e eVar = this.N;
        if (eVar != null) {
            eVar.a(list, str, i2);
        }
    }

    public boolean aP() {
        return this.j;
    }

    public void u(int i2) {
        this.B = i2;
        com.oppo.camera.ui.preview.d dVar = this.q;
        if (dVar != null) {
            dVar.d(i2);
        }
    }

    public void a(t.a aVar, boolean z2, boolean z3, String str) {
        com.oppo.camera.ui.preview.d dVar = this.q;
        if (dVar != null) {
            dVar.a(aVar, z2, z3, str);
        }
    }

    public boolean aQ() {
        f fVar = this.x;
        if (fVar != null) {
            return fVar.w();
        }
        return false;
    }

    public boolean aR() {
        f fVar = this.x;
        if (fVar != null) {
            return fVar.x();
        }
        return false;
    }

    public void aS() {
        f fVar = this.x;
        if (fVar != null) {
            fVar.D();
        }
    }

    public void d(int i2, int i3) {
        f fVar = this.x;
        if (fVar != null) {
            fVar.b(i2, i3);
        }
    }

    public void e(int i2, int i3) {
        f fVar = this.x;
        if (fVar != null) {
            fVar.c(i2, i3);
        }
    }

    public boolean ai() {
        f fVar = this.x;
        if (fVar != null) {
            return fVar.M();
        }
        return false;
    }

    public ShutterButton aT() {
        com.oppo.camera.ui.control.b bVar = this.p;
        if (bVar != null) {
            return bVar.o();
        }
        return null;
    }

    public void j(String str) {
        com.oppo.camera.ui.control.b bVar = this.p;
        if (bVar != null) {
            bVar.a(str);
        }
    }

    public com.oppo.camera.ui.control.e aU() {
        com.oppo.camera.ui.control.b bVar = this.p;
        if (bVar != null) {
            return bVar.q();
        }
        return null;
    }

    public int aV() {
        com.oppo.camera.ui.control.b bVar = this.p;
        if (bVar != null) {
            return bVar.r();
        }
        return 0;
    }

    public Surface aW() {
        com.oppo.camera.ui.preview.d dVar = this.q;
        if (dVar != null) {
            return dVar.B();
        }
        return null;
    }

    public Size aX() {
        return this.q.C();
    }

    public void a(Size size) {
        this.ay = size;
    }

    public com.oppo.camera.ui.preview.e c() {
        com.oppo.camera.ui.preview.d dVar = this.q;
        if (dVar != null) {
            return dVar.D();
        }
        return null;
    }

    public RelativeLayout i() {
        com.oppo.camera.ui.preview.d dVar = this.q;
        if (dVar != null) {
            return dVar.E();
        }
        return null;
    }

    public Rect aY() {
        com.oppo.camera.ui.preview.d dVar = this.q;
        if (dVar != null) {
            return dVar.M();
        }
        return null;
    }

    public void a(long j2) {
        com.oppo.camera.ui.preview.d dVar = this.q;
        if (dVar != null) {
            dVar.a(j2);
        }
    }

    public long aZ() {
        com.oppo.camera.ui.preview.d dVar = this.q;
        if (dVar != null) {
            return dVar.h();
        }
        return 0;
    }

    public void a(View view, String str, int i2, boolean z2) {
        ConcurrentHashMap concurrentHashMap = this.ad.get(str);
        if (concurrentHashMap == null) {
            concurrentHashMap = new ConcurrentHashMap();
        }
        View view2 = (View) concurrentHashMap.get(Integer.valueOf(i2));
        if (z2 && view2 != null) {
            this.I.removeView(view2);
            view2 = null;
        }
        if (view2 == null && this.I.indexOfChild(view) == -1) {
            view.setTag(R.id.tag_name_specific_mode_view_type, Integer.valueOf(i2));
            this.I.addView(view);
        }
        view.clearAnimation();
        concurrentHashMap.put(Integer.valueOf(i2), view);
        this.ad.put(str, concurrentHashMap);
    }

    public void b(String str, boolean z2) {
        for (String next : this.ad.keySet()) {
            a(this.ad.get(next), TextUtils.equals(next, str), z2, next);
        }
    }

    public void a(ConcurrentHashMap<Integer, View> concurrentHashMap, boolean z2, boolean z3, String str) {
        ConcurrentHashMap<Integer, View> concurrentHashMap2 = concurrentHashMap;
        boolean z4 = z2;
        if (concurrentHashMap2 != null) {
            for (View next : concurrentHashMap.values()) {
                if (next == null) {
                    String str2 = str;
                } else if (z3) {
                    next.clearAnimation();
                    final Object tag = next.getTag(R.id.tag_name_specific_mode_view_type);
                    if (!z4 && tag != null) {
                        concurrentHashMap2.remove(tag);
                    }
                    int i2 = 300;
                    if (!z4) {
                        i2 = 100;
                    }
                    int i3 = i2;
                    final View view = next;
                    final boolean z5 = z2;
                    final String str3 = str;
                    Util.a(next, z4 ? 0 : 8, (Animation.AnimationListener) new Animation.AnimationListener() {
                        public void onAnimationRepeat(Animation animation) {
                        }

                        public void onAnimationStart(Animation animation) {
                            View view = view;
                            if (view != null) {
                                view.setVisibility(z5 ? 0 : 8);
                            }
                            if (z5) {
                                g.this.A(true);
                            }
                        }

                        public void onAnimationEnd(Animation animation) {
                            if (g.this.x != null) {
                                g.this.x.a(str3, tag, z5, true);
                            }
                        }
                    }, (long) i3, 0, AnimationUtils.loadInterpolator(next.getContext(), R.anim.specific_view_alpha_interpolator));
                } else {
                    Object tag2 = next.getTag(R.id.tag_name_specific_mode_view_type);
                    if (!z4) {
                        next.setVisibility(8);
                        if (tag2 != null) {
                            concurrentHashMap2.remove(tag2);
                        }
                    } else {
                        next.setVisibility(0);
                    }
                    this.x.a(str, tag2, z4, true);
                }
            }
        }
    }

    public boolean ba() {
        return com.oppo.camera.ui.menu.f.a();
    }

    public void v(int i2) {
        this.y = i2;
        com.oppo.camera.ui.control.b bVar = this.p;
        if (bVar != null) {
            bVar.b(this.y);
        }
        p pVar = this.v;
        if (pVar != null) {
            pVar.e(this.y);
        }
        com.oppo.camera.ui.menu.setting.f fVar = this.w;
        if (fVar != null) {
            fVar.e(this.y);
        }
        com.oppo.camera.ui.preview.d dVar = this.q;
        if (dVar != null) {
            dVar.b(this.y);
        }
    }

    public void a(com.oppo.camera.ui.control.a aVar) {
        com.oppo.camera.ui.control.b bVar = this.p;
        if (bVar != null) {
            bVar.a(aVar);
        }
    }

    public void a(e.c cVar) {
        com.oppo.camera.ui.preview.d dVar = this.q;
        if (dVar != null) {
            dVar.a(cVar);
        }
    }

    public void a(com.oppo.camera.ui.control.f fVar) {
        com.oppo.camera.ui.control.b bVar = this.p;
        if (bVar != null) {
            bVar.a(fVar);
        }
    }

    public void R(boolean z2) {
        com.oppo.camera.ui.preview.d dVar = this.q;
        if (dVar != null) {
            dVar.d(z2);
        }
    }

    public void a(Rect rect, Size size) {
        com.oppo.camera.ui.preview.d dVar = this.q;
        if (dVar != null) {
            dVar.a(rect, size);
        }
    }

    public void a(Rect rect, Rect rect2, Size size) {
        com.oppo.camera.ui.preview.d dVar = this.q;
        if (dVar != null) {
            dVar.a(rect, rect2, size);
        }
    }

    public void a(float f) {
        com.oppo.camera.ui.preview.d dVar = this.q;
        if (dVar != null) {
            dVar.a(f);
        }
    }

    public void b(float f) {
        com.oppo.camera.ui.preview.d dVar = this.q;
        if (dVar != null) {
            dVar.b(f);
        }
    }

    public void c(float f) {
        com.oppo.camera.ui.preview.d dVar = this.q;
        if (dVar != null) {
            dVar.c(f);
        }
    }

    public void a(Face[] faceArr, int[] iArr) {
        com.oppo.camera.ui.preview.d dVar;
        if (!cH() && (dVar = this.q) != null) {
            dVar.a(faceArr, iArr);
        }
    }

    public void b(int[] iArr) {
        com.oppo.camera.ui.preview.d dVar;
        if (!cH() && (dVar = this.q) != null) {
            dVar.a(iArr);
        }
    }

    public void S(boolean z2) {
        com.oppo.camera.ui.preview.d dVar = this.q;
        if (dVar != null) {
            dVar.h(z2);
        }
    }

    public void w(int i2) {
        com.oppo.camera.ui.preview.d dVar = this.q;
        if (dVar != null) {
            dVar.e(i2);
        }
    }

    public void x(int i2) {
        this.z = i2;
        com.oppo.camera.ui.control.b bVar = this.p;
        if (bVar != null) {
            bVar.c(this.z);
        }
        p pVar = this.v;
        if (pVar != null) {
            pVar.f(this.z);
        }
        com.oppo.camera.ui.menu.setting.f fVar = this.w;
        if (fVar != null) {
            fVar.f(this.z);
        }
        com.oppo.camera.ui.preview.d dVar = this.q;
        if (dVar != null) {
            dVar.c(this.z);
        }
        int dp = dp();
        v vVar = this.t;
        if (!(vVar == null || dp == vVar.b())) {
            this.t.a(m19do(), dp, cU());
        }
        CameraScreenHintView cameraScreenHintView = this.K;
        if (cameraScreenHintView != null) {
            cameraScreenHintView.setOrientation(dp);
        }
        CameraScreenHintView cameraScreenHintView2 = this.J;
        if (cameraScreenHintView2 != null) {
            cameraScreenHintView2.setOrientation(dp);
        }
        CameraScreenHintView cameraScreenHintView3 = this.L;
        if (cameraScreenHintView3 != null) {
            cameraScreenHintView3.setOrientation(this.z);
        }
        CameraScreenHintView cameraScreenHintView4 = this.M;
        if (cameraScreenHintView4 != null) {
            cameraScreenHintView4.setOrientation(i2);
        }
        CameraScreenHintView cameraScreenHintView5 = this.P;
        if (cameraScreenHintView5 != null) {
            cameraScreenHintView5.setOrientation(this.z);
        }
        CameraScreenHintView cameraScreenHintView6 = this.S;
        if (cameraScreenHintView6 != null) {
            cameraScreenHintView6.setOrientation(this.z);
        }
        com.oppo.camera.ui.preview.a aVar = this.af;
        if (aVar != null) {
            aVar.d(this.z);
        }
        RotateImageView rotateImageView = this.aj;
        if (rotateImageView != null) {
            rotateImageView.a(this.z, true);
        }
        com.oppo.camera.ui.modepanel.f fVar2 = this.as;
        if (fVar2 != null) {
            fVar2.f(this.z);
        }
        com.oppo.camera.ui.a.a aVar2 = this.o;
        if (aVar2 != null) {
            aVar2.a(this.z);
        }
        com.oppo.camera.ui.widget.c cVar = this.ax;
        if (cVar != null) {
            cVar.a(this.z, true);
        }
        com.oppo.camera.doubleexposure.g gVar = this.aE;
        if (gVar != null) {
            gVar.a(this.z);
        }
    }

    public void a(final boolean z2, final boolean z3) {
        Activity activity = this.i;
        if (activity != null) {
            activity.runOnUiThread(new Runnable() {
                public void run() {
                    if (g.this.p != null) {
                        g.this.p.f(z2, z3);
                    }
                }
            });
        }
    }

    public void b(boolean z2) {
        if (this.N == null) {
            return;
        }
        if (!z2 || this.x.g("pref_filter_process_key")) {
            this.N.setEnabled(z2);
            this.N.setClickable(z2);
        }
    }

    public void t(boolean z2) {
        if (this.aj == null) {
            return;
        }
        if (z2 && !this.x.g(CameraFunction.FACE_BEAUTY_PROCESS)) {
            return;
        }
        if (!z2 || !dO()) {
            com.oppo.camera.e.a("CameraUIManager", "enableFaceBeautyMenu, enable: " + z2);
            this.aj.a(z2, false);
            this.aj.setClickable(z2);
        }
    }

    public void bb() {
        com.oppo.camera.ui.menu.setting.t tVar = this.ai;
        if (tVar != null) {
            tVar.j();
        }
    }

    public void bc() {
        com.oppo.camera.ui.menu.setting.t tVar = this.ai;
        if (tVar != null) {
            tVar.k();
        }
    }

    public int bd() {
        com.oppo.camera.ui.menu.levelcontrol.e eVar = this.N;
        if (eVar != null) {
            return eVar.o();
        }
        return 0;
    }

    public boolean s() {
        com.oppo.camera.ui.menu.levelcontrol.e eVar = this.N;
        if (eVar != null) {
            return eVar.b();
        }
        return false;
    }

    public boolean t() {
        com.oppo.camera.ui.control.b bVar = this.p;
        if (bVar == null || this.N == null || this.x == null || this.ao == null || this.O == null) {
            return false;
        }
        if (bVar.a() || this.N.g() || this.x.l() || this.ao.f() || this.O.g()) {
            return true;
        }
        return false;
    }

    public void u() {
        k kVar = this.Q;
        if (kVar != null) {
            kVar.a();
        }
    }

    public boolean be() {
        com.oppo.camera.ui.control.b bVar = this.p;
        if (bVar != null) {
            return bVar.t();
        }
        return false;
    }

    public void b(boolean z2, boolean z3) {
        com.oppo.camera.ui.control.b bVar = this.p;
        if (bVar != null) {
            bVar.g(z2, z3);
        }
    }

    public void c(boolean z2, boolean z3) {
        com.oppo.camera.ui.control.b bVar = this.p;
        if (bVar != null) {
            bVar.h(z2, z3);
            this.p.k(z2);
        }
    }

    public void e(boolean z2, boolean z3) {
        p pVar = this.v;
        if (pVar != null) {
            pVar.a(z2, z3);
        }
        com.oppo.camera.ui.menu.setting.f fVar = this.w;
        if (fVar != null) {
            fVar.a(z2, z3);
        }
    }

    public boolean bf() {
        p pVar = this.v;
        if (pVar != null) {
            return pVar.z();
        }
        com.oppo.camera.ui.menu.setting.f fVar = this.w;
        if (fVar != null) {
            return fVar.z();
        }
        return false;
    }

    public int bg() {
        return Util.t();
    }

    public int k() {
        com.oppo.camera.ui.control.b bVar = this.p;
        if (bVar != null) {
            return bVar.Q();
        }
        return 0;
    }

    public void d(boolean z2, boolean z3) {
        com.oppo.camera.e.a("CameraUIManager", "enableAllCameraView, enable: " + z2 + ", ashed: " + z3);
        a(z2, z3);
        b(z2, z3);
        c(z2, z3);
        e(z2, z3);
        b(z2);
        t(z2);
        G(z2);
        av(z2);
        aj(z2);
        aw(z2);
    }

    private void av(boolean z2) {
        com.oppo.camera.ui.widget.c cVar = this.ax;
        if (cVar != null) {
            cVar.setEnabled(z2);
        }
    }

    private void aw(boolean z2) {
        com.oppo.camera.ui.preview.d dVar = this.q;
        if (dVar != null) {
            dVar.j(z2);
        }
    }

    public void l(boolean z2) {
        com.oppo.camera.ui.control.b bVar = this.p;
        if (bVar != null) {
            bVar.g(z2);
        }
    }

    public void f(boolean z2, boolean z3) {
        com.oppo.camera.ui.control.b bVar = this.p;
        if (bVar != null) {
            bVar.e(z3, false);
            this.p.h();
        }
    }

    public void e(int i2) {
        com.oppo.camera.ui.control.b bVar = this.p;
        if (bVar != null) {
            bVar.e(i2);
        }
    }

    public void f(int i2) {
        com.oppo.camera.ui.control.b bVar = this.p;
        if (bVar != null) {
            bVar.f(i2);
        }
    }

    public void g(int i2) {
        com.oppo.camera.ui.control.b bVar = this.p;
        if (bVar != null) {
            bVar.h(i2);
        }
    }

    public void h(int i2) {
        com.oppo.camera.ui.control.b bVar = this.p;
        if (bVar != null) {
            bVar.i(i2);
        }
    }

    public void b(int i2, boolean z2) {
        com.oppo.camera.ui.control.b bVar;
        if (3 != this.y && (bVar = this.p) != null) {
            bVar.a(i2, z2);
        }
    }

    public void j(int i2) {
        p pVar;
        if (3 != this.y && (pVar = this.v) != null) {
            pVar.d(i2);
            if (i2 != 0) {
                W(false);
            } else if (!this.l) {
                this.w.i();
            }
        }
    }

    public boolean ac() {
        com.oppo.camera.ui.preview.d dVar = this.q;
        if (dVar != null) {
            return dVar.m();
        }
        return false;
    }

    public String ad() {
        com.oppo.camera.ui.preview.d dVar = this.q;
        return dVar != null ? dVar.n() : "";
    }

    public void b(String str, boolean z2, boolean z3) {
        p pVar = this.v;
        if (pVar != null) {
            pVar.a(str, z2, z3);
        }
        com.oppo.camera.ui.menu.setting.f fVar = this.w;
        if (fVar != null) {
            fVar.a(str, z2, z3);
        }
    }

    public void d(float f) {
        p pVar = this.v;
        if (pVar != null) {
            pVar.b(f);
        }
        com.oppo.camera.ui.menu.setting.f fVar = this.w;
        if (fVar != null) {
            fVar.b(f);
        }
    }

    public void a(int i2, boolean z2, boolean z3) {
        com.oppo.camera.e.a("CameraUIManager", "afterOpenCameraUpdateUI");
        p pVar = this.v;
        if (pVar != null) {
            pVar.a(i2, false, !this.j && z2, z3);
            if (this.j) {
                this.v.a(false, true);
                this.v.c(4);
            }
        }
        com.oppo.camera.ui.menu.setting.f fVar = this.w;
        if (fVar != null) {
            fVar.a(i2, false, !this.j && z2, z3);
            if (this.j) {
                this.w.a(false, true);
                this.w.c(4);
            }
        }
    }

    public void bh() {
        com.oppo.camera.e.a("CameraUIManager", "afterEnterCameraStartPreviewDone");
        if (!this.j) {
            e(true, false);
        }
    }

    public void a(Bitmap bitmap, e.a aVar, com.oppo.camera.ui.control.e eVar, int i2) {
        com.oppo.camera.ui.a.a aVar2 = this.o;
        if (aVar2 != null) {
            aVar2.a(bitmap, aVar, eVar, i2);
        }
    }

    public void a(com.oppo.camera.ui.control.e eVar) {
        a(eVar, true);
    }

    public void a(com.oppo.camera.ui.control.e eVar, boolean z2) {
        com.oppo.camera.ui.control.b bVar = this.p;
        if (bVar != null) {
            bVar.a(eVar, z2);
        }
    }

    public void a(b.C0100b bVar) {
        com.oppo.camera.ui.control.b bVar2 = this.p;
        if (bVar2 != null) {
            bVar2.a((e.c) null, true, bVar);
        }
    }

    public void a(com.oppo.camera.ui.control.e eVar, int i2) {
        com.oppo.camera.ui.control.b bVar = this.p;
        if (bVar != null) {
            bVar.a(eVar, i2);
        }
    }

    public void c(boolean z2) {
        com.oppo.camera.e.a("CameraUIManager", "updateThumbnail, anim: " + z2);
        a((e.c) null, z2);
    }

    public void a(e.c cVar, boolean z2) {
        com.oppo.camera.e.a("CameraUIManager", "updateThumbnail");
        com.oppo.camera.ui.control.b bVar = this.p;
        if (bVar != null) {
            bVar.a(cVar, z2);
        }
    }

    public void bi() {
        com.oppo.camera.ui.control.b bVar = this.p;
        if (bVar != null) {
            bVar.N();
        }
    }

    public boolean bj() {
        com.oppo.camera.ui.control.b bVar = this.p;
        if (bVar != null) {
            return bVar.O();
        }
        return false;
    }

    public void i(boolean z2) {
        com.oppo.camera.ui.preview.d dVar = this.q;
        if (dVar != null) {
            dVar.a(z2);
            this.q.b(z2);
        }
    }

    public void j(boolean z2) {
        com.oppo.camera.ui.preview.d dVar = this.q;
        if (dVar != null) {
            dVar.f(z2);
        }
    }

    public void k(boolean z2) {
        com.oppo.camera.ui.preview.d dVar = this.q;
        if (dVar != null) {
            dVar.a(z2);
        }
    }

    public boolean b(Size size) {
        com.oppo.camera.ui.preview.d dVar = this.q;
        if (dVar != null) {
            return dVar.a(size);
        }
        return false;
    }

    public void c(Size size) {
        com.oppo.camera.e.a("CameraUIManager", "notifyEffectMenuPreviewSizeChanged, previewSize: " + size.getWidth() + "x" + size.getHeight());
        com.oppo.camera.ui.menu.levelcontrol.e eVar = this.N;
        if (eVar != null) {
            int textureWidth = eVar.getTextureWidth();
            int textureHeight = this.N.getTextureHeight();
            int width = size.getWidth();
            int height = size.getHeight();
            if (this.B % 180 == 0) {
                int i2 = width;
                width = height;
                height = i2;
            }
            if (textureWidth != height || textureHeight != width) {
                this.N.b(height, width);
            }
        }
    }

    public void T(boolean z2) {
        this.p.n(z2);
    }

    public void y(int i2) {
        this.A = i2;
        p pVar = this.v;
        if (pVar != null) {
            pVar.b(this.A);
        }
        com.oppo.camera.ui.menu.setting.f fVar = this.w;
        if (fVar != null) {
            fVar.b(this.A);
        }
        com.oppo.camera.ui.control.b bVar = this.p;
        if (bVar != null) {
            bVar.a(this.A);
        }
    }

    public void a(Size size, Size size2, boolean z2) {
        com.oppo.camera.ui.preview.d dVar = this.q;
        if (dVar != null) {
            dVar.a(size, z2);
        }
        float[] fArr = {0.0f, 0.0f, 0.0f, 0.0f};
        int b2 = Util.b(size.getWidth(), size.getHeight());
        p pVar = this.v;
        if (pVar != null) {
            pVar.g(5 == b2);
        }
        if (Util.b(size.getWidth(), size.getHeight()) == 2) {
            fArr[0] = 0.0f;
        }
        c(size2);
    }

    public void q() {
        com.oppo.camera.ui.control.b bVar = this.p;
        if (bVar != null) {
            bVar.M();
        }
    }

    public void d(int i2, boolean z2) {
        com.oppo.camera.e.a("CameraUIManager", "previewType: " + i2 + ", needControlAnimation: " + z2);
        if (this.p != null && !G() && !cU()) {
            this.p.b(i2, z2);
        }
    }

    public void U(boolean z2) {
        com.oppo.camera.ui.preview.d dVar = this.q;
        if (dVar != null) {
            dVar.g(z2);
        }
    }

    public void bk() {
        com.oppo.camera.ui.preview.d dVar = this.q;
        if (dVar != null) {
            dVar.N();
        }
    }

    public void bl() {
        com.oppo.camera.ui.preview.d dVar = this.q;
        if (dVar != null) {
            dVar.O();
        }
    }

    public void bm() {
        com.oppo.camera.ui.preview.d dVar = this.q;
        if (dVar != null) {
            dVar.P();
        }
    }

    public void a(Float f, int i2, boolean z2) {
        if (this.t == null) {
            this.t = new v(this.i);
        }
        boolean z3 = false;
        this.t.d(this.J != null && cU() && this.J.f());
        int dp = dp();
        v vVar = this.t;
        if (vVar != null) {
            vVar.a(i2, m19do(), dp, z2, cU());
            this.t.f();
        }
        Z(true);
        aa(true);
        bU();
        CameraScreenHintView cameraScreenHintView = this.J;
        if (cameraScreenHintView != null && !cameraScreenHintView.f() && !this.J.g()) {
            z3 = true;
        }
        ax(z3);
    }

    public void p() {
        long currentTimeMillis = System.currentTimeMillis();
        if (!this.at && currentTimeMillis - this.H >= 3000) {
            if (!k("key_support_show_low_ambient_light_hint") || currentTimeMillis - this.H <= 60000) {
                a((int) R.string.camera_slow_video_tips, -1, true, false, false);
                this.at = true;
            }
        }
    }

    public void a(long j2, long j3, boolean z2, boolean z3, long j4) {
        v vVar = this.t;
        if (vVar != null) {
            vVar.a(j2, j3, z2, z3, j4);
        }
    }

    public void e(boolean z2) {
        v vVar = this.t;
        if (vVar != null) {
            vVar.b(z2);
        }
    }

    public void f(boolean z2) {
        v vVar = this.t;
        if (vVar != null) {
            vVar.a(z2);
        }
    }

    public void l(int i2) {
        if (this.u == null) {
            this.u = new com.oppo.camera.ui.preview.f(this.i, i2);
        }
        com.oppo.camera.ui.preview.f fVar = this.u;
        if (fVar != null) {
            fVar.a(i2, m19do(), false, cU());
        }
    }

    public void g(boolean z2) {
        com.oppo.camera.ui.preview.f fVar = this.u;
        if (fVar != null) {
            fVar.a(z2, cU());
        }
    }

    public void a(long j2, boolean z2) {
        com.oppo.camera.ui.preview.f fVar = this.u;
        if (fVar != null) {
            fVar.a(j2, 0, z2);
        }
    }

    public void V(boolean z2) {
        com.oppo.camera.e.a("CameraUIManager", "startVideoRecording");
        p pVar = this.v;
        if (pVar != null) {
            pVar.u();
        }
        com.oppo.camera.ui.preview.d dVar = this.q;
        if (dVar != null) {
            dVar.Q();
            this.q.e(true);
        }
        com.oppo.camera.ui.control.b bVar = this.p;
        if (bVar != null) {
            bVar.m(z2);
        }
        i(k("pref_camera_assistant_line_key"));
        com.oppo.camera.ui.control.b bVar2 = this.p;
        if (bVar2 != null) {
            bVar2.ab();
        }
        D(true);
    }

    public void bn() {
        com.oppo.camera.e.a("CameraUIManager", "beforeStopSlowVideoRecording");
        v vVar = this.t;
        if (vVar != null) {
            vVar.a(true);
        }
        com.oppo.camera.ui.control.b bVar = this.p;
        if (bVar != null) {
            bVar.j(false, false);
        }
        if (this.x.g("key_support_share_edit_thumb")) {
            ae();
        }
    }

    public void bo() {
        com.oppo.camera.e.a("CameraUIManager", "afterStopSlowVideoRecording");
        p pVar = this.v;
        if (pVar != null) {
            pVar.v();
        }
        com.oppo.camera.ui.preview.d dVar = this.q;
        if (dVar != null) {
            dVar.e(false);
        }
        com.oppo.camera.ui.menu.levelcontrol.a aVar = this.O;
        if (aVar != null) {
            aVar.e();
        }
        if (ba()) {
            bC();
        }
        k(true);
    }

    public void j(boolean z2, boolean z3) {
        com.oppo.camera.e.a("CameraUIManager", "stopVideoRecording");
        boolean z4 = false;
        Z(false);
        aa(false);
        bU();
        dl();
        p pVar = this.v;
        if (pVar != null) {
            pVar.v();
        }
        com.oppo.camera.ui.preview.d dVar = this.q;
        if (dVar != null) {
            dVar.e(false);
        }
        v vVar = this.t;
        if (vVar != null) {
            vVar.a(true, cU());
            this.t.a();
            CameraScreenHintView cameraScreenHintView = this.J;
            if (cameraScreenHintView != null && !cameraScreenHintView.f() && !this.J.g()) {
                z4 = true;
            }
            ax(z4);
        }
        com.oppo.camera.ui.control.b bVar = this.p;
        if (bVar != null) {
            bVar.j(z2, z3);
        }
        com.oppo.camera.ui.menu.levelcontrol.a aVar = this.O;
        if (aVar != null) {
            aVar.e();
        }
        if (ba()) {
            bC();
        }
        if (this.x.g("key_support_share_edit_thumb")) {
            ae();
        }
        i(true);
    }

    private void dl() {
        f fVar = this.x;
        if (fVar != null && fVar.aA()) {
            r(true);
            com.oppo.camera.ui.menu.a.g gVar = this.ao;
            if (gVar != null && gVar.d()) {
                s(true);
                this.ao.d(false);
            }
        }
    }

    public boolean bp() {
        com.oppo.camera.ui.menu.levelcontrol.a aVar = this.O;
        if (aVar != null) {
            return aVar.f();
        }
        return false;
    }

    public void bq() {
        if (!this.j) {
            this.q.J();
        }
    }

    public void br() {
        com.oppo.camera.e.a("CameraUIManager", "hidePostCaptureAlert");
        this.k = false;
        com.oppo.camera.ui.preview.d dVar = this.q;
        if (dVar != null) {
            dVar.y();
            cC();
        }
        p(true);
        r(true);
        p pVar = this.v;
        if (pVar != null) {
            pVar.d(0);
            this.v.a(true, false);
        }
        com.oppo.camera.ui.menu.setting.f fVar = this.w;
        if (fVar != null) {
            fVar.i();
        }
        if (this.p != null) {
            if (Util.c(this.A)) {
                this.p.a(0, true);
            }
            this.p.F();
        }
        a(0);
    }

    public void a(Bitmap bitmap) {
        com.oppo.camera.e.a("CameraUIManager", "showPostCaptureAlert");
        this.k = true;
        bS();
        if (this.y == 2) {
            if (s()) {
                q(false);
            } else {
                o(false);
            }
            a(true, true, false, false);
            d(false, false, false);
            p pVar = this.v;
            if (pVar != null) {
                pVar.a(false, true);
                if (Util.b(this.A)) {
                    this.v.d(4);
                } else {
                    this.v.c(0.0f);
                }
            }
            W(false);
            a(4);
            if (this.p != null) {
                if (Util.c(this.A)) {
                    this.p.a(4, true);
                }
                this.p.E();
            }
            com.oppo.camera.ui.preview.d dVar = this.q;
            if (dVar != null) {
                dVar.a(bitmap);
                CameraScreenHintView cameraScreenHintView = this.K;
                if (cameraScreenHintView != null) {
                    cameraScreenHintView.a(false, false);
                }
            }
            a(true, false, false);
            n(false);
            cw();
        }
    }

    public void c(com.oppo.camera.ui.control.c cVar, boolean z2) {
        this.j = false;
        com.oppo.camera.ui.control.b bVar = this.p;
        if (bVar != null) {
            bVar.H();
            this.p.b(cVar, z2);
            if (this.y != 3 && !this.l) {
                this.p.c(false);
            }
        }
        p pVar = this.v;
        if (pVar != null) {
            pVar.a(true, false);
            this.v.d(0);
        }
    }

    public void bs() {
        com.oppo.camera.e.a("CameraUIManager", "hideVideoAlert");
        this.j = false;
        com.oppo.camera.ui.preview.d dVar = this.q;
        if (dVar != null) {
            dVar.A();
        }
        com.oppo.camera.ui.control.b bVar = this.p;
        if (bVar != null) {
            bVar.H();
        }
        p pVar = this.v;
        if (pVar != null) {
            pVar.a(true, false);
            this.v.d(0);
        }
        com.oppo.camera.ui.menu.setting.f fVar = this.w;
        if (fVar != null) {
            fVar.a(true, false);
            this.w.d(0);
        }
    }

    public void b(Bitmap bitmap) {
        com.oppo.camera.e.a("CameraUIManager", "showVideoAlert");
        this.j = true;
        com.oppo.camera.ui.preview.d dVar = this.q;
        if (dVar != null) {
            dVar.b(bitmap);
        }
        com.oppo.camera.ui.control.b bVar = this.p;
        if (bVar != null) {
            bVar.G();
        }
        p pVar = this.v;
        if (pVar != null) {
            pVar.a(false, true);
            this.v.d(4);
            if (this.i.getResources().getDimensionPixelSize(R.dimen.third_video_preview_margin_top) > 0) {
                this.v.c(!Util.F(), true);
            }
        }
        com.oppo.camera.ui.menu.setting.f fVar = this.w;
        if (fVar != null) {
            fVar.a(false, true);
            this.w.a(4);
        }
        a(true, true, false);
    }

    public void bt() {
        com.oppo.camera.ui.preview.d dVar = this.q;
        if (dVar != null) {
            dVar.L();
        }
    }

    public boolean f(int i2, int i3) {
        com.oppo.camera.ui.control.b bVar = this.p;
        if (bVar == null || !bVar.aa()) {
            return false;
        }
        this.p.ab();
        return true;
    }

    public boolean g(int i2, int i3) {
        com.oppo.camera.e.a("CameraUIManager", "onSingleTapUp, x: " + i2 + ", y: " + i3);
        com.oppo.camera.ui.modepanel.f fVar = this.as;
        if (fVar != null && fVar.d()) {
            return true;
        }
        com.oppo.camera.ui.menu.setting.t tVar = this.ai;
        if (tVar != null && tVar.a(i2, i3)) {
            return true;
        }
        if (ak()) {
            al();
            return true;
        }
        com.oppo.camera.ui.menu.a.g gVar = this.ao;
        if (gVar == null || !gVar.h()) {
            com.oppo.camera.ui.menu.setting.f fVar2 = this.w;
            if (fVar2 == null || !fVar2.x()) {
                com.oppo.camera.ui.control.b bVar = this.p;
                if (bVar == null || !bVar.aa()) {
                    return false;
                }
                this.p.ab();
                return true;
            }
            this.r.edit().putString("pref_subsetting_key", "off").apply();
            f("pref_subsetting_key");
            return true;
        }
        if (!this.ao.f()) {
            b(true, true, false);
        }
        return true;
    }

    public void h() {
        com.oppo.camera.ui.preview.d dVar = this.q;
        if (dVar != null) {
            dVar.G();
        }
    }

    public void bu() {
        com.oppo.camera.ui.preview.d dVar = this.q;
        if (dVar != null) {
            dVar.H();
        }
    }

    public boolean bv() {
        f fVar = this.x;
        if (fVar != null) {
            return fVar.p();
        }
        return false;
    }

    public void bw() {
        f fVar = this.x;
        if (fVar != null) {
            fVar.f();
        }
    }

    public void bx() {
        com.oppo.camera.ui.menu.levelcontrol.e eVar = this.N;
        if (eVar != null && eVar.b() && this.x.g("pref_filter_process_key") && !this.x.b() && !this.k) {
            this.N.l();
        }
    }

    public void by() {
        f fVar = this.x;
        if (fVar != null) {
            fVar.q();
        }
    }

    public void bz() {
        f fVar = this.x;
        if (fVar != null) {
            fVar.r();
        }
    }

    public int bA() {
        f fVar = this.x;
        if (fVar != null) {
            return fVar.s();
        }
        return 0;
    }

    public int bB() {
        f fVar = this.x;
        if (fVar != null) {
            return fVar.t();
        }
        return 0;
    }

    public boolean k(String str) {
        f fVar = this.x;
        if (fVar != null) {
            return fVar.g(str);
        }
        return false;
    }

    public void bC() {
        if (com.oppo.camera.ui.menu.f.a()) {
            com.oppo.camera.ui.menu.f.d();
        }
    }

    public void W(boolean z2) {
        com.oppo.camera.ui.menu.setting.f fVar = this.w;
        if (fVar != null) {
            fVar.b(z2);
        }
    }

    public boolean l(String str) {
        p pVar = this.v;
        if (pVar != null) {
            return pVar.b(str);
        }
        return false;
    }

    public void a(String str, String str2) {
        String b2 = com.oppo.camera.entry.b.b(str, this.y);
        if (com.oppo.camera.ui.menu.f.a()) {
            com.oppo.camera.ui.menu.f.d();
        }
        p pVar = this.v;
        if (pVar != null) {
            pVar.a(b2, str2);
        }
        com.oppo.camera.ui.menu.setting.f fVar = this.w;
        if (fVar != null) {
            fVar.a(b2, str2);
        }
    }

    public void b(String str, String str2) {
        String b2 = com.oppo.camera.entry.b.b(str, this.y);
        p pVar = this.v;
        if (pVar != null) {
            pVar.b(b2, str2);
        }
        com.oppo.camera.ui.menu.setting.f fVar = this.w;
        if (fVar != null) {
            fVar.b(b2, str2);
        }
    }

    public void a(String str, String... strArr) {
        p pVar = this.v;
        if (pVar != null) {
            pVar.a(str, strArr);
        }
        com.oppo.camera.ui.menu.setting.f fVar = this.w;
        if (fVar != null) {
            fVar.a(str, strArr);
        }
    }

    public void b(String str, String... strArr) {
        p pVar = this.v;
        if (pVar != null) {
            pVar.b(str, strArr);
        }
        com.oppo.camera.ui.menu.setting.f fVar = this.w;
        if (fVar != null) {
            fVar.b(str, strArr);
        }
    }

    public void d(String str) {
        String b2 = com.oppo.camera.entry.b.b(str, this.y);
        p pVar = this.v;
        if (pVar != null) {
            pVar.c(b2);
        }
        com.oppo.camera.ui.menu.setting.f fVar = this.w;
        if (fVar != null) {
            fVar.c(b2);
        }
    }

    public void e(String str) {
        String b2 = com.oppo.camera.entry.b.b(str, this.y);
        p pVar = this.v;
        if (pVar != null) {
            pVar.d(b2);
        }
        com.oppo.camera.ui.menu.setting.f fVar = this.w;
        if (fVar != null) {
            fVar.d(b2);
        }
    }

    public void f(String str) {
        String b2 = com.oppo.camera.entry.b.b(str, this.y);
        p pVar = this.v;
        if (pVar != null) {
            pVar.e(b2);
        }
        com.oppo.camera.ui.menu.setting.f fVar = this.w;
        if (fVar != null) {
            fVar.e(b2);
        }
    }

    public void a(String str, int i2) {
        p pVar = this.v;
        if (pVar != null) {
            pVar.b(str, i2);
        }
        com.oppo.camera.ui.menu.setting.f fVar = this.w;
        if (fVar != null) {
            fVar.b(str, i2);
        }
    }

    public void j() {
        p pVar = this.v;
        if (pVar != null) {
            pVar.o();
        }
        com.oppo.camera.ui.menu.setting.f fVar = this.w;
        if (fVar != null) {
            fVar.o();
        }
    }

    public void b(int i2, boolean z2, boolean z3) {
        boolean z4 = true;
        if (this.v != null) {
            if (cU()) {
                this.v.b(0.0f);
            }
            this.v.b(i2, z3, !this.j && !z2, H());
        }
        com.oppo.camera.ui.menu.setting.f fVar = this.w;
        if (fVar != null) {
            if (this.j || z2) {
                z4 = false;
            }
            fVar.b(i2, z3, z4, H());
        }
    }

    public boolean a(MotionEvent motionEvent) {
        if (cF() || b(motionEvent) || d(motionEvent)) {
            return true;
        }
        com.oppo.camera.ui.preview.d dVar = this.q;
        if (dVar == null || !dVar.a(motionEvent)) {
            return false;
        }
        return true;
    }

    private boolean d(MotionEvent motionEvent) {
        com.oppo.camera.k kVar;
        com.oppo.camera.ui.preview.d dVar;
        f fVar = this.x;
        if (fVar == null || !ApsConstant.CAPTURE_MODE_MULTI_VIDEO.equals(fVar.P()) || (kVar = this.r) == null || kVar.getInt("pref_multicamera_type_selected_key", 0) == 0 || (dVar = this.q) == null || dVar.D() == null) {
            return false;
        }
        boolean a2 = com.oppo.camera.gl.b.e.a().a(motionEvent, this.q.D());
        if (a2) {
            if (ak()) {
                com.oppo.camera.e.b("CameraUIManager", "touchMultiVideoSmallSurface, consumed by MultiVideoSmallSurface");
                al();
            }
            if (this.x.aC()) {
                this.x.aB();
            }
            if (1 == motionEvent.getAction()) {
                this.x.m(FocusAimMsgData.KEY_MULTI_VIDEO_DRAG_SCREEN_FOCUS_TYPE);
            }
        }
        return a2;
    }

    public boolean b(MotionEvent motionEvent) {
        if (this.w == null || !J()) {
            return false;
        }
        return this.w.a(motionEvent);
    }

    public void o() {
        com.oppo.camera.ui.preview.d dVar = this.q;
        if (dVar != null) {
            dVar.X();
        }
    }

    public void a(DialogInterface.OnCancelListener onCancelListener) {
        com.oppo.camera.ui.preview.d dVar = this.q;
        if (dVar != null) {
            dVar.a(onCancelListener);
        }
    }

    public String r() {
        com.oppo.camera.ui.preview.d dVar = this.q;
        return dVar != null ? dVar.T() : "";
    }

    public void h(boolean z2) {
        if (this.q != null) {
            com.oppo.camera.l.a aVar = this.aw;
            this.q.a(z2, aVar == null || !aVar.d());
        }
    }

    public void a(int i2, int i3) {
        com.oppo.camera.ui.preview.d dVar = this.q;
        if (dVar != null) {
            dVar.a(i2, i3);
        }
    }

    public void a(k kVar) {
        com.oppo.camera.ui.preview.d dVar = this.q;
        if (dVar != null) {
            dVar.a(kVar);
        }
    }

    public GLRootView a() {
        return this.q.R();
    }

    public ViewGroup b() {
        return this.I;
    }

    public void i(int i2) {
        com.oppo.camera.ui.preview.d dVar = this.q;
        if (dVar != null) {
            dVar.a(i2);
        }
    }

    public void d(boolean z2) {
        com.oppo.camera.ui.preview.d dVar = this.q;
        if (dVar != null) {
            dVar.c(z2);
        }
    }

    public void b(String str, int i2) {
        this.N.c(i2);
        if (k("pref_portrait_new_style_menu")) {
            h("pref_portrait_new_style_menu");
        } else if (k("pref_filter_menu")) {
            h("pref_filter_menu");
        } else if (k("pref_video_filter_menu")) {
            h("pref_video_filter_menu");
        } else if (k("pref_night_filter_menu")) {
            h("pref_night_filter_menu");
        }
    }

    public void a(String str, boolean z2) {
        this.v.c(str, z2);
    }

    public void m(int i2) {
        dw();
    }

    public int Z() {
        p pVar = this.v;
        if (pVar != null) {
            return pVar.B();
        }
        return 0;
    }

    public int aa() {
        com.oppo.camera.ui.control.b bVar = this.p;
        if (bVar != null) {
            return bVar.P();
        }
        return 0;
    }

    public boolean ah() {
        CameraScreenHintView cameraScreenHintView = this.J;
        if (cameraScreenHintView != null) {
            return cameraScreenHintView.f();
        }
        return false;
    }

    public Uri ab() {
        com.oppo.camera.ui.control.b bVar = this.p;
        if (bVar != null) {
            return bVar.q().d();
        }
        return null;
    }

    public void bD() {
        if (!cH() && !cD()) {
            com.oppo.camera.ui.preview.d dVar = this.q;
            if (dVar != null) {
                dVar.s();
            }
            m();
            this.J.setOrientation(dp());
            this.J.a(this.i.getString(R.string.camera_toast_lock_ae_af), false, true, (int) R.drawable.screen_hint_textview_bg, (int) R.color.screen_hint_text_color, cU());
            ax(false);
        }
    }

    public void bE() {
        Activity activity = this.i;
        if (activity != null) {
            activity.runOnUiThread(new Runnable() {
                public void run() {
                    if (g.this.q != null) {
                        g.this.q.t();
                    }
                    if (g.this.J != null) {
                        g.this.J.a((int) R.string.camera_toast_lock_ae_af);
                    }
                }
            });
        }
    }

    public void bF() {
        com.oppo.camera.ui.preview.d dVar = this.q;
        if (dVar != null) {
            dVar.v();
        }
    }

    public void bG() {
        com.oppo.camera.ui.preview.d dVar = this.q;
        if (dVar != null) {
            dVar.w();
        }
    }

    public void bH() {
        com.oppo.camera.ui.menu.a.g gVar = this.ao;
        if (gVar != null) {
            gVar.k();
        }
        com.oppo.camera.ui.preview.d dVar = this.q;
        if (dVar != null) {
            dVar.U();
        }
        if (Util.j()) {
            Util.a(this.i, (int) R.string.camera_camera_error_title);
        }
        com.oppo.camera.l.a aVar = this.aw;
        if (aVar != null) {
            aVar.b(this.i);
        }
    }

    public void a(SharedPreferences sharedPreferences, String str) {
        com.oppo.camera.k kVar;
        f fVar;
        if (!this.l) {
            if ("pref_camera_torch_mode_key".equals(str)) {
                String string = sharedPreferences.getString("pref_camera_torch_mode_key", Util.y(this.i));
                if ("off".equals(string)) {
                    bQ();
                } else {
                    f fVar2 = this.x;
                    if (fVar2 != null && !fVar2.g(CameraFunction.TORCH_SOFT_LIGHT)) {
                        bP();
                    }
                }
                if ("off".equals(string)) {
                    com.oppo.camera.ui.inverse.c.INS.setInverseColor((Context) this.i, false, true);
                    a(s(), this.x.aG());
                } else if ("on".equals(string) && (fVar = this.x) != null && !fVar.g(CameraFunction.TORCH_SOFT_LIGHT)) {
                    com.oppo.camera.ui.inverse.c.INS.setInverseColor((Context) this.i, true, true);
                    a(s(), this.x.aG());
                }
            } else {
                if ("pref_camera_flashmode_key".equals(str) && !sharedPreferences.getString("pref_camera_flashmode_key", "off").equals("off") && sharedPreferences.getString("pref_high_resolution_key", "off").equals("on")) {
                    SharedPreferences.Editor edit = sharedPreferences.edit();
                    edit.putString("pref_high_resolution_key", "off");
                    edit.apply();
                    b("pref_high_resolution_key", "off");
                }
                if ("pref_allow_network_access".equals(str) && (kVar = this.r) != null && this.s != null && kVar.getBoolean("pref_allow_network_access", false)) {
                    this.s.a();
                }
            }
        }
    }

    public void bI() {
        com.oppo.camera.ui.control.b bVar = this.p;
        if (bVar != null) {
            bVar.J();
        }
    }

    public void bJ() {
        com.oppo.camera.ui.control.b bVar = this.p;
        if (bVar != null) {
            bVar.K();
        }
    }

    public void bK() {
        com.oppo.camera.ui.control.b bVar = this.p;
        if (bVar != null) {
            bVar.L();
        }
    }

    public boolean bL() {
        com.oppo.camera.ui.menu.setting.t tVar;
        com.oppo.camera.l.a aVar;
        p pVar = this.v;
        if ((pVar != null && pVar.t()) || (((tVar = this.ai) != null && tVar.o_()) || ((aVar = this.aw) != null && aVar.c()))) {
            return true;
        }
        if (H()) {
            V(-1);
            return true;
        }
        com.oppo.camera.ui.menu.a.g gVar = this.ao;
        if (gVar == null || !gVar.h()) {
            com.oppo.camera.doubleexposure.g gVar2 = this.aE;
            if (gVar2 == null || !gVar2.o()) {
                return false;
            }
            dj();
            return true;
        }
        if (!this.ao.f()) {
            b(true, true, false);
        }
        return true;
    }

    public void m(final String str) {
        Activity activity;
        if (!this.w.x() && !H() && (activity = this.i) != null) {
            activity.runOnUiThread(new Runnable() {
                public void run() {
                    g.this.m();
                    if (g.this.J != null) {
                        g.this.J.a(str, false, true, (int) ApsAdapterConstant.LOG_INTERVAL, false, g.this.k("key_full_screen_center_support"));
                    }
                }
            });
        }
    }

    public void bM() {
        Activity activity;
        if (!this.w.x() && !cD() && (activity = this.i) != null) {
            activity.runOnUiThread(new Runnable() {
                public void run() {
                    g.this.m();
                    if (g.this.J != null) {
                        g.this.J.a(g.this.i.getString(R.string.camera_toast_gesture_take_picture), false, true, R.drawable.screen_hint_textview_bg, R.color.screen_hint_text_color, 5000, false);
                    }
                }
            });
        }
    }

    public void bN() {
        if (this.S == null && this.I != null) {
            this.S = (CameraScreenHintView) this.i.getLayoutInflater().inflate(R.layout.camera_screen_hint, (ViewGroup) null);
            View view = this.R;
            if (view != null) {
                ViewGroup viewGroup = this.I;
                viewGroup.addView(this.S, viewGroup.indexOfChild(view));
            } else {
                this.I.addView(this.S);
            }
        }
        final String string = this.r.getString("pref_camera_photo_ratio_key", this.i.getString(R.string.camera_photo_ratio_default_value));
        CameraScreenHintView cameraScreenHintView = this.J;
        if (cameraScreenHintView != null) {
            cameraScreenHintView.getHintTextView().getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                public void onGlobalLayout() {
                    if (g.this.J != null) {
                        g.this.J.getHintTextView().getViewTreeObserver().removeOnGlobalLayoutListener(this);
                        if ("square".equals(string)) {
                            if (g.this.S != null) {
                                g.this.S.a(g.this.bg(), 0, g.this.J.getHintTextView().getHeight() + g.this.J.getMarginLeft(), false);
                            }
                        } else if (g.this.S != null) {
                            g.this.S.a(g.this.J.getHintTextView().getHeight() + g.this.J.getMarginTop(), 0, g.this.J.getHintTextView().getHeight() + g.this.J.getMarginLeft(), false);
                        }
                    }
                }
            });
        }
        CameraScreenHintView cameraScreenHintView2 = this.S;
        if (cameraScreenHintView2 != null) {
            cameraScreenHintView2.setOrientation(this.z);
            if ("full".equals(string) || "16_9".equals(string)) {
                this.S.setIsGestureHintNeedInverse(true);
            }
            this.S.a((int) R.drawable.gesture_hint_selector, false, true, 5000, false);
        }
    }

    public void a(boolean z2) {
        CameraScreenHintView cameraScreenHintView = this.S;
        if (cameraScreenHintView != null) {
            cameraScreenHintView.b(z2);
        }
    }

    public void X(boolean z2) {
        if (!z2) {
            a(false, false);
        }
        b(false, false);
        e(false, false);
        b(false);
        t(false);
    }

    public void c(String str) {
        com.oppo.camera.ui.control.b bVar = this.p;
        if (bVar != null) {
            bVar.b(str);
        }
    }

    public void a(com.oppo.camera.ui.control.c cVar) {
        com.oppo.camera.ui.control.b bVar = this.p;
        if (bVar != null) {
            bVar.b(cVar);
        }
    }

    public void a(final com.oppo.camera.ui.control.c cVar, final boolean z2) {
        Activity activity = this.i;
        if (activity != null) {
            activity.runOnUiThread(new Runnable() {
                public void run() {
                    if (g.this.p != null) {
                        g.this.p.b(cVar, z2);
                    }
                }
            });
        }
    }

    public void a(int i2, boolean z2) {
        if (i2 == 0) {
            ah(z2);
        } else {
            ai(z2);
        }
    }

    public void a(Animation animation) {
        c cVar = this.ah;
        if (cVar != null) {
            cVar.b(animation);
        }
    }

    public void a(String str) {
        c cVar = this.ah;
        if (cVar != null) {
            cVar.a(str);
        }
    }

    public void a(Size size, Size size2, d.a aVar, int i2, int i3, int i4, boolean z2) {
        com.oppo.camera.ui.preview.d dVar = this.q;
        if (dVar != null) {
            dVar.a(size, size2, aVar, i2, i3, i4, z2);
        }
    }

    public void z(int i2) {
        com.oppo.camera.ui.control.b bVar = this.p;
        if (bVar != null) {
            bVar.j(i2);
        }
    }

    public void a(byte b2, boolean z2) {
        if (this.p != null) {
            if (cU()) {
                b2 = 2;
            }
            this.p.a(b2, z2);
        }
    }

    public void k(boolean z2, boolean z3) {
        if (this.p != null) {
            this.v.c(z2, z3);
        }
    }

    public void Y(boolean z2) {
        p pVar = this.v;
        if (pVar != null) {
            pVar.f(z2);
        }
    }

    public void bO() {
        com.oppo.camera.ui.preview.d dVar = this.q;
        if (dVar != null) {
            dVar.Y();
        }
    }

    public void a(int i2) {
        g(i2, false);
    }

    private void g(int i2, boolean z2) {
        com.oppo.camera.ui.control.b bVar = this.p;
        if (bVar != null && !this.l) {
            if (i2 == 0) {
                bVar.b(true, z2);
            } else {
                bVar.a(true, z2);
            }
        }
    }

    public void a(int i2, long j2, long j3, TimeInterpolator timeInterpolator, Animator.AnimatorListener animatorListener) {
        com.oppo.camera.ui.control.b bVar = this.p;
        if (bVar != null) {
            bVar.a(i2, j2, j3, timeInterpolator, animatorListener);
        }
    }

    public void bP() {
        if (this.I != null && this.R == null) {
            this.i.getLayoutInflater().inflate(R.layout.screen_torch, this.I);
            this.R = this.i.findViewById(R.id.screen_torch);
            this.R.setForceDarkAllowed(false);
            if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_SCREENHOLE)) {
                ScreenHoleView screenHoleView = (ScreenHoleView) this.i.findViewById(R.id.screen_hole_view);
                Rect f = Util.f(Util.ac());
                if (f != null) {
                    com.oppo.camera.e.b("CameraUIManager", "addScreenTorchView, show screen hole view");
                    screenHoleView.setHolePosition(f);
                    screenHoleView.setVisibility(0);
                }
            }
        }
    }

    public void bQ() {
        if (this.I != null && this.R != null) {
            if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_SCREENHOLE)) {
                ScreenHoleView screenHoleView = (ScreenHoleView) this.i.findViewById(R.id.screen_hole_view);
                if (screenHoleView.getVisibility() == 0) {
                    com.oppo.camera.e.b("CameraUIManager", "addScreenTorchView, hide screen hole view");
                    screenHoleView.setVisibility(8);
                }
            }
            this.I.removeView(this.R);
            this.R = null;
        }
    }

    public void bR() {
        com.oppo.camera.e.a("CameraUIManager", "startScreenTorch, mScreenTorchView: " + this.R);
        bP();
        if (this.R != null) {
            int configColorValue = CameraConfig.getConfigColorValue(ConfigDataBase.KEY_FRONT_TORCH_COLOR);
            if (-1 == configColorValue) {
                configColorValue = Color.parseColor("#FFC8C8C8");
            }
            if (this.x.at()) {
                this.I.removeView(this.R);
                ViewGroup viewGroup = this.I;
                viewGroup.addView(this.R, viewGroup.indexOfChild(this.J));
            }
            this.R.setBackgroundColor(configColorValue);
            this.R.setVisibility(0);
            com.oppo.camera.ui.control.b bVar = this.p;
            if (bVar != null) {
                bVar.ad();
            }
        }
        K(false);
        d(false, false, false);
    }

    public void bS() {
        f fVar;
        com.oppo.camera.e.a("CameraUIManager", "stopScreenTorch");
        View view = this.R;
        if (!(view == null || view.getVisibility() == 8)) {
            this.R.setVisibility(8);
            if (this.x.at()) {
                this.I.removeView(this.R);
                this.I.addView(this.R);
            }
        }
        if (this.p != null && (fVar = this.x) != null && fVar.g("key_support_share_edit_thumb") && !this.x.aI()) {
            this.p.ae();
            this.p.af();
        }
    }

    public boolean bT() {
        View view = this.R;
        if (view != null) {
            return view.isShown();
        }
        return false;
    }

    public void a(int i2, int i3, boolean z2, boolean z3, boolean z4) {
        a(i2, i3, z2, z3, z4, false, k("key_full_screen_center_support"), true, ApsAdapterConstant.LOG_INTERVAL);
    }

    public void a(int i2, int i3, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
        a(i2, i3, z2, z3, z4, z5, k("key_full_screen_center_support"), z6, ApsAdapterConstant.LOG_INTERVAL);
    }

    public void a(int i2, final int i3, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, int i4) {
        Activity activity;
        Activity activity2;
        int i5 = i3;
        if (i2 > 0 && (activity2 = this.i) != null) {
            final boolean z8 = z7;
            final int i6 = i2;
            final boolean z9 = z4;
            final boolean z10 = z2;
            final int i7 = i4;
            final boolean z11 = z5;
            final boolean z12 = z6;
            activity2.runOnUiThread(new Runnable() {
                public void run() {
                    if (g.this.dm()) {
                        g.this.m();
                        if (g.this.J != null && g.this.i != null) {
                            if (z8) {
                                g.this.J.a(g.this.i.getString(i6), z9, z10, i7, z11, z12);
                            } else {
                                g.this.J.setChangeHintColor(true);
                                g.this.J.a(g.this.i.getString(i6), z9, z10, z11, z12);
                            }
                            g.this.ax(false);
                        }
                    }
                }
            });
        }
        if (i5 > 0 && (activity = this.i) != null) {
            final boolean z13 = z3;
            final boolean z14 = z6;
            activity.runOnUiThread(new Runnable() {
                public void run() {
                    if (g.this.dm()) {
                        g.this.m();
                        if (g.this.J != null) {
                            g.this.J.a(i3, z13, z14);
                            if (!(g.this.M == null || g.this.I == null)) {
                                int indexOfChild = g.this.I.indexOfChild(g.this.M);
                                com.oppo.camera.e.a("CameraUIManager", "showCameraScreenHintView, indexOfHighFpsHintView: " + indexOfChild);
                                if (indexOfChild >= 0) {
                                    g.this.ab(true);
                                }
                            }
                            g.this.ax(false);
                        }
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public boolean dm() {
        boolean J2 = J();
        boolean cE = cE();
        boolean ap2 = ap();
        boolean dt = dt();
        com.oppo.camera.e.b("CameraUIManager", "showCameraScreenHintView, mbPaused: " + this.l + ", isSubMenuShowing: " + J2 + ", isTiltShiftUIVisibility: " + cE + ", isDrawerSettingGuideAniRunning: " + ap2 + ", shouldShowDrawerSettingGuideAni: " + dt);
        return !this.l && !J2 && !cE && !ap2 && !dt;
    }

    public String e() {
        CameraScreenHintView cameraScreenHintView = this.J;
        return cameraScreenHintView != null ? cameraScreenHintView.getHintTextViewString() : "";
    }

    public int f() {
        CameraScreenHintView cameraScreenHintView = this.J;
        if (cameraScreenHintView != null) {
            return cameraScreenHintView.getHintIconViewResId();
        }
        return 0;
    }

    /* access modifiers changed from: private */
    public void ax(boolean z2) {
        f fVar = this.x;
        if ((fVar == null || fVar.a()) && this.J != null && this.t != null && cn()) {
            v vVar = this.t;
            boolean z3 = false;
            if (vVar == null || !vVar.j()) {
                this.J.setRecordTimeWidth(0);
                return;
            }
            this.J.setRecordTimeWidth(this.t.i());
            v vVar2 = this.t;
            if (this.J.f() && !z2) {
                z3 = true;
            }
            vVar2.d(z3);
            this.t.c(cU());
        }
    }

    public void Z(boolean z2) {
        CameraScreenHintView cameraScreenHintView = this.J;
        if (cameraScreenHintView != null) {
            cameraScreenHintView.setShowRecorderCenter(z2);
        }
    }

    public void aa(boolean z2) {
        CameraScreenHintView cameraScreenHintView = this.J;
        if (cameraScreenHintView != null) {
            cameraScreenHintView.setShowRecorderCenterAlways(z2);
        }
    }

    public void bU() {
        CameraScreenHintView cameraScreenHintView = this.J;
        if (cameraScreenHintView != null) {
            cameraScreenHintView.d();
        }
    }

    public void a(boolean z2, boolean z3, final boolean z4) {
        Activity activity;
        Activity activity2;
        if (z2 && (activity2 = this.i) != null) {
            activity2.runOnUiThread(new Runnable() {
                public void run() {
                    if (g.this.J != null) {
                        g.this.J.c(z4);
                    }
                    g.this.ax(true);
                }
            });
        }
        if (z3 && (activity = this.i) != null) {
            activity.runOnUiThread(new Runnable() {
                public void run() {
                    if (g.this.J != null) {
                        g.this.J.b(z4);
                    }
                    g.this.ax(true);
                }
            });
        }
    }

    public void b(int i2) {
        CameraScreenHintView cameraScreenHintView = this.J;
        if (cameraScreenHintView != null) {
            cameraScreenHintView.a(i2);
        }
    }

    public void bV() {
        b((int) R.string.camera_dark_environment_open_flash_toast);
        b((int) R.string.camera_ai_video_low_ambient_light_hint);
        b((int) R.string.camera_ai_video_back_light_hint);
    }

    public void a(final List<String> list, final long j2) {
        Activity activity;
        if (!this.w.x() && list != null && !list.isEmpty() && (activity = this.i) != null) {
            activity.runOnUiThread(new Runnable() {
                public void run() {
                    g.this.m();
                    if (g.this.J != null) {
                        g.this.J.a((List<String>) list, j2);
                    }
                }
            });
        }
    }

    public void g() {
        CameraScreenHintView cameraScreenHintView = this.J;
        if (cameraScreenHintView != null) {
            cameraScreenHintView.c();
        }
    }

    public void a(final String str, final boolean z2, final boolean z3) {
        Activity activity;
        if (!this.l && !this.w.x() && !cD() && !TextUtils.isEmpty(str) && (activity = this.i) != null) {
            activity.runOnUiThread(new Runnable() {
                public void run() {
                    g.this.m();
                    if (g.this.J != null) {
                        g.this.J.setChangeHintColor(true);
                        g.this.J.a(str, z3, z2, false, false);
                    }
                }
            });
        }
    }

    public void b(String str) {
        CameraScreenHintView cameraScreenHintView = this.J;
        if (cameraScreenHintView != null) {
            cameraScreenHintView.a(str);
        }
    }

    public void c(int i2) {
        CameraScreenHintView cameraScreenHintView = this.K;
        if (cameraScreenHintView != null) {
            cameraScreenHintView.a(i2);
        }
    }

    public void m() {
        if (this.I != null) {
            CameraScreenHintView cameraScreenHintView = this.J;
            if (cameraScreenHintView == null) {
                this.J = (CameraScreenHintView) this.i.getLayoutInflater().inflate(R.layout.camera_screen_hint, (ViewGroup) null);
                this.J.setCameraScreenHintListener(this.aI);
                this.J.setCameraScreenHintInterface(this.aJ);
                this.J.b(U(this.af.b()));
                this.J.addOnLayoutChangeListener(this.aL);
                if (cH()) {
                    aC(true);
                }
                View view = this.R;
                if (view != null) {
                    ViewGroup viewGroup = this.I;
                    viewGroup.addView(this.J, viewGroup.indexOfChild(view));
                } else if (this.af.f() != null) {
                    ViewGroup viewGroup2 = this.I;
                    viewGroup2.addView(this.J, viewGroup2.indexOfChild(this.af.f()));
                } else {
                    this.I.addView(this.J);
                }
                this.J.setOrientation(dp());
                CameraScreenHintView cameraScreenHintView2 = this.J;
                cameraScreenHintView2.a(a(cameraScreenHintView2), 0, dn(), false);
                if (!this.x.g("pref_support_rotate_hint_view")) {
                    this.J.setSupportRotateScreen(2);
                    return;
                }
                return;
            }
            cameraScreenHintView.a(dn(), a(this.J));
        }
    }

    private int dn() {
        CameraScreenHintView cameraScreenHintView;
        if (this.i == null || !cU()) {
            return 0;
        }
        float f = 0.0f;
        if (1.0f - cW() > 0.0f) {
            f = 1.0f - cW();
        }
        int dimensionPixelSize = this.i.getResources().getDimensionPixelSize(R.dimen.movie_hint_preview_margin_right) + (((int) (f * ((float) Util.E()))) / 2);
        if (!cU() || (cameraScreenHintView = this.J) == null) {
            return 0;
        }
        return dimensionPixelSize - cameraScreenHintView.getViewGap();
    }

    /* renamed from: do  reason: not valid java name */
    private int m19do() {
        if (this.i == null || !cU()) {
            return 0;
        }
        float f = 0.0f;
        if (1.0f - cW() > 0.0f) {
            f = 1.0f - cW();
        }
        return this.i.getResources().getDimensionPixelSize(R.dimen.movie_time_view_horizontal_margin) + (((int) (f * ((float) Util.E()))) / 2);
    }

    private int a(CameraScreenHintView cameraScreenHintView) {
        if (this.i == null || cameraScreenHintView == null || cU()) {
            return 0;
        }
        return this.i.getResources().getDimensionPixelSize(R.dimen.video_high_fps_hint_margin_top) - cameraScreenHintView.getViewGap();
    }

    private int dp() {
        if (this.i == null) {
            return 0;
        }
        if (cU()) {
            return 270;
        }
        return this.z;
    }

    public CameraScreenHintView n() {
        return this.J;
    }

    private void dq() {
        int i2;
        int i3;
        if (this.I != null) {
            if (this.L == null) {
                this.L = (CameraScreenHintView) this.i.getLayoutInflater().inflate(R.layout.camera_screen_hint, (ViewGroup) null);
                View view = this.R;
                if (view != null) {
                    ViewGroup viewGroup = this.I;
                    viewGroup.addView(this.L, viewGroup.indexOfChild(view));
                } else {
                    this.I.addView(this.L);
                }
                this.L.setOrientation(this.z);
                if (!this.x.g("pref_support_rotate_hint_view")) {
                    this.L.setSupportRotateScreen(2);
                }
            }
            if (3 == this.y) {
                i3 = ((Util.C() - Util.v()) - ((int) (((double) Util.E()) * 1.5d))) + this.i.getResources().getDimensionPixelSize(R.dimen.camera_hint_margin_bottom_third_party);
                i2 = this.L.getViewGap();
            } else {
                i3 = this.i.getResources().getDimensionPixelSize(R.dimen.down_hint_margin_bottom) + Util.w();
                i2 = this.L.getViewGap();
            }
            this.L.a(0, i3 - i2, 0, true);
            this.L.setChangeHintColor(true);
        }
    }

    public void g(String str) {
        CameraScreenHintView cameraScreenHintView;
        CameraScreenHintView cameraScreenHintView2;
        if (this.L == null) {
            dq();
        }
        if ((str == null || (cameraScreenHintView2 = this.L) == null || !str.equals(cameraScreenHintView2.getHintTextView().getText())) && (cameraScreenHintView = this.L) != null) {
            cameraScreenHintView.a(str, true, false, 0, (int) R.color.screen_hint_text_color);
        }
    }

    public void n(boolean z2) {
        CameraScreenHintView cameraScreenHintView = this.L;
        if (cameraScreenHintView != null && cameraScreenHintView.getHintTextView().getVisibility() == 0) {
            this.L.c(z2);
        }
    }

    public void A() {
        if (this.M != null && this.I != null) {
            com.oppo.camera.e.a("CameraUIManager", "removeHighFpsHintView");
            this.I.removeView(this.M);
            this.M = null;
        }
    }

    public void ab(boolean z2) {
        CameraScreenHintView cameraScreenHintView = this.M;
        if (cameraScreenHintView != null && cameraScreenHintView.getHintTextView().getVisibility() == 0) {
            this.M.c(z2);
        }
    }

    private void dr() {
        ViewGroup viewGroup = this.I;
        if (viewGroup != null) {
            CameraScreenHintView cameraScreenHintView = this.J;
            if (cameraScreenHintView != null) {
                viewGroup.removeView(cameraScreenHintView);
                this.J = null;
                this.af.b(0);
            }
            CameraScreenHintView cameraScreenHintView2 = this.L;
            if (cameraScreenHintView2 != null) {
                this.I.removeView(cameraScreenHintView2);
                this.L = null;
            }
            CameraScreenHintView cameraScreenHintView3 = this.M;
            if (cameraScreenHintView3 != null) {
                this.I.removeView(cameraScreenHintView3);
                this.M = null;
            }
            CameraScreenHintView cameraScreenHintView4 = this.S;
            if (cameraScreenHintView4 != null) {
                this.I.removeView(cameraScreenHintView4);
                this.S = null;
            }
        }
    }

    public void d(int i2) {
        CameraScreenHintView cameraScreenHintView = this.J;
        if (cameraScreenHintView != null) {
            cameraScreenHintView.setSupportRotateScreen(i2);
        }
    }

    public void n(int i2) {
        ds();
        this.aw.a(this.i, i2);
    }

    public void bW() {
        com.oppo.camera.l.a aVar = this.aw;
        if (aVar != null) {
            aVar.a();
        }
    }

    public void ag() {
        ds();
        this.aw.a(this.i);
    }

    private void ds() {
        if (this.aw == null) {
            this.aw = new com.oppo.camera.l.a(this.r, new c.a() {
                public void a() {
                    if (g.this.q != null && !g.this.r.getBoolean("key_video_hyper_lapse_focus_first_hints", false)) {
                        g.this.q.S();
                    }
                }
            });
        }
    }

    public void a(View view, int i2, int i3, int i4) {
        if (this.I == null) {
            com.oppo.camera.e.e("CameraUIManager", "showBubble, mCameraRootView: " + this.I + ", type: " + i2);
            return;
        }
        switch (i2) {
            case 3:
                if (this.T == null) {
                    this.T = x(this.i.getString(R.string.camera_bubble_sticker));
                    this.T.setTouchInterceptor(new View.OnTouchListener() {
                        public boolean onTouch(View view, MotionEvent motionEvent) {
                            g.this.c(3, true);
                            return false;
                        }
                    });
                    this.T.setOnDismissListener(new PopupWindow.OnDismissListener() {
                        public void onDismiss() {
                            g.this.c(3, true);
                        }
                    });
                }
                if (view != null) {
                    try {
                        this.T.a(view);
                        return;
                    } catch (WindowManager.BadTokenException e) {
                        if (this.T.isShowing()) {
                            this.T.dismiss();
                        }
                        com.oppo.camera.e.d("CameraUIManager", "showBubble, type: " + i2 + ", exception: " + e.getMessage());
                        return;
                    }
                } else {
                    return;
                }
            case 4:
                if (this.U == null) {
                    this.U = new com.oppo.camera.ui.widget.d(this.i);
                    this.U.a(true);
                    this.U.a((CharSequence) this.i.getString(R.string.camera_bubble_short_video));
                    this.U.setFocusable(true);
                    this.U.setBackgroundDrawable(new BitmapDrawable());
                    this.U.setTouchInterceptor(new View.OnTouchListener() {
                        public boolean onTouch(View view, MotionEvent motionEvent) {
                            g.this.c(4, true);
                            return false;
                        }
                    });
                    this.U.setOnDismissListener(new PopupWindow.OnDismissListener() {
                        public void onDismiss() {
                            g.this.c(4, true);
                        }
                    });
                }
                MainShutterButton o2 = this.p.o();
                this.U.c(o2.getShutterPadding());
                try {
                    this.U.a((View) o2);
                    return;
                } catch (WindowManager.BadTokenException e2) {
                    if (this.U.isShowing()) {
                        this.U.dismiss();
                        this.U = null;
                    }
                    com.oppo.camera.e.d("CameraUIManager", "showBubble, type: " + i2 + ", exception: " + e2.getMessage());
                    return;
                }
            case 5:
                if (this.X == null) {
                    this.X = l((int) R.drawable.bubble_down_right, (int) R.string.beauty3d_customize_success);
                    this.X.setTouchInterceptor(new View.OnTouchListener() {
                        public boolean onTouch(View view, MotionEvent motionEvent) {
                            g.this.c(5, true);
                            return false;
                        }
                    });
                }
                if (!this.X.isShowing()) {
                    try {
                        this.X.showAtLocation(this.I, 85, i3, i4);
                        return;
                    } catch (WindowManager.BadTokenException e3) {
                        if (this.X.isShowing()) {
                            this.X.dismiss();
                        }
                        com.oppo.camera.e.d("CameraUIManager", "showBubble, type: " + i2 + ", exception: " + e3.getMessage());
                        return;
                    }
                } else {
                    return;
                }
            case 6:
                if (this.V == null) {
                    this.V = l((int) R.drawable.bubble_down_left, (int) R.string.beauty3d_add_hint);
                    this.V.setTouchInterceptor(new View.OnTouchListener() {
                        public boolean onTouch(View view, MotionEvent motionEvent) {
                            g.this.c(6, true);
                            return false;
                        }
                    });
                }
                if (!this.V.isShowing()) {
                    try {
                        this.V.showAtLocation(this.I, 83, i3, i4);
                        return;
                    } catch (WindowManager.BadTokenException e4) {
                        if (this.V.isShowing()) {
                            this.V.dismiss();
                        }
                        com.oppo.camera.e.d("CameraUIManager", "showBubble, type: " + i2 + ", exception: " + e4.getMessage());
                        return;
                    }
                } else {
                    return;
                }
            case 7:
                a("key_ai_enhancement_video", "key_bubble_type_ai_enhancement_video", this.i.getString(R.string.camera_ai_enhancement_video_hint), i3, i4);
                return;
            case 8:
                if (this.W == null) {
                    this.W = new j(this.i);
                    this.W.a(true);
                    this.W.setFocusable(false);
                    this.W.a((CharSequence) this.i.getString(R.string.camera_custom_face_beauty_close_hint));
                    this.W.setTouchInterceptor(new View.OnTouchListener() {
                        public final boolean onTouch(View view, MotionEvent motionEvent) {
                            return g.this.a(view, motionEvent);
                        }
                    });
                }
                if (!this.W.isShowing() && view != null) {
                    try {
                        this.W.a(view, 4);
                        return;
                    } catch (WindowManager.BadTokenException e5) {
                        if (this.W.isShowing()) {
                            this.W.dismiss();
                        }
                        com.oppo.camera.e.d("CameraUIManager", "showBubble, type: " + i2 + ", exception: " + e5.getMessage());
                        return;
                    }
                } else {
                    return;
                }
            case 9:
                if (!k("key_bubble_type_zoom_ultra_wide")) {
                    com.oppo.camera.e.d("CameraUIManager", "showBubble, BUBBLE_TYPE_ZOOM_ULTRA_WIDE not support, so return");
                    return;
                }
                if (this.Y == null) {
                    this.Y = x(this.i.getString(R.string.zoom_ultra_wide_guide));
                    this.Y.setTouchInterceptor(new View.OnTouchListener() {
                        public boolean onTouch(View view, MotionEvent motionEvent) {
                            g.this.c(9, true);
                            return false;
                        }
                    });
                    this.Y.setOnDismissListener(new PopupWindow.OnDismissListener() {
                        public void onDismiss() {
                            g.this.c(9, true);
                        }
                    });
                }
                View findViewById = this.i.findViewById(R.id.zoom_seek_anchor_view);
                if (!(findViewById == null || 8 == findViewById.getVisibility())) {
                    try {
                        this.Y.a(findViewById);
                    } catch (WindowManager.BadTokenException e6) {
                        if (this.Y.isShowing()) {
                            this.Y.dismiss();
                        }
                        com.oppo.camera.e.d("CameraUIManager", "showBubble, type: " + i2 + ", exception: " + e6.getMessage());
                    }
                }
                if (this.x.M() && this.Y.isShowing()) {
                    this.x.O();
                    return;
                }
                return;
            case 10:
                if (this.aa == null) {
                    this.aa = new com.oppo.camera.ui.widget.d(this.i);
                    this.aa.a(true);
                    this.aa.a((CharSequence) this.i.getString(R.string.super_text_guide));
                    this.aa.setFocusable(false);
                    this.aa.setTouchInterceptor(new View.OnTouchListener() {
                        public boolean onTouch(View view, MotionEvent motionEvent) {
                            g.this.c(10, true);
                            return false;
                        }
                    });
                    this.aa.setOnDismissListener(new PopupWindow.OnDismissListener() {
                        public void onDismiss() {
                            g.this.c(10, true);
                        }
                    });
                }
                int dimensionPixelSize = this.i.getResources().getDimensionPixelSize(R.dimen.color_tool_tips_anchor_size);
                final Space space = new Space(this.i);
                space.setId(R.id.space_super_text_anchor);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
                layoutParams.addRule(14);
                space.setLayoutParams(layoutParams);
                this.I.addView(space, layoutParams);
                this.aa.b(this.i.getResources().getDimensionPixelOffset(R.dimen.common_super_text_guide_top));
                this.aM.post(new Runnable() {
                    public void run() {
                        if (g.this.aa != null) {
                            g.this.aa.a(space);
                            g gVar = g.this;
                            gVar.a((j) gVar.aa);
                        }
                    }
                });
                return;
            case 12:
                if (k("pref_subsetting_key")) {
                    if (this.ab == null) {
                        int dimensionPixelOffset = this.i.getResources().getDimensionPixelOffset(R.dimen.drawer_layout_arrow_height);
                        this.ab = new com.oppo.camera.ui.widget.d(this.i);
                        this.ab.a((CharSequence) this.i.getString(R.string.camera_drawer_guide));
                        this.ab.a(true);
                        this.ab.c(dimensionPixelOffset);
                        this.ab.setTouchInterceptor(new View.OnTouchListener() {
                            public boolean onTouch(View view, MotionEvent motionEvent) {
                                g.this.c(12, true);
                                return false;
                            }
                        });
                        this.ab.setOnDismissListener(new PopupWindow.OnDismissListener() {
                            public void onDismiss() {
                                g.this.c(12, true);
                                if (g.this.r != null && g.this.x != null && g.this.r.getBoolean("key_bubble_type_zoom_ultra_wide", true) && !com.oppo.camera.f.a.c(g.this.x.t())) {
                                    g.this.a((View) null, 9, 0, 0);
                                }
                            }
                        });
                    }
                    if (view != null) {
                        try {
                            this.ab.a(view);
                            return;
                        } catch (WindowManager.BadTokenException e7) {
                            if (this.ab.isShowing()) {
                                this.ab.dismiss();
                                this.ab = null;
                            }
                            com.oppo.camera.e.d("CameraUIManager", "showBubble, type: " + i2 + ", exception: " + e7.getMessage());
                            return;
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            case 13:
                a("key_ai_enhancement_video", "key_bubble_type_allmighty_video", this.i.getString(R.string.camera_ai_enhancement_video_hint), i3, i4);
                return;
            case 14:
                a("key_multicamera_type_menu_key", "key_bubble_type_multi_video", this.i.getString(R.string.camera_mode_multi_video_tip), i3, i4);
                return;
            case 15:
                a("pref_super_raw_control_key", "pref_super_raw_control_key", "super_raw", this.i.getString(R.string.camera_raw_control_super_bubble_hint), i3, i4);
                return;
            case 16:
                if (this.Z == null) {
                    this.Z = x(this.i.getString(R.string.camera_double_exposure_gallery_hint));
                    this.Z.setTouchInterceptor(new View.OnTouchListener() {
                        public boolean onTouch(View view, MotionEvent motionEvent) {
                            g.this.c(16, true);
                            return false;
                        }
                    });
                    if (view != null) {
                        try {
                            this.Z.a(view);
                            return;
                        } catch (WindowManager.BadTokenException e8) {
                            if (this.Z.isShowing()) {
                                this.Z.dismiss();
                                this.Z = null;
                            }
                            com.oppo.camera.e.d("CameraUIManager", "showBubble, type: " + i2 + ", exception: " + e8.getMessage());
                            return;
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            default:
                return;
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean a(View view, MotionEvent motionEvent) {
        c(8, true);
        return false;
    }

    public void aq() {
        f fVar = this.x;
        if (fVar != null) {
            fVar.aa();
        }
    }

    public boolean ao() {
        if (!dt()) {
            return false;
        }
        boolean a2 = this.w.a((Runnable) new Runnable() {
            public final void run() {
                g.this.eq();
            }
        });
        this.az = a2;
        h = !a2;
        if (a2) {
            at(false);
            M(false);
        }
        com.oppo.camera.e.b("CameraUIManager", "showDrawerSettingDownAni, showed: " + a2);
        return a2;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void eq() {
        if (!this.l && !cn()) {
            com.oppo.camera.ui.menu.setting.f fVar = this.w;
            if (fVar != null) {
                fVar.o();
            }
            M(true);
            f fVar2 = this.x;
            if (fVar2 != null) {
                fVar2.aH();
            }
        }
    }

    public void bX() {
        com.oppo.camera.ui.menu.setting.f fVar = this.w;
        if (fVar != null) {
            fVar.r();
        }
    }

    private boolean dt() {
        f fVar;
        if (!h || this.l || (fVar = this.x) == null || this.r == null || this.w == null || !fVar.E() || this.x.b() || !this.w.p() || !this.r.getBoolean("key_drawer_show_guide_animation", true)) {
            return false;
        }
        return true;
    }

    public void c(int i2, boolean z2) {
        String str;
        PopupWindow popupWindow = null;
        switch (i2) {
            case 3:
                popupWindow = this.T;
                str = "key_bubble_sticker";
                break;
            case 4:
                popupWindow = this.U;
                str = "key_bubble_short_video";
                break;
            case 5:
                popupWindow = this.X;
                str = "key_bubble_type_custom_beuty3d";
                break;
            case 6:
                popupWindow = this.V;
                str = "key_bubble_type_add_beuty3d";
                break;
            case 7:
                u("key_ai_enhancement_video");
                if (z2) {
                    e("key_bubble_type_ai_enhancement_video", false);
                    break;
                }
                break;
            case 8:
                popupWindow = this.W;
                str = "key_bubble_type_custom_face_beauty_close";
                break;
            case 9:
                j jVar = this.Y;
                if (jVar != null) {
                    if (jVar.isShowing()) {
                        this.Y.dismiss();
                    }
                    if (z2) {
                        e("key_bubble_type_zoom_ultra_wide", false);
                        this.Y = null;
                        break;
                    }
                }
                break;
            case 10:
                com.oppo.camera.ui.widget.d dVar = this.aa;
                if (dVar != null) {
                    if (dVar.isShowing()) {
                        this.aa.dismiss();
                    }
                    if (z2) {
                        e("key_bubble_type_super_text", false);
                        this.aa = null;
                        break;
                    }
                }
                break;
            case 12:
                com.oppo.camera.ui.widget.d dVar2 = this.ab;
                if (dVar2 != null) {
                    if (dVar2.isShowing()) {
                        this.ab.dismiss();
                    }
                    if (z2) {
                        e("key_drawer_layout_anchor", false);
                        this.ab = null;
                        break;
                    }
                }
                break;
            case 13:
                u("key_ai_enhancement_video");
                if (z2) {
                    e("key_bubble_type_allmighty_video", false);
                    break;
                }
                break;
            case 14:
                u("key_multicamera_type_menu_key");
                if (z2) {
                    e("key_bubble_type_multi_video", false);
                    break;
                }
                break;
            case 16:
                j jVar2 = this.Z;
                if (jVar2 != null) {
                    if (jVar2.isShowing()) {
                        this.Z.dismiss();
                    }
                    if (z2) {
                        e("pref_double_exposure_tips", false);
                        this.Z = null;
                        break;
                    }
                }
                break;
        }
        str = null;
        if (popupWindow != null) {
            if (popupWindow.isShowing()) {
                popupWindow.dismiss();
            }
            if (z2) {
                e(str, false);
            }
        }
    }

    private void du() {
        c(12, true);
        c(9, true);
        c(10, true);
        c(3, true);
        c(4, true);
    }

    /* access modifiers changed from: private */
    public void a(j jVar) {
        try {
            Field declaredField = j.class.getDeclaredField("e");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(jVar);
            if (obj != null) {
                ViewGroup viewGroup = (ViewGroup) obj;
                for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                    View childAt = viewGroup.getChildAt(i2);
                    if (childAt instanceof ImageView) {
                        childAt.setVisibility(8);
                        return;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void dv() {
        if (this.I != null && this.P == null) {
            this.P = (CameraScreenHintView) this.i.getLayoutInflater().inflate(R.layout.camera_screen_hint, (ViewGroup) null);
            View view = this.R;
            if (view != null) {
                ViewGroup viewGroup = this.I;
                viewGroup.addView(this.P, viewGroup.indexOfChild(view));
            } else {
                this.I.addView(this.P);
            }
            this.P.setOrientation(this.z);
            if (!this.x.g("pref_support_rotate_hint_view")) {
                this.P.setSupportRotateScreen(2);
            }
        }
    }

    public void n(String str) {
        if (this.P == null) {
            dv();
            if (this.P != null) {
                this.P.a(0, (this.i.getResources().getDimensionPixelSize(R.dimen.sticker_hint_bottom_margin_vertical) + Util.w()) - this.P.getViewGap(), this.i.getResources().getDimensionPixelSize(R.dimen.sticker_hint_bottom_margin_horizontal) - this.P.getViewGap(), true);
            }
        }
        CameraScreenHintView cameraScreenHintView = this.P;
        if (cameraScreenHintView != null) {
            cameraScreenHintView.a(str, true, false, (int) R.color.sticker_hint_background_color, (int) R.color.screen_hint_text_color);
        }
    }

    public void v() {
        CameraScreenHintView cameraScreenHintView = this.P;
        if (cameraScreenHintView != null && cameraScreenHintView.getHintTextView().getVisibility() == 0) {
            this.P.c(true);
        }
    }

    private PopupWindow l(int i2, int i3) {
        View inflate = LayoutInflater.from(this.i).inflate(R.layout.camera_bubble, (ViewGroup) null);
        inflate.setBackgroundResource(i2);
        ((OppoTextView) inflate.findViewById(R.id.camera_bubble_text)).setText(i3);
        PopupWindow popupWindow = new PopupWindow(this.i);
        popupWindow.setWidth(-2);
        popupWindow.setHeight(-2);
        popupWindow.setContentView(inflate);
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        popupWindow.setFocusable(false);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setAnimationStyle(R.style.PopupWindowStyle);
        return popupWindow;
    }

    private j x(String str) {
        j jVar = new j(this.i);
        jVar.a((CharSequence) str);
        jVar.a(true);
        jVar.setFocusable(false);
        return jVar;
    }

    private void e(String str, boolean z2) {
        com.oppo.camera.k kVar = this.r;
        if (kVar == null) {
            com.oppo.camera.e.e("CameraUIManager", "updateBubbleValue, mPreference null");
            return;
        }
        SharedPreferences.Editor edit = kVar.edit();
        edit.putBoolean(str, z2);
        edit.apply();
    }

    public int l() {
        com.oppo.camera.ui.control.b bVar = this.p;
        if (bVar != null) {
            return bVar.S();
        }
        return 1;
    }

    public void ac(boolean z2) {
        com.oppo.camera.ui.control.b bVar = this.p;
        if (bVar != null) {
            bVar.j(z2);
        }
    }

    public void bY() {
        com.oppo.camera.e.b("CameraUIManager", "startArrowAnimation");
        com.oppo.camera.ui.menu.setting.f fVar = this.w;
        if (fVar != null) {
            fVar.j();
            com.oppo.camera.k kVar = this.r;
            if (kVar != null) {
                kVar.edit().putBoolean("show_arrow_animation", false).apply();
            }
        }
    }

    public void bZ() {
        com.oppo.camera.ui.menu.levelcontrol.e eVar = this.N;
        if (eVar != null) {
            eVar.i();
        }
    }

    public boolean ca() {
        com.oppo.camera.ui.menu.levelcontrol.e eVar = this.N;
        if (eVar != null) {
            return eVar.m();
        }
        return false;
    }

    public void ad(boolean z2) {
        com.oppo.camera.ui.menu.levelcontrol.e eVar = this.N;
        if (eVar != null && eVar.b()) {
            this.N.b(z2, false);
        }
    }

    public void q(boolean z2) {
        com.oppo.camera.ui.menu.setting.t tVar = this.ai;
        if (tVar != null) {
            tVar.c(z2, true);
        }
    }

    public void B() {
        com.oppo.camera.ui.preview.d dVar = this.q;
        if (dVar != null) {
            dVar.F();
        }
    }

    public void o(boolean z2) {
        com.oppo.camera.ui.menu.levelcontrol.e eVar = this.N;
        if (eVar != null) {
            eVar.a(4, z2);
        }
    }

    public void r(boolean z2) {
        f fVar;
        com.oppo.camera.e.a("CameraUIManager", "showFaceBeautyMenu, needAnim: " + z2);
        if ((cQ() && cH()) || (fVar = this.x) == null || !fVar.g(CameraFunction.FACE_BEAUTY_PROCESS) || this.x.b() || this.x.y() || this.x.M()) {
            return;
        }
        if ((!this.x.ah() || this.x.ai()) && !this.k && this.ao != null && !this.N.b() && !G() && !cy() && !this.x.U() && !this.x.aN()) {
            this.ao.a(0, z2);
            if (!this.ao.h() || this.x.g(CameraFunction.FACE_BEAUTY_COMMON)) {
                h(0, z2);
            }
            dw();
        }
    }

    public void a(boolean z2, boolean z3, boolean z4, boolean z5) {
        com.oppo.camera.e.a("CameraUIManager", "hideFaceBeautyMenu, needAnim: " + z2 + ", needClose: " + z3 + ", showEnterButton: " + z4 + ", showZoom: " + z5);
        ObjectAnimator objectAnimator = this.aq;
        if (objectAnimator != null && objectAnimator.isStarted()) {
            this.aq.end();
        }
        com.oppo.camera.ui.menu.a.g gVar = this.ao;
        if (gVar == null) {
            return;
        }
        if (!z3 || !gVar.h()) {
            this.ao.a(8, z2);
            if (!this.ao.h()) {
                h(8, z2);
                return;
            }
            return;
        }
        b(z2, z4, z5);
    }

    public void s(boolean z2) {
        com.oppo.camera.e.a("CameraUIManager", "openFaceBeautyMenu, needAnim: " + z2);
        ObjectAnimator objectAnimator = this.aq;
        if (objectAnimator == null || !objectAnimator.isRunning()) {
            com.oppo.camera.ui.menu.a.g gVar = this.ao;
            if (gVar == null) {
                com.oppo.camera.e.d("CameraUIManager", "openFaceBeautyMenu, return");
                return;
            }
            gVar.a(true);
            f fVar = this.x;
            if (fVar != null) {
                this.ao.b(fVar.u());
            }
            bG();
            this.r.getString("pref_camera_gesture_shutter_key", this.i.getString(R.string.camera_gesture_shutter_default_value));
            f fVar2 = this.x;
            int I2 = fVar2 != null ? fVar2.I() : 0;
            b(z2, I2);
            View a2 = this.ao.a(I2);
            ViewGroup.LayoutParams c = this.ao.c();
            if (!(a2 == null || c == null)) {
                a2.setVisibility(0);
                if (a2.getParent() == null) {
                    this.I.addView(a2, this.I.indexOfChild(this.p.R()) + 1, c);
                }
                this.ao.b(z2);
            }
            if (2 == I2) {
                return;
            }
            if (z2) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.aj, "alpha", new float[]{1.0f, 0.0f});
                ofFloat.setInterpolator(AnimationUtils.loadInterpolator(this.i, R.anim.alpha_path_interpolator));
                ofFloat.setDuration(80);
                ofFloat.addListener(new Animator.AnimatorListener() {
                    public void onAnimationCancel(Animator animator) {
                    }

                    public void onAnimationRepeat(Animator animator) {
                    }

                    public void onAnimationStart(Animator animator) {
                    }

                    public void onAnimationEnd(Animator animator) {
                        if (g.this.aj != null) {
                            g.this.aj.setVisibility(8);
                        }
                        if (g.this.x != null) {
                            g.this.x.ap();
                        }
                    }
                });
                ofFloat.start();
                return;
            }
            this.aj.setVisibility(8);
            f fVar3 = this.x;
            if (fVar3 != null) {
                fVar3.ap();
                return;
            }
            return;
        }
        com.oppo.camera.e.a("CameraUIManager", "openFaceBeautyMenu, mCloseFaceAlphaButtonAnimator.isRunning()");
    }

    public void D(boolean z2) {
        com.oppo.camera.ui.control.b bVar = this.p;
        if (bVar == null) {
            return;
        }
        if (z2) {
            bVar.ad();
        } else {
            bVar.ab();
        }
    }

    public void ae() {
        if (this.p != null) {
            com.oppo.camera.doubleexposure.g gVar = this.aE;
            if (gVar == null || !gVar.o()) {
                this.p.ae();
            }
        }
    }

    public void af() {
        com.oppo.camera.ui.control.b bVar = this.p;
        if (bVar != null) {
            bVar.ag();
        }
    }

    public void i(boolean z2, boolean z3) {
        com.oppo.camera.ui.preview.d dVar = this.q;
        if (dVar != null) {
            dVar.b(z2, z3);
        }
    }

    public void b(boolean z2, boolean z3, boolean z4) {
        com.oppo.camera.e.a("CameraUIManager", "closeFaceBeautyMenu, needAnim: " + z2 + ", showEnterButton: " + z3 + ", showZoom: " + z4);
        if (this.ao == null) {
            com.oppo.camera.e.d("CameraUIManager", "closeFaceBeautyMenu, return");
            return;
        }
        f fVar = this.x;
        if (fVar != null) {
            fVar.h(false);
        }
        this.ao.a(false);
        this.ao.c(z2);
        int b2 = this.ao.b();
        a(z2, b2, z3, z4);
        if (2 == b2) {
            if (!z3) {
                this.aj.setVisibility(8);
            }
        } else if (!z3) {
        } else {
            if (z2) {
                this.aq = ObjectAnimator.ofFloat(this.aj, "alpha", new float[]{0.0f, 1.0f});
                this.aq.setInterpolator(AnimationUtils.loadInterpolator(this.i, R.anim.alpha_path_interpolator));
                this.aq.setStartDelay(160);
                this.aq.setDuration(160);
                this.aq.addListener(new Animator.AnimatorListener() {
                    public void onAnimationCancel(Animator animator) {
                    }

                    public void onAnimationRepeat(Animator animator) {
                    }

                    public void onAnimationStart(Animator animator) {
                    }

                    public void onAnimationEnd(Animator animator) {
                        if (g.this.aj != null) {
                            g.this.aj.setAlpha(1.0f);
                            g.this.aj.setVisibility(0);
                        }
                        if (g.this.x != null) {
                            g.this.x.aq();
                        }
                    }
                });
                this.aq.start();
                return;
            }
            this.aj.setAlpha(1.0f);
            this.aj.setVisibility(0);
            f fVar2 = this.x;
            if (fVar2 != null) {
                fVar2.aq();
            }
        }
    }

    public boolean C() {
        com.oppo.camera.ui.menu.a.g gVar = this.ao;
        return gVar != null && gVar.h();
    }

    public boolean G() {
        com.oppo.camera.ui.menu.levelcontrol.a aVar = this.O;
        if (aVar == null) {
            return false;
        }
        return aVar.h();
    }

    public boolean cb() {
        com.oppo.camera.ui.menu.levelcontrol.a aVar = this.ak;
        return aVar != null && aVar.h();
    }

    public void p(boolean z2) {
        if (this.N != null && this.x.g("pref_filter_process_key") && !this.x.b() && !this.k) {
            this.N.a(0, z2);
        }
    }

    public void e(int i2, boolean z2) {
        com.oppo.camera.ui.menu.a.g gVar;
        this.aj.setClickable(z2);
        this.aj.setEnabled(z2);
        M(i2);
        ay(i2 != 0);
        if (!z2 && (gVar = this.ao) != null) {
            if ((gVar.h() && !this.ao.f()) || this.ao.g()) {
                b(false, true, false);
            }
        }
    }

    /* access modifiers changed from: private */
    public void ay(final boolean z2) {
        Activity activity = this.i;
        if (activity != null) {
            activity.runOnUiThread(new Runnable() {
                public void run() {
                    int i;
                    if (g.this.aj != null) {
                        g.this.aF.cancel();
                        Drawable foreground = g.this.aj.getForeground();
                        if (foreground != null) {
                            i = foreground.getAlpha();
                        } else {
                            com.oppo.camera.e.e("CameraUIManager", "setFaceBeautyEnterButton, drawable is null");
                            i = 0;
                        }
                        if (z2) {
                            g.this.aF.setIntValues(new int[]{i, 255});
                            g.this.aF.start();
                            return;
                        }
                        g.this.aF.setIntValues(new int[]{i, 0});
                        g.this.aF.start();
                        if (g.this.dO()) {
                            g.this.aj.setEnabled(false);
                        }
                    }
                }
            });
        }
    }

    private void M(int i2) {
        com.oppo.camera.ui.menu.a.g gVar = this.ao;
        if (gVar != null) {
            gVar.c(i2);
        }
    }

    private void h(int i2, boolean z2) {
        Activity activity;
        com.oppo.camera.e.a("CameraUIManager", "setFaceBeautyEnterButtonVisibility, visibility: " + i2 + ", needAnim: " + z2);
        if (i2 == 0) {
            this.aj.setAlpha(1.0f);
        }
        if (!z2 || (activity = this.i) == null) {
            this.aj.setVisibility(i2);
            return;
        }
        Util.a((View) this.aj, i2, (Animation.AnimationListener) null, 180, 0, AnimationUtils.loadInterpolator(activity, R.anim.alpha_path_interpolator));
    }

    /* access modifiers changed from: private */
    public void i(int i2, boolean z2) {
        Activity activity;
        SwitchButton switchButton = this.ap;
        if (switchButton != null && this.I.indexOfChild(switchButton) != -1 && !cn()) {
            com.oppo.camera.e.a("CameraUIManager", "setSuperEISWideSwitchVisibility, visibility: " + i2 + ", needAnim: " + z2);
            long j2 = 160;
            long j3 = i2 == 0 ? 160 : 0;
            if (i2 != 0) {
                j2 = 80;
            }
            long j4 = j2;
            if (!z2 || (activity = this.i) == null) {
                this.ap.setVisibility(i2);
            } else {
                Util.a((View) this.ap, i2, (Animation.AnimationListener) null, j4, j3, AnimationUtils.loadInterpolator(activity, R.anim.alpha_path_interpolator));
            }
        }
    }

    /* access modifiers changed from: private */
    public void dw() {
        com.oppo.camera.e.a("CameraUIManager", "updateFaceBeautyEnterButton");
        f fVar = this.x;
        if (fVar != null && this.ao != null) {
            ay(fVar.J() != 0);
        }
    }

    public void cc() {
        com.oppo.camera.ui.preview.d dVar = this.q;
        if (dVar != null && dVar.al()) {
            this.q.ai();
        }
    }

    private void b(boolean z2, int i2) {
        f fVar;
        if (i2 == 1) {
            if (this.ar) {
                ai(z2);
                f fVar2 = this.x;
                if (fVar2 != null) {
                    fVar2.j();
                }
            } else {
                com.oppo.camera.ui.control.b bVar = this.p;
                if (bVar != null) {
                    if (z2) {
                        bVar.g();
                    } else {
                        bVar.a(false);
                    }
                }
            }
            cc();
        } else if (i2 == 2 && (fVar = this.x) != null) {
            fVar.j();
        }
    }

    private void a(boolean z2, int i2, boolean z3, boolean z4) {
        f fVar;
        f fVar2;
        if (!z3) {
            if (z4 && (fVar2 = this.x) != null) {
                fVar2.a(false);
            }
        } else if (i2 != 1) {
            if (i2 == 2 && (fVar = this.x) != null) {
                fVar.a(false);
                this.x.ad();
            }
        } else if (this.ar) {
            a(0, true);
            f fVar3 = this.x;
            if (fVar3 != null) {
                fVar3.a(false);
            }
        } else {
            com.oppo.camera.ui.control.b bVar = this.p;
            if (bVar == null) {
                return;
            }
            if (z2) {
                bVar.d(true, true);
            } else {
                bVar.b(z2);
            }
        }
    }

    public void cd() {
        v vVar;
        if (this.p != null && this.x.aI()) {
            ap(false);
            this.p.u();
        }
        com.oppo.camera.ui.menu.levelcontrol.e eVar = this.N;
        if (eVar != null && !eVar.b()) {
            o(false);
        }
        if (this.aj != null) {
            a(true, true, false, true);
        }
        f fVar = this.x;
        if (!(fVar == null || !fVar.b() || (vVar = this.t) == null)) {
            vVar.a(false);
        }
        if (ba()) {
            bC();
        }
        f fVar2 = this.x;
        if (fVar2 == null || !fVar2.Q()) {
            f fVar3 = this.x;
            if (fVar3 == null || !fVar3.b()) {
                g(4, true);
            } else {
                v vVar2 = this.t;
                if (vVar2 != null) {
                    vVar2.a(false);
                }
            }
        } else {
            this.ah.b(AnimationUtils.loadAnimation(this.i, R.anim.zoom_panel_level_out));
        }
        com.oppo.camera.ui.preview.d dVar = this.q;
        if (dVar != null) {
            dVar.an();
        }
        m(true, false);
    }

    public void ce() {
        f fVar;
        if (this.p != null && this.x.aI()) {
            A(true);
            this.p.v();
        }
        f fVar2 = this.x;
        if (fVar2 != null) {
            if (fVar2.d()) {
                dz();
            } else if (!this.x.b()) {
                if (this.x.Q()) {
                    dy();
                } else {
                    dx();
                }
            }
        }
        if (this.q != null && (fVar = this.x) != null && fVar.aI() && this.aB) {
            com.oppo.camera.ui.preview.d dVar = this.q;
            dVar.a((View) dVar.ao(), this.x.aJ(), true);
        }
        f fVar3 = this.x;
        if (fVar3 != null && fVar3.aI() && this.aD) {
            m(true, true);
        }
    }

    private void dx() {
        com.oppo.camera.ui.menu.levelcontrol.e eVar = this.N;
        if (eVar == null || !eVar.b()) {
            com.oppo.camera.ui.menu.levelcontrol.a aVar = this.O;
            if (aVar == null || !aVar.b()) {
                f fVar = this.x;
                if ((fVar != null && fVar.R()) || k("pref_headline_control_by_mode")) {
                    return;
                }
                if ((!this.q.z() || this.y != 2) && 3 != this.y) {
                    g(0, true);
                }
            }
        }
    }

    private void dy() {
        com.oppo.camera.ui.menu.levelcontrol.e eVar;
        if (!this.x.S() && !ak() && !this.x.R() && (eVar = this.N) != null && !eVar.b()) {
            if (this.aC || !this.x.aI()) {
                this.ah.a(AnimationUtils.loadAnimation(this.i, R.anim.zoom_panel_level_in));
            }
        }
    }

    private void dz() {
        v vVar = this.t;
        if (vVar != null && !vVar.g()) {
            a((Float) null, this.t.d(), this.t.e());
        }
    }

    public void l(boolean z2, boolean z3) {
        if (z2) {
            p(true);
        }
        if (this.aj != null && z3) {
            r(true);
        }
    }

    public void k(int i2) {
        com.oppo.camera.ui.control.b bVar = this.p;
        if (bVar != null) {
            bVar.k(i2);
        }
    }

    public void cf() {
        if (aQ()) {
            bE();
        }
    }

    public void b(int i2, String str) {
        com.oppo.camera.ui.control.b bVar = this.p;
        if (bVar != null) {
            bVar.a(i2, str);
        }
    }

    public void cg() {
        if (this.x.ae() == 0) {
            this.x.a(false, false);
        }
    }

    public void ae(boolean z2) {
        j(4);
        b(4, z2);
        h(8);
        a(8);
        ai(true);
        c(false, false);
        a(true, false);
        e(false, false);
        f(8);
        b(false);
        t(false);
        if (s()) {
            q(false);
        } else {
            o(false);
        }
        d(false, false, false);
        a(true, true, false, false);
    }

    public void ch() {
        com.oppo.camera.ui.control.b bVar = this.p;
        if (bVar != null) {
            bVar.Y();
        }
    }

    public void ci() {
        com.oppo.camera.ui.control.b bVar = this.p;
        if (bVar != null) {
            bVar.Z();
        }
    }

    public void cj() {
        com.oppo.camera.ui.preview.d dVar = this.q;
        if (dVar != null) {
            dVar.a();
        }
    }

    public void ck() {
        com.oppo.camera.ui.preview.d dVar = this.q;
        if (dVar != null) {
            dVar.c();
        }
    }

    public void Q() {
        com.oppo.camera.ui.preview.d dVar = this.q;
        if (dVar != null) {
            dVar.b();
        }
    }

    public void a(com.oppo.camera.t.a aVar) {
        com.oppo.camera.ui.preview.d dVar = this.q;
        if (dVar != null) {
            dVar.a(aVar);
        }
    }

    public void b(final com.oppo.camera.t.a aVar) {
        com.oppo.camera.e.a("CameraUIManager", "executeSuperTextFrameColorAnimation");
        if (this.q != null) {
            com.oppo.camera.e.a("CameraUIManager", this.aM, "CameraUIManager");
            this.aM.post(new Runnable() {
                public void run() {
                    com.oppo.camera.e.a("CameraUIManager", "executeSuperTextFrameColorAnimation, in handler");
                    g.this.q.b(aVar);
                }
            });
        }
    }

    public void a(int... iArr) {
        com.oppo.camera.ui.control.b bVar = this.p;
        if (bVar != null) {
            bVar.a(iArr);
        }
    }

    public void c(int... iArr) {
        com.oppo.camera.ui.control.b bVar = this.p;
        if (bVar != null) {
            bVar.b(iArr);
        }
    }

    public void h(int i2, int i3) {
        com.oppo.camera.ui.modepanel.f fVar = this.as;
        if (fVar != null) {
            fVar.a(i2, i3);
        }
    }

    public void o(int i2) {
        com.oppo.camera.ui.modepanel.f fVar = this.as;
        if (fVar != null) {
            fVar.g(i2);
        }
    }

    public void W() {
        if (this.p != null) {
            View findViewById = this.i.findViewById(R.id.movie_mode_back);
            View findViewById2 = this.i.findViewById(R.id.movie_menu_id);
            View findViewById3 = this.i.findViewById(R.id.switch_camera_bar);
            a(0, 180, 0, (TimeInterpolator) null, (Animator.AnimatorListener) null);
            com.oppo.camera.j.b.a(true);
            com.oppo.camera.j.b.a(this.I, aT(), this.p.p(), this.p.am(), findViewById, findViewById2, findViewById3);
        }
    }

    public void X() {
        if (this.p != null) {
            View findViewById = this.i.findViewById(R.id.movie_mode_back);
            View findViewById2 = this.i.findViewById(R.id.movie_menu_id);
            View findViewById3 = this.i.findViewById(R.id.switch_camera_bar);
            a(4, 180, 0, (TimeInterpolator) null, (Animator.AnimatorListener) null);
            com.oppo.camera.j.b.a(this.I, aT(), this.p.p(), this.p.am(), this.as, this.p.an(), findViewById, findViewById2, findViewById3);
        }
    }

    public void Y() {
        int dp = dp();
        CameraScreenHintView cameraScreenHintView = this.J;
        if (cameraScreenHintView != null) {
            cameraScreenHintView.setOrientation(dp);
        }
        CameraScreenHintView cameraScreenHintView2 = this.K;
        if (cameraScreenHintView2 != null) {
            cameraScreenHintView2.setOrientation(dp);
        }
    }

    public void a(h.a aVar) {
        this.N.setFilterCategory(aVar);
    }

    public void af(boolean z2) {
        this.p.d(z2);
    }

    public void ag(boolean z2) {
        this.p.e(z2);
    }

    /* compiled from: CameraUIManager */
    private class a implements d.a {
        private a() {
        }

        public void a() {
            g.this.x.G();
        }
    }

    private void dA() {
        if (this.ah == null) {
            this.ah = new com.oppo.camera.ui.modepanel.c(this.i, this.p.R());
            this.ah.a((d.a) new a());
        }
    }

    public void o(String str) {
        if (this.ah != null && !cU()) {
            this.ah.a(str);
        }
    }

    public String cl() {
        com.oppo.camera.ui.modepanel.c cVar = this.ah;
        return cVar != null ? cVar.a() : "";
    }

    public void ah(boolean z2) {
        if (this.ah != null && !cU()) {
            this.ah.a(z2);
        }
    }

    public void ai(boolean z2) {
        com.oppo.camera.ui.modepanel.c cVar = this.ah;
        if (cVar != null) {
            cVar.b(z2);
        }
    }

    public void aj(boolean z2) {
        com.oppo.camera.ui.modepanel.c cVar = this.ah;
        if (cVar != null) {
            cVar.c(z2);
        }
    }

    public boolean cm() {
        com.oppo.camera.ui.modepanel.c cVar = this.ah;
        if (cVar != null) {
            return cVar.b();
        }
        return false;
    }

    public void ak(boolean z2) {
        com.oppo.camera.ui.modepanel.f fVar = this.as;
        if (fVar != null) {
            fVar.a(z2);
        }
    }

    public void A(int i2) {
        com.oppo.camera.ui.modepanel.f fVar = this.as;
        if (fVar != null) {
            fVar.b(i2);
        }
    }

    public void B(int i2) {
        com.oppo.camera.ui.modepanel.f fVar = this.as;
        if (fVar != null) {
            fVar.c(i2);
        }
    }

    public void m(boolean z2) {
        com.oppo.camera.ui.menu.levelcontrol.e eVar;
        com.oppo.camera.e.a("CameraUIManager", "hideAllCameraView");
        if (z2 && (eVar = this.N) != null) {
            eVar.a(false);
        }
        this.v.b(false);
        this.v.a(false, false);
        W(false);
        this.w.a(false, false);
        o(false);
        a(false, false, false, false);
        b(false);
        t(false);
        n(false);
        this.p.f(false);
        if (this.y != 1) {
            this.p.d(8);
            this.p.l(false);
        }
        this.p.i(false, false);
    }

    public void y() {
        al(false);
        d(true, false);
    }

    public void al(boolean z2) {
        f fVar;
        this.v.i();
        this.w.i();
        p(true);
        if (!z2 && (fVar = this.x) != null) {
            this.p.a(true, fVar != null && fVar.U(), this.x.aI());
        }
        if (this.y != 1) {
            this.p.d(0);
            this.p.l(true);
        }
        if (this.N.b()) {
            com.oppo.camera.e.a("CameraUIManager", "showAllCameraView, mEffectLevelMenu is open, hideRollGLSurfaceView");
            K(false);
        }
    }

    public boolean cn() {
        f fVar = this.x;
        if (fVar != null) {
            return fVar.b();
        }
        return false;
    }

    public void a(RotateImageView rotateImageView) {
        f fVar = this.x;
        if (fVar != null) {
            fVar.a(rotateImageView);
        }
    }

    public void i(int i2, int i3) {
        f fVar = this.x;
        if (fVar != null) {
            fVar.a(i2, i3);
        }
    }

    public String co() {
        f fVar = this.x;
        if (fVar != null) {
            return fVar.V();
        }
        return null;
    }

    public void cp() {
        f fVar = this.x;
        if (fVar != null) {
            fVar.X();
        }
    }

    public void C(int i2) {
        if (!Q(i2)) {
            dB();
        } else if (cr()) {
            dC();
        }
        if (!R(i2)) {
            dD();
        } else if (cs()) {
            dE();
        }
        if (!P(i2)) {
            dG();
        } else if (N(i2)) {
            dH();
        } else if (!O(i2)) {
            if (this.n) {
                if (dN()) {
                    dJ();
                } else {
                    dI();
                }
            } else if (dO()) {
                dK();
            }
        }
        if (!S(i2)) {
            dL();
        } else if (cu()) {
            dM();
        }
    }

    public void cq() {
        if (cr()) {
            dC();
        }
        if (cs()) {
            dE();
        }
        if (this.n) {
            if (dN()) {
                dJ();
            } else {
                dI();
            }
        } else if (dO()) {
            dK();
        }
        if (cu()) {
            dM();
        }
    }

    private void dB() {
        b("pref_camera_flashmode_key", this.i.getString(R.string.camera_flash_mode_default_value), "off");
    }

    private void dC() {
        f fVar = this.x;
        a("pref_camera_flashmode_key", this.i.getString(R.string.camera_flash_mode_default_value), fVar != null ? fVar.am() : true);
    }

    private void dD() {
        f fVar = this.x;
        if (fVar != null) {
            b("pref_camera_hdr_mode_key", CameraConfig.getOptionKeyDefaultValue("pref_camera_hdr_mode_key", fVar.t()), "off");
        }
    }

    private void dE() {
        f fVar = this.x;
        if (fVar != null) {
            a("pref_camera_hdr_mode_key", CameraConfig.getOptionKeyDefaultValue("pref_camera_hdr_mode_key", fVar.t()), true);
        }
    }

    private String dF() {
        return com.oppo.camera.entry.b.b(e.e_[0], this.y);
    }

    private void dG() {
        if (this.n) {
            if (dN()) {
                dJ();
            } else {
                dI();
            }
        }
        if (!dO()) {
            String dF = dF();
            String p2 = p(dF);
            int i2 = this.r.getInt(dF, 0);
            this.n = false;
            SharedPreferences.Editor edit = this.r.edit();
            edit.putInt(dF, 0);
            edit.putInt(p2, i2);
            edit.apply();
            this.i.runOnUiThread(new Runnable() {
                public void run() {
                    g.this.e(0, false);
                    if (g.this.x != null) {
                        g.this.x.e(0);
                    }
                }
            });
            com.oppo.camera.e.b("CameraUIManager", "disableFaceBeautyByAiScene, nowIndex: " + i2);
        }
    }

    private void dH() {
        String dF = dF();
        String p2 = p(dF);
        int i2 = this.r.getInt(dF, 0);
        int i3 = this.r.getInt(p2, Integer.MIN_VALUE);
        this.n = true;
        final int i4 = (Integer.MIN_VALUE == i3 || i3 == 0) ? 40 : i3;
        SharedPreferences.Editor edit = this.r.edit();
        if (Integer.MIN_VALUE == i3) {
            edit.putInt(p2, i2);
        }
        edit.putInt(dF, i4);
        edit.apply();
        this.i.runOnUiThread(new Runnable() {
            public void run() {
                g.this.e(i4, true);
                if (g.this.x != null) {
                    g.this.x.a(0, i4, false);
                    if (i4 != 0) {
                        g.this.x.e(102);
                    }
                }
            }
        });
        com.oppo.camera.e.b("CameraUIManager", "openFaceBeautyByAIScene, nowValueIndex: " + i2 + ", recordDisableValue: " + i3 + ", valueIndex: " + i4);
    }

    /* access modifiers changed from: private */
    public void dI() {
        String p2 = p(dF());
        SharedPreferences.Editor edit = this.r.edit();
        edit.remove(p2);
        edit.apply();
    }

    private void dJ() {
        String dF = dF();
        String p2 = p(dF);
        SharedPreferences.Editor edit = this.r.edit();
        edit.remove(p2);
        edit.putInt(dF, 0);
        edit.apply();
        this.i.runOnUiThread(new Runnable() {
            public void run() {
                if (g.this.C()) {
                    g.this.b(false, true, false);
                }
                g.this.ay(false);
                if (g.this.x != null) {
                    g.this.x.e(0);
                }
            }
        });
        com.oppo.camera.e.b("CameraUIManager", "setBeautyToOpenBeforeByAIScene");
    }

    private void dK() {
        String dF = dF();
        String p2 = p(dF);
        final int i2 = this.r.getInt(p2, 0);
        SharedPreferences.Editor edit = this.r.edit();
        if (i2 != 0) {
            edit.putInt(dF, i2);
        }
        edit.remove(p2);
        edit.apply();
        this.i.runOnUiThread(new Runnable() {
            public void run() {
                g.this.e(i2, true);
                if (g.this.x != null) {
                    g.this.x.a(0, i2, false);
                    if (i2 != 0) {
                        g.this.x.e(102);
                    }
                }
            }
        });
        com.oppo.camera.e.b("CameraUIManager", "openFaceBeautyByAIScene, lastValueIndex: " + i2);
    }

    private void dL() {
        String p2 = p("pref_camera_high_resolution_key");
        String p3 = p("key_high_picture_size");
        if (!q(p2)) {
            final String string = this.r.getString("pref_camera_high_resolution_key", "standard");
            boolean z2 = this.r.getBoolean("key_high_picture_size", false);
            SharedPreferences.Editor edit = this.r.edit();
            if (z2) {
                edit.putString("pref_camera_high_resolution_key", "standard");
                edit.putBoolean("key_high_picture_size", false);
            }
            edit.putString(p2, string);
            edit.putBoolean(p3, z2);
            edit.apply();
            this.i.runOnUiThread(new Runnable() {
                public void run() {
                    g.this.a("pref_camera_high_resolution_key", string);
                }
            });
            com.oppo.camera.e.b("CameraUIManager", "disableHighResolutionByAiScene, isOpen: " + z2 + ", nowState: " + string);
        }
    }

    private void dM() {
        String p2 = p("pref_camera_high_resolution_key");
        String p3 = p("key_high_picture_size");
        final String string = this.r.getString(p2, "ai_scene_last_default_value");
        boolean z2 = this.r.getBoolean(p3, false);
        SharedPreferences.Editor edit = this.r.edit();
        if (z2) {
            edit.putString("pref_camera_high_resolution_key", string);
            edit.putBoolean("key_high_picture_size", true);
        }
        edit.remove(p2);
        edit.remove(p3);
        edit.apply();
        this.i.runOnUiThread(new Runnable() {
            public void run() {
                g.this.b("pref_camera_high_resolution_key", string);
            }
        });
        com.oppo.camera.e.b("CameraUIManager", "enableHighResolutionByAiScene, lastHighPictureValue: " + z2);
    }

    private void b(final String str, String str2, final String str3) {
        String p2 = p(str);
        if (!q(p2)) {
            final String string = this.r.getString(str, str2);
            SharedPreferences.Editor edit = this.r.edit();
            if (!TextUtils.equals(string, str3)) {
                edit.putString(str, str3);
            }
            edit.putString(p2, string);
            edit.apply();
            this.i.runOnUiThread(new Runnable() {
                public void run() {
                    if (!TextUtils.equals(string, str3)) {
                        g.this.a(str, (String) null);
                    } else {
                        g.this.a(str, str3);
                    }
                }
            });
            com.oppo.camera.e.b("CameraUIManager", "disableByAiScene, disableFunctionKey: " + str + ", nowState: " + string);
        }
    }

    private void a(final String str, String str2, boolean z2) {
        String p2 = p(str);
        String string = this.r.getString(p2, str2);
        SharedPreferences.Editor edit = this.r.edit();
        if (z2) {
            edit.putString(str, string);
        }
        edit.remove(p2);
        edit.apply();
        if (z2) {
            this.i.runOnUiThread(new Runnable() {
                public void run() {
                    g.this.b(str, (String) null);
                }
            });
        }
        com.oppo.camera.e.b("CameraUIManager", "enableByAiScene, enableFunction: " + str + ", lastState: " + string + ", enable: " + z2);
    }

    private boolean N(int i2) {
        int i3 = this.r.getInt(dF(), 0);
        if (!O(i2) || i3 != 0) {
            return false;
        }
        return true;
    }

    public String p(String str) {
        String b2 = com.oppo.camera.entry.b.b(str, this.y);
        return b2 + "_close_by_ai_last_state";
    }

    public boolean cr() {
        return q(p("pref_camera_flashmode_key"));
    }

    public boolean cs() {
        return q(p("pref_camera_hdr_mode_key"));
    }

    public boolean ct() {
        return q(p("pref_filter_menu"));
    }

    public boolean cu() {
        return q(p("pref_camera_high_resolution_key"));
    }

    public boolean q(String str) {
        String string = this.r.getString(str, "ai_scene_last_default_value");
        com.oppo.camera.e.b("CameraUIManager", "isDisabledByAiScene, recordDisableStateKey: " + str + ", state: " + string);
        return !TextUtils.equals("ai_scene_last_default_value", string);
    }

    private boolean dN() {
        String dF = dF();
        String p2 = p(dF);
        int i2 = this.r.getInt(dF, 0);
        if (this.r.getInt(p2, Integer.MIN_VALUE) == 0 && 40 == i2) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    public boolean dO() {
        if (this.n) {
            return false;
        }
        int i2 = this.r.getInt(p(dF()), Integer.MIN_VALUE);
        com.oppo.camera.e.b("CameraUIManager", "isFaceBeautyDisabledByAIScene, lastFaceBeautyIndex: " + i2);
        if (Integer.MIN_VALUE != i2) {
            return true;
        }
        return false;
    }

    public void D(int i2) {
        Handler handler;
        if (!this.w.x() && (handler = this.aM) != null) {
            handler.removeMessages(2);
            this.aM.obtainMessage(2, Integer.valueOf(i2)).sendToTarget();
        }
    }

    public void cv() {
        am(true);
    }

    public void am(boolean z2) {
        Handler handler = this.aM;
        if (handler != null) {
            handler.removeMessages(2);
        }
        com.oppo.camera.ui.preview.a aVar = this.af;
        if (aVar != null) {
            aVar.g();
            cx();
        }
        if (z2) {
            cC();
        }
        this.C = 0;
        this.m = false;
    }

    /* access modifiers changed from: private */
    public void dP() {
        if (this.af != null) {
            T(this.C);
        }
    }

    /* access modifiers changed from: private */
    public void T(int i2) {
        this.af.a(i2, this.z, this.D);
        int b2 = this.af.b();
        if (i2 == 0) {
            cx();
            return;
        }
        CameraScreenHintView cameraScreenHintView = this.J;
        if (cameraScreenHintView != null) {
            cameraScreenHintView.b(U(b2));
        }
    }

    public void cw() {
        com.oppo.camera.ui.preview.a aVar = this.af;
        if (aVar != null) {
            aVar.h();
            cx();
        }
    }

    public void cx() {
        CameraScreenHintView cameraScreenHintView = this.J;
        if (cameraScreenHintView != null) {
            cameraScreenHintView.b(0);
        }
    }

    /* access modifiers changed from: private */
    public int U(int i2) {
        if (i2 != 0) {
            return i2 + this.E;
        }
        return 0;
    }

    private boolean dQ() {
        Boolean valueOf = Boolean.valueOf(CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_VIDEO_FRONT_EIS_FORCE_ULTRA_WIDE));
        f fVar = this.x;
        Boolean valueOf2 = Boolean.valueOf(fVar != null && fVar.g("pref_video_super_eis_key"));
        Boolean valueOf3 = Boolean.valueOf("on".equals(this.r.getString("pref_video_super_eis_key", "off")));
        Boolean valueOf4 = Boolean.valueOf(com.oppo.camera.f.a.c(bB()));
        if (valueOf.booleanValue()) {
            if (!valueOf2.booleanValue() || !valueOf3.booleanValue()) {
                return false;
            }
            return true;
        } else if (!valueOf2.booleanValue() || valueOf4.booleanValue()) {
            return false;
        } else {
            return true;
        }
    }

    public boolean cy() {
        f fVar = this.x;
        if (fVar == null || this.r == null || !fVar.g("pref_video_super_eis_key") || com.oppo.camera.f.a.c(bB())) {
            return false;
        }
        return "on".equals(this.r.getString("pref_video_super_eis_key", "off"));
    }

    public Rect[] cz() {
        com.oppo.camera.ui.preview.d dVar = this.q;
        if (dVar != null) {
            return dVar.ag();
        }
        return null;
    }

    public void cA() {
        this.q.Z();
    }

    public void cB() {
        this.q.aa();
    }

    private boolean dR() {
        return !this.r.getString("pref_camera_tap_shutter_key", this.i.getString(R.string.camera_tap_shutter_default_value)).equals(this.r.getString("last_camera_tap_shutter_key", this.i.getString(R.string.camera_tap_shutter_default_value)));
    }

    public void d(String str, boolean z2) {
        com.oppo.camera.ui.menu.setting.t tVar = this.ae.get(str);
        if (!(this.v == null || tVar == null)) {
            if (!tVar.b() || z2 || tVar.d() || !tVar.c()) {
                this.v.b(str, tVar.c());
            } else {
                this.v.b(str, true);
            }
        }
        if (this.w != null && tVar != null) {
            if (!tVar.b() || z2 || tVar.d()) {
                this.w.b(str, tVar.c());
            } else {
                this.w.b(str, true);
            }
        }
    }

    public void h(String str) {
        d(str, false);
    }

    public void a(String str, com.oppo.camera.ui.menu.setting.t tVar) {
        if (tVar != null && !this.ae.containsKey(str)) {
            this.ae.put(str, tVar);
        }
        com.oppo.camera.e.a("CameraUIManager", "addMenuToExpandMenuMap, Map size: " + this.ae.size());
    }

    public void E(int i2) {
        com.oppo.camera.ui.menu.levelcontrol.a aVar = this.O;
        if (aVar != null) {
            aVar.a(i2);
        }
    }

    public void r(String str) {
        if (t(str)) {
            boolean z2 = false;
            if (this.ai != null) {
                com.oppo.camera.e.a("CameraUIManager", "updateCameraSettingExpandMenu, mCurrentExpandPanel: " + this.ai + ", key: " + str);
                if (str.equals(this.ai.getCurrentMenuKey())) {
                    this.ai.a(true, false);
                } else if (!"DefaultExpandPanel".equals(this.ai.getCurrentMenuKey())) {
                    com.oppo.camera.ui.menu.setting.t tVar = this.ae.get(str);
                    boolean z3 = tVar == null;
                    if (tVar != null) {
                        z2 = true;
                    }
                    this.ai.a(z3, z2);
                    if (tVar != null) {
                        if (tVar.d == null) {
                            tVar.setExpandMenuListener(this.aS);
                        }
                        tVar.a(str, true);
                    }
                } else if (s(str)) {
                    this.ai.a(str, false);
                }
            } else if (s(str)) {
                this.ai.a(str, false);
            }
        } else {
            com.oppo.camera.e.d("CameraUIManager", "updateCameraSettingExpandMenu, key: " + str);
        }
    }

    public boolean s(String str) {
        if (this.ae.get(str) != null && this.ae.get(str).d == null) {
            this.ae.get(str).setExpandMenuListener(this.aS);
        }
        this.ai = this.ae.get(str);
        com.oppo.camera.ui.menu.setting.t tVar = this.ai;
        if (tVar == null) {
            return false;
        }
        int i2 = this.av;
        if (i2 == 0) {
            return true;
        }
        tVar.setSkipIndex(i2);
        this.av = 0;
        return true;
    }

    public boolean t(String str) {
        return "pref_filter_menu".equals(str) || "pref_night_filter_menu".equals(str) || "pref_portrait_new_style_menu".equals(str) || "pref_video_filter_menu".equals(str) || "pref_video_blur_menu".equals(str) || "pref_portrait_blur_menu".equals(str) || "pref_tilt_shift_blur_menu".equals(str);
    }

    public void cC() {
        CameraScreenHintView cameraScreenHintView = this.K;
        if (cameraScreenHintView != null && cameraScreenHintView.getParent() != null) {
            CameraScreenHintView cameraScreenHintView2 = this.J;
            boolean z2 = true;
            boolean z3 = cameraScreenHintView2 == null || !cameraScreenHintView2.isShown();
            if (z3) {
                if (!CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_PI_AI)) {
                    com.oppo.camera.ui.preview.a aVar = this.af;
                    if (aVar != null && aVar.i()) {
                        z2 = false;
                    }
                    z3 = z2;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("showOrHideUpModeHintView, mAISceneUI.isShown: ");
                sb.append(!z3);
                sb.append(", mUpModeHintView.isShow: ");
                sb.append(this.K.isShown());
                com.oppo.camera.e.b("CameraUIManager", sb.toString());
            } else {
                com.oppo.camera.e.b("CameraUIManager", "showOrHideUpModeHintView, mUpHintView.isShown: true, mUpModeHintView.isShow: " + this.K.isShown());
            }
            if (z3 != this.K.isShown()) {
                if (!z3 || J() || cn() || ap()) {
                    this.K.a(false, false);
                } else {
                    this.K.a(cU());
                }
            }
        }
    }

    public void a(String str, int i2, int i3) {
        if (!this.l && !this.w.x() && !ap() && !H() && !cD()) {
            dU();
            this.K.a(str, true, false, 0, (int) R.color.screen_hint_text_color, cU());
        }
    }

    public void u(boolean z2) {
        CameraScreenHintView cameraScreenHintView = this.K;
        if (cameraScreenHintView != null) {
            if (z2) {
                this.I.removeView(cameraScreenHintView);
                this.K = null;
            } else if (cameraScreenHintView.getParent() != null) {
                this.K.c(false);
            }
        }
    }

    public void v(boolean z2) {
        com.oppo.camera.e.b("CameraUIManager", "showSuperEISWideSwitch, needAnimation: " + z2);
        if (this.I != null && !"off".equals(this.r.getString("pref_video_super_eis_key", "off")) && !H()) {
            if (this.ap == null) {
                dS();
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.i.getResources().getDimensionPixelSize(R.dimen.super_eis_switch_width), this.i.getResources().getDimensionPixelSize(R.dimen.super_eis_switch_height));
            layoutParams.addRule(20);
            layoutParams.addRule(2, R.id.control_panel_layout);
            layoutParams.setMarginStart(this.i.getResources().getDimensionPixelSize(R.dimen.super_eis_switch_margin_left));
            layoutParams.bottomMargin = this.i.getResources().getDimensionPixelOffset(R.dimen.super_eis_switch_margin_bottom);
            SwitchButton switchButton = this.ap;
            if (switchButton != null) {
                switchButton.a(this.r.getBoolean("pref_super_eis_wide_key", false), false);
                if (this.I.indexOfChild(this.ap) == -1) {
                    this.I.addView(this.ap, layoutParams);
                }
                if (z2) {
                    Util.a((View) this.ap, 0, (Animation.AnimationListener) null, 300);
                } else {
                    this.ap.setVisibility(0);
                }
            }
        }
    }

    private void dS() {
        com.oppo.camera.e.b("CameraUIManager", "initSuperEisSwitch");
        this.ap = (SwitchButton) this.i.getLayoutInflater().inflate(R.layout.super_eis_switch_button, (ViewGroup) null);
        this.ap.setVisibility(8);
        this.ap.setSwitchClickableListener(new SwitchButton.c() {
            public boolean a() {
                return g.this.x.F() && !g.this.ap.a();
            }
        });
        this.ap.setOnCheckedChangeListener(new SwitchButton.a() {
            public void a(SwitchButton switchButton, boolean z) {
                com.oppo.camera.e.a("CameraUIManager", "initSuperEisSwitch, onCheckedChanged, isChecked: " + z);
                g.this.x.f(z);
                g.this.az(z);
            }
        });
    }

    /* access modifiers changed from: private */
    public void az(boolean z2) {
        String str;
        if (!"off".equals(this.r.getString("pref_video_super_eis_key", "off"))) {
            if (z2) {
                str = this.i.getString(Util.d((int) R.string.camera_super_eis_pro));
            } else {
                str = this.i.getString(R.string.camera_super_eis);
            }
            a(str, 0, (int) R.color.screen_hint_text_color);
        }
    }

    public void w(boolean z2) {
        com.oppo.camera.e.b("CameraUIManager", "hideSuperEISWideSwitch, needAnimation: " + z2);
        if (this.I == null) {
            com.oppo.camera.e.e("CameraUIManager", "hideSuperEISWideSwitch, mCameraRootView is null");
            return;
        }
        SwitchButton switchButton = this.ap;
        if (switchButton != null) {
            if (z2) {
                Util.a((View) switchButton, 8, (Animation.AnimationListener) null, 300);
            } else {
                switchButton.setVisibility(8);
            }
            this.I.removeView(this.ap);
        }
    }

    public void x(boolean z2) {
        com.oppo.camera.e.b("CameraUIManager", "showTiltShiftSwitchUI, needAnimation: " + z2);
        if (this.I != null && this.x.ah() && !H() && !this.w.x()) {
            if (this.an == null) {
                dT();
            }
            com.oppo.camera.ui.menu.levelcontrol.a aVar = this.ak;
            if (aVar != null) {
                a("pref_tilt_shift_blur_menu", (com.oppo.camera.ui.menu.setting.t) aVar);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.i.getResources().getDimensionPixelSize(R.dimen.tilt_shift_control_width), this.i.getResources().getDimensionPixelSize(R.dimen.tilt_shift_control_hight));
            layoutParams.addRule(10);
            layoutParams.addRule(14);
            layoutParams.topMargin = this.i.getResources().getDimensionPixelSize(R.dimen.tilt_shift_margin_top);
            LinearLayout linearLayout = this.an;
            if (linearLayout != null) {
                if (this.I.indexOfChild(linearLayout) == -1) {
                    this.I.addView(this.an, layoutParams);
                }
                if (z2) {
                    Util.a((View) this.an, 0, (Animation.AnimationListener) null, 300);
                } else {
                    this.an.setVisibility(0);
                }
            }
        }
    }

    private void dT() {
        com.oppo.camera.e.b("CameraUIManager", "initTiltShiftSwitchUI");
        this.an = (LinearLayout) this.i.getLayoutInflater().inflate(R.layout.tilt_shift_control, (ViewGroup) null);
        this.an.setVisibility(8);
        this.ak = new com.oppo.camera.ui.menu.levelcontrol.a(this.i, this.aR);
        this.ak.setBlurType(1);
        this.al = (CheckableImageButton) this.an.findViewById(R.id.thit_shift_blur_button);
        this.al.setOnClickListener(this.aO);
        this.am = (CheckableImageButton) this.an.findViewById(R.id.tilt_shift_type_button);
        this.am.setOnCheckedChangeListener(new CheckableImageButton.a() {
            public void a(CheckableImageButton checkableImageButton, boolean z) {
                com.oppo.camera.e.a("CameraUIManager", "ShiftSwitchButton, onCheckedChanged, isChecked: " + z);
                g.this.x.c(z);
            }
        });
    }

    public void y(boolean z2) {
        com.oppo.camera.e.b("CameraUIManager", "hideTiltShiftSwitchUI, needAnimation: " + z2);
        if (this.I == null) {
            com.oppo.camera.e.e("CameraUIManager", "hideTiltShiftSwitchUI, mCameraRootView is null");
            return;
        }
        LinearLayout linearLayout = this.an;
        if (linearLayout != null) {
            if (z2) {
                Util.a((View) linearLayout, 8, (Animation.AnimationListener) null, 300);
            } else {
                linearLayout.setVisibility(8);
            }
            this.I.removeView(this.an);
        }
    }

    public boolean cD() {
        LinearLayout linearLayout = this.an;
        return linearLayout != null && linearLayout.getVisibility() == 0;
    }

    public boolean cE() {
        f fVar = this.x;
        return fVar != null && fVar.ah();
    }

    public void c(boolean z2, boolean z3, boolean z4) {
        com.oppo.camera.ui.menu.levelcontrol.a aVar;
        if (this.al != null && (aVar = this.ak) != null && aVar.h()) {
            this.ak.a(z2, z3, false, z4);
            this.al.setChecked(false);
        }
    }

    private void dU() {
        boolean z2;
        if (this.K == null) {
            com.oppo.camera.e.a("CameraUIManager", "addUpModeHintView");
            this.K = (CameraScreenHintView) this.i.getLayoutInflater().inflate(R.layout.camera_screen_hint, (ViewGroup) null);
            this.K.setChangeHintColor(true);
            z2 = true;
        } else {
            z2 = false;
        }
        if (this.K.getParent() == null) {
            CameraScreenHintView cameraScreenHintView = this.J;
            if (cameraScreenHintView != null) {
                ViewGroup viewGroup = this.I;
                viewGroup.addView(this.K, viewGroup.indexOfChild(cameraScreenHintView));
            } else {
                this.I.addView(this.K);
            }
            z2 = true;
        }
        if (z2) {
            this.K.getHintTextView().setVisibility(4);
            CameraScreenHintView cameraScreenHintView2 = this.K;
            cameraScreenHintView2.a(a(cameraScreenHintView2), 0, dn(), false);
            this.K.setOrientation(dp());
            return;
        }
        this.K.a(dn(), a(this.K));
    }

    /* access modifiers changed from: private */
    public void V(int i2) {
        com.oppo.camera.e.a("CameraUIManager", "exitFromMoreMode");
        if (!H()) {
            com.oppo.camera.e.b("CameraUIManager", "exitFromMoreMode, not in MoreMode");
        } else if (this.p.T()) {
            com.oppo.camera.e.b("CameraUIManager", "exitFromMoreMode, Multiple finger operation in Headline");
            this.p.p(false);
        } else {
            this.as.b(true);
            an(true);
            ao(true);
            f fVar = this.x;
            if (fVar != null) {
                fVar.f(i2);
            }
        }
    }

    public void d(boolean z2, boolean z3, boolean z4) {
        com.oppo.camera.ui.menu.setting.t tVar;
        com.oppo.camera.ui.menu.levelcontrol.a aVar = this.O;
        if (aVar != null && aVar.h()) {
            this.O.a(z2, z3, false, z4);
        }
        if (k(CameraFunction.VIDEO_BLUR_PROCESS) && this.v != null && this.x != null && (tVar = this.ae.get("pref_video_blur_menu")) != null) {
            this.v.b("pref_video_blur_menu", tVar.c());
        }
    }

    /* access modifiers changed from: private */
    public void aA(boolean z2) {
        if (this.x != null) {
            MenuClickMsgData menuClickMsgData = new MenuClickMsgData(this.i);
            menuClickMsgData.buildEvent(false);
            menuClickMsgData.mFuncKeyId = 2;
            menuClickMsgData.mCameraId = this.x.v();
            menuClickMsgData.mOrientation = this.z;
            menuClickMsgData.mCaptureType = bv() ^ true ? 1 : 0;
            menuClickMsgData.mCaptureMode = this.x.P();
            menuClickMsgData.mCameraEnterType = String.valueOf(this.y);
            if (z2) {
                menuClickMsgData.mFuncKeyResult = 1;
            } else {
                menuClickMsgData.mFuncKeyResult = 2;
            }
            menuClickMsgData.mRearOrFront = com.oppo.camera.f.a.c(menuClickMsgData.mCameraId) ? DcsMsgData.FRONT : DcsMsgData.REAR;
            menuClickMsgData.report();
        }
    }

    public void a(int i2, String str) {
        com.oppo.camera.ui.menu.levelcontrol.e eVar = this.N;
        if (eVar != null) {
            eVar.a(i2, str);
        }
    }

    private void dV() {
        if (this.as == null) {
            this.as = new com.oppo.camera.ui.modepanel.f(this.i, this.I, this.z);
            this.as.a((f.b) new f.b() {
                public void a(int i) {
                    com.oppo.camera.e.a("CameraUIManager", "onModeItemClick, itemId: " + i);
                    if (!g.this.X(i)) {
                        boolean z = 3 == i;
                        boolean c = com.oppo.camera.f.a.c(g.this.bB());
                        if (g.this.as != null) {
                            if (g.this.p.a() || !g.this.x.F() || g.this.x.as()) {
                                return;
                            }
                            if (!z) {
                                g.this.as.b(false);
                            }
                        }
                        if (g.this.x != null) {
                            g.this.x.c(i);
                        }
                        g.this.aC(false);
                        g.this.aB(true);
                        g.this.d(z ? 0.0f : 1.0f);
                        com.oppo.camera.ui.inverse.c.INS.setMaskAlpha(g.this.i, true, true);
                        com.oppo.camera.ui.inverse.c.INS.setExecuteDelayMsg(true);
                        g.this.p.s(false);
                        if (2 == i && !c) {
                            androidx.preference.j.a((Context) g.this.i).edit().putBoolean("slow_video_high_frame_reddot_show", false).apply();
                        } else if (13 == i) {
                            androidx.preference.j.a((Context) g.this.i).edit().putBoolean("id_photo_reddot_show", false).apply();
                        } else if (14 == i) {
                            androidx.preference.j.a((Context) g.this.i).edit().putBoolean("multi_video_reddot_show", false).apply();
                        } else if (4 == i) {
                            androidx.preference.j.a((Context) g.this.i).edit().putBoolean("profession_reddot_show", false).apply();
                        } else if (18 == i) {
                            androidx.preference.j.a((Context) g.this.i).edit().putBoolean("double_exposure_reddot_show", false).apply();
                        } else if (1 == i && !c) {
                            androidx.preference.j.a((Context) g.this.i).edit().putBoolean("timelapse_tiltshift_reddot_show", false).apply();
                        }
                    }
                }

                public void a() {
                    g.this.aO();
                }

                public void b() {
                    g.this.aN();
                }

                public void c() {
                    g.this.V(-1);
                }
            });
        }
    }

    private void dW() {
        com.oppo.camera.ui.preview.a aVar = this.af;
        if (aVar != null) {
            aVar.g();
            cx();
        }
    }

    /* access modifiers changed from: private */
    public void aB(boolean z2) {
        if (this.v != null) {
            com.oppo.camera.e.a("CameraUIManager", "showSettingMenu");
            this.v.i();
        }
        com.oppo.camera.ui.menu.setting.f fVar = this.w;
        if (fVar != null && !z2) {
            fVar.i();
        }
    }

    public void an(boolean z2) {
        if (this.p != null) {
            com.oppo.camera.e.a("CameraUIManager", "backToLastHeadlineIndex");
            this.p.i(z2);
        }
    }

    public boolean cF() {
        com.oppo.camera.ui.control.b bVar = this.p;
        if (bVar != null) {
            return bVar.n();
        }
        return false;
    }

    public void cG() {
        d(true, false);
        i(true);
        if (this.x.g(CameraFunction.FACE_BEAUTY_PROCESS)) {
            r(false);
        }
    }

    /* access modifiers changed from: private */
    public void aC(boolean z2) {
        CameraScreenHintView cameraScreenHintView = this.J;
        if (cameraScreenHintView != null) {
            cameraScreenHintView.setMoreMode(z2);
        }
        CameraScreenHintView cameraScreenHintView2 = this.K;
        if (cameraScreenHintView2 != null) {
            cameraScreenHintView2.setMoreMode(z2);
        }
        CameraScreenHintView cameraScreenHintView3 = this.L;
        if (cameraScreenHintView3 != null) {
            cameraScreenHintView3.setMoreMode(z2);
        }
        CameraScreenHintView cameraScreenHintView4 = this.M;
        if (cameraScreenHintView4 != null) {
            cameraScreenHintView4.setMoreMode(z2);
        }
        CameraScreenHintView cameraScreenHintView5 = this.S;
        if (cameraScreenHintView5 != null) {
            cameraScreenHintView5.setMoreMode(z2);
        }
    }

    public boolean cH() {
        com.oppo.camera.ui.modepanel.f fVar = this.as;
        return fVar != null && fVar.d();
    }

    public float cI() {
        p pVar = this.v;
        if (pVar != null) {
            return pVar.w();
        }
        return 1.0f;
    }

    public void F(int i2) {
        if (this.as != null) {
            com.oppo.camera.e.a("CameraUIManager", "showMoreView");
            this.as.d(i2);
        }
    }

    public void cJ() {
        if (this.as != null) {
            com.oppo.camera.e.a("CameraUIManager", "hideMoreView");
            this.as.b(true);
        }
    }

    public void cK() {
        com.oppo.camera.e.a("CameraUIManager", "onMoreModeShown");
        aC(true);
        p pVar = this.v;
        if (pVar != null) {
            pVar.b(false);
        }
        a(ApsConstant.REC_MODE_COMMON, "key_bubble_type_ai_enhancement_video", 7);
        a(ApsConstant.CAPTURE_MODE_COMMON, "key_bubble_type_zoom_ultra_wide", 9);
        W(false);
        h();
        bu();
        dW();
        a(false);
        u(false);
        a(true, true, false);
        n(false);
        a(true, true, false, false);
        i(false);
        D(false);
        y(false);
        com.oppo.camera.ui.control.b bVar = this.p;
        if (bVar != null) {
            bVar.i(false, true);
            com.oppo.camera.ui.inverse.c.INS.setExecuteDelayMsg(false);
            if (com.oppo.camera.ui.inverse.c.INS.isInverseColor(this.i.hashCode())) {
                com.oppo.camera.ui.inverse.c.INS.setMaskAlpha(this.i, false, true);
                this.p.s(true);
            }
        }
        w(false);
        if (J()) {
            K();
        }
        c(dY(), 2);
        c(ed(), 1);
        c(dZ(), 13);
        c(ea(), 14);
        c(eb(), 4);
        c(ec(), 18);
    }

    private void a(String str, String str2, int i2) {
        f fVar;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && (fVar = this.x) != null && str.equals(fVar.P()) && v(str2)) {
            c(i2, true);
        }
    }

    private void c(boolean z2, int i2) {
        if (z2) {
            h(i2, (int) R.drawable.sticker_red_point);
        } else {
            o(i2);
        }
    }

    public void ao(boolean z2) {
        aC(false);
        aB(false);
        d(true, false);
        i(true);
        com.oppo.camera.ui.inverse.c.INS.setExecuteDelayMsg(true);
        if (com.oppo.camera.ui.inverse.c.INS.isInverseColor(this.i.hashCode())) {
            com.oppo.camera.ui.inverse.c.INS.setMaskAlpha(this.i, true, true);
            this.p.s(false);
        }
        f fVar = this.x;
        if (fVar != null && fVar.g(CameraFunction.FACE_BEAUTY_PROCESS) && z2 && this.x.aA()) {
            r(false);
        }
        if (D()) {
            a(true, false, false);
        }
        f fVar2 = this.x;
        if (fVar2 != null && fVar2.g(CameraFunction.KEY_VIDEO_SUPER_EIS_WIDE)) {
            v(false);
        }
        f fVar3 = this.x;
        if (fVar3 != null && fVar3.ah()) {
            x(false);
        }
        if (dQ()) {
            E();
        } else {
            F();
        }
    }

    private void dX() {
        if (S() && androidx.preference.j.a((Context) this.i).getBoolean("video_mode_reddot_show", true)) {
            c(R.string.camera_mode_video);
        }
        if (ee()) {
            c(R.string.camera_mode_more);
        }
    }

    private boolean dY() {
        if (this.r == null || !CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SLOW_VIDEO_RED_DOT_SUPPORT) || com.oppo.camera.f.a.c(Integer.parseInt(this.r.getString("pref_camera_id_key", String.valueOf(0)))) || !androidx.preference.j.a((Context) this.i).getBoolean("slow_video_high_frame_reddot_show", true)) {
            return false;
        }
        return true;
    }

    private boolean dZ() {
        if (!CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_ID_PHOTO) || !Util.o(this.i)) {
            return false;
        }
        androidx.preference.j.a((Context) this.i).getBoolean("id_photo_reddot_show", true);
        return false;
    }

    private boolean ea() {
        if (!CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_MULTI_VIDEO_MODE_SUPPORT) || !androidx.preference.j.a((Context) this.i).getBoolean("multi_video_reddot_show", true)) {
            return false;
        }
        return true;
    }

    private boolean eb() {
        if (!CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_PROFESSIONAL_SUPER_RAW) || !androidx.preference.j.a((Context) this.i).getBoolean("profession_reddot_show", true)) {
            return false;
        }
        return true;
    }

    private boolean ec() {
        if (!CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_DOUBLE_EXPOSURE_SUPPORT) || !androidx.preference.j.a((Context) this.i).getBoolean("double_exposure_reddot_show", true)) {
            return false;
        }
        return true;
    }

    private boolean ed() {
        if (!AlgoSwitchConfig.getSupportCaptureAlgo(ApsConstant.REC_MODE_FAST_VIDEO, bB(), ParameterKeys.ALGO_NAME_TILT_SHIFT) || !androidx.preference.j.a((Context) this.i).getBoolean("timelapse_tiltshift_reddot_show", true)) {
            return false;
        }
        return true;
    }

    private boolean ee() {
        if (!(dY() || dZ() || ea() || eb() || ec() || ed()) || !androidx.preference.j.a((Context) this.i).getBoolean("more_menu_reddot_show", true)) {
            return false;
        }
        return true;
    }

    public boolean T() {
        if (!CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_MULTI_VIDEO_MODE_SUPPORT) || !androidx.preference.j.a((Context) this.i).getBoolean("multi_video_setting_menu_reddot_show", false)) {
            return false;
        }
        return true;
    }

    public boolean U() {
        if (!CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_PROFESSIONAL_SUPER_RAW) || !androidx.preference.j.a((Context) this.i).getBoolean("super_raw_setting_menu_reddot_show", true)) {
            return false;
        }
        return true;
    }

    public boolean S() {
        if (!androidx.preference.j.a((Context) this.i).getBoolean("video_retention_filter_reddot_show", true) || !CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_VIDEO_RETENTION_SUPPORT)) {
            return false;
        }
        return true;
    }

    public boolean R() {
        if (!androidx.preference.j.a((Context) this.i).getBoolean("portrait_filter_reddot_show", true) || !ef()) {
            return false;
        }
        return true;
    }

    public boolean V() {
        if (!AlgoSwitchConfig.getSupportCaptureAlgo(ApsConstant.REC_MODE_FAST_VIDEO, 0, ParameterKeys.ALGO_NAME_TILT_SHIFT) || !androidx.preference.j.a((Context) this.i).getBoolean("timelapse_tiltshift_menu_reddot_show", true)) {
            return false;
        }
        return true;
    }

    private boolean ef() {
        if (com.oppo.camera.f.a.c(bB())) {
            return CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_PORTRAIT_FRONT_RETENTION_SUPPORT) && CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_PORTRAIT_RETENTION_SUPPORT);
        }
        return CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_PORTRAIT_RETENTION_SUPPORT);
    }

    public void cL() {
        this.p.ac();
    }

    public boolean cM() {
        com.oppo.camera.ui.modepanel.f fVar = this.as;
        if (fVar != null) {
            return fVar.b();
        }
        return false;
    }

    public boolean I() {
        com.oppo.camera.ui.modepanel.f fVar = this.as;
        return fVar != null && fVar.c();
    }

    public boolean cN() {
        com.oppo.camera.ui.menu.levelcontrol.e eVar = this.N;
        if (eVar != null) {
            return eVar.g();
        }
        return false;
    }

    public void cO() {
        com.oppo.camera.ui.menu.levelcontrol.e eVar = this.N;
        if (eVar != null) {
            eVar.f();
        }
    }

    public boolean cP() {
        com.oppo.camera.ui.preview.f fVar = this.u;
        if (fVar != null) {
            return fVar.g();
        }
        return false;
    }

    public boolean cQ() {
        com.oppo.camera.ui.control.b bVar = this.p;
        return bVar != null && bVar.ak();
    }

    public boolean H() {
        return cQ() && cH();
    }

    public boolean L() {
        CameraScreenHintView cameraScreenHintView = this.M;
        return cameraScreenHintView == null || cameraScreenHintView.getHintTextView().getVisibility() != 0;
    }

    public void A(boolean z2) {
        f fVar = this.x;
        if (fVar != null) {
            fVar.d(z2);
        }
    }

    public void ap(boolean z2) {
        f fVar = this.x;
        if (fVar != null) {
            fVar.e(z2);
        }
    }

    public void cR() {
        com.oppo.camera.ui.menu.levelcontrol.e eVar = this.N;
        if (eVar != null) {
            eVar.n();
        }
    }

    public void B(boolean z2) {
        if (this.k || this.j) {
            com.oppo.camera.e.d("CameraUIManager", "updateDimHintView, mbShowCapAlert: " + this.k + ", mbShowVideoAlert: " + this.j);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (!z2) {
            if (currentTimeMillis - this.F < 3000) {
                com.oppo.camera.e.a("CameraUIManager", "updateDimHintView, hideDimScreenHint");
                b((int) R.string.camera_dark_environment_open_flash_toast);
            }
        } else if (currentTimeMillis - this.F > 60000 && this.x.ar() && currentTimeMillis - this.H >= 3000) {
            if ((!k("key_support_show_low_ambient_light_hint") || currentTimeMillis - this.H <= 60000) && currentTimeMillis - this.G >= 3000) {
                com.oppo.camera.e.a("CameraUIManager", "updateDimHintView, showDimScreenHint");
                this.F = currentTimeMillis;
                com.oppo.camera.ui.widget.d dVar = this.ab;
                if (dVar != null && dVar.isShowing()) {
                    this.ab.dismiss();
                }
                a((int) R.string.camera_dark_environment_open_flash_toast, -1, true, false, false);
                this.x.a(ReminderMsgData.TYPE_ADVICE, ReminderMsgData.CODE_FLASH_ON);
            }
        }
    }

    public void M() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.H > 60000 && currentTimeMillis - this.F >= 3000 && currentTimeMillis - this.G >= 3000 && !cn()) {
            com.oppo.camera.e.a("CameraUIManager", "updateDimHintView, showDimScreenHint");
            this.H = currentTimeMillis;
            com.oppo.camera.ui.widget.d dVar = this.ab;
            if (dVar != null && dVar.isShowing()) {
                this.ab.dismiss();
            }
            a((int) R.string.camera_ai_video_low_ambient_light_hint, -1, true, false, false);
        }
    }

    public void N() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.G > 60000 && currentTimeMillis - this.F >= 3000 && currentTimeMillis - this.H >= 3000 && !cn()) {
            com.oppo.camera.e.a("CameraUIManager", "updateDimHintView, showDimScreenHint");
            this.G = currentTimeMillis;
            com.oppo.camera.ui.widget.d dVar = this.ab;
            if (dVar != null && dVar.isShowing()) {
                this.ab.dismiss();
            }
            a((int) R.string.camera_ai_video_back_light_hint, -1, true, false, false);
        }
    }

    public boolean O() {
        if (this.k || this.j) {
            com.oppo.camera.e.d("CameraUIManager", "showDirtyLensHintView, mbShowCapAlert or mbShowVideoAlert return");
            return false;
        }
        CameraScreenHintView cameraScreenHintView = this.S;
        if (cameraScreenHintView == null || !cameraScreenHintView.isShown()) {
            a((int) R.string.camera_toast_clean_lens_suggestion, -1, true, false, false);
            this.x.a(ReminderMsgData.TYPE_ADVICE, ReminderMsgData.CODE_CLEAN_LENS);
            return true;
        }
        com.oppo.camera.e.d("CameraUIManager", "showDirtyLensHintView, mbShowCapAlert return");
        return false;
    }

    public void f(int i2, boolean z2) {
        com.oppo.camera.ui.preview.a aVar = this.af;
        if (aVar != null) {
            aVar.a(i2, z2);
        }
    }

    public boolean G(int i2) {
        com.oppo.camera.ui.preview.a aVar = this.af;
        if (aVar != null) {
            return aVar.c(i2);
        }
        return false;
    }

    public int P() {
        com.oppo.camera.ui.preview.a aVar = this.af;
        if (aVar != null) {
            return aVar.e();
        }
        return 67108863;
    }

    public boolean H(int i2) {
        f fVar;
        if (i2 != 4) {
            if (i2 != 5) {
                if (i2 == 12) {
                    String string = this.r.getString("pref_camera_flashmode_key", this.i.getString(R.string.camera_flash_mode_default_value));
                    if (TextUtils.equals("on", string) || TextUtils.equals("torch", string) || (((fVar = this.x) != null && !fVar.E()) || TextUtils.equals("on", this.r.getString("pref_camera_hdr_mode_key", CameraConfig.getOptionKeyDefaultValue("pref_camera_hdr_mode_key", bB()))))) {
                        return false;
                    }
                    return true;
                } else if (i2 != 18) {
                    if (i2 != 19) {
                        return true;
                    }
                    if (!TextUtils.equals("off", this.r.getString("pref_camera_hdr_mode_key", CameraConfig.getOptionKeyDefaultValue("pref_camera_hdr_mode_key", bB())))) {
                        return false;
                    }
                    String string2 = this.r.getString("pref_camera_flashmode_key", this.i.getString(R.string.camera_flash_mode_default_value));
                    if (TextUtils.equals("on", string2) || TextUtils.equals("torch", string2)) {
                        return false;
                    }
                    return true;
                }
            }
            return false;
        }
        f fVar2 = this.x;
        if (fVar2 != null) {
            return fVar2.E();
        }
        return true;
    }

    public void C(boolean z2) {
        com.oppo.camera.ui.preview.a aVar = this.af;
        if (aVar != null) {
            aVar.a(z2);
        }
    }

    public void a(String str, String str2, String str3) {
        String b2 = com.oppo.camera.entry.b.b(str, this.y);
        p pVar = this.v;
        if (pVar != null) {
            pVar.a(b2, str2, str3);
        }
    }

    public void cS() {
        com.oppo.camera.ui.preview.a aVar = this.af;
        if (aVar != null) {
            aVar.d();
        }
    }

    public void c(MotionEvent motionEvent) {
        com.oppo.camera.ui.menu.setting.f fVar;
        this.af.a(motionEvent);
        if (motionEvent.getAction() == 0) {
            at(true);
        } else if (3 == motionEvent.getAction() && (fVar = this.w) != null) {
            fVar.c(false);
        }
    }

    public void aq(boolean z2) {
        com.oppo.camera.ui.a.a aVar = this.o;
        if (aVar != null) {
            aVar.a(z2);
        }
    }

    public void a(String str, String str2, String str3, int i2, int i3) {
        p pVar = this.v;
        if (pVar != null) {
            pVar.a(str, str2, str3, i2, i3);
        }
    }

    public void u(String str) {
        p pVar = this.v;
        if (pVar != null) {
            pVar.g(str);
        }
    }

    public void a(String str, String str2, String str3, String str4, int i2, int i3) {
        p pVar = this.v;
        if (pVar != null) {
            pVar.a(str, str2, str3, str4, i2, i3);
        }
    }

    public void a(String str, boolean z2, int i2, int i3) {
        p pVar = this.v;
        if (pVar != null) {
            pVar.a(str, z2, i2, i3);
        }
        com.oppo.camera.ui.menu.setting.f fVar = this.w;
        if (fVar != null) {
            fVar.a(str, z2, i2, i3);
        }
    }

    public void E() {
        String str;
        com.oppo.camera.e.b("CameraUIManager", "showVideoEisHint");
        if (this.I != null && !this.l && !"off".equals(this.r.getString("pref_video_super_eis_key", "off"))) {
            if (!k(CameraFunction.KEY_VIDEO_SUPER_EIS_WIDE) || !this.r.getBoolean("pref_super_eis_wide_key", false)) {
                str = this.i.getString(R.string.camera_super_eis);
            } else {
                str = this.i.getString(Util.d((int) R.string.camera_super_eis_pro));
            }
            a(true, false, false);
            a(str, 0, (int) R.color.screen_hint_text_color);
        }
    }

    public void F() {
        com.oppo.camera.e.b("CameraUIManager", "hideVideoEisHint");
        if (this.I == null) {
            com.oppo.camera.e.e("CameraUIManager", "hideVideoEisHint, mCameraRootView is null");
            return;
        }
        c(Util.d((int) R.string.camera_super_eis_pro));
        c((int) R.string.camera_super_eis);
    }

    public void ar(boolean z2) {
        com.oppo.camera.ui.preview.d dVar = this.q;
        if (dVar != null) {
            dVar.i(z2);
        }
    }

    public boolean cT() {
        f fVar = this.x;
        return fVar != null && fVar.ax();
    }

    public boolean cU() {
        f fVar = this.x;
        return fVar != null && fVar.ay();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r0 = r3.r;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean cV() {
        /*
            r3 = this;
            boolean r0 = r3.cU()
            if (r0 == 0) goto L_0x001c
            com.oppo.camera.k r0 = r3.r
            if (r0 == 0) goto L_0x001c
            java.lang.String r1 = "pref_film_video_guide_line"
            java.lang.String r2 = "off"
            java.lang.String r0 = r0.getString(r1, r2)
            java.lang.String r1 = "grid"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x001c
            r0 = 1
            goto L_0x001d
        L_0x001c:
            r0 = 0
        L_0x001d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.ui.g.cV():boolean");
    }

    public float cW() {
        f fVar = this.x;
        if (fVar != null) {
            return fVar.az();
        }
        return 1.0f;
    }

    public void I(int i2) {
        com.oppo.camera.e.b("CameraUIManager", "onMultiCameraTypeChanged: " + i2);
        if (this.x != null) {
            W(i2);
            this.x.i(i2);
        }
    }

    private void W(int i2) {
        MenuClickMsgData menuClickMsgData = new MenuClickMsgData(this.i);
        menuClickMsgData.buildEvent(true);
        menuClickMsgData.mCaptureMode = this.x.P();
        menuClickMsgData.mCameraId = this.x.v();
        menuClickMsgData.mFuncKeyId = 54;
        menuClickMsgData.mItemValue = String.valueOf(i2);
        menuClickMsgData.mCaptureType = this.x.p() ^ true ? 1 : 0;
        menuClickMsgData.report();
    }

    public boolean cX() {
        f fVar = this.x;
        return fVar != null && fVar.aD();
    }

    public void a(com.oppo.camera.doubleexposure.f fVar) {
        f fVar2 = this.x;
        if (fVar2 != null) {
            fVar2.a(fVar);
        }
    }

    public void cY() {
        f fVar = this.x;
        if (fVar != null) {
            fVar.aK();
        }
    }

    public boolean cZ() {
        f fVar = this.x;
        if (fVar != null) {
            return fVar.aL();
        }
        return true;
    }

    public void r(int i2) {
        a("key_multicamera_type_menu_key", "on".equals(this.r.getString("key_multicamera_type_menu_key", this.i.getString(R.string.camera_multicamera_type_default))) ? R.drawable.multi_video_type_menu_selected : R.drawable.multi_video_type_menu_normal);
    }

    public boolean D() {
        CameraScreenHintView cameraScreenHintView = this.J;
        if (cameraScreenHintView != null) {
            return cameraScreenHintView.h();
        }
        return false;
    }

    public void as(boolean z2) {
        CameraScreenHintView cameraScreenHintView = this.J;
        if (cameraScreenHintView != null) {
            cameraScreenHintView.setLDAFShowed(z2);
        }
    }

    public boolean da() {
        com.oppo.camera.ui.menu.setting.f fVar = this.w;
        if (fVar != null) {
            return fVar.l();
        }
        return false;
    }

    public boolean ap() {
        com.oppo.camera.ui.menu.setting.f fVar = this.w;
        return fVar != null && fVar.q();
    }

    public boolean db() {
        com.oppo.camera.ui.menu.setting.f fVar = this.w;
        if (fVar != null) {
            return fVar.m();
        }
        return false;
    }

    public boolean dc() {
        com.oppo.camera.ui.menu.setting.f fVar = this.w;
        if (fVar != null) {
            return fVar.n();
        }
        return false;
    }

    public void dd() {
        com.oppo.camera.ui.menu.setting.f fVar = this.w;
        if (fVar != null) {
            fVar.i();
        }
    }

    public void an() {
        com.oppo.camera.ui.control.b bVar = this.p;
        if (bVar != null) {
            bVar.aj();
        }
    }

    public boolean de() {
        com.oppo.camera.ui.control.b bVar = this.p;
        if (bVar != null) {
            return bVar.ap();
        }
        return false;
    }

    public void F(boolean z2) {
        int i2;
        com.oppo.camera.e.b("CameraUIManager", "showSlowVideoModeSeekBar, needAnimation: " + z2);
        if (!this.l && !"off".equals(this.r.getString("key_slow_video_frame_seek_bar_menu_key", this.i.getString(R.string.camera_slow_video_mode_frame_default_value))) && !H()) {
            if (this.ax == null) {
                this.ax = new com.oppo.camera.ui.widget.c(this.i);
                this.ax.setOnTouchListener(new View.OnTouchListener() {
                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        if (g.this.aM == null || g.this.l) {
                            return false;
                        }
                        g.this.aM.removeMessages(4);
                        g.this.aM.sendMessageDelayed(g.this.aM.obtainMessage(4), 5000);
                        return false;
                    }
                });
                this.ax.setModeFrameChangeListener(new b());
                ArrayList arrayList = new ArrayList();
                arrayList.add(new c.a(120, this.i.getString(R.string.camera_intelligent_high_frame_slow_1080p)));
                arrayList.add(new c.a(240, this.i.getString(R.string.camera_intelligent_high_frame_slow_720p)));
                arrayList.add(new c.a(480, this.i.getString(R.string.camera_intelligent_high_frame_super_1080p)));
                arrayList.add(new c.a(960, this.i.getString(R.string.camera_intelligent_high_frame_super_720p)));
                this.ax.setFrameList(arrayList);
            }
            String string = this.r.getString("pref_slow_video_size_key", (!com.oppo.camera.f.a.c(bB()) || !CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_FRONT_SLOW_VIDEO)) ? "video_size_720p" : "video_size_1080p");
            if ("video_size_1080p".equals(string)) {
                i2 = CameraConfig.getConfigIntValue(ConfigDataBase.KEY_SLOW_VIDEO_1080P_DEFAULT_VALUE);
            } else {
                i2 = "video_size_720p".equals(string) ? CameraConfig.getConfigIntValue(ConfigDataBase.KEY_SLOW_VIDEO_720P_DEFAULT_VALUE) : 0;
            }
            this.ax.a(this.r.getInt("pref_slow_video_rear_fps_key", i2));
            this.ax.a(this.z, false);
            RelativeLayout E2 = this.q.E();
            int dimensionPixelSize = this.i.getResources().getDimensionPixelSize(R.dimen.slow_video_seekbar_width);
            int dimensionPixelSize2 = this.i.getResources().getDimensionPixelSize(R.dimen.slow_video_seekbar_height);
            int height = E2.getHeight() - (this.p.R().getTop() - E2.getTop());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize2);
            layoutParams.addRule(14);
            layoutParams.addRule(12);
            layoutParams.setMargins(0, 0, 0, height);
            this.ax.setLayoutParams(layoutParams);
            if (E2.indexOfChild(this.ax) < 0) {
                E2.addView(this.ax, E2.indexOfChild(E2.findViewById(R.id.slow_video_motion_detect_view)) - 1);
            }
            if (z2) {
                Util.a((View) this.ax, 0, (Animation.AnimationListener) null, 300);
            } else {
                this.ax.setVisibility(0);
            }
            this.aM.removeMessages(4);
            this.aM.sendMessageDelayed(this.aM.obtainMessage(4), 5000);
            this.p.r(false);
        }
    }

    public void E(boolean z2) {
        com.oppo.camera.ui.widget.c cVar;
        com.oppo.camera.e.b("CameraUIManager", "hideSlowVideoModeSeekBar, needAnimation: " + z2);
        this.aM.removeMessages(4);
        if (!(this.I == null || (cVar = this.ax) == null)) {
            if (z2) {
                Util.a((View) cVar, 8, (Animation.AnimationListener) null, 300);
            } else {
                cVar.setVisibility(8);
            }
            this.I.removeView(this.ax);
        }
        this.p.r(true);
    }

    public void df() {
        com.oppo.camera.e.b("CameraUIManager", "hideSlowVideoSeekBarBySharedPreference");
        this.r.edit().putString("key_slow_video_frame_seek_bar_menu_key", "off").apply();
        f("key_slow_video_frame_seek_bar_menu_key");
    }

    public boolean dg() {
        com.oppo.camera.ui.widget.c cVar = this.ax;
        return cVar != null && cVar.getVisibility() == 0;
    }

    /* compiled from: CameraUIManager */
    private class b implements c.b {
        private boolean a(int i) {
            return 480 == i || 960 == i;
        }

        private b() {
        }

        public void onSlowVideoFrameChange(int i) {
            com.oppo.camera.e.b("CameraUIManager", "onFrameChange, frame: " + i);
            if (g.this.cT()) {
                g.this.q(i);
            }
            g.this.x.h(i);
            String string = g.this.r.getString("pref_intelligent_high_frame_selected_key", g.this.i.getString(R.string.camera_intelligent_high_frame_default_selected));
            String string2 = g.this.r.getString("pref_temp_intelligent_high_frame_selected_key", "");
            if (!a(i)) {
                if (!TextUtils.isEmpty(string2)) {
                    g.this.r.edit().putString("pref_intelligent_high_frame_selected_key", "off").apply();
                }
                g.this.a("pref_intelligent_high_frame_selected_key", "off");
            } else if (!TextUtils.isEmpty(string2)) {
                g.this.b("pref_intelligent_high_frame_selected_key", string2);
            } else {
                g.this.b("pref_intelligent_high_frame_selected_key", string);
                g.this.r.edit().putString("pref_temp_intelligent_high_frame_selected_key", string).apply();
            }
        }
    }

    public void q(int i2) {
        int i3;
        String str;
        if (120 == i2) {
            i3 = R.drawable.frame_120;
            str = this.i.getString(R.string.camera_intelligent_high_frame_slow_selected);
        } else if (240 == i2) {
            i3 = R.drawable.frame_240;
            str = this.i.getString(R.string.camera_intelligent_high_frame_slow_selected);
        } else if (480 == i2) {
            i3 = R.drawable.frame_480;
            str = this.i.getString(R.string.camera_intelligent_high_frame_super_selected);
        } else if (960 == i2) {
            i3 = R.drawable.frame_960;
            str = this.i.getString(R.string.camera_intelligent_high_frame_super_selected);
        } else {
            str = "";
            i3 = 0;
        }
        a("key_slow_video_frame_seek_bar_menu_key", i3);
        a(str, 0, (int) R.color.screen_hint_text_color);
    }

    public void p(int i2) {
        com.oppo.camera.ui.preview.d dVar = this.q;
        if (dVar != null) {
            dVar.f(i2);
        }
    }

    public void G(boolean z2) {
        com.oppo.camera.ui.preview.d dVar = this.q;
        if (dVar != null) {
            dVar.k(z2);
        }
    }

    public RectF J(int i2) {
        com.oppo.camera.ui.preview.d dVar = this.q;
        if (dVar != null) {
            return dVar.g(i2);
        }
        return null;
    }

    public CameraMenuOption i(String str) {
        return this.v.f(str);
    }

    public void j(int i2, int i3) {
        f fVar = this.x;
        if (fVar != null) {
            fVar.d(i2, i3);
        }
    }

    public boolean k(int i2, int i3) {
        f fVar = this.x;
        return fVar != null && fVar.e(i2, i3);
    }

    public boolean v(String str) {
        com.oppo.camera.k kVar = this.r;
        if (kVar != null) {
            return kVar.getBoolean(str, true);
        }
        com.oppo.camera.e.e("CameraUIManager", "isBubbleOpen, mPreference null");
        return false;
    }

    public void am() {
        this.x.a("pref_filter_menu", false, false, false);
    }

    public void al() {
        com.oppo.camera.e.b("CameraUIManager", "hideMultiCameraTypeLayoutBySharedPreference");
        this.r.edit().putString("key_multicamera_type_menu_key", "off").apply();
        f("key_multicamera_type_menu_key");
    }

    public boolean ak() {
        com.oppo.camera.ui.preview.d dVar = this.q;
        return dVar != null && dVar.ah();
    }

    public void b(int i2, int i3) {
        com.oppo.camera.ui.preview.e c = c();
        if (c != null) {
            c.e(i2, i3);
        }
    }

    public Rect aj() {
        com.oppo.camera.ui.preview.e c = c();
        if (c != null) {
            return c.x();
        }
        return null;
    }

    public void s(int i2) {
        com.oppo.camera.ui.preview.e c = c();
        if (c != null) {
            c.d(i2);
        }
    }

    public void H(boolean z2) {
        com.oppo.camera.ui.preview.e c = c();
        if (c != null) {
            c.l(z2);
        }
    }

    public void c(int i2, int i3) {
        com.oppo.camera.ui.preview.e c = c();
        if (c != null) {
            c.d(i2, i3);
        }
    }

    public void I(boolean z2) {
        com.oppo.camera.ui.preview.d dVar = this.q;
        if (dVar != null && dVar.D() != null) {
            this.q.D().e(z2);
        }
    }

    /* access modifiers changed from: private */
    public boolean X(int i2) {
        if (cF()) {
            com.oppo.camera.e.a("CameraUIManager", "onModeItemClick, headline is scrolling, can't response");
            return true;
        } else if (17 != i2) {
            return false;
        } else {
            this.s.a(this.i, this.x, this.z);
            this.s.a(bB(), this.x.aw().m());
            return true;
        }
    }

    public void dh() {
        com.oppo.camera.l.a aVar = this.aw;
        if (aVar != null) {
            aVar.b();
        }
    }

    public boolean as() {
        return this.aA;
    }

    public void at(boolean z2) {
        this.aA = z2;
    }

    public void av() {
        this.aB = false;
        this.aC = false;
        this.aD = false;
        this.i.runOnUiThread(new Runnable() {
            public final void run() {
                g.this.ep();
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void ep() {
        this.p.z();
        this.q.an();
        this.x.b(false, true);
        A(false);
    }

    public void at() {
        this.aB = false;
        this.aD = false;
        this.i.runOnUiThread(new Runnable() {
            public final void run() {
                g.this.eo();
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void eo() {
        this.p.w();
        this.q.a(this.x.aJ(), (View) this.q.ao(), true);
    }

    public void au() {
        this.aB = false;
        this.aD = false;
        this.i.runOnUiThread(new Runnable() {
            public final void run() {
                g.this.en();
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void en() {
        this.p.y();
        this.q.a(this.x.aJ(), (View) this.q.ao(), true);
        A(true);
    }

    public void aw() {
        this.aB = true;
        this.aC = false;
        this.aD = false;
        this.i.runOnUiThread(new Runnable() {
            public final void run() {
                g.this.em();
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void em() {
        this.p.x();
        ai(true);
        com.oppo.camera.ui.preview.d dVar = this.q;
        dVar.a((View) dVar.ao(), this.x.aJ(), true);
        A(false);
    }

    public void ax() {
        this.aC = true;
        this.aD = true;
        this.i.runOnUiThread(new Runnable() {
            public final void run() {
                g.this.el();
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void el() {
        this.p.A();
        ah(true);
        this.q.a(this.x.aJ(), (View) this.q.ao(), true);
        A(true);
    }

    public void J(boolean z2) {
        this.i.runOnUiThread(new Runnable(z2) {
            private final /* synthetic */ boolean f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                g.this.aD(this.f$1);
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void aD(boolean z2) {
        this.p.B();
        this.q.a(z2 ? this.x.aJ() : this.q.ao(), !z2 ? this.x.aJ() : this.q.ao(), true);
    }

    public void ay() {
        this.aB = false;
        this.aC = true;
        this.aD = true;
        this.i.runOnUiThread(new Runnable() {
            public final void run() {
                g.this.ek();
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void ek() {
        this.p.C();
        ah(true);
        this.q.a(this.x.aJ(), (View) this.q.ao(), true);
        A(false);
    }

    public void az() {
        this.aB = true;
        this.aC = false;
        this.aD = false;
        this.i.runOnUiThread(new Runnable() {
            public final void run() {
                g.this.ej();
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void ej() {
        this.p.D();
        com.oppo.camera.ui.preview.d dVar = this.q;
        dVar.a((View) dVar.ao(), this.x.aJ(), true);
        A(false);
    }

    public void m(boolean z2, boolean z3) {
        com.oppo.camera.ui.control.b bVar = this.p;
        if (bVar != null) {
            bVar.c(z2, z3);
        }
    }

    public void di() {
        this.p.e();
    }

    public void w(String str) {
        com.oppo.camera.doubleexposure.g gVar = this.aE;
        if (gVar != null && gVar.a(str)) {
            D(true);
            this.aE.a();
        }
    }

    public void aA() {
        com.oppo.camera.doubleexposure.g gVar = this.aE;
        if (gVar != null) {
            gVar.a(false);
        }
        com.oppo.camera.k kVar = this.r;
        if (kVar != null) {
            kVar.edit().remove("PREF_VIDEO_CLIP_SAVE_PATH");
        }
        b((int) R.string.camera_double_exposure_max_recording_hint);
    }

    public void dj() {
        com.oppo.camera.ui.control.b bVar = this.p;
        if (bVar != null) {
            bVar.t(true);
        }
        aA();
    }

    public void a(float f, float f2) {
        com.oppo.camera.doubleexposure.g gVar;
        if (this.r != null && (gVar = this.aE) != null && !gVar.n()) {
            String string = this.r.getString("PREF_VIDEO_CLIP_SAVE_PATH", "");
            if (!TextUtils.isEmpty(string)) {
                try {
                    if (this.aE == null) {
                        return;
                    }
                    if (new File(this.aE.i()).exists()) {
                        this.aE.h();
                        a(this.aE.j());
                        return;
                    }
                    this.aE.a(string, new NvsStreamingContext.CompileCallback2(string) {
                        private final /* synthetic */ String f$1;

                        {
                            this.f$1 = r2;
                        }

                        public final void onCompileCompleted(NvsTimeline nvsTimeline, boolean z) {
                            g.this.a(this.f$1, nvsTimeline, z);
                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0043  */
    /* JADX WARNING: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ void a(java.lang.String r4, com.meicam.sdk.NvsTimeline r5, boolean r6) {
        /*
            r3 = this;
            r5 = 0
            android.media.MediaMetadataRetriever r6 = new android.media.MediaMetadataRetriever     // Catch:{ Exception -> 0x0032 }
            r6.<init>()     // Catch:{ Exception -> 0x0032 }
            r6.setDataSource(r4)     // Catch:{ Exception -> 0x002c, all -> 0x002a }
            r5 = 9
            java.lang.String r5 = r6.extractMetadata(r5)     // Catch:{ Exception -> 0x002c, all -> 0x002a }
            com.oppo.camera.doubleexposure.b r0 = new com.oppo.camera.doubleexposure.b     // Catch:{ Exception -> 0x002c, all -> 0x002a }
            r0.<init>(r4)     // Catch:{ Exception -> 0x002c, all -> 0x002a }
            r1 = 0
            r0.a((long) r1)     // Catch:{ Exception -> 0x002c, all -> 0x002a }
            long r4 = java.lang.Long.parseLong(r5)     // Catch:{ Exception -> 0x002c, all -> 0x002a }
            r0.b(r4)     // Catch:{ Exception -> 0x002c, all -> 0x002a }
            r3.a((com.oppo.camera.doubleexposure.b) r0)     // Catch:{ Exception -> 0x002c, all -> 0x002a }
            r6.release()     // Catch:{ Exception -> 0x002c, all -> 0x002a }
            r6.close()
            goto L_0x0040
        L_0x002a:
            r4 = move-exception
            goto L_0x0041
        L_0x002c:
            r4 = move-exception
            r5 = r6
            goto L_0x0033
        L_0x002f:
            r4 = move-exception
            r6 = r5
            goto L_0x0041
        L_0x0032:
            r4 = move-exception
        L_0x0033:
            com.oppo.camera.doubleexposure.g r6 = r3.aE     // Catch:{ all -> 0x002f }
            r6.m()     // Catch:{ all -> 0x002f }
            r4.printStackTrace()     // Catch:{ all -> 0x002f }
            if (r5 == 0) goto L_0x0040
            r5.close()
        L_0x0040:
            return
        L_0x0041:
            if (r6 == 0) goto L_0x0046
            r6.close()
        L_0x0046:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.ui.g.a(java.lang.String, com.meicam.sdk.NvsTimeline, boolean):void");
    }

    private void a(com.oppo.camera.doubleexposure.b bVar) {
        f fVar = this.x;
        if (fVar != null) {
            fVar.a(bVar, (g.a) new g.a() {
                public final void onVideoClipDone() {
                    g.this.eh();
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void eh() {
        this.i.runOnUiThread(new Runnable() {
            public final void run() {
                g.this.ei();
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void ei() {
        com.oppo.camera.doubleexposure.g gVar = this.aE;
        if (gVar != null) {
            gVar.a(true);
            this.aE.g();
        }
    }

    public boolean dk() {
        com.oppo.camera.doubleexposure.g gVar = this.aE;
        return gVar != null && gVar.o();
    }

    public void aB() {
        Activity activity = this.i;
        if (activity != null) {
            activity.runOnUiThread(new Runnable() {
                public final void run() {
                    g.this.eg();
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void eg() {
        if (this.I != null) {
            com.oppo.camera.ui.widget.e eVar = new com.oppo.camera.ui.widget.e(this.i);
            eVar.setVisibility(8);
            eVar.setId(R.id.video_clip_view);
            this.I.addView(eVar, new ViewGroup.MarginLayoutParams(-1, -1));
            this.aE = new com.oppo.camera.doubleexposure.g(this.I, this.i, this);
            this.aE.a((e.b) this);
            com.oppo.camera.ui.control.b bVar = this.p;
            if (bVar != null) {
                bVar.a(eVar);
            }
        }
    }

    public void t(int i2) {
        if (this.x != null && K(i2)) {
            this.x.j(i2);
        }
    }

    public boolean K(int i2) {
        CameraScreenHintView cameraScreenHintView = this.J;
        return (cameraScreenHintView == null || this.i == null || cameraScreenHintView.getHintTextView() == null || this.J.getHintTextViewString().equals(this.i.getString(i2))) ? false : true;
    }

    public void aC() {
        com.oppo.camera.ui.preview.d dVar = this.q;
        if (dVar != null) {
            dVar.af();
        }
    }
}
