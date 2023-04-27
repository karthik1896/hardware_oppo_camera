package androidx.room;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import android.database.Cursor;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.Looper;
import androidx.f.a.c;
import androidx.f.a.e;
import androidx.f.a.f;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* compiled from: RoomDatabase */
public abstract class i {
    @Deprecated

    /* renamed from: a  reason: collision with root package name */
    protected volatile androidx.f.a.b f1205a;

    /* renamed from: b  reason: collision with root package name */
    boolean f1206b;
    @Deprecated
    protected List<b> c;
    private Executor d;
    private Executor e;
    private androidx.f.a.c f;
    private final f g = c();
    private boolean h;
    private final ReentrantReadWriteLock i = new ReentrantReadWriteLock();
    private final ThreadLocal<Integer> j = new ThreadLocal<>();
    private final Map<String, Object> k = new ConcurrentHashMap();

    /* compiled from: RoomDatabase */
    public static abstract class b {
        public void a(androidx.f.a.b bVar) {
        }

        public void b(androidx.f.a.b bVar) {
        }

        public void c(androidx.f.a.b bVar) {
        }
    }

    /* access modifiers changed from: protected */
    public abstract androidx.f.a.c b(a aVar);

    /* access modifiers changed from: protected */
    public abstract f c();

    /* access modifiers changed from: package-private */
    public Lock a() {
        return this.i.readLock();
    }

    public void a(a aVar) {
        this.f = b(aVar);
        androidx.f.a.c cVar = this.f;
        if (cVar instanceof m) {
            ((m) cVar).a(aVar);
        }
        boolean z = false;
        if (Build.VERSION.SDK_INT >= 16) {
            if (aVar.g == c.WRITE_AHEAD_LOGGING) {
                z = true;
            }
            this.f.a(z);
        }
        this.c = aVar.e;
        this.d = aVar.h;
        this.e = new p(aVar.i);
        this.h = aVar.f;
        this.f1206b = z;
        if (aVar.j) {
            this.g.a(aVar.f1170b, aVar.c);
        }
    }

    public androidx.f.a.c b() {
        return this.f;
    }

    public boolean d() {
        androidx.f.a.b bVar = this.f1205a;
        return bVar != null && bVar.e();
    }

    public void e() {
        if (!this.h && l()) {
            throw new IllegalStateException("Cannot access database on the main thread since it may potentially lock the UI for a long period of time.");
        }
    }

    public void f() {
        if (!k() && this.j.get() != null) {
            throw new IllegalStateException("Cannot access database on a different coroutine context inherited from a suspending transaction.");
        }
    }

    public Cursor a(e eVar) {
        return a(eVar, (CancellationSignal) null);
    }

    public Cursor a(e eVar, CancellationSignal cancellationSignal) {
        e();
        f();
        if (cancellationSignal == null || Build.VERSION.SDK_INT < 16) {
            return this.f.b().a(eVar);
        }
        return this.f.b().a(eVar, cancellationSignal);
    }

    public f a(String str) {
        e();
        f();
        return this.f.b().a(str);
    }

    @Deprecated
    public void g() {
        e();
        androidx.f.a.b b2 = this.f.b();
        this.g.b(b2);
        b2.a();
    }

    @Deprecated
    public void h() {
        this.f.b().b();
        if (!k()) {
            this.g.b();
        }
    }

    public Executor i() {
        return this.d;
    }

    @Deprecated
    public void j() {
        this.f.b().c();
    }

    /* access modifiers changed from: protected */
    public void a(androidx.f.a.b bVar) {
        this.g.a(bVar);
    }

    public boolean k() {
        return this.f.b().d();
    }

    /* compiled from: RoomDatabase */
    public enum c {
        AUTOMATIC,
        TRUNCATE,
        WRITE_AHEAD_LOGGING;

        /* access modifiers changed from: package-private */
        @SuppressLint({"NewApi"})
        public c resolve(Context context) {
            ActivityManager activityManager;
            if (this != AUTOMATIC) {
                return this;
            }
            if (Build.VERSION.SDK_INT < 16 || (activityManager = (ActivityManager) context.getSystemService("activity")) == null || isLowRamDevice(activityManager)) {
                return TRUNCATE;
            }
            return WRITE_AHEAD_LOGGING;
        }

        private static boolean isLowRamDevice(ActivityManager activityManager) {
            if (Build.VERSION.SDK_INT >= 19) {
                return activityManager.isLowRamDevice();
            }
            return false;
        }
    }

    /* compiled from: RoomDatabase */
    public static class a<T extends i> {

        /* renamed from: a  reason: collision with root package name */
        private final Class<T> f1207a;

