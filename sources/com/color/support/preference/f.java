package com.color.support.preference;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import com.color.support.d.l;
import com.google.android.material.shape.MaterialShapeDrawable;

/* compiled from: ColorRecommendedDrawable */
public class f extends MaterialShapeDrawable {

    /* renamed from: a  reason: collision with root package name */
    private float f2002a;

    /* renamed from: b  reason: collision with root package name */
    private int f2003b;
    private Paint c = new Paint(1);
    private Path d = new Path();

    public f(float f, int i) {
        this.f2002a = f;
        this.f2003b = i;
        this.c.setColor(this.f2003b);
    }

    public void draw(Canvas canvas) {
        this.d.reset();
        this.d = l.a().a(getBounds(), this.f2002a);
        canvas.drawPath(this.d, this.c);
    }
}
