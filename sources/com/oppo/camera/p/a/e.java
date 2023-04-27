package com.oppo.camera.p.a;

/* compiled from: OverDarkScale */
class e implements a {
    e() {
    }

    public byte[] a(byte[] bArr, int i, int i2) {
        double random = (Math.random() / 2.0d) + 0.4000000059604645d;
        for (int i3 = 0; i3 < i * i2; i3++) {
            bArr[i3] = (byte) ((int) (Math.pow((double) (((float) (bArr[i3] & 255)) / 255.0f), random) * 255.0d));
        }
        return bArr;
    }
}
