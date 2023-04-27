package androidx.f.a.a;

import android.database.sqlite.SQLiteStatement;
import androidx.f.a.f;

/* compiled from: FrameworkSQLiteStatement */
class e extends d implements f {

    /* renamed from: a  reason: collision with root package name */
    private final SQLiteStatement f823a;

    e(SQLiteStatement sQLiteStatement) {
        super(sQLiteStatement);
        this.f823a = sQLiteStatement;
    }

    public int a() {
        return this.f823a.executeUpdateDelete();
    }

    public long b() {
        return this.f823a.executeInsert();
    }
}
