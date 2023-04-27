package com.oppo.camera.perf;

import androidx.annotation.Keep;
import com.oppo.camera.e;
import com.oppo.camera.gl.w;
import java.util.ArrayDeque;

@Keep
public class CapturePerformance {
    private static final long CAPTURE_TIME_LIMIT = 4000;
    private static final String TAG = "CapturePerformance";
    private static ArrayDeque<Long> sShowThumbnailQueue = new ArrayDeque<>();
    private static ArrayDeque<Long> sShutterTimeQueue = new ArrayDeque<>();

    @Keep
    public static class CapturePerformanceData {
        private long mCaptureTime;

        public CapturePerformanceData(long j) {
            this.mCaptureTime = j;
        }
    }

    public static void addClickShutterTime(long j) {
        e.a(TAG, "addClickShutterTime, clickShutterTime: " + w.a(j));
        sShutterTimeQueue.add(Long.valueOf(j));
    }

    public static void addShowThumbnailTime(long j) {
        sShowThumbnailQueue.add(Long.valueOf(j));
        e.a(TAG, "addShowThumbnailTime, sShutterTimeQueue.size: " + sShutterTimeQueue.size() + ", sShowThumbnailQueue.size: " + sShowThumbnailQueue.size());
        Long poll = sShutterTimeQueue.poll();
        sShutterTimeQueue.clear();
        if (poll != null) {
            onEnd(poll, sShowThumbnailQueue.poll());
        } else {
            clear();
        }
    }

    private static void onEnd(Long l, Long l2) {
        if (l != null && l2 != null) {
            long longValue = l2.longValue() - l.longValue();
            e.a(TAG, "onEnd, clickShutterTime: " + w.a(l.longValue()) + ", showThumbnailTime: " + w.a(l2.longValue()) + ", time: " + longValue);
            if (longValue <= 0 || CAPTURE_TIME_LIMIT <= longValue) {
                clear();
            } else {
                Performance.add(l.longValue(), new CapturePerformanceData(longValue));
            }
        }
    }

    private static void clear() {
        sShutterTimeQueue.clear();
        sShowThumbnailQueue.clear();
    }
}
