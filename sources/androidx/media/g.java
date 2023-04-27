package androidx.media;

import android.media.session.MediaSessionManager;
import androidx.core.f.c;
import androidx.media.e;

/* compiled from: MediaSessionManagerImplApi28 */
class g extends f {

    /* compiled from: MediaSessionManagerImplApi28 */
    static final class a implements e.b {

        /* renamed from: a  reason: collision with root package name */
        final MediaSessionManager.RemoteUserInfo f954a;

        a(String str, int i, int i2) {
            this.f954a = new MediaSessionManager.RemoteUserInfo(str, i, i2);
        }

        a(MediaSessionManager.RemoteUserInfo remoteUserInfo) {
            this.f954a = remoteUserInfo;
        }

        public int hashCode() {
            return c.a(this.f954a);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            return this.f954a.equals(((a) obj).f954a);
        }
    }
}
