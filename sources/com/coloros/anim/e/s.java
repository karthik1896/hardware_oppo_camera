package com.coloros.anim.e;

import android.util.JsonReader;
import android.util.JsonToken;
import com.coloros.anim.a;
import com.coloros.anim.a.b.h;
import com.coloros.anim.g.c;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* compiled from: KeyframesParser */
class s {
    static <T> List<c<T>> a(JsonReader jsonReader, a aVar, float f, aj<T> ajVar) throws IOException {
        ArrayList arrayList = new ArrayList();
        if (jsonReader.peek() == JsonToken.STRING) {
            aVar.a("EffectiveAnimation doesn't support expressions.");
            return arrayList;
        }
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c = 65535;
            if (nextName.hashCode() == 107 && nextName.equals("k")) {
                c = 0;
            }
            if (c != 0) {
                jsonReader.skipValue();
            } else if (jsonReader.peek() == JsonToken.BEGIN_ARRAY) {
                jsonReader.beginArray();
                if (jsonReader.peek() == JsonToken.NUMBER) {
                    arrayList.add(r.a(jsonReader, aVar, f, ajVar, false));
                } else {
                    while (jsonReader.hasNext()) {
                        arrayList.add(r.a(jsonReader, aVar, f, ajVar, true));
                    }
                }
                jsonReader.endArray();
            } else {
                arrayList.add(r.a(jsonReader, aVar, f, ajVar, false));
            }
        }
        jsonReader.endObject();
        a(arrayList);
        return arrayList;
    }

    public static <T> void a(List<? extends c<T>> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        while (true) {
            i = size - 1;
            if (i2 >= i) {
                break;
            }
            c cVar = (c) list.get(i2);
            i2++;
            c cVar2 = (c) list.get(i2);
            cVar.e = Float.valueOf(cVar2.c);
            if (cVar.d == null && cVar2.f2479a != null) {
                cVar.d = cVar2.f2479a;
                if (cVar instanceof h) {
                    ((h) cVar).a();
                }
            }
        }
        c cVar3 = (c) list.get(i);
        if ((cVar3.f2479a == null || cVar3.d == null) && list.size() > 1) {
            list.remove(cVar3);
        }
    }
}
