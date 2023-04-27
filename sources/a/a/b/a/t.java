package a.a.b.a;

import a.a.b.a.a.b;
import android.content.res.Resources;
import android.opengl.GLES20;
import android.util.LruCache;
import co.polarr.renderer.entities.Context;

public class t extends b {
    public static LruCache<String, t> q = new LruCache<>(5);
    public float[] r;

    public t(Resources resources, Context context) {
        super(resources, a.a.b.e.t.a("blur_mask"), context);
    }

    public static t a(Resources resources, Context context) {
        t tVar = q.get(Thread.currentThread().getName());
        if (tVar == null) {
            tVar = new t(resources, context);
            tVar.a();
            q.put(Thread.currentThread().getName(), tVar);
        }
        tVar.a(context);
        return tVar;
    }

    public static void l() {
        q.evictAll();
    }

    public void i() {
        super.i();
        GLES20.glUniform2fv(GLES20.glGetUniformLocation(this.f3b, "delta"), 1, this.r, 0);
    }
}
