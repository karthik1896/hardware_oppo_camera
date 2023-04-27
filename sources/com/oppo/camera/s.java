package com.oppo.camera;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.oppo.camera.util.Util;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: OppoPlaySound */
public class s implements SoundPool.OnLoadCompleteListener {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public SoundPool f3150a;

    /* renamed from: b  reason: collision with root package name */
    private Context f3151b;
    /* access modifiers changed from: private */
    public HashMap<Integer, Integer> c;
    private HashMap<Integer, Boolean> d;
    private AudioManager e;
    /* access modifiers changed from: private */
    public boolean f;
    private HandlerThread g;
    private Handler h;
    private int i;
    private a j;

    public s(Context context) {
        this.c = null;
        this.d = new HashMap<>();
        this.f = false;
        this.i = -1;
        this.j = null;
        this.f = Util.S();
        if (this.f) {
            this.f3150a = new SoundPool(10, com.heytap.compat.b.a.f2564a, 1);
        } else {
            this.f3150a = new SoundPool(10, 1, 1);
        }
        this.f3150a.setOnLoadCompleteListener(this);
        this.j = new a();
        this.f3151b = context;
        this.e = (AudioManager) this.f3151b.getSystemService("audio");
        this.g = new HandlerThread("OppoPlaySound Thread");
        this.g.start();
        this.h = new Handler(this.g.getLooper()) {
            public void handleMessage(Message message) {
                if (message.what == 1) {
                    int i = message.arg1;
                    if (s.this.f) {
                        if (s.this.c != null && s.this.f3150a != null) {
                            s.this.f3150a.play(((Integer) s.this.c.get(Integer.valueOf(i))).intValue(), 1.0f, 1.0f, 0, 0, 1.0f);
                        }
                    } else if (s.this.f() == 2 && s.this.c != null && s.this.f3150a != null) {
                        s.this.f3150a.play(((Integer) s.this.c.get(Integer.valueOf(i))).intValue(), 1.0f, 1.0f, 0, 0, 1.0f);
                    }
                }
            }
        };
    }

    public void a() {
        if (this.c == null) {
            this.c = new HashMap<>();
            this.c.put(0, Integer.valueOf(this.f3150a.load(this.f3151b, R.raw.camera_shutter, 0)));
            this.c.put(3, Integer.valueOf(this.f3150a.load(this.f3151b, R.raw.camera_time_snapshot, 0)));
            this.c.put(1, Integer.valueOf(this.f3150a.load(this.f3151b, R.raw.camera_burst_shutter, 0)));
            this.c.put(2, Integer.valueOf(this.f3150a.load(this.f3151b, R.raw.camera_burst_shutter_end, 0)));
            if (this.f) {
                this.c.put(4, Integer.valueOf(this.f3150a.load(this.f3151b, R.raw.camera_video_start_jp, 0)));
                this.c.put(5, Integer.valueOf(this.f3150a.load(this.f3151b, R.raw.camera_video_stop_jp, 0)));
            } else {
                this.c.put(4, Integer.valueOf(this.f3150a.load(this.f3151b, R.raw.camera_video_start, 0)));
                this.c.put(5, Integer.valueOf(this.f3150a.load(this.f3151b, R.raw.camera_video_stop, 0)));
            }
            this.j.a(4, 5);
        }
    }

    public void onLoadComplete(SoundPool soundPool, int i2, int i3) {
        if (i3 != 0) {
            e.e("OppoPlaySound", "onLoadComplete, load sound fail for soundId: " + i2 + ", status: " + i3);
        }
        HashMap<Integer, Integer> hashMap = this.c;
        if (hashMap != null && hashMap.entrySet() != null) {
            for (Map.Entry next : this.c.entrySet()) {
                if (i2 == ((Integer) next.getValue()).intValue()) {
                    this.d.put((Integer) next.getKey(), true);
                }
            }
        }
    }

    public boolean a(int i2) {
        return Util.b(this.d) && this.d.containsKey(Integer.valueOf(i2)) && this.d.get(Integer.valueOf(i2)).booleanValue();
    }

    /* access modifiers changed from: private */
    public int f() {
        AudioManager audioManager = this.e;
        if (audioManager != null) {
            return audioManager.getRingerMode();
        }
        return 2;
    }

    public void b() {
        AudioManager audioManager = this.e;
        if (audioManager != null) {
            this.i = audioManager.getRingerMode();
        }
    }

    public void c() {
        e.b("OppoPlaySound", "setAudioSilent, mRestoreRingMode: " + this.i);
        if (this.e != null && 2 == this.i) {
            try {
                com.heytap.compat.b.a.a(0);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void d() {
        int i2;
        e.b("OppoPlaySound", "restoreAudioMode, mRestoreRingMode: " + this.i);
        if (this.e != null && 2 == (i2 = this.i)) {
            try {
                com.heytap.compat.b.a.a(i2);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void b(int i2) {
        if (this.j.a(i2)) {
            this.h.removeCallbacksAndMessages((Object) null);
            this.h.obtainMessage(1, i2, 0).sendToTarget();
        }
    }

    public void e() {
        HandlerThread handlerThread = this.g;
        if (handlerThread != null) {
            handlerThread.quitSafely();
            this.g = null;
        }
        Handler handler = this.h;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
            this.h = null;
        }
        HashMap<Integer, Integer> hashMap = this.c;
        if (hashMap != null) {
            hashMap.clear();
            this.c = null;
        }
        SoundPool soundPool = this.f3150a;
        if (soundPool != null) {
            soundPool.setOnLoadCompleteListener((SoundPool.OnLoadCompleteListener) null);
            this.f3150a.release();
            this.f3150a = null;
        }
        this.d.clear();
        this.e = null;
    }

    /* compiled from: OppoPlaySound */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private List<b> f3153a = new ArrayList();

        public boolean a(int i) {
            for (b next : this.f3153a) {
                if (i == next.f3154a) {
                    next.c = true;
                } else if (i != next.f3155b) {
                    continue;
                } else if (!next.c) {
                    return false;
                } else {
                    next.c = false;
                }
            }
            return true;
        }

        public void a(int i, int i2) {
            this.f3153a.add(new b(i, i2));
        }
    }

    /* compiled from: OppoPlaySound */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public int f3154a = 0;

        /* renamed from: b  reason: collision with root package name */
        public int f3155b = 0;
        public boolean c = false;

        public b(int i, int i2) {
            this.f3154a = i;
            this.f3155b = i2;
        }
    }
}
