package com.coloros.anim.a.b;

import android.graphics.Path;
import com.coloros.anim.f.f;
import com.coloros.anim.g.c;
import java.util.List;

/* compiled from: ShapeKeyframeAnimation */
public class l extends a<com.coloros.anim.c.b.l, Path> {
    private final com.coloros.anim.c.b.l c = new com.coloros.anim.c.b.l();
    private final Path d = new Path();

    public l(List<c<com.coloros.anim.c.b.l>> list) {
        super(list);
    }

    /* renamed from: b */
    public Path a(c<com.coloros.anim.c.b.l> cVar, float f) {
        this.c.a((com.coloros.anim.c.b.l) cVar.f2479a, (com.coloros.anim.c.b.l) cVar.d, f);
        f.a(this.c, this.d);
        return this.d;
    }
}
