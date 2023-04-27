package com.oppo.camera.ui.preview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import com.heytap.compat.d.a.a;
import com.heytap.compat.os.b;
import com.oppo.camera.e;

public class ScreenHoleView extends View {

    /* renamed from: a  reason: collision with root package name */
    private int f4350a;

    /* renamed from: b  reason: collision with root package name */
    private int f4351b;
    private int c;
    private int d;
    private int e;
    private int f;
    private Paint g;
    private Rect h;

    public ScreenHoleView(Context context) {
        this(context, (AttributeSet) null);
    }

    public ScreenHoleView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ScreenHoleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4350a = 0;
        this.f4351b = 0;
        this.c = 0;
        this.d = 0;
        this.e = 0;
        this.f = 0;
        this.g = null;
        this.h = null;
        a();
    }

    private void a() {
        this.g = new Paint(1);
        this.g.setColor(-16777216);
        this.g.setStyle(Paint.Style.FILL);
    }

    public void setHolePosition(Rect rect) {
        e.b("ScreenHoleView", "setHolePosition, rect: " + rect);
        this.h = rect;
        b();
    }

    private void b() {
        Rect rect = this.h;
        if (rect != null && !rect.isEmpty()) {
            int screenHoleExpandSize = getScreenHoleExpandSize();
            this.f4350a = this.h.left - screenHoleExpandSize;
            this.f4351b = this.h.right + screenHoleExpandSize;
            this.c = this.h.top - screenHoleExpandSize;
            this.d = this.h.bottom + screenHoleExpandSize;
            if (this.f4350a < 0) {
                this.f4350a = 0;
            }
            if (this.c < 0) {
                this.c = 0;
            }
            this.e = (this.d - this.c) / 2;
            int i = this.h.right - this.h.left;
            int i2 = this.h.bottom - this.h.top;
            if (i == i2) {
                this.f = 1;
            } else if (i > i2) {
                this.f = 2;
            } else {
                this.f = 0;
            }
        }
    }

    private int getScreenHoleExpandSize() {
        try {
            return b.a("screen_hole_expand_size", 15);
        } catch (a e2) {
            e2.printStackTrace();
            return 15;
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int i = this.f;
        if (i == 1) {
            a(canvas);
        } else if (i == 2) {
            b(canvas);
        }
    }

    private void a(Canvas canvas) {
        int i = this.e;
        if (i > 0) {
            canvas.drawCircle((float) (this.f4350a + i), (float) (this.c + i), (float) i, this.g);
        }
    }

    private void b(Canvas canvas) {
        int i = this.e;
        if (i > 0) {
            int i2 = this.f4350a;
            Canvas canvas2 = canvas;
            canvas2.drawArc((float) i2, (float) this.c, (float) ((i * 2) + i2), (float) this.d, 90.0f, 180.0f, false, this.g);
            int i3 = this.f4350a;
            int i4 = this.e;
            canvas2.drawRect((float) (i3 + i4), (float) this.c, (float) (this.f4351b - i4), (float) this.d, this.g);
            int i5 = this.f4351b;
            canvas2.drawArc((float) (i5 - (this.e * 2)), (float) this.c, (float) i5, (float) this.d, 90.0f, -180.0f, false, this.g);
        }
    }
}
