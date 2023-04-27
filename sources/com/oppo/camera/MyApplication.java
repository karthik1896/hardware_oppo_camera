package com.oppo.camera;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.ConditionVariable;
import androidx.preference.j;
import com.oppo.camera.aps.config.AlgoSwitchConfig;
import com.oppo.camera.aps.config.CameraConfig;
import com.oppo.camera.aps.config.ConfigDataBase;
import com.oppo.camera.aps.service.ApsService;
import com.oppo.camera.f.a;
import com.oppo.camera.f.f;
import com.oppo.camera.f.h;
import com.oppo.camera.statistics.CameraStatisticsUtil;
import com.oppo.camera.tuningupgrade.TuningParameterUpgradeService;
import com.oppo.camera.util.Util;
import com.oppo.camera.v.c;
import java.util.Stack;

public class MyApplication extends Application {

    /* renamed from: a  reason: collision with root package name */
    private static Context f2742a = null;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f2743b = false;
    /* access modifiers changed from: private */
    public static Stack<Activity> c = new Stack<>();
    /* access modifiers changed from: private */
    public static f d = null;
    /* access modifiers changed from: private */
    public ConditionVariable e = new ConditionVariable();
    /* access modifiers changed from: private */
    public ConditionVariable f = new ConditionVariable();

    public static f a() {
        return d;
    }

    public static boolean b() {
        return f2743b;
    }

    public static void c() {
        e.a("MyApplication", "finishActivities E");
        while (!c.isEmpty()) {
            Activity pop = c.pop();
            e.a("MyApplication", "finishActivities: activity: " + pop);
            if (!pop.isFinishing()) {
                pop.finishAndRemoveTask();
            }
        }
        e.a("MyApplication", "finishActivities X");
    }

    public static Context d() {
        return f2742a;
    }

    /* access modifiers changed from: protected */
    public void attachBaseContext(Context context) {
        super.attachBaseContext(Util.m(context));
        Util.a((Context) this);
    }

    private void a(final Context context) {
        c.a().a(new Runnable() {
            public void run() {
                Util.b(context);
                f unused = MyApplication.d = new h();
                a.a(context);
                CameraConfig.initialize();
                Util.c(CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_HW_MANUFACTURER_QUALCOMM));
                MyApplication.this.e.open();
                AlgoSwitchConfig.initialize(context);
                MyApplication.this.f.open();
                Util.c(context);
                MyApplication.this.h();
            }
        }, "Camera Initialize");
    }

    /* access modifiers changed from: private */
    public void h() {
        e.b("MyApplication", "checkTuningUpgrade");
        try {
            int i = j.a((Context) this).getInt("copy_tuning_file_state", 0);
            if (i == 0 || 1 == i) {
                Intent intent = new Intent(this, TuningParameterUpgradeService.class);
                intent.setAction("com.oppo.camera.TUNING_UPGRADE");
                intent.putExtra("from", "MyApplication");
                intent.putExtra(CameraStatisticsUtil.RUS_FILE_VERSION, "1.0");
                intent.putExtra("code", "camera_tuning_upgrade");
                startService(intent);
            }
        } catch (Exception e2) {
            e.d("MyApplication", "checkTunningUpgrade, ex: " + e2.getMessage());
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (Build.VERSION.SDK_INT > 23) {
            Util.d(getApplicationContext());
            Util.f4604b = configuration.densityDpi;
            Util.c = configuration.fontScale;
            configuration.densityDpi = Util.f4603a;
            e.b("MyApplication", "onConfigurationChanged, config sDefaultDensity: " + Util.f4603a + ", sysDensityDpi: " + Util.f4604b + ", sysFontScale: " + Util.c);
            getResources().updateConfiguration(configuration, getResources().getDisplayMetrics());
        }
        super.onConfigurationChanged(configuration);
    }

    public void onCreate() {
        e.a("CameraStartupPerformance.onCameraApplicationCreated");
        f2742a = this;
        a((Context) this);
        super.onCreate();
        Util.d(getApplicationContext());
        Util.m(getApplicationContext());
        z.a(getApplicationContext());
        j();
        i();
        e.b("CameraStartupPerformance.onCameraApplicationCreated");
        new k(this).a().edit().putBoolean("share_edit_video_show_expand", true).apply();
    }

    public void e() {
        this.e.block();
        e.a("MyApplication", "checkPreInitStatus X");
    }

    public void f() {
        this.f.block();
        e.a("MyApplication", "checkPreviewConfigStatus X");
    }

    private void i() {
        registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() {
            public void onActivityPaused(Activity activity) {
            }

            public void onActivityResumed(Activity activity) {
            }

            public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            }

            public void onActivityStarted(Activity activity) {
            }

            public void onActivityStopped(Activity activity) {
            }

            public void onActivityCreated(Activity activity, Bundle bundle) {
                e.a("MyApplication", "onActivityCreated, activity: " + activity);
                MyApplication.c.push(activity);
            }

            public void onActivityDestroyed(Activity activity) {
                e.a("MyApplication", "onActivityDestroyed, activity: " + activity);
                if (MyApplication.c.contains(activity)) {
                    MyApplication.c.remove(activity);
                }
            }
        });
    }

    public void onTerminate() {
        Util.e();
        c.a().b();
        d.d();
        super.onTerminate();
    }

    private void j() {
        try {
            startForegroundService(new Intent(this, ApsService.class));
        } catch (IllegalStateException e2) {
            e2.printStackTrace();
        }
    }
}
