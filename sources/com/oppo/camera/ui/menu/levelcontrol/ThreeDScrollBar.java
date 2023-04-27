package com.oppo.camera.ui.menu.levelcontrol;

import android.app.Activity;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.TextureView;
import android.view.VelocityTracker;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import com.oppo.camera.e;
import com.oppo.camera.gl.m;
import com.oppo.camera.ui.inverse.c;
import com.oppo.camera.ui.menu.levelcontrol.g;
import com.oppo.camera.ui.preview.a.h;
import com.oppo.camera.util.Util;

public class ThreeDScrollBar extends TextureView implements TextureView.SurfaceTextureListener {

    /* renamed from: a  reason: collision with root package name */
    private Interpolator f4106a;

    /* renamed from: b  reason: collision with root package name */
    private Interpolator f4107b;
    /* access modifiers changed from: private */
    public g c;
    /* access modifiers changed from: private */
    public m d;
    /* access modifiers changed from: private */
    public a e;
    private VelocityTracker f;
    /* access modifiers changed from: private */
    public Handler g;
    private int h;
    /* access modifiers changed from: private */
    public int i;
    private float j;
    private float k;
    private float l;
    private boolean m;
    /* access modifiers changed from: private */
    public boolean n;
    private g.b o;
    private g.b p;
    private g.b q;

    public interface a {
        void a();

        void a(int i, boolean z);

        void a(g gVar);

        boolean a(int i);

        boolean b();

        int c();

        int d();
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    public void setThreeDScrollBarTextureViewCallback(a aVar) {
        this.e = aVar;
    }

    public ThreeDScrollBar(Context context) {
        this(context, (AttributeSet) null);
    }

    public ThreeDScrollBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4106a = new PathInterpolator(0.0f, 0.1f, 0.1f, 1.0f);
        this.f4107b = new PathInterpolator(0.0f, 0.1f, 0.4f, 0.7f);
        this.c = null;
        this.d = null;
        this.e = null;
        this.g = null;
        this.h = 1;
        this.i = com.oppo.camera.ui.preview.a.g.f4385a;
        this.j = 0.0f;
        this.k = 0.0f;
        this.l = 0.0f;
        this.m = false;
        this.n = false;
        this.o = new g.b() {
            public void a(float f) {
            }

            public void b(final float f) {
                boolean unused = ThreeDScrollBar.this.n = false;
                ThreeDScrollBar.this.g.post(new Runnable() {
                    public void run() {
                        ThreeDScrollBar.this.d.b(0);
                        ThreeDScrollBar.this.setScrolling(false);
                    }
                });
            }
        };
        this.p = new g.b() {
            public void a(final float f) {
                ThreeDScrollBar.this.g.post(new Runnable() {
                    public void run() {
                        int a2 = ThreeDScrollBar.this.c(f);
                        if (a2 != ThreeDScrollBar.this.i) {
                            ThreeDScrollBar.this.c(a2);
                        }
                    }
                });
            }

            public void b(final float f) {
                ThreeDScrollBar.this.g.post(new Runnable() {
                    public void run() {
                        ThreeDScrollBar.this.d.b(0);
                        ThreeDScrollBar.this.c(ThreeDScrollBar.this.c(f));
                        ThreeDScrollBar.this.setScrolling(false);
                    }
                });
            }
        };
        this.q = new g.b() {
            public void a(final float f) {
                ThreeDScrollBar.this.g.post(new Runnable() {
                    public void run() {
                        int a2 = ThreeDScrollBar.this.c(f);
                        if (a2 != ThreeDScrollBar.this.i) {
                            ThreeDScrollBar.this.c(a2);
                        }
                    }
                });
            }

            public void b(final float f) {
                ThreeDScrollBar.this.g.post(new Runnable() {
                    public void run() {
                        ThreeDScrollBar.this.c(ThreeDScrollBar.this.c(f));
                        ThreeDScrollBar.this.j();
                    }
                });
            }
        };
        setOpaque(false);
        setSurfaceTextureListener(this);
        this.g = new Handler();
        this.c = new g(context);
        c.INS.registerInverse(context, this.c);
        this.c.a((g.a) new g.a() {
            public void a() {
                ThreeDScrollBar.this.e.a();
            }

            public void a(g gVar) {
                ThreeDScrollBar.this.e.a(gVar);
                if (!ThreeDScrollBar.this.c.d()) {
                    ThreeDScrollBar.this.d.a((Runnable) new Runnable() {
                        public void run() {
                            ThreeDScrollBar.this.c.e();
                        }
                    });
                }
            }
        });
    }

