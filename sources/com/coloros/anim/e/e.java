package com.coloros.anim.e;

import android.graphics.PointF;
import android.util.JsonReader;
import com.coloros.anim.c.a.f;
import com.coloros.anim.c.a.m;
import com.coloros.anim.c.b.a;
import java.io.IOException;

/* compiled from: CircleShapeParser */
class e {
    static a a(JsonReader jsonReader, com.coloros.anim.a aVar, int i) throws IOException {
        boolean z = i == 3;
        boolean z2 = false;
        String str = null;
        m<PointF, PointF> mVar = null;
        f fVar = null;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c = 65535;
            int hashCode = nextName.hashCode();
            if (hashCode != 100) {
                if (hashCode != 112) {
                    if (hashCode != 115) {
                        if (hashCode != 3324) {
                            if (hashCode == 3519 && nextName.equals("nm")) {
                                c = 0;
                            }
                        } else if (nextName.equals("hd")) {
                            c = 3;
                        }
                    } else if (nextName.equals("s")) {
                        c = 2;
                    }
                } else if (nextName.equals("p")) {
                    c = 1;
                }
            } else if (nextName.equals("d")) {
                c = 4;
            }
            if (c == 0) {
                str = jsonReader.nextString();
            } else if (c == 1) {
                mVar = a.b(jsonReader, aVar);
            } else if (c == 2) {
                fVar = d.c(jsonReader, aVar);
            } else if (c == 3) {
                z2 = jsonReader.nextBoolean();
            } else if (c != 4) {
                jsonReader.skipValue();
            } else {
                z = jsonReader.nextInt() == 3;
            }
        }
        return new a(str, mVar, fVar, z, z2);
    }
}
