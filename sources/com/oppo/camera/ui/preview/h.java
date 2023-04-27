package com.oppo.camera.ui.preview;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.PointFEvaluator;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Size;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.oppo.camera.R;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/* compiled from: FacePointAnimationManager */
public class h {

    /* renamed from: a  reason: collision with root package name */
    private static final int[][] f4490a = {new int[]{121}, new int[]{115, 127}, new int[]{110, 132}, new int[]{-1, 118, 39, -1, 124, 36}, new int[]{-1, 38, 37}, new int[]{105, 104}, new int[]{106, 136}, new int[]{44}, new int[]{30, 3}, new int[]{46}, new int[]{-1, 81, 61, -1, 82, 52}, new int[]{-1, 49, 87}, new int[]{25, 8}, new int[]{90, 96}, new int[]{16}};

    /* renamed from: b  reason: collision with root package name */
    private int[] f4491b;
    private Size c;
    private int d;
    private boolean e;
    private Matrix f;
    private List<g> g;
    /* access modifiers changed from: private */
    public FaceView h;
    /* access modifiers changed from: private */
    public boolean i;
    /* access modifiers changed from: private */
    public boolean j;
    private Random k;
    /* access modifiers changed from: private */
    public b l;
    private Interpolator m;
    private Interpolator n;
    private Interpolator o;
    private Interpolator p;
    /* access modifiers changed from: private */
    public Handler q;

    /* compiled from: FacePointAnimationManager */
    private enum a {
        ALPHA,
        SCALE,
        TRANSLATION_X,
        TRANSLATION_Y
    }

    /* compiled from: FacePointAnimationManager */
    public interface b {
        void aj();

        void ak();

        boolean al();
    }

    public h(FaceView faceView) {
        this.f4491b = null;
        this.c = null;
        this.d = 0;
        this.e = false;
        this.f = new Matrix();
        this.g = new ArrayList();
        this.h = null;
        this.i = false;
        this.j = false;
        this.k = new Random();
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = new Handler(Looper.getMainLooper()) {
            public void handleMessage(Message message) {
                if (!h.this.j) {
                    int i = message.what;
                    if (i == 1) {
                        if (h.this.l != null) {
                            h.this.l.ak();
                        }
                        h.this.c();
                    } else if (i == 2) {
                        if (h.this.i || h.this.l == null || !h.this.l.al()) {
                            h.this.q.sendEmptyMessageDelayed(2, 50);
                        } else {
                            h.this.a();
                        }
                    }
                }
            }
        };
        this.j = false;
        this.h = faceView;
        this.m = AnimationUtils.loadInterpolator(this.h.getContext(), R.anim.face_point_scale_interpolator1);
        this.n = AnimationUtils.loadInterpolator(this.h.getContext(), R.anim.face_point_scale_interpolator2);
        this.o = AnimationUtils.loadInterpolator(this.h.getContext(), R.anim.face_point_scale_interpolator3);
        this.p = AnimationUtils.loadInterpolator(this.h.getContext(), R.anim.face_point_translation_interpolator);
    }

    public void a(Size size) {
        this.c = size;
    }

    public void a(int i2) {
        this.d = i2;
    }

    public void a(boolean z) {
        this.e = z;
    }

    public void a(Canvas canvas) {
        if (this.h != null && this.f4491b != null && this.g.size() != 0 && this.c != null && this.i) {
            for (g a2 : this.g) {
                for (i next : a2.a()) {
                    if (next.f()) {
                        float q2 = next.q();
                        float r = next.r();
                        canvas.drawCircle(q2, r, next.n(), next.u());
                        canvas.drawCircle(q2, r, next.m(), next.t());
                        canvas.drawCircle(q2, r, next.l(), next.s());
                    }
                }
            }
        }
    }

    public void a(int[] iArr) {
        FaceView faceView;
        this.f4491b = iArr;
        if (iArr != null && (faceView = this.h) != null && faceView.getWidth() > 0) {
            b bVar = this.l;
            if (bVar != null && !bVar.al()) {
                c();
            } else if (this.i) {
                try {
                    f();
                } catch (Exception e2) {
                    e2.printStackTrace();
                    c();
                }
            }
        }
    }

