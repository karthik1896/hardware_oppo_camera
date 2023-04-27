package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.R;
import androidx.core.g.aa;
import androidx.core.g.v;
import androidx.core.g.z;

/* compiled from: AbsActionBarView */
abstract class a extends ViewGroup {

    /* renamed from: a  reason: collision with root package name */
    protected final C0007a f369a;

    /* renamed from: b  reason: collision with root package name */
    protected final Context f370b;
    protected ActionMenuView c;
    protected ActionMenuPresenter d;
    protected int e;
    protected z f;
    private boolean g;
    private boolean h;

    protected static int a(int i, int i2, boolean z) {
        return z ? i - i2 : i + i2;
    }

    a(Context context) {
        this(context, (AttributeSet) null);
    }

    a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    a(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f369a = new C0007a();
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(R.attr.actionBarPopupTheme, typedValue, true) || typedValue.resourceId == 0) {
            this.f370b = context;
        } else {
            this.f370b = new ContextThemeWrapper(context, typedValue.resourceId);
        }
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes((AttributeSet) null, R.styleable.ActionBar, R.attr.actionBarStyle, 0);
        setContentHeight(obtainStyledAttributes.getLayoutDimension(R.styleable.ActionBar_height, 0));
        obtainStyledAttributes.recycle();
        ActionMenuPresenter actionMenuPresenter = this.d;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.a(configuration);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.g = false;
        }
        if (!this.g) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !onTouchEvent) {
                this.g = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.g = false;
        }
        return true;
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.h = false;
        }
        if (!this.h) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !onHoverEvent) {
                this.h = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.h = false;
        }
        return true;
    }

    public void setContentHeight(int i) {
        this.e = i;
        requestLayout();
    }

    public int getContentHeight() {
        return this.e;
    }

    public int getAnimatedVisibility() {
        if (this.f != null) {
            return this.f369a.f371a;
        }
        return getVisibility();
    }

    public z a(int i, long j) {
        z zVar = this.f;
        if (zVar != null) {
            zVar.b();
        }
        if (i == 0) {
            if (getVisibility() != 0) {
                setAlpha(0.0f);
            }
            z a2 = v.n(this).a(1.0f);
            a2.a(j);
            a2.a((aa) this.f369a.a(a2, i));
            return a2;
        }
        z a3 = v.n(this).a(0.0f);
        a3.a(j);
        a3.a((aa) this.f369a.a(a3, i));
        return a3;
    }

    public void setVisibility(int i) {
        if (i != getVisibility()) {
            z zVar = this.f;
            if (zVar != null) {
                zVar.b();
            }
            super.setVisibility(i);
        }
    }

    public boolean a() {
        ActionMenuPresenter actionMenuPresenter = this.d;
        if (actionMenuPresenter != null) {
            return actionMenuPresenter.c();
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public int a(View view, int i, int i2, int i3) {
        view.measure(View.MeasureSpec.makeMeasureSpec(i, Integer.MIN_VALUE), i2);
        return Math.max(0, (i - view.getMeasuredWidth()) - i3);
    }

    /* access modifiers changed from: protected */
    public int a(View view, int i, int i2, int i3, boolean z) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i4 = i2 + ((i3 - measuredHeight) / 2);
        if (z) {
            view.layout(i - measuredWidth, i4, i, measuredHeight + i4);
        } else {
            view.layout(i, i4, i + measuredWidth, measuredHeight + i4);
        }
        return z ? -measuredWidth : measuredWidth;
    }

    /* renamed from: androidx.appcompat.widget.a$a  reason: collision with other inner class name */
    /* compiled from: AbsActionBarView */
    protected class C0007a implements aa {

        /* renamed from: a  reason: collision with root package name */
        int f371a;
        private boolean c = false;

        protected C0007a() {
        }

        public C0007a a(z zVar, int i) {
            a.this.f = zVar;
            this.f371a = i;
            return this;
        }

        public void a(View view) {
            a.super.setVisibility(0);
            this.c = false;
        }

        public void b(View view) {
            if (!this.c) {
                a aVar = a.this;
                aVar.f = null;
                a.super.setVisibility(this.f371a);
            }
        }

        public void c(View view) {
            this.c = true;
        }
    }
}
