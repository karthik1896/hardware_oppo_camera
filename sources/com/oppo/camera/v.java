package com.oppo.camera;

import android.app.Activity;
import android.app.KeyguardManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Size;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.OplusWindowManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.PlanarYUVLuminanceSource;
import com.google.zxing.Result;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.QRCodeReader;
import com.oppo.camera.p.a.f;
import com.oppo.camera.p.b;
import com.oppo.camera.p.c;
import com.oppo.camera.statistics.CameraStatisticsUtil;
import com.oppo.camera.statistics.model.QrCodeDcsMsgData;
import com.oppo.camera.ui.CameraQrCodeJumpView;
import com.oppo.camera.ui.CameraQrCodeView;
import com.oppo.camera.ui.preview.PreviewFrameLayout;
import com.oppo.camera.util.Util;
import com.oppo.camera.util.YuvUtil;
import java.util.Hashtable;
import java.util.Map;
import java.util.Random;

/* compiled from: QrCodeManager */
public class v implements View.OnClickListener {
    private f A = null;
    private YuvUtil B = null;
    private int C = -1;
    /* access modifiers changed from: private */
    public Handler D = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message message) {
            int i = message.what;
            if (i != 1) {
                if (i == 2) {
                    if (!(message.obj == null || v.this.c == null || v.this.c.getParent() == null)) {
                        v.this.c.a(((Boolean) message.obj).booleanValue());
                        synchronized (v.this.t) {
                            if (v.this.v != null) {
                                v.this.v.ax();
                            }
                        }
                    }
                    v.this.t();
                } else if (i == 4) {
                    v.this.t();
                } else if (i == 5) {
                    v.this.o();
                }
            } else if (message.obj == null || v.this.c == null || v.this.i || !v.this.k || v.this.n) {
                v.this.c();
            } else {
                b unused = v.this.e = (b) message.obj;
                if (v.this.g == null || !TextUtils.equals(v.this.g.a(), v.this.e.a()) || !v.this.m) {
                    e.a("QrCodeManager", "handleMessage, MSG_QR_CODE_RESULT: " + v.this.k);
                    v.this.a();
                    v.this.a(true);
                    v.this.s();
                    return;
                }
                v.this.c();
            }
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private Activity f3162a = null;

    /* renamed from: b  reason: collision with root package name */
    private c f3163b = null;
    /* access modifiers changed from: private */
    public CameraQrCodeJumpView c = null;
    private CameraQrCodeView d = null;
    /* access modifiers changed from: private */
    public b e = null;
    private KeyguardManager f = null;
    /* access modifiers changed from: private */
    public b g = null;
    private int h;
    /* access modifiers changed from: private */
    public boolean i = false;
    private boolean j = true;
    /* access modifiers changed from: private */
    public boolean k = true;
    private boolean l = false;
    /* access modifiers changed from: private */
    public boolean m = false;
    /* access modifiers changed from: private */
    public boolean n = false;
    private boolean o = false;
    /* access modifiers changed from: private */
    public Handler p = null;
    private Handler q = null;
    private int r = 0;
    private QrCodeDcsMsgData s = null;
    /* access modifiers changed from: private */
    public Object t = new Object();
    private k u = null;
    /* access modifiers changed from: private */
    public com.oppo.camera.e.b v = null;
    private int w = 255;
    private a x = null;
    private Map<DecodeHintType, Object> y = null;
    private QRCodeReader z = null;

    public void a() {
        e.a("QrCodeManager", "clearHistory, mHistoryQrCodeScanResult: " + this.g + " ,mQrCodeScanResult: " + this.e);
        this.g = null;
        this.m = false;
    }

    public void b() {
        this.p.removeMessages(6);
        this.p.removeMessages(2);
        this.p.removeMessages(8);
        this.p.removeMessages(9);
    }

    /* access modifiers changed from: private */
    public void o() {
        CameraQrCodeJumpView cameraQrCodeJumpView = this.c;
        if (!(cameraQrCodeJumpView == null || cameraQrCodeJumpView.getParent() == null || !this.c.b())) {
            this.c.clearAnimation();
            this.c.setVisibility(8);
            synchronized (this.t) {
                if (this.v != null) {
                    this.v.ax();
                }
            }
        }
        CameraQrCodeView cameraQrCodeView = this.d;
        if (cameraQrCodeView != null && cameraQrCodeView.a()) {
            this.d.clearAnimation();
            this.d.setVisibility(4);
        }
    }

    public v(Activity activity, k kVar, com.oppo.camera.e.b bVar, int i2) {
        this.f3162a = activity;
        this.u = kVar;
        this.v = bVar;
        this.w = i2;
        this.f3163b = new c();
        this.h = (int) (((double) Util.E()) * 1.3333333333333333d);
        this.c = (CameraQrCodeJumpView) LayoutInflater.from(activity).inflate(R.layout.camera_qrcode_jump_view, (ViewGroup) null);
        this.c.setId(R.id.rl_qr_code_click);
        this.c.setOnClickListener(this);
        this.c.setDefaultPreviewHeight(this.h);
        this.f = (KeyguardManager) activity.getApplicationContext().getSystemService("keyguard");
        this.s = new QrCodeDcsMsgData(activity);
        this.A = new f();
        this.z = new QRCodeReader();
        this.y = new Hashtable();
        this.y.put(DecodeHintType.CHARACTER_SET, "utf-8");
        this.y.put(DecodeHintType.TRY_HARDER, Boolean.TRUE);
        this.y.put(DecodeHintType.POSSIBLE_FORMATS, BarcodeFormat.QR_CODE);
        if (this.B == null) {
            this.B = new YuvUtil();
        }
        p();
        if (r().getPackageManager() == null) {
            e.e("QrCodeManager", "QrCodeManager, mbIsWifiQrcodeShare, cannot get packageManager!");
        }
    }

    private void p() {
        HandlerThread handlerThread = new HandlerThread("CameraQrCode");
        handlerThread.start();
        HandlerThread handlerThread2 = new HandlerThread("CameraQrCodeJump");
        handlerThread2.start();
        this.q = new Handler(handlerThread2.getLooper());
        this.p = new Handler(handlerThread.getLooper()) {
            public void handleMessage(Message message) {
                int i = message.what;
                if (i != 3) {
                    switch (i) {
                        case 6:
                            e.a("QrCodeManager", "handleMessage, MSG_QR_CODE_CHECK_LEAVE");
                            v.this.p.removeMessages(8);
                            v.this.n();
                            return;
                        case 7:
                            e.a("QrCodeManager", "handleMessage, MSG_QR_CODE_JUMP_DELAY");
                            v.this.n();
                            boolean unused = v.this.n = false;
                            return;
                        case 8:
                            v.this.d(true);
                            if (v.this.h()) {
                                v.this.b(true);
                                return;
                            }
                            return;
                        case 9:
                            v.this.e(true);
                            synchronized (v.this.t) {
                                if (v.this.v != null) {
                                    v.this.v.b("type_preview_frame");
                                }
                            }
                            return;
                        default:
                            return;
                    }
                } else if (message.obj != null && !v.this.i && v.this.k) {
                    com.oppo.camera.p.a aVar = (com.oppo.camera.p.a) message.obj;
                    b a2 = v.this.a(aVar.a(), aVar.b(), aVar.c());
                    if (a2 == null || a2.d() == null || v.this.D == null || v.this.i) {
                        v.this.q();
                    } else {
                        v.this.a(a2);
                    }
                }
            }
        };
    }

    /* access modifiers changed from: private */
    public void q() {
        this.D.removeMessages(4);
        this.D.sendEmptyMessage(4);
        if (this.m && !this.p.hasMessages(6)) {
            e.a("QrCodeManager", "qrCodeEmpty, MSG_QR_CODE_CHECK_LEAVE");
            Handler handler = this.p;
            handler.sendMessageDelayed(handler.obtainMessage(6), 1000);
        }
        if (!this.m && !this.p.hasMessages(9)) {
            e.a("QrCodeManager", "qrCodeEmpty, QR_CODE_MAX_DETECTION_TIME");
            Handler handler2 = this.p;
            handler2.sendMessageDelayed(handler2.obtainMessage(9), 15000);
        }
    }

    /* access modifiers changed from: private */
    public void a(b bVar) {
        this.p.removeMessages(6);
        this.p.removeMessages(9);
        b bVar2 = this.e;
        if (bVar2 == null || !TextUtils.equals(bVar2.a(), bVar.a()) || !this.p.hasMessages(8)) {
            this.p.removeMessages(8);
            Handler handler = this.p;
            handler.sendMessageDelayed(handler.obtainMessage(8), 10000);
        }
        this.D.removeMessages(1);
        this.D.removeMessages(4);
        this.D.obtainMessage(1, bVar).sendToTarget();
    }

    public void a(byte[] bArr, Rect rect, Size size, int i2, int i3) {
        if (!this.i && this.k && !this.l) {
            m();
            int i4 = (int) (((float) i2) / (((float) i3) / 720.0f));
            byte[] a2 = this.B.a(bArr, i2, i3, i4, 720);
            this.p.removeMessages(3);
            this.p.obtainMessage(3, new com.oppo.camera.p.a(a2, rect, size, i4, 720)).sendToTarget();
        }
    }

    private b a(Result result, int i2, int i3) {
        if (result == null || TextUtils.isEmpty(result.getText()) || r() == null) {
            e.a("QrCodeManager", "innerConvertResult, result is null");
            return null;
        }
        e.a("QrCodeManager", "innerConvertResult, result: " + result.getText());
        RectF a2 = a(result.getResultPoints());
        if (a2 == null) {
            return null;
        }
        if (this.f3163b.a(result.getText())) {
            return new b(result.getText(), b.a.WIFI, (String) null, a2, i2, i3);
        }
        return new b(result.getText(), b.a.NONE, (String) null, a2, i2, i3);
    }

    private RectF a(ResultPoint[] resultPointArr) {
        if (4 != resultPointArr.length) {
            return null;
        }
        RectF rectF = new RectF();
        float x2 = (resultPointArr[0].getX() + resultPointArr[2].getX()) / 2.0f;
        float y2 = (resultPointArr[0].getY() + resultPointArr[2].getY()) / 2.0f;
        float sqrt = ((float) Math.sqrt(Math.pow((double) (resultPointArr[0].getX() - resultPointArr[2].getX()), 2.0d) + Math.pow((double) (resultPointArr[0].getY() - resultPointArr[2].getY()), 2.0d))) / 2.0f;
        rectF.left = x2 - sqrt;
        rectF.top = y2 - sqrt;
        rectF.right = x2 + sqrt;
        rectF.bottom = y2 + sqrt;
        return rectF;
    }

    /* access modifiers changed from: private */
    public b a(byte[] bArr, int i2, int i3) {
        Result result;
        e.a("QrCodeManager", "decode, width: " + i2 + ", height: " + i3);
        Result a2 = a(bArr, i2, i3, this.C);
        if (a2 == null) {
            this.C = -1;
            int nextInt = new Random().nextInt(this.A.a());
            result = a(bArr, i2, i3, nextInt);
            if (result != null) {
                this.C = nextInt;
            } else {
                this.C = -1;
            }
        } else {
            result = a2;
        }
        return a(result, i2, i3);
    }

    public Result a(byte[] bArr, int i2, int i3, int i4) {
        PlanarYUVLuminanceSource planarYUVLuminanceSource = new PlanarYUVLuminanceSource(bArr, i2, i3, 0, 0, i2, i3, false);
        if (-1 != i4) {
            this.A.a(i4).a(planarYUVLuminanceSource.getMatrix(), planarYUVLuminanceSource.getWidth(), planarYUVLuminanceSource.getHeight());
        }
        try {
            Result decode = this.z.decode(new BinaryBitmap(new HybridBinarizer(planarYUVLuminanceSource)), this.y);
            this.z.reset();
            return decode;
        } catch (NotFoundException e2) {
            e2.printStackTrace();
        } catch (FormatException e3) {
            e3.printStackTrace();
        } catch (ChecksumException e4) {
            e4.printStackTrace();
        } catch (Throwable th) {
            this.z.reset();
            throw th;
        }
        this.z.reset();
        return null;
    }

    /* access modifiers changed from: private */
    public void b(b bVar) {
        if (this.f3162a == null || this.i) {
            e.b("QrCodeManager", "handleCodeResult activity is destroyed");
        } else if (!bVar.g()) {
            b.a c2 = bVar.c();
            String a2 = bVar.a();
            if (c2 == b.a.NONE) {
                a(a2);
            } else if (c2 == b.a.WIFI) {
                Intent intent = new Intent("oppo.settings.WLAN_CONNECT");
                intent.setPackage("com.coloros.wirelesssettings");
                intent.putExtra("rawResult", a2);
                try {
                    this.f3162a.startActivity(intent);
                    a(3, true);
                } catch (Exception e2) {
                    e.e("QrCodeManager", "handleCodeResult, innerHandleCodeResult e: " + e2);
                    a(a2);
                }
            } else {
                a(a2);
            }
        }
    }

    private void a(int i2, boolean z2) {
        synchronized (this.t) {
            if (this.s != null) {
                this.s.buildEventId(z2);
                a(this.s);
                if (z2) {
                    this.s.mProtocol = i2;
                }
                this.s.report();
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00c9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean a(java.lang.String r8) {
        /*
            r7 = this;
            android.app.Activity r0 = r7.f3162a
            r1 = 0
            if (r0 != 0) goto L_0x0006
            return r1
        L_0x0006:
            java.util.regex.Pattern r0 = android.util.Patterns.WEB_URL
            java.util.regex.Matcher r0 = r0.matcher(r8)
            boolean r0 = r0.matches()
            java.lang.String r2 = "searchCode e: "
            java.lang.String r3 = "QrCodeManager"
            r4 = 1
            if (r0 != 0) goto L_0x0020
            boolean r0 = android.webkit.URLUtil.isValidUrl(r8)
            if (r0 == 0) goto L_0x001e
            goto L_0x0020
        L_0x001e:
            r5 = r1
            goto L_0x0052
        L_0x0020:
            java.lang.String r0 = com.oppo.camera.util.Util.g((java.lang.String) r8)
            android.net.Uri r0 = android.net.Uri.parse(r0)
            android.content.Intent r5 = new android.content.Intent
            java.lang.String r6 = "android.intent.action.VIEW"
            r5.<init>(r6, r0)
            android.app.Activity r0 = r7.f3162a     // Catch:{ Exception -> 0x003c }
            r0.startActivity(r5)     // Catch:{ Exception -> 0x003c }
            r7.a((int) r4, (boolean) r4)     // Catch:{ Exception -> 0x0039 }
            r5 = r4
            goto L_0x0052
        L_0x0039:
            r0 = move-exception
            r5 = r4
            goto L_0x003e
        L_0x003c:
            r0 = move-exception
            r5 = r1
        L_0x003e:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r2)
            r6.append(r0)
            java.lang.String r0 = r6.toString()
            com.oppo.camera.e.e(r3, r0)
            r7.n = r1
        L_0x0052:
            if (r5 != 0) goto L_0x00c9
            android.content.Intent r0 = new android.content.Intent
            java.lang.String r6 = "android.intent.action.WEB_SEARCH"
            r0.<init>(r6)
            java.lang.String r6 = "query"
            r0.putExtra(r6, r8)
            android.content.Context r8 = r7.r()
            java.lang.String r6 = "com.heytap.browser"
            boolean r8 = com.oppo.camera.util.Util.c((android.content.Context) r8, (java.lang.String) r6)
            if (r8 == 0) goto L_0x0070
            r0.setPackage(r6)
            goto L_0x00a1
        L_0x0070:
            android.content.Context r8 = r7.r()
            java.lang.String r6 = "com.coloros.browser"
            boolean r8 = com.oppo.camera.util.Util.c((android.content.Context) r8, (java.lang.String) r6)
            if (r8 == 0) goto L_0x0080
            r0.setPackage(r6)
            goto L_0x00a1
        L_0x0080:
            android.content.Context r8 = r7.r()
            java.lang.String r6 = "com.nearme.browser"
            boolean r8 = com.oppo.camera.util.Util.c((android.content.Context) r8, (java.lang.String) r6)
            if (r8 == 0) goto L_0x0090
            r0.setPackage(r6)
            goto L_0x00a1
        L_0x0090:
            android.content.Context r8 = r7.r()
            java.lang.String r6 = "com.android.chrome"
            boolean r8 = com.oppo.camera.util.Util.c((android.content.Context) r8, (java.lang.String) r6)
            if (r8 != 0) goto L_0x00a1
            java.lang.String r8 = "com.android.browser"
            r0.setPackage(r8)
        L_0x00a1:
            r8 = 268435456(0x10000000, float:2.5243549E-29)
            r0.addFlags(r8)
            android.app.Activity r8 = r7.f3162a     // Catch:{ Exception -> 0x00b2 }
            r8.startActivity(r0)     // Catch:{ Exception -> 0x00b2 }
            r8 = 4
            r7.a((int) r8, (boolean) r4)     // Catch:{ Exception -> 0x00b0 }
            goto L_0x00ca
        L_0x00b0:
            r8 = move-exception
            goto L_0x00b4
        L_0x00b2:
            r8 = move-exception
            r4 = r5
        L_0x00b4:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r2)
            r0.append(r8)
            java.lang.String r8 = r0.toString()
            com.oppo.camera.e.e(r3, r8)
            r7.n = r1
            goto L_0x00ca
        L_0x00c9:
            r4 = r5
        L_0x00ca:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.v.a(java.lang.String):boolean");
    }

    private Context r() {
        Activity activity = this.f3162a;
        if (activity != null) {
            return activity.getApplicationContext();
        }
        return null;
    }

    public void a(ViewGroup viewGroup) {
        if (viewGroup != null && this.c != null) {
            PreviewFrameLayout previewFrameLayout = (PreviewFrameLayout) this.f3162a.findViewById(R.id.frame_layout);
            this.d = (CameraQrCodeView) previewFrameLayout.findViewById(R.id.qrcode_view);
            if (this.d == null) {
                this.d = (CameraQrCodeView) this.f3162a.getLayoutInflater().inflate(R.layout.view_stub_qrcode_view, previewFrameLayout).findViewById(R.id.qrcode_view);
            }
            viewGroup.removeView(this.c);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(14);
            layoutParams.addRule(2, R.id.control_panel_layout);
            layoutParams.bottomMargin = this.f3162a.getResources().getDimensionPixelSize(R.dimen.qr_code_vertical_margin_bottom);
            viewGroup.addView(this.c, layoutParams);
            this.c.setVisibility(8);
            View findViewById = this.c.findViewById(R.id.camera_qr_code_hint_next);
            boolean z2 = true;
            if (this.c.getLayoutDirection() != 1) {
                z2 = false;
            }
            findViewById.setRotation(z2 ? 180.0f : 0.0f);
        }
    }

    public void a(boolean z2) {
        CameraQrCodeJumpView cameraQrCodeJumpView = this.c;
        if (cameraQrCodeJumpView != null && this.f3162a != null && this.e != null && !this.i && cameraQrCodeJumpView.getParent() != null) {
            this.c.setOrientation(this.r);
            synchronized (this.t) {
                if (this.v != null) {
                    this.v.ax();
                }
            }
            if (this.c.b()) {
                this.c.a();
                return;
            }
            this.c.a(true, z2);
            a(0, false);
        }
    }

    public void b(boolean z2) {
        if (this.c == null || this.f3162a == null || this.e == null || !i()) {
            Handler handler = this.D;
            if (handler != null) {
                handler.removeCallbacksAndMessages((Object) null);
            }
            if (this.D != null) {
                this.p.removeCallbacksAndMessages((Object) null);
                return;
            }
            return;
        }
        this.D.removeMessages(2);
        this.D.removeMessages(1);
        this.p.removeMessages(3);
        this.D.obtainMessage(2, Boolean.valueOf(z2)).sendToTarget();
    }

    /* access modifiers changed from: private */
    public void s() {
        CameraQrCodeView cameraQrCodeView = this.d;
        if (cameraQrCodeView == null || !this.j) {
            CameraQrCodeView cameraQrCodeView2 = this.d;
            if (cameraQrCodeView2 != null) {
                cameraQrCodeView2.setVisibility(4);
                return;
            }
            return;
        }
        cameraQrCodeView.a(this.e.d(), this.e.e(), this.e.f());
    }

    /* access modifiers changed from: private */
    public void t() {
        CameraQrCodeView cameraQrCodeView = this.d;
        if (cameraQrCodeView != null && !this.i) {
            cameraQrCodeView.a(true);
        }
    }

    public void c() {
        e.a("QrCodeManager", "clearQrCodeView, canScanQrCode: " + this.k + ", mbPause: " + this.i + ", isMainThread: " + d());
        if (!this.i && h()) {
            if (!d()) {
                this.D.removeCallbacksAndMessages((Object) null);
                this.p.removeCallbacksAndMessages((Object) null);
                this.D.sendEmptyMessage(5);
                return;
            }
            o();
        }
    }

    public boolean d() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    public void a(int i2) {
        e.a("QrCodeManager", "setOrientation: " + i2);
        this.r = i2;
        if (h()) {
            this.c.setOrientation(this.r);
        }
    }

    public void e() {
        e.a("QrCodeManager", "onResume");
        this.i = false;
        this.o = false;
        CameraQrCodeJumpView cameraQrCodeJumpView = this.c;
        if (cameraQrCodeJumpView != null) {
            cameraQrCodeJumpView.d();
        }
        CameraQrCodeView cameraQrCodeView = this.d;
        if (cameraQrCodeView != null) {
            cameraQrCodeView.c();
        }
        if (this.n) {
            this.p.removeMessages(7);
            Handler handler = this.p;
            handler.sendMessageDelayed(handler.obtainMessage(7), 2000);
        } else {
            a();
        }
        c(true);
    }

    public void f() {
        e.a("QrCodeManager", "onPause");
        this.i = true;
        this.o = false;
        CameraQrCodeJumpView cameraQrCodeJumpView = this.c;
        if (cameraQrCodeJumpView != null) {
            cameraQrCodeJumpView.c();
        }
        CameraQrCodeView cameraQrCodeView = this.d;
        if (cameraQrCodeView != null) {
            cameraQrCodeView.b();
        }
        a aVar = this.x;
        if (aVar != null) {
            aVar.a(true);
        }
        c(false);
        this.D.removeCallbacksAndMessages((Object) null);
        this.p.removeCallbacksAndMessages((Object) null);
        this.q.removeCallbacksAndMessages((Object) null);
        this.r = 0;
        this.C = -1;
        o();
    }

    public void g() {
        e.a("QrCodeManager", "onDestroy");
        a aVar = this.x;
        if (aVar != null) {
            aVar.a(true);
        }
        this.D.removeCallbacksAndMessages((Object) null);
        this.p.removeCallbacksAndMessages((Object) null);
        this.q.removeCallbacksAndMessages((Object) null);
        this.f3162a = null;
        this.f = null;
        synchronized (this.t) {
            this.v = null;
            this.u = null;
            this.s = null;
        }
        try {
            this.p.getLooper().quitSafely();
            this.p = null;
            this.q.getLooper().quitSafely();
            this.q = null;
        } catch (Exception e2) {
            e.e("QrCodeManager", "onDestroy, quit handler: " + e2.toString());
        }
    }

    public void c(boolean z2) {
        this.k = z2;
        if (!this.k) {
            c();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000a, code lost:
        r0 = r1.c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean h() {
        /*
            r1 = this;
            com.oppo.camera.ui.CameraQrCodeView r0 = r1.d
            if (r0 == 0) goto L_0x000a
            boolean r0 = r0.a()
            if (r0 != 0) goto L_0x0014
        L_0x000a:
            com.oppo.camera.ui.CameraQrCodeJumpView r0 = r1.c
            if (r0 == 0) goto L_0x0016
            boolean r0 = r0.b()
            if (r0 == 0) goto L_0x0016
        L_0x0014:
            r0 = 1
            goto L_0x0017
        L_0x0016:
            r0 = 0
        L_0x0017:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.v.h():boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000a, code lost:
        r0 = r1.c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean i() {
        /*
            r1 = this;
            com.oppo.camera.ui.CameraQrCodeView r0 = r1.d
            if (r0 == 0) goto L_0x0016
            boolean r0 = r0.a()
            if (r0 == 0) goto L_0x0016
            com.oppo.camera.ui.CameraQrCodeJumpView r0 = r1.c
            if (r0 == 0) goto L_0x0016
            boolean r0 = r0.b()
            if (r0 == 0) goto L_0x0016
            r0 = 1
            goto L_0x0017
        L_0x0016:
            r0 = 0
        L_0x0017:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.v.i():boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r1 = r2.r;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean j() {
        /*
            r2 = this;
            boolean r0 = r2.h()
            if (r0 == 0) goto L_0x0012
            r0 = 90
            int r1 = r2.r
            if (r0 == r1) goto L_0x0010
            r0 = 270(0x10e, float:3.78E-43)
            if (r0 != r1) goto L_0x0012
        L_0x0010:
            r0 = 1
            goto L_0x0013
        L_0x0012:
            r0 = 0
        L_0x0013:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.v.j():boolean");
    }

    public boolean a(MotionEvent motionEvent) {
        CameraQrCodeJumpView cameraQrCodeJumpView = this.c;
        if (cameraQrCodeJumpView == null || !cameraQrCodeJumpView.b() || !a((View) this.c, (int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
            if (motionEvent.getAction() == 0) {
                e.a("QrCodeManager", "needTouchEvent, isShowQrCodeView: " + h());
            }
            if (h() && motionEvent.getAction() == 0) {
                this.n = false;
                b();
                d(true);
                c();
            }
            return false;
        }
        e.a("QrCodeManager", "needTouchEvent, QrCode is show and dispatchTouchEvent");
        if (1 == motionEvent.getAction()) {
            c();
        }
        return true;
    }

    private boolean a(View view, int i2, int i3) {
        int measuredWidth;
        int measuredHeight;
        if (view == null) {
            return false;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i4 = iArr[0];
        int i5 = iArr[1];
        int i6 = this.r;
        if (270 == i6) {
            i4 -= view.getMeasuredHeight();
            measuredWidth = view.getMeasuredHeight() + i4;
            measuredHeight = view.getMeasuredWidth();
        } else if (90 == i6) {
            i5 -= view.getMeasuredWidth();
            measuredWidth = view.getMeasuredHeight() + i4;
            measuredHeight = view.getMeasuredWidth();
        } else {
            measuredWidth = view.getMeasuredWidth() + i4;
            measuredHeight = view.getMeasuredHeight();
        }
        int i7 = measuredHeight + i5;
        if (i3 < i5 || i3 > i7 || i2 < i4 || i2 > measuredWidth) {
            return false;
        }
        return true;
    }

    public void d(boolean z2) {
        this.m = z2;
        if (this.m) {
            this.g = this.e;
        }
    }

    public void e(boolean z2) {
        this.l = z2;
    }

    public boolean k() {
        return this.l;
    }

    public void l() {
        CameraQrCodeJumpView cameraQrCodeJumpView = this.c;
        if (cameraQrCodeJumpView != null) {
            cameraQrCodeJumpView.e();
        }
    }

    private void u() {
        e.a("QrCodeManager", "requestKeyguard");
        this.o = true;
        try {
            new OplusWindowManager().requestKeyguard("unlockOrShowSecurity");
        } catch (RemoteException e2) {
            e.e("QrCodeManager", "requestKeyguard: " + e2.toString());
        } catch (NoSuchMethodError e3) {
            e.e("QrCodeManager", "requestKeyguard: " + e3.toString());
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r1.f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean v() {
        /*
            r1 = this;
            android.app.Activity r0 = r1.f3162a
            if (r0 == 0) goto L_0x0010
            android.app.KeyguardManager r0 = r1.f
            if (r0 == 0) goto L_0x0010
            boolean r0 = r0.isDeviceLocked()
            if (r0 == 0) goto L_0x0010
            r0 = 1
            goto L_0x0011
        L_0x0010:
            r0 = 0
        L_0x0011:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.v.v():boolean");
    }

    public void m() {
        if (this.o && !v()) {
            this.o = false;
            w();
        }
    }

    private void a(QrCodeDcsMsgData qrCodeDcsMsgData) {
        if (qrCodeDcsMsgData != null) {
            com.oppo.camera.e.b bVar = this.v;
            if (bVar != null) {
                if (bVar.b() != null) {
                    qrCodeDcsMsgData.mCameraEnterType = String.valueOf(this.v.b().y());
                }
                qrCodeDcsMsgData.mCameraId = this.v.aq();
            }
            k kVar = this.u;
            if (kVar != null) {
                qrCodeDcsMsgData.mCaptureMode = kVar.getString("pref_camera_mode_key", "");
            }
            qrCodeDcsMsgData.mOrientation = this.r;
            qrCodeDcsMsgData.mScreenBrightness = (int) ((float) Settings.System.getInt(this.f3162a.getContentResolver(), CameraStatisticsUtil.SCREEN_BRIGHTNESS, (int) (((float) this.w) * 0.4f)));
        }
    }

    public void a(ViewGroup viewGroup, int i2) {
        a(viewGroup);
        a(i2);
    }

    public void n() {
        this.p.removeMessages(8);
        a();
    }

    public void onClick(View view) {
        this.n = true;
        if (v()) {
            u();
        } else {
            w();
        }
    }

    private void w() {
        if (this.e != null && this.q != null) {
            e.a("QrCodeManager", "jump, QR code jump");
            a aVar = this.x;
            if (aVar != null) {
                this.q.removeCallbacks(aVar);
                this.x.a(true);
            }
            this.x = new a();
            this.x.a(this.e);
            this.q.post(this.x);
            d(true);
            c();
        }
    }

    /* compiled from: QrCodeManager */
    private class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        b f3166a;

        private a() {
            this.f3166a = null;
        }

        public void a(b bVar) {
            this.f3166a = new b(bVar.a(), bVar.c(), bVar.b(), bVar.d(), bVar.e(), bVar.f());
        }

        public void a(boolean z) {
            b bVar = this.f3166a;
            if (bVar != null) {
                bVar.a(z);
            }
        }

        public void run() {
            b bVar = this.f3166a;
            if (bVar != null) {
                v.this.b(bVar);
                this.f3166a = null;
            }
        }
    }
}
