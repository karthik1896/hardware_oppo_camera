package androidx.transition;

import android.view.View;
import android.view.WindowId;

/* compiled from: WindowIdApi18 */
class am implements an {

    /* renamed from: a  reason: collision with root package name */
    private final WindowId f1260a;

    am(View view) {
        this.f1260a = view.getWindowId();
    }

    public boolean equals(Object obj) {
        return (obj instanceof am) && ((am) obj).f1260a.equals(this.f1260a);
    }

    public int hashCode() {
        return this.f1260a.hashCode();
    }
}