        /* renamed from: b  reason: collision with root package name */
        private final String f1208b;
        private final Context c;
        private ArrayList<b> d;
        private Executor e;
        private Executor f;
        private c.C0029c g;
        private boolean h;
        private c i = c.AUTOMATIC;
        private boolean j;
        private boolean k = true;
        private boolean l;
        private final d m = new d();
        private Set<Integer> n;
        private Set<Integer> o;
        private String p;
        private File q;

        a(Context context, Class<T> cls, String str) {
            this.c = context;
            this.f1207a = cls;
            this.f1208b = str;
        }

        public a<T> a() {
            this.h = true;
            return this;
        }

        @SuppressLint({"RestrictedApi"})
        public T b() {
            Executor executor;
            if (this.c == null) {
                throw new IllegalArgumentException("Cannot provide null context for the database.");
            } else if (this.f1207a != null) {
                if (this.e == null && this.f == null) {
                    Executor b2 = androidx.a.a.a.a.b();
                    this.f = b2;
                    this.e = b2;
                } else {
                    Executor executor2 = this.e;
                    if (executor2 != null && this.f == null) {
                        this.f = executor2;
                    } else if (this.e == null && (executor = this.f) != null) {
                        this.e = executor;
                    }
                }
                Set<Integer> set = this.o;
                if (!(set == null || this.n == null)) {
                    for (Integer next : set) {
                        if (this.n.contains(next)) {
                            throw new IllegalArgumentException("Inconsistency detected. A Migration was supplied to addMigration(Migration... migrations) that has a start or end version equal to a start version supplied to fallbackToDestructiveMigrationFrom(int... startVersions). Start version: " + next);
                        }
                    }
                }
                if (this.g == null) {
                    this.g = new androidx.f.a.a.c();
                }
                if (!(this.p == null && this.q == null)) {
                    if (this.f1208b == null) {
                        throw new IllegalArgumentException("Cannot create from asset or file for an in-memory database.");
                    } else if (this.p == null || this.q == null) {
                        this.g = new n(this.p, this.q, this.g);
                    } else {
                        throw new IllegalArgumentException("Both createFromAsset() and createFromFile() was called on this Builder but the database can only be created using one of the two configurations.");
                    }
                }
                Context context = this.c;
                String str = this.f1208b;
                c.C0029c cVar = this.g;
                d dVar = this.m;
                ArrayList<b> arrayList = this.d;
                boolean z = this.h;
                c resolve = this.i.resolve(context);
                Executor executor3 = this.e;
                Executor executor4 = this.f;
                boolean z2 = this.j;
                boolean z3 = this.k;
                boolean z4 = this.l;
                boolean z5 = z3;
                boolean z6 = z4;
                a aVar = new a(context, str, cVar, dVar, arrayList, z, resolve, executor3, executor4, z2, z5, z6, this.n, this.p, this.q);
                T t = (i) h.a(this.f1207a, "_Impl");
                t.a(aVar);
                return t;
            } else {
                throw new IllegalArgumentException("Must provide an abstract class that extends RoomDatabase");
            }
        }
    }

    /* compiled from: RoomDatabase */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        private HashMap<Integer, TreeMap<Integer, androidx.room.a.a>> f1209a = new HashMap<>();

        public List<androidx.room.a.a> a(int i, int i2) {
            if (i == i2) {
                return Collections.emptyList();
            }
            return a(new ArrayList(), i2 > i, i, i2);
        }

        private List<androidx.room.a.a> a(List<androidx.room.a.a> list, boolean z, int i, int i2) {
            Set set;
            boolean z2;
            do {
                if (z) {
                    if (i >= i2) {
                        return list;
                    }
                } else if (i <= i2) {
                    return list;
                }
                TreeMap treeMap = this.f1209a.get(Integer.valueOf(i));
                if (treeMap != null) {
                    if (z) {
                        set = treeMap.descendingKeySet();
                    } else {
                        set = treeMap.keySet();
                    }
                    Iterator it = set.iterator();
                    while (true) {
                        z2 = true;
                        boolean z3 = false;
                        if (!it.hasNext()) {
                            z2 = false;
                            continue;
                            break;
                        }
                        int intValue = ((Integer) it.next()).intValue();
                        if (!z ? !(intValue < i2 || intValue >= i) : !(intValue > i2 || intValue <= i)) {
                            z3 = true;
                            continue;
                        }
                        if (z3) {
                            list.add(treeMap.get(Integer.valueOf(intValue)));
                            i = intValue;
                            continue;
                            break;
                        }
                    }
                } else {
                    return null;
                }
            } while (z2);
            return null;
        }
    }

    private static boolean l() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }
}
