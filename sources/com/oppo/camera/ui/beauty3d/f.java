package com.oppo.camera.ui.beauty3d;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TimeInterpolator;
import android.app.Activity;
import android.graphics.Point;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.oppo.camera.R;
import com.oppo.camera.e;
import com.oppo.camera.util.Util;
import java.util.Locale;

/* compiled from: Beauty3DGuideScanUI */
public class f implements View.OnClickListener, View.OnTouchListener {
    /* access modifiers changed from: private */
    public ObjectAnimator A = null;
    private ObjectAnimator B = null;
    private ObjectAnimator C = null;
    private ObjectAnimator D = null;
    private ObjectAnimator E = null;
    private ObjectAnimator F = null;
    private ObjectAnimator G = null;
    private AnimatorSet H = null;
    /* access modifiers changed from: private */
    public boolean I = false;
    private TimeInterpolator J = new PathInterpolator(0.42f, 0.0f, 0.58f, 1.0f);
    private TimeInterpolator K = new PathInterpolator(0.0f, 0.0f, 0.1f, 1.0f);
    private TimeInterpolator L = new PathInterpolator(0.3f, 0.0f, 0.1f, 1.0f);
    private int[] M = {R.drawable.beauty3d_scan_00, R.drawable.beauty3d_scan_01, R.drawable.beauty3d_scan_02, R.drawable.beauty3d_scan_03, R.drawable.beauty3d_scan_04, R.drawable.beauty3d_scan_05, R.drawable.beauty3d_scan_06, R.drawable.beauty3d_scan_07, R.drawable.beauty3d_scan_08, R.drawable.beauty3d_scan_09, R.drawable.beauty3d_scan_10, R.drawable.beauty3d_scan_11, R.drawable.beauty3d_scan_12, R.drawable.beauty3d_scan_13, R.drawable.beauty3d_scan_14, R.drawable.beauty3d_scan_15, R.drawable.beauty3d_scan_16, R.drawable.beauty3d_scan_17, R.drawable.beauty3d_scan_18, R.drawable.beauty3d_scan_19, R.drawable.beauty3d_scan_20, R.drawable.beauty3d_scan_21, R.drawable.beauty3d_scan_22, R.drawable.beauty3d_scan_23, R.drawable.beauty3d_scan_24, R.drawable.beauty3d_scan_25, R.drawable.beauty3d_scan_26, R.drawable.beauty3d_scan_27, R.drawable.beauty3d_scan_28, R.drawable.beauty3d_scan_29};
    private int[] N = {R.drawable.beauty3d_scan_loading_00, R.drawable.beauty3d_scan_loading_01, R.drawable.beauty3d_scan_loading_02, R.drawable.beauty3d_scan_loading_03, R.drawable.beauty3d_scan_loading_04, R.drawable.beauty3d_scan_loading_05, R.drawable.beauty3d_scan_loading_06, R.drawable.beauty3d_scan_loading_07, R.drawable.beauty3d_scan_loading_08, R.drawable.beauty3d_scan_loading_09, R.drawable.beauty3d_scan_loading_10, R.drawable.beauty3d_scan_loading_11, R.drawable.beauty3d_scan_loading_12, R.drawable.beauty3d_scan_loading_13, R.drawable.beauty3d_scan_loading_14, R.drawable.beauty3d_scan_loading_15, R.drawable.beauty3d_scan_loading_16, R.drawable.beauty3d_scan_loading_17, R.drawable.beauty3d_scan_loading_18, R.drawable.beauty3d_scan_loading_19, R.drawable.beauty3d_scan_loading_20, R.drawable.beauty3d_scan_loading_21, R.drawable.beauty3d_scan_loading_22, R.drawable.beauty3d_scan_loading_23};
    /* access modifiers changed from: private */
    public Handler O = new Handler() {
        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 1) {
                Integer num = (Integer) message.obj;
                e.a("Beauty3DGuideScanUI", "handleMessage, mbNeedUpdate: " + f.this.l);
                if (f.this.r != null && f.this.l) {
                    String string = f.this.e.getResources().getString(num.intValue());
                    f.this.c(num.intValue());
                    if (num.intValue() == R.string.beauty3d_wait_scan_complete) {
                        f.this.d(num.intValue());
                        return;
                    }
                    f.this.a(string);
                    boolean unused = f.this.l = false;
                    postDelayed(new Runnable() {
                        public void run() {
                            boolean unused = f.this.l = true;
                            f.this.r.setText("");
                        }
                    }, 2000);
                }
            } else if (i == 2 && f.this.y != null) {
                f.this.y.a(((Integer) message.obj).intValue());
            }
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private boolean f3856a = false;

