package com.oppo.camera.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.oppo.camera.R;
import com.oppo.camera.e;

public class SwitchCameraBar extends RelativeLayout implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private Context f3816a;

    /* renamed from: b  reason: collision with root package name */
    private String f3817b;
    private RotateImageView c;
    private RotateImageView d;
    private RotateImageView e;
    private ImageView f;
    private a g;
    /* access modifiers changed from: private */
    public int h;

    public interface a {
        void a(String str);

        boolean a();
    }

    public SwitchCameraBar(Context context) {
        this(context, (AttributeSet) null);
    }

    public SwitchCameraBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SwitchCameraBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f3816a = null;
        this.f3817b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = 0;
        this.h = getResources().getDimensionPixelSize(R.dimen.switch_camera_bar_margin_left);
        this.f3816a = context;
    }

    public void a(String str, boolean z) {
        e.a("SwitchCameraBar", "init, selectValue: " + str);
        this.c = (RotateImageView) findViewById(R.id.switch_ultra_wide);
        this.d = (RotateImageView) findViewById(R.id.switch_main);
        this.e = (RotateImageView) findViewById(R.id.switch_tele);
        this.e.setVisibility(z ? 0 : 8);
        this.c.setOnClickListener(this);
        this.d.setOnClickListener(this);
        this.e.setOnClickListener(this);
        setSelectValue(str);
        setSelectBg(str);
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            public void onGlobalLayout() {
                if (SwitchCameraBar.this.getLayoutParams() != null && SwitchCameraBar.this.getVisibility() == 0 && SwitchCameraBar.this.getWidth() > 0) {
                    SwitchCameraBar.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) SwitchCameraBar.this.getLayoutParams();
                    marginLayoutParams.leftMargin = SwitchCameraBar.this.h - ((SwitchCameraBar.this.getWidth() / 2) - (SwitchCameraBar.this.getHeight() / 2));
                    SwitchCameraBar.this.setLayoutParams(marginLayoutParams);
                }
            }
        });
    }

    public void setSelectValue(String str) {
        e.a("SwitchCameraBar", "setSelectValue, value: " + str);
        this.f3817b = str;
    }

    public String getSelectValue() {
        return this.f3817b;
    }

    public void setSelectBg(String str) {
        RelativeLayout.LayoutParams layoutParams;
        if (str.equals("camera_main")) {
            layoutParams = (RelativeLayout.LayoutParams) this.d.getLayoutParams();
        } else if (str.equals("camera_ultra_wide")) {
            layoutParams = (RelativeLayout.LayoutParams) this.c.getLayoutParams();
        } else {
            layoutParams = (RelativeLayout.LayoutParams) this.e.getLayoutParams();
        }
        ImageView imageView = this.f;
        if (imageView != null) {
            removeView(imageView);
        }
        this.f = new ImageView(this.f3816a);
        this.f.setBackgroundResource(R.drawable.switch_camera_highlight_bg);
        this.f.setLayoutParams(new RelativeLayout.LayoutParams(layoutParams));
        this.f.animate().setDuration(300).setInterpolator(AnimationUtils.loadInterpolator(this.f3816a, R.anim.accelerate_decelerate_path_interpolator));
        addView(this.f, 0);
    }

    public void setClickListener(a aVar) {
        this.g = aVar;
    }

    private void a(float f2) {
        this.f.animate().cancel();
        this.f.animate().x(f2).start();
    }

    public void onClick(View view) {
        e.a("SwitchCameraBar", "onClick");
        a aVar = this.g;
        if (aVar != null && aVar.a()) {
            switch (view.getId()) {
                case R.id.switch_main:
                    setSelectValue("camera_main");
                    a(this.d.getX());
                    this.g.a("camera_main");
                    return;
                case R.id.switch_tele:
                    setSelectValue("camera_tele");
                    a(this.e.getX());
                    this.g.a("camera_tele");
                    return;
                case R.id.switch_ultra_wide:
                    setSelectValue("camera_ultra_wide");
                    a(this.c.getX());
                    this.g.a("camera_ultra_wide");
                    return;
                default:
                    return;
            }
        }
    }
}
