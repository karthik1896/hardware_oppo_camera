package androidx.transition;

import android.view.ViewGroup;

/* compiled from: Scene */
public class k {

    /* renamed from: a  reason: collision with root package name */
    private ViewGroup f1289a;

    /* renamed from: b  reason: collision with root package name */
    private Runnable f1290b;

    public void a() {
        Runnable runnable;
        if (a(this.f1289a) == this && (runnable = this.f1290b) != null) {
            runnable.run();
        }
    }

    static void a(ViewGroup viewGroup, k kVar) {
        viewGroup.setTag(R.id.transition_current_scene, kVar);
    }

    public static k a(ViewGroup viewGroup) {
        return (k) viewGroup.getTag(R.id.transition_current_scene);
    }
}
