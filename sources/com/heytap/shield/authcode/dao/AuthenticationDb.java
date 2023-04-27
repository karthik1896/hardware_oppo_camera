package com.heytap.shield.authcode.dao;

import android.content.Context;
import androidx.room.h;
import androidx.room.i;

public abstract class AuthenticationDb extends i {
    private static volatile AuthenticationDb d;

    public abstract a l();

    public static AuthenticationDb a(Context context) {
        if (d == null) {
            synchronized (AuthenticationDb.class) {
                if (d == null) {
                    d = h.a(context.getApplicationContext(), AuthenticationDb.class, "authentication.db").a().b();
                }
            }
        }
        return d;
    }
}
