package com.coloros.anim.e;

import android.graphics.PointF;
import android.util.JsonReader;
import android.util.JsonToken;
import com.coloros.anim.c.a;
import com.coloros.anim.c.b.l;
import com.coloros.anim.f.f;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: ShapeDataParser */
public class ad implements aj<l> {

    /* renamed from: a  reason: collision with root package name */
    public static final ad f2435a = new ad();

    private ad() {
    }

    /* renamed from: a */
    public l b(JsonReader jsonReader, float f) throws IOException {
        if (jsonReader.peek() == JsonToken.BEGIN_ARRAY) {
            jsonReader.beginArray();
        }
        jsonReader.beginObject();
        List<PointF> list = null;
        List<PointF> list2 = null;
        List<PointF> list3 = null;
        boolean z = false;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c = 65535;
            int hashCode = nextName.hashCode();
            if (hashCode != 99) {
                if (hashCode != 105) {
                    if (hashCode != 111) {
                        if (hashCode == 118 && nextName.equals("v")) {
                            c = 1;
                        }
                    } else if (nextName.equals("o")) {
                        c = 3;
                    }
                } else if (nextName.equals("i")) {
                    c = 2;
                }
            } else if (nextName.equals("c")) {
                c = 0;
            }
            if (c == 0) {
                z = jsonReader.nextBoolean();
            } else if (c == 1) {
                list = q.a(jsonReader, f);
            } else if (c == 2) {
                list2 = q.a(jsonReader, f);
            } else if (c == 3) {
                list3 = q.a(jsonReader, f);
            }
        }
        jsonReader.endObject();
        if (jsonReader.peek() == JsonToken.END_ARRAY) {
            jsonReader.endArray();
        }
        if (list == null || list2 == null || list3 == null) {
            throw new IllegalArgumentException("Shape data was missing information.");
        } else if (list.isEmpty()) {
            return new l(new PointF(), false, Collections.emptyList());
        } else {
            int size = list.size();
            PointF pointF = list.get(0);
            ArrayList arrayList = new ArrayList(size);
            for (int i = 1; i < size; i++) {
                PointF pointF2 = list.get(i);
                int i2 = i - 1;
                arrayList.add(new a(f.a(list.get(i2), list3.get(i2)), f.a(pointF2, list2.get(i)), pointF2));
            }
            if (z) {
                PointF pointF3 = list.get(0);
                int i3 = size - 1;
                arrayList.add(new a(f.a(list.get(i3), list3.get(i3)), f.a(pointF3, list2.get(0)), pointF3));
            }
            return new l(pointF, z, arrayList);
        }
    }
}
