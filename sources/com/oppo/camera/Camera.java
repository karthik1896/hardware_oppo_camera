package com.oppo.camera;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.ConditionVariable;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.OrientationEventListener;
import android.view.WindowManager;
import android.widget.Toast;
import androidx.appcompat.app.c;
import com.android.providers.downloads.Downloads;
import com.color.support.d.o;
import com.oplus.app.OPlusAccessControlManager;
import com.oppo.camera.aps.config.CameraConfig;
import com.oppo.camera.aps.config.ConfigDataBase;
import com.oppo.camera.aps.service.ApsService;
import com.oppo.camera.i;
import com.oppo.camera.statistics.model.DcsMsgData;
import com.oppo.camera.statistics.model.EnterExitDcsMsgData;
import com.oppo.camera.ui.control.g;
import com.oppo.camera.update.UpdateUtil;
import com.oppo.camera.util.Util;
import com.sensetime.stmobile.STCommon;
import com.sensetime.stmobile.STMobileHumanActionNative;
import java.io.File;
import java.util.Arrays;
import java.util.List;

public class Camera extends c implements SharedPreferences.OnSharedPreferenceChangeListener, d, g {
    public static final List<String> k = Arrays.asList(new String[]{"android.permission.READ_PHONE_STATE", "android.permission.ACCESS_FINE_LOCATION"});
    public static boolean l = false;
    public static boolean m = false;
    public static boolean n = false;
    public static boolean o = false;
    private static final Uri p = Uri.parse("content://com.color.provider.SafeProvider");
    private static int q = 120000;
    private static String r = null;
    private boolean A = false;
    /* access modifiers changed from: private */
    public boolean B = false;
    private String C = null;
    /* access modifiers changed from: private */
    public f D;
    private k E = null;
    /* access modifiers changed from: private */
    public b F;
    /* access modifiers changed from: private */
    public ServiceConnection G = null;
    private long H;
    private boolean I = false;
    /* access modifiers changed from: private */
    public ConditionVariable J = new ConditionVariable();
    private com.oppo.camera.entry.b K = new com.oppo.camera.entry.b();
    /* access modifiers changed from: private */
    public i L = null;
    private Thread M = new Thread(new Runnable() {
        public void run() {
            if (Camera.this.G == null) {
                Intent intent = new Intent(Camera.this, ApsService.class);
                ServiceConnection unused = Camera.this.G = new ServiceConnection() {
                    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                        e.b("OppoCamera", "mApsServiceThread, run, mIpaConnection.onServiceConnected");
                        Camera.this.D.a(componentName, iBinder);
                    }

                    public void onServiceDisconnected(ComponentName componentName) {
                        e.b("OppoCamera", "mApsServiceThread, run, mIpaConnection.onServiceDisconnected");
                    }
                };
                Camera camera = Camera.this;
                camera.bindService(intent, camera.G, 1);
            }
        }
    });
    /* access modifiers changed from: private */
    public final BroadcastReceiver N = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            if (!Camera.this.w && Camera.this.D != null) {
                Camera.this.D.b(intent);
            }
        }
    };
    private BroadcastReceiver O = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            if (Camera.this.D != null) {
                Camera.this.D.b(intent);
            }
        }
    };
    /* access modifiers changed from: private */
    public final BroadcastReceiver P = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            e.b("OppoCamera", "onReceive, action: " + action);
            if ("android.intent.action.PHONE_STATE".equals(action) && Camera.this.D != null) {
                Camera.this.D.b(intent);
            }
        }
    };
    /* access modifiers changed from: private */
    public BroadcastReceiver Q = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            if (!Camera.this.w && Camera.this.D != null) {
                Camera.this.D.b(intent);
            }
        }
    };
    private BroadcastReceiver R = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            if (Camera.this.D != null) {
                Camera.this.D.b(intent);
            }
        }
    };
    private BroadcastReceiver S = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            if (Camera.this.D != null) {
                Camera.this.D.b(intent);
            }
        }
    };
    private Runnable T = new Runnable() {
        public void run() {
            if (Camera.this.B) {
                try {
                    Camera.this.unregisterReceiver(Camera.this.N);
                    Camera.this.unregisterReceiver(Camera.this.P);
                    Camera.this.unregisterReceiver(Camera.this.Q);
                } catch (IllegalArgumentException e) {
                    e.e("OppoCamera", "mUnregisterPauseReceiver, unregister fail, exception: " + e.getMessage());
                } catch (Throwable th) {
                    boolean unused = Camera.this.B = false;
                    throw th;
                }
                boolean unused2 = Camera.this.B = false;
            }
        }
    };
    private Runnable U = new Runnable() {
        public void run() {
            if (!Camera.this.B && !Camera.this.w) {
                boolean unused = Camera.this.B = true;
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.intent.action.MEDIA_MOUNTED");
                intentFilter.addAction("android.intent.action.MEDIA_UNMOUNTED");
                intentFilter.addAction("android.intent.action.MEDIA_CHECKING");
                intentFilter.addAction("android.intent.action.MEDIA_SCANNER_FINISHED");
                intentFilter.addAction("android.intent.action.MEDIA_SHARED");
                intentFilter.addAction("android.intent.action.MEDIA_EJECT");
                intentFilter.addAction("android.intent.action.MEDIA_PRE_SHARED");
                intentFilter.addDataScheme("file");
                Camera camera = Camera.this;
                camera.registerReceiver(camera.N, intentFilter, "oppo.permission.OPPO_COMPONENT_SAFE", (Handler) null);
                IntentFilter intentFilter2 = new IntentFilter();
                intentFilter2.addAction("android.intent.action.PHONE_STATE");
                Camera camera2 = Camera.this;
                camera2.registerReceiver(camera2.P, intentFilter2, "oppo.permission.OPPO_COMPONENT_SAFE", (Handler) null);
                IntentFilter intentFilter3 = new IntentFilter();
                intentFilter3.addAction("android.intent.action.BATTERY_CHANGED");
                Camera camera3 = Camera.this;
                camera3.registerReceiver(camera3.Q, intentFilter3);
            }
        }
    };
    private final Handler s = new a();
    /* access modifiers changed from: private */
    public int t = -1;
    /* access modifiers changed from: private */
    public int u = -1;
    private int v = 0;
    /* access modifiers changed from: private */
    public boolean w;
    /* access modifiers changed from: private */
    public boolean x = true;
    private boolean y = false;
    private boolean z = false;

    public void o() {
    }

    public Camera() {
        com.oppo.camera.v.c.a().a(new Runnable() {
            public void run() {
                Camera camera = Camera.this;
                f unused = camera.D = new f(camera, camera);
                Camera.this.J.open();
            }
        }, "CameraManager instance");
    }

    /* access modifiers changed from: protected */
    public void attachBaseContext(Context context) {
        if (Util.f4603a != context.getApplicationContext().getResources().getConfiguration().densityDpi) {
            Util.m(context.getApplicationContext());
            e.d("OppoCamera", "attachBaseContext, dpi not same, so change it");
        }
        super.attachBaseContext(Util.m(context));
    }

    public void onCreate(Bundle bundle) {
        com.oppo.camera.perf.a.c("launch_on_create");
        Thread thread = this.M;
        if (thread != null) {
            thread.setName("MediaServiceThread");
            this.M.start();
        }
        e.e("OppoCamera", "onCreate, this: " + this);
        e.a("CameraStartupPerformance.onCameraActivityCreate");
        if (isInMultiWindowMode()) {
            super.onCreate(bundle);
            a(getString(R.string.camera_in_multiwindow_cannot_use));
            return;
        }
        this.E = new k(this);
        this.K.a(getIntent(), this, this.E, bundle);
        if (this.K.D() && this.K.m()) {
            getWindow().addFlags(STMobileHumanActionNative.ST_MOBILE_ENABLE_INPUT_CUSTOM);
            e.b("OppoCamera", "onCreate, addFlag FLAG_SHOW_WHEN_LOCKED");
        }
        this.L = new i(this, this.E);
        this.v = getResources().getConfiguration().uiMode;
        this.J.block();
        this.x = this.L.d();
        if (this.x) {
            com.oppo.camera.f.a.a(getApplicationContext());
        }
        this.D.x(true);
        this.D.a(this.E, this.K, this.x);
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_SCREEN_BRIGHTNESS)) {
            com.oppo.camera.ui.inverse.c.INS.init(this, this.K.y(), CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_TORCH_SOFT_LIGHT), CameraConfig.getConfigIntValue(ConfigDataBase.KEY_SCREEN_BRIGHTNESS_VALUE), CameraConfig.getConfigIntValue(ConfigDataBase.KEY_SCREEN_BRIGHTNESS_VIDEO_VALUE), CameraConfig.getConfigIntValue(ConfigDataBase.KEY_SCREEN_BRIGHTNESS_THRESHOLD), CameraConfig.getConfigIntValue(ConfigDataBase.KEY_SCREEN_BRIGHTNESS_RECOVER_THRESHOLD), CameraConfig.getConfigColorValue(ConfigDataBase.KEY_FRONT_INVERSE_COLOR));
        }
        Util.ah();
        Util.l(this);
        Util.h((Context) this);
        com.oppo.camera.v.c.a().a(new Runnable() {
            public void run() {
                UpdateUtil.getInstance(Camera.this).startUpdateAllPara();
                e.a((Context) Camera.this);
                DcsMsgData.init(Camera.this);
            }
        }, "CameraInit");
        super.onCreate(bundle);
        o.a().a((Context) this);
        setContentView((int) R.layout.camera);
        getWindow().getDecorView().setForceDarkAllowed(false);
        this.D.ac();
        this.L.a();
        try {
            this.C = getIntent().getStringExtra("keyguard_start_timestamp");
        } catch (Exception e) {
            e.printStackTrace();
        }
        u();
        if (this.K.D()) {
            getWindow().addFlags(2097152);
            e.b("OppoCamera", "onCreate, addFlag FLAG_TURN_SCREEN_ON");
        }
        e.a("OppoCamera", "onCreate X, this: " + this);
        e.b("CameraStartupPerformance.onCameraActivityCreate");
    }

    public com.oppo.camera.entry.b k() {
        return this.K;
    }

    private void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            Toast.makeText(this, str, 0).show();
        }
        e.a("OppoCamera", "finishActivityWithToast, toastMsg: " + str);
        this.w = true;
        finish();
    }

    public void onMultiWindowModeChanged(boolean z2, Configuration configuration) {
        super.onMultiWindowModeChanged(z2, configuration);
        if (z2) {
            a(getString(R.string.camera_in_multiwindow_cannot_use));
        }
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        this.D.x(true);
        super.onNewIntent(intent);
        e.a("OppoCamera", "onNewIntent");
        if (this.K.a(intent)) {
            if (this.K.D() && !this.A) {
                if (this.K.m()) {
                    getWindow().addFlags(STMobileHumanActionNative.ST_MOBILE_ENABLE_INPUT_CUSTOM);
                }
                getWindow().addFlags(2097152);
                e.b("OppoCamera", "onNewIntent, addFlag FLAG_SHOW_WHEN_LOCKED, FLAG_TURN_SCREEN_ON");
            }
            try {
                this.C = intent.getStringExtra("keyguard_start_timestamp");
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.D.a(intent);
        }
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        if (MyApplication.b()) {
            finish();
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        e.a("CameraStartupPerformance.onCameraActivityResume");
        e.a("OppoCamera", "onResume, this: " + this + ", mbDisplayOnLock: " + this.D.aj() + ", mVersionInfo: " + r);
        this.K.u();
        super.onResume();
        i iVar = this.L;
        if (iVar != null) {
            this.x = iVar.d();
            if (!this.E.getBoolean("pref_camera_statement_key", false)) {
                this.L.a(this.D.aW());
            }
        }
        if (this.x) {
            t();
        }
        i iVar2 = this.L;
        if (iVar2 != null) {
            iVar2.c();
        }
        if (getResources().getConfiguration().densityDpi != Util.f4603a) {
            Util.m(this);
        }
        if (getApplicationContext().getApplicationContext().getResources().getConfiguration().densityDpi != Util.f4603a) {
            Util.m(getApplicationContext());
        }
        if (!this.E.getBoolean("pref_camera_statement_key", false)) {
            s();
        }
        this.H = System.currentTimeMillis();
        this.w = false;
        this.y = false;
        this.D.a((Runnable) new Runnable() {
            public void run() {
                if (Camera.this.F == null) {
                    Camera camera = Camera.this;
                    b unused = camera.F = new b(camera.getApplicationContext());
                }
                Camera.this.F.enable();
            }
        }, 0);
        z.b(getApplicationContext());
        this.E.registerOnSharedPreferenceChangeListener(this);
        this.D.c(this.x, b("com.coloros.gallery3d"));
        y();
        this.D.q(false);
        com.oppo.camera.w.b.a((Activity) this, this.K.c());
        p();
        v();
        com.oppo.camera.w.b.a(getContentResolver(), 0);
        Util.l();
        if (!this.I) {
            if (Util.k((Context) this)) {
                getWindow().addFlags(256);
                getWindow().setFlags(-65537, STCommon.ST_MOBILE_TRACKING_SINGLE_THREAD);
                getWindow().addFlags(Integer.MIN_VALUE);
                getWindow().setNavigationBarContrastEnforced(false);
                getWindow().setNavigationBarColor(0);
            }
            if (27 < Build.VERSION.SDK_INT) {
                getWindow().getDecorView().setSystemUiVisibility(5636);
                WindowManager.LayoutParams attributes = getWindow().getAttributes();
                attributes.layoutInDisplayCutoutMode = 1;
                getWindow().setAttributes(attributes);
            }
            this.I = true;
        }
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_ATHENA_SUPPORT) && Util.f(MyApplication.d())) {
            Util.u(MyApplication.d());
        }
        e.a("OppoCamera", "onResume X, this: " + this + ", mbDisplayOnLock: " + this.D.aj());
        e.b("CameraStartupPerformance.onCameraActivityResume");
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        com.oppo.camera.perf.a.c("camera_exit_onpause_start");
        e.a("OppoCamera", "onPause, this: " + this);
        this.D.x(false);
        this.D.Z();
        g.a();
        this.w = true;
        this.D.a((Runnable) new Runnable() {
            public void run() {
                if (Camera.this.F != null) {
                    Camera.this.F.disable();
                }
            }
        }, 0);
        this.D.p(x());
        this.E.unregisterOnSharedPreferenceChangeListener(this);
        a(2000);
        super.onPause();
        if (!this.D.aT()) {
            if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_VIDEO_BLUR_ULTRA_WIDE) || (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_ULTRA_WIDE_ANGLE_SUPPORT) && this.E.contains("pref_none_sat_ultra_wide_angle_key"))) {
                this.D.h(true);
                this.E.edit().putString("pref_none_sat_ultra_wide_angle_key", "off").apply();
                this.D.h(false);
            }
            if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_NONE_SAT_TELE_SUPPORT) && this.E.contains("pref_none_sat_tele_angle_key")) {
                this.D.h(true);
                this.E.edit().putString("pref_none_sat_tele_angle_key", "off").apply();
                this.D.h(false);
            }
        }
        this.s.removeCallbacksAndMessages((Object) null);
        if ((this.x && !this.D.aX()) || !this.K.f()) {
            this.K.t();
        }
        Util.o();
        Util.m();
        UpdateUtil.getInstance(this).onPause();
        z();
        e.a("OppoCamera", "onPause X, this: " + this);
    }

    public boolean l() {
        return this.x;
    }

    public void onStop() {
        String str;
        f fVar;
        com.oppo.camera.perf.a.c("camera_exit_onstop_start");
        e.a("OppoCamera", "onStop, this: " + this + ", mbExitCameraUseBackKey: " + this.y + ", mKeyguardStartTimeStamp: " + this.C);
        com.oppo.camera.entry.b bVar = this.K;
        f fVar2 = this.D;
        boolean z2 = false;
        bVar.b(fVar2 != null && !fVar2.aT());
        com.oppo.camera.ui.inverse.c.INS.clear();
        super.onStop();
        f fVar3 = this.D;
        if (fVar3 != null) {
            fVar3.a();
        }
        com.oppo.camera.w.b.a(getContentResolver(), 0);
        String str2 = this.C;
        if (str2 == null) {
            str = null;
        } else {
            str = new String(str2);
        }
        this.C = null;
        if (this.K.D() && (fVar = this.D) != null && fVar.X()) {
            getWindow().clearFlags(2097152);
            e.b("OppoCamera", "onStop, clearFlag success finish");
        }
        try {
            z2 = getIntent().getBooleanExtra("com.oppo.camera.extra.IS_VOICE_INTERACTION_ROOT", false);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (getIntent() != null && z2) {
            finish();
        }
        e.a("OppoCamera", "onStop X, this: " + this + ", timeStamp: " + str);
        com.oppo.camera.perf.a.c("camera_exit_onstop_end");
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.z = true;
        e.a("OppoCamera", "onAttachedToWindow");
        f fVar = this.D;
        if (fVar != null) {
            fVar.ae();
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.z = false;
        e.a("OppoCamera", "onDetachedFromWindow");
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        e.a("OppoCamera", "onDestroy, this: " + this);
        i iVar = this.L;
        if (iVar != null) {
            iVar.b();
            this.L = null;
        }
        super.onDestroy();
        UpdateUtil.release();
        w();
        this.w = true;
        this.A = false;
        com.oppo.camera.ui.inverse.c.INS.release(this);
        f fVar = this.D;
        if (fVar != null) {
            fVar.ah();
            this.D = null;
        }
        CameraConfig.release();
        Thread thread = this.M;
        if (thread != null) {
            try {
                thread.join();
                this.M = null;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        Util.ai();
        Util.h();
        com.oppo.camera.ui.preview.a.g.n();
        ServiceConnection serviceConnection = this.G;
        if (serviceConnection != null) {
            unbindService(serviceConnection);
            this.G = null;
        }
        k kVar = this.E;
        if (kVar != null) {
            kVar.a((Context) this);
            this.E = null;
        }
        com.oppo.camera.entry.b bVar = this.K;
        if (bVar != null) {
            bVar.v();
            this.K = null;
        }
        if (MyApplication.b()) {
            Process.killProcess(Process.myPid());
        }
        e.a("OppoCamera", "onDestroy X, this: " + this);
    }

    public void finish() {
        super.finish();
        e.a("OppoCamera", "finish, isFinishing: " + isFinishing());
        if (this.E != null) {
            this.K.a();
        }
        this.A = true;
        boolean z2 = false;
        if (this.K.D()) {
            setShowWhenLocked(false);
            if (this.K.m()) {
                getWindow().clearFlags(STMobileHumanActionNative.ST_MOBILE_ENABLE_INPUT_CUSTOM);
            }
            getWindow().clearFlags(2097152);
            e.b("OppoCamera", "finish, clearFlag success finish");
        }
        try {
            z2 = getIntent().getBooleanExtra("open_from_dialog", false);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (z2) {
            overridePendingTransition(R.anim.oppo_dialog_open_enter, R.anim.oppo_dialog_open_exit);
        }
    }

    public void onBackPressed() {
        e.a("OppoCamera", "onBackPressed");
        if (this.D.aa()) {
            this.y = true;
            super.onBackPressed();
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        e.a("OppoCamera", "onKeyDown, keycode: " + i);
        if (this.w) {
            return false;
        }
        if (this.D.a(i, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        e.a("OppoCamera", "onKeyUp, keyCode: " + i);
        if (this.w) {
            return false;
        }
        if (this.D.b(i, keyEvent)) {
            return true;
        }
        return super.onKeyUp(i, keyEvent);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        if (!(keyCode == 57 || keyCode == 58 || keyCode == 82)) {
            switch (keyCode) {
                case 19:
                case 20:
                case 21:
                case 22:
                    break;
            }
        }
        if (Util.M()) {
            return true;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        this.D.a(motionEvent);
        if (motionEvent.getAction() == 1 || (motionEvent.getX() >= 0.0f && motionEvent.getY() >= 0.0f && motionEvent.getX() <= ((float) Util.E()))) {
            this.D.b(motionEvent);
            if (this.D.C()) {
                e.a("OppoCamera", "dispatchTouchEvent, camera on switching....");
                return true;
            } else if (!super.dispatchTouchEvent(motionEvent)) {
                return this.D.c(motionEvent);
            } else {
                e.a("OppoCamera", "dispatchTouchEvent, consume by super");
                this.D.d(motionEvent);
                return true;
            }
        } else {
            e.a("OppoCamera", "dispatchTouchEvent, X: " + motionEvent.getX() + ", Y: " + motionEvent.getY());
            return false;
        }
    }

    public void onUserInteraction() {
        super.onUserInteraction();
        p();
        com.oppo.camera.entry.b bVar = this.K;
        if (bVar != null && bVar.n()) {
            this.K.o();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        configuration.densityDpi = Util.f4603a;
        getResources().updateConfiguration(configuration, getResources().getDisplayMetrics());
        e.a("OppoCamera", "onConfigurationChanged, config sDefaultDensity: " + configuration.densityDpi + ", uiMode: " + configuration.uiMode + ", sysDensityDpi: " + Util.f4604b);
        i iVar = this.L;
        if (iVar != null) {
            iVar.e();
        }
        if (this.v != configuration.uiMode) {
            this.v = configuration.uiMode;
            i iVar2 = this.L;
            if (iVar2 != null) {
                iVar2.f();
            }
            f fVar = this.D;
            if (fVar != null) {
                fVar.as();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        Bundle extras;
        e.a("OppoCamera", "onActivityResult, resultCode: " + i2);
        super.onActivityResult(i, i2, intent);
        if (i == 1000) {
            Intent intent2 = new Intent();
            if (!(intent == null || (extras = intent.getExtras()) == null)) {
                intent2.putExtras(extras);
            }
            setResult(i2, intent2);
            finish();
            com.oppo.camera.q.a.c(getFileStreamPath("crop-temp").getAbsolutePath());
        } else if (i == 11111 && -1 == i2 && intent != null) {
            Cursor query = getContentResolver().query(intent.getData(), new String[]{Downloads.Impl._DATA}, (String) null, (String[]) null, (String) null);
            query.moveToFirst();
            String string = query.getString(query.getColumnIndex(Downloads.Impl._DATA));
            e.a("OppoCamera", "onActivityResult, videoPath: " + string);
            f fVar = this.D;
            if (!(fVar == null || string == null)) {
                fVar.a(string);
            }
            query.close();
        }
    }

    /* access modifiers changed from: private */
    public void t() {
        com.oppo.camera.f.a.a(getApplicationContext());
        f fVar = this.D;
        if (fVar != null) {
            fVar.aK();
        }
    }

    private void u() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.oppo.gallery3d.action.DELETE_PICTURE");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        intentFilter.addAction("android.intent.action.CLOSE_SYSTEM_DIALOGS");
        registerReceiver(this.O, intentFilter, "oppo.permission.OPPO_COMPONENT_SAFE", (Handler) null);
        IntentFilter intentFilter2 = new IntentFilter();
        intentFilter2.addAction("com.heytap.speechassist.intent.action.WINDOW_MANAGER_OCCUPIED");
        intentFilter2.addAction("com.heytap.speechassist.intent.action.FLOAT_ACTIVITY_START");
        registerReceiver(this.R, intentFilter2, "heytap.speechassist.permission.FLOAT_WINDOW_STATUS", (Handler) null);
        registerReceiver(this.S, new IntentFilter("android.location.MODE_CHANGED"));
        h.a(getApplicationContext()).a((Activity) this);
    }

    private void v() {
        f fVar = this.D;
        if (fVar != null) {
            fVar.a(this.T);
            this.D.a(this.U, 0);
        }
    }

    private void a(long j) {
        f fVar = this.D;
        if (fVar != null) {
            fVar.a(this.T, j);
        }
    }

    private void w() {
        try {
            if (this.D != null) {
                this.D.a(this.T);
            }
            a(0);
            unregisterReceiver(this.O);
            unregisterReceiver(this.R);
            unregisterReceiver(this.S);
            h.a(getApplicationContext()).b((Activity) this);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    public void m() {
        if (this.D != null && !x()) {
            this.D.a(false, true);
        }
        Process.killProcess(Process.myPid());
    }

    public void n() {
        String str;
        e.a("OppoCamera", "onPreviewOKMessage");
        try {
            if (r == null) {
                PackageManager packageManager = getPackageManager();
                String packageName = getPackageName();
                PackageInfo packageInfo = packageManager.getPackageInfo(packageName, 0);
                ApplicationInfo applicationInfo = packageManager.getApplicationInfo(packageName, 128);
                if (!(packageInfo == null || applicationInfo == null)) {
                    Object obj = applicationInfo.metaData.get("versionCommit");
                    Object obj2 = applicationInfo.metaData.get("versionDate");
                    String str2 = null;
                    if (obj != null) {
                        str = obj.toString();
                        if (!str.startsWith("_")) {
                            str = "_" + str;
                        }
                    } else {
                        str = null;
                    }
                    if (obj2 != null) {
                        str2 = obj2.toString();
                    }
                    r = packageInfo.versionName + str + "_" + str2;
                    StringBuilder sb = new StringBuilder();
                    sb.append("onPreviewOKMessage, Camera versionInfo: ");
                    sb.append(r);
                    e.a("OppoCamera", sb.toString());
                }
            }
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        if (this.z) {
            o();
        }
    }

    public void p() {
        e.a("OppoCamera", "keepScreenOnAwhile");
        this.s.removeMessages(1);
        getWindow().addFlags(128);
        this.s.sendEmptyMessageDelayed(1, (long) q);
    }

    public void q() {
        e.a("OppoCamera", "keepScreenOn");
        this.s.removeMessages(1);
        getWindow().addFlags(128);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        e.a("OppoCamera", "onRequestPermissionsResult, requestCode: " + i + ", permissions: " + Arrays.toString(strArr) + ", grantResults: " + Arrays.toString(iArr));
        i iVar = this.L;
        if (iVar != null) {
            iVar.a(i, strArr, iArr, (i.d) new i.d() {
                public void a() {
                    Camera camera = Camera.this;
                    boolean unused = camera.x = camera.L.d();
                    if (Camera.this.x) {
                        Camera.this.t();
                    }
                    e.a("OppoCamera", "onRequestPermissionsResult, mbHasNecessaryPermission: " + Camera.this.x);
                }

                public void b() {
                    if (Camera.this.D != null) {
                        Camera.this.D.aJ();
                    }
                }
            });
        }
        i.a((Activity) this, i, strArr, iArr);
    }

    public boolean r() {
        return checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0;
    }

    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        f fVar;
        if ((!this.w || "pref_subsetting_key".equals(str)) && (fVar = this.D) != null) {
            fVar.a(sharedPreferences, str);
        }
    }

    private boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return OPlusAccessControlManager.getInstance().isEncryptedPackage(str, OPlusAccessControlManager.USER_CURRENT);
    }

    private boolean x() {
        f fVar = this.D;
        if (fVar == null || !fVar.X()) {
            return false;
        }
        return !b("com.coloros.gallery3d");
    }

    private class a extends Handler {
        private a() {
        }

        public void handleMessage(Message message) {
            e.a("OppoCamera", "handleMessage, message: " + message.what);
            if (message.what == 1) {
                if (Camera.this.D != null && Camera.this.D.aI()) {
                    Camera.this.p();
                } else if (Camera.this.D != null && !Camera.this.D.aG()) {
                    Camera.this.getWindow().clearFlags(128);
                    Camera.this.finish();
                }
            }
            e.a("OppoCamera", "handleMessage, message: " + message.what + " X");
        }
    }

    private class b extends OrientationEventListener {
        public b(Context context) {
            super(context);
        }

        public void onOrientationChanged(int i) {
            if (i != -1) {
                if (Camera.this.u != i) {
                    int unused = Camera.this.u = i;
                    if (Camera.this.D != null) {
                        Camera.this.D.f(i);
                    }
                }
                int a2 = Util.a(i, Camera.this.t);
                if (Camera.this.t != a2) {
                    e.d("OppoCamera", "onOrientationChanged, mOrientation: " + Camera.this.t + " -> " + a2);
                    int unused2 = Camera.this.t = a2;
                    if (Camera.this.D != null) {
                        Camera.this.D.e(Camera.this.t);
                    }
                }
            }
        }
    }

    private void y() {
        EnterExitDcsMsgData enterExitDcsMsgData = new EnterExitDcsMsgData(this, "enter");
        enterExitDcsMsgData.mCameraEnterTimeGap = this.K.z();
        enterExitDcsMsgData.mEnterCallPackage = this.K.l();
        enterExitDcsMsgData.mShortcutType = this.K.x();
        enterExitDcsMsgData.mCameraEnterType = String.valueOf(this.K.C());
        enterExitDcsMsgData.mbFromLock = this.K.F();
        enterExitDcsMsgData.mCaptureMode = this.K.e();
        int aU = this.D.aF() ? this.D.aU() : this.K.h();
        enterExitDcsMsgData.mCameraId = aU;
        enterExitDcsMsgData.mRearOrFront = com.oppo.camera.f.a.c(aU) ? DcsMsgData.FRONT : DcsMsgData.REAR;
        enterExitDcsMsgData.onResume();
        enterExitDcsMsgData.report();
    }

    private void z() {
        EnterExitDcsMsgData enterExitDcsMsgData = new EnterExitDcsMsgData(this, "exit");
        enterExitDcsMsgData.mExitCallPackage = this.K.l();
        enterExitDcsMsgData.mShortcutType = this.K.x();
        enterExitDcsMsgData.mbToGallery = this.D.X();
        enterExitDcsMsgData.mResumePauseTime = System.currentTimeMillis() - this.H;
        enterExitDcsMsgData.mCameraEnterType = String.valueOf(this.K.y());
        enterExitDcsMsgData.mResumePauseVideoTime = this.D.aL();
        enterExitDcsMsgData.mCaptureMode = this.K.e();
        enterExitDcsMsgData.mCameraId = this.D.aF() ? this.D.aU() : this.K.h();
        enterExitDcsMsgData.onPause();
        enterExitDcsMsgData.report();
    }

    public void s() {
        e.a("OppoCamera", "copyOdmFileToCache");
        final String str = getApplicationContext().getCacheDir().getAbsolutePath() + File.separator + "anc_cache";
        File file = new File(str);
        File file2 = new File("odm/etc/camera/megvii/anc_cache");
        if (!file.exists()) {
            file.mkdirs();
            if (file2.exists()) {
                com.oppo.camera.v.c.a().a(new Runnable("odm/etc/camera/megvii/anc_cache") {
                    public void run() {
                        Util.a("odm/etc/camera/megvii/anc_cache", str);
                    }
                }, "Video blur and retention cache copy");
            }
        }
    }
}
