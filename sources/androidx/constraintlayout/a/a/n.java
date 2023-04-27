package androidx.constraintlayout.a.a;

/* compiled from: ResolutionDimension */
public class n extends o {

    /* renamed from: a  reason: collision with root package name */
    float f530a = 0.0f;

    public void b() {
        super.b();
        this.f530a = 0.0f;
    }

    public void a(int i) {
        if (this.i == 0 || this.f530a != ((float) i)) {
            this.f530a = (float) i;
            if (this.i == 1) {
                e();
            }
            f();
        }
    }

    public void c() {
        this.i = 2;
    }
}
