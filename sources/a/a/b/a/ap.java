package a.a.b.a;

import a.a.b.a.a.b;
import a.a.b.b.d;
import a.a.b.e.t;
import android.content.res.Resources;
import android.opengl.GLES20;
import android.util.LruCache;
import co.polarr.renderer.entities.Context;

public class ap extends b {
    public static LruCache<String, ap> q = new LruCache<>(5);
    public float r;
    public float[] s;
    public float[] t;
    public float[] u;
    public float v;
    public float w;

    public ap(Resources resources, Context context) {
        super(resources, t.a("spot_heal_mask"), context);
        this.o = t.a("composite_vertex");
    }

    public static ap a(Resources resources, Context context) {
        ap apVar = q.get(Thread.currentThread().getName());
        if (apVar == null) {
            apVar = new ap(resources, context);
            apVar.a();
            q.put(Thread.currentThread().getName(), apVar);
        }
        apVar.a(context);
        return apVar;
    }

    public static void l() {
        q.evictAll();
    }

    public void i() {
        super.i();
        GLES20.glUniformMatrix4fv(GLES20.glGetUniformLocation(this.f3b, "viewMatrix"), 1, false, getMatrix(), 0);
        int glGetUniformLocation = GLES20.glGetUniformLocation(this.f3b, "imgSize");
        d dVar = this.f2a.imageTexture;
        GLES20.glUniform2f(glGetUniformLocation, (float) dVar.f12b, (float) dVar.c);
        GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f3b, "feather"), this.r);
        GLES20.glUniform2fv(GLES20.glGetUniformLocation(this.f3b, "size"), 1, this.s, 0);
        GLES20.glUniform2fv(GLES20.glGetUniformLocation(this.f3b, "position"), 1, this.t, 0);
        GLES20.glUniform2fv(GLES20.glGetUniformLocation(this.f3b, "sourcePosition"), 1, this.u, 0);
        GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f3b, "opacity"), this.v);
        GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f3b, "alpha"), this.w);
    }
}
