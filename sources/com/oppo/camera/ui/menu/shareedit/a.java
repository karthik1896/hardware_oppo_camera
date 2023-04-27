package com.oppo.camera.ui.menu.shareedit;

import android.app.Activity;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Size;
import android.view.MotionEvent;
import android.view.OplusWindowManager;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.OplusBezierInterpolator;
import android.view.animation.Transformation;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import com.oppo.camera.Camera;
import com.oppo.camera.R;
import com.oppo.camera.aps.config.CameraConfig;
import com.oppo.camera.aps.config.ConfigDataBase;
import com.oppo.camera.k;
import com.oppo.camera.ui.RotateImageView;
import com.oppo.camera.ui.control.ThumbImageView;
import com.oppo.camera.ui.control.e;
import com.oppo.camera.ui.f;
import com.oppo.camera.ui.inverse.c;
import com.oppo.camera.util.Util;
import java.util.ArrayList;
import java.util.Locale;

/* compiled from: ShareEditThumbMenu */
public class a implements SharedPreferences.OnSharedPreferenceChangeListener, View.OnClickListener, View.OnTouchListener {
    private float A = 0.0f;
    private float B = 0.0f;
    /* access modifiers changed from: private */
    public float C = 0.0f;
    /* access modifiers changed from: private */
    public float D = 0.0f;
    /* access modifiers changed from: private */
    public float E = 0.0f;
    /* access modifiers changed from: private */
    public FrameLayout.LayoutParams F = null;
    private RelativeLayout.LayoutParams G = null;
    /* access modifiers changed from: private */
    public RelativeLayout.LayoutParams H = null;
    /* access modifiers changed from: private */
    public RelativeLayout.LayoutParams I = null;
    /* access modifiers changed from: private */
    public RelativeLayout.LayoutParams J = null;
    private float K = 0.0f;
    private float L = 0.0f;
    private float M = 0.0f;
    private float N = 0.0f;
    private RelativeLayout O = null;
    private PopupWindow P = null;
    /* access modifiers changed from: private */
    public ShareArrowImageView Q = null;
    /* access modifiers changed from: private */
    public RotateImageView R = null;
    /* access modifiers changed from: private */
    public RotateImageView S = null;
    /* access modifiers changed from: private */
    public RotateImageView T = null;
    private ThumbImageView U = null;
    /* access modifiers changed from: private */
    public com.oppo.camera.ui.control.b V = null;
    private boolean W = false;
    private boolean X = false;
    /* access modifiers changed from: private */
    public boolean Y = false;
    private boolean Z = false;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public int f4275a = 1;
    /* access modifiers changed from: private */
    public f aA = null;
    /* access modifiers changed from: private */
    public boolean aB = false;
    /* access modifiers changed from: private */
    public boolean aC = true;
    private boolean aD = false;
    /* access modifiers changed from: private */
    public boolean aE = false;
    /* access modifiers changed from: private */
    public boolean aF = false;
    private boolean aG = false;
    private boolean aa = false;
    /* access modifiers changed from: private */
    public boolean ab = false;
    private boolean ac = false;
    private boolean ad = false;
    private boolean ae = false;
    private C0105a af = null;
    private C0105a ag = null;
    private C0105a ah = null;
    private C0105a ai = null;
    private C0105a aj = null;
    private GradientDrawable ak = null;
    private float al = o();
    /* access modifiers changed from: private */
    public float am = this.g;
    /* access modifiers changed from: private */
    public Camera an = null;
    private long ao = 0;
    private b ap = null;
    private Handler aq = null;
    private e ar = null;
    private Interpolator as = null;
    private k at = null;
    private SharedPreferences au = null;
    /* access modifiers changed from: private */
    public boolean av = false;
    private boolean[] aw = {false, false, false, false};
    private int[] ax = {R.id.thumbnail, R.id.share, R.id.edit, R.id.soloop};
    private View[] ay = null;
    /* access modifiers changed from: private */
    public b az = null;

    /* renamed from: b  reason: collision with root package name */
    private int f4276b = 1;
    /* access modifiers changed from: private */
    public float c = 0.0f;
    private float d = 0.0f;
    private float e = 0.0f;
    private float f = 0.0f;
    private float g = 0.0f;
    private float h = 0.0f;
    private float i = 0.0f;
    private float j = 0.0f;
    private float k = 0.0f;
    /* access modifiers changed from: private */
    public int l = 0;
    /* access modifiers changed from: private */
    public int m = 0;
    /* access modifiers changed from: private */
    public int n = 0;
    /* access modifiers changed from: private */
    public int o = 0;
    /* access modifiers changed from: private */
    public int p = 0;
    /* access modifiers changed from: private */
    public int q = 0;
    private int r = 0;
    private int s = 0;
    /* access modifiers changed from: private */
    public int t = 0;
    private int u = 0;
    private int v = 0;
    private int w = 0;
    private int x = 0;
    private int y = 0;
    private int z = 0;

    /* compiled from: ShareEditThumbMenu */
    public interface b {
        void a();
    }

    private int a(int i2) {
        return Util.f().getResources().getDimensionPixelSize(i2);
    }

