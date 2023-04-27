package com.oppo.camera.gl.a;

import java.nio.FloatBuffer;

/* compiled from: GLImageCircularGaussBlurProcessor */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private e f3257a;

    /* renamed from: b  reason: collision with root package name */
    private int f3258b;
    private int c;

    public a() {
        this.f3257a = null;
        this.f3258b = 0;
        this.c = 0;
        this.f3257a = new e();
    }

    public void a(int i, int i2) {
        this.f3258b = i;
        this.c = i2;
    }

    public int a(int i, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        e eVar = this.f3257a;
        if (eVar == null) {
            return i;
        }
        eVar.a(0.0f, (float) this.c);
        int a2 = this.f3257a.a(i, floatBuffer, floatBuffer2, 0);
        this.f3257a.a((float) this.f3258b, 0.0f);
        return this.f3257a.a(a2, floatBuffer, floatBuffer2, 1);
    }

    public void b(int i, int i2) {
        e eVar = this.f3257a;
        if (eVar != null) {
            eVar.a(i, i2);
        }
    }

    public void a() {
        e eVar = this.f3257a;
        if (eVar != null) {
            eVar.b();
        }
    }

    public void b() {
        e eVar = this.f3257a;
        if (eVar != null) {
            eVar.c();
            this.f3257a = null;
        }
    }

    public void a(int i) {
        e eVar = this.f3257a;
        if (eVar != null) {
            eVar.a(i);
        }
    }
}
