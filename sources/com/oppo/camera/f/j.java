package com.oppo.camera.f;

import android.graphics.Rect;
import android.hardware.camera2.CameraCharacteristics;
import android.util.Range;
import android.util.Rational;
import android.util.Size;
import com.oppo.camera.ab;
import com.oppo.camera.aps.config.CameraConfig;
import com.oppo.camera.aps.config.ConfigDataBase;
import com.oppo.camera.e;
import com.oppo.camera.util.Util;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: OppoCameraCharacteristics */
public class j {

    /* renamed from: a  reason: collision with root package name */
    private final CameraCharacteristics f3241a;

    /* renamed from: b  reason: collision with root package name */
    private Map<Integer, List<Size>> f3242b = null;
    private Map<String, List<Size>> c = null;
    private List<Size> d = null;

    public j(CameraCharacteristics cameraCharacteristics) {
        this.f3241a = cameraCharacteristics;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0028, code lost:
        r0 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
        r1 = (android.hardware.camera2.params.StreamConfigurationMap) r7.f3241a.get(android.hardware.camera2.CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0033, code lost:
        r2 = new java.util.ArrayList();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0038, code lost:
        if (r1 == null) goto L_0x0061;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x003e, code lost:
        if (r1.getOutputSizes(r8) == null) goto L_0x0061;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0040, code lost:
        r3 = r1.getOutputSizes(r8);
        r4 = r3.length;
        r5 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0046, code lost:
        if (r5 >= r4) goto L_0x0050;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0048, code lost:
        r2.add(r3[r5]);
        r5 = r5 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0050, code lost:
        r1 = r1.getHighResolutionOutputSizes(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0054, code lost:
        if (r1 == null) goto L_0x0061;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0056, code lost:
        r3 = r1.length;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0057, code lost:
        if (r0 >= r3) goto L_0x0061;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0059, code lost:
        r2.add(r1[r0]);
        r0 = r0 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0063, code lost:
        if (32 == r8) goto L_0x0085;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0065, code lost:
        r0 = D();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0069, code lost:
        if (r0 == null) goto L_0x0085;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x006b, code lost:
        r0 = r0.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0073, code lost:
        if (r0.hasNext() == false) goto L_0x0085;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0075, code lost:
        r1 = r0.next();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x007f, code lost:
        if (com.oppo.camera.util.Util.a((java.util.List<android.util.Size>) r2, r1) != false) goto L_0x006f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0081, code lost:
        r2.add(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0085, code lost:
        monitor-enter(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:?, code lost:
        r7.f3242b.put(java.lang.Integer.valueOf(r8), r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x008f, code lost:
        monitor-exit(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0090, code lost:
        return r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0094, code lost:
        com.oppo.camera.e.e("OppoCameraCharacteristics", "Unable to obtain picture sizes");
        r1 = new java.util.ArrayList(0);
        r7.f3242b.put(java.lang.Integer.valueOf(r8), r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00a9, code lost:
        return r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<android.util.Size> a(int r8) {
        /*
            r7 = this;
            monitor-enter(r7)
            java.util.Map<java.lang.Integer, java.util.List<android.util.Size>> r0 = r7.f3242b     // Catch:{ all -> 0x00aa }
            if (r0 != 0) goto L_0x000d
            java.util.HashMap r0 = new java.util.HashMap     // Catch:{ all -> 0x00aa }
            r0.<init>()     // Catch:{ all -> 0x00aa }
            r7.f3242b = r0     // Catch:{ all -> 0x00aa }
            goto L_0x0027
        L_0x000d:
            java.util.Map<java.lang.Integer, java.util.List<android.util.Size>> r0 = r7.f3242b     // Catch:{ all -> 0x00aa }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r8)     // Catch:{ all -> 0x00aa }
            boolean r0 = r0.containsKey(r1)     // Catch:{ all -> 0x00aa }
            if (r0 == 0) goto L_0x0027
            java.util.Map<java.lang.Integer, java.util.List<android.util.Size>> r0 = r7.f3242b     // Catch:{ all -> 0x00aa }
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ all -> 0x00aa }
            java.lang.Object r8 = r0.get(r8)     // Catch:{ all -> 0x00aa }
            java.util.List r8 = (java.util.List) r8     // Catch:{ all -> 0x00aa }
            monitor-exit(r7)     // Catch:{ all -> 0x00aa }
            return r8
        L_0x0027:
            monitor-exit(r7)     // Catch:{ all -> 0x00aa }
            r0 = 0
            android.hardware.camera2.CameraCharacteristics r1 = r7.f3241a     // Catch:{ Exception -> 0x0094 }
            android.hardware.camera2.CameraCharacteristics$Key r2 = android.hardware.camera2.CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP     // Catch:{ Exception -> 0x0094 }
            java.lang.Object r1 = r1.get(r2)     // Catch:{ Exception -> 0x0094 }
            android.hardware.camera2.params.StreamConfigurationMap r1 = (android.hardware.camera2.params.StreamConfigurationMap) r1     // Catch:{ Exception -> 0x0094 }
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            if (r1 == 0) goto L_0x0061
            android.util.Size[] r3 = r1.getOutputSizes(r8)
            if (r3 == 0) goto L_0x0061
            android.util.Size[] r3 = r1.getOutputSizes(r8)
            int r4 = r3.length
            r5 = r0
        L_0x0046:
            if (r5 >= r4) goto L_0x0050
            r6 = r3[r5]
            r2.add(r6)
            int r5 = r5 + 1
            goto L_0x0046
        L_0x0050:
            android.util.Size[] r1 = r1.getHighResolutionOutputSizes(r8)
            if (r1 == 0) goto L_0x0061
            int r3 = r1.length
        L_0x0057:
            if (r0 >= r3) goto L_0x0061
            r4 = r1[r0]
            r2.add(r4)
            int r0 = r0 + 1
            goto L_0x0057
        L_0x0061:
            r0 = 32
            if (r0 == r8) goto L_0x0085
            java.util.List r0 = r7.D()
            if (r0 == 0) goto L_0x0085
            java.util.Iterator r0 = r0.iterator()
        L_0x006f:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0085
            java.lang.Object r1 = r0.next()
            android.util.Size r1 = (android.util.Size) r1
            boolean r3 = com.oppo.camera.util.Util.a((java.util.List<android.util.Size>) r2, (android.util.Size) r1)
            if (r3 != 0) goto L_0x006f
            r2.add(r1)
            goto L_0x006f
        L_0x0085:
            monitor-enter(r7)
            java.util.Map<java.lang.Integer, java.util.List<android.util.Size>> r0 = r7.f3242b     // Catch:{ all -> 0x0091 }
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ all -> 0x0091 }
            r0.put(r8, r2)     // Catch:{ all -> 0x0091 }
            monitor-exit(r7)     // Catch:{ all -> 0x0091 }
            return r2
        L_0x0091:
            r8 = move-exception
            monitor-exit(r7)     // Catch:{ all -> 0x0091 }
            throw r8
        L_0x0094:
            java.lang.String r1 = "OppoCameraCharacteristics"
            java.lang.String r2 = "Unable to obtain picture sizes"
            com.oppo.camera.e.e(r1, r2)
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>(r0)
            java.util.Map<java.lang.Integer, java.util.List<android.util.Size>> r0 = r7.f3242b
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            r0.put(r8, r1)
            return r1
        L_0x00aa:
            r8 = move-exception
            monitor-exit(r7)     // Catch:{ all -> 0x00aa }
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.f.j.a(int):java.util.List");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v8, resolved type: android.hardware.camera2.params.StreamConfigurationMap} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<android.util.Size> a(int r7, android.hardware.camera2.CameraCharacteristics r8, java.lang.String r9) {
        /*
            r6 = this;
            monitor-enter(r6)
            java.util.Map<java.lang.String, java.util.List<android.util.Size>> r0 = r6.c     // Catch:{ all -> 0x0095 }
            if (r0 != 0) goto L_0x000d
            java.util.HashMap r0 = new java.util.HashMap     // Catch:{ all -> 0x0095 }
            r0.<init>()     // Catch:{ all -> 0x0095 }
            r6.c = r0     // Catch:{ all -> 0x0095 }
            goto L_0x001f
        L_0x000d:
            java.util.Map<java.lang.String, java.util.List<android.util.Size>> r0 = r6.c     // Catch:{ all -> 0x0095 }
            boolean r0 = r0.containsKey(r9)     // Catch:{ all -> 0x0095 }
            if (r0 == 0) goto L_0x001f
            java.util.Map<java.lang.String, java.util.List<android.util.Size>> r7 = r6.c     // Catch:{ all -> 0x0095 }
            java.lang.Object r7 = r7.get(r9)     // Catch:{ all -> 0x0095 }
            java.util.List r7 = (java.util.List) r7     // Catch:{ all -> 0x0095 }
            monitor-exit(r6)     // Catch:{ all -> 0x0095 }
            return r7
        L_0x001f:
            r0 = 0
            r1 = 0
            if (r8 == 0) goto L_0x0040
            android.hardware.camera2.CameraCharacteristics$Key r0 = android.hardware.camera2.CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP     // Catch:{ Exception -> 0x002d }
            java.lang.Object r8 = r8.get(r0)     // Catch:{ Exception -> 0x002d }
            r0 = r8
            android.hardware.camera2.params.StreamConfigurationMap r0 = (android.hardware.camera2.params.StreamConfigurationMap) r0     // Catch:{ Exception -> 0x002d }
            goto L_0x0040
        L_0x002d:
            java.lang.String r7 = "OppoCameraCharacteristics"
            java.lang.String r8 = "getSupportedPhysicalPictureSizes, Unable to obtain picture sizes"
            com.oppo.camera.e.e(r7, r8)     // Catch:{ all -> 0x0095 }
            java.util.ArrayList r7 = new java.util.ArrayList     // Catch:{ all -> 0x0095 }
            r7.<init>(r1)     // Catch:{ all -> 0x0095 }
            java.util.Map<java.lang.String, java.util.List<android.util.Size>> r8 = r6.c     // Catch:{ all -> 0x0095 }
            r8.put(r9, r7)     // Catch:{ all -> 0x0095 }
            monitor-exit(r6)     // Catch:{ all -> 0x0095 }
            return r7
        L_0x0040:
            java.util.ArrayList r8 = new java.util.ArrayList     // Catch:{ all -> 0x0095 }
            r8.<init>()     // Catch:{ all -> 0x0095 }
            if (r0 == 0) goto L_0x006e
            android.util.Size[] r2 = r0.getOutputSizes(r7)     // Catch:{ all -> 0x0095 }
            if (r2 == 0) goto L_0x006e
            android.util.Size[] r2 = r0.getOutputSizes(r7)     // Catch:{ all -> 0x0095 }
            int r3 = r2.length     // Catch:{ all -> 0x0095 }
            r4 = r1
        L_0x0053:
            if (r4 >= r3) goto L_0x005d
            r5 = r2[r4]     // Catch:{ all -> 0x0095 }
            r8.add(r5)     // Catch:{ all -> 0x0095 }
            int r4 = r4 + 1
            goto L_0x0053
        L_0x005d:
            android.util.Size[] r7 = r0.getHighResolutionOutputSizes(r7)     // Catch:{ all -> 0x0095 }
            if (r7 == 0) goto L_0x006e
            int r0 = r7.length     // Catch:{ all -> 0x0095 }
        L_0x0064:
            if (r1 >= r0) goto L_0x006e
            r2 = r7[r1]     // Catch:{ all -> 0x0095 }
            r8.add(r2)     // Catch:{ all -> 0x0095 }
            int r1 = r1 + 1
            goto L_0x0064
        L_0x006e:
            java.util.List r7 = r6.D()     // Catch:{ all -> 0x0095 }
            if (r7 == 0) goto L_0x008e
            java.util.Iterator r7 = r7.iterator()     // Catch:{ all -> 0x0095 }
        L_0x0078:
            boolean r0 = r7.hasNext()     // Catch:{ all -> 0x0095 }
            if (r0 == 0) goto L_0x008e
            java.lang.Object r0 = r7.next()     // Catch:{ all -> 0x0095 }
            android.util.Size r0 = (android.util.Size) r0     // Catch:{ all -> 0x0095 }
            boolean r1 = com.oppo.camera.util.Util.a((java.util.List<android.util.Size>) r8, (android.util.Size) r0)     // Catch:{ all -> 0x0095 }
            if (r1 != 0) goto L_0x0078
            r8.add(r0)     // Catch:{ all -> 0x0095 }
            goto L_0x0078
        L_0x008e:
            java.util.Map<java.lang.String, java.util.List<android.util.Size>> r7 = r6.c     // Catch:{ all -> 0x0095 }
            r7.put(r9, r8)     // Catch:{ all -> 0x0095 }
            monitor-exit(r6)     // Catch:{ all -> 0x0095 }
            return r8
        L_0x0095:
            r7 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x0095 }
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.f.j.a(int, android.hardware.camera2.CameraCharacteristics, java.lang.String):java.util.List");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
        r1 = (android.hardware.camera2.params.StreamConfigurationMap) r5.f3241a.get(android.hardware.camera2.CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0015, code lost:
        r2 = new java.util.ArrayList();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001a, code lost:
        if (r1 == null) goto L_0x002f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001c, code lost:
        r1 = r1.getOutputSizes(android.graphics.SurfaceTexture.class);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0022, code lost:
        if (r1 == null) goto L_0x002f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0024, code lost:
        r3 = r1.length;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0025, code lost:
        if (r0 >= r3) goto L_0x002f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0027, code lost:
        r2.add(r1[r0]);
        r0 = r0 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x002f, code lost:
        monitor-enter(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        r5.d = r2;
        r0 = r5.d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0034, code lost:
        monitor-exit(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0035, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0039, code lost:
        com.oppo.camera.e.e("OppoCameraCharacteristics", "Unable to obtain preview sizes");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0045, code lost:
        return new java.util.ArrayList(0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x000a, code lost:
        r0 = 0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<android.util.Size> a() {
        /*
            r5 = this;
            monitor-enter(r5)
            java.util.List<android.util.Size> r0 = r5.d     // Catch:{ all -> 0x0046 }
            if (r0 == 0) goto L_0x0009
            java.util.List<android.util.Size> r0 = r5.d     // Catch:{ all -> 0x0046 }
            monitor-exit(r5)     // Catch:{ all -> 0x0046 }
            return r0
        L_0x0009:
            monitor-exit(r5)     // Catch:{ all -> 0x0046 }
            r0 = 0
            android.hardware.camera2.CameraCharacteristics r1 = r5.f3241a     // Catch:{ Exception -> 0x0039 }
            android.hardware.camera2.CameraCharacteristics$Key r2 = android.hardware.camera2.CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP     // Catch:{ Exception -> 0x0039 }
            java.lang.Object r1 = r1.get(r2)     // Catch:{ Exception -> 0x0039 }
            android.hardware.camera2.params.StreamConfigurationMap r1 = (android.hardware.camera2.params.StreamConfigurationMap) r1     // Catch:{ Exception -> 0x0039 }
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            if (r1 == 0) goto L_0x002f
            java.lang.Class<android.graphics.SurfaceTexture> r3 = android.graphics.SurfaceTexture.class
            android.util.Size[] r1 = r1.getOutputSizes(r3)
            if (r1 == 0) goto L_0x002f
            int r3 = r1.length
        L_0x0025:
            if (r0 >= r3) goto L_0x002f
            r4 = r1[r0]
            r2.add(r4)
            int r0 = r0 + 1
            goto L_0x0025
        L_0x002f:
            monitor-enter(r5)
            r5.d = r2     // Catch:{ all -> 0x0036 }
            java.util.List<android.util.Size> r0 = r5.d     // Catch:{ all -> 0x0036 }
            monitor-exit(r5)     // Catch:{ all -> 0x0036 }
            return r0
        L_0x0036:
            r0 = move-exception
            monitor-exit(r5)     // Catch:{ all -> 0x0036 }
            throw r0
        L_0x0039:
            java.lang.String r1 = "OppoCameraCharacteristics"
            java.lang.String r2 = "Unable to obtain preview sizes"
            com.oppo.camera.e.e(r1, r2)
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>(r0)
            return r1
        L_0x0046:
            r0 = move-exception
            monitor-exit(r5)     // Catch:{ all -> 0x0046 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.f.j.a():java.util.List");
    }

    public int b() {
        return ((Integer) this.f3241a.get(CameraCharacteristics.SENSOR_ORIENTATION)).intValue();
    }

    public int c() {
        return ((Integer) this.f3241a.get(CameraCharacteristics.LENS_FACING)).intValue();
    }

    public Rect d() {
        return (Rect) this.f3241a.get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE);
    }

    public float e() {
        return ((Float) this.f3241a.get(CameraCharacteristics.SCALER_AVAILABLE_MAX_DIGITAL_ZOOM)).floatValue();
    }

    public int f() {
        return ((Integer) this.f3241a.get(c.aL)).intValue();
    }

    public float[] g() {
        try {
            if (this.f3241a != null) {
                return (float[]) this.f3241a.get(c.av);
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public <T> T a(CameraCharacteristics.Key<T> key) {
        try {
            if (this.f3241a != null) {
                return this.f3241a.get(key);
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public float[] h() {
        try {
            if (this.f3241a != null) {
                return (float[]) this.f3241a.get(c.aw);
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public float[] a(ab abVar) {
        float[] fArr;
        try {
            if (this.f3241a != null) {
                if (abVar.b()) {
                    if (!abVar.a()) {
                        fArr = abVar.f2754a ? (float[]) a(c.az) : null;
                        if (fArr == null) {
                            fArr = (float[]) a(c.ay);
                        }
                    } else {
                        fArr = null;
                    }
                    return fArr == null ? g() : fArr;
                } else if (abVar.f()) {
                    return h();
                }
            }
        } catch (Exception e) {
            e.e("OppoCameraCharacteristics", "getSupportedZoomRange, e: " + e.getMessage());
        }
        return null;
    }

    public float[] i() {
        try {
            if (this.f3241a != null) {
                return (float[]) this.f3241a.get(c.aw);
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public float[] j() {
        try {
            if (this.f3241a != null) {
                return (float[]) this.f3241a.get(c.aM);
            }
        } catch (Exception e) {
            e.e("OppoCameraCharacteristics", "getFovAngle error: " + e.toString());
        }
        e.a("OppoCameraCharacteristics", "getFovAngle enter, return null");
        return null;
    }

    public byte[] k() {
        try {
            if (this.f3241a != null) {
                return (byte[]) this.f3241a.get(c.aJ);
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public float[] l() {
        try {
            if (this.f3241a != null) {
                return (float[]) this.f3241a.get(c.ax);
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Rect a(Size size) {
        Rect d2 = d();
        float width = ((float) d2.width()) / ((float) d2.height());
        float width2 = ((float) size.getWidth()) / ((float) size.getHeight());
        if (width2 - width > -0.015f) {
            int height = (d2.height() - ((int) (((float) d2.width()) / width2))) / 2;
            return new Rect(d2.left, d2.top + height, d2.right, d2.bottom - height);
        }
        int width3 = (d2.width() - ((int) (((float) d2.height()) * width2))) / 2;
        return new Rect(d2.left + width3, d2.top, d2.right - width3, d2.bottom);
    }

    public float b(ab abVar) {
        if (abVar.g() || abVar.h()) {
            return CameraConfig.getConfigFloatValue(ConfigDataBase.KEY_PORTRAIT_ZOOM_VALUE_DEFAULT);
        }
        if (abVar.v()) {
            return c(abVar);
        }
        float[] fArr = null;
        if (abVar.b()) {
            fArr = a(abVar);
        } else if (abVar.f()) {
            fArr = i();
        } else if (abVar.c()) {
            fArr = l();
        }
        if (fArr != null) {
            return fArr[2];
        }
        return 1.0f;
    }

    public float c(ab abVar) {
        if (!abVar.r() && !abVar.s()) {
            float[] a2 = a(abVar);
            if (a2 != null) {
                return a2[0];
            }
            if (!abVar.i() && !abVar.b()) {
                return 1.0f;
            }
            return 0.6f;
        }
        return 1.0f;
    }

    public float d(ab abVar) {
        float[] a2 = a(abVar);
        if (abVar.m()) {
            return 1.0f;
        }
        if (abVar.s()) {
            return 5.0f;
        }
        if (a2 != null && a2.length >= 4) {
            return a2[1];
        }
        if (abVar.g() || abVar.h()) {
            return 2.0f;
        }
        if (abVar.c()) {
            return a.a(0).e();
        }
        if (abVar.i() || abVar.o()) {
            return 1.0f;
        }
        if (abVar.n()) {
            return 5.0f;
        }
        if (abVar.p()) {
            return 20.0f;
        }
        if (abVar.r()) {
            return 5.0f;
        }
        if (abVar.t()) {
            return 3.0f;
        }
        if (abVar.u()) {
            return 2.0f;
        }
        if (!abVar.e() || abVar.f2754a || abVar.f2755b) {
            return e();
        }
        return 20.0f;
    }

    public boolean a(ab abVar, float f) {
        return Float.compare(f, c(abVar)) >= 0 && Float.compare(f, d(abVar)) <= 0;
    }

    public float m() {
        CameraCharacteristics cameraCharacteristics = this.f3241a;
        if (cameraCharacteristics == null) {
            return 0.0f;
        }
        try {
            return ((Float) cameraCharacteristics.get(CameraCharacteristics.LENS_INFO_HYPERFOCAL_DISTANCE)).floatValue();
        } catch (Exception e) {
            e.printStackTrace();
            return 0.0f;
        }
    }

    public float n() {
        CameraCharacteristics cameraCharacteristics = this.f3241a;
        if (cameraCharacteristics == null) {
            return 0.0f;
        }
        try {
            return ((Float) cameraCharacteristics.get(CameraCharacteristics.LENS_INFO_MINIMUM_FOCUS_DISTANCE)).floatValue();
        } catch (Exception e) {
            e.printStackTrace();
            return 0.0f;
        }
    }

    public boolean o() {
        Range range = (Range) this.f3241a.get(CameraCharacteristics.CONTROL_AE_COMPENSATION_RANGE);
        return (((Integer) range.getLower()).intValue() == 0 && ((Integer) range.getUpper()).intValue() == 0) ? false : true;
    }

    public int p() {
        if (!o()) {
            return -1;
        }
        return ((Integer) ((Range) this.f3241a.get(CameraCharacteristics.CONTROL_AE_COMPENSATION_RANGE)).getLower()).intValue();
    }

    public int q() {
        if (!o()) {
            return -1;
        }
        return ((Integer) ((Range) this.f3241a.get(CameraCharacteristics.CONTROL_AE_COMPENSATION_RANGE)).getUpper()).intValue();
    }

    public float r() {
        if (!o()) {
            return -1.0f;
        }
        Rational rational = (Rational) this.f3241a.get(CameraCharacteristics.CONTROL_AE_COMPENSATION_STEP);
        return ((float) rational.getNumerator()) / ((float) rational.getDenominator());
    }

    public boolean s() {
        Integer num = (Integer) this.f3241a.get(CameraCharacteristics.CONTROL_MAX_REGIONS_AF);
        return num != null && num.intValue() > 0;
    }

    public boolean t() {
        Integer num = (Integer) this.f3241a.get(CameraCharacteristics.CONTROL_MAX_REGIONS_AE);
        return num != null && num.intValue() > 0;
    }

    public int u() {
        Range range;
        CameraCharacteristics cameraCharacteristics = this.f3241a;
        if (cameraCharacteristics == null || (range = (Range) cameraCharacteristics.get(CameraCharacteristics.SENSOR_INFO_SENSITIVITY_RANGE)) == null) {
            return -1;
        }
        return ((Integer) range.getUpper()).intValue();
    }

    public int v() {
        Range range;
        CameraCharacteristics cameraCharacteristics = this.f3241a;
        if (cameraCharacteristics == null || (range = (Range) cameraCharacteristics.get(CameraCharacteristics.CONTROL_POST_RAW_SENSITIVITY_BOOST_RANGE)) == null) {
            return -1;
        }
        return ((Integer) range.getUpper()).intValue() + 1;
    }

    public int w() {
        Range range;
        CameraCharacteristics cameraCharacteristics = this.f3241a;
        if (cameraCharacteristics == null || (range = (Range) cameraCharacteristics.get(CameraCharacteristics.SENSOR_INFO_SENSITIVITY_RANGE)) == null) {
            return -1;
        }
        return ((Integer) range.getLower()).intValue();
    }

    public long x() {
        Range range;
        CameraCharacteristics cameraCharacteristics = this.f3241a;
        if (cameraCharacteristics == null || (range = (Range) cameraCharacteristics.get(CameraCharacteristics.SENSOR_INFO_EXPOSURE_TIME_RANGE)) == null) {
            return -1;
        }
        return ((Long) range.getUpper()).longValue();
    }

    public long y() {
        Range range;
        CameraCharacteristics cameraCharacteristics = this.f3241a;
        if (cameraCharacteristics == null || (range = (Range) cameraCharacteristics.get(CameraCharacteristics.SENSOR_INFO_EXPOSURE_TIME_RANGE)) == null) {
            return -1;
        }
        return ((Long) range.getLower()).longValue();
    }

    public Range<Integer>[] z() {
        return (Range[]) this.f3241a.get(CameraCharacteristics.CONTROL_AE_AVAILABLE_TARGET_FPS_RANGES);
    }

    public int[] A() {
        return (int[]) this.f3241a.get(CameraCharacteristics.CONTROL_AF_AVAILABLE_MODES);
    }

    public int[] B() {
        if (Util.p()) {
            return b((CameraCharacteristics.Key<?>) c.o);
        }
        return b((CameraCharacteristics.Key<?>) c.p);
    }

    public int[] C() {
        return b((CameraCharacteristics.Key<?>) c.q);
    }

    public List<Size> D() {
        int i;
        ArrayList arrayList = new ArrayList();
        try {
            int[] iArr = (int[]) this.f3241a.get(c.n);
            for (int i2 = 0; i2 < iArr.length; i2++) {
                if (i2 % 2 == 0 && (i = i2 + 1) < iArr.length) {
                    arrayList.add(new Size(iArr[i2], iArr[i]));
                }
            }
        } catch (Exception unused) {
        }
        return arrayList;
    }

    public int[] b(CameraCharacteristics.Key<?> key) {
        if (key == null) {
            return null;
        }
        try {
            return (int[]) this.f3241a.get(key);
        } catch (Exception e) {
            e.b("OppoCameraCharacteristics", "getIntArrayConfig, e: " + e.getMessage());
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x002a  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0036 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0033 A[EDGE_INSN: B:26:0x0033->B:20:0x0033 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:29:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean E() {
        /*
            r7 = this;
            android.hardware.camera2.CameraCharacteristics$Key<int[]> r0 = com.oppo.camera.f.c.r
            int[] r0 = r7.b((android.hardware.camera2.CameraCharacteristics.Key<?>) r0)
            android.hardware.camera2.CameraCharacteristics$Key<int[]> r1 = com.oppo.camera.f.c.s
            int[] r1 = r7.b((android.hardware.camera2.CameraCharacteristics.Key<?>) r1)
            r2 = 0
            r3 = 1
            if (r0 == 0) goto L_0x0020
            int r4 = r0.length
            if (r4 <= 0) goto L_0x0020
            int r4 = r0.length
            r5 = r2
        L_0x0015:
            if (r5 >= r4) goto L_0x0020
            r6 = r0[r5]
            if (r6 != r3) goto L_0x001d
            r0 = r3
            goto L_0x0021
        L_0x001d:
            int r5 = r5 + 1
            goto L_0x0015
        L_0x0020:
            r0 = r2
        L_0x0021:
            if (r1 == 0) goto L_0x0033
            int r4 = r1.length
            if (r4 <= 0) goto L_0x0033
            int r4 = r1.length
            r5 = r2
        L_0x0028:
            if (r5 >= r4) goto L_0x0033
            r6 = r1[r5]
            if (r6 != r3) goto L_0x0030
            r1 = r3
            goto L_0x0034
        L_0x0030:
            int r5 = r5 + 1
            goto L_0x0028
        L_0x0033:
            r1 = r2
        L_0x0034:
            if (r0 == 0) goto L_0x0039
            if (r1 == 0) goto L_0x0039
            r2 = r3
        L_0x0039:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.f.j.E():boolean");
    }

    public CameraCharacteristics F() {
        return this.f3241a;
    }

    public boolean G() {
        return !Util.p();
    }

    public boolean H() {
        int[] b2 = b((CameraCharacteristics.Key<?>) c.an);
        if (b2 == null || b2.length <= 0) {
            return false;
        }
        for (int i : b2) {
            if (i == 3) {
                return true;
            }
        }
        return false;
    }

    public boolean I() {
        int[] b2 = b((CameraCharacteristics.Key<?>) c.ao);
        if (b2 == null || b2.length <= 0) {
            return false;
        }
        for (int i : b2) {
            if (i == 1) {
                e.b("OppoCameraCharacteristics", "isSupport3Hdr, support3HDR: " + i);
                return true;
            }
        }
        return false;
    }

    public int J() {
        int[] iArr;
        if (Util.p()) {
            iArr = b((CameraCharacteristics.Key<?>) c.aB);
        } else {
            iArr = b((CameraCharacteristics.Key<?>) c.aC);
        }
        if (iArr != null && iArr.length > 0) {
            return iArr[0];
        }
        e.e("OppoCameraCharacteristics", "getLogicalCameraType, cameraTypeArray is null or the length is 0");
        return 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0042  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0056 A[ADDED_TO_REGION] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String[] K() {
        /*
            r9 = this;
            java.lang.String r0 = "OppoCameraCharacteristics"
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r2 = 0
            android.hardware.camera2.CameraCharacteristics r3 = r9.f3241a     // Catch:{ IllegalArgumentException -> 0x002c }
            android.hardware.camera2.CameraCharacteristics$Key<int[]> r4 = com.oppo.camera.f.c.aO     // Catch:{ IllegalArgumentException -> 0x002c }
            java.lang.Object r3 = r3.get(r4)     // Catch:{ IllegalArgumentException -> 0x002c }
            int[] r3 = (int[]) r3     // Catch:{ IllegalArgumentException -> 0x002c }
            android.hardware.camera2.CameraCharacteristics r4 = r9.f3241a     // Catch:{ IllegalArgumentException -> 0x0029 }
            android.hardware.camera2.CameraCharacteristics$Key<byte[]> r5 = com.oppo.camera.f.c.aP     // Catch:{ IllegalArgumentException -> 0x0029 }
            java.lang.Object r4 = r4.get(r5)     // Catch:{ IllegalArgumentException -> 0x0029 }
            byte[] r4 = (byte[]) r4     // Catch:{ IllegalArgumentException -> 0x0029 }
            android.hardware.camera2.CameraCharacteristics r5 = r9.f3241a     // Catch:{ IllegalArgumentException -> 0x0027 }
            android.hardware.camera2.CameraCharacteristics$Key<int[]> r6 = com.oppo.camera.f.c.aN     // Catch:{ IllegalArgumentException -> 0x0027 }
            java.lang.Object r5 = r5.get(r6)     // Catch:{ IllegalArgumentException -> 0x0027 }
            int[] r5 = (int[]) r5     // Catch:{ IllegalArgumentException -> 0x0027 }
            goto L_0x0035
        L_0x0027:
            r5 = move-exception
            goto L_0x002f
        L_0x0029:
            r5 = move-exception
            r4 = r2
            goto L_0x002f
        L_0x002c:
            r5 = move-exception
            r3 = r2
            r4 = r3
        L_0x002f:
            java.lang.String r6 = "getVendorTagAndId"
            com.oppo.camera.e.d(r0, r6, r5)
            r5 = r2
        L_0x0035:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "getVendorTagAndId, count: "
            r6.append(r7)
            r7 = 0
            if (r5 == 0) goto L_0x0049
            r5 = r5[r7]
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            goto L_0x004a
        L_0x0049:
            r5 = r2
        L_0x004a:
            r6.append(r5)
            java.lang.String r5 = r6.toString()
            com.oppo.camera.e.b(r0, r5)
            if (r3 == 0) goto L_0x00bf
            if (r4 != 0) goto L_0x0059
            goto L_0x00bf
        L_0x0059:
            java.lang.String r2 = new java.lang.String
            java.nio.charset.Charset r5 = java.nio.charset.StandardCharsets.UTF_8
            r2.<init>(r4, r5)
            java.lang.String r4 = ";"
            java.lang.String[] r2 = r2.split(r4)
            r4 = r7
        L_0x0067:
            int r5 = r2.length
            if (r4 >= r5) goto L_0x0083
            r5 = r2[r4]
            java.lang.String r6 = ""
            java.lang.String r8 = "\u0000"
            java.lang.String r5 = r5.replace(r8, r6)
            r2[r4] = r5
            r5 = r2[r4]
            java.lang.String r8 = " "
            java.lang.String r5 = r5.replace(r8, r6)
            r2[r4] = r5
            int r4 = r4 + 1
            goto L_0x0067
        L_0x0083:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "getVendorTagAndId, names array length: "
            r4.append(r5)
            int r5 = r2.length
            r4.append(r5)
            java.lang.String r5 = ", ids array length: "
            r4.append(r5)
            int r5 = r3.length
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            com.oppo.camera.e.b(r0, r4)
            r0 = r7
        L_0x00a2:
            int r4 = r3.length
            if (r0 >= r4) goto L_0x00b6
            r4 = r2[r0]
            r1.add(r4)
            r4 = r3[r0]
            java.lang.String r4 = java.lang.Integer.toString(r4)
            r1.add(r4)
            int r0 = r0 + 1
            goto L_0x00a2
        L_0x00b6:
            java.lang.String[] r0 = new java.lang.String[r7]
            java.lang.Object[] r0 = r1.toArray(r0)
            java.lang.String[] r0 = (java.lang.String[]) r0
            return r0
        L_0x00bf:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.f.j.K():java.lang.String[]");
    }

    public boolean L() {
        return b((CameraCharacteristics.Key<?>) c.aK) != null;
    }

    public int[] a(String str) {
        int[] iArr = new int[2];
        int[] b2 = b((CameraCharacteristics.Key<?>) c.aK);
        int i = str.equals("video_size_720p") ? 720 : 1080;
        if (b2 == null || b2.length <= 0) {
            return null;
        }
        int i2 = 0;
        while (true) {
            if (i2 >= b2.length) {
                break;
            } else if (b2[i2] == i) {
                iArr[0] = b2[i2 + 1];
                iArr[1] = b2[i2 + 2];
                break;
            } else {
                i2++;
            }
        }
        e.b("OppoCameraCharacteristics", "getAvailableSMVRModes, fps: " + iArr[0] + ", batch num: " + iArr[1]);
        return iArr;
    }
}
