package com.oppo.camera.ui.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.widget.ImageView;

/* compiled from: RoundImageView */
public class b extends ImageView {

    /* renamed from: a  reason: collision with root package name */
    private Bitmap f4587a;

    /* renamed from: b  reason: collision with root package name */
    private Shader f4588b;
    private Paint c = new Paint();
    private float d = 0.0f;
    private RectF e = new RectF();

    public b(Context context) {
        super(context);
    }

    public void setBitmap(Bitmap bitmap) {
        this.f4587a = bitmap;
        this.f4588b = new BitmapShader(this.f4587a, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
    }

    public void setMRadius(float f) {
        this.d = f;
        invalidate();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        if (this.f4588b != null) {
            canvas.save();
            this.c.setShader(this.f4588b);
            this.e.set((float) getPaddingLeft(), (float) getPaddingTop(), (float) (getWidth() - getPaddingRight()), (float) (getHeight() - getPaddingBottom()));
            RectF rectF = this.e;
            float f = this.d;
            canvas.drawRoundRect(rectF, f, f, this.c);
            canvas.restore();
        }
    }
}
