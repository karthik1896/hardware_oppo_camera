package com.oppo.camera.ui.control;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BlendMode;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Property;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.PathInterpolator;
import com.oppo.camera.R;
import com.oppo.camera.aps.config.CameraConfig;
import com.oppo.camera.aps.config.ConfigDataBase;
import com.oppo.camera.e;

public class MainShutterButton extends ShutterButton {
    private static final Interpolator k = new LinearInterpolator();
    private static final Interpolator l = new AccelerateDecelerateInterpolator();
    private static final int m = Color.parseColor("#FFEA3447");
    private static final int n = Color.parseColor("#E3E3E3");
    private static final int o = Color.parseColor("#4D4D4D");
    /* access modifiers changed from: private */
    public int A = 0;
    private int B = 0;
    /* access modifiers changed from: private */
    public int C = 0;
    private int D = 0;
    /* access modifiers changed from: private */
    public float E = 0.0f;
    private int F = 0;
    private int G = 0;
    private int H = 0;
    private int I = 0;
    private int J = 0;
    private int K = 0;
    private int L = 0;
    private int M = 0;
    private int N = 0;
    private int O = 0;
    private int P = 0;
    private int Q = 0;
    private int R = 0;
    private int S = 0;
    private int T = 0;
    private int U = 0;
    private int V = 0;
    private int W = 0;
    private Bitmap aA = null;
    private Bitmap aB = null;
    private Bitmap aC = null;
    private Bitmap aD = null;
    private Bitmap aE = null;
    private RectF aF = null;
    private RectF aG = null;
    /* access modifiers changed from: private */
    public RectF aH = null;
    private RectF aI = null;
    private RectF aJ = null;
    private RectF aK = null;
    /* access modifiers changed from: private */
    public Paint aL = null;
    private Paint aM = null;
    private Paint aN = null;
    private Paint aO = null;
    /* access modifiers changed from: private */
    public Paint aP = null;
    private Paint aQ = null;
    private Paint aR = null;
    private Paint aS = null;
    private Paint aT = null;
    private Property<MainShutterButton, Float> aU = null;
    private Property<MainShutterButton, Float> aV = null;
    private Property<MainShutterButton, Integer> aW = null;
    private ObjectAnimator aX = null;
    /* access modifiers changed from: private */
    public ObjectAnimator aY = null;
    /* access modifiers changed from: private */
    public ObjectAnimator aZ = null;
    private int aa = 0;
    /* access modifiers changed from: private */
    public int ab = 255;
    private int ac = 6;
    private int ad = 12;
    private int ae = 6;
    private int af = 9;
    private int ag = 12;
    private int ah = 4;
    private int ai = 6;
    private int aj = 0;
    private int ak = 24;
    /* access modifiers changed from: private */
    public float al = 0.0f;
    private float am = 0.0f;
    private float an = 0.0f;
    private float ao = 0.0f;
    private float ap = 0.0f;
    /* access modifiers changed from: private */
    public float aq = 0.0f;
    private String ar = null;
    /* access modifiers changed from: private */
    public String as = null;
    private boolean at = false;
    private boolean au = true;
    private boolean av = true;
    private boolean aw = false;
    private ObjectAnimator ax = null;
    private ObjectAnimator ay = null;
    private Canvas az = null;
    private ValueAnimator ba = null;
    private ValueAnimator bb = null;
    private ValueAnimator bc = null;
    private ValueAnimator bd = null;
    private ValueAnimator be = null;
    private ValueAnimator bf = null;
    private ValueAnimator bg = null;
    private ValueAnimator bh = null;
    private ValueAnimator bi = null;
    private ValueAnimator bj = null;
    private ValueAnimator.AnimatorUpdateListener bk = null;
    private Path bl = new Path();
    /* access modifiers changed from: private */
    public int p = 1;
    private int q = 0;
    /* access modifiers changed from: private */
    public int r = 0;
    private int s = 0;
    private int t = 0;
    private int u = 0;
    /* access modifiers changed from: private */
    public int v = 0;
    /* access modifiers changed from: private */
    public int w = 0;
    private int x = 0;
    private int y = 0;
    private int z = 0;

    private float a(float f, float f2, float f3, boolean z2) {
        return z2 ? f - (((f2 - 1.0f) / 2.0f) * f3) : f + (((f2 - 1.0f) / 2.0f) * f3);
    }

    private void b(Canvas canvas, Bitmap bitmap) {
    }

    public MainShutterButton(Context context) {
        super(context);
    }

