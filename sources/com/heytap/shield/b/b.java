package com.heytap.shield.b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import android.os.Build;
import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Arrays;

/* compiled from: CertUtils */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static final String f2646a = "b";

    public static String a(Context context, String str) {
        return a(context, "SHA1", str);
    }

    public static String b(Context context, String str) {
        return a(context, "SHA256", str);
    }

    private static String a(Context context, String str, String str2) {
        if (Build.VERSION.SDK_INT < 28) {
            Signature[] d = d(context, str2);
            if (d == null || d.length <= 0) {
                return "";
            }
            return a(d[0].toByteArray(), str);
        }
        SigningInfo c = c(context, str2);
        if (c == null) {
            return "";
        }
        Signature[] apkContentsSigners = c.getApkContentsSigners();
        if (apkContentsSigners.length == 1) {
            return a(apkContentsSigners[0].toByteArray(), str);
        }
        if (!c.hasMultipleSigners()) {
            return a(apkContentsSigners[0].toByteArray(), str);
        }
        d.c("has multiple signers");
        String[] strArr = new String[apkContentsSigners.length];
        for (int i = 0; i < apkContentsSigners.length; i++) {
            strArr[i] = a(apkContentsSigners[i].toByteArray(), str);
        }
        Arrays.sort(strArr);
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < strArr.length; i2++) {
            if (i2 != strArr.length - 1) {
                sb.append(strArr[i2]);
                sb.append(":");
            } else {
                sb.append(strArr[i2]);
            }
        }
        return sb.toString();
    }

    @SuppressLint({"NewApi"})
    private static SigningInfo c(Context context, String str) {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 134217728);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            packageInfo = null;
        }
        if (packageInfo == null) {
            return null;
        }
        return packageInfo.signingInfo;
    }

    private static Signature[] d(Context context, String str) {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 64);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            packageInfo = null;
        }
        if (packageInfo == null) {
            return null;
        }
        return packageInfo.signatures;
    }

    public static byte[] a(String str, String str2) {
        String a2 = a(str2);
        return (str + a2).getBytes(StandardCharsets.UTF_8);
    }

    private static String a(byte[] bArr, String str) {
        CertificateFactory certificateFactory;
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        X509Certificate x509Certificate = null;
        try {
            certificateFactory = CertificateFactory.getInstance("X509");
        } catch (Exception e) {
            e.printStackTrace();
            certificateFactory = null;
        }
        if (certificateFactory != null) {
            try {
                x509Certificate = (X509Certificate) certificateFactory.generateCertificate(byteArrayInputStream);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        try {
            MessageDigest instance = MessageDigest.getInstance(str);
            if (x509Certificate != null) {
                return a(instance.digest(x509Certificate.getEncoded()));
            }
            return "";
        } catch (NoSuchAlgorithmException e3) {
            e3.printStackTrace();
            return "";
        } catch (CertificateEncodingException e4) {
            e4.printStackTrace();
            return "";
        }
    }

    public static String a(String str) {
        return str.contains(":") ? str.replaceAll(":", "") : str;
    }

    private static String a(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (int i = 0; i < bArr.length; i++) {
            String hexString = Integer.toHexString(bArr[i]);
            int length = hexString.length();
            if (length == 1) {
                hexString = "0" + hexString;
            }
            if (length > 2) {
                hexString = hexString.substring(length - 2, length);
            }
            sb.append(hexString.toUpperCase());
            if (i < bArr.length - 1) {
                sb.append(':');
            }
        }
        return sb.toString();
    }
}
