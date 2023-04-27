package com.oppo.camera.e;

import android.annotation.TargetApi;
import android.hardware.HardwareBuffer;
import android.media.AudioRecord;
import android.media.CamcorderProfile;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.os.Bundle;
import android.os.ConditionVariable;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.oppo.camera.aps.constant.ApsConstant;
import com.oppo.camera.e;
import com.oppo.camera.gl.m;
import com.oppo.camera.gl.q;
import com.oppo.camera.gl.x;
import com.oppo.camera.statistics.model.VideoRecordMsgData;
import com.oppo.camera.util.Util;
import com.sensetime.stmobile.sticker_module_types.STStickerBackgroungEdgeParamType;
import java.io.FileDescriptor;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: CameraMediaCodec */
public class c {
    private MediaCodec A;
    /* access modifiers changed from: private */
    public Surface B;
    private MediaFormat C;
    private MediaFormat D;
    private ByteBuffer[] E;
    /* access modifiers changed from: private */
    public AudioRecord F;
    /* access modifiers changed from: private */
    public d G;
    /* access modifiers changed from: private */
    public a H;
    private q I;
    private Handler J;
    private Handler K;
    /* access modifiers changed from: private */
    public Handler L;
    private Thread M;
    private ConditionVariable N;
    /* access modifiers changed from: private */
    public b O;
    /* access modifiers changed from: private */
    public CountDownLatch P;
    private float Q;
    private float R;
    /* access modifiers changed from: private */
    public int S;
    /* access modifiers changed from: private */
    public long T;
    /* access modifiers changed from: private */
    public long U;
    private boolean V;
    /* access modifiers changed from: private */
    public boolean W;
    /* access modifiers changed from: private */
    public boolean X;
    private boolean Y;
    private boolean Z;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final Object f2836a;
    /* access modifiers changed from: private */
    public boolean aa;
    private String ab;
    private String ac;
    private int ad;
    private String ae;
    private m<Surface> af;
    private x ag;
    private Handler ah;
    /* access modifiers changed from: private */
    public boolean ai;
    /* access modifiers changed from: private */
    public CopyOnWriteArrayList<C0081c> aj;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final Object f2837b;
    /* access modifiers changed from: private */
    public final Object c;
    private final Object d;
    private final AtomicBoolean e;
    /* access modifiers changed from: private */
    public ConditionVariable f;
    /* access modifiers changed from: private */
    public boolean g;
    /* access modifiers changed from: private */
    public volatile long h;
    /* access modifiers changed from: private */
    public boolean i;
    /* access modifiers changed from: private */
    public int j;
    private int k;
    private int l;
    private int m;
    private int n;
    private int o;
    /* access modifiers changed from: private */
    public long p;
    private long q;
    /* access modifiers changed from: private */
    public long r;
    /* access modifiers changed from: private */
    public long s;
    /* access modifiers changed from: private */
    public long t;
    /* access modifiers changed from: private */
    public long u;
    /* access modifiers changed from: private */
    public MediaMuxer v;
    /* access modifiers changed from: private */
    public int w;
    private String x;
    private FileDescriptor y;
    private MediaCodec z;

    /* renamed from: com.oppo.camera.e.c$c  reason: collision with other inner class name */
    /* compiled from: CameraMediaCodec */
    private class C0081c {

        /* renamed from: a  reason: collision with root package name */
        public boolean f2851a = false;

        /* renamed from: b  reason: collision with root package name */
        public int f2852b = -1;
        public ByteBuffer c = null;
        public MediaCodec.BufferInfo d = null;

        public C0081c(int i, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo, boolean z) {
            this.f2852b = i;
            this.c = byteBuffer;
            this.d = bufferInfo;
            this.f2851a = z;
        }
    }

    /* compiled from: CameraMediaCodec */
    private class b {

        /* renamed from: a  reason: collision with root package name */
        public int f2849a;

        /* renamed from: b  reason: collision with root package name */
        public int f2850b;
        public int c;
        public int d;
        public int e;
        public int f;
        public int g;
        public int h;
        public int i;
        public int j;
        public int k;
        public int l;

        private b() {
            this.f2849a = 0;
            this.f2850b = 0;
            this.c = 0;
            this.d = 0;
            this.e = 0;
            this.f = 0;
            this.g = 0;
            this.h = 0;
            this.i = 0;
            this.j = 0;
            this.k = 0;
            this.l = 0;
        }
    }

    public c() {
        this.f2836a = new Object();
        this.f2837b = new Object();
        this.c = new Object();
        this.d = new Object();
        this.e = new AtomicBoolean(false);
        this.f = new ConditionVariable();
        this.g = false;
        this.h = 0;
        this.i = true;
        this.j = -1;
        this.k = -1;
        this.l = 0;
        this.m = 0;
        this.n = 12;
        this.o = 28;
        this.p = 0;
        this.q = 0;
        this.r = 0;
        this.s = -1;
        this.t = -1;
        this.u = -1;
        this.v = null;
        this.w = 3;
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
        this.J = null;
        this.K = null;
        this.L = null;
        this.M = null;
        this.N = new ConditionVariable();
        this.O = new b();
        this.P = new CountDownLatch(2);
        this.Q = 0.0f;
        this.R = 0.0f;
        this.S = -1;
        this.T = -1;
        this.U = 0;
        this.V = true;
        this.W = false;
        this.X = false;
        this.Y = false;
        this.Z = false;
        this.aa = false;
        this.ab = ApsConstant.CAPTURE_MODE_PANORAMA;
        this.ac = "0";
        this.ad = 0;
        this.ae = "";
        this.af = null;
        this.ag = null;
        this.ah = null;
        this.ai = true;
        this.aj = new CopyOnWriteArrayList<>();
        this.H = new a(Looper.getMainLooper());
    }

