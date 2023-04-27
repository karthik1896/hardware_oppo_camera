package androidx.appcompat.view;

import android.view.View;
import android.view.animation.Interpolator;
import androidx.core.g.aa;
import androidx.core.g.ab;
import androidx.core.g.z;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: ViewPropertyAnimatorCompatSet */
public class h {

    /* renamed from: a  reason: collision with root package name */
    final ArrayList<z> f234a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    aa f235b;
    private long c = -1;
    private Interpolator d;
    private boolean e;
    private final ab f = new ab() {

        /* renamed from: b  reason: collision with root package name */
        private boolean f237b = false;
        private int c = 0;

        public void a(View view) {
            if (!this.f237b) {
                this.f237b = true;
                if (h.this.f235b != null) {
                    h.this.f235b.a((View) null);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void a() {
            this.c = 0;
            this.f237b = false;
            h.this.b();
        }

        public void b(View view) {
            int i = this.c + 1;
            this.c = i;
            if (i == h.this.f234a.size()) {
                if (h.this.f235b != null) {
                    h.this.f235b.b((View) null);
                }
                a();
            }
        }
    };

    public h a(z zVar) {
        if (!this.e) {
            this.f234a.add(zVar);
        }
        return this;
    }

    public h a(z zVar, z zVar2) {
        this.f234a.add(zVar);
        zVar2.b(zVar.a());
        this.f234a.add(zVar2);
        return this;
    }

    public void a() {
        if (!this.e) {
            Iterator<z> it = this.f234a.iterator();
            while (it.hasNext()) {
                z next = it.next();
                long j = this.c;
                if (j >= 0) {
                    next.a(j);
                }
                Interpolator interpolator = this.d;
                if (interpolator != null) {
                    next.a(interpolator);
                }
                if (this.f235b != null) {
                    next.a((aa) this.f);
                }
                next.c();
            }
            this.e = true;
        }
    }

    /* access modifiers changed from: package-private */
    public void b() {
        this.e = false;
    }

    public void c() {
        if (this.e) {
            Iterator<z> it = this.f234a.iterator();
            while (it.hasNext()) {
                it.next().b();
            }
            this.e = false;
        }
    }

    public h a(long j) {
        if (!this.e) {
            this.c = j;
        }
        return this;
    }

    public h a(Interpolator interpolator) {
        if (!this.e) {
            this.d = interpolator;
        }
        return this;
    }

    public h a(aa aaVar) {
        if (!this.e) {
            this.f235b = aaVar;
        }
        return this;
    }
}
