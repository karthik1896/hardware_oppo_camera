package com.oppo.camera.gl.b;

import android.opengl.GLES20;
import android.opengl.GLES32;
import android.util.Size;
import com.oppo.camera.e;
import com.oppo.camera.gl.s;
import java.nio.FloatBuffer;

/* compiled from: SqureOesDrawer */
public class g extends a implements d {
    private static final float[] k = {-1.0f, 1.0f, 0.0f, 1.0f, -1.0f, -1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, -1.0f, 1.0f, 0.0f};
    private static final float[] l = {0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 1.0f, 0.0f};
    private boolean i = false;
    private int[] j = new int[1];

    public void h_() {
        this.f3274a = a(a(35633, "#version 300 es                                                      \nuniform mat4 mvp_matrix;                                     \nlayout(location = 0) in vec4 a_position;                     \nlayout(location = 1) in vec4 a_texture_coord;                \nout vec2 v_texture_coord;                                    \nvoid main()                                                  \n{                                                            \n    gl_Position = a_position;                                \n    v_texture_coord = (mvp_matrix * a_texture_coord).xy;     \n}                                                            \n"), a(35632, "#version 300 es                                                      \n#extension GL_OES_EGL_image_external_essl3 : require         \nprecision mediump float;                                     \nuniform samplerExternalOES uTextureSampler;                  \nuniform sampler2D uTextureSampler2D;                         \nuniform int uCameraId;                                       \nin vec2 v_texture_coord;                                     \nlayout(location = 0) out vec4 out_color;                     \nvoid main()                                                  \n{                                                            \n    out_color = texture(uTextureSampler, v_texture_coord);   \n}                                                            \n"));
        this.f3275b = a(a(35633, "#version 300 es                                                      \nuniform mat4 mvp_matrix;                                     \nlayout(location = 0) in vec4 a_position;                     \nlayout(location = 1) in vec4 a_texture_coord;                \nout vec2 v_texture_coord;                                    \nvoid main()                                                  \n{                                                            \n    gl_Position = a_position;                                \n    v_texture_coord = (mvp_matrix * a_texture_coord).xy;     \n}                                                            \n"), a(35632, "#version 300 es                                                      \n#extension GL_OES_EGL_image_external_essl3 : require         \nprecision mediump float;                                     \nuniform sampler2D uTextureSampler2D;                         \nin vec2 v_texture_coord;                                     \nlayout(location = 0) out vec4 out_color;                     \nvoid main()                                                  \n{                                                            \n    out_color = texture(uTextureSampler2D, v_texture_coord); \n}                                                            \n"));
        this.c = GLES32.glGetUniformLocation(this.f3274a, "mvp_matrix");
        this.e = GLES32.glGetUniformLocation(this.f3274a, "uTextureSampler");
        a();
        this.d = GLES32.glGetUniformLocation(this.f3275b, "mvp_matrix");
        this.f = GLES32.glGetUniformLocation(this.f3275b, "uTextureSampler2D");
        a();
    }

    public int a(int i2, int i3, Size size, Size size2, int i4, boolean z, boolean z2, h hVar, s sVar) {
        return b(i2, i3, size, size2, i4, z, z2, hVar, sVar);
    }

    public void b() {
        GLES20.glDeleteProgram(this.f3274a);
        this.f3274a = 0;
        this.f3275b = 0;
        this.c = 0;
        this.d = 0;
        this.e = 0;
        this.f = 0;
        int[] iArr = this.j;
        if (iArr[0] > 0) {
            GLES20.glDeleteFramebuffers(iArr.length, iArr, 0);
            this.j[0] = 0;
        }
    }

