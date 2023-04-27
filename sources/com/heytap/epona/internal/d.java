package com.heytap.epona.internal;

import com.heytap.epona.Request;
import com.heytap.epona.Response;
import com.heytap.epona.a;
import com.heytap.epona.d.c;
import com.heytap.epona.i;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: RealCall */
public class d implements com.heytap.epona.a {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final i f2607a;

    /* renamed from: b  reason: collision with root package name */
    private final Request f2608b;
    private AtomicBoolean c = new AtomicBoolean(false);

    private d(i iVar, Request request) {
        this.f2607a = iVar;
        this.f2608b = request;
    }

    public static d a(i iVar, Request request) {
        return new d(iVar, request);
    }

    public Response a() {
        c.a().a((com.heytap.epona.d.b) new com.heytap.epona.d.a(true));
        if (this.c.getAndSet(true)) {
            com.heytap.epona.e.a.c("RealCall", "execute has been executed", new Object[0]);
            return Response.defaultErrorResponse();
        }
        try {
            this.f2607a.a(this);
            b bVar = new b();
            a((a.C0068a) bVar, false);
            return bVar.a();
        } finally {
            this.f2607a.b(this);
        }
    }

    public void a(a.C0068a aVar) {
        c.a().a((com.heytap.epona.d.b) new com.heytap.epona.d.a(false));
        a aVar2 = new a(aVar);
        if (this.c.getAndSet(true)) {
            com.heytap.epona.e.a.c("RealCall", "asyncExecute has been executed", new Object[0]);
            aVar.onReceive(Response.defaultErrorResponse());
        }
        this.f2607a.a(aVar2);
    }

    /* access modifiers changed from: private */
    public void a(a.C0068a aVar, boolean z) {
        ArrayList arrayList = new ArrayList(com.heytap.epona.c.a());
        arrayList.add(new com.heytap.epona.a.a());
        arrayList.add(new com.heytap.epona.a.c());
        arrayList.add(new com.heytap.epona.a.d());
        arrayList.add(new com.heytap.epona.a.b());
        new e(arrayList, 0, this.f2608b, aVar, z).d();
    }

    /* compiled from: RealCall */
    private static class b implements a.C0068a {

        /* renamed from: a  reason: collision with root package name */
        private Response f2611a;

        private b() {
            this.f2611a = null;
        }

        public void onReceive(Response response) {
            this.f2611a = response;
        }

        public Response a() {
            return this.f2611a;
        }
    }

    /* compiled from: RealCall */
    public class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        private final a.C0068a f2610b;

        a(a.C0068a aVar) {
            this.f2610b = aVar;
        }

        /* JADX WARNING: type inference failed for: r0v0, types: [boolean] */
        public void run() {
            int i = 0;
            i = 1;
            try {
                d.this.a(this.f2610b, (boolean) i);
            } catch (Exception e) {
                Object[] objArr = new Object[i];
                objArr[i] = e.toString();
                com.heytap.epona.e.a.b("RealCall", "AsyncCall run failed and exception is %s", objArr);
                this.f2610b.onReceive(Response.defaultErrorResponse());
            } finally {
                d.this.f2607a.a(this, (boolean) i);
            }
        }
    }
}
