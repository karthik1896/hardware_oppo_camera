package color.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.app.a;
import androidx.appcompat.view.menu.h;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.view.menu.n;
import androidx.appcompat.view.menu.s;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.ar;
import androidx.appcompat.widget.ax;
import androidx.core.g.c;
import androidx.core.g.f;
import androidx.core.g.v;
import color.support.v7.appcompat.R;
import color.support.v7.internal.widget.d;
import java.util.ArrayList;
import java.util.List;

public class Toolbar extends androidx.appcompat.widget.Toolbar {
    private boolean A;
    private boolean B;
    private final ArrayList<View> C;
    private final int[] D;
    /* access modifiers changed from: private */
    public Toolbar.c E;
    private final ActionMenuView.e F;
    private a G;
    private n.a H;
    private h.a I;
    private boolean J;
    private int K;
    private boolean L;
    private int M;
    private int[] N;
    private float O;
    private int P;
    private int Q;
    private final int[] R;
    private final Runnable S;
    private int T;
    private float U;
    private float V;
    private boolean W;

    /* renamed from: a  reason: collision with root package name */
    View f1551a;
    private color.support.design.widget.a aa;

    /* renamed from: b  reason: collision with root package name */
    boolean f1552b;
    private ActionMenuView c;
    private TextView d;
    private TextView e;
    private ImageButton f;
    private ImageView g;
    private Drawable h;
    private CharSequence i;
    /* access modifiers changed from: private */
    public ImageButton j;
    private Context k;
    private int l;
    private int m;
    private int n;
    /* access modifiers changed from: private */
    public int o;
    private int p;
    private int q;
    private int r;
    private int s;
    private int t;
    private final d u;
    private int v;
    private CharSequence w;
    private CharSequence x;
    private int y;
    private int z;

    public Toolbar(Context context) {
        this(context, (AttributeSet) null);
    }

