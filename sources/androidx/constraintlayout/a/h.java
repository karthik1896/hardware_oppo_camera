package androidx.constraintlayout.a;

import java.util.Arrays;

/* compiled from: SolverVariable */
public class h {
    private static int j = 1;
    private static int k = 1;
    private static int l = 1;
    private static int m = 1;
    private static int n = 1;

    /* renamed from: a  reason: collision with root package name */
    public int f545a = -1;

    /* renamed from: b  reason: collision with root package name */
    int f546b = -1;
    public int c = 0;
    public float d;
    float[] e = new float[7];
    a f;
    b[] g = new b[8];
    int h = 0;
    public int i = 0;
    private String o;

    /* compiled from: SolverVariable */
    public enum a {
        UNRESTRICTED,
        CONSTANT,
        SLACK,
        ERROR,
        UNKNOWN
    }

    static void a() {
        k++;
    }

    public h(a aVar, String str) {
        this.f = aVar;
    }

    public final void a(b bVar) {
        int i2 = 0;
        while (true) {
            int i3 = this.h;
            if (i2 >= i3) {
                b[] bVarArr = this.g;
                if (i3 >= bVarArr.length) {
                    this.g = (b[]) Arrays.copyOf(bVarArr, bVarArr.length * 2);
                }
                b[] bVarArr2 = this.g;
                int i4 = this.h;
                bVarArr2[i4] = bVar;
                this.h = i4 + 1;
                return;
            } else if (this.g[i2] != bVar) {
                i2++;
            } else {
                return;
            }
        }
    }

    public final void b(b bVar) {
        int i2 = this.h;
        for (int i3 = 0; i3 < i2; i3++) {
            if (this.g[i3] == bVar) {
                for (int i4 = 0; i4 < (i2 - i3) - 1; i4++) {
                    b[] bVarArr = this.g;
                    int i5 = i3 + i4;
                    bVarArr[i5] = bVarArr[i5 + 1];
                }
                this.h--;
                return;
            }
        }
    }

    public final void c(b bVar) {
        int i2 = this.h;
        for (int i3 = 0; i3 < i2; i3++) {
            this.g[i3].d.a(this.g[i3], bVar, false);
        }
        this.h = 0;
    }

    public void b() {
        this.o = null;
        this.f = a.UNKNOWN;
        this.c = 0;
        this.f545a = -1;
        this.f546b = -1;
        this.d = 0.0f;
        this.h = 0;
        this.i = 0;
    }

    public void a(a aVar, String str) {
        this.f = aVar;
    }

    public String toString() {
        return "" + this.o;
    }
}
