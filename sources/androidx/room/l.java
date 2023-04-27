package androidx.room;

import androidx.f.a.d;
import androidx.f.a.e;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/* compiled from: RoomSQLiteQuery */
public class l implements d, e {
    static final TreeMap<Integer, l> g = new TreeMap<>();

    /* renamed from: a  reason: collision with root package name */
    final long[] f1214a;

    /* renamed from: b  reason: collision with root package name */
    final double[] f1215b;
    final String[] c;
    final byte[][] d;
    final int e;
    int f;
    private volatile String h;
    private final int[] i;

    public void close() {
    }

    public static l a(String str, int i2) {
        synchronized (g) {
            Map.Entry<Integer, l> ceilingEntry = g.ceilingEntry(Integer.valueOf(i2));
            if (ceilingEntry != null) {
                g.remove(ceilingEntry.getKey());
                l value = ceilingEntry.getValue();
                value.b(str, i2);
                return value;
            }
            l lVar = new l(i2);
            lVar.b(str, i2);
            return lVar;
        }
    }

    private l(int i2) {
        this.e = i2;
        int i3 = i2 + 1;
        this.i = new int[i3];
        this.f1214a = new long[i3];
        this.f1215b = new double[i3];
        this.c = new String[i3];
        this.d = new byte[i3][];
    }

    /* access modifiers changed from: package-private */
    public void b(String str, int i2) {
        this.h = str;
        this.f = i2;
    }

    public void a() {
        synchronized (g) {
            g.put(Integer.valueOf(this.e), this);
            c();
        }
    }

    private static void c() {
        if (g.size() > 15) {
            int size = g.size() - 10;
            Iterator<Integer> it = g.descendingKeySet().iterator();
            while (true) {
                int i2 = size - 1;
                if (size > 0) {
                    it.next();
                    it.remove();
                    size = i2;
                } else {
                    return;
                }
            }
        }
    }

    public String b() {
        return this.h;
    }

    public void a(d dVar) {
        for (int i2 = 1; i2 <= this.f; i2++) {
            int i3 = this.i[i2];
            if (i3 == 1) {
                dVar.a(i2);
            } else if (i3 == 2) {
                dVar.a(i2, this.f1214a[i2]);
            } else if (i3 == 3) {
                dVar.a(i2, this.f1215b[i2]);
            } else if (i3 == 4) {
                dVar.a(i2, this.c[i2]);
            } else if (i3 == 5) {
                dVar.a(i2, this.d[i2]);
            }
        }
    }

    public void a(int i2) {
        this.i[i2] = 1;
    }

    public void a(int i2, long j) {
        this.i[i2] = 2;
        this.f1214a[i2] = j;
    }

    public void a(int i2, double d2) {
        this.i[i2] = 3;
        this.f1215b[i2] = d2;
    }

    public void a(int i2, String str) {
        this.i[i2] = 4;
        this.c[i2] = str;
    }

    public void a(int i2, byte[] bArr) {
        this.i[i2] = 5;
        this.d[i2] = bArr;
    }
}
