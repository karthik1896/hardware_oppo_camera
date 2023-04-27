package com.oppo.camera.gl.a;

import android.opengl.GLES20;
import com.oppo.camera.util.d;
import java.nio.FloatBuffer;
import java.util.HashMap;
import java.util.Map;

/* compiled from: GLImageSingleGaussBlurProcessor */
class e {

    /* renamed from: a  reason: collision with root package name */
    private static final Map<Integer, float[]> f3271a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private final double f3272b = 2.0d;
    private final double c = 0.25d;
    private final double d = -0.5d;
    private c e = null;
    private int f = 0;
    private int g = 0;
    private int h = 0;
    private int i = 0;
    private int j = 0;
    private int k = 0;
    private int l = 0;
    private int m = 0;
    private int n = 50;

    e() {
        a();
        this.e = new c(this.f, this.g, this.h, this.i);
    }

    public void a() {
        this.f = d.a("attribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nuniform float texelWidthOffset;\nuniform float texelHeightOffset;\nvarying vec2 textureCoordinate;\nvarying vec2 singleStepOffset;\nvoid main() {\n    gl_Position = aPosition;\n    textureCoordinate = aTextureCoord.xy;\n    singleStepOffset = vec2(texelWidthOffset, texelHeightOffset);\n}", "precision mediump float;\nvarying vec2 textureCoordinate;\nvarying vec2 singleStepOffset;\nuniform float weight[25];\nuniform sampler2D inputTexture;\nuniform int radius;\nvoid main() {\n    vec4 currentColor = texture2D(inputTexture, textureCoordinate);\n    mediump vec3 sum = currentColor.rgb * weight[0];\n    for (int i = 0; i < radius - 1; i++) {\n        vec2 offset = float(i + 1) * singleStepOffset;\n        float offsetWeight = weight[i + 1];\n        sum += texture2D(inputTexture, textureCoordinate + offset).rgb * offsetWeight;\n        sum += texture2D(inputTexture, textureCoordinate - offset).rgb * offsetWeight;\n    }\n    gl_FragColor = vec4(sum, currentColor.a);\n}");
        this.g = GLES20.glGetAttribLocation(this.f, "aPosition");
        this.h = GLES20.glGetAttribLocation(this.f, "aTextureCoord");
        this.i = GLES20.glGetUniformLocation(this.f, "inputTexture");
        this.j = GLES20.glGetUniformLocation(this.f, "texelWidthOffset");
        this.k = GLES20.glGetUniformLocation(this.f, "texelHeightOffset");
        this.l = GLES20.glGetUniformLocation(this.f, "radius");
        this.m = GLES20.glGetUniformLocation(this.f, "weight");
    }

    private float[] b(int i2) {
        double d2;
        int i3 = this.n;
        if (i2 > i3) {
            i2 = i3;
        }
        if (f3271a.containsKey(Integer.valueOf(i2))) {
            return f3271a.get(Integer.valueOf(i2));
        }
        float[] fArr = new float[i2];
        double d3 = (((double) i2) * 0.25d) + 2.0d;
        for (int i4 = 0; i4 < i2; i4++) {
            double d4 = (double) i4;
            fArr[i4] = (float) Math.exp((((-0.5d * d4) * d4) / d3) / d3);
        }
        if (i2 < this.n) {
            d2 = (double) fArr[0];
            for (int i5 = 1; i5 < i2; i5++) {
                d2 += (double) (fArr[i5] * 2.0f);
            }
        } else {
            d2 = d3 * Math.sqrt(6.283185307179586d);
        }
        for (int i6 = 0; i6 < i2; i6++) {
            fArr[i6] = (float) (((double) fArr[i6]) / d2);
        }
        f3271a.put(Integer.valueOf(i2), fArr);
        return fArr;
    }

    public void a(int i2, int i3) {
        this.e.a(i2, i3, 2);
    }

    public int a(int i2, FloatBuffer floatBuffer, FloatBuffer floatBuffer2, int i3) {
        return i2 == -1 ? i2 : this.e.a(i2, floatBuffer, floatBuffer2, i3);
    }

    public void b() {
        this.e.d();
    }

    public void c() {
        this.e.c();
        this.e = null;
        f3271a.clear();
    }

    public void a(int i2) {
        this.e.a(this.l, i2);
        this.e.a(this.m, b(i2));
    }

    public void a(float f2, float f3) {
        if (f2 != 0.0f) {
            this.e.a(this.j, 1.0f / f2);
        } else {
            this.e.a(this.j, 0.0f);
        }
        if (f3 != 0.0f) {
            this.e.a(this.k, 1.0f / f3);
        } else {
            this.e.a(this.k, 0.0f);
        }
    }
}
