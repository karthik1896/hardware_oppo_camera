package com.oppo.camera.j;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.core.content.a;
import com.oppo.camera.R;
import com.oppo.camera.professional.l;
import com.oppo.camera.util.Util;

/* compiled from: FilmMainBarItem */
public class d extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    private ImageView f3353a;

    /* renamed from: b  reason: collision with root package name */
    private l f3354b;
    private Drawable c;
    private float d;
    private int e;
    private int f;
    private int g;
    private int h;
    private Resources i;
    private int j;
    private boolean k;

    public d(Context context) {
        super(context);
        this.f3353a = null;
        this.f3354b = null;
        this.c = null;
        this.d = 0.66f;
        this.e = 0;
        this.f = 2;
        this.g = 0;
        this.h = 0;
        this.i = null;
        this.j = 1000;
        this.k = true;
        this.i = getResources();
        this.e = this.i.getDimensionPixelSize(R.dimen.movie_mode_params_value_text_size);
        this.h = this.i.getDimensionPixelSize(R.dimen.movie_mode_params_item_text_offset);
        ColorStateList colorStateList = getResources().getColorStateList(R.color.profession_mode_bar_text_color, context.getTheme());
        this.f3353a = new ImageView(context);
        this.f3353a.setId(this.j);
        this.f3353a.setLayoutParams(new RelativeLayout.LayoutParams(this.i.getDimensionPixelSize(R.dimen.movie_params_image_size), this.i.getDimensionPixelSize(R.dimen.movie_params_image_size)));
        addView(this.f3353a);
        this.f3354b = new l(context);
        this.f3354b.setVerticalDraw(true);
        this.f3354b.setIncludeFontPadding(false);
        this.f3354b.setTextSize(0, (float) this.e);
        this.f3354b.setTypeface(Util.j(context));
        this.f3354b.setGravity(17);
        this.f3354b.setTextColor(colorStateList);
        this.c = getResources().getDrawable(R.drawable.pro_ic_tips_auto);
        this.c.setBounds(0, Util.a(this.d), this.i.getDimensionPixelSize(R.dimen.main_mode_bar_item_auto_width), Util.a(this.d) + this.i.getDimensionPixelSize(R.dimen.main_mode_bar_item_auto_height));
        this.f3354b.setCompoundDrawablePadding(Util.a((float) this.f));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(3, this.j);
        this.f3354b.setLayoutParams(layoutParams);
        addView(this.f3354b);
        setClipChildren(false);
    }

    public void a(int i2, boolean z) {
        l lVar;
        if (!this.k || (lVar = this.f3354b) == null) {
            return;
        }
        if (i2 == 0) {
            Drawable mutate = this.c.mutate();
            if (z) {
                mutate.setTintList(ColorStateList.valueOf(Util.s(getContext())));
            } else {
                mutate.setTintList(ColorStateList.valueOf(a.c(getContext(), R.color.camera_white)));
            }
            this.f3354b.setCompoundDrawables(mutate, (Drawable) null, (Drawable) null, (Drawable) null);
            return;
        }
        lVar.setCompoundDrawables((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
    }

    public void setItemTitleImage(int i2) {
        ImageView imageView = this.f3353a;
        if (imageView != null) {
            imageView.setImageResource(i2);
            this.f3353a.measure(Util.E(), Util.D());
        }
    }

    public void setItemValueText(String str) {
        if (str != null && str.length() < l.f3576a) {
            this.f3354b.setVerticalDraw(false);
        }
        this.f3354b.setText(str);
        this.f3354b.setContentDescription(str);
        this.f3354b.measure(Util.E(), Util.D());
    }

    private int getChildHeight() {
        int childCount = getChildCount();
        int i2 = 0;
        for (int i3 = 0; i3 < childCount; i3++) {
            i2 += getChildAt(i3).getMeasuredHeight();
        }
        return i2;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int i6 = i4 - i2;
        int childHeight = ((i5 - i3) - getChildHeight()) / 2;
        int childCount = getChildCount();
        int i7 = 0;
        int i8 = 0;
        while (i7 < childCount) {
            View childAt = getChildAt(i7);
            int measuredWidth = childAt.getMeasuredWidth();
            int measuredHeight = childAt.getMeasuredHeight();
            int i9 = (i6 - measuredWidth) / 2;
            if (i7 == 0) {
                i8 = childHeight;
            }
            if (childAt == this.f3354b) {
                i8 -= this.h;
            }
            int i10 = measuredHeight + i8;
            childAt.layout(i9, i8, measuredWidth + i9, i10);
            i7++;
            i8 = i10;
        }
    }

    public void setPressed(boolean z) {
        super.setPressed(z);
    }
}
