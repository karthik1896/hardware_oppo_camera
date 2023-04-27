package a.a.b.c;

import java.util.Arrays;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public float[] f23a;

    /* renamed from: b  reason: collision with root package name */
    public float[] f24b;
    public float[] c;
    public float[] d;
    public float[] e;

    public a(float[] fArr, float[] fArr2, Float f, Float f2) {
        float[] fArr3 = fArr;
        float[] fArr4 = fArr2;
        if (fArr3 != null && fArr4 != null) {
            boolean z = (f == null || f2 == null) ? false : true;
            int length = fArr3.length - 1;
            float[] fArr5 = new float[length];
            float[] fArr6 = new float[length];
            float[] fArr7 = new float[fArr3.length];
            float[] fArr8 = new float[length];
            float[] fArr9 = new float[fArr3.length];
            float[] fArr10 = new float[fArr3.length];
            float[] fArr11 = new float[length];
            float[] fArr12 = new float[length];
            float[] fArr13 = new float[length];
            float[] fArr14 = new float[length];
            int i = 0;
            int i2 = 0;
            while (true) {
                if (length < 0) {
                    if (i <= length) {
                        break;
                    }
                } else if (i >= length) {
                    break;
                }
                int i3 = i2 + 1;
                fArr5[i2] = fArr3[i3] - fArr3[i2];
                fArr13[i2] = fArr4[i3] - fArr4[i2];
                fArr14[i2] = fArr13[i2] / fArr5[i2];
                i2 = length >= 0 ? i + 1 : i - 1;
                i = i2;
            }
            if (z) {
                fArr6[0] = (((fArr4[1] - fArr4[0]) * 3.0f) / fArr5[0]) - (f.floatValue() * 3.0f);
                int i4 = length - 1;
                fArr6[length] = (f2.floatValue() * 3.0f) - (((fArr4[length] - fArr4[i4]) * 3.0f) / fArr5[i4]);
            }
            int i5 = 1;
            int i6 = 1;
            int i7 = 1;
            while (true) {
                if (i5 > length) {
                    if (i6 <= length) {
                        break;
                    }
                } else if (i6 >= length) {
                    break;
                }
                int i8 = i7 - 1;
                fArr6[i7] = ((3.0f / fArr5[i7]) * (fArr4[i7 + 1] - fArr4[i7])) - ((3.0f / fArr5[i8]) * (fArr4[i7] - fArr4[i8]));
                i7 = 1 <= length ? i6 + 1 : i6 - 1;
                i6 = i7;
                i5 = 1;
            }
            if (z) {
                fArr7[0] = fArr5[0] * 2.0f;
                fArr8[0] = 0.5f;
                fArr9[0] = fArr6[0] / fArr7[0];
            } else {
                fArr7[0] = 1.0f;
                fArr8[0] = 0.0f;
                fArr9[0] = 0.0f;
            }
            int i9 = 1;
            int i10 = 1;
            int i11 = 1;
            while (true) {
                if (i9 > length) {
                    if (i10 <= length) {
                        break;
                    }
                } else if (i10 >= length) {
                    break;
                }
                int i12 = i11 - 1;
                fArr7[i11] = ((fArr3[i11 + 1] - fArr3[i12]) * 2.0f) - (fArr5[i12] * fArr8[i12]);
                fArr8[i11] = fArr5[i11] / fArr7[i11];
                fArr9[i11] = (fArr6[i11] - (fArr5[i12] * fArr9[i12])) / fArr7[i11];
                i9 = 1;
                i11 = 1 <= length ? i10 + 1 : i10 - 1;
                i10 = i11;
            }
            if (z) {
                int i13 = length - 1;
                fArr7[length] = fArr5[i13] * (2.0f - fArr8[i13]);
                fArr9[length] = (fArr6[length] - (fArr5[i13] * fArr9[i13])) / fArr7[length];
                fArr10[length] = fArr9[length];
            } else {
                fArr7[length] = 1.0f;
                fArr9[length] = 0.0f;
                fArr10[length] = 0.0f;
            }
            int i14 = length - 1;
            int i15 = i14;
            while (true) {
                if (i14 > 0) {
                    if (i15 < 0) {
                        break;
                    }
                } else if (i15 > 0) {
                    break;
                }
                int i16 = i15 + 1;
                fArr10[i15] = fArr9[i15] - (fArr8[i15] * fArr10[i16]);
                fArr11[i15] = ((fArr4[i16] - fArr4[i15]) / fArr5[i15]) - ((fArr5[i15] * (fArr10[i16] + (fArr10[i15] * 2.0f))) / 3.0f);
                fArr12[i15] = (fArr10[i16] - fArr10[i15]) / (fArr5[i15] * 3.0f);
                i15 = i14 <= 0 ? i16 : i15 - 1;
            }
            this.f23a = Arrays.copyOf(fArr3, length + 1);
            this.f24b = Arrays.copyOf(fArr4, length);
            this.c = fArr11;
            this.d = Arrays.copyOf(fArr10, length);
            this.e = fArr12;
        }
    }

    public float a(int i) {
        try {
            int length = this.f23a.length - 1;
            int i2 = length;
            while (true) {
                if (length > 0) {
                    if (i2 < 0) {
                        break;
                    }
                } else if (i2 > 0) {
                    break;
                }
                if (this.f23a[i2] <= ((float) i)) {
                    break;
                }
                i2 = length <= 0 ? i2 + 1 : i2 - 1;
            }
            float f = ((float) i) - this.f23a[i2];
            if (this.f24b.length <= i2) {
                return -1.0f;
            }
            if (this.d.length <= i2) {
                return -1.0f;
            }
            double d2 = (double) f;
            return (float) (((double) (this.f24b[i2] + (this.c[i2] * f))) + (((double) this.d[i2]) * Math.pow(d2, 2.0d)) + (((double) this.e[i2]) * Math.pow(d2, 3.0d)));
        } catch (Exception unused) {
            return -1.0f;
        }
    }
}
