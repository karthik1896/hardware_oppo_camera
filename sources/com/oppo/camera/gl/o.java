package com.oppo.camera.gl;

/* compiled from: IntArray */
public class o {

    /* renamed from: a  reason: collision with root package name */
    private int[] f3306a = new int[8];

    /* renamed from: b  reason: collision with root package name */
    private int f3307b = 0;

    public void a(int i) {
        int[] iArr = this.f3306a;
        int length = iArr.length;
        int i2 = this.f3307b;
        if (length == i2) {
            int[] iArr2 = new int[(i2 + i2)];
            System.arraycopy(iArr, 0, iArr2, 0, i2);
            this.f3306a = iArr2;
        }
        int[] iArr3 = this.f3306a;
        int i3 = this.f3307b;
        this.f3307b = i3 + 1;
        iArr3[i3] = i;
    }

    public int a() {
        this.f3307b--;
        return this.f3306a[this.f3307b];
    }

    public int b() {
        return this.f3307b;
    }

    public int[] c() {
        return this.f3306a;
    }

    public void d() {
        this.f3307b = 0;
        if (this.f3306a.length != 8) {
            this.f3306a = new int[8];
        }
    }
}
