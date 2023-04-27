package com.airbnb.lottie.c.c;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import com.airbnb.lottie.a.a;
import com.airbnb.lottie.a.b.p;
import com.airbnb.lottie.f;
import com.airbnb.lottie.f.h;
import com.airbnb.lottie.k;

/* compiled from: ImageLayer */
public class c extends a {
    private final Paint e = new a(3);
    private final Rect f = new Rect();
    private final Rect g = new Rect();
    private com.airbnb.lottie.a.b.a<ColorFilter, ColorFilter> h;

    c(f fVar, d dVar) {
        super(fVar, dVar);
    }

    public void b(Canvas canvas, Matrix matrix, int i) {
        Bitmap f2 = f();
        if (f2 != null && !f2.isRecycled()) {
            float a2 = h.a();
            this.e.setAlpha(i);
            com.airbnb.lottie.a.b.a<ColorFilter, ColorFilter> aVar = this.h;
            if (aVar != null) {
                this.e.setColorFilter(aVar.g());
            }
            canvas.save();
            canvas.concat(matrix);
            this.f.set(0, 0, f2.getWidth(), f2.getHeight());
            this.g.set(0, 0, (int) (((float) f2.getWidth()) * a2), (int) (((float) f2.getHeight()) * a2));
            canvas.drawBitmap(f2, this.f, this.g, this.e);
            canvas.restore();
        }
    }

    public void a(RectF rectF, Matrix matrix, boolean z) {
        super.a(rectF, matrix, z);
        Bitmap f2 = f();
        if (f2 != null) {
            rectF.set(0.0f, 0.0f, ((float) f2.getWidth()) * h.a(), ((float) f2.getHeight()) * h.a());
            this.f1703a.mapRect(rectF);
        }
    }

    private Bitmap f() {
        return this.f1704b.e(this.c.g());
    }

    public <T> void a(T t, com.airbnb.lottie.g.c<T> cVar) {
        super.a(t, cVar);
        if (t != k.C) {
            return;
        }
        if (cVar == null) {
            this.h = null;
        } else {
            this.h = new p(cVar);
        }
    }
}
