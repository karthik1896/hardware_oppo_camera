package androidx.appcompat.widget;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.PopupWindow;
import androidx.appcompat.R;
import androidx.core.widget.h;

/* compiled from: AppCompatPopupWindow */
class o extends PopupWindow {

    /* renamed from: a  reason: collision with root package name */
    private static final boolean f456a = (Build.VERSION.SDK_INT < 21);

    /* renamed from: b  reason: collision with root package name */
    private boolean f457b;

    public o(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        a(context, attributeSet, i, i2);
    }

    private void a(Context context, AttributeSet attributeSet, int i, int i2) {
        ar a2 = ar.a(context, attributeSet, R.styleable.PopupWindow, i, i2);
        if (a2.g(R.styleable.PopupWindow_overlapAnchor)) {
            a(a2.a(R.styleable.PopupWindow_overlapAnchor, false));
        }
        setBackgroundDrawable(a2.a(R.styleable.PopupWindow_android_popupBackground));
        a2.b();
    }

    public void showAsDropDown(View view, int i, int i2) {
        if (f456a && this.f457b) {
            i2 -= view.getHeight();
        }
        super.showAsDropDown(view, i, i2);
    }

    public void showAsDropDown(View view, int i, int i2, int i3) {
        if (f456a && this.f457b) {
            i2 -= view.getHeight();
        }
        super.showAsDropDown(view, i, i2, i3);
    }

    public void update(View view, int i, int i2, int i3, int i4) {
        if (f456a && this.f457b) {
            i2 -= view.getHeight();
        }
        super.update(view, i, i2, i3, i4);
    }

    private void a(boolean z) {
        if (f456a) {
            this.f457b = z;
        } else {
            h.a((PopupWindow) this, z);
        }
    }
}