    public int b(int i2, int i3, Size size, Size size2, int i4, boolean z, boolean z2, h hVar, s sVar) {
        int i5 = i2;
        int i6 = i3;
        int i7 = i4;
        boolean z3 = z;
        boolean z4 = z2;
        FloatBuffer a2 = a(k);
        if (!this.i) {
            e.b("SqureOesDrawer", "multiDrawPreview, createFrameBuffer, subOneCameraTex: " + i5 + ", mainOneCameraTex: " + i6 + ", multiVideoType: " + i7 + ", mainOneCameraFirstDraw: " + z3 + ", isDrawTexture2D: " + z4 + ", DrawMainImageWidth: " + hVar.f() + ", DrawMainImageHeight: " + hVar.g() + ", DrawSubImageWidth: " + hVar.h() + ", DrawSubImageHeight: " + hVar.i() + ", fboHeight: " + hVar.j() + ", fboWidth: " + hVar.k() + ", outRawTexture: " + sVar + ", mainOneCameraSize: " + size2 + ", subOneCameraSize: " + size);
            int[] iArr = this.j;
            if (iArr[0] > 0) {
                GLES20.glDeleteFramebuffers(iArr.length, iArr, 0);
                this.j[0] = 0;
            }
            a(this.j, new int[]{sVar.d()}, hVar.k(), hVar.j());
            this.i = true;
        } else {
            s sVar2 = sVar;
        }
        GLES20.glBindFramebuffer(36160, this.j[0]);
        GLES32.glActiveTexture(33984);
        if (z3) {
            GLES32.glViewport(0, 0, hVar.f(), hVar.g());
            GLES20.glBindBuffer(34962, 0);
            GLES32.glUseProgram(this.f3274a);
            GLES32.glBindTexture(36197, i6);
            GLES32.glUniform1i(this.e, 0);
            GLES32.glUniformMatrix4fv(this.c, 1, false, this.g, 0);
            a();
        } else {
            GLES32.glViewport(0, 0, hVar.h(), hVar.i());
            GLES20.glBindBuffer(34962, 0);
            if (z4) {
                GLES32.glUseProgram(this.f3275b);
                GLES32.glBindTexture(3553, i5);
                GLES32.glUniform1i(this.f, 0);
                GLES32.glUniformMatrix4fv(this.d, 1, false, this.h, 0);
                a();
            } else {
                GLES32.glUseProgram(this.f3274a);
                GLES32.glBindTexture(36197, i5);
                GLES32.glUniform1i(this.e, 0);
                GLES32.glUniformMatrix4fv(this.c, 1, false, this.h, 0);
                a();
            }
        }
        a(a2, 16, i7, true);
        a(hVar, i7, z3);
        if (z3) {
            if (z4) {
                GLES32.glUseProgram(this.f3275b);
                GLES32.glBindTexture(3553, i5);
                GLES32.glUniform1i(this.f, 0);
                GLES32.glUniformMatrix4fv(this.d, 1, false, this.h, 0);
                a();
            } else {
                GLES32.glUseProgram(this.f3274a);
                GLES32.glBindTexture(36197, i5);
                GLES32.glUniform1i(this.e, 0);
                GLES32.glUniformMatrix4fv(this.c, 1, false, this.h, 0);
                a();
            }
            GLES32.glUniformMatrix4fv(this.c, 1, false, this.h, 0);
        } else {
            GLES32.glUseProgram(this.f3274a);
            GLES32.glBindTexture(36197, i6);
            GLES32.glUniform1i(this.e, 0);
            GLES32.glUniformMatrix4fv(this.c, 1, false, this.g, 0);
            a();
        }
        a(a2, 16, i7, false);
        GLES32.glUseProgram(0);
        GLES20.glBindFramebuffer(36160, 0);
        a();
        return sVar.d();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x002d, code lost:
        if (r12 != 2) goto L_0x0040;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(java.nio.FloatBuffer r10, int r11, int r12, boolean r13) {
        /*
            r9 = this;
            r0 = 1
            if (r0 != r12) goto L_0x000b
            if (r13 != 0) goto L_0x000b
            r10 = 200(0xc8, float:2.8E-43)
            java.nio.FloatBuffer r10 = r9.a((int) r10)
        L_0x000b:
            r7 = 0
            r10.position(r7)
            r1 = 0
            r2 = 2
            r3 = 5126(0x1406, float:7.183E-42)
            r4 = 0
            r5 = r11
            r6 = r10
            android.opengl.GLES32.glVertexAttribPointer(r1, r2, r3, r4, r5, r6)
            r8 = 2
            r10.position(r8)
            r1 = 1
            android.opengl.GLES32.glVertexAttribPointer(r1, r2, r3, r4, r5, r6)
            android.opengl.GLES32.glEnableVertexAttribArray(r7)
            android.opengl.GLES32.glEnableVertexAttribArray(r0)
            r10 = 4
            r11 = 5
            if (r12 == 0) goto L_0x003d
            if (r12 == r0) goto L_0x0030
            if (r12 == r8) goto L_0x003d
            goto L_0x0040
        L_0x0030:
            if (r13 == 0) goto L_0x0036
            android.opengl.GLES32.glDrawArrays(r11, r7, r10)
            goto L_0x0040
        L_0x0036:
            r10 = 6
            r11 = 202(0xca, float:2.83E-43)
            android.opengl.GLES32.glDrawArrays(r10, r7, r11)
            goto L_0x0040
        L_0x003d:
            android.opengl.GLES32.glDrawArrays(r11, r7, r10)
        L_0x0040:
            android.opengl.GLES32.glDisableVertexAttribArray(r7)
            android.opengl.GLES32.glDisableVertexAttribArray(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.gl.b.g.a(java.nio.FloatBuffer, int, int, boolean):void");
    }

    public void a(h hVar, int i2, boolean z) {
        int f = hVar.f();
        int g = hVar.g();
        int h = hVar.h();
        int i3 = hVar.i();
        if (i2 == 0) {
            GLES32.glViewport(0, g, f, g);
        } else if (i2 == 1 || i2 == 2) {
            if (z) {
                int i4 = h;
                h = f;
                f = i4;
                int i5 = i3;
                i3 = g;
                g = i5;
            }
            if (-1 == hVar.d() || -1 == hVar.e()) {
                GLES32.glViewport(h - f, i3 - g, f, g);
            } else {
                GLES32.glViewport(hVar.d(), ((-hVar.e()) - g) + i3 + hVar.c(), f, g);
            }
        }
    }

    public void a(boolean z) {
        this.i = z;
    }

    private FloatBuffer a(int i2) {
        float[] fArr = new float[((i2 * 4) + 8)];
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        fArr[2] = 0.5f;
        fArr[3] = 0.5f;
        for (int i3 = 0; i3 <= i2; i3++) {
            double d = ((((double) i3) * 3.141592653589793d) * 2.0d) / ((double) i2);
            float cos = (float) Math.cos(d);
            float sin = (float) Math.sin(d);
            int i4 = i3 * 4;
            fArr[i4 + 4] = cos;
            fArr[i4 + 5] = sin;
            fArr[i4 + 6] = (cos * 0.5f) + 0.5f;
            fArr[i4 + 7] = (sin * 0.5f) + 0.5f;
        }
        return a(fArr);
    }
}
