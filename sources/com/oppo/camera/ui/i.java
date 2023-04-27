package com.oppo.camera.ui;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.oppo.camera.e;

/* compiled from: CountDownUI */
public class i {

    /* renamed from: a  reason: collision with root package name */
    private long f4011a = 0;

    /* renamed from: b  reason: collision with root package name */
    private long f4012b = 0;
    private long c = 0;
    private e d = null;
    private Handler e = null;
    /* access modifiers changed from: private */
    public a f = null;

    /* compiled from: CountDownUI */
    public interface a {
        void a();

        void a(boolean z);
    }

    public i(e eVar, a aVar) {
        this.d = eVar;
        this.f = aVar;
        this.e = new Handler(Looper.getMainLooper()) {
            public void handleMessage(Message message) {
                int i = message.what;
                if (i == 2) {
                    i.this.f.a();
                } else if (i == 3) {
                    i.this.f.a(false);
                } else if (i == 4) {
                    i.this.f.a(true);
                }
            }
        };
    }

    public void a() {
        this.c = 0;
        this.e.removeMessages(2);
        this.e.sendEmptyMessage(4);
    }

    public void a(long j) {
        this.c = j;
    }

    public long b() {
        return this.c;
    }

    public void c() {
        this.f4011a = SystemClock.uptimeMillis();
        this.f4012b = 1000;
    }

    public void d() {
        long uptimeMillis = SystemClock.uptimeMillis();
        long j = uptimeMillis - this.f4011a;
        this.c -= j;
        this.f4012b += j;
        this.f4011a = uptimeMillis;
        long j2 = this.c;
        if (j2 < 0) {
            j2 = 0;
        }
        if (this.f4012b >= 1000) {
            e.b("CountDownUI", "updateCountdownTime, currentTime: " + j2 + ", delta: " + j + ", mCountDownTemp: " + this.f4012b);
            long j3 = this.f4012b - 1000;
            this.c = this.c + j3;
            this.f4012b = 0;
            this.d.a(j3 + j2, false);
        }
        if (j2 > 0) {
            this.e.sendEmptyMessageDelayed(2, 100);
        } else {
            this.e.sendEmptyMessage(3);
        }
    }
}
