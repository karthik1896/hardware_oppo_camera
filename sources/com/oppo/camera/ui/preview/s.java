package com.oppo.camera.ui.preview;

import android.app.Activity;
import android.content.Context;
import android.os.SystemClock;
import android.view.animation.PathInterpolator;
import com.oppo.camera.gl.c;
import com.oppo.camera.gl.h;
import com.oppo.camera.ui.preview.e;

/* compiled from: SwitchAnimManager */
public class s implements b {

    /* renamed from: a  reason: collision with root package name */
    private static final float[] f4562a = {70.0f, 110.0f};

    /* renamed from: b  reason: collision with root package name */
    private static final float[] f4563b = {0.2f, 0.25f};
    private static float c = 600.0f;
    private long d = 0;
    private int e = 0;
    private int f = 0;
    private int g = 0;
    private a h = new a(0.27f, 0.5f, 0.25f, 1.0f);
    private float i = 0.0f;
    private Context j = null;
    private float k = 0.0f;
    private float l = 0.0f;
    private float m = 0.0f;
    private float n = 1.0f;
    /* access modifiers changed from: private */
    public e.c o;

    public void a(int i2) {
        c = (float) i2;
    }

    public void a(int i2, int i3) {
        this.e = i2;
        this.f = i3;
    }

    public void b(int i2, int i3) {
        this.g = i2;
    }

    public void a(Context context, e.c cVar) {
        this.d = SystemClock.uptimeMillis();
        this.i = context.getResources().getDisplayMetrics().density;
        this.j = context;
        float[] fArr = f4562a;
        this.k = (fArr[1] - fArr[0]) / 2.0f;
        float[] fArr2 = f4563b;
        this.l = (fArr2[1] - fArr2[0]) / this.k;
        this.o = cVar;
    }

    public boolean a(h hVar, int i2, int i3, int i4, int i5, c cVar) {
        Context context;
        h hVar2 = hVar;
        int i6 = i5;
        float uptimeMillis = (float) (SystemClock.uptimeMillis() - this.d);
        float f2 = c;
        if (uptimeMillis > f2) {
            return false;
        }
        float interpolation = this.h.getInterpolation(uptimeMillis / f2);
        if (this.m <= 0.5f && interpolation > 0.5f && (context = this.j) != null) {
            ((Activity) context).runOnUiThread(new Runnable() {
                public void run() {
                    if (s.this.o != null) {
                        s.this.o.b();
                    }
                }
            });
        }
        this.m = interpolation;
        a(hVar2, interpolation, 180.0f * interpolation);
        float f3 = (float) i4;
        float f4 = ((float) i2) + (f3 / 2.0f);
        float f5 = (float) i6;
        float f6 = ((float) i3) + (f5 / 2.0f);
        if (interpolation < 0.1f) {
            float f7 = 1.0f - ((interpolation / 0.1f) * 0.1f);
            float f8 = f3 * f7;
            float f9 = f7 * f5;
            cVar.a(hVar, Math.round(f4 - (f8 / 2.0f)), Math.round(f6 - (f9 / 2.0f)), Math.round(f8), Math.round(f9));
            return true;
        }
        float f10 = interpolation - 0.1f;
        if (f10 < 0.8f) {
            float f11 = f3 * 0.9f;
            float f12 = f5 * 0.9f;
            int round = Math.round(f4 - (f11 / 2.0f));
            int round2 = Math.round(f6 - (f12 / 2.0f));
            if (f10 < 0.4f) {
                hVar2.a(f4, 0.0f);
                hVar.a((f10 / 0.4f) * 90.0f, 0.0f, 1.0f, 0.0f, 0.0f, (float) (i6 / 2), f5 * this.i);
                hVar2.a(-f4, 0.0f);
                cVar.a(hVar, round, round2, Math.round(f11), Math.round(f12));
                return true;
            }
            hVar2.a(f4, 0.0f);
            hVar.a(270.0f + (((f10 - 0.4f) / 0.4f) * 90.0f), 0.0f, 1.0f, 0.0f, 0.0f, (float) (i6 / 2), f5 * this.i);
            hVar2.a(-f4, 0.0f);
            cVar.a(hVar, round, round2, Math.round(f11), Math.round(f12));
            return true;
        }
        float f13 = 1.0f - (((1.0f - interpolation) / 0.1f) * 0.1f);
        float f14 = f3 * f13;
        float f15 = f13 * f5;
        cVar.a(hVar, Math.round(f4 - (f14 / 2.0f)), Math.round(f6 - (f15 / 2.0f)), Math.round(f14), Math.round(f15));
        return true;
    }

    public boolean b(h hVar, int i2, int i3, int i4, int i5, c cVar) {
        float f2;
        float f3 = (float) i4;
        float f4 = ((float) i2) + (f3 / 2.0f);
        float f5 = ((float) i3) + (((float) i5) / 2.0f);
        int i6 = this.g;
        if (i6 != 0) {
            f2 = f3 / ((float) i6);
        } else {
            com.oppo.camera.e.e("SwitchAnimManager", "mPreviewFrameLayoutWidth is 0.");
            f2 = 1.0f;
        }
        float f6 = ((float) this.e) * f2;
        float f7 = ((float) this.f) * f2;
        int round = Math.round(f4 - (f6 / 2.0f));
        int round2 = Math.round(f5 - (f7 / 2.0f));
        float b2 = hVar.b();
        hVar.a(0.8f);
        cVar.a(hVar, round, round2, Math.round(f6), Math.round(f7));
        hVar.a(b2);
        return true;
    }

    private void a(h hVar, float f2, float f3) {
        float f4 = (1.0f - (f2 * f2)) + 0.4f;
        if (f2 >= 0.7f) {
            hVar.a(f4);
            this.n = f4;
        }
        float[] fArr = f4562a;
        if (fArr[0] <= f3 && f3 <= fArr[1]) {
            float abs = (Math.abs(90.0f - f3) * this.l) + f4563b[0];
            hVar.a(abs);
            this.n = abs;
        }
    }

    public float a() {
        return this.n;
    }

    /* compiled from: SwitchAnimManager */
    private class a extends PathInterpolator {
        a(float f, float f2, float f3, float f4) {
            super(f, f2, f3, f4);
        }
    }
}
