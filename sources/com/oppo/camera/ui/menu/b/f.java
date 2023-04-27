package com.oppo.camera.ui.menu.b;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.GLUtils;
import android.text.TextPaint;
import android.view.animation.PathInterpolator;
import com.a.a.g;
import com.a.a.h;
import com.a.a.j;
import com.oppo.camera.R;
import com.oppo.camera.e;
import com.oppo.camera.util.Util;
import java.util.ArrayList;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* compiled from: HeadlineRenderer */
public class f implements GLSurfaceView.Renderer, com.oppo.camera.ui.inverse.a {
    private static Typeface L;
    private static Typeface M;
    private int A = 0;
    private float B = 1.0f;
    /* access modifiers changed from: private */
    public a C = null;
    private int D = 0;
    private int E = 0;
    private int F = 0;
    private e G = new e();
    private int H = 0;
    private int I = 0;
    private int J = 0;
    private float K = 0.0f;
    private PathInterpolator N = new PathInterpolator(0.2f, 0.0f, 0.0f, 1.0f);
    private com.a.a.f O = null;
    private boolean P = false;
    private int Q = 0;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final Object f4088a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private final ArrayList<String> f4089b = new ArrayList<>();
    private int c = -1;
    private int d = -1;
    private float e = 0.0f;
    private float f = 0.0f;
    private float g = 0.0f;
    private float h = 0.0f;
    private float i = 0.0f;
    private float j = 0.0f;
    private float k = 0.0f;
    private float l = 0.0f;
    private b m = null;
    private Context n = null;
    private float[] o = null;
    private String[] p = null;
    private int q = 0;
    private int r = 0;
    private int s = -1;
    private volatile boolean t = true;
    /* access modifiers changed from: private */
    public float u = 0.0f;
    private float v = 0.0f;
    private volatile int w = 0;
    private int x = 0;
    private int y = 0;
    private volatile int z = 0;

    /* compiled from: HeadlineRenderer */
    public interface a {
        c a();

        void a(int i, int i2, float f);

        void a(int i, boolean z);
    }

    public f(Context context, int i2, int i3, a aVar) {
        if (context != null) {
            this.n = context;
            this.Q = context.getColor(R.color.inverse_text_color);
            this.C = aVar;
            this.D = context.getResources().getDimensionPixelSize(R.dimen.head_line_normal_size);
            this.E = context.getResources().getDimensionPixelSize(R.dimen.head_line_pressed_size);
            this.F = context.getResources().getDimensionPixelSize(R.dimen.headline_item_gap);
            this.H = context.getResources().getDimensionPixelSize(R.dimen.head_line_background_height);
            this.I = context.getResources().getDimensionPixelSize(R.dimen.head_line_background_radius);
            this.J = context.getResources().getDimensionPixelSize(R.dimen.head_line_background_padding);
            this.d = i2;
            this.c = i3;
            float f2 = (float) i3;
            this.l = f2 / 2.0f;
            float f3 = this.l;
            this.e = ((float) i2) / f3;
            this.f = f2 / f3;
            float f4 = this.e;
            this.g = (-f4) / 2.0f;
            this.h = f4 / 2.0f;
            float f5 = this.f;
            this.i = f5 / 2.0f;
            this.j = (-f5) / 2.0f;
            this.k = (float) (((double) (f4 / 2.0f)) / Math.sin(Math.toRadians(22.5d)));
            this.q = (int) (((double) this.k) * Math.toRadians(126.0d) * ((double) this.l));
            this.r = this.c;
            d();
            e.a("HeadlineRenderer", "HeadlineRenderer, mNormalTextSize: " + this.D + ", mSelectTextSize: " + this.E + ", mTextGap: " + this.F + ", mSelectBackgroundHeight: " + this.H + ", mSelectBackgroundRadius: " + this.I + ", mSelectBackgroundPadding: " + this.J + ", mWidthPixel: " + this.d + ", mHeightPixel: " + this.c + ", mModelUnitPixel: " + this.l + ", mModelWidth: " + this.e + ", mModelHeight: " + this.f + ", mProjectNearLeft: " + this.g + ", mProjectNearRight: " + this.h + ", mProjectNearTop: " + this.i + ", mProjectNearBottom: " + this.j + ", mRadius: " + this.k + ", mTextureWidth: " + this.q + ", mTextureHeight: " + this.r);
            return;
        }
        throw new IllegalArgumentException("the context can't be null");
    }

    private void d() {
        this.O = j.c().b().a(g.b(2.0d, 35.0d));
        this.O.a((h) new b());
    }

    public void a(String[] strArr) {
        e.a("HeadlineRenderer", "updateTextArray");
        if (strArr == null || strArr.length <= 0) {
            throw new IllegalArgumentException("the text array can't be null or it's length can't be 0");
        }
        synchronized (this.f4088a) {
            this.p = strArr;
        }
    }

    public int b(String[] strArr) {
        e.b("HeadlineRenderer", "updateTextAndIndex");
        if (strArr == null || strArr.length <= 0) {
            throw new IllegalArgumentException("the text array can't be null or it's length can't be 0");
        }
        synchronized (this.f4088a) {
            String str = this.p[this.x];
            String str2 = this.p[this.w];
            this.p = strArr;
            a(str, str2);
        }
        return this.w;
    }

