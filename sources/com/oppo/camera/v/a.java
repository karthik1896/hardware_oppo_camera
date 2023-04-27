package com.oppo.camera.v;

import android.content.Context;
import com.heytap.providers.a;
import com.oppo.camera.e;
import com.oppo.camera.statistics.CameraStatisticsUtil;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;

/* compiled from: CameraDataCollection */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static a f4631a = null;

    /* renamed from: b  reason: collision with root package name */
    private static String f4632b = "CameraDataCollection";
    private ExecutorService c;

    public static a a() {
        a aVar;
        synchronized (a.class) {
            if (f4631a == null) {
                f4631a = new a();
            }
            aVar = f4631a;
        }
        return aVar;
    }

    private a() {
        this.c = null;
        this.c = Executors.newSingleThreadExecutor();
    }

    public static void b() {
        synchronized (a.class) {
            if (f4631a != null) {
                f4631a.c();
            }
            f4631a = null;
        }
    }

    private void c() {
        ExecutorService executorService = this.c;
        if (executorService != null) {
            executorService.shutdownNow();
            this.c = null;
        }
    }

    public void a(Context context, String str, Object obj) {
        ExecutorService executorService = this.c;
        if (executorService != null && context != null && str != null && obj != null) {
            try {
                executorService.submit(new Runnable(str, obj, context) {
                    private final /* synthetic */ String f$0;
                    private final /* synthetic */ Object f$1;
                    private final /* synthetic */ Context f$2;

                    {
                        this.f$0 = r1;
                        this.f$1 = r2;
                        this.f$2 = r3;
                    }

                    public final void run() {
                        a.a(this.f$0, this.f$1, this.f$2);
                    }
                });
            } catch (RejectedExecutionException e) {
                e.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void a(String str, Object obj, Context context) {
        e.b(f4632b, String.format("putSetting, %s: %s", new Object[]{str, obj}));
        if (obj instanceof Integer) {
            if (CameraStatisticsUtil.PORTRAIT_CAPTURE_MODE.equals(str)) {
                e.b(f4632b, String.format("putSetting, %s: 0x%x", new Object[]{str, obj}));
            }
            a.d.b(context.getContentResolver(), str, ((Integer) obj).intValue());
        } else if (obj instanceof String) {
            a.d.a(context.getContentResolver(), str, (String) obj);
        }
    }
}
