package androidx.transition;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewOverlay;

/* compiled from: ViewOverlayApi18 */
class ab implements ac {

    /* renamed from: a  reason: collision with root package name */
    private final ViewOverlay f1241a;

    ab(View view) {
        this.f1241a = view.getOverlay();
    }

    public void a(Drawable drawable) {
        this.f1241a.add(drawable);
    }

    public void b(Drawable drawable) {
        this.f1241a.remove(drawable);
    }
}
