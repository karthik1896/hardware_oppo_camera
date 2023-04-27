package com.coloros.anim.c.a;

import android.graphics.PointF;
import com.coloros.anim.a.b.a;
import com.coloros.anim.a.b.i;
import com.coloros.anim.a.b.j;
import com.coloros.anim.f.b;
import com.coloros.anim.g.c;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* compiled from: AnimatablePathValue */
public class e implements m<PointF, PointF> {

    /* renamed from: a  reason: collision with root package name */
    private final List<c<PointF>> f2360a;

    public e() {
        this.f2360a = Collections.singletonList(new c(new PointF(0.0f, 0.0f)));
    }

    public e(List<c<PointF>> list) {
        this.f2360a = list;
    }

    public List<c<PointF>> c() {
        return this.f2360a;
    }

    public boolean b() {
        return this.f2360a.size() == 1 && this.f2360a.get(0).e();
    }

    public a<PointF, PointF> a() {
        if (this.f2360a.get(0).e()) {
            if (b.d) {
                b.b("AnimatablePathValue.create PointKeyframeAnimation, keyframes is :" + toString());
            }
            return new j(this.f2360a);
        }
        if (b.d) {
            b.b("AnimatablePathValue.create PathKeyframeAnimation, keyframes is :" + toString());
        }
        return new i(this.f2360a);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (!this.f2360a.isEmpty()) {
            sb.append("values=");
            sb.append(Arrays.toString(this.f2360a.toArray()));
        }
        return sb.toString();
    }
}
