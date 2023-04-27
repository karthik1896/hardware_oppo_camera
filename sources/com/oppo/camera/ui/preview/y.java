package com.oppo.camera.ui.preview;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import com.oppo.camera.R;
import com.oppo.camera.ac;
import com.oppo.camera.e;
import com.oppo.camera.ui.c;
import com.oppo.camera.util.Util;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;

/* compiled from: ZoomSeekBar */
public abstract class y extends c {
    protected static final int p = ((int) (((float) Util.E()) * 0.104f));
    protected int A = 0;
    protected int B = 0;
    protected int C = 0;
    protected int D = 0;
    protected int E = 0;
    protected int F = 0;
    protected int G = 0;
    protected int H = 0;
    protected int I = 0;
    protected int J = 0;
    protected int K = 0;
    protected float L = 0.0f;
    protected float M = 0.0f;
    protected int N = 0;
    protected int O = 0;
    protected int P = 0;
    protected int Q = 0;
    protected int R = 0;
    protected int S = 0;
    protected float T = 0.0f;
    protected float U = 0.0f;
    protected int V = 0;
    protected int W = 0;
    protected int aA = 0;
    protected ArrayList<Float> aB = null;
    protected float[] aC = null;
    protected GestureDetector aD = null;
    protected x aE = null;
    protected Bitmap aF = null;
    protected Bitmap aG = null;
    protected Canvas aH = null;
    protected Canvas aI = null;
    protected DecimalFormat aJ = null;
    protected float aK = 0.0f;
    protected float aL = 0.0f;
    protected float aM = 0.0f;
    protected float aN = 0.0f;
    protected float aO = 0.0f;
    protected float aP = 0.0f;
    protected float aQ = 0.31f;
    protected boolean aR = false;
    protected boolean aS = false;
    protected int aT = 0;
    private boolean aU = false;
    private int aV = -1;
    private Path aW = null;
    /* access modifiers changed from: private */
    public float aX = 0.0f;
    private int aY = 200;
    /* access modifiers changed from: private */
    public ValueAnimator aZ = null;
    protected int aa = 0;
    protected float ab = 0.0f;
    protected float ac = 0.0f;
    protected boolean ad = false;
    protected boolean ae = false;
    protected boolean af = false;
    protected boolean ag = false;
    protected String ah = "";
    protected String ai = null;
    protected Drawable aj = null;
    protected float ak = 0.0f;
    protected float al = 0.0f;
    protected ArrayList<Float> am = null;
    protected ArrayList<Float> an = null;
    protected ArrayList<Float> ao = null;
    protected ArrayList<Integer> ap = null;
    protected Paint aq = null;
    protected Paint ar = null;
    protected Paint as = null;
    protected int at = 0;
    protected Paint au = null;
    protected int av = 0;
    protected Paint aw = null;
    protected Paint ax = null;
    protected Paint ay = null;
    protected TextPaint az = null;
    private long ba = 0;
    private long bb = 0;
    private int bc = 0;
    private int bd = 0;
    private int[] be = null;
    protected VelocityTracker q = null;
    protected int r = 0;
    protected int s = 0;
    protected int t = 0;
    protected float u = 0.0f;
    protected float v = 0.0f;
    protected Context w = null;
    protected Resources x = null;
    protected int y = 0;
    protected int z = 0;

    /* access modifiers changed from: protected */
    public abstract float a(float f, VelocityTracker velocityTracker);

    /* access modifiers changed from: protected */
    public boolean a(MotionEvent motionEvent) {
        return true;
    }

    public abstract int getLayoutHeight();

    public abstract int getType();

    public y(Context context) {
        super(context, (AttributeSet) null);
        this.w = context;
        this.x = this.w.getResources();
        i();
        setForceDarkAllowed(false);
    }

