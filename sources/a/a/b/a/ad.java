package a.a.b.a;

import a.a.b.a.a.b;
import a.a.b.e.t;
import android.content.res.Resources;
import android.opengl.GLES20;
import android.util.LruCache;
import co.polarr.renderer.entities.Context;

public class ad extends b {
    public static LruCache<String, ad> q = new LruCache<>(5);
    public int r;

    public ad(Resources resources, Context context) {
        super(resources, t.a("unmask"), context);
    }

    public static ad a(Resources resources, Context context) {
        ad adVar = q.get(Thread.currentThread().getName());
        if (adVar == null) {
            adVar = new ad(resources, context);
            adVar.a();
            q.put(Thread.currentThread().getName(), adVar);
        }
        adVar.a(context);
        return adVar;
    }

    public static void l() {
        q.evictAll();
    }

    public void d() {
    }

    public void e() {
    }

    public void i() {
        super.i();
        int glGetUniformLocation = GLES20.glGetUniformLocation(this.f3b, "source");
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, this.r);
        GLES20.glUniform1i(glGetUniformLocation, 0);
    }
}
