package com.oppo.camera.ui.preview;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Size;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import com.oppo.camera.R;
import com.oppo.camera.e;

public class IntelligentDragView extends ImageView implements j {

    /* renamed from: a  reason: collision with root package name */
    private int f4343a;

    /* renamed from: b  reason: collision with root package name */
    private int f4344b;
    private int c;
    private int d;
    private int e;
    /* access modifiers changed from: private */
    public boolean f;
    private Rect g;
    /* access modifiers changed from: private */
    public a h;
    private GestureDetector i;
    private final GestureDetector.OnGestureListener j;

    interface a {
        boolean a(MotionEvent motionEvent);

        void b(MotionEvent motionEvent);

        void c(MotionEvent motionEvent);
    }

    public void a() {
    }

    public void a(int i2, boolean z) {
    }

    public void a(boolean z, boolean z2) {
    }

    public IntelligentDragView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4343a = 0;
        this.f4344b = 0;
        this.c = 0;
        this.d = 0;
        this.e = 0;
        this.f = false;
        this.g = new Rect();
        this.h = null;
        this.i = null;
        this.j = new GestureDetector.OnGestureListener() {
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                return false;
            }

            public void onShowPress(MotionEvent motionEvent) {
            }

            public boolean onDown(MotionEvent motionEvent) {
                boolean unused = IntelligentDragView.this.f = false;
                return true;
            }

            public boolean onSingleTapUp(MotionEvent motionEvent) {
                if (IntelligentDragView.this.h != null) {
                    return IntelligentDragView.this.h.a(motionEvent);
                }
                return false;
            }

            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (!IntelligentDragView.this.isEnabled()) {
                    return false;
                }
                boolean unused = IntelligentDragView.this.f = true;
                float y = motionEvent2.getY() - motionEvent.getY();
                Rect a2 = IntelligentDragView.this.a(motionEvent2.getX() - motionEvent.getX(), y);
                IntelligentDragView.this.layout(a2.left, a2.top, a2.right, a2.bottom);
                return true;
            }

            public void onLongPress(MotionEvent motionEvent) {
                if (IntelligentDragView.this.h != null) {
                    IntelligentDragView.this.h.c(motionEvent);
                }
            }
        };
        this.f4343a = getResources().getDimensionPixelSize(R.dimen.video_intelligent_high_frame_dectect_width);
        this.f4344b = getResources().getDimensionPixelSize(R.dimen.video_intelligent_high_frame_dectect_height);
        this.i = new GestureDetector(context, this.j);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        View view = (View) getParent();
        this.c = view.getWidth();
        this.d = view.getHeight();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f && 1 == motionEvent.getAction()) {
            this.f = false;
            a aVar = this.h;
            if (aVar != null) {
                aVar.b(motionEvent);
            }
        }
        return this.i.onTouchEvent(motionEvent);
    }

    /* access modifiers changed from: private */
    public Rect a(float f2, float f3) {
        int left = (int) (((float) getLeft()) + f2);
        int i2 = this.f4343a + left;
        int top = (int) (((float) getTop()) + f3);
        int i3 = this.f4344b + top;
        if (left < 0) {
            i2 = this.f4343a + 0;
            left = 0;
        } else {
            int i4 = this.c;
            if (i2 > i4) {
                left = i4 - this.f4343a;
                i2 = i4;
            }
        }
        if (top < 0) {
            i3 = this.f4344b + 0;
            top = 0;
        } else {
            int i5 = this.d;
            int i6 = this.e;
            if (i3 > i5 - i6) {
                i3 = i5 - i6;
                top = i3 - this.f4344b;
            }
        }
        this.g.set(left, top, i2, i3);
        return this.g;
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        setAlpha(z ? 1.0f : 0.6028f);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!this.g.isEmpty()) {
            layout(this.g.left, this.g.top, this.g.right, this.g.bottom);
        }
    }

    public void layout(int i2, int i3, int i4, int i5) {
        if (!this.g.isEmpty()) {
            i2 = this.g.left;
            i3 = this.g.top;
            i4 = this.g.right;
            i5 = this.g.bottom;
        }
        super.layout(i2, i3, i4, i5);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        b();
    }

    public void b() {
        this.g.set(0, 0, 0, 0);
    }

    public void setBottomRestrict(int i2) {
        e.b("IntelligentDragView", "setBottomRestrict: " + i2);
        this.e = i2;
    }

    public void setIntelligentGestureListener(a aVar) {
        this.h = aVar;
    }

    public RectF a(Size size, int i2) {
        View view = (View) getParent();
        float height = ((float) size.getHeight()) / ((float) view.getWidth());
        float width = ((float) size.getWidth()) / ((float) view.getHeight());
        int left = getLeft();
        int top = getTop();
        int width2 = getWidth();
        int height2 = getHeight();
        RectF rectF = new RectF();
        if (i2 == 0) {
            rectF.left = (float) ((int) (((float) left) * height));
            rectF.top = (float) ((int) (((float) top) * width));
            rectF.right = (float) ((int) (rectF.left + (((float) width2) * width)));
            rectF.bottom = (float) ((int) (rectF.top + (((float) height2) * height)));
        } else if (90 == i2) {
            rectF.left = (float) ((int) (((float) top) * height));
            rectF.top = (float) ((int) (((float) ((view.getWidth() - left) - width2)) * width));
            rectF.right = (float) ((int) (rectF.left + (((float) height2) * width)));
            rectF.bottom = (float) ((int) (rectF.top + (((float) width2) * height)));
        } else if (180 == i2) {
            rectF.left = (float) ((int) (((float) ((view.getWidth() - left) - width2)) * height));
            rectF.top = (float) ((int) (((float) ((view.getHeight() - top) - height2)) * width));
            rectF.right = (float) ((int) (rectF.left + (((float) height2) * width)));
            rectF.bottom = (float) ((int) (rectF.top + (((float) width2) * height)));
        } else if (270 == i2) {
            rectF.left = (float) ((int) (((float) ((view.getHeight() - top) - height2)) * height));
            rectF.top = (float) ((int) (((float) left) * height));
            rectF.right = (float) ((int) (rectF.left + (((float) height2) * width)));
            rectF.bottom = (float) ((int) (rectF.top + (((float) width2) * height)));
        }
        return rectF;
    }
}
