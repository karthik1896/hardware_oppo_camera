package com.oppo.camera.entry;

import android.app.Activity;
import android.app.KeyguardManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import com.oppo.camera.R;
import com.oppo.camera.aps.config.CameraConfig;
import com.oppo.camera.aps.config.ConfigDataBase;
import com.oppo.camera.aps.constant.ApsConstant;
import com.oppo.camera.e;
import com.oppo.camera.statistics.model.DcsMsgData;
import com.oppo.camera.ui.preview.a.g;
import java.util.HashSet;
import java.util.Set;

/* compiled from: CameraEntry */
public class b implements a {
    private static Long e = -1L;
    private int f = 1;
    private int g = -1;
    private String h = "";
    private Activity i = null;
    private String j = "";
    private long k = 0;
    private boolean l = false;
    private boolean m = false;
    private boolean n = false;
    private boolean o = false;
    private boolean p = false;
    private int q = 3;
    private boolean r = true;
    private boolean s = true;
    private boolean t = false;
    private SharedPreferences u = null;
    private String v = null;
    private Set<String> w = new HashSet();

    /* compiled from: CameraEntry */
    private enum a {
        front_main,
        front_dual,
        front_wide,
        back_main,
        back_dual,
        back_second_dual,
        back_sat,
        back_wide,
        back_tele,
        back_mono,
        back_macro,
        back_streamer_main,
        back_microscope
    }

    public static boolean a(int i2) {
        return 2 == i2 || 3 == i2;
    }

    public void a() {
        if (1 == y() && !this.s) {
            long currentTimeMillis = System.currentTimeMillis();
            e.a("CameraEntry", "saveCameraExitState, currentTime: " + currentTimeMillis);
            this.s = true;
            SharedPreferences.Editor edit = this.u.edit();
            edit.putLong("pref_camera_exit_time_stamp_key", currentTimeMillis);
            edit.apply();
        }
    }

    public void a(boolean z) {
        e.a("CameraEntry", "set mbShouldKeepCurrentMode: " + z);
        this.t = z;
    }

    public boolean b() {
        return this.t;
    }

