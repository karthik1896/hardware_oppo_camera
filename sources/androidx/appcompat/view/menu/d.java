package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import androidx.collection.ArrayMap;
import androidx.core.a.a.b;
import androidx.core.a.a.c;
import java.util.Iterator;
import java.util.Map;

/* compiled from: BaseMenuWrapper */
abstract class d {

    /* renamed from: a  reason: collision with root package name */
    final Context f250a;

    /* renamed from: b  reason: collision with root package name */
    private Map<b, MenuItem> f251b;
    private Map<c, SubMenu> c;

    d(Context context) {
        this.f250a = context;
    }

    /* access modifiers changed from: package-private */
    public final MenuItem a(MenuItem menuItem) {
        if (!(menuItem instanceof b)) {
            return menuItem;
        }
        b bVar = (b) menuItem;
        if (this.f251b == null) {
            this.f251b = new ArrayMap();
        }
        MenuItem menuItem2 = this.f251b.get(menuItem);
        if (menuItem2 != null) {
            return menuItem2;
        }
        k kVar = new k(this.f250a, bVar);
        this.f251b.put(bVar, kVar);
        return kVar;
    }

    /* access modifiers changed from: package-private */
    public final SubMenu a(SubMenu subMenu) {
        if (!(subMenu instanceof c)) {
            return subMenu;
        }
        c cVar = (c) subMenu;
        if (this.c == null) {
            this.c = new ArrayMap();
        }
        SubMenu subMenu2 = this.c.get(cVar);
        if (subMenu2 != null) {
            return subMenu2;
        }
        t tVar = new t(this.f250a, cVar);
        this.c.put(cVar, tVar);
        return tVar;
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        Map<b, MenuItem> map = this.f251b;
        if (map != null) {
            map.clear();
        }
        Map<c, SubMenu> map2 = this.c;
        if (map2 != null) {
            map2.clear();
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(int i) {
        Map<b, MenuItem> map = this.f251b;
        if (map != null) {
            Iterator<b> it = map.keySet().iterator();
            while (it.hasNext()) {
                if (i == it.next().getGroupId()) {
                    it.remove();
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void b(int i) {
        Map<b, MenuItem> map = this.f251b;
        if (map != null) {
            Iterator<b> it = map.keySet().iterator();
            while (it.hasNext()) {
                if (i == it.next().getItemId()) {
                    it.remove();
                    return;
                }
            }
        }
    }
}
