package com.oppo.camera.panorama;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.YuvImage;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.media.Image;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Size;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.arcsoft.camera.burstpmk.ProcessResult;
import com.oppo.camera.R;
import com.oppo.camera.aps.adapter.ApsTotalResult;
import com.oppo.camera.aps.config.CameraConfig;
import com.oppo.camera.aps.config.CameraFunction;
import com.oppo.camera.aps.config.ConfigDataBase;
import com.oppo.camera.aps.constant.ApsConstant;
import com.oppo.camera.e;
import com.oppo.camera.e.a;
import com.oppo.camera.e.b;
import com.oppo.camera.f.d;
import com.oppo.camera.f.f;
import com.oppo.camera.f.j;
import com.oppo.camera.h;
import com.oppo.camera.jni.FormatConverter;
import com.oppo.camera.panorama.FrontPanoramaGuideView;
import com.oppo.camera.panorama.PanoramaProgressBar;
import com.oppo.camera.panorama.d;
import com.oppo.camera.panorama.g;
import com.oppo.camera.statistics.CameraStatisticsUtil;
import com.oppo.camera.statistics.model.CaptureMsgData;
import com.oppo.camera.statistics.model.DcsMsgData;
import com.oppo.camera.statistics.model.MenuClickMsgData;
import com.oppo.camera.statistics.model.VideoRecordMsgData;
import com.oppo.camera.ui.CameraScreenHintView;
import com.oppo.camera.ui.control.c;
import com.oppo.camera.ui.control.e;
import com.oppo.camera.ui.preview.a.n;
import com.oppo.camera.util.Util;
import com.oppo.camera.z;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.List;

