package com.color.support.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import androidx.core.g.a.d;
import androidx.customview.a.a;
import color.support.v7.appcompat.R;
import com.sensetime.stmobile.sticker_module_types.STStickerMakeupParamType;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ColorLockPatternView extends View {
    private int A;
    private int B;
    private final Interpolator C;
    private PatternExploreByTouchHelper D;
    private boolean E;
    private Drawable F;
    private Drawable G;
    /* access modifiers changed from: private */
    public ValueAnimator H;
    private boolean I;
    private Context J;
    private AccessibilityManager K;
    private int L;
    private Interpolator M;
    private Interpolator N;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final CellState[][] f2047a;

    /* renamed from: b  reason: collision with root package name */
    private final int f2048b;
    /* access modifiers changed from: private */
    public float c;
    private final Paint d;
    private final Paint e;
    private OnPatternListener f;
    /* access modifiers changed from: private */
    public final ArrayList<Cell> g;
    /* access modifiers changed from: private */
    public final boolean[][] h;
    private float i;
    private float j;
    private long k;
    private DisplayMode l;
    private boolean m;
    private boolean n;
    private boolean o;
    /* access modifiers changed from: private */
    public boolean p;
    /* access modifiers changed from: private */
    public float q;
    /* access modifiers changed from: private */
    public float r;
    /* access modifiers changed from: private */
    public float s;
    private final float t;
    private final Path u;
    private final Rect v;
    private final Rect w;
    private int x;
    private int y;
    private int z;

    public enum DisplayMode {
        Correct,
        Animate,
        Wrong,
        FingerprintMatch,
        FingerprintNoMatch
    }

    interface OnCellDrawListener {
        void a();
    }

    public interface OnPatternListener {
        void a();

        void a(List<Cell> list);

        void b();

        void b(List<Cell> list);
    }

    public static final class Cell {

        /* renamed from: a  reason: collision with root package name */
        private static final Cell[][] f2063a = a();
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final int f2064b;
        /* access modifiers changed from: private */
        public final int c;

        private static Cell[][] a() {
            Cell[][] cellArr = (Cell[][]) Array.newInstance(Cell.class, new int[]{3, 3});
            for (int i = 0; i < 3; i++) {
                for (int i2 = 0; i2 < 3; i2++) {
                    cellArr[i][i2] = new Cell(i, i2);
                }
            }
            return cellArr;
        }

        private Cell(int i, int i2) {
            b(i, i2);
            this.f2064b = i;
            this.c = i2;
        }

        public int getRow() {
            return this.f2064b;
        }

        public int getColumn() {
            return this.c;
        }

        public static Cell a(int i, int i2) {
            b(i, i2);
            return f2063a[i][i2];
        }

        private static void b(int i, int i2) {
            if (i < 0 || i > 2) {
                throw new IllegalArgumentException("row must be in range 0-2");
            } else if (i2 < 0 || i2 > 2) {
                throw new IllegalArgumentException("column must be in range 0-2");
            }
        }

        public String toString() {
            return "(row=" + this.f2064b + ",clmn=" + this.c + ")";
        }
    }

    public static class CellState {

        /* renamed from: a  reason: collision with root package name */
        float f2065a;

        /* renamed from: b  reason: collision with root package name */
        float f2066b;
        float c;
        float d;
        public float e = Float.MIN_VALUE;
        public float f = Float.MIN_VALUE;
        public ValueAnimator g;
        float h;
        float i;
        float j;
        float k;
        boolean l;
        OnCellDrawListener m;

        public void setCellDrawListener(OnCellDrawListener onCellDrawListener) {
            this.m = onCellDrawListener;
        }

        public void setCellNumberAlpha(float f2) {
            this.d = f2;
            this.m.a();
        }

        public void setCellNumberTranslateY(int i2) {
            this.f2065a = (float) i2;
            this.m.a();
        }

        public void setCellNumberTranslateX(int i2) {
            this.f2066b = (float) i2;
            this.m.a();
        }
    }

    /* renamed from: com.color.support.widget.ColorLockPatternView$1  reason: invalid class name */
    class AnonymousClass1 implements OnCellDrawListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ColorLockPatternView f2049a;

        public void a() {
            this.f2049a.invalidate();
        }
    }

    public CellState[][] getCellStates() {
        return this.f2047a;
    }

    public void setInStealthMode(boolean z2) {
        this.n = z2;
    }

    public void setTactileFeedbackEnabled(boolean z2) {
        this.o = z2;
    }

    public void setOnPatternListener(OnPatternListener onPatternListener) {
        this.f = onPatternListener;
    }

    public void a(DisplayMode displayMode, List<Cell> list) {
        this.g.clear();
        this.g.addAll(list);
        i();
        for (Cell next : list) {
            this.h[next.getRow()][next.getColumn()] = true;
        }
        setDisplayMode(displayMode);
    }

    public void setDisplayMode(DisplayMode displayMode) {
        this.l = displayMode;
        if (displayMode == DisplayMode.Animate) {
            if (this.g.size() != 0) {
                this.k = SystemClock.elapsedRealtime();
                Cell cell = this.g.get(0);
                this.i = b(cell.getColumn());
                this.j = c(cell.getRow());
                i();
            } else {
                throw new IllegalStateException("you must have a pattern to animate if you want to set the display mode to animate");
            }
        }
        if (displayMode == DisplayMode.Wrong) {
            if (this.g.size() > 1) {
                a();
            }
            b();
        }
        if (displayMode == DisplayMode.FingerprintNoMatch) {
            c();
        }
        invalidate();
    }

    private void a() {
        if (this.o) {
            if (this.I) {
                performHapticFeedback(304, 3);
            } else {
                performHapticFeedback(300, 3);
            }
        }
    }

    private void b() {
        this.H = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[]{PropertyValuesHolder.ofKeyframe("pathAlpha", new Keyframe[]{Keyframe.ofFloat(0.0f, 1.0f), Keyframe.ofFloat(0.2f, 0.35f), Keyframe.ofFloat(0.4f, 1.0f), Keyframe.ofFloat(0.6f, 0.15f), Keyframe.ofFloat(0.8f, 0.5f), Keyframe.ofFloat(1.0f, 0.0f)})});
        this.H.setDuration(1000);
        this.H.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float unused = ColorLockPatternView.this.c = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                Iterator it = ColorLockPatternView.this.g.iterator();
                while (it.hasNext()) {
                    Cell cell = (Cell) it.next();
                    CellState cellState = ColorLockPatternView.this.f2047a[cell.f2064b][cell.c];
                    cellState.j = ColorLockPatternView.this.c;
                    cellState.l = ColorLockPatternView.this.c <= 0.1f;
                }
                ColorLockPatternView.this.invalidate();
            }
        });
        this.H.start();
    }

    private void c() {
        ValueAnimator ofPropertyValuesHolder = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[]{PropertyValuesHolder.ofKeyframe("pathAlpha", new Keyframe[]{Keyframe.ofFloat(0.0f, 1.0f), Keyframe.ofFloat(0.2f, 0.35f), Keyframe.ofFloat(0.4f, 1.0f), Keyframe.ofFloat(0.6f, 0.15f), Keyframe.ofFloat(0.8f, 0.5f), Keyframe.ofFloat(1.0f, 0.0f)})});
        ofPropertyValuesHolder.setDuration(1000);
        ofPropertyValuesHolder.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                for (int i = 0; i < 3; i++) {
                    for (int i2 = 0; i2 < 3; i2++) {
                        CellState cellState = ColorLockPatternView.this.f2047a[i][i2];
                        cellState.j = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        cellState.l = cellState.j <= 0.1f;
                    }
                }
                ColorLockPatternView.this.invalidate();
            }
        });
        ofPropertyValuesHolder.start();
    }

    private void d() {
        OnPatternListener onPatternListener = this.f;
        if (onPatternListener != null) {
            onPatternListener.a(this.g);
        }
        this.D.invalidateRoot();
    }

    private void e() {
        a(R.string.lockscreen_access_pattern_start);
        OnPatternListener onPatternListener = this.f;
        if (onPatternListener != null) {
            onPatternListener.a();
        }
    }

    private void f() {
        a(R.string.lockscreen_access_pattern_detected);
        OnPatternListener onPatternListener = this.f;
        if (onPatternListener != null) {
            onPatternListener.b(this.g);
        }
    }

    private void g() {
        a(R.string.lockscreen_access_pattern_cleared);
        OnPatternListener onPatternListener = this.f;
        if (onPatternListener != null) {
            onPatternListener.b();
        }
    }

    /* renamed from: com.color.support.widget.ColorLockPatternView$4  reason: invalid class name */
    class AnonymousClass4 extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ColorLockPatternView f2052a;

        public void onAnimationEnd(Animator animator) {
            this.f2052a.h();
            if (this.f2052a.H != null) {
                this.f2052a.H.removeAllListeners();
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean dispatchHoverEvent(MotionEvent motionEvent) {
        return this.D.dispatchHoverEvent(motionEvent) | super.dispatchHoverEvent(motionEvent);
    }

    /* access modifiers changed from: private */
    public void h() {
        this.g.clear();
        i();
        this.l = DisplayMode.Correct;
        invalidate();
    }

    private void i() {
        for (int i2 = 0; i2 < 3; i2++) {
            for (int i3 = 0; i3 < 3; i3++) {
                this.h[i2][i3] = false;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        this.r = ((float) ((i2 - getPaddingLeft()) - getPaddingRight())) / 3.0f;
        this.s = ((float) ((i3 - getPaddingTop()) - getPaddingBottom())) / 3.0f;
        this.D.invalidateRoot();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        setMeasuredDimension(this.A, this.B);
    }

    private Cell a(float f2, float f3) {
        Cell b2 = b(f2, f3);
        Cell cell = null;
        if (b2 == null) {
            return null;
        }
        ArrayList<Cell> arrayList = this.g;
        if (!arrayList.isEmpty()) {
            int i2 = 1;
            Cell cell2 = arrayList.get(arrayList.size() - 1);
            int a2 = b2.f2064b - cell2.f2064b;
            int b3 = b2.c - cell2.c;
            int a3 = cell2.f2064b;
            int b4 = cell2.c;
            if (Math.abs(a2) == 2 && Math.abs(b3) != 1) {
                a3 = cell2.f2064b + (a2 > 0 ? 1 : -1);
            }
            if (Math.abs(b3) == 2 && Math.abs(a2) != 1) {
                int b5 = cell2.c;
                if (b3 <= 0) {
                    i2 = -1;
                }
                b4 = b5 + i2;
            }
            cell = Cell.a(a3, b4);
        }
        if (cell != null && !this.h[cell.f2064b][cell.c]) {
            a(cell);
        }
        a(b2);
        if (this.o) {
            j();
        }
        return b2;
    }

    private void j() {
        if (this.I) {
            performHapticFeedback(302);
        } else {
            performHapticFeedback(1);
        }
    }

    private void a(Cell cell) {
        this.h[cell.getRow()][cell.getColumn()] = true;
        this.g.add(cell);
        if (!this.n) {
            b(cell);
        }
        d();
    }

    private void b(Cell cell) {
        CellState cellState = this.f2047a[cell.f2064b][cell.c];
        a(cellState);
        b(cellState);
        a(cellState, this.i, this.j, b(cell.c), c(cell.f2064b));
    }

    private void a(final CellState cellState, float f2, float f3, float f4, float f5) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        final CellState cellState2 = cellState;
        final float f6 = f2;
        final float f7 = f4;
        final float f8 = f3;
        final float f9 = f5;
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                CellState cellState = cellState2;
                float f2 = 1.0f - floatValue;
                cellState.e = (f6 * f2) + (f7 * floatValue);
                cellState.f = (f2 * f8) + (floatValue * f9);
                ColorLockPatternView.this.invalidate();
            }
        });
        ofFloat.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                cellState.g = null;
            }
        });
        ofFloat.setInterpolator(this.C);
        ofFloat.setDuration(100);
        ofFloat.start();
        cellState.g = ofFloat;
    }

    private void a(final CellState cellState) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(460);
        animatorSet.setInterpolator(new PathInterpolator(0.0f, 0.0f, 0.1f, 1.0f));
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{1.0f, 7.0f});
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                cellState.i = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                ColorLockPatternView.this.invalidate();
            }
        });
        ValueAnimator ofPropertyValuesHolder = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[]{PropertyValuesHolder.ofKeyframe("alpha", new Keyframe[]{Keyframe.ofFloat(0.0f, 0.0f), Keyframe.ofFloat(0.5f, this.t), Keyframe.ofFloat(1.0f, 0.0f)})});
        ofPropertyValuesHolder.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                cellState.k = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                ColorLockPatternView.this.invalidate();
            }
        });
        animatorSet.play(ofFloat).with(ofPropertyValuesHolder);
        animatorSet.start();
    }

    private void b(final CellState cellState) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        ofFloat.setInterpolator(new PathInterpolator(0.3f, 0.0f, 0.7f, 0.0f));
        ofFloat.setDuration(230);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                cellState.j = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            }
        });
        ofFloat.start();
    }

    private Cell b(float f2, float f3) {
        int b2;
        int a2 = a(f3);
        if (a2 >= 0 && (b2 = b(f2)) >= 0 && !this.h[a2][b2]) {
            return Cell.a(a2, b2);
        }
        return null;
    }

    /* access modifiers changed from: private */
    public int a(float f2) {
        float f3 = this.s;
        float f4 = this.q * f3;
        float paddingTop = ((float) getPaddingTop()) + ((f3 - f4) / 2.0f);
        for (int i2 = 0; i2 < 3; i2++) {
            float f5 = (((float) i2) * f3) + paddingTop;
            if (f2 >= f5 && f2 <= f5 + f4) {
                return i2;
            }
        }
        return -1;
    }

    /* access modifiers changed from: private */
    public int b(float f2) {
        float f3 = this.r;
        float f4 = this.q * f3;
        float paddingLeft = ((float) getPaddingLeft()) + ((f3 - f4) / 2.0f);
        for (int i2 = 0; i2 < 3; i2++) {
            float f5 = (((float) i2) * f3) + paddingLeft;
            if (f2 >= f5 && f2 <= f5 + f4) {
                return i2;
            }
        }
        return -1;
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        if (this.K.isTouchExplorationEnabled()) {
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

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.m || !isEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            ValueAnimator valueAnimator = this.H;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.H.end();
            }
            b(motionEvent);
            return true;
        } else if (action == 1) {
            k();
            return true;
        } else if (action == 2) {
            a(motionEvent);
            return true;
        } else if (action != 3) {
            return false;
        } else {
            if (this.p) {
                setPatternInProgress(false);
                h();
                g();
            }
            return true;
        }
    }

    private void setPatternInProgress(boolean z2) {
        this.p = z2;
        this.D.invalidateRoot();
    }

    private void a(MotionEvent motionEvent) {
        float f2 = (float) this.f2048b;
        int historySize = motionEvent.getHistorySize();
        this.w.setEmpty();
        int i2 = 0;
        boolean z2 = false;
        while (i2 < historySize + 1) {
            float historicalX = i2 < historySize ? motionEvent.getHistoricalX(i2) : motionEvent.getX();
            float historicalY = i2 < historySize ? motionEvent.getHistoricalY(i2) : motionEvent.getY();
            Cell a2 = a(historicalX, historicalY);
            int size = this.g.size();
            if (a2 != null && size == 1) {
                setPatternInProgress(true);
                e();
            }
            float abs = Math.abs(historicalX - this.i);
            float abs2 = Math.abs(historicalY - this.j);
            if (abs > 0.0f || abs2 > 0.0f) {
                z2 = true;
            }
            if (this.p && size > 0) {
                Cell cell = this.g.get(size - 1);
                float b2 = b(cell.c);
                float c2 = c(cell.f2064b);
                float min = Math.min(b2, historicalX) - f2;
                float max = Math.max(b2, historicalX) + f2;
                float min2 = Math.min(c2, historicalY) - f2;
                float max2 = Math.max(c2, historicalY) + f2;
                if (a2 != null) {
                    float f3 = this.r * 0.5f;
                    float f4 = this.s * 0.5f;
                    float b3 = b(a2.c);
                    float c3 = c(a2.f2064b);
                    min = Math.min(b3 - f3, min);
                    max = Math.max(b3 + f3, max);
                    min2 = Math.min(c3 - f4, min2);
                    max2 = Math.max(c3 + f4, max2);
                }
                this.w.union(Math.round(min), Math.round(min2), Math.round(max), Math.round(max2));
            }
            i2++;
        }
        this.i = motionEvent.getX();
        this.j = motionEvent.getY();
        if (z2) {
            this.v.union(this.w);
            invalidate(this.v);
            this.v.set(this.w);
        }
    }

    private void a(int i2) {
        announceForAccessibility(this.J.getString(i2));
    }

    private void k() {
        if (!this.g.isEmpty()) {
            setPatternInProgress(false);
            l();
            f();
            invalidate();
        }
    }

    private void l() {
        for (int i2 = 0; i2 < 3; i2++) {
            for (int i3 = 0; i3 < 3; i3++) {
                CellState cellState = this.f2047a[i2][i3];
                if (cellState.g != null) {
                    cellState.g.cancel();
                    cellState.e = Float.MIN_VALUE;
                    cellState.f = Float.MIN_VALUE;
                }
            }
        }
    }

    private void b(MotionEvent motionEvent) {
        this.c = 1.0f;
        h();
        float x2 = motionEvent.getX();
        float y2 = motionEvent.getY();
        Cell a2 = a(x2, y2);
        if (a2 != null) {
            setPatternInProgress(true);
            this.l = DisplayMode.Correct;
            e();
        } else if (this.p) {
            setPatternInProgress(false);
            g();
        }
        if (a2 != null) {
            float b2 = b(a2.c);
            float c2 = c(a2.f2064b);
            float f2 = this.r / 2.0f;
            float f3 = this.s / 2.0f;
            invalidate((int) (b2 - f2), (int) (c2 - f3), (int) (b2 + f2), (int) (c2 + f3));
        }
        this.i = x2;
        this.j = y2;
    }

    /* access modifiers changed from: private */
    public float b(int i2) {
        float f2 = this.r;
        return ((float) getPaddingLeft()) + (((float) i2) * f2) + (f2 / 2.0f);
    }

    /* access modifiers changed from: private */
    public float c(int i2) {
        float f2 = this.s;
        return ((float) getPaddingTop()) + (((float) i2) * f2) + (f2 / 2.0f);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        float f2;
        float f3;
        CellState cellState;
        float f4;
        ColorLockPatternView colorLockPatternView = this;
        ArrayList<Cell> arrayList = colorLockPatternView.g;
        int size = arrayList.size();
        boolean[][] zArr = colorLockPatternView.h;
        if (colorLockPatternView.l == DisplayMode.Animate) {
            int elapsedRealtime = ((int) (SystemClock.elapsedRealtime() - colorLockPatternView.k)) % ((size + 1) * STStickerMakeupParamType.ST_STICKER_PARAM_MAKEUP_FLOAT_SCALE);
            int i2 = elapsedRealtime / STStickerMakeupParamType.ST_STICKER_PARAM_MAKEUP_FLOAT_SCALE;
            i();
            for (int i3 = 0; i3 < i2; i3++) {
                Cell cell = arrayList.get(i3);
                zArr[cell.getRow()][cell.getColumn()] = true;
            }
            if (i2 > 0 && i2 < size) {
                float f5 = ((float) (elapsedRealtime % STStickerMakeupParamType.ST_STICKER_PARAM_MAKEUP_FLOAT_SCALE)) / 700.0f;
                Cell cell2 = arrayList.get(i2 - 1);
                float b2 = colorLockPatternView.b(cell2.c);
                float c2 = colorLockPatternView.c(cell2.f2064b);
                Cell cell3 = arrayList.get(i2);
                colorLockPatternView.i = b2 + ((colorLockPatternView.b(cell3.c) - b2) * f5);
                colorLockPatternView.j = c2 + (f5 * (colorLockPatternView.c(cell3.f2064b) - c2));
            }
            invalidate();
        }
        Path path = colorLockPatternView.u;
        path.rewind();
        if (!colorLockPatternView.n) {
            colorLockPatternView.e.setColor(colorLockPatternView.a(true));
            colorLockPatternView.e.setAlpha((int) (colorLockPatternView.c * 255.0f));
            float f6 = 0.0f;
            float f7 = 0.0f;
            int i4 = 0;
            boolean z2 = false;
            while (i4 < size) {
                Cell cell4 = arrayList.get(i4);
                if (!zArr[cell4.f2064b][cell4.c]) {
                    break;
                }
                f6 = colorLockPatternView.b(cell4.c);
                f7 = colorLockPatternView.c(cell4.f2064b);
                if (i4 == 0) {
                    path.rewind();
                    path.moveTo(f6, f7);
                }
                if (i4 != 0) {
                    CellState cellState2 = colorLockPatternView.f2047a[cell4.f2064b][cell4.c];
                    if (cellState2.e == Float.MIN_VALUE || cellState2.f == Float.MIN_VALUE) {
                        path.lineTo(f6, f7);
                    } else {
                        path.lineTo(cellState2.e, cellState2.f);
                    }
                }
                i4++;
                z2 = true;
            }
            if ((colorLockPatternView.p || colorLockPatternView.l == DisplayMode.Animate) && z2) {
                path.moveTo(f6, f7);
                path.lineTo(colorLockPatternView.i, colorLockPatternView.j);
            }
            canvas.drawPath(path, colorLockPatternView.e);
        } else {
            Canvas canvas2 = canvas;
        }
        int i5 = 0;
        while (true) {
            int i6 = 3;
            if (i5 < 3) {
                float c3 = colorLockPatternView.c(i5);
                int i7 = 0;
                while (i7 < i6) {
                    CellState cellState3 = colorLockPatternView.f2047a[i5][i7];
                    float b3 = colorLockPatternView.b(i7);
                    float f8 = cellState3.f2065a;
                    float f9 = cellState3.f2066b;
                    boolean z3 = zArr[i5][i7];
                    if (z3 || colorLockPatternView.l == DisplayMode.FingerprintNoMatch) {
                        f2 = f9;
                        f3 = f8;
                        f4 = b3;
                        cellState = cellState3;
                        a(canvas, ((float) ((int) b3)) + f9, ((float) ((int) c3)) + f8, cellState3.h, cellState3.j, cellState3.i, cellState3.k);
                    } else {
                        f2 = f9;
                        f3 = f8;
                        f4 = b3;
                        cellState = cellState3;
                    }
                    if (cellState.l) {
                        a(canvas, ((float) ((int) f4)) + f2, ((float) ((int) c3)) + f3, cellState.c, z3, cellState.d);
                    }
                    i7++;
                    i6 = 3;
                    colorLockPatternView = this;
                }
                i5++;
                colorLockPatternView = this;
            } else {
                return;
            }
        }
    }

    private int a(boolean z2) {
        if (this.l == DisplayMode.Wrong || this.l == DisplayMode.FingerprintNoMatch) {
            return this.y;
        }
        if (this.l == DisplayMode.Correct || this.l == DisplayMode.Animate || this.l == DisplayMode.FingerprintMatch) {
            return this.z;
        }
        if (!z2 || this.n || this.p) {
            return this.x;
        }
        throw new IllegalStateException("unknown display mode " + this.l);
    }

    private void a(Canvas canvas, float f2, float f3, float f4, boolean z2, float f5) {
        this.d.setColor(this.x);
        this.d.setAlpha((int) (f5 * 255.0f));
        canvas.drawCircle(f2, f3, f4, this.d);
    }

    private void a(Canvas canvas, float f2, float f3, float f4, float f5, float f6, float f7) {
        canvas.save();
        int intrinsicWidth = this.F.getIntrinsicWidth();
        float f8 = (float) (intrinsicWidth / 2);
        int i2 = (int) (f2 - f8);
        int i3 = (int) (f3 - f8);
        canvas.scale(f4, f4, f2, f3);
        this.F.setTint(a(true));
        this.F.setBounds(i2, i3, i2 + intrinsicWidth, intrinsicWidth + i3);
        this.F.setAlpha((int) (f5 * 255.0f));
        this.F.draw(canvas);
        canvas.restore();
        canvas.save();
        int intrinsicWidth2 = this.G.getIntrinsicWidth();
        float f9 = (float) (intrinsicWidth2 / 2);
        int i4 = (int) (f2 - f9);
        int i5 = (int) (f3 - f9);
        canvas.scale(f6, f6, f2, f3);
        this.G.setTint(a(true));
        this.G.setBounds(i4, i5, i4 + intrinsicWidth2, intrinsicWidth2 + i5);
        this.G.setAlpha((int) (f7 * 255.0f));
        this.G.draw(canvas);
        canvas.restore();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ValueAnimator valueAnimator = this.H;
        if (valueAnimator != null) {
            valueAnimator.removeAllUpdateListeners();
            this.H.removeAllListeners();
            this.H = null;
        }
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), f.a((List<Cell>) this.g), this.l.ordinal(), this.m, this.n, this.o, (AnonymousClass1) null);
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        a(DisplayMode.Correct, f.a(savedState.getSerializedPattern()));
        this.l = DisplayMode.values()[savedState.getDisplayMode()];
        this.m = savedState.isInputEnabled();
        this.n = savedState.isInStealthMode();
        this.o = savedState.isTactileFeedbackEnabled();
    }

    private static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, (AnonymousClass1) null);
            }

            /* renamed from: a */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        private final int mDisplayMode;
        private final boolean mInStealthMode;
        private final boolean mInputEnabled;
        private final String mSerializedPattern;
        private final boolean mTactileFeedbackEnabled;

        /* synthetic */ SavedState(Parcel parcel, AnonymousClass1 r2) {
            this(parcel);
        }

        /* synthetic */ SavedState(Parcelable parcelable, String str, int i, boolean z, boolean z2, boolean z3, AnonymousClass1 r7) {
            this(parcelable, str, i, z, z2, z3);
        }

        private SavedState(Parcelable parcelable, String str, int i, boolean z, boolean z2, boolean z3) {
            super(parcelable);
            this.mSerializedPattern = str;
            this.mDisplayMode = i;
            this.mInputEnabled = z;
            this.mInStealthMode = z2;
            this.mTactileFeedbackEnabled = z3;
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.mSerializedPattern = parcel.readString();
            this.mDisplayMode = parcel.readInt();
            this.mInputEnabled = ((Boolean) parcel.readValue((ClassLoader) null)).booleanValue();
            this.mInStealthMode = ((Boolean) parcel.readValue((ClassLoader) null)).booleanValue();
            this.mTactileFeedbackEnabled = ((Boolean) parcel.readValue((ClassLoader) null)).booleanValue();
        }

        public String getSerializedPattern() {
            return this.mSerializedPattern;
        }

        public int getDisplayMode() {
            return this.mDisplayMode;
        }

        public boolean isInputEnabled() {
            return this.mInputEnabled;
        }

        public boolean isInStealthMode() {
            return this.mInStealthMode;
        }

        public boolean isTactileFeedbackEnabled() {
            return this.mTactileFeedbackEnabled;
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.mSerializedPattern);
            parcel.writeInt(this.mDisplayMode);
            parcel.writeValue(Boolean.valueOf(this.mInputEnabled));
            parcel.writeValue(Boolean.valueOf(this.mInStealthMode));
            parcel.writeValue(Boolean.valueOf(this.mTactileFeedbackEnabled));
        }
    }

    private final class PatternExploreByTouchHelper extends a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ColorLockPatternView f2067a;

        /* renamed from: b  reason: collision with root package name */
        private Rect f2068b;
        private final SparseArray<VirtualViewContainer> c;

        class VirtualViewContainer {

            /* renamed from: a  reason: collision with root package name */
            CharSequence f2069a;
        }

        /* access modifiers changed from: protected */
        public int getVirtualViewAt(float f, float f2) {
            return a(f, f2);
        }

        /* access modifiers changed from: protected */
        public void getVisibleVirtualViews(List<Integer> list) {
            if (this.f2067a.p) {
                for (int i = 1; i < 10; i++) {
                    list.add(Integer.valueOf(i));
                }
            }
        }

        /* access modifiers changed from: protected */
        public void onPopulateEventForVirtualView(int i, AccessibilityEvent accessibilityEvent) {
            VirtualViewContainer virtualViewContainer = this.c.get(i);
            if (virtualViewContainer != null) {
                accessibilityEvent.getText().add(virtualViewContainer.f2069a);
            }
        }

        /* access modifiers changed from: protected */
        public void onPopulateNodeForVirtualView(int i, d dVar) {
            dVar.c(d(i));
            dVar.e(d(i));
            if (this.f2067a.p) {
                dVar.c(true);
                if (b(i)) {
                    dVar.a(d.a.e);
                    dVar.h(b(i));
                }
            }
            dVar.b(c(i));
        }

        public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onPopulateAccessibilityEvent(view, accessibilityEvent);
            if (!this.f2067a.p) {
                accessibilityEvent.setContentDescription(this.f2067a.getContext().getText(R.string.lockscreen_access_pattern_area));
            }
        }

        private boolean b(int i) {
            if (i == Integer.MIN_VALUE) {
                return false;
            }
            int i2 = i - 1;
            return !this.f2067a.h[i2 / 3][i2 % 3];
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
            sendEventForVirtualView(i, 1);
            return true;
        }

        private Rect c(int i) {
            int i2 = i - 1;
            Rect rect = this.f2068b;
            int i3 = i2 / 3;
            int i4 = i2 % 3;
            CellState cellState = this.f2067a.f2047a[i3][i4];
            float a2 = this.f2067a.b(i4);
            float b2 = this.f2067a.c(i3);
            float h = this.f2067a.s * this.f2067a.q * 0.5f;
            float j = this.f2067a.r * this.f2067a.q * 0.5f;
            rect.left = (int) (a2 - j);
            rect.right = (int) (a2 + j);
            rect.top = (int) (b2 - h);
            rect.bottom = (int) (b2 + h);
            return rect;
        }

        private CharSequence d(int i) {
            return this.f2067a.getResources().getString(R.string.lockscreen_access_pattern_cell_added_verbose, new Object[]{String.valueOf(i)});
        }

        private int a(float f, float f2) {
            int c2;
            int b2 = this.f2067a.a(f2);
            if (b2 < 0 || (c2 = this.f2067a.b(f)) < 0) {
                return Integer.MIN_VALUE;
            }
            boolean z = this.f2067a.h[b2][c2];
            int i = (b2 * 3) + c2 + 1;
            if (z) {
                return i;
            }
            return Integer.MIN_VALUE;
        }
    }

    public void setLockPassword(boolean z2) {
        this.E = z2;
    }

    @Deprecated
    public Animator getFailAnimator() {
        return ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
    }

    @Deprecated
    public Animator getSuccessAnimator() {
        return ValueAnimator.ofInt(new int[]{255, 0});
    }

    public AnimatorSet getEnterAnim() {
        AnimatorSet animatorSet = new AnimatorSet();
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < 3; i2++) {
            for (int i3 = 0; i3 < 3; i3++) {
                a(this.f2047a[i2][i3], arrayList, (i2 * 3) + i3);
            }
        }
        animatorSet.playTogether(arrayList);
        return animatorSet;
    }

    private void a(CellState cellState, List<Animator> list, int i2) {
        cellState.setCellNumberAlpha(0.0f);
        cellState.setCellNumberTranslateY(this.L);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(cellState, "cellNumberAlpha", new float[]{0.0f, 1.0f});
        long j2 = ((long) i2) * 16;
        ofFloat.setStartDelay(166 + j2);
        ofFloat.setDuration(167);
        ofFloat.setInterpolator(this.M);
        list.add(ofFloat);
        ObjectAnimator ofInt = ObjectAnimator.ofInt(cellState, "cellNumberTranslateY", new int[]{this.L, 0});
        ofInt.setStartDelay(j2);
        ofInt.setDuration(500);
        ofInt.setInterpolator(this.N);
        list.add(ofInt);
    }
}
