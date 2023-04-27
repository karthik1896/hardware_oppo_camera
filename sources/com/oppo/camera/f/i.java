package com.oppo.camera.f;

import android.content.Intent;
import android.hardware.camera2.CameraDevice;
import android.media.ImageReader;
import android.os.ConditionVariable;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.oppo.camera.aps.config.AlgoSwitchConfig;
import com.oppo.camera.e;
import com.oppo.camera.f.f;
import com.oppo.camera.util.Util;
import com.oppo.camera.v.b;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: OneCameraStateMachine */
public abstract class i implements f {
    /* access modifiers changed from: private */
    public volatile boolean A = false;
    private ConditionVariable B = new ConditionVariable();
    private ConditionVariable C = new ConditionVariable();
    private Lock D = new ReentrantLock();
    protected final Object k = new Object();
    protected a l = null;
    protected b m = null;
    protected Handler n = null;
    protected Handler o = null;
    protected HashMap<String, ImageReader> p = null;
    protected HashMap<String, Long> q = null;
    protected int r = 3;
    protected int s = 1;
    protected int t = 1;
    protected ConditionVariable u = new ConditionVariable();
    protected ConditionVariable v = null;
    private long w = 0;
    private long x = 2000;
    /* access modifiers changed from: private */
    public boolean y = true;
    private boolean z = false;

    /* access modifiers changed from: protected */
    public abstract void A();

    /* access modifiers changed from: protected */
    public abstract void B();

    /* access modifiers changed from: protected */
    public abstract void a(int i, f.b bVar);

    /* access modifiers changed from: protected */
    public abstract void a(int i, f.d dVar, int i2);

    /* access modifiers changed from: protected */
    public abstract void a(CameraDevice cameraDevice);

    public i(int i) {
        HandlerThread handlerThread = new HandlerThread("Camera Hal Control Thread" + i);
        handlerThread.start();
        this.l = new a(handlerThread.getLooper());
        HandlerThread handlerThread2 = new HandlerThread("Camera Hal Callback Thread" + i);
        handlerThread2.start();
        this.m = new b(handlerThread2.getLooper());
        HandlerThread handlerThread3 = new HandlerThread("Aps Capture Yuv Thread" + i);
        handlerThread3.start();
        this.n = new Handler(handlerThread3.getLooper());
        HandlerThread handlerThread4 = new HandlerThread("CaptureImageCallback" + i);
        handlerThread4.start();
        this.o = new Handler(handlerThread4.getLooper());
        this.t = i;
        if (1 == i) {
            this.v = new ConditionVariable(true);
        }
        synchronized (this.k) {
            this.p = new HashMap<>();
            this.q = new HashMap<>();
        }
    }

    /* compiled from: OneCameraStateMachine */
    protected class a extends b {

        /* renamed from: b  reason: collision with root package name */
        private boolean f3240b = false;

        a(Looper looper) {
            super(looper);
        }

