package androidx.preference;

import java.util.Set;

/* compiled from: PreferenceDataStore */
public abstract class e {
    public int b(String str, int i) {
        return i;
    }

    public String b(String str, String str2) {
        return str2;
    }

    public Set<String> b(String str, Set<String> set) {
        return set;
    }

    public boolean b(String str, boolean z) {
        return z;
    }

    public void a(String str, String str2) {
        throw new UnsupportedOperationException("Not implemented on this data store");
    }

    public void a(String str, Set<String> set) {
        throw new UnsupportedOperationException("Not implemented on this data store");
    }

    public void a(String str, int i) {
        throw new UnsupportedOperationException("Not implemented on this data store");
    }

    public void a(String str, boolean z) {
        throw new UnsupportedOperationException("Not implemented on this data store");
    }
}
