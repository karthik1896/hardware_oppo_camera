package com.coloros.anim.e;

/* compiled from: ContentModelParser */
class g {
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00b2, code lost:
        if (r2.equals("gs") != false) goto L_0x00de;
     */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0042 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static com.coloros.anim.c.b.b a(android.util.JsonReader r9, com.coloros.anim.a r10) throws java.io.IOException {
        /*
            r9.beginObject()
            r0 = 2
            r1 = r0
        L_0x0005:
            boolean r2 = r9.hasNext()
            r3 = 0
            r4 = -1
            r5 = 1
            r6 = 0
            if (r2 == 0) goto L_0x0047
            java.lang.String r2 = r9.nextName()
            int r7 = r2.hashCode()
            r8 = 100
            if (r7 == r8) goto L_0x002a
            r8 = 3717(0xe85, float:5.209E-42)
            if (r7 == r8) goto L_0x0020
            goto L_0x0034
        L_0x0020:
            java.lang.String r7 = "ty"
            boolean r2 = r2.equals(r7)
            if (r2 == 0) goto L_0x0034
            r2 = r3
            goto L_0x0035
        L_0x002a:
            java.lang.String r7 = "d"
            boolean r2 = r2.equals(r7)
            if (r2 == 0) goto L_0x0034
            r2 = r5
            goto L_0x0035
        L_0x0034:
            r2 = r4
        L_0x0035:
            if (r2 == 0) goto L_0x0042
            if (r2 == r5) goto L_0x003d
            r9.skipValue()
            goto L_0x0005
        L_0x003d:
            int r1 = r9.nextInt()
            goto L_0x0005
        L_0x0042:
            java.lang.String r2 = r9.nextString()
            goto L_0x0048
        L_0x0047:
            r2 = r6
        L_0x0048:
            if (r2 != 0) goto L_0x004b
            return r6
        L_0x004b:
            int r7 = r2.hashCode()
            switch(r7) {
                case 3239: goto L_0x00d3;
                case 3270: goto L_0x00c9;
                case 3295: goto L_0x00bf;
                case 3307: goto L_0x00b5;
                case 3308: goto L_0x00ac;
                case 3488: goto L_0x00a1;
                case 3633: goto L_0x0096;
                case 3646: goto L_0x008b;
                case 3669: goto L_0x0081;
                case 3679: goto L_0x0076;
                case 3681: goto L_0x006b;
                case 3705: goto L_0x005f;
                case 3710: goto L_0x0054;
                default: goto L_0x0052;
            }
        L_0x0052:
            goto L_0x00dd
        L_0x0054:
            java.lang.String r0 = "tr"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x00dd
            r0 = 5
            goto L_0x00de
        L_0x005f:
            java.lang.String r0 = "tm"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x00dd
            r0 = 9
            goto L_0x00de
        L_0x006b:
            java.lang.String r0 = "st"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x00dd
            r0 = r5
            goto L_0x00de
        L_0x0076:
            java.lang.String r0 = "sr"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x00dd
            r0 = 10
            goto L_0x00de
        L_0x0081:
            java.lang.String r0 = "sh"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x00dd
            r0 = 6
            goto L_0x00de
        L_0x008b:
            java.lang.String r0 = "rp"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x00dd
            r0 = 12
            goto L_0x00de
        L_0x0096:
            java.lang.String r0 = "rc"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x00dd
            r0 = 8
            goto L_0x00de
        L_0x00a1:
            java.lang.String r0 = "mm"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x00dd
            r0 = 11
            goto L_0x00de
        L_0x00ac:
            java.lang.String r3 = "gs"
            boolean r3 = r2.equals(r3)
            if (r3 == 0) goto L_0x00dd
            goto L_0x00de
        L_0x00b5:
            java.lang.String r0 = "gr"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x00dd
            r0 = r3
            goto L_0x00de
        L_0x00bf:
            java.lang.String r0 = "gf"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x00dd
            r0 = 4
            goto L_0x00de
        L_0x00c9:
            java.lang.String r0 = "fl"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x00dd
            r0 = 3
            goto L_0x00de
        L_0x00d3:
            java.lang.String r0 = "el"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x00dd
            r0 = 7
            goto L_0x00de
        L_0x00dd:
            r0 = r4
        L_0x00de:
            switch(r0) {
                case 0: goto L_0x01b7;
                case 1: goto L_0x01a8;
                case 2: goto L_0x0199;
                case 3: goto L_0x018a;
                case 4: goto L_0x017b;
                case 5: goto L_0x016c;
                case 6: goto L_0x015d;
                case 7: goto L_0x014e;
                case 8: goto L_0x013e;
                case 9: goto L_0x012e;
                case 10: goto L_0x011e;
                case 11: goto L_0x0109;
                case 12: goto L_0x00f9;
                default: goto L_0x00e1;
            }
        L_0x00e1:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r0 = "Unknown shape type "
            r10.append(r0)
            r10.append(r2)
            java.lang.String r10 = r10.toString()
            java.lang.String r0 = "EffectiveAnimation"
            android.util.Log.w(r0, r10)
            goto L_0x01c5
        L_0x00f9:
            java.lang.String r0 = "ContentModeParser::case rp: start!!!"
            com.coloros.anim.k.a(r0)
            com.coloros.anim.c.b.k r6 = com.coloros.anim.e.ab.a(r9, r10)
            java.lang.String r10 = "ContentModeParser::case rp: end!!!"
            com.coloros.anim.k.a(r10)
            goto L_0x01c5
        L_0x0109:
            java.lang.String r0 = "ContentModeParser::case mm: start!!!"
            com.coloros.anim.k.a(r0)
            com.coloros.anim.c.b.h r6 = com.coloros.anim.e.v.a(r9)
            java.lang.String r0 = "Animation contains merge paths. Merge paths are only supported on KitKat+ and must be manually enabled by calling enableMergePathsForKitKatAndAbove()."
            r10.a((java.lang.String) r0)
            java.lang.String r10 = "ContentModeParser::case mm: end!!!"
            com.coloros.anim.k.a(r10)
            goto L_0x01c5
        L_0x011e:
            java.lang.String r0 = "ContentModeParser::case sr: start!!!"
            com.coloros.anim.k.a(r0)
            com.coloros.anim.c.b.i r6 = com.coloros.anim.e.z.a(r9, r10)
            java.lang.String r10 = "ContentModeParser::case sr: end!!!"
            com.coloros.anim.k.a(r10)
            goto L_0x01c5
        L_0x012e:
            java.lang.String r0 = "ContentModeParser::case tm: start!!!"
            com.coloros.anim.k.a(r0)
            com.coloros.anim.c.b.q r6 = com.coloros.anim.e.ai.a(r9, r10)
            java.lang.String r10 = "ContentModeParser::case tm: end!!!"
            com.coloros.anim.k.a(r10)
            goto L_0x01c5
        L_0x013e:
            java.lang.String r0 = "ContentModeParser::case rc: start!!!"
            com.coloros.anim.k.a(r0)
            com.coloros.anim.c.b.j r6 = com.coloros.anim.e.aa.a(r9, r10)
            java.lang.String r10 = "ContentModeParser::case rc: end!!!"
            com.coloros.anim.k.a(r10)
            goto L_0x01c5
        L_0x014e:
            java.lang.String r0 = "ContentModeParser::case el: start!!!"
            com.coloros.anim.k.a(r0)
            com.coloros.anim.c.b.a r6 = com.coloros.anim.e.e.a(r9, r10, r1)
            java.lang.String r10 = "ContentModeParser::case el: end!!!"
            com.coloros.anim.k.a(r10)
            goto L_0x01c5
        L_0x015d:
            java.lang.String r0 = "ContentModeParser::case sh: start!!!"
            com.coloros.anim.k.a(r0)
            com.coloros.anim.c.b.o r6 = com.coloros.anim.e.ag.a(r9, r10)
            java.lang.String r10 = "ContentModeParser::case sh: end!!!"
            com.coloros.anim.k.a(r10)
            goto L_0x01c5
        L_0x016c:
            java.lang.String r0 = "ContentModeParser::case tr: start!!!"
            com.coloros.anim.k.a(r0)
            com.coloros.anim.c.a.l r6 = com.coloros.anim.e.c.a(r9, r10)
            java.lang.String r10 = "ContentModeParser::case tr: end!!!"
            com.coloros.anim.k.a(r10)
            goto L_0x01c5
        L_0x017b:
            java.lang.String r0 = "ContentModeParser::case gf: start!!!"
            com.coloros.anim.k.a(r0)
            com.coloros.anim.c.b.d r6 = com.coloros.anim.e.n.a(r9, r10)
            java.lang.String r10 = "ContentModeParser::case gf: end!!!"
            com.coloros.anim.k.a(r10)
            goto L_0x01c5
        L_0x018a:
            java.lang.String r0 = "ContentModeParser::case fl: start!!!"
            com.coloros.anim.k.a(r0)
            com.coloros.anim.c.b.m r6 = com.coloros.anim.e.ae.a(r9, r10)
            java.lang.String r10 = "ContentModeParser::case fl: end!!!"
            com.coloros.anim.k.a(r10)
            goto L_0x01c5
        L_0x0199:
            java.lang.String r0 = "ContentModeParser::case gs: start!!!"
            com.coloros.anim.k.a(r0)
            com.coloros.anim.c.b.e r6 = com.coloros.anim.e.o.a(r9, r10)
            java.lang.String r10 = "ContentModeParser::case gs: end!!!"
            com.coloros.anim.k.a(r10)
            goto L_0x01c5
        L_0x01a8:
            java.lang.String r0 = "ContentModeParser::case st: start!!!"
            com.coloros.anim.k.a(r0)
            com.coloros.anim.c.b.p r6 = com.coloros.anim.e.ah.a(r9, r10)
            java.lang.String r10 = "ContentModeParser::case st: end!!!"
            com.coloros.anim.k.a(r10)
            goto L_0x01c5
        L_0x01b7:
            java.lang.String r0 = "ContentModeParser::case gr: start!!!"
            com.coloros.anim.k.a(r0)
            com.coloros.anim.c.b.n r6 = com.coloros.anim.e.af.a(r9, r10)
            java.lang.String r10 = "ContentModeParser::case gr: end!!!"
            com.coloros.anim.k.a(r10)
        L_0x01c5:
            boolean r10 = r9.hasNext()
            if (r10 == 0) goto L_0x01cf
            r9.skipValue()
            goto L_0x01c5
        L_0x01cf:
            r9.endObject()
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coloros.anim.e.g.a(android.util.JsonReader, com.coloros.anim.a):com.coloros.anim.c.b.b");
    }
}
