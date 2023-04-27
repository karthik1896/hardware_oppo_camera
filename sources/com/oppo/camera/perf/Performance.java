package com.oppo.camera.perf;

import android.content.Context;
import android.os.Environment;
import androidx.annotation.Keep;
import com.google.gson.Gson;
import com.oppo.camera.MyApplication;
import com.oppo.camera.e;
import com.oppo.camera.perf.CameraExitPerformance;
import com.oppo.camera.perf.CapturePerformance;
import com.oppo.camera.perf.ContinuousCapturePerformance;
import com.oppo.camera.perf.LaunchPerformance;
import com.oppo.camera.perf.PictureSavePerformance;
import com.oppo.camera.perf.SwitchCameraPerformance;
import com.oppo.camera.perf.SwitchModePerformance;
import com.oppo.camera.perf.VideoRecordPerformance;
import com.oppo.camera.perf.VideoSavePerformance;
import com.oppo.camera.statistics.model.PerfMonitorMsgData;
import com.oppo.camera.v.c;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Keep
public class Performance {
    private static final int COUNT_LIMIT = 5;
    private static final String FILE_NAME_PREFIX = "camera_data_";
    private static final boolean PERFORMANCE_WRITE_FILE_SWITCH = false;
    private static final String TAG = "OppoPerformance";
    private static Context sContext = MyApplication.d();
    /* access modifiers changed from: private */
    public static AtomicInteger sCount = new AtomicInteger(0);
    private static String sFilePath = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getPath();
    private static Gson sGson = new Gson();
    private static String sMarkFilePath = (sFilePath + File.separator + "switch_mark");
    /* access modifiers changed from: private */
    public static a sPerformanceData = new a();

    public static class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public List<LaunchPerformance.LaunchPerformanceData> f3502a = new ArrayList();
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public Map<Long, CapturePerformance.CapturePerformanceData> f3503b = new HashMap();
        /* access modifiers changed from: private */
        public List<SwitchModePerformance.SwitchModePerformanceData> c = new ArrayList();
        /* access modifiers changed from: private */
        public List<SwitchCameraPerformance.SwitchCameraPerformanceData> d = new ArrayList();
        /* access modifiers changed from: private */
        public List<VideoRecordPerformance.VideoRecordPerformanceData> e = new ArrayList();
        /* access modifiers changed from: private */
        public List<VideoSavePerformance.VideoSavePerformanceData> f = new ArrayList();
        /* access modifiers changed from: private */
        public List<PictureSavePerformance.PictureSavePerformanceData> g = new ArrayList();
        /* access modifiers changed from: private */
        public List<CameraExitPerformance.CameraExitPerformanceData> h = new ArrayList();
        /* access modifiers changed from: private */
        public List<ContinuousCapturePerformance.ContinuousCapturePerformanceData> i = new ArrayList();

