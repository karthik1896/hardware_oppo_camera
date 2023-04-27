package com.heytap.epona.b.b;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.heytap.epona.Request;
import com.heytap.epona.Response;
import com.heytap.epona.a;
import com.heytap.epona.c;
import com.heytap.epona.d;
import com.heytap.epona.e;
import com.heytap.shield.b;
import com.sensetime.stmobile.STMobileHumanActionNative;
import java.util.HashMap;
import java.util.Map;

/* compiled from: RemoteTransfer */
public class a extends d.a {

    /* renamed from: a  reason: collision with root package name */
    private static volatile a f2582a;

    /* renamed from: b  reason: collision with root package name */
    private Map<String, d> f2583b = new HashMap();

    private a() {
    }

    public static a b() {
        if (f2582a == null) {
            synchronized (a.class) {
                if (f2582a == null) {
                    f2582a = new a();
                }
            }
        }
        return f2582a;
    }

    public Response a(Request request) throws RemoteException {
        if (!b.b().a() || b(request)) {
            return c.a(request).a();
        }
        com.heytap.epona.e.a.b("RemoteTransfer", "Epona Authentication failed, request : " + request.toString(), new Object[0]);
        return Response.errorResponse("Epona Authentication failed, request : " + request.toString());
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        try {
            return super.onTransact(i, parcel, parcel2, i2);
        } catch (RuntimeException e) {
            com.heytap.epona.e.a.b("RemoteTransfer", "onTransact Exception: " + e.toString(), new Object[0]);
            throw e;
        }
    }

    public void a(Request request, e eVar) throws RemoteException {
        if (!b.b().a() || b(request)) {
            c.a(request).a((a.C0068a) new a.C0068a() {
                public final void onReceive(Response response) {
                    a.a(e.this, response);
                }
            });
            return;
        }
        com.heytap.epona.e.a.b("RemoteTransfer", "Epona Authentication failed, request : " + request.toString(), new Object[0]);
        eVar.a(Response.errorResponse("Epona Authentication failed, request : " + request.toString()));
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void a(e eVar, Response response) {
        try {
            eVar.a(response);
        } catch (RemoteException e) {
            com.heytap.epona.e.a.b("RemoteTransfer", "failed to asyncCall and exception is %s", e.toString());
        }
    }

    public d a(String str) {
        IBinder iBinder = null;
        if (!c()) {
            com.heytap.epona.e.a.a("RemoteTransfer", "DispatcherProvider is not exist", new Object[0]);
            return null;
        }
        d dVar = this.f2583b.get(str);
        if (dVar == null) {
            Context c = c.c();
            if ("com.heytap.appplatform".equals(c.getPackageName())) {
                iBinder = com.heytap.epona.b.c.a.a().a(str);
            } else {
                new Bundle().putString("com.heytap.epona.Dispatcher.TRANSFER_KEY", str);
                Bundle a2 = com.heytap.epona.e.b.a(c, str);
                if (a2 != null) {
                    iBinder = a2.getBinder("com.heytap.epona.Dispatcher.TRANSFER_VALUE");
                } else {
                    com.heytap.epona.e.a.b("RemoteTransfer", "Find remote transfer bundle null.", new Object[0]);
                }
            }
            if (iBinder != null) {
                dVar = d.a.a(iBinder);
                this.f2583b.put(str, dVar);
                try {
                    iBinder.linkToDeath(new IBinder.DeathRecipient(str) {
                        private final /* synthetic */ String f$1;

                        {
                            this.f$1 = r2;
                        }

                        public final void binderDied() {
                            a.this.b(this.f$1);
                        }
                    }, 0);
                } catch (RemoteException e) {
                    com.heytap.epona.e.a.c("RemoteTransfer", e.toString(), new Object[0]);
                }
            } else {
                com.heytap.epona.e.a.b("RemoteTransfer", "Get remote binder null. ComponentName : %s", str);
            }
        }
        return dVar;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(String str) {
        d remove = this.f2583b.remove(str);
    }

    private boolean c() {
        Context c = c.c();
        if (c == null || c.getPackageManager().resolveContentProvider("com.heytap.appplatform.dispatcher", STMobileHumanActionNative.ST_MOBILE_DETECT_MODE_VIDEO) == null) {
            return false;
        }
        return true;
    }

    private boolean b(Request request) {
        if (request == null || c.b() == null) {
            com.heytap.epona.e.a.b("RemoteTransfer", "Request is null.", new Object[0]);
            return true;
        }
        String packageName = c.b().getPackageName();
        return b.b().a(request.getComponentName(), request.getActionName(), packageName);
    }
}
