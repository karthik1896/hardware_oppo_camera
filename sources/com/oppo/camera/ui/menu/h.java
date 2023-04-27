package com.oppo.camera.ui.menu;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BlendMode;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.PathInterpolator;
import android.widget.ImageView;
import com.oppo.camera.R;
import com.oppo.camera.k;
import com.oppo.camera.ui.f;
import com.oppo.camera.ui.inverse.a;
import com.oppo.camera.util.Util;

/* compiled from: RotationOptionItemView */
public class h extends ImageView implements a {
    private Bitmap A = null;
    private Paint B = new Paint();
    private String C = null;
    private Paint D = null;
    private String E = null;
    private String F = null;
    private Paint G = null;
    private Paint H = null;
    private Paint I = null;
    private Paint J = null;
    private Matrix K = null;
    private k L = null;
    private ValueAnimator M = null;
    private ValueAnimator N = null;
    private ValueAnimator O = null;
    private int P = 0;
    private int Q = 0;
    private int R = 0;
    private int S = 0;
    private int T = 0;
    private int U = 0;
    private int V = 0;
    private int W = 0;

    /* renamed from: a  reason: collision with root package name */
    private PathInterpolator f4098a = new PathInterpolator(0.28f, 0.0f, 0.17f, 1.0f);
    private int aa = 0;
    private int ab = 0;
    private int ac = 0;
    private int ad = 0;
    private long ae = 0;
    private long af = 0;
    private f ag = null;

    /* renamed from: b  reason: collision with root package name */
    private PathInterpolator f4099b = new PathInterpolator(0.28f, 0.0f, 0.05f, 1.0f);
    /* access modifiers changed from: private */
    public float c = 0.0f;
    /* access modifiers changed from: private */
    public float d = 1.0f;
    /* access modifiers changed from: private */
    public float e = 0.0f;
    private boolean f = false;
    private boolean g = true;
    private boolean h = false;
    /* access modifiers changed from: private */
    public boolean i = false;
    private boolean j = false;
    private boolean k = false;
    private boolean l = false;
    private boolean m = false;
    private boolean n = false;
    private boolean o = false;
    private boolean p = false;
    private Context q = null;
    private Canvas r = null;
    private Drawable s = null;
    private Drawable t = null;
    private Bitmap u = null;
    private Bitmap v = null;
    private Bitmap w = null;
    private Bitmap x = null;
    private Bitmap y = null;
    private Bitmap z = null;

