package androidx.loader.a;

import android.os.Bundle;
import android.util.Log;
import androidx.collection.SparseArrayCompat;
import androidx.lifecycle.h;
import androidx.lifecycle.m;
import androidx.lifecycle.n;
import androidx.lifecycle.q;
import androidx.lifecycle.r;
import androidx.lifecycle.s;
import androidx.loader.a.a;
import androidx.loader.b.a;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* compiled from: LoaderManagerImpl */
class b extends a {

    /* renamed from: a  reason: collision with root package name */
    static boolean f935a = false;

    /* renamed from: b  reason: collision with root package name */
    private final h f936b;
    private final c c;

    /* compiled from: LoaderManagerImpl */
    public static class a<D> extends m<D> implements a.C0033a<D> {
        private final int e;
        private final Bundle f;
        private final androidx.loader.b.a<D> g;
        private h h;
        private C0032b<D> i;
        private androidx.loader.b.a<D> j;

        /* access modifiers changed from: package-private */
        public androidx.loader.b.a<D> e() {
            return this.g;
        }

        /* access modifiers changed from: protected */
        public void b() {
            if (b.f935a) {
                Log.v("LoaderManager", "  Starting: " + this);
            }
            this.g.a();
        }

        /* access modifiers changed from: protected */
        public void c() {
            if (b.f935a) {
                Log.v("LoaderManager", "  Stopping: " + this);
            }
            this.g.e();
        }

        /* access modifiers changed from: package-private */
        public void f() {
            h hVar = this.h;
            C0032b<D> bVar = this.i;
            if (hVar != null && bVar != null) {
                super.a(bVar);
                a(hVar, bVar);
            }
        }

        public void a(n<? super D> nVar) {
            super.a(nVar);
            this.h = null;
            this.i = null;
        }

        /* access modifiers changed from: package-private */
        public androidx.loader.b.a<D> a(boolean z) {
            if (b.f935a) {
                Log.v("LoaderManager", "  Destroying: " + this);
            }
            this.g.c();
            this.g.g();
            C0032b<D> bVar = this.i;
            if (bVar != null) {
                a(bVar);
                if (z) {
                    bVar.b();
                }
            }
            this.g.a(this);
            if ((bVar == null || bVar.a()) && !z) {
                return this.g;
            }
            this.g.i();
            return this.j;
        }

        public void a(D d) {
            super.a(d);
            androidx.loader.b.a<D> aVar = this.j;
            if (aVar != null) {
                aVar.i();
                this.j = null;
            }
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(64);
            sb.append("LoaderInfo{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(" #");
            sb.append(this.e);
            sb.append(" : ");
            androidx.core.f.a.a(this.g, sb);
            sb.append("}}");
            return sb.toString();
        }

        public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            printWriter.print(str);
            printWriter.print("mId=");
            printWriter.print(this.e);
            printWriter.print(" mArgs=");
            printWriter.println(this.f);
            printWriter.print(str);
            printWriter.print("mLoader=");
            printWriter.println(this.g);
            androidx.loader.b.a<D> aVar = this.g;
            aVar.a(str + "  ", fileDescriptor, printWriter, strArr);
            if (this.i != null) {
                printWriter.print(str);
                printWriter.print("mCallbacks=");
                printWriter.println(this.i);
                C0032b<D> bVar = this.i;
                bVar.a(str + "  ", printWriter);
            }
            printWriter.print(str);
            printWriter.print("mData=");
            printWriter.println(e().a(a()));
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.println(d());
        }
    }

    /* renamed from: androidx.loader.a.b$b  reason: collision with other inner class name */
    /* compiled from: LoaderManagerImpl */
    static class C0032b<D> implements n<D> {

        /* renamed from: a  reason: collision with root package name */
        private final androidx.loader.b.a<D> f937a;

        /* renamed from: b  reason: collision with root package name */
        private final a.C0031a<D> f938b;
        private boolean c;

        public void a(D d) {
            if (b.f935a) {
                Log.v("LoaderManager", "  onLoadFinished in " + this.f937a + ": " + this.f937a.a(d));
            }
            this.f938b.a(this.f937a, d);
            this.c = true;
        }

        /* access modifiers changed from: package-private */
        public boolean a() {
            return this.c;
        }

        /* access modifiers changed from: package-private */
        public void b() {
            if (this.c) {
                if (b.f935a) {
                    Log.v("LoaderManager", "  Resetting: " + this.f937a);
                }
                this.f938b.a(this.f937a);
            }
        }

        public String toString() {
            return this.f938b.toString();
        }

        public void a(String str, PrintWriter printWriter) {
            printWriter.print(str);
            printWriter.print("mDeliveredData=");
            printWriter.println(this.c);
        }
    }

    /* compiled from: LoaderManagerImpl */
    static class c extends q {

        /* renamed from: a  reason: collision with root package name */
        private static final r.a f939a = new r.a() {
            public <T extends q> T a(Class<T> cls) {
                return new c();
            }
        };

        /* renamed from: b  reason: collision with root package name */
        private SparseArrayCompat<a> f940b = new SparseArrayCompat<>();
        private boolean c = false;

        c() {
        }

        static c a(s sVar) {
            return (c) new r(sVar, f939a).a(c.class);
        }

        /* access modifiers changed from: package-private */
        public void b() {
            int size = this.f940b.size();
            for (int i = 0; i < size; i++) {
                this.f940b.valueAt(i).f();
            }
        }

        /* access modifiers changed from: protected */
        public void a() {
            super.a();
            int size = this.f940b.size();
            for (int i = 0; i < size; i++) {
                this.f940b.valueAt(i).a(true);
            }
            this.f940b.clear();
        }

        public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            if (this.f940b.size() > 0) {
                printWriter.print(str);
                printWriter.println("Loaders:");
                String str2 = str + "    ";
                for (int i = 0; i < this.f940b.size(); i++) {
                    a valueAt = this.f940b.valueAt(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(this.f940b.keyAt(i));
                    printWriter.print(": ");
                    printWriter.println(valueAt.toString());
                    valueAt.a(str2, fileDescriptor, printWriter, strArr);
                }
            }
        }
    }

    b(h hVar, s sVar) {
        this.f936b = hVar;
        this.c = c.a(sVar);
    }

    public void a() {
        this.c.b();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("LoaderManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        androidx.core.f.a.a(this.f936b, sb);
        sb.append("}}");
        return sb.toString();
    }

    @Deprecated
    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.c.a(str, fileDescriptor, printWriter, strArr);
    }
}
