package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.b;
import androidx.appcompat.view.menu.h;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.view.menu.n;
import androidx.appcompat.view.menu.o;
import androidx.appcompat.view.menu.q;
import androidx.appcompat.view.menu.s;
import androidx.appcompat.widget.ActionMenuView;
import androidx.core.g.b;
import java.util.ArrayList;

class ActionMenuPresenter extends androidx.appcompat.view.menu.c implements b.a {
    OverflowMenuButton g;
    d h;
    a i;
    c j;
    final e k = new e();
    int l;
    private Drawable m;
    private boolean n;
    private boolean o;
    private boolean p;
    private int q;
    private int r;
    private int s;
    private boolean t;
    private boolean u;
    private boolean v;
    private boolean w;
    private int x;
    private final SparseBooleanArray y = new SparseBooleanArray();
    private b z;

    public ActionMenuPresenter(Context context) {
        super(context, R.layout.abc_action_menu_layout, R.layout.abc_action_menu_item_layout);
    }

    public void initForMenu(Context context, h hVar) {
        super.initForMenu(context, hVar);
        Resources resources = context.getResources();
        androidx.appcompat.view.a a2 = androidx.appcompat.view.a.a(context);
        if (!this.p) {
            this.o = a2.b();
        }
        if (!this.v) {
            this.q = a2.c();
        }
        if (!this.t) {
            this.s = a2.a();
        }
        int i2 = this.q;
        if (this.o) {
            if (this.g == null) {
                this.g = new OverflowMenuButton(this.f248a);
                if (this.n) {
                    this.g.setImageDrawable(this.m);
                    this.m = null;
                    this.n = false;
                }
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                this.g.measure(makeMeasureSpec, makeMeasureSpec);
            }
            i2 -= this.g.getMeasuredWidth();
        } else {
            this.g = null;
        }
        this.r = i2;
        this.x = (int) (resources.getDisplayMetrics().density * 56.0f);
    }

    public void a(Configuration configuration) {
        if (!this.t) {
            this.s = androidx.appcompat.view.a.a(this.f249b).a();
        }
        if (this.c != null) {
            this.c.onItemsChanged(true);
        }
    }

    public void a(boolean z2) {
        this.o = z2;
        this.p = true;
    }

    public void b(boolean z2) {
        this.w = z2;
    }

    public void a(Drawable drawable) {
        OverflowMenuButton overflowMenuButton = this.g;
        if (overflowMenuButton != null) {
            overflowMenuButton.setImageDrawable(drawable);
            return;
        }
        this.n = true;
        this.m = drawable;
    }

    public Drawable b() {
        OverflowMenuButton overflowMenuButton = this.g;
        if (overflowMenuButton != null) {
            return overflowMenuButton.getDrawable();
        }
        if (this.n) {
            return this.m;
        }
        return null;
    }

    public o a(ViewGroup viewGroup) {
        o oVar = this.f;
        o a2 = super.a(viewGroup);
        if (oVar != a2) {
            ((ActionMenuView) a2).setPresenter(this);
        }
        return a2;
    }

    public View a(j jVar, View view, ViewGroup viewGroup) {
        View actionView = jVar.getActionView();
        if (actionView == null || jVar.n()) {
            actionView = super.a(jVar, view, viewGroup);
        }
        actionView.setVisibility(jVar.isActionViewExpanded() ? 8 : 0);
        ActionMenuView actionMenuView = (ActionMenuView) viewGroup;
        ViewGroup.LayoutParams layoutParams = actionView.getLayoutParams();
        if (!actionMenuView.checkLayoutParams(layoutParams)) {
            actionView.setLayoutParams(actionMenuView.generateLayoutParams(layoutParams));
        }
        return actionView;
    }

    public void a(j jVar, o.a aVar) {
        aVar.initialize(jVar, 0);
        androidx.appcompat.view.menu.b bVar = (androidx.appcompat.view.menu.b) aVar;
        bVar.setItemInvoker((ActionMenuView) this.f);
        if (this.z == null) {
            this.z = new b();
        }
        bVar.setPopupCallback(this.z);
    }

    public boolean a(int i2, j jVar) {
        return jVar.j();
    }

