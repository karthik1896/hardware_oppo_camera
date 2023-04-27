package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SeekBar;
import androidx.appcompat.R;
import androidx.core.g.v;
import androidx.core.graphics.drawable.a;

/* compiled from: AppCompatSeekBarHelper */
class t extends p {

    /* renamed from: a  reason: collision with root package name */
    private final SeekBar f462a;

    /* renamed from: b  reason: collision with root package name */
    private Drawable f463b;
    private ColorStateList c = null;
    private PorterDuff.Mode d = null;
    private boolean e = false;
    private boolean f = false;

    t(SeekBar seekBar) {
        super(seekBar);
        this.f462a = seekBar;
    }

    /* access modifiers changed from: package-private */
    public void a(AttributeSet attributeSet, int i) {
        super.a(attributeSet, i);
        ar a2 = ar.a(this.f462a.getContext(), attributeSet, R.styleable.AppCompatSeekBar, i, 0);
        Drawable b2 = a2.b(R.styleable.AppCompatSeekBar_android_thumb);
        if (b2 != null) {
            this.f462a.setThumb(b2);
        }
        a(a2.a(R.styleable.AppCompatSeekBar_tickMark));
        if (a2.g(R.styleable.AppCompatSeekBar_tickMarkTintMode)) {
            this.d = aa.a(a2.a(R.styleable.AppCompatSeekBar_tickMarkTintMode, -1), this.d);
            this.f = true;
        }
        if (a2.g(R.styleable.AppCompatSeekBar_tickMarkTint)) {
            this.c = a2.e(R.styleable.AppCompatSeekBar_tickMarkTint);
            this.e = true;
        }
        a2.b();
        d();
    }

    /* access modifiers changed from: package-private */
    public void a(Drawable drawable) {
        Drawable drawable2 = this.f463b;
        if (drawable2 != null) {
            drawable2.setCallback((Drawable.Callback) null);
        }
        this.f463b = drawable;
        if (drawable != null) {
            drawable.setCallback(this.f462a);
            a.b(drawable, v.g(this.f462a));
            if (drawable.isStateful()) {
                drawable.setState(this.f462a.getDrawableState());
            }
            d();
        }
        this.f462a.invalidate();
    }

    private void d() {
        if (this.f463b == null) {
            return;
        }
        if (this.e || this.f) {
            this.f463b = a.g(this.f463b.mutate());
            if (this.e) {
                a.a(this.f463b, this.c);
            }
            if (this.f) {
                a.a(this.f463b, this.d);
            }
            if (this.f463b.isStateful()) {
                this.f463b.setState(this.f462a.getDrawableState());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void b() {
        Drawable drawable = this.f463b;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    /* access modifiers changed from: package-private */
    public void c() {
        Drawable drawable = this.f463b;
        if (drawable != null && drawable.isStateful() && drawable.setState(this.f462a.getDrawableState())) {
            this.f462a.invalidateDrawable(drawable);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(Canvas canvas) {
        if (this.f463b != null) {
            int max = this.f462a.getMax();
            int i = 1;
            if (max > 1) {
                int intrinsicWidth = this.f463b.getIntrinsicWidth();
                int intrinsicHeight = this.f463b.getIntrinsicHeight();
                int i2 = intrinsicWidth >= 0 ? intrinsicWidth / 2 : 1;
                if (intrinsicHeight >= 0) {
                    i = intrinsicHeight / 2;
                }
                this.f463b.setBounds(-i2, -i, i2, i);
                float width = ((float) ((this.f462a.getWidth() - this.f462a.getPaddingLeft()) - this.f462a.getPaddingRight())) / ((float) max);
                int save = canvas.save();
                canvas.translate((float) this.f462a.getPaddingLeft(), (float) (this.f462a.getHeight() / 2));
                for (int i3 = 0; i3 <= max; i3++) {
                    this.f463b.draw(canvas);
                    canvas.translate(width, 0.0f);
                }
                canvas.restoreToCount(save);
            }
        }
    }
}
