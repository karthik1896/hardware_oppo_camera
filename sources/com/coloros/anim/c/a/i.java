package com.coloros.anim.c.a;

import android.graphics.PointF;
import com.coloros.anim.a.b.a;
import com.coloros.anim.a.b.m;
import com.coloros.anim.f.b;
import com.coloros.anim.g.c;
import java.util.List;

/* compiled from: AnimatableSplitDimensionPathValue */
public class i implements m<PointF, PointF> {

    /* renamed from: a  reason: collision with root package name */
    private final b f2361a;

    /* renamed from: b  reason: collision with root package name */
    private final b f2362b;

    public i(b bVar, b bVar2) {
        this.f2361a = bVar;
        this.f2362b = bVar2;
    }

    public List<c<PointF>> c() {
        throw new UnsupportedOperationException("Cannot call getKeyframes on AnimatableSplitDimensionPathValue.");
    }

    public boolean b() {
        return this.f2361a.b() && this.f2362b.b();
    }

    public a<PointF, PointF> a() {
        if (b.d) {
            b.b("AnimatableSplitDimensionPathValue create SplitDimensionPathKeyframeAnimation.");
        }
        return new m(this.f2361a.a(), this.f2362b.a());
    }
}
