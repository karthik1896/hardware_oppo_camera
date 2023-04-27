package com.oppo.camera.e;

import android.app.Activity;
import android.util.Size;
import com.oppo.camera.R;
import com.oppo.camera.ab;
import com.oppo.camera.aps.adapter.ApsCaptureResult;
import com.oppo.camera.aps.adapter.ImageCategory;
import com.oppo.camera.aps.config.AlgoSwitchConfig;
import com.oppo.camera.aps.config.CameraConfig;
import com.oppo.camera.aps.config.CameraFunction;
import com.oppo.camera.aps.config.ConfigDataBase;
import com.oppo.camera.aps.constant.ApsConstant;
import com.oppo.camera.aps.constant.ParameterKeys;
import com.oppo.camera.f.a;
import com.oppo.camera.f.f;
import com.oppo.camera.f.j;
import com.oppo.camera.statistics.model.CaptureMsgData;
import com.oppo.camera.statistics.model.DcsMsgData;
import com.oppo.camera.statistics.model.MenuClickMsgData;
import com.oppo.camera.ui.e;
import com.oppo.camera.ui.inverse.c;
import com.oppo.camera.ui.preview.a.g;
import com.oppo.camera.ui.preview.a.n;
import com.oppo.camera.util.Util;
import java.util.ArrayList;
import java.util.List;

/* compiled from: UltraHighResolutionMode */
public class t extends e {
    public String a() {
        return ApsConstant.CAPTURE_MODE_ULTRA_HIGH_RESOLUTION;
    }

    public boolean aa() {
        return false;
    }

    public boolean af() {
        return true;
    }

    public boolean c(String str) {
        return false;
    }

    public boolean ej() {
        return true;
    }

    public String eq() {
        return null;
    }

