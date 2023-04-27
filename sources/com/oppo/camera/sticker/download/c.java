package com.oppo.camera.sticker.download;

import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.oppo.camera.e;
import com.oppo.camera.sticker.c.b;
import com.oppo.camera.sticker.data.AnimojiStickerExtendedInfo;
import com.oppo.camera.sticker.data.BuildInSticker;
import com.oppo.camera.sticker.data.MultiStickerExtendedInfo;
import com.oppo.camera.sticker.data.StickerItem;
import com.oppo.camera.sticker.data.StickerItemWrapper;
import com.oppo.camera.sticker.h;
import com.oppo.camera.sticker.provider.FileProvider;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* compiled from: StickerInstaller */
public class c {
    public static boolean a(Context context, BuildInSticker buildInSticker) {
        if (context == null || buildInSticker == null) {
            e.d("StickerInstaller", "installBuildInSticker, parameter is null! context: " + context);
            return false;
        }
        e.b("StickerInstaller", "installBuildInSticker, buildInSticker: " + buildInSticker);
        try {
            String a2 = b.a(context, b.l, buildInSticker.getStickerUUID());
            if (b.a(context.getAssets().open(buildInSticker.getAssetThumbnailPath()), a2, true, true)) {
                Uri a3 = FileProvider.a(context, "com.oppo.camera.providers.sticker.file.provider", new File(a2));
                StickerItemWrapper obtainStickerItem = buildInSticker.obtainStickerItem();
                obtainStickerItem.setIsBuildIn(true);
                obtainStickerItem.setThumbnailPath(a2);
                obtainStickerItem.setThumbnailFileUri(a3.toString());
                int materialType = obtainStickerItem.getMaterialType();
                if (materialType == 0) {
                    return b(context, obtainStickerItem, buildInSticker.getAssetFilePath());
                }
                if (materialType == 1) {
                    return c(context, obtainStickerItem, buildInSticker.getAssetFilePath());
                }
                if (materialType == 2) {
                    return a(context, obtainStickerItem, buildInSticker.getAssetFilePath(), buildInSticker.getBackgroundColor());
                }
                e.d("StickerInstaller", "installBuildInSticker, can not supported material type!");
            } else {
                e.d("StickerInstaller", "installBuildInSticker, saveThumb fail!");
            }
        } catch (Exception e) {
            e.d("StickerInstaller", "installBuildInSticker, Exception: " + e);
        }
        return false;
    }

    public static boolean a(Context context, StickerItemWrapper stickerItemWrapper, String str) {
        if (context == null || stickerItemWrapper == null) {
            e.d("StickerInstaller", "installSticker, parameter is null! context: " + context);
            return false;
        }
        e.b("StickerInstaller", "installSticker, srcFilePath: " + str + ", stickerItem: " + stickerItemWrapper);
        int materialType = stickerItemWrapper.getMaterialType();
        if (materialType == 0) {
            return b(context, stickerItemWrapper, str);
        }
        if (materialType == 1) {
            return c(context, stickerItemWrapper, str);
        }
        if (materialType == 2) {
            return a(context, stickerItemWrapper, str, (String) null);
        }
        e.d("StickerInstaller", "installBuildInSticker, can not supported material type!");
        return false;
    }

    private static boolean b(Context context, StickerItemWrapper stickerItemWrapper, String str) {
        if (context == null || stickerItemWrapper == null) {
            e.d("StickerInstaller", "installNormalSticker, null parameter! context: " + context);
            return false;
        }
        try {
            if (stickerItemWrapper.getMaterialType() != 0) {
                e.d("StickerInstaller", "installNormalSticker, not a normal type! item: " + stickerItemWrapper);
                return false;
            }
            String a2 = b.a(context, b.h, stickerItemWrapper.getStickerUUID());
            boolean z = true;
            if (!stickerItemWrapper.isRecycleBin()) {
                if (TextUtils.isEmpty(str)) {
                    e.d("StickerInstaller", "installNormalSticker, file path is empty!");
                    return false;
                } else if (!stickerItemWrapper.isBuildIn() || !str.startsWith("sticker/material")) {
                    z = b.a(str, a2);
                    if (!z && !(z = com.oppo.camera.sticker.c.c.a(a2, stickerItemWrapper.getFileMd5()))) {
                        e.d("StickerInstaller", "installNormalSticker, md5CheckSum error! stickerItem: " + stickerItemWrapper);
                    }
                } else {
                    z = b.a(context.getAssets().open(str), a2, true, true);
                }
            }
            if (z) {
                stickerItemWrapper.setFileContentUri(FileProvider.a(context, "com.oppo.camera.providers.sticker.file.provider", new File(a2)).toString());
                stickerItemWrapper.setFilePath(a2);
                stickerItemWrapper.setDownloadState(8);
                stickerItemWrapper.setNeedUpdate(false);
                if (!stickerItemWrapper.isBuildIn() && stickerItemWrapper.getDownloadTime() == 0) {
                    stickerItemWrapper.setDownloadTime(System.currentTimeMillis());
                }
                return com.oppo.camera.sticker.a.b.a(context, stickerItemWrapper);
            }
            e.d("StickerInstaller", "installNormalSticker, save saveFile!");
            return false;
        } catch (Exception e) {
            e.d("StickerInstaller", "installNormalSticker exception e: " + e);
        }
    }

