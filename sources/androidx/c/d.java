package androidx.c;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Log;
import android.util.Pair;
import androidx.c.c;
import java.io.FileDescriptor;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: HeifWriter */
public final class d implements AutoCloseable {

    /* renamed from: a  reason: collision with root package name */
    int f493a;

    /* renamed from: b  reason: collision with root package name */
    final int f494b;
    final int c;
    final int d;
    final c e = new c();
    MediaMuxer f;
    final AtomicBoolean g = new AtomicBoolean(false);
    int[] h;
    int i;
    private final int j;
    private final HandlerThread k;
    private final Handler l;
    private c m;
    private boolean n;
    private final List<Pair<Integer, ByteBuffer>> o = new ArrayList();

    /* compiled from: HeifWriter */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final String f496a;

        /* renamed from: b  reason: collision with root package name */
        private final FileDescriptor f497b;
        private final int c;
        private final int d;
        private final int e;
        private boolean f;
        private int g;
        private int h;
        private int i;
        private int j;
        private Handler k;

        public a(FileDescriptor fileDescriptor, int i2, int i3, int i4) {
            this((String) null, fileDescriptor, i2, i3, i4);
        }

        private a(String str, FileDescriptor fileDescriptor, int i2, int i3, int i4) {
            this.f = true;
            this.g = 100;
            this.h = 1;
            this.i = 0;
            this.j = 0;
            if (i2 <= 0 || i3 <= 0) {
                throw new IllegalArgumentException("Invalid image size: " + i2 + "x" + i3);
            }
            this.f496a = str;
            this.f497b = fileDescriptor;
            this.c = i2;
            this.d = i3;
            this.e = i4;
        }

        public a a(int i2) {
            if (i2 == 0 || i2 == 90 || i2 == 180 || i2 == 270) {
                this.j = i2;
                return this;
            }
            throw new IllegalArgumentException("Invalid rotation angle: " + i2);
        }

        public a a(boolean z) {
            this.f = z;
            return this;
        }

        public a b(int i2) {
            if (i2 < 0 || i2 > 100) {
                throw new IllegalArgumentException("Invalid quality: " + i2);
            }
            this.g = i2;
            return this;
        }

        public a c(int i2) {
            if (i2 > 0) {
                this.h = i2;
                return this;
            }
            throw new IllegalArgumentException("Invalid maxImage: " + i2);
        }

        public a d(int i2) {
            if (i2 >= 0) {
                this.i = i2;
                return this;
            }
            throw new IllegalArgumentException("Invalid primaryIndex: " + i2);
        }

        public a a(Handler handler) {
            this.k = handler;
            return this;
        }

