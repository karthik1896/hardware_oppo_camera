package com.oppo.camera.ui.menu.a;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: FaceBeautyItemDecoration */
class f extends RecyclerView.h {

    /* renamed from: a  reason: collision with root package name */
    private int f4058a = 0;

    /* renamed from: b  reason: collision with root package name */
    private int f4059b = 0;
    private int c = 0;
    private int d = 0;

    public void a(int i, int i2, int i3) {
        this.f4058a = i;
        this.f4059b = i2;
        this.c = i3;
        this.d = i3;
    }

    public f(int i, int i2, int i3) {
        a(i, i2 / 2, i3);
    }

    public void a(int i, int i2) {
        this.c = i;
        this.d = i2;
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.t tVar) {
        int childPosition = recyclerView.getChildPosition(view);
        boolean z = 1 == recyclerView.getLayoutDirection();
        if (childPosition == 0) {
            rect.left = z ? this.f4059b : this.c;
            rect.right = z ? this.c : this.f4059b;
        } else if (this.f4058a - 1 == childPosition) {
            rect.left = z ? this.d : this.f4059b;
            rect.right = z ? this.f4059b : this.d;
        } else {
            int i = this.f4059b;
            rect.left = i;
            rect.right = i;
        }
    }
}