    /* JADX WARNING: type inference failed for: r5v0 */
    /* JADX WARNING: type inference failed for: r5v1 */
    /* JADX WARNING: type inference failed for: r5v2, types: [java.util.zip.ZipFile] */
    /* JADX WARNING: type inference failed for: r5v3 */
    /* JADX WARNING: type inference failed for: r5v4, types: [java.util.List] */
    /* JADX WARNING: type inference failed for: r5v8 */
    /* JADX WARNING: type inference failed for: r5v13 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x0307 A[SYNTHETIC, Splitter:B:129:0x0307] */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x0326 A[SYNTHETIC, Splitter:B:138:0x0326] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean c(android.content.Context r13, com.oppo.camera.sticker.data.StickerItemWrapper r14, java.lang.String r15) {
        /*
            java.lang.String r0 = "installMultiSticker close zip file exception: "
            boolean r1 = android.text.TextUtils.isEmpty(r15)
            r2 = 0
            java.lang.String r3 = "StickerInstaller"
            if (r1 == 0) goto L_0x0011
            java.lang.String r13 = "installMultiSticker, file path is empty!"
            com.oppo.camera.e.d(r3, r13)
            return r2
        L_0x0011:
            if (r13 == 0) goto L_0x0341
            if (r14 != 0) goto L_0x0017
            goto L_0x0341
        L_0x0017:
            int r1 = r14.getMaterialType()
            r4 = 1
            if (r1 == r4) goto L_0x0033
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            java.lang.String r15 = "installMultiSticker, not a multi type! item: "
            r13.append(r15)
            r13.append(r14)
            java.lang.String r13 = r13.toString()
            com.oppo.camera.e.d(r3, r13)
            return r2
        L_0x0033:
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r5 = 0
            boolean r6 = r14.isBuildIn()     // Catch:{ Exception -> 0x02ef, all -> 0x02eb }
            if (r6 == 0) goto L_0x00ab
            java.lang.String r6 = "sticker/material"
            boolean r6 = r15.startsWith(r6)     // Catch:{ Exception -> 0x02ef, all -> 0x02eb }
            if (r6 == 0) goto L_0x00ab
            java.lang.String r6 = com.oppo.camera.sticker.c.b.a((java.lang.String) r15)     // Catch:{ Exception -> 0x02ef, all -> 0x02eb }
            boolean r7 = android.text.TextUtils.isEmpty(r6)     // Catch:{ Exception -> 0x02ef, all -> 0x02eb }
            if (r7 == 0) goto L_0x006d
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02ef, all -> 0x02eb }
            r6.<init>()     // Catch:{ Exception -> 0x02ef, all -> 0x02eb }
            java.lang.String r7 = "installMultiSticker, parse file name fail! path: "
            r6.append(r7)     // Catch:{ Exception -> 0x02ef, all -> 0x02eb }
            r6.append(r15)     // Catch:{ Exception -> 0x02ef, all -> 0x02eb }
            java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x02ef, all -> 0x02eb }
            com.oppo.camera.e.d(r3, r6)     // Catch:{ Exception -> 0x02ef, all -> 0x02eb }
            java.util.UUID r6 = java.util.UUID.randomUUID()     // Catch:{ Exception -> 0x02ef, all -> 0x02eb }
            java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x02ef, all -> 0x02eb }
        L_0x006d:
            java.lang.String r7 = com.oppo.camera.sticker.c.b.k     // Catch:{ Exception -> 0x02ef, all -> 0x02eb }
            java.lang.String r6 = com.oppo.camera.sticker.c.b.a(r13, r7, r6)     // Catch:{ Exception -> 0x02ef, all -> 0x02eb }
            android.content.res.AssetManager r7 = r13.getAssets()     // Catch:{ Exception -> 0x00a7, all -> 0x00a3 }
            java.io.InputStream r7 = r7.open(r15)     // Catch:{ Exception -> 0x00a7, all -> 0x00a3 }
            boolean r7 = com.oppo.camera.sticker.c.b.a(r7, r6, r4, r4)     // Catch:{ Exception -> 0x00a7, all -> 0x00a3 }
            if (r7 != 0) goto L_0x00a1
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00a7, all -> 0x00a3 }
            r13.<init>()     // Catch:{ Exception -> 0x00a7, all -> 0x00a3 }
            java.lang.String r14 = "installMultiSticker, save inputStream fail! src: "
            r13.append(r14)     // Catch:{ Exception -> 0x00a7, all -> 0x00a3 }
            r13.append(r15)     // Catch:{ Exception -> 0x00a7, all -> 0x00a3 }
            java.lang.String r14 = ", dest: "
            r13.append(r14)     // Catch:{ Exception -> 0x00a7, all -> 0x00a3 }
            r13.append(r6)     // Catch:{ Exception -> 0x00a7, all -> 0x00a3 }
            java.lang.String r13 = r13.toString()     // Catch:{ Exception -> 0x00a7, all -> 0x00a3 }
            com.oppo.camera.e.d(r3, r13)     // Catch:{ Exception -> 0x00a7, all -> 0x00a3 }
            com.oppo.camera.sticker.c.b.b(r6)
            return r2
        L_0x00a1:
            r15 = r6
            goto L_0x00ab
        L_0x00a3:
            r13 = move-exception
            r15 = r6
            goto L_0x0323
        L_0x00a7:
            r13 = move-exception
            r15 = r6
            goto L_0x02f1
        L_0x00ab:
            java.util.zip.ZipFile r6 = new java.util.zip.ZipFile     // Catch:{ Exception -> 0x02e9 }
            r6.<init>(r15)     // Catch:{ Exception -> 0x02e9 }
            java.util.List r7 = a((java.util.zip.ZipFile) r6)     // Catch:{ Exception -> 0x02e6, all -> 0x02e4 }
            java.util.Iterator r7 = r7.iterator()     // Catch:{ Exception -> 0x02e6, all -> 0x02e4 }
        L_0x00b8:
            boolean r8 = r7.hasNext()     // Catch:{ Exception -> 0x02e6, all -> 0x02e4 }
            if (r8 == 0) goto L_0x01a5
            java.lang.Object r8 = r7.next()     // Catch:{ Exception -> 0x02e6, all -> 0x02e4 }
            java.util.zip.ZipEntry r8 = (java.util.zip.ZipEntry) r8     // Catch:{ Exception -> 0x02e6, all -> 0x02e4 }
            boolean r9 = r8.isDirectory()     // Catch:{ Exception -> 0x02e6, all -> 0x02e4 }
            if (r9 == 0) goto L_0x00cb
            goto L_0x00b8
        L_0x00cb:
            java.lang.String r9 = r8.getName()     // Catch:{ Exception -> 0x02e6, all -> 0x02e4 }
            java.lang.String r10 = "../"
            boolean r10 = r9.contains(r10)     // Catch:{ Exception -> 0x02e6, all -> 0x02e4 }
            if (r10 == 0) goto L_0x00d8
            goto L_0x00b8
        L_0x00d8:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02e6, all -> 0x02e4 }
            r10.<init>()     // Catch:{ Exception -> 0x02e6, all -> 0x02e4 }
            java.lang.String r11 = "installMultiSticker entryName: "
            r10.append(r11)     // Catch:{ Exception -> 0x02e6, all -> 0x02e4 }
            r10.append(r9)     // Catch:{ Exception -> 0x02e6, all -> 0x02e4 }
            java.lang.String r10 = r10.toString()     // Catch:{ Exception -> 0x02e6, all -> 0x02e4 }
            com.oppo.camera.e.b(r3, r10)     // Catch:{ Exception -> 0x02e6, all -> 0x02e4 }
            java.lang.String r10 = "StickerMultiCfg.json"
            boolean r10 = r9.endsWith(r10)     // Catch:{ Exception -> 0x02e6, all -> 0x02e4 }
            if (r10 == 0) goto L_0x00fd
            java.lang.String r5 = com.oppo.camera.sticker.c.b.a((java.util.zip.ZipFile) r6, (java.util.zip.ZipEntry) r8)     // Catch:{ Exception -> 0x02e6, all -> 0x02e4 }
            java.util.List r5 = b(r5)     // Catch:{ Exception -> 0x02e6, all -> 0x02e4 }
            goto L_0x00b8
        L_0x00fd:
            if (r5 == 0) goto L_0x0185
            boolean r10 = r5.isEmpty()     // Catch:{ Exception -> 0x02e6, all -> 0x02e4 }
            if (r10 == 0) goto L_0x0107
            goto L_0x0185
        L_0x0107:
            java.lang.String r10 = ".zip"
            boolean r10 = r9.endsWith(r10)     // Catch:{ Exception -> 0x02e6, all -> 0x02e4 }
            if (r10 != 0) goto L_0x0124
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02e6, all -> 0x02e4 }
            r8.<init>()     // Catch:{ Exception -> 0x02e6, all -> 0x02e4 }
            java.lang.String r10 = "installMultiSticker unsupported file, name: "
            r8.append(r10)     // Catch:{ Exception -> 0x02e6, all -> 0x02e4 }
            r8.append(r9)     // Catch:{ Exception -> 0x02e6, all -> 0x02e4 }
            java.lang.String r8 = r8.toString()     // Catch:{ Exception -> 0x02e6, all -> 0x02e4 }
            com.oppo.camera.e.d(r3, r8)     // Catch:{ Exception -> 0x02e6, all -> 0x02e4 }
            goto L_0x00b8
        L_0x0124:
            java.lang.String r10 = com.oppo.camera.sticker.c.b.i     // Catch:{ Exception -> 0x02e6, all -> 0x02e4 }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02e6, all -> 0x02e4 }
            r11.<init>()     // Catch:{ Exception -> 0x02e6, all -> 0x02e4 }
            java.lang.String r12 = java.io.File.separator     // Catch:{ Exception -> 0x02e6, all -> 0x02e4 }
            r11.append(r12)     // Catch:{ Exception -> 0x02e6, all -> 0x02e4 }
            java.lang.String r12 = r14.getStickerUUID()     // Catch:{ Exception -> 0x02e6, all -> 0x02e4 }
            r11.append(r12)     // Catch:{ Exception -> 0x02e6, all -> 0x02e4 }
            java.lang.String r12 = java.io.File.separator     // Catch:{ Exception -> 0x02e6, all -> 0x02e4 }
            r11.append(r12)     // Catch:{ Exception -> 0x02e6, all -> 0x02e4 }
            r11.append(r9)     // Catch:{ Exception -> 0x02e6, all -> 0x02e4 }
            java.lang.String r11 = r11.toString()     // Catch:{ Exception -> 0x02e6, all -> 0x02e4 }
            java.lang.String r10 = com.oppo.camera.sticker.c.b.a(r13, r10, r11)     // Catch:{ Exception -> 0x02e6, all -> 0x02e4 }
            java.io.InputStream r8 = r6.getInputStream(r8)     // Catch:{ Exception -> 0x02e6, all -> 0x02e4 }
            boolean r8 = com.oppo.camera.sticker.c.b.a(r8, r10, r4, r4)     // Catch:{ Exception -> 0x02e6, all -> 0x02e4 }
            if (r8 == 0) goto L_0x0156
            r1.add(r10)     // Catch:{ Exception -> 0x02e6, all -> 0x02e4 }
            goto L_0x00b8
        L_0x0156:
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02e6, all -> 0x02e4 }
            r13.<init>()     // Catch:{ Exception -> 0x02e6, all -> 0x02e4 }
            java.lang.String r14 = "installMultiSticker save file fail!, name: "
            r13.append(r14)     // Catch:{ Exception -> 0x02e6, all -> 0x02e4 }
            r13.append(r9)     // Catch:{ Exception -> 0x02e6, all -> 0x02e4 }
            java.lang.String r13 = r13.toString()     // Catch:{ Exception -> 0x02e6, all -> 0x02e4 }
            com.oppo.camera.e.d(r3, r13)     // Catch:{ Exception -> 0x02e6, all -> 0x02e4 }
            r6.close()     // Catch:{ IOException -> 0x016e }
            goto L_0x0181
        L_0x016e:
            r13 = move-exception
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            r14.append(r0)
            r14.append(r13)
            java.lang.String r13 = r14.toString()
            com.oppo.camera.e.d(r3, r13)
        L_0x0181:
            com.oppo.camera.sticker.c.b.b(r15)
            return r2
        L_0x0185:
            java.lang.String r13 = "installMultiSticker, parse config file fail!"
            com.oppo.camera.e.d(r3, r13)     // Catch:{ Exception -> 0x02e6, all -> 0x02e4 }
            r6.close()     // Catch:{ IOException -> 0x018e }
            goto L_0x01a1
        L_0x018e:
            r13 = move-exception
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            r14.append(r0)
            r14.append(r13)
            java.lang.String r13 = r14.toString()
            com.oppo.camera.e.d(r3, r13)
        L_0x01a1:
            com.oppo.camera.sticker.c.b.b(r15)
            return r2
        L_0x01a5:
            if (r5 == 0) goto L_0x029c
            java.util.Iterator r4 = r5.iterator()     // Catch:{ Exception -> 0x02e6, all -> 0x02e4 }
        L_0x01ab:
            boolean r7 = r4.hasNext()     // Catch:{ Exception -> 0x02e6, all -> 0x02e4 }
            if (r7 == 0) goto L_0x029c
            java.lang.Object r7 = r4.next()     // Catch:{ Exception -> 0x02e6, all -> 0x02e4 }
            com.oppo.camera.sticker.data.MultiStickerExtendedInfo r7 = (com.oppo.camera.sticker.data.MultiStickerExtendedInfo) r7     // Catch:{ Exception -> 0x02e6, all -> 0x02e4 }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02e6, all -> 0x02e4 }
            r8.<init>()     // Catch:{ Exception -> 0x02e6, all -> 0x02e4 }
            java.lang.String r9 = "installMultiSticker, multiStickerInfo: "
            r8.append(r9)     // Catch:{ Exception -> 0x02e6, all -> 0x02e4 }
            r8.append(r7)     // Catch:{ Exception -> 0x02e6, all -> 0x02e4 }
            java.lang.String r8 = r8.toString()     // Catch:{ Exception -> 0x02e6, all -> 0x02e4 }
            com.oppo.camera.e.b(r3, r8)     // Catch:{ Exception -> 0x02e6, all -> 0x02e4 }
            java.util.Iterator r8 = r1.iterator()     // Catch:{ Exception -> 0x02e6, all -> 0x02e4 }
            r9 = r2
        L_0x01d0:
            boolean r10 = r8.hasNext()     // Catch:{ Exception -> 0x02e6, all -> 0x02e4 }
            if (r10 == 0) goto L_0x01ab
            java.lang.Object r10 = r8.next()     // Catch:{ Exception -> 0x02e6, all -> 0x02e4 }
            java.lang.String r10 = (java.lang.String) r10     // Catch:{ Exception -> 0x02e6, all -> 0x02e4 }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02e6, all -> 0x02e4 }
            r11.<init>()     // Catch:{ Exception -> 0x02e6, all -> 0x02e4 }
            java.lang.String r12 = "installMultiSticker, filePath: "
            r11.append(r12)     // Catch:{ Exception -> 0x02e6, all -> 0x02e4 }
            r11.append(r10)     // Catch:{ Exception -> 0x02e6, all -> 0x02e4 }
            java.lang.String r11 = r11.toString()     // Catch:{ Exception -> 0x02e6, all -> 0x02e4 }
            com.oppo.camera.e.b(r3, r11)     // Catch:{ Exception -> 0x02e6, all -> 0x02e4 }
            boolean r11 = r7.getIsFitToSize()     // Catch:{ Exception -> 0x02e6, all -> 0x02e4 }
            r12 = 7
            if (r11 == 0) goto L_0x0267
            java.lang.String r11 = "/16_9/"
            boolean r11 = r10.contains(r11)     // Catch:{ Exception -> 0x02e6, all -> 0x02e4 }
            if (r11 == 0) goto L_0x021d
            java.lang.String r11 = r7.getStickerName()     // Catch:{ Exception -> 0x02e6, all -> 0x02e4 }
            boolean r11 = r10.contains(r11)     // Catch:{ Exception -> 0x02e6, all -> 0x02e4 }
            if (r11 == 0) goto L_0x021d
            java.io.File r11 = new java.io.File     // Catch:{ Exception -> 0x02e6, all -> 0x02e4 }
            r11.<init>(r10)     // Catch:{ Exception -> 0x02e6, all -> 0x02e4 }
            android.net.Uri r10 = com.oppo.camera.sticker.provider.FileProvider.a((android.content.Context) r13, (java.io.File) r11)     // Catch:{ Exception -> 0x02e6, all -> 0x02e4 }
            java.lang.String r10 = r10.toString()     // Catch:{ Exception -> 0x02e6, all -> 0x02e4 }
            r7.setFileContentUri16x9(r10)     // Catch:{ Exception -> 0x02e6, all -> 0x02e4 }
            r9 = r9 | 1
            goto L_0x0298
        L_0x021d:
            java.lang.String r11 = "/4_3/"
            boolean r11 = r10.contains(r11)     // Catch:{ Exception -> 0x02e6, all -> 0x02e4 }
            if (r11 == 0) goto L_0x0242
            java.lang.String r11 = r7.getStickerName()     // Catch:{ Exception -> 0x02e6, all -> 0x02e4 }
            boolean r11 = r10.contains(r11)     // Catch:{ Exception -> 0x02e6, all -> 0x02e4 }
            if (r11 == 0) goto L_0x0242
            java.io.File r11 = new java.io.File     // Catch:{ Exception -> 0x02e6, all -> 0x02e4 }
            r11.<init>(r10)     // Catch:{ Exception -> 0x02e6, all -> 0x02e4 }
            android.net.Uri r10 = com.oppo.camera.sticker.provider.FileProvider.a((android.content.Context) r13, (java.io.File) r11)     // Catch:{ Exception -> 0x02e6, all -> 0x02e4 }
            java.lang.String r10 = r10.toString()     // Catch:{ Exception -> 0x02e6, all -> 0x02e4 }
            r7.setFileContentUri4x3(r10)     // Catch:{ Exception -> 0x02e6, all -> 0x02e4 }
            r9 = r9 | 2
            goto L_0x0298
        L_0x0242:
            java.lang.String r11 = "/1_1/"
            boolean r11 = r10.contains(r11)     // Catch:{ Exception -> 0x02e6, all -> 0x02e4 }
            if (r11 == 0) goto L_0x0298
            java.lang.String r11 = r7.getStickerName()     // Catch:{ Exception -> 0x02e6, all -> 0x02e4 }
            boolean r11 = r10.contains(r11)     // Catch:{ Exception -> 0x02e6, all -> 0x02e4 }
            if (r11 == 0) goto L_0x0298
            java.io.File r11 = new java.io.File     // Catch:{ Exception -> 0x02e6, all -> 0x02e4 }
            r11.<init>(r10)     // Catch:{ Exception -> 0x02e6, all -> 0x02e4 }
            android.net.Uri r10 = com.oppo.camera.sticker.provider.FileProvider.a((android.content.Context) r13, (java.io.File) r11)     // Catch:{ Exception -> 0x02e6, all -> 0x02e4 }
            java.lang.String r10 = r10.toString()     // Catch:{ Exception -> 0x02e6, all -> 0x02e4 }
            r7.setFileContentUri1x1(r10)     // Catch:{ Exception -> 0x02e6, all -> 0x02e4 }
            r9 = r9 | 4
            goto L_0x0298
        L_0x0267:
            java.lang.String r11 = "/Default/"
            boolean r11 = r10.contains(r11)     // Catch:{ Exception -> 0x02e6, all -> 0x02e4 }
            if (r11 == 0) goto L_0x0298
            java.lang.String r11 = r7.getStickerName()     // Catch:{ Exception -> 0x02e6, all -> 0x02e4 }
            boolean r11 = r10.contains(r11)     // Catch:{ Exception -> 0x02e6, all -> 0x02e4 }
            if (r11 == 0) goto L_0x0298
            java.io.File r9 = new java.io.File     // Catch:{ Exception -> 0x02e6, all -> 0x02e4 }
            r9.<init>(r10)     // Catch:{ Exception -> 0x02e6, all -> 0x02e4 }
            android.net.Uri r9 = com.oppo.camera.sticker.provider.FileProvider.a((android.content.Context) r13, (java.io.File) r9)     // Catch:{ Exception -> 0x02e6, all -> 0x02e4 }
            java.lang.String r10 = r9.toString()     // Catch:{ Exception -> 0x02e6, all -> 0x02e4 }
            r7.setFileContentUri16x9(r10)     // Catch:{ Exception -> 0x02e6, all -> 0x02e4 }
            java.lang.String r10 = r9.toString()     // Catch:{ Exception -> 0x02e6, all -> 0x02e4 }
            r7.setFileContentUri4x3(r10)     // Catch:{ Exception -> 0x02e6, all -> 0x02e4 }
            java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x02e6, all -> 0x02e4 }
            r7.setFileContentUri1x1(r9)     // Catch:{ Exception -> 0x02e6, all -> 0x02e4 }
            r9 = r12
        L_0x0298:
            if (r9 != r12) goto L_0x01d0
            goto L_0x01ab
        L_0x029c:
            java.lang.String r1 = r14.getStickerUUID()     // Catch:{ Exception -> 0x02e6, all -> 0x02e4 }
            boolean r1 = com.oppo.camera.sticker.a.b.a((android.content.Context) r13, (java.lang.String) r1, (java.util.List<com.oppo.camera.sticker.data.MultiStickerExtendedInfo>) r5)     // Catch:{ Exception -> 0x02e6, all -> 0x02e4 }
            if (r1 == 0) goto L_0x02c5
            r1 = 8
            r14.setDownloadState(r1)     // Catch:{ Exception -> 0x02e6, all -> 0x02e4 }
            r14.setNeedUpdate(r2)     // Catch:{ Exception -> 0x02e6, all -> 0x02e4 }
            boolean r1 = r14.isBuildIn()     // Catch:{ Exception -> 0x02e6, all -> 0x02e4 }
            if (r1 != 0) goto L_0x02c5
            long r4 = r14.getDownloadTime()     // Catch:{ Exception -> 0x02e6, all -> 0x02e4 }
            r7 = 0
            int r1 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r1 != 0) goto L_0x02c5
            long r4 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x02e6, all -> 0x02e4 }
            r14.setDownloadTime(r4)     // Catch:{ Exception -> 0x02e6, all -> 0x02e4 }
        L_0x02c5:
            boolean r13 = com.oppo.camera.sticker.a.b.a((android.content.Context) r13, (com.oppo.camera.sticker.data.StickerItemWrapper) r14)     // Catch:{ Exception -> 0x02e6, all -> 0x02e4 }
            r6.close()     // Catch:{ IOException -> 0x02cd }
            goto L_0x02e0
        L_0x02cd:
            r14 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            r1.append(r14)
            java.lang.String r14 = r1.toString()
            com.oppo.camera.e.d(r3, r14)
        L_0x02e0:
            com.oppo.camera.sticker.c.b.b(r15)
            return r13
        L_0x02e4:
            r13 = move-exception
            goto L_0x0324
        L_0x02e6:
            r13 = move-exception
            r5 = r6
            goto L_0x02f1
        L_0x02e9:
            r13 = move-exception
            goto L_0x02f1
        L_0x02eb:
            r13 = move-exception
            r15 = r5
            r6 = r15
            goto L_0x0324
        L_0x02ef:
            r13 = move-exception
            r15 = r5
        L_0x02f1:
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ all -> 0x0322 }
            r14.<init>()     // Catch:{ all -> 0x0322 }
            java.lang.String r1 = "installMultiSticker exception e: "
            r14.append(r1)     // Catch:{ all -> 0x0322 }
            r14.append(r13)     // Catch:{ all -> 0x0322 }
            java.lang.String r13 = r14.toString()     // Catch:{ all -> 0x0322 }
            com.oppo.camera.e.d(r3, r13)     // Catch:{ all -> 0x0322 }
            if (r5 == 0) goto L_0x031e
            r5.close()     // Catch:{ IOException -> 0x030b }
            goto L_0x031e
        L_0x030b:
            r13 = move-exception
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            r14.append(r0)
            r14.append(r13)
            java.lang.String r13 = r14.toString()
            com.oppo.camera.e.d(r3, r13)
        L_0x031e:
            com.oppo.camera.sticker.c.b.b(r15)
            return r2
        L_0x0322:
            r13 = move-exception
        L_0x0323:
            r6 = r5
        L_0x0324:
            if (r6 == 0) goto L_0x033d
            r6.close()     // Catch:{ IOException -> 0x032a }
            goto L_0x033d
        L_0x032a:
            r14 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            r1.append(r14)
            java.lang.String r14 = r1.toString()
            com.oppo.camera.e.d(r3, r14)
        L_0x033d:
            com.oppo.camera.sticker.c.b.b(r15)
            throw r13
        L_0x0341:
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            java.lang.String r15 = "installMultiSticker, null parameter! context: "
            r14.append(r15)
            r14.append(r13)
            java.lang.String r13 = r14.toString()
            com.oppo.camera.e.d(r3, r13)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.sticker.download.c.c(android.content.Context, com.oppo.camera.sticker.data.StickerItemWrapper, java.lang.String):boolean");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: java.util.zip.ZipFile} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: java.util.zip.ZipFile} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: java.util.zip.ZipFile} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: java.util.zip.ZipFile} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v1, resolved type: com.oppo.camera.sticker.data.AnimojiStickerExtendedInfo} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v7, resolved type: java.util.zip.ZipFile} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v9, resolved type: java.util.zip.ZipFile} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v10, resolved type: java.util.zip.ZipFile} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v11, resolved type: java.util.zip.ZipFile} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v3, resolved type: com.oppo.camera.sticker.data.AnimojiStickerExtendedInfo} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v12, resolved type: java.util.zip.ZipFile} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v6, resolved type: com.oppo.camera.sticker.data.AnimojiStickerExtendedInfo} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v20, resolved type: java.util.zip.ZipFile} */
    /* JADX WARNING: type inference failed for: r1v15, types: [com.oppo.camera.sticker.data.AnimojiStickerExtendedInfo] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x01e7 A[SYNTHETIC, Splitter:B:83:0x01e7] */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0204  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x020a A[SYNTHETIC, Splitter:B:92:0x020a] */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0227  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean a(android.content.Context r12, com.oppo.camera.sticker.data.StickerItemWrapper r13, java.lang.String r14, java.lang.String r15) {
        /*
            java.lang.String r0 = "installAnimojiSticker close zip file exception: "
            boolean r1 = android.text.TextUtils.isEmpty(r14)
            r2 = 0
            java.lang.String r3 = "StickerInstaller"
            if (r1 == 0) goto L_0x0011
            java.lang.String r12 = "installAnimojiSticker, file path is empty!"
            com.oppo.camera.e.d(r3, r12)
            return r2
        L_0x0011:
            if (r12 == 0) goto L_0x022b
            if (r13 != 0) goto L_0x0017
            goto L_0x022b
        L_0x0017:
            int r1 = r13.getMaterialType()
            r4 = 2
            if (r1 == r4) goto L_0x0033
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r14 = "installAnimojiSticker, not a animoji type! item: "
            r12.append(r14)
            r12.append(r13)
            java.lang.String r12 = r12.toString()
            com.oppo.camera.e.d(r3, r12)
            return r2
        L_0x0033:
            r1 = 0
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ Exception -> 0x01e1 }
            r4.<init>()     // Catch:{ Exception -> 0x01e1 }
            boolean r5 = r13.isBuildIn()     // Catch:{ Exception -> 0x01e1 }
            r6 = 1
            if (r5 == 0) goto L_0x0083
            java.lang.String r5 = "sticker/material"
            boolean r5 = r14.startsWith(r5)     // Catch:{ Exception -> 0x01e1 }
            if (r5 == 0) goto L_0x0083
            com.oppo.camera.sticker.data.AnimojiStickerExtendedInfo r5 = new com.oppo.camera.sticker.data.AnimojiStickerExtendedInfo     // Catch:{ Exception -> 0x01e1 }
            r5.<init>()     // Catch:{ Exception -> 0x01e1 }
            r5.setBackgroundColor(r15)     // Catch:{ Exception -> 0x01e1 }
            java.lang.String r15 = com.oppo.camera.sticker.c.b.j     // Catch:{ Exception -> 0x01e1 }
            java.lang.String r7 = r13.getStickerUUID()     // Catch:{ Exception -> 0x01e1 }
            java.lang.String r15 = com.oppo.camera.sticker.c.b.a(r12, r15, r7)     // Catch:{ Exception -> 0x01e1 }
            android.content.res.AssetManager r7 = r12.getAssets()     // Catch:{ Exception -> 0x01e1 }
            java.io.InputStream r7 = r7.open(r14)     // Catch:{ Exception -> 0x01e1 }
            boolean r6 = com.oppo.camera.sticker.c.b.a(r7, r15, r6, r6)     // Catch:{ Exception -> 0x01e1 }
            if (r6 == 0) goto L_0x006d
            r4.add(r15)     // Catch:{ Exception -> 0x01e1 }
            goto L_0x0135
        L_0x006d:
            java.lang.StringBuilder r15 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01e1 }
            r15.<init>()     // Catch:{ Exception -> 0x01e1 }
            java.lang.String r6 = "installAnimojiSticker, save inputStream Fail! stickerFileSrcPath: "
            r15.append(r6)     // Catch:{ Exception -> 0x01e1 }
            r15.append(r14)     // Catch:{ Exception -> 0x01e1 }
            java.lang.String r15 = r15.toString()     // Catch:{ Exception -> 0x01e1 }
            com.oppo.camera.e.d(r3, r15)     // Catch:{ Exception -> 0x01e1 }
            goto L_0x0135
        L_0x0083:
            java.util.zip.ZipFile r15 = new java.util.zip.ZipFile     // Catch:{ Exception -> 0x01e1 }
            r15.<init>(r14)     // Catch:{ Exception -> 0x01e1 }
            java.util.Enumeration r5 = r15.entries()     // Catch:{ Exception -> 0x01dc, all -> 0x01d9 }
        L_0x008c:
            boolean r7 = r5.hasMoreElements()     // Catch:{ Exception -> 0x01dc, all -> 0x01d9 }
            if (r7 == 0) goto L_0x0133
            java.lang.Object r7 = r5.nextElement()     // Catch:{ Exception -> 0x01dc, all -> 0x01d9 }
            java.util.zip.ZipEntry r7 = (java.util.zip.ZipEntry) r7     // Catch:{ Exception -> 0x01dc, all -> 0x01d9 }
            java.lang.String r8 = r7.getName()     // Catch:{ Exception -> 0x01dc, all -> 0x01d9 }
            java.lang.String r8 = r8.toLowerCase()     // Catch:{ Exception -> 0x01dc, all -> 0x01d9 }
            java.lang.String r9 = "../"
            boolean r9 = r8.contains(r9)     // Catch:{ Exception -> 0x01dc, all -> 0x01d9 }
            if (r9 == 0) goto L_0x00a9
            goto L_0x008c
        L_0x00a9:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01dc, all -> 0x01d9 }
            r9.<init>()     // Catch:{ Exception -> 0x01dc, all -> 0x01d9 }
            java.lang.String r10 = "installAnimojiSticker entryName: "
            r9.append(r10)     // Catch:{ Exception -> 0x01dc, all -> 0x01d9 }
            r9.append(r8)     // Catch:{ Exception -> 0x01dc, all -> 0x01d9 }
            java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x01dc, all -> 0x01d9 }
            com.oppo.camera.e.b(r3, r9)     // Catch:{ Exception -> 0x01dc, all -> 0x01d9 }
            java.lang.String r9 = "ConfigInfo.json"
            java.lang.String r9 = r9.toLowerCase()     // Catch:{ Exception -> 0x01dc, all -> 0x01d9 }
            boolean r9 = r8.endsWith(r9)     // Catch:{ Exception -> 0x01dc, all -> 0x01d9 }
            if (r9 == 0) goto L_0x00d2
            java.lang.String r1 = com.oppo.camera.sticker.c.b.a((java.util.zip.ZipFile) r15, (java.util.zip.ZipEntry) r7)     // Catch:{ Exception -> 0x01dc, all -> 0x01d9 }
            com.oppo.camera.sticker.data.AnimojiStickerExtendedInfo r1 = a((java.lang.String) r1)     // Catch:{ Exception -> 0x01dc, all -> 0x01d9 }
            goto L_0x008c
        L_0x00d2:
            java.lang.String r9 = ".zip"
            boolean r9 = r8.endsWith(r9)     // Catch:{ Exception -> 0x01dc, all -> 0x01d9 }
            if (r9 == 0) goto L_0x008c
            java.lang.String r9 = com.oppo.camera.sticker.c.b.a((java.lang.String) r8)     // Catch:{ Exception -> 0x01dc, all -> 0x01d9 }
            boolean r10 = android.text.TextUtils.isEmpty(r9)     // Catch:{ Exception -> 0x01dc, all -> 0x01d9 }
            if (r10 != 0) goto L_0x0108
            java.util.UUID r9 = java.util.UUID.randomUUID()     // Catch:{ Exception -> 0x01dc, all -> 0x01d9 }
            java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x01dc, all -> 0x01d9 }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01dc, all -> 0x01d9 }
            r10.<init>()     // Catch:{ Exception -> 0x01dc, all -> 0x01d9 }
            java.lang.String r11 = "installAnimojiSticker, parse name fail, use uuid instead! entryName: "
            r10.append(r11)     // Catch:{ Exception -> 0x01dc, all -> 0x01d9 }
            r10.append(r8)     // Catch:{ Exception -> 0x01dc, all -> 0x01d9 }
            java.lang.String r8 = ", fileName: "
            r10.append(r8)     // Catch:{ Exception -> 0x01dc, all -> 0x01d9 }
            r10.append(r9)     // Catch:{ Exception -> 0x01dc, all -> 0x01d9 }
            java.lang.String r8 = r10.toString()     // Catch:{ Exception -> 0x01dc, all -> 0x01d9 }
            com.oppo.camera.e.d(r3, r8)     // Catch:{ Exception -> 0x01dc, all -> 0x01d9 }
        L_0x0108:
            java.lang.String r8 = com.oppo.camera.sticker.c.b.j     // Catch:{ Exception -> 0x01dc, all -> 0x01d9 }
            java.lang.String r8 = com.oppo.camera.sticker.c.b.a(r12, r8, r9)     // Catch:{ Exception -> 0x01dc, all -> 0x01d9 }
            java.io.InputStream r9 = r15.getInputStream(r7)     // Catch:{ Exception -> 0x01dc, all -> 0x01d9 }
            boolean r9 = com.oppo.camera.sticker.c.b.a(r9, r8, r6, r6)     // Catch:{ Exception -> 0x01dc, all -> 0x01d9 }
            if (r9 == 0) goto L_0x011d
            r4.add(r8)     // Catch:{ Exception -> 0x01dc, all -> 0x01d9 }
            goto L_0x008c
        L_0x011d:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01dc, all -> 0x01d9 }
            r8.<init>()     // Catch:{ Exception -> 0x01dc, all -> 0x01d9 }
            java.lang.String r9 = "installAnimojiSticker, save zip entry fail! entry: "
            r8.append(r9)     // Catch:{ Exception -> 0x01dc, all -> 0x01d9 }
            r8.append(r7)     // Catch:{ Exception -> 0x01dc, all -> 0x01d9 }
            java.lang.String r7 = r8.toString()     // Catch:{ Exception -> 0x01dc, all -> 0x01d9 }
            com.oppo.camera.e.d(r3, r7)     // Catch:{ Exception -> 0x01dc, all -> 0x01d9 }
            goto L_0x008c
        L_0x0133:
            r5 = r1
            r1 = r15
        L_0x0135:
            boolean r15 = r4.isEmpty()     // Catch:{ Exception -> 0x01e1 }
            if (r15 == 0) goto L_0x0163
            java.lang.String r12 = "installAnimojiSticker can not find any zip file!"
            com.oppo.camera.e.d(r3, r12)     // Catch:{ Exception -> 0x01e1 }
            if (r1 == 0) goto L_0x0159
            r1.close()     // Catch:{ IOException -> 0x0146 }
            goto L_0x0159
        L_0x0146:
            r12 = move-exception
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            r15.<init>()
            r15.append(r0)
            r15.append(r12)
            java.lang.String r12 = r15.toString()
            com.oppo.camera.e.d(r3, r12)
        L_0x0159:
            boolean r12 = r13.isBuildIn()
            if (r12 != 0) goto L_0x0162
            com.oppo.camera.sticker.c.b.b(r14)
        L_0x0162:
            return r2
        L_0x0163:
            java.lang.String r15 = "com.oppo.camera.providers.sticker.file.provider"
            java.io.File r6 = new java.io.File     // Catch:{ Exception -> 0x01e1 }
            java.lang.Object r7 = r4.get(r2)     // Catch:{ Exception -> 0x01e1 }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ Exception -> 0x01e1 }
            r6.<init>(r7)     // Catch:{ Exception -> 0x01e1 }
            android.net.Uri r15 = com.oppo.camera.sticker.provider.FileProvider.a(r12, r15, r6)     // Catch:{ Exception -> 0x01e1 }
            java.lang.String r15 = r15.toString()     // Catch:{ Exception -> 0x01e1 }
            r13.setFileContentUri(r15)     // Catch:{ Exception -> 0x01e1 }
            java.lang.Object r15 = r4.get(r2)     // Catch:{ Exception -> 0x01e1 }
            java.lang.String r15 = (java.lang.String) r15     // Catch:{ Exception -> 0x01e1 }
            r13.setFilePath(r15)     // Catch:{ Exception -> 0x01e1 }
            r15 = 8
            r13.setDownloadState(r15)     // Catch:{ Exception -> 0x01e1 }
            r13.setNeedUpdate(r2)     // Catch:{ Exception -> 0x01e1 }
            boolean r15 = r13.isBuildIn()     // Catch:{ Exception -> 0x01e1 }
            if (r15 != 0) goto L_0x01a3
            long r6 = r13.getDownloadTime()     // Catch:{ Exception -> 0x01e1 }
            r8 = 0
            int r15 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r15 != 0) goto L_0x01a3
            long r6 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x01e1 }
            r13.setDownloadTime(r6)     // Catch:{ Exception -> 0x01e1 }
        L_0x01a3:
            java.lang.String r15 = r13.getStickerUUID()     // Catch:{ Exception -> 0x01e1 }
            boolean r15 = com.oppo.camera.sticker.a.b.a((android.content.Context) r12, (java.lang.String) r15, (com.oppo.camera.sticker.data.AnimojiStickerExtendedInfo) r5)     // Catch:{ Exception -> 0x01e1 }
            if (r15 != 0) goto L_0x01b2
            java.lang.String r15 = "installAnimojiSticker update extend info fail!"
            com.oppo.camera.e.d(r3, r15)     // Catch:{ Exception -> 0x01e1 }
        L_0x01b2:
            boolean r12 = com.oppo.camera.sticker.a.b.a((android.content.Context) r12, (com.oppo.camera.sticker.data.StickerItemWrapper) r13)     // Catch:{ Exception -> 0x01e1 }
            if (r1 == 0) goto L_0x01cf
            r1.close()     // Catch:{ IOException -> 0x01bc }
            goto L_0x01cf
        L_0x01bc:
            r15 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            r1.append(r15)
            java.lang.String r15 = r1.toString()
            com.oppo.camera.e.d(r3, r15)
        L_0x01cf:
            boolean r13 = r13.isBuildIn()
            if (r13 != 0) goto L_0x01d8
            com.oppo.camera.sticker.c.b.b(r14)
        L_0x01d8:
            return r12
        L_0x01d9:
            r12 = move-exception
            r1 = r15
            goto L_0x0208
        L_0x01dc:
            r12 = move-exception
            r1 = r15
            goto L_0x01e2
        L_0x01df:
            r12 = move-exception
            goto L_0x0208
        L_0x01e1:
            r12 = move-exception
        L_0x01e2:
            r12.printStackTrace()     // Catch:{ all -> 0x01df }
            if (r1 == 0) goto L_0x01fe
            r1.close()     // Catch:{ IOException -> 0x01eb }
            goto L_0x01fe
        L_0x01eb:
            r12 = move-exception
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            r15.<init>()
            r15.append(r0)
            r15.append(r12)
            java.lang.String r12 = r15.toString()
            com.oppo.camera.e.d(r3, r12)
        L_0x01fe:
            boolean r12 = r13.isBuildIn()
            if (r12 != 0) goto L_0x0207
            com.oppo.camera.sticker.c.b.b(r14)
        L_0x0207:
            return r2
        L_0x0208:
            if (r1 == 0) goto L_0x0221
            r1.close()     // Catch:{ IOException -> 0x020e }
            goto L_0x0221
        L_0x020e:
            r15 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            r1.append(r15)
            java.lang.String r15 = r1.toString()
            com.oppo.camera.e.d(r3, r15)
        L_0x0221:
            boolean r13 = r13.isBuildIn()
            if (r13 != 0) goto L_0x022a
            com.oppo.camera.sticker.c.b.b(r14)
        L_0x022a:
            throw r12
        L_0x022b:
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            java.lang.String r14 = "installAnimojiSticker, null parameter! context: "
            r13.append(r14)
            r13.append(r12)
            java.lang.String r12 = r13.toString()
            com.oppo.camera.e.d(r3, r12)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.sticker.download.c.a(android.content.Context, com.oppo.camera.sticker.data.StickerItemWrapper, java.lang.String, java.lang.String):boolean");
    }

    private static AnimojiStickerExtendedInfo a(String str) {
        if (TextUtils.isEmpty(str)) {
            e.d("StickerInstaller", "parserAniMojiExtendInfo empty content");
            return null;
        }
        try {
            return (AnimojiStickerExtendedInfo) new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create().fromJson(str, AnimojiStickerExtendedInfo.class);
        } catch (Exception e) {
            e.d("StickerInstaller", "parserAniMojiExtendInfo exception: " + e);
            return null;
        }
    }

    private static List<MultiStickerExtendedInfo> b(String str) {
        if (TextUtils.isEmpty(str)) {
            e.d("StickerInstaller", "parserMultiStickerExtendInfo empty content");
            return null;
        }
        try {
            return (List) new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create().fromJson(str, new TypeToken<List<MultiStickerExtendedInfo>>() {
            }.getType());
        } catch (Exception e) {
            e.d("StickerInstaller", "parserMultiStickerExtendInfo exception: " + e);
            return null;
        }
    }

    private static List<ZipEntry> a(ZipFile zipFile) {
        ArrayList arrayList = new ArrayList();
        Enumeration<? extends ZipEntry> entries = zipFile.entries();
        while (entries.hasMoreElements()) {
            ZipEntry zipEntry = (ZipEntry) entries.nextElement();
            if (!zipEntry.isDirectory()) {
                arrayList.add(zipEntry);
            }
        }
        Collections.sort(arrayList, new Comparator<ZipEntry>() {
            /* renamed from: a */
            public int compare(ZipEntry zipEntry, ZipEntry zipEntry2) {
                int a2 = a(zipEntry.getName());
                int a3 = a(zipEntry2.getName());
                if (a2 > a3) {
                    return 1;
                }
                return a2 < a3 ? -1 : 0;
            }

            private int a(String str) {
                return str.endsWith("StickerMultiCfg.json") ? 0 : 1;
            }
        });
        return arrayList;
    }

    public static void a(Context context, List<StickerItem> list, boolean z) {
        if (list == null || list.isEmpty()) {
            e.d("StickerInstaller", "deleteSticker, list is empty!");
            return;
        }
        ContentValues contentValues = new ContentValues();
        for (StickerItem next : list) {
            if (next == null) {
                e.d("StickerInstaller", "deleteSticker, item is null!");
            } else {
                contentValues.clear();
                StickerItemWrapper a2 = com.oppo.camera.sticker.a.b.a(context, "uuid", next.getStickerUUID());
                if (a2 == null) {
                    e.d("StickerInstaller", "deleteSticker, can not find this sticker! name: " + next.getStickerName() + ", uuid: " + next.getStickerUUID());
                } else {
                    e.b("StickerInstaller", "deleteSticker, start delete one sticker, item: " + a2);
                    if (a2.isBuildIn()) {
                        contentValues.put("download_time", 0);
                        a2.setDownloadTime(0);
                    } else {
                        int a3 = a(context, a2);
                        if (a3 == 0) {
                            contentValues.put("download_time", 0);
                            contentValues.put("need_update", 0);
                            contentValues.put("file_path", "");
                            contentValues.put("file_content_uri", "");
                            contentValues.put("download_state", 0);
                            a2.setDownloadTime(0);
                            a2.setNeedUpdate(false);
                            a2.setDownloadState(0);
                        } else {
                            e.d("StickerInstaller", "deleteSticker, delete item fail! result: " + a3 + ", name: " + a2.getStickerName() + ", uuid: " + next.getStickerUUID());
                        }
                    }
                    int a4 = com.oppo.camera.sticker.a.b.a(context, "uuid", next.getStickerUUID(), contentValues);
                    e.b("StickerInstaller", "deleteSticker, updateStickerItem count: " + a4);
                    if (z) {
                        h.a(context).d(a2);
                    }
                }
            }
        }
    }

    public static int a(Context context, StickerItemWrapper stickerItemWrapper) {
        if (context == null || stickerItemWrapper == null) {
            e.d("StickerInstaller", "deleteSticker, parameter is null! context: " + context);
            return -2;
        }
        e.b("StickerInstaller", "deleteSticker, stickerItem: " + stickerItemWrapper);
        if (stickerItemWrapper.isBuildIn()) {
            return 0;
        }
        int materialType = stickerItemWrapper.getMaterialType();
        if (materialType == 0) {
            return b(context, stickerItemWrapper);
        }
        if (materialType == 1) {
            return c(context, stickerItemWrapper);
        }
        if (materialType != 2) {
            return -1;
        }
        return d(context, stickerItemWrapper);
    }

    public static int b(Context context, StickerItemWrapper stickerItemWrapper) {
        File file;
        if (context == null || stickerItemWrapper == null) {
            return -2;
        }
        if (stickerItemWrapper.getMaterialType() != 0) {
            return -3;
        }
        String filePath = stickerItemWrapper.getFilePath();
        try {
            if (TextUtils.isEmpty(stickerItemWrapper.getFilePath())) {
                file = FileProvider.a(context, Uri.parse(stickerItemWrapper.getFileContentUri()));
            } else {
                file = new File(filePath);
            }
            if (file == null) {
                return -4;
            }
            return b.a(file) ? 0 : -5;
        } catch (Exception e) {
            e.d("StickerInstaller", "deleteNormalSticker exception: " + e);
            return -1;
        }
    }

    public static int c(Context context, StickerItemWrapper stickerItemWrapper) {
        if (context == null || stickerItemWrapper == null) {
            return -2;
        }
        boolean z = true;
        if (stickerItemWrapper.getMaterialType() != 1) {
            return -3;
        }
        List<MultiStickerExtendedInfo> c = com.oppo.camera.sticker.a.b.c(context, stickerItemWrapper);
        if (c == null || c.isEmpty()) {
            return -6;
        }
        for (MultiStickerExtendedInfo next : c) {
            z = z & b.a(context, next.getFileContentUri16x9()) & b.a(context, next.getFileContentUri4x3()) & b.a(context, next.getFileContentUri1x1());
        }
        if (z) {
            return com.oppo.camera.sticker.a.b.d(context, stickerItemWrapper) ? 0 : -7;
        }
        return -5;
    }

    public static int d(Context context, StickerItemWrapper stickerItemWrapper) {
        File file;
        if (context == null || stickerItemWrapper == null) {
            return -2;
        }
        if (stickerItemWrapper.getMaterialType() != 2) {
            return -3;
        }
        String filePath = stickerItemWrapper.getFilePath();
        try {
            if (TextUtils.isEmpty(stickerItemWrapper.getFilePath())) {
                file = FileProvider.a(context, Uri.parse(stickerItemWrapper.getFileContentUri()));
            } else {
                file = new File(filePath);
            }
            if (file == null) {
                return -4;
            }
            if (b.a(file)) {
                return com.oppo.camera.sticker.a.b.b(context, stickerItemWrapper) ? 0 : -7;
            }
            return -5;
        } catch (Exception e) {
            e.d("StickerInstaller", "deleteAnimojiSticker exception: " + e);
            return -1;
        }
    }
}
