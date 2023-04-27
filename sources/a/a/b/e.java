package a.a.b;

import co.polarr.renderer.entities.FilterItem;
import co.polarr.renderer.entities.FilterPackage;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class e {

    /* renamed from: a  reason: collision with root package name */
    public static final e f42a = new e();

    /* renamed from: b  reason: collision with root package name */
    public List<FilterPackage> f43b;
    public Map<String, FilterItem> c;

    public static e a() {
        return f42a;
    }

    public FilterItem a(String str) {
        if (this.c == null) {
            c();
        }
        return this.c.get(str);
    }

    public List<FilterPackage> b() {
        List<FilterPackage> list = this.f43b;
        if (list == null) {
            return null;
        }
        return list;
    }

    public void c() {
        this.f43b = g.f84a;
        this.c = new HashMap();
        for (FilterPackage filterPackage : this.f43b) {
            for (FilterItem next : filterPackage.filters) {
                next.updateStates();
                this.c.put(next.id, next);
            }
        }
    }
}
