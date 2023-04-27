package androidx.media;

import androidx.versionedparcelable.a;

public final class AudioAttributesImplBaseParcelizer {
    public static c read(a aVar) {
        c cVar = new c();
        cVar.f949a = aVar.b(cVar.f949a, 1);
        cVar.f950b = aVar.b(cVar.f950b, 2);
        cVar.c = aVar.b(cVar.c, 3);
        cVar.d = aVar.b(cVar.d, 4);
        return cVar;
    }

    public static void write(c cVar, a aVar) {
        aVar.a(false, false);
        aVar.a(cVar.f949a, 1);
        aVar.a(cVar.f950b, 2);
        aVar.a(cVar.c, 3);
        aVar.a(cVar.d, 4);
    }
}