    public void setCameraEntryType(int i2) {
        this.h = i2;
    }

    public void setFilterCategory(h.a aVar) {
        this.c.a(aVar);
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
        e.a("ThreeDScrollBar", "onSurfaceTextureAvailable");
        this.d = new m(surfaceTexture);
        if (this.h == 1) {
            this.d.a(true);
        }
        this.d.a(2);
        this.d.a(8, 8, 8, 8, 16, 0);
        this.d.a((m.C0085m) this.c);
        this.d.b(0);
        this.d.a((SurfaceHolder) null);
        this.d.a((SurfaceHolder) null, 0, i2, i3);
        a(this.e.c());
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
        e.a("ThreeDScrollBar", "onSurfaceTextureSizeChanged");
        this.d.a((SurfaceHolder) null, 0, i2, i3);
        this.d.d();
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        e.a("ThreeDScrollBar", "onSurfaceTextureDestroyed");
        this.d.b((SurfaceHolder) null);
        this.d.e();
        return false;
    }

    public void a() {
        g gVar;
        if (this.d != null && (gVar = this.c) != null && gVar.h() && !e()) {
            this.d.d();
        }
    }

    public void a(final int i2, final int i3) {
        e.a("ThreeDScrollBar", "notifyPreviewSizeChanged, Size: " + i2 + " x " + i3);
        float[] fArr = {0.0f, 0.0f, 0.0f, 0.0f};
        if (Util.b(i3, i2) == 2) {
            fArr[0] = 0.0f;
        }
        g gVar = this.c;
        if (gVar != null) {
            gVar.a(fArr);
        }
        m mVar = this.d;
        if (mVar != null) {
            mVar.a((Runnable) new Runnable() {
                public void run() {
                    ThreeDScrollBar.this.c.a(i2, i3);
                }
            });
            this.d.d();
        }
    }

    public void b() {
        m mVar = this.d;
        if (mVar != null) {
            mVar.g();
        }
    }

    public void c() {
        m mVar = this.d;
        if (mVar != null) {
            g gVar = this.c;
            if (gVar != null) {
                gVar.a(mVar);
            }
            this.d.f();
        }
        this.n = false;
        setScrolling(false);
    }

    public void d() {
        g gVar;
        m mVar = this.d;
        if (mVar != null && (gVar = this.c) != null) {
            gVar.b(mVar);
        }
    }

    public void setScrolling(boolean z) {
        e.a("ThreeDScrollBar", "setScrolling, isScrolling: " + this.m + " -> " + z);
        this.m = z;
    }

    public boolean e() {
        return this.m;
    }

    public void a(final f fVar) {
        e.a("ThreeDScrollBar", "createTextures, mGLProducer: " + this.d);
        m mVar = this.d;
        if (mVar != null) {
            mVar.a((Runnable) new Runnable() {
                public void run() {
                    ThreeDScrollBar.this.c.a(fVar, !ThreeDScrollBar.this.c.a(fVar));
                    ThreeDScrollBar.this.c.c();
                    ThreeDScrollBar.this.a(fVar.j());
                }
            });
        }
    }

    public void a(int i2, String str) {
        if (this.d != null) {
            this.c.a(i2, str);
        }
    }

    public void a(int i2) {
        this.i = i2;
        k();
        a(d(i2), false);
    }

    /* access modifiers changed from: private */
    public void c(int i2) {
        a(i2, true);
    }