    private void f() {
        int i2;
        int i3;
        char c2;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int[] iArr = this.f4491b;
        if (iArr != null) {
            int i9 = iArr[3];
            char c3 = 1;
            int i10 = iArr[1];
            if (i10 != 0) {
                int i11 = 0;
                if (i10 < this.g.size()) {
                    this.g = this.g.subList(0, i10);
                }
                int i12 = 0;
                int i13 = 0;
                while (i13 < i10) {
                    int i14 = i13 == 0 ? 12 : i12 + i9;
                    int i15 = i14 + i9;
                    int[] copyOfRange = Arrays.copyOfRange(this.f4491b, i14, i15);
                    int i16 = i15 + i9;
                    int[] copyOfRange2 = Arrays.copyOfRange(this.f4491b, i15, i16);
                    RectF a2 = a(copyOfRange[i11], copyOfRange2[i11], copyOfRange[32], copyOfRange2[32]);
                    if (this.g.size() == 0 || i13 >= this.g.size()) {
                        float[] a3 = a(copyOfRange[45], copyOfRange2[45]);
                        float f2 = a3[i11];
                        float f3 = a3[c3];
                        ArrayList arrayList = new ArrayList();
                        int i17 = i11;
                        while (i17 < f4490a.length) {
                            int nextInt = this.k.nextInt(2);
                            int i18 = i11;
                            while (true) {
                                int[][] iArr2 = f4490a;
                                if (i18 >= iArr2[i17].length) {
                                    break;
                                }
                                int i19 = iArr2[i17][i18];
                                if (i19 < 0) {
                                    int i20 = iArr2[i17][i18 + 1];
                                    i5 = i18 + 2;
                                    int i21 = iArr2[i17][i5];
                                    i4 = i18;
                                    i6 = nextInt;
                                    RectF rectF = new RectF((float) copyOfRange[i20], (float) copyOfRange2[i20], (float) copyOfRange[i21], (float) copyOfRange2[i21]);
                                    i8 = (int) rectF.centerX();
                                    i7 = (int) rectF.centerY();
                                } else {
                                    i4 = i18;
                                    i6 = nextInt;
                                    i8 = copyOfRange[i19];
                                    i7 = copyOfRange2[i19];
                                    i5 = i4;
                                }
                                int i22 = i4;
                                int i23 = i9;
                                int i24 = i6;
                                int i25 = i10;
                                int i26 = i17;
                                int[] iArr3 = copyOfRange;
                                ArrayList arrayList2 = arrayList;
                                i a4 = a(i8, i7, f2, f3, a2);
                                a4.a(i19);
                                a4.b(i24);
                                a4.c(i26);
                                a4.d(i22);
                                if (i24 == 0) {
                                    a4.s().setAlpha(153);
                                } else {
                                    a4.s().setAlpha(229);
                                }
                                arrayList2.add(a4);
                                i18 = i5 + 1;
                                c3 = 1;
                                nextInt = i24;
                                i17 = i26;
                                arrayList = arrayList2;
                                i10 = i25;
                                i9 = i23;
                                copyOfRange = iArr3;
                            }
                            int i27 = i9;
                            char c4 = c3;
                            int[] iArr4 = copyOfRange;
                            ArrayList arrayList3 = arrayList;
                            i17++;
                            i10 = i10;
                            copyOfRange = iArr4;
                            i11 = 0;
                        }
                        i2 = i9;
                        c2 = c3;
                        i3 = i10;
                        this.g.add(new g(arrayList));
                    } else {
                        a(copyOfRange, copyOfRange2, this.g.get(i13), a2);
                        i2 = i9;
                        c2 = c3;
                        i3 = i10;
                    }
                    i13++;
                    c3 = c2;
                    i12 = i16;
                    i10 = i3;
                    i9 = i2;
                    i11 = 0;
                }
            }
        }
    }

