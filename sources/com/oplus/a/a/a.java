package com.oplus.a.a;

import android.compat.annotation.UnsupportedAppUsage;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.CursorWrapper;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.provider.Downloads;
import android.text.TextUtils;
import android.util.Pair;
import com.android.providers.downloads.DownloadInfoData;
import com.android.providers.downloads.Downloads;
import com.oppo.camera.statistics.model.StickerMsgData;
import com.sensetime.stmobile.STCommon;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: DownloadManager */
public class a {
    @UnsupportedAppUsage

    /* renamed from: a  reason: collision with root package name */
    public static final String[] f2665a = {"_id", "local_filename", Downloads.Impl.COLUMN_MEDIAPROVIDER_URI, Downloads.Impl.COLUMN_DESTINATION, Downloads.Impl.COLUMN_TITLE, Downloads.Impl.COLUMN_DESCRIPTION, Downloads.Impl.COLUMN_URI, Downloads.Impl.COLUMN_STATUS, Downloads.Impl.COLUMN_FILE_NAME_HINT, "media_type", "total_size", "last_modified_timestamp", "bytes_so_far", Downloads.Impl.COLUMN_ALLOW_WRITE, "local_uri", "reason", Downloads.Impl.COLUMN_NOTIFICATION_PACKAGE, Downloads.Impl.COLUMN_IS_VISIBLE_IN_DOWNLOADS_UI, "download_speed"};

    /* renamed from: b  reason: collision with root package name */
    public static final String[] f2666b = {"_id", "_data AS local_filename", Downloads.Impl.COLUMN_MEDIAPROVIDER_URI, Downloads.Impl.COLUMN_DESTINATION, Downloads.Impl.COLUMN_TITLE, Downloads.Impl.COLUMN_DESCRIPTION, Downloads.Impl.COLUMN_URI, Downloads.Impl.COLUMN_STATUS, Downloads.Impl.COLUMN_FILE_NAME_HINT, Downloads.Impl.COLUMN_NOTIFICATION_PACKAGE, "mimetype AS media_type", "total_bytes AS total_size", "lastmod AS last_modified_timestamp", "current_bytes AS bytes_so_far", Downloads.Impl.COLUMN_ALLOW_WRITE, Downloads.Impl.COLUMN_IS_VISIBLE_IN_DOWNLOADS_UI, "download_speed", "'placeholder' AS local_uri", "'placeholder' AS reason"};
    static final /* synthetic */ boolean c = (!a.class.desiredAssertionStatus());
    private static a d;
    private static HandlerThread e = new HandlerThread("DownloadManager");
    /* access modifiers changed from: private */
    public static int n = 0;
    private final ContentResolver f;
    /* access modifiers changed from: private */
    public final String g;
    private Uri h = Downloads.Impl.CONTENT_URI;
    private boolean i;
    /* access modifiers changed from: private */
    public b j;
    /* access modifiers changed from: private */
    public b k;
    private c l;
    /* access modifiers changed from: private */
    public Handler m = new Handler(e.getLooper());

    /* compiled from: DownloadManager */
    public interface b {
        void a();
    }

    static {
        e.start();
    }

    /* compiled from: DownloadManager */
    public static class e {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ boolean f2676a = (!a.class.desiredAssertionStatus());

        /* renamed from: b  reason: collision with root package name */
        private int f2677b = 0;
        private Uri c;
        private Uri d;
        private List<Pair<String, String>> e = new ArrayList();
        private CharSequence f;
        private CharSequence g;
        private String h;
        private int i = 6;
        private boolean j = true;
        private boolean k = true;
        private int l = 0;
        private boolean m = false;
        private boolean n = false;
        private boolean o = false;
        private String p = null;
        private int q = 0;
        private boolean r = false;
        private int s = -1;
        private int t = -1;
        private long u = 0;
        private long v = -1;
        private Uri w;
        private String x = null;
        private String y = null;
        private int z = 1;

        public e(Uri uri) {
            if (uri != null) {
                String scheme = uri.getScheme();
                if (scheme == null || (!scheme.equals("http") && !scheme.equals("https"))) {
                    throw new IllegalArgumentException("Can only download HTTP/HTTPS URIs: " + uri);
                }
                this.c = uri;
                return;
            }
            throw new NullPointerException();
        }

        public e a(Uri uri) {
            this.d = uri;
            return this;
        }

        public e a(CharSequence charSequence) {
            this.f = charSequence;
            return this;
        }

        public e a(String str) {
            this.h = str;
            return this;
        }

        public e a(int i2) {
            this.i = i2;
            return this;
        }

        public e a(boolean z2) {
            this.j = z2;
            return this;
        }

        public e b(int i2) {
            this.z = i2;
            return this;
        }

        public e b(String str) {
            this.p = str;
            return this;
        }

        public e b(boolean z2) {
            this.r = z2;
            return this;
        }

        public e c(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.x = str;
            }
            return this;
        }

        /* access modifiers changed from: package-private */
        public ContentValues d(String str) {
            ContentValues contentValues = new ContentValues();
            if (f2676a || this.c != null) {
                contentValues.put(Downloads.Impl.COLUMN_URI, this.c.toString());
                contentValues.put(Downloads.Impl.COLUMN_IS_PUBLIC_API, true);
                contentValues.put(Downloads.Impl.COLUMN_NOTIFICATION_PACKAGE, str);
                int i2 = 2;
                if (this.d != null) {
                    contentValues.put(Downloads.Impl.COLUMN_DESTINATION, 4);
                    contentValues.put(Downloads.Impl.COLUMN_FILE_NAME_HINT, this.d.toString());
                } else {
                    contentValues.put(Downloads.Impl.COLUMN_DESTINATION, Integer.valueOf(this.n ? 5 : 2));
                }
                if (this.m) {
                    i2 = 0;
                }
                contentValues.put(Downloads.Impl.COLUMN_MEDIA_SCANNED, Integer.valueOf(i2));
                if (!this.e.isEmpty()) {
                    a(contentValues);
                }
                a(contentValues, Downloads.Impl.COLUMN_TITLE, this.f);
                a(contentValues, Downloads.Impl.COLUMN_DESCRIPTION, this.g);
                a(contentValues, Downloads.Impl.COLUMN_MIME_TYPE, this.h);
                contentValues.put(Downloads.Impl.COLUMN_VISIBILITY, Integer.valueOf(this.f2677b));
                contentValues.put(Downloads.Impl.COLUMN_ALLOWED_NETWORK_TYPES, Integer.valueOf(this.i));
                contentValues.put(Downloads.Impl.COLUMN_ALLOW_ROAMING, Boolean.valueOf(this.j));
                contentValues.put(Downloads.Impl.COLUMN_ALLOW_METERED, Boolean.valueOf(this.k));
                contentValues.put(Downloads.Impl.COLUMN_FLAGS, Integer.valueOf(this.l));
                contentValues.put(Downloads.Impl.COLUMN_IS_VISIBLE_IN_DOWNLOADS_UI, Integer.valueOf(this.z));
                if (this.o) {
                    contentValues.put(Downloads.Impl.COLUMN_CONTROL, 1);
                    contentValues.put(Downloads.Impl.COLUMN_STATUS, 193);
                }
                a(contentValues, "extra", this.p);
                contentValues.put("priority", Integer.valueOf(this.q));
                contentValues.put("relpace_file", Boolean.valueOf(this.r));
                contentValues.put("statistics_id", Integer.valueOf(this.s));
                contentValues.put("time_out", Long.valueOf(this.u));
                contentValues.put("fail_retry_count", Integer.valueOf(this.t));
                contentValues.put("time_interval_for_fail", Long.valueOf(this.v));
                Uri uri = this.w;
                if (uri != null) {
                    contentValues.put("backup_uri", uri.toString());
                }
                a(contentValues, "md5", this.x);
                a(contentValues, "header_md5", this.y);
                return contentValues;
            }
            throw new AssertionError();
        }

