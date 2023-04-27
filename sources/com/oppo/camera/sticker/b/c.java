package com.oppo.camera.sticker.b;

import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

/* compiled from: TrustAllCerts */
public class c implements X509TrustManager {
    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        if (x509CertificateArr == null) {
            throw new IllegalArgumentException("X509Certificate array is null.");
        } else if (x509CertificateArr.length != 0) {
            int length = x509CertificateArr.length;
            int i = 0;
            while (i < length) {
                try {
                    x509CertificateArr[i].checkValidity();
                    i++;
                } catch (Exception unused) {
                    throw new CertificateException("X509Certificate has expired, not valid or untrusted.");
                }
            }
        } else {
            throw new IllegalArgumentException("X509Certificate array is empty.");
        }
    }

    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        if (x509CertificateArr == null) {
            throw new IllegalArgumentException("X509Certificate array is null.");
        } else if (x509CertificateArr.length != 0) {
            int length = x509CertificateArr.length;
            int i = 0;
            while (i < length) {
                try {
                    x509CertificateArr[i].checkValidity();
                    i++;
                } catch (Exception unused) {
                    throw new CertificateException("X509Certificate has expired, not valid or untrusted.");
                }
            }
        } else {
            throw new IllegalArgumentException("X509Certificate array is empty.");
        }
    }

    public X509Certificate[] getAcceptedIssuers() {
        return new X509Certificate[0];
    }

    public static SSLSocketFactory a() {
        try {
            SSLContext instance = SSLContext.getInstance("TLS");
            instance.init((KeyManager[]) null, new TrustManager[]{new c()}, new SecureRandom());
            return instance.getSocketFactory();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
