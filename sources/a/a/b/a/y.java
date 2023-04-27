package a.a.b.a;

import a.a.b.a.a.b;
import a.a.b.b.d;
import a.a.b.e.t;
import android.content.res.Resources;
import android.opengl.GLES20;
import android.util.LruCache;
import co.polarr.renderer.entities.Context;

public class y extends b {
    public static LruCache<String, y> q = new LruCache<>(5);

    public y(Resources resources, Context context) {
        super(resources, t.a("distortion"), context);
        this.o = t.a("fringing_vertex");
        a(new String[]{"distortion_amount", "fringing", "distortion_horizontal", "distortion_vertical"});
    }

    public static y a(Resources resources, Context context) {
        y yVar = q.get(Thread.currentThread().getName());
        if (yVar == null) {
            yVar = new y(resources, context);
            yVar.a();
            q.put(Thread.currentThread().getName(), yVar);
        }
        yVar.a(context);
        return yVar;
    }

    public static void l() {
        q.evictAll();
    }

    public void i() {
        super.i();
        int glGetUniformLocation = GLES20.glGetUniformLocation(this.f3b, "imgSize");
        d dVar = this.f2a.imageTexture;
        GLES20.glUniform2f(glGetUniformLocation, (float) dVar.f12b, (float) dVar.c);
    }

    public boolean k() {
        return false;
    }
}
