package com.oppo.camera.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.location.Address;
import android.text.TextUtils;
import com.oppo.camera.MyApplication;
import com.oppo.camera.R;
import com.oppo.camera.e;
import com.oppo.camera.o;
import com.oppo.camera.statistics.CameraStatisticsUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: LocationHelper */
public class b {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final AtomicBoolean f4617a = new AtomicBoolean(false);

    /* renamed from: b  reason: collision with root package name */
    private static final a f4618b = new a();

    /* JADX WARNING: type inference failed for: r2v2, types: [android.os.Parcelable] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.oppo.camera.o.a a(android.content.Context r2, android.location.Location r3) {
        /*
            r0 = 0
            if (r3 == 0) goto L_0x002b
            if (r2 != 0) goto L_0x0006
            goto L_0x002b
        L_0x0006:
            android.os.Bundle r2 = r3.getExtras()
            java.lang.String r3 = "LocationHelper"
            if (r2 != 0) goto L_0x0014
            java.lang.String r2 = "parceLastKnownLocation, geo is null"
            com.oppo.camera.e.d(r3, r2)
            return r0
        L_0x0014:
            java.lang.String r1 = "address"
            android.os.Parcelable r2 = r2.getParcelable(r1)
            boolean r1 = r2 instanceof android.location.Address
            if (r1 == 0) goto L_0x0026
            r0 = r2
            android.location.Address r0 = (android.location.Address) r0
            java.lang.String r2 = "parceLastKnownLocation"
            com.oppo.camera.e.b(r3, r2)
        L_0x0026:
            com.oppo.camera.o$a r2 = a((android.location.Address) r0)
            return r2
        L_0x002b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.util.b.a(android.content.Context, android.location.Location):com.oppo.camera.o$a");
    }

    public static o.a a(Address address) {
        if (address == null) {
            e.d("LocationHelper", "getCameraAddress, address is null");
            return null;
        }
        o.a aVar = new o.a();
        aVar.a(address.getCountryName());
        aVar.b(address.getAdminArea());
        aVar.c(address.getSubAdminArea());
        aVar.d(address.getLocality());
        aVar.e(address.getSubLocality());
        aVar.f(address.getThoroughfare());
        aVar.g(address.getSubThoroughfare());
        aVar.h(address.getCountryCode());
        return aVar;
    }

    public static String a(Context context, o.a aVar) {
        if (aVar == null) {
            e.a("LocationHelper", "getAddressInfoByAddress address is null");
            return "";
        } else if (c(context, aVar) || d(context, aVar)) {
            return aVar.c;
        } else {
            if (e(context, aVar)) {
                return context.getResources().getString(R.string.camera_hongkong_shown);
            }
            if (b(context, aVar)) {
                return context.getResources().getString(R.string.camera_macao_shown);
            }
            List list = null;
            if (!(aVar.g == null || aVar.f == null || aVar.e == null)) {
                aVar.d = null;
            }
            if (f4617a.get()) {
                list = f4618b.f4620b;
            }
            String a2 = com.oppo.camera.w.b.a(context, aVar, (List<String>) list);
            e.b("LocationHelper", "getAddressInfoByAddress, currentAddress: " + a2);
            return a2;
        }
    }

    public static boolean b(Context context, o.a aVar) {
        if (aVar == null) {
            return false;
        }
        if ("MO".equals(aVar.h)) {
            return true;
        }
        Resources resources = context.getResources();
        String string = resources.getString(R.string.camera_macao);
        if ((!TextUtils.isEmpty(aVar.g) && aVar.g.contains(string)) || (!TextUtils.isEmpty(aVar.f) && aVar.f.contains(string))) {
            return true;
        }
        for (String str : resources.getStringArray(R.array.location_mo)) {
            if ((!TextUtils.isEmpty(aVar.g) && aVar.g.contains(str)) || (!TextUtils.isEmpty(aVar.f) && aVar.f.contains(str))) {
                return true;
            }
        }
        return false;
    }

    public static boolean c(Context context, o.a aVar) {
        Resources resources = context.getResources();
        for (String str : resources.getStringArray(R.array.fujian_to_match)) {
            if (!TextUtils.isEmpty(aVar.f) && aVar.f.contains(str)) {
                for (String str2 : resources.getStringArray(R.array.kinmen_to_match)) {
                    if (!TextUtils.isEmpty(aVar.c) && aVar.c.contains(str2)) {
                        return true;
                    }
                }
                continue;
            }
        }
        return false;
    }

    public static boolean d(Context context, o.a aVar) {
        Resources resources = context.getResources();
        for (String str : resources.getStringArray(R.array.fujian_to_match)) {
            if (!TextUtils.isEmpty(aVar.f) && aVar.f.contains(str)) {
                for (String str2 : resources.getStringArray(R.array.lianjiang_to_match)) {
                    if (!TextUtils.isEmpty(aVar.c) && aVar.c.contains(str2)) {
                        return true;
                    }
                }
                continue;
            }
        }
        return false;
    }

    public static boolean e(Context context, o.a aVar) {
        if (aVar == null) {
            return false;
        }
        if ("HK".equals(aVar.h)) {
            return true;
        }
        Resources resources = context.getResources();
        String string = resources.getString(R.string.camera_hongkong);
        if ((!TextUtils.isEmpty(aVar.g) && aVar.g.contains(string)) || (!TextUtils.isEmpty(aVar.f) && aVar.f.contains(string))) {
            return true;
        }
        for (String str : resources.getStringArray(R.array.location_hk)) {
            if ((!TextUtils.isEmpty(aVar.g) && aVar.g.contains(str)) || (!TextUtils.isEmpty(aVar.f) && aVar.f.contains(str))) {
                return true;
            }
        }
        return false;
    }

    public static void a() {
        Util.a((Runnable) new Runnable() {
            public void run() {
                try {
                    e.a("LocationHelper", "parseSensorAreaList");
                    if (!b.f4617a.getAndSet(false)) {
                        b.e();
                    }
                    b.f();
                    b.f4617a.set(true);
                    e.a("LocationHelper", "parseSensorAreaList X");
                } catch (Exception e) {
                    b.f4617a.set(false);
                    e.printStackTrace();
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public static void e() throws JSONException {
        e.a("LocationHelper", "parseSensorAreaConfigFromAsset");
        a(Util.d("sensor_area.json"));
        e.a("LocationHelper", "parseSensorAreaConfigFromAsset X");
    }

    /* access modifiers changed from: private */
    public static void f() throws JSONException {
        SharedPreferences sharedPreferences = MyApplication.d().getSharedPreferences("rom_update_info", 0);
        if (sharedPreferences != null) {
            a(sharedPreferences.getString("sensor_area", (String) null));
        }
    }

