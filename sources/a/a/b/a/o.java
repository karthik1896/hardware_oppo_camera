package a.a.b.a;

import a.a.b.a.a.b;
import a.a.b.b.d;
import a.a.b.e.t;
import android.content.res.Resources;
import android.opengl.GLES20;
import android.util.LruCache;
import co.polarr.renderer.entities.Context;

public final class o extends b {
    public static LruCache<String, o> q = new LruCache<>(5);
    public float r;
    public float s;
    public float t;
    public float[] u;
    public float[] v;
    public float w;
    public float x;

    public o(Resources resources, Context context) {
        super(resources, t.a("mask_radial"), context);
        this.o = t.a("composite_vertex");
    }

    public static o a(Resources resources, Context context) {
        o oVar = q.get(Thread.currentThread().getName());
        if (oVar == null) {
            oVar = new o(resources, context);
            oVar.a();
            q.put(Thread.currentThread().getName(), oVar);
        }
        oVar.a(context);
        return oVar;
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
        GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f3b, "feather"), this.r);
        GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f3b, "invert"), this.s);
        GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f3b, "angle"), this.t);
        GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f3b, "opacity"), this.w);
        GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f3b, "alpha"), this.x);
        int glGetUniformLocation2 = GLES20.glGetUniformLocation(this.f3b, "position");
        if (this.f2a.isSDK) {
            float[] fArr = this.u;
            GLES20.glUniform2f(glGetUniformLocation2, fArr[0], -fArr[1]);
        } else {
            GLES20.glUniform2fv(glGetUniformLocation2, 1, this.u, 0);
        }
        GLES20.glUniform2fv(GLES20.glGetUniformLocation(this.f3b, "size"), 1, this.v, 0);
    }
}
