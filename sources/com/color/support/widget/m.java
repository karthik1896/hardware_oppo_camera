package com.color.support.widget;

import android.view.animation.Interpolator;

/* compiled from: IOverScroller */
public interface m {
    void a(int i);

    void a(Interpolator interpolator);

    boolean a();

    void abortAnimation();

    int b();

    int c();

    boolean computeScrollOffset();

    int d();

    int e();

    float f();

    void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8);

    float g();

    void notifyHorizontalEdgeReached(int i, int i2, int i3);

    void notifyVerticalEdgeReached(int i, int i2, int i3);

    void startScroll(int i, int i2, int i3, int i4, int i5);
}
