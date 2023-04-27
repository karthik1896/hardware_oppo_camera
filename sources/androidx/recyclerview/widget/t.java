package androidx.recyclerview.widget;

import android.view.View;

/* compiled from: ViewBoundsCheck */
class t {

    /* renamed from: a  reason: collision with root package name */
    final b f1157a;

    /* renamed from: b  reason: collision with root package name */
    a f1158b = new a();

    /* compiled from: ViewBoundsCheck */
    interface b {
        int a();

        int a(View view);

        View a(int i);

        int b();

        int b(View view);
    }

    t(b bVar) {
        this.f1157a = bVar;
    }

    /* compiled from: ViewBoundsCheck */
    static class a {

        /* renamed from: a  reason: collision with root package name */
        int f1159a = 0;

        /* renamed from: b  reason: collision with root package name */
        int f1160b;
        int c;
        int d;
        int e;

        /* access modifiers changed from: package-private */
        public int a(int i, int i2) {
            if (i > i2) {
                return 1;
            }
            return i == i2 ? 2 : 4;
        }

        a() {
        }

        /* access modifiers changed from: package-private */
        public void a(int i, int i2, int i3, int i4) {
            this.f1160b = i;
            this.c = i2;
            this.d = i3;
            this.e = i4;
        }

        /* access modifiers changed from: package-private */
        public void a(int i) {
            this.f1159a = i | this.f1159a;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            this.f1159a = 0;
        }

        /* access modifiers changed from: package-private */
        public boolean b() {
            int i = this.f1159a;
            if ((i & 7) != 0 && (i & (a(this.d, this.f1160b) << 0)) == 0) {
                return false;
            }
            int i2 = this.f1159a;
            if ((i2 & 112) != 0 && (i2 & (a(this.d, this.c) << 4)) == 0) {
                return false;
            }
            int i3 = this.f1159a;
            if ((i3 & 1792) != 0 && (i3 & (a(this.e, this.f1160b) << 8)) == 0) {
                return false;
            }
            int i4 = this.f1159a;
            if ((i4 & 28672) == 0 || (i4 & (a(this.e, this.c) << 12)) != 0) {
                return true;
            }
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public View a(int i, int i2, int i3, int i4) {
        int a2 = this.f1157a.a();
        int b2 = this.f1157a.b();
        int i5 = i2 > i ? 1 : -1;
        View view = null;
        while (i != i2) {
            View a3 = this.f1157a.a(i);
            this.f1158b.a(a2, b2, this.f1157a.a(a3), this.f1157a.b(a3));
            if (i3 != 0) {
                this.f1158b.a();
                this.f1158b.a(i3);
                if (this.f1158b.b()) {
                    return a3;
                }
            }
            if (i4 != 0) {
                this.f1158b.a();
                this.f1158b.a(i4);
                if (this.f1158b.b()) {
                    view = a3;
                }
            }
            i += i5;
        }
        return view;
    }

    /* access modifiers changed from: package-private */
    public boolean a(View view, int i) {
        this.f1158b.a(this.f1157a.a(), this.f1157a.b(), this.f1157a.a(view), this.f1157a.b(view));
        if (i == 0) {
            return false;
        }
        this.f1158b.a();
        this.f1158b.a(i);
        return this.f1158b.b();
    }
}