    private void h() {
        if (this.J == null) {
            HandlerThread handlerThread = new HandlerThread("video codec thread");
            handlerThread.start();
            this.J = new Handler(handlerThread.getLooper());
        }
    }

    public void a(String str) {
        this.ab = str;
    }

    public void b(String str) {
        this.ae = str;
    }

    public void c(String str) {
        this.ac = str;
    }

    public void a(int i2) {
        this.ad = i2;
    }

    private void i() {
        Handler handler = this.J;
        if (handler != null) {
            handler.getLooper().quitSafely();
            this.J = null;
        }
    }

    private void j() {
        if (this.K == null) {
            HandlerThread handlerThread = new HandlerThread("audio codec thread");
            handlerThread.start();
            this.K = new Handler(handlerThread.getLooper());
        }
    }

    private void k() {
        if (this.g && this.L == null) {
            HandlerThread handlerThread = new HandlerThread("frame catch thread");
            handlerThread.start();
            this.L = new Handler(handlerThread.getLooper()) {
                public void handleMessage(Message message) {
                    if (message.what == 1) {
                        c.this.g();
                    }
                }
            };
        }
    }

    private void l() {
        Handler handler = this.K;
        if (handler != null) {
            handler.getLooper().quitSafely();
            this.K = null;
        }
    }

    private void m() {
        Handler handler = this.L;
        if (handler != null) {
            handler.getLooper().quitSafely();
            this.L = null;
        }
    }

    public void d(String str) {
        this.x = str;
    }

    public void a(CamcorderProfile camcorderProfile) {
        this.O.k = camcorderProfile.videoFrameRate;
        this.O.h = camcorderProfile.videoBitRate;
        this.O.i = camcorderProfile.videoCodec;
        this.O.f2849a = camcorderProfile.audioBitRate;
        this.O.f2850b = camcorderProfile.audioChannels;
        this.O.c = camcorderProfile.audioCodec;
        this.O.d = camcorderProfile.audioSampleRate;
        this.O.e = camcorderProfile.duration;
        this.O.f = camcorderProfile.fileFormat;
        this.O.g = camcorderProfile.quality;
        this.O.j = camcorderProfile.videoFrameWidth;
        this.O.l = camcorderProfile.videoFrameHeight;
    }

    public void a(q qVar) {
        this.I = qVar;
    }

    private MediaFormat n() {
        if (this.C == null) {
            this.C = MediaFormat.createVideoFormat(o(), this.O.l, this.O.j);
            this.C.setInteger("bitrate", this.O.h);
            this.C.setInteger("frame-rate", this.O.k);
            this.C.setInteger("color-format", 2130708361);
            this.C.setFloat("i-frame-interval", a());
        }
        return this.C;
    }

    public float a() {
        int i2 = this.S;
        if (-1 != i2) {
            return ((float) i2) / ((float) this.O.k);
        }
        return 1.0f;
    }

    public void b(int i2) {
        e.a("CameraMediaCodec", "setExtractFrameRate, extractFrameRate: " + i2);
        this.S = i2;
    }

    private String o() {
        b bVar = this.O;
        return (bVar == null || bVar.i != 5) ? "video/avc" : "video/hevc";
    }

    private MediaFormat p() {
        if (this.D == null) {
            if (Util.h("oplus.software.video.surround_record_support")) {
                if (VideoRecordMsgData.END_TYPE_NORMAL.equals(this.ab)) {
                    this.D = MediaFormat.createAudioFormat("audio/mp4a-latm", q(), this.O.f2850b == 0 ? r() : this.O.f2850b);
                    this.D.setInteger("bitrate", this.O.f2849a == 0 ? 128000 : this.O.f2849a);
                    this.D.setString("vendor.ozoaudio.device.value", "");
                    this.D.setString("vendor.ozoaudio.focus-mode.value", "off");
                } else if (ApsConstant.CAPTURE_MODE_PANORAMA.equals(this.ab)) {
                    this.D = MediaFormat.createAudioFormat("audio/ozoaudio", q(), r());
                    this.D.setInteger("bitrate", 256000);
                    this.D.setString("vendor.ozoaudio.device.value", this.ac);
                    this.D.setString("vendor.ozoaudio.focus-mode.value", "on");
                    this.D.setString("vendor.ozoaudio.mode", "ozoaudio");
                    this.D.setInteger("vendor.ozoaudio.sample-depth", 16);
                    this.D.setString("vendor.ozoaudio.focus-azimuth.value", "0.0");
                    this.D.setString("vendor.ozoaudio.focus-elevation.value", "0.0");
                    this.D.setString("vendor.ozoaudio.focus-sector-width.value", "100.0");
                    this.D.setString("vendor.ozoaudio.focus-sector-height.value", "100.0");
                } else if ("focusing".equals(this.ab)) {
                    this.D = MediaFormat.createAudioFormat("audio/ozoaudio", q(), r());
                    this.D.setInteger("bitrate", 256000);
                    this.D.setString("vendor.ozoaudio.device.value", this.ac);
                    this.D.setString("vendor.ozoaudio.focus-mode.value", "on");
                    this.D.setString("vendor.ozoaudio.mode", "ozoaudio");
                    this.D.setInteger("vendor.ozoaudio.sample-depth", 16);
                    this.D.setString("vendor.ozoaudio.focus-gain.value", String.valueOf(Util.k(this.ad)));
                    this.D.setString("vendor.ozoaudio.focus-azimuth.value", "0.0");
                    this.D.setString("vendor.ozoaudio.focus-elevation.value", "0.0");
                    this.D.setString("vendor.ozoaudio.focus-sector-width.value", "100.0");
                    this.D.setString("vendor.ozoaudio.focus-sector-height.value", "100.0");
                } else {
                    this.D = MediaFormat.createAudioFormat("audio/mp4a-latm", q(), this.O.f2850b == 0 ? r() : this.O.f2850b);
                    this.D.setInteger("bitrate", this.O.f2849a == 0 ? 128000 : this.O.f2849a);
                    this.D.setString("vendor.ozoaudio.device.value", "");
                    this.D.setString("vendor.ozoaudio.focus-mode.value", "off");
                }
                if (Util.q()) {
                    this.D.setString("vendor.ozoaudio.wnr-mode.value", this.ae);
                }
                this.D.setInteger("aac-profile", 2);
            } else {
                this.D = MediaFormat.createAudioFormat("audio/mp4a-latm", q(), this.O.f2850b == 0 ? r() : this.O.f2850b);
                this.D.setInteger("bitrate", this.O.f2849a == 0 ? 128000 : this.O.f2849a);
                this.D.setInteger("aac-profile", 2);
            }
        }
        return this.D;
    }

