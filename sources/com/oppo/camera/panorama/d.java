package com.oppo.camera.panorama;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Size;
import android.widget.Toast;
import com.arcsoft.camera.wideselfie.ArcWideSelfieDef;
import com.arcsoft.camera.wideselfie.AwsInitParameter;
import com.arcsoft.camera.wideselfie.ProcessResult;
import com.arcsoft.camera.wideselfie.WideSelfieCallback;
import com.arcsoft.camera.wideselfie.WideSelfieEngine;
import com.oppo.camera.R;
import com.oppo.camera.e;
import com.oppo.camera.jni.FormatConverter;
import com.oppo.camera.util.Util;

/* compiled from: FrontPanoramaEngine */
public class d implements SensorEventListener, WideSelfieCallback {
    private final int A = 7;
    private int B = 90;
    private int C = 0;
    private int D = 0;
    private int E = 0;
    private int F = 0;
    private int G = 0;
    private int H = 0;
    private boolean I = false;
    private boolean J = false;
    private boolean K = false;
    private boolean L = false;
    private AwsInitParameter M = null;
    private WideSelfieEngine N = null;
    private float O = 10000.0f;
    private float[] P = null;
    private HandlerThread Q = null;
    private Handler R = null;
    private Size S = null;
    private SensorManager T = null;
    private Sensor U = null;
    private Object V = new Object();
    private a W = null;
    private Paint X = null;
    private int Y = 0;

    /* renamed from: a  reason: collision with root package name */
    private final int f3475a = 6;

    /* renamed from: b  reason: collision with root package name */
    private final int f3476b = 2;
    private final int c = 90;
    private final int d = 90;
    private final float e = 2.0f;
    private final float f = 1.0f;
    private final float g = 4.0f;
    private final float h = 3.0f;
    private final float i = 0.5f;
    private final float j = 0.25f;
    private final int k = 2;
    private final int l = 2;
    private final int m = 1;
    private final int n = 2;
    private final int o = 3;
    private final int p = 4;
    private final int q = 10000;
    private final int r = 1;
    private final int s = 10000;
    private final int t = 4;
    private final int u = 100;
    private final int v = 1;
    private final int w = 2;
    private final int x = 3;
    private final int y = 4;
    private final int z = 5;

    /* compiled from: FrontPanoramaEngine */
    public interface a {
        void a(Bitmap bitmap);

        void a(boolean z, byte[] bArr, int i, int i2);

        void a_(int i);

        int i();

        void i_();

        void j_();

        boolean k_();

        void l_();

        void m_();
    }

    public void onAccuracyChanged(Sensor sensor, int i2) {
    }

    public d(Activity activity, Size size, boolean z2, a aVar, float[] fArr) {
        this.S = size;
        this.L = z2;
        this.W = aVar;
        this.P = fArr;
        this.Y = activity.getApplicationContext().getResources().getDimensionPixelSize(R.dimen.panorama_rim_width);
        this.X = new Paint();
        this.X.setStyle(Paint.Style.STROKE);
        this.X.setStrokeWidth((float) this.Y);
        this.X.setColor(-1);
        k();
    }

    /* access modifiers changed from: private */
    public void f() {
        e.a("FrontPanoramaEngine", "frontCapPrepare enter");
        j();
        this.F = 0;
        this.O = ((float) g()) / 4.0f;
        this.I = true;
        h();
    }

    private int g() {
        Size size = this.S;
        if (size != null) {
            return (size.getHeight() * 2) / 6;
        }
        return 0;
    }

    private void h() {
        Size size = this.S;
        if (size != null) {
            this.M = AwsInitParameter.getDefaultInitParams(size.getWidth(), this.S.getHeight(), 2050, this.B);
            this.M.maxResultWidth = this.S.getHeight() * 2;
            this.M.progressBarThumbHeight = i();
            float[] fArr = this.P;
            if (fArr != null && fArr.length == 2) {
                AwsInitParameter awsInitParameter = this.M;
                awsInitParameter.cameraViewAngleForWidth = fArr[0];
                awsInitParameter.cameraViewAngleForHeight = fArr[1];
            }
            e.a("FrontPanoramaEngine", "createEngine, cameraViewAngleForHeight after: " + this.M.cameraViewAngleForHeight + ", cameraViewAngleForWidth after: " + this.M.cameraViewAngleForWidth);
            this.N = WideSelfieEngine.singleInstance(ArcWideSelfieDef.DEFAUT_JNI_LIB_NAME);
            int init = this.N.init(this.M);
            if (init != 0) {
                e.e("FrontPanoramaEngine", "createEngine WideSelfieEngine init error, res: " + init);
            }
            this.N.setOnCallback(this);
            int i2 = this.M.maxResultWidth;
            int i3 = this.M.progressBarThumbHeight;
            int fullImageWidth = this.M.getFullImageWidth();
            this.C = this.M.progressBarThumbHeight;
            this.D = (int) (((((float) i2) * 1.0f) / ((float) fullImageWidth)) * ((float) i3));
            this.D = (this.D / 4) * 4;
        }
    }

