package com.oppo.camera.ui.menu.b;

import android.content.Context;
import android.opengl.GLES20;
import com.oppo.camera.e;
import com.oppo.camera.util.d;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/* compiled from: HeadlineDrawer */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private int f4069a = -1;

    /* renamed from: b  reason: collision with root package name */
    private int f4070b = -1;
    private int c = -1;
    private int d = -1;
    private int e = -1;
    private Context f = null;
    private int g = -1;
    private int h = -1;
    private int i = -1;
    private int j = -1;
    private int k = -1;
    private int l = -1;
    private FloatBuffer m = null;
    private FloatBuffer n = null;
    private int o = 0;
    private float p = 1.0f;
    private float q = 0.0f;
    private float r = 0.0f;
    private float s = 0.0f;
    private float t = 0.0f;
    private float u = 0.0f;
    private float v = 0.0f;
    private float w = 0.0f;
    private float x = 0.0f;

    public b(Context context, float f2, float f3) {
        this.f = context;
        this.q = f2;
        this.r = f3;
    }

    public void a() {
        e.a("HeadlineDrawer", "initialize");
        a a2 = a((double) this.q, this.r, 126.0f, 20);
        this.m = a2.f4071a;
        this.o = this.m.remaining() / 3;
        this.n = a2.f4072b;
        this.f4069a = d.b(d.a("headline_vertex.sh", this.f.getResources()), d.a("headline_frag.sh", this.f.getResources()));
        this.c = GLES20.glGetAttribLocation(this.f4069a, "aPosition");
        this.f4070b = GLES20.glGetUniformLocation(this.f4069a, "uMVPMatrix");
        this.d = GLES20.glGetAttribLocation(this.f4069a, "aTexCoor");
        this.e = GLES20.glGetUniformLocation(this.f4069a, "uAlpha");
        this.g = GLES20.glGetUniformLocation(this.f4069a, "uPreviousStart");
        this.h = GLES20.glGetUniformLocation(this.f4069a, "uPreviousEnd");
        this.i = GLES20.glGetUniformLocation(this.f4069a, "uPreviousRatio");
        this.j = GLES20.glGetUniformLocation(this.f4069a, "uNextStart");
        this.k = GLES20.glGetUniformLocation(this.f4069a, "uNextEnd");
        this.l = GLES20.glGetUniformLocation(this.f4069a, "uNextRatio");
    }

    /* compiled from: HeadlineDrawer */
    private static class a {

        /* renamed from: a  reason: collision with root package name */
        public FloatBuffer f4071a;

        /* renamed from: b  reason: collision with root package name */
        public FloatBuffer f4072b;

        private a() {
            this.f4071a = null;
            this.f4072b = null;
        }
    }

    private a a(double d2, float f2, float f3, int i2) {
        float f4 = f3;
        float f5 = (float) i2;
        float f6 = 360.0f / f5;
        int i3 = (int) (((f5 * 6.0f) * f4) / 360.0f);
        float[] fArr = new float[(i3 * 3)];
        float[] fArr2 = new float[(i3 * 2)];
        double d3 = (double) f4;
        double radians = Math.toRadians(d3);
        float f7 = 0.0f;
        int i4 = 0;
        int i5 = 0;
        while (true) {
            double d4 = (double) f7;
            if (Math.ceil(d4) < d3) {
                double radians2 = Math.toRadians(d4);
                float f8 = f7 + f6;
                double radians3 = Math.toRadians((double) f8);
                int i6 = i4 + 1;
                float[] fArr3 = fArr2;
                double d5 = -d2;
                fArr[i4] = (float) (d5 * Math.sin(radians2));
                int i7 = i6 + 1;
                fArr[i6] = 0.0f;
                int i8 = i7 + 1;
                float f9 = f6;
                double d6 = d3;
                fArr[i7] = (float) (d5 * Math.cos(radians2));
                int i9 = i5 + 1;
                float f10 = (float) (1.0d - (radians2 / radians));
                fArr3[i5] = f10;
                int i10 = i9 + 1;
                fArr3[i9] = 1.0f;
                int i11 = i8 + 1;
                double d7 = radians;
                fArr[i8] = (float) (d5 * Math.sin(radians3));
                int i12 = i11 + 1;
                fArr[i11] = f2;
                int i13 = i12 + 1;
                fArr[i12] = (float) (Math.cos(radians3) * d5);
                int i14 = i10 + 1;
                float f11 = (float) (1.0d - (radians3 / d7));
                fArr3[i10] = f11;
                int i15 = i14 + 1;
                fArr3[i14] = 0.0f;
                int i16 = i13 + 1;
                fArr[i13] = (float) (d5 * Math.sin(radians2));
                int i17 = i16 + 1;
                fArr[i16] = f2;
                int i18 = i17 + 1;
                fArr[i17] = (float) (Math.cos(radians2) * d5);
                int i19 = i15 + 1;
                fArr3[i15] = f10;
                int i20 = i19 + 1;
                fArr3[i19] = 0.0f;
                int i21 = i18 + 1;
                fArr[i18] = (float) (d5 * Math.sin(radians2));
                int i22 = i21 + 1;
                fArr[i21] = 0.0f;
                int i23 = i22 + 1;
                fArr[i22] = (float) (Math.cos(radians2) * d5);
                int i24 = i20 + 1;
                fArr3[i20] = f10;
                int i25 = i24 + 1;
                fArr3[i24] = 1.0f;
                int i26 = i23 + 1;
                fArr[i23] = (float) (Math.sin(radians3) * d5);
                int i27 = i26 + 1;
                fArr[i26] = 0.0f;
                int i28 = i27 + 1;
                fArr[i27] = (float) (Math.cos(radians3) * d5);
                int i29 = i25 + 1;
                fArr3[i25] = f11;
                int i30 = i29 + 1;
                fArr3[i29] = 1.0f;
                int i31 = i28 + 1;
                fArr[i28] = (float) (Math.sin(radians3) * d5);
                int i32 = i31 + 1;
                fArr[i31] = f2;
                int i33 = i32 + 1;
                fArr[i32] = (float) (d5 * Math.cos(radians3));
                int i34 = i30 + 1;
                fArr3[i30] = f11;
                i5 = i34 + 1;
                fArr3[i34] = 0.0f;
                fArr2 = fArr3;
                f6 = f9;
                f7 = f8;
                d3 = d6;
                radians = d7;
                i4 = i33;
            } else {
                ByteBuffer allocateDirect = ByteBuffer.allocateDirect(fArr.length * 4);
                allocateDirect.order(ByteOrder.nativeOrder());
                FloatBuffer asFloatBuffer = allocateDirect.asFloatBuffer();
                asFloatBuffer.put(fArr);
                asFloatBuffer.position(0);
                float[] fArr4 = fArr2;
                ByteBuffer allocateDirect2 = ByteBuffer.allocateDirect(fArr4.length * 4);
                allocateDirect2.order(ByteOrder.nativeOrder());
                FloatBuffer asFloatBuffer2 = allocateDirect2.asFloatBuffer();
                asFloatBuffer2.put(fArr4);
                asFloatBuffer2.position(0);
                a aVar = new a();
                aVar.f4071a = asFloatBuffer;
                aVar.f4072b = asFloatBuffer2;
                return aVar;
            }
        }
    }

    public void a(float f2) {
        e.a("HeadlineDrawer", "setAlpha, alpha: " + f2);
        this.p = f2;
    }

    public void a(float f2, float f3) {
        e.a("HeadlineDrawer", "setPreviousTabLocation, start: " + f2 + ", end: " + f3);
        this.s = f2;
        this.t = f3;
    }

    public void b(float f2) {
        e.a("HeadlineDrawer", "setPreviousAnimationRatio, ratio: " + f2);
        this.u = f2;
    }

    public void b(float f2, float f3) {
        e.a("HeadlineDrawer", "setNextTabLocation, start: " + f2 + ", end: " + f3);
        this.v = f2;
        this.w = f3;
    }

    public void c(float f2) {
        e.a("HeadlineDrawer", "setNextAnimationRatio, ratio: " + f2);
        this.x = f2;
    }

    public void a(int i2, float[] fArr) {
        GLES20.glUseProgram(this.f4069a);
        GLES20.glUniform1f(this.e, this.p);
        GLES20.glUniform1f(this.g, this.s);
        GLES20.glUniform1f(this.h, this.t);
        GLES20.glUniform1f(this.i, this.u);
        GLES20.glUniform1f(this.j, this.v);
        GLES20.glUniform1f(this.k, this.w);
        GLES20.glUniform1f(this.l, this.x);
        GLES20.glUniformMatrix4fv(this.f4070b, 1, false, fArr, 0);
        GLES20.glVertexAttribPointer(this.c, 3, 5126, false, 12, this.m);
        GLES20.glVertexAttribPointer(this.d, 2, 5126, false, 8, this.n);
        GLES20.glEnableVertexAttribArray(this.c);
        GLES20.glEnableVertexAttribArray(this.d);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, i2);
        GLES20.glDrawArrays(4, 0, this.o);
    }
}
