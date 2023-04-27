package a.a.b.a;

import a.a.b.a.a.b;
import a.a.b.e.t;
import android.content.res.Resources;
import android.opengl.GLES20;
import android.util.LruCache;
import co.polarr.renderer.entities.Context;

public class bd extends b {
    public static LruCache<String, bd> q = new LruCache<>(5);

    public bd(Resources resources, Context context) {
        super(resources, t.a("blur_composite"), context);
        this.o = t.a("composite_vertex");
    }

    public static bd a(Resources resources, Context context) {
        bd bdVar = q.get(Thread.currentThread().getName());
        if (bdVar == null) {
            bdVar = new bd(resources, context);
            bdVar.a();
            q.put(Thread.currentThread().getName(), bdVar);
        }
        bdVar.a(context);
        return bdVar;
    }

    public static void l() {
        q.evictAll();
    }

    public void i() {
        super.i();
        int glGetUniformLocation = GLES20.glGetUniformLocation(this.f3b, "blurTexture");
        GLES20.glActiveTexture(33985);
        GLES20.glBindTexture(3553, this.f2a.lensBlurTexture.f11a);
        GLES20.glUniform1i(glGetUniformLocation, 1);
        GLES20.glUniformMatrix4fv(GLES20.glGetUniformLocation(this.f3b, "viewMatrix"), 1, false, this.f2a.matrix, 0);
    }
}
