package a.a.b.a;

import a.a.b.a.a.b;
import a.a.b.b.d;
import a.a.b.e.t;
import a.a.b.f;
import android.content.res.Resources;
import android.opengl.GLES20;
import android.util.LruCache;
import co.polarr.renderer.entities.Context;

public class m extends b {
    public static LruCache<String, m> q = new LruCache<>(5);

    public m(Resources resources, Context context) {
        super(resources, t.a("out"), context);
        this.o = t.a("distortion_vertex");
    }

    public static m a(Resources resources, Context context) {
        m mVar = q.get(Thread.currentThread().getName());
        if (mVar == null) {
            mVar = new m(resources, context);
            mVar.a();
            q.put(Thread.currentThread().getName(), mVar);
        }
        mVar.a(context);
        return mVar;
    }

    public static void l() {
        q.evictAll();
    }

    public void i() {
        super.i();
        int glGetUniformLocation = GLES20.glGetUniformLocation(this.f3b, "original");
        GLES20.glActiveTexture(33985);
        GLES20.glBindTexture(3553, this.f2a.imageTexture.f11a);
        GLES20.glUniform1i(glGetUniformLocation, 1);
        GLES20.glUniformMatrix4fv(GLES20.glGetUniformLocation(this.f3b, "viewMatrix"), 1, false, this.f2a.matrix, 0);
        GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f3b, "distortion_amount"), ((Float) f.a("distortion_amount", this.f2a.renderStates)).floatValue());
        GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f3b, "distortion_horizontal"), ((Float) f.a("distortion_horizontal", this.f2a.renderStates)).floatValue());
        GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f3b, "distortion_vertical"), ((Float) f.a("distortion_vertical", this.f2a.renderStates)).floatValue());
        int glGetUniformLocation2 = GLES20.glGetUniformLocation(this.f3b, "imgSize");
        d dVar = this.f2a.imageTexture;
        GLES20.glUniform2f(glGetUniformLocation2, (float) dVar.f12b, (float) dVar.c);
    }
}
