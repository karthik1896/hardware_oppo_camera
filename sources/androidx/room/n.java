package androidx.room;

import androidx.f.a.c;
import java.io.File;

/* compiled from: SQLiteCopyOpenHelperFactory */
class n implements c.C0029c {

    /* renamed from: a  reason: collision with root package name */
    private final String f1218a;

    /* renamed from: b  reason: collision with root package name */
    private final File f1219b;
    private final c.C0029c c;

    n(String str, File file, c.C0029c cVar) {
        this.f1218a = str;
        this.f1219b = file;
        this.c = cVar;
    }

    public c a(c.b bVar) {
        return new m(bVar.f825a, this.f1218a, this.f1219b, bVar.c.f824a, this.c.a(bVar));
    }
}
