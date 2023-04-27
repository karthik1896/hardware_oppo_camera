package com.oppo.camera.entry;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import com.oppo.camera.MyApplication;
import com.oppo.camera.d;
import com.oppo.camera.e;

public class EntryProvider extends ContentProvider implements d {
    c d = null;

    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    public String getType(Uri uri) {
        return null;
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    public boolean onCreate() {
        return true;
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        if (this.d == null) {
            this.d = new c();
            ((MyApplication) getContext().getApplicationContext()).e();
            this.d.a();
            this.d.b();
            this.d.c();
            this.d.d();
            this.d.e();
        }
        String path = uri.getPath();
        e.e("EntryProvider", "query, uri path: " + path);
        if (path == null || !path.contains("static_info")) {
            return null;
        }
        return this.d;
    }
}
