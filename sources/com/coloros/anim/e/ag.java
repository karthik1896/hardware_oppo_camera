package com.coloros.anim.e;

import android.util.JsonReader;
import com.coloros.anim.a;
import com.coloros.anim.c.a.h;
import com.coloros.anim.c.b.o;
import java.io.IOException;

/* compiled from: ShapePathParser */
class ag {
    static o a(JsonReader jsonReader, a aVar) throws IOException {
        String str = null;
        h hVar = null;
        int i = 0;
        boolean z = false;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c = 65535;
            int hashCode = nextName.hashCode();
            if (hashCode != 3324) {
                if (hashCode != 3432) {
                    if (hashCode != 3519) {
                        if (hashCode == 104415 && nextName.equals("ind")) {
                            c = 1;
                        }
                    } else if (nextName.equals("nm")) {
                        c = 0;
                    }
                } else if (nextName.equals("ks")) {
                    c = 2;
                }
            } else if (nextName.equals("hd")) {
                c = 3;
            }
            if (c == 0) {
                str = jsonReader.nextString();
            } else if (c == 1) {
                i = jsonReader.nextInt();
            } else if (c == 2) {
                hVar = d.e(jsonReader, aVar);
            } else if (c != 3) {
                jsonReader.skipValue();
            } else {
                z = jsonReader.nextBoolean();
            }
        }
        return new o(str, i, hVar, z);
    }
}
