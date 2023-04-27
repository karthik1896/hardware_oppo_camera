package com.oppo.camera.p.a;

/* compiled from: RevGrayScale */
class g implements a {
    g() {
    }

    public byte[] a(byte[] bArr, int i, int i2) {
        for (int i3 = 0; i3 < i * i2; i3++) {
            bArr[i3] = (byte) ((255 - bArr[i3]) & 255);
        }
        return bArr;
    }
}
