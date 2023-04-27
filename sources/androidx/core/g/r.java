package androidx.core.g;

import android.view.View;
import android.view.ViewTreeObserver;

/* compiled from: OneShotPreDrawListener */
public final class r implements View.OnAttachStateChangeListener, ViewTreeObserver.OnPreDrawListener {

    /* renamed from: a  reason: collision with root package name */
    private final View f708a;

    /* renamed from: b  reason: collision with root package name */
    private ViewTreeObserver f709b;
    private final Runnable c;

    private r(View view, Runnable runnable) {
        this.f708a = view;
        this.f709b = view.getViewTreeObserver();
        this.c = runnable;
    }

    public static r a(View view, Runnable runnable) {
        if (view == null) {
            throw new NullPointerException("view == null");
        } else if (runnable != null) {
            r rVar = new r(view, runnable);
            view.getViewTreeObserver().addOnPreDrawListener(rVar);
            view.addOnAttachStateChangeListener(rVar);
            return rVar;
        } else {
            throw new NullPointerException("runnable == null");
        }
    }

    public boolean onPreDraw() {
        a();
        this.c.run();
        return true;
    }

    public void a() {
        if (this.f709b.isAlive()) {
            this.f709b.removeOnPreDrawListener(this);
        } else {
            this.f708a.getViewTreeObserver().removeOnPreDrawListener(this);
        }
        this.f708a.removeOnAttachStateChangeListener(this);
    }

    public void onViewAttachedToWindow(View view) {
        this.f709b = view.getViewTreeObserver();
    }

    public void onViewDetachedFromWindow(View view) {
        a();
    }
}
