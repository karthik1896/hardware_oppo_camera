package androidx.media;

import android.os.Build;
import androidx.media.j;

/* compiled from: VolumeProviderCompat */
public abstract class i {

    /* renamed from: a  reason: collision with root package name */
    private final int f958a;

    /* renamed from: b  reason: collision with root package name */
    private final int f959b;
    private int c;
    private a d;
    private Object e;

    /* compiled from: VolumeProviderCompat */
    public static abstract class a {
        public abstract void onVolumeChanged(i iVar);
    }

    public void a(int i) {
    }

    public void b(int i) {
    }

    public final int a() {
        return this.c;
    }

    public final int b() {
        return this.f958a;
    }

    public final int c() {
        return this.f959b;
    }

    public void a(a aVar) {
        this.d = aVar;
    }

    public Object d() {
        if (this.e == null && Build.VERSION.SDK_INT >= 21) {
            this.e = j.a(this.f958a, this.f959b, this.c, new j.a() {
                public void a(int i) {
                    i.this.a(i);
                }

                public void b(int i) {
                    i.this.b(i);
                }
            });
        }
        return this.e;
    }
}