        public d a() throws IOException {
            return new d(this.f496a, this.f497b, this.c, this.d, this.j, this.f, this.g, this.h, this.i, this.e, this.k);
        }
    }

    @SuppressLint({"WrongConstant"})
    d(String str, FileDescriptor fileDescriptor, int i2, int i3, int i4, boolean z, int i5, int i6, int i7, int i8, Handler handler) throws IOException {
        MediaMuxer mediaMuxer;
        String str2 = str;
        int i9 = i6;
        int i10 = i7;
        if (i10 < i9) {
            this.f493a = 1;
            this.f494b = i4;
            this.j = i8;
            this.c = i9;
            this.d = i10;
            Looper looper = handler != null ? handler.getLooper() : null;
            if (looper == null) {
                this.k = new HandlerThread("HeifEncoderThread", -2);
                this.k.start();
                looper = this.k.getLooper();
            } else {
                this.k = null;
            }
            this.l = new Handler(looper);
            if (str2 != null) {
                mediaMuxer = new MediaMuxer(str, 3);
            } else {
                FileDescriptor fileDescriptor2 = fileDescriptor;
                mediaMuxer = new MediaMuxer(fileDescriptor, 3);
            }
            this.f = mediaMuxer;
            this.m = new c(i2, i3, z, i5, this.j, this.l, new b());
            return;
        }
        throw new IllegalArgumentException("Invalid maxImages (" + i9 + ") or primaryIndex (" + i10 + ")");
    }

    public void a() {
        a(false);
        this.n = true;
        this.m.a();
    }

    public void a(Bitmap bitmap) {
        b(2);
        synchronized (this) {
            if (this.m != null) {
                this.m.a(bitmap);
            }
        }
    }

    public void a(int i2, byte[] bArr, int i3, int i4) {
        a(true);
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(i4);
        allocateDirect.put(bArr, i3, i4);
        allocateDirect.flip();
        synchronized (this.o) {
            this.o.add(new Pair(Integer.valueOf(i2), allocateDirect));
        }
        b();
    }

    /* access modifiers changed from: package-private */
    @SuppressLint({"WrongConstant"})
    public void b() {
        Pair remove;
        if (this.g.get()) {
            while (true) {
                synchronized (this.o) {
                    if (!this.o.isEmpty()) {
                        remove = this.o.remove(0);
                    } else {
                        return;
                    }
                }
                MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
                bufferInfo.set(((ByteBuffer) remove.second).position(), ((ByteBuffer) remove.second).remaining(), 0, 16);
                this.f.writeSampleData(this.h[((Integer) remove.first).intValue()], (ByteBuffer) remove.second, bufferInfo);
            }
            while (true) {
            }
        }
    }

    public void a(long j2) throws Exception {
        a(true);
        synchronized (this) {
            if (this.m != null) {
                this.m.b();
            }
        }
        this.e.a(j2);
        b();
        c();
    }

    private void a(boolean z) {
        if (this.n != z) {
            throw new IllegalStateException("Already started");
        }
    }

    private void a(int i2) {
        if (this.j != i2) {
            throw new IllegalStateException("Not valid in input mode " + this.j);
        }
    }

    private void b(int i2) {
        a(true);
        a(i2);
    }

    /* access modifiers changed from: package-private */
    public void c() {
        MediaMuxer mediaMuxer = this.f;
        if (mediaMuxer != null) {
            mediaMuxer.stop();
            this.f.release();
            this.f = null;
        }
        c cVar = this.m;
        if (cVar != null) {
            cVar.close();
            synchronized (this) {
                this.m = null;
            }
        }
    }

    /* compiled from: HeifWriter */
    class b extends c.a {

        /* renamed from: b  reason: collision with root package name */
        private boolean f499b;

        b() {
        }

        public void a(c cVar, MediaFormat mediaFormat) {
            if (!this.f499b) {
                if (d.this.h != null) {
                    a((Exception) new IllegalStateException("Output format changed after muxer started"));
                    return;
                }
                try {
                    d.this.f493a = mediaFormat.getInteger("grid-rows") * mediaFormat.getInteger("grid-cols");
                } catch (ClassCastException | NullPointerException unused) {
                    d.this.f493a = 1;
                }
                d dVar = d.this;
                dVar.h = new int[dVar.c];
                if (d.this.f494b > 0) {
                    Log.d("HeifWriter", "setting rotation: " + d.this.f494b);
                    d.this.f.setOrientationHint(d.this.f494b);
                }
                int i = 0;
                while (i < d.this.h.length) {
                    mediaFormat.setInteger("is-default", i == d.this.d ? 1 : 0);
                    d.this.h[i] = d.this.f.addTrack(mediaFormat);
                    i++;
                }
                d.this.f.start();
                d.this.g.set(true);
                d.this.b();
            }
        }

        public void a(c cVar, ByteBuffer byteBuffer) {
            if (!this.f499b) {
                if (d.this.h == null) {
                    a((Exception) new IllegalStateException("Output buffer received before format info"));
                    return;
                }
                if (d.this.i < d.this.c * d.this.f493a) {
                    MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
                    bufferInfo.set(byteBuffer.position(), byteBuffer.remaining(), 0, 0);
                    d.this.f.writeSampleData(d.this.h[d.this.i / d.this.f493a], byteBuffer, bufferInfo);
                }
                d.this.i++;
                if (d.this.i == d.this.c * d.this.f493a) {
                    a((Exception) null);
                }
            }
        }

        public void a(c cVar) {
            a((Exception) null);
        }

        public void a(c cVar, MediaCodec.CodecException codecException) {
            a((Exception) codecException);
        }

        private void a(Exception exc) {
            if (!this.f499b) {
                this.f499b = true;
                d.this.e.a(exc);
            }
        }
    }

    /* compiled from: HeifWriter */
    static class c {

        /* renamed from: a  reason: collision with root package name */
        private boolean f500a;

        /* renamed from: b  reason: collision with root package name */
        private Exception f501b;

        c() {
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Can't wrap try/catch for region: R(5:15|16|17|18|11) */
        /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0020 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:4:0x0009 */
        /* JADX WARNING: Removed duplicated region for block: B:4:0x0009 A[LOOP:0: B:4:0x0009->B:34:0x0009, LOOP_START, SYNTHETIC] */
        /* JADX WARNING: Unknown top exception splitter block from list: {B:17:0x0020=Splitter:B:17:0x0020, B:4:0x0009=Splitter:B:4:0x0009} */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public synchronized void a(long r7) throws java.lang.Exception {
            /*
                r6 = this;
                monitor-enter(r6)
                r0 = 0
                int r2 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
                if (r2 < 0) goto L_0x0040
                if (r2 != 0) goto L_0x0011
            L_0x0009:
                boolean r7 = r6.f500a     // Catch:{ all -> 0x0048 }
                if (r7 != 0) goto L_0x0027
                r6.wait()     // Catch:{ InterruptedException -> 0x0009 }
                goto L_0x0009
            L_0x0011:
                long r2 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0048 }
            L_0x0015:
                boolean r4 = r6.f500a     // Catch:{ all -> 0x0048 }
                if (r4 != 0) goto L_0x0027
                int r4 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
                if (r4 <= 0) goto L_0x0027
                r6.wait(r7)     // Catch:{ InterruptedException -> 0x0020 }
            L_0x0020:
                long r4 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0048 }
                long r4 = r4 - r2
                long r7 = r7 - r4
                goto L_0x0015
            L_0x0027:
                boolean r7 = r6.f500a     // Catch:{ all -> 0x0048 }
                if (r7 != 0) goto L_0x0037
                r7 = 1
                r6.f500a = r7     // Catch:{ all -> 0x0048 }
                java.util.concurrent.TimeoutException r7 = new java.util.concurrent.TimeoutException     // Catch:{ all -> 0x0048 }
                java.lang.String r8 = "timed out waiting for result"
                r7.<init>(r8)     // Catch:{ all -> 0x0048 }
                r6.f501b = r7     // Catch:{ all -> 0x0048 }
            L_0x0037:
                java.lang.Exception r7 = r6.f501b     // Catch:{ all -> 0x0048 }
                if (r7 != 0) goto L_0x003d
                monitor-exit(r6)
                return
            L_0x003d:
                java.lang.Exception r7 = r6.f501b     // Catch:{ all -> 0x0048 }
                throw r7     // Catch:{ all -> 0x0048 }
            L_0x0040:
                java.lang.IllegalArgumentException r7 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x0048 }
                java.lang.String r8 = "timeoutMs is negative"
                r7.<init>(r8)     // Catch:{ all -> 0x0048 }
                throw r7     // Catch:{ all -> 0x0048 }
            L_0x0048:
                r7 = move-exception
                monitor-exit(r6)
                throw r7
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.c.d.c.a(long):void");
        }

        /* access modifiers changed from: package-private */
        public synchronized void a(Exception exc) {
            if (!this.f500a) {
                this.f500a = true;
                this.f501b = exc;
                notifyAll();
            }
        }
    }

    public void close() {
        this.l.postAtFrontOfQueue(new Runnable() {
            public void run() {
                try {
                    d.this.c();
                } catch (Exception unused) {
                }
            }
        });
    }
}
