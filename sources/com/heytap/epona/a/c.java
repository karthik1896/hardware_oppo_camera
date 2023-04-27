package com.heytap.epona.a;

import com.heytap.epona.Request;
import com.heytap.epona.Response;
import com.heytap.epona.a;
import com.heytap.epona.c.a;
import com.heytap.epona.f;

/* compiled from: CallProviderInterceptor */
public class c implements f {
    public void a(f.a aVar) {
        Request a2 = aVar.a();
        String componentName = a2.getComponentName();
        a b2 = com.heytap.epona.c.b(componentName);
        if (b2 != null) {
            a.C0068a b3 = aVar.b();
            try {
                String actionName = a2.getActionName();
                if (aVar.c()) {
                    b2.a(actionName).invoke((Object) null, new Object[]{a2, new a.C0068a(b3) {
                        private final /* synthetic */ a.C0068a f$1;

                        {
                            this.f$1 = r2;
                        }

                        public final void onReceive(Response response) {
                            c.a(Request.this, this.f$1, response);
                        }
                    }});
                    return;
                }
                Response response = (Response) b2.a(actionName).invoke((Object) null, new Object[]{a2});
                com.heytap.epona.e.a.a("CallProviderInterceptor", "Component(%s).Action(%s) response : %s", a2.getComponentName(), a2.getActionName(), response);
                b3.onReceive(response);
            } catch (Exception e) {
                com.heytap.epona.e.a.b("CallProviderInterceptor", "fail to run static provider with componentName = %s and exception is %s", componentName, e.toString());
                b3.onReceive(Response.defaultErrorResponse());
            }
        } else {
            aVar.d();
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void a(Request request, a.C0068a aVar, Response response) {
        com.heytap.epona.e.a.a("CallProviderInterceptor", "Component(%s).Action(%s) response : %s", request.getComponentName(), request.getActionName(), response);
        aVar.onReceive(response);
    }
}
