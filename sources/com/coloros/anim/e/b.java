package com.coloros.anim.e;

import android.util.JsonReader;
import com.coloros.anim.a;
import com.coloros.anim.c.a.k;
import java.io.IOException;

/* compiled from: AnimatableTextPropertiesParser */
public class b {
    public static k a(JsonReader jsonReader, a aVar) throws IOException {
        jsonReader.beginObject();
        k kVar = null;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c = 65535;
            if (nextName.hashCode() == 97 && nextName.equals("a")) {
                c = 0;
            }
            if (c != 0) {
                jsonReader.skipValue();
            } else {
                kVar = b(jsonReader, aVar);
            }
        }
        jsonReader.endObject();
        return kVar == null ? new k((com.coloros.anim.c.a.a) null, (com.coloros.anim.c.a.a) null, (com.coloros.anim.c.a.b) null, (com.coloros.anim.c.a.b) null) : kVar;
    }

    private static k b(JsonReader jsonReader, a aVar) throws IOException {
        jsonReader.beginObject();
        com.coloros.anim.c.a.a aVar2 = null;
        com.coloros.anim.c.a.a aVar3 = null;
        com.coloros.anim.c.a.b bVar = null;
        com.coloros.anim.c.a.b bVar2 = null;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c = 65535;
            int hashCode = nextName.hashCode();
            if (hashCode != 116) {
                if (hashCode != 3261) {
                    if (hashCode != 3664) {
                        if (hashCode == 3684 && nextName.equals("sw")) {
                            c = 2;
                        }
                    } else if (nextName.equals("sc")) {
                        c = 1;
                    }
                } else if (nextName.equals("fc")) {
                    c = 0;
                }
            } else if (nextName.equals("t")) {
                c = 3;
            }
            if (c == 0) {
                aVar2 = d.g(jsonReader, aVar);
            } else if (c == 1) {
                aVar3 = d.g(jsonReader, aVar);
            } else if (c == 2) {
                bVar = d.a(jsonReader, aVar);
            } else if (c != 3) {
                jsonReader.skipValue();
            } else {
                bVar2 = d.a(jsonReader, aVar);
            }
        }
        jsonReader.endObject();
        return new k(aVar2, aVar3, bVar, bVar2);
    }
}
