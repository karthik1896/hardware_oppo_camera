package com.oppo.camera.t;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Point;
import android.graphics.PointF;
import com.oppo.camera.aps.config.CameraConfig;
import com.oppo.camera.aps.config.ConfigDataBase;
import com.oppo.camera.aps.constant.ApsConstant;
import com.oppo.camera.e;
import com.oppo.camera.util.Util;
import com.tencent.youtu.YTCommonInterface;
import com.youtu.ocr.docprocess.DocDetector;
import com.youtu.ocr.docprocess.IText;
import com.youtu.ocr.docprocess.b;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: SuperTextEngine */
public class c implements b {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f3749a = false;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f3750b = false;
    private boolean c;
    private boolean d;
    private final Object e;
    private int f;
    private DocDetector g;
    private Context h;
    private int i;

    /* compiled from: SuperTextEngine */
    private static final class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static c f3753a = new c();
    }

    private c() {
        this.c = false;
        this.d = false;
        this.e = new Object();
        this.f = -1;
        this.g = new DocDetector();
        this.h = null;
        this.i = 0;
        this.h = Util.f();
    }

    public static c d() {
        return a.f3753a;
    }

    static {
        System.loadLibrary(ApsConstant.CAPTURE_MODE_COMMON);
    }

    public void a(int i2) {
        this.i = i2;
    }

    public int b() {
        return this.i;
    }

    public void a(final boolean z) {
        e.a("SuperTextEngine", "init, isCpuProcess: " + z + ", sbIniting: " + f3750b);
        if (!f3750b) {
            com.oppo.camera.v.c.a().a(new Runnable() {
                public void run() {
                    c.this.c(z);
                }
            }, "init super text sdk");
        }
    }

    public boolean a() {
        boolean z;
        synchronized (this.e) {
            z = this.f == 0;
        }
        return z;
    }

    public void b(boolean z) {
        synchronized (this.e) {
            if (z) {
                this.f = 0;
            } else {
                this.f = -1;
            }
        }
    }

    /* access modifiers changed from: private */
    public void c(boolean z) {
        e.a("SuperTextEngine", "initSdk, isCpuProcess: " + z);
        f3750b = true;
        InputStream inputStream = null;
        try {
            AssetManager assets = this.h.getResources().getAssets();
            int a2 = YTCommonInterface.a("license.lic", "DF6i36rLXS6SgeKipfIgndCUUCckbARQ");
            e.b("SuperTextEngine", "initSdk, ret: " + a2);
            InputStream open = assets.open("DocDetectV15.xbin");
            byte[] a3 = a(open, open.available());
            if (z) {
                this.d = this.g.xnnInitedByByte(a3);
            } else {
                this.c = this.g.xnnInitedByByteGPU(a3, this.h.getFilesDir().getAbsolutePath() + File.separator + "initGPUcache.bin");
            }
            e.b("SuperTextEngine", "initSdk, mbCpuSdkInited: " + this.d + ", version: " + b.f4646a.a());
            if (open != null) {
                try {
                    open.close();
                } catch (IOException e2) {
                    e = e2;
                }
            }
        } catch (Exception e3) {
            e3.printStackTrace();
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e4) {
                    e = e4;
                }
            }
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e5) {
                    e5.printStackTrace();
                }
            }
            f3750b = false;
            throw th;
        }
        f3750b = false;
        e.printStackTrace();
        f3750b = false;
    }

    public a a(byte[] bArr, int i2, int i3, int i4) {
        if (!this.d) {
            e.e("SuperTextEngine", "detectTextByByte, sdk not init yet");
            a(CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPER_TEXT_CPU_PROCESS));
            return new a();
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (f3749a) {
            currentTimeMillis = System.currentTimeMillis();
        }
        IText.DetectResult a2 = this.g.a(bArr, i2, i3, i4);
        if (f3749a) {
            e.e("SuperTextEngine", "detectTextByByte, cpu detect cost time: " + (System.currentTimeMillis() - currentTimeMillis));
        }
        return a(a2, i2, i3, i4);
    }

    public boolean a(int i2, int i3, int i4, int i5) {
        return this.g.a(i2, i3, i4, i5);
    }

    public a a(int i2, int i3, int i4, boolean z) {
        if (!this.c) {
            e.e("SuperTextEngine", "detectTextByTexture, sdk not init yet");
            a(CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPER_TEXT_CPU_PROCESS));
            return new a();
        }
        long j = 0;
        if (f3749a) {
            j = System.currentTimeMillis();
        }
        IText.DetectResult a2 = this.g.a(z);
        if (f3749a) {
            e.e("SuperTextEngine", "detectTextByTexture, gpu detect cost time: " + (System.currentTimeMillis() - j));
        }
        return a(a2, i2, i3, i4);
    }

    private a a(IText.DetectResult detectResult, int i2, int i3, int i4) {
        a aVar = new a();
        aVar.a(detectResult.hasResult);
        if (!detectResult.hasResult) {
            return aVar;
        }
        Point[] pointArr = new Point[4];
        PointF[] pointFArr = new PointF[4];
        PointF[] pointFArr2 = new PointF[4];
        for (int i5 = 0; i5 < detectResult.pointArr.length; i5++) {
            if (i4 == 0) {
                pointArr[i5] = new Point(detectResult.pointArr[i5].y, detectResult.pointArr[i5].x);
                float f2 = (float) i3;
                float f3 = (float) i2;
                pointFArr[i5] = new PointF(((float) detectResult.pointArr[i5].y) / f2, ((float) detectResult.pointArr[i5].x) / f3);
                pointFArr2[i5] = new PointF(((float) detectResult.pointArr[i5].y) / f2, ((float) detectResult.pointArr[i5].x) / f3);
            } else if (i4 == 90) {
                pointArr[i5] = new Point(detectResult.pointArr[i5].x, i2 - detectResult.pointArr[i5].y);
                float f4 = (float) i3;
                float f5 = (float) i2;
                pointFArr[i5] = new PointF(((float) detectResult.pointArr[i5].x) / f4, (f5 - ((float) detectResult.pointArr[i5].y)) / f5);
                pointFArr2[i5] = new PointF(((float) detectResult.pointArr[i5].y) / f5, ((float) detectResult.pointArr[i5].x) / f4);
            } else if (i4 == 180) {
                pointArr[i5] = new Point(i3 - detectResult.pointArr[i5].y, i2 - detectResult.pointArr[i5].x);
                float f6 = (float) i3;
                float f7 = (float) i2;
                pointFArr[i5] = new PointF(((float) (i3 - detectResult.pointArr[i5].y)) / f6, (f7 - ((float) detectResult.pointArr[i5].x)) / f7);
                pointFArr2[i5] = new PointF(((float) detectResult.pointArr[i5].y) / f6, ((float) detectResult.pointArr[i5].x) / f7);
            } else if (i4 == 270) {
                pointArr[i5] = new Point(i3 - detectResult.pointArr[i5].x, detectResult.pointArr[i5].y);
                float f8 = (float) i3;
                float f9 = (float) i2;
                pointFArr[i5] = new PointF(((float) (i3 - detectResult.pointArr[i5].x)) / f8, ((float) detectResult.pointArr[i5].y) / f9);
                pointFArr2[i5] = new PointF(((float) detectResult.pointArr[i5].y) / f9, ((float) detectResult.pointArr[i5].x) / f8);
            }
        }
        aVar.a(pointArr);
        aVar.b(pointFArr);
        aVar.a(pointFArr2);
        return aVar;
    }

    public void c() {
        this.g.xnnReleaseGLSource();
    }

    private byte[] a(InputStream inputStream, int i2) throws Exception {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[i2];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                byteArrayOutputStream.close();
                inputStream.close();
                return byteArrayOutputStream.toByteArray();
            }
        }
    }
}