    public h(Context context, f fVar, boolean z2, Bitmap bitmap, boolean z3, boolean z4, k kVar) {
        super(context);
        this.q = context;
        this.ag = fVar;
        this.h = z2;
        this.w = bitmap;
        this.j = z3;
        this.o = z4;
        this.L = kVar;
        if (this.h) {
            this.V = this.q.getResources().getDimensionPixelSize(R.dimen.sub_menu_layout_height);
            this.U = this.q.getResources().getDimensionPixelSize(R.dimen.sub_menu_item_layout_width);
        } else {
            this.V = this.q.getResources().getDimensionPixelSize(R.dimen.menu_indicator_layout_height);
            this.U = this.q.getResources().getDimensionPixelSize(R.dimen.menu_indicator_layout_width);
        }
        this.F = this.q.getResources().getString(R.string.camera_sub_setting_menu_description_setting_title);
        this.aa = this.q.getResources().getDimensionPixelSize(R.dimen.sub_menu_text_length);
        this.ab = this.q.getResources().getDimensionPixelSize(R.dimen.sub_menu_text_length_land);
        if (this.w != null) {
            setOnTouchListener(new View.OnTouchListener() {
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    Rect rect = new Rect();
                    view.getHitRect(rect);
                    if (1 != motionEvent.getAction() || !rect.contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                        return false;
                    }
                    boolean unused = h.this.i = true;
                    return false;
                }
            });
        }
        b();
    }

    private void b() {
        setLayerType(1, (Paint) null);
        this.H = new Paint();
        this.H.setMaskFilter(new BlurMaskFilter(4.0f, BlurMaskFilter.Blur.OUTER));
        this.H.setColor(getResources().getColor(R.color.color_black_with_70_percent_transparency));
    }

    public void setShadowOn(boolean z2) {
        this.o = z2;
    }

    public boolean getShadowOn() {
        return this.o;
    }

    public void setMenuName(String str) {
        this.E = str;
    }

    public void setSwitchIconNeedAnim(boolean z2) {
        this.k = z2;
    }

    public void setOffAnimIcon(Bitmap bitmap) {
        this.x = bitmap;
        Bitmap bitmap2 = this.x;
        if (bitmap2 != null) {
            this.z = Bitmap.createScaledBitmap(bitmap2.extractAlpha(), this.x.getWidth(), this.x.getHeight(), true);
        }
    }

    private void c() {
        if (this.N == null) {
            this.N = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
            this.N.setInterpolator(this.f4098a);
            this.N.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float unused = h.this.d = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    h.this.postInvalidate();
                }
            });
            this.N.setDuration(583);
        }
        this.N.cancel();
        this.N.start();
    }

    private void d() {
        if (this.O == null) {
            this.O = ValueAnimator.ofFloat(new float[]{0.001f, 1.0f});
            this.O.setInterpolator(this.f4098a);
            this.O.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float unused = h.this.e = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    h.this.postInvalidate();
                }
            });
            this.O.setDuration(583);
        }
        this.O.cancel();
        this.O.start();
        this.p = true;
    }

    private void e() {
        if (this.M == null) {
            this.M = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
            this.M.setInterpolator(this.f4098a);
            this.M.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float unused = h.this.c = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    h.this.postInvalidate();
                }
            });
            this.M.setDuration(583);
        }
        this.M.cancel();
        this.M.start();
    }

    public void a(Drawable drawable, boolean z2) {
        if (this.k) {
            this.p = false;
            this.s = this.t;
            this.u = this.v;
        }
        this.j = z2;
        refreshDrawableState();
        setImageDrawable(drawable);
        this.v = Util.a(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        this.r = new Canvas(this.v);
        f();
        this.t = drawable;
        if (this.i) {
            this.i = false;
            if (!this.j) {
                c();
                if (this.k && !this.t.equals(this.s)) {
                    d();
                }
            } else if (this.w != null) {
                e();
            }
        } else {
            if (this.j) {
                this.c = 1.0f;
                this.d = 0.0f;
            } else {
                this.c = 0.0f;
                this.d = 1.0f;
            }
            if (this.k && !this.t.equals(this.s)) {
                d();
            }
        }
        invalidate();
    }

    private void f() {
        Drawable drawable = getDrawable();
        if (this.v == null) {
            this.v = Util.a(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
            this.v.setDensity(Util.f4603a);
            this.r = new Canvas(this.v);
        }
        drawable.setBounds(0, 0, this.r.getWidth(), this.r.getHeight());
        this.r.drawColor(0, BlendMode.CLEAR);
        drawable.draw(this.r);
    }

    public void a(boolean z2, int i2, int i3) {
        boolean z3 = true;
        if (!z2) {
            this.G = null;
        } else if (this.G == null) {
            this.G = new Paint();
            this.G.setAntiAlias(true);
            this.G.setColor(this.q.getResources().getColor(R.color.camera_red_dot_hint_color, (Resources.Theme) null));
        }
        if (this.l == z2) {
            z3 = false;
        }
        this.l = z2;
        this.ac = i2;
        this.ad = i3;
        if (z3) {
            invalidate();
        }
    }

    public void setItemText(String str) {
        if (!TextUtils.equals(this.C, str)) {
            this.C = str;
            i();
            j();
        }
    }

    public void setEnabled(boolean z2) {
        super.setEnabled(z2);
        setClickable(z2);
        setAlpha(z2 ? 1.0f : 0.5f);
    }

    public void a(int i2, boolean z2) {
        boolean z3 = false;
        if (isShown()) {
            this.g = z2;
        } else {
            this.g = false;
        }
        int i3 = i2 >= 0 ? i2 % 360 : (i2 % 360) + 360;
        if (i3 != this.R) {
            this.R = i3;
            j();
            if (this.g) {
                this.Q = this.P;
                this.ae = AnimationUtils.currentAnimationTimeMillis();
                int i4 = this.R - this.P;
                if (i4 < 0) {
                    i4 += 360;
                }
                if (i4 > 180) {
                    i4 -= 360;
                }
                if (i4 >= 0) {
                    z3 = true;
                }
                this.f = z3;
                this.af = this.ae + ((long) ((Math.abs(i4) * 1000) / 360));
            } else {
                this.P = this.R;
            }
            invalidate();
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        super.onLayout(z2, i2, i3, i4, i5);
        this.S = i4 - i2;
        this.T = i5 - i3;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:133:0x0380, code lost:
        if (r4 > 255) goto L_0x0364;
     */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x0255  */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x03ce  */
    /* JADX WARNING: Removed duplicated region for block: B:145:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x014b  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x024a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onDraw(android.graphics.Canvas r17) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r16.f()
            boolean r2 = r0.h
            if (r2 == 0) goto L_0x001b
            android.content.Context r2 = r0.q
            android.content.res.Resources r2 = r2.getResources()
            r3 = 2131166884(0x7f0706a4, float:1.7948026E38)
            int r2 = r2.getDimensionPixelSize(r3)
            r0.T = r2
            goto L_0x0021
        L_0x001b:
            int r2 = com.oppo.camera.util.Util.u()
            r0.T = r2
        L_0x0021:
            int r2 = r0.P
            int r3 = r0.R
            if (r2 == r3) goto L_0x0059
            long r2 = android.view.animation.AnimationUtils.currentAnimationTimeMillis()
            long r4 = r0.af
            int r4 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r4 >= 0) goto L_0x0055
            long r4 = r0.ae
            long r2 = r2 - r4
            int r2 = (int) r2
            int r3 = r0.Q
            long r3 = (long) r3
            boolean r5 = r0.f
            if (r5 == 0) goto L_0x003d
            goto L_0x003e
        L_0x003d:
            int r2 = -r2
        L_0x003e:
            int r2 = r2 * 360
            long r5 = (long) r2
            r7 = 1000(0x3e8, double:4.94E-321)
            long r5 = r5 / r7
            long r3 = r3 + r5
            int r2 = (int) r3
            if (r2 < 0) goto L_0x004b
            int r2 = r2 % 360
            goto L_0x004f
        L_0x004b:
            int r2 = r2 % 360
            int r2 = r2 + 360
        L_0x004f:
            r0.P = r2
            r16.invalidate()
            goto L_0x0059
        L_0x0055:
            int r2 = r0.R
            r0.P = r2
        L_0x0059:
            android.content.Context r2 = r0.q
            android.content.res.Resources r2 = r2.getResources()
            r3 = 2131166722(0x7f070602, float:1.7947697E38)
            int r2 = r2.getDimensionPixelSize(r3)
            boolean r3 = com.oppo.camera.util.Util.Q()
            if (r3 == 0) goto L_0x007e
            boolean r3 = r0.h
            if (r3 != 0) goto L_0x007e
            android.content.Context r2 = r0.q
            android.content.res.Resources r2 = r2.getResources()
            r3 = 2131165948(0x7f0702fc, float:1.7946128E38)
            int r2 = r2.getDimensionPixelSize(r3)
            goto L_0x0083
        L_0x007e:
            boolean r3 = r0.h
            if (r3 == 0) goto L_0x0085
            r2 = 0
        L_0x0083:
            r3 = 0
            goto L_0x0087
        L_0x0085:
            r3 = r2
            r2 = 0
        L_0x0087:
            int r5 = r0.P
            int r5 = -r5
            float r5 = (float) r5
            int r6 = r0.S
            float r6 = (float) r6
            r7 = 1073741824(0x40000000, float:2.0)
            float r6 = r6 / r7
            int r8 = r0.T
            float r8 = (float) r8
            float r8 = r8 / r7
            float r9 = (float) r2
            float r8 = r8 + r9
            float r10 = (float) r3
            float r8 = r8 + r10
            r1.rotate(r5, r6, r8)
            java.lang.String r5 = r0.C
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            boolean r6 = r0.h
            r8 = 0
            if (r6 == 0) goto L_0x0147
            android.graphics.Bitmap r6 = r0.v
            if (r6 == 0) goto L_0x0147
            if (r5 != 0) goto L_0x0147
            android.content.Context r3 = r0.q
            android.content.res.Resources r3 = r3.getResources()
            r4 = 2131166720(0x7f070600, float:1.7947693E38)
            int r3 = r3.getDimensionPixelSize(r4)
            int r4 = r0.S
            android.graphics.Bitmap r5 = r0.v
            int r5 = r5.getWidth()
            int r4 = r4 - r5
            float r4 = (float) r4
            float r4 = r4 / r7
            int r4 = (int) r4
            int r5 = r0.T
            android.graphics.Bitmap r6 = r0.v
            int r6 = r6.getHeight()
            int r5 = r5 - r6
            int r5 = r5 - r3
            float r5 = (float) r5
            float r5 = r5 / r7
            int r5 = (int) r5
            android.graphics.Bitmap r6 = r0.v
            float r9 = (float) r4
            int r10 = r5 + r2
            float r11 = (float) r10
            r1.drawBitmap(r6, r9, r11, r8)
            boolean r6 = r0.l
            if (r6 == 0) goto L_0x00ff
            android.graphics.Paint r6 = r0.G
            if (r6 == 0) goto L_0x00ff
            r6 = 1077936128(0x40400000, float:3.0)
            int r6 = com.oppo.camera.util.Util.a((float) r6)
            float r6 = (float) r6
            android.graphics.Bitmap r8 = r0.v
            int r8 = r8.getWidth()
            int r4 = r4 + r8
            int r8 = r0.ac
            int r4 = r4 + r8
            float r4 = (float) r4
            int r8 = r0.ad
            int r10 = r10 + r8
            float r8 = (float) r10
            android.graphics.Paint r9 = r0.G
            r1.drawCircle(r4, r8, r6, r9)
        L_0x00ff:
            android.graphics.Bitmap r4 = r0.v
            int r4 = r4.getHeight()
            int r5 = r5 + r4
            int r5 = r5 + r3
            android.graphics.Paint r3 = r0.D
            java.lang.String r4 = r0.C
            float r3 = r3.measureText(r4)
            int r4 = r0.R
            if (r4 == 0) goto L_0x011b
            r6 = 180(0xb4, float:2.52E-43)
            if (r4 != r6) goto L_0x0118
            goto L_0x011b
        L_0x0118:
            int r4 = r0.ab
            goto L_0x011d
        L_0x011b:
            int r4 = r0.aa
        L_0x011d:
            java.lang.String r6 = r0.C
            float r4 = (float) r4
            int r3 = (r4 > r3 ? 1 : (r4 == r3 ? 0 : -1))
            if (r3 >= 0) goto L_0x0135
            android.text.TextPaint r3 = new android.text.TextPaint
            android.graphics.Paint r8 = r0.D
            r3.<init>(r8)
            android.text.TextUtils$TruncateAt r8 = android.text.TextUtils.TruncateAt.END
            java.lang.CharSequence r3 = android.text.TextUtils.ellipsize(r6, r3, r4, r8)
            java.lang.String r6 = r3.toString()
        L_0x0135:
            r16.h()
            int r3 = r0.S
            float r3 = (float) r3
            float r3 = r3 / r7
            int r3 = (int) r3
            float r3 = (float) r3
            int r5 = r5 + r2
            float r2 = (float) r5
            android.graphics.Paint r4 = r0.D
            r1.drawText(r6, r3, r2, r4)
            goto L_0x03f0
        L_0x0147:
            android.graphics.Bitmap r6 = r0.v
            if (r6 == 0) goto L_0x03cc
            int r10 = r0.S
            int r6 = r6.getWidth()
            int r10 = r10 - r6
            float r6 = (float) r10
            float r6 = r6 / r7
            int r6 = (int) r6
            if (r5 == 0) goto L_0x0164
            int r10 = r0.T
            android.graphics.Bitmap r11 = r0.v
            int r11 = r11.getHeight()
            int r10 = r10 - r11
            float r10 = (float) r10
            float r10 = r10 / r7
            int r10 = (int) r10
            goto L_0x0165
        L_0x0164:
            r10 = 0
        L_0x0165:
            android.graphics.Bitmap r11 = r0.w
            r12 = 1138819072(0x43e10000, float:450.0)
            r13 = 0
            r14 = 1132396544(0x437f0000, float:255.0)
            r15 = 1065353216(0x3f800000, float:1.0)
            if (r11 == 0) goto L_0x01d3
            boolean r11 = r0.j
            if (r11 == 0) goto L_0x0177
            float r11 = r0.c
            goto L_0x017b
        L_0x0177:
            float r11 = r0.d
            float r11 = r15 - r11
        L_0x017b:
            float r11 = r11 * r14
            int r11 = (int) r11
            float r4 = (float) r11
            int r4 = (r4 > r13 ? 1 : (r4 == r13 ? 0 : -1))
            if (r4 <= 0) goto L_0x01d3
            android.graphics.Paint r4 = r0.B
            r4.setAlpha(r11)
            r17.save()
            int r4 = r0.S
            android.graphics.Bitmap r11 = r0.w
            int r11 = r11.getWidth()
            int r4 = r4 - r11
            float r4 = (float) r4
            float r4 = r4 / r7
            int r4 = (int) r4
            if (r5 == 0) goto L_0x01a5
            int r11 = r0.T
            android.graphics.Bitmap r8 = r0.w
            int r8 = r8.getHeight()
            int r11 = r11 - r8
            float r8 = (float) r11
            float r8 = r8 / r7
            int r8 = (int) r8
            goto L_0x01a6
        L_0x01a5:
            r8 = 0
        L_0x01a6:
            boolean r11 = r0.j
            if (r11 == 0) goto L_0x01ad
            float r11 = r0.c
            goto L_0x01af
        L_0x01ad:
            float r11 = r0.d
        L_0x01af:
            float r11 = r11 * r12
            float r4 = (float) r4
            android.graphics.Bitmap r12 = r0.w
            int r12 = r12.getWidth()
            float r12 = (float) r12
            float r12 = r12 / r7
            float r12 = r12 + r4
            int r8 = r8 + r2
            int r8 = r8 + r3
            float r8 = (float) r8
            android.graphics.Bitmap r13 = r0.w
            int r13 = r13.getHeight()
            float r13 = (float) r13
            float r13 = r13 / r7
            float r13 = r13 + r8
            r1.rotate(r11, r12, r13)
            android.graphics.Bitmap r11 = r0.w
            android.graphics.Paint r12 = r0.B
            r1.drawBitmap(r11, r4, r8, r12)
            r17.restore()
        L_0x01d3:
            android.graphics.Bitmap r4 = r0.x
            r8 = 1
            if (r4 == 0) goto L_0x0232
            boolean r4 = r0.j
            if (r4 != 0) goto L_0x01df
            float r4 = r0.d
            goto L_0x01e3
        L_0x01df:
            float r4 = r0.c
            float r4 = r15 - r4
        L_0x01e3:
            float r4 = r4 * r14
            int r4 = (int) r4
            float r11 = (float) r4
            r12 = 0
            int r11 = (r11 > r12 ? 1 : (r11 == r12 ? 0 : -1))
            if (r11 <= 0) goto L_0x0232
            android.graphics.Paint r11 = r0.B
            r11.setAlpha(r4)
            r17.save()
            int r4 = r0.S
            android.graphics.Bitmap r11 = r0.x
            int r11 = r11.getWidth()
            int r4 = r4 - r11
            float r4 = (float) r4
            float r4 = r4 / r7
            int r4 = (int) r4
            if (r5 == 0) goto L_0x020e
            int r11 = r0.T
            android.graphics.Bitmap r12 = r0.x
            int r12 = r12.getHeight()
            int r11 = r11 - r12
            float r11 = (float) r11
            float r11 = r11 / r7
            int r11 = (int) r11
            goto L_0x020f
        L_0x020e:
            r11 = 0
        L_0x020f:
            boolean r12 = r0.m
            if (r12 == 0) goto L_0x0222
            r16.g()
            android.graphics.Bitmap r12 = r0.y
            float r4 = (float) r4
            int r11 = r11 + r2
            int r11 = r11 + r3
            float r11 = (float) r11
            android.graphics.Paint r13 = r0.B
            r1.drawBitmap(r12, r4, r11, r13)
            goto L_0x022d
        L_0x0222:
            android.graphics.Bitmap r12 = r0.x
            float r4 = (float) r4
            int r11 = r11 + r2
            int r11 = r11 + r3
            float r11 = (float) r11
            android.graphics.Paint r13 = r0.B
            r1.drawBitmap(r12, r4, r11, r13)
        L_0x022d:
            r17.restore()
            r4 = r8
            goto L_0x0233
        L_0x0232:
            r4 = 0
        L_0x0233:
            boolean r11 = r0.k
            if (r11 == 0) goto L_0x02f3
            boolean r11 = r0.p
            if (r11 == 0) goto L_0x02f3
            float r11 = r0.e
            r12 = 0
            int r12 = (r11 > r12 ? 1 : (r11 == r12 ? 0 : -1))
            if (r12 <= 0) goto L_0x02f3
            int r11 = (r11 > r15 ? 1 : (r11 == r15 ? 0 : -1))
            if (r11 >= 0) goto L_0x02f3
            android.graphics.Matrix r8 = r0.K
            if (r8 != 0) goto L_0x0251
            android.graphics.Matrix r8 = new android.graphics.Matrix
            r8.<init>()
            r0.K = r8
        L_0x0251:
            android.graphics.Paint r8 = r0.J
            if (r8 != 0) goto L_0x025c
            android.graphics.Paint r8 = new android.graphics.Paint
            r8.<init>()
            r0.J = r8
        L_0x025c:
            boolean r8 = r0.j
            if (r8 != 0) goto L_0x0262
            if (r4 != 0) goto L_0x028d
        L_0x0262:
            r17.save()
            float r4 = r0.e
            r8 = 1138819072(0x43e10000, float:450.0)
            float r4 = r4 * r8
            float r8 = (float) r6
            android.graphics.Bitmap r11 = r0.w
            int r11 = r11.getWidth()
            float r11 = (float) r11
            float r11 = r11 / r7
            float r11 = r11 + r8
            int r12 = r10 + r2
            int r12 = r12 + r3
            float r12 = (float) r12
            android.graphics.Bitmap r13 = r0.w
            int r13 = r13.getHeight()
            float r13 = (float) r13
            float r13 = r13 / r7
            float r13 = r13 + r12
            r1.rotate(r4, r11, r13)
            android.graphics.Bitmap r4 = r0.w
            r11 = 0
            r1.drawBitmap(r4, r8, r12, r11)
            r17.restore()
        L_0x028d:
            android.graphics.Matrix r4 = r0.K
            float r8 = (float) r6
            int r11 = r10 + r2
            int r11 = r11 + r3
            float r3 = (float) r11
            r4.setTranslate(r8, r3)
            android.graphics.Matrix r4 = r0.K
            float r11 = r0.e
            float r12 = r15 - r11
            float r11 = r15 - r11
            int r13 = r0.S
            float r13 = (float) r13
            float r13 = r13 / r7
            android.graphics.Bitmap r14 = r0.v
            int r14 = r14.getHeight()
            float r14 = (float) r14
            float r14 = r14 / r7
            float r14 = r14 + r3
            r4.postScale(r12, r11, r13, r14)
            android.graphics.Paint r4 = r0.J
            float r11 = r0.e
            float r15 = r15 - r11
            r11 = 1132396544(0x437f0000, float:255.0)
            float r15 = r15 * r11
            int r11 = (int) r15
            r4.setAlpha(r11)
            android.graphics.Bitmap r4 = r0.u
            android.graphics.Matrix r11 = r0.K
            android.graphics.Paint r12 = r0.J
            r1.drawBitmap(r4, r11, r12)
            android.graphics.Matrix r4 = r0.K
            r4.setTranslate(r8, r3)
            android.graphics.Matrix r4 = r0.K
            float r8 = r0.e
            int r11 = r0.S
            float r11 = (float) r11
            float r11 = r11 / r7
            android.graphics.Bitmap r12 = r0.v
            int r12 = r12.getHeight()
            float r12 = (float) r12
            float r12 = r12 / r7
            float r3 = r3 + r12
            r4.postScale(r8, r8, r11, r3)
            android.graphics.Paint r3 = r0.J
            float r4 = r0.e
            r8 = 1132396544(0x437f0000, float:255.0)
            float r4 = r4 * r8
            int r4 = (int) r4
            r3.setAlpha(r4)
            android.graphics.Bitmap r3 = r0.v
            android.graphics.Matrix r4 = r0.K
            android.graphics.Paint r8 = r0.J
            r1.drawBitmap(r3, r4, r8)
            goto L_0x03a2
        L_0x02f3:
            com.oppo.camera.k r11 = r0.L
            java.lang.String r12 = "off"
            java.lang.String r13 = "pref_subsetting_key"
            java.lang.String r11 = r11.getString(r13, r12)
            boolean r13 = r0.o
            if (r13 == 0) goto L_0x0397
            boolean r11 = r12.equals(r11)
            if (r11 == 0) goto L_0x0397
            boolean r11 = r0.m
            if (r11 != 0) goto L_0x0397
            android.graphics.Bitmap r11 = r0.v
            android.graphics.Bitmap r11 = r11.extractAlpha()
            android.graphics.Bitmap r12 = r0.v
            int r12 = r12.getWidth()
            android.graphics.Bitmap r13 = r0.v
            int r13 = r13.getHeight()
            android.graphics.Bitmap r8 = android.graphics.Bitmap.createScaledBitmap(r11, r12, r13, r8)
            r0.A = r8
            android.graphics.Bitmap r8 = r0.A
            float r11 = (float) r6
            int r12 = r10 + r2
            int r12 = r12 + r3
            float r3 = (float) r12
            android.graphics.Paint r12 = r0.H
            r1.drawBitmap(r8, r11, r3, r12)
            android.graphics.Bitmap r8 = r0.v
            r12 = 0
            r1.drawBitmap(r8, r11, r3, r12)
            android.graphics.Bitmap r8 = r0.x
            if (r8 == 0) goto L_0x03a2
            if (r4 == 0) goto L_0x03a2
            if (r8 == 0) goto L_0x03a2
            android.graphics.Bitmap r4 = r0.z
            if (r4 == 0) goto L_0x03a2
            android.graphics.Paint r4 = r0.I
            if (r4 != 0) goto L_0x034e
            android.graphics.Paint r4 = new android.graphics.Paint
            android.graphics.Paint r8 = r0.H
            r4.<init>(r8)
            r0.I = r4
        L_0x034e:
            boolean r4 = r0.j
            r8 = 1142013952(0x4411c000, float:583.0)
            r12 = 255(0xff, float:3.57E-43)
            if (r4 == 0) goto L_0x036a
            float r4 = r0.c
            float r4 = r4 * r8
            r8 = 1120403456(0x42c80000, float:100.0)
            float r4 = r4 / r8
            float r15 = r15 - r4
            r4 = 1132396544(0x437f0000, float:255.0)
            float r15 = r15 * r4
            int r4 = (int) r15
            if (r4 <= r12) goto L_0x0366
        L_0x0364:
            r4 = r12
            goto L_0x0383
        L_0x0366:
            if (r4 >= 0) goto L_0x0383
            r4 = 0
            goto L_0x0383
        L_0x036a:
            r4 = 403(0x193, float:5.65E-43)
            float r13 = r0.d
            float r14 = r13 * r8
            float r4 = (float) r4
            int r14 = (r14 > r4 ? 1 : (r14 == r4 ? 0 : -1))
            if (r14 >= 0) goto L_0x0377
            r4 = 0
            goto L_0x0380
        L_0x0377:
            float r13 = r13 * r8
            float r13 = r13 - r4
            r4 = 1127481344(0x43340000, float:180.0)
            float r13 = r13 / r4
            r4 = 1132396544(0x437f0000, float:255.0)
            float r13 = r13 * r4
            int r4 = (int) r13
        L_0x0380:
            if (r4 <= r12) goto L_0x0383
            goto L_0x0364
        L_0x0383:
            android.graphics.Paint r8 = r0.I
            r8.setAlpha(r4)
            android.graphics.Bitmap r4 = r0.z
            android.graphics.Paint r8 = r0.I
            r1.drawBitmap(r4, r11, r3, r8)
            android.graphics.Bitmap r4 = r0.x
            android.graphics.Paint r8 = r0.B
            r1.drawBitmap(r4, r11, r3, r8)
            goto L_0x03a2
        L_0x0397:
            android.graphics.Bitmap r4 = r0.v
            float r8 = (float) r6
            int r11 = r10 + r2
            int r11 = r11 + r3
            float r3 = (float) r11
            r11 = 0
            r1.drawBitmap(r4, r8, r3, r11)
        L_0x03a2:
            boolean r3 = r0.l
            if (r3 == 0) goto L_0x03cc
            android.graphics.Paint r3 = r0.G
            if (r3 == 0) goto L_0x03cc
            android.content.Context r3 = r0.q
            android.content.res.Resources r3 = r3.getResources()
            r4 = 2131166718(0x7f0705fe, float:1.794769E38)
            float r3 = r3.getDimension(r4)
            android.graphics.Bitmap r4 = r0.v
            int r4 = r4.getWidth()
            int r6 = r6 + r4
            int r4 = r0.ac
            int r6 = r6 + r4
            float r4 = (float) r6
            int r10 = r10 + r2
            int r2 = r0.ad
            int r10 = r10 + r2
            float r2 = (float) r10
            android.graphics.Paint r6 = r0.G
            r1.drawCircle(r4, r2, r3, r6)
        L_0x03cc:
            if (r5 != 0) goto L_0x03f0
            int r2 = r0.T
            float r2 = (float) r2
            float r2 = r2 / r7
            android.graphics.Paint r3 = r0.D
            float r3 = r3.descent()
            android.graphics.Paint r4 = r0.D
            float r4 = r4.ascent()
            float r3 = r3 + r4
            float r3 = r3 / r7
            float r2 = r2 - r3
            r16.h()
            java.lang.String r3 = r0.C
            int r4 = r0.S
            float r4 = (float) r4
            float r4 = r4 / r7
            float r2 = r2 + r9
            android.graphics.Paint r5 = r0.D
            r1.drawText(r3, r4, r2, r5)
        L_0x03f0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.ui.menu.h.onDraw(android.graphics.Canvas):void");
    }

    private void g() {
        if (this.y == null) {
            this.y = Util.a(this.x.getWidth(), this.x.getHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(this.y);
            Paint paint = new Paint();
            paint.setColorFilter(new PorterDuffColorFilter(getContext().getColor(R.color.inverse_text_color), PorterDuff.Mode.SRC_IN));
            canvas.drawBitmap(this.x, 0.0f, 0.0f, paint);
        }
    }

    private void h() {
        this.D.setColor(this.q.getColorStateList(R.color.menu_item_text_color_selector).getColorForState(getDrawableState(), R.color.oppo_submenu_text_color));
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int actionMasked;
        f fVar = this.ag;
        if (fVar == null || !fVar.i() || (actionMasked = motionEvent.getActionMasked()) == 3 || actionMasked == 2) {
            if (motionEvent.getActionMasked() == 3 && isEnabled()) {
                setAlpha(1.0f);
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        obtain.setAction(3);
        super.dispatchTouchEvent(obtain);
        return false;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (isEnabled()) {
            int action = motionEvent.getAction();
            if (action == 0) {
                setAlpha(0.3f);
            } else if (action == 1 || (action != 2 && action == 3)) {
                setAlpha(1.0f);
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public int getViewWidth() {
        Bitmap bitmap = this.v;
        int i2 = 0;
        if (bitmap != null) {
            i2 = 0 + bitmap.getWidth();
        }
        if (!TextUtils.isEmpty(this.C)) {
            i2 = Math.max(i2, (int) this.D.measureText(this.C));
        }
        if (!this.h) {
            return Math.max(i2, this.U);
        }
        int i3 = this.aa;
        if (i2 > i3) {
            return i3;
        }
        return this.U;
    }

    public int getViewHeight() {
        Bitmap bitmap = this.v;
        int i2 = 0;
        if (bitmap != null) {
            i2 = 0 + bitmap.getHeight();
        }
        if (!TextUtils.isEmpty(this.C)) {
            i2 = (int) (((float) i2) + (this.D.getFontMetrics().bottom - this.D.getFontMetrics().top));
        }
        int i3 = this.V;
        return i2 > i3 ? i2 : i3;
    }

    private void i() {
        if (this.D == null) {
            this.D = new Paint();
            this.D.setTextSize(this.q.getResources().getDimension(R.dimen.rotableview_text_size));
            this.D.setTextAlign(Paint.Align.CENTER);
            this.D.setFlags(1);
        }
    }

    public void setSelected(boolean z2) {
        if (this.D == null) {
            i();
        }
        super.setSelected(z2);
        invalidate();
    }

    private void j() {
        if (!TextUtils.isEmpty(this.C)) {
            this.D.setTextSize(this.q.getResources().getDimension(R.dimen.rotableview_text_size));
            int measureText = (int) this.D.measureText(this.C);
            if (this.R % 180 != 0 && measureText >= Util.y()) {
                this.D.setTextSize(this.q.getResources().getDimension(R.dimen.rotableview_text_size_small));
            }
        }
    }

    public void setSizeRatioType(int i2) {
        this.W = i2;
    }

    public void a() {
        this.q = null;
        this.v = null;
        this.r = null;
        this.D = null;
        this.C = null;
    }

    public int[] onCreateDrawableState(int i2) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i2 + 2);
        if (this.m && (this.w == null || !this.j)) {
            mergeDrawableStates(onCreateDrawableState, new int[]{R.attr.state_inverse_color});
        }
        if (this.n) {
            mergeDrawableStates(onCreateDrawableState, new int[]{R.attr.state_style_second});
        }
        return onCreateDrawableState;
    }

    public void setStateSecond(boolean z2) {
        this.n = z2;
        refreshDrawableState();
        invalidate();
    }

    public void setInverseColor(boolean z2) {
        this.m = z2;
        refreshDrawableState();
        invalidate();
    }
}