    private int i() {
        Size size = this.S;
        if (size != null) {
            return size.getWidth() / 6;
        }
        return 0;
    }

    private void j() {
        this.T = (SensorManager) Util.f().getSystemService("sensor");
        this.U = this.T.getDefaultSensor(4);
        synchronized (this.V) {
            if (this.U != null) {
                this.T.registerListener(this, this.U, 10000, this.R);
            } else {
                e.e("FrontPanoramaEngine", "initSensor, mGyroSensor is null.");
                Toast.makeText(Util.f(), Util.f().getString(R.string.camera_gyroscope_abnormal_warning_toast), 0).show();
            }
        }
    }

    public void a(boolean z2) {
        this.K = z2;
        synchronized (this.V) {
            if (this.R != null) {
                this.R.sendEmptyMessage(1);
            }
        }
    }

    private void k() {
        e.a("FrontPanoramaEngine", "initFrontHandler enter");
        if (this.Q == null) {
            this.Q = new HandlerThread("front_panorama");
            this.Q.start();
        }
        synchronized (this.V) {
            if (this.R == null) {
                this.R = new Handler(this.Q.getLooper()) {
                    public void handleMessage(Message message) {
                        int i = message.what;
                        if (i == 1) {
                            d.this.f();
                        } else if (i == 2) {
                            d.this.l();
                        } else if (i == 3) {
                            d.this.a((byte[]) message.obj);
                        } else if (i != 4) {
                            e.a("FrontPanoramaEngine", "mFrontHandler default enter");
                        } else {
                            d.this.n();
                        }
                        super.handleMessage(message);
                    }
                };
            }
        }
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        WideSelfieEngine wideSelfieEngine;
        int type = sensorEvent.sensor.getType();
        if (4 == type && (wideSelfieEngine = this.N) != null) {
            wideSelfieEngine.pushSensorDataIn(type, sensorEvent.values, sensorEvent.timestamp);
            this.J = true;
        }
    }

    public void onProcessCallback(int i2, ProcessResult processResult) {
        if (processResult == null) {
            e.e("FrontPanoramaEngine", "onProcessCallback error, data is null");
            return;
        }
        if (!this.I) {
            a(processResult);
        } else {
            c(processResult);
            b(processResult);
        }
        a(i2, processResult);
    }

    private void a(int i2, ProcessResult processResult) {
        if (28672 == i2 || 28673 == i2 || 28675 == i2 || 28676 == i2 || 28677 == i2 || 28678 == i2 || 28679 == i2 || 4 == i2 || 2 == i2) {
            a(4);
            e.e("FrontPanoramaEngine", "processResultForStatus, error code: " + i2);
        }
        if (32769 == i2 || 32770 == i2) {
            a(5);
        }
        if (Math.abs(processResult.progressBarThumbOffset.y) >= ((int) (((float) g()) * 0.25f)) + ((int) ((((float) g()) * 0.5f) / 3.0f))) {
            a(7);
        }
        if (100 == processResult.progress) {
            a(2);
        }
    }

