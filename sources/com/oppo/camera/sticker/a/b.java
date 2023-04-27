package com.oppo.camera.sticker.a;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.oppo.camera.e;
import com.oppo.camera.statistics.CameraStatisticsUtil;
import com.oppo.camera.sticker.a.c;
import com.oppo.camera.sticker.data.BuildInSticker;
import com.oppo.camera.sticker.data.MultiStickerExtendedInfo;
import com.oppo.camera.sticker.data.StickerItem;
import com.oppo.camera.sticker.data.StickerItemWrapper;
import java.util.ArrayList;
import java.util.List;

/* compiled from: StickerItemTableHelper */
public class b {
    public static String a() {
        return "CREATE TABLE IF NOT EXISTS sticker_item (_id INTEGER PRIMARY KEY, uuid TEXT NOT NULL UNIQUE, name TEXT, file_url TEXT, file_md5 TEXT, file_path TEXT, file_content_uri TEXT, thumbnail_url TEXT, thumbnail_path TEXT, thumbnail_file_uri TEXT, thumbnail_md5 TEXT, version INTEGER, logo_url TEXT, logo_path TEXT, logo_file_uri TEXT, logo_md5 TEXT, has_music INTEGER DEFAULT 0, attribute INTEGER, protocol_version TEXT, position INTEGER, need_update INTEGER DEFAULT 0, is_build_in INTEGER DEFAULT 0, is_new INTEGER DEFAULT 0, category_id TEXT, category_position INTEGER, request_time INTEGER, is_valid INTEGER DEFAULT 1, download_uuid TEXT, download_state INTEGER, download_time INTEGER);";
    }

    public static String b() {
        return "CREATE TABLE IF NOT EXISTS animoji_info (uuid TEXT NOT NULL, background_color TEXT NOT NULL, FOREIGN KEY(uuid)REFERENCES sticker_item(uuid));";
    }

    public static String c() {
        return "CREATE TABLE IF NOT EXISTS multi_info (uuid TEXT NOT NULL, sticker_fit_to_size INTEGER, sticker_name TEXT, position_type INTEGER, z_position INTEGER, base_size_16_9 TEXT, display_rect_16_9 TEXT, file_content_uri_16_9 TEXT, base_size_4_3 TEXT, display_rect_4_3 TEXT, file_content_uri_4_3 TEXT, base_size_1_1 TEXT, display_rect_1_1 TEXT, file_content_uri_1_1 TEXT, FOREIGN KEY(uuid)REFERENCES sticker_item(uuid));";
    }

    public static boolean a(Context context, BuildInSticker buildInSticker) {
        if (buildInSticker == null || TextUtils.isEmpty(buildInSticker.getStickerUUID())) {
            throw new IllegalArgumentException("isBuildInStickerCanAddOrUpdate, invalid Sticker!");
        }
        StickerItemWrapper a2 = a(context, "uuid", buildInSticker.getStickerUUID());
        e.b("StickerItemTableHelper", "isBuildInStickerCanAddOrUpdate, item: " + a2 + ", Sticker: " + buildInSticker);
        return a2 == null || a2.getVersion() < buildInSticker.getVersion();
    }

