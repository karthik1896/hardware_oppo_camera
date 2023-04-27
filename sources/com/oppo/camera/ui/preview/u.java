package com.oppo.camera.ui.preview;

import android.graphics.Color;
import android.os.SystemClock;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import com.oppo.camera.gl.h;
import com.oppo.camera.gl.s;

/* compiled from: VideoCaptureAnimManager */
public class u {

    /* renamed from: a  reason: collision with root package name */
    private final Interpolator f4568a = new DecelerateInterpolator();

    /* renamed from: b  reason: collision with root package name */
    private int f4569b;
    private long c;
    private float d;
    private float e;
    private float f;
    private int g;
    private int h;
    private int i;

    public void a(int i2, int i3, int i4, int i5) {
        this.c = SystemClock.uptimeMillis();
        this.g = i4;
        this.h = i5;
        this.d = (float) i2;
        this.e = (float) i3;
        int i6 = this.f4569b;
        if (i6 == 0) {
            this.f = (float) i4;
        } else if (i6 == 90) {
            this.f = (float) (-i5);
        } else if (i6 == 180) {
            this.f = (float) (-i4);
        } else if (i6 == 270) {
            this.f = (float) i5;
        }
    }

    public boolean a(h hVar, e eVar, s sVar) {
        long uptimeMillis = SystemClock.uptimeMillis() - this.c;
        if (this.i == 2 && uptimeMillis > 400) {
            return false;
        }
        if (this.i == 0 && uptimeMillis > 800) {
            return false;
        }
        int i2 = this.i;
        if (i2 == 0) {
            i2 = uptimeMillis < 400 ? 1 : 2;
            if (i2 == 2) {
                uptimeMillis -= 400;
            }
        }
        if (i2 == 1) {
            sVar.a(hVar, (int) this.d, (int) this.e, this.g, this.h);
            if (uptimeMillis < 200) {
                hVar.a(this.d, this.e, (float) this.g, (float) this.h, Color.argb((int) ((0.3f - ((((float) uptimeMillis) * 0.3f) / 200.0f)) * 255.0f), 255, 255, 255));
            }
        } else if (i2 != 2) {
            return false;
        } else {
            eVar.a(hVar, (int) this.d, (int) this.e, this.g, this.h);
        }
        return true;
    }
}
