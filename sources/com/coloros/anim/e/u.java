package com.coloros.anim.e;

/* compiled from: MaskParser */
class u {
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0071  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static com.coloros.anim.c.b.g a(android.util.JsonReader r12, com.coloros.anim.a r13) throws java.io.IOException {
        /*
            r12.beginObject()
            r0 = 0
            r1 = 0
            r4 = r0
            r2 = r1
            r3 = r2
        L_0x0008:
            boolean r5 = r12.hasNext()
            if (r5 == 0) goto L_0x00d9
            java.lang.String r5 = r12.nextName()
            int r6 = r5.hashCode()
            r7 = 111(0x6f, float:1.56E-43)
            r8 = 3
            r9 = -1
            r10 = 2
            r11 = 1
            if (r6 == r7) goto L_0x004b
            r7 = 3588(0xe04, float:5.028E-42)
            if (r6 == r7) goto L_0x0041
            r7 = 104433(0x197f1, float:1.46342E-40)
            if (r6 == r7) goto L_0x0037
            r7 = 3357091(0x3339a3, float:4.704286E-39)
            if (r6 == r7) goto L_0x002d
            goto L_0x0055
        L_0x002d:
            java.lang.String r6 = "mode"
            boolean r6 = r5.equals(r6)
            if (r6 == 0) goto L_0x0055
            r6 = r0
            goto L_0x0056
        L_0x0037:
            java.lang.String r6 = "inv"
            boolean r6 = r5.equals(r6)
            if (r6 == 0) goto L_0x0055
            r6 = r8
            goto L_0x0056
        L_0x0041:
            java.lang.String r6 = "pt"
            boolean r6 = r5.equals(r6)
            if (r6 == 0) goto L_0x0055
            r6 = r11
            goto L_0x0056
        L_0x004b:
            java.lang.String r6 = "o"
            boolean r6 = r5.equals(r6)
            if (r6 == 0) goto L_0x0055
            r6 = r10
            goto L_0x0056
        L_0x0055:
            r6 = r9
        L_0x0056:
            if (r6 == 0) goto L_0x0071
            if (r6 == r11) goto L_0x006c
            if (r6 == r10) goto L_0x0067
            if (r6 == r8) goto L_0x0062
            r12.skipValue()
            goto L_0x0008
        L_0x0062:
            boolean r4 = r12.nextBoolean()
            goto L_0x0008
        L_0x0067:
            com.coloros.anim.c.a.d r3 = com.coloros.anim.e.d.b(r12, r13)
            goto L_0x0008
        L_0x006c:
            com.coloros.anim.c.a.h r2 = com.coloros.anim.e.d.e(r12, r13)
            goto L_0x0008
        L_0x0071:
            java.lang.String r1 = r12.nextString()
            int r6 = r1.hashCode()
            r7 = 97
            if (r6 == r7) goto L_0x009a
            r7 = 105(0x69, float:1.47E-43)
            if (r6 == r7) goto L_0x0090
            r7 = 115(0x73, float:1.61E-43)
            if (r6 == r7) goto L_0x0086
            goto L_0x00a3
        L_0x0086:
            java.lang.String r6 = "s"
            boolean r1 = r1.equals(r6)
            if (r1 == 0) goto L_0x00a3
            r9 = r11
            goto L_0x00a3
        L_0x0090:
            java.lang.String r6 = "i"
            boolean r1 = r1.equals(r6)
            if (r1 == 0) goto L_0x00a3
            r9 = r10
            goto L_0x00a3
        L_0x009a:
            java.lang.String r6 = "a"
            boolean r1 = r1.equals(r6)
            if (r1 == 0) goto L_0x00a3
            r9 = r0
        L_0x00a3:
            if (r9 == 0) goto L_0x00d5
            if (r9 == r11) goto L_0x00d1
            if (r9 == r10) goto L_0x00c8
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r6 = "Unknown mask mode "
            r1.append(r6)
            r1.append(r5)
            java.lang.String r5 = ". Defaulting to Add."
            r1.append(r5)
            java.lang.String r1 = r1.toString()
            java.lang.String r5 = "EffectiveAnimation"
            android.util.Log.w(r5, r1)
            com.coloros.anim.c.b.g$a r1 = com.coloros.anim.c.b.g.a.MASK_MODE_ADD
            goto L_0x0008
        L_0x00c8:
            java.lang.String r1 = "Animation contains intersect masks. They are not supported but will be treated like add masks."
            r13.a((java.lang.String) r1)
            com.coloros.anim.c.b.g$a r1 = com.coloros.anim.c.b.g.a.MASK_MODE_INTERSECT
            goto L_0x0008
        L_0x00d1:
            com.coloros.anim.c.b.g$a r1 = com.coloros.anim.c.b.g.a.MASK_MODE_SUBTRACT
            goto L_0x0008
        L_0x00d5:
            com.coloros.anim.c.b.g$a r1 = com.coloros.anim.c.b.g.a.MASK_MODE_ADD
            goto L_0x0008
        L_0x00d9:
            r12.endObject()
            com.coloros.anim.c.b.g r12 = new com.coloros.anim.c.b.g
            r12.<init>(r1, r2, r3, r4)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coloros.anim.e.u.a(android.util.JsonReader, com.coloros.anim.a):com.coloros.anim.c.b.g");
    }
}