    private void a(int[] iArr, int[] iArr2, g gVar, RectF rectF) {
        int i2;
        int i3;
        List<i> a2 = gVar.a();
        int size = a2.size();
        for (int i4 = 0; i4 < size; i4++) {
            i iVar = a2.get(i4);
            int b2 = iVar.b();
            float d2 = iVar.d();
            float e2 = iVar.e();
            if (b2 < 0) {
                int i5 = f4490a[iVar.h()][iVar.v() + 1];
                int i6 = f4490a[iVar.h()][iVar.v() + 2];
                RectF rectF2 = new RectF((float) iArr[i5], (float) iArr2[i5], (float) iArr[i6], (float) iArr2[i6]);
                i3 = (int) rectF2.centerX();
                i2 = (int) rectF2.centerY();
            } else {
                int i7 = iArr[b2];
                i2 = iArr2[b2];
                i3 = i7;
            }
            float[] a3 = a(i3, i2);
            int i8 = (30.0d > (((double) (iVar.e() - a3[1])) / Math.sin(Math.atan2((double) (iVar.e() - a3[1]), (double) (iVar.d() - a3[0])))) ? 1 : (30.0d == (((double) (iVar.e() - a3[1])) / Math.sin(Math.atan2((double) (iVar.e() - a3[1]), (double) (iVar.d() - a3[0])))) ? 0 : -1));
            if (i8 < 0) {
                iVar.a(rectF.width() * 0.2f * 0.5f);
                iVar.b(a3[0]);
                iVar.c(a3[1]);
            }
            if (i8 < 0 && !iVar.a()) {
                iVar.j(d2);
                iVar.k(e2);
                a(iVar, 100, (Interpolator) new LinearInterpolator(), 0).start();
            }
        }
    }

    private i a(int i2, int i3, float f2, float f3, RectF rectF) {
        i iVar = new i();
        float[] a2 = a(i2, i3);
        iVar.a(rectF.width() * 0.2f * 0.5f);
        iVar.b(a2[0]);
        iVar.c(a2[1]);
        double atan2 = Math.atan2((double) (f3 - iVar.e()), (double) (f2 - iVar.d()));
        double e2 = (((double) (f3 - iVar.e())) / Math.sin(atan2)) + 200.0d;
        iVar.j((float) (((double) f2) - (Math.cos(atan2) * e2)));
        iVar.k((float) (((double) f3) - (e2 * Math.sin(atan2))));
        iVar.l(0.0f);
        iVar.m(0.0f);
        iVar.s().setColor(-1);
        iVar.s().setAntiAlias(true);
        iVar.s().setStyle(Paint.Style.FILL);
        iVar.t().set(iVar.s());
        iVar.t().setAlpha(0);
        iVar.u().set(iVar.s());
        iVar.u().setAlpha(0);
        return iVar;
    }

    private float[] a(int i2, int i3) {
        int width = this.h.getWidth();
        int height = this.h.getHeight();
        this.f.reset();
        this.f.setTranslate((float) ((-this.c.getWidth()) / 2), (float) ((-this.c.getHeight()) / 2));
        this.f.postScale(this.e ? -1.0f : 1.0f, 1.0f);
        this.f.postRotate((float) this.d);
        this.f.postScale((((float) width) * 1.0f) / ((float) this.c.getHeight()), (((float) height) * 1.0f) / ((float) this.c.getWidth()));
        this.f.postTranslate((float) (width / 2), (float) (height / 2));
        float[] fArr = {(float) i2, (float) i3};
        this.f.mapPoints(fArr);
        return fArr;
    }

    private RectF a(int i2, int i3, int i4, int i5) {
        int width = this.h.getWidth();
        int height = this.h.getHeight();
        this.f.reset();
        this.f.setTranslate((float) ((-this.c.getWidth()) / 2), (float) ((-this.c.getHeight()) / 2));
        this.f.postScale(this.e ? -1.0f : 1.0f, 1.0f);
        this.f.postRotate((float) this.d);
        this.f.postScale((((float) width) * 1.0f) / ((float) this.c.getHeight()), (((float) height) * 1.0f) / ((float) this.c.getWidth()));
        this.f.postTranslate((float) (width / 2), (float) (height / 2));
        RectF rectF = new RectF((float) i2, (float) i3, (float) i4, (float) i5);
        this.f.mapRect(rectF);
        return rectF;
    }

    public void a() {
        FaceView faceView = this.h;
        if (faceView != null && !this.i) {
            int[] iArr = this.f4491b;
            if (!(iArr == null || iArr.length == 0 || faceView.getWidth() <= 0)) {
                boolean z = true;
                if (this.f4491b[1] != 0) {
                    this.g.clear();
                    int i2 = this.f4491b[1];
                    try {
                        f();
                        for (g a2 : this.g) {
                            for (i next : a2.a()) {
                                if (!next.f()) {
                                    a(next);
                                }
                            }
                        }
                        if (i2 <= 0) {
                            z = false;
                        }
                        this.i = z;
                        b bVar = this.l;
                        if (bVar != null && this.i) {
                            bVar.aj();
                            return;
                        }
                        return;
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        c();
                        return;
                    }
                }
            }
            this.q.removeMessages(2);
            this.q.sendEmptyMessageDelayed(2, 50);
        }
    }

