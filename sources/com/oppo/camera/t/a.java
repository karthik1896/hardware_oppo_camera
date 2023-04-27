package com.oppo.camera.t;

import android.graphics.Point;
import android.graphics.PointF;
import java.util.Arrays;

/* compiled from: DetectResult */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private Point[] f3747a;

    /* renamed from: b  reason: collision with root package name */
    private PointF[] f3748b;
    private PointF[] c;
    private boolean d;

    public a() {
        this.f3747a = null;
        this.f3748b = null;
        this.c = null;
        this.d = false;
        this.d = false;
    }

    public PointF[] a() {
        return this.c;
    }

    public void a(PointF[] pointFArr) {
        this.c = pointFArr;
    }

    public PointF[] b() {
        return this.f3748b;
    }

    public void b(PointF[] pointFArr) {
        this.f3748b = pointFArr;
    }

    public void a(Point[] pointArr) {
        this.f3747a = pointArr;
    }

    public boolean c() {
        return this.d;
    }

    public void a(boolean z) {
        this.d = z;
    }

    public String toString() {
        return "DetectResult{mActualResultPointsArray=" + Arrays.toString(this.f3747a) + ", mPercentResultArrayForPreview=" + Arrays.toString(this.f3748b) + ", mPercentResultArrayForCapture=" + Arrays.toString(this.c) + ", mbHasResult=" + this.d + '}';
    }
}