    private void m() {
        this.t = a((int) R.dimen.thumbnail_width_nomal);
        this.v = a((int) R.dimen.share_icon_margin_bottom);
        this.u = a((int) R.dimen.thumb_margin_bottom);
        this.w = a((int) R.dimen.share_button_width);
        this.x = a((int) R.dimen.arrow_total_size);
        int i2 = this.u;
        int i3 = this.t;
        int i4 = this.w;
        int i5 = this.v;
        this.d = (float) ((i2 * 2) + i3 + i4 + i5);
        this.e = (float) ((i2 * 2) + i3 + (i4 * 2) + (i5 * 3));
        this.f = (float) ((i2 * 2) + i3 + (i4 * 3) + (i5 * 5));
        this.c = this.f + ((float) i4) + ((float) i5);
        this.g = (float) (i3 + i2 + this.x);
        this.h = (float) (i2 + i3);
        this.i = 0.0f;
        this.j = (float) a((int) R.dimen.arrow_anim_height);
        this.k = (float) a((int) R.dimen.arrow_anim_offset);
        int i6 = this.u;
        this.l = i6;
        int i7 = this.v;
        int i8 = this.t;
        int i9 = this.w;
        this.m = (i7 * 3) + i8 + i6 + (i9 * 2);
        this.n = i6;
        this.o = (i7 * 2) + i8 + i6 + i9;
        this.p = i6;
        this.q = i7 + i8 + i6;
        this.r = a((int) R.dimen.share_button_width);
        this.y = a((int) R.dimen.share_anim_up_region);
        this.z = a((int) R.dimen.share_anim_down_region);
        this.s = this.t + (this.u * 2);
    }

