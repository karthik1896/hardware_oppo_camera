package androidx.f.a.a;

import android.database.sqlite.SQLiteProgram;

/* compiled from: FrameworkSQLiteProgram */
class d implements androidx.f.a.d {

    /* renamed from: a  reason: collision with root package name */
    private final SQLiteProgram f822a;

    d(SQLiteProgram sQLiteProgram) {
        this.f822a = sQLiteProgram;
    }

    public void a(int i) {
        this.f822a.bindNull(i);
    }

    public void a(int i, long j) {
        this.f822a.bindLong(i, j);
    }

    public void a(int i, double d) {
        this.f822a.bindDouble(i, d);
    }

    public void a(int i, String str) {
        this.f822a.bindString(i, str);
    }

    public void a(int i, byte[] bArr) {
        this.f822a.bindBlob(i, bArr);
    }

    public void close() {
        this.f822a.close();
    }
}
