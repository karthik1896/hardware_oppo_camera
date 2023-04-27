package com.oppo.camera.statistics;

import android.hardware.camera2.CaptureResult;
import android.util.Log;
import android.util.Range;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class QualityReport {
    private static final int EVENT_ID_PREVIEW_STUCK = 14004201;
    private static final int EVENT_ID_START = 14001201;
    private static final int EVENT_ID_SWITCH_CAMERA = 14002201;
    private static final int EVENT_ID_SWITCH_MODE = 14003201;
    private static final int FPS_LOWER = 15;
    private static final int MS_IN_SECOND = 1000;
    private static final float PREVIEW_STUCK_FRAME = 15.0f;
    private static final String TAG = "Quality";
    private static Method mMethodLogP;
    private int mFpsLower;
    private String mModeName;
    private int mPreviewStuckCount;
    private Status mStatus;
    private long mTs;
    private boolean mbFront;

    public enum Status {
        idle,
        start,
        switchMode,
        switchCamera,
        preview
    }

    public QualityReport() {
        this.mStatus = Status.idle;
        this.mTs = 0;
        this.mModeName = null;
        this.mbFront = false;
        this.mPreviewStuckCount = 0;
        this.mFpsLower = 0;
        this.mStatus = Status.start;
        this.mTs = System.currentTimeMillis();
    }

    private void report(int i, Object... objArr) {
        StringBuilder sb = new StringBuilder();
        sb.append(i);
        sb.append(":");
        for (Object append : objArr) {
            sb.append(" ");
            sb.append(append);
        }
        logP(sb.toString());
    }

    private static void logP(String str) {
        if (mMethodLogP == null) {
            try {
                mMethodLogP = Log.class.getDeclaredMethod("p", new Class[]{String.class, String.class});
                mMethodLogP.setAccessible(true);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        }
        Method method = mMethodLogP;
        if (method != null) {
            try {
                method.invoke((Object) null, new Object[]{TAG, str});
            } catch (IllegalAccessException | InvocationTargetException e2) {
                e2.printStackTrace();
            }
        }
    }

    public void onSwitchMode(String str) {
        this.mTs = System.currentTimeMillis();
        this.mModeName = str;
        this.mStatus = Status.switchMode;
    }

    public void onSwitchCamera(boolean z) {
        this.mTs = System.currentTimeMillis();
        this.mbFront = z;
        this.mStatus = Status.switchCamera;
    }

    public void onFirstFrame(CaptureResult captureResult) {
        Range range = (Range) captureResult.get(CaptureResult.CONTROL_AE_TARGET_FPS_RANGE);
        int i = AnonymousClass1.$SwitchMap$com$oppo$camera$statistics$QualityReport$Status[this.mStatus.ordinal()];
        if (i == 1) {
            report(EVENT_ID_START, Long.valueOf(System.currentTimeMillis() - this.mTs));
            preview(range);
        } else if (i == 2) {
            report(EVENT_ID_SWITCH_MODE, this.mModeName, Long.valueOf(System.currentTimeMillis() - this.mTs));
            preview(range);
        } else if (i == 3) {
            report(EVENT_ID_SWITCH_CAMERA, Boolean.valueOf(this.mbFront), Long.valueOf(System.currentTimeMillis() - this.mTs));
            preview(range);
        }
    }

    /* renamed from: com.oppo.camera.statistics.QualityReport$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$oppo$camera$statistics$QualityReport$Status = new int[Status.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|8) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        static {
            /*
                com.oppo.camera.statistics.QualityReport$Status[] r0 = com.oppo.camera.statistics.QualityReport.Status.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$oppo$camera$statistics$QualityReport$Status = r0
                int[] r0 = $SwitchMap$com$oppo$camera$statistics$QualityReport$Status     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.oppo.camera.statistics.QualityReport$Status r1 = com.oppo.camera.statistics.QualityReport.Status.start     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = $SwitchMap$com$oppo$camera$statistics$QualityReport$Status     // Catch:{ NoSuchFieldError -> 0x001f }
                com.oppo.camera.statistics.QualityReport$Status r1 = com.oppo.camera.statistics.QualityReport.Status.switchMode     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = $SwitchMap$com$oppo$camera$statistics$QualityReport$Status     // Catch:{ NoSuchFieldError -> 0x002a }
                com.oppo.camera.statistics.QualityReport$Status r1 = com.oppo.camera.statistics.QualityReport.Status.switchCamera     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.statistics.QualityReport.AnonymousClass1.<clinit>():void");
        }
    }

    private void preview(Range<Integer> range) {
        this.mTs = System.currentTimeMillis();
        if (range != null) {
            this.mFpsLower = range.getLower().intValue();
        } else {
            this.mFpsLower = 15;
        }
        this.mStatus = Status.preview;
    }

    public void onPreview() {
        if (Status.preview == this.mStatus) {
            if (1000.0f / ((float) this.mFpsLower) < ((float) (System.currentTimeMillis() - this.mTs))) {
                this.mPreviewStuckCount++;
            } else {
                this.mPreviewStuckCount = 0;
            }
            if (((float) this.mPreviewStuckCount) > PREVIEW_STUCK_FRAME) {
                report(EVENT_ID_PREVIEW_STUCK, new Object[0]);
            }
            this.mTs = System.currentTimeMillis();
        }
    }
}
