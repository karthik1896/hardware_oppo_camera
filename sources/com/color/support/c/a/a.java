package com.color.support.c.a;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.g.a.d;
import java.util.List;

/* compiled from: ColorViewExplorerByTouchHelper */
public class a extends androidx.customview.a.a {

    /* renamed from: a  reason: collision with root package name */
    private final Rect f1856a = new Rect();

    /* renamed from: b  reason: collision with root package name */
    private View f1857b = null;
    private C0054a c = null;

    /* renamed from: com.color.support.c.a.a$a  reason: collision with other inner class name */
    /* compiled from: ColorViewExplorerByTouchHelper */
    public interface C0054a {
        int a();

        int a(float f, float f2);

        CharSequence a(int i);

        void a(int i, int i2, boolean z);

        void a(int i, Rect rect);

        int b();

        CharSequence c();

        int d();
    }

    public a(View view) {
        super(view);
        this.f1857b = view;
    }

    /* access modifiers changed from: protected */
    public int getVirtualViewAt(float f, float f2) {
        int a2 = this.c.a(f, f2);
        if (a2 >= 0) {
            return a2;
        }
        return Integer.MIN_VALUE;
    }

    /* access modifiers changed from: protected */
    public void getVisibleVirtualViews(List<Integer> list) {
        for (int i = 0; i < this.c.b(); i++) {
            list.add(Integer.valueOf(i));
        }
    }

    /* access modifiers changed from: protected */
    public void onPopulateEventForVirtualView(int i, AccessibilityEvent accessibilityEvent) {
        accessibilityEvent.setContentDescription(this.c.a(i));
    }

    /* access modifiers changed from: protected */
    public void onPopulateNodeForVirtualView(int i, d dVar) {
        a(i, this.f1856a);
        dVar.e(this.c.a(i));
        dVar.b(this.f1856a);
        if (this.c.c() != null) {
            dVar.b(this.c.c());
        }
        dVar.a(16);
        if (i == this.c.a()) {
            dVar.g(true);
        }
        if (i == this.c.d()) {
            dVar.i(false);
        }
    }

    /* access modifiers changed from: protected */
    public boolean onPerformActionForVirtualView(int i, int i2, Bundle bundle) {
        if (i2 != 16) {
            return false;
        }
        this.c.a(i, 16, false);
        return true;
    }

    private void a(int i, Rect rect) {
        if (i >= 0 && i < this.c.b()) {
            this.c.a(i, rect);
        }
    }

    public void a(C0054a aVar) {
        this.c = aVar;
    }
}
