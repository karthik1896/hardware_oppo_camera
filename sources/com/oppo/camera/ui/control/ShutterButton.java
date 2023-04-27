package com.oppo.camera.ui.control;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.oppo.camera.R;
import com.oppo.camera.e;
import com.oppo.camera.ui.RotateImageView;
import com.oppo.camera.ui.f;
import com.oppo.camera.ui.inverse.a;

public class ShutterButton extends RotateImageView implements a {
    protected OnShutterButtonListener i;
    protected boolean j = false;
    private boolean k;
    private boolean l = false;
    private f m = null;

    public interface OnShutterButtonListener {
        boolean I();

        void a(ShutterButton shutterButton);

        void a(ShutterButton shutterButton, boolean z);

        void b(ShutterButton shutterButton);

        void c(ShutterButton shutterButton);

        void d(ShutterButton shutterButton);

        void e(ShutterButton shutterButton);
    }

    public ShutterButton(Context context) {
        super(context);
    }

    public ShutterButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ShutterButton(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public void setOnShutterButtonListener(OnShutterButtonListener onShutterButtonListener) {
        this.i = onShutterButtonListener;
    }

    public void setCameraUIListener(f fVar) {
        this.m = fVar;
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int actionMasked;
        f fVar = this.m;
        if (fVar == null || !fVar.i() || ((actionMasked = motionEvent.getActionMasked()) != 5 && actionMasked != 0)) {
            return super.dispatchTouchEvent(motionEvent);
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        final boolean isPressed = isPressed();
        if (isPressed != this.k) {
            if (!isPressed) {
                post(new Runnable() {
                    public void run() {
                        ShutterButton.this.a(isPressed);
                    }
                });
            } else {
                a(isPressed);
            }
            this.k = isPressed;
        }
    }

    /* access modifiers changed from: private */
    public void a(boolean z) {
        OnShutterButtonListener onShutterButtonListener = this.i;
        if (onShutterButtonListener != null) {
            onShutterButtonListener.a(this, z);
        }
    }

    public boolean performClick() {
        boolean performClick = super.performClick();
        OnShutterButtonListener onShutterButtonListener = this.i;
        if (onShutterButtonListener != null) {
            onShutterButtonListener.a(this);
        }
        return performClick;
    }

    public boolean performLongClick() {
        this.l = true;
        OnShutterButtonListener onShutterButtonListener = this.i;
        if (onShutterButtonListener != null) {
            onShutterButtonListener.b(this);
        }
        return true;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        OnShutterButtonListener onShutterButtonListener;
        OnShutterButtonListener onShutterButtonListener2;
        e.a("ShutterButton", "onTouchEvent, isEnabled: " + isEnabled() + ", event.getAction: " + motionEvent.getAction() + ", getY: " + motionEvent.getY() + ", getRawY: " + motionEvent.getRawY());
        OnShutterButtonListener onShutterButtonListener3 = this.i;
        if (onShutterButtonListener3 != null && !onShutterButtonListener3.I()) {
            return super.onTouchEvent(motionEvent);
        }
        if ((motionEvent.getAction() == 1 || motionEvent.getAction() == 3) && this.l) {
            OnShutterButtonListener onShutterButtonListener4 = this.i;
            if (onShutterButtonListener4 != null) {
                onShutterButtonListener4.c(this);
            }
            this.l = false;
        }
        if (motionEvent.getAction() == 0 && (onShutterButtonListener2 = this.i) != null) {
            onShutterButtonListener2.d(this);
        }
        if ((motionEvent.getAction() == 1 || motionEvent.getAction() == 3) && (onShutterButtonListener = this.i) != null) {
            onShutterButtonListener.e(this);
        }
        return super.onTouchEvent(motionEvent);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    public int[] onCreateDrawableState(int i2) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i2 + 1);
        if (this.j) {
            mergeDrawableStates(onCreateDrawableState, new int[]{R.attr.state_inverse_color});
        }
        return onCreateDrawableState;
    }

    public void setInverseColor(boolean z) {
        this.j = z;
        refreshDrawableState();
        invalidate();
    }
}
