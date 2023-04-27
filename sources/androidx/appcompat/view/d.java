package androidx.appcompat.view;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.view.LayoutInflater;
import androidx.appcompat.R;

/* compiled from: ContextThemeWrapper */
public class d extends ContextWrapper {

    /* renamed from: a  reason: collision with root package name */
    private int f220a;

    /* renamed from: b  reason: collision with root package name */
    private Resources.Theme f221b;
    private LayoutInflater c;
    private Configuration d;
    private Resources e;

    public d() {
        super((Context) null);
    }

    public d(Context context, int i) {
        super(context);
        this.f220a = i;
    }

    public d(Context context, Resources.Theme theme) {
        super(context);
        this.f221b = theme;
    }

    /* access modifiers changed from: protected */
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    public Resources getResources() {
        return b();
    }

    private Resources b() {
        if (this.e == null) {
            if (this.d == null) {
                this.e = super.getResources();
            } else if (Build.VERSION.SDK_INT >= 17) {
                this.e = createConfigurationContext(this.d).getResources();
            }
        }
        return this.e;
    }

    public void setTheme(int i) {
        if (this.f220a != i) {
            this.f220a = i;
            c();
        }
    }

    public int a() {
        return this.f220a;
    }

    public Resources.Theme getTheme() {
        Resources.Theme theme = this.f221b;
        if (theme != null) {
            return theme;
        }
        if (this.f220a == 0) {
            this.f220a = R.style.Theme_AppCompat_Light;
        }
        c();
        return this.f221b;
    }

    public Object getSystemService(String str) {
        if (!"layout_inflater".equals(str)) {
            return getBaseContext().getSystemService(str);
        }
        if (this.c == null) {
            this.c = LayoutInflater.from(getBaseContext()).cloneInContext(this);
        }
        return this.c;
    }

    /* access modifiers changed from: protected */
    public void a(Resources.Theme theme, int i, boolean z) {
        theme.applyStyle(i, true);
    }

    private void c() {
        boolean z = this.f221b == null;
        if (z) {
            this.f221b = getResources().newTheme();
            Resources.Theme theme = getBaseContext().getTheme();
            if (theme != null) {
                this.f221b.setTo(theme);
            }
        }
        a(this.f221b, this.f220a, z);
    }

    public AssetManager getAssets() {
        return getResources().getAssets();
    }
}
