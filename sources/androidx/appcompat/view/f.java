package androidx.appcompat.view;

import android.content.Context;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.view.b;
import androidx.appcompat.view.menu.k;
import androidx.appcompat.view.menu.p;
import androidx.collection.SimpleArrayMap;
import java.util.ArrayList;

/* compiled from: SupportActionModeWrapper */
public class f extends ActionMode {

    /* renamed from: a  reason: collision with root package name */
    final Context f224a;

    /* renamed from: b  reason: collision with root package name */
    final b f225b;

    public f(Context context, b bVar) {
        this.f224a = context;
        this.f225b = bVar;
    }

    public Object getTag() {
        return this.f225b.j();
    }

    public void setTag(Object obj) {
        this.f225b.a(obj);
    }

    public void setTitle(CharSequence charSequence) {
        this.f225b.b(charSequence);
    }

    public void setSubtitle(CharSequence charSequence) {
        this.f225b.a(charSequence);
    }

    public void invalidate() {
        this.f225b.d();
    }

    public void finish() {
        this.f225b.c();
    }

    public Menu getMenu() {
        return new p(this.f224a, (androidx.core.a.a.a) this.f225b.b());
    }

    public CharSequence getTitle() {
        return this.f225b.f();
    }

    public void setTitle(int i) {
        this.f225b.a(i);
    }

    public CharSequence getSubtitle() {
        return this.f225b.g();
    }

    public void setSubtitle(int i) {
        this.f225b.b(i);
    }

    public View getCustomView() {
        return this.f225b.i();
    }

    public void setCustomView(View view) {
        this.f225b.a(view);
    }

    public MenuInflater getMenuInflater() {
        return this.f225b.a();
    }

    public boolean getTitleOptionalHint() {
        return this.f225b.k();
    }

    public void setTitleOptionalHint(boolean z) {
        this.f225b.a(z);
    }

    public boolean isTitleOptional() {
        return this.f225b.h();
    }

    /* compiled from: SupportActionModeWrapper */
    public static class a implements b.a {

        /* renamed from: a  reason: collision with root package name */
        final ActionMode.Callback f226a;

        /* renamed from: b  reason: collision with root package name */
        final Context f227b;
        final ArrayList<f> c = new ArrayList<>();
        final SimpleArrayMap<Menu, Menu> d = new SimpleArrayMap<>();

        public a(Context context, ActionMode.Callback callback) {
            this.f227b = context;
            this.f226a = callback;
        }

        public boolean a(b bVar, Menu menu) {
            return this.f226a.onCreateActionMode(b(bVar), a(menu));
        }

        public boolean b(b bVar, Menu menu) {
            return this.f226a.onPrepareActionMode(b(bVar), a(menu));
        }

        public boolean a(b bVar, MenuItem menuItem) {
            return this.f226a.onActionItemClicked(b(bVar), new k(this.f227b, (androidx.core.a.a.b) menuItem));
        }

        public void a(b bVar) {
            this.f226a.onDestroyActionMode(b(bVar));
        }

        private Menu a(Menu menu) {
            Menu menu2 = this.d.get(menu);
            if (menu2 != null) {
                return menu2;
            }
            p pVar = new p(this.f227b, (androidx.core.a.a.a) menu);
            this.d.put(menu, pVar);
            return pVar;
        }

        public ActionMode b(b bVar) {
            int size = this.c.size();
            for (int i = 0; i < size; i++) {
                f fVar = this.c.get(i);
                if (fVar != null && fVar.f225b == bVar) {
                    return fVar;
                }
            }
            f fVar2 = new f(this.f227b, bVar);
            this.c.add(fVar2);
            return fVar2;
        }
    }
}
