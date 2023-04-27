package com.coloros.anim.b;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import com.coloros.anim.c.i;
import java.util.HashMap;
import java.util.Map;

/* compiled from: FontAssetManager */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private final i<String> f2354a = new i<>();

    /* renamed from: b  reason: collision with root package name */
    private final Map<i<String>, Typeface> f2355b = new HashMap();
    private final Map<String, Typeface> c = new HashMap();
    private final AssetManager d;
    private com.coloros.anim.i e;
    private String f = ".ttf";

    public a(Drawable.Callback callback, com.coloros.anim.i iVar) {
        this.e = iVar;
        if (!(callback instanceof View)) {
            Log.w("EffectiveAnimation", "EffectiveAnimationDrawable must be inside of a view for images to work.");
            this.d = null;
            return;
        }
        this.d = ((View) callback).getContext().getAssets();
    }

    public void a(com.coloros.anim.i iVar) {
        this.e = iVar;
    }

    public Typeface a(String str, String str2) {
        this.f2354a.a(str, str2);
        Typeface typeface = this.f2355b.get(this.f2354a);
        if (typeface != null) {
            return typeface;
        }
        Typeface a2 = a(a(str), str2);
        this.f2355b.put(this.f2354a, a2);
        return a2;
    }

    private Typeface a(String str) {
        String b2;
        Typeface typeface = this.c.get(str);
        if (typeface != null) {
            return typeface;
        }
        Typeface typeface2 = null;
        com.coloros.anim.i iVar = this.e;
        if (iVar != null) {
            typeface2 = iVar.a(str);
        }
        com.coloros.anim.i iVar2 = this.e;
        if (!(iVar2 == null || typeface2 != null || (b2 = iVar2.b(str)) == null)) {
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
