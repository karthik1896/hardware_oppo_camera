package androidx.media;

import android.media.session.MediaSessionManager;
import android.os.Build;
import android.util.Log;
import androidx.media.g;
import androidx.media.h;

/* compiled from: MediaSessionManager */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    static final boolean f951a = Log.isLoggable("MediaSessionManager", 3);

    /* renamed from: b  reason: collision with root package name */
    private static final Object f952b = new Object();

    /* compiled from: MediaSessionManager */
    interface b {
    }

    /* compiled from: MediaSessionManager */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        b f953a;

        public a(String str, int i, int i2) {
            if (Build.VERSION.SDK_INT >= 28) {
                this.f953a = new g.a(str, i, i2);
            } else {
                this.f953a = new h.a(str, i, i2);
            }
        }

        public a(MediaSessionManager.RemoteUserInfo remoteUserInfo) {
            this.f953a = new g.a(remoteUserInfo);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            return this.f953a.equals(((a) obj).f953a);
        }

        public int hashCode() {
            return this.f953a.hashCode();
        }
    }
}
