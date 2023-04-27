package com.youtu.ocr.docprocess;

import android.util.Log;

/* compiled from: GussianBlur */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private double[] f4644a = new double[this.f4645b];

    /* renamed from: b  reason: collision with root package name */
    private int f4645b;

    public a(int i, int i2) {
        this.f4645b = i;
        int i3 = 0;
        double d = 0.0d;
        while (true) {
            int i4 = this.f4645b;
            if (i3 < i4) {
                double d2 = (double) ((i4 - 1) - i3);
                double d3 = (double) i2;
                double d4 = d;
                this.f4644a[i3] = (Math.exp(Math.pow(d2 / d3, 2.0d) * -0.5d) / Math.sqrt(6.283185307179586d)) / d3;
                if (d2 > 0.0d) {
                    double[] dArr = this.f4644a;
                    dArr[i3] = dArr[i3] * 2.0d;
                }
                d = this.f4644a[i3] + d4;
                Log.e("xlab", " " + i3 + " " + this.f4644a[i3]);
                i3++;
            } else {
                double d5 = d;
                Log.e("xlab", "sum: " + d);
                return;
            }
        }
    }

    public double[] a() {
        return this.f4644a;
    }
}
