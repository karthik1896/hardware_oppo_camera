package com.oppo.camera.p.a;

import android.graphics.Rect;

/* compiled from: InterruptGrayScale */
class b implements a {
    b() {
    }

    public byte[] a(byte[] bArr, int i, int i2) {
        int random = ((int) (Math.random() * 3.0d)) + 1;
        Rect rect = new Rect(0, 0, i, i2);
        for (int i3 = 0; i3 < random; i3++) {
            a(bArr, i, rect, i3);
            b(bArr, i, rect, i3);
        }
        return bArr;
    }

    private void a(byte[] bArr, int i, Rect rect, int i2) {
        Rect rect2 = rect;
        int i3 = rect2.top + i2;
        while (true) {
            int i4 = i3 + 2;
            if (i4 < rect2.bottom) {
                int i5 = rect2.left + i2;
                while (true) {
                    int i6 = i5 + 2;
                    if (i6 >= rect2.right) {
                        break;
                    }
                    int i7 = 0;
                    byte b2 = 2147483647;
                    int i8 = 0;
                    int i9 = i3;
                    while (i9 < i4) {
                        byte b3 = b2;
                        int i10 = i8;
                        int i11 = i7;
                        for (int i12 = i5; i12 < i6; i12++) {
                            int i13 = (i9 * i) + i12;
                            if ((bArr[i13] & 255) < 150) {
                                i11++;
                            }
                            i10 += bArr[i13] & 255;
                            if ((bArr[i13] & 255) < b3) {
                                b3 = bArr[i13] & 255;
                            }
                        }
                        i9++;
                        i7 = i11;
                        i8 = i10;
                        b2 = b3;
                    }
                    if (i7 != 0) {
                        int i14 = i8 / 4;
                        for (int i15 = i3; i15 < i4; i15++) {
                            for (int i16 = i5; i16 < i6; i16++) {
                                bArr[(i15 * i) + i16] = (byte) ((b2 / 5) * 4);
                            }
                        }
                    }
                    i5 = i6;
                }
                i3 = i4;
            } else {
                return;
            }
        }
    }

    private void b(byte[] bArr, int i, Rect rect, int i2) {
        int i3 = rect.top + i2;
        while (true) {
            int i4 = i3 + 2;
            if (i4 < rect.bottom) {
                int i5 = rect.left + i2;
                while (true) {
                    int i6 = i5 + 2;
                    if (i6 >= rect.right) {
                        break;
                    }
                    int i7 = 0;
                    byte b2 = 0;
                    int i8 = i3;
                    while (i8 < i4) {
                        byte b3 = b2;
                        int i9 = i7;
                        for (int i10 = i5; i10 < i6; i10++) {
                            int i11 = (i8 * i) + i10;
                            if ((bArr[i11] & 255) < 150) {
                                i9++;
                            }
                            if ((bArr[i11] & 255) > b3) {
                                b3 = bArr[i11] & 255;
                            }
                        }
                        i8++;
                        i7 = i9;
                        b2 = b3;
                    }
                    if (i7 <= 2) {
                        for (int i12 = i3; i12 < i4; i12++) {
                            for (int i13 = i5; i13 < i6; i13++) {
                                bArr[(i12 * i) + i13] = (byte) b2;
                            }
                        }
                    }
                    i5 = i6;
                }
                i3 = i4;
            } else {
                return;
            }
        }
    }
}
