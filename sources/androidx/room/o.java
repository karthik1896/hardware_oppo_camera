package androidx.room;

import androidx.f.a.f;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: SharedSQLiteStatement */
public abstract class o {

    /* renamed from: a  reason: collision with root package name */
    private final AtomicBoolean f1220a = new AtomicBoolean(false);

    /* renamed from: b  reason: collision with root package name */
    private final i f1221b;
    private volatile f c;

    /* access modifiers changed from: protected */
    public abstract String a();

    public o(i iVar) {
        this.f1221b = iVar;
    }

    /* access modifiers changed from: protected */
    public void b() {
        this.f1221b.e();
    }

    private f d() {
        return this.f1221b.a(a());
    }

    private f a(boolean z) {
        if (!z) {
            return d();
        }
        if (this.c == null) {
            this.c = d();
        }
        return this.c;
    }

    public f c() {
        b();
        return a(this.f1220a.compareAndSet(false, true));
    }

    public void a(f fVar) {
        if (fVar == this.c) {
            this.f1220a.set(false);
        }
    }
}
