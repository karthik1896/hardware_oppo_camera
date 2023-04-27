package a.a.b.a;

import a.a.b.a.a.b;
import a.a.b.e.t;
import android.content.res.Resources;
import android.opengl.GLES20;
import android.util.LruCache;
import co.polarr.renderer.entities.Context;

public class al extends b {
    public static LruCache<String, al> q = new LruCache<>(5);
    public int r;
    public float[] s;
    public float[] t;
    public float u;
    public float[] v;

    public al(Resources resources, Context context) {
        super(resources, t.a("initialize_field"), context);
        this.o = t.a("patchmatch_vertex");
    }

    public static al a(Resources resources, Context context) {
        al alVar = q.get(Thread.currentThread().getName());
        if (alVar == null) {
            alVar = new al(resources, context);
            alVar.a();
            q.put(Thread.currentThread().getName(), alVar);
        }
        alVar.a(context);
        return alVar;
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
        int glGetUniformLocation2 = GLES20.glGetUniformLocation(this.f3b, "source_size");
        float[] fArr = this.s;
        GLES20.glUniform2f(glGetUniformLocation2, fArr[0], fArr[1]);
        int glGetUniformLocation3 = GLES20.glGetUniformLocation(this.f3b, "full_size");
        float[] fArr2 = this.t;
        GLES20.glUniform2f(glGetUniformLocation3, fArr2[0], fArr2[1]);
        GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f3b, "seed"), this.u);
        GLES20.glUniformMatrix4fv(GLES20.glGetUniformLocation(this.f3b, "region"), 1, false, this.v, 0);
    }
}
