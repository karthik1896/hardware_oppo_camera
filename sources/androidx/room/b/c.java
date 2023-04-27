package androidx.room.b;

import android.database.AbstractWindowedCursor;
import android.database.Cursor;
import android.os.Build;
import android.os.CancellationSignal;
import androidx.f.a.b;
import androidx.f.a.e;
import androidx.room.i;
import java.util.ArrayList;

/* compiled from: DBUtil */
public class c {
    public static Cursor a(i iVar, e eVar, boolean z, CancellationSignal cancellationSignal) {
        Cursor a2 = iVar.a(eVar, cancellationSignal);
        if (!z || !(a2 instanceof AbstractWindowedCursor)) {
            return a2;
        }
        AbstractWindowedCursor abstractWindowedCursor = (AbstractWindowedCursor) a2;
        int count = abstractWindowedCursor.getCount();
        return (Build.VERSION.SDK_INT < 23 || (abstractWindowedCursor.hasWindow() ? abstractWindowedCursor.getWindow().getNumRows() : count) < count) ? b.a(abstractWindowedCursor) : a2;
    }

    /* JADX INFO: finally extract failed */
    public static void a(b bVar) {
        ArrayList<String> arrayList = new ArrayList<>();
        Cursor b2 = bVar.b("SELECT name FROM sqlite_master WHERE type = 'trigger'");
        while (b2.moveToNext()) {
            try {
                arrayList.add(b2.getString(0));
            } catch (Throwable th) {
                b2.close();
                throw th;
            }
        }
        b2.close();
        for (String str : arrayList) {
            if (str.startsWith("room_fts_content_sync_")) {
                bVar.c("DROP TRIGGER IF EXISTS " + str);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x003e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int a(java.io.File r10) throws java.io.IOException {
        /*
            r0 = 4
            r1 = 0
            java.nio.ByteBuffer r2 = java.nio.ByteBuffer.allocate(r0)     // Catch:{ all -> 0x003a }
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch:{ all -> 0x003a }
            r3.<init>(r10)     // Catch:{ all -> 0x003a }
            java.nio.channels.FileChannel r10 = r3.getChannel()     // Catch:{ all -> 0x003a }
            r5 = 60
            r7 = 4
            r9 = 1
            r4 = r10
            r4.tryLock(r5, r7, r9)     // Catch:{ all -> 0x0038 }
            r3 = 60
            r10.position(r3)     // Catch:{ all -> 0x0038 }
            int r1 = r10.read(r2)     // Catch:{ all -> 0x0038 }
            if (r1 != r0) goto L_0x0030
            r2.rewind()     // Catch:{ all -> 0x0038 }
            int r0 = r2.getInt()     // Catch:{ all -> 0x0038 }
            if (r10 == 0) goto L_0x002f
            r10.close()
        L_0x002f:
            return r0
        L_0x0030:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x0038 }
            java.lang.String r1 = "Bad database header, unable to read 4 bytes at offset 60"
            r0.<init>(r1)     // Catch:{ all -> 0x0038 }
            throw r0     // Catch:{ all -> 0x0038 }
        L_0x0038:
            r0 = move-exception
            goto L_0x003c
        L_0x003a:
            r0 = move-exception
            r10 = r1
        L_0x003c:
            if (r10 == 0) goto L_0x0041
            r10.close()
        L_0x0041:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.b.c.a(java.io.File):int");
    }
}
