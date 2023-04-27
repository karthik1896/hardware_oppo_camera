package color.support.design.widget;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;
import androidx.core.g.v;

/* compiled from: DividerHelper */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final int f1442a = Color.argb(16, 0, 0, 0);

    /* renamed from: b  reason: collision with root package name */
    public static final int f1443b = Color.argb(16, 255, 255, 255);
    private View c;
    private int d;
    private int e;
    private int f = this.d;
    private int g;
    private Paint h;
    private float i;
    private Point j;
    private Point k;
    private int l = f1442a;
    private int m = f1443b;
    private boolean n;

    public a(View view) {
        this.c = view;
        float f2 = view.getContext().getResources().getDisplayMetrics().density;
        this.d = Math.round(3.0f * f2);
        this.e = Math.round(1.0f * f2);
        this.g = Math.round(f2 * 24.0f);
        this.h = new Paint();
        this.i = 0.0f;
        this.j = new Point();
        this.k = new Point();
    }

    public void a(Canvas canvas) {
        if (this.n) {
            b(canvas);
            this.h.setStyle(Paint.Style.STROKE);
            this.h.setStrokeWidth((float) this.f);
            this.h.setColor(this.m);
            Path path = new Path();
            path.moveTo((float) this.c.getLeft(), (float) this.j.y);
            path.lineTo((float) this.c.getRight(), (float) this.k.y);
            canvas.drawPath(path, this.h);
            Path path2 = new Path();
            this.h.setColor(this.l);
            path2.moveTo((float) this.j.x, (float) this.j.y);
            path2.lineTo((float) this.k.x, (float) this.k.y);
            canvas.drawPath(path2, this.h);
        }
    }

    private void b(Canvas canvas) {
        this.j.x = Math.round(((float) this.g) * (1.0f - this.i));
        Rect rect = new Rect();
        this.c.getLocalVisibleRect(rect);
        this.j.y = rect.bottom - (this.f / 2);
        this.k.x = Math.round(((float) this.c.getMeasuredWidth()) - (((float) this.g) * (1.0f - this.i)));
        this.k.y = this.j.y;
    }

    public void a(int i2) {
        this.l = i2;
    }

    public void b(int i2) {
        this.m = i2;
    }

    public void c(int i2) {
        this.d = i2;
    }

    public int a() {
        return this.d;
    }

    public void d(int i2) {
        this.e = i2;
    }

    public int b() {
        return this.f;
    }

    public void a(boolean z) {
        this.n = z;
        v.e(this.c);
    }

    public void e(int i2) {
        this.g = i2;
    }

    public void f(int i2) {
        if (this.f != i2) {
            this.f = i2;
        }
    }
}