    private void i() {
        float f = this.x.getDisplayMetrics().density;
        this.s = (int) (400.0f * f);
        this.t = (int) (((float) this.s) * 10.0f);
        this.r = (int) (f * 20.0f);
        this.aW = new Path();
        this.U = 0.0f;
        l();
        this.ad = false;
        this.aJ = new DecimalFormat("#.#");
        this.bc = this.x.getDimensionPixelSize(R.dimen.zoom_click_hotspot_width_offset);
        this.bd = this.x.getDimensionPixelSize(R.dimen.zoom_hotspot_height);
        this.C = this.x.getDimensionPixelSize(R.dimen.zoom_click_point_radius);
        this.D = this.x.getDimensionPixelSize(R.dimen.zoom_click_point_gap);
        this.E = this.x.getDimensionPixelSize(R.dimen.zoom_click_point_shadow_radius);
        this.A = this.x.getDimensionPixelSize(R.dimen.zoom_focus_circle_stroke_width);
        this.B = this.x.getDimensionPixelSize(R.dimen.zoom_focus_circle_width) / 2;
        this.y = this.B - this.A;
        this.z = this.x.getDimensionPixelSize(R.dimen.zoom_focus_circle_radius_pressed);
        this.F = this.x.getDimensionPixelSize(R.dimen.zoom_focus_text_size_normal);
        this.G = this.x.getDimensionPixelSize(R.dimen.zoom_focus_text_size_pressed);
        this.I = this.x.getDimensionPixelSize(R.dimen.zoom_current_text_move_distance_max);
        this.ax = new Paint();
        this.ax.setAntiAlias(true);
        this.ay = new Paint();
        this.ay.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.aq = new Paint();
        this.aq.setAntiAlias(true);
        this.aq.setTextSize((float) this.F);
        this.aq.setColor(-1);
        this.aq.setTextAlign(Paint.Align.CENTER);
        this.aq.setTypeface(Util.j(this.w));
        this.as = new Paint();
        this.as.setAntiAlias(true);
        this.as.setStyle(Paint.Style.FILL);
        this.at = this.x.getColor(R.color.zoom_seekbar_focus_circle_bg_color);
        this.as.setColor(this.at);
        this.au = new Paint();
        this.au.setAntiAlias(true);
        this.au.setStyle(Paint.Style.STROKE);
        this.au.setStrokeWidth((float) this.A);
        this.av = this.x.getColor(R.color.zoom_seekbar_focus_circle_stroke_color);
        this.au.setColor(this.av);
        this.aw = new Paint();
        this.aw.setAntiAlias(true);
        this.aw.setStyle(Paint.Style.FILL);
        this.aw.setColor(-1);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:101:0x02a5, code lost:
        if (java.lang.Math.sqrt(java.lang.Math.pow((double) (r6.aO - r6.aL), 2.0d) + java.lang.Math.pow((double) (r6.aP - r6.aN), 2.0d)) <= ((double) (r6.aQ * ((float) p)))) goto L_0x03fe;
     */
    /* JADX WARNING: Removed duplicated region for block: B:169:0x03fc  */
    /* JADX WARNING: Removed duplicated region for block: B:174:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r22) {
        /*
            r21 = this;
            r6 = r21
            r0 = r22
            com.oppo.camera.ui.preview.x r1 = r6.aE
            boolean r1 = r1.d()
            java.lang.String r2 = "ZoomSeekBar"
            r7 = 0
            r8 = 0
            r9 = 1
            if (r1 != 0) goto L_0x0042
            com.oppo.camera.ui.preview.x r1 = r6.aE
            boolean r1 = r1.a()
            if (r1 == 0) goto L_0x001f
            boolean r1 = r21.isEnabled()
            if (r1 != 0) goto L_0x0042
        L_0x001f:
            java.lang.String r0 = "onTouchEvent, disabled"
            com.oppo.camera.e.a(r2, r0)
            android.os.Handler r0 = r6.o
            boolean r0 = r0.hasMessages(r9)
            if (r0 != 0) goto L_0x0035
            android.os.Handler r0 = r6.o
            long r1 = r21.getCollapseDelay()
            r0.sendEmptyMessageDelayed(r9, r1)
        L_0x0035:
            r6.aR = r8
            r6.T = r7
            r0 = 0
            r6.aD = r0
            r6.ad = r8
            r21.invalidate()
            return r8
        L_0x0042:
            com.oppo.camera.ui.preview.x r1 = r6.aE
            boolean r1 = r1.a()
            if (r1 != 0) goto L_0x0053
            com.oppo.camera.ui.preview.x r1 = r6.aE
            boolean r1 = r1.c()
            if (r1 == 0) goto L_0x0053
            return r8
        L_0x0053:
            android.view.GestureDetector r1 = r6.aD
            if (r1 != 0) goto L_0x0065
            android.view.GestureDetector r1 = new android.view.GestureDetector
            android.content.Context r3 = r6.w
            com.oppo.camera.ui.preview.y$a r4 = new com.oppo.camera.ui.preview.y$a
            r4.<init>()
            r1.<init>(r3, r4)
            r6.aD = r1
        L_0x0065:
            android.view.VelocityTracker r1 = r6.q
            if (r1 != 0) goto L_0x006f
            android.view.VelocityTracker r1 = android.view.VelocityTracker.obtain()
            r6.q = r1
        L_0x006f:
            android.view.VelocityTracker r1 = r6.q
            r1.addMovement(r0)
            int r1 = r22.getAction()
            if (r1 != 0) goto L_0x007c
            r6.aS = r8
        L_0x007c:
            boolean r1 = r6.aS
            if (r1 != 0) goto L_0x0085
            android.view.GestureDetector r1 = r6.aD
            r1.onTouchEvent(r0)
        L_0x0085:
            float r10 = r22.getX()
            float r11 = r22.getY()
            int r1 = r22.getAction()
            r12 = 1073741824(0x40000000, float:2.0)
            r13 = 1065353216(0x3f800000, float:1.0)
            r14 = 3
            r15 = 2
            if (r1 == 0) goto L_0x030b
            if (r1 == r9) goto L_0x02e2
            if (r1 == r15) goto L_0x009f
            goto L_0x03fe
        L_0x009f:
            int r1 = r6.f3880b
            if (r1 == 0) goto L_0x02d9
            int r1 = r6.f3880b
            if (r9 == r1) goto L_0x02d9
            int r1 = r6.f3880b
            if (r14 != r1) goto L_0x00ad
            goto L_0x02d9
        L_0x00ad:
            int r1 = r22.getActionIndex()
            int r1 = r0.getPointerId(r1)
            int r4 = r6.aa
            if (r4 == r1) goto L_0x00c3
            r6.aa = r1
            r6.aK = r10
            r6.aM = r11
            r6.aL = r10
            r6.aN = r11
        L_0x00c3:
            android.view.VelocityTracker r1 = r6.q
            r4 = 1000(0x3e8, float:1.401E-42)
            int r5 = r6.t
            float r5 = (float) r5
            r1.computeCurrentVelocity(r4, r5)
            float r4 = r1.getXVelocity()
            int r4 = (int) r4
            int r4 = java.lang.Math.abs(r4)
            float r5 = r6.aL
            r6.aK = r5
            float r5 = r6.aN
            r6.aM = r5
            float r5 = r22.getX()
            r6.aL = r5
            float r0 = r22.getY()
            r6.aN = r0
            float r0 = r6.aL
            float r5 = r6.aK
            float r0 = r0 - r5
            float r5 = r6.aN
            float r10 = r6.aM
            float r5 = r5 - r10
            android.content.res.Resources r10 = r21.getResources()
            r11 = 2131166760(0x7f070628, float:1.7947774E38)
            float r10 = r10.getDimension(r11)
            int r11 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
            if (r11 != 0) goto L_0x0109
            int r11 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r11 != 0) goto L_0x0109
            goto L_0x03fe
        L_0x0109:
            int r11 = com.oppo.camera.util.Util.E()
            int r11 = r11 / r15
            float r11 = (float) r11
            float r11 = r0 - r11
            float r11 = java.lang.Math.abs(r11)
            int r11 = (r11 > r10 ? 1 : (r11 == r10 ? 0 : -1))
            if (r11 >= 0) goto L_0x012f
            float r11 = java.lang.Math.abs(r0)
            float r14 = java.lang.Math.abs(r5)
            float r11 = r11 / r14
            double r14 = (double) r11
            r11 = 1106247680(0x41f00000, float:30.0)
            double r16 = r6.h((float) r11)
            int r11 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1))
            if (r11 >= 0) goto L_0x012f
            goto L_0x03fe
        L_0x012f:
            int r11 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r11 >= 0) goto L_0x0155
            float r11 = java.lang.Math.abs(r0)
            float r5 = java.lang.Math.abs(r5)
            float r11 = r11 / r5
            double r14 = (double) r11
            r5 = 1097859072(0x41700000, float:15.0)
            double r16 = r6.h((float) r5)
            int r5 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1))
            if (r5 >= 0) goto L_0x0155
            float r5 = r6.aN
            int r11 = r21.getHeight()
            float r11 = (float) r11
            float r11 = r11 * r13
            int r5 = (r5 > r11 ? 1 : (r5 == r11 ? 0 : -1))
            if (r5 >= 0) goto L_0x0155
            goto L_0x03fe
        L_0x0155:
            float r5 = r6.aN
            int r5 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            r14 = 4611686018427387904(0x4000000000000000, double:2.0)
            if (r5 >= 0) goto L_0x01ed
            int r0 = r21.getMeasuredWidth()
            float r0 = (float) r0
            float r0 = r0 / r12
            int r5 = r21.getMeasuredHeight()
            float r5 = (float) r5
            int r11 = com.oppo.camera.util.Util.w()
            float r11 = (float) r11
            float r11 = r11 / r12
            float r5 = r5 + r11
            float r11 = r6.aN
            float r11 = r11 - r5
            float r11 = java.lang.Math.abs(r11)
            double r11 = (double) r11
            double r11 = java.lang.Math.pow(r11, r14)
            float r8 = r6.aL
            float r8 = r8 - r0
            float r8 = java.lang.Math.abs(r8)
            r18 = r4
            double r3 = (double) r8
            double r3 = java.lang.Math.pow(r3, r14)
            double r11 = r11 + r3
            double r3 = java.lang.Math.sqrt(r11)
            double r3 = r3 * r14
            double r10 = (double) r10
            int r3 = (r3 > r10 ? 1 : (r3 == r10 ? 0 : -1))
            if (r3 >= 0) goto L_0x0196
            goto L_0x03fe
        L_0x0196:
            float r3 = r6.aK
            float r0 = r0 - r3
            float r4 = r6.aN
            float r8 = r6.aM
            float r10 = r4 - r8
            float r0 = r0 * r10
            float r5 = r5 - r8
            float r10 = r6.aL
            float r10 = r10 - r3
            float r5 = r5 * r10
            float r0 = r0 - r5
            double r10 = (double) r0
            r19 = 0
            int r0 = (r19 > r10 ? 1 : (r19 == r10 ? 0 : -1))
            if (r0 >= 0) goto L_0x01ce
            float r4 = r4 - r8
            float r0 = java.lang.Math.abs(r4)
            double r3 = (double) r0
            double r3 = java.lang.Math.pow(r3, r14)
            float r0 = r6.aL
            float r5 = r6.aK
            float r0 = r0 - r5
            float r0 = java.lang.Math.abs(r0)
            double r10 = (double) r0
            double r10 = java.lang.Math.pow(r10, r14)
            double r3 = r3 + r10
            double r3 = java.lang.Math.sqrt(r3)
            float r0 = (float) r3
            float r0 = r7 - r0
            goto L_0x01ef
        L_0x01ce:
            float r4 = r4 - r8
            float r0 = java.lang.Math.abs(r4)
            double r3 = (double) r0
            double r3 = java.lang.Math.pow(r3, r14)
            float r0 = r6.aL
            float r5 = r6.aK
            float r0 = r0 - r5
            float r0 = java.lang.Math.abs(r0)
            double r10 = (double) r0
            double r10 = java.lang.Math.pow(r10, r14)
            double r3 = r3 + r10
            double r3 = java.lang.Math.sqrt(r3)
            float r0 = (float) r3
            goto L_0x01ef
        L_0x01ed:
            r18 = r4
        L_0x01ef:
            int r3 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
            if (r3 >= 0) goto L_0x01f5
            r3 = r9
            goto L_0x01f6
        L_0x01f5:
            r3 = 0
        L_0x01f6:
            float r4 = r6.h
            int r4 = java.lang.Float.compare(r4, r7)
            if (r4 == 0) goto L_0x0206
            float r4 = r6.h
            int r4 = java.lang.Float.compare(r4, r13)
            if (r4 != 0) goto L_0x023e
        L_0x0206:
            int r4 = r6.aV
            if (r3 == r4) goto L_0x0217
            r5 = -1
            if (r4 == r5) goto L_0x020f
            r4 = r9
            goto L_0x0210
        L_0x020f:
            r4 = 0
        L_0x0210:
            r6.aU = r4
            r6.aT = r9
            r6.aV = r3
            goto L_0x0220
        L_0x0217:
            boolean r4 = r6.aU
            if (r4 == 0) goto L_0x0220
            int r4 = r6.aT
            int r4 = r4 + r9
            r6.aT = r4
        L_0x0220:
            boolean r4 = r6.aU
            if (r4 == 0) goto L_0x023e
            int r4 = r6.aT
            if (r4 > r9) goto L_0x023e
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "onTouchEvent, ignore move event, direction: "
            r0.append(r1)
            r0.append(r3)
            java.lang.String r0 = r0.toString()
            com.oppo.camera.e.a(r2, r0)
            goto L_0x03fe
        L_0x023e:
            float r2 = r6.h
            int r2 = java.lang.Float.compare(r2, r13)
            if (r2 < 0) goto L_0x0248
            if (r3 == 0) goto L_0x0252
        L_0x0248:
            float r2 = r6.h
            int r2 = java.lang.Float.compare(r2, r7)
            if (r2 > 0) goto L_0x0260
            if (r9 != r3) goto L_0x0260
        L_0x0252:
            boolean r0 = r6.aR
            if (r0 == 0) goto L_0x03fe
            float r0 = r6.aL
            r6.aO = r0
            float r0 = r6.aN
            r6.aP = r0
            goto L_0x03fe
        L_0x0260:
            float r0 = r6.a((float) r0, (android.view.VelocityTracker) r1)
            r1 = -1082130432(0xffffffffbf800000, float:-1.0)
            int r1 = (r1 > r0 ? 1 : (r1 == r0 ? 0 : -1))
            if (r1 != 0) goto L_0x026c
            goto L_0x03fe
        L_0x026c:
            float r1 = r6.h
            float r1 = r1 + r0
            boolean r0 = r6.aR
            if (r0 == 0) goto L_0x02a9
            r0 = 1050589266(0x3e9eb852, float:0.31)
            r2 = r18
            float r3 = (float) r2
            r4 = -1105282990(0xffffffffbe1eb852, float:-0.155)
            float r3 = r3 * r4
            r4 = 1143930880(0x442f0000, float:700.0)
            float r3 = r3 / r4
            float r3 = r3 + r0
            r6.aQ = r3
            float r0 = r6.aO
            float r3 = r6.aL
            float r0 = r0 - r3
            double r3 = (double) r0
            double r3 = java.lang.Math.pow(r3, r14)
            float r0 = r6.aP
            float r5 = r6.aN
            float r0 = r0 - r5
            double r10 = (double) r0
            double r10 = java.lang.Math.pow(r10, r14)
            double r3 = r3 + r10
            double r3 = java.lang.Math.sqrt(r3)
            float r0 = r6.aQ
            int r5 = p
            float r5 = (float) r5
            float r0 = r0 * r5
            double r10 = (double) r0
            int r0 = (r3 > r10 ? 1 : (r3 == r10 ? 0 : -1))
            if (r0 > 0) goto L_0x02ab
            goto L_0x03fe
        L_0x02a9:
            r2 = r18
        L_0x02ab:
            float r0 = r6.h
            float r0 = r6.c(r1, r0)
            int r3 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r3 < 0) goto L_0x02c4
            r4 = 700(0x2bc, float:9.81E-43)
            if (r4 <= r2) goto L_0x02c4
            r6.aR = r9
            float r1 = r6.aL
            r6.aO = r1
            float r1 = r6.aN
            r6.aP = r1
            goto L_0x02c8
        L_0x02c4:
            r0 = 0
            r6.aR = r0
            r0 = r1
        L_0x02c8:
            r6.setRate(r0)
            float r0 = r6.h
            if (r3 < 0) goto L_0x02d1
            r1 = r9
            goto L_0x02d2
        L_0x02d1:
            r1 = 0
        L_0x02d2:
            r6.a((float) r0, (boolean) r1)
            r6.aS = r9
            goto L_0x03fe
        L_0x02d9:
            r6.aK = r10
            r6.aM = r11
            r6.aL = r10
            r6.aN = r11
            return r9
        L_0x02e2:
            int r0 = r6.f3880b
            if (r9 == r0) goto L_0x02ea
            int r0 = r6.f3880b
            if (r15 != r0) goto L_0x0301
        L_0x02ea:
            android.os.Handler r0 = r6.o
            r0.removeMessages(r9)
            android.os.Handler r0 = r6.o
            long r1 = r21.getCollapseDelay()
            r0.sendEmptyMessageDelayed(r9, r1)
            com.oppo.camera.ui.c$a r0 = r6.n
            if (r0 == 0) goto L_0x0301
            com.oppo.camera.ui.c$a r0 = r6.n
            r0.e()
        L_0x0301:
            r0 = 0
            r6.aR = r0
            r6.ad = r0
            r21.invalidate()
            goto L_0x03fe
        L_0x030b:
            int r1 = r6.f3880b
            if (r9 == r1) goto L_0x0313
            int r1 = r6.f3880b
            if (r15 != r1) goto L_0x031c
        L_0x0313:
            com.oppo.camera.ui.c$a r1 = r6.n
            if (r1 == 0) goto L_0x031c
            com.oppo.camera.ui.c$a r1 = r6.n
            r1.f()
        L_0x031c:
            int r1 = r6.f3880b
            if (r14 != r1) goto L_0x0321
            return r9
        L_0x0321:
            boolean r0 = r21.a((android.view.MotionEvent) r22)
            if (r0 != 0) goto L_0x032d
            int r0 = r6.f3880b
            if (r15 != r0) goto L_0x032d
            r0 = 0
            return r0
        L_0x032d:
            r0 = 0
            int r1 = r6.f3880b
            if (r9 != r1) goto L_0x0333
            return r0
        L_0x0333:
            android.os.Handler r1 = r6.o
            r1.removeMessages(r9)
            r1 = -1
            r6.aV = r1
            r6.aU = r0
            r6.aT = r0
            r6.ab = r10
            r6.ac = r11
            r6.aR = r0
            r6.aK = r10
            r6.aM = r11
            r6.aL = r10
            r6.aN = r11
            float r1 = r6.ab
            float r2 = r6.ac
            int r0 = r6.f3879a
            int r0 = r0 / r15
            float r3 = (float) r0
            float r4 = r6.k
            int r0 = r6.B
            float r0 = (float) r0
            int r5 = r6.D
            float r5 = (float) r5
            float r5 = r5 * r13
            float r5 = r5 / r12
            float r5 = r5 + r0
            r0 = r21
            boolean r0 = r0.a((float) r1, (float) r2, (float) r3, (float) r4, (float) r5)
            r6.ad = r0
            boolean r0 = r6.ad
            if (r0 == 0) goto L_0x0375
            int r0 = r6.f3880b
            if (r0 != 0) goto L_0x0375
            r6.T = r7
            r21.invalidate()
        L_0x0375:
            int r0 = r6.f3880b
            if (r0 != 0) goto L_0x03fe
            int r0 = r6.J
            r1 = 0
            float r0 = r6.a((int) r1, (int) r0)
            int r1 = r6.aA
            int r1 = r1 - r9
            int r2 = r6.J
            float r1 = r6.a((int) r1, (int) r2)
            int r2 = r6.bc
            float r2 = (float) r2
            int r3 = r6.aA
            int r3 = r3 - r9
            int r4 = r6.J
            if (r4 <= r14) goto L_0x0396
            int r8 = r4 + -3
            goto L_0x0397
        L_0x0396:
            r8 = 0
        L_0x0397:
            int r4 = r6.J
            int r5 = r4 + 3
            int r7 = r6.aA
            int r7 = r7 - r9
            if (r5 >= r7) goto L_0x03a2
            int r3 = r4 + 3
        L_0x03a2:
            int r4 = r6.J
            if (r8 != r4) goto L_0x03bb
            r5 = 0
            int r3 = r6.c((int) r5)
            int r3 = r3 / r15
            float r3 = (float) r3
            float r0 = r0 - r3
            int r3 = r6.aA
            int r3 = r3 - r9
            int r3 = r6.c((int) r3)
            int r3 = r3 / r15
            float r3 = (float) r3
            float r1 = r1 + r3
        L_0x03b8:
            float r1 = r1 + r2
            r3 = 0
            goto L_0x03e4
        L_0x03bb:
            if (r3 != r4) goto L_0x03d0
            r3 = 0
            int r4 = r6.c((int) r3)
            int r4 = r4 / r15
            float r3 = (float) r4
            float r0 = r0 - r3
            float r0 = r0 - r2
            int r2 = r6.aA
            int r2 = r2 - r9
            int r2 = r6.c((int) r2)
            int r2 = r2 / r15
            float r2 = (float) r2
            goto L_0x03b8
        L_0x03d0:
            r3 = 0
            int r4 = r6.c((int) r3)
            int r4 = r4 / r15
            float r4 = (float) r4
            float r0 = r0 - r4
            float r0 = r0 - r2
            int r4 = r6.aA
            int r4 = r4 - r9
            int r4 = r6.c((int) r4)
            int r4 = r4 / r15
            float r4 = (float) r4
            float r1 = r1 + r4
            float r1 = r1 + r2
        L_0x03e4:
            int r0 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r0 < 0) goto L_0x03fd
            int r0 = (r10 > r1 ? 1 : (r10 == r1 ? 0 : -1))
            if (r0 > 0) goto L_0x03fd
            float r0 = r6.k
            float r0 = r0 - r11
            float r0 = java.lang.Math.abs(r0)
            int r1 = r6.bd
            float r1 = (float) r1
            float r1 = r1 * r13
            float r1 = r1 / r12
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 > 0) goto L_0x03fd
            r3 = r9
        L_0x03fd:
            return r3
        L_0x03fe:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.ui.preview.y.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void a(float f, float f2, float f3, ArrayList<Float> arrayList, ArrayList<Float> arrayList2) {
        this.aB = arrayList2;
        this.aA = arrayList2.size();
        this.ak = f2;
        this.al = f3;
        Float valueOf = Float.valueOf(0.6f);
        this.ag = !arrayList.contains(valueOf) && arrayList2.contains(valueOf);
        if (this.ag) {
            arrayList.add(0, valueOf);
        }
        this.u = g(f3) / ((float) this.f3879a);
        this.v = this.u * 2.0f;
        this.am = getZoomSections();
        this.an = getSectionStep();
        this.ap = getIndicatorSections();
        ArrayList<Integer> arrayList3 = this.ap;
        this.V = arrayList3.get(arrayList3.size() - 1).intValue() + 1;
        this.O = this.V - 1;
        this.aC = new float[arrayList.size()];
        for (int i = 0; i < this.aC.length; i++) {
            this.aC[i] = e(arrayList.get(i).floatValue());
        }
        j();
        float e = e(f);
        if (1 == getLayoutDirection()) {
            e = Util.a(1.0f, e);
        }
        this.h = e;
        this.i = this.h;
        this.ah = this.aJ.format((double) d(f)) + "X";
        int f4 = f(f);
        if (!h() || f4 == this.K) {
            setCenterPointIndex(f4);
        } else {
            this.aZ.cancel();
            a(f4, f);
        }
        setExtraDrawable(this.aE.a(f));
        e.a("ZoomSeekBar", "init, mCurrentDisplayText: " + this.ah);
        setContentDescription(getContext().getResources().getString(R.string.camera_description_zoom_seek_bar) + this.ah);
        a();
        postInvalidate();
    }

    private void j() {
        Paint.FontMetrics fontMetrics = this.aq.getFontMetrics();
        this.U = ((fontMetrics.bottom - fontMetrics.top) / 2.0f) - fontMetrics.bottom;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        synchronized (this) {
            k();
            super.onDraw(canvas);
        }
    }

    private void k() {
        if (this.P != this.R) {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            if (currentAnimationTimeMillis < this.bb) {
                int i = (int) (currentAnimationTimeMillis - this.ba);
                int i2 = this.Q;
                if (!this.ae) {
                    i = -i;
                }
                int i3 = i2 + ((i * 360) / 1000);
                this.P = i3 >= 0 ? i3 % 360 : (i3 % 360) + 360;
                invalidate();
                return;
            }
            this.P = this.R;
        }
    }

    public void d() {
        this.aF = Util.a(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
        this.aH = new Canvas();
        this.aH.setBitmap(this.aF);
        this.aG = Util.a(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
        this.aI = new Canvas();
        this.aI.setBitmap(this.aG);
    }

    public void b() {
        super.b();
        ValueAnimator valueAnimator = this.aZ;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        a();
        this.ad = false;
        setRate(e(1.0f));
        e();
    }

    /* access modifiers changed from: protected */
    public void a() {
        this.aq.setColor(-1);
        this.as.setColor(this.at);
        this.au.setColor(this.av);
        this.aw.setColor(-1);
    }

    public void e() {
        Bitmap bitmap = this.aF;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.aF.recycle();
            this.aF = null;
        }
        Bitmap bitmap2 = this.aG;
        if (bitmap2 != null && !bitmap2.isRecycled()) {
            this.aG.recycle();
            this.aG = null;
        }
        this.aI = null;
        this.aH = null;
    }

