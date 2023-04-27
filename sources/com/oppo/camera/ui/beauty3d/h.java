package com.oppo.camera.ui.beauty3d;

import android.widget.ImageView;

/* compiled from: FrameAnimation */
public class h {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public ImageView f3875a = null;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public int[] f3876b = null;
    private int c = 0;
    /* access modifiers changed from: private */
    public int d = 0;
    /* access modifiers changed from: private */
    public boolean e = true;
    /* access modifiers changed from: private */
    public boolean f = true;
    /* access modifiers changed from: private */
    public a g = new a();

    public h(ImageView imageView, int[] iArr, int i, boolean z) {
        this.f3875a = imageView;
        this.f3876b = iArr;
        this.c = i;
        this.d = iArr.length - 1;
        this.f = z;
    }

    /* access modifiers changed from: private */
    public void a(int i, boolean z) {
        ImageView imageView = this.f3875a;
        if (imageView != null) {
            if (i == 0 && z) {
                imageView.setBackgroundResource(this.f3876b[0]);
                i++;
            }
            a aVar = this.g;
            if (aVar != null) {
                aVar.a(i);
                this.f3875a.postDelayed(this.g, (long) this.c);
            }
        }
    }

    public void a() {
        this.e = true;
        ImageView imageView = this.f3875a;
        if (imageView != null) {
            imageView.removeCallbacks(this.g);
        }
    }

    public boolean b() {
        return this.e;
    }

    public boolean c() {
        return !this.e;
    }

    public void d() {
        if (this.e) {
            this.e = false;
            a(0, true);
        }
    }

    /* compiled from: FrameAnimation */
    private class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        private int f3878b;

        private a() {
            this.f3878b = 0;
        }

        public void a(int i) {
            this.f3878b = i;
        }

        public void run() {
            if (h.this.e) {
                h.this.f3875a.removeCallbacks(h.this.g);
                return;
            }
            h.this.f3875a.setBackgroundResource(h.this.f3876b[this.f3878b]);
            if (this.f3878b != h.this.d) {
                h.this.a(this.f3878b + 1, false);
            } else if (h.this.f) {
                h.this.a(0, false);
            }
        }
    }
}
