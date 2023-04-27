package com.coloros.anim.e;

import android.util.JsonReader;
import android.util.JsonToken;
import com.coloros.anim.a;
import com.coloros.anim.a.b.h;
import com.coloros.anim.f.g;
import java.io.IOException;

/* compiled from: PathKeyframeParser */
class w {
    static h a(JsonReader jsonReader, a aVar) throws IOException {
        return new h(aVar, r.a(jsonReader, aVar, g.a(), x.f2444a, jsonReader.peek() == JsonToken.BEGIN_OBJECT));
    }
}