    /* access modifiers changed from: protected */
    public boolean fH() {
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean fl() {
        return false;
    }

    public boolean z(String str) {
        return false;
    }

    public t(Activity activity, b bVar, e eVar, n nVar) {
        super(activity, bVar, eVar, nVar);
    }

    public boolean d() {
        return Util.X();
    }

    public boolean f(String str) {
        if ("pref_ai_scene_key".equals(str) || "pref_super_clear_portrait".equals(str) || "pref_camera_video_slogan_key".equals(str) || "pref_slogan_owner_key".equals(str) || "pref_burst_shot_key".equals(str) || "key_high_picture_size".equals(str) || "pref_camera_pi_ai_mode_key".equals(str) || CameraFunction.GOOGLE_LENS.equals(str) || "pref_qr_code_key".equals(str) || "pref_10bits_heic_encode_key".equals(str) || "key_suppport_multi_focus".equals(str)) {
            return false;
        }
        if ("pref_support_switch_camera".equals(str)) {
            return Util.X();
        }
        if ("pref_switch_camera_key".equals(str)) {
            if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_ULTRA_HIGH_RESOLUTION_FULL_ZOOM_SUPPORT) || !CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_ULTRA_HIGH_RESOLUTION_SWITCH_CAMERA_SUPPORT)) {
                return false;
            }
            return true;
        } else if ("pref_camera_slogan_key".equals(str)) {
            return AlgoSwitchConfig.getSupportCaptureAlgo(a(), this.n, ParameterKeys.ALGO_NAME_WATERMARK);
        } else {
            if (CameraFunction.SAT_CAMERA.equalsIgnoreCase(str)) {
                if (this.t || !a.f() || this.X == null || !this.X.j() || !CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_ULTRA_HIGH_RESOLUTION_FULL_ZOOM_SUPPORT)) {
                    return false;
                }
                return true;
            } else if ("pref_filter_menu".equals(str)) {
                return AlgoSwitchConfig.getSupportCaptureAlgo(a(), this.n, ParameterKeys.ALGO_NAME_FILTER);
            } else {
                if ("pref_filter_process_key".equals(str)) {
                    return f("pref_filter_menu");
                }
                if (CameraFunction.AIS_SNAPSHOT.equals(str)) {
                    return false;
                }
                return super.f(str);
            }
        }
    }

    public boolean d(String str) {
        if ("pref_camera_timer_shutter_key".equals(str)) {
            return f(str);
        }
        if ("pref_switch_camera_key".equals(str)) {
            return f(str);
        }
        return super.d(str);
    }

    public String cg() {
        if (f("pref_filter_menu")) {
            return "key_ultra_high_resolution_filter_index";
        }
        return super.cg();
    }

    public List<String> a(String str, int i) {
        if (!"pref_camera_flashmode_key".equals(str)) {
            return super.a(str, i);
        }
        List<String> b2 = b("pref_camera_flashmode_key", this.n);
        ArrayList arrayList = new ArrayList();
        if (b2 != null) {
            for (String next : b2) {
                if (!"on".equals(next) && !MenuClickMsgData.VALUE_PROFESSION_AUTO.equals(next)) {
                    arrayList.add(next);
                }
            }
        }
        if (arrayList.size() > 0) {
            return arrayList;
        }
        return null;
    }

    public void a(ApsCaptureResult apsCaptureResult, ImageCategory.MetaItemInfo metaItemInfo, String str, float f) {
        super.a(apsCaptureResult, metaItemInfo, str, f);
        boolean f2 = f(CameraFunction.SAT_CAMERA);
        float[] configFloatArrayValue = CameraConfig.getConfigFloatArrayValue(ConfigDataBase.KEY_SAT_MAIN_ZOOM_RANGE);
        if (configFloatArrayValue != null && configFloatArrayValue.length == 2) {
            Size a2 = a(str, this.W.e());
            com.oppo.camera.e.b("UltraHighResolutionMode", "updateUpscaleSize, current camera full input size is:" + a2);
            int width = a2.getWidth() * a2.getHeight();
            int[] iArr = {a2.getWidth() * 2, a2.getHeight() * 2, 0, 0};
            if ((12000000 <= width && Float.compare(f, configFloatArrayValue[0]) == 0) || (f2 && Float.compare(f, configFloatArrayValue[1]) == 0)) {
                iArr[0] = 12032;
                iArr[1] = 9024;
            }
            metaItemInfo.setParameter(ParameterKeys.KEY_OUTPUT_WIDTH, String.valueOf(iArr[0]));
            metaItemInfo.setParameter(ParameterKeys.KEY_OUTPUT_HEIGHT, String.valueOf(iArr[1]));
            metaItemInfo.setParameter(ParameterKeys.KEY_OUTPUT_SIZE, iArr);
        }
    }

    public void n(int i) {
        super.n(i);
        H(i);
    }

    /* access modifiers changed from: protected */
    public void s() {
        if ("on".equals(bu())) {
            this.aa.edit().putString("pref_camera_flashmode_key", "off").apply();
            m("off");
        }
        super.s();
    }

    private void H(int i) {
        MenuClickMsgData menuClickMsgData = new MenuClickMsgData(this.Z);
        menuClickMsgData.buildEvent(true);
        menuClickMsgData.mFuncKeyId = 4;
        menuClickMsgData.mItemValue = g.a(i, this.n);
        menuClickMsgData.mCameraEnterType = String.valueOf(1);
        menuClickMsgData.mCaptureMode = a();
        menuClickMsgData.mCameraId = this.X.aq();
        menuClickMsgData.mOrientation = this.k;
        menuClickMsgData.report();
    }

    public void g(boolean z) {
        c.INS.setPositionRatio(this.Z, 0.5f, z);
    }

    public DcsMsgData b(DcsMsgData dcsMsgData) {
        CaptureMsgData captureMsgData = dcsMsgData instanceof CaptureMsgData ? (CaptureMsgData) dcsMsgData : null;
        if (captureMsgData == null) {
            return null;
        }
        if (f("pref_filter_process_key")) {
            captureMsgData.mFilterType = g.a(cf(), this.n);
        }
        super.b(dcsMsgData);
        return dcsMsgData;
    }

    public Size d(j jVar) {
        return Util.c(jVar.a(256), 1.3333333333333333d);
    }

    /* access modifiers changed from: protected */
    public Size j(String str) {
        return Util.c(CameraConfig.getConfigSizeListValue(str), 1.3333333333333333d);
    }

    public boolean br() {
        return Util.p();
    }

    public ab dl() {
        if (ex()) {
            return super.dl();
        }
        ab abVar = new ab();
        abVar.a(g());
        abVar.b(false);
        abVar.o(true);
        abVar.f(f("pref_switch_camera_key"));
        return abVar;
    }

    /* access modifiers changed from: protected */
    public int eD() {
        if (this.aa == null) {
            return -1;
        }
        String string = this.aa.getString("pref_switch_camera_key", "camera_main");
        if ("camera_main".equals(string)) {
            return Util.d((int) R.string.camera_switch_main);
        }
        if ("camera_ultra_wide".equals(string)) {
            if (Float.compare(this.W.e().n(), 0.0f) == 0) {
                return Util.d((int) R.string.camera_switch_ultra_wide);
            }
            return Util.d((int) R.string.camera_switch_ultra_wide_micro_lens);
        } else if ("camera_tele".equals(string)) {
            return R.string.camera_switch_tele;
        } else {
            return -1;
        }
    }

    public void f(boolean z) {
        super.f(z);
        if (this.W != null) {
            this.W.n(true);
            this.W.a((f.c) null);
        }
    }

    /* access modifiers changed from: protected */
    public String ei() {
        return this.Z.getString(R.string.camera_picture_size_standard);
    }
}
