package com.oppo.camera;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.location.Location;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Environment;
import android.os.StatFs;
import android.os.storage.StorageManager;
import android.os.storage.StorageVolume;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Size;
import com.android.providers.downloads.Downloads;
import com.oplus.os.OplusUsbEnvironment;
import com.oppo.camera.a.d;
import com.oppo.camera.aps.adapter.ApsExifData;
import com.oppo.camera.aps.constant.ApsConstant;
import com.oppo.camera.e.g;
import com.oppo.camera.f.d;
import com.oppo.camera.statistics.CameraStatisticsUtil;
import com.oppo.camera.ui.control.e;
import com.oppo.camera.util.Util;
import com.oppo.camera.w.b;
import com.oppo.exif.OppoExifInterface;
import com.oppo.exif.OppoExifTag;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.TimeZone;

/* compiled from: Storage */
public class z implements d {
    private static boolean A = false;
    public static final String d = Environment.DIRECTORY_DCIM;
    public static final String e = (d + File.separator + "Camera" + File.separator);
    public static String f = null;
    public static String g = null;
    public static String h = null;
    public static String i = null;
    public static String j = null;
    public static String k = null;
    public static String l = null;
    public static String m = null;
    public static String n = null;
    public static String o = null;
    public static String p = null;
    public static String q = null;
    public static String r = "uninitied";
    public static int s = 0;
    public static int t = 0;
    public static boolean u = false;
    public static boolean v = false;
    private static final String w = ("image/" + ".jpeg".substring(1));
    private static final Uri x = Uri.parse("content://com.oppo.gallery3d.open.provider").buildUpon().appendPath("fast_captures").build();
    private static Context y;
    private static String z = null;

    public static void a(Context context) {
        e.b("Storage", "initializeStoragePath()");
        b(context);
        c(context);
        l = OplusUsbEnvironment.getInternalSdDirectory(context).getAbsolutePath() + File.separator + context.getResources().getString(R.string.camera_image_bucket_name);
        n = OplusUsbEnvironment.getInternalSdDirectory(context).getAbsolutePath() + File.separator + context.getResources().getString(R.string.camera_video_bucket_name);
        p = Util.x(context).getAbsolutePath();
        if (A) {
            q = context.getCacheDir().getAbsolutePath() + File.separator + context.getResources().getString(R.string.camera_thumbnail_bucket_name);
        } else {
            q = OplusUsbEnvironment.getInternalSdDirectory(context).getAbsolutePath() + File.separator + context.getResources().getString(R.string.camera_post_bucket_name);
        }
        k = b.a(l);
        m = b.a(n);
        o = b.a(p);
        y = context;
        v = g() <= 8.0d;
    }

    public static void b(Context context) {
        File externalSdDirectory = OplusUsbEnvironment.getExternalSdDirectory(context);
        if (externalSdDirectory != null) {
            String absolutePath = externalSdDirectory.getAbsolutePath();
            e.b("Storage", "initializeExternalSdBucketName, externalSdPath: " + absolutePath);
            String str = g;
            if (str == null || !str.startsWith(absolutePath)) {
                g = externalSdDirectory.getAbsolutePath() + File.separator + context.getResources().getString(R.string.camera_image_bucket_name);
                i = externalSdDirectory.getAbsolutePath() + File.separator + context.getResources().getString(R.string.camera_video_bucket_name);
                f = b.a(g);
                h = b.a(i);
            }
        }
    }

    public static void c(Context context) {
        boolean z2 = false;
        List<ResolveInfo> queryIntentActivities = context.getApplicationContext().getPackageManager().queryIntentActivities(new Intent("com.coloros.gallery3d.action.fastcapture.sandbox"), 0);
        if (queryIntentActivities != null && queryIntentActivities.size() > 0) {
            z2 = true;
        }
        A = z2;
    }

    public static a a(a aVar) {
        String str;
        String str2;
        String str3;
        a aVar2 = aVar;
        e.b("Storage", "addImage, " + aVar2);
        Uri uri = null;
        if (aVar2.p > -1 && -1 == aVar2.o) {
            return null;
        }
        String a2 = aVar2.h != null ? aVar2.h : Util.a(aVar2.n);
        if ("off".equals(r)) {
            str = l;
        } else {
            str = g;
        }
        if (aVar2.j == null || "jpeg".equalsIgnoreCase(aVar2.j)) {
            str2 = ".jpg";
        } else if ("raw".equalsIgnoreCase(aVar2.j)) {
            str2 = ".dng";
        } else if (!"heic_8bits".equalsIgnoreCase(aVar2.j) && !"heic_10bits".equalsIgnoreCase(aVar2.j)) {
            return null;
        } else {
            str2 = ".heic";
        }
        if (aVar2.o > -1) {
            str3 = aVar2.m + File.separator + a2 + str2;
            a(aVar2.m);
        } else {
            str3 = str + File.separator + a2 + str2;
        }
        if ("raw".equalsIgnoreCase(aVar2.j)) {
            z = a2;
        } else if (z != null) {
            str3 = str + File.separator + z + str2;
            z = null;
        }
        if (!"raw".equalsIgnoreCase(aVar2.j) || !aVar2.k.equals(ApsConstant.CAPTURE_MODE_NIGHT)) {
            ContentValues contentValues = new ContentValues(12);
            contentValues.put(Downloads.Impl.COLUMN_TITLE, a2);
            contentValues.put("_display_name", a2 + str2);
            contentValues.put("datetaken", Long.valueOf(aVar2.n));
            if ("raw".equals(aVar2.j)) {
                contentValues.put("mime_type", com.oppo.camera.q.a.f);
            } else if ("jpeg".equals(aVar2.j)) {
                contentValues.put("mime_type", com.oppo.camera.q.a.c);
            } else if ("heic_8bits".equals(aVar2.j) || "heic_10bits".equals(aVar2.j)) {
                contentValues.put("mime_type", com.oppo.camera.q.a.e);
                contentValues.put(Downloads.Impl._DATA, str3);
            }
            contentValues.put(CameraStatisticsUtil.PORTRAIT_ORIENTATION, Integer.valueOf(aVar2.v));
            contentValues.put("_size", Integer.valueOf((int) new File(str3).length()));
            contentValues.put("relative_path", d(aVar));
            boolean z2 = false;
            try {
                uri = aVar2.f3177a.insert(c("on".equals(r) && d()), contentValues);
                com.oppo.camera.perf.a.b("picture_save");
                e.a("Storage", "addImage, insertImage, uri: " + uri);
                if (aVar2.E) {
                    if ("heic_8bits".equalsIgnoreCase(aVar2.j)) {
                        a(true, aVar2, uri);
                    } else if ("heic_10bits".equalsIgnoreCase(aVar2.j)) {
                        a(false, aVar2, uri);
                    } else if (aVar2.e != null) {
                        a(uri, aVar2);
                    }
                } else if (!"heic_8bits".equalsIgnoreCase(aVar2.j) && !"heic_10bits".equalsIgnoreCase(aVar2.j)) {
                    e.b("Storage", "addImage, path: " + str3);
                    a(uri, aVar2.f3177a, aVar2.e);
                    b(uri, aVar2);
                }
                if (aVar2.F && aVar2.o == -1) {
                    a(uri, Util.f().getContentResolver());
                    if (aVar2.V != null) {
                        aVar2.V.a();
                    }
                }
            } catch (Throwable th) {
                e.d("Storage", "Failed to write MediaStore.", th);
            }
            aVar2.c = uri;
            aVar2.i = str3;
            aVar2.C = true;
            if (".jpg".equals(str2) && (aVar2.p == -1 || aVar2.p == 1)) {
                z2 = true;
            }
            aVar2.D = z2;
            return aVar2;
        }
        e.a("Storage", "addImage, nightNode Raw return");
        return null;
    }

