package co.polarr.renderer.filters;

import a.a.b.a.a.b;
import a.a.b.e.o;
import android.content.res.Resources;
import android.util.LruCache;
import co.polarr.renderer.entities.Context;

public class Basic extends b {
    public static LruCache<String, Basic> r = new LruCache<>(5);
    public boolean q = true;

    public Basic(Resources resources, Context context) {
        super(resources, "basic.glsl", context);
    }

    public static Basic a(Resources resources, Context context) {
        Basic basic = r.get(Thread.currentThread().getName());
        if (basic == null) {
            basic = new Basic(resources, context);
            basic.a();
            r.put(Thread.currentThread().getName(), basic);
        }
        basic.a(context);
        basic.a(o.a());
        basic.q = true;
        return basic;
    }

    public static Basic getInstance(Resources resources) {
        Basic basic = r.get(Thread.currentThread().getName());
        if (basic == null) {
            basic = new Basic(resources, new Context());
            basic.a();
            r.put(Thread.currentThread().getName(), basic);
        }
        basic.a(o.a());
        basic.q = true;
        return basic;
    }

    public static void l() {
        r.evictAll();
    }

    public void draw() {
        super.draw();
    }

    public void e() {
        if (this.q) {
            super.e();
        }
    }

    public float[] getMatrix() {
        return super.getMatrix();
    }

    public boolean k() {
        return false;
    }

    public void setInputTextureId(int i) {
        a(i);
    }

    public void setNeedClear(boolean z) {
        this.q = z;
    }
}
