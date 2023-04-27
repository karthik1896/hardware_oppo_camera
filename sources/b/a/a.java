package b.a;

import com.oppo.exif.OppoExifTag;
import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Writer;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: DiskLruCache */
public final class a implements Closeable {

    /* renamed from: a  reason: collision with root package name */
    private static final Charset f1403a = Charset.forName("UTF-8");
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final File f1404b;
    private final File c;
    private final File d;
    private final int e;
    private final long f;
    /* access modifiers changed from: private */
    public final int g;
    private long h = 0;
    /* access modifiers changed from: private */
    public Writer i;
    private final LinkedHashMap<String, b> j = new LinkedHashMap<>(0, 0.75f, true);
    /* access modifiers changed from: private */
    public int k;
    private long l = 0;
    private final ExecutorService m = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());
    private final Callable<Void> n = new Callable<Void>() {
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0027, code lost:
            return null;
         */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Void call() throws java.lang.Exception {
            /*
                r4 = this;
                b.a.a r0 = b.a.a.this
                monitor-enter(r0)
                b.a.a r1 = b.a.a.this     // Catch:{ all -> 0x0028 }
                java.io.Writer r1 = r1.i     // Catch:{ all -> 0x0028 }
                r2 = 0
                if (r1 != 0) goto L_0x000e
                monitor-exit(r0)     // Catch:{ all -> 0x0028 }
                return r2
            L_0x000e:
                b.a.a r1 = b.a.a.this     // Catch:{ all -> 0x0028 }
                r1.j()     // Catch:{ all -> 0x0028 }
                b.a.a r1 = b.a.a.this     // Catch:{ all -> 0x0028 }
                boolean r1 = r1.h()     // Catch:{ all -> 0x0028 }
                if (r1 == 0) goto L_0x0026
                b.a.a r1 = b.a.a.this     // Catch:{ all -> 0x0028 }
                r1.g()     // Catch:{ all -> 0x0028 }
                b.a.a r1 = b.a.a.this     // Catch:{ all -> 0x0028 }
                r3 = 0
                int unused = r1.k = r3     // Catch:{ all -> 0x0028 }
            L_0x0026:
                monitor-exit(r0)     // Catch:{ all -> 0x0028 }
                return r2
            L_0x0028:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0028 }
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: b.a.a.AnonymousClass1.call():java.lang.Void");
        }
    };

    private static <T> T[] a(T[] tArr, int i2, int i3) {
        int length = tArr.length;
        if (i2 > i3) {
            throw new IllegalArgumentException();
        } else if (i2 < 0 || i2 > length) {
            throw new ArrayIndexOutOfBoundsException();
        } else {
            int i4 = i3 - i2;
            int min = Math.min(i4, length - i2);
            T[] tArr2 = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), i4);
            System.arraycopy(tArr, i2, tArr2, 0, min);
            return tArr2;
        }
    }

    public static String a(InputStream inputStream) throws IOException {
        StringBuilder sb = new StringBuilder(80);
        while (true) {
            int read = inputStream.read();
            if (read == -1) {
                throw new EOFException();
            } else if (read == 10) {
                int length = sb.length();
                if (length > 0) {
                    int i2 = length - 1;
                    if (sb.charAt(i2) == 13) {
                        sb.setLength(i2);
                    }
                }
                return sb.toString();
            } else {
                sb.append((char) read);
            }
        }
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e2) {
                throw e2;
            } catch (Exception unused) {
            }
        }
    }

    public static void a(File file) throws IOException {
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            int length = listFiles.length;
            int i2 = 0;
            while (i2 < length) {
                File file2 = listFiles[i2];
                if (file2.isDirectory()) {
                    a(file2);
                }
                if (file2.delete()) {
                    i2++;
                } else {
                    throw new IOException("failed to delete file: " + file2);
                }
            }
            return;
        }
        throw new IllegalArgumentException("not a directory: " + file);
    }

    private a(File file, int i2, int i3, long j2) {
        File file2 = file;
        this.f1404b = file2;
        this.e = i2;
        this.c = new File(file2, "journal");
        this.d = new File(file2, "journal.tmp");
        this.g = i3;
        this.f = j2;
    }

    public static a a(File file, int i2, int i3, long j2) throws IOException {
        if (j2 <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        } else if (i3 > 0) {
            a aVar = new a(file, i2, i3, j2);
            if (aVar.c.exists()) {
                try {
                    aVar.e();
                    aVar.f();
                    aVar.i = new BufferedWriter(new FileWriter(aVar.c, true), OppoExifTag.EXIF_TAG_SUPER_HIGH_RESOLUTION);
                    return aVar;
                } catch (IOException unused) {
                    aVar.d();
                }
            }
            file.mkdirs();
            a aVar2 = new a(file, i2, i3, j2);
            aVar2.g();
            return aVar2;
        } else {
            throw new IllegalArgumentException("valueCount <= 0");
        }
    }

    private void e() throws IOException {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(this.c), OppoExifTag.EXIF_TAG_SUPER_HIGH_RESOLUTION);
        try {
            String a2 = a((InputStream) bufferedInputStream);
            String a3 = a((InputStream) bufferedInputStream);
            String a4 = a((InputStream) bufferedInputStream);
            String a5 = a((InputStream) bufferedInputStream);
            String a6 = a((InputStream) bufferedInputStream);
            if (!"libcore.io.DiskLruCache".equals(a2) || !"1".equals(a3) || !Integer.toString(this.e).equals(a4) || !Integer.toString(this.g).equals(a5) || !"".equals(a6)) {
                throw new IOException("unexpected journal header: [" + a2 + ", " + a3 + ", " + a5 + ", " + a6 + "]");
            }
            while (true) {
                try {
                    d(a((InputStream) bufferedInputStream));
                } catch (EOFException unused) {
                    return;
                }
            }
        } finally {
            a((Closeable) bufferedInputStream);
        }
    }

    private void d(String str) throws IOException {
        String[] split = str.split(" ");
        if (split.length >= 2) {
            String str2 = split[1];
            if (!split[0].equals("REMOVE") || split.length != 2) {
                b bVar = this.j.get(str2);
                if (bVar == null) {
                    bVar = new b(str2);
                    this.j.put(str2, bVar);
                }
                if (split[0].equals("CLEAN") && split.length == this.g + 2) {
                    boolean unused = bVar.d = true;
                    C0041a unused2 = bVar.e = null;
                    bVar.a((String[]) a((T[]) split, 2, split.length));
                } else if (split[0].equals("DIRTY") && split.length == 2) {
                    C0041a unused3 = bVar.e = new C0041a(bVar);
                } else if (!split[0].equals("READ") || split.length != 2) {
                    throw new IOException("unexpected journal line: " + str);
                }
            } else {
                this.j.remove(str2);
            }
        } else {
            throw new IOException("unexpected journal line: " + str);
        }
    }

    private synchronized void f() throws IOException {
        b(this.d);
        Iterator<b> it = this.j.values().iterator();
        while (it.hasNext()) {
            b next = it.next();
            int i2 = 0;
            if (next.e == null) {
                while (i2 < this.g) {
                    this.h += next.c[i2];
                    i2++;
                }
            } else {
                C0041a unused = next.e = null;
                while (i2 < this.g) {
                    b(next.a(i2));
                    b(next.b(i2));
                    i2++;
                }
                it.remove();
            }
        }
    }

    /* access modifiers changed from: private */
    public synchronized void g() throws IOException {
        BufferedWriter bufferedWriter;
        if (this.i != null) {
            this.i.close();
        }
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(this.d), OppoExifTag.EXIF_TAG_SUPER_HIGH_RESOLUTION);
            bufferedWriter.write("libcore.io.DiskLruCache");
            bufferedWriter.write("\n");
            bufferedWriter.write("1");
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.e));
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.g));
            bufferedWriter.write("\n");
            bufferedWriter.write("\n");
            for (b next : this.j.values()) {
                if (next.e != null) {
                    bufferedWriter.write("DIRTY " + next.f1410b + 10);
                } else {
                    bufferedWriter.write("CLEAN " + next.f1410b + next.a() + 10);
                }
            }
            bufferedWriter.close();
        } catch (IOException e2) {
            e2.printStackTrace();
        } catch (Throwable th) {
            r2.addSuppressed(th);
        }
        this.d.renameTo(this.c);
        this.i = new BufferedWriter(new FileWriter(this.c, true), OppoExifTag.EXIF_TAG_SUPER_HIGH_RESOLUTION);
        return;
        throw th;
    }

    private static void b(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    public synchronized c a(String str) throws IOException {
        i();
        e(str);
        b bVar = this.j.get(str);
        if (bVar == null) {
            return null;
        }
        if (!bVar.d) {
            return null;
        }
        InputStream[] inputStreamArr = new InputStream[this.g];
        int i2 = 0;
        while (i2 < this.g) {
            try {
                inputStreamArr[i2] = new FileInputStream(bVar.a(i2));
                i2++;
            } catch (FileNotFoundException unused) {
                return null;
            }
        }
        this.k++;
        this.i.append("READ " + str + 10);
        if (h()) {
            this.m.submit(this.n);
        }
        return new c(str, bVar.f, inputStreamArr);
    }

    public C0041a b(String str) throws IOException {
        return a(str, -1);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0021, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized b.a.a.C0041a a(java.lang.String r6, long r7) throws java.io.IOException {
        /*
            r5 = this;
            monitor-enter(r5)
            r5.i()     // Catch:{ all -> 0x0061 }
            r5.e((java.lang.String) r6)     // Catch:{ all -> 0x0061 }
            java.util.LinkedHashMap<java.lang.String, b.a.a$b> r0 = r5.j     // Catch:{ all -> 0x0061 }
            java.lang.Object r0 = r0.get(r6)     // Catch:{ all -> 0x0061 }
            b.a.a$b r0 = (b.a.a.b) r0     // Catch:{ all -> 0x0061 }
            r1 = -1
            int r1 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            r2 = 0
            if (r1 == 0) goto L_0x0022
            if (r0 == 0) goto L_0x0020
            long r3 = r0.f     // Catch:{ all -> 0x0061 }
            int r7 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r7 == 0) goto L_0x0022
        L_0x0020:
            monitor-exit(r5)
            return r2
        L_0x0022:
            if (r0 != 0) goto L_0x002f
            b.a.a$b r0 = new b.a.a$b     // Catch:{ all -> 0x0061 }
            r0.<init>(r6)     // Catch:{ all -> 0x0061 }
            java.util.LinkedHashMap<java.lang.String, b.a.a$b> r7 = r5.j     // Catch:{ all -> 0x0061 }
            r7.put(r6, r0)     // Catch:{ all -> 0x0061 }
            goto L_0x0037
        L_0x002f:
            b.a.a$a r7 = r0.e     // Catch:{ all -> 0x0061 }
            if (r7 == 0) goto L_0x0037
            monitor-exit(r5)
            return r2
        L_0x0037:
            b.a.a$a r7 = new b.a.a$a     // Catch:{ all -> 0x0061 }
            r7.<init>(r0)     // Catch:{ all -> 0x0061 }
            b.a.a.C0041a unused = r0.e = r7     // Catch:{ all -> 0x0061 }
            java.io.Writer r8 = r5.i     // Catch:{ all -> 0x0061 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0061 }
            r0.<init>()     // Catch:{ all -> 0x0061 }
            java.lang.String r1 = "DIRTY "
            r0.append(r1)     // Catch:{ all -> 0x0061 }
            r0.append(r6)     // Catch:{ all -> 0x0061 }
            r6 = 10
            r0.append(r6)     // Catch:{ all -> 0x0061 }
            java.lang.String r6 = r0.toString()     // Catch:{ all -> 0x0061 }
            r8.write(r6)     // Catch:{ all -> 0x0061 }
            java.io.Writer r6 = r5.i     // Catch:{ all -> 0x0061 }
            r6.flush()     // Catch:{ all -> 0x0061 }
            monitor-exit(r5)
            return r7
        L_0x0061:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: b.a.a.a(java.lang.String, long):b.a.a$a");
    }

    public File a() {
        return this.f1404b;
    }

    /* access modifiers changed from: private */
    public synchronized void a(C0041a aVar, boolean z) throws IOException {
        b a2 = aVar.f1407b;
        if (a2.e == aVar) {
            if (z && !a2.d) {
                int i2 = 0;
                while (i2 < this.g) {
                    if (a2.b(i2).exists()) {
                        i2++;
                    } else {
                        aVar.b();
                        throw new IllegalStateException("edit didn't create file " + i2);
                    }
                }
            }
            for (int i3 = 0; i3 < this.g; i3++) {
                File b2 = a2.b(i3);
                if (!z) {
                    b(b2);
                } else if (b2.exists()) {
                    File a3 = a2.a(i3);
                    b2.renameTo(a3);
                    long j2 = a2.c[i3];
                    long length = a3.length();
                    a2.c[i3] = length;
                    this.h = (this.h - j2) + length;
                }
            }
            this.k++;
            C0041a unused = a2.e = null;
            if (a2.d || z) {
                boolean unused2 = a2.d = true;
                this.i.write("CLEAN " + a2.f1410b + a2.a() + 10);
                if (z) {
                    long j3 = this.l;
                    this.l = 1 + j3;
                    long unused3 = a2.f = j3;
                }
            } else {
                this.j.remove(a2.f1410b);
                this.i.write("REMOVE " + a2.f1410b + 10);
            }
            if (this.h > this.f || h()) {
                this.m.submit(this.n);
            }
        } else {
            throw new IllegalStateException();
        }
    }

    /* access modifiers changed from: private */
    public boolean h() {
        int i2 = this.k;
        return i2 >= 2000 && i2 >= this.j.size();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0088, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x008a, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean c(java.lang.String r7) throws java.io.IOException {
        /*
            r6 = this;
            monitor-enter(r6)
            r6.i()     // Catch:{ all -> 0x008b }
            r6.e((java.lang.String) r7)     // Catch:{ all -> 0x008b }
            java.util.LinkedHashMap<java.lang.String, b.a.a$b> r0 = r6.j     // Catch:{ all -> 0x008b }
            java.lang.Object r0 = r0.get(r7)     // Catch:{ all -> 0x008b }
            b.a.a$b r0 = (b.a.a.b) r0     // Catch:{ all -> 0x008b }
            r1 = 0
            if (r0 == 0) goto L_0x0089
            b.a.a$a r2 = r0.e     // Catch:{ all -> 0x008b }
            if (r2 == 0) goto L_0x0019
            goto L_0x0089
        L_0x0019:
            int r2 = r6.g     // Catch:{ all -> 0x008b }
            if (r1 >= r2) goto L_0x0054
            java.io.File r2 = r0.a((int) r1)     // Catch:{ all -> 0x008b }
            boolean r3 = r2.delete()     // Catch:{ all -> 0x008b }
            if (r3 == 0) goto L_0x003d
            long r2 = r6.h     // Catch:{ all -> 0x008b }
            long[] r4 = r0.c     // Catch:{ all -> 0x008b }
            r4 = r4[r1]     // Catch:{ all -> 0x008b }
            long r2 = r2 - r4
            r6.h = r2     // Catch:{ all -> 0x008b }
            long[] r2 = r0.c     // Catch:{ all -> 0x008b }
            r3 = 0
            r2[r1] = r3     // Catch:{ all -> 0x008b }
            int r1 = r1 + 1
            goto L_0x0019
        L_0x003d:
            java.io.IOException r7 = new java.io.IOException     // Catch:{ all -> 0x008b }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x008b }
            r0.<init>()     // Catch:{ all -> 0x008b }
            java.lang.String r1 = "failed to delete "
            r0.append(r1)     // Catch:{ all -> 0x008b }
            r0.append(r2)     // Catch:{ all -> 0x008b }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x008b }
            r7.<init>(r0)     // Catch:{ all -> 0x008b }
            throw r7     // Catch:{ all -> 0x008b }
        L_0x0054:
            int r0 = r6.k     // Catch:{ all -> 0x008b }
            r1 = 1
            int r0 = r0 + r1
            r6.k = r0     // Catch:{ all -> 0x008b }
            java.io.Writer r0 = r6.i     // Catch:{ all -> 0x008b }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x008b }
            r2.<init>()     // Catch:{ all -> 0x008b }
            java.lang.String r3 = "REMOVE "
            r2.append(r3)     // Catch:{ all -> 0x008b }
            r2.append(r7)     // Catch:{ all -> 0x008b }
            r3 = 10
            r2.append(r3)     // Catch:{ all -> 0x008b }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x008b }
            r0.append(r2)     // Catch:{ all -> 0x008b }
            java.util.LinkedHashMap<java.lang.String, b.a.a$b> r0 = r6.j     // Catch:{ all -> 0x008b }
            r0.remove(r7)     // Catch:{ all -> 0x008b }
            boolean r7 = r6.h()     // Catch:{ all -> 0x008b }
            if (r7 == 0) goto L_0x0087
            java.util.concurrent.ExecutorService r7 = r6.m     // Catch:{ all -> 0x008b }
            java.util.concurrent.Callable<java.lang.Void> r0 = r6.n     // Catch:{ all -> 0x008b }
            r7.submit(r0)     // Catch:{ all -> 0x008b }
        L_0x0087:
            monitor-exit(r6)
            return r1
        L_0x0089:
            monitor-exit(r6)
            return r1
        L_0x008b:
            r7 = move-exception
            monitor-exit(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: b.a.a.c(java.lang.String):boolean");
    }

    public synchronized boolean b() {
        return this.i == null;
    }

    private void i() {
        if (this.i == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    public synchronized void c() throws IOException {
        i();
        j();
        this.i.flush();
    }

    public synchronized void close() throws IOException {
        if (this.i != null) {
            Iterator it = new ArrayList(this.j.values()).iterator();
            while (it.hasNext()) {
                b bVar = (b) it.next();
                if (bVar.e != null) {
                    bVar.e.b();
                }
            }
            j();
            this.i.close();
            this.i = null;
        }
    }

    /* access modifiers changed from: private */
    public void j() throws IOException {
        while (this.h > this.f) {
            c((String) this.j.entrySet().iterator().next().getKey());
        }
    }

    public void d() throws IOException {
        close();
        a(this.f1404b);
    }

    private void e(String str) {
        if (str.contains(" ") || str.contains("\n") || str.contains("\r")) {
            throw new IllegalArgumentException("keys must not contain spaces or newlines: \"" + str + "\"");
        }
    }

    /* compiled from: DiskLruCache */
    public final class c implements Closeable {

        /* renamed from: b  reason: collision with root package name */
        private final String f1412b;
        private final long c;
        private final InputStream[] d;

        private c(String str, long j, InputStream[] inputStreamArr) {
            this.f1412b = str;
            this.c = j;
            this.d = inputStreamArr;
        }

        public InputStream a(int i) {
            return this.d[i];
        }

        public void close() {
            for (InputStream a2 : this.d) {
                a.a((Closeable) a2);
            }
        }
    }

    /* renamed from: b.a.a$a  reason: collision with other inner class name */
    /* compiled from: DiskLruCache */
    public final class C0041a {
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final b f1407b;
        /* access modifiers changed from: private */
        public boolean c;

        private C0041a(b bVar) {
            this.f1407b = bVar;
        }

        public OutputStream a(int i) throws IOException {
            C0042a aVar;
            synchronized (a.this) {
                if (this.f1407b.e == this) {
                    aVar = new C0042a(new FileOutputStream(this.f1407b.b(i)));
                } else {
                    throw new IllegalStateException();
                }
            }
            return aVar;
        }

        public void a() throws IOException {
            if (this.c) {
                a.this.a(this, false);
                a.this.c(this.f1407b.f1410b);
                return;
            }
            a.this.a(this, true);
        }

        public void b() throws IOException {
            a.this.a(this, false);
        }

        /* renamed from: b.a.a$a$a  reason: collision with other inner class name */
        /* compiled from: DiskLruCache */
        private class C0042a extends FilterOutputStream {
            private C0042a(OutputStream outputStream) {
                super(outputStream);
            }

            public void write(int i) {
                try {
                    this.out.write(i);
                } catch (IOException unused) {
                    boolean unused2 = C0041a.this.c = true;
                }
            }

            public void write(byte[] bArr, int i, int i2) {
                try {
                    this.out.write(bArr, i, i2);
                } catch (IOException unused) {
                    boolean unused2 = C0041a.this.c = true;
                }
            }

            public void close() {
                try {
                    this.out.close();
                } catch (IOException unused) {
                    boolean unused2 = C0041a.this.c = true;
                }
            }

            public void flush() {
                try {
                    this.out.flush();
                } catch (IOException unused) {
                    boolean unused2 = C0041a.this.c = true;
                }
            }
        }
    }

    /* compiled from: DiskLruCache */
    private final class b {
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final String f1410b;
        /* access modifiers changed from: private */
        public final long[] c;
        /* access modifiers changed from: private */
        public boolean d;
        /* access modifiers changed from: private */
        public C0041a e;
        /* access modifiers changed from: private */
        public long f;

        private b(String str) {
            this.f1410b = str;
            this.c = new long[a.this.g];
        }

        public String a() throws IOException {
            StringBuilder sb = new StringBuilder();
            for (long append : this.c) {
                sb.append(' ');
                sb.append(append);
            }
            return sb.toString();
        }

        /* access modifiers changed from: private */
        public void a(String[] strArr) throws IOException {
            if (strArr.length == a.this.g) {
                int i = 0;
                while (i < strArr.length) {
                    try {
                        this.c[i] = Long.parseLong(strArr[i]);
                        i++;
                    } catch (NumberFormatException unused) {
                        throw b(strArr);
                    }
                }
                return;
            }
            throw b(strArr);
        }

        private IOException b(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        public File a(int i) {
            File f2 = a.this.f1404b;
            return new File(f2, this.f1410b + "." + i);
        }

        public File b(int i) {
            File f2 = a.this.f1404b;
            return new File(f2, this.f1410b + "." + i + ".tmp");
        }
    }
}
