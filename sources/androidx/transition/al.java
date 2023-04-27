package androidx.transition;

import android.os.IBinder;

/* compiled from: WindowIdApi14 */
class al implements an {

    /* renamed from: a  reason: collision with root package name */
    private final IBinder f1259a;

    al(IBinder iBinder) {
        this.f1259a = iBinder;
    }

    public boolean equals(Object obj) {
        return (obj instanceof al) && ((al) obj).f1259a.equals(this.f1259a);
    }

    public int hashCode() {
        return this.f1259a.hashCode();
    }
}
