package a.a.b.a;

import a.a.b.a.a.b;
import a.a.b.b.d;
import a.a.b.e.t;
import a.a.b.f;
import android.content.res.Resources;
import android.opengl.GLES20;
import android.util.LruCache;
import co.polarr.renderer.entities.Context;

public class ay extends b {
    public static LruCache<String, ay> q = new LruCache<>(5);
    public float A;
    public float r;
    public float s;
    public float t;
    public float u;
    public float[] v;
    public float[] w;
    public float x;
    public float y;
    public float[] z;

    public ay(Resources resources, Context context) {
        super(resources, t.a("mask_color"), context);
        this.o = t.a("distortion_vertex");
    }

    public static ay a(Resources resources, Context context) {
        ay ayVar = q.get(Thread.currentThread().getName());
        if (ayVar == null) {
            ayVar = new ay(resources, context);
            ayVar.a();
            q.put(Thread.currentThread().getName(), ayVar);
        }
        ayVar.a(context);
        return ayVar;
    }

    public static void l() {
        q.evictAll();
    }

    public void i() {
        super.i();
        int glGetUniformLocation = GLES20.glGetUniformLocation(this.f3b, "colorMap");
        GLES20.glActiveTexture(33985);
        GLES20.glBindTexture(3553, this.f2a.dehazeTexture.f11a);
        GLES20.glUniform1i(glGetUniformLocation, 1);
        GLES20.glUniformMatrix4fv(GLES20.glGetUniformLocation(this.f3b, "viewMatrix"), 1, false, this.f2a.matrix, 0);
        int glGetUniformLocation2 = GLES20.glGetUniformLocation(this.f3b, "imgSize");
        d dVar = this.f2a.imageTexture;
        GLES20.glUniform2f(glGetUniformLocation2, (float) dVar.f12b, (float) dVar.c);
        GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f3b, "distortion_amount"), ((Float) f.a("distortion_amount", this.f2a.renderStates)).floatValue());
        GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f3b, "distortion_horizontal"), ((Float) f.a("distortion_horizontal", this.f2a.renderStates)).floatValue());
        GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f3b, "distortion_vertical"), ((Float) f.a("distortion_vertical", this.f2a.renderStates)).floatValue());
        GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f3b, "feather"), this.r);
        GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f3b, "invert"), this.s);
        GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f3b, "useRadius"), this.t);
        GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f3b, "threshold"), this.u);
        GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f3b, "opacity"), this.x);
        GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f3b, "alpha"), this.y);
        GLES20.glUniform2fv(GLES20.glGetUniformLocation(this.f3b, "position"), 1, this.v, 0);
        GLES20.glUniform2fv(GLES20.glGetUniformLocation(this.f3b, "size"), 1, this.w, 0);
        float[] fArr = this.z;
        if (fArr != null && fArr.length == 3) {
            GLES20.glUniform3fv(GLES20.glGetUniformLocation(this.f3b, "selectedColor"), 1, this.z, 0);
        }
        GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f3b, "useSelectedColor"), this.A);
    }
}
