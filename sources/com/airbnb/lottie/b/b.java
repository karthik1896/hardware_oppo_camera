package com.airbnb.lottie.b;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import com.airbnb.lottie.f.d;
import com.airbnb.lottie.f.h;
import com.airbnb.lottie.g;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ImageAssetManager */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f1653a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private final Context f1654b;
    private String c;
    private com.airbnb.lottie.b d;
    private final Map<String, g> e;

    public b(Drawable.Callback callback, String str, com.airbnb.lottie.b bVar, Map<String, g> map) {
        this.c = str;
        if (!TextUtils.isEmpty(str)) {
            String str2 = this.c;
            if (str2.charAt(str2.length() - 1) != '/') {
                this.c += '/';
            }
        }
        if (!(callback instanceof View)) {
            d.b("LottieDrawable must be inside of a view for images to work.");
            this.e = new HashMap();
            this.f1654b = null;
            return;
        }
        this.f1654b = ((View) callback).getContext();
        this.e = map;
        a(bVar);
    }

    public void a(com.airbnb.lottie.b bVar) {
        this.d = bVar;
    }

    public Bitmap a(String str) {
        g gVar = this.e.get(str);
        if (gVar == null) {
            return null;
        }
        Bitmap e2 = gVar.e();
        if (e2 != null) {
            return e2;
        }
        com.airbnb.lottie.b bVar = this.d;
        if (bVar != null) {
            Bitmap a2 = bVar.a(gVar);
            if (a2 != null) {
                a(str, a2);
            }
            return a2;
        }
        String d2 = gVar.d();
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inScaled = true;
        options.inDensity = 160;
        if (!d2.startsWith("data:") || d2.indexOf("base64,") <= 0) {
            try {
                if (!TextUtils.isEmpty(this.c)) {
                    AssetManager assets = this.f1654b.getAssets();
                    return a(str, h.a(BitmapFactory.decodeStream(assets.open(this.c + d2), (Rect) null, options), gVar.a(), gVar.b()));
                }
                throw new IllegalStateException("You must set an images folder before loading an image. Set it with LottieComposition#setImagesFolder or LottieDrawable#setImagesFolder");
            } catch (IOException e3) {
                d.a("Unable to open asset.", e3);
                return null;
            }
        } else {
            try {
                byte[] decode = Base64.decode(d2.substring(d2.indexOf(44) + 1), 0);
                return a(str, BitmapFactory.decodeByteArray(decode, 0, decode.length, options));
            } catch (IllegalArgumentException e4) {
                d.a("data URL did not have correct base64 format.", e4);
                return null;
            }
        }
    }

    public boolean a(Context context) {
        return (context == null && this.f1654b == null) || this.f1654b.equals(context);
    }

    private Bitmap a(String str, Bitmap bitmap) {
        synchronized (f1653a) {
            this.e.get(str).a(bitmap);
        }
        return bitmap;
    }
}
