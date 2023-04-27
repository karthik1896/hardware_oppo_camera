package com.oppo.camera.sticker;

import android.content.Context;
import android.database.Cursor;
import android.database.MergeCursor;
import android.text.TextUtils;
import com.oppo.camera.e;
import com.oppo.camera.statistics.CameraStatisticsUtil;
import com.oppo.camera.sticker.a.c;
import com.oppo.camera.sticker.data.AnimojiStickerExtendedInfo;
import com.oppo.camera.sticker.data.MultiStickerExtendedInfo;
import com.oppo.camera.sticker.data.StickerCategoryItem;
import com.oppo.camera.sticker.data.StickerItem;
import java.util.ArrayList;
import java.util.List;

/* compiled from: StickerItemDBHelper */
public class g {
    public static Cursor a(Context context, long j, String str) {
        if (TextUtils.isEmpty(str)) {
            e.d("StickerItemDBHelper", "getStickerItemsCursor, empty categoryId!");
            return null;
        } else if (StickerCategoryItem.isMyCategory(str)) {
            Cursor a2 = a(context, j);
            if (a2 != null) {
                Cursor a3 = a(context);
                if (a3 != null) {
                    return new MergeCursor(new Cursor[]{a3, a2});
                }
                e.d("StickerItemDBHelper", "getStickerItemsCursor, recycleBinStickerCursor is null!");
                return a2;
            }
            e.d("StickerItemDBHelper", "getStickerItemsCursor, myStickerCursor is null!");
            return null;
        } else {
            return a(context, c.d.f3624a, (String[]) null, "category_id = \"" + str + "\" AND " + "attribute" + " & " + j + " = " + j, (String[]) null, "is_build_in ASC, is_valid DESC, position ASC");
        }
    }

    public static StickerItem a(Cursor cursor) {
        StickerItem stickerItem = new StickerItem();
        stickerItem.setStickerId(cursor.getLong(cursor.getColumnIndexOrThrow("_id")));
        stickerItem.setStickerUUID(cursor.getString(cursor.getColumnIndexOrThrow("uuid")));
        stickerItem.setStickerName(cursor.getString(cursor.getColumnIndexOrThrow("name")));
        stickerItem.setFileDownloadUrl(cursor.getString(cursor.getColumnIndexOrThrow("file_url")));
        stickerItem.setFileMd5(cursor.getString(cursor.getColumnIndexOrThrow("file_md5")));
        stickerItem.setFileContentUri(cursor.getString(cursor.getColumnIndexOrThrow("file_content_uri")));
        stickerItem.setThumbnailUrl(cursor.getString(cursor.getColumnIndexOrThrow("thumbnail_url")));
        stickerItem.setThumbnailFileUri(cursor.getString(cursor.getColumnIndexOrThrow("thumbnail_file_uri")));
        stickerItem.setThumbnailMd5(cursor.getString(cursor.getColumnIndexOrThrow("thumbnail_md5")));
        stickerItem.setLogoUrl(cursor.getString(cursor.getColumnIndexOrThrow("logo_url")));
        stickerItem.setLogoFileUri(cursor.getString(cursor.getColumnIndexOrThrow("logo_file_uri")));
        stickerItem.setLogoMd5(cursor.getString(cursor.getColumnIndexOrThrow("logo_md5")));
        stickerItem.setDownloadUid(cursor.getString(cursor.getColumnIndexOrThrow("download_uuid")));
        stickerItem.setVersion(cursor.getLong(cursor.getColumnIndexOrThrow(CameraStatisticsUtil.RUS_FILE_VERSION)));
        stickerItem.setProtocolVersion(cursor.getLong(cursor.getColumnIndexOrThrow("protocol_version")));
        stickerItem.setDownloadTime(cursor.getLong(cursor.getColumnIndexOrThrow("download_time")));
        stickerItem.setLastRequestTime(cursor.getLong(cursor.getColumnIndexOrThrow("request_time")));
        stickerItem.setCategoryId(cursor.getString(cursor.getColumnIndexOrThrow("category_id")));
        stickerItem.setCategoryPosition(cursor.getInt(cursor.getColumnIndexOrThrow("category_position")));
        stickerItem.setPosition(cursor.getInt(cursor.getColumnIndexOrThrow("position")));
        stickerItem.setDownloadState(cursor.getInt(cursor.getColumnIndexOrThrow("download_state")));
        stickerItem.setAttribute((long) cursor.getInt(cursor.getColumnIndexOrThrow("attribute")));
        boolean z = false;
        stickerItem.setHasMusic(cursor.getInt(cursor.getColumnIndexOrThrow("has_music")) != 0);
        stickerItem.setNeedUpdate(cursor.getInt(cursor.getColumnIndexOrThrow("need_update")) != 0);
        stickerItem.setIsBuildIn(cursor.getInt(cursor.getColumnIndexOrThrow("is_build_in")) != 0);
        stickerItem.setStickerNew(cursor.getInt(cursor.getColumnIndexOrThrow("is_new")) != 0);
        if (cursor.getInt(cursor.getColumnIndexOrThrow("is_valid")) != 0) {
            z = true;
        }
        stickerItem.setValid(z);
        stickerItem.setMaterialType(cursor.getInt(cursor.getColumnIndexOrThrow("material_type")));
        return stickerItem;
    }

