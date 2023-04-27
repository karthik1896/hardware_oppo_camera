package androidx.recyclerview.widget;

/* compiled from: BatchingListUpdateCallback */
public class c implements l {

    /* renamed from: a  reason: collision with root package name */
    final l f1092a;

    /* renamed from: b  reason: collision with root package name */
    int f1093b = 0;
    int c = -1;
    int d = -1;
    Object e = null;

    public c(l lVar) {
        this.f1092a = lVar;
    }

    public void a() {
        int i = this.f1093b;
        if (i != 0) {
            if (i == 1) {
                this.f1092a.a(this.c, this.d);
            } else if (i == 2) {
                this.f1092a.b(this.c, this.d);
            } else if (i == 3) {
                this.f1092a.a(this.c, this.d, this.e);
            }
            this.e = null;
            this.f1093b = 0;
        }
    }

    public void a(int i, int i2) {
        int i3;
        if (this.f1093b == 1 && i >= (i3 = this.c)) {
            int i4 = this.d;
            if (i <= i3 + i4) {
                this.d = i4 + i2;
                this.c = Math.min(i, i3);
                return;
            }
        }
        a();
        this.c = i;
        this.d = i2;
        this.f1093b = 1;
    }

    public void b(int i, int i2) {
        int i3;
        if (this.f1093b != 2 || (i3 = this.c) < i || i3 > i + i2) {
            a();
            this.c = i;
            this.d = i2;
            this.f1093b = 2;
            return;
        }
        this.d += i2;
        this.c = i;
    }

    public void c(int i, int i2) {
        a();
        this.f1092a.c(i, i2);
    }

    public void a(int i, int i2, Object obj) {
        int i3;
        if (this.f1093b == 3) {
            int i4 = this.c;
            int i5 = this.d;
            if (i <= i4 + i5 && (i3 = i + i2) >= i4 && this.e == obj) {
                this.c = Math.min(i, i4);
                this.d = Math.max(i5 + i4, i3) - this.c;
                return;
            }
        }
        a();
        this.c = i;
        this.d = i2;
        this.e = obj;
        this.f1093b = 3;
    }
}
