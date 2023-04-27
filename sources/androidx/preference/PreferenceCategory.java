package androidx.preference;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.TextView;
import androidx.core.content.a;
import androidx.core.content.a.g;
import androidx.core.g.a.d;

public class PreferenceCategory extends PreferenceGroup {
    public boolean y() {
        return false;
    }

    public PreferenceCategory(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    public PreferenceCategory(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public PreferenceCategory(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, g.a(context, R.attr.preferenceCategoryStyle, 16842892));
    }

    public PreferenceCategory(Context context) {
        this(context, (AttributeSet) null);
    }

    public boolean j() {
        return !super.y();
    }

    public void a(l lVar) {
        TextView textView;
        super.a(lVar);
        if (Build.VERSION.SDK_INT >= 28) {
            lVar.itemView.setAccessibilityHeading(true);
        } else if (Build.VERSION.SDK_INT < 21) {
            TypedValue typedValue = new TypedValue();
            if (J().getTheme().resolveAttribute(R.attr.colorAccent, typedValue, true) && (textView = (TextView) lVar.a(16908310)) != null && textView.getCurrentTextColor() == a.c(J(), R.color.preference_fallback_accent_color)) {
                textView.setTextColor(typedValue.data);
            }
        }
    }

    @Deprecated
    public void a(d dVar) {
        d.c u;
        super.a(dVar);
        if (Build.VERSION.SDK_INT < 28 && (u = dVar.u()) != null) {
            dVar.b((Object) d.c.a(u.c(), u.d(), u.a(), u.b(), true, u.e()));
        }
    }
}
