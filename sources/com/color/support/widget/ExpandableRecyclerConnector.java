package com.color.support.widget;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.PathInterpolator;
import android.widget.AbsListView;
import androidx.recyclerview.widget.ColorLinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ExpandableRecyclerConnector extends RecyclerView.a {

    /* renamed from: a  reason: collision with root package name */
    private SparseArray<e> f2118a = new SparseArray<>();

    /* renamed from: b  reason: collision with root package name */
    private SparseArray<d> f2119b = new SparseArray<>();
    private SparseArray<List<RecyclerView.w>> c = new SparseArray<>();
    private SparseArray<List<RecyclerView.w>> d = new SparseArray<>();
    private d e;
    private ArrayList<GroupMetadata> f = new ArrayList<>();
    private int g;
    private int h = Integer.MAX_VALUE;
    private final RecyclerView.c i = new f();
    /* access modifiers changed from: private */
    public ColorExpandableRecyclerView j;
    private SparseArray<Integer> k = new SparseArray<>();

    public ExpandableRecyclerConnector(d dVar, ColorExpandableRecyclerView colorExpandableRecyclerView) {
        this.j = colorExpandableRecyclerView;
        a(dVar);
    }

    public void a(d dVar) {
        d dVar2 = this.e;
        if (dVar2 != null) {
            dVar2.a(this.i);
        }
        this.e = dVar;
        setHasStableIds(this.e.a());
        dVar.b(this.i);
    }

    private e f(int i2) {
        e eVar = this.f2118a.get(i2);
        if (eVar != null) {
            return eVar;
        }
        e eVar2 = new e();
        this.f2118a.put(i2, eVar2);
        return eVar2;
    }

    private boolean g(int i2) {
        e f2 = f(i2);
        if (f2.f2133a && f2.f2134b) {
            return false;
        }
        f2.f2133a = true;
        f2.f2134b = true;
        return true;
    }

    public boolean a(int i2) {
        l a2 = l.a(2, i2, -1, -1);
        g a3 = a(a2);
        a2.a();
        View findViewByPosition = ((ColorLinearLayoutManager) this.j.getLayoutManager()).findViewByPosition(a3.f2136a.c);
        if (a3 == null || findViewByPosition == null || findViewByPosition.getBottom() < this.j.getHeight() - this.j.getPaddingBottom()) {
            e f2 = f(i2);
            if (f2.f2133a && f2.f2134b) {
                f2.f2134b = false;
                b(f2.d, a3.f2137b.flPos, i2, f2.e);
                return false;
            } else if (!f2.f2133a || f2.f2134b) {
                f2.f2133a = true;
                f2.f2134b = false;
                return true;
            } else {
                a(f2.d, a3.f2137b.flPos, i2, f2.c);
                f2.f2134b = true;
                return false;
            }
        } else {
            int i3 = a3.f2137b.flPos;
            this.f.remove(a3.f2137b);
            a(false, false);
            notifyItemChanged(i3);
            this.e.c(a3.f2137b.gPos);
            return false;
        }
    }

    /* access modifiers changed from: private */
    public void h(int i2) {
        e f2 = f(i2);
        f2.f2133a = false;
        f2.e = -1;
        d();
    }

    private void d() {
        for (int i2 = 0; i2 < this.d.size(); i2++) {
            List valueAt = this.d.valueAt(i2);
            int keyAt = this.d.keyAt(i2);
            List list = this.c.get(keyAt);
            if (list == null) {
                list = new ArrayList();
                this.c.put(keyAt, list);
            }
            list.addAll(valueAt);
        }
        this.d.clear();
    }

    /* access modifiers changed from: package-private */
    public g b(int i2) {
        int i3;
        ArrayList<GroupMetadata> arrayList = this.f;
        int size = arrayList.size();
        int i4 = size - 1;
        if (size == 0) {
            return g.a(i2, 2, i2, -1, (GroupMetadata) null, 0);
        }
        int i5 = 0;
        int i6 = 0;
        while (i5 <= i4) {
            int i7 = ((i4 - i5) / 2) + i5;
            GroupMetadata groupMetadata = arrayList.get(i7);
            if (i2 > groupMetadata.lastChildFlPos) {
                i5 = i7 + 1;
            } else if (i2 < groupMetadata.flPos) {
                i4 = i7 - 1;
            } else if (i2 == groupMetadata.flPos) {
                return g.a(i2, 2, groupMetadata.gPos, -1, groupMetadata, i7);
            } else if (i2 <= groupMetadata.lastChildFlPos) {
                return g.a(i2, 1, groupMetadata.gPos, i2 - (groupMetadata.flPos + 1), groupMetadata, i7);
            }
            i6 = i7;
        }
        if (i5 > i6) {
            GroupMetadata groupMetadata2 = arrayList.get(i5 - 1);
            i3 = (i2 - groupMetadata2.lastChildFlPos) + groupMetadata2.gPos;
        } else if (i4 < i6) {
            i5 = i4 + 1;
            GroupMetadata groupMetadata3 = arrayList.get(i5);
            i3 = groupMetadata3.gPos - (groupMetadata3.flPos - i2);
        } else {
            throw new RuntimeException("Unknown state");
        }
        return g.a(i2, 2, i3, -1, (GroupMetadata) null, i5);
    }

    /* access modifiers changed from: package-private */
    public g a(l lVar) {
        l lVar2 = lVar;
        ArrayList<GroupMetadata> arrayList = this.f;
        int size = arrayList.size();
        int i2 = size - 1;
        if (size == 0) {
            return g.a(lVar2.f2223a, lVar2.d, lVar2.f2223a, lVar2.f2224b, (GroupMetadata) null, 0);
        }
        int i3 = 0;
        int i4 = 0;
        while (i4 <= i2) {
            i3 = ((i2 - i4) / 2) + i4;
            GroupMetadata groupMetadata = arrayList.get(i3);
            if (lVar2.f2223a > groupMetadata.gPos) {
                i4 = i3 + 1;
            } else if (lVar2.f2223a < groupMetadata.gPos) {
                i2 = i3 - 1;
            } else if (lVar2.f2223a == groupMetadata.gPos) {
                if (lVar2.d == 2) {
                    return g.a(groupMetadata.flPos, lVar2.d, lVar2.f2223a, lVar2.f2224b, groupMetadata, i3);
                }
                if (lVar2.d == 1) {
                    return g.a(groupMetadata.flPos + lVar2.f2224b + 1, lVar2.d, lVar2.f2223a, lVar2.f2224b, groupMetadata, i3);
                }
                return null;
            }
        }
        if (lVar2.d != 2) {
            return null;
        }
        if (i4 > i3) {
            GroupMetadata groupMetadata2 = arrayList.get(i4 - 1);
            return g.a(groupMetadata2.lastChildFlPos + (lVar2.f2223a - groupMetadata2.gPos), lVar2.d, lVar2.f2223a, lVar2.f2224b, (GroupMetadata) null, i4);
        } else if (i2 >= i3) {
            return null;
        } else {
            int i5 = 1 + i2;
            GroupMetadata groupMetadata3 = arrayList.get(i5);
            return g.a(groupMetadata3.flPos - (groupMetadata3.gPos - lVar2.f2223a), lVar2.d, lVar2.f2223a, lVar2.f2224b, (GroupMetadata) null, i5);
        }
    }

    public int getItemCount() {
        return this.e.b() + this.g;
    }

    public long getItemId(int i2) {
        long j2;
        g b2 = b(i2);
        long d2 = this.e.d(b2.f2136a.f2223a);
        if (b2.f2136a.d == 2) {
            j2 = this.e.a(d2);
        } else if (b2.f2136a.d == 1) {
            j2 = this.e.a(d2, this.e.b(b2.f2136a.f2223a, b2.f2136a.f2224b));
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        b2.a();
        return j2;
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams a() {
        return new AbsListView.LayoutParams(-1, -2, 0);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v0, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v1, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v2, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v3, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v4, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v5, resolved type: boolean} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onBindViewHolder(androidx.recyclerview.widget.RecyclerView.w r9, final int r10) {
        /*
            r8 = this;
            com.color.support.widget.ExpandableRecyclerConnector$g r0 = r8.b((int) r10)
            com.color.support.widget.l r1 = r0.f2136a
            int r1 = r1.f2223a
            com.color.support.widget.ExpandableRecyclerConnector$e r2 = r8.f(r1)
            android.view.View r3 = r9.itemView
            r4 = 0
            r3.setOnClickListener(r4)
            com.color.support.widget.l r3 = r0.f2136a
            int r3 = r3.d
            r4 = 2
            if (r3 != r4) goto L_0x002e
            com.color.support.widget.d r2 = r8.e
            boolean r3 = r0.b()
            r2.a(r1, r3, r9)
            android.view.View r9 = r9.itemView
            com.color.support.widget.ExpandableRecyclerConnector$1 r1 = new com.color.support.widget.ExpandableRecyclerConnector$1
            r1.<init>(r10)
            r9.setOnClickListener(r1)
            goto L_0x00a9
        L_0x002e:
            boolean r3 = r2.f2133a
            r5 = 0
            r6 = 1
            if (r3 == 0) goto L_0x007d
            android.view.View r9 = r9.itemView
            com.color.support.widget.ExpandableRecyclerConnector$b r9 = (com.color.support.widget.ExpandableRecyclerConnector.b) r9
            r9.a()
            boolean r3 = r2.f2134b
            int r3 = r8.a((boolean) r3, (int) r1, (com.color.support.widget.ExpandableRecyclerConnector.b) r9)
            r2.c = r3
            r2.d = r9
            java.lang.Object r7 = r9.getTag()
            if (r7 != 0) goto L_0x004c
            goto L_0x0052
        L_0x004c:
            java.lang.Integer r7 = (java.lang.Integer) r7
            int r5 = r7.intValue()
        L_0x0052:
            boolean r7 = r2.f2134b
            if (r7 == 0) goto L_0x005c
            if (r5 == r6) goto L_0x005c
            r8.a(r9, r10, r1, r3)
            goto L_0x00a9
        L_0x005c:
            boolean r2 = r2.f2134b
            if (r2 != 0) goto L_0x0066
            if (r5 == r4) goto L_0x0066
            r8.b(r9, r10, r1, r3)
            goto L_0x00a9
        L_0x0066:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = "onBindViewHolder: state is no match:"
            r9.append(r10)
            r9.append(r5)
            java.lang.String r9 = r9.toString()
            java.lang.String r10 = "ExpandableRecyclerConnector"
            android.util.Log.e(r10, r9)
            goto L_0x00a9
        L_0x007d:
            com.color.support.widget.l r2 = r0.f2136a
            int r2 = r2.d
            if (r2 != r6) goto L_0x00ad
            com.color.support.widget.ExpandableRecyclerConnector$GroupMetadata r2 = r0.f2137b
            int r2 = r2.lastChildFlPos
            if (r2 != r10) goto L_0x008a
            r5 = r6
        L_0x008a:
            com.color.support.widget.d r2 = r8.e
            com.color.support.widget.l r3 = r0.f2136a
            int r3 = r3.f2224b
            r2.a(r1, r3, r5, r9)
            com.color.support.widget.d r2 = r8.e
            com.color.support.widget.l r3 = r0.f2136a
            int r3 = r3.f2224b
            boolean r1 = r2.a((int) r1, (int) r3)
            if (r1 == 0) goto L_0x00a9
            android.view.View r9 = r9.itemView
            com.color.support.widget.ExpandableRecyclerConnector$2 r1 = new com.color.support.widget.ExpandableRecyclerConnector$2
            r1.<init>(r10)
            r9.setOnClickListener(r1)
        L_0x00a9:
            r0.a()
            return
        L_0x00ad:
            java.lang.RuntimeException r9 = new java.lang.RuntimeException
            java.lang.String r10 = "Flat list position is of unknown type"
            r9.<init>(r10)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.color.support.widget.ExpandableRecyclerConnector.onBindViewHolder(androidx.recyclerview.widget.RecyclerView$w, int):void");
    }

    /* access modifiers changed from: package-private */
    public int c(int i2) {
        if (f(i2).f2133a) {
            return 1;
        }
        return this.e.a(i2);
    }

    private void a(RecyclerView.w wVar, int i2, int i3) {
        int b2 = b(i2, i3);
        List list = this.d.get(b2);
        if (list == null) {
            list = new ArrayList();
        }
        list.add(wVar);
        this.d.put(b2, list);
    }

    private RecyclerView.w a(int i2, int i3) {
        List list = this.c.get(b(i2, i3));
        if (list == null || list.isEmpty()) {
            return null;
        }
        return (RecyclerView.w) list.remove(0);
    }

    private int a(boolean z, int i2, b bVar) {
        int i3;
        int childCount = this.j.getLayoutManager().getChildCount();
        int bottom = childCount > 0 ? this.j.getLayoutManager().getChildAt(childCount - 1).getBottom() : 0;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.j.getWidth(), 1073741824);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
        if (!z || this.j.getLayoutParams().height != -2) {
            i3 = this.j.getBottom();
        } else {
            i3 = this.j.getContext().getResources().getDisplayMetrics().heightPixels;
        }
        int a2 = this.e.a(i2);
        int i4 = 0;
        for (int i5 = 0; i5 < a2; i5++) {
            RecyclerView.w a3 = a(i2, i5);
            if (a3 == null) {
                a3 = this.e.b((ViewGroup) this.j, b(i2, i5));
            }
            a(a3, i2, i5);
            View view = a3.itemView;
            this.e.a(i2, i5, false, a3);
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = a();
                view.setLayoutParams(layoutParams);
            }
            int i6 = layoutParams.height;
            int makeMeasureSpec3 = i6 > 0 ? View.MeasureSpec.makeMeasureSpec(i6, 1073741824) : makeMeasureSpec2;
            view.setLayoutDirection(this.j.getLayoutDirection());
            view.measure(makeMeasureSpec, makeMeasureSpec3);
            i4 += view.getMeasuredHeight();
            bVar.a(view);
            if ((!z && i4 + bottom > i3) || (z && i4 > (i3 - bottom) * 2)) {
                break;
            }
        }
        return i4;
    }

    private void a(final b bVar, final int i2, final int i3, int i4) {
        Log.d("ExpandableRecyclerConnector", "expandAnimationStart:" + i2 + " ,groupPos:" + i3 + " , height:" + i4);
        e f2 = f(i3);
        d dVar = this.f2119b.get(i3);
        if (dVar == null) {
            dVar = new d(this.j, 400, new PathInterpolator(0.3f, 0.0f, 0.0f, 1.0f));
            this.f2119b.put(i3, dVar);
        } else {
            dVar.removeAllListeners();
            dVar.cancel();
        }
        dVar.a(true, i2 == getItemCount() - 1, i2, bVar, f2, f2.e == -1 ? 0 : f2.e, i4);
        dVar.addListener(new c() {
            public void onAnimationEnd(Animator animator) {
                bVar.a();
                ExpandableRecyclerConnector.this.h(i3);
                ExpandableRecyclerConnector.this.a(true, true);
                ExpandableRecyclerConnector expandableRecyclerConnector = ExpandableRecyclerConnector.this;
                expandableRecyclerConnector.notifyItemRangeChanged(i2 - 1, (expandableRecyclerConnector.getItemCount() - i2) + 1);
                bVar.setTag(0);
            }
        });
        dVar.start();
        bVar.setTag(1);
    }

    private void b(final b bVar, int i2, final int i3, int i4) {
        Log.d("ExpandableRecyclerConnector", "collapseAnimationStart:" + i2 + " ,groupPos:" + i3 + " , height:" + i4);
        e f2 = f(i3);
        d dVar = this.f2119b.get(i3);
        if (dVar == null) {
            dVar = new d(this.j, 400, new PathInterpolator(0.3f, 0.0f, 0.0f, 1.0f));
            this.f2119b.put(i3, dVar);
        } else {
            dVar.removeAllListeners();
            dVar.cancel();
        }
        boolean z = i2 == getItemCount() - 1;
        if (f2.e != -1) {
            i4 = f2.e;
        }
        dVar.a(false, z, i2, bVar, f2, i4, 0);
        dVar.addListener(new c() {
            public void onAnimationEnd(Animator animator) {
                bVar.a();
                ExpandableRecyclerConnector.this.h(i3);
                ExpandableRecyclerConnector.this.d(i3);
                bVar.setTag(0);
            }
        });
        dVar.start();
        bVar.setTag(2);
    }

    public RecyclerView.w onCreateViewHolder(ViewGroup viewGroup, int i2) {
        if (i2 == Integer.MIN_VALUE) {
            return new a(new b(viewGroup.getContext()));
        }
        if (this.k.get(i2).intValue() == 2) {
            return this.e.a(viewGroup, i2);
        }
        if (this.k.get(i2).intValue() == 1) {
            return this.e.b(viewGroup, i2);
        }
        throw new RuntimeException("Flat list position is of unknown type");
    }

    public void b() {
        a(true, true);
        notifyItemRangeChanged(0, getItemCount());
    }

    static class a extends RecyclerView.w {
        public a(View view) {
            super(view);
            view.setLayoutParams(new AbsListView.LayoutParams(-1, 0));
        }
    }

    private static class b extends View {

        /* renamed from: a  reason: collision with root package name */
        private List<View> f2128a = new ArrayList();

        public b(Context context) {
            super(context);
        }

        public void a(View view) {
            this.f2128a.add(view);
        }

        /* access modifiers changed from: protected */
        public void onLayout(boolean z, int i, int i2, int i3, int i4) {
            int i5 = i4 - i2;
            int size = this.f2128a.size();
            int i6 = 0;
            int i7 = 0;
            while (i6 < size) {
                View view = this.f2128a.get(i6);
                int measuredHeight = view.getMeasuredHeight();
                i7 += measuredHeight;
                view.layout(i, i2, view.getMeasuredWidth() + i, measuredHeight + i2);
                if (i7 <= i5) {
                    i6++;
                } else {
                    return;
                }
            }
        }

        public void a() {
            this.f2128a.clear();
        }

        public void dispatchDraw(Canvas canvas) {
            canvas.save();
            int size = this.f2128a.size();
            int i = 0;
            for (int i2 = 0; i2 < size; i2++) {
                View view = this.f2128a.get(i2);
                canvas.save();
                int measuredHeight = view.getMeasuredHeight();
                i += measuredHeight;
                canvas.clipRect(0, 0, getWidth(), measuredHeight);
                view.draw(canvas);
                canvas.restore();
                canvas.translate(0.0f, (float) measuredHeight);
                if (i > canvas.getHeight()) {
                    break;
                }
            }
            canvas.restore();
        }
    }

    private static class d extends ValueAnimator {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public WeakReference<ColorExpandableRecyclerView> f2129a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public boolean f2130b;

        public d(ColorExpandableRecyclerView colorExpandableRecyclerView, long j, TimeInterpolator timeInterpolator) {
            this.f2129a = new WeakReference<>(colorExpandableRecyclerView);
            setDuration(j);
            setInterpolator(timeInterpolator);
        }

        public void a(boolean z, boolean z2, int i, View view, e eVar, int i2, int i3) {
            int i4 = i3;
            StringBuilder sb = new StringBuilder();
            sb.append("setParam: ");
            final boolean z3 = z;
            sb.append(z);
            sb.append(", isLastChild:");
            boolean z4 = z2;
            sb.append(z2);
            sb.append(" ,flatPos:");
            int i5 = i;
            sb.append(i);
            sb.append(" ,start:");
            sb.append(i2);
            sb.append(" ,end:");
            sb.append(i4);
            Log.d("ExpandableRecyclerConnector", sb.toString());
            this.f2130b = true;
            setIntValues(new int[]{i2, i4});
            removeAllUpdateListeners();
            final boolean z5 = z2;
            final int i6 = i;
            final View view2 = view;
            final e eVar2 = eVar;
            addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    int i;
                    ColorExpandableRecyclerView colorExpandableRecyclerView = (ColorExpandableRecyclerView) d.this.f2129a.get();
                    if (colorExpandableRecyclerView == null) {
                        d.this.a();
                        return;
                    }
                    int findFirstVisibleItemPosition = ((ColorLinearLayoutManager) colorExpandableRecyclerView.getLayoutManager()).findFirstVisibleItemPosition();
                    int findLastVisibleItemPosition = ((ColorLinearLayoutManager) colorExpandableRecyclerView.getLayoutManager()).findLastVisibleItemPosition();
                    if (!d.this.f2130b && !z5 && (findFirstVisibleItemPosition > (i = i6) || findLastVisibleItemPosition < i)) {
                        Log.d("ExpandableRecyclerConnector", "onAnimationUpdate1: " + findFirstVisibleItemPosition + "," + findLastVisibleItemPosition + "," + i6);
                        d.this.a();
                    } else if (!d.this.f2130b && !z5 && z3 && i6 == findLastVisibleItemPosition) {
                        Log.d("ExpandableRecyclerConnector", "onAnimationUpdate2: " + findLastVisibleItemPosition + "," + i6);
                        d.this.a();
                    } else if (d.this.f2130b || !z5 || !z3 || view2.getBottom() <= colorExpandableRecyclerView.getBottom()) {
                        boolean unused = d.this.f2130b = false;
                        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        eVar2.e = intValue;
                        view2.getLayoutParams().height = intValue;
                        colorExpandableRecyclerView.requestLayout();
                    } else {
                        Log.d("ExpandableRecyclerConnector", "onAnimationUpdate3: " + view2.getBottom() + "," + colorExpandableRecyclerView.getBottom());
                        d.this.a();
                    }
                }
            });
        }

        /* access modifiers changed from: private */
        public void a() {
            removeAllUpdateListeners();
            end();
        }
    }

    private static abstract class c implements Animator.AnimatorListener {
        public void onAnimationCancel(Animator animator) {
        }

        public void onAnimationRepeat(Animator animator) {
        }

        public void onAnimationStart(Animator animator) {
        }

        private c() {
        }
    }

    private int b(int i2, int i3) {
        return this.e.c(i2, i3) + this.e.c();
    }

    public int getItemViewType(int i2) {
        int i3;
        g b2 = b(i2);
        l lVar = b2.f2136a;
        if (lVar.d == 2) {
            i3 = this.e.e(lVar.f2223a);
        } else if (f(lVar.f2223a).f2133a) {
            i3 = Integer.MIN_VALUE;
        } else {
            i3 = b(lVar.f2223a, lVar.f2224b);
        }
        this.k.put(i3, Integer.valueOf(lVar.d));
        b2.a();
        return i3;
    }

    /* access modifiers changed from: private */
    public void a(boolean z, boolean z2) {
        ArrayList<GroupMetadata> arrayList = this.f;
        int size = arrayList.size();
        this.g = 0;
        if (z2) {
            int i2 = size;
            boolean z3 = false;
            for (int i3 = size - 1; i3 >= 0; i3--) {
                GroupMetadata groupMetadata = arrayList.get(i3);
                int a2 = a(groupMetadata.gId, groupMetadata.gPos);
                if (a2 != groupMetadata.gPos) {
                    if (a2 == -1) {
                        arrayList.remove(i3);
                        i2--;
                    }
                    groupMetadata.gPos = a2;
                    if (!z3) {
                        z3 = true;
                    }
                }
            }
            if (z3) {
                Collections.sort(arrayList);
            }
            size = i2;
        }
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 0; i6 < size; i6++) {
            GroupMetadata groupMetadata2 = arrayList.get(i6);
            int c2 = (groupMetadata2.lastChildFlPos == -1 || z) ? c(groupMetadata2.gPos) : groupMetadata2.lastChildFlPos - groupMetadata2.flPos;
            this.g += c2;
            int i7 = i5 + (groupMetadata2.gPos - i4);
            i4 = groupMetadata2.gPos;
            groupMetadata2.flPos = i7;
            i5 = i7 + c2;
            groupMetadata2.lastChildFlPos = i5;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean d(int i2) {
        l a2 = l.a(2, i2, -1, -1);
        g a3 = a(a2);
        a2.a();
        if (a3 == null) {
            return false;
        }
        return a(a3);
    }

    /* access modifiers changed from: package-private */
    public boolean a(g gVar) {
        if (gVar.f2137b == null) {
            return false;
        }
        this.f.remove(gVar.f2137b);
        a(false, false);
        notifyItemRangeChanged(0, getItemCount());
        this.e.c(gVar.f2137b.gPos);
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean e(int i2) {
        l a2 = l.a(2, i2, -1, -1);
        g a3 = a(a2);
        a2.a();
        if (a3 == null) {
            return false;
        }
        return b(a3);
    }

    /* access modifiers changed from: package-private */
    public boolean b(g gVar) {
        if (gVar.f2136a.f2223a < 0) {
            throw new RuntimeException("Need group");
        } else if (this.h == 0 || gVar.f2137b != null) {
            return false;
        } else {
            if (this.f.size() >= this.h) {
                GroupMetadata groupMetadata = this.f.get(0);
                int indexOf = this.f.indexOf(groupMetadata);
                d(groupMetadata.gPos);
                if (gVar.c > indexOf) {
                    gVar.c--;
                }
            }
            GroupMetadata obtain = GroupMetadata.obtain(-1, -1, gVar.f2136a.f2223a, this.e.d(gVar.f2136a.f2223a));
            View findViewByPosition = ((ColorLinearLayoutManager) this.j.getLayoutManager()).findViewByPosition(gVar.f2136a.c);
            if (findViewByPosition != null && findViewByPosition.getBottom() >= this.j.getHeight() - this.j.getPaddingBottom()) {
                this.f.add(gVar.c, obtain);
                a(false, false);
                this.e.b(obtain.gPos);
                notifyItemChanged(obtain.flPos);
                return false;
            } else if (!g(obtain.gPos)) {
                return false;
            } else {
                this.f.add(gVar.c, obtain);
                a(false, false);
                notifyItemRangeChanged(0, getItemCount());
                this.e.b(obtain.gPos);
                return true;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public ArrayList<GroupMetadata> c() {
        return this.f;
    }

    /* access modifiers changed from: package-private */
    public void a(ArrayList<GroupMetadata> arrayList) {
        d dVar;
        if (arrayList != null && (dVar = this.e) != null) {
            int b2 = dVar.b();
            int size = arrayList.size() - 1;
            while (size >= 0) {
                if (arrayList.get(size).gPos < b2) {
                    size--;
                } else {
                    return;
                }
            }
            this.f = arrayList;
            a(true, false);
        }
    }

    /* access modifiers changed from: package-private */
    public int a(long j2, int i2) {
        int b2 = this.e.b();
        if (b2 == 0 || j2 == Long.MIN_VALUE) {
            return -1;
        }
        int i3 = b2 - 1;
        int min = Math.min(i3, Math.max(0, i2));
        long uptimeMillis = SystemClock.uptimeMillis() + 100;
        d dVar = this.e;
        if (dVar == null) {
            return -1;
        }
        int i4 = min;
        int i5 = i4;
        boolean z = false;
        while (SystemClock.uptimeMillis() <= uptimeMillis) {
            if (dVar.d(min) != j2) {
                boolean z2 = i4 == i3;
                boolean z3 = i5 == 0;
                if (z2 && z3) {
                    break;
                } else if (z3 || (z && !z2)) {
                    i4++;
                    z = false;
                    min = i4;
                } else if (z2 || (!z && !z3)) {
                    i5--;
                    z = true;
                    min = i5;
                }
            } else {
                return min;
            }
        }
        return -1;
    }

    protected class f extends RecyclerView.c {
        protected f() {
        }

        public void onChanged() {
            ExpandableRecyclerConnector.this.a(true, true);
            ExpandableRecyclerConnector.this.notifyDataSetChanged();
        }

        public void onItemRangeChanged(int i, int i2) {
            ExpandableRecyclerConnector.this.a(true, true);
            ExpandableRecyclerConnector.this.notifyItemRangeChanged(i, i2);
        }

        public void onItemRangeChanged(int i, int i2, Object obj) {
            onItemRangeChanged(i, i2);
        }

        public void onItemRangeInserted(int i, int i2) {
            ExpandableRecyclerConnector.this.a(true, true);
            ExpandableRecyclerConnector.this.notifyItemRangeInserted(i, i2);
        }

        public void onItemRangeRemoved(int i, int i2) {
            ExpandableRecyclerConnector.this.a(true, true);
            ExpandableRecyclerConnector.this.notifyItemRangeRemoved(i, i2);
        }

        public void onItemRangeMoved(int i, int i2, int i3) {
            ExpandableRecyclerConnector.this.a(true, true);
            ExpandableRecyclerConnector.this.notifyItemMoved(i, i2);
        }
    }

    static class GroupMetadata implements Parcelable, Comparable<GroupMetadata> {
        public static final Parcelable.Creator<GroupMetadata> CREATOR = new Parcelable.Creator<GroupMetadata>() {
            /* renamed from: a */
            public GroupMetadata createFromParcel(Parcel parcel) {
                return GroupMetadata.obtain(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readLong());
            }

            /* renamed from: a */
            public GroupMetadata[] newArray(int i) {
                return new GroupMetadata[i];
            }
        };
        static final int REFRESH = -1;
        int flPos;
        long gId;
        int gPos;
        int lastChildFlPos;

        public int describeContents() {
            return 0;
        }

        private GroupMetadata() {
        }

        static GroupMetadata obtain(int i, int i2, int i3, long j) {
            GroupMetadata groupMetadata = new GroupMetadata();
            groupMetadata.flPos = i;
            groupMetadata.lastChildFlPos = i2;
            groupMetadata.gPos = i3;
            groupMetadata.gId = j;
            return groupMetadata;
        }

        public int compareTo(GroupMetadata groupMetadata) {
            if (groupMetadata != null) {
                return this.gPos - groupMetadata.gPos;
            }
            throw new IllegalArgumentException();
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.flPos);
            parcel.writeInt(this.lastChildFlPos);
            parcel.writeInt(this.gPos);
            parcel.writeLong(this.gId);
        }
    }

    public static class g {
        private static ArrayList<g> d = new ArrayList<>(5);

        /* renamed from: a  reason: collision with root package name */
        public l f2136a;

        /* renamed from: b  reason: collision with root package name */
        public GroupMetadata f2137b;
        public int c;

        private void c() {
            l lVar = this.f2136a;
            if (lVar != null) {
                lVar.a();
                this.f2136a = null;
            }
            this.f2137b = null;
            this.c = 0;
        }

        private g() {
        }

        static g a(int i, int i2, int i3, int i4, GroupMetadata groupMetadata, int i5) {
            g d2 = d();
            d2.f2136a = l.a(i2, i3, i4, i);
            d2.f2137b = groupMetadata;
            d2.c = i5;
            return d2;
        }

        private static g d() {
            synchronized (d) {
                if (d.size() > 0) {
                    g remove = d.remove(0);
                    remove.c();
                    return remove;
                }
                g gVar = new g();
                return gVar;
            }
        }

        public void a() {
            c();
            synchronized (d) {
                if (d.size() < 5) {
                    d.add(this);
                }
            }
        }

        public boolean b() {
            return this.f2137b != null;
        }
    }

    private static class e {

        /* renamed from: a  reason: collision with root package name */
        boolean f2133a;

        /* renamed from: b  reason: collision with root package name */
        boolean f2134b;
        int c;
        b d;
        int e;

        private e() {
            this.f2133a = false;
            this.f2134b = false;
            this.c = -1;
            this.e = -1;
        }
    }
}
