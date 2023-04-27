package a.a.b.a;

import a.a.b.a.a.b;
import a.a.b.b.d;
import a.a.b.e.t;
import a.a.b.f;
import android.content.res.Resources;
import android.opengl.GLES20;
import android.util.LruCache;
import co.polarr.renderer.entities.Context;

public class v extends b {
    public static LruCache<String, v> q = new LruCache<>(5);
    public float r;
    public float[] s;
    public float[] t;
    public float[] u;
    public float v;
    public float w;
    public float x;

    public v(Resources resources, Context context) {
        super(resources, t.a("spot_heal"), context);
        this.o = t.a("spot_heal_vertex");
    }

    public v(Resources resources, String str, Context context) {
        super(resources, str, context);
    }

    public static v a(Resources resources, Context context) {
        v vVar = q.get(Thread.currentThread().getName());
        if (vVar == null) {
            vVar = new v(resources, context);
            vVar.a();
            q.put(Thread.currentThread().getName(), vVar);
        }
        vVar.a(context);
        return vVar;
    }

    public static void l() {
        q.evictAll();
    }

    public void i() {
        super.i();
        int glGetUniformLocation = GLES20.glGetUniformLocation(this.f3b, "smoothTexture");
        GLES20.glActiveTexture(33985);
        GLES20.glBindTexture(3553, this.f2a.dehazeTexture.f11a);
        GLES20.glUniform1i(glGetUniformLocation, 1);
        int glGetUniformLocation2 = GLES20.glGetUniformLocation(this.f3b, "originalTexture");
        GLES20.glActiveTexture(33986);
        GLES20.glBindTexture(3553, this.f2a.imageTexture.f11a);
        GLES20.glUniform1i(glGetUniformLocation2, 2);
        int glGetUniformLocation3 = GLES20.glGetUniformLocation(this.f3b, "retouchTexture");
        GLES20.glActiveTexture(33987);
        GLES20.glBindTexture(3553, this.f2a.retouchTexture.f11a);
        GLES20.glUniform1i(glGetUniformLocation3, 3);
        GLES20.glUniformMatrix4fv(GLES20.glGetUniformLocation(this.f3b, "viewMatrix"), 1, false, this.f2a.matrix, 0);
        GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f3b, "distortion_amount"), ((Float) f.a("distortion_amount", this.f2a.renderStates)).floatValue());
        GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f3b, "distortion_horizontal"), ((Float) f.a("distortion_horizontal", this.f2a.renderStates)).floatValue());
        GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f3b, "distortion_vertical"), ((Float) f.a("distortion_vertical", this.f2a.renderStates)).floatValue());
        int glGetUniformLocation4 = GLES20.glGetUniformLocation(this.f3b, "imgSize");
        d dVar = this.f2a.imageTexture;
        GLES20.glUniform2f(glGetUniformLocation4, (float) dVar.f12b, (float) dVar.c);
        m();
    }

    public void m() {
        GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f3b, "feather"), this.r);
        GLES20.glUniform2fv(GLES20.glGetUniformLocation(this.f3b, "size"), 1, this.s, 0);
        GLES20.glUniform2fv(GLES20.glGetUniformLocation(this.f3b, "position"), 1, this.t, 0);
        GLES20.glUniform2fv(GLES20.glGetUniformLocation(this.f3b, "sourcePosition"), 1, this.u, 0);
        GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f3b, "opacity"), this.w);
        GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f3b, "angle"), this.v);
        GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f3b, "mode"), this.x);
    }
}
