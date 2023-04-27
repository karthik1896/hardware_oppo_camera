package androidx.appcompat.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.drawable.Drawable;

/* compiled from: ActionBarBackgroundDrawable */
class b extends Drawable {

    /* renamed from: a  reason: collision with root package name */
    final ActionBarContainer f434a;

    public int getOpacity() {
        return 0;
    }

    public void setAlpha(int i) {
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }

    public b(ActionBarContainer actionBarContainer) {
        this.f434a = actionBarContainer;
    }

    public void draw(Canvas canvas) {
        if (!this.f434a.d) {
            if (this.f434a.f290a != null) {
                this.f434a.f290a.draw(canvas);
            }
            if (this.f434a.f291b != null && this.f434a.e) {
                this.f434a.f291b.draw(canvas);
            }
        } else if (this.f434a.c != null) {
            this.f434a.c.draw(canvas);
        }
    }

    public void getOutline(Outline outline) {
        if (this.f434a.d) {
            if (this.f434a.c != null) {
                this.f434a.c.getOutline(outline);
            }
        } else if (this.f434a.f290a != null) {
            this.f434a.f290a.getOutline(outline);
        }
    }
}
