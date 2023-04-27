package com.oppo.camera;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.SharedPreferences;
import android.database.ContentObserver;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.oppo.camera.statistics.CameraStatisticsUtil;
import com.oppo.camera.statistics.model.EnterExitDcsMsgData;
import com.oppo.camera.util.Util;
import java.util.HashSet;

/* compiled from: LocationManager */
public class o {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public long f3136a = 0;

    /* renamed from: b  reason: collision with root package name */
    private Activity f3137b = null;
    /* access modifiers changed from: private */
    public LocationManager c = null;
    private String d = "off";
    private String e = "off";
    private String f = "off";
    /* access modifiers changed from: private */
    public boolean g = false;
    private String h = null;
    private k i = null;
    private ContentResolver j = null;
    private b k = null;
    /* access modifiers changed from: private */
    public Handler l = null;
    private Runnable m = null;
    /* access modifiers changed from: private */
    public Runnable n = null;
    private int o = 1;
    /* access modifiers changed from: private */
    public f p = null;
    private HandlerThread q;
    /* access modifiers changed from: private */
    public e[] r = {new e("gps"), new e(EnterExitDcsMsgData.STATEMENT_TYPE_NETWORK)};

    /* compiled from: LocationManager */
    public interface f {
        void a(Location location, boolean z);

        boolean a();
    }

    public o(Activity activity, k kVar) {
        this.f3137b = activity;
        this.i = kVar;
        this.j = this.f3137b.getApplicationContext().getContentResolver();
        this.k = new b(new Handler());
        this.q = new HandlerThread("LocationManagerHandlerThread");
        this.q.start();
        this.l = new Handler(this.q.getLooper());
        this.m = new c();
        this.n = new d();
    }

    public void a(int i2) {
        this.o = i2;
    }

    public void a(f fVar) {
        this.p = fVar;
    }

    public Location a() {
        if (("off".equals(this.d) && "off".equals(this.e) && "off".equals(this.f)) || this.r == null) {
            return null;
        }
        int i2 = 0;
        while (true) {
            e[] eVarArr = this.r;
            if (i2 < eVarArr.length) {
                Location a2 = eVarArr[i2].a();
                if (a2 != null) {
                    return a2;
                }
                i2++;
            } else {
                e.a("LocationManager", "getCurrentLocation, No location received yet.");
                return null;
            }
        }
    }

    public void b() {
        this.g = false;
        Activity activity = this.f3137b;
        if (activity == null || !Util.p(activity)) {
            this.d = "off";
            this.e = "off";
            this.f = "off";
            SharedPreferences.Editor edit = this.i.edit();
            edit.putString("pref_camera_recordlocation_key", "off");
            edit.putString("pref_slogan_location_key", "off");
            edit.putString("pref_video_slogan_location_key", "off");
            edit.apply();
        } else {
            this.d = this.i.getString("pref_camera_recordlocation_key", this.f3137b.getString(R.string.camera_location_default_value));
            this.e = this.i.getString("pref_slogan_location_key", this.f3137b.getString(R.string.camera_slogan_default_value));
            this.f = this.i.getString("pref_video_slogan_location_key", this.f3137b.getString(R.string.camera_slogan_default_value));
        }
        boolean n2 = n();
        e.a("LocationManager", "onResume, mRecordLocationState: " + this.d + ", isLocationSloganOpen: " + g() + ", allowNetworkAccess: " + n2);
        if (("on".equals(this.d) || "on".equals(this.e) || "on".equals(this.f)) && n2) {
            if (System.currentTimeMillis() - this.f3136a >= 600000) {
                e.a("LocationManager", "onResume, location is invalid");
                e[] eVarArr = this.r;
                if (eVarArr[0] != null) {
                    eVarArr[0].a(false);
                }
                e[] eVarArr2 = this.r;
                if (eVarArr2[1] != null) {
                    eVarArr2[1].a(false);
                }
            }
            h();
        }
    }

    public void c() {
        k kVar = this.i;
        if (kVar != null && this.f3137b != null && "on".equals(kVar.getString("pref_camera_recordlocation_key", "on")) && !Util.p(this.f3137b)) {
            this.i.edit().putString("pref_camera_recordlocation_key", "off").apply();
            this.d = "off";
        }
    }

    public void d() {
        b bVar;
        this.g = true;
        m();
        k();
        ContentResolver contentResolver = this.j;
        if (contentResolver != null && (bVar = this.k) != null) {
            contentResolver.unregisterContentObserver(bVar);
        }
    }

