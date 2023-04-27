package com.oppo.camera.sticker;

import android.content.Context;
import android.database.Cursor;
import com.oppo.camera.sticker.a.c;
import com.oppo.camera.sticker.data.StickerCategoryItem;

/* compiled from: StickerCategoryDBHelper */
public class e {
    private static String[] a() {
        return new String[]{"_id", "category_id", "category_name", "category_position", "category_icon_file_uri", "category_highlight_icon_file_uri", "category_is_new", "category_request_time"};
    }

    public static StickerCategoryItem a(Cursor cursor) {
        StickerCategoryItem stickerCategoryItem = new StickerCategoryItem();
        boolean z = true;
        stickerCategoryItem.setReadableId(cursor.getString(1));
        stickerCategoryItem.setCategoryName(cursor.getString(2));
        stickerCategoryItem.setPosition(cursor.getInt(3));
        stickerCategoryItem.setIconFileUri(cursor.getString(4));
        stickerCategoryItem.setIconHighlightFileUri(cursor.getString(5));
        if (cursor.getInt(6) == 0) {
            z = false;
        }
        stickerCategoryItem.setCategoryNew(z);
        stickerCategoryItem.setLastRequestTime(cursor.getLong(7));
        return stickerCategoryItem;
    }

    public static Cursor a(Context context, long j) {
        return a(context, c.e.f3626a, a(), "attribute & " + j + " = " + j + ") GROUP BY (" + "category_id", (String[]) null, "category_position ASC");
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0033 A[Catch:{ all -> 0x0068 }] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0042 A[SYNTHETIC, Splitter:B:24:0x0042] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0051 A[Catch:{ RemoteException -> 0x004f }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x006b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.database.Cursor a(android.content.Context r10, android.net.Uri r11, java.lang.String[] r12, java.lang.String r13, java.lang.String[] r14, java.lang.String r15) {
        /*
            java.lang.String r0 = "StickerCategoryDBHelper"
            r1 = 0
            android.content.ContentResolver r2 = r10.getContentResolver()     // Catch:{ RemoteException -> 0x002a, all -> 0x0027 }
            android.net.Uri r3 = com.oppo.camera.sticker.a.c.C0095c.f3622a     // Catch:{ RemoteException -> 0x002a, all -> 0x0027 }
            android.content.ContentProviderClient r2 = r2.acquireUnstableContentProviderClient(r3)     // Catch:{ RemoteException -> 0x002a, all -> 0x0027 }
            if (r2 == 0) goto L_0x001c
            r4 = r2
            r5 = r11
            r6 = r12
            r7 = r13
            r8 = r14
            r9 = r15
            android.database.Cursor r1 = r4.query(r5, r6, r7, r8, r9)     // Catch:{ RemoteException -> 0x001a }
            goto L_0x0021
        L_0x001a:
            r11 = move-exception
            goto L_0x002c
        L_0x001c:
            java.lang.String r11 = "getUnstableContentProviderCursor, client is null"
            com.oppo.camera.e.d(r0, r11)     // Catch:{ RemoteException -> 0x001a }
        L_0x0021:
            if (r2 == 0) goto L_0x0063
            r2.close()
            goto L_0x0063
        L_0x0027:
            r10 = move-exception
            r2 = r1
            goto L_0x0069
        L_0x002a:
            r11 = move-exception
            r2 = r1
        L_0x002c:
            java.lang.String r3 = "getUnstableContentProviderCursor, RemoteException! e: "
            com.oppo.camera.e.c(r0, r3, r11)     // Catch:{ all -> 0x0068 }
            if (r2 == 0) goto L_0x0036
            r2.close()     // Catch:{ all -> 0x0068 }
        L_0x0036:
            android.content.ContentResolver r10 = r10.getContentResolver()     // Catch:{ RemoteException -> 0x0057 }
            android.net.Uri r11 = com.oppo.camera.sticker.a.c.C0095c.f3622a     // Catch:{ RemoteException -> 0x0057 }
            android.content.ContentProviderClient r10 = r10.acquireUnstableContentProviderClient(r11)     // Catch:{ RemoteException -> 0x0057 }
            if (r10 == 0) goto L_0x0051
            android.net.Uri r4 = com.oppo.camera.sticker.a.c.C0095c.f3622a     // Catch:{ RemoteException -> 0x004f }
            r3 = r10
            r5 = r12
            r6 = r13
            r7 = r14
            r8 = r15
            android.database.Cursor r11 = r3.query(r4, r5, r6, r7, r8)     // Catch:{ RemoteException -> 0x004f }
            r1 = r11
            goto L_0x005e
        L_0x004f:
            r11 = move-exception
            goto L_0x0059
        L_0x0051:
            java.lang.String r11 = "getUnstableContentProviderCursor2, client is null"
            com.oppo.camera.e.d(r0, r11)     // Catch:{ RemoteException -> 0x004f }
            goto L_0x005e
        L_0x0057:
            r11 = move-exception
            r10 = r2
        L_0x0059:
            java.lang.String r12 = "getUnstableContentProviderCursor, RemoteException again! "
            com.oppo.camera.e.c(r0, r12, r11)     // Catch:{ all -> 0x0064 }
        L_0x005e:
            if (r10 == 0) goto L_0x0063
            r10.close()
        L_0x0063:
            return r1
        L_0x0064:
            r11 = move-exception
            r2 = r10
            r10 = r11
            goto L_0x0069
        L_0x0068:
            r10 = move-exception
        L_0x0069:
            if (r2 == 0) goto L_0x006e
            r2.close()
        L_0x006e:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.sticker.e.a(android.content.Context, android.net.Uri, java.lang.String[], java.lang.String, java.lang.String[], java.lang.String):android.database.Cursor");
    }
}
