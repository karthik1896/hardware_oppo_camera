package com.coloros.anim.e;

import android.graphics.PointF;
import com.coloros.anim.c.a.b;
import com.coloros.anim.c.a.e;
import com.coloros.anim.c.a.g;
import com.coloros.anim.c.a.i;
import com.coloros.anim.c.a.m;
import com.coloros.anim.g.d;

/* compiled from: AnimatableTransformParser */
public class c {
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00c6  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00cb  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00d3  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00db  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00e3  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00eb  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00f3  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x015e  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0165  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x016c  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0173  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.coloros.anim.c.a.l a(android.util.JsonReader r28, com.coloros.anim.a r29) throws java.io.IOException {
        /*
            r0 = r28
            r8 = r29
            android.util.JsonToken r1 = r28.peek()
            android.util.JsonToken r2 = android.util.JsonToken.BEGIN_OBJECT
            r10 = 0
            if (r1 != r2) goto L_0x000f
            r11 = 1
            goto L_0x0010
        L_0x000f:
            r11 = r10
        L_0x0010:
            if (r11 == 0) goto L_0x0015
            r28.beginObject()
        L_0x0015:
            r1 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r23 = 0
            r24 = 0
            r25 = 0
        L_0x0023:
            boolean r2 = r28.hasNext()
            if (r2 == 0) goto L_0x0196
            java.lang.String r2 = r28.nextName()
            r3 = -1
            int r4 = r2.hashCode()
            r5 = 97
            if (r4 == r5) goto L_0x00b8
            r5 = 3242(0xcaa, float:4.543E-42)
            if (r4 == r5) goto L_0x00ae
            r5 = 3656(0xe48, float:5.123E-42)
            if (r4 == r5) goto L_0x00a4
            r5 = 3662(0xe4e, float:5.132E-42)
            if (r4 == r5) goto L_0x0099
            r5 = 3672(0xe58, float:5.146E-42)
            if (r4 == r5) goto L_0x008e
            r5 = 3676(0xe5c, float:5.151E-42)
            if (r4 == r5) goto L_0x0084
            r5 = 111(0x6f, float:1.56E-43)
            if (r4 == r5) goto L_0x007a
            r5 = 112(0x70, float:1.57E-43)
            if (r4 == r5) goto L_0x0070
            r5 = 114(0x72, float:1.6E-43)
            if (r4 == r5) goto L_0x0066
            r5 = 115(0x73, float:1.61E-43)
            if (r4 == r5) goto L_0x005c
            goto L_0x00c2
        L_0x005c:
            java.lang.String r4 = "s"
            boolean r2 = r2.equals(r4)
            if (r2 == 0) goto L_0x00c2
            r2 = 2
            goto L_0x00c3
        L_0x0066:
            java.lang.String r4 = "r"
            boolean r2 = r2.equals(r4)
            if (r2 == 0) goto L_0x00c2
            r2 = 4
            goto L_0x00c3
        L_0x0070:
            java.lang.String r4 = "p"
            boolean r2 = r2.equals(r4)
            if (r2 == 0) goto L_0x00c2
            r2 = 1
            goto L_0x00c3
        L_0x007a:
            java.lang.String r4 = "o"
            boolean r2 = r2.equals(r4)
            if (r2 == 0) goto L_0x00c2
            r2 = 5
            goto L_0x00c3
        L_0x0084:
            java.lang.String r4 = "so"
            boolean r2 = r2.equals(r4)
            if (r2 == 0) goto L_0x00c2
            r2 = 6
            goto L_0x00c3
        L_0x008e:
            java.lang.String r4 = "sk"
            boolean r2 = r2.equals(r4)
            if (r2 == 0) goto L_0x00c2
            r2 = 8
            goto L_0x00c3
        L_0x0099:
            java.lang.String r4 = "sa"
            boolean r2 = r2.equals(r4)
            if (r2 == 0) goto L_0x00c2
            r2 = 9
            goto L_0x00c3
        L_0x00a4:
            java.lang.String r4 = "rz"
            boolean r2 = r2.equals(r4)
            if (r2 == 0) goto L_0x00c2
            r2 = 3
            goto L_0x00c3
        L_0x00ae:
            java.lang.String r4 = "eo"
            boolean r2 = r2.equals(r4)
            if (r2 == 0) goto L_0x00c2
            r2 = 7
            goto L_0x00c3
        L_0x00b8:
            java.lang.String r4 = "a"
            boolean r2 = r2.equals(r4)
            if (r2 == 0) goto L_0x00c2
            r2 = r10
            goto L_0x00c3
        L_0x00c2:
            r2 = r3
        L_0x00c3:
            switch(r2) {
                case 0: goto L_0x0173;
                case 1: goto L_0x016c;
                case 2: goto L_0x0165;
                case 3: goto L_0x015e;
                case 4: goto L_0x00f3;
                case 5: goto L_0x00eb;
                case 6: goto L_0x00e3;
                case 7: goto L_0x00db;
                case 8: goto L_0x00d3;
                case 9: goto L_0x00cb;
                default: goto L_0x00c6;
            }
        L_0x00c6:
            r28.skipValue()
            goto L_0x0023
        L_0x00cb:
            com.coloros.anim.c.a.b r2 = com.coloros.anim.e.d.a((android.util.JsonReader) r0, (com.coloros.anim.a) r8, (boolean) r10)
            r17 = r2
            goto L_0x0023
        L_0x00d3:
            com.coloros.anim.c.a.b r2 = com.coloros.anim.e.d.a((android.util.JsonReader) r0, (com.coloros.anim.a) r8, (boolean) r10)
            r16 = r2
            goto L_0x0023
        L_0x00db:
            com.coloros.anim.c.a.b r2 = com.coloros.anim.e.d.a((android.util.JsonReader) r0, (com.coloros.anim.a) r8, (boolean) r10)
            r25 = r2
            goto L_0x0023
        L_0x00e3:
            com.coloros.anim.c.a.b r2 = com.coloros.anim.e.d.a((android.util.JsonReader) r0, (com.coloros.anim.a) r8, (boolean) r10)
            r24 = r2
            goto L_0x0023
        L_0x00eb:
            com.coloros.anim.c.a.d r2 = com.coloros.anim.e.d.b(r28, r29)
            r23 = r2
            goto L_0x0023
        L_0x00f3:
            com.coloros.anim.c.a.b r18 = com.coloros.anim.e.d.a((android.util.JsonReader) r0, (com.coloros.anim.a) r8, (boolean) r10)
            java.util.List r1 = r18.c()
            boolean r1 = r1.isEmpty()
            r2 = 0
            if (r1 == 0) goto L_0x012b
            java.util.List r7 = r18.c()
            com.coloros.anim.g.c r6 = new com.coloros.anim.g.c
            java.lang.Float r3 = java.lang.Float.valueOf(r2)
            java.lang.Float r4 = java.lang.Float.valueOf(r2)
            r5 = 0
            r19 = 0
            float r1 = r29.g()
            java.lang.Float r20 = java.lang.Float.valueOf(r1)
            r1 = r6
            r2 = r29
            r9 = r6
            r6 = r19
            r12 = r7
            r7 = r20
            r1.<init>(r2, r3, r4, r5, r6, r7)
            r12.add(r9)
            goto L_0x015a
        L_0x012b:
            java.util.List r1 = r18.c()
            java.lang.Object r1 = r1.get(r10)
            com.coloros.anim.g.c r1 = (com.coloros.anim.g.c) r1
            T r1 = r1.f2479a
            if (r1 != 0) goto L_0x015a
            java.util.List r9 = r18.c()
            com.coloros.anim.g.c r12 = new com.coloros.anim.g.c
            java.lang.Float r3 = java.lang.Float.valueOf(r2)
            java.lang.Float r4 = java.lang.Float.valueOf(r2)
            r5 = 0
            r6 = 0
            float r1 = r29.g()
            java.lang.Float r7 = java.lang.Float.valueOf(r1)
            r1 = r12
            r2 = r29
            r1.<init>(r2, r3, r4, r5, r6, r7)
            r9.set(r10, r12)
        L_0x015a:
            r1 = r18
            goto L_0x0023
        L_0x015e:
            java.lang.String r2 = "EffectiveAnimation doesn't support 3D layers."
            r8.a((java.lang.String) r2)
            goto L_0x0023
        L_0x0165:
            com.coloros.anim.c.a.g r2 = com.coloros.anim.e.d.d(r28, r29)
            r15 = r2
            goto L_0x0023
        L_0x016c:
            com.coloros.anim.c.a.m r2 = com.coloros.anim.e.a.b(r28, r29)
            r14 = r2
            goto L_0x0023
        L_0x0173:
            r28.beginObject()
        L_0x0176:
            boolean r2 = r28.hasNext()
            if (r2 == 0) goto L_0x0191
            java.lang.String r2 = r28.nextName()
            java.lang.String r3 = "k"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x018d
            com.coloros.anim.c.a.e r13 = com.coloros.anim.e.a.a(r28, r29)
            goto L_0x0176
        L_0x018d:
            r28.skipValue()
            goto L_0x0176
        L_0x0191:
            r28.endObject()
            goto L_0x0023
        L_0x0196:
            if (r11 == 0) goto L_0x019b
            r28.endObject()
        L_0x019b:
            boolean r0 = a((com.coloros.anim.c.a.e) r13)
            if (r0 == 0) goto L_0x01a2
            r13 = 0
        L_0x01a2:
            boolean r0 = a((com.coloros.anim.c.a.m<android.graphics.PointF, android.graphics.PointF>) r14)
            if (r0 == 0) goto L_0x01ab
            r20 = 0
            goto L_0x01ad
        L_0x01ab:
            r20 = r14
        L_0x01ad:
            boolean r0 = a((com.coloros.anim.c.a.b) r1)
            if (r0 == 0) goto L_0x01b6
            r22 = 0
            goto L_0x01b8
        L_0x01b6:
            r22 = r1
        L_0x01b8:
            boolean r0 = a((com.coloros.anim.c.a.g) r15)
            if (r0 == 0) goto L_0x01c1
            r21 = 0
            goto L_0x01c3
        L_0x01c1:
            r21 = r15
        L_0x01c3:
            boolean r0 = b(r16)
            if (r0 == 0) goto L_0x01cc
            r26 = 0
            goto L_0x01ce
        L_0x01cc:
            r26 = r16
        L_0x01ce:
            boolean r0 = c(r17)
            if (r0 == 0) goto L_0x01d7
            r27 = 0
            goto L_0x01d9
        L_0x01d7:
            r27 = r17
        L_0x01d9:
            com.coloros.anim.c.a.l r0 = new com.coloros.anim.c.a.l
            r18 = r0
            r19 = r13
            r18.<init>(r19, r20, r21, r22, r23, r24, r25, r26, r27)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coloros.anim.e.c.a(android.util.JsonReader, com.coloros.anim.a):com.coloros.anim.c.a.l");
    }

    private static boolean a(e eVar) {
        return eVar == null || (eVar.b() && ((PointF) eVar.c().get(0).f2479a).equals(0.0f, 0.0f));
    }

    private static boolean a(m<PointF, PointF> mVar) {
        if (mVar == null || (!(mVar instanceof i) && mVar.b() && ((PointF) mVar.c().get(0).f2479a).equals(0.0f, 0.0f))) {
            return true;
        }
        return false;
    }

    private static boolean a(b bVar) {
        return bVar == null || (bVar.b() && ((Float) ((com.coloros.anim.g.c) bVar.c().get(0)).f2479a).floatValue() == 0.0f);
    }

    private static boolean a(g gVar) {
        return gVar == null || (gVar.b() && ((d) ((com.coloros.anim.g.c) gVar.c().get(0)).f2479a).b(1.0f, 1.0f));
    }

    private static boolean b(b bVar) {
        return bVar == null || (bVar.b() && ((Float) ((com.coloros.anim.g.c) bVar.c().get(0)).f2479a).floatValue() == 0.0f);
    }

    private static boolean c(b bVar) {
        return bVar == null || (bVar.b() && ((Float) ((com.coloros.anim.g.c) bVar.c().get(0)).f2479a).floatValue() == 0.0f);
    }
}
