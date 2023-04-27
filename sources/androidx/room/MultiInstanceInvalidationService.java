package androidx.room;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.util.Log;
import androidx.room.d;
import java.util.HashMap;

public class MultiInstanceInvalidationService extends Service {

    /* renamed from: a  reason: collision with root package name */
    int f1165a = 0;

    /* renamed from: b  reason: collision with root package name */
    final HashMap<Integer, String> f1166b = new HashMap<>();
    final RemoteCallbackList<c> c = new RemoteCallbackList<c>() {
        /* renamed from: a */
        public void onCallbackDied(c cVar, Object obj) {
            MultiInstanceInvalidationService.this.f1166b.remove(Integer.valueOf(((Integer) obj).intValue()));
        }
    };
    private final d.a d = new d.a() {
        public int a(c cVar, String str) {
            if (str == null) {
                return 0;
            }
            synchronized (MultiInstanceInvalidationService.this.c) {
                MultiInstanceInvalidationService multiInstanceInvalidationService = MultiInstanceInvalidationService.this;
                int i = multiInstanceInvalidationService.f1165a + 1;
                multiInstanceInvalidationService.f1165a = i;
                if (MultiInstanceInvalidationService.this.c.register(cVar, Integer.valueOf(i))) {
                    MultiInstanceInvalidationService.this.f1166b.put(Integer.valueOf(i), str);
                    return i;
                }
                MultiInstanceInvalidationService multiInstanceInvalidationService2 = MultiInstanceInvalidationService.this;
                multiInstanceInvalidationService2.f1165a--;
                return 0;
            }
        }

        public void a(c cVar, int i) {
            synchronized (MultiInstanceInvalidationService.this.c) {
                MultiInstanceInvalidationService.this.c.unregister(cVar);
                MultiInstanceInvalidationService.this.f1166b.remove(Integer.valueOf(i));
            }
        }

        public void a(int i, String[] strArr) {
            synchronized (MultiInstanceInvalidationService.this.c) {
                String str = MultiInstanceInvalidationService.this.f1166b.get(Integer.valueOf(i));
                if (str == null) {
                    Log.w("ROOM", "Remote invalidation client ID not registered");
                    return;
                }
                int beginBroadcast = MultiInstanceInvalidationService.this.c.beginBroadcast();
                for (int i2 = 0; i2 < beginBroadcast; i2++) {
                    try {
                        int intValue = ((Integer) MultiInstanceInvalidationService.this.c.getBroadcastCookie(i2)).intValue();
                        String str2 = MultiInstanceInvalidationService.this.f1166b.get(Integer.valueOf(intValue));
                        if (i != intValue && str.equals(str2)) {
                            MultiInstanceInvalidationService.this.c.getBroadcastItem(i2).a(strArr);
                        }
                    } catch (RemoteException e) {
                        Log.w("ROOM", "Error invoking a remote callback", e);
                    } catch (Throwable th) {
                        MultiInstanceInvalidationService.this.c.finishBroadcast();
                        throw th;
                    }
                }
                MultiInstanceInvalidationService.this.c.finishBroadcast();
            }
        }
    };

    public IBinder onBind(Intent intent) {
        return this.d;
    }
}
