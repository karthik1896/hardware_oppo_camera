package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.core.a.a.c;

/* compiled from: SubMenuWrapperICS */
class t extends p implements SubMenu {

    /* renamed from: b  reason: collision with root package name */
    private final c f289b;

    t(Context context, c cVar) {
        super(context, cVar);
        this.f289b = cVar;
    }

    public SubMenu setHeaderTitle(int i) {
        this.f289b.setHeaderTitle(i);
        return this;
    }

    public SubMenu setHeaderTitle(CharSequence charSequence) {
        this.f289b.setHeaderTitle(charSequence);
        return this;
    }

    public SubMenu setHeaderIcon(int i) {
        this.f289b.setHeaderIcon(i);
        return this;
    }

    public SubMenu setHeaderIcon(Drawable drawable) {
        this.f289b.setHeaderIcon(drawable);
        return this;
    }

    public SubMenu setHeaderView(View view) {
        this.f289b.setHeaderView(view);
        return this;
    }

    public void clearHeader() {
        this.f289b.clearHeader();
    }

    public SubMenu setIcon(int i) {
        this.f289b.setIcon(i);
        return this;
    }

    public SubMenu setIcon(Drawable drawable) {
        this.f289b.setIcon(drawable);
        return this;
    }

    public MenuItem getItem() {
        return a(this.f289b.getItem());
    }
}
