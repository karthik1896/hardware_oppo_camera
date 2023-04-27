package com.coloros.anim.c.c;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import com.coloros.anim.a.a;
import com.coloros.anim.a.b.p;
import com.coloros.anim.b;
import com.coloros.anim.d;
import com.coloros.anim.f.g;
import com.coloros.anim.k;

/* compiled from: ImageLayer */
public class c extends a {
    private final Paint e = new a(3);
    private final Rect f = new Rect();
    private final Rect g = new Rect();
    private com.coloros.anim.a.b.a<ColorFilter, ColorFilter> h;

    c(b bVar, d dVar) {
        super(bVar, dVar);
    }

    public void b(Canvas canvas, Matrix matrix, int i) {
        Bitmap f2 = f();
        if (f2 != null && !f2.isRecycled()) {
            float a2 = g.a();
            k.c("ImageLayer#draw");
            this.e.setAlpha(i);
            com.coloros.anim.a.b.a<ColorFilter, ColorFilter> aVar = this.h;
            if (aVar != null) {
                this.e.setColorFilter(aVar.g());
            }
            canvas.save();
            canvas.concat(matrix);
            this.f.set(0, 0, f2.getWidth(), f2.getHeight());
            this.g.set(0, 0, (int) (((float) f2.getWidth()) * a2), (int) (((float) f2.getHeight()) * a2));
            canvas.drawBitmap(f2, this.f, this.g, this.e);
            canvas.restore();
            k.d("ImageLayer#draw");
        }
    }

    public void a(RectF rectF, Matrix matrix, boolean z) {
        super.a(rectF, matrix, z);
        Bitmap f2 = f();
        if (f2 != null) {
            rectF.set(0.0f, 0.0f, ((float) f2.getWidth()) * g.a(), ((float) f2.getHeight()) * g.a());
            this.f2404a.mapRect(rectF);
        }
    }

    private Bitmap f() {
        return this.f2405b.e(this.c.g());
    }

    public <T> void a(T t, com.coloros.anim.g.b<T> bVar) {
        super.a(t, bVar);
        if (t != d.z) {
            return;
        }
        if (bVar == null) {
            this.h = null;
        } else {
            this.h = new p(bVar);
        }
    }
}
