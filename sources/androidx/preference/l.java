package androidx.preference;

import android.util.SparseArray;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: PreferenceViewHolder */
public class l extends RecyclerView.w {

    /* renamed from: a  reason: collision with root package name */
    private final SparseArray<View> f1031a = new SparseArray<>(4);

    /* renamed from: b  reason: collision with root package name */
    private boolean f1032b;
    private boolean c;

    l(View view) {
        super(view);
        this.f1031a.put(16908310, view.findViewById(16908310));
        this.f1031a.put(16908304, view.findViewById(16908304));
        this.f1031a.put(16908294, view.findViewById(16908294));
        this.f1031a.put(R.id.icon_frame, view.findViewById(R.id.icon_frame));
        this.f1031a.put(16908350, view.findViewById(16908350));
    }

    public View a(int i) {
        View view = this.f1031a.get(i);
        if (view != null) {
            return view;
        }
        View findViewById = this.itemView.findViewById(i);
        if (findViewById != null) {
            this.f1031a.put(i, findViewById);
        }
        return findViewById;
    }

    public boolean a() {
        return this.f1032b;
    }

    public void a(boolean z) {
        this.f1032b = z;
    }

    public boolean b() {
        return this.c;
    }

    public void b(boolean z) {
        this.c = z;
    }
}
