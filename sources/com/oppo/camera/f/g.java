package com.oppo.camera.f;

import android.graphics.Rect;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraConstrainedHighSpeedCaptureSession;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CaptureFailure;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.hardware.camera2.params.InputConfiguration;
import android.hardware.camera2.params.MeteringRectangle;
import android.hardware.camera2.params.OutputConfiguration;
import android.hardware.camera2.params.SessionConfiguration;
import android.location.Location;
import android.media.Image;
import android.media.ImageReader;
import android.media.ImageWriter;
import android.os.Build;
import android.os.ConditionVariable;
import android.util.Range;
import android.view.Surface;
import com.oppo.camera.aps.ApsCameraMetadataKey;
import com.oppo.camera.aps.adapter.ApsCaptureResult;
import com.oppo.camera.aps.adapter.ApsUtils;
import com.oppo.camera.aps.config.AlgoSwitchConfig;
import com.oppo.camera.aps.config.CameraConfig;
import com.oppo.camera.aps.config.ConfigDataBase;
import com.oppo.camera.aps.constant.ParameterKeys;
import com.oppo.camera.e;
import com.oppo.camera.f.d;
import com.oppo.camera.f.f;
import com.oppo.camera.statistics.model.MenuClickMsgData;
import com.oppo.camera.u.d;
import com.oppo.camera.util.Util;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Semaphore;

/* compiled from: OneCameraImpl */
public class g extends i {
    /* access modifiers changed from: private */
    public CameraCaptureSession A;
    /* access modifiers changed from: private */
    public CaptureRequest.Builder B;
    /* access modifiers changed from: private */
    public j C;
    /* access modifiers changed from: private */
    public f.d D;
    /* access modifiers changed from: private */
    public f.a E;
    /* access modifiers changed from: private */
    public f.c F;
    /* access modifiers changed from: private */
    public c G;
    /* access modifiers changed from: private */
    public LinkedHashMap<String, f.C0084f> H;
    private HashMap<String, a<?>> I;
    private Object J;
    /* access modifiers changed from: private */
    public boolean K;
    /* access modifiers changed from: private */
    public boolean L;
    /* access modifiers changed from: private */
    public int M;
    /* access modifiers changed from: private */
    public String N;
    /* access modifiers changed from: private */
    public boolean O;
    private boolean P;
    private boolean Q;
    private int R;
    private boolean S;
    private boolean T;
    /* access modifiers changed from: private */
    public boolean U;
    private int V;
    /* access modifiers changed from: private */
    public int W;
    /* access modifiers changed from: private */
    public int X;
    /* access modifiers changed from: private */
    public int Y;
    /* access modifiers changed from: private */
    public int Z;
    private int aa;
    /* access modifiers changed from: private */
    public int ab;
    private int ac;
    /* access modifiers changed from: private */
    public ImageWriter ad;
    /* access modifiers changed from: private */
    public d ae;
    private d af;
    /* access modifiers changed from: private */
    public boolean ag;
    /* access modifiers changed from: private */
    public boolean ah;
    /* access modifiers changed from: private */
    public b ai;
    /* access modifiers changed from: private */
    public ConditionVariable aj;
    /* access modifiers changed from: private */
    public ConditionVariable ak;
    /* access modifiers changed from: private */
    public ConditionVariable al;
    /* access modifiers changed from: private */
    public ConditionVariable am;
    /* access modifiers changed from: private */
    public ConditionVariable an;
    private Semaphore ao;
    /* access modifiers changed from: private */
    public String[] ap;
    /* access modifiers changed from: private */
    public int[] aq;
    /* access modifiers changed from: private */
    public int[] ar;
    private d as;
    /* access modifiers changed from: private */
    public boolean at;
    private final CameraCaptureSession.StateCallback au;
    /* access modifiers changed from: private */
    public final CameraCaptureSession.CaptureCallback av;
    /* access modifiers changed from: private */
    public com.oppo.camera.k.a aw;
    /* access modifiers changed from: private */
    public final com.oppo.camera.c.a ax;
    /* access modifiers changed from: private */
    public final com.oppo.camera.f.a.a ay;
    /* access modifiers changed from: private */
    public final CameraCaptureSession.CaptureCallback az;
    /* access modifiers changed from: private */
    public final Object w;
    private CameraManager x;
    /* access modifiers changed from: private */
    public CameraDevice y;
    /* access modifiers changed from: private */
    public f.e z;

