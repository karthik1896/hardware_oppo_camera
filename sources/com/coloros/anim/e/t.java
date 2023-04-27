package com.coloros.anim.e;

import android.graphics.Rect;
import com.coloros.anim.a;
import com.coloros.anim.c.a.b;
import com.coloros.anim.c.a.j;
import com.coloros.anim.c.a.k;
import com.coloros.anim.c.a.l;
import com.coloros.anim.c.c.d;
import java.util.Collections;
import java.util.List;

/* compiled from: LayerParser */
public class t {
    public static d a(a aVar) {
        Rect d = aVar.d();
        List emptyList = Collections.emptyList();
        d.a aVar2 = d.a.PRE_COMP;
        List emptyList2 = Collections.emptyList();
        l lVar = r4;
        l lVar2 = new l();
        return new d(emptyList, aVar, "__container", -1, aVar2, -1, (String) null, emptyList2, lVar, 0, 0, 0, 0.0f, 0.0f, d.width(), d.height(), (j) null, (k) null, Collections.emptyList(), d.b.NONE, (b) null, false);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x026a  */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x028d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.coloros.anim.c.c.d a(android.util.JsonReader r39, com.coloros.anim.a r40) throws java.io.IOException {
        /*
            r7 = r40
            com.coloros.anim.c.c.d$b r0 = com.coloros.anim.c.c.d.b.NONE
            java.util.ArrayList r10 = new java.util.ArrayList
            r10.<init>()
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            r39.beginObject()
            r1 = 1065353216(0x3f800000, float:1.0)
            java.lang.Float r9 = java.lang.Float.valueOf(r1)
            r2 = 0
            r11 = 0
            java.lang.Float r12 = java.lang.Float.valueOf(r11)
            r3 = 0
            java.lang.String r4 = "UNSET"
            r5 = 0
            r13 = -1
            r28 = r0
            r15 = r1
            r16 = r2
            r17 = r16
            r30 = r17
            r31 = r30
            r32 = r31
            r33 = r32
            r20 = r3
            r21 = r20
            r22 = r21
            r23 = r22
            r24 = r23
            r29 = r24
            r18 = r5
            r0 = r11
            r1 = r0
            r27 = r1
            r25 = r13
            r14 = r33
            r13 = r4
        L_0x004a:
            boolean r2 = r39.hasNext()
            if (r2 == 0) goto L_0x0374
            java.lang.String r2 = r39.nextName()
            int r4 = r2.hashCode()
            java.lang.String r5 = "nm"
            r6 = 1
            switch(r4) {
                case -995424086: goto L_0x0157;
                case -903568142: goto L_0x014c;
                case 104: goto L_0x0141;
                case 116: goto L_0x0136;
                case 119: goto L_0x012b;
                case 3177: goto L_0x0120;
                case 3233: goto L_0x0115;
                case 3324: goto L_0x010a;
                case 3367: goto L_0x00ff;
                case 3432: goto L_0x00f3;
                case 3519: goto L_0x00ea;
                case 3553: goto L_0x00de;
                case 3664: goto L_0x00d3;
                case 3669: goto L_0x00c8;
                case 3679: goto L_0x00bc;
                case 3681: goto L_0x00b0;
                case 3684: goto L_0x00a5;
                case 3705: goto L_0x0099;
                case 3712: goto L_0x008d;
                case 3717: goto L_0x0082;
                case 104415: goto L_0x0077;
                case 108390670: goto L_0x006c;
                case 1441620890: goto L_0x0060;
                default: goto L_0x005e;
            }
        L_0x005e:
            goto L_0x0161
        L_0x0060:
            java.lang.String r4 = "masksProperties"
            boolean r2 = r2.equals(r4)
            if (r2 == 0) goto L_0x0161
            r2 = 10
            goto L_0x0162
        L_0x006c:
            java.lang.String r4 = "refId"
            boolean r2 = r2.equals(r4)
            if (r2 == 0) goto L_0x0161
            r2 = 2
            goto L_0x0162
        L_0x0077:
            java.lang.String r4 = "ind"
            boolean r2 = r2.equals(r4)
            if (r2 == 0) goto L_0x0161
            r2 = r6
            goto L_0x0162
        L_0x0082:
            java.lang.String r4 = "ty"
            boolean r2 = r2.equals(r4)
            if (r2 == 0) goto L_0x0161
            r2 = 3
            goto L_0x0162
        L_0x008d:
            java.lang.String r4 = "tt"
            boolean r2 = r2.equals(r4)
            if (r2 == 0) goto L_0x0161
            r2 = 9
            goto L_0x0162
        L_0x0099:
            java.lang.String r4 = "tm"
            boolean r2 = r2.equals(r4)
            if (r2 == 0) goto L_0x0161
            r2 = 20
            goto L_0x0162
        L_0x00a5:
            java.lang.String r4 = "sw"
            boolean r2 = r2.equals(r4)
            if (r2 == 0) goto L_0x0161
            r2 = 5
            goto L_0x0162
        L_0x00b0:
            java.lang.String r4 = "st"
            boolean r2 = r2.equals(r4)
            if (r2 == 0) goto L_0x0161
            r2 = 15
            goto L_0x0162
        L_0x00bc:
            java.lang.String r4 = "sr"
            boolean r2 = r2.equals(r4)
            if (r2 == 0) goto L_0x0161
            r2 = 14
            goto L_0x0162
        L_0x00c8:
            java.lang.String r4 = "sh"
            boolean r2 = r2.equals(r4)
            if (r2 == 0) goto L_0x0161
            r2 = 6
            goto L_0x0162
        L_0x00d3:
            java.lang.String r4 = "sc"
            boolean r2 = r2.equals(r4)
            if (r2 == 0) goto L_0x0161
            r2 = 7
            goto L_0x0162
        L_0x00de:
            java.lang.String r4 = "op"
            boolean r2 = r2.equals(r4)
            if (r2 == 0) goto L_0x0161
            r2 = 19
            goto L_0x0162
        L_0x00ea:
            boolean r2 = r2.equals(r5)
            if (r2 == 0) goto L_0x0161
            r2 = r3
            goto L_0x0162
        L_0x00f3:
            java.lang.String r4 = "ks"
            boolean r2 = r2.equals(r4)
            if (r2 == 0) goto L_0x0161
            r2 = 8
            goto L_0x0162
        L_0x00ff:
            java.lang.String r4 = "ip"
            boolean r2 = r2.equals(r4)
            if (r2 == 0) goto L_0x0161
            r2 = 18
            goto L_0x0162
        L_0x010a:
            java.lang.String r4 = "hd"
            boolean r2 = r2.equals(r4)
            if (r2 == 0) goto L_0x0161
            r2 = 22
            goto L_0x0162
        L_0x0115:
            java.lang.String r4 = "ef"
            boolean r2 = r2.equals(r4)
            if (r2 == 0) goto L_0x0161
            r2 = 13
            goto L_0x0162
        L_0x0120:
            java.lang.String r4 = "cl"
            boolean r2 = r2.equals(r4)
            if (r2 == 0) goto L_0x0161
            r2 = 21
            goto L_0x0162
        L_0x012b:
            java.lang.String r4 = "w"
            boolean r2 = r2.equals(r4)
            if (r2 == 0) goto L_0x0161
            r2 = 16
            goto L_0x0162
        L_0x0136:
            java.lang.String r4 = "t"
            boolean r2 = r2.equals(r4)
            if (r2 == 0) goto L_0x0161
            r2 = 12
            goto L_0x0162
        L_0x0141:
            java.lang.String r4 = "h"
            boolean r2 = r2.equals(r4)
            if (r2 == 0) goto L_0x0161
            r2 = 17
            goto L_0x0162
        L_0x014c:
            java.lang.String r4 = "shapes"
            boolean r2 = r2.equals(r4)
            if (r2 == 0) goto L_0x0161
            r2 = 11
            goto L_0x0162
        L_0x0157:
            java.lang.String r4 = "parent"
            boolean r2 = r2.equals(r4)
            if (r2 == 0) goto L_0x0161
            r2 = 4
            goto L_0x0162
        L_0x0161:
            r2 = -1
        L_0x0162:
            switch(r2) {
                case 0: goto L_0x036a;
                case 1: goto L_0x0360;
                case 2: goto L_0x0359;
                case 3: goto L_0x0341;
                case 4: goto L_0x0337;
                case 5: goto L_0x0327;
                case 6: goto L_0x0317;
                case 7: goto L_0x030c;
                case 8: goto L_0x02fa;
                case 9: goto L_0x02e9;
                case 10: goto L_0x02c0;
                case 11: goto L_0x029c;
                case 12: goto L_0x0232;
                case 13: goto L_0x01ca;
                case 14: goto L_0x01c1;
                case 15: goto L_0x01b6;
                case 16: goto L_0x01a5;
                case 17: goto L_0x0194;
                case 18: goto L_0x018b;
                case 19: goto L_0x0182;
                case 20: goto L_0x017a;
                case 21: goto L_0x0171;
                case 22: goto L_0x016c;
                default: goto L_0x0165;
            }
        L_0x0165:
            r2 = r39
            r39.skipValue()
            goto L_0x0370
        L_0x016c:
            boolean r29 = r39.nextBoolean()
            goto L_0x0176
        L_0x0171:
            java.lang.String r2 = r39.nextString()
            r14 = r2
        L_0x0176:
            r2 = r39
            goto L_0x0370
        L_0x017a:
            r2 = r39
            com.coloros.anim.c.a.b r33 = com.coloros.anim.e.d.a((android.util.JsonReader) r2, (com.coloros.anim.a) r7, (boolean) r3)
            goto L_0x0370
        L_0x0182:
            r2 = r39
            double r4 = r39.nextDouble()
            float r1 = (float) r4
            goto L_0x0370
        L_0x018b:
            r2 = r39
            double r4 = r39.nextDouble()
            float r0 = (float) r4
            goto L_0x0370
        L_0x0194:
            r2 = r39
            int r4 = r39.nextInt()
            float r4 = (float) r4
            float r5 = com.coloros.anim.f.g.a()
            float r4 = r4 * r5
            int r4 = (int) r4
            r24 = r4
            goto L_0x0370
        L_0x01a5:
            r2 = r39
            int r4 = r39.nextInt()
            float r4 = (float) r4
            float r5 = com.coloros.anim.f.g.a()
            float r4 = r4 * r5
            int r4 = (int) r4
            r23 = r4
            goto L_0x0370
        L_0x01b6:
            r2 = r39
            double r4 = r39.nextDouble()
            float r4 = (float) r4
            r27 = r4
            goto L_0x0370
        L_0x01c1:
            r2 = r39
            double r4 = r39.nextDouble()
            float r15 = (float) r4
            goto L_0x0370
        L_0x01ca:
            r2 = r39
            java.lang.String r4 = "LayerParser::case ef: start!!!"
            com.coloros.anim.k.a(r4)
            r39.beginArray()
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
        L_0x01d9:
            boolean r6 = r39.hasNext()
            if (r6 == 0) goto L_0x0214
            r39.beginObject()
        L_0x01e2:
            boolean r6 = r39.hasNext()
            if (r6 == 0) goto L_0x020e
            java.lang.String r6 = r39.nextName()
            int r3 = r6.hashCode()
            r11 = 3519(0xdbf, float:4.931E-42)
            if (r3 == r11) goto L_0x01f5
            goto L_0x01fd
        L_0x01f5:
            boolean r3 = r6.equals(r5)
            if (r3 == 0) goto L_0x01fd
            r3 = 0
            goto L_0x01fe
        L_0x01fd:
            r3 = -1
        L_0x01fe:
            if (r3 == 0) goto L_0x0204
            r39.skipValue()
            goto L_0x020b
        L_0x0204:
            java.lang.String r3 = r39.nextString()
            r4.add(r3)
        L_0x020b:
            r3 = 0
            r11 = 0
            goto L_0x01e2
        L_0x020e:
            r39.endObject()
            r3 = 0
            r11 = 0
            goto L_0x01d9
        L_0x0214:
            r39.endArray()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r5 = "EffectiveAnimation doesn't support layer effects. If you are using them for  fills, strokes, trim paths etc. then try adding them directly as contents  in your shape. Found: "
            r3.append(r5)
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            r7.a((java.lang.String) r3)
            java.lang.String r3 = "LayerParser::case ef: end!!!"
            com.coloros.anim.k.a(r3)
            goto L_0x0370
        L_0x0232:
            r2 = r39
            java.lang.String r3 = "LayerParser::case t: start!!!"
            com.coloros.anim.k.a(r3)
            r39.beginObject()
        L_0x023c:
            boolean r3 = r39.hasNext()
            if (r3 == 0) goto L_0x0292
            java.lang.String r3 = r39.nextName()
            int r4 = r3.hashCode()
            r5 = 97
            if (r4 == r5) goto L_0x025d
            r5 = 100
            if (r4 == r5) goto L_0x0253
            goto L_0x0267
        L_0x0253:
            java.lang.String r4 = "d"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0267
            r3 = 0
            goto L_0x0268
        L_0x025d:
            java.lang.String r4 = "a"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0267
            r3 = r6
            goto L_0x0268
        L_0x0267:
            r3 = -1
        L_0x0268:
            if (r3 == 0) goto L_0x028d
            if (r3 == r6) goto L_0x0270
            r39.skipValue()
            goto L_0x023c
        L_0x0270:
            r39.beginArray()
            boolean r3 = r39.hasNext()
            if (r3 == 0) goto L_0x027f
            com.coloros.anim.c.a.k r3 = com.coloros.anim.e.b.a(r39, r40)
            r32 = r3
        L_0x027f:
            boolean r3 = r39.hasNext()
            if (r3 == 0) goto L_0x0289
            r39.skipValue()
            goto L_0x027f
        L_0x0289:
            r39.endArray()
            goto L_0x023c
        L_0x028d:
            com.coloros.anim.c.a.j r31 = com.coloros.anim.e.d.f(r39, r40)
            goto L_0x023c
        L_0x0292:
            r39.endObject()
            java.lang.String r3 = "LayerParser::case t: end!!!"
            com.coloros.anim.k.a(r3)
            goto L_0x0370
        L_0x029c:
            r2 = r39
            java.lang.String r3 = "LayerParser::case shapes: start!!!"
            com.coloros.anim.k.a(r3)
            r39.beginArray()
        L_0x02a6:
            boolean r3 = r39.hasNext()
            if (r3 == 0) goto L_0x02b6
            com.coloros.anim.c.b.b r3 = com.coloros.anim.e.g.a(r39, r40)
            if (r3 == 0) goto L_0x02a6
            r8.add(r3)
            goto L_0x02a6
        L_0x02b6:
            r39.endArray()
            java.lang.String r3 = "LayerParser::case shapes: end!!!"
            com.coloros.anim.k.a(r3)
            goto L_0x0370
        L_0x02c0:
            r2 = r39
            java.lang.String r3 = "LayerParser::case masksProperties: start!!!"
            com.coloros.anim.k.a(r3)
            r39.beginArray()
        L_0x02ca:
            boolean r3 = r39.hasNext()
            if (r3 == 0) goto L_0x02d8
            com.coloros.anim.c.b.g r3 = com.coloros.anim.e.u.a(r39, r40)
            r10.add(r3)
            goto L_0x02ca
        L_0x02d8:
            int r3 = r10.size()
            r7.a((int) r3)
            r39.endArray()
            java.lang.String r3 = "LayerParser::case masksProperties: end!!!"
            com.coloros.anim.k.a(r3)
            goto L_0x0370
        L_0x02e9:
            r2 = r39
            com.coloros.anim.c.c.d$b[] r3 = com.coloros.anim.c.c.d.b.values()
            int r4 = r39.nextInt()
            r28 = r3[r4]
            r7.a((int) r6)
            goto L_0x0370
        L_0x02fa:
            r2 = r39
            java.lang.String r3 = "LayerParser::case ks: start!!!"
            com.coloros.anim.k.a(r3)
            com.coloros.anim.c.a.l r30 = com.coloros.anim.e.c.a(r39, r40)
            java.lang.String r3 = "LayerParser::case ks: end!!!"
            com.coloros.anim.k.a(r3)
            goto L_0x0370
        L_0x030c:
            r2 = r39
            java.lang.String r3 = r39.nextString()
            int r22 = android.graphics.Color.parseColor(r3)
            goto L_0x0370
        L_0x0317:
            r2 = r39
            int r3 = r39.nextInt()
            float r3 = (float) r3
            float r4 = com.coloros.anim.f.g.a()
            float r3 = r3 * r4
            int r3 = (int) r3
            r21 = r3
            goto L_0x0370
        L_0x0327:
            r2 = r39
            int r3 = r39.nextInt()
            float r3 = (float) r3
            float r4 = com.coloros.anim.f.g.a()
            float r3 = r3 * r4
            int r3 = (int) r3
            r20 = r3
            goto L_0x0370
        L_0x0337:
            r2 = r39
            int r3 = r39.nextInt()
            long r3 = (long) r3
            r25 = r3
            goto L_0x0370
        L_0x0341:
            r2 = r39
            int r3 = r39.nextInt()
            com.coloros.anim.c.c.d$a r4 = com.coloros.anim.c.c.d.a.UNKNOWN
            int r4 = r4.ordinal()
            if (r3 >= r4) goto L_0x0356
            com.coloros.anim.c.c.d$a[] r4 = com.coloros.anim.c.c.d.a.values()
            r16 = r4[r3]
            goto L_0x0370
        L_0x0356:
            com.coloros.anim.c.c.d$a r16 = com.coloros.anim.c.c.d.a.UNKNOWN
            goto L_0x0370
        L_0x0359:
            r2 = r39
            java.lang.String r17 = r39.nextString()
            goto L_0x0370
        L_0x0360:
            r2 = r39
            int r3 = r39.nextInt()
            long r3 = (long) r3
            r18 = r3
            goto L_0x0370
        L_0x036a:
            r2 = r39
            java.lang.String r13 = r39.nextString()
        L_0x0370:
            r3 = 0
            r11 = 0
            goto L_0x004a
        L_0x0374:
            r2 = r39
            r39.endObject()
            float r11 = r0 / r15
            float r34 = r1 / r15
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            r0 = 0
            int r1 = (r11 > r0 ? 1 : (r11 == r0 ? 0 : -1))
            if (r1 <= 0) goto L_0x03a7
            com.coloros.anim.g.c r5 = new com.coloros.anim.g.c
            r4 = 0
            r35 = 0
            java.lang.Float r37 = java.lang.Float.valueOf(r11)
            r0 = r5
            r1 = r40
            r2 = r12
            r3 = r12
            r38 = r5
            r5 = r35
            r35 = r15
            r15 = r6
            r6 = r37
            r0.<init>(r1, r2, r3, r4, r5, r6)
            r0 = r38
            r15.add(r0)
            goto L_0x03aa
        L_0x03a7:
            r35 = r15
            r15 = r6
        L_0x03aa:
            r0 = 0
            int r0 = (r34 > r0 ? 1 : (r34 == r0 ? 0 : -1))
            if (r0 <= 0) goto L_0x03b0
            goto L_0x03b6
        L_0x03b0:
            float r0 = r40.g()
            r34 = r0
        L_0x03b6:
            com.coloros.anim.g.c r6 = new com.coloros.anim.g.c
            r4 = 0
            java.lang.Float r36 = java.lang.Float.valueOf(r34)
            r0 = r6
            r1 = r40
            r2 = r9
            r3 = r9
            r5 = r11
            r9 = r6
            r6 = r36
            r0.<init>(r1, r2, r3, r4, r5, r6)
            r15.add(r9)
            com.coloros.anim.g.c r9 = new com.coloros.anim.g.c
            r0 = 2139095039(0x7f7fffff, float:3.4028235E38)
            java.lang.Float r6 = java.lang.Float.valueOf(r0)
            r0 = r9
            r2 = r12
            r3 = r12
            r5 = r34
            r0.<init>(r1, r2, r3, r4, r5, r6)
            r15.add(r9)
            java.lang.String r0 = ".ai"
            boolean r0 = r13.endsWith(r0)
            if (r0 != 0) goto L_0x03f0
            java.lang.String r0 = "ai"
            boolean r0 = r0.equals(r14)
            if (r0 == 0) goto L_0x03f5
        L_0x03f0:
            java.lang.String r0 = "Convert your Illustrator layers to shape layers."
            r7.a((java.lang.String) r0)
        L_0x03f5:
            com.coloros.anim.c.c.d r34 = new com.coloros.anim.c.c.d
            r0 = r34
            r1 = r8
            r2 = r40
            r3 = r13
            r4 = r18
            r6 = r16
            r7 = r25
            r9 = r17
            r11 = r30
            r12 = r20
            r13 = r21
            r14 = r22
            r21 = r15
            r15 = r35
            r16 = r27
            r17 = r23
            r18 = r24
            r19 = r31
            r20 = r32
            r22 = r28
            r23 = r33
            r24 = r29
            r0.<init>(r1, r2, r3, r4, r6, r7, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24)
            return r34
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coloros.anim.e.t.a(android.util.JsonReader, com.coloros.anim.a):com.coloros.anim.c.c.d");
    }
}