    private void n() {
        this.P = new PopupWindow(this.O, this.s, (int) this.c);
        this.P.setSplitTouchEnabled(false);
        this.O.setBackgroundResource(R.drawable.share_and_edit_layout_background_drawable);
        this.ak = (GradientDrawable) this.O.getBackground();
        this.ak.setCornerRadius((float) (this.s / 2));
        this.U = (ThumbImageView) this.O.findViewById(R.id.thumbnail);
        this.D = (float) (a((int) R.dimen.thumbnail_margin_start) - ((((this.s - this.t) - this.U.getPaddingLeft()) - this.U.getPaddingRight()) / 2));
        this.E = (float) ((((a((int) R.dimen.control_panel_button_height) - this.t) / 2) - this.u) + ((Util.w() - Util.x()) - a((int) R.dimen.control_panel_margin_top)));
        this.P.setTouchInterceptor(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    if (a.this.aA != null) {
                        a.this.aA.g(true);
                    }
                    a aVar = a.this;
                    boolean unused = aVar.aB = aVar.V != null && !a.this.V.ak() && (a.this.c - motionEvent.getY() < ((float) a.this.t) || (a.this.B() && a.this.c - motionEvent.getY() < ((float) a.this.F.height)));
                }
                if (a.this.aB && a.this.aC) {
                    return false;
                }
                motionEvent.setLocation(a.this.aE ? motionEvent.getRawX() : motionEvent.getX() + a.this.D, ((motionEvent.getY() + ((float) Util.C())) - a.this.E) - a.this.c);
                a.this.an.dispatchTouchEvent(motionEvent);
                return true;
            }
        });
        this.Q = (ShareArrowImageView) this.V.al().findViewById(R.id.up_arrow);
        c.INS.registerInverse(this.an, this.Q);
        this.R = (RotateImageView) this.O.findViewById(R.id.share);
        this.S = (RotateImageView) this.O.findViewById(R.id.edit);
        this.T = (RotateImageView) this.O.findViewById(R.id.soloop);
        this.ay = new View[4];
        View[] viewArr = this.ay;
        viewArr[0] = this.U;
        viewArr[1] = this.R;
        viewArr[2] = this.S;
        viewArr[3] = this.T;
        this.O.setOnTouchListener(this);
        this.Q.setOnTouchListener(this);
        this.S.setOnTouchListener(this);
        this.R.setOnTouchListener(this);
        this.T.setOnTouchListener(this);
        this.R.setOnClickListener(this);
        this.S.setOnClickListener(this);
        this.T.setOnClickListener(this);
        this.G = (RelativeLayout.LayoutParams) this.Q.getLayoutParams();
        this.H = (RelativeLayout.LayoutParams) this.S.getLayoutParams();
        this.I = (RelativeLayout.LayoutParams) this.R.getLayoutParams();
        this.J = (RelativeLayout.LayoutParams) this.T.getLayoutParams();
        this.U.setOnTouchListener(this);
    }

    public a(RelativeLayout relativeLayout, com.oppo.camera.ui.control.b bVar, Activity activity, k kVar, b bVar2, f fVar) {
        this.O = relativeLayout;
        this.az = bVar2;
        this.aA = fVar;
        this.at = kVar;
        this.au = Util.f().getSharedPreferences("soloop_info", 0);
        this.au.registerOnSharedPreferenceChangeListener(this);
        this.V = bVar;
        this.an = (Camera) activity;
        this.ar = this.V.q();
        e eVar = this.ar;
        this.Y = eVar != null && Util.a(eVar.d());
        this.Z = this.ar != null && l();
        m();
        n();
        this.ap = new b(6.0f, 2.0f);
        this.as = new OplusBezierInterpolator(0.6600000262260437d, 0.0d, 0.3400000035762787d, 1.0d, true);
        this.aq = new Handler(Looper.getMainLooper()) {
            public void handleMessage(Message message) {
                if (message.what == 2) {
                    boolean unused = a.this.av = true;
                    a.this.a(true, true);
                }
            }
        };
        a(false, true);
    }

    public void a() {
        Handler handler = this.aq;
        if (handler != null) {
            handler.removeMessages(2);
        }
        PopupWindow popupWindow = this.P;
        if (popupWindow != null && popupWindow.isShowing()) {
            this.P.dismiss();
        }
    }

    public void b() {
        Camera camera = this.an;
        if (camera != null && !camera.isFinishing()) {
            boolean z2 = true;
            if (1 != androidx.core.e.f.a(Locale.getDefault())) {
                z2 = false;
            }
            this.aE = z2;
            this.P.showAtLocation((RelativeLayout) this.an.findViewById(R.id.camera), (this.aE ? 8388613 : 8388611) | 80, (int) this.D, (int) this.E);
            this.F = (FrameLayout.LayoutParams) this.O.getLayoutParams();
            this.F.gravity = 80;
        }
    }

    private float o() {
        if (this.Y && this.Z) {
            return this.f;
        }
        if (this.Y || this.Z) {
            return this.e;
        }
        return this.d;
    }

    public void a(int i2, boolean z2) {
        this.R.a(i2, z2);
        this.S.a(i2, z2);
        this.T.a(i2, z2);
    }

    public void a(e eVar) {
        this.ar = eVar;
        k();
    }

    public void b(e eVar) {
        this.aa = true;
        c(eVar);
        d(eVar);
        if (s() && this.U.getVisibility() == 0) {
            c(this.g);
            c(1);
            k kVar = this.at;
            if (kVar == null || eVar == null || !kVar.getBoolean("share_edit_video_show_expand", false) || Util.a(eVar.d()) || !K()) {
                if (this.aC) {
                    p();
                } else {
                    this.aD = true;
                }
                this.R.setVisibility(4);
                this.S.setVisibility(4);
                this.T.setVisibility(4);
                a(this.H, this.S, this.n);
                a(this.I, this.R, this.p);
                a(this.J, this.T, this.l);
                C();
                this.S.clearAnimation();
                this.R.clearAnimation();
                this.T.clearAnimation();
                return;
            }
            this.at.edit().putBoolean("share_edit_video_show_expand", false).apply();
            z();
            this.ab = true;
        }
    }

    /* access modifiers changed from: private */
    public void b(int i2) {
        com.oppo.camera.e.a("ShareEditThumbMenu", "setBgAlpha: " + this.ak.getAlpha() + " to -> :" + i2);
        this.ak.setAlpha(i2);
    }

    public void c() {
        if (this.aD) {
            this.aD = false;
            p();
        }
    }

    private void p() {
        b(255);
        c(this.g);
        y();
    }

    private void c(e eVar) {
        this.ar = eVar;
        e eVar2 = this.ar;
        if (eVar2 != null) {
            this.Y = Util.a(eVar2.d());
            this.al = o();
        }
    }

    private void d(e eVar) {
        this.ar = eVar;
        if (this.ar != null) {
            this.Z = l();
            this.al = o();
        }
    }

    /* access modifiers changed from: private */
    public void c(int i2) {
        com.oppo.camera.e.a("ShareEditThumbMenu", "setState: " + this.f4275a + " to -> :" + i2);
        this.f4275a = i2;
    }

    public void d() {
        c(this.g);
    }

    public void a(boolean z2, boolean z3) {
        this.aa = true;
        k();
        this.O.clearAnimation();
        this.T.clearAnimation();
        this.S.clearAnimation();
        this.R.clearAnimation();
        Handler handler = this.aq;
        if (handler != null) {
            handler.removeMessages(2);
        }
        if (!z2 || this.ak.getAlpha() == 0) {
            d(z3);
            return;
        }
        A();
        q();
    }

    /* access modifiers changed from: private */
    public void d(boolean z2) {
        c(0);
        A();
        b(0);
        this.T.setVisibility(4);
        this.R.setVisibility(4);
        this.S.setVisibility(4);
        a(this.J, this.T, this.l);
        a(this.H, this.S, this.n);
        a(this.I, this.R, this.p);
        if (z2) {
            d();
        }
    }

    /* access modifiers changed from: private */
    public float a(float f2) {
        float f3 = this.A;
        return f3 + ((this.B - f3) * f2);
    }

    private void q() {
        this.A = (float) this.F.height;
        this.B = this.g;
        c(5);
        this.C = this.R.getAlpha();
        this.aj = new C0105a() {

            /* renamed from: a  reason: collision with root package name */
            float f4284a = 0.0f;

            /* renamed from: b  reason: collision with root package name */
            float f4285b = 0.0f;

            /* access modifiers changed from: package-private */
            public void a(float f, Transformation transformation) {
                a aVar = a.this;
                aVar.c(aVar.a(f));
                a.this.b((int) ((1.0f - f) * 255.0f));
                this.f4284a = a.this.C + ((this.f4285b - a.this.C) * f);
                a.this.S.setImageAlpha((int) (this.f4284a * 255.0f));
                a.this.R.setImageAlpha((int) (this.f4284a * 255.0f));
                a.this.T.setImageAlpha((int) (this.f4284a * 255.0f));
                a aVar2 = a.this;
                float f2 = f;
                aVar2.a(aVar2.H, a.this.S, a.this.o, a.this.n, f2, false);
                a aVar3 = a.this;
                aVar3.a(aVar3.I, a.this.R, a.this.q, a.this.p, f2, false);
                if (!a.this.Y) {
                    a aVar4 = a.this;
                    aVar4.a(aVar4.J, a.this.T, a.this.o, a.this.n, f, false);
                    return;
                }
                a aVar5 = a.this;
                aVar5.a(aVar5.J, a.this.T, a.this.m, a.this.l, f, false);
            }

            /* access modifiers changed from: protected */
            public void a(Animation animation) {
                super.a(animation);
            }

            /* access modifiers changed from: protected */
            public void b(Animation animation) {
                if (5 == a.this.f4275a) {
                    a.this.d(true);
                }
                if (a.this.ab) {
                    a.this.y();
                    a.this.C();
                    boolean unused = a.this.ab = false;
                }
            }
        };
        this.aj.setDuration(300);
        this.aj.setInterpolator(this.as);
        this.O.clearAnimation();
        this.O.startAnimation(this.aj);
    }

    private boolean r() {
        e eVar = this.ar;
        this.Y = eVar != null && Util.a(eVar.d());
        this.Z = this.ar != null && l();
        this.al = o();
        e eVar2 = this.ar;
        if (eVar2 == null || eVar2.d() == null || this.ar.f3918a || !s()) {
            return false;
        }
        return true;
    }

    private boolean s() {
        return this.V.ah() && this.V.ao();
    }

    private void t() {
        if (2 == this.f4275a) {
            b(255);
            c(4);
            if (this.af == null) {
                this.af = new C0105a() {
                    /* access modifiers changed from: package-private */
                    public void a(float f, Transformation transformation) {
                        float E = a.this.x() * f;
                        a aVar = a.this;
                        aVar.c(aVar.am + E);
                    }
                };
                this.af.setInterpolator(this.as);
            }
            this.am = (float) this.F.height;
            this.af.setDuration(300);
            u();
            this.O.clearAnimation();
            this.O.startAnimation(this.af);
        }
    }

    /* access modifiers changed from: private */
    public void a(RelativeLayout.LayoutParams layoutParams, View view, int i2, int i3, float f2, boolean z2) {
        layoutParams.bottomMargin = (int) (((float) i2) + (((float) (i3 - i2)) * f2));
        view.requestLayout();
        if (0.5f < f2 && z2) {
            view.setVisibility(0);
        }
    }

    private void a(RelativeLayout.LayoutParams layoutParams, View view, int i2) {
        layoutParams.bottomMargin = i2;
        view.requestLayout();
    }

    private void u() {
        int i2 = this.f4275a;
        if (6 != i2 && 7 != i2 && 1 != i2) {
            c(6);
            if (this.ah == null) {
                this.ah = new C0105a() {
                    /* access modifiers changed from: protected */
                    public void a(float f, Transformation transformation) {
                        a aVar = a.this;
                        aVar.a(aVar.H, a.this.S, a.this.n, a.this.o, f, true);
                    }
                };
                this.ah.setDuration(300);
                this.ah.setStartOffset(80);
                this.ah.setInterpolator(this.ap);
            }
            if (this.ag == null) {
                this.ag = new C0105a() {
                    /* access modifiers changed from: package-private */
                    public void a(float f, Transformation transformation) {
                        if (1 == a.this.f4275a) {
                            a.this.R.clearAnimation();
                        }
                        if (a.this.Q.getVisibility() == 0) {
                            a.this.A();
                        }
                        a aVar = a.this;
                        aVar.a(aVar.I, a.this.R, a.this.p, a.this.q, f, true);
                    }

                    /* access modifiers changed from: protected */
                    public void b(Animation animation) {
                        if (1 == a.this.f4275a) {
                            a.this.R.setVisibility(4);
                        } else if (6 == a.this.f4275a) {
                            a.this.c(7);
                            if (a.this.Q.getVisibility() == 0) {
                                a.this.A();
                            }
                            if (a.this.az != null) {
                                a.this.az.a();
                            }
                            a.this.v();
                            a.this.V.n(45);
                        }
                    }
                };
                this.ag.setDuration(300);
                this.ag.setInterpolator(this.ap);
            }
            if (this.ai == null) {
                this.ai = new C0105a() {
                    /* access modifiers changed from: protected */
                    public void a(float f, Transformation transformation) {
                        if (!a.this.Y) {
                            a aVar = a.this;
                            aVar.a(aVar.J, a.this.T, a.this.n, a.this.o, f, true);
                            return;
                        }
                        a aVar2 = a.this;
                        aVar2.a(aVar2.J, a.this.T, a.this.l, a.this.m, f, true);
                    }
                };
                this.ai.setDuration(300);
                this.ai.setStartOffset(80);
                this.ai.setInterpolator(this.ap);
            }
            if (this.Z) {
                this.T.startAnimation(this.ai);
                this.ah.setStartOffset(110);
            }
            if (this.Y) {
                this.S.startAnimation(this.ah);
                this.ag.setStartOffset(140);
            } else {
                this.ag.setStartOffset(110);
            }
            w();
            v();
        }
    }

    public void e() {
        int i2 = this.f4275a;
        if (7 == i2 || 2 == i2 || 6 == i2 || 4 == i2) {
            v();
        }
    }

    /* access modifiers changed from: private */
    public void v() {
        float f2 = H() ? 0.3f : 1.0f;
        com.oppo.camera.e.e("ShareEditThumbMenu", "updateIconAlpha, mbEnable: " + this.av);
        if (this.Z) {
            this.T.setImageAlpha((int) (f2 * 255.0f));
        }
        if (this.Y) {
            this.S.setImageAlpha((int) (f2 * 255.0f));
        }
        this.R.setImageAlpha((int) (f2 * 255.0f));
        if (this.av) {
            C();
        }
    }

    private void w() {
        int i2 = this.f4275a;
        if (i2 != 0 && 1 != i2) {
            this.O.clearAnimation();
            this.R.startAnimation(this.ag);
        }
    }

    /* access modifiers changed from: private */
    public float x() {
        return this.al - this.am;
    }

    /* access modifiers changed from: private */
    public void y() {
        if (0.0f == this.M || 0.0f == this.N) {
            this.M = ((((float) (this.V.al().getHeight() - this.t)) / 2.0f) - ((float) a((int) R.dimen.arrow_height))) - this.k;
            this.N = ((float) a((int) R.dimen.thumbnail_margin_start)) + (((float) (this.t - a((int) R.dimen.arrow_width))) / 2.0f);
            RelativeLayout.LayoutParams layoutParams = this.G;
            layoutParams.topMargin = (int) this.M;
            layoutParams.setMarginStart((int) this.N);
            this.Q.requestLayout();
        }
        if (this.aC) {
            this.Q.setVisibility(0);
        }
    }

    private void z() {
        b(255);
        c(4);
        if (this.af == null) {
            this.af = new C0105a() {
                /* access modifiers changed from: package-private */
                public void a(float f, Transformation transformation) {
                    float E = a.this.x() * f;
                    a aVar = a.this;
                    aVar.c(aVar.am + E);
                }
            };
            this.af.setInterpolator(this.as);
        }
        this.am = (float) this.F.height;
        this.af.setDuration(300);
        u();
        this.O.clearAnimation();
        this.O.startAnimation(this.af);
    }

    /* access modifiers changed from: private */
    public void A() {
        this.Q.clearAnimation();
        this.Q.setVisibility(8);
    }

    private void b(float f2) {
        float f3 = ((float) this.F.height) + f2;
        if (this.g <= f3) {
            if (this.i + o() < f3) {
                f3 = o() + this.i;
                c(f3);
            } else if (o() < f3) {
                f3 = (((float) Math.exp((double) (-0.02f * f2))) * f2) + ((float) this.F.height);
                c(f3);
            } else {
                c(f3);
            }
            if (f3 >= o() - ((float) this.y) && 2 == this.f4275a) {
                A();
                t();
            }
            if (3 == this.f4275a && f3 <= o() - ((float) this.z)) {
                this.ad = false;
                q();
            }
        }
    }

    /* access modifiers changed from: private */
    public void c(float f2) {
        FrameLayout.LayoutParams layoutParams = this.F;
        if (layoutParams != null) {
            layoutParams.height = (int) f2;
            this.O.requestLayout();
        }
    }

    /* access modifiers changed from: private */
    public boolean B() {
        return 255 == this.ak.getAlpha();
    }

    /* access modifiers changed from: private */
    public void C() {
        Handler handler = this.aq;
        if (handler != null) {
            handler.removeMessages(2);
            this.aq.sendEmptyMessageDelayed(2, 2851);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: int} */
    /* JADX WARNING: type inference failed for: r2v0 */
    /* JADX WARNING: type inference failed for: r2v2 */
    /* JADX WARNING: type inference failed for: r2v4 */
    /* JADX WARNING: type inference failed for: r2v5, types: [int] */
    /* JADX WARNING: type inference failed for: r2v7 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouch(android.view.View r11, android.view.MotionEvent r12) {
        /*
            r10 = this;
            boolean r0 = r10.W
            java.lang.String r1 = "ShareEditThumbMenu"
            r2 = 0
            r3 = 1
            if (r0 == 0) goto L_0x01b9
            boolean r0 = r10.X
            if (r0 == 0) goto L_0x01b9
            boolean r0 = r10.av
            if (r0 == 0) goto L_0x01b9
            com.oppo.camera.ui.control.b r0 = r10.V
            boolean r0 = r0.ak()
            if (r0 != 0) goto L_0x01b9
            com.oppo.camera.ui.control.ThumbImageView r0 = r10.U
            int r0 = r0.getVisibility()
            if (r0 == 0) goto L_0x0022
            goto L_0x01b9
        L_0x0022:
            int r0 = r12.getAction()
            r4 = 7
            r5 = 3
            r6 = 2
            if (r0 == 0) goto L_0x0149
            if (r0 == r3) goto L_0x00d3
            if (r0 == r6) goto L_0x0032
            if (r0 == r5) goto L_0x00d3
            return r2
        L_0x0032:
            boolean r11 = r10.I()
            if (r11 == 0) goto L_0x003e
            java.lang.String r11 = "onTouch, ACTION_MOVE isAnimating return"
            com.oppo.camera.e.e(r1, r11)
            return r3
        L_0x003e:
            boolean r11 = r10.aa
            if (r11 == 0) goto L_0x0048
            java.lang.String r11 = "onTouch, ACTION_MOVE mbIntercept return"
            com.oppo.camera.e.e(r1, r11)
            return r3
        L_0x0048:
            float r11 = r10.L
            r0 = 0
            int r11 = (r11 > r0 ? 1 : (r11 == r0 ? 0 : -1))
            if (r11 == 0) goto L_0x00d2
            boolean r11 = r10.ad
            if (r11 == 0) goto L_0x00d2
            float r11 = r12.getY()
            float r1 = r10.L
            float r11 = r11 - r1
            float r1 = java.lang.Math.abs(r11)
            int r4 = r10.r
            float r4 = (float) r4
            int r1 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r1 >= 0) goto L_0x0066
            return r3
        L_0x0066:
            r1 = r2
        L_0x0067:
            boolean[] r4 = r10.aw
            int r5 = r4.length
            if (r1 >= r5) goto L_0x0089
            boolean r4 = r4[r1]
            if (r4 == 0) goto L_0x0086
            float r4 = r12.getY()
            float r5 = r10.K
            float r4 = r4 - r5
            float r4 = java.lang.Math.abs(r4)
            int r5 = r10.r
            float r5 = (float) r5
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 <= 0) goto L_0x0086
            boolean[] r4 = r10.aw
            r4[r1] = r2
        L_0x0086:
            int r1 = r1 + 1
            goto L_0x0067
        L_0x0089:
            boolean r12 = r10.ac
            if (r12 == 0) goto L_0x00a9
            r10.ac = r2
            boolean r12 = r10.ae
            if (r12 == 0) goto L_0x00a9
            com.oppo.camera.ui.menu.shareedit.ShareArrowImageView r12 = r10.Q
            int r12 = r12.getVisibility()
            if (r12 != 0) goto L_0x009e
            r10.A()
        L_0x009e:
            boolean r12 = r10.B()
            if (r12 != 0) goto L_0x00a9
            r12 = 255(0xff, float:3.57E-43)
            r10.b((int) r12)
        L_0x00a9:
            boolean r12 = r10.ae
            r4 = 4602678819172646912(0x3fe0000000000000, double:0.5)
            if (r12 == 0) goto L_0x00c1
            int r12 = (r11 > r0 ? 1 : (r11 == r0 ? 0 : -1))
            if (r12 <= 0) goto L_0x00b9
            r10.t()
            r10.ad = r2
            goto L_0x00d2
        L_0x00b9:
            float r11 = -r11
            double r11 = (double) r11
            double r11 = r11 * r4
            float r11 = (float) r11
            r10.b((float) r11)
            goto L_0x00d2
        L_0x00c1:
            int r12 = (r11 > r0 ? 1 : (r11 == r0 ? 0 : -1))
            if (r12 >= 0) goto L_0x00cb
            r10.q()
            r10.ad = r2
            goto L_0x00d2
        L_0x00cb:
            float r11 = -r11
            double r11 = (double) r11
            double r11 = r11 * r4
            float r11 = (float) r11
            r10.b((float) r11)
        L_0x00d2:
            return r3
        L_0x00d3:
            boolean r11 = r10.aa
            if (r11 == 0) goto L_0x00ec
        L_0x00d7:
            boolean[] r11 = r10.aw
            int r12 = r11.length
            if (r2 >= r12) goto L_0x00eb
            boolean r11 = r11[r2]
            if (r11 == 0) goto L_0x00e8
            android.view.View[] r11 = r10.ay
            r11 = r11[r2]
            r11.performClick()
            goto L_0x00eb
        L_0x00e8:
            int r2 = r2 + 1
            goto L_0x00d7
        L_0x00eb:
            return r3
        L_0x00ec:
            r10.C()
            float r11 = r12.getY()
            float r12 = r10.K
            float r11 = r11 - r12
            float r11 = java.lang.Math.abs(r11)
            int r12 = r10.r
            float r12 = (float) r12
            int r11 = (r11 > r12 ? 1 : (r11 == r12 ? 0 : -1))
            if (r11 >= 0) goto L_0x0103
            r11 = r3
            goto L_0x0104
        L_0x0103:
            r11 = r2
        L_0x0104:
            r12 = r2
        L_0x0105:
            boolean[] r0 = r10.aw
            int r1 = r0.length
            if (r12 >= r1) goto L_0x011b
            boolean r0 = r0[r12]
            if (r0 == 0) goto L_0x0118
            if (r11 == 0) goto L_0x0118
            android.view.View[] r11 = r10.ay
            r11 = r11[r12]
            r11.performClick()
            return r3
        L_0x0118:
            int r12 = r12 + 1
            goto L_0x0105
        L_0x011b:
            if (r11 == 0) goto L_0x0136
            int r11 = r10.f4276b
            if (r3 == r11) goto L_0x012f
            if (r11 != 0) goto L_0x0124
            goto L_0x012f
        L_0x0124:
            boolean r11 = r10.B()
            if (r11 == 0) goto L_0x012b
            r2 = r4
        L_0x012b:
            r10.c((int) r2)
            goto L_0x0135
        L_0x012f:
            r10.A()
            r10.t()
        L_0x0135:
            return r3
        L_0x0136:
            boolean r11 = r10.ae
            if (r11 == 0) goto L_0x0141
            r10.A()
            r10.t()
            goto L_0x0148
        L_0x0141:
            int r11 = r10.f4275a
            if (r5 != r11) goto L_0x0148
            r10.q()
        L_0x0148:
            return r3
        L_0x0149:
            r0 = r2
        L_0x014a:
            boolean[] r7 = r10.aw
            int r8 = r7.length
            if (r0 >= r8) goto L_0x0161
            int[] r8 = r10.ax
            r8 = r8[r0]
            int r9 = r11.getId()
            if (r8 != r9) goto L_0x015b
            r8 = r3
            goto L_0x015c
        L_0x015b:
            r8 = r2
        L_0x015c:
            r7[r0] = r8
            int r0 = r0 + 1
            goto L_0x014a
        L_0x0161:
            boolean r11 = r10.I()
            if (r11 == 0) goto L_0x016d
            java.lang.String r11 = "onTouch, ACTION_DOWN isAnimating return"
            com.oppo.camera.e.e(r1, r11)
            return r3
        L_0x016d:
            r10.aa = r2
            android.os.Handler r11 = r10.aq
            if (r11 == 0) goto L_0x0176
            r11.removeMessages(r6)
        L_0x0176:
            float r11 = r12.getY()
            r10.L = r11
            float r11 = r12.getY()
            r10.K = r11
            android.widget.FrameLayout$LayoutParams r11 = r10.F
            int r11 = r11.height
            if (r11 >= 0) goto L_0x0192
            android.widget.FrameLayout$LayoutParams r11 = r10.F
            android.widget.RelativeLayout r12 = r10.O
            int r12 = r12.getMeasuredHeight()
            r11.height = r12
        L_0x0192:
            int r11 = r10.f4275a
            r10.f4276b = r11
            if (r3 == r11) goto L_0x01a0
            if (r4 == r11) goto L_0x01a0
            if (r11 != 0) goto L_0x019d
            goto L_0x01a0
        L_0x019d:
            r10.ad = r2
            goto L_0x01b6
        L_0x01a0:
            r10.ad = r3
            int r11 = r10.f4275a
            if (r4 == r11) goto L_0x01a7
            r5 = r6
        L_0x01a7:
            r10.c((int) r5)
            android.widget.RelativeLayout r11 = r10.O
            r11.clearAnimation()
            int r11 = r10.f4275a
            if (r6 != r11) goto L_0x01b4
            r2 = r3
        L_0x01b4:
            r10.ae = r2
        L_0x01b6:
            r10.ac = r3
            return r3
        L_0x01b9:
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r12 = "onTouch, !mbShareAndMarkEnable: "
            r11.append(r12)
            boolean r12 = r10.W
            r12 = r12 ^ r3
            r11.append(r12)
            java.lang.String r12 = ", !mbEnableTouch: "
            r11.append(r12)
            boolean r12 = r10.X
            r12 = r12 ^ r3
            r11.append(r12)
            java.lang.String r12 = ", !mbEnable: "
            r11.append(r12)
            boolean r12 = r10.av
            r12 = r12 ^ r3
            r11.append(r12)
            java.lang.String r12 = ", isMoreModeTab: "
            r11.append(r12)
            com.oppo.camera.ui.control.b r12 = r10.V
            boolean r12 = r12.ak()
            r11.append(r12)
            java.lang.String r12 = ", mThumbImageViewVisibility: "
            r11.append(r12)
            com.oppo.camera.ui.control.ThumbImageView r12 = r10.U
            int r12 = r12.getVisibility()
            r11.append(r12)
            java.lang.String r11 = r11.toString()
            com.oppo.camera.e.e(r1, r11)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.ui.menu.shareedit.a.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    private String a(String str) {
        String[] split;
        if (TextUtils.isEmpty(str) || (split = str.split("\\.")) == null || 1 > split.length) {
            return null;
        }
        String str2 = split[split.length - 1];
        if ("jpeg".equalsIgnoreCase(str2) || "jpg".equalsIgnoreCase(str2)) {
            return com.oppo.camera.q.a.c;
        }
        if ("raw".equalsIgnoreCase(str2) || "dng".equalsIgnoreCase(str2)) {
            return com.oppo.camera.q.a.f;
        }
        if ("heic_8bits".equalsIgnoreCase(str2) || "heic_10bits".equalsIgnoreCase(str2) || "heic".equalsIgnoreCase(str2)) {
            return com.oppo.camera.q.a.e;
        }
        if ("mp4".equalsIgnoreCase(str2)) {
            return com.oppo.camera.q.a.j;
        }
        if ("3gp".equalsIgnoreCase(str2)) {
            return com.oppo.camera.q.a.k;
        }
        return null;
    }

    /* access modifiers changed from: private */
    public void D() {
        e q2 = this.V.q();
        if (q2 != null) {
            Uri d2 = q2.d();
            if (a(d2, Util.a(d2))) {
                Intent intent = new Intent("android.intent.action.SEND");
                String i2 = q2.i();
                if (i2 == null) {
                    i2 = a(q2.e());
                }
                if (i2 == null) {
                    i2 = Util.a(d2) ? "image/*" : "video/*";
                }
                intent.setType(i2);
                intent.putExtra("android.intent.extra.STREAM", d2);
                if (this.V.ai()) {
                    intent.setFlags(268468224);
                }
                G();
                try {
                    this.an.startActivity(Intent.createChooser(intent, (CharSequence) null));
                    this.an.overridePendingTransition(0, 0);
                } catch (Throwable th) {
                    com.oppo.camera.e.e("ShareEditThumbMenu", "jumpSystemShare: " + th);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void E() {
        e q2 = this.V.q();
        if (q2 != null) {
            Uri d2 = q2.d();
            if (a(d2, Util.a(d2))) {
                Intent intent = new Intent("android.intent.action.EDIT");
                intent.setData(d2);
                intent.putExtra("edit_skill", "doodle");
                intent.putExtra("finish_operate", "save,share");
                intent.putExtra("from", this.an.getPackageName());
                intent.putExtra("isInternalSdcard", true);
                intent.putExtra("editor_state_item", "graffiti");
                intent.setPackage("com.coloros.gallery3d");
                intent.setFlags(1);
                if (this.V.ai()) {
                    intent.addFlags(268468224);
                }
                G();
                try {
                    this.an.startActivity(intent);
                    this.an.overridePendingTransition(1 == this.an.getResources().getConfiguration().getLayoutDirection() ? R.anim.gallery_in_rtl : R.anim.gallery_in, 0);
                } catch (Throwable th) {
                    com.oppo.camera.e.e("ShareEditThumbMenu", "jumpMark: " + th);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void F() {
        e q2 = this.V.q();
        if (q2 != null) {
            Uri d2 = q2.d();
            if (a(d2, Util.a(d2))) {
                Intent intent = new Intent();
                intent.setAction("coloros.intent.action.SOLOOP_VIDEO_EDITOR");
                long parseId = ContentUris.parseId(d2);
                ArrayList arrayList = new ArrayList();
                arrayList.add(String.valueOf(parseId));
                intent.putStringArrayListExtra("id_list", arrayList);
                intent.putExtra("tab_name", "template");
                intent.putExtra("use_template", true);
                if (this.V.ai()) {
                    intent.setFlags(268468224);
                }
                G();
                try {
                    this.an.startActivity(intent);
                    this.an.overridePendingTransition(1 == this.an.getResources().getConfiguration().getLayoutDirection() ? R.anim.gallery_in_rtl : R.anim.gallery_in, 0);
                } catch (Throwable th) {
                    com.oppo.camera.e.e("ShareEditThumbMenu", "jumpSoloop: " + th);
                }
            }
        }
    }

    private void G() {
        if (this.V.ai()) {
            try {
                new OplusWindowManager().requestKeyguard("unlockOrShowSecurity");
            } catch (RemoteException e2) {
                com.oppo.camera.e.e("ShareEditThumbMenu", "OplusWindowManager exception:" + e2.toString());
            } catch (Exception e3) {
                com.oppo.camera.e.d("ShareEditThumbMenu", "OplusWindowManager error:", e3);
            }
        }
    }

    private boolean a(Uri uri, boolean z2) {
        if (uri == null) {
            return false;
        }
        boolean a2 = Util.a(uri, this.an.getContentResolver());
        if (H() || !a2) {
            com.oppo.camera.e.d("ShareEditThumbMenu", "onThumbNailClick, imageCaptureListIsEmpty: " + com.oppo.camera.n.b.a().j() + ", imageSaveListIsEmpty: " + com.oppo.camera.n.b.a().g() + ", isUriValid: " + a2);
            return false;
        } else if (!z2 || a(uri)) {
            return true;
        } else {
            return false;
        }
    }

    private boolean H() {
        return !com.oppo.camera.n.b.a().j() || !com.oppo.camera.n.b.a().g();
    }

    private boolean a(Uri uri) {
        try {
            return this.an.getContentResolver().loadThumbnail(uri, new Size(1, 1), (CancellationSignal) null) != null;
        } catch (Exception unused) {
            com.oppo.camera.e.e("ShareEditThumbMenu", "checkFileOk: " + uri.toString());
            return false;
        }
    }

    public void f() {
        this.aa = true;
        d(true);
        this.O.setVisibility(8);
        this.aC = false;
    }

    public void g() {
        this.O.setVisibility(0);
        this.aC = true;
    }

    public void a(boolean z2) {
        if (z2) {
            Util.a((View) this.O, 0, (Animation.AnimationListener) null, 300);
            this.aC = true;
            return;
        }
        g();
    }

    public void onClick(View view) {
        if (0 != this.ao && 500 > System.currentTimeMillis() - this.ao) {
            com.oppo.camera.e.e("ShareEditThumbMenu", "onClick, mLastClickTime return");
        } else if (!this.av || this.aG) {
            com.oppo.camera.e.e("ShareEditThumbMenu", "onClick, return mbEnable " + this.av + ", mbPaused: " + this.aG);
        } else if (!this.aF) {
            this.aF = true;
            this.ao = System.currentTimeMillis();
            int id = view.getId();
            if (id == R.id.edit) {
                com.oppo.camera.v.c.a().a(new Runnable() {
                    public void run() {
                        a.this.E();
                        boolean unused = a.this.aF = false;
                    }
                }, "share");
                this.at.edit().putBoolean("share_edit_video_show_expand", false).apply();
                this.V.n(47);
            } else if (id == R.id.share) {
                com.oppo.camera.v.c.a().a(new Runnable() {
                    public void run() {
                        a.this.D();
                        boolean unused = a.this.aF = false;
                    }
                }, "share");
                this.at.edit().putBoolean("share_edit_video_show_expand", false).apply();
                this.V.n(46);
            } else if (id != R.id.soloop) {
                this.aF = false;
            } else {
                com.oppo.camera.v.c.a().a(new Runnable() {
                    public void run() {
                        if (Util.c((Context) a.this.an, "com.coloros.videoeditor") || !Util.t(a.this.an) || !a.this.K()) {
                            a.this.F();
                            a.this.V.n(55);
                            boolean unused = a.this.aF = false;
                            return;
                        }
                        a.this.an.runOnUiThread(new Runnable() {
                            public void run() {
                                if (a.this.aA != null) {
                                    a.this.aA.aE();
                                }
                                boolean unused = a.this.aF = false;
                            }
                        });
                    }
                }, "share");
                this.at.edit().putBoolean("share_edit_video_show_expand", false).apply();
            }
        }
    }

    private boolean I() {
        return a(this.af) || a(this.aj) || a(this.ag) || a(this.ah) || a(this.ai);
    }

    private boolean a(C0105a aVar) {
        return aVar != null && aVar.a();
    }

    public boolean h() {
        int i2 = this.f4275a;
        return 7 == i2 || 4 == i2;
    }

    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        if ("key_is_soloop_in_market".equals(str)) {
            k();
        }
    }

    public void i() {
        this.aG = false;
        this.W = "on".equals(this.at.getString("pref_share_and_edit_key", this.an.getString(R.string.camera_share_default_value)));
    }

    public void j() {
        this.aG = true;
        this.ao = 0;
    }

    public void b(boolean z2) {
        com.oppo.camera.e.e("ShareEditThumbMenu", "setEnableMenu, enable: " + z2 + ", mbEnable: " + this.av);
        this.av = z2;
        if (!this.av) {
            int i2 = this.f4275a;
            if (7 == i2 || 4 == i2 || 2 == i2) {
                a(false, true);
            }
        }
    }

    public void k() {
        this.X = r();
    }

    public void c(boolean z2) {
        PopupWindow popupWindow = this.P;
        if (popupWindow != null && popupWindow.isShowing() && this.aE) {
            this.P.setTouchable(z2);
            this.P.update();
        }
    }

    public boolean l() {
        e q2 = this.V.q();
        return q2 != null && (q2.i() == null || !com.oppo.camera.q.a.f.equals(q2.i())) && !q2.e().contains("raw") && K() && ((Util.c((Context) this.an, "com.coloros.videoeditor") || (Util.t(this.an) && J())) && this.V.ah());
    }

    private boolean J() {
        SharedPreferences sharedPreferences = this.au;
        if (sharedPreferences != null) {
            return sharedPreferences.getBoolean("key_is_soloop_in_market", false);
        }
        return false;
    }

    /* access modifiers changed from: private */
    public boolean K() {
        return CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_SHOW_SOLOOP);
    }

    /* renamed from: com.oppo.camera.ui.menu.shareedit.a$a  reason: collision with other inner class name */
    /* compiled from: ShareEditThumbMenu */
    private static abstract class C0105a extends Animation {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public boolean f4290a = false;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public volatile boolean f4291b = false;

        /* access modifiers changed from: package-private */
        public abstract void a(float f, Transformation transformation);

        /* access modifiers changed from: protected */
        public void a(Animation animation) {
        }

        /* access modifiers changed from: protected */
        public void b(Animation animation) {
        }

        /* access modifiers changed from: protected */
        public void c(Animation animation) {
        }

        public C0105a() {
            setAnimationListener(new Animation.AnimationListener() {
                public void onAnimationStart(Animation animation) {
                    boolean unused = C0105a.this.f4290a = false;
                    boolean unused2 = C0105a.this.f4291b = true;
                    C0105a.this.a(animation);
                }

                public void onAnimationEnd(Animation animation) {
                    boolean unused = C0105a.this.f4290a = true;
                    boolean unused2 = C0105a.this.f4291b = false;
                    C0105a.this.b(animation);
                }

                public void onAnimationRepeat(Animation animation) {
                    C0105a.this.c(animation);
                }
            });
        }

        public boolean a() {
            return this.f4291b;
        }

        /* access modifiers changed from: protected */
        public void applyTransformation(float f, Transformation transformation) {
            if (!this.f4290a) {
                a(f, transformation);
            }
        }
    }
}
