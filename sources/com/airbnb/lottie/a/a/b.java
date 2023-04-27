package com.airbnb.lottie.a.a;

import android.graphics.Path;
import com.airbnb.lottie.f.h;
import java.util.ArrayList;
import java.util.List;

/* compiled from: CompoundTrimPathContent */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private List<s> f1618a = new ArrayList();

    /* access modifiers changed from: package-private */
    public void a(s sVar) {
        this.f1618a.add(sVar);
    }

    public void a(Path path) {
        for (int size = this.f1618a.size() - 1; size >= 0; size--) {
            h.a(path, this.f1618a.get(size));
        }
    }
}
