package com.oppo.camera.u;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.oppo.camera.e;

/* compiled from: HoraeProxyUtil */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static int f3757a = 1;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public IBinder f3758b;
    private IBinder.DeathRecipient c;

    /* compiled from: HoraeProxyUtil */
    private static class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static b f3760a = new b();
    }

    public float a() {
        if (!d()) {
            return -1.0f;
        }
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.oppo.horae.IHoraeService");
            this.f3758b.transact(17, obtain, obtain2, 0);
            float readFloat = obtain2.readFloat();
            e.b("HoraeTest", "getCurrentThermal, skinThermal: " + readFloat);
            return readFloat;
        } catch (Exception e) {
            e.b("HoraeTest", "getCurrentThermal, get SkinThermal has Exception: " + e);
            return -1.0f;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public static b b() {
        return a.f3760a;
    }

    private b() {
        this.c = new IBinder.DeathRecipient() {
            public void binderDied() {
                e.b("HoraeTest", "binderDied");
                IBinder unused = b.this.f3758b = null;
            }
        };
        f3757a = a("persist.sys.horae.enable", 1);
        c();
    }

    private IBinder a(String str) {
        try {
            return (IBinder) Class.forName("android.os.ServiceManager").getDeclaredMethod("checkService", new Class[]{String.class}).invoke((Object) null, new Object[]{str});
        } catch (Exception e) {
            e.e("HoraeTest", "checkService, e: " + e.toString());
            return null;
        }
    }

    private int a(String str, int i) {
        try {
            return ((Integer) Class.forName("android.os.SystemProperties").getDeclaredMethod("getInt", new Class[]{String.class, Integer.TYPE}).invoke((Object) null, new Object[]{str, Integer.valueOf(i)})).intValue();
        } catch (Exception e) {
            e.e("HoraeTest", "getIntSystemProperties, e: " + e.toString());
            return i;
        }
    }

    private synchronized IBinder c() {
        this.f3758b = a("horae");
        if (this.f3758b != null) {
            try {
                this.f3758b.linkToDeath(this.c, 0);
            } catch (RemoteException unused) {
                this.f3758b = null;
            }
        }
        return this.f3758b;
    }

    private boolean d() {
        if (f3757a == 0) {
            e.e("HoraeTest", "horaeEnable, horae is not open");
            return false;
        } else if (this.f3758b != null || c() != null) {
            return true;
        } else {
            e.e("HoraeTest", "horaeEnable, Cannot connect to HoraeService");
            return false;
        }
    }
}