    public void a(Animation.AnimationListener animationListener) {
        this.ad = false;
        super.a(animationListener);
    }

    public boolean b(boolean z2) {
        this.ad = false;
        return super.b(z2);
    }

    public void c() {
        this.T = 0.0f;
        super.c();
        d();
    }

    /* access modifiers changed from: protected */
    public void a(Canvas canvas) {
        int i;
        int i2;
        c(true);
        if (!this.aZ.isRunning() || (i = this.J) == (i2 = this.K) || this.af) {
            a(canvas, this.ah, this.aj, this.j, this.k);
        } else {
            a(canvas, this.ah, this.aj, i, i2);
        }
        super.a(canvas);
    }

    /* access modifiers changed from: protected */
    public void c(boolean z2) {
        if (z2) {
            this.aw.setShadowLayer((float) this.E, 0.0f, 0.0f, this.x.getColor(R.color.color_black_with_70_percent_transparency));
        } else {
            this.aw.clearShadowLayer();
        }
    }

    /* access modifiers changed from: protected */
    public void c(Canvas canvas) {
        if (this.g <= 0.0f) {
            e();
        }
        super.c(canvas);
    }

    public void a(float f, boolean z2) {
        if (1 == getLayoutDirection()) {
            f = Util.a(1.0f, f);
        }
        float b2 = b(f);
        this.ah = this.aJ.format((double) d(b2)) + "X";
        if (this.n != null) {
            this.n.a(b2, z2);
        }
        setExtraDrawable(this.aE.a(b2));
        setCenterPointIndex(f(b2));
        this.K = this.J;
        e.a("ZoomSeekBar", "onChanged, mCurrentDisplayText: " + this.ah + ", zoom: " + b2);
        StringBuilder sb = new StringBuilder();
        sb.append(getContext().getResources().getString(R.string.camera_description_zoom_seek_bar));
        sb.append(this.ah);
        setContentDescription(sb.toString());
        invalidate();
    }

