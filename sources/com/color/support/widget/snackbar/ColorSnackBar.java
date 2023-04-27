package com.color.support.widget.snackbar;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.PathInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import color.support.v7.appcompat.R;

public class ColorSnackBar extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    private static final PathInterpolator f2278a = new PathInterpolator(0.3f, 0.0f, 1.0f, 1.0f);

    /* renamed from: b  reason: collision with root package name */
    private static final PathInterpolator f2279b = new PathInterpolator(0.0f, 0.0f, 0.15f, 1.0f);
    private static int n;
    private final int c = getResources().getDimensionPixelSize(R.dimen.color_snack_bar_max_width);
    private final int d = getResources().getDimensionPixelSize(R.dimen.color_snack_bar_action_max_width);
    private final int e = getResources().getDimensionPixelSize(R.dimen.color_snack_bar_icon_width);
    private final int f = getResources().getDimensionPixelSize(R.dimen.color_snack_bar_icon_height);
    private final int g = getResources().getDimensionPixelSize(R.dimen.color_snack_bar_single_line_margin_top);
    private final int h = getResources().getDimensionPixelSize(R.dimen.color_snack_bar_single_line_margin_bottom);
    private final int i = getResources().getDimensionPixelSize(R.dimen.color_snack_bar_multi_line_margin_top);
    private final int j = getResources().getDimensionPixelSize(R.dimen.color_snack_bar_multi_line_margin_bottom);
    private final int k = getResources().getDimensionPixelSize(R.dimen.color_snack_bar_margin_start);
    private final int l = getResources().getDimensionPixelSize(R.dimen.color_snack_bar_content_action_min_margin);
    private final int m = getResources().getDimensionPixelSize(R.dimen.color_snack_bar_action_multi_line_interval);
    /* access modifiers changed from: private */
    public ViewGroup o;
    private TextView p;
    private TextView q;
    private ImageView r;
    /* access modifiers changed from: private */
    public View s;
    private int t;
    private int u;
    private int v;
    private String w;
    /* access modifiers changed from: private */
    public Runnable x;
    /* access modifiers changed from: private */
    public b y;

    public interface b {
        void a(ColorSnackBar colorSnackBar);
    }

    public ColorSnackBar(Context context) {
        super(context);
        a(context, (AttributeSet) null);
    }

    public ColorSnackBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet);
    }

    public void setEnabled(boolean z) {
        Runnable runnable;
        super.setEnabled(z);
        this.q.setEnabled(z);
        this.p.setEnabled(z);
        this.r.setEnabled(z);
        if (getDuration() != 0 && (runnable = this.x) != null) {
            removeCallbacks(runnable);
            postDelayed(this.x, (long) getDuration());
        }
    }

    public void a() {
        Runnable runnable = this.x;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
        c();
    }

    public void setContentText(int i2) {
        setContentText(getResources().getString(i2));
    }

    public void setContentText(String str) {
        if (TextUtils.isEmpty(str)) {
            this.p.setVisibility(8);
            Runnable runnable = this.x;
            if (runnable != null) {
                removeCallbacks(runnable);
                return;
            }
            return;
        }
        this.p.setText(str);
        this.w = str;
    }

    public void setOnStatusChangeListener(b bVar) {
        this.y = bVar;
    }

    private void setActionText(String str) {
        this.q.setText(str);
    }

    public String getContentText() {
        return String.valueOf(this.p.getText());
    }

    public TextView getContentView() {
        return this.p;
    }

    public TextView getActionView() {
        return this.q;
    }

    public String getActionText() {
        return String.valueOf(this.q.getText());
    }

    public int getDuration() {
        return this.u;
    }

    public void setDuration(int i2) {
        this.u = i2;
    }

    /* renamed from: com.color.support.widget.snackbar.ColorSnackBar$1  reason: invalid class name */
    class AnonymousClass1 implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ View.OnClickListener f2280a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ColorSnackBar f2281b;

        public void onClick(View view) {
            this.f2280a.onClick(view);
            ColorSnackBar colorSnackBar = this.f2281b;
            colorSnackBar.removeCallbacks(colorSnackBar.x);
            this.f2281b.a();
        }
    }

    private void setParent(ViewGroup viewGroup) {
        this.o = viewGroup;
    }

    public void setIconDrawable(int i2) {
        setIconDrawable(getResources().getDrawable(i2, getContext().getTheme()));
    }

    public void setIconDrawable(Drawable drawable) {
        if (drawable == null) {
            this.r.setVisibility(8);
            return;
        }
        this.r.setVisibility(0);
        this.r.setImageDrawable(drawable);
    }

    private boolean b() {
        return this.r.getDrawable() != null;
    }

    private void a(Context context, AttributeSet attributeSet) {
        this.s = inflate(context, R.layout.color_snack_bar_item, this);
        this.p = (TextView) this.s.findViewById(R.id.tv_color_snack_bar_content);
        this.q = (TextView) this.s.findViewById(R.id.tv_color_snack_bar_action);
        this.r = (ImageView) this.s.findViewById(R.id.iv_color_snack_bar_icon);
        n = new ViewGroup.MarginLayoutParams(context, attributeSet).bottomMargin;
        com.color.support.widget.a.a aVar = new com.color.support.widget.a.a();
        aVar.a(context.getResources().getDimension(R.dimen.color_snack_bar_background_radius));
        aVar.a(context.getResources().getColor(R.color.color_snack_bar_background_color));
        this.s.setBackground(aVar);
        setVisibility(8);
        this.x = new a(this, (AnonymousClass1) null);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ColorSnackBar, 0, 0);
        try {
            if (obtainStyledAttributes.getString(R.styleable.ColorSnackBar_defaultSnackBarContentText) != null) {
                setContentText(obtainStyledAttributes.getString(R.styleable.ColorSnackBar_defaultSnackBarContentText));
                setDuration(obtainStyledAttributes.getInt(R.styleable.ColorSnackBar_snackBarDisappearTime, 0));
            }
            setIconDrawable(obtainStyledAttributes.getDrawable(R.styleable.ColorSnackBar_colorSnackBarIcon));
        } catch (Exception e2) {
            Log.e("ColorSnackbar", "Failure setting ColorSnackBar " + e2.getMessage());
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
        obtainStyledAttributes.recycle();
    }

    private void c() {
        View view = this.s;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "translationY", new float[]{(float) (view.getHeight() + n)});
        ofFloat.setInterpolator(f2278a);
        ofFloat.setDuration(120);
        ofFloat.addListener(new Animator.AnimatorListener() {
            public void onAnimationCancel(Animator animator) {
            }

            public void onAnimationRepeat(Animator animator) {
            }

            public void onAnimationStart(Animator animator) {
            }

            public void onAnimationEnd(Animator animator) {
                ColorSnackBar.this.s.setVisibility(8);
                if (ColorSnackBar.this.o != null) {
                    ColorSnackBar.this.o.removeView(ColorSnackBar.this.s);
                }
                if (ColorSnackBar.this.y != null) {
                    ColorSnackBar.this.y.a(ColorSnackBar.this);
                }
            }
        });
        ofFloat.start();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        this.t = (int) this.p.getPaint().measureText(this.w);
        this.v = (this.c - (this.l * 3)) - this.q.getMeasuredWidth();
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        if (b()) {
            if (this.q.getMeasuredWidth() < this.d) {
                this.p.setMaxWidth(this.v);
                if (this.t > this.v) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.q.getLayoutParams();
                    layoutParams.topMargin = (((this.i + this.j) + this.p.getMeasuredHeight()) - this.q.getMeasuredHeight()) / 2;
                    layoutParams.bottomMargin = layoutParams.topMargin;
                    this.q.setLayoutParams(layoutParams);
                    ((RelativeLayout.LayoutParams) this.r.getLayoutParams()).topMargin = (getMeasuredHeight() - this.e) / 2;
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.p.getLayoutParams();
                    int measuredWidth = (this.c - (this.l * 3)) - this.q.getMeasuredWidth();
                    int i6 = this.l;
                    int i7 = this.e;
                    layoutParams2.width = (measuredWidth - i6) - i7;
                    layoutParams2.setMarginStart(i6 + this.k + i7);
                    layoutParams2.topMargin = this.i;
                    layoutParams2.bottomMargin = this.j;
                    layoutParams2.setMarginEnd(this.l);
                    this.p.setLayoutParams(layoutParams2);
                    return;
                }
                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.q.getLayoutParams();
                layoutParams3.topMargin = this.g;
                layoutParams3.bottomMargin = this.h;
                this.q.setLayoutParams(layoutParams3);
                ((RelativeLayout.LayoutParams) this.r.getLayoutParams()).topMargin = this.i;
                RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.p.getLayoutParams();
                int measuredWidth2 = (this.c - (this.l * 3)) - this.q.getMeasuredWidth();
                int i8 = this.l;
                int i9 = this.e;
                layoutParams4.width = (measuredWidth2 - i8) - i9;
                layoutParams4.setMarginStart(i8 + this.k + i9);
                layoutParams4.topMargin = this.g;
                layoutParams4.bottomMargin = this.h;
                this.p.setLayoutParams(layoutParams4);
            } else if (this.p.getLineCount() > 1) {
                RelativeLayout.LayoutParams layoutParams5 = (RelativeLayout.LayoutParams) this.q.getLayoutParams();
                layoutParams5.bottomMargin = this.j;
                layoutParams5.topMargin = this.i + getResources().getDimensionPixelSize(R.dimen.color_snack_bar_action_multi_line_content_long_interval) + this.p.getMeasuredHeight();
                this.q.setLayoutParams(layoutParams5);
                ((RelativeLayout.LayoutParams) this.r.getLayoutParams()).topMargin = this.i + ((this.p.getMeasuredHeight() - this.f) / 2);
                RelativeLayout.LayoutParams layoutParams6 = (RelativeLayout.LayoutParams) this.p.getLayoutParams();
                int i10 = this.c;
                int i11 = this.l;
                int i12 = this.e;
                layoutParams6.width = ((i10 - (i11 * 2)) - i11) - i12;
                layoutParams6.topMargin = this.i;
                layoutParams6.setMarginStart(i11 + this.k + i12);
                layoutParams6.setMarginEnd(0);
                this.p.setLayoutParams(layoutParams6);
            } else {
                RelativeLayout.LayoutParams layoutParams7 = (RelativeLayout.LayoutParams) this.q.getLayoutParams();
                layoutParams7.bottomMargin = this.j;
                layoutParams7.topMargin = this.i + this.m + this.e;
                this.q.setLayoutParams(layoutParams7);
                ((RelativeLayout.LayoutParams) this.r.getLayoutParams()).topMargin = this.i;
                RelativeLayout.LayoutParams layoutParams8 = (RelativeLayout.LayoutParams) this.p.getLayoutParams();
                int i13 = this.c;
                int i14 = this.l;
                int i15 = this.e;
                layoutParams8.width = ((i13 - (i14 * 2)) - i14) - i15;
                layoutParams8.topMargin = this.g;
                layoutParams8.setMarginStart(i14 + this.k + i15);
                layoutParams8.setMarginEnd(0);
                this.p.setLayoutParams(layoutParams8);
            }
        } else if (this.q.getMeasuredWidth() >= this.d) {
            if (this.p.getLineCount() > 1) {
                RelativeLayout.LayoutParams layoutParams9 = (RelativeLayout.LayoutParams) this.q.getLayoutParams();
                layoutParams9.bottomMargin = this.j;
                layoutParams9.topMargin = this.i + getResources().getDimensionPixelSize(R.dimen.color_snack_bar_action_multi_line_content_long_interval) + this.p.getMeasuredHeight();
                this.q.setLayoutParams(layoutParams9);
                RelativeLayout.LayoutParams layoutParams10 = (RelativeLayout.LayoutParams) this.p.getLayoutParams();
                layoutParams10.width = this.c - (this.l * 2);
                layoutParams10.topMargin = this.i;
                layoutParams10.setMarginStart(this.k);
                layoutParams10.setMarginEnd(0);
                this.p.setLayoutParams(layoutParams10);
                return;
            }
            RelativeLayout.LayoutParams layoutParams11 = (RelativeLayout.LayoutParams) this.q.getLayoutParams();
            layoutParams11.bottomMargin = this.j;
            layoutParams11.topMargin = this.i + this.m + this.p.getMeasuredHeight();
            this.q.setLayoutParams(layoutParams11);
            RelativeLayout.LayoutParams layoutParams12 = (RelativeLayout.LayoutParams) this.p.getLayoutParams();
            layoutParams12.width = this.c - (this.l * 2);
            layoutParams12.topMargin = this.i;
            layoutParams12.setMarginEnd(0);
            this.p.setLayoutParams(layoutParams12);
        } else if (this.t > this.v) {
            RelativeLayout.LayoutParams layoutParams13 = (RelativeLayout.LayoutParams) this.q.getLayoutParams();
            layoutParams13.topMargin = (((this.i + this.j) + this.p.getMeasuredHeight()) - this.q.getMeasuredHeight()) / 2;
            layoutParams13.bottomMargin = layoutParams13.topMargin;
            this.q.setLayoutParams(layoutParams13);
            RelativeLayout.LayoutParams layoutParams14 = (RelativeLayout.LayoutParams) this.p.getLayoutParams();
            layoutParams14.width = (this.c - (this.l * 3)) - this.q.getMeasuredWidth();
            layoutParams14.topMargin = this.i;
            layoutParams14.bottomMargin = this.j;
            layoutParams14.setMarginEnd(this.l);
            this.p.setLayoutParams(layoutParams14);
        } else {
            RelativeLayout.LayoutParams layoutParams15 = (RelativeLayout.LayoutParams) this.q.getLayoutParams();
            layoutParams15.topMargin = this.g;
            layoutParams15.bottomMargin = this.h;
            this.q.setLayoutParams(layoutParams15);
            RelativeLayout.LayoutParams layoutParams16 = (RelativeLayout.LayoutParams) this.p.getLayoutParams();
            layoutParams16.topMargin = this.g;
            layoutParams16.bottomMargin = this.h;
            this.p.setLayoutParams(layoutParams16);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000d, code lost:
        if (r4 != 3) goto L_0x0031;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r4) {
        /*
            r3 = this;
            int r4 = r4.getAction()
            r0 = 1
            if (r4 == 0) goto L_0x002a
            if (r4 == r0) goto L_0x0010
            r1 = 2
            if (r4 == r1) goto L_0x002a
            r1 = 3
            if (r4 == r1) goto L_0x0010
            goto L_0x0031
        L_0x0010:
            java.lang.Runnable r4 = r3.x
            if (r4 == 0) goto L_0x0031
            int r4 = r3.getDuration()
            if (r4 == 0) goto L_0x0031
            java.lang.Runnable r4 = r3.x
            r3.removeCallbacks(r4)
            java.lang.Runnable r4 = r3.x
            int r1 = r3.getDuration()
            long r1 = (long) r1
            r3.postDelayed(r4, r1)
            goto L_0x0031
        L_0x002a:
            java.lang.Runnable r4 = r3.x
            if (r4 == 0) goto L_0x0031
            r3.removeCallbacks(r4)
        L_0x0031:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.color.support.widget.snackbar.ColorSnackBar.onTouchEvent(android.view.MotionEvent):boolean");
    }

    private class a implements Runnable {
        private a() {
        }

        /* synthetic */ a(ColorSnackBar colorSnackBar, AnonymousClass1 r2) {
            this();
        }

        public void run() {
            ColorSnackBar.this.a();
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.x);
        this.o = null;
    }
}
