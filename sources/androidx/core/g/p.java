package androidx.core.g;

import android.view.View;
import android.view.ViewGroup;

/* compiled from: NestedScrollingParentHelper */
public class p {

    /* renamed from: a  reason: collision with root package name */
    private int f706a;

    /* renamed from: b  reason: collision with root package name */
    private int f707b;

    public p(ViewGroup viewGroup) {
    }

    public void a(View view, View view2, int i) {
        a(view, view2, i, 0);
    }

    public void a(View view, View view2, int i, int i2) {
        if (i2 == 1) {
            this.f707b = i;
        } else {
            this.f706a = i;
        }
    }

    public int a() {
        return this.f706a | this.f707b;
    }

    public void a(View view, int i) {
        if (i == 1) {
            this.f707b = 0;
        } else {
            this.f706a = 0;
        }
    }
}
