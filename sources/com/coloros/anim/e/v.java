package com.coloros.anim.e;

import android.util.JsonReader;
import com.coloros.anim.c.b.h;
import java.io.IOException;

/* compiled from: MergePathsParser */
class v {
    static h a(JsonReader jsonReader) throws IOException {
        String str = null;
        boolean z = false;
        h.a aVar = null;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c = 65535;
            int hashCode = nextName.hashCode();
            if (hashCode != 3324) {
                if (hashCode != 3488) {
                    if (hashCode == 3519 && nextName.equals("nm")) {
                        c = 0;
                    }
                } else if (nextName.equals("mm")) {
                    c = 1;
                }
            } else if (nextName.equals("hd")) {
                c = 2;
            }
            if (c == 0) {
                str = jsonReader.nextString();
            } else if (c == 1) {
                aVar = h.a.forId(jsonReader.nextInt());
            } else if (c != 2) {
                jsonReader.skipValue();
            } else {
                z = jsonReader.nextBoolean();
            }
        }
        return new h(str, aVar, z);
    }
}
