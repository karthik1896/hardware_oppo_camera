package com.airbnb.lottie;

import android.graphics.Rect;
import androidx.collection.LongSparseArray;
import androidx.collection.SparseArrayCompat;
import com.airbnb.lottie.c.c;
import com.airbnb.lottie.c.h;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/* compiled from: LottieComposition */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private final n f1724a = new n();

    /* renamed from: b  reason: collision with root package name */
    private final HashSet<String> f1725b = new HashSet<>();
    private Map<String, List<com.airbnb.lottie.c.c.d>> c;
    private Map<String, g> d;
    private Map<String, c> e;
    private List<h> f;
    private SparseArrayCompat<com.airbnb.lottie.c.d> g;
    private LongSparseArray<com.airbnb.lottie.c.c.d> h;
    private List<com.airbnb.lottie.c.c.d> i;
    private Rect j;
    private float k;
    private float l;
    private float m;
    private boolean n;
    private int o = 0;

    public void a(Rect rect, float f2, float f3, float f4, List<com.airbnb.lottie.c.c.d> list, LongSparseArray<com.airbnb.lottie.c.c.d> longSparseArray, Map<String, List<com.airbnb.lottie.c.c.d>> map, Map<String, g> map2, SparseArrayCompat<com.airbnb.lottie.c.d> sparseArrayCompat, Map<String, c> map3, List<h> list2) {
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
    }

    public void a(String str) {
        com.airbnb.lottie.f.d.b(str);
        this.f1725b.add(str);
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
        this.f1724a.a(z);
    }

    public n c() {
        return this.f1724a;
    }

    public com.airbnb.lottie.c.c.d a(long j2) {
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

    public List<com.airbnb.lottie.c.c.d> i() {
        return this.i;
    }

    public List<com.airbnb.lottie.c.c.d> b(String str) {
        return this.c.get(str);
    }

    public SparseArrayCompat<com.airbnb.lottie.c.d> j() {
        return this.g;
    }

    public Map<String, c> k() {
        return this.e;
    }

    public h c(String str) {
        this.f.size();
        for (int i2 = 0; i2 < this.f.size(); i2++) {
            h hVar = this.f.get(i2);
            if (hVar.a(str)) {
                return hVar;
            }
        }
        return null;
    }

    public Map<String, g> l() {
        return this.d;
    }

    public float m() {
        return this.l - this.k;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("LottieComposition:\n");
        for (com.airbnb.lottie.c.c.d a2 : this.i) {
            sb.append(a2.a("\t"));
        }
        return sb.toString();
    }
}
