package androidx.room;

import androidx.f.a.f;

/* compiled from: EntityInsertionAdapter */
public abstract class b<T> extends o {
    /* access modifiers changed from: protected */
    public abstract void a(f fVar, T t);

    public b(i iVar) {
        super(iVar);
    }

    public final void a(T t) {
        f c = c();
        try {
            a(c, t);
            c.b();
        } finally {
            a(c);
        }
    }
}
