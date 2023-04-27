package com.oppo.camera.ui.menu;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BlendMode;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.MotionEvent;
import android.widget.TextView;
import com.oppo.camera.R;
import com.oppo.camera.ui.f;
import com.oppo.camera.ui.inverse.a;
import com.oppo.camera.util.Util;

/* compiled from: SingleTextItemView */
public class i extends TextView implements a {
    private boolean A = true;

    /* renamed from: a  reason: collision with root package name */
    protected f f4104a = null;

    /* renamed from: b  reason: collision with root package name */
    private final BlurMaskFilter f4105b;
    private boolean c = false;
    private boolean d = false;
    private boolean e = false;
    private boolean f = false;
    private boolean g = true;
    private boolean h = false;
    private boolean i = false;
    private boolean j = false;
    private boolean k = false;
    private int l = 0;
    private int m = 0;
    private int n = 0;
    private int o = 0;
    private int p = 0;
    private int q = 0;
    private int r = 0;
    private int s = 17;
    private int t = 0;
    private Drawable u = null;
    private Bitmap v = null;
    private Canvas w = null;
    private String x;
    private String y;
    private Context z = null;

    public i(Context context, f fVar) {
        super(context);
        this.z = context;
        this.f4104a = fVar;
        this.n = this.z.getResources().getDimensionPixelSize(R.dimen.menu_option_item_width);
        if (!Util.Q()) {
            this.t = this.z.getResources().getDimensionPixelSize(R.dimen.setting_menu_move_down_y);
        }
        this.f4105b = new BlurMaskFilter(4.0f, BlurMaskFilter.Blur.SOLID);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int actionMasked;
        f fVar = this.f4104a;
        if (fVar == null || !fVar.i() || (actionMasked = motionEvent.getActionMasked()) == 3 || actionMasked == 2) {
            return super.dispatchTouchEvent(motionEvent);
        }
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        obtain.setAction(3);
        super.dispatchTouchEvent(obtain);
        return false;
    }

    public int getViewWidth() {
        if (this.l <= 0 || this.g || this.e) {
            if (this.q == 0 || this.r == 0 || this.h) {
                measure(Util.E(), Util.D());
                this.h = false;
            }
            if (this.e && this.p % 180 != 0) {
                int i2 = this.q;
                int i3 = this.r;
                if (i2 <= i3) {
                    i2 = i3;
                }
                this.l = i2;
            } else if (this.i) {
                this.l = getNoRotateWidth();
            } else {
                this.l = this.p % 180 == 0 ? this.q : this.r;
            }
            int i4 = this.p;
            if (i4 == 90 || i4 == 270) {
                this.l = this.l > Util.u() ? this.l : Util.u();
            } else {
                int i5 = this.l;
                int i6 = this.n;
                if (i5 <= i6) {
                    i5 = i6;
                }
                this.l = i5;
            }
        }
        return this.l;
    }

    public int getViewHeight() {
        if (this.m <= 0 || this.g || this.e) {
            if (this.q == 0 || this.r == 0 || this.h) {
                measure(Util.E(), Util.D());
                this.h = false;
            }
            if (!this.e || this.p % 180 == 0) {
                this.m = this.p % 180 == 0 ? this.r : this.q;
            } else {
                int i2 = this.q;
                int i3 = this.r;
                if (i2 <= i3) {
                    i2 = i3;
                }
                this.m = i2;
            }
            int i4 = this.p;
            if (i4 != 90 && i4 != 270) {
                this.m = this.m > Util.u() ? this.m : Util.u();
            } else if (this.e) {
                this.m = this.m > Util.u() ? this.m : Util.u();
            } else {
                int i5 = this.m;
                int i6 = this.n;
                if (i5 <= i6) {
                    i5 = i6;
                }
                this.m = i5;
            }
        }
        return this.m;
    }

    public int getNoRotateWidth() {
        if (getPaint() == null || getText() == null || getText().length() <= 0) {
            return 0;
        }
        return (int) getPaint().measureText(getText().toString());
    }

