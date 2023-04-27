package androidx.media;

import android.text.TextUtils;
import androidx.core.f.c;
import androidx.media.e;

/* compiled from: MediaSessionManagerImplBase */
class h {

    /* renamed from: a  reason: collision with root package name */
    private static final boolean f955a = e.f951a;

    /* compiled from: MediaSessionManagerImplBase */
    static class a implements e.b {

        /* renamed from: a  reason: collision with root package name */
        private String f956a;

        /* renamed from: b  reason: collision with root package name */
        private int f957b;
        private int c;

        a(String str, int i, int i2) {
            this.f956a = str;
            this.f957b = i;
            this.c = i2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (TextUtils.equals(this.f956a, aVar.f956a) && this.f957b == aVar.f957b && this.c == aVar.c) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return c.a(this.f956a, Integer.valueOf(this.f957b), Integer.valueOf(this.c));
        }
    }
}
