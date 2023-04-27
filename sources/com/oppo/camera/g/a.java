package com.oppo.camera.g;

import android.os.OplusManager;
import android.util.ArrayMap;
import com.oppo.camera.e;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* compiled from: DiagnosisTools */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static LinkedHashMap<Long, Long> f3245a = new LinkedHashMap<Long, Long>() {
        /* access modifiers changed from: protected */
        public boolean removeEldestEntry(Map.Entry<Long, Long> entry) {
            return size() > 10;
        }
    };

    /* renamed from: b  reason: collision with root package name */
    private static LinkedHashMap<Long, Long> f3246b = new LinkedHashMap<Long, Long>() {
        /* access modifiers changed from: protected */
        public boolean removeEldestEntry(Map.Entry<Long, Long> entry) {
            return size() > 10;
        }
    };
    private static Executor c = Executors.newSingleThreadExecutor();
    private static long d = -1;
    private static long e = -1;
    private static boolean f = false;

    public static void a(long j, long j2) {
        if (!f) {
            if (j >= 70 && j <= 150) {
                f3245a.put(Long.valueOf(j2), Long.valueOf(j));
            }
            if (10 == f3245a.size() && a(f3245a, d)) {
                Map.Entry<Long, Long> b2 = b(f3245a);
                if (b2 != null) {
                    d = b2.getKey().longValue();
                }
                ArrayMap arrayMap = new ArrayMap();
                arrayMap.put("preview_frame_gap", String.valueOf(f3245a));
                a("070102", (Map<String, String>) arrayMap);
                e.a("DiagnosisTools", "map: " + arrayMap);
                f = true;
                f3245a.clear();
            }
        }
    }

    private static boolean a(LinkedHashMap<Long, Long> linkedHashMap, long j) {
        Map.Entry<Long, Long> b2 = b(linkedHashMap);
        Map.Entry<Long, Long> a2 = a(linkedHashMap);
        if (b2 == null || a2 == null || b2.getKey().longValue() - a2.getKey().longValue() != 9 || j >= a2.getKey().longValue()) {
            return false;
        }
        return true;
    }

    private static <K, V> Map.Entry<K, V> a(LinkedHashMap<K, V> linkedHashMap) {
        if (linkedHashMap.size() > 0) {
            return (Map.Entry) linkedHashMap.entrySet().toArray()[0];
        }
        return null;
    }

    private static <K, V> Map.Entry<K, V> b(LinkedHashMap<K, V> linkedHashMap) {
        if (linkedHashMap.size() > 0) {
            return (Map.Entry) linkedHashMap.entrySet().toArray()[linkedHashMap.size() - 1];
        }
        return null;
    }

    public static void a(long j) {
        e.a("DiagnosisTools", "reportLaunchTime, launchTime: " + j);
        if (j >= 2500 && j <= 10000) {
            ArrayMap arrayMap = new ArrayMap();
            arrayMap.put("launch_time", String.valueOf(j));
            a("070103", (Map<String, String>) arrayMap);
        }
    }

    public static void b(long j) {
        e.a("DiagnosisTools", "reportCaptureTime, captureTime: " + j);
        if (j >= 4000 && j <= 10000) {
            ArrayMap arrayMap = new ArrayMap();
            arrayMap.put("capture_time", String.valueOf(j));
            a("070101", (Map<String, String>) arrayMap);
        }
    }

    public static void c(long j) {
        e.a("DiagnosisTools", "reportVideoSaveTime, videoSaveTime: " + j);
        if (j >= 2500 && j <= 10000) {
            ArrayMap arrayMap = new ArrayMap();
            arrayMap.put("video_save_time", String.valueOf(j));
            a("070105", (Map<String, String>) arrayMap);
        }
    }

    public static void b(long j, long j2) {
        if (j >= 50 && j <= 150) {
            f3246b.put(Long.valueOf(j2), Long.valueOf(j));
        }
        if (10 == f3246b.size() && a(f3246b, e)) {
            Map.Entry<Long, Long> b2 = b(f3246b);
            if (b2 != null) {
                e = b2.getKey().longValue();
            }
            ArrayMap arrayMap = new ArrayMap();
            arrayMap.put("video_recording_frame_gap", String.valueOf(f3246b));
            a("070104", (Map<String, String>) arrayMap);
        }
    }

    private static void a(final String str, final Map<String, String> map) {
        e.a("DiagnosisTools", "report, eventId: " + str + ", map: " + map);
        c.execute(new Runnable() {
            public void run() {
                OplusManager.onStamp(str, map);
            }
        });
    }

    public static void a() {
        d = -1;
        e = -1;
        f = false;
    }
}
