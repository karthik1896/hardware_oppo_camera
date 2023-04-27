package com.oppo.camera.ui.menu.levelcontrol;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.view.KeyEvent;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import com.oppo.camera.R;
import com.oppo.camera.util.Util;

/* compiled from: CameraImageButton */
public class c extends ImageView {

    /* renamed from: a  reason: collision with root package name */
    private Paint f4135a;

    /* renamed from: b  reason: collision with root package name */
    private Drawable f4136b = null;
    private Drawable c = null;
    private Drawable d = null;
    private int e = 0;
    private String f = "";
    private int g = 0;
    private int h = 0;
    private int i = 0;
    private long j = 0;
    private long k = 0;
    private float l = 0.0f;
    private boolean m = false;
    private boolean n = false;
    private boolean o = false;

    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        return false;
    }

    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        return false;
    }

    public void setNormalShape(boolean z) {
        this.n = z;
    }

    public void setBaseShape(boolean z) {
        this.o = z;
    }

    public c(Context context) {
        super(context);
        a();
    }

    private void a() {
        Resources resources = getContext().getResources();
        this.l = (float) ((resources.getDimensionPixelSize(R.dimen.level_pop_text_circle_diameter) / 2) + resources.getDimensionPixelSize(R.dimen.level_pop_text_circle_margin_right));
    }

    private void a(String str) {
        if (str != null) {
            if (this.f4135a == null) {
                Resources resources = getContext().getResources();
                this.f4135a = new Paint(1);
                this.f4135a.setTextSize((float) resources.getDimensionPixelSize(R.dimen.menu_tool_item_text_size));
                this.f4135a.setColor(-1);
                this.f4135a.setShadowLayer((float) resources.getDimensionPixelSize(R.dimen.level_pop_text_shadow_radius), 0.0f, (float) resources.getDimensionPixelSize(R.dimen.level_pop_text_shadow_offset_y), resources.getColor(R.color.level_pop_text_shadow_color));
                this.f4135a.setTypeface(Util.j(getContext()));
            }
            this.f = str;
        }
    }

    public void a(boolean z, String str, Drawable drawable) {
        if (z) {
            a(str);
            this.f4136b = drawable;
            this.e = 0;
        } else {
            if (drawable != null) {
                this.c = drawable;
            }
            this.e = 1;
        }
        invalidate();
    }

    public void setPopdownButtonImage(Drawable drawable) {
        if (this.d == null) {
            this.d = drawable;
        }
        this.e = 2;
        invalidate();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        Drawable drawable;
        super.onDraw(canvas);
        int i2 = this.e;
        if (i2 == 0) {
            b();
            canvas.rotate((float) (-this.g), this.n ? (float) (getWidth() / 2) : ((float) getWidth()) - this.l, this.n ? (float) (getHeight() / 2) : ((float) getHeight()) - this.l);
            Drawable drawable2 = this.f4136b;
            if (drawable2 != null) {
                if (this.o) {
                    int width = (getWidth() - this.f4136b.getIntrinsicWidth()) / 2;
                    int height = (getHeight() - this.f4136b.getIntrinsicHeight()) / 2;
                    Drawable drawable3 = this.f4136b;
                    drawable3.setBounds(width, height, drawable3.getIntrinsicWidth() + width, this.f4136b.getIntrinsicWidth() + height);
                } else {
                    drawable2.setBounds(0, 0, getWidth(), getHeight());
                }
                this.f4136b.draw(canvas);
            }
            if (this.f4135a != null) {
                canvas.drawText(this.f, ((float) getWidth()) - (this.l + (this.f4135a.measureText(this.f) / 2.0f)), (((float) getHeight()) - this.l) + ((Math.abs(this.f4135a.ascent()) - this.f4135a.descent()) / 2.0f), this.f4135a);
            }
        } else if (i2 == 1) {
            b();
            canvas.rotate((float) (-this.g), this.n ? (float) (getWidth() / 2) : ((float) getWidth()) - this.l, this.n ? (float) (getHeight() / 2) : ((float) getHeight()) - this.l);
            Drawable drawable4 = this.c;
            if (drawable4 != null) {
                if (this.o) {
                    int width2 = (getWidth() - this.f4136b.getIntrinsicWidth()) / 2;
                    int height2 = (getHeight() - this.f4136b.getIntrinsicHeight()) / 2;
                    Drawable drawable5 = this.c;
                    drawable5.setBounds(width2, height2, drawable5.getIntrinsicWidth() + width2, this.c.getIntrinsicWidth() + height2);
                } else {
                    drawable4.setBounds(0, 0, getWidth(), getHeight());
                }
                this.c.draw(canvas);
            }
        } else if (i2 == 2 && (drawable = this.d) != null) {
            if (this.o) {
                int width3 = (getWidth() - this.f4136b.getIntrinsicWidth()) / 2;
                int height3 = (getHeight() - this.f4136b.getIntrinsicHeight()) / 2;
                Drawable drawable6 = this.d;
                drawable6.setBounds(width3, height3, drawable6.getIntrinsicWidth() + width3, this.d.getIntrinsicWidth() + height3);
            } else {
                drawable.setBounds(0, 0, getWidth(), getHeight());
            }
            this.d.draw(canvas);
        }
    }

    private void b() {
        if (this.g != this.i) {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            if (currentAnimationTimeMillis < this.k) {
                int i2 = (int) (currentAnimationTimeMillis - this.j);
                int i3 = this.h;
                if (!this.m) {
                    i2 = -i2;
                }
                int i4 = i3 + ((i2 * 360) / 1000);
                this.g = i4 >= 0 ? i4 % 360 : (i4 % 360) + 360;
                invalidate();
                return;
            }
            this.g = this.i;
        }
    }

    public void a(int i2, boolean z) {
        boolean z2 = false;
        if (this.e == 2) {
            z = false;
        }
        int i3 = i2 >= 0 ? i2 % 360 : (i2 % 360) + 360;
        if (i3 != this.i) {
            this.i = i3;
            if (z) {
                this.h = this.g;
                this.j = AnimationUtils.currentAnimationTimeMillis();
                int i4 = this.i - this.g;
                if (i4 < 0) {
                    i4 += 360;
                }
                if (i4 > 180) {
                    i4 -= 360;
                }
                if (i4 >= 0) {
                    z2 = true;
                }
                this.m = z2;
                this.k = this.j + ((long) ((Math.abs(i4) * 1000) / 360));
                invalidate();
                return;
            }
            this.g = this.i;
        }
    }
}
