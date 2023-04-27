package com.heytap.shield.authcode.dao;

import androidx.f.a.b;
import androidx.f.a.c;
import androidx.room.a;
import androidx.room.b.e;
import androidx.room.f;
import androidx.room.i;
import androidx.room.k;
import com.oppo.camera.statistics.model.EnterExitDcsMsgData;
import java.util.HashMap;
import java.util.HashSet;

public final class AuthenticationDb_Impl extends AuthenticationDb {
    private volatile a d;

    /* access modifiers changed from: protected */
    public c b(a aVar) {
        return aVar.f1169a.a(c.b.a(aVar.f1170b).a(aVar.c).a((c.a) new k(aVar, new k.a(1) {
            public void h(b bVar) {
            }

            public void b(b bVar) {
                bVar.c("CREATE TABLE IF NOT EXISTS `a_e` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `auth_code` TEXT, `is_enable` INTEGER NOT NULL, `uid` INTEGER NOT NULL, `packageName` TEXT, `capability_name` TEXT, `expiration` INTEGER NOT NULL, `permission` BLOB, `last_update_time` INTEGER NOT NULL, `cache_time` INTEGER NOT NULL)");
                bVar.c("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
                bVar.c("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '4900734c010240a846af4887983ab420')");
            }

            public void a(b bVar) {
                bVar.c("DROP TABLE IF EXISTS `a_e`");
                if (AuthenticationDb_Impl.this.c != null) {
                    int size = AuthenticationDb_Impl.this.c.size();
                    for (int i = 0; i < size; i++) {
                        ((i.b) AuthenticationDb_Impl.this.c.get(i)).c(bVar);
                    }
                }
            }

            /* access modifiers changed from: protected */
            public void d(b bVar) {
                if (AuthenticationDb_Impl.this.c != null) {
                    int size = AuthenticationDb_Impl.this.c.size();
                    for (int i = 0; i < size; i++) {
                        ((i.b) AuthenticationDb_Impl.this.c.get(i)).a(bVar);
                    }
                }
            }

            public void c(b bVar) {
                b unused = AuthenticationDb_Impl.this.f1205a = bVar;
                AuthenticationDb_Impl.this.a(bVar);
                if (AuthenticationDb_Impl.this.c != null) {
                    int size = AuthenticationDb_Impl.this.c.size();
                    for (int i = 0; i < size; i++) {
                        ((i.b) AuthenticationDb_Impl.this.c.get(i)).b(bVar);
                    }
                }
            }

            public void g(b bVar) {
                androidx.room.b.c.a(bVar);
            }

            /* access modifiers changed from: protected */
            public k.b f(b bVar) {
                HashMap hashMap = new HashMap(10);
                hashMap.put("id", new e.a("id", "INTEGER", true, 1, (String) null, 1));
                hashMap.put("auth_code", new e.a("auth_code", "TEXT", false, 0, (String) null, 1));
                hashMap.put("is_enable", new e.a("is_enable", "INTEGER", true, 0, (String) null, 1));
                hashMap.put("uid", new e.a("uid", "INTEGER", true, 0, (String) null, 1));
                hashMap.put("packageName", new e.a("packageName", "TEXT", false, 0, (String) null, 1));
                hashMap.put("capability_name", new e.a("capability_name", "TEXT", false, 0, (String) null, 1));
                hashMap.put("expiration", new e.a("expiration", "INTEGER", true, 0, (String) null, 1));
                hashMap.put(EnterExitDcsMsgData.EVENT_PERMISSION, new e.a(EnterExitDcsMsgData.EVENT_PERMISSION, "BLOB", false, 0, (String) null, 1));
                hashMap.put("last_update_time", new e.a("last_update_time", "INTEGER", true, 0, (String) null, 1));
                hashMap.put("cache_time", new e.a("cache_time", "INTEGER", true, 0, (String) null, 1));
                e eVar = new e("a_e", hashMap, new HashSet(0), new HashSet(0));
                e a2 = e.a(bVar, "a_e");
                if (eVar.equals(a2)) {
                    return new k.b(true, (String) null);
                }
                return new k.b(false, "a_e(com.heytap.shield.authcode.dao.AuthenticationDbBean).\n Expected:\n" + eVar + "\n Found:\n" + a2);
            }
        }, "4900734c010240a846af4887983ab420", "bcb6b006fd96cb6cf4245dc2a4b99c48")).a());
    }

    /* access modifiers changed from: protected */
    public f c() {
        return new f(this, new HashMap(0), new HashMap(0), "a_e");
    }

    public a l() {
        a aVar;
        if (this.d != null) {
            return this.d;
        }
        synchronized (this) {
            if (this.d == null) {
                this.d = new b(this);
            }
            aVar = this.d;
        }
        return aVar;
    }
}
