package com.oppo.camera.e;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.util.Size;
import com.oppo.camera.R;
import com.oppo.camera.aps.config.CameraFunction;
import com.oppo.camera.aps.constant.ApsConstant;
import com.oppo.camera.f.j;
import com.oppo.camera.statistics.model.DcsMsgData;
import com.oppo.camera.statistics.model.ReminderMsgData;
import com.oppo.camera.ui.control.c;
import com.oppo.camera.ui.e;
import com.oppo.camera.ui.preview.a.n;
import com.oppo.camera.util.Util;

/* compiled from: IdPhotoMode */
public class k extends e {
    private int aB = 0;
    /* access modifiers changed from: private */
    public int aC = 0;
    private long aD = 0;
    private long aE = 0;
    private boolean aF = false;
    private int aG = 0;
    private Handler aH = null;
    /* access modifiers changed from: private */
    public boolean aI = false;

    public boolean F() {
        return true;
    }

    public String a() {
        return ApsConstant.CAPTURE_MODE_ID_PHOTO;
    }

    public boolean ax() {
        return false;
    }

    public String b() {
        return ApsConstant.CAPTURE_MODE_ID_PHOTO;
    }

    /* access modifiers changed from: protected */
    public String bY() {
        return "pref_idphoto_facebeauty_level_menu";
    }

    public boolean br() {
        return false;
    }

    public int c() {
        return 32769;
    }

    public boolean c(String str) {
        return false;
    }

    public boolean ea() {
        return false;
    }

    public boolean ej() {
        return true;
    }

    public String eq() {
        return null;
    }

    public boolean ex() {
        return false;
    }

