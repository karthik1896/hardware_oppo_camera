package com.oppo.camera.j;

import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.oppo.camera.ui.RotateImageView;
import java.util.ArrayList;
import java.util.List;

/* compiled from: FilmMenuAdapter */
public class e extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    private List<g> f3355a = null;

    /* renamed from: b  reason: collision with root package name */
    private boolean f3356b = false;
    private SharedPreferences c = null;
    private boolean d = false;

    public long getItemId(int i) {
        return 0;
    }

    public e(List<g> list, SharedPreferences sharedPreferences, boolean z) {
        this.f3355a = list == null ? new ArrayList<>() : list;
        this.c = sharedPreferences;
        this.d = z;
    }

    public int getCount() {
        return this.f3355a.size();
    }

    /* renamed from: a */
    public g getItem(int i) {
        return this.f3355a.get(i);
    }

    public void a(f fVar, int i) {
        if (fVar != null && i < fVar.getChildCount()) {
            a(fVar.getChildAt(i), i, getItem(i));
        }
    }

    public void a(f fVar, boolean z) {
        if (fVar != null && fVar.getChildCount() > 0) {
            int childCount = fVar.getChildCount();
            for (int i = 0; i < childCount; i++) {
                g a2 = getItem(i);
                a(fVar.getChildAt(i), i, a2);
                if ((z && a2.h()) || a2.i()) {
                    b.a(fVar.getChildAt(i), i, getItem(i).e());
                }
            }
        }
    }

    public void a(f fVar, int i, boolean z) {
        if (fVar != null && fVar.getChildCount() > 0) {
            if (i == 0) {
                int childCount = fVar.getChildCount();
                g a2 = getItem(i);
                this.f3356b = a2.d();
                int i2 = 0;
                while (i2 < childCount) {
                    g a3 = getItem(i2);
                    a3.c(a2.d() || i2 == 0);
                    a3.b(a2.d() || i2 != 0);
                    i2++;
                }
                a(fVar, z);
            }
        }
    }

    public void a(f fVar, int i, boolean z, boolean z2) {
        if (fVar != null && fVar.getChildCount() > 0) {
            if (i == 0) {
                int childCount = fVar.getChildCount();
                g a2 = getItem(i);
                this.f3356b = false;
                int i2 = 0;
                while (i2 < childCount) {
                    g a3 = getItem(i2);
                    a3.c(i2 == 0);
                    a3.b(i2 != 0);
                    i2++;
                }
                if (!z2) {
                    a2.b(true);
                }
                a(fVar, z);
            }
        }
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(0, viewGroup, false);
        }
        a(view, i, getItem(i));
        return view;
    }

    private void a(View view, int i, g gVar) {
        if (gVar != null && view != null) {
            RotateImageView rotateImageView = (RotateImageView) view;
            Resources resources = view.getResources();
            if (resources != null) {
                if (gVar.d()) {
                    if (gVar.a() > 0) {
                        rotateImageView.setImageResource(gVar.a());
                    }
                } else if (gVar.b() > 0) {
                    rotateImageView.setImageResource(gVar.b());
                }
                Drawable drawable = resources.getDrawable(gVar.c());
                if (!gVar.e() || gVar.c() <= 0) {
                    drawable.setAlpha(0);
                } else {
                    drawable.setAlpha(255);
                }
                view.setBackground(drawable);
                view.setVisibility(gVar.f() ? 0 : 8);
                boolean z = true;
                if ((3 != i || !this.d) && (!(2 == i || 3 == i) || this.d)) {
                    if (!gVar.f() || !gVar.g()) {
                        z = false;
                    }
                    view.setEnabled(z);
                    return;
                }
                if (!gVar.f() || !this.c.getBoolean("pref_film_video_eis_and_flash_enable", true)) {
                    z = false;
                }
                view.setEnabled(z);
            }
        }
    }

    public boolean a() {
        return this.f3356b;
    }
}
