package com.oppo.camera.professional;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.oppo.camera.util.Util;

/* compiled from: ImageItem */
public class b extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    public static int f3516a = 198;

    /* renamed from: b  reason: collision with root package name */
    private Context f3517b;
    private ImageView c;
    private l d;
    private int e;
    private int f;
    private int g;

    public void setItemViewDrawable(Drawable drawable) {
        this.c.setImageDrawable(drawable);
        this.c.measure(Util.E(), Util.D());
    }

    public void setItemValueText(String str) {
        this.d.setText(str);
        this.d.setTypeface(Util.j(this.f3517b));
        this.d.setContentDescription(str);
        this.d.measure(Util.E(), Util.D());
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10 = i3 - i;
        int i11 = i4 - i2;
        l lVar = this.d;
        int i12 = 0;
        if (lVar != null) {
            i6 = lVar.getMeasuredWidth();
            i5 = this.d.getMeasuredHeight();
        } else {
            i6 = 0;
            i5 = 0;
        }
        ImageView imageView = this.c;
        if (imageView != null) {
            int measuredWidth = imageView.getMeasuredWidth();
            int measuredHeight = this.c.getMeasuredHeight();
            int i13 = this.g;
            if (i13 == 90) {
                i9 = (((i10 - i5) - this.e) - measuredWidth) / 2;
                i7 = (i11 - measuredHeight) / 2;
            } else if (i13 != 270) {
                i9 = (i10 - measuredWidth) / 2;
                i7 = this.f;
            } else {
                i9 = (((i10 + i5) + this.e) - measuredWidth) / 2;
                i7 = (i11 - measuredHeight) / 2;
            }
            this.c.layout(i9, i7, measuredWidth + i9, i7 + measuredHeight);
            i12 = measuredHeight;
        } else {
            i7 = 0;
        }
        if (this.d != null) {
            int i14 = this.g;
            if (i14 == 90) {
                i8 = (((i10 + i12) + this.e) - i6) / 2;
                i7 = (i11 - i5) / 2;
            } else if (i14 != 270) {
                i8 = (i10 - i6) / 2;
                ImageView imageView2 = this.c;
                if (imageView2 != null) {
                    i7 = imageView2.getBottom() + this.e;
                }
            } else {
                i8 = (((i10 - i12) - this.e) - i6) / 2;
                i7 = (i11 - i5) / 2;
            }
            this.d.layout(i8, i7, i6 + i8, i5 + i7);
        }
    }
}
