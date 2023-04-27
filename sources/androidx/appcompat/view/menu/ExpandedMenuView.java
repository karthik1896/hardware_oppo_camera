package androidx.appcompat.view.menu;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.appcompat.view.menu.h;
import androidx.appcompat.widget.ar;

public final class ExpandedMenuView extends ListView implements AdapterView.OnItemClickListener, h.b, o {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f239a = {16842964, 16843049};

    /* renamed from: b  reason: collision with root package name */
    private h f240b;
    private int c;

    public ExpandedMenuView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842868);
    }

    public ExpandedMenuView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        setOnItemClickListener(this);
        ar a2 = ar.a(context, attributeSet, f239a, i, 0);
        if (a2.g(0)) {
            setBackgroundDrawable(a2.a(0));
        }
        if (a2.g(1)) {
            setDivider(a2.a(1));
        }
        a2.b();
    }

    public void initialize(h hVar) {
        this.f240b = hVar;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setChildrenDrawingCacheEnabled(false);
    }

    public boolean a(j jVar) {
        return this.f240b.performItemAction(jVar, 0);
    }

    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        a((j) getAdapter().getItem(i));
    }

    public int getWindowAnimations() {
        return this.c;
    }
}
