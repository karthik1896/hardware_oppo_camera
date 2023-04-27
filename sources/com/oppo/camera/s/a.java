package com.oppo.camera.s;

import android.content.ContentValues;
import android.content.Context;
import android.location.Location;
import android.media.CamcorderProfile;
import android.media.MediaCodec;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Size;
import com.android.providers.downloads.Downloads;
import com.oppo.camera.R;
import com.oppo.camera.aps.adapter.ApsResult;
import com.oppo.camera.aps.config.CameraConfig;
import com.oppo.camera.aps.config.ConfigDataBase;
import com.oppo.camera.e.b;
import com.oppo.camera.e.v;
import com.oppo.camera.jni.YuvProcessUtil;
import com.oppo.camera.statistics.CameraStatisticsUtil;
import com.oppo.camera.ui.control.e;
import com.oppo.camera.ui.e;
import com.oppo.camera.util.Util;
import com.oppo.camera.z;
import com.sensetime.stmobile.STMobileHumanActionNative;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* compiled from: StarVideoHelper */
class a implements v.d {

    /* renamed from: a  reason: collision with root package name */
    private Context f3597a = null;

    /* renamed from: b  reason: collision with root package name */
    private boolean f3598b = false;
    private b c = null;
    private e d = null;
    private Size e = null;
    private String f = null;
    private Uri g = null;
    private CamcorderProfile h = null;
    private ContentValues i = null;
    private ParcelFileDescriptor j = null;
    private v k = null;
    private ApsResult.ImageBuffer l = null;
    private C0094a m = null;
    private int n = 0;
    private int o = 0;
    private int p = 0;
    private boolean q = false;
    private boolean r = false;

    /* renamed from: com.oppo.camera.s.a$a  reason: collision with other inner class name */
    /* compiled from: StarVideoHelper */
    public interface C0094a extends v.e, v.f, v.g {
    }

    public int c() {
        return 30;
    }

    public a(Context context, b bVar, e eVar, boolean z) {
        this.f3597a = context;
        this.c = bVar;
        this.d = eVar;
        this.f3598b = z;
    }

    private int e() {
        CamcorderProfile camcorderProfile;
        String j2 = j();
        if ("video_size_4kuhd".equals(j2)) {
            return 100000000;
        }
        if (!"video_size_1080p".equals(j2) || !Util.p() || (camcorderProfile = CamcorderProfile.get(this.n, 6)) == null) {
            return 17000000;
        }
        return camcorderProfile.videoBitRate;
    }

    public void a(int i2) {
        this.n = i2;
        int width = b().getWidth();
        int height = b().getHeight();
        int e2 = e();
        int c2 = c();
        int i3 = "H265".equals(i()) ? 5 : 2;
        this.h = CamcorderProfile.get(this.n, 6);
        CamcorderProfile camcorderProfile = this.h;
        camcorderProfile.videoFrameRate = c2;
        camcorderProfile.videoBitRate = e2;
        camcorderProfile.videoCodec = i3;
        camcorderProfile.videoFrameWidth = width;
        camcorderProfile.videoFrameHeight = height;
    }

    private boolean f() {
        return !"video_size_1080p".equals(j()) || "H265".equals(i());
    }

    public void a(C0094a aVar) {
        this.m = aVar;
    }

