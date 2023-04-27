package androidx.room;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import androidx.room.c;
import androidx.room.d;
import androidx.room.f;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: MultiInstanceInvalidationClient */
class g {

    /* renamed from: a  reason: collision with root package name */
    final Context f1195a;

    /* renamed from: b  reason: collision with root package name */
    final String f1196b;
    int c;
    final f d;
    final f.b e;
    d f;
    final Executor g;
    final c h = new c.a() {
        public void a(final String[] strArr) {
            g.this.g.execute(new Runnable() {
                public void run() {
                    g.this.d.a(strArr);
                }
            });
        }
    };
    final AtomicBoolean i = new AtomicBoolean(false);
    final ServiceConnection j = new ServiceConnection() {
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            g.this.f = d.a.a(iBinder);
            g.this.g.execute(g.this.k);
        }

        public void onServiceDisconnected(ComponentName componentName) {
            g.this.g.execute(g.this.l);
            g.this.f = null;
        }
    };
    final Runnable k = new Runnable() {
        public void run() {
            try {
                d dVar = g.this.f;
                if (dVar != null) {
                    g.this.c = dVar.a(g.this.h, g.this.f1196b);
                    g.this.d.a(g.this.e);
                }
            } catch (RemoteException e) {
                Log.w("ROOM", "Cannot register multi-instance invalidation callback", e);
            }
        }
    };
    final Runnable l = new Runnable() {
        public void run() {
            g.this.d.b(g.this.e);
        }
    };
    private final Runnable m = new Runnable() {
        public void run() {
            g.this.d.b(g.this.e);
            try {
                d dVar = g.this.f;
                if (dVar != null) {
                    dVar.a(g.this.h, g.this.c);
                }
            } catch (RemoteException e) {
                Log.w("ROOM", "Cannot unregister multi-instance invalidation callback", e);
            }
            g.this.f1195a.unbindService(g.this.j);
        }
    };

    g(Context context, String str, f fVar, Executor executor) {
        this.f1195a = context.getApplicationContext();
        this.f1196b = str;
        this.d = fVar;
        this.g = executor;
        this.e = new f.b((String[]) fVar.f1187a.keySet().toArray(new String[0])) {
            /* access modifiers changed from: package-private */
            public boolean a() {
                return true;
            }

            public void a(Set<String> set) {
                if (!g.this.i.get()) {
                    try {
                        d dVar = g.this.f;
                        if (dVar != null) {
                            dVar.a(g.this.c, (String[]) set.toArray(new String[0]));
                        }
                    } catch (RemoteException e) {
                        Log.w("ROOM", "Cannot broadcast invalidation", e);
                    }
                }
            }
        };
        this.f1195a.bindService(new Intent(this.f1195a, MultiInstanceInvalidationService.class), this.j, 1);
    }
}
