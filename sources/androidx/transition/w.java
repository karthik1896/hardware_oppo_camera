package androidx.transition;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroupOverlay;

/* compiled from: ViewGroupOverlayApi18 */
class w implements x {

    /* renamed from: a  reason: collision with root package name */
    private final ViewGroupOverlay f1315a;

    w(ViewGroup viewGroup) {
        this.f1315a = viewGroup.getOverlay();
    }

    public void a(Drawable drawable) {
        this.f1315a.add(drawable);
    }

    public void b(Drawable drawable) {
        this.f1315a.remove(drawable);
    }

    public void a(View view) {
        this.f1315a.add(view);
    }

    public void b(View view) {
        this.f1315a.remove(view);
    }
}
