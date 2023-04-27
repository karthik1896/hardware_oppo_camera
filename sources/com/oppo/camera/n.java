package com.oppo.camera;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicYuvToRGB;
import android.renderscript.Type;
import android.util.Size;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.oppo.camera.jni.FormatConverter;
import com.oppo.camera.ui.j;
import com.oppo.camera.util.Util;

/* compiled from: HistogramProcessorManager */
public class n {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public int f3131a = 0;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public int f3132b = 0;
    private boolean c = false;
    /* access modifiers changed from: private */
    public Handler d = null;
    private Resources e = null;
    private ViewGroup f = null;
    /* access modifiers changed from: private */
    public j g = null;
    /* access modifiers changed from: private */
    public final Object h = new Object();
    private RenderScript i = null;
    private Context j = null;
    /* access modifiers changed from: private */
    public ScriptIntrinsicYuvToRGB k = null;
    /* access modifiers changed from: private */
    public Allocation l = null;
    /* access modifiers changed from: private */
    public Allocation m = null;
    /* access modifiers changed from: private */
    public byte[] n = null;
    /* access modifiers changed from: private */
    public float[] o = null;
    /* access modifiers changed from: private */
    public float[] p = null;
    /* access modifiers changed from: private */
    public float[] q = null;
    /* access modifiers changed from: private */
    public float[] r = null;
    /* access modifiers changed from: private */
    public FormatConverter s = new FormatConverter();
    private Handler t = null;

    public n(Context context, View view) {
        this.j = context;
        this.e = context.getResources();
        this.f = (ViewGroup) view;
    }

    public void a() {
        e.a("HistogramProcessorManager", "showHistogram");
        if (this.g == null) {
            this.g = new j(this.j);
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.f.getLayoutParams());
        layoutParams.width = this.e.getDimensionPixelSize(R.dimen.histogram_graph_view_width);
        layoutParams.height = this.e.getDimensionPixelSize(R.dimen.histogram_graph_view_height);
        layoutParams.addRule(12);
        layoutParams.bottomMargin = this.e.getDimensionPixelSize(R.dimen.histogram_margin_bottom) + Util.aj();
        layoutParams.leftMargin = this.e.getDimensionPixelSize(R.dimen.histogram_margin_left);
        this.f.removeView(this.g);
        this.f.addView(this.g, layoutParams);
        this.c = true;
        this.g.setRotation(90.0f);
        this.g.setVisibility(0);
        this.g.invalidate();
    }

    public void b() {
        e.a("HistogramProcessorManager", "updateHistogramLayout");
        if (this.g != null && e()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.g.getLayoutParams();
            layoutParams.bottomMargin = this.e.getDimensionPixelSize(R.dimen.histogram_margin_bottom) + Util.aj();
            this.g.setLayoutParams(layoutParams);
        }
    }

    private boolean e() {
        return this.c && this.f.indexOfChild(this.g) != -1;
    }

    @SuppressLint({"HandlerLeak"})
    public void a(Size size) {
        this.f3131a = size.getHeight();
        this.f3132b = size.getWidth();
        e.a("HistogramProcessorManager", "HistogramProcessorManager onOpen, mSizeHeight: " + this.f3131a + ", mSizeWidth: " + this.f3132b);
        synchronized (this.h) {
            this.i = RenderScript.create(this.j);
            this.k = ScriptIntrinsicYuvToRGB.create(this.i, Element.U8_4(this.i));
            this.l = Allocation.createTyped(this.i, new Type.Builder(this.i, Element.U8(this.i)).setX(((this.f3132b * this.f3131a) * 3) / 2).create(), 1);
            this.m = Allocation.createTyped(this.i, new Type.Builder(this.i, Element.RGBA_8888(this.i)).setX(this.f3132b).setY(this.f3131a).create(), 1);
            this.n = new byte[(this.f3132b * this.f3131a * 4)];
            this.o = new float[1];
            this.p = new float[256];
            this.q = new float[256];
            this.r = new float[256];
        }
        if (this.t == null) {
            this.t = new a();
        }
        if (this.d == null) {
            this.d = new Handler(Looper.getMainLooper());
        }
    }

