package a.a.b.a;

import a.a.b.a.a.b;
import a.a.b.b.d;
import a.a.b.e.t;
import android.content.res.Resources;
import android.opengl.GLES20;
import android.util.LruCache;
import co.polarr.renderer.entities.Context;

public class bb extends b {
    public static LruCache<String, bb> q = new LruCache<>(5);

    public bb(Resources resources, Context context) {
        super(resources, t.a("distortion_multitexture"), context);
        this.o = t.a("fringing_vertex");
        a(new String[]{"distortion_amount", "fringing", "distortion_horizontal", "distortion_vertical"});
    }

    public static bb a(Resources resources, Context context) {
        bb bbVar = q.get(Thread.currentThread().getName());
        if (bbVar == null) {
            bbVar = new bb(resources, context);
            bbVar.a();
            q.put(Thread.currentThread().getName(), bbVar);
        }
        bbVar.a(context);
        return bbVar;
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
        int glGetUniformLocation = GLES20.glGetUniformLocation(this.f3b, "imgSize");
        d dVar = this.f2a.imageTexture;
        GLES20.glUniform2f(glGetUniformLocation, (float) dVar.f12b, (float) dVar.c);
    }
}
