package androidx.room;

import android.database.Cursor;
import androidx.f.a.c;
import androidx.f.a.e;
import java.util.List;

/* compiled from: RoomOpenHelper */
public class k extends c.a {

    /* renamed from: b  reason: collision with root package name */
    private a f1210b;
    private final a c;
    private final String d;
    private final String e;

    public k(a aVar, a aVar2, String str, String str2) {
        super(aVar2.f1211a);
        this.f1210b = aVar;
        this.c = aVar2;
        this.d = str;
        this.e = str2;
    }

    public void a(androidx.f.a.b bVar) {
        super.a(bVar);
    }

    public void b(androidx.f.a.b bVar) {
        boolean i = i(bVar);
        this.c.b(bVar);
        if (!i) {
            b f = this.c.f(bVar);
            if (!f.f1212a) {
                throw new IllegalStateException("Pre-packaged database has an invalid schema: " + f.f1213b);
            }
        }
        f(bVar);
        this.c.d(bVar);
    }

    public void a(androidx.f.a.b bVar, int i, int i2) {
        boolean z;
        List<androidx.room.a.a> a2;
        a aVar = this.f1210b;
        if (aVar == null || (a2 = aVar.d.a(i, i2)) == null) {
            z = false;
        } else {
            this.c.g(bVar);
            for (androidx.room.a.a a3 : a2) {
                a3.a(bVar);
            }
            b f = this.c.f(bVar);
            if (f.f1212a) {
                this.c.h(bVar);
                f(bVar);
                z = true;
            } else {
                throw new IllegalStateException("Migration didn't properly handle: " + f.f1213b);
            }
        }
        if (!z) {
            a aVar2 = this.f1210b;
            if (aVar2 == null || aVar2.a(i, i2)) {
                throw new IllegalStateException("A migration from " + i + " to " + i2 + " was required but not found. Please provide the necessary Migration path via RoomDatabase.Builder.addMigration(Migration ...) or allow for destructive migrations via one of the RoomDatabase.Builder.fallbackToDestructiveMigration* methods.");
            }
            this.c.a(bVar);
            this.c.b(bVar);
        }
    }

    public void b(androidx.f.a.b bVar, int i, int i2) {
        a(bVar, i, i2);
    }

    public void c(androidx.f.a.b bVar) {
        super.c(bVar);
        e(bVar);
        this.c.c(bVar);
        this.f1210b = null;
    }

    /* JADX INFO: finally extract failed */
    private void e(androidx.f.a.b bVar) {
        if (h(bVar)) {
            String str = null;
            Cursor a2 = bVar.a((e) new androidx.f.a.a("SELECT identity_hash FROM room_master_table WHERE id = 42 LIMIT 1"));
            try {
                if (a2.moveToFirst()) {
                    str = a2.getString(0);
                }
                a2.close();
                if (!this.d.equals(str) && !this.e.equals(str)) {
                    throw new IllegalStateException("Room cannot verify the data integrity. Looks like you've changed schema but forgot to update the version number. You can simply fix this by increasing the version number.");
                }
            } catch (Throwable th) {
                a2.close();
                throw th;
            }
        } else {
            b f = this.c.f(bVar);
            if (f.f1212a) {
                this.c.h(bVar);
                f(bVar);
                return;
            }
            throw new IllegalStateException("Pre-packaged database has an invalid schema: " + f.f1213b);
        }
    }

    private void f(androidx.f.a.b bVar) {
        g(bVar);
        bVar.c(j.a(this.d));
    }

    private void g(androidx.f.a.b bVar) {
        bVar.c("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
    }

    private static boolean h(androidx.f.a.b bVar) {
        Cursor b2 = bVar.b("SELECT 1 FROM sqlite_master WHERE type = 'table' AND name='room_master_table'");
        try {
            boolean z = false;
            if (b2.moveToFirst() && b2.getInt(0) != 0) {
                z = true;
            }
            return z;
        } finally {
            b2.close();
        }
    }

    private static boolean i(androidx.f.a.b bVar) {
        Cursor b2 = bVar.b("SELECT count(*) FROM sqlite_master WHERE name != 'android_metadata'");
        try {
            boolean z = false;
            if (b2.moveToFirst() && b2.getInt(0) == 0) {
                z = true;
            }
            return z;
        } finally {
            b2.close();
        }
    }

    /* compiled from: RoomOpenHelper */
    public static abstract class a {

        /* renamed from: a  reason: collision with root package name */
        public final int f1211a;

        /* access modifiers changed from: protected */
        public abstract void a(androidx.f.a.b bVar);

        /* access modifiers changed from: protected */
        public abstract void b(androidx.f.a.b bVar);

        /* access modifiers changed from: protected */
        public abstract void c(androidx.f.a.b bVar);

        /* access modifiers changed from: protected */
        public abstract void d(androidx.f.a.b bVar);

        /* access modifiers changed from: protected */
        public void g(androidx.f.a.b bVar) {
        }

        /* access modifiers changed from: protected */
        public void h(androidx.f.a.b bVar) {
        }

        public a(int i) {
            this.f1211a = i;
        }

        /* access modifiers changed from: protected */
        @Deprecated
        public void e(androidx.f.a.b bVar) {
            throw new UnsupportedOperationException("validateMigration is deprecated");
        }

        /* access modifiers changed from: protected */
        public b f(androidx.f.a.b bVar) {
            e(bVar);
            return new b(true, (String) null);
        }
    }

    /* compiled from: RoomOpenHelper */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public final boolean f1212a;

        /* renamed from: b  reason: collision with root package name */
        public final String f1213b;

        public b(boolean z, String str) {
            this.f1212a = z;
            this.f1213b = str;
        }
    }
}
