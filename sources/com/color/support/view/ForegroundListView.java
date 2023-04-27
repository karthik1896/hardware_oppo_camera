package com.color.support.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.ListView;

public class ForegroundListView extends ListView {

    /* renamed from: a  reason: collision with root package name */
    private Paint f2008a = new Paint();

    public ForegroundListView(Context context) {
        super(context);
    }

    public ForegroundListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ForegroundListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public ForegroundListView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawText(" ", 0.0f, 0.0f, this.f2008a);
    }
}