    private void a(i iVar) {
        i iVar2 = iVar;
        if (!this.j) {
            int h2 = iVar.h() * 50;
            iVar2.a(true);
            ValueAnimator a2 = a(iVar2, 250, this.p, h2);
            i iVar3 = iVar;
            c cVar = new c(iVar3, a.SCALE, 0, h2, 400, this.m, 0.0f, 0.45f);
            c cVar2 = new c(iVar3, a.SCALE, 0, 0, 767, this.n, 0.45f, 0.35f);
            c cVar3 = new c(iVar3, a.SCALE, 0, 0, 600, this.o, 0.35f, 0.0f);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playSequentially(new Animator[]{cVar, cVar2, cVar3});
            float f2 = iVar.g() == 0 ? 0.32f : 0.48f;
            i iVar4 = iVar;
            AnimatorSet animatorSet2 = animatorSet;
            c cVar4 = new c(iVar4, a.SCALE, 1, h2, 400, this.n, 0.2f, f2);
            c cVar5 = new c(iVar4, a.SCALE, 1, 0, 367, this.n, f2, 0.2f);
            c cVar6 = new c(iVar4, a.SCALE, 1, 0, 400, this.n, 0.2f, f2);
            c cVar7 = new c(iVar4, a.SCALE, 1, 0, 367, this.n, f2, 0.2f);
            AnimatorSet animatorSet3 = new AnimatorSet();
            animatorSet3.playSequentially(new Animator[]{cVar4, cVar5, cVar6, cVar7});
            float f3 = iVar.g() == 0 ? 0.61f : 0.77f;
            int i2 = h2 + 767;
            i iVar5 = iVar;
            c cVar8 = new c(iVar5, a.SCALE, 2, i2, 400, this.n, 0.16f, f3);
            c cVar9 = new c(iVar5, a.SCALE, 2, 0, 367, this.n, f3, 0.16f);
            c cVar10 = new c(iVar5, a.ALPHA, 2, i2, 400, this.n, 0.0f, 0.1f);
            c cVar11 = new c(iVar5, a.ALPHA, 2, 0, 367, this.n, 0.1f, 0.0f);
            AnimatorSet animatorSet4 = new AnimatorSet();
            animatorSet4.playSequentially(new Animator[]{cVar8, cVar9});
            AnimatorSet animatorSet5 = new AnimatorSet();
            animatorSet5.playSequentially(new Animator[]{cVar10, cVar11});
            float f4 = iVar.g() == 0 ? 0.84f : 1.0f;
            i iVar6 = iVar;
            c cVar12 = new c(iVar6, a.SCALE, 3, i2, 400, this.n, 0.16f, f4);
            c cVar13 = new c(iVar6, a.SCALE, 3, 0, 367, this.n, f4, 0.16f);
            c cVar14 = new c(iVar6, a.ALPHA, 3, i2, 400, this.n, 0.0f, 0.1f);
            c cVar15 = new c(iVar6, a.ALPHA, 3, 0, 367, this.n, 0.1f, 0.0f);
            AnimatorSet animatorSet6 = new AnimatorSet();
            animatorSet6.playSequentially(new Animator[]{cVar12, cVar13});
            AnimatorSet animatorSet7 = new AnimatorSet();
            animatorSet7.playSequentially(new Animator[]{cVar14, cVar15});
            Animator[] animatorArr = {a2, animatorSet3, animatorSet4, animatorSet5, animatorSet6, animatorSet7};
            AnimatorSet animatorSet8 = animatorSet2;
            animatorSet8.playTogether(animatorArr);
            animatorSet8.start();
        }
    }

