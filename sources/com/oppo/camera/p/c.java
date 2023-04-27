package com.oppo.camera.p;

import android.text.TextUtils;
import java.util.ArrayList;

/* compiled from: WifiResultParser */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    private static final String[] f3465a = new String[0];

    public boolean a(String str) {
        String b2 = b(str);
        if (b2.startsWith("WIFI:") && !TextUtils.isEmpty(b("S:", b2.substring(5), ';', false))) {
            return true;
        }
        return false;
    }

    private static String b(String str) {
        return str.startsWith("﻿") ? str.substring(1) : str;
    }

    private static String c(String str) {
        int indexOf = str.indexOf(92);
        if (indexOf < 0) {
            return str;
        }
        int length = str.length();
        StringBuilder sb = new StringBuilder(length - 1);
        sb.append(str.toCharArray(), 0, indexOf);
        boolean z = false;
        while (indexOf < length) {
            char charAt = str.charAt(indexOf);
            if (z || charAt != '\\') {
                sb.append(charAt);
                z = false;
            } else {
                z = true;
            }
            indexOf++;
        }
        return sb.toString();
    }

    private static String[] a(String str, String str2, char c, boolean z) {
        int i;
        int length = str2.length();
        ArrayList arrayList = null;
        for (int i2 = 0; i2 < length; i2 = i) {
            int indexOf = str2.indexOf(str, i2);
            if (indexOf < 0) {
                break;
            }
            int length2 = indexOf + str.length();
            boolean z2 = true;
            i = length2;
            while (z2) {
                int indexOf2 = str2.indexOf(c, i);
                if (indexOf2 < 0) {
                    i = str2.length();
                } else if (a(str2, indexOf2) % 2 != 0) {
                    i = indexOf2 + 1;
                } else {
                    if (arrayList == null) {
                        arrayList = new ArrayList(3);
                    }
                    String c2 = c(str2.substring(length2, indexOf2));
                    if (z) {
                        c2 = c2.trim();
                    }
                    if (!c2.isEmpty()) {
                        arrayList.add(c2);
                    }
                    i = indexOf2 + 1;
                }
                z2 = false;
            }
        }
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        return (String[]) arrayList.toArray(f3465a);
    }

    private static int a(CharSequence charSequence, int i) {
        int i2 = i - 1;
        int i3 = 0;
        while (i2 >= 0 && charSequence.charAt(i2) == '\\') {
            i3++;
            i2--;
        }
        return i3;
    }

    private static String b(String str, String str2, char c, boolean z) {
        String[] a2 = a(str, str2, c, z);
        if (a2 == null || a2.length == 0) {
            return null;
        }
        return a2[0];
    }
}
