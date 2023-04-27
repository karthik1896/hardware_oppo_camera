package com.airbnb.lottie.c.a;

import android.graphics.PointF;
import com.airbnb.lottie.a.b.m;
import com.airbnb.lottie.g.a;
import java.util.List;

/* compiled from: AnimatableSplitDimensionPathValue */
public class i implements m<PointF, PointF> {

    /* renamed from: a  reason: collision with root package name */
    private final b f1660a;

    /* renamed from: b  reason: collision with root package name */
    private final b f1661b;

    public i(b bVar, b bVar2) {
        this.f1660a = bVar;
        this.f1661b = bVar2;
    }

    public List<a<PointF>> c() {
        throw new UnsupportedOperationException("Cannot call getKeyframes on AnimatableSplitDimensionPathValue.");
    }

    public boolean b() {
        return this.f1660a.b() && this.f1661b.b();
    }

    public com.airbnb.lottie.a.b.a<PointF, PointF> a() {
        return new m(this.f1660a.a(), this.f1661b.a());
    }
}
