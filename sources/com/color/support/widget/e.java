package com.color.support.widget;

import android.content.Context;
import android.graphics.PointF;
import android.os.Build;
import android.view.View;
import androidx.recyclerview.widget.ColorRecyclerView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.n;

/* compiled from: ColorFlingLocateHelper */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private ColorRecyclerView f2165a;

    /* renamed from: b  reason: collision with root package name */
    private int f2166b = 0;
    private n c;
    private RecyclerView.i d;
    private Context e;
    private RecyclerView.n f = new RecyclerView.n() {

        /* renamed from: a  reason: collision with root package name */
        boolean f2167a = false;

        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            if (i == 0 && this.f2167a) {
                this.f2167a = false;
                e.this.b();
            }
        }

        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            if (i != 0 || i2 != 0) {
                this.f2167a = true;
            }
        }
    };

    public void a(ColorRecyclerView colorRecyclerView) {
        this.f2165a = colorRecyclerView;
        this.e = colorRecyclerView.getContext();
    }

    public void a(int i) {
        this.f2166b = i;
        this.f2165a.addOnScrollListener(this.f);
    }

    public int a() {
        return this.f2166b;
    }

    /* access modifiers changed from: private */
    public void b() {
        View a2;
        int i;
        int i2;
        RecyclerView.i c2 = c();
        if (c2 != null && (a2 = a(c2)) != null) {
            int i3 = this.f2166b;
            if (i3 == 2) {
                int d2 = b(c2).d() + (b(c2).g() / 2);
                int itemCount = c2.getItemCount() - 1;
                if (c2.getPosition(a2) == 0) {
                    if (a(this.e)) {
                        d2 = b(c2).e() - (b(c2).e(a2) / 2);
                    } else {
                        d2 = b(c2).d() + (b(c2).e(a2) / 2);
                    }
                }
                if (c2.getPosition(a2) == itemCount) {
                    if (a(this.e)) {
                        d2 = b(c2).d() + (b(c2).e(a2) / 2);
                    } else {
                        d2 = b(c2).e() - (b(c2).e(a2) / 2);
                    }
                }
                int a3 = (b(c2).a(a2) + (b(c2).e(a2) / 2)) - d2;
                if (((float) Math.abs(a3)) > 1.0f) {
                    this.f2165a.smoothScrollBy(a3, 0);
                }
            } else if (i3 == 1) {
                if (a(this.e)) {
                    i = b(c2).b(a2);
                    i2 = b(c2).e();
                } else {
                    i = b(c2).a(a2);
                    i2 = b(c2).d();
                }
                int i4 = i - i2;
                if (((float) Math.abs(i4)) > 1.0f) {
                    this.f2165a.smoothScrollBy(i4, 0);
                }
            }
        }
    }

    private float a(RecyclerView.i iVar, n nVar) {
        int max;
        int childCount = iVar.getChildCount();
        if (childCount == 0) {
            return 1.0f;
        }
        View view = null;
        int i = Integer.MIN_VALUE;
        int i2 = Integer.MAX_VALUE;
        View view2 = null;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = iVar.getChildAt(i3);
            int position = iVar.getPosition(childAt);
            if (!(position == -1 || position == iVar.getItemCount() - 1 || position == 0)) {
                if (position < i2) {
                    view = childAt;
                    i2 = position;
                }
                if (position > i) {
                    view2 = childAt;
                    i = position;
                }
            }
        }
        if (view == null || view2 == null || (max = Math.max(nVar.b(view), nVar.b(view2)) - Math.min(nVar.a(view), nVar.a(view2))) == 0) {
            return 1.0f;
        }
        return (((float) max) * 1.0f) / ((float) ((i - i2) + 1));
    }

    public View a(RecyclerView.i iVar) {
        if (iVar.canScrollHorizontally()) {
            int i = this.f2166b;
            if (i == 2) {
                return c(iVar, b(iVar));
            }
            if (i == 1) {
                return b(iVar, b(iVar));
            }
        }
        return null;
    }

    private n b(RecyclerView.i iVar) {
        n nVar = this.c;
        if (nVar == null || nVar.a() != iVar) {
            this.c = n.a(iVar);
        }
        return this.c;
    }

    private RecyclerView.i c() {
        RecyclerView.i iVar = this.d;
        if (iVar == null || iVar != this.f2165a.getLayoutManager()) {
            this.d = this.f2165a.getLayoutManager();
        }
        return this.d;
    }

    private View b(RecyclerView.i iVar, n nVar) {
        int i;
        int childCount = iVar.getChildCount();
        View view = null;
        if (childCount == 0) {
            return null;
        }
        if (iVar instanceof LinearLayoutManager) {
            boolean z = true;
            if (((LinearLayoutManager) iVar).findFirstCompletelyVisibleItemPosition() != iVar.getItemCount() - 1) {
                z = false;
            }
            if (z) {
                return null;
            }
        }
        if (a(this.e)) {
            i = nVar.e();
        } else {
            i = nVar.d();
        }
        int i2 = Integer.MAX_VALUE;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = iVar.getChildAt(i3);
            int abs = Math.abs((a(this.e) ? nVar.b(childAt) : nVar.a(childAt)) - i);
            if (abs < i2) {
                view = childAt;
                i2 = abs;
            }
        }
        return view;
    }

    private View c(RecyclerView.i iVar, n nVar) {
        int childCount = iVar.getChildCount();
        View view = null;
        if (childCount == 0) {
            return null;
        }
        int d2 = nVar.d() + (nVar.g() / 2);
        int i = Integer.MAX_VALUE;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = iVar.getChildAt(i2);
            int abs = Math.abs((nVar.a(childAt) + (nVar.e(childAt) / 2)) - d2);
            if (abs < i) {
                view = childAt;
                i = abs;
            }
        }
        return view;
    }

    public int b(int i) {
        View a2;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        RecyclerView.i c2 = c();
        int itemCount = c2.getItemCount();
        if (itemCount == 0 || (a2 = a(c2)) == null) {
            return -1;
        }
        int position = c2.getPosition(a2);
        int i7 = itemCount - 1;
        PointF computeScrollVectorForPosition = ((RecyclerView.s.b) c2).computeScrollVectorForPosition(i7);
        if (computeScrollVectorForPosition == null) {
            return -1;
        }
        float f2 = 1.0f;
        if (c2.canScrollHorizontally()) {
            f2 = a(c2, b(c2));
            i2 = Math.round(((float) i) / f2);
            if (computeScrollVectorForPosition.x < 0.0f) {
                i2 = -i2;
            }
        } else {
            i2 = 0;
        }
        int i8 = i2 + position;
        if (i8 != position && i8 >= 0 && i8 < itemCount) {
            int i9 = this.f2166b;
            if (i9 == 2) {
                View view = null;
                if (c2.getPosition(a2) == 0 && c2.getChildCount() != 0) {
                    view = c2.getChildAt(c2.getChildCount() - 1);
                }
                if (c2.getPosition(a2) == i7 && c2.getChildCount() != 0) {
                    view = c2.getChildAt(0);
                }
                int d2 = b(c2).d() + (b(c2).g() / 2);
                if (view != null) {
                    if (a(this.e)) {
                        i6 = -((int) (((float) (i8 - c2.getPosition(view))) * f2));
                    } else {
                        i6 = (int) (((float) (i8 - c2.getPosition(view))) * f2);
                    }
                    i4 = b(c2).a(view) + (b(c2).e(view) / 2) + i6;
                } else {
                    if (a(this.e)) {
                        i5 = -((int) (((float) (i8 - c2.getPosition(a2))) * f2));
                    } else {
                        i5 = (int) (((float) (i8 - c2.getPosition(a2))) * f2);
                    }
                    i4 = b(c2).a(a2) + (b(c2).e(a2) / 2) + i5;
                }
                return i4 - d2;
            } else if (i9 == 1) {
                int e2 = a(this.e) ? b(c2).e() : b(c2).d();
                if (a(this.e)) {
                    i3 = b(c2).b(a2);
                } else {
                    i3 = b(c2).a(a2);
                }
                return (i3 + (a(this.e) ? -((int) (((float) (i8 - position)) * f2)) : (int) (((float) (i8 - position)) * f2))) - e2;
            }
        }
        return -1;
    }

    private boolean a(Context context) {
        if (context != null && Build.VERSION.SDK_INT > 16 && context.getResources().getConfiguration().getLayoutDirection() == 1) {
            return true;
        }
        return false;
    }
}
