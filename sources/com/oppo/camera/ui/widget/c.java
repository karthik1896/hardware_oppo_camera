package com.oppo.camera.ui.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AnimationUtils;
import androidx.dynamicanimation.a.b;
import androidx.dynamicanimation.a.d;
import androidx.dynamicanimation.a.e;
import androidx.dynamicanimation.a.f;
import com.oppo.camera.R;
import java.util.ArrayList;
import java.util.List;

/* compiled from: SlowVideoModeSeekBar */
public class c extends View implements b.c {
    private PointF A = new PointF();
    private b B = null;
    private e C = null;

    /* renamed from: a  reason: collision with root package name */
    private int f4589a = 0;

    /* renamed from: b  reason: collision with root package name */
    private int f4590b = 0;
    private int c = 0;
    private int d = 0;
    private int e = 0;
    private int f = 0;
    private int g = 0;
    private int h = 0;
    private int i = 0;
    private int j = 0;
    private int k = 0;
    private int l = 0;
    private int m = 0;
    private int n = 0;
    private int o = 0;
    private int p = -1;
    private int q = 0;
    private int r = 0;
    private int s = 0;
    private long t = 0;
    private long u = 0;
    private boolean v = false;
    private boolean w = false;
    private Paint x = null;
    private List<a> y = new ArrayList();
    private List<PointF> z = new ArrayList();

    /* compiled from: SlowVideoModeSeekBar */
    public interface b {
        void onSlowVideoFrameChange(int i);
    }

    public c(Context context) {
        super(context);
        a(context, (AttributeSet) null, 0);
    }

    private void a(Context context, AttributeSet attributeSet, int i2) {
        b(context, attributeSet, i2);
    }

