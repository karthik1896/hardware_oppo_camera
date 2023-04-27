package com.oppo.camera.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import b.a.a;
import com.oppo.camera.e;
import com.oppo.camera.z;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Comparator;

/* compiled from: ThumbnailCacheUtil */
public class g {

    /* renamed from: a  reason: collision with root package name */
    private b.a.a f4622a;

    /* renamed from: b  reason: collision with root package name */
    private FileFilter f4623b;
    private Comparator<File> c;

    /* compiled from: ThumbnailCacheUtil */
    private static class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final g f4628a = new g();
    }

    private g() {
        this.f4622a = null;
        this.f4623b = new FileFilter() {
            /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
                r2 = r2.getName();
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public boolean accept(java.io.File r2) {
                /*
                    r1 = this;
                    boolean r0 = r2.isFile()
                    if (r0 == 0) goto L_0x0016
                    java.lang.String r2 = r2.getName()
                    if (r2 == 0) goto L_0x0016
                    java.lang.String r0 = "IMG"
                    boolean r2 = r2.startsWith(r0)
                    if (r2 == 0) goto L_0x0016
                    r2 = 1
                    return r2
                L_0x0016:
                    r2 = 0
                    return r2
                */
                throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.util.g.AnonymousClass3.accept(java.io.File):boolean");
            }
        };
        this.c = new Comparator<File>() {
            /* renamed from: a */
            public int compare(File file, File file2) {
                long lastModified = file.lastModified() - file2.lastModified();
                if (lastModified > 0) {
                    return -1;
                }
                return 0 == lastModified ? 0 : 1;
            }
        };
    }

    public static g a() {
        return a.f4628a;
    }

    private b.a.a a(String str, boolean z) {
        b.a.a aVar;
        File file = new File(str);
        if (!z || !file.exists() || ((aVar = this.f4622a) != null && aVar.b())) {
            b.a.a aVar2 = this.f4622a;
            if (aVar2 != null) {
                try {
                    aVar2.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (!file.exists()) {
                file.mkdirs();
            }
            try {
                return b.a.a.a(file, 1, 1, 52428800);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return this.f4622a;
    }

    private boolean a(Bitmap bitmap, a.C0041a aVar) {
        e.a("ThumbnailCacheUtil", "saveBitmapToDiskLruCache");
        if (bitmap == null) {
            e.e("ThumbnailCacheUtil", "saveBitmapToDiskLruCache, bitmap: " + bitmap);
            return false;
        }
        OutputStream outputStream = null;
        try {
            OutputStream a2 = aVar.a(0);
            boolean compress = bitmap.compress(Bitmap.CompressFormat.JPEG, 75, a2);
            if (!compress) {
                e.e("ThumbnailCacheUtil", "saveBitmapToDiskLruCache, bitmap compress fail, byte count: " + bitmap.getByteCount() + ", isRecycled: " + bitmap.isRecycled() + ", width: " + bitmap.getWidth() + ", height: " + bitmap.getHeight());
            }
            a2.flush();
            if (a2 != null) {
                try {
                    a2.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            e.a("ThumbnailCacheUtil", "saveBitmapToDiskLruCache X");
            return compress;
        } catch (Exception e2) {
            e2.printStackTrace();
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
            }
            e.a("ThumbnailCacheUtil", "saveBitmapToDiskLruCache X");
            return false;
        } catch (Throwable th) {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
            }
            e.a("ThumbnailCacheUtil", "saveBitmapToDiskLruCache X");
            throw th;
        }
    }

    public void a(String str, Bitmap bitmap) {
        if (this.f4622a == null) {
            this.f4622a = a(z.b(), false);
        } else {
            this.f4622a = a(z.b(), true);
        }
        b.a.a aVar = this.f4622a;
        if (aVar == null) {
            e.e("ThumbnailCacheUtil", "saveSmallImageForGallery, mDiskLruCache null");
            return;
        }
        try {
            a.C0041a b2 = aVar.b(str);
            if (b2 != null) {
                if (a(bitmap, b2)) {
                    b2.a();
                } else {
                    b2.b();
                }
                this.f4622a.c();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:49:0x008b A[SYNTHETIC, Splitter:B:49:0x008b] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0093 A[Catch:{ IOException -> 0x008f }] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x009f A[SYNTHETIC, Splitter:B:60:0x009f] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00a7 A[Catch:{ IOException -> 0x00a3 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.graphics.Bitmap a(java.lang.String r7) {
        /*
            r6 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "getThumbnailBitmapFromCache, title: "
            r0.append(r1)
            r0.append(r7)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "ThumbnailCacheUtil"
            com.oppo.camera.e.a(r1, r0)
            r0 = 0
            b.a.a r2 = r6.f4622a     // Catch:{ Exception -> 0x0083, all -> 0x0080 }
            r3 = 0
            if (r2 != 0) goto L_0x0027
            java.lang.String r2 = com.oppo.camera.z.b()     // Catch:{ Exception -> 0x0083, all -> 0x0080 }
            b.a.a r2 = r6.a((java.lang.String) r2, (boolean) r3)     // Catch:{ Exception -> 0x0083, all -> 0x0080 }
            r6.f4622a = r2     // Catch:{ Exception -> 0x0083, all -> 0x0080 }
            goto L_0x0032
        L_0x0027:
            java.lang.String r2 = com.oppo.camera.z.b()     // Catch:{ Exception -> 0x0083, all -> 0x0080 }
            r4 = 1
            b.a.a r2 = r6.a((java.lang.String) r2, (boolean) r4)     // Catch:{ Exception -> 0x0083, all -> 0x0080 }
            r6.f4622a = r2     // Catch:{ Exception -> 0x0083, all -> 0x0080 }
        L_0x0032:
            b.a.a r2 = r6.f4622a     // Catch:{ Exception -> 0x0083, all -> 0x0080 }
            if (r2 != 0) goto L_0x003c
            java.lang.String r7 = "getThumbnailBitmapFromCache, mDiskLruCache null"
            com.oppo.camera.e.e(r1, r7)     // Catch:{ Exception -> 0x0083, all -> 0x0080 }
            return r0
        L_0x003c:
            b.a.a r2 = r6.f4622a     // Catch:{ Exception -> 0x0083, all -> 0x0080 }
            b.a.a$c r7 = r2.a((java.lang.String) r7)     // Catch:{ Exception -> 0x0083, all -> 0x0080 }
            if (r7 != 0) goto L_0x0054
            java.lang.String r2 = "getThumbnailBitmapFromCache, snapShot null"
            com.oppo.camera.e.e(r1, r2)     // Catch:{ Exception -> 0x007b, all -> 0x0077 }
            if (r7 == 0) goto L_0x0053
            r7.close()     // Catch:{ IOException -> 0x004f }
            goto L_0x0053
        L_0x004f:
            r7 = move-exception
            r7.printStackTrace()
        L_0x0053:
            return r0
        L_0x0054:
            java.io.InputStream r1 = r7.a(r3)     // Catch:{ Exception -> 0x007b, all -> 0x0077 }
            android.graphics.Bitmap r0 = android.graphics.BitmapFactory.decodeStream(r1)     // Catch:{ Exception -> 0x0072, all -> 0x006e }
            if (r1 == 0) goto L_0x0064
            r1.close()     // Catch:{ IOException -> 0x0062 }
            goto L_0x0064
        L_0x0062:
            r7 = move-exception
            goto L_0x006a
        L_0x0064:
            if (r7 == 0) goto L_0x006d
            r7.close()     // Catch:{ IOException -> 0x0062 }
            goto L_0x006d
        L_0x006a:
            r7.printStackTrace()
        L_0x006d:
            return r0
        L_0x006e:
            r0 = move-exception
            r2 = r7
            r7 = r0
            goto L_0x009c
        L_0x0072:
            r2 = move-exception
            r5 = r2
            r2 = r7
            r7 = r5
            goto L_0x0086
        L_0x0077:
            r1 = move-exception
            r2 = r7
            r7 = r1
            goto L_0x009d
        L_0x007b:
            r1 = move-exception
            r2 = r7
            r7 = r1
            r1 = r0
            goto L_0x0086
        L_0x0080:
            r7 = move-exception
            r2 = r0
            goto L_0x009d
        L_0x0083:
            r7 = move-exception
            r1 = r0
            r2 = r1
        L_0x0086:
            r7.printStackTrace()     // Catch:{ all -> 0x009b }
            if (r1 == 0) goto L_0x0091
            r1.close()     // Catch:{ IOException -> 0x008f }
            goto L_0x0091
        L_0x008f:
            r7 = move-exception
            goto L_0x0097
        L_0x0091:
            if (r2 == 0) goto L_0x009a
            r2.close()     // Catch:{ IOException -> 0x008f }
            goto L_0x009a
        L_0x0097:
            r7.printStackTrace()
        L_0x009a:
            return r0
        L_0x009b:
            r7 = move-exception
        L_0x009c:
            r0 = r1
        L_0x009d:
            if (r0 == 0) goto L_0x00a5
            r0.close()     // Catch:{ IOException -> 0x00a3 }
            goto L_0x00a5
        L_0x00a3:
            r0 = move-exception
            goto L_0x00ab
        L_0x00a5:
            if (r2 == 0) goto L_0x00ae
            r2.close()     // Catch:{ IOException -> 0x00a3 }
            goto L_0x00ae
        L_0x00ab:
            r0.printStackTrace()
        L_0x00ae:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.util.g.a(java.lang.String):android.graphics.Bitmap");
    }

    public void b(String str) {
        if (this.f4622a == null) {
            this.f4622a = a(z.b(), false);
        } else {
            this.f4622a = a(z.b(), true);
        }
        b.a.a aVar = this.f4622a;
        if (aVar == null) {
            e.e("ThumbnailCacheUtil", "removeSmallImageForGallery, mDiskLruCache null");
            return;
        }
        try {
            aVar.c(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void b() {
        new Thread(new Runnable() {
            public void run() {
                g.this.d();
            }
        }, "clearOldSmallImagesThread").start();
    }

    /* access modifiers changed from: private */
    public void d() {
        e.a("ThumbnailCacheUtil", "clearOldSmallImages");
        if (this.f4622a == null) {
            this.f4622a = a(z.b(), false);
        } else {
            this.f4622a = a(z.b(), true);
        }
        b.a.a aVar = this.f4622a;
        if (aVar == null) {
            e.e("ThumbnailCacheUtil", "clearOldSmallImages, mDiskLruCache null");
            return;
        }
        File a2 = aVar.a();
        if (a2 == null) {
            e.d("ThumbnailCacheUtil", "clearOldSmallImages, directory null");
            return;
        }
        File[] listFiles = a2.listFiles(this.f4623b);
        if (listFiles == null) {
            e.e("ThumbnailCacheUtil", "clearOldSmallImages, files null");
            return;
        }
        for (File file : listFiles) {
            String name = file.getName();
            long currentTimeMillis = System.currentTimeMillis() - file.lastModified();
            if ((name != null && currentTimeMillis > 300000) || currentTimeMillis < 0) {
                String substring = name.substring(0, name.indexOf("."));
                try {
                    this.f4622a.c(substring);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                e.a("ThumbnailCacheUtil", "clearOldSmallImages, title: " + substring + ", timeGap: " + currentTimeMillis);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x009b A[SYNTHETIC, Splitter:B:31:0x009b] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00a6 A[SYNTHETIC, Splitter:B:36:0x00a6] */
    /* JADX WARNING: Removed duplicated region for block: B:43:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b(java.lang.String r6, android.graphics.Bitmap r7) {
        /*
            r5 = this;
            java.lang.String r0 = "ThumbnailCacheUtil"
            if (r7 != 0) goto L_0x000a
            java.lang.String r6 = "saveSmallImageForGalleryFile, bitmap is null"
            com.oppo.camera.e.e(r0, r6)
            return
        L_0x000a:
            java.io.File r1 = new java.io.File
            java.lang.String r2 = com.oppo.camera.z.b()
            r1.<init>(r2)
            boolean r2 = r1.exists()
            if (r2 != 0) goto L_0x0020
            java.lang.String r2 = com.oppo.camera.z.b()
            com.oppo.camera.q.a.f(r2)
        L_0x0020:
            java.io.FileFilter r2 = r5.f4623b
            java.io.File[] r1 = r1.listFiles(r2)
            if (r1 == 0) goto L_0x003f
            int r2 = r1.length
            r3 = 30
            if (r2 < r3) goto L_0x003f
            java.util.Comparator<java.io.File> r2 = r5.c
            java.util.Arrays.sort(r1, r2)
            r2 = 29
        L_0x0034:
            int r3 = r1.length
            if (r2 >= r3) goto L_0x003f
            r3 = r1[r2]
            r3.delete()
            int r2 = r2 + 1
            goto L_0x0034
        L_0x003f:
            r1 = 0
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x0095 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0095 }
            r3.<init>()     // Catch:{ IOException -> 0x0095 }
            java.lang.String r4 = com.oppo.camera.z.b()     // Catch:{ IOException -> 0x0095 }
            r3.append(r4)     // Catch:{ IOException -> 0x0095 }
            java.lang.String r4 = java.io.File.separator     // Catch:{ IOException -> 0x0095 }
            r3.append(r4)     // Catch:{ IOException -> 0x0095 }
            r3.append(r6)     // Catch:{ IOException -> 0x0095 }
            java.lang.String r4 = "_tmp.jpg"
            r3.append(r4)     // Catch:{ IOException -> 0x0095 }
            java.lang.String r3 = r3.toString()     // Catch:{ IOException -> 0x0095 }
            r2.<init>(r3)     // Catch:{ IOException -> 0x0095 }
            android.graphics.Bitmap$CompressFormat r1 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch:{ IOException -> 0x0090, all -> 0x008d }
            r3 = 75
            boolean r7 = r7.compress(r1, r3, r2)     // Catch:{ IOException -> 0x0090, all -> 0x008d }
            r2.flush()     // Catch:{ IOException -> 0x0090, all -> 0x008d }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0090, all -> 0x008d }
            r1.<init>()     // Catch:{ IOException -> 0x0090, all -> 0x008d }
            java.lang.String r3 = "saveSmallImageForGalleryFile, title: "
            r1.append(r3)     // Catch:{ IOException -> 0x0090, all -> 0x008d }
            r1.append(r6)     // Catch:{ IOException -> 0x0090, all -> 0x008d }
            java.lang.String r6 = ", isCompressed: "
            r1.append(r6)     // Catch:{ IOException -> 0x0090, all -> 0x008d }
            r1.append(r7)     // Catch:{ IOException -> 0x0090, all -> 0x008d }
            java.lang.String r6 = r1.toString()     // Catch:{ IOException -> 0x0090, all -> 0x008d }
            com.oppo.camera.e.a(r0, r6)     // Catch:{ IOException -> 0x0090, all -> 0x008d }
            r2.close()     // Catch:{ IOException -> 0x009f }
            goto L_0x00a3
        L_0x008d:
            r6 = move-exception
            r1 = r2
            goto L_0x00a4
        L_0x0090:
            r6 = move-exception
            r1 = r2
            goto L_0x0096
        L_0x0093:
            r6 = move-exception
            goto L_0x00a4
        L_0x0095:
            r6 = move-exception
        L_0x0096:
            r6.printStackTrace()     // Catch:{ all -> 0x0093 }
            if (r1 == 0) goto L_0x00a3
            r1.close()     // Catch:{ IOException -> 0x009f }
            goto L_0x00a3
        L_0x009f:
            r6 = move-exception
            r6.printStackTrace()
        L_0x00a3:
            return
        L_0x00a4:
            if (r1 == 0) goto L_0x00ae
            r1.close()     // Catch:{ IOException -> 0x00aa }
            goto L_0x00ae
        L_0x00aa:
            r7 = move-exception
            r7.printStackTrace()
        L_0x00ae:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.util.g.b(java.lang.String, android.graphics.Bitmap):void");
    }

    public Bitmap c(String str) {
        e.a("ThumbnailCacheUtil", "getThumbnailBitmapFromPrivateCache, title: " + str);
        File file = new File(z.b() + File.separator + str + "_tmp.jpg");
        if (!file.exists()) {
            return null;
        }
        return BitmapFactory.decodeFile(file.getAbsolutePath());
    }

    public void c() {
        new Thread(new Runnable() {
            public void run() {
                g.this.e();
            }
        }, "clearOldSmallImageFilesThread").start();
    }

    /* access modifiers changed from: private */
    public void e() {
        e.a("ThumbnailCacheUtil", "clearOldSmallImageFiles");
        File[] listFiles = new File(z.b()).listFiles(this.f4623b);
        if (listFiles == null) {
            e.e("ThumbnailCacheUtil", "clearOldSmallImageFiles, files null");
            return;
        }
        for (File file : listFiles) {
            long currentTimeMillis = System.currentTimeMillis() - file.lastModified();
            if (currentTimeMillis > 300000 || currentTimeMillis < 0) {
                file.delete();
                e.a("ThumbnailCacheUtil", "clearOldSmallImageFiles, fileName: " + file.getName() + ", timeGap: " + currentTimeMillis);
            }
        }
    }
}
