package com.airbnb.lottie.c;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: KeyPath */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public static final e f1716a = new e("COMPOSITION");

    /* renamed from: b  reason: collision with root package name */
    private final List<String> f1717b;
    private f c;

    public e(String... strArr) {
        this.f1717b = Arrays.asList(strArr);
    }

    private e(e eVar) {
        this.f1717b = new ArrayList(eVar.f1717b);
        this.c = eVar.c;
    }

    public e a(String str) {
        e eVar = new e(this);
        eVar.f1717b.add(str);
        return eVar;
    }

    public e a(f fVar) {
        e eVar = new e(this);
        eVar.c = fVar;
        return eVar;
    }

    public f a() {
        return this.c;
    }

    public boolean a(String str, int i) {
        if (b(str)) {
            return true;
        }
        if (i >= this.f1717b.size()) {
            return false;
        }
        if (this.f1717b.get(i).equals(str) || this.f1717b.get(i).equals("**") || this.f1717b.get(i).equals("*")) {
            return true;
        }
        return false;
    }

    public int b(String str, int i) {
        if (b(str)) {
            return 0;
        }
        if (!this.f1717b.get(i).equals("**")) {
            return 1;
        }
        if (i != this.f1717b.size() - 1 && this.f1717b.get(i + 1).equals(str)) {
            return 2;
        }
        return 0;
    }

    public boolean c(String str, int i) {
        if (i >= this.f1717b.size()) {
            return false;
        }
        boolean z = i == this.f1717b.size() - 1;
        String str2 = this.f1717b.get(i);
        if (!str2.equals("**")) {
            boolean z2 = str2.equals(str) || str2.equals("*");
            if ((z || (i == this.f1717b.size() - 2 && b())) && z2) {
                return true;
            }
            return false;
        }
        if (!z && this.f1717b.get(i + 1).equals(str)) {
            if (i == this.f1717b.size() - 2 || (i == this.f1717b.size() - 3 && b())) {
                return true;
            }
            return false;
        } else if (z) {
            return true;
        } else {
            int i2 = i + 1;
            if (i2 < this.f1717b.size() - 1) {
                return false;
            }
            return this.f1717b.get(i2).equals(str);
        }
    }

    public boolean d(String str, int i) {
        if (!"__container".equals(str) && i >= this.f1717b.size() - 1 && !this.f1717b.get(i).equals("**")) {
            return false;
        }
        return true;
    }

    private boolean b(String str) {
        return "__container".equals(str);
    }

    private boolean b() {
        List<String> list = this.f1717b;
        return list.get(list.size() - 1).equals("**");
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("KeyPath{keys=");
        sb.append(this.f1717b);
        sb.append(",resolved=");
        sb.append(this.c != null);
        sb.append('}');
        return sb.toString();
    }
}
