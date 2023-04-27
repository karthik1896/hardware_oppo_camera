package com.color.support.d;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import androidx.core.graphics.drawable.a;

/* compiled from: ColorTintUtil */
public class p {
    public static Drawable a(Drawable drawable, int i) {
        Drawable g = a.g(drawable);
        a.a(g.mutate(), i);
        return g;
    }

    public static Bitmap a(Bitmap bitmap, int i) {
        Paint paint = new Paint();
        paint.setColorFilter(new PorterDuffColorFilter(i, PorterDuff.Mode.SRC_IN));
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
        createBitmap.setDensity(bitmap.getDensity());
        new Canvas(createBitmap).drawBitmap(bitmap, 0.0f, 0.0f, paint);
        return createBitmap;
    }
}
