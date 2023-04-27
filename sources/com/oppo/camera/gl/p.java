package com.oppo.camera.gl;

import android.graphics.Bitmap;
import android.opengl.GLES31;
import com.oppo.camera.R;
import com.oppo.camera.e;
import com.oppo.camera.jni.FormatConverter;
import com.oppo.camera.util.Util;
import com.oppo.camera.util.d;
import java.nio.FloatBuffer;
import java.util.Arrays;

/* compiled from: NoMoireThumbGenerator */
public class p {

    /* renamed from: a  reason: collision with root package name */
    private static final float[] f3308a = {1.0f, -1.0f, 1.0f, 1.0f, -1.0f, -1.0f, -1.0f, 1.0f};

    /* renamed from: b  reason: collision with root package name */
    private static final float[] f3309b = {-1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f, -1.0f};
    private static final float[] c = {1.0f, 1.0f, -1.0f, 1.0f, 1.0f, -1.0f, -1.0f, -1.0f};
    private static final float[] d = {-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};
    private static final float[] e = {0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f};
    private static final float[] f = {1.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f};
    private int g = d.b("attribute vec4 vPosition;\nattribute vec2 vCoordinate;\nvarying vec2 aCoordinate;\nvoid main() {\n   gl_Position = vPosition;\n   aCoordinate = vCoordinate;\n}", "precision mediump float;\nuniform sampler2D vTexture;\nuniform float srcWidth;\nuniform float srcHeight;\nuniform float dstWidth;\nuniform float dstHeight;\nvarying vec2 aCoordinate;\nvoid main() {\n    gl_FragColor = texture2D(vTexture, aCoordinate);\n}");
    private int h;
    private float[] i = new float[8];
    private float[] j = new float[8];
    private int[] k = new int[1];
    private int[] l = new int[1];
    private FormatConverter m = new FormatConverter();
    private int n = Util.f().getResources().getDimensionPixelSize(R.dimen.thumbnail_width_nomal);
    private int o = this.n;

    public void a() {
    }