    public MainShutterButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet, 0);
    }

    public MainShutterButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void a(Context context, AttributeSet attributeSet, int i) {
        setButtonTypeAndInvalidate(new c(1, "button_color_inside_none", "button_shape_ring_none"));
        b(context, attributeSet, i);
    }

    private void b(Context context, AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.MainShutterButton, i, 0);
        Resources resources = context.getResources();
        try {
            this.q = obtainStyledAttributes.getDimensionPixelSize(18, resources.getDimensionPixelSize(R.dimen.shutter_button_big_circle_radius));
            this.r = obtainStyledAttributes.getDimensionPixelSize(14, resources.getDimensionPixelSize(R.dimen.shutter_button_small_circle_radius));
            this.t = obtainStyledAttributes.getDimensionPixelSize(16, resources.getDimensionPixelSize(R.dimen.shutter_button_inside_rect_length));
            this.u = obtainStyledAttributes.getDimensionPixelSize(15, resources.getDimensionPixelSize(R.dimen.shutter_button_inside_rect_corner_radius));
            this.x = obtainStyledAttributes.getInt(0, resources.getInteger(R.integer.main_btn_default_angleAnimationDurationMillis));
            this.y = obtainStyledAttributes.getInt(22, resources.getInteger(R.integer.main_btn_default_sweepAnimationDuration));
            this.z = obtainStyledAttributes.getInt(17, resources.getInteger(R.integer.main_btn_default_miniSweepAngle));
            this.ap = (float) (360 - (this.z * 2));
            this.D = obtainStyledAttributes.getDimensionPixelSize(4, resources.getDimensionPixelSize(R.dimen.shutter_button_big_circle_radius_scaled));
        } catch (Exception e) {
            e.printStackTrace();
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
        obtainStyledAttributes.recycle();
        this.F = getResources().getDimensionPixelOffset(R.dimen.camera_button_path_width);
        this.G = getResources().getDimensionPixelOffset(R.dimen.step_next_width);
        this.H = getResources().getDimensionPixelOffset(R.dimen.step_next_height);
        this.J = getResources().getDimensionPixelOffset(R.dimen.step_next_top);
        this.I = getResources().getDimensionPixelOffset(R.dimen.step_next_left);
        this.L = this.J + this.H;
        this.K = this.I + this.G;
        this.M = getResources().getDimensionPixelOffset(R.dimen.step_complete_width);
        this.N = getResources().getDimensionPixelOffset(R.dimen.step_complete_height);
        this.O = getResources().getDimensionPixelOffset(R.dimen.step_complete_left);
        this.P = getResources().getDimensionPixelOffset(R.dimen.step_complete_top);
        this.Q = getResources().getDimensionPixelOffset(R.dimen.step_complete_hook_x1);
        this.R = getResources().getDimensionPixelOffset(R.dimen.step_complete_hook_y1);
        this.S = getResources().getDimensionPixelOffset(R.dimen.step_complete_hook_x2);
        this.T = getResources().getDimensionPixelOffset(R.dimen.step_complete_hook_y2);
        this.U = getResources().getDimensionPixelOffset(R.dimen.step_complete_hook_x3);
        this.V = getResources().getDimensionPixelOffset(R.dimen.step_complete_hook_y3);
        this.ah = getResources().getDimensionPixelOffset(R.dimen.double_exposure_shutter_shadow_offset);
        this.E = (float) (this.q - this.r);
        this.aL = new Paint();
        this.aL.setAntiAlias(true);
        this.aL.setStyle(Paint.Style.STROKE);
        this.aL.setStrokeWidth(this.E);
        this.aM = new Paint();
        this.aM.setAntiAlias(true);
        this.aM.setStyle(Paint.Style.FILL);
        this.aM.setAlpha(128);
        this.aN = new Paint();
        this.aN.setAntiAlias(true);
        this.aN.setStyle(Paint.Style.FILL);
        this.aN.setColor(m);
        this.aO = new Paint();
        this.aO.setAntiAlias(true);
        this.aO.setStyle(Paint.Style.FILL);
        this.aO.setAlpha(51);
        this.aP = new Paint();
        this.aP.setAntiAlias(true);
        this.aP.setStyle(Paint.Style.STROKE);
        this.aP.setStrokeWidth(this.E);
        this.aQ = new Paint();
        this.aQ.setAntiAlias(true);
        this.aQ.setStyle(Paint.Style.FILL);
        this.aS = new Paint();
        this.aS.setAntiAlias(true);
        this.aS.setColor(-1);
        this.aS.setStyle(Paint.Style.STROKE);
        this.aS.setStrokeWidth((float) this.F);
        this.aS.setStrokeCap(Paint.Cap.SQUARE);
        this.aS.setStrokeJoin(Paint.Join.ROUND);
        this.aT = new Paint(this.aS);
        i();
        n();
    }

    private Bitmap a(Bitmap bitmap, int i) {
        Drawable drawable = getContext().getDrawable(i);
        drawable.setState(getDrawableState());
        if (bitmap == null) {
            bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        }
        Canvas canvas = this.az;
        if (canvas == null) {
            this.az = new Canvas(bitmap);
        } else {
            canvas.setBitmap(bitmap);
        }
        drawable.setBounds(0, 0, this.az.getWidth(), this.az.getHeight());
        this.az.drawColor(0, BlendMode.CLEAR);
        drawable.draw(this.az);
        return bitmap;
    }

    public void setInverseColor(boolean z2) {
        this.j = z2;
        i();
        refreshDrawableState();
        u();
        post(new Runnable(z2) {
            private final /* synthetic */ boolean f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                MainShutterButton.this.a(this.f$1);
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(boolean z2) {
        if (z2) {
            setBackgroundColor(0);
        } else if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_UI_SHUTTER_BUTTON_TYPE_LOW_LIGHT)) {
            setBackgroundResource(R.drawable.button_shutter_low_shadow_background);
        }
        invalidate();
    }

    private void i() {
        int i;
        if (this.j) {
            i = o;
        } else {
            i = (this.aw || !CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_UI_SHUTTER_BUTTON_TYPE_LOW_LIGHT)) ? -1 : n;
        }
        this.aa = i;
        Paint paint = this.aL;
        if (paint != null) {
            paint.setColor(this.aa);
        }
        Paint paint2 = this.aM;
        if (paint2 != null) {
            paint2.setColor(this.aa);
        }
        Paint paint3 = this.aO;
        if (paint3 != null) {
            paint3.setColor(this.aa);
        }
        Paint paint4 = this.aP;
        if (paint4 != null) {
            paint4.setColor(this.aa);
        }
        Paint paint5 = this.aQ;
        if (paint5 != null) {
            paint5.setColor(this.aa);
        }
        Paint paint6 = this.aS;
        if (paint6 != null) {
            paint6.setColor(this.aa);
        }
    }

    public void setPressed(boolean z2) {
        if (this.bc == null || this.bb == null) {
            e.a("MainShutterButton", "setPressed, return because Animator is null");
            return;
        }
        boolean z3 = z2 != isPressed();
        super.setPressed(z2);
        if (z3) {
            r();
            if (isPressed()) {
                float f = this.al;
                int i = this.q;
                if (f <= ((float) i)) {
                    f = (float) i;
                }
                this.bb.setFloatValues(new float[]{f, (float) this.D});
                ValueAnimator valueAnimator = this.bc;
                int i2 = this.D;
                valueAnimator.setDuration((long) (((((float) i2) - f) * 100.0f) / ((float) (i2 - this.q))));
                this.bb.start();
            } else {
                float f2 = this.al;
                int i3 = this.q;
                if (f2 <= ((float) i3)) {
                    f2 = (float) i3;
                }
                this.bc.setFloatValues(new float[]{f2, (float) this.q});
                ValueAnimator valueAnimator2 = this.bc;
                int i4 = this.q;
                valueAnimator2.setDuration((long) (((f2 - ((float) i4)) * 100.0f) / ((float) (this.D - i4))));
                this.bc.start();
            }
            invalidate();
        }
    }

    private void j() {
        if (!l()) {
            this.at = true;
            ObjectAnimator objectAnimator = this.ay;
            if (objectAnimator != null) {
                objectAnimator.start();
            }
            ObjectAnimator objectAnimator2 = this.ax;
            if (objectAnimator2 != null) {
                objectAnimator2.start();
            }
            invalidate();
        }
    }

    private void k() {
        if (l()) {
            this.at = false;
            ObjectAnimator objectAnimator = this.ay;
            if (objectAnimator != null) {
                objectAnimator.cancel();
            }
            ObjectAnimator objectAnimator2 = this.ax;
            if (objectAnimator2 != null) {
                objectAnimator2.cancel();
            }
            invalidate();
        }
    }

    private boolean l() {
        return this.at;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:155:0x091f  */
    /* JADX WARNING: Removed duplicated region for block: B:156:0x0927  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x02dd  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x02e5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onDraw(android.graphics.Canvas r20) {
        /*
            r19 = this;
            r0 = r19
            r7 = r20
            int r1 = r0.f3804a
            int r2 = r0.c
            r8 = 360(0x168, float:5.04E-43)
            if (r1 == r2) goto L_0x0037
            long r1 = android.view.animation.AnimationUtils.currentAnimationTimeMillis()
            long r3 = r0.g
            int r3 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r3 >= 0) goto L_0x0033
            long r3 = r0.f
            long r1 = r1 - r3
            int r1 = (int) r1
            int r2 = r0.f3805b
            boolean r3 = r0.d
            if (r3 == 0) goto L_0x0021
            goto L_0x0022
        L_0x0021:
            int r1 = -r1
        L_0x0022:
            int r1 = r1 * 270
            int r1 = r1 / 1000
            int r2 = r2 + r1
            if (r2 < 0) goto L_0x002b
            int r2 = r2 % r8
            goto L_0x002d
        L_0x002b:
            int r2 = r2 % r8
            int r2 = r2 + r8
        L_0x002d:
            r0.f3804a = r2
            r19.invalidate()
            goto L_0x0037
        L_0x0033:
            int r1 = r0.c
            r0.f3804a = r1
        L_0x0037:
            android.graphics.RectF r1 = r0.aF
            r9 = 2
            if (r1 != 0) goto L_0x0067
            android.graphics.RectF r1 = new android.graphics.RectF
            int r2 = r19.getWidth()
            int r2 = r2 / r9
            int r3 = r0.r
            int r2 = r2 - r3
            float r2 = (float) r2
            int r3 = r19.getHeight()
            int r3 = r3 / r9
            int r4 = r0.r
            int r3 = r3 - r4
            float r3 = (float) r3
            int r4 = r19.getWidth()
            int r4 = r4 / r9
            int r5 = r0.r
            int r4 = r4 + r5
            float r4 = (float) r4
            int r5 = r19.getHeight()
            int r5 = r5 / r9
            int r6 = r0.r
            int r5 = r5 + r6
            float r5 = (float) r5
            r1.<init>(r2, r3, r4, r5)
            r0.aF = r1
        L_0x0067:
            android.graphics.RectF r1 = r0.aG
            if (r1 != 0) goto L_0x0096
            android.graphics.RectF r1 = new android.graphics.RectF
            int r2 = r19.getWidth()
            int r2 = r2 / r9
            int r3 = r0.s
            int r2 = r2 - r3
            float r2 = (float) r2
            int r3 = r19.getHeight()
            int r3 = r3 / r9
            int r4 = r0.s
            int r3 = r3 - r4
            float r3 = (float) r3
            int r4 = r19.getWidth()
            int r4 = r4 / r9
            int r5 = r0.s
            int r4 = r4 + r5
            float r4 = (float) r4
            int r5 = r19.getHeight()
            int r5 = r5 / r9
            int r6 = r0.s
            int r5 = r5 + r6
            float r5 = (float) r5
            r1.<init>(r2, r3, r4, r5)
            r0.aG = r1
        L_0x0096:
            android.graphics.RectF r1 = r0.aJ
            if (r1 != 0) goto L_0x00c9
            android.graphics.RectF r1 = new android.graphics.RectF
            int r2 = r19.getWidth()
            int r2 = r2 / r9
            int r3 = r0.t
            int r3 = r3 / r9
            int r2 = r2 - r3
            float r2 = (float) r2
            int r3 = r19.getHeight()
            int r3 = r3 / r9
            int r4 = r0.t
            int r4 = r4 / r9
            int r3 = r3 - r4
            float r3 = (float) r3
            int r4 = r19.getWidth()
            int r4 = r4 / r9
            int r5 = r0.t
            int r5 = r5 / r9
            int r4 = r4 + r5
            float r4 = (float) r4
            int r5 = r19.getHeight()
            int r5 = r5 / r9
            int r6 = r0.t
            int r6 = r6 / r9
            int r5 = r5 + r6
            float r5 = (float) r5
            r1.<init>(r2, r3, r4, r5)
            r0.aJ = r1
        L_0x00c9:
            android.graphics.RectF r1 = r0.aH
            r2 = 1073741824(0x40000000, float:2.0)
            if (r1 != 0) goto L_0x010a
            android.graphics.RectF r1 = new android.graphics.RectF
            int r3 = r19.getWidth()
            int r3 = r3 / r9
            int r4 = r0.q
            int r3 = r3 - r4
            float r3 = (float) r3
            float r4 = r0.E
            float r4 = r4 / r2
            float r3 = r3 + r4
            int r4 = r19.getHeight()
            int r4 = r4 / r9
            int r5 = r0.q
            int r4 = r4 - r5
            float r4 = (float) r4
            float r5 = r0.E
            float r5 = r5 / r2
            float r4 = r4 + r5
            int r5 = r19.getWidth()
            int r5 = r5 / r9
            int r6 = r0.q
            int r5 = r5 + r6
            float r5 = (float) r5
            float r6 = r0.E
            float r6 = r6 / r2
            float r5 = r5 - r6
            int r6 = r19.getHeight()
            int r6 = r6 / r9
            int r10 = r0.q
            int r6 = r6 + r10
            float r6 = (float) r6
            float r10 = r0.E
            float r10 = r10 / r2
            float r6 = r6 - r10
            r1.<init>(r3, r4, r5, r6)
            r0.aH = r1
        L_0x010a:
            android.graphics.RectF r1 = r0.aI
            if (r1 != 0) goto L_0x013b
            float r1 = r0.E
            int r3 = r0.ah
            float r3 = (float) r3
            float r1 = r1 - r3
            int r1 = (int) r1
            android.graphics.RectF r3 = new android.graphics.RectF
            android.graphics.RectF r4 = r0.aH
            r3.<init>(r4)
            r0.aI = r3
            android.graphics.RectF r3 = r0.aI
            float r4 = r3.left
            float r1 = (float) r1
            float r4 = r4 - r1
            r3.left = r4
            android.graphics.RectF r3 = r0.aI
            float r4 = r3.right
            float r4 = r4 + r1
            r3.right = r4
            android.graphics.RectF r3 = r0.aI
            float r4 = r3.top
            float r4 = r4 - r1
            r3.top = r4
            android.graphics.RectF r3 = r0.aI
            float r4 = r3.bottom
            float r4 = r4 + r1
            r3.bottom = r4
        L_0x013b:
            android.graphics.RectF r1 = r0.aK
            r3 = 0
            if (r1 != 0) goto L_0x0147
            android.graphics.RectF r1 = new android.graphics.RectF
            r1.<init>(r3, r3, r3, r3)
            r0.aK = r1
        L_0x0147:
            int r1 = r0.p
            r10 = 1
            if (r10 != r1) goto L_0x0151
            r0.a((android.graphics.Canvas) r7, (boolean) r10)
            goto L_0x0c6d
        L_0x0151:
            r11 = 255(0xff, float:3.57E-43)
            if (r9 != r1) goto L_0x0188
            r0.a((android.graphics.Canvas) r7, (boolean) r10)
            int r1 = r0.aj
            if (r1 != 0) goto L_0x0166
            android.graphics.Paint r1 = r0.aM
            r1.setAlpha(r11)
            android.graphics.Paint r1 = r0.aM
            r0.aR = r1
            goto L_0x017b
        L_0x0166:
            if (r10 != r1) goto L_0x0172
            android.graphics.Paint r1 = r0.aN
            r1.setAlpha(r11)
            android.graphics.Paint r1 = r0.aN
            r0.aR = r1
            goto L_0x017b
        L_0x0172:
            android.graphics.Paint r1 = r0.aM
            r1.setAlpha(r11)
            android.graphics.Paint r1 = r0.aM
            r0.aR = r1
        L_0x017b:
            android.graphics.RectF r1 = r0.aJ
            int r2 = r0.u
            float r3 = (float) r2
            float r2 = (float) r2
            android.graphics.Paint r4 = r0.aR
            r7.drawRoundRect(r1, r3, r2, r4)
            goto L_0x0c6d
        L_0x0188:
            r4 = 128(0x80, float:1.794E-43)
            r5 = 3
            r12 = 0
            if (r5 != r1) goto L_0x01e8
            android.graphics.Paint r1 = r0.aP
            r1.setAlpha(r4)
            r0.a((android.graphics.Canvas) r7, (boolean) r12)
            android.graphics.Paint r1 = r0.aL
            float r2 = r0.E
            r1.setStrokeWidth(r2)
            android.graphics.RectF r2 = r0.aH
            r3 = -1028390912(0xffffffffc2b40000, float:-90.0)
            int r1 = r0.A
            float r4 = (float) r1
            r5 = 0
            android.graphics.Paint r6 = r0.aL
            r1 = r20
            r1.drawArc(r2, r3, r4, r5, r6)
            int r1 = r0.aj
            if (r1 != 0) goto L_0x01ba
            android.graphics.Paint r1 = r0.aM
            r1.setAlpha(r11)
            android.graphics.Paint r1 = r0.aM
            r0.aR = r1
            goto L_0x01db
        L_0x01ba:
            if (r10 != r1) goto L_0x01c6
            android.graphics.Paint r1 = r0.aN
            r1.setAlpha(r11)
            android.graphics.Paint r1 = r0.aN
            r0.aR = r1
            goto L_0x01db
        L_0x01c6:
            if (r9 != r1) goto L_0x01d2
            android.graphics.Paint r1 = r0.aM
            r1.setAlpha(r12)
            android.graphics.Paint r1 = r0.aM
            r0.aR = r1
            goto L_0x01db
        L_0x01d2:
            android.graphics.Paint r1 = r0.aM
            r1.setAlpha(r11)
            android.graphics.Paint r1 = r0.aM
            r0.aR = r1
        L_0x01db:
            android.graphics.RectF r1 = r0.aJ
            int r2 = r0.u
            float r3 = (float) r2
            float r2 = (float) r2
            android.graphics.Paint r4 = r0.aR
            r7.drawRoundRect(r1, r3, r2, r4)
            goto L_0x0c6d
        L_0x01e8:
            r6 = 4
            if (r6 != r1) goto L_0x022f
            android.graphics.Paint r1 = r0.aP
            r1.setAlpha(r4)
            r0.a((android.graphics.Canvas) r7, (boolean) r12)
            float r1 = r0.an
            float r2 = r0.am
            float r1 = r1 - r2
            float r2 = r0.ao
            boolean r3 = r0.au
            if (r3 == 0) goto L_0x020a
            int r3 = r0.z
            float r3 = (float) r3
            float r3 = r3 + r2
            float r4 = r0.ap
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 != 0) goto L_0x021a
            float r3 = r3 - r4
            goto L_0x021a
        L_0x020a:
            float r1 = r1 + r2
            r3 = 1135869952(0x43b40000, float:360.0)
            float r3 = r3 - r2
            int r4 = r0.z
            float r4 = (float) r4
            float r3 = r3 - r4
            float r4 = r0.ap
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 != 0) goto L_0x021a
            float r1 = r1 - r4
            float r3 = r3 + r4
        L_0x021a:
            r4 = r3
            r3 = r1
            android.graphics.Paint r1 = r0.aL
            float r2 = r0.E
            r1.setStrokeWidth(r2)
            android.graphics.RectF r2 = r0.aH
            r5 = 0
            android.graphics.Paint r6 = r0.aL
            r1 = r20
            r1.drawArc(r2, r3, r4, r5, r6)
            goto L_0x0c6d
        L_0x022f:
            r6 = 5
            r13 = 8
            r14 = 1090519040(0x41000000, float:8.0)
            if (r6 != r1) goto L_0x02ee
            android.graphics.Paint r1 = r0.aP
            r1.setAlpha(r11)
            android.graphics.RectF r1 = r0.aH
            int r2 = r0.q
            float r3 = (float) r2
            float r2 = (float) r2
            android.graphics.Paint r4 = r0.aP
            r7.drawRoundRect(r1, r3, r2, r4)
            java.lang.String r1 = r0.ar
            java.lang.String r2 = "button_color_inside_none"
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L_0x0251
            return
        L_0x0251:
            java.lang.String r1 = r0.as
            java.lang.String r2 = "button_shape_ring_none"
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L_0x025e
            int r1 = r0.r
            goto L_0x0260
        L_0x025e:
            int r1 = r0.s
        L_0x0260:
            int r2 = r0.t
            int r2 = r2 / r9
            int r2 = r1 - r2
            float r2 = (float) r2
            int r3 = r0.u
            int r3 = r1 - r3
            float r3 = (float) r3
            float r3 = r3 / r14
            float r2 = r2 / r14
            int r4 = r19.getWidth()
            int r4 = r4 / r9
            int r4 = r4 - r1
            float r4 = (float) r4
            int r5 = r0.v
            float r5 = (float) r5
            float r5 = r5 * r2
            float r4 = r4 + r5
            int r5 = r19.getHeight()
            int r5 = r5 / r9
            int r5 = r5 - r1
            float r5 = (float) r5
            int r6 = r0.v
            float r6 = (float) r6
            float r6 = r6 * r2
            float r5 = r5 + r6
            int r6 = r19.getWidth()
            int r6 = r6 / r9
            int r6 = r6 + r1
            float r6 = (float) r6
            int r8 = r0.v
            float r8 = (float) r8
            float r8 = r8 * r2
            float r6 = r6 - r8
            int r8 = r19.getHeight()
            int r8 = r8 / r9
            int r8 = r8 + r1
            float r8 = (float) r8
            int r14 = r0.v
            float r15 = (float) r14
            float r15 = r15 * r2
            float r8 = r8 - r15
            float r1 = (float) r1
            float r2 = (float) r14
            float r2 = r2 * r3
            float r1 = r1 - r2
            android.graphics.RectF r2 = r0.aK
            r2.set(r4, r5, r6, r8)
            java.lang.String r2 = r0.ar
            java.lang.String r3 = "button_color_inside_grey"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x02bc
            android.graphics.Paint r2 = r0.aO
            r3 = 51
            r2.setAlpha(r3)
            android.graphics.Paint r2 = r0.aO
            r0.aR = r2
            goto L_0x02d1
        L_0x02bc:
            java.lang.String r2 = r0.ar
            java.lang.String r3 = "button_color_inside_red"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x02d1
            android.graphics.Paint r2 = r0.aN
            r2.setAlpha(r11)
            android.graphics.Paint r2 = r0.aN
            r0.aR = r2
            r2 = r10
            goto L_0x02d2
        L_0x02d1:
            r2 = r12
        L_0x02d2:
            android.graphics.RectF r3 = r0.aK
            android.graphics.Paint r4 = r0.aR
            r7.drawRoundRect(r3, r1, r1, r4)
            int r1 = r0.v
            if (r1 >= r13) goto L_0x02e5
            int r1 = r1 + r10
            r0.v = r1
            r19.invalidate()
            goto L_0x0c6d
        L_0x02e5:
            r0.v = r12
            java.lang.String r1 = "button_color_inside_none"
            r0.a((int) r9, (java.lang.String) r1, (int) r2)
            goto L_0x0c6d
        L_0x02ee:
            r6 = 17
            r15 = 1056964608(0x3f000000, float:0.5)
            r16 = 1069547520(0x3fc00000, float:1.5)
            r17 = 1132396544(0x437f0000, float:255.0)
            if (r1 != r6) goto L_0x044d
            android.graphics.Paint r1 = r0.aP
            r1.setAlpha(r11)
            r0.a((android.graphics.Canvas) r7, (boolean) r10)
            boolean r1 = r0.aw
            if (r1 == 0) goto L_0x0320
            android.graphics.Paint r1 = r0.aS
            android.content.res.Resources r4 = r19.getResources()
            r5 = 2131166484(0x7f070514, float:1.7947215E38)
            float r4 = r4.getDimension(r5)
            android.content.res.Resources r5 = r19.getResources()
            r6 = 2131099985(0x7f060151, float:1.7812339E38)
            int r5 = r5.getColor(r6)
            r1.setShadowLayer(r4, r3, r3, r5)
            goto L_0x0330
        L_0x0320:
            android.graphics.Paint r1 = r0.aS
            android.content.res.Resources r4 = r19.getResources()
            r5 = 2131100603(0x7f0603bb, float:1.7813592E38)
            int r4 = r4.getColor(r5)
            r1.setShadowLayer(r3, r3, r3, r4)
        L_0x0330:
            r20.save()
            int r1 = r0.f3804a
            int r1 = -r1
            float r1 = (float) r1
            int r3 = r19.getWidth()
            int r3 = r3 / r9
            float r3 = (float) r3
            int r4 = r19.getHeight()
            int r4 = r4 / r9
            float r4 = (float) r4
            r7.rotate(r1, r3, r4)
            int r1 = r0.u
            int r1 = r0.r
            int r1 = r19.getWidth()
            float r1 = (float) r1
            float r1 = r1 / r2
            int r3 = r0.t
            float r3 = (float) r3
            float r3 = r3 / r2
            float r1 = r1 - r3
            int r3 = r19.getHeight()
            float r3 = (float) r3
            float r3 = r3 / r2
            int r4 = r0.t
            float r4 = (float) r4
            float r4 = r4 / r2
            float r3 = r3 - r4
            int r4 = r19.getWidth()
            float r4 = (float) r4
            float r4 = r4 / r2
            int r5 = r0.t
            float r5 = (float) r5
            float r5 = r5 / r2
            float r4 = r4 + r5
            int r5 = r19.getWidth()
            float r5 = (float) r5
            float r5 = r5 / r2
            int r6 = r0.t
            float r6 = (float) r6
            float r6 = r6 / r2
            float r5 = r5 + r6
            int r6 = r19.getWidth()
            float r6 = (float) r6
            float r6 = r6 / r2
            int r8 = r0.r
            float r8 = (float) r8
            float r6 = r6 - r8
            int r8 = r19.getHeight()
            float r8 = (float) r8
            float r8 = r8 / r2
            int r9 = r0.r
            float r9 = (float) r9
            float r8 = r8 - r9
            int r9 = r19.getWidth()
            float r9 = (float) r9
            float r9 = r9 / r2
            int r13 = r0.r
            float r13 = (float) r13
            float r9 = r9 + r13
            int r13 = r19.getWidth()
            float r13 = (float) r13
            float r13 = r13 / r2
            int r2 = r0.r
            float r2 = (float) r2
            float r13 = r13 + r2
            r2 = -1015087104(0xffffffffc37f0000, float:-255.0)
            float r14 = r0.aq
            float r2 = r2 * r14
            float r2 = r2 + r17
            float r6 = r6 - r1
            float r6 = r6 * r14
            float r1 = r1 + r6
            float r8 = r8 - r3
            float r8 = r8 * r14
            float r3 = r3 + r8
            float r9 = r9 - r4
            float r9 = r9 * r14
            float r4 = r4 + r9
            float r13 = r13 - r5
            float r13 = r13 * r14
            float r5 = r5 + r13
            android.graphics.RectF r6 = r0.aK
            r6.set(r1, r3, r4, r5)
            android.graphics.Paint r1 = r0.aN
            r0.aR = r1
            android.graphics.Paint r1 = r0.aR
            int r2 = (int) r2
            r1.setAlpha(r2)
            int r1 = r0.Q
            float r2 = (float) r1
            int r3 = r0.R
            float r3 = (float) r3
            int r4 = r0.S
            float r5 = (float) r4
            int r6 = r0.T
            float r6 = (float) r6
            int r8 = r0.U
            float r9 = (float) r8
            int r13 = r0.V
            float r13 = (float) r13
            int r4 = r4 - r1
            float r4 = (float) r4
            int r8 = r8 - r1
            float r1 = (float) r8
            float r4 = r4 / r1
            float r1 = r0.aq
            float r1 = r1 * r15
            float r1 = r16 - r1
            float r8 = r9 - r2
            float r14 = r6 - r13
            float r2 = r0.a(r2, r1, r8, r10)
            float r3 = r0.a(r3, r1, r14, r12)
            float r5 = r0.a(r5, r1, r8, r10)
            float r6 = r0.a(r6, r1, r14, r12)
            float r8 = r0.a(r9, r1, r8, r12)
            float r9 = r0.a(r13, r1, r14, r10)
            android.graphics.Path r10 = r0.bl
            r10.rewind()
            float r10 = r0.aq
            int r12 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r12 >= 0) goto L_0x0417
            float r5 = r5 - r2
            float r8 = r10 / r4
            float r5 = r5 * r8
            float r5 = r5 + r2
            float r6 = r6 - r3
            float r10 = r10 / r4
            float r6 = r6 * r10
            float r6 = r6 + r3
            android.graphics.Path r4 = r0.bl
            r4.moveTo(r2, r3)
            android.graphics.Path r2 = r0.bl
            r2.lineTo(r5, r6)
            goto L_0x0433
        L_0x0417:
            float r8 = r8 - r2
            float r8 = r8 * r10
            float r8 = r8 + r2
            float r9 = r6 - r9
            float r10 = r10 - r4
            r12 = 1065353216(0x3f800000, float:1.0)
            float r12 = r12 - r4
            float r10 = r10 / r12
            float r9 = r9 * r10
            float r4 = r6 - r9
            android.graphics.Path r9 = r0.bl
            r9.moveTo(r2, r3)
            android.graphics.Path r2 = r0.bl
            r2.lineTo(r5, r6)
            android.graphics.Path r2 = r0.bl
            r2.lineTo(r8, r4)
        L_0x0433:
            android.graphics.Paint r2 = r0.aS
            r2.setAlpha(r11)
            android.graphics.Paint r2 = r0.aS
            int r3 = r0.F
            float r3 = (float) r3
            float r3 = r3 * r1
            r2.setStrokeWidth(r3)
            android.graphics.Path r1 = r0.bl
            android.graphics.Paint r2 = r0.aS
            r7.drawPath(r1, r2)
            r20.restore()
            goto L_0x0c6d
        L_0x044d:
            r6 = 21
            if (r6 != r1) goto L_0x04a9
            r20.save()
            int r1 = r0.f3804a
            int r1 = -r1
            float r1 = (float) r1
            int r2 = r19.getWidth()
            int r2 = r2 / r9
            float r2 = (float) r2
            int r3 = r19.getHeight()
            int r3 = r3 / r9
            float r3 = (float) r3
            r7.rotate(r1, r2, r3)
            r0.a((android.graphics.Canvas) r7, (boolean) r10)
            android.graphics.Path r1 = r0.bl
            r1.rewind()
            android.graphics.Path r1 = r0.bl
            int r2 = r0.Q
            float r2 = (float) r2
            int r3 = r0.R
            float r3 = (float) r3
            r1.moveTo(r2, r3)
            android.graphics.Path r1 = r0.bl
            int r2 = r0.S
            float r2 = (float) r2
            int r3 = r0.T
            float r3 = (float) r3
            r1.lineTo(r2, r3)
            android.graphics.Path r1 = r0.bl
            int r2 = r0.U
            float r2 = (float) r2
            int r3 = r0.V
            float r3 = (float) r3
            r1.lineTo(r2, r3)
            android.graphics.Paint r1 = r0.aS
            r1.setAlpha(r11)
            android.graphics.Paint r1 = r0.aS
            int r2 = r0.F
            float r2 = (float) r2
            r1.setStrokeWidth(r2)
            android.graphics.Path r1 = r0.bl
            android.graphics.Paint r2 = r0.aS
            r7.drawPath(r1, r2)
            r20.restore()
            goto L_0x0c6d
        L_0x04a9:
            r6 = 20
            if (r6 != r1) goto L_0x04ec
            r0.a((android.graphics.Canvas) r7, (boolean) r10)
            android.graphics.Path r1 = r0.bl
            r1.rewind()
            int r1 = r0.I
            float r3 = (float) r1
            int r4 = r0.J
            float r5 = (float) r4
            int r6 = r0.G
            int r1 = r1 + r6
            float r1 = (float) r1
            float r6 = (float) r4
            int r8 = r0.H
            float r9 = (float) r8
            float r9 = r9 / r2
            float r6 = r6 + r9
            int r4 = r4 + r8
            float r2 = (float) r4
            android.graphics.Path r4 = r0.bl
            r4.moveTo(r3, r5)
            android.graphics.Path r4 = r0.bl
            r4.lineTo(r1, r6)
            android.graphics.Path r1 = r0.bl
            r1.lineTo(r3, r2)
            android.graphics.Paint r1 = r0.aS
            r1.setAlpha(r11)
            android.graphics.Paint r1 = r0.aS
            int r2 = r0.F
            float r2 = (float) r2
            r1.setStrokeWidth(r2)
            android.graphics.Path r1 = r0.bl
            android.graphics.Paint r2 = r0.aS
            r7.drawPath(r1, r2)
            goto L_0x0c6d
        L_0x04ec:
            r6 = 18
            r18 = 1050253722(0x3e99999a, float:0.3)
            if (r6 != r1) goto L_0x05a6
            android.graphics.Paint r1 = r0.aP
            r1.setAlpha(r11)
            android.graphics.RectF r1 = r0.aH
            int r4 = r0.q
            float r5 = (float) r4
            float r4 = (float) r4
            android.graphics.Paint r6 = r0.aP
            r7.drawRoundRect(r1, r5, r4, r6)
            r1 = 1060320051(0x3f333333, float:0.7)
            float r4 = r0.aq
            float r5 = r17 * r4
            float r5 = r5 + r3
            float r4 = r4 * r18
            float r4 = r4 + r1
            int r1 = r0.r
            float r1 = (float) r1
            float r1 = r1 * r4
            int r3 = r19.getWidth()
            float r3 = (float) r3
            float r3 = r3 / r2
            float r3 = r3 - r1
            int r4 = r19.getHeight()
            float r4 = (float) r4
            float r4 = r4 / r2
            float r4 = r4 - r1
            int r6 = r19.getWidth()
            float r6 = (float) r6
            float r6 = r6 / r2
            float r6 = r6 + r1
            int r8 = r19.getHeight()
            float r8 = (float) r8
            float r8 = r8 / r2
            float r8 = r8 + r1
            android.graphics.RectF r9 = r0.aK
            r9.set(r3, r4, r6, r8)
            android.graphics.Paint r3 = r0.aN
            r0.aR = r3
            android.graphics.Paint r3 = r0.aR
            int r4 = (int) r5
            r3.setAlpha(r4)
            android.graphics.RectF r3 = r0.aK
            android.graphics.Paint r4 = r0.aR
            r7.drawRoundRect(r3, r1, r1, r4)
            android.graphics.Path r1 = r0.bl
            r1.rewind()
            int r1 = r0.I
            float r3 = (float) r1
            int r4 = r0.J
            float r5 = (float) r4
            int r6 = r0.G
            int r1 = r1 + r6
            float r1 = (float) r1
            float r6 = (float) r4
            int r8 = r0.H
            float r9 = (float) r8
            float r9 = r9 / r2
            float r6 = r6 + r9
            int r4 = r4 + r8
            float r2 = (float) r4
            r4 = 1065353216(0x3f800000, float:1.0)
            float r8 = r0.aq
            float r18 = r18 * r8
            float r4 = r4 - r18
            float r8 = r8 * r17
            float r8 = r17 - r8
            float r9 = r1 - r3
            float r11 = r2 - r5
            float r13 = r0.a(r3, r4, r9, r10)
            float r5 = r0.a(r5, r4, r11, r10)
            float r1 = r0.a(r1, r4, r9, r12)
            float r3 = r0.a(r3, r4, r9, r10)
            float r2 = r0.a(r2, r4, r11, r12)
            android.graphics.Path r9 = r0.bl
            r9.moveTo(r13, r5)
            android.graphics.Path r5 = r0.bl
            r5.lineTo(r1, r6)
            android.graphics.Path r1 = r0.bl
            r1.lineTo(r3, r2)
            android.graphics.Paint r1 = r0.aS
            int r2 = (int) r8
            r1.setAlpha(r2)
            android.graphics.Paint r1 = r0.aS
            int r2 = r0.F
            float r2 = (float) r2
            float r2 = r2 * r4
            r1.setStrokeWidth(r2)
            android.graphics.Path r1 = r0.bl
            android.graphics.Paint r2 = r0.aS
            r7.drawPath(r1, r2)
            goto L_0x0c6d
        L_0x05a6:
            r6 = 19
            if (r6 != r1) goto L_0x0661
            android.graphics.Paint r1 = r0.aP
            r1.setAlpha(r11)
            android.graphics.RectF r1 = r0.aH
            int r4 = r0.q
            float r5 = (float) r4
            float r4 = (float) r4
            android.graphics.Paint r6 = r0.aP
            r7.drawRoundRect(r1, r5, r4, r6)
            r1 = 1060320051(0x3f333333, float:0.7)
            float r4 = r0.aq
            float r5 = r17 * r4
            float r5 = r5 + r3
            float r4 = r4 * r18
            float r4 = r4 + r1
            int r1 = r0.r
            float r1 = (float) r1
            float r1 = r1 * r4
            int r3 = r19.getWidth()
            float r3 = (float) r3
            float r3 = r3 / r2
            float r3 = r3 - r1
            int r4 = r19.getHeight()
            float r4 = (float) r4
            float r4 = r4 / r2
            float r4 = r4 - r1
            int r6 = r19.getWidth()
            float r6 = (float) r6
            float r6 = r6 / r2
            float r6 = r6 + r1
            int r8 = r19.getHeight()
            float r8 = (float) r8
            float r8 = r8 / r2
            float r8 = r8 + r1
            android.graphics.RectF r2 = r0.aK
            r2.set(r3, r4, r6, r8)
            android.graphics.Paint r2 = r0.aN
            r0.aR = r2
            android.graphics.Paint r2 = r0.aR
            int r3 = (int) r5
            r2.setAlpha(r3)
            android.graphics.RectF r2 = r0.aK
            android.graphics.Paint r3 = r0.aR
            r7.drawRoundRect(r2, r1, r1, r3)
            android.graphics.Path r1 = r0.bl
            r1.rewind()
            int r1 = r0.Q
            float r1 = (float) r1
            int r2 = r0.R
            float r2 = (float) r2
            int r3 = r0.S
            float r3 = (float) r3
            int r4 = r0.T
            float r4 = (float) r4
            int r5 = r0.U
            float r5 = (float) r5
            int r6 = r0.V
            float r6 = (float) r6
            r8 = 1065353216(0x3f800000, float:1.0)
            float r9 = r0.aq
            float r18 = r18 * r9
            float r8 = r8 - r18
            float r9 = r9 * r17
            float r9 = r17 - r9
            float r11 = r5 - r1
            float r13 = r4 - r6
            float r1 = r0.a(r1, r8, r11, r10)
            float r2 = r0.a(r2, r8, r13, r12)
            float r3 = r0.a(r3, r8, r11, r10)
            float r4 = r0.a(r4, r8, r13, r12)
            float r5 = r0.a(r5, r8, r11, r12)
            float r6 = r0.a(r6, r8, r13, r10)
            android.graphics.Path r10 = r0.bl
            r10.moveTo(r1, r2)
            android.graphics.Path r1 = r0.bl
            r1.lineTo(r3, r4)
            android.graphics.Path r1 = r0.bl
            r1.lineTo(r5, r6)
            android.graphics.Paint r1 = r0.aS
            int r2 = (int) r9
            r1.setAlpha(r2)
            android.graphics.Paint r1 = r0.aS
            int r2 = r0.F
            float r2 = (float) r2
            float r2 = r2 * r8
            r1.setStrokeWidth(r2)
            android.graphics.Path r1 = r0.bl
            android.graphics.Paint r2 = r0.aS
            r7.drawPath(r1, r2)
            goto L_0x0c6d
        L_0x0661:
            r3 = 16
            if (r1 != r3) goto L_0x0782
            android.graphics.Paint r1 = r0.aP
            r1.setAlpha(r11)
            android.graphics.RectF r1 = r0.aH
            int r3 = r0.q
            float r4 = (float) r3
            float r3 = (float) r3
            android.graphics.Paint r5 = r0.aP
            r7.drawRoundRect(r1, r4, r3, r5)
            int r1 = r0.u
            float r1 = (float) r1
            int r3 = r0.r
            float r3 = (float) r3
            int r4 = r19.getWidth()
            float r4 = (float) r4
            float r4 = r4 / r2
            int r5 = r0.t
            float r5 = (float) r5
            float r5 = r5 / r2
            float r4 = r4 - r5
            int r5 = r19.getHeight()
            float r5 = (float) r5
            float r5 = r5 / r2
            int r6 = r0.t
            float r6 = (float) r6
            float r6 = r6 / r2
            float r5 = r5 - r6
            int r6 = r19.getWidth()
            float r6 = (float) r6
            float r6 = r6 / r2
            int r8 = r0.t
            float r8 = (float) r8
            float r8 = r8 / r2
            float r6 = r6 + r8
            int r8 = r19.getWidth()
            float r8 = (float) r8
            float r8 = r8 / r2
            int r9 = r0.t
            float r9 = (float) r9
            float r9 = r9 / r2
            float r8 = r8 + r9
            int r9 = r19.getWidth()
            float r9 = (float) r9
            float r9 = r9 / r2
            int r10 = r0.r
            float r10 = (float) r10
            float r9 = r9 - r10
            int r10 = r19.getHeight()
            float r10 = (float) r10
            float r10 = r10 / r2
            int r12 = r0.r
            float r12 = (float) r12
            float r10 = r10 - r12
            int r12 = r19.getWidth()
            float r12 = (float) r12
            float r12 = r12 / r2
            int r13 = r0.r
            float r13 = (float) r13
            float r12 = r12 + r13
            int r13 = r19.getWidth()
            float r13 = (float) r13
            float r13 = r13 / r2
            int r14 = r0.r
            float r14 = (float) r14
            float r13 = r13 + r14
            r14 = -1015087104(0xffffffffc37f0000, float:-255.0)
            float r11 = r0.aq
            float r14 = r14 * r11
            float r14 = r14 + r17
            float r3 = r3 - r1
            float r3 = r3 * r11
            float r1 = r1 + r3
            float r9 = r9 - r4
            float r9 = r9 * r11
            float r4 = r4 + r9
            float r10 = r10 - r5
            float r10 = r10 * r11
            float r5 = r5 + r10
            float r12 = r12 - r6
            float r12 = r12 * r11
            float r6 = r6 + r12
            float r13 = r13 - r8
            float r13 = r13 * r11
            float r8 = r8 + r13
            android.graphics.RectF r3 = r0.aK
            r3.set(r4, r5, r6, r8)
            android.graphics.Paint r3 = r0.aN
            r0.aR = r3
            android.graphics.Paint r3 = r0.aR
            int r4 = (int) r14
            r3.setAlpha(r4)
            android.graphics.RectF r3 = r0.aK
            android.graphics.Paint r4 = r0.aR
            r7.drawRoundRect(r3, r1, r1, r4)
            int r1 = r0.G
            float r3 = (float) r1
            float r3 = r3 * r16
            int r4 = r0.H
            float r5 = (float) r4
            float r5 = r5 * r16
            float r6 = (float) r1
            float r8 = (float) r4
            float r6 = r6 - r3
            float r9 = r0.aq
            float r6 = r6 * r9
            float r3 = r3 + r6
            float r8 = r8 - r5
            float r8 = r8 * r9
            float r5 = r5 + r8
            int r6 = r0.I
            float r8 = (float) r6
            float r9 = (float) r1
            float r9 = r9 / r2
            float r8 = r8 + r9
            float r3 = r3 / r2
            float r8 = r8 - r3
            int r9 = r0.J
            float r10 = (float) r9
            float r11 = (float) r4
            float r11 = r11 / r2
            float r10 = r10 + r11
            float r5 = r5 / r2
            float r10 = r10 - r5
            float r6 = (float) r6
            float r1 = (float) r1
            float r1 = r1 / r2
            float r6 = r6 + r1
            float r6 = r6 + r3
            float r1 = (float) r9
            float r3 = (float) r4
            float r3 = r3 / r2
            float r1 = r1 + r3
            float r3 = (float) r9
            float r4 = (float) r4
            float r4 = r4 / r2
            float r3 = r3 + r4
            float r3 = r3 + r5
            android.graphics.Path r4 = r0.bl
            r4.rewind()
            float r4 = r0.aq
            int r5 = (r4 > r15 ? 1 : (r4 == r15 ? 0 : -1))
            if (r5 > 0) goto L_0x074a
            float r6 = r6 - r8
            float r6 = r6 * r4
            float r6 = r6 * r2
            float r6 = r6 + r8
            float r3 = r3 - r10
            float r3 = r3 * r4
            float r3 = r3 + r10
            android.graphics.Path r1 = r0.bl
            r1.moveTo(r8, r10)
            android.graphics.Path r1 = r0.bl
            r1.lineTo(r6, r3)
            goto L_0x0763
        L_0x074a:
            float r5 = r8 - r6
            float r9 = r4 - r15
            float r5 = r5 * r9
            float r5 = r5 * r2
            float r5 = r5 + r6
            float r3 = r3 - r10
            float r3 = r3 * r4
            float r3 = r3 + r10
            android.graphics.Path r2 = r0.bl
            r2.moveTo(r8, r10)
            android.graphics.Path r2 = r0.bl
            r2.lineTo(r6, r1)
            android.graphics.Path r1 = r0.bl
            r1.lineTo(r5, r3)
        L_0x0763:
            float r1 = r0.aq
            float r1 = r1 * r15
            float r16 = r16 - r1
            android.graphics.Paint r1 = r0.aS
            int r2 = r0.F
            float r2 = (float) r2
            float r2 = r2 * r16
            r1.setStrokeWidth(r2)
            android.graphics.Paint r1 = r0.aS
            r2 = 255(0xff, float:3.57E-43)
            r1.setAlpha(r2)
            android.graphics.Path r1 = r0.bl
            android.graphics.Paint r2 = r0.aS
            r7.drawPath(r1, r2)
            goto L_0x0c6d
        L_0x0782:
            r3 = 6
            if (r3 != r1) goto L_0x082e
            android.graphics.RectF r1 = r0.aH
            int r2 = r0.q
            float r3 = (float) r2
            float r2 = (float) r2
            android.graphics.Paint r4 = r0.aP
            r7.drawRoundRect(r1, r3, r2, r4)
            java.lang.String r1 = r0.as
            java.lang.String r2 = "button_shape_ring_none"
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L_0x079d
            int r1 = r0.r
            goto L_0x079f
        L_0x079d:
            int r1 = r0.s
        L_0x079f:
            int r2 = r0.t
            int r2 = r2 / r9
            int r2 = r1 - r2
            float r2 = (float) r2
            int r3 = r0.u
            int r3 = r1 - r3
            float r3 = (float) r3
            float r3 = r3 / r14
            float r2 = r2 / r14
            int r4 = r19.getWidth()
            int r4 = r4 / r9
            int r5 = r1 / 2
            int r4 = r4 - r5
            float r4 = (float) r4
            int r6 = r0.w
            float r6 = (float) r6
            float r6 = r6 * r2
            float r4 = r4 - r6
            int r6 = r19.getHeight()
            int r6 = r6 / r9
            int r6 = r6 - r5
            float r6 = (float) r6
            int r8 = r0.w
            float r8 = (float) r8
            float r8 = r8 * r2
            float r6 = r6 - r8
            int r8 = r19.getWidth()
            int r8 = r8 / r9
            int r8 = r8 + r5
            float r8 = (float) r8
            int r11 = r0.w
            float r11 = (float) r11
            float r11 = r11 * r2
            float r8 = r8 + r11
            int r11 = r19.getHeight()
            int r11 = r11 / r9
            int r11 = r11 + r5
            float r5 = (float) r11
            int r9 = r0.w
            float r11 = (float) r9
            float r11 = r11 * r2
            float r5 = r5 + r11
            float r1 = (float) r1
            float r2 = (float) r9
            float r2 = r2 * r3
            float r1 = r1 + r2
            android.graphics.RectF r2 = r0.aK
            r2.set(r4, r6, r8, r5)
            int r2 = r0.aj
            if (r2 != 0) goto L_0x07f9
            android.graphics.Paint r2 = r0.aM
            r3 = 255(0xff, float:3.57E-43)
            r2.setAlpha(r3)
            android.graphics.Paint r2 = r0.aM
            r0.aR = r2
            java.lang.String r2 = "button_color_inside_grey"
            goto L_0x0814
        L_0x07f9:
            r3 = 255(0xff, float:3.57E-43)
            if (r10 != r2) goto L_0x0809
            android.graphics.Paint r2 = r0.aN
            r2.setAlpha(r3)
            android.graphics.Paint r2 = r0.aN
            r0.aR = r2
            java.lang.String r2 = "button_color_inside_red"
            goto L_0x0814
        L_0x0809:
            android.graphics.Paint r2 = r0.aM
            r2.setAlpha(r3)
            android.graphics.Paint r2 = r0.aM
            r0.aR = r2
            java.lang.String r2 = "button_color_inside_none"
        L_0x0814:
            android.graphics.RectF r3 = r0.aK
            android.graphics.Paint r4 = r0.aR
            r7.drawRoundRect(r3, r1, r1, r4)
            int r1 = r0.w
            if (r1 >= r13) goto L_0x0827
            int r1 = r1 + r10
            r0.w = r1
            r19.invalidate()
            goto L_0x0c6d
        L_0x0827:
            r0.w = r12
            r0.a((int) r10, (java.lang.String) r2)
            goto L_0x0c6d
        L_0x082e:
            r3 = 7
            if (r3 != r1) goto L_0x08a5
            r0.a((android.graphics.Canvas) r7, (boolean) r10)
            int r1 = r0.t
            float r1 = (float) r1
            float r1 = r1 / r14
            int r3 = r0.v
            float r4 = (float) r3
            float r4 = r4 * r1
            int r1 = r0.u
            float r1 = (float) r1
            float r1 = r1 / r14
            float r3 = (float) r3
            float r3 = r3 * r1
            int r1 = r19.getWidth()
            int r1 = r1 / r9
            float r1 = (float) r1
            float r4 = r4 / r2
            float r1 = r1 - r4
            int r2 = r19.getHeight()
            int r2 = r2 / r9
            float r2 = (float) r2
            float r2 = r2 - r4
            int r6 = r19.getWidth()
            int r6 = r6 / r9
            float r6 = (float) r6
            float r6 = r6 + r4
            int r8 = r19.getHeight()
            int r8 = r8 / r9
            float r8 = (float) r8
            float r8 = r8 + r4
            android.graphics.RectF r4 = r0.aK
            r4.set(r1, r2, r6, r8)
            int r1 = r0.aj
            if (r1 != 0) goto L_0x0874
            android.graphics.Paint r1 = r0.aM
            r2 = 255(0xff, float:3.57E-43)
            r1.setAlpha(r2)
            android.graphics.Paint r1 = r0.aM
            r0.aR = r1
            goto L_0x088b
        L_0x0874:
            r2 = 255(0xff, float:3.57E-43)
            if (r10 != r1) goto L_0x0882
            android.graphics.Paint r1 = r0.aN
            r1.setAlpha(r2)
            android.graphics.Paint r1 = r0.aN
            r0.aR = r1
            goto L_0x088b
        L_0x0882:
            android.graphics.Paint r1 = r0.aM
            r1.setAlpha(r2)
            android.graphics.Paint r1 = r0.aM
            r0.aR = r1
        L_0x088b:
            android.graphics.RectF r1 = r0.aK
            android.graphics.Paint r2 = r0.aR
            r7.drawRoundRect(r1, r3, r3, r2)
            int r1 = r0.v
            if (r1 >= r13) goto L_0x089e
            int r1 = r1 + r10
            r0.v = r1
            r19.invalidate()
            goto L_0x0c6d
        L_0x089e:
            r0.v = r12
            r0.setButtonTypeAndInvalidate((int) r5)
            goto L_0x0c6d
        L_0x08a5:
            if (r13 != r1) goto L_0x092f
            android.graphics.RectF r1 = r0.aH
            int r3 = r0.q
            float r4 = (float) r3
            float r3 = (float) r3
            android.graphics.Paint r5 = r0.aP
            r7.drawRoundRect(r1, r4, r3, r5)
            int r1 = r0.t
            float r3 = (float) r1
            float r3 = r3 / r14
            float r1 = (float) r1
            int r4 = r0.w
            float r5 = (float) r4
            float r5 = r5 * r3
            float r1 = r1 - r5
            int r3 = r0.u
            float r5 = (float) r3
            float r5 = r5 / r14
            float r3 = (float) r3
            float r4 = (float) r4
            float r4 = r4 * r5
            float r3 = r3 - r4
            int r4 = r19.getWidth()
            int r4 = r4 / r9
            float r4 = (float) r4
            float r1 = r1 / r2
            float r4 = r4 - r1
            int r2 = r19.getHeight()
            int r2 = r2 / r9
            float r2 = (float) r2
            float r2 = r2 - r1
            int r5 = r19.getWidth()
            int r5 = r5 / r9
            float r5 = (float) r5
            float r5 = r5 + r1
            int r6 = r19.getHeight()
            int r6 = r6 / r9
            float r6 = (float) r6
            float r6 = r6 + r1
            android.graphics.RectF r1 = r0.aK
            r1.set(r4, r2, r5, r6)
            java.lang.String r1 = r0.ar
            java.lang.String r2 = "button_color_inside_grey"
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L_0x08fc
            android.graphics.Paint r1 = r0.aO
            r2 = 51
            r1.setAlpha(r2)
            android.graphics.Paint r1 = r0.aO
            r0.aR = r1
            goto L_0x0913
        L_0x08fc:
            java.lang.String r1 = r0.ar
            java.lang.String r2 = "button_color_inside_red"
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L_0x0913
            android.graphics.Paint r1 = r0.aN
            r2 = 255(0xff, float:3.57E-43)
            r1.setAlpha(r2)
            android.graphics.Paint r1 = r0.aN
            r0.aR = r1
            r1 = r10
            goto L_0x0914
        L_0x0913:
            r1 = r12
        L_0x0914:
            android.graphics.RectF r2 = r0.aK
            android.graphics.Paint r4 = r0.aR
            r7.drawRoundRect(r2, r3, r3, r4)
            int r2 = r0.w
            if (r2 >= r13) goto L_0x0927
            int r2 = r2 + r10
            r0.w = r2
            r19.invalidate()
            goto L_0x0c6d
        L_0x0927:
            r0.w = r12
            r2 = 4
            r0.a((int) r2, (int) r1)
            goto L_0x0c6d
        L_0x092f:
            r3 = 9
            if (r3 != r1) goto L_0x096a
            r0.a((android.graphics.Canvas) r7, (boolean) r10)
            int r1 = r0.aj
            if (r1 != 0) goto L_0x0946
            android.graphics.Paint r1 = r0.aM
            r2 = 255(0xff, float:3.57E-43)
            r1.setAlpha(r2)
            android.graphics.Paint r1 = r0.aM
            r0.aR = r1
            goto L_0x095d
        L_0x0946:
            r2 = 255(0xff, float:3.57E-43)
            if (r10 != r1) goto L_0x0954
            android.graphics.Paint r1 = r0.aN
            r1.setAlpha(r2)
            android.graphics.Paint r1 = r0.aN
            r0.aR = r1
            goto L_0x095d
        L_0x0954:
            android.graphics.Paint r1 = r0.aM
            r1.setAlpha(r2)
            android.graphics.Paint r1 = r0.aM
            r0.aR = r1
        L_0x095d:
            android.graphics.RectF r1 = r0.aJ
            int r2 = r0.u
            float r3 = (float) r2
            float r2 = (float) r2
            android.graphics.Paint r4 = r0.aR
            r7.drawRoundRect(r1, r3, r2, r4)
            goto L_0x0c6d
        L_0x096a:
            r3 = 10
            if (r3 != r1) goto L_0x09f3
            android.graphics.Paint r1 = r0.aP
            r3 = 255(0xff, float:3.57E-43)
            r1.setAlpha(r3)
            android.graphics.RectF r1 = r0.aH
            int r3 = r0.q
            float r4 = (float) r3
            float r3 = (float) r3
            android.graphics.Paint r5 = r0.aP
            r7.drawRoundRect(r1, r4, r3, r5)
            int r1 = r0.t
            float r1 = (float) r1
            float r1 = r1 / r14
            int r3 = r0.v
            float r4 = (float) r3
            float r4 = r4 * r1
            int r1 = r0.u
            float r1 = (float) r1
            float r1 = r1 / r14
            float r3 = (float) r3
            float r3 = r3 * r1
            int r1 = r19.getWidth()
            int r1 = r1 / r9
            float r1 = (float) r1
            float r4 = r4 / r2
            float r1 = r1 - r4
            int r2 = r19.getHeight()
            int r2 = r2 / r9
            float r2 = (float) r2
            float r2 = r2 - r4
            int r5 = r19.getWidth()
            int r5 = r5 / r9
            float r5 = (float) r5
            float r5 = r5 + r4
            int r6 = r19.getHeight()
            int r6 = r6 / r9
            float r6 = (float) r6
            float r6 = r6 + r4
            android.graphics.RectF r4 = r0.aK
            r4.set(r1, r2, r5, r6)
            int r1 = r0.aj
            if (r1 != 0) goto L_0x09c0
            android.graphics.Paint r1 = r0.aM
            r2 = 255(0xff, float:3.57E-43)
            r1.setAlpha(r2)
            android.graphics.Paint r1 = r0.aM
            r0.aR = r1
            goto L_0x09d7
        L_0x09c0:
            r2 = 255(0xff, float:3.57E-43)
            if (r10 != r1) goto L_0x09ce
            android.graphics.Paint r1 = r0.aN
            r1.setAlpha(r2)
            android.graphics.Paint r1 = r0.aN
            r0.aR = r1
            goto L_0x09d7
        L_0x09ce:
            android.graphics.Paint r1 = r0.aM
            r1.setAlpha(r2)
            android.graphics.Paint r1 = r0.aM
            r0.aR = r1
        L_0x09d7:
            android.graphics.RectF r1 = r0.aK
            android.graphics.Paint r2 = r0.aR
            r7.drawRoundRect(r1, r3, r3, r2)
            int r1 = r0.v
            if (r1 >= r13) goto L_0x09ea
            int r1 = r1 + r10
            r0.v = r1
            r19.invalidate()
            goto L_0x0c6d
        L_0x09ea:
            r0.v = r12
            r1 = 9
            r0.setButtonTypeAndInvalidate((int) r1)
            goto L_0x0c6d
        L_0x09f3:
            r3 = 22
            if (r3 != r1) goto L_0x0a9f
            android.graphics.Paint r1 = r0.aP
            r2 = 255(0xff, float:3.57E-43)
            r1.setAlpha(r2)
            android.graphics.RectF r1 = r0.aH
            int r2 = r0.q
            float r3 = (float) r2
            float r2 = (float) r2
            android.graphics.Paint r4 = r0.aP
            r7.drawRoundRect(r1, r3, r2, r4)
            java.lang.String r1 = r0.as
            java.lang.String r2 = "button_shape_ring_none"
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L_0x0a16
            int r1 = r0.r
            goto L_0x0a18
        L_0x0a16:
            int r1 = r0.s
        L_0x0a18:
            int r2 = r0.t
            int r2 = r2 / r9
            int r2 = r1 - r2
            float r2 = (float) r2
            int r3 = r0.u
            int r3 = r1 - r3
            float r3 = (float) r3
            float r3 = r3 / r14
            float r2 = r2 / r14
            int r4 = r19.getWidth()
            int r4 = r4 / r9
            int r4 = r4 - r1
            float r4 = (float) r4
            int r6 = r0.v
            float r6 = (float) r6
            float r6 = r6 * r2
            float r4 = r4 + r6
            int r6 = r19.getHeight()
            int r6 = r6 / r9
            int r6 = r6 - r1
            float r6 = (float) r6
            int r8 = r0.v
            float r8 = (float) r8
            float r8 = r8 * r2
            float r6 = r6 + r8
            int r8 = r19.getWidth()
            int r8 = r8 / r9
            int r8 = r8 + r1
            float r8 = (float) r8
            int r11 = r0.v
            float r11 = (float) r11
            float r11 = r11 * r2
            float r8 = r8 - r11
            int r11 = r19.getHeight()
            int r11 = r11 / r9
            int r11 = r11 + r1
            float r9 = (float) r11
            int r11 = r0.v
            float r14 = (float) r11
            float r14 = r14 * r2
            float r9 = r9 - r14
            float r1 = (float) r1
            float r2 = (float) r11
            float r2 = r2 * r3
            float r1 = r1 - r2
            android.graphics.RectF r2 = r0.aK
            r2.set(r4, r6, r8, r9)
            int r2 = r0.aj
            if (r2 != 0) goto L_0x0a6e
            android.graphics.Paint r2 = r0.aM
            r3 = 255(0xff, float:3.57E-43)
            r2.setAlpha(r3)
            android.graphics.Paint r2 = r0.aM
            r0.aR = r2
            goto L_0x0a85
        L_0x0a6e:
            r3 = 255(0xff, float:3.57E-43)
            if (r10 != r2) goto L_0x0a7c
            android.graphics.Paint r2 = r0.aN
            r2.setAlpha(r3)
            android.graphics.Paint r2 = r0.aN
            r0.aR = r2
            goto L_0x0a85
        L_0x0a7c:
            android.graphics.Paint r2 = r0.aM
            r2.setAlpha(r3)
            android.graphics.Paint r2 = r0.aM
            r0.aR = r2
        L_0x0a85:
            android.graphics.RectF r2 = r0.aK
            android.graphics.Paint r3 = r0.aR
            r7.drawRoundRect(r2, r1, r1, r3)
            int r1 = r0.v
            if (r1 >= r13) goto L_0x0a98
            int r1 = r1 + r10
            r0.v = r1
            r19.invalidate()
            goto L_0x0c6d
        L_0x0a98:
            r0.v = r12
            r0.setButtonTypeAndInvalidate((int) r5)
            goto L_0x0c6d
        L_0x0a9f:
            r3 = 11
            if (r3 != r1) goto L_0x0b1b
            r0.a((android.graphics.Canvas) r7, (boolean) r10)
            int r1 = r0.t
            float r3 = (float) r1
            float r3 = r3 / r14
            float r1 = (float) r1
            int r4 = r0.w
            float r5 = (float) r4
            float r5 = r5 * r3
            float r1 = r1 - r5
            int r3 = r0.u
            float r5 = (float) r3
            float r5 = r5 / r14
            float r3 = (float) r3
            float r4 = (float) r4
            float r4 = r4 * r5
            float r3 = r3 - r4
            int r4 = r19.getWidth()
            int r4 = r4 / r9
            float r4 = (float) r4
            float r1 = r1 / r2
            float r4 = r4 - r1
            int r2 = r19.getHeight()
            int r2 = r2 / r9
            float r2 = (float) r2
            float r2 = r2 - r1
            int r5 = r19.getWidth()
            int r5 = r5 / r9
            float r5 = (float) r5
            float r5 = r5 + r1
            int r6 = r19.getHeight()
            int r6 = r6 / r9
            float r6 = (float) r6
            float r6 = r6 + r1
            android.graphics.RectF r1 = r0.aK
            r1.set(r4, r2, r5, r6)
            int r1 = r0.aj
            if (r1 != 0) goto L_0x0aea
            android.graphics.Paint r1 = r0.aM
            r2 = 255(0xff, float:3.57E-43)
            r1.setAlpha(r2)
            android.graphics.Paint r1 = r0.aM
            r0.aR = r1
            goto L_0x0b01
        L_0x0aea:
            r2 = 255(0xff, float:3.57E-43)
            if (r10 != r1) goto L_0x0af8
            android.graphics.Paint r1 = r0.aN
            r1.setAlpha(r2)
            android.graphics.Paint r1 = r0.aN
            r0.aR = r1
            goto L_0x0b01
        L_0x0af8:
            android.graphics.Paint r1 = r0.aM
            r1.setAlpha(r2)
            android.graphics.Paint r1 = r0.aM
            r0.aR = r1
        L_0x0b01:
            android.graphics.RectF r1 = r0.aK
            android.graphics.Paint r2 = r0.aR
            r7.drawRoundRect(r1, r3, r3, r2)
            int r1 = r0.w
            if (r1 >= r13) goto L_0x0b14
            int r1 = r1 + r10
            r0.w = r1
            r19.invalidate()
            goto L_0x0c6d
        L_0x0b14:
            r0.w = r12
            r0.setButtonTypeAndInvalidate((int) r10)
            goto L_0x0c6d
        L_0x0b1b:
            r3 = 12
            if (r3 != r1) goto L_0x0b84
            android.graphics.Paint r1 = r0.aP
            r1.setAlpha(r4)
            android.graphics.RectF r1 = r0.aH
            int r2 = r0.q
            float r3 = (float) r2
            float r2 = (float) r2
            android.graphics.Paint r4 = r0.aP
            r7.drawRoundRect(r1, r3, r2, r4)
            android.graphics.Paint r1 = r0.aL
            float r2 = r0.E
            r1.setStrokeWidth(r2)
            android.graphics.RectF r2 = r0.aH
            r3 = -1028390912(0xffffffffc2b40000, float:-90.0)
            int r1 = r0.W
            float r4 = (float) r1
            r5 = 0
            android.graphics.Paint r6 = r0.aL
            r1 = r20
            r1.drawArc(r2, r3, r4, r5, r6)
            int r1 = r0.aj
            if (r1 != 0) goto L_0x0b55
            android.graphics.Paint r1 = r0.aM
            r2 = 255(0xff, float:3.57E-43)
            r1.setAlpha(r2)
            android.graphics.Paint r1 = r0.aM
            r0.aR = r1
            goto L_0x0b6c
        L_0x0b55:
            r2 = 255(0xff, float:3.57E-43)
            if (r10 != r1) goto L_0x0b63
            android.graphics.Paint r1 = r0.aN
            r1.setAlpha(r2)
            android.graphics.Paint r1 = r0.aN
            r0.aR = r1
            goto L_0x0b6c
        L_0x0b63:
            android.graphics.Paint r1 = r0.aM
            r1.setAlpha(r2)
            android.graphics.Paint r1 = r0.aM
            r0.aR = r1
        L_0x0b6c:
            android.graphics.RectF r1 = r0.aJ
            int r2 = r0.u
            float r3 = (float) r2
            float r2 = (float) r2
            android.graphics.Paint r4 = r0.aR
            r7.drawRoundRect(r1, r3, r2, r4)
            int r1 = r0.W
            if (r1 < r8) goto L_0x0c6d
            r0.W = r12
            r1 = 11
            r0.setButtonTypeAndInvalidate((int) r1)
            goto L_0x0c6d
        L_0x0b84:
            r3 = 13
            if (r3 != r1) goto L_0x0ba5
            android.graphics.Paint r1 = r0.aP
            r1.setAlpha(r4)
            r0.a((android.graphics.Canvas) r7, (boolean) r12)
            r0.aj = r9
            int r1 = r0.v
            if (r1 >= r13) goto L_0x0b9e
            int r1 = r1 + r10
            r0.v = r1
            r19.invalidate()
            goto L_0x0c6d
        L_0x0b9e:
            r0.v = r12
            r0.setButtonTypeAndInvalidate((int) r5)
            goto L_0x0c6d
        L_0x0ba5:
            r3 = 14
            if (r3 != r1) goto L_0x0bf8
            android.graphics.Paint r1 = r0.aP
            r1.setAlpha(r4)
            r0.a((android.graphics.Canvas) r7, (boolean) r12)
            float r1 = r0.an
            float r2 = r0.am
            float r1 = r1 - r2
            float r2 = r0.ao
            boolean r3 = r0.au
            if (r3 == 0) goto L_0x0bc8
            int r3 = r0.z
            float r3 = (float) r3
            float r3 = r3 + r2
            float r4 = r0.ap
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 != 0) goto L_0x0bd8
            float r3 = r3 - r4
            goto L_0x0bd8
        L_0x0bc8:
            float r1 = r1 + r2
            r3 = 1135869952(0x43b40000, float:360.0)
            float r3 = r3 - r2
            int r4 = r0.z
            float r4 = (float) r4
            float r3 = r3 - r4
            float r4 = r0.ap
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 != 0) goto L_0x0bd8
            float r1 = r1 - r4
            float r3 = r3 + r4
        L_0x0bd8:
            r4 = r3
            r3 = r1
            android.graphics.Paint r1 = r0.aL
            float r2 = r0.E
            r1.setStrokeWidth(r2)
            android.graphics.RectF r2 = r0.aH
            r5 = 0
            android.graphics.Paint r6 = r0.aL
            r1 = r20
            r1.drawArc(r2, r3, r4, r5, r6)
            android.graphics.RectF r1 = r0.aJ
            int r2 = r0.u
            float r3 = (float) r2
            float r2 = (float) r2
            android.graphics.Paint r4 = r0.aR
            r7.drawRoundRect(r1, r3, r2, r4)
            goto L_0x0c6d
        L_0x0bf8:
            r3 = 15
            if (r3 != r1) goto L_0x0c6d
            r0.a((android.graphics.Canvas) r7, (boolean) r10)
            int r1 = r0.t
            float r1 = (float) r1
            float r1 = r1 / r14
            int r3 = r0.v
            float r4 = (float) r3
            float r4 = r4 * r1
            int r1 = r0.u
            float r1 = (float) r1
            float r1 = r1 / r14
            float r3 = (float) r3
            float r3 = r3 * r1
            int r1 = r19.getWidth()
            int r1 = r1 / r9
            float r1 = (float) r1
            float r4 = r4 / r2
            float r1 = r1 - r4
            int r2 = r19.getHeight()
            int r2 = r2 / r9
            float r2 = (float) r2
            float r2 = r2 - r4
            int r6 = r19.getWidth()
            int r6 = r6 / r9
            float r6 = (float) r6
            float r6 = r6 + r4
            int r8 = r19.getHeight()
            int r8 = r8 / r9
            float r8 = (float) r8
            float r8 = r8 + r4
            android.graphics.RectF r4 = r0.aK
            r4.set(r1, r2, r6, r8)
            int r1 = r0.aj
            if (r1 != 0) goto L_0x0c3f
            android.graphics.Paint r1 = r0.aM
            r2 = 255(0xff, float:3.57E-43)
            r1.setAlpha(r2)
            android.graphics.Paint r1 = r0.aM
            r0.aR = r1
            goto L_0x0c56
        L_0x0c3f:
            r2 = 255(0xff, float:3.57E-43)
            if (r10 != r1) goto L_0x0c4d
            android.graphics.Paint r1 = r0.aN
            r1.setAlpha(r2)
            android.graphics.Paint r1 = r0.aN
            r0.aR = r1
            goto L_0x0c56
        L_0x0c4d:
            android.graphics.Paint r1 = r0.aM
            r1.setAlpha(r2)
            android.graphics.Paint r1 = r0.aM
            r0.aR = r1
        L_0x0c56:
            android.graphics.RectF r1 = r0.aK
            android.graphics.Paint r2 = r0.aR
            r7.drawRoundRect(r1, r3, r3, r2)
            int r1 = r0.v
            if (r1 >= r13) goto L_0x0c68
            int r1 = r1 + r10
            r0.v = r1
            r19.invalidate()
            goto L_0x0c6d
        L_0x0c68:
            r0.v = r12
            r0.setButtonTypeAndInvalidate((int) r5)
        L_0x0c6d:
            r19.a((android.graphics.Canvas) r20)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.ui.control.MainShutterButton.onDraw(android.graphics.Canvas):void");
    }

    private void a(Canvas canvas, boolean z2) {
        if ("button_color_inside_red".equals(this.ar)) {
            this.aN.setAlpha(this.ab);
            this.aR = this.aN;
        } else if ("button_color_inside_grey".equals(this.ar)) {
            this.aO.setAlpha(51);
            this.aR = this.aO;
        }
        if (z2) {
            if (isPressed()) {
                Paint paint = this.aR;
                if (paint != null) {
                    paint.setAlpha(51);
                }
                this.aP.setAlpha(128);
            } else {
                this.aP.setAlpha(255);
            }
        }
        if (!"button_color_inside_none".equals(this.ar) && this.aR != null) {
            float f = (float) ("button_shape_ring_none".equals(this.as) ? this.r : this.s);
            canvas.drawRoundRect("button_shape_ring_none".equals(this.as) ? this.aF : this.aG, f, f, this.aR);
        }
        if (this.aw && !isPressed()) {
            Bitmap bitmap = this.aE;
            if (bitmap == null) {
                this.aE = a(bitmap, (int) R.drawable.shutter_button_shadow);
            }
            Bitmap bitmap2 = this.aE;
            canvas.drawBitmap(bitmap2, new Rect(0, 0, bitmap2.getWidth(), this.aE.getHeight()), this.aI, this.aT);
        }
        RectF rectF = this.aH;
        int i = this.q;
        canvas.drawRoundRect(rectF, (float) i, (float) i, this.aP);
    }

    private void a(Canvas canvas, Bitmap bitmap) {
        if (bitmap != null && !bitmap.isRecycled()) {
            canvas.drawBitmap(bitmap, (Rect) null, new RectF((float) ((getWidth() - bitmap.getWidth()) / 2), (float) ((getHeight() - bitmap.getHeight()) / 2), (float) ((getWidth() + bitmap.getWidth()) / 2), (float) ((getHeight() + bitmap.getHeight()) / 2)), (Paint) null);
        }
    }

    /* access modifiers changed from: private */
    public void m() {
        this.au = !this.au;
        if (this.au) {
            this.am = (this.am + ((float) (this.z * 2))) % 360.0f;
        }
    }

    private void n() {
        o();
        v();
        w();
    }

    private void o() {
        this.aU = new Property<MainShutterButton, Float>(Float.class, "angle") {
            /* renamed from: a */
            public Float get(MainShutterButton mainShutterButton) {
                return Float.valueOf(mainShutterButton.getCurrentGlobalAngle());
            }

            /* renamed from: a */
            public void set(MainShutterButton mainShutterButton, Float f) {
                mainShutterButton.setCurrentGlobalAngle(f.floatValue());
            }
        };
        this.aV = new Property<MainShutterButton, Float>(Float.class, "arc") {
            /* renamed from: a */
            public Float get(MainShutterButton mainShutterButton) {
                return Float.valueOf(mainShutterButton.getCurrentSweepAngle());
            }

            /* renamed from: a */
            public void set(MainShutterButton mainShutterButton, Float f) {
                mainShutterButton.setCurrentSweepAngle(f.floatValue());
            }
        };
        this.ay = ObjectAnimator.ofFloat(this, this.aU, new float[]{360.0f});
        this.ay.setInterpolator(k);
        this.ay.setDuration((long) this.x);
        this.ay.setRepeatMode(1);
        this.ay.setRepeatCount(-1);
        this.ax = ObjectAnimator.ofFloat(this, this.aV, new float[]{this.ap});
        this.ax.setInterpolator(l);
        this.ax.setDuration((long) this.y);
        this.ax.setRepeatMode(1);
        this.ax.setRepeatCount(-1);
        this.ax.addListener(new Animator.AnimatorListener() {
            public void onAnimationCancel(Animator animator) {
            }

            public void onAnimationEnd(Animator animator) {
            }

            public void onAnimationStart(Animator animator) {
            }

            public void onAnimationRepeat(Animator animator) {
                MainShutterButton.this.m();
            }
        });
    }

    public float getCurrentGlobalAngle() {
        return this.an;
    }

    public void setCurrentGlobalAngle(float f) {
        this.an = f;
        invalidate();
    }

    public float getCurrentSweepAngle() {
        return this.ao;
    }

    public void setCurrentSweepAngle(float f) {
        this.ao = f;
        invalidate();
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        e.a("MainShutterButton", "onAttachedToWindow, mButtonType: " + this.p);
        if (4 == this.p) {
            j();
        }
        super.onAttachedToWindow();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        e.a("MainShutterButton", " onDetachedFromWindow, mButtonType: " + this.p);
        if (4 == this.p) {
            k();
        }
        super.onDetachedFromWindow();
    }

    public void setButtonTypeAndInvalidate(c cVar) {
        e.a("MainShutterButton", "setButtonTypeAndInvalidate, mShutterButtonType: " + cVar.a() + ", mInfoInsideColor: " + cVar.b() + ", mRingShape: " + cVar.c() + ", mInfoInsideRectColor: " + cVar.d());
        ObjectAnimator objectAnimator = this.aX;
        if (objectAnimator != null && objectAnimator.isRunning() && 6 == cVar.a()) {
            this.aX.cancel();
        }
        ValueAnimator valueAnimator = this.bj;
        if (valueAnimator != null && valueAnimator.isRunning() && 22 == cVar.a()) {
            this.bj.cancel();
        }
        q();
        boolean z2 = this.aw;
        this.aw = cVar.f();
        this.ar = cVar.b();
        this.as = cVar.c();
        this.aj = cVar.d();
        setButtonType(cVar.a());
        if (z2 != cVar.f()) {
            i();
        }
        if (this.p != 4 && l()) {
            this.at = false;
            p();
        }
        if (cVar.e()) {
            if ("button_color_inside_red".equals(this.ar)) {
                this.ab = 0;
            }
            c();
        } else {
            this.ab = 255;
        }
        int i = this.p;
        if (3 == i) {
            A();
        } else if (4 == i) {
            j();
        } else if (14 == i) {
            j();
        } else if (5 != i || !"button_shape_dial_rotate".equals(this.as)) {
            int i2 = this.p;
            if (16 == i2) {
                B();
            } else if (17 == i2) {
                E();
            } else if (18 == i2) {
                C();
            } else if (19 == i2) {
                D();
            } else {
                invalidate();
            }
        } else {
            d();
        }
    }

    private void a(int i, String str) {
        this.ar = str;
        setButtonTypeAndInvalidate(i);
    }

    private void a(int i, int i2) {
        this.aj = i2;
        setButtonTypeAndInvalidate(i);
    }

    /* access modifiers changed from: private */
    public void setButtonTypeAndInvalidate(int i) {
        e.a("MainShutterButton", "setButtonTypeAndInvalidate, buttonType: " + i);
        q();
        setButtonType(i);
        if (this.p != 4 && l()) {
            this.at = false;
            p();
        }
        int i2 = this.p;
        if (3 == i2) {
            A();
        } else if (4 == i2) {
            j();
        } else if (14 == i2) {
            j();
        } else if (5 != i2 || !"button_shape_dial_rotate".equals(this.as)) {
            invalidate();
        } else {
            d();
        }
    }

    public void a(c cVar) {
        c shutterButtonInfo = getShutterButtonInfo();
        if (shutterButtonInfo == null) {
            e.e("MainShutterButton", "switchToModeType, null == currentButtonInfo");
            return;
        }
        e.a("MainShutterButton", "switchToModeType, before shutterButtonType: " + shutterButtonInfo.a() + ", before insideColor: " + shutterButtonInfo.b() + ", before ringShape: " + shutterButtonInfo.c() + " -> after shutterButtonType: " + cVar.a() + ", after insideColor: " + cVar.b() + ", after ringShape: " + cVar.c());
        setButtonTypeAndInvalidate(cVar);
    }

    public boolean b(c cVar) {
        return cVar.a() == this.p && cVar.b().equals(this.ar) && cVar.c().equals(this.as);
    }

    private void p() {
        ObjectAnimator objectAnimator = this.ay;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
        ObjectAnimator objectAnimator2 = this.ax;
        if (objectAnimator2 != null) {
            objectAnimator2.cancel();
        }
    }

    private void q() {
        ValueAnimator valueAnimator = this.ba;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.ba.cancel();
        }
    }

    private void r() {
        ValueAnimator valueAnimator = this.bb;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.bb.cancel();
        }
        ValueAnimator valueAnimator2 = this.bc;
        if (valueAnimator2 != null && valueAnimator2.isRunning()) {
            this.bc.cancel();
        }
    }

    public void setButtonType(int i) {
        e.a("MainShutterButton", "setButtonType, type: " + this.p + " => " + i);
        this.p = i;
        if (12 == this.p) {
            this.W = 0;
        }
        if (this.w != 0) {
            this.w = 0;
        }
    }

    public void a(int i, String str, int i2) {
        e.a("MainShutterButton", "setButtonType, insideRectColor: " + this.aj + " => " + i2 + ", inSideColor: " + this.ar + " => " + str);
        this.ar = str;
        this.aj = i2;
        setButtonType(i);
    }

    public int getButtonType() {
        return this.p;
    }

    public String getInsideColor() {
        return this.ar;
    }

    public String getRingShape() {
        return this.as;
    }

    public c getShutterButtonInfo() {
        return new c(this.p, this.ar);
    }

    public void a() {
        s();
        t();
        z();
        u();
    }

    private void s() {
        this.aF = null;
        this.aH = null;
        this.aJ = null;
        this.aL = null;
        this.aM = null;
        this.aN = null;
        this.aO = null;
    }

    private void t() {
        this.ay = null;
        this.ax = null;
        this.aU = null;
        this.aV = null;
        this.aW = null;
    }

    private void u() {
        Bitmap bitmap = this.aA;
        if (bitmap != null) {
            bitmap.recycle();
            this.aA = null;
        }
        Bitmap bitmap2 = this.aB;
        if (bitmap2 != null) {
            bitmap2.recycle();
            this.aB = null;
        }
        Bitmap bitmap3 = this.aC;
        if (bitmap3 != null) {
            bitmap3.recycle();
            this.aC = null;
        }
        Bitmap bitmap4 = this.aD;
        if (bitmap4 != null) {
            bitmap4.recycle();
            this.aD = null;
        }
        this.az = null;
    }

    public void b() {
        ObjectAnimator objectAnimator = this.aY;
        if (objectAnimator != null) {
            objectAnimator.cancel();
            this.C = 0;
        }
        ObjectAnimator objectAnimator2 = this.aX;
        if (objectAnimator2 != null) {
            objectAnimator2.cancel();
        }
    }

    private void v() {
        Resources resources = getResources();
        this.ac = resources.getDimensionPixelSize(R.dimen.shutter_button_line_height);
        this.ag = resources.getDimensionPixelSize(R.dimen.shutter_button_long_line_height);
        this.ai = resources.getDimensionPixelSize(R.dimen.shutter_button_long_line_padding);
        int i = this.ai;
        this.ak = (i * 2) + this.ag;
        int i2 = this.r;
        int i3 = this.ak;
        this.s = i2 - i3;
        this.ae = i;
        int i4 = this.ac;
        this.ad = (i3 - i4) - this.ae;
        this.af = (i3 - i4) / 2;
        this.aW = new Property<MainShutterButton, Integer>(Integer.class, "dial") {
            /* renamed from: a */
            public Integer get(MainShutterButton mainShutterButton) {
                return Integer.valueOf(mainShutterButton.getDialValue());
            }

            /* renamed from: a */
            public void set(MainShutterButton mainShutterButton, Integer num) {
                mainShutterButton.setDialValue(num.intValue());
            }
        };
        this.aX = ObjectAnimator.ofInt(this, this.aW, new int[]{0, 60});
        this.aX.setInterpolator(new LinearInterpolator());
        this.aX.setDuration(600);
        this.aX.addListener(new Animator.AnimatorListener() {
            public void onAnimationCancel(Animator animator) {
            }

            public void onAnimationRepeat(Animator animator) {
            }

            public void onAnimationStart(Animator animator) {
            }

            public void onAnimationEnd(Animator animator) {
                int unused = MainShutterButton.this.v = 0;
                e.a("MainShutterButton", "onAnimationEnd, mRingDotPrepareAnimator end, mButtonType: " + MainShutterButton.this.p);
                if (MainShutterButton.this.aY == null) {
                    return;
                }
                if ((2 == MainShutterButton.this.p || 5 == MainShutterButton.this.p) && "button_shape_dial_rotate".equals(MainShutterButton.this.as)) {
                    MainShutterButton.this.aY.setCurrentFraction(0.5f);
                    MainShutterButton.this.aY.start();
                    if (2 != MainShutterButton.this.p) {
                        MainShutterButton.this.setButtonType(2);
                    }
                }
            }
        });
        this.ba = ValueAnimator.ofInt(new int[]{0, 360});
        this.ba.setInterpolator(new LinearInterpolator());
        this.ba.setDuration((long) this.B);
        this.ba.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                if (MainShutterButton.this.A != intValue) {
                    int unused = MainShutterButton.this.A = intValue;
                    MainShutterButton.this.invalidate();
                }
            }
        });
        this.aY = ObjectAnimator.ofInt(this, this.aW, new int[]{0, 120});
        this.aY.setRepeatMode(1);
        this.aY.setRepeatCount(-1);
        this.aY.setInterpolator(new LinearInterpolator());
        this.aY.setDuration(12000);
        this.aY.addListener(new Animator.AnimatorListener() {
            public void onAnimationCancel(Animator animator) {
            }

            public void onAnimationRepeat(Animator animator) {
            }

            public void onAnimationStart(Animator animator) {
            }

            public void onAnimationEnd(Animator animator) {
                MainShutterButton.this.y();
                MainShutterButton.this.aZ.start();
            }
        });
        this.aZ = ObjectAnimator.ofInt(this, this.aW, new int[]{0, 60});
        this.aZ.setInterpolator(new PathInterpolator(0.576f, 0.16f, 0.421f, 0.853f));
        this.aZ.addListener(new Animator.AnimatorListener() {
            public void onAnimationCancel(Animator animator) {
            }

            public void onAnimationRepeat(Animator animator) {
            }

            public void onAnimationStart(Animator animator) {
            }

            public void onAnimationEnd(Animator animator) {
                int unused = MainShutterButton.this.C = 0;
                int unused2 = MainShutterButton.this.w = 0;
                if (6 == MainShutterButton.this.p && "button_shape_dial_rotate".equals(MainShutterButton.this.as)) {
                    MainShutterButton.this.setButtonType(1);
                }
            }
        });
    }

    private void w() {
        this.bk = new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float unused = MainShutterButton.this.al = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                float h = MainShutterButton.this.al - ((float) MainShutterButton.this.r);
                if (MainShutterButton.this.aH == null) {
                    MainShutterButton mainShutterButton = MainShutterButton.this;
                    float f = h / 2.0f;
                    RectF unused2 = mainShutterButton.aH = new RectF((((float) (mainShutterButton.getWidth() / 2)) - MainShutterButton.this.al) + f, (((float) (MainShutterButton.this.getHeight() / 2)) - MainShutterButton.this.al) + f, (((float) (MainShutterButton.this.getWidth() / 2)) + MainShutterButton.this.al) - f, (((float) (MainShutterButton.this.getWidth() / 2)) + MainShutterButton.this.al) - f);
                } else {
                    float f2 = h / 2.0f;
                    MainShutterButton.this.aH.set((((float) (MainShutterButton.this.getWidth() / 2)) - MainShutterButton.this.al) + f2, (((float) (MainShutterButton.this.getHeight() / 2)) - MainShutterButton.this.al) + f2, (((float) (MainShutterButton.this.getWidth() / 2)) + MainShutterButton.this.al) - f2, (((float) (MainShutterButton.this.getWidth() / 2)) + MainShutterButton.this.al) - f2);
                }
                MainShutterButton.this.aP.setStrokeWidth(h);
                float unused3 = MainShutterButton.this.E = h;
                if (MainShutterButton.this.aL != null) {
                    MainShutterButton.this.aL.setStrokeWidth(h);
                }
                MainShutterButton.this.invalidate();
            }
        };
        this.bb = ValueAnimator.ofFloat(new float[]{(float) this.q, (float) this.D});
        this.bb.setInterpolator(new PathInterpolator(0.33f, 0.0f, 0.66f, 1.0f));
        this.bb.setDuration(100);
        this.bb.addUpdateListener(this.bk);
        this.bc = ValueAnimator.ofFloat(new float[]{(float) this.D, (float) this.q});
        this.bc.setInterpolator(new PathInterpolator(0.33f, 0.0f, 0.66f, 1.0f));
        this.bc.setDuration(100);
        this.bc.addUpdateListener(this.bk);
    }

    private void x() {
        this.bf = ValueAnimator.ofInt(new int[]{0, 255});
        this.bf.setInterpolator(AnimationUtils.loadInterpolator(getContext(), R.anim.accelerate_decelerate_path_interpolator));
        this.bf.setDuration(440);
        this.bf.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int unused = MainShutterButton.this.ab = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                MainShutterButton.this.invalidate();
            }
        });
    }

    public void c() {
        if (this.bf == null) {
            x();
        }
        ValueAnimator valueAnimator = this.bf;
        if (valueAnimator != null) {
            valueAnimator.start();
        }
    }

    /* access modifiers changed from: private */
    public void y() {
        this.aZ.setIntValues(new int[]{this.C, 120});
        this.aZ.setDuration((long) (((120 - this.C) * 800) / 120));
    }

    private void z() {
        this.aX = null;
        this.aY = null;
        this.aZ = null;
        this.ba = null;
        this.bb = null;
        this.bc = null;
        ValueAnimator valueAnimator = this.bd;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.bd = null;
        }
        ValueAnimator valueAnimator2 = this.be;
        if (valueAnimator2 != null) {
            valueAnimator2.cancel();
            this.be = null;
        }
        ValueAnimator valueAnimator3 = this.bf;
        if (valueAnimator3 != null) {
            valueAnimator3.cancel();
            this.bf = null;
        }
    }

    public int getDialValue() {
        return this.C;
    }

    public void setDialValue(int i) {
        this.C = i;
        invalidate();
    }

    public void d() {
        ObjectAnimator objectAnimator = this.aX;
        if (objectAnimator != null) {
            objectAnimator.start();
        }
    }

    private void A() {
        ValueAnimator valueAnimator = this.ba;
        if (valueAnimator != null) {
            valueAnimator.setDuration((long) this.B);
            this.ba.start();
        }
    }

    public void e() {
        e.a("MainShutterButton", "pauseFastVideoDialAnimator");
        ObjectAnimator objectAnimator = this.aY;
        if (objectAnimator != null && objectAnimator.isRunning()) {
            this.aY.pause();
        }
    }

    public void f() {
        ValueAnimator valueAnimator = this.ba;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.ba.resume();
        }
    }

    public void g() {
        ValueAnimator valueAnimator = this.ba;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.ba.pause();
        }
    }

    public void h() {
        e.a("MainShutterButton", "resumeFastVideoDialAnimator");
        ObjectAnimator objectAnimator = this.aY;
        if (objectAnimator != null) {
            objectAnimator.resume();
        }
    }

    public void setShutterButtonTime(int i) {
        this.B = i;
    }

    public void setShutterButtonProgress(float f) {
        if (this.p != 12) {
            e.e("MainShutterButton", "setShutterButtonProgress, button type is error, mButtonType: " + this.p);
            return;
        }
        e.a("MainShutterButton", "setShutterButtonProgress, progress: " + f);
        this.W = (int) (f * 360.0f);
        if (this.W > 360) {
            this.W = 360;
        }
        invalidate();
    }

    private void B() {
        if (this.bg == null) {
            this.bg = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
            this.bg.setDuration(300);
            this.bg.setInterpolator(new PathInterpolator(0.17f, 0.0f, 0.83f, 1.0f));
            this.bg.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float unused = MainShutterButton.this.aq = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    MainShutterButton.this.invalidate();
                }
            });
            this.bg.addListener(new Animator.AnimatorListener() {
                public void onAnimationCancel(Animator animator) {
                }

                public void onAnimationRepeat(Animator animator) {
                }

                public void onAnimationStart(Animator animator) {
                }

                public void onAnimationEnd(Animator animator) {
                    MainShutterButton.this.setButtonTypeAndInvalidate(20);
                }
            });
        }
        this.bg.start();
    }

    private void C() {
        if (this.bi == null) {
            this.bi = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
            this.bi.setDuration(300);
            this.bi.setInterpolator(new PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f));
            this.bi.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float unused = MainShutterButton.this.aq = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    MainShutterButton.this.invalidate();
                }
            });
            this.bi.addListener(new Animator.AnimatorListener() {
                public void onAnimationCancel(Animator animator) {
                }

                public void onAnimationRepeat(Animator animator) {
                }

                public void onAnimationStart(Animator animator) {
                }

                public void onAnimationEnd(Animator animator) {
                    MainShutterButton.this.setButtonTypeAndInvalidate(1);
                }
            });
        }
        this.bi.start();
    }

    private void D() {
        if (this.bj == null) {
            this.bj = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
            this.bj.setDuration(300);
            this.bj.setInterpolator(new PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f));
            this.bj.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float unused = MainShutterButton.this.aq = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    MainShutterButton.this.invalidate();
                }
            });
            this.bj.addListener(new Animator.AnimatorListener() {
                public void onAnimationCancel(Animator animator) {
                }

                public void onAnimationRepeat(Animator animator) {
                }

                public void onAnimationStart(Animator animator) {
                }

                public void onAnimationEnd(Animator animator) {
                    MainShutterButton.this.setButtonTypeAndInvalidate(1);
                }
            });
        }
        this.bj.start();
    }

    private void E() {
        if (this.bh == null) {
            this.bh = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
            this.bh.setDuration(300);
            this.bh.setInterpolator(new PathInterpolator(0.3f, 0.0f, 0.1f, 1.0f));
            this.bh.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float unused = MainShutterButton.this.aq = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    MainShutterButton.this.invalidate();
                }
            });
            this.bh.addListener(new Animator.AnimatorListener() {
                public void onAnimationCancel(Animator animator) {
                }

                public void onAnimationRepeat(Animator animator) {
                }

                public void onAnimationStart(Animator animator) {
                }

                public void onAnimationEnd(Animator animator) {
                    MainShutterButton.this.setButtonTypeAndInvalidate(21);
                }
            });
        }
        this.bh.start();
    }

    private void b(Canvas canvas, boolean z2) {
        canvas.save();
        canvas.translate(((float) getWidth()) / 2.0f, ((float) getHeight()) / 2.0f);
        canvas.rotate(180.0f);
        int i = 0;
        while (i < 60) {
            if (!z2) {
                int i2 = this.s;
                int i3 = this.af;
                canvas.drawLine(0.0f, (float) (i2 + i3), 0.0f, (float) (i2 + i3 + this.ac), this.aQ);
            } else if (i % 5 == 0) {
                int i4 = this.s;
                int i5 = this.ai;
                canvas.drawLine(0.0f, (float) (i4 + i5), 0.0f, (float) (i4 + i5 + this.ag), this.aQ);
            } else {
                int i6 = this.C;
                if (i6 <= 60 || i6 == 0) {
                    int i7 = i == this.C ? this.ai : this.ad;
                    int i8 = i == this.C ? this.ag : this.ac;
                    if (i >= this.C) {
                        int i9 = this.s;
                        canvas.drawLine(0.0f, (float) (i9 + i7), 0.0f, (float) (i9 + i7 + i8), this.aQ);
                    }
                } else {
                    int i10 = i == i6 + -60 ? this.ai : this.ad;
                    int i11 = i == this.C - 60 ? this.ag : this.ac;
                    int i12 = this.C;
                    if (i <= i12 - 60 || i12 == 0) {
                        int i13 = this.s;
                        canvas.drawLine(0.0f, (float) (i13 + i10), 0.0f, (float) (i13 + i10 + i11), this.aQ);
                    }
                }
            }
            canvas.rotate(6.0f, 0.0f, 0.0f);
            i++;
        }
        canvas.restore();
    }

    private void a(Canvas canvas) {
        if (!"button_shape_ring_none".equals(this.as)) {
            int i = this.p;
            if (i != 9) {
                switch (i) {
                    case 1:
                    case 2:
                    case 5:
                        break;
                    case 3:
                    case 4:
                        if ("button_shape_dial_still".equals(this.as)) {
                            this.av = false;
                            b(canvas, this.av);
                            return;
                        }
                        return;
                    case 6:
                        if ("button_shape_dial_still".equals(this.as)) {
                            this.av = false;
                            b(canvas, this.av);
                            return;
                        } else if ("button_shape_dial_rotate".equals(this.as)) {
                            ObjectAnimator objectAnimator = this.aY;
                            if (objectAnimator != null && objectAnimator.isRunning()) {
                                this.aY.cancel();
                            }
                            this.av = true;
                            b(canvas, this.av);
                            return;
                        } else {
                            return;
                        }
                    default:
                        return;
                }
            }
            if ("button_shape_dial_still".equals(this.as)) {
                this.av = false;
                b(canvas, this.av);
            } else if ("button_shape_dial_rotate".equals(this.as)) {
                this.av = true;
                b(canvas, this.av);
            } else if ("button_shape_countdown_ten_seconds".equals(this.as)) {
                Bitmap bitmap = this.aB;
                if (bitmap == null) {
                    this.aB = a(bitmap, (int) R.drawable.countdown_10s_selector);
                }
                a(canvas, this.aB);
            } else if ("button_shape_countdown_three_seconds".equals(this.as)) {
                Bitmap bitmap2 = this.aA;
                if (bitmap2 == null) {
                    this.aA = a(bitmap2, (int) R.drawable.countdown_3s_selector);
                }
                a(canvas, this.aA);
            } else if ("button_shape_next_step".equals(this.as)) {
                Bitmap bitmap3 = this.aC;
                if (bitmap3 == null) {
                    this.aC = a(bitmap3, (int) R.drawable.ic_next_step);
                }
                b(canvas, this.aC);
            } else if ("button_shape_complete".equals(this.as)) {
                Bitmap bitmap4 = this.aD;
                if (bitmap4 == null) {
                    this.aD = a(bitmap4, (int) R.drawable.ic_complete);
                }
                b(canvas, this.aD);
            }
        }
    }

    public int getShutterPadding() {
        return (getMeasuredHeight() / 2) - this.q;
    }
}
