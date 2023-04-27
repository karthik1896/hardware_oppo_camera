package com.heytap.shield.b;

import java.util.Calendar;
import java.util.GregorianCalendar;

/* compiled from: TimeUtils */
public class i {
    public static Calendar a(byte[] bArr) {
        byte b2 = (bArr[3] & 255) | ((bArr[0] << 24) & -16777216) | ((bArr[1] << 16) & 16711680) | ((bArr[2] << 8) & 65280);
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTimeInMillis(((long) b2) * 1000);
        return gregorianCalendar;
    }
}
