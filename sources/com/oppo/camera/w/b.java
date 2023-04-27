package com.oppo.camera.w;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.location.Location;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.preference.Preference;
import androidx.preference.PreferenceScreen;
import com.color.support.preference.ColorPreferenceCategory;
import com.heytap.providers.a;
import com.oppo.camera.R;
import com.oppo.camera.e;
import com.oppo.camera.e.v;
import com.oppo.camera.o;
import com.oppo.camera.statistics.model.CaptureMsgData;
import com.oppo.camera.statistics.model.VideoRecordMsgData;
import com.oppo.camera.util.Util;
import java.util.List;
import java.util.Locale;

/* compiled from: RegionAdapter */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static final String f4638a = "b";

    public static String a() {
        return "0";
    }

    public static void a(Activity activity, boolean z) {
    }

    public static void a(CaptureMsgData captureMsgData, boolean z, o oVar) {
    }

    public static void a(VideoRecordMsgData videoRecordMsgData, boolean z, Location location) {
    }

    public static boolean c() {
        return true;
    }

    public static boolean d() {
        return true;
    }

    public static boolean e() {
        return true;
    }

    public static boolean f() {
        return true;
    }

    public static boolean g() {
        return true;
    }

    public static boolean h() {
        return true;
    }

    public static void a(ContentResolver contentResolver, int i) {
        a.d.b(contentResolver, "oppo_is_camera_recording", i);
    }

    public static void a(Activity activity) {
        activity.setResult(-1);
        activity.finish();
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return String.valueOf(str.toLowerCase(Locale.US).hashCode());
    }

    public static String a(Context context, o.a aVar, List<String> list) {
        return b(context, aVar, list);
    }

    private static String b(Context context, o.a aVar, List<String> list) {
        StringBuilder sb = new StringBuilder();
        String[] strArr = {aVar.d, aVar.e, aVar.f, aVar.g};
        String[] strArr2 = {aVar.e, aVar.f, aVar.g};
        if (a(context, aVar)) {
            strArr = strArr2;
        } else if (!TextUtils.isEmpty(aVar.f) || !TextUtils.isEmpty(aVar.e) || !TextUtils.isEmpty(aVar.d)) {
            strArr[3] = null;
        }
        for (String str : strArr) {
            if (!TextUtils.isEmpty(str)) {
                if (!sb.toString().isEmpty()) {
                    sb.append(", ");
                }
                sb.append(str);
            }
        }
        if (TextUtils.isEmpty(sb.toString())) {
            for (String str2 : new String[]{aVar.f3139a, aVar.f3140b, aVar.c}) {
                if (!TextUtils.isEmpty(str2)) {
                    if (!sb.toString().isEmpty()) {
                        sb.append(", ");
                    }
                    sb.append(str2);
                }
            }
        }
        if (list == null) {
            e.a(f4638a, "parseExportVersionAddress, sensor area is loading");
            return "";
        }
        String sb2 = sb.toString();
        for (String lowerCase : list) {
            if (sb2.toLowerCase().contains(lowerCase.toLowerCase())) {
                e.a(f4638a, "parseExportVersionAddress, here is sensor area");
                return "";
            }
        }
        return sb2;
    }

    public static boolean a(Context context, o.a aVar) {
        if (aVar == null) {
            return false;
        }
        if ("TW".equals(aVar.h)) {
            return true;
        }
        Resources resources = context.getResources();
        String string = resources.getString(R.string.camera_taiwan);
        if ((!TextUtils.isEmpty(aVar.g) && aVar.g.contains(string)) || (!TextUtils.isEmpty(aVar.f) && aVar.f.contains(string))) {
            return true;
        }
        for (String str : resources.getStringArray(R.array.taiwan_to_match)) {
            if ((!TextUtils.isEmpty(aVar.g) && aVar.g.contains(str)) || (!TextUtils.isEmpty(aVar.f) && aVar.f.contains(str))) {
                return true;
            }
        }
        return false;
    }

    public static boolean b() {
        String i = Util.i("ro.vendor.oplus.regionmark");
        return "EUEX".equals(i) || "RU".equals(i);
    }

    public static String a(Context context) {
        e.b(f4638a, "getBaseUrl, url is release env exp");
        return "https://stickerf.apps.oppomobile.com";
    }

    public static void a(v vVar, int i) {
        vVar.g(64000);
    }

    public static void a(PreferenceScreen preferenceScreen, ColorPreferenceCategory colorPreferenceCategory) {
        preferenceScreen.d((Preference) colorPreferenceCategory);
    }

    public static void a(Bundle bundle, color.support.v7.app.b bVar, color.support.v7.app.b bVar2, color.support.v7.app.b bVar3) {
        bundle.putBoolean("key_location_guide_dialog_show", bVar != null && bVar.isShowing());
    }
}
