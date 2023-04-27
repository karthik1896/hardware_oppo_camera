package com.oppo.camera.ui.preview;

import android.app.Activity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.oppo.camera.k;

/* compiled from: AISceneUI */
public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    protected Activity f4352a = null;

    /* renamed from: b  reason: collision with root package name */
    protected ViewGroup f4353b = null;
    protected k c = null;

    /* renamed from: com.oppo.camera.ui.preview.a$a  reason: collision with other inner class name */
    /* compiled from: AISceneUI */
    public interface C0106a {
        void a(int i);

        void a(int i, boolean z, boolean z2);

        boolean a();

        void b(int i);
    }

    public int a() {
        return 0;
    }

    public void a(int i) {
    }

    public void a(int i, int i2, int i3) {
    }

    public void a(int i, boolean z) {
    }

    public void a(MotionEvent motionEvent) {
    }

    public void a(View.OnLayoutChangeListener onLayoutChangeListener) {
    }

    public abstract void a(C0106a aVar);

    public void a(boolean z) {
    }

    public void a(boolean z, boolean z2) {
    }

    public int b() {
        return 0;
    }

    public void b(int i) {
    }

    public boolean c() {
        return false;
    }

    public boolean c(int i) {
        return false;
    }

    public void d() {
    }

    public abstract void d(int i);

    public int e() {
        return 0;
    }

    public abstract RelativeLayout f();

    public abstract void g();

    public abstract void h();

    public abstract boolean i();

    public void j() {
        this.f4352a = null;
        this.f4353b = null;
        this.c = null;
    }
}
