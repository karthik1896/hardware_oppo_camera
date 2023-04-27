package com.oppo.camera.ui.widget;

import android.content.Context;
import android.view.View;
import com.color.support.widget.j;

/* compiled from: SuperColorToolTips */
public class d extends j {

    /* renamed from: a  reason: collision with root package name */
    private int f4593a = -1;

    /* renamed from: b  reason: collision with root package name */
    private int f4594b;
    private int c;

    public d(Context context) {
        super(context);
    }

    public void showAtLocation(View view, int i, int i2, int i3) {
        int i4 = this.f4593a;
        if (i4 >= 0) {
            super.showAtLocation(view, i, i2, i4);
        } else {
            super.showAtLocation(view, i, i2 + this.f4594b, i3 + this.c);
        }
    }

    public void b(int i) {
        this.f4593a = i;
    }

    public void c(int i) {
        this.c = i;
    }

    public void a(int i, int i2) {
        this.f4594b = i;
        this.c = i2;
    }
}
