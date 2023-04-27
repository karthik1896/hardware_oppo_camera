package com.oppo.camera.ui.preview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

public class FocusIndicatorRotateLayout extends View implements j {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public int f4337a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public Runnable f4338b = new a();
    private Runnable c = new b();
    private boolean d = false;

    public FocusIndicatorRotateLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void a() {
        if (!this.d) {
            c();
            if (this.f4337a == 0) {
                setVisibility(0);
                animate().cancel();
                animate().withLayer().setDuration(160).scaleX(0.55f).scaleY(0.55f);
                this.f4337a = 1;
            }
        }
    }

    public void a(boolean z, boolean z2) {
        a(z, false, z2);
    }

    public void a(boolean z, boolean z2, boolean z3) {
        if (!this.d && !z3) {
            if (z2 || this.f4337a == 1) {
                setVisibility(0);
                animate().cancel();
                animate().withLayer().setDuration(100).scaleX(0.55f).scaleY(0.55f).withEndAction(z ? this.c : null);
                this.f4337a = 2;
            }
        }
    }

    public void b(boolean z, boolean z2) {
        if (!this.d && !z2 && this.f4337a == 1) {
            setVisibility(0);
            animate().cancel();
            animate().withLayer().setDuration(100).scaleX(0.55f).scaleY(0.55f).withEndAction(z ? this.c : null);
            this.f4337a = 2;
        }
    }

    public boolean b() {
        return this.f4337a == 0;
    }

    public void c() {
        animate().cancel();
        removeCallbacks(this.f4338b);
        this.f4338b.run();
        setScaleX(1.0f);
        setScaleY(1.0f);
    }

    public void d() {
        setVisibility(4);
        setScaleX(0.55f);
        setScaleY(0.55f);
    }

    public void a(boolean z) {
        this.d = z;
    }

    private class b implements Runnable {
        private b() {
        }

        public void run() {
            FocusIndicatorRotateLayout focusIndicatorRotateLayout = FocusIndicatorRotateLayout.this;
            focusIndicatorRotateLayout.postDelayed(focusIndicatorRotateLayout.f4338b, 200);
        }
    }

    private class a implements Runnable {
        private a() {
        }

        public void run() {
            FocusIndicatorRotateLayout.this.setVisibility(4);
            int unused = FocusIndicatorRotateLayout.this.f4337a = 0;
        }
    }
}
