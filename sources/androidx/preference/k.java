package androidx.preference;

import android.os.Bundle;
import android.view.View;
import androidx.core.g.a;
import androidx.core.g.a.d;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.p;

@Deprecated
/* compiled from: PreferenceRecyclerViewAccessibilityDelegate */
public class k extends p {

    /* renamed from: a  reason: collision with root package name */
    final RecyclerView f1028a;

    /* renamed from: b  reason: collision with root package name */
    final a f1029b = super.getItemDelegate();
    final a c = new a() {
        public void onInitializeAccessibilityNodeInfo(View view, d dVar) {
            Preference a2;
            k.this.f1029b.onInitializeAccessibilityNodeInfo(view, dVar);
            int childAdapterPosition = k.this.f1028a.getChildAdapterPosition(view);
            RecyclerView.a adapter = k.this.f1028a.getAdapter();
            if ((adapter instanceof h) && (a2 = ((h) adapter).a(childAdapterPosition)) != null) {
                a2.a(dVar);
            }
        }

        public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
            return k.this.f1029b.performAccessibilityAction(view, i, bundle);
        }
    };

    public k(RecyclerView recyclerView) {
        super(recyclerView);
        this.f1028a = recyclerView;
    }

    public a getItemDelegate() {
        return this.c;
    }
}
