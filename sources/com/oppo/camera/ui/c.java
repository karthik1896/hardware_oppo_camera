package com.oppo.camera.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import com.oppo.camera.R;
import com.oppo.camera.e;
import com.oppo.camera.util.Util;

/* compiled from: CameraSeekBar */
public abstract class c extends View {

    /* renamed from: a  reason: collision with root package name */
    protected int f3879a = 0;
    /* access modifiers changed from: protected */

    /* renamed from: b  reason: collision with root package name */
    public int f3880b = 0;
    protected boolean c = false;
    protected boolean d = false;
    protected Interpolator e = null;
    protected Interpolator f = null;
    protected float g = 0.0f;
    protected float h = 0.0f;
    protected float i = 0.0f;
    protected float j = 0.0f;
    protected float k = 0.0f;
    protected long l = 3000;
    protected Context m = null;
    /* access modifiers changed from: protected */
    public a n = null;
    protected Handler o = new Handler() {
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 1) {
                c.this.b(false);
            }
        }
    };
    private PathInterpolator p = new PathInterpolator(0.33f, 0.0f, 0.66f, 1.0f);

    /* compiled from: CameraSeekBar */
    public interface a {
        void a(float f);

        void a(float f, boolean z);

        boolean a();

        void b();

        void b(float f);

        void c();

        void c(float f);

        void d();

        void e();

        void f();
    }

    /* access modifiers changed from: protected */
    public abstract void a();

    /* access modifiers changed from: protected */
    public void a(Canvas canvas) {
    }

    /* access modifiers changed from: protected */
    public void d(Canvas canvas) {
    }

    /* access modifiers changed from: protected */
    public void e(Canvas canvas) {
    }

    /* access modifiers changed from: protected */
    public void f(Canvas canvas) {
    }

    public c(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.m = context;
        this.f3879a = Util.E();
        this.j = (((float) this.f3879a) * 1.0f) / 2.0f;
        this.e = getCollapseInterpolator();
        this.f = getExpandInterpolator();
        setStatus(0);
    }

    public void setOnSeekBarChangeListener(a aVar) {
        this.n = aVar;
    }

    public void setStatus(int i2) {
        e.a("CameraSeekBar", "setStatus, status: " + i2);
        this.f3880b = i2;
    }

    public int getStatus() {
        return this.f3880b;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        switch (this.f3880b) {
            case 0:
                a(canvas);
                return;
            case 1:
                b(canvas);
                return;
            case 2:
                f(canvas);
                return;
            case 3:
                c(canvas);
                return;
            case 4:
                d(canvas);
                return;
            case 5:
                e(canvas);
                return;
            case 6:
                this.g = 0.0f;
                c(canvas);
                return;
            default:
                return;
        }
    }

    /* access modifiers changed from: protected */
    public void b(Canvas canvas) {
        float f2 = this.g;
        if (f2 < 1.0f) {
            this.n.b(this.f.getInterpolation(f2));
            invalidate();
            this.g += 0.03333333f;
            return;
        }
        this.n.b(1.0f);
        f(canvas);
        this.g = 1.0f;
        setStatus(2);
    }

    /* access modifiers changed from: protected */
    public void c(Canvas canvas) {
        a aVar = this.n;
        if (aVar != null) {
            if (!this.d) {
                aVar.c();
                this.d = true;
            }
            this.n.c(this.e.getInterpolation(this.g));
        }
        float f2 = this.g;
        if (f2 > 0.0f) {
            if (this.c) {
                setAlpha(this.e.getInterpolation(f2));
            }
            invalidate();
            this.g -= 0.041666664f;
            return;
        }
        this.g = 0.0f;
        setAlpha(1.0f);
        setStatus(0);
        if (this.c) {
            setVisibility(8);
        }
        a();
        this.c = false;
        this.d = false;
        a aVar2 = this.n;
        if (aVar2 != null) {
            aVar2.d();
        }
    }

    public long getCollapseDelay() {
        return this.l;
    }

    public void setCollapseDelay(long j2) {
        this.l = j2;
    }

    /* access modifiers changed from: protected */
    public void b() {
        this.g = 0.0f;
        setStatus(0);
        setAlpha(1.0f);
        this.d = false;
    }

    public void a(Animation.AnimationListener animationListener) {
        if (this.f3880b != 0) {
            this.o.removeMessages(1);
            this.c = true;
            setStatus(3);
            invalidate();
            return;
        }
        Util.a((View) this, 80, 0, (Interpolator) this.p);
    }

    public void a(boolean z) {
        if (this.f3880b != 0) {
            setAlpha(1.0f);
            setVisibility(0);
            this.c = false;
            if (z) {
                this.o.removeMessages(1);
                setStatus(3);
                invalidate();
                return;
            }
            return;
        }
        Util.a((View) this, 0.0f, 1.0f, 160, (Animation.AnimationListener) null, (Interpolator) this.p);
    }

    /* access modifiers changed from: protected */
    public boolean b(boolean z) {
        int i2 = this.f3880b;
        int i3 = 3;
        if (!(3 == i2 || i2 == 0)) {
            if (8 == getVisibility() || 4 == getVisibility()) {
                setStatus(0);
            } else {
                this.c = false;
                if (z) {
                    i3 = 6;
                }
                setStatus(i3);
                invalidate();
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void c() {
        a aVar;
        if (1 != this.f3880b && getVisibility() == 0 && (aVar = this.n) != null && aVar.a()) {
            this.c = false;
            setStatus(1);
            this.n.b();
            invalidate();
        }
    }

    public void setRate(float f2) {
        float a2 = Util.a(f2, 0.0f, 1.0f);
        this.i = this.h;
        this.h = a2;
    }

    /* access modifiers changed from: protected */
    public Interpolator getCollapseInterpolator() {
        return AnimationUtils.loadInterpolator(this.m, R.anim.zoom_interpolator_out);
    }

    /* access modifiers changed from: protected */
    public Interpolator getExpandInterpolator() {
        return AnimationUtils.loadInterpolator(this.m, R.anim.zoom_interpolator_in);
    }

    public int getLayoutDirection() {
        return getContext().getResources().getConfiguration().getLayoutDirection();
    }
}
