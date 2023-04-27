package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import java.lang.ref.WeakReference;

/* compiled from: VectorEnabledTintResources */
public class aw extends Resources {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f431a = false;

    /* renamed from: b  reason: collision with root package name */
    private final WeakReference<Context> f432b;

    public static boolean a() {
        return b() && Build.VERSION.SDK_INT <= 20;
    }

    public aw(Context context, Resources resources) {
        super(resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
        this.f432b = new WeakReference<>(context);
    }

    public Drawable getDrawable(int i) throws Resources.NotFoundException {
        Context context = (Context) this.f432b.get();
        if (context != null) {
            return ah.a().a(context, this, i);
        }
        return super.getDrawable(i);
    }

    /* access modifiers changed from: package-private */
    public final Drawable a(int i) {
        return super.getDrawable(i);
    }

    public static boolean b() {
        return f431a;
    }
}