    public g(int i) {
        super(i);
        this.w = new Object();
        this.x = null;
        this.y = null;
        this.z = null;
        this.A = null;
        this.B = null;
        this.C = null;
        this.D = null;
        this.E = null;
        this.F = null;
        this.G = null;
        this.H = null;
        this.I = null;
        this.J = new Object();
        this.K = false;
        this.L = false;
        this.M = 0;
        this.N = "off";
        this.O = false;
        this.P = false;
        this.Q = false;
        this.R = 0;
        this.S = true;
        this.T = true;
        this.U = false;
        this.V = 32769;
        this.W = 4;
        this.X = 1;
        this.Y = 1;
        this.Z = 1;
        this.aa = 0;
        this.ab = 0;
        this.ac = 0;
        this.ad = null;
        this.ae = null;
        this.af = new d();
        this.ag = false;
        this.ah = false;
        this.ai = new b();
        this.aj = new ConditionVariable();
        this.ak = new ConditionVariable();
        this.al = new ConditionVariable();
        this.am = new ConditionVariable();
        this.an = new ConditionVariable();
        this.ao = new Semaphore(1);
        this.ap = null;
        this.aq = null;
        this.ar = null;
        this.as = null;
        this.at = false;
        this.au = new CameraCaptureSession.StateCallback() {
            public void onConfigured(CameraCaptureSession cameraCaptureSession) {
                com.oppo.camera.perf.a.c("launch_session_configured");
                e.e("OneCameraImpl", "onConfigured, mCameraRole: " + g.this.t + ", session: " + cameraCaptureSession);
                e.a("CameraStartupPerformance.onCameraCaptureSessionConfigured");
                CameraCaptureSession unused = g.this.A = cameraCaptureSession;
                g.this.H(5);
                boolean unused2 = g.this.L = false;
                g.this.ak.open();
                if (1 == g.this.t && g.this.z != null) {
                    g.this.z.d();
                }
                e.b("CameraStartupPerformance.onCameraCaptureSessionConfigured");
            }

            public void onConfigureFailed(CameraCaptureSession cameraCaptureSession) {
                e.e("OneCameraImpl", "onConfigureFailed, mCameraRole: " + g.this.t + ", session: " + cameraCaptureSession);
                if (cameraCaptureSession != null) {
                    cameraCaptureSession.close();
                }
                if (g.this.r == 4) {
                    CameraCaptureSession unused = g.this.A = null;
                    g.this.V();
                    g.this.H(6);
                    if (g.this.D != null) {
                        g.this.D.b();
                    }
                    g.this.ak.open();
                }
            }

            public void onClosed(CameraCaptureSession cameraCaptureSession) {
                super.onClosed(cameraCaptureSession);
                if (g.this.D != null) {
                    g.this.D.a(g.this.t);
                }
                e.e("OneCameraImpl", "onClosed, last session closed, mCameraRole: " + g.this.t + ", session: " + cameraCaptureSession + ", mDeviceState: " + g.this.r);
            }
        };
        this.av = new CameraCaptureSession.CaptureCallback() {

            /* renamed from: b  reason: collision with root package name */
            private long f3213b = 0;

            public void onCaptureStarted(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, long j, long j2) {
                this.f3213b = j2;
                super.onCaptureStarted(cameraCaptureSession, captureRequest, j, j2);
                if (g.this.F != null) {
                    g.this.F.a(cameraCaptureSession, captureRequest, j, j2);
                }
            }

            private boolean a(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest) {
                return g.this.A != null && (cameraCaptureSession == g.this.A || g.this.K) && g.this.r == 5 && g.this.M != 0 && (g.this.L || captureRequest.hashCode() == g.this.M);
            }

            public void onCaptureProgressed(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, CaptureResult captureResult) {
                if (!(captureResult == null || g.this.F == null)) {
                    g.this.F.a(cameraCaptureSession, captureRequest, captureResult);
                }
                super.onCaptureProgressed(cameraCaptureSession, captureRequest, captureResult);
            }

            public void onCaptureCompleted(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, TotalCaptureResult totalCaptureResult) {
                super.onCaptureCompleted(cameraCaptureSession, captureRequest, totalCaptureResult);
                if (a(cameraCaptureSession, captureRequest)) {
                    if (!g.this.L) {
                        e.a("CameraStartupPerformance.onFirstFrameArrived");
                        e.e("OneCameraImpl", "PreviewRequestCallback, onCaptureCompleted, first frame arrive, mCameraRole: " + g.this.t + ", mCameraCaptureSession: " + g.this.A + ", session: " + cameraCaptureSession + ", mPreviewRequestHash: " + g.this.M + ", request.hashCode: " + captureRequest.hashCode());
                        boolean unused = g.this.L = true;
                        g.this.al.open();
                        if (g.this.F != null) {
                            g.this.F.a(totalCaptureResult, g.this.t);
                        }
                        e.b("CameraStartupPerformance.onFirstFrameArrived");
                    }
                    if (totalCaptureResult != null) {
                        Object obj = totalCaptureResult.get(CaptureResult.CONTROL_AF_MODE);
                        if (obj instanceof Integer) {
                            int unused2 = g.this.W = ((Integer) obj).intValue();
                        }
                        Object obj2 = totalCaptureResult.get(CaptureResult.CONTROL_AE_MODE);
                        if (obj2 instanceof Integer) {
                            int unused3 = g.this.X = ((Integer) obj2).intValue();
                        }
                        g gVar = g.this;
                        int[] unused4 = gVar.aq = gVar.a((CaptureResult.Key<?>) ApsCameraMetadataKey.KEY_SENSOR_MASK, (CaptureResult) totalCaptureResult);
                        g gVar2 = g.this;
                        int[] unused5 = gVar2.ar = gVar2.a((CaptureResult.Key<?>) ApsCameraMetadataKey.KEY_MASTER_PIPELINE, (CaptureResult) totalCaptureResult);
                        if (g.this.aw != null) {
                            g.this.aw.onCaptureCompleted(cameraCaptureSession, captureRequest, totalCaptureResult);
                        }
                        if (g.this.ax != null) {
                            g.this.ax.onCaptureCompleted(cameraCaptureSession, captureRequest, totalCaptureResult);
                        }
                        if (g.this.ay != null) {
                            g.this.ay.onCaptureCompleted(cameraCaptureSession, captureRequest, totalCaptureResult);
                        }
                        if (g.this.F != null) {
                            g.this.F.a(cameraCaptureSession, captureRequest, totalCaptureResult, g.this.t, this.f3213b);
                        }
                    }
                }
            }

            public void onCaptureFailed(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, CaptureFailure captureFailure) {
                e.d("OneCameraImpl", "PreviewRequestCallback, onCaptureFailed, mCameraRole: " + g.this.t + ", session: " + cameraCaptureSession + ", fail reason: " + captureFailure.getReason() + ", fail sequenceId:" + captureFailure.getSequenceId());
                if ((g.this.O() || ("off".equals(g.this.N) && g.this.U)) && g.this.aw != null && g.this.aw.c()) {
                    g.this.aw.d();
                }
                if (!g.this.L && a(cameraCaptureSession, captureRequest)) {
                    g.this.al.open();
                }
                if (g.this.F != null) {
                    g.this.F.a(cameraCaptureSession, captureRequest, captureFailure);
                }
                super.onCaptureFailed(cameraCaptureSession, captureRequest, captureFailure);
            }

            public void onCaptureSequenceAborted(CameraCaptureSession cameraCaptureSession, int i) {
                e.a("OneCameraImpl", "PreviewRequestCallback, mCameraRole: " + g.this.t + ", onCaptureSequenceAborted, sequenceId: " + i + ", session: " + cameraCaptureSession);
                super.onCaptureSequenceAborted(cameraCaptureSession, i);
            }

            public void onCaptureBufferLost(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, Surface surface, long j) {
                e.a("OneCameraImpl", "PreviewRequestCallback, mCameraRole: " + g.this.t + ", onCaptureBufferLost, target: " + surface + ", frameNum: " + j + ", session: " + cameraCaptureSession);
                super.onCaptureBufferLost(cameraCaptureSession, captureRequest, surface, j);
            }
        };
        this.aw = new com.oppo.camera.k.a(this) {
            public void a() {
                e.a("OneCameraImpl", "onAeConverged, mCameraRole: " + g.this.t + ", mbNeedCapture: " + this.f3397b);
                g.this.Q();
                if (g.this.ae.ah) {
                    g.this.e(true);
                    g gVar = g.this;
                    gVar.a(gVar.B, g.this.av, 0);
                }
                if (g.this.E != null && this.f3397b) {
                    if ((Util.p() || g.this.ae.G == null || !ParameterKeys.ALGO_NAME_MFNR.equals(g.this.ae.G[0])) && !g.this.ae.ah && !g.this.ae.ao) {
                        g.this.ae.a(d.a.CAPTURE);
                    }
                    g gVar2 = g.this;
                    gVar2.a(gVar2.Y, g.this.ae, g.this.E);
                    if (!g.this.O && !g.this.b() && Util.p() && 2 == g.this.s) {
                        g.this.o();
                    }
                }
            }
        };
        this.ax = new com.oppo.camera.c.a(this) {
            public void a() {
                e.a("OneCameraImpl", "mApertureControllerCallback, mCameraRole: " + g.this.t + ", onApertureSwitchDone, needCapture: " + b());
                if (b() && g.this.E != null) {
                    a(false);
                    g gVar = g.this;
                    gVar.a(gVar.Y, g.this.ae, g.this.E);
                }
            }
        };
        this.ay = new com.oppo.camera.f.a.a(this) {
            public void a() {
                e.a("OneCameraImpl", "mZoomStateCallback, onZoomChangeDone, mCameraRole: " + g.this.t + ", needCapture: " + b());
                if (g.this.z != null) {
                    g.this.z.a(b());
                    if (b()) {
                        a(false);
                    }
                }
            }
        };
        this.az = new CameraCaptureSession.CaptureCallback() {
            public void onCaptureStarted(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, long j, long j2) {
                e.a("OneCameraImpl", "mPictureCallback, onCaptureStarted, mCameraRole: " + g.this.t + ", session: " + cameraCaptureSession + ", timestamp: " + j + ", frameNumber: " + j2);
                super.onCaptureStarted(cameraCaptureSession, captureRequest, j, j2);
                if (g.this.z != null) {
                    g.this.z.a(cameraCaptureSession, captureRequest, j);
                }
                if (g.this.E != null) {
                    g.this.E.a(cameraCaptureSession, captureRequest, j, j2);
                }
            }

            public void onCaptureSequenceCompleted(CameraCaptureSession cameraCaptureSession, int i, long j) {
                e.a("OneCameraImpl", "mPictureCallback, onCaptureSequenceCompleted, mCameraRole: " + g.this.t + ", session: " + cameraCaptureSession + ", frameNumber: " + j);
                super.onCaptureSequenceCompleted(cameraCaptureSession, i, j);
                if (g.this.O() || ("off".equals(g.this.N) && g.this.U)) {
                    g gVar = g.this;
                    gVar.w(gVar.aw.c());
                }
                if (g.this.E != null) {
                    g.this.E.S();
                }
                if (g.this.ae.ah && (d.a.CAPTURE_RAW == g.this.ae.a() || CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_YUV_NIGHT))) {
                    g.this.e(false);
                    g gVar2 = g.this;
                    gVar2.a(gVar2.B, g.this.av, 0);
                }
                if (g.this.ax != null) {
                    g.this.ax.d();
                }
                if (g.this.ay != null) {
                    g.this.ay.d();
                }
            }

            public void onCaptureBufferLost(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, Surface surface, long j) {
                super.onCaptureBufferLost(cameraCaptureSession, captureRequest, surface, j);
                e.e("OneCameraImpl", "mPictureCallback, onCaptureBufferLost, mCameraRole: " + g.this.t + ", target: " + surface);
                d dVar = (d) captureRequest.getTag();
                if (a(surface) || (dVar != null && dVar.a() == d.a.CAPTURE_REPROCESS)) {
                    e.e("OneCameraImpl", "mPictureCallback, onCaptureBufferLost, ignore the preview request, mCameraRole: " + g.this.t + ", requestTag.mRequestMode: " + dVar.a());
                } else if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SAT_SUPPORT_PREVERSION)) {
                    e.e("OneCameraImpl", "mPictureCallback, onCaptureBufferLost, ignore the sat support preversion");
                } else {
                    a(cameraCaptureSession, captureRequest);
                }
            }

            public void onCaptureFailed(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, CaptureFailure captureFailure) {
                e.a("OneCameraImpl", "mPictureCallback, onCaptureFailed, mCameraRole: " + g.this.t + ", session: " + cameraCaptureSession + ", fail reason: " + captureFailure.getReason() + ", fail sequenceId:" + captureFailure.getSequenceId());
                super.onCaptureFailed(cameraCaptureSession, captureRequest, captureFailure);
                a(cameraCaptureSession, captureRequest);
            }

            public void onCaptureProgressed(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, CaptureResult captureResult) {
                e.a("OneCameraImpl", "mPictureCallback, onCaptureProgressed, mCameraRole: " + g.this.t + ", session: " + cameraCaptureSession);
                super.onCaptureProgressed(cameraCaptureSession, captureRequest, captureResult);
                if (g.this.E != null) {
                    g.this.E.a(captureRequest, captureResult);
                }
                if (g.this.C.E() && g.this.ag && g.this.ab < Util.d && !Util.p()) {
                    int[] iArr = (int[]) captureResult.get(c.J);
                    boolean z = false;
                    if (iArr != null && iArr.length > 0) {
                        int length = iArr.length;
                        int i = 0;
                        while (true) {
                            if (i >= length) {
                                break;
                            } else if (iArr[i] == 1) {
                                z = true;
                                break;
                            } else {
                                i++;
                            }
                        }
                    }
                    if (z) {
                        g.this.ae.a(d.a.CAPTURE);
                        g gVar = g.this;
                        gVar.a(1, gVar.ae, g.this.E);
                    }
                }
            }

            public void onCaptureCompleted(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, TotalCaptureResult totalCaptureResult) {
                e.a("OneCameraImpl", "mPictureCallback, onCaptureCompleted, mCameraRole: " + g.this.t + ", session: " + cameraCaptureSession + ", frameNum: " + totalCaptureResult.getFrameNumber());
                super.onCaptureCompleted(cameraCaptureSession, captureRequest, totalCaptureResult);
                ApsCaptureResult apsCaptureResult = new ApsCaptureResult(totalCaptureResult, Integer.toString(((d) captureRequest.getTag()).w));
                if (g.this.z != null) {
                    g.this.z.a(totalCaptureResult, captureRequest);
                }
                if (g.this.E != null) {
                    g.this.E.a(apsCaptureResult, captureRequest);
                }
            }

            private boolean a(Surface surface) {
                Surface surface2;
                Surface surface3;
                Surface surface4;
                Surface surface5;
                f.C0084f fVar = (f.C0084f) g.this.H.get("type_main_preview_frame");
                f.C0084f fVar2 = (f.C0084f) g.this.H.get("type_sub_preview_frame");
                f.C0084f fVar3 = (f.C0084f) g.this.H.get("type_third_preview_frame");
                f.C0084f fVar4 = (f.C0084f) g.this.H.get("type_preview_frame");
                f.C0084f fVar5 = (f.C0084f) g.this.H.get("type_depth_preview");
                Surface surface6 = null;
                if (fVar == null) {
                    surface2 = null;
                } else {
                    surface2 = fVar.a();
                }
                if (fVar2 == null) {
                    surface3 = null;
                } else {
                    surface3 = fVar2.a();
                }
                if (fVar3 == null) {
                    surface4 = null;
                } else {
                    surface4 = fVar3.a();
                }
                if (fVar4 == null) {
                    surface5 = null;
                } else {
                    surface5 = fVar4.a();
                }
                if (fVar5 != null) {
                    surface6 = fVar5.a();
                }
                if (surface2 != null && surface2.equals(surface)) {
                    return true;
                }
                if (surface3 != null && surface3.equals(surface)) {
                    return true;
                }
                if (surface4 != null && surface4.equals(surface)) {
                    return true;
                }
                if (surface5 == null || !surface5.equals(surface)) {
                    return surface6 != null && surface6.equals(surface);
                }
                return true;
            }

            private void a(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest) {
                if (g.this.E != null) {
                    g.this.E.a(captureRequest);
                }
                if (g.this.O()) {
                    g.this.w(true);
                }
                if (g.this.ae.ah && (d.a.CAPTURE_RAW == g.this.ae.a() || CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_YUV_NIGHT))) {
                    g.this.e(false);
                    g gVar = g.this;
                    gVar.a(gVar.B, g.this.av, 0);
                }
                synchronized (g.this.w) {
                    if (g.this.ad != null) {
                        g.this.ad.close();
                        ImageWriter unused = g.this.ad = null;
                    }
                }
            }
        };
        this.I = new HashMap<>();
    }

    public void p(boolean z2) {
        this.U = z2;
    }

    /* access modifiers changed from: protected */
    public void a(final int i, final f.b bVar) {
        if (this.r != 3) {
            e.b("OneCameraImpl", "openCameraDevice, mCameraRole: " + this.t + ", mDeviceState: " + this.r);
            return;
        }
        try {
            if (1 == this.t && this.v != null && !bVar.a()) {
                e.b("OneCameraImpl", "openCameraDevice, mCameraRole: " + this.t + ", wait a while to close sub camera");
                this.v.close();
                if (this.v.block(5000)) {
                    e.a("OneCameraImpl", "openCameraDevice, mCameraRole: " + this.t + ",  OpenBlockTimeout");
                }
            } else if (2 == this.t) {
                e.b("OneCameraImpl", "openCameraDevice, mCameraRole: " + this.t + ", block for main camera configured");
                this.u.block();
            }
            H(0);
            this.aj.close();
            if (this.x == null) {
                this.x = (CameraManager) Util.f().getSystemService("camera");
            }
            this.C = a.a(i);
            com.oppo.camera.perf.a.c("launch_open_camera");
            e.e("OneCameraImpl", "openCamera start, mCameraRole: " + this.t + ", cameraId: " + i);
            e.a("CameraStartupPerformance.openCamera");
            this.x.openCamera(String.valueOf(i), new CameraDevice.StateCallback() {
                public void onOpened(CameraDevice cameraDevice) {
                    Set<String> physicalCameraIds;
                    com.oppo.camera.perf.a.c("launch_camera_opened");
                    e.e("OneCameraImpl", "onOpened, mCameraRole: " + g.this.t + ", cameraDevice: " + cameraDevice);
                    e.a("CameraStartupPerformance.onCameraOpened");
                    com.oppo.camera.v.a.a().a(Util.f(), "connected_camera_ids", (Object) String.valueOf(i));
                    com.oppo.camera.v.a.a().a(Util.f(), "active_camera_type", (Object) Integer.valueOf(a.f(i)));
                    CameraDevice unused = g.this.y = cameraDevice;
                    if (g.this.C() && (physicalCameraIds = g.this.C.F().getPhysicalCameraIds()) != null) {
                        e.b("OneCameraImpl", "onOpened, mCameraRole: " + g.this.t + ", physical cameras list : " + physicalCameraIds.toString());
                        String[] unused2 = g.this.ap = (String[]) physicalCameraIds.toArray(new String[physicalCameraIds.size()]);
                    }
                    if (!Util.p()) {
                        try {
                            boolean unused3 = g.this.at = g.this.C.f() == 1;
                            e.b("OneCameraImpl", "onOpened, mbMtkLowMemoryPlatform: " + g.this.at);
                        } catch (IllegalArgumentException e) {
                            e.e("OneCameraImpl", "onOpened, exception: " + e.getMessage());
                        }
                    }
                    g.this.H(1);
                    g.this.aj.open();
                    e.b("CameraStartupPerformance.onCameraOpened");
                }

                public void onClosed(CameraDevice cameraDevice) {
                    e.e("OneCameraImpl", "onClosed, mCameraRole: " + g.this.t + ", cameraDevice: " + cameraDevice);
                    com.oppo.camera.v.a.a().a(Util.f(), "connected_camera_ids", (Object) "");
                    com.oppo.camera.v.a.a().a(Util.f(), "active_camera_type", (Object) Integer.valueOf(a.f(-1)));
                    CameraDevice unused = g.this.y = null;
                    CameraCaptureSession unused2 = g.this.A = null;
                    boolean unused3 = g.this.L = false;
                    g.this.z();
                    g.this.H(3);
                    g.this.m.postAtFrontOfQueue(new Runnable() {
                        public void run() {
                            bVar.b(g.this.t);
                        }
                    });
                    g.this.aj.open();
                }

                public void onDisconnected(CameraDevice cameraDevice) {
                    e.a("OneCameraImpl", "onDisconnected, mCameraRole: " + g.this.t + ", cameraDevice: " + cameraDevice);
                    CameraDevice unused = g.this.y = cameraDevice;
                    g.this.b(true);
                    g.this.a(false, cameraDevice, false);
                    g.this.J();
                    bVar.a(true, g.this.t);
                }

                public void onError(CameraDevice cameraDevice, int i) {
                    e.e("OneCameraImpl", "onError, mCameraRole: " + g.this.t + ", cameraDevice: " + cameraDevice + ", error: " + i);
                    CameraDevice unused = g.this.y = cameraDevice;
                    g.this.b(true);
                    g.this.a(true, cameraDevice, false);
                    g.this.J();
                    if (1 == i) {
                        bVar.a(false, g.this.t);
                    } else {
                        bVar.a(i, g.this.t);
                    }
                }
            }, this.m);
            e.b("CameraStartupPerformance.openCamera");
            if (this.G == null) {
                this.G = new c();
            }
            a(true);
            e.b("OneCameraImpl", "openCameraDevice, mCameraRole: " + this.t + ", block in mDeviceState: " + this.r);
            this.aj.block();
        } catch (CameraAccessException e) {
            e.printStackTrace();
            if (bVar != null) {
                bVar.a(true, this.t);
            }
        } catch (SecurityException e2) {
            e2.printStackTrace();
            if (bVar != null) {
                bVar.a(true, this.t);
            }
        }
    }

    /* access modifiers changed from: private */
    public void J() {
        this.aj.open();
        this.ak.open();
        this.al.open();
        this.am.open();
    }

    public int c() {
        if (this.y == null || this.r == 3 || this.r == 2) {
            return -1;
        }
        return Integer.parseInt(this.y.getId());
    }

    public boolean b() {
        CameraDevice cameraDevice = this.y;
        if (cameraDevice != null) {
            return a.c(Integer.parseInt(cameraDevice.getId()));
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void a(CameraDevice cameraDevice) {
        if (this.r == 8 || this.r == 1 || this.r == 0 || this.r == 6) {
            if (cameraDevice == null) {
                cameraDevice = this.y;
            }
            if (cameraDevice != null) {
                e.a("CameraSwitchModePerformance.closeCameraDevice");
                e.e("OneCameraImpl", "closeCameraDevice start, mCameraRole: " + this.t);
                H(2);
                this.aj.close();
                cameraDevice.close();
                a(true);
                e.b("OneCameraImpl", "closeCameraDevice, mCameraRole: " + this.t + ", block in mDeviceState: " + this.r);
                this.aj.block();
                this.y = null;
                e.e("OneCameraImpl", "closeCameraDevice X, mCameraRole: " + this.t);
                e.b("CameraSwitchModePerformance.closeCameraDevice");
                return;
            }
            H(3);
            return;
        }
        e.e("OneCameraImpl", "closeCameraDevice, mCameraRole: " + this.t + ", return for mDeviceState: " + this.r);
    }

    /* compiled from: OneCameraImpl */
    private class a<T> {

        /* renamed from: b  reason: collision with root package name */
        private final CaptureRequest.Key<T> f3232b;
        /* access modifiers changed from: private */
        public final l<T> c;

        private a(CaptureRequest.Key<T> key, l<T> lVar) {
            this.f3232b = key;
            this.c = lVar;
        }

        public void a(CaptureRequest.Builder builder) {
            CaptureRequest.Key<T> key;
            if (g.this.G == null || (key = this.f3232b) == null) {
                e.e("OneCameraImpl", "addToBuilder, mCameraMetadataKey is null or not loaded, mCameraRole: " + g.this.t);
                return;
            }
            try {
                builder.set(key, this.c.a());
            } catch (Exception e) {
                e.d("OneCameraImpl", "addToBuilder, mCameraRole: " + g.this.t + ", error: " + e.getMessage());
            }
        }
    }

    public void a(f.e eVar) {
        this.z = eVar;
    }

    public j e() {
        return this.C;
    }

    private void a(InputConfiguration inputConfiguration) {
        HashMap hashMap;
        StringBuilder sb = new StringBuilder();
        sb.append("printStreams, createCaptureSession\ninputSurface: \n");
        if (inputConfiguration != null) {
            sb.append("width: ");
            sb.append(inputConfiguration.getWidth());
            sb.append(", height: ");
            sb.append(inputConfiguration.getHeight());
            sb.append(", format: ");
            sb.append(inputConfiguration.getFormat());
        }
        sb.append("\noutputSurfaces: \n");
        synchronized (this.k) {
            hashMap = this.p;
        }
        for (Map.Entry<String, f.C0084f> key : this.H.entrySet()) {
            String str = (String) key.getKey();
            if (!hashMap.containsKey(str)) {
                sb.append("type: ");
                sb.append(str);
                sb.append(", surface instance: ");
                sb.append(this.H.get(str).a());
                sb.append("\n");
            } else {
                ImageReader imageReader = (ImageReader) hashMap.get(str);
                sb.append("type: ");
                sb.append(str);
                sb.append(", width: ");
                sb.append(imageReader.getWidth());
                sb.append(", height: ");
                sb.append(imageReader.getHeight());
                sb.append(", format: ");
                sb.append(imageReader.getImageFormat());
                sb.append(", surface instance: ");
                sb.append(this.H.get(str).a());
                sb.append("\n");
            }
        }
        e.a("OneCameraImpl", sb.toString());
    }

    /* access modifiers changed from: protected */
    public void a(int i, f.d dVar, int i2) {
        if (2 == this.t) {
            e.b("OneCameraImpl", "createCaptureSession, block wait for main camera configured, mCameraRole: " + this.t);
            this.u.block();
        }
        e.a("OneCameraImpl", "createNewSession, mCameraRole: " + this.t + ", mDeviceState: " + this.r + ", mCameraDevice: " + this.y + ", operationMode: " + i + ", previewTemplate: " + i2);
        if (this.y != null) {
            this.D = dVar;
            this.V = i;
            this.K = (i & 32781) == 32781;
            this.Z = i2;
            try {
                H(4);
                this.ak.close();
                List<f.C0084f> S2 = S();
                InputConfiguration R2 = R();
                if (S2.size() == 0) {
                    V();
                    this.au.onConfigureFailed((CameraCaptureSession) null);
                    e.b("createNewSession");
                    return;
                }
                HashSet hashSet = new HashSet();
                if (a.g(Integer.parseInt(this.y.getId())) && this.H.get("type_main_preview_frame").b() != null) {
                    hashSet.add(this.H.get("type_main_preview_frame").b());
                }
                a((Set<String>) hashSet);
                a((Set<String>) hashSet, this.t);
                a(R2);
                a(this.B);
                e.a("createNewSession");
                ArrayList arrayList = new ArrayList();
                for (f.C0084f next : S2) {
                    OutputConfiguration outputConfiguration = new OutputConfiguration(next.a());
                    if (next.b() != null) {
                        outputConfiguration.setPhysicalCameraId(next.b());
                    }
                    arrayList.add(outputConfiguration);
                }
                if (this.K) {
                    a(S2, (List<OutputConfiguration>) arrayList);
                } else {
                    Range<Integer> c = this.D.c();
                    if (c != null) {
                        this.B.set(CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE, c);
                    }
                    CaptureRequest build = this.B.build();
                    SessionConfiguration sessionConfiguration = new SessionConfiguration(i, arrayList, new b(this.m), this.au);
                    sessionConfiguration.setInputConfiguration(R2);
                    sessionConfiguration.setSessionParameters(build);
                    com.oppo.camera.perf.a.c("launch_create_session");
                    e.e("OneCameraImpl", "createNewSession, createCaptureSession start, mCameraRole: " + this.t);
                    e.a("CameraStartupPerformance.createCaptureSession");
                    this.y.createCaptureSession(sessionConfiguration);
                    e.b("CameraStartupPerformance.createCaptureSession");
                }
                this.ak.block();
                e.b("createNewSession");
            } catch (Exception e) {
                e.e("OneCameraImpl", "createNewSession, mCameraRole: " + this.t + ", e: " + e.getMessage());
                V();
                this.au.onConfigureFailed((CameraCaptureSession) null);
            } catch (Throwable th) {
                e.b("createNewSession");
                throw th;
            }
        }
    }

    private void a(List<f.C0084f> list, List<OutputConfiguration> list2) throws CameraAccessException {
        com.oppo.camera.perf.a.c("launch_create_session");
        Range<Integer> c = this.D.c();
        e.e("OneCameraImpl", "createHighSpeedVideoNewSession, mCameraRole: " + this.t + ", range: " + c);
        if (!Util.p() || Build.VERSION.SDK_INT < 28) {
            ArrayList arrayList = new ArrayList();
            for (f.C0084f a2 : list) {
                arrayList.add(a2.a());
            }
            e.a("CameraStartupPerformance.createHighSpeedVideoNewSession");
            this.y.createConstrainedHighSpeedCaptureSession(arrayList, this.au, this.m);
            e.b("CameraStartupPerformance.createHighSpeedVideoNewSession");
            return;
        }
        if (c != null) {
            this.B.set(CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE, c);
        }
        CaptureRequest build = this.B.build();
        SessionConfiguration sessionConfiguration = new SessionConfiguration(1, list2, new b(this.m), this.au);
        sessionConfiguration.setSessionParameters(build);
        this.y.createCaptureSession(sessionConfiguration);
    }

    public void g() {
        this.l.a((Runnable) new Runnable() {
            public void run() {
                e.a("OneCameraImpl", "stopRepeating, mCameraRole: " + g.this.t);
                try {
                    if (g.this.A != null) {
                        e.a("stopRepeating");
                        g.this.A.stopRepeating();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } catch (Throwable th) {
                    e.b("stopRepeating");
                    throw th;
                }
                e.b("stopRepeating");
            }
        });
    }

    private void K() {
        e.a("OneCameraImpl", "waitRecordingFinish, mCameraRole: " + this.t + ", isCloseStreamTaskFinished: " + c("type_video"));
        if (!c("type_video") || !c("type_video_frame")) {
            this.am.block();
            if (this.l.hasCallbacks(this.ai)) {
                this.l.removeCallbacks(this.ai);
                this.ai.run();
            }
        }
        e.a("OneCameraImpl", "waitRecordingFinish, x, mCameraRole: " + this.t);
    }

    public void h() {
        this.l.a((Runnable) new Runnable() {
            public void run() {
                if (g.this.A != null) {
                    try {
                        g.this.A.abortCaptures();
                    } catch (CameraAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    public void A() {
        e.a("OneCameraImpl", "closeOldSession, mCameraRole: " + this.t + ", mCameraCaptureSession: " + this.A + ", mDeviceState: " + this.r);
        if (5 == this.r) {
            this.aw.d();
            this.O = false;
            K();
            H(7);
            this.ai.a(true);
            try {
                if (this.A != null) {
                    e.e("OneCameraImpl", "closeOldSession, begin to stopRepeating, mCameraRole: " + this.t);
                    e.a("CameraSwitchModePerformance.stopRepeating");
                    if (this.z != null) {
                        this.z.a(this.t);
                    }
                    this.A.stopRepeating();
                    e.b("CameraSwitchModePerformance.stopRepeating");
                    e.e("OneCameraImpl", "closeOldSession, begin to abortCaptures, mCameraRole: " + this.t);
                    e.a("CameraSwitchModePerformance.abortCaptures");
                    this.A.abortCaptures();
                    e.b("CameraSwitchModePerformance.abortCaptures");
                    e.e("OneCameraImpl", "closeOldSession, begin to close, mCameraRole: " + this.t);
                    e.a("CameraSwitchModePerformance.closeSession");
                    this.A.close();
                    this.M = 0;
                    this.A = null;
                    V();
                    H(8);
                    this.D.a(this.af, this.t);
                    e.b("CameraSwitchModePerformance.closeSession");
                }
            } catch (CameraAccessException | IllegalStateException e) {
                e.e("OneCameraImpl", "closeOldSession, mCameraRole: " + this.t + ", e: " + e);
                this.A = null;
                V();
                H(6);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void B() {
        if (this.D != null && this.r == 5) {
            this.al.close();
            if (this.D.a(this.B.build(), this.t)) {
                e.b("OneCameraImpl", "onSessionConfigured, block in, mCameraRole: " + this.t + ", mDeviceState: " + this.r);
                this.al.block();
            }
        }
    }

    /* access modifiers changed from: private */
    public boolean L() {
        com.oppo.camera.k.a aVar;
        f.e eVar;
        if (!O() || (aVar = this.aw) == null || aVar.b() || this.O) {
            return true;
        }
        e.b("OneCameraImpl", "checkAeAfState, flash required, but ae not converged, mCameraRole: " + this.t + ", mFlashControllerCallback.isAeConverged: " + this.aw.b() + ", mbAeAfLocked: " + this.O);
        if (b() && (eVar = this.z) != null) {
            eVar.b();
        }
        if (b() || CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_TORCH_FLASH)) {
            a(CaptureRequest.FLASH_MODE, 2);
            a(CaptureRequest.CONTROL_AE_MODE, 1);
            a("com.oplus.ProTorchMode", new int[]{1});
            a(this.B, this.av, 0);
        }
        this.aw.a(true);
        this.aw.a(0);
        P();
        return false;
    }

    /* access modifiers changed from: private */
    public boolean M() {
        com.oppo.camera.c.a aVar = this.ax;
        if (aVar == null || !aVar.c()) {
            return true;
        }
        e.b("OneCameraImpl", "checkApertureSwitchState, isApertureSwitching, mCameraRole: " + this.t);
        this.ax.a(true);
        return false;
    }

    /* access modifiers changed from: private */
    public boolean N() {
        com.oppo.camera.f.a.a aVar = this.ay;
        if (aVar == null || !aVar.c()) {
            return true;
        }
        e.b("OneCameraImpl", "checkZoomState, isZoomChanging, mCameraRole: " + this.t);
        this.ay.a(true);
        return false;
    }

    /* access modifiers changed from: private */
    public boolean O() {
        if (b() && CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_TORCH_SOFT_LIGHT)) {
            return false;
        }
        if ("on".equals(this.N)) {
            return true;
        }
        if (!MenuClickMsgData.VALUE_PROFESSION_AUTO.equals(this.N) || !this.P) {
            return false;
        }
        return true;
    }

    public void a(boolean z2, d dVar, f.a aVar) {
        int i = 1;
        if (z2) {
            this.ag = true;
        }
        if (z2) {
            i = CameraConfig.getConfigIntValue(ConfigDataBase.KEY_CSHOT_FIRST_REQUEST_NUM);
        }
        a(i, dVar, aVar);
    }

    public void i() {
        this.ag = false;
    }

    public void a(final int i, final d dVar, final f.a aVar) {
        this.l.a((Runnable) new Runnable() {
            public void run() {
                boolean H = g.this.L();
                boolean I = g.this.M();
                boolean J = g.this.N();
                d unused = g.this.ae = dVar;
                f.a unused2 = g.this.E = aVar;
                int unused3 = g.this.Y = i;
                e.a("OneCameraImpl", "burstCapture, pictureNum: " + i + ", checkAeAfState: " + H + ", mCameraCaptureSession: " + g.this.A + ", requestTag: " + dVar + ", checkApertureState: " + I + ", checkZoomState: " + J + ", featureType: " + dVar.ac + ", ev list: " + Arrays.toString(dVar.H));
                if (!H) {
                    e.a("OneCameraImpl", "burstCapture, checkAeAfState false, return!");
                } else if (Util.p() || !dVar.o || g.this.ab < Util.d) {
                    f.a aVar = aVar;
                    if (aVar != null) {
                        aVar.V();
                    }
                    if (!I) {
                        e.a("OneCameraImpl", "burstCapture, checkApertureState false, return!");
                    } else if (!J) {
                        e.a("OneCameraImpl", "burstCapture, checkZoomState false, return!");
                    } else {
                        if (g.this.z != null) {
                            g.this.z.a();
                        }
                        if (g.this.r != 5 || g.this.A == null) {
                            f.a aVar2 = aVar;
                            if (aVar2 != null) {
                                aVar2.b(dVar);
                                return;
                            }
                            return;
                        }
                        CaptureRequest.Builder builder = null;
                        if (dVar.a() == d.a.CAPTURE) {
                            builder = g.this.a(dVar);
                        } else if (dVar.a() == d.a.CAPTURE_RAW) {
                            builder = g.this.U();
                        }
                        try {
                            builder.set(c.k, Long.valueOf(dVar.an));
                            builder.set(c.l, Util.b(dVar.an));
                        } catch (Exception e) {
                            e.b("OneCameraImpl", "burstCapture, set hal exif, e: " + e.getMessage());
                        }
                        if (!Util.p() && builder != null) {
                            builder.set(c.aF, dVar.a() == d.a.CAPTURE_RAW ? f.h : f.i);
                            if (32 == dVar.r) {
                                builder.set(c.at, 1);
                                builder.set(c.au, new int[]{12});
                            } else if (34 == dVar.r) {
                                builder.set(c.as, new int[]{1});
                            } else if (37 == dVar.r) {
                                builder.set(c.at, 1);
                                builder.set(c.au, new int[]{10});
                            } else if (36 == dVar.r) {
                                builder.set(c.at, 0);
                                builder.set(c.au, new int[]{12});
                            }
                            if (g.this.at && dVar.o) {
                                g.this.x(false);
                            }
                        }
                        ArrayList arrayList = new ArrayList();
                        try {
                            f.a unused4 = g.this.E = aVar;
                            for (int i = 0; i < i; i++) {
                                if (builder != null) {
                                    if (!(dVar.H == null || dVar.H.length <= 0 || 26 == dVar.ac)) {
                                        builder.set(CaptureRequest.CONTROL_AE_EXPOSURE_COMPENSATION, Integer.valueOf(dVar.H[i]));
                                    }
                                    if (!Util.p() && dVar.I != null && dVar.I.length > 0) {
                                        builder.set(CaptureRequest.SENSOR_EXPOSURE_TIME, Long.valueOf(dVar.I[i]));
                                    }
                                    if (Util.p() && 4 == dVar.Z && !dVar.s) {
                                        if (1 == i) {
                                            builder.set(c.aQ, new int[]{4});
                                        } else if (i >= 3) {
                                            if (i == 0) {
                                                builder.set(c.aQ, new int[]{1});
                                            } else if (i - 1 == i) {
                                                builder.set(c.aQ, new int[]{3});
                                            } else {
                                                builder.set(c.aQ, new int[]{2});
                                            }
                                        }
                                    }
                                    if (Util.p()) {
                                        try {
                                            builder.set(c.f3189b, Integer.valueOf(i + 1));
                                        } catch (Exception e2) {
                                            e.e("OneCameraImpl", "burstCapture, exception: " + e2.getMessage());
                                        }
                                    }
                                    if (Util.p() && !dVar.o && (26 == dVar.ac || 27 == dVar.ac)) {
                                        e.a("OneCameraImpl", "burstCapture, mTouchEVValue: " + dVar.aq);
                                        if (dVar.H[i] - dVar.aq >= 0) {
                                            builder.set(c.aR, new int[]{dVar.ae});
                                            builder.set(c.aS, (byte) 102);
                                            builder.set(CaptureRequest.NOISE_REDUCTION_MODE, 2);
                                            builder.set(CaptureRequest.CONTROL_ENABLE_ZSL, true);
                                        } else {
                                            builder.set(c.aR, new int[]{0});
                                            builder.set(c.aS, (byte) 0);
                                            builder.set(CaptureRequest.NOISE_REDUCTION_MODE, 1);
                                            builder.set(CaptureRequest.CONTROL_ENABLE_ZSL, Boolean.valueOf(26 == dVar.ac));
                                        }
                                        builder.set(c.y, Integer.valueOf(dVar.ac));
                                    }
                                    if (g.this.z != null) {
                                        g.this.z.a(builder, i, i, dVar.G);
                                    }
                                    arrayList.add(builder.build());
                                    if (dVar.o) {
                                        CaptureRequest build = builder.build();
                                        e.a("CameraCapturePerformance.doBurstCapture");
                                        g.this.A.capture(build, g.this.az, g.this.n);
                                        int unused5 = g.this.ab = g.this.ab + 1;
                                        e.b("CameraCapturePerformance.doBurstCapture");
                                        e.a("OneCameraImpl", "burstCapture, with loop, request hashcode: " + build.hashCode() + ", mMtkCShortRequestNum: " + g.this.ab);
                                    }
                                }
                            }
                            if (!dVar.o && arrayList.size() > 0) {
                                e.a("CameraCapturePerformance.doCapture");
                                g.this.A.captureBurst(arrayList, g.this.az, g.this.n);
                                e.b("CameraCapturePerformance.doCapture");
                                e.a("OneCameraImpl", "burstCapture, with burst, request hashcode: " + arrayList.get(0));
                            }
                            g.this.G();
                        } catch (Exception e3) {
                            f.a aVar3 = aVar;
                            if (aVar3 != null) {
                                aVar3.b(dVar);
                            }
                            e.a("OneCameraImpl", "burstCapture, exception: " + e3.getMessage());
                        }
                    }
                } else {
                    e.a("OneCameraImpl", "burstCapture, mMtkCShortRequestNum reach max, return!");
                }
            }
        });
    }

    public void c(int i) {
        a(CaptureRequest.JPEG_ORIENTATION, Integer.valueOf(i));
    }

    public void d(int i) {
        a(CaptureRequest.JPEG_QUALITY, Byte.valueOf((byte) i));
    }

    public void a(Location location) {
        a(CaptureRequest.JPEG_GPS_LOCATION, location);
    }

    public void a(Rect rect) {
        e.a("OneCameraImpl", "setCropRegion, mCameraRole: " + this.t + ", cropRegion: " + rect);
        a(CaptureRequest.SCALER_CROP_REGION, rect);
    }

    public void a(float f) {
        e.a("OneCameraImpl", "setZoomRatio, mCameraRole: " + this.t + ", zoomRatio: " + f);
        a(CaptureRequest.CONTROL_ZOOM_RATIO, Float.valueOf(f));
    }

    public void b(Rect rect) {
        a(c.am, new int[]{rect.left, rect.top, rect.right, rect.bottom});
    }

    public void x() {
        j jVar = this.C;
        c cVar = this.G;
        int[] b2 = jVar.b((CameraCharacteristics.Key<?>) c.aA);
        if (b2 != null) {
            c cVar2 = this.G;
            a("com.mediatek.multicamfeature.multiCamFeatureMode", b2);
        }
    }

    public boolean C() {
        for (int i : (int[]) this.C.F().get(CameraCharacteristics.REQUEST_AVAILABLE_CAPABILITIES)) {
            if (11 == i) {
                return true;
            }
        }
        return false;
    }

    public void b(float f) {
        a(CaptureRequest.CONTROL_AF_MODE, 0);
        a(CaptureRequest.LENS_FOCUS_DISTANCE, Float.valueOf(f));
        a(this.B, this.av, 0);
    }

    public int p() {
        return this.W;
    }

    public String q() {
        return this.N;
    }

    public void a(int i, boolean z2) {
        e.a("OneCameraImpl", "setFocusMode, mCameraRole: " + this.t + ", focusMode: " + i + ", needTrigger: " + z2);
        if (!b()) {
            if (i == 1 && z2) {
                this.l.a((Runnable) new Runnable() {
                    public void run() {
                        e.a("CONTROL_AF_TRIGGER");
                        g gVar = g.this;
                        CaptureRequest.Builder e = gVar.I(gVar.Z);
                        if (e != null) {
                            e.set(CaptureRequest.CONTROL_AF_TRIGGER, 1);
                            g gVar2 = g.this;
                            gVar2.a(e, gVar2.av, 1);
                        }
                        e.b("CONTROL_AF_TRIGGER");
                    }
                });
            }
            a(CaptureRequest.CONTROL_AF_MODE, Integer.valueOf(i));
        }
        a(CaptureRequest.CONTROL_MODE, 1);
    }

    public void a(int i, MeteringRectangle[] meteringRectangleArr, MeteringRectangle[] meteringRectangleArr2, boolean z2) {
        e.a("OneCameraImpl", "setFocusMode, mCameraRole: " + this.t + ", focusMode: " + i + ", needTrigger: " + z2 + ", afRegion: " + Arrays.toString(meteringRectangleArr) + ", aeRegion: " + Arrays.toString(meteringRectangleArr2));
        if (!b()) {
            if (i == 1 && z2) {
                this.l.a((Runnable) new Runnable() {
                    public void run() {
                        e.a("CONTROL_AF_TRIGGER");
                        g gVar = g.this;
                        CaptureRequest.Builder e = gVar.I(gVar.Z);
                        if (e != null) {
                            e.set(CaptureRequest.CONTROL_AF_TRIGGER, 1);
                            g gVar2 = g.this;
                            gVar2.a(e, gVar2.av, 1);
                        }
                        e.b("CONTROL_AF_TRIGGER");
                    }
                });
            }
            a(CaptureRequest.CONTROL_AF_MODE, Integer.valueOf(i));
            a(CaptureRequest.CONTROL_AF_REGIONS, meteringRectangleArr);
            if (3 == i || 4 == i) {
                if (meteringRectangleArr2 != null) {
                    a(new k(meteringRectangleArr2[0]));
                }
                if (meteringRectangleArr != null) {
                    b(new k(meteringRectangleArr[0]));
                }
            }
        }
        a(CaptureRequest.CONTROL_MODE, 1);
        a(CaptureRequest.CONTROL_AE_REGIONS, meteringRectangleArr2);
    }

    public void a(MeteringRectangle[] meteringRectangleArr) {
        a(CaptureRequest.CONTROL_AE_REGIONS, meteringRectangleArr);
    }

    public void b(MeteringRectangle[] meteringRectangleArr) {
        a(CaptureRequest.CONTROL_AF_REGIONS, meteringRectangleArr);
    }

    public void b(k kVar) {
        a("com.oplus.control.af.region", kVar.a());
    }

    public void a(k kVar) {
        a("com.oplus.control.ae.region", kVar.a());
    }

    public void n() {
        a(CaptureRequest.CONTROL_MODE, 1);
        a(CaptureRequest.CONTROL_AF_MODE, 1);
    }

    public void o() {
        this.l.a((Runnable) new Runnable() {
            public void run() {
                g gVar = g.this;
                CaptureRequest.Builder e = gVar.I(gVar.Z);
                if (e != null) {
                    e.set(CaptureRequest.CONTROL_AF_TRIGGER, 2);
                    g gVar2 = g.this;
                    gVar2.a(e, gVar2.av, 1);
                }
            }
        });
    }

    public void e(int i) {
        e.a("OneCameraImpl", "cancelAutoFocus, mCameraRole: " + this.t);
        if (!b()) {
            this.l.a((Runnable) new Runnable() {
                public void run() {
                    if (g.this.aw == null || !g.this.aw.c()) {
                        g gVar = g.this;
                        CaptureRequest.Builder e = gVar.I(gVar.Z);
                        if (e != null) {
                            e.set(CaptureRequest.CONTROL_AF_TRIGGER, 2);
                            g gVar2 = g.this;
                            gVar2.a(e, gVar2.av, 1);
                            return;
                        }
                        return;
                    }
                    e.e("OneCameraImpl", "cancelAutoFocus, flash triggerStart, so return! mCameraRole: " + g.this.t);
                }
            });
            a(CaptureRequest.CONTROL_AF_MODE, Integer.valueOf(i));
            a(CaptureRequest.CONTROL_AF_REGIONS, com.oppo.camera.a.a());
            b(new k(com.oppo.camera.a.a()[0]));
            a(new k(com.oppo.camera.a.a()[0]));
        }
        a(CaptureRequest.CONTROL_MODE, 1);
        a(CaptureRequest.CONTROL_AE_REGIONS, com.oppo.camera.a.a());
        a(this.B, this.av, 0);
    }

    public void f(int i) {
        e.a("OneCameraImpl", "setExposureCompensation, mCameraRole: " + this.t + ", value: " + i);
        a(CaptureRequest.CONTROL_AE_EXPOSURE_COMPENSATION, Integer.valueOf(i));
    }

    public void g(int i) {
        e.a("OneCameraImpl", "setAISceneMode, mCameraRole: " + this.t + ", enable: " + i);
        a("com.oplus.ai.scene.app.enable", new int[]{i});
    }

    public void h(int i) {
        e.a("OneCameraImpl", "setPIMode, mCameraRole: " + this.t + ", enable: " + i);
        a("com.oplus.camera.pi.enable", new int[]{i});
    }

    public void i(int i) {
        a("com.oplus.capture.request.picture.size.scale", new int[]{i});
    }

    public void x(int i) {
        e.a("OneCameraImpl", "setPIEnableList, mCameraRole: " + this.t + ", enableList: " + Integer.toBinaryString(i));
        a("com.oplus.camera.pi.enable_list", new int[]{i});
    }

    public void j(int i) {
        e.a("OneCameraImpl", "setFaceBeautyLevel, mCameraRole: " + this.t + ", level: " + i);
        a("com.oplus.facebeauty.level", new int[]{i});
    }

    public void a(int[] iArr) {
        e.a("OneCameraImpl", "setCustomBeautyValues, mCameraRole: " + this.t + ", values: " + Arrays.toString(iArr));
        a("com.oplus.facebeauty.custom", iArr);
    }

    public void A(int i) {
        e.a("OneCameraImpl", "setApertureValue, mCameraRole: " + this.t + ", value: " + i);
        a("com.oplus.iris.aperture.value", new int[]{i});
    }

    public void q(int i) {
        e.a("OneCameraImpl", "setSceneMode, mCameraRole: " + this.t + ", mode: " + i);
        a(CaptureRequest.CONTROL_SCENE_MODE, Integer.valueOf(i));
    }

    public void r(int i) {
        e.a("OneCameraImpl", "setHDRMode, mCameraRole: " + this.t + ", mode: " + i);
        this.R = i;
        if (e() != null) {
            int i2 = 1;
            if (e().H()) {
                int i3 = this.R;
                if (i3 == 2) {
                    this.aa = 4;
                } else if (i3 == 1) {
                    this.aa = 3;
                } else {
                    this.aa = 0;
                }
                a("com.mediatek.hdrfeature.SessionParamhdrMode", new int[]{this.aa});
            }
            int[] iArr = new int[1];
            if (this.R != 2) {
                i2 = 0;
            }
            iArr[0] = i2;
            a("com.oplus.auto.hdr.enable", iArr);
        }
    }

    public void k(boolean z2) {
        e.a("OneCameraImpl", "setVHdrRequest, mCameraRole: " + this.t + ", enable: " + z2);
        if (z2) {
            a("com.mediatek.hdrfeature.hdrMode", new int[]{this.aa});
            return;
        }
        h("com.mediatek.hdrfeature.SessionParamhdrMode");
        h("com.mediatek.hdrfeature.hdrMode");
    }

    public void a(final boolean z2, boolean z3) {
        e.a("OneCameraImpl", "setAutoExposureLock, mCameraRole: " + this.t + ", aeLock: " + z2);
        a(CaptureRequest.CONTROL_AE_LOCK, Boolean.valueOf(z2));
        if (z2 && !Util.p()) {
            a(c.bo, Integer.valueOf(z3 ? 1 : 0));
        }
        this.l.a((Runnable) new Runnable() {
            public void run() {
                boolean unused = g.this.O = z2;
            }
        });
    }

    public void e(boolean z2) {
        e.a("OneCameraImpl", "setAutoWhiteBalanceLock, mCameraRole: " + this.t + ", awbLock: " + z2);
        a(CaptureRequest.CONTROL_AWB_LOCK, Boolean.valueOf(z2));
    }

    public void f(boolean z2) {
        e.a("OneCameraImpl", "setLongShotEnable, mCameraRole: " + this.t + ", enable: " + z2);
        a("com.oplus.longshot.enable", new int[]{z2});
    }

    public void s(int i) {
        e.a("OneCameraImpl", "setAheadCaptureFrameNum, num: " + i);
        a("com.oplus.ahead.capture.frame.num", new int[]{i});
    }

    public void g(boolean z2) {
        e.a("OneCameraImpl", "setZsl, zsl: " + z2);
        this.Q = z2;
        if (!Util.p()) {
            a("com.mediatek.control.capture.zsl.mode", new byte[]{z2 ? (byte) 1 : 0});
        } else if (Build.VERSION.SDK_INT >= 26) {
            a(CaptureRequest.CONTROL_ENABLE_ZSL, Boolean.valueOf(z2));
        }
    }

    public void a(String str, int[] iArr) {
        a(str, iArr);
    }

    public void a(String str) {
        e.b("OneCameraImpl", "setFlashMode, mCameraRole: " + this.t + ", value: " + str);
        if (str != null) {
            com.oppo.camera.u.d dVar = this.as;
            if (dVar != null) {
                dVar.a(str);
            }
            this.N = str;
            char c = 65535;
            int hashCode = str.hashCode();
            if (hashCode != 3551) {
                if (hashCode != 109935) {
                    if (hashCode != 3005871) {
                        if (hashCode == 110547964 && str.equals("torch")) {
                            c = 3;
                        }
                    } else if (str.equals(MenuClickMsgData.VALUE_PROFESSION_AUTO)) {
                        c = 2;
                    }
                } else if (str.equals("off")) {
                    c = 1;
                }
            } else if (str.equals("on")) {
                c = 0;
            }
            if (c == 0) {
                a(CaptureRequest.FLASH_MODE, 1);
                a(CaptureRequest.CONTROL_AE_MODE, 3);
            } else if (c == 1) {
                a(CaptureRequest.FLASH_MODE, 0);
                a(CaptureRequest.CONTROL_AE_MODE, 1);
            } else if (c == 2) {
                a(CaptureRequest.FLASH_MODE, 1);
                a(CaptureRequest.CONTROL_AE_MODE, 2);
            } else if (c == 3) {
                a(CaptureRequest.FLASH_MODE, 2);
                a(CaptureRequest.CONTROL_AE_MODE, 1);
            }
        }
    }

    public void c(boolean z2) {
        this.P = z2;
    }

    public void a(Image image, final TotalCaptureResult totalCaptureResult, final Rect rect, final d dVar) {
        e.b("OneCameraImpl", "reprocessImage, mCameraRole: " + this.t);
        if (this.y == null || this.A == null) {
            e.e("OneCameraImpl", "reprocessImage request is called even before taking picture, mCameraRole: " + this.t);
            image.close();
            return;
        }
        if (image != null) {
            try {
                synchronized (this.w) {
                    if (this.ad != null) {
                        this.ad.close();
                        this.ad = null;
                    }
                }
                if (this.r != 5 || !this.A.isReprocessable()) {
                    image.close();
                } else {
                    synchronized (this.w) {
                        if (this.A.getInputSurface() != null && this.ad == null) {
                            this.ad = ImageWriter.newInstance(this.A.getInputSurface(), 20);
                        }
                        if (this.ad != null) {
                            this.ad.queueInputImage(image);
                        }
                    }
                }
            } catch (IllegalStateException unused) {
                e.e("OneCameraImpl", "reprocessImage, Queueing more than it can have!, mCameraRole: " + this.t);
                image.close();
            } catch (IllegalArgumentException e) {
                e.e("OneCameraImpl", "reprocessImage, surface has occurred an error: " + e.getMessage());
                image.close();
            }
        }
        this.l.a((Runnable) new Runnable() {
            public void run() {
                CaptureRequest.Builder a2;
                if (g.this.r == 5 && g.this.A != null && (a2 = g.this.a(totalCaptureResult, dVar)) != null) {
                    Rect rect = rect;
                    if (rect != null && rect.width() > 0 && rect.height() > 0) {
                        a2.set(CaptureRequest.SCALER_CROP_REGION, g.this.a(a2, rect));
                    }
                    try {
                        g.this.A.capture(a2.build(), g.this.az, g.this.l);
                    } catch (Exception unused) {
                        e.e("OneCameraImpl", "reprocessImage, capture failed! mCameraRole: " + g.this.t);
                    }
                }
            }
        });
    }

    public void u() {
        synchronized (this.w) {
            if (this.ad != null) {
                e.b("OneCameraImpl", "closeImageWriter, mCameraRole: " + this.t);
                this.ad.close();
                this.ad = null;
            }
        }
    }

    /* access modifiers changed from: private */
    public Rect a(CaptureRequest.Builder builder, Rect rect) {
        float f;
        float f2;
        Rect rect2 = new Rect();
        Rect rect3 = (Rect) builder.get(CaptureRequest.SCALER_CROP_REGION);
        Rect d = this.C.d();
        if (rect3 == null || d == null) {
            f = 1.0f;
            f2 = 1.0f;
        } else {
            f2 = ((float) rect3.width()) / ((float) d.width());
            f = ((float) rect3.height()) / ((float) d.height());
        }
        int width = (int) ((((float) rect.width()) * (1.0f - f2)) / 2.0f);
        int height = (int) ((((float) rect.height()) * (1.0f - f)) / 2.0f);
        rect2.set(rect.left + width, rect.top + height, rect.right - width, rect.bottom - height);
        e.a("OneCameraImpl", "getZoomCropFormRegin, mCameraRole: " + this.t + ", newCropRegion: (" + rect2.left + ", " + rect2.top + ", " + rect2.right + ", " + rect2.bottom + "), scaleWidth: " + f2 + ", scaleHeight: " + f);
        return rect2;
    }

    public int[] a(CaptureResult.Key<?> key, CaptureResult captureResult) {
        Object a2 = c.a(captureResult, key);
        if (a2 == null || !(a2 instanceof int[])) {
            return null;
        }
        int[] iArr = (int[]) a2;
        if (iArr.length > 0) {
            return iArr;
        }
        return null;
    }

    private void P() {
        e.a("OneCameraImpl", "triggerAeAfForFlash, mCameraRole: " + this.t);
        this.l.a((Runnable) new Runnable() {
            public void run() {
                g gVar = g.this;
                CaptureRequest.Builder e = gVar.I(gVar.Z);
                if (e != null) {
                    e.set(CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER, 1);
                    if (g.this.p() != 1 && !g.this.b() && !g.this.O && !CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_TORCH_FLASH)) {
                        e.set(CaptureRequest.CONTROL_AF_TRIGGER, 1);
                    }
                    g gVar2 = g.this;
                    gVar2.a(e, gVar2.av, 1);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void Q() {
        if (!this.O) {
            if (!Util.p()) {
                a(c.bo, 0);
            }
            a(CaptureRequest.CONTROL_AE_LOCK, Boolean.TRUE);
            a(this.B, this.av, 0);
        }
    }

    /* access modifiers changed from: protected */
    public void w(final boolean z2) {
        e.a("OneCameraImpl", "resetParamsForFlash, mCameraRole: " + this.t + ", isFlashRequired: " + O() + ", cancelAETrigger: " + z2);
        this.aw.d();
        this.l.a((Runnable) new Runnable() {
            public void run() {
                g gVar = g.this;
                CaptureRequest.Builder e = gVar.I(gVar.Z);
                if (e != null && z2) {
                    e.set(CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER, 2);
                    if ((!Util.p() || 1 == g.this.s) && !g.this.O && !g.this.b()) {
                        e.set(CaptureRequest.CONTROL_AF_TRIGGER, 2);
                    }
                    g gVar2 = g.this;
                    gVar2.a(e, gVar2.av, 1);
                }
                if (g.this.b() && g.this.z != null) {
                    g.this.z.c();
                }
                if (g.this.b() || CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_TORCH_FLASH)) {
                    g gVar3 = g.this;
                    gVar3.a(gVar3.N);
                    g.this.a("com.oplus.ProTorchMode", new int[]{0});
                    g gVar4 = g.this;
                    gVar4.a(gVar4.B, g.this.av, 0);
                }
            }
        });
        if (!this.O) {
            a(CaptureRequest.CONTROL_AE_LOCK, Boolean.FALSE);
            a(this.B, this.av, 0);
        }
    }

    public void j() {
        e.a("OneCameraImpl", "startFaceDetection, mCameraRole: " + this.t + ", mDeviceState: " + this.r);
        e.a("startFaceDetection");
        a(CaptureRequest.STATISTICS_FACE_DETECT_MODE, 1);
        e.b("startFaceDetection");
    }

    public void t(int i) {
        e.a("OneCameraImpl", "setVideoEISRecordState, mCameraRole: " + this.t + ", value: " + i);
        a("com.oplus.eis.record.state", new int[]{i});
    }

    public void u(int i) {
        e.a("OneCameraImpl", "setMTKVideoEISRecordState, value: " + i);
        a("com.mediatek.streamingfeature.recordState", Integer.valueOf(i));
    }

    public void i(boolean z2) {
        e.a("OneCameraImpl", "setMTKTrackFocusState, isTrackFocusOpen: " + z2);
        a("com.oplus.track.focus.config.enable", new int[]{z2});
    }

    public void k() {
        e.a("OneCameraImpl", "stopFaceDetection, mCameraRole: " + this.t + ", mDeviceState: " + this.r);
        a(CaptureRequest.STATISTICS_FACE_DETECT_MODE, 0);
    }

    public void a(f.c cVar) {
        e.a("OneCameraImpl", "setRepeatingRequest, mCameraRole: " + this.t + ", previewCallback: " + cVar + ", mCameraCaptureSession: " + this.A + ", mPreviewBuilder: " + this.B + ", mDeviceState: " + this.r);
        if (3 == AlgoSwitchConfig.getApsVersion()) {
            Y();
        }
        if (cVar != null) {
            this.F = cVar;
        }
        a(this.B, this.av, 0);
    }

    /* access modifiers changed from: private */
    public void a(final CaptureRequest.Builder builder, final CameraCaptureSession.CaptureCallback captureCallback, final int i) {
        this.l.a((Runnable) new Runnable() {
            public void run() {
                CaptureRequest.Builder builder;
                e.a("OneCameraImpl", "submitRequest, mCameraRole: " + g.this.t + ", builder: " + builder + ", mCameraCaptureSession: " + g.this.A + ", type: " + i + ", mDeviceState: " + g.this.r);
                if (g.this.A != null && g.this.r == 5 && (builder = builder) != null) {
                    int i = i;
                    if (i == 0) {
                        g gVar = g.this;
                        boolean unused = gVar.a(builder, captureCallback, gVar.K);
                    } else if (i == 1) {
                        g gVar2 = g.this;
                        boolean unused2 = gVar2.b(builder, captureCallback, gVar2.K);
                    }
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public boolean a(CaptureRequest.Builder builder, CameraCaptureSession.CaptureCallback captureCallback, boolean z2) {
        e.a("OneCameraImpl", "requestRepeating, mCameraRole: " + this.t + ", builder: " + builder + ", isHFR: " + z2);
        a(builder);
        try {
            ArrayList arrayList = new ArrayList();
            Range<Integer> c = this.D.c();
            if (!z2) {
                if (c != null) {
                    builder.set(CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE, c);
                }
                arrayList.add(builder.build());
            } else if (c == null) {
                return false;
            } else {
                builder.set(CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE, c);
                arrayList.addAll(((CameraConstrainedHighSpeedCaptureSession) this.A).createHighSpeedRequestList(builder.build()));
            }
            com.oppo.camera.perf.a.c("launch_request_repeating");
            e.e("OneCameraImpl", "requestRepeating start, range: " + c);
            if (!arrayList.isEmpty()) {
                this.M = ((CaptureRequest) arrayList.get(0)).hashCode();
            }
            e.a("CameraStartupPerformance.setRepeatingRequest");
            this.A.setRepeatingBurst(arrayList, captureCallback, this.m);
            e.b("CameraStartupPerformance.setRepeatingRequest");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            this.al.open();
            return true;
        }
    }

    /* access modifiers changed from: private */
    public boolean b(CaptureRequest.Builder builder, CameraCaptureSession.CaptureCallback captureCallback, boolean z2) {
        e.a("OneCameraImpl", "requestCapture, mCameraRole: " + this.t + ", builder: " + builder + ", isHFR: " + z2);
        a(builder);
        try {
            ArrayList arrayList = new ArrayList();
            Range<Integer> c = this.D.c();
            if (!z2) {
                if (c != null) {
                    builder.set(CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE, c);
                }
                arrayList.add(builder.build());
            } else if (c == null) {
                return false;
            } else {
                builder.set(CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE, c);
                arrayList.addAll(((CameraConstrainedHighSpeedCaptureSession) this.A).createHighSpeedRequestList(builder.build()));
            }
            e.e("OneCameraImpl", "requestCapture start, mCameraRole: " + this.t + ", range: " + c);
            this.A.captureBurst(arrayList, captureCallback, this.m);
            return true;
        } catch (Exception e) {
            e.e("OneCameraImpl", "requestCapture, mCameraRole: " + this.t + ", e: " + e.getMessage());
            return false;
        }
    }

    private InputConfiguration R() {
        e.a("getInputConfiguration");
        f.d dVar = this.D;
        if (dVar != null) {
            InputConfiguration a2 = dVar.a();
            e.b("getInputConfiguration");
            return a2;
        }
        e.b("getInputConfiguration");
        return null;
    }

    private List<f.C0084f> S() {
        e.a("builderOutputSurfaces");
        if (this.H == null) {
            this.H = new LinkedHashMap<>();
        }
        f.d dVar = this.D;
        if (dVar != null) {
            dVar.a(this.H, this.t);
        }
        e.b("builderOutputSurfaces");
        return new ArrayList(this.H.values());
    }

    public CaptureRequest.Builder a(Set<String> set) throws CameraAccessException {
        int i;
        StringBuilder sb = new StringBuilder();
        sb.append("createPreviewBuilder, mCameraRole: ");
        sb.append(this.t);
        sb.append(", mDeviceState: ");
        sb.append(this.r);
        sb.append(" cameraDeviceHashCode: ");
        CameraDevice cameraDevice = this.y;
        if (cameraDevice == null) {
            i = 0;
        } else {
            i = cameraDevice.hashCode();
        }
        sb.append(i);
        sb.append(", ids: ");
        sb.append(set);
        e.e("OneCameraImpl", sb.toString());
        if (this.B != null && this.y != null && this.af.V == this.Z && this.af.U == this.y.hashCode() && Util.a((Set) set, (Set) this.af.ak)) {
            return this.B;
        }
        e.a("createPreviewBuilder");
        if (this.y != null) {
            this.af.a(d.a.PREVIEW);
            if (set == null || set.isEmpty()) {
                this.B = this.y.createCaptureRequest(this.Z);
            } else {
                this.B = this.y.createCaptureRequest(this.Z, set);
            }
            this.af.U = this.y.hashCode();
            d dVar = this.af;
            dVar.V = this.Z;
            dVar.ak = set;
            dVar.al = ApsUtils.getCaptureRequestMetaDatas(this.B);
            this.B.setTag(this.af);
        }
        e.b("createPreviewBuilder");
        e.e("OneCameraImpl", "createPreviewBuilder X, mCameraRole: " + this.t);
        return this.B;
    }

    private void a(Set<String> set, int i) {
        if (this.H.get("type_main_preview_frame") != null) {
            this.B.addTarget(this.H.get("type_main_preview_frame").a());
        }
        if (this.H.get("type_sub_preview_frame") != null && (set == null || set.isEmpty())) {
            this.B.addTarget(this.H.get("type_sub_preview_frame").a());
        }
        if (this.K && 3 == this.Z) {
            if (this.H.get("type_video_frame") != null) {
                this.B.addTarget(this.H.get("type_video_frame").a());
            } else {
                this.B.addTarget(this.H.get("type_video").a());
            }
        }
        if (3 == this.Z && this.ah) {
            e.a("OneCameraImpl", "attachSurfaceToBuilder, mbSurfaceAddTypeVideo is true, mCameraRole: " + this.t);
            this.ah = false;
        }
        if (this.H.get("type_depth_preview") != null) {
            this.B.addTarget(this.H.get("type_depth_preview").a());
        }
        f.e eVar = this.z;
        if (eVar != null) {
            eVar.a(this.af, this.B, (HashMap<String, f.C0084f>) this.H, this.t);
        }
    }

    /* access modifiers changed from: private */
    public CaptureRequest.Builder I(int i) {
        CaptureRequest.Builder builder;
        e.a("OneCameraImpl", "createTriggerBuilder, mCameraRole: " + this.t + ", templateType: " + i + ", mPhysicalIds: " + this.af.ak);
        CameraDevice cameraDevice = this.y;
        CaptureRequest.Builder builder2 = null;
        if (cameraDevice != null) {
            try {
                if (a.g(Integer.parseInt(cameraDevice.getId()))) {
                    builder = this.y.createCaptureRequest(i, this.af.ak);
                    try {
                        d dVar = new d();
                        dVar.al = ApsUtils.getCaptureRequestMetaDatas(builder);
                        builder.setTag(dVar);
                        if (this.z != null) {
                            this.z.a(builder, -1, -1, (String[]) null);
                        }
                    } catch (CameraAccessException e) {
                        e = e;
                        builder2 = builder;
                        e.e("OneCameraImpl", "createTriggerBuilder, mCameraRole: " + this.t + ", e: " + e.getMessage());
                        return builder2;
                    }
                } else {
                    builder = this.y.createCaptureRequest(i);
                }
                builder2 = builder;
                a(builder2, 2);
                if ((this.ah || this.K) && 3 == this.Z && builder2 != null) {
                    e.a("OneCameraImpl", "createTriggerBuilder, mCameraRole: " + this.t + ", mbAddVideoSurface: " + this.ah + ", mbHFR: " + this.K + ", TYPE_VIDEO surface: " + this.H.get("type_video") + ", TYPE_VIDEO_FRAME surface: " + this.H.get("type_video_frame"));
                    if (this.H.get("type_video_frame") != null) {
                        builder2.addTarget(this.H.get("type_video_frame").a());
                    } else if (this.H.get("type_video") != null) {
                        builder2.addTarget(this.H.get("type_video").a());
                    }
                }
            } catch (CameraAccessException e2) {
                e = e2;
                e.e("OneCameraImpl", "createTriggerBuilder, mCameraRole: " + this.t + ", e: " + e.getMessage());
                return builder2;
            }
        }
        return builder2;
    }

    public void a(final f.a aVar, final d dVar) {
        this.l.a((Runnable) new Runnable() {
            public void run() {
                d unused = g.this.ae = dVar;
                CaptureRequest.Builder N = g.this.T();
                if (N != null) {
                    N.addTarget(((f.C0084f) g.this.H.get("type_main_preview_frame")).a());
                    if (g.this.H.get("type_still_capture_yuv_main") != null) {
                        N.addTarget(((f.C0084f) g.this.H.get("type_still_capture_yuv_main")).a());
                    }
                    if (g.this.H.get("type_still_capture_jpeg") != null) {
                        N.addTarget(((f.C0084f) g.this.H.get("type_still_capture_jpeg")).a());
                    }
                    if (!g.this.ae.p && g.this.H.get("type_video") != null) {
                        N.addTarget(((f.C0084f) g.this.H.get("type_video")).a());
                    }
                    if (!g.this.ae.p && g.this.H.get("type_video_frame") != null) {
                        N.addTarget(((f.C0084f) g.this.H.get("type_video_frame")).a());
                    }
                    Range<Integer> c2 = g.this.D.c();
                    if (c2 != null) {
                        N.set(CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE, c2);
                    }
                    try {
                        f.a unused2 = g.this.E = aVar;
                        g.this.A.capture(N.build(), g.this.az, g.this.l);
                    } catch (CameraAccessException e) {
                        e.e("OneCameraImpl", "videoSnapshot, mCameraRole: " + g.this.t + ", e: " + e.getMessage());
                    }
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public CaptureRequest.Builder T() {
        CaptureRequest.Builder builder = null;
        try {
            builder = this.y.createCaptureRequest(4);
            builder.setTag(this.ae);
            a(builder);
            return builder;
        } catch (CameraAccessException e) {
            e.e("OneCameraImpl", "createVideoSnapshotBuilder, mCameraRole: " + this.t + ", e: " + e.getMessage());
            return builder;
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x02b7 A[Catch:{ CameraAccessException -> 0x02c3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00f5 A[SYNTHETIC, Splitter:B:34:0x00f5] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0170 A[Catch:{ CameraAccessException -> 0x02c3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x01da A[Catch:{ CameraAccessException -> 0x02c3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x026f A[Catch:{ CameraAccessException -> 0x02c3 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.hardware.camera2.CaptureRequest.Builder a(com.oppo.camera.f.d r15) {
        /*
            r14 = this;
            java.lang.String r0 = "type_still_capture_yuv_mfnr"
            java.lang.String r1 = "type_still_capture_jpeg"
            java.lang.String r2 = ", e: "
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "createCaptureBuilder, mCameraRole: "
            r3.append(r4)
            int r5 = r14.t
            r3.append(r5)
            java.lang.String r5 = ", mbZsl: "
            r3.append(r5)
            boolean r5 = r14.Q
            r3.append(r5)
            java.lang.String r5 = ", requestTag: "
            r3.append(r5)
            r3.append(r15)
            java.lang.String r3 = r3.toString()
            java.lang.String r5 = "OneCameraImpl"
            com.oppo.camera.e.a(r5, r3)
            android.hardware.camera2.CameraDevice r3 = r14.y
            r6 = 0
            if (r3 == 0) goto L_0x02e2
            android.hardware.camera2.CaptureRequest$Builder r6 = r14.Z()     // Catch:{ CameraAccessException -> 0x02c3 }
            com.oppo.camera.f.d r3 = r14.ae     // Catch:{ CameraAccessException -> 0x02c3 }
            androidx.collection.ArrayMap r7 = com.oppo.camera.aps.adapter.ApsUtils.getCaptureRequestMetaDatas(r6)     // Catch:{ CameraAccessException -> 0x02c3 }
            r3.al = r7     // Catch:{ CameraAccessException -> 0x02c3 }
            com.oppo.camera.f.d r3 = r14.ae     // Catch:{ CameraAccessException -> 0x02c3 }
            r6.setTag(r3)     // Catch:{ CameraAccessException -> 0x02c3 }
            r14.a((android.hardware.camera2.CaptureRequest.Builder) r6)     // Catch:{ CameraAccessException -> 0x02c3 }
            boolean r3 = com.oppo.camera.util.Util.p()     // Catch:{ CameraAccessException -> 0x02c3 }
            r7 = 0
            r8 = 1
            if (r3 != 0) goto L_0x0092
            boolean r3 = r15.o     // Catch:{ CameraAccessException -> 0x02c3 }
            if (r3 == 0) goto L_0x0087
            android.hardware.camera2.CaptureRequest$Key<int[]> r3 = com.oppo.camera.f.c.v     // Catch:{ Exception -> 0x0068 }
            int[] r9 = new int[r8]     // Catch:{ Exception -> 0x0068 }
            r9[r7] = r8     // Catch:{ Exception -> 0x0068 }
            r6.set(r3, r9)     // Catch:{ Exception -> 0x0068 }
            android.hardware.camera2.CaptureRequest$Key<int[]> r3 = com.oppo.camera.f.c.w     // Catch:{ Exception -> 0x0068 }
            int[] r9 = new int[r8]     // Catch:{ Exception -> 0x0068 }
            r9[r7] = r8     // Catch:{ Exception -> 0x0068 }
            r6.set(r3, r9)     // Catch:{ Exception -> 0x0068 }
            goto L_0x0087
        L_0x0068:
            r3 = move-exception
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ CameraAccessException -> 0x02c3 }
            r9.<init>()     // Catch:{ CameraAccessException -> 0x02c3 }
            r9.append(r4)     // Catch:{ CameraAccessException -> 0x02c3 }
            int r10 = r14.t     // Catch:{ CameraAccessException -> 0x02c3 }
            r9.append(r10)     // Catch:{ CameraAccessException -> 0x02c3 }
            r9.append(r2)     // Catch:{ CameraAccessException -> 0x02c3 }
            java.lang.String r3 = r3.getMessage()     // Catch:{ CameraAccessException -> 0x02c3 }
            r9.append(r3)     // Catch:{ CameraAccessException -> 0x02c3 }
            java.lang.String r3 = r9.toString()     // Catch:{ CameraAccessException -> 0x02c3 }
            com.oppo.camera.e.e(r5, r3)     // Catch:{ CameraAccessException -> 0x02c3 }
        L_0x0087:
            android.hardware.camera2.CaptureRequest$Key r3 = android.hardware.camera2.CaptureRequest.CONTROL_ENABLE_ZSL     // Catch:{ CameraAccessException -> 0x02c3 }
            boolean r9 = r14.Q     // Catch:{ CameraAccessException -> 0x02c3 }
            java.lang.Boolean r9 = java.lang.Boolean.valueOf(r9)     // Catch:{ CameraAccessException -> 0x02c3 }
            r6.set(r3, r9)     // Catch:{ CameraAccessException -> 0x02c3 }
        L_0x0092:
            r14.a((android.hardware.camera2.CaptureRequest.Builder) r6, (int) r8)     // Catch:{ CameraAccessException -> 0x02c3 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ CameraAccessException -> 0x02c3 }
            r3.<init>()     // Catch:{ CameraAccessException -> 0x02c3 }
            r3.append(r4)     // Catch:{ CameraAccessException -> 0x02c3 }
            int r9 = r14.t     // Catch:{ CameraAccessException -> 0x02c3 }
            r3.append(r9)     // Catch:{ CameraAccessException -> 0x02c3 }
            java.lang.String r9 = ", mSensorMask: "
            r3.append(r9)     // Catch:{ CameraAccessException -> 0x02c3 }
            int[] r9 = r15.X     // Catch:{ CameraAccessException -> 0x02c3 }
            java.lang.String r9 = java.util.Arrays.toString(r9)     // Catch:{ CameraAccessException -> 0x02c3 }
            r3.append(r9)     // Catch:{ CameraAccessException -> 0x02c3 }
            java.lang.String r3 = r3.toString()     // Catch:{ CameraAccessException -> 0x02c3 }
            com.oppo.camera.e.b(r5, r3)     // Catch:{ CameraAccessException -> 0x02c3 }
            com.oppo.camera.f.d$a r3 = r15.a()     // Catch:{ CameraAccessException -> 0x02c3 }
            java.lang.String r9 = "com.oplus.night.sensor.mark.support"
            boolean r9 = com.oppo.camera.aps.config.CameraConfig.getConfigBooleanValue(r9)     // Catch:{ CameraAccessException -> 0x02c3 }
            r10 = 2
            if (r9 == 0) goto L_0x00ea
            int[] r9 = r15.X     // Catch:{ CameraAccessException -> 0x02c3 }
            if (r9 == 0) goto L_0x00ea
            int[] r9 = r15.X     // Catch:{ CameraAccessException -> 0x02c3 }
            int r9 = r9.length     // Catch:{ CameraAccessException -> 0x02c3 }
            if (r9 <= 0) goto L_0x00ea
            int[] r9 = r15.X     // Catch:{ CameraAccessException -> 0x02c3 }
            r9 = r9[r7]     // Catch:{ CameraAccessException -> 0x02c3 }
            if (r9 != 0) goto L_0x00e1
            int[] r9 = r15.X     // Catch:{ CameraAccessException -> 0x02c3 }
            r9 = r9[r8]     // Catch:{ CameraAccessException -> 0x02c3 }
            if (r9 != 0) goto L_0x00e1
            int[] r9 = r15.X     // Catch:{ CameraAccessException -> 0x02c3 }
            r9 = r9[r10]     // Catch:{ CameraAccessException -> 0x02c3 }
            if (r9 != 0) goto L_0x00e1
            r9 = r8
            goto L_0x00e2
        L_0x00e1:
            r9 = r7
        L_0x00e2:
            if (r9 != 0) goto L_0x00ea
            com.oppo.camera.f.d$a r9 = com.oppo.camera.f.d.a.CAPTURE_RAW     // Catch:{ CameraAccessException -> 0x02c3 }
            if (r9 == r3) goto L_0x00ea
            r3 = r8
            goto L_0x00eb
        L_0x00ea:
            r3 = r7
        L_0x00eb:
            java.lang.String r9 = "type_tuning_data_yuv"
            java.lang.String r11 = "type_still_capture_yuv_third"
            java.lang.String r12 = "type_still_capture_yuv_sub"
            java.lang.String r13 = "type_still_capture_yuv_main"
            if (r3 == 0) goto L_0x0170
            int[] r3 = r15.X     // Catch:{ CameraAccessException -> 0x02c3 }
            r3 = r3[r8]     // Catch:{ CameraAccessException -> 0x02c3 }
            if (r8 != r3) goto L_0x0112
            java.util.LinkedHashMap<java.lang.String, com.oppo.camera.f.f$f> r3 = r14.H     // Catch:{ CameraAccessException -> 0x02c3 }
            java.lang.Object r3 = r3.get(r13)     // Catch:{ CameraAccessException -> 0x02c3 }
            if (r3 == 0) goto L_0x0112
            java.util.LinkedHashMap<java.lang.String, com.oppo.camera.f.f$f> r3 = r14.H     // Catch:{ CameraAccessException -> 0x02c3 }
            java.lang.Object r3 = r3.get(r13)     // Catch:{ CameraAccessException -> 0x02c3 }
            com.oppo.camera.f.f$f r3 = (com.oppo.camera.f.f.C0084f) r3     // Catch:{ CameraAccessException -> 0x02c3 }
            android.view.Surface r3 = r3.a()     // Catch:{ CameraAccessException -> 0x02c3 }
            r6.addTarget(r3)     // Catch:{ CameraAccessException -> 0x02c3 }
        L_0x0112:
            int[] r3 = r15.X     // Catch:{ CameraAccessException -> 0x02c3 }
            r3 = r3[r7]     // Catch:{ CameraAccessException -> 0x02c3 }
            if (r8 != r3) goto L_0x012f
            java.util.LinkedHashMap<java.lang.String, com.oppo.camera.f.f$f> r3 = r14.H     // Catch:{ CameraAccessException -> 0x02c3 }
            java.lang.Object r3 = r3.get(r12)     // Catch:{ CameraAccessException -> 0x02c3 }
            if (r3 == 0) goto L_0x012f
            java.util.LinkedHashMap<java.lang.String, com.oppo.camera.f.f$f> r3 = r14.H     // Catch:{ CameraAccessException -> 0x02c3 }
            java.lang.Object r3 = r3.get(r12)     // Catch:{ CameraAccessException -> 0x02c3 }
            com.oppo.camera.f.f$f r3 = (com.oppo.camera.f.f.C0084f) r3     // Catch:{ CameraAccessException -> 0x02c3 }
            android.view.Surface r3 = r3.a()     // Catch:{ CameraAccessException -> 0x02c3 }
            r6.addTarget(r3)     // Catch:{ CameraAccessException -> 0x02c3 }
        L_0x012f:
            int[] r3 = r15.X     // Catch:{ CameraAccessException -> 0x02c3 }
            r3 = r3[r10]     // Catch:{ CameraAccessException -> 0x02c3 }
            if (r8 != r3) goto L_0x014c
            java.util.LinkedHashMap<java.lang.String, com.oppo.camera.f.f$f> r3 = r14.H     // Catch:{ CameraAccessException -> 0x02c3 }
            java.lang.Object r3 = r3.get(r11)     // Catch:{ CameraAccessException -> 0x02c3 }
            if (r3 == 0) goto L_0x014c
            java.util.LinkedHashMap<java.lang.String, com.oppo.camera.f.f$f> r3 = r14.H     // Catch:{ CameraAccessException -> 0x02c3 }
            java.lang.Object r3 = r3.get(r11)     // Catch:{ CameraAccessException -> 0x02c3 }
            com.oppo.camera.f.f$f r3 = (com.oppo.camera.f.f.C0084f) r3     // Catch:{ CameraAccessException -> 0x02c3 }
            android.view.Surface r3 = r3.a()     // Catch:{ CameraAccessException -> 0x02c3 }
            r6.addTarget(r3)     // Catch:{ CameraAccessException -> 0x02c3 }
        L_0x014c:
            boolean r3 = com.oppo.camera.util.Util.p()     // Catch:{ CameraAccessException -> 0x02c3 }
            if (r3 != 0) goto L_0x01d2
            int[] r3 = r15.X     // Catch:{ CameraAccessException -> 0x02c3 }
            r3 = r3[r8]     // Catch:{ CameraAccessException -> 0x02c3 }
            if (r8 != r3) goto L_0x01d2
            java.util.LinkedHashMap<java.lang.String, com.oppo.camera.f.f$f> r3 = r14.H     // Catch:{ CameraAccessException -> 0x02c3 }
            java.lang.Object r3 = r3.get(r9)     // Catch:{ CameraAccessException -> 0x02c3 }
            if (r3 == 0) goto L_0x01d2
            java.util.LinkedHashMap<java.lang.String, com.oppo.camera.f.f$f> r3 = r14.H     // Catch:{ CameraAccessException -> 0x02c3 }
            java.lang.Object r3 = r3.get(r9)     // Catch:{ CameraAccessException -> 0x02c3 }
            com.oppo.camera.f.f$f r3 = (com.oppo.camera.f.f.C0084f) r3     // Catch:{ CameraAccessException -> 0x02c3 }
            android.view.Surface r3 = r3.a()     // Catch:{ CameraAccessException -> 0x02c3 }
            r6.addTarget(r3)     // Catch:{ CameraAccessException -> 0x02c3 }
            goto L_0x01d2
        L_0x0170:
            java.util.LinkedHashMap<java.lang.String, com.oppo.camera.f.f$f> r3 = r14.H     // Catch:{ CameraAccessException -> 0x02c3 }
            java.lang.Object r3 = r3.get(r13)     // Catch:{ CameraAccessException -> 0x02c3 }
            if (r3 == 0) goto L_0x0187
            java.util.LinkedHashMap<java.lang.String, com.oppo.camera.f.f$f> r3 = r14.H     // Catch:{ CameraAccessException -> 0x02c3 }
            java.lang.Object r3 = r3.get(r13)     // Catch:{ CameraAccessException -> 0x02c3 }
            com.oppo.camera.f.f$f r3 = (com.oppo.camera.f.f.C0084f) r3     // Catch:{ CameraAccessException -> 0x02c3 }
            android.view.Surface r3 = r3.a()     // Catch:{ CameraAccessException -> 0x02c3 }
            r6.addTarget(r3)     // Catch:{ CameraAccessException -> 0x02c3 }
        L_0x0187:
            java.util.LinkedHashMap<java.lang.String, com.oppo.camera.f.f$f> r3 = r14.H     // Catch:{ CameraAccessException -> 0x02c3 }
            java.lang.Object r3 = r3.get(r12)     // Catch:{ CameraAccessException -> 0x02c3 }
            if (r3 == 0) goto L_0x019e
            java.util.LinkedHashMap<java.lang.String, com.oppo.camera.f.f$f> r3 = r14.H     // Catch:{ CameraAccessException -> 0x02c3 }
            java.lang.Object r3 = r3.get(r12)     // Catch:{ CameraAccessException -> 0x02c3 }
            com.oppo.camera.f.f$f r3 = (com.oppo.camera.f.f.C0084f) r3     // Catch:{ CameraAccessException -> 0x02c3 }
            android.view.Surface r3 = r3.a()     // Catch:{ CameraAccessException -> 0x02c3 }
            r6.addTarget(r3)     // Catch:{ CameraAccessException -> 0x02c3 }
        L_0x019e:
            java.util.LinkedHashMap<java.lang.String, com.oppo.camera.f.f$f> r3 = r14.H     // Catch:{ CameraAccessException -> 0x02c3 }
            java.lang.Object r3 = r3.get(r11)     // Catch:{ CameraAccessException -> 0x02c3 }
            if (r3 == 0) goto L_0x01b5
            java.util.LinkedHashMap<java.lang.String, com.oppo.camera.f.f$f> r3 = r14.H     // Catch:{ CameraAccessException -> 0x02c3 }
            java.lang.Object r3 = r3.get(r11)     // Catch:{ CameraAccessException -> 0x02c3 }
            com.oppo.camera.f.f$f r3 = (com.oppo.camera.f.f.C0084f) r3     // Catch:{ CameraAccessException -> 0x02c3 }
            android.view.Surface r3 = r3.a()     // Catch:{ CameraAccessException -> 0x02c3 }
            r6.addTarget(r3)     // Catch:{ CameraAccessException -> 0x02c3 }
        L_0x01b5:
            boolean r3 = com.oppo.camera.util.Util.p()     // Catch:{ CameraAccessException -> 0x02c3 }
            if (r3 != 0) goto L_0x01d2
            java.util.LinkedHashMap<java.lang.String, com.oppo.camera.f.f$f> r3 = r14.H     // Catch:{ CameraAccessException -> 0x02c3 }
            java.lang.Object r3 = r3.get(r9)     // Catch:{ CameraAccessException -> 0x02c3 }
            if (r3 == 0) goto L_0x01d2
            java.util.LinkedHashMap<java.lang.String, com.oppo.camera.f.f$f> r3 = r14.H     // Catch:{ CameraAccessException -> 0x02c3 }
            java.lang.Object r3 = r3.get(r9)     // Catch:{ CameraAccessException -> 0x02c3 }
            com.oppo.camera.f.f$f r3 = (com.oppo.camera.f.f.C0084f) r3     // Catch:{ CameraAccessException -> 0x02c3 }
            android.view.Surface r3 = r3.a()     // Catch:{ CameraAccessException -> 0x02c3 }
            r6.addTarget(r3)     // Catch:{ CameraAccessException -> 0x02c3 }
        L_0x01d2:
            java.util.LinkedHashMap<java.lang.String, com.oppo.camera.f.f$f> r3 = r14.H     // Catch:{ CameraAccessException -> 0x02c3 }
            java.lang.Object r3 = r3.get(r1)     // Catch:{ CameraAccessException -> 0x02c3 }
            if (r3 == 0) goto L_0x01e9
            java.util.LinkedHashMap<java.lang.String, com.oppo.camera.f.f$f> r3 = r14.H     // Catch:{ CameraAccessException -> 0x02c3 }
            java.lang.Object r1 = r3.get(r1)     // Catch:{ CameraAccessException -> 0x02c3 }
            com.oppo.camera.f.f$f r1 = (com.oppo.camera.f.f.C0084f) r1     // Catch:{ CameraAccessException -> 0x02c3 }
            android.view.Surface r1 = r1.a()     // Catch:{ CameraAccessException -> 0x02c3 }
            r6.addTarget(r1)     // Catch:{ CameraAccessException -> 0x02c3 }
        L_0x01e9:
            boolean r1 = r14.ag     // Catch:{ CameraAccessException -> 0x02c3 }
            if (r1 != 0) goto L_0x0217
            boolean r1 = r15.S     // Catch:{ CameraAccessException -> 0x02c3 }
            if (r1 == 0) goto L_0x0217
            java.util.LinkedHashMap<java.lang.String, com.oppo.camera.f.f$f> r1 = r14.H     // Catch:{ CameraAccessException -> 0x02c3 }
            java.lang.Object r1 = r1.get(r0)     // Catch:{ CameraAccessException -> 0x02c3 }
            if (r1 == 0) goto L_0x0217
            java.util.LinkedHashMap<java.lang.String, com.oppo.camera.f.f$f> r1 = r14.H     // Catch:{ CameraAccessException -> 0x02c3 }
            java.lang.Object r1 = r1.get(r13)     // Catch:{ CameraAccessException -> 0x02c3 }
            com.oppo.camera.f.f$f r1 = (com.oppo.camera.f.f.C0084f) r1     // Catch:{ CameraAccessException -> 0x02c3 }
            android.view.Surface r1 = r1.a()     // Catch:{ CameraAccessException -> 0x02c3 }
            r6.removeTarget(r1)     // Catch:{ CameraAccessException -> 0x02c3 }
            java.util.LinkedHashMap<java.lang.String, com.oppo.camera.f.f$f> r1 = r14.H     // Catch:{ CameraAccessException -> 0x02c3 }
            java.lang.Object r0 = r1.get(r0)     // Catch:{ CameraAccessException -> 0x02c3 }
            com.oppo.camera.f.f$f r0 = (com.oppo.camera.f.f.C0084f) r0     // Catch:{ CameraAccessException -> 0x02c3 }
            android.view.Surface r0 = r0.a()     // Catch:{ CameraAccessException -> 0x02c3 }
            r6.addTarget(r0)     // Catch:{ CameraAccessException -> 0x02c3 }
        L_0x0217:
            int r0 = r15.ac     // Catch:{ Exception -> 0x0231 }
            if (r10 != r0) goto L_0x0250
            int r0 = r15.aa     // Catch:{ Exception -> 0x0231 }
            if (r8 == r0) goto L_0x0225
            r0 = 11
            int r1 = r15.aa     // Catch:{ Exception -> 0x0231 }
            if (r0 != r1) goto L_0x0250
        L_0x0225:
            android.hardware.camera2.CaptureRequest$Key<int[]> r0 = com.oppo.camera.f.c.h     // Catch:{ Exception -> 0x0231 }
            int[] r1 = new int[r8]     // Catch:{ Exception -> 0x0231 }
            int r3 = r15.q     // Catch:{ Exception -> 0x0231 }
            r1[r7] = r3     // Catch:{ Exception -> 0x0231 }
            r6.set(r0, r1)     // Catch:{ Exception -> 0x0231 }
            goto L_0x0250
        L_0x0231:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ CameraAccessException -> 0x02c3 }
            r1.<init>()     // Catch:{ CameraAccessException -> 0x02c3 }
            r1.append(r4)     // Catch:{ CameraAccessException -> 0x02c3 }
            int r3 = r14.t     // Catch:{ CameraAccessException -> 0x02c3 }
            r1.append(r3)     // Catch:{ CameraAccessException -> 0x02c3 }
            r1.append(r2)     // Catch:{ CameraAccessException -> 0x02c3 }
            java.lang.String r0 = r0.getMessage()     // Catch:{ CameraAccessException -> 0x02c3 }
            r1.append(r0)     // Catch:{ CameraAccessException -> 0x02c3 }
            java.lang.String r0 = r1.toString()     // Catch:{ CameraAccessException -> 0x02c3 }
            com.oppo.camera.e.e(r5, r0)     // Catch:{ CameraAccessException -> 0x02c3 }
        L_0x0250:
            boolean r0 = r15.g     // Catch:{ CameraAccessException -> 0x02c3 }
            if (r0 == 0) goto L_0x0267
            java.lang.String r0 = "com.oplus.quadcfa.blurless"
            boolean r0 = com.oppo.camera.aps.config.CameraConfig.getConfigBooleanValue(r0)     // Catch:{ CameraAccessException -> 0x02c3 }
            if (r0 == 0) goto L_0x0267
            android.hardware.camera2.CaptureRequest$Key<int[]> r0 = com.oppo.camera.f.c.aV     // Catch:{ CameraAccessException -> 0x02c3 }
            int[] r1 = new int[r8]     // Catch:{ CameraAccessException -> 0x02c3 }
            int r3 = r15.q     // Catch:{ CameraAccessException -> 0x02c3 }
            r1[r7] = r3     // Catch:{ CameraAccessException -> 0x02c3 }
            r6.set(r0, r1)     // Catch:{ CameraAccessException -> 0x02c3 }
        L_0x0267:
            java.lang.String r0 = "com.oplus.mfnr.support"
            boolean r0 = com.oppo.camera.aps.config.CameraConfig.getConfigBooleanValue(r0)     // Catch:{ CameraAccessException -> 0x02c3 }
            if (r0 == 0) goto L_0x02b3
            r0 = 3
            int r1 = r15.ac     // Catch:{ CameraAccessException -> 0x02c3 }
            if (r0 != r1) goto L_0x0298
            int r0 = r15.ae     // Catch:{ CameraAccessException -> 0x02c3 }
            if (r0 == 0) goto L_0x0298
            android.hardware.camera2.CaptureRequest$Key<int[]> r0 = com.oppo.camera.f.c.aR     // Catch:{ CameraAccessException -> 0x02c3 }
            int[] r1 = new int[r8]     // Catch:{ CameraAccessException -> 0x02c3 }
            int r15 = r15.ae     // Catch:{ CameraAccessException -> 0x02c3 }
            r1[r7] = r15     // Catch:{ CameraAccessException -> 0x02c3 }
            r6.set(r0, r1)     // Catch:{ CameraAccessException -> 0x02c3 }
            android.hardware.camera2.CaptureRequest$Key<java.lang.Byte> r15 = com.oppo.camera.f.c.aS     // Catch:{ CameraAccessException -> 0x02c3 }
            r0 = 102(0x66, float:1.43E-43)
            java.lang.Byte r0 = java.lang.Byte.valueOf(r0)     // Catch:{ CameraAccessException -> 0x02c3 }
            r6.set(r15, r0)     // Catch:{ CameraAccessException -> 0x02c3 }
            android.hardware.camera2.CaptureRequest$Key r15 = android.hardware.camera2.CaptureRequest.NOISE_REDUCTION_MODE     // Catch:{ CameraAccessException -> 0x02c3 }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r10)     // Catch:{ CameraAccessException -> 0x02c3 }
            r6.set(r15, r0)     // Catch:{ CameraAccessException -> 0x02c3 }
            goto L_0x02b3
        L_0x0298:
            android.hardware.camera2.CaptureRequest$Key<int[]> r15 = com.oppo.camera.f.c.aR     // Catch:{ CameraAccessException -> 0x02c3 }
            int[] r0 = new int[r8]     // Catch:{ CameraAccessException -> 0x02c3 }
            r0[r7] = r7     // Catch:{ CameraAccessException -> 0x02c3 }
            r6.set(r15, r0)     // Catch:{ CameraAccessException -> 0x02c3 }
            android.hardware.camera2.CaptureRequest$Key<java.lang.Byte> r15 = com.oppo.camera.f.c.aS     // Catch:{ CameraAccessException -> 0x02c3 }
            java.lang.Byte r0 = java.lang.Byte.valueOf(r7)     // Catch:{ CameraAccessException -> 0x02c3 }
            r6.set(r15, r0)     // Catch:{ CameraAccessException -> 0x02c3 }
            android.hardware.camera2.CaptureRequest$Key r15 = android.hardware.camera2.CaptureRequest.NOISE_REDUCTION_MODE     // Catch:{ CameraAccessException -> 0x02c3 }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r8)     // Catch:{ CameraAccessException -> 0x02c3 }
            r6.set(r15, r0)     // Catch:{ CameraAccessException -> 0x02c3 }
        L_0x02b3:
            com.oppo.camera.f.f$e r15 = r14.z     // Catch:{ CameraAccessException -> 0x02c3 }
            if (r15 == 0) goto L_0x02e2
            com.oppo.camera.f.f$e r15 = r14.z     // Catch:{ CameraAccessException -> 0x02c3 }
            com.oppo.camera.f.d r0 = r14.ae     // Catch:{ CameraAccessException -> 0x02c3 }
            java.util.LinkedHashMap<java.lang.String, com.oppo.camera.f.f$f> r1 = r14.H     // Catch:{ CameraAccessException -> 0x02c3 }
            int r3 = r14.t     // Catch:{ CameraAccessException -> 0x02c3 }
            r15.a((com.oppo.camera.f.d) r0, (android.hardware.camera2.CaptureRequest.Builder) r6, (java.util.HashMap<java.lang.String, com.oppo.camera.f.f.C0084f>) r1, (int) r3)     // Catch:{ CameraAccessException -> 0x02c3 }
            goto L_0x02e2
        L_0x02c3:
            r15 = move-exception
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r4)
            int r1 = r14.t
            r0.append(r1)
            r0.append(r2)
            java.lang.String r15 = r15.getMessage()
            r0.append(r15)
            java.lang.String r15 = r0.toString()
            com.oppo.camera.e.e(r5, r15)
        L_0x02e2:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.f.g.a(com.oppo.camera.f.d):android.hardware.camera2.CaptureRequest$Builder");
    }

    /* access modifiers changed from: private */
    public CaptureRequest.Builder a(TotalCaptureResult totalCaptureResult, d dVar) {
        CaptureRequest.Builder builder = null;
        try {
            builder = this.y.createReprocessCaptureRequest(totalCaptureResult);
            if (dVar == null) {
                builder.setTag(new d(d.a.CAPTURE_REPROCESS));
            } else {
                builder.setTag(dVar);
            }
            a(builder);
            if (b() || !CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SURPERNIGHT_REPROCESS_EXTRA_YUV)) {
                if (this.H.get("type_still_capture_yuv_main") != null) {
                    builder.addTarget(this.H.get("type_still_capture_yuv_main").a());
                }
                if (this.H.get("type_still_capture_yuv_sub") != null) {
                    builder.addTarget(this.H.get("type_still_capture_yuv_sub").a());
                }
                if (this.H.get("type_still_capture_yuv_third") != null) {
                    builder.addTarget(this.H.get("type_still_capture_yuv_third").a());
                }
            } else if (this.H.get("type_reprocess_data_yuv") != null) {
                byte b2 = 0;
                if (!(this.ap == null || this.ap.length <= 2 || this.ar == null)) {
                    if (this.ar[0] == 0) {
                        b2 = Byte.parseByte(this.ap[1]);
                    } else if (1 == this.ar[0]) {
                        b2 = Byte.parseByte(this.ap[0]);
                    } else if (2 == this.ar[0]) {
                        b2 = Byte.parseByte(this.ap[2]);
                    }
                }
                e.e("OneCameraImpl", "createReprocessCaptureRequest, set meta owner: " + b2);
                builder.set(c.aX, Byte.valueOf(b2));
                builder.addTarget(this.H.get("type_reprocess_data_yuv").a());
            }
            if (this.z != null) {
                this.z.a(dVar, builder, (HashMap<String, f.C0084f>) this.H, this.t);
            }
        } catch (CameraAccessException e) {
            e.a("OneCameraImpl", "createReprocessCaptureRequest, mCameraRole: " + this.t + ", e: " + e.getMessage());
        }
        return builder;
    }

    /* access modifiers changed from: private */
    public CaptureRequest.Builder U() {
        CaptureRequest.Builder createCaptureRequest;
        e.a("OneCameraImpl", "createRawCaptureBuilder, mCameraRole: " + this.t);
        CaptureRequest.Builder builder = null;
        if (this.y != null) {
            try {
                if (Util.p() && this.Q) {
                    createCaptureRequest = this.y.createCaptureRequest(5);
                } else if (a.g(Integer.parseInt(this.y.getId()))) {
                    createCaptureRequest = this.y.createCaptureRequest(2, this.af.ak);
                    try {
                        this.ae.al = ApsUtils.getCaptureRequestMetaDatas(createCaptureRequest);
                    } catch (CameraAccessException e) {
                        e = e;
                        builder = createCaptureRequest;
                    }
                } else {
                    createCaptureRequest = this.y.createCaptureRequest(2);
                }
                builder = createCaptureRequest;
                builder.setTag(this.ae);
                a(builder);
                if (!Util.p()) {
                    builder.set(CaptureRequest.CONTROL_ENABLE_ZSL, Boolean.valueOf(this.Q));
                }
                if (a.g(Integer.parseInt(this.y.getId()))) {
                    f.C0084f fVar = this.H.get("type_main_preview_frame");
                    f.C0084f fVar2 = this.H.get("type_sub_preview_frame");
                    f.C0084f fVar3 = this.H.get("type_third_preview_frame");
                    if (fVar != null && this.af.ak.contains(fVar.b())) {
                        builder.addTarget(fVar.a());
                    }
                    if (fVar2 != null && this.af.ak.contains(fVar2.b())) {
                        builder.addTarget(fVar2.a());
                    }
                    if (fVar3 != null && this.af.ak.contains(fVar3.b())) {
                        builder.addTarget(fVar3.a());
                    }
                } else if (this.H.get("type_main_preview_frame") != null) {
                    builder.addTarget(this.H.get("type_main_preview_frame").a());
                }
                if (this.H.get("type_still_capture_raw") != null) {
                    builder.addTarget(this.H.get("type_still_capture_raw").a());
                }
                if (!Util.p() && this.H.get("type_tuning_data_raw") != null) {
                    builder.addTarget(this.H.get("type_tuning_data_raw").a());
                }
                if (this.z != null) {
                    this.z.a(this.ae, builder, (HashMap<String, f.C0084f>) this.H, this.t);
                }
            } catch (CameraAccessException e2) {
                e = e2;
                e.e("OneCameraImpl", "createRawCaptureBuilder, mCameraRole: " + this.t + ", e: " + e.getMessage());
                return builder;
            }
        }
        return builder;
    }

    private void a(CaptureRequest.Builder builder) {
        synchronized (this.J) {
            StringBuilder sb = new StringBuilder();
            for (Map.Entry next : this.I.entrySet()) {
                ((a) next.getValue()).a(builder);
                sb.append(" key: " + next.getKey() + ", value: " + ((a) next.getValue()).c.toString());
            }
            e.a("OneCameraImpl", "addCacheToBuilder, mCameraRole: " + this.t + ", sb" + sb.toString());
        }
    }

    /* access modifiers changed from: private */
    public <T> void h(String str) {
        synchronized (this.J) {
            if (this.I != null && this.I.containsKey(str)) {
                this.I.remove(str);
            }
        }
    }

    public void z() {
        synchronized (this.J) {
            if (this.I != null) {
                this.I.clear();
            }
        }
    }

    private <T> void a(CaptureRequest.Key<T> key, final T t) {
        a(key, new l<T>() {
            public T a() {
                return t;
            }

            public String toString() {
                Object obj = t;
                if (obj == null) {
                    return null;
                }
                if ((obj instanceof int[]) && ((int[]) obj).length > 0) {
                    return String.valueOf(((int[]) obj)[0]);
                }
                Object obj2 = t;
                if (!(obj2 instanceof MeteringRectangle[]) || ((MeteringRectangle[]) obj2).length <= 0) {
                    return t.toString();
                }
                return ((MeteringRectangle[]) obj2)[0].toString();
            }
        });
    }

    private <T> void a(CaptureRequest.Key<T> key, l<T> lVar) {
        synchronized (this.J) {
            if (this.I != null) {
                this.I.put(key.getName(), new a(key, lVar));
            }
        }
    }

    /* access modifiers changed from: private */
    public <T> void a(String str, final T t) {
        a(str, new l<T>() {
            public T a() {
                return t;
            }

            public String toString() {
                Object obj = t;
                if (obj == null) {
                    return null;
                }
                if ((obj instanceof int[]) && ((int[]) obj).length > 0) {
                    return Arrays.toString((int[]) obj);
                }
                Object obj2 = t;
                if ((obj2 instanceof MeteringRectangle[]) && ((MeteringRectangle[]) obj2).length > 0) {
                    return ((MeteringRectangle[]) obj2)[0].toString();
                }
                Object obj3 = t;
                if ((obj3 instanceof k[]) && ((k[]) obj3).length > 0) {
                    return ((k[]) obj3)[0].toString();
                }
                Object obj4 = t;
                if (!(obj4 instanceof byte[]) || ((byte[]) obj4).length <= 0) {
                    return t.toString();
                }
                return Arrays.toString((byte[]) obj4);
            }
        });
    }

    private <T> void a(String str, l<T> lVar) {
        synchronized (this.J) {
            if (this.I != null) {
                this.I.put(str, new a(new CaptureRequest.Key(str, lVar.a().getClass()), lVar));
            }
        }
    }

    /* access modifiers changed from: private */
    public void V() {
        e.a("OneCameraImpl", "releaseResource, mCameraRole: " + this.t);
        e.a("releaseResource");
        this.B = null;
        LinkedHashMap<String, f.C0084f> linkedHashMap = this.H;
        if (linkedHashMap != null) {
            linkedHashMap.clear();
        }
        e.b("releaseResource");
    }

    public void r() {
        a(CaptureRequest.CONTROL_AWB_MODE, 1);
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_MMCAMERA_PROFESSIONAL)) {
            a("org.codeaurora.qcamera3.manualWB.partial_mwb_mode", new int[]{0});
        }
        a(this.B, this.av, 0);
    }

    public void k(int i) {
        if (Util.p()) {
            a(CaptureRequest.CONTROL_AWB_MODE, 0);
            if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_MMCAMERA_PROFESSIONAL)) {
                a("org.codeaurora.qcamera3.manualWB.partial_mwb_mode", new int[]{1});
                a("org.codeaurora.qcamera3.manualWB.color_temperature", new int[]{i});
            } else {
                a("com.qti.stats.awbwrapper.AWBCCT", new int[]{i});
            }
        } else {
            a(CaptureRequest.CONTROL_AWB_MODE, 10);
            a("com.oplus.manualWB.color_temperature", new int[]{i});
        }
        a(this.B, this.av, 0);
    }

    public void l(int i) {
        a("org.codeaurora.qcamera3.exposure_metering.exposure_metering_mode", new int[]{i});
    }

    private void W() {
        boolean z2 = !Util.p() ? !this.S || !this.T : !this.S && !this.T;
        if ("on".equals(this.N)) {
            a(CaptureRequest.CONTROL_AE_MODE, 3);
        } else if (MenuClickMsgData.VALUE_PROFESSION_AUTO.equals(this.N)) {
            a(CaptureRequest.CONTROL_AE_MODE, 2);
        } else if (z2) {
            a(CaptureRequest.CONTROL_AE_MODE, 0);
        } else if ("off".equals(this.N) || "torch".equals(this.N)) {
            a(CaptureRequest.CONTROL_AE_MODE, 1);
        }
    }

    public void m(int i) {
        if (i == -1) {
            this.S = true;
        } else {
            this.S = false;
            if (!CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_MMCAMERA_PROFESSIONAL)) {
                a(CaptureRequest.CONTROL_AE_MODE, 0);
            }
        }
        if (!this.S || !CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_MMCAMERA_PROFESSIONAL)) {
            if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_MMCAMERA_PROFESSIONAL)) {
                if (this.T) {
                    a(CaptureRequest.CONTROL_AE_MODE, 1);
                    a(c.i, new int[]{0});
                    this.ac = 0;
                } else {
                    a(CaptureRequest.CONTROL_AE_MODE, 0);
                    a(c.i, new int[]{2});
                }
                a(c.j, new long[]{(long) i});
            }
        } else if (this.T) {
            a(c.i, new int[]{this.ac});
            a(c.j, new long[]{0});
        }
        int u = e().u();
        e.b("OneCameraImpl", "setIso, mCameraRole: " + this.t + ", iso: " + i + ", maxISOValue: " + u);
        if (i > u) {
            a(CaptureRequest.CONTROL_POST_RAW_SENSITIVITY_BOOST, Integer.valueOf((int) ((((float) i) / ((float) u)) * 100.0f)));
            a(CaptureRequest.SENSOR_SENSITIVITY, Integer.valueOf(u));
        } else {
            a(CaptureRequest.SENSOR_SENSITIVITY, Integer.valueOf(i));
            a(CaptureRequest.CONTROL_POST_RAW_SENSITIVITY_BOOST, 100);
        }
        W();
        a(this.B, this.av, 0);
    }

    public void a(long j) {
        e.a("OneCameraImpl", "setExposureTime, mCameraRole: " + this.t + ", exposureTime: " + j);
        if (j == -1) {
            this.T = true;
        } else {
            this.T = false;
            if (!CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_MMCAMERA_PROFESSIONAL)) {
                a(CaptureRequest.CONTROL_AE_MODE, 0);
            }
        }
        if (!this.T || !CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_MMCAMERA_PROFESSIONAL)) {
            if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_MMCAMERA_PROFESSIONAL)) {
                if (this.S) {
                    a(CaptureRequest.CONTROL_AE_MODE, 1);
                    a(c.i, new int[]{1});
                    this.ac = 1;
                } else {
                    a(CaptureRequest.CONTROL_AE_MODE, 0);
                    a(c.i, new int[]{2});
                }
                a(c.j, new long[]{j});
                a(c.j, new long[]{j});
            }
        } else if (this.S) {
            a(c.i, new int[]{this.ac});
            a(c.j, new long[]{0});
        }
        W();
        a(CaptureRequest.SENSOR_EXPOSURE_TIME, Long.valueOf(j));
        a(this.B, this.av, 0);
    }

    public void s() {
        a(CaptureRequest.FLASH_MODE, 0);
    }

    public void t() {
        if (this.X == 0 && this.N.equals("on")) {
            a(CaptureRequest.FLASH_MODE, 1);
            a(CaptureRequest.CONTROL_AE_MODE, 3);
        } else if (this.X == 0 && this.N.equals(MenuClickMsgData.VALUE_PROFESSION_AUTO)) {
            a(CaptureRequest.FLASH_MODE, 1);
            a(CaptureRequest.CONTROL_AE_MODE, 2);
        }
        a(this.B, this.av, 0);
    }

    public void n(int i) {
        a("com.oplus.slogan.enable", new int[]{i});
    }

    public void o(int i) {
        e.b("OneCameraImpl", "setVideoSloganEnable, mCameraRole: " + this.t + ", enable: " + i);
        a("com.oplus.video.slogan.enable", new byte[]{(byte) i});
    }

    public void b(long j) {
        a(c.z, Long.valueOf(j));
    }

    public void p(int i) {
        e.b("OneCameraImpl", "setVideoSloganOrientation, mCameraRole: " + this.t + ", orientation: " + i);
        a("com.oplus.video.slogan.orientation", new int[]{i});
    }

    public void b(String str) {
        e.b("OneCameraImpl", "setVideoSloganPath, mCameraRole: " + this.t + ", videoSloganPath: " + str);
        a("com.oplus.video.slogan.path", str.getBytes());
    }

    public void f(String str) {
        if (this.af != null) {
            e.e("OneCameraImpl", "setCurrentSessionModeName, mCameraRole: " + this.t + ", modeName: " + str);
            this.af.u = str;
        }
    }

    public CameraCharacteristics e(String str) {
        CameraCharacteristics cameraCharacteristics;
        try {
            if ("type_still_capture_yuv_main".equals(str) && this.ap.length > 0) {
                cameraCharacteristics = this.x.getCameraCharacteristics(this.ap[0]);
            } else if ("type_still_capture_yuv_sub".equals(str) && this.ap.length > 1) {
                cameraCharacteristics = this.x.getCameraCharacteristics(this.ap[1]);
            } else if (!"type_still_capture_yuv_third".equals(str) || this.ap.length <= 2) {
                return null;
            } else {
                cameraCharacteristics = this.x.getCameraCharacteristics(this.ap[2]);
            }
            return cameraCharacteristics;
        } catch (CameraAccessException e) {
            e.e("OneCameraImpl", "getPhysicalCharacteristics, mCameraRole: " + this.t + ", e: " + e.getMessage());
            return null;
        }
    }

    public void d(boolean z2) {
        e.a("OneCameraImpl", "setMirror, mCameraRole: " + this.t + ", enable: " + z2);
        a(Util.p() ? "com.oplus.mirror.enable" : "com.mediatek.control.capture.flipmode", new int[]{z2});
    }

    public boolean c(String str) {
        e.a("OneCameraImpl", "isCloseStreamTaskFinished, mCameraRole: " + this.t + ", getSurfaceType: " + this.ai.c() + ", isFinished: " + this.ai.a() + ", isNeedWaitCloseStream: " + this.ai.b());
        return !str.equals(this.ai.c()) || this.ai.a() || !this.ai.b();
    }

    public void a(final String str, final boolean z2) {
        e.a("OneCameraImpl", "openStream, mCameraRole: " + this.t + ", type: " + str + ", needEndStream: " + z2);
        this.l.a((Runnable) new Runnable() {
            public void run() {
                e.a("OneCameraImpl", "openStream, mCameraRole: " + g.this.t + ", mPreviewBuilder: " + g.this.B + ", surface: " + g.this.H.get(str));
                boolean z = true;
                if (!(g.this.B == null || g.this.H.get(str) == null)) {
                    if ("type_video".equals(str) || "type_video_frame".equals(str)) {
                        g.this.am.close();
                    }
                    g.this.ai.a(false);
                    g.this.ai.b(z2);
                    g.this.ai.a(str);
                    g.this.ai.a(false, true);
                    g.this.B.addTarget(((f.C0084f) g.this.H.get(str)).a());
                    g gVar = g.this;
                    gVar.a(gVar.B, g.this.av, 0);
                }
                g gVar2 = g.this;
                if (!"type_video".equals(str) && !"type_video_frame".equals(str)) {
                    z = false;
                }
                boolean unused = gVar2.ah = z;
            }
        });
    }

    /* compiled from: OneCameraImpl */
    private class b implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        private String f3234b;
        private boolean c;
        private boolean d;
        private boolean e;
        private boolean f;

        private b() {
            this.f3234b = null;
            this.c = false;
            this.d = false;
            this.e = false;
            this.f = true;
        }

        public void a(boolean z, boolean z2) {
            this.e = z;
            this.f = z2;
        }

        public void a(boolean z) {
            e.a("OneCameraImpl", "setFinish, mCameraRole: " + g.this.t + ", finish: " + z);
            this.d = z;
        }

        public boolean a() {
            return this.d;
        }

        public boolean b() {
            return this.f;
        }

        public String c() {
            return this.f3234b;
        }

        public void a(String str) {
            this.f3234b = str;
        }

        public void b(boolean z) {
            this.c = z;
        }

        public void run() {
            e.a("OneCameraImpl", "CloseStreamTask, mCameraRole: " + g.this.t + ", mPreviewBuilder: " + g.this.B + ", mOutSurfaceMap: " + g.this.H.get(this.f3234b) + ", mSurfaceType: " + this.f3234b + ", mbWillCloseSession:" + this.e);
            if (!(g.this.B == null || g.this.H.get(this.f3234b) == null)) {
                if (this.c || this.e) {
                    g.this.X();
                }
                if (g.this.r == 5) {
                    e.a("OneCameraImpl", "CloseStreamTask, restart preview, mCameraRole: " + g.this.t);
                    g.this.a("org.quic.camera.recording.endOfStream", new byte[]{0});
                    if (!g.this.K) {
                        g.this.B.removeTarget(((f.C0084f) g.this.H.get(this.f3234b)).a());
                    }
                    if (!this.e) {
                        g.this.a((f.c) null);
                    }
                    g.this.h("org.quic.camera.recording.endOfStream");
                }
            }
            boolean unused = g.this.ah = false;
            a(true);
        }
    }

    public void h(boolean z2) {
        this.ai.a(true, z2);
    }

    public void d(String str) {
        e.a("OneCameraImpl", "closeStream, mCameraRole: " + this.t + ", type: " + str);
        if (this.r == 7 || this.r == 5) {
            this.l.post(this.ai);
        }
        this.am.open();
    }

    /* access modifiers changed from: private */
    public void X() {
        if (Util.p()) {
            e.b("OneCameraImpl", "endOfStream, mCameraRole: " + this.t);
            e.a("endOfStream");
            this.an.close();
            if (this.B != null) {
                g();
                a("org.quic.camera.recording.endOfStream", new byte[]{1});
                boolean b2 = b(this.B, new CameraCaptureSession.CaptureCallback() {
                    public void onCaptureFailed(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, CaptureFailure captureFailure) {
                        e.a("OneCameraImpl", "endOfStream, mCameraRole: " + g.this.t + ", onCaptureFailed, fail reason: " + captureFailure.getReason() + ", fail sequenceId: " + captureFailure.getSequenceId());
                        super.onCaptureFailed(cameraCaptureSession, captureRequest, captureFailure);
                        g.this.an.open();
                    }

                    public void onCaptureCompleted(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, TotalCaptureResult totalCaptureResult) {
                        e.a("OneCameraImpl", "endOfStream, mCameraRole: " + g.this.t + ", onCaptureCompleted, CaptureSession.close");
                        if (g.this.F != null) {
                            g.this.F.a(cameraCaptureSession, captureRequest, totalCaptureResult, g.this.t, -1);
                        }
                        super.onCaptureCompleted(cameraCaptureSession, captureRequest, totalCaptureResult);
                        g.this.an.open();
                    }

                    public void onCaptureSequenceAborted(CameraCaptureSession cameraCaptureSession, int i) {
                        e.a("OneCameraImpl", "endOfStream, onCaptureSequenceAborted, CaptureSession.close");
                        super.onCaptureSequenceAborted(cameraCaptureSession, i);
                        g.this.an.open();
                    }
                }, false);
                h("org.quic.camera.recording.endOfStream");
                if (!b2) {
                    this.an.open();
                }
            }
            this.an.block(2000);
            e.b("endOfStream");
        }
    }

    public void v(int i) {
        a("com.oplus.camera.3d.api.state", new int[]{i});
    }

    public void c(float f) {
        e.a("OneCameraImpl", "setBokehLevel, mCameraRole: " + this.t + ", level: " + f);
        a("com.oplus.bokeh.level", new float[]{f});
    }

    public void w(int i) {
        a("com.oplus.supernight.mode", new int[]{i});
    }

    public void y(int i) {
        a(Util.p() ? "com.oplus.rear.remosaic.enable" : "com.mediatek.control.capture.remosaicenable", new int[]{i});
    }

    public void z(int i) {
        a(c.aI, new int[]{i});
    }

    public void B(int i) {
        e.a("OneCameraImpl", "setApsFeatureType, mCameraRole: " + this.t + ", featureType: " + i);
        a(c.y, Integer.valueOf(i));
    }

    public void C(int i) {
        e.a("OneCameraImpl", "setBracketMode, mCameraRole: " + this.t + ", mode: " + i);
        a(c.aZ, Integer.valueOf(i));
    }

    public void D(int i) {
        e.b("OneCameraImpl", "updateAsdSceneValue, mCameraRole: " + this.t + ", value: " + i);
        a(c.bn, Integer.valueOf(i));
    }

    public void l(boolean z2) {
        e.a("OneCameraImpl", "setRearAicolorEnable, mCameraRole: " + this.t + ", enable: " + z2);
        a("com.oplus.aicolor.rear.enable", new int[]{z2});
    }

    public void m(boolean z2) {
        e.a("OneCameraImpl", "setMtkAIShutterEnable, mtkAIShutterEnable: " + z2);
        a("com.mediatek.3afeature.aishutCapture", new int[]{z2});
    }

    public void b(byte[] bArr) {
        e.a("OneCameraImpl", "setTuningDataEnable, mCameraRole: " + this.t + ", type: " + Arrays.toString(bArr));
        a(c.aE, bArr);
    }

    public int v() {
        return this.ab;
    }

    public void w() {
        this.ab = 0;
    }

    public void j(boolean z2) {
        if (z2) {
            a(c.al, new int[]{1});
            return;
        }
        h(c.al.getName());
    }

    public void n(boolean z2) {
        a(Util.p() ? "com.oplus.ultra.resolution.mode" : "com.oplus.ultra.high.resolution.enable", new int[]{z2});
    }

    private void Y() {
        if (this.z != null && this.r == 5 && this.B != null && a.g(Integer.parseInt(this.y.getId()))) {
            try {
                this.ao.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int a2 = this.z.a(this.y.getId());
            if (a2 != 0) {
                boolean z2 = false;
                boolean z3 = (a2 & 1) != 0;
                boolean z4 = (a2 & 2) != 0;
                if ((a2 & 4) != 0) {
                    z2 = true;
                }
                if (this.H.get("type_main_preview_frame") != null) {
                    this.B.removeTarget(this.H.get("type_main_preview_frame").a());
                }
                if (this.H.get("type_sub_preview_frame") != null) {
                    this.B.removeTarget(this.H.get("type_sub_preview_frame").a());
                }
                if (this.H.get("type_third_preview_frame") != null) {
                    this.B.removeTarget(this.H.get("type_third_preview_frame").a());
                }
                if (z3) {
                    this.B.addTarget(this.H.get("type_sub_preview_frame").a());
                }
                if (z4) {
                    this.B.addTarget(this.H.get("type_main_preview_frame").a());
                }
                if (z2) {
                    this.B.addTarget(this.H.get("type_third_preview_frame").a());
                }
            }
            this.ao.release();
        }
    }

    private CaptureRequest.Builder Z() throws CameraAccessException {
        if (!Util.p()) {
            return this.y.createCaptureRequest(2);
        }
        if (!this.Q || O() || this.ag) {
            if (a.g(Integer.parseInt(this.y.getId()))) {
                return this.y.createCaptureRequest(2, this.af.ak);
            }
            return this.y.createCaptureRequest(2);
        } else if (a.g(Integer.parseInt(this.y.getId()))) {
            return this.y.createCaptureRequest(5, this.af.ak);
        } else {
            return this.y.createCaptureRequest(5);
        }
    }

    private void a(CaptureRequest.Builder builder, int i) {
        if (a.g(Integer.parseInt(this.y.getId()))) {
            if (this.af.ak.contains(this.H.get("type_main_preview_frame").b())) {
                builder.addTarget(this.H.get("type_main_preview_frame").a());
            }
            if (this.af.ak.contains(this.H.get("type_sub_preview_frame").b())) {
                builder.addTarget(this.H.get("type_sub_preview_frame").a());
            }
            if (this.af.ak.contains(this.H.get("type_third_preview_frame").b())) {
                builder.addTarget(this.H.get("type_third_preview_frame").a());
                return;
            }
            return;
        }
        if (1 == i) {
            if (!this.ag && this.H.get("type_main_preview_frame") != null) {
                builder.addTarget(this.H.get("type_main_preview_frame").a());
            }
        } else if (2 == i && this.H.get("type_main_preview_frame") != null) {
            builder.addTarget(this.H.get("type_main_preview_frame").a());
        }
        if (this.H.get("type_sub_preview_frame") != null) {
            builder.addTarget(this.H.get("type_sub_preview_frame").a());
        }
    }

    public void a(boolean z2, String str) {
        if (!this.C.L()) {
            return;
        }
        if (z2) {
            a("com.mediatek.smvrfeature.smvrMode", this.C.a(str));
        } else {
            h("com.mediatek.smvrfeature.smvrMode");
        }
    }

    public void a(Range range) {
        if (range != null) {
            e.b("OneCameraImpl", "setVideoFpsRange: " + range.toString() + ", mCameraRole: " + this.t);
            if (this.C.L()) {
                this.B.set(CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE, range);
                a(this.B, this.av, 0);
            }
        }
    }

    public void E(int i) {
        a("com.oplus.picture.exif.flag", new int[]{i});
    }

    public void o(boolean z2) {
        if (!Util.p()) {
            e.a("OneCameraImpl", "setMsnr, mCameraRole: " + this.t + ", enable: " + z2);
            a("com.mediatek.control.capture.singleYuvNr.mode", new int[]{z2});
        }
    }

    public void x(boolean z2) {
        if (!Util.p()) {
            e.a("OneCameraImpl", "setMtkHighQualityYuv, enable: " + z2);
            a("com.mediatek.control.capture.highQualityYuv", new int[]{z2});
        }
    }

    public void y() {
        com.oppo.camera.f.a.a aVar = this.ay;
        if (aVar != null) {
            aVar.d();
        }
    }

    public void q(boolean z2) {
        a("com.oplus.zoom.active", new int[]{z2});
        a((f.c) null);
    }

    public void t(boolean z2) {
        a(c.x, Integer.valueOf(z2 ? 1 : 0));
    }

    public void r(boolean z2) {
        a("com.oplus.salient.object.detection.enable", new int[]{z2});
        a((f.c) null);
    }

    public void a(com.oppo.camera.u.d dVar) {
        this.as = dVar;
    }

    public void g(String str) {
        e.a("OneCameraImpl", "setOffsetTime, mCameraRole: " + this.t + ", offsetTime: " + str);
        a("com.oplus.picture.offset.time", str.getBytes());
    }

    public void a(byte[] bArr) {
        a(c.f3188a, bArr);
    }

    public void F(int i) {
        e.b("OneCameraImpl", "setNightIso, mCameraRole: " + this.t + ", iso: " + i);
        a("com.oplus.sensor.night.sensitivity", new int[]{i});
        a(this.B, this.av, 0);
    }

    public void c(long j) {
        e.a("OneCameraImpl", "setNightExposureTime, mCameraRole: " + this.t + ", exposureTime: " + j);
        a("com.oplus.sensor.night.exposureTime", new long[]{j});
        a(this.B, this.av, 0);
    }

    public void d(long j) {
        e.a("OneCameraImpl", "setHighPictureProExposureTime, mCameraRole: " + this.t + ", exposureTime: " + j);
        a("com.oplus.highpicture.professional.exposureTime", new long[]{j});
        a(this.B, this.av, 0);
    }

    public void G(int i) {
        a("com.oplus.highpicture.professional.enable", new int[]{i});
    }

    public void s(boolean z2) {
        e.a("OneCameraImpl", "setTrackEnable, mCameraRole: " + this.t + ", enable: " + z2);
        a("com.oplus.sod.enable", new byte[]{z2 ? (byte) 1 : 0});
    }

    public void b(int[] iArr) {
        e.a("OneCameraImpl", "trackTouchRegion, region: " + Arrays.toString(iArr));
        a("com.oplus.sod.touch.region", iArr);
    }

    public void u(boolean z2) {
        e.a("OneCameraImpl", "setPortraitNeon, enable: " + z2);
        a("com.oplus.portrait.neon", new int[]{z2});
    }

    public void v(boolean z2) {
        e.a("OneCameraImpl", "setVideoRetention, enable: " + z2);
        a("com.oplus.video.retention", new int[]{z2});
    }
}
