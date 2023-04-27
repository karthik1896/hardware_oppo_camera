package com.heytap.epona.a;

import android.os.RemoteException;
import com.heytap.epona.Request;
import com.heytap.epona.Response;
import com.heytap.epona.a;
import com.heytap.epona.b.b.a;
import com.heytap.epona.d;
import com.heytap.epona.e;
import com.heytap.epona.f;

/* compiled from: CallIPCComponentInterceptor */
public class b implements f {
    public void a(f.a aVar) {
        final Request a2 = aVar.a();
        d a3 = a.b().a(a2.getComponentName());
        if (a3 != null) {
            final a.C0068a b2 = aVar.b();
            try {
                if (aVar.c()) {
                    a3.a(a2, new e.a() {
                        public void a(Response response) throws RemoteException {
                            com.heytap.epona.e.a.a("CallIPCComponentInterceptor", "Component(%s).Action(%s) response : %s", a2.getComponentName(), a2.getActionName(), response);
                            b2.onReceive(response);
                        }
                    });
                    return;
                }
                Response a4 = a3.a(a2);
                com.heytap.epona.e.a.a("CallIPCComponentInterceptor", "Component(%s).Action(%s) response : %s", a2.getComponentName(), a2.getActionName(), a4);
                b2.onReceive(a4);
            } catch (RemoteException e) {
                com.heytap.epona.e.a.b("CallIPCComponentInterceptor", "fail to call %s#%s and exception is %s", a2.getComponentName(), a2.getActionName(), e.toString());
                b2.onReceive(Response.defaultErrorResponse());
            }
        } else {
            aVar.d();
        }
    }
}
