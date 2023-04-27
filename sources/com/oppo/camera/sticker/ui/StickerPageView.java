package com.oppo.camera.sticker.ui;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.animation.TranslateAnimation;
import androidx.viewpager.widget.ViewPager;

public class StickerPageView extends ViewPager {
    private g d;
    private Rect e;
    private boolean f;
    private float g;
    private int h;

    public StickerPageView(Context context) {
        this(context, (AttributeSet) null);
    }

    public StickerPageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.d = null;
        this.e = new Rect();
        this.f = true;
        this.g = 0.0f;
        this.h = 0;
    }

    public void setStickerCategoryInterface(g gVar) {
        this.d = gVar;
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        g gVar = this.d;
        if (gVar == null || gVar.a()) {
            return super.dispatchTouchEvent(motionEvent);
        }
        return false;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.g = motionEvent.getX();
            this.h = getCurrentItem();
            g gVar = this.d;
            if (gVar != null) {
                gVar.b();
            }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 1) {
            f();
        } else if (action == 2) {
            float x = motionEvent.getX();
            float f2 = x - this.g;
            if (getAdapter().a() > 1) {
                int i = this.h;
                if (i == 0) {
                    if (this.f && f2 > 10.0f) {
                        b(x);
                    } else if (!this.f) {
                        this.g = x;
                        int i2 = (int) (f2 * 0.5f);
                        if (getLeft() + i2 >= this.e.left) {
                            layout(getLeft() + i2, getTop(), getRight() + i2, getBottom());
                        }
                    }
                } else if (i != getAdapter().a() - 1) {
                    this.f = true;
                } else if (this.f && f2 < -10.0f) {
                    b(x);
                } else if (!this.f) {
                    this.g = x;
                    int i3 = (int) (f2 * 0.5f);
                    if (getRight() + i3 <= this.e.right) {
                        layout(getLeft() + i3, getTop(), getRight() + i3, getBottom());
                    }
                }
            } else if (this.f && (f2 > 10.0f || f2 < -10.0f)) {
                b(x);
            } else if (!this.f) {
                this.g = x;
                int i4 = (int) (f2 * 0.5f);
                if (getLeft() + i4 >= this.e.left) {
                    layout(getLeft() + i4, getTop(), getRight() + i4, getBottom());
                }
                if (getRight() + i4 <= this.e.right) {
                    layout(getLeft() + i4, getTop(), getRight() + i4, getBottom());
                }
            }
            if (!this.f) {
                return true;
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    private void b(float f2) {
        this.g = f2;
        if (this.e.isEmpty()) {
            this.e.set(getLeft(), getTop(), getRight(), getBottom());
        }
        this.f = false;
    }

    private void f() {
        if (!this.e.isEmpty()) {
            g();
        }
    }

    private void g() {
        TranslateAnimation translateAnimation = new TranslateAnimation((float) getLeft(), (float) this.e.left, 0.0f, 0.0f);
        translateAnimation.setDuration(300);
        startAnimation(translateAnimation);
        layout(this.e.left, this.e.top, this.e.right, this.e.bottom);
        this.e.setEmpty();
        this.f = true;
    }
}
