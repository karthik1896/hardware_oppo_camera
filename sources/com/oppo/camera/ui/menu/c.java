package com.oppo.camera.ui.menu;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.widget.RelativeLayout;
import com.oppo.camera.R;
import com.oppo.camera.ui.RotateImageView;
import com.oppo.camera.ui.f;
import com.oppo.camera.ui.l;
import com.oppo.camera.ui.menu.BasicOptionItemList;
import com.oppo.camera.ui.menu.setting.CameraMenuOption;
import com.oppo.camera.util.Util;

/* compiled from: OptionItemIconTextList */
public class c extends BasicOptionItemList {
    private f A = null;
    /* access modifiers changed from: private */
    public RotateImageView x = null;
    private boolean y = false;
    private l z = null;

    public c(Context context, f fVar) {
        super(context);
        this.A = fVar;
    }

    public void a(View view, int i, int i2) {
        super.a(view, i, i2);
        if (view != null && this.r != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, Math.max(getItemsMeasureHeight(), a(this.m)));
            layoutParams.topMargin = i2;
            layoutParams.leftMargin = this.f4041b;
            this.r.addView(this, layoutParams);
        }
    }

    private int a(Context context) {
        if (context == null) {
            return 0;
        }
        return Util.u();
    }

    /* access modifiers changed from: protected */
    public void b() {
        this.s = new AnimationSet(true);
        this.s.addAnimation(new AlphaAnimation(0.0f, 1.0f));
        if (this.v == null) {
            this.v = new BasicOptionItemList.PopUpFadeInAnimationListener();
        }
        this.s.setAnimationListener(this.v);
        this.s.setDuration(240);
        this.s.setStartOffset(50);
        this.u = new AnimationSet(true);
        this.u.addAnimation(new AlphaAnimation(1.0f, 0.0f));
        if (this.w == null) {
            this.w = new BasicOptionItemList.PopUpFadeOutAnimationListener();
        }
        this.u.setAnimationListener(this.w);
        this.u.setDuration(200);
    }

    private void h() {
        if (this.z == null) {
            this.z = new l(1.0f, 0.0f);
            this.z.a((l.a) new a());
            this.z.setDuration(300);
        }
    }

    public boolean a(CameraMenuOption cameraMenuOption) {
        if (cameraMenuOption == null || this.n == null || this.n.contains(cameraMenuOption)) {
            return false;
        }
        cameraMenuOption.a((CameraMenuOption.OnItemClickListener) this.o);
        this.n.add(cameraMenuOption);
        cameraMenuOption.a((ViewGroup) this);
        return true;
    }

    public boolean a(CameraMenuOption cameraMenuOption, int i) {
        if (cameraMenuOption == null || this.n.contains(cameraMenuOption)) {
            return false;
        }
        if (i < 0) {
            i = 0;
        }
        if (i >= this.n.size()) {
            i = this.n.size();
        }
        this.n.add(i, cameraMenuOption);
        cameraMenuOption.a((CameraMenuOption.OnItemClickListener) this.o);
        cameraMenuOption.a((ViewGroup) this);
        return true;
    }

    public void d() {
        if (isShown()) {
            if (this.u == null) {
                b();
            }
            if (this.u == null) {
                return;
            }
            if (!this.u.hasStarted() || this.u.hasEnded()) {
                clearAnimation();
                startAnimation(this.u);
            }
        }
    }

    public void e() {
        clearAnimation();
        setVisibility(8);
        f.d(this.p.a());
    }

    public void setOptionItemIcon(Bitmap bitmap) {
        RotateImageView rotateImageView = this.x;
        if (rotateImageView != null) {
            rotateImageView.setImageBitmap(bitmap);
        }
    }

    public void setSelectItemIndex(int i) {
        if (i >= 0 && i != this.k) {
            this.k = i;
            if (this.n != null && this.n.size() > 0) {
                int i2 = 0;
                while (i2 < this.n.size()) {
                    CameraMenuOption cameraMenuOption = (CameraMenuOption) this.n.get(i2);
                    if (cameraMenuOption != null) {
                        cameraMenuOption.c(i2 == this.k);
                    }
                    i2++;
                }
            }
        }
    }

    public void a(int i, boolean z2) {
        if (!this.y) {
            i = 0;
        }
        if (this.z == null) {
            h();
        }
        if (z2 && isShown() && !this.z.b() && this.z.a() != i) {
            startAnimation(this.z);
        }
        this.z.a(i, z2);
    }

    public int getItemsMeasureWidth() {
        int i = 0;
        if (this.n == null || this.n.size() <= 0) {
            return 0;
        }
        for (CameraMenuOption cameraMenuOption : this.n) {
            if (cameraMenuOption != null) {
                i += cameraMenuOption.x();
            }
        }
        RotateImageView rotateImageView = this.x;
        return rotateImageView != null ? i + rotateImageView.getMeasuredWidth() : i;
    }

    public int getItemsMeasureHeight() {
        int y2;
        int i = 0;
        if (this.n == null || this.n.size() <= 0) {
            return 0;
        }
        for (CameraMenuOption cameraMenuOption : this.n) {
            if (cameraMenuOption != null && i <= (y2 = cameraMenuOption.y())) {
                i = y2;
            }
        }
        RotateImageView rotateImageView = this.x;
        return (rotateImageView == null || i > rotateImageView.getMeasuredHeight()) ? i : this.x.getMeasuredHeight();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        try {
            super.onMeasure(i, i2);
            if (this.x != null) {
                this.x.measure(Util.E(), Util.D());
            }
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i, int i2, int i3, int i4) {
        if (this.n != null && this.n.size() > 0) {
            int i5 = i4 - i2;
            int itemsMeasureWidth = ((((i3 - i) - 0) - this.d) - getItemsMeasureWidth()) / (this.n.size() - 1);
            int i6 = 0;
            for (int i7 = 0; i7 < this.n.size(); i7++) {
                CameraMenuOption cameraMenuOption = (CameraMenuOption) this.n.get(i7);
                if (cameraMenuOption != null) {
                    int x2 = cameraMenuOption.x();
                    int y2 = cameraMenuOption.y();
                    int i8 = (i5 - y2) / 2;
                    if (Util.Q()) {
                        i8 += this.m.getResources().getDimensionPixelSize(R.dimen.ear_screen_menu_item_offset);
                    }
                    cameraMenuOption.a(i6, i8, i6 + x2, y2 + i8);
                    i6 += x2 + itemsMeasureWidth;
                }
            }
        }
    }

    public void g() {
        RotateImageView rotateImageView = this.x;
        if (rotateImageView != null) {
            removeView(rotateImageView);
            this.x = null;
        }
        this.z = null;
        super.g();
    }

    /* compiled from: OptionItemIconTextList */
    private class a implements l.a {
        private a() {
        }

        public void a(float f) {
            if (c.this.x != null) {
                c.this.x.setAlpha(f);
            }
            if (c.this.n != null && c.this.n.size() > 0) {
                for (int i = 0; i < c.this.n.size(); i++) {
                    CameraMenuOption cameraMenuOption = (CameraMenuOption) c.this.n.get(i);
                    if (cameraMenuOption != null) {
                        cameraMenuOption.a(f);
                    }
                }
            }
        }

        public void a(int i) {
            if (c.this.x != null) {
                c.this.x.a(i, false);
            }
            if (c.this.n != null && c.this.n.size() > 0) {
                for (int i2 = 0; i2 < c.this.n.size(); i2++) {
                    CameraMenuOption cameraMenuOption = (CameraMenuOption) c.this.n.get(i2);
                    if (cameraMenuOption != null) {
                        cameraMenuOption.a(i, false);
                    }
                }
            }
            c cVar = c.this;
            cVar.l = i;
            cVar.requestLayout();
        }

        public boolean a() {
            return c.this.isShown();
        }
    }
}
