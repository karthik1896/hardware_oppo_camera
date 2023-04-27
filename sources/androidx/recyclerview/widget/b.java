package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;

/* compiled from: AdapterListUpdateCallback */
public final class b implements l {

    /* renamed from: a  reason: collision with root package name */
    private final RecyclerView.a f1091a;

    public b(RecyclerView.a aVar) {
        this.f1091a = aVar;
    }

    public void a(int i, int i2) {
        this.f1091a.notifyItemRangeInserted(i, i2);
    }

    public void b(int i, int i2) {
        this.f1091a.notifyItemRangeRemoved(i, i2);
    }

    public void c(int i, int i2) {
        this.f1091a.notifyItemMoved(i, i2);
    }

    public void a(int i, int i2, Object obj) {
        this.f1091a.notifyItemRangeChanged(i, i2, obj);
    }
}
