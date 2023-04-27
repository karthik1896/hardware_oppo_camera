package androidx.transition;

import android.view.View;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* compiled from: TransitionValues */
public class t {

    /* renamed from: a  reason: collision with root package name */
    public final Map<String, Object> f1311a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    public View f1312b;
    final ArrayList<m> c = new ArrayList<>();

    @Deprecated
    public t() {
    }

    public t(View view) {
        this.f1312b = view;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof t)) {
            return false;
        }
        t tVar = (t) obj;
        return this.f1312b == tVar.f1312b && this.f1311a.equals(tVar.f1311a);
    }

    public int hashCode() {
        return (this.f1312b.hashCode() * 31) + this.f1311a.hashCode();
    }

    public String toString() {
        String str = (("TransitionValues@" + Integer.toHexString(hashCode()) + ":\n") + "    view = " + this.f1312b + "\n") + "    values:";
        for (String next : this.f1311a.keySet()) {
            str = str + "    " + next + ": " + this.f1311a.get(next) + "\n";
        }
        return str;
    }
}
