package com.color.support.widget.slideselect;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.Space;
import android.widget.TextView;
import color.support.v7.appcompat.R;

public class ColorSelectListView extends ListView {

    /* renamed from: a  reason: collision with root package name */
    private b f2276a;

    /* renamed from: b  reason: collision with root package name */
    private int f2277b;
    private boolean c;
    private boolean d;
    private Vibrator e;
    private int f;
    private int g;
    private Bitmap h;
    private double i = 12.0d;
    private boolean j;
    private int k;

    public void setAnimationInPregress(boolean z) {
        this.d = z;
    }

    public void setIsFirstDown(boolean z) {
        this.j = z;
    }

    public int getTriggerSource() {
        return this.k;
    }

    public void setTriggerSource(int i2) {
        this.k = i2;
    }

    public ColorSelectListView(Context context) {
        super(context);
    }

    public ColorSelectListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.e = (Vibrator) context.getSystemService("vibrator");
        this.f = getResources().getColor(R.color.color_slide_secletor_item_bg);
        this.g = getResources().getColor(17170445);
    }

    public ColorSelectListView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.e = (Vibrator) context.getSystemService("vibrator");
        this.f = getResources().getColor(R.color.color_slide_secletor_item_bg);
        this.g = getResources().getColor(17170445);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.d) {
            return true;
        }
        if (this.k == 0) {
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action == 1) {
                    if (this.c) {
                        this.f2276a.a(this.f2277b);
                    } else {
                        this.f2276a.a(-10);
                    }
                    this.c = false;
                    setTriggerSource(2);
                } else if (action == 2) {
                    a(motionEvent);
                    return true;
                }
            }
            return super.onTouchEvent(motionEvent);
        }
        int action2 = motionEvent.getAction();
        if (action2 != 0) {
            if (action2 == 1) {
                setTriggerSource(2);
                this.f2276a.a(this.f2277b);
                return true;
            } else if (action2 != 2) {
                return super.onTouchEvent(motionEvent);
            }
        }
        b(motionEvent);
        return true;
    }

    private void a(MotionEvent motionEvent) {
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if (!(childAt instanceof Space)) {
                if (a(childAt).contains(motionEvent.getRawX(), motionEvent.getRawY())) {
                    if (this.j) {
                        this.f2277b = i2;
                        this.j = false;
                        this.c = false;
                        return;
                    }
                    if (this.f2277b != i2) {
                        this.c = true;
                    }
                    if (!this.c) {
                        continue;
                    } else if (this.f2277b != i2) {
                        this.f2277b = i2;
                        a();
                        setItemFous(childAt);
                    } else {
                        return;
                    }
                } else if (this.c) {
                    FrameLayout frameLayout = (FrameLayout) childAt;
                    if (((TextView) frameLayout.getChildAt(0)).getCurrentTextColor() != getResources().getColor(R.color.color_select_prefernce_default_tv_color)) {
                        ((TextView) frameLayout.getChildAt(0)).setTextColor(getResources().getColor(R.color.color_select_prefernce_default_tv_color));
                    }
                    if ((childAt.getBackground() instanceof ColorDrawable) && ((ColorDrawable) childAt.getBackground()).getColor() == this.f) {
                        setItemLoseFocus(childAt);
                    }
                }
            }
        }
    }

    private void a() {
        if (Build.VERSION.SDK_INT > 26) {
            this.e.vibrate(VibrationEffect.createOneShot(16, 250));
            return;
        }
        performHapticFeedback(0);
    }

    private void b(MotionEvent motionEvent) {
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if (!a(childAt).contains(motionEvent.getRawX(), motionEvent.getRawY())) {
                setItemLoseFocus(childAt);
            } else if (this.f2277b != i2) {
                this.f2277b = i2;
                a();
                setItemFous(childAt);
            } else {
                return;
            }
        }
    }

    private void setItemLoseFocus(View view) {
        view.setBackgroundColor(getResources().getColor(17170445));
        ((TextView) ((FrameLayout) view).getChildAt(0)).setTextColor(getResources().getColor(R.color.color_select_prefernce_default_tv_color));
    }

    private void setItemFous(View view) {
        view.setBackgroundColor(getResources().getColor(R.color.color_slide_secletor_item_bg));
        ((TextView) ((FrameLayout) view).getChildAt(0)).setTextColor(getResources().getColor(R.color.color_select_prefernce_focus_tv_color));
    }

    public void setOnFingerUpListener(b bVar) {
        this.f2276a = bVar;
    }

    public static RectF a(View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        return new RectF((float) iArr[0], (float) iArr[1], (float) (iArr[0] + view.getWidth()), (float) (iArr[1] + view.getHeight()));
    }

    public void setBlurBitmap(Bitmap bitmap) {
        this.h = bitmap;
        invalidate();
    }
}
