package a.a.b.a;

import a.a.b.a.a.b;
import a.a.b.e.t;
import android.content.res.Resources;
import android.opengl.GLES20;
import android.util.LruCache;
import co.polarr.renderer.entities.Context;
import co.polarr.renderer.entities.Mesh;

public class aj extends b {
    public static LruCache<String, aj> q = new LruCache<>(5);
    public Mesh r;

    public aj(Resources resources, Context context) {
        super(resources, t.a("mul"), context);
    }

    public static aj a(Resources resources, Context context) {
        aj ajVar = q.get(Thread.currentThread().getName());
        if (ajVar == null) {
            ajVar = new aj(resources, context);
            ajVar.a();
            q.put(Thread.currentThread().getName(), ajVar);
        }
        ajVar.a(context);
        return ajVar;
    }

    public static void l() {
        q.evictAll();
    }

    public void g() {
        int i = this.c;
        if (i >= 0) {
            GLES20.glEnableVertexAttribArray(i);
            GLES20.glVertexAttribPointer(this.c, 3, 5126, false, 0, this.r.mVerBuffer);
        }
        int i2 = this.d;
        if (i2 >= 0) {
            GLES20.glEnableVertexAttribArray(i2);
            GLES20.glVertexAttribPointer(this.d, 2, 5126, false, 0, this.r.mTexBuffer);
        }
        int i3 = this.e;
        if (i3 >= 0) {
            GLES20.glEnableVertexAttribArray(i3);
            GLES20.glVertexAttribPointer(this.e, 2, 5126, false, 0, this.r.mDistortionBuffer);
        }
        int i4 = this.f;
        if (i4 >= 0) {
            GLES20.glEnableVertexAttribArray(i4);
            GLES20.glVertexAttribPointer(this.f, 2, 5126, false, 0, this.r.mDeltaBuffer);
        }
        GLES20.glDrawElements(4, this.r.trianglesBuffer.capacity(), 5123, this.r.trianglesBuffer);
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
