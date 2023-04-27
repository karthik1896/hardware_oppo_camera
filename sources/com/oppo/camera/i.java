package com.oppo.camera;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import color.support.v7.app.b;
import com.oppo.camera.j;
import com.oppo.camera.statistics.model.EnterExitDcsMsgData;
import com.oppo.camera.util.Util;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: CameraPermission */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public static final List<String> f3102a = Arrays.asList(new String[]{"android.permission.CAMERA", "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_PHONE_STATE"});
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public Activity f3103b = null;
    /* access modifiers changed from: private */
    public k c = null;
    private j d = null;
    /* access modifiers changed from: private */
    public b e = null;
    /* access modifiers changed from: private */
    public a f = null;

    /* compiled from: CameraPermission */
    public interface a {
        void a();
    }

    /* compiled from: CameraPermission */
    public interface d {
        void a();

        void b();
    }

    private static String a(int i) {
        return 1 == i ? EnterExitDcsMsgData.TIMING_OPEN_CAMERA : 2 == i ? EnterExitDcsMsgData.TIMING_VIDEO_RECORD : 3 == i ? EnterExitDcsMsgData.TIMING_SETTING_LOCATION : 4 == i ? EnterExitDcsMsgData.TIMING_SETTING_LOCATION_SLOGAN : "";
    }

    public i(Activity activity, k kVar) {
        this.f3103b = activity;
        this.c = kVar;
    }

    public void a() {
        b bVar = this.e;
        if (bVar != null) {
            bVar.c();
        }
        if (this.c.contains("pref_permission_denied")) {
            this.c.edit().remove("pref_permission_denied").apply();
        }
    }

    public void b() {
        j jVar = this.d;
        if (jVar != null) {
            jVar.b();
            this.d = null;
        }
        b bVar = this.e;
        if (bVar != null) {
            bVar.c();
            this.e = null;
        }
    }

    public void c() {
        if (!i()) {
            h();
        }
    }

    public boolean d() {
        for (String checkSelfPermission : f3102a) {
            if (this.f3103b.checkSelfPermission(checkSelfPermission) != 0) {
                return false;
            }
        }
        return true;
    }

    private List<String> g() {
        List<String> list;
        ArrayList arrayList = new ArrayList();
        if (!Util.p(this.f3103b) || !j()) {
            list = f3102a;
        } else {
            list = new ArrayList<>();
            list.addAll(f3102a);
            list.add("android.permission.ACCESS_FINE_LOCATION");
        }
        for (String str : list) {
            if (this.f3103b.checkSelfPermission(str) != 0) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    public void h() {
        List<String> g = g();
        if (g.isEmpty()) {
            this.c.edit().putBoolean("pref_permission_denied", false).apply();
            this.c.edit().putBoolean("key_permission_dialog_displayed", true).apply();
            b bVar = this.e;
            if (bVar != null && !bVar.f()) {
                this.e.c();
                return;
            }
            return;
        }
        this.c.edit().putBoolean("key_permission_dialog_displayed", false).apply();
        if (this.c.getBoolean("pref_permission_denied", false)) {
            a(g, (DialogInterface.OnClickListener) new c(a(g), 1, g));
            return;
        }
        String[] strArr = (String[]) g.toArray(new String[g.size()]);
        this.f3103b.requestPermissions(strArr, 1);
        e.a("CameraPermission", "requestPermissions, permissions: " + Arrays.toString(strArr));
    }

    private void a(List<String> list, DialogInterface.OnClickListener onClickListener) {
        String str;
        String str2;
        int size = list.size();
        if (size != 0) {
            b bVar = this.e;
            if (bVar != null) {
                bVar.c();
            }
            if (1 == size) {
                String str3 = list.get(0);
                Activity activity = this.f3103b;
                str = activity.getString(R.string.camera_permission_dialog_title, new Object[]{b(activity, str3)});
                str2 = a(this.f3103b, str3);
            } else if (2 != size || !list.contains("android.permission.READ_EXTERNAL_STORAGE") || !list.contains("android.permission.WRITE_EXTERNAL_STORAGE")) {
                if (list.contains("android.permission.READ_EXTERNAL_STORAGE") && list.contains("android.permission.WRITE_EXTERNAL_STORAGE")) {
                    list.remove("android.permission.WRITE_EXTERNAL_STORAGE");
                }
                str = this.f3103b.getString(R.string.camera_permission_dialog_multi_title);
                str2 = null;
            } else {
                Activity activity2 = this.f3103b;
                str = activity2.getString(R.string.camera_permission_dialog_title, new Object[]{activity2.getString(R.string.camera_permission_name_storage)});
                str2 = this.f3103b.getString(R.string.camera_permission_description_storage);
            }
            b.a a2 = new b.a(this.f3103b).setOnKeyListener((DialogInterface.OnKeyListener) new DialogInterface.OnKeyListener() {
                public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                    if (i != 4) {
                        return true;
                    }
                    i.this.f3103b.finish();
                    return true;
                }
            }).setTitle((CharSequence) str).setPositiveButton((int) R.string.camera_permission_dialog_ok, onClickListener).setCancelable(false);
            if (a(list)) {
                a2.setNegativeButton((int) R.string.camera_permission_dialog_exit, onClickListener);
            } else {
                a2.setNegativeButton((int) R.string.camera_permission_dialog_cancel, onClickListener);
            }
            if (str2 == null) {
                View inflate = LayoutInflater.from(this.f3103b).inflate(R.layout.permission_dialog_content, (ViewGroup) null);
                ViewGroup viewGroup = (ViewGroup) inflate.findViewById(R.id.permission_dialog_content);
                for (String next : list) {
                    LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.f3103b).inflate(R.layout.permission_dialog_item, (ViewGroup) null);
                    ((TextView) linearLayout.findViewById(R.id.permission_dialog_name)).setText(b(this.f3103b, next));
                    ((TextView) linearLayout.findViewById(R.id.permission_dialog_usage)).setText(c(this.f3103b, next));
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams.topMargin = this.f3103b.getResources().getDimensionPixelSize(R.dimen.permission_dialog_item_top_margin);
                    viewGroup.addView(linearLayout, layoutParams);
                }
                a2.setView(inflate);
            } else {
                a2.setMessage((CharSequence) str2);
            }
            this.e = new b(a2.create(), list, onClickListener);
            if (!this.f3103b.isFinishing()) {
                this.e.b();
            }
        }
    }

    private boolean a(List<String> list) {
        for (String contains : f3102a) {
            if (list.contains(contains)) {
                return true;
            }
        }
        return false;
    }

    private String a(Activity activity, String str) {
        if ("android.permission.CAMERA".equals(str)) {
            return activity.getString(R.string.camera_permission_description_camera);
        }
        if ("android.permission.READ_EXTERNAL_STORAGE".equals(str) || "android.permission.WRITE_EXTERNAL_STORAGE".equals(str)) {
            return activity.getString(R.string.camera_permission_description_storage);
        }
        if ("android.permission.READ_PHONE_STATE".equals(str)) {
            return activity.getString(R.string.camera_permission_description_phone);
        }
        if ("android.permission.RECORD_AUDIO".equals(str)) {
            return activity.getString(R.string.camera_permission_description_microphone);
        }
        if ("android.permission.ACCESS_FINE_LOCATION".equals(str)) {
            return activity.getString(R.string.camera_permission_description_location);
        }
        return "";
    }

    private String b(Activity activity, String str) {
        if ("android.permission.CAMERA".equals(str)) {
            return activity.getString(R.string.camera_permission_name_camera);
        }
        if ("android.permission.READ_EXTERNAL_STORAGE".equals(str) || "android.permission.WRITE_EXTERNAL_STORAGE".equals(str)) {
            return activity.getString(R.string.camera_permission_name_storage);
        }
        if ("android.permission.READ_PHONE_STATE".equals(str)) {
            return activity.getString(R.string.camera_permission_name_phone);
        }
        if ("android.permission.RECORD_AUDIO".equals(str)) {
            return activity.getString(R.string.camera_permission_name_microphone);
        }
        if ("android.permission.ACCESS_FINE_LOCATION".equals(str)) {
            return activity.getString(R.string.camera_permission_name_location);
        }
        return "";
    }

    private String c(Activity activity, String str) {
        if ("android.permission.CAMERA".equals(str)) {
            return activity.getString(R.string.camera_permission_usage_camera);
        }
        if ("android.permission.READ_EXTERNAL_STORAGE".equals(str) || "android.permission.WRITE_EXTERNAL_STORAGE".equals(str)) {
            return activity.getString(R.string.camera_permission_usage_storage);
        }
        if ("android.permission.READ_PHONE_STATE".equals(str)) {
            return activity.getString(R.string.camera_permission_usage_phone);
        }
        if ("android.permission.RECORD_AUDIO".equals(str)) {
            return activity.getString(R.string.camera_permission_usage_microphone);
        }
        if ("android.permission.ACCESS_FINE_LOCATION".equals(str)) {
            return activity.getString(R.string.camera_permission_usage_location);
        }
        return "";
    }

    public void e() {
        j jVar = this.d;
        if (jVar != null && jVar.a()) {
            this.d.b();
            this.d = null;
            i();
        }
    }

    public void f() {
        b bVar = this.e;
        if (bVar != null && bVar.a()) {
            List<String> d2 = this.e.d();
            DialogInterface.OnClickListener e2 = this.e.e();
            this.e.c();
            this.e = null;
            a(d2, e2);
        }
    }

    private boolean i() {
        k kVar;
        if (this.d == null) {
            this.d = new j(this.f3103b, new j.a() {
                public void a(boolean z) {
                    e.a("CameraPermission", "onStatementAlertClick, isAgree: " + z);
                    if (i.this.c != null) {
                        i.this.c.edit().putBoolean("pref_allow_network_access", z).apply();
                        i.this.c.edit().putBoolean("show_arrow_animation", z).apply();
                    }
                    if (!z) {
                        i.this.k();
                    }
                    i.this.h();
                    if (i.this.f != null) {
                        i.this.f.a();
                    }
                    i.a(i.this.f3103b, EnterExitDcsMsgData.STATEMENT_TYPE_PRIVACY, z ? EnterExitDcsMsgData.RESULT_AGREE : "cancel");
                }
            });
        }
        boolean a2 = this.d.a((SharedPreferences) this.c);
        if (!a2 && (kVar = this.c) != null) {
            kVar.edit().putBoolean("show_arrow_animation", true).apply();
        }
        e.a("CameraPermission", "showPrivacyPolicyAlertDialog, isShow: " + a2);
        return a2;
    }

    public void a(int i, String[] strArr, int[] iArr, d dVar) {
        if (strArr == null || strArr.length == 0 || iArr == null || iArr.length == 0) {
            e.d("CameraPermission", "onRequestPermissionsResult, return");
            return;
        }
        k kVar = this.c;
        if (kVar != null) {
            kVar.edit().putBoolean("key_permission_dialog_displayed", true).apply();
        }
        int i2 = 0;
        if (i == 1) {
            dVar.a();
            List<String> a2 = a(strArr, iArr);
            this.c.edit().putBoolean("pref_permission_denied", a2.size() > 0).apply();
            if (!a2.isEmpty()) {
                a(a2, (DialogInterface.OnClickListener) new c(a(a2), 1, a2));
            }
            while (i2 < strArr.length) {
                if (!"android.permission.ACCESS_FINE_LOCATION".equals(strArr[i2])) {
                    i2++;
                } else if (iArr[i2] != 0) {
                    k();
                    return;
                } else {
                    dVar.b();
                    return;
                }
            }
        } else if (i == 2) {
            int i3 = 0;
            while (i3 < strArr.length) {
                if (!"android.permission.RECORD_AUDIO".equals(strArr[i3])) {
                    i3++;
                } else if (iArr[i3] != 0) {
                    a((List<String>) Arrays.asList(new String[]{"android.permission.RECORD_AUDIO"}), (DialogInterface.OnClickListener) new c(false, 2, Arrays.asList(new String[]{"android.permission.RECORD_AUDIO"})));
                    return;
                } else {
                    return;
                }
            }
        }
    }

    private boolean j() {
        k kVar = this.c;
        if (kVar == null) {
            return false;
        }
        if ("on".equals(kVar.getString("pref_camera_recordlocation_key", this.f3103b.getString(R.string.camera_location_default_value))) || "on".equals(this.c.getString("pref_slogan_location_key", this.f3103b.getString(R.string.camera_slogan_default_value))) || "on".equals(this.c.getString("pref_video_slogan_location_key", this.f3103b.getString(R.string.camera_slogan_default_value)))) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    public void k() {
        k kVar = this.c;
        if (kVar != null) {
            SharedPreferences.Editor edit = kVar.edit();
            if ("on".equals(this.c.getString("pref_camera_recordlocation_key", this.f3103b.getString(R.string.camera_location_default_value)))) {
                edit.putString("pref_camera_recordlocation_key", "off");
            }
            if ("on".equals(this.c.getString("pref_slogan_location_key", this.f3103b.getString(R.string.camera_slogan_default_value)))) {
                edit.putString("pref_slogan_location_key", "off");
            }
            if ("on".equals(this.c.getString("pref_video_slogan_location_key", "off"))) {
                edit.putString("pref_video_slogan_location_key", "off");
            }
            edit.apply();
        }
    }

    private List<String> a(String[] strArr, int[] iArr) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < iArr.length; i++) {
            if (iArr[i] != 0) {
                arrayList.add(strArr[i]);
            }
        }
        return arrayList;
    }

    /* compiled from: CameraPermission */
    private class c implements DialogInterface.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        private boolean f3109b = false;
        private int c = 0;
        private List<String> d = null;

        public c(boolean z, int i, List<String> list) {
            this.f3109b = z;
            this.c = i;
            this.d = list;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            if (i == -2) {
                dialogInterface.dismiss();
                if (i.this.e != null) {
                    i.this.e.c();
                    b unused = i.this.e = null;
                }
                i.a(i.this.f3103b, this.c, this.d, this.f3109b ? "exit" : "cancel");
                if (this.f3109b) {
                    i.this.f3103b.finish();
                }
            } else if (i == -1) {
                i.this.f3103b.startActivity(new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.fromParts("package", i.this.f3103b.getPackageName(), (String) null)));
                dialogInterface.dismiss();
                if (i.this.e != null) {
                    i.this.e.c();
                    b unused2 = i.this.e = null;
                }
                i.a(i.this.f3103b, this.c, this.d, EnterExitDcsMsgData.RESULT_SETTING);
            }
        }
    }

    public static void a(Activity activity, int i, String[] strArr, int[] iArr) {
        EnterExitDcsMsgData enterExitDcsMsgData = new EnterExitDcsMsgData(activity, EnterExitDcsMsgData.EVENT_PERMISSION);
        enterExitDcsMsgData.mTiming = a(i);
        for (int i2 = 0; i2 < strArr.length; i2++) {
            if ("android.permission.CAMERA".equals(strArr[i2])) {
                enterExitDcsMsgData.mCameraPermission = a(activity, strArr[i2], iArr[i2]);
            } else if ("android.permission.READ_EXTERNAL_STORAGE".equals(strArr[i2]) || "android.permission.WRITE_EXTERNAL_STORAGE".equals(strArr[i2])) {
                enterExitDcsMsgData.mStoragePermission = a(activity, strArr[i2], iArr[i2]);
            } else if ("android.permission.READ_PHONE_STATE".equals(strArr[i2])) {
                enterExitDcsMsgData.mImeiPermission = a(activity, strArr[i2], iArr[i2]);
            } else if ("android.permission.RECORD_AUDIO".equals(strArr[i2])) {
                enterExitDcsMsgData.mRecorderPermission = a(activity, strArr[i2], iArr[i2]);
            } else if ("android.permission.ACCESS_FINE_LOCATION".equals(strArr[i2])) {
                enterExitDcsMsgData.mLocationPermission = a(activity, strArr[i2], iArr[i2]);
            }
        }
        enterExitDcsMsgData.report();
    }

    public static void a(Activity activity, int i, List<String> list, String str) {
        EnterExitDcsMsgData enterExitDcsMsgData = new EnterExitDcsMsgData(activity, EnterExitDcsMsgData.EVENT_AGREEMENT);
        enterExitDcsMsgData.mTiming = a(i);
        enterExitDcsMsgData.mResult = str;
        for (int i2 = 0; i2 < list.size(); i2++) {
            if ("android.permission.CAMERA".equals(list.get(i2))) {
                enterExitDcsMsgData.mbCamera = true;
            } else if ("android.permission.READ_EXTERNAL_STORAGE".equals(list.get(i2)) || "android.permission.WRITE_EXTERNAL_STORAGE".equals(list.get(i2))) {
                enterExitDcsMsgData.mbStorage = true;
            } else if ("android.permission.READ_PHONE_STATE".equals(list.get(i2))) {
                enterExitDcsMsgData.mbImei = true;
            } else if ("android.permission.RECORD_AUDIO".equals(list.get(i2))) {
                enterExitDcsMsgData.mbRecorder = true;
            } else if ("android.permission.ACCESS_FINE_LOCATION".equals(list.get(i2))) {
                enterExitDcsMsgData.mbLocation = true;
            }
        }
        enterExitDcsMsgData.report();
    }

    public static String a(Activity activity, String str, int i) {
        if (i == 0) {
            return "on";
        }
        return activity.shouldShowRequestPermissionRationale(str) ? "off" : EnterExitDcsMsgData.PERMISSION_DISAGREE;
    }

    public static void a(Activity activity, String str, String str2) {
        EnterExitDcsMsgData enterExitDcsMsgData = new EnterExitDcsMsgData(activity, EnterExitDcsMsgData.EVENT_STATEMENT);
        enterExitDcsMsgData.mStatementType = str;
        enterExitDcsMsgData.mResult = str2;
        enterExitDcsMsgData.report();
    }

    /* compiled from: CameraPermission */
    class b {

        /* renamed from: b  reason: collision with root package name */
        private color.support.v7.app.b f3107b = null;
        private List<String> c = null;
        private DialogInterface.OnClickListener d = null;

        public b(color.support.v7.app.b bVar, List<String> list, DialogInterface.OnClickListener onClickListener) {
            this.f3107b = bVar;
            this.c = list;
            this.d = onClickListener;
        }

        public boolean a() {
            color.support.v7.app.b bVar = this.f3107b;
            if (bVar == null) {
                return false;
            }
            return bVar.isShowing();
        }

        public void b() {
            color.support.v7.app.b bVar = this.f3107b;
            if (bVar != null) {
                bVar.show();
            }
        }

        public void c() {
            if (a()) {
                this.f3107b.dismiss();
            }
            this.f3107b = null;
            this.c = null;
            this.d = null;
        }

        public List<String> d() {
            return this.c;
        }

        public DialogInterface.OnClickListener e() {
            return this.d;
        }

        public boolean f() {
            List<String> list = this.c;
            if (list != null) {
                return list.contains("android.permission.RECORD_AUDIO");
            }
            return false;
        }
    }

    public void a(a aVar) {
        this.f = aVar;
    }
}
