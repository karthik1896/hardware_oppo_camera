package androidx.preference;

import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.g.v;
import androidx.preference.Preference;
import androidx.preference.PreferenceGroup;
import androidx.preference.j;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.f;
import java.util.ArrayList;
import java.util.List;

/* compiled from: PreferenceGroupAdapter */
public class h extends RecyclerView.a<l> implements Preference.a {

    /* renamed from: a  reason: collision with root package name */
    private PreferenceGroup f1013a;

    /* renamed from: b  reason: collision with root package name */
    private List<Preference> f1014b;
    private List<Preference> c;
    private List<a> d;
    private Handler e;
    private Runnable f = new Runnable() {
        public void run() {
            h.this.a();
        }
    };

    public h(PreferenceGroup preferenceGroup) {
        this.f1013a = preferenceGroup;
        this.e = new Handler();
        this.f1013a.a((Preference.a) this);
        this.f1014b = new ArrayList();
        this.c = new ArrayList();
        this.d = new ArrayList();
        PreferenceGroup preferenceGroup2 = this.f1013a;
        if (preferenceGroup2 instanceof PreferenceScreen) {
            setHasStableIds(((PreferenceScreen) preferenceGroup2).l());
        } else {
            setHasStableIds(true);
        }
        a();
    }

    /* access modifiers changed from: package-private */
    public void a() {
        for (Preference a2 : this.f1014b) {
            a2.a((Preference.a) null);
        }
        this.f1014b = new ArrayList(this.f1014b.size());
        a(this.f1014b, this.f1013a);
        final List<Preference> list = this.c;
        final List<Preference> a3 = a(this.f1013a);
        this.c = a3;
        j M = this.f1013a.M();
        if (M == null || M.g() == null) {
            notifyDataSetChanged();
        } else {
            final j.d g = M.g();
            f.a(new f.a() {
                public int a() {
                    return list.size();
                }

                public int b() {
                    return a3.size();
                }

                public boolean a(int i, int i2) {
                    return g.a((Preference) list.get(i), (Preference) a3.get(i2));
                }

                public boolean b(int i, int i2) {
                    return g.b((Preference) list.get(i), (Preference) a3.get(i2));
                }
            }).a((RecyclerView.a) this);
        }
        for (Preference P : this.f1014b) {
            P.P();
        }
    }

    private void a(List<Preference> list, PreferenceGroup preferenceGroup) {
        preferenceGroup.h();
        int c2 = preferenceGroup.c();
        for (int i = 0; i < c2; i++) {
            Preference i2 = preferenceGroup.i(i);
            list.add(i2);
            a aVar = new a(i2);
            if (!this.d.contains(aVar)) {
                this.d.add(aVar);
            }
            if (i2 instanceof PreferenceGroup) {
                PreferenceGroup preferenceGroup2 = (PreferenceGroup) i2;
                if (preferenceGroup2.e()) {
                    a(list, preferenceGroup2);
                }
            }
            i2.a((Preference.a) this);
        }
    }

