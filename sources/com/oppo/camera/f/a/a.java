package com.oppo.camera.f.a;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.TotalCaptureResult;
import com.oppo.camera.f.c;
import com.oppo.camera.f.f;

/* compiled from: ZoomStateCallback */
public class a extends CameraCaptureSession.CaptureCallback {

    /* renamed from: a  reason: collision with root package name */
    private int f3185a = 0;

    /* renamed from: b  reason: collision with root package name */
    private boolean f3186b = false;
    private boolean c = false;
    private boolean d = false;
    private boolean e = false;
    private boolean f = false;
    private long g = 0;
    private f h = null;

    public void a() {
    }

    public a(f fVar) {
        this.h = fVar;
    }

    public void onCaptureCompleted(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, TotalCaptureResult totalCaptureResult) {
        Object a2 = c.a(totalCaptureResult, c.F);
        if (a2 == null || !(a2 instanceof int[])) {
            d();
        } else {
            long frameNumber = totalCaptureResult.getFrameNumber();
            int[] iArr = (int[]) a2;
            int i = iArr.length > 0 ? iArr[0] : 0;
            if ((!this.d || this.e) && i == 1) {
                this.d = true;
                this.e = false;
                this.g = frameNumber;
            }
            this.f = frameNumber - this.g > 30;
            this.f3186b = i == 1;
            if (this.f3185a == 1 && (i == 0 || this.f)) {
                this.d = false;
                a();
            }
            this.f3185a = i;
        }
        super.onCaptureCompleted(cameraCaptureSession, captureRequest, totalCaptureResult);
    }

    public void a(boolean z) {
        this.c = z;
        this.e = z;
    }

    public boolean b() {
        return this.c;
    }

    public boolean c() {
        return this.f3186b && !this.f;
    }

    public void d() {
        this.f3186b = false;
        this.c = false;
        this.f = false;
        this.e = false;
        this.d = false;
        this.g = 0;
        this.f3185a = 0;
    }
}
