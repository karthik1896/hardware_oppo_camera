package com.oppo.camera.entry;

import android.database.AbstractCursor;
import com.oppo.camera.aps.constant.ApsConstant;
import com.oppo.camera.statistics.model.DcsMsgData;
import java.util.HashMap;
import java.util.Map;

/* compiled from: CameraInfoCursor */
public class c extends AbstractCursor implements a {
    private static Map<Integer, String> g = new HashMap<Integer, String>() {
        {
            put(0, ApsConstant.CAPTURE_MODE_COMMON);
            put(1, ApsConstant.CAPTURE_MODE_NIGHT);
            put(2, "portrait");
            put(3, ApsConstant.CAPTURE_MODE_PANORAMA);
            put(4, ApsConstant.CAPTURE_MODE_PROFESSIONAL);
            put(5, ApsConstant.CAPTURE_MODE_STICKER);
            put(6, ApsConstant.REC_MODE_COMMON);
            put(7, ApsConstant.REC_MODE_FAST_VIDEO);
            put(8, ApsConstant.REC_MODE_SLOW_VIDEO);
            put(11, "superText");
            put(12, ApsConstant.CAPTURE_MODE_ULTRA_HIGH_RESOLUTION);
            put(10, ApsConstant.CAPTURE_MODE_MACRO);
            put(9, ApsConstant.CAPTURE_MODE_HIGH_DEFINITION);
            put(13, ApsConstant.CAPTURE_MODE_ID_PHOTO);
            put(14, ApsConstant.CAPTURE_MODE_GROUP_SHOT);
            put(15, ApsConstant.CAPTURE_MODE_MULTI_VIDEO);
            put(17, ApsConstant.CAPTURE_MODE_MICROSCOPE);
            put(16, "movie");
            put(18, ApsConstant.CAPTURE_MODE_STARRY);
        }
    };
    private int[] e = new int[d.length];
    private Map<String, Integer> f = new HashMap();

    public int getCount() {
        return 1;
    }

    public double getDouble(int i) {
        return 0.0d;
    }

    public float getFloat(int i) {
        return 0.0f;
    }

    public short getShort(int i) {
        return 0;
    }

    public String getString(int i) {
        return null;
    }

    public int getType(int i) {
        return 1;
    }

    public boolean isNull(int i) {
        return false;
    }

    public c() {
        for (int i = 0; i < d.length; i++) {
            this.f.put(d[i], Integer.valueOf(i));
        }
    }

