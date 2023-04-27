package com.oppo.camera.p.a;

/* compiled from: OverBrightScale */
class d implements a {
    d() {
    }

    public byte[] a(byte[] bArr, int i, int i2) {
        double random = (Math.random() * 10.0d) + 2.0d;
        for (int i3 = 0; i3 < i * i2; i3++) {
            bArr[i3] = (byte) ((int) (Math.pow((double) (((float) (bArr[i3] & 255)) / 255.0f), random) * 255.0d));
        }
        return bArr;
    }
}
