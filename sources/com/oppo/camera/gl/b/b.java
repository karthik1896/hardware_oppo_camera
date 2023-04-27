package com.oppo.camera.gl.b;

import android.opengl.GLES20;
import android.opengl.GLES32;
import android.util.Size;
import java.nio.FloatBuffer;

/* compiled from: FboDrawer */
public class b extends a implements c {
    private static final float[] i = {-1.0f, -1.0f, -1.0f, 1.0f, 1.0f, -1.0f, 1.0f, 1.0f};
    private static final float[] j = {0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f};
    private int k = 0;
    private int l = 0;

    public void b() {
        this.k = a(a(35633, "#version 300 es                                                      \nlayout(location = 0) in vec4 a_position;                     \nlayout(location = 1) in vec4 a_texture_coord;                \nout vec2 v_texture_coord;                                    \nvoid main()                                                  \n{                                                            \n    gl_Position = a_position;                                \n    v_texture_coord = a_texture_coord.xy;                    \n}                                                            \n"), a(35632, "#version 300 es                                                      \nprecision mediump float;                                     \nuniform sampler2D uTextureSampler;                           \nin vec2 v_texture_coord;                                     \nlayout(location = 0) out vec4 out_color;                     \nvoid main()                                                  \n{                                                            \n    out_color = texture(uTextureSampler, v_texture_coord);   \n}\n"));
        this.l = GLES32.glGetUniformLocation(this.k, "uTextureSampler");
    }

    public int a(int i2, int i3, int i4, Size size, Size size2, int i5, boolean z, h hVar) {
        int a2 = hVar.a();
        int j2 = hVar.j();
        int b2 = (hVar.b() - hVar.j()) - hVar.c();
        GLES32.glUseProgram(this.k);
        GLES32.glActiveTexture(33984);
        GLES32.glViewport(0, b2, a2, j2);
        int i6 = i2;
        GLES32.glBindTexture(3553, i2);
        GLES32.glUniform1i(this.l, 0);
        a();
        FloatBuffer a3 = a(i);
        FloatBuffer a4 = a(j);
        a3.position(0);
        a4.position(0);
        GLES32.glVertexAttribPointer(0, 2, 5126, false, 0, a3);
        GLES32.glVertexAttribPointer(1, 2, 5126, false, 0, a4);
        GLES32.glEnableVertexAttribArray(0);
        GLES32.glEnableVertexAttribArray(1);
        GLES32.glDrawArrays(5, 0, 4);
        a();
        GLES32.glDisableVertexAttribArray(0);
        GLES32.glDisableVertexAttribArray(1);
        GLES32.glBindTexture(3553, 0);
        GLES32.glUseProgram(0);
        a();
        return 0;
    }

    public void c() {
        GLES20.glDeleteProgram(this.k);
        this.k = 0;
        this.c = 0;
        this.e = 0;
        this.l = 0;
    }
}
