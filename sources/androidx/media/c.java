package androidx.media;

import java.util.Arrays;

/* compiled from: AudioAttributesImplBase */
class c implements a {

    /* renamed from: a  reason: collision with root package name */
    int f949a = 0;

    /* renamed from: b  reason: collision with root package name */
    int f950b = 0;
    int c = 0;
    int d = -1;

    c() {
    }

    public int a() {
        int i = this.d;
        if (i != -1) {
            return i;
        }
        return AudioAttributesCompat.a(false, this.c, this.f949a);
    }

    public int b() {
        return this.f950b;
    }

    public int c() {
        return this.f949a;
    }

    public int d() {
        int i = this.c;
        int a2 = a();
        if (a2 == 6) {
            i |= 4;
        } else if (a2 == 7) {
            i |= 1;
        }
        return i & 273;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f950b), Integer.valueOf(this.c), Integer.valueOf(this.f949a), Integer.valueOf(this.d)});
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        if (this.f950b == cVar.b() && this.c == cVar.d() && this.f949a == cVar.c() && this.d == cVar.d) {
            return true;
        }
        return false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("AudioAttributesCompat:");
        if (this.d != -1) {
            sb.append(" stream=");
            sb.append(this.d);
            sb.append(" derived");
        }
        sb.append(" usage=");
        sb.append(AudioAttributesCompat.a(this.f949a));
        sb.append(" content=");
        sb.append(this.f950b);
        sb.append(" flags=0x");
        sb.append(Integer.toHexString(this.c).toUpperCase());
        return sb.toString();
    }
}
