package com.coloros.anim.b;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import com.coloros.anim.h;
import com.coloros.anim.j;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ImageAssetManager */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f2356a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private final Context f2357b;
    private final Map<String, h> c;
    private String d;
    private j e;

    public b(Drawable.Callback callback, String str, j jVar, Map<String, h> map) {
        this.d = str;
        if (!TextUtils.isEmpty(str)) {
            String str2 = this.d;
            if (str2.charAt(str2.length() - 1) != '/') {
                this.d += '/';
            }
        }
        if (!(callback instanceof View)) {
            Log.w("EffectiveAnimation", "EffectiveAnimationDrawable must be inside of a view for images to work.");
            this.c = new HashMap();
            this.f2357b = null;
            return;
        }
        this.f2357b = ((View) callback).getContext();
        this.c = map;
        a(jVar);
    }

    public void a(j jVar) {
        this.e = jVar;
    }

    public Bitmap a(String str) {
        h hVar = this.c.get(str);
        if (hVar == null) {
            return null;
        }
        Bitmap c2 = hVar.c();
        if (c2 != null) {
            return c2;
        }
        j jVar = this.e;
        if (jVar != null) {
            Bitmap a2 = jVar.a(hVar);
            if (a2 != null) {
                a(str, a2);
            }
            return a2;
        }
        String b2 = hVar.b();
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inScaled = true;
        options.inDensity = 160;
        if (!b2.startsWith("data:") || b2.indexOf("base64,") <= 0) {
            try {
                if (!TextUtils.isEmpty(this.d)) {
                    if (com.coloros.anim.f.b.f2452a) {
                        com.coloros.anim.f.b.c("bitmapForId filename = " + b2 + ";imagesFolder = " + this.d);
                    }
                    AssetManager assets = this.f2357b.getAssets();
                    InputStream open = assets.open(this.d + b2);
                    Bitmap decodeStream = BitmapFactory.decodeStream(open, (Rect) null, options);
                    open.close();
                    return a(str, decodeStream);
                }
                throw new IllegalStateException("You must set an images folder before loading an image. Set it with EffectiveAnimationComposition#setImagesFolder or EffectiveAnimationDrawable#setImagesFolder");
            } catch (IOException e2) {
                Log.w("EffectiveAnimation", "Unable to open asset.", e2);
                return null;
            }
        } else {
            try {
                byte[] decode = Base64.decode(b2.substring(b2.indexOf(44) + 1), 0);
                return a(str, BitmapFactory.decodeByteArray(decode, 0, decode.length, options));
            } catch (IllegalArgumentException e3) {
                Log.w("EffectiveAnimation", "data URL did not have correct base64 format.", e3);
                return null;
            }
        }
    }

    public boolean a(Context context) {
        return (context == null && this.f2357b == null) || this.f2357b.equals(context);
    }

    private Bitmap a(String str, Bitmap bitmap) {
        synchronized (f2356a) {
            if (com.coloros.anim.f.b.f2452a) {
                com.coloros.anim.f.b.c("putBitmap key = " + str);
            }
            this.c.get(str).a(bitmap);
        }
        return bitmap;
    }
}
