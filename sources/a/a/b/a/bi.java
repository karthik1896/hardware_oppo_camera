package a.a.b.a;

import a.a.b.a.a.b;
import a.a.b.e.t;
import android.content.res.Resources;
import android.opengl.GLES20;
import android.util.LruCache;
import co.polarr.renderer.entities.Context;

public class bi extends b {
    public static LruCache<String, bi> q = new LruCache<>(5);
    public float[] r = {1.0f, 0.0f, 0.0f, 0.0f};
    public float s = 0.0f;

    public bi(Resources resources, Context context) {
        super(resources, t.a("fill"), context);
    }

    public static bi a(Resources resources, Context context) {
        bi biVar = q.get(Thread.currentThread().getName());
        if (biVar == null) {
            biVar = new bi(resources, context);
            biVar.a();
            q.put(Thread.currentThread().getName(), biVar);
        }
        biVar.a(context);
        return biVar;
    }

    public static void l() {
        q.evictAll();
    }

    public void i() {
        super.i();
        GLES20.glUniform4fv(GLES20.glGetUniformLocation(this.f3b, "fill_color"), 1, this.r, 0);
        GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f3b, "fill_blend"), this.s);
    }
}
