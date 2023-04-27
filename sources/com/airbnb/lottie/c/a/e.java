package com.airbnb.lottie.c.a;

import android.graphics.PointF;
import com.airbnb.lottie.a.b.i;
import com.airbnb.lottie.a.b.j;
import com.airbnb.lottie.g.a;
import java.util.Collections;
import java.util.List;

/* compiled from: AnimatablePathValue */
public class e implements m<PointF, PointF> {

    /* renamed from: a  reason: collision with root package name */
    private final List<a<PointF>> f1659a;

    public e() {
        this.f1659a = Collections.singletonList(new a(new PointF(0.0f, 0.0f)));
    }

    public e(List<a<PointF>> list) {
        this.f1659a = list;
    }

    public List<a<PointF>> c() {
        return this.f1659a;
    }

    public boolean b() {
        return this.f1659a.size() == 1 && this.f1659a.get(0).e();
    }

    public com.airbnb.lottie.a.b.a<PointF, PointF> a() {
        if (this.f1659a.get(0).e()) {
            return new j(this.f1659a);
        }
        return new i(this.f1659a);
    }
}
