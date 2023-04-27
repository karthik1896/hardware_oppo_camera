package com.oppo.camera.ui;

import android.view.animation.Animation;
import android.view.animation.Transformation;

/* compiled from: OrientationAnimation */
public class l extends Animation implements Animation.AnimationListener {

    /* renamed from: a  reason: collision with root package name */
    private float f4036a = 0.0f;

    /* renamed from: b  reason: collision with root package name */
    private float f4037b = 0.0f;
    private boolean c = false;
    private boolean d = false;
    private int e = 0;
    private a f = null;

    /* compiled from: OrientationAnimation */
    public interface a {
        void a(float f);

        void a(int i);

        boolean a();
    }

    public l(float f2, float f3) {
        this.f4036a = f2;
        this.f4037b = f3;
        this.c = false;
        this.d = false;
        setRepeatCount(1);
        setAnimationListener(this);
    }

    public void a(int i, boolean z) {
        this.e = i;
        a aVar = this.f;
        if ((aVar != null && !aVar.a()) || !z) {
            a(i);
        }
    }

    public void a(a aVar) {
        this.f = aVar;
    }

    public int a() {
        return this.e;
    }

    public boolean b() {
        return this.c;
    }

    /* access modifiers changed from: protected */
    public void applyTransformation(float f2, Transformation transformation) {
        float f3;
        float f4;
        if (this.d) {
            f3 = this.f4037b;
            f4 = this.f4036a;
        } else {
            f3 = this.f4036a;
            f4 = this.f4037b;
        }
        float f5 = f3 + ((f4 - f3) * f2);
        float f6 = 1.0f;
        if (f5 <= 1.0f) {
            f6 = f5;
        }
        if (f6 < 0.0f) {
            f6 = 0.0f;
        }
        if (!this.c) {
            f6 = this.f4036a;
        }
        a(f6);
    }

    private void a(float f2) {
        a aVar = this.f;
        if (aVar != null) {
            aVar.a(f2);
        }
    }

    private void a(int i) {
        a aVar = this.f;
        if (aVar != null) {
            aVar.a(i);
        }
    }

    public void onAnimationEnd(Animation animation) {
        a(this.e);
        a(this.f4036a);
        this.c = false;
        this.d = false;
    }

    public void onAnimationRepeat(Animation animation) {
        this.d = true;
        a(this.f4037b);
        a(this.e);
    }

    public void onAnimationStart(Animation animation) {
        this.c = true;
        this.d = false;
    }
}
