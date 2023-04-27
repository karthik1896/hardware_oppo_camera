package com.coloros.anim.c;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: KeyPath */
public class f {

    /* renamed from: a  reason: collision with root package name */
    private final List<String> f2420a;

    /* renamed from: b  reason: collision with root package name */
    private g f2421b;

    public f(String... strArr) {
        this.f2420a = Arrays.asList(strArr);
    }

    private f(f fVar) {
        this.f2420a = new ArrayList(fVar.f2420a);
        this.f2421b = fVar.f2421b;
    }

    public f a(String str) {
        f fVar = new f(this);
        fVar.f2420a.add(str);
        return fVar;
    }

    public f a(g gVar) {
        f fVar = new f(this);
        fVar.f2421b = gVar;
        return fVar;
    }

    public g a() {
        return this.f2421b;
    }

    public boolean a(String str, int i) {
        if (b(str)) {
            return true;
        }
        if (i >= this.f2420a.size()) {
            return false;
        }
        if (this.f2420a.get(i).equals(str) || this.f2420a.get(i).equals("**") || this.f2420a.get(i).equals("*")) {
            return true;
        }
        return false;
    }

    public int b(String str, int i) {
        if (b(str)) {
            return 0;
        }
        if (!this.f2420a.get(i).equals("**")) {
            return 1;
        }
        if (i != this.f2420a.size() - 1 && this.f2420a.get(i + 1).equals(str)) {
            return 2;
        }
        return 0;
    }

    public boolean c(String str, int i) {
        if (i >= this.f2420a.size()) {
            return false;
        }
        boolean z = i == this.f2420a.size() - 1;
        String str2 = this.f2420a.get(i);
        if (!str2.equals("**")) {
            boolean z2 = str2.equals(str) || str2.equals("*");
            if ((z || (i == this.f2420a.size() - 2 && b())) && z2) {
                return true;
            }
            return false;
        }
        if (!z && this.f2420a.get(i + 1).equals(str)) {
            if (i == this.f2420a.size() - 2 || (i == this.f2420a.size() - 3 && b())) {
                return true;
            }
            return false;
        } else if (z) {
            return true;
        } else {
            int i2 = i + 1;
            if (i2 < this.f2420a.size() - 1) {
                return false;
            }
            return this.f2420a.get(i2).equals(str);
        }
    }

    public boolean d(String str, int i) {
        if (!"__container".equals(str) && i >= this.f2420a.size() - 1 && !this.f2420a.get(i).equals("**")) {
            return false;
        }
        return true;
    }

    private boolean b(String str) {
        return "__container".equals(str);
    }

    private boolean b() {
        List<String> list = this.f2420a;
        return list.get(list.size() - 1).equals("**");
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("KeyPath{keys=");
        sb.append(this.f2420a);
        sb.append(",resolved=");
        sb.append(this.f2421b != null);
        sb.append('}');
        return sb.toString();
    }
}