    public void a() {
        com.oppo.camera.e.c("StarVideoHelper", "startRecording E");
        n();
        l();
        this.k = new v(true, this.c.ae());
        this.k.a(false);
        this.k.b(false);
        this.k.c(true);
        this.k.a(this.h);
        Location v = this.c.v();
        if (v != null) {
            this.k.a((float) v.getLatitude(), (float) v.getLongitude());
        }
        this.k.o((this.c.s() + 0) % 360);
        ParcelFileDescriptor parcelFileDescriptor = this.j;
        if (parcelFileDescriptor != null) {
            this.k.a(parcelFileDescriptor.getFileDescriptor());
        } else {
            this.k.a(this.f);
        }
        this.k.g(f() ? this.h.videoBitRate / 2 : this.h.videoBitRate);
        long c2 = z.c(z.r);
        long j2 = "on".equals(z.r) ? STMobileHumanActionNative.ST_MOBILE_BODY_ACTION1 : 0;
        if (j2 > 0 && j2 < c2) {
            c2 = j2;
        }
        this.k.a(c2);
        this.k.a((v.e) this.m);
        this.k.a((v.g) this.m);
        this.k.a((v.f) this.m);
        this.k.a((v.d) this);
        try {
            this.k.d();
            this.k.a();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        this.q = true;
        this.o = 0;
        this.p = 0;
        com.oppo.camera.e.c("StarVideoHelper", "startRecording X");
    }

    public void a(byte[] bArr) {
        ApsResult.ImageBuffer imageBuffer;
        com.oppo.camera.e.c("StarVideoHelper", "onYuvImageReceived");
        if (!this.q || bArr == null || this.k == null || (imageBuffer = this.l) == null) {
            com.oppo.camera.e.e("StarVideoHelper", "onYuvImageReceived, mbRecording: " + this.q);
        } else {
            this.o++;
            this.l.getImage().getPlanes()[0].getBuffer().put(bArr, 0, imageBuffer.getImage().getPlanes()[0].getBuffer().remaining());
            this.k.a(this.l.getImage().getHardwareBuffer());
            if (this.r) {
                Util.a(bArr, "capture_yuv", System.currentTimeMillis() + "star_video_" + this.o + ".yuv");
            }
        }
        g();
    }

    private void g() {
        ApsResult.ImageBuffer imageBuffer = this.l;
        if (imageBuffer != null) {
            imageBuffer.close();
            this.l = null;
        }
    }

    public void a(ApsResult.ImageBuffer imageBuffer) {
        g();
        if (imageBuffer != null) {
            this.l = imageBuffer;
            this.l.addRef();
        }
    }

    public void a(boolean z) {
        com.oppo.camera.e.c("StarVideoHelper", "stopRecording E");
        if (!this.q) {
            com.oppo.camera.e.e("StarVideoHelper", "stopRecording, mbRecording is false, so return!");
            return;
        }
        this.q = false;
        v vVar = this.k;
        if (vVar != null) {
            vVar.b();
            this.k.a((v.e) null);
            this.k.a((v.g) null);
            this.k.a((v.f) null);
            this.k.a((v.d) null);
        }
        if (z) {
            e.c cVar = new e.c();
            cVar.k = 1;
            a(cVar);
            n();
            cVar.d = this.g;
            this.d.a(cVar, false);
        } else {
            n();
            a(this.f);
        }
        g();
        this.o = 0;
        com.oppo.camera.e.c("StarVideoHelper", "stopRecording X");
    }

    public Size b() {
        if (this.e == null) {
            String j2 = j();
            if ("video_size_4kuhd".equals(j2)) {
                this.e = new Size(3840, 2160);
            } else if ("video_size_1080p".equals(j2)) {
                this.e = new Size(1920, 1080);
            } else {
                this.e = new Size(1280, 720);
            }
        }
        return this.e;
    }

    public int d() {
        return h() / c();
    }

    private int h() {
        return this.p;
    }

    private String i() {
        return this.f3597a.getString(R.string.camera_video_codec_default_value);
    }

    private String j() {
        return CameraConfig.getConfigStringValue(ConfigDataBase.KEY_STAR_VIDEO_SIZE_TYPE);
    }

    private String a(long j2) {
        return new SimpleDateFormat(this.f3597a.getResources().getString(R.string.camera_video_file_name_format), Locale.US).format(new Date(j2));
    }

    private String k() {
        String str;
        StringBuilder sb;
        if (z.r.equals("off")) {
            sb = new StringBuilder();
            str = z.n;
        } else {
            sb = new StringBuilder();
            str = z.i;
        }
        sb.append(str);
        sb.append('/');
        return sb.toString();
    }

    private void l() {
        long currentTimeMillis = System.currentTimeMillis();
        String a2 = a(currentTimeMillis);
        String str = a2 + ".mp4";
        this.f = k() + str;
        this.i = new ContentValues(7);
        this.i.put(Downloads.Impl.COLUMN_TITLE, a2);
        this.i.put("_display_name", str);
        this.i.put("datetaken", Long.valueOf(currentTimeMillis));
        this.i.put("mime_type", "video/mp4");
        this.i.put("relative_path", z.d((z.a) null));
        this.i.put("is_pending", 1);
        Context context = this.f3597a;
        this.g = com.oppo.camera.util.storage.a.a(context, context.getContentResolver(), this.i);
        try {
            this.j = this.f3597a.getContentResolver().openFileDescriptor(this.g, "rw");
        } catch (FileNotFoundException e2) {
            e2.printStackTrace();
        }
        Size b2 = b();
        if (b2 != null) {
            this.i.put("resolution", b2.getWidth() + "x" + b2.getHeight());
            this.i.put(CameraStatisticsUtil.IMAGE_WIDTH, Integer.toString(b2.getWidth()));
            this.i.put(CameraStatisticsUtil.IMAGE_HEIGHT, Integer.toString(b2.getHeight()));
        }
        Location v = this.c.v();
        if (v != null) {
            this.i.put("latitude", Double.valueOf(v.getLatitude()));
            this.i.put("longitude", Double.valueOf(v.getLongitude()));
        }
        com.oppo.camera.e.a("StarVideoHelper", "generateVideoFilename, New video filename: " + this.f + ", mCurrentVideoUri: " + this.g + ", videoSize: " + b2);
    }

    private void a(String str) {
        com.oppo.camera.e.a("StarVideoHelper", "deleteVideoFile, fileName: " + str);
        if (str != null) {
            File file = new File(str);
            if (file.exists() && !file.delete()) {
                com.oppo.camera.e.a("StarVideoHelper", "deleteVideoFile, Could not delete " + str);
            }
            if (this.g != null) {
                try {
                    this.f3597a.getContentResolver().delete(this.g, (String) null, (String[]) null);
                } catch (Exception e2) {
                    e2.printStackTrace();
                } catch (Throwable th) {
                    this.g = null;
                    throw th;
                }
                this.g = null;
            }
        }
    }

    private long m() {
        float h2 = ((float) h()) / ((float) c());
        com.oppo.camera.e.c("StarVideoHelper", "calcVideoDuration, mEncodeFrameNumber: " + this.p + ", time: " + h2);
        return (long) ((int) (h2 * 1000.0f));
    }

    private void n() {
        ParcelFileDescriptor parcelFileDescriptor = this.j;
        if (parcelFileDescriptor != null) {
            try {
                parcelFileDescriptor.close();
            } catch (IOException e2) {
                com.oppo.camera.e.d("StarVideoHelper", "closeVideoFileDescriptor, Fail to close fd", e2);
            }
            this.j = null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00ab, code lost:
        if (r2 == null) goto L_0x00ae;
     */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0166  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean a(com.oppo.camera.ui.control.e.c r13) {
        /*
            r12 = this;
            java.lang.String r0 = "com.oppo.camera.NEW_VIDEO"
            java.lang.String r1 = "StarVideoHelper"
            java.lang.String r2 = "addVideoToMediaStore"
            com.oppo.camera.e.a(r1, r2)
            java.lang.String r2 = com.oppo.camera.z.e()
            java.lang.String r3 = "on"
            boolean r2 = r3.equals(r2)
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L_0x0030
            boolean r2 = com.oppo.camera.z.b((boolean) r3)
            if (r2 != 0) goto L_0x0030
            r12.g = r4
            r12.f = r4
            android.content.ContentValues r13 = r12.i
            if (r13 == 0) goto L_0x002a
            r13.clear()
            r12.i = r4
        L_0x002a:
            java.lang.String r13 = "addVideoToMediaStore, Exception: sdcard has removed, so not add to mediaStore."
            com.oppo.camera.e.a(r1, r13)
            return r3
        L_0x0030:
            android.os.ParcelFileDescriptor r2 = r12.j
            r5 = 0
            if (r2 == 0) goto L_0x016a
            java.lang.String r2 = r12.f
            if (r2 == 0) goto L_0x016a
            android.content.ContentValues r6 = r12.i
            java.io.File r7 = new java.io.File
            r7.<init>(r2)
            long r7 = r7.length()
            java.lang.Long r2 = java.lang.Long.valueOf(r7)
            java.lang.String r7 = "_size"
            r6.put(r7, r2)
            android.content.ContentValues r2 = r12.i
            long r6 = java.lang.System.currentTimeMillis()
            java.lang.Long r6 = java.lang.Long.valueOf(r6)
            java.lang.String r7 = "datetaken"
            r2.put(r7, r6)
            android.content.ContentValues r2 = r12.i
            java.lang.Integer r6 = java.lang.Integer.valueOf(r5)
            java.lang.String r7 = "is_pending"
            r2.put(r7, r6)
            r6 = 0
            android.media.MediaMetadataRetriever r2 = new android.media.MediaMetadataRetriever     // Catch:{ Exception -> 0x00a4, all -> 0x00a0 }
            r2.<init>()     // Catch:{ Exception -> 0x00a4, all -> 0x00a0 }
            android.content.Context r8 = r12.f3597a     // Catch:{ Exception -> 0x00a5 }
            java.lang.String r9 = r12.f     // Catch:{ Exception -> 0x00a5 }
            android.net.Uri r9 = android.net.Uri.parse(r9)     // Catch:{ Exception -> 0x00a5 }
            r2.setDataSource(r8, r9)     // Catch:{ Exception -> 0x00a5 }
            r8 = 9
            java.lang.String r8 = r2.extractMetadata(r8)     // Catch:{ Exception -> 0x00a5 }
            boolean r9 = android.text.TextUtils.isEmpty(r8)     // Catch:{ Exception -> 0x00a5 }
            if (r9 == 0) goto L_0x0087
            r8 = r6
            goto L_0x008b
        L_0x0087:
            long r8 = java.lang.Long.parseLong(r8)     // Catch:{ Exception -> 0x00a5 }
        L_0x008b:
            r10 = -1
            android.graphics.Bitmap r10 = r2.getFrameAtTime(r10)     // Catch:{ Exception -> 0x00a6 }
            int r11 = com.oppo.camera.ui.control.ThumbImageView.f3902a     // Catch:{ Exception -> 0x00a6 }
            android.graphics.Bitmap r10 = com.oppo.camera.ui.control.e.b((android.graphics.Bitmap) r10, (int) r11)     // Catch:{ Exception -> 0x00a6 }
            r13.l = r10     // Catch:{ Exception -> 0x00a6 }
        L_0x0099:
            r2.release()
            goto L_0x00ae
        L_0x009d:
            r13 = move-exception
            goto L_0x0164
        L_0x00a0:
            r13 = move-exception
            r2 = r4
            goto L_0x0164
        L_0x00a4:
            r2 = r4
        L_0x00a5:
            r8 = r6
        L_0x00a6:
            java.lang.String r13 = "addVideoToMediaStore, get video duration fail."
            com.oppo.camera.e.a(r1, r13)     // Catch:{ all -> 0x009d }
            if (r2 == 0) goto L_0x00ae
            goto L_0x0099
        L_0x00ae:
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            java.lang.String r2 = "addVideoToMediaStore, Video duration: "
            r13.append(r2)
            r13.append(r8)
            java.lang.String r13 = r13.toString()
            com.oppo.camera.e.a(r1, r13)
            int r13 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            java.lang.String r2 = "duration"
            if (r13 <= 0) goto L_0x00d2
            android.content.ContentValues r13 = r12.i
            java.lang.Long r6 = java.lang.Long.valueOf(r8)
            r13.put(r2, r6)
            goto L_0x00df
        L_0x00d2:
            android.content.ContentValues r13 = r12.i
            long r6 = r12.m()
            java.lang.Long r6 = java.lang.Long.valueOf(r6)
            r13.put(r2, r6)
        L_0x00df:
            android.content.Context r13 = r12.f3597a     // Catch:{ Exception -> 0x0159 }
            if (r13 == 0) goto L_0x016a
            android.content.Context r13 = r12.f3597a     // Catch:{ Exception -> 0x0159 }
            android.content.ContentResolver r13 = r13.getContentResolver()     // Catch:{ Exception -> 0x0159 }
            android.net.Uri r2 = r12.g     // Catch:{ Exception -> 0x0159 }
            android.content.ContentValues r6 = r12.i     // Catch:{ Exception -> 0x0159 }
            r13.update(r2, r6, r4, r4)     // Catch:{ Exception -> 0x0159 }
            boolean r13 = r12.f3598b     // Catch:{ Exception -> 0x0159 }
            if (r13 == 0) goto L_0x0122
            android.net.Uri r13 = r12.g     // Catch:{ Exception -> 0x0159 }
            if (r13 == 0) goto L_0x0122
            android.content.ContentValues r13 = new android.content.ContentValues     // Catch:{ Exception -> 0x0159 }
            r13.<init>()     // Catch:{ Exception -> 0x0159 }
            java.lang.String r2 = "media_id"
            android.net.Uri r6 = r12.g     // Catch:{ Exception -> 0x0159 }
            long r6 = android.content.ContentUris.parseId(r6)     // Catch:{ Exception -> 0x0159 }
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ Exception -> 0x0159 }
            r13.put(r2, r6)     // Catch:{ Exception -> 0x0159 }
            java.lang.String r2 = "content://com.oppo.gallery3d.open.provider/locked_pictures"
            android.net.Uri r2 = android.net.Uri.parse(r2)     // Catch:{ Exception -> 0x0159 }
            android.content.Context r6 = r12.f3597a     // Catch:{ Exception -> 0x0159 }
            android.content.ContentResolver r6 = r6.getContentResolver()     // Catch:{ Exception -> 0x0159 }
            r6.insert(r2, r13)     // Catch:{ Exception -> 0x011c }
            goto L_0x0122
        L_0x011c:
            r13 = move-exception
            java.lang.String r2 = "addVideoToMediaStore, updateLockCameraAlbum, err: "
            com.oppo.camera.e.a((java.lang.String) r1, (java.lang.String) r2, (java.lang.Throwable) r13)     // Catch:{ Exception -> 0x0159 }
        L_0x0122:
            android.content.Context r13 = r12.f3597a     // Catch:{ Exception -> 0x0159 }
            android.content.Intent r2 = new android.content.Intent     // Catch:{ Exception -> 0x0159 }
            java.lang.String r6 = "android.hardware.action.NEW_VIDEO"
            android.net.Uri r7 = r12.g     // Catch:{ Exception -> 0x0159 }
            r2.<init>(r6, r7)     // Catch:{ Exception -> 0x0159 }
            r13.sendBroadcast(r2)     // Catch:{ Exception -> 0x0159 }
            android.content.Context r13 = r12.f3597a     // Catch:{ Exception -> 0x0159 }
            android.net.Uri r2 = r12.g     // Catch:{ Exception -> 0x0159 }
            java.lang.String r6 = "com.coloros.gallery3d"
            com.oppo.camera.util.Util.a((android.content.Context) r13, (android.net.Uri) r2, (java.lang.String) r0, (java.lang.String) r6)     // Catch:{ Exception -> 0x0159 }
            android.content.Context r13 = r12.f3597a     // Catch:{ Exception -> 0x0159 }
            android.net.Uri r2 = r12.g     // Catch:{ Exception -> 0x0159 }
            java.lang.String r6 = "com.heytap.cloud"
            com.oppo.camera.util.Util.a((android.content.Context) r13, (android.net.Uri) r2, (java.lang.String) r0, (java.lang.String) r6)     // Catch:{ Exception -> 0x0159 }
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0159 }
            r13.<init>()     // Catch:{ Exception -> 0x0159 }
            java.lang.String r0 = "addVideoToMediaStore, Video mCurrentVideoUri: "
            r13.append(r0)     // Catch:{ Exception -> 0x0159 }
            android.net.Uri r0 = r12.g     // Catch:{ Exception -> 0x0159 }
            r13.append(r0)     // Catch:{ Exception -> 0x0159 }
            java.lang.String r13 = r13.toString()     // Catch:{ Exception -> 0x0159 }
            com.oppo.camera.e.a(r1, r13)     // Catch:{ Exception -> 0x0159 }
            goto L_0x016a
        L_0x0159:
            r13 = move-exception
            java.lang.String r0 = "addVideoToMediaStore, failed to add video to media store"
            com.oppo.camera.e.a((java.lang.String) r1, (java.lang.String) r0, (java.lang.Throwable) r13)
            r12.g = r4
            r12.f = r4
            goto L_0x016b
        L_0x0164:
            if (r2 == 0) goto L_0x0169
            r2.release()
        L_0x0169:
            throw r13
        L_0x016a:
            r3 = r5
        L_0x016b:
            android.content.ContentValues r13 = r12.i
            if (r13 == 0) goto L_0x0174
            r13.clear()
            r12.i = r4
        L_0x0174:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.s.a.a(com.oppo.camera.ui.control.e$c):boolean");
    }

    public long a(MediaCodec.BufferInfo bufferInfo) {
        this.p++;
        return (long) ((this.p * YuvProcessUtil.ExifInfo.EXPOSURE_MULTIPLE) / c());
    }
}
