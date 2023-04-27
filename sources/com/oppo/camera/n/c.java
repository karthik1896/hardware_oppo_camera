package com.oppo.camera.n;

import android.app.Activity;
import android.app.ActivityManager;
import android.os.Debug;
import android.os.Process;
import com.oppo.camera.e;
import com.oppo.camera.util.Util;
import com.oppo.camera.z;

/* compiled from: MemoryMonitor */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private Runtime f3448a;

    /* renamed from: b  reason: collision with root package name */
    private long f3449b;
    private long c;
    private long d;
    private boolean e;
    private String f;

    public c() {
        this.f3448a = Runtime.getRuntime();
        this.f3449b = 0;
        this.c = 0;
        this.d = 0;
        this.e = false;
        this.f = null;
        this.f3449b = this.f3448a.maxMemory();
        e.a("MemoryMonitor", "MemoryMonitor, mMaxMemory: " + this.f3449b);
    }

    public void a(long j) {
        String str;
        if (this.c == 0 || (str = this.f) == null || !str.equals(z.r)) {
            this.c = z.c(z.r) - 50000000;
            this.d = 0;
            this.e = true;
            this.f = z.r;
        }
        this.d += j;
    }

    public boolean a(Activity activity, long j) {
        boolean z;
        Debug.MemoryInfo[] processMemoryInfo;
        Debug.MemoryInfo memoryInfo;
        long freeMemory = this.f3449b - (this.f3448a.totalMemory() - this.f3448a.freeMemory());
        if (freeMemory <= j) {
            e.d("MemoryMonitor", "checkMemoryAndStorage, realfree(" + freeMemory + ") <= minLeftMemory(" + j + ")");
            z = false;
        } else {
            z = true;
        }
        if (z && activity != null) {
            ActivityManager activityManager = (ActivityManager) activity.getSystemService("activity");
            ActivityManager.MemoryInfo memoryInfo2 = new ActivityManager.MemoryInfo();
            activityManager.getMemoryInfo(memoryInfo2);
            if (memoryInfo2.availMem <= memoryInfo2.threshold) {
                e.d("MemoryMonitor", "checkMemoryAndStorage, availMem(" + memoryInfo2.availMem + ") <= threshold(" + memoryInfo2.threshold + ")");
                z = false;
            }
            if (Util.M() && (processMemoryInfo = activityManager.getProcessMemoryInfo(new int[]{Process.myPid()})) != null && processMemoryInfo.length > 0 && (memoryInfo = processMemoryInfo[0]) != null) {
                e.a("MemoryMonitor", "checkMemoryAndStorage, totalPss: " + memoryInfo.getTotalPss() + ", dalvikPss: " + memoryInfo.dalvikPss + ", nativePss: " + memoryInfo.nativePss + ", otherPss: " + memoryInfo.otherPss);
            }
        }
        String str = this.f;
        if (str != null && !str.equals(z.r)) {
            a(0);
        }
        if (this.e && this.d >= this.c) {
            e.d("MemoryMonitor", "mLeftStorage(" + this.c + ") <= mUsedStorage(" + this.d + ")");
        }
        return z;
    }
}
