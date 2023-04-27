package color.support.v7.internal.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import java.lang.reflect.Field;

/* compiled from: ListViewCompat */
public class c extends ListView {
    private static final int[] f = {0};

    /* renamed from: a  reason: collision with root package name */
    final Rect f1542a = new Rect();

    /* renamed from: b  reason: collision with root package name */
    int f1543b = 0;
    int c = 0;
    int d = 0;
    int e = 0;
    private Field g;
    private a h;

    /* access modifiers changed from: protected */
    public boolean c() {
        return false;
    }

    public c(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        try {
            this.g = AbsListView.class.getDeclaredField("mIsChildViewEnabled");
            this.g.setAccessible(true);
        } catch (NoSuchFieldException e2) {
            e2.printStackTrace();
        }
    }

    public void setSelector(Drawable drawable) {
        this.h = drawable != null ? new a(drawable) : null;
        super.setSelector(this.h);
        Rect rect = new Rect();
        if (drawable != null) {
            drawable.getPadding(rect);
        }
        this.f1543b = rect.left;
        this.c = rect.top;
        this.d = rect.right;
        this.e = rect.bottom;
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        setSelectorEnabled(true);
        a();
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        a(canvas);
        super.dispatchDraw(canvas);
    }

    /* access modifiers changed from: protected */
    public void a() {
        Drawable selector = getSelector();
        if (selector != null && b()) {
            selector.setState(getDrawableState());
        }
    }

    /* access modifiers changed from: protected */
    public boolean b() {
        return c() && isPressed();
    }

    /* access modifiers changed from: protected */
    public void a(Canvas canvas) {
        Drawable selector;
        if (!this.f1542a.isEmpty() && (selector = getSelector()) != null) {
            selector.setBounds(this.f1542a);
            selector.draw(canvas);
        }
    }

    /* access modifiers changed from: protected */
    public void a(int i, View view, float f2, float f3) {
        a(i, view);
        Drawable selector = getSelector();
        if (selector != null && i != -1) {
            androidx.core.graphics.drawable.a.a(selector, f2, f3);
        }
    }

    /* access modifiers changed from: protected */
    public void a(int i, View view) {
        Drawable selector = getSelector();
        boolean z = true;
        boolean z2 = (selector == null || i == -1) ? false : true;
        if (z2) {
            selector.setVisible(false, false);
        }
        b(i, view);
        if (z2) {
            Rect rect = this.f1542a;
            float exactCenterX = rect.exactCenterX();
            float exactCenterY = rect.exactCenterY();
            if (getVisibility() != 0) {
                z = false;
            }
            selector.setVisible(z, false);
            androidx.core.graphics.drawable.a.a(selector, exactCenterX, exactCenterY);
        }
    }

    /* access modifiers changed from: protected */
    public void b(int i, View view) {
        Rect rect = this.f1542a;
        rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        rect.left -= this.f1543b;
        rect.top -= this.c;
        rect.right += this.d;
        rect.bottom += this.e;
        try {
            boolean z = this.g.getBoolean(this);
            if (view.isEnabled() != z) {
                this.g.set(this, Boolean.valueOf(!z));
                if (i != -1) {
                    refreshDrawableState();
                }
            }
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        }
    }

    public int a(int i, int i2, int i3, int i4, int i5) {
        int i6;
        int listPaddingTop = getListPaddingTop();
        int listPaddingBottom = getListPaddingBottom();
        getListPaddingLeft();
        getListPaddingRight();
        int dividerHeight = getDividerHeight();
        Drawable divider = getDivider();
        ListAdapter adapter = getAdapter();
        if (adapter == null) {
            return listPaddingTop + listPaddingBottom;
        }
        int i7 = listPaddingTop + listPaddingBottom;
        if (dividerHeight <= 0 || divider == null) {
            dividerHeight = 0;
        }
        int count = adapter.getCount();
        int i8 = i7;
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        View view = null;
        while (i9 < count) {
            int itemViewType = adapter.getItemViewType(i9);
            if (itemViewType != i10) {
                view = null;
                i10 = itemViewType;
            }
            view = adapter.getView(i9, view, this);
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null || layoutParams.height <= 0) {
                i6 = View.MeasureSpec.makeMeasureSpec(0, 0);
            } else {
                i6 = View.MeasureSpec.makeMeasureSpec(layoutParams.height, 1073741824);
            }
            view.measure(i, i6);
            if (i9 > 0) {
                i8 += dividerHeight;
            }
            i8 += view.getMeasuredHeight();
            if (i8 >= i4) {
                return (i5 < 0 || i9 <= i5 || i11 <= 0 || i8 == i4) ? i4 : i11;
            }
            if (i5 >= 0 && i9 >= i5) {
                i11 = i8;
            }
            i9++;
        }
        return i8;
    }

    /* access modifiers changed from: protected */
    public void setSelectorEnabled(boolean z) {
        a aVar = this.h;
        if (aVar != null) {
            aVar.a(z);
        }
    }

    /* compiled from: ListViewCompat */
    private static class a extends androidx.appcompat.b.a.c {

        /* renamed from: a  reason: collision with root package name */
        private boolean f1544a = true;

        public a(Drawable drawable) {
            super(drawable);
        }

        /* access modifiers changed from: package-private */
        public void a(boolean z) {
            this.f1544a = z;
        }

        public boolean setState(int[] iArr) {
            if (this.f1544a) {
                return super.setState(iArr);
            }
            return false;
        }

        public void draw(Canvas canvas) {
            if (this.f1544a) {
                super.draw(canvas);
            }
        }

        public boolean setVisible(boolean z, boolean z2) {
            if (this.f1544a) {
                return super.setVisible(z, z2);
            }
            return false;
        }
    }
}