    public p() {
        int glCreateShader = GLES31.glCreateShader(37305);
        if (glCreateShader != 0) {
            GLES31.glShaderSource(glCreateShader, "#version 310 es\nlayout(local_size_x = 8, local_size_y = 4, local_size_z = 1) in;\nlayout(rgba8, binding = 0) readonly uniform highp image2D input0; \nlayout(rgba8, binding = 1) writeonly uniform highp image2D output0; \n\nuniform float srcWidth;\nuniform float srcHeight;\nuniform float dstWidth;\nuniform float dstHeight;\n\nvoid main() {\n    float gx = float(gl_GlobalInvocationID.x);\n    float gy = float(gl_GlobalInvocationID.y);\n    \n    float xScale = srcWidth / dstWidth;\n    float yScale = srcHeight / dstHeight;\n    float xScaleActual = xScale;\n    float yScaleActual = yScale;\n    \n    float yPos = gy * yScale;\n    float yBegin = floor(yPos);\n    float yEnd = ceil(yPos + yScale);\n    float fraction_y_0 = 1.0f - abs(yPos - yBegin);\n    float fraction_y_1 = 1.0f - abs(yPos + yScale - yEnd);\n    if (yEnd > srcHeight) {\n        yEnd = srcHeight;\n        yScaleActual = yEnd - yPos;\n        fraction_y_1 = 1.0f;\n    }\n\n    float xPos = gx * xScale;\n    float xBegin = floor(xPos);\n    float xEnd = ceil(xPos + xScale);\n    float fraction_x_0 = 1.0f - abs(xPos - xBegin);\n    float fraction_x_1 = 1.0f - abs(xPos + xScale - xEnd);\n    if (xEnd > srcWidth) {\n        xEnd = srcWidth;\n        xScaleActual = xEnd - xPos;\n        fraction_x_1 = 1.0f;\n    }\n\n    vec4 sum = vec4(0.0f, 0.0f, 0.0f, 0.0f);\n    {\n        float y = yBegin;\n        {\n            float x = xBegin;\n            vec4 sumy = vec4(0.0f, 0.0f, 0.0f, 0.0f);\n            sumy += imageLoad(input0, ivec2(uint(x), uint(y))) * vec4(fraction_x_0, fraction_x_0,                     fraction_x_0, fraction_x_0);\n\n            for (x = xBegin + 1.0f; x < xEnd - 1.0f; x += 1.0f) {\n                sumy += imageLoad(input0, ivec2(uint(x), uint(y)));\n            }\n\n            sumy += imageLoad(input0, ivec2(uint(x), uint(y))) * vec4(fraction_x_1, fraction_x_1,                     fraction_x_1, fraction_x_1);\n            sum += sumy * vec4(fraction_y_0, fraction_y_0, fraction_y_0, fraction_y_0);\n        }\n\n        for (y = yBegin + 1.0f; y < yEnd - 1.0f; y += 1.0f) {\n            float x = xBegin;\n            vec4 sumy = vec4(0.0f, 0.0f, 0.0f, 0.0f);\n            sumy += imageLoad(input0, ivec2(uint(x), uint(y))) * vec4(fraction_x_0, fraction_x_0,                     fraction_x_0, fraction_x_0);\n\n            for (x = xBegin + 1.0f; x < xEnd - 1.0f; x += 1.0f) {\n                sumy += imageLoad(input0, ivec2(uint(x), uint(y)));\n            }\n\n            sumy += imageLoad(input0, ivec2(uint(x), uint(y))) * vec4(fraction_x_1, fraction_x_1,                     fraction_x_1, fraction_x_1);\n            sum += sumy;\n        }\n\n        {\n            float x = xBegin;\n            vec4 sumy = vec4(0.0f, 0.0f, 0.0f, 0.0f);\n            sumy += imageLoad(input0, ivec2(uint(x), uint(y))) * vec4(fraction_x_0, fraction_x_0,                     fraction_x_0, fraction_x_0);\n\n            for (x = xBegin + 1.0f; x < xEnd - 1.0f; x += 1.0f) {\n                sumy += imageLoad(input0, ivec2(uint(x), uint(y)));\n            }\n\n            sumy += imageLoad(input0, ivec2(uint(x), uint(y))) * vec4(fraction_x_1, fraction_x_1,                     fraction_x_1, fraction_x_1);\n            sum += sumy * vec4(fraction_y_1, fraction_y_1, fraction_y_1, fraction_y_1);\n        }\n    }\n\n    float area = xScaleActual * yScaleActual;\n    sum /= vec4(area, area, area, area);\n    imageStore(output0, ivec2(uint(gx), uint(gy)), sum);\n}\n");
            GLES31.glCompileShader(glCreateShader);
            int[] iArr = new int[1];
            GLES31.glGetShaderiv(glCreateShader, 35713, iArr, 0);
            if (iArr[0] == 0) {
                e.e("NoMoireThumbGenerator", "loadShader, Could not compile shader 37305: " + GLES31.glGetShaderInfoLog(glCreateShader));
                GLES31.glDeleteShader(glCreateShader);
                glCreateShader = 0;
            }
        }
        int glCreateProgram = GLES31.glCreateProgram();
        if (glCreateProgram != 0) {
            GLES31.glAttachShader(glCreateProgram, glCreateShader);
            GLES31.glLinkProgram(glCreateProgram);
            int[] iArr2 = new int[1];
            GLES31.glGetProgramiv(glCreateProgram, 35714, iArr2, 0);
            if (1 != iArr2[0]) {
                e.e("NoMoireThumbGenerator", "createProgram, Could not link program: " + GLES31.glGetProgramInfoLog(glCreateProgram));
                GLES31.glDeleteProgram(glCreateProgram);
            }
        }
        this.h = glCreateProgram;
    }

    public void a(int i2, int i3, int i4, boolean z) {
        if (z) {
            float[] fArr = e;
            System.arraycopy(fArr, 0, this.j, 0, fArr.length);
        } else {
            float[] fArr2 = f;
            System.arraycopy(fArr2, 0, this.j, 0, fArr2.length);
        }
        if (i2 != i3) {
            float f2 = ((float) (i3 - i2)) / (((float) i3) * 2.0f);
            float[] fArr3 = this.j;
            fArr3[1] = fArr3[1] + f2;
            fArr3[5] = fArr3[5] + f2;
            fArr3[3] = fArr3[3] - f2;
            fArr3[7] = fArr3[7] - f2;
        }
        if (i4 == 0) {
            this.i = d;
        } else if (90 == i4) {
            this.i = f3308a;
        } else if (180 == i4) {
            this.i = c;
        } else if (270 == i4) {
            this.i = f3309b;
        }
    }