    public boolean c() {
        long j2 = this.u.getLong("pref_report_permission_timestamp", 0);
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - j2 <= 86400000) {
            return false;
        }
        this.u.edit().putLong("pref_report_permission_timestamp", currentTimeMillis).apply();
        return true;
    }

    public boolean d() {
        return H() && this.r;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean a(java.lang.String r4, com.oppo.camera.entry.b.a r5) {
        /*
            r3 = this;
            int r0 = r4.hashCode()
            r1 = 1
            r2 = 0
            switch(r0) {
                case -1933413040: goto L_0x00df;
                case -1890252483: goto L_0x00d4;
                case -1482065415: goto L_0x00ca;
                case -1354814997: goto L_0x00c0;
                case -1060049483: goto L_0x00b5;
                case -892483559: goto L_0x00aa;
                case -333683288: goto L_0x00a0;
                case -332860600: goto L_0x0096;
                case -35510913: goto L_0x008b;
                case 103652300: goto L_0x007f;
                case 104087344: goto L_0x0073;
                case 104817688: goto L_0x0068;
                case 325866571: goto L_0x005d;
                case 729267099: goto L_0x0051;
                case 764302074: goto L_0x0045;
                case 875077159: goto L_0x0039;
                case 1069983349: goto L_0x002e;
                case 1373542928: goto L_0x0023;
                case 1638611415: goto L_0x0017;
                case 1704250517: goto L_0x000b;
                default: goto L_0x0009;
            }
        L_0x0009:
            goto L_0x00ea
        L_0x000b:
            java.lang.String r0 = "highDefinition"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x00ea
            r4 = 17
            goto L_0x00eb
        L_0x0017:
            java.lang.String r0 = "idPhoto"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x00ea
            r4 = 18
            goto L_0x00eb
        L_0x0023:
            java.lang.String r0 = "microscope"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x00ea
            r4 = 3
            goto L_0x00eb
        L_0x002e:
            java.lang.String r0 = "panorama"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x00ea
            r4 = 7
            goto L_0x00eb
        L_0x0039:
            java.lang.String r0 = "professional"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x00ea
            r4 = 9
            goto L_0x00eb
        L_0x0045:
            java.lang.String r0 = "slowVideo"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x00ea
            r4 = 14
            goto L_0x00eb
        L_0x0051:
            java.lang.String r0 = "portrait"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x00ea
            r4 = 8
            goto L_0x00eb
        L_0x005d:
            java.lang.String r0 = "microscopeVideo"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x00ea
            r4 = 4
            goto L_0x00eb
        L_0x0068:
            java.lang.String r0 = "night"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x00ea
            r4 = 6
            goto L_0x00eb
        L_0x0073:
            java.lang.String r0 = "movie"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x00ea
            r4 = 15
            goto L_0x00eb
        L_0x007f:
            java.lang.String r0 = "macro"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x00ea
            r4 = 16
            goto L_0x00eb
        L_0x008b:
            java.lang.String r0 = "fastVideo"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x00ea
            r4 = 13
            goto L_0x00eb
        L_0x0096:
            java.lang.String r0 = "superText"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x00ea
            r4 = r2
            goto L_0x00eb
        L_0x00a0:
            java.lang.String r0 = "ultraHD"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x00ea
            r4 = r1
            goto L_0x00eb
        L_0x00aa:
            java.lang.String r0 = "starry"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x00ea
            r4 = 19
            goto L_0x00eb
        L_0x00b5:
            java.lang.String r0 = "double_exposure"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x00ea
            r4 = 12
            goto L_0x00eb
        L_0x00c0:
            java.lang.String r0 = "common"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x00ea
            r4 = 5
            goto L_0x00eb
        L_0x00ca:
            java.lang.String r0 = "groupshot"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x00ea
            r4 = 2
            goto L_0x00eb
        L_0x00d4:
            java.lang.String r0 = "sticker"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x00ea
            r4 = 10
            goto L_0x00eb
        L_0x00df:
            java.lang.String r0 = "commonVideo"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x00ea
            r4 = 11
            goto L_0x00eb
        L_0x00ea:
            r4 = -1
        L_0x00eb:
            switch(r4) {
                case 0: goto L_0x022e;
                case 1: goto L_0x01f9;
                case 2: goto L_0x01f2;
                case 3: goto L_0x01eb;
                case 4: goto L_0x01e4;
                case 5: goto L_0x01c9;
                case 6: goto L_0x01ae;
                case 7: goto L_0x01a3;
                case 8: goto L_0x0188;
                case 9: goto L_0x0175;
                case 10: goto L_0x0166;
                case 11: goto L_0x014b;
                case 12: goto L_0x014b;
                case 13: goto L_0x0138;
                case 14: goto L_0x0131;
                case 15: goto L_0x0122;
                case 16: goto L_0x011b;
                case 17: goto L_0x0114;
                case 18: goto L_0x0109;
                case 19: goto L_0x00ef;
                default: goto L_0x00ee;
            }
        L_0x00ee:
            return r2
        L_0x00ef:
            java.lang.String r4 = "com.oplus.starry.mode.support.preversion"
            boolean r4 = com.oppo.camera.aps.config.CameraConfig.getConfigBooleanValue(r4)
            if (r4 == 0) goto L_0x0102
            com.oppo.camera.entry.b$a r4 = com.oppo.camera.entry.b.a.back_sat
            if (r5 == r4) goto L_0x0101
            com.oppo.camera.entry.b$a r4 = com.oppo.camera.entry.b.a.back_main
            if (r5 != r4) goto L_0x0100
            goto L_0x0101
        L_0x0100:
            r1 = r2
        L_0x0101:
            return r1
        L_0x0102:
            com.oppo.camera.entry.b$a r4 = com.oppo.camera.entry.b.a.back_main
            if (r5 != r4) goto L_0x0107
            goto L_0x0108
        L_0x0107:
            r1 = r2
        L_0x0108:
            return r1
        L_0x0109:
            com.oppo.camera.entry.b$a r4 = com.oppo.camera.entry.b.a.back_main
            if (r5 == r4) goto L_0x0113
            com.oppo.camera.entry.b$a r4 = com.oppo.camera.entry.b.a.front_main
            if (r5 != r4) goto L_0x0112
            goto L_0x0113
        L_0x0112:
            r1 = r2
        L_0x0113:
            return r1
        L_0x0114:
            com.oppo.camera.entry.b$a r4 = com.oppo.camera.entry.b.a.back_main
            if (r5 != r4) goto L_0x0119
            goto L_0x011a
        L_0x0119:
            r1 = r2
        L_0x011a:
            return r1
        L_0x011b:
            com.oppo.camera.entry.b$a r4 = com.oppo.camera.entry.b.a.back_macro
            if (r5 != r4) goto L_0x0120
            goto L_0x0121
        L_0x0120:
            r1 = r2
        L_0x0121:
            return r1
        L_0x0122:
            com.oppo.camera.entry.b$a r4 = com.oppo.camera.entry.b.a.back_wide
            if (r5 == r4) goto L_0x0130
            com.oppo.camera.entry.b$a r4 = com.oppo.camera.entry.b.a.back_tele
            if (r5 == r4) goto L_0x0130
            com.oppo.camera.entry.b$a r4 = com.oppo.camera.entry.b.a.back_main
            if (r5 != r4) goto L_0x012f
            goto L_0x0130
        L_0x012f:
            r1 = r2
        L_0x0130:
            return r1
        L_0x0131:
            com.oppo.camera.entry.b$a r4 = com.oppo.camera.entry.b.a.back_main
            if (r5 != r4) goto L_0x0136
            goto L_0x0137
        L_0x0136:
            r1 = r2
        L_0x0137:
            return r1
        L_0x0138:
            com.oppo.camera.entry.b$a r4 = com.oppo.camera.entry.b.a.front_main
            if (r5 == r4) goto L_0x014a
            com.oppo.camera.entry.b$a r4 = com.oppo.camera.entry.b.a.back_main
            if (r5 == r4) goto L_0x014a
            com.oppo.camera.entry.b$a r4 = com.oppo.camera.entry.b.a.back_wide
            if (r5 == r4) goto L_0x014a
            com.oppo.camera.entry.b$a r4 = com.oppo.camera.entry.b.a.back_sat
            if (r5 != r4) goto L_0x0149
            goto L_0x014a
        L_0x0149:
            r1 = r2
        L_0x014a:
            return r1
        L_0x014b:
            com.oppo.camera.entry.b$a r4 = com.oppo.camera.entry.b.a.front_main
            if (r5 == r4) goto L_0x0165
            com.oppo.camera.entry.b$a r4 = com.oppo.camera.entry.b.a.front_wide
            if (r5 == r4) goto L_0x0165
            com.oppo.camera.entry.b$a r4 = com.oppo.camera.entry.b.a.back_main
            if (r5 == r4) goto L_0x0165
            com.oppo.camera.entry.b$a r4 = com.oppo.camera.entry.b.a.back_wide
            if (r5 == r4) goto L_0x0165
            com.oppo.camera.entry.b$a r4 = com.oppo.camera.entry.b.a.back_tele
            if (r5 == r4) goto L_0x0165
            com.oppo.camera.entry.b$a r4 = com.oppo.camera.entry.b.a.back_sat
            if (r5 != r4) goto L_0x0164
            goto L_0x0165
        L_0x0164:
            r1 = r2
        L_0x0165:
            return r1
        L_0x0166:
            com.oppo.camera.entry.b$a r4 = com.oppo.camera.entry.b.a.front_dual
            if (r5 == r4) goto L_0x0174
            com.oppo.camera.entry.b$a r4 = com.oppo.camera.entry.b.a.front_main
            if (r5 == r4) goto L_0x0174
            com.oppo.camera.entry.b$a r4 = com.oppo.camera.entry.b.a.back_main
            if (r5 != r4) goto L_0x0173
            goto L_0x0174
        L_0x0173:
            r1 = r2
        L_0x0174:
            return r1
        L_0x0175:
            com.oppo.camera.entry.b$a r4 = com.oppo.camera.entry.b.a.back_wide
            if (r5 == r4) goto L_0x0187
            com.oppo.camera.entry.b$a r4 = com.oppo.camera.entry.b.a.back_tele
            if (r5 == r4) goto L_0x0187
            com.oppo.camera.entry.b$a r4 = com.oppo.camera.entry.b.a.back_macro
            if (r5 == r4) goto L_0x0187
            com.oppo.camera.entry.b$a r4 = com.oppo.camera.entry.b.a.back_main
            if (r5 != r4) goto L_0x0186
            goto L_0x0187
        L_0x0186:
            r1 = r2
        L_0x0187:
            return r1
        L_0x0188:
            com.oppo.camera.entry.b$a r4 = com.oppo.camera.entry.b.a.back_dual
            if (r5 == r4) goto L_0x01a2
            com.oppo.camera.entry.b$a r4 = com.oppo.camera.entry.b.a.back_second_dual
            if (r5 == r4) goto L_0x01a2
            com.oppo.camera.entry.b$a r4 = com.oppo.camera.entry.b.a.back_mono
            if (r5 == r4) goto L_0x01a2
            com.oppo.camera.entry.b$a r4 = com.oppo.camera.entry.b.a.front_main
            if (r5 == r4) goto L_0x01a2
            com.oppo.camera.entry.b$a r4 = com.oppo.camera.entry.b.a.front_dual
            if (r5 == r4) goto L_0x01a2
            com.oppo.camera.entry.b$a r4 = com.oppo.camera.entry.b.a.back_streamer_main
            if (r5 != r4) goto L_0x01a1
            goto L_0x01a2
        L_0x01a1:
            r1 = r2
        L_0x01a2:
            return r1
        L_0x01a3:
            com.oppo.camera.entry.b$a r4 = com.oppo.camera.entry.b.a.front_main
            if (r5 == r4) goto L_0x01ad
            com.oppo.camera.entry.b$a r4 = com.oppo.camera.entry.b.a.back_main
            if (r5 != r4) goto L_0x01ac
            goto L_0x01ad
        L_0x01ac:
            r1 = r2
        L_0x01ad:
            return r1
        L_0x01ae:
            com.oppo.camera.entry.b$a r4 = com.oppo.camera.entry.b.a.back_main
            if (r5 == r4) goto L_0x01c8
            com.oppo.camera.entry.b$a r4 = com.oppo.camera.entry.b.a.back_wide
            if (r5 == r4) goto L_0x01c8
            com.oppo.camera.entry.b$a r4 = com.oppo.camera.entry.b.a.back_tele
            if (r5 == r4) goto L_0x01c8
            com.oppo.camera.entry.b$a r4 = com.oppo.camera.entry.b.a.back_sat
            if (r5 == r4) goto L_0x01c8
            com.oppo.camera.entry.b$a r4 = com.oppo.camera.entry.b.a.front_main
            if (r5 == r4) goto L_0x01c8
            com.oppo.camera.entry.b$a r4 = com.oppo.camera.entry.b.a.front_wide
            if (r5 != r4) goto L_0x01c7
            goto L_0x01c8
        L_0x01c7:
            r1 = r2
        L_0x01c8:
            return r1
        L_0x01c9:
            com.oppo.camera.entry.b$a r4 = com.oppo.camera.entry.b.a.back_sat
            if (r5 == r4) goto L_0x01e3
            com.oppo.camera.entry.b$a r4 = com.oppo.camera.entry.b.a.back_main
            if (r5 == r4) goto L_0x01e3
            com.oppo.camera.entry.b$a r4 = com.oppo.camera.entry.b.a.back_wide
            if (r5 == r4) goto L_0x01e3
            com.oppo.camera.entry.b$a r4 = com.oppo.camera.entry.b.a.back_tele
            if (r5 == r4) goto L_0x01e3
            com.oppo.camera.entry.b$a r4 = com.oppo.camera.entry.b.a.front_main
            if (r5 == r4) goto L_0x01e3
            com.oppo.camera.entry.b$a r4 = com.oppo.camera.entry.b.a.front_wide
            if (r5 != r4) goto L_0x01e2
            goto L_0x01e3
        L_0x01e2:
            r1 = r2
        L_0x01e3:
            return r1
        L_0x01e4:
            com.oppo.camera.entry.b$a r4 = com.oppo.camera.entry.b.a.back_microscope
            if (r5 != r4) goto L_0x01e9
            goto L_0x01ea
        L_0x01e9:
            r1 = r2
        L_0x01ea:
            return r1
        L_0x01eb:
            com.oppo.camera.entry.b$a r4 = com.oppo.camera.entry.b.a.back_microscope
            if (r5 != r4) goto L_0x01f0
            goto L_0x01f1
        L_0x01f0:
            r1 = r2
        L_0x01f1:
            return r1
        L_0x01f2:
            com.oppo.camera.entry.b$a r4 = com.oppo.camera.entry.b.a.back_main
            if (r5 != r4) goto L_0x01f7
            goto L_0x01f8
        L_0x01f7:
            r1 = r2
        L_0x01f8:
            return r1
        L_0x01f9:
            java.lang.String r4 = "com.oplus.feature.ultra.high.resolution.full.zoom.support"
            boolean r4 = com.oppo.camera.aps.config.CameraConfig.getConfigBooleanValue(r4)
            if (r4 == 0) goto L_0x0210
            com.oppo.camera.entry.b$a r4 = com.oppo.camera.entry.b.a.back_main
            if (r5 == r4) goto L_0x020f
            com.oppo.camera.entry.b$a r4 = com.oppo.camera.entry.b.a.back_wide
            if (r5 == r4) goto L_0x020f
            com.oppo.camera.entry.b$a r4 = com.oppo.camera.entry.b.a.back_sat
            if (r5 != r4) goto L_0x020e
            goto L_0x020f
        L_0x020e:
            r1 = r2
        L_0x020f:
            return r1
        L_0x0210:
            java.lang.String r4 = "com.oplus.ultra.high.resolution.switch.camera.support"
            boolean r4 = com.oppo.camera.aps.config.CameraConfig.getConfigBooleanValue(r4)
            if (r4 == 0) goto L_0x0227
            com.oppo.camera.entry.b$a r4 = com.oppo.camera.entry.b.a.back_wide
            if (r5 == r4) goto L_0x0226
            com.oppo.camera.entry.b$a r4 = com.oppo.camera.entry.b.a.back_tele
            if (r5 == r4) goto L_0x0226
            com.oppo.camera.entry.b$a r4 = com.oppo.camera.entry.b.a.back_main
            if (r5 != r4) goto L_0x0225
            goto L_0x0226
        L_0x0225:
            r1 = r2
        L_0x0226:
            return r1
        L_0x0227:
            com.oppo.camera.entry.b$a r4 = com.oppo.camera.entry.b.a.back_main
            if (r5 != r4) goto L_0x022c
            goto L_0x022d
        L_0x022c:
            r1 = r2
        L_0x022d:
            return r1
        L_0x022e:
            com.oppo.camera.entry.b$a r4 = com.oppo.camera.entry.b.a.back_sat
            if (r5 == r4) goto L_0x023c
            com.oppo.camera.entry.b$a r4 = com.oppo.camera.entry.b.a.back_wide
            if (r5 == r4) goto L_0x023c
            com.oppo.camera.entry.b$a r4 = com.oppo.camera.entry.b.a.back_main
            if (r5 != r4) goto L_0x023b
            goto L_0x023c
        L_0x023b:
            r1 = r2
        L_0x023c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.entry.b.a(java.lang.String, com.oppo.camera.entry.b$a):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:126:0x0291 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x0293  */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x02fe  */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x0300  */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x0309  */
    /* JADX WARNING: Removed duplicated region for block: B:155:0x0328  */
    /* JADX WARNING: Removed duplicated region for block: B:159:0x0331  */
    /* JADX WARNING: Removed duplicated region for block: B:209:0x03f0  */
    /* JADX WARNING: Removed duplicated region for block: B:227:0x041a  */
    /* JADX WARNING: Removed duplicated region for block: B:237:0x0436  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x01bf  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean b(java.lang.String r24, com.oppo.camera.entry.b.a r25) {
        /*
            r23 = this;
            r0 = r23
            r1 = r24
            r2 = r25
            com.oppo.camera.entry.b$a r3 = com.oppo.camera.entry.b.a.back_sat
            java.lang.String r4 = "pref_video_super_eis_key"
            java.lang.String r5 = "ultraHD"
            java.lang.String r6 = "pref_video_size_key"
            java.lang.String r7 = "night"
            java.lang.String r8 = "common"
            java.lang.String r9 = "double_exposure"
            java.lang.String r10 = "commonVideo"
            java.lang.String r12 = "off"
            java.lang.String r13 = "on"
            r14 = 0
            if (r2 != r3) goto L_0x01b3
            boolean r3 = r10.equals(r1)
            if (r3 != 0) goto L_0x00a5
            boolean r3 = r9.equals(r1)
            if (r3 == 0) goto L_0x002b
            goto L_0x00a5
        L_0x002b:
            boolean r3 = r8.equals(r1)
            if (r3 == 0) goto L_0x0042
            boolean r3 = com.oppo.camera.f.a.f()
            if (r3 == 0) goto L_0x0041
            android.content.SharedPreferences r3 = r0.u
            java.lang.String r15 = "key_high_picture_size"
            boolean r3 = r3.getBoolean(r15, r14)
            if (r3 == 0) goto L_0x01b3
        L_0x0041:
            return r14
        L_0x0042:
            boolean r3 = r7.equals(r1)
            if (r3 == 0) goto L_0x005e
            boolean r3 = com.oppo.camera.f.a.f()
            if (r3 != 0) goto L_0x004f
            return r14
        L_0x004f:
            android.content.SharedPreferences r3 = r0.u
            java.lang.String r15 = "pref_night_pro_mode_key"
            java.lang.String r3 = r3.getString(r15, r12)
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x01b3
            return r14
        L_0x005e:
            java.lang.String r3 = "superText"
            boolean r3 = r3.equals(r1)
            if (r3 != 0) goto L_0x009e
            boolean r3 = r5.equals(r1)
            if (r3 == 0) goto L_0x006d
            goto L_0x009e
        L_0x006d:
            java.lang.String r3 = "fastVideo"
            boolean r3 = r3.equals(r1)
            if (r3 == 0) goto L_0x0095
            java.lang.String r3 = "com.oplus.feature.fast.video.sat.support"
            boolean r3 = com.oppo.camera.aps.config.CameraConfig.getConfigBooleanValue(r3)
            if (r3 == 0) goto L_0x0094
            android.content.SharedPreferences r3 = r0.u
            android.app.Activity r15 = r0.i
            r11 = 2131755792(0x7f100310, float:1.9142473E38)
            java.lang.String r11 = r15.getString(r11)
            java.lang.String r15 = "pref_video_hyper_lapse_key"
            java.lang.String r3 = r3.getString(r15, r11)
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x01b3
        L_0x0094:
            return r14
        L_0x0095:
            java.lang.String r3 = "groupshot"
            boolean r3 = r3.equals(r1)
            if (r3 == 0) goto L_0x01b3
            return r14
        L_0x009e:
            boolean r3 = com.oppo.camera.f.a.f()
            if (r3 != 0) goto L_0x01b3
            return r14
        L_0x00a5:
            java.lang.String r3 = "com.oplus.feature.video.sat.support"
            boolean r3 = com.oppo.camera.aps.config.CameraConfig.getConfigBooleanValue(r3)
            if (r3 != 0) goto L_0x00ae
            return r14
        L_0x00ae:
            android.content.SharedPreferences r3 = r0.u
            android.app.Activity r11 = r0.i
            android.content.res.Resources r11 = r11.getResources()
            r15 = 2131755790(0x7f10030e, float:1.914247E38)
            java.lang.String r11 = r11.getString(r15)
            java.lang.String r15 = "key_video_hdr"
            java.lang.String r3 = r3.getString(r15, r11)
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x00ca
            return r14
        L_0x00ca:
            android.content.SharedPreferences r3 = r0.u
            android.app.Activity r11 = r0.i
            android.content.res.Resources r11 = r11.getResources()
            r15 = 2131755748(0x7f1002e4, float:1.9142384E38)
            java.lang.String r11 = r11.getString(r15)
            java.lang.String r15 = "key_ultra_night_video"
            java.lang.String r3 = r3.getString(r15, r11)
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x00e6
            return r14
        L_0x00e6:
            android.content.SharedPreferences r3 = r0.u
            android.app.Activity r11 = r0.i
            android.content.res.Resources r11 = r11.getResources()
            r15 = 2131755122(0x7f100072, float:1.9141114E38)
            java.lang.String r11 = r11.getString(r15)
            java.lang.String r15 = "key_ai_enhancement_video"
            java.lang.String r3 = r3.getString(r15, r11)
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x0102
            return r14
        L_0x0102:
            android.content.SharedPreferences r3 = r0.u
            java.lang.String r3 = r3.getString(r4, r12)
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x010f
            return r14
        L_0x010f:
            android.content.SharedPreferences r3 = r0.u
            java.lang.String r11 = "pref_video_tilt_shift_key"
            java.lang.String r3 = r3.getString(r11, r12)
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x011e
            return r14
        L_0x011e:
            android.content.SharedPreferences r3 = r0.u
            java.lang.String r11 = "pref_video_timelapse_tilt_shift_key"
            java.lang.String r3 = r3.getString(r11, r12)
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x012d
            return r14
        L_0x012d:
            android.content.SharedPreferences r3 = r0.u
            java.lang.String r11 = "pref_video_blur_menu_state"
            boolean r3 = r3.getBoolean(r11, r14)
            if (r3 == 0) goto L_0x0138
            return r14
        L_0x0138:
            android.content.SharedPreferences r3 = r0.u
            int r11 = com.oppo.camera.ui.preview.a.g.f4385a
            java.lang.String r15 = "key_video_filter_index"
            int r3 = r3.getInt(r15, r11)
            int r11 = com.oppo.camera.ui.preview.a.g.a((boolean) r14)
            if (r3 != r11) goto L_0x0149
            return r14
        L_0x0149:
            android.content.SharedPreferences r3 = r0.u
            android.app.Activity r11 = r0.i
            r15 = 2131755765(0x7f1002f5, float:1.9142419E38)
            java.lang.String r11 = r11.getString(r15)
            java.lang.String r15 = "pref_video_fps_key"
            java.lang.String r3 = r3.getString(r15, r11)
            android.content.SharedPreferences r11 = r0.u
            java.lang.String r15 = com.oppo.camera.aps.config.CameraConfig.getOptionKeyDefaultValue(r6, r14)
            java.lang.String r11 = r11.getString(r6, r15)
            java.lang.String r15 = "com.oplus.feature.video.sat.mask"
            int r15 = com.oppo.camera.aps.config.CameraConfig.getConfigIntValue(r15)
            r16 = 1
            r15 = r15 & 1
            if (r15 != 0) goto L_0x017f
            java.lang.Integer r15 = java.lang.Integer.valueOf(r3)
            int r15 = r15.intValue()
            r17 = r4
            r4 = 30
            if (r15 == r4) goto L_0x0181
            return r14
        L_0x017f:
            r17 = r4
        L_0x0181:
            java.lang.String r4 = "com.oplus.feature.video.sat.mask"
            int r4 = com.oppo.camera.aps.config.CameraConfig.getConfigIntValue(r4)
            r4 = r4 & 2
            if (r4 != 0) goto L_0x0194
            java.lang.String r4 = "video_size_4kuhd"
            boolean r4 = r4.equals(r11)
            if (r4 == 0) goto L_0x0194
            return r14
        L_0x0194:
            java.lang.String r4 = "com.oplus.feature.video.sat.mask"
            int r4 = com.oppo.camera.aps.config.CameraConfig.getConfigIntValue(r4)
            r4 = r4 & 4
            if (r4 != 0) goto L_0x01b5
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            int r3 = r3.intValue()
            r4 = 30
            if (r3 == r4) goto L_0x01b5
            java.lang.String r3 = "video_size_4kuhd"
            boolean r3 = r3.equals(r11)
            if (r3 == 0) goto L_0x01b5
            return r14
        L_0x01b3:
            r17 = r4
        L_0x01b5:
            com.oppo.camera.entry.b$a r3 = com.oppo.camera.entry.b.a.back_tele
            java.lang.String r4 = "professional"
            java.lang.String r11 = "pref_switch_camera_key"
            java.lang.String r15 = "camera_main"
            if (r2 != r3) goto L_0x0275
            boolean r3 = r4.equals(r1)
            java.lang.String r14 = "camera_tele"
            if (r3 == 0) goto L_0x01d5
            android.content.SharedPreferences r3 = r0.u
            java.lang.String r3 = r3.getString(r11, r15)
            boolean r3 = r3.equals(r14)
            if (r3 != 0) goto L_0x0275
            r3 = 0
            return r3
        L_0x01d5:
            java.lang.String r3 = "movie"
            boolean r3 = r3.equals(r1)
            if (r3 == 0) goto L_0x01ed
            android.content.SharedPreferences r3 = r0.u
            java.lang.String r6 = "pref_switch_camera_bar_key"
            java.lang.String r3 = r3.getString(r6, r15)
            boolean r3 = r3.equals(r14)
            if (r3 != 0) goto L_0x0275
            r3 = 0
            return r3
        L_0x01ed:
            r3 = 0
            boolean r18 = r5.equals(r1)
            if (r18 == 0) goto L_0x0201
            android.content.SharedPreferences r6 = r0.u
            java.lang.String r6 = r6.getString(r11, r15)
            boolean r6 = r6.equals(r14)
            if (r6 != 0) goto L_0x0275
            return r3
        L_0x0201:
            boolean r3 = r8.equals(r1)
            if (r3 != 0) goto L_0x0261
            boolean r3 = r7.equals(r1)
            if (r3 == 0) goto L_0x020e
            goto L_0x0261
        L_0x020e:
            boolean r3 = r10.equals(r1)
            if (r3 != 0) goto L_0x021a
            boolean r3 = r9.equals(r1)
            if (r3 == 0) goto L_0x0275
        L_0x021a:
            android.content.SharedPreferences r3 = r0.u
            android.app.Activity r14 = r0.i
            r19 = r5
            r5 = 2131755765(0x7f1002f5, float:1.9142419E38)
            java.lang.String r5 = r14.getString(r5)
            java.lang.String r14 = "pref_video_fps_key"
            java.lang.String r3 = r3.getString(r14, r5)
            android.content.SharedPreferences r5 = r0.u
            r20 = r7
            r14 = 0
            java.lang.String r7 = com.oppo.camera.aps.config.CameraConfig.getOptionKeyDefaultValue(r6, r14)
            java.lang.String r5 = r5.getString(r6, r7)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            int r3 = r3.intValue()
            r6 = 60
            if (r3 == r6) goto L_0x025f
            java.lang.String r3 = "video_size_4kuhd"
            boolean r3 = r3.equals(r5)
            if (r3 == 0) goto L_0x024f
            goto L_0x025f
        L_0x024f:
            android.content.SharedPreferences r3 = r0.u
            java.lang.String r5 = "pref_none_sat_tele_angle_key"
            java.lang.String r3 = r3.getString(r5, r12)
            boolean r3 = r3.equals(r13)
            if (r3 != 0) goto L_0x0279
            r3 = 0
            return r3
        L_0x025f:
            r3 = 0
            return r3
        L_0x0261:
            r19 = r5
            r20 = r7
            r3 = 0
            android.content.SharedPreferences r5 = r0.u
            java.lang.String r6 = "pref_none_sat_tele_angle_key"
            java.lang.String r5 = r5.getString(r6, r12)
            boolean r5 = r5.equals(r13)
            if (r5 != 0) goto L_0x0279
            return r3
        L_0x0275:
            r19 = r5
            r20 = r7
        L_0x0279:
            com.oppo.camera.entry.b$a r3 = com.oppo.camera.entry.b.a.back_macro
            if (r2 != r3) goto L_0x0293
            boolean r3 = r4.equals(r1)
            if (r3 == 0) goto L_0x0293
            android.content.SharedPreferences r3 = r0.u
            java.lang.String r3 = r3.getString(r11, r15)
            java.lang.String r5 = "camera_macro"
            boolean r3 = r5.equals(r3)
            if (r3 != 0) goto L_0x0293
            r3 = 0
            return r3
        L_0x0293:
            android.content.SharedPreferences r3 = r0.u
            java.lang.String r5 = "pref_none_sat_ultra_wide_angle_key"
            boolean r3 = r3.contains(r5)
            if (r3 == 0) goto L_0x02ad
            android.content.SharedPreferences r3 = r0.u
            java.lang.String r5 = "pref_none_sat_ultra_wide_angle_key"
            java.lang.String r3 = r3.getString(r5, r12)
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x02ad
            r3 = 1
            goto L_0x02ae
        L_0x02ad:
            r3 = 0
        L_0x02ae:
            java.lang.String r5 = "com.oplus.feature.front.eis.wide.force.support"
            boolean r5 = com.oppo.camera.aps.config.CameraConfig.getConfigBooleanValue(r5)
            android.content.SharedPreferences r6 = r0.u
            r7 = r17
            java.lang.String r6 = r6.getString(r7, r12)
            boolean r6 = r13.equals(r6)
            android.content.SharedPreferences r14 = r0.u
            java.lang.String r7 = r14.getString(r7, r12)
            boolean r7 = r13.equals(r7)
            if (r7 == 0) goto L_0x02e3
            java.lang.String r7 = "com.oplus.feature.video.super.eis.wide.support"
            boolean r7 = com.oppo.camera.aps.config.CameraConfig.getConfigBooleanValue(r7)
            if (r7 == 0) goto L_0x02e3
            android.content.SharedPreferences r7 = r0.u
            java.lang.String r14 = "pref_super_eis_wide_key"
            r17 = r6
            r6 = 0
            boolean r7 = r7.getBoolean(r14, r6)
            if (r7 == 0) goto L_0x02e5
            r6 = 1
            goto L_0x02e6
        L_0x02e3:
            r17 = r6
        L_0x02e5:
            r6 = 0
        L_0x02e6:
            android.content.SharedPreferences r7 = r0.u
            java.lang.String r14 = "pref_portrait_half_body_key"
            boolean r7 = r7.contains(r14)
            if (r7 == 0) goto L_0x0300
            android.content.SharedPreferences r7 = r0.u
            java.lang.String r14 = "pref_portrait_half_body_key"
            java.lang.String r7 = r7.getString(r14, r12)
            boolean r7 = r13.equals(r7)
            if (r7 == 0) goto L_0x0300
            r7 = 1
            goto L_0x0301
        L_0x0300:
            r7 = 0
        L_0x0301:
            java.lang.String r14 = "com.oplus.ultra.wide.high.picturesize"
            boolean r14 = com.oppo.camera.aps.config.CameraConfig.getConfigBooleanValue(r14)
            if (r14 == 0) goto L_0x0328
            android.content.SharedPreferences r14 = r0.u
            r21 = r7
            java.lang.String r7 = "key_high_picture_size"
            r22 = r5
            r5 = 0
            boolean r7 = r14.getBoolean(r7, r5)
            if (r7 == 0) goto L_0x032c
            android.content.SharedPreferences r5 = r0.u
            java.lang.String r7 = "pref_ultra_wide_high_picture_size_key"
            java.lang.String r5 = r5.getString(r7, r12)
            boolean r5 = r13.equals(r5)
            if (r5 == 0) goto L_0x032c
            r5 = 1
            goto L_0x032d
        L_0x0328:
            r22 = r5
            r21 = r7
        L_0x032c:
            r5 = 0
        L_0x032d:
            com.oppo.camera.entry.b$a r7 = com.oppo.camera.entry.b.a.back_wide
            if (r2 != r7) goto L_0x03e9
            boolean r7 = r8.equals(r1)
            if (r7 == 0) goto L_0x033d
            if (r3 != 0) goto L_0x03e9
            if (r5 != 0) goto L_0x03e9
            r7 = 0
            return r7
        L_0x033d:
            r7 = 0
            boolean r4 = r4.equals(r1)
            if (r4 == 0) goto L_0x0357
            android.content.SharedPreferences r4 = r0.u
            java.lang.String r4 = r4.getString(r11, r15)
            java.lang.String r11 = "camera_ultra_wide"
            boolean r4 = r4.equals(r11)
            if (r4 != 0) goto L_0x0353
            return r7
        L_0x0353:
            r4 = r20
            goto L_0x03ec
        L_0x0357:
            boolean r4 = r10.equals(r1)
            if (r4 != 0) goto L_0x03e2
            boolean r4 = r9.equals(r1)
            if (r4 == 0) goto L_0x0365
            goto L_0x03e2
        L_0x0365:
            r4 = r20
            boolean r13 = r4.equals(r1)
            if (r13 == 0) goto L_0x0370
            if (r3 != 0) goto L_0x03ec
            return r7
        L_0x0370:
            java.lang.String r13 = "superText"
            boolean r13 = r13.equals(r1)
            if (r13 == 0) goto L_0x037b
            if (r3 != 0) goto L_0x03ec
            return r7
        L_0x037b:
            r13 = r19
            boolean r13 = r13.equals(r1)
            if (r13 == 0) goto L_0x0392
            android.content.SharedPreferences r12 = r0.u
            java.lang.String r11 = r12.getString(r11, r15)
            java.lang.String r12 = "camera_ultra_wide"
            boolean r11 = r11.equals(r12)
            if (r11 != 0) goto L_0x03ec
            return r7
        L_0x0392:
            java.lang.String r7 = "fastVideo"
            boolean r7 = r7.equals(r1)
            if (r7 == 0) goto L_0x03c8
            if (r3 != 0) goto L_0x03eb
            android.content.SharedPreferences r7 = r0.u
            android.app.Activity r11 = r0.i
            r13 = 2131755792(0x7f100310, float:1.9142473E38)
            java.lang.String r11 = r11.getString(r13)
            java.lang.String r13 = "pref_video_hyper_lapse_key"
            java.lang.String r7 = r7.getString(r13, r11)
            boolean r7 = r12.equals(r7)
            if (r7 != 0) goto L_0x03c6
            java.lang.String r7 = "com.oplus.feature.video.hyper.lapse.ultra.wide.support"
            boolean r7 = com.oppo.camera.aps.config.CameraConfig.getConfigBooleanValue(r7)
            if (r7 == 0) goto L_0x03c6
            android.content.SharedPreferences r7 = r0.u
            java.lang.String r11 = "key_hyper_lapse_zoom_ultra_wide_open"
            r12 = 1
            boolean r7 = r7.getBoolean(r11, r12)
            if (r7 != 0) goto L_0x03eb
        L_0x03c6:
            r7 = 0
            return r7
        L_0x03c8:
            r7 = 0
            java.lang.String r11 = "movie"
            boolean r11 = r11.equals(r1)
            if (r11 == 0) goto L_0x03ec
            android.content.SharedPreferences r11 = r0.u
            java.lang.String r12 = "pref_switch_camera_bar_key"
            java.lang.String r11 = r11.getString(r12, r15)
            java.lang.String r12 = "camera_ultra_wide"
            boolean r11 = r11.equals(r12)
            if (r11 != 0) goto L_0x03ec
            return r7
        L_0x03e2:
            r4 = r20
            if (r3 != 0) goto L_0x03ec
            if (r6 != 0) goto L_0x03ec
            return r7
        L_0x03e9:
            r4 = r20
        L_0x03eb:
            r7 = 0
        L_0x03ec:
            com.oppo.camera.entry.b$a r11 = com.oppo.camera.entry.b.a.front_wide
            if (r2 != r11) goto L_0x0416
            boolean r11 = r8.equals(r1)
            if (r11 == 0) goto L_0x03f9
            if (r3 != 0) goto L_0x0416
            return r7
        L_0x03f9:
            boolean r11 = r10.equals(r1)
            if (r11 != 0) goto L_0x040f
            boolean r11 = r9.equals(r1)
            if (r11 == 0) goto L_0x0406
            goto L_0x040f
        L_0x0406:
            boolean r4 = r4.equals(r1)
            if (r4 == 0) goto L_0x0416
            if (r3 != 0) goto L_0x0416
            return r7
        L_0x040f:
            if (r3 != 0) goto L_0x0416
            if (r22 == 0) goto L_0x0415
            if (r17 != 0) goto L_0x0416
        L_0x0415:
            return r7
        L_0x0416:
            com.oppo.camera.entry.b$a r3 = com.oppo.camera.entry.b.a.front_dual
            if (r2 != r3) goto L_0x0432
            java.lang.String r3 = "sticker"
            boolean r3 = r3.equals(r1)
            if (r3 == 0) goto L_0x0423
            return r7
        L_0x0423:
            java.lang.String r3 = "portrait"
            boolean r3 = r3.equals(r1)
            if (r3 == 0) goto L_0x0432
            boolean r3 = com.oppo.camera.f.a.e()
            if (r3 != 0) goto L_0x0432
            return r7
        L_0x0432:
            com.oppo.camera.entry.b$a r3 = com.oppo.camera.entry.b.a.back_main
            if (r3 != r2) goto L_0x044e
            boolean r3 = r8.equals(r1)
            if (r3 == 0) goto L_0x043f
            if (r5 == 0) goto L_0x044e
            return r7
        L_0x043f:
            boolean r3 = r10.equals(r1)
            if (r3 == 0) goto L_0x044e
            boolean r3 = r9.equals(r1)
            if (r3 == 0) goto L_0x044e
            if (r6 == 0) goto L_0x044e
            return r7
        L_0x044e:
            com.oppo.camera.entry.b$a r3 = com.oppo.camera.entry.b.a.back_dual
            if (r3 != r2) goto L_0x045d
            java.lang.String r3 = "portrait"
            boolean r3 = r3.equals(r1)
            if (r3 == 0) goto L_0x045d
            if (r21 == 0) goto L_0x045d
            return r7
        L_0x045d:
            com.oppo.camera.entry.b$a r3 = com.oppo.camera.entry.b.a.back_second_dual
            if (r3 != r2) goto L_0x046c
            java.lang.String r3 = "portrait"
            boolean r3 = r3.equals(r1)
            if (r3 == 0) goto L_0x046c
            if (r21 != 0) goto L_0x046c
            return r7
        L_0x046c:
            boolean r1 = r23.a((java.lang.String) r24, (com.oppo.camera.entry.b.a) r25)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.entry.b.b(java.lang.String, com.oppo.camera.entry.b$a):boolean");
    }

    public int a(String str, int i2) {
        int A;
        if (i2 == 1) {
            if (b(str, a.front_dual)) {
                return com.oppo.camera.f.a.n();
            }
            if (b(str, a.front_wide)) {
                return com.oppo.camera.f.a.k();
            }
            return com.oppo.camera.f.a.i();
        } else if ((b(str, a.back_mono) || b(str, a.back_streamer_main)) && -1 != (A = A())) {
            return A;
        } else {
            if (b(str, a.back_dual)) {
                return com.oppo.camera.f.a.l();
            }
            if (b(str, a.back_second_dual)) {
                return com.oppo.camera.f.a.m();
            }
            if (b(str, a.back_tele)) {
                return com.oppo.camera.f.a.o();
            }
            if (b(str, a.back_macro)) {
                if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_MACROLENS_EQUAL_ULTRAWIDELENS)) {
                    return com.oppo.camera.f.a.j();
                }
                return com.oppo.camera.f.a.r();
            } else if (b(str, a.back_wide) && y() == 1) {
                return com.oppo.camera.f.a.j();
            } else {
                if (b(str, a.back_sat) && this.f == 1) {
                    return com.oppo.camera.f.a.p();
                }
                if (!b(str, a.back_microscope) || this.f != 1) {
                    return com.oppo.camera.f.a.h();
                }
                return com.oppo.camera.f.a.q();
            }
        }
    }

    public String e() {
        String str = this.v;
        if (str != null) {
            return str;
        }
        if (this.f == 3) {
            return ApsConstant.REC_MODE_COMMON;
        }
        if (!d() || b()) {
            return this.u.getString("pref_camera_mode_key", ApsConstant.CAPTURE_MODE_COMMON);
        }
        return ApsConstant.CAPTURE_MODE_COMMON;
    }

    public boolean f() {
        return k() && this.w.contains("beauty");
    }

    public void g() {
        this.v = null;
        this.w.clear();
        this.r = false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0051 A[Catch:{ Exception -> 0x005b }] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0053 A[Catch:{ Exception -> 0x005b }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int h() {
        /*
            r5 = this;
            android.content.SharedPreferences r0 = r5.u
            r1 = 0
            java.lang.String r2 = java.lang.String.valueOf(r1)
            java.lang.String r3 = "pref_camera_id_key"
            java.lang.String r0 = r0.getString(r3, r2)
            int r0 = java.lang.Integer.parseInt(r0)
            boolean r2 = r5.d()
            if (r2 == 0) goto L_0x001e
            boolean r2 = r5.b()
            if (r2 != 0) goto L_0x001e
            r0 = r1
        L_0x001e:
            android.app.Activity r2 = r5.i     // Catch:{ Exception -> 0x005b }
            android.content.Intent r2 = r2.getIntent()     // Catch:{ Exception -> 0x005b }
            java.lang.String r3 = "android.intent.extras.CAMERA_FACING"
            int r0 = r2.getIntExtra(r3, r0)     // Catch:{ Exception -> 0x005b }
            boolean r2 = r5.o     // Catch:{ Exception -> 0x005b }
            r3 = 1
            if (r2 == 0) goto L_0x005f
            android.app.Activity r2 = r5.i     // Catch:{ Exception -> 0x005b }
            android.content.Intent r2 = r2.getIntent()     // Catch:{ Exception -> 0x005b }
            java.lang.String r4 = "android.intent.extra.USE_FRONT_CAMERA"
            boolean r2 = r2.getBooleanExtra(r4, r1)     // Catch:{ Exception -> 0x005b }
            if (r2 != 0) goto L_0x004e
            android.app.Activity r2 = r5.i     // Catch:{ Exception -> 0x005b }
            android.content.Intent r2 = r2.getIntent()     // Catch:{ Exception -> 0x005b }
            java.lang.String r4 = "com.google.assistant.extra.USE_FRONT_CAMERA"
            boolean r2 = r2.getBooleanExtra(r4, r1)     // Catch:{ Exception -> 0x005b }
            if (r2 == 0) goto L_0x004c
            goto L_0x004e
        L_0x004c:
            r2 = r1
            goto L_0x004f
        L_0x004e:
            r2 = r3
        L_0x004f:
            if (r2 == 0) goto L_0x0053
            r0 = r3
            goto L_0x005f
        L_0x0053:
            boolean r2 = r5.G()     // Catch:{ Exception -> 0x005b }
            if (r2 == 0) goto L_0x005f
            r0 = r1
            goto L_0x005f
        L_0x005b:
            r1 = move-exception
            r1.printStackTrace()
        L_0x005f:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "getIntentLegacyId, mCameraEntryType: "
            r1.append(r2)
            int r2 = r5.f
            r1.append(r2)
            java.lang.String r2 = ", cameraId: "
            r1.append(r2)
            r1.append(r0)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "CameraEntry"
            com.oppo.camera.e.a(r2, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.entry.b.h():int");
    }

    private boolean G() {
        Bundle extras = this.i.getIntent().getExtras();
        if (extras == null) {
            return false;
        }
        if (extras.containsKey("com.oppo.camera.extra.IS_VOICE_INTERACTION_ROOT") || extras.containsKey("isVoiceQuery")) {
            return true;
        }
        return false;
    }

    private boolean H() {
        return 1 == y();
    }

    public static long i() {
        return e.longValue();
    }

    public void j() {
        long j2 = this.u.getLong("pref_camera_exit_time_stamp_key", 0);
        long currentTimeMillis = System.currentTimeMillis();
        this.k = currentTimeMillis - j2;
        e = Long.valueOf(currentTimeMillis);
        if (H()) {
            if (this.s) {
                this.s = false;
                e.a("CameraEntry", "updateOverrideCameraModeStatus, currentTime: " + currentTimeMillis + ", timeStamp: " + j2 + ", mCameraEnterTimeGap: " + this.k);
                if (0 < j2) {
                    long j3 = this.k;
                    if (0 < j3 && 300000 < j3) {
                        this.r = true;
                        return;
                    }
                }
                this.r = false;
                return;
            }
            this.r = false;
        } else if (k()) {
            if (this.s) {
                this.s = false;
            }
        } else if (m() && this.s) {
            this.s = false;
            this.r = false;
        }
    }

    public boolean k() {
        return this.v != null || !this.w.isEmpty();
    }

    private void a(Intent intent, Bundle bundle) {
        int i2;
        boolean z;
        boolean z2;
        boolean z3;
        String bundle2 = intent.getExtras() != null ? intent.getExtras().toString() : null;
        if ("android.intent.action.MAIN".equals(this.j)) {
            return;
        }
        if (!"com.oppo.camera.action.SHORTCUT_TYPE_MENU".equals(this.j) || bundle == null) {
            this.w.clear();
            E();
            e.a("CameraEntry", "parseIntentExtraInfo, mAction: " + this.j + ", extras: " + bundle2);
            try {
                i2 = intent.getIntExtra("mode", -1);
            } catch (Exception e2) {
                e2.printStackTrace();
                i2 = -1;
            }
            if ("com.heytap.lab".equals(this.h) && -1 == i2) {
                i2 = Integer.parseInt(intent.getStringExtra("mode"));
            }
            if (i2 != -1) {
                this.v = c.a(i2);
                if (!a(this.v)) {
                    intent.putExtra("android.intent.extras.CAMERA_FACING", 0);
                    this.w.add(DcsMsgData.REAR);
                }
            }
            try {
                z = intent.getBooleanExtra(DcsMsgData.REAR, false);
            } catch (Exception e3) {
                e3.printStackTrace();
                z = false;
            }
            if (z) {
                intent.putExtra("android.intent.extras.CAMERA_FACING", 0);
                this.w.add(DcsMsgData.REAR);
                if (this.v == null && !"com.heytap.speechassist".equals(this.h)) {
                    this.v = c.a(0);
                }
            }
            try {
                z2 = intent.getBooleanExtra(DcsMsgData.FRONT, false);
            } catch (Exception e4) {
                e4.printStackTrace();
                z2 = false;
            }
            if (z2) {
                intent.putExtra("android.intent.extras.CAMERA_FACING", 1);
                this.w.add(DcsMsgData.FRONT);
                if (this.v == null) {
                    this.v = c.a(0);
                }
            }
            try {
                z3 = intent.getBooleanExtra("beauty", false);
            } catch (Exception e5) {
                e5.printStackTrace();
                z3 = false;
            }
            if (z3) {
                this.w.add("beauty");
            }
            if (intent.getBooleanExtra("com.oppo.camera.extra.IS_VOICE_INTERACTION_ROOT", false) && "android.media.action.STILL_IMAGE_CAMERA".equals(this.j) && !intent.getBooleanExtra("com.google.assistant.extra.CAMERA_OPEN_ONLY", false) && (intent.getFlags() & 1048576) == 0) {
                this.p = true;
                e.a("CameraEntry", "parseIntentExtraInfo, set mbRequstVoiceCapture true");
            }
            if (this.p) {
                int intExtra = intent.getIntExtra("com.google.assistant.extra.TIMER_DURATION_SECONDS", 3);
                e.a("CameraEntry", "parseIntentExtraInfo, delayDuration: " + intExtra);
                if (intExtra > 0 && intExtra <= 10) {
                    this.q = intExtra;
                } else if (intExtra > 10) {
                    this.q = 10;
                }
            }
            com.oppo.camera.util.a.a(intent);
        }
    }

    public String l() {
        return this.h;
    }

    public boolean m() {
        return "android.media.action.STILL_IMAGE_CAMERA_SECURE".equals(this.j) || this.n;
    }

    public boolean n() {
        return this.p;
    }

    public void o() {
        this.p = false;
    }

    public int p() {
        return this.q;
    }

    public boolean q() {
        return this.m && !this.n;
    }

    public void r() {
        KeyguardManager keyguardManager = (KeyguardManager) this.i.getSystemService("keyguard");
        if (keyguardManager != null) {
            keyguardManager.requestDismissKeyguard(this.i, (KeyguardManager.KeyguardDismissCallback) null);
        }
    }

    public boolean s() {
        KeyguardManager keyguardManager = (KeyguardManager) this.i.getSystemService("keyguard");
        if (keyguardManager != null) {
            return keyguardManager.isKeyguardLocked();
        }
        return false;
    }

    public void t() {
        this.v = null;
        this.w.clear();
    }

    public void u() {
        if (m()) {
            this.i.setShowWhenLocked(true);
        } else if (!s()) {
            this.i.setShowWhenLocked(false);
        }
        this.l = false;
    }

    public void b(boolean z) {
        if (z) {
            this.i.setShowWhenLocked(false);
        }
        this.l = true;
    }

    public void v() {
        this.i = null;
    }

    public boolean w() {
        return this.l;
    }

    public static boolean a(String str) {
        return !ApsConstant.REC_MODE_SLOW_VIDEO.equals(str) && !"movie".equals(str) && !ApsConstant.CAPTURE_MODE_NIGHT.equals(str) && !ApsConstant.CAPTURE_MODE_PROFESSIONAL.equals(str) && !ApsConstant.CAPTURE_MODE_MACRO.equals(str) && !ApsConstant.CAPTURE_MODE_HIGH_DEFINITION.equals(str);
    }

    public static boolean b(String str) {
        return ApsConstant.CAPTURE_MODE_STICKER.equals(str) || ApsConstant.CAPTURE_MODE_COMMON.equals(str) || "portrait".equals(str) || ApsConstant.REC_MODE_COMMON.equals(str);
    }

    private void b(Intent intent, Bundle bundle) {
        if (intent == null) {
            e.e("CameraEntry", "parseIntent, intent is null");
            return;
        }
        this.j = intent.getAction();
        b(intent);
        String str = this.j;
        if (str != null) {
            if ("android.media.action.STILL_IMAGE_CAMERA_SECURE".equals(str)) {
                this.f = 1;
            } else if ("android.media.action.IMAGE_CAPTURE".equals(this.j) || "android.media.action.IMAGE_CAPTURE_SECURE".equals(this.j)) {
                this.f = 2;
                this.v = ApsConstant.CAPTURE_MODE_COMMON;
            } else if ("android.media.action.VIDEO_CAPTURE".equals(this.j) || "com.oppo.action.VIDEO_CAPTURE".equals(this.j)) {
                this.f = 3;
                this.v = ApsConstant.REC_MODE_COMMON;
            } else if ("com.oppo.action.VIDEO_CAMERA".equals(this.j)) {
                this.f = 1;
                this.v = ApsConstant.REC_MODE_COMMON;
            } else if ("android.media.action.STILL_IMAGE_CAMERA".equals(this.j)) {
                this.o = true;
                this.f = 1;
                if (G()) {
                    this.v = ApsConstant.CAPTURE_MODE_COMMON;
                }
            } else {
                this.f = 1;
            }
        }
        e.a("CameraEntry", "parseIntent, mCameraEntryType: " + this.f + ", mCallPkg: " + this.h + ", mAction: " + this.j);
        a(intent, bundle);
        if (m()) {
            this.i.setShowWhenLocked(true);
        }
        if (q()) {
            r();
        }
    }

    public void a(Intent intent, Activity activity, SharedPreferences sharedPreferences, Bundle bundle) {
        this.i = activity;
        this.u = sharedPreferences;
        b(intent, bundle);
        j();
        e.a("CameraEntry", "onCreate, mCameraEntryType: " + this.f + ", mCallPkg: " + this.h + ", mAction: " + this.j);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x002b  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x002e  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void b(android.content.Intent r5) {
        /*
            r4 = this;
            java.lang.String r0 = ""
            r4.h = r0
            r0 = 0
            android.app.Activity r1 = r4.i     // Catch:{ Exception -> 0x000c }
            android.net.Uri r1 = r1.getReferrer()     // Catch:{ Exception -> 0x000c }
            goto L_0x0011
        L_0x000c:
            r1 = move-exception
            r1.printStackTrace()
            r1 = r0
        L_0x0011:
            java.lang.String r2 = "extra_key_caller_package_name"
            java.lang.String r2 = r5.getStringExtra(r2)     // Catch:{ Exception -> 0x0020 }
            java.lang.String r3 = "android_camera_launch_type"
            java.lang.String r0 = r5.getStringExtra(r3)     // Catch:{ Exception -> 0x001e }
            goto L_0x0025
        L_0x001e:
            r5 = move-exception
            goto L_0x0022
        L_0x0020:
            r5 = move-exception
            r2 = r0
        L_0x0022:
            r5.printStackTrace()
        L_0x0025:
            boolean r5 = android.text.TextUtils.isEmpty(r2)
            if (r5 != 0) goto L_0x002e
            r4.h = r2
            goto L_0x0036
        L_0x002e:
            if (r1 == 0) goto L_0x0036
            java.lang.String r5 = r1.getHost()
            r4.h = r5
        L_0x0036:
            boolean r5 = android.text.TextUtils.isEmpty(r0)
            if (r5 != 0) goto L_0x0053
            java.lang.String r5 = "gimbal_launch_from_framework"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x0048
            r5 = 4
            r4.g = r5
            goto L_0x0053
        L_0x0048:
            java.lang.String r5 = "quick_launch_from_framework"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x0053
            r5 = 5
            r4.g = r5
        L_0x0053:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.entry.b.b(android.content.Intent):void");
    }

    public boolean a(Intent intent) {
        e.a("CameraEntry", "onNewIntent");
        if (this.i.getCallingActivity() != null) {
            intent.setFlags(469762048);
            this.i.finish();
            this.i.overridePendingTransition(R.anim.oppo_close_slide_enter, R.anim.oppo_close_slide_exit);
            this.i.startActivity(intent);
            return false;
        }
        this.i.setIntent(intent);
        b(intent, (Bundle) null);
        return true;
    }

    public String x() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.v);
        String str = "beauty";
        if (!this.w.contains(str)) {
            str = "";
        }
        sb.append(str);
        return sb.toString();
    }

    public int y() {
        return this.f;
    }

    public long z() {
        return this.k;
    }

    public int A() {
        int i2 = this.u.getInt("key_portrait_new_style_index", g.f4385a);
        if (i2 == g.b()) {
            return g.l();
        }
        if (i2 == g.c()) {
            return g.m();
        }
        if (i2 == g.d()) {
            return com.oppo.camera.f.a.h();
        }
        return -1;
    }

    public boolean B() {
        return -1 != this.g;
    }

    public int C() {
        return B() ? this.g : this.f;
    }

    public boolean D() {
        return 5 == this.g;
    }

    public void E() {
        KeyguardManager keyguardManager;
        if (B() && (keyguardManager = (KeyguardManager) this.i.getSystemService("keyguard")) != null) {
            if (keyguardManager.isKeyguardLocked() && keyguardManager.isKeyguardSecure()) {
                this.n = true;
            }
            if (keyguardManager.isKeyguardLocked() || keyguardManager.isKeyguardSecure()) {
                this.m = true;
            }
        }
    }

    public boolean F() {
        return this.m || m();
    }

    public static String b(String str, int i2) {
        return (!a(i2) || -1 != d(str)) ? str : str.concat("_from_other_app");
    }

    public static String c(String str) {
        int d = d(str);
        return d > 0 ? str.substring(0, d) : str;
    }

    private static int d(String str) {
        if (str == null) {
            return -2;
        }
        return str.indexOf("_from_other_app");
    }
}
