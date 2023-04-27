package a.a.b.a;

import a.a.b.a.a.b;
import a.a.b.e.t;
import android.content.res.Resources;
import android.opengl.GLES20;
import android.util.LruCache;
import co.polarr.renderer.entities.Context;

public class as extends b {
    public static LruCache<String, as> q = new LruCache<>(5);
    public int r;

    public as(Resources resources, Context context) {
        super(resources, t.a("combine_mask"), context);
    }

    public static as a(Resources resources, Context context) {
        as asVar = q.get(Thread.currentThread().getName());
        if (asVar == null) {
            asVar = new as(resources, context);
            asVar.a();
            q.put(Thread.currentThread().getName(), asVar);
        }
        asVar.a(context);
        return asVar;
    }

    public static void l() {
        q.evictAll();
    }

    public void i() {
        super.i();
        int glGetUniformLocation = GLES20.glGetUniformLocation(this.f3b, "mask");
        GLES20.glActiveTexture(33985);
        GLES20.glBindTexture(3553, this.r);
        GLES20.glUniform1i(glGetUniformLocation, 1);
    }
}
