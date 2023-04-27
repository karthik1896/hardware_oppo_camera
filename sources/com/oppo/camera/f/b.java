package com.oppo.camera.f;

import android.os.Handler;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

/* compiled from: CameraHandlerExecutor */
public class b implements Executor {

    /* renamed from: a  reason: collision with root package name */
    private Handler f3187a = null;

    public b(Handler handler) {
        if (handler != null) {
            this.f3187a = handler;
            return;
        }
        throw new NullPointerException();
    }

    public void execute(Runnable runnable) {
        if (!this.f3187a.post(runnable)) {
            throw new RejectedExecutionException(this.f3187a + " is shutting down");
        }
    }
}
