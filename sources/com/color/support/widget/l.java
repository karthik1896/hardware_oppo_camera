package com.color.support.widget;

import java.util.ArrayList;

/* compiled from: ExpandableRecyclerPosition */
class l {
    private static ArrayList<l> e = new ArrayList<>(5);

    /* renamed from: a  reason: collision with root package name */
    public int f2223a;

    /* renamed from: b  reason: collision with root package name */
    public int f2224b;
    int c;
    public int d;

    private void b() {
        this.f2223a = 0;
        this.f2224b = 0;
        this.c = 0;
        this.d = 0;
    }

    private l() {
    }

    static l a(int i, int i2, int i3, int i4) {
        l c2 = c();
        c2.d = i;
        c2.f2223a = i2;
        c2.f2224b = i3;
        c2.c = i4;
        return c2;
    }

    private static l c() {
        synchronized (e) {
            if (e.size() > 0) {
                l remove = e.remove(0);
                remove.b();
                return remove;
            }
            l lVar = new l();
            return lVar;
        }
    }

    public void a() {
        synchronized (e) {
            if (e.size() < 5) {
                e.add(this);
            }
        }
    }
}
