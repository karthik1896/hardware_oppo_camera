package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.R;
import androidx.core.g.v;
import com.sensetime.stmobile.STMobileHumanActionNative;

public class ActionBarContainer extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    Drawable f290a;

    /* renamed from: b  reason: collision with root package name */
    Drawable f291b;
    Drawable c;
    boolean d;
    boolean e;
    private boolean f;
    private View g;
    private View h;
    private View i;
    private int j;

    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback) {
        return null;
    }

    public ActionBarContainer(Context context) {
        this(context, (AttributeSet) null);
    }

    public ActionBarContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        v.a((View) this, (Drawable) new b(this));
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ActionBar);
        this.f290a = obtainStyledAttributes.getDrawable(R.styleable.ActionBar_background);
        this.f291b = obtainStyledAttributes.getDrawable(R.styleable.ActionBar_backgroundStacked);
        this.j = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ActionBar_height, -1);
        if (getId() == R.id.split_action_bar) {
            this.d = true;
            this.c = obtainStyledAttributes.getDrawable(R.styleable.ActionBar_backgroundSplit);
        }
        obtainStyledAttributes.recycle();
        boolean z = false;
        if (!this.d ? this.f290a == null && this.f291b == null : this.c == null) {
            z = true;
        }
        setWillNotDraw(z);
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        this.h = findViewById(R.id.action_bar);
        this.i = findViewById(R.id.action_context_bar);
    }

    public void setPrimaryBackground(Drawable drawable) {
        Drawable drawable2 = this.f290a;
        if (drawable2 != null) {
            drawable2.setCallback((Drawable.Callback) null);
            unscheduleDrawable(this.f290a);
        }
        this.f290a = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            View view = this.h;
            if (view != null) {
                this.f290a.setBounds(view.getLeft(), this.h.getTop(), this.h.getRight(), this.h.getBottom());
            }
        }
        boolean z = true;
        if (!this.d ? !(this.f290a == null && this.f291b == null) : this.c != null) {
            z = false;
        }
        setWillNotDraw(z);
        invalidate();
        if (Build.VERSION.SDK_INT >= 21) {
            invalidateOutline();
        }
    }

    public void setStackedBackground(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.f291b;
        if (drawable3 != null) {
            drawable3.setCallback((Drawable.Callback) null);
            unscheduleDrawable(this.f291b);
        }
        this.f291b = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.e && (drawable2 = this.f291b) != null) {
                drawable2.setBounds(this.g.getLeft(), this.g.getTop(), this.g.getRight(), this.g.getBottom());
            }
        }
        boolean z = true;
        if (!this.d ? !(this.f290a == null && this.f291b == null) : this.c != null) {
            z = false;
        }
        setWillNotDraw(z);
        invalidate();
        if (Build.VERSION.SDK_INT >= 21) {
            invalidateOutline();
        }
    }

    public void setSplitBackground(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.c;
        if (drawable3 != null) {
            drawable3.setCallback((Drawable.Callback) null);
            unscheduleDrawable(this.c);
        }
        this.c = drawable;
        boolean z = false;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.d && (drawable2 = this.c) != null) {
                drawable2.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            }
        }
        if (!this.d ? this.f290a == null && this.f291b == null : this.c == null) {
            z = true;
        }
        setWillNotDraw(z);
        invalidate();
        if (Build.VERSION.SDK_INT >= 21) {
            invalidateOutline();
        }
    }

    public void setVisibility(int i2) {
        super.setVisibility(i2);
        boolean z = i2 == 0;
        Drawable drawable = this.f290a;
        if (drawable != null) {
            drawable.setVisible(z, false);
        }
        Drawable drawable2 = this.f291b;
        if (drawable2 != null) {
            drawable2.setVisible(z, false);
        }
        Drawable drawable3 = this.c;
        if (drawable3 != null) {
            drawable3.setVisible(z, false);
        }
    }

    /* access modifiers changed from: protected */
    public boolean verifyDrawable(Drawable drawable) {
        return (drawable == this.f290a && !this.d) || (drawable == this.f291b && this.e) || ((drawable == this.c && this.d) || super.verifyDrawable(drawable));
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f290a;
        if (drawable != null && drawable.isStateful()) {
            this.f290a.setState(getDrawableState());
        }
        Drawable drawable2 = this.f291b;
        if (drawable2 != null && drawable2.isStateful()) {
            this.f291b.setState(getDrawableState());
        }
        Drawable drawable3 = this.c;
        if (drawable3 != null && drawable3.isStateful()) {
            this.c.setState(getDrawableState());
        }
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f290a;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.f291b;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        Drawable drawable3 = this.c;
        if (drawable3 != null) {
            drawable3.jumpToCurrentState();
        }
    }

    public void setTransitioning(boolean z) {
        this.f = z;
        setDescendantFocusability(z ? 393216 : STMobileHumanActionNative.ST_MOBILE_DETECT_MODE_IMAGE);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f || super.onInterceptTouchEvent(motionEvent);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        super.onHoverEvent(motionEvent);
        return true;
    }

    public void setTabContainer(ak akVar) {
        View view = this.g;
        if (view != null) {
            removeView(view);
        }
        this.g = akVar;
        if (akVar != null) {
            addView(akVar);
            ViewGroup.LayoutParams layoutParams = akVar.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -2;
            akVar.setAllowCollapse(false);
        }
    }

    public View getTabContainer() {
        return this.g;
    }

    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback, int i2) {
        if (i2 != 0) {
            return super.startActionModeForChild(view, callback, i2);
        }
        return null;
    }

    private boolean a(View view) {
        return view == null || view.getVisibility() == 8 || view.getMeasuredHeight() == 0;
    }

    private int b(View view) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        return view.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
    }

    public void onMeasure(int i2, int i3) {
        int i4;
        int i5;
        if (this.h == null && View.MeasureSpec.getMode(i3) == Integer.MIN_VALUE && (i5 = this.j) >= 0) {
            i3 = View.MeasureSpec.makeMeasureSpec(Math.min(i5, View.MeasureSpec.getSize(i3)), Integer.MIN_VALUE);
        }
        super.onMeasure(i2, i3);
        if (this.h != null) {
            int mode = View.MeasureSpec.getMode(i3);
            View view = this.g;
            if (view != null && view.getVisibility() != 8 && mode != 1073741824) {
                if (!a(this.h)) {
                    i4 = b(this.h);
                } else {
                    i4 = !a(this.i) ? b(this.i) : 0;
                }
                setMeasuredDimension(getMeasuredWidth(), Math.min(i4 + b(this.g), mode == Integer.MIN_VALUE ? View.MeasureSpec.getSize(i3) : Integer.MAX_VALUE));
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x00c2  */
    /* JADX WARNING: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onLayout(boolean r6, int r7, int r8, int r9, int r10) {
        /*
            r5 = this;
            super.onLayout(r6, r7, r8, r9, r10)
            android.view.View r6 = r5.g
            r8 = 8
            r10 = 1
            r0 = 0
            if (r6 == 0) goto L_0x0013
            int r1 = r6.getVisibility()
            if (r1 == r8) goto L_0x0013
            r1 = r10
            goto L_0x0014
        L_0x0013:
            r1 = r0
        L_0x0014:
            if (r6 == 0) goto L_0x0035
            int r2 = r6.getVisibility()
            if (r2 == r8) goto L_0x0035
            int r8 = r5.getMeasuredHeight()
            android.view.ViewGroup$LayoutParams r2 = r6.getLayoutParams()
            android.widget.FrameLayout$LayoutParams r2 = (android.widget.FrameLayout.LayoutParams) r2
            int r3 = r6.getMeasuredHeight()
            int r3 = r8 - r3
            int r4 = r2.bottomMargin
            int r3 = r3 - r4
            int r2 = r2.bottomMargin
            int r8 = r8 - r2
            r6.layout(r7, r3, r9, r8)
        L_0x0035:
            boolean r7 = r5.d
            if (r7 == 0) goto L_0x004d
            android.graphics.drawable.Drawable r6 = r5.c
            if (r6 == 0) goto L_0x004a
            int r7 = r5.getMeasuredWidth()
            int r8 = r5.getMeasuredHeight()
            r6.setBounds(r0, r0, r7, r8)
            goto L_0x00c0
        L_0x004a:
            r10 = r0
            goto L_0x00c0
        L_0x004d:
            android.graphics.drawable.Drawable r7 = r5.f290a
            if (r7 == 0) goto L_0x00a5
            android.view.View r7 = r5.h
            int r7 = r7.getVisibility()
            if (r7 != 0) goto L_0x0077
            android.graphics.drawable.Drawable r7 = r5.f290a
            android.view.View r8 = r5.h
            int r8 = r8.getLeft()
            android.view.View r9 = r5.h
            int r9 = r9.getTop()
            android.view.View r0 = r5.h
            int r0 = r0.getRight()
            android.view.View r2 = r5.h
            int r2 = r2.getBottom()
            r7.setBounds(r8, r9, r0, r2)
            goto L_0x00a4
        L_0x0077:
            android.view.View r7 = r5.i
            if (r7 == 0) goto L_0x009f
            int r7 = r7.getVisibility()
            if (r7 != 0) goto L_0x009f
            android.graphics.drawable.Drawable r7 = r5.f290a
            android.view.View r8 = r5.i
            int r8 = r8.getLeft()
            android.view.View r9 = r5.i
            int r9 = r9.getTop()
            android.view.View r0 = r5.i
            int r0 = r0.getRight()
            android.view.View r2 = r5.i
            int r2 = r2.getBottom()
            r7.setBounds(r8, r9, r0, r2)
            goto L_0x00a4
        L_0x009f:
            android.graphics.drawable.Drawable r7 = r5.f290a
            r7.setBounds(r0, r0, r0, r0)
        L_0x00a4:
            r0 = r10
        L_0x00a5:
            r5.e = r1
            if (r1 == 0) goto L_0x004a
            android.graphics.drawable.Drawable r7 = r5.f291b
            if (r7 == 0) goto L_0x004a
            int r8 = r6.getLeft()
            int r9 = r6.getTop()
            int r0 = r6.getRight()
            int r6 = r6.getBottom()
            r7.setBounds(r8, r9, r0, r6)
        L_0x00c0:
            if (r10 == 0) goto L_0x00c5
            r5.invalidate()
        L_0x00c5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ActionBarContainer.onLayout(boolean, int, int, int, int):void");
    }
}
