package com.color.support.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.f;
import color.support.v7.widget.Toolbar;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class ColorSearchViewAnimate extends LinearLayout implements androidx.appcompat.view.c {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f2102a = false;

    /* renamed from: b  reason: collision with root package name */
    private ImageView f2103b;
    private TextView c;
    /* access modifiers changed from: private */
    public ColorSearchView d;
    private SearchCancelButton e;
    private LinearLayout f;
    private volatile a g;
    private AtomicInteger h;
    private List<c> i;
    /* access modifiers changed from: private */
    public b j;
    /* access modifiers changed from: private */
    public long k;
    private MenuItem l;
    private Toolbar m;
    private boolean n;
    private boolean o;
    private int p;

    public interface b {
        void a(int i);

        void b(int i);
    }

    public interface c {
        void a(int i, int i2);
    }

    private int a(int i2) {
        return i2;
    }

    public void a() {
    }

    public void b() {
    }

    public void setGravity(int i2) {
        if (this.p != i2) {
            if ((8388615 & i2) == 0) {
                i2 |= 8388611;
            }
            if ((i2 & 112) == 0) {
                i2 |= 16;
            }
            this.p = i2;
            a((View) this.f, this.p);
        }
    }

    private void a(View view, int i2) {
        ViewGroup.LayoutParams layoutParams;
        if (view != null && (layoutParams = view.getLayoutParams()) != null && (layoutParams instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            Arrays.fill(layoutParams2.getRules(), 0);
            layoutParams2.alignWithParent = true;
            int i3 = i2 & 112;
            int i4 = 15;
            if (i3 != 16) {
                if (i3 == 48) {
                    i4 = 10;
                } else if (i3 == 80) {
                    i4 = 12;
                }
            }
            layoutParams2.addRule(i4);
            view.requestLayout();
        }
    }

    public int getGravity() {
        return this.p;
    }

    public void addView(View view) {
        super.addView(view);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
    }

    public void setOnAnimationListener(b bVar) {
        this.j = bVar;
    }

    public void setIconCanAnimate(boolean z) {
        this.o = z;
    }

    public long getAnimatorDuration() {
        return this.k;
    }

    public ColorSearchView getSearchView() {
        return this.d;
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        ImageView imageView = this.f2103b;
        if (imageView != null) {
            imageView.setEnabled(z);
        }
        TextView textView = this.c;
        if (textView != null) {
            textView.setEnabled(z);
        }
        LinearLayout linearLayout = this.f;
        if (linearLayout != null) {
            linearLayout.setEnabled(z);
        }
        ColorSearchView colorSearchView = this.d;
        if (colorSearchView != null) {
            colorSearchView.setEnabled(z);
        }
        SearchCancelButton searchCancelButton = this.e;
        if (searchCancelButton != null) {
            searchCancelButton.setEnabled(z);
        }
    }

    public int getSearchState() {
        return this.h.get();
    }

    private void setToolBarChildVisibility(int i2) {
        Toolbar toolbar = this.m;
        if (toolbar != null) {
            int childCount = toolbar.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = this.m.getChildAt(i3);
                if (childAt != this) {
                    childAt.setVisibility(i2);
                }
            }
        }
    }

    private void setToolBarAlpha(float f2) {
        Toolbar toolbar = this.m;
        if (toolbar != null) {
            int childCount = toolbar.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.m.getChildAt(i2);
                if (childAt != this) {
                    childAt.setAlpha(f2);
                }
            }
        }
    }

    private void setMenuItem(MenuItem menuItem) {
        this.l = menuItem;
        MenuItem menuItem2 = this.l;
        if (menuItem2 != null) {
            Toolbar toolbar = this.m;
            if (menuItem2.getActionView() == this) {
                this.l.setActionView((View) null);
            }
        }
    }

    public void a(boolean z) {
        ColorSearchView colorSearchView = this.d;
        if (colorSearchView != null && colorSearchView.getSearchAutoComplete() != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
            if (f2102a) {
                Log.d("ColorSearchViewAnimate", "openSoftInput: " + z);
            }
            if (z) {
                c();
                if (inputMethodManager != null) {
                    inputMethodManager.showSoftInput(this.d.getSearchAutoComplete(), 0);
                }
            } else if (inputMethodManager != null && inputMethodManager.isActive()) {
                inputMethodManager.hideSoftInputFromWindow(this.d.getSearchAutoComplete().getWindowToken(), 0);
            }
        }
    }

    public boolean getCancelIconAnimating() {
        return this.n;
    }

    public void setQueryHint(CharSequence charSequence) {
        TextView textView = this.c;
        if (textView != null) {
            textView.setText(charSequence);
        }
        ColorSearchView colorSearchView = this.d;
        if (colorSearchView != null) {
            colorSearchView.setQueryHint(charSequence);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        super.onMeasure(a(i2), i3);
        a((View) this.f, this.p);
    }

    private a getAnimatorHelper() {
        if (this.g == null) {
            synchronized (this) {
                if (this.g == null) {
                    this.g = new a();
                }
            }
        }
        return this.g;
    }

    /* access modifiers changed from: private */
    public void c() {
        SearchView.SearchAutoComplete searchAutoComplete;
        ColorSearchView colorSearchView = this.d;
        if (colorSearchView != null && (searchAutoComplete = colorSearchView.getSearchAutoComplete()) != null) {
            searchAutoComplete.setFocusable(true);
            searchAutoComplete.setFocusableInTouchMode(true);
            searchAutoComplete.requestFocus();
        }
    }

    /* access modifiers changed from: private */
    public void d() {
        ColorSearchView colorSearchView = this.d;
        if (colorSearchView != null) {
            colorSearchView.clearFocus();
            this.d.setFocusable(false);
            this.d.onWindowFocusChanged(false);
            SearchView.SearchAutoComplete searchAutoComplete = this.d.getSearchAutoComplete();
            if (searchAutoComplete != null) {
                searchAutoComplete.setFocusable(false);
            }
        }
    }

    /* access modifiers changed from: private */
    public void a(int i2, int i3) {
        List<c> list = this.i;
        if (list != null) {
            for (c next : list) {
                if (next != null) {
                    next.a(i2, i3);
                }
            }
        }
    }

    private class a {

        /* renamed from: b  reason: collision with root package name */
        private long f2107b = ColorSearchViewAnimate.this.k;
        /* access modifiers changed from: private */
        public volatile AtomicBoolean c = new AtomicBoolean(false);
        private Runnable d = new Runnable() {
            public void run() {
                ColorSearchViewAnimate.this.d();
                ColorSearchViewAnimate.this.a(true);
                if (ColorSearchViewAnimate.this.j != null) {
                    ColorSearchViewAnimate.this.j.a(1);
                }
                ColorSearchViewAnimate.this.a(0, 1);
            }
        };
        private Runnable e = new Runnable() {
            public void run() {
                ColorSearchViewAnimate.this.c();
                a.this.c.set(false);
                if (ColorSearchViewAnimate.this.j != null) {
                    ColorSearchViewAnimate.this.j.b(1);
                }
            }
        };
        private Runnable f = new Runnable() {
            public void run() {
                ColorSearchViewAnimate.this.c();
                ColorSearchViewAnimate.this.a(false);
                if (ColorSearchViewAnimate.this.j != null) {
                    ColorSearchViewAnimate.this.j.a(0);
                }
                ColorSearchViewAnimate.this.a(1, 0);
            }
        };
        private Runnable g = new Runnable() {
            public void run() {
                ColorSearchViewAnimate.this.d();
                a.this.c.set(false);
                ColorSearchViewAnimate.this.d.a((CharSequence) "", false);
                if (ColorSearchViewAnimate.this.j != null) {
                    ColorSearchViewAnimate.this.j.b(0);
                }
            }
        };

        a() {
        }
    }

    public static class SearchCancelButton extends f {

        /* renamed from: a  reason: collision with root package name */
        volatile boolean f2104a = false;

        /* renamed from: b  reason: collision with root package name */
        a f2105b;

        interface a {
            void a();
        }

        public void setPerformClickCallback(a aVar) {
            this.f2105b = aVar;
        }

        public SearchCancelButton(Context context) {
            super(context);
        }

        public SearchCancelButton(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public SearchCancelButton(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
        }

        public boolean performClick() {
            a aVar = this.f2105b;
            if (aVar != null) {
                this.f2104a = true;
                aVar.a();
            }
            return super.performClick();
        }

        public void setPerformClicked(boolean z) {
            this.f2104a = z;
        }
    }
}
