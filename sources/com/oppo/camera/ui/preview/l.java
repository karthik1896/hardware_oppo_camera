package com.oppo.camera.ui.preview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.hardware.SensorEvent;
import android.hardware.SensorEventCallback;
import android.hardware.SensorManager;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.coloros.gradientereffects.GradienterNative;
import com.google.gson.Gson;
import com.oppo.camera.R;
import com.oppo.camera.e;
import com.oppo.camera.util.Util;
import java.util.LinkedList;

/* compiled from: GradienterAssistView */
public class l extends View {
    /* access modifiers changed from: private */
    public int[] A = new int[3];
    /* access modifiers changed from: private */
    public int[] B = new int[1];
    /* access modifiers changed from: private */
    public LinkedList<a> C = new LinkedList<>();
    private b D = null;
    private SensorEventCallback E = new SensorEventCallback() {
        public void onSensorChanged(SensorEvent sensorEvent) {
            if (9 == sensorEvent.sensor.getType()) {
                float[] unused = l.this.x = (float[]) sensorEvent.values.clone();
            }
            long currentTimeMillis = System.currentTimeMillis();
            GradienterNative.processGravity(l.this.x[0], l.this.x[1], l.this.x[2], l.this.z, l.this.A, l.this.B);
            l lVar = l.this;
            if (lVar.a(lVar.y) || 0.05f <= Math.abs(l.this.z[0] - l.this.y[0]) || 0.05f <= Math.abs(l.this.z[1] - l.this.y[1])) {
                int unused2 = l.this.g = 0;
            } else {
                l.f(l.this);
            }
            l lVar2 = l.this;
            float[] unused3 = lVar2.y = (float[]) lVar2.z.clone();
            if (10 > l.this.g) {
                l.this.a(currentTimeMillis);
                super.onSensorChanged(sensorEvent);
            }
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public boolean f4519a = false;

    /* renamed from: b  reason: collision with root package name */
    private boolean f4520b = false;
    /* access modifiers changed from: private */
    public boolean c = false;
    private int d = 0;
    private int e = 0;
    /* access modifiers changed from: private */
    public int f = 0;
    /* access modifiers changed from: private */
    public int g = 0;
    /* access modifiers changed from: private */
    public float h = 0.0f;
    private long i = 0;
    private long j = 0;
    private RectF k = new RectF();
    private RectF l = new RectF();
    private Bitmap m = null;
    private Bitmap n = null;
    private Bitmap o = null;
    private Bitmap p = null;
    private Bitmap q = null;
    private Paint r = null;
    /* access modifiers changed from: private */
    public a s = new a();
    /* access modifiers changed from: private */
    public a t = new a();
    private a u = new a();
    /* access modifiers changed from: private */
    public ValueAnimator v = null;
    private ValueAnimator w = null;
    /* access modifiers changed from: private */
    public float[] x = new float[3];
    /* access modifiers changed from: private */
    public float[] y = new float[4];
    /* access modifiers changed from: private */
    public float[] z = new float[4];

    /* compiled from: GradienterAssistView */
    interface b {
        void a();
    }

    static /* synthetic */ int f(l lVar) {
        int i2 = lVar.g;
        lVar.g = i2 + 1;
        return i2;
    }

    /* access modifiers changed from: private */
    public boolean a(float[] fArr) {
        if (fArr == null) {
            return true;
        }
        for (float compare : fArr) {
            if (Float.compare(compare, 0.0f) != 0) {
                return false;
            }
        }
        return true;
    }

    private boolean a(float f2) {
        if (1.5707963267948966d - ((double) Math.abs(this.z[2])) >= ((double) f2) || Math.abs(this.z[0]) >= f2 || Math.abs(this.z[1]) >= f2) {
            return false;
        }
        return true;
    }

    private boolean b(float f2) {
        if (1.5707963267948966d - ((double) Math.abs(this.z[0])) >= ((double) f2) || Math.abs(this.z[2]) >= f2 || Math.abs(this.z[1]) >= f2) {
            return false;
        }
        return true;
    }

    private boolean c(float f2) {
        if (1.5707963267948966d - ((double) Math.abs(this.z[1])) >= ((double) f2) || Math.abs(this.z[0]) >= f2 || Math.abs(this.z[2]) >= f2) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public void a(long j2) {
        int[] iArr = this.B;
        int i2 = 1;
        if ((1 == iArr[0] || 4 == iArr[0]) && a(15.0f)) {
            a(true);
            int unused = this.u.f4526a = 5;
            long unused2 = this.u.d = j2;
            boolean unused3 = this.u.e = a(1.0f);
            int unused4 = this.u.f4527b = f(this.z[0]);
            int unused5 = this.u.c = f(this.z[1]);
            float unused6 = this.u.f = 0.0f;
        } else {
            int i3 = -1;
            if (3 == this.B[0] && b(15.0f)) {
                a(this.k, 1, 0.0f);
                a(true);
                int unused7 = this.u.f4526a = 3;
                long unused8 = this.u.d = j2;
                boolean unused9 = this.u.e = b(1.0f);
                a(this.l, d() ? -1 : 1, (this.z[2] / 15.0f) * ((float) this.e));
                int unused10 = this.u.f4527b = (int) (this.l.left - this.k.left);
                int unused11 = this.u.c = (int) (this.l.top - this.k.top);
                if (d()) {
                    i3 = 1;
                }
                float unused12 = this.u.f = ((float) i3) * this.z[1];
            } else if (2 != this.B[0] || !c(15.0f)) {
                a(false);
            } else {
                a(this.k, 1, 0.0f);
                a(true);
                int unused13 = this.u.f4526a = 2;
                long unused14 = this.u.d = j2;
                float f2 = (this.z[2] / 15.0f) * ((float) this.e);
                boolean unused15 = this.u.e = c(1.0f);
                a(this.l, e() ? 1 : -1, f2);
                int unused16 = this.u.f4527b = (int) (this.l.left - this.k.left);
                int unused17 = this.u.c = (int) (this.l.top - this.k.top);
                if (!e()) {
                    i2 = -1;
                }
                float unused18 = this.u.f = ((float) i2) * this.z[0];
            }
        }
        if (this.u.e) {
            this.i = System.currentTimeMillis();
        } else {
            this.i = 0;
        }
        if (this.f4519a) {
            a(this.u);
            if (this.s.a()) {
                this.s.h(this.u);
                this.t.h(this.u);
                invalidate();
                return;
            }
            ValueAnimator valueAnimator = this.v;
            if (valueAnimator == null || (!valueAnimator.isRunning() && !this.v.isStarted() && !this.v.isPaused())) {
                f();
            } else if (this.v.isPaused()) {
                this.v.resume();
            }
        }
    }

    private boolean d() {
        return 0.0f > this.z[0];
    }

    private boolean e() {
        return 0.0f < this.z[1];
    }

    private void a(a aVar) {
        if (aVar.a()) {
            e.d("GradienterAssistView", "checkAndAddAttitude, empty attitude is dismissed.");
            return;
        }
        if (1 < this.C.size()) {
            this.C.removeLast();
        }
        this.C.add(aVar.b());
    }

    /* access modifiers changed from: private */
    public void f() {
        if (this.v == null) {
            this.v = ValueAnimator.ofFloat(new float[]{0.0f, 100.0f});
            this.v.setDuration(60);
            this.v.setInterpolator(new LinearInterpolator());
            this.v.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    a aVar = (a) l.this.C.peekFirst();
                    if (aVar == null) {
                        e.d("GradienterAssistView", "onAnimationUpdate, attitude list is empty.");
                        return;
                    }
                    l.this.t.a(l.this.s, aVar, floatValue / 100.0f, l.this.h);
                    if (Float.compare(floatValue, 100.0f) == 0) {
                        l.this.s.h(aVar);
                        l.this.C.removeFirst();
                    }
                    if (!l.this.c || !aVar.e) {
                        l.this.invalidate();
                    }
                }
            });
            this.v.addListener(new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    if (!l.this.v.isRunning() && l.this.C.size() > 0) {
                        l.this.f();
                    }
                }
            });
        }
        this.v.start();
    }

    public l(Context context) {
        super(context);
        a(context);
    }

    public void setOnAdjustedListener(b bVar) {
        this.D = bVar;
    }

    private void a(Context context) {
        this.r = new Paint();
        this.r.setAlpha(0);
        this.d = getResources().getDimensionPixelOffset(R.dimen.gradienter_cross_max_offset);
        this.e = getResources().getDimensionPixelOffset(R.dimen.gradienter_rect_max_offset);
        this.h = (float) getResources().getDimensionPixelOffset(R.dimen.gradienter_adjusted_threshold_in_distance);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        if (this.f4519a) {
            if (255 > this.f) {
                e.b("GradienterAssistView", "onDraw, alpha: " + this.f + ", Gradienter type: " + this.t.f4526a);
            }
            this.r.setAlpha(this.f);
            if (5 == this.t.f4526a) {
                this.r.clearShadowLayer();
                if (this.t.e) {
                    g();
                    canvas.drawBitmap(this.n, (float) d(0.0f), (float) e(0.0f), this.r);
                    return;
                }
                this.c = false;
                this.r.setAlpha((int) (((float) this.f) * 0.7f));
                canvas.drawBitmap(this.m, (float) d(0.0f), (float) e(0.0f), this.r);
                this.r.setAlpha((int) (((float) this.f) * 0.3f));
                canvas.drawBitmap(this.m, (float) d((float) this.t.f4527b), (float) e((float) this.t.c), this.r);
                this.r.setAlpha(this.f);
            } else if (3 == this.t.f4526a || 2 == this.t.f4526a) {
                if (3 == this.t.f4526a) {
                    canvas.rotate(90.0f, (float) getCenterX(), (float) getCenterY());
                }
                if (this.t.e) {
                    g();
                    canvas.drawBitmap(this.q, this.k.left, this.k.top, this.r);
                } else {
                    this.c = false;
                    canvas.drawBitmap(this.p, this.k.left, this.k.top, this.r);
                    this.r.clearShadowLayer();
                    canvas.rotate(this.t.f, (float) getCenterX(), (float) getCenterY());
                    canvas.drawBitmap(this.o, this.k.left + ((float) this.t.f4527b), this.k.top + ((float) this.t.c), this.r);
                    canvas.rotate(-this.t.f, (float) getCenterX(), (float) getCenterY());
                }
                if (3 == this.t.f4526a) {
                    canvas.rotate(-90.0f, (float) getCenterX(), (float) getCenterY());
                }
            }
        }
    }

    private int getCenterX() {
        return (int) (((float) getWidth()) / 2.0f);
    }

    private int getCenterY() {
        return (int) (((float) getHeight()) / 2.0f);
    }

    private void g() {
        long currentTimeMillis = System.currentTimeMillis();
        b bVar = this.D;
        if (bVar != null && 1000 < currentTimeMillis - this.j) {
            this.j = currentTimeMillis;
            bVar.a();
        }
        this.c = true;
    }

    private int d(float f2) {
        return (int) (((float) ((int) (((float) getCenterX()) - (((float) this.n.getWidth()) / 2.0f)))) + f2);
    }

    private int e(float f2) {
        return (int) (((float) ((int) (((float) getCenterY()) - (((float) this.n.getHeight()) / 2.0f)))) - f2);
    }

    private void a(RectF rectF, int i2, float f2) {
        float f3 = ((float) i2) * f2;
        rectF.set(((float) getCenterX()) - (((float) this.p.getWidth()) / 2.0f), (((float) getCenterY()) - (((float) this.p.getHeight()) / 2.0f)) + f3, ((float) getCenterX()) + (((float) this.p.getWidth()) / 2.0f), ((float) getCenterY()) + (((float) this.p.getHeight()) / 2.0f) + f3);
        if (0.0f == f2) {
            e.b("GradienterAssistView", "getAdjustRectF, centerRectF: " + rectF + ", rect.height: " + this.p.getHeight());
        }
    }

    private int f(float f2) {
        if (15.0f < f2) {
            f2 = 15.0f;
        }
        return (int) ((f2 / 15.0f) * ((float) this.d));
    }

    public void a() {
        e.b("GradienterAssistView", "startDrawGradienter.");
        if (!this.f4519a) {
            setVisibility(0);
            SensorManager sensorManager = (SensorManager) getContext().getSystemService("sensor");
            if (sensorManager != null) {
                sensorManager.registerListener(this.E, sensorManager.getDefaultSensor(9), 1);
                this.f4520b = true;
                this.f = 0;
                if (this.n == null) {
                    this.n = Util.b(getContext(), BitmapFactory.decodeResource(getResources(), R.drawable.icon_gradienter_indicator_highlight));
                }
                if (this.m == null) {
                    this.m = BitmapFactory.decodeResource(getResources(), R.drawable.icon_gradienter_indicator);
                }
                if (this.o == null) {
                    this.o = BitmapFactory.decodeResource(getResources(), R.drawable.icon_gradienter_rect_adjusting);
                }
                if (this.p == null) {
                    this.p = BitmapFactory.decodeResource(getResources(), R.drawable.icon_gradienter_rect_according);
                }
                if (this.q == null) {
                    this.q = Util.b(getContext(), BitmapFactory.decodeResource(getResources(), R.drawable.icon_gradienter_rect_highlight));
                }
            }
        }
    }

    private void a(final boolean z2) {
        if ((!z2 || this.f == 0 || !this.f4519a) && ((z2 || this.f != 0) && this.f4520b)) {
            if (this.w == null) {
                this.w = ValueAnimator.ofInt(new int[]{this.r.getAlpha(), 255});
                this.w.setDuration(600);
                this.w.setInterpolator(new LinearInterpolator());
                this.w.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        int unused = l.this.f = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        if (z2 || l.this.f != 0) {
                            l.this.invalidate();
                        } else {
                            boolean unused2 = l.this.f4519a = false;
                        }
                    }
                });
            }
            if (z2) {
                this.f4519a = true;
                this.w.setIntValues(new int[]{this.r.getAlpha(), 255});
            } else {
                this.w.setIntValues(new int[]{this.r.getAlpha(), 0});
            }
            if (!this.w.isRunning() && !this.w.isStarted()) {
                this.w.start();
                return;
            }
            return;
        }
        e.b("GradienterAssistView", "checkAndStartFadeInOutAnimation, fadeIn: " + z2 + ", current alpha: " + this.f + ", mbDrawGradient: " + this.f4519a + ", mbSensorRegistered: " + this.f4520b + ", return");
    }

    public void b() {
        e.b("GradienterAssistView", "stopDrawGradienter.");
        if (this.f4520b) {
            SensorManager sensorManager = (SensorManager) getContext().getSystemService("sensor");
            if (sensorManager != null) {
                sensorManager.unregisterListener(this.E);
            }
            this.f4520b = false;
        }
        invalidate();
        this.f4519a = false;
        this.f = 0;
        this.g = 0;
        setVisibility(8);
        LinkedList<a> linkedList = this.C;
        if (linkedList != null && linkedList.size() > 0) {
            this.C.clear();
        }
        Bitmap bitmap = this.n;
        if (bitmap != null) {
            bitmap.recycle();
            this.n = null;
        }
        Bitmap bitmap2 = this.m;
        if (bitmap2 != null) {
            bitmap2.recycle();
            this.m = null;
        }
        Bitmap bitmap3 = this.q;
        if (bitmap3 != null) {
            bitmap3.recycle();
            this.q = null;
        }
        Bitmap bitmap4 = this.o;
        if (bitmap4 != null) {
            bitmap4.recycle();
            this.o = null;
        }
        Bitmap bitmap5 = this.p;
        if (bitmap5 != null) {
            bitmap5.recycle();
            this.p = null;
        }
        ValueAnimator valueAnimator = this.v;
        if (valueAnimator != null) {
            valueAnimator.removeAllUpdateListeners();
            this.v.removeAllListeners();
            if (this.v.isRunning() || this.v.isStarted()) {
                this.v.cancel();
            }
            this.v = null;
        }
        ValueAnimator valueAnimator2 = this.w;
        if (valueAnimator2 != null) {
            valueAnimator2.removeAllListeners();
            this.w.removeAllUpdateListeners();
            if (this.w.isRunning() || this.w.isStarted()) {
                this.w.cancel();
            }
            this.w = null;
        }
    }

    public boolean c() {
        return 0 != this.i && 1000 <= System.currentTimeMillis() - this.i;
    }

    public String getOrientation() {
        return (3 == this.u.f4526a || 2 == this.u.f4526a) ? "vertical" : "horizontal";
    }

    /* compiled from: GradienterAssistView */
    private static class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public int f4526a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public int f4527b;
        /* access modifiers changed from: private */
        public int c;
        /* access modifiers changed from: private */
        public long d;
        /* access modifiers changed from: private */
        public boolean e;
        /* access modifiers changed from: private */
        public float f;

        private a() {
            this.f4526a = 1;
            this.f4527b = 0;
            this.c = 0;
            this.d = 0;
            this.e = false;
            this.f = 0.0f;
        }

        /* access modifiers changed from: private */
        public boolean a() {
            return this.f4527b == 0 && this.c == 0 && Float.compare(this.f, 0.0f) == 0;
        }

        /* access modifiers changed from: private */
        public void h(a aVar) {
            this.f4526a = aVar.f4526a;
            this.f4527b = aVar.f4527b;
            this.c = aVar.c;
            this.f = aVar.f;
            this.e = aVar.e;
            this.d = aVar.d;
        }

        /* access modifiers changed from: private */
        public a b() {
            a aVar = new a();
            aVar.h(this);
            return aVar;
        }

        /* access modifiers changed from: private */
        public void a(a aVar, a aVar2, float f2, float f3) {
            this.f4526a = aVar2.f4526a;
            this.d = aVar2.d;
            int i = aVar.f4527b;
            this.f4527b = (int) (((float) i) + (((float) (aVar2.f4527b - i)) * f2));
            int i2 = aVar.c;
            this.c = (int) (((float) i2) + (((float) (aVar2.c - i2)) * f2));
            this.e = aVar2.e && f3 > ((float) Math.abs(this.f4527b - aVar2.f4527b)) && f3 > ((float) Math.abs(this.c - aVar2.c));
            int i3 = aVar2.f4526a;
            if (2 == i3 || 3 == i3) {
                float f4 = aVar.f;
                this.f = f4 + (f2 * (aVar2.f - f4));
            }
        }

        public String toString() {
            return new Gson().toJson((Object) this);
        }
    }
}
