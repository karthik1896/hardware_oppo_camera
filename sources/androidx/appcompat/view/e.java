package androidx.appcompat.view;

import android.content.Context;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.view.b;
import androidx.appcompat.view.menu.h;
import androidx.appcompat.widget.ActionBarContextView;
import java.lang.ref.WeakReference;

/* compiled from: StandaloneActionMode */
public class e extends b implements h.a {

    /* renamed from: a  reason: collision with root package name */
    private Context f222a;

    /* renamed from: b  reason: collision with root package name */
    private ActionBarContextView f223b;
    private b.a c;
    private WeakReference<View> d;
    private boolean e;
    private boolean f;
    private h g;

    public e(Context context, ActionBarContextView actionBarContextView, b.a aVar, boolean z) {
        this.f222a = context;
        this.f223b = actionBarContextView;
        this.c = aVar;
        this.g = new h(actionBarContextView.getContext()).setDefaultShowAsAction(1);
        this.g.setCallback(this);
        this.f = z;
    }

    public void b(CharSequence charSequence) {
        this.f223b.setTitle(charSequence);
    }

    public void a(CharSequence charSequence) {
        this.f223b.setSubtitle(charSequence);
    }

    public void a(int i) {
        b((CharSequence) this.f222a.getString(i));
    }

    public void b(int i) {
        a((CharSequence) this.f222a.getString(i));
    }

    public void a(boolean z) {
        super.a(z);
        this.f223b.setTitleOptional(z);
    }

    public boolean h() {
        return this.f223b.d();
    }

    public void a(View view) {
        this.f223b.setCustomView(view);
        this.d = view != null ? new WeakReference<>(view) : null;
    }

    public void d() {
        this.c.b(this, this.g);
    }

    public void c() {
        if (!this.e) {
            this.e = true;
            this.f223b.sendAccessibilityEvent(32);
            this.c.a(this);
        }
    }

    public Menu b() {
        return this.g;
    }

    public CharSequence f() {
        return this.f223b.getTitle();
    }

    public CharSequence g() {
        return this.f223b.getSubtitle();
    }

    public View i() {
        WeakReference<View> weakReference = this.d;
        if (weakReference != null) {
            return (View) weakReference.get();
        }
        return null;
    }

    public MenuInflater a() {
        return new g(this.f223b.getContext());
    }

    public boolean onMenuItemSelected(h hVar, MenuItem menuItem) {
        return this.c.a((b) this, menuItem);
    }

    public void onMenuModeChange(h hVar) {
        d();
        this.f223b.a();
    }
}