    public void setInverseColor(boolean z2) {
        this.C.a().queueEvent(new Runnable(z2) {
            private final /* synthetic */ boolean f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                f.this.a(this.f$1);
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(boolean z2) {
        this.P = z2;
        this.t = true;
        this.C.a().requestRender();
    }

    public int a() {
        return this.x;
    }

    public void a(int i2) {
        synchronized (this.f4088a) {
            if (this.p != null && this.p.length > 0 && i2 >= 0) {
                if (i2 < this.p.length) {
                    this.x = this.w;
                    this.w = i2;
                    e.a("HeadlineRenderer", "updateCurrentIndex, mLastIndex: " + this.x + ", mCurrentIndex: " + this.w);
                    return;
                }
            }
            e.d("HeadlineRenderer", "updateCurrentIndex, mTextArray: " + this.p + ", index: " + i2 + ", mCurrentIndex: " + this.w);
        }
    }

    public void a(String str, String str2) {
        int i2 = this.x;
        int i3 = this.w;
        int i4 = 0;
        while (true) {
            String[] strArr = this.p;
            if (i4 >= strArr.length) {
                i4 = 0;
                break;
            } else if (str.equals(strArr[i4])) {
                break;
            } else {
                i4++;
            }
        }
        int i5 = 0;
        while (true) {
            String[] strArr2 = this.p;
            if (i5 >= strArr2.length) {
                i5 = 0;
                break;
            } else if (str2.equals(strArr2[i5])) {
                break;
            } else {
                i5++;
            }
        }
        if (i2 != i4) {
            this.x = i4;
        }
        if (i3 != i5) {
            a(i5, false);
        }
        e.a("HeadlineRenderer", "updateIndex, mLastIndex: " + this.x + ", mCurrentIndex: " + this.w);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0056, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(int r5, boolean r6) {
        /*
            r4 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "setCurrentIndex, from mCurrentIndex: "
            r0.append(r1)
            int r1 = r4.w
            r0.append(r1)
            java.lang.String r1 = " to target index: "
            r0.append(r1)
            r0.append(r5)
            java.lang.String r1 = ", updateLastIndex: "
            r0.append(r1)
            r0.append(r6)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "HeadlineRenderer"
            com.oppo.camera.e.a(r1, r0)
            java.lang.Object r0 = r4.f4088a
            monitor-enter(r0)
            java.lang.String[] r1 = r4.p     // Catch:{ all -> 0x0083 }
            r2 = 0
            if (r1 == 0) goto L_0x0057
            java.lang.String[] r1 = r4.p     // Catch:{ all -> 0x0083 }
            int r1 = r1.length     // Catch:{ all -> 0x0083 }
            if (r1 <= 0) goto L_0x0057
            if (r5 < 0) goto L_0x0057
            java.lang.String[] r1 = r4.p     // Catch:{ all -> 0x0083 }
            int r1 = r1.length     // Catch:{ all -> 0x0083 }
            if (r5 < r1) goto L_0x003d
            goto L_0x0057
        L_0x003d:
            r1 = 2
            r4.c((int) r1)     // Catch:{ all -> 0x0083 }
            if (r6 == 0) goto L_0x0047
            int r6 = r4.w     // Catch:{ all -> 0x0083 }
            r4.x = r6     // Catch:{ all -> 0x0083 }
        L_0x0047:
            r4.w = r5     // Catch:{ all -> 0x0083 }
            r5 = 1
            r4.t = r5     // Catch:{ all -> 0x0083 }
            com.oppo.camera.ui.menu.b.f$a r6 = r4.C     // Catch:{ all -> 0x0083 }
            if (r6 == 0) goto L_0x0055
            com.oppo.camera.ui.menu.b.f$a r6 = r4.C     // Catch:{ all -> 0x0083 }
            r6.a(r2, r5)     // Catch:{ all -> 0x0083 }
        L_0x0055:
            monitor-exit(r0)     // Catch:{ all -> 0x0083 }
            return r5
        L_0x0057:
            java.lang.String r6 = "HeadlineRenderer"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0083 }
            r1.<init>()     // Catch:{ all -> 0x0083 }
            java.lang.String r3 = "setCurrentIndex, mTextArray: "
            r1.append(r3)     // Catch:{ all -> 0x0083 }
            java.lang.String[] r3 = r4.p     // Catch:{ all -> 0x0083 }
            r1.append(r3)     // Catch:{ all -> 0x0083 }
            java.lang.String r3 = ", index: "
            r1.append(r3)     // Catch:{ all -> 0x0083 }
            r1.append(r5)     // Catch:{ all -> 0x0083 }
            java.lang.String r5 = ", mCurrentIndex: "
            r1.append(r5)     // Catch:{ all -> 0x0083 }
            int r5 = r4.w     // Catch:{ all -> 0x0083 }
            r1.append(r5)     // Catch:{ all -> 0x0083 }
            java.lang.String r5 = r1.toString()     // Catch:{ all -> 0x0083 }
            com.oppo.camera.e.e(r6, r5)     // Catch:{ all -> 0x0083 }
            monitor-exit(r0)     // Catch:{ all -> 0x0083 }
            return r2
        L_0x0083:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0083 }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.ui.menu.b.f.a(int, boolean):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00a5, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean b(int r7) {
        /*
            r6 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "setCurrentIndexWithAnim, index: "
            r0.append(r1)
            r0.append(r7)
            java.lang.String r1 = ", mCurrentIndex: "
            r0.append(r1)
            int r1 = r6.w
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "HeadlineRenderer"
            com.oppo.camera.e.a(r1, r0)
            java.lang.Object r0 = r6.f4088a
            monitor-enter(r0)
            java.lang.String[] r1 = r6.p     // Catch:{ all -> 0x00db }
            r2 = 0
            if (r1 == 0) goto L_0x00af
            java.lang.String[] r1 = r6.p     // Catch:{ all -> 0x00db }
            int r1 = r1.length     // Catch:{ all -> 0x00db }
            if (r1 <= 0) goto L_0x00af
            if (r7 < 0) goto L_0x00af
            java.lang.String[] r1 = r6.p     // Catch:{ all -> 0x00db }
            int r1 = r1.length     // Catch:{ all -> 0x00db }
            if (r7 < r1) goto L_0x0036
            goto L_0x00af
        L_0x0036:
            float[] r1 = r6.o     // Catch:{ all -> 0x00db }
            if (r1 == 0) goto L_0x00a6
            float[] r1 = r6.o     // Catch:{ all -> 0x00db }
            int r1 = r1.length     // Catch:{ all -> 0x00db }
            if (r1 <= 0) goto L_0x00a6
            int r1 = r7 + 1
            float[] r3 = r6.o     // Catch:{ all -> 0x00db }
            int r3 = r3.length     // Catch:{ all -> 0x00db }
            if (r1 < r3) goto L_0x0047
            goto L_0x00a6
        L_0x0047:
            int r1 = r6.w     // Catch:{ all -> 0x00db }
            r6.x = r1     // Catch:{ all -> 0x00db }
            r6.w = r7     // Catch:{ all -> 0x00db }
            r7 = 1
            r6.t = r7     // Catch:{ all -> 0x00db }
            com.oppo.camera.ui.menu.b.f$a r1 = r6.C     // Catch:{ all -> 0x00db }
            if (r1 == 0) goto L_0x00a4
            float[] r1 = r6.o     // Catch:{ all -> 0x00db }
            int r2 = r6.x     // Catch:{ all -> 0x00db }
            r1 = r1[r2]     // Catch:{ all -> 0x00db }
            float[] r2 = r6.o     // Catch:{ all -> 0x00db }
            int r3 = r6.x     // Catch:{ all -> 0x00db }
            int r3 = r3 + r7
            r2 = r2[r3]     // Catch:{ all -> 0x00db }
            float r1 = r1 + r2
            r2 = 1073741824(0x40000000, float:2.0)
            float r1 = r1 / r2
            float[] r3 = r6.o     // Catch:{ all -> 0x00db }
            int r4 = r6.w     // Catch:{ all -> 0x00db }
            r3 = r3[r4]     // Catch:{ all -> 0x00db }
            float[] r4 = r6.o     // Catch:{ all -> 0x00db }
            int r5 = r6.w     // Catch:{ all -> 0x00db }
            int r5 = r5 + r7
            r4 = r4[r5]     // Catch:{ all -> 0x00db }
            float r3 = r3 + r4
            float r3 = r3 / r2
            com.a.a.f r2 = r6.O     // Catch:{ all -> 0x00db }
            if (r2 != 0) goto L_0x007b
            r6.d()     // Catch:{ all -> 0x00db }
        L_0x007b:
            com.a.a.f r2 = r6.O     // Catch:{ all -> 0x00db }
            double r4 = (double) r1     // Catch:{ all -> 0x00db }
            com.a.a.f r2 = r2.a((double) r4)     // Catch:{ all -> 0x00db }
            double r4 = (double) r3     // Catch:{ all -> 0x00db }
            r2.b(r4)     // Catch:{ all -> 0x00db }
            java.lang.String r2 = "HeadlineRenderer"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x00db }
            r4.<init>()     // Catch:{ all -> 0x00db }
            java.lang.String r5 = "setCurrentIndexWithAnim, startAngle: "
            r4.append(r5)     // Catch:{ all -> 0x00db }
            r4.append(r1)     // Catch:{ all -> 0x00db }
            java.lang.String r1 = ", endAngle: "
            r4.append(r1)     // Catch:{ all -> 0x00db }
            r4.append(r3)     // Catch:{ all -> 0x00db }
            java.lang.String r1 = r4.toString()     // Catch:{ all -> 0x00db }
            com.oppo.camera.e.a(r2, r1)     // Catch:{ all -> 0x00db }
        L_0x00a4:
            monitor-exit(r0)     // Catch:{ all -> 0x00db }
            return r7
        L_0x00a6:
            java.lang.String r7 = "HeadlineRenderer"
            java.lang.String r1 = "setCurrentIndexWithAnim, mTextItemAngle is illegal"
            com.oppo.camera.e.e(r7, r1)     // Catch:{ all -> 0x00db }
            monitor-exit(r0)     // Catch:{ all -> 0x00db }
            return r2
        L_0x00af:
            java.lang.String r1 = "HeadlineRenderer"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00db }
            r3.<init>()     // Catch:{ all -> 0x00db }
            java.lang.String r4 = "setCurrentIndexWithAnim, mTextArray: "
            r3.append(r4)     // Catch:{ all -> 0x00db }
            java.lang.String[] r4 = r6.p     // Catch:{ all -> 0x00db }
            r3.append(r4)     // Catch:{ all -> 0x00db }
            java.lang.String r4 = ", index: "
            r3.append(r4)     // Catch:{ all -> 0x00db }
            r3.append(r7)     // Catch:{ all -> 0x00db }
            java.lang.String r7 = ", mCurrentIndex: "
            r3.append(r7)     // Catch:{ all -> 0x00db }
            int r7 = r6.w     // Catch:{ all -> 0x00db }
            r3.append(r7)     // Catch:{ all -> 0x00db }
            java.lang.String r7 = r3.toString()     // Catch:{ all -> 0x00db }
            com.oppo.camera.e.e(r1, r7)     // Catch:{ all -> 0x00db }
            monitor-exit(r0)     // Catch:{ all -> 0x00db }
            return r2
        L_0x00db:
            r7 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00db }
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.ui.menu.b.f.b(int):boolean");
    }

    public int a(float f2) {
        synchronized (this.f4088a) {
            if (this.o != null) {
                if (this.o.length > 0) {
                    float abs = Math.abs(f2) / this.l;
                    float degrees = (float) Math.toDegrees(Math.asin((double) (abs / this.k)));
                    float f3 = (this.o[this.w] + this.o[this.w + 1]) / 2.0f;
                    e.a("HeadlineRenderer", "computeIndexOnTap, modelX: " + abs + ", angle: " + degrees);
                    float f4 = f2 >= 0.0f ? f3 + degrees : f3 - degrees;
                    int i2 = 0;
                    while (true) {
                        if (i2 < this.o.length - 1) {
                            if (Float.compare(f4, this.o[i2]) >= 0 && Float.compare(f4, this.o[i2 + 1]) < 0) {
                                break;
                            }
                            i2++;
                        } else {
                            i2 = -1;
                            break;
                        }
                    }
                    if (this.p != null && this.p.length > 0 && i2 >= 0 && i2 < this.p.length) {
                        if (this.w != i2) {
                            this.x = this.w;
                            this.w = i2;
                            c(0);
                            this.t = true;
                            if (this.C != null) {
                                float f5 = (this.o[this.x] + this.o[this.x + 1]) / 2.0f;
                                float f6 = (this.o[this.w] + this.o[this.w + 1]) / 2.0f;
                                if (this.O == null) {
                                    d();
                                }
                                this.O.a((double) f5).b((double) f6);
                            }
                            e.a("HeadlineRenderer", "computeIndexOnTap, mCurrentIndex: " + this.w);
                            int i3 = this.w;
                            return i3;
                        }
                    }
                    e.e("HeadlineRenderer", "computeIndexOnTap, mTextArray: " + this.p + ", targetIndex: " + i2 + ", mCurrentIndex: " + this.w);
                    return -1;
                }
            }
            e.e("HeadlineRenderer", "computeIndexOnTap, mTextItemAngle is illegal");
            return -1;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:50:0x013b, code lost:
        return r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0172, code lost:
        return 0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int b(float r11) {
        /*
            r10 = this;
            java.lang.Object r0 = r10.f4088a
            monitor-enter(r0)
            java.lang.String[] r1 = r10.p     // Catch:{ all -> 0x0173 }
            r2 = 0
            if (r1 == 0) goto L_0x0171
            java.lang.String[] r1 = r10.p     // Catch:{ all -> 0x0173 }
            int r1 = r1.length     // Catch:{ all -> 0x0173 }
            if (r1 > 0) goto L_0x000f
            goto L_0x0171
        L_0x000f:
            float[] r1 = r10.o     // Catch:{ all -> 0x0173 }
            r3 = -1
            if (r1 == 0) goto L_0x0168
            float[] r1 = r10.o     // Catch:{ all -> 0x0173 }
            int r1 = r1.length     // Catch:{ all -> 0x0173 }
            if (r1 > 0) goto L_0x001b
            goto L_0x0168
        L_0x001b:
            float[] r1 = r10.o     // Catch:{ all -> 0x0173 }
            int r1 = r1.length     // Catch:{ all -> 0x0173 }
            r4 = 2
            if (r1 > r4) goto L_0x002a
            java.lang.String r11 = "HeadlineRenderer"
            java.lang.String r1 = "computeIndexOnScroll, one TextItem needn't rotate"
            com.oppo.camera.e.e(r11, r1)     // Catch:{ all -> 0x0173 }
            monitor-exit(r0)     // Catch:{ all -> 0x0173 }
            return r3
        L_0x002a:
            float[] r1 = r10.o     // Catch:{ all -> 0x0173 }
            int r1 = r1.length     // Catch:{ all -> 0x0173 }
            float r5 = r10.l     // Catch:{ all -> 0x0173 }
            float r11 = r11 / r5
            float r5 = r10.k     // Catch:{ all -> 0x0173 }
            float r11 = r11 / r5
            double r5 = (double) r11     // Catch:{ all -> 0x0173 }
            double r5 = java.lang.Math.asin(r5)     // Catch:{ all -> 0x0173 }
            double r5 = java.lang.Math.toDegrees(r5)     // Catch:{ all -> 0x0173 }
            float r11 = (float) r5     // Catch:{ all -> 0x0173 }
            float[] r5 = r10.o     // Catch:{ all -> 0x0173 }
            int r6 = r10.w     // Catch:{ all -> 0x0173 }
            r5 = r5[r6]     // Catch:{ all -> 0x0173 }
            float[] r6 = r10.o     // Catch:{ all -> 0x0173 }
            int r7 = r10.w     // Catch:{ all -> 0x0173 }
            r8 = 1
            int r7 = r7 + r8
            r6 = r6[r7]     // Catch:{ all -> 0x0173 }
            float r5 = r5 + r6
            r6 = 1073741824(0x40000000, float:2.0)
            float r5 = r5 / r6
            float r5 = r5 + r11
            float[] r11 = r10.o     // Catch:{ all -> 0x0173 }
            int r7 = r1 + -1
            r11 = r11[r7]     // Catch:{ all -> 0x0173 }
            float[] r9 = r10.o     // Catch:{ all -> 0x0173 }
            int r1 = r1 - r4
            r4 = r9[r1]     // Catch:{ all -> 0x0173 }
            float r11 = r11 + r4
            float r11 = r11 / r6
            int r11 = (r5 > r11 ? 1 : (r5 == r11 ? 0 : -1))
            if (r11 <= 0) goto L_0x006c
            float[] r11 = r10.o     // Catch:{ all -> 0x0173 }
            r11 = r11[r7]     // Catch:{ all -> 0x0173 }
            float[] r4 = r10.o     // Catch:{ all -> 0x0173 }
            r1 = r4[r1]     // Catch:{ all -> 0x0173 }
            float r11 = r11 + r1
            float r5 = r11 / r6
        L_0x006c:
            float[] r11 = r10.o     // Catch:{ all -> 0x0173 }
            r11 = r11[r2]     // Catch:{ all -> 0x0173 }
            float[] r1 = r10.o     // Catch:{ all -> 0x0173 }
            r1 = r1[r8]     // Catch:{ all -> 0x0173 }
            float r11 = r11 + r1
            float r11 = r11 / r6
            int r11 = (r5 > r11 ? 1 : (r5 == r11 ? 0 : -1))
            if (r11 >= 0) goto L_0x0085
            float[] r11 = r10.o     // Catch:{ all -> 0x0173 }
            r11 = r11[r2]     // Catch:{ all -> 0x0173 }
            float[] r1 = r10.o     // Catch:{ all -> 0x0173 }
            r1 = r1[r8]     // Catch:{ all -> 0x0173 }
            float r11 = r11 + r1
            float r5 = r11 / r6
        L_0x0085:
            float[] r11 = r10.o     // Catch:{ all -> 0x0173 }
            int r11 = r11.length     // Catch:{ all -> 0x0173 }
            int r11 = r11 - r8
            if (r2 >= r11) goto L_0x00a5
            float[] r11 = r10.o     // Catch:{ all -> 0x0173 }
            r11 = r11[r2]     // Catch:{ all -> 0x0173 }
            int r11 = java.lang.Float.compare(r5, r11)     // Catch:{ all -> 0x0173 }
            if (r11 < 0) goto L_0x00a2
            float[] r11 = r10.o     // Catch:{ all -> 0x0173 }
            int r1 = r2 + 1
            r11 = r11[r1]     // Catch:{ all -> 0x0173 }
            int r11 = java.lang.Float.compare(r5, r11)     // Catch:{ all -> 0x0173 }
            if (r11 >= 0) goto L_0x00a2
            goto L_0x00a6
        L_0x00a2:
            int r2 = r2 + 1
            goto L_0x0085
        L_0x00a5:
            r2 = r3
        L_0x00a6:
            java.lang.String[] r11 = r10.p     // Catch:{ all -> 0x0173 }
            if (r11 == 0) goto L_0x013c
            java.lang.String[] r11 = r10.p     // Catch:{ all -> 0x0173 }
            int r11 = r11.length     // Catch:{ all -> 0x0173 }
            if (r11 <= 0) goto L_0x013c
            if (r2 < 0) goto L_0x013c
            java.lang.String[] r11 = r10.p     // Catch:{ all -> 0x0173 }
            int r11 = r11.length     // Catch:{ all -> 0x0173 }
            if (r2 < r11) goto L_0x00b8
            goto L_0x013c
        L_0x00b8:
            java.lang.String r11 = "HeadlineRenderer"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0173 }
            r1.<init>()     // Catch:{ all -> 0x0173 }
            java.lang.String r3 = "computeIndexOnScroll, targetIndex: "
            r1.append(r3)     // Catch:{ all -> 0x0173 }
            r1.append(r2)     // Catch:{ all -> 0x0173 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0173 }
            com.oppo.camera.e.a(r11, r1)     // Catch:{ all -> 0x0173 }
            r10.c((int) r8)     // Catch:{ all -> 0x0173 }
            int r11 = r10.z     // Catch:{ all -> 0x0173 }
            if (r11 == r2) goto L_0x013a
            java.lang.String r11 = "HeadlineRenderer"
            java.lang.String r1 = "computeIndexOnScroll, mScrollCurrentIndex need to change"
            com.oppo.camera.e.a(r11, r1)     // Catch:{ all -> 0x0173 }
            r10.t = r8     // Catch:{ all -> 0x0173 }
            int r11 = r10.z     // Catch:{ all -> 0x0173 }
            r10.y = r11     // Catch:{ all -> 0x0173 }
            r10.z = r2     // Catch:{ all -> 0x0173 }
            java.lang.String r11 = "HeadlineRenderer"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0173 }
            r1.<init>()     // Catch:{ all -> 0x0173 }
            java.lang.String r3 = "computeIndexOnScroll, mScrollLastIndex: "
            r1.append(r3)     // Catch:{ all -> 0x0173 }
            int r3 = r10.y     // Catch:{ all -> 0x0173 }
            r1.append(r3)     // Catch:{ all -> 0x0173 }
            java.lang.String r3 = ", mScrollCurrentIndex: "
            r1.append(r3)     // Catch:{ all -> 0x0173 }
            int r3 = r10.z     // Catch:{ all -> 0x0173 }
            r1.append(r3)     // Catch:{ all -> 0x0173 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0173 }
            com.oppo.camera.e.a(r11, r1)     // Catch:{ all -> 0x0173 }
            com.oppo.camera.ui.menu.b.f$a r11 = r10.C     // Catch:{ all -> 0x0173 }
            if (r11 == 0) goto L_0x013a
            float[] r11 = r10.o     // Catch:{ all -> 0x0173 }
            int r1 = r10.y     // Catch:{ all -> 0x0173 }
            r11 = r11[r1]     // Catch:{ all -> 0x0173 }
            float[] r1 = r10.o     // Catch:{ all -> 0x0173 }
            int r3 = r10.y     // Catch:{ all -> 0x0173 }
            int r3 = r3 + r8
            r1 = r1[r3]     // Catch:{ all -> 0x0173 }
            float r11 = r11 + r1
            float r11 = r11 / r6
            float[] r1 = r10.o     // Catch:{ all -> 0x0173 }
            int r3 = r10.z     // Catch:{ all -> 0x0173 }
            r1 = r1[r3]     // Catch:{ all -> 0x0173 }
            float[] r3 = r10.o     // Catch:{ all -> 0x0173 }
            int r4 = r10.z     // Catch:{ all -> 0x0173 }
            int r4 = r4 + r8
            r3 = r3[r4]     // Catch:{ all -> 0x0173 }
            float r1 = r1 + r3
            float r1 = r1 / r6
            com.a.a.f r3 = r10.O     // Catch:{ all -> 0x0173 }
            if (r3 != 0) goto L_0x012f
            r10.d()     // Catch:{ all -> 0x0173 }
        L_0x012f:
            com.a.a.f r3 = r10.O     // Catch:{ all -> 0x0173 }
            double r4 = (double) r11     // Catch:{ all -> 0x0173 }
            com.a.a.f r11 = r3.a((double) r4)     // Catch:{ all -> 0x0173 }
            double r3 = (double) r1     // Catch:{ all -> 0x0173 }
            r11.b(r3)     // Catch:{ all -> 0x0173 }
        L_0x013a:
            monitor-exit(r0)     // Catch:{ all -> 0x0173 }
            return r2
        L_0x013c:
            java.lang.String r11 = "HeadlineRenderer"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0173 }
            r1.<init>()     // Catch:{ all -> 0x0173 }
            java.lang.String r4 = "computeIndexOnScroll, mTextArray: "
            r1.append(r4)     // Catch:{ all -> 0x0173 }
            java.lang.String[] r4 = r10.p     // Catch:{ all -> 0x0173 }
            r1.append(r4)     // Catch:{ all -> 0x0173 }
            java.lang.String r4 = ", targetIndex: "
            r1.append(r4)     // Catch:{ all -> 0x0173 }
            r1.append(r2)     // Catch:{ all -> 0x0173 }
            java.lang.String r2 = ", mCurrentIndex: "
            r1.append(r2)     // Catch:{ all -> 0x0173 }
            int r2 = r10.w     // Catch:{ all -> 0x0173 }
            r1.append(r2)     // Catch:{ all -> 0x0173 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0173 }
            com.oppo.camera.e.e(r11, r1)     // Catch:{ all -> 0x0173 }
            monitor-exit(r0)     // Catch:{ all -> 0x0173 }
            return r3
        L_0x0168:
            java.lang.String r11 = "HeadlineRenderer"
            java.lang.String r1 = "computeIndexOnScroll, mTextItemAngle is illegal"
            com.oppo.camera.e.e(r11, r1)     // Catch:{ all -> 0x0173 }
            monitor-exit(r0)     // Catch:{ all -> 0x0173 }
            return r3
        L_0x0171:
            monitor-exit(r0)     // Catch:{ all -> 0x0173 }
            return r2
        L_0x0173:
            r11 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0173 }
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.ui.menu.b.f.b(float):int");
    }

    public void b() {
        com.a.a.f fVar = this.O;
        if (fVar != null) {
            fVar.a();
            this.O = null;
        }
        if (L != null) {
            L = null;
        }
        if (M != null) {
            M = null;
        }
    }

    public void c(int i2) {
        e.a("HeadlineRenderer", "setRotateMode, rotateMode: " + i2);
        this.A = i2;
    }

    public void c() {
        this.y = this.w;
        this.z = this.w;
        e.a("HeadlineRenderer", "initScrollIndex, mScrollLastIndex: " + this.y + ", mScrollCurrentIndex" + this.z);
    }

    public void c(float f2) {
        e.a("HeadlineRenderer", "setAlpha, alpha: " + f2);
        synchronized (this.f4088a) {
            this.B = f2;
            if (this.C != null) {
                this.C.a(-1, true);
            }
        }
    }

    private void e() {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        this.s = iArr[0];
        GLES20.glBindTexture(3553, this.s);
        GLES20.glTexParameterf(3553, 10241, 9729.0f);
        GLES20.glTexParameterf(3553, 10240, 9729.0f);
        GLES20.glTexParameterf(3553, 10242, 10497.0f);
        GLES20.glTexParameterf(3553, 10243, 10497.0f);
        e.a("HeadlineRenderer", "initTexture, mTextureId: " + this.s);
    }

    private void a(int i2, int i3, String[] strArr) {
        TextPaint textPaint;
        Paint paint;
        int i4 = i2;
        int i5 = i3;
        String[] strArr2 = strArr;
        String str = "HeadlineRenderer";
        e.a(str, "updateTexture, width: " + i4 + ", height: " + i5 + ", textArray: " + strArr2);
        this.o = new float[(strArr2.length + 1)];
        Bitmap a2 = Util.a(i4, i5, Bitmap.Config.ARGB_8888);
        TextPaint textPaint2 = new TextPaint();
        TextPaint textPaint3 = new TextPaint();
        Canvas canvas = new Canvas(a2);
        canvas.drawColor(0);
        textPaint2.setAntiAlias(true);
        textPaint2.setTextSize((float) this.D);
        textPaint2.setTypeface(Util.j(this.n));
        textPaint2.setColor(this.P ? this.Q : -1);
        textPaint2.setTextAlign(Paint.Align.CENTER);
        textPaint3.setAntiAlias(true);
        textPaint3.setTextSize((float) this.D);
        textPaint3.setTypeface(f());
        textPaint3.setColor(Util.s(this.n));
        textPaint3.setTextAlign(Paint.Align.CENTER);
        Paint.FontMetrics fontMetrics = textPaint2.getFontMetrics();
        Paint.FontMetrics fontMetrics2 = textPaint3.getFontMetrics();
        float height = ((((float) a2.getHeight()) / 2.0f) - (fontMetrics.bottom / 2.0f)) - (fontMetrics.top / 2.0f);
        float height2 = ((((float) a2.getHeight()) / 2.0f) - (fontMetrics2.bottom / 2.0f)) - (fontMetrics2.top / 2.0f);
        float dimensionPixelSize = height - ((float) this.n.getResources().getDimensionPixelSize(R.dimen.baseline_vertical_offset));
        float dimensionPixelSize2 = height2 - ((float) this.n.getResources().getDimensionPixelSize(R.dimen.baseline_vertical_offset));
        this.o[0] = 0.0f;
        float a3 = (float) Util.a(3.0f);
        float f2 = 0.0f;
        int i6 = 0;
        Paint paint2 = null;
        while (i6 < strArr2.length) {
            float measureText = textPaint2.measureText(strArr2[i6]);
            float f3 = f2 + measureText + ((float) this.F);
            String str2 = str;
            float f4 = (f2 + f3) / 2.0f;
            Bitmap bitmap = a2;
            float f5 = f3;
            if (this.A == 1) {
                if (i6 != this.z) {
                    canvas.drawText(strArr2[i6], f4, dimensionPixelSize, textPaint2);
                } else {
                    canvas.drawText(strArr2[i6], f4, dimensionPixelSize2, textPaint3);
                }
            } else if (i6 != this.w) {
                canvas.drawText(strArr2[i6], f4, dimensionPixelSize, textPaint2);
            } else {
                canvas.drawText(strArr2[i6], f4, dimensionPixelSize2, textPaint3);
            }
            if (a(strArr2[i6])) {
                if (paint2 == null) {
                    paint = new Paint();
                    paint.setAntiAlias(true);
                    textPaint = textPaint2;
                    paint.setColor(this.n.getResources().getColor(R.color.camera_red_dot_hint_color, (Resources.Theme) null));
                } else {
                    textPaint = textPaint2;
                    paint = paint2;
                }
                canvas.drawCircle(f4 + (measureText / 2.0f) + a3, (i6 != this.w ? fontMetrics.top : fontMetrics2.top) + height, a3, paint);
                paint2 = paint;
            } else {
                textPaint = textPaint2;
            }
            i6++;
            this.o[i6] = (float) Math.toDegrees((double) ((f5 / this.l) / this.k));
            strArr2 = strArr;
            a2 = bitmap;
            f2 = f5;
            str = str2;
            textPaint2 = textPaint;
        }
        Bitmap bitmap2 = a2;
        String str3 = str;
        GLES20.glBindTexture(3553, this.s);
        GLES20.glTexParameterf(3553, 10241, 9729.0f);
        GLES20.glTexParameterf(3553, 10240, 9729.0f);
        GLES20.glTexParameterf(3553, 10242, 10497.0f);
        GLES20.glTexParameterf(3553, 10243, 10497.0f);
        GLUtils.texImage2D(3553, 0, GLUtils.getInternalFormat(bitmap2), bitmap2, GLUtils.getType(bitmap2), 0);
        bitmap2.recycle();
        for (int i7 = 0; i7 < this.o.length; i7++) {
            e.a(str3, "updateTexture, index: " + i7 + ", angle: " + this.o[i7]);
        }
    }

    public void a(int... iArr) {
        boolean z2;
        if (iArr == null || iArr.length <= 0) {
            z2 = false;
        } else {
            z2 = false;
            for (int string : iArr) {
                String string2 = this.n.getString(string);
                if (!a(string2)) {
                    this.f4089b.add(string2);
                    z2 = true;
                }
            }
        }
        if (z2) {
            this.C.a(0, true);
        }
    }

    public void b(int... iArr) {
        boolean z2;
        if (iArr != null && iArr.length > 0) {
            z2 = false;
            for (int string : iArr) {
                String string2 = this.n.getString(string);
                if (a(string2)) {
                    this.f4089b.remove(string2);
                    this.t = true;
                    z2 = true;
                }
            }
        } else if (!this.f4089b.isEmpty()) {
            this.f4089b.clear();
            this.t = true;
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            this.C.a(0, true);
        }
    }

    private boolean a(String str) {
        return !this.f4089b.isEmpty() && this.f4089b.contains(str);
    }

    private Typeface f() {
        Typeface typeface = L;
        if (typeface != null) {
            return typeface;
        }
        L = Util.a(this.n, true);
        return L;
    }

    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        e.a("HeadlineRenderer", "onSurfaceCreated");
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        GLES20.glEnable(2929);
        GLES20.glEnable(2884);
        GLES20.glFrontFace(2304);
        synchronized (this.f4088a) {
            this.G.a();
            e();
            this.m = new b(this.n, this.k, this.f);
            this.m.a();
        }
        e.a("HeadlineRenderer", "onSurfaceCreated X");
    }

    public void onSurfaceChanged(GL10 gl10, int i2, int i3) {
        e.a("HeadlineRenderer", "onSurfaceChanged");
        GLES20.glViewport(0, 0, i2, i3);
        synchronized (this.f4088a) {
            this.G.a(this.g, this.h, this.j, this.i, 4.0f, 100.0f);
            this.G.a(0.0f, 0.0f, 8.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f);
        }
        e.a("HeadlineRenderer", "onSurfaceChanged X");
    }

    public void onDrawFrame(GL10 gl10) {
        synchronized (this.f4088a) {
            if (this.p != null) {
                if (this.p.length > 0) {
                    GLES20.glClear(16640);
                    this.G.b();
                    this.G.a(0.0f, -1.0f, 0.0f);
                    if (this.t) {
                        a(this.q, this.r, this.p);
                        this.t = false;
                    }
                    d(this.A);
                    g();
                    this.m.a(this.s, this.G.d());
                    this.G.c();
                    return;
                }
            }
            e.e("HeadlineRenderer", "onDrawFrame, mTextArray is null or the length is 0");
        }
    }

    private void d(int i2) {
        if (i2 == 0) {
            int i3 = this.x;
            if (i3 < 0 || i3 > this.o.length - 2 || this.w < 0 || this.w > this.o.length - 2) {
                e.e("HeadlineRenderer", "setHeadlineAngle, ROTATE_MODE_SLIDE, the parameter is illegal");
                return;
            }
            if (this.x != this.w) {
                float f2 = this.u;
                float[] fArr = this.o;
                int i4 = this.x;
                float abs = Math.abs(f2 - ((fArr[i4] + fArr[i4 + 1]) / 2.0f));
                float[] fArr2 = this.o;
                int i5 = this.x;
                this.K = abs / Math.abs(((this.o[this.w] + this.o[this.w + 1]) / 2.0f) - ((fArr2[i5] + fArr2[i5 + 1]) / 2.0f));
                if (this.K > 1.0f) {
                    this.K = 1.0f;
                }
            } else {
                this.K = 1.0f;
            }
            this.G.a(this.u - 126.0f, 0.0f, 1.0f, 0.0f);
            e.a("HeadlineRenderer", "setHeadlineAngle, ROTATE_MODE_SLIDE, angle:" + this.u);
        } else if (i2 == 1) {
            int i6 = this.y;
            if (i6 < 0 || i6 > this.o.length - 2 || this.z < 0 || this.z > this.o.length - 2) {
                e.e("HeadlineRenderer", "setHeadlineAngle, ROTATE_MODE_FOLLOW_FINGER , the parameter is illegal");
                return;
            }
            if (this.y != this.z) {
                float f3 = this.u;
                float[] fArr3 = this.o;
                int i7 = this.y;
                float abs2 = Math.abs(f3 - ((fArr3[i7] + fArr3[i7 + 1]) / 2.0f));
                float[] fArr4 = this.o;
                int i8 = this.y;
                this.K = abs2 / Math.abs(((this.o[this.z] + this.o[this.z + 1]) / 2.0f) - ((fArr4[i8] + fArr4[i8 + 1]) / 2.0f));
                if (this.K > 1.0f) {
                    this.K = 1.0f;
                }
            } else {
                this.K = 1.0f;
            }
            this.G.a(this.u - 126.0f, 0.0f, 1.0f, 0.0f);
            e.a("HeadlineRenderer", "setHeadlineAngle, ROTATE_MODE_FOLLOW_FINGER, angle:" + this.u);
        } else if (i2 == 2) {
            if (this.w >= 0) {
                int i9 = this.w;
                float[] fArr5 = this.o;
                if (i9 <= fArr5.length - 2) {
                    this.u = (fArr5[this.w] + this.o[this.w + 1]) / 2.0f;
                    this.K = 1.0f;
                    this.G.a(this.u - 126.0f, 0.0f, 1.0f, 0.0f);
                    e.a("HeadlineRenderer", "setHeadlineAngle, ROTATE_MODE_NO_ANIMATION, angle:" + this.u);
                    return;
                }
            }
            e.e("HeadlineRenderer", "setHeadlineAngle, ROTATE_MODE_NO_ANIMATION , the parameter is illegal");
        }
    }

    private void g() {
        b bVar = this.m;
        if (bVar != null) {
            float[] fArr = this.o;
            int i2 = this.x;
            bVar.a(fArr[i2] / 126.0f, fArr[i2 + 1] / 126.0f);
            this.m.b(this.o[this.w] / 126.0f, this.o[this.w + 1] / 126.0f);
            this.m.b(1.0f);
            this.m.c(1.0f);
            e.a("HeadlineRenderer", "setHeadlineDrawer, mAnimationRatio: " + this.K);
            float d2 = d(this.N.getInterpolation(this.K));
            float f2 = ((((float) this.H) / 2.0f) / this.l) / (this.f / 2.0f);
            a aVar = this.C;
            if (aVar != null) {
                aVar.a((int) (((float) this.d) * d2), (int) (((float) this.c) * f2), this.B);
            }
            this.m.a(this.B);
        }
    }

    private float d(float f2) {
        float f3;
        float f4;
        if (this.A == 1) {
            f4 = e(this.y);
            f3 = e(this.z);
        } else {
            f4 = e(this.x);
            f3 = e(this.w);
        }
        e.a("HeadlineRenderer", "getCurrentBackgroundLocation, startLocation: " + f4 + ", endLocation: " + f3);
        return f4 + ((f3 - f4) * f2);
    }

    private float e(int i2) {
        float[] fArr = this.o;
        double radians = Math.toRadians((double) (fArr[i2 + 1] - fArr[i2]));
        float f2 = this.k;
        float f3 = this.l;
        return (float) ((((double) f2) * Math.sin(((((((((double) f2) * radians) / 2.0d) - ((double) (((float) (this.F / 2)) / f3))) + ((double) (((float) this.J) / f3))) * 2.0d) / ((double) f2)) / 2.0d)) / ((double) (this.e / 2.0f)));
    }

    /* compiled from: HeadlineRenderer */
    private class b extends com.a.a.e {
        private b() {
        }

        public void a(com.a.a.f fVar) {
            synchronized (f.this.f4088a) {
                float unused = f.this.u = (float) fVar.c();
                if (f.this.C != null) {
                    f.this.C.a(0, true);
                }
            }
        }

        public void b(com.a.a.f fVar) {
            e.a("HeadlineRenderer", "onSpringAtRest, mSlideAnim completed");
        }
    }
}
