package com.oppo.camera.sticker.provider;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.text.TextUtils;
import com.oppo.camera.e;
import com.oppo.camera.sticker.a.b;
import com.oppo.camera.sticker.a.c;
import com.oppo.camera.sticker.a.d;
import java.util.ArrayList;
import java.util.List;

public class StickerProvider extends ContentProvider {

    /* renamed from: a  reason: collision with root package name */
    private static final UriMatcher f3673a = new UriMatcher(-1);

    /* renamed from: b  reason: collision with root package name */
    private a f3674b = null;

    public String getType(Uri uri) {
        return null;
    }

    static {
        f3673a.addURI("com.oppo.camera.sticker.db.provider", "sticker_item", 1);
        f3673a.addURI("com.oppo.camera.sticker.db.provider", "sticker_item/#", 2);
        f3673a.addURI("com.oppo.camera.sticker.db.provider", "sticker_category", 3);
        f3673a.addURI("com.oppo.camera.sticker.db.provider", "sticker_category/#", 4);
        f3673a.addURI("com.oppo.camera.sticker.db.provider", "sticker_view", 5);
        f3673a.addURI("com.oppo.camera.sticker.db.provider", "sticker_view/#", 6);
        f3673a.addURI("com.oppo.camera.sticker.db.provider", "multi_info", 7);
        f3673a.addURI("com.oppo.camera.sticker.db.provider", "multi_info/#", 8);
        f3673a.addURI("com.oppo.camera.sticker.db.provider", "animoji_info", 9);
        f3673a.addURI("com.oppo.camera.sticker.db.provider", "animoji_info/#", 10);
    }

    public boolean onCreate() {
        this.f3674b = new a(getContext());
        return true;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        Uri uri2 = uri;
        SQLiteDatabase readableDatabase = this.f3674b.getReadableDatabase();
        String queryParameter = uri.getQueryParameter("limit");
        ArrayList arrayList = new ArrayList();
        SQLiteQueryBuilder sQLiteQueryBuilder = new SQLiteQueryBuilder();
        switch (f3673a.match(uri)) {
            case 1:
                sQLiteQueryBuilder.setTables("sticker_item");
                break;
            case 2:
                sQLiteQueryBuilder.setTables("sticker_item");
                sQLiteQueryBuilder.appendWhere("_id=?");
                arrayList.add(uri.getPathSegments().get(1));
                break;
            case 3:
                sQLiteQueryBuilder.setTables("sticker_category");
                break;
            case 4:
                sQLiteQueryBuilder.setTables("sticker_category");
                sQLiteQueryBuilder.appendWhere("_id=?");
                arrayList.add(uri.getPathSegments().get(1));
                break;
            case 5:
                sQLiteQueryBuilder.setTables("sticker_view");
                break;
            case 6:
                sQLiteQueryBuilder.setTables("sticker_view");
                sQLiteQueryBuilder.appendWhere("_id=?");
                arrayList.add(uri.getPathSegments().get(1));
                break;
            case 7:
                sQLiteQueryBuilder.setTables("multi_info");
                break;
            case 8:
                sQLiteQueryBuilder.setTables("multi_info");
                sQLiteQueryBuilder.appendWhere("_id=?");
                arrayList.add(uri.getPathSegments().get(1));
                break;
            case 9:
                sQLiteQueryBuilder.setTables("animoji_info");
                break;
            case 10:
                sQLiteQueryBuilder.setTables("animoji_info");
                sQLiteQueryBuilder.appendWhere("_id=?");
                arrayList.add(uri.getPathSegments().get(1));
                break;
            default:
                throw new IllegalStateException("query error! unknown uri: " + uri.toString());
        }
        Cursor cursor = null;
        try {
            cursor = sQLiteQueryBuilder.query(readableDatabase, strArr, str, a(arrayList, strArr2), (String) null, (String) null, str2, queryParameter);
            cursor.setNotificationUri(getContext().getContentResolver(), uri);
            return cursor;
        } catch (IllegalStateException e) {
            e.e("StickerProvider", "query exception! e: " + e);
            return cursor;
        }
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        SQLiteDatabase writableDatabase = this.f3674b.getWritableDatabase();
        if (writableDatabase != null) {
            Uri a2 = a(writableDatabase, uri, contentValues);
            a(a2);
            return a2;
        }
        throw new IllegalStateException("insert, couldn't open database for uri: " + uri);
    }

