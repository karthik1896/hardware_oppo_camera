package com.coloros.anim.e;

/* compiled from: ShapeStrokeParser */
class ah {
    /* JADX WARNING: Removed duplicated region for block: B:100:0x014d  */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x0173  */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x017c  */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x0186  */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x0197  */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x01a8  */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x01b1  */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x01ba  */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x01c3  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00ac  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00eb  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x00f8  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x0138  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static com.coloros.anim.c.b.p a(android.util.JsonReader r18, com.coloros.anim.a r19) throws java.io.IOException {
        /*
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            r2 = 0
            r10 = r2
            r2 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r11 = 0
        L_0x000f:
            boolean r12 = r18.hasNext()
            if (r12 == 0) goto L_0x01cc
            java.lang.String r12 = r18.nextName()
            int r13 = r12.hashCode()
            r14 = 99
            java.lang.String r15 = "o"
            java.lang.String r1 = "d"
            r16 = -1
            if (r13 == r14) goto L_0x0095
            r14 = 100
            if (r13 == r14) goto L_0x008c
            r14 = 111(0x6f, float:1.56E-43)
            if (r13 == r14) goto L_0x0084
            r14 = 119(0x77, float:1.67E-43)
            if (r13 == r14) goto L_0x007a
            r14 = 3324(0xcfc, float:4.658E-42)
            if (r13 == r14) goto L_0x0070
            r14 = 3447(0xd77, float:4.83E-42)
            if (r13 == r14) goto L_0x0066
            r14 = 3454(0xd7e, float:4.84E-42)
            if (r13 == r14) goto L_0x005c
            r14 = 3487(0xd9f, float:4.886E-42)
            if (r13 == r14) goto L_0x0052
            r14 = 3519(0xdbf, float:4.931E-42)
            if (r13 == r14) goto L_0x0048
            goto L_0x009f
        L_0x0048:
            java.lang.String r13 = "nm"
            boolean r12 = r12.equals(r13)
            if (r12 == 0) goto L_0x009f
            r12 = 0
            goto L_0x00a1
        L_0x0052:
            java.lang.String r13 = "ml"
            boolean r12 = r12.equals(r13)
            if (r12 == 0) goto L_0x009f
            r12 = 6
            goto L_0x00a1
        L_0x005c:
            java.lang.String r13 = "lj"
            boolean r12 = r12.equals(r13)
            if (r12 == 0) goto L_0x009f
            r12 = 5
            goto L_0x00a1
        L_0x0066:
            java.lang.String r13 = "lc"
            boolean r12 = r12.equals(r13)
            if (r12 == 0) goto L_0x009f
            r12 = 4
            goto L_0x00a1
        L_0x0070:
            java.lang.String r13 = "hd"
            boolean r12 = r12.equals(r13)
            if (r12 == 0) goto L_0x009f
            r12 = 7
            goto L_0x00a1
        L_0x007a:
            java.lang.String r13 = "w"
            boolean r12 = r12.equals(r13)
            if (r12 == 0) goto L_0x009f
            r12 = 2
            goto L_0x00a1
        L_0x0084:
            boolean r12 = r12.equals(r15)
            if (r12 == 0) goto L_0x009f
            r12 = 3
            goto L_0x00a1
        L_0x008c:
            boolean r12 = r12.equals(r1)
            if (r12 == 0) goto L_0x009f
            r12 = 8
            goto L_0x00a1
        L_0x0095:
            java.lang.String r13 = "c"
            boolean r12 = r12.equals(r13)
            if (r12 == 0) goto L_0x009f
            r12 = 1
            goto L_0x00a1
        L_0x009f:
            r12 = r16
        L_0x00a1:
            switch(r12) {
                case 0: goto L_0x01c3;
                case 1: goto L_0x01ba;
                case 2: goto L_0x01b1;
                case 3: goto L_0x01a8;
                case 4: goto L_0x0197;
                case 5: goto L_0x0186;
                case 6: goto L_0x017c;
                case 7: goto L_0x0173;
                case 8: goto L_0x00ac;
                default: goto L_0x00a4;
            }
        L_0x00a4:
            r0 = r19
            r1 = 0
            r18.skipValue()
            goto L_0x000f
        L_0x00ac:
            r18.beginArray()
        L_0x00af:
            boolean r12 = r18.hasNext()
            if (r12 == 0) goto L_0x0157
            r18.beginObject()
            r12 = 0
            r13 = 0
        L_0x00ba:
            boolean r14 = r18.hasNext()
            if (r14 == 0) goto L_0x0100
            java.lang.String r14 = r18.nextName()
            int r0 = r14.hashCode()
            r17 = r4
            r4 = 110(0x6e, float:1.54E-43)
            if (r0 == r4) goto L_0x00dd
            r4 = 118(0x76, float:1.65E-43)
            if (r0 == r4) goto L_0x00d3
            goto L_0x00e7
        L_0x00d3:
            java.lang.String r0 = "v"
            boolean r0 = r14.equals(r0)
            if (r0 == 0) goto L_0x00e7
            r0 = 1
            goto L_0x00e9
        L_0x00dd:
            java.lang.String r0 = "n"
            boolean r0 = r14.equals(r0)
            if (r0 == 0) goto L_0x00e7
            r0 = 0
            goto L_0x00e9
        L_0x00e7:
            r0 = r16
        L_0x00e9:
            if (r0 == 0) goto L_0x00f8
            r4 = 1
            if (r0 == r4) goto L_0x00f2
            r18.skipValue()
            goto L_0x00fd
        L_0x00f2:
            com.coloros.anim.c.a.b r0 = com.coloros.anim.e.d.a(r18, r19)
            r13 = r0
            goto L_0x00fd
        L_0x00f8:
            java.lang.String r0 = r18.nextString()
            r12 = r0
        L_0x00fd:
            r4 = r17
            goto L_0x00ba
        L_0x0100:
            r17 = r4
            r18.endObject()
            int r0 = r12.hashCode()
            r4 = 100
            if (r0 == r4) goto L_0x012a
            r14 = 103(0x67, float:1.44E-43)
            if (r0 == r14) goto L_0x011e
            r14 = 111(0x6f, float:1.56E-43)
            if (r0 == r14) goto L_0x0116
            goto L_0x0134
        L_0x0116:
            boolean r0 = r12.equals(r15)
            if (r0 == 0) goto L_0x0134
            r0 = 0
            goto L_0x0136
        L_0x011e:
            r14 = 111(0x6f, float:1.56E-43)
            java.lang.String r0 = "g"
            boolean r0 = r12.equals(r0)
            if (r0 == 0) goto L_0x0134
            r0 = 2
            goto L_0x0136
        L_0x012a:
            r14 = 111(0x6f, float:1.56E-43)
            boolean r0 = r12.equals(r1)
            if (r0 == 0) goto L_0x0134
            r0 = 1
            goto L_0x0136
        L_0x0134:
            r0 = r16
        L_0x0136:
            if (r0 == 0) goto L_0x014d
            r12 = 1
            if (r0 == r12) goto L_0x0144
            r4 = 2
            if (r0 == r4) goto L_0x0141
            r0 = r19
            goto L_0x0153
        L_0x0141:
            r0 = r19
            goto L_0x0146
        L_0x0144:
            r4 = 2
            goto L_0x0141
        L_0x0146:
            r0.a((boolean) r12)
            r3.add(r13)
            goto L_0x0153
        L_0x014d:
            r0 = r19
            r4 = 2
            r12 = 1
            r17 = r13
        L_0x0153:
            r4 = r17
            goto L_0x00af
        L_0x0157:
            r0 = r19
            r17 = r4
            r12 = 1
            r18.endArray()
            int r1 = r3.size()
            if (r1 != r12) goto L_0x016e
            r1 = 0
            java.lang.Object r4 = r3.get(r1)
            r3.add(r4)
            goto L_0x016f
        L_0x016e:
            r1 = 0
        L_0x016f:
            r4 = r17
            goto L_0x000f
        L_0x0173:
            r0 = r19
            r1 = 0
            boolean r11 = r18.nextBoolean()
            goto L_0x000f
        L_0x017c:
            r0 = r19
            r1 = 0
            double r12 = r18.nextDouble()
            float r10 = (float) r12
            goto L_0x000f
        L_0x0186:
            r0 = r19
            r1 = 0
            com.coloros.anim.c.b.p$b[] r9 = com.coloros.anim.c.b.p.b.values()
            int r12 = r18.nextInt()
            r13 = 1
            int r12 = r12 - r13
            r9 = r9[r12]
            goto L_0x000f
        L_0x0197:
            r0 = r19
            r1 = 0
            r13 = 1
            com.coloros.anim.c.b.p$a[] r8 = com.coloros.anim.c.b.p.a.values()
            int r12 = r18.nextInt()
            int r12 = r12 - r13
            r8 = r8[r12]
            goto L_0x000f
        L_0x01a8:
            r0 = r19
            r1 = 0
            com.coloros.anim.c.a.d r6 = com.coloros.anim.e.d.b(r18, r19)
            goto L_0x000f
        L_0x01b1:
            r0 = r19
            r1 = 0
            com.coloros.anim.c.a.b r7 = com.coloros.anim.e.d.a(r18, r19)
            goto L_0x000f
        L_0x01ba:
            r0 = r19
            r1 = 0
            com.coloros.anim.c.a.a r5 = com.coloros.anim.e.d.g(r18, r19)
            goto L_0x000f
        L_0x01c3:
            r0 = r19
            r1 = 0
            java.lang.String r2 = r18.nextString()
            goto L_0x000f
        L_0x01cc:
            com.coloros.anim.c.b.p r12 = new com.coloros.anim.c.b.p
            r0 = r12
            r1 = r2
            r2 = r4
            r4 = r5
            r5 = r6
            r6 = r7
            r7 = r8
            r8 = r9
            r9 = r10
            r10 = r11
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coloros.anim.e.ah.a(android.util.JsonReader, com.coloros.anim.a):com.coloros.anim.c.b.p");
    }
}
