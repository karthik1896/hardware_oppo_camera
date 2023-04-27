package a.a.b.a;

import a.a.b.a.a.b;
import a.a.b.e.t;
import android.content.res.Resources;
import android.opengl.GLES20;
import android.util.LruCache;
import co.polarr.renderer.entities.Context;
import co.polarr.renderer.entities.Mesh;

public class r extends b {
    public static LruCache<String, r> q = new LruCache<>(5);
    public float[] r;
    public Mesh s;

    public r(Resources resources, Context context) {
        super(resources, t.a("darkchannel_1"), context);
    }

    public static r a(Resources resources, Context context) {
        r rVar = q.get(Thread.currentThread().getName());
        if (rVar == null) {
            rVar = new r(resources, context);
            rVar.a();
            q.put(Thread.currentThread().getName(), rVar);
        }
        rVar.a(context);
        return rVar;
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
        int glGetUniformLocation = GLES20.glGetUniformLocation(this.f3b, "delta");
        float[] fArr = this.r;
        GLES20.glUniform2fv(glGetUniformLocation, fArr.length / 2, fArr, 0);
    }
}