    private static OppoExifInterface e(a aVar) {
        OppoExifInterface oppoExifInterface = new OppoExifInterface();
        try {
            oppoExifInterface.readExif(aVar.e);
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        oppoExifInterface.setTag(oppoExifInterface.buildTag(OppoExifInterface.TAG_USER_COMMENT, OppoExifTag.EXIF_TAG_PREFIX.concat(String.valueOf(com.oppo.camera.h.b.a(aVar.k, aVar.u)))));
        oppoExifInterface.setTag(oppoExifInterface.buildTag(OppoExifInterface.TAG_ORIENTATION, Integer.valueOf(aVar.v)));
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss", Locale.US);
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy:MM:dd", Locale.US);
        simpleDateFormat2.setTimeZone(TimeZone.getTimeZone("UTC"));
        simpleDateFormat.setTimeZone(Calendar.getInstance().getTimeZone());
        oppoExifInterface.setTag(oppoExifInterface.buildTag(OppoExifInterface.TAG_DATE_TIME, simpleDateFormat.format(Long.valueOf(aVar.n))));
        oppoExifInterface.setTag(oppoExifInterface.buildTag(OppoExifInterface.TAG_DATE_TIME_ORIGINAL, simpleDateFormat.format(Long.valueOf(aVar.n))));
        ZonedDateTime ofInstant = ZonedDateTime.ofInstant(Instant.ofEpochMilli(aVar.n), ZoneId.systemDefault());
        oppoExifInterface.setTag(oppoExifInterface.buildTag(OppoExifInterface.TAG_SUB_SEC_TIME_ORIGINAL, DateTimeFormatter.ofPattern("SSS").format(ofInstant)));
        oppoExifInterface.setTag(oppoExifInterface.buildTag(OppoExifInterface.TAG_OFFSET_TIME_ORIGINAL, 2, DateTimeFormatter.ofPattern("XXX").format(ofInstant)));
        oppoExifInterface.addGpsDateTimeStampTag(aVar.n);
        oppoExifInterface.setTag(oppoExifInterface.buildTag(OppoExifInterface.TAG_GPS_DATE_STAMP, simpleDateFormat2.format(Long.valueOf(aVar.n))));
        if (aVar.d != null) {
            oppoExifInterface.addGpsTags(aVar.d.getLatitude(), aVar.d.getLongitude());
        }
        return oppoExifInterface;
    }

    private static void a(Uri uri, a aVar) {
        OppoExifInterface e2 = e(aVar);
        OutputStream outputStream = null;
        try {
            OutputStream openOutputStream = aVar.f3177a.openOutputStream(uri);
            if (openOutputStream != null) {
                e2.writeExif(aVar.e, openOutputStream);
            }
            if (openOutputStream != null) {
                try {
                    openOutputStream.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
            }
        } catch (IOException e4) {
            e4.printStackTrace();
            if (outputStream != null) {
                outputStream.close();
            }
        } catch (Throwable th) {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e5) {
                    e5.printStackTrace();
                }
            }
            throw th;
        }
    }

    public static String a(String str, String str2) {
        String str3;
        if ("off".equals(r)) {
            str3 = l;
        } else {
            str3 = g;
        }
        if (!"".equals(str2)) {
            return str3 + '/' + str + "." + str2;
        }
        return str3 + '/' + "Cshot" + '/' + str;
    }

    public static String a() {
        return p;
    }

    public static String b() {
        return q;
    }