    /* JADX INFO: finally extract failed */
    public int bulkInsert(Uri uri, ContentValues[] contentValuesArr) {
        SQLiteDatabase writableDatabase = this.f3674b.getWritableDatabase();
        if (writableDatabase != null) {
            writableDatabase.beginTransaction();
            int i = 0;
            int i2 = 0;
            while (i < contentValuesArr.length) {
                try {
                    ContentValues contentValues = contentValuesArr[i];
                    if (!(contentValues == null || a(writableDatabase, uri, contentValues) == null)) {
                        i2++;
                    }
                    i++;
                } catch (Throwable th) {
                    writableDatabase.endTransaction();
                    throw th;
                }
            }
            writableDatabase.setTransactionSuccessful();
            writableDatabase.endTransaction();
            a(uri);
            return i2;
        }
        throw new IllegalStateException("bulkInsert couldn't open database for uri: " + uri);
    }

    private Uri a(SQLiteDatabase sQLiteDatabase, Uri uri, ContentValues contentValues) {
        if (contentValues != null) {
            int match = f3673a.match(uri);
            long j = -1;
            if (match != 1) {
                if (match != 3) {
                    if (match == 5) {
                        throw new IllegalStateException("insert exception! Can not insert a row into db View!");
                    } else if (match != 7) {
                        if (match != 9) {
                            e.d("StickerProvider", "insert error! unsupported uri! uri: " + uri);
                        } else if (contentValues.containsKey("uuid")) {
                            j = sQLiteDatabase.insert("animoji_info", (String) null, contentValues);
                        } else {
                            throw new IllegalStateException("insert exception! Attempting to add animoji info without uuid");
                        }
                    } else if (contentValues.containsKey("uuid")) {
                        j = sQLiteDatabase.insert("multi_info", (String) null, contentValues);
                    } else {
                        throw new IllegalStateException("insert exception! Attempting to add multi info without uuid");
                    }
                } else if (contentValues.containsKey("readable_id")) {
                    j = sQLiteDatabase.insert("sticker_category", (String) null, contentValues);
                } else {
                    throw new IllegalStateException("insert exception! Attempting to add sticker category without id");
                }
            } else if (contentValues.containsKey("uuid")) {
                j = sQLiteDatabase.insert("sticker_item", (String) null, contentValues);
            } else {
                throw new IllegalStateException("insert exception! Attempting to add sticker without uuid");
            }
            if (j <= 0) {
                return null;
            }
            return ContentUris.withAppendedId(uri, j);
        }
        throw new IllegalStateException("insert exception! Attempting to insert null values");
    }

