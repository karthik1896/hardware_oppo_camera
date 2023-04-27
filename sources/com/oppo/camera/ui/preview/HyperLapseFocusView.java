package com.oppo.camera.ui.preview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.oppo.camera.e;
import com.oppo.camera.util.Util;

public class HyperLapseFocusView extends ImageView {

    /* renamed from: a  reason: collision with root package name */
    private int f4341a = 0;

    /* renamed from: b  reason: collision with root package name */
    private int f4342b = 0;
    private int c = 0;
    private int d = 0;
    private int e = 0;
    private int f = 0;
    private int g = 0;
    private int h = 0;
    private int i = 0;
    private int j = 0;
    private long k = 0;
    private a l = null;

    public interface a {
        void a(int i, int i2);

        boolean a();

        void b(int i, int i2);

        boolean b();

        void c();
    }

    public HyperLapseFocusView(Context context) {
        super(context);
    }

    public HyperLapseFocusView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public HyperLapseFocusView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public void a(a aVar) {
        this.j = (Util.C() - Util.w()) - Util.z();
        this.l = aVar;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        a aVar = this.l;
        if (aVar == null || (!aVar.a() && !this.l.b())) {
            int measuredHeight = getMeasuredHeight();
            int measuredWidth = getMeasuredWidth();
            int action = motionEvent.getAction();
            int rawX = (int) motionEvent.getRawX();
            int rawY = (int) motionEvent.getRawY();
            if (action == 0) {
                this.c = rawX;
                this.d = rawY;
                this.f4341a = rawX;
                this.f4342b = rawY;
                this.k = System.currentTimeMillis();
            } else if (action != 1) {
                if (action == 2) {
                    int i2 = rawX - this.c;
                    int i3 = rawY - this.d;
                    this.e = getLeft() + i2;
                    this.f = getTop() + i3;
                    this.g = getRight() + i2;
                    this.h = getBottom() + i3;
                    if (this.g > Util.E()) {
                        this.g = Util.E();
                        this.e = this.g - measuredWidth;
                    }
                    int i4 = this.e;
                    int i5 = this.i;
                    if (i4 < i5) {
                        this.e = i5;
                        this.g = measuredWidth;
                    }
                    int i6 = this.f;
                    int i7 = this.i;
                    if (i6 < i7) {
                        this.f = i7;
                        this.h = measuredHeight;
                    }
                    int i8 = this.h;
                    int i9 = this.j;
                    if (i8 > i9) {
                        this.h = i9;
                        this.f = this.h - measuredHeight;
                    }
                    layout(this.e, this.f, this.g, this.h);
                    this.c = rawX;
                    this.d = rawY;
                }
            } else if (Math.abs(rawX - this.f4341a) < 5 || Math.abs(rawY - this.f4342b) < 5) {
                if (this.l != null) {
                    if (500 < System.currentTimeMillis() - this.k) {
                        this.l.b(rawX, rawY);
                    } else {
                        this.l.a(rawX, rawY);
                    }
                }
                return true;
            } else {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
                layoutParams.setMargins(this.e, this.f, 0, 0);
                setLayoutParams(layoutParams);
                a aVar2 = this.l;
                if (aVar2 != null) {
                    aVar2.c();
                }
            }
            return true;
        }
        e.a("HyperLapseFocusView", "onTouchEvent, return");
        return false;
    }
}
