package com.color.support.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import androidx.core.g.a.d;
import androidx.customview.a.a;
import java.util.ArrayList;
import java.util.List;

public class ColorNumericKeyboard extends View {
    private AnimatorSet A;
    /* access modifiers changed from: private */
    public AnimatorSet B;
    private boolean C;
    private Animator.AnimatorListener D;
    private PatternExploreByTouchHelper E;
    private final AccessibilityManager F;
    private Context G;
    private int H;
    private int I;
    private int J;
    private int K;
    private float L;
    private int M;
    private int N;
    private float O;
    private Interpolator P;
    private Interpolator Q;

    /* renamed from: a  reason: collision with root package name */
    private Paint f2091a;

    /* renamed from: b  reason: collision with root package name */
    private Cell f2092b;
    private int c;
    private OnClickItemListener d;
    private int e;
    /* access modifiers changed from: private */
    public int f;
    private int g;
    private boolean h;
    private boolean i;
    private Cell[][] j;
    private Drawable k;
    private Drawable l;
    /* access modifiers changed from: private */
    public int[] m;
    private TextPaint n;
    private Paint.FontMetricsInt o;
    private Paint.FontMetricsInt p;
    private Paint q;
    private float r;
    private float s;
    private TextPaint t;
    private float u;
    private float v;
    private float w;
    private float x;
    /* access modifiers changed from: private */
    public SideStyle y;
    /* access modifiers changed from: private */
    public SideStyle z;

    public interface OnClickItemListener {
        void a();

        void a(int i);

        void b();
    }

    @Deprecated
    public interface OnItemTouchListener {
    }

    @Deprecated
    public interface OnTouchTextListener {
    }

    @Deprecated
    public interface OnTouchUpListener {
    }

    public static class SideStyle {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public Drawable f2098a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public String f2099b;
        /* access modifiers changed from: private */
        public int c;
        /* access modifiers changed from: private */
        public float d;
        /* access modifiers changed from: private */
        public String e;

        public static class Builder {
        }
    }

    @Deprecated
    public int getTouchIndex() {
        return 0;
    }

    @Deprecated
    public void setHasFinishButton(boolean z2) {
    }

    @Deprecated
    public void setItemTouchListener(OnItemTouchListener onItemTouchListener) {
    }

    @Deprecated
    public void setTouchTextListener(OnTouchTextListener onTouchTextListener) {
    }

    @Deprecated
    public void setTouchUpListener(OnTouchUpListener onTouchUpListener) {
    }

    @Deprecated
    public void setType(int i2) {
    }

    /* renamed from: com.color.support.widget.ColorNumericKeyboard$1  reason: invalid class name */
    class AnonymousClass1 extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ColorNumericKeyboard f2093a;

