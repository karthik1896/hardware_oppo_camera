package com.oppo.camera.ui.menu.levelcontrol;

import android.content.Context;
import android.opengl.GLES20;
import co.polarr.renderer.entities.DrawingItem;
import com.arcsoft.arcsoftjni.ArcSoftOffscreen;
import com.oppo.camera.aps.config.CameraConfig;
import com.oppo.camera.aps.config.ConfigDataBase;
import com.oppo.camera.e;
import com.oppo.camera.gl.i;
import com.oppo.camera.ui.preview.a.a;
import com.oppo.camera.ui.preview.a.b;
import com.oppo.camera.ui.preview.a.h;
import com.oppo.camera.ui.preview.a.m;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.List;

/* compiled from: CylinderSide */
public class d {
    private ArrayList<FloatBuffer> A = new ArrayList<>();
    private ArrayList<FloatBuffer> B = new ArrayList<>();
    private ArrayList<Integer> C = new ArrayList<>();
    private m D = null;
    private b E = null;
    private h.a F = h.a.Polarr;
    private int[] G = new int[1];

    /* renamed from: a  reason: collision with root package name */
    private int f4137a = 0;

    /* renamed from: b  reason: collision with root package name */
    private int f4138b = 0;
    private int c = 0;
    private int d = 0;
    private int e = 0;
    private int f = 0;
    private int g = 0;
    private String h = null;
    private String i = null;
    private int j = 0;
    private int k = 0;
    private int l = 0;
    private int m = 0;
    private int n = 0;
    private int o = 0;
    private int p = 0;
    private String q = null;
    private String r = null;
    private int s = 0;
    private int t = 0;
    private float u = 0.0f;
    private int v = 0;
    private boolean w = false;
    private FloatBuffer x = null;
    private FloatBuffer y = null;
    private ArrayList<FloatBuffer> z = new ArrayList<>();

    private float a(double d2, double d3, double d4, boolean z2) {
        return (float) (z2 ? ((d2 - d3) / 2.0d) + d4 : ((d2 + d3) / 2.0d) - d4);
    }

    public d(Context context) {
        b(context);
        c(context);
        this.D = new m();
        this.E = new b();
    }

    private a f() {
        if (h.a.Polarr == this.F) {
            return this.D;
        }
        return this.E;
    }

    public void a(h.a aVar) {
        this.F = aVar;
    }

    public void a(int i2, int i3) {
        this.s = i2;
        this.t = i3;
    }

    public void a(float f2) {
        this.u = f2;
    }

    public void a() {
        ArrayList<Integer> arrayList = this.C;
        if (arrayList != null) {
            arrayList.clear();
        }
        ArrayList<FloatBuffer> arrayList2 = this.z;
        if (arrayList2 != null) {
            arrayList2.clear();
        }
        ArrayList<FloatBuffer> arrayList3 = this.A;
        if (arrayList3 != null) {
            arrayList3.clear();
        }
        ArrayList<FloatBuffer> arrayList4 = this.B;
        if (arrayList4 != null) {
            arrayList4.clear();
        }
    }