    public Toolbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.toolbarStyle);
    }

    public Toolbar(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.u = new d();
        this.v = 8388627;
        this.C = new ArrayList<>();
        this.D = new int[2];
        this.F = new ActionMenuView.e() {
            public boolean a(MenuItem menuItem) {
                if (Toolbar.this.E != null) {
                    return Toolbar.this.E.a(menuItem);
                }
                return false;
            }
        };
        this.L = false;
        this.N = new int[2];
        this.O = 0.0f;
        this.R = new int[2];
        this.S = new Runnable() {
            public void run() {
                Toolbar.this.showOverflowMenu();
            }
        };
        this.f1552b = false;
        this.T = -1;
        this.W = false;
        setClipToPadding(false);
        setClipChildren(false);
        ar a2 = ar.a(getContext(), attributeSet, R.styleable.Toolbar, i2, 0);
        if (a2.g(R.styleable.Toolbar_titleType)) {
            this.M = a2.a(R.styleable.Toolbar_titleType, 0);
        }
        this.m = a2.g(R.styleable.Toolbar_supportTitleTextAppearance, 0);
        this.n = a2.g(R.styleable.Toolbar_supportSubtitleTextAppearance, 0);
        this.v = a2.c(R.styleable.Toolbar_android_gravity, this.v);
        this.o = a2.c(R.styleable.Toolbar_supportButtonGravity, 48);
        int d2 = a2.d(R.styleable.Toolbar_supportTitleMargins, 0);
        this.t = d2;
        this.s = d2;
        this.r = d2;
        this.q = d2;
        int d3 = a2.d(R.styleable.Toolbar_supportTitleMarginStart, -1);
        if (d3 >= 0) {
            this.q = d3;
        }
        int d4 = a2.d(R.styleable.Toolbar_supportTitleMarginEnd, -1);
        if (d4 >= 0) {
            this.r = d4;
        }
        int d5 = a2.d(R.styleable.Toolbar_supportTitleMarginTop, -1);
        if (d5 >= 0) {
            this.s = d5;
        }
        int d6 = a2.d(R.styleable.Toolbar_supportTitleMarginBottom, -1);
        if (d6 >= 0) {
            this.t = d6;
        }
        this.p = a2.e(R.styleable.Toolbar_supportMaxButtonHeight, -1);
        int d7 = a2.d(R.styleable.Toolbar_supportContentInsetStart, Integer.MIN_VALUE);
        int d8 = a2.d(R.styleable.Toolbar_supportContentInsetEnd, Integer.MIN_VALUE);
        this.u.b(a2.e(R.styleable.Toolbar_supportContentInsetLeft, 0), a2.e(R.styleable.Toolbar_supportContentInsetRight, 0));
        if (!(d7 == Integer.MIN_VALUE && d8 == Integer.MIN_VALUE)) {
            this.u.a(d7, d8);
        }
        this.h = a2.a(R.styleable.Toolbar_supportCollapseIcon);
        this.i = a2.c(R.styleable.Toolbar_supportCollapseContentDescription);
        CharSequence c2 = a2.c(R.styleable.Toolbar_supportTitle);
        if (!TextUtils.isEmpty(c2)) {
            setTitle(c2);
        }
        CharSequence c3 = a2.c(R.styleable.Toolbar_supportSubtitle);
        if (!TextUtils.isEmpty(c3)) {
            setSubtitle(c3);
        }
        this.k = getContext();
        setPopupTheme(a2.g(R.styleable.Toolbar_supportPopupTheme, 0));
        Drawable a3 = a2.a(R.styleable.Toolbar_supportNavigationIcon);
        if (a3 != null) {
            setNavigationIcon(a3);
        }
        CharSequence c4 = a2.c(R.styleable.Toolbar_supportNavigationContentDescription);
        if (!TextUtils.isEmpty(c4)) {
            setNavigationContentDescription(c4);
        }
        this.K = a2.e(R.styleable.Toolbar_android_minHeight, 0);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        this.W = a2.a(R.styleable.Toolbar_showBottomDivider, false);
        if (a2.g(R.styleable.Toolbar_minTitleTextSize)) {
            this.V = (float) a2.e(R.styleable.Toolbar_minTitleTextSize, (int) (displayMetrics.scaledDensity * 16.0f));
        } else {
            this.V = displayMetrics.scaledDensity * 16.0f;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(this.m, new int[]{16842901});
        if (obtainStyledAttributes != null) {
            this.U = (float) obtainStyledAttributes.getDimensionPixelSize(0, (int) (displayMetrics.scaledDensity * 24.0f));
            obtainStyledAttributes.recycle();
        }
        if (this.M == 1) {
            this.U = com.color.support.d.b.a(this.U, getResources().getConfiguration().fontScale, 2);
            this.V = com.color.support.d.b.a(this.V, getResources().getConfiguration().fontScale, 2);
        }
        this.P = getContext().getResources().getDimensionPixelOffset(R.dimen.toolbar_normal_menu_padding);
        this.Q = getContext().getResources().getDimensionPixelOffset(R.dimen.toolbar_overflow_menu_padding);
        this.aa = new color.support.design.widget.a(this);
        if (a2.g(R.styleable.Toolbar_dividerBackgroundColor)) {
            this.aa.b(a2.b(R.styleable.Toolbar_dividerBackgroundColor, color.support.design.widget.a.f1443b));
        }
        if (a2.g(R.styleable.Toolbar_dividerColor)) {
            this.aa.a(a2.b(R.styleable.Toolbar_dividerColor, color.support.design.widget.a.f1442a));
        }
        if (a2.g(R.styleable.Toolbar_titleCenter)) {
            this.L = a2.a(R.styleable.Toolbar_titleCenter, false);
        }
        setWillNotDraw(false);
        a2.b();
    }

    public void setPopupTheme(int i2) {
        if (this.l != i2) {
            this.l = i2;
            if (i2 == 0) {
                this.k = getContext();
            } else {
                this.k = new ContextThemeWrapper(getContext(), i2);
            }
        }
    }

    public void setSearchView(View view) {
        a(view, view != null ? new b(view.getLayoutParams()) : null);
    }

    public void a(View view, b bVar) {
        if (view == null) {
            this.f1552b = false;
            return;
        }
        this.f1552b = view != null;
        b bVar2 = new b(bVar);
        bVar2.d = true;
        bVar2.c = 0;
        addView(view, 0, bVar2);
    }

    public int getPopupTheme() {
        return this.l;
    }

    public void onRtlPropertiesChanged(int i2) {
        if (Build.VERSION.SDK_INT >= 17) {
            super.onRtlPropertiesChanged(i2);
        }
        d dVar = this.u;
        if (dVar != null) {
            boolean z2 = true;
            if (i2 != 1) {
                z2 = false;
            }
            dVar.a(z2);
        }
    }

    public void setLogo(int i2) {
        setLogo(androidx.appcompat.a.a.a.b(getContext(), i2));
    }

    public void dismissPopupMenus() {
        ActionMenuView actionMenuView = this.c;
        if (actionMenuView != null) {
            actionMenuView.i();
        }
    }

    public void setLogo(Drawable drawable) {
        if (drawable != null) {
            b();
            if (this.g.getParent() == null) {
                a((View) this.g);
                e(this.g);
            }
        } else {
            ImageView imageView = this.g;
            if (!(imageView == null || imageView.getParent() == null)) {
                removeView(this.g);
            }
        }
        ImageView imageView2 = this.g;
        if (imageView2 != null) {
            imageView2.setImageDrawable(drawable);
        }
    }

    public Drawable getLogo() {
        ImageView imageView = this.g;
        if (imageView != null) {
            return imageView.getDrawable();
        }
        return null;
    }

    public void setLogoDescription(int i2) {
        setLogoDescription(getContext().getText(i2));
    }

    public void setLogoDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            b();
        }
        ImageView imageView = this.g;
        if (imageView != null) {
            imageView.setContentDescription(charSequence);
        }
    }

    public CharSequence getLogoDescription() {
        ImageView imageView = this.g;
        if (imageView != null) {
            return imageView.getContentDescription();
        }
        return null;
    }

    private void b() {
        if (this.g == null) {
            this.g = new ImageView(getContext());
        }
    }

    public void collapseActionView() {
        a aVar = this.G;
        j jVar = aVar == null ? null : aVar.f1557b;
        if (jVar != null) {
            jVar.collapseActionView();
        }
    }

    public CharSequence getTitle() {
        return this.w;
    }

    public void setTitle(int i2) {
        setTitle(getContext().getText(i2));
    }

    public void setTitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.d == null) {
                Context context = getContext();
                this.d = new TextView(context);
                b a2 = generateDefaultLayoutParams();
                a2.bottomMargin = this.t;
                a2.f172a = 8388613 | (this.o & 112);
                this.d.setLayoutParams(a2);
                this.d.setSingleLine();
                this.d.setEllipsize(TextUtils.TruncateAt.END);
                int i2 = this.m;
                if (i2 != 0) {
                    this.d.setTextAppearance(context, i2);
                }
                int i3 = this.y;
                if (i3 != 0) {
                    this.d.setTextColor(i3);
                }
                if (this.M == 1) {
                    this.d.setTextSize(0, com.color.support.d.b.a(this.d.getTextSize(), getContext().getResources().getConfiguration().fontScale, 2));
                }
            }
            if (this.d.getParent() == null) {
                a((View) this.d);
                e(this.d);
            }
        } else {
            TextView textView = this.d;
            if (!(textView == null || textView.getParent() == null)) {
                removeView(this.d);
            }
        }
        if (this.d != null) {
            if (Build.VERSION.SDK_INT >= 17) {
                this.d.setTextAlignment(5);
            }
            this.d.setText(charSequence);
            this.O = this.d.getTextSize();
        }
        this.w = charSequence;
    }

    public CharSequence getSubtitle() {
        return this.x;
    }

    public void setSubtitle(int i2) {
        setSubtitle(getContext().getText(i2));
    }

    public void setSubtitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.e == null) {
                Context context = getContext();
                this.e = new TextView(context);
                this.e.setSingleLine();
                this.e.setEllipsize(TextUtils.TruncateAt.END);
                int i2 = this.n;
                if (i2 != 0) {
                    this.e.setTextAppearance(context, i2);
                }
                int i3 = this.z;
                if (i3 != 0) {
                    this.e.setTextColor(i3);
                }
            }
            if (this.e.getParent() == null) {
                a((View) this.e);
                e(this.e);
            }
        } else {
            TextView textView = this.e;
            if (!(textView == null || textView.getParent() == null)) {
                removeView(this.e);
            }
        }
        if (this.e != null) {
            if (Build.VERSION.SDK_INT >= 17) {
                this.e.setTextAlignment(5);
            }
            this.e.setText(charSequence);
        }
        this.x = charSequence;
    }

    public void setTitleTextAppearance(Context context, int i2) {
        this.m = i2;
        TextView textView = this.d;
        if (textView != null) {
            textView.setTextAppearance(context, i2);
            if (this.M == 1) {
                this.d.setTextSize(0, com.color.support.d.b.a(this.d.getTextSize(), getContext().getResources().getConfiguration().fontScale, 2));
            }
            this.U = this.d.getTextSize();
            this.O = this.d.getTextSize();
        }
    }

    public void setSubtitleTextAppearance(Context context, int i2) {
        this.n = i2;
        TextView textView = this.e;
        if (textView != null) {
            textView.setTextAppearance(context, i2);
        }
    }

    public void setTitleTextColor(int i2) {
        this.y = i2;
        TextView textView = this.d;
        if (textView != null) {
            textView.setTextColor(i2);
        }
    }

    public void setSubtitleTextColor(int i2) {
        this.z = i2;
        TextView textView = this.e;
        if (textView != null) {
            textView.setTextColor(i2);
        }
    }

    public CharSequence getNavigationContentDescription() {
        ImageButton imageButton = this.f;
        if (imageButton != null) {
            return imageButton.getContentDescription();
        }
        return null;
    }

    public void setNavigationContentDescription(int i2) {
        setNavigationContentDescription(i2 != 0 ? getContext().getText(i2) : null);
    }

    public void setNavigationContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            e();
        }
        ImageButton imageButton = this.f;
        if (imageButton != null) {
            imageButton.setContentDescription(charSequence);
        }
    }

    public void setNavigationIcon(int i2) {
        setNavigationIcon(androidx.appcompat.a.a.a.b(getContext(), i2));
    }

    public void setNavigationIcon(Drawable drawable) {
        if (drawable != null) {
            e();
            if (this.f.getParent() == null) {
                a((View) this.f);
                e(this.f);
            }
        } else {
            ImageButton imageButton = this.f;
            if (!(imageButton == null || imageButton.getParent() == null)) {
                removeView(this.f);
            }
        }
        ImageButton imageButton2 = this.f;
        if (imageButton2 != null) {
            imageButton2.setImageDrawable(drawable);
        }
    }

    public Drawable getNavigationIcon() {
        ImageButton imageButton = this.f;
        if (imageButton != null) {
            return imageButton.getDrawable();
        }
        return null;
    }

    public void setNavigationOnClickListener(View.OnClickListener onClickListener) {
        e();
        this.f.setOnClickListener(onClickListener);
    }

    public Menu getMenu() {
        c();
        return this.c.getMenu();
    }

    public void setOverflowIcon(Drawable drawable) {
        c();
        this.c.setOverflowIcon(drawable);
    }

    public Drawable getOverflowIcon() {
        c();
        return this.c.getOverflowIcon();
    }

    private void c() {
        d();
        if (this.c.d() == null) {
            h hVar = (h) this.c.getMenu();
            if (this.G == null) {
                this.G = new a();
            }
            this.c.setExpandedActionViewsExclusive(true);
            hVar.addMenuPresenter(this.G, this.k);
        }
    }

    private void d() {
        if (this.c == null) {
            this.c = new a(getContext());
            this.c.setPopupTheme(this.l);
            this.c.setOnMenuItemClickListener(this.F);
            this.c.a(this.H, this.I);
            b a2 = generateDefaultLayoutParams();
            if (this.L) {
                a2.width = -1;
            } else {
                a2.width = -2;
            }
            a2.f172a = 8388613 | (this.o & 112);
            this.c.setLayoutParams(a2);
            a((View) this.c);
        }
    }

    public void setOnMenuItemClickListener(Toolbar.c cVar) {
        this.E = cVar;
    }

    public void setContentInsetsRelative(int i2, int i3) {
        this.u.a(i2, i3);
    }

    public int getContentInsetStart() {
        return this.u.c();
    }

    public int getContentInsetEnd() {
        return this.u.d();
    }

    public void setContentInsetsAbsolute(int i2, int i3) {
        this.u.b(i2, i3);
    }

    public int getContentInsetLeft() {
        return this.u.a();
    }

    public int getContentInsetRight() {
        return this.u.b();
    }

    private void e() {
        if (this.f == null) {
            this.f = new ImageButton(getContext(), (AttributeSet) null, R.attr.toolbarNavigationButtonStyle);
            b a2 = generateDefaultLayoutParams();
            a2.f172a = 8388611 | (this.o & 112);
            this.f.setLayoutParams(a2);
            this.f.setBackgroundResource(R.drawable.color_toolbar_menu_bg);
        }
    }

    /* access modifiers changed from: private */
    public void f() {
        if (this.j == null) {
            this.j = new ImageButton(getContext(), (AttributeSet) null, R.attr.toolbarNavigationButtonStyle);
            this.j.setImageDrawable(this.h);
            this.j.setContentDescription(this.i);
            b a2 = generateDefaultLayoutParams();
            a2.f172a = 8388611 | (this.o & 112);
            a2.c = 2;
            this.j.setLayoutParams(a2);
            this.j.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Toolbar.this.collapseActionView();
                }
            });
        }
    }

    private void a(View view) {
        b bVar;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            bVar = generateDefaultLayoutParams();
        } else if (!checkLayoutParams(layoutParams)) {
            bVar = generateLayoutParams(layoutParams);
        } else {
            bVar = (b) layoutParams;
        }
        bVar.c = 1;
        addView(view, bVar);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.S);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int a2 = androidx.core.g.h.a(motionEvent);
        if (a2 == 0) {
            this.A = false;
        }
        if (!this.A) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (a2 == 0 && !onTouchEvent) {
                this.A = true;
            }
        }
        if (a2 == 1 || a2 == 3) {
            this.A = false;
        }
        return true;
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        int a2 = androidx.core.g.h.a(motionEvent);
        if (a2 == 9) {
            this.B = false;
        }
        if (!this.B) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (a2 == 9 && !onHoverEvent) {
                this.B = true;
            }
        }
        if (a2 == 10 || a2 == 3) {
            this.B = false;
        }
        return true;
    }

    private void a(View view, int i2, int i3, int i4, int i5, int i6) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int childMeasureSpec = getChildMeasureSpec(i2, getPaddingLeft() + getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i3, marginLayoutParams.width);
        int childMeasureSpec2 = getChildMeasureSpec(i4, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i5, marginLayoutParams.height);
        int mode = View.MeasureSpec.getMode(childMeasureSpec2);
        if (mode != 1073741824 && i6 >= 0) {
            if (mode != 0) {
                i6 = Math.min(View.MeasureSpec.getSize(childMeasureSpec2), i6);
            }
            childMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i6, 1073741824);
        }
        view.measure(childMeasureSpec, childMeasureSpec2);
    }

    private int a(View view, int i2, int i3, int i4, int i5, int[] iArr) {
        int i6;
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        boolean z2 = false;
        int i7 = marginLayoutParams.leftMargin - iArr[0];
        int i8 = marginLayoutParams.rightMargin - iArr[1];
        int max = Math.max(0, i7) + Math.max(0, i8);
        iArr[0] = Math.max(0, -i7);
        iArr[1] = Math.max(0, -i8);
        if ((marginLayoutParams instanceof b) && ((b) marginLayoutParams).d && this.f1552b) {
            z2 = true;
        }
        if (z2) {
            i6 = getChildMeasureSpec(i2, getContentInsetStart() + max + getContentInsetStart(), marginLayoutParams.width);
        } else {
            i6 = getChildMeasureSpec(i2, getPaddingLeft() + getPaddingRight() + max + i3, marginLayoutParams.width);
        }
        view.measure(i6, getChildMeasureSpec(i4, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i5, marginLayoutParams.height));
        if (z2) {
            return max;
        }
        return view.getMeasuredWidth() + max;
    }

    private boolean g() {
        if (!this.J) {
            return false;
        }
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (b(childAt) && childAt.getMeasuredWidth() > 0 && childAt.getMeasuredHeight() > 0) {
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        char c2;
        char c3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        char c4;
        char c5;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        int i22;
        int i23 = i2;
        int i24 = i3;
        boolean z2 = v.g(this) == 1;
        if (this.L) {
            int[] iArr = this.D;
            if (ax.a(this)) {
                c5 = 1;
                c4 = 0;
            } else {
                c4 = 1;
                c5 = 0;
            }
            int contentInsetStart = getContentInsetStart();
            int max = Math.max(contentInsetStart, 0) + 0;
            iArr[c5] = Math.max(0, contentInsetStart - 0);
            if (b((View) this.c)) {
                a((h) this.c.getMenu(), z2);
                a((View) this.c, i2, 0, i3, 0, this.p);
                i15 = this.c.getMeasuredWidth() + c((View) this.c);
                i13 = Math.max(0, this.c.getMeasuredHeight() + d((View) this.c));
                i14 = View.combineMeasuredStates(0, v.h(this.c));
            } else {
                i15 = 0;
                i14 = 0;
                i13 = 0;
            }
            int contentInsetEnd = getContentInsetEnd();
            int max2 = max + Math.max(contentInsetEnd, i15);
            iArr[c4] = Math.max(0, contentInsetEnd - i15);
            if (b(this.f1551a)) {
                max2 += a(this.f1551a, i2, max2, i3, 0, iArr);
                i13 = Math.max(i13, this.f1551a.getMeasuredHeight() + d(this.f1551a));
                i14 = View.combineMeasuredStates(i14, v.h(this.f1551a));
            }
            int i25 = i14;
            int childCount = getChildCount();
            int i26 = i13;
            int i27 = 0;
            while (i27 < childCount) {
                View childAt = getChildAt(i27);
                if (((b) childAt.getLayoutParams()).c != 0 || !b(childAt)) {
                    i22 = childCount;
                    i26 = i26;
                } else {
                    View view = childAt;
                    i22 = childCount;
                    max2 += a(childAt, i2, max2, i3, 0, iArr);
                    View view2 = view;
                    i26 = Math.max(i26, view.getMeasuredHeight() + d(view2));
                    i25 = View.combineMeasuredStates(i25, v.h(view2));
                }
                i27++;
                childCount = i22;
            }
            int i28 = i26;
            int i29 = this.s + this.t;
            int i30 = this.q;
            int i31 = this.r;
            if (b((View) this.d)) {
                this.d.getLayoutParams().width = -2;
                this.d.setTextSize(0, this.O);
                i17 = -2;
                a((View) this.d, i2, 0, i3, i29, iArr);
                int measuredWidth = this.d.getMeasuredWidth() + c((View) this.d);
                i18 = this.d.getMeasuredHeight() + d((View) this.d);
                i19 = View.combineMeasuredStates(i25, v.h(this.d));
                i16 = measuredWidth;
            } else {
                i17 = -2;
                i19 = i25;
                i18 = 0;
                i16 = 0;
            }
            if (b((View) this.e)) {
                this.e.getLayoutParams().width = i17;
                i21 = i18;
                i16 = Math.max(i16, a((View) this.e, i2, 0, i3, i18 + i29, iArr));
                i20 = View.combineMeasuredStates(i19, v.h(this.e));
            } else {
                i20 = i19;
                i21 = i18;
            }
            int max3 = Math.max(i28, i21) + getPaddingTop() + getPaddingBottom();
            int a2 = v.a(Math.max(max2 + i16 + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), i23, -16777216 & i20);
            int a3 = v.a(Math.max(max3, getSuggestedMinimumHeight()), i24, i20 << 16);
            if (this.W) {
                a3 += this.aa.b();
            }
            if (g()) {
                a3 = 0;
            }
            setMeasuredDimension(a2, a3);
            a(this.N);
            int[] iArr2 = this.N;
            int i32 = iArr2[1] - iArr2[0];
            if (b((View) this.d)) {
                int measuredWidth2 = this.d.getMeasuredWidth();
                int[] iArr3 = this.N;
                if (measuredWidth2 > iArr3[1] - iArr3[0]) {
                    a((View) this.d, View.MeasureSpec.makeMeasureSpec(i32, Integer.MIN_VALUE), 0, i3, i29, iArr);
                }
            }
            if (b((View) this.e)) {
                int measuredWidth3 = this.e.getMeasuredWidth();
                int[] iArr4 = this.N;
                if (measuredWidth3 > iArr4[1] - iArr4[0]) {
                    a((View) this.e, View.MeasureSpec.makeMeasureSpec(i32, Integer.MIN_VALUE), 0, i3, i21 + i29, iArr);
                    return;
                }
                return;
            }
            return;
        }
        int[] iArr5 = this.D;
        if (ax.a(this)) {
            c3 = 1;
            c2 = 0;
        } else {
            c2 = 1;
            c3 = 0;
        }
        if (b((View) this.f)) {
            a((View) this.f, i2, 0, i3, 0, this.p);
            i6 = this.f.getMeasuredWidth() + c((View) this.f);
            i5 = Math.max(0, this.f.getMeasuredHeight() + d((View) this.f));
            i4 = View.combineMeasuredStates(0, v.h(this.f));
        } else {
            i6 = 0;
            i5 = 0;
            i4 = 0;
        }
        if (b((View) this.j)) {
            a((View) this.j, i2, 0, i3, 0, this.p);
            i6 = this.j.getMeasuredWidth() + c((View) this.j);
            i5 = Math.max(i5, this.j.getMeasuredHeight() + d((View) this.j));
            i4 = View.combineMeasuredStates(i4, v.h(this.j));
        }
        int contentInsetStart2 = getContentInsetStart();
        int max4 = 0 + Math.max(contentInsetStart2, i6);
        iArr5[c3] = Math.max(0, contentInsetStart2 - i6);
        if (b((View) this.c)) {
            a((h) this.c.getMenu(), z2);
            a((View) this.c, i2, max4, i3, 0, this.p);
            i7 = this.c.getMeasuredWidth() + c((View) this.c);
            i5 = Math.max(i5, this.c.getMeasuredHeight() + d((View) this.c));
            i4 = View.combineMeasuredStates(i4, v.h(this.c));
        } else {
            i7 = 0;
        }
        int contentInsetEnd2 = getContentInsetEnd();
        int max5 = max4 + Math.max(contentInsetEnd2, i7);
        iArr5[c2] = Math.max(0, contentInsetEnd2 - i7);
        if (b(this.f1551a)) {
            max5 += a(this.f1551a, i2, max5, i3, 0, iArr5);
            i5 = Math.max(i5, this.f1551a.getMeasuredHeight() + d(this.f1551a));
            i4 = View.combineMeasuredStates(i4, v.h(this.f1551a));
        }
        if (b((View) this.g)) {
            max5 += a((View) this.g, i2, max5, i3, 0, iArr5);
            i5 = Math.max(i5, this.g.getMeasuredHeight() + d((View) this.g));
            i4 = View.combineMeasuredStates(i4, v.h(this.g));
        }
        int childCount2 = getChildCount();
        int i33 = max5;
        for (int i34 = 0; i34 < childCount2; i34++) {
            View childAt2 = getChildAt(i34);
            if (((b) childAt2.getLayoutParams()).c == 0 && b(childAt2)) {
                View view3 = childAt2;
                i33 += a(childAt2, i2, i33, i3, 0, iArr5);
                View view4 = view3;
                i5 = Math.max(i5, view3.getMeasuredHeight() + d(view4));
                i4 = View.combineMeasuredStates(i4, v.h(view4));
            }
        }
        int i35 = this.s + this.t;
        int i36 = this.q + this.r;
        if (b((View) this.d)) {
            this.d.getLayoutParams().width = -1;
            this.d.setTextSize(0, this.O);
            i9 = 0;
            i11 = -1;
            a((View) this.d, i2, i33 + i36, i3, i35, iArr5);
            int measuredWidth4 = this.d.getMeasuredWidth() + c((View) this.d);
            i8 = this.d.getMeasuredHeight() + d((View) this.d);
            i12 = View.combineMeasuredStates(i4, v.h(this.d));
            i10 = measuredWidth4;
        } else {
            i11 = -1;
            i9 = 0;
            i12 = i4;
            i10 = 0;
            i8 = 0;
        }
        if (b((View) this.e)) {
            this.e.getLayoutParams().width = i11;
            i10 = Math.max(i10, a((View) this.e, i2, i33 + i36, i3, i8 + i35, iArr5));
            i8 += this.e.getMeasuredHeight() + d((View) this.e);
            i12 = View.combineMeasuredStates(i12, v.h(this.e));
        } else {
            int i37 = i12;
        }
        int max6 = Math.max(i5, i8);
        int paddingLeft = i33 + i10 + getPaddingLeft() + getPaddingRight();
        int paddingTop = max6 + getPaddingTop() + getPaddingBottom();
        int a4 = v.a(Math.max(paddingLeft, getSuggestedMinimumWidth()), i23, -16777216 & i12);
        int a5 = v.a(Math.max(paddingTop, getSuggestedMinimumHeight()), i3, i12 << 16);
        if (this.W) {
            a5 += this.aa.b();
        }
        int i38 = a5;
        if (g()) {
            i38 = i9;
        }
        setMeasuredDimension(a4, i38);
    }

    private void a(h hVar, boolean z2) {
        if (hVar != null) {
            if (!hVar.getNonActionItems().isEmpty()) {
                if (z2) {
                    setPadding(this.Q, getPaddingTop(), getPaddingRight(), getPaddingBottom());
                } else {
                    setPadding(getPaddingLeft(), getPaddingTop(), this.Q, getPaddingBottom());
                }
            } else if (z2) {
                setPadding(this.P, getPaddingTop(), this.P, getPaddingBottom());
            } else {
                setPadding(this.P, getPaddingTop(), this.P, getPaddingBottom());
            }
        }
    }

    private void a(int[] iArr) {
        int i2;
        int i3;
        boolean z2 = v.g(this) == 1;
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.color_actionbar_menuitemview_item_spacing);
        iArr[0] = Math.max(this.u.a(), getPaddingLeft());
        iArr[1] = getMeasuredWidth() - Math.max(this.u.b(), getPaddingRight());
        if (b((View) this.c) && this.c.getChildCount() != 0) {
            if (this.c.getChildCount() == 1) {
                i2 = this.c.getChildAt(0).getMeasuredWidth() + dimensionPixelSize + 0;
                i3 = 0;
            } else {
                i3 = this.c.getChildAt(0).getMeasuredWidth() + dimensionPixelSize + 0;
                i2 = 0;
                for (int i4 = 1; i4 < this.c.getChildCount(); i4++) {
                    i2 += this.c.getChildAt(i4).getMeasuredWidth() + dimensionPixelSize;
                }
            }
            if (z2) {
                iArr[0] = iArr[0] + i2;
                iArr[1] = iArr[1] - i3;
                return;
            }
            iArr[0] = iArr[0] + i3;
            iArr[1] = iArr[1] - i2;
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x0372  */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x03bb  */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x03df  */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x0423  */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x0452  */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x0461 A[LOOP:4: B:162:0x045f->B:163:0x0461, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0079  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00ba  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00d1  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00ee  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0107  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x010c  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0124  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0135  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0138  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x013c  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x013f  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0172  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x01b1  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x01c2  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x0285  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onLayout(boolean r19, int r20, int r21, int r22, int r23) {
        /*
            r18 = this;
            r0 = r18
            int r1 = androidx.core.g.v.g(r18)
            r2 = 1
            r3 = 0
            if (r1 != r2) goto L_0x000c
            r1 = r2
            goto L_0x000d
        L_0x000c:
            r1 = r3
        L_0x000d:
            int r4 = r18.getWidth()
            int r5 = r18.getHeight()
            boolean r6 = r0.W
            if (r6 == 0) goto L_0x0020
            color.support.design.widget.a r6 = r0.aa
            int r6 = r6.b()
            goto L_0x0021
        L_0x0020:
            r6 = r3
        L_0x0021:
            int r5 = r5 - r6
            int r6 = r18.getPaddingLeft()
            int r7 = r18.getPaddingRight()
            int r8 = r18.getPaddingTop()
            int r9 = r18.getPaddingBottom()
            int r10 = r4 - r7
            int[] r11 = r0.D
            r11[r2] = r3
            r11[r3] = r3
            int r12 = r18.getMinimumHeightCompat()
            android.widget.ImageButton r13 = r0.f
            boolean r13 = r0.b((android.view.View) r13)
            if (r13 == 0) goto L_0x0058
            if (r1 == 0) goto L_0x0051
            android.widget.ImageButton r13 = r0.f
            int r13 = r0.b(r13, r10, r11, r12)
            r14 = r13
            r13 = r6
            goto L_0x005a
        L_0x0051:
            android.widget.ImageButton r13 = r0.f
            int r13 = r0.a(r13, r6, r11, r12)
            goto L_0x0059
        L_0x0058:
            r13 = r6
        L_0x0059:
            r14 = r10
        L_0x005a:
            android.widget.ImageButton r15 = r0.j
            boolean r15 = r0.b((android.view.View) r15)
            if (r15 == 0) goto L_0x0071
            if (r1 == 0) goto L_0x006b
            android.widget.ImageButton r15 = r0.j
            int r14 = r0.b(r15, r14, r11, r12)
            goto L_0x0071
        L_0x006b:
            android.widget.ImageButton r15 = r0.j
            int r13 = r0.a(r15, r13, r11, r12)
        L_0x0071:
            androidx.appcompat.widget.ActionMenuView r15 = r0.c
            boolean r15 = r0.b((android.view.View) r15)
            if (r15 == 0) goto L_0x0088
            if (r1 == 0) goto L_0x0082
            androidx.appcompat.widget.ActionMenuView r15 = r0.c
            int r13 = r0.a(r15, r13, r11, r12)
            goto L_0x0088
        L_0x0082:
            androidx.appcompat.widget.ActionMenuView r15 = r0.c
            int r14 = r0.b(r15, r14, r11, r12)
        L_0x0088:
            int r15 = r18.getContentInsetLeft()
            int r15 = r15 - r13
            int r15 = java.lang.Math.max(r3, r15)
            r11[r3] = r15
            int r15 = r18.getContentInsetRight()
            int r16 = r10 - r14
            int r15 = r15 - r16
            int r15 = java.lang.Math.max(r3, r15)
            r11[r2] = r15
            int r15 = r18.getContentInsetLeft()
            int r13 = java.lang.Math.max(r13, r15)
            int r15 = r18.getContentInsetRight()
            int r10 = r10 - r15
            int r10 = java.lang.Math.min(r14, r10)
            android.view.View r14 = r0.f1551a
            boolean r14 = r0.b((android.view.View) r14)
            if (r14 == 0) goto L_0x00c9
            if (r1 == 0) goto L_0x00c3
            android.view.View r14 = r0.f1551a
            int r10 = r0.b(r14, r10, r11, r12)
            goto L_0x00c9
        L_0x00c3:
            android.view.View r14 = r0.f1551a
            int r13 = r0.a(r14, r13, r11, r12)
        L_0x00c9:
            android.widget.ImageView r14 = r0.g
            boolean r14 = r0.b((android.view.View) r14)
            if (r14 == 0) goto L_0x00e0
            if (r1 == 0) goto L_0x00da
            android.widget.ImageView r14 = r0.g
            int r10 = r0.b(r14, r10, r11, r12)
            goto L_0x00e0
        L_0x00da:
            android.widget.ImageView r14 = r0.g
            int r13 = r0.a(r14, r13, r11, r12)
        L_0x00e0:
            android.widget.TextView r14 = r0.d
            boolean r14 = r0.b((android.view.View) r14)
            android.widget.TextView r15 = r0.e
            boolean r15 = r0.b((android.view.View) r15)
            if (r14 == 0) goto L_0x0107
            android.widget.TextView r2 = r0.d
            android.view.ViewGroup$LayoutParams r2 = r2.getLayoutParams()
            color.support.v7.widget.Toolbar$b r2 = (color.support.v7.widget.Toolbar.b) r2
            int r3 = r2.topMargin
            r21 = r7
            android.widget.TextView r7 = r0.d
            int r7 = r7.getMeasuredHeight()
            int r3 = r3 + r7
            int r2 = r2.bottomMargin
            int r3 = r3 + r2
            r2 = 0
            int r3 = r3 + r2
            goto L_0x010a
        L_0x0107:
            r21 = r7
            r3 = 0
        L_0x010a:
            if (r15 == 0) goto L_0x0124
            android.widget.TextView r2 = r0.e
            android.view.ViewGroup$LayoutParams r2 = r2.getLayoutParams()
            color.support.v7.widget.Toolbar$b r2 = (color.support.v7.widget.Toolbar.b) r2
            int r7 = r2.topMargin
            r22 = r6
            android.widget.TextView r6 = r0.e
            int r6 = r6.getMeasuredHeight()
            int r7 = r7 + r6
            int r2 = r2.bottomMargin
            int r7 = r7 + r2
            int r3 = r3 + r7
            goto L_0x0126
        L_0x0124:
            r22 = r6
        L_0x0126:
            if (r14 != 0) goto L_0x0133
            if (r15 == 0) goto L_0x012b
            goto L_0x0133
        L_0x012b:
            r23 = r4
            r16 = r12
            r17 = r13
            goto L_0x0281
        L_0x0133:
            if (r14 == 0) goto L_0x0138
            android.widget.TextView r2 = r0.d
            goto L_0x013a
        L_0x0138:
            android.widget.TextView r2 = r0.e
        L_0x013a:
            if (r15 == 0) goto L_0x013f
            android.widget.TextView r6 = r0.e
            goto L_0x0141
        L_0x013f:
            android.widget.TextView r6 = r0.d
        L_0x0141:
            android.view.ViewGroup$LayoutParams r2 = r2.getLayoutParams()
            color.support.v7.widget.Toolbar$b r2 = (color.support.v7.widget.Toolbar.b) r2
            android.view.ViewGroup$LayoutParams r6 = r6.getLayoutParams()
            color.support.v7.widget.Toolbar$b r6 = (color.support.v7.widget.Toolbar.b) r6
            if (r14 == 0) goto L_0x0157
            android.widget.TextView r7 = r0.d
            int r7 = r7.getMeasuredWidth()
            if (r7 > 0) goto L_0x0161
        L_0x0157:
            if (r15 == 0) goto L_0x0165
            android.widget.TextView r7 = r0.e
            int r7 = r7.getMeasuredWidth()
            if (r7 <= 0) goto L_0x0165
        L_0x0161:
            r23 = r4
            r7 = 1
            goto L_0x0168
        L_0x0165:
            r23 = r4
            r7 = 0
        L_0x0168:
            int r4 = r0.v
            r4 = r4 & 112(0x70, float:1.57E-43)
            r16 = r12
            r12 = 48
            if (r4 == r12) goto L_0x01b1
            r12 = 80
            if (r4 == r12) goto L_0x01a5
            int r4 = r5 - r8
            int r4 = r4 - r9
            int r4 = r4 - r3
            int r4 = r4 / 2
            int r12 = r2.topMargin
            r17 = r13
            int r13 = r0.s
            int r12 = r12 + r13
            if (r4 >= r12) goto L_0x018c
            int r2 = r2.topMargin
            int r3 = r0.s
            int r4 = r2 + r3
            goto L_0x01a3
        L_0x018c:
            int r5 = r5 - r9
            int r5 = r5 - r3
            int r5 = r5 - r4
            int r5 = r5 - r8
            int r2 = r2.bottomMargin
            int r3 = r0.t
            int r2 = r2 + r3
            if (r5 >= r2) goto L_0x01a3
            int r2 = r6.bottomMargin
            int r3 = r0.t
            int r2 = r2 + r3
            int r2 = r2 - r5
            int r4 = r4 - r2
            r2 = 0
            int r4 = java.lang.Math.max(r2, r4)
        L_0x01a3:
            int r8 = r8 + r4
            goto L_0x01be
        L_0x01a5:
            r17 = r13
            int r5 = r5 - r9
            int r2 = r6.bottomMargin
            int r5 = r5 - r2
            int r2 = r0.t
            int r5 = r5 - r2
            int r8 = r5 - r3
            goto L_0x01be
        L_0x01b1:
            r17 = r13
            int r3 = r18.getPaddingTop()
            int r2 = r2.topMargin
            int r3 = r3 + r2
            int r2 = r0.s
            int r8 = r3 + r2
        L_0x01be:
            boolean r2 = r0.L
            if (r2 == 0) goto L_0x0285
            if (r14 == 0) goto L_0x01cb
            android.widget.TextView r1 = r0.d
            int r3 = r1.getMeasuredWidth()
            goto L_0x01cc
        L_0x01cb:
            r3 = 0
        L_0x01cc:
            if (r15 == 0) goto L_0x01d5
            android.widget.TextView r1 = r0.e
            int r1 = r1.getMeasuredWidth()
            goto L_0x01d6
        L_0x01d5:
            r1 = 0
        L_0x01d6:
            int r1 = java.lang.Math.max(r3, r1)
            int r2 = r18.getWidth()
            int[] r3 = r0.N
            r4 = 0
            r3 = r3[r4]
            int r5 = r18.getWidth()
            int[] r6 = r0.N
            r7 = 1
            r6 = r6[r7]
            int r5 = r5 - r6
            int r3 = java.lang.Math.max(r3, r5)
            int r3 = r3 * 2
            int r2 = r2 - r3
            int[] r3 = r0.N
            r5 = r3[r7]
            r3 = r3[r4]
            int r5 = r5 - r3
            if (r14 == 0) goto L_0x0240
            android.widget.TextView r3 = r0.d
            android.view.ViewGroup$LayoutParams r3 = r3.getLayoutParams()
            color.support.v7.widget.Toolbar$b r3 = (color.support.v7.widget.Toolbar.b) r3
            android.widget.TextView r4 = r0.d
            int r4 = r4.getMeasuredWidth()
            int r6 = r18.getWidth()
            int r6 = r6 - r4
            int r6 = r6 / 2
            int r7 = r6 + r4
            android.widget.TextView r9 = r0.d
            int r9 = r9.getMeasuredHeight()
            int r9 = r9 + r8
            if (r2 >= r1) goto L_0x0237
            if (r4 < r5) goto L_0x022a
            int[] r4 = r0.N
            r6 = 0
            r7 = r4[r6]
            r12 = 1
            r4 = r4[r12]
            r6 = r7
            r7 = r4
            goto L_0x0237
        L_0x022a:
            r6 = 0
            int r7 = r5 - r4
            int r7 = r7 / 2
            int[] r12 = r0.N
            r12 = r12[r6]
            int r6 = r12 + r7
            int r7 = r6 + r4
        L_0x0237:
            android.widget.TextView r4 = r0.d
            r4.layout(r6, r8, r7, r9)
            int r3 = r3.bottomMargin
            int r8 = r9 + r3
        L_0x0240:
            if (r15 == 0) goto L_0x0281
            android.widget.TextView r3 = r0.e
            android.view.ViewGroup$LayoutParams r3 = r3.getLayoutParams()
            color.support.v7.widget.Toolbar$b r3 = (color.support.v7.widget.Toolbar.b) r3
            int r3 = r3.topMargin
            int r8 = r8 + r3
            android.widget.TextView r3 = r0.e
            int r3 = r3.getMeasuredWidth()
            int r4 = r18.getWidth()
            int r4 = r4 - r3
            int r4 = r4 / 2
            int r6 = r4 + r3
            android.widget.TextView r7 = r0.e
            int r7 = r7.getMeasuredHeight()
            int r7 = r7 + r8
            if (r2 >= r1) goto L_0x027c
            if (r3 < r5) goto L_0x0270
            int[] r1 = r0.N
            r2 = 0
            r4 = r1[r2]
            r3 = 1
            r6 = r1[r3]
            goto L_0x027c
        L_0x0270:
            r2 = 0
            int r5 = r5 - r3
            int r5 = r5 / 2
            int[] r1 = r0.N
            r1 = r1[r2]
            int r4 = r1 + r5
            int r6 = r4 + r3
        L_0x027c:
            android.widget.TextView r1 = r0.e
            r1.layout(r4, r8, r6, r7)
        L_0x0281:
            r13 = r17
            goto L_0x0362
        L_0x0285:
            if (r1 == 0) goto L_0x02f7
            if (r7 == 0) goto L_0x028d
            int r3 = r0.q
            r1 = 1
            goto L_0x028f
        L_0x028d:
            r1 = 1
            r3 = 0
        L_0x028f:
            r2 = r11[r1]
            int r3 = r3 - r2
            r2 = 0
            int r4 = java.lang.Math.max(r2, r3)
            int r10 = r10 - r4
            int r3 = -r3
            int r3 = java.lang.Math.max(r2, r3)
            r11[r1] = r3
            if (r14 == 0) goto L_0x02c5
            android.widget.TextView r1 = r0.d
            android.view.ViewGroup$LayoutParams r1 = r1.getLayoutParams()
            color.support.v7.widget.Toolbar$b r1 = (color.support.v7.widget.Toolbar.b) r1
            android.widget.TextView r2 = r0.d
            int r2 = r2.getMeasuredWidth()
            int r2 = r10 - r2
            android.widget.TextView r3 = r0.d
            int r3 = r3.getMeasuredHeight()
            int r3 = r3 + r8
            android.widget.TextView r4 = r0.d
            r4.layout(r2, r8, r10, r3)
            int r4 = r0.r
            int r2 = r2 - r4
            int r1 = r1.bottomMargin
            int r8 = r3 + r1
            goto L_0x02c6
        L_0x02c5:
            r2 = r10
        L_0x02c6:
            if (r15 == 0) goto L_0x02ee
            android.widget.TextView r1 = r0.e
            android.view.ViewGroup$LayoutParams r1 = r1.getLayoutParams()
            color.support.v7.widget.Toolbar$b r1 = (color.support.v7.widget.Toolbar.b) r1
            int r3 = r1.topMargin
            int r8 = r8 + r3
            android.widget.TextView r3 = r0.e
            int r3 = r3.getMeasuredWidth()
            int r3 = r10 - r3
            android.widget.TextView r4 = r0.e
            int r4 = r4.getMeasuredHeight()
            int r4 = r4 + r8
            android.widget.TextView r5 = r0.e
            r5.layout(r3, r8, r10, r4)
            int r3 = r0.r
            int r3 = r10 - r3
            int r1 = r1.bottomMargin
            goto L_0x02ef
        L_0x02ee:
            r3 = r10
        L_0x02ef:
            if (r7 == 0) goto L_0x0281
            int r1 = java.lang.Math.min(r2, r3)
            r10 = r1
            goto L_0x0281
        L_0x02f7:
            if (r7 == 0) goto L_0x02fd
            int r3 = r0.q
            r1 = 0
            goto L_0x02ff
        L_0x02fd:
            r1 = 0
            r3 = 0
        L_0x02ff:
            r2 = r11[r1]
            int r3 = r3 - r2
            int r2 = java.lang.Math.max(r1, r3)
            int r13 = r17 + r2
            int r2 = -r3
            int r2 = java.lang.Math.max(r1, r2)
            r11[r1] = r2
            if (r14 == 0) goto L_0x0334
            android.widget.TextView r1 = r0.d
            android.view.ViewGroup$LayoutParams r1 = r1.getLayoutParams()
            color.support.v7.widget.Toolbar$b r1 = (color.support.v7.widget.Toolbar.b) r1
            android.widget.TextView r2 = r0.d
            int r2 = r2.getMeasuredWidth()
            int r2 = r2 + r13
            android.widget.TextView r3 = r0.d
            int r3 = r3.getMeasuredHeight()
            int r3 = r3 + r8
            android.widget.TextView r4 = r0.d
            r4.layout(r13, r8, r2, r3)
            int r4 = r0.r
            int r2 = r2 + r4
            int r1 = r1.bottomMargin
            int r8 = r3 + r1
            goto L_0x0335
        L_0x0334:
            r2 = r13
        L_0x0335:
            if (r15 == 0) goto L_0x035b
            android.widget.TextView r1 = r0.e
            android.view.ViewGroup$LayoutParams r1 = r1.getLayoutParams()
            color.support.v7.widget.Toolbar$b r1 = (color.support.v7.widget.Toolbar.b) r1
            int r3 = r1.topMargin
            int r8 = r8 + r3
            android.widget.TextView r3 = r0.e
            int r3 = r3.getMeasuredWidth()
            int r3 = r3 + r13
            android.widget.TextView r4 = r0.e
            int r4 = r4.getMeasuredHeight()
            int r4 = r4 + r8
            android.widget.TextView r5 = r0.e
            r5.layout(r13, r8, r3, r4)
            int r4 = r0.r
            int r3 = r3 + r4
            int r1 = r1.bottomMargin
            goto L_0x035c
        L_0x035b:
            r3 = r13
        L_0x035c:
            if (r7 == 0) goto L_0x0362
            int r13 = java.lang.Math.max(r2, r3)
        L_0x0362:
            java.util.ArrayList<android.view.View> r1 = r0.C
            r2 = 3
            r0.a((java.util.List<android.view.View>) r1, (int) r2)
            java.util.ArrayList<android.view.View> r1 = r0.C
            int r1 = r1.size()
            boolean r2 = r0.f1552b
            if (r2 == 0) goto L_0x03bb
            r2 = 0
        L_0x0373:
            if (r2 >= r1) goto L_0x03b8
            java.util.ArrayList<android.view.View> r3 = r0.C
            java.lang.Object r3 = r3.get(r2)
            android.view.View r3 = (android.view.View) r3
            android.view.ViewGroup$LayoutParams r3 = r3.getLayoutParams()
            if (r3 == 0) goto L_0x03a4
            boolean r4 = r3 instanceof color.support.v7.widget.Toolbar.b
            if (r4 == 0) goto L_0x03a4
            color.support.v7.widget.Toolbar$b r3 = (color.support.v7.widget.Toolbar.b) r3
            boolean r3 = r3.d
            if (r3 == 0) goto L_0x03a4
            java.util.ArrayList<android.view.View> r3 = r0.C
            java.lang.Object r3 = r3.get(r2)
            android.view.View r3 = (android.view.View) r3
            int r4 = r18.getContentInsetLeft()
            int[] r5 = r0.R
            r6 = 0
            int r3 = r0.a(r3, r4, r5, r6)
            r13 = r3
            r4 = r16
            goto L_0x03b3
        L_0x03a4:
            java.util.ArrayList<android.view.View> r3 = r0.C
            java.lang.Object r3 = r3.get(r2)
            android.view.View r3 = (android.view.View) r3
            r4 = r16
            int r3 = r0.a(r3, r13, r11, r4)
            r13 = r3
        L_0x03b3:
            int r2 = r2 + 1
            r16 = r4
            goto L_0x0373
        L_0x03b8:
            r4 = r16
            goto L_0x03cf
        L_0x03bb:
            r4 = r16
            r2 = 0
        L_0x03be:
            if (r2 >= r1) goto L_0x03cf
            java.util.ArrayList<android.view.View> r3 = r0.C
            java.lang.Object r3 = r3.get(r2)
            android.view.View r3 = (android.view.View) r3
            int r13 = r0.a(r3, r13, r11, r4)
            int r2 = r2 + 1
            goto L_0x03be
        L_0x03cf:
            java.util.ArrayList<android.view.View> r1 = r0.C
            r2 = 5
            r0.a((java.util.List<android.view.View>) r1, (int) r2)
            java.util.ArrayList<android.view.View> r1 = r0.C
            int r1 = r1.size()
            boolean r2 = r0.f1552b
            if (r2 == 0) goto L_0x0423
            r2 = 0
        L_0x03e0:
            if (r2 >= r1) goto L_0x0421
            java.util.ArrayList<android.view.View> r3 = r0.C
            java.lang.Object r3 = r3.get(r2)
            android.view.View r3 = (android.view.View) r3
            android.view.ViewGroup$LayoutParams r3 = r3.getLayoutParams()
            if (r3 == 0) goto L_0x0410
            boolean r5 = r3 instanceof color.support.v7.widget.Toolbar.b
            if (r5 == 0) goto L_0x0410
            color.support.v7.widget.Toolbar$b r3 = (color.support.v7.widget.Toolbar.b) r3
            boolean r3 = r3.d
            if (r3 == 0) goto L_0x0410
            java.util.ArrayList<android.view.View> r3 = r0.C
            java.lang.Object r3 = r3.get(r2)
            android.view.View r3 = (android.view.View) r3
            int r5 = r18.getContentInsetRight()
            int r5 = r23 - r5
            int[] r6 = r0.R
            r7 = 0
            int r3 = r0.b(r3, r5, r6, r7)
            goto L_0x041d
        L_0x0410:
            r7 = 0
            java.util.ArrayList<android.view.View> r3 = r0.C
            java.lang.Object r3 = r3.get(r2)
            android.view.View r3 = (android.view.View) r3
            int r3 = r0.b(r3, r10, r11, r4)
        L_0x041d:
            r10 = r3
            int r2 = r2 + 1
            goto L_0x03e0
        L_0x0421:
            r7 = 0
            goto L_0x0436
        L_0x0423:
            r7 = 0
            r2 = r7
        L_0x0425:
            if (r2 >= r1) goto L_0x0436
            java.util.ArrayList<android.view.View> r3 = r0.C
            java.lang.Object r3 = r3.get(r2)
            android.view.View r3 = (android.view.View) r3
            int r10 = r0.b(r3, r10, r11, r4)
            int r2 = r2 + 1
            goto L_0x0425
        L_0x0436:
            java.util.ArrayList<android.view.View> r1 = r0.C
            r2 = 1
            r0.a((java.util.List<android.view.View>) r1, (int) r2)
            java.util.ArrayList<android.view.View> r1 = r0.C
            int r1 = r0.a((java.util.List<android.view.View>) r1, (int[]) r11)
            int r2 = r23 - r22
            int r2 = r2 - r21
            int r2 = r2 / 2
            int r6 = r22 + r2
            int r2 = r1 / 2
            int r2 = r6 - r2
            int r1 = r1 + r2
            if (r2 >= r13) goto L_0x0452
            goto L_0x0459
        L_0x0452:
            if (r1 <= r10) goto L_0x0458
            int r1 = r1 - r10
            int r13 = r2 - r1
            goto L_0x0459
        L_0x0458:
            r13 = r2
        L_0x0459:
            java.util.ArrayList<android.view.View> r1 = r0.C
            int r1 = r1.size()
        L_0x045f:
            if (r7 >= r1) goto L_0x0470
            java.util.ArrayList<android.view.View> r2 = r0.C
            java.lang.Object r2 = r2.get(r7)
            android.view.View r2 = (android.view.View) r2
            int r13 = r0.a(r2, r13, r11, r4)
            int r7 = r7 + 1
            goto L_0x045f
        L_0x0470:
            java.util.ArrayList<android.view.View> r1 = r0.C
            r1.clear()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: color.support.v7.widget.Toolbar.onLayout(boolean, int, int, int, int):void");
    }

    private int a(List<View> list, int[] iArr) {
        int i2 = iArr[0];
        int i3 = iArr[1];
        int size = list.size();
        int i4 = i3;
        int i5 = 0;
        int i6 = i2;
        int i7 = 0;
        while (i5 < size) {
            View view = list.get(i5);
            b bVar = (b) view.getLayoutParams();
            int i8 = bVar.leftMargin - i6;
            int i9 = bVar.rightMargin - i4;
            int max = Math.max(0, i8);
            int max2 = Math.max(0, i9);
            int max3 = Math.max(0, -i8);
            int max4 = Math.max(0, -i9);
            i7 += max + view.getMeasuredWidth() + max2;
            i5++;
            i4 = max4;
            i6 = max3;
        }
        return i7;
    }

    private int a(View view, int i2, int[] iArr, int i3) {
        b bVar = (b) view.getLayoutParams();
        int i4 = bVar.leftMargin - iArr[0];
        int max = i2 + Math.max(0, i4);
        iArr[0] = Math.max(0, -i4);
        int a2 = a(view, i3);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max, a2, max + measuredWidth, view.getMeasuredHeight() + a2);
        return max + measuredWidth + bVar.rightMargin;
    }

    private int b(View view, int i2, int[] iArr, int i3) {
        b bVar = (b) view.getLayoutParams();
        int i4 = bVar.rightMargin - iArr[1];
        int max = i2 - Math.max(0, i4);
        iArr[1] = Math.max(0, -i4);
        int a2 = a(view, i3);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max - measuredWidth, a2, max, view.getMeasuredHeight() + a2);
        return max - (measuredWidth + bVar.leftMargin);
    }

    private int a(View view, int i2) {
        b bVar = (b) view.getLayoutParams();
        int measuredHeight = view.getMeasuredHeight();
        int i3 = 0;
        int i4 = i2 > 0 ? (measuredHeight - i2) / 2 : 0;
        int a2 = a(bVar.f172a);
        if (a2 == 48) {
            return getPaddingTop() - i4;
        }
        if (a2 != 80) {
            int paddingTop = getPaddingTop();
            int paddingBottom = getPaddingBottom();
            int height = getHeight() - (this.W ? this.aa.b() : 0);
            int i5 = (((height - paddingTop) - paddingBottom) - measuredHeight) / 2;
            if (i5 < bVar.topMargin) {
                i5 = bVar.topMargin;
            } else {
                int i6 = (((height - paddingBottom) - measuredHeight) - i5) - paddingTop;
                if (i6 < bVar.bottomMargin) {
                    i5 = Math.max(0, i5 - (bVar.bottomMargin - i6));
                }
            }
            return paddingTop + i5;
        }
        int height2 = getHeight();
        if (this.W) {
            i3 = this.aa.b();
        }
        return ((((height2 - i3) - getPaddingBottom()) - measuredHeight) - bVar.bottomMargin) - i4;
    }

    private int a(int i2) {
        int i3 = i2 & 112;
        return (i3 == 16 || i3 == 48 || i3 == 80) ? i3 : this.v & 112;
    }

    private void a(List<View> list, int i2) {
        boolean z2 = v.g(this) == 1;
        int childCount = getChildCount();
        int a2 = c.a(i2, v.g(this));
        list.clear();
        if (z2) {
            for (int i3 = childCount - 1; i3 >= 0; i3--) {
                View childAt = getChildAt(i3);
                b bVar = (b) childAt.getLayoutParams();
                if (bVar.c == 0 && b(childAt) && b(bVar.f172a) == a2) {
                    list.add(childAt);
                }
            }
            return;
        }
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt2 = getChildAt(i4);
            b bVar2 = (b) childAt2.getLayoutParams();
            if (bVar2.c == 0 && b(childAt2) && b(bVar2.f172a) == a2) {
                list.add(childAt2);
            }
        }
    }

    private int b(int i2) {
        int g2 = v.g(this);
        int a2 = c.a(i2, g2) & 7;
        if (a2 == 1 || a2 == 3 || a2 == 5) {
            return a2;
        }
        return g2 == 1 ? 5 : 3;
    }

    private boolean b(View view) {
        return (view == null || view.getParent() != this || view.getVisibility() == 8) ? false : true;
    }

    private int c(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return f.a(marginLayoutParams) + f.b(marginLayoutParams);
    }

    private int d(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }

    /* renamed from: a */
    public b generateLayoutParams(AttributeSet attributeSet) {
        return new b(getContext(), attributeSet);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public b generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof b) {
            return new b((b) layoutParams);
        }
        if (layoutParams instanceof a.C0003a) {
            return new b((a.C0003a) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new b((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new b(layoutParams);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public b generateDefaultLayoutParams() {
        return new b(-2, -2);
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof b);
    }

    /* access modifiers changed from: private */
    public void setChildVisibilityForExpandedActionView(boolean z2) {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (!(((b) childAt.getLayoutParams()).c == 2 || childAt == this.c)) {
                childAt.setVisibility(z2 ? 8 : 0);
            }
        }
    }

    private void e(View view) {
        if (((b) view.getLayoutParams()).c != 2 && view != this.c) {
            view.setVisibility(this.f1551a != null ? 8 : 0);
        }
    }

    public void setCollapsible(boolean z2) {
        this.J = z2;
        requestLayout();
    }

    public void setMenuCallbacks(n.a aVar, h.a aVar2) {
        this.H = aVar;
        this.I = aVar2;
    }

    public void setMinimumHeight(int i2) {
        this.K = i2;
        super.setMinimumHeight(i2);
    }

    private int getMinimumHeightCompat() {
        if (Build.VERSION.SDK_INT >= 16) {
            return v.m(this);
        }
        return this.K;
    }

    public static class b extends Toolbar.b {
        int c = 0;
        boolean d = false;

        public b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public b(int i, int i2) {
            super(i, i2);
            this.f172a = 8388627;
        }

        public b(b bVar) {
            super((Toolbar.b) bVar);
            this.c = bVar.c;
        }

        public b(a.C0003a aVar) {
            super(aVar);
        }

        public b(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            a(marginLayoutParams);
        }

        public b(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        /* access modifiers changed from: package-private */
        public void a(ViewGroup.MarginLayoutParams marginLayoutParams) {
            this.leftMargin = marginLayoutParams.leftMargin;
            this.topMargin = marginLayoutParams.topMargin;
            this.rightMargin = marginLayoutParams.rightMargin;
            this.bottomMargin = marginLayoutParams.bottomMargin;
        }
    }

    private class a implements n {

        /* renamed from: a  reason: collision with root package name */
        h f1556a;

        /* renamed from: b  reason: collision with root package name */
        j f1557b;

        public boolean flagActionItems() {
            return false;
        }

        public int getId() {
            return 0;
        }

        public void onCloseMenu(h hVar, boolean z) {
        }

        public void onRestoreInstanceState(Parcelable parcelable) {
        }

        public Parcelable onSaveInstanceState() {
            return null;
        }

        public boolean onSubMenuSelected(s sVar) {
            return false;
        }

        public void setCallback(n.a aVar) {
        }

        private a() {
        }

        public void initForMenu(Context context, h hVar) {
            j jVar;
            h hVar2 = this.f1556a;
            if (!(hVar2 == null || (jVar = this.f1557b) == null)) {
                hVar2.collapseItemActionView(jVar);
            }
            this.f1556a = hVar;
        }

        public void updateMenuView(boolean z) {
            if (this.f1557b != null) {
                h hVar = this.f1556a;
                boolean z2 = false;
                if (hVar != null) {
                    int size = hVar.size();
                    int i = 0;
                    while (true) {
                        if (i >= size) {
                            break;
                        } else if (this.f1556a.getItem(i) == this.f1557b) {
                            z2 = true;
                            break;
                        } else {
                            i++;
                        }
                    }
                }
                if (!z2) {
                    collapseItemActionView(this.f1556a, this.f1557b);
                }
            }
        }

        public boolean expandItemActionView(h hVar, j jVar) {
            Toolbar.this.f();
            ViewParent parent = Toolbar.this.j.getParent();
            Toolbar toolbar = Toolbar.this;
            if (parent != toolbar) {
                toolbar.addView(toolbar.j);
            }
            Toolbar.this.f1551a = jVar.getActionView();
            this.f1557b = jVar;
            ViewParent parent2 = Toolbar.this.f1551a.getParent();
            Toolbar toolbar2 = Toolbar.this;
            if (parent2 != toolbar2) {
                b a2 = toolbar2.generateDefaultLayoutParams();
                a2.f172a = 8388611 | (Toolbar.this.o & 112);
                a2.c = 2;
                Toolbar.this.f1551a.setLayoutParams(a2);
                Toolbar toolbar3 = Toolbar.this;
                toolbar3.addView(toolbar3.f1551a);
            }
            Toolbar.this.setChildVisibilityForExpandedActionView(true);
            Toolbar.this.requestLayout();
            jVar.e(true);
            if (Toolbar.this.f1551a instanceof androidx.appcompat.view.c) {
                ((androidx.appcompat.view.c) Toolbar.this.f1551a).a();
            }
            return true;
        }

        public boolean collapseItemActionView(h hVar, j jVar) {
            if (Toolbar.this.f1551a instanceof androidx.appcompat.view.c) {
                ((androidx.appcompat.view.c) Toolbar.this.f1551a).b();
            }
            Toolbar toolbar = Toolbar.this;
            toolbar.removeView(toolbar.f1551a);
            Toolbar toolbar2 = Toolbar.this;
            toolbar2.removeView(toolbar2.j);
            Toolbar toolbar3 = Toolbar.this;
            toolbar3.f1551a = null;
            toolbar3.setChildVisibilityForExpandedActionView(false);
            this.f1557b = null;
            Toolbar.this.requestLayout();
            jVar.e(false);
            return true;
        }
    }

    public void setIsTitleCenterStyle(boolean z2) {
        d();
        this.L = z2;
        b bVar = (b) this.c.getLayoutParams();
        if (this.L) {
            bVar.width = -1;
        } else {
            bVar.width = -2;
        }
        this.c.setLayoutParams(bVar);
        requestLayout();
    }

    public boolean getIsTitleCenterStyle() {
        return this.L;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        h();
    }

    public void inflateMenu(int i2) {
        super.inflateMenu(i2);
        ActionMenuView actionMenuView = this.c;
        if (actionMenuView instanceof a) {
            ((a) actionMenuView).j();
        }
    }

    public int getTotalScaleRange() {
        if (this.T < 0) {
            this.T = getMeasuredHeight() - v.m(this);
            if (this.W) {
                this.T -= this.aa.a();
            }
        }
        return this.T;
    }

    public void setMinTitleTextSize(float f2) {
        float f3 = this.U;
        if (f2 > f3) {
            f2 = f3;
        }
        this.V = f2;
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.W) {
            this.aa.a(canvas);
        }
    }

    private void h() {
        color.support.design.widget.a aVar = this.aa;
        if (aVar != null) {
            aVar.a(this.W);
        }
    }

    public int getBottomDividerHeight() {
        if (this.W) {
            return this.aa.b();
        }
        return 0;
    }

    public void setBottomDividerHeight(int i2) {
        this.aa.f(i2);
        postInvalidate();
    }

    public void setBottomDividerBackground(int i2) {
        this.aa.b(i2);
        postInvalidate();
    }

    public void setDividerColor(int i2) {
        this.aa.a(i2);
        postInvalidate();
    }

    public void setDividerMaxHeight(int i2) {
        this.aa.c(i2);
        postInvalidate();
    }

    public void setDividerMinHeight(int i2) {
        this.aa.d(i2);
        postInvalidate();
    }

    public void setDividerMargin(int i2) {
        this.aa.e(i2);
        postInvalidate();
    }

    public boolean showOverflowMenu() {
        ActionMenuView actionMenuView = this.c;
        if (actionMenuView instanceof a) {
            return actionMenuView.e();
        }
        return super.showOverflowMenu();
    }

    public void setPopupWindowOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        ActionMenuView actionMenuView = this.c;
        if (actionMenuView instanceof a) {
            ((a) actionMenuView).setPopupWindowOnDismissListener(onDismissListener);
        }
    }
}
