package com.heytap.shield.b;

import android.content.Context;
import com.heytap.shield.authcode.a.b;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.List;

/* compiled from: SignVerifyUtils */
public class g {

    /* renamed from: a  reason: collision with root package name */
    private static final String f2652a = Signature.class.getSimpleName();

    public static boolean a(Context context, String str, byte[] bArr, int i, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5) {
        boolean z;
        byte[] a2 = b.a(str, b.a(context, str));
        byte[] bArr6 = new byte[(a2.length + i + 10)];
        int i2 = 0;
        h.a(bArr, 0, bArr6, 0, 1);
        h.a(bArr2, 0, bArr6, 1, 1);
        h.a(a2, 0, bArr6, 2, a2.length);
        h.a(bArr3, 0, bArr6, a2.length + 2, 4);
        h.a(bArr4, 0, bArr6, a2.length + 6, i);
        h.a(h.a(i), 0, bArr6, a2.length + i + 6, 4);
        try {
            Signature instance = Signature.getInstance("SHA256withECDSA");
            List<b> a3 = a();
            z = false;
            while (i2 < a3.size()) {
                try {
                    if ("OK".equals(a3.get(i2).b())) {
                        PublicKey a4 = a(a.a(a3.get(i2).a()), "EC");
                        if (a4 != null) {
                            instance.initVerify(a4);
                            instance.update(bArr6);
                            z = instance.verify(bArr5);
                            if (z) {
                                break;
                            }
                        }
                    }
                    i2++;
                } catch (InvalidKeyException | NoSuchAlgorithmException | SignatureException e) {
                    e = e;
                    e.printStackTrace();
                    d.b("Verify signing get an exception is " + e.getMessage());
                    return z;
                }
            }
        } catch (InvalidKeyException | NoSuchAlgorithmException | SignatureException e2) {
            e = e2;
            z = false;
            e.printStackTrace();
            d.b("Verify signing get an exception is " + e.getMessage());
            return z;
        }
        return z;
    }

    private static List<b> a() {
        ArrayList arrayList = new ArrayList();
        b bVar = new b();
        bVar.a("MFkwEwYHKoZIzj0CAQYIKoZIzj0DAQcDQgAEvE0DoqARwzQKOb/b0cx7B0BQ4Ux8mTdND8rX9KHproZAuOP/M049VdcJ53sjVujUF1URD4IGMtkId2QYwXoDHw==");
        bVar.b("OK");
        arrayList.add(bVar);
        return arrayList;
    }

    private static PublicKey a(byte[] bArr, String str) {
        try {
            return KeyFactory.getInstance(str).generatePublic(new X509EncodedKeySpec(bArr));
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            e.printStackTrace();
            d.b("convertPublicKey get exception - " + e.getMessage());
            return null;
        }
    }
}
