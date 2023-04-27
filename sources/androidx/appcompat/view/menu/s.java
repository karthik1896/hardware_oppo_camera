package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.appcompat.view.menu.h;

/* compiled from: SubMenuBuilder */
public class s extends h implements SubMenu {
    private j mItem;
    private h mParentMenu;

    public s(Context context, h hVar, j jVar) {
        super(context);
        this.mParentMenu = hVar;
        this.mItem = jVar;
    }

    public void setQwertyMode(boolean z) {
        this.mParentMenu.setQwertyMode(z);
    }

    public boolean isQwertyMode() {
        return this.mParentMenu.isQwertyMode();
    }

    public void setShortcutsVisible(boolean z) {
        this.mParentMenu.setShortcutsVisible(z);
    }

    public boolean isShortcutsVisible() {
        return this.mParentMenu.isShortcutsVisible();
    }

    public Menu getParentMenu() {
        return this.mParentMenu;
    }

    public MenuItem getItem() {
        return this.mItem;
    }

    public void setCallback(h.a aVar) {
        this.mParentMenu.setCallback(aVar);
    }

    public h getRootMenu() {
        return this.mParentMenu.getRootMenu();
    }

    /* access modifiers changed from: package-private */
    public boolean dispatchMenuItemSelected(h hVar, MenuItem menuItem) {
        return super.dispatchMenuItemSelected(hVar, menuItem) || this.mParentMenu.dispatchMenuItemSelected(hVar, menuItem);
    }

    public SubMenu setIcon(Drawable drawable) {
        this.mItem.setIcon(drawable);
        return this;
    }

    public SubMenu setIcon(int i) {
        this.mItem.setIcon(i);
        return this;
    }

    public SubMenu setHeaderIcon(Drawable drawable) {
        return (SubMenu) super.setHeaderIconInt(drawable);
    }

    public SubMenu setHeaderIcon(int i) {
        return (SubMenu) super.setHeaderIconInt(i);
    }

    public SubMenu setHeaderTitle(CharSequence charSequence) {
        return (SubMenu) super.setHeaderTitleInt(charSequence);
    }

    public SubMenu setHeaderTitle(int i) {
        return (SubMenu) super.setHeaderTitleInt(i);
    }

    public SubMenu setHeaderView(View view) {
        return (SubMenu) super.setHeaderViewInt(view);
    }

    public boolean expandItemActionView(j jVar) {
        return this.mParentMenu.expandItemActionView(jVar);
    }

    public boolean collapseItemActionView(j jVar) {
        return this.mParentMenu.collapseItemActionView(jVar);
    }

    public String getActionViewStatesKey() {
        j jVar = this.mItem;
        int itemId = jVar != null ? jVar.getItemId() : 0;
        if (itemId == 0) {
            return null;
        }
        return super.getActionViewStatesKey() + ":" + itemId;
    }

    public void setGroupDividerEnabled(boolean z) {
        this.mParentMenu.setGroupDividerEnabled(z);
    }

    public boolean isGroupDividerEnabled() {
        return this.mParentMenu.isGroupDividerEnabled();
    }
}
