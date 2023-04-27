package androidx.room;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.util.Log;
import androidx.f.a.e;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;

/* compiled from: InvalidationTracker */
public class f {
    private static final String[] h = {"UPDATE", "DELETE", "INSERT"};

    /* renamed from: a  reason: collision with root package name */
    final HashMap<String, Integer> f1187a;

    /* renamed from: b  reason: collision with root package name */
    final String[] f1188b;
    final i c;
    AtomicBoolean d = new AtomicBoolean(false);
    volatile androidx.f.a.f e;
    @SuppressLint({"RestrictedApi"})
    final androidx.a.a.b.b<b, c> f = new androidx.a.a.b.b<>();
    Runnable g = new Runnable() {
        public void run() {
            androidx.f.a.b b2;
            Lock a2 = f.this.c.a();
            Set<Integer> set = null;
            try {
                a2.lock();
                if (!f.this.a()) {
                    a2.unlock();
                } else if (!f.this.d.compareAndSet(true, false)) {
                    a2.unlock();
                } else if (f.this.c.k()) {
                    a2.unlock();
                } else {
                    if (f.this.c.f1206b) {
                        b2 = f.this.c.b().b();
                        b2.a();
                        set = a();
                        b2.c();
                        b2.b();
                    } else {
                        set = a();
                    }
                    a2.unlock();
                    if (set != null && !set.isEmpty()) {
                        synchronized (f.this.f) {
                            Iterator<Map.Entry<b, c>> it = f.this.f.iterator();
                            while (it.hasNext()) {
                                ((c) it.next().getValue()).a(set);
                            }
                        }
                    }
                }
            } catch (SQLiteException | IllegalStateException e) {
                try {
                    Log.e("ROOM", "Cannot run invalidation tracker. Is the db closed?", e);
                } catch (Throwable th) {
                    a2.unlock();
                    throw th;
                }
            } catch (Throwable th2) {
                b2.b();
                throw th2;
            }
        }

        /* JADX INFO: finally extract failed */
        private Set<Integer> a() {
            HashSet hashSet = new HashSet();
            Cursor a2 = f.this.c.a((e) new androidx.f.a.a("SELECT * FROM room_table_modification_log WHERE invalidated = 1;"));
            while (a2.moveToNext()) {
                try {
                    hashSet.add(Integer.valueOf(a2.getInt(0)));
                } catch (Throwable th) {
                    a2.close();
                    throw th;
                }
            }
            a2.close();
            if (!hashSet.isEmpty()) {
                f.this.e.a();
            }
            return hashSet;
        }
    };
    private Map<String, Set<String>> i;
    private volatile boolean j = false;
    private a k;
    private final e l;
    private g m;