    public int b() {
        ArrayList<FloatBuffer> arrayList = this.z;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    public void a(float f2, float f3, float f4, int i2, float f5, float f6, boolean z2, f fVar) {
        float[] fArr;
        d dVar = this;
        int i3 = i2;
        int ceil = (int) Math.ceil((double) (((float) (i3 * 3 * 2)) * (f6 / 360.0f)));
        boolean k2 = fVar.k();
        boolean l2 = fVar.l();
        boolean r2 = fVar.r();
        int f7 = fVar.f();
        int g2 = fVar.g();
        float f8 = f2 * f3;
        float f9 = f2 * f4;
        int i4 = ceil * 3;
        float[] fArr2 = new float[i4];
        float[] fArr3 = new float[(ceil * 2)];
        float f10 = 360.0f / ((float) i3);
        double c2 = (double) h.c();
        double d2 = 0.0d;
        if (z2) {
            d2 = -1.0d;
        }
        float f11 = f5;
        double d3 = d2;
        double d4 = d2;
        int i5 = 0;
        int i6 = 0;
        while (true) {
            float f12 = f5 + f6;
            if (f11 >= f12 || i5 + 18 >= i4) {
                float[] fArr4 = fArr3;
                int i7 = ceil;
                float[] fArr5 = fArr2;
                float[] fArr6 = new float[fArr5.length];
            } else {
                double d5 = c2;
                double radians = Math.toRadians((double) f11);
                if (i5 + 36 < i4) {
                    f12 = f11 + f10;
                }
                double radians2 = Math.toRadians((double) (f12 % 360.0f));
                if (z2) {
                    if (-1.0d == d4) {
                        d3 = dVar.a((double) ((f11 - f5) / f6));
                    }
                    d4 = d3;
                    d3 = dVar.a((double) (((f11 + f10) - f5) / f6));
                }
                int i8 = i5 + 1;
                double d6 = (double) f8;
                int i9 = i4;
                fArr2[i5] = (float) (d6 * Math.sin(radians));
                int i10 = i8 + 1;
                double d7 = (double) f9;
                double d8 = d5;
                double d9 = d6;
                float f13 = f9;
                double d10 = d7;
                float f14 = f8;
                float[] fArr7 = fArr2;
                fArr7[i8] = a(d7, d8, d4, true);
                int i11 = i10 + 1;
                fArr7[i10] = (float) (d9 * Math.cos(radians));
                int i12 = i6 + 1;
                float f15 = (f11 - f5) / f6;
                float[] fArr8 = fArr3;
                fArr8[i6] = f15;
                int i13 = i12 + 1;
                int i14 = ceil;
                float[] fArr9 = fArr7;
                float[] fArr10 = fArr8;
                fArr10[i12] = a(1.0d, 1.0d, d4, false);
                if (r2) {
                    fArr = fArr10;
                    a(fArr10, i13 - 1, k2, l2, z2, f7, g2);
                } else {
                    fArr = fArr10;
                }
                int i15 = i11 + 1;
                fArr9[i11] = (float) (d9 * Math.sin(radians2));
                int i16 = i15 + 1;
                double d11 = d3;
                fArr9[i15] = a(d10, d8, d11, false);
                int i17 = i16 + 1;
                fArr9[i16] = (float) (d9 * Math.cos(radians2));
                int i18 = i13 + 1;
                f11 += f10;
                float f16 = (f11 - f5) / f6;
                fArr[i13] = f16;
                int i19 = i18 + 1;
                fArr[i18] = a(1.0d, 1.0d, d11, true);
                if (r2) {
                    a(fArr, i19 - 1, k2, l2, z2, f7, g2);
                }
                int i20 = i17 + 1;
                fArr9[i17] = (float) (d9 * Math.sin(radians));
                int i21 = i20 + 1;
                double d12 = d4;
                fArr9[i20] = a(d10, d8, d12, false);
                int i22 = i21 + 1;
                fArr9[i21] = (float) (d9 * Math.cos(radians));
                int i23 = i19 + 1;
                fArr[i19] = f15;
                int i24 = i23 + 1;
                fArr[i23] = a(1.0d, 1.0d, d12, true);
                if (r2) {
                    a(fArr, i24 - 1, k2, l2, z2, f7, g2);
                }
                int i25 = i22 + 1;
                fArr9[i22] = (float) (d9 * Math.sin(radians));
                int i26 = i25 + 1;
                double d13 = d4;
                fArr9[i25] = a(d10, d8, d13, true);
                int i27 = i26 + 1;
                fArr9[i26] = (float) (d9 * Math.cos(radians));
                int i28 = i24 + 1;
                fArr[i24] = f15;
                int i29 = i28 + 1;
                fArr[i28] = a(1.0d, 1.0d, d13, false);
                if (r2) {
                    a(fArr, i29 - 1, k2, l2, z2, f7, g2);
                }
                int i30 = i27 + 1;
                fArr9[i27] = (float) (d9 * Math.sin(radians2));
                int i31 = i30 + 1;
                double d14 = d3;
                fArr9[i30] = a(d10, d8, d14, true);
                int i32 = i31 + 1;
                fArr9[i31] = (float) (d9 * Math.cos(radians2));
                int i33 = i29 + 1;
                fArr[i29] = f16;
                int i34 = i33 + 1;
                fArr[i33] = a(1.0d, 1.0d, d14, false);
                if (r2) {
                    a(fArr, i34 - 1, k2, l2, z2, f7, g2);
                }
                int i35 = i32 + 1;
                fArr9[i32] = (float) (d9 * Math.sin(radians2));
                int i36 = i35 + 1;
                double d15 = d3;
                fArr9[i35] = a(d10, d8, d15, false);
                i5 = i36 + 1;
                fArr9[i36] = (float) (d9 * Math.cos(radians2));
                int i37 = i34 + 1;
                fArr[i34] = f16;
                i6 = i37 + 1;
                fArr[i37] = a(1.0d, 1.0d, d15, true);
                if (r2) {
                    a(fArr, i6 - 1, k2, l2, z2, f7, g2);
                }
                fArr3 = fArr;
                fArr2 = fArr9;
                f9 = f13;
                i4 = i9;
                c2 = d8;
                ceil = i14;
                f8 = f14;
                dVar = this;
            }
        }
        float[] fArr42 = fArr3;
        int i72 = ceil;
        float[] fArr52 = fArr2;
        float[] fArr62 = new float[fArr52.length];
        for (int i38 = 0; i38 < fArr52.length; i38++) {
            if (i38 % 3 == 1) {
                fArr62[i38] = 0.0f;
            } else {
                fArr62[i38] = fArr52[i38];
            }
        }
        float[] fArr11 = fArr42;
        this.C.add(Integer.valueOf(i72));
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(fArr52.length * 4);
        allocateDirect.order(ByteOrder.nativeOrder());
        FloatBuffer asFloatBuffer = allocateDirect.asFloatBuffer();
        asFloatBuffer.put(fArr52);
        asFloatBuffer.position(0);
        this.z.add(asFloatBuffer);
        ByteBuffer allocateDirect2 = ByteBuffer.allocateDirect(fArr52.length * 4);
        allocateDirect2.order(ByteOrder.nativeOrder());
        FloatBuffer asFloatBuffer2 = allocateDirect2.asFloatBuffer();
        asFloatBuffer2.put(fArr62);
        asFloatBuffer2.position(0);
        this.B.add(asFloatBuffer2);
        ByteBuffer allocateDirect3 = ByteBuffer.allocateDirect(fArr11.length * 4);
        allocateDirect3.order(ByteOrder.nativeOrder());
        FloatBuffer asFloatBuffer3 = allocateDirect3.asFloatBuffer();
        asFloatBuffer3.put(fArr11);
        asFloatBuffer3.position(0);
        this.A.add(asFloatBuffer3);
    }

    private double a(double d2) {
        if (0.0d <= d2) {
            double d3 = (double) 0.23f;
            if (d3 >= d2) {
                double d4 = d3 - d2;
                return d3 - Math.sqrt(((double) 0.0529f) - (d4 * d4));
            }
        }
        if (((double) 0.77f) > d2) {
            return 0.0d;
        }
        double d5 = (double) 0.23f;
        double d6 = d5 - (1.0d - d2);
        return d5 - Math.sqrt(((double) 0.0529f) - (d6 * d6));
    }

    private void a(float[] fArr, int i2, boolean z2, boolean z3, boolean z4, int i3, int i4) {
        if (!z4) {
            b(fArr, i2);
        }
        if (z3) {
            b(fArr, i2);
        }
        if (z2) {
            a(fArr, i2);
        }
        a(fArr, i2, i3, i4);
        c(fArr, i2);
    }

    private void a(float[] fArr, int i2) {
        fArr[i2] = 1.0f - fArr[i2];
    }

    private void a(float[] fArr, int i2, int i3, int i4) {
        float f2 = (float) i3;
        float f3 = (float) i4;
        fArr[i2] = ((1.0f - (f2 / f3)) / 2.0f) + ((fArr[i2] * f2) / f3);
    }

    private void b(float[] fArr, int i2) {
        int i3 = i2 - 1;
        fArr[i3] = 1.0f - fArr[i3];
        fArr[i2] = 1.0f - fArr[i2];
    }

    private void c(float[] fArr, int i2) {
        int i3 = i2 - 1;
        float f2 = fArr[i3];
        fArr[i3] = fArr[i2];
        fArr[i2] = 1.0f - f2;
    }

    private void b(Context context) {
        this.h = com.oppo.camera.util.d.a("vertex_tex.sh", context.getResources());
        this.i = com.oppo.camera.util.d.a("frag_tex.sh", context.getResources());
        this.f4137a = com.oppo.camera.util.d.b(this.h, this.i);
        this.c = GLES20.glGetAttribLocation(this.f4137a, "aPosition");
        this.d = GLES20.glGetAttribLocation(this.f4137a, "aTexCoor");
        this.f4138b = GLES20.glGetUniformLocation(this.f4137a, "uMVPMatrix");
        this.f = GLES20.glGetUniformLocation(this.f4137a, "uCamera");
        this.g = GLES20.glGetUniformLocation(this.f4137a, "uLightLocation");
        this.e = GLES20.glGetUniformLocation(this.f4137a, "uMMatrix");
    }

    public void b(int i2, int i3) {
        int i4 = i3;
        i.i();
        GLES20.glUseProgram(this.f4137a);
        i.i();
        GLES20.glUniformMatrix4fv(this.f4138b, 1, false, i.d(), 0);
        i.i();
        GLES20.glUniformMatrix4fv(this.e, 1, false, i.e(), 0);
        i.i();
        GLES20.glUniform3fv(this.f, 1, i.f());
        i.i();
        GLES20.glUniform3fv(this.g, 1, i.g());
        i.i();
        GLES20.glVertexAttribPointer(this.c, 3, 5126, false, 12, this.z.get(i4));
        GLES20.glVertexAttribPointer(this.d, 2, 5126, false, 8, this.A.get(i4));
        i.i();
        GLES20.glEnableVertexAttribArray(this.c);
        GLES20.glEnableVertexAttribArray(this.d);
        i.i();
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, i2);
        GLES20.glDrawArrays(4, 0, this.C.get(i4).intValue());
        GLES20.glDisableVertexAttribArray(this.c);
        GLES20.glDisableVertexAttribArray(this.d);
        i.i();
    }

