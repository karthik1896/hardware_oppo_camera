package com.oppo.camera.sticker.a;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import com.oppo.camera.e;
import com.oppo.camera.sticker.a.c;
import com.oppo.camera.sticker.data.StickerCategoryItem;
import com.oppo.camera.sticker.data.StickerCategoryItemWrapper;
import java.util.ArrayList;
import java.util.List;

/* compiled from: StickerCategoryTableHelper */
public class a {
    public static String a() {
        return "CREATE TABLE IF NOT EXISTS sticker_category (_id INTEGER PRIMARY KEY, readable_id TEXT UNIQUE, category_name TEXT, position INTEGER, icon_url TEXT, icon_md5 TEXT, icon_path TEXT, icon_file_uri TEXT, icon_highlight_url TEXT, icon_highlight_md5 TEXT, icon_highlight_path TEXT, icon_highlight_file_uri TEXT, is_new INTEGER DEFAULT 0, request_time INTEGER, is_valid INTEGER DEFAULT 1);";
    }

    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0115, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0117, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0118, code lost:
        r10 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0119, code lost:
        r1 = r0;
        r19 = r4;
        r2 = r10;
        r10 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0121, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0122, code lost:
        r1 = r0;
        r19 = r4;
        r10 = r16;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0121 A[ExcHandler: Throwable (r0v17 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:11:0x005d] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x01dc A[SYNTHETIC, Splitter:B:64:0x01dc] */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x01ec  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(android.content.Context r19, com.oppo.camera.sticker.data.StickerCategoryItemWrapper r20) {
        /*
            r1 = r20
            java.lang.String r2 = "StickerCategoryTableHelper"
            if (r19 == 0) goto L_0x0220
            if (r1 != 0) goto L_0x000a
            goto L_0x0220
        L_0x000a:
            android.content.ContentResolver r0 = r19.getContentResolver()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "readable_id = \""
            r4.append(r5)
            java.lang.String r5 = r20.getReadableId()
            r4.append(r5)
            java.lang.String r5 = "\""
            r4.append(r5)
            java.lang.String r10 = r4.toString()
            android.net.Uri r11 = com.oppo.camera.sticker.a.c.C0095c.f3622a
            android.content.ContentValues r12 = new android.content.ContentValues
            r12.<init>()
            r6 = 0
            r8 = 0
            r9 = 0
            r4 = r0
            r5 = r11
            r7 = r10
            android.database.Cursor r4 = r4.query(r5, r6, r7, r8, r9)     // Catch:{ Exception -> 0x01fe }
            java.lang.String r5 = "position"
            java.lang.String r6 = "icon_highlight_md5"
            java.lang.String r7 = "icon_highlight_file_uri"
            java.lang.String r8 = "icon_highlight_path"
            java.lang.String r9 = "icon_highlight_url"
            java.lang.String r13 = "icon_md5"
            java.lang.String r14 = "icon_file_uri"
            java.lang.String r15 = "icon_path"
            java.lang.String r3 = "icon_url"
            java.lang.String r1 = "category_name"
            r16 = r2
            java.lang.String r2 = "readable_id"
            r19 = r10
            r17 = 1
            if (r4 == 0) goto L_0x013a
            int r18 = r4.getCount()     // Catch:{ Throwable -> 0x0132, all -> 0x0129 }
            if (r18 <= 0) goto L_0x013a
            r4.moveToFirst()     // Catch:{ Throwable -> 0x0121, all -> 0x0117 }
            java.lang.String r10 = r20.getReadableId()     // Catch:{ Throwable -> 0x0121, all -> 0x0117 }
            r12.put(r2, r10)     // Catch:{ Throwable -> 0x0121, all -> 0x0117 }
            java.lang.String r2 = r20.getCategoryName()     // Catch:{ Throwable -> 0x0121, all -> 0x0117 }
            r12.put(r1, r2)     // Catch:{ Throwable -> 0x0121, all -> 0x0117 }
            java.lang.String r1 = r20.getIconUrl()     // Catch:{ Throwable -> 0x0121, all -> 0x0117 }
            r12.put(r3, r1)     // Catch:{ Throwable -> 0x0121, all -> 0x0117 }
            java.lang.String r1 = r20.getIconPath()     // Catch:{ Throwable -> 0x0121, all -> 0x0117 }
            r12.put(r15, r1)     // Catch:{ Throwable -> 0x0121, all -> 0x0117 }
            java.lang.String r1 = r20.getIconFileUri()     // Catch:{ Throwable -> 0x0121, all -> 0x0117 }
            r12.put(r14, r1)     // Catch:{ Throwable -> 0x0121, all -> 0x0117 }
            java.lang.String r1 = r20.getIconMd5()     // Catch:{ Throwable -> 0x0121, all -> 0x0117 }
            r12.put(r13, r1)     // Catch:{ Throwable -> 0x0121, all -> 0x0117 }
            java.lang.String r1 = r20.getIconHighlightUrl()     // Catch:{ Throwable -> 0x0121, all -> 0x0117 }
            r12.put(r9, r1)     // Catch:{ Throwable -> 0x0121, all -> 0x0117 }
            java.lang.String r1 = r20.getIconHighlightPath()     // Catch:{ Throwable -> 0x0121, all -> 0x0117 }
            r12.put(r8, r1)     // Catch:{ Throwable -> 0x0121, all -> 0x0117 }
            java.lang.String r1 = r20.getIconHighlightFileUri()     // Catch:{ Throwable -> 0x0121, all -> 0x0117 }
            r12.put(r7, r1)     // Catch:{ Throwable -> 0x0121, all -> 0x0117 }
            java.lang.String r1 = r20.getIconHighlightMd5()     // Catch:{ Throwable -> 0x0121, all -> 0x0117 }
            r12.put(r6, r1)     // Catch:{ Throwable -> 0x0121, all -> 0x0117 }
            int r1 = r20.getPosition()     // Catch:{ Throwable -> 0x0121, all -> 0x0117 }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ Throwable -> 0x0121, all -> 0x0117 }
            r12.put(r5, r1)     // Catch:{ Throwable -> 0x0121, all -> 0x0117 }
            boolean r1 = r20.isCategoryNew()     // Catch:{ Throwable -> 0x0121, all -> 0x0117 }
            if (r1 != 0) goto L_0x00d3
            java.lang.String r1 = "is_new"
            boolean r2 = r20.isCategoryNew()     // Catch:{ Throwable -> 0x0121, all -> 0x00cb }
            if (r2 == 0) goto L_0x00c2
            r2 = r17
            goto L_0x00c3
        L_0x00c2:
            r2 = 0
        L_0x00c3:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ Throwable -> 0x0121, all -> 0x00cb }
            r12.put(r1, r2)     // Catch:{ Throwable -> 0x0121, all -> 0x00cb }
            goto L_0x00d3
        L_0x00cb:
            r0 = move-exception
            r1 = r0
            r19 = r4
            r10 = r16
            goto L_0x012f
        L_0x00d3:
            java.lang.String r1 = "is_valid"
            boolean r2 = r20.isCategoryValid()     // Catch:{ Throwable -> 0x0121, all -> 0x0117 }
            if (r2 == 0) goto L_0x00de
            r2 = r17
            goto L_0x00df
        L_0x00de:
            r2 = 0
        L_0x00df:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ Throwable -> 0x0121, all -> 0x0117 }
            r12.put(r1, r2)     // Catch:{ Throwable -> 0x0121, all -> 0x0117 }
            r1 = r19
            r10 = 0
            int r0 = r0.update(r11, r12, r1, r10)     // Catch:{ Throwable -> 0x0121, all -> 0x0115 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x0121, all -> 0x0115 }
            r1.<init>()     // Catch:{ Throwable -> 0x0121, all -> 0x0115 }
            java.lang.String r2 = "updateOrAddToCategoryTable, update single item. count: "
            r1.append(r2)     // Catch:{ Throwable -> 0x0121, all -> 0x0115 }
            r1.append(r0)     // Catch:{ Throwable -> 0x0121, all -> 0x0115 }
            java.lang.String r0 = r1.toString()     // Catch:{ Throwable -> 0x0121, all -> 0x0115 }
            r1 = r16
            com.oppo.camera.e.b(r1, r0)     // Catch:{ Throwable -> 0x010f, all -> 0x0108 }
            r10 = r1
            r19 = r4
            goto L_0x01da
        L_0x0108:
            r0 = move-exception
            r19 = r4
            r2 = r10
            r10 = r1
            goto L_0x01e9
        L_0x010f:
            r0 = move-exception
            r10 = r1
            r19 = r4
            goto L_0x01e5
        L_0x0115:
            r0 = move-exception
            goto L_0x0119
        L_0x0117:
            r0 = move-exception
            r10 = 0
        L_0x0119:
            r1 = r0
            r19 = r4
            r2 = r10
            r10 = r16
            goto L_0x01ea
        L_0x0121:
            r0 = move-exception
            r1 = r0
            r19 = r4
            r10 = r16
            goto L_0x01e6
        L_0x0129:
            r0 = move-exception
            r10 = r16
            r1 = r0
            r19 = r4
        L_0x012f:
            r2 = 0
            goto L_0x01ea
        L_0x0132:
            r0 = move-exception
            r10 = r16
            r1 = r0
            r19 = r4
            goto L_0x01e6
        L_0x013a:
            r10 = r16
            r19 = r4
            java.lang.String r4 = r20.getReadableId()     // Catch:{ Throwable -> 0x01e4, all -> 0x01e0 }
            r12.put(r2, r4)     // Catch:{ Throwable -> 0x01e4, all -> 0x01e0 }
            java.lang.String r2 = r20.getCategoryName()     // Catch:{ Throwable -> 0x01e4, all -> 0x01e0 }
            r12.put(r1, r2)     // Catch:{ Throwable -> 0x01e4, all -> 0x01e0 }
            java.lang.String r1 = r20.getIconUrl()     // Catch:{ Throwable -> 0x01e4, all -> 0x01e0 }
            r12.put(r3, r1)     // Catch:{ Throwable -> 0x01e4, all -> 0x01e0 }
            java.lang.String r1 = r20.getIconPath()     // Catch:{ Throwable -> 0x01e4, all -> 0x01e0 }
            r12.put(r15, r1)     // Catch:{ Throwable -> 0x01e4, all -> 0x01e0 }
            java.lang.String r1 = r20.getIconFileUri()     // Catch:{ Throwable -> 0x01e4, all -> 0x01e0 }
            r12.put(r14, r1)     // Catch:{ Throwable -> 0x01e4, all -> 0x01e0 }
            java.lang.String r1 = r20.getIconMd5()     // Catch:{ Throwable -> 0x01e4, all -> 0x01e0 }
            r12.put(r13, r1)     // Catch:{ Throwable -> 0x01e4, all -> 0x01e0 }
            java.lang.String r1 = r20.getIconHighlightUrl()     // Catch:{ Throwable -> 0x01e4, all -> 0x01e0 }
            r12.put(r9, r1)     // Catch:{ Throwable -> 0x01e4, all -> 0x01e0 }
            java.lang.String r1 = r20.getIconHighlightPath()     // Catch:{ Throwable -> 0x01e4, all -> 0x01e0 }
            r12.put(r8, r1)     // Catch:{ Throwable -> 0x01e4, all -> 0x01e0 }
            java.lang.String r1 = r20.getIconHighlightFileUri()     // Catch:{ Throwable -> 0x01e4, all -> 0x01e0 }
            r12.put(r7, r1)     // Catch:{ Throwable -> 0x01e4, all -> 0x01e0 }
            java.lang.String r1 = r20.getIconHighlightMd5()     // Catch:{ Throwable -> 0x01e4, all -> 0x01e0 }
            r12.put(r6, r1)     // Catch:{ Throwable -> 0x01e4, all -> 0x01e0 }
            java.lang.String r1 = "request_time"
            long r2 = r20.getLastRequestTime()     // Catch:{ Throwable -> 0x01e4, all -> 0x01e0 }
            java.lang.Long r2 = java.lang.Long.valueOf(r2)     // Catch:{ Throwable -> 0x01e4, all -> 0x01e0 }
            r12.put(r1, r2)     // Catch:{ Throwable -> 0x01e4, all -> 0x01e0 }
            int r1 = r20.getPosition()     // Catch:{ Throwable -> 0x01e4, all -> 0x01e0 }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ Throwable -> 0x01e4, all -> 0x01e0 }
            r12.put(r5, r1)     // Catch:{ Throwable -> 0x01e4, all -> 0x01e0 }
            java.lang.String r1 = "is_new"
            boolean r2 = r20.isCategoryNew()     // Catch:{ Throwable -> 0x01e4, all -> 0x01e0 }
            if (r2 == 0) goto L_0x01a7
            r2 = r17
            goto L_0x01a8
        L_0x01a7:
            r2 = 0
        L_0x01a8:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ Throwable -> 0x01e4, all -> 0x01e0 }
            r12.put(r1, r2)     // Catch:{ Throwable -> 0x01e4, all -> 0x01e0 }
            java.lang.String r1 = "is_valid"
            boolean r2 = r20.isCategoryValid()     // Catch:{ Throwable -> 0x01e4, all -> 0x01e0 }
            if (r2 == 0) goto L_0x01ba
            r2 = r17
            goto L_0x01bb
        L_0x01ba:
            r2 = 0
        L_0x01bb:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ Throwable -> 0x01e4, all -> 0x01e0 }
            r12.put(r1, r2)     // Catch:{ Throwable -> 0x01e4, all -> 0x01e0 }
            android.net.Uri r0 = r0.insert(r11, r12)     // Catch:{ Throwable -> 0x01e4, all -> 0x01e0 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x01e4, all -> 0x01e0 }
            r1.<init>()     // Catch:{ Throwable -> 0x01e4, all -> 0x01e0 }
            java.lang.String r2 = "updateOrAddToCategoryTable, insert single item. insertUri: "
            r1.append(r2)     // Catch:{ Throwable -> 0x01e4, all -> 0x01e0 }
            r1.append(r0)     // Catch:{ Throwable -> 0x01e4, all -> 0x01e0 }
            java.lang.String r0 = r1.toString()     // Catch:{ Throwable -> 0x01e4, all -> 0x01e0 }
            com.oppo.camera.e.b(r10, r0)     // Catch:{ Throwable -> 0x01e4, all -> 0x01e0 }
        L_0x01da:
            if (r19 == 0) goto L_0x01df
            r19.close()     // Catch:{ Exception -> 0x01fc }
        L_0x01df:
            return r17
        L_0x01e0:
            r0 = move-exception
            r1 = r0
            goto L_0x012f
        L_0x01e4:
            r0 = move-exception
        L_0x01e5:
            r1 = r0
        L_0x01e6:
            throw r1     // Catch:{ all -> 0x01e7 }
        L_0x01e7:
            r0 = move-exception
            r2 = r1
        L_0x01e9:
            r1 = r0
        L_0x01ea:
            if (r19 == 0) goto L_0x01fb
            if (r2 == 0) goto L_0x01f8
            r19.close()     // Catch:{ Throwable -> 0x01f2 }
            goto L_0x01fb
        L_0x01f2:
            r0 = move-exception
            r3 = r0
            r2.addSuppressed(r3)     // Catch:{ Exception -> 0x01fc }
            goto L_0x01fb
        L_0x01f8:
            r19.close()     // Catch:{ Exception -> 0x01fc }
        L_0x01fb:
            throw r1     // Catch:{ Exception -> 0x01fc }
        L_0x01fc:
            r0 = move-exception
            goto L_0x0200
        L_0x01fe:
            r0 = move-exception
            r10 = r2
        L_0x0200:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "updateOrAddToCategoryTable, cause a exception, exception: "
            r1.append(r2)
            r1.append(r0)
            java.lang.String r0 = ", category: "
            r1.append(r0)
            r2 = r20
            r1.append(r2)
            java.lang.String r0 = r1.toString()
            com.oppo.camera.e.d(r10, r0)
            r1 = 0
            return r1
        L_0x0220:
            r10 = r2
            r1 = 0
            java.lang.String r0 = "updateOrAddToCategoryTable, context or category is null!"
            com.oppo.camera.e.d(r10, r0)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.sticker.a.a.a(android.content.Context, com.oppo.camera.sticker.data.StickerCategoryItemWrapper):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:81:0x023a, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x023b, code lost:
        r3 = r18;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x0245, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x0246, code lost:
        r3 = r18;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x022e A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x022b A[SYNTHETIC, Splitter:B:77:0x022b] */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0245 A[ExcHandler: Throwable (th java.lang.Throwable), Splitter:B:60:0x0184] */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x024e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(android.content.Context r21, java.util.List<com.oppo.camera.sticker.data.StickerCategoryItemWrapper> r22) {
        /*
            java.lang.String r1 = "StickerCategoryTableHelper"
            r2 = 0
            if (r22 == 0) goto L_0x0299
            int r0 = r22.size()
            if (r0 != 0) goto L_0x000d
            goto L_0x0299
        L_0x000d:
            java.lang.String r0 = "sticker.db"
            r3 = r21
            java.io.File r0 = r3.getDatabasePath(r0)
            java.lang.String r0 = r0.getPath()
            r3 = 0
            android.database.sqlite.SQLiteDatabase r12 = android.database.sqlite.SQLiteDatabase.openDatabase(r0, r3, r2)
            r12.beginTransaction()     // Catch:{ Exception -> 0x0270 }
            android.content.ContentValues r0 = new android.content.ContentValues     // Catch:{ Exception -> 0x0270 }
            r0.<init>()     // Catch:{ Exception -> 0x0270 }
            java.lang.String r13 = "sticker_category"
            java.util.Iterator r14 = r22.iterator()     // Catch:{ Exception -> 0x0270 }
        L_0x002c:
            boolean r4 = r14.hasNext()     // Catch:{ Exception -> 0x0270 }
            if (r4 == 0) goto L_0x025e
            java.lang.Object r4 = r14.next()     // Catch:{ Exception -> 0x0270 }
            r11 = r4
            com.oppo.camera.sticker.data.StickerCategoryItemWrapper r11 = (com.oppo.camera.sticker.data.StickerCategoryItemWrapper) r11     // Catch:{ Exception -> 0x0270 }
            r0.clear()     // Catch:{ Exception -> 0x0270 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0270 }
            r4.<init>()     // Catch:{ Exception -> 0x0270 }
            java.lang.String r5 = "readable_id = \""
            r4.append(r5)     // Catch:{ Exception -> 0x0270 }
            java.lang.String r5 = r11.getReadableId()     // Catch:{ Exception -> 0x0270 }
            r4.append(r5)     // Catch:{ Exception -> 0x0270 }
            java.lang.String r5 = "\""
            r4.append(r5)     // Catch:{ Exception -> 0x0270 }
            java.lang.String r10 = r4.toString()     // Catch:{ Exception -> 0x0270 }
            r6 = 0
            r8 = 0
            r9 = 0
            r16 = 0
            r17 = 0
            r4 = r12
            r5 = r13
            r7 = r10
            r2 = r10
            r10 = r16
            r21 = r11
            r11 = r17
            android.database.Cursor r4 = r4.query(r5, r6, r7, r8, r9, r10, r11)     // Catch:{ Exception -> 0x0270 }
            java.lang.String r5 = "position"
            java.lang.String r6 = "icon_highlight_file_uri"
            java.lang.String r7 = "icon_highlight_md5"
            java.lang.String r8 = "icon_highlight_path"
            java.lang.String r9 = "icon_highlight_url"
            java.lang.String r10 = "icon_file_uri"
            java.lang.String r11 = "icon_md5"
            java.lang.String r15 = "icon_path"
            java.lang.String r3 = "icon_url"
            r17 = r14
            java.lang.String r14 = "category_name"
            r18 = r1
            java.lang.String r1 = "readable_id"
            if (r4 == 0) goto L_0x017c
            int r19 = r4.getCount()     // Catch:{ Throwable -> 0x0174, all -> 0x016b }
            if (r19 <= 0) goto L_0x017c
            r4.moveToFirst()     // Catch:{ Throwable -> 0x0174, all -> 0x016b }
            r19 = r4
            java.lang.String r4 = r21.getReadableId()     // Catch:{ Throwable -> 0x0169, all -> 0x0167 }
            r0.put(r1, r4)     // Catch:{ Throwable -> 0x0169, all -> 0x0167 }
            java.lang.String r1 = r21.getCategoryName()     // Catch:{ Throwable -> 0x0169, all -> 0x0167 }
            r0.put(r14, r1)     // Catch:{ Throwable -> 0x0169, all -> 0x0167 }
            java.lang.String r1 = r21.getIconUrl()     // Catch:{ Throwable -> 0x0169, all -> 0x0167 }
            r0.put(r3, r1)     // Catch:{ Throwable -> 0x0169, all -> 0x0167 }
            java.lang.String r1 = r21.getIconMd5()     // Catch:{ Throwable -> 0x0169, all -> 0x0167 }
            r0.put(r11, r1)     // Catch:{ Throwable -> 0x0169, all -> 0x0167 }
            java.lang.String r1 = r21.getIconPath()     // Catch:{ Throwable -> 0x0169, all -> 0x0167 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Throwable -> 0x0169, all -> 0x0167 }
            if (r1 != 0) goto L_0x00bf
            java.lang.String r1 = r21.getIconPath()     // Catch:{ Throwable -> 0x0169, all -> 0x0167 }
            r0.put(r15, r1)     // Catch:{ Throwable -> 0x0169, all -> 0x0167 }
        L_0x00bf:
            java.lang.String r1 = r21.getIconFileUri()     // Catch:{ Throwable -> 0x0169, all -> 0x0167 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Throwable -> 0x0169, all -> 0x0167 }
            if (r1 != 0) goto L_0x00d0
            java.lang.String r1 = r21.getIconFileUri()     // Catch:{ Throwable -> 0x0169, all -> 0x0167 }
            r0.put(r10, r1)     // Catch:{ Throwable -> 0x0169, all -> 0x0167 }
        L_0x00d0:
            java.lang.String r1 = r21.getIconHighlightUrl()     // Catch:{ Throwable -> 0x0169, all -> 0x0167 }
            r0.put(r9, r1)     // Catch:{ Throwable -> 0x0169, all -> 0x0167 }
            java.lang.String r1 = r21.getIconHighlightMd5()     // Catch:{ Throwable -> 0x0169, all -> 0x0167 }
            r0.put(r7, r1)     // Catch:{ Throwable -> 0x0169, all -> 0x0167 }
            java.lang.String r1 = r21.getIconHighlightPath()     // Catch:{ Throwable -> 0x0169, all -> 0x0167 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Throwable -> 0x0169, all -> 0x0167 }
            if (r1 != 0) goto L_0x00ef
            java.lang.String r1 = r21.getIconHighlightPath()     // Catch:{ Throwable -> 0x0169, all -> 0x0167 }
            r0.put(r8, r1)     // Catch:{ Throwable -> 0x0169, all -> 0x0167 }
        L_0x00ef:
            java.lang.String r1 = r21.getIconHighlightFileUri()     // Catch:{ Throwable -> 0x0169, all -> 0x0167 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Throwable -> 0x0169, all -> 0x0167 }
            if (r1 != 0) goto L_0x0100
            java.lang.String r1 = r21.getIconHighlightFileUri()     // Catch:{ Throwable -> 0x0169, all -> 0x0167 }
            r0.put(r6, r1)     // Catch:{ Throwable -> 0x0169, all -> 0x0167 }
        L_0x0100:
            int r1 = r21.getPosition()     // Catch:{ Throwable -> 0x0169, all -> 0x0167 }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ Throwable -> 0x0169, all -> 0x0167 }
            r0.put(r5, r1)     // Catch:{ Throwable -> 0x0169, all -> 0x0167 }
            boolean r1 = r21.isCategoryNew()     // Catch:{ Throwable -> 0x0169, all -> 0x0167 }
            if (r1 != 0) goto L_0x0123
            java.lang.String r1 = "is_new"
            boolean r3 = r21.isCategoryNew()     // Catch:{ Throwable -> 0x0169, all -> 0x0167 }
            if (r3 == 0) goto L_0x011b
            r3 = 1
            goto L_0x011c
        L_0x011b:
            r3 = 0
        L_0x011c:
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ Throwable -> 0x0169, all -> 0x0167 }
            r0.put(r1, r3)     // Catch:{ Throwable -> 0x0169, all -> 0x0167 }
        L_0x0123:
            java.lang.String r1 = "is_valid"
            boolean r3 = r21.isCategoryValid()     // Catch:{ Throwable -> 0x0169, all -> 0x0167 }
            if (r3 == 0) goto L_0x012d
            r3 = 1
            goto L_0x012e
        L_0x012d:
            r3 = 0
        L_0x012e:
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ Throwable -> 0x0169, all -> 0x0167 }
            r0.put(r1, r3)     // Catch:{ Throwable -> 0x0169, all -> 0x0167 }
            r1 = 0
            int r2 = r12.update(r13, r0, r2, r1)     // Catch:{ Throwable -> 0x0169, all -> 0x0167 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x0169, all -> 0x0167 }
            r1.<init>()     // Catch:{ Throwable -> 0x0169, all -> 0x0167 }
            java.lang.String r3 = "updateOrAddToCategoryTable, update count: "
            r1.append(r3)     // Catch:{ Throwable -> 0x0169, all -> 0x0167 }
            r1.append(r2)     // Catch:{ Throwable -> 0x0169, all -> 0x0167 }
            java.lang.String r2 = ", category: "
            r1.append(r2)     // Catch:{ Throwable -> 0x0169, all -> 0x0167 }
            r4 = r21
            r1.append(r4)     // Catch:{ Throwable -> 0x0169, all -> 0x0167 }
            java.lang.String r1 = r1.toString()     // Catch:{ Throwable -> 0x0169, all -> 0x0167 }
            r2 = r18
            com.oppo.camera.e.b(r2, r1)     // Catch:{ Throwable -> 0x0162, all -> 0x015e }
            r3 = r2
            r1 = 0
            goto L_0x0229
        L_0x015e:
            r0 = move-exception
            r1 = r0
            r3 = r2
            goto L_0x0171
        L_0x0162:
            r0 = move-exception
            r1 = r0
            r3 = r2
            goto L_0x0249
        L_0x0167:
            r0 = move-exception
            goto L_0x016e
        L_0x0169:
            r0 = move-exception
            goto L_0x0177
        L_0x016b:
            r0 = move-exception
            r19 = r4
        L_0x016e:
            r1 = r0
            r3 = r18
        L_0x0171:
            r2 = 0
            goto L_0x024c
        L_0x0174:
            r0 = move-exception
            r19 = r4
        L_0x0177:
            r1 = r0
            r3 = r18
            goto L_0x0249
        L_0x017c:
            r19 = r4
            r2 = r18
            r4 = r21
            r18 = r2
            java.lang.String r2 = r4.getReadableId()     // Catch:{ Throwable -> 0x0245, all -> 0x023e }
            r0.put(r1, r2)     // Catch:{ Throwable -> 0x0245, all -> 0x023e }
            java.lang.String r1 = r4.getCategoryName()     // Catch:{ Throwable -> 0x0245, all -> 0x023e }
            r0.put(r14, r1)     // Catch:{ Throwable -> 0x0245, all -> 0x023e }
            java.lang.String r1 = r4.getIconUrl()     // Catch:{ Throwable -> 0x0245, all -> 0x023e }
            r0.put(r3, r1)     // Catch:{ Throwable -> 0x0245, all -> 0x023e }
            java.lang.String r1 = r4.getIconPath()     // Catch:{ Throwable -> 0x0245, all -> 0x023e }
            r0.put(r15, r1)     // Catch:{ Throwable -> 0x0245, all -> 0x023e }
            java.lang.String r1 = r4.getIconMd5()     // Catch:{ Throwable -> 0x0245, all -> 0x023e }
            r0.put(r11, r1)     // Catch:{ Throwable -> 0x0245, all -> 0x023e }
            java.lang.String r1 = r4.getIconFileUri()     // Catch:{ Throwable -> 0x0245, all -> 0x023e }
            r0.put(r10, r1)     // Catch:{ Throwable -> 0x0245, all -> 0x023e }
            java.lang.String r1 = r4.getIconHighlightUrl()     // Catch:{ Throwable -> 0x0245, all -> 0x023e }
            r0.put(r9, r1)     // Catch:{ Throwable -> 0x0245, all -> 0x023e }
            java.lang.String r1 = r4.getIconHighlightPath()     // Catch:{ Throwable -> 0x0245, all -> 0x023e }
            r0.put(r8, r1)     // Catch:{ Throwable -> 0x0245, all -> 0x023e }
            java.lang.String r1 = r4.getIconHighlightMd5()     // Catch:{ Throwable -> 0x0245, all -> 0x023e }
            r0.put(r7, r1)     // Catch:{ Throwable -> 0x0245, all -> 0x023e }
            java.lang.String r1 = r4.getIconHighlightFileUri()     // Catch:{ Throwable -> 0x0245, all -> 0x023e }
            r0.put(r6, r1)     // Catch:{ Throwable -> 0x0245, all -> 0x023e }
            java.lang.String r1 = "request_time"
            long r2 = r4.getLastRequestTime()     // Catch:{ Throwable -> 0x0245, all -> 0x023e }
            java.lang.Long r2 = java.lang.Long.valueOf(r2)     // Catch:{ Throwable -> 0x0245, all -> 0x023e }
            r0.put(r1, r2)     // Catch:{ Throwable -> 0x0245, all -> 0x023e }
            int r1 = r4.getPosition()     // Catch:{ Throwable -> 0x0245, all -> 0x023e }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ Throwable -> 0x0245, all -> 0x023e }
            r0.put(r5, r1)     // Catch:{ Throwable -> 0x0245, all -> 0x023e }
            java.lang.String r1 = "is_new"
            boolean r2 = r4.isCategoryNew()     // Catch:{ Throwable -> 0x0245, all -> 0x023e }
            if (r2 == 0) goto L_0x01ec
            r2 = 1
            goto L_0x01ed
        L_0x01ec:
            r2 = 0
        L_0x01ed:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ Throwable -> 0x0245, all -> 0x023e }
            r0.put(r1, r2)     // Catch:{ Throwable -> 0x0245, all -> 0x023e }
            java.lang.String r1 = "is_valid"
            boolean r2 = r4.isCategoryValid()     // Catch:{ Throwable -> 0x0245, all -> 0x023e }
            if (r2 == 0) goto L_0x01fe
            r2 = 1
            goto L_0x01ff
        L_0x01fe:
            r2 = 0
        L_0x01ff:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ Throwable -> 0x0245, all -> 0x023e }
            r0.put(r1, r2)     // Catch:{ Throwable -> 0x0245, all -> 0x023e }
            r1 = 0
            long r2 = r12.insert(r13, r1, r0)     // Catch:{ Throwable -> 0x0245, all -> 0x023a }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x0245, all -> 0x023a }
            r5.<init>()     // Catch:{ Throwable -> 0x0245, all -> 0x023a }
            java.lang.String r6 = "updateOrAddToCategoryTable, insert rowId: "
            r5.append(r6)     // Catch:{ Throwable -> 0x0245, all -> 0x023a }
            r5.append(r2)     // Catch:{ Throwable -> 0x0245, all -> 0x023a }
            java.lang.String r2 = ", category: "
            r5.append(r2)     // Catch:{ Throwable -> 0x0245, all -> 0x023a }
            r5.append(r4)     // Catch:{ Throwable -> 0x0245, all -> 0x023a }
            java.lang.String r2 = r5.toString()     // Catch:{ Throwable -> 0x0245, all -> 0x023a }
            r3 = r18
            com.oppo.camera.e.b(r3, r2)     // Catch:{ Throwable -> 0x0238 }
        L_0x0229:
            if (r19 == 0) goto L_0x022e
            r19.close()     // Catch:{ Exception -> 0x026c }
        L_0x022e:
            r14 = r17
            r2 = 0
            r20 = r3
            r3 = r1
            r1 = r20
            goto L_0x002c
        L_0x0238:
            r0 = move-exception
            goto L_0x0248
        L_0x023a:
            r0 = move-exception
            r3 = r18
            goto L_0x0242
        L_0x023e:
            r0 = move-exception
            r3 = r18
            r1 = 0
        L_0x0242:
            r2 = r1
            r1 = r0
            goto L_0x024c
        L_0x0245:
            r0 = move-exception
            r3 = r18
        L_0x0248:
            r1 = r0
        L_0x0249:
            throw r1     // Catch:{ all -> 0x024a }
        L_0x024a:
            r0 = move-exception
            goto L_0x0242
        L_0x024c:
            if (r19 == 0) goto L_0x025d
            if (r2 == 0) goto L_0x025a
            r19.close()     // Catch:{ Throwable -> 0x0254 }
            goto L_0x025d
        L_0x0254:
            r0 = move-exception
            r4 = r0
            r2.addSuppressed(r4)     // Catch:{ Exception -> 0x026c }
            goto L_0x025d
        L_0x025a:
            r19.close()     // Catch:{ Exception -> 0x026c }
        L_0x025d:
            throw r1     // Catch:{ Exception -> 0x026c }
        L_0x025e:
            r3 = r1
            r12.setTransactionSuccessful()     // Catch:{ Exception -> 0x026c }
            if (r12 == 0) goto L_0x026a
            r12.endTransaction()
            r12.close()
        L_0x026a:
            r0 = 1
            return r0
        L_0x026c:
            r0 = move-exception
            goto L_0x0272
        L_0x026e:
            r0 = move-exception
            goto L_0x0290
        L_0x0270:
            r0 = move-exception
            r3 = r1
        L_0x0272:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x026e }
            r1.<init>()     // Catch:{ all -> 0x026e }
            java.lang.String r2 = "updateOrAddToCategoryTable, update list, e: "
            r1.append(r2)     // Catch:{ all -> 0x026e }
            r1.append(r0)     // Catch:{ all -> 0x026e }
            java.lang.String r0 = r1.toString()     // Catch:{ all -> 0x026e }
            com.oppo.camera.e.d(r3, r0)     // Catch:{ all -> 0x026e }
            if (r12 == 0) goto L_0x028e
            r12.endTransaction()
            r12.close()
        L_0x028e:
            r1 = 0
            return r1
        L_0x0290:
            if (r12 == 0) goto L_0x0298
            r12.endTransaction()
            r12.close()
        L_0x0298:
            throw r0
        L_0x0299:
            r3 = r1
            java.lang.String r0 = "updateOrAddToCategoryTable, categoryList is empty!"
            com.oppo.camera.e.d(r3, r0)
            r1 = 0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.sticker.a.a.a(android.content.Context, java.util.List):boolean");
    }

    public static List<StickerCategoryItem> a(Context context) {
        Cursor query;
        ContentResolver contentResolver = context.getContentResolver();
        ArrayList arrayList = new ArrayList();
        try {
            query = contentResolver.query(c.C0095c.f3622a, (String[]) null, (String) null, (String[]) null, "position ASC");
            if (query != null) {
                if (query.moveToFirst()) {
                    do {
                        StickerCategoryItemWrapper a2 = a(query);
                        if (a2 != null && !TextUtils.isEmpty(a2.getCategoryName())) {
                            arrayList.add(a2);
                        }
                    } while (query.moveToNext());
                }
            }
            if (query != null) {
                query.close();
            }
        } catch (Exception e) {
            e.d("StickerCategoryTableHelper", "getAllStickerCategory, e: " + e);
        } catch (Throwable th) {
            r1.addSuppressed(th);
        }
        return arrayList;
        throw th;
    }

    public static StickerCategoryItemWrapper a(Cursor cursor) {
        StickerCategoryItemWrapper stickerCategoryItemWrapper = new StickerCategoryItemWrapper();
        stickerCategoryItemWrapper.setReadableId(cursor.getString(cursor.getColumnIndexOrThrow("readable_id")));
        stickerCategoryItemWrapper.setCategoryName(cursor.getString(cursor.getColumnIndexOrThrow("category_name")));
        stickerCategoryItemWrapper.setPosition(cursor.getInt(cursor.getColumnIndexOrThrow("position")));
        stickerCategoryItemWrapper.setIconUrl(cursor.getString(cursor.getColumnIndexOrThrow("icon_url")));
        stickerCategoryItemWrapper.setIconPath(cursor.getString(cursor.getColumnIndexOrThrow("icon_path")));
        stickerCategoryItemWrapper.setIconFileUri(cursor.getString(cursor.getColumnIndexOrThrow("icon_file_uri")));
        stickerCategoryItemWrapper.setIconMd5(cursor.getString(cursor.getColumnIndexOrThrow("icon_md5")));
        stickerCategoryItemWrapper.setIconHighlightUrl(cursor.getString(cursor.getColumnIndexOrThrow("icon_highlight_url")));
        stickerCategoryItemWrapper.setIconHighlightPath(cursor.getString(cursor.getColumnIndexOrThrow("icon_highlight_path")));
        stickerCategoryItemWrapper.setIconHighlightFileUri(cursor.getString(cursor.getColumnIndexOrThrow("icon_highlight_file_uri")));
        stickerCategoryItemWrapper.setIconHighlightMd5(cursor.getString(cursor.getColumnIndexOrThrow("icon_highlight_md5")));
        stickerCategoryItemWrapper.setLastRequestTime(cursor.getLong(cursor.getColumnIndexOrThrow("request_time")));
        boolean z = false;
        stickerCategoryItemWrapper.setCategoryNew(cursor.getInt(cursor.getColumnIndexOrThrow("is_new")) != 0);
        if (cursor.getInt(cursor.getColumnIndexOrThrow("is_valid")) != 0) {
            z = true;
        }
        stickerCategoryItemWrapper.setCategoryValid(z);
        return stickerCategoryItemWrapper;
    }

    /* JADX WARNING: type inference failed for: r8v2 */
    /* JADX WARNING: type inference failed for: r8v5 */
    /* JADX WARNING: type inference failed for: r8v7, types: [com.oppo.camera.sticker.data.StickerCategoryItem] */
    /* JADX WARNING: type inference failed for: r8v8, types: [java.lang.Throwable] */
    /* JADX WARNING: type inference failed for: r8v13 */
    /* JADX WARNING: type inference failed for: r8v14 */
    /* JADX WARNING: type inference failed for: r8v15 */
    /* JADX WARNING: type inference failed for: r8v16 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.oppo.camera.sticker.data.StickerCategoryItem a(android.content.Context r8, java.lang.String r9, java.lang.String r10) {
        /*
            java.lang.String r0 = "StickerCategoryTableHelper"
            android.content.ContentResolver r1 = r8.getContentResolver()
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r8.append(r9)
            java.lang.String r9 = " = \""
            r8.append(r9)
            r8.append(r10)
            java.lang.String r9 = "\""
            r8.append(r9)
            java.lang.String r4 = r8.toString()
            r8 = 0
            android.net.Uri r2 = com.oppo.camera.sticker.a.c.C0095c.f3622a     // Catch:{ Exception -> 0x006f }
            r3 = 0
            r5 = 0
            r6 = 0
            android.database.Cursor r9 = r1.query(r2, r3, r4, r5, r6)     // Catch:{ Exception -> 0x006f }
            if (r9 == 0) goto L_0x0069
            boolean r10 = r9.moveToFirst()     // Catch:{ Throwable -> 0x0050, all -> 0x004d }
            if (r10 == 0) goto L_0x0069
            com.oppo.camera.sticker.data.StickerCategoryItemWrapper r10 = a((android.database.Cursor) r9)     // Catch:{ Throwable -> 0x0050, all -> 0x004d }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x004b }
            r1.<init>()     // Catch:{ Throwable -> 0x004b }
            java.lang.String r2 = "getStickerCategory, item: "
            r1.append(r2)     // Catch:{ Throwable -> 0x004b }
            r1.append(r10)     // Catch:{ Throwable -> 0x004b }
            java.lang.String r1 = r1.toString()     // Catch:{ Throwable -> 0x004b }
            com.oppo.camera.e.b(r0, r1)     // Catch:{ Throwable -> 0x004b }
            r8 = r10
            goto L_0x0069
        L_0x004b:
            r8 = move-exception
            goto L_0x0054
        L_0x004d:
            r1 = move-exception
            r10 = r8
            goto L_0x0056
        L_0x0050:
            r10 = move-exception
            r7 = r10
            r10 = r8
            r8 = r7
        L_0x0054:
            throw r8     // Catch:{ all -> 0x0055 }
        L_0x0055:
            r1 = move-exception
        L_0x0056:
            if (r9 == 0) goto L_0x0066
            if (r8 == 0) goto L_0x0063
            r9.close()     // Catch:{ Throwable -> 0x005e }
            goto L_0x0066
        L_0x005e:
            r9 = move-exception
            r8.addSuppressed(r9)     // Catch:{ Exception -> 0x0067 }
            goto L_0x0066
        L_0x0063:
            r9.close()     // Catch:{ Exception -> 0x0067 }
        L_0x0066:
            throw r1     // Catch:{ Exception -> 0x0067 }
        L_0x0067:
            r8 = move-exception
            goto L_0x0072
        L_0x0069:
            if (r9 == 0) goto L_0x0078
            r9.close()     // Catch:{ Exception -> 0x006f }
            goto L_0x0078
        L_0x006f:
            r9 = move-exception
            r10 = r8
            r8 = r9
        L_0x0072:
            java.lang.String r9 = "getStickerCategory, e:"
            com.oppo.camera.e.c(r0, r9, r8)
            r8 = r10
        L_0x0078:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.sticker.a.a.a(android.content.Context, java.lang.String, java.lang.String):com.oppo.camera.sticker.data.StickerCategoryItem");
    }

    public static boolean a(Context context, String str) {
        StickerCategoryItem a2 = a(context, "readable_id", str);
        e.b("StickerCategoryTableHelper", "hasStickerCategory, item: " + a2);
        return a2 != null;
    }

    public static int a(Context context, String str, String str2, ContentValues contentValues) {
        return context.getContentResolver().update(c.C0095c.f3622a, contentValues, str + " = \"" + str2 + "\"", (String[]) null);
    }

    public static void a(Context context, long j, long j2) {
        String[] strArr = {String.valueOf(1)};
        ContentValues contentValues = new ContentValues();
        contentValues.put("is_new", 0);
        e.b("StickerCategoryTableHelper", "autoClearStickerNewStatus, update count: " + context.getContentResolver().update(c.C0095c.f3622a, contentValues, "is_new = ? AND request_time < " + (j - j2), strArr) + ", currTime: " + j);
    }
}
