package com.oppo.camera;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.LocalSocket;
import android.net.LocalSocketAddress;
import android.os.MotorManager;
import android.os.Process;
import com.oppo.camera.aps.config.CameraConfig;
import com.oppo.camera.aps.config.ConfigDataBase;
import com.oppo.camera.util.Util;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;

/* compiled from: CameraMotorManager */
public class h extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    private static h f3100a;

    /* renamed from: b  reason: collision with root package name */
    private WeakReference<MotorManager> f3101b = null;
    private boolean c = false;
    private boolean d = false;
    private boolean e = false;
    private boolean f = false;
    private Runnable g = null;

    public static h a(Context context) {
        h hVar;
        synchronized (h.class) {
            if (f3100a == null) {
                f3100a = new h();
                f3100a.b(context);
            }
            hVar = f3100a;
        }
        return hVar;
    }

    private void b(Context context) {
        if (context != null && this.f3101b == null && Util.h("oplus.software.motor_support")) {
            e.a("CameraMotorManager", "initMotorManager, support hardware motor.");
            this.f3101b = new WeakReference<>(context.getSystemService(MotorManager.class));
            this.e = Util.h("oplus.software.motor.backcamera");
            this.d = Util.h("oplus.software.motor.backflash");
            this.f = true;
        }
    }

    public boolean a() {
        return this.d;
    }

    public boolean b() {
        return this.e;
    }

    public boolean c() {
        return this.f;
    }

    public void a(Activity activity) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("oppo.intent.action.MOTOR_UPED");
        activity.registerReceiver(this, intentFilter);
    }

    public void b(Activity activity) {
        activity.unregisterReceiver(this);
    }

    public void onReceive(Context context, Intent intent) {
        Runnable runnable;
        String action = intent.getAction();
        if (((action.hashCode() == -215192424 && action.equals("oppo.intent.action.MOTOR_UPED")) ? (char) 0 : 65535) == 0 && (runnable = this.g) != null) {
            runnable.run();
            this.g = null;
        }
    }

    private boolean h() {
        WeakReference<MotorManager> weakReference = this.f3101b;
        return (weakReference == null || weakReference.get() == null) ? false : true;
    }

    public boolean d() {
        return !h() || ((MotorManager) this.f3101b.get()).getMotorStateBySystemApp() == 10;
    }

    public void a(Runnable runnable) {
        this.g = runnable;
    }

    public synchronized void e() {
        if (this.c && h()) {
            int configIntValue = CameraConfig.getConfigIntValue(ConfigDataBase.KEY_MOTOR_DOWN_DELAY);
            if (configIntValue < 0) {
                configIntValue = 1000;
            }
            e.a("CameraMotorManager", "downMotorByPrivacyApp, motorDelay: " + configIntValue);
            ((MotorManager) this.f3101b.get()).downMotorByPrivacyApp("motor_force_by_camera", configIntValue);
            this.c = false;
        }
    }

    public synchronized void f() {
        if (this.c && h()) {
            e.a("CameraMotorManager", "downMotorBySystemApp");
            ((MotorManager) this.f3101b.get()).downMotorBySystemApp("motor_force_by_camera");
            this.c = false;
        }
    }

    public synchronized void g() {
        if (!this.c && h()) {
            int motorStateBySystemApp = ((MotorManager) this.f3101b.get()).getMotorStateBySystemApp();
            e.a("CameraMotorManager", "upMotorBySystemApp, motorState: " + motorStateBySystemApp);
            if (10 == motorStateBySystemApp) {
                ((MotorManager) this.f3101b.get()).upMotorBySystemApp("motor_force_by_camera");
                this.c = true;
            }
        }
    }

    public synchronized void a(int i) {
        MotorManager motorManager;
        if (h() && (motorManager = (MotorManager) this.f3101b.get()) != null) {
            int motorStateBySystemApp = motorManager.getMotorStateBySystemApp();
            e.a("CameraMotorManager", "breathLedLoopEffect, motorState: " + motorStateBySystemApp);
            if (10 == motorStateBySystemApp) {
                motorManager.breathLedLoopEffect(i);
            }
        }
    }

    public void b(int i) {
        PrintWriter printWriter;
        LocalSocket localSocket = new LocalSocket();
        try {
            localSocket.connect(new LocalSocketAddress("motor_socket"));
            localSocket.setSoTimeout(1000);
            printWriter = new PrintWriter(localSocket.getOutputStream());
        } catch (IOException e2) {
            e.c("CameraMotorManager", "sendSocketToMotorManager, local socket connect", e2);
            printWriter = null;
        }
        if (printWriter != null) {
            printWriter.print(("1" + "," + Process.myPid() + "," + "com.oppo.camera" + "," + i).toCharArray());
            printWriter.flush();
            printWriter.close();
        }
        try {
            localSocket.close();
        } catch (IOException e3) {
            e.d("CameraMotorManager", "sendSocketToMotorManager, local socket close", e3);
        }
    }
}
