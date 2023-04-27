package com.oppo.camera.j;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;
import java.util.List;

/* compiled from: FilmListModeBarAdapter */
public class c extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    private LayoutInflater f3351a;

    /* renamed from: b  reason: collision with root package name */
    private List<i> f3352b;

    public long getItemId(int i) {
        return 0;
    }

    public c(Context context, List<i> list) {
        this.f3351a = (LayoutInflater) context.getSystemService("layout_inflater");
        this.f3352b = list == null ? new ArrayList<>() : list;
    }

    public int getCount() {
        List<i> list = this.f3352b;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    /* renamed from: a */
    public i getItem(int i) {
        return this.f3352b.get(i);
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        return a(i, view, viewGroup, 0);
    }

    public void a(List<i> list) {
        this.f3352b = list;
    }

    public void a(View view, int i) {
        a(i, view);
    }

    public void b(int i) {
        if (this.f3352b != null && i < getCount()) {
            boolean z = false;
            i a2 = getItem(0);
            if (i == 0) {
                z = true;
            }
            a2.b(z);
        }
    }

    public void b(View view, int i) {
        i a2 = getItem(i);
        if (a2 != null) {
            ((d) view).setItemValueText(a2.g());
        }
    }

    private View a(int i, View view, ViewGroup viewGroup, int i2) {
        if (view == null) {
            view = this.f3351a.inflate(i2, viewGroup, false);
        }
        a(i, view);
        return view;
    }

    private void a(int i, View view) {
        i iVar;
        if (i <= this.f3352b.size() - 1 && (iVar = this.f3352b.get(i)) != null) {
            d dVar = (d) view;
            dVar.setItemTitleImage(iVar.c());
            dVar.setItemValueText(iVar.g());
            if (!iVar.d() || i >= getCount() - 1) {
                dVar.a(8, false);
            } else {
                dVar.a(0, iVar.f());
            }
        }
    }

    public void a(ViewGroup viewGroup) {
        if (viewGroup != null && getCount() > 0) {
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                a(i, viewGroup.getChildAt(i));
            }
        }
    }

    public void a() {
        if (this.f3352b != null && getCount() > 0) {
            for (int i = 0; i < getCount(); i++) {
                getItem(i).d((String) null);
            }
        }
    }

    public List<i> b() {
        return this.f3352b;
    }
}
