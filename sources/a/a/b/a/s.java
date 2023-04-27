package a.a.b.a;

import a.a.b.a.a.b;
import a.a.b.e.t;
import android.content.res.Resources;
import android.opengl.GLES20;
import android.util.LruCache;
import co.polarr.renderer.entities.Context;

public class s extends b {
    public static LruCache<String, s> q = new LruCache<>(5);
    public int r;
    public int s;
    public int t;

    public s(Resources resources, Context context) {
        super(resources, t.a("paint_split"), context);
    }

    public static s a(Resources resources, Context context) {
        s sVar = q.get(Thread.currentThread().getName());
        if (sVar == null) {
            sVar = new s(resources, context);
            sVar.a();
            q.put(Thread.currentThread().getName(), sVar);
        }
        sVar.a(context);
        return sVar;
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
        int glGetUniformLocation2 = GLES20.glGetUniformLocation(this.f3b, "prePainting");
        GLES20.glActiveTexture(33986);
        GLES20.glBindTexture(3553, this.s);
        GLES20.glUniform1i(glGetUniformLocation2, 2);
        int glGetUniformLocation3 = GLES20.glGetUniformLocation(this.f3b, "curBrush");
        GLES20.glActiveTexture(33987);
        GLES20.glBindTexture(3553, this.t);
        GLES20.glUniform1i(glGetUniformLocation3, 3);
    }
}
