package com.airbnb.lottie;

import androidx.collection.ArraySet;
import androidx.core.f.d;
import com.airbnb.lottie.f.f;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* compiled from: PerformanceTracker */
public class n {

    /* renamed from: a  reason: collision with root package name */
    private boolean f1845a = false;

    /* renamed from: b  reason: collision with root package name */
    private final Set<a> f1846b = new ArraySet();
    private final Map<String, f> c = new HashMap();
    private final Comparator<d<String, Float>> d = new Comparator<d<String, Float>>() {
        /* renamed from: a */
        public int compare(d<String, Float> dVar, d<String, Float> dVar2) {
            float floatValue = ((Float) dVar.f677b).floatValue();
            float floatValue2 = ((Float) dVar2.f677b).floatValue();
            if (floatValue2 > floatValue) {
                return 1;
            }
            return floatValue > floatValue2 ? -1 : 0;
        }
    };

    /* compiled from: PerformanceTracker */
    public interface a {
        void a(float f);
    }

    /* access modifiers changed from: package-private */
    public void a(boolean z) {
        this.f1845a = z;
    }

    public void a(String str, float f) {
        if (this.f1845a) {
            f fVar = this.c.get(str);
            if (fVar == null) {
                fVar = new f();
                this.c.put(str, fVar);
            }
            fVar.a(f);
            if (str.equals("__container")) {
                for (a a2 : this.f1846b) {
                    a2.a(f);
                }
            }
        }
    }
}
