package com.oppo.camera.professional;

import android.content.Context;
import android.widget.RelativeLayout;
import com.oppo.camera.e;

/* compiled from: RotateView */
public class m extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    public boolean f3578a = true;

    /* renamed from: b  reason: collision with root package name */
    protected int f3579b = -1;
    private Context c;

    public void a(int i, boolean z) {
    }

    public m(Context context, int i) {
        super(context);
        this.c = context;
        this.f3579b = i;
        e.e("RotateView", "RotateView mOrientation is " + this.f3579b);
        a(this.f3579b, false);
    }

    public void setRotateViewClickable(boolean z) {
        this.f3578a = z;
        setAlpha(this.f3578a ? 1.0f : 0.5f);
    }
}
