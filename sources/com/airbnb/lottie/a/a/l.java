package com.airbnb.lottie.a.a;

import android.annotation.TargetApi;
import android.graphics.Path;
import android.os.Build;
import com.airbnb.lottie.c.b.h;
import java.util.ArrayList;
import java.util.List;

@TargetApi(19)
/* compiled from: MergePathsContent */
public class l implements j, m {

    /* renamed from: a  reason: collision with root package name */
    private final Path f1627a = new Path();

    /* renamed from: b  reason: collision with root package name */
    private final Path f1628b = new Path();
    private final Path c = new Path();
    private final String d;
    private final List<m> e = new ArrayList();
    private final h f;

    public l(h hVar) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.d = hVar.a();
            this.f = hVar;
            return;
        }
        throw new IllegalStateException("Merge paths are not supported pre-KitKat.");
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP:0: B:0:0x0000->B:3:0x000a, LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(java.util.ListIterator<com.airbnb.lottie.a.a.c> r3) {
        /*
            r2 = this;
        L_0x0000:
            boolean r0 = r3.hasPrevious()
            if (r0 == 0) goto L_0x000d
            java.lang.Object r0 = r3.previous()
            if (r0 == r2) goto L_0x000d
            goto L_0x0000
        L_0x000d:
            boolean r0 = r3.hasPrevious()
            if (r0 == 0) goto L_0x0028
            java.lang.Object r0 = r3.previous()
            com.airbnb.lottie.a.a.c r0 = (com.airbnb.lottie.a.a.c) r0
            boolean r1 = r0 instanceof com.airbnb.lottie.a.a.m
            if (r1 == 0) goto L_0x000d
            java.util.List<com.airbnb.lottie.a.a.m> r1 = r2.e
            com.airbnb.lottie.a.a.m r0 = (com.airbnb.lottie.a.a.m) r0
            r1.add(r0)
            r3.remove()
            goto L_0x000d
        L_0x0028:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.a.a.l.a(java.util.ListIterator):void");
    }

    public void a(List<c> list, List<c> list2) {
        for (int i = 0; i < this.e.size(); i++) {
            this.e.get(i).a(list, list2);
        }
    }

    public Path e() {
        this.c.reset();
        if (this.f.c()) {
            return this.c;
        }
        int i = AnonymousClass1.f1629a[this.f.b().ordinal()];
        if (i == 1) {
            a();
        } else if (i == 2) {
            a(Path.Op.UNION);
        } else if (i == 3) {
            a(Path.Op.REVERSE_DIFFERENCE);
        } else if (i == 4) {
            a(Path.Op.INTERSECT);
        } else if (i == 5) {
            a(Path.Op.XOR);
        }
        return this.c;
    }

    /* renamed from: com.airbnb.lottie.a.a.l$1  reason: invalid class name */
    /* compiled from: MergePathsContent */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f1629a = new int[h.a.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0035 */
        static {
            /*
                com.airbnb.lottie.c.b.h$a[] r0 = com.airbnb.lottie.c.b.h.a.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f1629a = r0
                int[] r0 = f1629a     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.airbnb.lottie.c.b.h$a r1 = com.airbnb.lottie.c.b.h.a.MERGE     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f1629a     // Catch:{ NoSuchFieldError -> 0x001f }
                com.airbnb.lottie.c.b.h$a r1 = com.airbnb.lottie.c.b.h.a.ADD     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = f1629a     // Catch:{ NoSuchFieldError -> 0x002a }
                com.airbnb.lottie.c.b.h$a r1 = com.airbnb.lottie.c.b.h.a.SUBTRACT     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                int[] r0 = f1629a     // Catch:{ NoSuchFieldError -> 0x0035 }
                com.airbnb.lottie.c.b.h$a r1 = com.airbnb.lottie.c.b.h.a.INTERSECT     // Catch:{ NoSuchFieldError -> 0x0035 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                int[] r0 = f1629a     // Catch:{ NoSuchFieldError -> 0x0040 }
                com.airbnb.lottie.c.b.h$a r1 = com.airbnb.lottie.c.b.h.a.EXCLUDE_INTERSECTIONS     // Catch:{ NoSuchFieldError -> 0x0040 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0040 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0040 }
            L_0x0040:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.a.a.l.AnonymousClass1.<clinit>():void");
        }
    }

    public String b() {
        return this.d;
    }

    private void a() {
        for (int i = 0; i < this.e.size(); i++) {
            this.c.addPath(this.e.get(i).e());
        }
    }

    @TargetApi(19)
    private void a(Path.Op op) {
        this.f1628b.reset();
        this.f1627a.reset();
        for (int size = this.e.size() - 1; size >= 1; size--) {
            m mVar = this.e.get(size);
            if (mVar instanceof d) {
                d dVar = (d) mVar;
                List<m> c2 = dVar.c();
                for (int size2 = c2.size() - 1; size2 >= 0; size2--) {
                    Path e2 = c2.get(size2).e();
                    e2.transform(dVar.d());
                    this.f1628b.addPath(e2);
                }
            } else {
                this.f1628b.addPath(mVar.e());
            }
        }
        m mVar2 = this.e.get(0);
        if (mVar2 instanceof d) {
            d dVar2 = (d) mVar2;
            List<m> c3 = dVar2.c();
            for (int i = 0; i < c3.size(); i++) {
                Path e3 = c3.get(i).e();
                e3.transform(dVar2.d());
                this.f1627a.addPath(e3);
            }
        } else {
            this.f1627a.set(mVar2.e());
        }
        this.c.op(this.f1627a, this.f1628b, op);
    }
}
