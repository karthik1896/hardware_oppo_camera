package com.oppo.camera.ui.preview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Size;
import android.view.View;
import com.oppo.camera.R;
import com.oppo.camera.e;
import com.oppo.camera.util.Util;

/* compiled from: TrackFocusView */
public class t extends View implements j {

    /* renamed from: a  reason: collision with root package name */
    private Rect f4566a = new Rect();

    /* renamed from: b  reason: collision with root package name */
    private RectF f4567b = new RectF();
    private RectF c = new RectF();
    private Paint d = new Paint();
    private Matrix e = new Matrix();
    private int f = 0;
    private float g = 1.0f;
    private float h = 1.0f;
    private boolean i = false;
    private boolean j = true;
    private boolean k = false;
    private int l = 0;
    private int m = 0;
    private float n = 0.0f;

    public void a(boolean z, boolean z2) {
    }

    public t(Context context) {
        super(context);
        a(context);
    }

    private void a(Context context) {
        this.d = new Paint(1);
        this.n = context.getResources().getDimension(R.dimen.video_tracking_focus_frame_radius);
        this.d.setAntiAlias(true);
        this.d.setDither(true);
        this.d.setStyle(Paint.Style.STROKE);
        this.d.setStrokeCap(Paint.Cap.ROUND);
        this.d.setStrokeWidth((float) context.getResources().getDimensionPixelSize(R.dimen.track_focus_circle_stroke_width));
        this.d.setColor(context.getResources().getColor(R.color.track_focus_circle_stroke_color));
    }

    public void setZoomValue(float f2) {
        this.g = f2;
    }

    public void a(Rect rect, Rect rect2, Size size) {
        e.a("TrackFocusView", "initTrackRegionParams, cropRegion: " + rect + ", inputRegion: " + rect2 + ", trackHalAlgoSize: " + size);
        this.f4566a = rect;
        this.h = ((float) Util.E()) / ((float) this.f4566a.height());
        if (((double) Math.abs((((float) size.getWidth()) / ((float) size.getHeight())) - (((float) this.f4566a.width()) / ((float) this.f4566a.height())))) > 0.01d) {
            this.k = true;
            this.l = this.f4566a.top;
            this.m = this.f4566a.height();
            return;
        }
        this.k = false;
    }

    public void setDisplayOrientation(int i2) {
        this.f = i2;
    }

    public void a(int[] iArr) {
        if (iArr == null) {
            this.j = false;
        } else if (!this.i && !this.j) {
            b(iArr);
            postInvalidate();
        }
    }

    private void b(int[] iArr) {
        if (this.k) {
            int i2 = iArr[1];
            int i3 = this.l;
            int i4 = i2 - i3;
            int i5 = iArr[3] - i3;
            RectF rectF = this.f4567b;
            float f2 = (float) iArr[0];
            if (i4 <= 0) {
                i4 = 0;
            }
            float f3 = (float) i4;
            float f4 = (float) iArr[2];
            int i6 = this.m;
            if (i5 >= i6) {
                i5 = i6;
            }
            rectF.set(f2, f3, f4, (float) i5);
            return;
        }
        this.f4567b.set((float) iArr[0], (float) iArr[1], (float) iArr[2], (float) iArr[3]);
    }

    public void a() {
        setVisibility(8);
        this.i = true;
        this.j = true;
        d();
    }

    public void b() {
        setVisibility(0);
        this.i = false;
    }

    public boolean c() {
        return !this.f4567b.isEmpty();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        if (!this.f4567b.isEmpty()) {
            this.e.reset();
            this.e.setTranslate((float) ((-this.f4566a.width()) / 2), (float) ((-this.f4566a.height()) / 2));
            this.e.postRotate((float) this.f);
            Matrix matrix = this.e;
            float f2 = this.h;
            float f3 = this.g;
            matrix.postScale(f2 * f3, f2 * f3);
            this.e.postTranslate((float) (getWidth() / 2), (float) (getHeight() / 2));
            this.e.mapRect(this.c, this.f4567b);
            canvas.drawCircle(this.c.centerX(), this.c.centerY(), this.n, this.d);
        }
    }

    public void d() {
        this.f4567b.setEmpty();
        postInvalidate();
    }
}
