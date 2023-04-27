package com.oppo.camera.sticker.data;

import android.content.Context;
import com.oppo.camera.e;
import com.oppo.camera.sticker.h;

/* compiled from: BuildInStickerTools */
public class a {
    public static void a(Context context) {
        e.b("BuildInStickerTools", "checkBuildInData");
        b(context);
        c(context);
        h.a(context).d();
    }

    /* JADX WARNING: Removed duplicated region for block: B:42:0x0157 A[SYNTHETIC, Splitter:B:42:0x0157] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0161 A[SYNTHETIC, Splitter:B:47:0x0161] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x016e A[SYNTHETIC, Splitter:B:54:0x016e] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0178 A[SYNTHETIC, Splitter:B:59:0x0178] */
    /* JADX WARNING: Removed duplicated region for block: B:70:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void b(android.content.Context r15) {
        /*
            java.lang.String r0 = "com.oppo.camera.providers.sticker.file.provider"
            java.lang.String r1 = "checkBuildInCategory.close reader, e: "
            java.lang.String r2 = "checkBuildInCategory.close bufferedReader, e: "
            java.lang.String r3 = "BuildInStickerTools"
            r4 = 0
            java.io.InputStreamReader r5 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x014e, all -> 0x014a }
            android.content.res.AssetManager r6 = r15.getAssets()     // Catch:{ Exception -> 0x014e, all -> 0x014a }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x014e, all -> 0x014a }
            r7.<init>()     // Catch:{ Exception -> 0x014e, all -> 0x014a }
            java.lang.String r8 = "sticker"
            r7.append(r8)     // Catch:{ Exception -> 0x014e, all -> 0x014a }
            java.lang.String r8 = java.io.File.separator     // Catch:{ Exception -> 0x014e, all -> 0x014a }
            r7.append(r8)     // Catch:{ Exception -> 0x014e, all -> 0x014a }
            java.lang.String r8 = "category.cfg"
            r7.append(r8)     // Catch:{ Exception -> 0x014e, all -> 0x014a }
            java.lang.String r7 = r7.toString()     // Catch:{ Exception -> 0x014e, all -> 0x014a }
            java.io.InputStream r6 = r6.open(r7)     // Catch:{ Exception -> 0x014e, all -> 0x014a }
            java.lang.String r7 = "UTF-8"
            r5.<init>(r6, r7)     // Catch:{ Exception -> 0x014e, all -> 0x014a }
            java.io.BufferedReader r6 = new java.io.BufferedReader     // Catch:{ Exception -> 0x0148 }
            r6.<init>(r5)     // Catch:{ Exception -> 0x0148 }
            java.lang.StringBuffer r4 = new java.lang.StringBuffer     // Catch:{ Exception -> 0x0145, all -> 0x0143 }
            r4.<init>()     // Catch:{ Exception -> 0x0145, all -> 0x0143 }
        L_0x003a:
            java.lang.String r7 = r6.readLine()     // Catch:{ Exception -> 0x0145, all -> 0x0143 }
            if (r7 == 0) goto L_0x0049
            r4.append(r7)     // Catch:{ Exception -> 0x0145, all -> 0x0143 }
            java.lang.String r7 = "\n"
            r4.append(r7)     // Catch:{ Exception -> 0x0145, all -> 0x0143 }
            goto L_0x003a
        L_0x0049:
            com.google.gson.GsonBuilder r7 = new com.google.gson.GsonBuilder     // Catch:{ Exception -> 0x0145, all -> 0x0143 }
            r7.<init>()     // Catch:{ Exception -> 0x0145, all -> 0x0143 }
            com.google.gson.GsonBuilder r7 = r7.excludeFieldsWithoutExposeAnnotation()     // Catch:{ Exception -> 0x0145, all -> 0x0143 }
            com.google.gson.Gson r7 = r7.create()     // Catch:{ Exception -> 0x0145, all -> 0x0143 }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x0145, all -> 0x0143 }
            com.oppo.camera.sticker.data.a$1 r8 = new com.oppo.camera.sticker.data.a$1     // Catch:{ Exception -> 0x0145, all -> 0x0143 }
            r8.<init>()     // Catch:{ Exception -> 0x0145, all -> 0x0143 }
            java.lang.reflect.Type r8 = r8.getType()     // Catch:{ Exception -> 0x0145, all -> 0x0143 }
            java.lang.Object r4 = r7.fromJson((java.lang.String) r4, (java.lang.reflect.Type) r8)     // Catch:{ Exception -> 0x0145, all -> 0x0143 }
            java.util.List r4 = (java.util.List) r4     // Catch:{ Exception -> 0x0145, all -> 0x0143 }
            if (r4 == 0) goto L_0x0137
            boolean r7 = r4.isEmpty()     // Catch:{ Exception -> 0x0145, all -> 0x0143 }
            if (r7 != 0) goto L_0x0137
            java.util.Iterator r4 = r4.iterator()     // Catch:{ Exception -> 0x0145, all -> 0x0143 }
        L_0x0075:
            boolean r7 = r4.hasNext()     // Catch:{ Exception -> 0x0145, all -> 0x0143 }
            if (r7 == 0) goto L_0x0137
            java.lang.Object r7 = r4.next()     // Catch:{ Exception -> 0x0145, all -> 0x0143 }
            com.oppo.camera.sticker.data.BuildInStickerCategory r7 = (com.oppo.camera.sticker.data.BuildInStickerCategory) r7     // Catch:{ Exception -> 0x0145, all -> 0x0143 }
            java.lang.String r8 = r7.getReadableId()     // Catch:{ Exception -> 0x0145, all -> 0x0143 }
            boolean r8 = com.oppo.camera.sticker.a.a.a((android.content.Context) r15, (java.lang.String) r8)     // Catch:{ Exception -> 0x0145, all -> 0x0143 }
            if (r8 != 0) goto L_0x0075
            java.lang.String r8 = r7.getIconPath()     // Catch:{ Exception -> 0x0145, all -> 0x0143 }
            java.lang.String r8 = com.oppo.camera.sticker.c.b.a((java.lang.String) r8)     // Catch:{ Exception -> 0x0145, all -> 0x0143 }
            java.lang.String r9 = r7.getIconHighlightPath()     // Catch:{ Exception -> 0x0145, all -> 0x0143 }
            java.lang.String r9 = com.oppo.camera.sticker.c.b.a((java.lang.String) r9)     // Catch:{ Exception -> 0x0145, all -> 0x0143 }
            java.lang.String r10 = com.oppo.camera.sticker.c.b.g     // Catch:{ Exception -> 0x0145, all -> 0x0143 }
            java.lang.String r8 = com.oppo.camera.sticker.c.b.a(r15, r10, r8)     // Catch:{ Exception -> 0x0145, all -> 0x0143 }
            java.lang.String r10 = com.oppo.camera.sticker.c.b.g     // Catch:{ Exception -> 0x0145, all -> 0x0143 }
            java.lang.String r9 = com.oppo.camera.sticker.c.b.a(r15, r10, r9)     // Catch:{ Exception -> 0x0145, all -> 0x0143 }
            android.content.res.AssetManager r10 = r15.getAssets()     // Catch:{ Exception -> 0x0145, all -> 0x0143 }
            java.lang.String r11 = r7.getIconPath()     // Catch:{ Exception -> 0x0145, all -> 0x0143 }
            java.io.InputStream r10 = r10.open(r11)     // Catch:{ Exception -> 0x0145, all -> 0x0143 }
            r11 = 1
            r12 = 0
            boolean r10 = com.oppo.camera.sticker.c.b.a(r10, r8, r12, r11)     // Catch:{ Exception -> 0x0145, all -> 0x0143 }
            android.content.res.AssetManager r13 = r15.getAssets()     // Catch:{ Exception -> 0x0145, all -> 0x0143 }
            java.lang.String r14 = r7.getIconHighlightPath()     // Catch:{ Exception -> 0x0145, all -> 0x0143 }
            java.io.InputStream r13 = r13.open(r14)     // Catch:{ Exception -> 0x0145, all -> 0x0143 }
            boolean r11 = com.oppo.camera.sticker.c.b.a(r13, r9, r12, r11)     // Catch:{ Exception -> 0x0145, all -> 0x0143 }
            if (r10 == 0) goto L_0x0119
            if (r11 == 0) goto L_0x0119
            java.io.File r10 = new java.io.File     // Catch:{ Exception -> 0x0145, all -> 0x0143 }
            r10.<init>(r8)     // Catch:{ Exception -> 0x0145, all -> 0x0143 }
            android.net.Uri r10 = com.oppo.camera.sticker.provider.FileProvider.a(r15, r0, r10)     // Catch:{ Exception -> 0x0145, all -> 0x0143 }
            java.io.File r11 = new java.io.File     // Catch:{ Exception -> 0x0145, all -> 0x0143 }
            r11.<init>(r9)     // Catch:{ Exception -> 0x0145, all -> 0x0143 }
            android.net.Uri r11 = com.oppo.camera.sticker.provider.FileProvider.a(r15, r0, r11)     // Catch:{ Exception -> 0x0145, all -> 0x0143 }
            com.oppo.camera.sticker.data.StickerCategoryItemWrapper r7 = r7.obtainStickerCategoryItem()     // Catch:{ Exception -> 0x0145, all -> 0x0143 }
            r7.setIconPath(r8)     // Catch:{ Exception -> 0x0145, all -> 0x0143 }
            java.lang.String r8 = r10.toString()     // Catch:{ Exception -> 0x0145, all -> 0x0143 }
            r7.setIconFileUri(r8)     // Catch:{ Exception -> 0x0145, all -> 0x0143 }
            r7.setIconHighlightPath(r9)     // Catch:{ Exception -> 0x0145, all -> 0x0143 }
            java.lang.String r8 = r11.toString()     // Catch:{ Exception -> 0x0145, all -> 0x0143 }
            r7.setIconHighlightFileUri(r8)     // Catch:{ Exception -> 0x0145, all -> 0x0143 }
            boolean r8 = com.oppo.camera.sticker.a.a.a((android.content.Context) r15, (com.oppo.camera.sticker.data.StickerCategoryItemWrapper) r7)     // Catch:{ Exception -> 0x0145, all -> 0x0143 }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0145, all -> 0x0143 }
            r9.<init>()     // Catch:{ Exception -> 0x0145, all -> 0x0143 }
            java.lang.String r10 = "checkBuildInCategory result: "
            r9.append(r10)     // Catch:{ Exception -> 0x0145, all -> 0x0143 }
            r9.append(r8)     // Catch:{ Exception -> 0x0145, all -> 0x0143 }
            java.lang.String r8 = ", newItem: "
            r9.append(r8)     // Catch:{ Exception -> 0x0145, all -> 0x0143 }
            r9.append(r7)     // Catch:{ Exception -> 0x0145, all -> 0x0143 }
            java.lang.String r7 = r9.toString()     // Catch:{ Exception -> 0x0145, all -> 0x0143 }
            com.oppo.camera.e.b(r3, r7)     // Catch:{ Exception -> 0x0145, all -> 0x0143 }
            goto L_0x0075
        L_0x0119:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0145, all -> 0x0143 }
            r7.<init>()     // Catch:{ Exception -> 0x0145, all -> 0x0143 }
            java.lang.String r8 = "checkBuildInCategory, save category fail! saveIcon: "
            r7.append(r8)     // Catch:{ Exception -> 0x0145, all -> 0x0143 }
            r7.append(r10)     // Catch:{ Exception -> 0x0145, all -> 0x0143 }
            java.lang.String r8 = ", saveIconHighlight: "
            r7.append(r8)     // Catch:{ Exception -> 0x0145, all -> 0x0143 }
            r7.append(r11)     // Catch:{ Exception -> 0x0145, all -> 0x0143 }
            java.lang.String r7 = r7.toString()     // Catch:{ Exception -> 0x0145, all -> 0x0143 }
            com.oppo.camera.e.d(r3, r7)     // Catch:{ Exception -> 0x0145, all -> 0x0143 }
            goto L_0x0075
        L_0x0137:
            r6.close()     // Catch:{ IOException -> 0x013b }
            goto L_0x013f
        L_0x013b:
            r15 = move-exception
            com.oppo.camera.e.c(r3, r2, r15)
        L_0x013f:
            r5.close()     // Catch:{ Exception -> 0x0165 }
            goto L_0x0169
        L_0x0143:
            r15 = move-exception
            goto L_0x016c
        L_0x0145:
            r15 = move-exception
            r4 = r6
            goto L_0x0150
        L_0x0148:
            r15 = move-exception
            goto L_0x0150
        L_0x014a:
            r15 = move-exception
            r5 = r4
            r6 = r5
            goto L_0x016c
        L_0x014e:
            r15 = move-exception
            r5 = r4
        L_0x0150:
            java.lang.String r0 = "checkBuildInCategory, e:"
            com.oppo.camera.e.c(r3, r0, r15)     // Catch:{ all -> 0x016a }
            if (r4 == 0) goto L_0x015f
            r4.close()     // Catch:{ IOException -> 0x015b }
            goto L_0x015f
        L_0x015b:
            r15 = move-exception
            com.oppo.camera.e.c(r3, r2, r15)
        L_0x015f:
            if (r5 == 0) goto L_0x0169
            r5.close()     // Catch:{ Exception -> 0x0165 }
            goto L_0x0169
        L_0x0165:
            r15 = move-exception
            com.oppo.camera.e.c(r3, r1, r15)
        L_0x0169:
            return
        L_0x016a:
            r15 = move-exception
            r6 = r4
        L_0x016c:
            if (r6 == 0) goto L_0x0176
            r6.close()     // Catch:{ IOException -> 0x0172 }
            goto L_0x0176
        L_0x0172:
            r0 = move-exception
            com.oppo.camera.e.c(r3, r2, r0)
        L_0x0176:
            if (r5 == 0) goto L_0x0180
            r5.close()     // Catch:{ Exception -> 0x017c }
            goto L_0x0180
        L_0x017c:
            r0 = move-exception
            com.oppo.camera.e.c(r3, r1, r0)
        L_0x0180:
            throw r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.sticker.data.a.b(android.content.Context):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00c0, code lost:
        r9 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00c2, code lost:
        r9 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00c3, code lost:
        r3 = r5;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00c0 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:5:0x0033] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00d4 A[SYNTHETIC, Splitter:B:43:0x00d4] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00de A[SYNTHETIC, Splitter:B:48:0x00de] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00eb A[SYNTHETIC, Splitter:B:55:0x00eb] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00f5 A[SYNTHETIC, Splitter:B:60:0x00f5] */
    /* JADX WARNING: Removed duplicated region for block: B:71:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void c(android.content.Context r9) {
        /*
            java.lang.String r0 = "checkBuildInSticker.close reader, e: "
            java.lang.String r1 = "checkBuildInSticker.close bufferedReader, e: "
            java.lang.String r2 = "BuildInStickerTools"
            r3 = 0
            java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x00cb, all -> 0x00c7 }
            android.content.res.AssetManager r5 = r9.getAssets()     // Catch:{ Exception -> 0x00cb, all -> 0x00c7 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00cb, all -> 0x00c7 }
            r6.<init>()     // Catch:{ Exception -> 0x00cb, all -> 0x00c7 }
            java.lang.String r7 = "sticker"
            r6.append(r7)     // Catch:{ Exception -> 0x00cb, all -> 0x00c7 }
            java.lang.String r7 = java.io.File.separator     // Catch:{ Exception -> 0x00cb, all -> 0x00c7 }
            r6.append(r7)     // Catch:{ Exception -> 0x00cb, all -> 0x00c7 }
            java.lang.String r7 = "sticker.cfg"
            r6.append(r7)     // Catch:{ Exception -> 0x00cb, all -> 0x00c7 }
            java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x00cb, all -> 0x00c7 }
            java.io.InputStream r5 = r5.open(r6)     // Catch:{ Exception -> 0x00cb, all -> 0x00c7 }
            java.lang.String r6 = "UTF-8"
            r4.<init>(r5, r6)     // Catch:{ Exception -> 0x00cb, all -> 0x00c7 }
            java.io.BufferedReader r5 = new java.io.BufferedReader     // Catch:{ Exception -> 0x00c5 }
            r5.<init>(r4)     // Catch:{ Exception -> 0x00c5 }
            java.lang.StringBuffer r3 = new java.lang.StringBuffer     // Catch:{ Exception -> 0x00c2, all -> 0x00c0 }
            r3.<init>()     // Catch:{ Exception -> 0x00c2, all -> 0x00c0 }
        L_0x0038:
            java.lang.String r6 = r5.readLine()     // Catch:{ Exception -> 0x00c2, all -> 0x00c0 }
            if (r6 == 0) goto L_0x0047
            r3.append(r6)     // Catch:{ Exception -> 0x00c2, all -> 0x00c0 }
            java.lang.String r6 = "\n"
            r3.append(r6)     // Catch:{ Exception -> 0x00c2, all -> 0x00c0 }
            goto L_0x0038
        L_0x0047:
            com.google.gson.GsonBuilder r6 = new com.google.gson.GsonBuilder     // Catch:{ Exception -> 0x00c2, all -> 0x00c0 }
            r6.<init>()     // Catch:{ Exception -> 0x00c2, all -> 0x00c0 }
            com.google.gson.GsonBuilder r6 = r6.excludeFieldsWithoutExposeAnnotation()     // Catch:{ Exception -> 0x00c2, all -> 0x00c0 }
            com.google.gson.Gson r6 = r6.create()     // Catch:{ Exception -> 0x00c2, all -> 0x00c0 }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x00c2, all -> 0x00c0 }
            com.oppo.camera.sticker.data.a$2 r7 = new com.oppo.camera.sticker.data.a$2     // Catch:{ Exception -> 0x00c2, all -> 0x00c0 }
            r7.<init>()     // Catch:{ Exception -> 0x00c2, all -> 0x00c0 }
            java.lang.reflect.Type r7 = r7.getType()     // Catch:{ Exception -> 0x00c2, all -> 0x00c0 }
            java.lang.Object r3 = r6.fromJson((java.lang.String) r3, (java.lang.reflect.Type) r7)     // Catch:{ Exception -> 0x00c2, all -> 0x00c0 }
            java.util.List r3 = (java.util.List) r3     // Catch:{ Exception -> 0x00c2, all -> 0x00c0 }
            if (r3 == 0) goto L_0x00b4
            boolean r6 = r3.isEmpty()     // Catch:{ Exception -> 0x00c2, all -> 0x00c0 }
            if (r6 != 0) goto L_0x00b4
            java.util.Iterator r3 = r3.iterator()     // Catch:{ Exception -> 0x00c2, all -> 0x00c0 }
        L_0x0073:
            boolean r6 = r3.hasNext()     // Catch:{ Exception -> 0x00c2, all -> 0x00c0 }
            if (r6 == 0) goto L_0x00b4
            java.lang.Object r6 = r3.next()     // Catch:{ Exception -> 0x00c2, all -> 0x00c0 }
            com.oppo.camera.sticker.data.BuildInSticker r6 = (com.oppo.camera.sticker.data.BuildInSticker) r6     // Catch:{ Exception -> 0x00c2, all -> 0x00c0 }
            boolean r7 = com.oppo.camera.sticker.a.b.a((android.content.Context) r9, (com.oppo.camera.sticker.data.BuildInSticker) r6)     // Catch:{ Exception -> 0x009e, all -> 0x00c0 }
            if (r7 == 0) goto L_0x0073
            boolean r6 = com.oppo.camera.sticker.download.c.a((android.content.Context) r9, (com.oppo.camera.sticker.data.BuildInSticker) r6)     // Catch:{ Exception -> 0x009e, all -> 0x00c0 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x009e, all -> 0x00c0 }
            r7.<init>()     // Catch:{ Exception -> 0x009e, all -> 0x00c0 }
            java.lang.String r8 = "checkBuildInSticker, result: "
            r7.append(r8)     // Catch:{ Exception -> 0x009e, all -> 0x00c0 }
            r7.append(r6)     // Catch:{ Exception -> 0x009e, all -> 0x00c0 }
            java.lang.String r6 = r7.toString()     // Catch:{ Exception -> 0x009e, all -> 0x00c0 }
            com.oppo.camera.e.b(r2, r6)     // Catch:{ Exception -> 0x009e, all -> 0x00c0 }
            goto L_0x0073
        L_0x009e:
            r6 = move-exception
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00c2, all -> 0x00c0 }
            r7.<init>()     // Catch:{ Exception -> 0x00c2, all -> 0x00c0 }
            java.lang.String r8 = "checkBuildInSticker, Exception e: "
            r7.append(r8)     // Catch:{ Exception -> 0x00c2, all -> 0x00c0 }
            r7.append(r6)     // Catch:{ Exception -> 0x00c2, all -> 0x00c0 }
            java.lang.String r6 = r7.toString()     // Catch:{ Exception -> 0x00c2, all -> 0x00c0 }
            com.oppo.camera.e.d(r2, r6)     // Catch:{ Exception -> 0x00c2, all -> 0x00c0 }
            goto L_0x0073
        L_0x00b4:
            r5.close()     // Catch:{ IOException -> 0x00b8 }
            goto L_0x00bc
        L_0x00b8:
            r9 = move-exception
            com.oppo.camera.e.c(r2, r1, r9)
        L_0x00bc:
            r4.close()     // Catch:{ Exception -> 0x00e2 }
            goto L_0x00e6
        L_0x00c0:
            r9 = move-exception
            goto L_0x00e9
        L_0x00c2:
            r9 = move-exception
            r3 = r5
            goto L_0x00cd
        L_0x00c5:
            r9 = move-exception
            goto L_0x00cd
        L_0x00c7:
            r9 = move-exception
            r4 = r3
            r5 = r4
            goto L_0x00e9
        L_0x00cb:
            r9 = move-exception
            r4 = r3
        L_0x00cd:
            java.lang.String r5 = "checkBuildInSticker, e:"
            com.oppo.camera.e.c(r2, r5, r9)     // Catch:{ all -> 0x00e7 }
            if (r3 == 0) goto L_0x00dc
            r3.close()     // Catch:{ IOException -> 0x00d8 }
            goto L_0x00dc
        L_0x00d8:
            r9 = move-exception
            com.oppo.camera.e.c(r2, r1, r9)
        L_0x00dc:
            if (r4 == 0) goto L_0x00e6
            r4.close()     // Catch:{ Exception -> 0x00e2 }
            goto L_0x00e6
        L_0x00e2:
            r9 = move-exception
            com.oppo.camera.e.c(r2, r0, r9)
        L_0x00e6:
            return
        L_0x00e7:
            r9 = move-exception
            r5 = r3
        L_0x00e9:
            if (r5 == 0) goto L_0x00f3
            r5.close()     // Catch:{ IOException -> 0x00ef }
            goto L_0x00f3
        L_0x00ef:
            r3 = move-exception
            com.oppo.camera.e.c(r2, r1, r3)
        L_0x00f3:
            if (r4 == 0) goto L_0x00fd
            r4.close()     // Catch:{ Exception -> 0x00f9 }
            goto L_0x00fd
        L_0x00f9:
            r1 = move-exception
            com.oppo.camera.e.c(r2, r0, r1)
        L_0x00fd:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.sticker.data.a.c(android.content.Context):void");
    }
}
