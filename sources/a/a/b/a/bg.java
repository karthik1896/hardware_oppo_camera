package a.a.b.a;

import a.a.b.a.a.b;
import a.a.b.b.d;
import a.a.b.e.t;
import a.a.b.f;
import android.content.res.Resources;
import android.opengl.GLES20;
import android.util.LruCache;
import co.polarr.renderer.entities.Context;

public final class bg extends b {
    public static LruCache<String, bg> q = new LruCache<>(5);
    public float r;
    public float s;
    public float t;
    public float u;
    public float v;
    public float w;

    public bg(Resources resources, Context context) {
        super(resources, t.a("mask_luminance"), context);
        this.o = t.a("distortion_vertex");
    }

    public static bg a(Resources resources, Context context) {
        bg bgVar = q.get(Thread.currentThread().getName());
        if (bgVar == null) {
            bgVar = new bg(resources, context);
            bgVar.a();
            q.put(Thread.currentThread().getName(), bgVar);
        }
        bgVar.a(context);
        return bgVar;
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
        GLES20.glUniformMatrix4fv(GLES20.glGetUniformLocation(this.f3b, "viewMatrix"), 1, false, this.f2a.matrix, 0);
        int glGetUniformLocation2 = GLES20.glGetUniformLocation(this.f3b, "imgSize");
        d dVar = this.f2a.imageTexture;
        GLES20.glUniform2f(glGetUniformLocation2, (float) dVar.f12b, (float) dVar.c);
        GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f3b, "distortion_amount"), ((Float) f.a("distortion_amount", this.f2a.renderStates)).floatValue());
        GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f3b, "distortion_horizontal"), ((Float) f.a("distortion_horizontal", this.f2a.renderStates)).floatValue());
        GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f3b, "distortion_vertical"), ((Float) f.a("distortion_vertical", this.f2a.renderStates)).floatValue());
        GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f3b, "target"), this.r);
        GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f3b, "range"), this.s);
        GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f3b, "smoothness"), this.t);
        GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f3b, "invert"), this.u);
        GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f3b, "opacity"), this.v);
        GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f3b, "alpha"), this.w);
    }
}
