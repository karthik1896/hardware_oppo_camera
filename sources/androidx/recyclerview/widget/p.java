package androidx.recyclerview.widget;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.g.a.d;
import androidx.core.g.a.e;
import androidx.core.g.v;
import java.util.Map;
import java.util.WeakHashMap;

/* compiled from: RecyclerViewAccessibilityDelegate */
public class p extends androidx.core.g.a {
    private final a mItemDelegate;
    final RecyclerView mRecyclerView;

    public p(RecyclerView recyclerView) {
        this.mRecyclerView = recyclerView;
        androidx.core.g.a itemDelegate = getItemDelegate();
        if (itemDelegate == null || !(itemDelegate instanceof a)) {
            this.mItemDelegate = new a(this);
        } else {
            this.mItemDelegate = (a) itemDelegate;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean shouldIgnore() {
        return this.mRecyclerView.hasPendingAdapterUpdates();
    }

    public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
        if (super.performAccessibilityAction(view, i, bundle)) {
            return true;
        }
        if (shouldIgnore() || this.mRecyclerView.getLayoutManager() == null) {
            return false;
        }
        return this.mRecyclerView.getLayoutManager().performAccessibilityAction(i, bundle);
    }

    public void onInitializeAccessibilityNodeInfo(View view, d dVar) {
        super.onInitializeAccessibilityNodeInfo(view, dVar);
        if (!shouldIgnore() && this.mRecyclerView.getLayoutManager() != null) {
            this.mRecyclerView.getLayoutManager().onInitializeAccessibilityNodeInfo(dVar);
        }
    }

    public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(view, accessibilityEvent);
        if ((view instanceof RecyclerView) && !shouldIgnore()) {
            RecyclerView recyclerView = (RecyclerView) view;
            if (recyclerView.getLayoutManager() != null) {
                recyclerView.getLayoutManager().onInitializeAccessibilityEvent(accessibilityEvent);
            }
        }
    }

    public androidx.core.g.a getItemDelegate() {
        return this.mItemDelegate;
    }

    /* compiled from: RecyclerViewAccessibilityDelegate */
    public static class a extends androidx.core.g.a {

        /* renamed from: a  reason: collision with root package name */
        final p f1150a;

        /* renamed from: b  reason: collision with root package name */
        private Map<View, androidx.core.g.a> f1151b = new WeakHashMap();

        public a(p pVar) {
            this.f1150a = pVar;
        }

        /* access modifiers changed from: package-private */
        public void a(View view) {
            androidx.core.g.a b2 = v.b(view);
            if (b2 != null && b2 != this) {
                this.f1151b.put(view, b2);
            }
        }

        /* access modifiers changed from: package-private */
        public androidx.core.g.a b(View view) {
            return this.f1151b.remove(view);
        }

        public void onInitializeAccessibilityNodeInfo(View view, d dVar) {
            if (this.f1150a.shouldIgnore() || this.f1150a.mRecyclerView.getLayoutManager() == null) {
                super.onInitializeAccessibilityNodeInfo(view, dVar);
                return;
            }
            this.f1150a.mRecyclerView.getLayoutManager().onInitializeAccessibilityNodeInfoForItem(view, dVar);
            androidx.core.g.a aVar = this.f1151b.get(view);
            if (aVar != null) {
                aVar.onInitializeAccessibilityNodeInfo(view, dVar);
            } else {
                super.onInitializeAccessibilityNodeInfo(view, dVar);
            }
        }

        public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
            if (this.f1150a.shouldIgnore() || this.f1150a.mRecyclerView.getLayoutManager() == null) {
                return super.performAccessibilityAction(view, i, bundle);
            }
            androidx.core.g.a aVar = this.f1151b.get(view);
            if (aVar != null) {
                if (aVar.performAccessibilityAction(view, i, bundle)) {
                    return true;
                }
            } else if (super.performAccessibilityAction(view, i, bundle)) {
                return true;
            }
            return this.f1150a.mRecyclerView.getLayoutManager().performAccessibilityActionForItem(view, i, bundle);
        }

        public void sendAccessibilityEvent(View view, int i) {
            androidx.core.g.a aVar = this.f1151b.get(view);
            if (aVar != null) {
                aVar.sendAccessibilityEvent(view, i);
            } else {
                super.sendAccessibilityEvent(view, i);
            }
        }

        public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
            androidx.core.g.a aVar = this.f1151b.get(view);
            if (aVar != null) {
                aVar.sendAccessibilityEventUnchecked(view, accessibilityEvent);
            } else {
                super.sendAccessibilityEventUnchecked(view, accessibilityEvent);
            }
        }

        public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            androidx.core.g.a aVar = this.f1151b.get(view);
            if (aVar != null) {
                return aVar.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
            }
            return super.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
        }

        public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            androidx.core.g.a aVar = this.f1151b.get(view);
            if (aVar != null) {
                aVar.onPopulateAccessibilityEvent(view, accessibilityEvent);
            } else {
                super.onPopulateAccessibilityEvent(view, accessibilityEvent);
            }
        }

        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            androidx.core.g.a aVar = this.f1151b.get(view);
            if (aVar != null) {
                aVar.onInitializeAccessibilityEvent(view, accessibilityEvent);
            } else {
                super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            }
        }

        public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            androidx.core.g.a aVar = this.f1151b.get(viewGroup);
            if (aVar != null) {
                return aVar.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
            }
            return super.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
        }

        public e getAccessibilityNodeProvider(View view) {
            androidx.core.g.a aVar = this.f1151b.get(view);
            if (aVar != null) {
                return aVar.getAccessibilityNodeProvider(view);
            }
            return super.getAccessibilityNodeProvider(view);
        }
    }
}
