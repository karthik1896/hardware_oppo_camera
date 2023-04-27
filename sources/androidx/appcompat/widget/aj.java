package androidx.appcompat.widget;

/* compiled from: RtlSpacingHelper */
class aj {

    /* renamed from: a  reason: collision with root package name */
    private int f398a = 0;

    /* renamed from: b  reason: collision with root package name */
    private int f399b = 0;
    private int c = Integer.MIN_VALUE;
    private int d = Integer.MIN_VALUE;
    private int e = 0;
    private int f = 0;
    private boolean g = false;
    private boolean h = false;

    aj() {
    }

    public int a() {
        return this.f398a;
    }

    public int b() {
        return this.f399b;
    }

    public int c() {
        return this.g ? this.f399b : this.f398a;
    }

    public int d() {
        return this.g ? this.f398a : this.f399b;
    }

    public void a(int i, int i2) {
        this.c = i;
        this.d = i2;
        this.h = true;
        if (this.g) {
            if (i2 != Integer.MIN_VALUE) {
                this.f398a = i2;
            }
            if (i != Integer.MIN_VALUE) {
                this.f399b = i;
                return;
            }
            return;
        }
        if (i != Integer.MIN_VALUE) {
            this.f398a = i;
        }
        if (i2 != Integer.MIN_VALUE) {
            this.f399b = i2;
        }
    }

    public void b(int i, int i2) {
        this.h = false;
        if (i != Integer.MIN_VALUE) {
            this.e = i;
            this.f398a = i;
        }
        if (i2 != Integer.MIN_VALUE) {
            this.f = i2;
            this.f399b = i2;
        }
    }

    public void a(boolean z) {
        if (z != this.g) {
            this.g = z;
            if (!this.h) {
                this.f398a = this.e;
                this.f399b = this.f;
            } else if (z) {
                int i = this.d;
                if (i == Integer.MIN_VALUE) {
                    i = this.e;
                }
                this.f398a = i;
                int i2 = this.c;
                if (i2 == Integer.MIN_VALUE) {
                    i2 = this.f;
                }
                this.f399b = i2;
            } else {
                int i3 = this.c;
                if (i3 == Integer.MIN_VALUE) {
                    i3 = this.e;
                }
                this.f398a = i3;
                int i4 = this.d;
                if (i4 == Integer.MIN_VALUE) {
                    i4 = this.f;
                }
                this.f399b = i4;
            }
        }
    }
}
