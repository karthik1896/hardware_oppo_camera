package com.airbnb.lottie.f;

/* compiled from: GammaEvaluator */
public class b {
    private static float a(float f) {
        return f <= 0.0031308f ? f * 12.92f : (float) ((Math.pow((double) f, 0.4166666567325592d) * 1.0549999475479126d) - 0.054999999701976776d);
    }

    private static float b(float f) {
        return f <= 0.04045f ? f / 12.92f : (float) Math.pow((double) ((f + 0.055f) / 1.055f), 2.4000000953674316d);
    }

    public static int a(float f, int i, int i2) {
        if (i == i2) {
            return i;
        }
        float f2 = ((float) ((i >> 24) & 255)) / 255.0f;
        float b2 = b(((float) ((i >> 16) & 255)) / 255.0f);
        float b3 = b(((float) ((i >> 8) & 255)) / 255.0f);
        float b4 = b(((float) (i & 255)) / 255.0f);
        float b5 = b(((float) ((i2 >> 16) & 255)) / 255.0f);
        float b6 = b(((float) ((i2 >> 8) & 255)) / 255.0f);
        float b7 = b4 + (f * (b(((float) (i2 & 255)) / 255.0f) - b4));
        return (Math.round(a(b2 + ((b5 - b2) * f)) * 255.0f) << 16) | (Math.round((f2 + (((((float) ((i2 >> 24) & 255)) / 255.0f) - f2) * f)) * 255.0f) << 24) | (Math.round(a(b3 + ((b6 - b3) * f)) * 255.0f) << 8) | Math.round(a(b7) * 255.0f);
    }
}