    public void c() {
        e.a("HistogramProcessorManager", "stopAndHideHistogram");
        ViewGroup viewGroup = this.f;
        if (viewGroup != null) {
            viewGroup.removeView(this.g);
        }
        this.c = false;
        Handler handler = this.t;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
        }
        Handler handler2 = this.d;
        if (handler2 != null) {
            handler2.removeCallbacksAndMessages((Object) null);
        }
    }

    public void d() {
        e.a("HistogramProcessorManager", "HistogramProcessorManager onClose");
        c();
        if (this.m != null) {
            synchronized (this.h) {
                if (this.l != null) {
                    this.l.destroy();
                }
                if (this.m != null) {
                    this.m.destroy();
                }
                this.m = null;
                this.l = null;
            }
            RenderScript renderScript = this.i;
            if (renderScript != null) {
                renderScript.destroy();
                this.i = null;
            }
            this.n = null;
            this.o = null;
            this.p = null;
            this.r = null;
            this.q = null;
            this.t = null;
            this.d = null;
        }
    }

    public void a(byte[] bArr) {
        if (this.m != null) {
            if (!e()) {
                this.d.post(new Runnable() {
                    public void run() {
                        n.this.a();
                    }
                });
            }
            Handler handler = this.t;
            if (handler != null) {
                Message obtainMessage = handler.obtainMessage(1);
                obtainMessage.obj = bArr;
                this.t.removeMessages(1);
                this.t.sendMessage(obtainMessage);
            }
        }
    }

    /* compiled from: HistogramProcessorManager */
    private class a extends Handler {
        private a() {
        }

        /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void handleMessage(android.os.Message r11) {
            /*
                r10 = this;
                int r0 = r11.what
                r1 = 1
                if (r0 == r1) goto L_0x0007
                goto L_0x00a6
            L_0x0007:
                com.oppo.camera.n r0 = com.oppo.camera.n.this
                java.lang.Object r0 = r0.h
                monitor-enter(r0)
                com.oppo.camera.n r1 = com.oppo.camera.n.this     // Catch:{ RSIllegalArgumentException -> 0x009a }
                android.renderscript.Allocation r1 = r1.l     // Catch:{ RSIllegalArgumentException -> 0x009a }
                if (r1 != 0) goto L_0x0018
                monitor-exit(r0)     // Catch:{ all -> 0x0098 }
                return
            L_0x0018:
                java.lang.Object r11 = r11.obj     // Catch:{ RSIllegalArgumentException -> 0x009a }
                byte[] r11 = (byte[]) r11     // Catch:{ RSIllegalArgumentException -> 0x009a }
                byte[] r11 = (byte[]) r11     // Catch:{ RSIllegalArgumentException -> 0x009a }
                com.oppo.camera.n r1 = com.oppo.camera.n.this     // Catch:{ RSIllegalArgumentException -> 0x009a }
                android.renderscript.Allocation r1 = r1.l     // Catch:{ RSIllegalArgumentException -> 0x009a }
                r1.copyFrom(r11)     // Catch:{ RSIllegalArgumentException -> 0x009a }
                com.oppo.camera.n r11 = com.oppo.camera.n.this     // Catch:{ RSIllegalArgumentException -> 0x009a }
                android.renderscript.ScriptIntrinsicYuvToRGB r11 = r11.k     // Catch:{ RSIllegalArgumentException -> 0x009a }
                com.oppo.camera.n r1 = com.oppo.camera.n.this     // Catch:{ RSIllegalArgumentException -> 0x009a }
                android.renderscript.Allocation r1 = r1.l     // Catch:{ RSIllegalArgumentException -> 0x009a }
                r11.setInput(r1)     // Catch:{ RSIllegalArgumentException -> 0x009a }
                com.oppo.camera.n r11 = com.oppo.camera.n.this     // Catch:{ RSIllegalArgumentException -> 0x009a }
                android.renderscript.ScriptIntrinsicYuvToRGB r11 = r11.k     // Catch:{ RSIllegalArgumentException -> 0x009a }
                com.oppo.camera.n r1 = com.oppo.camera.n.this     // Catch:{ RSIllegalArgumentException -> 0x009a }
                android.renderscript.Allocation r1 = r1.m     // Catch:{ RSIllegalArgumentException -> 0x009a }
                r11.forEach(r1)     // Catch:{ RSIllegalArgumentException -> 0x009a }
                com.oppo.camera.n r11 = com.oppo.camera.n.this     // Catch:{ RSIllegalArgumentException -> 0x009a }
                android.renderscript.Allocation r11 = r11.m     // Catch:{ RSIllegalArgumentException -> 0x009a }
                com.oppo.camera.n r1 = com.oppo.camera.n.this     // Catch:{ RSIllegalArgumentException -> 0x009a }
                byte[] r1 = r1.n     // Catch:{ RSIllegalArgumentException -> 0x009a }
                r11.copyTo(r1)     // Catch:{ RSIllegalArgumentException -> 0x009a }
                com.oppo.camera.n r11 = com.oppo.camera.n.this     // Catch:{ RSIllegalArgumentException -> 0x009a }
                com.oppo.camera.jni.FormatConverter r1 = r11.s     // Catch:{ RSIllegalArgumentException -> 0x009a }
                com.oppo.camera.n r11 = com.oppo.camera.n.this     // Catch:{ RSIllegalArgumentException -> 0x009a }
                byte[] r2 = r11.n     // Catch:{ RSIllegalArgumentException -> 0x009a }
                com.oppo.camera.n r11 = com.oppo.camera.n.this     // Catch:{ RSIllegalArgumentException -> 0x009a }
                float[] r3 = r11.o     // Catch:{ RSIllegalArgumentException -> 0x009a }
                com.oppo.camera.n r11 = com.oppo.camera.n.this     // Catch:{ RSIllegalArgumentException -> 0x009a }
                int r4 = r11.f3131a     // Catch:{ RSIllegalArgumentException -> 0x009a }
                com.oppo.camera.n r11 = com.oppo.camera.n.this     // Catch:{ RSIllegalArgumentException -> 0x009a }
                int r5 = r11.f3132b     // Catch:{ RSIllegalArgumentException -> 0x009a }
                r6 = 8
                com.oppo.camera.n r11 = com.oppo.camera.n.this     // Catch:{ RSIllegalArgumentException -> 0x009a }
                float[] r7 = r11.p     // Catch:{ RSIllegalArgumentException -> 0x009a }
                com.oppo.camera.n r11 = com.oppo.camera.n.this     // Catch:{ RSIllegalArgumentException -> 0x009a }
                float[] r8 = r11.q     // Catch:{ RSIllegalArgumentException -> 0x009a }
                com.oppo.camera.n r11 = com.oppo.camera.n.this     // Catch:{ RSIllegalArgumentException -> 0x009a }
                float[] r9 = r11.r     // Catch:{ RSIllegalArgumentException -> 0x009a }
                r1.statisticsHistogramRGB(r2, r3, r4, r5, r6, r7, r8, r9)     // Catch:{ RSIllegalArgumentException -> 0x009a }
                com.oppo.camera.n r11 = com.oppo.camera.n.this     // Catch:{ RSIllegalArgumentException -> 0x009a }
                android.os.Handler r11 = r11.d     // Catch:{ RSIllegalArgumentException -> 0x009a }
                com.oppo.camera.n$a$1 r1 = new com.oppo.camera.n$a$1     // Catch:{ RSIllegalArgumentException -> 0x009a }
                r1.<init>()     // Catch:{ RSIllegalArgumentException -> 0x009a }
                r11.post(r1)     // Catch:{ RSIllegalArgumentException -> 0x009a }
                goto L_0x00a5
            L_0x0098:
                r11 = move-exception
                goto L_0x00a7
            L_0x009a:
                r11 = move-exception
                r11.printStackTrace()     // Catch:{ all -> 0x0098 }
                java.lang.String r11 = "HistogramProcessorManager"
                java.lang.String r1 = "Array too small for allocation type."
                com.oppo.camera.e.e(r11, r1)     // Catch:{ all -> 0x0098 }
            L_0x00a5:
                monitor-exit(r0)     // Catch:{ all -> 0x0098 }
            L_0x00a6:
                return
            L_0x00a7:
                monitor-exit(r0)     // Catch:{ all -> 0x0098 }
                throw r11
            */
            throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.n.a.handleMessage(android.os.Message):void");
        }
    }
}
