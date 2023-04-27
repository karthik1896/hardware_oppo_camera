package com.oppo.camera.ui.menu.b;

import com.oppo.camera.R;
import com.oppo.camera.aps.config.CameraConfig;
import com.oppo.camera.aps.config.ConfigDataBase;
import com.oppo.camera.aps.constant.ApsConstant;
import com.oppo.camera.e;
import com.oppo.camera.util.Util;
import java.util.ArrayList;
import java.util.List;

/* compiled from: HeadlineHelper */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private List<Integer> f4084a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private List<Integer> f4085b = new ArrayList();
    private int c = 1;
    private boolean d = true;
    private boolean e = true;

    public static String a(int i) {
        switch (i) {
            case R.string.camera_mode_double_exposure:
                return ApsConstant.REC_MODE_DOUBLE_EXPOSURE;
            case R.string.camera_mode_fast_video:
                return ApsConstant.REC_MODE_FAST_VIDEO;
            case R.string.camera_mode_high_definition_108mp:
            case R.string.camera_mode_high_definition_48mp_realme:
            case R.string.camera_mode_high_definition_64mp_realme:
                return ApsConstant.CAPTURE_MODE_HIGH_DEFINITION;
            case R.string.camera_mode_id_photo:
                return ApsConstant.CAPTURE_MODE_ID_PHOTO;
            case R.string.camera_mode_macro:
            case R.string.camera_mode_super_macro:
                return ApsConstant.CAPTURE_MODE_MACRO;
            case R.string.camera_mode_more:
                return "more";
            case R.string.camera_mode_movie:
                return "movie";
            case R.string.camera_mode_night:
                return ApsConstant.CAPTURE_MODE_NIGHT;
            case R.string.camera_mode_panorama:
                return ApsConstant.CAPTURE_MODE_PANORAMA;
            case R.string.camera_mode_portrait:
                return "portrait";
            case R.string.camera_mode_professional:
                return ApsConstant.CAPTURE_MODE_PROFESSIONAL;
            case R.string.camera_mode_slow_video:
                return ApsConstant.REC_MODE_SLOW_VIDEO;
            case R.string.camera_mode_sticker:
                return ApsConstant.CAPTURE_MODE_STICKER;
            case R.string.camera_mode_video:
                return ApsConstant.REC_MODE_COMMON;
            default:
                return ApsConstant.CAPTURE_MODE_COMMON;
        }
    }

    public void a(int i, boolean z, boolean z2) {
        this.c = i;
        this.d = z;
        this.e = z2;
    }

    public void a() {
        e.a("HeadlineHelper", "updateMode, mCameraEntryType: " + this.c);
        this.f4084a.clear();
        this.f4085b.clear();
        int i = this.c;
        Integer valueOf = Integer.valueOf(R.string.camera_mode_video);
        if (i == 3) {
            this.f4085b.add(valueOf);
            this.f4084a.add(valueOf);
        } else if (i == 2) {
            this.f4085b.add(Integer.valueOf(R.string.camera_mode_common));
            this.f4084a.add(Integer.valueOf(R.string.camera_mode_common));
            if (this.d) {
                this.f4085b.add(Integer.valueOf(R.string.camera_mode_portrait));
                this.f4084a.add(Integer.valueOf(R.string.camera_mode_portrait));
            }
        } else if (i == 1) {
            if (this.e) {
                this.f4085b.add(Integer.valueOf(R.string.camera_mode_night));
            }
            if (Util.W()) {
                this.f4084a.add(Integer.valueOf(R.string.camera_mode_night));
            }
            this.f4085b.add(valueOf);
            this.f4084a.add(valueOf);
            this.f4085b.add(Integer.valueOf(R.string.camera_mode_common));
            this.f4084a.add(Integer.valueOf(R.string.camera_mode_common));
            if (this.d) {
                this.f4085b.add(Integer.valueOf(R.string.camera_mode_portrait));
                this.f4084a.add(Integer.valueOf(R.string.camera_mode_portrait));
            }
            if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_HIGH_DEFINITION)) {
                this.f4085b.add(Integer.valueOf(d()));
            }
            this.f4085b.add(Integer.valueOf(R.string.camera_mode_more));
            this.f4084a.add(Integer.valueOf(R.string.camera_mode_more));
        }
        e.a("HeadlineHelper", "updateMode, mRearCameraModeTextIdList size: " + this.f4085b.size() + ", mFrontCameraModeTextIdList size: " + this.f4084a.size());
    }

    public List<Integer> b() {
        if (this.f4084a.size() <= 0) {
            a();
        }
        return this.f4084a;
    }

    public List<Integer> c() {
        if (this.f4085b.size() <= 0) {
            a();
        }
        return this.f4085b;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int a(java.lang.String r1) {
        /*
            int r0 = r1.hashCode()
            switch(r0) {
                case -1933413040: goto L_0x0102;
                case -1890252483: goto L_0x00f7;
                case -1482065415: goto L_0x00ec;
                case -1060049483: goto L_0x00e1;
                case -892483559: goto L_0x00d6;
                case -735775298: goto L_0x00cb;
                case -333683288: goto L_0x00c0;
                case -332860600: goto L_0x00b5;
                case -35510913: goto L_0x00ab;
                case 3357525: goto L_0x009f;
                case 103652300: goto L_0x0094;
                case 104087344: goto L_0x0089;
                case 104817688: goto L_0x007d;
                case 325866571: goto L_0x0071;
                case 729267099: goto L_0x0066;
                case 764302074: goto L_0x005b;
                case 778729370: goto L_0x004f;
                case 875077159: goto L_0x0044;
                case 1069983349: goto L_0x0039;
                case 1373542928: goto L_0x002d;
                case 1638611415: goto L_0x0021;
                case 1704250517: goto L_0x0015;
                case 2138587465: goto L_0x0009;
                default: goto L_0x0007;
            }
        L_0x0007:
            goto L_0x010c
        L_0x0009:
            java.lang.String r0 = "starVideo"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x010c
            r1 = 22
            goto L_0x010d
        L_0x0015:
            java.lang.String r0 = "highDefinition"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x010c
            r1 = 15
            goto L_0x010d
        L_0x0021:
            java.lang.String r0 = "idPhoto"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x010c
            r1 = 14
            goto L_0x010d
        L_0x002d:
            java.lang.String r0 = "microscope"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x010c
            r1 = 17
            goto L_0x010d
        L_0x0039:
            java.lang.String r0 = "panorama"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x010c
            r1 = 4
            goto L_0x010d
        L_0x0044:
            java.lang.String r0 = "professional"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x010c
            r1 = 6
            goto L_0x010d
        L_0x004f:
            java.lang.String r0 = "soloopTemplate"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x010c
            r1 = 19
            goto L_0x010d
        L_0x005b:
            java.lang.String r0 = "slowVideo"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x010c
            r1 = 1
            goto L_0x010d
        L_0x0066:
            java.lang.String r0 = "portrait"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x010c
            r1 = 5
            goto L_0x010d
        L_0x0071:
            java.lang.String r0 = "microscopeVideo"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x010c
            r1 = 18
            goto L_0x010d
        L_0x007d:
            java.lang.String r0 = "night"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x010c
            r1 = 9
            goto L_0x010d
        L_0x0089:
            java.lang.String r0 = "movie"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x010c
            r1 = 2
            goto L_0x010d
        L_0x0094:
            java.lang.String r0 = "macro"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x010c
            r1 = 7
            goto L_0x010d
        L_0x009f:
            java.lang.String r0 = "more"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x010c
            r1 = 10
            goto L_0x010d
        L_0x00ab:
            java.lang.String r0 = "fastVideo"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x010c
            r1 = 0
            goto L_0x010d
        L_0x00b5:
            java.lang.String r0 = "superText"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x010c
            r1 = 11
            goto L_0x010d
        L_0x00c0:
            java.lang.String r0 = "ultraHD"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x010c
            r1 = 13
            goto L_0x010d
        L_0x00cb:
            java.lang.String r0 = "multiCamera"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x010c
            r1 = 16
            goto L_0x010d
        L_0x00d6:
            java.lang.String r0 = "starry"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x010c
            r1 = 21
            goto L_0x010d
        L_0x00e1:
            java.lang.String r0 = "double_exposure"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x010c
            r1 = 20
            goto L_0x010d
        L_0x00ec:
            java.lang.String r0 = "groupshot"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x010c
            r1 = 12
            goto L_0x010d
        L_0x00f7:
            java.lang.String r0 = "sticker"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x010c
            r1 = 8
            goto L_0x010d
        L_0x0102:
            java.lang.String r0 = "commonVideo"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x010c
            r1 = 3
            goto L_0x010d
        L_0x010c:
            r1 = -1
        L_0x010d:
            switch(r1) {
                case 0: goto L_0x0172;
                case 1: goto L_0x016e;
                case 2: goto L_0x016a;
                case 3: goto L_0x0166;
                case 4: goto L_0x0162;
                case 5: goto L_0x015e;
                case 6: goto L_0x015a;
                case 7: goto L_0x014c;
                case 8: goto L_0x0148;
                case 9: goto L_0x0144;
                case 10: goto L_0x0140;
                case 11: goto L_0x013c;
                case 12: goto L_0x0138;
                case 13: goto L_0x0134;
                case 14: goto L_0x0130;
                case 15: goto L_0x012b;
                case 16: goto L_0x0127;
                case 17: goto L_0x0123;
                case 18: goto L_0x0123;
                case 19: goto L_0x011f;
                case 20: goto L_0x011a;
                case 21: goto L_0x0115;
                case 22: goto L_0x0115;
                default: goto L_0x0110;
            }
        L_0x0110:
            r1 = 2131755370(0x7f10016a, float:1.9141617E38)
            goto L_0x0175
        L_0x0115:
            r1 = 2131755397(0x7f100185, float:1.9141672E38)
            goto L_0x0175
        L_0x011a:
            r1 = 2131755371(0x7f10016b, float:1.914162E38)
            goto L_0x0175
        L_0x011f:
            r1 = 2131755389(0x7f10017d, float:1.9141656E38)
            goto L_0x0175
        L_0x0123:
            r1 = 2131755379(0x7f100173, float:1.9141636E38)
            goto L_0x0175
        L_0x0127:
            r1 = 2131755382(0x7f100176, float:1.9141642E38)
            goto L_0x0175
        L_0x012b:
            int r1 = d()
            goto L_0x0175
        L_0x0130:
            r1 = 2131755377(0x7f100171, float:1.9141632E38)
            goto L_0x0175
        L_0x0134:
            r1 = 2131756138(0x7f10046a, float:1.9143175E38)
            goto L_0x0175
        L_0x0138:
            r1 = 2131755373(0x7f10016d, float:1.9141623E38)
            goto L_0x0175
        L_0x013c:
            r1 = 2131755400(0x7f100188, float:1.9141678E38)
            goto L_0x0175
        L_0x0140:
            r1 = 2131755380(0x7f100174, float:1.9141638E38)
            goto L_0x0175
        L_0x0144:
            r1 = 2131755390(0x7f10017e, float:1.9141658E38)
            goto L_0x0175
        L_0x0148:
            r1 = 2131755398(0x7f100186, float:1.9141674E38)
            goto L_0x0175
        L_0x014c:
            boolean r1 = com.oppo.camera.util.Util.R()
            if (r1 == 0) goto L_0x0156
            r1 = 2131755399(0x7f100187, float:1.9141676E38)
            goto L_0x0175
        L_0x0156:
            r1 = 2131755378(0x7f100172, float:1.9141634E38)
            goto L_0x0175
        L_0x015a:
            r1 = 2131755394(0x7f100182, float:1.9141666E38)
            goto L_0x0175
        L_0x015e:
            r1 = 2131755393(0x7f100181, float:1.9141664E38)
            goto L_0x0175
        L_0x0162:
            r1 = 2131755391(0x7f10017f, float:1.914166E38)
            goto L_0x0175
        L_0x0166:
            r1 = 2131755401(0x7f100189, float:1.914168E38)
            goto L_0x0175
        L_0x016a:
            r1 = 2131755381(0x7f100175, float:1.914164E38)
            goto L_0x0175
        L_0x016e:
            r1 = 2131755395(0x7f100183, float:1.9141668E38)
            goto L_0x0175
        L_0x0172:
            r1 = 2131755372(0x7f10016c, float:1.9141621E38)
        L_0x0175:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.ui.menu.b.d.a(java.lang.String):int");
    }

    private static int d() {
        int ak = Util.ak();
        if (48 == ak) {
            return R.string.camera_mode_high_definition_48mp_realme;
        }
        if (64 == ak) {
            return R.string.camera_mode_high_definition_64mp_realme;
        }
        return 108 == ak ? R.string.camera_mode_high_definition_108mp : R.string.camera_mode_high_definition_48mp_realme;
    }
}
