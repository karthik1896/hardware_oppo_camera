package a.a.b.a;

import a.a.b.a.a.a;
import a.a.b.a.a.b;
import a.a.b.b.d;
import a.a.b.e.t;
import android.content.res.Resources;
import android.opengl.GLES20;
import android.util.LruCache;
import co.polarr.renderer.entities.Context;
import java.util.Map;

public class aw extends b {
    public static LruCache<String, aw> q = new LruCache<>(5);
    public String r = "square";
    public float s;
    public float t;
    public float u;
    public int v;

    public aw(Resources resources, Context context) {
        super(resources, t.a("mosaic"), context);
        this.o = t.a("composite_vertex");
    }

    public static aw a(Resources resources, Context context) {
        aw awVar = q.get(Thread.currentThread().getName());
        if (awVar == null) {
            awVar = new aw(resources, context);
            awVar.a();
            q.put(Thread.currentThread().getName(), awVar);
        }
        awVar.a(context);
        return awVar;
    }

    public static void l() {
        q.evictAll();
    }

    public void i() {
        Map<String, d> map;
        d dVar;
        super.i();
        int glGetUniformLocation = GLES20.glGetUniformLocation(this.f3b, "blurTexture");
        GLES20.glActiveTexture(33985);
        GLES20.glBindTexture(3553, this.v);
        GLES20.glUniform1i(glGetUniformLocation, 1);
        String str = this.r;
        if (!(str == null || (map = this.f2a.patterns) == null || (dVar = map.get(str)) == null)) {
            int glGetUniformLocation2 = GLES20.glGetUniformLocation(this.f3b, "patternTexture");
            GLES20.glActiveTexture(33986);
            GLES20.glBindTexture(3553, dVar.f11a);
            GLES20.glUniform1i(glGetUniformLocation2, 2);
            GLES20.glUniform2f(GLES20.glGetUniformLocation(this.f3b, "patternSize"), (float) dVar.f12b, (float) dVar.c);
        }
        GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f3b, "mosaic_size"), (float) (((double) this.s) * Math.sqrt((double) ((this.t * this.u) / 2073600.0f))));
        GLES20.glUniformMatrix4fv(GLES20.glGetUniformLocation(this.f3b, "viewMatrix"), 1, false, a.m, 0);
        GLES20.glUniform2f(GLES20.glGetUniformLocation(this.f3b, "imgSize"), this.t, this.u);
    }
}
