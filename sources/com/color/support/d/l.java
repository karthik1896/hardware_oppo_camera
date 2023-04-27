package com.color.support.d;

import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import com.color.support.widget.a.b;

/* compiled from: ColorRoundRectUtil */
public class l {

    /* renamed from: a  reason: collision with root package name */
    private static l f1871a;

    /* renamed from: b  reason: collision with root package name */
    private Path f1872b = new Path();

    private l() {
    }

    public static l a() {
        if (f1871a == null) {
            f1871a = new l();
        }
        return f1871a;
    }

    public Path a(Rect rect, float f) {
        return a(new RectF(rect), f);
    }

    public Path a(RectF rectF, float f) {
        return b.a(this.f1872b, rectF, f);
    }
}
