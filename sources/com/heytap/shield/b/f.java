package com.heytap.shield.b;

/* compiled from: ParseUtils */
public class f {
    public static byte[] a(byte[] bArr) {
        return new byte[]{bArr[0]};
    }

    public static byte[] b(byte[] bArr) {
        byte[] bArr2 = new byte[4];
        h.a(bArr, bArr.length - 4, bArr2, 0, 4);
        return bArr2;
    }

    public static byte[] a(byte[] bArr, int i) {
        byte[] bArr2 = new byte[i];
        h.a(bArr, (bArr.length - i) - 4, bArr2, 0, i);
        return bArr2;
    }

    public static byte[] b(byte[] bArr, int i) {
        byte[] bArr2 = new byte[4];
        h.a(bArr, (bArr.length - i) - 8, bArr2, 0, 4);
        return bArr2;
    }

    public static byte[] c(byte[] bArr, int i) {
        byte[] bArr2 = new byte[((bArr.length - i) - 9)];
        h.a(bArr, 1, bArr2, 0, (bArr.length - i) - 9);
        return bArr2;
    }
}
