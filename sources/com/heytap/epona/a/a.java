package com.heytap.epona.a;

import com.heytap.epona.Request;
import com.heytap.epona.Response;
import com.heytap.epona.a;
import com.heytap.epona.b;
import com.heytap.epona.c;
import com.heytap.epona.f;

/* compiled from: CallComponentInterceptor */
public class a implements f {
    public void a(f.a aVar) {
        Request a2 = aVar.a();
        b a3 = c.a(a2.getComponentName());
        if (a3 != null) {
            a.C0068a b2 = aVar.b();
            if (aVar.c()) {
                a3.a(a2, new a.C0068a(b2) {
                    private final /* synthetic */ a.C0068a f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void onReceive(Response response) {
                        a.a(Request.this, this.f$1, response);
                    }
                });
                return;
            }
            Response a4 = a3.a(a2);
            com.heytap.epona.e.a.a("CallComponentInterceptor", "Component(%s).Action(%s) response : %s", a2.getComponentName(), a2.getActionName(), a4);
            b2.onReceive(a4);
            return;
        }
        aVar.d();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void a(Request request, a.C0068a aVar, Response response) {
        com.heytap.epona.e.a.a("CallComponentInterceptor", "Component(%s).Action(%s) response : %s", request.getComponentName(), request.getActionName(), response);
        aVar.onReceive(response);
    }
}
