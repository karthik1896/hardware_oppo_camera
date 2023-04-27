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

public class z extends a {
    public float n = 0.5f;
    public float o = 0.0f;
    public float p = 0.5f;
    public float[] q = {1.0f, 0.0f, 0.0f, 0.0f};
    public boolean r;
    public boolean s;
    public FloatBuffer t;

    public z(Context context, Resources resources) {
        super(context, resources);
        a();
    }

    public void a(int i, int i2) {
    }

    public void a(List<Float> list, boolean z) {
        int i;
        if (list != null && !list.isEmpty()) {
            GLES20.glEnable(3042);
            GLES20.glBlendEquation(32774);
            if (z) {
                if (this.r) {
                    GLES20.glBlendFuncSeparate(0, 771, 0, 771);
                } else {
                    GLES20.glBlendFuncSeparate(ArcSoftOffscreen.ASVL_PAF_RGB32_B8G8R8A8, 771, 1, 771);
                }
            } else if (!this.r || this.s) {
                GLES20.glBlendFunc(1, 769);
            } else {
                GLES20.glBlendFunc(0, 769);
            }
            if (z) {
                synchronized (list) {
                    int size = list.size() * 4;
                    ByteBuffer allocateDirect = ByteBuffer.allocateDirect(size);
                    allocateDirect.order(ByteOrder.nativeOrder());
                    this.t = allocateDirect.asFloatBuffer();
                    int i2 = 0;
                    while (true) {
                        if (i2 >= size) {
                            break;
                        } else if (list.size() <= i2) {
                            break;
                        } else {
                            Float f = list.get(i2);
                            if (!this.f2a.isSDK && i2 % 4 == 1) {
                                f = Float.valueOf(1.0f - f.floatValue());
                            }
                            this.t.put(f.floatValue());
                            i2++;
                        }
                    }
                }
                this.t.position(0);
                GLES20.glVertexAttribPointer(this.d, 4, 5126, false, 0, this.t);
                GLES20.glEnableVertexAttribArray(this.d);
                GLES20.glUseProgram(this.f3b);
                k();
                i = list.size() / 4;
            } else {
                synchronized (list) {
                    int size2 = list.size() * 4;
                    ByteBuffer allocateDirect2 = ByteBuffer.allocateDirect(size2);
                    allocateDirect2.order(ByteOrder.nativeOrder());
                    this.t = allocateDirect2.asFloatBuffer();
                    int i3 = 0;
                    while (true) {
                        if (i3 >= size2) {
                            break;
                        } else if (list.size() <= i3) {
                            break;
                        } else {
                            Float f2 = list.get(i3);
                            if (!this.f2a.isSDK && i3 % 3 == 1) {
                                f2 = Float.valueOf(1.0f - f2.floatValue());
                            }
                            this.t.put(f2.floatValue());
                            i3++;
                        }
                    }
                }
                this.t.position(0);
                GLES20.glVertexAttribPointer(this.d, 3, 5126, false, 0, this.t);
                GLES20.glEnableVertexAttribArray(this.d);
                GLES20.glUseProgram(this.f3b);
                k();
                i = list.size() / 3;
            }
            GLES20.glDrawArrays(0, 0, i);
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
        this.f3b = a.c(a.vertexHeader + this.f2a.shaderUtil.a(this.i, t.a("brush_vertex")), a.fragmentHeader + this.f2a.shaderUtil.a(this.i, t.a("brush")));
        this.d = GLES20.glGetAttribLocation(this.f3b, "coordinates");
    }

    public void i() {
    }

    public void k() {
        GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f3b, "brushSize"), this.n);
        GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f3b, "hardness"), this.o);
        GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f3b, "flow"), this.p);
        GLES20.glUniform4fv(GLES20.glGetUniformLocation(this.f3b, "channelMask"), 1, this.q, 0);
    }
}