    public void e() {
        this.g = true;
        this.i = null;
        this.r = null;
        this.c = null;
        this.f3137b = null;
        this.k = null;
        this.j = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.p = null;
        HandlerThread handlerThread = this.q;
        if (handlerThread != null) {
            handlerThread.quitSafely();
            this.q = null;
        }
    }

    public String f() {
        return this.d;
    }

    public boolean g() {
        return "on".equals(this.e) || "on".equals(this.f);
    }

    public void h() {
        f fVar = this.p;
        if (fVar != null && fVar.a() && n()) {
            if ("on".equals(this.d) || "on".equals(this.e) || "on".equals(this.f)) {
                i();
                return;
            }
            k();
            m();
        }
    }

    @SuppressLint({"MissingPermission"})
    private void i() {
        Location lastKnownLocation;
        if (this.c == null) {
            this.c = (LocationManager) this.f3137b.getApplicationContext().getSystemService(CameraStatisticsUtil.PORTRAIT_LOCATION);
        }
        LocationManager locationManager = this.c;
        if (!(locationManager == null || (lastKnownLocation = locationManager.getLastKnownLocation(EnterExitDcsMsgData.STATEMENT_TYPE_NETWORK)) == null || this.p == null || System.currentTimeMillis() - lastKnownLocation.getTime() >= 360000)) {
            this.p.a(lastKnownLocation, true);
        }
        LocationManager locationManager2 = this.c;
        if (locationManager2 != null) {
            boolean isProviderEnabled = locationManager2.isProviderEnabled(EnterExitDcsMsgData.STATEMENT_TYPE_NETWORK);
            e.a("LocationManager", "startReceivingLocationUpdates, ntpEnable: " + isProviderEnabled);
            if (isProviderEnabled) {
                try {
                    this.c.requestLocationUpdates(EnterExitDcsMsgData.STATEMENT_TYPE_NETWORK, 1000, 300.0f, this.r[1]);
                } catch (SecurityException e2) {
                    e.b("LocationManager", "startReceivingLocationUpdates, fail to request location update", e2);
                } catch (IllegalArgumentException e3) {
                    e.b("LocationManager", "startReceivingLocationUpdates, provider does not exist" + e3.getMessage());
                }
                this.l.postDelayed(this.m, 3000);
                return;
            }
            j();
        }
    }

    /* access modifiers changed from: private */
    public void j() {
        e.a("LocationManager", "startGpsReceivingLocationUpdates, mActivity: " + this.f3137b + ", mbPaused: " + this.g);
        Activity activity = this.f3137b;
        if (activity != null && !this.g) {
            if (this.c == null) {
                this.c = (LocationManager) activity.getApplicationContext().getSystemService(CameraStatisticsUtil.PORTRAIT_LOCATION);
            }
            this.l.post(new Runnable() {
                public void run() {
                    try {
                        e.b("LocationManager", "startGpsReceivingLocationUpdates, requestLocationUpdates post to handler thread");
                        o.this.c.requestLocationUpdates("gps", 1000, 300.0f, o.this.r[0]);
                    } catch (SecurityException e) {
                        e.d("LocationManager", "startGpsReceivingLocationUpdates, fail to request location update", e);
                    } catch (IllegalArgumentException e2) {
                        e.e("LocationManager", "startGpsReceivingLocationUpdates, provider does not exist" + e2.getMessage());
                    }
                    if (o.this.l != null) {
                        o.this.l.postDelayed(o.this.n, 45000);
                    }
                    e.a("LocationManager", "startGpsReceivingLocationUpdates, post GPS timeout runnable");
                }
            });
        }
    }

    private void k() {
        if (this.c != null) {
            int i2 = 0;
            while (true) {
                e[] eVarArr = this.r;
                if (i2 < eVarArr.length) {
                    try {
                        this.c.removeUpdates(eVarArr[i2]);
                    } catch (Exception e2) {
                        e.a("LocationManager", "stopReceivingLocationUpdates, fail to remove location listners", (Throwable) e2);
                    }
                    i2++;
                } else {
                    e.a("LocationManager", "stopReceivingLocationUpdates");
                    return;
                }
            }
        }
    }

    /* compiled from: LocationManager */
    public class c implements Runnable {
        public c() {
        }

        public void run() {
            if (o.this.r != null && o.this.a() == null && !o.this.g) {
                o.this.j();
            }
        }
    }

    /* compiled from: LocationManager */
    public class d implements Runnable {
        public d() {
        }

