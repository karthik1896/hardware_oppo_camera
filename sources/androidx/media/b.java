package androidx.media;

import android.annotation.TargetApi;
import android.media.AudioAttributes;

@TargetApi(21)
/* compiled from: AudioAttributesImplApi21 */
class b implements a {

    /* renamed from: a  reason: collision with root package name */
    AudioAttributes f947a;

    /* renamed from: b  reason: collision with root package name */
    int f948b = -1;

    b() {
    }

    public int hashCode() {
        return this.f947a.hashCode();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        return this.f947a.equals(((b) obj).f947a);
    }

    public String toString() {
        return "AudioAttributesCompat: audioattributes=" + this.f947a;
    }
}
