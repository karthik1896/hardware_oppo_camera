package androidx.room.b;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: CopyLock */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final Map<String, Lock> f1171a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private final File f1172b;
    private final Lock c = a(this.f1172b.getAbsolutePath());
    private final boolean d;
    private FileChannel e;

    public a(String str, File file, boolean z) {
        this.f1172b = new File(file, str + ".lck");
        this.d = z;
    }

    public void a() {
        this.c.lock();
        if (this.d) {
            try {
                this.e = new FileOutputStream(this.f1172b).getChannel();
                this.e.lock();
            } catch (IOException e2) {
                throw new IllegalStateException("Unable to grab copy lock.", e2);
            }
        }
    }

    public void b() {
        FileChannel fileChannel = this.e;
        if (fileChannel != null) {
            try {
                fileChannel.close();
            } catch (IOException unused) {
            }
        }
        this.c.unlock();
    }

    private static Lock a(String str) {
        Lock lock;
        synchronized (f1171a) {
            lock = f1171a.get(str);
            if (lock == null) {
                lock = new ReentrantLock();
                f1171a.put(str, lock);
            }
        }
        return lock;
    }
}
