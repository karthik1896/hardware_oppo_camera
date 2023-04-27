package androidx.constraintlayout.a;

import androidx.constraintlayout.a.h;
import java.util.Arrays;

/* compiled from: ArrayLinkedVariables */
public class a {

    /* renamed from: a  reason: collision with root package name */
    int f513a = 0;

    /* renamed from: b  reason: collision with root package name */
    private final b f514b;
    private final c c;
    private int d = 8;
    private h e = null;
    private int[] f;
    private int[] g;
    private float[] h;
    private int i;
    private int j;
    private boolean k;

    a(b bVar, c cVar) {
        int i2 = this.d;
        this.f = new int[i2];
        this.g = new int[i2];
        this.h = new float[i2];
        this.i = -1;
        this.j = -1;
        this.k = false;
        this.f514b = bVar;
        this.c = cVar;
    }

    public final void a(h hVar, float f2) {
        if (f2 == 0.0f) {
            a(hVar, true);
            return;
        }
        int i2 = this.i;
        if (i2 == -1) {
            this.i = 0;
            float[] fArr = this.h;
            int i3 = this.i;
            fArr[i3] = f2;
            this.f[i3] = hVar.f545a;
            this.g[this.i] = -1;
            hVar.i++;
            hVar.a(this.f514b);
            this.f513a++;
            if (!this.k) {
                this.j++;
                int i4 = this.j;
                int[] iArr = this.f;
                if (i4 >= iArr.length) {
                    this.k = true;
                    this.j = iArr.length - 1;
                    return;
                }
                return;
            }
            return;
        }
        int i5 = 0;
        int i6 = -1;
        while (i2 != -1 && i5 < this.f513a) {
            if (this.f[i2] == hVar.f545a) {
                this.h[i2] = f2;
                return;
            }
            if (this.f[i2] < hVar.f545a) {
                i6 = i2;
            }
            i2 = this.g[i2];
            i5++;
        }
        int i7 = this.j;
        int i8 = i7 + 1;
        if (this.k) {
            int[] iArr2 = this.f;
            if (iArr2[i7] != -1) {
                i7 = iArr2.length;
            }
        } else {
            i7 = i8;
        }
        int[] iArr3 = this.f;
        if (i7 >= iArr3.length && this.f513a < iArr3.length) {
            int i9 = 0;
            while (true) {
                int[] iArr4 = this.f;
                if (i9 >= iArr4.length) {
                    break;
                } else if (iArr4[i9] == -1) {
                    i7 = i9;
                    break;
                } else {
                    i9++;
                }
            }
        }
        int[] iArr5 = this.f;
        if (i7 >= iArr5.length) {
            i7 = iArr5.length;
            this.d *= 2;
            this.k = false;
            this.j = i7 - 1;
            this.h = Arrays.copyOf(this.h, this.d);
            this.f = Arrays.copyOf(this.f, this.d);
            this.g = Arrays.copyOf(this.g, this.d);
        }
        this.f[i7] = hVar.f545a;
        this.h[i7] = f2;
        if (i6 != -1) {
            int[] iArr6 = this.g;
            iArr6[i7] = iArr6[i6];
            iArr6[i6] = i7;
        } else {
            this.g[i7] = this.i;
            this.i = i7;
        }
        hVar.i++;
        hVar.a(this.f514b);
        this.f513a++;
        if (!this.k) {
            this.j++;
        }
        if (this.f513a >= this.f.length) {
            this.k = true;
        }
        int i10 = this.j;
        int[] iArr7 = this.f;
        if (i10 >= iArr7.length) {
            this.k = true;
            this.j = iArr7.length - 1;
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(h hVar, float f2, boolean z) {
        if (f2 != 0.0f) {
            int i2 = this.i;
            if (i2 == -1) {
                this.i = 0;
                float[] fArr = this.h;
                int i3 = this.i;
                fArr[i3] = f2;
                this.f[i3] = hVar.f545a;
                this.g[this.i] = -1;
                hVar.i++;
                hVar.a(this.f514b);
                this.f513a++;
                if (!this.k) {
                    this.j++;
                    int i4 = this.j;
                    int[] iArr = this.f;
                    if (i4 >= iArr.length) {
                        this.k = true;
                        this.j = iArr.length - 1;
                        return;
                    }
                    return;
                }
                return;
            }
            int i5 = 0;
            int i6 = -1;
            while (i2 != -1 && i5 < this.f513a) {
                if (this.f[i2] == hVar.f545a) {
                    float[] fArr2 = this.h;
                    fArr2[i2] = fArr2[i2] + f2;
                    if (fArr2[i2] == 0.0f) {
                        if (i2 == this.i) {
                            this.i = this.g[i2];
                        } else {
                            int[] iArr2 = this.g;
                            iArr2[i6] = iArr2[i2];
                        }
                        if (z) {
                            hVar.b(this.f514b);
                        }
                        if (this.k) {
                            this.j = i2;
                        }
                        hVar.i--;
                        this.f513a--;
                        return;
                    }
                    return;
                }
                if (this.f[i2] < hVar.f545a) {
                    i6 = i2;
                }
                i2 = this.g[i2];
                i5++;
            }
            int i7 = this.j;
            int i8 = i7 + 1;
            if (this.k) {
                int[] iArr3 = this.f;
                if (iArr3[i7] != -1) {
                    i7 = iArr3.length;
                }
            } else {
                i7 = i8;
            }
            int[] iArr4 = this.f;
            if (i7 >= iArr4.length && this.f513a < iArr4.length) {
                int i9 = 0;
                while (true) {
                    int[] iArr5 = this.f;
                    if (i9 >= iArr5.length) {
                        break;
                    } else if (iArr5[i9] == -1) {
                        i7 = i9;
                        break;
                    } else {
                        i9++;
                    }
                }
            }
            int[] iArr6 = this.f;
            if (i7 >= iArr6.length) {
                i7 = iArr6.length;
                this.d *= 2;
                this.k = false;
                this.j = i7 - 1;
                this.h = Arrays.copyOf(this.h, this.d);
                this.f = Arrays.copyOf(this.f, this.d);
                this.g = Arrays.copyOf(this.g, this.d);
            }
            this.f[i7] = hVar.f545a;
            this.h[i7] = f2;
            if (i6 != -1) {
                int[] iArr7 = this.g;
                iArr7[i7] = iArr7[i6];
                iArr7[i6] = i7;
            } else {
                this.g[i7] = this.i;
                this.i = i7;
            }
            hVar.i++;
            hVar.a(this.f514b);
            this.f513a++;
            if (!this.k) {
                this.j++;
            }
            int i10 = this.j;
            int[] iArr8 = this.f;
            if (i10 >= iArr8.length) {
                this.k = true;
                this.j = iArr8.length - 1;
            }
        }
    }

    public final float a(h hVar, boolean z) {
        if (this.e == hVar) {
            this.e = null;
        }
        int i2 = this.i;
        if (i2 == -1) {
            return 0.0f;
        }
        int i3 = 0;
        int i4 = -1;
        while (i2 != -1 && i3 < this.f513a) {
            if (this.f[i2] == hVar.f545a) {
                if (i2 == this.i) {
                    this.i = this.g[i2];
                } else {
                    int[] iArr = this.g;
                    iArr[i4] = iArr[i2];
                }
                if (z) {
                    hVar.b(this.f514b);
                }
                hVar.i--;
                this.f513a--;
                this.f[i2] = -1;
                if (this.k) {
                    this.j = i2;
                }
                return this.h[i2];
            }
            i3++;
            i4 = i2;
            i2 = this.g[i2];
        }
        return 0.0f;
    }

    public final void a() {
        int i2 = this.i;
        int i3 = 0;
        while (i2 != -1 && i3 < this.f513a) {
            h hVar = this.c.c[this.f[i2]];
            if (hVar != null) {
                hVar.b(this.f514b);
            }
            i2 = this.g[i2];
            i3++;
        }
        this.i = -1;
        this.j = -1;
        this.k = false;
        this.f513a = 0;
    }

    /* access modifiers changed from: package-private */
    public final boolean a(h hVar) {
        int i2 = this.i;
        if (i2 == -1) {
            return false;
        }
        int i3 = 0;
        while (i2 != -1 && i3 < this.f513a) {
            if (this.f[i2] == hVar.f545a) {
                return true;
            }
            i2 = this.g[i2];
            i3++;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public void b() {
        int i2 = this.i;
        int i3 = 0;
        while (i2 != -1 && i3 < this.f513a) {
            float[] fArr = this.h;
            fArr[i2] = fArr[i2] * -1.0f;
            i2 = this.g[i2];
            i3++;
        }
    }

    /* access modifiers changed from: package-private */
    public void a(float f2) {
        int i2 = this.i;
        int i3 = 0;
        while (i2 != -1 && i3 < this.f513a) {
            float[] fArr = this.h;
            fArr[i2] = fArr[i2] / f2;
            i2 = this.g[i2];
            i3++;
        }
    }

    private boolean a(h hVar, e eVar) {
        return hVar.i <= 1;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x004a  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0093 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public androidx.constraintlayout.a.h a(androidx.constraintlayout.a.e r15) {
        /*
            r14 = this;
            int r0 = r14.i
            r1 = 0
            r2 = 0
            r3 = 0
            r4 = r1
            r6 = r2
            r8 = r6
            r5 = r3
            r7 = r5
        L_0x000a:
            r9 = -1
            if (r0 == r9) goto L_0x009b
            int r9 = r14.f513a
            if (r2 >= r9) goto L_0x009b
            float[] r9 = r14.h
            r9 = r9[r0]
            r10 = 981668463(0x3a83126f, float:0.001)
            androidx.constraintlayout.a.c r11 = r14.c
            androidx.constraintlayout.a.h[] r11 = r11.c
            int[] r12 = r14.f
            r12 = r12[r0]
            r11 = r11[r12]
            int r12 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
            if (r12 >= 0) goto L_0x0037
            r10 = -1165815185(0xffffffffba83126f, float:-0.001)
            int r10 = (r9 > r10 ? 1 : (r9 == r10 ? 0 : -1))
            if (r10 <= 0) goto L_0x0045
            float[] r9 = r14.h
            r9[r0] = r3
            androidx.constraintlayout.a.b r9 = r14.f514b
            r11.b(r9)
            goto L_0x0044
        L_0x0037:
            int r10 = (r9 > r10 ? 1 : (r9 == r10 ? 0 : -1))
            if (r10 >= 0) goto L_0x0045
            float[] r9 = r14.h
            r9[r0] = r3
            androidx.constraintlayout.a.b r9 = r14.f514b
            r11.b(r9)
        L_0x0044:
            r9 = r3
        L_0x0045:
            int r10 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
            r12 = 1
            if (r10 == 0) goto L_0x0093
            androidx.constraintlayout.a.h$a r10 = r11.f
            androidx.constraintlayout.a.h$a r13 = androidx.constraintlayout.a.h.a.UNRESTRICTED
            if (r10 != r13) goto L_0x006f
            if (r4 != 0) goto L_0x005a
            boolean r4 = r14.a((androidx.constraintlayout.a.h) r11, (androidx.constraintlayout.a.e) r15)
        L_0x0056:
            r6 = r4
            r5 = r9
            r4 = r11
            goto L_0x0093
        L_0x005a:
            int r10 = (r5 > r9 ? 1 : (r5 == r9 ? 0 : -1))
            if (r10 <= 0) goto L_0x0063
            boolean r4 = r14.a((androidx.constraintlayout.a.h) r11, (androidx.constraintlayout.a.e) r15)
            goto L_0x0056
        L_0x0063:
            if (r6 != 0) goto L_0x0093
            boolean r10 = r14.a((androidx.constraintlayout.a.h) r11, (androidx.constraintlayout.a.e) r15)
            if (r10 == 0) goto L_0x0093
            r5 = r9
            r4 = r11
            r6 = r12
            goto L_0x0093
        L_0x006f:
            if (r4 != 0) goto L_0x0093
            int r10 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
            if (r10 >= 0) goto L_0x0093
            if (r1 != 0) goto L_0x007f
            boolean r1 = r14.a((androidx.constraintlayout.a.h) r11, (androidx.constraintlayout.a.e) r15)
        L_0x007b:
            r8 = r1
            r7 = r9
            r1 = r11
            goto L_0x0093
        L_0x007f:
            int r10 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r10 <= 0) goto L_0x0088
            boolean r1 = r14.a((androidx.constraintlayout.a.h) r11, (androidx.constraintlayout.a.e) r15)
            goto L_0x007b
        L_0x0088:
            if (r8 != 0) goto L_0x0093
            boolean r10 = r14.a((androidx.constraintlayout.a.h) r11, (androidx.constraintlayout.a.e) r15)
            if (r10 == 0) goto L_0x0093
            r7 = r9
            r1 = r11
            r8 = r12
        L_0x0093:
            int[] r9 = r14.g
            r0 = r9[r0]
            int r2 = r2 + 1
            goto L_0x000a
        L_0x009b:
            if (r4 == 0) goto L_0x009e
            return r4
        L_0x009e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.a.a.a(androidx.constraintlayout.a.e):androidx.constraintlayout.a.h");
    }

    /* access modifiers changed from: package-private */
    public final void a(b bVar, b bVar2, boolean z) {
        int i2 = this.i;
        while (true) {
            int i3 = 0;
            while (i2 != -1 && i3 < this.f513a) {
                if (this.f[i2] == bVar2.f535a.f545a) {
                    float f2 = this.h[i2];
                    a(bVar2.f535a, z);
                    a aVar = bVar2.d;
                    int i4 = aVar.i;
                    int i5 = 0;
                    while (i4 != -1 && i5 < aVar.f513a) {
                        a(this.c.c[aVar.f[i4]], aVar.h[i4] * f2, z);
                        i4 = aVar.g[i4];
                        i5++;
                    }
                    bVar.f536b += bVar2.f536b * f2;
                    if (z) {
                        bVar2.f535a.b(bVar);
                    }
                    i2 = this.i;
                } else {
                    i2 = this.g[i2];
                    i3++;
                }
            }
            return;
        }
    }

    /* access modifiers changed from: package-private */
    public void a(b bVar, b[] bVarArr) {
        int i2 = this.i;
        while (true) {
            int i3 = 0;
            while (i2 != -1 && i3 < this.f513a) {
                h hVar = this.c.c[this.f[i2]];
                if (hVar.f546b != -1) {
                    float f2 = this.h[i2];
                    a(hVar, true);
                    b bVar2 = bVarArr[hVar.f546b];
                    if (!bVar2.e) {
                        a aVar = bVar2.d;
                        int i4 = aVar.i;
                        int i5 = 0;
                        while (i4 != -1 && i5 < aVar.f513a) {
                            a(this.c.c[aVar.f[i4]], aVar.h[i4] * f2, true);
                            i4 = aVar.g[i4];
                            i5++;
                        }
                    }
                    bVar.f536b += bVar2.f536b * f2;
                    bVar2.f535a.b(bVar);
                    i2 = this.i;
                } else {
                    i2 = this.g[i2];
                    i3++;
                }
            }
            return;
        }
    }

    /* access modifiers changed from: package-private */
    public h a(boolean[] zArr, h hVar) {
        int i2 = this.i;
        int i3 = 0;
        h hVar2 = null;
        float f2 = 0.0f;
        while (i2 != -1 && i3 < this.f513a) {
            if (this.h[i2] < 0.0f) {
                h hVar3 = this.c.c[this.f[i2]];
                if ((zArr == null || !zArr[hVar3.f545a]) && hVar3 != hVar && (hVar3.f == h.a.SLACK || hVar3.f == h.a.ERROR)) {
                    float f3 = this.h[i2];
                    if (f3 < f2) {
                        hVar2 = hVar3;
                        f2 = f3;
                    }
                }
            }
            i2 = this.g[i2];
            i3++;
        }
        return hVar2;
    }

    /* access modifiers changed from: package-private */
    public final h a(int i2) {
        int i3 = this.i;
        int i4 = 0;
        while (i3 != -1 && i4 < this.f513a) {
            if (i4 == i2) {
                return this.c.c[this.f[i3]];
            }
            i3 = this.g[i3];
            i4++;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public final float b(int i2) {
        int i3 = this.i;
        int i4 = 0;
        while (i3 != -1 && i4 < this.f513a) {
            if (i4 == i2) {
                return this.h[i3];
            }
            i3 = this.g[i3];
            i4++;
        }
        return 0.0f;
    }

    public final float b(h hVar) {
        int i2 = this.i;
        int i3 = 0;
        while (i2 != -1 && i3 < this.f513a) {
            if (this.f[i2] == hVar.f545a) {
                return this.h[i2];
            }
            i2 = this.g[i2];
            i3++;
        }
        return 0.0f;
    }

    public String toString() {
        int i2 = this.i;
        String str = "";
        int i3 = 0;
        while (i2 != -1 && i3 < this.f513a) {
            str = ((str + " -> ") + this.h[i2] + " : ") + this.c.c[this.f[i2]];
            i2 = this.g[i2];
            i3++;
        }
        return str;
    }
}
