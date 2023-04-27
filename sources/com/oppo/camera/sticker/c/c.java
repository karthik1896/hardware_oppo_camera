package com.oppo.camera.sticker.c;

import android.text.TextUtils;
import com.oppo.camera.e;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* compiled from: MD5Utils */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static final char[] f3644a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static String a(InputStream inputStream) throws NoSuchAlgorithmException, IOException {
        MessageDigest instance = MessageDigest.getInstance("MD5");
        if (inputStream != null) {
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    instance.update(bArr, 0, read);
                } else {
                    try {
                        break;
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            inputStream.close();
        }
        return a(instance.digest());
    }

    public static String a(String str) throws NoSuchAlgorithmException, IOException {
        return a((InputStream) new FileInputStream(str));
    }

    public static boolean a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            e.d("MD5Utils", "md5CheckSum, empty value! toBeCheckSum: " + str2);
            return false;
        }
        try {
            return a(str).equalsIgnoreCase(str2);
        } catch (NoSuchAlgorithmException e) {
            e.d("MD5Utils", "md5CheckSum, NoSuchAlgorithmException: " + e);
            return false;
        } catch (IOException e2) {
            e.d("MD5Utils", "md5CheckSum, IOException: " + e2);
            return false;
        }
    }

    public static String a(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (int i = 0; i < bArr.length; i++) {
            sb.append(f3644a[(bArr[i] & 240) >>> 4]);
            sb.append(f3644a[bArr[i] & 15]);
        }
        return sb.toString();
    }
}
