package a.a.b.a;

import a.a.b.a.a.a;
import a.a.b.e.t;
import android.content.res.Resources;
import android.opengl.GLES20;
import co.polarr.renderer.entities.Context;
import com.arcsoft.arcsoftjni.ArcSoftOffscreen;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.List;

public class ax extends a {
    public float n = 0.5f;
    public float o = 0.5f;
    public int p;

    public ax(Context context, Resources resources) {
        super(context, resources);
        a();
    }

    public void a(int i, int i2) {
    }

    public void a(List<Float> list) {
        FloatBuffer asFloatBuffer;
        if (list != null) {
            synchronized (list) {
                int size = list.size() * 4;
                ByteBuffer allocateDirect = ByteBuffer.allocateDirect(size);
                allocateDirect.order(ByteOrder.nativeOrder());
                asFloatBuffer = allocateDirect.asFloatBuffer();
                int i = 0;
                while (true) {
                    if (i >= size) {
                        break;
                    } else if (list.size() <= i) {
                        break;
                    } else {
                        Float f = list.get(i);
                        if (!this.f2a.isSDK && i % 4 == 1) {
                            f = Float.valueOf(1.0f - f.floatValue());
                        }
                        asFloatBuffer.put(f.floatValue());
                        i++;
                    }
                }
            }
            asFloatBuffer.position(0);
            GLES20.glEnable(3042);
            GLES20.glBlendEquation(32774);
            GLES20.glBlendFuncSeparate(ArcSoftOffscreen.ASVL_PAF_RGB32_B8G8R8A8, 771, 1, 771);
            GLES20.glVertexAttribPointer(this.d, 4, 5126, false, 0, asFloatBuffer);
            GLES20.glEnableVertexAttribArray(this.d);
            GLES20.glUseProgram(this.f3b);
            k();
            GLES20.glDrawArrays(0, 0, list.size() / 4);
            GLES20.glDisableVertexAttribArray(this.d);
            GLES20.glDisable(3042);
        }
    }

    public void c() {
    }

    public void draw() {
    }

    public void e() {
    }

    public void f() {
        this.f3b = a.c(a.vertexHeader + this.f2a.shaderUtil.a(this.i, t.a("paint_vertex")), a.fragmentHeader + this.f2a.shaderUtil.a(this.i, t.a("paint")));
        this.d = GLES20.glGetAttribLocation(this.f3b, "coordinates");
    }

    public void i() {
    }

    public final void k() {
        int glGetUniformLocation = GLES20.glGetUniformLocation(this.f3b, "brushMap");
        GLES20.glActiveTexture(33988);
        GLES20.glBindTexture(3553, this.p);
        GLES20.glUniform1i(glGetUniformLocation, 4);
        int glGetUniformLocation2 = GLES20.glGetUniformLocation(this.f3b, "image");
        GLES20.glActiveTexture(33989);
        GLES20.glBindTexture(3553, this.f2a.denoiseTexture.f11a);
        GLES20.glUniform1i(glGetUniformLocation2, 5);
        GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f3b, "brushSize"), this.n);
        GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f3b, "flow"), this.o);
    }
}
