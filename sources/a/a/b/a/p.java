package a.a.b.a;

import a.a.b.a.a.b;
import a.a.b.e.t;
import android.content.res.Resources;
import android.opengl.GLES20;
import android.util.LruCache;
import co.polarr.renderer.entities.Context;
import co.polarr.renderer.entities.Mesh;

public class p extends b {
    public static LruCache<String, p> q = new LruCache<>(5);
    public int r;
    public int s;
    public int t;
    public Mesh u;

    public p(Resources resources, Context context) {
        super(resources, t.a("compute_a"), context);
    }

    public static p a(Resources resources, Context context) {
        p pVar = q.get(Thread.currentThread().getName());
        if (pVar == null) {
            pVar = new p(resources, context);
            pVar.a();
            q.put(Thread.currentThread().getName(), pVar);
        }
        pVar.a(context);
        return pVar;
    }

    public static void l() {
        q.evictAll();
    }

    public void d() {
        int glGetUniformLocation = GLES20.glGetUniformLocation(this.f3b, "mean_I");
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, this.r);
        GLES20.glUniform1i(glGetUniformLocation, 0);
        int glGetUniformLocation2 = GLES20.glGetUniformLocation(this.f3b, "mean_II");
        GLES20.glActiveTexture(33985);
        GLES20.glBindTexture(3553, this.s);
        GLES20.glUniform1i(glGetUniformLocation2, 1);
        int glGetUniformLocation3 = GLES20.glGetUniformLocation(this.f3b, "mean_p");
        GLES20.glActiveTexture(33986);
        GLES20.glBindTexture(3553, this.t);
        GLES20.glUniform1i(glGetUniformLocation3, 2);
    }

    public void g() {
        int i = this.c;
        if (i >= 0) {
            GLES20.glEnableVertexAttribArray(i);
            GLES20.glVertexAttribPointer(this.c, 3, 5126, false, 0, this.u.mVerBuffer);
        }
        int i2 = this.d;
        if (i2 >= 0) {
            GLES20.glEnableVertexAttribArray(i2);
            GLES20.glVertexAttribPointer(this.d, 2, 5126, false, 0, this.u.mTexBuffer);
        }
        int i3 = this.e;
        if (i3 >= 0) {
            GLES20.glEnableVertexAttribArray(i3);
            GLES20.glVertexAttribPointer(this.e, 2, 5126, false, 0, this.u.mDistortionBuffer);
        }
        int i4 = this.f;
        if (i4 >= 0) {
            GLES20.glEnableVertexAttribArray(i4);
            GLES20.glVertexAttribPointer(this.f, 2, 5126, false, 0, this.u.mDeltaBuffer);
        }
        GLES20.glDrawElements(4, this.u.trianglesBuffer.capacity(), 5123, this.u.trianglesBuffer);
        int i5 = this.c;
        if (i5 >= 0) {
            GLES20.glDisableVertexAttribArray(i5);
        }
        int i6 = this.d;
        if (i6 >= 0) {
            GLES20.glDisableVertexAttribArray(i6);
        }
        int i7 = this.e;
        if (i7 >= 0) {
            GLES20.glDisableVertexAttribArray(i7);
        }
        int i8 = this.f;
        if (i8 >= 0) {
            GLES20.glDisableVertexAttribArray(i8);
        }
    }
}
