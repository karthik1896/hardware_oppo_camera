package androidx.preference;

import android.content.Context;
import android.util.AttributeSet;
import androidx.core.content.a.g;
import androidx.preference.j;

public final class PreferenceScreen extends PreferenceGroup {

    /* renamed from: b  reason: collision with root package name */
    private boolean f984b = true;

    /* access modifiers changed from: protected */
    public boolean e() {
        return false;
    }

    public PreferenceScreen(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, g.a(context, R.attr.preferenceScreenStyle, 16842891));
    }

    /* access modifiers changed from: protected */
    public void g() {
        j.b i;
        if (q() == null && r() == null && c() != 0 && (i = M().i()) != null) {
            i.b(this);
        }
    }

    public boolean l() {
        return this.f984b;
    }
}
