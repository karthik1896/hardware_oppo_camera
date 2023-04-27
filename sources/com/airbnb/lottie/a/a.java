package com.airbnb.lottie.a;

import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.os.LocaleList;

/* compiled from: LPaint */
public class a extends Paint {
    public void setTextLocales(LocaleList localeList) {
    }

    public a() {
    }

    public a(int i) {
        super(i);
    }

    public a(PorterDuff.Mode mode) {
        setXfermode(new PorterDuffXfermode(mode));
    }

    public a(int i, PorterDuff.Mode mode) {
        super(i);
        setXfermode(new PorterDuffXfermode(mode));
    }
}
