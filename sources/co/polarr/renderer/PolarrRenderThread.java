package co.polarr.renderer;

import a.a.b.b.c;
import a.a.b.d;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.HandlerThread;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PolarrRenderThread extends HandlerThread {

    /* renamed from: a  reason: collision with root package name */
    public final Resources f1422a;

    /* renamed from: b  reason: collision with root package name */
    public d f1423b = null;
    public c c;
    public Handler d;
    public boolean e = false;

    public class porender_YuvEf implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Bitmap f1424a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ List f1425b;
        public final /* synthetic */ RenderCallback c;

        public porender_YuvEf(Bitmap bitmap, List list, RenderCallback renderCallback) {
            this.f1424a = bitmap;
            this.f1425b = list;
            this.c = renderCallback;
        }

        public void run() {
            ArrayList arrayList = new ArrayList();
            PolarrRenderThread.this.f1423b.c(this.f1424a.getWidth(), this.f1424a.getHeight());
            for (String a2 : this.f1425b) {
                arrayList.add(PolarrRenderThread.this.f1423b.a(this.f1424a, a2));
            }
            this.c.onRenderBitmap(arrayList);
        }
    }

    public class porender_iuAiH implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ RenderCallback f1426a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Bitmap f1427b;
        public final /* synthetic */ List c;

        public porender_iuAiH(RenderCallback renderCallback, Bitmap bitmap, List list) {
            this.f1426a = renderCallback;
            this.f1427b = bitmap;
            this.c = list;
        }

        public void run() {
            if (this.f1426a != null) {
                ArrayList arrayList = new ArrayList();
                PolarrRenderThread.this.f1423b.c(this.f1427b.getWidth(), this.f1427b.getHeight());
                for (Map a2 : this.c) {
                    arrayList.add(PolarrRenderThread.this.f1423b.a(this.f1427b, (Map<String, Object>) a2));
                }
                this.f1426a.onRenderBitmap(arrayList);
            }
        }
    }

    public class porender_pefpG implements Runnable {
        public porender_pefpG() {
        }

        public void run() {
            PolarrRenderThread.this.b();
            PolarrRenderThread.super.interrupt();
            PolarrRenderThread.this.d.getLooper().quit();
            Handler unused = PolarrRenderThread.this.d = null;
        }
    }

    public class porender_qbdmL implements Runnable {
        public porender_qbdmL() {
        }

        public void run() {
            PolarrRenderThread.this.a();
        }
    }

    public PolarrRenderThread(Resources resources) {
        super("PolarrRenderThread");
        this.f1422a = resources;
    }

    public final void a() {
        this.c = new c();
        this.c.a(100, 100);
        this.f1423b = new d();
        this.f1423b.a(this.f1422a, 1, 1, !this.e, 0);
        this.f1423b.c();
    }

    public final void b() {
        this.f1423b.o();
        this.c.a();
    }

    public void interrupt() {
        this.d.post(new porender_pefpG());
    }

    public void renderBitmap(Bitmap bitmap, List<String> list, RenderCallback renderCallback) {
        if (renderCallback != null && bitmap != null && !bitmap.isRecycled() && bitmap.getWidth() > 0 && bitmap.getHeight() > 0 && list != null && !list.isEmpty()) {
            this.d.post(new porender_YuvEf(bitmap, list, renderCallback));
        }
    }

    public void renderBitmapByStates(Bitmap bitmap, List<Map<String, Object>> list, RenderCallback renderCallback) {
        if (bitmap != null && !bitmap.isRecycled() && bitmap.getWidth() > 0 && bitmap.getHeight() > 0 && list != null && !list.isEmpty()) {
            this.d.post(new porender_iuAiH(renderCallback, bitmap, list));
        }
    }

    public void start() {
        synchronized (this) {
            super.start();
            this.d = new Handler(getLooper());
            this.d.post(new porender_qbdmL());
        }
    }
}
