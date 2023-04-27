package com.heytap.shield.authcode;

import com.heytap.shield.b.h;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: PermissionTable */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private List<String> f2635a = new CopyOnWriteArrayList();

    public d(String str) {
        this.f2635a.clear();
        this.f2635a.addAll(h.a(str, ","));
    }

    public boolean a(String str) {
        if (this.f2635a.size() != 0) {
            return this.f2635a.contains(str);
        }
        return false;
    }
}