    private static void a(String str) throws JSONException {
        if (str != null) {
            JSONObject jSONObject = new JSONObject(str);
            int parseInt = Integer.parseInt(jSONObject.getString(CameraStatisticsUtil.RUS_FILE_VERSION));
            e.a("LocationHelper", "updateSensorAreaConfigFromJson, sSensorAreaConfig.version: " + f4618b.f4619a + ", jsonVersion: " + parseInt);
            if (f4618b.f4619a < parseInt) {
                JSONArray jSONArray = jSONObject.getJSONArray("areas");
                ArrayList arrayList = new ArrayList();
                int length = jSONArray.length();
                for (int i = 0; i < length; i++) {
                    JSONArray jSONArray2 = jSONArray.getJSONObject(i).getJSONArray("disputingParty");
                    int length2 = jSONArray2.length();
                    for (int i2 = 0; i2 < length2; i2++) {
                        arrayList.add(jSONArray2.getString(i2));
                    }
                }
                int unused = f4618b.f4619a = parseInt;
                List unused2 = f4618b.f4620b = arrayList;
            }
        }
    }

    /* compiled from: LocationHelper */
    private static class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public int f4619a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public List<String> f4620b;

        private a() {
            this.f4619a = -1;
            this.f4620b = new ArrayList();
        }
    }
}