    private ValueAnimator a(final i iVar, int i2, Interpolator interpolator, int i3) {
        ValueAnimator ofObject = ValueAnimator.ofObject(new PointFEvaluator() {
            public PointF evaluate(float f, PointF pointF, PointF pointF2) {
                pointF.set(iVar.o(), iVar.p());
                pointF2.set(iVar.d(), iVar.e());
                return new PointF(pointF.x + ((pointF2.x - pointF.x) * f), pointF.y + (f * (pointF2.y - pointF.y)));
            }
        }, new Object[]{new PointF(), new PointF()});
        ofObject.setDuration((long) i2);
        ofObject.setStartDelay((long) i3);
        ofObject.setInterpolator(interpolator);
        ofObject.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (h.this.j) {
                    valueAnimator.cancel();
                    return;
                }
                PointF pointF = (PointF) valueAnimator.getAnimatedValue();
                iVar.l(pointF.x);
                iVar.m(pointF.y);
                if (1.0f <= valueAnimator.getAnimatedFraction()) {
                    iVar.a(false);
                } else {
                    iVar.a(true);
                }
                h.this.h.invalidate();
            }
        });
        return ofObject;
    }

    public void a(b bVar) {
        this.l = bVar;
    }

    public boolean b() {
        return this.i;
    }

    public void c() {
        this.f4491b = null;
        List<g> list = this.g;
        if (list != null) {
            list.clear();
            this.i = false;
        }
        Handler handler = this.q;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
        }
    }

    public void d() {
        Handler handler;
        if (!(this.l == null || (handler = this.q) == null || !handler.hasMessages(1))) {
            this.l.ak();
        }
        c();
        this.j = true;
        this.h = null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0007, code lost:
        r0 = r2.q;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean e() {
        /*
            r2 = this;
            int[] r0 = r2.f4491b
            if (r0 == 0) goto L_0x0007
            int r0 = r0.length
            if (r0 > 0) goto L_0x0012
        L_0x0007:
            android.os.Handler r0 = r2.q
            if (r0 == 0) goto L_0x0014
            r1 = 2
            boolean r0 = r0.hasMessages(r1)
            if (r0 == 0) goto L_0x0014
        L_0x0012:
            r0 = 1
            goto L_0x0015
        L_0x0014:
            r0 = 0
        L_0x0015:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.ui.preview.h.e():boolean");
    }

    /* compiled from: FacePointAnimationManager */
    private class c extends ValueAnimator implements Animator.AnimatorListener, ValueAnimator.AnimatorUpdateListener {

        /* renamed from: b  reason: collision with root package name */
        private i f4498b = null;
        private a c = a.SCALE;
        private int d = 0;

        public void onAnimationRepeat(Animator animator) {
        }

        public c(i iVar, a aVar, int i, int i2, int i3, Interpolator interpolator, float... fArr) {
            this.f4498b = iVar;
            this.d = i;
            setFloatValues(fArr);
            setDuration((long) i3);
            setStartDelay((long) i2);
            setInterpolator(interpolator);
            addUpdateListener(this);
            addListener(this);
            this.c = aVar;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (h.this.j) {
                cancel();
                return;
            }
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            if (a.ALPHA == this.c) {
                int i = (int) (floatValue * 255.0f);
                int i2 = this.d;
                if (1 == i2) {
                    this.f4498b.s().setAlpha(i);
                } else if (2 == i2) {
                    this.f4498b.t().setAlpha(i);
                } else if (3 == i2) {
                    this.f4498b.u().setAlpha(i);
                }
            } else if (a.TRANSLATION_X == this.c) {
                this.f4498b.l(floatValue);
            } else if (a.TRANSLATION_Y == this.c) {
                this.f4498b.m(floatValue);
            } else {
                int i3 = this.d;
                if (i3 == 0) {
                    this.f4498b.n(floatValue);
                    i iVar = this.f4498b;
                    iVar.g(iVar.i() * this.f4498b.c() * floatValue);
                    i iVar2 = this.f4498b;
                    iVar2.h(iVar2.j() * this.f4498b.c() * floatValue);
                    i iVar3 = this.f4498b;
                    iVar3.i(iVar3.k() * this.f4498b.c() * floatValue);
                    h.this.h.invalidate();
                    h.this.q.removeMessages(1);
                    h.this.q.sendEmptyMessageDelayed(1, 50);
                } else if (1 == i3) {
                    this.f4498b.d(floatValue);
                } else if (2 == i3) {
                    this.f4498b.e(floatValue);
                } else if (3 == i3) {
                    this.f4498b.f(floatValue);
                }
            }
        }

        public void onAnimationStart(Animator animator) {
            if (this.d == 0) {
                this.f4498b.b(true);
            }
        }

        public void onAnimationEnd(Animator animator) {
            if (this.d == 0) {
                this.f4498b.b(false);
            }
        }

        public void onAnimationCancel(Animator animator) {
            if (this.d == 0) {
                this.f4498b.b(false);
            }
        }
    }
}