    private void a(int i2, int i3, int i4, int[] iArr, int i5, int i6, int i7, int i8) {
        int i9 = i2;
        int[] iArr2 = iArr;
        GLES31.glGenFramebuffers(1, iArr2, 0);
        GLES31.glBindFramebuffer(36160, iArr2[0]);
        GLES31.glFramebufferTexture2D(36160, 36064, 3553, i4, 0);
        FloatBuffer a2 = d.a(this.i);
        FloatBuffer a3 = d.a(this.j);
        GLES31.glViewport(i5, i6, i7, i8);
        GLES31.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        GLES31.glClear(16640);
        GLES31.glUseProgram(i2);
        int glGetAttribLocation = GLES31.glGetAttribLocation(i9, "vPosition");
        int glGetAttribLocation2 = GLES31.glGetAttribLocation(i9, "vCoordinate");
        int glGetUniformLocation = GLES31.glGetUniformLocation(i9, "vTexture");
        GLES31.glEnableVertexAttribArray(glGetAttribLocation);
        GLES31.glEnableVertexAttribArray(glGetAttribLocation2);
        GLES31.glVertexAttribPointer(glGetAttribLocation, 2, 5126, false, 0, a2);
        GLES31.glVertexAttribPointer(glGetAttribLocation2, 2, 5126, false, 0, a3);
        GLES31.glActiveTexture(33984);
        GLES31.glBindTexture(3553, i3);
        GLES31.glUniform1i(glGetUniformLocation, 0);
        GLES31.glDrawArrays(5, 0, this.i.length / 2);
        GLES31.glDisableVertexAttribArray(glGetAttribLocation);
        GLES31.glDisableVertexAttribArray(glGetAttribLocation2);
        GLES31.glDeleteFramebuffers(1, iArr2, 0);
    }

    private void a(int i2, int[] iArr, int i3, int i4, int i5) {
        int[] iArr2 = iArr;
        GLES31.glGenTextures(1, iArr2, 0);
        GLES31.glBindTexture(3553, iArr2[0]);
        int i6 = i4;
        int i7 = i5;
        GLES31.glTexStorage2D(3553, 1, 32856, i6, i7);
        a(i3, i2, iArr2[0], new int[1], 0, 0, i6, i7);
        GLES31.glUseProgram(this.h);
        GLES31.glBindTexture(3553, iArr2[0]);
        GLES31.glBindImageTexture(0, iArr2[0], 0, false, 0, 35000, 32856);
    }

    private void a(int[] iArr) {
        GLES31.glBindTexture(3553, iArr[0]);
        GLES31.glBindImageTexture(1, iArr[0], 0, false, 0, 35001, 32856);
    }

    private void a(int i2, int i3, int i4, int i5, int i6) {
        GLES31.glUseProgram(i2);
        int glGetUniformLocation = GLES31.glGetUniformLocation(i2, "srcWidth");
        int glGetUniformLocation2 = GLES31.glGetUniformLocation(i2, "srcHeight");
        int glGetUniformLocation3 = GLES31.glGetUniformLocation(i2, "dstWidth");
        int glGetUniformLocation4 = GLES31.glGetUniformLocation(i2, "dstHeight");
        GLES31.glUniform1f(glGetUniformLocation, (float) i3);
        GLES31.glUniform1f(glGetUniformLocation2, (float) i4);
        GLES31.glUniform1f(glGetUniformLocation3, (float) i5);
        GLES31.glUniform1f(glGetUniformLocation4, (float) i6);
        GLES31.glDispatchCompute(i5, i6, 1);
        GLES31.glMemoryBarrier(8);
    }

    public Bitmap a(int i2, int i3, int i4) {
        int[] iArr = new int[1];
        d.a(this.k, this.l, this.n, this.o);
        int i5 = i3 / 2;
        int i6 = i4 / 2;
        a(i2, iArr, this.g, i5, i6);
        a(this.l);
        a(this.h, i5, i6, this.n, this.o);
        GLES31.glBindImageTexture(1, 0, 0, false, 0, 35001, 32856);
        GLES31.glBindFramebuffer(36160, this.k[0]);
        e.b("NoMoireThumbGenerator", "onDrawFrame, mFbo: " + Arrays.toString(this.k));
        GLES31.glFramebufferTexture2D(36160, 36064, 3553, this.l[0], 0);
        Bitmap a2 = Util.a(this.n, this.o, Bitmap.Config.ARGB_8888);
        this.m.glReadPixelsToBitmap(a2, this.n, this.o, 6408, 5121);
        GLES31.glBindTexture(3553, 0);
        GLES31.glBindFramebuffer(36160, 0);
        GLES31.glUseProgram(0);
        GLES31.glDeleteTextures(1, iArr, 0);
        GLES31.glDeleteFramebuffers(1, this.k, 0);
        GLES31.glDeleteTextures(1, this.l, 0);
        return a2;
    }
}
