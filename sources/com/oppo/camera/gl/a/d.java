package com.oppo.camera.gl.a;

import android.opengl.GLES20;
import android.util.Size;
import com.oppo.camera.e;
import java.nio.FloatBuffer;

/* compiled from: GLImageScaleCircularGaussProcessor */
public class d extends a {

    /* renamed from: a  reason: collision with root package name */
    private Size f3269a = null;

    /* renamed from: b  reason: collision with root package name */
    private Size f3270b = null;
    private FloatBuffer c = null;
    private c d = null;
    private int e = 0;
    private int f = 0;
    private int g = 0;
    private int h = 0;
    private int i = 0;
    private int j = 0;

    public d() {
        c();
        this.d = new c(this.e, this.f, this.g, this.h);
    }

    public void a(int i2, int i3) {
        super.a(i2, i3);
        a((float) i2, (float) i3);
    }

    public void b(int i2, int i3) {
        super.b(i2, i3);
        this.d.a(i2, i3, 1);
    }

    public void a() {
        super.a();
        d();
        this.d.d();
    }

    public void b() {
        super.b();
        this.d.c();
        this.d = null;
    }

    public void a(int i2) {
        super.a(i2);
    }

    public void c() {
        this.e = com.oppo.camera.util.d.a("attribute vec4 aPosition;\nattribute vec2 aTextureCoord;\nvarying vec2 aCoordinate;\nvoid main() {\n    gl_Position = aPosition;\n    aCoordinate = aTextureCoord;\n}", "precision mediump float;\nuniform sampler2D inputTexture;\nvarying vec2 aCoordinate;\nvoid main() {\n    gl_FragColor = texture2D(inputTexture, aCoordinate);\n}\n");
        this.f = GLES20.glGetAttribLocation(this.e, "aPosition");
        this.g = GLES20.glGetAttribLocation(this.e, "aTextureCoord");
        this.h = GLES20.glGetUniformLocation(this.e, "inputTexture");
    }

    public int a(int i2, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        this.c = floatBuffer2;
        c(this.i, this.j);
        return super.a(this.d.a(i2, floatBuffer, this.c, 0), floatBuffer, floatBuffer2);
    }

    public void a(float f2, float f3) {
        int i2 = ((int) f2) * 10;
        int i3 = ((int) f3) * 10;
        if (this.j != i3) {
            this.i = i2;
            this.j = i3;
        }
    }

    public void a(Size size, Size size2) {
        this.f3269a = size;
        this.f3270b = size2;
    }

    private void c(int i2, int i3) {
        float f2;
        Size size = this.f3269a;
        if (size != null && this.f3270b != null) {
            float f3 = (float) i3;
            if (Float.compare(((float) size.getWidth()) / ((float) this.f3269a.getHeight()), f3 / ((float) i2)) == 0) {
                e.b("GLImageScaleCircularGaussProcessor", "changeTextureFloatBuffer, fromRatio is equal with toRatio, return");
                return;
            }
            if (this.f3269a.getWidth() > i3) {
                f2 = ((float) (this.f3269a.getWidth() - i3)) / ((float) this.f3269a.getWidth());
            } else {
                f2 = ((float) (i3 - this.f3269a.getWidth())) / f3;
            }
            float[] fArr = (float[]) c.f3262b.clone();
            if (this.f3269a.getWidth() > i3) {
                float f4 = f2 / 2.0f;
                fArr[1] = fArr[1] + f4;
                fArr[3] = fArr[3] - f4;
                fArr[5] = fArr[5] + f4;
                fArr[7] = fArr[7] - f4;
            } else {
                float f5 = f2 / 2.0f;
                fArr[0] = fArr[0] + f5;
                fArr[2] = fArr[2] + f5;
                fArr[4] = fArr[4] - f5;
                fArr[6] = fArr[6] - f5;
            }
            this.c = com.oppo.camera.util.d.a(fArr);
        }
    }

    public void d() {
        this.f3269a = null;
        this.f3270b = null;
        this.j = 0;
        this.i = 0;
        this.c = null;
    }
}
