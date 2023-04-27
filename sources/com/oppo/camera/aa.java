package com.oppo.camera;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.provider.Settings;
import com.oplus.os.LinearmotorVibrator;
import com.oplus.os.WaveformEffect;

/* compiled from: VibrateManager */
public class aa {

    /* renamed from: a  reason: collision with root package name */
    private Activity f2751a = null;

    /* renamed from: b  reason: collision with root package name */
    private LinearmotorVibrator f2752b = null;
    private boolean c = false;
    private boolean d = false;
    private HandlerThread e = null;
    /* access modifiers changed from: private */
    public Handler f = null;
    private WaveformEffect.Builder g;

    @SuppressLint({"WrongConstant"})
    public aa(Activity activity, boolean z) {
        this.f2751a = activity;
        this.f2752b = (LinearmotorVibrator) this.f2751a.getSystemService("linearmotor");
        this.c = false;
        this.d = z;
        this.g = new WaveformEffect.Builder();
        this.e = new HandlerThread("CameraVibrateManager");
        this.e.start();
        this.f = new Handler(this.e.getLooper()) {
            public void handleMessage(Message message) {
                e.a("VibrateManager", "handleMessage, message: " + message.what);
                if (message.what == 100) {
                    aa.this.f.removeCallbacksAndMessages((Object) null);
                    aa.this.b(message.arg1);
                }
            }
        };
    }

    public void a() {
        if (this.d) {
            boolean z = true;
            if (Settings.System.getInt(this.f2751a.getContentResolver(), "haptic_feedback_enabled", 1) == 0) {
                z = false;
            }
            this.c = z;
        }
        e.a("VibrateManager", "onResume, mbVibrateFeedbackEnabled: " + this.c);
    }

    public void b() {
        HandlerThread handlerThread = this.e;
        if (handlerThread != null) {
            handlerThread.quitSafely();
        }
        Handler handler = this.f;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
            this.f = null;
        }
    }

    public boolean c() {
        return this.c;
    }

    public void d() {
        a(68);
    }

    public void e() {
        a(1);
    }

    public void f() {
        a(0);
    }

    private void a(int i) {
        if (this.d && this.c) {
            e.a("VibrateManager", "vibrateWithEffect, effect: " + i);
            Message obtain = Message.obtain();
            obtain.what = 100;
            obtain.arg1 = i;
            this.f.sendMessage(obtain);
        }
    }

    /* access modifiers changed from: private */
    public void b(int i) {
        try {
            if (this.f2752b != null) {
                this.g.setEffectType(i);
                this.f2752b.vibrate(this.g.build());
            }
        } catch (NoClassDefFoundError e2) {
            e2.printStackTrace();
        }
    }
}
