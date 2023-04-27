package com.coloros.anim.e;

import android.util.JsonReader;
import android.util.LongSparseArray;
import androidx.collection.SparseArrayCompat;
import com.coloros.anim.a;
import com.coloros.anim.c.c.d;
import com.coloros.anim.c.e;
import com.coloros.anim.h;
import com.coloros.anim.k;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: EffectiveCompositionParser */
public class i {
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.coloros.anim.a a(android.util.JsonReader r27) throws java.io.IOException {
        /*
            r0 = r27
            float r12 = com.coloros.anim.f.g.a()
            android.util.LongSparseArray r6 = new android.util.LongSparseArray
            r6.<init>()
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            java.util.HashMap r7 = new java.util.HashMap
            r7.<init>()
            java.util.HashMap r8 = new java.util.HashMap
            r8.<init>()
            java.util.HashMap r10 = new java.util.HashMap
            r10.<init>()
            java.util.ArrayList r11 = new java.util.ArrayList
            r11.<init>()
            androidx.collection.SparseArrayCompat r9 = new androidx.collection.SparseArrayCompat
            r9.<init>()
            com.coloros.anim.a r13 = new com.coloros.anim.a
            r13.<init>()
            r27.beginObject()
            r1 = 0
            r4 = r1
            r14 = r4
            r15 = r14
            r1 = 0
            r3 = 0
        L_0x0037:
            boolean r16 = r27.hasNext()
            if (r16 == 0) goto L_0x019c
            java.lang.String r2 = r27.nextName()
            r17 = -1
            int r18 = r2.hashCode()
            r19 = 2
            r20 = 1
            switch(r18) {
                case -1408207997: goto L_0x00d2;
                case -1109732030: goto L_0x00c6;
                case 104: goto L_0x00b9;
                case 118: goto L_0x00ad;
                case 119: goto L_0x00a1;
                case 3276: goto L_0x0095;
                case 3367: goto L_0x0088;
                case 3553: goto L_0x007c;
                case 94623709: goto L_0x006e;
                case 97615364: goto L_0x0060;
                case 839250809: goto L_0x0052;
                default: goto L_0x004e;
            }
        L_0x004e:
            r18 = r15
            goto L_0x00de
        L_0x0052:
            r18 = r15
            java.lang.String r15 = "markers"
            boolean r2 = r2.equals(r15)
            if (r2 == 0) goto L_0x00de
            r2 = 10
            goto L_0x00e0
        L_0x0060:
            r18 = r15
            java.lang.String r15 = "fonts"
            boolean r2 = r2.equals(r15)
            if (r2 == 0) goto L_0x00de
            r2 = 8
            goto L_0x00e0
        L_0x006e:
            r18 = r15
            java.lang.String r15 = "chars"
            boolean r2 = r2.equals(r15)
            if (r2 == 0) goto L_0x00de
            r2 = 9
            goto L_0x00e0
        L_0x007c:
            r18 = r15
            java.lang.String r15 = "op"
            boolean r2 = r2.equals(r15)
            if (r2 == 0) goto L_0x00de
            r2 = 3
            goto L_0x00e0
        L_0x0088:
            r18 = r15
            java.lang.String r15 = "ip"
            boolean r2 = r2.equals(r15)
            if (r2 == 0) goto L_0x00de
            r2 = r19
            goto L_0x00e0
        L_0x0095:
            r18 = r15
            java.lang.String r15 = "fr"
            boolean r2 = r2.equals(r15)
            if (r2 == 0) goto L_0x00de
            r2 = 4
            goto L_0x00e0
        L_0x00a1:
            r18 = r15
            java.lang.String r15 = "w"
            boolean r2 = r2.equals(r15)
            if (r2 == 0) goto L_0x00de
            r2 = 0
            goto L_0x00e0
        L_0x00ad:
            r18 = r15
            java.lang.String r15 = "v"
            boolean r2 = r2.equals(r15)
            if (r2 == 0) goto L_0x00de
            r2 = 5
            goto L_0x00e0
        L_0x00b9:
            r18 = r15
            java.lang.String r15 = "h"
            boolean r2 = r2.equals(r15)
            if (r2 == 0) goto L_0x00de
            r2 = r20
            goto L_0x00e0
        L_0x00c6:
            r18 = r15
            java.lang.String r15 = "layers"
            boolean r2 = r2.equals(r15)
            if (r2 == 0) goto L_0x00de
            r2 = 6
            goto L_0x00e0
        L_0x00d2:
            r18 = r15
            java.lang.String r15 = "assets"
            boolean r2 = r2.equals(r15)
            if (r2 == 0) goto L_0x00de
            r2 = 7
            goto L_0x00e0
        L_0x00de:
            r2 = r17
        L_0x00e0:
            switch(r2) {
                case 0: goto L_0x018e;
                case 1: goto L_0x0185;
                case 2: goto L_0x017c;
                case 3: goto L_0x016e;
                case 4: goto L_0x0163;
                case 5: goto L_0x0131;
                case 6: goto L_0x0123;
                case 7: goto L_0x0115;
                case 8: goto L_0x0107;
                case 9: goto L_0x00f9;
                case 10: goto L_0x00eb;
                default: goto L_0x00e3;
            }
        L_0x00e3:
            r15 = r10
            r17 = r11
            r27.skipValue()
            goto L_0x0195
        L_0x00eb:
            java.lang.String r2 = "parseMarkers start!!!"
            com.coloros.anim.k.a(r2)
            a((android.util.JsonReader) r0, (com.coloros.anim.a) r13, (java.util.List<com.coloros.anim.c.h>) r11)
            java.lang.String r2 = "parseMarkers end!!!"
            com.coloros.anim.k.a(r2)
            goto L_0x015f
        L_0x00f9:
            java.lang.String r2 = "parseChars start!!!"
            com.coloros.anim.k.a(r2)
            a((android.util.JsonReader) r0, (com.coloros.anim.a) r13, (androidx.collection.SparseArrayCompat<com.coloros.anim.c.e>) r9)
            java.lang.String r2 = "parseChars end!!!"
            com.coloros.anim.k.a(r2)
            goto L_0x015f
        L_0x0107:
            java.lang.String r2 = "parseFonts start!!!"
            com.coloros.anim.k.a(r2)
            a(r0, r10)
            java.lang.String r2 = "parseFonts end!!!"
            com.coloros.anim.k.a(r2)
            goto L_0x015f
        L_0x0115:
            java.lang.String r2 = "parseAssets start!!!"
            com.coloros.anim.k.a(r2)
            a((android.util.JsonReader) r0, (com.coloros.anim.a) r13, (java.util.Map<java.lang.String, java.util.List<com.coloros.anim.c.c.d>>) r7, (java.util.Map<java.lang.String, com.coloros.anim.h>) r8)
            java.lang.String r2 = "parseAssets end!!!"
            com.coloros.anim.k.a(r2)
            goto L_0x015f
        L_0x0123:
            java.lang.String r2 = "parseLayers start!!!"
            com.coloros.anim.k.a(r2)
            a((android.util.JsonReader) r0, (com.coloros.anim.a) r13, (java.util.List<com.coloros.anim.c.c.d>) r5, (android.util.LongSparseArray<com.coloros.anim.c.c.d>) r6)
            java.lang.String r2 = "parseLayers end!!!"
            com.coloros.anim.k.a(r2)
            goto L_0x015f
        L_0x0131:
            java.lang.String r2 = r27.nextString()
            java.lang.String r15 = "\\."
            java.lang.String[] r2 = r2.split(r15)
            r15 = 0
            r17 = r2[r15]
            int r21 = java.lang.Integer.parseInt(r17)
            r15 = r2[r20]
            int r22 = java.lang.Integer.parseInt(r15)
            r2 = r2[r19]
            int r23 = java.lang.Integer.parseInt(r2)
            r24 = 4
            r25 = 4
            r26 = 0
            boolean r2 = com.coloros.anim.f.g.a(r21, r22, r23, r24, r25, r26)
            if (r2 != 0) goto L_0x015f
            java.lang.String r2 = "EffectiveAnimation only supports bodymovin >= 4.4.0"
            r13.a((java.lang.String) r2)
        L_0x015f:
            r15 = r10
            r17 = r11
            goto L_0x0195
        L_0x0163:
            r15 = r10
            r17 = r11
            double r10 = r27.nextDouble()
            float r2 = (float) r10
            r18 = r2
            goto L_0x0195
        L_0x016e:
            r15 = r10
            r17 = r11
            double r10 = r27.nextDouble()
            float r2 = (float) r10
            r10 = 1008981770(0x3c23d70a, float:0.01)
            float r14 = r2 - r10
            goto L_0x0195
        L_0x017c:
            r15 = r10
            r17 = r11
            double r10 = r27.nextDouble()
            float r4 = (float) r10
            goto L_0x0195
        L_0x0185:
            r15 = r10
            r17 = r11
            int r2 = r27.nextInt()
            r3 = r2
            goto L_0x0195
        L_0x018e:
            r15 = r10
            r17 = r11
            int r1 = r27.nextInt()
        L_0x0195:
            r10 = r15
            r11 = r17
            r15 = r18
            goto L_0x0037
        L_0x019c:
            r17 = r11
            r18 = r15
            r15 = r10
            r27.endObject()
            float r0 = (float) r1
            float r0 = r0 * r12
            int r0 = (int) r0
            float r1 = (float) r3
            float r1 = r1 * r12
            int r1 = (int) r1
            android.graphics.Rect r2 = new android.graphics.Rect
            r3 = 0
            r2.<init>(r3, r3, r0, r1)
            r0 = r13
            r1 = r2
            r2 = r4
            r3 = r14
            r4 = r18
            r0.a(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            java.lang.String r0 = "CompositionParser::parse end!!!"
            com.coloros.anim.k.a(r0)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coloros.anim.e.i.a(android.util.JsonReader):com.coloros.anim.a");
    }

    private static void a(JsonReader jsonReader, a aVar, List<d> list, LongSparseArray<d> longSparseArray) throws IOException {
        jsonReader.beginArray();
        int i = 0;
        while (jsonReader.hasNext()) {
            d a2 = t.a(jsonReader, aVar);
            if (a2.k() == d.a.IMAGE) {
                i++;
            }
            list.add(a2);
            longSparseArray.put(a2.e(), a2);
            if (i > 4) {
                k.b("You have " + i + " images. EffectiveAnimation should primarily be " + "used with shapes. If you are using Adobe Illustrator, convert the Illustrator layers" + " to shape layers.");
            }
        }
        jsonReader.endArray();
    }

    private static void a(JsonReader jsonReader, a aVar, Map<String, List<d>> map, Map<String, h> map2) throws IOException {
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            ArrayList arrayList = new ArrayList();
            LongSparseArray longSparseArray = new LongSparseArray();
            jsonReader.beginObject();
            String str = null;
            String str2 = null;
            String str3 = null;
            int i = 0;
            int i2 = 0;
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                char c = 65535;
                int hashCode = nextName.hashCode();
                if (hashCode != -1109732030) {
                    if (hashCode != 104) {
                        if (hashCode != 112) {
                            if (hashCode != 117) {
                                if (hashCode != 119) {
                                    if (hashCode == 3355 && nextName.equals("id")) {
                                        c = 0;
                                    }
                                } else if (nextName.equals("w")) {
                                    c = 2;
                                }
                            } else if (nextName.equals("u")) {
                                c = 5;
                            }
                        } else if (nextName.equals("p")) {
                            c = 4;
                        }
                    } else if (nextName.equals("h")) {
                        c = 3;
                    }
                } else if (nextName.equals("layers")) {
                    c = 1;
                }
                if (c == 0) {
                    str = jsonReader.nextString();
                } else if (c == 1) {
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        d a2 = t.a(jsonReader, aVar);
                        longSparseArray.put(a2.e(), a2);
                        arrayList.add(a2);
                    }
                    jsonReader.endArray();
                } else if (c == 2) {
                    i = jsonReader.nextInt();
                } else if (c == 3) {
                    i2 = jsonReader.nextInt();
                } else if (c == 4) {
                    str2 = jsonReader.nextString();
                } else if (c != 5) {
                    jsonReader.skipValue();
                } else {
                    str3 = jsonReader.nextString();
                }
            }
            jsonReader.endObject();
            if (str2 != null) {
                h hVar = new h(i, i2, str, str2, str3);
                map2.put(hVar.a(), hVar);
                Map<String, List<d>> map3 = map;
            } else {
                Map<String, h> map4 = map2;
                map.put(str, arrayList);
            }
        }
        jsonReader.endArray();
    }

    private static void a(JsonReader jsonReader, Map<String, com.coloros.anim.c.d> map) throws IOException {
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c = 65535;
            if (nextName.hashCode() == 3322014 && nextName.equals("list")) {
                c = 0;
            }
            if (c != 0) {
                jsonReader.skipValue();
            } else {
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    com.coloros.anim.c.d a2 = l.a(jsonReader);
                    map.put(a2.b(), a2);
                }
                jsonReader.endArray();
            }
        }
        jsonReader.endObject();
    }

    private static void a(JsonReader jsonReader, a aVar, SparseArrayCompat<e> sparseArrayCompat) throws IOException {
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            e a2 = k.a(jsonReader, aVar);
            sparseArrayCompat.put(a2.hashCode(), a2);
        }
        jsonReader.endArray();
    }

    private static void a(JsonReader jsonReader, a aVar, List<com.coloros.anim.c.h> list) throws IOException {
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            String str = null;
            jsonReader.beginObject();
            float f = 0.0f;
            float f2 = 0.0f;
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                char c = 65535;
                int hashCode = nextName.hashCode();
                if (hashCode != 3178) {
                    if (hashCode != 3214) {
                        if (hashCode == 3705 && nextName.equals("tm")) {
                            c = 1;
                        }
                    } else if (nextName.equals("dr")) {
                        c = 2;
                    }
                } else if (nextName.equals("cm")) {
                    c = 0;
                }
                if (c == 0) {
                    str = jsonReader.nextString();
                } else if (c == 1) {
                    f = (float) jsonReader.nextDouble();
                } else if (c != 2) {
                    jsonReader.skipValue();
                } else {
                    f2 = (float) jsonReader.nextDouble();
                }
            }
            jsonReader.endObject();
            list.add(new com.coloros.anim.c.h(str, f, f2));
        }
        jsonReader.endArray();
    }
}
