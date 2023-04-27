package com.cdv.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.media.MediaMuxer;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.os.Process;

public class NvAndroidUtils {
    private static final String TAG = "Meicam";

    public static long getSystemMemorySizeInBytes(Context context) {
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(memoryInfo);
        return memoryInfo.totalMem;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0078  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.media.MediaExtractor createMediaExtractorFromMediaFilePath(android.content.Context r8, java.lang.String r9) {
        /*
            r0 = 0
            android.media.MediaExtractor r7 = new android.media.MediaExtractor     // Catch:{ Exception -> 0x0057 }
            r7.<init>()     // Catch:{ Exception -> 0x0057 }
            java.lang.String r1 = "content://"
            boolean r1 = r9.startsWith(r1)     // Catch:{ Exception -> 0x0055 }
            if (r1 == 0) goto L_0x0027
            android.content.ContentResolver r8 = r8.getContentResolver()     // Catch:{ Exception -> 0x0055 }
            android.net.Uri r9 = android.net.Uri.parse(r9)     // Catch:{ Exception -> 0x0055 }
            java.lang.String r1 = "r"
            android.os.ParcelFileDescriptor r8 = r8.openFileDescriptor(r9, r1)     // Catch:{ Exception -> 0x0055 }
            java.io.FileDescriptor r9 = r8.getFileDescriptor()     // Catch:{ Exception -> 0x0055 }
            r7.setDataSource(r9)     // Catch:{ Exception -> 0x0055 }
            r8.close()     // Catch:{ Exception -> 0x0055 }
            goto L_0x0054
        L_0x0027:
            java.lang.String r1 = "assets:/"
            boolean r1 = r9.startsWith(r1)     // Catch:{ Exception -> 0x0055 }
            if (r1 == 0) goto L_0x0051
            android.content.res.AssetManager r8 = r8.getAssets()     // Catch:{ Exception -> 0x0055 }
            r1 = 8
            java.lang.String r9 = r9.substring(r1)     // Catch:{ Exception -> 0x0055 }
            android.content.res.AssetFileDescriptor r8 = r8.openFd(r9)     // Catch:{ Exception -> 0x0055 }
            java.io.FileDescriptor r2 = r8.getFileDescriptor()     // Catch:{ Exception -> 0x0055 }
            long r3 = r8.getStartOffset()     // Catch:{ Exception -> 0x0055 }
            long r5 = r8.getLength()     // Catch:{ Exception -> 0x0055 }
            r1 = r7
            r1.setDataSource(r2, r3, r5)     // Catch:{ Exception -> 0x0055 }
            r8.close()     // Catch:{ Exception -> 0x0055 }
            goto L_0x0054
        L_0x0051:
            r7.setDataSource(r9)     // Catch:{ Exception -> 0x0055 }
        L_0x0054:
            return r7
        L_0x0055:
            r8 = move-exception
            goto L_0x0059
        L_0x0057:
            r8 = move-exception
            r7 = r0
        L_0x0059:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r1 = ""
            r9.append(r1)
            java.lang.String r1 = r8.getMessage()
            r9.append(r1)
            java.lang.String r9 = r9.toString()
            java.lang.String r1 = "Meicam"
            android.util.Log.e(r1, r9)
            r8.printStackTrace()
            if (r7 == 0) goto L_0x007b
            r7.release()
        L_0x007b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cdv.utils.NvAndroidUtils.createMediaExtractorFromMediaFilePath(android.content.Context, java.lang.String):android.media.MediaExtractor");
    }

    public static MediaMuxer createMediaMuxerFromContentUrl(Context context, String str) {
        if (Build.VERSION.SDK_INT < 26) {
            return null;
        }
        try {
            ParcelFileDescriptor openFileDescriptor = context.getContentResolver().openFileDescriptor(Uri.parse(str), "rwt");
            MediaMuxer mediaMuxer = new MediaMuxer(openFileDescriptor.getFileDescriptor(), 0);
            openFileDescriptor.close();
            return mediaMuxer;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static int openFdForContentUrl(Context context, String str, String str2) {
        try {
            return context.getContentResolver().openFileDescriptor(Uri.parse(str), str2).detachFd();
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static String getMimeTypeFromContentUrl(Context context, String str) {
        try {
            return context.getContentResolver().getType(Uri.parse(str));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void setThreadPriority() {
        Process.setThreadPriority(-2);
    }
}