    public static boolean c() {
        return A;
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x0041 A[SYNTHETIC, Splitter:B:29:0x0041] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0051 A[SYNTHETIC, Splitter:B:37:0x0051] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0057 A[SYNTHETIC, Splitter:B:41:0x0057] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] a(android.content.ContentResolver r3, android.net.Uri r4) {
        /*
            java.lang.String r0 = "Storage"
            r1 = 0
            java.io.InputStream r3 = r3.openInputStream(r4)     // Catch:{ FileNotFoundException -> 0x0045, IOException -> 0x0035, all -> 0x0032 }
            android.media.ExifInterface r4 = new android.media.ExifInterface     // Catch:{ FileNotFoundException -> 0x0030, IOException -> 0x002e }
            r4.<init>(r3)     // Catch:{ FileNotFoundException -> 0x0030, IOException -> 0x002e }
            boolean r2 = r4.hasThumbnail()     // Catch:{ FileNotFoundException -> 0x0030, IOException -> 0x002e }
            if (r2 == 0) goto L_0x0021
            byte[] r4 = r4.getThumbnail()     // Catch:{ FileNotFoundException -> 0x0030, IOException -> 0x002e }
            if (r3 == 0) goto L_0x0020
            r3.close()     // Catch:{ IOException -> 0x001c }
            goto L_0x0020
        L_0x001c:
            r3 = move-exception
            r3.printStackTrace()
        L_0x0020:
            return r4
        L_0x0021:
            if (r3 == 0) goto L_0x0054
            r3.close()     // Catch:{ IOException -> 0x0027 }
            goto L_0x0054
        L_0x0027:
            r3 = move-exception
            r3.printStackTrace()
            goto L_0x0054
        L_0x002c:
            r4 = move-exception
            goto L_0x0055
        L_0x002e:
            r4 = move-exception
            goto L_0x0037
        L_0x0030:
            r4 = move-exception
            goto L_0x0047
        L_0x0032:
            r4 = move-exception
            r3 = r1
            goto L_0x0055
        L_0x0035:
            r4 = move-exception
            r3 = r1
        L_0x0037:
            java.lang.String r2 = "getThumbnail, IOException: "
            com.oppo.camera.e.c(r0, r2)     // Catch:{ all -> 0x002c }
            r4.printStackTrace()     // Catch:{ all -> 0x002c }
            if (r3 == 0) goto L_0x0054
            r3.close()     // Catch:{ IOException -> 0x0027 }
            goto L_0x0054
        L_0x0045:
            r4 = move-exception
            r3 = r1
        L_0x0047:
            java.lang.String r2 = "getThumbnail, FileNotFoundException: "
            com.oppo.camera.e.c(r0, r2)     // Catch:{ all -> 0x002c }
            r4.printStackTrace()     // Catch:{ all -> 0x002c }
            if (r3 == 0) goto L_0x0054
            r3.close()     // Catch:{ IOException -> 0x0027 }
        L_0x0054:
            return r1
        L_0x0055:
            if (r3 == 0) goto L_0x005f
            r3.close()     // Catch:{ IOException -> 0x005b }
            goto L_0x005f
        L_0x005b:
            r3 = move-exception
            r3.printStackTrace()
        L_0x005f:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.z.a(android.content.ContentResolver, android.net.Uri):byte[]");
    }

    public static void a(String str) {
        if (!A && !new File(str).exists()) {
            com.oppo.camera.q.a.f(str);
        }
    }

    public static boolean a(Uri uri, ContentResolver contentResolver, byte[] bArr) {
        if (bArr == null) {
            return false;
        }
        OutputStream outputStream = null;
        try {
            OutputStream openOutputStream = contentResolver.openOutputStream(uri, "w");
            if (openOutputStream != null) {
                openOutputStream.write(bArr);
                openOutputStream.flush();
                if (openOutputStream != null) {
                    try {
                        openOutputStream.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                }
                return true;
            }
            if (openOutputStream != null) {
                try {
                    openOutputStream.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
            }
            return false;
        } catch (IOException e4) {
            e4.printStackTrace();
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e5) {
                    e5.printStackTrace();
                }
            }
            return false;
        } catch (Throwable th) {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e6) {
                    e6.printStackTrace();
                }
            }
            throw th;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: java.io.OutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: java.io.OutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: com.oppo.exif.OppoExifTag} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v6, resolved type: java.io.OutputStream} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void b(android.net.Uri r6, com.oppo.camera.z.a r7) {
        /*
            if (r7 == 0) goto L_0x0089
            if (r6 != 0) goto L_0x0006
            goto L_0x0089
        L_0x0006:
            java.lang.String r0 = r7.H
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x0012
            boolean r0 = r7.R
            if (r0 == 0) goto L_0x007d
        L_0x0012:
            r0 = 0
            com.oppo.exif.OppoExifInterface r1 = new com.oppo.exif.OppoExifInterface     // Catch:{ IOException -> 0x006f }
            r1.<init>()     // Catch:{ IOException -> 0x006f }
            byte[] r2 = r7.e     // Catch:{ IOException -> 0x006f }
            if (r2 == 0) goto L_0x0021
            byte[] r2 = r7.e     // Catch:{ IOException -> 0x006f }
            r1.readExif((byte[]) r2)     // Catch:{ IOException -> 0x006f }
        L_0x0021:
            int r2 = com.oppo.exif.OppoExifInterface.TAG_USER_COMMENT     // Catch:{ IOException -> 0x006f }
            com.oppo.exif.OppoExifTag r2 = r1.getTag(r2)     // Catch:{ IOException -> 0x006f }
            java.lang.String r3 = r7.H     // Catch:{ IOException -> 0x006f }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ IOException -> 0x006f }
            if (r3 != 0) goto L_0x003b
            int r3 = com.oppo.exif.OppoExifInterface.TAG_MAKER_NOTE     // Catch:{ IOException -> 0x006f }
            java.lang.String r4 = r7.H     // Catch:{ IOException -> 0x006f }
            com.oppo.exif.OppoExifTag r3 = r1.buildTag(r3, r4)     // Catch:{ IOException -> 0x006f }
            r1.setTag(r3)     // Catch:{ IOException -> 0x006f }
            goto L_0x003c
        L_0x003b:
            r3 = r0
        L_0x003c:
            boolean r4 = r7.R     // Catch:{ IOException -> 0x006f }
            if (r4 == 0) goto L_0x0057
            if (r2 != 0) goto L_0x0057
            int r2 = com.oppo.exif.OppoExifInterface.TAG_USER_COMMENT     // Catch:{ IOException -> 0x006f }
            java.lang.String r4 = "oppo_"
            r5 = 8192(0x2000, float:1.14794E-41)
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ IOException -> 0x006f }
            java.lang.String r4 = r4.concat(r5)     // Catch:{ IOException -> 0x006f }
            com.oppo.exif.OppoExifTag r2 = r1.buildTag(r2, r4)     // Catch:{ IOException -> 0x006f }
            r1.setTag(r2)     // Catch:{ IOException -> 0x006f }
        L_0x0057:
            if (r3 != 0) goto L_0x005c
            if (r2 != 0) goto L_0x005c
            return
        L_0x005c:
            android.content.ContentResolver r2 = r7.f3177a     // Catch:{ IOException -> 0x006f }
            java.io.OutputStream r0 = r2.openOutputStream(r6)     // Catch:{ IOException -> 0x006f }
            byte[] r6 = r7.e     // Catch:{ IOException -> 0x006f }
            r1.writeExif((byte[]) r6, (java.io.OutputStream) r0)     // Catch:{ IOException -> 0x006f }
            if (r0 == 0) goto L_0x007d
            r0.close()     // Catch:{ IOException -> 0x0079 }
            goto L_0x007d
        L_0x006d:
            r6 = move-exception
            goto L_0x007e
        L_0x006f:
            r6 = move-exception
            r6.printStackTrace()     // Catch:{ all -> 0x006d }
            if (r0 == 0) goto L_0x007d
            r0.close()     // Catch:{ IOException -> 0x0079 }
            goto L_0x007d
        L_0x0079:
            r6 = move-exception
            r6.printStackTrace()
        L_0x007d:
            return
        L_0x007e:
            if (r0 == 0) goto L_0x0088
            r0.close()     // Catch:{ IOException -> 0x0084 }
            goto L_0x0088
        L_0x0084:
            r7 = move-exception
            r7.printStackTrace()
        L_0x0088:
            throw r6
        L_0x0089:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.z.b(android.net.Uri, com.oppo.camera.z$a):void");
    }

    public static boolean a(boolean z2) {
        String internalSdState = OplusUsbEnvironment.getInternalSdState(y);
        e.a("Storage", "hasInternalStorage, requireWriteAccess: " + z2 + ", state: " + internalSdState);
        if ("mounted".equals(internalSdState)) {
            if (z2) {
                return i();
            }
            return true;
        } else if (z2 || !"mounted_ro".equals(internalSdState)) {
            return false;
        } else {
            return true;
        }
    }

    private static boolean i() {
        String str = OplusUsbEnvironment.getInternalSdDirectory(y).toString() + "/DCIM/Camera";
        File file = new File(str);
        if (file.exists() && !file.isDirectory()) {
            e.a("Storage", "checkInternalFsWritable, result: " + file.renameTo(d(str)));
        }
        if (!file.exists() && !com.oppo.camera.q.a.f(file.getAbsolutePath())) {
            e.a("Storage", "checkInternalFsWritable, directory.exists(): " + file.exists());
            if (!file.exists()) {
                return false;
            }
        }
        e.a("Storage", "checkInternalFsWritable, writable: " + file.canWrite());
        return file.canWrite();
    }

    public static boolean b(boolean z2) {
        String externalSdState = OplusUsbEnvironment.getExternalSdState(y);
        e.a("Storage", "hasStorage, state: " + externalSdState + ", requireWriteAccess: " + z2);
        if ("mounted".equals(externalSdState)) {
            if (!z2) {
                return true;
            }
            boolean k2 = k();
            e.a("Storage", "hasStorage, writable: " + k2);
            if (k2 || "mounted_ro".equals(externalSdState) || j()) {
                return k2;
            }
            return true;
        } else if (z2 || !"mounted_ro".equals(externalSdState)) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean d() {
        Context context = y;
        if (context == null) {
            return false;
        }
        String externalSdState = OplusUsbEnvironment.getExternalSdState(context);
        e.a("Storage", "hasSdCard(), state: " + externalSdState);
        return "mounted".equals(externalSdState);
    }

    private static boolean j() {
        File externalSdDirectory;
        if (!"mounted".equals(OplusUsbEnvironment.getExternalSdState(y)) || (externalSdDirectory = OplusUsbEnvironment.getExternalSdDirectory(y)) == null) {
            return false;
        }
        try {
            if (new StatFs(externalSdDirectory.toString()).getAvailableBlocks() > 0) {
                return true;
            }
            return false;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    private static boolean k() {
        return com.oppo.camera.q.a.a();
    }

    private static File d(String str) {
        String str2 = str + System.currentTimeMillis();
        File file = new File(str2);
        while (file.exists()) {
            file = new File(str2 + "_" + new Random().nextInt(100000));
        }
        e.d("Storage", "getBackupFile, file: " + file.getPath());
        return file;
    }

    public static String e() {
        return r;
    }

    public static void a(k kVar, String str) {
        u = d();
        v = g() <= 8.0d;
        e.a("Storage", "updateStoragePlace, before sStoragePlace: " + r + ", sStorageOverrideState: " + s + ", sbSmallEmmc: " + v + ", sbHasSDCard: " + u);
        s = 0;
        r = str;
        boolean equals = "off".equals(r);
        if (equals || f()) {
            t = b(r);
            int i2 = t;
            if (i2 == 1) {
                if (!equals) {
                    int b2 = b("off");
                    if (1 == b2 || 2 == b2) {
                        s = 4;
                    } else if (b2 == 0) {
                        s = 3;
                    }
                } else if (u) {
                    int b3 = b("on");
                    if (1 == b3 || 2 == b3) {
                        s = 1;
                    } else if (b3 == 0) {
                        s = 2;
                    }
                } else {
                    s = 1;
                }
                r = "invalid";
            } else if (i2 == 2 || i2 == 3) {
                s = 5;
                r = "invalid";
                t = 3;
            }
            e.a("Storage", "updateStoragePlace, after sStoragePlace: " + r + ", sStorageOverrideState: " + s);
            return;
        }
        s = 5;
        r = "invalid";
        t = 3;
    }

    private static StorageVolume a(StorageManager storageManager, File file) {
        if (storageManager == null) {
            return null;
        }
        return storageManager.getStorageVolume(file);
    }

    public static boolean f() {
        int i2;
        StorageVolume a2 = a((StorageManager) y.getSystemService("storage"), OplusUsbEnvironment.getExternalSdDirectory(y));
        if (a2 == null) {
            e.a("Storage", "checkExternalState, sdCardStorageVolumn is null");
            return false;
        }
        try {
            i2 = com.heytap.compat.os.a.b.b(a2);
        } catch (com.heytap.compat.d.a.a e2) {
            e2.printStackTrace();
            i2 = 0;
        }
        e.a("Storage", "checkExternalState: readOnlyTypeState: " + i2);
        if (1 == i2 || 2 == i2 || -1 == i2) {
            return false;
        }
        return true;
    }

    public static int b(String str) {
        e.a("Storage", "getStorageStatus, storagePlace: " + str);
        if (str == null || "invalid".equals(str) || "uninitied".equals(str)) {
            return 2;
        }
        long c = c(str);
        e.a("Storage", "remaining: " + c);
        if (-2 == c) {
            return 3;
        }
        return 52428800 >= c ? 1 : 0;
    }

    public static double g() {
        try {
            StatFs statFs = new StatFs(OplusUsbEnvironment.getInternalSdDirectory(y).toString());
            return ((double) (statFs.getBlockSizeLong() * statFs.getBlockCountLong())) / 1.073741824E9d;
        } catch (Exception e2) {
            e.d("Storage", "getInternalTotalStorage, Fail to access statfs", e2);
            return -2.0d;
        }
    }

    public static long c(String str) {
        e.a("Storage", "getAvailableStorage, sContext: " + y + ", storagePlace: " + str);
        Context context = y;
        if (context == null) {
            return -2;
        }
        boolean z2 = false;
        String str2 = null;
        File internalSdDirectory = OplusUsbEnvironment.getInternalSdDirectory(context);
        if ("on".equals(str)) {
            internalSdDirectory = OplusUsbEnvironment.getExternalSdDirectory(y);
        }
        if (internalSdDirectory == null) {
            e.e("Storage", "getAvailableStorage, file is null");
            return -2;
        }
        if ("off".equals(str)) {
            str2 = internalSdDirectory.toString();
            z2 = a(true);
        } else if ("on".equals(str)) {
            str2 = internalSdDirectory.toString();
            z2 = b(true);
        }
        if (!z2) {
            return -2;
        }
        e.a("Storage", "getAvailableStorage, dir: " + str2);
        try {
            StatFs statFs = new StatFs(str2);
            return ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
        } catch (Exception e2) {
            e.d("Storage", "Fail to access statfs", e2);
            return -2;
        }
    }

    private static void a(a aVar, ContentValues contentValues, Uri uri) {
        if (aVar != null && uri != null) {
            long j2 = -1;
            try {
                Uri insert = aVar.f3177a.insert(x, contentValues);
                if (insert != null) {
                    j2 = ContentUris.parseId(insert);
                }
            } catch (Exception e2) {
                e.e("Storage", "newImageForGallery, " + e2);
            }
            e.b("Storage", "newImageForGallery, result:" + j2);
        }
    }

    private static void b(a aVar, ContentValues contentValues, Uri uri) {
        if (aVar != null && uri != null) {
            int i2 = -1;
            try {
                long parseId = ContentUris.parseId(uri);
                ContentResolver contentResolver = aVar.f3177a;
                Uri uri2 = x;
                i2 = contentResolver.update(uri2, contentValues, "media_id=" + parseId, (String[]) null);
            } catch (Exception e2) {
                e.e("Storage", "updateImageForGallery, " + e2);
            }
            e.b("Storage", "updateImageForGallery, result:" + i2);
        }
    }

    private static void f(a aVar) {
        if (aVar != null && aVar.c != null) {
            int i2 = -1;
            try {
                long parseId = ContentUris.parseId(aVar.c);
                ContentResolver contentResolver = aVar.f3177a;
                Uri uri = x;
                i2 = contentResolver.delete(uri, "media_id=" + parseId, (String[]) null);
            } catch (Exception e2) {
                e.e("Storage", "deleteImageForGallery, " + e2);
            }
            e.b("Storage", "deleteImageForGallery, result:" + i2);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:69:0x0303  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0309  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0330 A[Catch:{ Throwable -> 0x03e4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0332 A[Catch:{ Throwable -> 0x03e4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x03c3 A[Catch:{ Throwable -> 0x03e2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x03c9 A[Catch:{ Throwable -> 0x03e2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x03fe  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.net.Uri b(com.oppo.camera.z.a r16) {
        /*
            r1 = r16
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "newImage, "
            r0.append(r2)
            java.lang.String r2 = r1.j
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            java.lang.String r2 = "Storage"
            com.oppo.camera.e.e(r2, r0)
            java.lang.String r0 = r
            java.lang.String r3 = "off"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x0027
            java.lang.String r0 = l
            goto L_0x0029
        L_0x0027:
            java.lang.String r0 = g
        L_0x0029:
            r3 = 0
            if (r0 != 0) goto L_0x002d
            return r3
        L_0x002d:
            java.lang.String r4 = r1.j
            java.lang.String r5 = "raw"
            java.lang.String r6 = "heic_10bits"
            java.lang.String r7 = "heic_8bits"
            java.lang.String r8 = "jpeg"
            if (r4 == 0) goto L_0x0073
            java.lang.String r4 = r1.j
            boolean r4 = r8.equalsIgnoreCase(r4)
            if (r4 == 0) goto L_0x0042
            goto L_0x0073
        L_0x0042:
            java.lang.String r4 = r1.j
            boolean r4 = r4.equalsIgnoreCase(r5)
            if (r4 == 0) goto L_0x004b
            goto L_0x0073
        L_0x004b:
            java.lang.String r4 = r1.j
            boolean r4 = r4.equalsIgnoreCase(r7)
            if (r4 != 0) goto L_0x0073
            java.lang.String r4 = r1.j
            boolean r4 = r4.equalsIgnoreCase(r6)
            if (r4 == 0) goto L_0x005c
            goto L_0x0073
        L_0x005c:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r4 = "newImage, Invalid pictureFormat: "
            r0.append(r4)
            java.lang.String r1 = r1.j
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            com.oppo.camera.e.e(r2, r0)
            return r3
        L_0x0073:
            a((java.lang.String) r0)
            android.content.ContentValues r4 = new android.content.ContentValues
            r9 = 10
            r4.<init>(r9)
            java.lang.String r9 = r1.h
            java.lang.String r10 = "title"
            r4.put(r10, r9)
            long r9 = r1.n
            java.lang.Long r9 = java.lang.Long.valueOf(r9)
            java.lang.String r10 = "datetaken"
            r4.put(r10, r9)
            int r9 = r1.q
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            java.lang.String r10 = "width"
            r4.put(r10, r9)
            int r9 = r1.r
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            java.lang.String r10 = "height"
            r4.put(r10, r9)
            java.lang.String r9 = d((com.oppo.camera.z.a) r16)
            java.lang.String r10 = "relative_path"
            r4.put(r10, r9)
            r9 = 1
            java.lang.Integer r10 = java.lang.Integer.valueOf(r9)
            java.lang.String r11 = "is_pending"
            r4.put(r11, r10)
            long r10 = r1.o
            r12 = -1
            int r10 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            java.lang.String r11 = "_tmp"
            java.lang.String r12 = ""
            java.lang.String r13 = ".jpg"
            if (r10 <= 0) goto L_0x00f5
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r10 = r1.h
            r5.append(r10)
            java.lang.String r10 = "_00"
            r5.append(r10)
            r5.append(r13)
            java.lang.String r12 = r5.toString()
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r10 = r1.h
            r5.append(r10)
            java.lang.String r10 = "_00_tmp"
            r5.append(r10)
            r5.append(r13)
            java.lang.String r5 = r5.toString()
        L_0x00f2:
            r3 = r5
            goto L_0x02f4
        L_0x00f5:
            boolean r10 = r1.R
            java.lang.String r14 = ".heic"
            java.lang.String r15 = ".dng"
            if (r10 == 0) goto L_0x01a7
            java.lang.String r10 = r1.j
            if (r10 == 0) goto L_0x0179
            java.lang.String r10 = r1.j
            boolean r10 = r8.equalsIgnoreCase(r10)
            if (r10 == 0) goto L_0x010a
            goto L_0x0179
        L_0x010a:
            java.lang.String r10 = r1.j
            boolean r5 = r5.equalsIgnoreCase(r10)
            if (r5 == 0) goto L_0x013f
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r10 = r1.h
            r5.append(r10)
            java.lang.String r10 = "_sr"
            r5.append(r10)
            r5.append(r15)
            java.lang.String r12 = r5.toString()
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r10 = r1.h
            r5.append(r10)
            java.lang.String r10 = "_sr_tmp"
            r5.append(r10)
            r5.append(r15)
            java.lang.String r5 = r5.toString()
            goto L_0x00f2
        L_0x013f:
            java.lang.String r5 = r1.j
            boolean r5 = r7.equalsIgnoreCase(r5)
            if (r5 != 0) goto L_0x014f
            java.lang.String r5 = r1.j
            boolean r5 = r6.equalsIgnoreCase(r5)
            if (r5 == 0) goto L_0x02a1
        L_0x014f:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r10 = r1.h
            r5.append(r10)
            r5.append(r12)
            r5.append(r14)
            java.lang.String r12 = r5.toString()
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r10 = r1.h
            r5.append(r10)
            r5.append(r11)
            r5.append(r14)
            java.lang.String r5 = r5.toString()
            goto L_0x00f2
        L_0x0179:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r10 = r1.h
            r5.append(r10)
            java.lang.String r10 = "_sr"
            r5.append(r10)
            r5.append(r13)
            java.lang.String r12 = r5.toString()
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r10 = r1.h
            r5.append(r10)
            java.lang.String r10 = "_sr_tmp"
            r5.append(r10)
            r5.append(r13)
            java.lang.String r5 = r5.toString()
            goto L_0x00f2
        L_0x01a7:
            boolean r10 = r1.S
            if (r10 == 0) goto L_0x0252
            java.lang.String r10 = r1.j
            java.lang.String r3 = "_sc_tmp"
            java.lang.String r9 = "_sc"
            if (r10 == 0) goto L_0x0228
            java.lang.String r10 = r1.j
            boolean r10 = r8.equalsIgnoreCase(r10)
            if (r10 == 0) goto L_0x01bc
            goto L_0x0228
        L_0x01bc:
            java.lang.String r10 = r1.j
            boolean r5 = r5.equalsIgnoreCase(r10)
            if (r5 == 0) goto L_0x01ee
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r10 = r1.h
            r5.append(r10)
            r5.append(r9)
            r5.append(r15)
            java.lang.String r12 = r5.toString()
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r9 = r1.h
            r5.append(r9)
            r5.append(r3)
            r5.append(r15)
            java.lang.String r3 = r5.toString()
            goto L_0x02f4
        L_0x01ee:
            java.lang.String r5 = r1.j
            boolean r5 = r7.equalsIgnoreCase(r5)
            if (r5 != 0) goto L_0x01fe
            java.lang.String r5 = r1.j
            boolean r5 = r6.equalsIgnoreCase(r5)
            if (r5 == 0) goto L_0x02a1
        L_0x01fe:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r10 = r1.h
            r5.append(r10)
            r5.append(r9)
            r5.append(r14)
            java.lang.String r12 = r5.toString()
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r9 = r1.h
            r5.append(r9)
            r5.append(r3)
            r5.append(r14)
            java.lang.String r3 = r5.toString()
            goto L_0x02f4
        L_0x0228:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r10 = r1.h
            r5.append(r10)
            r5.append(r9)
            r5.append(r13)
            java.lang.String r12 = r5.toString()
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r9 = r1.h
            r5.append(r9)
            r5.append(r3)
            r5.append(r13)
            java.lang.String r3 = r5.toString()
            goto L_0x02f4
        L_0x0252:
            java.lang.String r3 = r1.j
            if (r3 == 0) goto L_0x02cc
            java.lang.String r3 = r1.j
            boolean r3 = r8.equalsIgnoreCase(r3)
            if (r3 == 0) goto L_0x025f
            goto L_0x02cc
        L_0x025f:
            java.lang.String r3 = r1.j
            boolean r3 = r5.equalsIgnoreCase(r3)
            if (r3 == 0) goto L_0x0290
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r5 = r1.h
            r3.append(r5)
            r3.append(r12)
            r3.append(r15)
            java.lang.String r12 = r3.toString()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r5 = r1.h
            r3.append(r5)
            r3.append(r11)
            r3.append(r15)
            java.lang.String r3 = r3.toString()
            goto L_0x02f4
        L_0x0290:
            java.lang.String r3 = r1.j
            boolean r3 = r7.equalsIgnoreCase(r3)
            if (r3 != 0) goto L_0x02a3
            java.lang.String r3 = r1.j
            boolean r3 = r6.equalsIgnoreCase(r3)
            if (r3 == 0) goto L_0x02a1
            goto L_0x02a3
        L_0x02a1:
            r3 = r12
            goto L_0x02f4
        L_0x02a3:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r5 = r1.h
            r3.append(r5)
            r3.append(r12)
            r3.append(r14)
            java.lang.String r12 = r3.toString()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r5 = r1.h
            r3.append(r5)
            r3.append(r11)
            r3.append(r14)
            java.lang.String r3 = r3.toString()
            goto L_0x02f4
        L_0x02cc:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r5 = r1.h
            r3.append(r5)
            r3.append(r12)
            r3.append(r13)
            java.lang.String r12 = r3.toString()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r5 = r1.h
            r3.append(r5)
            r3.append(r11)
            r3.append(r13)
            java.lang.String r3 = r3.toString()
        L_0x02f4:
            java.lang.String r5 = "_display_name"
            r4.put(r5, r12)
            java.lang.String r5 = r1.j
            boolean r5 = r8.equalsIgnoreCase(r5)
            java.lang.String r9 = "mime_type"
            if (r5 == 0) goto L_0x0309
            java.lang.String r5 = com.oppo.camera.q.a.c
            r4.put(r9, r5)
            goto L_0x031e
        L_0x0309:
            java.lang.String r5 = r1.j
            boolean r5 = r7.equalsIgnoreCase(r5)
            if (r5 != 0) goto L_0x0319
            java.lang.String r5 = r1.j
            boolean r5 = r6.equalsIgnoreCase(r5)
            if (r5 == 0) goto L_0x031e
        L_0x0319:
            java.lang.String r5 = com.oppo.camera.q.a.e
            r4.put(r9, r5)
        L_0x031e:
            android.content.ContentResolver r5 = r1.f3177a     // Catch:{ Throwable -> 0x03e4 }
            java.lang.String r10 = "on"
            java.lang.String r12 = r     // Catch:{ Throwable -> 0x03e4 }
            boolean r10 = r10.equals(r12)     // Catch:{ Throwable -> 0x03e4 }
            if (r10 == 0) goto L_0x0332
            boolean r10 = d()     // Catch:{ Throwable -> 0x03e4 }
            if (r10 == 0) goto L_0x0332
            r10 = 1
            goto L_0x0333
        L_0x0332:
            r10 = 0
        L_0x0333:
            android.net.Uri r10 = c((boolean) r10)     // Catch:{ Throwable -> 0x03e4 }
            android.net.Uri r5 = r5.insert(r10, r4)     // Catch:{ Throwable -> 0x03e4 }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x03e2 }
            r10.<init>()     // Catch:{ Throwable -> 0x03e2 }
            java.lang.String r12 = "newImage, uri: "
            r10.append(r12)     // Catch:{ Throwable -> 0x03e2 }
            r10.append(r5)     // Catch:{ Throwable -> 0x03e2 }
            java.lang.String r12 = ", values: "
            r10.append(r12)     // Catch:{ Throwable -> 0x03e2 }
            r10.append(r4)     // Catch:{ Throwable -> 0x03e2 }
            java.lang.String r10 = r10.toString()     // Catch:{ Throwable -> 0x03e2 }
            com.oppo.camera.e.b(r2, r10)     // Catch:{ Throwable -> 0x03e2 }
            r4.clear()     // Catch:{ Throwable -> 0x03e2 }
            java.lang.String r10 = "title"
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x03e2 }
            r12.<init>()     // Catch:{ Throwable -> 0x03e2 }
            java.lang.String r13 = r1.h     // Catch:{ Throwable -> 0x03e2 }
            r12.append(r13)     // Catch:{ Throwable -> 0x03e2 }
            r12.append(r11)     // Catch:{ Throwable -> 0x03e2 }
            java.lang.String r11 = r12.toString()     // Catch:{ Throwable -> 0x03e2 }
            r4.put(r10, r11)     // Catch:{ Throwable -> 0x03e2 }
            java.lang.String r10 = "_display_name"
            r4.put(r10, r3)     // Catch:{ Throwable -> 0x03e2 }
            java.lang.String r10 = "_data"
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x03e2 }
            r11.<init>()     // Catch:{ Throwable -> 0x03e2 }
            r11.append(r0)     // Catch:{ Throwable -> 0x03e2 }
            java.lang.String r0 = g(r16)     // Catch:{ Throwable -> 0x03e2 }
            r11.append(r0)     // Catch:{ Throwable -> 0x03e2 }
            r11.append(r3)     // Catch:{ Throwable -> 0x03e2 }
            java.lang.String r0 = r11.toString()     // Catch:{ Throwable -> 0x03e2 }
            r4.put(r10, r0)     // Catch:{ Throwable -> 0x03e2 }
            java.lang.String r0 = "datetaken"
            long r10 = r1.n     // Catch:{ Throwable -> 0x03e2 }
            java.lang.Long r3 = java.lang.Long.valueOf(r10)     // Catch:{ Throwable -> 0x03e2 }
            r4.put(r0, r3)     // Catch:{ Throwable -> 0x03e2 }
            java.lang.String r0 = "media_type"
            r3 = 1
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ Throwable -> 0x03e2 }
            r4.put(r0, r3)     // Catch:{ Throwable -> 0x03e2 }
            java.lang.String r0 = "relative_path"
            java.lang.String r3 = d((com.oppo.camera.z.a) r16)     // Catch:{ Throwable -> 0x03e2 }
            r4.put(r0, r3)     // Catch:{ Throwable -> 0x03e2 }
            java.lang.String r0 = "media_id"
            long r10 = android.content.ContentUris.parseId(r5)     // Catch:{ Throwable -> 0x03e2 }
            java.lang.Long r3 = java.lang.Long.valueOf(r10)     // Catch:{ Throwable -> 0x03e2 }
            r4.put(r0, r3)     // Catch:{ Throwable -> 0x03e2 }
            java.lang.String r0 = r1.j     // Catch:{ Throwable -> 0x03e2 }
            boolean r0 = r8.equalsIgnoreCase(r0)     // Catch:{ Throwable -> 0x03e2 }
            if (r0 == 0) goto L_0x03c9
            java.lang.String r0 = com.oppo.camera.q.a.c     // Catch:{ Throwable -> 0x03e2 }
            r4.put(r9, r0)     // Catch:{ Throwable -> 0x03e2 }
            goto L_0x03de
        L_0x03c9:
            java.lang.String r0 = r1.j     // Catch:{ Throwable -> 0x03e2 }
            boolean r0 = r7.equalsIgnoreCase(r0)     // Catch:{ Throwable -> 0x03e2 }
            if (r0 != 0) goto L_0x03d9
            java.lang.String r0 = r1.j     // Catch:{ Throwable -> 0x03e2 }
            boolean r0 = r6.equalsIgnoreCase(r0)     // Catch:{ Throwable -> 0x03e2 }
            if (r0 == 0) goto L_0x03de
        L_0x03d9:
            java.lang.String r0 = com.oppo.camera.q.a.e     // Catch:{ Throwable -> 0x03e2 }
            r4.put(r9, r0)     // Catch:{ Throwable -> 0x03e2 }
        L_0x03de:
            a((com.oppo.camera.z.a) r1, (android.content.ContentValues) r4, (android.net.Uri) r5)     // Catch:{ Throwable -> 0x03e2 }
            goto L_0x03fa
        L_0x03e2:
            r0 = move-exception
            goto L_0x03e6
        L_0x03e4:
            r0 = move-exception
            r5 = 0
        L_0x03e6:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "newImage, Failed to new image"
            r3.append(r4)
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            com.oppo.camera.e.e(r2, r0)
        L_0x03fa:
            boolean r0 = r1.F
            if (r0 == 0) goto L_0x0406
            com.oppo.camera.z$1 r0 = new com.oppo.camera.z$1
            r0.<init>(r5, r1)
            com.oppo.camera.util.Util.a((java.lang.Runnable) r0)
        L_0x0406:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.z.b(com.oppo.camera.z$a):android.net.Uri");
    }

    /* JADX WARNING: Removed duplicated region for block: B:101:0x0319 A[Catch:{ Throwable -> 0x03f4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x03b5 A[Catch:{ Throwable -> 0x03f4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:143:0x0463  */
    /* JADX WARNING: Removed duplicated region for block: B:148:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0208  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x024c  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0252  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x02bf  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x02d8  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x02f2  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x02f5  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x02fb  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.oppo.camera.z.a c(com.oppo.camera.z.a r25) {
        /*
            r1 = r25
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "updateImage, "
            r0.append(r2)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r2 = "Storage"
            com.oppo.camera.e.b(r2, r0)
            java.lang.String r0 = r
            java.lang.String r3 = "off"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x0025
            java.lang.String r0 = l
            goto L_0x0027
        L_0x0025:
            java.lang.String r0 = g
        L_0x0027:
            r3 = r0
            java.lang.String r0 = r1.j
            java.lang.String r4 = ".heic"
            java.lang.String r5 = ".jpg"
            java.lang.String r6 = "heic_10bits"
            java.lang.String r7 = "heic_8bits"
            java.lang.String r8 = "jpeg"
            r9 = 0
            if (r0 == 0) goto L_0x0078
            java.lang.String r0 = r1.j
            boolean r0 = r8.equalsIgnoreCase(r0)
            if (r0 == 0) goto L_0x0040
            goto L_0x0078
        L_0x0040:
            java.lang.String r0 = r1.j
            java.lang.String r10 = "raw"
            boolean r0 = r10.equalsIgnoreCase(r0)
            if (r0 == 0) goto L_0x004e
            java.lang.String r0 = ".dng"
            r10 = r0
            goto L_0x0079
        L_0x004e:
            java.lang.String r0 = r1.j
            boolean r0 = r7.equalsIgnoreCase(r0)
            if (r0 != 0) goto L_0x0076
            java.lang.String r0 = r1.j
            boolean r0 = r6.equalsIgnoreCase(r0)
            if (r0 == 0) goto L_0x005f
            goto L_0x0076
        L_0x005f:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r3 = "updateImage, Invalid pictureFormat: "
            r0.append(r3)
            java.lang.String r1 = r1.j
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            com.oppo.camera.e.e(r2, r0)
            return r9
        L_0x0076:
            r10 = r4
            goto L_0x0079
        L_0x0078:
            r10 = r5
        L_0x0079:
            android.content.ContentResolver r11 = r1.f3177a     // Catch:{ Throwable -> 0x0439 }
            android.net.Uri r12 = r1.c     // Catch:{ Throwable -> 0x0439 }
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            android.database.Cursor r11 = r11.query(r12, r13, r14, r15, r16)     // Catch:{ Throwable -> 0x0439 }
            java.lang.String r12 = "title"
            if (r11 == 0) goto L_0x00a1
            int r0 = r11.getCount()     // Catch:{ Throwable -> 0x009e }
            if (r0 <= 0) goto L_0x00a1
            r11.moveToFirst()     // Catch:{ Throwable -> 0x009e }
            int r0 = r11.getColumnIndex(r12)     // Catch:{ Throwable -> 0x009e }
            java.lang.String r0 = r11.getString(r0)     // Catch:{ Throwable -> 0x009e }
            r1.h = r0     // Catch:{ Throwable -> 0x009e }
            goto L_0x00a1
        L_0x009e:
            r0 = move-exception
            goto L_0x043b
        L_0x00a1:
            long r13 = r1.o
            r15 = -1
            int r0 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r0 <= 0) goto L_0x00ef
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r13 = r1.m
            r0.append(r13)
            java.lang.String r13 = java.io.File.separator
            r0.append(r13)
            java.lang.String r13 = r1.h
            r0.append(r13)
            r0.append(r10)
            java.lang.String r0 = r0.toString()
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            java.lang.String r14 = r1.m
            r13.append(r14)
            java.lang.String r14 = java.io.File.separator
            r13.append(r14)
            java.lang.String r14 = r1.h
            r13.append(r14)
            java.lang.String r14 = "_00"
            r13.append(r14)
            r13.append(r10)
            java.lang.String r13 = r13.toString()
            java.lang.String r14 = r1.m
            a((java.lang.String) r14)
        L_0x00e9:
            r24 = r13
            r13 = r0
            r0 = r24
            goto L_0x014a
        L_0x00ef:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r3)
            java.lang.String r13 = java.io.File.separator
            r0.append(r13)
            java.lang.String r13 = r1.h
            r0.append(r13)
            r0.append(r10)
            java.lang.String r0 = r0.toString()
            boolean r13 = r1.R
            if (r13 == 0) goto L_0x012b
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            r13.append(r3)
            java.lang.String r14 = java.io.File.separator
            r13.append(r14)
            java.lang.String r14 = r1.h
            r13.append(r14)
            java.lang.String r14 = "_sr"
            r13.append(r14)
            r13.append(r10)
            java.lang.String r13 = r13.toString()
            goto L_0x00e9
        L_0x012b:
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            r13.append(r3)
            java.lang.String r14 = java.io.File.separator
            r13.append(r14)
            java.lang.String r14 = r1.h
            r13.append(r14)
            java.lang.String r14 = ""
            r13.append(r14)
            r13.append(r10)
            java.lang.String r13 = r13.toString()
            goto L_0x00e9
        L_0x014a:
            boolean r14 = r1.E
            r15 = 0
            r9 = 1
            if (r14 == 0) goto L_0x0176
            java.lang.String r0 = r1.j
            boolean r0 = r7.equalsIgnoreCase(r0)
            if (r0 == 0) goto L_0x015e
            android.net.Uri r0 = r1.c
            a((boolean) r9, (com.oppo.camera.z.a) r1, (android.net.Uri) r0)
            goto L_0x01ae
        L_0x015e:
            java.lang.String r0 = r1.j
            boolean r0 = r6.equalsIgnoreCase(r0)
            if (r0 == 0) goto L_0x016c
            android.net.Uri r0 = r1.c
            a((boolean) r15, (com.oppo.camera.z.a) r1, (android.net.Uri) r0)
            goto L_0x01ae
        L_0x016c:
            byte[] r0 = r1.e
            if (r0 == 0) goto L_0x01ae
            android.net.Uri r0 = r1.c
            a((android.net.Uri) r0, (com.oppo.camera.z.a) r1)
            goto L_0x01ae
        L_0x0176:
            boolean r14 = r1.x     // Catch:{ Exception -> 0x0414 }
            if (r14 == 0) goto L_0x01ae
            java.lang.String r14 = r1.j     // Catch:{ Exception -> 0x0414 }
            boolean r14 = r8.equalsIgnoreCase(r14)     // Catch:{ Exception -> 0x0414 }
            if (r14 == 0) goto L_0x01ae
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0414 }
            r14.<init>()     // Catch:{ Exception -> 0x0414 }
            java.lang.String r9 = "updateImage, path: "
            r14.append(r9)     // Catch:{ Exception -> 0x0414 }
            r14.append(r13)     // Catch:{ Exception -> 0x0414 }
            java.lang.String r9 = r14.toString()     // Catch:{ Exception -> 0x0414 }
            com.oppo.camera.e.b(r2, r9)     // Catch:{ Exception -> 0x0414 }
            android.net.Uri r9 = r1.c     // Catch:{ Exception -> 0x0414 }
            android.content.ContentResolver r14 = r1.f3177a     // Catch:{ Exception -> 0x0414 }
            byte[] r15 = r1.e     // Catch:{ Exception -> 0x0414 }
            a((android.net.Uri) r9, (android.content.ContentResolver) r14, (byte[]) r15)     // Catch:{ Exception -> 0x0414 }
            java.lang.String r9 = "picture_save"
            com.oppo.camera.perf.a.b(r9)     // Catch:{ Exception -> 0x0414 }
            long r14 = r1.n     // Catch:{ Exception -> 0x0414 }
            a((java.lang.String) r0, (long) r14)     // Catch:{ Exception -> 0x0414 }
            android.net.Uri r0 = r1.c     // Catch:{ Exception -> 0x0414 }
            b(r0, r1)     // Catch:{ Exception -> 0x0414 }
        L_0x01ae:
            int r9 = r1.q
            int r14 = r1.r
            r20 = 0
            android.content.ContentResolver r0 = r1.f3177a     // Catch:{ IOException -> 0x01dc, all -> 0x01d8 }
            android.net.Uri r15 = r1.c     // Catch:{ IOException -> 0x01dc, all -> 0x01d8 }
            java.io.InputStream r15 = r0.openInputStream(r15)     // Catch:{ IOException -> 0x01dc, all -> 0x01d8 }
            int r0 = r15.available()     // Catch:{ IOException -> 0x01d0 }
            r22 = r4
            r23 = r5
            long r4 = (long) r0
            android.media.ExifInterface r0 = new android.media.ExifInterface     // Catch:{ IOException -> 0x01ce }
            r0.<init>(r15)     // Catch:{ IOException -> 0x01ce }
            com.oppo.camera.util.Util.a((java.io.Closeable) r15)
            goto L_0x0202
        L_0x01ce:
            r0 = move-exception
            goto L_0x01e4
        L_0x01d0:
            r0 = move-exception
            r22 = r4
            r23 = r5
            r4 = r20
            goto L_0x01e4
        L_0x01d8:
            r0 = move-exception
            r15 = 0
            goto L_0x040e
        L_0x01dc:
            r0 = move-exception
            r22 = r4
            r23 = r5
            r4 = r20
            r15 = 0
        L_0x01e4:
            r20 = r4
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x040d }
            r4.<init>()     // Catch:{ all -> 0x040d }
            java.lang.String r5 = "updateImage, open uri failed, uri: "
            r4.append(r5)     // Catch:{ all -> 0x040d }
            android.net.Uri r5 = r1.c     // Catch:{ all -> 0x040d }
            r4.append(r5)     // Catch:{ all -> 0x040d }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x040d }
            com.oppo.camera.e.d(r2, r4, r0)     // Catch:{ all -> 0x040d }
            com.oppo.camera.util.Util.a((java.io.Closeable) r15)
            r4 = r20
            r0 = 0
        L_0x0202:
            android.util.Size r15 = a((android.media.ExifInterface) r0)
            if (r15 == 0) goto L_0x0210
            int r9 = r15.getWidth()
            int r14 = r15.getHeight()
        L_0x0210:
            android.content.ContentValues r15 = new android.content.ContentValues
            r20 = r13
            r13 = 12
            r15.<init>(r13)
            java.lang.String r13 = r1.h
            r15.put(r12, r13)
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            r21 = r3
            java.lang.String r3 = r1.h
            r13.append(r3)
            r13.append(r10)
            java.lang.String r3 = r13.toString()
            java.lang.String r13 = "_display_name"
            r15.put(r13, r3)
            r19 = r13
            r3 = 0
            java.lang.Integer r13 = java.lang.Integer.valueOf(r3)
            java.lang.String r3 = "is_pending"
            r15.put(r3, r13)
            java.lang.String r3 = r1.j
            boolean r3 = r8.equalsIgnoreCase(r3)
            java.lang.String r8 = "mime_type"
            if (r3 == 0) goto L_0x0252
            java.lang.String r3 = com.oppo.camera.q.a.c
            r15.put(r8, r3)
            goto L_0x0267
        L_0x0252:
            java.lang.String r3 = r1.j
            boolean r3 = r7.equalsIgnoreCase(r3)
            if (r3 != 0) goto L_0x0262
            java.lang.String r3 = r1.j
            boolean r3 = r6.equalsIgnoreCase(r3)
            if (r3 == 0) goto L_0x0267
        L_0x0262:
            java.lang.String r3 = com.oppo.camera.q.a.e
            r15.put(r8, r3)
        L_0x0267:
            int r3 = r1.v
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            java.lang.String r6 = "orientation"
            r15.put(r6, r3)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r9)
            java.lang.String r6 = "width"
            r15.put(r6, r3)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r14)
            java.lang.String r6 = "height"
            r15.put(r6, r3)
            java.lang.Long r3 = java.lang.Long.valueOf(r4)
            java.lang.String r4 = "_size"
            r15.put(r4, r3)
            long r3 = java.lang.System.currentTimeMillis()
            r5 = 1000(0x3e8, double:4.94E-321)
            long r3 = r3 / r5
            java.lang.Long r3 = java.lang.Long.valueOf(r3)
            java.lang.String r4 = "date_added"
            r15.put(r4, r3)
            long r3 = r1.n
            long r3 = r3 / r5
            java.lang.Long r3 = java.lang.Long.valueOf(r3)
            java.lang.String r4 = "date_modified"
            r15.put(r4, r3)
            long r3 = r1.n
            java.lang.Long r3 = java.lang.Long.valueOf(r3)
            java.lang.String r4 = "datetaken"
            r15.put(r4, r3)
            java.lang.String r3 = d((com.oppo.camera.z.a) r25)
            java.lang.String r5 = "relative_path"
            r15.put(r5, r3)
            if (r11 == 0) goto L_0x02d8
            boolean r3 = r11.moveToFirst()
            if (r3 == 0) goto L_0x02d0
            int r3 = r11.getColumnIndex(r4)
            long r3 = r11.getLong(r3)
            r17 = r3
            goto L_0x02d2
        L_0x02d0:
            r17 = -1
        L_0x02d2:
            r11.close()
            r3 = r17
            goto L_0x02da
        L_0x02d8:
            r3 = -1
        L_0x02da:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "updateImage, values: "
            r5.append(r6)
            r5.append(r15)
            java.lang.String r5 = r5.toString()
            com.oppo.camera.e.b(r2, r5)
            boolean r5 = r1.z
            if (r5 == 0) goto L_0x02f5
            android.location.Location r0 = r1.d
            goto L_0x02f9
        L_0x02f5:
            android.location.Location r0 = com.oppo.camera.util.Util.a((android.media.ExifInterface) r0)
        L_0x02f9:
            if (r0 == 0) goto L_0x0315
            double r5 = r0.getLatitude()
            java.lang.Double r5 = java.lang.Double.valueOf(r5)
            java.lang.String r6 = "latitude"
            r15.put(r6, r5)
            double r5 = r0.getLongitude()
            java.lang.Double r0 = java.lang.Double.valueOf(r5)
            java.lang.String r5 = "longitude"
            r15.put(r5, r0)
        L_0x0315:
            boolean r0 = r1.x     // Catch:{ Throwable -> 0x03f4 }
            if (r0 == 0) goto L_0x03b5
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch:{ Throwable -> 0x03f4 }
            r5 = 30
            if (r0 < r5) goto L_0x0333
            android.os.Bundle r0 = new android.os.Bundle     // Catch:{ Throwable -> 0x03f4 }
            r0.<init>()     // Catch:{ Throwable -> 0x03f4 }
            java.lang.String r5 = "android:query-arg-do-async-scan"
            r6 = 1
            r0.putBoolean(r5, r6)     // Catch:{ Throwable -> 0x03f4 }
            android.content.ContentResolver r5 = r1.f3177a     // Catch:{ Throwable -> 0x03f4 }
            android.net.Uri r6 = r1.c     // Catch:{ Throwable -> 0x03f4 }
            int r0 = r5.update(r6, r15, r0)     // Catch:{ Throwable -> 0x03f4 }
            goto L_0x033c
        L_0x0333:
            android.content.ContentResolver r0 = r1.f3177a     // Catch:{ Throwable -> 0x03f4 }
            android.net.Uri r5 = r1.c     // Catch:{ Throwable -> 0x03f4 }
            r6 = 0
            int r0 = r0.update(r5, r15, r6, r6)     // Catch:{ Throwable -> 0x03f4 }
        L_0x033c:
            if (r0 > 0) goto L_0x036f
            android.content.ContentResolver r0 = r1.f3177a     // Catch:{ Throwable -> 0x03f4 }
            java.lang.String r5 = "on"
            java.lang.String r6 = r     // Catch:{ Throwable -> 0x03f4 }
            boolean r5 = r5.equals(r6)     // Catch:{ Throwable -> 0x03f4 }
            if (r5 == 0) goto L_0x0352
            boolean r5 = d()     // Catch:{ Throwable -> 0x03f4 }
            if (r5 == 0) goto L_0x0352
            r5 = 1
            goto L_0x0353
        L_0x0352:
            r5 = 0
        L_0x0353:
            android.net.Uri r5 = c((boolean) r5)     // Catch:{ Throwable -> 0x03f4 }
            android.net.Uri r0 = r0.insert(r5, r15)     // Catch:{ Throwable -> 0x03f4 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x03f4 }
            r5.<init>()     // Catch:{ Throwable -> 0x03f4 }
            java.lang.String r6 = "updateImage, insertImage, uri: "
            r5.append(r6)     // Catch:{ Throwable -> 0x03f4 }
            r5.append(r0)     // Catch:{ Throwable -> 0x03f4 }
            java.lang.String r0 = r5.toString()     // Catch:{ Throwable -> 0x03f4 }
            com.oppo.camera.e.a(r2, r0)     // Catch:{ Throwable -> 0x03f4 }
        L_0x036f:
            r15.clear()     // Catch:{ Throwable -> 0x03f4 }
            java.lang.String r0 = r1.h     // Catch:{ Throwable -> 0x03f4 }
            r15.put(r12, r0)     // Catch:{ Throwable -> 0x03f4 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x03f4 }
            r0.<init>()     // Catch:{ Throwable -> 0x03f4 }
            java.lang.String r5 = r1.h     // Catch:{ Throwable -> 0x03f4 }
            r0.append(r5)     // Catch:{ Throwable -> 0x03f4 }
            r0.append(r10)     // Catch:{ Throwable -> 0x03f4 }
            java.lang.String r0 = r0.toString()     // Catch:{ Throwable -> 0x03f4 }
            r5 = r19
            r15.put(r5, r0)     // Catch:{ Throwable -> 0x03f4 }
            java.lang.String r0 = "_data"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x03f4 }
            r5.<init>()     // Catch:{ Throwable -> 0x03f4 }
            r6 = r21
            r5.append(r6)     // Catch:{ Throwable -> 0x03f4 }
            java.lang.String r6 = g(r25)     // Catch:{ Throwable -> 0x03f4 }
            r5.append(r6)     // Catch:{ Throwable -> 0x03f4 }
            java.lang.String r6 = r1.h     // Catch:{ Throwable -> 0x03f4 }
            r5.append(r6)     // Catch:{ Throwable -> 0x03f4 }
            r5.append(r10)     // Catch:{ Throwable -> 0x03f4 }
            java.lang.String r5 = r5.toString()     // Catch:{ Throwable -> 0x03f4 }
            r15.put(r0, r5)     // Catch:{ Throwable -> 0x03f4 }
            android.net.Uri r0 = r1.c     // Catch:{ Throwable -> 0x03f4 }
            b(r1, r15, r0)     // Catch:{ Throwable -> 0x03f4 }
            goto L_0x03c0
        L_0x03b5:
            android.content.ContentResolver r0 = r1.f3177a     // Catch:{ Throwable -> 0x03f4 }
            android.net.Uri r5 = r1.c     // Catch:{ Throwable -> 0x03f4 }
            r6 = 0
            r0.delete(r5, r6, r6)     // Catch:{ Throwable -> 0x03f4 }
            f(r25)     // Catch:{ Throwable -> 0x03f4 }
        L_0x03c0:
            r5 = r20
            r1.i = r5
            r1.n = r3
            r3 = 1
            r1.C = r3
            r4 = r23
            boolean r0 = r4.equals(r10)
            if (r0 != 0) goto L_0x03db
            r4 = r22
            boolean r0 = r4.equals(r10)
            if (r0 == 0) goto L_0x03da
            goto L_0x03db
        L_0x03da:
            r3 = 0
        L_0x03db:
            r1.D = r3
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r3 = "updateImage, X uri: "
            r0.append(r3)
            android.net.Uri r3 = r1.c
            r0.append(r3)
            java.lang.String r0 = r0.toString()
            com.oppo.camera.e.e(r2, r0)
            return r1
        L_0x03f4:
            r0 = move-exception
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "updateImage, Failed to update image: "
            r3.append(r4)
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            com.oppo.camera.e.e(r2, r0)
            r2 = 0
            r1.e = r2
            return r2
        L_0x040d:
            r0 = move-exception
        L_0x040e:
            com.oppo.camera.util.Util.a((java.io.Closeable) r15)
            throw r0
        L_0x0412:
            r0 = move-exception
            goto L_0x0438
        L_0x0414:
            r0 = move-exception
            java.lang.String r1 = "updateImage, Failed to write image: "
            com.oppo.camera.e.d(r2, r1, r0)     // Catch:{ all -> 0x0412 }
            if (r11 == 0) goto L_0x0436
            r11.close()     // Catch:{ Exception -> 0x0420 }
            goto L_0x0436
        L_0x0420:
            r0 = move-exception
            r1 = r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r3 = "updateImage error, cursor: "
            r0.append(r3)
            r0.append(r11)
            java.lang.String r0 = r0.toString()
            com.oppo.camera.e.d(r2, r0, r1)
        L_0x0436:
            r1 = 0
            return r1
        L_0x0438:
            throw r0
        L_0x0439:
            r0 = move-exception
            r11 = 0
        L_0x043b:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "updateImage, Failed to query uri: "
            r3.append(r4)
            android.net.Uri r1 = r1.c
            r3.append(r1)
            java.lang.String r1 = ", cursor: "
            r3.append(r1)
            r3.append(r11)
            java.lang.String r1 = ", th: "
            r3.append(r1)
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            com.oppo.camera.e.e(r2, r0)
            if (r11 == 0) goto L_0x0466
            r11.close()
        L_0x0466:
            r1 = 0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.z.c(com.oppo.camera.z$a):com.oppo.camera.z$a");
    }

    private static void a(String str, long j2) {
        e.a("Storage", "changeLastModified, path: " + str + ", date: " + j2);
        try {
            File file = new File(str);
            if (file.exists()) {
                file.setLastModified(j2);
            }
            e.a("Storage", "changeLastModified, lastModified: " + file.lastModified());
        } catch (Exception e2) {
            e2.printStackTrace();
            e.e("Storage", "changeLastModified, exception");
        }
        e.a("Storage", "changeLastModified X, path: " + str + ", date: " + j2);
    }

    public static void a(Uri uri) {
        String path;
        int lastIndexOf;
        String scheme = uri.getScheme();
        if (!TextUtils.isEmpty(scheme) && scheme.equalsIgnoreCase("file") && (path = uri.getPath()) != null && (lastIndexOf = path.lastIndexOf("/")) > 0) {
            String substring = path.substring(0, lastIndexOf);
            if (!TextUtils.isEmpty(substring) && !new File(substring).exists()) {
                boolean f2 = com.oppo.camera.q.a.f(substring);
                e.a("Storage", "ensurePathExist folder: " + substring + ", result: " + f2);
            }
        }
    }

    public static Uri c(boolean z2) {
        if (z2) {
            return MediaStore.Images.Media.getContentUri(h());
        }
        return MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
    }

    public static Uri d(boolean z2) {
        if (z2) {
            return MediaStore.Video.Media.getContentUri(h());
        }
        return MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
    }

    public static String h() {
        StorageVolume a2 = a((StorageManager) y.getSystemService("storage"), OplusUsbEnvironment.getExternalSdDirectory(y));
        if (a2 == null) {
            return "";
        }
        return a2.getUuid().toLowerCase();
    }

    public static Size a(ExifInterface exifInterface) {
        if (exifInterface == null) {
            return null;
        }
        Size size = new Size(exifInterface.getAttributeInt("ImageWidth", 0), exifInterface.getAttributeInt("ImageLength", 0));
        if (size.getWidth() <= 0 || size.getHeight() <= 0) {
            return null;
        }
        return size;
    }

    public static void a(Uri uri, ContentResolver contentResolver) {
        if (uri != null && contentResolver != null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("media_id", Long.valueOf(ContentUris.parseId(uri)));
            try {
                contentResolver.insert(Uri.parse("content://com.oppo.gallery3d.open.provider/locked_pictures"), contentValues);
            } catch (Exception e2) {
                e.a("Storage", "addImageToLockScreenGallery, err: ", (Throwable) e2);
            }
        }
    }

    private static String g(a aVar) {
        String str = File.separator;
        if (aVar == null || aVar.o <= -1) {
            return str;
        }
        return File.separator + aVar.m.substring(aVar.m.indexOf("Cshot")) + File.separator;
    }

    public static String d(a aVar) {
        if (aVar == null || aVar.o <= -1) {
            return e;
        }
        return e + aVar.m.substring(aVar.m.indexOf("Cshot")) + File.separator;
    }

    private static void a(boolean z2, a aVar, Uri uri) {
        OppoExifInterface oppoExifInterface;
        boolean z3 = z2;
        a aVar2 = aVar;
        long currentTimeMillis = System.currentTimeMillis();
        com.oppo.camera.m.b bVar = new com.oppo.camera.m.b(z3);
        if (aVar2.f3178b != null) {
            oppoExifInterface = com.oppo.camera.m.a.a(aVar2.f3178b, aVar2.n);
        } else {
            oppoExifInterface = e(aVar);
        }
        OppoExifInterface oppoExifInterface2 = oppoExifInterface;
        if (z3) {
            com.oppo.camera.m.a.a(aVar2, y);
            bVar.a(aVar2.N, aVar2.v, 95, oppoExifInterface2, aVar2.f3177a, uri);
            bVar.a();
        } else {
            byte[] bArr = aVar2.e;
            int i2 = aVar2.q;
            OppoExifInterface oppoExifInterface3 = oppoExifInterface2;
            int i3 = aVar2.r;
            bVar.a(bArr, oppoExifInterface3, i2, i3, aVar2.s, aVar2.t, 1, 95, aVar2.v, aVar2.f3177a, uri);
            bVar.a();
        }
        e.b("Storage", "processHeicEncode, costTime: " + (System.currentTimeMillis() - currentTimeMillis));
    }

    /* compiled from: Storage */
    public static class a {
        public e.a A = null;
        public e.a B = null;
        public boolean C = false;
        public boolean D = false;
        public boolean E = false;
        public boolean F = false;
        public String G = null;
        public String H = null;
        public String I = null;
        public long J = 0;
        public boolean K = false;
        public com.oppo.camera.a.e L = null;
        public Bitmap M = null;
        public Bitmap N = null;
        public d O = null;
        public boolean P = false;
        public int Q = 0;
        public boolean R = false;
        public boolean S = false;
        public boolean T = false;
        public e.b U = null;
        public g V = null;

        /* renamed from: a  reason: collision with root package name */
        public ContentResolver f3177a = null;

        /* renamed from: b  reason: collision with root package name */
        public ApsExifData f3178b = null;
        public Uri c = null;
        public Location d = null;
        public byte[] e = null;
        public byte[] f = null;
        public Bitmap g = null;
        public String h = null;
        public String i = null;
        public String j = null;
        public String k = null;
        public d.a l = null;
        public String m = null;
        public long n = 0;
        public long o = -1;
        public int p = -1;
        public int q = 0;
        public int r = 0;
        public int s = 0;
        public int t = 0;
        public int u = 0;
        public int v = 0;
        public int w = 0;
        public boolean x = false;
        public boolean y = false;
        public boolean z = false;

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("CameraPicture: [width: ");
            sb.append(this.q);
            sb.append(", height: ");
            sb.append(this.r);
            sb.append(", mStride: ");
            sb.append(this.s);
            sb.append(", mScanline: ");
            sb.append(this.t);
            sb.append(", jpegName: ");
            sb.append(this.i);
            sb.append(", mBurstShotFlagId: ");
            sb.append(this.o);
            sb.append(", mCshotPath: ");
            sb.append(this.m);
            sb.append(", cameraId: ");
            sb.append(this.u);
            sb.append(", format: ");
            sb.append(this.j);
            sb.append(", mMarkerNote: ");
            sb.append(this.H);
            sb.append(", mRecBurstNum: ");
            sb.append(this.p);
            sb.append(", mTitle: ");
            sb.append(this.h);
            sb.append(", mDate: ");
            sb.append(this.n);
            sb.append(", mCapMode: ");
            sb.append(this.k);
            sb.append(", mbWriteExifByApp: ");
            sb.append(this.E);
            sb.append(", picture data: ");
            byte[] bArr = this.e;
            sb.append(bArr != null ? Integer.valueOf(bArr.length) : null);
            sb.append(", mbNeedStoreImage: ");
            sb.append(this.x);
            sb.append(", uri: ");
            sb.append(this.c);
            sb.append(", mbIsSuperTextOpen: ");
            sb.append(this.T);
            sb.append("]");
            return sb.toString();
        }
    }
}
