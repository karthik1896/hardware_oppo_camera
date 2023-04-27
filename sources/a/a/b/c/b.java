package a.a.b.c;

import java.util.ArrayList;
import java.util.Arrays;

public class b {

    /* renamed from: a  reason: collision with root package name */
    public float[] f25a;

    /* renamed from: b  reason: collision with root package name */
    public float[] f26b;
    public float[] c;

    public b(float[] fArr, float[] fArr2) {
        float f;
        ArrayList arrayList;
        float[] fArr3 = fArr;
        float[] fArr4 = fArr2;
        int length = fArr3.length;
        float[] fArr5 = new float[length];
        float[] fArr6 = new float[length];
        float[] fArr7 = new float[length];
        float[] fArr8 = new float[length];
        float[] fArr9 = new float[length];
        float[] fArr10 = new float[length];
        int i = length - 1;
        int i2 = 0;
        while (true) {
            if (i < 0) {
                if (i2 <= i) {
                    break;
                }
            } else if (i2 >= i) {
                break;
            }
            int i3 = i2 + 1;
            fArr5[i2] = (fArr4[i3] - fArr4[i2]) / (fArr3[i3] - fArr3[i2]);
            if (i2 > 0) {
                fArr6[i2] = (fArr5[i2 - 1] + fArr5[i2]) / 2.0f;
            }
            i2 = i >= 0 ? i3 : i2 - 1;
        }
        fArr6[0] = fArr5[0];
        fArr6[i] = fArr5[length - 2];
        ArrayList arrayList2 = new ArrayList();
        int i4 = 0;
        while (true) {
            f = 0.0f;
            if (i < 0) {
                if (i4 <= i) {
                    break;
                }
            } else if (i4 >= i) {
                break;
            }
            if (fArr5[i4] == 0.0f) {
                arrayList2.add(Integer.valueOf(i4));
            }
            i4 = i >= 0 ? i4 + 1 : i4 - 1;
        }
        int size = arrayList2.size();
        for (int i5 = 0; i5 < size; i5++) {
            int intValue = ((Integer) arrayList2.get(i5)).intValue();
            fArr6[intValue + 1] = 0.0f;
            fArr6[intValue] = 0.0f;
        }
        int i6 = 0;
        while (true) {
            if (i < 0) {
                if (i6 <= i) {
                    break;
                }
            } else if (i6 >= i) {
                break;
            }
            fArr7[i6] = fArr5[i6] == f ? f : fArr6[i6] / fArr5[i6];
            fArr8[i6] = fArr5[i6] == f ? f : fArr6[i6 + 1] / fArr5[i6];
            ArrayList arrayList3 = arrayList2;
            fArr9[i6] = ((float) Math.pow((double) fArr7[i6], 2.0d)) + ((float) Math.pow((double) fArr8[i6], 2.0d));
            float sqrt = (float) Math.sqrt((double) fArr9[i6]);
            fArr10[i6] = sqrt == 0.0f ? 0.0f : 3.0f / sqrt;
            i6 = i >= 0 ? i6 + 1 : i6 - 1;
            f = 0.0f;
            arrayList2 = arrayList3;
            float[] fArr11 = fArr;
        }
        ArrayList arrayList4 = arrayList2;
        arrayList4.clear();
        int i7 = 0;
        int i8 = 0;
        while (true) {
            if (i < 0) {
                if (i7 <= i) {
                    break;
                }
            } else if (i7 >= i) {
                break;
            }
            if (fArr9[i8] > 9.0f) {
                arrayList = arrayList4;
                arrayList.add(Integer.valueOf(i8));
            } else {
                arrayList = arrayList4;
            }
            i8 = i >= 0 ? i7 + 1 : i7 - 1;
            i7 = i8;
            arrayList4 = arrayList;
        }
        ArrayList arrayList5 = arrayList4;
        int size2 = arrayList5.size();
        for (int i9 = 0; i9 < size2; i9++) {
            int intValue2 = ((Integer) arrayList5.get(i9)).intValue();
            fArr6[intValue2] = fArr10[intValue2] * fArr7[intValue2] * fArr5[intValue2];
            fArr6[intValue2 + 1] = fArr10[intValue2] * fArr8[intValue2] * fArr5[intValue2];
        }
        this.f25a = Arrays.copyOf(fArr, length);
        this.f26b = Arrays.copyOf(fArr4, length);
        this.c = fArr6;
    }

    public float a(int i) {
        int length = this.f25a.length - 2;
        int i2 = length;
        while (true) {
            if (length > 0) {
                if (i2 < 0) {
                    break;
                }
            } else if (i2 > 0) {
                break;
            }
            if (this.f25a[i2] <= ((float) i)) {
                break;
            }
            i2 = length <= 0 ? i2 + 1 : i2 - 1;
        }
        float[] fArr = this.f25a;
        int i3 = i2 + 1;
        float f = fArr[i3] - fArr[i2];
        float f2 = (((float) i) - fArr[i2]) / f;
        double d = (double) f2;
        float pow = (float) Math.pow(d, 2.0d);
        float pow2 = (float) Math.pow(d, 3.0d);
        float f3 = 3.0f * pow;
        float[] fArr2 = this.f26b;
        float f4 = fArr2[i2];
        float[] fArr3 = this.c;
        return ((((pow2 * 2.0f) - f3) + 1.0f) * f4) + (((pow2 - (2.0f * pow)) + f2) * f * fArr3[i2]) + (((-2.0f * pow2) + f3) * fArr2[i3]) + ((pow2 - pow) * f * fArr3[i3]);
    }
}
