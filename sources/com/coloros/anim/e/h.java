package com.coloros.anim.e;

import com.coloros.anim.c.b;

/* compiled from: DocumentDataParser */
public class h implements aj<b> {

    /* renamed from: a  reason: collision with root package name */
    public static final h f2437a = new h();

    private h() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:60:0x00cd  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00d2  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00da  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00e2  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00ea  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00f2  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00f9  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0100  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0107  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0122  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0129  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0130  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.coloros.anim.c.b b(android.util.JsonReader r23, float r24) throws java.io.IOException {
        /*
            r22 = this;
            com.coloros.anim.c.b$a r0 = com.coloros.anim.c.b.a.CENTER
            r23.beginObject()
            r1 = 1
            r2 = 0
            r3 = 0
            r4 = 0
            r11 = r0
            r21 = r1
            r7 = r2
            r8 = r7
            r12 = r3
            r17 = r12
            r18 = r17
            r9 = r4
            r13 = r9
            r15 = r13
            r19 = r15
        L_0x0019:
            boolean r0 = r23.hasNext()
            if (r0 == 0) goto L_0x0137
            java.lang.String r0 = r23.nextName()
            r2 = -1
            int r4 = r0.hashCode()
            r5 = 102(0x66, float:1.43E-43)
            if (r4 == r5) goto L_0x00bf
            r5 = 106(0x6a, float:1.49E-43)
            if (r4 == r5) goto L_0x00b5
            r5 = 3261(0xcbd, float:4.57E-42)
            if (r4 == r5) goto L_0x00ab
            r5 = 3452(0xd7c, float:4.837E-42)
            if (r4 == r5) goto L_0x00a1
            r5 = 3463(0xd87, float:4.853E-42)
            if (r4 == r5) goto L_0x0097
            r5 = 3543(0xdd7, float:4.965E-42)
            if (r4 == r5) goto L_0x008c
            r5 = 3664(0xe50, float:5.134E-42)
            if (r4 == r5) goto L_0x0081
            r5 = 3684(0xe64, float:5.162E-42)
            if (r4 == r5) goto L_0x0076
            r5 = 3710(0xe7e, float:5.199E-42)
            if (r4 == r5) goto L_0x006c
            r5 = 115(0x73, float:1.61E-43)
            if (r4 == r5) goto L_0x0061
            r5 = 116(0x74, float:1.63E-43)
            if (r4 == r5) goto L_0x0056
            goto L_0x00c9
        L_0x0056:
            java.lang.String r4 = "t"
            boolean r0 = r0.equals(r4)
            if (r0 == 0) goto L_0x00c9
            r0 = r3
            goto L_0x00ca
        L_0x0061:
            java.lang.String r4 = "s"
            boolean r0 = r0.equals(r4)
            if (r0 == 0) goto L_0x00c9
            r0 = 2
            goto L_0x00ca
        L_0x006c:
            java.lang.String r4 = "tr"
            boolean r0 = r0.equals(r4)
            if (r0 == 0) goto L_0x00c9
            r0 = 4
            goto L_0x00ca
        L_0x0076:
            java.lang.String r4 = "sw"
            boolean r0 = r0.equals(r4)
            if (r0 == 0) goto L_0x00c9
            r0 = 9
            goto L_0x00ca
        L_0x0081:
            java.lang.String r4 = "sc"
            boolean r0 = r0.equals(r4)
            if (r0 == 0) goto L_0x00c9
            r0 = 8
            goto L_0x00ca
        L_0x008c:
            java.lang.String r4 = "of"
            boolean r0 = r0.equals(r4)
            if (r0 == 0) goto L_0x00c9
            r0 = 10
            goto L_0x00ca
        L_0x0097:
            java.lang.String r4 = "ls"
            boolean r0 = r0.equals(r4)
            if (r0 == 0) goto L_0x00c9
            r0 = 6
            goto L_0x00ca
        L_0x00a1:
            java.lang.String r4 = "lh"
            boolean r0 = r0.equals(r4)
            if (r0 == 0) goto L_0x00c9
            r0 = 5
            goto L_0x00ca
        L_0x00ab:
            java.lang.String r4 = "fc"
            boolean r0 = r0.equals(r4)
            if (r0 == 0) goto L_0x00c9
            r0 = 7
            goto L_0x00ca
        L_0x00b5:
            java.lang.String r4 = "j"
            boolean r0 = r0.equals(r4)
            if (r0 == 0) goto L_0x00c9
            r0 = 3
            goto L_0x00ca
        L_0x00bf:
            java.lang.String r4 = "f"
            boolean r0 = r0.equals(r4)
            if (r0 == 0) goto L_0x00c9
            r0 = r1
            goto L_0x00ca
        L_0x00c9:
            r0 = r2
        L_0x00ca:
            switch(r0) {
                case 0: goto L_0x0130;
                case 1: goto L_0x0129;
                case 2: goto L_0x0122;
                case 3: goto L_0x0107;
                case 4: goto L_0x0100;
                case 5: goto L_0x00f9;
                case 6: goto L_0x00f2;
                case 7: goto L_0x00ea;
                case 8: goto L_0x00e2;
                case 9: goto L_0x00da;
                case 10: goto L_0x00d2;
                default: goto L_0x00cd;
            }
        L_0x00cd:
            r23.skipValue()
            goto L_0x0019
        L_0x00d2:
            boolean r0 = r23.nextBoolean()
            r21 = r0
            goto L_0x0019
        L_0x00da:
            double r4 = r23.nextDouble()
            r19 = r4
            goto L_0x0019
        L_0x00e2:
            int r0 = com.coloros.anim.e.q.a(r23)
            r18 = r0
            goto L_0x0019
        L_0x00ea:
            int r0 = com.coloros.anim.e.q.a(r23)
            r17 = r0
            goto L_0x0019
        L_0x00f2:
            double r4 = r23.nextDouble()
            r15 = r4
            goto L_0x0019
        L_0x00f9:
            double r4 = r23.nextDouble()
            r13 = r4
            goto L_0x0019
        L_0x0100:
            int r0 = r23.nextInt()
            r12 = r0
            goto L_0x0019
        L_0x0107:
            int r0 = r23.nextInt()
            com.coloros.anim.c.b$a r2 = com.coloros.anim.c.b.a.CENTER
            int r2 = r2.ordinal()
            if (r0 > r2) goto L_0x011d
            if (r0 >= 0) goto L_0x0116
            goto L_0x011d
        L_0x0116:
            com.coloros.anim.c.b$a[] r2 = com.coloros.anim.c.b.a.values()
            r0 = r2[r0]
            goto L_0x011f
        L_0x011d:
            com.coloros.anim.c.b$a r0 = com.coloros.anim.c.b.a.CENTER
        L_0x011f:
            r11 = r0
            goto L_0x0019
        L_0x0122:
            double r4 = r23.nextDouble()
            r9 = r4
            goto L_0x0019
        L_0x0129:
            java.lang.String r0 = r23.nextString()
            r8 = r0
            goto L_0x0019
        L_0x0130:
            java.lang.String r0 = r23.nextString()
            r7 = r0
            goto L_0x0019
        L_0x0137:
            r23.endObject()
            com.coloros.anim.c.b r0 = new com.coloros.anim.c.b
            r6 = r0
            r6.<init>(r7, r8, r9, r11, r12, r13, r15, r17, r18, r19, r21)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coloros.anim.e.h.b(android.util.JsonReader, float):com.coloros.anim.c.b");
    }
}
