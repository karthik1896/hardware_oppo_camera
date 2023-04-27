package a.a.b.a;

import a.a.b.a.a.a;
import a.a.b.b.d;
import a.a.b.e.q;
import a.a.b.e.t;
import android.content.res.Resources;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.util.LruCache;
import co.polarr.renderer.entities.Context;

public class az extends a {
    public static LruCache<String, az> n = new LruCache<>(5);
    public float[] o = {0.5f, 0.5f};
    public float p = 42.0f;
    public float[] q = {0.0f, 0.0f, 0.0f};
    public boolean r;

    public az(Resources resources, Context context) {
        super(context, resources);
    }

    public static az a(Resources resources, Context context) {
        az azVar = n.get(Thread.currentThread().getName());
        if (azVar == null) {
            azVar = new az(resources, context);
            azVar.a();
            n.put(Thread.currentThread().getName(), azVar);
        }
        azVar.f2a = context;
        return azVar;
    }

    public static void k() {
        n.evictAll();
    }

    public void a(int i, int i2) {
    }

    public void draw() {
        j();
        i();
        d();
        g();
    }

    public void f() {
        this.f3b = a.c(a.vertexHeader + this.f2a.shaderUtil.a(this.i, t.a("vertex")), this.f2a.shaderUtil.a(this.i, t.a("color_cursor")));
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
        if (this.o != null) {
            GLES20.glUniform2fv(GLES20.glGetUniformLocation(this.f3b, "position"), 1, this.o, 0);
            float c = this.p * q.c(this.f2a);
            Context context = this.f2a;
            d dVar = context.imageTexture;
            float f = context.screen.zoom;
            float[] fArr = {c / (((float) dVar.f12b) * f), c / (((float) dVar.c) * f), 1.0f};
            float[] fArr2 = this.o;
            float[] fArr3 = {fArr2[0] * 2.0f, (-fArr2[1]) * 2.0f, 0.0f};
            Matrix.translateM(this.j, 0, context.overlayMatrix, 0, fArr3[0], fArr3[1], fArr3[2]);
            Matrix.scaleM(this.j, 0, fArr[0], fArr[1], fArr[2]);
            GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f3b, "texel"), 1.0f / c);
            float[] fArr4 = this.q;
            if (fArr4 == null || fArr4.length != 3) {
                GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f3b, "colorMix"), 0.0f);
            } else {
                GLES20.glUniform3fv(GLES20.glGetUniformLocation(this.f3b, "color"), 1, this.q, 0);
                GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f3b, "colorMix"), 1.0f);
            }
        }
        a(this.f2a.dehazeTexture.f11a);
        super.i();
    }
}
