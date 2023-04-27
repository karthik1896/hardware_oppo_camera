package com.heytap.tingle.ipc.a;

import android.database.Cursor;
import android.database.MatrixCursor;
import android.os.Bundle;
import android.os.IBinder;

/* compiled from: ProviderCursor */
public class a extends MatrixCursor {

    /* renamed from: a  reason: collision with root package name */
    public static final String[] f2653a = {"col"};

    /* renamed from: b  reason: collision with root package name */
    private static volatile a f2654b = null;
    private Bundle c;

    public Bundle getExtras() {
        return this.c;
    }

    public static IBinder a(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        Bundle extras = cursor.getExtras();
        if (extras != null) {
            return extras.getBinder("IBinder");
        }
        com.heytap.tingle.ipc.d.a.a("ProviderCursor", "Get cursor bundle null.", new Object[0]);
        return null;
    }
}