        private void a(ContentValues contentValues) {
            int i2 = 0;
            for (Pair next : this.e) {
                contentValues.put(Downloads.Impl.RequestHeaders.INSERT_KEY_PREFIX + i2, ((String) next.first) + ": " + ((String) next.second));
                i2++;
            }
        }

        private void a(ContentValues contentValues, String str, Object obj) {
            if (obj != null) {
                contentValues.put(str, obj.toString());
            }
        }
    }

    /* compiled from: DownloadManager */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        private long[] f2674a = null;

        /* renamed from: b  reason: collision with root package name */
        private String[] f2675b = null;
        private Integer c = null;
        private String d = null;
        private String e = Downloads.Impl.COLUMN_LAST_MODIFICATION;
        private int f = 2;
        private boolean g = false;
        private boolean h = false;
        private String[] i = null;
        private String j = null;
        private String[] k = null;

        public d a(long... jArr) {
            this.f2674a = jArr;
            return this;
        }

        public d a(String... strArr) {
            this.k = strArr;
            return this;
        }

        public d b(String... strArr) {
            this.f2675b = strArr;
            a.c(this.f2675b);
            return this;
        }

        public String[] a() {
            String[] strArr = this.i;
            if (strArr != null) {
                return strArr;
            }
            if (e()) {
                return a.f2665a;
            }
            return a.f2666b;
        }

        private boolean e() {
            return a.n > 0;
        }

        /* access modifiers changed from: package-private */
        public Cursor a(ContentResolver contentResolver, Uri uri) {
            try {
                return contentResolver.query(uri, a(), b(), d(), c());
            } catch (Exception e2) {
                com.oplus.a.a.a.a.d("DownloadManager", "runQuery, occur exception. e = " + e2.getMessage());
                return null;
            }
        }

        public String b() {
            ArrayList arrayList = new ArrayList();
            long[] jArr = this.f2674a;
            if (jArr != null) {
                arrayList.add(a.b(jArr));
            }
            String[] strArr = this.k;
            if (strArr != null) {
                arrayList.add(a.e(strArr));
            }
            if (com.oplus.a.a.a.a.f2669a) {
                com.oplus.a.a.a.a.a("DownloadManager", "getSelection , mPackageNames = " + Arrays.toString(this.f2675b) + ", this = " + this);
            }
            String[] strArr2 = this.f2675b;
            if (strArr2 != null) {
                arrayList.add(a.d(strArr2));
            }
            if (this.c != null) {
                ArrayList arrayList2 = new ArrayList();
                if ((this.c.intValue() & 1) != 0) {
                    arrayList2.add(a("=", 190));
                }
                if ((this.c.intValue() & 2) != 0) {
                    arrayList2.add(a("=", 192));
                }
                if ((this.c.intValue() & 4) != 0) {
                    arrayList2.add(a("=", 193));
                    arrayList2.add(a("=", 194));
                    arrayList2.add(a("=", 195));
                    arrayList2.add(a("=", 196));
                    arrayList2.add(a("=", 198));
                }
                if ((this.c.intValue() & 8) != 0) {
                    arrayList2.add(a("=", 200));
                }
                if ((this.c.intValue() & 16) != 0) {
                    arrayList2.add("(" + a(">=", 400) + " AND " + a("<", 600) + ")");
                    arrayList2.add(a("=", 199));
                }
                if (arrayList2.size() > 0) {
                    arrayList.add("(" + a(" OR ", (Iterable<String>) arrayList2) + ")");
                }
            }
            if (this.h) {
                arrayList.add("is_visible_in_downloads_ui != '0'");
            } else if (this.g) {
                arrayList.add("is_visible_in_downloads_ui = '1'");
            }
            arrayList.add("deleted != '1'");
            if (!TextUtils.isEmpty(this.j)) {
                arrayList.add("uri = '" + this.j + "'");
            }
            String a2 = a(" AND ", (Iterable<String>) arrayList);
            if (com.oplus.a.a.a.a.f2669a) {
                com.oplus.a.a.a.a.a("DownloadManager", "getSelection. selection = " + a2);
            }
            return a2;
        }

        public String c() {
            String str = this.f == 1 ? "ASC" : "DESC";
            return this.e + " " + str;
        }

        public String[] d() {
            String[] strArr = new String[0];
            String[] strArr2 = new String[0];
            String[] strArr3 = new String[0];
            long[] jArr = this.f2674a;
            if (jArr != null) {
                strArr = a.c(jArr);
            }
            String[] strArr4 = this.k;
            if (strArr4 != null) {
                strArr2 = strArr4;
            }
            String[] strArr5 = this.f2675b;
            if (strArr5 != null) {
                strArr3 = strArr5;
            }
            String[] a2 = a(strArr, strArr2, strArr3);
            a.c(a2);
            return a2;
        }

        private String a(String str, Iterable<String> iterable) {
            StringBuilder sb = new StringBuilder();
            boolean z = true;
            for (String next : iterable) {
                if (!z) {
                    sb.append(str);
                }
                sb.append(next);
                z = false;
            }
            return sb.toString();
        }

        private String a(String str, int i2) {
            return Downloads.Impl.COLUMN_STATUS + str + "'" + i2 + "'";
        }

        public String[] a(String[] strArr, String[]... strArr2) {
            if (strArr == null || strArr2 == null) {
                return null;
            }
            int length = strArr.length;
            for (String[] strArr3 : strArr2) {
                if (strArr3 != null && strArr3.length > 0) {
                    length += strArr3.length;
                }
            }
            String[] strArr4 = (String[]) Arrays.copyOf(strArr, length);
            int length2 = strArr.length;
            int i2 = length2;
            for (String[] strArr5 : strArr2) {
                if (strArr5 != null && strArr5.length > 0) {
                    System.arraycopy(strArr5, 0, strArr4, i2, strArr5.length);
                    i2 += strArr5.length;
                }
            }
            return strArr4;
        }
    }

    public static a a(Context context) {
        return a(context, (String) null);
    }

    public static synchronized a a(Context context, String str) {
        a aVar;
        synchronized (a.class) {
            if (d == null) {
                d = new a(context.getApplicationContext(), str);
            }
            aVar = d;
        }
        return aVar;
    }

    private a(Context context, String str) {
        if (context != null) {
            this.f = context.getContentResolver();
            String packageName = context.getPackageName();
            if (b(context).equalsIgnoreCase(packageName)) {
                this.g = null;
            } else {
                this.g = TextUtils.isEmpty(str) ? packageName : str;
            }
            if (com.oplus.a.a.a.a.f2669a) {
                com.oplus.a.a.a.a.b("DownloadManager", "DownloadManager. mPackageName = " + this.g);
            }
            this.i = context.getApplicationInfo().targetSdkVersion < 23;
            try {
                n = context.getPackageManager().getApplicationInfo("com.android.providers.downloads", 128).metaData.getInt("provider_version");
            } catch (Exception e2) {
                com.oplus.a.a.a.a.d("DownloadManager", "DownloadManager,exception: " + e2);
            }
        } else {
            throw new IllegalArgumentException("The context and resolver can't be null !");
        }
    }

    @UnsupportedAppUsage(maxTargetSdk = 28, trackingBug = 115609023)
    public void a(boolean z) {
        this.i = z;
    }

    public String a(e eVar) {
        try {
            Uri insert = this.f.insert(Downloads.Impl.CONTENT_URI, eVar.d(this.g));
            if (insert != null) {
                return a(Long.parseLong(insert.getLastPathSegment()));
            }
            com.oplus.a.a.a.a.d("DownloadManager", "enqueue, downloadUri = null, return -1.");
            return null;
        } catch (Exception e2) {
            com.oplus.a.a.a.a.d("DownloadManager", "enqueueWithUuid, occur exception. e = " + e2.getMessage());
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0050, code lost:
        if (r12 != null) goto L_0x0052;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0052, code lost:
        r12.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0073, code lost:
        if (r12 != null) goto L_0x0052;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0076, code lost:
        return null;
     */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x007a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String a(long r12) {
        /*
            r11 = this;
            java.lang.String r0 = "uuid"
            java.lang.String r1 = "DownloadManager"
            r2 = 1
            r3 = 0
            long[] r2 = new long[r2]     // Catch:{ Exception -> 0x0059, all -> 0x0056 }
            r4 = 0
            r2[r4] = r12     // Catch:{ Exception -> 0x0059, all -> 0x0056 }
            java.lang.String[] r7 = new java.lang.String[]{r0}     // Catch:{ Exception -> 0x0059, all -> 0x0056 }
            android.content.ContentResolver r5 = r11.f     // Catch:{ Exception -> 0x0059, all -> 0x0056 }
            android.net.Uri r6 = r11.h     // Catch:{ Exception -> 0x0059, all -> 0x0056 }
            java.lang.String r8 = b((long[]) r2)     // Catch:{ Exception -> 0x0059, all -> 0x0056 }
            java.lang.String[] r9 = c((long[]) r2)     // Catch:{ Exception -> 0x0059, all -> 0x0056 }
            r10 = 0
            android.database.Cursor r12 = r5.query(r6, r7, r8, r9, r10)     // Catch:{ Exception -> 0x0059, all -> 0x0056 }
            if (r12 == 0) goto L_0x0050
            boolean r13 = r12.moveToFirst()     // Catch:{ Exception -> 0x004e }
            if (r13 == 0) goto L_0x0050
            int r13 = r12.getColumnIndex(r0)     // Catch:{ Exception -> 0x004e }
            java.lang.String r13 = r12.getString(r13)     // Catch:{ Exception -> 0x004e }
            boolean r0 = com.oplus.a.a.a.a.f2669a     // Catch:{ Exception -> 0x004e }
            if (r0 == 0) goto L_0x0048
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x004e }
            r0.<init>()     // Catch:{ Exception -> 0x004e }
            java.lang.String r2 = "enqueueWithUuid, uuid ="
            r0.append(r2)     // Catch:{ Exception -> 0x004e }
            r0.append(r13)     // Catch:{ Exception -> 0x004e }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x004e }
            com.oplus.a.a.a.a.a(r1, r0)     // Catch:{ Exception -> 0x004e }
        L_0x0048:
            if (r12 == 0) goto L_0x004d
            r12.close()
        L_0x004d:
            return r13
        L_0x004e:
            r13 = move-exception
            goto L_0x005b
        L_0x0050:
            if (r12 == 0) goto L_0x0076
        L_0x0052:
            r12.close()
            goto L_0x0076
        L_0x0056:
            r13 = move-exception
            r12 = r3
            goto L_0x0078
        L_0x0059:
            r13 = move-exception
            r12 = r3
        L_0x005b:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0077 }
            r0.<init>()     // Catch:{ all -> 0x0077 }
            java.lang.String r2 = "exception = "
            r0.append(r2)     // Catch:{ all -> 0x0077 }
            java.lang.String r13 = r13.getMessage()     // Catch:{ all -> 0x0077 }
            r0.append(r13)     // Catch:{ all -> 0x0077 }
            java.lang.String r13 = r0.toString()     // Catch:{ all -> 0x0077 }
            com.oplus.a.a.a.a.d(r1, r13)     // Catch:{ all -> 0x0077 }
            if (r12 == 0) goto L_0x0076
            goto L_0x0052
        L_0x0076:
            return r3
        L_0x0077:
            r13 = move-exception
        L_0x0078:
            if (r12 == 0) goto L_0x007d
            r12.close()
        L_0x007d:
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.a.a.a.a(long):java.lang.String");
    }

    public Cursor a(d dVar) {
        return a(dVar, f2665a);
    }

    public Cursor a(d dVar, String[] strArr) {
        Cursor a2 = dVar.a(this.f, this.h);
        if (a2 == null) {
            return null;
        }
        return new C0075a(a2, this.h, this.i);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x005c, code lost:
        if (r3 != null) goto L_0x005e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x005e, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0079, code lost:
        if (r3 == null) goto L_0x007c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x007c, code lost:
        r1 = new android.content.ContentValues();
        r1.put(com.android.providers.downloads.Downloads.Impl.COLUMN_CURRENT_BYTES, 0);
        r1.put(com.android.providers.downloads.Downloads.Impl.COLUMN_TOTAL_BYTES, -1);
        r1.putNull(com.android.providers.downloads.Downloads.Impl._DATA);
        r1.put(com.android.providers.downloads.Downloads.Impl.COLUMN_CONTROL, 0);
        r1.put(com.android.providers.downloads.Downloads.Impl.COLUMN_STATUS, 190);
        r1.put(com.android.providers.downloads.Downloads.Impl.COLUMN_FAILED_CONNECTIONS, 0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00c0, code lost:
        return r7.f.update(r7.h, r1, e(r8), r8);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int a(java.lang.String... r8) {
        /*
            r7 = this;
            java.lang.String r0 = "status"
            java.lang.String r1 = "DownloadManager"
            r2 = 0
            r3 = 0
            com.oplus.a.a.a$d r4 = new com.oplus.a.a.a$d     // Catch:{ RuntimeException -> 0x0064 }
            r4.<init>()     // Catch:{ RuntimeException -> 0x0064 }
            com.oplus.a.a.a$d r4 = r4.a((java.lang.String[]) r8)     // Catch:{ RuntimeException -> 0x0064 }
            android.database.Cursor r3 = r7.a((com.oplus.a.a.a.d) r4)     // Catch:{ RuntimeException -> 0x0064 }
            if (r3 != 0) goto L_0x001b
            if (r3 == 0) goto L_0x001a
            r3.close()
        L_0x001a:
            return r2
        L_0x001b:
            r3.moveToFirst()     // Catch:{ RuntimeException -> 0x0064 }
        L_0x001e:
            boolean r4 = r3.isAfterLast()     // Catch:{ RuntimeException -> 0x0064 }
            if (r4 != 0) goto L_0x005c
            int r4 = r3.getColumnIndex(r0)     // Catch:{ RuntimeException -> 0x0064 }
            int r4 = r3.getInt(r4)     // Catch:{ RuntimeException -> 0x0064 }
            r5 = 8
            if (r4 == r5) goto L_0x0058
            r5 = 16
            if (r4 == r5) goto L_0x0058
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ RuntimeException -> 0x0064 }
            r4.<init>()     // Catch:{ RuntimeException -> 0x0064 }
            java.lang.String r5 = "restartDownloadWithUuid Cannot restart incomplete downloadid = "
            r4.append(r5)     // Catch:{ RuntimeException -> 0x0064 }
            java.lang.String r5 = "_id"
            int r5 = r3.getColumnIndex(r5)     // Catch:{ RuntimeException -> 0x0064 }
            long r5 = r3.getLong(r5)     // Catch:{ RuntimeException -> 0x0064 }
            r4.append(r5)     // Catch:{ RuntimeException -> 0x0064 }
            java.lang.String r4 = r4.toString()     // Catch:{ RuntimeException -> 0x0064 }
            com.oplus.a.a.a.a.c(r1, r4)     // Catch:{ RuntimeException -> 0x0064 }
            if (r3 == 0) goto L_0x0057
            r3.close()
        L_0x0057:
            return r2
        L_0x0058:
            r3.moveToNext()     // Catch:{ RuntimeException -> 0x0064 }
            goto L_0x001e
        L_0x005c:
            if (r3 == 0) goto L_0x007c
        L_0x005e:
            r3.close()
            goto L_0x007c
        L_0x0062:
            r8 = move-exception
            goto L_0x00c1
        L_0x0064:
            r4 = move-exception
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0062 }
            r5.<init>()     // Catch:{ all -> 0x0062 }
            java.lang.String r6 = "Exception happened in restartDownload: "
            r5.append(r6)     // Catch:{ all -> 0x0062 }
            r5.append(r4)     // Catch:{ all -> 0x0062 }
            java.lang.String r4 = r5.toString()     // Catch:{ all -> 0x0062 }
            com.oplus.a.a.a.a.c(r1, r4)     // Catch:{ all -> 0x0062 }
            if (r3 == 0) goto L_0x007c
            goto L_0x005e
        L_0x007c:
            android.content.ContentValues r1 = new android.content.ContentValues
            r1.<init>()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r2)
            java.lang.String r4 = "current_bytes"
            r1.put(r4, r3)
            r3 = -1
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            java.lang.String r4 = "total_bytes"
            r1.put(r4, r3)
            java.lang.String r3 = "_data"
            r1.putNull(r3)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r2)
            java.lang.String r4 = "control"
            r1.put(r4, r3)
            r3 = 190(0xbe, float:2.66E-43)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r1.put(r0, r3)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r2)
            java.lang.String r2 = "numfailed"
            r1.put(r2, r0)
            android.content.ContentResolver r0 = r7.f
            android.net.Uri r2 = r7.h
            java.lang.String r3 = e(r8)
            int r8 = r0.update(r2, r1, r3, r8)
            return r8
        L_0x00c1:
            if (r3 == 0) goto L_0x00c6
            r3.close()
        L_0x00c6:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.a.a.a.a(java.lang.String[]):int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00dd, code lost:
        if (r13 != null) goto L_0x00f9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00f7, code lost:
        if (r13 == null) goto L_0x00fc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00f9, code lost:
        r13.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00fc, code lost:
        r15 = r12.size();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0100, code lost:
        if (r15 > 0) goto L_0x0108;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0102, code lost:
        com.oplus.a.a.a.a.c("DownloadManager", "resumeDownloadWithUuid resumeIdList size <= 0, return.");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0107, code lost:
        return 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x010a, code lost:
        if (com.oplus.a.a.a.a.f2669a == false) goto L_0x0120;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x010c, code lost:
        com.oplus.a.a.a.a.b("DownloadManager", "resumeDownloadWithUuid resumeIdList = " + r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0120, code lost:
        r0 = new android.content.ContentValues();
        r0.put(com.android.providers.downloads.Downloads.Impl.COLUMN_CONTROL, 0);
        r0.put(com.android.providers.downloads.Downloads.Impl.COLUMN_STATUS, 190);
        r0.put(com.android.providers.downloads.Downloads.Impl.COLUMN_FAILED_CONNECTIONS, 0);
        r15 = (java.lang.String[]) r12.toArray(new java.lang.String[r15]);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x014a, code lost:
        return r14.f.update(r14.h, r0, e(r15), r15);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int b(java.lang.String... r15) {
        /*
            r14 = this;
            r0 = 0
            java.lang.Integer r1 = java.lang.Integer.valueOf(r0)
            java.lang.String r2 = "DownloadManager"
            if (r15 == 0) goto L_0x0151
            int r3 = r15.length
            if (r3 != 0) goto L_0x000e
            goto L_0x0151
        L_0x000e:
            boolean r3 = com.oplus.a.a.a.a.f2669a
            if (r3 == 0) goto L_0x002a
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "resumeDownloadWithUuid dumpArray= "
            r3.append(r4)
            java.lang.String r4 = java.util.Arrays.toString(r15)
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            com.oplus.a.a.a.a.b(r2, r3)
        L_0x002a:
            java.lang.String r3 = "uuid"
            java.lang.String r4 = "status"
            java.lang.String r5 = "control"
            java.lang.String[] r8 = new java.lang.String[]{r5, r4, r3}
            java.util.ArrayList r12 = new java.util.ArrayList
            int r6 = r15.length
            r12.<init>(r6)
            r13 = 0
            android.content.ContentResolver r6 = r14.f     // Catch:{ RuntimeException -> 0x00e2 }
            android.net.Uri r7 = r14.h     // Catch:{ RuntimeException -> 0x00e2 }
            java.lang.String r9 = e(r15)     // Catch:{ RuntimeException -> 0x00e2 }
            r11 = 0
            r10 = r15
            android.database.Cursor r13 = r6.query(r7, r8, r9, r10, r11)     // Catch:{ RuntimeException -> 0x00e2 }
            if (r13 != 0) goto L_0x0056
            java.lang.String r15 = "resumeDownloadWithUuid return 0!"
            com.oplus.a.a.a.a.c(r2, r15)     // Catch:{ RuntimeException -> 0x00e2 }
            if (r13 == 0) goto L_0x0055
            r13.close()
        L_0x0055:
            return r0
        L_0x0056:
            boolean r15 = com.oplus.a.a.a.a.f2669a     // Catch:{ RuntimeException -> 0x00e2 }
            if (r15 == 0) goto L_0x0072
            java.lang.StringBuilder r15 = new java.lang.StringBuilder     // Catch:{ RuntimeException -> 0x00e2 }
            r15.<init>()     // Catch:{ RuntimeException -> 0x00e2 }
            java.lang.String r6 = "resumeDownloadWithUuid cursor.getCount() = "
            r15.append(r6)     // Catch:{ RuntimeException -> 0x00e2 }
            int r6 = r13.getCount()     // Catch:{ RuntimeException -> 0x00e2 }
            r15.append(r6)     // Catch:{ RuntimeException -> 0x00e2 }
            java.lang.String r15 = r15.toString()     // Catch:{ RuntimeException -> 0x00e2 }
            com.oplus.a.a.a.a.b(r2, r15)     // Catch:{ RuntimeException -> 0x00e2 }
        L_0x0072:
            r13.moveToFirst()     // Catch:{ RuntimeException -> 0x00e2 }
        L_0x0075:
            boolean r15 = r13.isAfterLast()     // Catch:{ RuntimeException -> 0x00e2 }
            if (r15 != 0) goto L_0x00dd
            int r15 = r13.getColumnIndex(r3)     // Catch:{ RuntimeException -> 0x00e2 }
            java.lang.String r15 = r13.getString(r15)     // Catch:{ RuntimeException -> 0x00e2 }
            int r6 = r13.getColumnIndex(r4)     // Catch:{ RuntimeException -> 0x00e2 }
            int r6 = r13.getInt(r6)     // Catch:{ RuntimeException -> 0x00e2 }
            int r7 = r13.getColumnIndex(r5)     // Catch:{ RuntimeException -> 0x00e2 }
            int r7 = r13.getInt(r7)     // Catch:{ RuntimeException -> 0x00e2 }
            boolean r8 = android.provider.Downloads.Impl.isStatusCompleted(r6)     // Catch:{ RuntimeException -> 0x00e2 }
            if (r8 != 0) goto L_0x00a0
            r8 = 199(0xc7, float:2.79E-43)
            if (r6 != r8) goto L_0x009e
            goto L_0x00a0
        L_0x009e:
            r8 = r0
            goto L_0x00a1
        L_0x00a0:
            r8 = 1
        L_0x00a1:
            if (r8 != 0) goto L_0x00a5
            if (r7 != 0) goto L_0x00d6
        L_0x00a5:
            r7 = 193(0xc1, float:2.7E-43)
            if (r6 == r7) goto L_0x00d6
            r7 = 194(0xc2, float:2.72E-43)
            if (r6 == r7) goto L_0x00d6
            r7 = 195(0xc3, float:2.73E-43)
            if (r6 == r7) goto L_0x00d6
            r7 = 196(0xc4, float:2.75E-43)
            if (r6 == r7) goto L_0x00d6
            r7 = 198(0xc6, float:2.77E-43)
            if (r6 == r7) goto L_0x00d6
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ RuntimeException -> 0x00e2 }
            r7.<init>()     // Catch:{ RuntimeException -> 0x00e2 }
            java.lang.String r8 = "resumeDownloadWithUuid Cannot resume a completed task. id = "
            r7.append(r8)     // Catch:{ RuntimeException -> 0x00e2 }
            r7.append(r15)     // Catch:{ RuntimeException -> 0x00e2 }
            java.lang.String r15 = ", stauts = "
            r7.append(r15)     // Catch:{ RuntimeException -> 0x00e2 }
            r7.append(r6)     // Catch:{ RuntimeException -> 0x00e2 }
            java.lang.String r15 = r7.toString()     // Catch:{ RuntimeException -> 0x00e2 }
            com.oplus.a.a.a.a.c(r2, r15)     // Catch:{ RuntimeException -> 0x00e2 }
            goto L_0x00d9
        L_0x00d6:
            r12.add(r15)     // Catch:{ RuntimeException -> 0x00e2 }
        L_0x00d9:
            r13.moveToNext()     // Catch:{ RuntimeException -> 0x00e2 }
            goto L_0x0075
        L_0x00dd:
            if (r13 == 0) goto L_0x00fc
            goto L_0x00f9
        L_0x00e0:
            r15 = move-exception
            goto L_0x014b
        L_0x00e2:
            r15 = move-exception
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00e0 }
            r3.<init>()     // Catch:{ all -> 0x00e0 }
            java.lang.String r6 = "Exception happened in getUriForDownloadedFile: "
            r3.append(r6)     // Catch:{ all -> 0x00e0 }
            r3.append(r15)     // Catch:{ all -> 0x00e0 }
            java.lang.String r15 = r3.toString()     // Catch:{ all -> 0x00e0 }
            com.oplus.a.a.a.a.c(r2, r15)     // Catch:{ all -> 0x00e0 }
            if (r13 == 0) goto L_0x00fc
        L_0x00f9:
            r13.close()
        L_0x00fc:
            int r15 = r12.size()
            if (r15 > 0) goto L_0x0108
            java.lang.String r15 = "resumeDownloadWithUuid resumeIdList size <= 0, return."
            com.oplus.a.a.a.a.c(r2, r15)
            return r0
        L_0x0108:
            boolean r0 = com.oplus.a.a.a.a.f2669a
            if (r0 == 0) goto L_0x0120
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r3 = "resumeDownloadWithUuid resumeIdList = "
            r0.append(r3)
            r0.append(r12)
            java.lang.String r0 = r0.toString()
            com.oplus.a.a.a.a.b(r2, r0)
        L_0x0120:
            android.content.ContentValues r0 = new android.content.ContentValues
            r0.<init>()
            r0.put(r5, r1)
            r2 = 190(0xbe, float:2.66E-43)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r0.put(r4, r2)
            java.lang.String r2 = "numfailed"
            r0.put(r2, r1)
            java.lang.String[] r15 = new java.lang.String[r15]
            java.lang.Object[] r15 = r12.toArray(r15)
            java.lang.String[] r15 = (java.lang.String[]) r15
            android.content.ContentResolver r1 = r14.f
            android.net.Uri r2 = r14.h
            java.lang.String r3 = e(r15)
            int r15 = r1.update(r2, r0, r3, r15)
            return r15
        L_0x014b:
            if (r13 == 0) goto L_0x0150
            r13.close()
        L_0x0150:
            throw r15
        L_0x0151:
            java.lang.String r15 = "resumeDownloadWithUuid input param 'uuids' can't be null"
            com.oplus.a.a.a.a.c(r2, r15)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.a.a.a.b(java.lang.String[]):int");
    }

    public int a(int i2, String... strArr) {
        if (strArr == null || strArr.length == 0) {
            throw new IllegalArgumentException("setAllowedNetworkTypesWithUuid input param 'uuids' can't be null");
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put(Downloads.Impl.COLUMN_ALLOWED_NETWORK_TYPES, Integer.valueOf(i2));
        return this.f.update(this.h, contentValues, e(strArr), strArr);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x007c, code lost:
        if (r6 == null) goto L_0x00a0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x007e, code lost:
        r6.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x009d, code lost:
        if (r6 == null) goto L_0x00a0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00a0, code lost:
        return r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<com.android.providers.downloads.DownloadInfoData> a(long... r6) {
        /*
            r5 = this;
            r0 = 1
            r5.a((boolean) r0)
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            com.oplus.a.a.a$d r2 = new com.oplus.a.a.a$d
            r2.<init>()
            r2.a((long[]) r6)
            boolean r6 = com.oplus.a.a.a.a.f2669a
            java.lang.String r3 = "DownloadManager"
            if (r6 == 0) goto L_0x002d
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r4 = "getDownloadData -array-  mPackageName = "
            r6.append(r4)
            java.lang.String r4 = r5.g
            r6.append(r4)
            java.lang.String r6 = r6.toString()
            com.oplus.a.a.a.a.a(r3, r6)
        L_0x002d:
            java.lang.String r6 = r5.g
            boolean r6 = android.text.TextUtils.isEmpty(r6)
            if (r6 != 0) goto L_0x003f
            java.lang.String[] r6 = new java.lang.String[r0]
            r0 = 0
            java.lang.String r4 = r5.g
            r6[r0] = r4
            r2.b(r6)
        L_0x003f:
            r6 = 0
            android.database.Cursor r6 = r5.a((com.oplus.a.a.a.d) r2)     // Catch:{ Exception -> 0x0084 }
            int r0 = r6.getCount()     // Catch:{ Exception -> 0x0084 }
            boolean r2 = com.oplus.a.a.a.a.f2669a     // Catch:{ Exception -> 0x0084 }
            if (r2 == 0) goto L_0x0060
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0084 }
            r2.<init>()     // Catch:{ Exception -> 0x0084 }
            java.lang.String r4 = "getDownloadData  c.getCount() = "
            r2.append(r4)     // Catch:{ Exception -> 0x0084 }
            r2.append(r0)     // Catch:{ Exception -> 0x0084 }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x0084 }
            com.oplus.a.a.a.a.a(r3, r2)     // Catch:{ Exception -> 0x0084 }
        L_0x0060:
            if (r0 <= 0) goto L_0x007c
            boolean r0 = r6.moveToFirst()     // Catch:{ Exception -> 0x0084 }
            if (r0 == 0) goto L_0x007c
        L_0x0068:
            com.android.providers.downloads.DownloadInfoData$BaseReader r0 = new com.android.providers.downloads.DownloadInfoData$BaseReader     // Catch:{ Exception -> 0x0084 }
            android.content.ContentResolver r2 = r5.f     // Catch:{ Exception -> 0x0084 }
            r0.<init>(r2, r6)     // Catch:{ Exception -> 0x0084 }
            com.android.providers.downloads.DownloadInfoData r0 = r0.newDownloadInfoSimple()     // Catch:{ Exception -> 0x0084 }
            r1.add(r0)     // Catch:{ Exception -> 0x0084 }
            boolean r0 = r6.moveToNext()     // Catch:{ Exception -> 0x0084 }
            if (r0 != 0) goto L_0x0068
        L_0x007c:
            if (r6 == 0) goto L_0x00a0
        L_0x007e:
            r6.close()
            goto L_0x00a0
        L_0x0082:
            r0 = move-exception
            goto L_0x00a1
        L_0x0084:
            r0 = move-exception
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0082 }
            r2.<init>()     // Catch:{ all -> 0x0082 }
            java.lang.String r4 = "exception = "
            r2.append(r4)     // Catch:{ all -> 0x0082 }
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x0082 }
            r2.append(r0)     // Catch:{ all -> 0x0082 }
            java.lang.String r0 = r2.toString()     // Catch:{ all -> 0x0082 }
            com.oplus.a.a.a.a.d(r3, r0)     // Catch:{ all -> 0x0082 }
            if (r6 == 0) goto L_0x00a0
            goto L_0x007e
        L_0x00a0:
            return r1
        L_0x00a1:
            if (r6 == 0) goto L_0x00a6
            r6.close()
        L_0x00a6:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.a.a.a.a(long[]):java.util.List");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x006d, code lost:
        if (r1 != null) goto L_0x006f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x006f, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0095, code lost:
        if (r1 != null) goto L_0x006f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0098, code lost:
        return null;
     */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x009b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.android.providers.downloads.DownloadInfoData a(java.lang.String r6) {
        /*
            r5 = this;
            java.lang.String r0 = "DownloadManager"
            r1 = 1
            r5.a((boolean) r1)
            com.oplus.a.a.a$d r2 = new com.oplus.a.a.a$d
            r2.<init>()
            java.lang.String[] r1 = new java.lang.String[r1]
            r3 = 0
            r1[r3] = r6
            r2.a((java.lang.String[]) r1)
            r6 = 0
            android.database.Cursor r1 = r5.a((com.oplus.a.a.a.d) r2)     // Catch:{ Exception -> 0x007b, all -> 0x0077 }
            boolean r2 = com.oplus.a.a.a.a.f2669a     // Catch:{ Exception -> 0x0075 }
            if (r2 == 0) goto L_0x003c
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0075 }
            r2.<init>()     // Catch:{ Exception -> 0x0075 }
            java.lang.String r3 = "getDownloadDataWithUuid  c.getCount() = "
            r2.append(r3)     // Catch:{ Exception -> 0x0075 }
            if (r1 == 0) goto L_0x0031
            int r3 = r1.getCount()     // Catch:{ Exception -> 0x0075 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ Exception -> 0x0075 }
            goto L_0x0032
        L_0x0031:
            r3 = r6
        L_0x0032:
            r2.append(r3)     // Catch:{ Exception -> 0x0075 }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x0075 }
            com.oplus.a.a.a.a.a(r0, r2)     // Catch:{ Exception -> 0x0075 }
        L_0x003c:
            if (r1 == 0) goto L_0x006d
            boolean r2 = r1.moveToFirst()     // Catch:{ Exception -> 0x0075 }
            if (r2 == 0) goto L_0x006d
            com.android.providers.downloads.DownloadInfoData$BaseReader r2 = new com.android.providers.downloads.DownloadInfoData$BaseReader     // Catch:{ Exception -> 0x0075 }
            android.content.ContentResolver r3 = r5.f     // Catch:{ Exception -> 0x0075 }
            r2.<init>(r3, r1)     // Catch:{ Exception -> 0x0075 }
            com.android.providers.downloads.DownloadInfoData r2 = r2.newDownloadInfoSimple()     // Catch:{ Exception -> 0x0075 }
            boolean r3 = com.oplus.a.a.a.a.f2669a     // Catch:{ Exception -> 0x0075 }
            if (r3 == 0) goto L_0x0067
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0075 }
            r3.<init>()     // Catch:{ Exception -> 0x0075 }
            java.lang.String r4 = "getDownloadDataWithUuid. info = "
            r3.append(r4)     // Catch:{ Exception -> 0x0075 }
            r3.append(r2)     // Catch:{ Exception -> 0x0075 }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x0075 }
            com.oplus.a.a.a.a.a(r0, r3)     // Catch:{ Exception -> 0x0075 }
        L_0x0067:
            if (r1 == 0) goto L_0x006c
            r1.close()
        L_0x006c:
            return r2
        L_0x006d:
            if (r1 == 0) goto L_0x0098
        L_0x006f:
            r1.close()
            goto L_0x0098
        L_0x0073:
            r6 = move-exception
            goto L_0x0099
        L_0x0075:
            r2 = move-exception
            goto L_0x007d
        L_0x0077:
            r0 = move-exception
            r1 = r6
            r6 = r0
            goto L_0x0099
        L_0x007b:
            r2 = move-exception
            r1 = r6
        L_0x007d:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0073 }
            r3.<init>()     // Catch:{ all -> 0x0073 }
            java.lang.String r4 = "exception = "
            r3.append(r4)     // Catch:{ all -> 0x0073 }
            java.lang.String r2 = r2.getMessage()     // Catch:{ all -> 0x0073 }
            r3.append(r2)     // Catch:{ all -> 0x0073 }
            java.lang.String r2 = r3.toString()     // Catch:{ all -> 0x0073 }
            com.oplus.a.a.a.a.d(r0, r2)     // Catch:{ all -> 0x0073 }
            if (r1 == 0) goto L_0x0098
            goto L_0x006f
        L_0x0098:
            return r6
        L_0x0099:
            if (r1 == 0) goto L_0x009e
            r1.close()
        L_0x009e:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.a.a.a.a(java.lang.String):com.android.providers.downloads.DownloadInfoData");
    }

    public void a(b bVar) {
        this.j = bVar;
        c();
        if (com.oplus.a.a.a.a.f2669a) {
            com.oplus.a.a.a.a.b("DownloadManager", "registerDownloadStatesCallback  mDownloadStatesCallback = " + this.j);
        }
    }

    public void a() {
        this.j = null;
        d();
        if (com.oplus.a.a.a.a.f2669a) {
            com.oplus.a.a.a.a.b("DownloadManager", "unregisterDownloadStatesCallback  mDownloadStatesCallback = " + this.j);
        }
    }

    private synchronized void c() {
        if (this.l == null) {
            this.l = new c((Handler) null);
            this.f.registerContentObserver(c.f2679b, true, this.l);
            this.f.registerContentObserver(c.f2678a, true, this.l);
        }
    }

    private synchronized void d() {
        if (this.l != null) {
            this.f.unregisterContentObserver(this.l);
            this.l = null;
        }
    }

    /* compiled from: DownloadManager */
    class c extends ContentObserver {
        public c(Handler handler) {
            super(handler);
        }

        public void onChange(boolean z) {
            onChange(z, (Uri) null);
        }

        public void onChange(boolean z, final Uri uri) {
            if (com.oplus.a.a.a.a.f2669a) {
                com.oplus.a.a.a.a.a("DownloadManager", "onChange run, uri = " + uri);
            }
            if (a.this.k != null) {
                a.this.k.a();
            } else if (uri == null) {
                com.oplus.a.a.a.a.d("DownloadManager", "onChange error uri = null, return.");
            } else if (a.this.j == null) {
                com.oplus.a.a.a.a.d("DownloadManager", "onChange error mDownloadStatesCallback = null, return.");
            } else {
                a.this.m.post(new Runnable() {
                    public void run() {
                        if (com.oplus.a.a.a.a.f2669a) {
                            com.oplus.a.a.a.a.a("DownloadManager", "onChange run, start! mPackageName=" + a.this.g + "/uri = " + uri);
                        }
                        if (uri.getPathSegments().size() > 2) {
                            String uri = uri.toString();
                            String str = "insert";
                            if (!uri.contains(str)) {
                                if (uri.contains("update")) {
                                    str = "update";
                                } else if (uri.contains(StickerMsgData.STICKER_OPER_DELETE)) {
                                    str = StickerMsgData.STICKER_OPER_DELETE;
                                } else if (uri.contains("timeout")) {
                                    str = "timeout";
                                } else {
                                    com.oplus.a.a.a.a.d("DownloadManager", "onChange type error uriString = " + uri);
                                    return;
                                }
                            }
                            String[] split = uri.getLastPathSegment().split("-");
                            if (com.oplus.a.a.a.a.f2669a) {
                                com.oplus.a.a.a.a.a("DownloadManager", "onChange run, changeType = " + str + Arrays.toString(split));
                            }
                            if (split == null || split.length <= 0) {
                                com.oplus.a.a.a.a.d("DownloadManager", "onChange error no valid id");
                                return;
                            }
                            try {
                                if (str.equalsIgnoreCase(StickerMsgData.STICKER_OPER_DELETE)) {
                                    ArrayList arrayList = new ArrayList();
                                    for (String str2 : split) {
                                        int indexOf = str2.indexOf(124);
                                        DownloadInfoData downloadInfoData = new DownloadInfoData();
                                        downloadInfoData.mId = Long.parseLong(str2.substring(0, indexOf));
                                        downloadInfoData.mUuid = str2.substring(indexOf + 1);
                                        arrayList.add(downloadInfoData);
                                    }
                                    if (a.this.j != null) {
                                        a.this.j.c(arrayList);
                                    } else {
                                        com.oplus.a.a.a.a.d("DownloadManager", "onChange return mDownloadStatesCallback  is null");
                                    }
                                } else {
                                    long[] jArr = new long[split.length];
                                    for (int i = 0; i < split.length; i++) {
                                        Long valueOf = Long.valueOf(Long.parseLong(split[i]));
                                        jArr[i] = valueOf.longValue();
                                        if (com.oplus.a.a.a.a.f2669a) {
                                            com.oplus.a.a.a.a.a("DownloadManager", "onChange run, split i = " + i + "/ id =" + valueOf);
                                        }
                                    }
                                    List<DownloadInfoData> a2 = a.this.a(jArr);
                                    if (a2 != null && a2.size() > 0) {
                                        c.this.a(a2, str);
                                    }
                                }
                            } catch (Exception e) {
                                com.oplus.a.a.a.a.d("DownloadManager", "exception = " + e.getMessage());
                            }
                        } else {
                            com.oplus.a.a.a.a.d("DownloadManager", "onChange run, pathSegments.size <= 2, uri has't downloadid");
                        }
                    }
                });
            }
        }

        /* access modifiers changed from: private */
        public void a(List<DownloadInfoData> list, String str) {
            if (list.get(0).mPackage == null) {
                com.oplus.a.a.a.a.d("DownloadManager", "downloadInfo.mPackage = null, return");
            } else if (a.this.g == null || list.get(0).mPackage.equals(a.this.g)) {
                if (com.oplus.a.a.a.a.f2669a) {
                    com.oplus.a.a.a.a.a("DownloadManager", "handleDownloadInfo.list downloadInfos.size = " + list.size());
                }
                if (a.this.j == null) {
                    com.oplus.a.a.a.a.d("DownloadManager", "handleDownloadInfo list mDownloadStatesCallback = null");
                } else if (str.equalsIgnoreCase("insert")) {
                    a.this.j.a(list);
                } else if (str.equalsIgnoreCase("update")) {
                    a.this.j.b(list);
                } else if (str.equalsIgnoreCase("timeout")) {
                    a.this.j.d(list);
                }
            } else {
                com.oplus.a.a.a.a.d("DownloadManager", "handleDownloadInfo list downloadInfo.mPackage = " + list.get(0).mPackage + ". is not equal " + a.this.g);
            }
        }
    }

    public static void c(String[] strArr) {
        com.oplus.a.a.a.a.b("DownloadManager", "dumpArray array= " + Arrays.toString(strArr));
    }

    private static String b(Context context) {
        PackageManager packageManager = context.getPackageManager();
        List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(new Intent("coloros.intent.action.VIEW_DOWNLOADS"), STCommon.ST_MOBILE_TRACKING_SINGLE_THREAD);
        if (queryIntentActivities != null && queryIntentActivities.size() > 0) {
            return queryIntentActivities.get(0).activityInfo.packageName;
        }
        List<ResolveInfo> queryIntentActivities2 = packageManager.queryIntentActivities(new Intent("com.oplus.providers.downloads.ui.intent.action.VIEW_DOWNLOADS"), STCommon.ST_MOBILE_TRACKING_SINGLE_THREAD);
        return (queryIntentActivities2 == null || queryIntentActivities2.size() <= 0) ? "com.coloros.providers.downloads.ui" : queryIntentActivities2.get(0).activityInfo.packageName;
    }

    static String d(String[] strArr) {
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        for (int i2 = 0; i2 < strArr.length; i2++) {
            if (i2 > 0) {
                sb.append("OR ");
            }
            sb.append(Downloads.Impl.COLUMN_NOTIFICATION_PACKAGE);
            sb.append(" = ? ");
        }
        sb.append(")");
        return sb.toString();
    }

    @UnsupportedAppUsage
    static String b(long[] jArr) {
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        for (int i2 = 0; i2 < jArr.length; i2++) {
            if (i2 > 0) {
                sb.append("OR ");
            }
            sb.append("_id");
            sb.append(" = ? ");
        }
        sb.append(")");
        return sb.toString();
    }

    static String e(String[] strArr) {
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        for (int i2 = 0; i2 < strArr.length; i2++) {
            if (i2 > 0) {
                sb.append("OR ");
            }
            sb.append("uuid");
            sb.append(" = ? ");
        }
        sb.append(")");
        return sb.toString();
    }

    @UnsupportedAppUsage
    static String[] c(long[] jArr) {
        return a(jArr, new String[jArr.length]);
    }

    static String[] a(long[] jArr, String[] strArr) {
        if (c || strArr.length >= jArr.length) {
            for (int i2 = 0; i2 < jArr.length; i2++) {
                strArr[i2] = Long.toString(jArr[i2]);
            }
            return strArr;
        }
        throw new AssertionError();
    }

    /* renamed from: com.oplus.a.a.a$a  reason: collision with other inner class name */
    /* compiled from: DownloadManager */
    public static class C0075a extends CursorWrapper {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ boolean f2667a = (!a.class.desiredAssertionStatus());

        /* renamed from: b  reason: collision with root package name */
        private final Uri f2668b;
        private final boolean c;

        private static long c(int i) {
            switch (i) {
                case 193:
                    return 5;
                case 194:
                    return 1;
                case 195:
                    return 2;
                case 196:
                    return 3;
                case 198:
                    return 6;
                default:
                    return 4;
            }
        }

        private static long d(int i) {
            if ((400 <= i && i < 488) || (500 <= i && i < 600)) {
                return (400 > i || i >= 488) ? 1011 : 1012;
            }
            if (i == 198) {
                return 1006;
            }
            if (i == 199) {
                return 1007;
            }
            if (i == 488) {
                return 1009;
            }
            if (i == 489) {
                return 1008;
            }
            if (i == 497) {
                return 1005;
            }
            switch (i) {
                case Downloads.Impl.STATUS_FILE_ERROR:
                    return 1001;
                case Downloads.Impl.STATUS_UNHANDLED_REDIRECT:
                case Downloads.Impl.STATUS_UNHANDLED_HTTP_CODE:
                    return 1002;
                case Downloads.Impl.STATUS_HTTP_DATA_ERROR:
                    return 1004;
                default:
                    return 1000;
            }
        }

        public C0075a(Cursor cursor, Uri uri, boolean z) {
            super(cursor);
            this.f2668b = uri;
            this.c = z;
        }

        public int getInt(int i) {
            if (getColumnName(i).equals("reason")) {
                return (int) a(super.getInt(getColumnIndex(Downloads.Impl.COLUMN_STATUS)));
            }
            if (getColumnName(i).equals(Downloads.Impl.COLUMN_STATUS)) {
                return b(super.getInt(getColumnIndex(Downloads.Impl.COLUMN_STATUS)));
            }
            if (getColumnName(i).equals("status_detailed")) {
                return super.getInt(getColumnIndex(Downloads.Impl.COLUMN_STATUS));
            }
            return super.getInt(i);
        }

        /* JADX WARNING: Removed duplicated region for block: B:12:0x002b  */
        /* JADX WARNING: Removed duplicated region for block: B:21:0x0043  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.String getString(int r5) {
            /*
                r4 = this;
                java.lang.String r0 = r4.getColumnName(r5)
                int r1 = r0.hashCode()
                r2 = -1204869480(0xffffffffb82f2698, float:-4.1759195E-5)
                r3 = 1
                if (r1 == r2) goto L_0x001e
                r2 = 22072411(0x150cc5b, float:3.8350184E-38)
                if (r1 == r2) goto L_0x0014
                goto L_0x0028
            L_0x0014:
                java.lang.String r1 = "local_filename"
                boolean r0 = r0.equals(r1)
                if (r0 == 0) goto L_0x0028
                r0 = r3
                goto L_0x0029
            L_0x001e:
                java.lang.String r1 = "local_uri"
                boolean r0 = r0.equals(r1)
                if (r0 == 0) goto L_0x0028
                r0 = 0
                goto L_0x0029
            L_0x0028:
                r0 = -1
            L_0x0029:
                if (r0 == 0) goto L_0x0043
                if (r0 == r3) goto L_0x0032
                java.lang.String r5 = super.getString(r5)
                return r5
            L_0x0032:
                boolean r0 = r4.c
                if (r0 == 0) goto L_0x003b
                java.lang.String r5 = super.getString(r5)
                return r5
            L_0x003b:
                java.lang.SecurityException r5 = new java.lang.SecurityException
                java.lang.String r0 = "COLUMN_LOCAL_FILENAME is deprecated; use ContentResolver.openFileDescriptor() instead"
                r5.<init>(r0)
                throw r5
            L_0x0043:
                java.lang.String r5 = r4.a()
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.oplus.a.a.a.C0075a.getString(int):java.lang.String");
        }

        private String a() {
            long j = getLong(getColumnIndex(Downloads.Impl.COLUMN_DESTINATION));
            if (j == 4 || j == 0 || j == 6) {
                String string = super.getString(getColumnIndex("local_filename"));
                if (string == null) {
                    return null;
                }
                return Uri.fromFile(new File(string)).toString();
            }
            return ContentUris.withAppendedId(Downloads.Impl.ALL_DOWNLOADS_CONTENT_URI, getLong(getColumnIndex("_id"))).toString();
        }

        public static long a(int i) {
            int b2 = b(i);
            if (b2 == 4) {
                return c(i);
            }
            if (b2 != 16) {
                return 0;
            }
            return d(i);
        }

        public static int b(int i) {
            switch (i) {
                case 190:
                    return 1;
                case 192:
                    return 2;
                case 193:
                case 194:
                case 195:
                case 196:
                case 198:
                    return 4;
                case 200:
                    return 8;
                default:
                    if (f2667a || Downloads.Impl.isStatusError(i)) {
                        return 16;
                    }
                    throw new AssertionError();
            }
        }
    }
}
