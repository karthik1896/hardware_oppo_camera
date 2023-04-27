package com.oppo.camera.ui;

import android.graphics.Outline;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.oppo.camera.e;

/* compiled from: OppoViewOutlineProvider */
public class k extends ViewOutlineProvider {

    /* renamed from: a  reason: collision with root package name */
    String f4034a = "Rect";

    /* renamed from: b  reason: collision with root package name */
    private float f4035b = 0.0f;
    private Rect c = null;

    public k a(Rect rect, float f) {
        this.f4034a = "RoundRect";
        this.f4035b = f;
        this.c = rect;
        e.e("OppoViewOutlineProvider", "setRountRect, mOutLineRect: " + this.c.toString());
        if (a(this.c)) {
            return this;
        }
        return null;
    }

    private boolean a(Rect rect) {
        if (rect != null && rect.left >= 0 && rect.top >= 0 && rect.width() > 0 && rect.height() > 0) {
            return true;
        }
        e.e("OppoViewOutlineProvider", "checkArgumentNonnegative, value is invalid");
        return false;
    }

    public void getOutline(View view, Outline outline) {
        if (this.c != null && "RoundRect".equals(this.f4034a)) {
            outline.setRoundRect(this.c, this.f4035b);
        }
    }
}
