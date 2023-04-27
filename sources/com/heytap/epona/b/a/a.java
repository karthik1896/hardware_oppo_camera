package com.heytap.epona.b.a;

import android.database.Cursor;
import android.database.MatrixCursor;
import android.os.Bundle;

/* compiled from: ProviderCursor */
public class a extends MatrixCursor {

    /* renamed from: a  reason: collision with root package name */
    public static final String[] f2580a = {"col"};

    /* renamed from: b  reason: collision with root package name */
    private Bundle f2581b;

    public Bundle getExtras() {
        return this.f2581b;
    }

    public static Bundle a(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        return cursor.getExtras();
    }
}
