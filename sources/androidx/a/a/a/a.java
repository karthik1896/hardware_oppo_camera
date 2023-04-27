package androidx.a.a.a;

import java.util.concurrent.Executor;

/* compiled from: ArchTaskExecutor */
public class a extends c {

    /* renamed from: a  reason: collision with root package name */
    private static volatile a f85a;
    private static final Executor d = new Executor() {
        public void execute(Runnable runnable) {
            a.a().b(runnable);
        }
    };
    private static final Executor e = new Executor() {
        public void execute(Runnable runnable) {
            a.a().a(runnable);
        }
    };

    /* renamed from: b  reason: collision with root package name */
    private c f86b = this.c;
    private c c = new b();

    private a() {
    }

    public static a a() {
        if (f85a != null) {
            return f85a;
        }
        synchronized (a.class) {
            if (f85a == null) {
                f85a = new a();
            }
        }
        return f85a;
    }

    public void a(Runnable runnable) {
        this.f86b.a(runnable);
    }

    public void b(Runnable runnable) {
        this.f86b.b(runnable);
    }

    public static Executor b() {
        return e;
    }

    public boolean c() {
        return this.f86b.c();
    }
}
