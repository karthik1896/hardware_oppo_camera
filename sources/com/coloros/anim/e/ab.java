package com.coloros.anim.e;

import android.util.JsonReader;
import com.coloros.anim.a;
import com.coloros.anim.c.a.b;
import com.coloros.anim.c.a.l;
import com.coloros.anim.c.b.k;
import java.io.IOException;

/* compiled from: RepeaterParser */
class ab {
    static k a(JsonReader jsonReader, a aVar) throws IOException {
        boolean z = false;
        String str = null;
        b bVar = null;
        b bVar2 = null;
        l lVar = null;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c = 65535;
            int hashCode = nextName.hashCode();
            if (hashCode != 99) {
                if (hashCode != 111) {
                    if (hashCode != 3324) {
                        if (hashCode != 3519) {
                            if (hashCode == 3710 && nextName.equals("tr")) {
                                c = 3;
                            }
                        } else if (nextName.equals("nm")) {
                            c = 0;
                        }
                    } else if (nextName.equals("hd")) {
                        c = 4;
                    }
                } else if (nextName.equals("o")) {
                    c = 2;
                }
            } else if (nextName.equals("c")) {
                c = 1;
            }
            if (c == 0) {
                str = jsonReader.nextString();
            } else if (c == 1) {
                bVar = d.a(jsonReader, aVar, false);
            } else if (c == 2) {
                bVar2 = d.a(jsonReader, aVar, false);
            } else if (c == 3) {
                lVar = c.a(jsonReader, aVar);
            } else if (c != 4) {
                jsonReader.skipValue();
            } else {
                z = jsonReader.nextBoolean();
            }
        }
        return new k(str, bVar, bVar2, lVar, z);
    }
}
