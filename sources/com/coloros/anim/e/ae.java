package com.coloros.anim.e;

import android.graphics.Path;
import android.util.JsonReader;
import com.coloros.anim.a;
import com.coloros.anim.c.a.d;
import com.coloros.anim.c.b.m;
import java.io.IOException;

/* compiled from: ShapeFillParser */
class ae {
    static m a(JsonReader jsonReader, a aVar) throws IOException {
        boolean z = false;
        boolean z2 = false;
        String str = null;
        com.coloros.anim.c.a.a aVar2 = null;
        d dVar = null;
        int i = 1;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c = 65535;
            int hashCode = nextName.hashCode();
            if (hashCode != -396065730) {
                if (hashCode != 99) {
                    if (hashCode != 111) {
                        if (hashCode != 114) {
                            if (hashCode != 3324) {
                                if (hashCode == 3519 && nextName.equals("nm")) {
                                    c = 0;
                                }
                            } else if (nextName.equals("hd")) {
                                c = 5;
                            }
                        } else if (nextName.equals("r")) {
                            c = 4;
                        }
                    } else if (nextName.equals("o")) {
                        c = 2;
                    }
                } else if (nextName.equals("c")) {
                    c = 1;
                }
            } else if (nextName.equals("fillEnabled")) {
                c = 3;
            }
            if (c == 0) {
                str = jsonReader.nextString();
            } else if (c == 1) {
                aVar2 = d.g(jsonReader, aVar);
            } else if (c == 2) {
                dVar = d.b(jsonReader, aVar);
            } else if (c == 3) {
                z = jsonReader.nextBoolean();
            } else if (c == 4) {
                i = jsonReader.nextInt();
            } else if (c != 5) {
                jsonReader.skipValue();
            } else {
                z2 = jsonReader.nextBoolean();
            }
        }
        return new m(str, z, i == 1 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD, aVar2, dVar, z2);
    }
}
