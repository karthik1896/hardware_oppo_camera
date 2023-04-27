package a.a.b.a;

import a.a.b.a.a.b;
import a.a.b.e.t;
import android.content.res.Resources;
import android.opengl.GLES20;
import android.util.LruCache;
import co.polarr.renderer.entities.Context;

public class ba extends b {
    public static LruCache<String, ba> q = new LruCache<>(5);

    public ba(Resources resources, Context context) {
        super(resources, t.a("multitexture"), context);
    }

    public static ba a(Resources resources, Context context) {
        ba baVar = q.get(Thread.currentThread().getName());
        if (baVar == null) {
            baVar = new ba(resources, context);
            baVar.a();
            q.put(Thread.currentThread().getName(), baVar);
        }
        baVar.a(context);
        return baVar;
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
    }
}
