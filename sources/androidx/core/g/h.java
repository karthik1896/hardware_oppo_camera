package androidx.core.g;

import android.view.MotionEvent;

/* compiled from: MotionEventCompat */
public final class h {
    @Deprecated
    public static int a(MotionEvent motionEvent) {
        return motionEvent.getActionMasked();
    }

    public static boolean a(MotionEvent motionEvent, int i) {
        return (motionEvent.getSource() & i) == i;
    }
}
