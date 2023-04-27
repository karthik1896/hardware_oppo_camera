package com.heytap.epona.internal;

import com.heytap.epona.Request;
import com.heytap.epona.Response;
import com.heytap.epona.a;
import com.heytap.epona.f;
import java.util.ArrayList;
import java.util.List;

/* compiled from: RealInterceptorChain */
class e implements f.a {

    /* renamed from: a  reason: collision with root package name */
    private final List<f> f2612a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private final int f2613b;
    private final Request c;
    private final a.C0068a d;
    private final boolean e;

    e(List<f> list, int i, Request request, a.C0068a aVar, boolean z) {
        this.f2612a.addAll(list);
        this.f2613b = i;
        this.c = request;
        this.d = aVar;
        this.e = z;
    }

    public Request a() {
        return this.c;
    }

    public a.C0068a b() {
        return this.d;
    }

    public boolean c() {
        return this.e;
    }

    public void d() {
        if (this.f2613b < this.f2612a.size()) {
            this.f2612a.get(this.f2613b).a(a(this.f2613b + 1));
            return;
        }
        this.d.onReceive(Response.defaultErrorResponse());
    }

    private e a(int i) {
        return new e(this.f2612a, i, this.c, this.d, this.e);
    }
}
