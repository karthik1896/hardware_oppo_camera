package androidx.c;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.media.Image;
import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Log;
import android.util.Range;
import android.view.Surface;
import com.oppo.camera.statistics.CameraStatisticsUtil;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: HeifEncoder */
public final class c implements SurfaceTexture.OnFrameAvailableListener, AutoCloseable {
    private static final MediaCodecList n = new MediaCodecList(0);
    private b A;
    private a B;
    private int C;
    private final float[] D = new float[16];
    private final AtomicBoolean E = new AtomicBoolean(false);

    /* renamed from: a  reason: collision with root package name */
    MediaCodec f484a;

    /* renamed from: b  reason: collision with root package name */
    final a f485b;
    final Handler c;
    final int d;
    final int e;
    final int f;
    final int g;
    final int h;
    final int i;
    final boolean j;
    boolean k;
    final ArrayList<Integer> l = new ArrayList<>();
    C0011c m;
    private final HandlerThread o;
    private final int p;
    private final int q;
    private int r;
    private final Rect s;
    private final Rect t;
    private ByteBuffer u;
    private final ArrayList<ByteBuffer> v = new ArrayList<>();
    private final ArrayList<ByteBuffer> w = new ArrayList<>();
    private SurfaceTexture x;
    private Surface y;
    private Surface z;

    /* compiled from: HeifEncoder */
    public static abstract class a {
        public abstract void a(c cVar);

        public abstract void a(c cVar, MediaCodec.CodecException codecException);

        public abstract void a(c cVar, MediaFormat mediaFormat);

        public abstract void a(c cVar, ByteBuffer byteBuffer);
    }

