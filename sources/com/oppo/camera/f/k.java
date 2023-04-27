package com.oppo.camera.f;

import android.graphics.Rect;
import android.hardware.camera2.params.MeteringRectangle;
import com.oppo.camera.util.Util;

/* compiled from: OppoMeteringRectangle */
public final class k {

    /* renamed from: a  reason: collision with root package name */
    private final int f3243a;

    /* renamed from: b  reason: collision with root package name */
    private final int f3244b;
    private final int c;
    private final int d;
    private final int e;

    public k(MeteringRectangle meteringRectangle) {
        this.f3243a = meteringRectangle.getX();
        this.f3244b = meteringRectangle.getY();
        this.c = meteringRectangle.getWidth();
        this.d = meteringRectangle.getHeight();
        this.e = meteringRectangle.getMeteringWeight();
    }

    public k(Rect rect, int i) {
        this.f3243a = rect.left;
        this.f3244b = rect.top;
        this.c = rect.width();
        this.d = rect.height();
        this.e = i;
    }

    public int[] a() {
        int i = this.f3243a;
        int i2 = this.f3244b;
        return new int[]{i, i2, i + this.c, i2 + this.d, this.e};
    }

    public int hashCode() {
        return Util.b(this.f3243a, this.f3244b, this.c, this.d, this.e);
    }

    public String toString() {
        return String.format("(x:%d, y:%d, w:%d, h:%d, wt:%d)", new Object[]{Integer.valueOf(this.f3243a), Integer.valueOf(this.f3244b), Integer.valueOf(this.c), Integer.valueOf(this.d), Integer.valueOf(this.e)});
    }
}
