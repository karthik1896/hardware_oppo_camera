package com.heytap.shield.authcode.dao;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.f.a.f;
import androidx.room.b.c;
import androidx.room.i;
import androidx.room.l;
import androidx.room.o;
import com.oppo.camera.statistics.model.EnterExitDcsMsgData;

/* compiled from: AuthenticationDao_Impl */
public final class b implements a {

    /* renamed from: a  reason: collision with root package name */
    private final i f2637a;

    /* renamed from: b  reason: collision with root package name */
    private final androidx.room.b<c> f2638b;
    private final o c;
    private final o d;

    public b(i iVar) {
        this.f2637a = iVar;
        this.f2638b = new androidx.room.b<c>(iVar) {
            public String a() {
                return "INSERT OR REPLACE INTO `a_e` (`id`,`auth_code`,`is_enable`,`uid`,`packageName`,`capability_name`,`expiration`,`permission`,`last_update_time`,`cache_time`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?)";
            }

            public void a(f fVar, c cVar) {
                fVar.a(1, (long) cVar.a());
                if (cVar.b() == null) {
                    fVar.a(2);
                } else {
                    fVar.a(2, cVar.b());
                }
                fVar.a(3, cVar.c() ? 1 : 0);
                fVar.a(4, (long) cVar.d());
                if (cVar.e() == null) {
                    fVar.a(5);
                } else {
                    fVar.a(5, cVar.e());
                }
                if (cVar.f() == null) {
                    fVar.a(6);
                } else {
                    fVar.a(6, cVar.f());
                }
                fVar.a(7, cVar.g());
                if (cVar.h() == null) {
                    fVar.a(8);
                } else {
                    fVar.a(8, cVar.h());
                }
                fVar.a(9, cVar.i());
                fVar.a(10, cVar.j());
            }
        };
        this.c = new o(iVar) {
            public String a() {
                return "DELETE from a_e WHERE a_e.uid = (?)AND a_e.capability_name = (?)AND a_e.auth_code = (?)";
            }
        };
        this.d = new o(iVar) {
            public String a() {
                return "DELETE from a_e";
            }
        };
    }

    public void a(c cVar) {
        this.f2637a.f();
        this.f2637a.g();
        try {
            this.f2638b.a(cVar);
            this.f2637a.j();
        } finally {
            this.f2637a.h();
        }
    }

    public c a(int i, String str, String str2, String str3) {
        String str4 = str;
        String str5 = str2;
        String str6 = str3;
        l a2 = l.a("SELECT * FROM a_e WHERE a_e.uid = (?)AND a_e.packageName = (?)AND a_e.capability_name = (?)AND a_e.auth_code = (?)", 4);
        a2.a(1, (long) i);
        if (str4 == null) {
            a2.a(2);
        } else {
            a2.a(2, str4);
        }
        if (str5 == null) {
            a2.a(3);
        } else {
            a2.a(3, str5);
        }
        if (str6 == null) {
            a2.a(4);
        } else {
            a2.a(4, str6);
        }
        this.f2637a.f();
        c cVar = null;
        Cursor a3 = c.a(this.f2637a, a2, false, (CancellationSignal) null);
        try {
            int a4 = androidx.room.b.b.a(a3, "id");
            int a5 = androidx.room.b.b.a(a3, "auth_code");
            int a6 = androidx.room.b.b.a(a3, "is_enable");
            int a7 = androidx.room.b.b.a(a3, "uid");
            int a8 = androidx.room.b.b.a(a3, "packageName");
            int a9 = androidx.room.b.b.a(a3, "capability_name");
            int a10 = androidx.room.b.b.a(a3, "expiration");
            int a11 = androidx.room.b.b.a(a3, EnterExitDcsMsgData.EVENT_PERMISSION);
            int a12 = androidx.room.b.b.a(a3, "last_update_time");
            int a13 = androidx.room.b.b.a(a3, "cache_time");
            if (a3.moveToFirst()) {
                cVar = new c(a3.getString(a5), a3.getInt(a6) != 0, a3.getInt(a7), a3.getString(a8), a3.getString(a9), a3.getLong(a10), a3.getBlob(a11), a3.getLong(a12), a3.getLong(a13));
                cVar.a(a3.getInt(a4));
            }
            return cVar;
        } finally {
            a3.close();
            a2.a();
        }
    }
}
