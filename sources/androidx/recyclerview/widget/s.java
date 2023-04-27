package androidx.recyclerview.widget;

import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: SnapHelper */
public abstract class s extends RecyclerView.l {

    /* renamed from: a  reason: collision with root package name */
    RecyclerView f1152a;

    /* renamed from: b  reason: collision with root package name */
    private Scroller f1153b;
    private final RecyclerView.n c = new RecyclerView.n() {

        /* renamed from: a  reason: collision with root package name */
        boolean f1154a = false;

        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            if (i == 0 && this.f1154a) {
                this.f1154a = false;
                s.this.a();
            }
        }

        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            if (i != 0 || i2 != 0) {
                this.f1154a = true;
            }
        }
    };

    public abstract int a(RecyclerView.i iVar, int i, int i2);

    public abstract View a(RecyclerView.i iVar);

    public abstract int[] a(RecyclerView.i iVar, View view);

    public boolean a(int i, int i2) {
        RecyclerView.i layoutManager = this.f1152a.getLayoutManager();
        if (layoutManager == null || this.f1152a.getAdapter() == null) {
            return false;
        }
        int minFlingVelocity = this.f1152a.getMinFlingVelocity();
        if ((Math.abs(i2) > minFlingVelocity || Math.abs(i) > minFlingVelocity) && b(layoutManager, i, i2)) {
            return true;
        }
        return false;
    }

    public void a(RecyclerView recyclerView) throws IllegalStateException {
        RecyclerView recyclerView2 = this.f1152a;
        if (recyclerView2 != recyclerView) {
            if (recyclerView2 != null) {
                c();
            }
            this.f1152a = recyclerView;
            if (this.f1152a != null) {
                b();
                this.f1153b = new Scroller(this.f1152a.getContext(), new DecelerateInterpolator());
                a();
            }
        }
    }

    private void b() throws IllegalStateException {
        if (this.f1152a.getOnFlingListener() == null) {
            this.f1152a.addOnScrollListener(this.c);
            this.f1152a.setOnFlingListener(this);
            return;
        }
        throw new IllegalStateException("An instance of OnFlingListener already set.");
    }

    private void c() {
        this.f1152a.removeOnScrollListener(this.c);
        this.f1152a.setOnFlingListener((RecyclerView.l) null);
    }

    public int[] b(int i, int i2) {
        this.f1153b.fling(0, 0, i, i2, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return new int[]{this.f1153b.getFinalX(), this.f1153b.getFinalY()};
    }

    private boolean b(RecyclerView.i iVar, int i, int i2) {
        RecyclerView.s c2;
        int a2;
        if (!(iVar instanceof RecyclerView.s.b) || (c2 = c(iVar)) == null || (a2 = a(iVar, i, i2)) == -1) {
            return false;
        }
        c2.setTargetPosition(a2);
        iVar.startSmoothScroll(c2);
        return true;
    }

    /* access modifiers changed from: package-private */
    public void a() {
        RecyclerView.i layoutManager;
        View a2;
        RecyclerView recyclerView = this.f1152a;
        if (recyclerView != null && (layoutManager = recyclerView.getLayoutManager()) != null && (a2 = a(layoutManager)) != null) {
            int[] a3 = a(layoutManager, a2);
            if (a3[0] != 0 || a3[1] != 0) {
                this.f1152a.smoothScrollBy(a3[0], a3[1]);
            }
        }
    }

    /* access modifiers changed from: protected */
    public RecyclerView.s c(RecyclerView.i iVar) {
        return b(iVar);
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public j b(RecyclerView.i iVar) {
        if (!(iVar instanceof RecyclerView.s.b)) {
            return null;
        }
        return new j(this.f1152a.getContext()) {
            /* access modifiers changed from: protected */
            public void onTargetFound(View view, RecyclerView.t tVar, RecyclerView.s.a aVar) {
                if (s.this.f1152a != null) {
                    s sVar = s.this;
                    int[] a2 = sVar.a(sVar.f1152a.getLayoutManager(), view);
                    int i = a2[0];
                    int i2 = a2[1];
                    int calculateTimeForDeceleration = calculateTimeForDeceleration(Math.max(Math.abs(i), Math.abs(i2)));
                    if (calculateTimeForDeceleration > 0) {
                        aVar.a(i, i2, calculateTimeForDeceleration, this.mDecelerateInterpolator);
                    }
                }
            }

            /* access modifiers changed from: protected */
            public float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
                return 100.0f / ((float) displayMetrics.densityDpi);
            }
        };
    }
}
