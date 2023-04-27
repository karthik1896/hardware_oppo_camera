package a.a.b.a;

import a.a.b.a.a.b;
import a.a.b.b.f;
import a.a.b.e.t;
import android.content.res.Resources;
import android.opengl.GLES20;
import android.util.LruCache;
import co.polarr.renderer.entities.Context;

public class bj extends b {
    public static LruCache<String, bj> q = new LruCache<>(5);
    public f r;
    public Context.FaceState s;

    public bj(Resources resources, Context context) {
        super(resources, t.a("face"), context);
        this.o = t.a("distortion_vertex");
    }

    public static bj a(Resources resources, Context context) {
        bj bjVar = q.get(Thread.currentThread().getName());
        if (bjVar == null) {
            bjVar = new bj(resources, context);
            bjVar.a();
            q.put(Thread.currentThread().getName(), bjVar);
        }
        bjVar.a(context);
        return bjVar;
    }

    public static void l() {
        q.evictAll();
    }

    public void i() {
        super.i();
        int glGetUniformLocation = GLES20.glGetUniformLocation(this.f3b, "smoothMap");
        GLES20.glActiveTexture(33985);
        GLES20.glBindTexture(3553, this.f2a.dehazeTexture.f11a);
        GLES20.glUniform1i(glGetUniformLocation, 1);
        int glGetUniformLocation2 = GLES20.glGetUniformLocation(this.f3b, "faceMask");
        GLES20.glActiveTexture(33986);
        GLES20.glBindTexture(3553, this.r.f11a);
        GLES20.glUniform1i(glGetUniformLocation2, 2);
        GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f3b, "distortion_amount"), ((Float) a.a.b.f.a("distortion_amount", this.f2a.renderStates)).floatValue());
        GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f3b, "distortion_horizontal"), ((Float) a.a.b.f.a("distortion_horizontal", this.f2a.renderStates)).floatValue());
        GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f3b, "distortion_vertical"), ((Float) a.a.b.f.a("distortion_vertical", this.f2a.renderStates)).floatValue());
        GLES20.glUniformMatrix4fv(GLES20.glGetUniformLocation(this.f3b, "viewMatrix"), 1, false, this.f2a.matrix, 0);
        if (this.s != null) {
            GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f3b, "skin_smoothness"), this.s.skin_smoothness);
            GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f3b, "skin_tone"), this.s.skin_tone);
            GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f3b, "skin_hue"), this.s.skin_hue);
            GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f3b, "skin_saturation"), this.s.skin_saturation);
            GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f3b, "skin_shadows"), this.s.skin_shadows);
            GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f3b, "skin_highlights"), this.s.skin_highlights);
            GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f3b, "teeth_whitening"), this.s.teeth_whitening);
            GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f3b, "teeth_brightness"), this.s.teeth_brightness);
            GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f3b, "eyes_brightness"), this.s.eyes_brightness);
            GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f3b, "eyes_contrast"), this.s.eyes_contrast);
            GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f3b, "eyes_clarity"), this.s.eyes_clarity);
            GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f3b, "lips_brightness"), this.s.lips_brightness);
            GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f3b, "lips_saturation"), this.s.lips_saturation);
        }
    }
}