    private void b(Context context, AttributeSet attributeSet, int i2) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SlowVideoModeSeekBar, i2, 0);
        Resources resources = context.getResources();
        try {
            this.f4589a = obtainStyledAttributes.getDimensionPixelSize(13, resources.getDimensionPixelSize(R.dimen.slow_video_seekbar_line_width));
            this.f4590b = obtainStyledAttributes.getDimensionPixelSize(12, resources.getDimensionPixelSize(R.dimen.slow_video_seekbar_line_height));
            this.c = obtainStyledAttributes.getColor(11, context.getColor(R.color.slow_video_seekbar_line_color));
            this.d = obtainStyledAttributes.getInt(10, 76);
            this.e = obtainStyledAttributes.getDimensionPixelSize(7, resources.getDimensionPixelSize(R.dimen.slow_video_seekbar_node_unselected_size));
            this.f = obtainStyledAttributes.getColor(6, context.getColor(R.color.slow_video_seekbar_node_unselected_color));
            this.g = obtainStyledAttributes.getDimensionPixelSize(3, resources.getDimensionPixelSize(R.dimen.slow_video_seekbar_node_selected_outer_size));
            this.h = obtainStyledAttributes.getColor(2, context.getColor(R.color.slow_video_seekbar_node_selected_outer_color));
            this.i = obtainStyledAttributes.getDimensionPixelSize(1, resources.getDimensionPixelSize(R.dimen.slow_video_seekbar_node_selected_inner_size));
            this.j = obtainStyledAttributes.getColor(0, context.getColor(R.color.slow_video_seekbar_node_selected_inner_color));
            this.k = obtainStyledAttributes.getDimensionPixelSize(9, resources.getDimensionPixelSize(R.dimen.slow_video_seekbar_node_unselected_text_size));
            this.l = obtainStyledAttributes.getColor(8, context.getColor(R.color.slow_video_seekbar_node_unselected_text_color));
            this.m = obtainStyledAttributes.getDimensionPixelSize(5, resources.getDimensionPixelSize(R.dimen.slow_video_seekbar_node_selected_text_size));
            this.n = obtainStyledAttributes.getColor(4, context.getColor(R.color.slow_video_seekbar_node_selected_text_color));
        } catch (Resources.NotFoundException e2) {
            e2.printStackTrace();
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
        obtainStyledAttributes.recycle();
        this.x = new Paint();
        this.x.setAntiAlias(true);
        this.x.setStyle(Paint.Style.FILL);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        this.A.x = ((float) getLineStartX()) + (((float) this.p) * (((float) this.f4589a) / ((float) (this.y.size() - 1))));
        this.A.y = getLineStartY();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        a();
        c(canvas);
        b(canvas);
        a(canvas);
    }

    private void a(Canvas canvas) {
        for (int i2 = 0; i2 < this.y.size(); i2++) {
            if (b(i2)) {
                this.x.setColor(this.n);
                this.x.setTextSize((float) this.m);
            } else {
                this.x.setColor(this.l);
                this.x.setTextSize((float) this.k);
            }
            String b2 = this.y.get(i2).b();
            float measureText = this.x.measureText(b2);
            Paint.FontMetrics fontMetrics = this.x.getFontMetrics();
            PointF pointF = this.z.get(i2);
            float f2 = pointF.x - (measureText / 2.0f);
            float dimension = pointF.y + getContext().getResources().getDimension(R.dimen.slow_video_seekbar_node_text_margin_top) + ((float) (this.f4590b >> 1));
            float f3 = dimension - fontMetrics.top;
            canvas.save();
            canvas.rotate((float) (-this.r), pointF.x, dimension + ((fontMetrics.bottom - fontMetrics.top) / 2.0f));
            canvas.drawText(b2, f2, f3, this.x);
            canvas.restore();
        }
    }

    private boolean b(int i2) {
        return this.p == i2;
    }

    private void b(Canvas canvas) {
        this.x.setStyle(Paint.Style.FILL);
        this.x.setAlpha(255);
        this.x.setColor(this.f);
        float lineStartX = (float) getLineStartX();
        for (int i2 = 0; i2 < this.y.size(); i2++) {
            float size = (((float) i2) * (((float) this.f4589a) / ((float) (this.y.size() - 1)))) + lineStartX;
            float lineStartY = getLineStartY();
            canvas.drawCircle(size, lineStartY, (float) (this.e >> 1), this.x);
            if (this.z.size() != this.y.size()) {
                this.z.add(new PointF(size, lineStartY));
            }
        }
        float f2 = this.A.x;
        float f3 = this.A.y;
        if (this.w) {
            this.x.setColor(this.f);
            canvas.drawCircle(f2, f3, (float) (this.e >> 1), this.x);
            return;
        }
        this.x.setColor(this.h);
        canvas.drawCircle(f2, f3, (float) (this.g >> 1), this.x);
        this.x.setColor(this.j);
        canvas.drawCircle(f2, f3, (float) (this.i >> 1), this.x);
    }

    private void c(Canvas canvas) {
        this.x.setStyle(Paint.Style.STROKE);
        this.x.setStrokeWidth((float) this.f4590b);
        this.x.setColor(this.c);
        this.x.setAlpha(this.d);
        float lineStartX = (float) getLineStartX();
        float lineStartY = getLineStartY();
        canvas.drawLine(lineStartX, lineStartY, lineStartX + ((float) this.f4589a), lineStartY, this.x);
    }

    private float getLineStartY() {
        return ((float) getMeasuredHeight()) * 0.26667f;
    }

    private int getLineStartX() {
        return (getMeasuredWidth() - this.f4589a) >> 1;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001e, code lost:
        if (r0 != 6) goto L_0x0138;
     */
    @android.annotation.SuppressLint({"ClickableViewAccessibility"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r9) {
        /*
            r8 = this;
            boolean r0 = r8.isEnabled()
            r1 = 0
            if (r0 != 0) goto L_0x000e
            r8.w = r1
            boolean r9 = super.onTouchEvent(r9)
            return r9
        L_0x000e:
            int r0 = r9.getAction()
            r2 = 1
            if (r0 == 0) goto L_0x00e7
            if (r0 == r2) goto L_0x0079
            r3 = 2
            if (r0 == r3) goto L_0x0022
            r3 = 3
            if (r0 == r3) goto L_0x0079
            r3 = 6
            if (r0 == r3) goto L_0x0079
            goto L_0x0138
        L_0x0022:
            boolean r0 = r8.w
            if (r0 == 0) goto L_0x0138
            float r9 = r9.getX()
            java.util.List<android.graphics.PointF> r0 = r8.z
            java.lang.Object r0 = r0.get(r1)
            android.graphics.PointF r0 = (android.graphics.PointF) r0
            java.util.List<android.graphics.PointF> r3 = r8.z
            int r4 = r3.size()
            int r4 = r4 - r2
            java.lang.Object r3 = r3.get(r4)
            android.graphics.PointF r3 = (android.graphics.PointF) r3
            float r0 = r0.x
            float r9 = java.lang.Math.max(r9, r0)
            float r0 = r3.x
            float r9 = java.lang.Math.min(r9, r0)
            android.graphics.PointF r0 = r8.A
            r0.x = r9
        L_0x004f:
            java.util.List<android.graphics.PointF> r0 = r8.z
            int r0 = r0.size()
            if (r1 >= r0) goto L_0x0074
            java.util.List<android.graphics.PointF> r0 = r8.z
            java.lang.Object r0 = r0.get(r1)
            android.graphics.PointF r0 = (android.graphics.PointF) r0
            float r0 = r0.x
            float r0 = r0 - r9
            float r0 = java.lang.Math.abs(r0)
            int r3 = r8.e
            int r3 = r3 >> r2
            float r3 = (float) r3
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 > 0) goto L_0x0071
            r8.p = r1
            goto L_0x0074
        L_0x0071:
            int r1 = r1 + 1
            goto L_0x004f
        L_0x0074:
            r8.postInvalidate()
            goto L_0x0138
        L_0x0079:
            boolean r0 = r8.w
            if (r0 == 0) goto L_0x0138
            int r0 = r8.f4589a
            float r0 = (float) r0
            r3 = r0
            r0 = r1
        L_0x0082:
            java.util.List<android.graphics.PointF> r4 = r8.z
            int r4 = r4.size()
            if (r0 >= r4) goto L_0x00a7
            java.util.List<android.graphics.PointF> r4 = r8.z
            java.lang.Object r4 = r4.get(r0)
            android.graphics.PointF r4 = (android.graphics.PointF) r4
            float r5 = r9.getX()
            float r4 = r4.x
            float r4 = r4 - r5
            float r4 = java.lang.Math.abs(r4)
            int r5 = (r4 > r3 ? 1 : (r4 == r3 ? 0 : -1))
            if (r5 >= 0) goto L_0x00a4
            r8.p = r0
            r3 = r4
        L_0x00a4:
            int r0 = r0 + 1
            goto L_0x0082
        L_0x00a7:
            java.util.List<android.graphics.PointF> r9 = r8.z
            int r0 = r8.p
            java.lang.Object r9 = r9.get(r0)
            android.graphics.PointF r9 = (android.graphics.PointF) r9
            android.graphics.PointF r0 = r8.A
            float r0 = r0.x
            float r3 = r9.x
            int r0 = java.lang.Float.compare(r0, r3)
            if (r0 == 0) goto L_0x00c6
            android.graphics.PointF r0 = r8.A
            float r0 = r0.x
            float r9 = r9.x
            r8.a((float) r0, (float) r9)
        L_0x00c6:
            java.util.List<com.oppo.camera.ui.widget.c$a> r9 = r8.y
            int r0 = r8.p
            java.lang.Object r9 = r9.get(r0)
            com.oppo.camera.ui.widget.c$a r9 = (com.oppo.camera.ui.widget.c.a) r9
            int r9 = r9.a()
            int r0 = r8.o
            if (r0 == r9) goto L_0x00e1
            com.oppo.camera.ui.widget.c$b r0 = r8.B
            if (r0 == 0) goto L_0x00e1
            r8.o = r9
            r0.onSlowVideoFrameChange(r9)
        L_0x00e1:
            r8.w = r1
            r8.postInvalidate()
            goto L_0x0138
        L_0x00e7:
            float r0 = r9.getX()
            float r9 = r9.getY()
            r3 = r1
        L_0x00f0:
            java.util.List<android.graphics.PointF> r4 = r8.z
            int r4 = r4.size()
            if (r3 >= r4) goto L_0x0138
            java.util.List<android.graphics.PointF> r4 = r8.z
            java.lang.Object r4 = r4.get(r3)
            android.graphics.PointF r4 = (android.graphics.PointF) r4
            float r5 = r4.x
            float r4 = r4.y
            float r6 = r0 - r5
            float r6 = java.lang.Math.abs(r6)
            r7 = 1117782016(0x42a00000, float:80.0)
            int r6 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1))
            if (r6 >= 0) goto L_0x0133
            float r4 = r9 - r4
            float r4 = java.lang.Math.abs(r4)
            int r4 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r4 >= 0) goto L_0x0133
            android.graphics.PointF r9 = r8.A
            float r9 = r9.x
            r8.a((float) r9, (float) r5)
            r8.w = r2
            androidx.dynamicanimation.a.e r9 = r8.C
            if (r9 == 0) goto L_0x0138
            r9.b((androidx.dynamicanimation.a.b.c) r8)
            androidx.dynamicanimation.a.e r9 = r8.C
            r9.b()
            r9 = 0
            r8.C = r9
            goto L_0x0138
        L_0x0133:
            r8.w = r1
            int r3 = r3 + 1
            goto L_0x00f0
        L_0x0138:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.ui.widget.c.onTouchEvent(android.view.MotionEvent):boolean");
    }

    private void a(float f2, float f3) {
        e eVar = this.C;
        if (eVar != null) {
            eVar.b((b.c) this);
            this.C.b();
        }
        this.C = new e(new d(f2));
        f fVar = new f(f3);
        fVar.a(1500.0f);
        fVar.b(0.5f);
        this.C.a(fVar);
        List<PointF> list = this.z;
        this.C.c(this.z.get(0).x - ((float) this.e));
        this.C.b(list.get(list.size() - 1).x + ((float) this.e));
        this.C.a((b.c) this);
        this.C.a();
    }

    public void a(androidx.dynamicanimation.a.b bVar, float f2, float f3) {
        this.A.x = f2;
        postInvalidate();
    }

    private void a() {
        if (this.r != this.s) {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            if (currentAnimationTimeMillis < this.u) {
                int i2 = (int) (currentAnimationTimeMillis - this.t);
                int i3 = this.q;
                if (!this.v) {
                    i2 = -i2;
                }
                int i4 = i3 + ((i2 * 360) / 1000);
                this.r = i4 > 0 ? i4 % 360 : (i4 % 360) + 360;
                invalidate();
                return;
            }
            this.r = this.s;
        }
    }

    public void a(int i2, boolean z2) {
        int i3 = i2 > 0 ? i2 % 360 : (i2 % 360) + 360;
        if (i3 != this.s) {
            this.s = i3;
            if (z2) {
                this.q = this.r;
                this.t = AnimationUtils.currentAnimationTimeMillis();
                int i4 = this.s - this.r;
                if (i4 < 0) {
                    i4 += 360;
                }
                if (i4 > 180) {
                    i4 -= 360;
                }
                this.v = i4 >= 0;
                this.u = this.t + ((long) ((Math.abs(i4) * 1000) / 360));
            } else {
                this.r = this.q;
            }
            invalidate();
        }
    }

    public void setFrameList(List<a> list) {
        if (list != null && !list.isEmpty()) {
            this.z.clear();
            this.y.clear();
            this.y.addAll(list);
        }
        com.oppo.camera.e.b("SlowVideoModeSeekBar", "setFrameList: " + list);
    }

    public void a(int i2) {
        int i3 = 0;
        while (true) {
            if (i3 >= this.y.size()) {
                break;
            } else if (this.y.get(i3).a() == i2) {
                this.p = i3;
                this.o = this.y.get(this.p).a();
                break;
            } else {
                i3++;
            }
        }
        int i4 = this.p;
        if (i4 < 0 || i4 >= this.y.size()) {
            this.p = this.y.size() - 1;
            this.o = this.y.get(this.p).a();
            com.oppo.camera.e.d("SlowVideoModeSeekBar", "updateSelectedFrame, default index not found, use last index");
        }
        com.oppo.camera.e.b("SlowVideoModeSeekBar", "updateSelectedFrame, frame: " + i2 + ", mSelectedIndex: " + this.p);
    }

    public void setModeFrameChangeListener(b bVar) {
        this.B = bVar;
    }

    /* compiled from: SlowVideoModeSeekBar */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private int f4591a = 0;

        /* renamed from: b  reason: collision with root package name */
        private String f4592b = "";

        public a(int i, String str) {
            this.f4591a = i;
            this.f4592b = str;
        }

        public int a() {
            return this.f4591a;
        }

        public String b() {
            return this.f4592b;
        }
    }
}
