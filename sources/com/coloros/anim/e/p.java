package com.coloros.anim.e;

import android.util.JsonReader;
import java.io.IOException;

/* compiled from: IntegerParser */
public class p implements aj<Integer> {

    /* renamed from: a  reason: collision with root package name */
    public static final p f2440a = new p();

    private p() {
    }

    /* renamed from: a */
    public Integer b(JsonReader jsonReader, float f) throws IOException {
        return Integer.valueOf(Math.round(q.b(jsonReader) * f));
    }
}
