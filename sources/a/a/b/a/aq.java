package a.a.b.a;

import a.a.b.a.a.b;
import a.a.b.b.d;
import a.a.b.e.t;
import a.a.b.f;
import android.content.res.Resources;
import android.opengl.GLES20;
import android.util.LruCache;
import co.polarr.renderer.entities.Context;

public class aq extends b {
    public static LruCache<String, aq> q = new LruCache<>(5);

    public aq(Resources resources, Context context) {
        super(resources, t.a("out_multitexture"), context);
        this.o = t.a("distortion_vertex");
    }

    public static aq a(Resources resources, Context context) {
        aq aqVar = q.get(Thread.currentThread().getName());
        if (aqVar == null) {
            aqVar = new aq(resources, context);
            aqVar.a();
            q.put(Thread.currentThread().getName(), aqVar);
        }
        aqVar.a(context);
        return aqVar;
    }

    public static void l() {
        q.evictAll();
    }

    public void d() {
    }

    public void i() {
        super.i();
        for (int i = 0; i < 4; i++) {
            GLES20.glActiveTexture(33984 + i);
            GLES20.glBindTexture(3553, this.f2a.textures[i]);
        }
        GLES20.glUniform1iv(GLES20.glGetUniformLocation(this.f3b, "textures[0]"), 4, new int[]{0, 1, 2, 3}, 0);
        int glGetUniformLocation = GLES20.glGetUniformLocation(this.f3b, "texture");
        GLES20.glActiveTexture(33988);
        GLES20.glBindTexture(3553, this.f2a.readableTexture.f11a);
        GLES20.glUniform1i(glGetUniformLocation, 4);
        GLES20.glUniformMatrix4fv(GLES20.glGetUniformLocation(this.f3b, "viewMatrix"), 1, false, this.f2a.matrix, 0);
        GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f3b, "distortion_amount"), ((Float) f.a("distortion_amount", this.f2a.renderStates)).floatValue());
        GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f3b, "distortion_horizontal"), ((Float) f.a("distortion_horizontal", this.f2a.renderStates)).floatValue());
        GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f3b, "distortion_vertical"), ((Float) f.a("distortion_vertical", this.f2a.renderStates)).floatValue());
        int glGetUniformLocation2 = GLES20.glGetUniformLocation(this.f3b, "imgSize");
        d dVar = this.f2a.imageTexture;
        GLES20.glUniform2f(glGetUniformLocation2, (float) dVar.f12b, (float) dVar.c);
    }
}