        public void run() {
            o.this.l();
        }
    }

    /* compiled from: LocationManager */
    private class b extends ContentObserver {
        public b(Handler handler) {
            super(handler);
        }
    }

    /* compiled from: LocationManager */
    private class e implements LocationListener {

        /* renamed from: b  reason: collision with root package name */
        private Location f3145b;
        private boolean c = false;
        private String d;

        public void onProviderEnabled(String str) {
        }

        public e(String str) {
            this.d = str;
            this.f3145b = new Location(this.d);
        }

        public void a(boolean z) {
            this.c = z;
        }

        public void onLocationChanged(Location location) {
            if (location.getLatitude() != 0.0d || location.getLongitude() != 0.0d) {
                if (o.this.g) {
                    e.a("LocationManager", "onLocationChanged after pause, so return");
                    return;
                }
                e.b("LocationManager", "LocationListener, onLocationChanged, mProvider: " + this.d + ", mbValid: " + this.c);
                long unused = o.this.f3136a = System.currentTimeMillis();
                this.f3145b.set(location);
                this.c = true;
                if (o.this.p != null) {
                    o.this.p.a(location, false);
                }
                o.this.l();
            }
        }

        public void onProviderDisabled(String str) {
            e.a("LocationManager", "onProviderDisabled, mbValid: " + this.c);
            this.c = false;
        }

        public void onStatusChanged(String str, int i, Bundle bundle) {
            e.a("LocationManager", "onStatusChanged, status: " + i + ", mbValid: " + this.c);
            if (i == 0) {
                this.c = false;
            }
        }

        public Location a() {
            if (this.c) {
                return this.f3145b;
            }
            return null;
        }
    }

    /* access modifiers changed from: private */
    public void l() {
        m();
        LocationManager locationManager = this.c;
        if (locationManager != null) {
            e[] eVarArr = this.r;
            if (eVarArr[0] != null) {
                try {
                    locationManager.removeUpdates(eVarArr[0]);
                } catch (Exception e2) {
                    e.a("LocationManager", "stopGpsReceivingLocationUpdates, fail to remove location listeners", (Throwable) e2);
                }
                e.a("LocationManager", "stopGpsReceivingLocationUpdates X");
            }
        }
    }

    private void m() {
        Handler handler = this.l;
        if (handler != null) {
            handler.removeCallbacks(this.m);
            this.l.removeCallbacks(this.n);
        }
    }

    private boolean n() {
        if (com.oppo.camera.w.b.g() || this.i.getBoolean("pref_allow_network_access", false)) {
            return true;
        }
        return false;
    }

    /* compiled from: LocationManager */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f3139a = null;

        /* renamed from: b  reason: collision with root package name */
        public String f3140b = null;
        public String c = null;
        public String d = null;
        public String e = null;
        public String f = null;
        public String g = null;
        public String h = null;
        public Location i = null;

        public void a(String str) {
            if (TextUtils.isEmpty(str) || !a().contains(str)) {
                this.g = str;
            }
        }

        public void b(String str) {
            if (TextUtils.isEmpty(str) || !a().contains(str)) {
                this.f = str;
            }
        }

        public void c(String str) {
            if (TextUtils.isEmpty(str) || !a().contains(str)) {
                this.e = str;
            }
        }

        public void d(String str) {
            if (TextUtils.isEmpty(str) || !a().contains(str)) {
                this.d = str;
            }
        }

        public void e(String str) {
            if (TextUtils.isEmpty(str) || !a().contains(str)) {
                this.c = str;
            }
        }

        public void f(String str) {
            if (TextUtils.isEmpty(str) || !a().contains(str)) {
                this.f3140b = str;
            }
        }

        public void g(String str) {
            if (TextUtils.isEmpty(str) || !a().contains(str)) {
                this.f3139a = str;
            }
        }

        public void h(String str) {
            this.h = str;
        }

        private HashSet<String> a() {
            HashSet<String> hashSet = new HashSet<>();
            hashSet.add(this.g);
            hashSet.add(this.f);
            hashSet.add(this.e);
            hashSet.add(this.d);
            hashSet.add(this.c);
            hashSet.add(this.f3140b);
            hashSet.add(this.f3139a);
            return hashSet;
        }

        public String toString() {
            return this.g + "_" + this.f + "_" + this.e + "_" + this.d + "_" + this.c + "_" + this.f3140b + "_" + this.f3139a + "_";
        }
    }
}
