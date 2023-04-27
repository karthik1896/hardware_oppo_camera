package com.color.support.widget.floatingbutton;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Outline;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.a.f;
import color.support.v7.appcompat.R;
import com.color.support.d.k;
import com.color.support.widget.floatingbutton.ColorFloatingButton;
import com.color.support.widget.floatingbutton.ColorFloatingButtonItem;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.shape.ShapeAppearanceModel;

/* compiled from: ColorFloatingButtonLabel */
public class a extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private static final String f2191a = "a";
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public float f2192b;
    /* access modifiers changed from: private */
    public ValueAnimator c;
    private TextView d;
    private ShapeableImageView e;
    private androidx.cardview.a.a f;
    private boolean g;
    private ColorFloatingButtonItem h;
    /* access modifiers changed from: private */
    public ColorFloatingButton.a i;
    private float j;

    public a(Context context) {
        super(context);
        a(context, (AttributeSet) null);
    }

    @SuppressLint({"RestrictedApi"})
    public void setVisibility(int i2) {
        super.setVisibility(i2);
        getChildColorFloatingButton().setVisibility(i2);
        if (a()) {
            getColorFloatingButtonLabelBackground().setVisibility(i2);
        }
    }

    public void setOrientation(int i2) {
        super.setOrientation(i2);
        b();
        if (i2 == 1) {
            setLabelEnabled(false);
        } else {
            setLabel(this.d.getText().toString());
        }
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.d.setEnabled(z);
        this.e.setEnabled(z);
        this.f.setEnabled(z);
    }

    public boolean a() {
        return this.g;
    }

    private void setLabelEnabled(boolean z) {
        this.g = z;
        this.f.setVisibility(z ? 0 : 8);
    }

    public TextView getColorFloatingButtonLabelText() {
        return this.d;
    }

    public androidx.cardview.a.a getColorFloatingButtonLabelBackground() {
        return this.f;
    }

    public ImageView getChildColorFloatingButton() {
        return this.e;
    }

    public ColorFloatingButtonItem getColorFloatingButtonItem() {
        ColorFloatingButtonItem colorFloatingButtonItem = this.h;
        if (colorFloatingButtonItem != null) {
            return colorFloatingButtonItem;
        }
        throw new IllegalStateException("SpeedDialActionItem not set yet!");
    }

    public ColorFloatingButtonItem.a getColorFloatingButtonItemBuilder() {
        return new ColorFloatingButtonItem.a(getColorFloatingButtonItem());
    }

    public void setColorFloatingButtonItem(ColorFloatingButtonItem colorFloatingButtonItem) {
        this.h = colorFloatingButtonItem;
        setId(colorFloatingButtonItem.getColorFloatingButtonItemLocation());
        setLabel(colorFloatingButtonItem.getLabel(getContext()));
        getColorFloatingButtonItem();
        setFabIcon(colorFloatingButtonItem.getFabImageDrawable(getContext()));
        ColorStateList fabBackgroundColor = colorFloatingButtonItem.getFabBackgroundColor();
        if (fabBackgroundColor == ColorStateList.valueOf(Integer.MIN_VALUE)) {
            fabBackgroundColor = f.b(getResources(), R.color.color_floating_button_label_background_color, getContext().getTheme());
        }
        setFabBackgroundColor(fabBackgroundColor);
        ColorStateList labelColor = colorFloatingButtonItem.getLabelColor();
        if (labelColor == ColorStateList.valueOf(Integer.MIN_VALUE)) {
            labelColor = f.b(getResources(), R.color.color_floating_button_label_text_color, getContext().getTheme());
        }
        setLabelTextColor(labelColor);
        ColorStateList labelBackgroundColor = colorFloatingButtonItem.getLabelBackgroundColor();
        if (labelBackgroundColor == ColorStateList.valueOf(Integer.MIN_VALUE)) {
            labelBackgroundColor = f.b(getResources(), R.color.color_floating_button_label_background_color, getContext().getTheme());
        }
        setLabelBackgroundColor(labelBackgroundColor);
        if (colorFloatingButtonItem.isColorFloatingButtonExpandEnable()) {
            c();
        }
        getChildColorFloatingButton().setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                a.this.d();
            }
        });
    }

    public void setOnActionSelectedListener(ColorFloatingButton.a aVar) {
        this.i = aVar;
        if (this.i != null) {
            getColorFloatingButtonLabelBackground().setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    ColorFloatingButtonItem colorFloatingButtonItem = a.this.getColorFloatingButtonItem();
                    if (a.this.i != null && colorFloatingButtonItem != null) {
                        a.this.i.a(colorFloatingButtonItem);
                    }
                }
            });
            return;
        }
        getChildColorFloatingButton().setOnClickListener((View.OnClickListener) null);
        getColorFloatingButtonLabelBackground().setOnClickListener((View.OnClickListener) null);
    }

    private void a(Context context, AttributeSet attributeSet) {
        View inflate = inflate(context, R.layout.color_floating_button_item_label, this);
        this.e = (ShapeableImageView) inflate.findViewById(R.id.color_floating_button_child_fab);
        this.d = (TextView) inflate.findViewById(R.id.color_floating_button_label);
        this.f = (androidx.cardview.a.a) inflate.findViewById(R.id.color_floating_button_label_container);
        this.e.setElevation(24.0f);
        this.e.setOutlineProvider(new ViewOutlineProvider() {
            public void getOutline(View view, Outline outline) {
                outline.setAlpha(0.3f);
                outline.setOval(0, 0, view.getWidth(), view.getHeight());
            }
        });
        this.e.setShapeAppearanceModel(ShapeAppearanceModel.builder().setAllCornerSizes(ShapeAppearanceModel.PILL).build());
        this.f.setCardElevation(24.0f);
        this.f.setOutlineProvider(new ViewOutlineProvider() {
            public void getOutline(View view, Outline outline) {
                outline.setAlpha(0.3f);
                outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), (float) a.b(a.this.getContext(), 5.67f));
            }
        });
        setOrientation(0);
        setClipChildren(false);
        setClipToPadding(false);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ColorFloatingButtonLabel, 0, 0);
        try {
            int resourceId = obtainStyledAttributes.getResourceId(R.styleable.ColorFloatingButtonLabel_srcCompat, Integer.MIN_VALUE);
            if (resourceId == Integer.MIN_VALUE) {
                resourceId = obtainStyledAttributes.getResourceId(R.styleable.ColorFloatingButtonLabel_android_src, Integer.MIN_VALUE);
            }
            ColorFloatingButtonItem.a aVar = new ColorFloatingButtonItem.a(getId(), resourceId);
            aVar.a(obtainStyledAttributes.getString(R.styleable.ColorFloatingButtonLabel_fabLabel));
            aVar.a(ColorStateList.valueOf(obtainStyledAttributes.getColor(R.styleable.ColorFloatingButtonLabel_fabBackgroundColor, getResources().getColor(R.color.color_floating_button_label_background_color))));
            aVar.b(ColorStateList.valueOf(obtainStyledAttributes.getColor(R.styleable.ColorFloatingButtonLabel_fabLabelColor, Integer.MIN_VALUE)));
            aVar.c(ColorStateList.valueOf(obtainStyledAttributes.getColor(R.styleable.ColorFloatingButtonLabel_fabLabelBackgroundColor, Integer.MIN_VALUE)));
            setColorFloatingButtonItem(aVar.a());
        } catch (Exception e2) {
            String str = f2191a;
            Log.e(str, "Failure setting FabWithLabelView icon" + e2.getMessage());
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
        obtainStyledAttributes.recycle();
        setClipChildren(false);
    }

    private void b() {
        LinearLayout.LayoutParams layoutParams;
        int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.color_floating_button_fab_normal_size);
        getContext().getResources().getDimensionPixelSize(R.dimen.color_floating_button_fab_side_margin);
        getContext().getResources().getDimensionPixelSize(R.dimen.color_floating_button_item_normal_bottom_margin);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.e.getLayoutParams();
        if (getOrientation() == 0) {
            layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 8388613;
        } else {
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(dimensionPixelSize, -2);
            layoutParams3.gravity = 16;
            layoutParams2.setMargins(0, 0, 0, 0);
            layoutParams = layoutParams3;
        }
        setLayoutParams(layoutParams);
        this.e.setLayoutParams(layoutParams2);
    }

    private void setFabIcon(Drawable drawable) {
        this.e.setImageDrawable(drawable);
    }

    private void setLabel(CharSequence charSequence) {
        boolean z = false;
        if (!TextUtils.isEmpty(charSequence)) {
            this.d.setText(charSequence);
            if (getOrientation() == 0) {
                z = true;
            }
            setLabelEnabled(z);
            return;
        }
        setLabelEnabled(false);
    }

    private void setFabBackgroundColor(ColorStateList colorStateList) {
        this.e.setBackgroundTintList(colorStateList);
    }

    private void setLabelTextColor(ColorStateList colorStateList) {
        this.d.setTextColor(colorStateList);
    }

    private void setLabelBackgroundColor(ColorStateList colorStateList) {
        if (colorStateList == ColorStateList.valueOf(Integer.MIN_VALUE)) {
            this.f.setCardBackgroundColor(0);
            this.j = this.f.getElevation();
            this.f.setElevation(0.0f);
            return;
        }
        this.f.setCardBackgroundColor(colorStateList);
        float f2 = this.j;
        if (f2 != 0.0f) {
            this.f.setElevation(f2);
            this.j = 0.0f;
        }
    }

    private void c() {
        this.e.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int action = motionEvent.getAction();
                if (action == 0) {
                    a.this.e();
                    return false;
                } else if (action == 1) {
                    a.this.f();
                    return false;
                } else if (action != 3) {
                    return false;
                } else {
                    a.this.f();
                    return false;
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void d() {
        ColorFloatingButtonItem colorFloatingButtonItem = getColorFloatingButtonItem();
        ColorFloatingButton.a aVar = this.i;
        if (aVar != null && colorFloatingButtonItem != null) {
            aVar.a(colorFloatingButtonItem);
        }
    }

    /* access modifiers changed from: private */
    public void e() {
        clearAnimation();
        g();
        ScaleAnimation a2 = k.a(this.e);
        this.c = k.a();
        this.c.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float unused = a.this.f2192b = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (a.this.f2192b >= 0.98f) {
                    float unused2 = a.this.f2192b = 0.98f;
                }
            }
        });
        a2.setAnimationListener(new com.color.support.widget.slideselect.a() {
            public void onAnimationStart(Animation animation) {
                a.this.c.start();
            }
        });
        this.e.startAnimation(a2);
    }

    /* access modifiers changed from: private */
    public void f() {
        clearAnimation();
        g();
        ShapeableImageView shapeableImageView = this.e;
        shapeableImageView.startAnimation(k.a(shapeableImageView, this.f2192b));
    }

    private void g() {
        ValueAnimator valueAnimator = this.c;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.c.cancel();
        }
    }

    /* access modifiers changed from: private */
    public static int b(Context context, float f2) {
        return Math.round(TypedValue.applyDimension(1, f2, context.getResources().getDisplayMetrics()));
    }
}
