package a.a.b.a;

import a.a.b.a.a.b;
import a.a.b.b.d;
import a.a.b.e.t;
import android.content.res.Resources;
import android.opengl.GLES20;
import android.util.LruCache;
import co.polarr.renderer.entities.Context;

public class e extends b {
    public static LruCache<String, e> q = new LruCache<>(5);
    public float[] r = new float[15];

    public e(Resources resources, Context context) {
        super(resources, t.a("denoise_nlm2"), context);
        a(new String[]{"delta"});
    }

    public static e a(Resources resources, Context context) {
        e eVar = q.get(Thread.currentThread().getName());
        if (eVar == null) {
            eVar = new e(resources, context);
            eVar.a();
            q.put(Thread.currentThread().getName(), eVar);
        }
        eVar.a(context);
        return eVar;
    }

    public static void l() {
        q.evictAll();
    }

    public void i() {
        super.i();
        int glGetUniformLocation = GLES20.glGetUniformLocation(this.f3b, "textureResolution");
        d dVar = this.f2a.imageTexture;
        GLES20.glUniform2f(glGetUniformLocation, (float) dVar.f12b, (float) dVar.c);
        int glGetUniformLocation2 = GLES20.glGetUniformLocation(this.f3b, "kernel[0]");
        float[] fArr = this.r;
        GLES20.glUniform1fv(glGetUniformLocation2, fArr.length, fArr, 0);
    }
}
