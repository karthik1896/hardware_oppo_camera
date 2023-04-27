package com.oppo.camera.ui.preview;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.SurfaceTexture;
import android.graphics.drawable.Drawable;
import android.hardware.camera2.params.Face;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.os.SystemClock;
import android.util.Size;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import color.support.v7.app.b;
import com.color.support.widget.j;
import com.oppo.camera.R;
import com.oppo.camera.aps.config.CameraConfig;
import com.oppo.camera.aps.config.CameraFunction;
import com.oppo.camera.aps.config.ConfigDataBase;
import com.oppo.camera.doubleexposure.e;
import com.oppo.camera.doubleexposure.f;
import com.oppo.camera.gl.GLRootView;
import com.oppo.camera.gl.GLView;
import com.oppo.camera.gl.t;
import com.oppo.camera.k;
import com.oppo.camera.ui.RotableTextView;
import com.oppo.camera.ui.RotateImageView;
import com.oppo.camera.ui.inverse.InverseMaskView;
import com.oppo.camera.ui.m;
import com.oppo.camera.ui.menu.levelcontrol.g;
import com.oppo.camera.ui.preview.HyperLapseFocusView;
import com.oppo.camera.ui.preview.IntelligentDragView;
import com.oppo.camera.ui.preview.PreviewFrameLayout;
import com.oppo.camera.ui.preview.a.n;
import com.oppo.camera.ui.preview.e;
import com.oppo.camera.ui.preview.h;
import com.oppo.camera.ui.preview.l;
import com.oppo.camera.ui.widget.a;
import com.oppo.camera.util.Util;
import com.oppo.camera.z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: CameraPreviewUI */
public class d implements View.OnLayoutChangeListener, com.oppo.camera.d, PreviewFrameLayout.OnSizeChangedListener, e.b, h.b {
    private static final Interpolator d = new PathInterpolator(0.33f, 0.0f, 0.66f, 1.0f);
    /* access modifiers changed from: private */
    public static float e = 600.0f;
    private static Bitmap f = null;
    /* access modifiers changed from: private */
    public int A = 0;
    /* access modifiers changed from: private */
    public int B = 0;
    private int C = 90;
    /* access modifiers changed from: private */
    public int D = 0;
    /* access modifiers changed from: private */
    public int E = 0;
    /* access modifiers changed from: private */
    public long F = 0;
    /* access modifiers changed from: private */
    public Activity G = null;
    /* access modifiers changed from: private */
    public k H = null;
    /* access modifiers changed from: private */
    public e I = null;
    /* access modifiers changed from: private */
    public color.support.v7.app.b J = null;
    private b.a K = null;
    /* access modifiers changed from: private */
    public FaceView L = null;
    private t M = null;
    /* access modifiers changed from: private */
    public MultiFocusView N = null;
    private IntelligentDragView O = null;
    /* access modifiers changed from: private */
    public r P = null;
    private int Q = 1;
    /* access modifiers changed from: private */
    public int R = 0;
    private int S = 0;
    /* access modifiers changed from: private */
    public b T = null;
    private ImageView U = null;
    private ImageView V = null;
    /* access modifiers changed from: private */
    public PreviewFrameLayout W = null;
    private RelativeLayout.LayoutParams X = null;
    private RotateImageView Y = null;
    private l Z = null;
    private Thread aA = null;
    private boolean aB = true;
    /* access modifiers changed from: private */
    public boolean aC = false;
    /* access modifiers changed from: private */
    public boolean aD = false;
    private ArrayList<q> aE = new ArrayList<>();
    private Handler aF = new Handler() {
        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 1) {
                d.this.az();
            } else if (i == 2) {
                d.this.aA();
            } else if (i != 3) {
                if (i == 4 && d.this.as != null && d.this.as.getVisibility() == 0) {
                    d.this.as.setVisibility(8);
                }
            } else if (d.this.as != null && d.this.as.getVisibility() != 0) {
                d.this.as.setVisibility(0);
            }
        }
    };
    private final GLView aG = new GLView() {
        /* access modifiers changed from: protected */
        public void c(com.oppo.camera.gl.h hVar) {
            super.c(hVar);
        }

        public void a(int i, int i2, int i3, int i4) {
            super.a(i, i2, i3, i4);
        }

        /* access modifiers changed from: protected */
        public void f() {
            d.this.I.p();
        }

        /* access modifiers changed from: protected */
        public void a(int i, int i2) {
            d.this.I.b(i, i2);
        }

        /* access modifiers changed from: protected */
        public void a(com.oppo.camera.gl.h hVar) {
            if (d.this.I.g()) {
                com.oppo.camera.e.a("CameraPreviewUI", "render, last wanted frame already drawn, prevent from drawing more frames");
                return;
            }
            d dVar = d.this;
            dVar.a((dVar.W.getRight() - d.this.W.getLeft()) / 2, (d.this.W.getBottom() - d.this.W.getTop()) / 2, false, d.this.av(), false);
            hVar.a(new float[]{1.0f, 0.0f, 0.0f, 0.0f});
            if (d.this.s) {
                hVar.a(new float[]{1.0f, ((((float) Color.red(d.this.B)) / 255.0f) * ((float) Color.alpha(d.this.B))) / 255.0f, ((((float) Color.green(d.this.B)) / 255.0f) * ((float) Color.alpha(d.this.B))) / 255.0f, ((((float) Color.blue(d.this.B)) / 255.0f) * ((float) Color.alpha(d.this.B))) / 255.0f});
            }
            if (d.this.A != 0) {
                synchronized (d.this.j) {
                    float uptimeMillis = (float) (SystemClock.uptimeMillis() - d.this.F);
                    if (uptimeMillis < d.e) {
                        float interpolation = d.this.g.getInterpolation(uptimeMillis / d.e);
                        int unused = d.this.z = d.this.am.getWidth() + ((int) (((float) d.this.A) * interpolation));
                        int unused2 = d.this.u = d.this.v + ((int) (((float) d.this.x) * interpolation));
                    } else {
                        int unused3 = d.this.z = d.this.al.getWidth();
                        if (d.this.r) {
                            int unused4 = d.this.u = d.this.w;
                        }
                        int unused5 = d.this.A = 0;
                        int unused6 = d.this.x = 0;
                        int unused7 = d.this.w = 0;
                    }
                }
            }
            d.this.a(hVar);
            d.this.I.a(hVar, (g) null, d.this.ar(), d.this.as(), d.this.at(), d.this.au());
            d.this.b(hVar);
        }

        /* access modifiers changed from: protected */
        public void b(com.oppo.camera.gl.h hVar) {
            if (d.this.I != null) {
                d.this.I.a(hVar, 0, 0, d.this.E, d.this.D, d.this.h ? d.this.i : d.this.T.bA());
            }
        }
    };
    private Animation.AnimationListener aH = new Animation.AnimationListener() {
        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationStart(Animation animation) {
        }

        public void onAnimationEnd(Animation animation) {
            if (!d.this.aC) {
                d.this.aq();
            }
        }
    };
    private Animation.AnimationListener aI = new Animation.AnimationListener() {
        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationStart(Animation animation) {
        }

        public void onAnimationEnd(Animation animation) {
            if (d.this.ab != null) {
                d.this.ab.setVisibility(8);
            }
        }
    };
    private final DialogInterface.OnClickListener aJ = new DialogInterface.OnClickListener() {
        public void onClick(DialogInterface dialogInterface, int i) {
            int i2 = z.t;
            if (i2 == 0) {
                dialogInterface.dismiss();
            } else if (i2 == 1 || i2 == 2 || i2 == 3) {
                dialogInterface.dismiss();
                if (d.this.aD) {
                    Intent intent = new Intent("com.oppo.cleandroid.ui.ClearMainActivity");
                    intent.setPackage("com.coloros.phonemanager");
                    try {
                        intent.addFlags(67108864);
                        d.this.G.startActivity(intent);
                    } catch (Exception e) {
                        com.oppo.camera.e.e("CameraPreviewUI", "mDialogOnClickListener.onClick, Exception when start ClearMainActivity: " + e);
                    }
                }
            }
        }
    };
    private final IntelligentDragView.a aK = new IntelligentDragView.a() {
        public boolean a(MotionEvent motionEvent) {
            int rawX = (int) motionEvent.getRawX();
            int rawY = (int) motionEvent.getRawY();
            if (d.this.T == null || !d.this.T.k(rawX, rawY)) {
                return false;
            }
            d.this.T.d(rawX, rawY);
            return false;
        }

        public void b(MotionEvent motionEvent) {
            int rawX = (int) motionEvent.getRawX();
            int rawY = (int) motionEvent.getRawY();
            if (d.this.T != null) {
                d.this.T.j(rawX, rawY);
            }
        }

        public void c(MotionEvent motionEvent) {
            int rawX = (int) motionEvent.getRawX();
            int rawY = (int) motionEvent.getRawY();
            if (d.this.T != null && d.this.T.k(rawX, rawY)) {
                d.this.T.e(rawX, rawY);
            }
        }
    };
    private HyperLapseFocusView.a aL = new HyperLapseFocusView.a() {
        public boolean a() {
            return d.this.h;
        }

        public boolean b() {
            if (d.this.T != null) {
                return d.this.T.ai();
            }
            return false;
        }

        public void c() {
            if (d.this.T != null) {
                d.this.T.aS();
            }
        }

        public void a(int i, int i2) {
            d.this.T.d(i, i2);
        }

        public void b(int i, int i2) {
            d.this.T.e(i, i2);
        }
    };
    private n aa = null;
    /* access modifiers changed from: private */
    public ImageView ab = null;
    /* access modifiers changed from: private */
    public RelativeLayout ac = null;
    private Bitmap ad = null;
    private String ae = null;
    private String af = "off";
    private Size ag = null;
    private SurfaceTexture ah = null;
    private Surface ai = null;
    private Size aj = null;
    private Size ak = null;
    /* access modifiers changed from: private */
    public Size al = null;
    /* access modifiers changed from: private */
    public Size am = null;
    private int an = 0;
    private a ao = null;
    private e.c ap = null;
    private GLRootView aq = null;
    /* access modifiers changed from: private */
    public RotableTextView ar = null;
    /* access modifiers changed from: private */
    public m as = null;
    /* access modifiers changed from: private */
    public HyperLapseFocusView at = null;
    /* access modifiers changed from: private */
    public j au = null;
    private int av = 0;
    private ImageView aw = null;
    /* access modifiers changed from: private */
    public com.oppo.camera.ui.widget.a ax = null;
    private RecyclerView ay = null;
    private e.b az = null;
    /* access modifiers changed from: private */
    public final PathInterpolator g;
    /* access modifiers changed from: private */
    public volatile boolean h = false;
    /* access modifiers changed from: private */
    public volatile int i = 0;
    /* access modifiers changed from: private */
    public Object j = new Object();
    /* access modifiers changed from: private */
    public boolean k = false;
    /* access modifiers changed from: private */
    public boolean l = false;
    private boolean m = false;
    private boolean n = false;
    /* access modifiers changed from: private */
    public boolean o = false;
    /* access modifiers changed from: private */
    public boolean p = false;
    /* access modifiers changed from: private */
    public boolean q = false;
    /* access modifiers changed from: private */
    public boolean r = false;
    /* access modifiers changed from: private */
    public boolean s = false;
    private int t = 0;
    /* access modifiers changed from: private */
    public int u = 0;
    /* access modifiers changed from: private */
    public int v = 0;
    /* access modifiers changed from: private */
    public int w = 0;
    /* access modifiers changed from: private */
    public int x = 0;
    private int y = 0;
    /* access modifiers changed from: private */
    public int z = 0;

    /* compiled from: CameraPreviewUI */
    public interface a {
        void a();

        void a(Size size);

        void a(Size size, Size size2);

        int b();
    }

    /* compiled from: CameraPreviewUI */
    public interface b {
        void I(int i);

        void a(f fVar);

        void a(RotateImageView rotateImageView);

        boolean aR();

        void aS();

        boolean ai();

        int bA();

        int bB();

        boolean bv();

        void bw();

        void bx();

        void by();

        void bz();

        boolean cU();

        boolean cV();

        float cW();

        boolean cX();

        void cY();

        boolean cZ();

        String co();

        void cp();

        void d(int i, int i2);

        void e(int i, int i2);

        void i(int i, int i2);

        void j(int i, int i2);

        boolean k(int i, int i2);

        boolean k(String str);
    }

    public void a() {
        r rVar = this.P;
        if (rVar != null) {
            rVar.setVisibility(0);
        }
    }

    public void b() {
        this.P = (r) this.G.findViewById(R.id.super_text_frame_view);
        if (this.P == null) {
            this.P = new r(this.G);
            this.P.setId(R.id.super_text_frame_view);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            this.P.setLayoutParams(layoutParams);
            this.P.setVisibility(8);
            this.W.addView(this.P, layoutParams);
        }
        this.P.setForceDarkAllowed(false);
    }

    public void c() {
        r rVar = this.P;
        if (rVar != null) {
            rVar.setVisibility(4);
            this.P.setPointsArray((PointF[]) null);
        }
    }

    public void a(final com.oppo.camera.t.a aVar) {
        this.G.runOnUiThread(new Runnable() {
            public void run() {
                if (d.this.P == null) {
                    d.this.b();
                }
                if (d.this.P != null) {
                    com.oppo.camera.t.a aVar = aVar;
                    if (aVar == null || !aVar.c()) {
                        d.this.P.setVisibility(4);
                        d.this.P.setPointsArray((PointF[]) null);
                        return;
                    }
                    d.this.P.setVisibility(0);
                    d.this.P.setPointsArray(aVar.b());
                }
            }
        });
    }

    public void b(com.oppo.camera.t.a aVar) {
        com.oppo.camera.e.a("CameraPreviewUI", "executeSuperTextFrameColorAnimation");
        r rVar = this.P;
        if (rVar != null) {
            rVar.a(aVar);
        }
    }

    public void a(boolean z2, int i2) {
        this.s = z2;
        this.B = i2;
    }

    public d(Activity activity, k kVar, b bVar) {
        boolean z2 = false;
        this.G = activity;
        this.H = kVar;
        this.T = bVar;
        this.g = new PathInterpolator(0.35f, 0.62f, 0.2f, 1.0f);
        Intent intent = new Intent();
        intent.setPackage("com.coloros.phonemanager");
        intent.setAction("com.oppo.cleandroid.ui.ClearMainActivity");
        List<ResolveInfo> queryIntentActivities = activity.getPackageManager().queryIntentActivities(intent, 0);
        if (queryIntentActivities != null && queryIntentActivities.size() > 0) {
            z2 = true;
        }
        this.aD = z2;
        com.oppo.camera.e.e("CameraPreviewUI", "CameraPreviewUI, mbCanUseCleanFunction: " + this.aD);
    }

    public void a(int i2, int i3) {
        this.D = i2;
        this.E = i3;
    }

    public void a(n nVar) {
        this.aq = (GLRootView) this.G.findViewById(R.id.gl_root_view);
        this.aq.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.aq.setContentPane(this.aG);
        a(com.oppo.camera.f.a.c(this.T.bB()), nVar);
        this.ac = (RelativeLayout) this.G.findViewById(R.id.camera);
        this.L = (FaceView) this.G.findViewById(R.id.face_view);
        this.L.setDisplayOrientation(this.C);
        this.N = (MultiFocusView) this.G.findViewById(R.id.multi_focus_view);
        a(this.N.getListener());
        this.W = (PreviewFrameLayout) this.G.findViewById(R.id.frame_layout);
        this.W.setOnSizeChangedListener(this);
        this.W.addOnLayoutChangeListener(this);
        a((h.b) this);
        com.oppo.camera.ui.inverse.c cVar = com.oppo.camera.ui.inverse.c.INS;
        Activity activity = this.G;
        cVar.setInverseMaskView(activity, (InverseMaskView) activity.findViewById(R.id.inverse_mask_view));
    }

    public void d() {
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_INTELLIGENT_HIGH_FRAME) && this.O == null) {
            this.O = (IntelligentDragView) this.G.getLayoutInflater().inflate(R.layout.view_slow_motion_detect, this.W).findViewById(R.id.slow_video_motion_detect_view);
            this.O.setIntelligentGestureListener(this.aK);
        }
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_TRACK_FOCUS_SUPPORT)) {
            this.M = (t) this.G.findViewById(R.id.track_focus_view);
            if (this.M == null) {
                this.M = new t(this.G);
                this.M.setId(R.id.track_focus_view);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                this.M.setLayoutParams(layoutParams);
                this.M.setVisibility(8);
                this.W.addView(this.M, layoutParams);
            }
        }
    }

    public void e() {
        this.k = false;
        this.I.d(false);
        GLRootView gLRootView = this.aq;
        if (gLRootView != null) {
            gLRootView.c();
        }
    }

    public void f() {
        this.af = this.H.getString("pref_assist_gradienter", "off");
        com.oppo.camera.e.a("CameraPreviewUI", "onResumeMessage, mAssistGradienterState: " + this.af);
        a(true);
        b("on".equals(this.af));
        t();
        this.aA = Thread.currentThread();
    }

    public void g() {
        com.oppo.camera.e.a("CameraPreviewUI", "releaseTextures");
        synchronized (this.j) {
            if (this.I != null) {
                this.I.c();
                this.I.a(t.a.c);
                this.I.a(t.a.d);
                this.I.a(t.a.e);
                this.ah = null;
                this.aB = true;
            }
            if (this.ai != null) {
                this.ai.release();
                this.ai = null;
            }
        }
    }

    public void a(long j2) {
        e eVar = this.I;
        if (eVar != null) {
            eVar.a(j2);
        }
    }

    public long h() {
        e eVar = this.I;
        if (eVar != null) {
            return eVar.o();
        }
        return 0;
    }

    public void i() {
        com.oppo.camera.e.a("CameraPreviewUI", "onPause");
        this.k = true;
        this.l = true;
        t();
        r();
        x();
        FaceView faceView = this.L;
        if (faceView != null) {
            faceView.c();
        }
        IntelligentDragView intelligentDragView = this.O;
        if (intelligentDragView != null) {
            intelligentDragView.a();
        }
        MultiFocusView multiFocusView = this.N;
        if (multiFocusView != null) {
            multiFocusView.b();
        }
        t tVar = this.M;
        if (tVar != null) {
            tVar.d();
        }
        ImageView imageView = this.ab;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        GLRootView gLRootView = this.aq;
        if (gLRootView != null) {
            gLRootView.setAlpha(1.0f);
        }
        Bitmap bitmap = this.ad;
        if (bitmap != null) {
            bitmap.recycle();
            this.ad = null;
        }
        this.I.k(true);
        p();
        l(false);
        this.o = false;
        this.p = false;
        this.aF.removeCallbacksAndMessages((Object) null);
        g();
        GLRootView gLRootView2 = this.aq;
        if (gLRootView2 != null) {
            gLRootView2.d();
        }
        ay();
        l lVar = this.Z;
        if (lVar != null) {
            lVar.b();
        }
    }

    public void j() {
        GLRootView gLRootView = this.aq;
        if (gLRootView != null) {
            gLRootView.setBackgroundColor(-16777216);
        }
        e eVar = this.I;
        if (eVar != null) {
            eVar.e(false);
        }
    }

    public void k() {
        com.oppo.camera.e.a("CameraPreviewUI", "onDestroy");
        l();
        this.J = null;
        this.G = null;
        this.U = null;
        this.K = null;
        this.aq = null;
        com.oppo.camera.ui.widget.a aVar = this.ax;
        if (aVar != null) {
            aVar.a();
        }
        FaceView faceView = this.L;
        if (faceView != null) {
            faceView.f();
            this.L = null;
        }
        if (this.M != null) {
            this.M = null;
        }
        MultiFocusView multiFocusView = this.N;
        if (multiFocusView != null) {
            multiFocusView.e();
            this.N = null;
        }
        PreviewFrameLayout previewFrameLayout = this.W;
        if (previewFrameLayout != null) {
            previewFrameLayout.removeAllViewsInLayout();
            this.W.removeAllViews();
            this.W = null;
        }
    }

    public void l() {
        e eVar = this.I;
        if (eVar != null) {
            eVar.n();
        }
        GLRootView gLRootView = this.aq;
        if (gLRootView != null) {
            gLRootView.f();
        }
    }

    public void a(g gVar) {
        this.I.a((com.oppo.camera.gl.h) null, gVar, ar(), as(), at(), au());
    }

    public void a(boolean z2) {
        b bVar;
        if (this.aa == null) {
            this.aa = new n(this.G);
            this.aa.setForceDarkAllowed(false);
            this.aa.setVisibility(8);
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
            PreviewFrameLayout previewFrameLayout = this.W;
            previewFrameLayout.addView(this.aa, previewFrameLayout.indexOfChild(this.Z), layoutParams);
        }
        if (this.aa != null && (bVar = this.T) != null) {
            if (!z2 || !bVar.k("pref_camera_assistant_line_key") || (!this.T.cV() && this.T.cU())) {
                this.aa.a(this.T.cU());
                return;
            }
            float cW = this.T.cW();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.aa.getLayoutParams();
            if (1.0f > cW) {
                float right = (float) (this.W.getRight() - this.W.getLeft());
                int i2 = (int) ((right - (cW * right)) / 2.0f);
                layoutParams2.leftMargin = i2;
                layoutParams2.rightMargin = i2;
            } else {
                layoutParams2.leftMargin = 0;
                layoutParams2.rightMargin = 0;
            }
            this.aa.setLayoutParams(layoutParams2);
            this.aa.a(this.T.co());
        }
    }

    public void b(boolean z2) {
        if (this.Z == null) {
            this.Z = new l(this.G);
            this.Z.setForceDarkAllowed(false);
            this.Z.setVisibility(8);
            this.Z.setOnAdjustedListener(new l.b() {
                public void a() {
                    if (d.this.T != null) {
                        d.this.T.cp();
                    }
                }
            });
            this.W.addView(this.Z, new ViewGroup.LayoutParams(-1, -1));
        }
        if (this.Z == null) {
            return;
        }
        if (!z2 || !this.T.k("pref_assist_gradienter") || !"on".equals(this.af)) {
            this.Z.b();
        } else {
            this.Z.a();
        }
    }

    public boolean m() {
        l lVar = this.Z;
        if (lVar != null) {
            return lVar.c();
        }
        return false;
    }

    public String n() {
        l lVar = this.Z;
        return lVar != null ? lVar.getOrientation() : "";
    }

    public void o() {
        if (this.ac != null && this.ar == null) {
            this.G.getLayoutInflater().inflate(R.layout.burst, this.ac);
            this.ar = (RotableTextView) this.G.findViewById(R.id.burst_num_view);
            ((RelativeLayout.LayoutParams) this.ar.getLayoutParams()).addRule(2, R.id.control_panel_layout);
            this.ar.setTypeface(Util.j((Context) this.G));
            this.ar.a(this.R, false);
            this.ar.setVisibility(8);
        }
    }

    public void p() {
        RotableTextView rotableTextView;
        RelativeLayout relativeLayout = this.ac;
        if (relativeLayout != null && (rotableTextView = this.ar) != null) {
            relativeLayout.removeView(rotableTextView);
            this.ar = null;
        }
    }

    public void a(int i2) {
        o();
        RotableTextView rotableTextView = this.ar;
        if (rotableTextView != null) {
            if (i2 < 10) {
                rotableTextView.setText(Util.j(0) + Util.j(i2));
            } else {
                rotableTextView.setText(Util.j(i2));
            }
            if (1 == i2) {
                com.oppo.camera.perf.a.a("continuous_capture");
            } else if (Util.d == i2) {
                com.oppo.camera.perf.a.b("continuous_capture");
            }
            this.ar.setVisibility(0);
        }
    }

    public void c(boolean z2) {
        RotableTextView rotableTextView = this.ar;
        if (rotableTextView != null) {
            if (!z2) {
                rotableTextView.setText((CharSequence) null);
                this.ar.setVisibility(8);
            } else if (rotableTextView.isShown()) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
                alphaAnimation.setDuration(100);
                alphaAnimation.setAnimationListener(new Animation.AnimationListener() {
                    public void onAnimationRepeat(Animation animation) {
                    }

                    public void onAnimationStart(Animation animation) {
                    }

                    public void onAnimationEnd(Animation animation) {
                        if (d.this.ar != null) {
                            d.this.ar.setText((CharSequence) null);
                        }
                    }
                });
                this.ar.startAnimation(alphaAnimation);
                this.ar.setVisibility(8);
            }
        }
    }

    public void q() {
        if (this.W != null && this.Y == null) {
            this.Y = new RotateImageView(this.G);
            this.Y.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
            this.Y.setScaleType(ImageView.ScaleType.CENTER);
            this.Y.setImageDrawable(Util.b((Context) this.G, (int) R.drawable.ae_af_lock));
            this.Y.setVisibility(8);
            this.W.addView(this.Y);
            b bVar = this.T;
            if (bVar != null) {
                bVar.a(this.Y);
            }
        }
    }

    public void r() {
        RotateImageView rotateImageView;
        PreviewFrameLayout previewFrameLayout = this.W;
        if (previewFrameLayout != null && (rotateImageView = this.Y) != null) {
            previewFrameLayout.removeView(rotateImageView);
            this.Y = null;
        }
    }

    public void s() {
        q();
        if (this.Y != null && !this.T.aR()) {
            this.Y.setVisibility(0);
        }
    }

    public void t() {
        RotateImageView rotateImageView = this.Y;
        if (rotateImageView != null) {
            rotateImageView.setVisibility(8);
        }
    }

    public void u() {
        Activity activity;
        if (this.ac != null && this.as == null && (activity = this.G) != null) {
            activity.runOnUiThread(new Runnable() {
                public void run() {
                    if (d.this.as == null) {
                        d dVar = d.this;
                        m unused = dVar.as = new m(dVar.G);
                        int dimensionPixelSize = d.this.G.getResources().getDimensionPixelSize(R.dimen.omoji_no_face_view_size);
                        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
                        layoutParams.addRule(14);
                        layoutParams.addRule(10);
                        layoutParams.topMargin = Util.v() + d.this.G.getResources().getDimensionPixelSize(R.dimen.omoji_no_face_view_margin_topbar);
                        d.this.as.setImage(BitmapFactory.decodeResource(d.this.G.getResources(), R.drawable.no_face_detect));
                        d.this.as.setText(d.this.G.getResources().getString(R.string.camera_omoji_no_faces));
                        d.this.as.setViewGap(d.this.G.getResources().getDimensionPixelSize(R.dimen.omoji_no_face_view_gap));
                        d.this.ac.addView(d.this.as, layoutParams);
                        d.this.as.a(d.this.R, false);
                        d.this.as.setVisibility(8);
                    }
                }
            });
        }
    }

    public void v() {
        u();
        Handler handler = this.aF;
        if (handler != null) {
            handler.removeMessages(3);
            this.aF.sendEmptyMessage(3);
        }
    }

    public void w() {
        Handler handler = this.aF;
        if (handler != null) {
            handler.removeMessages(4);
            this.aF.sendEmptyMessage(4);
        }
    }

    public void x() {
        m mVar;
        RelativeLayout relativeLayout = this.ac;
        if (relativeLayout != null && (mVar = this.as) != null) {
            relativeLayout.removeView(mVar);
            this.as = null;
        }
    }

    public void a(Bitmap bitmap) {
        ImageView imageView;
        a(false);
        b(false);
        if (this.U == null) {
            this.U = a((ViewGroup) this.W);
        }
        if (!(bitmap == null || (imageView = this.U) == null)) {
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            this.U.setImageBitmap(bitmap);
            this.U.setVisibility(0);
        }
        t();
    }

    public void y() {
        ImageView imageView = this.U;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        this.I.k(true);
        a(true);
        b(true);
    }

    public boolean z() {
        ImageView imageView = this.U;
        if (imageView != null) {
            return imageView.isShown();
        }
        return false;
    }

    private ImageView a(ViewGroup viewGroup) {
        ImageView imageView = new ImageView(this.G);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
        imageView.setVisibility(8);
        imageView.setBackgroundColor(-16777216);
        viewGroup.addView(imageView, layoutParams);
        return imageView;
    }

    public void b(Bitmap bitmap) {
        if (this.U == null) {
            this.U = a((ViewGroup) this.W);
        }
        this.U.setScaleType(ImageView.ScaleType.FIT_START);
        if (bitmap != null) {
            this.U.setImageBitmap(Util.a(bitmap, -this.S, false));
            this.U.setVisibility(0);
        }
    }

    public void A() {
        this.U.setVisibility(8);
    }

    public Surface B() {
        Surface surface;
        synchronized (this.j) {
            surface = this.ai;
        }
        return surface;
    }

    public Size C() {
        Size size;
        synchronized (this.j) {
            size = this.ag;
        }
        return size;
    }

    public e D() {
        return this.I;
    }

    public RelativeLayout E() {
        return this.W;
    }

    public void a(e.c cVar) {
        this.ap = cVar;
    }

    public void b(int i2) {
        this.Q = i2;
    }

    public void c(int i2) {
        this.R = i2;
        RotableTextView rotableTextView = this.ar;
        if (rotableTextView != null) {
            rotableTextView.a(i2, true);
        }
        FaceView faceView = this.L;
        if (faceView != null) {
            faceView.a(i2, false);
        }
        IntelligentDragView intelligentDragView = this.O;
        if (intelligentDragView != null) {
            intelligentDragView.a(i2, false);
        }
        m mVar = this.as;
        if (mVar != null) {
            mVar.a(i2, true);
        }
        com.oppo.camera.ui.widget.a aVar = this.ax;
        if (aVar != null) {
            aVar.a(i2, true);
        }
    }

    public void d(int i2) {
        this.C = i2;
        e eVar = this.I;
        if (eVar != null) {
            eVar.b(i2);
        }
        FaceView faceView = this.L;
        if (faceView != null) {
            faceView.setDisplayOrientation(i2);
        }
        t tVar = this.M;
        if (tVar != null) {
            tVar.setDisplayOrientation(i2);
        }
        MultiFocusView multiFocusView = this.N;
        if (multiFocusView != null) {
            multiFocusView.setDisplayOrientation(i2);
        }
    }

    public void a(t.a aVar, boolean z2, boolean z3, String str) {
        e eVar = this.I;
        if (eVar != null) {
            eVar.a(aVar, z2, z3, str);
        }
    }

    public void d(boolean z2) {
        FaceView faceView = this.L;
        if (faceView != null) {
            faceView.setMirror(z2);
        }
    }

    public void e(boolean z2) {
        this.h = z2;
        if (this.h) {
            this.i = this.T.bA();
        }
    }

    public void a(Rect rect, Size size) {
        FaceView faceView = this.L;
        if (faceView != null) {
            faceView.a(rect, size);
        }
    }

    public void a(Rect rect, Rect rect2, Size size) {
        t tVar = this.M;
        if (tVar != null) {
            tVar.a(rect, rect2, size);
        }
    }

    public void a(float f2) {
        FaceView faceView = this.L;
        if (faceView != null) {
            faceView.setEISScale(f2);
        }
    }

    public void b(float f2) {
        FaceView faceView = this.L;
        if (faceView != null) {
            faceView.setZoomValue(f2);
        }
    }

    public void c(float f2) {
        FaceView faceView = this.L;
        if (faceView != null) {
            faceView.setFaceSlenderZoomValue(f2);
        }
    }

    public void a(Face[] faceArr, int[] iArr) {
        MultiFocusView multiFocusView;
        if (this.L == null) {
            return;
        }
        if (this.I.k() || ((multiFocusView = this.N) != null && multiFocusView.a())) {
            if (this.L.a()) {
                G();
            }
            this.L.b();
            return;
        }
        this.L.a(faceArr, iArr);
    }

    public void a(int[] iArr) {
        if (this.N == null) {
            return;
        }
        if (!this.L.g() || !this.p) {
            this.N.b();
        } else {
            this.N.a(iArr, C());
        }
    }

    public void F() {
        e eVar = this.I;
        if (eVar != null) {
            eVar.w();
        }
    }

    public void G() {
        FaceView faceView = this.L;
        if (faceView != null) {
            faceView.c();
        }
    }

    public void H() {
        MultiFocusView multiFocusView = this.N;
        if (multiFocusView != null) {
            multiFocusView.b();
        }
    }

    private void a(boolean z2, n nVar) {
        if (this.I == null) {
            this.I = new e(this.G, this, z2);
            this.I.a(this.ap);
            this.I.b(this.C);
            this.I.a(nVar);
        }
        this.I.a(this.aq);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x00b1, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(android.util.Size r7) {
        /*
            r6 = this;
            java.lang.Object r0 = r6.j
            monitor-enter(r0)
            java.lang.String r1 = "CameraPreviewUI"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x00bb }
            r2.<init>()     // Catch:{ all -> 0x00bb }
            java.lang.String r3 = "updateSurfaceTexture, previewSize: "
            r2.append(r3)     // Catch:{ all -> 0x00bb }
            int r3 = r7.getWidth()     // Catch:{ all -> 0x00bb }
            r2.append(r3)     // Catch:{ all -> 0x00bb }
            java.lang.String r3 = "x"
            r2.append(r3)     // Catch:{ all -> 0x00bb }
            int r3 = r7.getHeight()     // Catch:{ all -> 0x00bb }
            r2.append(r3)     // Catch:{ all -> 0x00bb }
            java.lang.String r3 = ", mbNeedAcquireTexture: "
            r2.append(r3)     // Catch:{ all -> 0x00bb }
            boolean r3 = r6.aB     // Catch:{ all -> 0x00bb }
            r2.append(r3)     // Catch:{ all -> 0x00bb }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x00bb }
            com.oppo.camera.e.a(r1, r2)     // Catch:{ all -> 0x00bb }
            r6.ag = r7     // Catch:{ all -> 0x00bb }
            int r1 = r7.getWidth()     // Catch:{ all -> 0x00bb }
            int r2 = r7.getHeight()     // Catch:{ all -> 0x00bb }
            r6.b((int) r1, (int) r2)     // Catch:{ all -> 0x00bb }
            com.oppo.camera.ui.preview.e r1 = r6.I     // Catch:{ all -> 0x00bb }
            int r1 = r1.e()     // Catch:{ all -> 0x00bb }
            com.oppo.camera.ui.preview.e r2 = r6.I     // Catch:{ all -> 0x00bb }
            int r2 = r2.f()     // Catch:{ all -> 0x00bb }
            boolean r3 = r6.k     // Catch:{ all -> 0x00bb }
            r4 = 0
            if (r3 != 0) goto L_0x00b2
            com.oppo.camera.ui.preview.e r3 = r6.I     // Catch:{ all -> 0x00bb }
            r3.m()     // Catch:{ all -> 0x00bb }
            boolean r3 = r6.aB     // Catch:{ all -> 0x00bb }
            r5 = 1
            if (r3 == 0) goto L_0x008f
            int r1 = r7.getWidth()     // Catch:{ all -> 0x00bb }
            int r2 = r7.getHeight()     // Catch:{ all -> 0x00bb }
            r3 = -1
            r6.a((int) r3, (int) r3, (int) r1, (int) r2)     // Catch:{ all -> 0x00bb }
            com.oppo.camera.ui.preview.e r1 = r6.I     // Catch:{ all -> 0x00bb }
            com.oppo.camera.ui.preview.d$b r2 = r6.T     // Catch:{ all -> 0x00bb }
            int r2 = r2.bB()     // Catch:{ all -> 0x00bb }
            if (r2 != 0) goto L_0x0073
            r2 = r5
            goto L_0x0074
        L_0x0073:
            r2 = r4
        L_0x0074:
            r1.b((boolean) r2)     // Catch:{ all -> 0x00bb }
            com.oppo.camera.ui.preview.e r1 = r6.I     // Catch:{ all -> 0x00bb }
            android.graphics.SurfaceTexture r1 = r1.b()     // Catch:{ all -> 0x00bb }
            r6.ah = r1     // Catch:{ all -> 0x00bb }
            android.graphics.SurfaceTexture r1 = r6.ah     // Catch:{ all -> 0x00bb }
            if (r1 == 0) goto L_0x008c
            android.view.Surface r1 = new android.view.Surface     // Catch:{ all -> 0x00bb }
            android.graphics.SurfaceTexture r2 = r6.ah     // Catch:{ all -> 0x00bb }
            r1.<init>(r2)     // Catch:{ all -> 0x00bb }
            r6.ai = r1     // Catch:{ all -> 0x00bb }
        L_0x008c:
            r6.aB = r4     // Catch:{ all -> 0x00bb }
            goto L_0x009a
        L_0x008f:
            int r3 = r7.getWidth()     // Catch:{ all -> 0x00bb }
            int r4 = r7.getHeight()     // Catch:{ all -> 0x00bb }
            r6.a((int) r1, (int) r2, (int) r3, (int) r4)     // Catch:{ all -> 0x00bb }
        L_0x009a:
            com.oppo.camera.ui.preview.e r1 = r6.I     // Catch:{ all -> 0x00bb }
            r1.d()     // Catch:{ all -> 0x00bb }
            android.graphics.SurfaceTexture r1 = r6.ah     // Catch:{ all -> 0x00bb }
            if (r1 == 0) goto L_0x00b0
            android.graphics.SurfaceTexture r1 = r6.ah     // Catch:{ all -> 0x00bb }
            int r2 = r7.getWidth()     // Catch:{ all -> 0x00bb }
            int r7 = r7.getHeight()     // Catch:{ all -> 0x00bb }
            r1.setDefaultBufferSize(r2, r7)     // Catch:{ all -> 0x00bb }
        L_0x00b0:
            monitor-exit(r0)     // Catch:{ all -> 0x00bb }
            return r5
        L_0x00b2:
            java.lang.String r7 = "CameraPreviewUI"
            java.lang.String r1 = "updateSurfaceTexture, Activity already pause. Avoid 0x502."
            com.oppo.camera.e.a(r7, r1)     // Catch:{ all -> 0x00bb }
            monitor-exit(r0)     // Catch:{ all -> 0x00bb }
            return r4
        L_0x00bb:
            r7 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00bb }
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.ui.preview.d.a(android.util.Size):boolean");
    }

    public void a(com.oppo.camera.ui.k kVar) {
        if (this.aq != null) {
            com.oppo.camera.e.a("CameraPreviewUI", "setOutlineProvider, outlineProvider: " + kVar);
            if (kVar != null) {
                this.aq.setClipToOutline(true);
            } else {
                this.aq.setClipToOutline(false);
            }
            this.aq.setOutlineProvider(kVar);
        }
    }

    public void a(final Size size, boolean z2) {
        com.oppo.camera.e.a("CameraPreviewUI", "updatePreviewSize, previewSize: " + size.getWidth() + "x" + size.getHeight() + ", layoutPreview: " + z2);
        a(size);
        if (Thread.currentThread() != this.aA) {
            this.G.runOnUiThread(new Runnable() {
                public void run() {
                    d.this.b(size);
                }
            });
        } else {
            b(size);
        }
    }

    private void a(int i2, int i3, int i4, int i5) {
        if (this.C % 180 != 0) {
            int i6 = i5;
            i5 = i4;
            i4 = i6;
        }
        if (i2 != i4 || i3 != i5) {
            this.I.a(i4, i5);
        }
    }

    /* access modifiers changed from: private */
    public void b(Size size) {
        RelativeLayout.LayoutParams layoutParams;
        View childAt;
        if (this.G == null) {
            com.oppo.camera.e.a("CameraPreviewUI", "layoutPreviewFrameToPreviewSize, mActivity is null");
            return;
        }
        e eVar = this.I;
        boolean z2 = true;
        if (eVar != null) {
            eVar.a(Util.p() && this.T.k("pref_video_eis"));
        }
        if (this.W != null) {
            if (size.getWidth() == 0 || size.getWidth() != size.getHeight() || !this.T.bv()) {
                boolean z3 = Math.abs((((double) size.getWidth()) / ((double) size.getHeight())) - 1.3333333333333333d) > 0.01d;
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
                if (!z3) {
                    int width = size.getWidth();
                    int height = size.getHeight();
                    float f2 = ((float) height) / ((float) width);
                    if ((((double) width) / ((double) height)) - 1.0d != 0.0d) {
                        z2 = false;
                    }
                    if (z2) {
                        layoutParams2.topMargin = Util.v() + Util.t();
                        layoutParams2.height = Util.v() + Util.t() + Util.E();
                    } else {
                        layoutParams2.topMargin = Util.v();
                        layoutParams2.bottomMargin = (int) (((float) (Util.C() - Util.v())) - (((float) Util.E()) / f2));
                    }
                } else if (Math.abs((((double) size.getWidth()) / ((double) size.getHeight())) - 1.5d) < 0.01d) {
                    int width2 = size.getWidth();
                    int height2 = size.getHeight();
                    if (this.C % 180 != 0) {
                        width2 = size.getHeight();
                        height2 = size.getWidth();
                    }
                    float f3 = 1.0f;
                    float E2 = width2 != 0 ? ((float) Util.E()) / ((float) width2) : 1.0f;
                    if (height2 != 0) {
                        f3 = ((float) Util.D()) / ((float) height2);
                    }
                    layoutParams = E2 != f3 ? new RelativeLayout.LayoutParams((int) (((float) width2) * E2), (int) (((float) height2) * E2)) : layoutParams2;
                    layoutParams.addRule(10);
                    layoutParams.topMargin = Util.v();
                } else {
                    float width3 = ((float) size.getWidth()) / ((float) size.getHeight());
                    int b2 = Util.b(size.getWidth(), size.getHeight());
                    if (!this.T.cU() && (!this.T.bv() || 1 == b2)) {
                        layoutParams2.topMargin = Util.v();
                        layoutParams2.bottomMargin = (int) (((float) (Util.C() - Util.v())) - (((float) Util.E()) * width3));
                    }
                }
                layoutParams = layoutParams2;
            } else {
                layoutParams = new RelativeLayout.LayoutParams(-1, Util.E());
                layoutParams.topMargin = Util.v() + Util.t();
                layoutParams.bottomMargin = Util.C() - ((Util.v() + Util.t()) + Util.E());
            }
            this.X = layoutParams;
            this.W.setLayoutParams(this.X);
            Activity activity = this.G;
            if (!(activity == null || (childAt = ((ViewGroup) activity.getWindow().getDecorView()).getChildAt(0)) == null)) {
                childAt.requestLayout();
            }
            b bVar = this.T;
            if (bVar != null) {
                bVar.i(this.W.getWidth(), this.W.getHeight());
            }
        }
    }

    private ImageView b(ViewGroup viewGroup) {
        ImageView imageView = new ImageView(this.G);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
        imageView.setVisibility(8);
        imageView.setLayerType(2, (Paint) null);
        viewGroup.addView(imageView, layoutParams);
        return imageView;
    }

    public void f(boolean z2) {
        b bVar;
        if (!z2 || (bVar = this.T) == null || !bVar.k(CameraFunction.ID_PHOTO)) {
            ImageView imageView = this.aw;
            if (imageView != null) {
                this.W.removeView(imageView);
                this.aw = null;
            }
        } else if (this.aw == null) {
            this.aw = new ImageView(this.G);
            this.aw.setForegroundGravity(48);
            if (this.T.bB() == 0) {
                this.aw.setImageResource(R.drawable.id_photo_guide_puzzle_rear);
            } else {
                this.aw.setImageResource(R.drawable.id_photo_guide_puzzle_front);
            }
            this.W.addView(this.aw, new ViewGroup.LayoutParams(-2, -2));
        }
    }

    public static void c(Bitmap bitmap) {
        f = bitmap;
    }

    public static Bitmap I() {
        return f;
    }

    public void J() {
        if (I() != null) {
            if (this.V == null) {
                this.V = new ImageView(this.G);
                this.V.setScaleType(ImageView.ScaleType.CENTER_CROP);
                this.V.setVisibility(0);
            }
            com.oppo.camera.e.a("CameraPreviewUI", "coverBlurView, mBlurCover: " + this.V);
            this.V.setImageBitmap(I());
            this.V.setAlpha(1.0f);
            this.V.clearAnimation();
            if (this.W.indexOfChild(this.V) < 0) {
                this.W.addView(this.V, new ViewGroup.LayoutParams(-1, -1));
            }
        }
    }

    public void K() {
        PreviewFrameLayout previewFrameLayout;
        com.oppo.camera.e.a("CameraPreviewUI", "hideBlurView, mBlurCover: " + this.V);
        ImageView imageView = this.V;
        if (imageView != null && (previewFrameLayout = this.W) != null) {
            previewFrameLayout.removeView(imageView);
        }
    }

    /* access modifiers changed from: private */
    public void aq() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(10);
        alphaAnimation.setAnimationListener(this.aI);
        if (this.ab == null) {
            this.ab = b((ViewGroup) this.W);
        }
        this.ab.startAnimation(alphaAnimation);
        this.aC = true;
    }

    public void L() {
        if (!this.s) {
            this.aC = false;
            if (this.ab == null) {
                this.ab = b((ViewGroup) this.W);
            }
            this.ab.setImageBitmap((Bitmap) null);
            this.ab.setVisibility(0);
            this.ab.setBackgroundColor(-16777216);
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setInterpolator(new c());
            alphaAnimation.setDuration(50);
            alphaAnimation.setAnimationListener(this.aH);
            this.ab.clearAnimation();
            this.ab.startAnimation(alphaAnimation);
        }
    }

    public void b(int i2, int i3) {
        b bVar = this.T;
        if (bVar != null) {
            bVar.i(i2, i3);
        }
        l(true);
        this.t = 0;
    }

    /* access modifiers changed from: private */
    public int ar() {
        int i2;
        synchronized (this.j) {
            i2 = this.t;
        }
        return i2;
    }

    /* access modifiers changed from: private */
    public int as() {
        int i2;
        synchronized (this.j) {
            i2 = this.u;
        }
        return i2;
    }

    /* access modifiers changed from: private */
    public int at() {
        int i2;
        synchronized (this.j) {
            i2 = this.y;
        }
        return i2;
    }

    /* access modifiers changed from: private */
    public int au() {
        int i2;
        synchronized (this.j) {
            i2 = this.z;
        }
        return i2;
    }

    private void l(boolean z2) {
        synchronized (this) {
            this.m = z2;
        }
    }

    /* access modifiers changed from: private */
    public boolean av() {
        boolean z2;
        synchronized (this) {
            z2 = this.m;
        }
        return z2;
    }

    public Rect M() {
        Rect rect;
        synchronized (this.j) {
            int i2 = this.w == 0 ? this.u : this.w;
            rect = new Rect(this.t, i2, this.t + this.y, (this.al == null ? this.z : this.al.getWidth()) + i2);
        }
        return rect;
    }

    public void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        if (i2 != i6 || i3 != i7 || i4 != i8 || i5 != i9) {
            int i10 = i4 - i2;
            int i11 = i5 - i3;
            if (Util.a(this.G) % 180 == 0) {
                this.I.c(i10, i11);
            } else {
                this.I.c(i11, i10);
            }
        }
    }

    public void g(boolean z2) {
        FaceView faceView = this.L;
        if (faceView != null && !this.o) {
            faceView.setMirror(z2);
            this.L.setVisibility(0);
            this.L.c();
            this.L.e();
            this.o = true;
        }
    }

    public void N() {
        Activity activity = this.G;
        if (activity != null) {
            activity.runOnUiThread(new Runnable() {
                public void run() {
                    if (d.this.L != null) {
                        d.this.L.d();
                        d.this.L.c();
                        boolean unused = d.this.o = false;
                    }
                }
            });
        }
    }

    public void O() {
        MultiFocusView multiFocusView = this.N;
        if (multiFocusView != null && !this.p) {
            multiFocusView.setVisibility(0);
            this.N.d();
            this.p = true;
        }
    }

    public void P() {
        Activity activity = this.G;
        if (activity != null) {
            activity.runOnUiThread(new Runnable() {
                public void run() {
                    if (d.this.N != null) {
                        d.this.N.c();
                        boolean unused = d.this.p = false;
                    }
                }
            });
        }
    }

    public void Q() {
        this.S = this.R;
    }

    public boolean a(MotionEvent motionEvent) {
        ImageView imageView = this.U;
        if (imageView == null || !imageView.isShown()) {
            return false;
        }
        com.oppo.camera.e.a("CameraPreviewUI", "dispatchTouchEvent, mReviewImage is show");
        return true;
    }

    public GLRootView R() {
        return this.aq;
    }

    public void a(DialogInterface.OnCancelListener onCancelListener) {
        new b.a(this.G, R.style.DialogAlert).setTitle((CharSequence) this.G.getResources().getString(R.string.camera_video_rec_disable_title)).setNegativeButton((int) R.string.camera_button_ok, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        }).setOnCancelListener(onCancelListener).show();
    }

    public void a(boolean z2, boolean z3) {
        com.oppo.camera.e.c("CameraPreviewUI", "showHyperLapseFocusView, show: " + z2);
        if (!z2 || this.k) {
            HyperLapseFocusView hyperLapseFocusView = this.at;
            if (hyperLapseFocusView != null) {
                hyperLapseFocusView.setVisibility(8);
            }
            ay();
            return;
        }
        if (this.at == null) {
            aw();
        }
        ax();
        if (z3 && !this.H.getBoolean("key_video_hyper_lapse_focus_first_hints", false)) {
            this.H.edit().putBoolean("key_video_hyper_lapse_focus_first_hints", true).apply();
            S();
        }
    }

    private void aw() {
        if (this.at == null) {
            this.at = (HyperLapseFocusView) this.G.getLayoutInflater().inflate(R.layout.view_hyper_lapse_focus, this.W).findViewById(R.id.hyper_lapse_focus_view);
            this.at.a(this.aL);
            this.av = this.G.getResources().getDimensionPixelSize(R.dimen.video_hyper_lapse_focus_top_margin);
        }
    }

    private void ax() {
        HyperLapseFocusView hyperLapseFocusView = this.at;
        if (hyperLapseFocusView != null && hyperLapseFocusView.getVisibility() != 0) {
            int dimensionPixelSize = this.G.getResources().getDimensionPixelSize(R.dimen.video_hyper_lapse_focus_width);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.at.getLayoutParams();
            layoutParams.topMargin = this.av - Util.z();
            layoutParams.leftMargin = (Util.E() - dimensionPixelSize) / 2;
            this.at.setLayoutParams(layoutParams);
            this.at.setVisibility(0);
        }
    }

    public void S() {
        if (this.au == null) {
            this.au = new j(this.G);
            this.au.a(true);
            this.au.a((CharSequence) this.G.getString(R.string.camera_video_hyper_lapse_focus_hint));
            this.au.setFocusable(false);
            this.au.setTouchInterceptor(new View.OnTouchListener() {
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    d.this.H.edit().putBoolean("key_video_hyper_lapse_focus_first_hints", true).apply();
                    return false;
                }
            });
            this.au.setOnDismissListener(new PopupWindow.OnDismissListener() {
                public void onDismiss() {
                    d.this.H.edit().putBoolean("key_video_hyper_lapse_focus_first_hints", true).apply();
                }
            });
            this.aF.post(new Runnable() {
                public void run() {
                    if (d.this.au != null && d.this.at != null) {
                        d.this.au.a((View) d.this.at);
                    }
                }
            });
        }
    }

    private void ay() {
        j jVar = this.au;
        if (jVar != null) {
            jVar.dismiss();
            this.au = null;
        }
    }

    public String T() {
        HyperLapseFocusView hyperLapseFocusView = this.at;
        if (hyperLapseFocusView == null || this.W == null) {
            return "";
        }
        int[] iArr = new int[2];
        hyperLapseFocusView.getLocationOnScreen(iArr);
        int width = iArr[0] + (this.at.getWidth() / 2);
        int height = (iArr[1] + (this.at.getHeight() / 2)) - this.W.getTop();
        return width + "x" + height;
    }

    public void U() {
        color.support.v7.app.b bVar = this.J;
        if (bVar == null || !bVar.isShowing()) {
            this.J = null;
            return;
        }
        this.J.cancel();
        this.J = null;
        b(this.aJ);
    }

    private void b(DialogInterface.OnClickListener onClickListener) {
        if (this.ae != null) {
            color.support.v7.app.b bVar = this.J;
            if (bVar == null || !bVar.isShowing()) {
                color.support.v7.app.b bVar2 = this.J;
                if (bVar2 != null) {
                    bVar2.dismiss();
                }
                this.K = new b.a(this.G, R.style.DialogAlert);
                this.K.setTitle((CharSequence) this.ae);
                this.K.setOnKeyListener((DialogInterface.OnKeyListener) new DialogInterface.OnKeyListener() {
                    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                        if (i != 4 || keyEvent.getRepeatCount() != 0) {
                            return false;
                        }
                        d.this.J.dismiss();
                        return false;
                    }
                });
                int i2 = z.t;
                if (i2 == 1) {
                    if (z.s == 1 || z.s == 4 || z.s == 5) {
                        a(onClickListener);
                    }
                    if (z.s == 2 || z.s == 3) {
                        V();
                    }
                } else if (i2 == 2 || i2 == 3) {
                    if (z.s == 5) {
                        W();
                    }
                    if (z.s == 1 || z.s == 4) {
                        a(onClickListener);
                    }
                }
                this.J = this.K.create();
                this.J.show();
            }
        }
    }

    public void V() {
        Resources resources = this.G.getResources();
        boolean z2 = this.aD;
        int i2 = R.array.storage_tip_internal_full_external_available_can_clean;
        String[] stringArray = resources.getStringArray(z2 ? R.array.storage_tip_internal_full_external_available_can_clean : R.array.storage_tip_internal_full_external_available_can_not_clean);
        int i3 = z.s;
        final boolean z3 = false;
        if (i3 == 2) {
            Resources resources2 = this.G.getResources();
            if (!this.aD) {
                i2 = R.array.storage_tip_internal_full_external_available_can_not_clean;
            }
            stringArray = resources2.getStringArray(i2);
            z3 = true;
        } else if (i3 == 3) {
            stringArray = this.G.getResources().getStringArray(this.aD ? R.array.storage_tip_external_full_internal_available_can_clean : R.array.storage_tip_external_full_internal_available_can_not_clean);
        }
        this.K.setItems((CharSequence[]) stringArray, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                if (dialogInterface == null) {
                    return;
                }
                if (i == 0) {
                    dialogInterface.dismiss();
                    if (d.this.aD) {
                        Intent intent = new Intent("com.oppo.cleandroid.ui.ClearMainActivity");
                        intent.setPackage("com.coloros.phonemanager");
                        try {
                            intent.addFlags(67108864);
                            d.this.G.startActivity(intent);
                        } catch (Exception e) {
                            com.oppo.camera.e.e("CameraPreviewUI", "makeMultipleOptionStorageDialog, Exception when start ClearMainActivity: " + e);
                        }
                    }
                } else if (i == 1) {
                    String string = d.this.H.getString("pref_camera_storage_key", d.this.G.getString(R.string.camera_storage_default_value));
                    if (z3) {
                        if ("off".equals(string)) {
                            SharedPreferences.Editor edit = d.this.H.edit();
                            edit.putString("pref_camera_storage_key", "on");
                            edit.apply();
                        }
                        z.r = "on";
                    } else {
                        if ("on".equals(string)) {
                            SharedPreferences.Editor edit2 = d.this.H.edit();
                            edit2.putString("pref_camera_storage_key", "off");
                            edit2.apply();
                        }
                        z.r = "off";
                    }
                    z.t = z.b(z.r);
                } else if (i == 2) {
                    dialogInterface.dismiss();
                }
            }
        });
    }

    public void a(DialogInterface.OnClickListener onClickListener) {
        this.K.setPositiveButton(this.aD ? R.string.camera_storage_button_clean : R.string.camera_button_ok, onClickListener);
        this.K.setNegativeButton((int) R.string.camera_storage_button_cancel, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                if (dialogInterface != null) {
                    dialogInterface.dismiss();
                }
            }
        });
    }

    public void W() {
        this.K.setNegativeButton((int) R.string.camera_button_ok, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                if (dialogInterface != null && "on".equals(d.this.H.getString("pref_camera_storage_key", d.this.G.getString(R.string.camera_storage_default_value)))) {
                    SharedPreferences.Editor edit = d.this.H.edit();
                    edit.putString("pref_camera_storage_key", "off");
                    edit.commit();
                    d.this.T.bw();
                }
            }
        });
    }

    public void X() {
        com.oppo.camera.e.a("CameraPreviewUI", "updateStorageHint(), storage_status = " + z.t + ", Storage.sStorageOverrideState = " + z.s);
        int i2 = z.t;
        if (i2 == 0) {
            color.support.v7.app.b bVar = this.J;
            if (bVar != null) {
                bVar.cancel();
            }
        } else if (i2 == 1) {
            if (z.s == 1) {
                this.ae = this.G.getString(R.string.camera_storage_all_full);
            } else if (z.s == 2) {
                this.ae = this.G.getString(R.string.camera_storage_internal_full_external_avaliable);
            } else if (z.s == 3) {
                this.ae = this.G.getString(R.string.camera_storage_internal_avaliable_external_full);
            } else if (z.s == 4) {
                this.ae = this.G.getString(R.string.camera_storage_internal_fullL_external_full);
            } else if (z.s == 5) {
                this.ae = this.G.getString(R.string.camera_storage_all_full);
            }
            b(this.aJ);
        } else if (i2 == 2 || i2 == 3) {
            if (z.s == 5) {
                this.ae = this.G.getString(R.string.camera_storage_external_fail);
            } else if (z.s == 1) {
                this.ae = this.G.getString(R.string.camera_storage_all_full);
            } else if (z.s == 4) {
                this.ae = this.G.getString(R.string.camera_storage_internal_fullL_external_full);
            }
            b(this.aJ);
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0149  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x015b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(int r7, int r8, boolean r9, boolean r10, boolean r11) {
        /*
            r6 = this;
            if (r10 != 0) goto L_0x0003
            return
        L_0x0003:
            java.lang.Object r10 = r6.j
            monitor-enter(r10)
            android.util.Size r0 = r6.ag     // Catch:{ all -> 0x0198 }
            if (r0 != 0) goto L_0x000c
            monitor-exit(r10)     // Catch:{ all -> 0x0198 }
            return
        L_0x000c:
            com.oppo.camera.ui.preview.e r0 = r6.I     // Catch:{ all -> 0x0198 }
            int r0 = r0.e()     // Catch:{ all -> 0x0198 }
            com.oppo.camera.ui.preview.e r1 = r6.I     // Catch:{ all -> 0x0198 }
            int r1 = r1.f()     // Catch:{ all -> 0x0198 }
            int r2 = com.oppo.camera.util.Util.E()     // Catch:{ all -> 0x0198 }
            float r2 = (float) r2     // Catch:{ all -> 0x0198 }
            com.oppo.camera.ui.preview.e r3 = r6.I     // Catch:{ all -> 0x0198 }
            float r3 = r3.a()     // Catch:{ all -> 0x0198 }
            float r2 = r2 * r3
            int r2 = (int) r2     // Catch:{ all -> 0x0198 }
            r6.an = r2     // Catch:{ all -> 0x0198 }
            int r2 = com.oppo.camera.util.Util.E()     // Catch:{ all -> 0x0198 }
            float r2 = (float) r2     // Catch:{ all -> 0x0198 }
            float r0 = (float) r0     // Catch:{ all -> 0x0198 }
            float r2 = r2 / r0
            float r7 = (float) r7     // Catch:{ all -> 0x0198 }
            float r3 = r0 * r2
            r4 = 1073741824(0x40000000, float:2.0)
            float r5 = r3 / r4
            float r7 = r7 - r5
            int r7 = java.lang.Math.round(r7)     // Catch:{ all -> 0x0198 }
            r6.t = r7     // Catch:{ all -> 0x0198 }
            float r7 = (float) r8     // Catch:{ all -> 0x0198 }
            float r8 = (float) r1     // Catch:{ all -> 0x0198 }
            float r2 = r2 * r8
            float r2 = r2 / r4
            float r7 = r7 - r2
            int r7 = java.lang.Math.round(r7)     // Catch:{ all -> 0x0198 }
            r6.u = r7     // Catch:{ all -> 0x0198 }
            int r7 = r6.u     // Catch:{ all -> 0x0198 }
            com.oppo.camera.ui.preview.PreviewFrameLayout r1 = r6.W     // Catch:{ all -> 0x0198 }
            int r1 = r1.getTop()     // Catch:{ all -> 0x0198 }
            if (r7 >= r1) goto L_0x0059
            com.oppo.camera.ui.preview.PreviewFrameLayout r7 = r6.W     // Catch:{ all -> 0x0198 }
            int r7 = r7.getTop()     // Catch:{ all -> 0x0198 }
            r6.u = r7     // Catch:{ all -> 0x0198 }
        L_0x0059:
            int r7 = r6.t     // Catch:{ all -> 0x0198 }
            com.oppo.camera.ui.preview.PreviewFrameLayout r1 = r6.W     // Catch:{ all -> 0x0198 }
            int r1 = r1.getLeft()     // Catch:{ all -> 0x0198 }
            if (r7 >= r1) goto L_0x006b
            com.oppo.camera.ui.preview.PreviewFrameLayout r7 = r6.W     // Catch:{ all -> 0x0198 }
            int r7 = r7.getLeft()     // Catch:{ all -> 0x0198 }
            r6.t = r7     // Catch:{ all -> 0x0198 }
        L_0x006b:
            int r7 = r6.u     // Catch:{ all -> 0x0198 }
            com.oppo.camera.ui.preview.PreviewFrameLayout r1 = r6.W     // Catch:{ all -> 0x0198 }
            int r1 = r1.getTop()     // Catch:{ all -> 0x0198 }
            r2 = 0
            if (r7 == r1) goto L_0x0081
            if (r9 != 0) goto L_0x007f
            int r7 = com.oppo.camera.util.Util.v()     // Catch:{ all -> 0x0198 }
            r6.u = r7     // Catch:{ all -> 0x0198 }
            goto L_0x0081
        L_0x007f:
            r6.u = r2     // Catch:{ all -> 0x0198 }
        L_0x0081:
            int r7 = java.lang.Math.round(r3)     // Catch:{ all -> 0x0198 }
            r6.y = r7     // Catch:{ all -> 0x0198 }
            r7 = 1065353216(0x3f800000, float:1.0)
            float r8 = r8 * r7
            float r8 = r8 / r0
            int r7 = r6.an     // Catch:{ all -> 0x0198 }
            float r7 = (float) r7     // Catch:{ all -> 0x0198 }
            float r8 = r8 * r7
            int r7 = java.lang.Math.round(r8)     // Catch:{ all -> 0x0198 }
            r6.z = r7     // Catch:{ all -> 0x0198 }
            r6.l((boolean) r2)     // Catch:{ all -> 0x0198 }
            com.oppo.camera.ui.preview.d$b r7 = r6.T     // Catch:{ all -> 0x0198 }
            boolean r7 = r7.bv()     // Catch:{ all -> 0x0198 }
            if (r7 != 0) goto L_0x0111
            com.oppo.camera.ui.preview.d$b r7 = r6.T     // Catch:{ all -> 0x0198 }
            boolean r7 = r7.cU()     // Catch:{ all -> 0x0198 }
            if (r7 == 0) goto L_0x00a9
            goto L_0x0111
        L_0x00a9:
            int r7 = com.oppo.camera.util.Util.v()     // Catch:{ all -> 0x0198 }
            r6.u = r7     // Catch:{ all -> 0x0198 }
            int r7 = r6.Q     // Catch:{ all -> 0x0198 }
            r8 = 3
            if (r7 == r8) goto L_0x00ed
            int r7 = r6.y     // Catch:{ all -> 0x0198 }
            double r7 = (double) r7     // Catch:{ all -> 0x0198 }
            r0 = 4610685218510194460(0x3ffc71c71c71c71c, double:1.7777777777777777)
            double r7 = r7 * r0
            int r7 = (int) r7     // Catch:{ all -> 0x0198 }
            r6.z = r7     // Catch:{ all -> 0x0198 }
            boolean r7 = com.oppo.camera.util.Util.F()     // Catch:{ all -> 0x0198 }
            if (r7 != 0) goto L_0x00d6
            int r7 = com.oppo.camera.util.Util.C()     // Catch:{ all -> 0x0198 }
            int r8 = com.oppo.camera.util.Util.z()     // Catch:{ all -> 0x0198 }
            int r7 = r7 - r8
            int r8 = com.oppo.camera.util.Util.A()     // Catch:{ all -> 0x0198 }
            int r7 = r7 - r8
            r6.z = r7     // Catch:{ all -> 0x0198 }
        L_0x00d6:
            boolean r7 = r6.q     // Catch:{ all -> 0x0198 }
            if (r7 == 0) goto L_0x00ed
            android.util.Size r7 = r6.al     // Catch:{ all -> 0x0198 }
            int r7 = r7.getWidth()     // Catch:{ all -> 0x0198 }
            android.util.Size r8 = r6.al     // Catch:{ all -> 0x0198 }
            int r8 = r8.getHeight()     // Catch:{ all -> 0x0198 }
            int r7 = com.oppo.camera.util.Util.b((int) r7, (int) r8)     // Catch:{ all -> 0x0198 }
            r6.h((int) r7)     // Catch:{ all -> 0x0198 }
        L_0x00ed:
            android.util.Size r7 = r6.al     // Catch:{ all -> 0x0198 }
            if (r7 == 0) goto L_0x0143
            boolean r7 = r6.q     // Catch:{ all -> 0x0198 }
            if (r7 == 0) goto L_0x0143
            android.util.Size r7 = r6.al     // Catch:{ all -> 0x0198 }
            int r7 = r7.getWidth()     // Catch:{ all -> 0x0198 }
            android.util.Size r8 = r6.al     // Catch:{ all -> 0x0198 }
            int r8 = r8.getHeight()     // Catch:{ all -> 0x0198 }
            int r7 = com.oppo.camera.util.Util.b((int) r7, (int) r8)     // Catch:{ all -> 0x0198 }
            r8 = 2
            if (r7 <= r8) goto L_0x0143
            r6.u = r2     // Catch:{ all -> 0x0198 }
            int r7 = com.oppo.camera.util.Util.C()     // Catch:{ all -> 0x0198 }
            r6.z = r7     // Catch:{ all -> 0x0198 }
            goto L_0x0143
        L_0x0111:
            boolean r7 = r6.q     // Catch:{ all -> 0x0198 }
            if (r7 == 0) goto L_0x0126
            android.util.Size r7 = r6.al     // Catch:{ all -> 0x0198 }
            int r7 = r7.getWidth()     // Catch:{ all -> 0x0198 }
            android.util.Size r8 = r6.al     // Catch:{ all -> 0x0198 }
            int r8 = r8.getHeight()     // Catch:{ all -> 0x0198 }
            int r7 = com.oppo.camera.util.Util.b((int) r7, (int) r8)     // Catch:{ all -> 0x0198 }
            goto L_0x0136
        L_0x0126:
            android.util.Size r7 = r6.ag     // Catch:{ all -> 0x0198 }
            int r7 = r7.getWidth()     // Catch:{ all -> 0x0198 }
            android.util.Size r8 = r6.ag     // Catch:{ all -> 0x0198 }
            int r8 = r8.getHeight()     // Catch:{ all -> 0x0198 }
            int r7 = com.oppo.camera.util.Util.b((int) r7, (int) r8)     // Catch:{ all -> 0x0198 }
        L_0x0136:
            if (r11 != 0) goto L_0x0140
            com.oppo.camera.ui.preview.d$b r8 = r6.T     // Catch:{ all -> 0x0198 }
            boolean r8 = r8.cU()     // Catch:{ all -> 0x0198 }
            if (r8 != 0) goto L_0x0143
        L_0x0140:
            r6.h((int) r7)     // Catch:{ all -> 0x0198 }
        L_0x0143:
            int r7 = r6.v     // Catch:{ all -> 0x0198 }
            int r8 = r6.u     // Catch:{ all -> 0x0198 }
            if (r7 == r8) goto L_0x0157
            r7 = 1
            r6.r = r7     // Catch:{ all -> 0x0198 }
            int r7 = r6.u     // Catch:{ all -> 0x0198 }
            r6.w = r7     // Catch:{ all -> 0x0198 }
            int r7 = r6.w     // Catch:{ all -> 0x0198 }
            int r8 = r6.v     // Catch:{ all -> 0x0198 }
            int r7 = r7 - r8
            r6.x = r7     // Catch:{ all -> 0x0198 }
        L_0x0157:
            com.oppo.camera.ui.preview.MultiFocusView r7 = r6.N     // Catch:{ all -> 0x0198 }
            if (r7 == 0) goto L_0x0160
            com.oppo.camera.ui.preview.MultiFocusView r7 = r6.N     // Catch:{ all -> 0x0198 }
            r7.g()     // Catch:{ all -> 0x0198 }
        L_0x0160:
            java.lang.String r7 = "CameraPreviewUI"
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x0198 }
            r8.<init>()     // Catch:{ all -> 0x0198 }
            java.lang.String r9 = "layoutPreview, l: "
            r8.append(r9)     // Catch:{ all -> 0x0198 }
            int r9 = r6.t     // Catch:{ all -> 0x0198 }
            r8.append(r9)     // Catch:{ all -> 0x0198 }
            java.lang.String r9 = ", t: "
            r8.append(r9)     // Catch:{ all -> 0x0198 }
            int r9 = r6.u     // Catch:{ all -> 0x0198 }
            r8.append(r9)     // Catch:{ all -> 0x0198 }
            java.lang.String r9 = ", w: "
            r8.append(r9)     // Catch:{ all -> 0x0198 }
            int r9 = r6.y     // Catch:{ all -> 0x0198 }
            r8.append(r9)     // Catch:{ all -> 0x0198 }
            java.lang.String r9 = ", h: "
            r8.append(r9)     // Catch:{ all -> 0x0198 }
            int r9 = r6.z     // Catch:{ all -> 0x0198 }
            r8.append(r9)     // Catch:{ all -> 0x0198 }
            java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x0198 }
            com.oppo.camera.e.a(r7, r8)     // Catch:{ all -> 0x0198 }
            monitor-exit(r10)     // Catch:{ all -> 0x0198 }
            return
        L_0x0198:
            r7 = move-exception
            monitor-exit(r10)     // Catch:{ all -> 0x0198 }
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.ui.preview.d.a(int, int, boolean, boolean, boolean):void");
    }

    private void h(int i2) {
        if (i2 == 0) {
            this.u = Util.v();
        } else if (i2 != 1) {
            if (i2 != 2) {
                this.u = 0;
                this.z = Util.C();
                return;
            }
            this.u = Util.t() + Util.v();
        } else if (Util.F()) {
            this.u = Util.v();
        } else {
            this.u = 0;
            this.z = Util.C();
        }
    }

    /* access modifiers changed from: private */
    public void az() {
        com.oppo.camera.e.a("CameraPreviewUI", "notifyPreviewImageAnimOnStart");
        a aVar = this.ao;
        if (aVar != null) {
            aVar.a(this.aj);
        }
        Activity activity = this.G;
        if (activity != null) {
            activity.onUserInteraction();
        }
    }

    /* access modifiers changed from: private */
    public void aA() {
        com.oppo.camera.e.a("CameraPreviewUI", "notifyPreviewImageAnimOnMiddle, mbCancleBlurAnimation: " + this.n);
        a aVar = this.ao;
        if (aVar != null) {
            aVar.a(this.ak, this.aj);
        }
    }

    public void Y() {
        com.oppo.camera.e.a("CameraPreviewUI", "cancelBlurAnimation");
        this.n = true;
        Handler handler = this.aF;
        if (handler != null) {
            handler.removeMessages(1);
            this.aF.removeMessages(2);
        }
    }

    public void Z() {
        this.q = false;
    }

    public void aa() {
        boolean z2;
        if (this.ak != null && this.aj != null && this.ao != null && !(z2 = this.n)) {
            if (z2) {
                com.oppo.camera.e.a("CameraPreviewUI", "notifyPreviewImageAnimationOnMiddle cancel animation");
                return;
            }
            this.aF.removeMessages(2);
            this.aF.sendEmptyMessage(2);
        }
    }

    public void a(Size size, Size size2, final a aVar, int i2, int i3, int i4, boolean z2) {
        int i5 = i2;
        com.oppo.camera.e.a("CameraPreviewUI", "startShowPreviewImageAnimation, size: " + size.getWidth() + " x " + size.getHeight() + " => " + size2.getWidth() + " x " + size2.getHeight() + ", moreTime: " + i2);
        this.ak = size;
        this.aj = size2;
        this.ao = aVar;
        this.n = false;
        this.I.a((e.a) new e.a() {
            public void a() {
                a aVar;
                boolean unused = d.this.q = false;
                if (!d.this.k && (aVar = aVar) != null) {
                    aVar.a();
                }
            }
        });
        c();
        a(size, size2, i3, i4);
        this.I.a(this.am, this.al);
        aB();
        a((this.W.getRight() - this.W.getLeft()) / 2, (this.W.getBottom() - this.W.getTop()) / 2, false, true, z2);
        com.oppo.camera.e.a("CameraPreviewUI", "startShowPreviewImageAnimation, perivew size change: " + this.ak.getWidth() + " x " + this.ak.getHeight() + " => " + this.aj.getWidth() + " x " + this.aj.getHeight() + ", mHeight: " + this.z + ", mWidth: " + this.y + ", offSetY: " + as() + ", mDiffSize: " + this.A);
        Activity activity = this.G;
        if (activity != null) {
            activity.runOnUiThread(new Runnable() {
                public void run() {
                    if (d.this.G != null) {
                        d.this.G.onUserInteraction();
                    }
                }
            });
        }
        if (!this.n) {
            this.aF.removeMessages(1);
            this.aF.sendEmptyMessageDelayed(1, (long) i5);
        }
    }

    private void aB() {
        synchronized (this.j) {
            this.A = this.al.getWidth() - this.am.getWidth();
            this.F = SystemClock.uptimeMillis();
            this.q = true;
            this.v = this.u;
            this.r = false;
            this.x = 0;
        }
    }

    private void a(Size size, Size size2, int i2, int i3) {
        com.oppo.camera.e.a("CameraPreviewUI", "updateDisplaySize, Size width: " + size.getWidth() + " x " + size.getHeight() + " => " + size2.getWidth() + " x " + size2.getHeight() + ", mHeight: " + this.z + ", mWidth: " + this.y);
        if (this.I.v()) {
            this.am = new Size(this.z, this.y);
            int i4 = this.y;
            this.al = new Size((int) ((((double) size2.getWidth()) / ((double) size2.getHeight())) * ((double) i4)), i4);
        } else if (size.getWidth() == size2.getWidth() && size.getHeight() == size2.getHeight()) {
            this.am = size;
            this.al = size2;
        } else {
            this.am = new Size((int) ((((double) size.getWidth()) / ((double) size.getHeight())) * ((double) i2)), i2);
            this.al = new Size((int) ((((double) size2.getWidth()) / ((double) size2.getHeight())) * ((double) i3)), i3);
            com.oppo.camera.e.a("CameraPreviewUI", "updateDisplaySize, DisplaySize: " + this.am.getWidth() + " x " + this.am.getHeight() + " => " + this.al.getWidth() + " x " + this.al.getHeight());
        }
    }

    public void h(boolean z2) {
        FaceView faceView = this.L;
        if (faceView != null) {
            faceView.setShowBeauty3DFace(z2);
        }
    }

    public void e(int i2) {
        FaceView faceView = this.L;
        if (faceView != null) {
            faceView.setMainFaceIndex(i2);
        }
    }

    public void ab() {
        GLRootView gLRootView = this.aq;
        if (gLRootView != null) {
            gLRootView.a();
        }
        b bVar = this.T;
        if (bVar != null) {
            bVar.bx();
        }
    }

    public void ac() {
        b bVar = this.T;
        if (bVar != null) {
            bVar.by();
        }
    }

    public void ad() {
        GLRootView gLRootView = this.aq;
        if (gLRootView != null) {
            gLRootView.setBackground((Drawable) null);
        }
        b bVar = this.T;
        if (bVar != null) {
            bVar.bz();
        }
    }

    public void ae() {
        b bVar = this.T;
        if (bVar != null) {
            if (!this.k) {
                bVar.cY();
            }
            if (!this.T.cZ()) {
                com.oppo.camera.e.a("CameraPreviewUI", "onFirstFrameDraw, don't hide blur for some case");
                return;
            }
        }
        af();
    }

    public void af() {
        com.oppo.camera.e.a("CameraPreviewUI", "execHideBlurView");
        if (!this.k && this.W.indexOfChild(this.V) >= 0) {
            if ((this.T.bB() != 0 || com.oppo.camera.h.a(this.G.getApplicationContext()).b()) && !com.oppo.camera.h.a(this.G.getApplicationContext()).d()) {
                com.oppo.camera.h.a(this.G.getApplicationContext()).a((Runnable) new Runnable() {
                    public void run() {
                        d.this.K();
                    }
                });
            } else if (this.l) {
                this.aF.post(new Runnable() {
                    public void run() {
                        d.this.K();
                        boolean unused = d.this.l = false;
                    }
                });
            } else {
                this.aF.postAtFrontOfQueue(new Runnable() {
                    public void run() {
                        d.this.K();
                    }
                });
            }
        }
    }

    public Rect[] ag() {
        FaceView faceView = this.L;
        if (faceView != null) {
            return faceView.getFaceRects();
        }
        return null;
    }

    public void i(boolean z2) {
        e eVar = this.I;
        if (eVar != null) {
            eVar.c(z2);
        }
    }

    private void a(q qVar) {
        if (!this.aE.contains(qVar)) {
            this.aE.add(qVar);
        }
    }

    /* access modifiers changed from: private */
    public void a(com.oppo.camera.gl.h hVar) {
        if (!this.aE.isEmpty()) {
            Iterator<q> it = this.aE.iterator();
            while (it.hasNext()) {
                q next = it.next();
                if (next != null) {
                    next.a(hVar, this.h);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void b(com.oppo.camera.gl.h hVar) {
        if (!this.aE.isEmpty()) {
            Iterator<q> it = this.aE.iterator();
            while (it.hasNext()) {
                q next = it.next();
                if (next != null) {
                    next.b(hVar, this.h);
                }
            }
        }
    }

    public void b(boolean z2, boolean z3) {
        com.oppo.camera.e.b("CameraPreviewUI", "showMultiCameraTypeView, show: " + z2 + ", needAnimation: " + z3);
        if (z2) {
            if (this.ax == null) {
                aC();
            }
            this.ax.setType(this.H.getInt("pref_multicamera_type_selected_key", 0));
            if (z3) {
                Util.a((View) this.ax, 0, (Animation.AnimationListener) null, 180);
                return;
            }
            this.ax.a(this.R, true);
            this.ax.setVisibility(0);
            return;
        }
        com.oppo.camera.ui.widget.a aVar = this.ax;
        if (aVar == null) {
            return;
        }
        if (z3) {
            Util.a((View) aVar, 8, (Animation.AnimationListener) null, 180);
        } else {
            aVar.setVisibility(8);
        }
    }

    private void aC() {
        this.ax = new com.oppo.camera.ui.widget.a(this.G);
        int dimension = (int) this.G.getResources().getDimension(R.dimen.multicamera_type_layout_height);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, dimension);
        layoutParams.addRule(14);
        layoutParams.addRule(12);
        layoutParams.setMargins(0, 0, 0, Util.w() - dimension);
        this.ac.addView(this.ax, layoutParams);
        AnonymousClass21 r0 = new View.OnClickListener() {
            public void onClick(View view) {
                if (view.isEnabled() && d.this.T != null && d.this.T.cX() && d.this.D() != null && d.this.D().s() && d.this.D().t()) {
                    d.this.ax.a(view);
                }
            }
        };
        this.ax.findViewById(R.id.view_half_half).setOnClickListener(r0);
        this.ax.findViewById(R.id.view_pip_cir).setOnClickListener(r0);
        this.ax.findViewById(R.id.view_pip_rec).setOnClickListener(r0);
        this.ax.setOnTypeChangeListener(new a.C0107a() {
            public void a(int i) {
                if (d.this.T != null) {
                    d.this.T.I(i);
                }
            }
        });
    }

    public boolean ah() {
        com.oppo.camera.ui.widget.a aVar = this.ax;
        return aVar != null && aVar.getVisibility() == 0;
    }

    public void j(boolean z2) {
        com.oppo.camera.ui.widget.a aVar = this.ax;
        if (aVar != null) {
            aVar.setEnabled(z2);
        }
    }

    /* compiled from: CameraPreviewUI */
    public class c extends AccelerateInterpolator {
        public c() {
        }

        public float getInterpolation(float f) {
            if (((double) Math.abs(f - 1.0f)) <= 1.0E-6d && !d.this.aC) {
                d.this.aq();
            }
            return ((float) (Math.cos(((double) (f + 1.0f)) * 3.141592653589793d) / 2.0d)) + 0.5f;
        }
    }

    public void f(int i2) {
        com.oppo.camera.e.b("CameraPreviewUI", "setSlowVideoMotionDetectViewVisibility: " + i2);
        IntelligentDragView intelligentDragView = this.O;
        if (intelligentDragView != null) {
            if (8 == intelligentDragView.getVisibility()) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.O.getLayoutParams();
                layoutParams.addRule(14);
                int C2 = (Util.C() - Util.u()) - Util.w();
                layoutParams.setMargins(0, (int) ((((float) C2) - this.G.getResources().getDimension(R.dimen.video_intelligent_high_frame_dectect_height)) / 2.0f), 0, 0);
                this.O.setLayoutParams(layoutParams);
                this.O.setBottomRestrict(this.W.getHeight() - C2);
                this.O.b();
            }
            this.O.setVisibility(i2);
        }
    }

    public void k(boolean z2) {
        com.oppo.camera.e.b("CameraPreviewUI", "enableSlowVideoMotionDetectView: " + z2);
        IntelligentDragView intelligentDragView = this.O;
        if (intelligentDragView != null) {
            intelligentDragView.setEnabled(z2);
        }
    }

    public RectF g(int i2) {
        IntelligentDragView intelligentDragView = this.O;
        if (intelligentDragView != null) {
            return intelligentDragView.a(C(), i2);
        }
        return null;
    }

    public void ai() {
        FaceView faceView = this.L;
        if (faceView != null) {
            faceView.h();
        }
    }

    public void aj() {
        FaceView faceView = this.L;
        if (faceView != null) {
            faceView.c();
        }
    }

    public void ak() {
        if (this.H != null) {
            com.oppo.camera.e.e("CameraPreviewUI", "endFacePointAnimation");
            this.H.edit().putInt("key_camera_pid_history", Process.myPid()).putInt("key_support_front_face_point_animation", Util.f(System.currentTimeMillis())).apply();
        }
    }

    public boolean al() {
        b bVar = this.T;
        if (bVar == null || !bVar.k("key_support_front_face_point_animation") || !this.H.getBoolean("pref_camera_statement_key", false)) {
            return false;
        }
        return true;
    }

    public void a(h.b bVar) {
        FaceView faceView = this.L;
        if (faceView != null) {
            faceView.setFacePointAnimationListener(bVar);
        }
    }

    public void am() {
        if (this.ay == null) {
            int i2 = this.H.getInt("pref_double_exposure_effect_type", 5);
            this.ay = new RecyclerView(this.G);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(12);
            layoutParams.addRule(14);
            boolean z2 = false;
            layoutParams.setMargins(0, 0, 0, (int) this.G.getResources().getDimension(R.dimen.effect_menu_margin_bottom_not_zoom));
            this.ay.setVisibility(4);
            this.ay.setClipChildren(false);
            this.ac.addView(this.ay, layoutParams);
            final float dimensionPixelSize = (float) this.G.getResources().getDimensionPixelSize(R.dimen.effect_menu_margin);
            this.ay.setLayoutManager(new LinearLayoutManager(this.G, 0, false));
            this.ay.addItemDecoration(new RecyclerView.h() {
                public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.t tVar) {
                    LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
                    super.getItemOffsets(rect, view, recyclerView, tVar);
                    if (linearLayoutManager == null) {
                        return;
                    }
                    if (linearLayoutManager.getPosition(view) == 0) {
                        rect.right = (int) (dimensionPixelSize * 0.5f);
                    } else {
                        rect.left = (int) (dimensionPixelSize * 0.5f);
                    }
                }
            });
            ArrayList arrayList = new ArrayList();
            arrayList.add(new f(5, R.drawable.double_exposure_composition, this.G.getString(R.string.camera_double_exposure_type_composition), 5 == i2));
            String string = this.G.getString(R.string.camera_double_exposure_type_sketch);
            if (4 == i2) {
                z2 = true;
            }
            arrayList.add(new f(4, R.drawable.double_exposure_sketch, string, z2));
            com.oppo.camera.doubleexposure.e eVar = new com.oppo.camera.doubleexposure.e(this.G, arrayList);
            this.az = new e.b() {
                public void a(f fVar) {
                    if (d.this.T != null) {
                        d.this.T.a(fVar);
                        if (fVar != null) {
                            d.this.H.edit().putInt("pref_double_exposure_effect_type", fVar.a()).apply();
                        }
                    }
                }
            };
            eVar.a(this.az);
            this.ay.setAdapter(eVar);
        }
    }

    public void an() {
        RecyclerView recyclerView = this.ay;
        if (recyclerView != null) {
            Util.a((View) recyclerView, 4, (Animation.AnimationListener) null, 300);
        }
    }

    public RecyclerView ao() {
        if (this.ay == null) {
            am();
        }
        return this.ay;
    }

    public void a(View view, View view2, boolean z2) {
        if (view != null && view2 != null && !z2) {
            view.setVisibility(0);
            view2.setVisibility(4);
        } else if (view2 != null) {
            Interpolator loadInterpolator = AnimationUtils.loadInterpolator(view2.getContext(), R.anim.face_point_scale_interpolator2);
            if (view2.getVisibility() == 0) {
                Util.a(view2, 4, (Animation.AnimationListener) new com.oppo.camera.b.b(true, view, view2), 180, 0, loadInterpolator);
            } else if (view != null) {
                Util.a(view, 0, (Animation.AnimationListener) null, 300);
            }
        } else if (view != null) {
            Util.a(view, 0, (Animation.AnimationListener) null, 300);
        }
    }
}
