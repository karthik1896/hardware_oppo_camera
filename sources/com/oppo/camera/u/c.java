package com.oppo.camera.u;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.widget.Toast;
import androidx.core.app.h;
import com.oppo.camera.Camera;
import com.oppo.camera.R;
import com.oppo.camera.e;

/* compiled from: TemperatureNotificationManager */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private Context f3761a = null;

    /* renamed from: b  reason: collision with root package name */
    private NotificationManager f3762b = null;
    private a c;

    public c(Context context, a aVar) {
        this.f3761a = context;
        this.c = aVar;
    }

    public void a() {
        int i = Settings.System.getInt(this.f3761a.getContentResolver(), "oplus_settings_hightemp_protect", 0);
        e.b("TemperatureNotificationManager", "initTemperatureSettings highTempProtectStatus: " + i);
        this.f3762b = (NotificationManager) this.f3761a.getSystemService("notification");
        if (1 == i) {
            Camera.m = true;
            Camera.o = true;
            a(this.f3761a.getString(R.string.camera_high_temperature_exit_toast), this.f3761a.getString(R.string.camera_high_temperature_exit_notification));
            Context context = this.f3761a;
            Toast.makeText(context, context.getString(R.string.camera_high_temperature_exit_notification), 1).show();
            this.c.a(true, i);
            return;
        }
        b();
        Camera.m = false;
        Camera.o = false;
    }

    private void a(String str, String str2) {
        e.b("TemperatureNotificationManager", "temperatureNotifyIn");
        Intent intent = new Intent();
        intent.setPackage(this.f3761a.getPackageName());
        intent.setAction("camera_close");
        PendingIntent broadcast = PendingIntent.getBroadcast(this.f3761a, 0, intent, 268435456);
        NotificationChannel notificationChannel = new NotificationChannel("1", "camera", 4);
        h.b bVar = new h.b();
        bVar.a((CharSequence) str);
        NotificationManager notificationManager = this.f3762b;
        if (notificationManager != null && this.f3761a != null) {
            notificationManager.createNotificationChannel(notificationChannel);
            h.d dVar = new h.d(this.f3761a, "1");
            dVar.b(16);
            dVar.b(true);
            dVar.a((h.e) bVar);
            dVar.a((CharSequence) str2);
            dVar.a((int) R.drawable.ic_launcher_camera);
            dVar.b((CharSequence) str2).a(System.currentTimeMillis());
            dVar.a(broadcast);
            this.f3762b.notify(1, dVar.b());
        }
    }

    public void b() {
        if (this.f3762b != null) {
            e.b("TemperatureNotificationManager", "cancelTemperatureNofify");
            this.f3762b.cancel(1);
        }
    }

    public void c() {
        if (this.f3762b != null) {
            this.f3762b = null;
        }
    }
}