/* compiled from: PanoramaCapMode */
public class f extends a implements d.a, g.a {
    /* access modifiers changed from: private */
    public static final Object av = new Object();
    private int aA = 0;
    /* access modifiers changed from: private */
    public int aB = 0;
    private int aC = 0;
    /* access modifiers changed from: private */
    public int aD = 0;
    private int aE = 42;
    private int aF = 0;
    /* access modifiers changed from: private */
    public boolean aG = false;
    private boolean aH = false;
    /* access modifiers changed from: private */
    public boolean aI = false;
    private boolean aJ = false;
    private Bitmap aK = null;
    /* access modifiers changed from: private */
    public ImageView aL = null;
    /* access modifiers changed from: private */
    public FrontPanoramaGuideView aM = null;
    /* access modifiers changed from: private */
    public TextView aN = null;
    private Resources aO = null;
    private Object aP = new Object();
    private RelativeLayout aQ = null;
    /* access modifiers changed from: private */
    public CameraScreenHintView aR = null;
    private Size aS = null;
    /* access modifiers changed from: private */
    public Size aT = null;
    private Size aU = null;
    /* access modifiers changed from: private */
    public PanoramaProgressBar aV = null;
    /* access modifiers changed from: private */
    public volatile boolean aW = false;
    /* access modifiers changed from: private */
    public volatile boolean aX = true;
    /* access modifiers changed from: private */
    public int aY = 0;
    private int aZ = 0;
    FrontPanoramaGuideView.a at = new FrontPanoramaGuideView.a() {
        public void a(int i) {
            if (f.this.aN != null && f.this.aM != null) {
                f.this.aN.setText(f.this.aM.getCurrentGuideTips());
            }
        }
    };
    PanoramaProgressBar.RearPanoramaInterface au = new PanoramaProgressBar.RearPanoramaInterface() {
        public void onReportDirectionChange(int i) {
            f.this.J(i);
        }
    };
    private int aw = 1080;
    private int ax = 282;
    private int ay = 0;
    private int az = 0;
    private int ba = 0;
    private boolean bb;
    private boolean bc = false;
    /* access modifiers changed from: private */
    public volatile int bd = -1;
    private byte[] be = null;
    /* access modifiers changed from: private */
    public int bf = 0;
    /* access modifiers changed from: private */
    public int bg = 0;
    private int bh = 0;
    /* access modifiers changed from: private */
    public int bi = 0;
    /* access modifiers changed from: private */
    public int bj = 0;
    /* access modifiers changed from: private */
    public int bk = 0;
    /* access modifiers changed from: private */
    public int bl = 0;
    /* access modifiers changed from: private */
    public float bm = 0.0f;
    /* access modifiers changed from: private */
    public int bn = 0;
    /* access modifiers changed from: private */
    public g bo = null;
    /* access modifiers changed from: private */
    public Bitmap bp = null;
    /* access modifiers changed from: private */
    public Matrix bq = new Matrix();
    private String br = VideoRecordMsgData.END_TYPE_NORMAL;
    private boolean bs = false;
    private int bt = 0;
    private float bu = 0.0f;
    /* access modifiers changed from: private */
    public d bv = null;
    /* access modifiers changed from: private */
    public Bitmap bw = null;
    /* access modifiers changed from: private */
    public Handler bx = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message message) {
            Message message2 = message;
            switch (message2.what) {
                case 1:
                    if (f.this.bv != null) {
                        f.this.bv.a();
                    }
                    f.this.fI();
                    boolean booleanValue = ((Boolean) message2.obj).booleanValue();
                    f.this.G(booleanValue);
                    if (!booleanValue) {
                        f.this.Y.af();
                        return;
                    }
                    return;
                case 2:
                    Bitmap bitmap = (Bitmap) message2.obj;
                    if (f.this.aI && !f.this.y && f.this.aL != null && bitmap != null && !bitmap.isRecycled() && h.a(f.this.Z.getApplicationContext()).d()) {
                        f.this.aL.setImageBitmap(bitmap);
                        if (f.this.bw != null) {
                            f.this.bw.recycle();
                            Bitmap unused = f.this.bw = null;
                        }
                        Bitmap unused2 = f.this.bw = bitmap;
                        return;
                    }
                    return;
                case 3:
                    if (f.this.aI) {
                        f.this.F(((Integer) message2.obj).intValue());
                        return;
                    }
                    return;
                case 4:
                    if (!f.this.aW && f.this.aV != null && !f.this.aV.d() && -1 != f.this.aV.getDirection()) {
                        f.this.aV.e();
                        f.this.aV.setAnimationState(6);
                        return;
                    }
                    return;
                case 5:
                    if (f.this.aW && f.this.bp != null && f.this.aV != null) {
                        int i = message2.arg1;
                        if (f.this.bn == 0) {
                            int unused3 = f.this.bn = i;
                        }
                        f.this.aV.a(f.this.bp, f.this.bp.getWidth() - f.this.bg, (int) (((float) (i - f.this.bn)) * 0.1f));
                        return;
                    }
                    return;
                case 6:
                    f fVar = f.this;
                    fVar.e(fVar.aY);
                    if (f.this.aV != null) {
                        f.this.aV.f();
                    }
                    f.this.F(0);
                    e.a("PanoramaCapMode", "handleMessage, MSG_REAR_PANORAMA_FINISH");
                    f.this.Y.a(new c(11, "button_color_inside_none"));
                    f.this.Y.j(0);
                    f.this.Y.b(0, true);
                    f.this.Y.e(0);
                    f.this.Y.f(0);
                    f.this.Y.h(0);
                    if (f.this.aI) {
                        f.this.Y.a(0, true);
                    }
                    f.this.Y.d(true, false);
                    if (!f.this.X.w()) {
                        f.this.X.V();
                        f.this.W.a(false, false);
                        f.this.W.a(4, com.oppo.camera.a.a(), com.oppo.camera.a.a(), true);
                        f.this.W.f(com.oppo.camera.a.b());
                    }
                    f.this.W.e(false);
                    f.this.W.a((f.c) null);
                    boolean unused4 = f.this.aG = false;
                    f fVar2 = f.this;
                    fVar2.a((byte[]) null, 0, 0, Util.a(fVar2.aQ()), false, false, 0);
                    return;
                case 7:
                    synchronized (f.av) {
                        if (!(f.this.aW || f.this.aV == null || f.this.aT == null)) {
                            Bitmap a2 = e.a(f.this.Z, (byte[]) message2.obj, f.this.aT.getWidth(), f.this.aT.getHeight(), f.this.bj, f.this.bi);
                            if (!f.this.y && a2 != null) {
                                Bitmap a3 = Util.a(a2, 0, 0, a2.getWidth(), a2.getHeight(), f.this.bq, true);
                                f.this.aV.setFrameSize(a3.getWidth());
                                f.this.aV.a(a3, 0, 0);
                            }
                        }
                    }
                    return;
                default:
                    return;
            }
        }
    };

    private int I(int i) {
        if (i == -1) {
            return 3;
        }
        if (i != 2) {
            return i != 3 ? 0 : 1;
        }
        return 2;
    }

    public String a() {
        return ApsConstant.CAPTURE_MODE_PANORAMA;
    }

    public boolean aa() {
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean bk() {
        return true;
    }

    public int c() {
        return 32775;
    }

    public boolean c(String str) {
        return false;
    }

    public boolean cw() {
        return false;
    }

    public CameraStatisticsUtil.MakerNote dY() {
        return null;
    }

    /* access modifiers changed from: protected */
    public void q() {
    }

    public void fC() {
        this.bx.sendEmptyMessage(6);
        synchronized (av) {
            if (this.bo != null) {
                this.bo.a();
            }
        }
    }

    public void a(ProcessResult processResult) {
        this.aW = false;
        int i = processResult.width;
        int i2 = processResult.height;
        if (i <= 0 || i2 <= 0) {
            this.bx.sendEmptyMessage(6);
            synchronized (av) {
                if (this.bo != null) {
                    this.bo.a();
                }
            }
            return;
        }
        byte[] bArr = new byte[processResult.imageData.length];
        FormatConverter.rotateAndMirrorYUV(processResult.imageData, bArr, processResult.imageData.length, new int[]{i, i}, new int[]{i2, i2}, i, i2, 90, false);
        if (eq() != null) {
            a(bArr, i2, i);
        } else {
            try {
                YuvImage yuvImage = new YuvImage(bArr, 17, i2, i, (int[]) null);
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                yuvImage.compressToJpeg(new Rect(0, 0, i2, i), 95, byteArrayOutputStream);
                a(byteArrayOutputStream.toByteArray(), i2, i);
                byteArrayOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        synchronized (av) {
            if (this.bo != null) {
                this.bo.a();
            }
        }
    }

    public void b(final ProcessResult processResult) {
        if (this.bd != processResult.direction) {
            this.bd = processResult.direction;
            final Rect rect = processResult.updateSmallImageRect;
            Bitmap a2 = e.a(this.Z, processResult.smallImageData, rect.right - rect.left, rect.bottom - rect.top);
            if (a2 != null) {
                final Bitmap a3 = Util.a(a2, 0, 0, a2.getWidth(), a2.getHeight(), this.bq, true);
                this.Z.runOnUiThread(new Runnable() {
                    public void run() {
                        if (f.this.aV != null) {
                            f.this.aV.setAnimationState(3 == f.this.bd ? 4 : 5);
                        }
                        f fVar = f.this;
                        Bitmap unused = fVar.bp = fVar.a(fVar.bp, a3, rect);
                    }
                });
            }
        } else if (c(processResult)) {
            final Rect rect2 = processResult.updateSmallImageRect;
            Bitmap a4 = e.a(this.Z, processResult.smallImageData, rect2.right - rect2.left, rect2.bottom - rect2.top);
            if (a4 != null) {
                final Bitmap a5 = Util.a(a4, 0, 0, a4.getWidth(), a4.getHeight(), this.bq, true);
                this.Z.runOnUiThread(new Runnable() {
                    public void run() {
                        f fVar = f.this;
                        Bitmap unused = fVar.bp = fVar.a(fVar.bp, a5, rect2);
                        f.this.bx.removeMessages(5);
                        Message obtainMessage = f.this.bx.obtainMessage(5);
                        obtainMessage.arg1 = processResult.outputOffset.x;
                        f.this.bx.sendMessage(obtainMessage);
                    }
                });
            }
        } else {
            fE();
        }
    }

    private void fE() {
        synchronized (av) {
            if (this.aW && this.bo != null) {
                this.bo.c();
                this.aW = false;
            }
        }
    }

    public void a(byte[] bArr, int i, int i2) {
        e.a("PanoramaCapMode", "onRearPanoramaSave, data: " + bArr + ", mbPaused: " + this.y);
        if (this.aj != null) {
            this.aj.setCapturing(false);
        }
        if (!this.y) {
            this.aX = false;
            this.X.c(5);
            this.bx.sendEmptyMessage(6);
            if (bArr != null) {
                z.a aVar = new z.a();
                aVar.e = bArr;
                aVar.j = eq() != null ? eq() : "jpeg";
                aVar.v = Util.b(bArr);
                aVar.i = null;
                aVar.q = i;
                aVar.r = i2;
                aVar.E = true;
                aVar.F = this.J;
                aVar.d = this.X.v();
                if (!this.y) {
                    this.X.a(aVar);
                } else {
                    this.aX = true;
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0091, code lost:
        b(r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0094, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void b(byte[] r10) {
        /*
            r9 = this;
            java.lang.Object r0 = r9.aP
            monitor-enter(r0)
            if (r10 == 0) goto L_0x0095
            android.graphics.Bitmap r1 = r9.aK     // Catch:{ all -> 0x00c1 }
            if (r1 == 0) goto L_0x0095
            android.graphics.Bitmap r1 = r9.aK     // Catch:{ all -> 0x00c1 }
            boolean r1 = r1.isRecycled()     // Catch:{ all -> 0x00c1 }
            if (r1 != 0) goto L_0x0095
            android.util.Size r1 = r9.aU     // Catch:{ all -> 0x00c1 }
            if (r1 != 0) goto L_0x0017
            goto L_0x0095
        L_0x0017:
            com.oppo.camera.panorama.d r1 = r9.bv     // Catch:{ all -> 0x00c1 }
            if (r1 == 0) goto L_0x0025
            com.oppo.camera.panorama.d r1 = r9.bv     // Catch:{ all -> 0x00c1 }
            boolean r1 = r1.b()     // Catch:{ all -> 0x00c1 }
            if (r1 == 0) goto L_0x0025
            monitor-exit(r0)     // Catch:{ all -> 0x00c1 }
            return
        L_0x0025:
            android.util.Size r1 = r9.aS     // Catch:{ all -> 0x00c1 }
            if (r1 == 0) goto L_0x0082
            android.app.Activity r1 = r9.Z     // Catch:{ all -> 0x00c1 }
            if (r1 == 0) goto L_0x0082
            int r1 = r10.length     // Catch:{ all -> 0x00c1 }
            r2 = 1
            if (r1 <= r2) goto L_0x0082
            android.app.Activity r3 = r9.Z     // Catch:{ all -> 0x00c1 }
            android.util.Size r1 = r9.aS     // Catch:{ all -> 0x00c1 }
            int r5 = r1.getWidth()     // Catch:{ all -> 0x00c1 }
            android.util.Size r1 = r9.aS     // Catch:{ all -> 0x00c1 }
            int r6 = r1.getHeight()     // Catch:{ all -> 0x00c1 }
            android.util.Size r1 = r9.aS     // Catch:{ all -> 0x00c1 }
            int r1 = r1.getWidth()     // Catch:{ all -> 0x00c1 }
            int r7 = r1 / 6
            android.util.Size r1 = r9.aS     // Catch:{ all -> 0x00c1 }
            int r1 = r1.getHeight()     // Catch:{ all -> 0x00c1 }
            int r8 = r1 / 6
            r4 = r10
            android.graphics.Bitmap r10 = com.oppo.camera.panorama.e.a(r3, r4, r5, r6, r7, r8)     // Catch:{ all -> 0x00c1 }
            r9.aK = r10     // Catch:{ all -> 0x00c1 }
            android.graphics.Matrix r6 = new android.graphics.Matrix     // Catch:{ all -> 0x00c1 }
            r6.<init>()     // Catch:{ all -> 0x00c1 }
            r10 = 1119092736(0x42b40000, float:90.0)
            r6.postRotate(r10)     // Catch:{ all -> 0x00c1 }
            r10 = 1065353216(0x3f800000, float:1.0)
            r1 = -1082130432(0xffffffffbf800000, float:-1.0)
            r6.postScale(r10, r1)     // Catch:{ all -> 0x00c1 }
            android.graphics.Bitmap r10 = r9.aK     // Catch:{ all -> 0x00c1 }
            if (r10 == 0) goto L_0x0082
            android.graphics.Bitmap r1 = r9.aK     // Catch:{ all -> 0x00c1 }
            r2 = 0
            r3 = 0
            android.graphics.Bitmap r10 = r9.aK     // Catch:{ all -> 0x00c1 }
            int r4 = r10.getWidth()     // Catch:{ all -> 0x00c1 }
            android.graphics.Bitmap r10 = r9.aK     // Catch:{ all -> 0x00c1 }
            int r5 = r10.getHeight()     // Catch:{ all -> 0x00c1 }
            r7 = 1
            android.graphics.Bitmap r10 = com.oppo.camera.util.Util.a(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x00c1 }
            r9.aK = r10     // Catch:{ all -> 0x00c1 }
        L_0x0082:
            com.oppo.camera.panorama.d r10 = r9.bv     // Catch:{ all -> 0x00c1 }
            if (r10 == 0) goto L_0x008f
            com.oppo.camera.panorama.d r10 = r9.bv     // Catch:{ all -> 0x00c1 }
            android.graphics.Bitmap r1 = r9.aK     // Catch:{ all -> 0x00c1 }
            android.graphics.Bitmap r10 = r10.a((android.graphics.Bitmap) r1)     // Catch:{ all -> 0x00c1 }
            goto L_0x0090
        L_0x008f:
            r10 = 0
        L_0x0090:
            monitor-exit(r0)     // Catch:{ all -> 0x00c1 }
            r9.b((android.graphics.Bitmap) r10)
            return
        L_0x0095:
            java.lang.String r1 = "PanoramaCapMode"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x00c1 }
            r2.<init>()     // Catch:{ all -> 0x00c1 }
            java.lang.String r3 = "processFrontPreviewFrame, data: "
            r2.append(r3)     // Catch:{ all -> 0x00c1 }
            r2.append(r10)     // Catch:{ all -> 0x00c1 }
            java.lang.String r10 = ", mFrontPreviewBitmap: "
            r2.append(r10)     // Catch:{ all -> 0x00c1 }
            android.graphics.Bitmap r10 = r9.aK     // Catch:{ all -> 0x00c1 }
            r2.append(r10)     // Catch:{ all -> 0x00c1 }
            java.lang.String r10 = ", mPictureSize: "
            r2.append(r10)     // Catch:{ all -> 0x00c1 }
            android.util.Size r10 = r9.aU     // Catch:{ all -> 0x00c1 }
            r2.append(r10)     // Catch:{ all -> 0x00c1 }
            java.lang.String r10 = r2.toString()     // Catch:{ all -> 0x00c1 }
            com.oppo.camera.e.e(r1, r10)     // Catch:{ all -> 0x00c1 }
            monitor-exit(r0)     // Catch:{ all -> 0x00c1 }
            return
        L_0x00c1:
            r10 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00c1 }
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.panorama.f.b(byte[]):void");
    }

    /* access modifiers changed from: protected */
    public boolean a(Image image) {
        super.a(image);
        if (image != null && !this.y && this.aI && this.aH && (this.X == null || !this.X.B())) {
            if (this.t) {
                byte[] a2 = Util.a(image, 17);
                b(a2);
                d dVar = this.bv;
                if (dVar != null) {
                    dVar.b(a2);
                }
            } else if (!this.aW) {
                this.be = Util.a(image, 17, this.be);
                this.bx.removeMessages(7);
                this.bx.obtainMessage(7, this.be).sendToTarget();
            } else if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_PANORAMA_REAR_PROCESS_IMAGE)) {
                synchronized (av) {
                    if (this.bo != null) {
                        this.bo.a(image);
                        return false;
                    }
                }
            } else {
                ByteBuffer[] byteBufferArr = {image.getPlanes()[0].getBuffer(), image.getPlanes()[2].getBuffer()};
                synchronized (av) {
                    if (this.bo != null) {
                        this.bo.a(byteBufferArr);
                    }
                }
                if (Util.b()) {
                    byte[] a3 = Util.a(image, 17);
                    Util.a(a3, "dump_rear", System.currentTimeMillis() + "_" + this.aT.getWidth() + "x" + this.aT.getHeight());
                }
            }
        }
        return true;
    }

    public f(Activity activity, b bVar, com.oppo.camera.ui.e eVar, n nVar) {
        super(activity, bVar, eVar, nVar);
    }

    public boolean r(String str) {
        if ("type_still_capture_yuv_main".equals(str)) {
            return false;
        }
        if ("type_preview_frame".equals(str)) {
            return true;
        }
        if ("type_tuning_data_yuv".equals(str)) {
            return false;
        }
        return super.r(str);
    }

    /* access modifiers changed from: protected */
    public void a(com.oppo.camera.f.d dVar, CaptureRequest.Builder builder, HashMap<String, f.C0084f> hashMap, int i) {
        if (d.a.PREVIEW == dVar.a() && hashMap.containsKey("type_preview_frame")) {
            builder.addTarget(hashMap.get("type_preview_frame").a());
        }
        super.a(dVar, builder, hashMap, i);
    }

    /* access modifiers changed from: protected */
    public long aK() {
        return (long) CameraConfig.getConfigIntValue(ConfigDataBase.KEY_HAL_MEMORY_PANORAMA);
    }

    public boolean f() {
        return this.X.j();
    }

    public boolean d() {
        return this.X.j();
    }

    /* access modifiers changed from: protected */
    public void s() {
        e.a("PanoramaCapMode", "onInitCameraMode()");
        this.aI = true;
        int i = 0;
        this.aH = false;
        this.bb = false;
        this.aO = this.Z.getResources();
        fF();
        this.aY = this.X.s();
        if (this.t) {
            i = this.aY;
        }
        this.aY = i;
        this.Y.a(true);
        this.Y.a(true, true, true);
        this.Y.e("pref_camera_photo_ratio_key");
        this.Y.d(2);
        this.Y.c(this.Z.getString(R.string.camera_description_common_shutter_button));
        e.a("PanoramaCapMode", "onInitCameraMode X");
    }

    private void fF() {
        this.aF = Util.v();
        this.aw = this.aO.getDimensionPixelSize(R.dimen.panorama_rect_width);
        this.ax = this.aO.getDimensionPixelSize(R.dimen.panorama_rect_height);
        this.ay = this.aO.getDimensionPixelSize(R.dimen.panorama_rect_to_left);
        this.az = this.aO.getDimensionPixelSize(R.dimen.panorama_rect_to_top);
        this.aA = this.aO.getDimensionPixelSize(R.dimen.panorama_progressbar_margin_top);
        this.aB = this.aO.getDimensionPixelSize(R.dimen.panorama_progressbar_margin_left);
        this.aE = this.aO.getDimensionPixelSize(R.dimen.panorama_view_gap);
        int i = this.ax;
        this.bf = i - (this.aA * 2);
        this.aC = this.aE + i;
        this.aD = (this.az + i) - this.aF;
        this.bh = Math.round(Util.i() * 150.0f);
        if (this.aQ == null) {
            LayoutInflater from = LayoutInflater.from(this.Z);
            this.aQ = (RelativeLayout) from.inflate(this.aO.getLayout(R.layout.panorama), (ViewGroup) null);
            this.aR = (CameraScreenHintView) from.inflate(this.aO.getLayout(R.layout.camera_screen_hint), (ViewGroup) null);
            this.aR.setChangeHintColor(true);
            this.aR.setChangeHintTextShadow(true);
            this.aL = (ImageView) this.aQ.findViewById(R.id.preview_view);
            this.aM = (FrontPanoramaGuideView) this.aQ.findViewById(R.id.capture_guide_view);
            this.aM.setOnDirectionChangeListener(this.at);
            this.aN = (TextView) this.aQ.findViewById(R.id.capture_guide_tips);
            this.aV = new PanoramaProgressBar(this.Z);
            this.aV.setRearPanoramaInterface(this.au);
            this.aV.setForceDarkAllowed(false);
            this.aV.setContentDescription(this.Z.getString(R.string.camera_description_arrow_left_to_right));
            this.aQ.addView(this.aR);
            this.aQ.addView(this.aV);
            this.aQ.setVisibility(8);
            this.ac.removeView(this.aQ);
            this.ac.addView(this.aQ);
        }
        H(this.n);
        this.aV.b();
    }

    public void t() {
        e.a("PanoramaCapMode", "onDeInitCameraMode()");
        this.aI = false;
        this.aG = false;
        this.bb = false;
        this.aR.c(false);
        Handler handler = this.bx;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
        }
        fH();
        fL();
        if (this.W != null) {
            this.W.q(0);
            this.W.a(false, false);
            this.W.e(false);
            this.W.a(4, com.oppo.camera.a.a(), com.oppo.camera.a.a(), true);
        }
        this.Y.b("pref_camera_photo_ratio_key", (String) null);
        this.Y.d(1);
    }

    private void fG() {
        if (this.aQ != null) {
            PanoramaProgressBar panoramaProgressBar = this.aV;
            if (panoramaProgressBar != null) {
                panoramaProgressBar.c();
                this.aQ.removeView(this.aV);
                this.aV = null;
            }
            if (this.aR != null) {
                this.aR = null;
            }
            if (this.aL != null) {
                this.aL = null;
            }
            FrontPanoramaGuideView frontPanoramaGuideView = this.aM;
            if (frontPanoramaGuideView != null) {
                frontPanoramaGuideView.b();
                this.aM = null;
            }
            if (this.aN != null) {
                this.aN = null;
            }
            this.aQ.removeAllViews();
            this.ac.removeView(this.aQ);
            this.aQ = null;
        }
        fJ();
    }

    private void fH() {
        e.a("PanoramaCapMode", "releaseRearPanorama");
        if (this.aj != null) {
            this.aj.setCapturing(false);
        }
        synchronized (av) {
            this.aW = false;
            if (this.bo != null) {
                this.bo.a();
                this.bo.b();
                this.bo = null;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void a(boolean z) {
        e.a("PanoramaCapMode", "onResume");
        PanoramaProgressBar panoramaProgressBar = this.aV;
        if (panoramaProgressBar != null) {
            panoramaProgressBar.b();
            this.aV.postInvalidate();
        }
        RelativeLayout relativeLayout = this.aQ;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(0);
            this.aQ.setAlpha(1.0f);
        }
        if (this.t) {
            F(8);
        }
        this.Y.j(0);
        this.Y.a(o(), false);
        this.Y.e(0);
        this.Y.f(0);
        this.Y.h(0);
        this.Y.b(0, true);
    }

    /* access modifiers changed from: protected */
    public void bg() {
        this.bx.removeCallbacksAndMessages((Object) null);
        PanoramaProgressBar panoramaProgressBar = this.aV;
        if (panoramaProgressBar != null) {
            panoramaProgressBar.b();
            this.aV.postInvalidate();
        }
        this.Y.a(o(), false);
        if (this.t) {
            this.bx.removeMessages(1);
            Handler handler = this.bx;
            handler.sendMessage(handler.obtainMessage(1, true));
        } else {
            fE();
        }
        this.aG = false;
    }

    /* access modifiers changed from: protected */
    public void p() {
        e.a("PanoramaCapMode", "onPause");
        if (this.aG) {
            bg();
        }
        fH();
        G(4);
        this.aL.setVisibility(4);
        this.Y.j(0);
        if (this.t) {
            this.aR.c(false);
        }
        this.aH = false;
        d dVar = this.bv;
        if (dVar != null) {
            dVar.a();
            this.bv.b(false);
            this.bv.d();
        }
    }

    /* access modifiers changed from: protected */
    public void r() {
        fG();
    }

    public boolean au() {
        super.au();
        d dVar = this.bv;
        if (dVar == null) {
            return false;
        }
        dVar.e();
        return false;
    }

    public boolean b(MotionEvent motionEvent) {
        if (this.aW || this.aG || this.t || this.aV == null) {
            return false;
        }
        this.bx.removeMessages(4);
        this.bx.sendEmptyMessageDelayed(4, 5000);
        return this.aV.a(motionEvent);
    }

    /* access modifiers changed from: protected */
    public void u() {
        e.a("PanoramaCapMode", "onBeforePreview");
        this.aH = false;
        if (!this.t) {
            this.bx.removeMessages(3);
            this.bx.obtainMessage(3, 0).sendToTarget();
        }
        this.L = false;
    }

    public void f(boolean z) {
        e.a("PanoramaCapMode", "onAfterStartPreview");
        if (!this.aH) {
            this.aH = true;
            this.bb = true;
            this.aG = false;
            this.Z.runOnUiThread(new Runnable() {
                public void run() {
                    if (f.this.t) {
                        if (f.this.bv != null) {
                            f.this.bv.a();
                        }
                        f.this.G(true);
                        f.this.fK();
                        return;
                    }
                    f fVar = f.this;
                    Size unused = fVar.aT = fVar.g(fVar.W.e());
                    f fVar2 = f.this;
                    int unused2 = fVar2.bl = fVar2.aT.getWidth() / 2;
                    f fVar3 = f.this;
                    int unused3 = fVar3.bg = (fVar3.bf * f.this.aT.getHeight()) / f.this.aT.getWidth();
                    f fVar4 = f.this;
                    int unused4 = fVar4.bj = fVar4.aT.getWidth() / 8;
                    f fVar5 = f.this;
                    int unused5 = fVar5.bi = ((fVar5.aT.getHeight() / 8) / 2) * 2;
                    f fVar6 = f.this;
                    float unused6 = fVar6.bm = ((float) fVar6.bf) / ((float) f.this.bj);
                    int unused7 = f.this.bk = (int) (((float) (Util.E() - (f.this.aB * 2))) / f.this.bm);
                    f.this.bq.reset();
                    f.this.bq.postRotate(90.0f);
                    f.this.bq.postScale(f.this.bm, f.this.bm);
                    synchronized (f.av) {
                        if (f.this.bo == null) {
                            g unused8 = f.this.bo = new g(f.this.Z, f.this.aT.getWidth(), f.this.aT.getHeight(), f.this);
                        }
                    }
                }
            });
            super.f(z);
        }
    }

    public void ed() {
        super.ed();
        this.W.a(false, false);
        this.W.e(false);
        this.W.a(4, com.oppo.camera.a.a(), com.oppo.camera.a.a(), true);
    }

    /* access modifiers changed from: protected */
    public boolean a(com.oppo.camera.f.d dVar) {
        e.a("PanoramaCapMode", "onBeforeSnapping, mOrientation: " + this.aY);
        this.bs = true;
        if (this.t) {
            e.a("PanoramaCapMode", "createEngine enter, mbPaused: " + this.y + ", mbStartPreviewed: " + this.aH);
            if (this.bv != null && !this.y && this.aH) {
                boolean z = this.X.s() % 180 == 0;
                this.aZ = this.X.s();
                this.bv.a(z);
            }
        }
        this.Z.runOnUiThread(new Runnable() {
            public void run() {
                if (f.this.y) {
                    e.a("PanoramaCapMode", "onBeforeSnapping, return after pause");
                    return;
                }
                if (!f.this.t) {
                    synchronized (f.av) {
                        if (!(f.this.bo == null || f.this.aV == null)) {
                            f.this.bx.removeMessages(4);
                            Bitmap unused = f.this.bp = null;
                            int unused2 = f.this.bn = 0;
                            int unused3 = f.this.bd = f.this.aV.getDirection();
                            f.this.bo.a(f.this.bd);
                            boolean unused4 = f.this.aW = true;
                            f.this.Y.a(true, false);
                        }
                    }
                    boolean unused5 = f.this.aG = true;
                    f fVar = f.this;
                    fVar.e(fVar.aY);
                    f.this.F(0);
                    f.this.Y.b(4, true);
                }
                f.this.Y.j(4);
                f.this.Y.f(4);
                f.this.Y.h(4);
                f.this.Y.a(8, true);
                c cVar = new c(10, "button_color_inside_none");
                cVar.b(0);
                f.this.Y.a(cVar);
            }
        });
        if (1 != this.W.p()) {
            this.W.n();
        }
        this.aJ = false;
        this.W.a(true, false);
        this.W.e(true);
        this.W.a((f.c) null);
        return true;
    }

    public boolean aM() {
        e.a("PanoramaCapMode", "onAfterSnapping");
        this.Z.runOnUiThread(new Runnable() {
            public void run() {
                if (f.this.t) {
                    f.this.aR.c(false);
                    f.this.X.c(4);
                    f.this.aM.setNextDirection(1);
                    f.this.G(0);
                    boolean unused = f.this.aG = true;
                    return;
                }
                f.this.aR.c(false);
                f.this.aR.a(f.this.aD, 0, 0, false);
                f.this.aR.a(f.this.Z.getResources().getString(R.string.camera_panorama_rear_capturing), false, true);
                f.this.X.c(4);
            }
        });
        return true;
    }

    public boolean i(String str) {
        if ("pref_camera_timer_shutter_key".equals(str) || "pref_camera_photo_ratio_key".equals(str)) {
            return false;
        }
        return super.i(str);
    }

    public Size g(j jVar) {
        List<Size> a2 = jVar.a();
        if (this.t) {
            return Util.b(a2, 1.3333333333333333d, CameraConfig.getConfigIntValue(ConfigDataBase.KEY_FRONT_PANORAMA_MAX_HEIGHT));
        }
        return Util.b(a2, 1.3333333333333333d, CameraConfig.getConfigIntValue(ConfigDataBase.KEY_REAR_PANORAMA_MAX_HEIGHT));
    }

    public Size d(j jVar) {
        if (this.t) {
            return Util.c(jVar.a(256), 1.3333333333333333d);
        }
        return null;
    }

    public boolean br() {
        if (this.t) {
            return super.br();
        }
        return true;
    }

    public boolean bn() {
        e.a("PanoramaCapMode", "isAllowSwitch, mbStartPreviewed: " + this.aH);
        if (!this.bb) {
            return true;
        }
        if (this.aG || !this.aH) {
            return false;
        }
        return true;
    }

    public c o() {
        c o = super.o();
        o.b("button_shape_ring_none");
        return o;
    }

    public boolean f(String str) {
        if ("pref_camera_tap_shutter_key".equals(str) || "pref_camera_gesture_shutter_key".equals(str) || "pref_time_lapse_key".equals(str) || "pref_zoom_key".equals(str) || "pref_support_rotate_hint_view".equals(str) || "key_capturing_click_close".equals(str)) {
            return false;
        }
        if ("pref_sstart_preview_sync".equals(str)) {
            return true;
        }
        if (!CameraFunction.RESET_AUTO_FOCUS.equals(str)) {
            return super.f(str);
        }
        if (this.X.h() == 1) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean v() {
        this.aJ = true;
        this.br = this.X.Z();
        if (this.t) {
            e.a("PanoramaCapMode", "onStopTakePicture, mFrontJpegCount: " + this.ba + ", mbSnapShoting: " + this.aG);
            int i = this.ba;
            if (i == 0) {
                return false;
            }
            if (this.aG && i > 0) {
                this.aG = false;
                this.bc = true;
                final c cVar = new c(11, "button_color_inside_none");
                cVar.b(0);
                this.Z.runOnUiThread(new Runnable() {
                    public void run() {
                        f.this.Y.a(cVar);
                    }
                });
                d dVar = this.bv;
                if (dVar != null) {
                    dVar.c();
                }
            }
            return true;
        }
        e.a("PanoramaCapMode", "onStopTakePicture, mbPanning: " + this.aW + ", mbSnapShoting: " + this.aG + ", mbRearCapturePicSaveDone: " + this.aX);
        fE();
        if (this.aG || this.aV.d() || !this.aX) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void a(byte[] bArr, boolean z) {
        if (this.t) {
            this.Y.d(true, false);
        }
    }

    public void F(int i) {
        e.a("PanoramaCapMode", "setProgressBarVisble, visible: " + i);
        if (i == 0) {
            this.aR.a(this.aD, 0, 0, false);
            String string = this.Z.getString(R.string.camera_panorama_rear_prepare);
            if (this.aR.getHintTextView().getVisibility() != 0 || !string.equals(this.aR.getHintTextView().getText())) {
                this.aR.a(string, true, false, 0, (int) R.color.screen_hint_text_color);
            }
        } else {
            this.aR.c(false);
        }
        PanoramaProgressBar panoramaProgressBar = this.aV;
        if (panoramaProgressBar != null && panoramaProgressBar.getVisibility() != i) {
            this.aV.setVisibility(i);
        }
    }

    public void e(int i) {
        e.a("PanoramaCapMode", "setOrientation(), orientation: " + i);
        if (this.t) {
            this.aY = i;
        }
    }

    /* access modifiers changed from: protected */
    public void b(byte[] bArr, boolean z) {
        this.Y.a(true, false);
    }

    public void d(int i) {
        e.a("PanoramaCapMode", "cameraIdChanged, mCameraId: " + this.n);
        super.d(i);
        Handler handler = this.bx;
        if (handler != null) {
            handler.removeMessages(3);
            this.bx.removeMessages(4);
        }
        PanoramaProgressBar panoramaProgressBar = this.aV;
        if (panoramaProgressBar != null) {
            panoramaProgressBar.f();
        }
        fH();
        fL();
        this.Z.runOnUiThread(new Runnable() {
            public void run() {
                if (!f.this.y) {
                    f fVar = f.this;
                    fVar.H(fVar.n);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void H(int i) {
        PanoramaProgressBar panoramaProgressBar = this.aV;
        if (panoramaProgressBar != null) {
            panoramaProgressBar.a(this.aw, this.ax, this.ay, this.az, this.aA, this.aB);
        }
        if (com.oppo.camera.f.a.c(i)) {
            this.aL.setImageBitmap((Bitmap) null);
            F(8);
            return;
        }
        this.aL.setVisibility(8);
        this.aY = 0;
        PanoramaProgressBar panoramaProgressBar2 = this.aV;
        if (panoramaProgressBar2 != null) {
            panoramaProgressBar2.postInvalidate();
        }
    }

    public void bK() {
        this.Y.e("pref_camera_photo_ratio_key");
        super.bK();
    }

    public void i_() {
        if (this.Z != null) {
            this.Z.runOnUiThread(new Runnable() {
                public void run() {
                    f.this.Y.a(true, false);
                }
            });
        }
    }

    public void j_() {
        if (this.X != null) {
            this.X.c(5);
        }
    }

    public void a(boolean z, byte[] bArr, int i, int i2) {
        e.a("PanoramaCapMode", "onImageDataSave enter");
        if (this.aj != null) {
            this.aj.setCapturing(false);
        }
        if (!(bArr == null || this.X == null || this.aU == null)) {
            if (z) {
                int i3 = i2;
                i2 = i;
                i = i3;
            }
            z.a aVar = new z.a();
            aVar.q = i;
            aVar.r = i2;
            aVar.e = bArr;
            aVar.j = eq() != null ? eq() : "jpeg";
            aVar.v = Util.b(aVar.e);
            aVar.i = null;
            aVar.E = true;
            aVar.F = this.J;
            aVar.d = this.X.v();
            this.X.a(aVar);
        }
        l_();
        this.aZ = 0;
    }

    /* access modifiers changed from: protected */
    public e.b aN() {
        return new e.b() {
            public void a(long j) {
                boolean unused = f.this.aX = true;
            }
        };
    }

    public void G(boolean z) {
        com.oppo.camera.e.a("PanoramaCapMode", "initFrontPanorama, mbPaused: " + this.y + ", mbStartPreviewed: " + this.aH + ", mViewGroup: " + this.aQ);
        if (!this.y && this.aQ != null && this.aH) {
            synchronized (this.aP) {
                if (this.aK != null) {
                    this.aK.recycle();
                    this.aK = null;
                }
            }
            this.ba = 0;
            this.aU = d(this.W.e());
            this.aS = g(this.W.e());
            if (this.aS != null) {
                synchronized (this.aP) {
                    this.aK = Util.a((this.aS.getHeight() * 2) / 6, this.aS.getWidth() / 6, Bitmap.Config.ARGB_8888);
                    int width = (int) (((((float) this.aK.getWidth()) * 1.0f) * ((float) this.ax)) / ((float) this.aK.getHeight()));
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(width, this.ax);
                    layoutParams.addRule(10);
                    layoutParams.addRule(9);
                    layoutParams.topMargin = this.aE + this.aF;
                    layoutParams.leftMargin = (Util.E() - width) / 2;
                    if (z) {
                        this.aL.setImageBitmap((Bitmap) null);
                    }
                    this.aL.setLayoutParams(layoutParams);
                    this.aL.setVisibility(0);
                }
                this.aQ.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
                com.oppo.camera.e.a("PanoramaCapMode", "initFrontPanorama, mPictureSize: " + this.aU.getWidth() + " x " + this.aU.getHeight() + ", mPreviewFrameSize: " + this.aS.getWidth() + " x " + this.aS.getHeight());
            }
            this.aR.a(this.aC, 0, 0, false);
            this.aR.a(this.Z.getString(R.string.camera_panorama_front_previewing), true, false, 0, (int) R.color.screen_hint_text_color);
        }
    }

    /* access modifiers changed from: protected */
    public void eh() {
        PanoramaProgressBar panoramaProgressBar = this.aV;
        if (panoramaProgressBar != null) {
            panoramaProgressBar.setVisibility(8);
        }
    }

    public void al() {
        if (this.t) {
            this.Z.runOnUiThread(new Runnable() {
                public void run() {
                    f.this.aR.a(f.this.Z.getString(R.string.camera_toast_camera_Low_memory_hint), false, true);
                }
            });
        } else {
            this.Y.a((int) R.string.camera_toast_camera_Low_memory_hint, -1, true, false, false);
        }
    }

    /* access modifiers changed from: private */
    public void fI() {
        if (this.aH) {
            a((byte[]) null, 0, 0, Util.a(aQ()), false, false, 0);
        }
        this.Y.j(0);
        if (!this.bc && !this.y) {
            c cVar = new c(11, "button_color_inside_none");
            cVar.b(0);
            this.Y.a(cVar);
        }
        this.bc = false;
        this.Y.e(0);
        this.Y.f(0);
        this.Y.h(0);
        this.Y.a(0, true);
        this.W.a(false, false);
        this.W.e(false);
        this.W.a(4, com.oppo.camera.a.a(), com.oppo.camera.a.a(), true);
        this.W.a((f.c) null);
        this.aG = false;
        this.ba = 0;
        G(4);
    }

    private void fJ() {
        synchronized (this.aP) {
            if (this.aK != null) {
                this.aK.recycle();
                this.aK = null;
            }
        }
    }

    public void G(final int i) {
        AlphaAnimation alphaAnimation;
        FrontPanoramaGuideView frontPanoramaGuideView = this.aM;
        if (frontPanoramaGuideView == null) {
            return;
        }
        if (frontPanoramaGuideView.getVisibility() != i) {
            if (i == 0) {
                alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            } else {
                alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            }
            alphaAnimation.setDuration(300);
            alphaAnimation.setAnimationListener(new Animation.AnimationListener() {
                public void onAnimationRepeat(Animation animation) {
                }

                public void onAnimationStart(Animation animation) {
                    if (i == 0) {
                        f.this.aM.setVisibility(i);
                        f.this.aN.setVisibility(i);
                    }
                }

                public void onAnimationEnd(Animation animation) {
                    f.this.aM.setVisibility(i);
                    f.this.aN.setVisibility(i);
                }
            });
            this.aN.clearAnimation();
            this.aN.startAnimation(alphaAnimation);
            this.aM.clearAnimation();
            this.aM.startAnimation(alphaAnimation);
            return;
        }
        Animation animation = this.aM.getAnimation();
        if (animation != null) {
            animation.reset();
            animation.cancel();
        }
        this.aN.clearAnimation();
        this.aN.setVisibility(i);
        this.aM.clearAnimation();
        this.aM.setVisibility(i);
    }

    public void c(int i, boolean z) {
        super.c(i, z);
        if (i != 1) {
            if (i != 2) {
                if (i == 5) {
                    if (!z) {
                        F(8);
                    } else if (!this.t) {
                        F(0);
                    }
                }
            } else if (z) {
                Util.a((View) this.aQ, 0, (Animation.AnimationListener) null, 300);
            } else {
                this.Y.a(true, true, true);
                this.aQ.setVisibility(8);
            }
        } else if (z) {
            Util.a((View) this.aQ, 0, (Animation.AnimationListener) null, 300);
        } else {
            Util.a((View) this.aQ, 8, (Animation.AnimationListener) null, 300);
        }
    }

    public DcsMsgData b(DcsMsgData dcsMsgData) {
        PanoramaProgressBar panoramaProgressBar;
        if (dcsMsgData == null || !(dcsMsgData instanceof CaptureMsgData)) {
            return null;
        }
        CaptureMsgData captureMsgData = (CaptureMsgData) dcsMsgData;
        captureMsgData.mShutterType = bB();
        if (this.t || (panoramaProgressBar = this.aV) == null) {
            return captureMsgData;
        }
        captureMsgData.mPanoramaDirection = I(panoramaProgressBar.getDirection());
        captureMsgData.mAeAfLock = String.valueOf(this.X.X());
        captureMsgData.mTouchXYValue = this.X.Y();
        return captureMsgData;
    }

    public void a(ApsTotalResult apsTotalResult) {
        CaptureResult.Key key;
        CaptureResult.Key key2;
        super.a(apsTotalResult);
        if (apsTotalResult == null || apsTotalResult.getTotalResult() == null) {
            com.oppo.camera.e.e("PanoramaCapMode", "onPreviewCaptureResult, invalid totalResult: " + apsTotalResult);
        } else if (this.bs) {
            this.bs = false;
            CaptureResult totalResult = apsTotalResult.getTotalResult();
            if (Util.p()) {
                key2 = com.oppo.camera.f.c.N;
                key = com.oppo.camera.f.c.O;
            } else {
                key2 = com.oppo.camera.f.c.aa;
                key = com.oppo.camera.f.c.Q;
            }
            if (key2 != null) {
                try {
                    this.bt = ((int[]) totalResult.get(key2))[0];
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (key != null) {
                try {
                    this.bu = ((float[]) totalResult.get(key))[0];
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public DcsMsgData b(DcsMsgData dcsMsgData, z.a aVar) {
        if (dcsMsgData != null && (dcsMsgData instanceof CaptureMsgData)) {
            CaptureMsgData captureMsgData = (CaptureMsgData) dcsMsgData;
            if (this.aJ) {
                captureMsgData.mShutterType += DcsMsgData.DIVIDER + this.br;
            } else {
                captureMsgData.mShutterType += "|end";
            }
            Size a2 = z.a(Util.a(aVar.e));
            if (a2 != null) {
                captureMsgData.mWidth = String.valueOf(a2.getWidth());
                captureMsgData.mHeight = String.valueOf(a2.getHeight());
            }
            captureMsgData.mCCT = String.valueOf(this.bt);
            captureMsgData.mLux = String.valueOf(this.bu);
        }
        return super.b(dcsMsgData, aVar);
    }

    /* access modifiers changed from: protected */
    public String ei() {
        if (this.t) {
            return this.Z.getString(R.string.camera_picture_size_standard);
        }
        return this.Z.getString(R.string.camera_picture_size_full);
    }

    /* access modifiers changed from: protected */
    public int y(int i) {
        if (com.oppo.camera.f.a.c(i)) {
            return CameraConfig.getConfigIntValue(ConfigDataBase.KEY_PANORAMA_TO_REAL_SWITCH_ANIM_TIME);
        }
        return CameraConfig.getConfigIntValue(ConfigDataBase.KEY_PANORAMA_TO_FRONT_SWITCH_ANIM_TIME);
    }

    /* access modifiers changed from: private */
    public void J(int i) {
        MenuClickMsgData menuClickMsgData = new MenuClickMsgData(this.Z);
        menuClickMsgData.buildEvent(false);
        menuClickMsgData.mCaptureMode = ApsConstant.CAPTURE_MODE_PANORAMA;
        menuClickMsgData.mCaptureType = 0;
        menuClickMsgData.mFuncKeyId = 19;
        menuClickMsgData.mOrientation = this.aY;
        menuClickMsgData.mFuncKeyResult = i;
        menuClickMsgData.mRearOrFront = this.t ? DcsMsgData.FRONT : DcsMsgData.REAR;
        menuClickMsgData.report();
    }

    public void b(Bitmap bitmap) {
        if (bitmap == null) {
            com.oppo.camera.e.e("PanoramaCapMode", "sendToUpdateGuideBitmap error, bitmap is null");
            return;
        }
        Handler handler = this.bx;
        if (handler != null) {
            handler.removeMessages(2);
            Message obtainMessage = this.bx.obtainMessage(2);
            obtainMessage.obj = bitmap;
            obtainMessage.sendToTarget();
        }
    }

    /* access modifiers changed from: private */
    public void fK() {
        com.oppo.camera.e.a("PanoramaCapMode", "initFrontManager enter");
        this.bv = new d(this.Z, this.aS, TextUtils.equals(bA(), "on"), this, com.oppo.camera.f.a.a(this.n).j());
    }

    private void fL() {
        d dVar = this.bv;
        if (dVar != null) {
            dVar.a();
            this.bv.d();
        }
    }

    public int i() {
        int i = this.aZ;
        return (i + (i % 180 == 0 ? 180 : 90)) % 360;
    }

    public boolean k_() {
        return eq() != null;
    }

    public void a_(int i) {
        FrontPanoramaGuideView frontPanoramaGuideView = this.aM;
        if (frontPanoramaGuideView != null) {
            frontPanoramaGuideView.setNextDirection(i);
        }
    }

    public void l_() {
        com.oppo.camera.e.a("PanoramaCapMode", "sendFrontResetMessage enter");
        if (this.bx != null && !this.y) {
            this.bx.removeMessages(1);
            Handler handler = this.bx;
            handler.sendMessage(handler.obtainMessage(1, false));
        }
    }

    public boolean ea() {
        return 1 != this.X.h() || this.X.C();
    }

    public void a(Bitmap bitmap) {
        b(bitmap);
    }

    public void m_() {
        this.ba++;
    }

    private boolean c(ProcessResult processResult) {
        boolean z;
        if (3 != this.bd ? 2 != this.bd || processResult.updateSmallImageRect.bottom >= this.bk : this.bl - processResult.updateSmallImageRect.top >= this.bk) {
            z = false;
        } else {
            z = true;
        }
        if (!z || Math.abs(processResult.outputOffset.x - this.bn) >= this.bh) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public Bitmap a(Bitmap bitmap, Bitmap bitmap2, Rect rect) {
        if (3 == this.bd) {
            float f = this.bm;
            Bitmap a2 = Util.a((int) (((float) (this.bl - rect.top)) * f), (int) (((float) this.bj) * f), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(a2);
            if (bitmap != null && !bitmap.isRecycled()) {
                canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
            }
            canvas.drawBitmap(bitmap2, (float) ((int) (((float) (this.bl - rect.bottom)) * this.bm)), ((float) rect.left) * this.bm, (Paint) null);
            canvas.save();
            canvas.restore();
            return a2;
        } else if (2 != this.bd) {
            return null;
        } else {
            float f2 = this.bm;
            Bitmap a3 = Util.a((int) (((float) rect.bottom) * f2), (int) (((float) this.bj) * f2), Bitmap.Config.ARGB_8888);
            Canvas canvas2 = new Canvas(a3);
            if (bitmap != null && !bitmap.isRecycled()) {
                canvas2.drawBitmap(bitmap, (float) (a3.getWidth() - bitmap.getWidth()), 0.0f, (Paint) null);
            }
            canvas2.drawBitmap(bitmap2, 0.0f, ((float) rect.left) * this.bm, (Paint) null);
            canvas2.save();
            canvas2.restore();
            return a3;
        }
    }
}
