package com.oppo.camera.ui.menu.levelcontrol;

import android.opengl.Matrix;
import java.lang.reflect.Array;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/* compiled from: MatrixState */
public class i {

    /* renamed from: a  reason: collision with root package name */
    private static float[] f4148a = new float[16];

    /* renamed from: b  reason: collision with root package name */
    private static float[] f4149b = new float[16];
    private static float[] c = new float[16];
    private static float[] d = null;
    private static FloatBuffer e = null;
    private static FloatBuffer f = null;
    private static float[][] g = ((float[][]) Array.newInstance(float.class, new int[]{10, 16}));
    private static int h = -1;

    public static void a() {
        d = new float[16];
        Matrix.setRotateM(d, 0, 0.0f, 1.0f, 0.0f, 0.0f);
    }

    public static void b() {
        h++;
        for (int i = 0; i < 16; i++) {
            g[h][i] = d[i];
        }
    }

    public static void c() {
        for (int i = 0; i < 16; i++) {
            d[i] = g[h][i];
        }
        h--;
    }

    public static void a(float f2, float f3, float f4) {
        Matrix.translateM(d, 0, f2, f3, f4);
    }

    public static void a(float f2, float f3, float f4, float f5) {
        Matrix.rotateM(d, 0, f2, f3, f4, f5);
    }

    public static void a(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10) {
        Matrix.setLookAtM(c, 0, f2, f3, f4, f5, f6, f7, f8, f9, f10);
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(12);
        allocateDirect.clear();
        allocateDirect.order(ByteOrder.nativeOrder());
        e = allocateDirect.asFloatBuffer();
        e.put(new float[]{f2, f3, f4});
        e.position(0);
    }

    public static void b(float f2, float f3, float f4) {
        float[] fArr = {0.0f, 0.0f, 0.0f};
        fArr[0] = f2;
        fArr[1] = f3;
        fArr[2] = f4;
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(12);
        allocateDirect.clear();
        allocateDirect.order(ByteOrder.nativeOrder());
        f = allocateDirect.asFloatBuffer();
        f.put(fArr);
        f.position(0);
    }

    public static void a(float f2, float f3, float f4, float f5, float f6, float f7) {
        Matrix.orthoM(f4149b, 0, f2, f3, f4, f5, f6, f7);
    }

    public static float[] d() {
        Matrix.multiplyMM(f4148a, 0, c, 0, d, 0);
        float[] fArr = f4148a;
        Matrix.multiplyMM(fArr, 0, f4149b, 0, fArr, 0);
        return f4148a;
    }

    public static float[] e() {
        return d;
    }

    public static FloatBuffer f() {
        return e;
    }

    public static FloatBuffer g() {
        return f;
    }
}
