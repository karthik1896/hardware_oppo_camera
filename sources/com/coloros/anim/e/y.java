package com.coloros.anim.e;

import android.graphics.PointF;
import android.util.JsonReader;
import android.util.JsonToken;
import java.io.IOException;

/* compiled from: PointFParser */
public class y implements aj<PointF> {

    /* renamed from: a  reason: collision with root package name */
    public static final y f2445a = new y();

    private y() {
    }

    /* renamed from: a */
    public PointF b(JsonReader jsonReader, float f) throws IOException {
        JsonToken peek = jsonReader.peek();
        if (peek == JsonToken.BEGIN_ARRAY) {
            return q.b(jsonReader, f);
        }
        if (peek == JsonToken.BEGIN_OBJECT) {
            return q.b(jsonReader, f);
        }
        if (peek == JsonToken.NUMBER) {
            PointF pointF = new PointF(((float) jsonReader.nextDouble()) * f, ((float) jsonReader.nextDouble()) * f);
            while (jsonReader.hasNext()) {
                jsonReader.skipValue();
            }
            return pointF;
        }
        throw new IllegalArgumentException("Cannot convert json to point. Next token is " + peek);
    }
}
