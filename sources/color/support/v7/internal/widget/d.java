package color.support.v7.internal.widget;

/* compiled from: RtlSpacingHelper */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private int f1545a = 0;

    /* renamed from: b  reason: collision with root package name */
    private int f1546b = 0;
    private int c = Integer.MIN_VALUE;
    private int d = Integer.MIN_VALUE;
    private int e = 0;
    private int f = 0;
    private boolean g = false;
    private boolean h = false;

    public int a() {
        return this.f1545a;
    }

    public int b() {
        return this.f1546b;
    }

    public int c() {
        return this.g ? this.f1546b : this.f1545a;
    }

    public int d() {
        return this.g ? this.f1545a : this.f1546b;
    }

    public void a(int i, int i2) {
        this.c = i;
        this.d = i2;
        this.h = true;
        if (this.g) {
            if (i2 != Integer.MIN_VALUE) {
                this.f1545a = i2;
            }
            if (i != Integer.MIN_VALUE) {
                this.f1546b = i;
                return;
            }
            return;
        }
        if (i != Integer.MIN_VALUE) {
            this.f1545a = i;
        }
        if (i2 != Integer.MIN_VALUE) {
            this.f1546b = i2;
        }
    }

    public void b(int i, int i2) {
        this.h = false;
        if (i != Integer.MIN_VALUE) {
            this.e = i;
            this.f1545a = i;
        }
        if (i2 != Integer.MIN_VALUE) {
            this.f = i2;
            this.f1546b = i2;
        }
    }

    public void a(boolean z) {
        if (z != this.g) {
            this.g = z;
            if (!this.h) {
                this.f1545a = this.e;
                this.f1546b = this.f;
            } else if (z) {
                int i = this.d;
                if (i == Integer.MIN_VALUE) {
                    i = this.e;
                }
                this.f1545a = i;
                int i2 = this.c;
                if (i2 == Integer.MIN_VALUE) {
                    i2 = this.f;
                }
                this.f1546b = i2;
            } else {
                int i3 = this.c;
                if (i3 == Integer.MIN_VALUE) {
                    i3 = this.e;
                }
                this.f1545a = i3;
                int i4 = this.d;
                if (i4 == Integer.MIN_VALUE) {
                    i4 = this.f;
                }
                this.f1546b = i4;
            }
        }
    }
}
