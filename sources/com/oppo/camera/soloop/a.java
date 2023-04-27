package com.oppo.camera.soloop;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.oppo.camera.aps.config.CameraConfig;
import com.oppo.camera.aps.config.ConfigDataBase;
import com.oppo.camera.e;
import com.oppo.camera.soloop.SoloopRequest;
import com.oppo.camera.sticker.b.a;
import com.oppo.camera.update.MD5Utils;
import com.oppo.camera.util.Util;
import com.oppo.camera.w.c;
import java.util.ArrayList;
import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: SoloopDataRequest */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private Context f3610a = null;

    /* renamed from: b  reason: collision with root package name */
    private SharedPreferences f3611b = null;
    private Call c = null;

    protected a(Context context) {
        this.f3610a = context;
        this.f3611b = Util.f().getSharedPreferences("soloop_info", 0);
    }

    /* access modifiers changed from: protected */
    public void a() {
        String str;
        if (this.f3610a != null) {
            if (!CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_SHOW_SOLOOP_SAME)) {
                e.e("SoloopDataRequest", "soloopUpdateRequest, project config is off.");
                return;
            }
            ArrayList arrayList = new ArrayList();
            Request.Builder builder = new Request.Builder();
            SoloopRequest.ClientMeta clientMeta = new SoloopRequest.ClientMeta();
            SoloopRequest.Upgrades upgrades = new SoloopRequest.Upgrades();
            SoloopRequest soloopRequest = new SoloopRequest();
            Gson gson = new Gson();
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            try {
                str = MD5Utils.getMD5("camera" + currentTimeMillis + "3cba827273b563e6884dec9b0ebacb");
            } catch (Exception e) {
                e.e("SoloopDataRequest", "soloopUpdateRequest error, message: " + e.getMessage());
                str = "";
            }
            com.oppo.camera.sticker.b.a aVar = new com.oppo.camera.sticker.b.a(this.f3610a.getApplicationContext());
            c.a();
            clientMeta.androidVersionCode = Build.VERSION.SDK_INT;
            clientMeta.channel = "2101";
            clientMeta.colorOsCode = com.oppo.camera.sticker.c.a.a().c();
            clientMeta.language = Util.w(this.f3610a.getApplicationContext());
            clientMeta.model = com.oppo.camera.sticker.c.a.a().b();
            clientMeta.region = com.oppo.camera.sticker.c.a.a().f();
            upgrades.pkgName = "com.coloros.videoeditor";
            upgrades.verCode = 0;
            soloopRequest.clientMeta = clientMeta;
            arrayList.add(upgrades);
            soloopRequest.upgrades = arrayList;
            builder.addHeader("sign", str).addHeader("openid", "camera").addHeader("ts", String.valueOf(currentTimeMillis)).addHeader("appVersion", String.valueOf(com.oppo.camera.sticker.c.a.a().a(this.f3610a))).addHeader("model", com.oppo.camera.sticker.c.a.a().b()).addHeader("colorOSVersion", com.oppo.camera.sticker.c.a.a().c()).addHeader("uRegion", com.oppo.camera.sticker.c.a.a().f()).addHeader("androidVersion", String.valueOf(Build.VERSION.SDK_INT)).addHeader("ulang", Util.aa()).post(RequestBody.create(MediaType.parse("application/json;charset=utf-8"), gson.toJson((Object) soloopRequest))).url(c.f4639a + "/camera/getSoloopUpdate");
            AnonymousClass1 r0 = new a.c() {
                public void a(ResponseBody responseBody) {
                    try {
                        JSONArray jSONArray = new JSONObject(responseBody.string()).getJSONArray("data");
                        if (jSONArray.length() == 0) {
                            a.this.c();
                            return;
                        }
                        boolean z = false;
                        String string = ((JSONObject) jSONArray.get(0)).getString("verCode");
                        int i = ((JSONObject) jSONArray.get(0)).getInt("verCode");
                        boolean z2 = !TextUtils.isEmpty(string);
                        a.this.a("key_is_soloop_in_market", z2);
                        a aVar = a.this;
                        if (z2 && 12400 <= i) {
                            z = true;
                        }
                        aVar.a("key_market_soloop_support_jump", z);
                    } catch (Exception e) {
                        e.b("SoloopDataRequest", "soloopUpdateRequest, exception: " + e + ", responseBody: " + responseBody.toString());
                        a.this.c();
                    }
                }

                public void a(String str) {
                    e.b("SoloopDataRequest", "soloopUpdateRequest, errorMsg: " + str);
                    a.this.c();
                }
            };
            this.c = aVar.a(builder.build());
            aVar.a(this.c, (a.c) r0);
        }
    }

    /* access modifiers changed from: private */
    public void c() {
        a("key_is_soloop_in_market", false);
        a("key_market_soloop_support_jump", false);
    }

    /* access modifiers changed from: private */
    public void a(String str, boolean z) {
        SharedPreferences sharedPreferences = this.f3611b;
        if (sharedPreferences != null) {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putBoolean(str, z);
            edit.apply();
        }
    }

    /* access modifiers changed from: protected */
    public void b() {
        Call call = this.c;
        if (call != null) {
            call.cancel();
        }
        this.f3610a = null;
    }
}
