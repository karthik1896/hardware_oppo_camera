package androidx.cardview.a;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import androidx.cardview.a.h;

/* compiled from: CardViewBaseImpl */
class d implements f {

    /* renamed from: a  reason: collision with root package name */
    final RectF f507a = new RectF();

    public void g(e eVar) {
    }

    d() {
    }

    public void a() {
        h.f511a = new h.a() {
            public void a(Canvas canvas, RectF rectF, float f, Paint paint) {
                Canvas canvas2 = canvas;
                RectF rectF2 = rectF;
                float f2 = 2.0f * f;
                float width = (rectF.width() - f2) - 1.0f;
                float height = (rectF.height() - f2) - 1.0f;
                if (f >= 1.0f) {
                    float f3 = f + 0.5f;
                    float f4 = -f3;
                    d.this.f507a.set(f4, f4, f3, f3);
                    int save = canvas.save();
                    canvas2.translate(rectF2.left + f3, rectF2.top + f3);
                    Paint paint2 = paint;
                    canvas.drawArc(d.this.f507a, 180.0f, 90.0f, true, paint2);
                    canvas2.translate(width, 0.0f);
                    canvas2.rotate(90.0f);
                    canvas.drawArc(d.this.f507a, 180.0f, 90.0f, true, paint2);
                    canvas2.translate(height, 0.0f);
                    canvas2.rotate(90.0f);
                    canvas.drawArc(d.this.f507a, 180.0f, 90.0f, true, paint2);
                    canvas2.translate(width, 0.0f);
                    canvas2.rotate(90.0f);
                    canvas.drawArc(d.this.f507a, 180.0f, 90.0f, true, paint2);
                    canvas2.restoreToCount(save);
                    canvas.drawRect((rectF2.left + f3) - 1.0f, rectF2.top, (rectF2.right - f3) + 1.0f, rectF2.top + f3, paint2);
                    canvas.drawRect((rectF2.left + f3) - 1.0f, rectF2.bottom - f3, (rectF2.right - f3) + 1.0f, rectF2.bottom, paint2);
                }
                canvas.drawRect(rectF2.left, rectF2.top + f, rectF2.right, rectF2.bottom - f, paint);
            }
        };
    }

    public void a(e eVar, Context context, ColorStateList colorStateList, float f, float f2, float f3) {
        h a2 = a(context, colorStateList, f, f2, f3);
        a2.a(eVar.b());
        eVar.a(a2);
        f(eVar);
    }

    private h a(Context context, ColorStateList colorStateList, float f, float f2, float f3) {
        return new h(context.getResources(), colorStateList, f, f2, f3);
    }

    public void f(e eVar) {
        Rect rect = new Rect();
        j(eVar).a(rect);
        eVar.a((int) Math.ceil((double) b(eVar)), (int) Math.ceil((double) c(eVar)));
        eVar.a(rect.left, rect.top, rect.right, rect.bottom);
    }

    public void h(e eVar) {
        j(eVar).a(eVar.b());
        f(eVar);
    }

    public void a(e eVar, ColorStateList colorStateList) {
        j(eVar).a(colorStateList);
    }

    public ColorStateList i(e eVar) {
        return j(eVar).f();
    }

    public void a(e eVar, float f) {
        j(eVar).a(f);
        f(eVar);
    }

    public float d(e eVar) {
        return j(eVar).a();
    }

    public void c(e eVar, float f) {
        j(eVar).b(f);
    }

    public float e(e eVar) {
        return j(eVar).b();
    }

    public void b(e eVar, float f) {
        j(eVar).c(f);
        f(eVar);
    }

    public float a(e eVar) {
        return j(eVar).c();
    }

    public float b(e eVar) {
        return j(eVar).d();
    }

    public float c(e eVar) {
        return j(eVar).e();
    }

    private h j(e eVar) {
        return (h) eVar.c();
    }
}
