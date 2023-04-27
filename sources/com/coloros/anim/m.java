package com.coloros.anim;

import android.util.ArraySet;
import android.util.Pair;
import com.coloros.anim.f.e;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* compiled from: PerformanceTracker */
public class m {

    /* renamed from: a  reason: collision with root package name */
    private final Set<a> f2487a = new ArraySet();

    /* renamed from: b  reason: collision with root package name */
    private final Map<String, e> f2488b = new HashMap();
    private final Comparator<Pair<String, Float>> c = new Comparator<Pair<String, Float>>() {
        /* renamed from: a */
        public int compare(Pair<String, Float> pair, Pair<String, Float> pair2) {
            float floatValue = ((Float) pair.second).floatValue();
            float floatValue2 = ((Float) pair2.second).floatValue();
            if (floatValue2 > floatValue) {
                return 1;
            }
            return floatValue > floatValue2 ? -1 : 0;
        }
    };
    private boolean d = false;

    /* compiled from: PerformanceTracker */
    public interface a {
        void a(float f);
    }

    /* access modifiers changed from: package-private */
    public void a(boolean z) {
        this.d = z;
    }

    public void a(String str, float f) {
        if (this.d) {
            e eVar = this.f2488b.get(str);
            if (eVar == null) {
                eVar = new e();
                this.f2488b.put(str, eVar);
            }
            eVar.a(f);
            if (str.equals("__container")) {
                for (a a2 : this.f2487a) {
                    a2.a(f);
                }
            }
        }
    }
}
