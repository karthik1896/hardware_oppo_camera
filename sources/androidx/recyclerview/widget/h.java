package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;

/* compiled from: GapWorker */
final class h implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    static final ThreadLocal<h> f1136a = new ThreadLocal<>();
    static Comparator<b> e = new Comparator<b>() {
        /* renamed from: a */
        public int compare(b bVar, b bVar2) {
            if ((bVar.d == null) != (bVar2.d == null)) {
                if (bVar.d == null) {
                    return 1;
                }
                return -1;
            } else if (bVar.f1140a == bVar2.f1140a) {
                int i = bVar2.f1141b - bVar.f1141b;
                if (i != 0) {
                    return i;
                }
                int i2 = bVar.c - bVar2.c;
                if (i2 != 0) {
                    return i2;
                }
                return 0;
            } else if (bVar.f1140a) {
                return -1;
            } else {
                return 1;
            }
        }
    };

    /* renamed from: b  reason: collision with root package name */
    ArrayList<RecyclerView> f1137b = new ArrayList<>();
    long c;
    long d;
    private ArrayList<b> f = new ArrayList<>();

    h() {
    }

    /* compiled from: GapWorker */
    static class b {

        /* renamed from: a  reason: collision with root package name */
        public boolean f1140a;

        /* renamed from: b  reason: collision with root package name */
        public int f1141b;
        public int c;
        public RecyclerView d;
        public int e;

        b() {
        }

        public void a() {
            this.f1140a = false;
            this.f1141b = 0;
            this.c = 0;
            this.d = null;
            this.e = 0;
        }
    }

    @SuppressLint({"VisibleForTests"})
    /* compiled from: GapWorker */
    static class a implements RecyclerView.i.a {

        /* renamed from: a  reason: collision with root package name */
        int f1138a;

        /* renamed from: b  reason: collision with root package name */
        int f1139b;
        int[] c;
        int d;

        a() {
        }

        /* access modifiers changed from: package-private */
        public void a(int i, int i2) {
            this.f1138a = i;
            this.f1139b = i2;
        }

        /* access modifiers changed from: package-private */
        public void a(RecyclerView recyclerView, boolean z) {
            this.d = 0;
            int[] iArr = this.c;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            RecyclerView.i iVar = recyclerView.mLayout;
            if (recyclerView.mAdapter != null && iVar != null && iVar.isItemPrefetchEnabled()) {
                if (z) {
                    if (!recyclerView.mAdapterHelper.d()) {
                        iVar.collectInitialPrefetchPositions(recyclerView.mAdapter.getItemCount(), this);
                    }
                } else if (!recyclerView.hasPendingAdapterUpdates()) {
                    iVar.collectAdjacentPrefetchPositions(this.f1138a, this.f1139b, recyclerView.mState, this);
                }
                if (this.d > iVar.mPrefetchMaxCountObserved) {
                    iVar.mPrefetchMaxCountObserved = this.d;
                    iVar.mPrefetchMaxObservedInInitialPrefetch = z;
                    recyclerView.mRecycler.b();
                }
            }
        }

        public void b(int i, int i2) {
            if (i < 0) {
                throw new IllegalArgumentException("Layout positions must be non-negative");
            } else if (i2 >= 0) {
                int i3 = this.d * 2;
                int[] iArr = this.c;
                if (iArr == null) {
                    this.c = new int[4];
                    Arrays.fill(this.c, -1);
                } else if (i3 >= iArr.length) {
                    this.c = new int[(i3 * 2)];
                    System.arraycopy(iArr, 0, this.c, 0, iArr.length);
                }
                int[] iArr2 = this.c;
                iArr2[i3] = i;
                iArr2[i3 + 1] = i2;
                this.d++;
            } else {
                throw new IllegalArgumentException("Pixel distance must be non-negative");
            }
        }

        /* access modifiers changed from: package-private */
        public boolean a(int i) {
            if (this.c != null) {
                int i2 = this.d * 2;
                for (int i3 = 0; i3 < i2; i3 += 2) {
                    if (this.c[i3] == i) {
                        return true;
                    }
                }
            }
            return false;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            int[] iArr = this.c;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            this.d = 0;
        }
    }

    public void a(RecyclerView recyclerView) {
        this.f1137b.add(recyclerView);
    }

    public void b(RecyclerView recyclerView) {
        this.f1137b.remove(recyclerView);
    }

    /* access modifiers changed from: package-private */
    public void a(RecyclerView recyclerView, int i, int i2) {
        if (recyclerView.isAttachedToWindow() && this.c == 0) {
            this.c = recyclerView.getNanoTime();
            recyclerView.post(this);
        }
        recyclerView.mPrefetchRegistry.a(i, i2);
    }

    private void a() {
        b bVar;
        int size = this.f1137b.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            RecyclerView recyclerView = this.f1137b.get(i2);
            if (recyclerView.getWindowVisibility() == 0) {
                recyclerView.mPrefetchRegistry.a(recyclerView, false);
                i += recyclerView.mPrefetchRegistry.d;
            }
        }
        this.f.ensureCapacity(i);
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            RecyclerView recyclerView2 = this.f1137b.get(i4);
            if (recyclerView2.getWindowVisibility() == 0) {
                a aVar = recyclerView2.mPrefetchRegistry;
                int abs = Math.abs(aVar.f1138a) + Math.abs(aVar.f1139b);
                int i5 = i3;
                for (int i6 = 0; i6 < aVar.d * 2; i6 += 2) {
                    if (i5 >= this.f.size()) {
                        bVar = new b();
                        this.f.add(bVar);
                    } else {
                        bVar = this.f.get(i5);
                    }
                    int i7 = aVar.c[i6 + 1];
                    bVar.f1140a = i7 <= abs;
                    bVar.f1141b = abs;
                    bVar.c = i7;
                    bVar.d = recyclerView2;
                    bVar.e = aVar.c[i6];
                    i5++;
                }
                i3 = i5;
            }
        }
        Collections.sort(this.f, e);
    }

    static boolean a(RecyclerView recyclerView, int i) {
        int c2 = recyclerView.mChildHelper.c();
        for (int i2 = 0; i2 < c2; i2++) {
            RecyclerView.w childViewHolderInt = RecyclerView.getChildViewHolderInt(recyclerView.mChildHelper.d(i2));
            if (childViewHolderInt.mPosition == i && !childViewHolderInt.isInvalid()) {
                return true;
            }
        }
        return false;
    }

    private RecyclerView.w a(RecyclerView recyclerView, int i, long j) {
        if (a(recyclerView, i)) {
            return null;
        }
        RecyclerView.p pVar = recyclerView.mRecycler;
        try {
            recyclerView.onEnterLayoutOrScroll();
            RecyclerView.w a2 = pVar.a(i, false, j);
            if (a2 != null) {
                if (!a2.isBound() || a2.isInvalid()) {
                    pVar.a(a2, false);
                } else {
                    pVar.a(a2.itemView);
                }
            }
            return a2;
        } finally {
            recyclerView.onExitLayoutOrScroll(false);
        }
    }

    private void a(RecyclerView recyclerView, long j) {
        if (recyclerView != null) {
            if (recyclerView.mDataSetHasChangedAfterLayout && recyclerView.mChildHelper.c() != 0) {
                recyclerView.removeAndRecycleViews();
            }
            a aVar = recyclerView.mPrefetchRegistry;
            aVar.a(recyclerView, true);
            if (aVar.d != 0) {
                try {
                    androidx.core.c.a.a("RV Nested Prefetch");
                    recyclerView.mState.a(recyclerView.mAdapter);
                    for (int i = 0; i < aVar.d * 2; i += 2) {
                        a(recyclerView, aVar.c[i], j);
                    }
                } finally {
                    androidx.core.c.a.a();
                }
            }
        }
    }

    private void a(b bVar, long j) {
        RecyclerView.w a2 = a(bVar.d, bVar.e, bVar.f1140a ? Long.MAX_VALUE : j);
        if (a2 != null && a2.mNestedRecyclerView != null && a2.isBound() && !a2.isInvalid()) {
            a((RecyclerView) a2.mNestedRecyclerView.get(), j);
        }
    }

    private void b(long j) {
        int i = 0;
        while (i < this.f.size()) {
            b bVar = this.f.get(i);
            if (bVar.d != null) {
                a(bVar, j);
                bVar.a();
                i++;
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void a(long j) {
        a();
        b(j);
    }

    public void run() {
        try {
            androidx.core.c.a.a("RV Prefetch");
            if (!this.f1137b.isEmpty()) {
                int size = this.f1137b.size();
                long j = 0;
                for (int i = 0; i < size; i++) {
                    RecyclerView recyclerView = this.f1137b.get(i);
                    if (recyclerView.getWindowVisibility() == 0) {
                        j = Math.max(recyclerView.getDrawingTime(), j);
                    }
                }
                if (j != 0) {
                    a(TimeUnit.MILLISECONDS.toNanos(j) + this.d);
                    this.c = 0;
                    androidx.core.c.a.a();
                }
            }
        } finally {
            this.c = 0;
            androidx.core.c.a.a();
        }
    }
}