    private List<Preference> a(PreferenceGroup preferenceGroup) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int c2 = preferenceGroup.c();
        int i = 0;
        for (int i2 = 0; i2 < c2; i2++) {
            Preference i3 = preferenceGroup.i(i2);
            if (i3.A()) {
                if (!b(preferenceGroup) || i < preferenceGroup.b()) {
                    arrayList.add(i3);
                } else {
                    arrayList2.add(i3);
                }
                if (!(i3 instanceof PreferenceGroup)) {
                    i++;
                } else {
                    PreferenceGroup preferenceGroup2 = (PreferenceGroup) i3;
                    if (!preferenceGroup2.e()) {
                        continue;
                    } else if (!b(preferenceGroup) || !b(preferenceGroup2)) {
                        for (Preference next : a(preferenceGroup2)) {
                            if (!b(preferenceGroup) || i < preferenceGroup.b()) {
                                arrayList.add(next);
                            } else {
                                arrayList2.add(next);
                            }
                            i++;
                        }
                    } else {
                        throw new IllegalStateException("Nesting an expandable group inside of another expandable group is not supported!");
                    }
                }
            }
        }
        if (b(preferenceGroup) && i > preferenceGroup.b()) {
            arrayList.add(a(preferenceGroup, (List<Preference>) arrayList2));
        }
        return arrayList;
    }

    private b a(final PreferenceGroup preferenceGroup, List<Preference> list) {
        b bVar = new b(preferenceGroup.J(), list, preferenceGroup.c_());
        bVar.a((Preference.c) new Preference.c() {
            public boolean onPreferenceClick(Preference preference) {
                preferenceGroup.h(Integer.MAX_VALUE);
                h.this.b(preference);
                PreferenceGroup.a f = preferenceGroup.f();
                if (f == null) {
                    return true;
                }
                f.a();
                return true;
            }
        });
        return bVar;
    }

    private boolean b(PreferenceGroup preferenceGroup) {
        return preferenceGroup.b() != Integer.MAX_VALUE;
    }

    public Preference a(int i) {
        if (i < 0 || i >= getItemCount()) {
            return null;
        }
        return this.c.get(i);
    }

    public int getItemCount() {
        return this.c.size();
    }

    public long getItemId(int i) {
        if (!hasStableIds()) {
            return -1;
        }
        return a(i).c_();
    }

    public void a(Preference preference) {
        int indexOf = this.c.indexOf(preference);
        if (indexOf != -1) {
            notifyItemChanged(indexOf, preference);
        }
    }

    public void b(Preference preference) {
        this.e.removeCallbacks(this.f);
        this.e.post(this.f);
    }

    public int getItemViewType(int i) {
        a aVar = new a(a(i));
        int indexOf = this.d.indexOf(aVar);
        if (indexOf != -1) {
            return indexOf;
        }
        int size = this.d.size();
        this.d.add(aVar);
        return size;
    }

    /* renamed from: a */
    public l onCreateViewHolder(ViewGroup viewGroup, int i) {
        a aVar = this.d.get(i);
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        TypedArray obtainStyledAttributes = viewGroup.getContext().obtainStyledAttributes((AttributeSet) null, R.styleable.BackgroundStyle);
        Drawable drawable = obtainStyledAttributes.getDrawable(R.styleable.BackgroundStyle_android_selectableItemBackground);
        if (drawable == null) {
            drawable = androidx.appcompat.a.a.a.b(viewGroup.getContext(), 17301602);
        }
        obtainStyledAttributes.recycle();
        View inflate = from.inflate(aVar.f1020a, viewGroup, false);
        if (inflate.getBackground() == null) {
            v.a(inflate, drawable);
        }
        ViewGroup viewGroup2 = (ViewGroup) inflate.findViewById(16908312);
        if (viewGroup2 != null) {
            if (aVar.f1021b != 0) {
                from.inflate(aVar.f1021b, viewGroup2);
            } else {
                viewGroup2.setVisibility(8);
            }
        }
        return new l(inflate);
    }

    /* renamed from: a */
    public void onBindViewHolder(l lVar, int i) {
        a(i).a(lVar);
    }

    /* compiled from: PreferenceGroupAdapter */
    private static class a {

        /* renamed from: a  reason: collision with root package name */
        int f1020a;

        /* renamed from: b  reason: collision with root package name */
        int f1021b;
        String c;

        a(Preference preference) {
            this.c = preference.getClass().getName();
            this.f1020a = preference.u();
            this.f1021b = preference.v();
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (this.f1020a == aVar.f1020a && this.f1021b == aVar.f1021b && TextUtils.equals(this.c, aVar.c)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return ((((527 + this.f1020a) * 31) + this.f1021b) * 31) + this.c.hashCode();
        }
    }
}
