package com.oppo.camera.ui.preview.a.a;

import android.graphics.SurfaceTexture;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.media.MediaMetadataRetriever;
import android.os.ConditionVariable;
import android.view.Surface;
import com.oppo.camera.aps.config.AlgoSwitchConfig;
import com.oppo.camera.doubleexposure.b;
import com.oppo.camera.e;
import java.io.IOException;
import java.nio.ByteBuffer;

/* compiled from: VideoDecodeSync */
public class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private MediaMetadataRetriever f4358a = null;

    /* renamed from: b  reason: collision with root package name */
    private MediaFormat f4359b = null;
    private MediaExtractor c = null;
    private MediaCodec d = null;
    private int e = 0;
    private int f = 0;
    private int g = 0;
    private int h = 0;
    private int i = 0;
    private long j = 0;
    private long k = -1;
    private b l = null;
    private SurfaceTexture m = null;
    private boolean n = false;
    private boolean o = false;
    private boolean p = false;
    private long q = 0;
    private long r = 0;
    private boolean s = false;
    private String t = "";
    private b u = null;
    private ConditionVariable v = null;
    private Object w = null;
    private ConditionVariable x = new ConditionVariable(true);

    public c(b bVar, SurfaceTexture surfaceTexture) {
        this.l = bVar;
        this.m = surfaceTexture;
        l();
    }

    public int a() {
        return this.f;
    }

    public int b() {
        return this.g;
    }

    public int c() {
        return this.h;
    }

    public void a(b bVar) {
        this.u = bVar;
    }

    public void a(ConditionVariable conditionVariable) {
        this.v = conditionVariable;
    }

    public void a(Object obj) {
        this.w = obj;
    }

    private void l() {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            this.f4358a = new MediaMetadataRetriever();
            this.f4358a.setDataSource(this.l.c());
            String extractMetadata = this.f4358a.extractMetadata(18);
            String extractMetadata2 = this.f4358a.extractMetadata(19);
            String extractMetadata3 = this.f4358a.extractMetadata(24);
            this.f = Integer.parseInt(extractMetadata);
            this.g = Integer.parseInt(extractMetadata2);
            this.h = Integer.parseInt(extractMetadata3);
            e.a("VideoDecodeSync", "init, mWidth: " + this.f + ", mHeight: " + this.g + ", mRotation: " + this.h);
        } catch (Exception e2) {
            e2.printStackTrace();
            this.n = true;
            o();
        }
        e.a("VideoDecodeSync", "init, time: " + (System.currentTimeMillis() - currentTimeMillis) + ", this: " + this);
    }

    private void m() {
        long currentTimeMillis = System.currentTimeMillis();
        this.c = new MediaExtractor();
        if (!this.l.f()) {
            long j2 = Long.MAX_VALUE;
            try {
                j2 = Long.parseLong(this.f4358a.extractMetadata(9));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            this.l.a(0);
            this.l.b(j2);
        }
        try {
            this.c.setDataSource(this.l.c());
            int trackCount = this.c.getTrackCount();
            int i2 = 0;
            while (true) {
                if (i2 >= trackCount) {
                    break;
                }
                MediaFormat trackFormat = this.c.getTrackFormat(i2);
                this.t = trackFormat.getString("mime");
                if (this.t != null && this.t.startsWith(AlgoSwitchConfig.APS_PIPELINE_VIDEO)) {
                    this.e = i2;
                    this.f4359b = trackFormat;
                    this.f4359b.setInteger("i-frame-interval", 1);
                    this.f4359b.setInteger("color-format", 2135033992);
                    e.a("VideoDecodeSync", "config, mVideoFormat: " + this.f4359b.toString() + ", mWidth: " + this.f + ", mHeight: " + this.g + ", rotation: " + this.h + ", this: " + this);
                    break;
                }
                i2++;
            }
            this.d = MediaCodec.createDecoderByType(this.t);
            this.d.configure(this.f4359b, new Surface(this.m), (MediaCrypto) null, 0);
            this.d.start();
        } catch (IOException e3) {
            e3.printStackTrace();
            e.e("VideoDecodeSync", "config, error: " + e3.getLocalizedMessage());
            this.n = true;
            o();
        } catch (Throwable th) {
            th.printStackTrace();
            e.e("VideoDecodeSync", "config, error");
            this.n = true;
            o();
        }
        e.a("VideoDecodeSync", "config, cost time: " + (System.currentTimeMillis() - currentTimeMillis));
    }

    public void d() {
        ConditionVariable conditionVariable = this.v;
        if (conditionVariable != null) {
            conditionVariable.close();
        }
        this.s = true;
    }

    public void e() {
        this.s = false;
    }

    public boolean f() {
        return this.s;
    }

    private int a(ByteBuffer byteBuffer) {
        if (this.n) {
            return -1;
        }
        byteBuffer.clear();
        int readSampleData = this.c.readSampleData(byteBuffer, 0);
        if (readSampleData < 0) {
            return -1;
        }
        this.j = this.c.getSampleTime();
        this.i = this.c.getSampleFlags();
        this.c.advance();
        return readSampleData;
    }

    public void g() {
        this.n = true;
    }

    public void h() {
        this.p = true;
    }

    public boolean i() {
        return !this.n && this.o;
    }

    public boolean j() {
        return !this.n && !this.o;
    }

    public void run() {
        this.x.close();
        m();
        MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
        e();
        try {
            this.c.selectTrack(this.e);
            if (this.l.f() && this.l.d() > 0) {
                this.c.seekTo(this.l.d() * 1000, 2);
            }
            while (!this.n) {
                int dequeueInputBuffer = this.d.dequeueInputBuffer(1000);
                if (dequeueInputBuffer > 0) {
                    int a2 = a(this.d.getInputBuffer(dequeueInputBuffer));
                    if (a2 <= 0 || this.p) {
                        this.p = false;
                        this.d.queueInputBuffer(dequeueInputBuffer, 0, 0, 0, 4);
                        this.d.flush();
                        this.c.seekTo(this.l.d() * 1000, 2);
                    } else {
                        this.d.queueInputBuffer(dequeueInputBuffer, 0, a2, this.j, this.i);
                    }
                }
                a(bufferInfo);
                int dequeueOutputBuffer = this.d.dequeueOutputBuffer(bufferInfo, 1000);
                b(bufferInfo);
                if (dequeueOutputBuffer > 0 && bufferInfo.presentationTimeUs / 1000 > this.l.e()) {
                    this.p = true;
                }
                if (dequeueOutputBuffer > 0 && !this.p) {
                    if (this.k < 0 || n()) {
                        this.k = System.currentTimeMillis();
                    }
                    if (this.n) {
                        continue;
                    } else {
                        if (this.v != null) {
                            this.v.close();
                            this.v.block();
                        }
                        synchronized (this.w) {
                            this.d.releaseOutputBuffer(dequeueOutputBuffer, true);
                        }
                        if (!this.o) {
                            e.a("VideoDecodeSync", "first decode frame arrived");
                            this.o = true;
                            if (this.u != null) {
                                this.u.a();
                            }
                        }
                    }
                }
            }
        } catch (Throwable th) {
            try {
                th.printStackTrace();
                e.a("VideoDecodeSync", "run, decode error, this: " + this);
            } catch (Throwable th2) {
                e.a("VideoDecodeSync", "run, decode thread end");
                this.x.open();
                throw th2;
            }
        }
        e.a("VideoDecodeSync", "run, decode thread end");
        this.x.open();
    }

    private boolean n() {
        return this.r < this.q;
    }

    private void a(MediaCodec.BufferInfo bufferInfo) {
        if (bufferInfo != null) {
            this.q = bufferInfo.presentationTimeUs / 1000;
        }
    }

    private void b(MediaCodec.BufferInfo bufferInfo) {
        if (bufferInfo != null) {
            this.r = bufferInfo.presentationTimeUs / 1000;
        }
    }

    public void k() {
        ConditionVariable conditionVariable = this.v;
        if (conditionVariable != null) {
            conditionVariable.open();
        }
        this.x.block(1000);
        e.a("VideoDecodeSync", "release, start");
        try {
            if (this.f4358a != null) {
                this.f4358a.release();
            }
            if (this.d != null) {
                this.d.stop();
                this.d.release();
                this.c.release();
            }
        } catch (IllegalStateException e2) {
            e2.printStackTrace();
        } catch (Throwable th) {
            e.a("VideoDecodeSync", "release, end");
            throw th;
        }
        e.a("VideoDecodeSync", "release, end");
    }

    private void o() {
        b bVar = this.u;
        if (bVar != null) {
            bVar.b();
        }
    }
}
