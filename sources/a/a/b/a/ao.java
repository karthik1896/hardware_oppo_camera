package a.a.b.a;

import a.a.b.a.a.b;
import a.a.b.e.t;
import android.content.res.Resources;
import android.opengl.GLES20;
import android.util.LruCache;
import co.polarr.renderer.entities.Context;
import co.polarr.renderer.entities.Mesh;

public class ao extends b {
    public static LruCache<String, ao> q = new LruCache<>(5);
    public float[] r;
    public Mesh s;

    public ao(Resources resources, Context context) {
        super(resources, t.a("paint_box_blur"), context);
    }

    public static ao a(Resources resources, Context context) {
        ao aoVar = q.get(Thread.currentThread().getName());
        if (aoVar == null) {
            aoVar = new ao(resources, context);
            aoVar.a();
            q.put(Thread.currentThread().getName(), aoVar);
        }
        aoVar.a(context);
        return aoVar;
    }

    public static void l() {
        q.evictAll();
    }

    public void g() {
        int i = this.c;
        if (i >= 0) {
            GLES20.glEnableVertexAttribArray(i);
            GLES20.glVertexAttribPointer(this.c, 3, 5126, false, 0, this.s.mVerBuffer);
        }
        int i2 = this.d;
        if (i2 >= 0) {
            GLES20.glEnableVertexAttribArray(i2);
            GLES20.glVertexAttribPointer(this.d, 2, 5126, false, 0, this.s.mTexBuffer);
        }
        int i3 = this.e;
        if (i3 >= 0) {
            GLES20.glEnableVertexAttribArray(i3);
            GLES20.glVertexAttribPointer(this.e, 2, 5126, false, 0, this.s.mDistortionBuffer);
        }
        int i4 = this.f;
        if (i4 >= 0) {
            GLES20.glEnableVertexAttribArray(i4);
            GLES20.glVertexAttribPointer(this.f, 2, 5126, false, 0, this.s.mDeltaBuffer);
        }
        GLES20.glDrawElements(4, this.s.trianglesBuffer.capacity(), 5123, this.s.trianglesBuffer);
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

    public void i() {
        super.i();
        GLES20.glUniform2fv(GLES20.glGetUniformLocation(this.f3b, "delta"), 1, this.r, 0);
    }
}