    /* JADX WARNING: Removed duplicated region for block: B:100:0x0409 A[SYNTHETIC, Splitter:B:100:0x0409] */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x0422  */
    /* JADX WARNING: Removed duplicated region for block: B:131:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(android.content.Context r24, com.oppo.camera.sticker.data.StickerItemWrapper r25) {
        /*
            r1 = r25
            java.lang.String r2 = "StickerItemTableHelper"
            r3 = 0
            java.lang.Integer r0 = java.lang.Integer.valueOf(r3)
            if (r24 == 0) goto L_0x0456
            if (r1 != 0) goto L_0x000f
            goto L_0x0456
        L_0x000f:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "updateOrAddToStickerItemTable, single mode. stickerItem: "
            r4.append(r5)
            r4.append(r1)
            java.lang.String r4 = r4.toString()
            com.oppo.camera.e.b(r2, r4)
            java.lang.String r4 = r25.getCategoryId()
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 == 0) goto L_0x0033
            java.lang.String r0 = "updateOrAddToStickerItemTable, single mode. no category id!"
            com.oppo.camera.e.d(r2, r0)
            return r3
        L_0x0033:
            android.content.ContentResolver r10 = r24.getContentResolver()
            java.lang.String r11 = "uuid = ?"
            r12 = 1
            java.lang.String[] r13 = new java.lang.String[r12]
            java.lang.String r4 = r25.getStickerUUID()
            r13[r3] = r4
            android.net.Uri r14 = com.oppo.camera.sticker.a.c.d.f3624a
            android.content.ContentValues r15 = new android.content.ContentValues
            r15.<init>()
            r6 = 0
            r9 = 0
            r4 = r10
            r5 = r14
            r7 = r11
            r8 = r13
            android.database.Cursor r4 = r4.query(r5, r6, r7, r8, r9)     // Catch:{ Exception -> 0x0434 }
            java.lang.String r6 = "thumbnail_md5"
            java.lang.String r7 = "thumbnail_file_uri"
            java.lang.String r8 = "thumbnail_path"
            java.lang.String r9 = "thumbnail_url"
            java.lang.String r5 = "file_content_uri"
            java.lang.String r3 = "file_path"
            java.lang.String r12 = "file_md5"
            java.lang.String r1 = "file_url"
            r16 = r10
            java.lang.String r10 = "name"
            r17 = r11
            java.lang.String r11 = "need_update"
            r18 = r13
            java.lang.String r13 = "download_state"
            r19 = r14
            java.lang.String r14 = "version"
            if (r4 == 0) goto L_0x0287
            int r20 = r4.getCount()     // Catch:{ Throwable -> 0x0280, all -> 0x0278 }
            if (r20 <= 0) goto L_0x0287
            r4.moveToFirst()     // Catch:{ Throwable -> 0x0271, all -> 0x026c }
            r20 = r11
            int r11 = r4.getColumnIndexOrThrow(r14)     // Catch:{ Throwable -> 0x0271, all -> 0x026c }
            r21 = r13
            r22 = r14
            long r13 = r4.getLong(r11)     // Catch:{ Throwable -> 0x0271, all -> 0x026c }
            java.lang.String r11 = r25.getStickerName()     // Catch:{ Throwable -> 0x0271, all -> 0x026c }
            r15.put(r10, r11)     // Catch:{ Throwable -> 0x0271, all -> 0x026c }
            java.lang.String r10 = r25.getFileDownloadUrl()     // Catch:{ Throwable -> 0x0271, all -> 0x026c }
            r15.put(r1, r10)     // Catch:{ Throwable -> 0x0271, all -> 0x026c }
            java.lang.String r1 = r25.getFileMd5()     // Catch:{ Throwable -> 0x0271, all -> 0x026c }
            r15.put(r12, r1)     // Catch:{ Throwable -> 0x0271, all -> 0x026c }
            java.lang.String r1 = r25.getFilePath()     // Catch:{ Throwable -> 0x0271, all -> 0x026c }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Throwable -> 0x0271, all -> 0x026c }
            if (r1 != 0) goto L_0x00b2
            java.lang.String r1 = r25.getFilePath()     // Catch:{ Throwable -> 0x0271, all -> 0x026c }
            r15.put(r3, r1)     // Catch:{ Throwable -> 0x0271, all -> 0x026c }
        L_0x00b2:
            java.lang.String r1 = r25.getFileContentUri()     // Catch:{ Throwable -> 0x0271, all -> 0x026c }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Throwable -> 0x0271, all -> 0x026c }
            if (r1 != 0) goto L_0x00c3
            java.lang.String r1 = r25.getFileContentUri()     // Catch:{ Throwable -> 0x0271, all -> 0x026c }
            r15.put(r5, r1)     // Catch:{ Throwable -> 0x0271, all -> 0x026c }
        L_0x00c3:
            java.lang.String r1 = r25.getThumbnailUrl()     // Catch:{ Throwable -> 0x0271, all -> 0x026c }
            r15.put(r9, r1)     // Catch:{ Throwable -> 0x0271, all -> 0x026c }
            java.lang.String r1 = r25.getThumbnailPath()     // Catch:{ Throwable -> 0x0271, all -> 0x026c }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Throwable -> 0x0271, all -> 0x026c }
            if (r1 != 0) goto L_0x00db
            java.lang.String r1 = r25.getThumbnailPath()     // Catch:{ Throwable -> 0x0271, all -> 0x026c }
            r15.put(r8, r1)     // Catch:{ Throwable -> 0x0271, all -> 0x026c }
        L_0x00db:
            java.lang.String r1 = r25.getThumbnailFileUri()     // Catch:{ Throwable -> 0x0271, all -> 0x026c }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Throwable -> 0x0271, all -> 0x026c }
            if (r1 != 0) goto L_0x00ec
            java.lang.String r1 = r25.getThumbnailFileUri()     // Catch:{ Throwable -> 0x0271, all -> 0x026c }
            r15.put(r7, r1)     // Catch:{ Throwable -> 0x0271, all -> 0x026c }
        L_0x00ec:
            java.lang.String r1 = r25.getThumbnailMd5()     // Catch:{ Throwable -> 0x0271, all -> 0x026c }
            r15.put(r6, r1)     // Catch:{ Throwable -> 0x0271, all -> 0x026c }
            java.lang.String r1 = "logo_url"
            java.lang.String r3 = r25.getLogoUrl()     // Catch:{ Throwable -> 0x0271, all -> 0x026c }
            r15.put(r1, r3)     // Catch:{ Throwable -> 0x0271, all -> 0x026c }
            java.lang.String r1 = r25.getLogoPath()     // Catch:{ Throwable -> 0x0271, all -> 0x026c }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Throwable -> 0x0271, all -> 0x026c }
            if (r1 != 0) goto L_0x010f
            java.lang.String r1 = "logo_path"
            java.lang.String r3 = r25.getLogoPath()     // Catch:{ Throwable -> 0x0271, all -> 0x026c }
            r15.put(r1, r3)     // Catch:{ Throwable -> 0x0271, all -> 0x026c }
        L_0x010f:
            java.lang.String r1 = r25.getLogoFileUri()     // Catch:{ Throwable -> 0x0271, all -> 0x026c }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Throwable -> 0x0271, all -> 0x026c }
            if (r1 != 0) goto L_0x0122
            java.lang.String r1 = "logo_file_uri"
            java.lang.String r3 = r25.getLogoFileUri()     // Catch:{ Throwable -> 0x0271, all -> 0x026c }
            r15.put(r1, r3)     // Catch:{ Throwable -> 0x0271, all -> 0x026c }
        L_0x0122:
            java.lang.String r1 = "logo_md5"
            java.lang.String r3 = r25.getLogoMd5()     // Catch:{ Throwable -> 0x0271, all -> 0x026c }
            r15.put(r1, r3)     // Catch:{ Throwable -> 0x0271, all -> 0x026c }
            java.lang.String r1 = "download_uuid"
            java.lang.String r3 = r25.getDownloadUid()     // Catch:{ Throwable -> 0x0271, all -> 0x026c }
            r15.put(r1, r3)     // Catch:{ Throwable -> 0x0271, all -> 0x026c }
            int r1 = r25.getDownloadState()     // Catch:{ Throwable -> 0x0271, all -> 0x026c }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ Throwable -> 0x0271, all -> 0x026c }
            r11 = r21
            r15.put(r11, r1)     // Catch:{ Throwable -> 0x0271, all -> 0x026c }
            long r5 = r25.getDownloadTime()     // Catch:{ Throwable -> 0x0271, all -> 0x026c }
            r7 = 0
            int r1 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r1 <= 0) goto L_0x0158
            java.lang.String r1 = "download_time"
            long r5 = r25.getDownloadTime()     // Catch:{ Throwable -> 0x0271, all -> 0x026c }
            java.lang.Long r3 = java.lang.Long.valueOf(r5)     // Catch:{ Throwable -> 0x0271, all -> 0x026c }
            r15.put(r1, r3)     // Catch:{ Throwable -> 0x0271, all -> 0x026c }
        L_0x0158:
            java.lang.String r1 = "protocol_version"
            long r5 = r25.getProtocolVersion()     // Catch:{ Throwable -> 0x0271, all -> 0x026c }
            java.lang.Long r3 = java.lang.Long.valueOf(r5)     // Catch:{ Throwable -> 0x0271, all -> 0x026c }
            r15.put(r1, r3)     // Catch:{ Throwable -> 0x0271, all -> 0x026c }
            long r5 = r25.getVersion()     // Catch:{ Throwable -> 0x0271, all -> 0x026c }
            int r1 = (r5 > r13 ? 1 : (r5 == r13 ? 0 : -1))
            if (r1 <= 0) goto L_0x01b7
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x0271, all -> 0x026c }
            r1.<init>()     // Catch:{ Throwable -> 0x0271, all -> 0x026c }
            java.lang.String r3 = "version updated, newVersion: "
            r1.append(r3)     // Catch:{ Throwable -> 0x0271, all -> 0x026c }
            r1.append(r5)     // Catch:{ Throwable -> 0x0271, all -> 0x026c }
            java.lang.String r3 = ", localVersion: "
            r1.append(r3)     // Catch:{ Throwable -> 0x0271, all -> 0x026c }
            r1.append(r13)     // Catch:{ Throwable -> 0x0271, all -> 0x026c }
            java.lang.String r1 = r1.toString()     // Catch:{ Throwable -> 0x0271, all -> 0x026c }
            com.oppo.camera.e.b(r2, r1)     // Catch:{ Throwable -> 0x0271, all -> 0x026c }
            long r5 = r25.getVersion()     // Catch:{ Throwable -> 0x0271, all -> 0x026c }
            java.lang.Long r1 = java.lang.Long.valueOf(r5)     // Catch:{ Throwable -> 0x0271, all -> 0x026c }
            r13 = r22
            r15.put(r13, r1)     // Catch:{ Throwable -> 0x0271, all -> 0x026c }
            java.lang.String r1 = "request_time"
            long r5 = r25.getLastRequestTime()     // Catch:{ Throwable -> 0x0271, all -> 0x026c }
            java.lang.Long r3 = java.lang.Long.valueOf(r5)     // Catch:{ Throwable -> 0x0271, all -> 0x026c }
            r15.put(r1, r3)     // Catch:{ Throwable -> 0x0271, all -> 0x026c }
            boolean r1 = r25.isBuildIn()     // Catch:{ Throwable -> 0x0271, all -> 0x026c }
            if (r1 != 0) goto L_0x01c2
            r15.put(r11, r0)     // Catch:{ Throwable -> 0x0271, all -> 0x026c }
            r0 = 1
            java.lang.Integer r1 = java.lang.Integer.valueOf(r0)     // Catch:{ Throwable -> 0x0271, all -> 0x026c }
            r14 = r20
            r15.put(r14, r1)     // Catch:{ Throwable -> 0x0271, all -> 0x026c }
            goto L_0x01c2
        L_0x01b7:
            r14 = r20
            boolean r1 = r25.isDownloaded()     // Catch:{ Throwable -> 0x0271, all -> 0x026c }
            if (r1 == 0) goto L_0x01c2
            r15.put(r14, r0)     // Catch:{ Throwable -> 0x0271, all -> 0x026c }
        L_0x01c2:
            java.lang.String r0 = "category_id"
            java.lang.String r1 = r25.getCategoryId()     // Catch:{ Throwable -> 0x0271, all -> 0x026c }
            r15.put(r0, r1)     // Catch:{ Throwable -> 0x0271, all -> 0x026c }
            java.lang.String r0 = "category_position"
            int r1 = r25.getCategoryPosition()     // Catch:{ Throwable -> 0x0271, all -> 0x026c }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ Throwable -> 0x0271, all -> 0x026c }
            r15.put(r0, r1)     // Catch:{ Throwable -> 0x0271, all -> 0x026c }
            java.lang.String r0 = "position"
            int r1 = r25.getPosition()     // Catch:{ Throwable -> 0x0271, all -> 0x026c }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ Throwable -> 0x0271, all -> 0x026c }
            r15.put(r0, r1)     // Catch:{ Throwable -> 0x0271, all -> 0x026c }
            java.lang.String r0 = "attribute"
            long r5 = r25.getAttribute()     // Catch:{ Throwable -> 0x0271, all -> 0x026c }
            java.lang.Long r1 = java.lang.Long.valueOf(r5)     // Catch:{ Throwable -> 0x0271, all -> 0x026c }
            r15.put(r0, r1)     // Catch:{ Throwable -> 0x0271, all -> 0x026c }
            java.lang.String r0 = "has_music"
            boolean r1 = r25.hasMusic()     // Catch:{ Throwable -> 0x0271, all -> 0x026c }
            if (r1 == 0) goto L_0x01fc
            r1 = 1
            goto L_0x01fd
        L_0x01fc:
            r1 = 0
        L_0x01fd:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ Throwable -> 0x0271, all -> 0x026c }
            r15.put(r0, r1)     // Catch:{ Throwable -> 0x0271, all -> 0x026c }
            java.lang.String r0 = "is_build_in"
            boolean r1 = r25.isBuildIn()     // Catch:{ Throwable -> 0x0271, all -> 0x026c }
            if (r1 == 0) goto L_0x020e
            r1 = 1
            goto L_0x020f
        L_0x020e:
            r1 = 0
        L_0x020f:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ Throwable -> 0x0271, all -> 0x026c }
            r15.put(r0, r1)     // Catch:{ Throwable -> 0x0271, all -> 0x026c }
            java.lang.String r0 = "is_new"
            boolean r1 = r25.isStickerNew()     // Catch:{ Throwable -> 0x0271, all -> 0x026c }
            if (r1 == 0) goto L_0x0220
            r1 = 1
            goto L_0x0221
        L_0x0220:
            r1 = 0
        L_0x0221:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ Throwable -> 0x0271, all -> 0x026c }
            r15.put(r0, r1)     // Catch:{ Throwable -> 0x0271, all -> 0x026c }
            java.lang.String r0 = "is_valid"
            boolean r1 = r25.isValid()     // Catch:{ Throwable -> 0x0271, all -> 0x026c }
            if (r1 == 0) goto L_0x0232
            r1 = 1
            goto L_0x0233
        L_0x0232:
            r1 = 0
        L_0x0233:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ Throwable -> 0x0271, all -> 0x026c }
            r15.put(r0, r1)     // Catch:{ Throwable -> 0x0271, all -> 0x026c }
            java.lang.String r0 = "material_type"
            int r1 = r25.getMaterialType()     // Catch:{ Throwable -> 0x0271, all -> 0x026c }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ Throwable -> 0x0271, all -> 0x026c }
            r15.put(r0, r1)     // Catch:{ Throwable -> 0x0271, all -> 0x026c }
            r0 = r16
            r1 = r17
            r3 = r18
            r5 = r19
            int r0 = r0.update(r5, r15, r1, r3)     // Catch:{ Throwable -> 0x0271, all -> 0x026c }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x0271, all -> 0x026c }
            r1.<init>()     // Catch:{ Throwable -> 0x0271, all -> 0x026c }
            java.lang.String r3 = "updateOrAddToStickerItemTable, update single item. count: "
            r1.append(r3)     // Catch:{ Throwable -> 0x0271, all -> 0x026c }
            r1.append(r0)     // Catch:{ Throwable -> 0x0271, all -> 0x026c }
            java.lang.String r0 = r1.toString()     // Catch:{ Throwable -> 0x0271, all -> 0x026c }
            com.oppo.camera.e.b(r2, r0)     // Catch:{ Throwable -> 0x0271, all -> 0x026c }
            r1 = r2
            r16 = r4
            goto L_0x0407
        L_0x026c:
            r0 = move-exception
            r1 = r2
            r16 = r4
            goto L_0x027c
        L_0x0271:
            r0 = move-exception
            r5 = r0
            r1 = r2
            r16 = r4
            goto L_0x041c
        L_0x0278:
            r0 = move-exception
            r16 = r4
            r1 = r2
        L_0x027c:
            r5 = 0
        L_0x027d:
            r2 = r0
            goto L_0x0420
        L_0x0280:
            r0 = move-exception
            r16 = r4
            r5 = r0
            r1 = r2
            goto L_0x041c
        L_0x0287:
            r0 = r16
            r16 = r4
            r4 = r19
            r23 = r14
            r14 = r11
            r11 = r13
            r13 = r23
            r17 = r2
            java.lang.String r2 = "_id"
            long r18 = r25.getStickerId()     // Catch:{ Throwable -> 0x0418, all -> 0x0412 }
            r20 = r0
            java.lang.Long r0 = java.lang.Long.valueOf(r18)     // Catch:{ Throwable -> 0x0418, all -> 0x0412 }
            r15.put(r2, r0)     // Catch:{ Throwable -> 0x0418, all -> 0x0412 }
            java.lang.String r0 = "uuid"
            java.lang.String r2 = r25.getStickerUUID()     // Catch:{ Throwable -> 0x0418, all -> 0x0412 }
            r15.put(r0, r2)     // Catch:{ Throwable -> 0x0418, all -> 0x0412 }
            java.lang.String r0 = r25.getStickerName()     // Catch:{ Throwable -> 0x0418, all -> 0x0412 }
            r15.put(r10, r0)     // Catch:{ Throwable -> 0x0418, all -> 0x0412 }
            java.lang.String r0 = r25.getFileDownloadUrl()     // Catch:{ Throwable -> 0x0418, all -> 0x0412 }
            r15.put(r1, r0)     // Catch:{ Throwable -> 0x0418, all -> 0x0412 }
            java.lang.String r0 = r25.getFileMd5()     // Catch:{ Throwable -> 0x0418, all -> 0x0412 }
            r15.put(r12, r0)     // Catch:{ Throwable -> 0x0418, all -> 0x0412 }
            java.lang.String r0 = r25.getFilePath()     // Catch:{ Throwable -> 0x0418, all -> 0x0412 }
            r15.put(r3, r0)     // Catch:{ Throwable -> 0x0418, all -> 0x0412 }
            java.lang.String r0 = r25.getFileContentUri()     // Catch:{ Throwable -> 0x0418, all -> 0x0412 }
            r15.put(r5, r0)     // Catch:{ Throwable -> 0x0418, all -> 0x0412 }
            java.lang.String r0 = r25.getThumbnailUrl()     // Catch:{ Throwable -> 0x0418, all -> 0x0412 }
            r15.put(r9, r0)     // Catch:{ Throwable -> 0x0418, all -> 0x0412 }
            java.lang.String r0 = r25.getThumbnailPath()     // Catch:{ Throwable -> 0x0418, all -> 0x0412 }
            r15.put(r8, r0)     // Catch:{ Throwable -> 0x0418, all -> 0x0412 }
            java.lang.String r0 = r25.getThumbnailFileUri()     // Catch:{ Throwable -> 0x0418, all -> 0x0412 }
            r15.put(r7, r0)     // Catch:{ Throwable -> 0x0418, all -> 0x0412 }
            java.lang.String r0 = r25.getThumbnailMd5()     // Catch:{ Throwable -> 0x0418, all -> 0x0412 }
            r15.put(r6, r0)     // Catch:{ Throwable -> 0x0418, all -> 0x0412 }
            java.lang.String r0 = "logo_url"
            java.lang.String r1 = r25.getLogoUrl()     // Catch:{ Throwable -> 0x0418, all -> 0x0412 }
            r15.put(r0, r1)     // Catch:{ Throwable -> 0x0418, all -> 0x0412 }
            java.lang.String r0 = "logo_path"
            java.lang.String r1 = r25.getLogoPath()     // Catch:{ Throwable -> 0x0418, all -> 0x0412 }
            r15.put(r0, r1)     // Catch:{ Throwable -> 0x0418, all -> 0x0412 }
            java.lang.String r0 = "logo_file_uri"
            java.lang.String r1 = r25.getLogoFileUri()     // Catch:{ Throwable -> 0x0418, all -> 0x0412 }
            r15.put(r0, r1)     // Catch:{ Throwable -> 0x0418, all -> 0x0412 }
            java.lang.String r0 = "logo_md5"
            java.lang.String r1 = r25.getLogoMd5()     // Catch:{ Throwable -> 0x0418, all -> 0x0412 }
            r15.put(r0, r1)     // Catch:{ Throwable -> 0x0418, all -> 0x0412 }
            java.lang.String r0 = "download_uuid"
            java.lang.String r1 = r25.getDownloadUid()     // Catch:{ Throwable -> 0x0418, all -> 0x0412 }
            r15.put(r0, r1)     // Catch:{ Throwable -> 0x0418, all -> 0x0412 }
            int r0 = r25.getDownloadState()     // Catch:{ Throwable -> 0x0418, all -> 0x0412 }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ Throwable -> 0x0418, all -> 0x0412 }
            r15.put(r11, r0)     // Catch:{ Throwable -> 0x0418, all -> 0x0412 }
            java.lang.String r0 = "download_time"
            long r1 = r25.getDownloadTime()     // Catch:{ Throwable -> 0x0418, all -> 0x0412 }
            java.lang.Long r1 = java.lang.Long.valueOf(r1)     // Catch:{ Throwable -> 0x0418, all -> 0x0412 }
            r15.put(r0, r1)     // Catch:{ Throwable -> 0x0418, all -> 0x0412 }
            long r0 = r25.getVersion()     // Catch:{ Throwable -> 0x0418, all -> 0x0412 }
            java.lang.Long r0 = java.lang.Long.valueOf(r0)     // Catch:{ Throwable -> 0x0418, all -> 0x0412 }
            r15.put(r13, r0)     // Catch:{ Throwable -> 0x0418, all -> 0x0412 }
            java.lang.String r0 = "protocol_version"
            long r1 = r25.getProtocolVersion()     // Catch:{ Throwable -> 0x0418, all -> 0x0412 }
            java.lang.Long r1 = java.lang.Long.valueOf(r1)     // Catch:{ Throwable -> 0x0418, all -> 0x0412 }
            r15.put(r0, r1)     // Catch:{ Throwable -> 0x0418, all -> 0x0412 }
            java.lang.String r0 = "request_time"
            long r1 = r25.getLastRequestTime()     // Catch:{ Throwable -> 0x0418, all -> 0x0412 }
            java.lang.Long r1 = java.lang.Long.valueOf(r1)     // Catch:{ Throwable -> 0x0418, all -> 0x0412 }
            r15.put(r0, r1)     // Catch:{ Throwable -> 0x0418, all -> 0x0412 }
            java.lang.String r0 = "category_id"
            java.lang.String r1 = r25.getCategoryId()     // Catch:{ Throwable -> 0x0418, all -> 0x0412 }
            r15.put(r0, r1)     // Catch:{ Throwable -> 0x0418, all -> 0x0412 }
            java.lang.String r0 = "category_position"
            int r1 = r25.getCategoryPosition()     // Catch:{ Throwable -> 0x0418, all -> 0x0412 }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ Throwable -> 0x0418, all -> 0x0412 }
            r15.put(r0, r1)     // Catch:{ Throwable -> 0x0418, all -> 0x0412 }
            java.lang.String r0 = "position"
            int r1 = r25.getPosition()     // Catch:{ Throwable -> 0x0418, all -> 0x0412 }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ Throwable -> 0x0418, all -> 0x0412 }
            r15.put(r0, r1)     // Catch:{ Throwable -> 0x0418, all -> 0x0412 }
            java.lang.String r0 = "attribute"
            long r1 = r25.getAttribute()     // Catch:{ Throwable -> 0x0418, all -> 0x0412 }
            java.lang.Long r1 = java.lang.Long.valueOf(r1)     // Catch:{ Throwable -> 0x0418, all -> 0x0412 }
            r15.put(r0, r1)     // Catch:{ Throwable -> 0x0418, all -> 0x0412 }
            boolean r0 = r25.needUpdate()     // Catch:{ Throwable -> 0x0418, all -> 0x0412 }
            if (r0 == 0) goto L_0x038e
            r0 = 1
            goto L_0x038f
        L_0x038e:
            r0 = 0
        L_0x038f:
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ Throwable -> 0x0418, all -> 0x0412 }
            r15.put(r14, r0)     // Catch:{ Throwable -> 0x0418, all -> 0x0412 }
            java.lang.String r0 = "has_music"
            boolean r1 = r25.hasMusic()     // Catch:{ Throwable -> 0x0418, all -> 0x0412 }
            if (r1 == 0) goto L_0x03a0
            r1 = 1
            goto L_0x03a1
        L_0x03a0:
            r1 = 0
        L_0x03a1:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ Throwable -> 0x0418, all -> 0x0412 }
            r15.put(r0, r1)     // Catch:{ Throwable -> 0x0418, all -> 0x0412 }
            java.lang.String r0 = "is_build_in"
            boolean r1 = r25.isBuildIn()     // Catch:{ Throwable -> 0x0418, all -> 0x0412 }
            if (r1 == 0) goto L_0x03b2
            r1 = 1
            goto L_0x03b3
        L_0x03b2:
            r1 = 0
        L_0x03b3:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ Throwable -> 0x0418, all -> 0x0412 }
            r15.put(r0, r1)     // Catch:{ Throwable -> 0x0418, all -> 0x0412 }
            java.lang.String r0 = "is_new"
            boolean r1 = r25.isStickerNew()     // Catch:{ Throwable -> 0x0418, all -> 0x0412 }
            if (r1 == 0) goto L_0x03c4
            r1 = 1
            goto L_0x03c5
        L_0x03c4:
            r1 = 0
        L_0x03c5:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ Throwable -> 0x0418, all -> 0x0412 }
            r15.put(r0, r1)     // Catch:{ Throwable -> 0x0418, all -> 0x0412 }
            java.lang.String r0 = "is_valid"
            boolean r1 = r25.isValid()     // Catch:{ Throwable -> 0x0418, all -> 0x0412 }
            if (r1 == 0) goto L_0x03d6
            r1 = 1
            goto L_0x03d7
        L_0x03d6:
            r1 = 0
        L_0x03d7:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ Throwable -> 0x0418, all -> 0x0412 }
            r15.put(r0, r1)     // Catch:{ Throwable -> 0x0418, all -> 0x0412 }
            java.lang.String r0 = "material_type"
            int r1 = r25.getMaterialType()     // Catch:{ Throwable -> 0x0418, all -> 0x0412 }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ Throwable -> 0x0418, all -> 0x0412 }
            r15.put(r0, r1)     // Catch:{ Throwable -> 0x0418, all -> 0x0412 }
            r0 = r20
            android.net.Uri r0 = r0.insert(r4, r15)     // Catch:{ Throwable -> 0x0418, all -> 0x0412 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x0418, all -> 0x0412 }
            r1.<init>()     // Catch:{ Throwable -> 0x0418, all -> 0x0412 }
            java.lang.String r2 = "updateOrAddToStickerItemTable, insert single item. insertUri: "
            r1.append(r2)     // Catch:{ Throwable -> 0x0418, all -> 0x0412 }
            r1.append(r0)     // Catch:{ Throwable -> 0x0418, all -> 0x0412 }
            java.lang.String r0 = r1.toString()     // Catch:{ Throwable -> 0x0418, all -> 0x0412 }
            r1 = r17
            com.oppo.camera.e.b(r1, r0)     // Catch:{ Throwable -> 0x0410, all -> 0x040e }
        L_0x0407:
            if (r16 == 0) goto L_0x040c
            r16.close()     // Catch:{ Exception -> 0x0432 }
        L_0x040c:
            r0 = 1
            return r0
        L_0x040e:
            r0 = move-exception
            goto L_0x0415
        L_0x0410:
            r0 = move-exception
            goto L_0x041b
        L_0x0412:
            r0 = move-exception
            r1 = r17
        L_0x0415:
            r2 = r0
            r5 = 0
            goto L_0x0420
        L_0x0418:
            r0 = move-exception
            r1 = r17
        L_0x041b:
            r5 = r0
        L_0x041c:
            throw r5     // Catch:{ all -> 0x041d }
        L_0x041d:
            r0 = move-exception
            goto L_0x027d
        L_0x0420:
            if (r16 == 0) goto L_0x0431
            if (r5 == 0) goto L_0x042e
            r16.close()     // Catch:{ Throwable -> 0x0428 }
            goto L_0x0431
        L_0x0428:
            r0 = move-exception
            r3 = r0
            r5.addSuppressed(r3)     // Catch:{ Exception -> 0x0432 }
            goto L_0x0431
        L_0x042e:
            r16.close()     // Catch:{ Exception -> 0x0432 }
        L_0x0431:
            throw r2     // Catch:{ Exception -> 0x0432 }
        L_0x0432:
            r0 = move-exception
            goto L_0x0436
        L_0x0434:
            r0 = move-exception
            r1 = r2
        L_0x0436:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "updateOrAddToStickerItemTable cause a exception, exception: "
            r2.append(r3)
            r2.append(r0)
            java.lang.String r0 = ", stickerItem: "
            r2.append(r0)
            r3 = r25
            r2.append(r3)
            java.lang.String r0 = r2.toString()
            com.oppo.camera.e.d(r1, r0)
            r2 = 0
            return r2
        L_0x0456:
            r1 = r2
            r2 = r3
            java.lang.String r0 = "updateOrAddToStickerItemTable, context or category is null!"
            com.oppo.camera.e.d(r1, r0)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.sticker.a.b.a(android.content.Context, com.oppo.camera.sticker.data.StickerItemWrapper):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:116:0x0450 A[SYNTHETIC, Splitter:B:116:0x0450] */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x0487  */
    /* JADX WARNING: Removed duplicated region for block: B:164:0x04cd  */
    /* JADX WARNING: Removed duplicated region for block: B:167:0x04d9  */
    /* JADX WARNING: Removed duplicated region for block: B:176:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(android.content.Context r26, java.util.List<com.oppo.camera.sticker.data.StickerItemWrapper> r27) {
        /*
            java.lang.String r1 = "StickerItemTableHelper"
            r2 = 0
            java.lang.Integer r3 = java.lang.Integer.valueOf(r2)
            if (r27 == 0) goto L_0x04e0
            int r4 = r27.size()
            if (r4 != 0) goto L_0x0011
            goto L_0x04e0
        L_0x0011:
            java.lang.String r4 = "sticker.db"
            r5 = r26
            java.io.File r4 = r5.getDatabasePath(r4)
            java.lang.String r4 = r4.getPath()
            r5 = 0
            android.database.sqlite.SQLiteDatabase r4 = android.database.sqlite.SQLiteDatabase.openDatabase(r4, r5, r2)
            r4.beginTransaction()     // Catch:{ Exception -> 0x04b0, all -> 0x04ac }
            android.content.ContentValues r14 = new android.content.ContentValues     // Catch:{ Exception -> 0x04b0, all -> 0x04ac }
            r14.<init>()     // Catch:{ Exception -> 0x04b0, all -> 0x04ac }
            java.lang.String r15 = "sticker_item"
            java.util.Iterator r16 = r27.iterator()     // Catch:{ Exception -> 0x04b0, all -> 0x04ac }
        L_0x0030:
            boolean r6 = r16.hasNext()     // Catch:{ Exception -> 0x04b0, all -> 0x04ac }
            r13 = 1
            if (r6 == 0) goto L_0x0497
            java.lang.Object r6 = r16.next()     // Catch:{ Exception -> 0x04b0, all -> 0x04ac }
            r12 = r6
            com.oppo.camera.sticker.data.StickerItemWrapper r12 = (com.oppo.camera.sticker.data.StickerItemWrapper) r12     // Catch:{ Exception -> 0x04b0, all -> 0x04ac }
            java.lang.String r6 = r12.getCategoryId()     // Catch:{ Exception -> 0x04b0, all -> 0x04ac }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ Exception -> 0x04b0, all -> 0x04ac }
            if (r6 == 0) goto L_0x006b
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0062, all -> 0x005d }
            r6.<init>()     // Catch:{ Exception -> 0x0062, all -> 0x005d }
            java.lang.String r7 = "updateOrAddToStickerItemTable, stickerItem category id is empty! stickerItem: "
            r6.append(r7)     // Catch:{ Exception -> 0x0062, all -> 0x005d }
            r6.append(r12)     // Catch:{ Exception -> 0x0062, all -> 0x005d }
            java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x0062, all -> 0x005d }
            com.oppo.camera.e.d(r1, r6)     // Catch:{ Exception -> 0x0062, all -> 0x005d }
            goto L_0x0030
        L_0x005d:
            r0 = move-exception
            r2 = r0
            r1 = r4
            goto L_0x04d7
        L_0x0062:
            r0 = move-exception
            r2 = r0
            r25 = r4
            r4 = r1
            r1 = r25
            goto L_0x04b7
        L_0x006b:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x04b0, all -> 0x04ac }
            r6.<init>()     // Catch:{ Exception -> 0x04b0, all -> 0x04ac }
            java.lang.String r7 = "updateOrAddToStickerItemTable, stickerItem = "
            r6.append(r7)     // Catch:{ Exception -> 0x04b0, all -> 0x04ac }
            r6.append(r12)     // Catch:{ Exception -> 0x04b0, all -> 0x04ac }
            java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x04b0, all -> 0x04ac }
            com.oppo.camera.e.b(r1, r6)     // Catch:{ Exception -> 0x04b0, all -> 0x04ac }
            r14.clear()     // Catch:{ Exception -> 0x04b0, all -> 0x04ac }
            java.lang.String r11 = "uuid = ?"
            java.lang.String[] r10 = new java.lang.String[r13]     // Catch:{ Exception -> 0x04b0, all -> 0x04ac }
            java.lang.String r6 = r12.getStickerUUID()     // Catch:{ Exception -> 0x04b0, all -> 0x04ac }
            java.lang.String r6 = java.lang.String.valueOf(r6)     // Catch:{ Exception -> 0x04b0, all -> 0x04ac }
            r10[r2] = r6     // Catch:{ Exception -> 0x04b0, all -> 0x04ac }
            r8 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r6 = r4
            r7 = r15
            r9 = r11
            r26 = r10
            r2 = r11
            r11 = r17
            r17 = r12
            r12 = r18
            r18 = r13
            r13 = r19
            android.database.Cursor r6 = r6.query(r7, r8, r9, r10, r11, r12, r13)     // Catch:{ Exception -> 0x04b0, all -> 0x04ac }
            java.lang.String r7 = "thumbnail_file_uri"
            java.lang.String r8 = "thumbnail_path"
            java.lang.String r9 = "thumbnail_url"
            java.lang.String r10 = "file_content_uri"
            java.lang.String r11 = "file_path"
            java.lang.String r12 = "file_md5"
            java.lang.String r13 = "file_url"
            java.lang.String r5 = "name"
            r27 = r2
            java.lang.String r2 = "need_update"
            r20 = r4
            java.lang.String r4 = "version"
            r21 = r15
            java.lang.String r15 = "download_state"
            if (r6 == 0) goto L_0x02c9
            int r22 = r6.getCount()     // Catch:{ Throwable -> 0x02c0, all -> 0x02b6 }
            if (r22 <= 0) goto L_0x02c9
            r6.moveToFirst()     // Catch:{ Throwable -> 0x02b0, all -> 0x02aa }
            r22 = r2
            int r2 = r6.getColumnIndexOrThrow(r4)     // Catch:{ Throwable -> 0x02b0, all -> 0x02aa }
            r23 = r3
            long r2 = r6.getLong(r2)     // Catch:{ Throwable -> 0x02b0, all -> 0x02aa }
            r24 = r4
            int r4 = r6.getColumnIndexOrThrow(r15)     // Catch:{ Throwable -> 0x02b0, all -> 0x02aa }
            r6.getInt(r4)     // Catch:{ Throwable -> 0x02b0, all -> 0x02aa }
            java.lang.String r4 = r17.getStickerName()     // Catch:{ Throwable -> 0x02b0, all -> 0x02aa }
            r14.put(r5, r4)     // Catch:{ Throwable -> 0x02b0, all -> 0x02aa }
            java.lang.String r4 = r17.getFileDownloadUrl()     // Catch:{ Throwable -> 0x02b0, all -> 0x02aa }
            r14.put(r13, r4)     // Catch:{ Throwable -> 0x02b0, all -> 0x02aa }
            java.lang.String r4 = r17.getFileMd5()     // Catch:{ Throwable -> 0x02b0, all -> 0x02aa }
            r14.put(r12, r4)     // Catch:{ Throwable -> 0x02b0, all -> 0x02aa }
            java.lang.String r4 = r17.getFilePath()     // Catch:{ Throwable -> 0x02b0, all -> 0x02aa }
            boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Throwable -> 0x02b0, all -> 0x02aa }
            if (r4 != 0) goto L_0x010d
            java.lang.String r4 = r17.getFilePath()     // Catch:{ Throwable -> 0x02b0, all -> 0x02aa }
            r14.put(r11, r4)     // Catch:{ Throwable -> 0x02b0, all -> 0x02aa }
        L_0x010d:
            java.lang.String r4 = r17.getFileContentUri()     // Catch:{ Throwable -> 0x02b0, all -> 0x02aa }
            boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Throwable -> 0x02b0, all -> 0x02aa }
            if (r4 != 0) goto L_0x011e
            java.lang.String r4 = r17.getFileContentUri()     // Catch:{ Throwable -> 0x02b0, all -> 0x02aa }
            r14.put(r10, r4)     // Catch:{ Throwable -> 0x02b0, all -> 0x02aa }
        L_0x011e:
            java.lang.String r4 = r17.getThumbnailUrl()     // Catch:{ Throwable -> 0x02b0, all -> 0x02aa }
            r14.put(r9, r4)     // Catch:{ Throwable -> 0x02b0, all -> 0x02aa }
            java.lang.String r4 = r17.getThumbnailPath()     // Catch:{ Throwable -> 0x02b0, all -> 0x02aa }
            boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Throwable -> 0x02b0, all -> 0x02aa }
            if (r4 != 0) goto L_0x0136
            java.lang.String r4 = r17.getThumbnailPath()     // Catch:{ Throwable -> 0x02b0, all -> 0x02aa }
            r14.put(r8, r4)     // Catch:{ Throwable -> 0x02b0, all -> 0x02aa }
        L_0x0136:
            java.lang.String r4 = r17.getThumbnailFileUri()     // Catch:{ Throwable -> 0x02b0, all -> 0x02aa }
            boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Throwable -> 0x02b0, all -> 0x02aa }
            if (r4 != 0) goto L_0x0147
            java.lang.String r4 = r17.getThumbnailFileUri()     // Catch:{ Throwable -> 0x02b0, all -> 0x02aa }
            r14.put(r7, r4)     // Catch:{ Throwable -> 0x02b0, all -> 0x02aa }
        L_0x0147:
            java.lang.String r4 = "thumbnail_md5"
            java.lang.String r5 = r17.getThumbnailMd5()     // Catch:{ Throwable -> 0x02b0, all -> 0x02aa }
            r14.put(r4, r5)     // Catch:{ Throwable -> 0x02b0, all -> 0x02aa }
            java.lang.String r4 = "logo_url"
            java.lang.String r5 = r17.getLogoUrl()     // Catch:{ Throwable -> 0x02b0, all -> 0x02aa }
            r14.put(r4, r5)     // Catch:{ Throwable -> 0x02b0, all -> 0x02aa }
            java.lang.String r4 = r17.getLogoPath()     // Catch:{ Throwable -> 0x02b0, all -> 0x02aa }
            boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Throwable -> 0x02b0, all -> 0x02aa }
            if (r4 != 0) goto L_0x016c
            java.lang.String r4 = "logo_path"
            java.lang.String r5 = r17.getLogoPath()     // Catch:{ Throwable -> 0x02b0, all -> 0x02aa }
            r14.put(r4, r5)     // Catch:{ Throwable -> 0x02b0, all -> 0x02aa }
        L_0x016c:
            java.lang.String r4 = r17.getLogoFileUri()     // Catch:{ Throwable -> 0x02b0, all -> 0x02aa }
            boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Throwable -> 0x02b0, all -> 0x02aa }
            if (r4 != 0) goto L_0x017f
            java.lang.String r4 = "logo_file_uri"
            java.lang.String r5 = r17.getLogoFileUri()     // Catch:{ Throwable -> 0x02b0, all -> 0x02aa }
            r14.put(r4, r5)     // Catch:{ Throwable -> 0x02b0, all -> 0x02aa }
        L_0x017f:
            java.lang.String r4 = "logo_md5"
            java.lang.String r5 = r17.getLogoMd5()     // Catch:{ Throwable -> 0x02b0, all -> 0x02aa }
            r14.put(r4, r5)     // Catch:{ Throwable -> 0x02b0, all -> 0x02aa }
            java.lang.String r4 = "download_uuid"
            java.lang.String r5 = r17.getDownloadUid()     // Catch:{ Throwable -> 0x02b0, all -> 0x02aa }
            r14.put(r4, r5)     // Catch:{ Throwable -> 0x02b0, all -> 0x02aa }
            int r4 = r17.getDownloadState()     // Catch:{ Throwable -> 0x02b0, all -> 0x02aa }
            if (r4 == 0) goto L_0x01a2
            int r4 = r17.getDownloadState()     // Catch:{ Throwable -> 0x02b0, all -> 0x02aa }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ Throwable -> 0x02b0, all -> 0x02aa }
            r14.put(r15, r4)     // Catch:{ Throwable -> 0x02b0, all -> 0x02aa }
        L_0x01a2:
            long r4 = r17.getDownloadTime()     // Catch:{ Throwable -> 0x02b0, all -> 0x02aa }
            r7 = 0
            int r4 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r4 <= 0) goto L_0x01b9
            java.lang.String r4 = "download_time"
            long r7 = r17.getDownloadTime()     // Catch:{ Throwable -> 0x02b0, all -> 0x02aa }
            java.lang.Long r5 = java.lang.Long.valueOf(r7)     // Catch:{ Throwable -> 0x02b0, all -> 0x02aa }
            r14.put(r4, r5)     // Catch:{ Throwable -> 0x02b0, all -> 0x02aa }
        L_0x01b9:
            java.lang.String r4 = "protocol_version"
            long r7 = r17.getProtocolVersion()     // Catch:{ Throwable -> 0x02b0, all -> 0x02aa }
            java.lang.Long r5 = java.lang.Long.valueOf(r7)     // Catch:{ Throwable -> 0x02b0, all -> 0x02aa }
            r14.put(r4, r5)     // Catch:{ Throwable -> 0x02b0, all -> 0x02aa }
            long r4 = r17.getVersion()     // Catch:{ Throwable -> 0x02b0, all -> 0x02aa }
            int r7 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r7 <= 0) goto L_0x0202
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x02b0, all -> 0x02aa }
            r7.<init>()     // Catch:{ Throwable -> 0x02b0, all -> 0x02aa }
            java.lang.String r8 = "version updated, newVersion: "
            r7.append(r8)     // Catch:{ Throwable -> 0x02b0, all -> 0x02aa }
            r7.append(r4)     // Catch:{ Throwable -> 0x02b0, all -> 0x02aa }
            java.lang.String r8 = ", localVersion: "
            r7.append(r8)     // Catch:{ Throwable -> 0x02b0, all -> 0x02aa }
            r7.append(r2)     // Catch:{ Throwable -> 0x02b0, all -> 0x02aa }
            java.lang.String r2 = r7.toString()     // Catch:{ Throwable -> 0x02b0, all -> 0x02aa }
            com.oppo.camera.e.b(r1, r2)     // Catch:{ Throwable -> 0x02b0, all -> 0x02aa }
            java.lang.Long r2 = java.lang.Long.valueOf(r4)     // Catch:{ Throwable -> 0x02b0, all -> 0x02aa }
            r3 = r24
            r14.put(r3, r2)     // Catch:{ Throwable -> 0x02b0, all -> 0x02aa }
            r2 = r23
            r14.put(r15, r2)     // Catch:{ Throwable -> 0x02b0, all -> 0x02aa }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r18)     // Catch:{ Throwable -> 0x02b0, all -> 0x02aa }
            r4 = r22
            r14.put(r4, r3)     // Catch:{ Throwable -> 0x02b0, all -> 0x02aa }
            goto L_0x020f
        L_0x0202:
            r4 = r22
            r2 = r23
            boolean r3 = r17.isDownloaded()     // Catch:{ Throwable -> 0x02b0, all -> 0x02aa }
            if (r3 == 0) goto L_0x020f
            r14.put(r4, r2)     // Catch:{ Throwable -> 0x02b0, all -> 0x02aa }
        L_0x020f:
            java.lang.String r3 = "category_id"
            java.lang.String r4 = r17.getCategoryId()     // Catch:{ Throwable -> 0x02b0, all -> 0x02aa }
            r14.put(r3, r4)     // Catch:{ Throwable -> 0x02b0, all -> 0x02aa }
            java.lang.String r3 = "category_position"
            int r4 = r17.getCategoryPosition()     // Catch:{ Throwable -> 0x02b0, all -> 0x02aa }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ Throwable -> 0x02b0, all -> 0x02aa }
            r14.put(r3, r4)     // Catch:{ Throwable -> 0x02b0, all -> 0x02aa }
            java.lang.String r3 = "position"
            int r4 = r17.getPosition()     // Catch:{ Throwable -> 0x02b0, all -> 0x02aa }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ Throwable -> 0x02b0, all -> 0x02aa }
            r14.put(r3, r4)     // Catch:{ Throwable -> 0x02b0, all -> 0x02aa }
            java.lang.String r3 = "attribute"
            long r4 = r17.getAttribute()     // Catch:{ Throwable -> 0x02b0, all -> 0x02aa }
            java.lang.Long r4 = java.lang.Long.valueOf(r4)     // Catch:{ Throwable -> 0x02b0, all -> 0x02aa }
            r14.put(r3, r4)     // Catch:{ Throwable -> 0x02b0, all -> 0x02aa }
            java.lang.String r3 = "has_music"
            boolean r4 = r17.hasMusic()     // Catch:{ Throwable -> 0x02b0, all -> 0x02aa }
            if (r4 == 0) goto L_0x024a
            r4 = r18
            goto L_0x024b
        L_0x024a:
            r4 = 0
        L_0x024b:
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ Throwable -> 0x02b0, all -> 0x02aa }
            r14.put(r3, r4)     // Catch:{ Throwable -> 0x02b0, all -> 0x02aa }
            java.lang.String r3 = "is_valid"
            boolean r4 = r17.isValid()     // Catch:{ Throwable -> 0x02b0, all -> 0x02aa }
            if (r4 == 0) goto L_0x025b
            goto L_0x025d
        L_0x025b:
            r18 = 0
        L_0x025d:
            java.lang.Integer r4 = java.lang.Integer.valueOf(r18)     // Catch:{ Throwable -> 0x02b0, all -> 0x02aa }
            r14.put(r3, r4)     // Catch:{ Throwable -> 0x02b0, all -> 0x02aa }
            java.lang.String r3 = "material_type"
            int r4 = r17.getMaterialType()     // Catch:{ Throwable -> 0x02b0, all -> 0x02aa }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ Throwable -> 0x02b0, all -> 0x02aa }
            r14.put(r3, r4)     // Catch:{ Throwable -> 0x02b0, all -> 0x02aa }
            r7 = r26
            r5 = r27
            r3 = r20
            r4 = r21
            int r5 = r3.update(r4, r14, r5, r7)     // Catch:{ Throwable -> 0x02a2, all -> 0x029b }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x02a2, all -> 0x029b }
            r7.<init>()     // Catch:{ Throwable -> 0x02a2, all -> 0x029b }
            java.lang.String r8 = "updateOrAddToStickerItemTable, update count: "
            r7.append(r8)     // Catch:{ Throwable -> 0x02a2, all -> 0x029b }
            r7.append(r5)     // Catch:{ Throwable -> 0x02a2, all -> 0x029b }
            java.lang.String r5 = r7.toString()     // Catch:{ Throwable -> 0x02a2, all -> 0x029b }
            com.oppo.camera.e.b(r1, r5)     // Catch:{ Throwable -> 0x02a2, all -> 0x029b }
            r23 = r2
            r26 = r6
            r2 = 0
            r6 = r4
            r4 = r1
            r1 = r3
            goto L_0x044e
        L_0x029b:
            r0 = move-exception
            r2 = r0
            r4 = r1
            r1 = r3
            r26 = r6
            goto L_0x02bd
        L_0x02a2:
            r0 = move-exception
            r5 = r0
            r4 = r1
            r1 = r3
            r26 = r6
            goto L_0x0482
        L_0x02aa:
            r0 = move-exception
            r2 = r0
            r4 = r1
            r26 = r6
            goto L_0x02bb
        L_0x02b0:
            r0 = move-exception
            r5 = r0
            r4 = r1
            r26 = r6
            goto L_0x02c5
        L_0x02b6:
            r0 = move-exception
            r26 = r6
            r2 = r0
            r4 = r1
        L_0x02bb:
            r1 = r20
        L_0x02bd:
            r5 = 0
            goto L_0x0485
        L_0x02c0:
            r0 = move-exception
            r26 = r6
            r5 = r0
            r4 = r1
        L_0x02c5:
            r1 = r20
            goto L_0x0482
        L_0x02c9:
            r23 = r3
            r3 = r4
            r26 = r6
            r6 = r21
            r4 = r2
            r2 = r20
            r20 = r1
            java.lang.String r1 = "_id"
            long r21 = r17.getStickerId()     // Catch:{ Throwable -> 0x047d, all -> 0x0475 }
            r24 = r2
            java.lang.Long r2 = java.lang.Long.valueOf(r21)     // Catch:{ Throwable -> 0x046f, all -> 0x0469 }
            r14.put(r1, r2)     // Catch:{ Throwable -> 0x046f, all -> 0x0469 }
            java.lang.String r1 = "uuid"
            java.lang.String r2 = r17.getStickerUUID()     // Catch:{ Throwable -> 0x046f, all -> 0x0469 }
            r14.put(r1, r2)     // Catch:{ Throwable -> 0x046f, all -> 0x0469 }
            java.lang.String r1 = r17.getStickerName()     // Catch:{ Throwable -> 0x046f, all -> 0x0469 }
            r14.put(r5, r1)     // Catch:{ Throwable -> 0x046f, all -> 0x0469 }
            java.lang.String r1 = r17.getFileDownloadUrl()     // Catch:{ Throwable -> 0x046f, all -> 0x0469 }
            r14.put(r13, r1)     // Catch:{ Throwable -> 0x046f, all -> 0x0469 }
            java.lang.String r1 = r17.getFileMd5()     // Catch:{ Throwable -> 0x046f, all -> 0x0469 }
            r14.put(r12, r1)     // Catch:{ Throwable -> 0x046f, all -> 0x0469 }
            java.lang.String r1 = r17.getFilePath()     // Catch:{ Throwable -> 0x046f, all -> 0x0469 }
            r14.put(r11, r1)     // Catch:{ Throwable -> 0x046f, all -> 0x0469 }
            java.lang.String r1 = r17.getFileContentUri()     // Catch:{ Throwable -> 0x046f, all -> 0x0469 }
            r14.put(r10, r1)     // Catch:{ Throwable -> 0x046f, all -> 0x0469 }
            java.lang.String r1 = r17.getThumbnailUrl()     // Catch:{ Throwable -> 0x046f, all -> 0x0469 }
            r14.put(r9, r1)     // Catch:{ Throwable -> 0x046f, all -> 0x0469 }
            java.lang.String r1 = r17.getThumbnailPath()     // Catch:{ Throwable -> 0x046f, all -> 0x0469 }
            r14.put(r8, r1)     // Catch:{ Throwable -> 0x046f, all -> 0x0469 }
            java.lang.String r1 = r17.getThumbnailFileUri()     // Catch:{ Throwable -> 0x046f, all -> 0x0469 }
            r14.put(r7, r1)     // Catch:{ Throwable -> 0x046f, all -> 0x0469 }
            java.lang.String r1 = "thumbnail_md5"
            java.lang.String r2 = r17.getThumbnailMd5()     // Catch:{ Throwable -> 0x046f, all -> 0x0469 }
            r14.put(r1, r2)     // Catch:{ Throwable -> 0x046f, all -> 0x0469 }
            java.lang.String r1 = "logo_url"
            java.lang.String r2 = r17.getLogoUrl()     // Catch:{ Throwable -> 0x046f, all -> 0x0469 }
            r14.put(r1, r2)     // Catch:{ Throwable -> 0x046f, all -> 0x0469 }
            java.lang.String r1 = "logo_path"
            java.lang.String r2 = r17.getLogoPath()     // Catch:{ Throwable -> 0x046f, all -> 0x0469 }
            r14.put(r1, r2)     // Catch:{ Throwable -> 0x046f, all -> 0x0469 }
            java.lang.String r1 = "logo_file_uri"
            java.lang.String r2 = r17.getLogoFileUri()     // Catch:{ Throwable -> 0x046f, all -> 0x0469 }
            r14.put(r1, r2)     // Catch:{ Throwable -> 0x046f, all -> 0x0469 }
            java.lang.String r1 = "logo_md5"
            java.lang.String r2 = r17.getLogoMd5()     // Catch:{ Throwable -> 0x046f, all -> 0x0469 }
            r14.put(r1, r2)     // Catch:{ Throwable -> 0x046f, all -> 0x0469 }
            java.lang.String r1 = "download_uuid"
            java.lang.String r2 = r17.getDownloadUid()     // Catch:{ Throwable -> 0x046f, all -> 0x0469 }
            r14.put(r1, r2)     // Catch:{ Throwable -> 0x046f, all -> 0x0469 }
            int r1 = r17.getDownloadState()     // Catch:{ Throwable -> 0x046f, all -> 0x0469 }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ Throwable -> 0x046f, all -> 0x0469 }
            r14.put(r15, r1)     // Catch:{ Throwable -> 0x046f, all -> 0x0469 }
            java.lang.String r1 = "download_time"
            long r7 = r17.getDownloadTime()     // Catch:{ Throwable -> 0x046f, all -> 0x0469 }
            java.lang.Long r2 = java.lang.Long.valueOf(r7)     // Catch:{ Throwable -> 0x046f, all -> 0x0469 }
            r14.put(r1, r2)     // Catch:{ Throwable -> 0x046f, all -> 0x0469 }
            long r1 = r17.getVersion()     // Catch:{ Throwable -> 0x046f, all -> 0x0469 }
            java.lang.Long r1 = java.lang.Long.valueOf(r1)     // Catch:{ Throwable -> 0x046f, all -> 0x0469 }
            r14.put(r3, r1)     // Catch:{ Throwable -> 0x046f, all -> 0x0469 }
            java.lang.String r1 = "protocol_version"
            long r2 = r17.getProtocolVersion()     // Catch:{ Throwable -> 0x046f, all -> 0x0469 }
            java.lang.Long r2 = java.lang.Long.valueOf(r2)     // Catch:{ Throwable -> 0x046f, all -> 0x0469 }
            r14.put(r1, r2)     // Catch:{ Throwable -> 0x046f, all -> 0x0469 }
            java.lang.String r1 = "request_time"
            long r2 = r17.getLastRequestTime()     // Catch:{ Throwable -> 0x046f, all -> 0x0469 }
            java.lang.Long r2 = java.lang.Long.valueOf(r2)     // Catch:{ Throwable -> 0x046f, all -> 0x0469 }
            r14.put(r1, r2)     // Catch:{ Throwable -> 0x046f, all -> 0x0469 }
            java.lang.String r1 = "category_id"
            java.lang.String r2 = r17.getCategoryId()     // Catch:{ Throwable -> 0x046f, all -> 0x0469 }
            r14.put(r1, r2)     // Catch:{ Throwable -> 0x046f, all -> 0x0469 }
            java.lang.String r1 = "category_position"
            int r2 = r17.getCategoryPosition()     // Catch:{ Throwable -> 0x046f, all -> 0x0469 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ Throwable -> 0x046f, all -> 0x0469 }
            r14.put(r1, r2)     // Catch:{ Throwable -> 0x046f, all -> 0x0469 }
            java.lang.String r1 = "position"
            int r2 = r17.getPosition()     // Catch:{ Throwable -> 0x046f, all -> 0x0469 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ Throwable -> 0x046f, all -> 0x0469 }
            r14.put(r1, r2)     // Catch:{ Throwable -> 0x046f, all -> 0x0469 }
            java.lang.String r1 = "attribute"
            long r2 = r17.getAttribute()     // Catch:{ Throwable -> 0x046f, all -> 0x0469 }
            java.lang.Long r2 = java.lang.Long.valueOf(r2)     // Catch:{ Throwable -> 0x046f, all -> 0x0469 }
            r14.put(r1, r2)     // Catch:{ Throwable -> 0x046f, all -> 0x0469 }
            boolean r1 = r17.needUpdate()     // Catch:{ Throwable -> 0x046f, all -> 0x0469 }
            if (r1 == 0) goto L_0x03d1
            r1 = r18
            goto L_0x03d2
        L_0x03d1:
            r1 = 0
        L_0x03d2:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ Throwable -> 0x046f, all -> 0x0469 }
            r14.put(r4, r1)     // Catch:{ Throwable -> 0x046f, all -> 0x0469 }
            java.lang.String r1 = "has_music"
            boolean r2 = r17.hasMusic()     // Catch:{ Throwable -> 0x046f, all -> 0x0469 }
            if (r2 == 0) goto L_0x03e4
            r2 = r18
            goto L_0x03e5
        L_0x03e4:
            r2 = 0
        L_0x03e5:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ Throwable -> 0x046f, all -> 0x0469 }
            r14.put(r1, r2)     // Catch:{ Throwable -> 0x046f, all -> 0x0469 }
            java.lang.String r1 = "is_build_in"
            boolean r2 = r17.isBuildIn()     // Catch:{ Throwable -> 0x046f, all -> 0x0469 }
            if (r2 == 0) goto L_0x03f7
            r2 = r18
            goto L_0x03f8
        L_0x03f7:
            r2 = 0
        L_0x03f8:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ Throwable -> 0x046f, all -> 0x0469 }
            r14.put(r1, r2)     // Catch:{ Throwable -> 0x046f, all -> 0x0469 }
            java.lang.String r1 = "is_new"
            boolean r2 = r17.isStickerNew()     // Catch:{ Throwable -> 0x046f, all -> 0x0469 }
            if (r2 == 0) goto L_0x040a
            r2 = r18
            goto L_0x040b
        L_0x040a:
            r2 = 0
        L_0x040b:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ Throwable -> 0x046f, all -> 0x0469 }
            r14.put(r1, r2)     // Catch:{ Throwable -> 0x046f, all -> 0x0469 }
            java.lang.String r1 = "is_valid"
            boolean r2 = r17.isValid()     // Catch:{ Throwable -> 0x046f, all -> 0x0469 }
            if (r2 == 0) goto L_0x041b
            goto L_0x041d
        L_0x041b:
            r18 = 0
        L_0x041d:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r18)     // Catch:{ Throwable -> 0x046f, all -> 0x0469 }
            r14.put(r1, r2)     // Catch:{ Throwable -> 0x046f, all -> 0x0469 }
            java.lang.String r1 = "material_type"
            int r2 = r17.getMaterialType()     // Catch:{ Throwable -> 0x046f, all -> 0x0469 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ Throwable -> 0x046f, all -> 0x0469 }
            r14.put(r1, r2)     // Catch:{ Throwable -> 0x046f, all -> 0x0469 }
            r1 = r24
            r2 = 0
            long r3 = r1.insert(r6, r2, r14)     // Catch:{ Throwable -> 0x0467, all -> 0x0463 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x0467, all -> 0x0463 }
            r5.<init>()     // Catch:{ Throwable -> 0x0467, all -> 0x0463 }
            java.lang.String r7 = "updateOrAddToStickerItemTable, insert rowId: "
            r5.append(r7)     // Catch:{ Throwable -> 0x0467, all -> 0x0463 }
            r5.append(r3)     // Catch:{ Throwable -> 0x0467, all -> 0x0463 }
            java.lang.String r3 = r5.toString()     // Catch:{ Throwable -> 0x0467, all -> 0x0463 }
            r4 = r20
            com.oppo.camera.e.b(r4, r3)     // Catch:{ Throwable -> 0x0461, all -> 0x045f }
        L_0x044e:
            if (r26 == 0) goto L_0x0453
            r26.close()     // Catch:{ Exception -> 0x04aa }
        L_0x0453:
            r5 = r2
            r15 = r6
            r3 = r23
            r2 = 0
            r25 = r4
            r4 = r1
            r1 = r25
            goto L_0x0030
        L_0x045f:
            r0 = move-exception
            goto L_0x047a
        L_0x0461:
            r0 = move-exception
            goto L_0x0481
        L_0x0463:
            r0 = move-exception
            r4 = r20
            goto L_0x047a
        L_0x0467:
            r0 = move-exception
            goto L_0x047f
        L_0x0469:
            r0 = move-exception
            r4 = r20
            r1 = r24
            goto L_0x0479
        L_0x046f:
            r0 = move-exception
            r4 = r20
            r1 = r24
            goto L_0x0481
        L_0x0475:
            r0 = move-exception
            r1 = r2
            r4 = r20
        L_0x0479:
            r2 = 0
        L_0x047a:
            r5 = r2
        L_0x047b:
            r2 = r0
            goto L_0x0485
        L_0x047d:
            r0 = move-exception
            r1 = r2
        L_0x047f:
            r4 = r20
        L_0x0481:
            r5 = r0
        L_0x0482:
            throw r5     // Catch:{ all -> 0x0483 }
        L_0x0483:
            r0 = move-exception
            goto L_0x047b
        L_0x0485:
            if (r26 == 0) goto L_0x0496
            if (r5 == 0) goto L_0x0493
            r26.close()     // Catch:{ Throwable -> 0x048d }
            goto L_0x0496
        L_0x048d:
            r0 = move-exception
            r3 = r0
            r5.addSuppressed(r3)     // Catch:{ Exception -> 0x04aa }
            goto L_0x0496
        L_0x0493:
            r26.close()     // Catch:{ Exception -> 0x04aa }
        L_0x0496:
            throw r2     // Catch:{ Exception -> 0x04aa }
        L_0x0497:
            r18 = r13
            r25 = r4
            r4 = r1
            r1 = r25
            r1.setTransactionSuccessful()     // Catch:{ Exception -> 0x04aa }
            if (r1 == 0) goto L_0x04a9
            r1.endTransaction()
            r1.close()
        L_0x04a9:
            return r18
        L_0x04aa:
            r0 = move-exception
            goto L_0x04b6
        L_0x04ac:
            r0 = move-exception
            r1 = r4
        L_0x04ae:
            r2 = r0
            goto L_0x04d7
        L_0x04b0:
            r0 = move-exception
            r25 = r4
            r4 = r1
            r1 = r25
        L_0x04b6:
            r2 = r0
        L_0x04b7:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x04d5 }
            r3.<init>()     // Catch:{ all -> 0x04d5 }
            java.lang.String r5 = "updateOrAddToStickerItemTable update list. e: "
            r3.append(r5)     // Catch:{ all -> 0x04d5 }
            r3.append(r2)     // Catch:{ all -> 0x04d5 }
            java.lang.String r2 = r3.toString()     // Catch:{ all -> 0x04d5 }
            com.oppo.camera.e.d(r4, r2)     // Catch:{ all -> 0x04d5 }
            if (r1 == 0) goto L_0x04d3
            r1.endTransaction()
            r1.close()
        L_0x04d3:
            r1 = 0
            return r1
        L_0x04d5:
            r0 = move-exception
            goto L_0x04ae
        L_0x04d7:
            if (r1 == 0) goto L_0x04df
            r1.endTransaction()
            r1.close()
        L_0x04df:
            throw r2
        L_0x04e0:
            r4 = r1
            java.lang.String r1 = "updateOrAddToStickerItemTable, categoryList is empty!"
            com.oppo.camera.e.d(r4, r1)
            r1 = 0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.sticker.a.b.a(android.content.Context, java.util.List):boolean");
    }

    public static int a(Context context, StickerItem stickerItem) {
        e.d("StickerItemTableHelper", "updateStickerDownloadTime item: " + stickerItem);
        ContentValues contentValues = new ContentValues();
        contentValues.put("download_time", Long.valueOf(System.currentTimeMillis()));
        return a(context, "uuid", stickerItem.getStickerUUID(), contentValues);
    }

    public static int a(Context context, String str, String str2, ContentValues contentValues) {
        e.d("StickerItemTableHelper", "updateStickerItem");
        return context.getContentResolver().update(c.d.f3624a, contentValues, str + " = ?", new String[]{str2});
    }

    public static List<StickerItem> a(Context context, boolean z) {
        Cursor query;
        ContentResolver contentResolver = context.getContentResolver();
        String str = !z ? "is_build_in <> 1" : null;
        ArrayList arrayList = new ArrayList();
        try {
            query = contentResolver.query(c.d.f3624a, (String[]) null, str, (String[]) null, (String) null);
            if (query != null) {
                if (query.moveToFirst()) {
                    do {
                        StickerItemWrapper a2 = a(query);
                        if (a2 != null && !TextUtils.isEmpty(a2.getStickerUUID())) {
                            arrayList.add(a2);
                        }
                    } while (query.moveToNext());
                }
            }
            if (query != null) {
                query.close();
            }
        } catch (Exception e) {
            e.d("StickerItemTableHelper", "getAllStickerItem, e: " + e);
        } catch (Throwable th) {
            r6.addSuppressed(th);
        }
        return arrayList;
        throw th;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0036, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0037, code lost:
        r6 = r0;
        r0 = r9;
        r9 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0031, code lost:
        r9 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0032, code lost:
        r0 = null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.oppo.camera.sticker.data.StickerItemWrapper a(android.content.Context r7, java.lang.String r8, java.lang.String r9) {
        /*
            android.content.ContentResolver r0 = r7.getContentResolver()
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r7.append(r8)
            java.lang.String r8 = " = ?"
            r7.append(r8)
            java.lang.String r3 = r7.toString()
            r7 = 1
            java.lang.String[] r4 = new java.lang.String[r7]
            r7 = 0
            r4[r7] = r9
            r7 = 0
            android.net.Uri r1 = com.oppo.camera.sticker.a.c.d.f3624a     // Catch:{ Exception -> 0x0051 }
            r2 = 0
            r5 = 0
            android.database.Cursor r8 = r0.query(r1, r2, r3, r4, r5)     // Catch:{ Exception -> 0x0051 }
            if (r8 == 0) goto L_0x004b
            boolean r9 = r8.moveToFirst()     // Catch:{ Throwable -> 0x0034, all -> 0x0031 }
            if (r9 == 0) goto L_0x004b
            com.oppo.camera.sticker.data.StickerItemWrapper r7 = a((android.database.Cursor) r8)     // Catch:{ Throwable -> 0x0034, all -> 0x0031 }
            goto L_0x004b
        L_0x0031:
            r9 = move-exception
            r0 = r7
            goto L_0x003a
        L_0x0034:
            r9 = move-exception
            throw r9     // Catch:{ all -> 0x0036 }
        L_0x0036:
            r0 = move-exception
            r6 = r0
            r0 = r9
            r9 = r6
        L_0x003a:
            if (r8 == 0) goto L_0x004a
            if (r0 == 0) goto L_0x0047
            r8.close()     // Catch:{ Throwable -> 0x0042 }
            goto L_0x004a
        L_0x0042:
            r8 = move-exception
            r0.addSuppressed(r8)     // Catch:{ Exception -> 0x0051 }
            goto L_0x004a
        L_0x0047:
            r8.close()     // Catch:{ Exception -> 0x0051 }
        L_0x004a:
            throw r9     // Catch:{ Exception -> 0x0051 }
        L_0x004b:
            if (r8 == 0) goto L_0x0068
            r8.close()     // Catch:{ Exception -> 0x0051 }
            goto L_0x0068
        L_0x0051:
            r8 = move-exception
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r0 = "getStickerItem, e: "
            r9.append(r0)
            r9.append(r8)
            java.lang.String r8 = r9.toString()
            java.lang.String r9 = "StickerItemTableHelper"
            com.oppo.camera.e.d(r9, r8)
        L_0x0068:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.sticker.a.b.a(android.content.Context, java.lang.String, java.lang.String):com.oppo.camera.sticker.data.StickerItemWrapper");
    }

    public static StickerItemWrapper a(Cursor cursor) {
        StickerItemWrapper stickerItemWrapper = new StickerItemWrapper();
        stickerItemWrapper.setStickerId(cursor.getLong(cursor.getColumnIndexOrThrow("_id")));
        stickerItemWrapper.setStickerUUID(cursor.getString(cursor.getColumnIndexOrThrow("uuid")));
        stickerItemWrapper.setStickerName(cursor.getString(cursor.getColumnIndexOrThrow("name")));
        stickerItemWrapper.setFileDownloadUrl(cursor.getString(cursor.getColumnIndexOrThrow("file_url")));
        stickerItemWrapper.setFileMd5(cursor.getString(cursor.getColumnIndexOrThrow("file_md5")));
        stickerItemWrapper.setFilePath(cursor.getString(cursor.getColumnIndexOrThrow("file_path")));
        stickerItemWrapper.setFileContentUri(cursor.getString(cursor.getColumnIndexOrThrow("file_content_uri")));
        stickerItemWrapper.setThumbnailUrl(cursor.getString(cursor.getColumnIndexOrThrow("thumbnail_url")));
        stickerItemWrapper.setThumbnailPath(cursor.getString(cursor.getColumnIndexOrThrow("thumbnail_path")));
        stickerItemWrapper.setThumbnailFileUri(cursor.getString(cursor.getColumnIndexOrThrow("thumbnail_file_uri")));
        stickerItemWrapper.setThumbnailMd5(cursor.getString(cursor.getColumnIndexOrThrow("thumbnail_md5")));
        stickerItemWrapper.setLogoUrl(cursor.getString(cursor.getColumnIndexOrThrow("logo_url")));
        stickerItemWrapper.setLogoPath(cursor.getString(cursor.getColumnIndexOrThrow("logo_path")));
        stickerItemWrapper.setLogoFileUri(cursor.getString(cursor.getColumnIndexOrThrow("logo_file_uri")));
        stickerItemWrapper.setLogoMd5(cursor.getString(cursor.getColumnIndexOrThrow("logo_md5")));
        stickerItemWrapper.setDownloadUid(cursor.getString(cursor.getColumnIndexOrThrow("download_uuid")));
        stickerItemWrapper.setVersion(cursor.getLong(cursor.getColumnIndexOrThrow(CameraStatisticsUtil.RUS_FILE_VERSION)));
        stickerItemWrapper.setProtocolVersion(cursor.getLong(cursor.getColumnIndexOrThrow("protocol_version")));
        stickerItemWrapper.setDownloadTime(cursor.getLong(cursor.getColumnIndexOrThrow("download_time")));
        stickerItemWrapper.setLastRequestTime(cursor.getLong(cursor.getColumnIndexOrThrow("request_time")));
        stickerItemWrapper.setCategoryId(cursor.getString(cursor.getColumnIndexOrThrow("category_id")));
        stickerItemWrapper.setCategoryPosition(cursor.getInt(cursor.getColumnIndexOrThrow("category_position")));
        stickerItemWrapper.setPosition(cursor.getInt(cursor.getColumnIndexOrThrow("position")));
        stickerItemWrapper.setDownloadState(cursor.getInt(cursor.getColumnIndexOrThrow("download_state")));
        stickerItemWrapper.setAttribute(cursor.getLong(cursor.getColumnIndexOrThrow("attribute")));
        boolean z = false;
        stickerItemWrapper.setHasMusic(cursor.getInt(cursor.getColumnIndexOrThrow("has_music")) != 0);
        stickerItemWrapper.setNeedUpdate(cursor.getInt(cursor.getColumnIndexOrThrow("need_update")) != 0);
        stickerItemWrapper.setIsBuildIn(cursor.getInt(cursor.getColumnIndexOrThrow("is_build_in")) != 0);
        stickerItemWrapper.setStickerNew(cursor.getInt(cursor.getColumnIndexOrThrow("is_new")) != 0);
        if (cursor.getInt(cursor.getColumnIndexOrThrow("is_valid")) != 0) {
            z = true;
        }
        stickerItemWrapper.setValid(z);
        stickerItemWrapper.setMaterialType(cursor.getInt(cursor.getColumnIndexOrThrow("material_type")));
        return stickerItemWrapper;
    }

    public static void b(Context context, StickerItem stickerItem) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("download_state", 0);
        contentValues.put("download_uuid", "");
        a(context, "uuid", stickerItem.getStickerUUID(), contentValues);
    }

    /* JADX WARNING: Removed duplicated region for block: B:7:0x002f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.List<com.oppo.camera.sticker.data.StickerItem> a(android.content.Context r6) {
        /*
            android.content.ContentResolver r0 = r6.getContentResolver()
            r6 = 23
            java.lang.String r3 = a((int) r6)
            android.net.Uri r1 = com.oppo.camera.sticker.a.c.d.f3624a
            r2 = 0
            r4 = 0
            r5 = 0
            android.database.Cursor r6 = r0.query(r1, r2, r3, r4, r5)
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            if (r6 == 0) goto L_0x002d
            boolean r1 = r6.moveToFirst()
            if (r1 == 0) goto L_0x002d
        L_0x0020:
            com.oppo.camera.sticker.data.StickerItemWrapper r1 = a((android.database.Cursor) r6)
            r0.add(r1)
            boolean r1 = r6.moveToNext()
            if (r1 != 0) goto L_0x0020
        L_0x002d:
            if (r6 == 0) goto L_0x0032
            r6.close()
        L_0x0032:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.sticker.a.b.a(android.content.Context):java.util.List");
    }

    private static String a(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append(" ");
        sb.append("download_state");
        sb.append(" IN (");
        if ((i & 1) != 0) {
            sb.append(1);
            sb.append(",");
        }
        if ((i & 2) != 0) {
            sb.append(2);
            sb.append(",");
        }
        if ((i & 4) != 0) {
            sb.append(4);
            sb.append(",");
        }
        if ((i & 8) != 0) {
            sb.append(8);
            sb.append(",");
        }
        if ((i & 16) != 0) {
            sb.append(16);
            sb.append(",");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append(")");
        return sb.toString();
    }

    public static void a(Context context, long j, long j2) {
        ContentResolver contentResolver = context.getContentResolver();
        if (contentResolver != null) {
            String[] strArr = {String.valueOf(1)};
            ContentValues contentValues = new ContentValues();
            contentValues.put("is_new", 0);
            e.b("StickerItemTableHelper", "autoClearStickerNewStatus, update count: " + contentResolver.update(c.d.f3624a, contentValues, "is_new = ? AND request_time < " + (j - j2), strArr) + ", currTime: " + j);
        }
    }

    public static void b(Context context) {
        ContentResolver contentResolver = context.getContentResolver();
        String[] strArr = {String.valueOf(0)};
        ContentValues contentValues = new ContentValues();
        contentValues.put("is_valid", 0);
        int update = contentResolver.update(c.d.f3624a, contentValues, "download_state = ? AND is_build_in <> 1", strArr);
        e.b("StickerItemTableHelper", "preCheckStickerValid, update count: " + update);
    }

    public static void c(Context context) {
        Throwable th;
        ContentResolver contentResolver = context.getContentResolver();
        ArrayList<StickerItemWrapper> arrayList = new ArrayList<>();
        Cursor query = contentResolver.query(c.d.f3624a, (String[]) null, "is_valid = 0 AND is_build_in <> 1", (String[]) null, (String) null);
        while (query != null) {
            try {
                if (!query.moveToNext()) {
                    break;
                }
                arrayList.add(a(query));
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
        }
        if (query != null) {
            query.close();
        }
        for (StickerItemWrapper stickerItemWrapper : arrayList) {
            boolean b2 = com.oppo.camera.sticker.c.b.b(stickerItemWrapper.getThumbnailPath());
            boolean b3 = com.oppo.camera.sticker.c.b.b(stickerItemWrapper.getLogoPath());
            e.b("StickerItemTableHelper", "postCheckStickerValidStatus, delete item: " + stickerItemWrapper + ", deleteThumbResult: " + b2 + ", deleteLogoResult: " + b3);
        }
        int delete = contentResolver.delete(c.d.f3624a, "is_valid = 0 AND is_build_in <> 1", (String[]) null);
        e.b("StickerItemTableHelper", "postCheckStickerValidStatus, delete invalid sticker, count: " + delete);
        return;
        throw th;
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0095 A[SYNTHETIC, Splitter:B:22:0x0095] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(android.content.Context r13, java.lang.String r14, com.oppo.camera.sticker.data.AnimojiStickerExtendedInfo r15) {
        /*
            r0 = 0
            java.lang.String r1 = "StickerItemTableHelper"
            if (r13 == 0) goto L_0x00cd
            if (r15 != 0) goto L_0x0009
            goto L_0x00cd
        L_0x0009:
            java.lang.String r2 = r15.getBackgroundColor()
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 == 0) goto L_0x0019
            java.lang.String r13 = "updateOrAddToAniMojiExtendTable, animojiStickerExtendedInfo color is empty!"
            com.oppo.camera.e.d(r1, r13)
            return r0
        L_0x0019:
            boolean r2 = android.text.TextUtils.isEmpty(r14)
            if (r2 == 0) goto L_0x0025
            java.lang.String r13 = "updateOrAddToAniMojiExtendTable, uuid is empty!"
            com.oppo.camera.e.d(r1, r13)
            return r0
        L_0x0025:
            android.content.ContentResolver r13 = r13.getContentResolver()
            java.lang.String r8 = "uuid = ?"
            r9 = 1
            java.lang.String[] r10 = new java.lang.String[r9]
            r10[r0] = r14
            android.net.Uri r11 = com.oppo.camera.sticker.a.c.a.f3618a
            android.content.ContentValues r12 = new android.content.ContentValues
            r12.<init>()
            r4 = 0
            r7 = 0
            r2 = r13
            r3 = r11
            r5 = r8
            r6 = r10
            android.database.Cursor r2 = r2.query(r3, r4, r5, r6, r7)     // Catch:{ Exception -> 0x00af }
            r3 = 0
            java.lang.String r4 = "background_color"
            if (r2 == 0) goto L_0x006f
            int r5 = r2.getCount()     // Catch:{ Throwable -> 0x009b }
            if (r5 <= 0) goto L_0x006f
            r2.moveToFirst()     // Catch:{ Throwable -> 0x009b }
            java.lang.String r15 = r15.getBackgroundColor()     // Catch:{ Throwable -> 0x009b }
            r12.put(r4, r15)     // Catch:{ Throwable -> 0x009b }
            int r13 = r13.update(r11, r12, r8, r10)     // Catch:{ Throwable -> 0x009b }
            java.lang.StringBuilder r15 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x009b }
            r15.<init>()     // Catch:{ Throwable -> 0x009b }
            java.lang.String r4 = "updateOrAddToAniMojiExtendTable, update single item. count: "
            r15.append(r4)     // Catch:{ Throwable -> 0x009b }
            r15.append(r13)     // Catch:{ Throwable -> 0x009b }
            java.lang.String r13 = r15.toString()     // Catch:{ Throwable -> 0x009b }
            com.oppo.camera.e.b(r1, r13)     // Catch:{ Throwable -> 0x009b }
            goto L_0x0093
        L_0x006f:
            java.lang.String r5 = "uuid"
            r12.put(r5, r14)     // Catch:{ Throwable -> 0x009b }
            java.lang.String r15 = r15.getBackgroundColor()     // Catch:{ Throwable -> 0x009b }
            r12.put(r4, r15)     // Catch:{ Throwable -> 0x009b }
            android.net.Uri r13 = r13.insert(r11, r12)     // Catch:{ Throwable -> 0x009b }
            java.lang.StringBuilder r15 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x009b }
            r15.<init>()     // Catch:{ Throwable -> 0x009b }
            java.lang.String r4 = "updateOrAddToAniMojiExtendTable, insert single item. insertUri: "
            r15.append(r4)     // Catch:{ Throwable -> 0x009b }
            r15.append(r13)     // Catch:{ Throwable -> 0x009b }
            java.lang.String r13 = r15.toString()     // Catch:{ Throwable -> 0x009b }
            com.oppo.camera.e.b(r1, r13)     // Catch:{ Throwable -> 0x009b }
        L_0x0093:
            if (r2 == 0) goto L_0x0098
            r2.close()     // Catch:{ Exception -> 0x00af }
        L_0x0098:
            return r9
        L_0x0099:
            r13 = move-exception
            goto L_0x009e
        L_0x009b:
            r13 = move-exception
            r3 = r13
            throw r3     // Catch:{ all -> 0x0099 }
        L_0x009e:
            if (r2 == 0) goto L_0x00ae
            if (r3 == 0) goto L_0x00ab
            r2.close()     // Catch:{ Throwable -> 0x00a6 }
            goto L_0x00ae
        L_0x00a6:
            r15 = move-exception
            r3.addSuppressed(r15)     // Catch:{ Exception -> 0x00af }
            goto L_0x00ae
        L_0x00ab:
            r2.close()     // Catch:{ Exception -> 0x00af }
        L_0x00ae:
            throw r13     // Catch:{ Exception -> 0x00af }
        L_0x00af:
            r13 = move-exception
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            r15.<init>()
            java.lang.String r2 = "updateOrAddToAniMojiExtendTable cause a exception, exception: "
            r15.append(r2)
            r15.append(r13)
            java.lang.String r13 = ", uuid: "
            r15.append(r13)
            r15.append(r14)
            java.lang.String r13 = r15.toString()
            com.oppo.camera.e.d(r1, r13)
            return r0
        L_0x00cd:
            java.lang.String r13 = "updateOrAddToAniMojiExtendTable, context or category is null!"
            com.oppo.camera.e.d(r1, r13)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.sticker.a.b.a(android.content.Context, java.lang.String, com.oppo.camera.sticker.data.AnimojiStickerExtendedInfo):boolean");
    }

    public static boolean a(Context context, String str, List<MultiStickerExtendedInfo> list) {
        if (context == null || list == null || list.isEmpty()) {
            e.d("StickerItemTableHelper", "addToMultiStickerExtendTable, context or category is null!");
            return false;
        } else if (TextUtils.isEmpty(str)) {
            e.d("StickerItemTableHelper", "addToMultiStickerExtendTable, uuid is empty!");
            return false;
        } else {
            ContentResolver contentResolver = context.getContentResolver();
            String[] strArr = {str};
            Uri uri = c.b.f3620a;
            try {
                int delete = contentResolver.delete(uri, "uuid = ?", strArr);
                e.b("StickerItemTableHelper", "addToMultiStickerExtendTable, delete exist data. count: " + delete);
                ArrayList arrayList = new ArrayList();
                for (MultiStickerExtendedInfo next : list) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("uuid", str);
                    contentValues.put("sticker_fit_to_size", Integer.valueOf(next.getIsFitToSize() ? 1 : 0));
                    contentValues.put(CameraStatisticsUtil.STICKER_NAME, next.getStickerName());
                    contentValues.put("position_type", Integer.valueOf(next.getPositionType()));
                    contentValues.put("z_position", Integer.valueOf(next.getZPosition()));
                    contentValues.put("base_size_16_9", next.getBaseSize16x9());
                    contentValues.put("display_rect_16_9", next.getDisplayRect16x9());
                    contentValues.put("base_size_4_3", next.getBaseSize4x3());
                    contentValues.put("display_rect_4_3", next.getDisplayRect4x3());
                    contentValues.put("base_size_1_1", next.getBaseSize1x1());
                    contentValues.put("display_rect_1_1", next.getDisplayRect1x1());
                    contentValues.put("file_content_uri_16_9", next.getFileContentUri16x9());
                    contentValues.put("file_content_uri_4_3", next.getFileContentUri4x3());
                    contentValues.put("file_content_uri_1_1", next.getFileContentUri1x1());
                    arrayList.add(contentValues);
                }
                int bulkInsert = contentResolver.bulkInsert(uri, (ContentValues[]) arrayList.toArray(new ContentValues[0]));
                int size = list.size();
                if (bulkInsert == size) {
                    return true;
                }
                e.d("StickerItemTableHelper", "addToMultiStickerExtendTable, insert count error! count: " + bulkInsert + ", size: " + size);
                return false;
            } catch (Exception e) {
                e.d("StickerItemTableHelper", "addToMultiStickerExtendTable cause a exception, exception: " + e + ", uuid: " + str);
                return false;
            }
        }
    }

    public static List<MultiStickerExtendedInfo> c(Context context, StickerItem stickerItem) {
        Cursor query;
        if (context == null || stickerItem == null) {
            return null;
        }
        if (stickerItem.getMaterialType() != 1) {
            e.d("StickerItemTableHelper", "getMultiStickerInfo, not a multi type! item: " + stickerItem);
            return null;
        } else if (TextUtils.isEmpty(stickerItem.getStickerUUID())) {
            e.d("StickerItemTableHelper", "getMultiStickerInfo, sticker uuid is empty! item: " + stickerItem);
            return null;
        } else {
            ContentResolver contentResolver = context.getContentResolver();
            String[] strArr = {stickerItem.getStickerUUID()};
            ArrayList arrayList = new ArrayList();
            try {
                query = contentResolver.query(c.b.f3620a, (String[]) null, "uuid = ?", strArr, (String) null);
                while (query != null) {
                    if (!query.moveToNext()) {
                        break;
                    }
                    arrayList.add(b(query));
                }
                if (query != null) {
                    query.close();
                }
            } catch (Exception e) {
                e.d("StickerItemTableHelper", "getMultiStickerInfo, e:" + e);
            } catch (Throwable th) {
                r0.addSuppressed(th);
            }
            return arrayList;
        }
        throw th;
    }

    private static MultiStickerExtendedInfo b(Cursor cursor) {
        MultiStickerExtendedInfo multiStickerExtendedInfo = new MultiStickerExtendedInfo();
        boolean z = true;
        if (cursor.getInt(cursor.getColumnIndexOrThrow("sticker_fit_to_size")) != 1) {
            z = false;
        }
        multiStickerExtendedInfo.setIsFitToSize(z);
        multiStickerExtendedInfo.setStickerName(cursor.getString(cursor.getColumnIndexOrThrow(CameraStatisticsUtil.STICKER_NAME)));
        multiStickerExtendedInfo.setPositionType(cursor.getInt(cursor.getColumnIndexOrThrow("position_type")));
        multiStickerExtendedInfo.setZPosition(cursor.getInt(cursor.getColumnIndexOrThrow("z_position")));
        multiStickerExtendedInfo.setBaseSize16x9(cursor.getString(cursor.getColumnIndexOrThrow("base_size_16_9")));
        multiStickerExtendedInfo.setDisplayRect16x9(cursor.getString(cursor.getColumnIndexOrThrow("display_rect_16_9")));
        multiStickerExtendedInfo.setFileContentUri16x9(cursor.getString(cursor.getColumnIndexOrThrow("file_content_uri_16_9")));
        multiStickerExtendedInfo.setBaseSize4x3(cursor.getString(cursor.getColumnIndexOrThrow("base_size_4_3")));
        multiStickerExtendedInfo.setDisplayRect4x3(cursor.getString(cursor.getColumnIndexOrThrow("display_rect_4_3")));
        multiStickerExtendedInfo.setFileContentUri4x3(cursor.getString(cursor.getColumnIndexOrThrow("file_content_uri_4_3")));
        multiStickerExtendedInfo.setBaseSize1x1(cursor.getString(cursor.getColumnIndexOrThrow("base_size_1_1")));
        multiStickerExtendedInfo.setDisplayRect1x1(cursor.getString(cursor.getColumnIndexOrThrow("display_rect_1_1")));
        multiStickerExtendedInfo.setFileContentUri1x1(cursor.getString(cursor.getColumnIndexOrThrow("file_content_uri_1_1")));
        return multiStickerExtendedInfo;
    }

    public static boolean d(Context context, StickerItem stickerItem) {
        if (context == null || stickerItem == null) {
            e.d("StickerItemTableHelper", "deleteMultiStickerInfo, parameter is null! context: " + context);
            return false;
        }
        int delete = context.getContentResolver().delete(c.b.f3620a, "uuid = ?", new String[]{stickerItem.getStickerUUID()});
        e.b("StickerItemTableHelper", "deleteMultiStickerInfo, count: " + delete + ", item name: " + stickerItem.getStickerName());
        return true;
    }

    public static boolean b(Context context, StickerItemWrapper stickerItemWrapper) {
        if (context == null || stickerItemWrapper == null) {
            e.d("StickerItemTableHelper", "deleteAnimojiStickerInfo, parameter is null! context: " + context);
            return false;
        }
        int delete = context.getContentResolver().delete(c.a.f3618a, "uuid = ?", new String[]{stickerItemWrapper.getStickerUUID()});
        e.b("StickerItemTableHelper", "deleteAnimojiStickerInfo, count: " + delete + ", item name: " + stickerItemWrapper.getStickerName());
        return true;
    }
}
