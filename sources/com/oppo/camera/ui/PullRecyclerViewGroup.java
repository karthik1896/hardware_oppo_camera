package com.oppo.camera.ui;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import androidx.dynamicanimation.a.b;
import androidx.dynamicanimation.a.e;
import androidx.dynamicanimation.a.f;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class PullRecyclerViewGroup extends LinearLayout implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: a  reason: collision with root package name */
    private float f3798a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f3799b;
    /* access modifiers changed from: private */
    public boolean c;
    private RecyclerView d;
    private Rect e;

    public PullRecyclerViewGroup(Context context) {
        this(context, (AttributeSet) null);
    }

    public PullRecyclerViewGroup(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PullRecyclerViewGroup(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f3798a = 0.0f;
        this.f3799b = false;
        this.c = true;
        this.d = null;
        this.e = new Rect();
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.c = true;
    }

    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (this.d == null && (view instanceof RecyclerView)) {
            this.d = (RecyclerView) view;
        }
        super.addView(view, i, layoutParams);
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        View childAt;
        if (1 == getChildCount() && (childAt = getChildAt(0)) != null && (childAt instanceof RecyclerView)) {
            this.d = (RecyclerView) childAt;
        }
        getViewTreeObserver().addOnGlobalLayoutListener(this);
        super.onFinishInflate();
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.e.set(this.d.getLeft(), this.d.getTop(), this.d.getRight(), this.d.getBottom());
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.d == null) {
            return super.dispatchTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f3798a = motionEvent.getX();
            return super.dispatchTouchEvent(motionEvent);
        } else if (action == 1) {
            if (this.f3799b) {
                a();
            }
            if (this.c) {
                return super.dispatchTouchEvent(motionEvent);
            }
            return true;
        } else if (action != 2) {
            if (action == 3 && this.f3799b) {
                a();
            }
            return true;
        } else {
            int x = (int) (motionEvent.getX() - this.f3798a);
            if (a(x)) {
                int i = (int) (((float) x) * 0.5f);
                this.d.layout(this.e.left + i, this.e.top, this.e.right + i, this.e.bottom);
                this.f3799b = true;
                this.c = false;
                return true;
            }
            this.f3798a = motionEvent.getX();
            this.f3799b = false;
            this.c = true;
            a();
            return super.dispatchTouchEvent(motionEvent);
        }
    }

    private boolean a(int i) {
        boolean c2 = c();
        boolean b2 = b();
        return 1 == getLayoutDirection() ? (i > 0 && c2) || (i < 0 && b2) || (c2 && b2) : (i > 0 && b2) || (i < 0 && c2) || (c2 && b2);
    }

    private void a() {
        if (this.f3799b) {
            try {
                e eVar = new e(this.d, e.i);
                f fVar = new f(0.0f);
                fVar.a(350.0f);
                fVar.b(0.79f);
                eVar.a(fVar);
                eVar.a((b.C0027b) new b.C0027b() {
                    public void a(b bVar, boolean z, float f, float f2) {
                        boolean unused = PullRecyclerViewGroup.this.c = true;
                    }
                });
                eVar.a();
            } catch (NoClassDefFoundError e2) {
                e2.printStackTrace();
                TranslateAnimation translateAnimation = new TranslateAnimation((float) (this.d.getLeft() - this.e.left), 0.0f, 0.0f, 0.0f);
                translateAnimation.setDuration(400);
                translateAnimation.setAnimationListener(new Animation.AnimationListener() {
                    public void onAnimationRepeat(Animation animation) {
                    }

                    public void onAnimationStart(Animation animation) {
                    }

                    public void onAnimationEnd(Animation animation) {
                        boolean unused = PullRecyclerViewGroup.this.c = true;
                    }
                });
                this.d.startAnimation(translateAnimation);
            }
            this.d.layout(this.e.left, this.e.top, this.e.right, this.e.bottom);
            this.f3799b = false;
        }
    }

    private boolean b() {
        RecyclerView.a adapter = this.d.getAdapter();
        if (adapter == null) {
            return true;
        }
        if (((LinearLayoutManager) this.d.getLayoutManager()).findFirstCompletelyVisibleItemPosition() != 0 && adapter.getItemCount() != 0) {
            return false;
        }
        if (((this.d.getChildCount() <= 0 || this.d.getChildAt(0) == null) ? 0 : this.d.getChildAt(0).getLeft()) >= 0) {
            return true;
        }
        return false;
    }

    private boolean c() {
        View childAt;
        RecyclerView.a adapter = this.d.getAdapter();
        if (adapter == null) {
            return true;
        }
        int itemCount = adapter.getItemCount() - 1;
        int findLastCompletelyVisibleItemPosition = ((LinearLayoutManager) this.d.getLayoutManager()).findLastCompletelyVisibleItemPosition();
        if (findLastCompletelyVisibleItemPosition < itemCount || (childAt = this.d.getChildAt(Math.min(findLastCompletelyVisibleItemPosition - ((LinearLayoutManager) this.d.getLayoutManager()).findFirstCompletelyVisibleItemPosition(), this.d.getChildCount() - 1))) == null) {
            return false;
        }
        if (childAt.getRight() <= this.d.getRight() - this.d.getLeft()) {
            return true;
        }
        return false;
    }

    public void onGlobalLayout() {
        requestLayout();
        getViewTreeObserver().removeOnGlobalLayoutListener(this);
    }
}
