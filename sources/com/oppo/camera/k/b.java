package com.oppo.camera.k;

import java.util.HashSet;

/* compiled from: TriggerStateMachine */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static final HashSet<Integer> f3398a = new HashSet<>();

    /* renamed from: b  reason: collision with root package name */
    private static final HashSet<Integer> f3399b = new HashSet<>();
    private C0087b c = C0087b.WAITING_FOR_TRIGGER;
    private Long d = null;

    /* renamed from: com.oppo.camera.k.b$b  reason: collision with other inner class name */
    /* compiled from: TriggerStateMachine */
    private enum C0087b {
        WAITING_FOR_TRIGGER,
        TRIGGERED,
        AE_CONVERGED,
        AF_SCAN
    }

    public b() {
        f3398a.add(0);
        f3398a.add(4);
        f3398a.add(2);
        f3399b.add(2);
        f3399b.add(4);
        f3399b.add(5);
    }

    /* renamed from: com.oppo.camera.k.b$1  reason: invalid class name */
    /* compiled from: TriggerStateMachine */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f3400a = new int[C0087b.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(10:0|1|2|3|4|5|6|7|8|10) */
        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        static {
            /*
                com.oppo.camera.k.b$b[] r0 = com.oppo.camera.k.b.C0087b.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f3400a = r0
                int[] r0 = f3400a     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.oppo.camera.k.b$b r1 = com.oppo.camera.k.b.C0087b.WAITING_FOR_TRIGGER     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f3400a     // Catch:{ NoSuchFieldError -> 0x001f }
                com.oppo.camera.k.b$b r1 = com.oppo.camera.k.b.C0087b.TRIGGERED     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = f3400a     // Catch:{ NoSuchFieldError -> 0x002a }
                com.oppo.camera.k.b$b r1 = com.oppo.camera.k.b.C0087b.AE_CONVERGED     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                int[] r0 = f3400a     // Catch:{ NoSuchFieldError -> 0x0035 }
                com.oppo.camera.k.b$b r1 = com.oppo.camera.k.b.C0087b.AF_SCAN     // Catch:{ NoSuchFieldError -> 0x0035 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.k.b.AnonymousClass1.<clinit>():void");
        }
    }

    public boolean a(a aVar) {
        int i = AnonymousClass1.f3400a[this.c.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        return false;
                    }
                    if (this.d != null && aVar.f3401a <= this.d.longValue()) {
                        return false;
                    }
                    if (!f3399b.contains(aVar.e) && (this.d == null || aVar.f3401a - this.d.longValue() <= 20)) {
                        return false;
                    }
                    this.c = C0087b.WAITING_FOR_TRIGGER;
                    this.d = null;
                    return true;
                } else if (this.d != null && aVar.f3401a <= this.d.longValue()) {
                    return false;
                } else {
                    if (1 == aVar.e.intValue()) {
                        this.c = C0087b.AF_SCAN;
                        this.d = Long.valueOf(aVar.f3401a);
                        return false;
                    } else if (this.d == null || aVar.f3401a - this.d.longValue() <= 10) {
                        return false;
                    } else {
                        this.c = C0087b.WAITING_FOR_TRIGGER;
                        this.d = null;
                        return true;
                    }
                }
            } else if (this.d != null && aVar.f3401a <= this.d.longValue()) {
                return false;
            } else {
                if (!f3398a.contains(aVar.d) && (1 != aVar.d.intValue() || aVar.f3401a - aVar.f3402b <= 60)) {
                    return false;
                }
                if (aVar.f) {
                    this.c = C0087b.AE_CONVERGED;
                    this.d = Long.valueOf(aVar.f3401a);
                    return false;
                }
                this.c = C0087b.WAITING_FOR_TRIGGER;
                this.d = null;
                return true;
            }
        } else if ((this.d != null && aVar.f3401a <= this.d.longValue()) || 1 != aVar.c.intValue()) {
            return false;
        } else {
            this.c = C0087b.TRIGGERED;
            this.d = Long.valueOf(aVar.f3401a);
            return false;
        }
    }

    public void a() {
        this.c = C0087b.WAITING_FOR_TRIGGER;
        this.d = null;
    }

    /* compiled from: TriggerStateMachine */
    class a {

        /* renamed from: a  reason: collision with root package name */
        long f3401a = 0;

        /* renamed from: b  reason: collision with root package name */
        long f3402b = 0;
        Integer c = null;
        Integer d = null;
        Integer e = null;
        boolean f = false;

        a() {
        }

        public String toString() {
            return "mFrameNum: " + this.f3401a + ", mFirstFrameNumber: " + this.f3402b + ", mTriggerState: " + this.c + ", mAeState: " + this.d + ", mAfState: " + this.e + ", mbWaitAf: " + this.f;
        }
    }
}
