package com.color.support.widget.navigation;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.view.menu.o;
import androidx.appcompat.widget.at;
import androidx.core.g.b.b;
import androidx.core.g.s;
import androidx.core.g.v;
import color.support.v7.appcompat.R;
import com.color.support.d.h;
import com.color.support.widget.ColorHintRedDot;
import com.crunchfish.touchless_a3d.TouchlessA3D;

/* compiled from: ColorNavigationItemView */
public class a extends FrameLayout implements o.a {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f2235a = {16842912};

    /* renamed from: b  reason: collision with root package name */
    private final float f2236b;
    private final float c;
    private final float d;
    private final float e;
    private final TextView f;
    private int g;
    private ImageView h;
    private j i;
    private ColorStateList j;
    private ColorStateList k;
    /* access modifiers changed from: private */
    public ColorHintRedDot l;
    private ScaleAnimation m;

    public boolean prefersCondensedTitle() {
        return false;
    }

    public a(Context context) {
        this(context, (AttributeSet) null);
    }

    public a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public a(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f2236b = 0.0f;
        this.c = 1.0f;
        this.d = 0.3f;
        this.e = 0.5f;
        this.g = -1;
        View inflate = LayoutInflater.from(context).inflate(h.a(context) ? R.layout.color_navigation_item_layout : R.layout.color_navigation_item_layout_land, this, true);
        this.h = (ImageView) inflate.findViewById(R.id.icon);
        this.f = (TextView) inflate.findViewById(R.id.normalLable);
        this.l = (ColorHintRedDot) inflate.findViewById(R.id.tips);
        setWillNotDraw(false);
    }

    public void initialize(j jVar, int i2) {
        this.i = jVar;
        setCheckable(jVar.isCheckable());
        setChecked(jVar.isChecked());
        setEnabled(jVar.isEnabled());
        setIcon(jVar.getIcon());
        setTitle(jVar.getTitle());
        setId(jVar.getItemId());
        if (Build.VERSION.SDK_INT >= 26) {
            setContentDescription(jVar.getContentDescription());
            at.a(this, jVar.getTooltipText());
        }
    }

    public void setItemPosition(int i2) {
        this.g = i2;
    }

    public int getItemPosition() {
        return this.g;
    }

    public j getItemData() {
        return this.i;
    }

    public void setTitle(CharSequence charSequence) {
        if (charSequence == null || charSequence.toString().isEmpty()) {
            this.f.setVisibility(8);
            return;
        }
        this.f.setVisibility(0);
        this.f.setText(charSequence);
    }

    public void setCheckable(boolean z) {
        refreshDrawableState();
    }

    public void setChecked(boolean z) {
        refreshDrawableState();
        this.h.setSelected(z);
        this.f.setSelected(z);
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.h.setEnabled(z);
        this.f.setEnabled(z);
        if (z) {
            v.a((View) this, s.a(getContext(), TouchlessA3D.Parameters.EXTENDED_RANGE));
        } else {
            v.a((View) this, (s) null);
        }
    }

    public int[] onCreateDrawableState(int i2) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i2 + 1);
        j jVar = this.i;
        if (jVar != null && jVar.isCheckable() && this.i.isChecked()) {
            mergeDrawableStates(onCreateDrawableState, f2235a);
        }
        return onCreateDrawableState;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        a();
    }

    private void a() {
        int left = a(getContext()) ? this.h.getLeft() - (this.l.getWidth() / 2) : (this.h.getLeft() - (this.l.getWidth() / 2)) + this.h.getWidth();
        int top = this.h.getTop() - (this.l.getHeight() / 2);
        this.l.setX((float) left);
        this.l.setY((float) top);
    }

    public void setIcon(Drawable drawable) {
        if (drawable != null) {
            this.h.setVisibility(0);
            if (Build.VERSION.SDK_INT >= 21 ? drawable instanceof StateListDrawable : false) {
                int[] iArr = new int[1];
                iArr[0] = (this.i.isChecked() ? 1 : -1) * 16842912;
                this.h.setImageState(iArr, true);
            }
        } else {
            this.h.setVisibility(8);
            this.f.setMaxLines(2);
        }
        this.h.setImageDrawable(drawable);
    }

    @Deprecated
    public void setIconTintList(ColorStateList colorStateList) {
        this.j = colorStateList;
        j jVar = this.i;
        if (jVar != null) {
            setIcon(jVar.getIcon());
        }
    }

    public void setTextColor(ColorStateList colorStateList) {
        if (colorStateList != null) {
            this.k = colorStateList;
            this.f.setTextColor(colorStateList);
        }
    }

    public void setTextSize(int i2) {
        this.f.setTextSize(0, (float) i2);
    }

    public void setItemBackground(int i2) {
        v.a((View) this, i2 == 0 ? null : androidx.core.content.a.a(getContext(), i2));
    }

    public void setMaxTextWidth(int i2) {
        if (i2 > 0) {
            this.f.setMaxWidth(i2);
        }
    }

    public TextView getTextView() {
        return this.f;
    }

    public void a(int i2, int i3) {
        if (i3 >= 0) {
            if (i3 == 3) {
                if (this.l.getVisibility() != 8) {
                    if (this.m == null) {
                        b();
                    }
                    this.l.startAnimation(this.m);
                }
            } else if (i3 == 1) {
                this.l.setPointMode(1);
                this.l.setVisibility(0);
            } else if (i3 == 2) {
                this.l.setPointNumber(i2);
                this.l.setPointMode(2);
                this.l.setVisibility(0);
            }
        }
    }

    private void b() {
        this.m = new ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f, 1, 0.5f, 1, 0.5f);
        this.m.setDuration(400);
        if (Build.VERSION.SDK_INT > 21) {
            this.m.setInterpolator(b.a(1.0f, 0.4f, 0.0f, 0.0f));
        }
        this.m.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
            }

            public void onAnimationEnd(Animation animation) {
                a.this.l.setVisibility(8);
            }
        });
    }

    private boolean a(Context context) {
        if (context != null && Build.VERSION.SDK_INT > 16 && context.getResources().getConfiguration().getLayoutDirection() == 1) {
            return true;
        }
        return false;
    }
}
