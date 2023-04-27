package com.oppo.camera.ui.control;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.hardware.camera2.params.Face;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.oppo.camera.R;
import com.oppo.camera.e;
import com.oppo.camera.ui.RotableTextView;
import com.oppo.camera.ui.inverse.c;
import com.oppo.camera.ui.preview.PreviewFrameLayout;
import com.oppo.camera.util.Util;

/* compiled from: TimerSnapShotManager */
public class h {

    /* renamed from: a  reason: collision with root package name */
    private static Typeface f3924a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public float f3925b;
    /* access modifiers changed from: private */
    public float c;
    /* access modifiers changed from: private */
    public int d;
    /* access modifiers changed from: private */
    public int e;
    private boolean f;
    /* access modifiers changed from: private */
    public boolean g;
    /* access modifiers changed from: private */
    public boolean h;
    /* access modifiers changed from: private */
    public int i;
    /* access modifiers changed from: private */
    public int j;
    private long k;
    /* access modifiers changed from: private */
    public b l;
    private a m;
    /* access modifiers changed from: private */
    public RotableTextView n;
    /* access modifiers changed from: private */
    public ValueAnimator o;

    /* compiled from: TimerSnapShotManager */
    public interface b {
        void a();

        void a(boolean z);

        void b();

        void c();
    }

    public h() {
        this.f3925b = 0.0f;
        this.c = 0.0f;
        this.d = 0;
        this.e = 0;
        this.f = false;
        this.g = false;
        this.h = false;
        this.i = 0;
        this.j = 0;
        this.k = 0;
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = null;
        this.m = new a();
    }

    /* compiled from: TimerSnapShotManager */
    private class a extends Handler {

        /* renamed from: b  reason: collision with root package name */
        private boolean f3927b;
        private int c;
        private int d;
        private int e;

        private a() {
            this.f3927b = false;
            this.c = 0;
            this.d = 0;
            this.e = 0;
        }

        public void handleMessage(Message message) {
            e.a("TimerSnapShotManager", "handleMessage, what: " + message.what);
            int i = message.what;
            int i2 = 1;
            if (i == 1) {
                int intValue = ((Integer) message.obj).intValue();
                if (h.this.n != null) {
                    h.this.n.a(intValue, false);
                }
                this.e = intValue;
                this.f3927b = true;
                this.c = 0;
                this.d = 0;
            } else if (i != 2) {
                if (i == 3) {
                    boolean booleanValue = ((Boolean) message.obj).booleanValue();
                    int i3 = message.arg1;
                    if (!booleanValue) {
                        i2 = 2;
                    }
                    a(i2, i3);
                    if (this.f3927b) {
                        e.a("TimerSnapShotManager", "handleMessage, MSG_UPDATE_POSITION, mbFirstPreview");
                        this.f3927b = false;
                        c(1000);
                    }
                }
            } else if (!b()) {
                c(((Integer) message.obj).intValue());
            }
        }

        public void a() {
            this.f3927b = false;
        }

        private boolean b() {
            if (h.this.i > 0) {
                return false;
            }
            if (h.this.l != null) {
                boolean unused = h.this.g = true;
                h.this.l.a();
            }
            return true;
        }

        private void a(int i, int i2) {
            if (h.this.n != null) {
                int i3 = this.d;
                if (i3 == 0) {
                    b(i);
                    this.d = i;
                } else if (i3 != i) {
                    b(i);
                    if (this.d == 1) {
                        a(h.this.n, (h.this.f3925b * 1.0f) / h.this.c, this.d, i);
                    } else if (i == 1) {
                        a(h.this.n, (h.this.c * 1.0f) / h.this.f3925b, this.d, i);
                    }
                    this.d = i;
                }
                if (this.e != i2) {
                    h.this.n.a(i2, true);
                    this.e = i2;
                }
            }
        }

        private void a(View view, float f, int i, int i2) {
            PointF a2 = a(i);
            PointF a3 = a(i2);
            view.setScaleX(f);
            view.setScaleY(f);
            view.setTranslationX(a2.x - a3.x);
            view.setTranslationY(a2.y - a3.y);
            view.animate().setDuration(500).scaleX(1.0f).scaleY(1.0f).translationX(1.0f).translationY(1.0f);
        }

        private PointF a(int i) {
            float f;
            ViewGroup viewGroup = (ViewGroup) h.this.n.getParent();
            float f2 = 0.0f;
            if (i == 1) {
                f2 = ((float) viewGroup.getWidth()) / 2.0f;
                f = ((float) viewGroup.getHeight()) / 2.0f;
            } else if (i != 2) {
                f = 0.0f;
            } else {
                int g = h.this.h ? h.this.e : 0;
                f2 = (((float) viewGroup.getWidth()) - (h.this.c / 2.0f)) - ((float) h.this.d);
                f = ((float) g) + (h.this.c / 2.0f);
            }
            return new PointF(f2, f);
        }

        private void b(int i) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            int i2 = -1;
            if (i == 1) {
                layoutParams.addRule(13);
                h.this.n.setTextSize(0, h.this.f3925b);
                h.this.n.setTextColor(-1);
            } else if (i == 2) {
                layoutParams.addRule(10);
                layoutParams.addRule(11);
                layoutParams.rightMargin = h.this.d;
                if (h.this.h) {
                    layoutParams.topMargin = h.this.e;
                }
                h.this.n.setTextSize(0, h.this.c);
                RotableTextView a2 = h.this.n;
                if (c.INS.isInverseColor(h.this.n.getContext().hashCode())) {
                    i2 = h.this.n.getContext().getColor(R.color.inverse_text_color);
                }
                a2.setTextColor(i2);
            }
            h.this.n.setLayoutParams(layoutParams);
        }

