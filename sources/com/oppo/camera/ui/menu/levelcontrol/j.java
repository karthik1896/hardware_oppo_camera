package com.oppo.camera.ui.menu.levelcontrol;

import android.content.Context;
import android.opengl.GLES20;
import com.oppo.camera.util.d;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.ArrayList;

/* compiled from: Ring */
public class j {

    /* renamed from: a  reason: collision with root package name */
    private int f4150a;

    /* renamed from: b  reason: collision with root package name */
    private int f4151b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h = 0;
    private String i;
    private String j;
    private ArrayList<FloatBuffer> k = new ArrayList<>();
    private ArrayList<FloatBuffer> l = new ArrayList<>();
    private ArrayList<FloatBuffer> m = new ArrayList<>();

    public j(Context context) {
        a(context);
    }

    public void a() {
        this.k.clear();
        this.l.clear();
        this.m.clear();
    }

    public void a(float f2, float f3, float f4, float f5, float f6) {
        this.h = 6;
        int i2 = this.h;
        float[] fArr = new float[(i2 * 3)];
        float[] fArr2 = new float[(i2 * 2)];
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (i3 < 1) {
            int i6 = i4 + 1;
            float f7 = (float) i3;
            float f8 = (float) 1;
            float f9 = f6 + ((f7 * f2) / f8);
            fArr[i4] = f9;
            int i7 = i6 + 1;
            float f10 = (f5 - f3) / 2.0f;
            fArr[i6] = f10;
            int i8 = i7 + 1;
            fArr[i7] = f4;
            int i9 = i5 + 1;
            float f11 = (f7 * 1.0f) / f8;
            fArr2[i5] = f11;
            int i10 = i9 + 1;
            fArr2[i9] = 1.0f;
            int i11 = i8 + 1;
            i3++;
            float f12 = (float) i3;
            float f13 = f6 + ((f12 * f2) / f8);
            fArr[i8] = f13;
            int i12 = i11 + 1;
            float f14 = (f5 + f3) / 2.0f;
            fArr[i11] = f14;
            int i13 = i12 + 1;
            fArr[i12] = f4;
            int i14 = i10 + 1;
            float f15 = (f12 * 1.0f) / f8;
            fArr2[i10] = f15;
            int i15 = i14 + 1;
            fArr2[i14] = 0.0f;
            int i16 = i13 + 1;
            fArr[i13] = f9;
            int i17 = i16 + 1;
            fArr[i16] = f14;
            int i18 = i17 + 1;
            fArr[i17] = f4;
            int i19 = i15 + 1;
            fArr2[i15] = f11;
            int i20 = i19 + 1;
            fArr2[i19] = 0.0f;
            int i21 = i18 + 1;
            fArr[i18] = f9;
            int i22 = i21 + 1;
            fArr[i21] = f10;
            int i23 = i22 + 1;
            fArr[i22] = f4;
            int i24 = i20 + 1;
            fArr2[i20] = f11;
            int i25 = i24 + 1;
            fArr2[i24] = 1.0f;
            int i26 = i23 + 1;
            fArr[i23] = f13;
            int i27 = i26 + 1;
            fArr[i26] = f10;
            int i28 = i27 + 1;
            fArr[i27] = f4;
            int i29 = i25 + 1;
            fArr2[i25] = f15;
            int i30 = i29 + 1;
            fArr2[i29] = 1.0f;
            int i31 = i28 + 1;
            fArr[i28] = f13;
            int i32 = i31 + 1;
            fArr[i31] = f14;
            i4 = i32 + 1;
            fArr[i32] = f4;
            int i33 = i30 + 1;
            fArr2[i30] = f15;
            i5 = i33 + 1;
            fArr2[i33] = 0.0f;
        }
        float[] fArr3 = new float[fArr.length];
        for (int i34 = 0; i34 < fArr.length; i34++) {
            if (i34 % 3 == 1) {
                fArr3[i34] = 0.0f;
            } else {
                fArr3[i34] = fArr[i34];
            }
        }
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(fArr.length * 4);
        allocateDirect.order(ByteOrder.nativeOrder());
        FloatBuffer asFloatBuffer = allocateDirect.asFloatBuffer();
        asFloatBuffer.put(fArr);
        asFloatBuffer.position(0);
        this.k.add(asFloatBuffer);
        ByteBuffer allocateDirect2 = ByteBuffer.allocateDirect(fArr.length * 4);
        allocateDirect2.order(ByteOrder.nativeOrder());
        FloatBuffer asFloatBuffer2 = allocateDirect2.asFloatBuffer();
        asFloatBuffer2.put(fArr3);
        asFloatBuffer2.position(0);
        this.m.add(asFloatBuffer2);
        ByteBuffer allocateDirect3 = ByteBuffer.allocateDirect(fArr2.length * 4);
        allocateDirect3.order(ByteOrder.nativeOrder());
        FloatBuffer asFloatBuffer3 = allocateDirect3.asFloatBuffer();
        asFloatBuffer3.put(fArr2);
        asFloatBuffer3.position(0);
        this.l.add(asFloatBuffer3);
    }

    private void a(Context context) {
        this.i = d.a("vertex_tex.sh", context.getResources());
        this.j = d.a("frag_tex.sh", context.getResources());
        this.f4150a = d.b(this.i, this.j);
        this.c = GLES20.glGetAttribLocation(this.f4150a, "aPosition");
        this.d = GLES20.glGetAttribLocation(this.f4150a, "aTexCoor");
        this.f4151b = GLES20.glGetUniformLocation(this.f4150a, "uMVPMatrix");
        this.f = GLES20.glGetUniformLocation(this.f4150a, "uCamera");
        this.g = GLES20.glGetUniformLocation(this.f4150a, "uLightLocation");
        this.e = GLES20.glGetUniformLocation(this.f4150a, "uMMatrix");
    }

    public void a(int i2, int i3) {
        int i4 = i3;
        GLES20.glUseProgram(this.f4150a);
        GLES20.glUniformMatrix4fv(this.f4151b, 1, false, i.d(), 0);
        GLES20.glUniformMatrix4fv(this.e, 1, false, i.e(), 0);
        GLES20.glUniform3fv(this.f, 1, i.f());
        GLES20.glUniform3fv(this.g, 1, i.g());
        GLES20.glVertexAttribPointer(this.c, 3, 5126, false, 12, this.k.get(i4));
        GLES20.glVertexAttribPointer(this.d, 2, 5126, false, 8, this.l.get(i4));
        GLES20.glEnableVertexAttribArray(this.c);
        GLES20.glEnableVertexAttribArray(this.d);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, i2);
        GLES20.glDrawArrays(4, 0, this.h);
        GLES20.glDisableVertexAttribArray(this.c);
        GLES20.glDisableVertexAttribArray(this.d);
    }
}
