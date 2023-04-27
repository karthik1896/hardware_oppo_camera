package androidx.f.a.a;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQuery;
import android.os.CancellationSignal;
import android.util.Pair;
import androidx.f.a.b;
import androidx.f.a.e;
import androidx.f.a.f;
import java.io.IOException;
import java.util.List;

/* compiled from: FrameworkSQLiteDatabase */
class a implements b {

    /* renamed from: a  reason: collision with root package name */
    private static final String[] f811a = {"", " OR ROLLBACK ", " OR ABORT ", " OR FAIL ", " OR IGNORE ", " OR REPLACE "};

    /* renamed from: b  reason: collision with root package name */
    private static final String[] f812b = new String[0];
    private final SQLiteDatabase c;

    a(SQLiteDatabase sQLiteDatabase) {
        this.c = sQLiteDatabase;
    }

    public f a(String str) {
        return new e(this.c.compileStatement(str));
    }

    public void a() {
        this.c.beginTransaction();
    }

    public void b() {
        this.c.endTransaction();
    }

    public void c() {
        this.c.setTransactionSuccessful();
    }

    public boolean d() {
        return this.c.inTransaction();
    }

    public Cursor b(String str) {
        return a((e) new androidx.f.a.a(str));
    }

    public Cursor a(final e eVar) {
        return this.c.rawQueryWithFactory(new SQLiteDatabase.CursorFactory() {
            public Cursor newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
                eVar.a(new d(sQLiteQuery));
                return new SQLiteCursor(sQLiteCursorDriver, str, sQLiteQuery);
            }
        }, eVar.b(), f812b, (String) null);
    }

    public Cursor a(final e eVar, CancellationSignal cancellationSignal) {
        return this.c.rawQueryWithFactory(new SQLiteDatabase.CursorFactory() {
            public Cursor newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
                eVar.a(new d(sQLiteQuery));
                return new SQLiteCursor(sQLiteCursorDriver, str, sQLiteQuery);
            }
        }, eVar.b(), f812b, (String) null, cancellationSignal);
    }

    public void c(String str) throws SQLException {
        this.c.execSQL(str);
    }

    public boolean e() {
        return this.c.isOpen();
    }

    public String f() {
        return this.c.getPath();
    }

    public List<Pair<String, String>> g() {
        return this.c.getAttachedDbs();
    }

    public void close() throws IOException {
        this.c.close();
    }

    /* access modifiers changed from: package-private */
    public boolean a(SQLiteDatabase sQLiteDatabase) {
        return this.c == sQLiteDatabase;
    }
}
