package com.heytap.tingle.ipc;

import android.os.IBinder;
import android.os.RemoteException;
import com.heytap.tingle.ipc.b;
import com.heytap.tingle.ipc.b.d;
import com.heytap.tingle.ipc.b.e;
import com.heytap.tingle.ipc.d.a;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: Slave */
public class c {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static b f2657a;

    /* renamed from: b  reason: collision with root package name */
    private static List<Object> f2658b = new ArrayList();
    private static List<Object> c = new CopyOnWriteArrayList();

    static void a(IBinder iBinder) {
        if (iBinder != null) {
            try {
                iBinder.linkToDeath($$Lambda$c$cndoCGWLB9ltcVys02ncaGJYqNY.INSTANCE, 0);
                f2657a = b.a.a(iBinder);
            } catch (RemoteException e) {
                a.a("Slave", "attach linkToDeath Error : " + e, new Object[0]);
            }
        }
        a();
        b();
    }

    private static void a() {
        f2658b.add(new d());
        f2658b.add(new e());
        f2658b.add(new com.heytap.tingle.ipc.b.a());
        f2658b.add(new com.heytap.tingle.ipc.b.b());
        f2658b.add(new com.heytap.tingle.ipc.b.c());
    }

    private static void b() {
        c.add(new com.heytap.tingle.ipc.c.a.a());
        c.add(new com.heytap.tingle.ipc.c.d.a());
        c.add(new com.heytap.tingle.ipc.c.a.b());
        c.add(new com.heytap.tingle.ipc.c.e.a());
        c.add(new com.heytap.tingle.ipc.c.c.a.a());
        c.add(new com.heytap.tingle.ipc.c.b.a());
    }
}