    private void a(int i2, boolean z) {
        e.a("ThreeDScrollBar", "onItemChanged, index: " + this.i + " -> " + i2 + ", hasTexturesInited: " + l() + ", isFromSlide: " + z);
        if (i2 != this.i && l()) {
            this.c.a(i2);
            this.e.a(i2, z);
            this.i = i2;
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        float f2;
        float x = motionEvent.getX();
        if (this.n) {
            if (motionEvent.getActionMasked() == 0) {
                e.a("ThreeDScrollBar", "onTouchEvent, click scrolling, reset touch x");
                this.k = x;
                this.j = x;
                this.f = VelocityTracker.obtain();
            }
            return true;
        } else if (!this.e.b()) {
            j();
            if (motionEvent.getActionMasked() == 0) {
                a(motionEvent);
            }
            return true;
        } else {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                k();
                this.k = x;
                this.j = x;
                this.f = VelocityTracker.obtain();
            } else if (actionMasked == 1) {
                float f3 = 0.0f;
                VelocityTracker velocityTracker = this.f;
                if (velocityTracker != null) {
                    velocityTracker.addMovement(motionEvent);
                    this.f.computeCurrentVelocity(1000);
                    f3 = this.f.getXVelocity();
                    this.f.clear();
                }
                if (Math.abs(f3) >= 1000.0f) {
                    b(f3);
                } else if (Math.abs(x - this.k) > 2.0f) {
                    j();
                } else {
                    b(motionEvent);
                }
            } else if (actionMasked == 2) {
                if (motionEvent.getPointerId(motionEvent.getActionIndex()) == 1) {
                    f2 = x - this.l;
                    this.l = x;
                } else {
                    f2 = x - this.j;
                    this.j = x;
                }
                VelocityTracker velocityTracker2 = this.f;
                if (velocityTracker2 != null) {
                    velocityTracker2.addMovement(motionEvent);
                }
                a(f2);
            } else if (actionMasked == 3) {
                VelocityTracker velocityTracker3 = this.f;
                if (velocityTracker3 != null) {
                    velocityTracker3.recycle();
                    this.f = null;
                }
                if (Math.abs(x - this.k) > 2.0f) {
                    j();
                } else {
                    b(motionEvent);
                }
            } else if (actionMasked == 5) {
                k();
                a(motionEvent);
                this.f = VelocityTracker.obtain();
            } else if (actionMasked == 6) {
                a(motionEvent);
            }
            return true;
        }
    }

    private void a(MotionEvent motionEvent) {
        if (motionEvent.getPointerCount() > 0) {
            this.j = motionEvent.getX(motionEvent.findPointerIndex(motionEvent.getPointerId(0)));
        }
        if (1 < motionEvent.getPointerCount()) {
            this.l = motionEvent.getX(motionEvent.findPointerIndex(motionEvent.getPointerId(1)));
        }
    }

    public void f() {
        this.n = false;
        if (!l()) {
            e.e("ThreeDScrollBar", "slideToNextItem, texture not init, so return");
        } else if (this.i < getModelNum() - 1) {
            int i2 = this.i + 1;
            e.a("ThreeDScrollBar", "slideToNextItem, index: " + this.i + " -> " + i2);
            k();
            a(d(i2), 26, this.f4106a, this.p);
        }
    }

    public void g() {
        this.n = false;
        if (!l()) {
            e.e("ThreeDScrollBar", "slideToPreviousItem, texture not init, so return");
        } else if (this.i > this.e.d()) {
            int i2 = this.i - 1;
            e.a("ThreeDScrollBar", "slideToPreviousItem, index: " + this.i + " -> " + i2);
            k();
            a(d(i2), 26, this.f4106a, this.p);
        }
    }

