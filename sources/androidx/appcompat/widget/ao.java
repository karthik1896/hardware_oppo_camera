package androidx.appcompat.widget;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Build;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* compiled from: TintContextWrapper */
public class ao extends ContextWrapper {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f412a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private static ArrayList<WeakReference<ao>> f413b;
    private final Resources c;
    private final Resources.Theme d;

    public static Context a(Context context) {
        if (!b(context)) {
            return context;
        }
        synchronized (f412a) {
            if (f413b == null) {
                f413b = new ArrayList<>();
            } else {
                for (int size = f413b.size() - 1; size >= 0; size--) {
                    WeakReference weakReference = f413b.get(size);
                    if (weakReference == null || weakReference.get() == null) {
                        f413b.remove(size);
                    }
                }
                for (int size2 = f413b.size() - 1; size2 >= 0; size2--) {
                    WeakReference weakReference2 = f413b.get(size2);
                    ao aoVar = weakReference2 != null ? (ao) weakReference2.get() : null;
                    if (aoVar != null && aoVar.getBaseContext() == context) {
                        return aoVar;
                    }
                }
            }
            ao aoVar2 = new ao(context);
            f413b.add(new WeakReference(aoVar2));
            return aoVar2;
        }
    }

    private static boolean b(Context context) {
        if ((context instanceof ao) || (context.getResources() instanceof aq) || (context.getResources() instanceof aw)) {
            return false;
        }
        if (Build.VERSION.SDK_INT < 21 || aw.a()) {
            return true;
        }
        return false;
    }

    private ao(Context context) {
        super(context);
        if (aw.a()) {
            this.c = new aw(this, context.getResources());
            this.d = this.c.newTheme();
            this.d.setTo(context.getTheme());
            return;
        }
        this.c = new aq(this, context.getResources());
        this.d = null;
    }

    public Resources.Theme getTheme() {
        Resources.Theme theme = this.d;
        return theme == null ? super.getTheme() : theme;
    }

    public void setTheme(int i) {
        Resources.Theme theme = this.d;
        if (theme == null) {
            super.setTheme(i);
        } else {
            theme.applyStyle(i, true);
        }
    }

    public Resources getResources() {
        return this.c;
    }

    public AssetManager getAssets() {
        return this.c.getAssets();
    }
}
