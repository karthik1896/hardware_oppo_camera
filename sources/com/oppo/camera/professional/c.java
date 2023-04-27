package com.oppo.camera.professional;

import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.core.content.a;
import com.oppo.camera.R;
import com.oppo.camera.util.Util;

/* compiled from: MainBarItem */
public class c extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    private static int f3518a;

    /* renamed from: b  reason: collision with root package name */
    private Activity f3519b = null;
    /* access modifiers changed from: private */
    public ImageView c = null;
    private ImageView d = null;
    private l e = null;
    private int f = 0;
    private int g = 0;
    private Resources h;
    private boolean i = true;

    public c(Activity activity) {
        super(activity);
        this.f3519b = activity;
        this.h = this.f3519b.getApplication().getResources();
        f3518a = this.h.getDimensionPixelSize(R.dimen.main_mode_bar_item_title_image_margin_top);
        this.f = this.h.getDimensionPixelSize(R.dimen.main_mode_bar_item_value_text_margin_top);
        this.g = this.h.getDimensionPixelSize(R.dimen.main_mode_bar_item_value_auto_image_padding);
        this.c = new ImageView(this.f3519b);
        this.c.setLayoutParams(new RelativeLayout.LayoutParams(this.h.getDimensionPixelSize(R.dimen.main_mode_bar_item_image_width), this.h.getDimensionPixelSize(R.dimen.main_mode_bar_item_image_height)));
        addView(this.c);
        ColorStateList colorStateList = this.h.getColorStateList(R.color.profession_mode_bar_text_color, this.f3519b.getTheme());
        this.e = new l(this.f3519b);
        this.e.setHeight(this.h.getDimensionPixelSize(R.dimen.main_mode_bar_item_value_text_height));
        this.e.setVerticalDraw(true);
        this.e.setIncludeFontPadding(false);
        this.e.setTextSize(0, (float) this.h.getDimensionPixelSize(R.dimen.main_mode_bar_item_value_text_size));
        this.e.setTypeface(Util.j((Context) this.f3519b));
        this.e.setGravity(17);
        this.e.setTextColor(colorStateList);
        addView(this.e);
        this.d = new ImageView(this.f3519b);
        this.d.setImageDrawable(Util.b(getContext(), (int) R.drawable.pro_ic_tips_auto));
        this.d.setLayoutParams(new RelativeLayout.LayoutParams(this.h.getDimensionPixelSize(R.dimen.main_mode_bar_item_auto_width), this.h.getDimensionPixelSize(R.dimen.main_mode_bar_item_auto_height)));
        this.d.setVisibility(8);
        addView(this.d);
    }

    public void a(boolean z) {
        this.i = z;
    }

    public void a(int i2, boolean z) {
        if (!this.i || this.e == null) {
            return;
        }
        if (i2 == 0) {
            if (z) {
                this.d.setImageTintList(ColorStateList.valueOf(Util.s(this.f3519b)));
            } else {
                this.d.setImageTintList(ColorStateList.valueOf(a.c(this.f3519b, R.color.camera_white)));
            }
            this.d.setVisibility(0);
            return;
        }
        this.d.setVisibility(8);
    }

    public void setItemTitleImage(final int i2) {
        Activity activity = this.f3519b;
        if (activity != null) {
            activity.runOnUiThread(new Runnable() {
                public void run() {
                    if (c.this.c != null) {
                        c.this.c.setImageResource(i2);
                        c.this.c.measure(Util.E(), Util.D());
                    }
                }
            });
        }
    }

    public void setItemValueText(String str) {
        if (str != null && str.length() < l.f3576a) {
            this.e.setVerticalDraw(false);
        }
        this.e.setText(str);
        this.e.setContentDescription(str);
        this.e.measure(Util.E(), Util.D());
    }

    public String getItemValueText() {
        l lVar = this.e;
        if (lVar != null) {
            return lVar.getText().toString();
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int i6;
        int i7 = i4 - i2;
        ImageView imageView = this.c;
        if (imageView != null) {
            int measuredWidth = imageView.getMeasuredWidth();
            int measuredHeight = this.c.getMeasuredHeight();
            int i8 = (i7 - measuredWidth) / 2;
            ImageView imageView2 = this.c;
            int i9 = f3518a;
            imageView2.layout(i8, i9, measuredWidth + i8, measuredHeight + i9);
        }
        l lVar = this.e;
        int i10 = 0;
        if (lVar != null) {
            i10 = lVar.getMeasuredWidth();
            i6 = this.e.getMeasuredHeight();
            int i11 = (i7 - i10) / 2;
            l lVar2 = this.e;
            int i12 = this.f;
            lVar2.layout(i11, i12, i11 + i10, i12 + i6);
        } else {
            i6 = 0;
        }
        ImageView imageView3 = this.d;
        if (imageView3 != null) {
            int measuredWidth2 = imageView3.getMeasuredWidth();
            int measuredHeight2 = this.d.getMeasuredHeight();
            int i13 = (((i7 - i10) / 2) - this.g) - measuredWidth2;
            int i14 = this.f + ((i6 - measuredHeight2) / 2);
            this.d.layout(i13, i14, measuredWidth2 + i13, measuredHeight2 + i14);
        }
    }
}