        private void c(int i) {
            int ceil;
            if (!(h.this.n == null || (ceil = (int) Math.ceil((((double) h.this.i) * 1.0d) / 1000.0d)) == this.c)) {
                h.this.n.setAlpha(1.0f);
                h.this.n.setText(Util.j(ceil));
                this.c = ceil;
                c();
            }
            h hVar = h.this;
            int unused = hVar.i = hVar.i - i;
            h.this.l.c();
            int i2 = 1000;
            if (h.this.j > 3000 && h.this.i <= 3000) {
                i2 = h.this.i <= 1000 ? 125 : 250;
            }
            removeMessages(2);
            sendMessageDelayed(obtainMessage(2, Integer.valueOf(i2)), (long) i);
        }

        private void c() {
            if (h.this.o == null) {
                d();
            }
            h.this.o.cancel();
            h.this.o.start();
        }

        private void d() {
            ValueAnimator unused = h.this.o = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f}).setDuration(1000);
            h.this.o.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    if (h.this.n != null) {
                        h.this.n.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                        h.this.n.postInvalidate();
                    }
                }
            });
        }
    }

    public void a(b bVar) {
        this.l = bVar;
    }

    private void a(Activity activity) {
        if (this.n == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(13);
            PreviewFrameLayout previewFrameLayout = (PreviewFrameLayout) activity.findViewById(R.id.frame_layout);
            float dimension = activity.getResources().getDimension(R.dimen.time_snapshot_indicator_shadow_radius_size);
            float dimension2 = activity.getResources().getDimension(R.dimen.time_snapshot_indicator_shadow_radius_dx);
            float dimension3 = activity.getResources().getDimension(R.dimen.time_snapshot_indicator_shadow_radius_dy);
            this.f3925b = activity.getResources().getDimension(R.dimen.time_snapshot_indicator_text_size);
            this.c = activity.getResources().getDimension(R.dimen.time_snapshot_indicator_text_size_corner);
            this.d = (int) activity.getResources().getDimension(R.dimen.time_snapshot_indicator_text_margin_horizontal);
            this.e = Util.v();
            this.n = new RotableTextView(activity);
            this.n.setShadowLayer(dimension, dimension2, dimension3, 0);
            if (f3924a == null) {
                f3924a = Util.j((Context) activity);
            }
            this.n.setTypeface(f3924a);
            this.n.setTextSize(0, this.f3925b);
            previewFrameLayout.addView(this.n, layoutParams);
            this.n.setVisibility(8);
        }
    }

    public void a() {
        this.n = null;
        this.m = null;
        ValueAnimator valueAnimator = this.o;
        if (valueAnimator != null) {
            valueAnimator.removeAllUpdateListeners();
            this.o = null;
        }
    }

    public String b() {
        if (this.n == null) {
            return null;
        }
        return this.n.getWidth() + "x" + this.n.getHeight();
    }

    public String c() {
        if (this.n == null) {
            return null;
        }
        return this.n.getLeft() + "," + this.n.getTop() + "," + this.n.getRight() + "," + this.n.getBottom();
    }

    public void a(int i2, Activity activity, int i3, boolean z) {
        e.a("TimerSnapShotManager", "startTimerSnapShot, time: " + i2);
        this.h = z;
        this.i = i2 * 1000;
        this.j = this.i;
        a(activity);
        this.f = true;
        RotableTextView rotableTextView = this.n;
        if (rotableTextView != null) {
            rotableTextView.setVisibility(0);
        }
        this.m.removeMessages(1);
        a aVar = this.m;
        aVar.sendMessage(aVar.obtainMessage(1, Integer.valueOf(i3)));
        this.l.b();
    }

    public boolean d() {
        return this.f;
    }

    public boolean e() {
        return this.g;
    }

    public void f() {
        this.m.removeMessages(2);
        this.m.removeMessages(3);
        this.m.a();
        this.f = false;
        RotableTextView rotableTextView = this.n;
        if (rotableTextView != null) {
            rotableTextView.clearAnimation();
            this.n.setVisibility(8);
        }
        b bVar = this.l;
        if (bVar != null) {
            bVar.a(this.g);
        }
        this.g = false;
        this.i = 0;
        this.j = 0;
        this.k = 0;
    }

    public void a(Rect rect, Face[] faceArr, int i2) {
        if (System.currentTimeMillis() - this.k > 500) {
            this.k = System.currentTimeMillis();
            this.m.removeMessages(3);
            Message obtainMessage = this.m.obtainMessage(3);
            obtainMessage.obj = Boolean.valueOf(a(rect, faceArr));
            obtainMessage.arg1 = i2;
            this.m.sendMessage(obtainMessage);
        }
    }

    private boolean a(Rect rect, Face[] faceArr) {
        if (faceArr == null || faceArr.length <= 0) {
            return true;
        }
        int width = (rect.width() * rect.height()) / 16;
        for (Face a2 : faceArr) {
            if (a(a2, width)) {
                return true;
            }
        }
        return false;
    }

    private boolean a(Face face, int i2) {
        if (face == null) {
            return false;
        }
        Rect bounds = face.getBounds();
        if (bounds.width() * bounds.height() <= i2) {
            return true;
        }
        return false;
    }
}