        public void onAnimationEnd(Animator animator) {
            this.f2093a.B.start();
        }
    }

    public synchronized Cell a(int i2, int i3) {
        b(i2, i3);
        return this.j[i2][i3];
    }

    private void b(int i2, int i3) {
        if (i2 < 0 || i2 > 3) {
            throw new IllegalArgumentException("row must be in range 0-3");
        } else if (i3 < 0 || i3 > 2) {
            throw new IllegalArgumentException("column must be in range 0-2");
        }
    }

    public class Cell {

        /* renamed from: a  reason: collision with root package name */
        int f2094a;

        /* renamed from: b  reason: collision with root package name */
        int f2095b;
        String c;
        float d;
        int e;
        int f;
        final /* synthetic */ ColorNumericKeyboard g;

        public int getRow() {
            return this.f2094a;
        }

        public int getColumn() {
            return this.f2095b;
        }

        public void setCellNumberAlpha(float f2) {
            this.d = f2;
            this.g.invalidate();
        }

        public void setCellNumberTranslateX(int i) {
            this.e = i;
            this.g.invalidate();
        }

        public void setCellNumberTranslateY(int i) {
            this.f = i;
            this.g.invalidate();
        }

        public String toString() {
            return "row " + this.f2094a + "column " + this.f2095b;
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        int i4 = this.e;
        int i5 = this.f;
        setMeasuredDimension(((this.g + i4) * 3) + i5, ((int) (((float) (i4 * 4)) + (this.s * 5.0f))) + i5);
    }

    private int[] getStatusAndVariation() {
        int i2 = Settings.System.getInt(this.G.getContentResolver(), "font_variation_settings", 550);
        return new int[]{(61440 & i2) >> 12, i2 & 4095};
    }

    private Typeface a(int[] iArr) {
        this.H = iArr[1];
        Typeface typeface = Typeface.DEFAULT;
        if (Build.VERSION.SDK_INT < 26) {
            return typeface;
        }
        if (iArr[0] == 0) {
            return new Typeface.Builder("/system/fonts/SysSans-En-Regular.ttf").build();
        }
        return new Typeface.Builder("/system/fonts/SysSans-En-Regular.ttf").setFontVariationSettings("'wght' " + iArr[1]).build();
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        int[] statusAndVariation = getStatusAndVariation();
        if (this.H != statusAndVariation[1]) {
            this.n.setTypeface(a(statusAndVariation));
            invalidate();
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (a(motionEvent)) {
            return true;
        }
        int action = motionEvent.getAction();
        if (!isEnabled()) {
            if (a(action)) {
                c();
            }
            return false;
        }
        if (action == 0) {
            this.i = true;
            c(motionEvent);
        } else if (action == 1) {
            this.i = false;
            b(motionEvent);
        } else if (action != 2) {
            if (action == 3) {
                this.i = false;
                b(motionEvent);
            } else if (action == 6) {
                this.i = false;
                b(motionEvent);
            }
        }
        return true;
    }

    private boolean a(int i2) {
        return this.v > 0.0f && (1 == i2 || 3 == i2 || i2 == 0);
    }

    private boolean a(MotionEvent motionEvent) {
        return motionEvent.getPointerId(motionEvent.getActionIndex()) > 0;
    }

    private void a() {
        if (this.C) {
            performHapticFeedback(302);
        } else {
            performHapticFeedback(301);
        }
    }

    private void b() {
        playSoundEffect(0);
    }

    private void b(MotionEvent motionEvent) {
        if (this.F.isTouchExplorationEnabled()) {
            this.f2092b = a(motionEvent.getX(), motionEvent.getY());
            Cell cell = this.f2092b;
            if (cell != null) {
                int a2 = a(cell);
                this.E.invalidateRoot();
                if (this.h && a2 != -1) {
                    a();
                }
            } else {
                this.c = -1;
            }
        }
        c();
        if (!(a(motionEvent.getY()) == -1 || b(motionEvent.getX()) == -1)) {
            b(this.c);
        }
        if (this.c != -1 && isEnabled() && !hasOnClickListeners()) {
            b();
        }
        invalidate();
    }

    private void c() {
        if (this.A.isRunning()) {
            this.A.addListener(this.D);
        } else {
            this.B.start();
        }
    }

    /* access modifiers changed from: private */
    public void b(int i2) {
        OnClickItemListener onClickItemListener = this.d;
        if (onClickItemListener != null) {
            if (i2 >= 0 && i2 <= 8) {
                onClickItemListener.a(i2 + 1);
            }
            if (i2 == 10) {
                this.d.a(0);
            }
            if (i2 == 9) {
                this.d.a();
            }
            if (i2 == 11) {
                this.d.b();
            }
        }
    }

    private void c(MotionEvent motionEvent) {
        if (!this.F.isTouchExplorationEnabled()) {
            this.f2092b = a(motionEvent.getX(), motionEvent.getY());
            Cell cell = this.f2092b;
            if (cell != null) {
                int a2 = a(cell);
                this.E.invalidateRoot();
                if (this.h && a2 != -1) {
                    a();
                }
            } else {
                this.c = -1;
            }
        }
        this.A.removeListener(this.D);
        if (this.B.isRunning()) {
            this.B.end();
        }
        if (this.A.isRunning()) {
            this.A.end();
        }
        this.A.start();
        invalidate();
    }

    private int a(Cell cell) {
        this.c = (cell.getRow() * 3) + cell.getColumn();
        if (this.c == 9 && a(this.y)) {
            this.c = -1;
        }
        if (this.c == 11 && a(this.z)) {
            this.c = -1;
        }
        return this.c;
    }

    /* access modifiers changed from: private */
    public float c(int i2) {
        float f2 = (float) (this.e + this.g);
        return ((float) getPaddingLeft()) + (f2 / 2.0f) + (f2 * ((float) i2)) + ((float) (this.f / 2));
    }

    /* access modifiers changed from: private */
    public float d(int i2) {
        float f2 = (float) this.e;
        return ((float) getPaddingTop()) + (f2 / 2.0f) + ((float) (this.f / 2)) + (f2 * ((float) i2)) + (this.s * ((float) (i2 + 1)));
    }

    /* access modifiers changed from: private */
    public Cell a(float f2, float f3) {
        int b2;
        int a2 = a(f3);
        if (a2 >= 0 && (b2 = b(f2)) >= 0) {
            return a(a2, b2);
        }
        return null;
    }

    private int a(float f2) {
        for (int i2 = 0; i2 < 4; i2++) {
            int d2 = (int) d(i2);
            int i3 = this.e;
            float f3 = this.s;
            int i4 = (int) (((float) (d2 + (i3 / 2))) + (f3 / 2.0f));
            if (((float) ((int) (((float) (d2 - (i3 / 2))) - (f3 / 2.0f)))) <= f2 && f2 <= ((float) i4)) {
                return i2;
            }
        }
        return -1;
    }

    private int b(float f2) {
        for (int i2 = 0; i2 < 3; i2++) {
            int c2 = (int) c(i2);
            int i3 = this.e;
            int i4 = this.g;
            int i5 = c2 + (i3 / 2) + (i4 / 2);
            if (((float) ((c2 - (i3 / 2)) - (i4 / 2))) <= f2 && f2 <= ((float) i5)) {
                return i2;
            }
        }
        return -1;
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f2091a != null) {
            this.f2091a = null;
        }
        if (this.f2092b != null) {
            this.f2092b = null;
        }
        this.i = false;
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        a(canvas);
        for (int i2 = -1; i2 < 4; i2++) {
            a(canvas, i2);
        }
        for (int i3 = 0; i3 < 4; i3++) {
            for (int i4 = 0; i4 < 3; i4++) {
                a(canvas, i4, i3);
            }
        }
    }

    private void a(Canvas canvas) {
        Cell cell = this.f2092b;
        if (cell != null) {
            float c2 = c(cell.f2095b);
            float d2 = d(this.f2092b.f2094a);
            if (a(this.f2092b) != -1) {
                int i2 = this.f;
                int i3 = (int) (c2 - ((float) i2));
                int i4 = (int) (d2 - ((float) i2));
                int i5 = (int) (((float) i2) + c2);
                int i6 = (int) (((float) i2) + d2);
                canvas.save();
                float f2 = this.x;
                canvas.scale(f2, f2, c2, d2);
                this.k.setAlpha((int) (this.v * 255.0f));
                this.k.setBounds(i3, i4, i5, i6);
                this.k.draw(canvas);
                canvas.restore();
                canvas.save();
                float f3 = this.w;
                canvas.scale(f3, f3, c2, d2);
                this.l.setBounds(i3, i4, i5, i6);
                this.l.setAlpha((int) (this.u * 255.0f));
                this.l.draw(canvas);
                canvas.restore();
            }
        }
    }

    private void a(Canvas canvas, int i2) {
        float f2 = this.r;
        float measuredWidth = (((float) getMeasuredWidth()) - f2) / 2.0f;
        float f3 = (float) ((this.e + this.g) * (i2 + 1));
        canvas.drawLine(measuredWidth, f3, measuredWidth + f2, f3, this.q);
    }

    private void a(Canvas canvas, int i2, int i3) {
        Cell cell = this.j[i3][i2];
        float c2 = c(i2);
        float d2 = d(i3);
        int i4 = (i3 * 3) + i2;
        if (i4 == 9) {
            a(this.y, canvas, c2, d2);
        } else if (i4 == 11) {
            a(this.z, canvas, c2, d2);
        } else if (i4 != -1) {
            float measureText = this.n.measureText(cell.c);
            float f2 = d2 - ((float) ((this.o.descent + this.o.ascent) / 2));
            this.n.setAlpha((int) (cell.d * 255.0f));
            canvas.drawText(cell.c, (c2 - (measureText / 2.0f)) + ((float) cell.e), f2 + ((float) cell.f), this.n);
        }
    }

    private void a(SideStyle sideStyle, Canvas canvas, float f2, float f3) {
        if (!a(sideStyle)) {
            if (sideStyle.f2098a != null) {
                int intrinsicWidth = (int) (f2 - ((float) (sideStyle.f2098a.getIntrinsicWidth() / 2)));
                int intrinsicWidth2 = sideStyle.f2098a.getIntrinsicWidth() + intrinsicWidth;
                int intrinsicHeight = (int) (f3 - ((float) (sideStyle.f2098a.getIntrinsicHeight() / 2)));
                int intrinsicHeight2 = sideStyle.f2098a.getIntrinsicHeight() + intrinsicHeight;
                Drawable a2 = sideStyle.f2098a;
                int i2 = this.J;
                int i3 = this.K;
                a2.setBounds(intrinsicWidth + i2, intrinsicHeight + i3, intrinsicWidth2 + i2, intrinsicHeight2 + i3);
                sideStyle.f2098a.setAlpha((int) (this.L * 255.0f));
                sideStyle.f2098a.draw(canvas);
            } else if (!TextUtils.isEmpty(sideStyle.f2099b)) {
                this.t.setTextSize(sideStyle.d);
                this.t.setColor(sideStyle.c);
                this.t.setAlpha((int) (this.O * 255.0f));
                float measureText = this.t.measureText(sideStyle.f2099b);
                this.p = this.t.getFontMetricsInt();
                canvas.drawText(sideStyle.f2099b, (f2 - (measureText / 2.0f)) + ((float) this.M), (f3 - ((float) ((this.p.descent + this.p.ascent) / 2))) + ((float) this.N), this.t);
            }
        }
    }

    public void setEnabled(boolean z2) {
        Paint paint;
        if (!z2 && this.i && (paint = this.f2091a) != null) {
            paint.setAlpha(0);
            this.i = false;
            invalidate();
        }
        super.setEnabled(z2);
    }

    private void setBlurScale(float f2) {
        this.w = f2;
        invalidate();
    }

    private void setNormalScale(float f2) {
        this.x = f2;
        invalidate();
    }

    private void setBlurAlpha(float f2) {
        this.u = f2;
        invalidate();
    }

    private void setNormalAlpha(float f2) {
        this.v = f2;
        invalidate();
    }

    public void setDrawableTranslateX(int i2) {
        this.J = i2;
        invalidate();
    }

    public void setDrawableTranslateY(int i2) {
        this.K = i2;
        invalidate();
    }

    public void setDrawableAlpha(float f2) {
        this.L = f2;
        invalidate();
    }

    public void setTextTranslateX(int i2) {
        this.M = i2;
        invalidate();
    }

    public void setTextTranslateY(int i2) {
        this.N = i2;
        invalidate();
    }

    public void setTextAlpha(float f2) {
        this.O = f2;
        invalidate();
    }

    public void setOnClickItemListener(OnClickItemListener onClickItemListener) {
        this.d = onClickItemListener;
    }

    public void setLeftStyle(SideStyle sideStyle) {
        this.y = sideStyle;
        this.E.invalidateVirtualView(9);
        invalidate();
    }

    public void setRightStyle(SideStyle sideStyle) {
        this.z = sideStyle;
        this.E.invalidateVirtualView(11);
        invalidate();
    }

    /* access modifiers changed from: private */
    public boolean a(SideStyle sideStyle) {
        return sideStyle == null || (sideStyle.f2098a == null && TextUtils.isEmpty(sideStyle.f2099b));
    }

    public void setTactileFeedbackEnabled(boolean z2) {
        this.h = z2;
    }

    public AnimatorSet getEnterAnim() {
        AnimatorSet animatorSet = new AnimatorSet();
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < 4; i2++) {
            for (int i3 = 0; i3 < 3; i3++) {
                Cell a2 = a(i2, i3);
                int i4 = (i2 * 3) + i3;
                if (i4 == 9) {
                    a(this.y, (List<Animator>) arrayList, i4);
                } else if (i4 == 11) {
                    SideStyle sideStyle = this.z;
                    if (a(this.y)) {
                        i4--;
                    }
                    a(sideStyle, (List<Animator>) arrayList, i4);
                } else {
                    a(a2, (List<Animator>) arrayList, i4);
                }
            }
        }
        animatorSet.playTogether(arrayList);
        return animatorSet;
    }

    private void a(SideStyle sideStyle, List<Animator> list, int i2) {
        List<Animator> list2 = list;
        int i3 = i2;
        if (a(sideStyle)) {
            return;
        }
        if (sideStyle.f2098a != null) {
            setDrawableAlpha(0.0f);
            setDrawableTranslateY(this.I);
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "drawableAlpha", new float[]{0.0f, 1.0f});
            long j2 = ((long) i3) * 16;
            ofFloat.setStartDelay(166 + j2);
            ofFloat.setDuration(167);
            ofFloat.setInterpolator(this.P);
            list2.add(ofFloat);
            ObjectAnimator ofInt = ObjectAnimator.ofInt(this, "drawableTranslateY", new int[]{this.I, 0});
            ofInt.setStartDelay(j2);
            ofInt.setDuration(500);
            ofInt.setInterpolator(this.Q);
            list2.add(ofInt);
        } else if (!TextUtils.isEmpty(sideStyle.f2099b)) {
            setTextAlpha(0.0f);
            setTextTranslateY(this.I);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this, "textAlpha", new float[]{0.0f, 1.0f});
            long j3 = ((long) i3) * 16;
            ofFloat2.setStartDelay(166 + j3);
            ofFloat2.setDuration(167);
            ofFloat2.setInterpolator(this.P);
            list2.add(ofFloat2);
            ObjectAnimator ofInt2 = ObjectAnimator.ofInt(this, "textTranslateY", new int[]{this.I, 0});
            ofInt2.setStartDelay(j3);
            ofInt2.setDuration(500);
            ofInt2.setInterpolator(this.Q);
            list2.add(ofInt2);
        }
    }

    private void a(Cell cell, List<Animator> list, int i2) {
        cell.setCellNumberAlpha(0.0f);
        cell.setCellNumberTranslateY(this.I);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(cell, "cellNumberAlpha", new float[]{0.0f, 1.0f});
        ofFloat.setStartDelay(166 + (((long) ((i2 != 10 || !a(this.y)) ? i2 : i2 - 1)) * 16));
        ofFloat.setDuration(167);
        ofFloat.setInterpolator(this.P);
        list.add(ofFloat);
        ObjectAnimator ofInt = ObjectAnimator.ofInt(cell, "cellNumberTranslateY", new int[]{this.I, 0});
        if (i2 == 10 && a(this.y)) {
            i2--;
        }
        ofInt.setStartDelay(16 * ((long) i2));
        ofInt.setDuration(500);
        ofInt.setInterpolator(this.Q);
        list.add(ofInt);
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        if (this.F.isTouchExplorationEnabled()) {
            int action = motionEvent.getAction();
            if (action == 7) {
                motionEvent.setAction(2);
            } else if (action == 9) {
                motionEvent.setAction(0);
            } else if (action == 10) {
                motionEvent.setAction(1);
            }
            onTouchEvent(motionEvent);
            motionEvent.setAction(action);
        }
        return super.onHoverEvent(motionEvent);
    }

    /* access modifiers changed from: protected */
    public boolean dispatchHoverEvent(MotionEvent motionEvent) {
        return this.E.dispatchHoverEvent(motionEvent) | super.dispatchHoverEvent(motionEvent);
    }

    private final class PatternExploreByTouchHelper extends a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ColorNumericKeyboard f2096a;

        /* renamed from: b  reason: collision with root package name */
        private Rect f2097b;

        /* access modifiers changed from: protected */
        public int getVirtualViewAt(float f, float f2) {
            return a(f, f2);
        }

        /* access modifiers changed from: protected */
        public void getVisibleVirtualViews(List<Integer> list) {
            for (int i = 0; i < getItemCounts(); i++) {
                list.add(Integer.valueOf(i));
            }
        }

        /* access modifiers changed from: protected */
        public void onPopulateEventForVirtualView(int i, AccessibilityEvent accessibilityEvent) {
            accessibilityEvent.getText().add(b(i));
        }

        /* access modifiers changed from: protected */
        public void onPopulateNodeForVirtualView(int i, d dVar) {
            dVar.e(b(i));
            dVar.a(d.a.e);
            dVar.h(true);
            dVar.b(c(i));
        }

        public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onPopulateAccessibilityEvent(view, accessibilityEvent);
        }

        /* access modifiers changed from: protected */
        public boolean onPerformActionForVirtualView(int i, int i2, Bundle bundle) {
            if (i2 != 16) {
                return false;
            }
            return a(i);
        }

        /* access modifiers changed from: package-private */
        public boolean a(int i) {
            invalidateVirtualView(i);
            if (this.f2096a.isEnabled()) {
                this.f2096a.b(i);
                this.f2096a.announceForAccessibility(b(i));
            }
            sendEventForVirtualView(i, 1);
            return true;
        }

        private Rect c(int i) {
            int i2;
            Rect rect = this.f2097b;
            int i3 = 0;
            if (i != -1) {
                Cell a2 = this.f2096a.a(i / 3, i % 3);
                i3 = (int) this.f2096a.c(a2.f2095b);
                i2 = (int) this.f2096a.d(a2.f2094a);
            } else {
                i2 = 0;
            }
            rect.left = i3 - this.f2096a.f;
            rect.right = i3 + this.f2096a.f;
            rect.top = i2 - this.f2096a.f;
            rect.bottom = i2 + this.f2096a.f;
            return rect;
        }

        private int a(float f, float f2) {
            Cell a2 = this.f2096a.a(f, f2);
            if (a2 == null) {
                return -1;
            }
            int column = a2.getColumn() + (a2.getRow() * 3);
            if (column == 9) {
                ColorNumericKeyboard colorNumericKeyboard = this.f2096a;
                if (colorNumericKeyboard.a(colorNumericKeyboard.y)) {
                    column = -1;
                }
            }
            if (column != 11) {
                return column;
            }
            ColorNumericKeyboard colorNumericKeyboard2 = this.f2096a;
            if (colorNumericKeyboard2.a(colorNumericKeyboard2.z)) {
                return -1;
            }
            return column;
        }

        public int getItemCounts() {
            ColorNumericKeyboard colorNumericKeyboard = this.f2096a;
            int i = colorNumericKeyboard.a(colorNumericKeyboard.y) ? 10 : 11;
            ColorNumericKeyboard colorNumericKeyboard2 = this.f2096a;
            return colorNumericKeyboard2.a(colorNumericKeyboard2.z) ? i - 1 : i;
        }

        public CharSequence b(int i) {
            if (i == 9) {
                ColorNumericKeyboard colorNumericKeyboard = this.f2096a;
                if (!colorNumericKeyboard.a(colorNumericKeyboard.y)) {
                    return this.f2096a.y.e;
                }
            }
            if (i == 11) {
                ColorNumericKeyboard colorNumericKeyboard2 = this.f2096a;
                if (!colorNumericKeyboard2.a(colorNumericKeyboard2.z)) {
                    return this.f2096a.z.e;
                }
            }
            if (i == -1) {
                return getClass().getSimpleName();
            }
            return this.f2096a.m[i] + "";
        }
    }
}