    public boolean f() {
        return true;
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

    public k(Activity activity, b bVar, e eVar, n nVar) {
        super(activity, bVar, eVar, nVar);
    }

    /* access modifiers changed from: protected */
    public void s() {
        super.s();
        this.Y.a(R.string.camera_mode_more);
        this.aF = this.aa.getBoolean("key_bottom_guide_type_id_photo", false);
        if (this.aH == null) {
            this.aH = new Handler() {
                public void handleMessage(Message message) {
                    super.handleMessage(message);
                    int i = message.what;
                    if (i == 1) {
                        boolean booleanValue = ((Boolean) message.obj).booleanValue();
                        int i2 = message.arg1;
                        k.this.a(i2, booleanValue, message.arg2);
                        if (!booleanValue) {
                            k.this.H(i2);
                        }
                    } else if (i == 2) {
                        if (!(k.this.Y == null || k.this.aC == 0)) {
                            k.this.Y.b(k.this.aC);
                        }
                        int unused = k.this.aC = 0;
                    } else if (i == 3) {
                        boolean unused2 = k.this.aI = true;
                    }
                }
            };
        }
    }

    /* access modifiers changed from: protected */
    public String[] de() {
        return e.g;
    }

    public boolean d(String str) {
        if ("pref_camera_flashmode_key".equals(str)) {
            return f(str);
        }
        if ("pref_setting_key".equals(str)) {
            return true;
        }
        if ("pref_camera_timer_shutter_key".equals(str)) {
            return false;
        }
        return super.d(str);
    }

    public boolean au() {
        super.au();
        return false;
    }

    public boolean av() {
        return f(CameraFunction.ID_PHOTO);
    }

    public c o() {
        c o = super.o();
        o.b("button_shape_ring_none");
        return o;
    }

    public Size d(j jVar) {
        return Util.c(jVar.a(256), 1.3333333333333333d);
    }

    public Size a(j jVar, double d) {
        return super.a(jVar, 1.3333333333333333d);
    }

    public Size a(j jVar, String str) {
        return super.a(jVar, 1.3333333333333333d);
    }

    public Size e(j jVar) {
        return super.a(jVar, 1.3333333333333333d);
    }

    public boolean f(String str) {
        if ("pref_time_lapse_key".equals(str) || "pref_camera_gesture_shutter_key".equals(str) || "pref_ai_scene_key".equals(str) || "pref_super_clear_portrait".equals(str) || "pref_camera_slogan_key".equals(str) || "pref_camera_video_slogan_key".equals(str) || "pref_slogan_owner_key".equals(str) || "pref_burst_shot_key".equals(str) || "key_high_picture_size".equals(str) || "key_suppport_multi_focus".equals(str) || "pref_support_post_view".equals(str) || "pref_camera_assistant_line_key".equals(str) || "pref_assist_gradienter".equals(str) || "pref_zoom_key".equals(str) || CameraFunction.GOOGLE_LENS.equals(str) || CameraFunction.AIS_SNAPSHOT.equals(str) || "pref_qr_code_key".equals(str) || CameraFunction.RAW_HDR.equals(str) || "support_focus_out_of_range".equals(str)) {
            return false;
        }
        if ("key_support_update_thumbnail_user_picture".equals(str) || "pref_support_switch_camera".equals(str) || "key_support_show_dim_hint".equals(str) || "pref_face_detection_key".equals(str) || CameraFunction.ID_PHOTO.equals(str)) {
            return true;
        }
        if ("pref_camera_flashmode_key".equals(str)) {
            return !this.t;
        }
        return super.f(str);
    }

    public void a(SharedPreferences sharedPreferences, String str) {
        super.a(sharedPreferences, str);
        if ("key_bottom_guide_type_id_photo".equals(str)) {
            this.aF = sharedPreferences.getBoolean("key_bottom_guide_type_id_photo", false);
        }
    }

    /* access modifiers changed from: protected */
    public void p() {
        super.p();
        this.Y.j(false);
    }

    public void am() {
        super.am();
        this.aI = false;
        if (this.aC != 0) {
            fP();
            this.aH.removeMessages(1);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0084  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(com.oppo.camera.aps.adapter.ApsTotalResult r5) {
        /*
            r4 = this;
            super.a((com.oppo.camera.aps.adapter.ApsTotalResult) r5)
            boolean r0 = r4.y
            if (r0 != 0) goto L_0x00ca
            com.oppo.camera.e.b r0 = r4.X
            if (r0 == 0) goto L_0x00ca
            boolean r0 = r4.aF
            if (r0 == 0) goto L_0x00ca
            boolean r0 = r4.aI
            if (r0 == 0) goto L_0x00ca
            android.hardware.camera2.CaptureResult r0 = r5.getTotalResult()
            android.hardware.camera2.CaptureResult$Key<int[]> r1 = com.oppo.camera.f.c.S
            java.lang.Object r0 = com.oppo.camera.f.c.a(r0, r1)
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x0035
            boolean r3 = r0 instanceof int[]
            if (r3 == 0) goto L_0x0035
            int[] r0 = (int[]) r0
            int[] r0 = (int[]) r0
            r0 = r0[r2]
            r4.s = r0
            int r0 = r4.s
            if (r1 != r0) goto L_0x0035
            r0 = 2131755322(0x7f10013a, float:1.914152E38)
            goto L_0x0036
        L_0x0035:
            r0 = r2
        L_0x0036:
            android.hardware.camera2.CaptureResult r5 = r5.getTotalResult()
            android.hardware.camera2.CaptureResult$Key r3 = android.hardware.camera2.CaptureResult.STATISTICS_FACES
            java.lang.Object r5 = r5.get(r3)
            android.hardware.camera2.params.Face[] r5 = (android.hardware.camera2.params.Face[]) r5
            if (r5 == 0) goto L_0x0046
            int r5 = r5.length
            goto L_0x0047
        L_0x0046:
            r5 = r2
        L_0x0047:
            r4.aG = r5
            if (r0 != 0) goto L_0x0058
            int r5 = r4.aG
            if (r5 != 0) goto L_0x0053
            r0 = 2131755323(0x7f10013b, float:1.9141522E38)
            goto L_0x0058
        L_0x0053:
            if (r5 <= r1) goto L_0x0058
            r0 = 2131755320(0x7f100138, float:1.9141516E38)
        L_0x0058:
            com.oppo.camera.ui.e r5 = r4.Y
            java.lang.String r5 = r5.e()
            com.oppo.camera.ui.e r3 = r4.Y
            int r3 = r3.f()
            if (r3 == 0) goto L_0x0084
            if (r0 != 0) goto L_0x0076
            android.os.Handler r5 = r4.aH
            boolean r5 = r5.hasMessages(r1)
            if (r5 == 0) goto L_0x00ca
            android.os.Handler r5 = r4.aH
            r5.removeMessages(r1)
            goto L_0x00ca
        L_0x0076:
            android.os.Handler r5 = r4.aH
            boolean r5 = r5.hasMessages(r1)
            if (r5 != 0) goto L_0x00ca
            r5 = 1000(0x3e8, float:1.401E-42)
            r4.a((int) r0, (boolean) r2, (int) r5, (int) r2)
            goto L_0x00ca
        L_0x0084:
            boolean r3 = android.text.TextUtils.isEmpty(r5)
            if (r3 == 0) goto L_0x009e
            if (r0 != 0) goto L_0x009a
            android.os.Handler r5 = r4.aH
            boolean r5 = r5.hasMessages(r1)
            if (r5 == 0) goto L_0x00ca
            android.os.Handler r5 = r4.aH
            r5.removeMessages(r1)
            goto L_0x00ca
        L_0x009a:
            r4.a((int) r0, (boolean) r2, (int) r2, (int) r2)
            goto L_0x00ca
        L_0x009e:
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            if (r5 != 0) goto L_0x00ca
            if (r0 != 0) goto L_0x00bb
            int r5 = r4.aC
            if (r5 == 0) goto L_0x00bb
            r4.fP()
            android.os.Handler r5 = r4.aH
            boolean r5 = r5.hasMessages(r1)
            if (r5 == 0) goto L_0x00ca
            android.os.Handler r5 = r4.aH
            r5.removeMessages(r1)
            goto L_0x00ca
        L_0x00bb:
            int r5 = r4.aC
            if (r5 == r0) goto L_0x00ca
            android.os.Handler r5 = r4.aH
            boolean r5 = r5.hasMessages(r1)
            if (r5 != 0) goto L_0x00ca
            r4.a((int) r0, (boolean) r2, (int) r2, (int) r2)
        L_0x00ca:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.e.k.a(com.oppo.camera.aps.adapter.ApsTotalResult):void");
    }

    private void a(int i, boolean z, int i2, int i3) {
        Message obtainMessage = this.aH.obtainMessage();
        obtainMessage.what = 1;
        obtainMessage.arg1 = i;
        obtainMessage.arg2 = i3;
        obtainMessage.obj = Boolean.valueOf(z);
        this.aH.sendMessageDelayed(obtainMessage, (long) i2);
    }

    /* access modifiers changed from: private */
    public void H(int i) {
        String str;
        switch (i) {
            case R.string.camera_id_photo_mode_more_faces:
                str = "more_face";
                break;
            case R.string.camera_id_photo_mode_need_more_light:
                str = ReminderMsgData.CODE_FLASH_ON;
                break;
            case R.string.camera_id_photo_mode_no_faces:
                str = "no_face";
                break;
            default:
                return;
        }
        ReminderMsgData reminderMsgData = new ReminderMsgData(this.Z, true);
        if (this.X != null) {
            reminderMsgData.mCameraId = this.X.aq();
        }
        reminderMsgData.mReminderCodeValue = str;
        reminderMsgData.mCaptureMode = a();
        reminderMsgData.mOrientation = this.k;
        reminderMsgData.mReminderTypeValue = ReminderMsgData.TYPE_ADVICE;
        reminderMsgData.mRearOrFront = this.t ? DcsMsgData.FRONT : DcsMsgData.REAR;
        reminderMsgData.report();
    }

    private boolean fO() {
        int i = this.aB;
        if (i == 0) {
            a((int) R.string.camera_id_photo_mode_no_faces_retake, true, 1000, 2000);
            return false;
        } else if (i <= 1) {
            return true;
        } else {
            a((int) R.string.camera_id_photo_mode_more_faces_retake, true, 1000, 2000);
            return false;
        }
    }

    public void g(boolean z) {
        com.oppo.camera.ui.inverse.c.INS.setPositionRatio(this.Z, 0.5f, z);
    }

    /* access modifiers changed from: private */
    public void a(int i, boolean z, int i2) {
        if (this.Y != null && this.aE < System.currentTimeMillis()) {
            this.aD = System.currentTimeMillis();
            this.aE = this.aD + ((long) i2);
            this.aC = i;
            this.Y.a(i, 0, z, true, false, false, true);
        }
    }

    private void fP() {
        Message obtainMessage = this.aH.obtainMessage();
        obtainMessage.what = 2;
        long currentTimeMillis = 1000 - (System.currentTimeMillis() - this.aD);
        long j = 0;
        if (currentTimeMillis > 0) {
            j = currentTimeMillis;
        }
        this.aH.sendMessageDelayed(obtainMessage, j);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x005f, code lost:
        if (r4.J != false) goto L_0x006e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x006c, code lost:
        if (r4.J == false) goto L_0x0073;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x006e, code lost:
        r4.Z.finish();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0073, code lost:
        com.oppo.camera.e.d("IdPhotoMode", "onAfterPictureTaken, uri: " + r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(byte[] r5, boolean r6) {
        /*
            r4 = this;
            java.lang.String r0 = "IdPhotoMode"
            super.a((byte[]) r5, (boolean) r6)
            r5 = 0
            r4.f((boolean) r5, (boolean) r6)
            boolean r6 = r4.y
            if (r6 != 0) goto L_0x0092
            boolean r6 = r4.fO()
            if (r6 != 0) goto L_0x0015
            goto L_0x0092
        L_0x0015:
            com.oppo.camera.ui.e r6 = r4.Y
            android.net.Uri r6 = r6.ab()
            if (r6 == 0) goto L_0x0092
            android.content.Intent r1 = new android.content.Intent
            java.lang.String r2 = "oppo.intent.action.galleryfeature"
            r1.<init>(r2)
            java.lang.String r2 = "feature"
            java.lang.String r3 = "aiidphoto"
            r1.putExtra(r2, r3)
            android.app.Activity r2 = r4.Z
            java.lang.String r2 = r2.getPackageName()
            java.lang.String r3 = "from"
            r1.putExtra(r3, r2)
            java.lang.String r2 = "aiidphotouri"
            r1.putExtra(r2, r6)
            android.app.Activity r2 = r4.Z     // Catch:{ Throwable -> 0x0064 }
            r2.startActivity(r1)     // Catch:{ Throwable -> 0x0064 }
            android.app.Activity r1 = r4.Z     // Catch:{ Throwable -> 0x0064 }
            r2 = 1
            android.app.Activity r3 = r4.Z     // Catch:{ Throwable -> 0x0064 }
            android.content.res.Resources r3 = r3.getResources()     // Catch:{ Throwable -> 0x0064 }
            android.content.res.Configuration r3 = r3.getConfiguration()     // Catch:{ Throwable -> 0x0064 }
            int r3 = r3.getLayoutDirection()     // Catch:{ Throwable -> 0x0064 }
            if (r2 != r3) goto L_0x0057
            r2 = 2130772061(0x7f01005d, float:1.714723E38)
            goto L_0x005a
        L_0x0057:
            r2 = 2130772059(0x7f01005b, float:1.7147226E38)
        L_0x005a:
            r1.overridePendingTransition(r2, r5)     // Catch:{ Throwable -> 0x0064 }
            boolean r5 = r4.J
            if (r5 == 0) goto L_0x0073
            goto L_0x006e
        L_0x0062:
            r5 = move-exception
            goto L_0x0088
        L_0x0064:
            r5 = move-exception
            java.lang.String r1 = "onAfterPictureTaken, start gallery error!"
            com.oppo.camera.e.d(r0, r1, r5)     // Catch:{ all -> 0x0062 }
            boolean r5 = r4.J
            if (r5 == 0) goto L_0x0073
        L_0x006e:
            android.app.Activity r5 = r4.Z
            r5.finish()
        L_0x0073:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r1 = "onAfterPictureTaken, uri: "
            r5.append(r1)
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            com.oppo.camera.e.d(r0, r5)
            goto L_0x0092
        L_0x0088:
            boolean r6 = r4.J
            if (r6 == 0) goto L_0x0091
            android.app.Activity r6 = r4.Z
            r6.finish()
        L_0x0091:
            throw r5
        L_0x0092:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.e.k.a(byte[], boolean):void");
    }

    public boolean aM() {
        this.aB = this.aG;
        return super.aM();
    }

    /* access modifiers changed from: protected */
    public String da() {
        return this.aB != 1 ? ApsConstant.CAPTURE_MODE_COMMON : ApsConstant.CAPTURE_MODE_ID_PHOTO;
    }

    public boolean i(String str) {
        if ("pref_camera_timer_shutter_key".equals(str) || "pref_camera_photo_ratio_key".equals(str)) {
            return false;
        }
        return super.i(str);
    }

    public void f(boolean z) {
        if (!this.y && this.Y != null) {
            super.f(z);
            this.Y.j(true);
            if (this.aa != null && !this.aa.getBoolean("key_bottom_guide_type_id_photo", false)) {
                this.Y.n(4);
            }
            Handler handler = this.aH;
            if (handler != null) {
                handler.sendEmptyMessageDelayed(3, 500);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void t() {
        super.t();
        this.Y.a(true, true, true);
        this.aC = 0;
        this.aD = 0;
        this.aI = false;
        fP();
        if (this.aH.hasMessages(1)) {
            this.aH.removeMessages(1);
        }
    }
}
