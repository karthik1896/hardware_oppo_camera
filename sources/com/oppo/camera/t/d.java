package com.oppo.camera.t;

import android.app.Activity;
import android.graphics.PointF;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.oppo.camera.aps.config.CameraConfig;
import com.oppo.camera.aps.config.ConfigDataBase;
import com.oppo.camera.e;
import com.oppo.camera.statistics.CameraStatisticsUtil;
import com.oppo.camera.ui.f;
import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: SuperTextManager */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private Activity f3754a = null;

    /* renamed from: b  reason: collision with root package name */
    private f f3755b = null;
    private a c = null;
    private b d = null;
    private final Object e = new Object();
    private HandlerThread f = null;
    private Handler g = null;
    private boolean h = false;
    private Map<Long, a> i = new LinkedHashMap<Long, a>() {
        /* access modifiers changed from: protected */
        public boolean removeEldestEntry(Map.Entry<Long, a> entry) {
            return size() > 5;
        }
    };

    public d(Activity activity, f fVar) {
        this.f3754a = activity;
        this.f3755b = fVar;
        this.d = c.d();
        this.f = new HandlerThread("SuperTextManager");
        this.f.start();
        this.g = new Handler(this.f.getLooper()) {
            public void handleMessage(Message message) {
                e.a("SuperTextManager", "handleMessage, what: " + message.what);
                int i = message.what;
                if (i == 101) {
                    Bundle data = message.getData();
                    int i2 = data.getInt(CameraStatisticsUtil.IMAGE_WIDTH);
                    int i3 = data.getInt(CameraStatisticsUtil.IMAGE_HEIGHT);
                    int i4 = data.getInt(CameraStatisticsUtil.PORTRAIT_ORIENTATION);
                    long j = data.getLong("timestamp");
                    if (i2 > 0 && i3 > 0) {
                        d.this.a(i2, i3, i4, j);
                    }
                } else if (i == 102) {
                    long j2 = message.getData().getLong("timestamp");
                    d.this.b((byte[]) message.obj, message.arg1, message.arg2, j2);
                }
            }
        };
    }

    public void a(int i2) {
        this.d.a(i2);
        d();
    }

    public int a() {
        return this.d.b();
    }

    public void b() {
        e.a("SuperTextManager", "init, mSuperTextEngine: " + this.d);
        if (this.d != null) {
            a(false);
            this.d.a(CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPER_TEXT_CPU_PROCESS));
        }
    }

    public boolean c() {
        b bVar = this.d;
        if (bVar != null) {
            return bVar.a();
        }
        return false;
    }

    public void a(boolean z) {
        this.d.b(z);
    }

    public a a(long j) {
        synchronized (this.e) {
            if (this.i.size() <= 0) {
                a aVar = new a();
                return aVar;
            }
            int i2 = 0;
            long j2 = 0;
            a aVar2 = null;
            for (Long longValue : this.i.keySet()) {
                long longValue2 = longValue.longValue();
                a aVar3 = this.i.get(Long.valueOf(longValue2));
                if (aVar3 != null && aVar3.c()) {
                    i2++;
                    j2 = longValue2;
                    aVar2 = aVar3;
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("getProperDetectResultByTimestamp, time diff: ");
            long j3 = j - j2;
            sb.append(j3);
            sb.append(", availableCount: ");
            sb.append(i2);
            sb.append(", availableResult: ");
            sb.append(aVar2);
            e.a("SuperTextManager", sb.toString());
            if (i2 >= 2 && aVar2 != null && aVar2.c() && j3 <= 500) {
                return aVar2;
            }
            d();
            a aVar4 = new a();
            return aVar4;
        }
    }

    public void d() {
        synchronized (this.e) {
            this.i.clear();
        }
    }

    private void a(long j, a aVar) {
        synchronized (this.e) {
            this.i.put(Long.valueOf(System.currentTimeMillis()), aVar);
        }
    }

    /* access modifiers changed from: private */
    public void a(int i2, int i3, int i4, long j) {
        if (!c()) {
            a a2 = this.d.a(i2, i3, i4, true);
            if (!c()) {
                if (g()) {
                    a(a2);
                    this.f3755b.a(a2);
                } else {
                    this.f3755b.a((a) null);
                }
                a(j, a2);
            }
        }
    }

    public void a(byte[] bArr, int i2, int i3, long j) {
        if (!this.h) {
            Message obtain = Message.obtain();
            Bundle bundle = new Bundle();
            bundle.putLong("timestamp", j);
            obtain.what = 102;
            obtain.obj = bArr;
            obtain.arg1 = i2;
            obtain.arg2 = i3;
            obtain.setData(bundle);
            this.g.sendMessage(obtain);
        }
    }

    public void b(byte[] bArr, int i2, int i3, long j) {
        b bVar;
        this.h = true;
        if (!c() && (bVar = this.d) != null) {
            a a2 = bVar.a(bArr, i2, i3, a());
            if (!c()) {
                if (g()) {
                    a(a2);
                    this.f3755b.a(a2);
                } else {
                    this.f3755b.a((a) null);
                }
                a(j, a2);
            }
        }
        this.h = false;
    }

    public boolean a(int i2, int i3, int i4, int i5, long j) {
        b bVar = this.d;
        if (bVar == null || !bVar.a(i2, i3, i4, i5)) {
            return false;
        }
        Message obtain = Message.obtain();
        obtain.what = 101;
        Bundle bundle = new Bundle();
        bundle.putInt(CameraStatisticsUtil.IMAGE_WIDTH, i3);
        bundle.putInt(CameraStatisticsUtil.IMAGE_HEIGHT, i4);
        bundle.putInt(CameraStatisticsUtil.PORTRAIT_ORIENTATION, i5);
        bundle.putLong("timestamp", j);
        obtain.setData(bundle);
        this.g.sendMessage(obtain);
        e.a("SuperTextManager", "setOesTextureId, sendMsg");
        return true;
    }

    public void e() {
        this.d.c();
    }

    public void f() {
        HandlerThread handlerThread = this.f;
        if (handlerThread != null) {
            handlerThread.quitSafely();
        }
        Handler handler = this.g;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
            this.g = null;
        }
    }

    private void a(a aVar) {
        if (aVar == null || this.c == null || !aVar.c() || !this.c.c()) {
            this.c = aVar;
            return;
        }
        PointF[] b2 = aVar.b();
        PointF[] b3 = this.c.b();
        boolean[] zArr = new boolean[b3.length];
        int i2 = 0;
        for (int i3 = 0; i3 < zArr.length; i3++) {
            zArr[i3] = false;
        }
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        while (true) {
            boolean z = true;
            if (i4 >= b2.length) {
                break;
            }
            int i7 = 0;
            while (true) {
                if (i7 >= b3.length) {
                    z = false;
                    break;
                } else if (a(b2[i4], b3[i7]) <= 1.0E-4f) {
                    b2[i4] = b3[i7];
                    i5++;
                    zArr[i7] = true;
                    break;
                } else {
                    i7++;
                }
            }
            if (!z) {
                i6 = i4;
            }
            i4++;
        }
        if (i5 == b2.length - 1) {
            while (true) {
                if (i2 >= b3.length) {
                    break;
                } else if (zArr[i2]) {
                    i2++;
                } else if (a(b2[i6], b3[i2]) <= 0.01f) {
                    b2[i6] = b3[i2];
                    e.a("SuperTextManager", "optimisedResult, 3 points are reusable then reuse the fourth one");
                }
            }
        }
        this.c = aVar;
    }

    private float a(PointF pointF, PointF pointF2) {
        float f2 = ((pointF.x - pointF2.x) * (pointF.x - pointF2.x)) + ((pointF.y - pointF2.y) * (pointF.y - pointF2.y));
        BigDecimal bigDecimal = new BigDecimal((double) f2);
        e.a("SuperTextManager", "calcDiff, result: " + bigDecimal + ", p1: " + pointF + ", p2: " + pointF2);
        return f2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0037, code lost:
        return r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean g() {
        /*
            r6 = this;
            java.lang.Object r0 = r6.e
            monitor-enter(r0)
            java.util.Map<java.lang.Long, com.oppo.camera.t.a> r1 = r6.i     // Catch:{ all -> 0x0038 }
            int r1 = r1.size()     // Catch:{ all -> 0x0038 }
            r2 = 5
            r3 = 1
            if (r1 >= r2) goto L_0x000f
            monitor-exit(r0)     // Catch:{ all -> 0x0038 }
            return r3
        L_0x000f:
            java.util.Map<java.lang.Long, com.oppo.camera.t.a> r1 = r6.i     // Catch:{ all -> 0x0038 }
            java.util.Collection r1 = r1.values()     // Catch:{ all -> 0x0038 }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x0038 }
            r2 = 0
            r4 = r2
        L_0x001b:
            boolean r5 = r1.hasNext()     // Catch:{ all -> 0x0038 }
            if (r5 == 0) goto L_0x0032
            java.lang.Object r5 = r1.next()     // Catch:{ all -> 0x0038 }
            com.oppo.camera.t.a r5 = (com.oppo.camera.t.a) r5     // Catch:{ all -> 0x0038 }
            if (r5 == 0) goto L_0x001b
            boolean r5 = r5.c()     // Catch:{ all -> 0x0038 }
            if (r5 == 0) goto L_0x001b
            int r4 = r4 + 1
            goto L_0x001b
        L_0x0032:
            r1 = 3
            if (r4 < r1) goto L_0x0036
            r2 = r3
        L_0x0036:
            monitor-exit(r0)     // Catch:{ all -> 0x0038 }
            return r2
        L_0x0038:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0038 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.t.d.g():boolean");
    }
}