    public f(i iVar, Map<String, String> map, Map<String, Set<String>> map2, String... strArr) {
        this.c = iVar;
        this.k = new a(strArr.length);
        this.f1187a = new HashMap<>();
        this.i = map2;
        this.l = new e(this.c);
        int length = strArr.length;
        this.f1188b = new String[length];
        for (int i2 = 0; i2 < length; i2++) {
            String lowerCase = strArr[i2].toLowerCase(Locale.US);
            this.f1187a.put(lowerCase, Integer.valueOf(i2));
            String str = map.get(strArr[i2]);
            if (str != null) {
                this.f1188b[i2] = str.toLowerCase(Locale.US);
            } else {
                this.f1188b[i2] = lowerCase;
            }
        }
        for (Map.Entry next : map.entrySet()) {
            String lowerCase2 = ((String) next.getValue()).toLowerCase(Locale.US);
            if (this.f1187a.containsKey(lowerCase2)) {
                String lowerCase3 = ((String) next.getKey()).toLowerCase(Locale.US);
                HashMap<String, Integer> hashMap = this.f1187a;
                hashMap.put(lowerCase3, hashMap.get(lowerCase2));
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void a(androidx.f.a.b bVar) {
        synchronized (this) {
            if (this.j) {
                Log.e("ROOM", "Invalidation tracker is initialized twice :/.");
                return;
            }
            bVar.c("PRAGMA temp_store = MEMORY;");
            bVar.c("PRAGMA recursive_triggers='ON';");
            bVar.c("CREATE TEMP TABLE room_table_modification_log(table_id INTEGER PRIMARY KEY, invalidated INTEGER NOT NULL DEFAULT 0)");
            b(bVar);
            this.e = bVar.a("UPDATE room_table_modification_log SET invalidated = 0 WHERE invalidated = 1 ");
            this.j = true;
        }
    }

    /* access modifiers changed from: package-private */
    public void a(Context context, String str) {
        this.m = new g(context, str, this, this.c.i());
    }

    private static void a(StringBuilder sb, String str, String str2) {
        sb.append("`");
        sb.append("room_table_modification_trigger_");
        sb.append(str);
        sb.append("_");
        sb.append(str2);
        sb.append("`");
    }

    private void a(androidx.f.a.b bVar, int i2) {
        String str = this.f1188b[i2];
        StringBuilder sb = new StringBuilder();
        for (String a2 : h) {
            sb.setLength(0);
            sb.append("DROP TRIGGER IF EXISTS ");
            a(sb, str, a2);
            bVar.c(sb.toString());
        }
    }

    private void b(androidx.f.a.b bVar, int i2) {
        bVar.c("INSERT OR IGNORE INTO room_table_modification_log VALUES(" + i2 + ", 0)");
        String str = this.f1188b[i2];
        StringBuilder sb = new StringBuilder();
        for (String str2 : h) {
            sb.setLength(0);
            sb.append("CREATE TEMP TRIGGER IF NOT EXISTS ");
            a(sb, str, str2);
            sb.append(" AFTER ");
            sb.append(str2);
            sb.append(" ON `");
            sb.append(str);
            sb.append("` BEGIN UPDATE ");
            sb.append("room_table_modification_log");
            sb.append(" SET ");
            sb.append("invalidated");
            sb.append(" = 1");
            sb.append(" WHERE ");
            sb.append("table_id");
            sb.append(" = ");
            sb.append(i2);
            sb.append(" AND ");
            sb.append("invalidated");
            sb.append(" = 0");
            sb.append("; END");
            bVar.c(sb.toString());
        }
    }

    @SuppressLint({"RestrictedApi"})
    public void a(b bVar) {
        c a2;
        String[] b2 = b(bVar.f1192a);
        int[] iArr = new int[b2.length];
        int length = b2.length;
        int i2 = 0;
        while (i2 < length) {
            Integer num = this.f1187a.get(b2[i2].toLowerCase(Locale.US));
            if (num != null) {
                iArr[i2] = num.intValue();
                i2++;
            } else {
                throw new IllegalArgumentException("There is no table with name " + b2[i2]);
            }
        }
        c cVar = new c(bVar, iArr, b2);
        synchronized (this.f) {
            a2 = this.f.a(bVar, cVar);
        }
        if (a2 == null && this.k.a(iArr)) {
            c();
        }
    }

    private String[] b(String[] strArr) {
        HashSet hashSet = new HashSet();
        for (String str : strArr) {
            String lowerCase = str.toLowerCase(Locale.US);
            if (this.i.containsKey(lowerCase)) {
                hashSet.addAll(this.i.get(lowerCase));
            } else {
                hashSet.add(str);
            }
        }
        return (String[]) hashSet.toArray(new String[hashSet.size()]);
    }

    @SuppressLint({"RestrictedApi"})
    public void b(b bVar) {
        c b2;
        synchronized (this.f) {
            b2 = this.f.b(bVar);
        }
        if (b2 != null && this.k.b(b2.f1193a)) {
            c();
        }
    }

    /* access modifiers changed from: package-private */
    public boolean a() {
        if (!this.c.d()) {
            return false;
        }
        if (!this.j) {
            this.c.b().b();
        }
        if (this.j) {
            return true;
        }
        Log.e("ROOM", "database is not initialized even though it is open");
        return false;
    }

    public void b() {
        if (this.d.compareAndSet(false, true)) {
            this.c.i().execute(this.g);
        }
    }

    public void a(String... strArr) {
        synchronized (this.f) {
            Iterator<Map.Entry<b, c>> it = this.f.iterator();
            while (it.hasNext()) {
                Map.Entry next = it.next();
                if (!((b) next.getKey()).a()) {
                    ((c) next.getValue()).a(strArr);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void b(androidx.f.a.b bVar) {
        if (!bVar.d()) {
            while (true) {
                try {
                    Lock a2 = this.c.a();
                    a2.lock();
                    try {
                        int[] a3 = this.k.a();
                        if (a3 == null) {
                            a2.unlock();
                            return;
                        }
                        int length = a3.length;
                        bVar.a();
                        for (int i2 = 0; i2 < length; i2++) {
                            int i3 = a3[i2];
                            if (i3 == 1) {
                                b(bVar, i2);
                            } else if (i3 == 2) {
                                a(bVar, i2);
                            }
                        }
                        bVar.c();
                        bVar.b();
                        this.k.b();
                        a2.unlock();
                    } catch (Throwable th) {
                        a2.unlock();
                        throw th;
                    }
                } catch (SQLiteException | IllegalStateException e2) {
                    Log.e("ROOM", "Cannot run invalidation tracker. Is the db closed?", e2);
                    return;
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void c() {
        if (this.c.d()) {
            b(this.c.b().b());
        }
    }

    /* compiled from: InvalidationTracker */
    static class c {

        /* renamed from: a  reason: collision with root package name */
        final int[] f1193a;

        /* renamed from: b  reason: collision with root package name */
        final b f1194b;
        private final String[] c;
        private final Set<String> d;

        c(b bVar, int[] iArr, String[] strArr) {
            this.f1194b = bVar;
            this.f1193a = iArr;
            this.c = strArr;
            if (iArr.length == 1) {
                HashSet hashSet = new HashSet();
                hashSet.add(this.c[0]);
                this.d = Collections.unmodifiableSet(hashSet);
                return;
            }
            this.d = null;
        }

        /* access modifiers changed from: package-private */
        public void a(Set<Integer> set) {
            int length = this.f1193a.length;
            Set set2 = null;
            for (int i = 0; i < length; i++) {
                if (set.contains(Integer.valueOf(this.f1193a[i]))) {
                    if (length == 1) {
                        set2 = this.d;
                    } else {
                        if (set2 == null) {
                            set2 = new HashSet(length);
                        }
                        set2.add(this.c[i]);
                    }
                }
            }
            if (set2 != null) {
                this.f1194b.a(set2);
            }
        }

        /* access modifiers changed from: package-private */
        public void a(String[] strArr) {
            Set<String> set = null;
            if (this.c.length == 1) {
                int length = strArr.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        break;
                    } else if (strArr[i].equalsIgnoreCase(this.c[0])) {
                        set = this.d;
                        break;
                    } else {
                        i++;
                    }
                }
            } else {
                HashSet hashSet = new HashSet();
                for (String str : strArr) {
                    String[] strArr2 = this.c;
                    int length2 = strArr2.length;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= length2) {
                            break;
                        }
                        String str2 = strArr2[i2];
                        if (str2.equalsIgnoreCase(str)) {
                            hashSet.add(str2);
                            break;
                        }
                        i2++;
                    }
                }
                if (hashSet.size() > 0) {
                    set = hashSet;
                }
            }
            if (set != null) {
                this.f1194b.a(set);
            }
        }
    }

    /* compiled from: InvalidationTracker */
    public static abstract class b {

        /* renamed from: a  reason: collision with root package name */
        final String[] f1192a;

        public abstract void a(Set<String> set);

        /* access modifiers changed from: package-private */
        public boolean a() {
            return false;
        }

        public b(String[] strArr) {
            this.f1192a = (String[]) Arrays.copyOf(strArr, strArr.length);
        }
    }

    /* compiled from: InvalidationTracker */
    static class a {

        /* renamed from: a  reason: collision with root package name */
        final long[] f1190a;

        /* renamed from: b  reason: collision with root package name */
        final boolean[] f1191b;
        final int[] c;
        boolean d;
        boolean e;

        a(int i) {
            this.f1190a = new long[i];
            this.f1191b = new boolean[i];
            this.c = new int[i];
            Arrays.fill(this.f1190a, 0);
            Arrays.fill(this.f1191b, false);
        }

        /* access modifiers changed from: package-private */
        public boolean a(int... iArr) {
            boolean z;
            synchronized (this) {
                z = false;
                for (int i : iArr) {
                    long j = this.f1190a[i];
                    this.f1190a[i] = 1 + j;
                    if (j == 0) {
                        this.d = true;
                        z = true;
                    }
                }
            }
            return z;
        }

        /* access modifiers changed from: package-private */
        public boolean b(int... iArr) {
            boolean z;
            synchronized (this) {
                z = false;
                for (int i : iArr) {
                    long j = this.f1190a[i];
                    this.f1190a[i] = j - 1;
                    if (j == 1) {
                        this.d = true;
                        z = true;
                    }
                }
            }
            return z;
        }

        /* access modifiers changed from: package-private */
        public int[] a() {
            synchronized (this) {
                if (this.d) {
                    if (!this.e) {
                        int length = this.f1190a.length;
                        int i = 0;
                        while (true) {
                            int i2 = 1;
                            if (i < length) {
                                boolean z = this.f1190a[i] > 0;
                                if (z != this.f1191b[i]) {
                                    int[] iArr = this.c;
                                    if (!z) {
                                        i2 = 2;
                                    }
                                    iArr[i] = i2;
                                } else {
                                    this.c[i] = 0;
                                }
                                this.f1191b[i] = z;
                                i++;
                            } else {
                                this.e = true;
                                this.d = false;
                                int[] iArr2 = this.c;
                                return iArr2;
                            }
                        }
                    }
                }
                return null;
            }
        }

        /* access modifiers changed from: package-private */
        public void b() {
            synchronized (this) {
                this.e = false;
            }
        }
    }
}
