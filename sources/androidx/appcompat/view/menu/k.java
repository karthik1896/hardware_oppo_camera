package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.view.ActionProvider;
import android.view.CollapsibleActionView;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.g.b;
import java.lang.reflect.Method;

/* compiled from: MenuItemWrapperICS */
public class k extends d implements MenuItem {

    /* renamed from: b  reason: collision with root package name */
    private final androidx.core.a.a.b f272b;
    private Method c;

    public k(Context context, androidx.core.a.a.b bVar) {
        super(context);
        if (bVar != null) {
            this.f272b = bVar;
            return;
        }
        throw new IllegalArgumentException("Wrapped Object can not be null.");
    }

    public int getItemId() {
        return this.f272b.getItemId();
    }

    public int getGroupId() {
        return this.f272b.getGroupId();
    }

    public int getOrder() {
        return this.f272b.getOrder();
    }

    public MenuItem setTitle(CharSequence charSequence) {
        this.f272b.setTitle(charSequence);
        return this;
    }

    public MenuItem setTitle(int i) {
        this.f272b.setTitle(i);
        return this;
    }

    public CharSequence getTitle() {
        return this.f272b.getTitle();
    }

    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f272b.setTitleCondensed(charSequence);
        return this;
    }

    public CharSequence getTitleCondensed() {
        return this.f272b.getTitleCondensed();
    }

    public MenuItem setIcon(Drawable drawable) {
        this.f272b.setIcon(drawable);
        return this;
    }

    public MenuItem setIcon(int i) {
        this.f272b.setIcon(i);
        return this;
    }

    public Drawable getIcon() {
        return this.f272b.getIcon();
    }

    public MenuItem setIntent(Intent intent) {
        this.f272b.setIntent(intent);
        return this;
    }

    public Intent getIntent() {
        return this.f272b.getIntent();
    }

    public MenuItem setShortcut(char c2, char c3) {
        this.f272b.setShortcut(c2, c3);
        return this;
    }

    public MenuItem setShortcut(char c2, char c3, int i, int i2) {
        this.f272b.setShortcut(c2, c3, i, i2);
        return this;
    }

    public MenuItem setNumericShortcut(char c2) {
        this.f272b.setNumericShortcut(c2);
        return this;
    }

    public MenuItem setNumericShortcut(char c2, int i) {
        this.f272b.setNumericShortcut(c2, i);
        return this;
    }

    public char getNumericShortcut() {
        return this.f272b.getNumericShortcut();
    }

    public int getNumericModifiers() {
        return this.f272b.getNumericModifiers();
    }

    public MenuItem setAlphabeticShortcut(char c2) {
        this.f272b.setAlphabeticShortcut(c2);
        return this;
    }

    public MenuItem setAlphabeticShortcut(char c2, int i) {
        this.f272b.setAlphabeticShortcut(c2, i);
        return this;
    }

    public char getAlphabeticShortcut() {
        return this.f272b.getAlphabeticShortcut();
    }

    public int getAlphabeticModifiers() {
        return this.f272b.getAlphabeticModifiers();
    }

    public MenuItem setCheckable(boolean z) {
        this.f272b.setCheckable(z);
        return this;
    }

    public boolean isCheckable() {
        return this.f272b.isCheckable();
    }

    public MenuItem setChecked(boolean z) {
        this.f272b.setChecked(z);
        return this;
    }

    public boolean isChecked() {
        return this.f272b.isChecked();
    }

    public MenuItem setVisible(boolean z) {
        return this.f272b.setVisible(z);
    }

    public boolean isVisible() {
        return this.f272b.isVisible();
    }

    public MenuItem setEnabled(boolean z) {
        this.f272b.setEnabled(z);
        return this;
    }

    public boolean isEnabled() {
        return this.f272b.isEnabled();
    }

    public boolean hasSubMenu() {
        return this.f272b.hasSubMenu();
    }

    public SubMenu getSubMenu() {
        return a(this.f272b.getSubMenu());
    }

    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f272b.setOnMenuItemClickListener(onMenuItemClickListener != null ? new e(onMenuItemClickListener) : null);
        return this;
    }

    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.f272b.getMenuInfo();
    }

    public void setShowAsAction(int i) {
        this.f272b.setShowAsAction(i);
    }

    public MenuItem setShowAsActionFlags(int i) {
        this.f272b.setShowAsActionFlags(i);
        return this;
    }

    public MenuItem setActionView(View view) {
        if (view instanceof CollapsibleActionView) {
            view = new c(view);
        }
        this.f272b.setActionView(view);
        return this;
    }

    public MenuItem setActionView(int i) {
        this.f272b.setActionView(i);
        View actionView = this.f272b.getActionView();
        if (actionView instanceof CollapsibleActionView) {
            this.f272b.setActionView((View) new c(actionView));
        }
        return this;
    }

    public View getActionView() {
        View actionView = this.f272b.getActionView();
        return actionView instanceof c ? ((c) actionView).c() : actionView;
    }

    public MenuItem setActionProvider(ActionProvider actionProvider) {
        androidx.core.g.b bVar;
        if (Build.VERSION.SDK_INT >= 16) {
            bVar = new b(this.f250a, actionProvider);
        } else {
            bVar = new a(this.f250a, actionProvider);
        }
        androidx.core.a.a.b bVar2 = this.f272b;
        if (actionProvider == null) {
            bVar = null;
        }
        bVar2.a(bVar);
        return this;
    }

    public ActionProvider getActionProvider() {
        androidx.core.g.b a2 = this.f272b.a();
        if (a2 instanceof a) {
            return ((a) a2).f273a;
        }
        return null;
    }

    public boolean expandActionView() {
        return this.f272b.expandActionView();
    }

    public boolean collapseActionView() {
        return this.f272b.collapseActionView();
    }

    public boolean isActionViewExpanded() {
        return this.f272b.isActionViewExpanded();
    }

    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        this.f272b.setOnActionExpandListener(onActionExpandListener != null ? new d(onActionExpandListener) : null);
        return this;
    }

    public MenuItem setContentDescription(CharSequence charSequence) {
        this.f272b.a(charSequence);
        return this;
    }

    public CharSequence getContentDescription() {
        return this.f272b.getContentDescription();
    }

    public MenuItem setTooltipText(CharSequence charSequence) {
        this.f272b.b(charSequence);
        return this;
    }

    public CharSequence getTooltipText() {
        return this.f272b.getTooltipText();
    }

    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f272b.setIconTintList(colorStateList);
        return this;
    }

    public ColorStateList getIconTintList() {
        return this.f272b.getIconTintList();
    }

    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f272b.setIconTintMode(mode);
        return this;
    }

    public PorterDuff.Mode getIconTintMode() {
        return this.f272b.getIconTintMode();
    }

    public void a(boolean z) {
        try {
            if (this.c == null) {
                this.c = this.f272b.getClass().getDeclaredMethod("setExclusiveCheckable", new Class[]{Boolean.TYPE});
            }
            this.c.invoke(this.f272b, new Object[]{Boolean.valueOf(z)});
        } catch (Exception e2) {
            Log.w("MenuItemWrapper", "Error while calling setExclusiveCheckable", e2);
        }
    }

    /* compiled from: MenuItemWrapperICS */
    private class e implements MenuItem.OnMenuItemClickListener {

        /* renamed from: b  reason: collision with root package name */
        private final MenuItem.OnMenuItemClickListener f279b;

        e(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
            this.f279b = onMenuItemClickListener;
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            return this.f279b.onMenuItemClick(k.this.a(menuItem));
        }
    }

    /* compiled from: MenuItemWrapperICS */
    private class d implements MenuItem.OnActionExpandListener {

        /* renamed from: b  reason: collision with root package name */
        private final MenuItem.OnActionExpandListener f277b;

        d(MenuItem.OnActionExpandListener onActionExpandListener) {
            this.f277b = onActionExpandListener;
        }

        public boolean onMenuItemActionExpand(MenuItem menuItem) {
            return this.f277b.onMenuItemActionExpand(k.this.a(menuItem));
        }

        public boolean onMenuItemActionCollapse(MenuItem menuItem) {
            return this.f277b.onMenuItemActionCollapse(k.this.a(menuItem));
        }
    }

    /* compiled from: MenuItemWrapperICS */
    private class a extends androidx.core.g.b {

        /* renamed from: a  reason: collision with root package name */
        final ActionProvider f273a;

        a(Context context, ActionProvider actionProvider) {
            super(context);
            this.f273a = actionProvider;
        }

        public View a() {
            return this.f273a.onCreateActionView();
        }

        public boolean b() {
            return this.f273a.onPerformDefaultAction();
        }

        public boolean c() {
            return this.f273a.hasSubMenu();
        }

        public void a(SubMenu subMenu) {
            this.f273a.onPrepareSubMenu(k.this.a(subMenu));
        }
    }

    /* compiled from: MenuItemWrapperICS */
    private class b extends a implements ActionProvider.VisibilityListener {
        private b.C0022b d;

        b(Context context, ActionProvider actionProvider) {
            super(context, actionProvider);
        }

        public View a(MenuItem menuItem) {
            return this.f273a.onCreateActionView(menuItem);
        }

        public boolean d() {
            return this.f273a.overridesItemVisibility();
        }

        public boolean e() {
            return this.f273a.isVisible();
        }

        public void a(b.C0022b bVar) {
            this.d = bVar;
            this.f273a.setVisibilityListener(bVar != null ? this : null);
        }

        public void onActionProviderVisibilityChanged(boolean z) {
            b.C0022b bVar = this.d;
            if (bVar != null) {
                bVar.a(z);
            }
        }
    }

    /* compiled from: MenuItemWrapperICS */
    static class c extends FrameLayout implements androidx.appcompat.view.c {

        /* renamed from: a  reason: collision with root package name */
        final CollapsibleActionView f275a;

        c(View view) {
            super(view.getContext());
            this.f275a = (CollapsibleActionView) view;
            addView(view);
        }

        public void a() {
            this.f275a.onActionViewExpanded();
        }

        public void b() {
            this.f275a.onActionViewCollapsed();
        }

        /* access modifiers changed from: package-private */
        public View c() {
            return (View) this.f275a;
        }
    }
}