    public int delete(Uri uri, String str, String[] strArr) {
        String str2;
        int match = f3673a.match(uri);
        SQLiteDatabase writableDatabase = this.f3674b.getWritableDatabase();
        String str3 = "animoji_info";
        switch (match) {
            case 1:
                str3 = "sticker_item";
                break;
            case 2:
                str2 = "_id=" + uri.getPathSegments().get(1);
                str3 = "sticker_item";
                break;
            case 3:
                str3 = "sticker_category";
                break;
            case 4:
                str2 = "_id=" + uri.getPathSegments().get(1);
                str3 = "sticker_category";
                break;
            case 7:
                str3 = "multi_info";
                break;
            case 8:
                str2 = "_id=" + uri.getPathSegments().get(1);
                str3 = "multi_info";
                break;
            case 9:
                break;
            case 10:
                str2 = "_id=" + uri.getPathSegments().get(1);
                break;
            default:
                throw new IllegalStateException("delete exception! unknown uri: " + uri.toString());
        }
        str2 = null;
        if (TextUtils.isEmpty(str)) {
            str = str2;
        } else if (!TextUtils.isEmpty(str2)) {
            str = str2 + " AND (" + str + ")";
        }
        int i = 0;
        try {
            i = writableDatabase.delete(str3, str, strArr);
            e.b("StickerProvider", "delete count: " + i);
        } catch (Exception e) {
            e.e("StickerProvider", "delete exception! e: " + e);
        }
        if (i > 0) {
            a(uri);
        }
        return i;
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        String str2;
        int match = f3673a.match(uri);
        SQLiteDatabase writableDatabase = this.f3674b.getWritableDatabase();
        String str3 = "animoji_info";
        switch (match) {
            case 1:
                str3 = "sticker_item";
                break;
            case 2:
                str2 = "_id=" + uri.getPathSegments().get(1);
                str3 = "sticker_item";
                break;
            case 3:
                str3 = "sticker_category";
                break;
            case 4:
                str2 = "_id=" + uri.getPathSegments().get(1);
                str3 = "sticker_category";
                break;
            case 7:
                str3 = "multi_info";
                break;
            case 8:
                str2 = "_id=" + uri.getPathSegments().get(1);
                str3 = "multi_info";
                break;
            case 9:
                break;
            case 10:
                str2 = "_id=" + uri.getPathSegments().get(1);
                break;
            default:
                throw new IllegalStateException("update exception! uri: " + uri.toString());
        }
        str2 = null;
        if (TextUtils.isEmpty(str)) {
            str = str2;
        } else if (!TextUtils.isEmpty(str2)) {
            str = str2 + " AND (" + str + ")";
        }
        int i = 0;
        try {
            i = writableDatabase.update(str3, contentValues, str, strArr);
        } catch (Exception e) {
            e.e("StickerProvider", "delete exception! e: " + e);
        }
        if (i > 0) {
            a(uri);
        }
        e.b("StickerProvider", "update, count: " + i + ", uri: " + uri);
        return i;
    }

    private String[] a(List<String> list, String[] strArr) {
        int size = list.size();
        if (size == 0) {
            return strArr;
        }
        int length = strArr != null ? strArr.length : 0;
        String[] strArr2 = new String[(size + length)];
        for (int i = 0; i < size; i++) {
            strArr2[i] = list.get(i);
        }
        for (int i2 = 0; i2 < length; i2++) {
            strArr2[size + i2] = strArr[i2];
        }
        return strArr2;
    }

    private void a(Uri uri) {
        if (uri != null) {
            String queryParameter = uri.getQueryParameter("notify");
            if (queryParameter == null || "true".equals(queryParameter)) {
                getContext().getContentResolver().notifyChange(uri, (ContentObserver) null);
                if (!uri.equals(c.e.f3626a)) {
                    getContext().getContentResolver().notifyChange(c.e.f3626a, (ContentObserver) null);
                }
            }
        }
    }

    private static class a extends SQLiteOpenHelper {
        public a(Context context) {
            super(context, "sticker.db", (SQLiteDatabase.CursorFactory) null, 2);
        }

        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            a(sQLiteDatabase, 0, 2);
        }

        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            a(sQLiteDatabase, i, 2);
        }

        private void a(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            e.b("StickerProvider", "updateDatabase, fromVersion: " + i + ",toVersion: " + i2);
            if (i < i2) {
                if (i < 1) {
                    sQLiteDatabase.execSQL(com.oppo.camera.sticker.a.a.a());
                    sQLiteDatabase.execSQL(b.a());
                    sQLiteDatabase.execSQL(d.a());
                }
                if (i < 2) {
                    sQLiteDatabase.execSQL("alter table sticker_item add material_type INTEGER DEFAULT 0");
                    sQLiteDatabase.execSQL(b.c());
                    sQLiteDatabase.execSQL(b.b());
                    sQLiteDatabase.execSQL("DROP VIEW IF EXISTS sticker_view");
                    sQLiteDatabase.execSQL(d.b());
                }
            }
        }

        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            e.d("StickerProvider", "onDowngrade, oldVersion: " + i + ", newVersion: " + i2);
            a(sQLiteDatabase);
            a(sQLiteDatabase, 0, 2);
        }

        private void a(SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.execSQL("DROP VIEW IF EXISTS sticker_view");
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS sticker_item");
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS sticker_category");
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS multi_info");
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS animoji_info");
            } catch (SQLException e) {
                e.c("StickerProvider", "deleteAllTables, couldn't delete table in downloads database. e: ", e);
            }
        }
    }
}
