package androidx.constraintlayout.a.a;

import androidx.constraintlayout.a.e;

/* compiled from: Chain */
class c {
    static void a(g gVar, e eVar, int i) {
        int i2;
        d[] dVarArr;
        int i3;
        if (i == 0) {
            int i4 = gVar.an;
            dVarArr = gVar.aq;
            i2 = i4;
            i3 = 0;
        } else {
            i3 = 2;
            i2 = gVar.ao;
            dVarArr = gVar.ap;
        }
        for (int i5 = 0; i5 < i2; i5++) {
            d dVar = dVarArr[i5];
            dVar.a();
            if (!gVar.u(4)) {
                a(gVar, eVar, i, i3, dVar);
            } else if (!k.a(gVar, eVar, i, i3, dVar)) {
                a(gVar, eVar, i, i3, dVar);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0035, code lost:
        if (r2.Z == 2) goto L_0x004a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0048, code lost:
        if (r2.aa == 2) goto L_0x004a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x004c, code lost:
        r5 = false;
     */
    /* JADX WARNING: Removed duplicated region for block: B:190:0x038f  */
    /* JADX WARNING: Removed duplicated region for block: B:199:0x03a8  */
    /* JADX WARNING: Removed duplicated region for block: B:200:0x03ab  */
    /* JADX WARNING: Removed duplicated region for block: B:203:0x03b1  */
    /* JADX WARNING: Removed duplicated region for block: B:251:0x0481  */
    /* JADX WARNING: Removed duplicated region for block: B:256:0x04b6  */
    /* JADX WARNING: Removed duplicated region for block: B:265:0x04db  */
    /* JADX WARNING: Removed duplicated region for block: B:266:0x04e0  */
    /* JADX WARNING: Removed duplicated region for block: B:269:0x04e6  */
    /* JADX WARNING: Removed duplicated region for block: B:270:0x04eb  */
    /* JADX WARNING: Removed duplicated region for block: B:272:0x04ef  */
    /* JADX WARNING: Removed duplicated region for block: B:278:0x0501  */
    /* JADX WARNING: Removed duplicated region for block: B:293:0x0390 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x015b  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0188  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x018c  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0196  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void a(androidx.constraintlayout.a.a.g r35, androidx.constraintlayout.a.e r36, int r37, int r38, androidx.constraintlayout.a.a.d r39) {
        /*
            r0 = r35
            r9 = r36
            r1 = r39
            androidx.constraintlayout.a.a.f r10 = r1.f515a
            androidx.constraintlayout.a.a.f r11 = r1.c
            androidx.constraintlayout.a.a.f r12 = r1.f516b
            androidx.constraintlayout.a.a.f r13 = r1.d
            androidx.constraintlayout.a.a.f r2 = r1.e
            float r3 = r1.k
            androidx.constraintlayout.a.a.f r4 = r1.f
            androidx.constraintlayout.a.a.f r4 = r1.g
            androidx.constraintlayout.a.a.f$a[] r4 = r0.C
            r4 = r4[r37]
            androidx.constraintlayout.a.a.f$a r5 = androidx.constraintlayout.a.a.f.a.WRAP_CONTENT
            r7 = 1
            if (r4 != r5) goto L_0x0021
            r4 = r7
            goto L_0x0022
        L_0x0021:
            r4 = 0
        L_0x0022:
            r5 = 2
            if (r37 != 0) goto L_0x0038
            int r8 = r2.Z
            if (r8 != 0) goto L_0x002b
            r8 = r7
            goto L_0x002c
        L_0x002b:
            r8 = 0
        L_0x002c:
            int r14 = r2.Z
            if (r14 != r7) goto L_0x0032
            r14 = r7
            goto L_0x0033
        L_0x0032:
            r14 = 0
        L_0x0033:
            int r15 = r2.Z
            if (r15 != r5) goto L_0x004c
            goto L_0x004a
        L_0x0038:
            int r8 = r2.aa
            if (r8 != 0) goto L_0x003e
            r8 = r7
            goto L_0x003f
        L_0x003e:
            r8 = 0
        L_0x003f:
            int r14 = r2.aa
            if (r14 != r7) goto L_0x0045
            r14 = r7
            goto L_0x0046
        L_0x0045:
            r14 = 0
        L_0x0046:
            int r15 = r2.aa
            if (r15 != r5) goto L_0x004c
        L_0x004a:
            r5 = r7
            goto L_0x004d
        L_0x004c:
            r5 = 0
        L_0x004d:
            r15 = r8
            r8 = r10
            r16 = r14
            r14 = r5
            r5 = 0
        L_0x0053:
            r21 = 0
            if (r5 != 0) goto L_0x012e
            androidx.constraintlayout.a.a.e[] r7 = r8.A
            r7 = r7[r38]
            if (r4 != 0) goto L_0x0063
            if (r14 == 0) goto L_0x0060
            goto L_0x0063
        L_0x0060:
            r23 = 4
            goto L_0x0065
        L_0x0063:
            r23 = 1
        L_0x0065:
            int r24 = r7.e()
            androidx.constraintlayout.a.a.e r6 = r7.c
            if (r6 == 0) goto L_0x0077
            if (r8 == r10) goto L_0x0077
            androidx.constraintlayout.a.a.e r6 = r7.c
            int r6 = r6.e()
            int r24 = r24 + r6
        L_0x0077:
            r6 = r24
            if (r14 == 0) goto L_0x0085
            if (r8 == r10) goto L_0x0085
            if (r8 == r12) goto L_0x0085
            r24 = r3
            r23 = r5
            r3 = 6
            goto L_0x0095
        L_0x0085:
            if (r15 == 0) goto L_0x008f
            if (r4 == 0) goto L_0x008f
            r24 = r3
            r23 = r5
            r3 = 4
            goto L_0x0095
        L_0x008f:
            r24 = r3
            r3 = r23
            r23 = r5
        L_0x0095:
            androidx.constraintlayout.a.a.e r5 = r7.c
            if (r5 == 0) goto L_0x00c2
            if (r8 != r12) goto L_0x00aa
            androidx.constraintlayout.a.h r5 = r7.f
            r25 = r15
            androidx.constraintlayout.a.a.e r15 = r7.c
            androidx.constraintlayout.a.h r15 = r15.f
            r26 = r2
            r2 = 5
            r9.a((androidx.constraintlayout.a.h) r5, (androidx.constraintlayout.a.h) r15, (int) r6, (int) r2)
            goto L_0x00b8
        L_0x00aa:
            r26 = r2
            r25 = r15
            androidx.constraintlayout.a.h r2 = r7.f
            androidx.constraintlayout.a.a.e r5 = r7.c
            androidx.constraintlayout.a.h r5 = r5.f
            r15 = 6
            r9.a((androidx.constraintlayout.a.h) r2, (androidx.constraintlayout.a.h) r5, (int) r6, (int) r15)
        L_0x00b8:
            androidx.constraintlayout.a.h r2 = r7.f
            androidx.constraintlayout.a.a.e r5 = r7.c
            androidx.constraintlayout.a.h r5 = r5.f
            r9.c(r2, r5, r6, r3)
            goto L_0x00c6
        L_0x00c2:
            r26 = r2
            r25 = r15
        L_0x00c6:
            if (r4 == 0) goto L_0x00fd
            int r2 = r8.l()
            r3 = 8
            if (r2 == r3) goto L_0x00ec
            androidx.constraintlayout.a.a.f$a[] r2 = r8.C
            r2 = r2[r37]
            androidx.constraintlayout.a.a.f$a r3 = androidx.constraintlayout.a.a.f.a.MATCH_CONSTRAINT
            if (r2 != r3) goto L_0x00ec
            androidx.constraintlayout.a.a.e[] r2 = r8.A
            int r3 = r38 + 1
            r2 = r2[r3]
            androidx.constraintlayout.a.h r2 = r2.f
            androidx.constraintlayout.a.a.e[] r3 = r8.A
            r3 = r3[r38]
            androidx.constraintlayout.a.h r3 = r3.f
            r5 = 5
            r6 = 0
            r9.a((androidx.constraintlayout.a.h) r2, (androidx.constraintlayout.a.h) r3, (int) r6, (int) r5)
            goto L_0x00ed
        L_0x00ec:
            r6 = 0
        L_0x00ed:
            androidx.constraintlayout.a.a.e[] r2 = r8.A
            r2 = r2[r38]
            androidx.constraintlayout.a.h r2 = r2.f
            androidx.constraintlayout.a.a.e[] r3 = r0.A
            r3 = r3[r38]
            androidx.constraintlayout.a.h r3 = r3.f
            r5 = 6
            r9.a((androidx.constraintlayout.a.h) r2, (androidx.constraintlayout.a.h) r3, (int) r6, (int) r5)
        L_0x00fd:
            androidx.constraintlayout.a.a.e[] r2 = r8.A
            int r3 = r38 + 1
            r2 = r2[r3]
            androidx.constraintlayout.a.a.e r2 = r2.c
            if (r2 == 0) goto L_0x011e
            androidx.constraintlayout.a.a.f r2 = r2.f517a
            androidx.constraintlayout.a.a.e[] r3 = r2.A
            r3 = r3[r38]
            androidx.constraintlayout.a.a.e r3 = r3.c
            if (r3 == 0) goto L_0x011e
            androidx.constraintlayout.a.a.e[] r3 = r2.A
            r3 = r3[r38]
            androidx.constraintlayout.a.a.e r3 = r3.c
            androidx.constraintlayout.a.a.f r3 = r3.f517a
            if (r3 == r8) goto L_0x011c
            goto L_0x011e
        L_0x011c:
            r21 = r2
        L_0x011e:
            if (r21 == 0) goto L_0x0125
            r8 = r21
            r5 = r23
            goto L_0x0126
        L_0x0125:
            r5 = 1
        L_0x0126:
            r3 = r24
            r15 = r25
            r2 = r26
            goto L_0x0053
        L_0x012e:
            r26 = r2
            r24 = r3
            r25 = r15
            if (r13 == 0) goto L_0x0158
            androidx.constraintlayout.a.a.e[] r2 = r11.A
            int r3 = r38 + 1
            r2 = r2[r3]
            androidx.constraintlayout.a.a.e r2 = r2.c
            if (r2 == 0) goto L_0x0158
            androidx.constraintlayout.a.a.e[] r2 = r13.A
            r2 = r2[r3]
            androidx.constraintlayout.a.h r5 = r2.f
            androidx.constraintlayout.a.a.e[] r6 = r11.A
            r3 = r6[r3]
            androidx.constraintlayout.a.a.e r3 = r3.c
            androidx.constraintlayout.a.h r3 = r3.f
            int r2 = r2.e()
            int r2 = -r2
            r6 = 5
            r9.b(r5, r3, r2, r6)
            goto L_0x0159
        L_0x0158:
            r6 = 5
        L_0x0159:
            if (r4 == 0) goto L_0x0175
            androidx.constraintlayout.a.a.e[] r0 = r0.A
            int r2 = r38 + 1
            r0 = r0[r2]
            androidx.constraintlayout.a.h r0 = r0.f
            androidx.constraintlayout.a.a.e[] r3 = r11.A
            r3 = r3[r2]
            androidx.constraintlayout.a.h r3 = r3.f
            androidx.constraintlayout.a.a.e[] r4 = r11.A
            r2 = r4[r2]
            int r2 = r2.e()
            r4 = 6
            r9.a((androidx.constraintlayout.a.h) r0, (androidx.constraintlayout.a.h) r3, (int) r2, (int) r4)
        L_0x0175:
            java.util.ArrayList<androidx.constraintlayout.a.a.f> r0 = r1.h
            if (r0 == 0) goto L_0x022d
            int r2 = r0.size()
            r3 = 1
            if (r2 <= r3) goto L_0x022d
            boolean r4 = r1.l
            if (r4 == 0) goto L_0x018c
            boolean r4 = r1.n
            if (r4 != 0) goto L_0x018c
            int r4 = r1.j
            float r4 = (float) r4
            goto L_0x018e
        L_0x018c:
            r4 = r24
        L_0x018e:
            r5 = 0
            r28 = r5
            r8 = r21
            r7 = 0
        L_0x0194:
            if (r7 >= r2) goto L_0x022d
            java.lang.Object r15 = r0.get(r7)
            androidx.constraintlayout.a.a.f r15 = (androidx.constraintlayout.a.a.f) r15
            float[] r3 = r15.ad
            r3 = r3[r37]
            int r23 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r23 >= 0) goto L_0x01c2
            boolean r3 = r1.n
            if (r3 == 0) goto L_0x01be
            androidx.constraintlayout.a.a.e[] r3 = r15.A
            int r23 = r38 + 1
            r3 = r3[r23]
            androidx.constraintlayout.a.h r3 = r3.f
            androidx.constraintlayout.a.a.e[] r15 = r15.A
            r15 = r15[r38]
            androidx.constraintlayout.a.h r15 = r15.f
            r5 = 4
            r6 = 0
            r9.c(r3, r15, r6, r5)
            r5 = r6
            r6 = 6
            goto L_0x01db
        L_0x01be:
            r5 = 4
            r3 = 1065353216(0x3f800000, float:1.0)
            goto L_0x01c3
        L_0x01c2:
            r5 = 4
        L_0x01c3:
            r6 = 0
            int r20 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r20 != 0) goto L_0x01e0
            androidx.constraintlayout.a.a.e[] r3 = r15.A
            int r20 = r38 + 1
            r3 = r3[r20]
            androidx.constraintlayout.a.h r3 = r3.f
            androidx.constraintlayout.a.a.e[] r15 = r15.A
            r15 = r15[r38]
            androidx.constraintlayout.a.h r15 = r15.f
            r5 = 0
            r6 = 6
            r9.c(r3, r15, r5, r6)
        L_0x01db:
            r24 = r0
            r22 = r2
            goto L_0x0222
        L_0x01e0:
            r5 = 0
            r6 = 6
            if (r8 == 0) goto L_0x021b
            androidx.constraintlayout.a.a.e[] r5 = r8.A
            r5 = r5[r38]
            androidx.constraintlayout.a.h r5 = r5.f
            androidx.constraintlayout.a.a.e[] r8 = r8.A
            int r22 = r38 + 1
            r8 = r8[r22]
            androidx.constraintlayout.a.h r8 = r8.f
            androidx.constraintlayout.a.a.e[] r6 = r15.A
            r6 = r6[r38]
            androidx.constraintlayout.a.h r6 = r6.f
            r24 = r0
            androidx.constraintlayout.a.a.e[] r0 = r15.A
            r0 = r0[r22]
            androidx.constraintlayout.a.h r0 = r0.f
            r22 = r2
            androidx.constraintlayout.a.b r2 = r36.c()
            r27 = r2
            r29 = r4
            r30 = r3
            r31 = r5
            r32 = r8
            r33 = r6
            r34 = r0
            r27.a((float) r28, (float) r29, (float) r30, (androidx.constraintlayout.a.h) r31, (androidx.constraintlayout.a.h) r32, (androidx.constraintlayout.a.h) r33, (androidx.constraintlayout.a.h) r34)
            r9.a((androidx.constraintlayout.a.b) r2)
            goto L_0x021f
        L_0x021b:
            r24 = r0
            r22 = r2
        L_0x021f:
            r28 = r3
            r8 = r15
        L_0x0222:
            int r7 = r7 + 1
            r2 = r22
            r0 = r24
            r3 = 1
            r5 = 0
            r6 = 5
            goto L_0x0194
        L_0x022d:
            if (r12 == 0) goto L_0x0297
            if (r12 == r13) goto L_0x0233
            if (r14 == 0) goto L_0x0297
        L_0x0233:
            androidx.constraintlayout.a.a.e[] r0 = r10.A
            r0 = r0[r38]
            androidx.constraintlayout.a.a.e[] r1 = r11.A
            int r2 = r38 + 1
            r1 = r1[r2]
            androidx.constraintlayout.a.a.e[] r3 = r10.A
            r3 = r3[r38]
            androidx.constraintlayout.a.a.e r3 = r3.c
            if (r3 == 0) goto L_0x024e
            androidx.constraintlayout.a.a.e[] r3 = r10.A
            r3 = r3[r38]
            androidx.constraintlayout.a.a.e r3 = r3.c
            androidx.constraintlayout.a.h r3 = r3.f
            goto L_0x0250
        L_0x024e:
            r3 = r21
        L_0x0250:
            androidx.constraintlayout.a.a.e[] r4 = r11.A
            r4 = r4[r2]
            androidx.constraintlayout.a.a.e r4 = r4.c
            if (r4 == 0) goto L_0x0262
            androidx.constraintlayout.a.a.e[] r4 = r11.A
            r4 = r4[r2]
            androidx.constraintlayout.a.a.e r4 = r4.c
            androidx.constraintlayout.a.h r4 = r4.f
            r5 = r4
            goto L_0x0264
        L_0x0262:
            r5 = r21
        L_0x0264:
            if (r12 != r13) goto L_0x026e
            androidx.constraintlayout.a.a.e[] r0 = r12.A
            r0 = r0[r38]
            androidx.constraintlayout.a.a.e[] r1 = r12.A
            r1 = r1[r2]
        L_0x026e:
            if (r3 == 0) goto L_0x04c7
            if (r5 == 0) goto L_0x04c7
            if (r37 != 0) goto L_0x0279
            r2 = r26
            float r2 = r2.S
            goto L_0x027d
        L_0x0279:
            r2 = r26
            float r2 = r2.T
        L_0x027d:
            r4 = r2
            int r6 = r0.e()
            int r7 = r1.e()
            androidx.constraintlayout.a.h r2 = r0.f
            androidx.constraintlayout.a.h r8 = r1.f
            r10 = 5
            r0 = r36
            r1 = r2
            r2 = r3
            r3 = r6
            r6 = r8
            r8 = r10
            r0.a(r1, r2, r3, r4, r5, r6, r7, r8)
            goto L_0x04c7
        L_0x0297:
            if (r25 == 0) goto L_0x0394
            if (r12 == 0) goto L_0x0394
            int r0 = r1.j
            if (r0 <= 0) goto L_0x02a8
            int r0 = r1.i
            int r1 = r1.j
            if (r0 != r1) goto L_0x02a8
            r17 = 1
            goto L_0x02aa
        L_0x02a8:
            r17 = 0
        L_0x02aa:
            r14 = r12
            r15 = r14
        L_0x02ac:
            if (r14 == 0) goto L_0x04c7
            androidx.constraintlayout.a.a.f[] r0 = r14.af
            r0 = r0[r37]
            r8 = r0
        L_0x02b3:
            if (r8 == 0) goto L_0x02c2
            int r0 = r8.l()
            r7 = 8
            if (r0 != r7) goto L_0x02c4
            androidx.constraintlayout.a.a.f[] r0 = r8.af
            r8 = r0[r37]
            goto L_0x02b3
        L_0x02c2:
            r7 = 8
        L_0x02c4:
            if (r8 != 0) goto L_0x02d1
            if (r14 != r13) goto L_0x02c9
            goto L_0x02d1
        L_0x02c9:
            r18 = r8
            r19 = 4
            r20 = 6
            goto L_0x0387
        L_0x02d1:
            androidx.constraintlayout.a.a.e[] r0 = r14.A
            r0 = r0[r38]
            androidx.constraintlayout.a.h r1 = r0.f
            androidx.constraintlayout.a.a.e r2 = r0.c
            if (r2 == 0) goto L_0x02e0
            androidx.constraintlayout.a.a.e r2 = r0.c
            androidx.constraintlayout.a.h r2 = r2.f
            goto L_0x02e2
        L_0x02e0:
            r2 = r21
        L_0x02e2:
            if (r15 == r14) goto L_0x02ed
            androidx.constraintlayout.a.a.e[] r2 = r15.A
            int r3 = r38 + 1
            r2 = r2[r3]
            androidx.constraintlayout.a.h r2 = r2.f
            goto L_0x0304
        L_0x02ed:
            if (r14 != r12) goto L_0x0304
            if (r15 != r14) goto L_0x0304
            androidx.constraintlayout.a.a.e[] r2 = r10.A
            r2 = r2[r38]
            androidx.constraintlayout.a.a.e r2 = r2.c
            if (r2 == 0) goto L_0x0302
            androidx.constraintlayout.a.a.e[] r2 = r10.A
            r2 = r2[r38]
            androidx.constraintlayout.a.a.e r2 = r2.c
            androidx.constraintlayout.a.h r2 = r2.f
            goto L_0x0304
        L_0x0302:
            r2 = r21
        L_0x0304:
            int r0 = r0.e()
            androidx.constraintlayout.a.a.e[] r3 = r14.A
            int r4 = r38 + 1
            r3 = r3[r4]
            int r3 = r3.e()
            if (r8 == 0) goto L_0x0321
            androidx.constraintlayout.a.a.e[] r5 = r8.A
            r5 = r5[r38]
            androidx.constraintlayout.a.h r6 = r5.f
            androidx.constraintlayout.a.a.e[] r7 = r14.A
            r7 = r7[r4]
            androidx.constraintlayout.a.h r7 = r7.f
            goto L_0x0334
        L_0x0321:
            androidx.constraintlayout.a.a.e[] r5 = r11.A
            r5 = r5[r4]
            androidx.constraintlayout.a.a.e r5 = r5.c
            if (r5 == 0) goto L_0x032c
            androidx.constraintlayout.a.h r6 = r5.f
            goto L_0x032e
        L_0x032c:
            r6 = r21
        L_0x032e:
            androidx.constraintlayout.a.a.e[] r7 = r14.A
            r7 = r7[r4]
            androidx.constraintlayout.a.h r7 = r7.f
        L_0x0334:
            if (r5 == 0) goto L_0x033b
            int r5 = r5.e()
            int r3 = r3 + r5
        L_0x033b:
            if (r15 == 0) goto L_0x0346
            androidx.constraintlayout.a.a.e[] r5 = r15.A
            r5 = r5[r4]
            int r5 = r5.e()
            int r0 = r0 + r5
        L_0x0346:
            if (r1 == 0) goto L_0x02c9
            if (r2 == 0) goto L_0x02c9
            if (r6 == 0) goto L_0x02c9
            if (r7 == 0) goto L_0x02c9
            if (r14 != r12) goto L_0x0358
            androidx.constraintlayout.a.a.e[] r0 = r12.A
            r0 = r0[r38]
            int r0 = r0.e()
        L_0x0358:
            r5 = r0
            if (r14 != r13) goto L_0x0366
            androidx.constraintlayout.a.a.e[] r0 = r13.A
            r0 = r0[r4]
            int r0 = r0.e()
            r18 = r0
            goto L_0x0368
        L_0x0366:
            r18 = r3
        L_0x0368:
            if (r17 == 0) goto L_0x036d
            r22 = 6
            goto L_0x036f
        L_0x036d:
            r22 = 4
        L_0x036f:
            r4 = 1056964608(0x3f000000, float:0.5)
            r0 = r36
            r3 = r5
            r20 = 4
            r5 = r6
            r23 = 6
            r6 = r7
            r19 = r20
            r20 = r23
            r7 = r18
            r18 = r8
            r8 = r22
            r0.a(r1, r2, r3, r4, r5, r6, r7, r8)
        L_0x0387:
            int r0 = r14.l()
            r8 = 8
            if (r0 == r8) goto L_0x0390
            r15 = r14
        L_0x0390:
            r14 = r18
            goto L_0x02ac
        L_0x0394:
            r8 = 8
            r19 = 4
            r20 = 6
            if (r16 == 0) goto L_0x04c7
            if (r12 == 0) goto L_0x04c7
            int r0 = r1.j
            if (r0 <= 0) goto L_0x03ab
            int r0 = r1.i
            int r1 = r1.j
            if (r0 != r1) goto L_0x03ab
            r17 = 1
            goto L_0x03ad
        L_0x03ab:
            r17 = 0
        L_0x03ad:
            r14 = r12
            r15 = r14
        L_0x03af:
            if (r14 == 0) goto L_0x0469
            androidx.constraintlayout.a.a.f[] r0 = r14.af
            r0 = r0[r37]
        L_0x03b5:
            if (r0 == 0) goto L_0x03c2
            int r1 = r0.l()
            if (r1 != r8) goto L_0x03c2
            androidx.constraintlayout.a.a.f[] r0 = r0.af
            r0 = r0[r37]
            goto L_0x03b5
        L_0x03c2:
            if (r14 == r12) goto L_0x0458
            if (r14 == r13) goto L_0x0458
            if (r0 == 0) goto L_0x0458
            if (r0 != r13) goto L_0x03cd
            r7 = r21
            goto L_0x03ce
        L_0x03cd:
            r7 = r0
        L_0x03ce:
            androidx.constraintlayout.a.a.e[] r0 = r14.A
            r0 = r0[r38]
            androidx.constraintlayout.a.h r1 = r0.f
            androidx.constraintlayout.a.a.e r2 = r0.c
            if (r2 == 0) goto L_0x03dc
            androidx.constraintlayout.a.a.e r2 = r0.c
            androidx.constraintlayout.a.h r2 = r2.f
        L_0x03dc:
            androidx.constraintlayout.a.a.e[] r2 = r15.A
            int r3 = r38 + 1
            r2 = r2[r3]
            androidx.constraintlayout.a.h r2 = r2.f
            int r0 = r0.e()
            androidx.constraintlayout.a.a.e[] r4 = r14.A
            r4 = r4[r3]
            int r4 = r4.e()
            if (r7 == 0) goto L_0x0404
            androidx.constraintlayout.a.a.e[] r5 = r7.A
            r5 = r5[r38]
            androidx.constraintlayout.a.h r6 = r5.f
            androidx.constraintlayout.a.a.e r8 = r5.c
            if (r8 == 0) goto L_0x0401
            androidx.constraintlayout.a.a.e r8 = r5.c
            androidx.constraintlayout.a.h r8 = r8.f
            goto L_0x0417
        L_0x0401:
            r8 = r21
            goto L_0x0417
        L_0x0404:
            androidx.constraintlayout.a.a.e[] r5 = r14.A
            r5 = r5[r3]
            androidx.constraintlayout.a.a.e r5 = r5.c
            if (r5 == 0) goto L_0x040f
            androidx.constraintlayout.a.h r6 = r5.f
            goto L_0x0411
        L_0x040f:
            r6 = r21
        L_0x0411:
            androidx.constraintlayout.a.a.e[] r8 = r14.A
            r8 = r8[r3]
            androidx.constraintlayout.a.h r8 = r8.f
        L_0x0417:
            if (r5 == 0) goto L_0x041e
            int r5 = r5.e()
            int r4 = r4 + r5
        L_0x041e:
            r18 = r4
            if (r15 == 0) goto L_0x042b
            androidx.constraintlayout.a.a.e[] r4 = r15.A
            r3 = r4[r3]
            int r3 = r3.e()
            int r0 = r0 + r3
        L_0x042b:
            r3 = r0
            if (r17 == 0) goto L_0x0431
            r22 = r20
            goto L_0x0433
        L_0x0431:
            r22 = r19
        L_0x0433:
            if (r1 == 0) goto L_0x044f
            if (r2 == 0) goto L_0x044f
            if (r6 == 0) goto L_0x044f
            if (r8 == 0) goto L_0x044f
            r4 = 1056964608(0x3f000000, float:0.5)
            r0 = r36
            r5 = r6
            r6 = r8
            r23 = r7
            r7 = r18
            r18 = r15
            r15 = 8
            r8 = r22
            r0.a(r1, r2, r3, r4, r5, r6, r7, r8)
            goto L_0x0455
        L_0x044f:
            r23 = r7
            r18 = r15
            r15 = 8
        L_0x0455:
            r0 = r23
            goto L_0x045b
        L_0x0458:
            r18 = r15
            r15 = r8
        L_0x045b:
            int r1 = r14.l()
            if (r1 == r15) goto L_0x0462
            goto L_0x0464
        L_0x0462:
            r14 = r18
        L_0x0464:
            r8 = r15
            r15 = r14
            r14 = r0
            goto L_0x03af
        L_0x0469:
            androidx.constraintlayout.a.a.e[] r0 = r12.A
            r0 = r0[r38]
            androidx.constraintlayout.a.a.e[] r1 = r10.A
            r1 = r1[r38]
            androidx.constraintlayout.a.a.e r1 = r1.c
            androidx.constraintlayout.a.a.e[] r2 = r13.A
            int r3 = r38 + 1
            r10 = r2[r3]
            androidx.constraintlayout.a.a.e[] r2 = r11.A
            r2 = r2[r3]
            androidx.constraintlayout.a.a.e r14 = r2.c
            if (r1 == 0) goto L_0x04b6
            if (r12 == r13) goto L_0x0490
            androidx.constraintlayout.a.h r2 = r0.f
            androidx.constraintlayout.a.h r1 = r1.f
            int r0 = r0.e()
            r15 = 5
            r9.c(r2, r1, r0, r15)
            goto L_0x04b7
        L_0x0490:
            r15 = 5
            if (r14 == 0) goto L_0x04b7
            androidx.constraintlayout.a.h r2 = r0.f
            androidx.constraintlayout.a.h r3 = r1.f
            int r4 = r0.e()
            r5 = 1056964608(0x3f000000, float:0.5)
            androidx.constraintlayout.a.h r6 = r10.f
            androidx.constraintlayout.a.h r7 = r14.f
            int r8 = r10.e()
            r17 = 5
            r0 = r36
            r1 = r2
            r2 = r3
            r3 = r4
            r4 = r5
            r5 = r6
            r6 = r7
            r7 = r8
            r8 = r17
            r0.a(r1, r2, r3, r4, r5, r6, r7, r8)
            goto L_0x04b7
        L_0x04b6:
            r15 = 5
        L_0x04b7:
            if (r14 == 0) goto L_0x04c7
            if (r12 == r13) goto L_0x04c7
            androidx.constraintlayout.a.h r0 = r10.f
            androidx.constraintlayout.a.h r1 = r14.f
            int r2 = r10.e()
            int r2 = -r2
            r9.c(r0, r1, r2, r15)
        L_0x04c7:
            if (r25 != 0) goto L_0x04cb
            if (r16 == 0) goto L_0x052e
        L_0x04cb:
            if (r12 == 0) goto L_0x052e
            androidx.constraintlayout.a.a.e[] r0 = r12.A
            r0 = r0[r38]
            androidx.constraintlayout.a.a.e[] r1 = r13.A
            int r2 = r38 + 1
            r1 = r1[r2]
            androidx.constraintlayout.a.a.e r3 = r0.c
            if (r3 == 0) goto L_0x04e0
            androidx.constraintlayout.a.a.e r3 = r0.c
            androidx.constraintlayout.a.h r3 = r3.f
            goto L_0x04e2
        L_0x04e0:
            r3 = r21
        L_0x04e2:
            androidx.constraintlayout.a.a.e r4 = r1.c
            if (r4 == 0) goto L_0x04eb
            androidx.constraintlayout.a.a.e r4 = r1.c
            androidx.constraintlayout.a.h r4 = r4.f
            goto L_0x04ed
        L_0x04eb:
            r4 = r21
        L_0x04ed:
            if (r11 == r13) goto L_0x04fe
            androidx.constraintlayout.a.a.e[] r4 = r11.A
            r4 = r4[r2]
            androidx.constraintlayout.a.a.e r5 = r4.c
            if (r5 == 0) goto L_0x04fc
            androidx.constraintlayout.a.a.e r4 = r4.c
            androidx.constraintlayout.a.h r4 = r4.f
            goto L_0x04fe
        L_0x04fc:
            r4 = r21
        L_0x04fe:
            r5 = r4
            if (r12 != r13) goto L_0x0509
            androidx.constraintlayout.a.a.e[] r0 = r12.A
            r0 = r0[r38]
            androidx.constraintlayout.a.a.e[] r1 = r12.A
            r1 = r1[r2]
        L_0x0509:
            if (r3 == 0) goto L_0x052e
            if (r5 == 0) goto L_0x052e
            r4 = 1056964608(0x3f000000, float:0.5)
            int r6 = r0.e()
            if (r13 != 0) goto L_0x0516
            goto L_0x0517
        L_0x0516:
            r11 = r13
        L_0x0517:
            androidx.constraintlayout.a.a.e[] r7 = r11.A
            r2 = r7[r2]
            int r7 = r2.e()
            androidx.constraintlayout.a.h r2 = r0.f
            androidx.constraintlayout.a.h r8 = r1.f
            r10 = 5
            r0 = r36
            r1 = r2
            r2 = r3
            r3 = r6
            r6 = r8
            r8 = r10
            r0.a(r1, r2, r3, r4, r5, r6, r7, r8)
        L_0x052e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.a.a.c.a(androidx.constraintlayout.a.a.g, androidx.constraintlayout.a.e, int, int, androidx.constraintlayout.a.a.d):void");
    }
}
