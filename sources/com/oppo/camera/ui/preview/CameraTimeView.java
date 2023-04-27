package com.oppo.camera.ui.preview;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Size;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.LayoutAnimationController;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.oppo.camera.R;
import com.oppo.camera.e;
import com.oppo.camera.ui.inverse.InverseImageView;
import com.oppo.camera.ui.inverse.InverseTextView;
import com.oppo.camera.ui.inverse.c;
import com.oppo.camera.util.Util;
import java.util.Locale;

public class CameraTimeView extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private int f4328a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public boolean f4329b;
    private ImageView c;
    private InverseTextView d;
    private InverseTextView e;
    private InverseImageView f;
    private InverseImageView g;
    private InverseTextView h;
    private InverseTextView i;
    private InverseTextView j;
    private InverseTextView k;
    private View l;
    private int m;
    private int n;
    private int o;
    private int p;
    private int q;
    private boolean r;
    private boolean s;
    private a t;

    public interface a {
        void a(int i);
    }

    public CameraTimeView(Context context) {
        this(context, (AttributeSet) null);
    }

    public CameraTimeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CameraTimeView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f4328a = 0;
        this.f4329b = false;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = 0;
        this.n = 0;
        this.o = 0;
        this.p = 0;
        this.q = 0;
        this.r = false;
        this.s = false;
        this.t = null;
    }

    public void a(boolean z, int i2, int i3, int i4, int i5) {
        this.m = i2;
        this.n = i3;
        this.o = i4;
        this.p = i5;
        this.r = z;
        this.q = getResources().getDimensionPixelSize(R.dimen.camera_time_view_horizontal_margin);
        float dimensionPixelSize = (float) getResources().getDimensionPixelSize(R.dimen.camera_time_split_shadow_radius_size);
        float dimensionPixelSize2 = (float) getResources().getDimensionPixelSize(R.dimen.camera_time_split_shadow_dx);
        float dimensionPixelSize3 = (float) getResources().getDimensionPixelSize(R.dimen.camera_time_split_shadow_dy);
        int color2 = getResources().getColor(R.color.inertial_bar_shadow_color);
        this.c = (ImageView) findViewById(R.id.blink_record_icon);
        this.d = (InverseTextView) findViewById(R.id.video_hour_ten);
        this.e = (InverseTextView) findViewById(R.id.video_hour_unit);
        this.h = (InverseTextView) findViewById(R.id.video_minute_ten);
        this.i = (InverseTextView) findViewById(R.id.video_minute_unit);
        this.f = (InverseImageView) findViewById(R.id.video_colon);
        this.g = (InverseImageView) findViewById(R.id.video_colon_second);
        this.j = (InverseTextView) findViewById(R.id.video_second_ten);
        this.k = (InverseTextView) findViewById(R.id.video_second_unit);
        this.d.setHorizontalInverseAble(false);
        this.e.setHorizontalInverseAble(false);
        this.h.setHorizontalInverseAble(false);
        this.i.setHorizontalInverseAble(false);
        this.f.setHorizontalInverseAble(false);
        this.g.setHorizontalInverseAble(false);
        this.j.setHorizontalInverseAble(false);
        this.k.setHorizontalInverseAble(false);
        this.d.setShadowLayer(dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize3, color2);
        this.e.setShadowLayer(dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize3, color2);
        this.h.setShadowLayer(dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize3, color2);
        this.i.setShadowLayer(dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize3, color2);
        this.j.setShadowLayer(dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize3, color2);
        this.k.setShadowLayer(dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize3, color2);
        this.d.setTypeface(Util.b(false));
        this.e.setTypeface(Util.b(false));
        this.h.setTypeface(Util.b(false));
        this.i.setTypeface(Util.b(false));
        this.j.setTypeface(Util.b(false));
        this.k.setTypeface(Util.b(false));
        if (this.r) {
            this.l = findViewById(R.id.record_split_view);
            this.l.setVisibility(0);
            this.c.setVisibility(8);
            this.c = null;
        }
    }

    public void a() {
        c.INS.unRegisterInverse(getContext(), this.d);
        c.INS.unRegisterInverse(getContext(), this.e);
        c.INS.unRegisterInverse(getContext(), this.h);
        c.INS.unRegisterInverse(getContext(), this.i);
        c.INS.unRegisterInverse(getContext(), this.f);
        c.INS.unRegisterInverse(getContext(), this.g);
        c.INS.unRegisterInverse(getContext(), this.j);
        c.INS.unRegisterInverse(getContext(), this.k);
    }

    public void a(int i2) {
        this.p = i2;
        d();
    }

    public void a(int i2, int i3, int i4, boolean z) {
        e.a("CameraTimeView", "showTimeUI");
        if (z) {
            this.q = i3;
        } else {
            this.q = getResources().getDimensionPixelSize(R.dimen.camera_time_view_horizontal_margin);
        }
        this.s = z;
        this.f4328a = i4;
        c();
        this.m = i2;
        d();
        setVisibility(0);
        clearAnimation();
        this.f4329b = true;
        LayoutAnimationController layoutAnimationController = new LayoutAnimationController(a(0.1f, 1.0f));
        layoutAnimationController.setDelay(0.0f);
        layoutAnimationController.setOrder(0);
        setLayoutAnimation(layoutAnimationController);
        startLayoutAnimation();
    }

    private void c() {
        this.d.setOrientation(this.f4328a);
        this.e.setOrientation(this.f4328a);
        this.h.setOrientation(this.f4328a);
        this.i.setOrientation(this.f4328a);
        this.f.setOrientation(this.f4328a);
        this.g.setOrientation(this.f4328a);
        this.j.setOrientation(this.f4328a);
        this.k.setOrientation(this.f4328a);
    }

    public void a(boolean z, boolean z2) {
        e.e("CameraTimeView", "hideTimeUI");
        if (8 == getVisibility()) {
            e.b("CameraTimeView", "hideTimeUI, return");
            return;
        }
        this.s = z2;
        this.f4329b = false;
        clearAnimation();
        this.f4329b = true;
        if (z) {
            AnonymousClass1 r4 = new Animation.AnimationListener() {
                public void onAnimationRepeat(Animation animation) {
                }

                public void onAnimationStart(Animation animation) {
                    e.a("CameraTimeView", "hideTimeUI, onAnimationStart");
                }

                public void onAnimationEnd(Animation animation) {
                    boolean unused = CameraTimeView.this.f4329b = false;
                    e.a("CameraTimeView", "hideTimeUI, onAnimationEnd");
                }
            };
            AnimationSet a2 = a(1.0f, 0.0f);
            a2.setDuration(100);
            a2.setAnimationListener(r4);
            startAnimation(a2);
            setVisibility(8);
            return;
        }
        setVisibility(8);
        this.f4329b = false;
        e.a("CameraTimeView", "hideTimeUI, without Animation");
    }

    public void setVisibility(int i2) {
        super.setVisibility(i2);
        if (8 == i2) {
            this.f4329b = false;
        }
    }

    public int getBlinkRecordIconWidth() {
        ImageView imageView = this.c;
        if (imageView != null) {
            return a((View) imageView).getWidth();
        }
        return 0;
    }

    private Size a(View view) {
        view.measure(Util.E(), Util.E());
        return new Size(view.getMeasuredWidth(), view.getMeasuredHeight());
    }

    private void d() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        Size a2 = a((View) this);
        ImageView imageView = this.c;
        int i2 = 0;
        int blinkRecordIconWidth = (getBlinkRecordIconWidth() + (imageView != null ? ((LinearLayout.LayoutParams) imageView.getLayoutParams()).rightMargin : 0)) / 2;
        if (this.s) {
            this.f4328a = 270;
        }
        int i3 = this.f4328a;
        int i4 = 11;
        if (i3 == 90) {
            layoutParams.addRule(10);
            if (this.s) {
                i4 = 9;
            }
            layoutParams.addRule(i4);
            layoutParams.topMargin = (((this.n + (this.o / 2)) + blinkRecordIconWidth) - (a2.getHeight() / 2)) - this.p;
            layoutParams.rightMargin = this.q - (a2.getWidth() / 2);
            i2 = 90;
        } else if (i3 == 180) {
            layoutParams.addRule(9);
            layoutParams.addRule(10);
            layoutParams.leftMargin = ((Util.E() / 2) - (a2.getWidth() / 2)) + this.p + blinkRecordIconWidth;
            layoutParams.topMargin = this.m;
            i2 = 180;
        } else if (i3 != 270) {
            layoutParams.addRule(9);
            layoutParams.addRule(10);
            layoutParams.leftMargin = (((Util.E() / 2) - (a2.getWidth() / 2)) + this.p) - blinkRecordIconWidth;
            layoutParams.topMargin = this.m;
        } else {
            if (!this.s) {
                i4 = 9;
            }
            layoutParams.addRule(i4);
            layoutParams.addRule(10);
            layoutParams.topMargin = (((this.n + (this.o / 2)) - blinkRecordIconWidth) - (a2.getHeight() / 2)) + this.p;
            if (this.s) {
                layoutParams.rightMargin = this.q - (a2.getWidth() / 2);
            } else {
                layoutParams.leftMargin = this.q - (a2.getWidth() / 2);
            }
            i2 = 270;
        }
        setLayoutParams(layoutParams);
        setRotation((float) (-i2));
    }

    private AnimationSet a(float f2, float f3) {
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(new AlphaAnimation(f2, f3));
        animationSet.setDuration(300);
        return animationSet;
    }

    public void a(boolean z) {
        ImageView imageView = this.c;
        if (imageView == null) {
            return;
        }
        if (z) {
            imageView.setImageResource(R.drawable.ic_recording_indicator);
        } else {
            imageView.setVisibility(4);
        }
    }

    public void a(long j2, boolean z) {
        a(j2, z, false);
    }

    public void a(long j2, boolean z, boolean z2) {
        if (j2 < 0) {
            e.e("CameraTimeView", "updateRecordingTime: parameter is invalid");
            return;
        }
        b(j2, z2);
        ImageView imageView = this.c;
        if (imageView != null) {
            imageView.setVisibility(z ? 0 : 4);
        }
    }

    private void b(long j2, boolean z) {
        int i2;
        if (this.d == null || this.e == null || this.f == null || this.h == null || this.i == null || this.j == null || this.k == null) {
            e.e("CameraTimeView", "updateNormalRecordTimeView: parameter is invalid");
            return;
        }
        if (2000 <= j2 && 3000 >= j2) {
            com.oppo.camera.perf.a.b("start_video_record");
        }
        int i3 = (int) (j2 / 3600000);
        int i4 = (int) ((j2 % 3600000) / 60000);
        if (z) {
            i2 = (int) Math.ceil((double) (((float) (j2 % 60000)) / 1000.0f));
        } else {
            i2 = (int) ((j2 % 60000) / 1000);
        }
        if (i3 > 0) {
            this.d.setText(Util.j(i3 / 10));
            this.e.setText(Util.j(i3 % 10));
            e();
            a aVar = this.t;
            if (aVar != null) {
                aVar.a(getWidth());
            }
        } else {
            f();
        }
        this.h.setText(Util.j(i4 / 10));
        this.i.setText(Util.j(i4 % 10));
        this.j.setText(Util.j(i2 / 10));
        this.k.setText(Util.j(i2 % 10));
        e.a("CameraTimeView", String.format(Locale.getDefault(), "updateNormalRecordTimeView, time: %d:%d:%d, setText done.", new Object[]{Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i2)}));
    }

    private void e() {
        InverseTextView inverseTextView;
        InverseImageView inverseImageView;
        InverseTextView inverseTextView2 = this.d;
        if (inverseTextView2 != null && inverseTextView2.getVisibility() != 0 && (inverseTextView = this.e) != null && inverseTextView.getVisibility() != 0 && (inverseImageView = this.f) != null && inverseImageView.getVisibility() != 0) {
            this.d.setVisibility(0);
            this.e.setVisibility(0);
            this.f.setVisibility(0);
            d();
        }
    }

    private void f() {
        InverseTextView inverseTextView = this.d;
        if (inverseTextView != null) {
            inverseTextView.setVisibility(8);
        }
        InverseTextView inverseTextView2 = this.e;
        if (inverseTextView2 != null) {
            inverseTextView2.setVisibility(8);
        }
        InverseImageView inverseImageView = this.f;
        if (inverseImageView != null) {
            inverseImageView.setVisibility(8);
        }
    }

    public void setCameraTimeListener(a aVar) {
        this.t = aVar;
    }

    public boolean b() {
        return this.f4329b && getVisibility() == 0;
    }
}
