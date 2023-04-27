package androidx.viewpager2.adapter;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.collection.LongSparseArray;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.h;
import androidx.fragment.app.k;
import androidx.lifecycle.e;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

/* compiled from: FragmentStateAdapter */
public abstract class a extends RecyclerView.a<b> implements c {

    /* renamed from: a  reason: collision with root package name */
    final e f1362a;

    /* renamed from: b  reason: collision with root package name */
    final h f1363b;
    final LongSparseArray<Fragment> c;
    private C0040a d;

    public long getItemId(int i) {
        return (long) i;
    }

    /* access modifiers changed from: package-private */
    public void a(b bVar) {
        Fragment fragment = this.c.get(bVar.getItemId());
        if (fragment != null) {
            FrameLayout a2 = bVar.a();
            View view = fragment.getView();
            if (!fragment.isAdded() && view != null) {
                throw new IllegalStateException("Design assumption violated.");
            } else if (fragment.isAdded() && view == null) {
                a(fragment, a2);
            } else if (!fragment.isAdded() || view.getParent() == null) {
                if (fragment.isAdded()) {
                    a(view, a2);
                } else if (!a()) {
                    a(fragment, a2);
                    k a3 = this.f1363b.a();
                    a3.a(fragment, "f" + bVar.getItemId()).a(fragment, e.b.STARTED).d();
                    this.d.a(false);
                } else if (!this.f1363b.e()) {
                    this.f1362a.a(new FragmentStateAdapter$2(this, bVar));
                }
            } else if (view.getParent() != a2) {
                a(view, a2);
            }
        } else {
            throw new IllegalStateException("Design assumption violated.");
        }
    }

    private void a(final Fragment fragment, final FrameLayout frameLayout) {
        this.f1363b.a((h.a) new h.a() {
            public void a(h hVar, Fragment fragment, View view, Bundle bundle) {
                if (fragment == fragment) {
                    hVar.a((h.a) this);
                    a.this.a(view, frameLayout);
                }
            }
        }, false);
    }

    /* access modifiers changed from: package-private */
    public void a(View view, FrameLayout frameLayout) {
        if (frameLayout.getChildCount() > 1) {
            throw new IllegalStateException("Design assumption violated.");
        } else if (view.getParent() != frameLayout) {
            if (frameLayout.getChildCount() > 0) {
                frameLayout.removeAllViews();
            }
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            frameLayout.addView(view);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean a() {
        return this.f1363b.g();
    }

    /* renamed from: androidx.viewpager2.adapter.a$a  reason: collision with other inner class name */
    /* compiled from: FragmentStateAdapter */
    class C0040a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f1366a;

        /* renamed from: b  reason: collision with root package name */
        private ViewPager2 f1367b;
        private long c;

        /* access modifiers changed from: package-private */
        public void a(boolean z) {
            int currentItem;
            Fragment fragment;
            if (!this.f1366a.a() && this.f1367b.getScrollState() == 0 && !this.f1366a.c.isEmpty() && this.f1366a.getItemCount() != 0 && (currentItem = this.f1367b.getCurrentItem()) < this.f1366a.getItemCount()) {
                long itemId = this.f1366a.getItemId(currentItem);
                if ((itemId != this.c || z) && (fragment = this.f1366a.c.get(itemId)) != null && fragment.isAdded()) {
                    this.c = itemId;
                    k a2 = this.f1366a.f1363b.a();
                    Fragment fragment2 = null;
                    for (int i = 0; i < this.f1366a.c.size(); i++) {
                        long keyAt = this.f1366a.c.keyAt(i);
                        Fragment valueAt = this.f1366a.c.valueAt(i);
                        if (valueAt.isAdded()) {
                            if (keyAt != this.c) {
                                a2.a(valueAt, e.b.STARTED);
                            } else {
                                fragment2 = valueAt;
                            }
                            valueAt.setMenuVisibility(keyAt == this.c);
                        }
                    }
                    if (fragment2 != null) {
                        a2.a(fragment2, e.b.RESUMED);
                    }
                    if (!a2.h()) {
                        a2.d();
                    }
                }
            }
        }
    }
}