    public void updateMenuView(boolean z2) {
        super.updateMenuView(z2);
        ((View) this.f).requestLayout();
        boolean z3 = false;
        if (this.c != null) {
            ArrayList<j> actionItems = this.c.getActionItems();
            int size = actionItems.size();
            for (int i2 = 0; i2 < size; i2++) {
                androidx.core.g.b a2 = actionItems.get(i2).a();
                if (a2 != null) {
                    a2.a((b.a) this);
                }
            }
        }
        ArrayList<j> nonActionItems = this.c != null ? this.c.getNonActionItems() : null;
        if (this.o && nonActionItems != null) {
            int size2 = nonActionItems.size();
            if (size2 == 1) {
                z3 = !nonActionItems.get(0).isActionViewExpanded();
            } else if (size2 > 0) {
                z3 = true;
            }
        }
        if (z3) {
            if (this.g == null) {
                this.g = new OverflowMenuButton(this.f248a);
            }
            ViewGroup viewGroup = (ViewGroup) this.g.getParent();
            if (viewGroup != this.f) {
                if (viewGroup != null) {
                    viewGroup.removeView(this.g);
                }
                ActionMenuView actionMenuView = (ActionMenuView) this.f;
                actionMenuView.addView(this.g, actionMenuView.c());
            }
        } else {
            OverflowMenuButton overflowMenuButton = this.g;
            if (overflowMenuButton != null && overflowMenuButton.getParent() == this.f) {
                ((ViewGroup) this.f).removeView(this.g);
            }
        }
        ((ActionMenuView) this.f).setOverflowReserved(this.o);
    }

    public boolean a(ViewGroup viewGroup, int i2) {
        if (viewGroup.getChildAt(i2) == this.g) {
            return false;
        }
        return super.a(viewGroup, i2);
    }

