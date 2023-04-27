package com.coloros.anim.e;

import android.util.JsonReader;
import java.io.IOException;

/* compiled from: FloatParser */
public class j implements aj<Float> {

    /* renamed from: a  reason: collision with root package name */
    public static final j f2438a = new j();

    private j() {
    }

    /* renamed from: a */
    public Float b(JsonReader jsonReader, float f) throws IOException {
        return Float.valueOf(q.b(jsonReader) * f);
    }
}
