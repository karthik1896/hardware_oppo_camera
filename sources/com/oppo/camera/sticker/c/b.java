package com.oppo.camera.sticker.c;

import android.content.Context;
import android.net.Uri;
import android.os.FileUtils;
import android.system.ErrnoException;
import android.system.Os;
import android.text.TextUtils;
import com.oppo.camera.aps.constant.ApsConstant;
import com.oppo.camera.e;
import com.oppo.camera.sticker.provider.FileProvider;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* compiled from: FileUtils */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final String f3642a = (File.separator + ApsConstant.CAPTURE_MODE_STICKER);

    /* renamed from: b  reason: collision with root package name */
    public static final String f3643b = (File.separator + "category");
    public static final String c = (File.separator + "material");
    public static final String d = (File.separator + "multi");
    public static final String e = (File.separator + "animoji");
    public static final String f = (File.separator + "icon");
    public static final String g = (f3642a + f3643b);
    public static final String h = (f3642a + c);
    public static final String i = (h + d);
    public static final String j = (h + e);
    public static final String k = (f3642a + File.separator + "tmp");
    public static final String l;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append(f3642a);
        sb.append(f);
        l = sb.toString();
    }

    public static String a(String str) {
        String[] split = str.split("/");
        return (split == null || split.length <= 0) ? str : split[split.length - 1];
    }

    public static synchronized String a(Context context, String str, String str2) {
        String str3;
        synchronized (b.class) {
            str3 = context.getFilesDir() + str + File.separator + str2;
            File parentFile = new File(str3).getParentFile();
            if (parentFile != null && !parentFile.exists() && !parentFile.mkdirs()) {
                e.d("FileUtils", "getFileSavePath, mkdirs fail! filePath: " + str3);
            }
        }
        return str3;
    }

    /* JADX WARNING: Removed duplicated region for block: B:104:0x00ff A[SYNTHETIC, Splitter:B:104:0x00ff] */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x0116 A[SYNTHETIC, Splitter:B:116:0x0116] */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x00e9 A[SYNTHETIC, Splitter:B:92:0x00e9] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:89:0x00e4=Splitter:B:89:0x00e4, B:101:0x00fa=Splitter:B:101:0x00fa} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(java.io.InputStream r5, java.lang.String r6, boolean r7, boolean r8) throws java.io.IOException {
        /*
            r0 = 0
            if (r5 == 0) goto L_0x012b
            r1 = 0
            boolean r2 = android.text.TextUtils.isEmpty(r6)     // Catch:{ FileNotFoundException -> 0x00f9, IOException -> 0x00e3 }
            if (r2 == 0) goto L_0x000c
            goto L_0x012b
        L_0x000c:
            java.io.File r2 = new java.io.File     // Catch:{ FileNotFoundException -> 0x00f9, IOException -> 0x00e3 }
            r2.<init>(r6)     // Catch:{ FileNotFoundException -> 0x00f9, IOException -> 0x00e3 }
            boolean r6 = r2.exists()     // Catch:{ FileNotFoundException -> 0x00f9, IOException -> 0x00e3 }
            java.lang.String r3 = "FileUtils"
            if (r6 == 0) goto L_0x005d
            if (r7 == 0) goto L_0x004b
            boolean r6 = r2.delete()     // Catch:{ FileNotFoundException -> 0x00f9, IOException -> 0x00e3 }
            if (r6 != 0) goto L_0x0033
            java.lang.String r6 = "saveInputStream, delete exist file fail!"
            com.oppo.camera.e.d(r3, r6)     // Catch:{ FileNotFoundException -> 0x00f9, IOException -> 0x00e3 }
            if (r8 == 0) goto L_0x0032
            if (r5 == 0) goto L_0x0032
            r5.close()     // Catch:{ IOException -> 0x002e }
            goto L_0x0032
        L_0x002e:
            r5 = move-exception
            r5.printStackTrace()
        L_0x0032:
            return r0
        L_0x0033:
            boolean r6 = r2.createNewFile()     // Catch:{ FileNotFoundException -> 0x00f9, IOException -> 0x00e3 }
            if (r6 != 0) goto L_0x00aa
            java.lang.String r6 = "saveInputStream, createNewFile fail!"
            com.oppo.camera.e.d(r3, r6)     // Catch:{ FileNotFoundException -> 0x00f9, IOException -> 0x00e3 }
            if (r8 == 0) goto L_0x004a
            if (r5 == 0) goto L_0x004a
            r5.close()     // Catch:{ IOException -> 0x0046 }
            goto L_0x004a
        L_0x0046:
            r5 = move-exception
            r5.printStackTrace()
        L_0x004a:
            return r0
        L_0x004b:
            java.lang.String r6 = "saveInputStream, file is exist!"
            com.oppo.camera.e.b(r3, r6)     // Catch:{ FileNotFoundException -> 0x00f9, IOException -> 0x00e3 }
            if (r8 == 0) goto L_0x005c
            if (r5 == 0) goto L_0x005c
            r5.close()     // Catch:{ IOException -> 0x0058 }
            goto L_0x005c
        L_0x0058:
            r5 = move-exception
            r5.printStackTrace()
        L_0x005c:
            return r0
        L_0x005d:
            java.io.File r6 = r2.getParentFile()     // Catch:{ FileNotFoundException -> 0x00f9, IOException -> 0x00e3 }
            if (r6 == 0) goto L_0x0090
            boolean r4 = r6.exists()     // Catch:{ FileNotFoundException -> 0x00f9, IOException -> 0x00e3 }
            if (r4 != 0) goto L_0x0090
            boolean r6 = r6.mkdirs()     // Catch:{ FileNotFoundException -> 0x00f9, IOException -> 0x00e3 }
            if (r6 != 0) goto L_0x0090
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x00f9, IOException -> 0x00e3 }
            r6.<init>()     // Catch:{ FileNotFoundException -> 0x00f9, IOException -> 0x00e3 }
            java.lang.String r2 = "saveInputStream, mkdirs fail!, replace: "
            r6.append(r2)     // Catch:{ FileNotFoundException -> 0x00f9, IOException -> 0x00e3 }
            r6.append(r7)     // Catch:{ FileNotFoundException -> 0x00f9, IOException -> 0x00e3 }
            java.lang.String r6 = r6.toString()     // Catch:{ FileNotFoundException -> 0x00f9, IOException -> 0x00e3 }
            com.oppo.camera.e.d(r3, r6)     // Catch:{ FileNotFoundException -> 0x00f9, IOException -> 0x00e3 }
            if (r8 == 0) goto L_0x008f
            if (r5 == 0) goto L_0x008f
            r5.close()     // Catch:{ IOException -> 0x008b }
            goto L_0x008f
        L_0x008b:
            r5 = move-exception
            r5.printStackTrace()
        L_0x008f:
            return r0
        L_0x0090:
            boolean r6 = r2.createNewFile()     // Catch:{ FileNotFoundException -> 0x00f9, IOException -> 0x00e3 }
            if (r6 != 0) goto L_0x00aa
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x00f9, IOException -> 0x00e3 }
            r6.<init>()     // Catch:{ FileNotFoundException -> 0x00f9, IOException -> 0x00e3 }
            java.lang.String r4 = "saveInputStream, createNewFile fail!, replace: "
            r6.append(r4)     // Catch:{ FileNotFoundException -> 0x00f9, IOException -> 0x00e3 }
            r6.append(r7)     // Catch:{ FileNotFoundException -> 0x00f9, IOException -> 0x00e3 }
            java.lang.String r6 = r6.toString()     // Catch:{ FileNotFoundException -> 0x00f9, IOException -> 0x00e3 }
            com.oppo.camera.e.d(r3, r6)     // Catch:{ FileNotFoundException -> 0x00f9, IOException -> 0x00e3 }
        L_0x00aa:
            java.io.FileOutputStream r6 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x00f9, IOException -> 0x00e3 }
            r6.<init>(r2)     // Catch:{ FileNotFoundException -> 0x00f9, IOException -> 0x00e3 }
            r7 = 1024(0x400, float:1.435E-42)
            byte[] r7 = new byte[r7]     // Catch:{ FileNotFoundException -> 0x00dd, IOException -> 0x00d9, all -> 0x00d5 }
        L_0x00b3:
            int r1 = r7.length     // Catch:{ FileNotFoundException -> 0x00dd, IOException -> 0x00d9, all -> 0x00d5 }
            int r1 = r5.read(r7, r0, r1)     // Catch:{ FileNotFoundException -> 0x00dd, IOException -> 0x00d9, all -> 0x00d5 }
            r2 = -1
            if (r1 == r2) goto L_0x00bf
            r6.write(r7, r0, r1)     // Catch:{ FileNotFoundException -> 0x00dd, IOException -> 0x00d9, all -> 0x00d5 }
            goto L_0x00b3
        L_0x00bf:
            r7 = 1
            r6.close()     // Catch:{ IOException -> 0x00c4 }
            goto L_0x00c8
        L_0x00c4:
            r6 = move-exception
            r6.printStackTrace()
        L_0x00c8:
            if (r8 == 0) goto L_0x00d4
            if (r5 == 0) goto L_0x00d4
            r5.close()     // Catch:{ IOException -> 0x00d0 }
            goto L_0x00d4
        L_0x00d0:
            r5 = move-exception
            r5.printStackTrace()
        L_0x00d4:
            return r7
        L_0x00d5:
            r7 = move-exception
            r1 = r6
            r6 = r7
            goto L_0x0114
        L_0x00d9:
            r7 = move-exception
            r1 = r6
            r6 = r7
            goto L_0x00e4
        L_0x00dd:
            r7 = move-exception
            r1 = r6
            r6 = r7
            goto L_0x00fa
        L_0x00e1:
            r6 = move-exception
            goto L_0x0114
        L_0x00e3:
            r6 = move-exception
        L_0x00e4:
            r6.printStackTrace()     // Catch:{ all -> 0x00e1 }
            if (r1 == 0) goto L_0x00f1
            r1.close()     // Catch:{ IOException -> 0x00ed }
            goto L_0x00f1
        L_0x00ed:
            r6 = move-exception
            r6.printStackTrace()
        L_0x00f1:
            if (r8 == 0) goto L_0x0113
            if (r5 == 0) goto L_0x0113
            r5.close()     // Catch:{ IOException -> 0x010f }
            goto L_0x0113
        L_0x00f9:
            r6 = move-exception
        L_0x00fa:
            r6.printStackTrace()     // Catch:{ all -> 0x00e1 }
            if (r1 == 0) goto L_0x0107
            r1.close()     // Catch:{ IOException -> 0x0103 }
            goto L_0x0107
        L_0x0103:
            r6 = move-exception
            r6.printStackTrace()
        L_0x0107:
            if (r8 == 0) goto L_0x0113
            if (r5 == 0) goto L_0x0113
            r5.close()     // Catch:{ IOException -> 0x010f }
            goto L_0x0113
        L_0x010f:
            r5 = move-exception
            r5.printStackTrace()
        L_0x0113:
            return r0
        L_0x0114:
            if (r1 == 0) goto L_0x011e
            r1.close()     // Catch:{ IOException -> 0x011a }
            goto L_0x011e
        L_0x011a:
            r7 = move-exception
            r7.printStackTrace()
        L_0x011e:
            if (r8 == 0) goto L_0x012a
            if (r5 == 0) goto L_0x012a
            r5.close()     // Catch:{ IOException -> 0x0126 }
            goto L_0x012a
        L_0x0126:
            r5 = move-exception
            r5.printStackTrace()
        L_0x012a:
            throw r6
        L_0x012b:
            if (r8 == 0) goto L_0x0137
            if (r5 == 0) goto L_0x0137
            r5.close()     // Catch:{ IOException -> 0x0133 }
            goto L_0x0137
        L_0x0133:
            r5 = move-exception
            r5.printStackTrace()
        L_0x0137:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.sticker.c.b.a(java.io.InputStream, java.lang.String, boolean, boolean):boolean");
    }

    public static synchronized boolean a(File file) {
        boolean z;
        synchronized (b.class) {
            if (file != null) {
                z = !file.exists() || file.delete();
            } else {
                throw new IllegalArgumentException("deleteExistFile, file is null!");
            }
        }
        return z;
    }

    public static synchronized boolean b(String str) {
        synchronized (b.class) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            boolean a2 = a(new File(str));
            return a2;
        }
    }

    public static boolean a(File file, File file2) {
        if (file == null || file2 == null) {
            e.d("FileUtils", "copyFile, srcFile or dest file is null! srcFile: " + file);
            return false;
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            if (file2.exists()) {
                file2.delete();
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            FileUtils.copy(fileInputStream, fileOutputStream);
            Os.fsync(fileOutputStream.getFD());
            return true;
        } catch (ErrnoException | IOException unused) {
            e.e("FileUtils", "copyFile, catch exception");
            return false;
        }
    }

    public static boolean b(File file, File file2) {
        if (!a(file, file2)) {
            return false;
        }
        if (file.delete()) {
            return true;
        }
        e.d("FileUtils", "cutFile, delete srcFile fail! srcFile: " + file);
        return true;
    }

    public static boolean a(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            return b(new File(str), new File(str2));
        }
        e.d("FileUtils", "cutFile, srcFilePath or desFilePath is empty! srcFilePath: " + str);
        return false;
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [java.lang.String, java.io.InputStream] */
    public static String a(ZipFile zipFile, ZipEntry zipEntry) throws Exception {
        InputStream inputStream = 0;
        if (zipFile == null || zipEntry == null) {
            e.d("FileUtils", "getFileContentFromZipEntry null parameter! zipFile: " + zipFile);
            return inputStream;
        }
        try {
            inputStream = zipFile.getInputStream(zipEntry);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr, 0, 1024);
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
            return new String(byteArrayOutputStream.toByteArray(), "UTF-8");
        } finally {
            if (inputStream != 0) {
                try {
                    inputStream.close();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public static boolean c(String str) {
        if (TextUtils.isEmpty(str)) {
            e.d("FileUtils", "deleteAllFilesFromPath, empty path");
            return false;
        }
        File file = new File(str);
        if (file.isFile()) {
            e.d("FileUtils", "deleteAllFilesFromPath, is a file, not path");
            return false;
        }
        File[] listFiles = file.listFiles();
        if (!(listFiles == null || listFiles.length == 0)) {
            for (File file2 : listFiles) {
                if (!file2.isDirectory()) {
                    e.b("FileUtils", "deleteAllFilesFromPath, file: " + file2.getAbsolutePath());
                    if (!file2.delete()) {
                        e.d("FileUtils", "deleteAllFilesFromPath, delete file fail! path: " + file2.getAbsolutePath());
                        return false;
                    }
                } else if (!file2.delete()) {
                    c(file2.getAbsolutePath());
                }
            }
        }
        return true;
    }

    public static boolean a(Context context, String str) {
        try {
            Uri parse = Uri.parse(str);
            if (parse == null) {
                return false;
            }
            return a(FileProvider.a(context, parse));
        } catch (Exception e2) {
            e.d("FileUtils", "deleteFile, exception: " + e2);
            return false;
        }
    }
}
