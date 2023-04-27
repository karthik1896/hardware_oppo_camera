package a.a.b.a;

import a.a.b.a.a.b;
import a.a.b.b.d;
import a.a.b.e.t;
import android.content.res.Resources;
import android.opengl.GLES20;
import android.util.LruCache;
import co.polarr.renderer.entities.Context;

public class at extends b {
    public static LruCache<String, at> q = new LruCache<>(5);
    public d r;
    public float[] s;
    public float t;
    public float u;
    public float v;
    public float[] w;

    public at(Resources resources, Context context) {
        super(resources, t.a("layer"), context);
        this.o = t.a("layer_vertex");
    }

    public static at a(Resources resources, Context context) {
        at atVar = q.get(Thread.currentThread().getName());
        if (atVar == null) {
            atVar = new at(resources, context);
            atVar.a();
            q.put(Thread.currentThread().getName(), atVar);
        }
        atVar.a(context);
        return atVar;
    }

    public static void l() {
        q.evictAll();
    }

    public void e() {
    }

    public void i() {
        super.i();
        int glGetUniformLocation = GLES20.glGetUniformLocation(this.f3b, "layerTexture");
        GLES20.glActiveTexture(33985);
        GLES20.glBindTexture(3553, this.r.f11a);
        GLES20.glUniform1i(glGetUniformLocation, 1);
        if (this.s != null) {
            GLES20.glUniform4fv(GLES20.glGetUniformLocation(this.f3b, "colorOverlay"), 1, this.s, 0);
        }
        GLES20.glUniformMatrix4fv(GLES20.glGetUniformLocation(this.f3b, "backgroundMatrix"), 1, false, this.w, 0);
        GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f3b, "opacity"), this.t);
        GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f3b, "blendMode"), this.u);
        GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f3b, "blendMix"), this.v);
    }
}