    /* access modifiers changed from: protected */
    public void a(Canvas canvas, String str, Drawable drawable, int i, int i2) {
        float f;
        int i3 = i;
        int i4 = i2;
        int i5 = this.y;
        int i6 = this.F;
        int i7 = this.A;
        int i8 = this.J;
        int i9 = i8 > 3 ? i8 - 3 : 0;
        int size = this.aB.size();
        if (this.J + 1 + 3 < this.aB.size()) {
            size = this.J + 1 + 3;
        }
        int i10 = size;
        for (int i11 = i9; i11 < i10; i11++) {
            float a2 = a(i11, i3);
            if (i3 == i4) {
                f = a2;
            } else {
                f = a(i11, i4);
            }
            float f2 = this.aX;
            float f3 = a2 + ((f - a2) * f2);
            if (i11 == i3) {
                float abs = Math.abs(1.0f - f2);
                this.aq.setTextSize(((float) this.F) * abs);
                float f4 = ((float) this.y) * abs;
                int i12 = this.A;
                this.au.setStrokeWidth(((float) i12) + (((float) (this.C - i12)) * this.aX));
                a(canvas, f3, this.k, str, drawable, f4, abs, 255);
            } else if (i11 == i4) {
                this.aq.setTextSize(((float) this.F) * f2);
                float f5 = this.aX;
                float f6 = ((float) this.y) * f5;
                int i13 = this.C;
                this.au.setStrokeWidth(((float) i13) + (((float) (this.A - i13)) * f5));
                float f7 = this.L;
                a(canvas, f3, this.k, this.aJ.format((double) d(f7)) + "X", this.aE.a(f7), f6, this.aX, 255);
            } else {
                canvas.drawCircle(f3, this.k, (float) this.C, this.aw);
            }
            Canvas canvas2 = canvas;
        }
        this.au.setStrokeWidth((float) this.A);
        this.aq.setTextSize((float) this.F);
    }

