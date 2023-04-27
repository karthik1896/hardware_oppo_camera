package com.color.support.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityManager;

public class ColorCircleProgressBar extends View {

    /* renamed from: a  reason: collision with root package name */
    private int f2017a;

    /* renamed from: b  reason: collision with root package name */
    private int f2018b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private a h;
    private AccessibilityManager i;
    private Paint j;
    private Paint k;
    private int l;
    private int m;
    private RectF n;
    private float o;

    private void b() {
        int i2 = this.d;
        if (i2 > 0) {
            this.f = (int) (((float) this.e) / (((float) i2) / 360.0f));
            if (360 - this.f < 2) {
                this.f = 360;
            }
            this.g = this.f;
        } else {
            this.f = 0;
            this.g = 0;
        }
        invalidate();
    }

    public void onDraw(Canvas canvas) {
        a(canvas);
        canvas.save();
        int i2 = this.m;
        canvas.rotate(-90.0f, (float) i2, (float) i2);
        canvas.drawArc(this.n, 0.0f, (float) this.f, false, this.j);
        canvas.restore();
    }

    private void a(Canvas canvas) {
        this.k.setStrokeWidth((float) this.c);
        int i2 = this.m;
        canvas.drawCircle((float) i2, (float) i2, this.o, this.k);
    }

    public void setProgress(int i2) {
        Log.i("ColorCircleProgressBar", "setProgress: " + i2);
        if (i2 < 0) {
            i2 = 0;
        }
        int i3 = this.d;
        if (i2 > i3) {
            i2 = i3;
        }
        if (i2 != this.e) {
            this.e = i2;
        }
        b();
        a();
    }

    public int getProgress() {
        return this.e;
    }

    public void setMax(int i2) {
        if (i2 < 0) {
            i2 = 0;
        }
        if (i2 != this.d) {
            this.d = i2;
            if (this.e > i2) {
                this.e = i2;
            }
        }
        b();
    }

    public int getMax() {
        return this.d;
    }

    /* access modifiers changed from: package-private */
    public void a() {
        AccessibilityManager accessibilityManager = this.i;
        if (accessibilityManager != null && accessibilityManager.isEnabled() && this.i.isTouchExplorationEnabled()) {
            c();
        }
    }

    private void c() {
        a aVar = this.h;
        if (aVar == null) {
            this.h = new a();
        } else {
            removeCallbacks(aVar);
        }
        postDelayed(this.h, 10);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        setMeasuredDimension(this.f2017a, this.f2018b);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        a aVar = this.h;
        if (aVar != null) {
            removeCallbacks(aVar);
        }
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.mProgress = this.e;
        return savedState;
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        this.l = this.c / 2;
        this.m = getWidth() / 2;
        int i6 = this.m;
        this.o = (float) (i6 - this.l);
        float f2 = this.o;
        this.n = new RectF(((float) i6) - f2, ((float) i6) - f2, ((float) i6) + f2, ((float) i6) + f2);
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setProgress(savedState.mProgress);
        requestLayout();
    }

    private class a implements Runnable {
        private a() {
        }

        public void run() {
            ColorCircleProgressBar.this.sendAccessibilityEvent(4);
        }
    }

    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* renamed from: a */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int mProgress;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.mProgress = ((Integer) parcel.readValue((ClassLoader) null)).intValue();
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeValue(Integer.valueOf(this.mProgress));
        }

        public String toString() {
            return "ColorCircleProgressBar.SavedState { " + Integer.toHexString(System.identityHashCode(this)) + " mProgress = " + this.mProgress + " }";
        }
    }
}
