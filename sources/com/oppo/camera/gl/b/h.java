package com.oppo.camera.gl.b;

import android.graphics.Rect;
import android.util.Size;
import com.oppo.camera.e;

/* compiled from: SubSurfacePositionContainer */
public class h {

    /* renamed from: a  reason: collision with root package name */
    private int f3280a = 0;

    /* renamed from: b  reason: collision with root package name */
    private int f3281b = 0;
    private int c = 0;
    private int d = -1;
    private int e = -1;
    private int f = 0;
    private int g = 0;
    private int h = -1;
    private int i = 0;
    private int j = 0;
    private int k = 0;
    private int l = 0;
    private int m = 0;
    private int n = 0;
    private boolean o = true;

    public int a() {
        return this.f3280a;
    }

    public int b() {
        return this.f3281b;
    }

    public int c() {
        return this.c;
    }

    public int d() {
        return this.d;
    }

    public int e() {
        return this.e;
    }

    public int f() {
        return this.i;
    }

    public int g() {
        return this.j;
    }

    public int h() {
        return this.k;
    }

    public int i() {
        return this.l;
    }

    public int j() {
        return this.m;
    }

    public int k() {
        return this.n;
    }

    public void a(int i2) {
        this.f3280a = i2;
    }

    public void b(int i2) {
        this.f3281b = i2;
    }

    public void c(int i2) {
        this.c = i2;
    }

    public void d(int i2) {
        this.d = i2;
    }

    public void e(int i2) {
        this.e = i2;
    }

    public int l() {
        return this.h;
    }

    public void f(int i2) {
        e.e("SubSurfacePositionContainer", "setMultiVideoType, multiVideoType: " + i2);
        this.h = i2;
    }

    public boolean m() {
        return this.o;
    }

    public void a(boolean z) {
        this.o = z;
    }

    public void a(int i2, int i3) {
        this.f = i2;
        this.g = i3;
    }

    public Rect n() {
        int i2 = this.d;
        int i3 = this.e;
        return new Rect(i2, i3, this.f + i2, this.g + i3);
    }

    public void a(Size size, Size size2, int i2, boolean z) {
        if (i2 == 0) {
            this.i = a();
            this.j = (size2.getWidth() * a()) / size2.getHeight();
            int i3 = this.i;
            this.k = i3;
            int i4 = this.j;
            this.l = i4;
            this.n = i3;
            this.m = i4 * 2;
        } else if (i2 != 1) {
            if (i2 == 2) {
                if (z) {
                    this.i = a();
                    this.j = (size2.getWidth() * a()) / size2.getHeight();
                    this.k = (int) (((float) a()) / 3.0f);
                    int i5 = this.j;
                    this.l = (int) (((float) i5) / 3.0f);
                    this.n = this.i;
                    this.m = i5;
                    return;
                }
                this.k = a();
                this.l = (size.getWidth() * a()) / size.getHeight();
                this.i = (int) (((float) a()) / 3.0f);
                int i6 = this.l;
                this.j = (int) (((float) i6) / 3.0f);
                this.n = this.k;
                this.m = i6;
            }
        } else if (z) {
            this.i = a();
            this.j = (size2.getWidth() * a()) / size2.getHeight();
            int a2 = (int) (((float) a()) / 2.33f);
            this.k = a2;
            this.l = a2;
            this.n = this.i;
            this.m = this.j;
        } else {
            this.k = a();
            this.l = (size.getWidth() * a()) / size.getHeight();
            int a3 = (int) (((float) a()) / 2.33f);
            this.i = a3;
            this.j = a3;
            this.n = this.k;
            this.m = this.l;
        }
    }

    public String toString() {
        return "SubSurfacePositionContainer{mScreenWidth=" + this.f3280a + ", mScreenHeight=" + this.f3281b + ", mSettingMenuPanelHeight=" + this.c + ", mSmallSurfaceXOnScreen=" + this.d + ", mSmallSurfaceYOnScreen=" + this.e + ", mSmallSurfaceWidth=" + this.f + ", mSmallSurfaceHeight=" + this.g + ", mMultiVideoType=" + this.h + ", mDrawMainImageWidth=" + this.i + ", mDrawMainImageHeight=" + this.j + ", mDrawSubImageWidth=" + this.k + ", mDrawSubImageHeight=" + this.l + ", mFboHeight=" + this.m + ", mFboWidth=" + this.n + ", mbMainOneCameraFirstDraw=" + this.o + '}';
    }
}
