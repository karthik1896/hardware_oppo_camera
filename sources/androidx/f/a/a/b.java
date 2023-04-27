package androidx.f.a.a;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.f.a.c;

/* compiled from: FrameworkSQLiteOpenHelper */
class b implements c {

    /* renamed from: a  reason: collision with root package name */
    private final a f817a;

    b(Context context, String str, c.a aVar) {
        this.f817a = a(context, str, aVar);
    }

    private a a(Context context, String str, c.a aVar) {
        return new a(context, str, new a[1], aVar);
    }

    public String a() {
        return this.f817a.getDatabaseName();
    }

    public void a(boolean z) {
        this.f817a.setWriteAheadLoggingEnabled(z);
    }

    public androidx.f.a.b b() {
        return this.f817a.a();
    }

    /* compiled from: FrameworkSQLiteOpenHelper */
    static class a extends SQLiteOpenHelper {

        /* renamed from: a  reason: collision with root package name */
        final a[] f818a;

        /* renamed from: b  reason: collision with root package name */
        final c.a f819b;
        private boolean c;

        a(Context context, String str, final a[] aVarArr, final c.a aVar) {
            super(context, str, (SQLiteDatabase.CursorFactory) null, aVar.f824a, new DatabaseErrorHandler() {
                public void onCorruption(SQLiteDatabase sQLiteDatabase) {
                    c.a.this.d(a.a(aVarArr, sQLiteDatabase));
                }
            });
            this.f819b = aVar;
            this.f818a = aVarArr;
        }

        /* access modifiers changed from: package-private */
        public synchronized androidx.f.a.b a() {
            this.c = false;
            SQLiteDatabase writableDatabase = super.getWritableDatabase();
            if (this.c) {
                close();
                return a();
            }
            return a(writableDatabase);
        }

        /* access modifiers changed from: package-private */
        public a a(SQLiteDatabase sQLiteDatabase) {
            return a(this.f818a, sQLiteDatabase);
        }

        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            this.f819b.b(a(sQLiteDatabase));
        }

        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            this.c = true;
            this.f819b.a(a(sQLiteDatabase), i, i2);
        }

        public void onConfigure(SQLiteDatabase sQLiteDatabase) {
            this.f819b.a((androidx.f.a.b) a(sQLiteDatabase));
        }

        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            this.c = true;
            this.f819b.b(a(sQLiteDatabase), i, i2);
        }

        public void onOpen(SQLiteDatabase sQLiteDatabase) {
            if (!this.c) {
                this.f819b.c(a(sQLiteDatabase));
            }
        }

        public synchronized void close() {
            super.close();
            this.f818a[0] = null;
        }

        static a a(a[] aVarArr, SQLiteDatabase sQLiteDatabase) {
            a aVar = aVarArr[0];
            if (aVar == null || !aVar.a(sQLiteDatabase)) {
                aVarArr[0] = new a(sQLiteDatabase);
            }
            return aVarArr[0];
        }
    }
}
