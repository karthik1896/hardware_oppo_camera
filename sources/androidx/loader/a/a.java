package androidx.loader.a;

import androidx.lifecycle.h;
import androidx.lifecycle.t;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* compiled from: LoaderManager */
public abstract class a {

    /* renamed from: androidx.loader.a.a$a  reason: collision with other inner class name */
    /* compiled from: LoaderManager */
    public interface C0031a<D> {
        void a(androidx.loader.b.a<D> aVar);

        void a(androidx.loader.b.a<D> aVar, D d);
    }

    public abstract void a();

    @Deprecated
    public abstract void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    public static <T extends h & t> a a(T t) {
        return new b(t, ((t) t).getViewModelStore());
    }
}
