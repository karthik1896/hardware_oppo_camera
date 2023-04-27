package com.oppo.camera.professional;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import com.android.providers.downloads.Downloads;
import java.util.List;
import java.util.Map;

public class ListModeBarAdapter extends BaseAdapter implements Filterable {

    /* renamed from: a  reason: collision with root package name */
    private LayoutInflater f3512a;

    /* renamed from: b  reason: collision with root package name */
    private List<? extends Map<String, ?>> f3513b;
    private int[] c;
    private String[] d = {"img", Downloads.Impl.COLUMN_TITLE, "mainTitle"};
    private h e;

    public Filter getFilter() {
        return null;
    }

    public Object getItem(int i) {
        return null;
    }

    public long getItemId(int i) {
        return 0;
    }

    public ListModeBarAdapter(Context context, List<? extends Map<String, ?>> list) {
        this.f3512a = (LayoutInflater) context.getSystemService("layout_inflater");
        this.f3513b = list;
    }

    public void a(h hVar) {
        this.e = hVar;
    }

    public int getCount() {
        List<? extends Map<String, ?>> list = this.f3513b;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        return a(i, view, viewGroup, 0);
    }

    public String a(View view) {
        View findViewById = view.findViewById(102);
        if (findViewById instanceof c) {
            return ((c) findViewById).getItemValueText();
        }
        return null;
    }

    public void a(int[] iArr) {
        this.c = iArr;
    }

    public void a(List<? extends Map<String, ?>> list) {
        this.f3513b = list;
    }

    public void a(View view, String str) {
        ((c) view.findViewById(102)).setItemValueText(str);
    }

    public void a(View view, int i, boolean z) {
        ((c) view.findViewById(102)).a(i, z);
    }

    public void a(int i, View view) {
        int i2;
        View findViewById = view.findViewById(102);
        Map map = (Map) this.f3513b.get(i);
        if (map != null) {
            Object obj = map.get("mainTitle");
            if (obj == null) {
                i2 = 0;
            } else {
                i2 = ((Integer) obj).intValue();
            }
            ((c) findViewById).setItemTitleImage(i2);
        }
    }

    private View a(int i, View view, ViewGroup viewGroup, int i2) {
        if (view == null) {
            view = this.f3512a.inflate(i2, viewGroup, false);
        }
        b(i, view);
        return view;
    }

    private void b(int i, View view) {
        Map map;
        int i2;
        String str;
        if (i <= this.f3513b.size() - 1 && (map = (Map) this.f3513b.get(i)) != null) {
            String[] strArr = this.d;
            int length = this.c.length;
            View findViewById = view.findViewById(102);
            Object obj = map.get("mainTitle");
            if (obj == null) {
                i2 = 0;
            } else {
                i2 = ((Integer) obj).intValue();
            }
            Object obj2 = map.get("main_item_key");
            if (obj2 == null) {
                str = "";
            } else {
                str = obj2.toString();
            }
            c cVar = (c) findViewById;
            cVar.setItemTitleImage(i2);
            cVar.setItemValueText(str);
            h hVar = this.e;
            if (hVar == null) {
                return;
            }
            if (!hVar.i(i) || i >= getCount() - 1) {
                cVar.a(8, false);
            } else {
                cVar.a(0, false);
            }
        }
    }
}
