package com.oppo.camera.ui.menu.a;

import android.app.Activity;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.oppo.camera.R;
import com.oppo.camera.ui.OppoNumAISeekBar;
import com.oppo.camera.ui.OppoNumSeekBar;
import com.oppo.camera.util.Util;

/* compiled from: FaceBeautyCommonMenu */
class d implements a {

    /* renamed from: a  reason: collision with root package name */
    private int f4053a = -2;

    /* renamed from: b  reason: collision with root package name */
    private int f4054b = -2;
    private int c = 0;
    private OppoNumAISeekBar d = null;
    private RelativeLayout.LayoutParams e = null;

    public d(Activity activity, OppoNumSeekBar.a aVar) {
        Resources resources = activity.getApplicationContext().getResources();
        int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.face_beauty_common_seekbar_margin_left);
        int dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.face_beauty_common_seekbar_margin_right);
        this.f4053a = resources.getDimensionPixelSize(R.dimen.face_beauty_custom_seekbar_height);
        this.f4054b = resources.getDimensionPixelSize(R.dimen.face_beauty_custom_seekbar_width);
        this.c = Util.w();
        this.d = new OppoNumAISeekBar(activity);
        this.d.setPadding(dimensionPixelSize, 0, dimensionPixelSize2, 0);
        this.d.setOnProgressChangedListener(aVar);
        this.d.setFrontStyle(false);
    }

    public void a(int i, int i2) {
        if (i == -100000) {
            i = 0;
        }
        this.d.b(0).a(100).d(i2).c(i).postInvalidate();
    }

    public ViewGroup.LayoutParams c() {
        if (this.e == null) {
            this.e = new RelativeLayout.LayoutParams(this.f4054b, this.f4053a);
            this.e.addRule(12);
            this.e.addRule(16, R.id.face_beauty_enter_button);
            this.e.setMargins(0, 0, 0, this.c);
        }
        return this.e;
    }

    public void a() {
        ViewGroup viewGroup = (ViewGroup) this.d.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(this.d);
        }
    }

    public View b() {
        return this.d;
    }
}
