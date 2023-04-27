package androidx.core.graphics;

import android.graphics.BlendMode;
import android.graphics.BlendModeColorFilter;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.os.Build;

/* compiled from: BlendModeColorFilterCompat */
public class a {
    public static ColorFilter a(int i, b bVar) {
        if (Build.VERSION.SDK_INT >= 29) {
            BlendMode a2 = c.a(bVar);
            if (a2 != null) {
                return new BlendModeColorFilter(i, a2);
            }
            return null;
        }
        PorterDuff.Mode b2 = c.b(bVar);
        if (b2 != null) {
            return new PorterDuffColorFilter(i, b2);
        }
        return null;
    }
}
