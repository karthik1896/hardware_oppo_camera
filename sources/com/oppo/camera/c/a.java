package com.oppo.camera.c;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.TotalCaptureResult;
import com.oppo.camera.f.c;
import com.oppo.camera.f.f;

/* compiled from: ApertureControllerCallback */
public class a extends CameraCaptureSession.CaptureCallback {

    /* renamed from: a  reason: collision with root package name */
    private int f2780a = 0;

    /* renamed from: b  reason: collision with root package name */
    private boolean f2781b = false;
    private boolean c = false;
    private boolean d = false;
    private boolean e = false;
    private long f = 0;
    private f g = null;

    public void a() {
    }

    public a(f fVar) {
        this.g = fVar;
    }

    public void onCaptureCompleted(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, TotalCaptureResult totalCaptureResult) {
        Object a2 = c.a(totalCaptureResult, c.A);
        if (a2 != null && (a2 instanceof int[])) {
            long frameNumber = totalCaptureResult.getFrameNumber();
            int[] iArr = (int[]) a2;
            int i = iArr.length > 0 ? iArr[0] : 0;
            if (!this.d && i == 1) {
                this.d = true;
                this.f = frameNumber;
            }
            this.e = frameNumber - this.f > 15;
            this.f2781b = i == 1;
            if (this.f2780a == 1 && (i == 0 || this.e)) {
                this.d = false;
                a();
            }
            this.f2780a = i;
        }
        super.onCaptureCompleted(cameraCaptureSession, captureRequest, totalCaptureResult);
    }

    public void a(boolean z) {
        this.c = z;
    }

    public boolean b() {
        return this.c;
    }

    public boolean c() {
        return this.f2781b && !this.e;
    }

    public void d() {
        this.c = false;
        this.e = false;
        this.d = false;
        this.f = 0;
        this.f2780a = 0;
    }
}