    private float c(float f, float f2) {
        float f3;
        float min = Math.min(f, f2);
        float max = Math.max(f, f2);
        if (Float.compare(min, max) == 0) {
            return -1.0f;
        }
        for (int i = 0; i < this.aC.length; i++) {
            if (1 == getLayoutDirection()) {
                float[] fArr = this.aC;
                f3 = Util.a(1.0f, fArr[(fArr.length - 1) - i]);
            } else {
                f3 = this.aC[i];
            }
            if ((Float.compare(f3, f2) > 0 && Float.compare(f3, f) <= 0) || (Float.compare(f3, f2) < 0 && Float.compare(f3, f) >= 0)) {
                return f3;
            }
            if (Float.compare(f3, max) > 0) {
                return -1.0f;
            }
        }
        return -1.0f;
    }

    public void a(int i, boolean z2) {
        int i2 = i >= 0 ? i % 360 : (i % 360) + 360;
        if (i2 != this.R) {
            this.R = i2;
            if (z2) {
                this.Q = this.P;
                this.ba = AnimationUtils.currentAnimationTimeMillis();
                int i3 = this.R - this.P;
                if (i3 < 0) {
                    i3 += 360;
                }
                if (i3 > 180) {
                    i3 -= 360;
                }
                this.ae = i3 >= 0;
                this.bb = this.ba + ((long) ((Math.abs(i3) * 1000) / 360));
            } else {
                this.P = this.R;
            }
            invalidate();
        }
    }

    /* access modifiers changed from: protected */
    public void a(int i, float f) {
        e.a("ZoomSeekBar", "startSlideTo, centerPointIndex: " + i + ", toValue: " + f);
        if (i == this.J) {
            if (!this.ah.equals(this.aJ.format((double) d(f)) + "X")) {
                b(f, false);
                return;
            }
            return;
        }
        this.T = 0.0f;
        this.K = i;
        this.L = f;
        this.M = f;
        this.aZ.start();
    }

