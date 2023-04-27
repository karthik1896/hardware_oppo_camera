package color.support.v7.internal.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.ar;

public class TintImageView extends AppCompatImageView {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f1513a = {16842964, 16843033};

    /* renamed from: b  reason: collision with root package name */
    private final f f1514b;

    public TintImageView(Context context) {
        this(context, (AttributeSet) null);
    }

    public TintImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TintImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        ar a2 = ar.a(getContext(), attributeSet, f1513a, i, 0);
        if (a2.a() > 0) {
            if (a2.g(0)) {
                setBackgroundDrawable(a2.a(0));
            }
            if (a2.g(1)) {
                setImageDrawable(a2.a(1));
            }
        }
        a2.b();
        this.f1514b = f.a(context);
    }

    public void setImageResource(int i) {
        setImageDrawable(this.f1514b.a(i));
    }
}
