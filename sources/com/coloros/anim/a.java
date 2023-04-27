package com.coloros.anim;

import android.graphics.Rect;
import android.util.Log;
import android.util.LongSparseArray;
import androidx.collection.SparseArrayCompat;
import com.coloros.anim.c.c.d;
import com.coloros.anim.c.e;
import com.coloros.anim.c.h;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/* compiled from: EffectiveAnimationComposition */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private final m f2290a = new m();

    /* renamed from: b  reason: collision with root package name */
    private final HashSet<String> f2291b = new HashSet<>();
    private Map<String, List<d>> c;
    private Map<String, h> d;
    private Map<String, com.coloros.anim.c.d> e;
    private List<h> f;
    private SparseArrayCompat<e> g;
    private LongSparseArray<d> h;
    private List<d> i;
    private Rect j;
    private float k;
    private float l;
    private float m;
    private boolean n;
    private int o = 0;
    private float p = 3.0f;

    public void a(Rect rect, float f2, float f3, float f4, List<d> list, LongSparseArray<d> longSparseArray, Map<String, List<d>> map, Map<String, h> map2, SparseArrayCompat<e> sparseArrayCompat, Map<String, com.coloros.anim.c.d> map3, List<h> list2, float f5) {
        this.j = rect;
        this.k = f2;
        this.l = f3;
        this.m = f4;
        this.i = list;
        this.h = longSparseArray;
        this.c = map;
        this.d = map2;
        this.g = sparseArrayCompat;
        this.e = map3;
        this.f = list2;
        this.p = f5;
    }

    public void a(String str) {
        Log.w("EffectiveAnimation", str);
        this.f2291b.add(str);
    }

    public void a(boolean z) {
        this.n = z;
    }

    public void a(int i2) {
        this.o += i2;
    }

    public boolean a() {
        return this.n;
    }

    public int b() {
        return this.o;
    }

    public void b(boolean z) {
        this.f2290a.a(z);
    }

    public m c() {
        return this.f2290a;
    }

    public d a(long j2) {
        return this.h.get(j2);
    }

    public Rect d() {
        return this.j;
    }

    public float e() {
        return (float) ((long) ((m() / this.m) * 1000.0f));
    }

    public float f() {
        return this.k;
    }

    public float g() {
        return this.l;
    }

    public float h() {
        return this.m;
    }

    public List<d> i() {
        return this.i;
    }

    public List<d> b(String str) {
        return this.c.get(str);
    }

    public SparseArrayCompat<e> j() {
        return this.g;
    }

    public Map<String, com.coloros.anim.c.d> k() {
        return this.e;
    }

    public h c(String str) {
        this.f.size();
        for (int i2 = 0; i2 < this.f.size(); i2++) {
            h hVar = this.f.get(i2);
            if (str.equals(hVar.f2422a)) {
                return hVar;
            }
        }
        return null;
    }

    public Map<String, h> l() {
        return this.d;
    }

    public float m() {
        return this.l - this.k;
    }

    public float n() {
        return this.p;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("EffectiveAnimationComposition:\n");
        for (d a2 : this.i) {
            sb.append(a2.a("\t"));
        }
        return sb.toString();
    }
}
