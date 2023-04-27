package com.oppo.camera.ui.beauty3d;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.oppo.camera.R;
import com.oppo.camera.util.Util;

public class BorderRoundImageView extends ImageView {

    /* renamed from: a  reason: collision with root package name */
    private Paint f3825a;

    /* renamed from: b  reason: collision with root package name */
    private Paint f3826b;
    private Bitmap c;
    private Canvas d;
    private BitmapShader e;
    private Matrix f;
    private float g;
    private int h;
    private boolean i;

    public BorderRoundImageView(Context context) {
        this(context, (AttributeSet) null);
    }

    public BorderRoundImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BorderRoundImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet);
        this.f3825a = new Paint(1);
        this.f3826b = new Paint(1);
        this.c = null;
        this.d = new Canvas();
        this.e = null;
        this.f = new Matrix();
        this.g = 0.0f;
        this.h = 0;
        this.i = false;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.borderRoundImageView, i2, 0);
        this.g = (float) obtainStyledAttributes.getDimensionPixelSize(1, getResources().getDimensionPixelSize(R.dimen.beauty3d_edit_recyclerview_item_border_width));
        this.h = obtainStyledAttributes.getColor(0, Util.s(context));
        obtainStyledAttributes.recycle();
        this.f3826b.setStyle(Paint.Style.STROKE);
        this.f3826b.setStrokeWidth(this.g);
        this.f3826b.setColor(this.h);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        Bitmap a2 = a(getDrawable());
        if (a2 != null) {
            int min = Math.min(getWidth(), getHeight());
            if (this.e == null || !a2.equals(this.c)) {
                this.c = a2;
                this.e = new BitmapShader(this.c, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
            }
            if (this.e != null) {
                float f2 = (float) min;
                this.f.setScale((f2 - (this.g * 2.0f)) / ((float) a2.getWidth()), (f2 - (this.g * 2.0f)) / ((float) a2.getHeight()));
                this.e.setLocalMatrix(this.f);
            }
            this.f3825a.setShader(this.e);
            float f3 = ((float) min) / 2.0f;
            if (this.i) {
                canvas.drawCircle(f3, f3, f3 - (this.g / 2.0f), this.f3826b);
            }
            float f4 = this.g;
            canvas.translate(f4, f4);
            float f5 = this.g;
            canvas.drawCircle(f3 - f5, f3 - f5, f3 - f5, this.f3825a);
            return;
        }
        super.onDraw(canvas);
    }

    private Bitmap a(Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        if (!(drawable instanceof ColorDrawable)) {
            return null;
        }
        Rect bounds = drawable.getBounds();
        int color2 = ((ColorDrawable) drawable).getColor();
        Bitmap a2 = Util.a(bounds.right - bounds.left, bounds.bottom - bounds.top, Bitmap.Config.ARGB_8888);
        Canvas canvas = this.d;
        if (canvas != null) {
            canvas.setBitmap(a2);
            this.d.drawARGB(Color.alpha(color2), Color.red(color2), Color.green(color2), Color.blue(color2));
        }
        return a2;
    }

    public void setHighLight(boolean z) {
        this.i = z;
        invalidate();
    }
}
