package com.coloros.anim.c.b;

import com.coloros.anim.a.a.c;
import com.coloros.anim.a.a.l;
import com.coloros.anim.b;
import com.coloros.anim.k;

/* compiled from: MergePaths */
public class h implements b {

    /* renamed from: a  reason: collision with root package name */
    private final String f2380a;

    /* renamed from: b  reason: collision with root package name */
    private final a f2381b;
    private final boolean c;

    public h(String str, a aVar, boolean z) {
        this.f2380a = str;
        this.f2381b = aVar;
        this.c = z;
    }

    public String a() {
        return this.f2380a;
    }

    public a b() {
        return this.f2381b;
    }

    public boolean c() {
        return this.c;
    }

    public c a(b bVar, com.coloros.anim.c.c.a aVar) {
        if (!bVar.a()) {
            k.b("Animation contains merge paths but they are disabled.");
            return null;
        }
        if (com.coloros.anim.f.b.d) {
            com.coloros.anim.f.b.b("MergePaths to MergePathsContent, layer = " + aVar);
        }
        return new l(this);
    }

    public String toString() {
        return "MergePaths{mode=" + this.f2381b + '}';
    }

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
}
