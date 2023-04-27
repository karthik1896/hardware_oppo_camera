package androidx.appcompat.app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.util.Log;
import androidx.core.content.b;
import com.oppo.camera.statistics.CameraStatisticsUtil;
import com.oppo.camera.statistics.model.EnterExitDcsMsgData;
import java.util.Calendar;

/* compiled from: TwilightManager */
class k {

    /* renamed from: a  reason: collision with root package name */
    private static k f189a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f190b;
    private final LocationManager c;
    private final a d = new a();

    static k a(Context context) {
        if (f189a == null) {
            Context applicationContext = context.getApplicationContext();
            f189a = new k(applicationContext, (LocationManager) applicationContext.getSystemService(CameraStatisticsUtil.PORTRAIT_LOCATION));
        }
        return f189a;
    }

    k(Context context, LocationManager locationManager) {
        this.f190b = context;
        this.c = locationManager;
    }

    /* access modifiers changed from: package-private */
    public boolean a() {
        a aVar = this.d;
        if (c()) {
            return aVar.f191a;
        }
        Location b2 = b();
        if (b2 != null) {
            a(b2);
            return aVar.f191a;
        }
        Log.i("TwilightManager", "Could not get last known location. This is probably because the app does not have any location permissions. Falling back to hardcoded sunrise/sunset values.");
        int i = Calendar.getInstance().get(11);
        return i < 6 || i >= 22;
    }

    @SuppressLint({"MissingPermission"})
    private Location b() {
        Location location = null;
        Location a2 = b.a(this.f190b, "android.permission.ACCESS_COARSE_LOCATION") == 0 ? a(EnterExitDcsMsgData.STATEMENT_TYPE_NETWORK) : null;
        if (b.a(this.f190b, "android.permission.ACCESS_FINE_LOCATION") == 0) {
            location = a("gps");
        }
        return (location == null || a2 == null) ? location != null ? location : a2 : location.getTime() > a2.getTime() ? location : a2;
    }

    private Location a(String str) {
        try {
            if (this.c.isProviderEnabled(str)) {
                return this.c.getLastKnownLocation(str);
            }
            return null;
        } catch (Exception e) {
            Log.d("TwilightManager", "Failed to get last known location", e);
            return null;
        }
    }

    private boolean c() {
        return this.d.f > System.currentTimeMillis();
    }

    private void a(Location location) {
        long j;
        a aVar = this.d;
        long currentTimeMillis = System.currentTimeMillis();
        j a2 = j.a();
        j jVar = a2;
        jVar.a(currentTimeMillis - 86400000, location.getLatitude(), location.getLongitude());
        long j2 = a2.f187a;
        jVar.a(currentTimeMillis, location.getLatitude(), location.getLongitude());
        boolean z = true;
        if (a2.c != 1) {
            z = false;
        }
        long j3 = a2.f188b;
        long j4 = j2;
        long j5 = a2.f187a;
        long j6 = j3;
        boolean z2 = z;
        a2.a(86400000 + currentTimeMillis, location.getLatitude(), location.getLongitude());
        long j7 = a2.f188b;
        if (j6 == -1 || j5 == -1) {
            j = 43200000 + currentTimeMillis;
        } else {
            j = (currentTimeMillis > j5 ? 0 + j7 : currentTimeMillis > j6 ? 0 + j5 : 0 + j6) + 60000;
        }
        aVar.f191a = z2;
        aVar.f192b = j4;
        aVar.c = j6;
        aVar.d = j5;
        aVar.e = j7;
        aVar.f = j;
    }

    /* compiled from: TwilightManager */
    private static class a {

        /* renamed from: a  reason: collision with root package name */
        boolean f191a;

        /* renamed from: b  reason: collision with root package name */
        long f192b;
        long c;
        long d;
        long e;
        long f;

        a() {
        }
    }
}
