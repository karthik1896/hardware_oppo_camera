package com.oppo.camera.gl;

import android.hardware.HardwareBuffer;
import android.renderscript.Matrix4f;
import com.oppo.camera.e;
import com.oppo.camera.gl.m;
import com.oppo.camera.jni.PreviewShow;
import java.util.ArrayList;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* compiled from: YUVRenderer */
public class x implements m.C0085m {

    /* renamed from: a  reason: collision with root package name */
    private final Object f3327a;

    /* renamed from: b  reason: collision with root package name */
    private ArrayList<HardwareBuffer> f3328b;
    private int c;
    private int d;
    private h e;
    private float[] f;
    private g g;
    private long h;

    public x() {
        this.f3327a = new Object();
        this.f3328b = null;
        this.c = -1;
        this.d = -1;
        this.e = null;
        this.f = new float[16];
        this.g = null;
        this.h = 0;
        this.h = PreviewShow.init();
        Matrix4f matrix4f = new Matrix4f();
        matrix4f.scale(1.0f, -1.0f, 1.0f);
        matrix4f.translate(0.0f, -1.0f, 0.0f);
        matrix4f.rotate(90.0f, 0.0f, 0.0f, 1.0f);
        matrix4f.translate(0.0f, -1.0f, 0.0f);
        this.f = matrix4f.getArray();
        this.f3328b = new ArrayList<>();
    }

    public void a(GL10 gl10, EGLConfig eGLConfig) {
        this.g = new g(36197);
        this.e = new i();
    }

    public void a(GL10 gl10, int i, int i2) {
        this.c = i;
        this.d = i2;
        this.e.a(this.c, this.d);
    }

    public void a(HardwareBuffer hardwareBuffer) {
        synchronized (this.f3327a) {
            if (this.f3328b == null) {
                hardwareBuffer.close();
                return;
            }
            if (this.f3328b.size() > 15) {
                this.f3328b.remove(0).close();
            }
            this.f3328b.add(hardwareBuffer);
        }
    }

    public void a(GL10 gl10) {
        this.e.a(new float[]{1.0f, 0.0f, 0.0f, 0.0f});
        a(this.e, 0, 0, this.c, this.d);
    }

    private void a(h hVar, int i, int i2, int i3, int i4) {
        HardwareBuffer remove;
        h hVar2 = hVar;
        int i5 = i3;
        int i6 = i4;
        synchronized (this.f3327a) {
            remove = this.f3328b.size() > 0 ? this.f3328b.remove(0) : null;
        }
        e.a("drawHardwareBuffer");
        if (remove != null) {
            hVar.a(2);
            int d2 = hVar.d();
            int e2 = hVar.e();
            hVar.a(i5, i6);
            int i7 = (i5 / 2) + i;
            int i8 = (i6 / 2) + i2;
            hVar.a((float) i7, (float) i8);
            hVar.a(1.0f, -1.0f, 1.0f);
            hVar.a((float) (-i7), (float) (-i8));
            PreviewShow.process(remove, 36197, this.g.d(), this.h);
            hVar.a((c) this.g, this.f, i, i2, i3, i4);
            hVar.a(d2, e2);
            hVar.f();
            remove.close();
        }
        e.b("drawHardwareBuffer");
    }

    public void a() {
        synchronized (this.f3327a) {
            if (this.f3328b.size() > 0) {
                this.f3328b.clear();
            }
        }
        PreviewShow.release(this.h);
    }
}
