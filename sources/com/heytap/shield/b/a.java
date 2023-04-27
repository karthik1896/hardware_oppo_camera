package com.heytap.shield.b;

import android.annotation.SuppressLint;
import java.util.Base64;

/* compiled from: Base64Utils */
public class a {
    @SuppressLint({"NewApi"})
    public static byte[] a(String str) {
        return Base64.getDecoder().decode(str);
    }
}
