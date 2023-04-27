package com.color.support.dialog.panel;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowInsets;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.g.a.d;
import androidx.core.g.a.g;
import androidx.core.g.v;
import androidx.customview.a.c;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.sensetime.stmobile.STMobileHumanActionNative;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ColorGuideBehavior<V extends View> extends BottomSheetBehavior<V> {
    private static final int E = R.style.Widget_Design_BottomSheet_Modal;
    private ShapeAppearanceModel A;
    private boolean B;
    private ColorGuideBehavior<V>.b C = null;
    private ValueAnimator D;
    /* access modifiers changed from: private */
    public boolean F;
    /* access modifiers changed from: private */
    public boolean G = true;
    private boolean H;
    private int I;
    private boolean J;
    private final ArrayList<a> K = new ArrayList<>();
    private VelocityTracker L;
    private int M;
    private int N;
    private Map<View, Integer> O;
    /* access modifiers changed from: private */
    public e P;
    /* access modifiers changed from: private */
    public boolean Q;
    /* access modifiers changed from: private */
    public boolean R;
    private final c.a S = new c.a() {
        public boolean tryCaptureView(View view, int i) {
            if (ColorGuideBehavior.this.h == 1 || ColorGuideBehavior.this.o) {
                return false;
            }
            if (ColorGuideBehavior.this.h == 3 && ColorGuideBehavior.this.n == i) {
                View view2 = ColorGuideBehavior.this.m != null ? (View) ColorGuideBehavior.this.m.get() : null;
                if (view2 != null && view2.canScrollVertically(-1)) {
                    return false;
                }
            }
            if (ColorGuideBehavior.this.l == null || ColorGuideBehavior.this.l.get() != view) {
                return false;
            }
            return true;
        }

        public void onViewPositionChanged(View view, int i, int i2, int i3, int i4) {
            ColorGuideBehavior.this.dispatchOnSlide(i2);
        }

        public void onViewDragStateChanged(int i) {
            if (i == 1 && ColorGuideBehavior.this.G) {
                ColorGuideBehavior.this.setStateInternal(1);
            }
        }

        private boolean a(View view) {
            return view.getTop() > (ColorGuideBehavior.this.k + ColorGuideBehavior.this.getExpandedOffset()) / 2;
        }

        public void onViewReleased(View view, float f, float f2) {
            int i;
            int i2;
            if (ColorGuideBehavior.this.P == null || ColorGuideBehavior.this.k - view.getHeight() >= ColorGuideBehavior.this.getExpandedOffset() || view.getTop() >= ColorGuideBehavior.this.getExpandedOffset()) {
                int i3 = 4;
                if (f2 < 0.0f) {
                    if (ColorGuideBehavior.this.r) {
                        i = ColorGuideBehavior.this.f1893b;
                    } else if (view.getTop() > ColorGuideBehavior.this.c) {
                        i2 = ColorGuideBehavior.this.c;
                        i3 = 6;
                        ColorGuideBehavior.this.startSettlingAnimation(view, i3, i, true);
                        return;
                    } else {
                        i = ColorGuideBehavior.this.f1892a;
                    }
                } else if (!ColorGuideBehavior.this.g || !ColorGuideBehavior.this.shouldHide(view, f2)) {
                    if (f2 == 0.0f || Math.abs(f) > Math.abs(f2)) {
                        int top = view.getTop();
                        if (!ColorGuideBehavior.this.r) {
                            if (top < ColorGuideBehavior.this.c) {
                                if (top < Math.abs(top - ColorGuideBehavior.this.e)) {
                                    i = ColorGuideBehavior.this.f1892a;
                                } else {
                                    i2 = ColorGuideBehavior.this.c;
                                }
                            } else if (Math.abs(top - ColorGuideBehavior.this.c) < Math.abs(top - ColorGuideBehavior.this.e)) {
                                i2 = ColorGuideBehavior.this.c;
                            } else {
                                i = ColorGuideBehavior.this.e;
                                ColorGuideBehavior.this.startSettlingAnimation(view, i3, i, true);
                                return;
                            }
                            i3 = 6;
                            ColorGuideBehavior.this.startSettlingAnimation(view, i3, i, true);
                            return;
                        } else if (Math.abs(top - ColorGuideBehavior.this.f1893b) < Math.abs(top - ColorGuideBehavior.this.e)) {
                            i = ColorGuideBehavior.this.f1893b;
                        } else {
                            i = ColorGuideBehavior.this.e;
                            ColorGuideBehavior.this.startSettlingAnimation(view, i3, i, true);
                            return;
                        }
                    } else {
                        if (ColorGuideBehavior.this.r) {
                            i = ColorGuideBehavior.this.e;
                        } else {
                            int top2 = view.getTop();
                            if (Math.abs(top2 - ColorGuideBehavior.this.c) < Math.abs(top2 - ColorGuideBehavior.this.e)) {
                                i2 = ColorGuideBehavior.this.c;
                                i3 = 6;
                            } else {
                                i = ColorGuideBehavior.this.e;
                            }
                        }
                        ColorGuideBehavior.this.startSettlingAnimation(view, i3, i, true);
                        return;
                    }
                } else if (ColorGuideBehavior.this.p != null && ColorGuideBehavior.this.p.a()) {
                    i = ColorGuideBehavior.this.f1893b;
                    boolean unused = ColorGuideBehavior.this.R = false;
                } else if ((Math.abs(f) < Math.abs(f2) && f2 > 500.0f) || a(view)) {
                    i = ColorGuideBehavior.this.k;
                    i3 = 5;
                    boolean unused2 = ColorGuideBehavior.this.R = true;
                    ColorGuideBehavior.this.startSettlingAnimation(view, i3, i, true);
                    return;
                } else if (ColorGuideBehavior.this.r) {
                    i = ColorGuideBehavior.this.f1893b;
                } else if (Math.abs(view.getTop() - ColorGuideBehavior.this.f1892a) < Math.abs(view.getTop() - ColorGuideBehavior.this.c)) {
                    i = ColorGuideBehavior.this.f1892a;
                } else {
                    i2 = ColorGuideBehavior.this.c;
                    i3 = 6;
                    ColorGuideBehavior.this.startSettlingAnimation(view, i3, i, true);
                    return;
                }
                i3 = 3;
                ColorGuideBehavior.this.startSettlingAnimation(view, i3, i, true);
                return;
            }
            ColorGuideBehavior.this.P.a(ColorGuideBehavior.this.getExpandedOffset());
        }

        public int clampViewPositionVertical(View view, int i, int i2) {
            int i3 = 0;
            if (ColorGuideBehavior.this.P != null) {
                if (ColorGuideBehavior.this.h == 3 || (ColorGuideBehavior.this.h == 1 && view.getTop() <= ColorGuideBehavior.this.getExpandedOffset())) {
                    boolean unused = ColorGuideBehavior.this.Q = true;
                    i3 = ColorGuideBehavior.this.P.a(i2, ColorGuideBehavior.this.getExpandedOffset());
                }
            }
            return androidx.core.b.a.a(i, ColorGuideBehavior.this.getExpandedOffset() - i3, ColorGuideBehavior.this.g ? ColorGuideBehavior.this.k : ColorGuideBehavior.this.e);
        }

        public int clampViewPositionHorizontal(View view, int i, int i2) {
            return view.getLeft();
        }

        public int getViewVerticalDragRange(View view) {
            if (ColorGuideBehavior.this.g) {
                return ColorGuideBehavior.this.k;
            }
            return ColorGuideBehavior.this.e;
        }
    };

    /* renamed from: a  reason: collision with root package name */
    int f1892a;

    /* renamed from: b  reason: collision with root package name */
    int f1893b;
    int c;
    float d = 0.5f;
    int e;
    float f = -1.0f;
    boolean g;
    int h = 4;
    c i;
    int j;
    int k;
    WeakReference<V> l;
    WeakReference<View> m;
    int n;
    boolean o;
    d p;
    private int q = 0;
    /* access modifiers changed from: private */
    public boolean r = true;
    private boolean s = false;
    private float t;
    /* access modifiers changed from: private */
    public int u;
    private boolean v;
    private int w;
    private boolean x;
    /* access modifiers changed from: private */
    public MaterialShapeDrawable y;
    private boolean z;

    public static abstract class a {
        public abstract void a(View view, float f);

        public abstract void a(View view, int i);
    }

    public void onNestedScroll(CoordinatorLayout coordinatorLayout, V v2, View view, int i2, int i3, int i4, int i5, int i6, int[] iArr) {
    }

    public ColorGuideBehavior() {
    }

    public ColorGuideBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.BottomSheetBehavior_Layout);
        this.x = obtainStyledAttributes.hasValue(R.styleable.BottomSheetBehavior_Layout_shapeAppearance);
        boolean hasValue = obtainStyledAttributes.hasValue(R.styleable.BottomSheetBehavior_Layout_backgroundTint);
        if (hasValue) {
            a(context, attributeSet, hasValue, MaterialResources.getColorStateList(context, obtainStyledAttributes, R.styleable.BottomSheetBehavior_Layout_backgroundTint));
        } else {
            a(context, attributeSet, hasValue);
        }
        e();
        if (Build.VERSION.SDK_INT >= 21) {
            this.f = obtainStyledAttributes.getDimension(R.styleable.BottomSheetBehavior_Layout_android_elevation, -1.0f);
        }
        TypedValue peekValue = obtainStyledAttributes.peekValue(R.styleable.BottomSheetBehavior_Layout_behavior_peekHeight);
        if (peekValue == null || peekValue.data != -1) {
            setPeekHeight(obtainStyledAttributes.getDimensionPixelSize(R.styleable.BottomSheetBehavior_Layout_behavior_peekHeight, -1));
        } else {
            setPeekHeight(peekValue.data);
        }
        setHideable(obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_hideable, false));
        setGestureInsetBottomIgnored(obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_gestureInsetBottomIgnored, false));
        setFitToContents(obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_fitToContents, true));
        setSkipCollapsed(obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_skipCollapsed, false));
        setDraggable(obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_draggable, true));
        setSaveFlags(obtainStyledAttributes.getInt(R.styleable.BottomSheetBehavior_Layout_behavior_saveFlags, 0));
        setHalfExpandedRatio(obtainStyledAttributes.getFloat(R.styleable.BottomSheetBehavior_Layout_behavior_halfExpandedRatio, 0.5f));
        TypedValue peekValue2 = obtainStyledAttributes.peekValue(R.styleable.BottomSheetBehavior_Layout_behavior_expandedOffset);
        if (peekValue2 == null || peekValue2.type != 16) {
            setExpandedOffset(obtainStyledAttributes.getDimensionPixelOffset(R.styleable.BottomSheetBehavior_Layout_behavior_expandedOffset, 0));
        } else {
            setExpandedOffset(peekValue2.data);
        }
        obtainStyledAttributes.recycle();
        this.t = (float) ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
        this.R = false;
    }

    public Parcelable onSaveInstanceState(CoordinatorLayout coordinatorLayout, V v2) {
        return new SavedState(super.onSaveInstanceState(coordinatorLayout, v2), (ColorGuideBehavior<?>) this);
    }

    public void onRestoreInstanceState(CoordinatorLayout coordinatorLayout, V v2, Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(coordinatorLayout, v2, savedState.getSuperState());
        a(savedState);
        if (savedState.state == 1 || savedState.state == 2) {
            this.h = 4;
        } else {
            this.h = savedState.state;
        }
    }

    public void onAttachedToLayoutParams(CoordinatorLayout.e eVar) {
        super.onAttachedToLayoutParams(eVar);
        this.l = null;
        this.i = null;
    }

    public void onDetachedFromLayoutParams() {
        super.onDetachedFromLayoutParams();
        this.l = null;
        this.i = null;
    }

    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, V v2, int i2) {
        MaterialShapeDrawable materialShapeDrawable;
        if (v.t(coordinatorLayout) && !v.t(v2)) {
            v2.setFitsSystemWindows(true);
        }
        if (this.l == null) {
            this.w = coordinatorLayout.getResources().getDimensionPixelSize(R.dimen.design_bottom_sheet_peek_height_min);
            a(coordinatorLayout);
            this.l = new WeakReference<>(v2);
            if (this.x && (materialShapeDrawable = this.y) != null) {
                v.a((View) v2, (Drawable) materialShapeDrawable);
            }
            MaterialShapeDrawable materialShapeDrawable2 = this.y;
            if (materialShapeDrawable2 != null) {
                float f2 = this.f;
                if (f2 == -1.0f) {
                    f2 = v.o(v2);
                }
                materialShapeDrawable2.setElevation(f2);
                this.B = this.h == 3;
                this.y.setInterpolation(this.B ? 0.0f : 1.0f);
            }
            g();
            if (v.f(v2) == 0) {
                v.b((View) v2, 1);
            }
        }
        if (this.i == null) {
            this.i = c.a((ViewGroup) coordinatorLayout, this.S);
        }
        int top = v2.getTop();
        coordinatorLayout.onLayoutChild(v2, i2);
        this.j = coordinatorLayout.getWidth();
        this.k = coordinatorLayout.getHeight();
        if (!this.Q) {
            this.f1893b = Math.max(0, this.k - v2.getHeight());
        }
        this.Q = false;
        c();
        b();
        int i3 = this.h;
        if (i3 == 3) {
            v.e(v2, getExpandedOffset());
        } else if (i3 == 6) {
            v.e(v2, this.c);
        } else if (!this.g || i3 != 5) {
            int i4 = this.h;
            if (i4 == 4) {
                v.e(v2, this.e);
            } else if (i4 == 1 || i4 == 2) {
                v.e(v2, top - v2.getTop());
            }
        } else {
            v.e(v2, this.k);
        }
        this.m = new WeakReference<>(findScrollingChild(v2));
        return true;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v16, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: android.view.View} */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002e, code lost:
        if (r0 != 3) goto L_0x008c;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onInterceptTouchEvent(androidx.coordinatorlayout.widget.CoordinatorLayout r10, V r11, android.view.MotionEvent r12) {
        /*
            r9 = this;
            boolean r0 = r11.isShown()
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x011a
            boolean r0 = r9.G
            if (r0 != 0) goto L_0x000e
            goto L_0x011a
        L_0x000e:
            int r0 = r12.getActionMasked()
            if (r0 != 0) goto L_0x0017
            r9.d()
        L_0x0017:
            android.view.VelocityTracker r3 = r9.L
            if (r3 != 0) goto L_0x0021
            android.view.VelocityTracker r3 = android.view.VelocityTracker.obtain()
            r9.L = r3
        L_0x0021:
            android.view.VelocityTracker r3 = r9.L
            r3.addMovement(r12)
            r3 = 0
            r4 = 2
            r5 = -1
            if (r0 == 0) goto L_0x0043
            if (r0 == r2) goto L_0x0031
            r11 = 3
            if (r0 == r11) goto L_0x0038
            goto L_0x008c
        L_0x0031:
            com.color.support.dialog.panel.e r11 = r9.P
            if (r11 == 0) goto L_0x0038
            r11.a()
        L_0x0038:
            r9.o = r1
            r9.n = r5
            boolean r11 = r9.H
            if (r11 == 0) goto L_0x008c
            r9.H = r1
            return r1
        L_0x0043:
            float r6 = r12.getX()
            int r6 = (int) r6
            r9.M = r6
            float r6 = r12.getY()
            int r6 = (int) r6
            r9.N = r6
            int r6 = r9.h
            if (r6 == r4) goto L_0x0079
            java.lang.ref.WeakReference<android.view.View> r6 = r9.m
            if (r6 == 0) goto L_0x0060
            java.lang.Object r6 = r6.get()
            android.view.View r6 = (android.view.View) r6
            goto L_0x0061
        L_0x0060:
            r6 = r3
        L_0x0061:
            if (r6 == 0) goto L_0x0079
            int r7 = r9.M
            int r8 = r9.N
            boolean r6 = r10.isPointInChildBounds(r6, r7, r8)
            if (r6 == 0) goto L_0x0079
            int r6 = r12.getActionIndex()
            int r6 = r12.getPointerId(r6)
            r9.n = r6
            r9.o = r2
        L_0x0079:
            int r6 = r9.n
            if (r6 != r5) goto L_0x0089
            int r5 = r9.M
            int r6 = r9.N
            boolean r11 = r10.isPointInChildBounds(r11, r5, r6)
            if (r11 != 0) goto L_0x0089
            r11 = r2
            goto L_0x008a
        L_0x0089:
            r11 = r1
        L_0x008a:
            r9.H = r11
        L_0x008c:
            boolean r11 = r9.H
            if (r11 != 0) goto L_0x009b
            androidx.customview.a.c r11 = r9.i
            if (r11 == 0) goto L_0x009b
            boolean r11 = r11.a((android.view.MotionEvent) r12)
            if (r11 == 0) goto L_0x009b
            return r2
        L_0x009b:
            int r11 = r9.N
            float r11 = (float) r11
            float r5 = r12.getY()
            float r11 = r11 - r5
            float r11 = java.lang.Math.abs(r11)
            int r5 = r9.M
            float r5 = (float) r5
            float r6 = r12.getX()
            float r5 = r5 - r6
            float r5 = java.lang.Math.abs(r5)
            r6 = 1073741824(0x40000000, float:2.0)
            float r5 = r5 * r6
            int r11 = (r11 > r5 ? 1 : (r11 == r5 ? 0 : -1))
            if (r11 <= 0) goto L_0x00d6
            androidx.customview.a.c r11 = r9.i
            if (r11 == 0) goto L_0x00d6
            int r11 = r9.N
            float r11 = (float) r11
            float r5 = r12.getY()
            float r11 = r11 - r5
            float r11 = java.lang.Math.abs(r11)
            androidx.customview.a.c r5 = r9.i
            int r5 = r5.d()
            float r5 = (float) r5
            int r11 = (r11 > r5 ? 1 : (r11 == r5 ? 0 : -1))
            if (r11 <= 0) goto L_0x00d6
            return r2
        L_0x00d6:
            java.lang.ref.WeakReference<android.view.View> r11 = r9.m
            if (r11 == 0) goto L_0x00e1
            java.lang.Object r11 = r11.get()
            r3 = r11
            android.view.View r3 = (android.view.View) r3
        L_0x00e1:
            if (r0 != r4) goto L_0x0119
            if (r3 == 0) goto L_0x0119
            boolean r11 = r9.H
            if (r11 != 0) goto L_0x0119
            int r11 = r9.h
            if (r11 == r2) goto L_0x0119
            float r11 = r12.getX()
            int r11 = (int) r11
            float r0 = r12.getY()
            int r0 = (int) r0
            boolean r10 = r10.isPointInChildBounds(r3, r11, r0)
            if (r10 != 0) goto L_0x0119
            androidx.customview.a.c r10 = r9.i
            if (r10 == 0) goto L_0x0119
            int r10 = r9.N
            float r10 = (float) r10
            float r11 = r12.getY()
            float r10 = r10 - r11
            float r10 = java.lang.Math.abs(r10)
            androidx.customview.a.c r11 = r9.i
            int r11 = r11.d()
            float r11 = (float) r11
            int r10 = (r10 > r11 ? 1 : (r10 == r11 ? 0 : -1))
            if (r10 <= 0) goto L_0x0119
            r1 = r2
        L_0x0119:
            return r1
        L_0x011a:
            r9.H = r2
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.color.support.dialog.panel.ColorGuideBehavior.onInterceptTouchEvent(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, android.view.MotionEvent):boolean");
    }

    public boolean onTouchEvent(CoordinatorLayout coordinatorLayout, V v2, MotionEvent motionEvent) {
        if (!v2.isShown()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (this.h == 1 && actionMasked == 0) {
            return true;
        }
        c cVar = this.i;
        if (cVar != null) {
            cVar.b(motionEvent);
        }
        if (actionMasked == 0) {
            d();
        }
        if (this.L == null) {
            this.L = VelocityTracker.obtain();
        }
        this.L.addMovement(motionEvent);
        if (actionMasked == 2 && !this.H && Math.abs(((float) this.N) - motionEvent.getY()) > ((float) this.i.d())) {
            this.i.a((View) v2, motionEvent.getPointerId(motionEvent.getActionIndex()));
        }
        return !this.H;
    }

    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, V v2, View view, View view2, int i2, int i3) {
        this.I = 0;
        this.J = false;
        if ((i2 & 2) != 0) {
            return true;
        }
        return false;
    }

    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, V v2, View view, int i2, int i3, int[] iArr, int i4) {
        if (i4 != 1) {
            WeakReference<View> weakReference = this.m;
            if (view == (weakReference != null ? (View) weakReference.get() : null)) {
                int top = v2.getTop();
                int i5 = top - i3;
                if (i3 > 0) {
                    if (i5 < getExpandedOffset()) {
                        iArr[1] = top - getExpandedOffset();
                        v.e(v2, -iArr[1]);
                        setStateInternal(3);
                    } else if (this.G) {
                        iArr[1] = i3;
                        v.e(v2, -i3);
                        setStateInternal(1);
                    } else {
                        return;
                    }
                } else if (i3 < 0 && !view.canScrollVertically(-1)) {
                    int i6 = this.e;
                    if (i5 > i6 && !this.g) {
                        iArr[1] = top - i6;
                        v.e(v2, -iArr[1]);
                        setStateInternal(4);
                    } else if (this.G) {
                        iArr[1] = i3;
                        v.e(v2, -i3);
                        setStateInternal(1);
                    } else {
                        return;
                    }
                }
                dispatchOnSlide(v2.getTop());
                this.I = i3;
                this.J = true;
            }
        }
    }

    public void onStopNestedScroll(CoordinatorLayout coordinatorLayout, V v2, View view, int i2) {
        int i3;
        int i4;
        int i5 = 3;
        if (v2.getTop() == getExpandedOffset()) {
            setStateInternal(3);
            return;
        }
        WeakReference<View> weakReference = this.m;
        if (weakReference != null && view == weakReference.get() && this.J) {
            if (this.I > 0) {
                if (this.r) {
                    i3 = this.f1893b;
                } else {
                    int top = v2.getTop();
                    int i6 = this.c;
                    if (top > i6) {
                        i3 = i6;
                    } else {
                        i3 = this.f1892a;
                    }
                }
                startSettlingAnimation(v2, i5, i3, false);
                this.J = false;
            } else if (!this.g || !shouldHide(v2, f())) {
                if (this.I == 0) {
                    int top2 = v2.getTop();
                    if (!this.r) {
                        int i7 = this.c;
                        if (top2 < i7) {
                            if (top2 < Math.abs(top2 - this.e)) {
                                i3 = this.f1892a;
                                startSettlingAnimation(v2, i5, i3, false);
                                this.J = false;
                            }
                            i3 = this.c;
                        } else if (Math.abs(top2 - i7) < Math.abs(top2 - this.e)) {
                            i3 = this.c;
                        } else {
                            i4 = this.e;
                        }
                    } else if (Math.abs(top2 - this.f1893b) < Math.abs(top2 - this.e)) {
                        i3 = this.f1893b;
                        startSettlingAnimation(v2, i5, i3, false);
                        this.J = false;
                    } else {
                        i4 = this.e;
                    }
                } else if (this.r) {
                    i4 = this.e;
                } else {
                    int top3 = v2.getTop();
                    if (Math.abs(top3 - this.c) < Math.abs(top3 - this.e)) {
                        i3 = this.c;
                    } else {
                        i4 = this.e;
                    }
                }
                i5 = 4;
                startSettlingAnimation(v2, i5, i3, false);
                this.J = false;
            } else {
                d dVar = this.p;
                if (dVar == null || !dVar.a()) {
                    i3 = this.k;
                    i5 = 5;
                    this.R = true;
                } else {
                    i3 = this.f1893b;
                    this.R = false;
                }
                startSettlingAnimation(v2, i5, i3, false);
                this.J = false;
            }
            i5 = 6;
            startSettlingAnimation(v2, i5, i3, false);
            this.J = false;
        }
    }

    public boolean onNestedPreFling(CoordinatorLayout coordinatorLayout, V v2, View view, float f2, float f3) {
        WeakReference<View> weakReference = this.m;
        if (weakReference == null || view != weakReference.get()) {
            return false;
        }
        if (this.h != 3 || super.onNestedPreFling(coordinatorLayout, v2, view, f2, f3)) {
            return true;
        }
        return false;
    }

    public boolean isFitToContents() {
        return this.r;
    }

    public void setFitToContents(boolean z2) {
        if (this.r != z2) {
            this.r = z2;
            if (this.l != null) {
                b();
            }
            setStateInternal((!this.r || this.h != 6) ? this.h : 3);
            g();
        }
    }

    public void setPeekHeight(int i2) {
        a(i2, false);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0025  */
    /* JADX WARNING: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(int r4, boolean r5) {
        /*
            r3 = this;
            r0 = 1
            r1 = 0
            r2 = -1
            if (r4 != r2) goto L_0x000c
            boolean r4 = r3.v
            if (r4 != 0) goto L_0x0015
            r3.v = r0
            goto L_0x001f
        L_0x000c:
            boolean r2 = r3.v
            if (r2 != 0) goto L_0x0017
            int r2 = r3.u
            if (r2 == r4) goto L_0x0015
            goto L_0x0017
        L_0x0015:
            r0 = r1
            goto L_0x001f
        L_0x0017:
            r3.v = r1
            int r4 = java.lang.Math.max(r1, r4)
            r3.u = r4
        L_0x001f:
            if (r0 == 0) goto L_0x0042
            java.lang.ref.WeakReference<V> r4 = r3.l
            if (r4 == 0) goto L_0x0042
            r3.b()
            int r4 = r3.h
            r0 = 4
            if (r4 != r0) goto L_0x0042
            java.lang.ref.WeakReference<V> r4 = r3.l
            java.lang.Object r4 = r4.get()
            android.view.View r4 = (android.view.View) r4
            if (r4 == 0) goto L_0x0042
            if (r5 == 0) goto L_0x003f
            int r4 = r3.h
            r3.a((int) r4)
            goto L_0x0042
        L_0x003f:
            r4.requestLayout()
        L_0x0042:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.color.support.dialog.panel.ColorGuideBehavior.a(int, boolean):void");
    }

    public int getPeekHeight() {
        if (this.v) {
            return -1;
        }
        return this.u;
    }

    public void setHalfExpandedRatio(float f2) {
        if (f2 <= 0.0f || f2 >= 1.0f) {
            throw new IllegalArgumentException("ratio must be a float value between 0 and 1");
        }
        this.d = f2;
        if (this.l != null) {
            c();
        }
    }

    public float getHalfExpandedRatio() {
        return this.d;
    }

    public void setExpandedOffset(int i2) {
        if (i2 >= 0) {
            this.f1892a = i2;
            return;
        }
        throw new IllegalArgumentException("offset must be greater than or equal to 0");
    }

    public int getExpandedOffset() {
        return this.r ? this.f1893b : this.f1892a;
    }

    @SuppressLint({"WrongConstant"})
    public void setHideable(boolean z2) {
        if (this.g != z2) {
            this.g = z2;
            if (!z2 && this.h == 5) {
                setState(4);
            }
            g();
        }
    }

    public boolean isHideable() {
        return this.g;
    }

    public void setSkipCollapsed(boolean z2) {
        this.F = z2;
    }

    public boolean getSkipCollapsed() {
        return this.F;
    }

    public void setDraggable(boolean z2) {
        this.G = z2;
    }

    public boolean isDraggable() {
        return this.G;
    }

    public void setSaveFlags(int i2) {
        this.q = i2;
    }

    public int getSaveFlags() {
        return this.q;
    }

    public void setState(int i2) {
        if (i2 != this.h) {
            if (this.l != null) {
                a(i2);
            } else if (i2 == 4 || i2 == 3 || i2 == 6 || (this.g && i2 == 5)) {
                this.h = i2;
            }
        }
    }

    public void setGestureInsetBottomIgnored(boolean z2) {
        this.z = z2;
    }

    public boolean isGestureInsetBottomIgnored() {
        return this.z;
    }

    private void a(final int i2) {
        final View view = (View) this.l.get();
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent == null || !parent.isLayoutRequested() || !v.D(view)) {
                settleToState(view, i2);
            } else {
                view.post(new Runnable() {
                    public void run() {
                        ColorGuideBehavior.this.settleToState(view, i2);
                    }
                });
            }
        }
    }

    @SuppressLint({"WrongConstant"})
    public int getState() {
        return this.h;
    }

    /* access modifiers changed from: package-private */
    public void setStateInternal(int i2) {
        View view;
        if (this.h != i2) {
            this.h = i2;
            WeakReference<V> weakReference = this.l;
            if (weakReference != null && (view = (View) weakReference.get()) != null) {
                if (i2 == 3) {
                    a(true);
                } else if (i2 == 6 || i2 == 5 || i2 == 4) {
                    a(false);
                }
                b(i2);
                for (int i3 = 0; i3 < this.K.size(); i3++) {
                    this.K.get(i3).a(view, i2);
                }
                g();
            }
        }
    }

    private void b(int i2) {
        ValueAnimator valueAnimator;
        if (i2 != 2) {
            boolean z2 = i2 == 3;
            if (this.B != z2) {
                this.B = z2;
                if (this.y != null && (valueAnimator = this.D) != null) {
                    if (valueAnimator.isRunning()) {
                        this.D.reverse();
                        return;
                    }
                    float f2 = z2 ? 0.0f : 1.0f;
                    this.D.setFloatValues(new float[]{1.0f - f2, f2});
                    this.D.start();
                }
            }
        }
    }

    private int a() {
        if (this.v) {
            return Math.max(this.w, this.k - ((this.j * 9) / 16));
        }
        return this.u;
    }

    private void b() {
        int a2 = a();
        if (this.r) {
            this.e = Math.max(this.k - a2, this.f1893b);
        } else {
            this.e = this.k - a2;
        }
    }

    private void c() {
        this.c = (int) (((float) this.k) * (1.0f - this.d));
    }

    private void d() {
        this.n = -1;
        VelocityTracker velocityTracker = this.L;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.L = null;
        }
    }

    private void a(SavedState savedState) {
        int i2 = this.q;
        if (i2 != 0) {
            if (i2 == -1 || (i2 & 1) == 1) {
                this.u = savedState.peekHeight;
            }
            int i3 = this.q;
            if (i3 == -1 || (i3 & 2) == 2) {
                this.r = savedState.fitToContents;
            }
            int i4 = this.q;
            if (i4 == -1 || (i4 & 4) == 4) {
                this.g = savedState.hideable;
            }
            int i5 = this.q;
            if (i5 == -1 || (i5 & 8) == 8) {
                this.F = savedState.skipCollapsed;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean shouldHide(View view, float f2) {
        if (this.F) {
            return true;
        }
        if (view.getTop() < this.e) {
            return false;
        }
        if (Math.abs((((float) view.getTop()) + (f2 * 0.1f)) - ((float) this.e)) / ((float) a()) > 0.5f) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public View findScrollingChild(View view) {
        if (v.y(view) && view.getVisibility() == 0) {
            return view;
        }
        if (!(view instanceof ViewGroup) || view.getVisibility() != 0) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View findScrollingChild = findScrollingChild(viewGroup.getChildAt(i2));
            if (findScrollingChild != null) {
                return findScrollingChild;
            }
        }
        return null;
    }

    private void a(Context context, AttributeSet attributeSet, boolean z2) {
        a(context, attributeSet, z2, (ColorStateList) null);
    }

    private void a(Context context, AttributeSet attributeSet, boolean z2, ColorStateList colorStateList) {
        if (this.x) {
            this.A = ShapeAppearanceModel.builder(context, attributeSet, R.attr.bottomSheetStyle, E).build();
            this.y = new MaterialShapeDrawable(this.A);
            this.y.initializeElevationOverlay(context);
            if (!z2 || colorStateList == null) {
                TypedValue typedValue = new TypedValue();
                context.getTheme().resolveAttribute(16842801, typedValue, true);
                this.y.setTint(typedValue.data);
                return;
            }
            this.y.setFillColor(colorStateList);
        }
    }

    private void e() {
        this.D = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.D.setDuration(500);
        this.D.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (ColorGuideBehavior.this.y != null) {
                    ColorGuideBehavior.this.y.setInterpolation(floatValue);
                }
            }
        });
    }

    private void a(CoordinatorLayout coordinatorLayout) {
        WindowInsets rootWindowInsets;
        if (Build.VERSION.SDK_INT >= 29 && !isGestureInsetBottomIgnored() && (rootWindowInsets = coordinatorLayout.getRootWindowInsets()) != null) {
            this.u += rootWindowInsets.getSystemGestureInsets().bottom;
        }
    }

    private float f() {
        VelocityTracker velocityTracker = this.L;
        if (velocityTracker == null) {
            return 0.0f;
        }
        velocityTracker.computeCurrentVelocity(1000, this.t);
        return this.L.getYVelocity(this.n);
    }

    /* access modifiers changed from: package-private */
    public void settleToState(View view, int i2) {
        int i3;
        int i4;
        if (i2 == 4) {
            i3 = this.e;
        } else if (i2 == 6) {
            int i5 = this.c;
            if (!this.r || i5 > (i4 = this.f1893b)) {
                i3 = i5;
            } else {
                i2 = 3;
                i3 = i4;
            }
        } else if (i2 == 3) {
            i3 = getExpandedOffset();
        } else if (!this.g || i2 != 5) {
            throw new IllegalArgumentException("Illegal state argument: " + i2);
        } else {
            i3 = this.k;
        }
        startSettlingAnimation(view, i2, i3, false);
    }

    /* access modifiers changed from: package-private */
    public void startSettlingAnimation(View view, int i2, int i3, boolean z2) {
        boolean z3;
        if (z2) {
            z3 = this.i.a(view.getLeft(), i3);
        } else {
            z3 = this.i.a(view, view.getLeft(), i3);
        }
        if (z3) {
            setStateInternal(2);
            b(i2);
            if (this.C == null) {
                this.C = new b(view, i2);
            }
            if (!this.C.d) {
                ColorGuideBehavior<V>.b bVar = this.C;
                bVar.f1900a = i2;
                v.a(view, (Runnable) bVar);
                boolean unused = this.C.d = true;
                return;
            }
            this.C.f1900a = i2;
            return;
        }
        setStateInternal(i2);
    }

    /* access modifiers changed from: package-private */
    public void dispatchOnSlide(int i2) {
        float f2;
        float f3;
        View view = (View) this.l.get();
        if (view != null && !this.K.isEmpty()) {
            int i3 = this.e;
            if (i2 > i3 || i3 == getExpandedOffset()) {
                int i4 = this.e;
                f2 = (float) (i4 - i2);
                f3 = (float) (this.k - i4);
            } else {
                int i5 = this.e;
                f2 = (float) (i5 - i2);
                f3 = (float) (i5 - getExpandedOffset());
            }
            float f4 = f2 / f3;
            for (int i6 = 0; i6 < this.K.size(); i6++) {
                this.K.get(i6).a(view, f4);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public int getPeekHeightMin() {
        return this.w;
    }

    public void disableShapeAnimations() {
        this.D = null;
    }

    private class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        int f1900a;
        private final View c;
        /* access modifiers changed from: private */
        public boolean d;

        b(View view, int i) {
            this.c = view;
            this.f1900a = i;
        }

        public void run() {
            if (ColorGuideBehavior.this.i == null || !ColorGuideBehavior.this.i.a(true)) {
                ColorGuideBehavior.this.setStateInternal(this.f1900a);
            } else {
                v.a(this.c, (Runnable) this);
            }
            this.d = false;
        }
    }

    protected static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() {
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, (ClassLoader) null);
            }

            /* renamed from: a */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        boolean fitToContents;
        boolean hideable;
        int peekHeight;
        boolean skipCollapsed;
        final int state;

        public SavedState(Parcel parcel) {
            this(parcel, (ClassLoader) null);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.state = parcel.readInt();
            this.peekHeight = parcel.readInt();
            boolean z = false;
            this.fitToContents = parcel.readInt() == 1;
            this.hideable = parcel.readInt() == 1;
            this.skipCollapsed = parcel.readInt() == 1 ? true : z;
        }

        public SavedState(Parcelable parcelable, ColorGuideBehavior<?> colorGuideBehavior) {
            super(parcelable);
            this.state = colorGuideBehavior.h;
            this.peekHeight = colorGuideBehavior.u;
            this.fitToContents = colorGuideBehavior.r;
            this.hideable = colorGuideBehavior.g;
            this.skipCollapsed = colorGuideBehavior.F;
        }

        @Deprecated
        public SavedState(Parcelable parcelable, int i) {
            super(parcelable);
            this.state = i;
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.state);
            parcel.writeInt(this.peekHeight);
            parcel.writeInt(this.fitToContents ? 1 : 0);
            parcel.writeInt(this.hideable ? 1 : 0);
            parcel.writeInt(this.skipCollapsed ? 1 : 0);
        }
    }

    public void setUpdateImportantForAccessibilityOnSiblings(boolean z2) {
        this.s = z2;
    }

    private void a(boolean z2) {
        Map<View, Integer> map;
        WeakReference<V> weakReference = this.l;
        if (weakReference != null) {
            ViewParent parent = ((View) weakReference.get()).getParent();
            if (parent instanceof CoordinatorLayout) {
                CoordinatorLayout coordinatorLayout = (CoordinatorLayout) parent;
                int childCount = coordinatorLayout.getChildCount();
                if (Build.VERSION.SDK_INT >= 16 && z2) {
                    if (this.O == null) {
                        this.O = new HashMap(childCount);
                    } else {
                        return;
                    }
                }
                for (int i2 = 0; i2 < childCount; i2++) {
                    View childAt = coordinatorLayout.getChildAt(i2);
                    if (childAt != this.l.get()) {
                        if (z2) {
                            if (Build.VERSION.SDK_INT >= 16) {
                                this.O.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                            }
                            if (this.s) {
                                v.b(childAt, 4);
                            }
                        } else if (this.s && (map = this.O) != null && map.containsKey(childAt)) {
                            v.b(childAt, this.O.get(childAt).intValue());
                        }
                    }
                }
                if (!z2) {
                    this.O = null;
                }
            }
        }
    }

    private void g() {
        View view;
        WeakReference<V> weakReference = this.l;
        if (weakReference != null && (view = (View) weakReference.get()) != null) {
            v.c(view, (int) STMobileHumanActionNative.ST_MOBILE_ENABLE_INPUT_CUSTOM);
            v.c(view, (int) STMobileHumanActionNative.ST_MOBILE_DETECT_MODE_IMAGE);
            v.c(view, 1048576);
            if (this.g && this.h != 5) {
                a(view, d.a.u, 5);
            }
            int i2 = this.h;
            int i3 = 6;
            if (i2 == 3) {
                if (this.r) {
                    i3 = 4;
                }
                a(view, d.a.t, i3);
            } else if (i2 == 4) {
                if (this.r) {
                    i3 = 3;
                }
                a(view, d.a.s, i3);
            } else if (i2 == 6) {
                a(view, d.a.t, 4);
                a(view, d.a.s, 3);
            }
        }
    }

    private void a(V v2, d.a aVar, final int i2) {
        v.a(v2, aVar, (CharSequence) null, new g() {
            public boolean perform(View view, g.a aVar) {
                ColorGuideBehavior.this.setState(i2);
                return true;
            }
        });
    }
}
