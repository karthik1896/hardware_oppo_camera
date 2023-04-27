package com.oppo.camera.k;

import android.hardware.camera2.CameraCaptureSession;
import com.oppo.camera.e;
import com.oppo.camera.f.f;
import com.oppo.camera.k.b;

/* compiled from: FlashControllerCallback */
public class a extends CameraCaptureSession.CaptureCallback {

    /* renamed from: a  reason: collision with root package name */
    private volatile int f3396a = 0;

    /* renamed from: b  reason: collision with root package name */
    protected boolean f3397b = false;
    private boolean c = false;
    private boolean d = false;
    private long e = 0;
    private int f = -1;
    private f g = null;
    private b h = null;
    private b.a i = null;

    public void a() {
    }

    public a(f fVar) {
        this.g = fVar;
        this.h = new b();
        b bVar = this.h;
        bVar.getClass();
        this.i = new b.a();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x005d, code lost:
        r5 = r4.g;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCaptureCompleted(android.hardware.camera2.CameraCaptureSession r5, android.hardware.camera2.CaptureRequest r6, android.hardware.camera2.TotalCaptureResult r7) {
        /*
            r4 = this;
            super.onCaptureCompleted(r5, r6, r7)
            boolean r5 = r4.f3397b
            if (r5 == 0) goto L_0x0088
            if (r7 != 0) goto L_0x000b
            goto L_0x0088
        L_0x000b:
            android.hardware.camera2.CaptureRequest r5 = r7.getRequest()
            android.hardware.camera2.CaptureRequest$Key r6 = android.hardware.camera2.CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER
            java.lang.Object r5 = r5.get(r6)
            java.lang.Integer r5 = (java.lang.Integer) r5
            r6 = 1
            if (r5 == 0) goto L_0x0026
            int r0 = r5.intValue()
            if (r6 != r0) goto L_0x0026
            int r0 = r5.intValue()
            r4.f3396a = r0
        L_0x0026:
            int r0 = r4.f3396a
            if (r6 != r0) goto L_0x0087
            android.hardware.camera2.CaptureResult$Key r0 = android.hardware.camera2.CaptureResult.CONTROL_AE_STATE
            java.lang.Object r0 = r7.get(r0)
            java.lang.Integer r0 = (java.lang.Integer) r0
            android.hardware.camera2.CaptureResult$Key r1 = android.hardware.camera2.CaptureResult.CONTROL_AF_STATE
            java.lang.Object r1 = r7.get(r1)
            java.lang.Integer r1 = (java.lang.Integer) r1
            long r2 = r7.getFrameNumber()
            boolean r7 = r4.c
            if (r7 != 0) goto L_0x0046
            r4.c = r6
            r4.e = r2
        L_0x0046:
            com.oppo.camera.k.b$a r7 = r4.i
            r7.f3401a = r2
            long r2 = r4.e
            r7.f3402b = r2
            r7.c = r5
            r7.d = r0
            r7.e = r1
            java.lang.String r5 = "com.oplus.torch.flash.support"
            boolean r5 = com.oppo.camera.aps.config.CameraConfig.getConfigBooleanValue(r5)
            r0 = 0
            if (r5 == 0) goto L_0x0069
            com.oppo.camera.f.f r5 = r4.g
            if (r5 == 0) goto L_0x0069
            boolean r5 = r5.b()
            if (r5 != 0) goto L_0x0069
            r5 = r6
            goto L_0x006a
        L_0x0069:
            r5 = r0
        L_0x006a:
            r7.f = r5
            com.oppo.camera.k.b r5 = r4.h
            com.oppo.camera.k.b$a r7 = r4.i
            boolean r5 = r5.a(r7)
            if (r5 == 0) goto L_0x0087
            boolean r5 = r4.d
            if (r5 != 0) goto L_0x0087
            r4.d = r6
            r4.c = r0
            r0 = 0
            r4.e = r0
            r4.f = r6
            r4.a()
        L_0x0087:
            return
        L_0x0088:
            if (r7 != 0) goto L_0x0091
            java.lang.String r5 = "FlashControllerCallback"
            java.lang.String r6 = "onCaptureCompleted, result is null!"
            com.oppo.camera.e.d(r5, r6)
        L_0x0091:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.k.a.onCaptureCompleted(android.hardware.camera2.CameraCaptureSession, android.hardware.camera2.CaptureRequest, android.hardware.camera2.TotalCaptureResult):void");
    }

    public void a(boolean z) {
        this.f3397b = z;
    }

    public void a(int i2) {
        e.b("FlashControllerCallback", "setCurrentState: " + this.f + " -> " + i2);
        this.f = i2;
    }

    public boolean b() {
        return this.d;
    }

    public boolean c() {
        e.b("FlashControllerCallback", "isAeTriggerStart, mAeTriggerState: " + this.f3396a + ", mCurrentState: " + this.f);
        return 1 == this.f3396a || this.f == 0;
    }

    public void d() {
        this.f3397b = false;
        this.d = false;
        this.f = -1;
        this.c = false;
        this.f3396a = 0;
        this.h.a();
    }
}
