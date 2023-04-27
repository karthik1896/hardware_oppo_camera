package com.oppo.camera.sticker.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import com.oppo.camera.R;

/* compiled from: StickerCategoryContainer */
public class f extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    private boolean f3705a;

    /* renamed from: b  reason: collision with root package name */
    private Paint f3706b;
    private int c;
    private int d;

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public f(Context context) {
        super(context);
        this.f3705a = false;
        this.f3706b = null;
        this.c = 0;
        this.d = 0;
        this.f3706b = new Paint();
        this.f3706b.setStrokeWidth(1.0f);
        this.f3706b.setColor(getContext().getColor(R.color.camera_white));
        this.f3706b.setAlpha(51);
        this.f3706b.setAntiAlias(true);
        this.c = context.getResources().getDimensionPixelSize(R.dimen.sticker_music_divider_margin_right);
        this.d = context.getResources().getDimensionPixelSize(R.dimen.sticker_music_divider_margin_top);
        setLayerType(1, (Paint) null);
    }

    public void a(boolean z) {
        this.f3705a = z;
        invalidate();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        canvas.drawLine(0.0f, (float) getHeight(), (float) getWidth(), (float) getHeight(), this.f3706b);
        if (this.f3705a) {
            canvas.drawLine((float) (getWidth() - this.c), (float) this.d, (float) (getWidth() - this.c), (float) (getHeight() - this.d), this.f3706b);
        }
        canvas.restore();
    }
}
