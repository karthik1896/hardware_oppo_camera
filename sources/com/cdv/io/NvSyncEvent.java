package com.cdv.io;

import android.util.Log;

public class NvSyncEvent {
    private boolean m_manualReset = false;
    private volatile boolean m_signaled = false;

    public NvSyncEvent(boolean z) {
        this.m_manualReset = z;
    }

    public void setEvent() {
        synchronized (this) {
            if (!this.m_signaled) {
                this.m_signaled = true;
                notifyAll();
            }
        }
    }

    public void resetEvent() {
        synchronized (this) {
            this.m_signaled = false;
        }
    }

    public boolean waitEvent(long j) {
        boolean z;
        int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        if (i == 0) {
            synchronized (this) {
                z = this.m_signaled;
            }
            return z;
        } else if (i > 0) {
            return waitEventWithTimeout(j);
        } else {
            try {
                synchronized (this) {
                    while (!this.m_signaled) {
                        wait();
                    }
                    if (!this.m_manualReset) {
                        this.m_signaled = false;
                    }
                }
                return true;
            } catch (Exception e) {
                Log.e("SyncEvent", "" + e.getMessage());
                e.printStackTrace();
                return false;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x000e, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0030, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean waitEventWithTimeout(long r8) {
        /*
            r7 = this;
            r0 = 0
            monitor-enter(r7)     // Catch:{ Exception -> 0x0034 }
            boolean r1 = r7.m_signaled     // Catch:{ all -> 0x0031 }
            r2 = 1
            if (r1 == 0) goto L_0x000f
            boolean r8 = r7.m_manualReset     // Catch:{ all -> 0x0031 }
            if (r8 != 0) goto L_0x000d
            r7.m_signaled = r0     // Catch:{ all -> 0x0031 }
        L_0x000d:
            monitor-exit(r7)     // Catch:{ all -> 0x0031 }
            return r2
        L_0x000f:
            long r3 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x0031 }
        L_0x0013:
            boolean r1 = r7.m_signaled     // Catch:{ all -> 0x0031 }
            if (r1 != 0) goto L_0x0029
            r7.wait(r8)     // Catch:{ all -> 0x0031 }
            long r5 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x0031 }
            long r3 = r5 - r3
            int r1 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1))
            if (r1 < 0) goto L_0x0026
            monitor-exit(r7)     // Catch:{ all -> 0x0031 }
            return r0
        L_0x0026:
            long r8 = r8 - r3
            r3 = r5
            goto L_0x0013
        L_0x0029:
            boolean r8 = r7.m_manualReset     // Catch:{ all -> 0x0031 }
            if (r8 != 0) goto L_0x002f
            r7.m_signaled = r0     // Catch:{ all -> 0x0031 }
        L_0x002f:
            monitor-exit(r7)     // Catch:{ all -> 0x0031 }
            return r2
        L_0x0031:
            r8 = move-exception
            monitor-exit(r7)     // Catch:{ all -> 0x0031 }
            throw r8     // Catch:{ Exception -> 0x0034 }
        L_0x0034:
            r8 = move-exception
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r1 = ""
            r9.append(r1)
            java.lang.String r1 = r8.getMessage()
            r9.append(r1)
            java.lang.String r9 = r9.toString()
            java.lang.String r1 = "SyncEvent"
            android.util.Log.e(r1, r9)
            r8.printStackTrace()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cdv.io.NvSyncEvent.waitEventWithTimeout(long):boolean");
    }
}
