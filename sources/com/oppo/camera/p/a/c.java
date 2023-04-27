package com.oppo.camera.p.a;

/* compiled from: LightGreyScale */
class c implements a {
    c() {
    }

    public byte[] a(byte[] bArr, int i, int i2) {
        short random = (short) ((int) ((Math.random() * 5.0d) + 2.0d));
        for (int i3 = 0; i3 < i * i2; i3++) {
            bArr[i3] = (byte) (bArr[i3] * random);
        }
        return bArr;
    }
}
