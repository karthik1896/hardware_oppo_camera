package a.a.b.a;

import a.a.b.a.a.b;
import a.a.b.b.d;
import a.a.b.e.t;
import android.content.res.Resources;
import android.opengl.GLES20;
import android.util.LruCache;
import co.polarr.renderer.entities.Context;

public final class a extends b {
    public static LruCache<String, a> q = new LruCache<>(5);
    public float[] r;
    public float[] s;
    public float t;
    public float u;
    public float v;
    public float w;

    public a(Resources resources, Context context) {
        super(resources, t.a("mask_gradient"), context);
        this.o = t.a("composite_vertex");
    }

    public static a a(Resources resources, Context context) {
        a aVar = q.get(Thread.currentThread().getName());
        if (aVar == null) {
            aVar = new a(resources, context);
            aVar.a();
            q.put(Thread.currentThread().getName(), aVar);
        }
        aVar.a(context);
        return aVar;
    }

    public static void l() {
        q.evictAll();
    }

    public void i() {
        super.i();
        GLES20.glUniformMatrix4fv(GLES20.glGetUniformLocation(this.f3b, "viewMatrix"), 1, false, this.f2a.matrix, 0);
        int glGetUniformLocation = GLES20.glGetUniformLocation(this.f3b, "imgSize");
        d dVar = this.f2a.imageTexture;
        GLES20.glUniform2f(glGetUniformLocation, (float) dVar.f12b, (float) dVar.c);
        GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f3b, "invert"), this.t);
        GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f3b, "reflect"), this.u);
        GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f3b, "opacity"), this.v);
        GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f3b, "alpha"), this.w);
        GLES20.glUniform2fv(GLES20.glGetUniformLocation(this.f3b, "endPoint"), 1, this.s, 0);
        GLES20.glUniform2fv(GLES20.glGetUniformLocation(this.f3b, "startPoint"), 1, this.r, 0);
    }
}
