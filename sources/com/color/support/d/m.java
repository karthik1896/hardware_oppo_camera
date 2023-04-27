package com.color.support.d;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.SoundPool;
import android.provider.Settings;
import java.util.HashMap;

/* compiled from: ColorSoundLoadUtil */
public class m {

    /* renamed from: a  reason: collision with root package name */
    private static m f1873a;

    /* renamed from: b  reason: collision with root package name */
    private HashMap<Integer, Integer> f1874b = new HashMap<>();
    private SoundPool c;

    private m() {
        b();
    }

    public static synchronized m a() {
        m mVar;
        synchronized (m.class) {
            if (f1873a == null) {
                f1873a = new m();
            }
            mVar = f1873a;
        }
        return mVar;
    }

    private void b() {
        SoundPool.Builder builder = new SoundPool.Builder();
        AudioAttributes build = new AudioAttributes.Builder().setLegacyStreamType(1).build();
        builder.setMaxStreams(1);
        builder.setAudioAttributes(build);
        this.c = builder.build();
    }

    public int a(Context context, int i) {
        if (this.f1874b.containsKey(Integer.valueOf(i))) {
            return this.f1874b.get(Integer.valueOf(i)).intValue();
        }
        int load = this.c.load(context, i, 0);
        this.f1874b.put(Integer.valueOf(i), Integer.valueOf(load));
        return load;
    }

    public void a(Context context, int i, float f, float f2, int i2, int i3, float f3) {
        if (a(context)) {
            this.c.play(i, f, f2, i2, i3, f3);
        }
    }

    private boolean a(Context context) {
        return Settings.System.getInt(context.getContentResolver(), "sound_effects_enabled", 0) != 0;
    }
}
