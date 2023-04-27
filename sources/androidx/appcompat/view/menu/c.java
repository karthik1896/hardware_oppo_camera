package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.view.menu.n;
import androidx.appcompat.view.menu.o;
import java.util.ArrayList;

/* compiled from: BaseMenuPresenter */
public abstract class c implements n {

    /* renamed from: a  reason: collision with root package name */
    protected Context f248a;

    /* renamed from: b  reason: collision with root package name */
    protected Context f249b;
    protected h c;
    protected LayoutInflater d;
    protected LayoutInflater e;
    protected o f;
    private n.a g;
    private int h;
    private int i;
    private int j;

    public abstract void a(j jVar, o.a aVar);

    public boolean a(int i2, j jVar) {
        return true;
    }

    public boolean collapseItemActionView(h hVar, j jVar) {
        return false;
    }

    public boolean expandItemActionView(h hVar, j jVar) {
        return false;
    }

    public boolean flagActionItems() {
        return false;
    }

    public c(Context context, int i2, int i3) {
        this.f248a = context;
        this.d = LayoutInflater.from(context);
        this.h = i2;
        this.i = i3;
    }

    public void initForMenu(Context context, h hVar) {
        this.f249b = context;
        this.e = LayoutInflater.from(this.f249b);
        this.c = hVar;
    }

    public o a(ViewGroup viewGroup) {
        if (this.f == null) {
            this.f = (o) this.d.inflate(this.h, viewGroup, false);
            this.f.initialize(this.c);
            updateMenuView(true);
        }
        return this.f;
    }

    public void updateMenuView(boolean z) {
        ViewGroup viewGroup = (ViewGroup) this.f;
        if (viewGroup != null) {
            h hVar = this.c;
            int i2 = 0;
            if (hVar != null) {
                hVar.flagActionItems();
                ArrayList<j> visibleItems = this.c.getVisibleItems();
                int size = visibleItems.size();
                int i3 = 0;
                for (int i4 = 0; i4 < size; i4++) {
                    j jVar = visibleItems.get(i4);
                    if (a(i3, jVar)) {
                        View childAt = viewGroup.getChildAt(i3);
                        j itemData = childAt instanceof o.a ? ((o.a) childAt).getItemData() : null;
                        View a2 = a(jVar, childAt, viewGroup);
                        if (jVar != itemData) {
                            a2.setPressed(false);
                            a2.jumpDrawablesToCurrentState();
                        }
                        if (a2 != childAt) {
                            a(a2, i3);
                        }
                        i3++;
                    }
                }
                i2 = i3;
            }
            while (i2 < viewGroup.getChildCount()) {
                if (!a(viewGroup, i2)) {
                    i2++;
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void a(View view, int i2) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(view);
        }
        ((ViewGroup) this.f).addView(view, i2);
    }

    /* access modifiers changed from: protected */
    public boolean a(ViewGroup viewGroup, int i2) {
        viewGroup.removeViewAt(i2);
        return true;
    }

    public void setCallback(n.a aVar) {
        this.g = aVar;
    }

    public n.a a() {
        return this.g;
    }

    public o.a b(ViewGroup viewGroup) {
        return (o.a) this.d.inflate(this.i, viewGroup, false);
    }

    public View a(j jVar, View view, ViewGroup viewGroup) {
        o.a aVar;
        if (view instanceof o.a) {
            aVar = (o.a) view;
        } else {
            aVar = b(viewGroup);
        }
        a(jVar, aVar);
        return (View) aVar;
    }

    public void onCloseMenu(h hVar, boolean z) {
        n.a aVar = this.g;
        if (aVar != null) {
            aVar.a(hVar, z);
        }
    }

    public boolean onSubMenuSelected(s sVar) {
        n.a aVar = this.g;
        if (aVar != null) {
            return aVar.a(sVar);
        }
        return false;
    }

    public int getId() {
        return this.j;
    }

    public void a(int i2) {
        this.j = i2;
    }
}
