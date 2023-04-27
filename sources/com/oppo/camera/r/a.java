package com.oppo.camera.r;

import android.app.Activity;
import android.content.ContentValues;
import android.net.Uri;
import com.oppo.camera.ui.control.c;
import com.oppo.camera.ui.e;

/* compiled from: SLVBaseMode */
public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    protected Activity f3584a;

    /* renamed from: b  reason: collision with root package name */
    protected e f3585b;
    protected C0093a c = null;

    /* renamed from: com.oppo.camera.r.a$a  reason: collision with other inner class name */
    /* compiled from: SLVBaseMode */
    public interface C0093a {
        void a(String str);

        void b(String str);
    }

    /* access modifiers changed from: package-private */
    public abstract int a();

    /* access modifiers changed from: protected */
    public String a(String str) {
        return "";
    }

    public boolean a(int i, Uri uri, ContentValues contentValues, String str) {
        return false;
    }

    public boolean b() {
        return false;
    }

    public int c() {
        return Integer.MAX_VALUE;
    }

    public void d() {
    }

    public a(Activity activity, e eVar) {
        this.f3584a = activity;
        this.f3585b = eVar;
        com.oppo.camera.e.a("SLVBaseMode", " enter");
    }

    public c a(int i) {
        if (i == 1) {
            return new c(6, "button_color_inside_red", "button_shape_dial_still", 1);
        }
        if (i == 2) {
            return new c(5, "button_color_inside_red", "button_shape_dial_still", 1);
        }
        if (i != 3) {
            return null;
        }
        c cVar = new c();
        cVar.a("button_color_inside_none");
        cVar.a(4);
        return cVar;
    }

    public void a(C0093a aVar) {
        this.c = aVar;
    }

    public void e() {
        this.f3584a = null;
        this.f3585b = null;
        this.c = null;
        com.oppo.camera.e.a("SLVBaseMode", "exit");
    }
}