    /* renamed from: b  reason: collision with root package name */
    private boolean f3857b = false;
    private boolean c = false;
    /* access modifiers changed from: private */
    public boolean d = false;
    /* access modifiers changed from: private */
    public Activity e = null;
    private ViewGroup f = null;
    private ViewGroup g = null;
    private View h = null;
    private boolean i = false;
    private View j = null;
    private boolean k = false;
    /* access modifiers changed from: private */
    public boolean l = true;
    private View m = null;
    private View n = null;
    private ImageView o = null;
    private ImageView p = null;
    private ImageView q = null;
    /* access modifiers changed from: private */
    public TextView r = null;
    private h s = null;
    private h t = null;
    /* access modifiers changed from: private */
    public e u = null;
    private Point v = null;
    private TextView w = null;
    private Button x = null;
    /* access modifiers changed from: private */
    public OppoCircleProgressView y = null;
    /* access modifiers changed from: private */
    public ImageView z = null;

    public boolean onTouch(View view, MotionEvent motionEvent) {
        return true;
    }

    public f(Activity activity, ViewGroup viewGroup, ViewGroup viewGroup2) {
        this.e = activity;
        this.f = viewGroup;
        this.g = viewGroup2;
        this.f3856a = false;
        this.f3857b = false;
    }

    public void a(e eVar) {
        this.u = eVar;
    }

    public boolean a() {
        return this.f3856a;
    }

    public boolean b() {
        View view;
        if (!this.f3857b || (view = this.n) == null || view.getVisibility() != 0) {
            return false;
        }
        return true;
    }

    public void a(int i2, boolean z2, int i3, int i4) {
        if (this.e != null && this.f != null) {
            i();
            e.a("Beauty3DGuideScanUI", "showGuideView, mbGuideAdd: " + this.f3856a);
            if (!this.f3856a) {
                ((Button) this.m.findViewById(R.id.start_face_scan)).setOnClickListener(this);
                TextView textView = (TextView) this.m.findViewById(R.id.skip);
                textView.setOnClickListener(this);
                this.g.addView(this.m, a(i2, z2, textView, false, i3, i4));
                this.f3856a = true;
            }
        }
    }

    private RelativeLayout.LayoutParams a(int i2, boolean z2, TextView textView, boolean z3, int i3, int i4) {
        View findViewById = this.m.findViewById(R.id.guide_background_top);
        View findViewById2 = this.m.findViewById(R.id.guide_background_bottom);
        findViewById.setVisibility(0);
        findViewById2.setVisibility(0);
        TextView textView2 = (TextView) this.m.findViewById(R.id.beauty3d_face);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        if (i2 == 2 && !z2) {
            a(textView2, textView, layoutParams, i3, i4);
        } else if ((i2 == 0 && !z2) || z2) {
            if (z3) {
                a(textView2, textView);
            }
            layoutParams.addRule(12);
            layoutParams.addRule(10);
            layoutParams.bottomMargin = i3;
            layoutParams.topMargin = i4;
        }
        return layoutParams;
    }

