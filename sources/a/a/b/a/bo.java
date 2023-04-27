package a.a.b.a;

import a.a.b.b.d;
import a.a.b.e.t;
import a.a.b.f;
import android.content.res.Resources;
import android.opengl.GLES20;
import android.util.LruCache;
import co.polarr.renderer.entities.Context;

public class bo extends v {
    public static LruCache<String, bo> y = new LruCache<>(5);

    public bo(Resources resources, Context context) {
        super(resources, t.a("spot_heal_multitexture"), context);
        this.o = t.a("spot_heal_vertex");
    }

    public static bo b(Resources resources, Context context) {
        bo boVar = y.get(Thread.currentThread().getName());
        if (boVar == null) {
            boVar = new bo(resources, context);
            boVar.a();
            y.put(Thread.currentThread().getName(), boVar);
        }
        boVar.a(context);
        return boVar;
    }

    public static void n() {
        y.evictAll();
    }

    public void d() {
    }

    public void i() {
        super.i();
        int glGetUniformLocation = GLES20.glGetUniformLocation(this.f3b, "smoothTexture");
        GLES20.glActiveTexture(33985);
        GLES20.glBindTexture(3553, this.f2a.dehazeTexture.f11a);
        GLES20.glUniform1i(glGetUniformLocation, 1);
        int glGetUniformLocation2 = GLES20.glGetUniformLocation(this.f3b, "retouchTexture");
        GLES20.glActiveTexture(33986);
        GLES20.glBindTexture(3553, this.f2a.retouchTexture.f11a);
        GLES20.glUniform1i(glGetUniformLocation2, 2);
        GLES20.glUniform1iv(GLES20.glGetUniformLocation(this.f3b, "textures[0]"), 4, new int[]{3, 4, 5, 6}, 0);
        for (int i = 1; i <= 4; i++) {
            GLES20.glActiveTexture(33984 + i + 2);
            GLES20.glBindTexture(3553, this.f2a.textures[i - 1]);
        }
        GLES20.glUniformMatrix4fv(GLES20.glGetUniformLocation(this.f3b, "viewMatrix"), 1, false, this.f2a.matrix, 0);
        GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f3b, "distortion_amount"), ((Float) f.a("distortion_amount", this.f2a.renderStates)).floatValue());
        GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f3b, "distortion_horizontal"), ((Float) f.a("distortion_horizontal", this.f2a.renderStates)).floatValue());
        GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f3b, "distortion_vertical"), ((Float) f.a("distortion_vertical", this.f2a.renderStates)).floatValue());
        int glGetUniformLocation3 = GLES20.glGetUniformLocation(this.f3b, "imgSize");
        d dVar = this.f2a.imageTexture;
        GLES20.glUniform2f(glGetUniformLocation3, (float) dVar.f12b, (float) dVar.c);
        m();
    }
}
