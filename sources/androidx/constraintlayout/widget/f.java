package androidx.constraintlayout.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;

/* compiled from: Placeholder */
public class f extends View {

    /* renamed from: a  reason: collision with root package name */
    private int f559a;

    /* renamed from: b  reason: collision with root package name */
    private View f560b;
    private int c;

    public void setEmptyVisibility(int i) {
        this.c = i;
    }

    public int getEmptyVisibility() {
        return this.c;
    }

    public View getContent() {
        return this.f560b;
    }

    public void onDraw(Canvas canvas) {
        if (isInEditMode()) {
            canvas.drawRGB(223, 223, 223);
            Paint paint = new Paint();
            paint.setARGB(255, 210, 210, 210);
            paint.setTextAlign(Paint.Align.CENTER);
            paint.setTypeface(Typeface.create(Typeface.DEFAULT, 0));
            Rect rect = new Rect();
            canvas.getClipBounds(rect);
            paint.setTextSize((float) rect.height());
            int height = rect.height();
            int width = rect.width();
            paint.setTextAlign(Paint.Align.LEFT);
            paint.getTextBounds("?", 0, 1, rect);
            canvas.drawText("?", ((((float) width) / 2.0f) - (((float) rect.width()) / 2.0f)) - ((float) rect.left), ((((float) height) / 2.0f) + (((float) rect.height()) / 2.0f)) - ((float) rect.bottom), paint);
        }
    }

    public void a(ConstraintLayout constraintLayout) {
        if (this.f559a == -1 && !isInEditMode()) {
            setVisibility(this.c);
        }
        this.f560b = constraintLayout.findViewById(this.f559a);
        View view = this.f560b;
        if (view != null) {
            ((ConstraintLayout.a) view.getLayoutParams()).aa = true;
            this.f560b.setVisibility(0);
            setVisibility(0);
        }
    }

    public void setContentId(int i) {
        View findViewById;
        if (this.f559a != i) {
            View view = this.f560b;
            if (view != null) {
                view.setVisibility(0);
                ((ConstraintLayout.a) this.f560b.getLayoutParams()).aa = false;
                this.f560b = null;
            }
            this.f559a = i;
            if (i != -1 && (findViewById = ((View) getParent()).findViewById(i)) != null) {
                findViewById.setVisibility(8);
            }
        }
    }

    public void b(ConstraintLayout constraintLayout) {
        if (this.f560b != null) {
            ConstraintLayout.a aVar = (ConstraintLayout.a) getLayoutParams();
            ConstraintLayout.a aVar2 = (ConstraintLayout.a) this.f560b.getLayoutParams();
            aVar2.al.e(0);
            aVar.al.j(aVar2.al.p());
            aVar.al.k(aVar2.al.r());
            aVar2.al.e(8);
        }
    }
}
