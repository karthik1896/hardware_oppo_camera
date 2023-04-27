package com.oppo.camera.j;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.RelativeLayout;
import com.oppo.camera.R;
import com.oppo.camera.professional.l;
import com.oppo.camera.ui.CommonComponent.SlideBar;
import com.oppo.camera.ui.menu.levelcontrol.c;
import com.oppo.camera.util.Util;

/* compiled from: FilmSlideBarContainer */
public class m extends RelativeLayout implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private SlideBar f3376a = null;

    /* renamed from: b  reason: collision with root package name */
    private l f3377b = null;
    private c c = null;
    private int d = 0;
    private boolean e = false;
    private a f = null;

    /* compiled from: FilmSlideBarContainer */
    public interface a {
        void c(boolean z);
    }

    public m(Context context) {
        super(context);
        a();
    }

    private void a() {
        this.c = new c(getContext());
        this.c.setEnabled(true);
        this.c.setFocusable(false);
        this.c.setClickable(true);
        this.c.setNormalShape(true);
        this.c.setContentDescription(getResources().getString(R.string.camera_description_professional_auto));
        this.c.setOnClickListener(this);
        Drawable drawable = getResources().getDrawable(R.drawable.icon_pro_auto);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.movie_mode_auto_button_width), getResources().getDimensionPixelSize(R.dimen.movie_mode_auto_button_height));
        layoutParams.addRule(9);
        layoutParams.addRule(15);
        this.c.setLayoutParams(layoutParams);
        this.c.a(270, false);
        this.c.setId(generateViewId());
        this.c.a(true, (String) null, drawable);
        this.c.setBaseShape(true);
        addView(this.c);
        this.f3377b = new l(getContext());
        this.f3377b.setIncludeFontPadding(false);
        this.f3377b.setTextSize(0, (float) getResources().getDimensionPixelSize(R.dimen.movie_mode_slide_value_text_size));
        this.f3377b.setTypeface(Util.j(getContext()));
        this.f3377b.setGravity(17);
        this.f3377b.setTextColor(getResources().getColor(R.color.main_item_title_text_color));
        this.f3377b.setRotation(90.0f);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.movie_mode_slide_bar_click_height), -2);
        layoutParams2.addRule(11);
        layoutParams2.addRule(15);
        this.f3377b.setLayoutParams(layoutParams2);
        this.f3377b.setId(generateViewId());
        this.f3376a = new SlideBar(getContext(), 0, true);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.movie_mode_slide_bar_width), getResources().getDimensionPixelSize(R.dimen.movie_mode_slide_bar_click_height));
        layoutParams3.addRule(1, this.c.getId());
        layoutParams3.addRule(15);
        this.f3376a.setAuto(false);
        this.f3376a.setAlign(2);
        layoutParams3.leftMargin = getResources().getDimensionPixelSize(R.dimen.movie_mode_auto_button_margin_right);
        addView(this.f3376a, layoutParams3);
        addView(this.f3377b);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.d == 0) {
            this.d = this.f3377b.getMeasuredWidth();
            if (this.d > 0) {
                int measuredHeight = this.f3377b.getMeasuredHeight();
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f3377b.getLayoutParams();
                layoutParams.rightMargin = -((this.d / 2) - (measuredHeight / 2));
                this.f3377b.setLayoutParams(layoutParams);
            }
        }
    }

    public void setValue(String str) {
        l lVar = this.f3377b;
        if (lVar != null) {
            this.d = 0;
            lVar.setText(str);
        }
    }

    public void a(int i, boolean z) {
        c cVar = this.c;
        if (cVar != null) {
            cVar.setVisibility(i);
            if (i == 0) {
                Drawable drawable = getResources().getDrawable(R.drawable.icon_pro_auto);
                if (z) {
                    drawable.setColorFilter(Util.s(getContext()), PorterDuff.Mode.SRC_ATOP);
                    this.c.a(true, (String) null, drawable);
                    this.e = true;
                } else {
                    drawable.setColorFilter(getResources().getColor(R.color.camera_white), PorterDuff.Mode.SRC_ATOP);
                    this.c.a(false, (String) null, drawable);
                    this.e = false;
                }
                SlideBar slideBar = this.f3376a;
                if (slideBar != null) {
                    slideBar.setAuto(this.e);
                }
            }
        }
    }

    public void setSlideNum(int i) {
        SlideBar slideBar = this.f3376a;
        if (slideBar != null) {
            slideBar.setLevelNum(i);
        }
    }

    public void setCurrentSlideIndex(int i) {
        SlideBar slideBar = this.f3376a;
        if (slideBar != null && slideBar.getCurrentIndex() != i) {
            this.f3376a.setCurrentIndex(i);
            this.f3376a.scrollTo(i);
        }
    }

    public int getCurrentSlideIndex() {
        SlideBar slideBar = this.f3376a;
        if (slideBar != null) {
            return slideBar.getCurrentIndex();
        }
        return -1;
    }

    public void setSlideBarValueChangeListener(SlideBar.SlideBarValueChangeListener slideBarValueChangeListener) {
        SlideBar slideBar = this.f3376a;
        if (slideBar != null) {
            slideBar.setSlideBarValueChangeListener(slideBarValueChangeListener);
        }
    }

    public boolean a(int i) {
        SlideBar slideBar = this.f3376a;
        return (slideBar == null || slideBar.getCurrentIndex() == i) ? false : true;
    }

    public void onClick(View view) {
        if (this.f != null) {
            a(0, !this.e);
            this.f.c(this.e);
        }
    }

    public void setSlideBarAutoListener(a aVar) {
        this.f = aVar;
    }
}
