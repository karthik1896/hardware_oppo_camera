package com.oppo.camera.u;

import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.text.TextUtils;
import com.heytap.compat.c.a;
import com.oppo.camera.aps.config.CameraConfig;
import com.oppo.camera.aps.config.ConfigDataBase;
import com.oppo.camera.e;
import com.oppo.camera.k;
import com.oppo.camera.statistics.CameraStatisticsUtil;
import com.oppo.camera.util.Util;
import com.oppo.camera.v.c;

/* compiled from: TemperatureProvider */
public class d {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public k f3763a = null;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public a f3764b = null;
    private a c = new a();
    /* access modifiers changed from: private */
    public ContentResolver d = null;
    private b e = null;

    public d(Context context, k kVar, a aVar) {
        this.f3764b = aVar;
        this.d = context.getContentResolver();
        this.f3763a = kVar;
    }

    public void a(final boolean z) {
        Util.a((Runnable) new Runnable() {
            public void run() {
                boolean z = z;
                e.b("TemperatureProvider", "notifyCameraOpened: " + (z ? 1 : 0));
                a.b.a("temperature_o_camera_open", (int) z);
            }
        });
    }

    public void a(final String str) {
        Util.a((Runnable) new Runnable() {
            public void run() {
                e.b("TemperatureProvider", "notifyFlashState: " + str);
                a.b.a("temperature_o_camera_flash_status", str);
            }
        });
    }

    public void a() {
        ContentResolver contentResolver = this.d;
        if (contentResolver != null) {
            contentResolver.registerContentObserver(Settings.System.getUriFor("oplus.camera.flash"), false, this.c);
            this.d.registerContentObserver(Settings.System.getUriFor("oplus.camera.video"), false, this.c);
            this.d.registerContentObserver(Settings.System.getUriFor("oplus.camera.exit"), false, this.c);
            this.d.registerContentObserver(Settings.System.getUriFor("oplus.camera.brightness"), false, this.c);
            this.d.registerContentObserver(Settings.System.getUriFor("oplus_settings_hightemp_protect"), false, this.c);
        }
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_TEMPERATURE_CONTROL_STOP_VIDEO_RECORDING) && this.e == null) {
            this.e = new b();
            Util.f().registerReceiver(this.e, new IntentFilter("oppo.intent.action.THERMAL_LEVEL_CHANGE"));
            c.a().a(new Runnable() {
                public void run() {
                    float a2 = b.b().a();
                    if (d.this.f3763a != null) {
                        d.this.f3763a.edit().putFloat("key_cur_temperature", a2).apply();
                    }
                    e.b("TemperatureProvider", "register getCurrentThermal, currentThermal: " + a2);
                }
            }, "GetCurTemperature");
        }
    }

    public void b() {
        ContentResolver contentResolver;
        a aVar = this.c;
        if (!(aVar == null || (contentResolver = this.d) == null)) {
            contentResolver.unregisterContentObserver(aVar);
            this.d = null;
            this.c = null;
        }
        if (this.e != null) {
            Util.f().unregisterReceiver(this.e);
            this.e = null;
        }
    }

    /* compiled from: TemperatureProvider */
    private final class a extends ContentObserver {
        public a() {
            super(new Handler(Looper.getMainLooper()));
        }

        public void onChange(boolean z, Uri uri) {
            String lastPathSegment = uri == null ? null : uri.getLastPathSegment();
            e.b("TemperatureProvider", "onChange url: " + uri + ", settingsName: " + lastPathSegment);
            if (d.this.d != null && !TextUtils.isEmpty(lastPathSegment)) {
                char c = 65535;
                switch (lastPathSegment.hashCode()) {
                    case -1694432468:
                        if (lastPathSegment.equals("oplus.camera.flash")) {
                            c = 0;
                            break;
                        }
                        break;
                    case -1679743049:
                        if (lastPathSegment.equals("oplus.camera.video")) {
                            c = 1;
                            break;
                        }
                        break;
                    case -885961118:
                        if (lastPathSegment.equals("oplus.camera.exit")) {
                            c = 2;
                            break;
                        }
                        break;
                    case -91767147:
                        if (lastPathSegment.equals("oplus.camera.brightness")) {
                            c = 3;
                            break;
                        }
                        break;
                    case 844777068:
                        if (lastPathSegment.equals("oplus_settings_hightemp_protect")) {
                            c = 4;
                            break;
                        }
                        break;
                }
                if (c == 0) {
                    int i = Settings.System.getInt(d.this.d, lastPathSegment, 0);
                    e.b("TemperatureProvider", "onChange, oplus.camera.flash: " + i);
                    if (1 == i) {
                        d.this.f3764b.a();
                    }
                } else if (c == 1) {
                    int i2 = Settings.System.getInt(d.this.d, lastPathSegment, 0);
                    e.b("TemperatureProvider", "onChange, oplus.camera.video: " + i2);
                    if (1 == i2) {
                        d.this.f3764b.b();
                    }
                } else if (c == 2) {
                    int i3 = Settings.System.getInt(d.this.d, lastPathSegment, 0);
                    e.b("TemperatureProvider", "onChange, oplus.camera.exit: " + i3);
                    d.this.f3764b.a(false, i3);
                } else if (c == 3) {
                    float f = (float) Settings.System.getInt(d.this.d, lastPathSegment, 0);
                    float f2 = (float) Settings.System.getInt(d.this.d, CameraStatisticsUtil.SCREEN_BRIGHTNESS, 130);
                    e.b("TemperatureProvider", "onChange, brightness: " + f + ", currBrightness: " + f2);
                    if (f2 > f) {
                        d.this.f3764b.a(f);
                    }
                } else if (c == 4) {
                    int i4 = Settings.System.getInt(d.this.d, lastPathSegment, 0);
                    e.b("TemperatureProvider", "onChange, oplus_settings_hightemp_protect: " + i4);
                    d.this.f3764b.a(false, i4);
                }
            }
        }
    }

    /* compiled from: TemperatureProvider */
    private class b extends BroadcastReceiver {
        private b() {
        }

        public void onReceive(Context context, Intent intent) {
            int intExtra = intent.getIntExtra("currenttemperature", -1);
            int intExtra2 = intent.getIntExtra("thermallevel", -1);
            d.this.f3764b.a(intExtra2, intExtra);
            e.b("TemperatureProvider", "onReceive, curTemperatureLevel: " + intExtra2 + ", curTemperature: " + intExtra);
        }
    }
}