        public void a() {
            this.f3502a.clear();
            this.f3503b.clear();
            this.c.clear();
            this.d.clear();
            this.e.clear();
            this.f.clear();
            this.g.clear();
            this.h.clear();
            this.i.clear();
        }
    }

    public static void add(ContinuousCapturePerformance.ContinuousCapturePerformanceData continuousCapturePerformanceData) {
        e.a(TAG, "add, continuousCapturePerformanceData: " + sGson.toJson((Object) continuousCapturePerformanceData));
        PerfMonitorMsgData.reportContinuousCapture(sContext, continuousCapturePerformanceData);
        sPerformanceData.i.add(continuousCapturePerformanceData);
        count();
    }

    public static void add(CameraExitPerformance.CameraExitPerformanceData cameraExitPerformanceData) {
        e.a(TAG, "add, cameraExitPerformanceData: " + sGson.toJson((Object) cameraExitPerformanceData));
        PerfMonitorMsgData.reportCameraExit(sContext, cameraExitPerformanceData);
        sPerformanceData.h.add(cameraExitPerformanceData);
        count();
    }

    public static void add(PictureSavePerformance.PictureSavePerformanceData pictureSavePerformanceData) {
        e.a(TAG, "add, pictureSavePerformanceData: " + sGson.toJson((Object) pictureSavePerformanceData));
        PerfMonitorMsgData.reportPictureSave(sContext, pictureSavePerformanceData);
        com.oppo.camera.g.a.b(pictureSavePerformanceData.getPictureSaveTime());
        sPerformanceData.g.add(pictureSavePerformanceData);
        count();
    }

    public static void add(VideoSavePerformance.VideoSavePerformanceData videoSavePerformanceData) {
        e.a(TAG, "add, videoSavePerformanceData: " + sGson.toJson((Object) videoSavePerformanceData));
        PerfMonitorMsgData.reportVideoSave(sContext, videoSavePerformanceData);
        com.oppo.camera.g.a.c(videoSavePerformanceData.getVideoSaveTime());
        sPerformanceData.f.add(videoSavePerformanceData);
        count();
    }

    public static void add(VideoRecordPerformance.VideoRecordPerformanceData videoRecordPerformanceData) {
        e.a(TAG, "add, videoRecordPerformanceData: " + sGson.toJson((Object) videoRecordPerformanceData));
        PerfMonitorMsgData.reportStartVideoRecord(sContext, videoRecordPerformanceData);
        sPerformanceData.e.add(videoRecordPerformanceData);
        count();
    }

    public static void add(SwitchCameraPerformance.SwitchCameraPerformanceData switchCameraPerformanceData) {
        e.a(TAG, "add, switchCameraPerformanceData: " + sGson.toJson((Object) switchCameraPerformanceData));
        PerfMonitorMsgData.reportSwitchCamera(sContext, switchCameraPerformanceData);
        sPerformanceData.d.add(switchCameraPerformanceData);
        count();
    }

    public static void add(SwitchModePerformance.SwitchModePerformanceData switchModePerformanceData) {
        e.a(TAG, "add, switchModePerformanceData: " + sGson.toJson((Object) switchModePerformanceData));
        PerfMonitorMsgData.reportSwitchMode(sContext, switchModePerformanceData);
        sPerformanceData.c.add(switchModePerformanceData);
        count();
    }

    public static void add(LaunchPerformance.LaunchPerformanceData launchPerformanceData) {
        e.a(TAG, "add, launchPerformanceData: " + sGson.toJson((Object) launchPerformanceData));
        PerfMonitorMsgData.reportLaunch(sContext, launchPerformanceData);
        com.oppo.camera.g.a.a(launchPerformanceData.launchTime());
        sPerformanceData.f3502a.add(launchPerformanceData);
        count();
    }

    public static void add(long j, CapturePerformance.CapturePerformanceData capturePerformanceData) {
        e.a(TAG, "add, capturePerformanceData: " + sGson.toJson((Object) capturePerformanceData));
        PerfMonitorMsgData.reportCapture(sContext, capturePerformanceData);
        sPerformanceData.f3503b.put(Long.valueOf(j), capturePerformanceData);
        count();
    }

    private static void count() {
        if (!new File(sMarkFilePath).exists()) {
            sPerformanceData.a();
        } else {
            c.a().a(new Runnable() {
                public void run() {
                    if (Performance.sCount.incrementAndGet() >= 5) {
                        Performance.sCount.set(0);
                        Performance.writeToFile();
                        Performance.sPerformanceData.a();
                        return;
                    }
                    e.e(Performance.TAG, "count, sCount: " + Performance.sCount.get());
                }
            }, "Perf write file");
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0052 A[SYNTHETIC, Splitter:B:19:0x0052] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x005d A[SYNTHETIC, Splitter:B:24:0x005d] */
    /* JADX WARNING: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void writeToFile() {
        /*
            java.lang.String r0 = generateFileName()
            java.io.File r1 = new java.io.File
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = sFilePath
            r2.append(r3)
            java.lang.String r3 = java.io.File.separator
            r2.append(r3)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0)
            r0 = 0
            boolean r2 = r1.exists()     // Catch:{ IOException -> 0x004c }
            if (r2 != 0) goto L_0x0029
            r1.createNewFile()     // Catch:{ IOException -> 0x004c }
        L_0x0029:
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x004c }
            r2.<init>(r1)     // Catch:{ IOException -> 0x004c }
            com.google.gson.Gson r0 = new com.google.gson.Gson     // Catch:{ IOException -> 0x0046, all -> 0x0044 }
            r0.<init>()     // Catch:{ IOException -> 0x0046, all -> 0x0044 }
            com.oppo.camera.perf.Performance$a r1 = sPerformanceData     // Catch:{ IOException -> 0x0046, all -> 0x0044 }
            java.lang.String r0 = r0.toJson((java.lang.Object) r1)     // Catch:{ IOException -> 0x0046, all -> 0x0044 }
            byte[] r0 = r0.getBytes()     // Catch:{ IOException -> 0x0046, all -> 0x0044 }
            r2.write(r0)     // Catch:{ IOException -> 0x0046, all -> 0x0044 }
            r2.close()     // Catch:{ IOException -> 0x0056 }
            goto L_0x005a
        L_0x0044:
            r1 = move-exception
            goto L_0x005b
        L_0x0046:
            r1 = move-exception
            r0 = r2
            goto L_0x004d
        L_0x0049:
            r1 = move-exception
            r2 = r0
            goto L_0x005b
        L_0x004c:
            r1 = move-exception
        L_0x004d:
            r1.printStackTrace()     // Catch:{ all -> 0x0049 }
            if (r0 == 0) goto L_0x005a
            r0.close()     // Catch:{ IOException -> 0x0056 }
            goto L_0x005a
        L_0x0056:
            r0 = move-exception
            r0.printStackTrace()
        L_0x005a:
            return
        L_0x005b:
            if (r2 == 0) goto L_0x0065
            r2.close()     // Catch:{ IOException -> 0x0061 }
            goto L_0x0065
        L_0x0061:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0065:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.perf.Performance.writeToFile():void");
    }

    private static String generateFileName() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd_hh-mm-ss", Locale.CHINA);
        return FILE_NAME_PREFIX + simpleDateFormat.format(new Date(System.currentTimeMillis())) + ".txt";
    }
}
