package com.airbnb.lottie.c.b;

import com.airbnb.lottie.a.a.c;
import com.airbnb.lottie.a.a.l;
import com.airbnb.lottie.f;
import com.airbnb.lottie.f.d;

/* compiled from: MergePaths */
public class h implements b {

    /* renamed from: a  reason: collision with root package name */
    private final String f1679a;

    /* renamed from: b  reason: collision with root package name */
    private final a f1680b;
    private final boolean c;

    /* compiled from: MergePaths */
    public enum a {
        MERGE,
        ADD,
        SUBTRACT,
        INTERSECT,
        EXCLUDE_INTERSECTIONS;

        public static a forId(int i) {
            if (i == 1) {
                return MERGE;
            }
            if (i == 2) {
                return ADD;
            }
            if (i == 3) {
                return SUBTRACT;
            }
            if (i == 4) {
                return INTERSECT;
            }
            if (i != 5) {
                return MERGE;
            }
            return EXCLUDE_INTERSECTIONS;
        }
    }

    public h(String str, a aVar, boolean z) {
        this.f1679a = str;
        this.f1680b = aVar;
        this.c = z;
    }

    public String a() {
        return this.f1679a;
    }

    public a b() {
        return this.f1680b;
    }

    public boolean c() {
        return this.c;
    }

    public c a(f fVar, com.airbnb.lottie.c.c.a aVar) {
        if (fVar.a()) {
            return new l(this);
        }
        d.b("Animation contains merge paths but they are disabled.");
        return null;
    }

    public String toString() {
        return "MergePaths{mode=" + this.f1680b + '}';
    }
}
