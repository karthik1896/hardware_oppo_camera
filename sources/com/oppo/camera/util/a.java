package com.oppo.camera.util;

import android.content.Intent;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.TotalCaptureResult;
import com.oppo.camera.z;

/* compiled from: AndroidTestHelper */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f4615a = false;

    /* renamed from: b  reason: collision with root package name */
    public static C0108a f4616b;

    /* renamed from: com.oppo.camera.util.a$a  reason: collision with other inner class name */
    /* compiled from: AndroidTestHelper */
    public interface C0108a {
        void a(CaptureRequest captureRequest, TotalCaptureResult totalCaptureResult);

        void a(z.a aVar);

        void b(CaptureRequest captureRequest, TotalCaptureResult totalCaptureResult);
    }

    public static void a(Intent intent) {
        try {
            f4615a = intent.getBooleanExtra("android_test", false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void a(z.a aVar) {
        C0108a aVar2;
        if (f4615a && (aVar2 = f4616b) != null) {
            aVar2.a(aVar);
        }
    }

    public static void a(CaptureRequest captureRequest, TotalCaptureResult totalCaptureResult) {
        C0108a aVar;
        if (f4615a && (aVar = f4616b) != null) {
            aVar.b(captureRequest, totalCaptureResult);
        }
    }

    public static void b(CaptureRequest captureRequest, TotalCaptureResult totalCaptureResult) {
        C0108a aVar;
        if (f4615a && (aVar = f4616b) != null) {
            aVar.a(captureRequest, totalCaptureResult);
        }
    }
}
