package com.oppo.camera.v;

import android.os.Handler;
import android.os.Looper;

/* compiled from: CameraHandler */
public class b extends Handler {

    /* renamed from: a  reason: collision with root package name */
    private Looper f4633a = null;

    public b(Looper looper) {
        super(looper);
        this.f4633a = looper;
    }

    public void a(Runnable runnable) {
        if (Looper.myLooper() == this.f4633a) {
            runnable.run();
        } else {
            super.post(runnable);
        }
    }
}
