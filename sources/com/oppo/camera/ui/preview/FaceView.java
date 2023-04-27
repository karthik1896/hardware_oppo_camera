package com.oppo.camera.ui.preview;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.hardware.camera2.params.Face;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Size;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.oppo.camera.R;
import com.oppo.camera.e;
import com.oppo.camera.ui.preview.h;
import com.oppo.camera.util.Util;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class FaceView extends View implements j {
    private float A = 1.0f;
    /* access modifiers changed from: private */
    public int B = 0;
    /* access modifiers changed from: private */
    public int C = 0;
    /* access modifiers changed from: private */
    public int D = 0;
    private Face[] E = null;
    private Face[] F = null;
    private ArrayList<Rect> G = null;
    private ArrayList<Rect> H = null;
    private HashMap<String, String> I = null;
    /* access modifiers changed from: private */
    public ValueAnimator J = null;
    private ValueAnimator K = null;
    private int L = 32;
    /* access modifiers changed from: private */
    public int M = 255;
    /* access modifiers changed from: private */
    public boolean N = false;
    /* access modifiers changed from: private */
    public boolean O = false;
    private float P = 1.0f;
    private volatile boolean Q = false;
    private int R = 0;
    private volatile int S = 0;
    private Queue<Rect[]> T = null;
    private int U = 0;
    private h V = null;

    /* renamed from: a  reason: collision with root package name */
    private int f4331a;

    /* renamed from: b  reason: collision with root package name */
    private int f4332b;
    private boolean c;
    /* access modifiers changed from: private */
    public boolean d;
    private Matrix e = new Matrix();
    private Rect f = null;
    private Rect[] g = null;
    private ArrayList<Rect> h = null;
    private RectF i = new RectF();
    private Face[] j;
    private Face[] k;
    private Drawable l;
    private Drawable m;
    private Drawable n;
    private Paint o;
    private int p = 0;
    private int[] q;
    private int[] r;
    private int[] s;
    private long t = 0;
    private boolean u = false;
    private boolean v = false;
    private boolean w = true;
    private long x = 0;
    private float y = 0.0f;
    private float z = 1.0f;

    private boolean i() {
        return true;
    }

    public FaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.n = Util.b(context, (int) R.drawable.icon_face_detecte);
        this.m = Util.b(context, (int) R.drawable.beauty3d_face_detecte);
        this.R = (int) getResources().getDimension(R.dimen.beauty3d_face_outer_width);
        this.l = this.n;
        this.o = new Paint();
        this.o.setAntiAlias(true);
        this.o.setDither(true);
        this.o.setColor(-1);
        this.o.setStyle(Paint.Style.STROKE);
        this.o.setStrokeCap(Paint.Cap.ROUND);
        this.o.setStrokeWidth(10.0f);
        this.T = new LinkedList();
        this.h = new ArrayList<>();
        this.V = new h(this);
        if (i()) {
            l();
        }
    }

    public void a(Face[] faceArr, int[] iArr) {
        Face[] faceArr2;
        Face[] faceArr3;
        if (!this.d) {
            this.V.a(iArr);
            if (faceArr != null && !this.V.b()) {
                this.k = this.j;
                this.j = faceArr;
                a(faceArr);
                if (!i()) {
                    invalidate();
                } else if (!this.O) {
                    if (this.M != 0 && this.w && !this.N && (faceArr3 = this.j) != null && faceArr3.length > 0) {
                        b(faceArr3);
                    }
                    if (this.D != 0 && this.w && !this.N) {
                        j();
                    } else if (SystemClock.uptimeMillis() - this.x > 100 && this.M == 255 && this.v && ((faceArr2 = this.j) == null || faceArr2.length == 0 || !this.w)) {
                        k();
                    } else if (!this.N && a(this.k, this.j) && this.w) {
                        this.M = 255;
                        this.H.clear();
                        int i2 = 0;
                        while (true) {
                            Face[] faceArr4 = this.j;
                            if (i2 < faceArr4.length) {
                                this.H.add(new Rect(faceArr4[i2].getBounds().left, this.j[i2].getBounds().top, this.j[i2].getBounds().right, this.j[i2].getBounds().bottom));
                                i2++;
                            } else {
                                invalidate();
                                return;
                            }
                        }
                    }
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x00b9  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00c5 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(android.hardware.camera2.params.Face[] r12) {
        /*
            r11 = this;
            int r0 = r11.p
            int r1 = r12.length
            r2 = 1
            r3 = 0
            if (r0 != r1) goto L_0x0009
            r0 = r3
            goto L_0x0057
        L_0x0009:
            int r0 = r12.length
            r11.p = r0
            int r0 = r12.length
            int[] r0 = new int[r0]
            r11.q = r0
            int r0 = r12.length
            int[] r0 = new int[r0]
            r11.r = r0
            int r0 = r12.length
            int[] r0 = new int[r0]
            r11.s = r0
            r0 = r3
        L_0x001c:
            int r1 = r12.length
            if (r0 >= r1) goto L_0x0054
            r1 = r12[r0]
            int[] r4 = r11.q
            android.graphics.Rect r5 = r1.getBounds()
            int r5 = r5.left
            android.graphics.Rect r6 = r1.getBounds()
            int r6 = r6.right
            int r5 = r11.b((int) r5, (int) r6)
            r4[r0] = r5
            int[] r4 = r11.r
            android.graphics.Rect r5 = r1.getBounds()
            int r5 = r5.top
            android.graphics.Rect r6 = r1.getBounds()
            int r6 = r6.bottom
            int r5 = r11.b((int) r5, (int) r6)
            r4[r0] = r5
            int[] r4 = r11.s
            int r1 = r11.a((android.hardware.camera2.params.Face) r1)
            r4[r0] = r1
            int r0 = r0 + 1
            goto L_0x001c
        L_0x0054:
            r11.u = r3
            r0 = r2
        L_0x0057:
            r1 = r0
            r0 = r3
        L_0x0059:
            int r4 = r12.length
            if (r0 >= r4) goto L_0x00c8
            r4 = r12[r0]
            android.graphics.Rect r5 = r4.getBounds()
            int r5 = r5.left
            android.graphics.Rect r6 = r4.getBounds()
            int r6 = r6.right
            int r5 = r11.b((int) r5, (int) r6)
            android.graphics.Rect r6 = r4.getBounds()
            int r6 = r6.top
            android.graphics.Rect r7 = r4.getBounds()
            int r7 = r7.bottom
            int r6 = r11.b((int) r6, (int) r7)
            int r4 = r11.a((android.hardware.camera2.params.Face) r4)
            int[] r7 = r11.s
            r8 = r7[r0]
            r9 = 1050253722(0x3e99999a, float:0.3)
            if (r8 <= 0) goto L_0x009b
            float r8 = (float) r4
            r7 = r7[r0]
            float r7 = (float) r7
            float r8 = r8 / r7
            r7 = 1065353216(0x3f800000, float:1.0)
            int r10 = (r8 > r7 ? 1 : (r8 == r7 ? 0 : -1))
            if (r10 >= 0) goto L_0x0098
            float r8 = r7 / r8
        L_0x0098:
            float r7 = r8 - r7
            goto L_0x009c
        L_0x009b:
            r7 = r9
        L_0x009c:
            int[] r8 = r11.q
            r8 = r8[r0]
            int[] r10 = r11.r
            r10 = r10[r0]
            int r8 = r11.a(r5, r6, r8, r10)
            r10 = 260(0x104, float:3.64E-43)
            if (r8 <= r10) goto L_0x00b0
            r11.u = r3
        L_0x00ae:
            r1 = r2
            goto L_0x00b7
        L_0x00b0:
            int r7 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r7 < 0) goto L_0x00b7
            r11.u = r3
            goto L_0x00ae
        L_0x00b7:
            if (r1 == 0) goto L_0x00c5
            int[] r7 = r11.q
            r7[r0] = r5
            int[] r5 = r11.r
            r5[r0] = r6
            int[] r5 = r11.s
            r5[r0] = r4
        L_0x00c5:
            int r0 = r0 + 1
            goto L_0x0059
        L_0x00c8:
            long r4 = android.os.SystemClock.elapsedRealtime()
            if (r1 != 0) goto L_0x00e9
            boolean r12 = r11.u
            if (r12 == 0) goto L_0x00e9
            long r0 = r11.t
            long r4 = r4 - r0
            r0 = 3000(0xbb8, double:1.482E-320)
            int r12 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r12 <= 0) goto L_0x00e9
            boolean r12 = r11.O
            if (r12 != 0) goto L_0x00e9
            r11.w = r3
            java.util.Queue<android.graphics.Rect[]> r12 = r11.T
            if (r12 == 0) goto L_0x00fc
            r12.clear()
            goto L_0x00fc
        L_0x00e9:
            boolean r12 = r11.w
            if (r12 != 0) goto L_0x00fa
            long r0 = android.os.SystemClock.uptimeMillis()
            r11.x = r0
            java.util.Queue<android.graphics.Rect[]> r12 = r11.T
            if (r12 == 0) goto L_0x00fa
            r12.clear()
        L_0x00fa:
            r11.w = r2
        L_0x00fc:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.ui.preview.FaceView.a(android.hardware.camera2.params.Face[]):void");
    }

    private int a(int i2, int i3) {
        return Math.abs(i3 - i2);
    }

    private int a(int i2, int i3, int i4, int i5) {
        int i6 = i4 - i2;
        int i7 = i5 - i3;
        return (int) Math.sqrt((double) ((i6 * i6) + (i7 * i7)));
    }

    private int b(int i2, int i3) {
        return (i2 + i3) / 2;
    }

    private int a(Face face) {
        return Math.abs(face.getBounds().right - face.getBounds().left) * Math.abs(face.getBounds().bottom - face.getBounds().top);
    }

    private int a(Rect rect) {
        if (rect == null) {
            return 0;
        }
        return Math.abs(rect.right - rect.left) * Math.abs(rect.bottom - rect.top);
    }

    public Rect[] getFaceRects() {
        return this.g;
    }

    public void setDisplayOrientation(int i2) {
        this.f4331a = i2;
        this.V.a(i2);
    }

    public void a(int i2, boolean z2) {
        this.f4332b = i2;
        invalidate();
    }

    public void setMirror(boolean z2) {
        this.c = z2;
        this.V.a(z2);
    }

    public void a(Rect rect, Size size) {
        this.f = rect;
        this.V.a(size);
    }

    public void setEISScale(float f2) {
        this.P = f2;
        this.U = ((int) Math.sqrt((double) (this.z * this.P * this.A))) + 4;
    }

    public void setZoomValue(float f2) {
        this.z = f2;
        this.U = ((int) Math.sqrt((double) (this.z * this.P * this.A))) + 4;
    }

    public void setFaceSlenderZoomValue(float f2) {
        this.A = f2;
        this.U = ((int) Math.sqrt((double) (this.z * this.P * this.A))) + 4;
    }

    public boolean a() {
        Face[] faceArr = this.j;
        return faceArr != null && faceArr.length > 0;
    }

    public void b() {
        h hVar = this.V;
        if (hVar != null && hVar.e()) {
            this.V.c();
        }
    }

    public void a(boolean z2, boolean z3) {
        this.l = this.n;
        e.a("FaceView", "showSuccess()");
        invalidate();
    }

    public void c() {
        if (this.j != null) {
            e.a("FaceView", "clear()");
            this.l = this.n;
            this.j = null;
            this.p = 0;
            ArrayList<Rect> arrayList = this.H;
            if (arrayList != null && arrayList.size() > 0) {
                this.H.clear();
                invalidate();
            }
        }
        Queue<Rect[]> queue = this.T;
        if (queue != null) {
            queue.clear();
        }
        ArrayList<Rect> arrayList2 = this.h;
        if (arrayList2 != null) {
            arrayList2.clear();
        }
    }

    public void d() {
        e.a("FaceView", "pause()");
        this.d = true;
    }

    public void e() {
        e.a("FaceView", "resume()");
        this.d = false;
    }

    public void f() {
        this.d = true;
        this.l = null;
        this.n = null;
        this.j = null;
        this.h = null;
        this.e = null;
        this.o = null;
        this.T = null;
        m();
        h hVar = this.V;
        if (hVar != null) {
            hVar.d();
        }
        this.V = null;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        int i2;
        ArrayList<Rect> arrayList;
        Face[] faceArr;
        this.e.reset();
        this.v = false;
        ArrayList<Rect> arrayList2 = this.H;
        if (arrayList2 != null) {
            i2 = arrayList2.size();
        } else {
            Face[] faceArr2 = this.j;
            i2 = faceArr2 != null ? faceArr2.length : 0;
        }
        ArrayList<Rect> arrayList3 = this.h;
        if (arrayList3 != null) {
            arrayList3.clear();
        }
        this.V.a(canvas);
        if (i2 > 0) {
            this.e.setTranslate((float) ((-this.f.width()) / 2), (float) ((-this.f.height()) / 2));
            this.e.postScale(this.c ? -1.0f : 1.0f, 1.0f);
            this.e.postRotate((float) this.f4331a);
            this.e.postScale((((((float) getWidth()) * this.z) * this.P) * this.A) / ((float) this.f.height()), (((((float) getHeight()) * this.z) * this.P) * this.A) / ((float) this.f.width()));
            this.e.postTranslate((float) (getWidth() / 2), (float) (getHeight() / 2));
            this.g = new Rect[i2];
            int i3 = 0;
            for (int i4 = 0; i4 < i2; i4++) {
                ArrayList<Rect> arrayList4 = this.H;
                if (arrayList4 != null) {
                    this.i.set(arrayList4.get(i4));
                } else {
                    this.i.set(this.j[i4].getBounds());
                }
                this.i.offset((float) (-this.f.left), (float) (-this.f.top));
                this.e.mapRect(this.i);
                Rect rect = new Rect(Math.max(0, Math.round(this.i.left)), Math.max(0, Math.round(this.i.top)), Math.min(getWidth(), Math.round(this.i.right)), Math.min(getHeight(), Math.round(this.i.bottom)));
                int a2 = a(rect);
                if (a2 >= i3) {
                    i3 = a2;
                }
                this.g[i4] = rect;
            }
            Queue<Rect[]> queue = this.T;
            if (queue != null) {
                Rect[] rectArr = this.g;
                if (rectArr.length > 0) {
                    queue.offer(rectArr);
                }
            }
            while (true) {
                Queue<Rect[]> queue2 = this.T;
                if (queue2 == null || queue2.size() <= this.U) {
                    Queue<Rect[]> queue3 = this.T;
                } else {
                    this.T.poll();
                }
            }
            Queue<Rect[]> queue32 = this.T;
            if (!(queue32 == null || (faceArr = this.k) == null || this.g.length == faceArr.length)) {
                queue32.clear();
                this.T.offer(this.g);
            }
            Queue<Rect[]> queue4 = this.T;
            if (queue4 != null && queue4.size() > 0) {
                for (int i5 = 0; i5 < this.g.length; i5++) {
                    int i6 = 0;
                    int i7 = 0;
                    int i8 = 0;
                    int i9 = 0;
                    int i10 = 0;
                    for (Rect[] rectArr2 : this.T) {
                        if (rectArr2.length > i5 && !rectArr2[i5].isEmpty()) {
                            i7 += rectArr2[i5].left;
                            i9 += rectArr2[i5].right;
                            i8 += rectArr2[i5].top;
                            i10 += rectArr2[i5].bottom;
                            i6++;
                        }
                    }
                    if (!(i6 == 0 || (arrayList = this.h) == null)) {
                        arrayList.add(new Rect(i7 / i6, i8 / i6, i9 / i6, i10 / i6));
                    }
                }
            }
            ArrayList<Rect> arrayList5 = this.h;
            if (arrayList5 != null && !arrayList5.isEmpty()) {
                for (int i11 = 0; i11 < this.h.size(); i11++) {
                    this.l.setBounds(this.h.get(i11));
                    if (this.w) {
                        if (!this.u) {
                            this.t = SystemClock.elapsedRealtime();
                        }
                        this.u = true;
                        this.v = true;
                        if (!this.Q) {
                            this.l.setAlpha(this.M);
                            this.l.draw(canvas);
                        } else if (i11 == this.S) {
                            a(canvas, this.h.get(i11));
                        } else {
                            this.l.setAlpha(this.M);
                            this.l.draw(canvas);
                        }
                    }
                }
            } else {
                return;
            }
        }
        ArrayList<Rect> arrayList6 = this.H;
        if (arrayList6 != null && this.M == 0 && arrayList6.size() > 0) {
            this.H.clear();
        }
        ArrayList<Rect> arrayList7 = this.h;
        if (arrayList7 != null) {
            arrayList7.clear();
        }
        super.onDraw(canvas);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0032, code lost:
        if (r5 != 270) goto L_0x006d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(android.graphics.Canvas r9, android.graphics.Rect r10) {
        /*
            r8 = this;
            if (r9 == 0) goto L_0x0070
            if (r10 != 0) goto L_0x0005
            goto L_0x0070
        L_0x0005:
            r9.save()
            int r0 = r10.left
            int r1 = r8.R
            int r0 = r0 - r1
            int r1 = r10.right
            int r2 = r8.R
            int r1 = r1 + r2
            int r2 = r10.top
            int r3 = r8.R
            int r2 = r2 - r3
            int r10 = r10.bottom
            int r3 = r8.R
            int r10 = r10 + r3
            int r3 = r8.c((int) r0, (int) r1)
            int r4 = r8.c((int) r2, (int) r10)
            int r5 = r8.f4332b
            if (r5 == 0) goto L_0x0054
            r6 = 90
            r7 = 180(0xb4, float:2.52E-43)
            if (r5 == r6) goto L_0x0035
            if (r5 == r7) goto L_0x0054
            r6 = 270(0x10e, float:3.78E-43)
            if (r5 == r6) goto L_0x0035
            goto L_0x006d
        L_0x0035:
            int r5 = r8.f4332b
            int r5 = r5 - r7
            float r5 = (float) r5
            float r3 = (float) r3
            float r4 = (float) r4
            r9.rotate(r5, r3, r4)
            android.graphics.drawable.Drawable r3 = r8.m
            int r10 = r10 - r2
            int r10 = r10 + r0
            int r1 = r1 - r0
            int r1 = r1 + r2
            r3.setBounds(r0, r2, r10, r1)
            android.graphics.drawable.Drawable r10 = r8.m
            int r0 = r8.M
            r10.setAlpha(r0)
            android.graphics.drawable.Drawable r10 = r8.m
            r10.draw(r9)
            goto L_0x006d
        L_0x0054:
            int r5 = r8.f4332b
            float r5 = (float) r5
            float r3 = (float) r3
            float r4 = (float) r4
            r9.rotate(r5, r3, r4)
            android.graphics.drawable.Drawable r3 = r8.m
            r3.setBounds(r0, r2, r1, r10)
            android.graphics.drawable.Drawable r10 = r8.m
            int r0 = r8.M
            r10.setAlpha(r0)
            android.graphics.drawable.Drawable r10 = r8.m
            r10.draw(r9)
        L_0x006d:
            r9.restore()
        L_0x0070:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.ui.preview.FaceView.a(android.graphics.Canvas, android.graphics.Rect):void");
    }

    private int c(int i2, int i3) {
        return i2 + ((i3 - i2) / 2);
    }

    private void j() {
        if (!this.N) {
            this.N = true;
            this.M = 255;
            setLayerType(2, (Paint) null);
            int i2 = this.L;
            this.B = (i2 / 16) + 1;
            this.C = 0;
            this.y = 100.0f / ((float) this.B);
            ValueAnimator valueAnimator = this.J;
            if (valueAnimator != null) {
                valueAnimator.setDuration((long) i2);
                this.J.start();
            }
        }
    }

    private boolean a(Face[] faceArr, Face[] faceArr2) {
        int i2;
        if (faceArr == null || faceArr2 == null || faceArr.length <= 0 || faceArr.length != faceArr2.length) {
            i2 = 0;
        } else {
            i2 = 0;
            for (int i3 = 0; i3 < faceArr.length; i3++) {
                Rect bounds = faceArr[i3].getBounds();
                int b2 = b(bounds.left, bounds.right);
                int b3 = b(bounds.top, bounds.bottom);
                int a2 = a(faceArr[i3]);
                int i4 = 0;
                while (true) {
                    if (i4 >= faceArr2.length) {
                        break;
                    } else if (-1 == faceArr2[i3].getId() || faceArr[i3].getId() != faceArr2[i4].getId()) {
                        i4++;
                    } else {
                        Rect bounds2 = faceArr2[i4].getBounds();
                        int b4 = b(bounds2.left, bounds2.right);
                        int b5 = b(bounds2.top, bounds2.bottom);
                        int a3 = a(faceArr2[i4]);
                        if (a(b2, b3, b4, b5) == 0 && a(a2, a3) == 0) {
                            i2++;
                        }
                    }
                }
            }
        }
        if (faceArr != null && faceArr2 != null && i2 == faceArr2.length && i2 == faceArr.length) {
            return false;
        }
        if (faceArr == null && faceArr2 == null) {
            return false;
        }
        return true;
    }

    private void b(Face[] faceArr) {
        Face[] faceArr2;
        if (a(this.F, faceArr)) {
            this.L = 32;
            int i2 = 0;
            this.D = 0;
            this.E = this.F;
            this.F = faceArr;
            this.G.clear();
            this.I.clear();
            Face[] faceArr3 = this.E;
            if (faceArr3 != null && (faceArr2 = this.F) != null && faceArr3.length > 0 && faceArr2.length > 0) {
                int i3 = 0;
                while (true) {
                    Face[] faceArr4 = this.E;
                    if (i3 >= faceArr4.length) {
                        break;
                    }
                    Rect bounds = faceArr4[i3].getBounds();
                    int b2 = b(bounds.left, bounds.right);
                    int b3 = b(bounds.top, bounds.bottom);
                    int a2 = a(this.E[i3]);
                    int i4 = 0;
                    while (true) {
                        Face[] faceArr5 = this.F;
                        if (i4 >= faceArr5.length) {
                            break;
                        }
                        if (-1 != faceArr5[i4].getId() && this.F[i4].getId() == this.E[i3].getId() && !this.I.containsKey(String.valueOf(i4))) {
                            Rect bounds2 = this.F[i4].getBounds();
                            int b4 = b(bounds2.left, bounds2.right);
                            int b5 = b(bounds2.top, bounds2.bottom);
                            int a3 = a(this.F[i4]);
                            a(a2, a3);
                            int a4 = a(b2, b3, b4, b5);
                            float f2 = 0.0f;
                            if (a2 > 0) {
                                float f3 = (((float) a3) * 1.0f) / ((float) a2);
                                if (f3 < 1.0f) {
                                    f3 = 1.0f / f3;
                                }
                                f2 = f3 - 1.0f;
                            }
                            if (a4 > 2 || f2 > 0.01f) {
                                int a5 = Util.a((int) ((((float) a4) / 30.0f) * 32.0f), 32, 96);
                                int a6 = Util.a((int) (f2 * 32.0f * 1.5f), 32, 160);
                                if (a5 > this.L) {
                                    this.L = a5;
                                }
                                if (a6 > this.L) {
                                    this.L = a6;
                                }
                                this.D = 1 << i4;
                                this.I.put(String.valueOf(i4), String.valueOf(i3));
                                this.G.add(new Rect(bounds2.left - bounds.left, bounds2.top - bounds.top, bounds2.right - bounds.right, bounds2.bottom - bounds.bottom));
                            }
                        }
                        i4++;
                    }
                    i3++;
                }
            }
            if (this.D != 0) {
                this.H.clear();
                while (true) {
                    Face[] faceArr6 = this.F;
                    if (i2 < faceArr6.length) {
                        this.H.add(new Rect(faceArr6[i2].getBounds().left, this.F[i2].getBounds().top, this.F[i2].getBounds().right, this.F[i2].getBounds().bottom));
                        i2++;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    private void k() {
        if (!this.O) {
            this.w = true;
            ValueAnimator valueAnimator = this.J;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.J.cancel();
            }
            ValueAnimator valueAnimator2 = this.K;
            if (valueAnimator2 != null) {
                this.O = true;
                valueAnimator2.start();
            }
        }
    }

    private void l() {
        this.G = new ArrayList<>();
        this.H = new ArrayList<>();
        this.I = new HashMap<>();
        this.J = ValueAnimator.ofInt(new int[]{0, 100});
        this.J.setDuration((long) this.L);
        this.J.setInterpolator(new LinearInterpolator());
        this.J.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                if (FaceView.this.d && FaceView.this.J != null) {
                    FaceView.this.J.cancel();
                } else if (FaceView.this.N && FaceView.this.C < FaceView.this.B) {
                    if (!FaceView.this.O || FaceView.this.J == null) {
                        FaceView.this.a(intValue);
                        FaceView.this.invalidate();
                        return;
                    }
                    FaceView.this.J.end();
                }
            }
        });
        this.J.addListener(new Animator.AnimatorListener() {
            public void onAnimationRepeat(Animator animator) {
            }

            public void onAnimationStart(Animator animator) {
                boolean unused = FaceView.this.N = true;
            }

            public void onAnimationEnd(Animator animator) {
                FaceView.this.setLayerType(0, (Paint) null);
                boolean unused = FaceView.this.N = false;
                int unused2 = FaceView.this.D = 0;
            }

            public void onAnimationCancel(Animator animator) {
                boolean unused = FaceView.this.N = false;
            }
        });
        this.K = ValueAnimator.ofInt(new int[]{255, 0});
        this.K.setDuration(300);
        this.K.setInterpolator(new LinearInterpolator());
        this.K.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int unused = FaceView.this.M = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                FaceView.this.invalidate();
            }
        });
        this.K.addListener(new Animator.AnimatorListener() {
            public void onAnimationCancel(Animator animator) {
            }

            public void onAnimationRepeat(Animator animator) {
            }

            public void onAnimationStart(Animator animator) {
            }

            public void onAnimationEnd(Animator animator) {
                boolean unused = FaceView.this.O = false;
            }
        });
    }

    /* access modifiers changed from: private */
    public void a(int i2) {
        int i3 = this.C;
        this.C = i3 + 1;
        float f2 = (i3 < this.B ? ((float) this.C) * this.y : 100.0f) / 100.0f;
        if (i2 >= 100) {
            f2 = 1.0f;
            this.C = this.B;
        }
        int i4 = 0;
        int i5 = 0;
        while (true) {
            ArrayList<Rect> arrayList = this.H;
            if (arrayList != null && i4 < arrayList.size()) {
                if ((this.D & (1 << i4)) != 0) {
                    int parseInt = Integer.parseInt(this.I.get(String.valueOf(i4)));
                    this.H.get(i4).left = this.E[parseInt].getBounds().left + ((int) (((float) this.G.get(i5).left) * f2));
                    this.H.get(i4).top = this.E[parseInt].getBounds().top + ((int) (((float) this.G.get(i5).top) * f2));
                    this.H.get(i4).right = this.E[parseInt].getBounds().right + ((int) (((float) this.G.get(i5).right) * f2));
                    this.H.get(i4).bottom = this.E[parseInt].getBounds().bottom + ((int) (((float) this.G.get(i5).bottom) * f2));
                    i5++;
                }
                i4++;
            } else {
                return;
            }
        }
    }

    private void m() {
        if (i()) {
            this.D = 0;
            this.E = null;
            this.F = null;
            this.k = null;
            this.j = null;
            ValueAnimator valueAnimator = this.J;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.J.end();
            }
            ValueAnimator valueAnimator2 = this.K;
            if (valueAnimator2 != null && valueAnimator2.isRunning()) {
                this.K.end();
            }
            this.J = null;
            this.K = null;
            ArrayList<Rect> arrayList = this.G;
            if (arrayList != null) {
                arrayList.clear();
                this.G = null;
            }
            ArrayList<Rect> arrayList2 = this.H;
            if (arrayList2 != null) {
                arrayList2.clear();
                this.H = null;
            }
            HashMap<String, String> hashMap = this.I;
            if (hashMap != null) {
                hashMap.clear();
                this.I = null;
            }
        }
    }

    public void setShowBeauty3DFace(boolean z2) {
        this.Q = z2;
    }

    public void setMainFaceIndex(int i2) {
        this.S = i2;
    }

    public boolean g() {
        Face[] faceArr = this.j;
        return faceArr == null || faceArr.length == 0 || (!this.w && !this.O);
    }

    public void h() {
        h hVar = this.V;
        if (hVar != null) {
            hVar.a();
        }
    }

    public void setFacePointAnimationListener(h.b bVar) {
        h hVar = this.V;
        if (hVar != null) {
            hVar.a(bVar);
        }
    }
}