    public void a() {
        this.e[getColumnIndex("support")] = 15;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b() {
        /*
            r8 = this;
            java.util.Map<java.lang.Integer, java.lang.String> r0 = g
            java.util.Set r0 = r0.entrySet()
            java.util.Iterator r0 = r0.iterator()
            r1 = 0
            r2 = r1
        L_0x000c:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L_0x0122
            java.lang.Object r3 = r0.next()
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3
            java.lang.Object r4 = r3.getValue()
            java.lang.String r4 = (java.lang.String) r4
            r5 = -1
            int r6 = r4.hashCode()
            r7 = 1
            switch(r6) {
                case -1890252483: goto L_0x00aa;
                case -1482065415: goto L_0x009f;
                case -892483559: goto L_0x0094;
                case -735775298: goto L_0x0089;
                case -333683288: goto L_0x007f;
                case -332860600: goto L_0x0075;
                case 103652300: goto L_0x006b;
                case 104087344: goto L_0x0060;
                case 104817688: goto L_0x0056;
                case 729267099: goto L_0x004b;
                case 1373542928: goto L_0x003f;
                case 1638611415: goto L_0x0034;
                case 1704250517: goto L_0x0029;
                default: goto L_0x0027;
            }
        L_0x0027:
            goto L_0x00b4
        L_0x0029:
            java.lang.String r6 = "highDefinition"
            boolean r4 = r4.equals(r6)
            if (r4 == 0) goto L_0x00b4
            r4 = 6
            goto L_0x00b5
        L_0x0034:
            java.lang.String r6 = "idPhoto"
            boolean r4 = r4.equals(r6)
            if (r4 == 0) goto L_0x00b4
            r4 = 7
            goto L_0x00b5
        L_0x003f:
            java.lang.String r6 = "microscope"
            boolean r4 = r4.equals(r6)
            if (r4 == 0) goto L_0x00b4
            r4 = 11
            goto L_0x00b5
        L_0x004b:
            java.lang.String r6 = "portrait"
            boolean r4 = r4.equals(r6)
            if (r4 == 0) goto L_0x00b4
            r4 = r1
            goto L_0x00b5
        L_0x0056:
            java.lang.String r6 = "night"
            boolean r4 = r4.equals(r6)
            if (r4 == 0) goto L_0x00b4
            r4 = r7
            goto L_0x00b5
        L_0x0060:
            java.lang.String r6 = "movie"
            boolean r4 = r4.equals(r6)
            if (r4 == 0) goto L_0x00b4
            r4 = 10
            goto L_0x00b5
        L_0x006b:
            java.lang.String r6 = "macro"
            boolean r4 = r4.equals(r6)
            if (r4 == 0) goto L_0x00b4
            r4 = 5
            goto L_0x00b5
        L_0x0075:
            java.lang.String r6 = "superText"
            boolean r4 = r4.equals(r6)
            if (r4 == 0) goto L_0x00b4
            r4 = 3
            goto L_0x00b5
        L_0x007f:
            java.lang.String r6 = "ultraHD"
            boolean r4 = r4.equals(r6)
            if (r4 == 0) goto L_0x00b4
            r4 = 4
            goto L_0x00b5
        L_0x0089:
            java.lang.String r6 = "multiCamera"
            boolean r4 = r4.equals(r6)
            if (r4 == 0) goto L_0x00b4
            r4 = 9
            goto L_0x00b5
        L_0x0094:
            java.lang.String r6 = "starry"
            boolean r4 = r4.equals(r6)
            if (r4 == 0) goto L_0x00b4
            r4 = 12
            goto L_0x00b5
        L_0x009f:
            java.lang.String r6 = "groupshot"
            boolean r4 = r4.equals(r6)
            if (r4 == 0) goto L_0x00b4
            r4 = 8
            goto L_0x00b5
        L_0x00aa:
            java.lang.String r6 = "sticker"
            boolean r4 = r4.equals(r6)
            if (r4 == 0) goto L_0x00b4
            r4 = 2
            goto L_0x00b5
        L_0x00b4:
            r4 = r5
        L_0x00b5:
            switch(r4) {
                case 0: goto L_0x010d;
                case 1: goto L_0x0106;
                case 2: goto L_0x00ff;
                case 3: goto L_0x00f8;
                case 4: goto L_0x00f1;
                case 5: goto L_0x00ea;
                case 6: goto L_0x00e3;
                case 7: goto L_0x00dc;
                case 8: goto L_0x00d5;
                case 9: goto L_0x00ce;
                case 10: goto L_0x00c7;
                case 11: goto L_0x00c0;
                case 12: goto L_0x00b9;
                default: goto L_0x00b8;
            }
        L_0x00b8:
            goto L_0x0113
        L_0x00b9:
            java.lang.String r4 = "com.oplus.starry.support"
            boolean r7 = com.oppo.camera.aps.config.CameraConfig.getConfigBooleanValue(r4)
            goto L_0x0113
        L_0x00c0:
            java.lang.String r4 = "com.oppo.feature.microscope.support"
            boolean r7 = com.oppo.camera.aps.config.CameraConfig.getConfigBooleanValue(r4)
            goto L_0x0113
        L_0x00c7:
            java.lang.String r4 = "com.oplus.feature.movie.mode.support"
            boolean r7 = com.oppo.camera.aps.config.CameraConfig.getConfigBooleanValue(r4)
            goto L_0x0113
        L_0x00ce:
            java.lang.String r4 = "com.oplus.multi.video.mode.support"
            boolean r7 = com.oppo.camera.aps.config.CameraConfig.getConfigBooleanValue(r4)
            goto L_0x0113
        L_0x00d5:
            java.lang.String r4 = "com.oplus.feature.groupshot.support"
            boolean r7 = com.oppo.camera.aps.config.CameraConfig.getConfigBooleanValue(r4)
            goto L_0x0113
        L_0x00dc:
            java.lang.String r4 = "com.oplus.feature.id.photo.support"
            boolean r7 = com.oppo.camera.aps.config.CameraConfig.getConfigBooleanValue(r4)
            goto L_0x0113
        L_0x00e3:
            java.lang.String r4 = "com.oplus.feature.high.definition.support"
            boolean r7 = com.oppo.camera.aps.config.CameraConfig.getConfigBooleanValue(r4)
            goto L_0x0113
        L_0x00ea:
            java.lang.String r4 = "com.oplus.feature.macro.mode.support"
            boolean r7 = com.oppo.camera.aps.config.CameraConfig.getConfigBooleanValue(r4)
            goto L_0x0113
        L_0x00f1:
            java.lang.String r4 = "com.oplus.feature.ultra.high.resolution.support"
            boolean r7 = com.oppo.camera.aps.config.CameraConfig.getConfigBooleanValue(r4)
            goto L_0x0113
        L_0x00f8:
            java.lang.String r4 = "com.oplus.feature.super.text.support"
            boolean r7 = com.oppo.camera.aps.config.CameraConfig.getConfigBooleanValue(r4)
            goto L_0x0113
        L_0x00ff:
            java.lang.String r4 = "com.oplus.app.feature.sticker.support"
            boolean r7 = com.oppo.camera.aps.config.CameraConfig.getConfigBooleanValue(r4)
            goto L_0x0113
        L_0x0106:
            java.lang.String r4 = "com.oplus.feature.suppernight.support"
            boolean r7 = com.oppo.camera.aps.config.CameraConfig.getConfigBooleanValue(r4)
            goto L_0x0113
        L_0x010d:
            java.lang.String r4 = "com.oplus.feature.portrait.support"
            boolean r7 = com.oppo.camera.aps.config.CameraConfig.getConfigBooleanValue(r4)
        L_0x0113:
            java.lang.Object r3 = r3.getKey()
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r3 = r3.intValue()
            int r3 = r7 << r3
            r2 = r2 | r3
            goto L_0x000c
        L_0x0122:
            int[] r0 = r8.e
            java.lang.String r1 = "mode"
            int r1 = r8.getColumnIndex(r1)
            r0[r1] = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.entry.c.b():void");
    }

    public void c() {
        int i = 0;
        for (Map.Entry<Integer, String> key : g.entrySet()) {
            i |= 1 << ((Integer) key.getKey()).intValue();
        }
        this.e[getColumnIndex(DcsMsgData.REAR)] = this.e[getColumnIndex("mode")] & i;
    }

    public void d() {
        int i = 0;
        for (Map.Entry next : g.entrySet()) {
            if (b.a((String) next.getValue())) {
                i |= 1 << ((Integer) next.getKey()).intValue();
            }
        }
        this.e[getColumnIndex(DcsMsgData.FRONT)] = this.e[getColumnIndex("mode")] & i;
    }

    public void e() {
        int i = 0;
        for (Map.Entry next : g.entrySet()) {
            if (b.b((String) next.getValue())) {
                i |= 1 << ((Integer) next.getKey()).intValue();
            }
        }
        this.e[getColumnIndex("beauty")] = this.e[getColumnIndex("mode")] & i;
    }

    public static String a(int i) {
        return g.get(Integer.valueOf(i));
    }

    public int getColumnIndex(String str) {
        return this.f.get(str).intValue();
    }

    public String[] getColumnNames() {
        return d;
    }

    public int getInt(int i) {
        return this.e[i];
    }

    public long getLong(int i) {
        return (long) this.e[i];
    }
}