    public boolean f() {
        return getVisibility() == 0 && (3 == this.f3880b || 6 == this.f3880b);
    }

    public boolean g() {
        if (getVisibility() == 0) {
            return 2 == this.f3880b || 1 == this.f3880b;
        }
        return false;
    }

    public boolean h() {
        ValueAnimator valueAnimator = this.aZ;
        if (valueAnimator != null) {
            return valueAnimator.isRunning();
        }
        return false;
    }

    public void setZoomListener(x xVar) {
        this.aE = xVar;
    }

    /* access modifiers changed from: protected */
    public void setCenterPointIndex(int i) {
        e.a("ZoomSeekBar", "setCenterPointIndex, index: " + i);
        this.J = i;
    }

    public void b(float f, boolean z2) {
        e.a("ZoomSeekBar", "updateUI, zoomValue: " + f + ", rest: " + this.aZ.isRunning());
        if (this.aZ.isRunning()) {
            this.M = f;
            return;
        }
        if (z2 && g()) {
            this.o.removeMessages(1);
            this.o.sendEmptyMessageDelayed(1, getCollapseDelay());
        }
        float e = e(f);
        if (Float.compare(e, 0.0f) < 0) {
            e = 0.0f;
        } else if (Float.compare(e, 1.0f) > 0) {
            e = 1.0f;
        }
        if (1 == getLayoutDirection()) {
            setRate(1.0f - e);
        } else {
            setRate(e);
        }
        int f2 = f(f);
        if (f2 != this.J) {
            if (this.f3880b == 0) {
                a(f2, f);
                return;
            } else {
                setCenterPointIndex(f2);
                this.K = this.J;
            }
        }
        this.ah = this.aJ.format((double) d(f)) + "X";
        setExtraDrawable(this.aE.a(f));
        e.a("ZoomSeekBar", "updateUI, mCurrentDisplayText: " + this.ah + ", rate: " + e);
        StringBuilder sb = new StringBuilder();
        sb.append(getContext().getResources().getString(R.string.camera_description_zoom_seek_bar));
        sb.append(this.ah);
        setContentDescription(sb.toString());
        postInvalidate();
    }

    /* access modifiers changed from: protected */
    public boolean a(float f) {
        int i = 0;
        while (true) {
            float[] fArr = this.aC;
            if (i >= fArr.length) {
                return false;
            }
            if (Math.abs(f - fArr[i]) <= 1.0E-5f) {
                return true;
            }
            i++;
        }
    }

    public float a(int i) {
        if (1 == getLayoutDirection()) {
            return this.aB.get((this.aA - 1) - i).floatValue();
        }
        return this.aB.get(i).floatValue();
    }

    public float b(float f) {
        float f2;
        float c = c(f);
        int i = 1;
        while (true) {
            if (i >= this.am.size()) {
                f2 = 0.0f;
                break;
            } else if (c <= ((float) this.ap.get(i).intValue())) {
                int i2 = i - 1;
                f2 = this.am.get(i2).floatValue() + (this.an.get(i2).floatValue() * (c - ((float) this.ap.get(i2).intValue())));
                break;
            } else {
                i++;
            }
        }
        return new BigDecimal((double) f2).setScale(4, 4).floatValue();
    }

    public float getTotleAngle() {
        float f = 0.0f;
        int i = 0;
        while (i < this.an.size()) {
            int i2 = i + 1;
            f += ((this.am.get(i2).floatValue() - this.am.get(i).floatValue()) / this.an.get(i).floatValue()) * this.ao.get(i).floatValue();
            i = i2;
        }
        return f;
    }

    public float c(float f) {
        float totleAngle = f * getTotleAngle();
        float f2 = 0.0f;
        int i = 0;
        while (i < this.an.size()) {
            int i2 = i + 1;
            float floatValue = ((this.am.get(i2).floatValue() - this.am.get(i).floatValue()) / this.an.get(i).floatValue()) * this.ao.get(i).floatValue();
            if (totleAngle <= floatValue) {
                return f2 + (totleAngle / this.ao.get(i).floatValue());
            }
            totleAngle -= floatValue;
            f2 += (this.am.get(i2).floatValue() - this.am.get(i).floatValue()) / this.an.get(i).floatValue();
            i = i2;
        }
        return f2;
    }

    public float b(int i) {
        float totleAngle = getTotleAngle();
        int i2 = 0;
        float f = 0.0f;
        while (true) {
            if (i2 >= this.an.size()) {
                break;
            }
            int i3 = i2 + 1;
            int round = Math.round((this.am.get(i3).floatValue() - this.am.get(i2).floatValue()) / this.an.get(i2).floatValue());
            if (i <= round) {
                f += ((float) i) * this.ao.get(i2).floatValue();
                break;
            }
            i -= round;
            f += ((float) round) * this.ao.get(i2).floatValue();
            i2 = i3;
        }
        float f2 = f / totleAngle;
        if (Float.isNaN(f2)) {
            return 0.0f;
        }
        return f2;
    }

    public boolean a(float f, float f2) {
        return (!this.ag || Float.compare(f, 1.0f) >= 0) && f != f2;
    }

    public float d(float f) {
        return ac.c(f);
    }

    public float e(float f) {
        float f2;
        int i = 1;
        while (true) {
            f2 = 0.0f;
            if (i >= this.am.size()) {
                break;
            } else if (f <= this.am.get(i).floatValue()) {
                int i2 = i - 1;
                float floatValue = (f - this.am.get(i2).floatValue()) / (this.am.get(i).floatValue() - this.am.get(i2).floatValue());
                float intValue = (float) this.ap.get(i2).intValue();
                float intValue2 = (float) (this.ap.get(i).intValue() - this.ap.get(i2).intValue());
                if (Float.isNaN(floatValue)) {
                    floatValue = 0.0f;
                }
                f2 = intValue + (intValue2 * floatValue);
            } else {
                i++;
            }
        }
        return b(Math.round(f2));
    }

    public float getCurrentZoom() {
        return b(1 == getLayoutDirection() ? 1.0f - this.h : this.h);
    }

    public ArrayList<Integer> getIndicatorSections() {
        int size = this.am.size();
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(0);
        for (int i = 1; i < size; i++) {
            int i2 = i - 1;
            arrayList.add(i, Integer.valueOf(Math.round((this.am.get(i).floatValue() - this.am.get(i2).floatValue()) / this.an.get(i2).floatValue()) + arrayList.get(i2).intValue()));
        }
        return arrayList;
    }

    public ArrayList<Float> getZoomSections() {
        ArrayList<Float> arrayList = new ArrayList<>();
        if (Float.compare(this.ak, 1.0f) < 0) {
            arrayList.add(Float.valueOf(this.ak));
        } else if (this.ag) {
            arrayList.add(Float.valueOf(0.6f));
        }
        if (Float.compare(this.ak, 1.0f) <= 0) {
            arrayList.add(Float.valueOf(1.0f));
        }
        if (Float.compare(this.al, 4.0f) > 0) {
            arrayList.add(Float.valueOf(2.0f));
        }
        if (Float.compare(this.al, 8.0f) > 0) {
            arrayList.add(Float.valueOf(5.0f));
        }
        if (Float.compare(this.al, 10.0f) > 0) {
            arrayList.add(Float.valueOf(10.0f));
        }
        if (Float.compare(this.al, 20.0f) > 0) {
            arrayList.add(Float.valueOf(20.0f));
        }
        arrayList.add(Float.valueOf(this.al));
        return arrayList;
    }

