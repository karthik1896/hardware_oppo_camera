package com.oppo.camera.j;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.oppo.camera.R;
import java.util.ArrayList;
import java.util.List;

/* compiled from: FilmModeSlideBarAdapter */
public class j extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    private LayoutInflater f3366a = null;

    /* renamed from: b  reason: collision with root package name */
    private List<k> f3367b = null;

    public long getItemId(int i) {
        return 0;
    }

    public j(Context context, List<k> list) {
        this.f3366a = (LayoutInflater) context.getSystemService("layout_inflater");
        this.f3367b = list == null ? new ArrayList<>() : list;
    }

    public int getCount() {
        List<k> list = this.f3367b;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    /* renamed from: a */
    public k getItem(int i) {
        return this.f3367b.get(i);
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        return a(i, view, viewGroup, 0);
    }

    public void a(List<k> list) {
        this.f3367b = list;
    }

    public void a(int i, View view, ViewGroup viewGroup) {
        getView(i, view, viewGroup);
    }

    private View a(int i, View view, ViewGroup viewGroup, int i2) {
        if (view == null) {
            view = this.f3366a.inflate(i2, viewGroup, false);
        }
        a(i, view);
        return view;
    }

    private void a(int i, View view) {
        k kVar;
        if (i <= this.f3367b.size() - 1 && (kVar = this.f3367b.get(i)) != null && view != null) {
            m mVar = (m) view.findViewById(R.id.movie_slide_bar_id);
            mVar.setValue(kVar.a());
            mVar.a(kVar.d(), kVar.c());
            mVar.setSlideNum(kVar.f());
            if (kVar.g()) {
                mVar.setCurrentSlideIndex(kVar.b());
            }
        }
    }
}