    public void onWindowFocusChanged(boolean z2) {
        if (z2) {
            super.onWindowFocusChanged(z2);
        }
    }

    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        super.setText(charSequence, bufferType);
        this.h = true;
    }

    public void a(int i2, boolean z2) {
        if (this.p != i2) {
            if (!this.e || this.f) {
                this.p = i2;
                this.g = true;
            } else {
                this.p = 0;
                this.g = false;
            }
            if (this.e) {
                if (this.p % 180 == 0) {
                    if (this.i) {
                        setText(this.x);
                    }
                    setEms(getText() != null ? getText().length() : 1);
                } else {
                    if (this.i) {
                        setText(this.y);
                    }
                    setEms(1);
                }
                setRotation((float) (-this.p));
                this.h = true;
            }
        }
    }

    public void setVerticalDraw(boolean z2) {
        this.e = z2;
        if (this.e) {
            setIncludeFontPadding(false);
            setLineSpacing(0.0f, 0.9f);
        }
    }

    public void setOriginalText(String str) {
        this.x = str;
        this.i = true;
        this.y = null;
        String str2 = this.x;
        if (str2 != null) {
            this.y = str2.substring(0, 2);
        }
    }

    public void setItemText(String str) {
        setItemType(true);
        setVerticalDraw(this.e);
        setTextSize(0, this.z.getResources().getDimension(R.dimen.menu_tool_item_text_size));
        setTextColor(this.z.getColorStateList(R.color.menu_item_text_color_selector));
        getPaint().setAntiAlias(true);
        setTypeface(Util.j(this.z));
        setAlpha(isEnabled() ? 0.7f : 0.5f);
        if (this.c) {
            setText(a(str));
        } else {
            setText(str);
        }
        if (this.d) {
            setOriginalText(str);
        }
        this.g = true;
    }

    public void a(Drawable drawable, boolean z2) {
        setItemType(false);
        setSelected(z2);
        this.u = drawable;
    }

    public void setItemType(boolean z2) {
        this.j = z2;
    }

    private void b() {
        if (this.v == null) {
            this.v = Bitmap.createBitmap(this.u.getIntrinsicWidth(), this.u.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
            this.w = new Canvas(this.v);
        }
        this.w.drawColor(0, BlendMode.CLEAR);
        Drawable drawable = this.u;
        if (drawable instanceof StateListDrawable) {
            StateListDrawable stateListDrawable = (StateListDrawable) drawable;
            int[] iArr = new int[1];
            iArr[0] = isSelected() ? 16842913 : 0;
            Drawable stateDrawable = stateListDrawable.getStateDrawable(stateListDrawable.findStateDrawableIndex(iArr));
            stateDrawable.setBounds(0, 0, this.w.getWidth(), this.w.getHeight());
            androidx.core.graphics.drawable.a.g(stateDrawable).mutate().draw(this.w);
            return;
        }
        drawable.setState(getDrawableState());
        this.u.setBounds(0, 0, this.w.getWidth(), this.w.getHeight());
        this.u.draw(this.w);
    }

    public void setLayoutGravity(int i2) {
        this.s = i2;
    }

    public void setEnabled(boolean z2) {
        super.setEnabled(z2);
        setClickable(z2);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        try {
            if (this.e) {
                super.onMeasure(Util.E(), Util.D());
                this.q = getMeasuredWidth();
                this.r = getMeasuredHeight();
                return;
            }
            super.onMeasure(Util.E(), Util.D());
            this.q = getMeasuredWidth();
            this.r = getMeasuredHeight();
            setMeasuredDimension(this.p % 180 == 0 ? this.q : this.r, this.p % 180 == 0 ? this.r : this.q);
        } catch (Exception unused) {
        }
    }

    public float getShadowDy() {
        return super.getShadowDy() + ((float) this.t);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        int i2 = 17;
        if (getText() == null || this.e) {
            int i3 = this.p;
            if (i3 == 0 || i3 == 180) {
                if (this.i) {
                    i2 = 3;
                }
                setGravity(i2);
            } else {
                setGravity(3);
            }
            super.onDraw(canvas);
            return;
        }
        int width = getWidth();
        int height = getHeight();
        if (this.j) {
            Path path = new Path();
            String charSequence = getText().toString();
            getPaint().setColor(getCurrentTextColor());
            Paint.FontMetrics fontMetrics = getPaint().getFontMetrics();
            float f2 = fontMetrics.bottom;
            float f3 = fontMetrics.bottom - fontMetrics.top;
            int i4 = this.s;
            if (i4 == 5) {
                float f4 = (float) (((double) (f3 - f2)) + (((double) (height - this.r)) / 2.0d));
                path.moveTo((float) (width - this.q), f4);
                path.lineTo((float) width, f4);
                canvas.drawTextOnPath(charSequence, path, 0.0f, (float) this.t, getPaint());
            } else if (i4 != 17) {
                float f5 = (float) (((double) (f3 - f2)) + (((double) (height - this.r)) / 2.0d));
                path.moveTo(0.0f, f5);
                path.lineTo((float) this.q, f5);
                canvas.drawTextOnPath(charSequence, path, 0.0f, (float) this.t, getPaint());
            } else {
                float f6 = (float) (((double) (f3 - f2)) + (((double) (height - this.r)) / 2.0d));
                int i5 = this.q;
                float f7 = (float) (((double) (width - i5)) / 2.0d);
                path.moveTo(f7, f6);
                path.lineTo(((float) i5) + f7 + getTextSize(), f6);
                canvas.drawTextOnPath(charSequence, path, 0.0f, (float) this.t, getPaint());
            }
        } else {
            b();
            getPaint().setColor(this.z.getResources().getColor(R.color.camera_white));
            Matrix matrix = new Matrix();
            matrix.reset();
            matrix.postTranslate((float) ((width - this.v.getWidth()) / 2), (float) (((height - this.v.getHeight()) / 2) + this.t));
            canvas.drawBitmap(this.v, matrix, getPaint());
            super.onDraw(canvas);
        }
    }

    public void setShadow(boolean z2) {
        this.A = z2;
        if (!this.A || this.k) {
            setShadowLayer(0.0f, 0.0f, 0.0f, getPaint().getColor());
        } else {
            setShadowLayer(4.0f, 0.0f, 0.0f, getResources().getColor(R.color.color_black_with_70_percent_transparency));
        }
    }

    private String a(String str) {
        int lastIndexOf;
        if (str == null || str.equals("") || (lastIndexOf = str.lastIndexOf(" ")) >= str.length() - 1 || lastIndexOf < 0) {
            return str;
        }
        return (str.substring(0, lastIndexOf) + " ") + "（" + str.substring(lastIndexOf + 1) + "）";
    }

    public void a() {
        this.z = null;
        this.w = null;
    }

    public int[] onCreateDrawableState(int i2) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i2 + 1);
        if (this.k) {
            mergeDrawableStates(onCreateDrawableState, new int[]{R.attr.state_inverse_color});
        }
        return onCreateDrawableState;
    }

    public void setInverseColor(boolean z2) {
        this.k = z2;
        refreshDrawableState();
        setShadow(this.A);
        invalidate();
    }
}
