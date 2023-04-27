package com.heytap.shield.b;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/* compiled from: SystemUtils */
public class h {
    static void a(Object obj, int i, Object obj2, int i2, int i3) {
        System.arraycopy(obj, i, obj2, i2, i3);
    }

    public static byte[] a(int i) {
        byte[] bArr = new byte[4];
        bArr[3] = (byte) ((i >> 24) & 255);
        bArr[2] = (byte) ((i >> 16) & 255);
        bArr[1] = (byte) ((i >> 8) & 255);
        bArr[0] = (byte) (i & 255);
        return bArr;
    }

    public static int a(byte[] bArr) {
        return ((bArr[3] & 255) << 24) | (bArr[0] & 255) | ((bArr[1] & 255) << 8) | ((bArr[2] & 255) << 16);
    }

    public static List<String> a(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        StringTokenizer stringTokenizer = new StringTokenizer(str, str2);
        while (stringTokenizer.hasMoreTokens()) {
            arrayList.add(stringTokenizer.nextToken());
        }
        return arrayList;
    }
}