        public void a(Runnable runnable) {
            if (this.f3240b) {
                super.a(runnable);
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v8, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v5, resolved type: android.hardware.camera2.CameraDevice} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v10, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v8, resolved type: android.hardware.camera2.CameraDevice} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void handleMessage(android.os.Message r7) {
            /*
                r6 = this;
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "handleMessage, mCameraRole: "
                r0.append(r1)
                com.oppo.camera.f.i r1 = com.oppo.camera.f.i.this
                int r1 = r1.t
                r0.append(r1)
                java.lang.String r1 = ", msg: "
                r0.append(r1)
                int r2 = r7.what
                r0.append(r2)
                java.lang.String r0 = r0.toString()
                java.lang.String r2 = "OneCameraStateMachine"
                com.oppo.camera.e.b(r2, r0)
                int r0 = r7.what
                r3 = 1
                r4 = 8
                r5 = 0
                switch(r0) {
                    case 1: goto L_0x00e2;
                    case 2: goto L_0x00d6;
                    case 3: goto L_0x00b6;
                    case 4: goto L_0x007d;
                    case 5: goto L_0x006c;
                    case 6: goto L_0x0060;
                    case 7: goto L_0x0036;
                    case 8: goto L_0x002f;
                    default: goto L_0x002d;
                }
            L_0x002d:
                goto L_0x00f6
            L_0x002f:
                com.oppo.camera.f.i r0 = com.oppo.camera.f.i.this
                r0.B()
                goto L_0x00f6
            L_0x0036:
                com.oppo.camera.f.i r0 = com.oppo.camera.f.i.this
                int r0 = r0.r
                if (r0 == r3) goto L_0x0049
                com.oppo.camera.f.i r0 = com.oppo.camera.f.i.this
                int r0 = r0.r
                if (r0 == r4) goto L_0x0049
                com.oppo.camera.f.i r0 = com.oppo.camera.f.i.this
                int r0 = r0.r
                r3 = 6
                if (r0 != r3) goto L_0x00f6
            L_0x0049:
                com.oppo.camera.f.i r0 = com.oppo.camera.f.i.this     // Catch:{ CameraAccessException -> 0x004f }
                r0.a((java.util.Set<java.lang.String>) r5)     // Catch:{ CameraAccessException -> 0x004f }
                goto L_0x0053
            L_0x004f:
                r0 = move-exception
                r0.printStackTrace()
            L_0x0053:
                java.lang.Object r0 = r7.obj
                com.oppo.camera.f.f$b r0 = (com.oppo.camera.f.f.b) r0
                com.oppo.camera.f.i r3 = com.oppo.camera.f.i.this
                int r3 = r3.t
                r0.a(r3)
                goto L_0x00f6
            L_0x0060:
                com.oppo.camera.f.i r0 = com.oppo.camera.f.i.this
                r0.C()
                com.oppo.camera.f.i r0 = com.oppo.camera.f.i.this
                r0.A()
                goto L_0x00f6
            L_0x006c:
                com.oppo.camera.f.i r0 = com.oppo.camera.f.i.this
                java.lang.Object r3 = r7.obj
                if (r3 != 0) goto L_0x0073
                goto L_0x0078
            L_0x0073:
                java.lang.Object r3 = r7.obj
                r5 = r3
                android.hardware.camera2.CameraDevice r5 = (android.hardware.camera2.CameraDevice) r5
            L_0x0078:
                r0.a((android.hardware.camera2.CameraDevice) r5)
                goto L_0x00f6
            L_0x007d:
                com.oppo.camera.f.i r0 = com.oppo.camera.f.i.this
                boolean r0 = r0.A
                if (r0 != 0) goto L_0x00f6
                com.oppo.camera.f.i r0 = com.oppo.camera.f.i.this
                com.oppo.camera.f.i$a r0 = r0.l
                r0.removeCallbacksAndMessages(r5)
                com.oppo.camera.f.i r0 = com.oppo.camera.f.i.this
                int r4 = r7.arg1
                r0.I(r4)
                com.oppo.camera.f.i r0 = com.oppo.camera.f.i.this
                boolean r0 = r0.y
                if (r0 == 0) goto L_0x00ab
                com.oppo.camera.f.i r0 = com.oppo.camera.f.i.this
                java.lang.Object r3 = r7.obj
                if (r3 != 0) goto L_0x00a2
                goto L_0x00a7
            L_0x00a2:
                java.lang.Object r3 = r7.obj
                r5 = r3
                android.hardware.camera2.CameraDevice r5 = (android.hardware.camera2.CameraDevice) r5
            L_0x00a7:
                r0.b((android.hardware.camera2.CameraDevice) r5)
                goto L_0x00f6
            L_0x00ab:
                java.lang.String r0 = "don't close camera and run open flow"
                com.oppo.camera.e.b(r2, r0)
                com.oppo.camera.f.i r0 = com.oppo.camera.f.i.this
                boolean unused = r0.y = r3
                goto L_0x00f6
            L_0x00b6:
                com.oppo.camera.f.i r0 = com.oppo.camera.f.i.this
                int r3 = r7.arg1
                java.lang.Object r5 = r7.obj
                com.oppo.camera.f.f$d r5 = (com.oppo.camera.f.f.d) r5
                int r7 = r7.arg2
                r0.a((int) r3, (com.oppo.camera.f.f.d) r5, (int) r7)
                com.oppo.camera.f.i r7 = com.oppo.camera.f.i.this
                com.oppo.camera.f.i$a r7 = r7.l
                r7.removeMessages(r4)
                com.oppo.camera.f.i r7 = com.oppo.camera.f.i.this
                com.oppo.camera.f.i$a r7 = r7.l
                android.os.Message r7 = r7.obtainMessage(r4)
                r7.sendToTarget()
                goto L_0x00f6
            L_0x00d6:
                com.oppo.camera.f.i r0 = com.oppo.camera.f.i.this
                int r3 = r7.arg1
                java.lang.Object r4 = r7.obj
                com.oppo.camera.f.f$b r4 = (com.oppo.camera.f.f.b) r4
                r0.a((int) r3, (com.oppo.camera.f.f.b) r4)
                goto L_0x00f6
            L_0x00e2:
                com.oppo.camera.f.i r0 = com.oppo.camera.f.i.this
                com.oppo.camera.f.i$a r0 = r0.l
                r0.removeCallbacksAndMessages(r5)
                com.oppo.camera.f.i r0 = com.oppo.camera.f.i.this
                int r3 = r7.arg1
                java.lang.Object r4 = r7.obj
                com.oppo.camera.f.f$b r4 = (com.oppo.camera.f.f.b) r4
                int r5 = r7.arg2
                r0.b((int) r3, (com.oppo.camera.f.f.b) r4, (int) r5)
            L_0x00f6:
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r3 = "handleMessage x, mCameraRole: "
                r0.append(r3)
                com.oppo.camera.f.i r3 = com.oppo.camera.f.i.this
                int r3 = r3.t
                r0.append(r3)
                r0.append(r1)
                int r7 = r7.what
                r0.append(r7)
                java.lang.String r7 = r0.toString()
                com.oppo.camera.e.a(r2, r7)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.f.i.a.handleMessage(android.os.Message):void");
        }

        public void a(boolean z) {
            this.f3240b = z;
        }
    }

    public void D() {
        e.b("OneCameraStateMachine", "openSubCameraLock, mCameraRole: " + this.t);
        this.u.open();
    }

    public void E() {
        e.b("OneCameraStateMachine", "closeSubCameraLock, mCameraRole: " + this.t);
        this.u.close();
    }

    /* access modifiers changed from: protected */
    public void F() {
        if (this.v != null) {
            e.b("OneCameraStateMachine", "openMainCameraOpenBlock, mCameraRole: " + this.t);
            this.v.open();
        }
    }

    /* access modifiers changed from: private */
    public void b(int i, f.b bVar, int i2) {
        if (c() == -1) {
            e.e("OneCameraStateMachine", "openCamera, mCameraRole: " + this.t + ", normal open");
            Message obtainMessage = this.l.obtainMessage();
            obtainMessage.what = 2;
            obtainMessage.obj = bVar;
            obtainMessage.arg1 = i;
            this.l.sendMessage(obtainMessage);
        } else {
            e.e("OneCameraStateMachine", "openCamera, mCameraRole: " + this.t + ",  close then open");
            b((CameraDevice) null);
            Message obtainMessage2 = this.l.obtainMessage();
            obtainMessage2.what = 2;
            obtainMessage2.obj = bVar;
            obtainMessage2.arg1 = i;
            this.l.sendMessage(obtainMessage2);
        }
        Message obtainMessage3 = this.l.obtainMessage();
        obtainMessage3.what = 7;
        obtainMessage3.obj = bVar;
        this.l.sendMessage(obtainMessage3);
        this.y = true;
        this.A = false;
    }

    /* access modifiers changed from: private */
    public void b(CameraDevice cameraDevice) {
        e.b("OneCameraStateMachine", "closeCameraDecision, mCameraRole: " + this.t + ", mDeviceState: " + this.r);
        int i = this.r;
        if (i == 1 || i == 8 || i == 0 || i == 6) {
            e.b("OneCameraStateMachine", "closeCameraDecision, mCameraRole: " + this.t + ",  quick close");
            Message obtainMessage = this.l.obtainMessage();
            obtainMessage.what = 5;
            obtainMessage.obj = cameraDevice;
            this.l.sendMessage(obtainMessage);
        } else if (i == 5) {
            e.b("OneCameraStateMachine", "closeCameraDecision, mCameraRole: " + this.t + ",  normal close");
            Message obtainMessage2 = this.l.obtainMessage();
            obtainMessage2.what = 6;
            this.l.sendMessage(obtainMessage2);
            Message obtainMessage3 = this.l.obtainMessage();
            obtainMessage3.what = 5;
            obtainMessage3.obj = cameraDevice;
            this.l.sendMessage(obtainMessage3);
        }
    }

    public void a(int i, f.b bVar, int i2) {
        e.e("OneCameraStateMachine", "openCamera, mCameraRole: " + this.t + ",  cameraId: " + i + ", this: " + this);
        this.l.removeCallbacksAndMessages((Object) null);
        Message obtainMessage = this.l.obtainMessage();
        obtainMessage.what = 1;
        obtainMessage.obj = bVar;
        obtainMessage.arg1 = i;
        obtainMessage.arg2 = i2;
        if (this.z) {
            this.y = false;
        } else {
            this.x = 2000;
        }
        b(false);
        this.l.sendMessageAtFrontOfQueue(obtainMessage);
        this.A = true;
        e.a("OneCameraStateMachine", (Handler) this.l, "openCamera");
    }

    public void a(boolean z2, CameraDevice cameraDevice, boolean z3) {
        e.e("OneCameraStateMachine", "closeCamera, mCameraRole: " + this.t + ",  mCameraDevice: " + cameraDevice + ", fromError: " + z2 + ", needDelay: " + z3);
        this.A = false;
        Message obtainMessage = this.l.obtainMessage();
        obtainMessage.what = 4;
        obtainMessage.obj = cameraDevice;
        obtainMessage.arg1 = z3 ? 1 : 0;
        this.y = true;
        this.l.sendMessageAtFrontOfQueue(obtainMessage);
        e.a("OneCameraStateMachine", (Handler) this.l, "closeCamera");
    }

    public void b(int i, f.d dVar, int i2) {
        e.a("OneCameraStateMachine", "createCaptureSession, mCameraRole: " + this.t);
        Message obtainMessage = this.l.obtainMessage();
        obtainMessage.what = 3;
        obtainMessage.arg1 = i;
        obtainMessage.arg2 = i2;
        obtainMessage.obj = dVar;
        this.l.sendMessage(obtainMessage);
    }

    public void f() {
        e.a("OneCameraStateMachine", "closeSession, mCameraRole: " + this.t);
        Message obtainMessage = this.l.obtainMessage();
        obtainMessage.what = 6;
        obtainMessage.obj = null;
        obtainMessage.arg1 = 0;
        this.l.sendMessage(obtainMessage);
    }

    /* access modifiers changed from: protected */
    public void H(int i) {
        e.e("OneCameraStateMachine", "setDeviceState, mCameraRole: " + this.t + ",  mDeviceState: " + this.r + " -> " + i);
        this.r = i;
        if (this.r == 5) {
            this.l.a(true);
        } else {
            this.l.a(false);
        }
    }

    public ImageReader a(String str, int i, int i2, int i3, int i4, long j) {
        ImageReader imageReader;
        ImageReader imageReader2;
        synchronized (this.k) {
            imageReader = this.p.get(str);
            Long l2 = this.q.get(str);
            if (imageReader == null || imageReader.getWidth() != i || imageReader.getHeight() != i2 || imageReader.getImageFormat() != i3 || imageReader.getMaxImages() != i4 || "type_multi_sub_preview_frame".equals(str) || "type_multi_main_preview_frame".equals(str) || "type_main_preview_frame".equals(str) || "type_sub_preview_frame".equals(str) || "type_third_preview_frame".equals(str) || "type_video_frame".equals(str) || !(l2 == null || j == l2.longValue())) {
                if (imageReader != null) {
                    e.a("OneCameraStateMachine", "getImageReader, mCameraRole: " + this.t + ",  reader close");
                    imageReader.setOnImageAvailableListener((ImageReader.OnImageAvailableListener) null, (Handler) null);
                    imageReader.close();
                }
                if (2 == AlgoSwitchConfig.getApsVersion()) {
                    imageReader2 = ImageReader.newInstance(i, i2, i3, i4);
                } else {
                    imageReader2 = ImageReader.newInstance(i, i2, i3, i4, j);
                }
                imageReader = imageReader2;
                this.p.put(str, imageReader);
                this.q.put(str, Long.valueOf(j));
            }
        }
        return imageReader;
    }

    public ImageReader.OnImageAvailableListener a(final ImageReader.OnImageAvailableListener onImageAvailableListener) {
        return new ImageReader.OnImageAvailableListener() {
            public void onImageAvailable(ImageReader imageReader) {
                synchronized (i.this.k) {
                    onImageAvailableListener.onImageAvailable(imageReader);
                }
            }
        };
    }

    public void a(String str, ImageReader.OnImageAvailableListener onImageAvailableListener, Handler handler) {
        synchronized (this.k) {
            if (this.p.containsKey(str)) {
                e.a("OneCameraStateMachine", "setImageListener, type: " + str + ",  listener: " + onImageAvailableListener);
                this.p.get(str).setOnImageAvailableListener(onImageAvailableListener, handler);
            }
        }
    }

    public void b(int i) {
        synchronized (this.k) {
            for (Map.Entry<String, ImageReader> value : this.p.entrySet()) {
                ((ImageReader) value.getValue()).close();
            }
            this.p.clear();
            this.q.clear();
        }
    }

    public void a() {
        synchronized (this.k) {
            if (this.p.containsKey("type_still_capture_raw")) {
                this.p.get("type_still_capture_raw").discardFreeBuffers();
            }
        }
    }

    public void d() {
        this.m.getLooper().quitSafely();
        this.l.getLooper().quitSafely();
        this.n.getLooper().quitSafely();
        this.o.getLooper().quitSafely();
    }

    public void a(final boolean z2) {
        Util.a((Runnable) new Runnable() {
            public void run() {
                e.a("OneCameraStateMachine", "broadcastRearCamera, enterRearCamera: " + z2);
                Intent intent = new Intent("com.oppo.rearcamera");
                intent.putExtra("command", z2 ? "enterrear" : "exitrear");
                Util.f().sendBroadcast(intent);
            }
        });
    }

    public void a(int i) {
        this.s = i;
    }

    public Handler m() {
        return this.l;
    }

    public Handler l() {
        return this.o;
    }

    public void G() {
        this.D.lock();
        try {
            this.C.close();
            this.B.close();
        } finally {
            this.D.unlock();
        }
    }

    public void b(boolean z2) {
        e.b("OneCameraStateMachine", "openLock, mCameraRole: " + this.t + ", openboth : " + z2);
        this.D.lock();
        try {
            this.B.open();
            if (z2) {
                this.C.open();
            }
        } finally {
            this.D.unlock();
        }
    }

    /* access modifiers changed from: private */
    public void I(int i) {
        if (1 == i) {
            e.b("OneCameraStateMachine", "blockClose begin, mCameraRole: " + this.t);
            this.w = System.currentTimeMillis();
            this.z = true;
            this.B.block(2000);
            this.z = false;
            this.x = System.currentTimeMillis() - this.w;
            this.B.open();
            e.b("OneCameraStateMachine", "blockClose end, mCameraRole: " + this.t + ", mWaitingDuration: " + this.x);
        }
    }

    /* access modifiers changed from: private */
    public void C() {
        long j = 2000 - this.x;
        if (j > 1) {
            e.b("OneCameraStateMachine", "blockCloseOldSession begin, mCameraRole: " + this.t + ", leftWaitingTime: " + j);
            this.C.block(j);
            this.x = 2000;
            this.C.open();
            e.b("OneCameraStateMachine", "blockCloseOldSession end, mCameraRole: " + this.t);
        }
    }

    public boolean H() {
        return 5 == this.r;
    }

    public boolean I() {
        return 3 == this.r;
    }
}
