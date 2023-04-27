package com.oppo.camera.ui.control;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;

/* compiled from: ThumbnailHolder */
public class g {

    /* renamed from: a  reason: collision with root package name */
    private static e f3921a;

    /* compiled from: ThumbnailHolder */
    private static class a {

        /* renamed from: a  reason: collision with root package name */
        public static final HandlerThread f3922a = new HandlerThread("ClearThumbnail");

        /* renamed from: b  reason: collision with root package name */
        public static final Handler f3923b = new Handler(f3922a.getLooper(), new Handler.Callback() {
            public boolean handleMessage(Message message) {
                if (message.what == 1) {
                    g.a();
                }
                return true;
            }
        });

        static {
            f3922a.start();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001f, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized com.oppo.camera.ui.control.e a(android.content.ContentResolver r4) {
        /*
            java.lang.Class<com.oppo.camera.ui.control.g> r0 = com.oppo.camera.ui.control.g.class
            monitor-enter(r0)
            com.oppo.camera.ui.control.e r1 = f3921a     // Catch:{ all -> 0x0020 }
            r2 = 0
            if (r1 == 0) goto L_0x001e
            android.os.Handler r1 = com.oppo.camera.ui.control.g.a.f3923b     // Catch:{ all -> 0x0020 }
            r3 = 1
            r1.removeMessages(r3)     // Catch:{ all -> 0x0020 }
            com.oppo.camera.ui.control.e r1 = f3921a     // Catch:{ all -> 0x0020 }
            f3921a = r2     // Catch:{ all -> 0x0020 }
            android.net.Uri r3 = r1.d()     // Catch:{ all -> 0x0020 }
            boolean r4 = com.oppo.camera.util.Util.a((android.net.Uri) r3, (android.content.ContentResolver) r4)     // Catch:{ all -> 0x0020 }
            if (r4 == 0) goto L_0x001e
            monitor-exit(r0)
            return r1
        L_0x001e:
            monitor-exit(r0)
            return r2
        L_0x0020:
            r4 = move-exception
            monitor-exit(r0)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.ui.control.g.a(android.content.ContentResolver):com.oppo.camera.ui.control.e");
    }

    public static synchronized void a() {
        synchronized (g.class) {
            a.f3923b.removeMessages(1);
            f3921a = null;
        }
    }

    public static synchronized void a(e eVar) {
        synchronized (g.class) {
            f3921a = eVar;
            a.f3923b.removeMessages(1);
            a.f3923b.sendEmptyMessageDelayed(1, 3000);
        }
    }
}
