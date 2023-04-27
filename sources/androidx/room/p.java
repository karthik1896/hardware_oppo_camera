package androidx.room;

import java.util.ArrayDeque;
import java.util.concurrent.Executor;

/* compiled from: TransactionExecutor */
class p implements Executor {

    /* renamed from: a  reason: collision with root package name */
    private final Executor f1222a;

    /* renamed from: b  reason: collision with root package name */
    private final ArrayDeque<Runnable> f1223b = new ArrayDeque<>();
    private Runnable c;

    p(Executor executor) {
        this.f1222a = executor;
    }

    public synchronized void execute(final Runnable runnable) {
        this.f1223b.offer(new Runnable() {
            public void run() {
                try {
                    runnable.run();
                } finally {
                    p.this.a();
                }
            }
        });
        if (this.c == null) {
            a();
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized void a() {
        Runnable poll = this.f1223b.poll();
        this.c = poll;
        if (poll != null) {
            this.f1222a.execute(this.c);
        }
    }
}
