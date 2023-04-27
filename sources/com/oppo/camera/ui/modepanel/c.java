package com.oppo.camera.ui.modepanel;

import android.app.Activity;
import android.view.ViewGroup;
import android.view.animation.Animation;
import com.oppo.camera.ui.modepanel.d;

/* compiled from: ModePanelUIControl */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private Activity f4299a = null;

    /* renamed from: b  reason: collision with root package name */
    private ViewGroup f4300b = null;
    private d c = null;
    private d.a d = null;

    public c(Activity activity, ViewGroup viewGroup) {
        this.f4299a = activity;
        this.f4300b = viewGroup;
    }

    public void a(d.a aVar) {
        this.d = aVar;
    }

    private void c() {
        if (this.c == null) {
            this.c = new d(this.f4299a, this.f4300b);
            this.c.a(this.d);
        }
    }

    public void a(String str) {
        c();
        this.c.a(str);
    }

    public String a() {
        d dVar = this.c;
        return dVar != null ? dVar.a() : "";
    }

    public void a(boolean z) {
        c();
        this.c.a(0, z);
    }

    public void a(Animation animation) {
        c();
        this.c.a(0, animation);
    }

    public void b(boolean z) {
        d dVar = this.c;
        if (dVar != null) {
            dVar.a(8, z);
        }
    }

    public void b(Animation animation) {
        d dVar = this.c;
        if (dVar != null) {
            dVar.a(8, animation);
        }
    }

    public boolean b() {
        d dVar = this.c;
        if (dVar != null) {
            return dVar.b();
        }
        return false;
    }

    public void c(boolean z) {
        d dVar = this.c;
        if (dVar != null) {
            dVar.a(z);
        }
    }
}