    /* access modifiers changed from: protected */
    public ArrayList<Float> getSectionStep() {
        ArrayList<Float> arrayList = new ArrayList<>();
        this.ao = new ArrayList<>();
        float f = this.ak;
        Float valueOf = Float.valueOf(1.0f);
        int compare = Float.compare(f, 1.0f);
        Float valueOf2 = Float.valueOf(3.0f);
        Float valueOf3 = Float.valueOf(0.1f);
        if (compare < 0) {
            arrayList.add(valueOf3);
            this.ao.add(valueOf2);
        } else if (this.ag) {
            arrayList.add(valueOf3);
            this.ao.add(valueOf2);
        }
        if (Float.compare(this.ak, 1.0f) <= 0) {
            arrayList.add(valueOf3);
            this.ao.add(Float.valueOf(2.0f));
        }
        if (Float.compare(this.al, 4.0f) > 0) {
            arrayList.add(Float.valueOf(0.2f));
            this.ao.add(Float.valueOf(1.5f));
        }
        if (Float.compare(this.al, 8.0f) > 0) {
            arrayList.add(Float.valueOf(0.2f));
            this.ao.add(valueOf);
        }
        if (Float.compare(this.al, 10.0f) > 0) {
            if (Float.compare(this.al, 30.0f) > 0) {
                arrayList.add(Float.valueOf(2.0f));
                arrayList.add(Float.valueOf(2.0f));
                this.ao.add(Float.valueOf(0.8f));
                this.ao.add(Float.valueOf(0.8f));
            } else if (Float.compare(this.al, 20.0f) > 0) {
                arrayList.add(valueOf);
                arrayList.add(valueOf);
                this.ao.add(Float.valueOf(0.8f));
                this.ao.add(Float.valueOf(0.8f));
            } else {
                arrayList.add(Float.valueOf(0.5f));
                this.ao.add(Float.valueOf(0.8f));
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: protected */
    public boolean a(float f, float f2, float f3, float f4, float f5) {
        return ((float) ((int) Math.sqrt(Math.pow((double) Math.abs(f3 - f), 2.0d) + Math.pow((double) Math.abs(f4 - f2), 2.0d)))) <= f5;
    }

    /* access modifiers changed from: protected */
    public float a(int i, int i2) {
        int i3;
        float f;
        int i4;
        int i5;
        if (i == i2) {
            return this.j;
        }
        if (i < i2) {
            float f2 = this.j;
            int i6 = this.B;
            i3 = this.C;
            f = f2 - ((float) (i6 - i3));
            i4 = i - i2;
            i5 = this.D;
        } else {
            float f3 = this.j;
            int i7 = this.B;
            i3 = this.C;
            f = f3 + ((float) (i7 - i3));
            i4 = i - i2;
            i5 = this.D;
        }
        return f + ((float) (i4 * (i5 + (i3 * 2))));
    }

    /* access modifiers changed from: protected */
    public int c(int i) {
        int i2;
        int i3;
        if (i == this.J) {
            i2 = this.B * 2;
            i3 = this.D;
        } else {
            i2 = this.C * 2;
            i3 = this.D;
        }
        return i2 + i3;
    }

    /* access modifiers changed from: protected */
    public int b(float f, float f2) {
        float f3 = this.k;
        float dimensionPixelOffset = (float) this.x.getDimensionPixelOffset(R.dimen.zoom_click_hotspot_height);
        int i = this.aA - 1;
        int i2 = this.J;
        int i3 = i2 > 3 ? i2 - 3 : 0;
        int i4 = this.J;
        if (i4 + 3 < this.aA - 1) {
            i = i4 + 3;
        }
        for (int i5 = i3; i5 <= i; i5++) {
            float a2 = a(i5, this.J);
            float c = (float) c(i5);
            float f4 = c / 2.0f;
            float f5 = a2 - f4;
            float f6 = dimensionPixelOffset / 2.0f;
            float f7 = f3 - f6;
            float f8 = f4 + a2;
            float f9 = f6 + f3;
            if (i5 != this.J) {
                if (i3 == i5) {
                    f5 -= (float) this.bc;
                } else if (i == i5) {
                    f8 += (float) this.bc;
                }
            }
            RectF rectF = new RectF(f5, f7, f8, f9);
            boolean contains = rectF.contains(f, f2);
            e.a("ZoomSeekBar", "getClickPointIndex, index: " + i5 + ", hotAreaWidth: " + c + ", hotAreaHeight: " + dimensionPixelOffset + ", centerX: " + a2 + ", centerY: " + f3 + ", x: " + f + ", y: " + f2 + ", clickRectF: " + rectF.toString() + ", contains: " + contains);
            if (contains) {
                return i5;
            }
        }
        return -1;
    }

    /* access modifiers changed from: protected */
    public int f(float f) {
        int i = 0;
        int i2 = 0;
        while (i < this.aB.size() && Float.compare(this.aB.get(i).floatValue(), f) <= 0) {
            i2 = i;
            i++;
        }
        return 1 == getLayoutDirection() ? (this.aA - 1) - i2 : i2;
    }

    public void setExtraDrawable(Drawable drawable) {
        this.aj = drawable;
    }

    /* access modifiers changed from: protected */
    public void a(Canvas canvas, String str, Drawable drawable, float f, float f2) {
        int i;
        float f3 = f2;
        e.a("ZoomSeekBar", "drawFocusCircle, mbClickFocusCircle: " + this.ad + ", mFocusAnimProgress: " + this.T);
        if (this.ad) {
            float f4 = this.T;
            if (f4 < 1.0f) {
                this.T = f4 + 0.1f;
                invalidate();
            } else {
                this.T = 1.0f;
            }
        } else {
            float f5 = this.T;
            if (f5 > 0.0f) {
                this.T = f5 - 0.1f;
                invalidate();
            } else {
                this.T = 0.0f;
            }
        }
        int i2 = this.y;
        float f6 = (float) i2;
        float f7 = (float) (this.z - i2);
        float f8 = this.T;
        float f9 = f6 + (f7 * f8);
        int i3 = this.F;
        this.aq.setTextSize(((float) i3) + (((float) (this.G - i3)) * f8));
        a(canvas, f, f2, str, drawable, f9, 1.0f, 255);
        int i4 = 0;
        int i5 = this.J;
        if (i5 > 3) {
            i4 = i5 - 3;
        }
        int size = this.aB.size();
        if (this.J + 1 + 3 < this.aB.size()) {
            size = this.J + 1 + 3;
        }
        while (i4 < size) {
            if (this.af || i4 == (i = this.J)) {
                Canvas canvas2 = canvas;
            } else {
                Canvas canvas3 = canvas;
                canvas.drawCircle(a(i4, i), f3, (float) this.C, this.aw);
            }
            i4++;
        }
        if (!(this.f3880b == 0 || this.aI == null)) {
            this.aW.reset();
            this.aW.addCircle(f, f3, f9, Path.Direction.CW);
            a(this.aW);
        }
        this.aq.setTextSize((float) this.F);
    }

    /* access modifiers changed from: protected */
    public void a(Canvas canvas, float f, float f2, String str, Drawable drawable, float f3, float f4, int i) {
        canvas.drawCircle(f, f2, f3, this.as);
        canvas.drawCircle(f, f2, f3 + (this.au.getStrokeWidth() / 2.0f), this.au);
        int save = canvas.save();
        canvas.rotate((float) (-this.P), f, f2);
        if (drawable != null) {
            a(canvas, drawable, f, f2, f4, i);
        } else {
            j();
            canvas.drawText(str, f, f2 + this.U, this.aq);
        }
        canvas.restoreToCount(save);
    }

    private void a(Path path) {
        int save = this.aI.save();
        this.aI.clipPath(path);
        this.aI.drawPaint(this.ay);
        this.aI.restoreToCount(save);
    }

    /* access modifiers changed from: protected */
    public float g(float f) {
        return Float.compare(f, 5.0f) > 0 ? 1.1f : 1.8f;
    }

    /* access modifiers changed from: protected */
    public void a(Canvas canvas, Drawable drawable, float f, float f2, float f3, int i) {
        float intrinsicWidth = ((((float) drawable.getIntrinsicWidth()) * f3) * 1.0f) / 2.0f;
        float intrinsicHeight = ((((float) drawable.getIntrinsicHeight()) * f3) * 1.0f) / 2.0f;
        drawable.setBounds((int) (f - intrinsicWidth), (int) (f2 - intrinsicHeight), (int) (f + intrinsicWidth), (int) (f2 + intrinsicHeight));
        drawable.setAlpha(i);
        drawable.draw(canvas);
    }

    public void setInertial(boolean z2) {
        this.af = z2;
        invalidate();
    }

    /* compiled from: ZoomSeekBar */
    protected class a implements GestureDetector.OnGestureListener {
        public boolean onDown(MotionEvent motionEvent) {
            return false;
        }

        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            return false;
        }

        public void onShowPress(MotionEvent motionEvent) {
        }

        protected a() {
        }

        public boolean onSingleTapUp(MotionEvent motionEvent) {
            int i;
            int i2;
            e.a("ZoomSeekBar", "MyGestureListener, onSingleTapUp");
            if (y.this.aZ.isRunning() || y.this.aE.d()) {
                e.a("ZoomSeekBar", "MyGestureListener, onSingleTapUp return, spring is running");
                return false;
            }
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            if (2 == y.this.f3880b && y.this.ad) {
                y yVar = y.this;
                if (yVar.a(x, y, yVar.ab, y.this.ac, (float) y.this.y)) {
                    y.this.b(false);
                    y.this.aS = true;
                }
            } else if (y.this.f3880b == 0) {
                if (!y.this.ad) {
                    i = y.this.b(x, y);
                } else if (1 == y.this.getLayoutDirection()) {
                    if (y.this.J < 1) {
                        i2 = y.this.aB.size();
                    } else {
                        i2 = y.this.J;
                    }
                    i = i2 - 1;
                } else if (y.this.J >= y.this.aB.size() - 1) {
                    i = 0;
                } else {
                    i = y.this.J + 1;
                }
                e.a("ZoomSeekBar", "onSingleTapUp, targetIndex: " + i);
                if (!(y.this.n == null || -1 == i)) {
                    float a2 = y.this.a(i);
                    y.this.n.a(a2);
                    y.this.a(i, a2);
                    y yVar2 = y.this;
                    yVar2.aS = true;
                    yVar2.invalidate();
                }
            }
            return false;
        }

        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (y.this.aE.b() && motionEvent != null) {
                if (y.this.f3880b == 0) {
                    if (f2 >= 0.0f || ((double) (Math.abs(f2) / Math.abs(f))) < y.this.h(30.0f)) {
                        y.this.c();
                        y.this.aS = true;
                    }
                } else if (2 == y.this.f3880b && f2 < 0.0f && Math.abs(f2) > 10.0f && ((double) (Math.abs(f) / Math.abs(f2))) < y.this.h(15.0f) && motionEvent.getY() < ((float) y.this.getHeight()) * 1.0f) {
                    y.this.b(false);
                    y.this.aS = true;
                }
            }
            return false;
        }

        public void onLongPress(MotionEvent motionEvent) {
            if (y.this.f3880b == 0 && y.this.ad) {
                e.a("ZoomSeekBar", "MyGestureListener, onLongPress to performExpand");
                y.this.c();
                y.this.aS = true;
            }
        }
    }

    /* access modifiers changed from: private */
    public double h(float f) {
        return Math.tan((((double) f) * 3.141592653589793d) / 180.0d);
    }

    public String getCurrentDisplayText() {
        return this.ah;
    }

    private void l() {
        if (this.aZ == null) {
            this.aZ = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
            this.aZ.setDuration((long) this.aY);
            this.aZ.setInterpolator(new DecelerateInterpolator());
            this.aZ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float unused = y.this.aX = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    y.this.invalidate();
                }
            });
            this.aZ.addListener(new Animator.AnimatorListener() {
                public void onAnimationCancel(Animator animator) {
                }

                public void onAnimationRepeat(Animator animator) {
                }

                public void onAnimationStart(Animator animator) {
                    y yVar = y.this;
                    StringBuilder sb = new StringBuilder();
                    DecimalFormat decimalFormat = y.this.aJ;
                    y yVar2 = y.this;
                    sb.append(decimalFormat.format((double) yVar2.d(yVar2.L)));
                    sb.append("X");
                    yVar.ah = sb.toString();
                }

                public void onAnimationEnd(Animator animator) {
                    y yVar = y.this;
                    yVar.setCenterPointIndex(yVar.K);
                    y yVar2 = y.this;
                    yVar2.setExtraDrawable(yVar2.aE.a(y.this.L));
                    y yVar3 = y.this;
                    yVar3.b(yVar3.M, false);
                }
            });
        }
    }

    public float[] getUltraWideZoomDotViewLocation() {
        ArrayList<Float> arrayList;
        if (3 < this.J || (arrayList = this.aB) == null || !arrayList.contains(Float.valueOf(0.6f))) {
            return null;
        }
        return new float[]{a(1 == getLayoutDirection() ? this.aA - 1 : 0, this.J), this.k - ((float) this.B)};
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.be = new int[2];
        getLocationOnScreen(this.be);
    }

    public int getFocusCircleRadius() {
        return this.B;
    }

    public boolean b(MotionEvent motionEvent) {
        int[] iArr;
        if (getParent() == null || getVisibility() != 0 || (iArr = this.be) == null || 2 > iArr.length || motionEvent.getRawY() <= ((float) this.be[1]) || Math.abs(this.k - (motionEvent.getRawY() - ((float) this.be[1]))) > (((float) this.bd) * 1.0f) / 2.0f) {
            return false;
        }
        return true;
    }
}
