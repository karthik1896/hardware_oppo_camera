package com.airbnb.lottie.c.c;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.airbnb.lottie.a.a;
import com.airbnb.lottie.a.b.p;
import com.airbnb.lottie.f;
import com.airbnb.lottie.g.c;
import com.airbnb.lottie.k;

/* compiled from: SolidLayer */
public class g extends a {
    private final RectF e = new RectF();
    private final Paint f = new a();
    private final float[] g = new float[8];
    private final Path h = new Path();
    private final d i;
    private com.airbnb.lottie.a.b.a<ColorFilter, ColorFilter> j;

    g(f fVar, d dVar) {
        super(fVar, dVar);
        this.i = dVar;
        this.f.setAlpha(0);
        this.f.setStyle(Paint.Style.FILL);
        this.f.setColor(dVar.p());
    }

    public void b(Canvas canvas, Matrix matrix, int i2) {
        int alpha = Color.alpha(this.i.p());
        if (alpha != 0) {
            int intValue = (int) ((((float) i2) / 255.0f) * (((((float) alpha) / 255.0f) * ((float) (this.d.a() == null ? 100 : this.d.a().g().intValue()))) / 100.0f) * 255.0f);
            this.f.setAlpha(intValue);
            com.airbnb.lottie.a.b.a<ColorFilter, ColorFilter> aVar = this.j;
            if (aVar != null) {
                this.f.setColorFilter(aVar.g());
            }
            if (intValue > 0) {
                float[] fArr = this.g;
                fArr[0] = 0.0f;
                fArr[1] = 0.0f;
                fArr[2] = (float) this.i.r();
                float[] fArr2 = this.g;
                fArr2[3] = 0.0f;
                fArr2[4] = (float) this.i.r();
                this.g[5] = (float) this.i.q();
                float[] fArr3 = this.g;
                fArr3[6] = 0.0f;
                fArr3[7] = (float) this.i.q();
                matrix.mapPoints(this.g);
                this.h.reset();
                Path path = this.h;
                float[] fArr4 = this.g;
                path.moveTo(fArr4[0], fArr4[1]);
                Path path2 = this.h;
                float[] fArr5 = this.g;
                path2.lineTo(fArr5[2], fArr5[3]);
                Path path3 = this.h;
                float[] fArr6 = this.g;
                path3.lineTo(fArr6[4], fArr6[5]);
                Path path4 = this.h;
                float[] fArr7 = this.g;
                path4.lineTo(fArr7[6], fArr7[7]);
                Path path5 = this.h;
                float[] fArr8 = this.g;
                path5.lineTo(fArr8[0], fArr8[1]);
                this.h.close();
                canvas.drawPath(this.h, this.f);
            }
        }
    }

    public void a(RectF rectF, Matrix matrix, boolean z) {
        super.a(rectF, matrix, z);
        this.e.set(0.0f, 0.0f, (float) this.i.r(), (float) this.i.q());
        this.f1703a.mapRect(this.e);
        rectF.set(this.e);
    }

    public <T> void a(T t, c<T> cVar) {
        super.a(t, cVar);
        if (t != k.C) {
            return;
        }
        if (cVar == null) {
            this.j = null;
        } else {
            this.j = new p(cVar);
        }
    }
}
