package a.a.b.a;

import a.a.b.a.a.a;
import a.a.b.e.t;
import android.content.res.Resources;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.util.LruCache;
import co.polarr.renderer.entities.Context;

public class ai extends a {
    public static LruCache<String, ai> n = new LruCache<>(5);
    public float[] o;
    public float[] p;
    public float[] q;
    public float r;
    public float s = 0.0f;
    public float t = 0.5f;
    public boolean u;

    public ai(Resources resources, Context context) {
        super(context, resources);
    }

    public static ai a(Resources resources, Context context) {
        ai aiVar = n.get(Thread.currentThread().getName());
        if (aiVar == null) {
            aiVar = new ai(resources, context);
            aiVar.a();
            n.put(Thread.currentThread().getName(), aiVar);
        }
        aiVar.f2a = context;
        return aiVar;
    }

    public static void k() {
        n.evictAll();
    }

    public void a(int i, int i2) {
    }

    public void draw() {
        j();
        i();
        g();
    }

    public void f() {
        this.f3b = a.c(a.vertexHeader + this.f2a.shaderUtil.a(this.i, t.a("vertex")), this.f2a.shaderUtil.a(this.i, t.a("brush_cursor")));
        this.c = GLES20.glGetAttribLocation(this.f3b, "a_Vertex");
        this.d = GLES20.glGetAttribLocation(this.f3b, "a_TexCoord");
        this.e = GLES20.glGetAttribLocation(this.f3b, "a_Distortion");
        this.f = GLES20.glGetAttribLocation(this.f3b, "a_Delta");
        this.g = GLES20.glGetUniformLocation(this.f3b, "u_ModelViewProjectionMatrix");
        this.h = GLES20.glGetUniformLocation(this.f3b, "texture");
    }

    public void g() {
        int i = this.c;
        if (i >= 0) {
            GLES20.glEnableVertexAttribArray(i);
            GLES20.glVertexAttribPointer(this.c, 3, 5126, false, 0, Context.overlayMesh.mVerBuffer);
        }
        int i2 = this.d;
        if (i2 >= 0) {
            GLES20.glEnableVertexAttribArray(i2);
            GLES20.glVertexAttribPointer(this.d, 2, 5126, false, 0, Context.overlayMesh.mTexBuffer);
        }
        int i3 = this.e;
        if (i3 >= 0) {
            GLES20.glEnableVertexAttribArray(i3);
            GLES20.glVertexAttribPointer(this.e, 2, 5126, false, 0, Context.overlayMesh.mDistortionBuffer);
        }
        int i4 = this.f;
        if (i4 >= 0) {
            GLES20.glEnableVertexAttribArray(i4);
            GLES20.glVertexAttribPointer(this.f, 2, 5126, false, 0, Context.overlayMesh.mDeltaBuffer);
        }
        GLES20.glDrawElements(4, Context.overlayMesh.trianglesBuffer.capacity(), 5123, Context.overlayMesh.trianglesBuffer);
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
        if (this.o == null) {
            this.o = new float[]{0.0f, 0.0f, 0.0f};
        }
        float min = Math.min(1.0f, this.o[2] * 2.0f);
        float[] fArr = this.j;
        float[] fArr2 = this.f2a.overlayMatrix;
        float[] fArr3 = this.q;
        Matrix.translateM(fArr, 0, fArr2, 0, fArr3[0], fArr3[1], fArr3[2]);
        float[] fArr4 = this.j;
        float[] fArr5 = this.p;
        Matrix.scaleM(fArr4, 0, fArr5[0], fArr5[1], fArr5[2]);
        GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f3b, "pressure"), min);
        GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f3b, "hardness"), this.s);
        GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f3b, "flow"), this.t);
        super.i();
    }
}
