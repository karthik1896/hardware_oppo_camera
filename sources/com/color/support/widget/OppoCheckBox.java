package com.color.support.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewDebug;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.appcompat.widget.ax;
import androidx.appcompat.widget.f;
import color.support.v7.appcompat.R;
import com.color.support.d.d;

public class OppoCheckBox extends f {
    private static final int[] g = {R.attr.oppo_state_allSelect};
    private static final int[] h = {R.attr.oppo_state_partSelect};

    /* renamed from: a  reason: collision with root package name */
    private int f2139a;

    /* renamed from: b  reason: collision with root package name */
    private int f2140b;
    private boolean c;
    private Drawable e;
    private a f;

    public interface a {
        void a(OppoCheckBox oppoCheckBox, int i);
    }

    public OppoCheckBox(Context context) {
        this(context, (AttributeSet) null);
    }

    public OppoCheckBox(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.oppoCheckBoxStyle);
    }

    public OppoCheckBox(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        d.a(this, false);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.OppoCheckBox, i, 0);
        Drawable drawable = obtainStyledAttributes.getDrawable(R.styleable.OppoCheckBox_oppoButton);
        if (drawable != null) {
            setButtonDrawable(drawable);
        }
        setState(obtainStyledAttributes.getInteger(R.styleable.OppoCheckBox_oppoState, 0));
        obtainStyledAttributes.recycle();
    }

    public void a() {
        int i = 2;
        if (this.f2139a >= 2) {
            i = 0;
        }
        setState(i);
    }

    public boolean performClick() {
        a();
        return super.performClick();
    }

    @ViewDebug.ExportedProperty
    public int getState() {
        return this.f2139a;
    }

    public void setState(int i) {
        if (this.f2139a != i) {
            this.f2139a = i;
            refreshDrawableState();
            if (!this.c) {
                this.c = true;
                a aVar = this.f;
                if (aVar != null) {
                    aVar.a(this, this.f2139a);
                }
                this.c = false;
            }
        }
    }

    public void setOnStateChangeListener(a aVar) {
        this.f = aVar;
    }

    public void setButtonDrawable(int i) {
        if (i == 0 || i != this.f2140b) {
            this.f2140b = i;
            Drawable drawable = null;
            if (this.f2140b != 0) {
                drawable = getResources().getDrawable(this.f2140b);
            }
            setButtonDrawable(drawable);
        }
    }

    public void setButtonDrawable(Drawable drawable) {
        if (drawable != null) {
            Drawable drawable2 = this.e;
            if (drawable2 != null) {
                drawable2.setCallback((Drawable.Callback) null);
                unscheduleDrawable(this.e);
            }
            drawable.setCallback(this);
            drawable.setState(getDrawableState());
            drawable.setVisible(getVisibility() == 0, false);
            this.e = drawable;
            this.e.setState((int[]) null);
            setMinHeight(this.e.getIntrinsicHeight());
        }
        refreshDrawableState();
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(OppoCheckBox.class.getName());
        if (this.f2139a == 2) {
            accessibilityEvent.setChecked(true);
        } else {
            accessibilityEvent.setChecked(false);
        }
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(OppoCheckBox.class.getName());
        accessibilityNodeInfo.setCheckable(true);
        if (this.f2139a == 2) {
            accessibilityNodeInfo.setChecked(true);
        } else {
            accessibilityNodeInfo.setChecked(false);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000a, code lost:
        r1 = r2.e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int getCompoundPaddingLeft() {
        /*
            r2 = this;
            int r0 = super.getCompoundPaddingLeft()
            boolean r1 = androidx.appcompat.widget.ax.a(r2)
            if (r1 != 0) goto L_0x0013
            android.graphics.drawable.Drawable r1 = r2.e
            if (r1 == 0) goto L_0x0013
            int r1 = r1.getIntrinsicWidth()
            int r0 = r0 + r1
        L_0x0013:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.color.support.widget.OppoCheckBox.getCompoundPaddingLeft():int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000a, code lost:
        r1 = r2.e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int getCompoundPaddingRight() {
        /*
            r2 = this;
            int r0 = super.getCompoundPaddingRight()
            boolean r1 = androidx.appcompat.widget.ax.a(r2)
            if (r1 == 0) goto L_0x0013
            android.graphics.drawable.Drawable r1 = r2.e
            if (r1 == 0) goto L_0x0013
            int r1 = r1.getIntrinsicWidth()
            int r0 = r0 + r1
        L_0x0013:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.color.support.widget.OppoCheckBox.getCompoundPaddingRight():int");
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        int i;
        super.onDraw(canvas);
        Drawable drawable = this.e;
        if (drawable != null) {
            int gravity = getGravity() & 112;
            int intrinsicHeight = drawable.getIntrinsicHeight();
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int i2 = 0;
            if (gravity == 16) {
                i = (getHeight() - intrinsicHeight) / 2;
            } else if (gravity != 80) {
                i = 0;
            } else {
                i = getHeight() - intrinsicHeight;
            }
            int i3 = intrinsicHeight + i;
            if (ax.a(this)) {
                i2 = getWidth() - intrinsicWidth;
            }
            if (ax.a(this)) {
                intrinsicWidth = getWidth();
            }
            drawable.setBounds(i2, i, intrinsicWidth, i3);
            drawable.draw(canvas);
        }
    }

    /* access modifiers changed from: protected */
    public int[] onCreateDrawableState(int i) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
        if (getState() == 1) {
            mergeDrawableStates(onCreateDrawableState, h);
        }
        if (getState() == 2) {
            mergeDrawableStates(onCreateDrawableState, g);
        }
        return onCreateDrawableState;
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.e != null) {
            this.e.setState(getDrawableState());
            invalidate();
        }
    }

    /* access modifiers changed from: protected */
    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.e;
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.e;
        if (drawable != null) {
            drawable.jumpToCurrentState();
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
        int state;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.state = ((Integer) parcel.readValue((ClassLoader) null)).intValue();
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeValue(Integer.valueOf(this.state));
        }

        public String toString() {
            return "CompoundButton.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " state=" + this.state + "}";
        }
    }

    public Parcelable onSaveInstanceState() {
        setFreezesText(true);
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.state = getState();
        return savedState;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setState(savedState.state);
        requestLayout();
    }
}
