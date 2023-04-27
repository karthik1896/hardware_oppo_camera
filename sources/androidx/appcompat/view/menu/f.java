package androidx.appcompat.view.menu;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.n;
import androidx.appcompat.view.menu.o;
import java.util.ArrayList;

/* compiled from: ListMenuPresenter */
public class f implements AdapterView.OnItemClickListener, n {

    /* renamed from: a  reason: collision with root package name */
    Context f261a;

    /* renamed from: b  reason: collision with root package name */
    LayoutInflater f262b;
    h c;
    ExpandedMenuView d;
    int e;
    int f;
    int g;
    a h;
    private n.a i;
    private int j;

    public boolean collapseItemActionView(h hVar, j jVar) {
        return false;
    }

    public boolean expandItemActionView(h hVar, j jVar) {
        return false;
    }

    public boolean flagActionItems() {
        return false;
    }

    public f(Context context, int i2) {
        this(i2, 0);
        this.f261a = context;
        this.f262b = LayoutInflater.from(this.f261a);
    }

    public f(int i2, int i3) {
        this.g = i2;
        this.f = i3;
    }

    public void initForMenu(Context context, h hVar) {
        int i2 = this.f;
        if (i2 != 0) {
            this.f261a = new ContextThemeWrapper(context, i2);
            this.f262b = LayoutInflater.from(this.f261a);
        } else if (this.f261a != null) {
            this.f261a = context;
            if (this.f262b == null) {
                this.f262b = LayoutInflater.from(this.f261a);
            }
        }
        this.c = hVar;
        a aVar = this.h;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
        }
    }

    public o a(ViewGroup viewGroup) {
        if (this.d == null) {
            this.d = (ExpandedMenuView) this.f262b.inflate(R.layout.abc_expanded_menu_layout, viewGroup, false);
            if (this.h == null) {
                this.h = new a();
            }
            this.d.setAdapter(this.h);
            this.d.setOnItemClickListener(this);
        }
        return this.d;
    }

    public ListAdapter a() {
        if (this.h == null) {
            this.h = new a();
        }
        return this.h;
    }

    public void updateMenuView(boolean z) {
        a aVar = this.h;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
        }
    }

    public void setCallback(n.a aVar) {
        this.i = aVar;
    }

    public boolean onSubMenuSelected(s sVar) {
        if (!sVar.hasVisibleItems()) {
            return false;
        }
        new i(sVar).a((IBinder) null);
        n.a aVar = this.i;
        if (aVar == null) {
            return true;
        }
        aVar.a(sVar);
        return true;
    }

    public void onCloseMenu(h hVar, boolean z) {
        n.a aVar = this.i;
        if (aVar != null) {
            aVar.a(hVar, z);
        }
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
        this.c.performItemAction(this.h.getItem(i2), this, 0);
    }

    public void a(Bundle bundle) {
        SparseArray sparseArray = new SparseArray();
        ExpandedMenuView expandedMenuView = this.d;
        if (expandedMenuView != null) {
            expandedMenuView.saveHierarchyState(sparseArray);
        }
        bundle.putSparseParcelableArray("android:menu:list", sparseArray);
    }

    public void b(Bundle bundle) {
        SparseArray sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:list");
        if (sparseParcelableArray != null) {
            this.d.restoreHierarchyState(sparseParcelableArray);
        }
    }

    public int getId() {
        return this.j;
    }

    public Parcelable onSaveInstanceState() {
        if (this.d == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        a(bundle);
        return bundle;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        b((Bundle) parcelable);
    }

    /* compiled from: ListMenuPresenter */
    private class a extends BaseAdapter {

        /* renamed from: b  reason: collision with root package name */
        private int f264b = -1;

        public long getItemId(int i) {
            return (long) i;
        }

        public a() {
            a();
        }

        public int getCount() {
            int size = f.this.c.getNonActionItems().size() - f.this.e;
            return this.f264b < 0 ? size : size - 1;
        }

        /* renamed from: a */
        public j getItem(int i) {
            ArrayList<j> nonActionItems = f.this.c.getNonActionItems();
            int i2 = i + f.this.e;
            int i3 = this.f264b;
            if (i3 >= 0 && i2 >= i3) {
                i2++;
            }
            return nonActionItems.get(i2);
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = f.this.f262b.inflate(f.this.g, viewGroup, false);
            }
            ((o.a) view).initialize(getItem(i), 0);
            return view;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            j expandedItem = f.this.c.getExpandedItem();
            if (expandedItem != null) {
                ArrayList<j> nonActionItems = f.this.c.getNonActionItems();
                int size = nonActionItems.size();
                for (int i = 0; i < size; i++) {
                    if (nonActionItems.get(i) == expandedItem) {
                        this.f264b = i;
                        return;
                    }
                }
            }
            this.f264b = -1;
        }

        public void notifyDataSetChanged() {
            a();
            super.notifyDataSetChanged();
        }
    }
}
