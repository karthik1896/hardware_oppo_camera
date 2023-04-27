package a.a.b.a;

import a.a.b.a.a.b;
import a.a.b.e.t;
import android.content.res.Resources;
import android.opengl.GLES20;
import android.util.LruCache;
import co.polarr.renderer.entities.Context;

public class l extends b {
    public static LruCache<String, l> q = new LruCache<>(5);
    public float r;
    public float[] s;
    public float t;
    public float u;

    public l(Resources resources, Context context) {
        super(resources, t.a("mask_brush"), context);
        this.o = t.a("composite_vertex");
    }

    public static l a(Resources resources, Context context) {
        l lVar = q.get(Thread.currentThread().getName());
        if (lVar == null) {
            lVar = new l(resources, context);
            lVar.a();
            q.put(Thread.currentThread().getName(), lVar);
        }
        lVar.a(context);
        return lVar;
    }

    public static void l() {
        q.evictAll();
    }

    public void i() {
        super.i();
        int glGetUniformLocation = GLES20.glGetUniformLocation(this.f3b, "brushTexture");
        GLES20.glActiveTexture(33985);
        GLES20.glBindTexture(3553, this.f2a.paintTexture.f11a);
        GLES20.glUniform1i(glGetUniformLocation, 1);
        GLES20.glUniformMatrix4fv(GLES20.glGetUniformLocation(this.f3b, "viewMatrix"), 1, false, this.f2a.matrix, 0);
        GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f3b, "invert"), this.r);
        GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f3b, "opacity"), this.t);
        GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f3b, "alpha"), this.u);
        if (this.s != null) {
            GLES20.glUniform4fv(GLES20.glGetUniformLocation(this.f3b, "channel"), 1, this.s, 0);
        }
    }
}
