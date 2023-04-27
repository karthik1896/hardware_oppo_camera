package a.a.b.a;

import a.a.b.a.a.b;
import a.a.b.e.t;
import android.content.res.Resources;
import android.opengl.GLES20;
import android.util.LruCache;
import co.polarr.renderer.entities.Context;

public class ag extends b {
    public static LruCache<String, ag> q = new LruCache<>(5);
    public int r;
    public int s;
    public int t;
    public float[] u;
    public float[] v;
    public float[] w;
    public float x;
    public float[] y;

    public ag(Resources resources, Context context) {
        super(resources, t.a("random_search"), context);
        this.o = t.a("patchmatch_vertex");
    }

    public static ag a(Resources resources, Context context) {
        ag agVar = q.get(Thread.currentThread().getName());
        if (agVar == null) {
            agVar = new ag(resources, context);
            agVar.a();
            q.put(Thread.currentThread().getName(), agVar);
        }
        agVar.a(context);
        return agVar;
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
        int glGetUniformLocation = GLES20.glGetUniformLocation(this.f3b, "target");
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, this.r);
        GLES20.glUniform1i(glGetUniformLocation, 0);
        int glGetUniformLocation2 = GLES20.glGetUniformLocation(this.f3b, "source");
        GLES20.glActiveTexture(33985);
        GLES20.glBindTexture(3553, this.s);
        GLES20.glUniform1i(glGetUniformLocation2, 1);
        int glGetUniformLocation3 = GLES20.glGetUniformLocation(this.f3b, "field");
        GLES20.glActiveTexture(33986);
        GLES20.glBindTexture(3553, this.t);
        GLES20.glUniform1i(glGetUniformLocation3, 2);
        int glGetUniformLocation4 = GLES20.glGetUniformLocation(this.f3b, "source_size");
        float[] fArr = this.u;
        GLES20.glUniform2f(glGetUniformLocation4, fArr[0], fArr[1]);
        int glGetUniformLocation5 = GLES20.glGetUniformLocation(this.f3b, "target_size");
        float[] fArr2 = this.v;
        GLES20.glUniform2f(glGetUniformLocation5, fArr2[0], fArr2[1]);
        int glGetUniformLocation6 = GLES20.glGetUniformLocation(this.f3b, "full_size");
        float[] fArr3 = this.w;
        GLES20.glUniform2f(glGetUniformLocation6, fArr3[0], fArr3[1]);
        GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f3b, "seed"), this.x);
        GLES20.glUniformMatrix4fv(GLES20.glGetUniformLocation(this.f3b, "region"), 1, false, this.y, 0);
    }
}
