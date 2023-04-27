package com.coloros.anim.a.a;

import android.graphics.Path;
import com.coloros.anim.f.g;
import java.util.ArrayList;
import java.util.List;

/* compiled from: CompoundTrimPathContent */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private List<s> f2296a = new ArrayList();

    /* access modifiers changed from: package-private */
    public void a(s sVar) {
        this.f2296a.add(sVar);
    }

    public void a(Path path) {
        for (int size = this.f2296a.size() - 1; size >= 0; size--) {
            g.a(path, this.f2296a.get(size));
        }
    }
}
