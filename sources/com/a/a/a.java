package com.a.a;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Handler;
import android.os.SystemClock;
import android.view.Choreographer;

/* compiled from: AndroidSpringLooperFactory */
abstract class a {
    public static i a() {
        if (Build.VERSION.SDK_INT >= 16) {
            return C0051a.a();
        }
        return b.a();
    }

    /* compiled from: AndroidSpringLooperFactory */
    private static class b extends i {
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final Handler f1593b;
        /* access modifiers changed from: private */
        public final Runnable c = new Runnable() {
            public void run() {
                if (b.this.d && b.this.f1605a != null) {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    b.this.f1605a.b((double) (uptimeMillis - b.this.e));
                    long unused = b.this.e = uptimeMillis;
                    b.this.f1593b.post(b.this.c);
                }
            }
        };
        /* access modifiers changed from: private */
        public boolean d;
        /* access modifiers changed from: private */
        public long e;

        public static i a() {
            return new b(new Handler());
        }

        public b(Handler handler) {
            this.f1593b = handler;
        }

        public void b() {
            if (!this.d) {
                this.d = true;
                this.e = SystemClock.uptimeMillis();
                this.f1593b.removeCallbacks(this.c);
                this.f1593b.post(this.c);
            }
        }

        public void c() {
            this.d = false;
            this.f1593b.removeCallbacks(this.c);
        }
    }

    @TargetApi(16)
    /* renamed from: com.a.a.a$a  reason: collision with other inner class name */
    /* compiled from: AndroidSpringLooperFactory */
    private static class C0051a extends i {
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final Choreographer f1591b;
        /* access modifiers changed from: private */
        public final Choreographer.FrameCallback c = new Choreographer.FrameCallback() {
            public void doFrame(long j) {
                if (C0051a.this.d && C0051a.this.f1605a != null) {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    C0051a.this.f1605a.b((double) (uptimeMillis - C0051a.this.e));
                    long unused = C0051a.this.e = uptimeMillis;
                    C0051a.this.f1591b.postFrameCallback(C0051a.this.c);
                }
            }
        };
        /* access modifiers changed from: private */
        public boolean d;
        /* access modifiers changed from: private */
        public long e;

        public static C0051a a() {
            return new C0051a(Choreographer.getInstance());
        }

        public C0051a(Choreographer choreographer) {
            this.f1591b = choreographer;
        }

        public void b() {
            if (!this.d) {
                this.d = true;
                this.e = SystemClock.uptimeMillis();
                this.f1591b.removeFrameCallback(this.c);
                this.f1591b.postFrameCallback(this.c);
            }
        }

        public void c() {
            this.d = false;
            this.f1591b.removeFrameCallback(this.c);
        }
    }
}
