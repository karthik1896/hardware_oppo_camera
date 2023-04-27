package com.coloros.anim.e;

import android.graphics.PointF;
import android.util.JsonReader;
import android.util.JsonToken;
import com.coloros.anim.c.a.b;
import com.coloros.anim.c.a.e;
import com.coloros.anim.c.a.i;
import com.coloros.anim.c.a.m;
import com.coloros.anim.f.g;
import com.coloros.anim.g.c;
import java.io.IOException;
import java.util.ArrayList;

/* compiled from: AnimatablePathValueParser */
public class a {
    public static e a(JsonReader jsonReader, com.coloros.anim.a aVar) throws IOException {
        ArrayList arrayList = new ArrayList();
        if (jsonReader.peek() == JsonToken.BEGIN_ARRAY) {
            jsonReader.beginArray();
            while (jsonReader.hasNext()) {
                arrayList.add(w.a(jsonReader, aVar));
            }
            jsonReader.endArray();
            s.a(arrayList);
        } else {
            arrayList.add(new c(q.b(jsonReader, g.a())));
        }
        return new e(arrayList);
    }

    static m<PointF, PointF> b(JsonReader jsonReader, com.coloros.anim.a aVar) throws IOException {
        jsonReader.beginObject();
        e eVar = null;
        b bVar = null;
        b bVar2 = null;
        boolean z = false;
        while (jsonReader.peek() != JsonToken.END_OBJECT) {
            String nextName = jsonReader.nextName();
            char c = 65535;
            int hashCode = nextName.hashCode();
            if (hashCode != 107) {
                if (hashCode != 120) {
                    if (hashCode == 121 && nextName.equals("y")) {
                        c = 2;
                    }
                } else if (nextName.equals("x")) {
                    c = 1;
                }
            } else if (nextName.equals("k")) {
                c = 0;
            }
            if (c != 0) {
                if (c != 1) {
                    if (c != 2) {
                        jsonReader.skipValue();
                    } else if (jsonReader.peek() == JsonToken.STRING) {
                        jsonReader.skipValue();
                    } else {
                        bVar2 = d.a(jsonReader, aVar);
                    }
                } else if (jsonReader.peek() == JsonToken.STRING) {
                    jsonReader.skipValue();
                } else {
                    bVar = d.a(jsonReader, aVar);
                }
                z = true;
            } else {
                eVar = a(jsonReader, aVar);
            }
        }
        jsonReader.endObject();
        if (z) {
            aVar.a("EffectiveAnimation doesn't support expressions.");
        }
        if (eVar != null) {
            return eVar;
        }
        return new i(bVar, bVar2);
    }
}
