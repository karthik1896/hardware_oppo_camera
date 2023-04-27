package com.airbnb.lottie.b;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.airbnb.lottie.c.i;
import com.airbnb.lottie.f.d;
import java.util.HashMap;
import java.util.Map;

/* compiled from: FontAssetManager */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private final i<String> f1651a = new i<>();

    /* renamed from: b  reason: collision with root package name */
    private final Map<i<String>, Typeface> f1652b = new HashMap();
    private final Map<String, Typeface> c = new HashMap();
    private final AssetManager d;
    private com.airbnb.lottie.a e;
    private String f = ".ttf";

    public a(Drawable.Callback callback, com.airbnb.lottie.a aVar) {
        this.e = aVar;
        if (!(callback instanceof View)) {
            d.b("LottieDrawable must be inside of a view for images to work.");
            this.d = null;
            return;
        }
        this.d = ((View) callback).getContext().getAssets();
    }

    public void a(com.airbnb.lottie.a aVar) {
        this.e = aVar;
    }

    public Typeface a(String str, String str2) {
        this.f1651a.a(str, str2);
        Typeface typeface = this.f1652b.get(this.f1651a);
        if (typeface != null) {
            return typeface;
        }
        Typeface a2 = a(a(str), str2);
        this.f1652b.put(this.f1651a, a2);
        return a2;
    }

    private Typeface a(String str) {
        String b2;
        Typeface typeface = this.c.get(str);
        if (typeface != null) {
            return typeface;
        }
        Typeface typeface2 = null;
        com.airbnb.lottie.a aVar = this.e;
        if (aVar != null) {
            typeface2 = aVar.a(str);
        }
        com.airbnb.lottie.a aVar2 = this.e;
        if (!(aVar2 == null || typeface2 != null || (b2 = aVar2.b(str)) == null)) {
            typeface2 = Typeface.createFromAsset(this.d, b2);
        }
        if (typeface2 == null) {
            typeface2 = Typeface.createFromAsset(this.d, "fonts/" + str + this.f);
        }
        this.c.put(str, typeface2);
        return typeface2;
    }

    private Typeface a(Typeface typeface, String str) {
        boolean contains = str.contains("Italic");
        boolean contains2 = str.contains("Bold");
        int i = (!contains || !contains2) ? contains ? 2 : contains2 ? 1 : 0 : 3;
        if (typeface.getStyle() == i) {
            return typeface;
        }
        return Typeface.create(typeface, i);
    }
}
