package androidx.core.g;

import android.content.Context;
import android.os.Build;
import android.view.PointerIcon;

/* compiled from: PointerIconCompat */
public final class s {

    /* renamed from: a  reason: collision with root package name */
    private Object f710a;

    private s(Object obj) {
        this.f710a = obj;
    }

    public Object a() {
        return this.f710a;
    }

    public static s a(Context context, int i) {
        if (Build.VERSION.SDK_INT >= 24) {
            return new s(PointerIcon.getSystemIcon(context, i));
        }
        return new s((Object) null);
    }
}