    private int q() {
        b bVar = this.O;
        if (bVar == null || bVar.d == 0) {
            return 48000;
        }
        return this.O.d;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0043, code lost:
        if (r0 != 48) goto L_0x0050;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int r() {
        /*
            r7 = this;
            java.lang.String r0 = "oplus.software.video.surround_record_support"
            boolean r0 = com.oppo.camera.util.Util.h((java.lang.String) r0)
            if (r0 == 0) goto L_0x0025
            java.lang.String r0 = r7.ab
            java.lang.String r1 = "panorama"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L_0x0017
            int r0 = r7.o
            r7.n = r0
            goto L_0x0025
        L_0x0017:
            java.lang.String r0 = r7.ab
            java.lang.String r1 = "focusing"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L_0x0025
            int r0 = r7.o
            r7.n = r0
        L_0x0025:
            int r0 = r7.n
            java.lang.String r1 = "CameraMediaCodec"
            r2 = -2
            r3 = 3
            r4 = 2
            r5 = 1
            if (r0 == 0) goto L_0x0050
            if (r0 == r5) goto L_0x004f
            if (r0 == r4) goto L_0x004f
            if (r0 == r3) goto L_0x004d
            r6 = 12
            if (r0 == r6) goto L_0x004d
            r6 = 16
            if (r0 == r6) goto L_0x004f
            r5 = 28
            if (r0 == r5) goto L_0x0046
            r3 = 48
            if (r0 == r3) goto L_0x004d
            goto L_0x0050
        L_0x0046:
            java.lang.String r0 = "getChannelCount, mChannelConfig: 28"
            com.oppo.camera.e.c(r1, r0)
            r2 = r3
            goto L_0x0050
        L_0x004d:
            r2 = r4
            goto L_0x0050
        L_0x004f:
            r2 = r5
        L_0x0050:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r3 = "getChannelCount, channelCount: "
            r0.append(r3)
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            com.oppo.camera.e.a(r1, r0)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.e.c.r():int");
    }

    public void a(long j2) {
        this.t = j2 * 1000;
    }

    public void b(long j2) {
        this.u = (long) (((float) j2) * 0.9f);
    }

    public void b() {
        e.a("CameraMediaCodec", "prepare");
        h();
        j();
        k();
        if (this.v == null) {
            try {
                if (this.y != null) {
                    this.v = new MediaMuxer(this.y, this.O.f);
                } else {
                    this.v = new MediaMuxer(this.x, this.O.f);
                }
                this.v.setOrientationHint(this.l);
                this.v.setLocation(this.Q, this.R);
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
    }

    public void c(int i2) {
        this.l = i2;
    }

    public boolean c() {
        e.a("CameraMediaCodec", "start");
        this.aj.clear();
        if (this.i) {
            this.i = Util.U();
        }
        this.J.post(new Runnable() {
            public void run() {
                try {
                    c.this.v();
                } finally {
                    c.this.P.countDown();
                    e.a("CameraMediaCodec", "start, initVideoCodec end");
                }
            }
        });
        this.K.post(new Runnable() {
            public void run() {
                try {
                    if (c.this.i) {
                        c.this.u();
                    }
                } finally {
                    c.this.P.countDown();
                    e.a("CameraMediaCodec", "start, initAudioCodec end");
                }
            }
        });
        try {
            this.P.await();
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        }
        this.X = false;
        this.Y = false;
        boolean z2 = true;
        m(1);
        if (this.i) {
            z2 = G();
        }
        this.V = z2;
        q qVar = this.I;
        if (qVar != null) {
            qVar.j();
        } else {
            e.e("CameraMediaCodec", "start, mGLSurfaceView is null");
        }
        return this.V;
    }

    public boolean d() {
        e.a("CameraMediaCodec", "stop, mRecorderState: " + this.w);
        if (this.w == 3) {
            return true;
        }
        this.N.close();
        m(3);
        synchronized (this.f2837b) {
            this.f2837b.notifyAll();
        }
        synchronized (this.f2836a) {
            this.f2836a.notifyAll();
        }
        q qVar = this.I;
        if (qVar != null) {
            qVar.i();
        } else {
            e.e("CameraMediaCodec", "stop, mGLSurfaceView is null");
        }
        this.q = 0;
        this.p = 0;
        B();
        z();
        if (this.i) {
            s();
            t();
        }
        x xVar = this.ag;
        if (xVar != null && !this.ai) {
            xVar.a();
        }
        Handler handler = this.ah;
        if (handler != null) {
            handler.getLooper().quitSafely();
            this.ah = null;
        }
        this.N.block();
        return this.V;
    }

    private void s() {
        e.a("CameraMediaCodec", "stopAudioInput");
        AudioRecord audioRecord = this.F;
        if (audioRecord != null) {
            audioRecord.stop();
            this.F.release();
        }
    }

    private void t() {
        e.a("CameraMediaCodec", "stopAudioEncode, mAudioCodec: " + this.A + ", mbAudioCodecOutputDataCome: " + this.Y);
        if (this.Y) {
            MediaCodec mediaCodec = this.A;
            if (mediaCodec != null) {
                this.A.queueInputBuffer(mediaCodec.dequeueInputBuffer(-1), 0, 0, 0, 4);
                return;
            }
            return;
        }
        A();
        D();
    }

    public void e() {
        e.a("CameraMediaCodec", "pause");
        this.p = System.nanoTime();
        m(2);
        this.q = 0;
        q qVar = this.I;
        if (qVar != null) {
            qVar.i();
        } else {
            e.e("CameraMediaCodec", "pause, mGLSurfaceView is null");
        }
    }

    public void f() {
        this.q = System.nanoTime();
        this.r += this.q - this.p;
        e.a("CameraMediaCodec", "resume, mPausedTime: " + this.r);
        m(1);
        synchronized (this.f2837b) {
            this.f2837b.notifyAll();
        }
        q qVar = this.I;
        if (qVar != null) {
            qVar.j();
        } else {
            e.e("CameraMediaCodec", "resume, mGLSurfaceView is null");
        }
    }

    /* access modifiers changed from: private */
    public void u() {
        e.a("CameraMediaCodec", "initAudioCodec, mAudioType: " + this.ab);
        try {
            if (!Util.h("oplus.software.video.surround_record_support")) {
                this.A = MediaCodec.createEncoderByType("audio/mp4a-latm");
            } else if (VideoRecordMsgData.END_TYPE_NORMAL.equals(this.ab)) {
                this.A = MediaCodec.createEncoderByType("audio/mp4a-latm");
            } else if (ApsConstant.CAPTURE_MODE_PANORAMA.equals(this.ab)) {
                this.A = MediaCodec.createEncoderByType("audio/ozoaudio");
            } else if ("focusing".equals(this.ab)) {
                this.A = MediaCodec.createEncoderByType("audio/ozoaudio");
            } else {
                this.A = MediaCodec.createEncoderByType("audio/mp4a-latm");
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.A.configure(p(), (Surface) null, (MediaCrypto) null, 1);
        this.A.start();
        this.E = this.A.getInputBuffers();
        this.K.post(new Runnable() {
            public void run() {
                e.a("CameraMediaCodec", "initAudioCodec, AudioEncode run");
                c.this.y();
            }
        });
        e.a("CameraMediaCodec", "initAudioCodec, mInputByteBuffer.length: " + this.E.length);
    }

    /* access modifiers changed from: private */
    @TargetApi(23)
    public void v() {
        e.a("CameraMediaCodec", "initVideoCodec");
        try {
            this.z = MediaCodec.createEncoderByType(o());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.z.setCallback(new MediaCodec.Callback() {
            public void onInputBufferAvailable(MediaCodec mediaCodec, int i) {
                e.a("CameraMediaCodec", "onInputBufferAvailable");
            }

            public void onOutputBufferAvailable(MediaCodec mediaCodec, int i, MediaCodec.BufferInfo bufferInfo) {
                MediaCodec mediaCodec2 = mediaCodec;
                int i2 = i;
                MediaCodec.BufferInfo bufferInfo2 = bufferInfo;
                e.a("CameraMediaCodec", "onOutputBufferAvailable");
                if (c.this.j < 0) {
                    e.a("CameraMediaCodec", "onOutputBufferAvailable invalid video track:" + c.this.j);
                    return;
                }
                ByteBuffer outputBuffer = mediaCodec.getOutputBuffer(i);
                if (bufferInfo2.flags == 4) {
                    e.a("CameraMediaCodec", "onOutputBufferAvailable, Video encode Stopped");
                    if (c.this.g) {
                        CopyOnWriteArrayList h = c.this.aj;
                        c cVar = c.this;
                        h.add(new C0081c(cVar.j, (ByteBuffer) null, bufferInfo, false));
                        c.this.L.sendEmptyMessage(1);
                        mediaCodec2.releaseOutputBuffer(i2, false);
                        return;
                    }
                    c.this.w();
                    c.this.D();
                    if (c.this.B != null) {
                        c.this.B.release();
                    }
                } else if (bufferInfo2.flags == 2) {
                    e.a("CameraMediaCodec", "onOutputBufferAvailable, BUFFER_FLAG_CODEC_CONFIG");
                } else {
                    if (bufferInfo2.flags == 1) {
                        e.a("CameraMediaCodec", "onOutputBufferAvailable, BUFFER_FLAG_SYNC_FRAME");
                    }
                    if (!c.this.W) {
                        e.b("CameraMediaCodec", "onOutputBufferAvailable, mbMuxerStarted: " + c.this.W);
                        return;
                    }
                    if (0 < c.this.r) {
                        bufferInfo2.presentationTimeUs -= c.this.r / 1000;
                    }
                    if (c.this.aa) {
                        bufferInfo2.presentationTimeUs = c.this.a(bufferInfo2);
                        if (bufferInfo2.presentationTimeUs <= 0) {
                            e.b("CameraMediaCodec", "onOutputBufferAvailable, skip, info.presentationTime: " + bufferInfo2.presentationTimeUs);
                            mediaCodec2.releaseOutputBuffer(i2, false);
                            return;
                        }
                    }
                    if (c.this.s < 0) {
                        long unused = c.this.s = bufferInfo2.presentationTimeUs;
                    }
                    if (-1 != c.this.S) {
                        if (!((bufferInfo2.flags & 1) != 0)) {
                            e.b("CameraMediaCodec", "onOutputBufferAvailable, skip Frame");
                            mediaCodec2.releaseOutputBuffer(i2, false);
                            return;
                        }
                        if (c.this.T < 0) {
                            long unused2 = c.this.T = bufferInfo2.presentationTimeUs;
                        } else {
                            c cVar2 = c.this;
                            long unused3 = cVar2.T = cVar2.T + ((long) ((int) (1000000.0f / ((float) c.this.O.k))));
                        }
                        bufferInfo2.presentationTimeUs = c.this.T;
                    }
                    e.a("CameraMediaCodec", "onOutputBufferAvailable, writeSampleData, info.presentationTimeUs: " + bufferInfo2.presentationTimeUs + ", mbVideoCodecSpecialEffect: " + c.this.ai);
                    if (c.this.g) {
                        ByteBuffer allocate = ByteBuffer.allocate(outputBuffer.capacity());
                        allocate.put(outputBuffer);
                        CopyOnWriteArrayList h2 = c.this.aj;
                        c cVar3 = c.this;
                        C0081c cVar4 = r3;
                        C0081c cVar5 = new C0081c(cVar3.j, allocate, bufferInfo, false);
                        h2.add(cVar4);
                        c.this.L.sendEmptyMessage(1);
                    } else {
                        c cVar6 = c.this;
                        cVar6.a(cVar6.j, outputBuffer, bufferInfo2);
                    }
                    synchronized (c.this.c) {
                        long unused4 = c.this.U = c.this.U + ((long) bufferInfo2.size);
                    }
                    if (c.this.t > 0 && bufferInfo2.presentationTimeUs - c.this.s >= c.this.t) {
                        e.e("CameraMediaCodec", "onOutputBufferAvailable, reach to max duration time");
                        c.this.H.sendMessage(c.this.H.obtainMessage(1, 800, -1));
                        long unused5 = c.this.t = -1;
                    } else if (c.this.u > 0 && c.this.U >= c.this.u) {
                        e.e("CameraMediaCodec", "onOutputBufferAvailable, reach to max file size");
                        c.this.H.sendMessage(c.this.H.obtainMessage(1, STStickerBackgroungEdgeParamType.ST_STICKER_PARAM_BACKGROUND_EDGE_UINT_COLOR, -1));
                        long unused6 = c.this.u = -1;
                    }
                    if (c.this.w == 2) {
                        long unused7 = c.this.p = System.nanoTime();
                    }
                    mediaCodec2.releaseOutputBuffer(i2, false);
                    boolean unused8 = c.this.X = true;
                }
            }

            public void onError(MediaCodec mediaCodec, MediaCodec.CodecException codecException) {
                e.e("CameraMediaCodec", "onError, diagnostic Info: " + codecException.getDiagnosticInfo());
                c.this.H.sendMessage(c.this.H.obtainMessage(2, codecException.getErrorCode(), -1));
            }

            public void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) {
                e.a("CameraMediaCodec", "onOutputFormatChanged");
                synchronized (c.this.f2836a) {
                    if (c.this.j < 0 && c.this.v != null) {
                        mediaFormat.setInteger("support64BitFileSize", 1);
                        int unused = c.this.j = c.this.v.addTrack(mediaFormat);
                        c.this.C();
                        e.e("CameraMediaCodec", "onOutputFormatChanged, addTrack mVideoTrack, format: " + mediaFormat);
                    }
                }
            }
        }, this.J);
        this.z.configure(n(), (Surface) null, (MediaCrypto) null, 1);
        this.B = this.z.createInputSurface();
        if (this.ai) {
            this.I.setOutput(this.B);
        } else {
            if (this.ah == null) {
                HandlerThread handlerThread = new HandlerThread("VideoCodecInputThread");
                handlerThread.start();
                this.ah = new Handler(handlerThread.getLooper()) {
                    public void handleMessage(Message message) {
                        if (message.what == 1) {
                            c.this.b((HardwareBuffer) message.obj);
                            message.obj = null;
                        }
                    }
                };
            }
            this.af = new m<>(this.B);
            this.af.a(2);
            this.af.a(8, 8, 8, 8, 0, 0);
            this.ag = new x();
            this.Z = false;
        }
        this.z.start();
        this.e.set(true);
    }

    /* access modifiers changed from: private */
    public long a(MediaCodec.BufferInfo bufferInfo) {
        d dVar = this.G;
        if (dVar != null) {
            return dVar.a(bufferInfo);
        }
        return -1;
    }

    public void a(boolean z2) {
        e.a("CameraMediaCodec", "updateSavePatch, mbSaveInSDCard:" + this.g);
        this.g = z2;
    }

    /* access modifiers changed from: private */
    public void w() {
        e.a("CameraMediaCodec", "releaseVideoCodec");
        try {
            if (this.z != null) {
                this.z.stop();
                this.z.release();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        } catch (Throwable th) {
            this.j = -1;
            throw th;
        }
        this.j = -1;
        e.a("CameraMediaCodec", "releaseVideoCodec, end");
    }

    private void x() {
        this.af.a((m.C0085m) this.ag);
        this.af.b(0);
        this.af.a((SurfaceHolder) null);
        this.af.a((SurfaceHolder) null, 0, this.O.l, this.O.j);
    }

    /* access modifiers changed from: private */
    public void b(HardwareBuffer hardwareBuffer) {
        if (this.z == null) {
            hardwareBuffer.close();
            return;
        }
        this.ag.a(hardwareBuffer);
        if (!this.Z) {
            this.Z = true;
            x();
        }
        this.af.d();
    }

    public void a(HardwareBuffer hardwareBuffer) {
        if (!this.e.get()) {
            hardwareBuffer.close();
        } else if (this.ah == null) {
            hardwareBuffer.close();
        } else if (Looper.myLooper() != this.ah.getLooper()) {
            Message obtainMessage = this.ah.obtainMessage(1);
            obtainMessage.obj = hardwareBuffer;
            this.ah.sendMessage(obtainMessage);
        } else {
            hardwareBuffer.close();
        }
    }

    /* access modifiers changed from: private */
    public void a(byte[] bArr, int i2, int i3) {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("addAudioFrame, mAudioCodec: ");
        sb.append(this.A);
        sb.append(", mRecorderState: ");
        sb.append(this.w);
        sb.append(", audioData: ");
        if (bArr == null || 1 > bArr.length) {
            str = "empty";
        } else {
            str = "first : " + bArr[0];
        }
        sb.append(str);
        e.a("CameraMediaCodec", sb.toString());
        if (this.A != null) {
            int i4 = -1;
            while (true) {
                if (i4 >= 0) {
                    break;
                }
                i4 = this.A.dequeueInputBuffer(5000);
                e.a("CameraMediaCodec", "addAudioFrame, outputBufferIndex: " + i4);
                if (i4 < 0 && this.w != 1) {
                    e.e("CameraMediaCodec", "addAudioFrame break, mRecorderState: " + this.w);
                    break;
                }
            }
            int i5 = i4;
            if (bArr != null && i5 >= 0) {
                this.E[i5].position(0);
                this.E[i5].put(bArr, i2, i3);
                this.A.queueInputBuffer(i5, 0, i3, System.nanoTime() / 1000, 0);
            }
        }
    }

    /* access modifiers changed from: private */
    public void y() {
        e.a("CameraMediaCodec", "audioEncoder, start");
        ByteBuffer[] outputBuffers = this.A.getOutputBuffers();
        while (true) {
            try {
                MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
                int dequeueOutputBuffer = this.A.dequeueOutputBuffer(bufferInfo, -1);
                if (dequeueOutputBuffer == -3) {
                    outputBuffers = this.A.getOutputBuffers();
                } else if (dequeueOutputBuffer == -2) {
                    synchronized (this.f2836a) {
                        if (this.k < 0) {
                            e.a("CameraMediaCodec", "audioEncoder, addTrack mAudioTrack");
                            this.k = this.v.addTrack(this.A.getOutputFormat());
                            C();
                        }
                    }
                } else if (dequeueOutputBuffer == -1) {
                    e.e("CameraMediaCodec", "audioEncoder, Audio INFO_TRY_AGAIN_LATER");
                } else if (bufferInfo.flags == 4) {
                    e.a("CameraMediaCodec", "audioEncoder, Audio BUFFER_FLAG_END_OF_STREAM");
                    if (this.g) {
                        this.aj.add(new C0081c(this.k, (ByteBuffer) null, bufferInfo, true));
                        this.L.sendEmptyMessage(1);
                    } else {
                        A();
                        D();
                    }
                } else if (bufferInfo.flags == 2) {
                    e.a("CameraMediaCodec", "audioEncoder, Audio BUFFER_FLAG_CODEC_CONFIG");
                } else if (bufferInfo.flags == 1) {
                    e.a("CameraMediaCodec", "audioEncoder, Audio BUFFER_FLAG_SYNC_FRAME");
                } else if (!this.W) {
                    e.b("CameraMediaCodec", "audioEncoder, mbMuxerStarted: " + this.W);
                } else {
                    bufferInfo.presentationTimeUs = (System.nanoTime() - this.r) / 1000;
                    if (this.s < 0) {
                        this.s = bufferInfo.presentationTimeUs;
                    }
                    e.a("CameraMediaCodec", "audioEncoder, audio bufferInfo.presentationTimeUs: " + bufferInfo.presentationTimeUs);
                    if (this.g) {
                        ByteBuffer allocate = ByteBuffer.allocate(outputBuffers[dequeueOutputBuffer].capacity());
                        allocate.put(outputBuffers[dequeueOutputBuffer]);
                        CopyOnWriteArrayList<C0081c> copyOnWriteArrayList = this.aj;
                        C0081c cVar = r1;
                        C0081c cVar2 = new C0081c(this.k, allocate, bufferInfo, true);
                        copyOnWriteArrayList.add(cVar);
                        this.L.sendEmptyMessage(1);
                    } else {
                        a(this.k, outputBuffers[dequeueOutputBuffer], bufferInfo);
                    }
                    synchronized (this.c) {
                        this.U += (long) bufferInfo.size;
                    }
                    this.A.releaseOutputBuffer(dequeueOutputBuffer, false);
                    if (this.t > 0 && bufferInfo.presentationTimeUs - this.s >= this.t) {
                        e.e("CameraMediaCodec", "audioEncoder, reach to max duration time");
                        this.H.sendMessage(this.H.obtainMessage(1, 800, -1));
                        this.t = -1;
                    } else if (this.u > 0 && this.U >= this.u) {
                        e.a("CameraMediaCodec", "audioEncoder, reach to max file size");
                        this.H.sendMessage(this.H.obtainMessage(1, STStickerBackgroungEdgeParamType.ST_STICKER_PARAM_BACKGROUND_EDGE_UINT_COLOR, -1));
                        this.u = -1;
                    }
                    if (this.w == 2) {
                        this.p = System.nanoTime();
                    }
                    this.Y = true;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                Message obtainMessage = this.H.obtainMessage(3, 1);
                this.H.removeMessages(3);
                this.H.sendMessage(obtainMessage);
            }
        }
        e.a("CameraMediaCodec", "audioEncoder, release audio codec");
    }

    private void z() {
        try {
            if (this.M != null && this.M.isAlive()) {
                e.a("CameraMediaCodec", "releaseAudioCodec, audio input thread not end and we wait it here");
                this.M.join();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        } catch (Throwable th) {
            this.M = null;
            throw th;
        }
        this.M = null;
    }

    private void A() {
        e.a("CameraMediaCodec", "releaseAudioCodec");
        z();
        synchronized (this.d) {
            try {
                e.a("CameraMediaCodec", "releaseAudioCodec, mAudioCodec: " + this.A);
                if (this.A != null) {
                    this.A.stop();
                    this.A.release();
                }
                this.k = -1;
            } catch (Exception e2) {
                try {
                    e2.printStackTrace();
                    this.k = -1;
                } catch (Throwable th) {
                    this.k = -1;
                    this.A = null;
                    throw th;
                }
            }
            this.A = null;
        }
        e.a("CameraMediaCodec", "releaseAudioCodec, end");
    }

    private void B() {
        e.a("CameraMediaCodec", "stopVideoEncode, mbVideoCodecOutputDataCome: " + this.X);
        q qVar = this.I;
        if (qVar != null) {
            qVar.h();
        }
        if (this.X) {
            MediaCodec mediaCodec = this.z;
            if (mediaCodec != null) {
                mediaCodec.signalEndOfInputStream();
                return;
            }
            return;
        }
        Handler handler = this.J;
        if (handler != null) {
            handler.post(new Runnable() {
                public void run() {
                    c.this.w();
                    c.this.D();
                    if (c.this.B != null) {
                        c.this.B.release();
                    }
                }
            });
        }
    }

    private void m(int i2) {
        e.a("CameraMediaCodec", "setRecordState, mRecorderState: " + this.w + " => " + i2);
        this.w = i2;
    }

    public void d(int i2) {
        this.O.h = i2;
    }

    public void e(int i2) {
        this.O.k = i2;
    }

    public void f(int i2) {
        this.O.f = i2;
    }

    public void a(float f2, float f3) {
        this.Q = f2;
        this.R = f3;
    }

    public void a(FileDescriptor fileDescriptor) {
        this.y = fileDescriptor;
    }

    public void a(int i2, int i3) {
        b bVar = this.O;
        bVar.l = i3;
        bVar.j = i2;
    }

    public void g(int i2) {
        this.O.i = i2;
    }

    public void h(int i2) {
        this.O.f2849a = i2;
    }

    public void i(int i2) {
        this.O.f2850b = i2;
    }

    public void j(int i2) {
        this.O.d = i2;
    }

    public void k(int i2) {
        this.O.c = i2;
    }

    public void b(boolean z2) {
        e.a("CameraMediaCodec", "setAudioEnable, enable: " + z2);
        this.i = z2;
    }

    /* access modifiers changed from: private */
    public void C() {
        e.a("CameraMediaCodec", "startMediaMuxer, mVideoTrack: " + this.j + ", mAudioTrack: " + this.k);
        if (this.i) {
            synchronized (this.f2836a) {
                if (this.j < 0 || this.k < 0) {
                    try {
                        if (this.j < 0 || this.k < 0) {
                            this.f2836a.wait();
                        }
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                    }
                } else {
                    if (!this.W) {
                        this.v.start();
                        this.W = true;
                    }
                    this.f2836a.notifyAll();
                }
            }
        } else if (!this.W) {
            this.v.start();
            this.W = true;
        }
    }

    /* access modifiers changed from: private */
    public void D() {
        ConditionVariable conditionVariable;
        e.a("CameraMediaCodec", "stopMediaMuxer, mbScopeEnableAudio: " + this.i + ", mAudioTrack: " + this.k + ", mVideoTrack: " + this.j);
        if (this.i) {
            synchronized (this.f2836a) {
                if (this.k >= 0 || this.j >= 0) {
                    try {
                        if (this.k >= 0 || this.j >= 0) {
                            this.f2836a.wait();
                        }
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                    }
                } else {
                    try {
                        if (this.v != null) {
                            this.v.stop();
                            this.v.release();
                        }
                        this.W = false;
                        this.v = null;
                        this.f2836a.notifyAll();
                        i();
                        l();
                        m();
                        conditionVariable = this.N;
                    } catch (IllegalStateException e3) {
                        try {
                            e3.printStackTrace();
                            this.W = false;
                            this.v = null;
                            this.f2836a.notifyAll();
                            i();
                            l();
                            m();
                            conditionVariable = this.N;
                        } catch (Throwable th) {
                            this.W = false;
                            this.v = null;
                            this.f2836a.notifyAll();
                            i();
                            l();
                            m();
                            this.N.open();
                            throw th;
                        }
                    }
                    conditionVariable.open();
                }
            }
            return;
        }
        try {
            if (this.v != null) {
                this.v.stop();
                this.v.release();
            }
        } catch (IllegalStateException e4) {
            e4.printStackTrace();
        } catch (Throwable th2) {
            this.W = false;
            this.v = null;
            i();
            l();
            m();
            this.N.open();
            throw th2;
        }
        this.W = false;
        this.v = null;
        i();
        l();
        m();
        this.N.open();
    }

    /* access modifiers changed from: private */
    public void a(int i2, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        e.a("CameraMediaCodec", "writeSampleData");
        MediaMuxer mediaMuxer = this.v;
        if (mediaMuxer != null) {
            mediaMuxer.writeSampleData(i2, byteBuffer, bufferInfo);
        }
    }

    /* access modifiers changed from: private */
    public int E() {
        if (this.m == 0) {
            this.m = AudioRecord.getMinBufferSize(q(), 12, 2);
            if (this.E[0].capacity() < this.m) {
                this.m = this.E[0].capacity();
            }
        }
        return this.m;
    }

    private void F() {
        if (this.F != null) {
            return;
        }
        if (!Util.h("oplus.software.video.surround_record_support")) {
            this.F = new AudioRecord(5, q(), 12, 2, E());
        } else if (VideoRecordMsgData.END_TYPE_NORMAL.equals(this.ab)) {
            this.F = new AudioRecord(5, q(), 12, 2, E());
        } else if (ApsConstant.CAPTURE_MODE_PANORAMA.equals(this.ab)) {
            this.F = new AudioRecord(5, q(), 28, 2, E());
        } else if ("focusing".equals(this.ab)) {
            this.F = new AudioRecord(5, q(), 28, 2, E());
        } else {
            e.e("CameraMediaCodec", " mAudioType: " + this.ab + " is wrong");
        }
    }

    private boolean G() {
        boolean z2;
        e.a("CameraMediaCodec", "startAudioInput");
        if (this.F == null) {
            F();
        }
        AudioRecord audioRecord = this.F;
        if (audioRecord != null) {
            audioRecord.startRecording();
            if (this.F.getRecordingState() != 3) {
                e.e("CameraMediaCodec", "startAudioInput, mAudioRecord may be conflict or have some other exception");
                z2 = false;
                final byte[] bArr = new byte[E()];
                this.h = System.currentTimeMillis();
                this.M = new Thread("audio input thread") {
                    public void run() {
                        while (true) {
                            if (c.this.w == 1) {
                                int read = c.this.F.read(bArr, 0, c.this.E());
                                long currentTimeMillis = System.currentTimeMillis();
                                if (read > 0) {
                                    if (500 < currentTimeMillis - c.this.h) {
                                        c.this.a(bArr, 0, read);
                                    } else {
                                        byte[] bArr = new byte[read];
                                        Arrays.fill(bArr, (byte) 0);
                                        c.this.a(bArr, 0, read);
                                        e.e("CameraMediaCodec", "startAudioInput, send empty");
                                    }
                                }
                            } else if (c.this.w == 3) {
                                e.e("CameraMediaCodec", "startAudioInput, AudioInput stop");
                                return;
                            } else if (c.this.w == 2) {
                                e.e("CameraMediaCodec", "startAudioInput, AudioInput pause");
                                synchronized (c.this.f2837b) {
                                    try {
                                        if (c.this.w == 2) {
                                            c.this.f2837b.wait();
                                        }
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                }
                            } else {
                                continue;
                            }
                        }
                    }
                };
                this.M.start();
                return z2;
            }
        }
        z2 = true;
        final byte[] bArr2 = new byte[E()];
        this.h = System.currentTimeMillis();
        this.M = new Thread("audio input thread") {
            public void run() {
                while (true) {
                    if (c.this.w == 1) {
                        int read = c.this.F.read(bArr2, 0, c.this.E());
                        long currentTimeMillis = System.currentTimeMillis();
                        if (read > 0) {
                            if (500 < currentTimeMillis - c.this.h) {
                                c.this.a(bArr2, 0, read);
                            } else {
                                byte[] bArr = new byte[read];
                                Arrays.fill(bArr, (byte) 0);
                                c.this.a(bArr, 0, read);
                                e.e("CameraMediaCodec", "startAudioInput, send empty");
                            }
                        }
                    } else if (c.this.w == 3) {
                        e.e("CameraMediaCodec", "startAudioInput, AudioInput stop");
                        return;
                    } else if (c.this.w == 2) {
                        e.e("CameraMediaCodec", "startAudioInput, AudioInput pause");
                        synchronized (c.this.f2837b) {
                            try {
                                if (c.this.w == 2) {
                                    c.this.f2837b.wait();
                                }
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    } else {
                        continue;
                    }
                }
            }
        };
        this.M.start();
        return z2;
    }

    public void l(int i2) {
        Bundle bundle = new Bundle();
        bundle.putString("vendor.ozoaudio.focus-gain.value", String.valueOf(Util.k(i2)));
        synchronized (this.d) {
            if (this.A != null) {
                this.A.setParameters(bundle);
            }
        }
    }

    public void a(d dVar) {
        this.G = dVar;
    }

    public void c(boolean z2) {
        this.ai = z2;
    }

    public void d(boolean z2) {
        this.aa = z2;
    }

    /* compiled from: CameraMediaCodec */
    private class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            int i = message.what;
            if (i != 1) {
                if (i != 2) {
                    if (i == 3 && c.this.G != null) {
                        c.this.G.a(((Integer) message.obj).intValue());
                    }
                } else if (c.this.G != null) {
                    c.this.G.b(c.this, message.arg1, message.arg2);
                }
            } else if (c.this.G != null) {
                c.this.G.a(c.this, message.arg1, message.arg2);
            }
        }
    }

    public void g() {
        while (!this.aj.isEmpty()) {
            try {
                C0081c remove = this.aj.remove(0);
                if (remove.d.flags == 4) {
                    if (remove.f2851a) {
                        A();
                    } else if (this.J != null) {
                        this.f.close();
                        this.J.post(new Runnable() {
                            public void run() {
                                try {
                                    c.this.w();
                                } finally {
                                    c.this.f.open();
                                }
                            }
                        });
                        this.f.block();
                    }
                    if (this.k < 0 && this.j < 0) {
                        D();
                        if (this.B != null) {
                            this.B.release();
                        }
                    }
                } else {
                    a(remove.f2852b, remove.c, remove.d);
                    remove.c.clear();
                    remove.c = null;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                Message obtainMessage = this.H.obtainMessage(3, 1);
                this.H.removeMessages(3);
                this.H.sendMessage(obtainMessage);
                return;
            }
        }
    }
}