    private void a(ProcessResult processResult) {
        byte[] bArr;
        e.a("FrontPanoramaEngine", "processResultRealTimeBitmap enter");
        if (processResult.resultImageHeight <= 0 || processResult.resultImageWidth <= 0) {
            e.e("FrontPanoramaEngine", "processResultRealTimeBitmap error, resultImageHeight: " + processResult.resultImageHeight + ", resultImageWidth: " + processResult.resultImageWidth);
            this.W.l_();
            return;
        }
        if (this.W.k_()) {
            bArr = b(this.K, processResult);
        } else {
            bArr = a(this.K, processResult);
        }
        this.W.j_();
        l();
        this.W.a(this.K, bArr, processResult.resultImageWidth, processResult.resultImageHeight);
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x00de A[SYNTHETIC, Splitter:B:29:0x00de] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0101 A[SYNTHETIC, Splitter:B:36:0x0101] */
    /* JADX WARNING: Removed duplicated region for block: B:42:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private byte[] a(boolean r18, com.arcsoft.camera.wideselfie.ProcessResult r19) {
        /*
            r17 = this;
            r1 = r17
            r0 = r19
            java.lang.String r2 = "getBosByRotate finally error: "
            java.lang.String r3 = "FrontPanoramaEngine"
            java.io.ByteArrayOutputStream r5 = new java.io.ByteArrayOutputStream     // Catch:{ Exception -> 0x00c2, all -> 0x00be }
            r5.<init>()     // Catch:{ Exception -> 0x00c2, all -> 0x00be }
            byte[] r6 = r0.resultImageArray     // Catch:{ Exception -> 0x00bb, all -> 0x00b8 }
            int r6 = r6.length     // Catch:{ Exception -> 0x00bb, all -> 0x00b8 }
            byte[] r6 = new byte[r6]     // Catch:{ Exception -> 0x00bb, all -> 0x00b8 }
            int r12 = r0.resultImageWidth     // Catch:{ Exception -> 0x00bb, all -> 0x00b8 }
            int r13 = r0.resultImageHeight     // Catch:{ Exception -> 0x00bb, all -> 0x00b8 }
            r7 = 2
            r8 = 1
            r14 = 0
            if (r18 == 0) goto L_0x0068
            byte[] r9 = r0.resultImageArray     // Catch:{ Exception -> 0x00bb, all -> 0x00b8 }
            byte[] r10 = r0.resultImageArray     // Catch:{ Exception -> 0x00bb, all -> 0x00b8 }
            int r10 = r10.length     // Catch:{ Exception -> 0x00bb, all -> 0x00b8 }
            int[] r11 = new int[r7]     // Catch:{ Exception -> 0x00bb, all -> 0x00b8 }
            r11[r14] = r12     // Catch:{ Exception -> 0x00bb, all -> 0x00b8 }
            r11[r8] = r12     // Catch:{ Exception -> 0x00bb, all -> 0x00b8 }
            int[] r7 = new int[r7]     // Catch:{ Exception -> 0x00bb, all -> 0x00b8 }
            r7[r14] = r13     // Catch:{ Exception -> 0x00bb, all -> 0x00b8 }
            r7[r8] = r13     // Catch:{ Exception -> 0x00bb, all -> 0x00b8 }
            com.oppo.camera.panorama.d$a r14 = r1.W     // Catch:{ Exception -> 0x00bb, all -> 0x00b8 }
            int r14 = r14.i()     // Catch:{ Exception -> 0x00bb, all -> 0x00b8 }
            int r14 = r14 + 90
            boolean r15 = r1.L     // Catch:{ Exception -> 0x00bb, all -> 0x00b8 }
            if (r15 != 0) goto L_0x003c
            r15 = r7
            r16 = r8
            goto L_0x003f
        L_0x003c:
            r15 = r7
            r16 = 0
        L_0x003f:
            r7 = r9
            r8 = r6
            r9 = r10
            r10 = r11
            r11 = r15
            r15 = 0
            r4 = r15
            r15 = r16
            com.oppo.camera.jni.FormatConverter.rotateAndMirrorYUV(r7, r8, r9, r10, r11, r12, r13, r14, r15)     // Catch:{ Exception -> 0x00bb, all -> 0x00b8 }
            android.graphics.YuvImage r13 = new android.graphics.YuvImage     // Catch:{ Exception -> 0x00bb, all -> 0x00b8 }
            r9 = 17
            int r10 = r0.resultImageHeight     // Catch:{ Exception -> 0x00bb, all -> 0x00b8 }
            int r11 = r0.resultImageWidth     // Catch:{ Exception -> 0x00bb, all -> 0x00b8 }
            r12 = 0
            r7 = r13
            r8 = r6
            r7.<init>(r8, r9, r10, r11, r12)     // Catch:{ Exception -> 0x00bb, all -> 0x00b8 }
            android.graphics.Rect r6 = new android.graphics.Rect     // Catch:{ Exception -> 0x00bb, all -> 0x00b8 }
            int r7 = r0.resultImageHeight     // Catch:{ Exception -> 0x00bb, all -> 0x00b8 }
            int r0 = r0.resultImageWidth     // Catch:{ Exception -> 0x00bb, all -> 0x00b8 }
            r6.<init>(r4, r4, r7, r0)     // Catch:{ Exception -> 0x00bb, all -> 0x00b8 }
            r0 = 95
            r13.compressToJpeg(r6, r0, r5)     // Catch:{ Exception -> 0x00bb, all -> 0x00b8 }
            goto L_0x00b0
        L_0x0068:
            r4 = r14
            byte[] r9 = r0.resultImageArray     // Catch:{ Exception -> 0x00bb, all -> 0x00b8 }
            byte[] r10 = r0.resultImageArray     // Catch:{ Exception -> 0x00bb, all -> 0x00b8 }
            int r10 = r10.length     // Catch:{ Exception -> 0x00bb, all -> 0x00b8 }
            int[] r11 = new int[r7]     // Catch:{ Exception -> 0x00bb, all -> 0x00b8 }
            r11[r4] = r12     // Catch:{ Exception -> 0x00bb, all -> 0x00b8 }
            r11[r8] = r12     // Catch:{ Exception -> 0x00bb, all -> 0x00b8 }
            int[] r14 = new int[r7]     // Catch:{ Exception -> 0x00bb, all -> 0x00b8 }
            r14[r4] = r13     // Catch:{ Exception -> 0x00bb, all -> 0x00b8 }
            r14[r8] = r13     // Catch:{ Exception -> 0x00bb, all -> 0x00b8 }
            com.oppo.camera.panorama.d$a r7 = r1.W     // Catch:{ Exception -> 0x00bb, all -> 0x00b8 }
            int r15 = r7.i()     // Catch:{ Exception -> 0x00bb, all -> 0x00b8 }
            boolean r7 = r1.L     // Catch:{ Exception -> 0x00bb, all -> 0x00b8 }
            if (r7 != 0) goto L_0x0087
            r16 = r8
            goto L_0x0089
        L_0x0087:
            r16 = r4
        L_0x0089:
            r7 = r9
            r8 = r6
            r9 = r10
            r10 = r11
            r11 = r14
            r14 = r15
            r15 = r16
            com.oppo.camera.jni.FormatConverter.rotateAndMirrorYUV(r7, r8, r9, r10, r11, r12, r13, r14, r15)     // Catch:{ Exception -> 0x00bb, all -> 0x00b8 }
            android.graphics.YuvImage r13 = new android.graphics.YuvImage     // Catch:{ Exception -> 0x00bb, all -> 0x00b8 }
            r9 = 17
            int r10 = r0.resultImageWidth     // Catch:{ Exception -> 0x00bb, all -> 0x00b8 }
            int r11 = r0.resultImageHeight     // Catch:{ Exception -> 0x00bb, all -> 0x00b8 }
            r12 = 0
            r7 = r13
            r8 = r6
            r7.<init>(r8, r9, r10, r11, r12)     // Catch:{ Exception -> 0x00bb, all -> 0x00b8 }
            android.graphics.Rect r6 = new android.graphics.Rect     // Catch:{ Exception -> 0x00bb, all -> 0x00b8 }
            int r7 = r0.resultImageWidth     // Catch:{ Exception -> 0x00bb, all -> 0x00b8 }
            int r0 = r0.resultImageHeight     // Catch:{ Exception -> 0x00bb, all -> 0x00b8 }
            r6.<init>(r4, r4, r7, r0)     // Catch:{ Exception -> 0x00bb, all -> 0x00b8 }
            r0 = 95
            r13.compressToJpeg(r6, r0, r5)     // Catch:{ Exception -> 0x00bb, all -> 0x00b8 }
        L_0x00b0:
            byte[] r0 = r5.toByteArray()     // Catch:{ Exception -> 0x00bb, all -> 0x00b8 }
            r5.close()     // Catch:{ Exception -> 0x00bb, all -> 0x00b8 }
            return r0
        L_0x00b8:
            r0 = move-exception
        L_0x00b9:
            r4 = r0
            goto L_0x00ff
        L_0x00bb:
            r0 = move-exception
            r4 = r5
            goto L_0x00c4
        L_0x00be:
            r0 = move-exception
            r4 = r0
            r5 = 0
            goto L_0x00ff
        L_0x00c2:
            r0 = move-exception
            r4 = 0
        L_0x00c4:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x00fc }
            r5.<init>()     // Catch:{ all -> 0x00fc }
            java.lang.String r6 = "getBosByRotate error: "
            r5.append(r6)     // Catch:{ all -> 0x00fc }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x00fc }
            r5.append(r0)     // Catch:{ all -> 0x00fc }
            java.lang.String r0 = r5.toString()     // Catch:{ all -> 0x00fc }
            com.oppo.camera.e.e(r3, r0)     // Catch:{ all -> 0x00fc }
            if (r4 == 0) goto L_0x00fa
            r4.close()     // Catch:{ Exception -> 0x00e2 }
            goto L_0x00fa
        L_0x00e2:
            r0 = move-exception
            r4 = r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r2)
            java.lang.String r2 = r4.toString()
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            com.oppo.camera.e.e(r3, r0)
        L_0x00fa:
            r2 = 0
            return r2
        L_0x00fc:
            r0 = move-exception
            r5 = r4
            goto L_0x00b9
        L_0x00ff:
            if (r5 == 0) goto L_0x011d
            r5.close()     // Catch:{ Exception -> 0x0105 }
            goto L_0x011d
        L_0x0105:
            r0 = move-exception
            r5 = r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r2)
            java.lang.String r2 = r5.toString()
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            com.oppo.camera.e.e(r3, r0)
        L_0x011d:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.panorama.d.a(boolean, com.arcsoft.camera.wideselfie.ProcessResult):byte[]");
    }

    private byte[] b(boolean z2, ProcessResult processResult) {
        byte[] bArr = new byte[processResult.resultImageArray.length];
        int i2 = processResult.resultImageWidth;
        int i3 = processResult.resultImageHeight;
        FormatConverter.rotateAndMirrorYUV(processResult.resultImageArray, bArr, processResult.resultImageArray.length, new int[]{i2, i2}, new int[]{i3, i3}, i2, i3, z2 ? this.W.i() + 90 : this.W.i(), !this.L);
        return bArr;
    }

    public Bitmap a(Bitmap bitmap) {
        if (bitmap == null || g() <= 0 || i() <= 0) {
            e.e("FrontPanoramaEngine", "drawFrontPreviewBitmap, bitmap is null,or getFrontPreviewHeight: " + i() + ", getFrontPreviewWidth: " + g());
            return null;
        }
        Bitmap a2 = Util.a(g(), i(), Bitmap.Config.ARGB_8888);
        int g2 = g();
        int i2 = i();
        float f2 = ((float) g2) * 0.5f;
        float f3 = 0.5f * f2;
        Canvas canvas = new Canvas(a2);
        canvas.drawBitmap(bitmap, ((float) g()) / 4.0f, 0.0f, (Paint) null);
        int i3 = this.Y;
        canvas.drawRect(((float) ((int) f3)) + (((float) i3) / 2.0f), ((float) i3) / 2.0f, ((float) ((int) (f3 + f2))) - (((float) i3) / 2.0f), ((float) i2) - (((float) i3) / 2.0f), this.X);
        return a2;
    }

    private Bitmap a(Bitmap bitmap, float f2) {
        if (bitmap == null) {
            e.a("FrontPanoramaEngine", "drawPreviewBitmap, bitmap is null");
            return null;
        }
        Bitmap a2 = Util.a(g(), i(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(a2);
        float g2 = ((float) g()) / 4.0f;
        if (f2 > 0.0f) {
            g2 -= f2;
        }
        this.F = Math.max((int) (((((float) g()) * 0.5f) + g2) - f2), this.F);
        if (this.F > g()) {
            this.F = g();
        }
        float f3 = this.O;
        int min = 10000.0f != f3 ? (int) Math.min(g2, f3) : 0;
        if (min < 0) {
            min = 0;
        }
        int i2 = this.F;
        int i3 = i();
        this.O = (float) min;
        canvas.drawBitmap(bitmap, (Rect) null, new Rect(min, 0, i2, i3), (Paint) null);
        int g3 = g();
        int i4 = i();
        float f4 = (float) g3;
        float f5 = f4 * 0.5f;
        float f6 = (float) ((int) (0.5f * f5));
        int i5 = this.Y;
        canvas.drawRect(((float) ((int) Math.max(0.0f, f6 - f2))) + (((float) i5) / 2.0f), ((float) i5) / 2.0f, ((float) ((int) Math.min(f4, (f6 + f5) - f2))) - (((float) i5) / 2.0f), ((float) i4) - (((float) i5) / 2.0f), this.X);
        return a2;
    }

    private void b(ProcessResult processResult) {
        if (processResult != null && this.E != processResult.direction) {
            if (processResult.direction == 1) {
                this.W.a_(0);
            } else {
                this.W.a_(1);
            }
            this.E = processResult.direction;
        }
    }

    private void c(ProcessResult processResult) {
        new Canvas(Bitmap.createBitmap(this.C, this.D, Bitmap.Config.ARGB_8888)).drawARGB(100, 0, 0, 0);
        this.G = Math.max(processResult.progressBarThumbOffset.y, this.G);
        this.H = Math.min(processResult.progressBarThumbOffset.y, this.H);
        Bitmap createBitmap = Bitmap.createBitmap(processResult.progressBarThumbRgbPixels, processResult.progressBarThumbImageWidth, processResult.progressBarThumbImageHeight, Bitmap.Config.ARGB_8888);
        Matrix matrix = new Matrix();
        matrix.postRotate(90.0f);
        Bitmap a2 = Util.a(createBitmap, 0, 0, createBitmap.getWidth(), createBitmap.getHeight(), matrix, true);
        if (a2 != null) {
            this.W.a(a(a2, (float) processResult.progressBarThumbOffset.y));
        }
    }

    /* access modifiers changed from: private */
    public void l() {
        int uninit;
        e.a("FrontPanoramaEngine", "destroyEngine enter");
        WideSelfieEngine wideSelfieEngine = this.N;
        if (!(wideSelfieEngine == null || (uninit = wideSelfieEngine.uninit()) == 0)) {
            e.e("FrontPanoramaEngine", "destroyEngine error, res: " + uninit);
        }
        this.N = null;
        this.M = null;
        this.J = false;
        this.H = 0;
        this.G = 0;
        m();
    }

    private void m() {
        SensorManager sensorManager;
        e.a("FrontPanoramaEngine", "unRegisterSensor, mGyroSensor: " + this.U + ", mSensorManager: " + this.T);
        if (this.U != null && (sensorManager = this.T) != null) {
            sensorManager.unregisterListener(this);
        }
    }

    public void a(byte[] bArr) {
        if (this.N != null && this.I) {
            this.W.m_();
            int process = this.N.process(0, bArr);
            this.W.i_();
            if (process != 0) {
                e.e("FrontPanoramaEngine", "onPreviewFrame process select error, res：" + process);
            }
        }
    }

    public void a() {
        e.a("FrontPanoramaEngine", "destroyFrontEngine enter");
        this.K = false;
        synchronized (this.V) {
            if (this.R != null) {
                this.R.sendEmptyMessage(2);
            }
        }
    }

    public void b(byte[] bArr) {
        if (this.I) {
            synchronized (this.V) {
                if (!(this.R == null || bArr == null || (!this.J && this.U != null))) {
                    Message obtain = Message.obtain();
                    obtain.what = 3;
                    obtain.obj = bArr;
                    this.R.sendMessage(obtain);
                }
            }
        }
    }

    public boolean b() {
        return this.I;
    }

    public void b(boolean z2) {
        this.I = z2;
    }

    public void c() {
        a(1);
    }

    public void d() {
        synchronized (this.V) {
            if (this.R != null) {
                this.R.getLooper().quitSafely();
                this.R = null;
            }
        }
    }

    private void a(int i2) {
        e.a("FrontPanoramaEngine", "stopProcessingWithType, stopType: " + i2);
        synchronized (this.V) {
            if (this.R != null) {
                Message obtain = Message.obtain();
                obtain.what = 4;
                this.R.sendMessage(obtain);
            }
        }
    }

    /* access modifiers changed from: private */
    public void n() {
        WideSelfieEngine wideSelfieEngine = this.N;
        if (wideSelfieEngine != null && this.I) {
            this.I = false;
            wideSelfieEngine.stopProcessing();
        }
    }

    public void e() {
        a(3);
    }
}