    public static Cursor a(Context context, long j) {
        return a(context, c.d.f3624a, (String[]) null, "download_time > 0 AND download_state = 8 AND attribute & " + j + " = " + j, (String[]) null, "download_time DESC");
    }

    public static Cursor a(Context context) {
        return a(context, c.d.f3624a, (String[]) null, "uuid = '68714002-1206-472f-a3c8-74eea52f7808'", (String[]) null, "");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0033, code lost:
        r10 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0034, code lost:
        r0 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0038, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0039, code lost:
        r7 = r0;
        r0 = r10;
        r10 = r7;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.oppo.camera.sticker.data.StickerItem a(android.content.Context r8, java.lang.String r9, java.lang.String r10) {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r9)
            java.lang.String r9 = " = ?"
            r0.append(r9)
            java.lang.String r4 = r0.toString()
            r9 = 1
            java.lang.String[] r5 = new java.lang.String[r9]
            r9 = 0
            r5[r9] = r10
            r9 = 0
            android.net.Uri r2 = com.oppo.camera.sticker.a.c.d.f3624a     // Catch:{ Exception -> 0x0053 }
            r3 = 0
            r6 = 0
            r1 = r8
            android.database.Cursor r8 = a(r1, r2, r3, r4, r5, r6)     // Catch:{ Exception -> 0x0053 }
            if (r8 == 0) goto L_0x004d
            boolean r10 = r8.moveToFirst()     // Catch:{ Throwable -> 0x0036, all -> 0x0033 }
            if (r10 == 0) goto L_0x004d
            com.oppo.camera.sticker.data.StickerItem r10 = a((android.database.Cursor) r8)     // Catch:{ Throwable -> 0x0036, all -> 0x0033 }
            if (r8 == 0) goto L_0x0032
            r8.close()     // Catch:{ Exception -> 0x0053 }
        L_0x0032:
            return r10
        L_0x0033:
            r10 = move-exception
            r0 = r9
            goto L_0x003c
        L_0x0036:
            r10 = move-exception
            throw r10     // Catch:{ all -> 0x0038 }
        L_0x0038:
            r0 = move-exception
            r7 = r0
            r0 = r10
            r10 = r7
        L_0x003c:
            if (r8 == 0) goto L_0x004c
            if (r0 == 0) goto L_0x0049
            r8.close()     // Catch:{ Throwable -> 0x0044 }
            goto L_0x004c
        L_0x0044:
            r8 = move-exception
            r0.addSuppressed(r8)     // Catch:{ Exception -> 0x0053 }
            goto L_0x004c
        L_0x0049:
            r8.close()     // Catch:{ Exception -> 0x0053 }
        L_0x004c:
            throw r10     // Catch:{ Exception -> 0x0053 }
        L_0x004d:
            if (r8 == 0) goto L_0x006a
            r8.close()     // Catch:{ Exception -> 0x0053 }
            goto L_0x006a
        L_0x0053:
            r8 = move-exception
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r0 = "getStickerItem, exception: "
            r10.append(r0)
            r10.append(r8)
            java.lang.String r8 = r10.toString()
            java.lang.String r10 = "StickerItemDBHelper"
            com.oppo.camera.e.d(r10, r8)
        L_0x006a:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.sticker.g.a(android.content.Context, java.lang.String, java.lang.String):com.oppo.camera.sticker.data.StickerItem");
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0031 A[Catch:{ all -> 0x0063 }] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x004c A[Catch:{ RemoteException -> 0x004a }] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x005b  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0066  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.database.Cursor a(android.content.Context r9, android.net.Uri r10, java.lang.String[] r11, java.lang.String r12, java.lang.String[] r13, java.lang.String r14) {
        /*
            java.lang.String r0 = "StickerItemDBHelper"
            r1 = 0
            android.content.ContentResolver r2 = r9.getContentResolver()     // Catch:{ RemoteException -> 0x0028, all -> 0x0025 }
            android.content.ContentProviderClient r2 = r2.acquireUnstableContentProviderClient(r10)     // Catch:{ RemoteException -> 0x0028, all -> 0x0025 }
            if (r2 == 0) goto L_0x001a
            r3 = r2
            r4 = r10
            r5 = r11
            r6 = r12
            r7 = r13
            r8 = r14
            android.database.Cursor r1 = r3.query(r4, r5, r6, r7, r8)     // Catch:{ RemoteException -> 0x0018 }
            goto L_0x001f
        L_0x0018:
            r3 = move-exception
            goto L_0x002a
        L_0x001a:
            java.lang.String r3 = "getUnstableContentProviderCursor, client is null!"
            com.oppo.camera.e.d(r0, r3)     // Catch:{ RemoteException -> 0x0018 }
        L_0x001f:
            if (r2 == 0) goto L_0x005e
            r2.close()
            goto L_0x005e
        L_0x0025:
            r9 = move-exception
            r2 = r1
            goto L_0x0064
        L_0x0028:
            r3 = move-exception
            r2 = r1
        L_0x002a:
            java.lang.String r4 = "getUnstableContentProviderCursor, RemoteException! e: "
            com.oppo.camera.e.c(r0, r4, r3)     // Catch:{ all -> 0x0063 }
            if (r2 == 0) goto L_0x0034
            r2.close()     // Catch:{ all -> 0x0063 }
        L_0x0034:
            android.content.ContentResolver r9 = r9.getContentResolver()     // Catch:{ RemoteException -> 0x0052 }
            android.content.ContentProviderClient r9 = r9.acquireUnstableContentProviderClient(r10)     // Catch:{ RemoteException -> 0x0052 }
            if (r9 == 0) goto L_0x004c
            r3 = r9
            r4 = r10
            r5 = r11
            r6 = r12
            r7 = r13
            r8 = r14
            android.database.Cursor r10 = r3.query(r4, r5, r6, r7, r8)     // Catch:{ RemoteException -> 0x004a }
            r1 = r10
            goto L_0x0059
        L_0x004a:
            r10 = move-exception
            goto L_0x0054
        L_0x004c:
            java.lang.String r10 = "getUnstableContentProviderCursor2, client is null!"
            com.oppo.camera.e.d(r0, r10)     // Catch:{ RemoteException -> 0x004a }
            goto L_0x0059
        L_0x0052:
            r10 = move-exception
            r9 = r2
        L_0x0054:
            java.lang.String r11 = "getUnstableContentProviderCursor, RemoteException again! "
            com.oppo.camera.e.c(r0, r11, r10)     // Catch:{ all -> 0x005f }
        L_0x0059:
            if (r9 == 0) goto L_0x005e
            r9.close()
        L_0x005e:
            return r1
        L_0x005f:
            r10 = move-exception
            r2 = r9
            r9 = r10
            goto L_0x0064
        L_0x0063:
            r9 = move-exception
        L_0x0064:
            if (r2 == 0) goto L_0x0069
            r2.close()
        L_0x0069:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.sticker.g.a(android.content.Context, android.net.Uri, java.lang.String[], java.lang.String, java.lang.String[], java.lang.String):android.database.Cursor");
    }

    public static List<MultiStickerExtendedInfo> a(Context context, StickerItem stickerItem) {
        Cursor a2;
        if (context == null || stickerItem == null) {
            return null;
        }
        if (stickerItem.getMaterialType() != 1) {
            e.d("StickerItemDBHelper", "getMultiStickerInfo, not a multi type! item: " + stickerItem);
            return null;
        } else if (TextUtils.isEmpty(stickerItem.getStickerUUID())) {
            e.d("StickerItemDBHelper", "getMultiStickerInfo, sticker uuid is empty! item: " + stickerItem);
            return null;
        } else {
            String[] strArr = {stickerItem.getStickerUUID()};
            ArrayList arrayList = new ArrayList();
            try {
                a2 = a(context, c.b.f3620a, (String[]) null, "uuid = ?", strArr, (String) null);
                while (a2 != null) {
                    if (!a2.moveToNext()) {
                        break;
                    }
                    arrayList.add(b(a2));
                }
                if (a2 != null) {
                    a2.close();
                }
            } catch (Exception e) {
                e.d("StickerItemDBHelper", "getMultiStickerInfo, e = " + e);
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

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0069, code lost:
        r12 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x006a, code lost:
        r1 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x006e, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x006f, code lost:
        r10 = r1;
        r1 = r12;
        r12 = r10;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.oppo.camera.sticker.data.AnimojiStickerExtendedInfo b(android.content.Context r11, com.oppo.camera.sticker.data.StickerItem r12) {
        /*
            r0 = 0
            if (r11 == 0) goto L_0x009e
            if (r12 != 0) goto L_0x0007
            goto L_0x009e
        L_0x0007:
            int r1 = r12.getMaterialType()
            r2 = 2
            java.lang.String r3 = "StickerItemDBHelper"
            if (r1 == r2) goto L_0x0025
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r1 = "getAnimojiStickerInfo, not a animoji type! item: "
            r11.append(r1)
            r11.append(r12)
            java.lang.String r11 = r11.toString()
            com.oppo.camera.e.d(r3, r11)
            return r0
        L_0x0025:
            java.lang.String r1 = r12.getStickerUUID()
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 == 0) goto L_0x0044
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r1 = "getAnimojiStickerInfo, sticker uuid is empty! item: "
            r11.append(r1)
            r11.append(r12)
            java.lang.String r11 = r11.toString()
            com.oppo.camera.e.d(r3, r11)
            return r0
        L_0x0044:
            java.lang.String r7 = "uuid = ?"
            r1 = 1
            java.lang.String[] r8 = new java.lang.String[r1]
            r1 = 0
            java.lang.String r12 = r12.getStickerUUID()
            r8[r1] = r12
            android.net.Uri r5 = com.oppo.camera.sticker.a.c.a.f3618a     // Catch:{ Exception -> 0x0089 }
            r6 = 0
            r9 = 0
            r4 = r11
            android.database.Cursor r11 = a(r4, r5, r6, r7, r8, r9)     // Catch:{ Exception -> 0x0089 }
            if (r11 == 0) goto L_0x0083
            int r12 = r11.getCount()     // Catch:{ Throwable -> 0x006c, all -> 0x0069 }
            if (r12 <= 0) goto L_0x0083
            r11.moveToFirst()     // Catch:{ Throwable -> 0x006c, all -> 0x0069 }
            com.oppo.camera.sticker.data.AnimojiStickerExtendedInfo r0 = c(r11)     // Catch:{ Throwable -> 0x006c, all -> 0x0069 }
            goto L_0x0083
        L_0x0069:
            r12 = move-exception
            r1 = r0
            goto L_0x0072
        L_0x006c:
            r12 = move-exception
            throw r12     // Catch:{ all -> 0x006e }
        L_0x006e:
            r1 = move-exception
            r10 = r1
            r1 = r12
            r12 = r10
        L_0x0072:
            if (r11 == 0) goto L_0x0082
            if (r1 == 0) goto L_0x007f
            r11.close()     // Catch:{ Throwable -> 0x007a }
            goto L_0x0082
        L_0x007a:
            r11 = move-exception
            r1.addSuppressed(r11)     // Catch:{ Exception -> 0x0089 }
            goto L_0x0082
        L_0x007f:
            r11.close()     // Catch:{ Exception -> 0x0089 }
        L_0x0082:
            throw r12     // Catch:{ Exception -> 0x0089 }
        L_0x0083:
            if (r11 == 0) goto L_0x009e
            r11.close()     // Catch:{ Exception -> 0x0089 }
            goto L_0x009e
        L_0x0089:
            r11 = move-exception
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r1 = "getAnimojiStickerInfo, e: "
            r12.append(r1)
            r12.append(r11)
            java.lang.String r11 = r12.toString()
            com.oppo.camera.e.d(r3, r11)
        L_0x009e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.sticker.g.b(android.content.Context, com.oppo.camera.sticker.data.StickerItem):com.oppo.camera.sticker.data.AnimojiStickerExtendedInfo");
    }

    private static AnimojiStickerExtendedInfo c(Cursor cursor) {
        AnimojiStickerExtendedInfo animojiStickerExtendedInfo = new AnimojiStickerExtendedInfo();
        animojiStickerExtendedInfo.setBackgroundColor(cursor.getString(cursor.getColumnIndexOrThrow("background_color")));
        return animojiStickerExtendedInfo;
    }
}
