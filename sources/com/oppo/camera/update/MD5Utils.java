package com.oppo.camera.update;

import com.oppo.camera.e;
import java.security.MessageDigest;

public class MD5Utils {
    private static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private static final String TAG = "MD5Utils";

    public static String getMD5(String str) {
        try {
            byte[] bytes = str.getBytes();
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(bytes);
            return toHexStringMd5(instance.digest());
        } catch (Exception e) {
            e.e(TAG, e.getMessage());
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002a, code lost:
        r1 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002b, code lost:
        r2 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x002f, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0030, code lost:
        r5 = r2;
        r2 = r1;
        r1 = r5;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String md5Sum(java.lang.String r6) {
        /*
            r0 = 0
            java.io.InputStream r6 = com.oppo.camera.q.a.e(r6)     // Catch:{ IOException -> 0x004c, NoSuchAlgorithmException -> 0x004a }
            if (r6 == 0) goto L_0x0044
            r1 = 8192(0x2000, float:1.14794E-41)
            byte[] r1 = new byte[r1]     // Catch:{ Throwable -> 0x002d, all -> 0x002a }
            java.lang.String r2 = "MD5"
            java.security.MessageDigest r2 = java.security.MessageDigest.getInstance(r2)     // Catch:{ Throwable -> 0x002d, all -> 0x002a }
        L_0x0011:
            int r3 = r6.read(r1)     // Catch:{ Throwable -> 0x002d, all -> 0x002a }
            if (r3 <= 0) goto L_0x001c
            r4 = 0
            r2.update(r1, r4, r3)     // Catch:{ Throwable -> 0x002d, all -> 0x002a }
            goto L_0x0011
        L_0x001c:
            byte[] r1 = r2.digest()     // Catch:{ Throwable -> 0x002d, all -> 0x002a }
            java.lang.String r1 = toHexStringMd5(r1)     // Catch:{ Throwable -> 0x002d, all -> 0x002a }
            if (r6 == 0) goto L_0x0029
            r6.close()     // Catch:{ IOException -> 0x004c, NoSuchAlgorithmException -> 0x004a }
        L_0x0029:
            return r1
        L_0x002a:
            r1 = move-exception
            r2 = r0
            goto L_0x0033
        L_0x002d:
            r1 = move-exception
            throw r1     // Catch:{ all -> 0x002f }
        L_0x002f:
            r2 = move-exception
            r5 = r2
            r2 = r1
            r1 = r5
        L_0x0033:
            if (r6 == 0) goto L_0x0043
            if (r2 == 0) goto L_0x0040
            r6.close()     // Catch:{ Throwable -> 0x003b }
            goto L_0x0043
        L_0x003b:
            r6 = move-exception
            r2.addSuppressed(r6)     // Catch:{ IOException -> 0x004c, NoSuchAlgorithmException -> 0x004a }
            goto L_0x0043
        L_0x0040:
            r6.close()     // Catch:{ IOException -> 0x004c, NoSuchAlgorithmException -> 0x004a }
        L_0x0043:
            throw r1     // Catch:{ IOException -> 0x004c, NoSuchAlgorithmException -> 0x004a }
        L_0x0044:
            if (r6 == 0) goto L_0x0050
            r6.close()     // Catch:{ IOException -> 0x004c, NoSuchAlgorithmException -> 0x004a }
            goto L_0x0050
        L_0x004a:
            r6 = move-exception
            goto L_0x004d
        L_0x004c:
            r6 = move-exception
        L_0x004d:
            r6.printStackTrace()
        L_0x0050:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.update.MD5Utils.md5Sum(java.lang.String):java.lang.String");
    }

    public static String toHexStringMd5(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        char[] cArr = new char[(r0 * 2)];
        int i = 0;
        for (byte b2 : bArr) {
            int i2 = i + 1;
            char[] cArr2 = HEX_DIGITS;
            cArr[i] = cArr2[(b2 >>> 4) & 15];
            i = i2 + 1;
            cArr[i2] = cArr2[b2 & 15];
        }
        return new String(cArr);
    }
}
