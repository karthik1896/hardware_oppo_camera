package androidx.appcompat.view.menu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.appcompat.view.menu.o;
import java.util.ArrayList;

/* compiled from: MenuAdapter */
public class g extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    h f265a;

    /* renamed from: b  reason: collision with root package name */
    private int f266b = -1;
    private boolean c;
    private final boolean d;
    private final LayoutInflater e;
    private final int f;

    public long getItemId(int i) {
        return (long) i;
    }

    public g(h hVar, LayoutInflater layoutInflater, boolean z, int i) {
        this.d = z;
        this.e = layoutInflater;
        this.f265a = hVar;
        this.f = i;
        b();
    }

    public void a(boolean z) {
        this.c = z;
    }

    public int getCount() {
        ArrayList<j> nonActionItems = this.d ? this.f265a.getNonActionItems() : this.f265a.getVisibleItems();
        if (this.f266b < 0) {
            return nonActionItems.size();
        }
        return nonActionItems.size() - 1;
    }

    public h a() {
        return this.f265a;
    }

    /* renamed from: a */
    public j getItem(int i) {
        ArrayList<j> nonActionItems = this.d ? this.f265a.getNonActionItems() : this.f265a.getVisibleItems();
        int i2 = this.f266b;
        if (i2 >= 0 && i >= i2) {
            i++;
        }
        return nonActionItems.get(i);
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.e.inflate(this.f, viewGroup, false);
        }
        int groupId = getItem(i).getGroupId();
        int i2 = i - 1;
        ListMenuItemView listMenuItemView = (ListMenuItemView) view;
        listMenuItemView.setGroupDividerEnabled(this.f265a.isGroupDividerEnabled() && groupId != (i2 >= 0 ? getItem(i2).getGroupId() : groupId));
        o.a aVar = (o.a) view;
        if (this.c) {
            listMenuItemView.setForceShowIcon(true);
        }
        aVar.initialize(getItem(i), 0);
        return view;
    }

    /* access modifiers changed from: package-private */
    public void b() {
        j expandedItem = this.f265a.getExpandedItem();
        if (expandedItem != null) {
            ArrayList<j> nonActionItems = this.f265a.getNonActionItems();
            int size = nonActionItems.size();
            for (int i = 0; i < size; i++) {
                if (nonActionItems.get(i) == expandedItem) {
                    this.f266b = i;
                    return;
                }
            }
        }
        this.f266b = -1;
    }

    public void notifyDataSetChanged() {
        b();
        super.notifyDataSetChanged();
    }
}
