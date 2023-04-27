package com.heytap.compat.b;

import android.media.AudioManager;
import android.os.Bundle;
import android.util.Log;
import com.color.inner.media.AudioManagerWrapper;
import com.heytap.compat.d.a.b;
import com.heytap.epona.Request;
import com.heytap.epona.Response;
import com.heytap.epona.c;

/* compiled from: AudioManagerNative */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static int f2564a = 7;

    /* renamed from: b  reason: collision with root package name */
    public static String f2565b = "android.media.VOLUME_CHANGED_ACTION";

    public static void a(int i) throws com.heytap.compat.d.a.a {
        if (b.a()) {
            Request a2 = new Request.a().a("android.media.AudioManager").b("setRingerModeInternal").a();
            Bundle bundle = new Bundle();
            bundle.putInt("ringerMode", i);
            a2.putBundle(bundle);
            Response a3 = c.a(a2).a();
            if (!a3.isSuccessful()) {
                Log.e("AudioManagerNative", "response code error:" + a3.getCode());
            }
        } else if (b.b()) {
            try {
                AudioManagerWrapper.setRingerModeInternal((AudioManager) c.c().getSystemService("audio"), i);
            } catch (Throwable th) {
                Log.e("AudioManagerNative", th.toString());
            }
        } else {
            throw new com.heytap.compat.d.a.a("not supported before Q");
        }
    }
}
