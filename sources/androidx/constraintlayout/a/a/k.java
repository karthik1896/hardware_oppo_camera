package androidx.constraintlayout.a.a;

import androidx.constraintlayout.a.a.f;
import androidx.constraintlayout.a.e;

/* compiled from: Optimizer */
public class k {

    /* renamed from: a  reason: collision with root package name */
    static boolean[] f527a = new boolean[3];

    static void a(g gVar, e eVar, f fVar) {
        if (gVar.C[0] != f.a.WRAP_CONTENT && fVar.C[0] == f.a.MATCH_PARENT) {
            int i = fVar.s.d;
            int p = gVar.p() - fVar.u.d;
            fVar.s.f = eVar.a((Object) fVar.s);
            fVar.u.f = eVar.a((Object) fVar.u);
            eVar.a(fVar.s.f, i);
            eVar.a(fVar.u.f, p);
            fVar.f520a = 2;
            fVar.c(i, p);
        }
        if (gVar.C[1] != f.a.WRAP_CONTENT && fVar.C[1] == f.a.MATCH_PARENT) {
            int i2 = fVar.t.d;
            int r = gVar.r() - fVar.v.d;
            fVar.t.f = eVar.a((Object) fVar.t);
            fVar.v.f = eVar.a((Object) fVar.v);
            eVar.a(fVar.t.f, i2);
            eVar.a(fVar.v.f, r);
            if (fVar.O > 0 || fVar.l() == 8) {
                fVar.w.f = eVar.a((Object) fVar.w);
                eVar.a(fVar.w.f, fVar.O + i2);
            }
            fVar.f521b = 2;
            fVar.d(i2, r);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x003d A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean a(androidx.constraintlayout.a.a.f r3, int r4) {
        /*
            androidx.constraintlayout.a.a.f$a[] r0 = r3.C
            r0 = r0[r4]
            androidx.constraintlayout.a.a.f$a r1 = androidx.constraintlayout.a.a.f.a.MATCH_CONSTRAINT
            r2 = 0
            if (r0 == r1) goto L_0x000a
            return r2
        L_0x000a:
            float r0 = r3.G
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            r1 = 1
            if (r0 == 0) goto L_0x001f
            androidx.constraintlayout.a.a.f$a[] r3 = r3.C
            if (r4 != 0) goto L_0x0017
            goto L_0x0018
        L_0x0017:
            r1 = r2
        L_0x0018:
            r3 = r3[r1]
            androidx.constraintlayout.a.a.f$a r4 = androidx.constraintlayout.a.a.f.a.MATCH_CONSTRAINT
            if (r3 != r4) goto L_0x001e
        L_0x001e:
            return r2
        L_0x001f:
            if (r4 != 0) goto L_0x002f
            int r4 = r3.e
            if (r4 == 0) goto L_0x0026
            return r2
        L_0x0026:
            int r4 = r3.h
            if (r4 != 0) goto L_0x002e
            int r3 = r3.i
            if (r3 == 0) goto L_0x003d
        L_0x002e:
            return r2
        L_0x002f:
            int r4 = r3.f
            if (r4 == 0) goto L_0x0034
            return r2
        L_0x0034:
            int r4 = r3.k
            if (r4 != 0) goto L_0x003e
            int r3 = r3.l
            if (r3 == 0) goto L_0x003d
            goto L_0x003e
        L_0x003d:
            return r1
        L_0x003e:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.a.a.k.a(androidx.constraintlayout.a.a.f, int):boolean");
    }

    static void a(int i, f fVar) {
        f fVar2 = fVar;
        fVar.g();
        m a2 = fVar2.s.a();
        m a3 = fVar2.t.a();
        m a4 = fVar2.u.a();
        m a5 = fVar2.v.a();
        boolean z = (i & 8) == 8;
        boolean z2 = fVar2.C[0] == f.a.MATCH_CONSTRAINT && a(fVar2, 0);
        if (!(a2.g == 4 || a4.g == 4)) {
            if (fVar2.C[0] == f.a.FIXED || (z2 && fVar.l() == 8)) {
                if (fVar2.s.c == null && fVar2.u.c == null) {
                    a2.b(1);
                    a4.b(1);
                    if (z) {
                        a4.a(a2, 1, fVar.i());
                    } else {
                        a4.a(a2, fVar.p());
                    }
                } else if (fVar2.s.c != null && fVar2.u.c == null) {
                    a2.b(1);
                    a4.b(1);
                    if (z) {
                        a4.a(a2, 1, fVar.i());
                    } else {
                        a4.a(a2, fVar.p());
                    }
                } else if (fVar2.s.c == null && fVar2.u.c != null) {
                    a2.b(1);
                    a4.b(1);
                    a2.a(a4, -fVar.p());
                    if (z) {
                        a2.a(a4, -1, fVar.i());
                    } else {
                        a2.a(a4, -fVar.p());
                    }
                } else if (!(fVar2.s.c == null || fVar2.u.c == null)) {
                    a2.b(2);
                    a4.b(2);
                    if (z) {
                        fVar.i().a(a2);
                        fVar.i().a(a4);
                        a2.b(a4, -1, fVar.i());
                        a4.b(a2, 1, fVar.i());
                    } else {
                        a2.b(a4, (float) (-fVar.p()));
                        a4.b(a2, (float) fVar.p());
                    }
                }
            } else if (z2) {
                int p = fVar.p();
                a2.b(1);
                a4.b(1);
                if (fVar2.s.c == null && fVar2.u.c == null) {
                    if (z) {
                        a4.a(a2, 1, fVar.i());
                    } else {
                        a4.a(a2, p);
                    }
                } else if (fVar2.s.c == null || fVar2.u.c != null) {
                    if (fVar2.s.c != null || fVar2.u.c == null) {
                        if (!(fVar2.s.c == null || fVar2.u.c == null)) {
                            if (z) {
                                fVar.i().a(a2);
                                fVar.i().a(a4);
                            }
                            if (fVar2.G == 0.0f) {
                                a2.b(3);
                                a4.b(3);
                                a2.b(a4, 0.0f);
                                a4.b(a2, 0.0f);
                            } else {
                                a2.b(2);
                                a4.b(2);
                                a2.b(a4, (float) (-p));
                                a4.b(a2, (float) p);
                                fVar2.j(p);
                            }
                        }
                    } else if (z) {
                        a2.a(a4, -1, fVar.i());
                    } else {
                        a2.a(a4, -p);
                    }
                } else if (z) {
                    a4.a(a2, 1, fVar.i());
                } else {
                    a4.a(a2, p);
                }
            }
        }
        boolean z3 = fVar2.C[1] == f.a.MATCH_CONSTRAINT && a(fVar2, 1);
        if (a3.g != 4 && a5.g != 4) {
            if (fVar2.C[1] == f.a.FIXED || (z3 && fVar.l() == 8)) {
                if (fVar2.t.c == null && fVar2.v.c == null) {
                    a3.b(1);
                    a5.b(1);
                    if (z) {
                        a5.a(a3, 1, fVar.j());
                    } else {
                        a5.a(a3, fVar.r());
                    }
                    if (fVar2.w.c != null) {
                        fVar2.w.a().b(1);
                        a3.a(1, fVar2.w.a(), -fVar2.O);
                    }
                } else if (fVar2.t.c != null && fVar2.v.c == null) {
                    a3.b(1);
                    a5.b(1);
                    if (z) {
                        a5.a(a3, 1, fVar.j());
                    } else {
                        a5.a(a3, fVar.r());
                    }
                    if (fVar2.O > 0) {
                        fVar2.w.a().a(1, a3, fVar2.O);
                    }
                } else if (fVar2.t.c == null && fVar2.v.c != null) {
                    a3.b(1);
                    a5.b(1);
                    if (z) {
                        a3.a(a5, -1, fVar.j());
                    } else {
                        a3.a(a5, -fVar.r());
                    }
                    if (fVar2.O > 0) {
                        fVar2.w.a().a(1, a3, fVar2.O);
                    }
                } else if (fVar2.t.c != null && fVar2.v.c != null) {
                    a3.b(2);
                    a5.b(2);
                    if (z) {
                        a3.b(a5, -1, fVar.j());
                        a5.b(a3, 1, fVar.j());
                        fVar.j().a(a3);
                        fVar.i().a(a5);
                    } else {
                        a3.b(a5, (float) (-fVar.r()));
                        a5.b(a3, (float) fVar.r());
                    }
                    if (fVar2.O > 0) {
                        fVar2.w.a().a(1, a3, fVar2.O);
                    }
                }
            } else if (z3) {
                int r = fVar.r();
                a3.b(1);
                a5.b(1);
                if (fVar2.t.c == null && fVar2.v.c == null) {
                    if (z) {
                        a5.a(a3, 1, fVar.j());
                    } else {
                        a5.a(a3, r);
                    }
                } else if (fVar2.t.c == null || fVar2.v.c != null) {
                    if (fVar2.t.c != null || fVar2.v.c == null) {
                        if (fVar2.t.c != null && fVar2.v.c != null) {
                            if (z) {
                                fVar.j().a(a3);
                                fVar.i().a(a5);
                            }
                            if (fVar2.G == 0.0f) {
                                a3.b(3);
                                a5.b(3);
                                a3.b(a5, 0.0f);
                                a5.b(a3, 0.0f);
                                return;
                            }
                            a3.b(2);
                            a5.b(2);
                            a3.b(a5, (float) (-r));
                            a5.b(a3, (float) r);
                            fVar2.k(r);
                            if (fVar2.O > 0) {
                                fVar2.w.a().a(1, a3, fVar2.O);
                            }
                        }
                    } else if (z) {
                        a3.a(a5, -1, fVar.j());
                    } else {
                        a3.a(a5, -r);
                    }
                } else if (z) {
                    a5.a(a3, 1, fVar.j());
                } else {
                    a5.a(a3, r);
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0032, code lost:
        if (r7.Z == 2) goto L_0x0034;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0036, code lost:
        r2 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0048, code lost:
        if (r7.aa == 2) goto L_0x0034;
     */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0105  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0109  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static boolean a(androidx.constraintlayout.a.a.g r23, androidx.constraintlayout.a.e r24, int r25, int r26, androidx.constraintlayout.a.a.d r27) {
        /*
            r0 = r24
            r1 = r25
            r2 = r27
            androidx.constraintlayout.a.a.f r3 = r2.f515a
            androidx.constraintlayout.a.a.f r4 = r2.c
            androidx.constraintlayout.a.a.f r5 = r2.f516b
            androidx.constraintlayout.a.a.f r6 = r2.d
            androidx.constraintlayout.a.a.f r7 = r2.e
            float r8 = r2.k
            androidx.constraintlayout.a.a.f r9 = r2.f
            androidx.constraintlayout.a.a.f r2 = r2.g
            r9 = r23
            androidx.constraintlayout.a.a.f$a[] r2 = r9.C
            r2 = r2[r1]
            androidx.constraintlayout.a.a.f$a r9 = androidx.constraintlayout.a.a.f.a.WRAP_CONTENT
            r2 = 2
            r10 = 1
            if (r1 != 0) goto L_0x0038
            int r11 = r7.Z
            if (r11 != 0) goto L_0x0028
            r11 = r10
            goto L_0x0029
        L_0x0028:
            r11 = 0
        L_0x0029:
            int r12 = r7.Z
            if (r12 != r10) goto L_0x002f
            r12 = r10
            goto L_0x0030
        L_0x002f:
            r12 = 0
        L_0x0030:
            int r7 = r7.Z
            if (r7 != r2) goto L_0x0036
        L_0x0034:
            r2 = r10
            goto L_0x004b
        L_0x0036:
            r2 = 0
            goto L_0x004b
        L_0x0038:
            int r11 = r7.aa
            if (r11 != 0) goto L_0x003e
            r11 = r10
            goto L_0x003f
        L_0x003e:
            r11 = 0
        L_0x003f:
            int r12 = r7.aa
            if (r12 != r10) goto L_0x0045
            r12 = r10
            goto L_0x0046
        L_0x0045:
            r12 = 0
        L_0x0046:
            int r7 = r7.aa
            if (r7 != r2) goto L_0x0036
            goto L_0x0034
        L_0x004b:
            r14 = r3
            r10 = 0
            r13 = 0
            r15 = 0
            r16 = 0
            r17 = 0
        L_0x0053:
            r7 = 8
            if (r13 != 0) goto L_0x010c
            int r9 = r14.l()
            if (r9 == r7) goto L_0x00a1
            int r15 = r15 + 1
            if (r1 != 0) goto L_0x0066
            int r9 = r14.p()
            goto L_0x006a
        L_0x0066:
            int r9 = r14.r()
        L_0x006a:
            float r9 = (float) r9
            float r16 = r16 + r9
            if (r14 == r5) goto L_0x007a
            androidx.constraintlayout.a.a.e[] r9 = r14.A
            r9 = r9[r26]
            int r9 = r9.e()
            float r9 = (float) r9
            float r16 = r16 + r9
        L_0x007a:
            if (r14 == r6) goto L_0x0089
            androidx.constraintlayout.a.a.e[] r9 = r14.A
            int r19 = r26 + 1
            r9 = r9[r19]
            int r9 = r9.e()
            float r9 = (float) r9
            float r16 = r16 + r9
        L_0x0089:
            androidx.constraintlayout.a.a.e[] r9 = r14.A
            r9 = r9[r26]
            int r9 = r9.e()
            float r9 = (float) r9
            float r17 = r17 + r9
            androidx.constraintlayout.a.a.e[] r9 = r14.A
            int r19 = r26 + 1
            r9 = r9[r19]
            int r9 = r9.e()
            float r9 = (float) r9
            float r17 = r17 + r9
        L_0x00a1:
            androidx.constraintlayout.a.a.e[] r9 = r14.A
            r9 = r9[r26]
            int r9 = r14.l()
            if (r9 == r7) goto L_0x00df
            androidx.constraintlayout.a.a.f$a[] r7 = r14.C
            r7 = r7[r1]
            androidx.constraintlayout.a.a.f$a r9 = androidx.constraintlayout.a.a.f.a.MATCH_CONSTRAINT
            if (r7 != r9) goto L_0x00df
            int r10 = r10 + 1
            if (r1 != 0) goto L_0x00c7
            int r7 = r14.e
            if (r7 == 0) goto L_0x00bd
            r7 = 0
            return r7
        L_0x00bd:
            r7 = 0
            int r9 = r14.h
            if (r9 != 0) goto L_0x00c6
            int r9 = r14.i
            if (r9 == 0) goto L_0x00d6
        L_0x00c6:
            return r7
        L_0x00c7:
            r7 = 0
            int r9 = r14.f
            if (r9 == 0) goto L_0x00cd
            return r7
        L_0x00cd:
            int r9 = r14.k
            if (r9 != 0) goto L_0x00de
            int r9 = r14.l
            if (r9 == 0) goto L_0x00d6
            goto L_0x00de
        L_0x00d6:
            float r9 = r14.G
            r18 = 0
            int r9 = (r9 > r18 ? 1 : (r9 == r18 ? 0 : -1))
            if (r9 == 0) goto L_0x00df
        L_0x00de:
            return r7
        L_0x00df:
            androidx.constraintlayout.a.a.e[] r7 = r14.A
            int r9 = r26 + 1
            r7 = r7[r9]
            androidx.constraintlayout.a.a.e r7 = r7.c
            if (r7 == 0) goto L_0x0101
            androidx.constraintlayout.a.a.f r7 = r7.f517a
            androidx.constraintlayout.a.a.e[] r9 = r7.A
            r9 = r9[r26]
            androidx.constraintlayout.a.a.e r9 = r9.c
            if (r9 == 0) goto L_0x0101
            androidx.constraintlayout.a.a.e[] r9 = r7.A
            r9 = r9[r26]
            androidx.constraintlayout.a.a.e r9 = r9.c
            androidx.constraintlayout.a.a.f r9 = r9.f517a
            if (r9 == r14) goto L_0x00fe
            goto L_0x0101
        L_0x00fe:
            r19 = r7
            goto L_0x0103
        L_0x0101:
            r19 = 0
        L_0x0103:
            if (r19 == 0) goto L_0x0109
            r14 = r19
            goto L_0x0053
        L_0x0109:
            r13 = 1
            goto L_0x0053
        L_0x010c:
            androidx.constraintlayout.a.a.e[] r9 = r3.A
            r9 = r9[r26]
            androidx.constraintlayout.a.a.m r9 = r9.a()
            androidx.constraintlayout.a.a.e[] r13 = r4.A
            int r19 = r26 + 1
            r13 = r13[r19]
            androidx.constraintlayout.a.a.m r13 = r13.a()
            androidx.constraintlayout.a.a.m r7 = r9.c
            if (r7 == 0) goto L_0x038e
            androidx.constraintlayout.a.a.m r7 = r13.c
            if (r7 != 0) goto L_0x0128
            goto L_0x038e
        L_0x0128:
            androidx.constraintlayout.a.a.m r7 = r9.c
            int r7 = r7.i
            r20 = r3
            r3 = 1
            if (r7 != r3) goto L_0x038c
            androidx.constraintlayout.a.a.m r7 = r13.c
            int r7 = r7.i
            if (r7 == r3) goto L_0x0139
            goto L_0x038c
        L_0x0139:
            if (r10 <= 0) goto L_0x013f
            if (r10 == r15) goto L_0x013f
            r3 = 0
            return r3
        L_0x013f:
            if (r2 != 0) goto L_0x0148
            if (r11 != 0) goto L_0x0148
            if (r12 == 0) goto L_0x0146
            goto L_0x0148
        L_0x0146:
            r7 = 0
            goto L_0x0161
        L_0x0148:
            if (r5 == 0) goto L_0x0154
            androidx.constraintlayout.a.a.e[] r3 = r5.A
            r3 = r3[r26]
            int r3 = r3.e()
            float r7 = (float) r3
            goto L_0x0155
        L_0x0154:
            r7 = 0
        L_0x0155:
            if (r6 == 0) goto L_0x0161
            androidx.constraintlayout.a.a.e[] r3 = r6.A
            r3 = r3[r19]
            int r3 = r3.e()
            float r3 = (float) r3
            float r7 = r7 + r3
        L_0x0161:
            androidx.constraintlayout.a.a.m r3 = r9.c
            float r3 = r3.f
            androidx.constraintlayout.a.a.m r6 = r13.c
            float r6 = r6.f
            int r13 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r13 >= 0) goto L_0x016f
            float r6 = r6 - r3
            goto L_0x0171
        L_0x016f:
            float r6 = r3 - r6
        L_0x0171:
            float r6 = r6 - r16
            r21 = 1
            if (r10 <= 0) goto L_0x0226
            if (r10 != r15) goto L_0x0226
            androidx.constraintlayout.a.a.f r2 = r14.k()
            if (r2 == 0) goto L_0x018d
            androidx.constraintlayout.a.a.f r2 = r14.k()
            androidx.constraintlayout.a.a.f$a[] r2 = r2.C
            r2 = r2[r1]
            androidx.constraintlayout.a.a.f$a r5 = androidx.constraintlayout.a.a.f.a.WRAP_CONTENT
            if (r2 != r5) goto L_0x018d
            r2 = 0
            return r2
        L_0x018d:
            float r6 = r6 + r16
            float r6 = r6 - r17
            r2 = r20
        L_0x0193:
            if (r2 == 0) goto L_0x0224
            androidx.constraintlayout.a.f r5 = androidx.constraintlayout.a.e.g
            if (r5 == 0) goto L_0x01b1
            androidx.constraintlayout.a.f r5 = androidx.constraintlayout.a.e.g
            long r11 = r5.B
            long r11 = r11 - r21
            r5.B = r11
            androidx.constraintlayout.a.f r5 = androidx.constraintlayout.a.e.g
            long r11 = r5.s
            long r11 = r11 + r21
            r5.s = r11
            androidx.constraintlayout.a.f r5 = androidx.constraintlayout.a.e.g
            long r11 = r5.y
            long r11 = r11 + r21
            r5.y = r11
        L_0x01b1:
            androidx.constraintlayout.a.a.f[] r5 = r2.af
            r5 = r5[r1]
            if (r5 != 0) goto L_0x01b9
            if (r2 != r4) goto L_0x0221
        L_0x01b9:
            float r7 = (float) r10
            float r7 = r6 / r7
            r11 = 0
            int r12 = (r8 > r11 ? 1 : (r8 == r11 ? 0 : -1))
            if (r12 <= 0) goto L_0x01d3
            float[] r7 = r2.ad
            r7 = r7[r1]
            r11 = -1082130432(0xffffffffbf800000, float:-1.0)
            int r7 = (r7 > r11 ? 1 : (r7 == r11 ? 0 : -1))
            if (r7 != 0) goto L_0x01cd
            r7 = 0
            goto L_0x01d3
        L_0x01cd:
            float[] r7 = r2.ad
            r7 = r7[r1]
            float r7 = r7 * r6
            float r7 = r7 / r8
        L_0x01d3:
            int r11 = r2.l()
            r12 = 8
            if (r11 != r12) goto L_0x01dc
            r7 = 0
        L_0x01dc:
            androidx.constraintlayout.a.a.e[] r11 = r2.A
            r11 = r11[r26]
            int r11 = r11.e()
            float r11 = (float) r11
            float r3 = r3 + r11
            androidx.constraintlayout.a.a.e[] r11 = r2.A
            r11 = r11[r26]
            androidx.constraintlayout.a.a.m r11 = r11.a()
            androidx.constraintlayout.a.a.m r12 = r9.e
            r11.a((androidx.constraintlayout.a.a.m) r12, (float) r3)
            androidx.constraintlayout.a.a.e[] r11 = r2.A
            r11 = r11[r19]
            androidx.constraintlayout.a.a.m r11 = r11.a()
            androidx.constraintlayout.a.a.m r12 = r9.e
            float r3 = r3 + r7
            r11.a((androidx.constraintlayout.a.a.m) r12, (float) r3)
            androidx.constraintlayout.a.a.e[] r7 = r2.A
            r7 = r7[r26]
            androidx.constraintlayout.a.a.m r7 = r7.a()
            r7.a((androidx.constraintlayout.a.e) r0)
            androidx.constraintlayout.a.a.e[] r7 = r2.A
            r7 = r7[r19]
            androidx.constraintlayout.a.a.m r7 = r7.a()
            r7.a((androidx.constraintlayout.a.e) r0)
            androidx.constraintlayout.a.a.e[] r2 = r2.A
            r2 = r2[r19]
            int r2 = r2.e()
            float r2 = (float) r2
            float r3 = r3 + r2
        L_0x0221:
            r2 = r5
            goto L_0x0193
        L_0x0224:
            r2 = 1
            return r2
        L_0x0226:
            r8 = 0
            int r8 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r8 >= 0) goto L_0x022e
            r2 = 1
            r11 = 0
            r12 = 0
        L_0x022e:
            if (r2 == 0) goto L_0x02b2
            float r6 = r6 - r7
            r2 = r20
            float r5 = r2.g(r1)
            float r6 = r6 * r5
            float r3 = r3 + r6
        L_0x0239:
            if (r2 == 0) goto L_0x02b9
            androidx.constraintlayout.a.f r5 = androidx.constraintlayout.a.e.g
            if (r5 == 0) goto L_0x0257
            androidx.constraintlayout.a.f r5 = androidx.constraintlayout.a.e.g
            long r6 = r5.B
            long r6 = r6 - r21
            r5.B = r6
            androidx.constraintlayout.a.f r5 = androidx.constraintlayout.a.e.g
            long r6 = r5.s
            long r6 = r6 + r21
            r5.s = r6
            androidx.constraintlayout.a.f r5 = androidx.constraintlayout.a.e.g
            long r6 = r5.y
            long r6 = r6 + r21
            r5.y = r6
        L_0x0257:
            androidx.constraintlayout.a.a.f[] r5 = r2.af
            r5 = r5[r1]
            if (r5 != 0) goto L_0x025f
            if (r2 != r4) goto L_0x02b0
        L_0x025f:
            if (r1 != 0) goto L_0x0266
            int r6 = r2.p()
            goto L_0x026a
        L_0x0266:
            int r6 = r2.r()
        L_0x026a:
            float r6 = (float) r6
            androidx.constraintlayout.a.a.e[] r7 = r2.A
            r7 = r7[r26]
            int r7 = r7.e()
            float r7 = (float) r7
            float r3 = r3 + r7
            androidx.constraintlayout.a.a.e[] r7 = r2.A
            r7 = r7[r26]
            androidx.constraintlayout.a.a.m r7 = r7.a()
            androidx.constraintlayout.a.a.m r8 = r9.e
            r7.a((androidx.constraintlayout.a.a.m) r8, (float) r3)
            androidx.constraintlayout.a.a.e[] r7 = r2.A
            r7 = r7[r19]
            androidx.constraintlayout.a.a.m r7 = r7.a()
            androidx.constraintlayout.a.a.m r8 = r9.e
            float r3 = r3 + r6
            r7.a((androidx.constraintlayout.a.a.m) r8, (float) r3)
            androidx.constraintlayout.a.a.e[] r6 = r2.A
            r6 = r6[r26]
            androidx.constraintlayout.a.a.m r6 = r6.a()
            r6.a((androidx.constraintlayout.a.e) r0)
            androidx.constraintlayout.a.a.e[] r6 = r2.A
            r6 = r6[r19]
            androidx.constraintlayout.a.a.m r6 = r6.a()
            r6.a((androidx.constraintlayout.a.e) r0)
            androidx.constraintlayout.a.a.e[] r2 = r2.A
            r2 = r2[r19]
            int r2 = r2.e()
            float r2 = (float) r2
            float r3 = r3 + r2
        L_0x02b0:
            r2 = r5
            goto L_0x0239
        L_0x02b2:
            r2 = r20
            if (r11 != 0) goto L_0x02bc
            if (r12 == 0) goto L_0x02b9
            goto L_0x02bc
        L_0x02b9:
            r0 = 1
            goto L_0x038b
        L_0x02bc:
            if (r11 == 0) goto L_0x02c0
        L_0x02be:
            float r6 = r6 - r7
            goto L_0x02c3
        L_0x02c0:
            if (r12 == 0) goto L_0x02c3
            goto L_0x02be
        L_0x02c3:
            int r7 = r15 + 1
            float r7 = (float) r7
            float r7 = r6 / r7
            if (r12 == 0) goto L_0x02d5
            r8 = 1
            if (r15 <= r8) goto L_0x02d1
            int r7 = r15 + -1
            float r7 = (float) r7
            goto L_0x02d3
        L_0x02d1:
            r7 = 1073741824(0x40000000, float:2.0)
        L_0x02d3:
            float r7 = r6 / r7
        L_0x02d5:
            int r6 = r2.l()
            r8 = 8
            if (r6 == r8) goto L_0x02e0
            float r6 = r3 + r7
            goto L_0x02e1
        L_0x02e0:
            r6 = r3
        L_0x02e1:
            if (r12 == 0) goto L_0x02f0
            r8 = 1
            if (r15 <= r8) goto L_0x02f0
            androidx.constraintlayout.a.a.e[] r6 = r5.A
            r6 = r6[r26]
            int r6 = r6.e()
            float r6 = (float) r6
            float r6 = r6 + r3
        L_0x02f0:
            if (r11 == 0) goto L_0x02fe
            if (r5 == 0) goto L_0x02fe
            androidx.constraintlayout.a.a.e[] r3 = r5.A
            r3 = r3[r26]
            int r3 = r3.e()
            float r3 = (float) r3
            float r6 = r6 + r3
        L_0x02fe:
            if (r2 == 0) goto L_0x02b9
            androidx.constraintlayout.a.f r3 = androidx.constraintlayout.a.e.g
            if (r3 == 0) goto L_0x031c
            androidx.constraintlayout.a.f r3 = androidx.constraintlayout.a.e.g
            long r10 = r3.B
            long r10 = r10 - r21
            r3.B = r10
            androidx.constraintlayout.a.f r3 = androidx.constraintlayout.a.e.g
            long r10 = r3.s
            long r10 = r10 + r21
            r3.s = r10
            androidx.constraintlayout.a.f r3 = androidx.constraintlayout.a.e.g
            long r10 = r3.y
            long r10 = r10 + r21
            r3.y = r10
        L_0x031c:
            androidx.constraintlayout.a.a.f[] r3 = r2.af
            r3 = r3[r1]
            if (r3 != 0) goto L_0x0328
            if (r2 != r4) goto L_0x0325
            goto L_0x0328
        L_0x0325:
            r8 = 8
            goto L_0x0388
        L_0x0328:
            if (r1 != 0) goto L_0x032f
            int r8 = r2.p()
            goto L_0x0333
        L_0x032f:
            int r8 = r2.r()
        L_0x0333:
            float r8 = (float) r8
            if (r2 == r5) goto L_0x0340
            androidx.constraintlayout.a.a.e[] r10 = r2.A
            r10 = r10[r26]
            int r10 = r10.e()
            float r10 = (float) r10
            float r6 = r6 + r10
        L_0x0340:
            androidx.constraintlayout.a.a.e[] r10 = r2.A
            r10 = r10[r26]
            androidx.constraintlayout.a.a.m r10 = r10.a()
            androidx.constraintlayout.a.a.m r11 = r9.e
            r10.a((androidx.constraintlayout.a.a.m) r11, (float) r6)
            androidx.constraintlayout.a.a.e[] r10 = r2.A
            r10 = r10[r19]
            androidx.constraintlayout.a.a.m r10 = r10.a()
            androidx.constraintlayout.a.a.m r11 = r9.e
            float r12 = r6 + r8
            r10.a((androidx.constraintlayout.a.a.m) r11, (float) r12)
            androidx.constraintlayout.a.a.e[] r10 = r2.A
            r10 = r10[r26]
            androidx.constraintlayout.a.a.m r10 = r10.a()
            r10.a((androidx.constraintlayout.a.e) r0)
            androidx.constraintlayout.a.a.e[] r10 = r2.A
            r10 = r10[r19]
            androidx.constraintlayout.a.a.m r10 = r10.a()
            r10.a((androidx.constraintlayout.a.e) r0)
            androidx.constraintlayout.a.a.e[] r2 = r2.A
            r2 = r2[r19]
            int r2 = r2.e()
            float r2 = (float) r2
            float r8 = r8 + r2
            float r6 = r6 + r8
            if (r3 == 0) goto L_0x0325
            int r2 = r3.l()
            r8 = 8
            if (r2 == r8) goto L_0x0388
            float r6 = r6 + r7
        L_0x0388:
            r2 = r3
            goto L_0x02fe
        L_0x038b:
            return r0
        L_0x038c:
            r0 = 0
            return r0
        L_0x038e:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.a.a.k.a(androidx.constraintlayout.a.a.g, androidx.constraintlayout.a.e, int, int, androidx.constraintlayout.a.a.d):boolean");
    }

    static void a(f fVar, int i, int i2) {
        int i3 = i * 2;
        int i4 = i3 + 1;
        fVar.A[i3].a().e = fVar.k().s.a();
        fVar.A[i3].a().f = (float) i2;
        fVar.A[i3].a().i = 1;
        fVar.A[i4].a().e = fVar.A[i3].a();
        fVar.A[i4].a().f = (float) fVar.f(i);
        fVar.A[i4].a().i = 1;
    }
}
