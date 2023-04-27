package com.oppo.camera.gl.a;

import android.renderscript.Matrix4f;
import android.util.Size;
import android.view.animation.PathInterpolator;
import com.oppo.camera.e;
import com.oppo.camera.gl.i;
import com.oppo.camera.util.d;
import java.nio.FloatBuffer;

/* compiled from: GLImageModeChangeProcessorAgent */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private float f3259a;

    /* renamed from: b  reason: collision with root package name */
    private float f3260b;
    private int c;
    private int d;
    private int e;
    private d f;
    private PathInterpolator g;
    private FloatBuffer h;
    private FloatBuffer i;
    private Matrix4f j;
    private Matrix4f k;
    private boolean l;

    public b() {
        this.f3259a = 5.0f;
        this.f3260b = 1.0f;
        this.c = 0;
        this.d = 0;
        this.e = 0;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = false;
        this.f = new d();
        this.g = new PathInterpolator(0.33f, 0.0f, 0.66f, 1.0f);
        this.h = d.a(c.f3261a);
        this.i = d.a(c.f3262b);
        this.j = new Matrix4f();
        this.j.scale(1.0f, -1.0f, 1.0f);
        this.j.translate(0.0f, -1.0f, 0.0f);
        this.k = new Matrix4f();
    }

    public void a(int i2, int i3) {
        e.a("GLImageModeChangeProcessorAgent", "init, width: " + i2 + ", height: " + i3);
        this.c = i2;
        this.d = i3;
        this.f.b(i2, i3);
        this.f.a(i2, i3);
    }

    public void a(Size size, Size size2) {
        e.a("GLImageModeChangeProcessorAgent", "setChangeSize, size change: " + size.getWidth() + " x " + size.getHeight() + " => " + size2.getWidth() + " x " + size2.getHeight());
        this.f.a(size, size2);
    }

    public int a(int i2) {
        this.f.a(e());
        return this.f.a(i2, this.h, this.i);
    }

    public float[] a() {
        if (this.l) {
            return this.k.getArray();
        }
        return this.j.getArray();
    }

    public void a(boolean z) {
        this.l = z;
    }

    public void b() {
        e.a("GLImageModeChangeProcessorAgent", "uninit");
        this.c = 0;
        this.d = 0;
        this.f.a();
    }

    public void c() {
        this.f.b();
        this.f = null;
        this.h = null;
        this.i = null;
    }

    public int a(int i2, int i3, int i4) {
        e.a("GLImageModeChangeProcessorAgent", "drawCoverBlur, textId: " + i2 + ", mBlurShotWidth: " + this.c + ", mBlurShotHeight: " + this.d + ", width: " + i3 + ", height: " + i4 + ", mSizeRatioType: " + this.e);
        int i5 = i4 / 10;
        int i6 = i3 / 10;
        if (!(this.c == i6 && this.d == i5)) {
            a(i6, i5);
            i.i();
        }
        return a(i2);
    }

    public void d() {
        this.f3259a = 5.0f;
    }

    public int e() {
        float interpolation = this.g.getInterpolation(this.f3259a / 25.0f);
        this.f3259a += this.f3260b;
        if (this.f3259a > 25.0f) {
            this.f3259a = 25.0f;
        }
        return (int) (interpolation * 25.0f);
    }
}
