package com.coloros.anim.e;

import android.graphics.PointF;
import android.util.JsonReader;
import com.coloros.anim.a;
import com.coloros.anim.c.a.b;
import com.coloros.anim.c.a.f;
import com.coloros.anim.c.a.m;
import com.coloros.anim.c.b.j;
import java.io.IOException;

/* compiled from: RectangleShapeParser */
class aa {
    static j a(JsonReader jsonReader, a aVar) throws IOException {
        boolean z = false;
        String str = null;
        m<PointF, PointF> mVar = null;
        f fVar = null;
        b bVar = null;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c = 65535;
            int hashCode = nextName.hashCode();
            if (hashCode != 112) {
                if (hashCode != 3324) {
                    if (hashCode != 3519) {
                        if (hashCode != 114) {
                            if (hashCode == 115 && nextName.equals("s")) {
                                c = 2;
                            }
                        } else if (nextName.equals("r")) {
                            c = 3;
                        }
                    } else if (nextName.equals("nm")) {
                        c = 0;
                    }
                } else if (nextName.equals("hd")) {
                    c = 4;
                }
            } else if (nextName.equals("p")) {
                c = 1;
            }
            if (c == 0) {
                str = jsonReader.nextString();
            } else if (c == 1) {
                mVar = a.b(jsonReader, aVar);
            } else if (c == 2) {
                fVar = d.c(jsonReader, aVar);
            } else if (c == 3) {
                bVar = d.a(jsonReader, aVar);
            } else if (c != 4) {
                jsonReader.skipValue();
            } else {
                z = jsonReader.nextBoolean();
            }
        }
        return new j(str, mVar, fVar, bVar, z);
    }
}
