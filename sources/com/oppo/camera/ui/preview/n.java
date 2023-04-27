package com.oppo.camera.ui.preview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.RectF;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import com.oppo.camera.R;
import java.util.ArrayList;
import java.util.List;

/* compiled from: GuideLineView */
public class n extends View {

    /* renamed from: a  reason: collision with root package name */
    private Paint f4533a = null;

    /* renamed from: b  reason: collision with root package name */
    private Paint f4534b = null;
    private boolean c = false;
    private String d = "grid";
    private List<b> e = null;
    private PointF f = new PointF();
    private c g = new c();
    private a h = null;
    private a i = null;
    /* access modifiers changed from: private */
    public int j = 0;
    private Canvas k = null;
    private Bitmap l = null;
    private float m = 0.0f;

    public n(Context context) {
        super(context);
        a(context);
    }

    private void a(Context context) {
        this.m = context.getResources().getDimension(R.dimen.guideline_stroke_width);
        this.f4533a = new Paint();
        this.f4533a.setStyle(Paint.Style.STROKE);
        this.f4533a.setColor(Color.parseColor("#ffffff"));
        this.f4533a.setStrokeWidth(this.m);
        this.f4533a.setAntiAlias(true);
        this.f4534b = new Paint();
        this.h = new a();
        this.h.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationEnd(Animation animation) {
            }

            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
                n.this.setVisibility(0);
            }
        });
        this.i = new a();
        this.i.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
            }

            public void onAnimationEnd(Animation animation) {
                n.this.setVisibility(8);
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        int width = getWidth();
        int height = getHeight();
        if (this.c) {
            a(width, height);
            int a2 = a();
            String str = this.d;
            char c2 = 65535;
            int hashCode = str.hashCode();
            if (hashCode != -895939855) {
                if (hashCode != 3181382) {
                    if (hashCode == 1497762312 && str.equals("triangle")) {
                        c2 = 1;
                    }
                } else if (str.equals("grid")) {
                    c2 = 0;
                }
            } else if (str.equals("spiral")) {
                c2 = 2;
            }
            if (c2 == 0) {
                c(0, 0, width, height);
            } else if (c2 == 1) {
                b(0, 0, width, height);
            } else if (c2 == 2) {
                float f2 = (float) 0;
                float f3 = this.m;
                a((int) (f2 + f3), (int) (f2 + f3), (int) (((float) width) - (f3 * 2.0f)), (int) (((float) height) - (f3 / 2.0f)));
            }
            this.f4533a.setShadowLayer(3.0f, 0.0f, 0.0f, Color.parseColor("#80000000"));
            for (int i2 = 0; i2 < a2; i2++) {
                b bVar = this.e.get(i2);
                if (bVar.f4540b == 0) {
                    this.k.drawLine(bVar.c.x, bVar.c.y, bVar.d.x, bVar.d.y, this.f4533a);
                } else if (1 == bVar.f4540b) {
                    this.k.drawArc(bVar.g, (float) bVar.e, (float) bVar.f, bVar.h, this.f4533a);
                }
            }
            this.f4534b.setAlpha(this.j);
            canvas.drawBitmap(this.l, 0.0f, 0.0f, this.f4534b);
        }
    }

    private void a(int i2, int i3) {
        Canvas canvas = this.k;
        if (canvas == null) {
            this.k = new Canvas();
        } else if (!(i2 == canvas.getWidth() && i3 == this.k.getHeight())) {
            this.k = new Canvas();
        }
        Bitmap bitmap = this.l;
        if (bitmap == null) {
            this.l = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
        } else if (!(i2 == bitmap.getWidth() && i3 == this.l.getHeight())) {
            this.l.recycle();
            this.l = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
        }
        this.k.setBitmap(this.l);
        this.k.drawColor(0, PorterDuff.Mode.CLEAR);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Bitmap bitmap = this.l;
        if (bitmap != null) {
            bitmap.recycle();
            this.l = null;
        }
    }

    private void a(int i2, int i3, int i4, int i5) {
        float f2 = (float) i4;
        float f3 = (float) i5;
        if ((1.0f * f2) / f3 >= this.g.g) {
            float unused = this.g.i = f3;
            c cVar = this.g;
            float unused2 = cVar.h = cVar.i * this.g.g;
            c cVar2 = this.g;
            float unused3 = cVar2.j = (f2 - cVar2.h) * 0.5f;
            float unused4 = this.g.k = 0.0f;
        } else {
            float unused5 = this.g.h = f2;
            c cVar3 = this.g;
            float unused6 = cVar3.i = cVar3.h / this.g.g;
            float unused7 = this.g.j = 0.0f;
            c cVar4 = this.g;
            float unused8 = cVar4.k = (f3 - cVar4.i) * 0.5f;
        }
        int i6 = 0;
        this.e.get(0).a(((float) i2) + this.g.j, ((float) (i3 + i5)) - this.g.k, this.g.a(0), this.g.b(0), 0, 90);
        int i7 = 1;
        while (i7 < 9) {
            int i8 = i6 + 1;
            b bVar = this.e.get(i6);
            this.e.get(i8).a(bVar.c.x, bVar.c.y, this.g.a(i8), this.g.b(i8), bVar.e - 90, 90);
            i7++;
            i6 = i8;
        }
        b bVar2 = this.e.get(4);
        this.e.get(i6 + 1).a(bVar2.d.x, bVar2.d.y, bVar2.c.x, bVar2.d.y);
    }

    private void b(int i2, int i3, int i4, int i5) {
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        int i9 = i5;
        float f2 = (float) (i6 + i8);
        float f3 = (float) i7;
        float f4 = (float) i6;
        float f5 = (float) (i7 + i9);
        this.e.get(0).a(f2, f3, f4, f5);
        float f6 = (float) i8;
        float f7 = (float) i9;
        this.f.set((f6 * 0.33333334f) + f4, (f7 * 0.6666667f) + f3);
        this.e.get(1).a(f4, (float) ((Math.pow((double) (f4 - this.f.x), 2.0d) / ((double) (this.f.y - f5))) + ((double) this.f.y)), this.f.x, this.f.y);
        this.f.set(f4 + (f6 * 0.6666667f), (f7 * 0.33333334f) + f3);
        this.e.get(2).a(f2, (float) ((Math.pow((double) (f2 - this.f.x), 2.0d) / ((double) (this.f.y - f3))) + ((double) this.f.y)), this.f.x, this.f.y);
    }

    private void c(int i2, int i3, int i4, int i5) {
        float f2 = (float) i2;
        float f3 = (float) i3;
        float f4 = (float) i5;
        float f5 = (f4 * 0.33333334f) + f3;
        float f6 = (float) (i2 + i4);
        this.e.get(0).a(f2, f5, f6, f5);
        float f7 = (f4 * 0.6666667f) + f3;
        this.e.get(1).a(f2, f7, f6, f7);
        float f8 = (float) i4;
        float f9 = (0.33333334f * f8) + f2;
        float f10 = (float) (i3 + i5);
        this.e.get(2).a(f9, f3, f9, f10);
        float f11 = f2 + (f8 * 0.6666667f);
        this.e.get(3).a(f11, f3, f11, f10);
    }

    public void a(String str) {
        if (str == null || "off".equals(str)) {
            a(false);
            return;
        }
        this.d = str;
        if (!this.c) {
            this.c = true;
            setVisibility(0);
            if (this.h != null) {
                clearAnimation();
                setAnimation(this.h);
                this.h.a(0.0f, 127.5f);
            }
        }
    }

    private int a() {
        if (this.e == null) {
            this.e = new ArrayList();
        }
        String str = this.d;
        char c2 = 65535;
        int hashCode = str.hashCode();
        int i2 = 0;
        if (hashCode != -895939855) {
            if (hashCode != 3181382) {
                if (hashCode == 1497762312 && str.equals("triangle")) {
                    c2 = 1;
                }
            } else if (str.equals("grid")) {
                c2 = 0;
            }
        } else if (str.equals("spiral")) {
            c2 = 2;
        }
        if (c2 == 0) {
            i2 = 4;
        } else if (c2 == 1) {
            i2 = 3;
        } else if (c2 == 2) {
            i2 = 10;
        }
        while (this.e.size() < i2) {
            this.e.add(new b(new PointF(0.0f, 0.0f), new PointF(0.0f, 0.0f)));
        }
        return i2;
    }

    public void a(boolean z) {
        if (this.c) {
            this.c = false;
            clearAnimation();
            if (z) {
                setAnimation(this.i);
                this.i.a(127.5f, 0.0f);
                return;
            }
            setVisibility(8);
        }
    }

    /* compiled from: GuideLineView */
    private class a extends Animation {

        /* renamed from: b  reason: collision with root package name */
        private float f4538b = 0.0f;
        private float c = 0.0f;

        public a() {
            setDuration(310);
        }

        /* access modifiers changed from: protected */
        public void applyTransformation(float f, Transformation transformation) {
            float f2 = this.c;
            float f3 = this.f4538b;
            int unused = n.this.j = (int) (((f2 - f3) * f) + f3);
            n.this.invalidate();
        }

        public void a(float f, float f2) {
            this.f4538b = f;
            this.c = f2;
            start();
        }
    }

    /* compiled from: GuideLineView */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        private static final int[] f4541a = {0, 1, 3, 5, 7};

        /* renamed from: b  reason: collision with root package name */
        private static final int[] f4542b = {1, 2, 4, 6, 8};
        private static final int[] c = {4, 5, 6, 7};
        private float[] d = new float[9];
        private float e = 0.0f;
        private float f = 0.0f;
        /* access modifiers changed from: private */
        public float g = 0.0f;
        /* access modifiers changed from: private */
        public float h = 0.0f;
        /* access modifiers changed from: private */
        public float i = 0.0f;
        /* access modifiers changed from: private */
        public float j = 0.0f;
        /* access modifiers changed from: private */
        public float k = 0.0f;

        public c() {
            a();
        }

        private void a() {
            float[] fArr = this.d;
            fArr[0] = 1.0f;
            fArr[1] = 1.0f;
            int i2 = 2;
            while (true) {
                float[] fArr2 = this.d;
                if (i2 >= fArr2.length) {
                    break;
                }
                fArr2[i2] = fArr2[i2 - 1] + fArr2[i2 - 2];
                i2++;
            }
            int[] iArr = f4541a;
            int length = iArr.length;
            for (int i3 = 0; i3 < length; i3++) {
                this.e += this.d[iArr[i3]];
            }
            int[] iArr2 = f4542b;
            int length2 = iArr2.length;
            for (int i4 = 0; i4 < length2; i4++) {
                this.f += this.d[iArr2[i4]];
            }
            this.g = this.e / this.f;
        }

        public float a(int i2) {
            float[] fArr = this.d;
            return (fArr[(fArr.length - 1) - i2] * this.h) / this.e;
        }

        public boolean b(int i2) {
            for (int i3 : c) {
                if (i3 == (this.d.length - 1) - i2) {
                    return true;
                }
            }
            return false;
        }
    }

    /* compiled from: GuideLineView */
    public class b {
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public int f4540b = 0;
        /* access modifiers changed from: private */
        public PointF c = null;
        /* access modifiers changed from: private */
        public PointF d = null;
        /* access modifiers changed from: private */
        public int e = 0;
        /* access modifiers changed from: private */
        public int f = 0;
        /* access modifiers changed from: private */
        public RectF g = null;
        /* access modifiers changed from: private */
        public boolean h = false;

        public b(PointF pointF, PointF pointF2) {
            this.c = pointF;
            this.d = pointF2;
        }

        public void a(float f2, float f3, float f4, float f5) {
            this.c.set(f2, f3);
            this.d.set(f4, f5);
            this.f4540b = 0;
        }

        public void a(float f2, float f3, float f4, boolean z, int i, int i2) {
            this.d.set(f2, f3);
            this.e = i;
            this.f = i2;
            this.h = z;
            this.f4540b = 1;
            if (this.g == null) {
                this.g = new RectF();
            }
            int i3 = i % 360;
            if (i3 < 0) {
                i3 += 360;
            }
            if (i3 == 0) {
                float f5 = f2 + f4;
                this.c.set(f5, f3 - f4);
                this.g.set(f2 - f4, f3 - (f4 * 2.0f), f5, f3);
            } else if (i3 == 90) {
                float f6 = f3 + f4;
                this.c.set(f2 + f4, f6);
                this.g.set(f2, f3 - f4, (f4 * 2.0f) + f2, f6);
            } else if (i3 == 180) {
                float f7 = f2 - f4;
                this.c.set(f7, f3 + f4);
                this.g.set(f7, f3, f2 + f4, (f4 * 2.0f) + f3);
            } else if (i3 == 270) {
                float f8 = f3 - f4;
                this.c.set(f2 - f4, f8);
                this.g.set(f2 - (2.0f * f4), f8, f2, f3 + f4);
            }
        }
    }
}
