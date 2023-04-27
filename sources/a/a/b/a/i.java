package a.a.b.a;

import a.a.b.a.a.b;
import a.a.b.e.t;
import android.content.res.Resources;
import android.opengl.GLES20;
import android.util.LruCache;
import co.polarr.renderer.entities.Context;

public class i extends b {
    public static LruCache<String, i> q = new LruCache<>(5);
    public int r;

    public i(Resources resources, Context context) {
        super(resources, t.a("paint_blend"), context);
    }

    public static i a(Resources resources, Context context) {
        i iVar = q.get(Thread.currentThread().getName());
        if (iVar == null) {
            iVar = new i(resources, context);
            iVar.a();
            q.put(Thread.currentThread().getName(), iVar);
        }
        iVar.a(context);
        return iVar;
    }

    public static void l() {
        q.evictAll();
    }

    public void i() {
        super.i();
        int glGetUniformLocation = GLES20.glGetUniformLocation(this.f3b, "source");
        GLES20.glActiveTexture(33985);
        GLES20.glBindTexture(3553, this.r);
        GLES20.glUniform1i(glGetUniformLocation, 1);
    }
}
