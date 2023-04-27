package com.oppo.camera.gl.b;

import android.graphics.Rect;
import android.view.MotionEvent;
import com.oppo.camera.util.Util;

/* compiled from: MultiVideoSmallSurfaceTouchEventHelper */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private static e f3276a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f3277b = false;
    private boolean c = false;
    private float d = 0.0f;
    private float e = 0.0f;
    private int f = 0;
    private int g = 0;
    private int h = 0;
    private int i = 0;

    private e() {
    }

    public static e a() {
        if (f3276a == null) {
            f3276a = new e();
        }
        return f3276a;
    }

    public boolean a(MotionEvent motionEvent, com.oppo.camera.ui.preview.e eVar) {
        Rect x = eVar.x();
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f3277b = false;
            this.c = false;
            if (x.contains((int) rawX, (int) rawY)) {
                this.f3277b = true;
                this.d = rawX;
                this.e = rawY;
            }
        } else if (action != 1) {
            if (action == 2) {
                float f2 = rawX - this.d;
                float f3 = rawY - this.e;
                if (this.f3277b && !(f2 == 0.0f && f3 == 0.0f)) {
                    this.c = true;
                    this.d = rawX;
                    this.e = rawY;
                    int i2 = (int) (((float) x.left) + f2);
                    int u = Util.u() + this.h;
                    eVar.e(Math.min(Math.max(i2, this.f), (Util.E() - x.width()) - this.g), Math.min(Math.max(u, (int) (((float) x.top) + f3)), ((Util.C() - Util.w()) - x.height()) - this.i));
                    return true;
                }
            }
        } else if (!this.f3277b || !this.c) {
            this.f3277b = false;
            this.c = false;
        } else {
            this.f3277b = false;
            this.c = false;
            return true;
        }
        return false;
    }

    public void a(int i2, int i3, int i4, int i5) {
        this.f = i2;
        this.h = i3;
        this.g = i4;
        this.i = i5;
    }

    public boolean b() {
        return this.c;
    }
}
