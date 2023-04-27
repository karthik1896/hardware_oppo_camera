package com.oppo.camera.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import com.oppo.camera.R;
import com.oppo.camera.e;
import com.oppo.camera.util.Util;

public class CameraQrCodeView extends View {

    /* renamed from: a  reason: collision with root package name */
    private String f3778a = "CameraQrCodeView";

    /* renamed from: b  reason: collision with root package name */
    private Rect f3779b = new Rect();
    /* access modifiers changed from: private */
    public boolean c = false;
    private int d = 0;
    /* access modifiers changed from: private */
    public AlphaAnimation e = null;
    /* access modifiers changed from: private */
    public boolean f = false;
    private Drawable g = null;
    private Handler h = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message message) {
            if (message.what == 300 && CameraQrCodeView.this.e != null && !CameraQrCodeView.this.c && CameraQrCodeView.this.a()) {
                CameraQrCodeView cameraQrCodeView = CameraQrCodeView.this;
                cameraQrCodeView.startAnimation(cameraQrCodeView.e);
            }
        }
    };

    public CameraQrCodeView(Context context) {
        super(context);
        d();
    }

    public CameraQrCodeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        d();
    }

    public CameraQrCodeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        d();
    }

    private void d() {
        this.g = getResources().getDrawable(R.drawable.icon_face_detecte);
        this.d = Util.E();
        e();
    }

    private void e() {
        this.e = new AlphaAnimation(1.0f, 0.0f);
        this.e.setDuration(300);
        this.e.setInterpolator(new LinearInterpolator());
        this.e.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
                boolean unused = CameraQrCodeView.this.f = true;
            }

            public void onAnimationEnd(Animation animation) {
                CameraQrCodeView.this.setVisibility(4);
                boolean unused = CameraQrCodeView.this.f = false;
            }
        });
    }

    public void a(RectF rectF, int i, int i2) {
        String str = this.f3778a;
        e.a(str, "updateQrCodeSize  mbHideAnimationRunning: " + this.f + ", mPause: " + this.c + ", qrCodeSize: " + rectF);
        if (rectF != null && !this.c) {
            if (!b(rectF, i, i2)) {
                setVisibility(4);
                return;
            }
            this.h.removeMessages(300);
            setVisibility(0);
            float f2 = rectF.right - rectF.left;
            float f3 = rectF.bottom - rectF.top;
            this.f3779b.top = (int) rectF.left;
            this.f3779b.left = (int) ((((float) this.d) - rectF.top) - f3);
            Rect rect = this.f3779b;
            rect.right = (int) (((float) rect.left) + f3);
            Rect rect2 = this.f3779b;
            rect2.bottom = (int) (((float) rect2.top) + f2);
            invalidate();
        }
    }

    private boolean b(RectF rectF, int i, int i2) {
        RectF rectF2 = rectF;
        int i3 = i;
        int i4 = i2;
        int width = getWidth();
        int height = getHeight();
        if (height == 0 || width == 0) {
            return false;
        }
        float f2 = ((float) height) * 1.0f;
        float f3 = (float) width;
        float f4 = (float) i3;
        float f5 = (float) i4;
        float f6 = f3;
        if (0.01d < ((double) Math.abs((f2 / f3) - ((f4 * 1.0f) / f5)))) {
            return false;
        }
        if (height == i3 && width == i4) {
            return true;
        }
        float f7 = f2 / f4;
        float f8 = (f6 * 1.0f) / f5;
        rectF2.left *= f7;
        rectF2.top *= f8;
        rectF2.right *= f7;
        rectF2.bottom *= f8;
        return true;
    }

    public void setVisibility(int i) {
        String str = this.f3778a;
        e.a(str, "setVisibility, visibility: " + i);
        if (i != 0) {
            this.h.removeMessages(300);
        }
        super.setVisibility(i);
    }

    public void a(boolean z) {
        if (!this.f && a()) {
            if (z) {
                this.h.removeMessages(300);
                this.h.sendEmptyMessageDelayed(300, 100);
                return;
            }
            setVisibility(4);
        }
    }

    public boolean a() {
        return getVisibility() == 0;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        Rect rect = this.f3779b;
        if (rect != null && !this.c) {
            this.g.setBounds(rect);
            this.g.draw(canvas);
            super.onDraw(canvas);
        }
    }

    public void b() {
        this.c = true;
        setVisibility(4);
        this.h.removeCallbacksAndMessages((Object) null);
        this.f = false;
        clearAnimation();
    }

    public void c() {
        this.c = false;
        this.f = false;
    }
}
