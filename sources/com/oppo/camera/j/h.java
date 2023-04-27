package com.oppo.camera.j;

import android.content.Context;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import com.oppo.camera.R;

/* compiled from: FilmModeBarItemLayout */
public class h extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ boolean f3361a = (!h.class.desiredAssertionStatus());

    /* renamed from: b  reason: collision with root package name */
    private BaseAdapter f3362b;
    private int c;
    private int d;
    private Rect e;
    private int f;
    private int g;
    private int h;
    private int i;
    private a j;
    private int k;

    /* compiled from: FilmModeBarItemLayout */
    public interface a {
        void a(View view, View view2, int i);

        void a(View view, View view2, int i, long j);
    }

    public h(Context context) {
        super(context);
        this.f3362b = null;
        this.c = -1;
        this.d = 0;
        this.e = null;
        this.f = 0;
        this.g = 0;
        this.h = 0;
        this.i = 0;
        this.j = null;
        this.k = 0;
        this.k = R.id.movie_params_item_tag;
        this.h = context.getResources().getDimensionPixelSize(R.dimen.movie_mode_params_padding);
        this.i = context.getResources().getDimensionPixelSize(R.dimen.movie_mode_params_item_right);
        setClipChildren(false);
        getViewTreeObserver().addOnWindowFocusChangeListener(new ViewTreeObserver.OnWindowFocusChangeListener() {
            public void onWindowFocusChanged(boolean z) {
                h.this.setItemPressed(true);
            }
        });
    }

    public void setAdapter(BaseAdapter baseAdapter) {
        if (baseAdapter != null) {
            removeAllViews();
            this.f3362b = baseAdapter;
            this.d = this.f3362b.getCount();
            for (int i2 = 0; i2 < this.d; i2++) {
                d dVar = new d(getContext());
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.movie_mode_params_item_height), getResources().getDimensionPixelSize(R.dimen.movie_mode_params_item_width));
                dVar.setId(102);
                dVar.setRotation(90.0f);
                dVar.setTag(Integer.valueOf(i2));
                dVar.setGravity(17);
                addView(baseAdapter.getView(i2, dVar, this), layoutParams);
            }
        }
    }

    public BaseAdapter getAdapter() {
        return this.f3362b;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        View childAt;
        int a2;
        View childAt2;
        if (!isEnabled()) {
            a(this.f, this.g, false);
            if (isClickable() || isLongClickable()) {
                return true;
            }
            return false;
        } else if (motionEvent.getPointerCount() > 1) {
            a(this.f, this.g, false);
            return true;
        } else {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                this.f = (int) motionEvent.getX();
                this.g = (int) motionEvent.getY();
                int a3 = a(this.f, this.g);
                if (-1 != a3 && this.d > 0 && a3 < this.f3362b.getCount() && (childAt = getChildAt(a3)) != null) {
                    childAt.setPressed(childAt.isEnabled());
                }
            } else if (actionMasked != 1) {
                if (actionMasked == 3 && (a2 = a(this.f, this.g)) != this.c && -1 != a2 && this.d > 0 && a2 < this.f3362b.getCount() && (childAt2 = getChildAt(a2)) != null) {
                    childAt2.setPressed(false);
                }
            } else if (!b((int) motionEvent.getX(), (int) motionEvent.getY())) {
                b(this.f, this.g);
            }
            return true;
        }
    }

    private void a(int i2, int i3, boolean z) {
        View childAt;
        int a2 = a(i2, i3);
        if (a2 != this.c && -1 != a2 && this.d > 0 && a2 < this.f3362b.getCount() && (childAt = getChildAt(a2)) != null) {
            childAt.setPressed(z);
        }
    }

    public int a(int i2, int i3) {
        int childCount = getChildCount() - 1;
        while (childCount >= 0) {
            View childAt = getChildAt(childCount);
            if (!f3361a && childAt == null) {
                throw new AssertionError();
            } else if (childAt.getVisibility() == 0 && childAt.getTag(this.k) != null && ((Rect) childAt.getTag(this.k)).contains(i2, i3)) {
                return childCount;
            } else {
                childCount--;
            }
        }
        return -1;
    }

    private boolean b(int i2, int i3) {
        View childAt;
        int a2 = a(i2, i3);
        boolean z = false;
        if (-1 != a2 && this.d > 0 && a2 < this.f3362b.getCount() && (childAt = getChildAt(a2)) != null && childAt.isEnabled()) {
            setPressed(false);
            z = true;
            childAt.setPressed(true);
            a aVar = this.j;
            if (aVar != null) {
                if (this.c != a2) {
                    aVar.a(this, childAt, a2, this.f3362b.getItemId(a2));
                } else {
                    aVar.a(this, childAt, a2);
                }
            }
            if (this.c == a2 || childAt == null) {
                a();
            } else {
                this.c = a2;
                childAt.sendAccessibilityEvent(1);
            }
        }
        return z;
    }

    public void a() {
        setItemPressed(false);
        this.c = -1;
    }

    public void setItemPressed(boolean z) {
        View childAt;
        int i2 = this.c;
        if (-1 != i2 && (childAt = getChildAt(i2)) != null) {
            childAt.setPressed(z && childAt.isEnabled());
        }
    }

    public void setOnItemClickListener(a aVar) {
        this.j = aVar;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int childCount = getChildCount();
        int i6 = 0;
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            int measuredWidth = childAt.getMeasuredWidth();
            int measuredHeight = childAt.getMeasuredHeight();
            if (i7 == 0) {
                i6 = this.h;
            } else {
                i6 = i6 + measuredHeight + this.i;
            }
            int i8 = measuredHeight + i6;
            int i9 = measuredWidth + 0;
            childAt.setTag(this.k, new Rect(i6, 0, i8, i9));
            childAt.layout(i6, 0, i8, i9);
        }
    }
}