    public void c(int i2, int i3) {
        int i4 = i3;
        i.b();
        GLES20.glViewport(0, 0, this.s, this.t);
        GLES20.glEnable(2929);
        GLES20.glEnable(2884);
        GLES20.glEnable(3042);
        GLES20.glBlendFunc(ArcSoftOffscreen.ASVL_PAF_RGB32_B8G8R8A8, 1);
        i.a(0.0f, ((-h.i()) / 2.0f) * 1.0f, 0.0f);
        GLES20.glUseProgram(this.f4137a);
        GLES20.glUniformMatrix4fv(this.f4138b, 1, false, i.d(), 0);
        GLES20.glUniformMatrix4fv(this.e, 1, false, i.e(), 0);
        GLES20.glUniform3fv(this.f, 1, i.f());
        GLES20.glUniform3fv(this.g, 1, i.g());
        GLES20.glVertexAttribPointer(this.c, 3, 5126, false, 12, this.z.get(i4));
        GLES20.glVertexAttribPointer(this.d, 2, 5126, false, 8, this.A.get(i4));
        GLES20.glEnableVertexAttribArray(this.c);
        GLES20.glEnableVertexAttribArray(this.d);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, i2);
        GLES20.glDrawArrays(4, 0, this.C.get(i4).intValue());
        GLES20.glDisableVertexAttribArray(this.c);
        GLES20.glDisableVertexAttribArray(this.d);
        i.c();
    }

    private void c(Context context) {
        this.q = com.oppo.camera.util.d.a("vertex_tex.sh", context.getResources());
        this.r = com.oppo.camera.util.d.a("frag_oes_tex.sh", context.getResources());
        this.j = com.oppo.camera.util.d.b(this.q, this.r);
        this.l = GLES20.glGetAttribLocation(this.j, "aPosition");
        this.m = GLES20.glGetAttribLocation(this.j, "aTexCoor");
        this.k = GLES20.glGetUniformLocation(this.j, "uMVPMatrix");
        this.o = GLES20.glGetUniformLocation(this.j, "uCamera");
        this.p = GLES20.glGetUniformLocation(this.j, "uLightLocation");
        this.n = GLES20.glGetUniformLocation(this.j, "uMMatrix");
    }

    public void d(int i2, int i3) {
        int i4 = i3;
        i.i();
        i.b();
        i.a(0.0f, ((-h.i()) / 2.0f) * 1.0f, 0.0f);
        GLES20.glUseProgram(this.j);
        GLES20.glUniformMatrix4fv(this.k, 1, false, i.d(), 0);
        GLES20.glUniformMatrix4fv(this.n, 1, false, i.e(), 0);
        GLES20.glUniform3fv(this.o, 1, i.f());
        GLES20.glUniform3fv(this.p, 1, i.g());
        GLES20.glVertexAttribPointer(this.l, 3, 5126, false, 12, this.z.get(i4));
        GLES20.glVertexAttribPointer(this.m, 2, 5126, false, 8, this.A.get(i4));
        GLES20.glEnableVertexAttribArray(this.l);
        GLES20.glEnableVertexAttribArray(this.m);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(36197, i2);
        GLES20.glDrawArrays(4, 0, this.C.get(i4).intValue());
        GLES20.glDisableVertexAttribArray(this.l);
        GLES20.glDisableVertexAttribArray(this.m);
        i.c();
    }

    public void e(int i2, int i3) {
        i.i();
        i.b();
        i.a(0.0f, ((-h.i()) / 2.0f) * 1.0f, 0.0f);
        b(i2, i3);
        i.c();
    }

    public void a(Context context) {
        this.w = true;
        this.D.a(context, 2, 2);
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_MICROSCOPE_SUPPORT)) {
            this.E.a(context, 2, 2);
        }
        this.w = false;
    }

    public void f(int i2, int i3) {
        m mVar = this.D;
        if (mVar != null) {
            mVar.a(i2, i3);
        }
    }

    public void c() {
        if (this.D != null) {
            e.a("CylinderSide", "destroyFilterEngine mPolarrRender");
            this.D.e();
            i.i();
            e.a("CylinderSide", "destroyFilterEngine mPolarrRender X");
        }
        if (this.E != null) {
            e.a("CylinderSide", "destroyFilterEngine mAncFilterSdk");
            this.E.e();
            i.i();
            e.a("CylinderSide", "destroyFilterEngine mAncFilterSdk X");
        }
    }

    public void d() {
        m mVar = this.D;
        if (mVar != null) {
            mVar.f();
        }
    }

    public boolean a(int i2, int i3, List<DrawingItem> list, float f2) {
        if (list == null) {
            return false;
        }
        GLES20.glDisable(3042);
        f().a(list, i2, i3, this.u, f2);
        return true;
    }

    public boolean e() {
        return f() != null && f().a();
    }
}