    public boolean onSubMenuSelected(s sVar) {
        boolean z2 = false;
        if (!sVar.hasVisibleItems()) {
            return false;
        }
        s sVar2 = sVar;
        while (sVar2.getParentMenu() != this.c) {
            sVar2 = (s) sVar2.getParentMenu();
        }
        View a2 = a(sVar2.getItem());
        if (a2 == null) {
            return false;
        }
        this.l = sVar.getItem().getItemId();
        int size = sVar.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                break;
            }
            MenuItem item = sVar.getItem(i2);
            if (item.isVisible() && item.getIcon() != null) {
                z2 = true;
                break;
            }
            i2++;
        }
        this.i = new a(this.f249b, sVar, a2);
        this.i.a(z2);
        this.i.a();
        super.onSubMenuSelected(sVar);
        return true;
    }

    private View a(MenuItem menuItem) {
        ViewGroup viewGroup = (ViewGroup) this.f;
        if (viewGroup == null) {
            return null;
        }
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = viewGroup.getChildAt(i2);
            if ((childAt instanceof o.a) && ((o.a) childAt).getItemData() == menuItem) {
                return childAt;
            }
        }
        return null;
    }

    public boolean c() {
        if (!this.o || g() || this.c == null || this.f == null || this.j != null || this.c.getNonActionItems().isEmpty()) {
            return false;
        }
        this.j = new c(new d(this.f249b, this.c, this.g, true));
        ((View) this.f).post(this.j);
        super.onSubMenuSelected((s) null);
        return true;
    }

    public boolean d() {
        if (this.j == null || this.f == null) {
            d dVar = this.h;
            if (dVar == null) {
                return false;
            }
            dVar.d();
            return true;
        }
        ((View) this.f).removeCallbacks(this.j);
        this.j = null;
        return true;
    }

    public boolean e() {
        return d() | f();
    }

    public boolean f() {
        a aVar = this.i;
        if (aVar == null) {
            return false;
        }
        aVar.d();
        return true;
    }

    public boolean g() {
        d dVar = this.h;
        return dVar != null && dVar.f();
    }

    public boolean h() {
        return this.j != null || g();
    }

    public boolean flagActionItems() {
        int i2;
        ArrayList<j> arrayList;
        int i3;
        int i4;
        int i5;
        boolean z2;
        boolean z3;
        ActionMenuPresenter actionMenuPresenter = this;
        View view = null;
        boolean z4 = false;
        if (actionMenuPresenter.c != null) {
            arrayList = actionMenuPresenter.c.getVisibleItems();
            i2 = arrayList.size();
        } else {
            arrayList = null;
            i2 = 0;
        }
        int i6 = actionMenuPresenter.s;
        int i7 = actionMenuPresenter.r;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup viewGroup = (ViewGroup) actionMenuPresenter.f;
        boolean z5 = false;
        int i8 = 0;
        int i9 = 0;
        int i10 = i6;
        for (int i11 = 0; i11 < i2; i11++) {
            j jVar = arrayList.get(i11);
            if (jVar.l()) {
                i8++;
            } else if (jVar.k()) {
                i9++;
            } else {
                z5 = true;
            }
            if (actionMenuPresenter.w && jVar.isActionViewExpanded()) {
                i10 = 0;
            }
        }
        if (actionMenuPresenter.o && (z5 || i9 + i8 > i10)) {
            i10--;
        }
        int i12 = i10 - i8;
        SparseBooleanArray sparseBooleanArray = actionMenuPresenter.y;
        sparseBooleanArray.clear();
        if (actionMenuPresenter.u) {
            int i13 = actionMenuPresenter.x;
            i3 = i7 / i13;
            i4 = i13 + ((i7 % i13) / i3);
        } else {
            i4 = 0;
            i3 = 0;
        }
        int i14 = 0;
        int i15 = i7;
        int i16 = 0;
        while (i16 < i2) {
            j jVar2 = arrayList.get(i16);
            if (jVar2.l()) {
                View a2 = actionMenuPresenter.a(jVar2, view, viewGroup);
                if (actionMenuPresenter.u) {
                    i3 -= ActionMenuView.a(a2, i4, i3, makeMeasureSpec, z4 ? 1 : 0);
                } else {
                    a2.measure(makeMeasureSpec, makeMeasureSpec);
                }
                int measuredWidth = a2.getMeasuredWidth();
                i15 -= measuredWidth;
                if (i14 != 0) {
                    measuredWidth = i14;
                }
                int groupId = jVar2.getGroupId();
                if (groupId != 0) {
                    z3 = true;
                    sparseBooleanArray.put(groupId, true);
                } else {
                    z3 = true;
                }
                jVar2.d(z3);
                i14 = measuredWidth;
                z2 = z4;
                i5 = i2;
            } else if (jVar2.k()) {
                int groupId2 = jVar2.getGroupId();
                boolean z6 = sparseBooleanArray.get(groupId2);
                boolean z7 = (i12 > 0 || z6) && i15 > 0 && (!actionMenuPresenter.u || i3 > 0);
                if (z7) {
                    boolean z8 = z7;
                    i5 = i2;
                    View a3 = actionMenuPresenter.a(jVar2, (View) null, viewGroup);
                    if (actionMenuPresenter.u) {
                        int a4 = ActionMenuView.a(a3, i4, i3, makeMeasureSpec, 0);
                        i3 -= a4;
                        z8 = a4 == 0 ? false : z8;
                    } else {
                        a3.measure(makeMeasureSpec, makeMeasureSpec);
                    }
                    int measuredWidth2 = a3.getMeasuredWidth();
                    i15 -= measuredWidth2;
                    if (i14 == 0) {
                        i14 = measuredWidth2;
                    }
                    z7 = z8 & (!actionMenuPresenter.u ? i15 + i14 > 0 : i15 >= 0);
                } else {
                    boolean z9 = z7;
                    i5 = i2;
                }
                if (z7 && groupId2 != 0) {
                    sparseBooleanArray.put(groupId2, true);
                } else if (z6) {
                    sparseBooleanArray.put(groupId2, false);
                    int i17 = 0;
                    while (i17 < i16) {
                        j jVar3 = arrayList.get(i17);
                        if (jVar3.getGroupId() == groupId2) {
                            if (jVar3.j()) {
                                i12++;
                            }
                            jVar3.d(false);
                        }
                        i17++;
                    }
                }
                if (z7) {
                    i12--;
                }
                jVar2.d(z7);
                z2 = false;
            } else {
                z2 = z4;
                i5 = i2;
                jVar2.d(z2);
            }
            i16++;
            z4 = z2;
            i2 = i5;
            view = null;
            actionMenuPresenter = this;
        }
        return true;
    }

    public void onCloseMenu(h hVar, boolean z2) {
        e();
        super.onCloseMenu(hVar, z2);
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState();
        savedState.openSubMenuId = this.l;
        return savedState;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        MenuItem findItem;
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            if (savedState.openSubMenuId > 0 && (findItem = this.c.findItem(savedState.openSubMenuId)) != null) {
                onSubMenuSelected((s) findItem.getSubMenu());
            }
        }
    }

    public void c(boolean z2) {
        if (z2) {
            super.onSubMenuSelected((s) null);
        } else if (this.c != null) {
            this.c.close(false);
        }
    }

    public void a(ActionMenuView actionMenuView) {
        this.f = actionMenuView;
        actionMenuView.initialize(this.c);
    }

    @SuppressLint({"BanParcelableUsage"})
    private static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* renamed from: a */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        public int openSubMenuId;

        public int describeContents() {
            return 0;
        }

        SavedState() {
        }

        SavedState(Parcel parcel) {
            this.openSubMenuId = parcel.readInt();
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.openSubMenuId);
        }
    }

    private class OverflowMenuButton extends AppCompatImageView implements ActionMenuView.a {

        /* renamed from: b  reason: collision with root package name */
        private final float[] f300b = new float[2];

        public boolean b() {
            return false;
        }

        public boolean c() {
            return false;
        }

        public OverflowMenuButton(Context context) {
            super(context, (AttributeSet) null, R.attr.actionOverflowButtonStyle);
            setClickable(true);
            setFocusable(true);
            setVisibility(0);
            setEnabled(true);
            at.a(this, getContentDescription());
            setOnTouchListener(new ad(this, ActionMenuPresenter.this) {
                public q a() {
                    if (ActionMenuPresenter.this.h == null) {
                        return null;
                    }
                    return ActionMenuPresenter.this.h.b();
                }

                public boolean b() {
                    ActionMenuPresenter.this.c();
                    return true;
                }

                public boolean c() {
                    if (ActionMenuPresenter.this.j != null) {
                        return false;
                    }
                    ActionMenuPresenter.this.d();
                    return true;
                }
            });
        }

        public boolean performClick() {
            if (super.performClick()) {
                return true;
            }
            playSoundEffect(0);
            ActionMenuPresenter.this.c();
            return true;
        }

        /* access modifiers changed from: protected */
        public boolean setFrame(int i, int i2, int i3, int i4) {
            boolean frame = super.setFrame(i, i2, i3, i4);
            Drawable drawable = getDrawable();
            Drawable background = getBackground();
            if (!(drawable == null || background == null)) {
                int width = getWidth();
                int height = getHeight();
                int max = Math.max(width, height) / 2;
                int paddingLeft = (width + (getPaddingLeft() - getPaddingRight())) / 2;
                int paddingTop = (height + (getPaddingTop() - getPaddingBottom())) / 2;
                androidx.core.graphics.drawable.a.a(background, paddingLeft - max, paddingTop - max, paddingLeft + max, paddingTop + max);
            }
            return frame;
        }
    }

    private class d extends m {
        public d(Context context, h hVar, View view, boolean z) {
            super(context, hVar, view, z, R.attr.actionOverflowMenuStyle);
            a(8388613);
            a((n.a) ActionMenuPresenter.this.k);
        }

        /* access modifiers changed from: protected */
        public void e() {
            if (ActionMenuPresenter.this.c != null) {
                ActionMenuPresenter.this.c.close();
            }
            ActionMenuPresenter.this.h = null;
            super.e();
        }
    }

    private class a extends m {
        public a(Context context, s sVar, View view) {
            super(context, sVar, view, false, R.attr.actionOverflowMenuStyle);
            if (!((j) sVar.getItem()).j()) {
                a(ActionMenuPresenter.this.g == null ? (View) ActionMenuPresenter.this.f : ActionMenuPresenter.this.g);
            }
            a((n.a) ActionMenuPresenter.this.k);
        }

        /* access modifiers changed from: protected */
        public void e() {
            ActionMenuPresenter actionMenuPresenter = ActionMenuPresenter.this;
            actionMenuPresenter.i = null;
            actionMenuPresenter.l = 0;
            super.e();
        }
    }

    private class e implements n.a {
        e() {
        }

        public boolean a(h hVar) {
            if (hVar == null) {
                return false;
            }
            ActionMenuPresenter.this.l = ((s) hVar).getItem().getItemId();
            n.a a2 = ActionMenuPresenter.this.a();
            if (a2 != null) {
                return a2.a(hVar);
            }
            return false;
        }

        public void a(h hVar, boolean z) {
            if (hVar instanceof s) {
                hVar.getRootMenu().close(false);
            }
            n.a a2 = ActionMenuPresenter.this.a();
            if (a2 != null) {
                a2.a(hVar, z);
            }
        }
    }

    private class c implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        private d f306b;

        public c(d dVar) {
            this.f306b = dVar;
        }

        public void run() {
            if (ActionMenuPresenter.this.c != null) {
                ActionMenuPresenter.this.c.changeMenuMode();
            }
            View view = (View) ActionMenuPresenter.this.f;
            if (!(view == null || view.getWindowToken() == null || !this.f306b.c())) {
                ActionMenuPresenter.this.h = this.f306b;
            }
            ActionMenuPresenter.this.j = null;
        }
    }

    private class b extends b.C0006b {
        b() {
        }

        public q a() {
            if (ActionMenuPresenter.this.i != null) {
                return ActionMenuPresenter.this.i.b();
            }
            return null;
        }
    }
}
