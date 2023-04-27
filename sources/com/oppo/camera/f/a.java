package com.oppo.camera.f;

import android.content.Context;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraManager;
import com.oppo.camera.aps.config.AlgoSwitchConfig;
import com.oppo.camera.aps.config.CameraConfig;
import com.oppo.camera.aps.config.ConfigDataBase;
import com.oppo.camera.e;
import com.oppo.camera.k;
import com.oppo.camera.util.Util;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/* compiled from: CameraCharacteristicsUtil */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static CameraManager f3181a;

    /* renamed from: b  reason: collision with root package name */
    private static ArrayList<j> f3182b;
    private static String[] c;
    private static ArrayList<String> d;
    private static ArrayList<String> e;
    private static HashMap<Integer, Integer> f;
    private static HashMap<Integer, Integer> g;
    private static C0083a h;
    private static C0083a i;

    /* renamed from: com.oppo.camera.f.a$a  reason: collision with other inner class name */
    /* compiled from: CameraCharacteristicsUtil */
    public static class C0083a {

        /* renamed from: a  reason: collision with root package name */
        public int f3183a = 0;

        /* renamed from: b  reason: collision with root package name */
        public int f3184b = 0;
        public float c = 0.0f;
        public float d = 0.0f;
        public float e = 0.0f;
        public float f = 0.0f;

        public boolean a() {
            return (this.f3183a == 0 && this.f3184b == 0 && Float.compare(this.c, 0.0f) == 0 && Float.compare(this.d, 0.0f) == 0 && Float.compare(this.e, 0.0f) == 0 && Float.compare(this.f, 0.0f) == 0) ? false : true;
        }

        public String toString() {
            return "mFrameWidth: " + this.f3183a + ", mFrameHeight: " + this.f3184b + ", mCameraFx: " + this.c + ", mCameraFy: " + this.d + ", mCameraCx: " + this.e + ", mCameraCy: " + this.f;
        }
    }

    public static synchronized void a(Context context) {
        synchronized (a.class) {
            e.a("CameraCharacteristicsUtil", "initialize");
            f3181a = (CameraManager) context.getSystemService("camera");
            b(context);
            e.a("CameraCharacteristicsUtil", "initialize, X");
        }
    }

    public static void b(Context context) {
        String[] strArr;
        j jVar;
        HashMap<Integer, Integer> hashMap;
        HashMap<Integer, Integer> hashMap2;
        if (c == null) {
            if (f3181a == null) {
                f3181a = (CameraManager) context.getSystemService("camera");
            }
            try {
                c = f3181a.getCameraIdList();
            } catch (CameraAccessException e2) {
                e2.printStackTrace();
            }
        }
        String[] strArr2 = c;
        if (!(strArr2 == null || (hashMap2 = g) == null || strArr2.length == hashMap2.size())) {
            e.a("CameraCharacteristicsUtil", "initCameraInfo, reload camera info");
            f = null;
        }
        if ((f3182b == null || (hashMap = f) == null || hashMap.size() == 0) && (strArr = c) != null && strArr.length > 0) {
            d = new ArrayList<>();
            e = new ArrayList<>();
            f3182b = new ArrayList<>();
            int i2 = 0;
            while (true) {
                String[] strArr3 = c;
                if (i2 >= strArr3.length) {
                    break;
                }
                try {
                    jVar = new j(f3181a.getCameraCharacteristics(strArr3[i2]));
                } catch (CameraAccessException e3) {
                    e3.printStackTrace();
                    jVar = null;
                }
                if (jVar != null) {
                    try {
                        int parseInt = Integer.parseInt(c[i2]);
                        int[] C = jVar.C();
                        int i3 = C != null ? C[0] : -1;
                        e.a("CameraCharacteristicsUtil", "initCameraInfo, cameraType: " + i3 + ", cameraId: " + parseInt);
                        if (f == null) {
                            f = new HashMap<>();
                        }
                        if (g == null) {
                            g = new HashMap<>();
                        }
                        if (i3 > -1) {
                            f.put(Integer.valueOf(i3), Integer.valueOf(parseInt));
                            g.put(Integer.valueOf(parseInt), Integer.valueOf(i3));
                        }
                    } catch (IllegalArgumentException unused) {
                    }
                }
                f3182b.add(jVar);
                if (jVar == null || jVar.c() != 0) {
                    d.add(c[i2]);
                } else {
                    e.add(c[i2]);
                }
                i2++;
            }
        }
        s();
        e.b("CameraCharacteristicsUtil", "initCameraInfo, sAllCameraIds.length: " + c.length);
    }

    private static void s() {
        if (h == null || i == null) {
            byte[] a2 = Util.a(new File("/persist/camera/stereoParams.bin"));
            if (h == null) {
                h = new C0083a();
            }
            h.f3184b = Util.b(a2, 4130, 4133);
            h.f3183a = Util.b(a2, 4134, 4137);
            h.c = Util.b(a2, 4138);
            h.d = Util.b(a2, 4142);
            h.e = Util.b(a2, 4146);
            h.f = Util.b(a2, 4150);
            if (i == null) {
                i = new C0083a();
            }
            i.f3184b = Util.b(a2, 17, 20);
            i.f3183a = Util.b(a2, 21, 24);
            i.c = Util.b(a2, 25);
            i.d = Util.b(a2, 29);
            i.e = Util.b(a2, 33);
            i.f = Util.b(a2, 37);
            e.a("CameraCharacteristicsUtil", "fillBokehParam, sMasterCalibParam: " + h.toString() + ", sDepthCalibParam: " + i.toString());
        }
    }

    public static C0083a a() {
        return h;
    }

    public static C0083a b() {
        return i;
    }

    public static int c() {
        String[] strArr = c;
        if (strArr != null) {
            return strArr.length;
        }
        return 0;
    }

    public static j a(int i2) {
        if (i2 <= c() - 1) {
            return f3182b.get(i2);
        }
        return f3182b.get(0);
    }

    public static int a(int i2, int i3) {
        j a2 = a(i3);
        if (a2.c() == 0) {
            return (360 - ((a2.b() + i2) % 360)) % 360;
        }
        return ((a2.b() - i2) + 360) % 360;
    }

    public static int b(int i2) {
        j a2 = a(i2);
        if (a2 != null) {
            return a2.b();
        }
        return 0;
    }

    public static int b(int i2, int i3) {
        int i4;
        j a2 = a(i2);
        if (i3 == -1) {
            i4 = a2.b();
        } else if (a2.c() == 0) {
            i4 = ((a2.b() - i3) + 360) % 360;
        } else {
            i4 = (a2.b() + i3) % 360;
        }
        e.a("CameraCharacteristicsUtil", "getJpegOrientation, cameraId: " + i2 + ", orientation: " + i3 + ", rotation: " + i4);
        return i4;
    }

    public static boolean c(int i2) {
        if (Util.r(Util.f())) {
            ArrayList<j> arrayList = f3182b;
            if (arrayList == null || arrayList.size() == 0 || a(i2).c() != 0) {
                return false;
            }
            return true;
        } else if (1 == Integer.parseInt(new k(Util.f()).getString("pref_camera_id_key", String.valueOf(0)))) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean d() {
        ArrayList<String> arrayList = d;
        return arrayList != null && arrayList.size() >= 3;
    }

    public static boolean e() {
        ArrayList<String> arrayList = e;
        return arrayList != null && arrayList.size() >= 3;
    }

    public static String[] d(int i2) {
        e.b("CameraCharacteristicsUtil", "getPhysicalCameraIds, logical cameraId: " + i2);
        j a2 = a(i2);
        int[] iArr = (int[]) a2.F().get(CameraCharacteristics.REQUEST_AVAILABLE_CAPABILITIES);
        if (iArr == null) {
            return null;
        }
        for (int i3 : iArr) {
            if (11 == i3) {
                Set<String> physicalCameraIds = a2.F().getPhysicalCameraIds();
                e.b("CameraCharacteristicsUtil", "getPhysicalCameraIds, physicalIds: " + physicalCameraIds);
                return (String[]) physicalCameraIds.toArray(new String[0]);
            }
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0010, code lost:
        r0 = d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean f() {
        /*
            java.util.HashMap<java.lang.Integer, java.lang.Integer> r0 = f
            if (r0 == 0) goto L_0x002a
            r1 = 12
            java.lang.Integer r2 = java.lang.Integer.valueOf(r1)
            boolean r0 = r0.containsKey(r2)
            if (r0 == 0) goto L_0x002a
            java.util.ArrayList<java.lang.String> r0 = d
            if (r0 == 0) goto L_0x002a
            java.util.HashMap<java.lang.Integer, java.lang.Integer> r2 = f
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            java.lang.Object r1 = r2.get(r1)
            java.lang.String r1 = java.lang.String.valueOf(r1)
            boolean r0 = r0.contains(r1)
            if (r0 == 0) goto L_0x002a
            r0 = 1
            return r0
        L_0x002a:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.f.a.f():boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000f, code lost:
        r0 = d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean g() {
        /*
            java.util.HashMap<java.lang.Integer, java.lang.Integer> r0 = f
            if (r0 == 0) goto L_0x0029
            r1 = 2
            java.lang.Integer r2 = java.lang.Integer.valueOf(r1)
            boolean r0 = r0.containsKey(r2)
            if (r0 == 0) goto L_0x0029
            java.util.ArrayList<java.lang.String> r0 = d
            if (r0 == 0) goto L_0x0029
            java.util.HashMap<java.lang.Integer, java.lang.Integer> r2 = f
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            java.lang.Object r1 = r2.get(r1)
            java.lang.String r1 = java.lang.String.valueOf(r1)
            boolean r0 = r0.contains(r1)
            if (r0 == 0) goto L_0x0029
            r0 = 1
            return r0
        L_0x0029:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.f.a.g():boolean");
    }

    public static int h() {
        HashMap<Integer, Integer> hashMap = f;
        if (hashMap != null && hashMap.size() > 0 && f.containsKey(0)) {
            return f.get(0).intValue();
        }
        ArrayList<String> arrayList = d;
        if (arrayList == null || arrayList.size() <= 0) {
            return 0;
        }
        return Integer.parseInt(d.get(0));
    }

    public static int i() {
        HashMap<Integer, Integer> hashMap = f;
        if (hashMap != null && hashMap.size() > 0 && f.containsKey(1)) {
            return f.get(1).intValue();
        }
        ArrayList<String> arrayList = e;
        if (arrayList == null || arrayList.size() <= 0) {
            return 0;
        }
        return Integer.parseInt(e.get(0));
    }

    public static int j() {
        HashMap<Integer, Integer> hashMap = f;
        if (hashMap != null && hashMap.size() > 0 && f.containsKey(2)) {
            return f.get(2).intValue();
        }
        ArrayList<String> arrayList = d;
        if (arrayList == null || arrayList.size() <= 2) {
            return 0;
        }
        ArrayList<String> arrayList2 = d;
        return Integer.parseInt(arrayList2.get(arrayList2.size() - 2));
    }

    public static int k() {
        HashMap<Integer, Integer> hashMap = f;
        if (hashMap != null && hashMap.size() > 0 && f.containsKey(3)) {
            return f.get(3).intValue();
        }
        ArrayList<String> arrayList = e;
        if (arrayList == null || arrayList.size() <= 2) {
            return 0;
        }
        ArrayList<String> arrayList2 = e;
        return Integer.parseInt(arrayList2.get(arrayList2.size() - 2));
    }

    public static int l() {
        HashMap<Integer, Integer> hashMap = f;
        if (hashMap != null && hashMap.size() > 0 && f.containsKey(8)) {
            return f.get(8).intValue();
        }
        ArrayList<String> arrayList = d;
        if (arrayList == null || arrayList.size() <= 1) {
            return 0;
        }
        ArrayList<String> arrayList2 = d;
        return Integer.parseInt(arrayList2.get(arrayList2.size() - 1));
    }

    public static int m() {
        HashMap<Integer, Integer> hashMap = f;
        if (hashMap == null || hashMap.size() <= 0 || !f.containsKey(11)) {
            return 0;
        }
        return f.get(11).intValue();
    }

    public static int n() {
        HashMap<Integer, Integer> hashMap = f;
        if (hashMap != null && hashMap.size() > 0 && f.containsKey(10)) {
            return f.get(10).intValue();
        }
        ArrayList<String> arrayList = e;
        if (arrayList == null || arrayList.size() <= 1) {
            return 0;
        }
        ArrayList<String> arrayList2 = e;
        return Integer.parseInt(arrayList2.get(arrayList2.size() - 1));
    }

    public static int o() {
        HashMap<Integer, Integer> hashMap = f;
        if (hashMap == null || hashMap.size() <= 0 || !f.containsKey(6)) {
            return 0;
        }
        return f.get(6).intValue();
    }

    public static int p() {
        HashMap<Integer, Integer> hashMap = f;
        if (hashMap == null || hashMap.size() <= 0 || !f.containsKey(12)) {
            return 0;
        }
        return f.get(12).intValue();
    }

    public static int q() {
        HashMap<Integer, Integer> hashMap = f;
        if (hashMap == null || hashMap.size() <= 0 || !f.containsKey(19)) {
            return 0;
        }
        return f.get(19).intValue();
    }

    public static int r() {
        HashMap<Integer, Integer> hashMap = f;
        if (hashMap == null || hashMap.size() <= 0 || !f.containsKey(17)) {
            return 0;
        }
        return f.get(17).intValue();
    }

    public static int e(int i2) {
        HashMap<Integer, Integer> hashMap = f;
        if (hashMap == null || hashMap.size() <= 0 || !f.containsKey(Integer.valueOf(i2))) {
            return 0;
        }
        return f.get(Integer.valueOf(i2)).intValue();
    }

    public static int f(int i2) {
        HashMap<Integer, Integer> hashMap = g;
        if (hashMap == null || hashMap.size() <= 0 || !g.containsKey(Integer.valueOf(i2))) {
            return -1;
        }
        return g.get(Integer.valueOf(i2)).intValue();
    }

    public static boolean g(int i2) {
        return 3 == AlgoSwitchConfig.getApsVersion() && !CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SAT_USE_HAL) && f() && i2 == p();
    }
}
