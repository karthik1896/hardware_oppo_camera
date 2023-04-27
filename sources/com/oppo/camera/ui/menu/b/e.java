package com.oppo.camera.ui.menu.b;

import android.opengl.Matrix;
import java.lang.reflect.Array;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/* compiled from: HeadlineMatrix */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private float[][] f4086a = ((float[][]) Array.newInstance(float.class, new int[]{10, 16}));

    /* renamed from: b  reason: collision with root package name */
    private float[] f4087b = new float[16];
    private float[] c = new float[16];
    private float[] d = new float[16];
    private float[] e = null;
    private FloatBuffer f = null;
    private FloatBuffer g = null;
    private int h = -1;

    public void a() {
        this.e = new float[16];
        Matrix.setRotateM(this.e, 0, 0.0f, 1.0f, 0.0f, 0.0f);
    }

    public void b() {
        this.h++;
        for (int i = 0; i < 16; i++) {
            this.f4086a[this.h][i] = this.e[i];
        }
    }

    public void c() {
        for (int i = 0; i < 16; i++) {
            this.e[i] = this.f4086a[this.h][i];
        }
        this.h--;
    }

    public void a(float f2, float f3, float f4) {
        Matrix.translateM(this.e, 0, f2, f3, f4);
    }

    public void a(float f2, float f3, float f4, float f5) {
        Matrix.rotateM(this.e, 0, f2, f3, f4, f5);
    }

    public void a(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10) {
        Matrix.setLookAtM(this.d, 0, f2, f3, f4, f5, f6, f7, f8, f9, f10);
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(12);
        allocateDirect.clear();
        allocateDirect.order(ByteOrder.nativeOrder());
        this.f = allocateDirect.asFloatBuffer();
        this.f.put(new float[]{f2, f3, f4});
        this.f.position(0);
    }

    public void a(float f2, float f3, float f4, float f5, float f6, float f7) {
        Matrix.orthoM(this.c, 0, f2, f3, f4, f5, f6, f7);
    }

    public float[] d() {
        Matrix.multiplyMM(this.f4087b, 0, this.d, 0, this.e, 0);
        float[] fArr = this.f4087b;
        Matrix.multiplyMM(fArr, 0, this.c, 0, fArr, 0);
        return this.f4087b;
    }
}