    public c(int i2, int i3, boolean z2, int i4, int i5, Handler handler, a aVar) throws IOException {
        MediaCodecInfo.CodecCapabilities codecCapabilities;
        boolean z3;
        int i6;
        int i7;
        MediaFormat mediaFormat;
        int i8 = i2;
        int i9 = i3;
        int i10 = i4;
        int i11 = i5;
        if (i8 < 0 || i9 < 0 || i10 < 0 || i10 > 100) {
            throw new IllegalArgumentException("invalid encoder inputs");
        }
        int i12 = 512;
        int i13 = 1;
        boolean z4 = z2 & (i8 > 512 || i9 > 512);
        try {
            this.f484a = MediaCodec.createEncoderByType("image/vnd.android.heic");
            MediaCodecInfo.CodecCapabilities capabilitiesForType = this.f484a.getCodecInfo().getCapabilitiesForType("image/vnd.android.heic");
            if (capabilitiesForType.getVideoCapabilities().isSizeSupported(i8, i9)) {
                codecCapabilities = capabilitiesForType;
                z3 = true;
                this.p = i11;
                this.f485b = aVar;
                Looper looper = handler != null ? handler.getLooper() : null;
                if (looper == null) {
                    this.o = new HandlerThread("HeifEncoderThread", -2);
                    this.o.start();
                    looper = this.o.getLooper();
                } else {
                    this.o = null;
                }
                this.c = new Handler(looper);
                boolean z5 = i11 == 1 || i11 == 2;
                int i14 = z5 ? 2130708361 : 2135033992;
                boolean z6 = (z4 && !z3) || i11 == 2;
                this.d = i8;
                this.e = i9;
                this.j = z4;
                if (z4) {
                    i7 = ((i9 + 512) - 1) / 512;
                    i13 = ((i8 + 512) - 1) / 512;
                    i6 = 512;
                } else {
                    i12 = this.d;
                    i6 = this.e;
                    i7 = 1;
                }
                if (z3) {
                    mediaFormat = MediaFormat.createVideoFormat("image/vnd.android.heic", this.d, this.e);
                } else {
                    mediaFormat = MediaFormat.createVideoFormat("video/hevc", i12, i6);
                }
                if (z4) {
                    mediaFormat.setInteger("tile-width", i12);
                    mediaFormat.setInteger("tile-height", i6);
                    mediaFormat.setInteger("grid-cols", i13);
                    mediaFormat.setInteger("grid-rows", i7);
                }
                if (z3) {
                    this.f = i8;
                    this.g = i9;
                    this.h = 1;
                    this.i = 1;
                } else {
                    this.f = i12;
                    this.g = i6;
                    this.h = i7;
                    this.i = i13;
                }
                this.q = this.h * this.i;
                mediaFormat.setInteger("i-frame-interval", 0);
                mediaFormat.setInteger("color-format", i14);
                mediaFormat.setInteger("frame-rate", this.q);
                if (this.q > 1) {
                    mediaFormat.setInteger("operating-rate", 120);
                } else {
                    mediaFormat.setInteger("operating-rate", 30);
                }
                if (z5 && !z6) {
                    Log.d("HeifEncoder", "Setting fixed pts gap");
                    mediaFormat.setLong("max-pts-gap-to-encoder", -1000000);
                }
                MediaCodecInfo.EncoderCapabilities encoderCapabilities = codecCapabilities.getEncoderCapabilities();
                if (encoderCapabilities.isBitrateModeSupported(0)) {
                    Log.d("HeifEncoder", "Setting bitrate mode to constant quality");
                    Range<Integer> qualityRange = encoderCapabilities.getQualityRange();
                    Log.d("HeifEncoder", "Quality range: " + qualityRange);
                    mediaFormat.setInteger("bitrate-mode", 0);
                    mediaFormat.setInteger("quality", (int) (((double) qualityRange.getLower().intValue()) + (((double) ((qualityRange.getUpper().intValue() - qualityRange.getLower().intValue()) * i4)) / 100.0d)));
                } else {
                    int i15 = i4;
                    if (encoderCapabilities.isBitrateModeSupported(2)) {
                        Log.d("HeifEncoder", "Setting bitrate mode to constant bitrate");
                        mediaFormat.setInteger("bitrate-mode", 2);
                    } else {
                        Log.d("HeifEncoder", "Setting bitrate mode to variable bitrate");
                        mediaFormat.setInteger("bitrate-mode", 1);
                    }
                    mediaFormat.setInteger("bitrate", codecCapabilities.getVideoCapabilities().getBitrateRange().clamp(Integer.valueOf((int) (((((((double) (i8 * i9)) * 1.5d) * 8.0d) * 0.25d) * ((double) i15)) / 100.0d))).intValue());
                }
                this.f484a.setCallback(new b(), this.c);
                this.f484a.configure(mediaFormat, (Surface) null, (MediaCrypto) null, 1);
                if (z5) {
                    this.z = this.f484a.createInputSurface();
                    this.m = new C0011c(z6);
                    if (z6) {
                        this.A = new b(this.z);
                        this.A.b();
                        int i16 = i5;
                        this.B = new a(new e(i16 == 2 ? 0 : 1), this.d, this.e);
                        this.C = this.B.a();
                        if (i16 == 1) {
                            this.x = new SurfaceTexture(this.C, true);
                            this.x.setOnFrameAvailableListener(this);
                            this.x.setDefaultBufferSize(this.d, this.e);
                            this.y = new Surface(this.x);
                        }
                        this.A.c();
                    } else {
                        this.y = this.z;
                    }
                } else {
                    for (int i17 = 0; i17 < 2; i17++) {
                        this.v.add(ByteBuffer.allocateDirect(((this.d * this.e) * 3) / 2));
                    }
                }
                this.t = new Rect(0, 0, this.f, this.g);
                this.s = new Rect();
                return;
            }
            this.f484a.release();
            this.f484a = null;
            throw new Exception();
        } catch (Exception unused) {
            this.f484a = MediaCodec.createByCodecName(e());
            MediaCodecInfo.CodecCapabilities capabilitiesForType2 = this.f484a.getCodecInfo().getCapabilitiesForType("video/hevc");
            z4 |= !capabilitiesForType2.getVideoCapabilities().isSizeSupported(i8, i9);
            codecCapabilities = capabilitiesForType2;
            z3 = false;
        }
    }