    public void h() {
        this.n = false;
        float d2 = d(c(getCurrYAngle()));
        if (Float.compare(d2, getCurrYAngle()) != 0) {
            e.a("ThreeDScrollBar", "forceScrollNearWithNoAnim, angle: " + getCurrYAngle() + " -> " + d2);
            k();
            a(d2, true);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x003b, code lost:
        if (r4 > r8) goto L_0x003d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0052, code lost:
        if (r4 < r8) goto L_0x003d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(float r8) {
        /*
            r7 = this;
            double r0 = com.oppo.camera.ui.menu.levelcontrol.h.a()
            float r0 = (float) r0
            r1 = 1073741824(0x40000000, float:2.0)
            float r0 = r0 / r1
            com.oppo.camera.ui.menu.levelcontrol.ThreeDScrollBar$a r1 = r7.e
            int r1 = r1.d()
            float r1 = r7.d((int) r1)
            int r2 = r7.getModelNum()
            r3 = 1
            int r2 = r2 - r3
            float r2 = r7.d((int) r2)
            float r4 = r7.getCurrYAngle()
            float r5 = com.oppo.camera.ui.menu.levelcontrol.h.f(r8)
            float r4 = r4 + r5
            int r5 = (r4 > r1 ? 1 : (r4 == r1 ? 0 : -1))
            r6 = 1053609165(0x3ecccccd, float:0.4)
            if (r5 <= 0) goto L_0x003f
            float r2 = r7.getCurrYAngle()
            float r8 = com.oppo.camera.ui.menu.levelcontrol.h.f(r8)
            float r8 = r8 * r6
            float r4 = r2 + r8
            float r8 = r1 + r0
            int r0 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r0 <= 0) goto L_0x0055
        L_0x003d:
            r4 = r8
            goto L_0x0055
        L_0x003f:
            int r1 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r1 > 0) goto L_0x0055
            float r1 = r7.getCurrYAngle()
            float r8 = com.oppo.camera.ui.menu.levelcontrol.h.f(r8)
            float r8 = r8 * r6
            float r4 = r1 + r8
            float r8 = r2 - r0
            int r0 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r0 >= 0) goto L_0x0055
            goto L_0x003d
        L_0x0055:
            r7.a((float) r4, (boolean) r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.ui.menu.levelcontrol.ThreeDScrollBar.a(float):void");
    }

    /* access modifiers changed from: private */
    public void j() {
        a aVar = this.e;
        int d2 = aVar != null ? aVar.d() : 0;
        float currYAngle = getCurrYAngle();
        float d3 = d(d2);
        if (currYAngle <= d3) {
            d3 = currYAngle;
        }
        float d4 = d(c(d3));
        e.a("ThreeDScrollBar", "scrollNear, angle: " + getCurrYAngle() + " -> " + d4);
        a(d4, 26, this.f4106a, this.p);
    }

    private void b(MotionEvent motionEvent) {
        if (!l()) {
            e.e("ThreeDScrollBar", "scrollToByClick, texture not init, so return");
            j();
            return;
        }
        float f2 = h.f(((float) (Util.E() / 2)) - motionEvent.getX());
        float d2 = d(0) + (h.e() / 2.0f);
        float d3 = d(getModelNum() - 1) - (h.e() / 2.0f);
        float currYAngle = getCurrYAngle() + f2;
        if (currYAngle > d2 || currYAngle <= d3) {
            j();
            return;
        }
        int c2 = c(currYAngle);
        e.a("ThreeDScrollBar", "scrollToByClick, toYAngle: " + currYAngle + ", index: " + this.i + " -> " + c2);
        a aVar = this.e;
        if (aVar != null && !aVar.a(c2)) {
            if (!(this.c == null || Float.compare(currYAngle - getCurrYAngle(), 0.0f) == 0)) {
                this.n = true;
                a(c2, false);
            }
            a(d(c2), 26, this.f4106a, this.o);
        }
    }

    public void b(int i2) {
        if (i2 >= getModelNum()) {
            i2 = getModelNum() - 1;
        }
        this.n = true;
        a(i2, false);
        a(d(i2), 26, this.f4106a, this.o);
    }

    private void b(float f2) {
        if (!l()) {
            e.e("ThreeDScrollBar", "scrollToByFling, texture not init, so return");
            j();
            return;
        }
        float f3 = h.f(0.08f * f2);
        float e2 = h.e() * Math.abs(f2 / 30000.0f);
        float d2 = d(this.e.d());
        float d3 = d(getModelNum() - 1);
        float currYAngle = getCurrYAngle() + f3;
        int i2 = 26;
        if (getCurrYAngle() > d2 || getCurrYAngle() <= d3) {
            j();
        } else if (currYAngle > d2) {
            float f4 = d2 + e2;
            if (currYAngle > f4) {
                currYAngle = f4;
            }
            i2 = Math.abs(c(getCurrYAngle()) - c(currYAngle)) * 2;
            a(currYAngle, i2, this.f4107b, this.q);
        } else if (currYAngle <= d3) {
            float f5 = d3 - e2;
            if (currYAngle < f5) {
                currYAngle = f5;
            }
            i2 = Math.abs(c(getCurrYAngle()) - c(currYAngle)) * 2;
            a(currYAngle, i2, this.f4107b, this.q);
        } else {
            i2 = 26 + (Math.abs(c(getCurrYAngle()) - c(currYAngle)) * 2);
            a(d(c(currYAngle)), i2, this.f4106a, this.p);
        }
        e.a("ThreeDScrollBar", "scrollToByFling, toYAngle: " + currYAngle + ", positiveLimit: " + d2 + ", negativeLimit: " + d3 + ", animFrame: " + i2 + ", velocityX: " + f2 + ", outLimitDiff: " + e2);
    }

    private boolean a(float f2, int i2, Interpolator interpolator, g.b bVar) {
        float currYAngle = f2 - getCurrYAngle();
        if (this.c == null || Float.compare(currYAngle, 0.0f) == 0) {
            this.n = false;
            return false;
        }
        setScrolling(true);
        this.c.a(getCurrYAngle(), currYAngle, i2, interpolator, bVar);
        this.d.b(1);
        ((Activity) getContext()).runOnUiThread(new Runnable() {
            public void run() {
                if (ThreeDScrollBar.this.d != null) {
                    ThreeDScrollBar.this.d.b();
                }
            }
        });
        return true;
    }

    private void a(float f2, boolean z) {
        e.a("ThreeDScrollBar", "moveToYAngle, angle: " + getCurrYAngle() + " -> " + f2);
        g gVar = this.c;
        if (gVar != null) {
            gVar.a(f2, 0.0f, 0, (Interpolator) null, (g.b) null);
            m mVar = this.d;
            if (mVar != null) {
                mVar.d();
            }
            if (z) {
                c(c(f2));
            }
        }
    }

    private void k() {
        e.a("ThreeDScrollBar", "cancelYAngleAnim");
        Handler handler = this.g;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
        }
        this.n = false;
        setScrolling(false);
        m mVar = this.d;
        if (mVar != null) {
            mVar.b(0);
        }
        g gVar = this.c;
        if (gVar != null) {
            gVar.a();
        }
    }

    private float d(int i2) {
        return ((float) (-i2)) * h.g();
    }

    /* access modifiers changed from: private */
    public int c(float f2) {
        if (!l()) {
            e.e("ThreeDScrollBar", "convertAngleToIndex, texture not init, so return");
            return 0;
        }
        float d2 = d(0);
        float d3 = d(getModelNum() - 1);
        int round = Math.round(Math.abs(f2 / h.g()));
        if (round < 0 || f2 > d2) {
            return 0;
        }
        if (round >= getModelNum() || f2 <= d3) {
            return getModelNum() - 1;
        }
        return round;
    }

    private boolean l() {
        return getModelNum() > 0;
    }

    private int getModelNum() {
        g gVar = this.c;
        if (gVar != null) {
            return gVar.g();
        }
        return 0;
    }

    private float getCurrYAngle() {
        g gVar = this.c;
        if (gVar != null) {
            return gVar.b();
        }
        return 0.0f;
    }

    public void i() {
        m mVar = this.d;
        if (mVar != null) {
            mVar.a((Runnable) new Runnable() {
                public void run() {
                    if (ThreeDScrollBar.this.c != null && ThreeDScrollBar.this.c.d()) {
                        ThreeDScrollBar.this.c.f();
                    }
                }
            });
        }
    }
}
