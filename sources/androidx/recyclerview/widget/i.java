package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: LayoutState */
class i {

    /* renamed from: a  reason: collision with root package name */
    boolean f1142a = true;

    /* renamed from: b  reason: collision with root package name */
    int f1143b;
    int c;
    int d;
    int e;
    int f = 0;
    int g = 0;
    boolean h;
    boolean i;

    i() {
    }

    /* access modifiers changed from: package-private */
    public boolean a(RecyclerView.t tVar) {
        int i2 = this.c;
        return i2 >= 0 && i2 < tVar.e();
    }

    /* access modifiers changed from: package-private */
    public View a(RecyclerView.p pVar) {
        View c2 = pVar.c(this.c);
        this.c += this.d;
        return c2;
    }

    public String toString() {
        return "LayoutState{mAvailable=" + this.f1143b + ", mCurrentPosition=" + this.c + ", mItemDirection=" + this.d + ", mLayoutDirection=" + this.e + ", mStartLine=" + this.f + ", mEndLine=" + this.g + '}';
    }
}