    private void a(TextView textView, TextView textView2, RelativeLayout.LayoutParams layoutParams, int i2, int i3) {
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) textView.getLayoutParams();
        layoutParams2.topMargin = (int) this.e.getResources().getDimension(R.dimen.beauty3d_guide_margin_top_1_1);
        textView.setLayoutParams(layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) textView2.getLayoutParams();
        layoutParams3.bottomMargin = (int) this.e.getResources().getDimension(R.dimen.beauty3d_guide_margin_bottom_1_1);
        textView2.setLayoutParams(layoutParams3);
        layoutParams.addRule(12);
        layoutParams.addRule(10);
        layoutParams.bottomMargin = i2;
        layoutParams.topMargin = i3;
    }

    public void a(int i2) {
        if (i2 == 0) {
            View view = this.m;
            if (view != null && this.f3856a) {
                this.g.removeView(view);
                e.a("Beauty3DGuideScanUI", "onViewDismiss, mRootView.removeGuideView.");
                this.m = null;
                this.f3856a = false;
                e eVar = this.u;
                if (eVar != null) {
                    eVar.a();
                }
            }
        } else if (1 == i2) {
            View view2 = this.n;
            if (view2 != null && this.f3857b) {
                this.f.removeView(view2);
                e.a("Beauty3DGuideScanUI", "onViewDismiss, mRootPreviewView.removeScanView.");
                this.n = null;
                this.f3857b = false;
            }
            View view3 = this.h;
            if (view3 != null && this.i) {
                this.g.removeView(view3);
                this.i = false;
                this.h = null;
            }
            View view4 = this.j;
            if (view4 != null && this.k) {
                this.g.removeView(view4);
                this.k = false;
                this.j = null;
            }
            p();
        }
    }

    public void c() {
        e.a("Beauty3DGuideScanUI", "onScanViewHide");
        f();
        g();
        OppoCircleProgressView oppoCircleProgressView = this.y;
        if (oppoCircleProgressView != null) {
            oppoCircleProgressView.setVisibility(0);
        }
        ObjectAnimator objectAnimator = this.G;
        if (objectAnimator != null && objectAnimator.isRunning()) {
            this.G.cancel();
        }
        if (this.z != null) {
            e.a("Beauty3DGuideScanUI", "onScanViewHide, reset scanCircle");
            this.z.setScaleX(1.0f);
            this.z.setScaleY(1.0f);
        }
        View view = this.n;
        if (view != null) {
            view.setVisibility(8);
            ((ImageView) this.n.findViewById(R.id.scan_foreground_middle)).setImageResource(R.drawable.beauty3d_scan_foreground);
        }
    }

    private void i() {
        if (this.m == null) {
            this.m = this.e.getLayoutInflater().inflate(R.layout.beauty3d_guide, (ViewGroup) null, false);
        }
        this.m.setOnTouchListener(this);
    }

    private void j() {
        if (this.n == null) {
            this.n = this.e.getLayoutInflater().inflate(R.layout.beauty3d_scan, (ViewGroup) null, false);
        }
        this.n.setOnTouchListener(this);
        this.n.setAlpha(0.0f);
        this.r = (TextView) this.n.findViewById(R.id.hint);
        this.o = (ImageView) this.n.findViewById(R.id.scan_left_arrow);
        this.p = (ImageView) this.n.findViewById(R.id.scan_right_arrow);
        this.q = (ImageView) this.n.findViewById(R.id.scan_up_arrow);
    }

    public void d() {
        a(0);
        a(1);
        this.e = null;
        this.m = null;
        this.n = null;
        this.f3856a = false;
        this.f3857b = false;
        this.c = false;
        this.u = null;
    }

    private void k() {
        this.A = ObjectAnimator.ofFloat(this.n, "alpha", new float[]{0.0f, 1.0f});
        this.A.setInterpolator(this.J);
        this.A.setDuration(320);
    }

    public void a(Integer num) {
        Handler handler = this.O;
        if (handler != null && this.c) {
            handler.removeMessages(1);
            Message obtain = Message.obtain();
            obtain.obj = num;
            obtain.what = 1;
            this.O.sendMessage(obtain);
        }
    }

    public void b(int i2, boolean z2, int i3, int i4) {
        if (this.e != null && this.f != null) {
            j();
            k();
            e.a("Beauty3DGuideScanUI", "showBeauty3DScanView, mbScanAdd: " + this.f3857b);
            this.n.setVisibility(0);
            if (!this.f3857b) {
                this.z = (ImageView) this.n.findViewById(R.id.scan_circle);
                if (this.s == null) {
                    this.s = new h(this.z, this.M, 33, true);
                }
                this.y = (OppoCircleProgressView) this.n.findViewById(R.id.circle_progress);
                ImageView imageView = (ImageView) this.n.findViewById(R.id.scan_foreground_middle);
                View findViewById = this.n.findViewById(R.id.scan_foreground_top);
                View findViewById2 = this.n.findViewById(R.id.scan_foreground_bottom);
                if (i2 == 2 && !z2) {
                    findViewById.setVisibility(8);
                    findViewById2.setVisibility(8);
                } else if (i2 == 0 && !z2) {
                    findViewById.setVisibility(0);
                    findViewById2.setVisibility(0);
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.z.getLayoutParams();
                    int dimension = (int) this.e.getResources().getDimension(R.dimen.beauty3d_scan_imageview_margin_top);
                    layoutParams.addRule(10);
                    layoutParams.topMargin = dimension;
                    this.z.setLayoutParams(layoutParams);
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) imageView.getLayoutParams();
                    layoutParams2.addRule(10);
                    layoutParams2.topMargin = dimension;
                    imageView.setLayoutParams(layoutParams2);
                } else if (z2) {
                    this.e.findViewById(R.id.beauty3d_setting).setVisibility(0);
                    RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.n.getLayoutParams();
                    layoutParams3.addRule(12);
                    layoutParams3.bottomMargin = i3;
                    this.n.setLayoutParams(layoutParams3);
                    findViewById.setVisibility(0);
                    findViewById2.setVisibility(0);
                    RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.z.getLayoutParams();
                    int dimension2 = (int) this.e.getResources().getDimension(R.dimen.beauty3d_scan_imageview_margin_top);
                    layoutParams4.addRule(10);
                    layoutParams4.topMargin = dimension2;
                    this.z.setLayoutParams(layoutParams4);
                    RelativeLayout.LayoutParams layoutParams5 = (RelativeLayout.LayoutParams) imageView.getLayoutParams();
                    layoutParams5.addRule(10);
                    layoutParams5.topMargin = dimension2;
                    imageView.setLayoutParams(layoutParams5);
                }
                this.n.requestLayout();
                this.v = this.y.getCenterPoint();
                this.f.addView(this.n, new ViewGroup.LayoutParams(-1, -1));
            }
            b(i2, z2);
            a(z2);
            this.f3857b = true;
            if (this.A.isStarted()) {
                this.A.cancel();
            }
            this.A.start();
            this.c = false;
        }
    }

    public void a(int i2, boolean z2) {
        k();
        a(z2);
        b(i2, z2);
        l();
    }

    private void l() {
        this.c = true;
        View view = this.n;
        if (!(view == null || view.getVisibility() == 0)) {
            this.n.setVisibility(0);
        }
        h hVar = this.s;
        if (hVar != null) {
            if (!hVar.b()) {
                this.s.a();
            }
            this.s.d();
        }
        Button button = this.x;
        if (button != null) {
            button.setVisibility(4);
            this.x.setClickable(false);
        }
    }

    public void a(boolean z2, final boolean z3) {
        if (this.d) {
            e.a("Beauty3DGuideScanUI", "stop3DScan, mbExiting: " + this.d + " return");
            return;
        }
        this.d = true;
        this.c = false;
        Handler handler = this.O;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
            this.l = true;
        }
        if (z2) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.n, "alpha", new float[]{1.0f, 0.0f});
            ofFloat.setInterpolator(this.J);
            ofFloat.setDuration(320);
            ofFloat.addListener(new Animator.AnimatorListener() {
                public void onAnimationRepeat(Animator animator) {
                }

                public void onAnimationStart(Animator animator) {
                    f.this.m();
                }

                public void onAnimationEnd(Animator animator) {
                    e.a("Beauty3DGuideScanUI", "stop3DScan, onAnimationEnd");
                    ObjectAnimator unused = f.this.A = null;
                    f.this.q();
                    if (z3) {
                        f.this.a(1);
                    } else {
                        f.this.c();
                    }
                    if (f.this.u != null) {
                        f.this.u.a(true);
                    }
                    boolean unused2 = f.this.d = false;
                }

                public void onAnimationCancel(Animator animator) {
                    e.a("Beauty3DGuideScanUI", "stop3DScan, onAnimationCancel");
                }
            });
            ofFloat.start();
            return;
        }
        m();
        this.A = null;
        q();
        if (z3) {
            a(1);
        } else {
            c();
        }
        e eVar = this.u;
        if (eVar != null) {
            eVar.a(false);
        }
        this.d = false;
    }

    /* access modifiers changed from: private */
    public void m() {
        ObjectAnimator objectAnimator = this.A;
        if (objectAnimator != null && objectAnimator.isRunning()) {
            this.A.cancel();
        }
        ObjectAnimator objectAnimator2 = this.B;
        if (objectAnimator2 != null) {
            objectAnimator2.cancel();
            this.B = null;
        }
        h hVar = this.s;
        if (hVar != null) {
            hVar.a();
        }
        h hVar2 = this.t;
        if (hVar2 != null) {
            hVar2.a();
        }
        AnimatorSet animatorSet = this.H;
        if (animatorSet != null && animatorSet.isRunning()) {
            this.H.cancel();
        }
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.scan_cancel:
                a(true, true);
                return;
            case R.id.skip:
                a(0);
                return;
            case R.id.start_face_scan:
                a(0);
                e.a("Beauty3DGuideScanUI", "onClick, startScan, disMiss Guide.");
                e eVar = this.u;
                if (eVar != null) {
                    eVar.b();
                    return;
                }
                return;
            case R.id.start_scan:
                l();
                e eVar2 = this.u;
                if (eVar2 != null) {
                    eVar2.a("com.oplus.beauty3d.scan.state", new int[]{1});
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void e() {
        a(0);
        a(false, false);
    }

    public void a(boolean z2) {
        n();
        this.h.setVisibility(0);
        this.h.setEnabled(true);
        if (z2) {
            c(z2);
        }
    }

    private void c(boolean z2) {
        View view = this.h;
        if (view == null) {
            return;
        }
        if (z2) {
            view.setBackgroundColor(this.e.getResources().getColor(R.color.beauty3d_scan_background));
        } else {
            view.setBackgroundColor(this.e.getResources().getColor(R.color.background_color));
        }
    }

    private void n() {
        if (this.h == null) {
            ViewGroup viewGroup = (ViewGroup) this.e.findViewById(R.id.camera);
            this.h = this.e.getLayoutInflater().inflate(R.layout.beauty3d_scan_setting, (ViewGroup) null, false);
            this.h.setBackgroundColor(this.e.getResources().getColor(R.color.background_color));
            this.h.setOnTouchListener(this);
            if (!this.i) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams.addRule(10);
                layoutParams.height = (int) this.e.getResources().getDimension(R.dimen.beauty3d_scan_setting_height);
                layoutParams.topMargin = 0;
                viewGroup.addView(this.h, layoutParams);
                this.i = true;
            }
        }
    }

    public void f() {
        View view = this.h;
        if (view != null) {
            view.setVisibility(8);
            this.h.setEnabled(false);
        }
    }

    public void b(int i2, boolean z2) {
        o();
        this.w = (TextView) this.j.findViewById(R.id.scan_cancel);
        this.x = (Button) this.j.findViewById(R.id.start_scan);
        if (Util.J()) {
            a(this.w);
        }
        this.j.setVisibility(0);
        this.j.setEnabled(true);
        this.j.setOnTouchListener(this);
        if (z2) {
            c(this.e.getColor(R.color.beauty3d_scan_background), false);
        }
        this.w.setEnabled(true);
        this.w.setClickable(true);
        this.w.setOnClickListener(this);
        this.x.setVisibility(0);
        this.x.setEnabled(true);
        this.x.setClickable(true);
        this.x.setOnClickListener(this);
    }

    private void o() {
        if (this.j == null) {
            this.j = this.e.getLayoutInflater().inflate(R.layout.beauty3d_scan_bottom, (ViewGroup) null, false);
            this.j.setBackgroundColor(this.e.getResources().getColor(R.color.background_color));
            ViewGroup viewGroup = (ViewGroup) this.e.findViewById(R.id.camera);
            if (!this.k) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams.addRule(12);
                layoutParams.bottomMargin = 0;
                layoutParams.height = Util.w();
                viewGroup.addView(this.j, layoutParams);
                this.k = true;
            }
        }
    }

    public void g() {
        View view = this.j;
        if (view != null) {
            view.setVisibility(8);
            this.j.setEnabled(false);
        }
    }

    private void c(int i2, boolean z2) {
        e.a("Beauty3DGuideScanUI", "updateBeauty3DControlPanelBgColor, color: " + i2 + ", needAnimation: " + z2);
        View view = this.j;
        if (view != null) {
            if (z2) {
                Util.a(view, i2, 200, (Interpolator) null, (Animator.AnimatorListener) null);
            } else {
                view.setBackgroundColor(i2);
            }
        }
    }

    public boolean c(int i2, boolean z2, int i3, int i4) {
        View view;
        if (!this.f3856a || (view = this.m) == null) {
            return false;
        }
        this.m.setLayoutParams(a(i2, z2, (TextView) view.findViewById(R.id.skip), true, i3, i4));
        this.m.requestLayout();
        return true;
    }

    private void a(TextView textView, TextView textView2) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) textView.getLayoutParams();
        layoutParams.topMargin = (int) this.e.getResources().getDimension(R.dimen.beauty3d_guide_margin_top);
        textView.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) textView2.getLayoutParams();
        layoutParams2.bottomMargin = (int) this.e.getResources().getDimension(R.dimen.beauty3d_guide_textview_margin_bottom);
        textView2.setLayoutParams(layoutParams2);
    }

    public void b(int i2) {
        Handler handler = this.O;
        if (handler != null && this.c) {
            handler.removeMessages(2);
            Message obtain = Message.obtain();
            obtain.obj = Integer.valueOf(i2);
            obtain.what = 2;
            this.O.sendMessage(obtain);
        }
    }

    private void a(TextView textView) {
        if (textView != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) textView.getLayoutParams();
            layoutParams.topMargin = this.e.getResources().getDimensionPixelSize(R.dimen.control_panel_margin_top);
            textView.setLayoutParams(layoutParams);
            textView.requestLayout();
        }
    }

    public void b(boolean z2) {
        View view = this.j;
        if (view != null) {
            view.setEnabled(z2);
            this.j.setClickable(z2);
        }
    }

    public void a(String str) {
        if (this.r == null) {
            this.r = (TextView) this.n.findViewById(R.id.hint);
        }
        this.r.setText("");
        if (this.B == null) {
            if (TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1) {
                float f2 = (float) 30;
                float f3 = (float) -30;
                this.B = ObjectAnimator.ofFloat(this.r, "translationX", new float[]{0.0f, f2, f3, f2, f3, 0.0f});
            } else {
                float f4 = (float) -30;
                float f5 = (float) 30;
                this.B = ObjectAnimator.ofFloat(this.r, "translationX", new float[]{0.0f, f4, f5, f4, f5, 0.0f});
            }
        }
        if (!TextUtils.isEmpty(str)) {
            this.r.setText(str);
        }
        this.B.setDuration(300);
        if (this.B.isRunning()) {
            this.B.cancel();
        }
        this.B.start();
    }

    private void p() {
        h hVar = this.s;
        if (hVar != null) {
            hVar.a();
        }
        this.s = null;
        h hVar2 = this.t;
        if (hVar2 != null) {
            hVar2.a();
        }
        this.t = null;
    }

    /* access modifiers changed from: private */
    public void q() {
        ImageView imageView = this.o;
        if (imageView != null) {
            imageView.setVisibility(4);
        }
        ImageView imageView2 = this.p;
        if (imageView2 != null) {
            imageView2.setVisibility(4);
        }
        ImageView imageView3 = this.q;
        if (imageView3 != null) {
            imageView3.setVisibility(4);
        }
        ObjectAnimator objectAnimator = this.C;
        if (objectAnimator != null && objectAnimator.isRunning()) {
            this.C.cancel();
        }
        ObjectAnimator objectAnimator2 = this.D;
        if (objectAnimator2 != null && objectAnimator2.isRunning()) {
            this.D.cancel();
        }
        ObjectAnimator objectAnimator3 = this.E;
        if (objectAnimator3 != null && objectAnimator3.isRunning()) {
            this.E.cancel();
        }
        ObjectAnimator objectAnimator4 = this.F;
        if (objectAnimator4 != null && objectAnimator4.isRunning()) {
            this.F.cancel();
        }
    }

    public void c(int i2) {
        if (i2 == R.string.beauty3d_turn_to_left || i2 == R.string.beauty3d_continue_turn_to_left) {
            e.a("Beauty3DGuideScanUI", "updateArrow, turn left");
            a((View) this.o, "translationX");
            a(this.E, (View) this.p);
            a(this.F, (View) this.q);
        } else if (i2 == R.string.beauty3d_turn_to_right || i2 == R.string.beauty3d_continue_turn_to_right) {
            e.a("Beauty3DGuideScanUI", "updateArrow, turn right");
            a((View) this.p, "translationX");
            a(this.D, (View) this.o);
            a(this.F, (View) this.q);
        } else if (i2 == R.string.beauty3d_turn_to_up) {
            e.a("Beauty3DGuideScanUI", "updateArrow, turn up");
            a((View) this.q, "translationY");
            a(this.E, (View) this.p);
            a(this.D, (View) this.o);
        } else {
            ObjectAnimator objectAnimator = this.C;
            if (objectAnimator != null && objectAnimator.isRunning()) {
                this.C.cancel();
            }
            a(this.E, (View) this.p);
            a(this.D, (View) this.o);
            a(this.F, (View) this.q);
        }
    }

    public void a(View view, String str) {
        PropertyValuesHolder propertyValuesHolder;
        if (view != null && view.getVisibility() != 0) {
            ObjectAnimator objectAnimator = this.C;
            if (objectAnimator != null && objectAnimator.isRunning()) {
                this.C.cancel();
            }
            e.a("Beauty3DGuideScanUI", "playStartArrowAnim");
            if (view.getId() == R.id.scan_right_arrow) {
                propertyValuesHolder = PropertyValuesHolder.ofFloat(str, new float[]{0.0f, (float) 100});
            } else {
                propertyValuesHolder = PropertyValuesHolder.ofFloat(str, new float[]{0.0f, (float) -100});
            }
            this.C = ObjectAnimator.ofPropertyValuesHolder(view, new PropertyValuesHolder[]{propertyValuesHolder, PropertyValuesHolder.ofFloat("alpha", new float[]{0.0f, 1.0f, 1.0f, 0.0f})});
            this.C.setInterpolator(this.K);
            this.C.setDuration(1200);
            this.C.setRepeatCount(-1);
            this.C.setRepeatMode(1);
            this.C.start();
            view.setVisibility(0);
        }
    }

    public void a(ObjectAnimator objectAnimator, final View view) {
        if (view != null && view.getVisibility() == 0) {
            if (objectAnimator == null || !objectAnimator.isRunning()) {
                e.a("Beauty3DGuideScanUI", "playFadeOutArrowAnim");
                if (objectAnimator == null) {
                    objectAnimator = ObjectAnimator.ofFloat(view, "alpha", new float[]{1.0f, 0.0f});
                    objectAnimator.addListener(new AnimatorListenerAdapter() {
                        public void onAnimationEnd(Animator animator) {
                            super.onAnimationEnd(animator);
                            view.setVisibility(4);
                            view.setAlpha(1.0f);
                        }
                    });
                }
                objectAnimator.setInterpolator(this.J);
                objectAnimator.setDuration(200);
                objectAnimator.start();
                return;
            }
            e.a("Beauty3DGuideScanUI", "playFadeOutArrowAnim, animator is Running");
        }
    }

    /* access modifiers changed from: private */
    public void d(int i2) {
        ImageView imageView;
        if (this.t == null && (imageView = this.z) != null) {
            this.t = new h(imageView, this.N, 41, true);
        }
        h hVar = this.s;
        if (hVar != null && !hVar.b()) {
            this.s.a();
        }
        h hVar2 = this.t;
        if (hVar2 != null && !hVar2.c()) {
            TextView textView = this.r;
            if (textView != null) {
                textView.setText(i2);
            }
            e.a("Beauty3DGuideScanUI", "startScanLoadAnim, mScanLoadAnimation start");
            this.t.d();
            this.y.setVisibility(4);
            View view = this.n;
            if (view != null) {
                ((ImageView) view.findViewById(R.id.scan_foreground_middle)).setImageResource(R.drawable.beauty3d_sacn_load_foreground);
            }
            PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat("scaleX", new float[]{1.0f, 0.75f});
            PropertyValuesHolder ofFloat2 = PropertyValuesHolder.ofFloat("scaleY", new float[]{1.0f, 0.75f});
            ObjectAnimator objectAnimator = this.G;
            if (objectAnimator != null && objectAnimator.isRunning()) {
                this.G.cancel();
            }
            this.G = ObjectAnimator.ofPropertyValuesHolder(this.z, new PropertyValuesHolder[]{ofFloat, ofFloat2});
            this.G.setDuration(500);
            this.G.setInterpolator(this.L);
            e.a("Beauty3DGuideScanUI", "startScanLoadAnim, scaleAnim start");
            this.G.start();
        }
    }

    public void h() {
        e.a("Beauty3DGuideScanUI", "scanComplete");
        AnimatorSet animatorSet = this.H;
        if (animatorSet == null || !animatorSet.isRunning()) {
            this.H = new AnimatorSet();
            PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat("scaleX", new float[]{0.0f, 2.0f});
            PropertyValuesHolder ofFloat2 = PropertyValuesHolder.ofFloat("scaleY", new float[]{0.0f, 2.0f});
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.z, new PropertyValuesHolder[]{ofFloat, ofFloat2});
            ofPropertyValuesHolder.setInterpolator(this.L);
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.z, "alpha", new float[]{1.0f, 0.0f});
            this.H.setDuration(500);
            this.H.playTogether(new Animator[]{ofPropertyValuesHolder, ofFloat3});
            this.H.addListener(new Animator.AnimatorListener() {
                public void onAnimationRepeat(Animator animator) {
                }

                public void onAnimationStart(Animator animator) {
                    boolean unused = f.this.I = false;
                }

                public void onAnimationEnd(Animator animator) {
                    e.a("Beauty3DGuideScanUI", "scanComplete, onAnimationEnd, mbScanCompleteCancel: " + f.this.I);
                    if (f.this.O != null && !f.this.I) {
                        f.this.O.post(new Runnable() {
                            public void run() {
                                f.this.z.setAlpha(1.0f);
                                if (f.this.u != null) {
                                    f.this.u.c();
                                    f.this.a(false, true);
                                }
                            }
                        });
                    }
                }

                public void onAnimationCancel(Animator animator) {
                    boolean unused = f.this.I = true;
                }
            });
            this.H.start();
            return;
        }
        e.a("Beauty3DGuideScanUI", "scanComplete,isRunning return");
    }
}