    private String e() {
        String str = null;
        String str2 = null;
        for (MediaCodecInfo mediaCodecInfo : n.getCodecInfos()) {
            if (mediaCodecInfo.isEncoder()) {
                try {
                    MediaCodecInfo.CodecCapabilities capabilitiesForType = mediaCodecInfo.getCapabilitiesForType("video/hevc");
                    if (capabilitiesForType.getVideoCapabilities().isSizeSupported(512, 512)) {
                        if (capabilitiesForType.getEncoderCapabilities().isBitrateModeSupported(0)) {
                            if (mediaCodecInfo.isHardwareAccelerated()) {
                                return mediaCodecInfo.getName();
                            }
                            if (str == null) {
                                str = mediaCodecInfo.getName();
                            }
                        }
                        if (str2 == null) {
                            str2 = mediaCodecInfo.getName();
                        }
                    } else {
                        continue;
                    }
                } catch (IllegalArgumentException unused) {
                    continue;
                }
            }
        }
        return str != null ? str : str2;
    }

    private void f() {
        GLES20.glViewport(0, 0, this.f, this.g);
        for (int i2 = 0; i2 < this.h; i2++) {
            int i3 = 0;
            while (i3 < this.i) {
                int i4 = this.f;
                int i5 = i3 * i4;
                int i6 = this.g;
                int i7 = i2 * i6;
                this.s.set(i5, i7, i4 + i5, i6 + i7);
                try {
                    this.B.a(this.C, e.f503b, this.s);
                    b bVar = this.A;
                    int i8 = this.r;
                    this.r = i8 + 1;
                    bVar.a(a(i8) * 1000);
                    this.A.d();
                    i3++;
                } catch (RuntimeException e2) {
                    if (!this.E.get()) {
                        throw e2;
                    }
                    return;
                }
            }
        }
    }

    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        synchronized (this) {
            if (this.A != null) {
                this.A.b();
                surfaceTexture.updateTexImage();
                surfaceTexture.getTransformMatrix(this.D);
                if (this.m.a(surfaceTexture.getTimestamp(), a((this.r + this.q) - 1))) {
                    f();
                }
                surfaceTexture.releaseTexImage();
                this.A.c();
            }
        }
    }

    public void a() {
        this.f484a.start();
    }

    public void a(Bitmap bitmap) {
        if (this.p != 2) {
            throw new IllegalStateException("addBitmap is only allowed in bitmap input mode");
        } else if (this.m.a(a(this.r) * 1000, a((this.r + this.q) - 1))) {
            synchronized (this) {
                if (this.A != null) {
                    this.A.b();
                    this.B.a(this.C, bitmap);
                    f();
                    this.A.c();
                }
            }
        }
    }

    public void b() {
        int i2 = this.p;
        if (i2 == 2) {
            this.m.a(0);
        } else if (i2 == 0) {
            a((byte[]) null);
        }
    }

    private long a(int i2) {
        return ((((long) i2) * 1000000) / ((long) this.q)) + 132;
    }

    private void a(byte[] bArr) {
        ByteBuffer g2 = g();
        if (g2 != null) {
            g2.clear();
            if (bArr != null) {
                g2.put(bArr);
            }
            g2.flip();
            synchronized (this.w) {
                this.w.add(g2);
            }
            this.c.post(new Runnable() {
                public void run() {
                    c.this.c();
                }
            });
        }
    }

    /* access modifiers changed from: package-private */
    public void c() {
        int i2;
        while (true) {
            ByteBuffer h2 = h();
            if (h2 != null && !this.l.isEmpty()) {
                int i3 = 0;
                int intValue = this.l.remove(0).intValue();
                boolean z2 = this.r % this.q == 0 && h2.remaining() == 0;
                if (!z2) {
                    Image inputImage = this.f484a.getInputImage(intValue);
                    int i4 = this.f;
                    int i5 = this.r;
                    int i6 = this.i;
                    int i7 = (i5 % i6) * i4;
                    int i8 = this.g;
                    int i9 = ((i5 / i6) % this.h) * i8;
                    this.s.set(i7, i9, i4 + i7, i8 + i9);
                    a(h2, inputImage, this.d, this.e, this.s, this.t);
                }
                MediaCodec mediaCodec = this.f484a;
                if (z2) {
                    i2 = 0;
                } else {
                    i2 = mediaCodec.getInputBuffer(intValue).capacity();
                }
                int i10 = this.r;
                this.r = i10 + 1;
                long a2 = a(i10);
                if (z2) {
                    i3 = 4;
                }
                mediaCodec.queueInputBuffer(intValue, 0, i2, a2, i3);
                if (z2 || this.r % this.q == 0) {
                    a(z2);
                }
            } else {
                return;
            }
        }
    }

    private static void a(ByteBuffer byteBuffer, Image image, int i2, int i3, Rect rect, Rect rect2) {
        int i4;
        int i5;
        Rect rect3 = rect;
        Rect rect4 = rect2;
        if (rect.width() == rect2.width() && rect.height() == rect2.height()) {
            if (i2 % 2 == 0 && i3 % 2 == 0) {
                int i6 = 2;
                if (rect3.left % 2 == 0 && rect3.top % 2 == 0 && rect3.right % 2 == 0 && rect3.bottom % 2 == 0 && rect4.left % 2 == 0 && rect4.top % 2 == 0 && rect4.right % 2 == 0 && rect4.bottom % 2 == 0) {
                    Image.Plane[] planes = image.getPlanes();
                    int i7 = 0;
                    while (i7 < planes.length) {
                        ByteBuffer buffer = planes[i7].getBuffer();
                        int pixelStride = planes[i7].getPixelStride();
                        int min = Math.min(rect.width(), i2 - rect3.left);
                        int min2 = Math.min(rect.height(), i3 - rect3.top);
                        if (i7 > 0) {
                            i5 = ((i2 * i3) * (i7 + 3)) / 4;
                            i4 = i6;
                        } else {
                            i4 = 1;
                            i5 = 0;
                        }
                        for (int i8 = 0; i8 < min2 / i4; i8++) {
                            byteBuffer.position(((((rect3.top / i4) + i8) * i2) / i4) + i5 + (rect3.left / i4));
                            buffer.position((((rect4.top / i4) + i8) * planes[i7].getRowStride()) + ((rect4.left * pixelStride) / i4));
                            int i9 = 0;
                            while (true) {
                                int i10 = min / i4;
                                if (i9 >= i10) {
                                    break;
                                }
                                buffer.put(byteBuffer.get());
                                if (pixelStride > 1 && i9 != i10 - 1) {
                                    buffer.position((buffer.position() + pixelStride) - 1);
                                }
                                i9++;
                            }
                        }
                        ByteBuffer byteBuffer2 = byteBuffer;
                        i7++;
                        i6 = 2;
                    }
                    return;
                }
            }
            throw new IllegalArgumentException("src or dst are not aligned!");
        }
        throw new IllegalArgumentException("src and dst rect size are different!");
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:2:0x0003 */
    /* JADX WARNING: Removed duplicated region for block: B:2:0x0003 A[LOOP:0: B:2:0x0003->B:19:0x0003, LOOP_START, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.nio.ByteBuffer g() {
        /*
            r3 = this;
            java.util.ArrayList<java.nio.ByteBuffer> r0 = r3.v
            monitor-enter(r0)
        L_0x0003:
            boolean r1 = r3.k     // Catch:{ all -> 0x0026 }
            if (r1 != 0) goto L_0x0015
            java.util.ArrayList<java.nio.ByteBuffer> r1 = r3.v     // Catch:{ all -> 0x0026 }
            boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x0026 }
            if (r1 == 0) goto L_0x0015
            java.util.ArrayList<java.nio.ByteBuffer> r1 = r3.v     // Catch:{ InterruptedException -> 0x0003 }
            r1.wait()     // Catch:{ InterruptedException -> 0x0003 }
            goto L_0x0003
        L_0x0015:
            boolean r1 = r3.k     // Catch:{ all -> 0x0026 }
            if (r1 == 0) goto L_0x001b
            r1 = 0
            goto L_0x0024
        L_0x001b:
            java.util.ArrayList<java.nio.ByteBuffer> r1 = r3.v     // Catch:{ all -> 0x0026 }
            r2 = 0
            java.lang.Object r1 = r1.remove(r2)     // Catch:{ all -> 0x0026 }
            java.nio.ByteBuffer r1 = (java.nio.ByteBuffer) r1     // Catch:{ all -> 0x0026 }
        L_0x0024:
            monitor-exit(r0)     // Catch:{ all -> 0x0026 }
            return r1
        L_0x0026:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0026 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.c.c.g():java.nio.ByteBuffer");
    }

    private ByteBuffer h() {
        ByteBuffer byteBuffer;
        if (!this.k && this.u == null) {
            synchronized (this.w) {
                if (this.w.isEmpty()) {
                    byteBuffer = null;
                } else {
                    byteBuffer = this.w.remove(0);
                }
                this.u = byteBuffer;
            }
        }
        if (this.k) {
            return null;
        }
        return this.u;
    }

    private void a(boolean z2) {
        synchronized (this.v) {
            this.k = z2 | this.k;
            this.v.add(this.u);
            this.v.notifyAll();
        }
        this.u = null;
    }

    /* access modifiers changed from: package-private */
    public void d() {
        this.E.set(true);
        MediaCodec mediaCodec = this.f484a;
        if (mediaCodec != null) {
            mediaCodec.stop();
            this.f484a.release();
            this.f484a = null;
        }
        synchronized (this.v) {
            this.k = true;
            this.v.notifyAll();
        }
        synchronized (this) {
            if (this.B != null) {
                this.B.a(false);
                this.B = null;
            }
            if (this.A != null) {
                this.A.a();
                this.A = null;
            }
            if (this.x != null) {
                this.x.release();
                this.x = null;
            }
        }
    }

    /* renamed from: androidx.c.c$c  reason: collision with other inner class name */
    /* compiled from: HeifEncoder */
    private class C0011c {

        /* renamed from: a  reason: collision with root package name */
        final boolean f490a;

        /* renamed from: b  reason: collision with root package name */
        long f491b = -1;
        long c = -1;
        long d = -1;
        long e = -1;
        long f = -1;
        boolean g;

        C0011c(boolean z) {
            this.f490a = z;
        }

        /* access modifiers changed from: package-private */
        public synchronized void a(long j) {
            if (this.f490a) {
                if (this.f491b < 0) {
                    this.f491b = j;
                }
            } else if (this.d < 0) {
                this.d = j / 1000;
            }
            a();
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Removed duplicated region for block: B:10:0x0015  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public synchronized boolean a(long r5, long r7) {
            /*
                r4 = this;
                monitor-enter(r4)
                long r0 = r4.f491b     // Catch:{ all -> 0x001e }
                r2 = 0
                int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                if (r0 < 0) goto L_0x0012
                long r0 = r4.f491b     // Catch:{ all -> 0x001e }
                int r0 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
                if (r0 > 0) goto L_0x0010
                goto L_0x0012
            L_0x0010:
                r0 = 0
                goto L_0x0013
            L_0x0012:
                r0 = 1
            L_0x0013:
                if (r0 == 0) goto L_0x0017
                r4.e = r7     // Catch:{ all -> 0x001e }
            L_0x0017:
                r4.c = r5     // Catch:{ all -> 0x001e }
                r4.a()     // Catch:{ all -> 0x001e }
                monitor-exit(r4)
                return r0
            L_0x001e:
                r5 = move-exception
                monitor-exit(r4)
                throw r5
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.c.c.C0011c.a(long, long):boolean");
        }

        /* access modifiers changed from: package-private */
        public synchronized void b(long j) {
            this.f = j;
            a();
        }

        private void a() {
            if (!this.g) {
                if (this.d < 0) {
                    long j = this.f491b;
                    if (j >= 0 && this.c >= j) {
                        long j2 = this.e;
                        if (j2 < 0) {
                            b();
                            return;
                        }
                        this.d = j2;
                    }
                }
                long j3 = this.d;
                if (j3 >= 0 && j3 <= this.f) {
                    b();
                }
            }
        }

        private void b() {
            c.this.c.post(new Runnable() {
                public void run() {
                    if (c.this.f484a != null) {
                        c.this.f484a.signalEndOfInputStream();
                    }
                }
            });
            this.g = true;
        }
    }

    /* compiled from: HeifEncoder */
    class b extends MediaCodec.Callback {

        /* renamed from: b  reason: collision with root package name */
        private boolean f489b;

        b() {
        }

        public void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) {
            if (mediaCodec == c.this.f484a) {
                if (!"image/vnd.android.heic".equals(mediaFormat.getString("mime"))) {
                    mediaFormat.setString("mime", "image/vnd.android.heic");
                    mediaFormat.setInteger(CameraStatisticsUtil.IMAGE_WIDTH, c.this.d);
                    mediaFormat.setInteger(CameraStatisticsUtil.IMAGE_HEIGHT, c.this.e);
                    if (c.this.j) {
                        mediaFormat.setInteger("tile-width", c.this.f);
                        mediaFormat.setInteger("tile-height", c.this.g);
                        mediaFormat.setInteger("grid-rows", c.this.h);
                        mediaFormat.setInteger("grid-cols", c.this.i);
                    }
                }
                c.this.f485b.a(c.this, mediaFormat);
            }
        }

        public void onInputBufferAvailable(MediaCodec mediaCodec, int i) {
            if (mediaCodec == c.this.f484a && !c.this.k) {
                c.this.l.add(Integer.valueOf(i));
                c.this.c();
            }
        }

        public void onOutputBufferAvailable(MediaCodec mediaCodec, int i, MediaCodec.BufferInfo bufferInfo) {
            if (mediaCodec == c.this.f484a && !this.f489b) {
                if (bufferInfo.size > 0 && (bufferInfo.flags & 2) == 0) {
                    ByteBuffer outputBuffer = mediaCodec.getOutputBuffer(i);
                    outputBuffer.position(bufferInfo.offset);
                    outputBuffer.limit(bufferInfo.offset + bufferInfo.size);
                    if (c.this.m != null) {
                        c.this.m.b(bufferInfo.presentationTimeUs);
                    }
                    c.this.f485b.a(c.this, outputBuffer);
                }
                this.f489b = ((bufferInfo.flags & 4) != 0) | this.f489b;
                mediaCodec.releaseOutputBuffer(i, false);
                if (this.f489b) {
                    a((MediaCodec.CodecException) null);
                }
            }
        }

        public void onError(MediaCodec mediaCodec, MediaCodec.CodecException codecException) {
            if (mediaCodec == c.this.f484a) {
                Log.e("HeifEncoder", "onError: " + codecException);
                a(codecException);
            }
        }

        private void a(MediaCodec.CodecException codecException) {
            c.this.d();
            if (codecException == null) {
                c.this.f485b.a(c.this);
            } else {
                c.this.f485b.a(c.this, codecException);
            }
        }
    }

    public void close() {
        synchronized (this.v) {
            this.k = true;
            this.v.notifyAll();
        }
        this.c.postAtFrontOfQueue(new Runnable() {
            public void run() {
                c.this.d();
            }
        });
    }
}
