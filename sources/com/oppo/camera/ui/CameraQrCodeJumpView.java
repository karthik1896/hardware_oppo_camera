package com.oppo.camera.ui;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.oppo.camera.R;
import com.oppo.camera.e;
import com.oppo.camera.ui.l;
import com.oppo.camera.util.Util;

public class CameraQrCodeJumpView extends LinearLayout {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public String f3772a = "CameraQrCodeJumpView";
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public boolean f3773b = false;
    /* access modifiers changed from: private */
    public boolean c = false;
    private int d = 0;
    private int e = 0;
    /* access modifiers changed from: private */
    public a f = new a();
    private l g = null;
    private Handler h = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message message) {
            String a2 = CameraQrCodeJumpView.this.f3772a;
            e.a(a2, "handleMessage, what: " + message.what);
            if (message.what == 1) {
                CameraQrCodeJumpView.this.a(true);
            }
        }
    };
    private l.a i = new l.a() {
        public void a(int i) {
            CameraQrCodeJumpView.this.f();
        }

        public boolean a() {
            return CameraQrCodeJumpView.this.getVisibility() == 0;
        }

        public void a(float f) {
            CameraQrCodeJumpView.this.setAlpha(f);
        }
    };

    public CameraQrCodeJumpView(Context context) {
        super(context);
    }

    public CameraQrCodeJumpView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CameraQrCodeJumpView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public CameraQrCodeJumpView(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
    }

    public void a(boolean z, boolean z2) {
        e.a(this.f3772a, "showQrCodeJumpView");
        if (!this.c) {
            setVisibility(0);
            if (z2) {
                setAlpha(0.0f);
                this.f.a(0);
            }
            setOrientation(this.d);
            if (z) {
                a();
            }
        }
    }

    public void a() {
        e.a(this.f3772a, "startHideDelay");
        this.h.removeMessages(1);
        this.h.sendEmptyMessageDelayed(1, 2500);
    }

    public void a(boolean z) {
        e.a(this.f3772a, "hideQrCodeJumpView");
        if (!this.c && b()) {
            setAlpha(0.0f);
            setOrientation(this.d);
            if (z) {
                this.f.a(1);
            } else {
                setVisibility(8);
            }
        }
    }

    public boolean b() {
        return getVisibility() == 0;
    }

    public void c() {
        this.c = true;
        this.d = -1;
        clearAnimation();
    }

    public void clearAnimation() {
        this.f3773b = false;
        super.clearAnimation();
    }

    public void d() {
        this.c = false;
    }

    public void setOrientation(int i2) {
        int i3 = this.d;
        this.d = i2;
        if (this.g == null) {
            g();
        }
        if (-1 == i2) {
            i2 = 0;
        }
        if (i2 % 180 == 0) {
            i2 = 0;
        }
        if (i3 != i2) {
            l.a aVar = this.i;
            if (aVar != null && aVar.a() && !this.g.b() && this.g.a() != i2) {
                startAnimation(this.g);
            }
            this.g.a(i2, true);
        }
    }

    /* access modifiers changed from: private */
    public void f() {
        int i2 = this.d;
        if (-1 == i2) {
            i2 = 0;
        }
        this.d = i2;
        int i3 = this.d;
        if (i3 % 180 == 0) {
            i3 = 0;
        }
        this.d = i3;
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        if (measuredWidth == 0 || measuredHeight == 0) {
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE);
            measure(makeMeasureSpec, makeMeasureSpec);
            measuredWidth = getMeasuredWidth();
            measuredHeight = getMeasuredHeight();
        }
        int i4 = this.d;
        if (i4 == 90) {
            layoutParams.addRule(11);
            layoutParams.addRule(3, R.id.oppo_setting_bar);
            int i5 = (measuredWidth / 2) - (measuredHeight / 2);
            layoutParams.rightMargin = (-i5) + getResources().getDimensionPixelSize(R.dimen.qr_code_horizontal_margin_bottom);
            layoutParams.topMargin = i5 + ((this.e - measuredWidth) / 2) + Util.u();
            layoutParams.bottomMargin = 0;
        } else if (i4 != 270) {
            layoutParams.addRule(14);
            layoutParams.addRule(2, R.id.control_panel_layout);
            layoutParams.bottomMargin = getResources().getDimensionPixelSize(R.dimen.qr_code_vertical_margin_bottom);
        } else {
            layoutParams.addRule(9);
            int i6 = (measuredWidth / 2) - (measuredHeight / 2);
            layoutParams.topMargin = ((this.e - measuredWidth) / 2) + i6 + Util.u();
            layoutParams.leftMargin = (-i6) + getResources().getDimensionPixelSize(R.dimen.qr_code_horizontal_margin_bottom);
            layoutParams.bottomMargin = 0;
        }
        e.e(this.f3772a, "mOrientation: " + this.d + ", default: " + this.e + ", width: " + measuredWidth + ", height: " + measuredHeight);
        setLayoutParams(layoutParams);
        setRotation((float) (-this.d));
    }

    private void g() {
        this.g = new l(1.0f, 0.0f);
        this.g.setDuration(300);
        this.g.a(this.i);
    }

    public void setDefaultPreviewHeight(int i2) {
        this.e = i2;
    }

    public int getOrientation() {
        return this.d;
    }

    private class a extends Animation implements Animation.AnimationListener {

        /* renamed from: b  reason: collision with root package name */
        private float f3777b = 1.0f;
        private float c = 0.0f;
        private int d = 0;

        public void onAnimationRepeat(Animation animation) {
        }

        public a() {
            setAnimationListener(this);
        }

        public void a(int i) {
            String a2 = CameraQrCodeJumpView.this.f3772a;
            e.a(a2, "startScreenAnimation, animationType: " + i);
            if (i == 0) {
                boolean unused = CameraQrCodeJumpView.this.f3773b = false;
                a(80, 330);
                setInterpolator(CameraQrCodeJumpView.this.getContext(), R.anim.hint_view_show_alpha_path_interpolator);
                this.c = 0.0f;
                this.f3777b = 1.0f;
            } else if (i != 1) {
                a(0, 300);
            } else {
                boolean unused2 = CameraQrCodeJumpView.this.f3773b = false;
                a(0, 160);
                setInterpolator(CameraQrCodeJumpView.this.getContext(), R.anim.alpha_path_interpolator);
                this.c = 1.0f;
                this.f3777b = 0.0f;
            }
            this.d = i;
            if (!CameraQrCodeJumpView.this.f3773b || CameraQrCodeJumpView.this.c) {
                CameraQrCodeJumpView cameraQrCodeJumpView = CameraQrCodeJumpView.this;
                boolean unused3 = cameraQrCodeJumpView.f3773b = !cameraQrCodeJumpView.c;
                if (CameraQrCodeJumpView.this.c) {
                    CameraQrCodeJumpView.this.setAlpha(this.f3777b);
                    return;
                }
                CameraQrCodeJumpView.this.clearAnimation();
                CameraQrCodeJumpView cameraQrCodeJumpView2 = CameraQrCodeJumpView.this;
                cameraQrCodeJumpView2.startAnimation(cameraQrCodeJumpView2.f);
            }
        }

        private void a(int i, int i2) {
            setStartOffset((long) i);
            setDuration((long) i2);
        }

        /* access modifiers changed from: protected */
        public void applyTransformation(float f, Transformation transformation) {
            if (!CameraQrCodeJumpView.this.c) {
                float f2 = this.c;
                CameraQrCodeJumpView.this.setAlpha(f2 + ((this.f3777b - f2) * f));
            }
        }

        public void onAnimationEnd(Animation animation) {
            String a2 = CameraQrCodeJumpView.this.f3772a;
            e.a(a2, "onAnimationEnd(), mAnimationType: " + this.d);
            int i = this.d;
            if (i == 0) {
                CameraQrCodeJumpView.this.setAlpha(this.f3777b);
            } else if (i == 1) {
                CameraQrCodeJumpView.this.setVisibility(8);
            }
        }

        public void onAnimationStart(Animation animation) {
            String a2 = CameraQrCodeJumpView.this.f3772a;
            e.a(a2, "onAnimationStart(), mbActivityPause: " + CameraQrCodeJumpView.this.c);
            if (!CameraQrCodeJumpView.this.c) {
                boolean unused = CameraQrCodeJumpView.this.f3773b = true;
                CameraQrCodeJumpView.this.setAlpha(this.c);
            }
        }
    }

    public int getLayoutDirection() {
        return getContext().getResources().getConfiguration().getLayoutDirection();
    }

    public void e() {
        this.d = -1;
    }
}
