package com.coloros.anim.e;

import android.util.JsonReader;
import com.coloros.anim.a;
import com.coloros.anim.c.b.b;
import com.coloros.anim.c.b.n;
import java.io.IOException;
import java.util.ArrayList;

/* compiled from: ShapeGroupParser */
class af {
    static n a(JsonReader jsonReader, a aVar) throws IOException {
        ArrayList arrayList = new ArrayList();
        String str = null;
        boolean z = false;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c = 65535;
            int hashCode = nextName.hashCode();
            if (hashCode != 3324) {
                if (hashCode != 3371) {
                    if (hashCode == 3519 && nextName.equals("nm")) {
                        c = 0;
                    }
                } else if (nextName.equals("it")) {
                    c = 2;
                }
            } else if (nextName.equals("hd")) {
                c = 1;
            }
            if (c == 0) {
                str = jsonReader.nextString();
            } else if (c == 1) {
                z = jsonReader.nextBoolean();
            } else if (c != 2) {
                jsonReader.skipValue();
            } else {
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    b a2 = g.a(jsonReader, aVar);
                    if (a2 != null) {
                        arrayList.add(a2);
                    }
                }
                jsonReader.endArray();
            }
        }
        return new n(str, arrayList, z);
    }
}
